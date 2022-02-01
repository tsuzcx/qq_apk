package com.tencent.liteav;

import android.os.Handler;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.n;
import com.tencent.liteav.capturer.a;

class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public void run()
  {
    try
    {
      if ((this.a.d()) && (c.b(this.a)) && (c.c(this.a).l() == null))
      {
        TXCLog.w("CameraCapture", "camera monitor restart capture");
        c.c(this.a).g();
        c.d(this.a).a(false);
        c.c(this.a).a(c.a(this.a).i);
        c.c(this.a).a(c.a(this.a).X, c.a(this.a).a, c.a(this.a).b);
        c.c(this.a).a(c.d(this.a).getSurfaceTexture());
        c.c(this.a).d(c.a(this.a).n);
        return;
      }
      if (c.e(this.a) == null) {
        break label200;
      }
      c.e(this.a).postDelayed(this, 2000L);
      return;
    }
    catch (Exception localException)
    {
      label193:
      label200:
      break label193;
    }
    TXCLog.w("CameraCapture", "camera monitor exception ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.c.2
 * JD-Core Version:    0.7.0.1
 */