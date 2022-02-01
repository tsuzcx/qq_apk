package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader;
import com.tencent.biz.qqstory.base.preload.VideoPreloader;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeedVideoPreloader
{
  public IVideoPreloader a = new VideoPreloader();
  public FeedVideoPreloader.OnFileDownloadListener b = new FeedVideoPreloader.OnFileDownloadListener(this);
  protected FeedVideoPreloader.OnVideoDownloadListener c;
  protected List<StoryHomeFeed> d = new ArrayList();
  protected List<DownloadTask> e = new ArrayList();
  protected StoryVideoItem f = null;
  protected FeedVideoPreloader.CurrentVid g;
  private Object h = new Object();
  
  public FeedVideoPreloader()
  {
    this.a.a(1);
    this.a.a(this.b);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, List<DownloadTask> paramList, boolean paramBoolean)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if (paramBoolean)
    {
      DownloadTask localDownloadTask1 = DownloadTask.a(paramStoryVideoItem.mVid, 1);
      DownloadTask localDownloadTask2 = DownloadTask.a(paramStoryVideoItem.mVid, 0);
      paramStoryVideoItem = DownloadTask.a(paramStoryVideoItem.mVid, 2);
      localDownloadTask1.s = 0;
      localDownloadTask2.s = 0;
      paramStoryVideoItem.s = 1;
      localDownloadTask2.l.put("handleCallback", localBoolean);
      paramList.add(localDownloadTask1);
      paramList.add(localDownloadTask2);
      paramList.add(paramStoryVideoItem);
      return;
    }
    paramList.add(DownloadTask.a(paramStoryVideoItem.mVid, 2));
    paramList.add(DownloadTask.a(paramStoryVideoItem.mVid, 1));
    paramStoryVideoItem = DownloadTask.a(paramStoryVideoItem.mVid, 0);
    paramStoryVideoItem.l.put("handleCallback", localBoolean);
    paramList.add(paramStoryVideoItem);
  }
  
  public void a()
  {
    this.a.a();
    this.c = null;
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, List<StoryHomeFeed> paramList)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new FeedVideoPreloader.1(this, "Q.qqstory.download.preload.FeedVideoPreloader", paramStoryVideoItem, paramList));
  }
  
  public void a(FeedVideoPreloader.OnVideoDownloadListener paramOnVideoDownloadListener)
  {
    this.c = paramOnVideoDownloadListener;
  }
  
  protected boolean a(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, false);
  }
  
  protected void b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList();
    int i;
    int j;
    synchronized (this.h)
    {
      ((List)localObject2).addAll(this.d);
      if (this.f != null)
      {
        i = 0;
        if (i < ((List)localObject2).size())
        {
          List localList = ((StoryHomeFeed)((List)localObject2).get(i)).j();
          if ((localList.size() > 0) && (TextUtils.equals(this.f.mVid, ((StoryVideoItem)localList.get(0)).mVid)))
          {
            j = 1;
            a(this.f, localArrayList, true);
            if (j == 0) {
              i = 0;
            }
            j = i + 1;
            if (j < ((List)localObject2).size())
            {
              ??? = ((StoryHomeFeed)((List)localObject2).get(j)).j();
              if (((List)???).size() > 0) {
                a((StoryVideoItem)((List)???).get(0), localArrayList, false);
              }
            }
            i -= 1;
            if ((i >= 0) && (i < ((List)localObject2).size()))
            {
              localObject2 = ((StoryHomeFeed)((List)localObject2).get(i)).j();
              if (((List)localObject2).size() > 0) {
                a((StoryVideoItem)((List)localObject2).get(0), localArrayList, false);
              }
            }
            this.e = localArrayList;
            this.a.a(localArrayList, true);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader
 * JD-Core Version:    0.7.0.1
 */