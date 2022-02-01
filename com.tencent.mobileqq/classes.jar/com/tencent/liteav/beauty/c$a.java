package com.tencent.liteav.beauty;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.m;

class c$a
  extends Handler
{
  private String b = "EGLDrawThreadHandler";
  
  c$a(c paramc, Looper paramLooper, Context paramContext)
  {
    super(paramLooper);
  }
  
  private void a(Object paramObject)
  {
    TXCLog.i(this.b, "come into InitEGL");
    paramObject = (d.b)paramObject;
    a();
    c.a(this.a, new com.tencent.liteav.beauty.a.a.a());
    c localc = this.a;
    c.a(localc, new com.tencent.liteav.beauty.a.a.c(c.m(localc), paramObject.g, paramObject.f, false));
    c.n(this.a).b();
    if (!c.a(this.a, paramObject))
    {
      TXCLog.e(this.b, "initInternal failed!");
      return;
    }
    TXCLog.i(this.b, "come out InitEGL");
  }
  
  public void a()
  {
    TXCLog.i(this.b, "come into releaseEGL");
    if ((c.o(this.a) != null) && (c.o(this.a)[0] > 0))
    {
      GLES20.glDeleteBuffers(1, c.o(this.a), 0);
      c.a(this.a, null);
    }
    c.p(this.a);
    if (c.n(this.a) != null)
    {
      c.n(this.a).c();
      c.a(this.a, null);
    }
    if (c.m(this.a) != null)
    {
      c.m(this.a).a();
      c.a(this.a, null);
    }
    c.b(this.a, false);
    NativeLoad.getInstance();
    NativeLoad.nativeDeleteYuv2Yuv();
    TXCLog.i(this.b, "come out releaseEGL");
  }
  
  void b()
  {
    try
    {
      try
      {
        wait();
      }
      finally
      {
        break label16;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label13:
      label16:
      break label13;
    }
    return;
    throw localObject;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                paramMessage = (d.b)paramMessage.obj;
                c.b(this.a, paramMessage);
              }
            }
            else
            {
              c localc = this.a;
              double d = paramMessage.arg1;
              Double.isNaN(d);
              c.a(localc, (float)(d / 100.0D));
              if (c.a(this.a) != null) {
                c.a(this.a).a(c.q(this.a));
              }
            }
          }
          else
          {
            c.b(this.a, paramMessage.arg1);
            break label200;
          }
        }
        else {
          c.a(this.a, (byte[])paramMessage.obj);
        }
      }
      else
      {
        a();
        this.a.d.a();
      }
      i = 0;
      break label203;
    }
    else
    {
      a(paramMessage.obj);
      c.b(this.a, true);
    }
    label200:
    i = 1;
    label203:
    if (1 == i) {}
    try
    {
      notify();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.c.a
 * JD-Core Version:    0.7.0.1
 */