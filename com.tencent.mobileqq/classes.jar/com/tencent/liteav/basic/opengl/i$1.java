package com.tencent.liteav.basic.opengl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

final class i$1
  implements Runnable
{
  i$1(Handler paramHandler, HandlerThread paramHandlerThread) {}
  
  public void run()
  {
    new Handler(Looper.getMainLooper()).post(new i.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.i.1
 * JD-Core Version:    0.7.0.1
 */