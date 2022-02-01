package com.tencent.mobileqq.apollo.view.opengl;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener, GLRenderView
{
  private static final String TAG = "[ApolloGL][GLTextureView]";
  private static final GLThreadManager sGLThreadManager = new GLThreadManager();
  private int mDebugFlags;
  private boolean mDestroyOnAsync;
  private boolean mDetached;
  protected boolean mDisableCreateRenderThread;
  private EGLConfigChooser mEGLConfigChooser;
  private int mEGLContextClientVersion;
  private EGLContextFactory mEGLContextFactory;
  private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
  private GLTextureView.FinishDrawing mFinishDrawing = new GLTextureView.FinishDrawing(this, null);
  private Runnable mForceSetAlphaTask = new GLTextureView.2(this);
  private GLThread mGLThread;
  private GLWrapper mGLWrapper;
  private boolean mPreserveEGLContextOnPause;
  private Renderer mRenderer;
  int mSurfaceHeight = 0;
  int mSurfaceWidth = 0;
  private final WeakReference<GLRenderView> mThisWeakRef = new WeakReference(this);
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public static void checkGLVersion(Context paramContext)
  {
    GLThreadManager.a(paramContext);
  }
  
  private void checkRenderThreadState()
  {
    if (this.mGLThread == null) {
      return;
    }
    throw new IllegalStateException("setRenderer has already been called for this instance.");
  }
  
  private void checkSetAlpha()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.mUIHandler.post(this.mForceSetAlphaTask);
      return;
    }
    this.mForceSetAlphaTask.run();
  }
  
  @TargetApi(14)
  private float getViewAlpha()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return getAlpha();
    }
    return 1.0F;
  }
  
  private void init()
  {
    GLThreadManager.b(getContext());
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(new GLTextureView.1(this));
    setViewAlpha(0.0F);
  }
  
  @TargetApi(14)
  private void setViewAlpha(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      setAlpha(paramFloat);
    }
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
    return getSurfaceTexture();
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.mPreserveEGLContextOnPause;
  }
  
  public int getRenderMode()
  {
    return this.mGLThread.b();
  }
  
  public String getRenderThreadName()
  {
    return "GLTexture_";
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
    ((StringBuilder)localObject).append(", mDisableCreateRenderThread: ");
    ((StringBuilder)localObject).append(this.mDisableCreateRenderThread);
    QLog.d("[ApolloGL][GLTextureView]", 1, ((StringBuilder)localObject).toString());
    if ((this.mDetached) && (this.mRenderer != null))
    {
      localObject = this.mGLThread;
      int i;
      if (localObject != null) {
        i = ((GLThread)localObject).b();
      } else {
        i = 1;
      }
      if (!this.mDisableCreateRenderThread)
      {
        this.mGLThread = new GLThread(sGLThreadManager, this.mThisWeakRef);
        this.mGLThread.a(this.mDestroyOnAsync);
        localObject = this.mGLThread;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getRenderThreadName());
        localStringBuilder.append("_");
        localStringBuilder.append(this.mGLThread.getId());
        ((GLThread)localObject).setName(localStringBuilder.toString());
        this.mGLThread.b(false);
        if (i != 1) {
          this.mGLThread.a(i);
        }
        this.mGLThread.start();
      }
      else
      {
        QLog.e("[ApolloGL][GLTextureView]", 1, "onAttachedToWindow mDisableCreateRenderThread true");
      }
    }
    this.mDetached = false;
  }
  
  protected void onDetachedFromWindow()
  {
    QLog.d("[ApolloGL][GLTextureView]", 1, "onDetachedFromWindow");
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
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mGLThread.b(this.mFinishDrawing);
    this.mSurfaceWidth = 0;
    this.mSurfaceHeight = 0;
    QLog.d("[ApolloGL][GLTextureView]", 1, "onSurfaceTextureAvailable");
    long l = System.currentTimeMillis();
    surfaceCreated(paramSurfaceTexture);
    boolean bool = QLog.isColorLevel();
    Integer localInteger = Integer.valueOf(2);
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" TextureView onSurfaceTextureAvailable surfaceCreated cost:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("[ApolloGL][GLTextureView]", 1, new Object[] { localInteger, localStringBuilder.toString() });
    }
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append(" TextureView onSurfaceTextureAvailable surfaceChanged cost:");
      paramSurfaceTexture.append(System.currentTimeMillis() - l);
      QLog.d("[ApolloGL][GLTextureView]", 1, new Object[] { localInteger, paramSurfaceTexture.toString() });
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d("[ApolloGL][GLTextureView]", 1, "onSurfaceTextureDestroyed");
    surfaceDestroyed(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.d("[ApolloGL][GLTextureView]", 1, "TextureView onSurfaceTextureDestroyed");
    }
    setViewAlpha(0.0F);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    QLog.d("[ApolloGL][GLTextureView]", 1, "onSurfaceTextureSizeChanged");
    surfaceChanged(paramSurfaceTexture, 0, paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append("TextureView onSurfaceTextureSizeChanged surfaceChanged cost:");
      paramSurfaceTexture.append(System.currentTimeMillis() - l);
      QLog.d("[ApolloGL][GLTextureView]", 1, paramSurfaceTexture.toString());
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
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
  
  public void setDestroyOnAsync(boolean paramBoolean)
  {
    this.mDestroyOnAsync = paramBoolean;
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
    this.mGLThread.a(this.mDestroyOnAsync);
    paramRenderer = this.mGLThread;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getRenderThreadName());
    localStringBuilder.append("_");
    localStringBuilder.append(this.mGLThread.getId());
    paramRenderer.setName(localStringBuilder.toString());
    this.mGLThread.b(false);
    this.mGLThread.start();
  }
  
  public void surfaceChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    if ((this.mSurfaceWidth == paramInt2) && (this.mSurfaceHeight == paramInt3))
    {
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append("surfaceChanged, bug width and height not change. width:");
      paramSurfaceTexture.append(paramInt2);
      paramSurfaceTexture.append(", height:");
      paramSurfaceTexture.append(paramInt3);
      paramSurfaceTexture.append(", cost:");
      paramSurfaceTexture.append(System.currentTimeMillis() - l);
      QLog.d("[ApolloGL][GLTextureView]", 1, paramSurfaceTexture.toString());
      return;
    }
    this.mSurfaceWidth = paramInt2;
    this.mSurfaceHeight = paramInt3;
    this.mGLThread.b(this.mFinishDrawing);
    this.mGLThread.a(paramInt2, paramInt3);
    paramSurfaceTexture = new StringBuilder();
    paramSurfaceTexture.append("surfaceChanged, onWindowResize, width/height change to ");
    paramSurfaceTexture.append(paramInt2);
    paramSurfaceTexture.append("/");
    paramSurfaceTexture.append(paramInt3);
    paramSurfaceTexture.append(", cost:");
    paramSurfaceTexture.append(System.currentTimeMillis() - l);
    QLog.d("[ApolloGL][GLTextureView]", 1, paramSurfaceTexture.toString());
  }
  
  public void surfaceCreated(SurfaceTexture paramSurfaceTexture)
  {
    this.mGLThread.d();
  }
  
  public void surfaceDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mGLThread.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLTextureView
 * JD-Core Version:    0.7.0.1
 */