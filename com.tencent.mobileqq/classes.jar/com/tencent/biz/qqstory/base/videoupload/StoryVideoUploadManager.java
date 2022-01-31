package com.tencent.biz.qqstory.base.videoupload;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTaskManager;
import com.tencent.biz.qqstory.base.videoupload.task.BaseTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.boundaries.StoryDepends.ShortVideoMultiSender;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.network.request.AddGroupVideoRequest;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse.AddGroupFeed;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.MonitorReport;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
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
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mza;
import mzb;
import mzc;
import mzd;
import mze;
import mzf;
import mzg;

@TargetApi(14)
public class StoryVideoUploadManager
  extends BasePublishTaskManager
  implements IEventReceiver
{
  private StoryVideoUploadManager.VideoCompositeRec a;
  
  public static int a()
  {
    for (;;)
    {
      List localList;
      try
      {
        EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
        StoryVideoUploadManager localStoryVideoUploadManager = (StoryVideoUploadManager)SuperManager.a(3);
        localList = localEntityManager.a(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, "createTime ASC", null, null);
        if ((localList == null) || (localList.size() <= 0))
        {
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: 0");
          i = 0;
          return i;
        }
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext()) {
          break label288;
        }
        PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)localIterator.next();
        long l1 = localPublishVideoEntry.getId();
        String str1 = localPublishVideoEntry.fakeVid;
        int j = localPublishVideoEntry.publishState;
        String str2 = localPublishVideoEntry.videoLabel;
        String str3 = localPublishVideoEntry.videoDoodleDescription;
        long l2 = localPublishVideoEntry.videoDuration;
        String str4 = localPublishVideoEntry.videoLocationDescription;
        if (localPublishVideoEntry.isPicture)
        {
          i = 1;
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: id=%d, fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s, isPhoto = %d", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(j), str2, str3, Long.valueOf(l2), str4, Integer.valueOf(i) });
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo detail info:%s", new Object[] { localPublishVideoEntry });
          localPublishVideoEntry.publishState = 0;
          localEntityManager.a(localPublishVideoEntry);
          localStoryVideoUploadManager.a(localPublishVideoEntry);
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label288:
      int i = localList.size();
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry)
  {
    StoryVideoTaskInfo localStoryVideoTaskInfo = new StoryVideoTaskInfo(paramPublishVideoEntry);
    super.b(localStoryVideoTaskInfo);
    StoryVideoUploadManager.StoryVideoPublishStatusEvent localStoryVideoPublishStatusEvent = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(true);
    if (!localStoryVideoTaskInfo.a().getBooleanExtra("ignorePersonalPublish", false)) {}
    Object localObject1;
    for (boolean bool1 = true;; bool1 = false)
    {
      localStoryVideoPublishStatusEvent.jdField_b_of_type_Boolean = bool1;
      localObject1 = (StoryManager)SuperManager.a(5);
      Object localObject2 = localStoryVideoTaskInfo.a();
      localStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryManager)localObject1).a(localStoryVideoTaskInfo.a(), (StoryVideoItem)localObject2);
      localStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localStoryVideoTaskInfo.a();
      localObject1 = localStoryVideoTaskInfo.a();
      if ((localObject1 == null) || (((VideoSpreadGroupList)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break;
      }
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
    bool1 = paramPublishVideoEntry.getBooleanExtra("is_hw_encode", false);
    boolean bool2 = paramPublishVideoEntry.isLocalPublish;
    if ((bool1) || (bool2))
    {
      int i = Math.min(paramPublishVideoEntry.videoHeight, paramPublishVideoEntry.videoWidth);
      int j = Math.max(paramPublishVideoEntry.videoHeight, paramPublishVideoEntry.videoWidth);
      paramPublishVideoEntry.videoWidth = i;
      paramPublishVideoEntry.videoHeight = j;
      if (StoryConfigManager.b()) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (StoryConfigManager.c()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().a().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((EntityManager)localObject1).b(paramPublishVideoEntry);
    }
    ThreadManager.post(new mzd(this, localStoryVideoTaskInfo, localStoryVideoPublishStatusEvent), 8, new mze(this, localStoryVideoTaskInfo), false);
  }
  
  public static void a(String paramString)
  {
    ((StoryVideoUploadManager)SuperManager.a().b(3)).c(paramString);
  }
  
  public static void a(String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramString != null) && (paramPublishVideoEntry != null) && (!paramPublishVideoEntry.hwEncodeRecordVideo) && (paramPublishVideoEntry.readerConfBytes != null) && (paramPublishVideoEntry.readerConfBytes.length > 0)) {}
    try
    {
      Object localObject = (StoryConfigManager)SuperManager.a(10);
      boolean bool1 = ((Boolean)((StoryConfigManager)localObject).b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)((StoryConfigManager)localObject).b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2) && ((paramPublishVideoEntry.readerConfBytes[0] == 1) || (paramPublishVideoEntry.readerConfBytes[0] == 4)))
      {
        localObject = paramPublishVideoEntry.fakeVid;
        String str = PublishFileManager.a(1, paramPublishVideoEntry.videoUploadTempDir, ".mp4");
        FileUtils.c(paramString, str);
        paramString = (PublishVideoEntry)paramPublishVideoEntry.deepCopyByReflect();
        paramString.fakeVid = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
        paramString.businessId = 1;
        paramString.publishState = 1;
        paramString.mIFrameVideoPath = str;
        paramString.publishFrom = 101;
        paramPublishVideoEntry = new QQStoryEntityManagerFactory(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        paramPublishVideoEntry.verifyAuthentication();
        paramPublishVideoEntry.createEntityManager().b(paramString);
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skip encode video : old=%s, new=%s, conf=%d", new Object[] { paramString.fakeVid, localObject, Byte.valueOf(paramString.readerConfBytes[0]) });
        StoryTransitionActivity.a(BaseApplicationImpl.getApplication());
      }
      return;
    }
    catch (Throwable paramString)
    {
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "handleVideoEvent", paramString);
    }
  }
  
  public static void a(@NonNull String paramString, @NonNull ArrayList paramArrayList, int paramInt)
  {
    try
    {
      AssertUtils.a(paramString);
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
    }
    finally {}
    Dispatchers.get().dispatch(new StoryVideoUploadManager.CreateFakeVideoEvent());
  }
  
  public static void a(String paramString, List paramList)
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
  
  private static void a(String paramString, List paramList, int paramInt)
  {
    for (;;)
    {
      VideoListFeedItem localVideoListFeedItem;
      StoryManager localStoryManager;
      Object localObject5;
      try
      {
        localVideoListFeedItem = FeedManager.a(paramString, FeedManager.a());
        if ((localVideoListFeedItem != null) && (paramList != null))
        {
          int i = paramList.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localStoryManager = (StoryManager)SuperManager.a(5);
        localObject1 = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(true);
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_b_of_type_Boolean = false;
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new StoryVideoUploadManager.ShareGroupFakeItem();
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = localVideoListFeedItem;
        localObject3 = paramList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new StoryVideoUploadManager.OneVideoInfo();
          ((StoryVideoUploadManager.OneVideoInfo)localObject5).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localStoryManager.a((StoryVideoItem)localObject4);
          ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject5);
          continue;
        }
        Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject1);
      }
      finally {}
      Object localObject1 = new ArrayList(paramList.size());
      Object localObject2 = new ArrayList(paramList.size());
      Object localObject3 = new ArrayList(paramList.size());
      Object localObject4 = paramList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (StoryVideoItem)((Iterator)localObject4).next();
        ((ArrayList)localObject1).add(((StoryVideoItem)localObject5).sourceVid);
        ((ArrayList)localObject2).add(Long.valueOf(((StoryVideoItem)localObject5).mCreateTime));
        ((ArrayList)localObject3).add(Integer.valueOf((int)((StoryVideoItem)localObject5).mTimeZoneOffsetMillis / 1000));
      }
      paramString = new AddGroupVideoRequest(paramString, (List)localObject1, (List)localObject2, (List)localObject3, paramInt);
      CmdTaskManger.a().a(paramString, new mzb(localVideoListFeedItem, paramList, localStoryManager));
    }
  }
  
  public static void a(List paramList, Activity paramActivity)
  {
    if (!NetworkUtil.g(paramActivity)) {
      QQToast.a(paramActivity, 1, "当前网络不可用，请检查你的网络设置", 0).a();
    }
    ArrayList localArrayList1;
    do
    {
      return;
      localArrayList1 = new ArrayList();
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
    } while ((localArrayList1.size() <= 0) || (paramActivity.isFinishing()));
    paramList = DialogUtil.a(paramActivity, 230);
    paramList.setTitle("发表失败");
    paramList.setMessage("文件已被删除，请重新拍摄");
    paramList.setPositiveButton("我知道了", new mza(localArrayList1));
    paramList.setCancelable(false);
    paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramList.show();
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!NetworkUtil.g(paramContext))
    {
      QQToast.a(paramContext, 1, "当前网络不可用，请检查你的网络设置", 0).a();
      return false;
    }
    ((StoryVideoUploadManager)SuperManager.a().b(3)).a(paramStoryVideoItem);
    return true;
  }
  
  public static void b(String paramString)
  {
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString + " post createStoryVideo ... ");
    Bosses.get().postJob(new mzc(paramString));
  }
  
  private void f()
  {
    SLog.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new mzg(this));
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
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadManager$VideoCompositeRec);
  }
  
  protected void a(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    if (b()) {
      SLog.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
    }
    Object localObject1;
    label133:
    label195:
    label477:
    label876:
    do
    {
      return;
      if (paramStoryVideoTaskInfo.b())
      {
        localObject1 = FileCacheUtils.a(paramStoryVideoTaskInfo.g, paramStoryVideoTaskInfo.d, 0, false, false);
        if (!FileUtils.b(paramStoryVideoTaskInfo.jdField_a_of_type_JavaLangString, (String)localObject1)) {
          break label816;
        }
        paramStoryVideoTaskInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject1 });
        localObject1 = FileCacheUtils.a(paramStoryVideoTaskInfo.g, paramStoryVideoTaskInfo.d, 2, false, false);
        if (!FileUtils.b(paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString, (String)localObject1)) {
          break label827;
        }
        paramStoryVideoTaskInfo.jdField_c_of_type_JavaLangString = paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString;
        paramStoryVideoTaskInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject1 });
        if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.e))
        {
          localObject1 = FileCacheUtils.a(paramStoryVideoTaskInfo.g, paramStoryVideoTaskInfo.d, 6, false, false);
          if (!FileUtils.b(paramStoryVideoTaskInfo.e, (String)localObject1)) {
            break label838;
          }
          paramStoryVideoTaskInfo.e = ((String)localObject1);
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.f))
        {
          localObject1 = FileCacheUtils.a(paramStoryVideoTaskInfo.g, paramStoryVideoTaskInfo.d, 6, false, false);
          if (!FileUtils.b(paramStoryVideoTaskInfo.f, (String)localObject1)) {
            break label849;
          }
          paramStoryVideoTaskInfo.f = ((String)localObject1);
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.m))
        {
          localObject1 = FileCacheUtils.a(paramStoryVideoTaskInfo.g, paramStoryVideoTaskInfo.d, 5, false, false);
          if (!FileUtils.b(paramStoryVideoTaskInfo.m, (String)localObject1)) {
            break label860;
          }
          paramStoryVideoTaskInfo.m = ((String)localObject1);
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir %s", new Object[] { localObject1 });
        }
      }
      Object localObject3 = (StoryManager)SuperManager.a(5);
      Object localObject2 = (FeedManager)SuperManager.a(11);
      Object localObject4 = ((StoryManager)localObject3).a(paramStoryVideoTaskInfo.a(), paramStoryVideoTaskInfo.a());
      SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "task state write:" + localObject4);
      localObject1 = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(false);
      boolean bool;
      Object localObject5;
      StoryVideoUploadManager.ShareGroupFakeItem localShareGroupFakeItem;
      StoryVideoUploadManager.OneVideoInfo localOneVideoInfo;
      Object localObject6;
      AddGroupVideoResponse.AddGroupFeed localAddGroupFeed;
      if (!paramStoryVideoTaskInfo.a().getBooleanExtra("ignorePersonalPublish", false))
      {
        bool = true;
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_b_of_type_Boolean = bool;
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject4);
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = paramStoryVideoTaskInfo.a();
        localObject4 = paramStoryVideoTaskInfo.a();
        if ((localObject4 == null) || (((VideoSpreadGroupList)localObject4).jdField_b_of_type_JavaUtilList == null)) {
          break label943;
        }
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject4 = ((VideoSpreadGroupList)localObject4).jdField_b_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label943;
        }
        localObject5 = (String)((Iterator)localObject4).next();
        localShareGroupFakeItem = new StoryVideoUploadManager.ShareGroupFakeItem();
        localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = FeedManager.a((String)localObject5, paramStoryVideoTaskInfo.a().mLocalDate);
        localShareGroupFakeItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localOneVideoInfo = new StoryVideoUploadManager.OneVideoInfo();
        localOneVideoInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        if ((((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()) && (paramStoryVideoTaskInfo.jdField_b_of_type_JavaUtilList != null))
        {
          localObject6 = paramStoryVideoTaskInfo.jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localAddGroupFeed = (AddGroupVideoResponse.AddGroupFeed)((Iterator)localObject6).next();
            if (((String)localObject5).equals(localAddGroupFeed.jdField_a_of_type_JavaLangString)) {
              if ((!(localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) || (!localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(localAddGroupFeed.jdField_b_of_type_JavaLangString))) {
                break label876;
              }
            }
          }
        }
      }
      for (localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);; localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((FeedManager)localObject2).a(localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem)))
      {
        localObject5 = new StoryVideoItem();
        ((StoryVideoItem)localObject5).copy(((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((StoryVideoItem)localObject5).mVid = ((String)localAddGroupFeed.jdField_a_of_type_JavaUtilMap.get(paramStoryVideoTaskInfo.g));
        ((StoryVideoItem)localObject5).mVideoIndex = 0L;
        AssertUtils.a(((StoryVideoItem)localObject5).mVid);
        localOneVideoInfo.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryManager)localObject3).a((StoryVideoItem)localObject5);
        ((FeedManager)localObject2).a(localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        localObject6 = new ArrayList();
        ((ArrayList)localObject6).add(localObject5);
        ((FeedManager)localObject2).a(localAddGroupFeed.jdField_b_of_type_JavaLangString, (List)localObject6, false);
        localShareGroupFakeItem.jdField_a_of_type_JavaUtilArrayList.add(localOneVideoInfo);
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localShareGroupFakeItem);
        break label477;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
        break;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
        break label133;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        break label195;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        break label257;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir fail");
        break label318;
        bool = false;
        break label403;
        localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = localAddGroupFeed.jdField_b_of_type_JavaLangString;
        AssertUtils.a(localAddGroupFeed.jdField_b_of_type_JavaLangString);
      }
      long l;
      if (((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
      {
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoTaskInfo.a();
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid = paramStoryVideoTaskInfo.g;
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryManager)localObject3).a(paramStoryVideoTaskInfo.g, ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        if (((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_b_of_type_Boolean)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          ((FeedManager)localObject2).a(((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId, (List)localObject3, false);
        }
        if (paramStoryVideoTaskInfo.jdField_b_of_type_Int > 0) {
          StoryReportor.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", paramStoryVideoTaskInfo.g });
        }
        localObject2 = paramStoryVideoTaskInfo.a() + "##:";
        l = SystemClock.elapsedRealtime() - paramStoryVideoTaskInfo.jdField_a_of_type_Long;
        StoryReportor.b("publish_story", "publish_all", 0, 0, new String[] { localObject2, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()), String.valueOf(paramStoryVideoTaskInfo.jdField_b_of_type_Int) });
        localObject2 = paramStoryVideoTaskInfo.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        StoryReportor.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, 0, new String[] { String.valueOf(bool), "", paramStoryVideoTaskInfo.h });
        MonitorReport.a(2444494, null);
        SLog.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s success take time:%d", paramStoryVideoTaskInfo.a(), Long.valueOf(l));
        VideoCompositeHelper.a(paramStoryVideoTaskInfo.a());
      }
      if (((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail())
      {
        Dispatchers.get().dispatchDelayed((Dispatcher.Dispatchable)localObject1, 500);
        StoryReportor.a("mystory", "publish_fail", 0, 0, new String[0]);
        if (paramStoryVideoTaskInfo.jdField_b_of_type_Int > 0) {
          StoryReportor.a("mystory", "retrypub_fail", 0, 0, new String[0]);
        }
        l = SystemClock.elapsedRealtime() - paramStoryVideoTaskInfo.jdField_a_of_type_Long;
        localObject1 = String.format("times:%d##lastError:%d##fakeVid:%s##%s", new Object[] { Integer.valueOf(paramStoryVideoTaskInfo.jdField_b_of_type_Int), Integer.valueOf(paramStoryVideoTaskInfo.jdField_c_of_type_Int), paramStoryVideoTaskInfo.a(), paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
        StoryReportor.b("publish_story", "publish_all", 0, paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()), String.valueOf(paramStoryVideoTaskInfo.jdField_b_of_type_Int) });
        localObject2 = paramStoryVideoTaskInfo.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        StoryReportor.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(bool), localObject1, paramStoryVideoTaskInfo.h });
        MonitorReport.a(2444493, paramStoryVideoTaskInfo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessageForReport());
        SLog.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s fail take time:%d", paramStoryVideoTaskInfo.a(), Long.valueOf(l));
        return;
      }
    } while (((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel());
    label257:
    label318:
    label838:
    label849:
    label860:
    Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject1);
    label403:
    label816:
    label827:
    return;
  }
  
  protected void a(StoryVideoTaskInfo paramStoryVideoTaskInfo, ErrorMessage paramErrorMessage) {}
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (StoryDepends.ShortVideoMultiSender.a(paramStoryVideoItem))
    {
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
      return;
    }
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "can not retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
    paramStoryVideoItem = new StoryVideoTaskInfo(paramStoryVideoItem);
    paramStoryVideoItem.jdField_b_of_type_Int += 1;
    super.b(paramStoryVideoItem);
    Object localObject1 = (StoryManager)SuperManager.a(5);
    StoryVideoUploadManager.StoryVideoPublishStatusEvent localStoryVideoPublishStatusEvent = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(false);
    if (!paramStoryVideoItem.a().getBooleanExtra("ignorePersonalPublish", false)) {}
    for (boolean bool = true;; bool = false)
    {
      localStoryVideoPublishStatusEvent.jdField_b_of_type_Boolean = bool;
      localStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryManager)localObject1).a(paramStoryVideoItem.a(), paramStoryVideoItem.a());
      localStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = paramStoryVideoItem.a();
      localObject1 = paramStoryVideoItem.a();
      if ((localObject1 == null) || (((VideoSpreadGroupList)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break;
      }
      localStoryVideoPublishStatusEvent.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((VideoSpreadGroupList)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        StoryVideoUploadManager.ShareGroupFakeItem localShareGroupFakeItem = new StoryVideoUploadManager.ShareGroupFakeItem();
        localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = FeedManager.a((String)localObject2, paramStoryVideoItem.a().mLocalDate);
        localShareGroupFakeItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new StoryVideoUploadManager.OneVideoInfo();
        ((StoryVideoUploadManager.OneVideoInfo)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localShareGroupFakeItem.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        localStoryVideoPublishStatusEvent.jdField_a_of_type_JavaUtilArrayList.add(localShareGroupFakeItem);
      }
    }
    Dispatchers.get().dispatch(localStoryVideoPublishStatusEvent);
    super.d();
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { paramStoryVideoItem });
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
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 937	com/tencent/biz/qqstory/base/videoupload/StoryVideoUploadManager:jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +28 -> 36
    //   11: aload_1
    //   12: aload_3
    //   13: invokevirtual 942	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTask:a	()Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   16: checkcast 146	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   19: invokevirtual 175	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:a	()Ljava/lang/String;
    //   22: invokevirtual 755	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: istore_2
    //   26: iload_2
    //   27: ifeq +9 -> 36
    //   30: iconst_1
    //   31: istore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 934	com/tencent/biz/qqstory/base/videoupload/StoryVideoUploadManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   40: invokevirtual 435	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 82 1 0
    //   50: ifeq +29 -> 79
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 86 1 0
    //   60: checkcast 146	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   63: invokevirtual 175	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:a	()Ljava/lang/String;
    //   66: invokevirtual 755	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: istore_2
    //   70: iload_2
    //   71: ifeq -27 -> 44
    //   74: iconst_1
    //   75: istore_2
    //   76: goto -44 -> 32
    //   79: iconst_0
    //   80: istore_2
    //   81: goto -49 -> 32
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	StoryVideoUploadManager
    //   0	89	1	paramString	String
    //   25	56	2	bool	boolean
    //   6	49	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	84	finally
    //   11	26	84	finally
    //   36	44	84	finally
    //   44	70	84	finally
  }
  
  public void b()
  {
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.b();
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadManager$VideoCompositeRec);
  }
  
  public void c(String paramString)
  {
    Object localObject = (StoryManager)SuperManager.a(5);
    StoryVideoItem localStoryVideoItem = ((StoryManager)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        FileUtils.f(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        FileUtils.f(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        FileUtils.f(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((StoryManager)localObject).a(paramString);
    localObject = new StoryVideoTaskInfo(paramString);
    super.c((BaseTaskInfo)localObject);
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    VideoCompositeHelper.a(((StoryVideoTaskInfo)localObject).a());
    Bosses.get().scheduleJobDelayed(new mzf(this, paramString, localStoryVideoItem), 300);
  }
  
  public boolean isValidate()
  {
    return !this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager
 * JD-Core Version:    0.7.0.1
 */