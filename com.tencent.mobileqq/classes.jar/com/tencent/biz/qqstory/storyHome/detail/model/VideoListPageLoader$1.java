package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.support.logging.SLog;

class VideoListPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((FeedVideoManager)SuperManager.a(12)).a(VideoListPageLoader.a(this.this$0), VideoListPageLoader.b(this.this$0));
    VideoListPageLoader.GetVideoListEvent localGetVideoListEvent = new VideoListPageLoader.GetVideoListEvent(new ErrorMessage(), VideoListPageLoader.a(this.this$0));
    localGetVideoListEvent.d = false;
    localGetVideoListEvent.b = true;
    localGetVideoListEvent.c = true;
    localGetVideoListEvent.a = true;
    if (??? != null) {
      localGetVideoListEvent.h = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.e)
      {
        VideoListPageLoader.a(this.this$0, localGetVideoListEvent);
        SLog.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localGetVideoListEvent);
      }
      else
      {
        SLog.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */