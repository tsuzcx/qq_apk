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
  public final IManager[] a = new IManager[40];
  
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
    IManager localIManager1 = this.a[paramInt];
    if (localIManager1 == null) {}
    for (;;)
    {
      IManager localIManager2;
      synchronized (this.a)
      {
        localIManager2 = this.a[paramInt];
        if (localIManager2 == null) {
          break label408;
        }
        return localIManager2;
        if (localIManager1 != null)
        {
          localIManager1.a();
          SLog.b("Q.qqstory.SuperManager", "onInit manager : %s", localIManager1);
        }
        a(paramInt, localIManager1);
        return localIManager1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new TrimmableManager();
      continue;
      localObject2 = new ShareGroupIconManager();
      continue;
      localObject2 = new VideoFilterManager();
      continue;
      localObject2 = new StoryConfigManager();
      continue;
      localObject2 = new LbsManager();
      continue;
      localObject2 = new com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager();
      continue;
      localObject2 = new dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager();
      continue;
      localObject2 = new UserManager();
      continue;
      localObject2 = new PreloadDownloaderManager();
      continue;
      localObject2 = new VideoServerInfoManager();
      continue;
      localObject2 = new StoryVideoUploadManager();
      continue;
      localObject2 = new StoryManager();
      continue;
      localObject2 = new ReportWatchVideoManager();
      continue;
      localObject2 = new VideoCompositeManager();
      continue;
      localObject2 = new LikeManager();
      continue;
      localObject2 = new QQStoryActivityManager();
      continue;
      localObject2 = new CommentManager();
      continue;
      localObject2 = new MemoryManager();
      continue;
      localObject2 = new DataProviderManager();
      continue;
      localObject2 = new TroopStoryDBManager();
      continue;
      localObject2 = new DiscoverManager();
      continue;
      localObject2 = new FeedManager();
      continue;
      localObject2 = new FeedVideoManager();
      continue;
      localObject2 = new TroopNickNameManager();
      continue;
      localObject2 = new ShareGroupManager();
      continue;
      localObject2 = new HotSortVideoManager();
      continue;
      localObject2 = new TagManager();
      continue;
      localObject2 = new DownloadUrlManager();
      continue;
      localObject2 = new StoryPromoteTaskManager();
      continue;
      localObject2 = new StoryScanManager();
      continue;
      return localObject2;
      label408:
      localObject2 = localIManager2;
      switch (paramInt)
      {
      }
      localObject2 = localIManager2;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.SuperManager
 * JD-Core Version:    0.7.0.1
 */