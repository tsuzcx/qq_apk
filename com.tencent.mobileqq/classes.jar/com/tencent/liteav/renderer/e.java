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
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.opengl.g;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;

public class e
  extends a
  implements TextureView.SurfaceTextureListener
{
  private static final float[] a = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  private long A = 0L;
  private long B = 0L;
  private long C = 0L;
  private boolean D = false;
  private boolean E = false;
  private boolean F = false;
  private boolean G = false;
  private e.a H = new e.a();
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
  private g q;
  private h r;
  private Surface s;
  private int t = 0;
  private int u;
  private int v;
  private int[] w = new int[5];
  private int x = 500;
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
    if (this.v == 1) {
      this.r.a(true);
    } else {
      this.r.a(false);
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
    if (!this.F)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_USERID", getID());
      ((Bundle)localObject).putInt("EVT_ID", 2003);
      ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      ((Bundle)localObject).putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      ((Bundle)localObject).putCharSequence("EVT_MSG", "Render the first video frame(IDR)");
      ((Bundle)localObject).putInt("EVT_PARAM1", this.h);
      ((Bundle)localObject).putInt("EVT_PARAM2", this.i);
      com.tencent.liteav.basic.util.h.a(this.p, 2003, (Bundle)localObject);
      setStatusValue(6001, this.j, Long.valueOf(TXCTimeUtil.getTimeTick()));
      setStatusValue(6010, this.j, Integer.valueOf(this.h));
      setStatusValue(6011, this.j, Integer.valueOf(this.i));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[FirstFramePath][Video][Render] TXCVideoRender: render first video frame. instance:");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(" id:");
      ((StringBuilder)localObject).append(getID());
      ((StringBuilder)localObject).append(" type:");
      ((StringBuilder)localObject).append(this.j);
      TXCLog.i("TXCVideoRender", ((StringBuilder)localObject).toString());
      this.F = true;
      Monitor.a(2, String.format("Remote-VideoRender[%d]: Render first frame [tinyID:%s][streamType:%d]", new Object[] { Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.j) }), "streamType: 2-big, 3-small, 7-sub", 0);
      TXCKeyPointReportProxy.a(getID(), 40022, 0L, this.j);
    }
    if (!this.H.o) {
      return;
    }
    Object localObject = this.H;
    ((e.a)localObject).c += 1L;
    o();
    long l1 = a(this.H.n);
    if (this.H.d != 0L)
    {
      localObject = this.H;
      ((e.a)localObject).j = a(((e.a)localObject).d);
      localObject = this.H;
      ((e.a)localObject).k += this.H.j;
      if (this.H.j > 200L)
      {
        localObject = this.H;
        ((e.a)localObject).e += 1L;
        setStatusValue(6009, this.j, Long.valueOf(this.H.e));
      }
      if (this.H.j > this.x)
      {
        localObject = this.H;
        ((e.a)localObject).f += 1L;
        setStatusValue(6003, this.j, Long.valueOf(this.H.f));
        if (this.H.j > this.H.i)
        {
          localObject = this.H;
          ((e.a)localObject).i = ((e.a)localObject).j;
          setStatusValue(6005, this.j, Long.valueOf(this.H.i));
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("render frame count:");
        ((StringBuilder)localObject).append(this.H.c);
        ((StringBuilder)localObject).append(" block time:");
        ((StringBuilder)localObject).append(this.H.j);
        ((StringBuilder)localObject).append("> 500");
        TXCLog.w("TXCVideoRender", ((StringBuilder)localObject).toString());
      }
      if (this.H.j > this.c)
      {
        this.z += this.H.j;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("render frame count:");
        ((StringBuilder)localObject).append(this.H.c);
        ((StringBuilder)localObject).append(" block time:");
        ((StringBuilder)localObject).append(this.H.j);
        ((StringBuilder)localObject).append("> ");
        ((StringBuilder)localObject).append(this.c);
        TXCLog.w("TXCVideoRender", ((StringBuilder)localObject).toString());
        localObject = this.p;
        String str = getID();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Current video block for ");
        localStringBuilder.append(this.H.j);
        localStringBuilder.append("ms");
        com.tencent.liteav.basic.util.h.a((WeakReference)localObject, str, 2105, localStringBuilder.toString(), this.H.j);
        localObject = this.H;
        ((e.a)localObject).h += this.H.j;
        setStatusValue(6006, this.j, Long.valueOf(this.H.h));
      }
      if (this.H.j > 1000L)
      {
        localObject = this.H;
        ((e.a)localObject).g += 1L;
        setStatusValue(6004, this.j, Long.valueOf(this.H.g));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("render frame count:");
        ((StringBuilder)localObject).append(this.H.c);
        ((StringBuilder)localObject).append(" block time:");
        ((StringBuilder)localObject).append(this.H.j);
        ((StringBuilder)localObject).append("> 1000");
        TXCLog.w("TXCVideoRender", ((StringBuilder)localObject).toString());
      }
    }
    if ((this.H.n != 0L) && (l1 > this.c))
    {
      this.A += 1L;
      this.B += l1;
    }
    l1 = TXCTimeUtil.getTimeTick();
    long l2 = this.y;
    if (l2 == 0L)
    {
      this.y = l1;
    }
    else if (l1 - l2 >= 2000L)
    {
      setStatusValue(17015, this.j, Long.valueOf(this.A));
      setStatusValue(17016, this.j, Long.valueOf(this.B));
      if (this.C != 0L)
      {
        TXCKeyPointReportProxy.a(getID(), 40005, (int)this.z, this.j);
        TXCKeyPointReportProxy.a(getID(), 40065, (int)this.B, this.j);
        TXCKeyPointReportProxy.a(getID(), 40006, (int)(l1 - this.y), this.j);
        setStatusValue(6012, this.j, Long.valueOf(this.H.k));
      }
      this.z = 0L;
      this.A = 0L;
      this.B = 0L;
      this.y = l1;
    }
    this.H.d = TXCTimeUtil.getTimeTick();
    localObject = this.H;
    ((e.a)localObject).n = ((e.a)localObject).d;
    if (this.C == 0L) {
      this.C = this.H.d;
    }
    localObject = this.H;
    ((e.a)localObject).m = this.i;
    ((e.a)localObject).l = this.h;
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
            try
            {
              this.d.setSurfaceTexture(this.b);
              return;
            }
            catch (Exception paramTextureView)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("setSurfaceTexture error ");
              ((StringBuilder)localObject).append(paramTextureView);
              TXCLog.e("TXCVideoRender", ((StringBuilder)localObject).toString());
              return;
            }
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
    this.D = true;
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
  
  public void a(p paramp)
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
      AsyncTask.execute(new e.1(this, localTextureView.getTransform(null), (Bitmap)localObject, localTextureView, paramp));
      return;
      localObject = this.q;
      if (localObject != null)
      {
        ((g)localObject).a(new e.2(this, paramp));
        return;
      }
      if (paramp != null) {
        paramp.onTakePhotoComplete(null);
      }
    }
  }
  
  public void a(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != this.k)
    {
      this.k = paramInt3;
      e(this.t);
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
      System.arraycopy(paramArrayOfFloat, 0, this.w, 0, 3);
      if (paramBoolean)
      {
        paramArrayOfFloat = this.w;
        paramArrayOfFloat[3] = 1;
        paramArrayOfFloat[4] = 180;
      }
      else
      {
        paramArrayOfFloat = this.w;
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
            this.q = new g();
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
    l();
    Object localObject1;
    if (this.E)
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
    this.E = false;
    this.F = false;
    this.G = false;
    if ((paramBoolean) && (this.l == 1))
    {
      this.l = -1;
      TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when stop");
      d();
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
  
  protected void b(SurfaceTexture paramSurfaceTexture)
  {
    this.D = false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.H.o = paramBoolean;
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
    a(paramInt1, paramInt2);
  }
  
  public void c(Object paramObject) {}
  
  public void d() {}
  
  public void d(int paramInt)
  {
    this.v = paramInt;
    d locald = this.e;
    if (locald != null)
    {
      if (paramInt == 2)
      {
        locald.a(false);
        return;
      }
      locald.a(true);
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surface-render: set setSurfaceSize ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("*");
    localStringBuilder.append(paramInt2);
    TXCLog.i("TXCVideoRender", localStringBuilder.toString());
    if ((paramInt1 != this.m) || (paramInt2 != this.n))
    {
      if ((this.q != null) && (this.l == 1) && (this.w != null))
      {
        this.q.a(new e.3(this, paramInt1, paramInt2));
        return;
      }
      this.m = paramInt1;
      this.n = paramInt2;
    }
  }
  
  public void e()
  {
    Monitor.a(2, String.format("Remote-VideoRender[%d]: Start [tinyID:%s] [streamType:%d]", new Object[] { Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.j) }), "streamType: 2-big, 3-small, 7-sub", 0);
    this.E = true;
    if (Build.VERSION.SDK_INT >= 21) {
      this.G = true;
    } else {
      this.G = false;
    }
    this.F = false;
    l();
  }
  
  public void e(int paramInt)
  {
    this.t = paramInt;
    d locald = this.e;
    if (locald != null) {
      locald.c((paramInt + this.k) % 360);
    }
  }
  
  public int f()
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
  
  public void f(int paramInt)
  {
    this.x = paramInt;
  }
  
  public int g()
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
  
  public int h()
  {
    return this.h;
  }
  
  public int i()
  {
    return this.i;
  }
  
  protected void j() {}
  
  protected void k()
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
  
  public void l()
  {
    m();
    e.a locala = this.H;
    Long localLong = Long.valueOf(0L);
    locala.b = 0L;
    locala.c = 0L;
    locala.e = 0L;
    locala.f = 0L;
    locala.g = 0L;
    locala.h = 0L;
    locala.i = 0L;
    locala.k = 0L;
    this.C = 0L;
    setStatusValue(6001, this.j, localLong);
    setStatusValue(6003, this.j, localLong);
    setStatusValue(6005, this.j, localLong);
    setStatusValue(6006, this.j, localLong);
    setStatusValue(6004, this.j, localLong);
    setStatusValue(6012, this.j, localLong);
  }
  
  public void m()
  {
    n();
    e.a locala = this.H;
    locala.a = 0L;
    locala.d = 0L;
    locala.j = 0L;
    this.z = 0L;
  }
  
  public void n()
  {
    e.a locala = this.H;
    locala.n = 0L;
    this.B = 0L;
    this.A = 0L;
    locala.l = 0;
    locala.m = 0;
    setStatusValue(6002, this.j, Double.valueOf(0.0D));
  }
  
  public void o()
  {
    if (this.H.a == 0L)
    {
      this.H.a = TXCTimeUtil.getTimeTick();
      return;
    }
    long l1 = TXCTimeUtil.getTimeTick() - this.H.a;
    if (l1 >= 950L)
    {
      double d1 = this.H.c - this.H.b;
      Double.isNaN(d1);
      double d2 = l1;
      Double.isNaN(d2);
      d1 = Double.valueOf(d1 * 1000.0D / d2).doubleValue();
      setStatusValue(6002, this.j, Double.valueOf(d1));
      TXCKeyPointReportProxy.a(getID(), 40001, (int)d1, this.j);
      e.a locala = this.H;
      locala.b = locala.c;
      locala = this.H;
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
    this.D = true;
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = false;
    try
    {
      this.D = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play:vrender:  onSurfaceTextureDestroyed when need save texture : ");
      localStringBuilder.append(this.G);
      localStringBuilder.append("id ");
      localStringBuilder.append(getID());
      localStringBuilder.append("_");
      localStringBuilder.append(this.j);
      TXCLog.w("TXCVideoRender", localStringBuilder.toString());
      if (this.G)
      {
        this.b = paramSurfaceTexture;
      }
      else
      {
        this.H.a = 0L;
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
    if (!this.D)
    {
      TXCLog.w("TXCVideoRender", "play:vrender: onSurfaceCreate on onSurfaceTextureSizeChanged when onSurfaceTextureAvailable is not trigger");
      this.D = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.e
 * JD-Core Version:    0.7.0.1
 */