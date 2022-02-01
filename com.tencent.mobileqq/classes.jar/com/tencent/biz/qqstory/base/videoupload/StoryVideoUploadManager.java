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
  private StoryVideoUploadManager.VideoCompositeRec d;
  private boolean e = false;
  
  private void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (this.a == null) {
      StoryVideoUploadProgressManager.a().b();
    }
    StoryVideoTaskInfo localStoryVideoTaskInfo = new StoryVideoTaskInfo(paramPublishVideoEntry);
    super.c(localStoryVideoTaskInfo);
    StoryVideoUploadProgressManager.a().a(paramPublishVideoEntry.fakeVid, false);
    StoryVideoUploadManager.StoryVideoPublishStatusEvent localStoryVideoPublishStatusEvent = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(true);
    Object localObject1 = (StoryManager)SuperManager.a(5);
    Object localObject2 = localStoryVideoTaskInfo.c();
    localStoryVideoPublishStatusEvent.c = ((StoryManager)localObject1).a(localStoryVideoTaskInfo.d(), (StoryVideoItem)localObject2);
    localStoryVideoPublishStatusEvent.e = localStoryVideoTaskInfo.b();
    localObject1 = localStoryVideoTaskInfo.f();
    if ((localObject1 != null) && (((VideoSpreadGroupList)localObject1).d != null))
    {
      localStoryVideoPublishStatusEvent.f = new ArrayList();
      localObject1 = ((VideoSpreadGroupList)localObject1).d.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new StoryVideoUploadManager.ShareGroupFakeItem();
        ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).a = FeedManager.d((String)localObject3, localStoryVideoTaskInfo.e().mLocalDate);
        ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).c = new ArrayList(1);
        localObject3 = new StoryVideoUploadManager.OneVideoInfo();
        ((StoryVideoUploadManager.OneVideoInfo)localObject3).a = localStoryVideoPublishStatusEvent.c;
        ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).c.add(localObject3);
        localStoryVideoPublishStatusEvent.f.add(localObject2);
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
      if ((StoryConfigManager.m()) && (Build.VERSION.SDK_INT < 27)) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (StoryConfigManager.n()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().d().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((EntityManager)localObject1).persistOrReplace(paramPublishVideoEntry);
    }
    ThreadManager.post(new StoryVideoUploadManager.4(this, localStoryVideoTaskInfo, localStoryVideoPublishStatusEvent), 8, new StoryVideoUploadManager.5(this, localStoryVideoTaskInfo), false);
  }
  
  public static void a(String paramString)
  {
    ((StoryVideoUploadManager)SuperManager.c().b(3)).d(paramString);
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
          paramArrayList.mOwnerUid = QQStoryContext.a().i();
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "vid:%s for storyVideoItem is null", new Object[] { str });
        }
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(paramArrayList);
        localStoryVideoItem.mVideoSource = 1;
        localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        localStoryVideoItem.shareGroupId = paramString;
        localStoryVideoItem.sourceVid = str;
        localStoryVideoItem.mPublishDate = FeedManager.i();
        localStoryVideoItem.mUploadStatus = 0;
        localStoryVideoItem.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
        localStoryVideoItem.mTimeZoneOffsetMillis = (UIUtils.b() * 1000);
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
        {
          paramArrayList = ((UserManager)SuperManager.a(2)).c();
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
      VideoListFeedItem localVideoListFeedItem = FeedManager.d(paramString, FeedManager.i());
      if ((localVideoListFeedItem != null) && (paramList != null) && (paramList.size() != 0))
      {
        StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
        Object localObject1 = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(true);
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).b = false;
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).f = new ArrayList(1);
        Object localObject2 = new StoryVideoUploadManager.ShareGroupFakeItem();
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject1).f.add(localObject2);
        ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).a = localVideoListFeedItem;
        Object localObject3 = paramList.iterator();
        Object localObject5;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new StoryVideoUploadManager.OneVideoInfo();
          ((StoryVideoUploadManager.OneVideoInfo)localObject5).a = localStoryManager.a((StoryVideoItem)localObject4);
          ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).c.add(localObject5);
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
      QQToast.makeText(paramActivity, 1, HardCodeUtil.a(2131911875), 0).show();
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
      paramList.setTitle(HardCodeUtil.a(2131911876));
      paramList.setMessage(HardCodeUtil.a(2131911878));
      paramList.setPositiveButton(HardCodeUtil.a(2131911877), new StoryVideoUploadManager.1(localArrayList1));
      paramList.setCancelable(false);
      paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      paramList.show();
    }
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!NetworkUtil.isNetworkAvailable(paramContext))
    {
      QQToast.makeText(paramContext, 1, HardCodeUtil.a(2131911874), 0).show();
      return false;
    }
    ((StoryVideoUploadManager)SuperManager.c().b(3)).a(paramStoryVideoItem);
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
  
  public static int c()
  {
    try
    {
      EntityManager localEntityManager = QQStoryContext.a().d().createEntityManager();
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
  
  private void g()
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
    g();
    this.d = new StoryVideoUploadManager.VideoCompositeRec(this);
    StoryDispatcher.a().registerSubscriber(this.d);
  }
  
  protected void a(StoryVideoTaskInfo paramStoryVideoTaskInfo, ErrorMessage paramErrorMessage)
  {
    if (paramStoryVideoTaskInfo.a == 5)
    {
      StoryVideoUploadProgressManager.a().a(paramStoryVideoTaskInfo.d(), paramStoryVideoTaskInfo.s);
      return;
    }
    if ((paramStoryVideoTaskInfo.a == 6) || (paramStoryVideoTaskInfo.a == 3) || (paramStoryVideoTaskInfo.a == 7)) {
      StoryVideoUploadProgressManager.a().d(paramStoryVideoTaskInfo.d());
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
    if (this.a == null) {
      StoryVideoUploadProgressManager.a().b();
    }
    StoryVideoTaskInfo localStoryVideoTaskInfo = new StoryVideoTaskInfo(paramStoryVideoItem);
    localStoryVideoTaskInfo.c += 1;
    super.c(localStoryVideoTaskInfo);
    StoryVideoUploadProgressManager.a().a(paramStoryVideoItem.mVid, false);
    Object localObject1 = (StoryManager)SuperManager.a(5);
    paramStoryVideoItem = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(false);
    paramStoryVideoItem.c = ((StoryManager)localObject1).a(localStoryVideoTaskInfo.d(), localStoryVideoTaskInfo.c());
    paramStoryVideoItem.e = localStoryVideoTaskInfo.b();
    localObject1 = localStoryVideoTaskInfo.f();
    if ((localObject1 != null) && (((VideoSpreadGroupList)localObject1).d != null))
    {
      paramStoryVideoItem.f = new ArrayList();
      localObject1 = ((VideoSpreadGroupList)localObject1).d.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        StoryVideoUploadManager.ShareGroupFakeItem localShareGroupFakeItem = new StoryVideoUploadManager.ShareGroupFakeItem();
        localShareGroupFakeItem.a = FeedManager.d((String)localObject2, localStoryVideoTaskInfo.e().mLocalDate);
        localShareGroupFakeItem.c = new ArrayList(1);
        localObject2 = new StoryVideoUploadManager.OneVideoInfo();
        ((StoryVideoUploadManager.OneVideoInfo)localObject2).a = paramStoryVideoItem.c;
        localShareGroupFakeItem.c.add(localObject2);
        paramStoryVideoItem.f.add(localShareGroupFakeItem);
      }
    }
    StoryDispatcher.a().dispatch(paramStoryVideoItem);
    super.e();
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { localStoryVideoTaskInfo });
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = this.b.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (StoryVideoTaskInfo)((Iterator)localObject3).next();
      } while (!paramString1.equals(((StoryVideoTaskInfo)localObject1).d()));
      localObject3 = this.a;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (paramString1.equals(((StoryVideoTaskInfo)((BasePublishTask)localObject3).a()).d())) {
            localObject2 = (StoryVideoTaskInfo)((BasePublishTask)localObject3).a();
          }
        }
      }
      if (localObject2 != null)
      {
        ((StoryVideoTaskInfo)localObject2).g = paramString2;
        localObject1 = (StoryManager)SuperManager.a(5);
        localObject3 = ((StoryVideoTaskInfo)localObject2).c();
        ((StoryManager)localObject1).a(((StoryVideoTaskInfo)localObject2).d(), (StoryVideoItem)localObject3);
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
  
  public void b()
  {
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.b();
    StoryDispatcher.a().unRegisterSubscriber(this.d);
  }
  
  protected void b(StoryVideoTaskInfo paramStoryVideoTaskInfo)
  {
    boolean bool = i();
    Object localObject1 = "Q.qqstory.publish.upload:StoryVideoUploadManager";
    if (bool)
    {
      SLog.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
      return;
    }
    if (paramStoryVideoTaskInfo.a())
    {
      localObject2 = FileCacheUtils.a(paramStoryVideoTaskInfo.s, paramStoryVideoTaskInfo.q, 0, false, false);
      if (FileUtils.b(paramStoryVideoTaskInfo.g, (String)localObject2))
      {
        paramStoryVideoTaskInfo.g = ((String)localObject2);
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject2 });
      }
      else
      {
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
      }
      localObject2 = FileCacheUtils.a(paramStoryVideoTaskInfo.s, paramStoryVideoTaskInfo.q, 2, false, false);
      if (FileUtils.b(paramStoryVideoTaskInfo.h, (String)localObject2))
      {
        paramStoryVideoTaskInfo.i = paramStoryVideoTaskInfo.h;
        paramStoryVideoTaskInfo.h = ((String)localObject2);
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject2 });
      }
      else
      {
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
      }
      if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.k))
      {
        localObject2 = FileCacheUtils.a(paramStoryVideoTaskInfo.s, paramStoryVideoTaskInfo.q, 6, false, false);
        if (FileUtils.b(paramStoryVideoTaskInfo.k, (String)localObject2))
        {
          paramStoryVideoTaskInfo.k = ((String)localObject2);
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject2 });
        }
        else
        {
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        }
      }
      if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.l))
      {
        localObject2 = FileCacheUtils.a(paramStoryVideoTaskInfo.s, paramStoryVideoTaskInfo.q, 6, false, false);
        if (FileUtils.b(paramStoryVideoTaskInfo.l, (String)localObject2))
        {
          paramStoryVideoTaskInfo.l = ((String)localObject2);
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject2 });
        }
        else
        {
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        }
      }
      if (!TextUtils.isEmpty(paramStoryVideoTaskInfo.y))
      {
        localObject2 = FileCacheUtils.a(paramStoryVideoTaskInfo.s, paramStoryVideoTaskInfo.q, 5, false, false);
        if (FileUtils.b(paramStoryVideoTaskInfo.y, (String)localObject2))
        {
          paramStoryVideoTaskInfo.y = ((String)localObject2);
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
    Object localObject2 = localStoryManager.a(paramStoryVideoTaskInfo.d(), paramStoryVideoTaskInfo.c());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("task state write:");
    ((StringBuilder)localObject3).append(localObject2);
    SLog.b("Q.qqstory.publish.upload:StoryVideoUploadManager", ((StringBuilder)localObject3).toString());
    localObject3 = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(false);
    ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).g = paramStoryVideoTaskInfo.f;
    ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).c = ((StoryVideoItem)localObject2);
    ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).e = paramStoryVideoTaskInfo.b();
    Object localObject5 = paramStoryVideoTaskInfo.f();
    localObject2 = localObject1;
    Object localObject6;
    if (localObject5 != null)
    {
      localObject2 = localObject1;
      if (((VideoSpreadGroupList)localObject5).d != null)
      {
        ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).f = new ArrayList();
        localObject5 = ((VideoSpreadGroupList)localObject5).d.iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          Object localObject7 = (String)((Iterator)localObject5).next();
          localObject2 = new StoryVideoUploadManager.ShareGroupFakeItem();
          ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).a = FeedManager.d((String)localObject7, paramStoryVideoTaskInfo.e().mLocalDate);
          ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).c = new ArrayList(1);
          localObject6 = new StoryVideoUploadManager.OneVideoInfo();
          ((StoryVideoUploadManager.OneVideoInfo)localObject6).a = ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).c;
          if ((((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).c.isUploadSuc()) && (paramStoryVideoTaskInfo.z != null))
          {
            Object localObject8 = paramStoryVideoTaskInfo.z.iterator();
            while (((Iterator)localObject8).hasNext())
            {
              AddGroupVideoResponse.AddGroupFeed localAddGroupFeed = (AddGroupVideoResponse.AddGroupFeed)((Iterator)localObject8).next();
              if (((String)localObject7).equals(localAddGroupFeed.a))
              {
                if (((((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).a instanceof ShareGroupFeedItem)) && (((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).a.feedId.equals(localAddGroupFeed.b)))
                {
                  ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).b = ((ShareGroupFeedItem)((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).a);
                }
                else
                {
                  ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).b = new ShareGroupFeedItem();
                  ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).b.copy(((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).a);
                  ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).b.feedId = localAddGroupFeed.b;
                  AssertUtils.checkNotEmpty(localAddGroupFeed.b);
                  ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).b = ((ShareGroupFeedItem)((FeedManager)localObject4).a(((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).b));
                }
                localObject7 = new StoryVideoItem();
                ((StoryVideoItem)localObject7).copy(((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).c);
                ((StoryVideoItem)localObject7).mVid = ((String)localAddGroupFeed.c.get(paramStoryVideoTaskInfo.s));
                ((StoryVideoItem)localObject7).mVideoIndex = 0L;
                AssertUtils.checkNotEmpty(((StoryVideoItem)localObject7).mVid);
                ((StoryVideoUploadManager.OneVideoInfo)localObject6).b = localStoryManager.a((StoryVideoItem)localObject7);
                ((FeedManager)localObject4).a(((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).b.ownerId, ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).b.date, ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).b.feedId);
                localObject8 = new ArrayList();
                ((ArrayList)localObject8).add(localObject7);
                ((FeedManager)localObject4).a(localAddGroupFeed.b, (List)localObject8, false);
              }
            }
          }
          ((StoryVideoUploadManager.ShareGroupFakeItem)localObject2).c.add(localObject6);
          ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).f.add(localObject2);
        }
      }
    }
    int i;
    if ((paramStoryVideoTaskInfo.a == 2) && (!this.e))
    {
      this.e = true;
      i = (int)(SystemClock.elapsedRealtime() - paramStoryVideoTaskInfo.e);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(StoryReportor.d(paramStoryVideoTaskInfo.E));
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramStoryVideoTaskInfo.m);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(paramStoryVideoTaskInfo.F);
      ((StringBuilder)localObject6).append("");
      StoryReportor.a("video_shoot_new", "time_upload", 0, i, new String[] { localObject1, localObject5, "", ((StringBuilder)localObject6).toString() });
    }
    if ((paramStoryVideoTaskInfo.a == 5) || (paramStoryVideoTaskInfo.a == 3) || (paramStoryVideoTaskInfo.a == 6))
    {
      this.e = false;
      i = (int)(SystemClock.elapsedRealtime() - paramStoryVideoTaskInfo.e);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(StoryReportor.d(paramStoryVideoTaskInfo.E));
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramStoryVideoTaskInfo.m);
      ((StringBuilder)localObject5).append("");
      localObject5 = ((StringBuilder)localObject5).toString();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(paramStoryVideoTaskInfo.F);
      ((StringBuilder)localObject6).append("");
      StoryReportor.a("video_shoot_new", "time_publish", 0, i, new String[] { localObject1, localObject5, "", ((StringBuilder)localObject6).toString() });
    }
    long l;
    if (((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).c.isUploadSuc())
    {
      ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).d = paramStoryVideoTaskInfo.c();
      ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).d.mVid = paramStoryVideoTaskInfo.s;
      ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).d = localStoryManager.a(paramStoryVideoTaskInfo.s, ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).d);
      if (((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).b)
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).d);
        ((FeedManager)localObject4).a(((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).e.feedId, (List)localObject1, false);
      }
      if (paramStoryVideoTaskInfo.c > 0) {
        StoryReportor.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", paramStoryVideoTaskInfo.s });
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramStoryVideoTaskInfo.d());
      ((StringBuilder)localObject1).append("##:");
      localObject1 = ((StringBuilder)localObject1).toString();
      l = SystemClock.elapsedRealtime() - paramStoryVideoTaskInfo.e;
      StoryReportor.b("publish_story", "publish_all", 0, 0, new String[] { localObject1, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()), String.valueOf(paramStoryVideoTaskInfo.c) });
      StoryReportor.b("publish_story", "publish_all_old", 0, 0, new String[] { localObject1, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()), String.valueOf(paramStoryVideoTaskInfo.c) });
      localObject1 = paramStoryVideoTaskInfo.e();
      bool = ((PublishVideoEntry)localObject1).getBooleanExtra("useFlowDecode", false);
      StoryReportor.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject1).saveMode, 0, new String[] { String.valueOf(bool), "", paramStoryVideoTaskInfo.t });
      MonitorReport.a(2444494, null);
      SLog.a((String)localObject2, "publish vid:%s success take time:%d", paramStoryVideoTaskInfo.d(), Long.valueOf(l));
      VideoCompositeHelper.a(paramStoryVideoTaskInfo.e());
    }
    if (((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).c.isUploadFail())
    {
      StoryDispatcher.a().dispatchDelayed((Dispatcher.Dispatchable)localObject3, 500);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(StoryReportor.d(paramStoryVideoTaskInfo.E));
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramStoryVideoTaskInfo.f.errorCode);
      ((StringBuilder)localObject4).append("");
      StoryReportor.a("mystory", "publish_fail", 0, 0, new String[] { localObject1, ((StringBuilder)localObject4).toString(), "", ((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).c.mVid });
      if (paramStoryVideoTaskInfo.c > 0) {
        StoryReportor.a("mystory", "retrypub_fail", 0, 0, new String[0]);
      }
      l = SystemClock.elapsedRealtime() - paramStoryVideoTaskInfo.e;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramStoryVideoTaskInfo.f.extraMsg);
      ((StringBuilder)localObject1).append("##times:%d##lastError:%d##fakeVid:%s##%s");
      localObject1 = String.format(((StringBuilder)localObject1).toString(), new Object[] { Integer.valueOf(paramStoryVideoTaskInfo.c), Integer.valueOf(paramStoryVideoTaskInfo.d), paramStoryVideoTaskInfo.d(), paramStoryVideoTaskInfo.f.errorMsg });
      StoryReportor.b("publish_story", "publish_all_old", 0, paramStoryVideoTaskInfo.f.errorCode, new String[] { localObject1, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()), String.valueOf(paramStoryVideoTaskInfo.c) });
      if (!"composite".equals(paramStoryVideoTaskInfo.f.extraMsg)) {
        StoryReportor.b("publish_story", "publish_all", 0, paramStoryVideoTaskInfo.f.errorCode, new String[] { localObject1, String.valueOf(l), StoryReportor.a(BaseApplication.getContext()), String.valueOf(paramStoryVideoTaskInfo.c) });
      }
      localObject3 = paramStoryVideoTaskInfo.e();
      bool = ((PublishVideoEntry)localObject3).getBooleanExtra("useFlowDecode", false);
      StoryReportor.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject3).saveMode, paramStoryVideoTaskInfo.f.errorCode, new String[] { String.valueOf(bool), localObject1, paramStoryVideoTaskInfo.t });
      MonitorReport.a(2444493, paramStoryVideoTaskInfo.f.getErrorMessageForReport());
      SLog.a((String)localObject2, "publish vid:%s fail take time:%d", paramStoryVideoTaskInfo.d(), Long.valueOf(l));
      return;
    }
    if (!((StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject3).c.isCancel()) {
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject3);
    }
  }
  
  public boolean c(String paramString)
  {
    try
    {
      Object localObject = this.a;
      boolean bool;
      if (localObject != null)
      {
        bool = paramString.equals(((StoryVideoTaskInfo)((BasePublishTask)localObject).a()).d());
        if (bool) {
          return true;
        }
      }
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bool = paramString.equals(((StoryVideoTaskInfo)((Iterator)localObject).next()).d());
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
  
  public void d(String paramString)
  {
    Object localObject = (StoryManager)SuperManager.a(5);
    StoryVideoItem localStoryVideoItem = ((StoryManager)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        FileUtils.k(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        FileUtils.k(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        FileUtils.k(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((StoryManager)localObject).j(paramString);
    localObject = new StoryVideoTaskInfo(paramString);
    super.d((BaseTaskInfo)localObject);
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    VideoCompositeHelper.a(((StoryVideoTaskInfo)localObject).e());
    Bosses.get().scheduleJobDelayed(new StoryVideoUploadManager.6(this, "Q.qqstory.publish.upload:StoryVideoUploadManager", paramString, localStoryVideoItem), 300);
  }
  
  public boolean isValidate()
  {
    return this.h.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager
 * JD-Core Version:    0.7.0.1
 */