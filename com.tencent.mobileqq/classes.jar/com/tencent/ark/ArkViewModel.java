package com.tencent.ark;

import android.graphics.Rect;
import android.graphics.RectF;

public class ArkViewModel
  extends ArkViewModelBase
{
  protected static final String TAG = "ArkApp.ArkViewModel";
  protected IArkEGLContextManager mContextManager = null;
  protected ArkTextureViewImpl mHardwareView;
  protected boolean mIsSurfaceInvalid = false;
  
  public ArkViewModel(ark.ApplicationCallback paramApplicationCallback)
  {
    this(paramApplicationCallback, true);
  }
  
  public ArkViewModel(ark.ApplicationCallback paramApplicationCallback, boolean paramBoolean)
  {
    super(paramApplicationCallback);
    if ((paramBoolean) && (ENV.isHardwareAcceleration())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.mIsGpuRendering = paramBoolean;
    int i;
    if (ENV.isSingleThreadMode()) {
      i = 1;
    } else {
      i = 2;
    }
    this.mContextManager = ArkEGLContextManager.getManager(i);
    Logger.logI("ArkApp.ArkViewModel", String.format("ArkViewModel.create. single-thread-mode=%s, hardware-rendering=%s, virtual-context=%s", new Object[] { Boolean.toString(ENV.isSingleThreadMode()), Boolean.toString(this.mIsGpuRendering), Boolean.toString(EGLContextHolder.sIsVirtualContext) }));
  }
  
  public static EGLContextHolder getOffscreenContext()
  {
    if (!ENV.isHardwareAcceleration()) {
      return null;
    }
    return EGLContextHolder.getApplicationContext();
  }
  
  public static void precreateOfflineContext()
  {
    if (ENV.isSingleThreadMode()) {
      ArkDispatchTask.getInstance().postToArkThread(new ArkViewModel.1());
    }
  }
  
  public void Update(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super.Update(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.mIsSurfaceInvalid = true;
  }
  
  protected void applicationCreate(ark.Application paramApplication)
  {
    if (!ENV.isHardwareAcceleration())
    {
      Logger.logI("ArkApp.ArkViewModel", String.format("applicationCreate.app.no.hardware.rendering.this: %h", new Object[] { this }));
      super.applicationCreate(paramApplication);
      return;
    }
    if (paramApplication == null)
    {
      Logger.logE("ArkApp.ArkViewModel", String.format("applicationCreate.app.is.null.this: %h", new Object[] { this }));
      return;
    }
    paramApplication = this.mContextManager.createContext(this.mAppInfo.name);
    if (paramApplication == null) {
      Logger.logE("ArkApp.ArkViewModel", String.format("applicationCreate.createContext.fail.this: %h", new Object[] { this }));
    }
    EGLContextHolder.setApplicationContext(paramApplication);
  }
  
  protected void applicationRelease(ark.Application paramApplication)
  {
    if (!ENV.isHardwareAcceleration())
    {
      super.applicationRelease(paramApplication);
      return;
    }
    Logger.logE("ArkApp.ArkViewModel", String.format("applicationRelease.releaseContext.this: %h", new Object[] { this }));
    if (this.mContextManager.releaseContext(this.mAppInfo.name)) {
      EGLContextHolder.setApplicationContext(null);
    }
  }
  
  public void createDrawTarget(ArkViewImplement paramArkViewImplement)
  {
    Logger.logI("ArkApp.ArkViewModel", String.format("createDrawTarget.this.%h.app.%s.container.%h", new Object[] { this, this.mAppInfo.name, this.mContainer }));
    if (!this.mIsGpuRendering)
    {
      super.createDrawTarget(paramArkViewImplement);
      return;
    }
    this.mTimeRecord.beginOfCreateDrawTarget = System.currentTimeMillis();
    paramArkViewImplement = this.mHardwareView;
    if (paramArkViewImplement != null)
    {
      if (this.mRectContainer.isEmpty()) {
        return;
      }
      if (this.mContainer != null)
      {
        if (!this.mContainer.CreateHardwareBitmap(this.mRectContainer.width(), this.mRectContainer.height())) {
          Logger.logI("ArkApp.ArkViewModel", String.format("createDrawTarget.this.%h.app.%s.container.%h", new Object[] { this, this.mAppInfo.name, this.mContainer }));
        }
        this.mContainer.SetContextHolder(paramArkViewImplement.getContextHolder());
      }
      invalidateRect();
      this.mTimeRecord.endOfCreateDrawTarget = System.currentTimeMillis();
    }
  }
  
  public void destroyDrawTarget()
  {
    if (!this.mIsGpuRendering)
    {
      super.destroyDrawTarget();
      return;
    }
    Logger.logI("ArkApp.ArkViewModel", String.format("destroyDrawTarget.this.%h.app.%s.container.%h", new Object[] { this, this.mAppInfo.name, this.mContainer }));
    if (this.mContainer != null)
    {
      this.mContainer.SetContextHolder(null);
      this.mContainer.DestroyHardwareBitmap();
    }
  }
  
  public void detachView()
  {
    super.detachView();
    this.mHardwareView = null;
  }
  
  public void doFrame()
  {
    if (!this.mIsGpuRendering)
    {
      super.doFrame();
      return;
    }
    int i;
    if ((ENV.mIsDebug) && (ENV.mShowVsyncLog)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!this.mSyncRectLock) && (this.mAttached))
    {
      beginDraw();
      if ((!this.mRectInvalidF.isEmpty()) && (this.mContainer.Paint(this.mRectInvalidF.left, this.mRectInvalidF.top, this.mRectInvalidF.right, this.mRectInvalidF.bottom)))
      {
        if (i != 0) {
          Logger.logI("ArkApp.ArkViewModel", String.format("doFrame.paint.succ.%h.(%.1f, %.1f, %.1f, %.1f)", new Object[] { this, Float.valueOf(this.mRectContainerF.left), Float.valueOf(this.mRectContainerF.top), Float.valueOf(this.mRectContainerF.right), Float.valueOf(this.mRectContainerF.bottom) }));
        }
        this.mRectInvalidF.setEmpty();
      }
      if ((this.mIsSurfaceInvalid) && (this.mContainer.InvalidSurface()))
      {
        this.mIsSurfaceInvalid = false;
        if (i != 0) {
          Logger.logI("ArkApp.ArkViewModel", String.format("doFrame.invalid.succ.%h", new Object[] { this }));
        }
        endDraw();
        didFirstPaint();
      }
      return;
    }
    if (i != 0) {
      Logger.logE("ArkApp.ArkViewModel", String.format("doFrame.fail.1.%h", new Object[] { this }));
    }
  }
  
  public EGLContextHolder getContext()
  {
    return this.mContextManager.getContext(this.mAppInfo.name);
  }
  
  protected boolean initArkContainer(ArkViewImplement paramArkViewImplement)
  {
    if (paramArkViewImplement != null)
    {
      if (paramArkViewImplement.getView() == null) {
        return false;
      }
      if (this.mIsGpuRendering)
      {
        if (!(paramArkViewImplement.getView() instanceof ArkTextureViewImpl)) {
          return false;
        }
        this.mHardwareView = ((ArkTextureViewImpl)paramArkViewImplement.getView());
      }
      return super.initArkContainer(paramArkViewImplement);
    }
    return false;
  }
  
  protected void initLibrary()
  {
    ark.MediaSetStub(ArkPlayer.sFactory);
  }
  
  public void invalidateRect()
  {
    super.invalidateRect();
    this.mRectInvalidF.set(this.mRectContainerF);
    this.mIsSurfaceInvalid = true;
  }
  
  public boolean isGpuRenderingEnabled()
  {
    return this.mIsGpuRendering;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModel
 * JD-Core Version:    0.7.0.1
 */