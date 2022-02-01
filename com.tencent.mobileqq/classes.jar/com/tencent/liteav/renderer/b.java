package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.c;
import com.tencent.liteav.basic.util.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.Semaphore;

class b
  extends Thread
{
  private WeakReference<a> a;
  private volatile boolean b = false;
  private int c = 1280;
  private int d = 720;
  private final Semaphore e = new Semaphore(0);
  private c f = null;
  private com.tencent.liteav.basic.opengl.b g = null;
  private Object h = null;
  
  b(WeakReference<a> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.a != null)
      {
        a locala = (a)this.a.get();
        if (locala != null)
        {
          boolean bool = locala.b(paramInt1, paramInt2);
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
  
  private e f()
  {
    Object localObject = this.g;
    if (localObject != null) {
      return ((com.tencent.liteav.basic.opengl.b)localObject).f();
    }
    localObject = this.f;
    if (localObject != null) {
      return ((c)localObject).c();
    }
    TXCOpenGlUtils.a("getSurfaceSize");
    return new e(0, 0);
  }
  
  private void g()
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
  
  private void h()
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
  
  private void i()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null) {
        ((a)localObject).j();
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
        ((a)localObject).k();
      }
    }
  }
  
  private void k()
  {
    Object localObject1 = (a)this.a.get();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((a)localObject1).c();
    if (localObject1 != null) {
      localObject1 = new Surface((SurfaceTexture)localObject1);
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.h;
    if ((localObject2 != null) && (!(localObject2 instanceof javax.microedition.khronos.egl.EGLContext))) {
      this.f = c.a(null, (android.opengl.EGLContext)localObject2, (Surface)localObject1, this.c, this.d);
    } else {
      this.g = com.tencent.liteav.basic.opengl.b.a(null, (javax.microedition.khronos.egl.EGLContext)this.h, (Surface)localObject1, this.c, this.d);
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
      ((com.tencent.liteav.basic.opengl.b)localObject).c();
      this.g = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((c)localObject).d();
      this.f = null;
    }
  }
  
  public Object a()
  {
    Object localObject = this.g;
    if (localObject != null) {
      return ((com.tencent.liteav.basic.opengl.b)localObject).d();
    }
    localObject = this.f;
    if (localObject != null) {
      return ((c)localObject).f();
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
    this.e.release();
  }
  
  public void d()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((com.tencent.liteav.basic.opengl.b)localObject).a();
    }
    localObject = this.f;
    if (localObject != null) {
      ((c)localObject).e();
    }
  }
  
  public void e()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((com.tencent.liteav.basic.opengl.b)localObject).b();
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
    //   0: new 64	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 185
    //   11: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 189	com/tencent/liteav/renderer/b:getId	()J
    //   20: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 195	com/tencent/liteav/renderer/b:setName	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 27	com/tencent/liteav/renderer/b:b	Z
    //   37: aload_0
    //   38: invokespecial 196	com/tencent/liteav/renderer/b:k	()V
    //   41: aload_0
    //   42: invokespecial 198	com/tencent/liteav/renderer/b:g	()V
    //   45: aload_0
    //   46: invokespecial 200	com/tencent/liteav/renderer/b:i	()V
    //   49: aload_0
    //   50: getfield 27	com/tencent/liteav/renderer/b:b	Z
    //   53: ifeq +87 -> 140
    //   56: aload_0
    //   57: invokespecial 201	com/tencent/liteav/renderer/b:f	()Lcom/tencent/liteav/basic/util/e;
    //   60: astore_1
    //   61: aload_0
    //   62: aload_1
    //   63: getfield 203	com/tencent/liteav/basic/util/e:a	I
    //   66: aload_1
    //   67: getfield 205	com/tencent/liteav/basic/util/e:b	I
    //   70: invokespecial 207	com/tencent/liteav/renderer/b:a	(II)Z
    //   73: ifeq +41 -> 114
    //   76: aload_0
    //   77: getfield 46	com/tencent/liteav/renderer/b:a	Ljava/lang/ref/WeakReference;
    //   80: ifnonnull +8 -> 88
    //   83: aconst_null
    //   84: astore_1
    //   85: goto +14 -> 99
    //   88: aload_0
    //   89: getfield 46	com/tencent/liteav/renderer/b:a	Ljava/lang/ref/WeakReference;
    //   92: invokevirtual 58	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   95: checkcast 60	com/tencent/liteav/renderer/a
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +14 -> 114
    //   103: aload_1
    //   104: invokevirtual 128	com/tencent/liteav/renderer/a:c	()Landroid/graphics/SurfaceTexture;
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 208	com/tencent/liteav/renderer/b:d	()V
    //   114: aload_0
    //   115: getfield 27	com/tencent/liteav/renderer/b:b	Z
    //   118: ifeq -69 -> 49
    //   121: aload_0
    //   122: getfield 38	com/tencent/liteav/renderer/b:e	Ljava/util/concurrent/Semaphore;
    //   125: ldc2_w 209
    //   128: getstatic 216	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   131: invokevirtual 220	java/util/concurrent/Semaphore:tryAcquire	(JLjava/util/concurrent/TimeUnit;)Z
    //   134: ifne -85 -> 49
    //   137: goto -23 -> 114
    //   140: aload_0
    //   141: invokespecial 221	com/tencent/liteav/renderer/b:j	()V
    //   144: aload_0
    //   145: invokespecial 223	com/tencent/liteav/renderer/b:h	()V
    //   148: aload_0
    //   149: invokespecial 225	com/tencent/liteav/renderer/b:l	()V
    //   152: return
    //   153: astore_1
    //   154: goto +13 -> 167
    //   157: astore_1
    //   158: ldc 77
    //   160: ldc 227
    //   162: aload_1
    //   163: invokestatic 114	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   166: return
    //   167: goto +5 -> 172
    //   170: aload_1
    //   171: athrow
    //   172: goto -2 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	b
    //   7	97	1	localObject1	Object
    //   153	1	1	localObject2	Object
    //   157	14	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   32	49	153	finally
    //   49	83	153	finally
    //   88	99	153	finally
    //   103	114	153	finally
    //   114	137	153	finally
    //   140	152	153	finally
    //   158	166	153	finally
    //   32	49	157	java/lang/Exception
    //   49	83	157	java/lang/Exception
    //   88	99	157	java/lang/Exception
    //   103	114	157	java/lang/Exception
    //   114	137	157	java/lang/Exception
    //   140	152	157	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.b
 * JD-Core Version:    0.7.0.1
 */