package com.tencent.liteav.basic.opengl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;

public class i
  extends f
{
  public int a = 720;
  public int b = 1280;
  public Surface c = null;
  public boolean d = false;
  public c e = null;
  public android.opengl.EGLContext f = null;
  public b g = null;
  public javax.microedition.khronos.egl.EGLContext h = null;
  private i.a i = null;
  
  public i(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static void a(Handler paramHandler, HandlerThread paramHandlerThread)
  {
    if (paramHandler != null)
    {
      if (paramHandlerThread == null) {
        return;
      }
      Message localMessage = new Message();
      localMessage.what = 101;
      localMessage.obj = new i.1(paramHandler, paramHandlerThread);
      paramHandler.sendMessage(localMessage);
    }
  }
  
  private void a(Message paramMessage)
  {
    try
    {
      e();
      return;
    }
    catch (Exception paramMessage)
    {
      label6:
      break label6;
    }
    paramMessage = new StringBuilder();
    paramMessage.append("surface-render: init egl context exception ");
    paramMessage.append(this.c);
    TXCLog.e("TXGLThreadHandler", paramMessage.toString());
    this.c = null;
  }
  
  private void b(Message paramMessage)
  {
    f();
  }
  
  private void c(Message paramMessage)
  {
    try
    {
      if (this.i != null)
      {
        this.i.d();
        return;
      }
    }
    catch (Exception paramMessage)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMsgRend Exception ");
      localStringBuilder.append(paramMessage.getMessage());
      TXCLog.e("TXGLThreadHandler", localStringBuilder.toString());
    }
  }
  
  private boolean e()
  {
    TXCLog.i("TXGLThreadHandler", String.format("init egl size[%d/%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    if (!this.d) {
      this.g = b.a(null, this.h, this.c, this.a, this.b);
    } else {
      this.e = c.a(null, this.f, this.c, this.a, this.b);
    }
    if ((this.g == null) && (this.e == null)) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("surface-render: create egl context ");
    ((StringBuilder)localObject).append(this.c);
    TXCLog.w("TXGLThreadHandler", ((StringBuilder)localObject).toString());
    localObject = this.i;
    if (localObject != null) {
      ((i.a)localObject).c();
    }
    return true;
  }
  
  private void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("surface-render: destroy egl context ");
    ((StringBuilder)localObject).append(this.c);
    TXCLog.w("TXGLThreadHandler", ((StringBuilder)localObject).toString());
    this.d = false;
    localObject = this.i;
    if (localObject != null) {
      ((i.a)localObject).e();
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((b)localObject).c();
      this.g = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((c)localObject).d();
      this.e = null;
    }
    this.c = null;
  }
  
  public javax.microedition.khronos.egl.EGLContext a()
  {
    b localb = this.g;
    if (localb != null) {
      return localb.d();
    }
    return null;
  }
  
  public void a(i.a parama)
  {
    this.i = parama;
  }
  
  public Surface b()
  {
    return this.c;
  }
  
  public void c()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((b)localObject).a();
    }
    localObject = this.e;
    if (localObject != null) {
      ((c)localObject).e();
    }
  }
  
  public void d()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((b)localObject).b();
    }
    localObject = this.e;
    if (localObject != null) {
      ((c)localObject).b();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      break;
    case 102: 
      c(paramMessage);
      break;
    case 101: 
      b(paramMessage);
      break;
    case 100: 
      a(paramMessage);
    }
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      ((Runnable)paramMessage.obj).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.i
 * JD-Core Version:    0.7.0.1
 */