package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class VideoMaskController$onTouchListener$1
  implements View.OnTouchListener
{
  VideoMaskController$onTouchListener$1(VideoMaskController paramVideoMaskController) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "event");
    int i = (int)paramMotionEvent.getRawX() - VideoMaskController.a(this.a);
    int j = (int)paramMotionEvent.getRawY() - VideoMaskController.b(this.a);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      VideoMaskController.a(this.a, (int)paramMotionEvent.getRawX());
      VideoMaskController.b(this.a, (int)paramMotionEvent.getRawY());
      VideoMaskController.c(this.a, this.a.a().getProgress());
      VideoMaskController.a(this.a).requestDisallowInterceptTouchEvent(true);
      return false;
      if (Math.abs(j) - Math.abs(i) * 2 > 0)
      {
        VideoMaskController.a(this.a).requestDisallowInterceptTouchEvent(false);
        return false;
      }
      paramView = this.a.a();
      if (paramView != null)
      {
        float f2;
        float f1;
        if (VideoMaskController.a(this.a).getWidth() != 0)
        {
          f2 = ((int)paramMotionEvent.getRawX() - VideoMaskController.a(this.a)) * 100 / VideoMaskController.a(this.a).getWidth() + VideoMaskController.c(this.a);
          if (f2 >= 0) {
            break label283;
          }
          f1 = 0.0F;
        }
        for (;;)
        {
          paramView.setProgress((int)f1);
          if ((Math.abs(i) > 6) && (!this.a.a())) {
            VideoMaskController.a(this.a).onStartTrackingTouch(this.a.a());
          }
          break;
          label283:
          f1 = f2;
          if (f2 >= 100) {
            f1 = 99.0F;
          }
        }
        if ((Math.abs(i) < 6) || (Math.abs(j) - Math.abs(i) > 0)) {
          return false;
        }
        VideoMaskController.a(this.a).onStopTrackingTouch(this.a.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoMaskController.onTouchListener.1
 * JD-Core Version:    0.7.0.1
 */