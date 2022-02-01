package com.tencent.mobileqq.apollo.view.opengl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class GLSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback2, GLRenderView
{
  public static final int RENDERMODE_CONTINUOUSLY = 1;
  public static final int RENDERMODE_WHEN_DIRTY = 0;
  private static final String TAG = "[ApolloGL][GLSurfaceView]";
  private static final GLThreadManager sGLThreadManager = new GLThreadManager();
  private int mDebugFlags;
  private boolean mDetached;
  private EGLConfigChooser mEGLConfigChooser;
  private int mEGLContextClientVersion;
  private EGLContextFactory mEGLContextFactory;
  private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
  private GLThread mGLThread;
  private GLWrapper mGLWrapper;
  private boolean mPreserveEGLContextOnPause;
  private Renderer mRenderer;
  private final WeakReference<GLRenderView> mThisWeakRef = new WeakReference(this);
  
  public GLSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void checkRenderThreadState()
  {
    if (this.mGLThread == null) {
      return;
    }
    throw new IllegalStateException("setRenderer has already been called for this instance.");
  }
  
  private void init()
  {
    GLThreadManager.b(getContext());
    getHolder().addCallback(this);
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mGLThread != null) {
        this.mGLThread.h();
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
    return this.mDebugFlags;
  }
  
  public EGLConfigChooser getEGLConfigChooser()
  {
    return this.mEGLConfigChooser;
  }
  
  public EGLContextFactory getEGLContextFactory()
  {
    return this.mEGLContextFactory;
  }
  
  public EGLWindowSurfaceFactory getEGLWindowSurfaceFactory()
  {
    return this.mEGLWindowSurfaceFactory;
  }
  
  public long getGLThreadId()
  {
    GLThread localGLThread = this.mGLThread;
    if (localGLThread != null) {
      return localGLThread.getId();
    }
    return -1L;
  }
  
  public GLWrapper getGLWrapper()
  {
    return this.mGLWrapper;
  }
  
  public Object getNativeWindow()
  {
    return getHolder();
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.mPreserveEGLContextOnPause;
  }
  
  public int getRenderMode()
  {
    return this.mGLThread.b();
  }
  
  public Renderer getRenderer()
  {
    return this.mRenderer;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAttachedToWindow reattach =");
    ((StringBuilder)localObject).append(this.mDetached);
    QLog.d("[ApolloGL][GLSurfaceView]", 1, ((StringBuilder)localObject).toString());
    if ((this.mDetached) && (this.mRenderer != null))
    {
      localObject = this.mGLThread;
      int i;
      if (localObject != null) {
        i = ((GLThread)localObject).b();
      } else {
        i = 1;
      }
      this.mGLThread = new GLThread(sGLThreadManager, this.mThisWeakRef);
      if (i != 1) {
        this.mGLThread.a(i);
      }
      this.mGLThread.start();
    }
    this.mDetached = false;
  }
  
  protected void onDetachedFromWindow()
  {
    QLog.d("[ApolloGL][GLSurfaceView]", 1, "onDetachedFromWindow");
    GLThread localGLThread = this.mGLThread;
    if (localGLThread != null) {
      localGLThread.h();
    }
    this.mDetached = true;
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    this.mGLThread.f();
  }
  
  public void onResume()
  {
    this.mGLThread.g();
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    this.mGLThread.c(paramRunnable);
  }
  
  public void requestRender()
  {
    this.mGLThread.c();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.mDebugFlags = paramInt;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new ComponentSizeChooser(this.mEGLContextClientVersion, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(EGLConfigChooser paramEGLConfigChooser)
  {
    checkRenderThreadState();
    this.mEGLConfigChooser = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new SimpleEGLConfigChooser(this.mEGLContextClientVersion, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    checkRenderThreadState();
    this.mEGLContextClientVersion = paramInt;
  }
  
  public void setEGLContextFactory(EGLContextFactory paramEGLContextFactory)
  {
    checkRenderThreadState();
    this.mEGLContextFactory = paramEGLContextFactory;
  }
  
  public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory)
  {
    checkRenderThreadState();
    this.mEGLWindowSurfaceFactory = paramEGLWindowSurfaceFactory;
  }
  
  public void setGLWrapper(GLWrapper paramGLWrapper)
  {
    this.mGLWrapper = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.mPreserveEGLContextOnPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mGLThread.a(paramInt);
  }
  
  public void setRenderer(Renderer paramRenderer)
  {
    checkRenderThreadState();
    if (this.mEGLConfigChooser == null) {
      this.mEGLConfigChooser = new SimpleEGLConfigChooser(this.mEGLContextClientVersion, true);
    }
    if (this.mEGLContextFactory == null) {
      this.mEGLContextFactory = new DefaultContextFactory(this.mEGLContextClientVersion);
    }
    if (this.mEGLWindowSurfaceFactory == null) {
      this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
    }
    this.mRenderer = paramRenderer;
    this.mGLThread = new GLThread(sGLThreadManager, this.mThisWeakRef);
    this.mGLThread.start();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mGLThread.a(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mGLThread.d();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mGLThread.e();
  }
  
  @Deprecated
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceRedrawNeededAsync(SurfaceHolder paramSurfaceHolder, Runnable paramRunnable)
  {
    paramSurfaceHolder = this.mGLThread;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.a(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLSurfaceView
 * JD-Core Version:    0.7.0.1
 */