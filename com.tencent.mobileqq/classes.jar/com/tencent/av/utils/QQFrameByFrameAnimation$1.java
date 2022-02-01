package com.tencent.av.utils;

import android.os.Handler;

class QQFrameByFrameAnimation$1
  implements Runnable
{
  QQFrameByFrameAnimation$1(QQFrameByFrameAnimation paramQQFrameByFrameAnimation) {}
  
  public void run()
  {
    if ((this.this$0.g > 0) && (this.this$0.f >= this.this$0.g))
    {
      this.this$0.c();
      return;
    }
    if ((this.this$0.e > 0) && (this.this$0.f / this.this$0.c.length >= this.this$0.e))
    {
      this.this$0.c();
      return;
    }
    this.this$0.a();
    this.this$0.h.postDelayed(this, this.this$0.d);
    if (this.this$0.b != null)
    {
      this.this$0.b.c();
      if ((this.this$0.c.length > 0) && (this.this$0.f % this.this$0.c.length == 0)) {
        this.this$0.b.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QQFrameByFrameAnimation.1
 * JD-Core Version:    0.7.0.1
 */