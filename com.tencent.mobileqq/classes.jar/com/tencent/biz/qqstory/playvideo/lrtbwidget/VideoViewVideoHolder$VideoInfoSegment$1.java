package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import uvx;
import uwa;
import vtt;
import vuz;

public class VideoViewVideoHolder$VideoInfoSegment$1
  implements Runnable
{
  public VideoViewVideoHolder$VideoInfoSegment$1(vuz paramvuz) {}
  
  public void run()
  {
    if (this.a.isCanceled()) {
      return;
    }
    VideoViewVideoHolder.a(this.a.a, "VI", SystemClock.uptimeMillis());
    if (!this.a.a.d())
    {
      vuz.a(this.a, new ErrorMessage(-1, "already unBind"));
      return;
    }
    StoryVideoItem localStoryVideoItem = ((uvx)uwa.a(5)).b(this.a.a.a.a);
    vuz.a(this.a, localStoryVideoItem, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment.1
 * JD-Core Version:    0.7.0.1
 */