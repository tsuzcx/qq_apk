package com.tencent.ark;

import android.graphics.Rect;
import android.graphics.RectF;
import javax.microedition.khronos.egl.EGL10;

public class ArkViewModel
  extends ArkViewModelBase
{
  protected static final String TAG = "ArkApp.ArkViewModel";
  protected static EGLContextHolder sOffscreenContext;
  protected ArkTextureView mHardwareView;
  protected final boolean mIsGpuRendering = ENV.isHardwareAcceleration();
  protected boolean mIsSurfaceInvalid = false;
  
  public ArkViewModel(ark.ApplicationCallback paramApplicationCallback)
  {
    super(paramApplicationCallback);
  }
  
  public static EGLContextHolder getOffscreenContext()
  {
    if (!ENV.isHardwareAcceleration()) {
      return null;
    }
    if (sOffscreenContext == null)
    {
      sOffscreenContext = new EGLContextHolder();
      if (!sOffscreenContext.create(EGL10.EGL_NO_CONTEXT, null, 1, 1))
      {
        ENV.logE("ArkApp.ArkViewModel", "sOffscreenContext.create.fail");
        sOffscreenContext.release();
        sOffscreenContext = null;
        return null;
      }
    }
    return sOffscreenContext;
  }
  
  public static void precreateOfflineContext()
  {
    if (ENV.mIsDebug) {
      ENV.logI("ArkApp.ArkViewModel", "precreateOfflineContext");
    }
    if (ArkDispatchTask.getInstance().isTaskThread())
    {
      getOffscreenContext();
      return;
    }
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        ArkViewModel.getOffscreenContext();
      }
    });
  }
  
  public void Update(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super.Update(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.mIsSurfaceInvalid = true;
  }
  
  protected void applicationCreate(ark.Application paramApplication)
  {
    if (!this.mIsGpuRendering) {
      super.applicationCreate(paramApplication);
    }
    while ((paramApplication == null) || (getOffscreenContext() != null)) {
      return;
    }
    ENV.logE("ArkApp.ArkViewModel", String.format("getOffscreenContext.fail.this: %h", new Object[] { this }));
  }
  
  public void createDrawTarget(ArkViewImplement paramArkViewImplement)
  {
    if (!this.mIsGpuRendering) {
      super.createDrawTarget(paramArkViewImplement);
    }
    do
    {
      return;
      this.mTimeRecord.beginOfCreateDrawTarget = System.currentTimeMillis();
      paramArkViewImplement = this.mHardwareView;
    } while ((paramArkViewImplement == null) || (this.mRectContainer.isEmpty()));
    if (this.mContainer != null)
    {
      if (this.mContainer.CreateHardwareBitmap(this.mRectContainer.width(), this.mRectContainer.height())) {
        this.mRectInvalidF.set(this.mRectContainerF);
      }
      this.mContainer.SetContextHolder(paramArkViewImplement.getContextHolder());
    }
    this.mIsSurfaceInvalid = true;
    this.mTimeRecord.endOfCreateDrawTarget = System.currentTimeMillis();
  }
  
  public void destroyDrawTarget()
  {
    if (!this.mIsGpuRendering) {
      super.destroyDrawTarget();
    }
    while (this.mContainer == null) {
      return;
    }
    this.mContainer.SetContextHolder(null);
    this.mContainer.DestroyHardwareBitmap();
  }
  
  public void detachView()
  {
    super.detachView();
    this.mHardwareView = null;
  }
  
  public void doFrame()
  {
    if (!this.mIsGpuRendering) {
      super.doFrame();
    }
    int i;
    label77:
    do
    {
      return;
      if ((ENV.mIsDebug) && (ENV.mShowVsyncLog)) {}
      for (i = 1;; i = 0)
      {
        if ((!this.mSyncRectLock) && (this.mAttached)) {
          break label77;
        }
        if (i == 0) {
          break;
        }
        ENV.logE("ArkApp.ArkViewModel", String.format("doFrame.fail.1.%h", new Object[] { this }));
        return;
      }
      beginDraw();
      if ((!this.mRectInvalidF.isEmpty()) && (this.mContainer.Paint(this.mRectInvalidF.left, this.mRectInvalidF.top, this.mRectInvalidF.right, this.mRectInvalidF.bottom)))
      {
        if (i != 0) {
          ENV.logE("ArkApp.ArkViewModel", String.format("doFrame.paint.succ.%h.(%.1f, %.1f, %.1f, %.1f)", new Object[] { this, Float.valueOf(this.mRectContainerF.left), Float.valueOf(this.mRectContainerF.top), Float.valueOf(this.mRectContainerF.right), Float.valueOf(this.mRectContainerF.bottom) }));
        }
        this.mRectInvalidF.setEmpty();
      }
    } while ((!this.mIsSurfaceInvalid) || (!this.mContainer.InvalidSurface()));
    this.mIsSurfaceInvalid = false;
    if (i != 0) {
      ENV.logE("ArkApp.ArkViewModel", String.format("doFrame.invalid.succ.%h", new Object[] { this }));
    }
    endDraw();
  }
  
  protected boolean initArkContainer(ArkViewImplement paramArkViewImplement)
  {
    if (this.mIsGpuRendering)
    {
      if (!(paramArkViewImplement.getView() instanceof ArkTextureView)) {
        return false;
      }
      this.mHardwareView = ((ArkTextureView)paramArkViewImplement.getView());
    }
    return super.initArkContainer(paramArkViewImplement);
  }
  
  protected void initLibrary()
  {
    ark.MediaSetStub(ArkPlayer.sFactory);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ark.ArkViewModel
 * JD-Core Version:    0.7.0.1
 */