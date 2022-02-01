package com.tencent.luggage.wxa.ml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.wxa.ma.e.h;
import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.mi.b.a;
import com.tencent.luggage.wxa.mi.b.b;
import com.tencent.luggage.wxa.mi.b.d;
import com.tencent.luggage.wxa.mi.b.e;
import com.tencent.luggage.wxa.mi.b.f;
import com.tencent.luggage.wxa.mi.b.g;
import com.tencent.luggage.wxa.mi.b.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public abstract class a
  extends TextureView
  implements d
{
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private TextureView.SurfaceTextureListener D = new a.10(this);
  private boolean E = false;
  private e F = new e();
  private float G = -1.0F;
  protected b a = null;
  private String b;
  private int c;
  private Surface d = null;
  private boolean e;
  private int f;
  private int g;
  private boolean h;
  private d.a i;
  private d.e j;
  private d.c k;
  private d.b l;
  private d.d m;
  private long n = 0L;
  private long o = 0L;
  private int p = 0;
  private boolean q = false;
  private boolean r = false;
  private b.h s = new a.3(this);
  private b.f t = new a.4(this);
  private b.g u = new a.5(this);
  private b.a v = new a.6(this);
  private b.e w = new a.7(this);
  private b.b x = new a.8(this);
  private b.d y = new a.9(this);
  private long z = 0L;
  
  public a(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void a(SurfaceTexture paramSurfaceTexture)
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, null);
    Object localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    int i1 = localObject.length;
    localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject, i1, arrayOfInt);
    arrayOfInt = localObject[0];
    localObject = localEGL10.eglCreateContext(localEGLDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    paramSurfaceTexture = localEGL10.eglCreateWindowSurface(localEGLDisplay, arrayOfInt, paramSurfaceTexture, new int[] { 12344 });
    localEGL10.eglMakeCurrent(localEGLDisplay, paramSurfaceTexture, paramSurfaceTexture, (EGLContext)localObject);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    localEGL10.eglSwapBuffers(localEGLDisplay, paramSurfaceTexture);
    localEGL10.eglDestroySurface(localEGLDisplay, paramSurfaceTexture);
    localEGL10.eglMakeCurrent(localEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    localEGL10.eglDestroyContext(localEGLDisplay, (EGLContext)localObject);
    localEGL10.eglTerminate(localEGLDisplay);
  }
  
  private void a(b paramb)
  {
    new a.1(this, paramb).start();
  }
  
  private void g()
  {
    this.f = 0;
    this.g = 0;
    setSurfaceTextureListener(this.D);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void h()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.addRule(13);
    setLayoutParams(localLayoutParams);
  }
  
  private void i()
  {
    try
    {
      if ((this.d != null) && (this.e))
      {
        SurfaceTexture localSurfaceTexture = getSurfaceTexture();
        if (localSurfaceTexture != null)
        {
          o.d("MicroMsg.Video.AbstractVideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
          a(localSurfaceTexture);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Video.AbstractVideoTextureView", localException, "release surface", new Object[0]);
    }
  }
  
  private void j()
  {
    int i1 = hashCode();
    boolean bool2 = this.e;
    boolean bool1 = true;
    if (this.a != null) {
      bool1 = false;
    }
    o.d("MicroMsg.Video.AbstractVideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    b localb = this.a;
    if (localb != null)
    {
      localb.a(null);
      this.a.a(null);
      try
      {
        this.a.n();
      }
      catch (Exception localException1)
      {
        o.a("MicroMsg.Video.AbstractVideoTextureView", localException1, "stop media player error", new Object[0]);
      }
      try
      {
        this.a.o();
        this.a.b();
      }
      catch (Exception localException2)
      {
        o.a("MicroMsg.Video.AbstractVideoTextureView", localException2, "reset media player error", new Object[0]);
      }
    }
    this.a = null;
  }
  
  private void k()
  {
    if ((!af.c(this.b)) && (this.d != null))
    {
      j();
      o.d("MicroMsg.Video.AbstractVideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.b });
      try
      {
        this.a = a();
        this.a.a(this.t);
        this.a.a(this.s);
        this.e = false;
        this.c = -1;
        this.p = 0;
        this.a.a(this.x);
        this.a.a(this.y);
        this.a.a(this.u);
        this.a.a(this.v);
        this.a.a(this.w);
        if (!af.c(this.b)) {
          this.a.b(this.b);
        }
        this.a.a(this.d);
        this.a.k();
        this.g = this.a.j();
        this.f = this.a.i();
        setMute(this.E);
        a(this.G);
        o.d("MicroMsg.Video.AbstractVideoTextureView", "%d open video success player[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.a.hashCode()) });
        return;
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Video.AbstractVideoTextureView", localException, "prepare async error path", new Object[0]);
        d.a locala = this.i;
        if (locala != null) {
          locala.a(-1, -1);
        }
        return;
      }
    }
    o.d("MicroMsg.Video.AbstractVideoTextureView", "openVideo, try later, url:%s, surface:%s", new Object[] { this.b, this.d });
  }
  
  protected abstract b a();
  
  public void a(double paramDouble)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((b)localObject).a((int)paramDouble);
      this.h = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("seek to time: ");
      ((StringBuilder)localObject).append(paramDouble);
      ((StringBuilder)localObject).append(" curr pos : ");
      ((StringBuilder)localObject).append(this.a.h());
      o.e("MicroMsg.Video.AbstractVideoTextureView", ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(double paramDouble, boolean paramBoolean)
  {
    a(paramDouble);
    this.h = paramBoolean;
  }
  
  protected void a(Surface paramSurface)
  {
    f.a.c(new a.2(this, paramSurface));
  }
  
  public boolean a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return false;
    }
    this.G = paramFloat;
    b localb = this.a;
    if (localb != null) {
      localb.a(this.G);
    }
    return false;
  }
  
  public void b()
  {
    long l1 = this.o;
    if (l1 > 0L) {
      l1 -= this.n;
    } else {
      l1 = 2147483647L;
    }
    long l3 = af.a() - this.n;
    long l2;
    if (l1 > l3) {
      l2 = l3;
    } else {
      l2 = l1;
    }
    int i2 = (int)l2 * 1000;
    int i1 = i2;
    if (i2 > getDuration()) {
      i1 = getDuration();
    }
    o.d("MicroMsg.Video.AbstractVideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
    d.a locala = this.i;
    if (locala != null) {
      locala.b(i1, getDuration());
    }
    j();
    this.F.a();
    i();
    this.b = "";
    this.p = 0;
    this.e = false;
    this.h = false;
    this.z = 0L;
  }
  
  public void c()
  {
    if ((this.a != null) && (this.e))
    {
      Surface localSurface = this.d;
      if ((localSurface != null) && (localSurface.isValid()))
      {
        o.d("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
        this.C = true;
        this.a.a(0.0F, 0.0F);
        this.a.l();
      }
    }
  }
  
  public void d()
  {
    b localb = this.a;
    if ((localb != null) && (this.e) && (localb.f()))
    {
      o.e("MicroMsg.Video.AbstractVideoTextureView", "pause video.");
      this.a.m();
    }
    this.h = false;
  }
  
  public boolean e()
  {
    b localb = this.a;
    boolean bool;
    if ((localb != null) && (this.e) && (!this.B) && (!this.C)) {
      bool = localb.f();
    } else {
      bool = false;
    }
    o.e("MicroMsg.Video.AbstractVideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.B), Boolean.valueOf(this.e) });
    return bool;
  }
  
  public boolean f()
  {
    if (this.d == null)
    {
      o.c("MicroMsg.Video.AbstractVideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.A = true;
      this.h = true;
      return false;
    }
    long l2 = this.n;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = af.a();
    }
    this.n = l1;
    o.d("MicroMsg.Video.AbstractVideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b mediaPlayer %s", new Object[] { Long.valueOf(this.n), Boolean.valueOf(this.e), Boolean.valueOf(this.B), this.a });
    if ((this.a != null) && (this.e))
    {
      if (this.B)
      {
        this.B = false;
        setMute(this.E);
      }
      this.a.l();
      this.h = true;
      return true;
    }
    if ((this.a == null) && (this.e))
    {
      this.h = true;
      k();
      requestLayout();
      return true;
    }
    this.h = true;
    return false;
  }
  
  public int getCurrentPosition()
  {
    b localb = this.a;
    if ((localb != null) && (this.e)) {
      return localb.h();
    }
    if (this.a == null) {
      return -1;
    }
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.p;
  }
  
  public int getDuration()
  {
    b localb = this.a;
    if ((localb != null) && (this.e))
    {
      int i1 = this.c;
      if (i1 > 0) {
        return i1;
      }
      this.c = localb.g();
      return this.c;
    }
    this.c = -1;
    return this.c;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.z;
  }
  
  public String getVideoPath()
  {
    return this.b;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.f != 0) && (this.g != 0))
    {
      paramInt1 = getDefaultSize(1, paramInt1);
      paramInt2 = getDefaultSize(1, paramInt2);
      int i1 = this.f;
      int i2 = this.g;
      this.F.a(paramInt1, paramInt2, i1, i2);
      setMeasuredDimension(this.F.f, this.F.g);
      return;
    }
    setMeasuredDimension(1, 1);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.r = paramBoolean;
    this.F.a = this.r;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    b localb = this.a;
    if (localb != null) {
      localb.b(paramBoolean);
    }
    this.q = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    o.d("MicroMsg.Video.AbstractVideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.E = paramBoolean;
    b localb = this.a;
    if (localb != null)
    {
      if (this.E)
      {
        localb.a(0.0F, 0.0F);
        return;
      }
      localb.a(1.0F, 1.0F);
    }
  }
  
  public void setOnInfoCallback(d.b paramb)
  {
    this.l = paramb;
  }
  
  public void setOnSeekCompleteCallback(d.c paramc)
  {
    this.k = paramc;
  }
  
  public void setOnSurfaceCallback(d.d paramd)
  {
    this.m = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(d.e parame)
  {
    this.j = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(e.h paramh)
  {
    this.F.a(paramh);
    requestLayout();
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(d.a parama)
  {
    this.i = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    this.b = paramString;
    this.h = false;
    k();
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.a
 * JD-Core Version:    0.7.0.1
 */