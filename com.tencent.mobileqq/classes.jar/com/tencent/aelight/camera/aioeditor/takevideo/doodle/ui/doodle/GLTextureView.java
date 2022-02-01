package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

@TargetApi(14)
public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static int a;
  private static final GLTextureView.GLThreadManager f = new GLTextureView.GLThreadManager(null);
  private boolean b;
  private Runnable c = new GLTextureView.2(this);
  int d = 0;
  int e = 0;
  private final WeakReference<GLTextureView> g = new WeakReference(this);
  private GLTextureView.GLThread h;
  private GLSurfaceView.Renderer i;
  private boolean j;
  private GLTextureView.EGLConfigChooser k;
  private GLTextureView.EGLContextFactory l;
  private GLTextureView.EGLWindowSurfaceFactory m;
  private GLTextureView.GLWrapper n;
  private int o;
  private int p;
  private boolean q;
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  @SuppressLint({"UseValueOf"})
  public static Integer a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (Integer)paramContext.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(paramContext, new Object[] { new String(paramString), new Integer(paramInt) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext)
    {
      label67:
      break label67;
    }
    return Integer.valueOf(paramInt);
  }
  
  private void a()
  {
    a = a(getContext(), "ro.opengles.version", 0).intValue();
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(new GLTextureView.1(this));
  }
  
  private void b()
  {
    if (this.h == null) {
      return;
    }
    throw new IllegalStateException("setRenderer has already been called for this instance.");
  }
  
  @TargetApi(14)
  private float getViewAlpha()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return getAlpha();
    }
    return 1.0F;
  }
  
  @TargetApi(14)
  private void setViewAlpha(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      setAlpha(paramFloat);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TextureView setAlpha,alpha:");
        localStringBuilder.append(paramFloat);
        QLog.d("GLTextureView", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.h.d();
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = System.currentTimeMillis();
    if ((this.d != paramInt2) || (this.e != paramInt3))
    {
      this.d = paramInt2;
      this.e = paramInt3;
      this.h.a(paramInt2, paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("GLTextureView", 2, " surfaceChanged, onWindowResize");
      }
    }
    removeCallbacks(this.c);
    if ((this.b) && (getViewAlpha() != 1.0F)) {
      setViewAlpha(1.0F);
    }
    if (QLog.isColorLevel())
    {
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append(" surfaceChanged, w:");
      paramSurfaceTexture.append(paramInt2);
      paramSurfaceTexture.append(",h:");
      paramSurfaceTexture.append(paramInt3);
      paramSurfaceTexture.append(" use:");
      paramSurfaceTexture.append(System.currentTimeMillis() - l1);
      QLog.d("GLTextureView", 2, paramSurfaceTexture.toString());
    }
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    this.h.e();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.h.a(paramRunnable);
  }
  
  public void c()
  {
    this.h.c();
  }
  
  protected void finalize()
  {
    try
    {
      if (this.h != null) {
        this.h.f();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return this.o;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.q;
  }
  
  public int getRenderMode()
  {
    return this.h.b();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.j) && (this.i != null))
    {
      GLTextureView.GLThread localGLThread = this.h;
      int i1;
      if (localGLThread != null) {
        i1 = localGLThread.b();
      } else {
        i1 = 1;
      }
      this.h = new GLTextureView.GLThread(this.g);
      if (i1 != 1) {
        this.h.a(i1);
      }
      this.h.start();
    }
    this.j = false;
  }
  
  protected void onDetachedFromWindow()
  {
    GLTextureView.GLThread localGLThread = this.h;
    if (localGLThread != null) {
      localGLThread.f();
    }
    this.j = true;
    super.onDetachedFromWindow();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.b = true;
    this.d = 0;
    this.e = 0;
    Log.d("GLTextureView", "onSurfaceTextureAvailable");
    long l1 = System.currentTimeMillis();
    a(paramSurfaceTexture);
    postDelayed(this.c, 250L);
    if (QLog.isColorLevel())
    {
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append(" TextureView onSurfaceTextureAvailable surfaceCreated use:");
      paramSurfaceTexture.append(System.currentTimeMillis() - l1);
      QLog.d("GLTextureView", 2, paramSurfaceTexture.toString());
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.b = false;
    Log.d("GLTextureView", "onSurfaceTextureDestroyed");
    b(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureDestroyed");
    }
    setViewAlpha(0.0F);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    Log.d("GLTextureView", "onSurfaceTextureSizeChanged");
    a(paramSurfaceTexture, 0, paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append(" TextureView onSurfaceTextureSizeChanged surfaceChanged use:");
      paramSurfaceTexture.append(System.currentTimeMillis() - l1);
      QLog.d("GLTextureView", 2, paramSurfaceTexture.toString());
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setDebugFlags(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new GLTextureView.ComponentSizeChooser(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(GLTextureView.EGLConfigChooser paramEGLConfigChooser)
  {
    b();
    this.k = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new GLTextureView.SimpleEGLConfigChooser(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    b();
    this.p = paramInt;
  }
  
  public void setEGLContextFactory(GLTextureView.EGLContextFactory paramEGLContextFactory)
  {
    b();
    this.l = paramEGLContextFactory;
  }
  
  public void setEGLWindowSurfaceFactory(GLTextureView.EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    b();
    this.m = paramEGLWindowSurfaceFactory;
  }
  
  public void setGLWrapper(GLTextureView.GLWrapper paramGLWrapper)
  {
    this.n = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.h.a(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    b();
    if (this.k == null) {
      this.k = new GLTextureView.SimpleEGLConfigChooser(this, true);
    }
    if (this.l == null) {
      this.l = new GLTextureView.DefaultContextFactory(this, null);
    }
    if (this.m == null) {
      this.m = new GLTextureView.DefaultWindowSurfaceFactory(null);
    }
    this.i = paramRenderer;
    this.h = new GLTextureView.GLThread(this.g);
    this.h.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView
 * JD-Core Version:    0.7.0.1
 */