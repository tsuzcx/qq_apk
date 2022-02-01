package com.tencent.luggage.scanner.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PreviewCallback;
import android.os.Looper;
import android.view.Display;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.scanner.camera.a;
import com.tencent.luggage.scanner.camera.b.b.a;
import com.tencent.luggage.scanner.camera.b.c.a;
import com.tencent.luggage.scanner.camera.b.d.a;
import com.tencent.luggage.scanner.camera.b.f;
import com.tencent.luggage.scanner.camera.b.g;
import com.tencent.luggage.scanner.camera.b.h;
import com.tencent.luggage.scanner.camera.b.i;
import com.tencent.luggage.scanner.camera.b.j;
import com.tencent.luggage.scanner.camera.c;
import com.tencent.luggage.scanner.camera.g;

public abstract class b
  extends FrameLayout
  implements Camera.AutoFocusCallback, Camera.PreviewCallback, TextureView.SurfaceTextureListener
{
  protected static int d = 80;
  protected static int e = 1000;
  protected TextureView a;
  protected g b;
  protected SurfaceTexture c;
  private int f;
  private long g;
  private long h;
  private b.b i = new b.b(this, Looper.myLooper());
  private b.a j = new b.a(this, Looper.myLooper());
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  private Matrix a(Point paramPoint1, Point paramPoint2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("from ");
    ((StringBuilder)localObject1).append(paramPoint1);
    ((StringBuilder)localObject1).append(" to ");
    ((StringBuilder)localObject1).append(paramPoint2);
    com.tencent.luggage.wxa.ry.b.c("ScanView", ((StringBuilder)localObject1).toString());
    localObject1 = new Matrix();
    this.a.getTransform((Matrix)localObject1);
    ((Matrix)localObject1).reset();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("before matrix ");
    ((StringBuilder)localObject2).append(localObject1);
    com.tencent.luggage.wxa.ry.b.c("ScanView", ((StringBuilder)localObject2).toString());
    if (paramPoint1.equals(paramPoint2)) {
      return localObject1;
    }
    int n = this.b.f();
    localObject2 = this.b.h();
    int k = (((Point)localObject2).x - paramPoint2.x) / 2;
    int m = (((Point)localObject2).y - paramPoint2.y) / 2;
    float f1;
    float f2;
    if (n % 180 != 0)
    {
      f1 = paramPoint2.x * 1.0F / paramPoint1.y;
      f2 = paramPoint2.y * 1.0F / paramPoint1.x;
      k = (((Point)localObject2).y - paramPoint2.x) / 2;
      m = (((Point)localObject2).x - paramPoint2.y) / 2;
    }
    else
    {
      f1 = paramPoint2.x * 1.0F / paramPoint1.x;
      f2 = paramPoint2.y * 1.0F / paramPoint1.y;
    }
    float f3 = Math.max(f1, f2);
    com.tencent.luggage.wxa.ry.b.c("ScanView", "scaleX %f, scaleY %f, scale %f, dx %d, dy %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(k), Integer.valueOf(m) });
    ((Matrix)localObject1).preScale(1.0F / f1, 1.0F / f2);
    ((Matrix)localObject1).postScale(f3, f3);
    ((Matrix)localObject1).postTranslate(-k, -m);
    paramPoint1 = new StringBuilder();
    paramPoint1.append("after matrix ");
    paramPoint1.append(localObject1);
    com.tencent.luggage.wxa.ry.b.c("ScanView", paramPoint1.toString());
    return localObject1;
  }
  
  protected void a()
  {
    this.b = new a();
  }
  
  public void a(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.g;
    int k = d;
    if (l1 > k)
    {
      this.i.removeMessages(0);
      this.i.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = k;
    this.i.removeMessages(0);
    this.i.sendEmptyMessageDelayed(0, paramLong + (l2 - l1));
  }
  
  public void a(b.b.a parama)
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "try open camera");
    if (!this.b.c())
    {
      com.tencent.luggage.wxa.ry.b.c("ScanView", "camera is not open");
      int k = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
      c.a().a(new b.g(this.b, k), parama);
      return;
    }
    com.tencent.luggage.wxa.ry.b.c("ScanView", "camera is already open!");
    if (parama != null) {
      parama.a();
    }
  }
  
  public void a(b.c.a parama)
  {
    int k = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("try reopen camera ");
    localStringBuilder.append(k);
    com.tencent.luggage.wxa.ry.b.c("ScanView", localStringBuilder.toString());
    c.a().a(new b.h(this.b, k), parama);
  }
  
  public void a(b.d.a parama)
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "try start preview");
    if ((this.b.c()) && (!this.b.a()) && (this.c != null)) {
      c.a().a(new b.i(this.b, this.c), new b.1(this, parama));
    }
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "onCreate");
    i();
  }
  
  public void b(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.h;
    int k = e;
    if (l1 > k)
    {
      this.j.removeMessages(0);
      this.j.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = k;
    this.j.removeMessages(0);
    this.j.sendEmptyMessageDelayed(0, paramLong + (l2 - l1));
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "onResume");
  }
  
  public void e()
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "onPause");
  }
  
  public void f()
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "onStop");
  }
  
  public void g()
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "onDestroy");
    this.a.setSurfaceTextureListener(null);
  }
  
  public void h()
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "try stop preview");
    if (this.b.c()) {
      c.a().a(new b.j(this.b));
    }
  }
  
  protected void i()
  {
    this.a = new TextureView(getContext());
    this.a.setSurfaceTextureListener(this);
    addView(this.a, new FrameLayout.LayoutParams(-1, -1));
    a();
    this.f = getResources().getConfiguration().orientation;
    a(null);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.luggage.wxa.ry.b.c("ScanView", "onConfigurationChanged %d,%d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.f) });
    if ((paramConfiguration.orientation != this.f) && (this.b != null))
    {
      this.f = paramConfiguration.orientation;
      a(new b.4(this));
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h();
    p();
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.g = 0L;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "surface available, %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.c = paramSurfaceTexture;
    if (this.b.c())
    {
      this.b.b(new Point(paramInt1, paramInt2));
      a(new b.2(this));
      return;
    }
    a(new b.3(this, paramInt1, paramInt2));
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "surface destroyed");
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "surface size changed, %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void p()
  {
    com.tencent.luggage.wxa.ry.b.c("ScanView", "try close camera");
    if (this.b.c()) {
      c.a().a(new b.f(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.b
 * JD-Core Version:    0.7.0.1
 */