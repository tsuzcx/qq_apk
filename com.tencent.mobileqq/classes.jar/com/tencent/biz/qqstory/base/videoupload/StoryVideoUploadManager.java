package com.tencent.biz.qqstory.base.videoupload;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTaskManager;
import com.tencent.biz.qqstory.base.videoupload.task.BaseTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.boundaries.StoryDepends.ShortVideoMultiSender;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.network.request.AddGroupVideoRequest;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse.AddGroupFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.MonitorReport;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class StoryVideoUploadManager
  extends BasePublishTaskManager<StoryVideoTaskInfo>
  implements IEventReceiver
{
  private StoryVideoUploadManager.VideoCompositeRec jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadManager$VideoCompositeRec;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static int a()
  {
    try
    {
      EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
      StoryVideoUploadManager localStoryVideoUploadManager = (StoryVideoUploadManager)SuperManager.a(3);
      List localList = localEntityManager.query(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, "createTime ASC", null, null);
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)localIterator.next();
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo detail info:%s", new Object[] { localPublishVideoEntry });
          localPublishVideoEntry.publishState = 0;
          localEntityManager.update(localPublishVideoEntry);
          localStoryVideoUploadManager.a(localPublishVideoEntry);
        }
        int i = localList.size();
        return i;
      }
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: 0");
      return 0;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      StoryVideoUploadProgressManager.a().a();
    }
    StoryVideoTaskInfo localStoryVideoTaskInfo = new StoryVideoTaskInfo(paramPublishVideoEntry);
    super.b(localStoryVideoTaskInfo);
    StoryVideoUploadProgressManager.a().a(paramPublishVideoEntry.fakeVid, false);
    StoryVideoUploadManager.StoryVideoPublishStatusEvent localStoryVideoPublishStatusEvent = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(true);
    Object localObject1 = (StoryManager)SuperManager.a(5);
    Object localObject2 = localStoryVideoTaskInfo.a();
    localStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryManager)localObject1).a(localStoryVideoTaskInfo.a(), (StoryVideoItem)localObject2);
    localStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localStoryVideoTaskInfo.a();
    localObject1 = localStoryVideoTaskInfo.a();
    if ((localObject1 != null) && (((VideoSpreadGroupList)localObject1).jdField_b_of_type_JavaUtilList != null))
    {
      localStoryVideoPublishStatusEvent.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((VideoSpreadGroupList)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new StoryVideoUploadManager.ShareGroupFakeItem();
        ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = FeedManager.a((String)localObject3, localStoryVideoTaskInfo.a().mLocalDate);
        ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject3 = new StoryVideoUploadManager.OneVideoInfo();
        ((StoryVideoUploadManager.OneVideoInfo)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        localStoryVideoPublishStatusEvent.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    boolean bool1 = paramPublishVideoEntry.getBooleanExtra("is_hw_encode", false);
    boolean bool2 = paramPublishVideoEntry.isLocalPublish;
    if ((bool1) || (bool2))
    {
      int i = Math.min(paramPublishVideoEntry.videoHeight, paramPublishVideoEntry.videoWidth);
      int j = Math.max(paramPublishVideoEntry.videoHeight, paramPublishVideoEntry.videoWidth);
      paramPublishVideoEntry.videoWidth = i;
      paramPublishVideoEntry.videoHeight = j;
      if ((StoryConfigManager.c()) && (Build.VERSION.SDK_INT < 27)) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (StoryConfigManager.d()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().a().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((EntityManager)localObject1).persistOrReplace(paramPublishVideoEntry);
    }
    ThreadManager.post(new StoryVideoUploadManager.4(this, localStoryVideoTaskInfo, localStoryVideoPublishStatusEvent), 8, new StoryVideoUploadManager.5(this, localStoryVideoTaskInfo), false);
  }
  
  public static void a(String paramString)
  {
    ((StoryVideoUploadManager)SuperManager.a().b(3)).c(paramString);
  }
  
  public static void a(@NonNull String paramString, @NonNull ArrayList<String> paramArrayList, int paramInt)
  {
    try
    {
      AssertUtils.checkNotEmpty(paramString);
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video %s: %s", new Object[] { paramString, paramArrayList });
      StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localStoryManager.a(str);
        paramArrayList = localStoryVideoItem;
        if (localStoryVideoItem == null)
        {
          paramArrayList = new StoryVideoItem();
          paramArrayList.mVid = str;
          paramArrayList.mOwnerUid = QQStoryContext.a().b();
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "vid:%s for storyVideoItem is null", new Object[] { str });
        }
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(paramArrayList);
        localStoryVideoItem.mVideoSource = 1;
        localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        localStoryVideoItem.shareGroupId = paramString;
        localStoryVideoItem.sourceVid = str;
        localStoryVideoItem.mPublishDate = FeedManager.a();
        localStoryVideoItem.mUploadStatus = 0;
        localStoryVideoItem.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
        localStoryVideoItem.mTimeZoneOffsetMillis = (UIUtils.a() * 1000);
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
        {
          paramArrayList = ((UserManager)SuperManager.a(2)).a();
          if (paramArrayList != null) {
            localStoryVideoItem.mOwnerName = paramArrayList.getDisplayName();
          }
        }
        localStoryManager.a(localStoryVideoItem.mVid, localStoryVideoItem);
        localArrayList.add(localStoryVideoItem);
      }
      a(paramString, localArrayList, paramInt);
      StoryDispatcher.a().dispatch(new StoryVideoUploadManager.CreateFakeVideoEvent());
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static void a(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry add shareGroup video %s: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
      a(paramString, paramList, 1);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static void a(String paramString, List<StoryVideoItem> paramList, int paramInt)
  {
    try
    {
      VideoListFeedItem localVideoListFeedItem = FeedManager.a(paramString, FeedManager.a());
      if ((localVideoListFeedItem != null) && (paramList != null) && (paramList.size() != 0))
      {
        StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
        Object localObject1 = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(true);
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_b_of_type_Boolean = false;
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        Object localObject2 = new StoryVideoUploadManager.ShareGroupFakeItem();
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = localVideoListFeedItem;
        Object localObject3 = paramList.iterator();
        Object localObject5;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new StoryVideoUploadManager.OneVideoInfo();
          ((StoryVideoUploadManager.OneVideoInfo)localObject5).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localStoryManager.a((StoryVideoItem)localObject4);
          ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject5);
        }
        StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
        localObject1 = new ArrayList(paramList.size());
        localObject2 = new ArrayList(paramList.size());
        localObject3 = new ArrayList(paramList.size());
        Object localObject4 = paramList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (StoryVideoItem)((Iterator)localObject4).next();
          ((ArrayList)localObject1).add(((StoryVideoItem)localObject5).sourceVid);
          ((ArrayList)localObject2).add(Long.valueOf(((StoryVideoItem)localObject5).mCreateTime));
          ((ArrayList)localObject3).add(Integer.valueOf((int)((StoryVideoItem)localObject5).mTimeZoneOffsetMillis / 1000));
        }
        paramString = new AddGroupVideoRequest(paramString, (List)localObject1, (List)localObject2, (List)localObject3, paramInt);
        CmdTaskManger.a().a(paramString, new StoryVideoUploadManager.2(localVideoListFeedItem, paramList, localStoryManager));
        return;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static void a(List<StoryVideoItem> paramList, Activity paramActivity)
  {
    if (!NetworkUtil.isNetworkAvailable(paramActivity))
    {
      QQToast.a(paramActivity, 1, HardCodeUtil.a(2131714361), 0).a();
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
      if (!TextUtils.isEmpty(localStoryVideoItem.sourceVid))
      {
        localArrayList2.add(localStoryVideoItem);
      }
      else if (StoryVideoUploadManager.StoryVideoPublishStatusEvent.a(localStoryVideoItem.mUpLoadFailedError))
      {
        localArrayList1.add(localStoryVideoItem.mVid);
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video file not exist, vid:%s", new Object[] { localStoryVideoItem.mVid });
      }
      else
      {
        a(localStoryVideoItem, paramActivity);
      }
    }
    if (localArrayList2.size() > 0) {
      a(((StoryVideoItem)localArrayList2.get(0)).shareGroupId, localArrayList2);
    }
    if (localArrayList1.size() > 0)
    {
      if (paramActivity.isFinishing()) {
        return;
      }
      paramList = DialogUtil.a(paramActivity, 230);
      paramList.setTitle(HardCodeUtil.a(2131714362));
      paramList.setMessage(HardCodeUtil.a(2131714364));
      paramList.setPositiveButton(HardCodeUtil.a(2131714363), new StoryVideoUploadManager.1(localArrayList1));
      paramList.setCancelable(false);
      paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      paramList.show();
    }
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!NetworkUtil.isNetworkAvailable(paramContext))
    {
      QQToast.a(paramContext, 1, HardCodeUtil.a(2131714360), 0).a();
      return false;
    }
    ((StoryVideoUploadManager)SuperManager.a().b(3)).a(paramStoryVideoItem);
    return true;
  }
  
  public static void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" post createStoryVideo ... ");
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", localStringBuilder.toString());
    Bosses.get().postJob(new StoryVideoUploadManager.3("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString));
  }
  
  private void f()
  {
    SLog.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new StoryVideoUploadManager.7(this, "Q.qqstory.publish.upload:StoryVideoUploadManager"));
  }
  
  protected BasePublishTask a(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    return new StoryVideoUploadTask(paramStoryVideoTaskInfo);
  }
  
  public void a()
  {
    super.a();
    f();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadManager$VideoCompositeRec = new StoryVideoUploadManager.VideoCompositeRec(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadManager$VideoCompositeRec);
  }
  
  protected void a(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    boolean bool = b();
    Object localObject1 = "Q.qqstory.publish.upload:StoryVideoUploadManager";
    if (bool)
    {
      SLog.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
      return;
    }
    if (paramStoryVideoTaskInfo.a())
    {
      localObject2 = FileCacheUtils.a(paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString, paramStoryVideoTaskInfo.d, 0, false, false);
      if (FileUtils.b(paramStoryVideoTaskInfo.jdField_a_of_type_JavaLangString, (String)localObject2))
      {
        paramStoryVideoTaskInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject2 });
      }
      else
      {
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
      }
      localObject2 = FileCacheUtils.a(paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString, paramStoryVideoTaskInfo.d, 2, false, false);
      if (FileUtils.b(paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString, (String)localObject2))
      {
        paramStoryVideoTaskInfo.jdField_c_of_type_JavaLangString = paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString;
        paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString = ((String)localObject2);
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject2 });
      }
      else
      {
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
      }
      if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.e))
      {
        localObject2 = FileCacheUtils.a(paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString, paramStoryVideoTaskInfo.d, 6, false, false);
        if (FileUtils.b(paramStoryVideoTaskInfo.e, (String)localObject2))
        {
          paramStoryVideoTaskInfo.e = ((String)localObject2);
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject2 });
        }
        else
        {
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        }
      }
      if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.jdField_f_of_type_JavaLangString))
      {
        localObject2 = FileCacheUtils.a(paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString, paramStoryVideoTaskInfo.d, 6, false, false);
        if (FileUtils.b(paramStoryVideoTaskInfo.jdField_f_of_type_JavaLangString, (String)localObject2))
        {
          paramStoryVideoTaskInfo.jdField_f_of_type_JavaLangString = ((String)localObject2);
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject2 });
        }
        else
        {
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        }
      }
      if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.m))
      {
        localObject2 = FileCacheUtils.a(paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString, paramStoryVideoTaskInfo.d, 5, false, false);
        if (FileUtils.b(paramStoryVideoTaskInfo.m, (String)localObject2))
        {
          paramStoryVideoTaskInfo.m = ((String)localObject2);
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir %s", new Object[] { localObject2 });
        }
        else
        {
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir fail");
        }
      }
    }
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    Object localObject4 = (FeedManager)SuperManager.a(11);
    Object localObject2 = localStoryManager.a(paramStoryVideoTaskInfo.a(), paramStoryVideoTaskInfo.a());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("task state write:");
    ((StringBuilder)localObject3).append(localObject2);
    SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", ((StringBuilder)localObject3).toString());
    localObject3 = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(false);
    ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
    ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject2);
    ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = paramStoryVideoTaskInfo.a();
    Object localObject5 = paramStoryVideoTaskInfo.a();
    localObject2 = localObject1;
    Object localObject6;
    if (localObject5 != null)
    {
      localObject2 = localObject1;
      if (((VideoSpreadGroupList)localObject5).jdField_b_of_type_JavaUtilList != null)
      {
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject5 = ((VideoSpreadGroupList)localObject5).jdField_b_of_type_JavaUtilList.iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          Object localObject7 = (String)((Iterator)localObject5).next();
          localObject2 = new StoryVideoUploadManager.ShareGroupFakeItem();
          ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = FeedManager.a((String)localObject7, paramStoryVideoTaskInfo.a().mLocalDate);
          ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
          localObject6 = new StoryVideoUploadManager.OneVideoInfo();
          ((StoryVideoUploadManager.OneVideoInfo)localObject6).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
          if ((((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()) && (paramStoryVideoTaskInfo.jdField_b_of_type_JavaUtilList != null))
          {
            Object localObject8 = paramStoryVideoTaskInfo.jdField_b_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject8).hasNext())
            {
              AddGroupVideoResponse.AddGroupFeed localAddGroupFeed = (AddGroupVideoResponse.AddGroupFeed)((Iterator)localObject8).next();
              if (((String)localObject7).equals(localAddGroupFeed.jdField_a_of_type_JavaLangString))
              {
                if (((((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) && (((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(localAddGroupFeed.jdField_b_of_type_JavaLangString)))
                {
                  ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
                }
                else
                {
                  ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
                  ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
                  ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = localAddGroupFeed.jdField_b_of_type_JavaLangString;
                  AssertUtils.checkNotEmpty(localAddGroupFeed.jdField_b_of_type_JavaLangString);
                  ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((FeedManager)localObject4).a(((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem));
                }
                localObject7 = new StoryVideoItem();
                ((StoryVideoItem)localObject7).copy(((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
                ((StoryVideoItem)localObject7).mVid = ((String)localAddGroupFeed.jdField_a_of_type_JavaUtilMap.get(paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString));
                ((StoryVideoItem)localObject7).mVideoIndex = 0L;
                AssertUtils.checkNotEmpty(((StoryVideoItem)localObject7).mVid);
                ((StoryVideoUploadManager.OneVideoInfo)localObject6).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localStoryManager.a((StoryVideoItem)localObject7);
                ((FeedManager)localObject4).a(((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
                localObject8 = new ArrayList();
                ((ArrayList)localObject8).add(localObject7);
                ((FeedManager)localObject4).a(localAddGroupFeed.jdField_b_of_type_JavaLangString, (List)localObject8, false);
              }
            }
          }
          ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject6);
          ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        }
      }
    }
    int i;
    if ((paramStoryVideoTaskInfo.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      i = (int)(SystemClock.elapsedRealtime() - paramStoryVideoTaskInfo.jdField_a_of_type_Long);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(StoryReportor.b(paramStoryVideoTaskInfo.jdField_f_of_type_Int));
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramStoryVideoTaskInfo.jdField_b_of_type_Long);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(paramStoryVideoTaskInfo.jdField_g_of_type_Int);
      ((StringBuilder)localObject6).append("");
      StoryReportor.a("video_shoot_new", "time_upload", 0, i, new String[] { localObject1, localObject5, "", ((StringBuilder)localObject6).toString() });
    }
    if ((paramStoryVideoTaskInfo.jdField_a_of_type_Int == 5) || (paramStoryVideoTaskInfo.jdField_a_of_type_Int == 3) || (paramStoryVideoTaskInfo.jdField_a_of_type_Int == 6))
    {
      this.jdField_a_of_type_Boolean = false;
      i = (int)(SystemClock.elapsedRealtime() - paramStoryVideoTaskInfo.jdField_a_of_type_Long);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(StoryReportor.b(paramStoryVideoTaskInfo.jdField_f_of_type_Int));
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramStoryVideoTaskInfo.jdField_b_of_type_Long);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(paramStoryVideoTaskInfo.jdField_g_of_type_Int);
      ((StringBuilder)localObject6).append("");
      StoryReportor.a("video_shoot_new", "time_publish", 0, i, new String[] { localObject1, localObject5, "", ((StringBuilder)localObject6).toString() });
    }
    long l;
    if (((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
    {
      ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoTaskInfo.a();
      ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid = paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString;
      ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localStoryManager.a(paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString, ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      if (((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_b_of_type_Boolean)
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((FeedManager)localObject4).a(((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId, (List)localObject1, false);
      }
      if (paramStoryVideoTaskInfo.jdField_b_of_type_Int > 0) {
        StoryReportor.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString });
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramStoryVideoTaskInfo.a());
      ((StringBuilder)localObject1).append("##:");
      localObject1 = ((StringBuilder)localObject1).toString();
      l = SystemClock.elapsedRealtime() - paramStoryVideoTaskInfo.jdField_a_of_type_Long;
      StoryReportor.b("publish_story", "publish_all", 0, 0, new String[] { localObject1, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()), String.valueOf(paramStoryVideoTaskInfo.jdField_b_of_type_Int) });
      StoryReportor.b("publish_story", "publish_all_old", 0, 0, new String[] { localObject1, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()), String.valueOf(paramStoryVideoTaskInfo.jdField_b_of_type_Int) });
      localObject1 = paramStoryVideoTaskInfo.a();
      bool = ((PublishVideoEntry)localObject1).getBooleanExtra("useFlowDecode", false);
      StoryReportor.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject1).saveMode, 0, new String[] { String.valueOf(bool), "", paramStoryVideoTaskInfo.h });
      MonitorReport.a(2444494, null);
      SLog.a((String)localObject2, "publish vid:%s success take time:%d", paramStoryVideoTaskInfo.a(), Long.valueOf(l));
      VideoCompositeHelper.a(paramStoryVideoTaskInfo.a());
    }
    if (((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail())
    {
      StoryDispatcher.a().dispatchDelayed((Dispatcher.Dispatchable)localObject3, 500);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(StoryReportor.b(paramStoryVideoTaskInfo.jdField_f_of_type_Int));
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode);
      ((StringBuilder)localObject4).append("");
      StoryReportor.a("mystory", "publish_fail", 0, 0, new String[] { localObject1, ((StringBuilder)localObject4).toString(), "", ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      if (paramStoryVideoTaskInfo.jdField_b_of_type_Int > 0) {
        StoryReportor.a("mystory", "retrypub_fail", 0, 0, new String[0]);
      }
      l = SystemClock.elapsedRealtime() - paramStoryVideoTaskInfo.jdField_a_of_type_Long;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg);
      ((StringBuilder)localObject1).append("##times:%d##lastError:%d##fakeVid:%s##%s");
      localObject1 = String.format(((StringBuilder)localObject1).toString(), new Object[] { Integer.valueOf(paramStoryVideoTaskInfo.jdField_b_of_type_Int), Integer.valueOf(paramStoryVideoTaskInfo.jdField_c_of_type_Int), paramStoryVideoTaskInfo.a(), paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
      StoryReportor.b("publish_story", "publish_all_old", 0, paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()), String.valueOf(paramStoryVideoTaskInfo.jdField_b_of_type_Int) });
      if (!"composite".equals(paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg)) {
        StoryReportor.b("publish_story", "publish_all", 0, paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()), String.valueOf(paramStoryVideoTaskInfo.jdField_b_of_type_Int) });
      }
      localObject3 = paramStoryVideoTaskInfo.a();
      bool = ((PublishVideoEntry)localObject3).getBooleanExtra("useFlowDecode", false);
      StoryReportor.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject3).saveMode, paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(bool), localObject1, paramStoryVideoTaskInfo.h });
      MonitorReport.a(2444493, paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessageForReport());
      SLog.a((String)localObject2, "publish vid:%s fail take time:%d", paramStoryVideoTaskInfo.a(), Long.valueOf(l));
      return;
    }
    if (!((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel()) {
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject3);
    }
  }
  
  protected void a(StoryVideoTaskInfo paramStoryVideoTaskInfo, ErrorMessage paramErrorMessage)
  {
    if (paramStoryVideoTaskInfo.jdField_a_of_type_Int == 5)
    {
      StoryVideoUploadProgressManager.a().a(paramStoryVideoTaskInfo.a(), paramStoryVideoTaskInfo.jdField_g_of_type_JavaLangString);
      return;
    }
    if ((paramStoryVideoTaskInfo.jdField_a_of_type_Int == 6) || (paramStoryVideoTaskInfo.jdField_a_of_type_Int == 3) || (paramStoryVideoTaskInfo.jdField_a_of_type_Int == 7)) {
      StoryVideoUploadProgressManager.a().d(paramStoryVideoTaskInfo.a());
    }
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (StoryDepends.ShortVideoMultiSender.a(paramStoryVideoItem))
    {
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
      return;
    }
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "can not retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      StoryVideoUploadProgressManager.a().a();
    }
    StoryVideoTaskInfo localStoryVideoTaskInfo = new StoryVideoTaskInfo(paramStoryVideoItem);
    localStoryVideoTaskInfo.jdField_b_of_type_Int += 1;
    super.b(localStoryVideoTaskInfo);
    StoryVideoUploadProgressManager.a().a(paramStoryVideoItem.mVid, false);
    Object localObject1 = (StoryManager)SuperManager.a(5);
    paramStoryVideoItem = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(false);
    paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryManager)localObject1).a(localStoryVideoTaskInfo.a(), localStoryVideoTaskInfo.a());
    paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localStoryVideoTaskInfo.a();
    localObject1 = localStoryVideoTaskInfo.a();
    if ((localObject1 != null) && (((VideoSpreadGroupList)localObject1).jdField_b_of_type_JavaUtilList != null))
    {
      paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((VideoSpreadGroupList)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        StoryVideoUploadManager.ShareGroupFakeItem localShareGroupFakeItem = new StoryVideoUploadManager.ShareGroupFakeItem();
        localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = FeedManager.a((String)localObject2, localStoryVideoTaskInfo.a().mLocalDate);
        localShareGroupFakeItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new StoryVideoUploadManager.OneVideoInfo();
        ((StoryVideoUploadManager.OneVideoInfo)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localShareGroupFakeItem.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList.add(localShareGroupFakeItem);
      }
    }
    StoryDispatcher.a().dispatch(paramStoryVideoItem);
    super.d();
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { localStoryVideoTaskInfo });
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (StoryVideoTaskInfo)((Iterator)localObject3).next();
      } while (!paramString1.equals(((StoryVideoTaskInfo)localObject1).a()));
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (paramString1.equals(((StoryVideoTaskInfo)((BasePublishTask)localObject3).a()).a())) {
            localObject2 = (StoryVideoTaskInfo)((BasePublishTask)localObject3).a();
          }
        }
      }
      if (localObject2 != null)
      {
        ((StoryVideoTaskInfo)localObject2).jdField_a_of_type_JavaLangString = paramString2;
        localObject1 = (StoryManager)SuperManager.a(5);
        localObject3 = ((StoryVideoTaskInfo)localObject2).a();
        ((StoryManager)localObject1).a(((StoryVideoTaskInfo)localObject2).a(), (StoryVideoItem)localObject3);
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "true update video path:%s %s", new Object[] { paramString1, paramString2 });
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask;
      boolean bool;
      if (localObject != null)
      {
        bool = paramString.equals(((StoryVideoTaskInfo)((BasePublishTask)localObject).a()).a());
        if (bool) {
          return true;
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bool = paramString.equals(((StoryVideoTaskInfo)((Iterator)localObject).next()).a());
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b()
  {
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.b();
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadManager$VideoCompositeRec);
  }
  
  public void c(String paramString)
  {
    Object localObject = (StoryManager)SuperManager.a(5);
    StoryVideoItem localStoryVideoItem = ((StoryManager)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        FileUtils.g(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        FileUtils.g(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        FileUtils.g(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((StoryManager)localObject).a(paramString);
    localObject = new StoryVideoTaskInfo(paramString);
    super.c((BaseTaskInfo)localObject);
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    VideoCompositeHelper.a(((StoryVideoTaskInfo)localObject).a());
    Bosses.get().scheduleJobDelayed(new StoryVideoUploadManager.6(this, "Q.qqstory.publish.upload:StoryVideoUploadManager", paramString, localStoryVideoItem), 300);
  }
  
  public boolean isValidate()
  {
    return this.c.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager
 * JD-Core Version:    0.7.0.1
 */