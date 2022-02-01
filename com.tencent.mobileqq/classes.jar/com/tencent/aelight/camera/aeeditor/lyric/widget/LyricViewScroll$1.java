package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

class LyricViewScroll$1
  extends Handler
{
  int a;
  
  LyricViewScroll$1(LyricViewScroll paramLyricViewScroll) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      paramMessage = this.b;
      paramMessage.d = true;
      if (LyricViewScroll.c(paramMessage) != null) {
        LyricViewScroll.c(this.b).b();
      }
    }
    else if (this.a == this.b.getScrollY())
    {
      paramMessage = this.b;
      paramMessage.a = this.a;
      if (LyricViewScroll.a(paramMessage) != null) {
        LyricViewScroll.a(this.b).b(this.a);
      }
      Log.d("LyricViewScroll", "fling stop");
      LyricViewScroll.a(this.b, false);
      LyricViewScroll.b(this.b).sendEmptyMessageDelayed(2, this.b.e);
      paramMessage = this.b;
      paramMessage.d = false;
      if (LyricViewScroll.c(paramMessage) != null) {
        LyricViewScroll.c(this.b).a();
      }
    }
    else
    {
      this.a = this.b.getScrollY();
      if (LyricViewScroll.a(this.b) != null) {
        LyricViewScroll.a(this.b).a(this.a);
      }
      LyricViewScroll.b(this.b).sendEmptyMessageDelayed(1, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewScroll.1
 * JD-Core Version:    0.7.0.1
 */