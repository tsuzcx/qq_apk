package com.tencent.TMG.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Process;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.TMG.opengl.glrenderer.GLCanvas;
import com.tencent.TMG.opengl.glrenderer.GLES11Canvas;
import com.tencent.TMG.opengl.glrenderer.GLES20Canvas;
import com.tencent.TMG.opengl.texture.BasicTexture;
import com.tencent.TMG.opengl.texture.UploadedTexture;
import com.tencent.TMG.opengl.utils.Utils;
import com.tencent.TMG.utils.QLog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class GLRootView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private static final boolean DEBUG_DRAWING_STAT = false;
  private static final boolean DEBUG_FPS = false;
  private static final int FLAG_INITIALIZED = 1;
  private static final int FLAG_NEED_LAYOUT = 2;
  private static final String TAG = "GLRootView";
  private GLCanvas mCanvas;
  protected GLView mContentView;
  private boolean mFirstDraw = true;
  private int mFlags = 2;
  private int mFrameCount = 0;
  private long mFrameCountingStart = 0L;
  private boolean mFreeze;
  private final Condition mFreezeCondition = this.mRenderLock.newCondition();
  private GL11 mGL;
  private boolean mInDownState = false;
  long mLastRenderTime = 0L;
  private final ReentrantLock mRenderLock = new ReentrantLock();
  private volatile boolean mRenderRequested = false;
  private Runnable mRequestRenderOnAnimationFrame = new GLRootView.1(this);
  
  public GLRootView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GLRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    this.mFlags = (0x1 | this.mFlags);
    setBackgroundDrawable(null);
    setEGLContextClientVersion(Utils.getGLVersion(paramContext));
    if (Utils.USE_888_PIXEL_FORMAT) {
      setEGLConfigChooser(8, 8, 8, 0, 0, 0);
    } else {
      setEGLConfigChooser(5, 6, 5, 0, 0, 0);
    }
    setRenderer(this);
    if (Utils.USE_888_PIXEL_FORMAT)
    {
      getHolder().setFormat(3);
      return;
    }
    getHolder().setFormat(4);
  }
  
  private void layoutContentPane()
  {
    this.mFlags &= 0xFFFFFFFD;
    int i = getWidth();
    int j = getHeight();
    GLView localGLView = this.mContentView;
    if ((localGLView != null) && (i != 0) && (j != 0)) {
      localGLView.layout(0, 0, i, j);
    }
  }
  
  private void outputFps()
  {
    long l1 = System.nanoTime();
    long l2 = this.mFrameCountingStart;
    if (l2 == 0L)
    {
      this.mFrameCountingStart = l1;
    }
    else if (l1 - l2 > 1000000000L)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fps: ");
        double d1 = this.mFrameCount;
        Double.isNaN(d1);
        double d2 = l1 - this.mFrameCountingStart;
        Double.isNaN(d2);
        localStringBuilder.append(d1 * 1000000000.0D / d2);
        QLog.d("GLRootView", 0, localStringBuilder.toString());
      }
      this.mFrameCountingStart = l1;
      this.mFrameCount = 0;
    }
    this.mFrameCount += 1;
  }
  
  private void superRequestRender()
  {
    super.requestRender();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = isEnabled();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i != 3) && (i != 1))
    {
      if ((!this.mInDownState) && (i != 0)) {
        return false;
      }
    }
    else {
      this.mInDownState = false;
    }
    this.mRenderLock.lock();
    bool1 = bool2;
    try
    {
      if (this.mContentView != null)
      {
        bool1 = bool2;
        if (this.mContentView.dispatchTouchEvent(paramMotionEvent)) {
          bool1 = true;
        }
      }
      if ((i == 0) && (bool1)) {
        this.mInDownState = true;
      }
      return bool1;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
  }
  
  public void freeze()
  {
    this.mRenderLock.lock();
    this.mFreeze = true;
    this.mRenderLock.unlock();
  }
  
  public void lockRenderThread()
  {
    this.mRenderLock.lock();
  }
  
  protected void onDetachedFromWindow()
  {
    unfreeze();
    super.onDetachedFromWindow();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    AnimationTime.update();
    this.mRenderLock.lock();
    while (this.mFreeze) {
      this.mFreezeCondition.awaitUninterruptibly();
    }
    try
    {
      onDrawFrameLocked(paramGL10);
      this.mRenderLock.unlock();
      if (this.mFirstDraw)
      {
        paramGL10 = this.mContentView;
        if (paramGL10 != null)
        {
          this.mFirstDraw = false;
          paramGL10.onFirstDraw();
        }
      }
      this.mLastRenderTime = SystemClock.elapsedRealtime();
      return;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
    for (;;)
    {
      throw paramGL10;
    }
  }
  
  protected void onDrawFrameLocked(GL10 paramGL10)
  {
    this.mCanvas.deleteRecycledResources();
    UploadedTexture.resetUploadLimit();
    this.mRenderRequested = false;
    if ((this.mFlags & 0x2) != 0) {
      layoutContentPane();
    }
    paramGL10 = this.mContentView;
    if (paramGL10 != null) {
      paramGL10.render(this.mCanvas);
    } else {
      this.mCanvas.clearBuffer();
    }
    if (UploadedTexture.uploadLimitReached()) {
      requestRender();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      requestLayoutContentPane();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    freeze();
  }
  
  public void onResume()
  {
    unfreeze();
    super.onResume();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSurfaceChanged: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("x");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", gl10: ");
      localStringBuilder.append(paramGL10.toString());
      QLog.i("GLRootView", 0, localStringBuilder.toString());
    }
    Process.setThreadPriority(-4);
    this.mCanvas.setSize(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = (GL11)paramGL10;
    if ((this.mGL != null) && (QLog.isColorLevel()))
    {
      paramEGLConfig = new StringBuilder();
      paramEGLConfig.append("GLObject has changed from ");
      paramEGLConfig.append(this.mGL);
      paramEGLConfig.append(" to ");
      paramEGLConfig.append(paramGL10);
      QLog.d("GLRootView", 0, paramEGLConfig.toString());
    }
    this.mRenderLock.lock();
    try
    {
      this.mGL = paramGL10;
      if (Utils.getGLVersion(getContext().getApplicationContext()) >= 2) {
        paramGL10 = new GLES20Canvas();
      } else {
        paramGL10 = new GLES11Canvas(paramGL10);
      }
      this.mCanvas = paramGL10;
      BasicTexture.invalidateAllTextures();
      this.mRenderLock.unlock();
      setRenderMode(0);
      return;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
  }
  
  public void requestLayoutContentPane()
  {
    this.mRenderLock.lock();
    try
    {
      if ((this.mContentView != null) && ((this.mFlags & 0x2) == 0))
      {
        int i = this.mFlags;
        if ((i & 0x1) != 0) {}
      }
      else
      {
        return;
      }
      this.mFlags |= 0x2;
      requestRender();
      return;
    }
    finally
    {
      this.mRenderLock.unlock();
    }
  }
  
  @SuppressLint({"NewApi"})
  public void requestRender()
  {
    if (this.mRenderRequested)
    {
      super.postDelayed(this.mRequestRenderOnAnimationFrame, 30L);
      return;
    }
    this.mRenderRequested = true;
    long l = SystemClock.elapsedRealtime() - this.mLastRenderTime;
    if ((l > 0L) && (l < 33L))
    {
      super.postDelayed(this.mRequestRenderOnAnimationFrame, 33L - l);
      return;
    }
    if (Utils.HAS_POST_ON_ANIMATION)
    {
      postOnAnimation(this.mRequestRenderOnAnimationFrame);
      return;
    }
    super.requestRender();
  }
  
  public void requestRenderForced()
  {
    superRequestRender();
  }
  
  public void setContentPane(GLView paramGLView)
  {
    Object localObject = this.mContentView;
    if (localObject == paramGLView) {
      return;
    }
    if (localObject != null)
    {
      if (this.mInDownState)
      {
        long l = SystemClock.uptimeMillis();
        localObject = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.mContentView.dispatchTouchEvent((MotionEvent)localObject);
        ((MotionEvent)localObject).recycle();
        this.mInDownState = false;
      }
      this.mContentView.detachFromRoot();
      BasicTexture.yieldAllTextures();
    }
    this.mContentView = paramGLView;
    if (paramGLView != null)
    {
      paramGLView.attachToRoot(this);
      requestLayoutContentPane();
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    unfreeze();
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    unfreeze();
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    unfreeze();
    super.surfaceDestroyed(paramSurfaceHolder);
  }
  
  public void unfreeze()
  {
    this.mRenderLock.lock();
    this.mFreeze = false;
    this.mFreezeCondition.signalAll();
    this.mRenderLock.unlock();
  }
  
  public void unlockRenderThread()
  {
    this.mRenderLock.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.GLRootView
 * JD-Core Version:    0.7.0.1
 */