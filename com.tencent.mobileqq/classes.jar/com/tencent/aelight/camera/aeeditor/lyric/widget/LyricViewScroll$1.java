package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

class LyricViewScroll$1
  extends Handler
{
  int jdField_a_of_type_Int;
  
  LyricViewScroll$1(LyricViewScroll paramLyricViewScroll) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll;
      paramMessage.jdField_b_of_type_Boolean = true;
      if (LyricViewScroll.a(paramMessage) != null) {
        LyricViewScroll.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll).b();
      }
    }
    else if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll.getScrollY())
    {
      paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll;
      paramMessage.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      if (LyricViewScroll.a(paramMessage) != null) {
        LyricViewScroll.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll).b(this.jdField_a_of_type_Int);
      }
      Log.d("LyricViewScroll", "fling stop");
      LyricViewScroll.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll, false);
      LyricViewScroll.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll).sendEmptyMessageDelayed(2, this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll.jdField_b_of_type_Int);
      paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll;
      paramMessage.jdField_b_of_type_Boolean = false;
      if (LyricViewScroll.a(paramMessage) != null) {
        LyricViewScroll.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll).a();
      }
    }
    else
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll.getScrollY();
      if (LyricViewScroll.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll) != null) {
        LyricViewScroll.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll).a(this.jdField_a_of_type_Int);
      }
      LyricViewScroll.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll).sendEmptyMessageDelayed(1, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewScroll.1
 * JD-Core Version:    0.7.0.1
 */