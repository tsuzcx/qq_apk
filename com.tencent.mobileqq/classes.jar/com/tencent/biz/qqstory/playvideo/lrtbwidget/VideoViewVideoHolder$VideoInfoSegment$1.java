package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class VideoViewVideoHolder$VideoInfoSegment$1
  implements Runnable
{
  VideoViewVideoHolder$VideoInfoSegment$1(VideoViewVideoHolder.VideoInfoSegment paramVideoInfoSegment) {}
  
  public void run()
  {
    if (this.a.isCanceled()) {
      return;
    }
    VideoViewVideoHolder.a(this.a.a, "VI", SystemClock.uptimeMillis());
    if (!this.a.a.d())
    {
      VideoViewVideoHolder.VideoInfoSegment.a(this.a, new ErrorMessage(-1, "already unBind"));
      return;
    }
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).b(this.a.a.a.a);
    VideoViewVideoHolder.VideoInfoSegment.a(this.a, localStoryVideoItem, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment.1
 * JD-Core Version:    0.7.0.1
 */