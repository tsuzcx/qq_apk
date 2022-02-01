package com.tencent.liteav.basic.opengl;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;

class i$1$1
  implements Runnable
{
  i$1$1(i.1 param1) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.removeCallbacksAndMessages(null);
    }
    if (this.a.b != null)
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        this.a.b.quitSafely();
        return;
      }
      this.a.b.quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.i.1.1
 * JD-Core Version:    0.7.0.1
 */