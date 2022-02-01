package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;

class VideoViewVideoHolder$VideoInfoSegment$2
  implements Runnable
{
  VideoViewVideoHolder$VideoInfoSegment$2(VideoViewVideoHolder.VideoInfoSegment paramVideoInfoSegment) {}
  
  public void run()
  {
    if (this.a.isCanceled()) {
      return;
    }
    SLog.e(this.a.b.a, "response FAILED get video info of %s", new Object[] { this.a.a });
    VideoViewVideoHolder.a(this.a.b, HardCodeUtil.a(2131913625));
    SLog.d(this.a.b.a, "get video info failed, hide loading view");
    VideoViewVideoHolder.c(this.a.b, 6);
    VideoViewVideoHolder.a(this.a.b, false);
    if (!NetworkUtil.isNetworkAvailable(this.a.b.b.getContext())) {
      VideoViewVideoHolder.b(this.a.b, 880001);
    }
    VideoViewVideoHolder.VideoInfoSegment localVideoInfoSegment = this.a;
    VideoViewVideoHolder.VideoInfoSegment.b(localVideoInfoSegment, new ErrorMessage(VideoViewVideoHolder.c(localVideoInfoSegment.b), "get video info failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment.2
 * JD-Core Version:    0.7.0.1
 */