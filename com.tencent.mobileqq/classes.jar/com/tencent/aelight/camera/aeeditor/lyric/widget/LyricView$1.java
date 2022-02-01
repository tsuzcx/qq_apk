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
    if ((Math.abs(this.a.j.x - this.a.i.x) < 15.0F) && (Math.abs(this.a.j.y - this.a.i.y) < 15.0F) && (this.a.h != null))
    {
      paramMessage = this.a;
      paramMessage.m = true;
      paramMessage.h.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricView.1
 * JD-Core Version:    0.7.0.1
 */