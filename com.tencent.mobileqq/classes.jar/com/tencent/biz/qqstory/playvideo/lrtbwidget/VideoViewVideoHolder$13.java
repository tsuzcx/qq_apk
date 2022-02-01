package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;

class VideoViewVideoHolder$13
  extends SimpleActivityLifeCycle
{
  VideoViewVideoHolder$13(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void e()
  {
    super.e();
    String str1 = this.a.a;
    String str2 = VideoViewVideoHolder.j[VideoViewVideoHolder.n(this.a)];
    boolean bool = false;
    if (this.a.r().getVisibility() == 0) {
      bool = true;
    }
    SLog.d(str1, "onResume, current state = %s, startBtn show = %s", new Object[] { str2, Boolean.valueOf(bool) });
    if (this.a.f()) {
      this.a.a(10, "onResume");
    }
  }
  
  public void f()
  {
    super.f();
    VideoViewVideoHolder.a(this.a, false);
    SLog.d(this.a.a, "onPause, current state = %s", new Object[] { VideoViewVideoHolder.j[VideoViewVideoHolder.n(this.a)] });
    this.a.a(0, true, "onPause");
  }
  
  public void h()
  {
    super.h();
    VideoViewVideoHolder.k(this.a).removeCallbacksAndMessages(null);
    this.a.l.b();
    this.a.a(0, true, "onDestroy");
    this.a.p.c();
    this.a.p.l();
    BatchGetVideoInfo localBatchGetVideoInfo = VideoViewVideoHolder.e(this.a);
    VideoViewVideoHolder.a(this.a, null);
    if (localBatchGetVideoInfo != null) {
      localBatchGetVideoInfo.a();
    }
    if (VideoViewVideoHolder.l(this.a) != null)
    {
      VideoViewVideoHolder.l(this.a).recycle();
      VideoViewVideoHolder.a(this.a, null);
    }
    if ((this.a.w != null) && (this.a.w.isShowing())) {
      this.a.w.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.13
 * JD-Core Version:    0.7.0.1
 */