package com.tencent.av.wtogether.gles;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.tencent.av.VideoController;
import com.tencent.av.wtogether.callback.VideoSink;
import com.tencent.av.wtogether.callback.WatchTogetherSurfaceLifeCallback;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class WatchTogetherVideoRenderHelper
  implements VideoSink, WatchTogetherSurfaceLifeCallback
{
  private final String a;
  private boolean b = false;
  private WatchTogetherSurfaceTextureHolder c;
  private final float d = 64.0F;
  private int e;
  private int f;
  private float[] g = new float[16];
  private int h;
  private int i = -1;
  private int j = -1;
  private float[] k;
  private TextureRender l;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = true;
  private boolean q = false;
  private WeakReference<GLSurfaceView> r;
  
  public WatchTogetherVideoRenderHelper(boolean paramBoolean)
  {
    this.q = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchTogetherVideoRenderHelper");
    String str;
    if (this.q) {
      str = "Floating-window";
    } else {
      str = "Full-screen";
    }
    localStringBuilder.append(str);
    this.a = localStringBuilder.toString();
  }
  
  private void a(Runnable paramRunnable)
  {
    WeakReference localWeakReference = this.r;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((GLSurfaceView)this.r.get()).queueEvent(paramRunnable);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    String str = this.a;
    int i2 = 1;
    QLog.d(str, 1, "onSizeChanged");
    int i1;
    if ((this.e == paramInt1) && (this.f == paramInt2)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((i1 != 0) || (!this.m))
    {
      this.e = paramInt1;
      this.f = paramInt2;
      this.l = new TextureRender();
    }
    paramInt1 = i2;
    if (i1 == 0) {
      if (!this.m) {
        paramInt1 = i2;
      } else {
        paramInt1 = 0;
      }
    }
    if (paramInt1 != 0) {
      this.h = -1;
    }
  }
  
  private void f()
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.a("tryReleaseVideoSink", this);
    }
  }
  
  private boolean g()
  {
    if (this.o)
    {
      WeakReference localWeakReference = this.r;
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        ((GLSurfaceView)this.r.get()).requestRender();
        QLog.d(this.a, 1, "run requestGLRender");
        return true;
      }
    }
    return false;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d(this.a, 1, "onSurfaceChange");
    c(paramInt1, paramInt2);
  }
  
  public void a(GLSurfaceView paramGLSurfaceView)
  {
    this.r = new WeakReference(paramGLSurfaceView);
  }
  
  public boolean a()
  {
    QLog.d(this.a, 1, "onVideoFrameResume");
    this.n = true;
    a(new WatchTogetherVideoRenderHelper.1(this));
    return false;
  }
  
  public boolean a(@NonNull WatchTogetherSurfaceTextureHolder paramWatchTogetherSurfaceTextureHolder, int paramInt1, int paramInt2)
  {
    try
    {
      this.c = paramWatchTogetherSurfaceTextureHolder;
      this.b = true;
      this.i = paramInt1;
      this.j = paramInt2;
      return g();
    }
    finally {}
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    ??? = this.c;
    int i1;
    if ((??? != null) && (???.c())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.o = true;
    if ((this.c != null) && (this.n))
    {
      if (i1 == 0) {
        return;
      }
      c(paramInt1, paramInt2);
    }
    for (;;)
    {
      synchronized (this.c)
      {
        if (this.b)
        {
          if (this.h < 0) {
            this.h = GlUtil.createTexture(36197);
          }
          this.c.a(this.h);
          this.c.a();
          this.c.a(this.g);
        }
        int i2 = AIOUtils.b(64.0F, ((GLSurfaceView)this.r.get()).getResources());
        int i3 = WTogetherUtil.a(((GLSurfaceView)this.r.get()).getContext());
        int i4 = WTogetherUtil.b();
        int i5 = WTogetherUtil.b();
        if (paramInt1 >= paramInt2) {
          break label301;
        }
        i1 = 1;
        if (i1 != 0)
        {
          GLES20.glViewport(0, paramInt2 - (i2 + i3 + i4), paramInt1, i5);
          this.k = GPUBaseFilter.caculateFitCenterMvpMatrix(this.i, this.j, paramInt1, i5);
        }
        else
        {
          GLES20.glViewport(0, 0, paramInt1, paramInt2);
          this.k = GPUBaseFilter.caculateFitCenterMvpMatrix(this.i, this.j, paramInt1, paramInt2);
        }
        this.l.drawTexture(36197, this.h, this.g, this.k);
        if (i1 != 0) {
          GLES20.glViewport(0, 0, paramInt1, paramInt2);
        }
        this.m = true;
        this.p = false;
        this.b = false;
        return;
      }
      return;
      label301:
      i1 = 0;
    }
  }
  
  public boolean b()
  {
    QLog.d(this.a, 1, "onVideoFramePause");
    this.n = false;
    a(new WatchTogetherVideoRenderHelper.2(this));
    return false;
  }
  
  public void c()
  {
    QLog.d(this.a, 1, "onSurfaceDestroy");
    if ((this.c != null) && (Build.VERSION.SDK_INT >= 16)) {
      synchronized (this.c)
      {
        if (this.m)
        {
          this.c.d();
          this.m = false;
        }
        this.c.e();
        this.h = -1;
      }
    }
    f();
    this.o = false;
    this.p = true;
    this.n = false;
    this.l = null;
    this.e = -1;
    this.f = -1;
  }
  
  public void d()
  {
    QLog.d(this.a, 1, "onSurfaceCreate");
  }
  
  public void e()
  {
    QLog.d(this.a, 1, "onActivityDestroy");
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      GLES20.glDisable(2929);
      GLES20.glDisable(3042);
      b(this.e, this.f);
      return;
    }
    catch (Exception paramGL10)
    {
      if (QLog.isColorLevel())
      {
        Object localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("WL_DEBUG onDrawFrame e = ");
        localStringBuilder.append(paramGL10);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
        localObject = paramGL10.getStackTrace();
        int i2 = localObject.length;
        int i1 = 0;
        paramGL10 = "";
        while (i1 < i2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramGL10);
          localStringBuilder.append("WL_DEBUG onDrawFrame ste[");
          localStringBuilder.append(i1);
          localStringBuilder.append("]");
          localStringBuilder.append(localObject[i1].toString());
          localStringBuilder.append("\n");
          paramGL10 = localStringBuilder.toString();
          i1 += 1;
        }
        QLog.e(this.a, 2, paramGL10);
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.gles.WatchTogetherVideoRenderHelper
 * JD-Core Version:    0.7.0.1
 */