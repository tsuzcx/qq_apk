package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;

public class e
  extends a
  implements TextureView.SurfaceTextureListener
{
  private static final float[] a = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  private long A = 0L;
  private boolean B = false;
  private boolean C = false;
  private boolean D = false;
  private boolean E = false;
  private e.a F = new e.a();
  private SurfaceTexture b;
  private int c = 800;
  protected TextureView d;
  protected d e;
  protected int f = 0;
  protected int g = 0;
  protected int h = 0;
  protected int i = 0;
  protected int j = 0;
  protected int k = 0;
  protected volatile int l = -1;
  protected int m = 0;
  protected int n = 0;
  protected f o;
  WeakReference<b> p;
  private com.tencent.liteav.basic.c.e q;
  private h r;
  private Surface s;
  private int t = 0;
  private int u;
  private int[] v = new int[5];
  private int w = 500;
  private long x = 0L;
  private long y = 0L;
  private long z = 0L;
  
  private long a(long paramLong)
  {
    long l1 = TXCTimeUtil.getTimeTick();
    if (paramLong > l1) {
      return 0L;
    }
    return l1 - paramLong;
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f1 = paramInt2;
    float f2 = paramInt1;
    if (f1 / f2 > paramBitmap.getHeight() / paramBitmap.getWidth()) {
      f1 = f2 / paramBitmap.getWidth();
    } else {
      f1 /= paramBitmap.getHeight();
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).preScale(f1, f1);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, false);
    paramBitmap.recycle();
    return localObject;
  }
  
  private Bitmap a(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i1 = 360 - (this.t + this.k) % 360;
    paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
    paramBitmap.recycle();
    if (i1 != 0)
    {
      paramBitmap = new Matrix();
      paramBitmap.setRotate(i1);
      paramBitmap = Bitmap.createBitmap(paramMatrix, 0, 0, paramMatrix.getWidth(), paramMatrix.getHeight(), paramBitmap, false);
      paramMatrix.recycle();
      paramMatrix = paramBitmap;
    }
    if (this.u == 0)
    {
      int i3 = paramMatrix.getWidth();
      int i4 = paramMatrix.getHeight();
      int i2 = 1;
      if (paramInt1 < paramInt2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i3 >= i4) {
        i2 = 0;
      }
      float f2;
      float f1;
      float f3;
      if (i1 != i2) {
        if (i1 != 0)
        {
          f2 = i4;
          f1 = paramInt1;
          f2 = f2 * f1 / paramInt2;
          f3 = i3;
          paramBitmap = new Matrix();
          f1 /= f2;
          paramBitmap.preScale(f1, f1);
          paramBitmap = Bitmap.createBitmap(paramMatrix, (int)((f3 - f2) * 0.5F), 0, (int)f2, i4, paramBitmap, false);
          paramMatrix.recycle();
        }
      }
      for (paramMatrix = paramBitmap;; paramMatrix = a(paramMatrix, paramInt1, paramInt2))
      {
        return paramMatrix;
        f2 = i3 / paramInt1;
        f1 = paramInt2;
        f2 *= f1;
        f3 = i4;
        paramBitmap = new Matrix();
        f1 /= f2;
        paramBitmap.preScale(f1, f1);
        paramMatrix = Bitmap.createBitmap(paramMatrix, 0, (int)((f3 - f2) * 0.5F), i3, (int)f2, null, false);
        paramBitmap = Bitmap.createBitmap(paramMatrix, 0, 0, paramMatrix.getWidth(), paramMatrix.getHeight(), paramBitmap, false);
        paramMatrix.recycle();
        return paramBitmap;
        paramBitmap = paramMatrix;
        if (paramInt1 == paramMatrix.getWidth()) {
          break;
        }
        paramBitmap = paramMatrix;
        if (paramInt2 == paramMatrix.getHeight()) {
          break;
        }
      }
    }
    paramBitmap = paramMatrix;
    if (paramInt1 != paramMatrix.getWidth())
    {
      paramBitmap = paramMatrix;
      if (paramInt2 != paramMatrix.getHeight()) {
        paramBitmap = a(paramMatrix, paramInt1, paramInt2);
      }
    }
    return paramBitmap;
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    h localh = this.r;
    if ((localh != null) && (localh.a() != paramBoolean))
    {
      this.r.c();
      this.r = null;
    }
    if (this.r == null)
    {
      this.r = new h(Boolean.valueOf(paramBoolean));
      this.r.b();
    }
    if (paramArrayOfFloat != null) {
      this.r.a(paramArrayOfFloat);
    } else {
      this.r.a(a);
    }
    int i3 = this.m;
    int i4 = this.n;
    if (this.u == 0) {
      this.r.a(h.a);
    } else {
      this.r.a(h.b);
    }
    int i5 = this.t;
    int i2 = (this.k + i5) % 360;
    int i1 = i2;
    if (paramBoolean) {
      if (i5 != 90)
      {
        i1 = i2;
        if (i5 != 270) {}
      }
      else
      {
        i1 = (this.t + this.k + 180) % 360;
      }
    }
    this.r.b(i1);
    this.r.b(paramInt2, paramInt3);
    this.r.a(i3, i4);
    return new int[] { this.r.d(paramInt1), i3, i4 };
  }
  
  private void b()
  {
    if (!this.D)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_USERID", getID());
      ((Bundle)localObject).putInt("EVT_ID", 2003);
      ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      ((Bundle)localObject).putCharSequence("EVT_MSG", "Render the first video frame(IDR)");
      ((Bundle)localObject).putInt("EVT_PARAM1", this.h);
      ((Bundle)localObject).putInt("EVT_PARAM2", this.i);
      com.tencent.liteav.basic.util.f.a(this.p, 2003, (Bundle)localObject);
      setStatusValue(6001, this.j, Long.valueOf(TXCTimeUtil.getTimeTick()));
      setStatusValue(6015, this.j, Integer.valueOf(this.h));
      setStatusValue(6016, this.j, Integer.valueOf(this.i));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[FirstFramePath][Video][Render] TXCVideoRender: render first video frame. instance:");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(" id:");
      ((StringBuilder)localObject).append(getID());
      ((StringBuilder)localObject).append(" type:");
      ((StringBuilder)localObject).append(this.j);
      TXCLog.i("TXCVideoRender", ((StringBuilder)localObject).toString());
      this.D = true;
      Monitor.a(2, String.format("Remote-VideoRender[%d]: Render first frame [tinyID:%s][streamType:%d]", new Object[] { Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.j) }), "streamType: 2-big, 3-small, 7-sub", 0);
      TXCKeyPointReportProxy.a(getID(), 40022, 0L, this.j);
    }
    Object localObject = this.F;
    ((e.a)localObject).c += 1L;
    n();
    if (this.F.d != 0L)
    {
      localObject = this.F;
      ((e.a)localObject).j = a(((e.a)localObject).d);
      if (this.F.j > 200L)
      {
        localObject = this.F;
        ((e.a)localObject).e += 1L;
        setStatusValue(6021, this.j, Long.valueOf(this.F.e));
      }
      if (this.F.j > this.w)
      {
        localObject = this.F;
        ((e.a)localObject).f += 1L;
        setStatusValue(6003, this.j, Long.valueOf(this.F.f));
        if (this.F.j > this.F.i)
        {
          localObject = this.F;
          ((e.a)localObject).i = ((e.a)localObject).j;
          setStatusValue(6005, this.j, Long.valueOf(this.F.i));
        }
        localObject = this.F;
        ((e.a)localObject).h += this.F.j;
        setStatusValue(6006, this.j, Long.valueOf(this.F.h));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("render frame count:");
        ((StringBuilder)localObject).append(this.F.c);
        ((StringBuilder)localObject).append(" block time:");
        ((StringBuilder)localObject).append(this.F.j);
        ((StringBuilder)localObject).append("> 500");
        TXCLog.w("TXCVideoRender", ((StringBuilder)localObject).toString());
      }
      if (this.F.j > this.c)
      {
        this.x += 1L;
        this.z += this.F.j;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("render frame count:");
        ((StringBuilder)localObject).append(this.F.c);
        ((StringBuilder)localObject).append(" block time:");
        ((StringBuilder)localObject).append(this.F.j);
        ((StringBuilder)localObject).append("> ");
        ((StringBuilder)localObject).append(this.c);
        TXCLog.w("TXCVideoRender", ((StringBuilder)localObject).toString());
        localObject = this.p;
        String str = getID();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Current video block for ");
        localStringBuilder.append(this.F.j);
        localStringBuilder.append("ms");
        com.tencent.liteav.basic.util.f.a((WeakReference)localObject, str, 2105, localStringBuilder.toString());
      }
      if (this.F.j > 1000L)
      {
        localObject = this.F;
        ((e.a)localObject).g += 1L;
        setStatusValue(6004, this.j, Long.valueOf(this.F.g));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("render frame count:");
        ((StringBuilder)localObject).append(this.F.c);
        ((StringBuilder)localObject).append(" block time:");
        ((StringBuilder)localObject).append(this.F.j);
        ((StringBuilder)localObject).append("> 1000");
        TXCLog.w("TXCVideoRender", ((StringBuilder)localObject).toString());
      }
    }
    long l1 = TXCTimeUtil.getTimeTick();
    long l2 = this.y;
    if (l2 == 0L)
    {
      this.y = l1;
    }
    else if (l1 - l2 >= 2000L)
    {
      setStatusValue(17015, this.j, Long.valueOf(this.x));
      setStatusValue(17016, this.j, Long.valueOf(this.z));
      if (this.A != 0L)
      {
        TXCKeyPointReportProxy.a(getID(), 40005, (int)this.z, this.j);
        TXCKeyPointReportProxy.a(getID(), 40006, (int)(l1 - this.y), this.j);
      }
      this.x = 0L;
      this.y = l1;
      this.z = 0L;
    }
    this.F.d = TXCTimeUtil.getTimeTick();
    if (this.A == 0L) {
      this.A = this.F.d;
    }
    localObject = this.F;
    ((e.a)localObject).l = this.i;
    ((e.a)localObject).k = this.h;
  }
  
  private void b(Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surface-render: set surface ");
    localStringBuilder.append(paramSurface);
    TXCLog.i("TXCVideoRender", localStringBuilder.toString());
    if (this.s == paramSurface)
    {
      TXCLog.i("TXCVideoRender", "surface-render: set the same surface, ignore ");
      return;
    }
    this.s = paramSurface;
    this.l = 1;
    if (paramSurface != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("surface-render: set surface start render thread ");
      localStringBuilder.append(paramSurface);
      TXCLog.i("TXCVideoRender", localStringBuilder.toString());
      c(null);
      return;
    }
    try
    {
      if (this.q != null)
      {
        paramSurface = new StringBuilder();
        paramSurface.append("surface-render: set surface stop render thread ");
        paramSurface.append(this.q);
        TXCLog.i("TXCVideoRender", paramSurface.toString());
        this.q.a();
        this.q = null;
      }
      return;
    }
    finally {}
  }
  
  private void b(TextureView paramTextureView)
  {
    int i2 = 0;
    if (paramTextureView != null) {
      this.l = 0;
    }
    int i1;
    if ((this.d != null) || (paramTextureView == null))
    {
      localObject = this.d;
      i1 = i2;
      if (localObject != null)
      {
        i1 = i2;
        if (localObject.equals(paramTextureView)) {}
      }
    }
    else
    {
      i1 = 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("play:vrender: set video view @old=");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(",new=");
    ((StringBuilder)localObject).append(paramTextureView);
    ((StringBuilder)localObject).append("id ");
    ((StringBuilder)localObject).append(getID());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.j);
    TXCLog.w("TXCVideoRender", ((StringBuilder)localObject).toString());
    if (i1 != 0)
    {
      localObject = this.d;
      if ((localObject != null) && (this.b == null))
      {
        b(((TextureView)localObject).getSurfaceTexture());
        this.d.setSurfaceTextureListener(null);
      }
      this.d = paramTextureView;
      paramTextureView = this.d;
      if (paramTextureView != null)
      {
        if (paramTextureView.getWidth() != 0) {
          this.f = this.d.getWidth();
        }
        if (this.d.getHeight() != 0) {
          this.g = this.d.getHeight();
        }
        this.e = new d(this.d);
        this.e.b(this.h, this.i);
        this.e.a(this.f, this.g);
        this.e.a(this.u);
        this.e.c((this.t + this.k) % 360);
        this.d.setSurfaceTextureListener(this);
        if (this.b != null)
        {
          if ((Build.VERSION.SDK_INT >= 16) && (this.d.getSurfaceTexture() != this.b))
          {
            paramTextureView = new StringBuilder();
            paramTextureView.append("play:vrender: setSurfaceTexture ");
            paramTextureView.append(this.d);
            paramTextureView.append(", surfaceTexture ");
            paramTextureView.append(this.b);
            TXCLog.w("TXCVideoRender", paramTextureView.toString());
            this.d.setSurfaceTexture(this.b);
            return;
          }
          paramTextureView = new StringBuilder();
          paramTextureView.append("play:vrender: not setSurfaceTexture old surfaceTexture ");
          paramTextureView.append(this.d.getSurfaceTexture());
          paramTextureView.append(", new surfaceTexture ");
          paramTextureView.append(this.b);
          TXCLog.w("TXCVideoRender", paramTextureView.toString());
          return;
        }
        if (this.d.isAvailable()) {
          a(this.d.getSurfaceTexture());
        }
      }
    }
  }
  
  public SurfaceTexture a()
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (((this.h != paramInt1) || (this.i != paramInt2)) && ((this.h != paramInt1) || (this.i != paramInt2)))
    {
      this.h = paramInt1;
      this.i = paramInt2;
      d locald = this.e;
      if (locald != null) {
        locald.b(this.h, this.i);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    a(paramInt2, paramInt3);
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture)
  {
    this.B = true;
  }
  
  public void a(Surface paramSurface)
  {
    b(paramSurface);
  }
  
  public void a(TextureView paramTextureView)
  {
    b(paramTextureView);
  }
  
  public void a(b paramb)
  {
    this.p = new WeakReference(paramb);
  }
  
  public void a(o paramo)
  {
    TextureView localTextureView = this.d;
    if (localTextureView != null) {}
    try
    {
      localObject = localTextureView.getBitmap();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      label17:
      break label17;
    }
    localObject = null;
    if (localObject != null)
    {
      AsyncTask.execute(new e.1(this, localTextureView.getTransform(null), (Bitmap)localObject, localTextureView, paramo));
      return;
      localObject = this.q;
      if (localObject != null)
      {
        ((com.tencent.liteav.basic.c.e)localObject).a(new e.2(this, paramo));
        return;
      }
      if (paramo != null) {
        paramo.onTakePhotoComplete(null);
      }
    }
  }
  
  public void a(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != this.k)
    {
      this.k = paramInt3;
      d(this.t);
    }
    a(paramInt1, paramInt2);
    b();
  }
  
  public void a(f paramf)
  {
    this.o = paramf;
  }
  
  protected void a(Object paramObject, int paramInt, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (this.l == 1)
    {
      paramArrayOfFloat = a(paramInt, this.h, this.i, paramArrayOfFloat, paramBoolean);
      paramInt = paramArrayOfFloat[0];
      int i1 = paramArrayOfFloat[1];
      int i2 = paramArrayOfFloat[2];
      System.arraycopy(paramArrayOfFloat, 0, this.v, 0, 3);
      if (paramBoolean)
      {
        paramArrayOfFloat = this.v;
        paramArrayOfFloat[3] = 1;
        paramArrayOfFloat[4] = 180;
      }
      else
      {
        paramArrayOfFloat = this.v;
        paramArrayOfFloat[3] = 0;
        paramArrayOfFloat[4] = 0;
      }
      try
      {
        paramArrayOfFloat = this.s;
        if (paramArrayOfFloat != null)
        {
          Object localObject;
          if (this.q != null)
          {
            localObject = this.q.b();
            if ((localObject != paramArrayOfFloat) || ((localObject != null) && (!((Surface)localObject).isValid())))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("surface-render: onDrawTextureToSurface surface change stop render thread ");
              localStringBuilder.append(this.q);
              localStringBuilder.append(", ");
              localStringBuilder.append(localObject);
              localStringBuilder.append(", ");
              localStringBuilder.append(paramArrayOfFloat);
              TXCLog.i("TXCVideoRender", localStringBuilder.toString());
              this.q.a();
              this.q = null;
            }
          }
          if ((this.q == null) && (this.l == 1) && (paramArrayOfFloat.isValid()))
          {
            this.q = new com.tencent.liteav.basic.c.e();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("surface-render: onDrawTextureToSurface start render thread ");
            ((StringBuilder)localObject).append(this.q);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(paramArrayOfFloat);
            TXCLog.i("TXCVideoRender", ((StringBuilder)localObject).toString());
            this.q.a(paramObject, paramArrayOfFloat);
          }
          if ((this.q != null) && (this.l == 1)) {
            if (paramBoolean) {
              this.q.a(paramInt, true, 180, this.m, this.n, i1, i2, false, false);
            } else {
              this.q.a(paramInt, false, 0, this.m, this.n, i1, i2, false, false);
            }
          }
        }
        else if (this.q != null)
        {
          paramObject = new StringBuilder();
          paramObject.append("surface-render: onDrawTextureToSurface stop render thread ");
          paramObject.append(this.q);
          TXCLog.i("TXCVideoRender", paramObject.toString());
          this.q.a();
          this.q = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1;
    if (this.C)
    {
      int i1 = hashCode();
      String str = getID();
      int i2 = this.j;
      if (paramBoolean) {
        localObject1 = "true";
      } else {
        localObject1 = "false";
      }
      Monitor.a(2, String.format("Remote-VideoRender[%d]: Stop [tinyID:%s][streamType:%d][stopRendThread:%s]", new Object[] { Integer.valueOf(i1), str, Integer.valueOf(i2), localObject1 }), "streamType: 2-big, 3-small, 7-sub", 0);
    }
    this.C = false;
    this.D = false;
    this.E = false;
    if ((paramBoolean) && (this.l == 1))
    {
      this.l = -1;
      TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when stop");
      e();
      try
      {
        if (this.q != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("surface-render:stop render thread ");
          ((StringBuilder)localObject1).append(this.q);
          TXCLog.i("TXCVideoRender", ((StringBuilder)localObject1).toString());
          this.q.a();
          this.q = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0) {
      this.c = paramInt;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture)
  {
    this.B = false;
  }
  
  public void c(int paramInt)
  {
    this.u = paramInt;
    d locald = this.e;
    if (locald != null) {
      locald.a(paramInt);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surface-render: set setSurfaceSize ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("*");
    localStringBuilder.append(paramInt2);
    TXCLog.i("TXCVideoRender", localStringBuilder.toString());
    if ((paramInt1 != this.m) || (paramInt2 != this.n))
    {
      if ((this.q != null) && (this.l == 1) && (this.v != null))
      {
        this.q.a(new e.3(this, paramInt1, paramInt2));
        return;
      }
      this.m = paramInt1;
      this.n = paramInt2;
    }
  }
  
  public void c(Object paramObject) {}
  
  public void d(int paramInt)
  {
    this.t = paramInt;
    d locald = this.e;
    if (locald != null) {
      locald.c((paramInt + this.k) % 360);
    }
  }
  
  public void e() {}
  
  public void e(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void f()
  {
    Monitor.a(2, String.format("Remote-VideoRender[%d]: Start [tinyID:%s] [streamType:%d]", new Object[] { Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.j) }), "streamType: 2-big, 3-small, 7-sub", 0);
    this.C = true;
    if (Build.VERSION.SDK_INT >= 21) {
      this.E = true;
    } else {
      this.E = false;
    }
    this.D = false;
    m();
  }
  
  public int g()
  {
    TextureView localTextureView = this.d;
    if (localTextureView != null) {
      return localTextureView.getWidth();
    }
    if (this.s != null) {
      return this.m;
    }
    return 0;
  }
  
  public int h()
  {
    TextureView localTextureView = this.d;
    if (localTextureView != null) {
      return localTextureView.getHeight();
    }
    if (this.s != null) {
      return this.n;
    }
    return 0;
  }
  
  public int i()
  {
    return this.h;
  }
  
  public int j()
  {
    return this.i;
  }
  
  protected void k() {}
  
  protected void l()
  {
    try
    {
      if (this.q != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("surface-render: onRenderThreadEGLDestroy stop render thread ");
        ((StringBuilder)localObject1).append(this.q);
        TXCLog.i("TXCVideoRender", ((StringBuilder)localObject1).toString());
        this.q.a();
        this.q = null;
      }
      Object localObject1 = this.r;
      if (localObject1 != null)
      {
        ((h)localObject1).c();
        this.r = null;
      }
      return;
    }
    finally {}
  }
  
  public void m()
  {
    e.a locala = this.F;
    Long localLong = Long.valueOf(0L);
    locala.a = 0L;
    locala.b = 0L;
    locala.c = 0L;
    locala.d = 0L;
    locala.e = 0L;
    locala.f = 0L;
    locala.g = 0L;
    locala.h = 0L;
    locala.i = 0L;
    locala.j = 0L;
    locala.k = 0;
    locala.l = 0;
    setStatusValue(6001, this.j, localLong);
    setStatusValue(6002, this.j, Double.valueOf(0.0D));
    setStatusValue(6003, this.j, localLong);
    setStatusValue(6005, this.j, localLong);
    setStatusValue(6006, this.j, localLong);
    setStatusValue(6004, this.j, localLong);
  }
  
  public void n()
  {
    if (this.F.a == 0L)
    {
      this.F.a = TXCTimeUtil.getTimeTick();
      return;
    }
    long l1 = TXCTimeUtil.getTimeTick() - this.F.a;
    if (l1 >= 1000L)
    {
      double d1 = this.F.c - this.F.b;
      Double.isNaN(d1);
      double d2 = l1;
      Double.isNaN(d2);
      d1 = Double.valueOf(d1 * 1000.0D / d2).doubleValue();
      setStatusValue(6002, this.j, Double.valueOf(d1));
      TXCKeyPointReportProxy.a(getID(), 40001, (int)d1, this.j);
      e.a locala = this.F;
      locala.b = locala.c;
      locala = this.F;
      locala.a += l1;
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("play:vrender: texture available @");
    ((StringBuilder)localObject).append(paramSurfaceTexture);
    ((StringBuilder)localObject).append("id ");
    ((StringBuilder)localObject).append(getID());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.j);
    TXCLog.w("TXCVideoRender", ((StringBuilder)localObject).toString());
    this.f = paramInt1;
    this.g = paramInt2;
    localObject = this.e;
    if (localObject != null) {
      ((d)localObject).a(this.f, this.g);
    }
    if (this.b != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramSurfaceTexture = this.d.getSurfaceTexture();
        localObject = this.b;
        if (paramSurfaceTexture != localObject) {
          this.d.setSurfaceTexture((SurfaceTexture)localObject);
        }
      }
      this.b = null;
    }
    else
    {
      a(paramSurfaceTexture);
    }
    this.B = true;
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = false;
    try
    {
      this.B = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play:vrender:  onSurfaceTextureDestroyed when need save texture : ");
      localStringBuilder.append(this.E);
      localStringBuilder.append("id ");
      localStringBuilder.append(getID());
      localStringBuilder.append("_");
      localStringBuilder.append(this.j);
      TXCLog.w("TXCVideoRender", localStringBuilder.toString());
      if (this.E)
      {
        this.b = paramSurfaceTexture;
      }
      else
      {
        this.F.a = 0L;
        b(paramSurfaceTexture);
        if (paramSurfaceTexture == this.b) {
          this.b = null;
        }
      }
    }
    catch (Exception paramSurfaceTexture)
    {
      TXCLog.e("TXCVideoRender", "onSurfaceTextureDestroyed failed.", paramSurfaceTexture);
    }
    if (this.b == null) {
      bool = true;
    }
    return bool;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("play:vrender: texture size change new:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" old:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append(this.g);
    TXCLog.w("TXCVideoRender", localStringBuilder.toString());
    if (!this.B)
    {
      TXCLog.w("TXCVideoRender", "play:vrender: onSurfaceCreate on onSurfaceTextureSizeChanged when onSurfaceTextureAvailable is not trigger");
      this.B = true;
      a(paramSurfaceTexture);
    }
    this.f = paramInt1;
    this.g = paramInt2;
    paramSurfaceTexture = this.e;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.a(this.f, this.g);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.e
 * JD-Core Version:    0.7.0.1
 */