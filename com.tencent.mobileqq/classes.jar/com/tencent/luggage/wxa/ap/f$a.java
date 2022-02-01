package com.tencent.luggage.wxa.ap;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

final class f$a
  implements Handler.Callback, Choreographer.FrameCallback
{
  private static final a b = new a();
  public volatile long a;
  private final Handler c;
  private final HandlerThread d = new HandlerThread("ChoreographerOwner:Handler");
  private Choreographer e;
  private int f;
  
  private f$a()
  {
    this.d.start();
    this.c = new Handler(this.d.getLooper(), this);
    this.c.sendEmptyMessage(0);
  }
  
  public static a a()
  {
    return b;
  }
  
  private void d()
  {
    this.e = Choreographer.getInstance();
  }
  
  private void e()
  {
    this.f += 1;
    if (this.f == 1) {
      this.e.postFrameCallback(this);
    }
  }
  
  private void f()
  {
    this.f -= 1;
    if (this.f == 0)
    {
      this.e.removeFrameCallback(this);
      this.a = 0L;
    }
  }
  
  public void b()
  {
    this.c.sendEmptyMessage(1);
  }
  
  public void c()
  {
    this.c.sendEmptyMessage(2);
  }
  
  public void doFrame(long paramLong)
  {
    this.a = paramLong;
    this.e.postFrameCallbackDelayed(this, 500L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        f();
        return true;
      }
      e();
      return true;
    }
    d();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ap.f.a
 * JD-Core Version:    0.7.0.1
 */