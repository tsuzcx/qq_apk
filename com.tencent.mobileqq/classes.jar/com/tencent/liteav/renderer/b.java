package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

class b
  extends Thread
{
  private WeakReference<a> a;
  private boolean b = false;
  private int c = 1280;
  private int d = 720;
  private Object e = new Object();
  private c f = null;
  private com.tencent.liteav.basic.c.b g = null;
  private Object h = null;
  
  b(WeakReference<a> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  private void f()
  {
    try
    {
      a locala = (a)this.a.get();
      if (locala != null)
      {
        locala.a(this);
        return;
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCVideoRenderThread", "init texture render failed.", localException);
    }
  }
  
  private void g()
  {
    try
    {
      a locala = (a)this.a.get();
      if (locala != null)
      {
        locala.b(this);
        return;
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCVideoRenderThread", "destroy texture render failed", localException);
    }
  }
  
  private boolean h()
  {
    try
    {
      if (this.a != null)
      {
        a locala = (a)this.a.get();
        if (locala != null)
        {
          boolean bool = locala.c();
          return bool;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("drawFrame failed.");
      localStringBuilder.append(localException.getMessage());
      TXCLog.e("TXCVideoRenderThread", localStringBuilder.toString());
    }
    return false;
  }
  
  private void i()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null) {
        ((a)localObject).k();
      }
    }
  }
  
  private void j()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null) {
        ((a)localObject).l();
      }
    }
  }
  
  private void k()
  {
    Object localObject1 = (a)this.a.get();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((a)localObject1).d();
    if (localObject1 != null) {
      localObject1 = new Surface((SurfaceTexture)localObject1);
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.h;
    if ((localObject2 != null) && (!(localObject2 instanceof javax.microedition.khronos.egl.EGLContext))) {
      this.f = c.a(null, (android.opengl.EGLContext)localObject2, (Surface)localObject1, this.c, this.d);
    } else {
      this.g = com.tencent.liteav.basic.c.b.a(null, (javax.microedition.khronos.egl.EGLContext)this.h, (Surface)localObject1, this.c, this.d);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vrender: init egl share context ");
    ((StringBuilder)localObject1).append(this.h);
    ((StringBuilder)localObject1).append(", create context");
    ((StringBuilder)localObject1).append(a());
    TXCLog.w("TXCVideoRenderThread", ((StringBuilder)localObject1).toString());
    e();
  }
  
  private void l()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("vrender: uninit egl ");
    ((StringBuilder)localObject).append(a());
    TXCLog.w("TXCVideoRenderThread", ((StringBuilder)localObject).toString());
    localObject = this.g;
    if (localObject != null)
    {
      ((com.tencent.liteav.basic.c.b)localObject).c();
      this.g = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((c)localObject).c();
      this.f = null;
    }
  }
  
  public Object a()
  {
    Object localObject = this.g;
    if (localObject != null) {
      return ((com.tencent.liteav.basic.c.b)localObject).d();
    }
    localObject = this.f;
    if (localObject != null) {
      return ((c)localObject).e();
    }
    return null;
  }
  
  public void a(Object paramObject)
  {
    this.h = paramObject;
  }
  
  public void b()
  {
    this.b = false;
    c();
  }
  
  public void c()
  {
    synchronized (this.e)
    {
      this.e.notifyAll();
      return;
    }
  }
  
  public void d()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((com.tencent.liteav.basic.c.b)localObject).a();
    }
    localObject = this.f;
    if (localObject != null) {
      ((c)localObject).d();
    }
  }
  
  public void e()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((com.tencent.liteav.basic.c.b)localObject).b();
    }
    localObject = this.f;
    if (localObject != null) {
      ((c)localObject).b();
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 77	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 165
    //   11: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 169	com/tencent/liteav/renderer/b:getId	()J
    //   20: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 176	com/tencent/liteav/renderer/b:setName	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 26	com/tencent/liteav/renderer/b:b	Z
    //   37: aload_0
    //   38: invokespecial 177	com/tencent/liteav/renderer/b:k	()V
    //   41: aload_0
    //   42: invokespecial 179	com/tencent/liteav/renderer/b:f	()V
    //   45: aload_0
    //   46: invokespecial 181	com/tencent/liteav/renderer/b:i	()V
    //   49: aload_0
    //   50: getfield 26	com/tencent/liteav/renderer/b:b	Z
    //   53: ifeq +78 -> 131
    //   56: aload_0
    //   57: invokespecial 183	com/tencent/liteav/renderer/b:h	()Z
    //   60: ifeq +41 -> 101
    //   63: aload_0
    //   64: getfield 43	com/tencent/liteav/renderer/b:a	Ljava/lang/ref/WeakReference;
    //   67: ifnonnull +8 -> 75
    //   70: aconst_null
    //   71: astore_1
    //   72: goto +14 -> 86
    //   75: aload_0
    //   76: getfield 43	com/tencent/liteav/renderer/b:a	Ljava/lang/ref/WeakReference;
    //   79: invokevirtual 54	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   82: checkcast 56	com/tencent/liteav/renderer/a
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +14 -> 101
    //   90: aload_1
    //   91: invokevirtual 105	com/tencent/liteav/renderer/a:d	()Landroid/graphics/SurfaceTexture;
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 185	com/tencent/liteav/renderer/b:d	()V
    //   101: aload_0
    //   102: getfield 35	com/tencent/liteav/renderer/b:e	Ljava/lang/Object;
    //   105: astore_1
    //   106: aload_1
    //   107: monitorenter
    //   108: aload_0
    //   109: getfield 35	com/tencent/liteav/renderer/b:e	Ljava/lang/Object;
    //   112: invokevirtual 188	java/lang/Object:wait	()V
    //   115: goto +7 -> 122
    //   118: astore_2
    //   119: goto +8 -> 127
    //   122: aload_1
    //   123: monitorexit
    //   124: goto -75 -> 49
    //   127: aload_1
    //   128: monitorexit
    //   129: aload_2
    //   130: athrow
    //   131: aload_0
    //   132: invokespecial 190	com/tencent/liteav/renderer/b:j	()V
    //   135: aload_0
    //   136: invokespecial 192	com/tencent/liteav/renderer/b:g	()V
    //   139: aload_0
    //   140: invokespecial 193	com/tencent/liteav/renderer/b:l	()V
    //   143: return
    //   144: astore_1
    //   145: goto +13 -> 158
    //   148: astore_1
    //   149: ldc 61
    //   151: ldc 195
    //   153: aload_1
    //   154: invokestatic 68	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   157: return
    //   158: goto +5 -> 163
    //   161: aload_1
    //   162: athrow
    //   163: goto -2 -> 161
    //   166: astore_2
    //   167: goto -45 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	b
    //   144	1	1	localObject2	Object
    //   148	14	1	localException	Exception
    //   118	12	2	localObject3	Object
    //   166	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   108	115	118	finally
    //   122	124	118	finally
    //   127	129	118	finally
    //   32	49	144	finally
    //   49	70	144	finally
    //   75	86	144	finally
    //   90	101	144	finally
    //   101	108	144	finally
    //   129	131	144	finally
    //   131	143	144	finally
    //   149	157	144	finally
    //   32	49	148	java/lang/Exception
    //   49	70	148	java/lang/Exception
    //   75	86	148	java/lang/Exception
    //   90	101	148	java/lang/Exception
    //   101	108	148	java/lang/Exception
    //   129	131	148	java/lang/Exception
    //   131	143	148	java/lang/Exception
    //   108	115	166	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.b
 * JD-Core Version:    0.7.0.1
 */