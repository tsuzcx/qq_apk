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
    ??? = ((FeedVideoManager)SuperManager.a(12)).a(VideoListPageLoader.a(this.this$0), VideoListPageLoader.a(this.this$0));
    VideoListPageLoader.GetVideoListEvent localGetVideoListEvent = new VideoListPageLoader.GetVideoListEvent(new ErrorMessage(), VideoListPageLoader.a(this.this$0));
    localGetVideoListEvent.d = false;
    localGetVideoListEvent.b = true;
    localGetVideoListEvent.c = true;
    localGetVideoListEvent.jdField_a_of_type_Boolean = true;
    if (??? != null) {
      localGetVideoListEvent.jdField_a_of_type_JavaUtilList = ((FeedVideoInfo)???).mVideoItemList;
    }
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        VideoListPageLoader.a(this.this$0, localGetVideoListEvent);
        SLog.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from cache: %s", localGetVideoListEvent);
        return;
      }
      SLog.d("Q.qqstory.home.data:VideoListPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.1
 * JD-Core Version:    0.7.0.1
 */