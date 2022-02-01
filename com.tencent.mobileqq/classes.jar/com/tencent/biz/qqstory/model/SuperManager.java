package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager;
import com.tencent.biz.qqstory.model.filter.VideoFilterManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.support.logging.SLog;

public class SuperManager
  implements IManager
{
  public final IManager[] a = new IManager[32];
  
  public static IManager a(int paramInt)
  {
    return SuperManager.InstanceHolder.a.b(paramInt);
  }
  
  public static SuperManager a()
  {
    return SuperManager.InstanceHolder.a;
  }
  
  private void a(int paramInt, IManager paramIManager)
  {
    this.a[paramInt] = paramIManager;
  }
  
  public void a() {}
  
  public IManager b(int paramInt)
  {
    IManager[] arrayOfIManager = this.a;
    Object localObject = arrayOfIManager[paramInt];
    if (localObject == null)
    {
      try
      {
        localObject = this.a[paramInt];
        if (localObject == null) {
          break label373;
        }
        return localObject;
      }
      finally {}
      localObject = new StoryScanManager();
      break label338;
      localObject = new StoryPromoteTaskManager();
      break label338;
      localObject = new DownloadUrlManager();
      break label338;
      localObject = new TagManager();
      break label338;
      localObject = new TrimmableManager();
      break label338;
      localObject = new HotSortVideoManager();
      break label338;
      localObject = new ShareGroupIconManager();
      break label338;
      localObject = new TroopNickNameManager();
      break label338;
      localObject = new DiscoverManager();
      break label338;
      localObject = new TroopStoryDBManager();
      break label338;
      localObject = new DataProviderManager();
      break label338;
      localObject = new MemoryManager();
      break label338;
      localObject = new QQStoryActivityManager();
      break label338;
      localObject = new CommentManager();
      break label338;
      localObject = new VideoFilterManager();
      break label338;
      localObject = new LikeManager();
      break label338;
      localObject = new VideoCompositeManager();
      break label338;
      localObject = new ReportWatchVideoManager();
      break label338;
      localObject = new FeedVideoManager();
      break label338;
      localObject = new FeedManager();
      break label338;
      localObject = new StoryConfigManager();
      break label338;
      localObject = new LbsManager();
      break label338;
      localObject = new ShareGroupManager();
      break label338;
      localObject = new PreloadDownloaderManager();
      break label338;
      localObject = new StoryManager();
      break label338;
      localObject = new VideoServerInfoManager();
      break label338;
      localObject = new StoryVideoUploadManager();
      break label338;
      localObject = new UserManager();
    }
    for (;;)
    {
      label338:
      if (localObject != null)
      {
        ((IManager)localObject).a();
        SLog.b("Q.qqstory.SuperManager", "onInit manager : %s", localObject);
      }
      a(paramInt, (IManager)localObject);
      return localObject;
      return localIManager;
      switch (paramInt)
      {
      case 30: 
      case 29: 
      case 28: 
      case 27: 
      case 26: 
      case 25: 
      case 24: 
      case 23: 
      case 22: 
      case 21: 
      case 20: 
      case 19: 
      case 18: 
      case 17: 
      case 16: 
      case 15: 
      case 14: 
      case 13: 
      case 12: 
      case 11: 
      case 10: 
      case 9: 
      case 7: 
      case 6: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
      case 1: 
      case 8: 
      default: 
        break;
      case 0: 
        label373:
        SuperManager localSuperManager = this;
      }
    }
  }
  
  public void b() {}
  
  public void c()
  {
    IManager[] arrayOfIManager = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        IManager localIManager = this.a[i];
        SLog.b("Q.qqstory.SuperManager", "destroy manager : %s", localIManager);
        if (localIManager != null) {
          localIManager.b();
        }
        this.a[i] = null;
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.SuperManager
 * JD-Core Version:    0.7.0.1
 */