package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import com.tencent.biz.qqstory.base.ErrorMessage;
import xpq;
import xsn;
import yuk;

class VideoViewVideoHolder$VideoStartSegment$1$1
  implements Runnable
{
  VideoViewVideoHolder$VideoStartSegment$1$1(VideoViewVideoHolder.VideoStartSegment.1 param1) {}
  
  public void run()
  {
    if (this.a.a.isCanceled()) {}
    xpq localxpq;
    do
    {
      return;
      if ((!this.a.a.this$0.c()) || (this.a.a.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder == null)) {
        break;
      }
      yuk.d(this.a.a.this$0.jdField_a_of_type_JavaLangString, "VideoStartSegment, wait first not-black frame");
      this.a.a.this$0.a().setVisibility(8);
      this.a.a.this$0.b().setVisibility(8);
      this.a.a.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a(true, true);
      VideoViewVideoHolder.a(this.a.a.this$0).b(this.a.a.this$0, this.a.a.this$0.jdField_a_of_type_Xtg);
      VideoViewVideoHolder.a(this.a.a.this$0, 12);
      this.a.a.a = SystemClock.uptimeMillis();
      VideoViewVideoHolder.a(this.a.a.this$0).removeCallbacksAndMessages(null);
      VideoViewVideoHolder.a(this.a.a.this$0).post(this.a.a);
      localxpq = (xpq)this.a.a.this$0.a(xpq.class);
    } while (localxpq == null);
    localxpq.a.setVisibility(0);
    return;
    yuk.e(this.a.a.this$0.jdField_a_of_type_JavaLangString, "VideoStartSegment, do not wait first not-black frame");
    VideoViewVideoHolder.VideoStartSegment.a(this.a.a, new ErrorMessage(0, "onPrepared, is not on foreground"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoStartSegment.1.1
 * JD-Core Version:    0.7.0.1
 */