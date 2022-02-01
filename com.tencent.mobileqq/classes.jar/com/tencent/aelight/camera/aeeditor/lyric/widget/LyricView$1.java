package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Message;

class LyricView$1
  extends Handler
{
  LyricView$1(LyricView paramLyricView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10) {
      return;
    }
    if ((Math.abs(this.a.b.x - this.a.jdField_a_of_type_AndroidGraphicsPointF.x) < 15.0F) && (Math.abs(this.a.b.y - this.a.jdField_a_of_type_AndroidGraphicsPointF.y) < 15.0F) && (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricView$OnLyricViewLongClickListener != null))
    {
      paramMessage = this.a;
      paramMessage.e = true;
      paramMessage.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricView$OnLyricViewLongClickListener.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricView.1
 * JD-Core Version:    0.7.0.1
 */