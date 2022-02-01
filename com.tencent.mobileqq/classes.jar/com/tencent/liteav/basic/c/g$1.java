package com.tencent.liteav.basic.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

final class g$1
  implements Runnable
{
  g$1(Handler paramHandler, HandlerThread paramHandlerThread) {}
  
  public void run()
  {
    new Handler(Looper.getMainLooper()).post(new g.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.c.g.1
 * JD-Core Version:    0.7.0.1
 */