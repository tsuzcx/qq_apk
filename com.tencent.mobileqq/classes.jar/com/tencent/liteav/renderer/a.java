package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

public class a
  extends e
  implements SurfaceTexture.OnFrameAvailableListener
{
  private c A;
  private TXSVideoFrame B;
  private TXCYuvTextureRender C;
  private Object D = null;
  private Object E = new Object();
  private h F;
  private TXCYuvTextureRender G;
  private final Queue<Runnable> H = new LinkedList();
  g a;
  a.a b;
  a.a c;
  private final int q = 0;
  private final int r = 0;
  private final int s = 0;
  private final int t = 0;
  private Object u = new Object();
  private b v;
  private SurfaceTexture w;
  private c x;
  private boolean y;
  private float[] z = new float[16];
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null) {
        return false;
      }
      localRunnable.run();
      return true;
    }
    finally {}
  }
  
  private void o()
  {
    this.x = new c(true);
    this.C = new TXCYuvTextureRender();
    this.A = new c(false);
  }
  
  private boolean p()
  {
    try
    {
      boolean bool;
      Object localObject3;
      if (this.y)
      {
        bool = this.y;
        this.y = false;
        localObject3 = null;
      }
      else
      {
        if (this.B == null) {
          break label585;
        }
        localObject3 = this.B;
        this.B = null;
        bool = false;
      }
      GLES20.glViewport(0, 0, g(), h());
      Object localObject1;
      if (this.l == 1) {
        localObject1 = b();
      } else {
        localObject1 = null;
      }
      a.a locala = this.c;
      Object localObject4;
      int i;
      if (bool)
      {
        localObject3 = this.w;
        if (localObject3 != null)
        {
          ((SurfaceTexture)localObject3).updateTexImage();
          this.w.getTransformMatrix(this.z);
        }
        localObject3 = this.a;
        if (localObject3 != null)
        {
          localObject4 = this.x;
          if (localObject4 != null) {
            ((g)localObject3).a(((c)localObject4).a(), this.z);
          }
        }
        else if (this.x != null)
        {
          GLES20.glBindFramebuffer(36160, 0);
          this.x.a(this.w);
        }
        if (locala != null)
        {
          i = this.x.a();
          if (this.F == null)
          {
            this.F = new h(Boolean.valueOf(true));
            this.F.b();
            this.F.a(true);
            this.F.b(180);
            this.F.a(h.a);
          }
          this.F.a(this.z);
          this.F.b(this.h, this.i);
          this.F.a(this.h, this.i);
          locala.onTextureProcess(this.F.d(i), i(), j(), this.k);
        }
        if (this.l == 1)
        {
          localObject3 = this.x;
          if (localObject3 != null)
          {
            a(localObject1, ((c)localObject3).a(), this.z, true);
            return true;
          }
        }
      }
      else if (localObject3 != null)
      {
        localObject4 = this.C;
        if (localObject4 != null)
        {
          if (this.b != null)
          {
            ((TXCYuvTextureRender)localObject4).setHasFrameBuffer(this.h, this.i);
            i = this.C.drawToTexture((TXSVideoFrame)localObject3);
            this.b.onTextureProcess(i, i(), j(), this.k);
          }
          else
          {
            if (this.l == 0)
            {
              GLES20.glBindFramebuffer(36160, 0);
              this.C.drawFrame((TXSVideoFrame)localObject3);
            }
            i = -1;
          }
          if (this.l == 1)
          {
            int j = i;
            if (i == -1)
            {
              this.C.setHasFrameBuffer(this.h, this.i);
              j = this.C.drawToTexture((TXSVideoFrame)localObject3);
            }
            a(localObject1, j, null, false);
          }
          if (locala != null)
          {
            if (this.G == null)
            {
              this.G = new TXCYuvTextureRender();
              this.G.createTexture();
              this.G.flipVertical(false);
            }
            this.G.setHasFrameBuffer(this.h, this.i);
            locala.onTextureProcess(this.G.drawToTexture((TXSVideoFrame)localObject3), i(), j(), this.k);
          }
        }
      }
      return true;
      label585:
      return false;
    }
    finally {}
  }
  
  public SurfaceTexture a()
  {
    return this.w;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject = this.C;
    if (localObject != null) {
      ((TXCYuvTextureRender)localObject).setVideoSize(paramInt1, paramInt2);
    }
    localObject = this.x;
    if (localObject != null) {
      ((c)localObject).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    GLES20.glViewport(0, 0, g(), h());
    ??? = this.A;
    if (??? != null) {
      ((c)???).a(paramInt1, paramBoolean, paramInt4);
    }
    super.a(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
    synchronized (this.u)
    {
      if (this.v != null) {
        this.v.c();
      }
      return;
    }
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture)
  {
    super.a(paramSurfaceTexture);
    TXCLog.w("TXCVideoRender", "play:vrender: create render thread when onSurfaceCreate");
    c(null);
  }
  
  /* Error */
  public void a(TXSVideoFrame arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 108	com/tencent/liteav/renderer/a:B	Lcom/tencent/liteav/basic/structs/TXSVideoFrame;
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 108	com/tencent/liteav/renderer/a:B	Lcom/tencent/liteav/basic/structs/TXSVideoFrame;
    //   13: invokevirtual 269	com/tencent/liteav/basic/structs/TXSVideoFrame:release	()V
    //   16: aload_0
    //   17: aload_1
    //   18: putfield 108	com/tencent/liteav/renderer/a:B	Lcom/tencent/liteav/basic/structs/TXSVideoFrame;
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_0
    //   24: aload_1
    //   25: iload_2
    //   26: iload_3
    //   27: iload 4
    //   29: invokespecial 271	com/tencent/liteav/renderer/e:a	(Lcom/tencent/liteav/basic/structs/TXSVideoFrame;III)V
    //   32: aload_0
    //   33: getfield 58	com/tencent/liteav/renderer/a:u	Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 246	com/tencent/liteav/renderer/a:v	Lcom/tencent/liteav/renderer/b;
    //   43: ifnull +10 -> 53
    //   46: aload_0
    //   47: getfield 246	com/tencent/liteav/renderer/a:v	Lcom/tencent/liteav/renderer/b;
    //   50: invokevirtual 250	com/tencent/liteav/renderer/b:c	()V
    //   53: aload_1
    //   54: monitorexit
    //   55: return
    //   56: astore 5
    //   58: aload_1
    //   59: monitorexit
    //   60: aload 5
    //   62: athrow
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	a
    //   0	68	2	paramInt1	int
    //   0	68	3	paramInt2	int
    //   0	68	4	paramInt3	int
    //   56	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   39	53	56	finally
    //   53	55	56	finally
    //   58	60	56	finally
    //   2	16	63	finally
    //   16	23	63	finally
    //   64	66	63	finally
  }
  
  public void a(a.a parama)
  {
    this.b = parama;
    if (parama != null)
    {
      parama = this.C;
      if (parama != null) {
        parama.setHasFrameBuffer(this.h, this.i);
      }
    }
  }
  
  public void a(g paramg)
  {
    this.a = paramg;
  }
  
  void a(Object paramObject)
  {
    synchronized (this.E)
    {
      this.D = paramObject;
      paramObject = new StringBuilder();
      paramObject.append("play:vrender: TXCGLRender initTextureRender ");
      paramObject.append(this);
      TXCLog.w("TXCVideoRender", paramObject.toString());
      o();
      if (this.e != null)
      {
        this.e.a(this.f, this.g);
        this.e.b(this.h, this.i);
      }
      if (this.x != null)
      {
        this.x.b();
        this.w = new SurfaceTexture(this.x.a());
        this.w.setOnFrameAvailableListener(this);
      }
      if (this.C != null) {
        this.C.createTexture();
      }
      if ((this.b != null) && (this.C != null)) {
        this.C.setHasFrameBuffer(this.h, this.i);
      }
      if (this.A != null) {
        this.A.b();
      }
      if (this.o != null) {
        this.o.onSurfaceTextureAvailable(this.w);
      }
      return;
    }
  }
  
  public Object b()
  {
    for (;;)
    {
      synchronized (this.u)
      {
        if (this.v != null)
        {
          Object localObject1 = this.v.a();
          return localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture)
  {
    super.b(paramSurfaceTexture);
    TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when onSurfaceRelease");
    e();
  }
  
  public void b(a.a parama)
  {
    this.c = parama;
    if (parama != null)
    {
      parama = this.C;
      if (parama != null) {
        parama.setHasFrameBuffer(this.h, this.i);
      }
    }
  }
  
  void b(Object paramObject)
  {
    synchronized (this.E)
    {
      if (this.D != paramObject)
      {
        paramObject = new StringBuilder();
        paramObject.append("play:vrender: TXCGLRender destroyTextureRender ignore when not the same gl thread ");
        paramObject.append(this);
        TXCLog.w("TXCVideoRender", paramObject.toString());
        return;
      }
      this.D = null;
      paramObject = new StringBuilder();
      paramObject.append("play:vrender: TXCGLRender destroyTextureRender ");
      paramObject.append(this);
      TXCLog.w("TXCVideoRender", paramObject.toString());
      try
      {
        if (this.o != null) {
          this.o.onSurfaceTextureDestroy(this.w);
        }
      }
      catch (Exception paramObject)
      {
        TXCLog.e("TXCVideoRender", "callback failed.", paramObject);
      }
      if (this.x != null)
      {
        this.x.c();
        this.x = null;
      }
      if (this.C != null)
      {
        this.C.onSurfaceDestroy();
        this.C = null;
      }
      if (this.A != null)
      {
        this.A.c();
        this.A = null;
      }
      this.w = null;
      if (this.F != null)
      {
        this.F.c();
        this.F = null;
      }
      if (this.G != null)
      {
        this.G.onSurfaceDestroy();
        this.G = null;
      }
      return;
    }
  }
  
  public void c(Object paramObject)
  {
    synchronized (this.u)
    {
      if (this.v == null)
      {
        this.v = new b(new WeakReference(this));
        this.v.a(paramObject);
        this.v.start();
        this.v.c();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("play:vrender: start render thread id ");
        localStringBuilder.append(getID());
        localStringBuilder.append(", glContext ");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(", ");
        localStringBuilder.append(this);
        TXCLog.w("TXCVideoRender", localStringBuilder.toString());
      }
      else
      {
        paramObject = new StringBuilder();
        paramObject.append("play:vrender: start render thread when running ");
        paramObject.append(getID());
        paramObject.append(", ");
        paramObject.append(this);
        TXCLog.w("TXCVideoRender", paramObject.toString());
      }
      return;
    }
  }
  
  boolean c()
  {
    while (a(this.H)) {}
    return p();
  }
  
  SurfaceTexture d()
  {
    if (this.d != null) {
      return this.d.getSurfaceTexture();
    }
    return null;
  }
  
  public void e()
  {
    synchronized (this.u)
    {
      if (this.v != null)
      {
        this.v.b();
        this.v.c();
        this.v = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("play:vrender: quit render thread id");
        localStringBuilder.append(getID());
        localStringBuilder.append(", ");
        localStringBuilder.append(this);
        TXCLog.w("TXCVideoRender", localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void finalize()
  {
    super.finalize();
    TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when finalize");
    try
    {
      e();
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCVideoRender", "quit render thread failed.", localException);
    }
  }
  
  /* Error */
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 106	com/tencent/liteav/renderer/a:y	Z
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: getfield 58	com/tencent/liteav/renderer/a:u	Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 246	com/tencent/liteav/renderer/a:v	Lcom/tencent/liteav/renderer/b;
    //   20: ifnull +10 -> 30
    //   23: aload_0
    //   24: getfield 246	com/tencent/liteav/renderer/a:v	Lcom/tencent/liteav/renderer/b;
    //   27: invokevirtual 250	com/tencent/liteav/renderer/b:c	()V
    //   30: aload_1
    //   31: monitorexit
    //   32: return
    //   33: astore_2
    //   34: aload_1
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	a
    //   33	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	30	33	finally
    //   30	32	33	finally
    //   34	36	33	finally
    //   2	9	38	finally
    //   39	41	38	finally
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.a
 * JD-Core Version:    0.7.0.1
 */