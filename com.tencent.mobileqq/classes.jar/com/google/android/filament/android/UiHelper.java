package com.google.android.filament.android;

import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class UiHelper
{
  private static final boolean LOGGING = false;
  private static final String LOG_TAG = "UiHelper";
  private int mDesiredHeight;
  private int mDesiredWidth;
  private boolean mHasSwapChain;
  private Object mNativeWindow;
  private boolean mOpaque = true;
  private UiHelper.RendererCallback mRenderCallback;
  private UiHelper.RenderSurface mRenderSurface;
  
  public UiHelper()
  {
    this(UiHelper.ContextErrorPolicy.CHECK);
  }
  
  public UiHelper(UiHelper.ContextErrorPolicy paramContextErrorPolicy) {}
  
  private boolean attach(@NonNull Object paramObject)
  {
    if (this.mNativeWindow != null)
    {
      if (this.mNativeWindow == paramObject) {
        return false;
      }
      destroySwapChain();
    }
    this.mNativeWindow = paramObject;
    return true;
  }
  
  private void createSwapChain(@NonNull Surface paramSurface)
  {
    this.mRenderCallback.onNativeWindowChanged(paramSurface);
    this.mHasSwapChain = true;
  }
  
  private void destroySwapChain()
  {
    if (this.mRenderSurface != null) {
      this.mRenderSurface.detach();
    }
    this.mRenderCallback.onDetachedFromSurface();
    this.mHasSwapChain = false;
  }
  
  public void attachTo(@NonNull SurfaceView paramSurfaceView)
  {
    int i = -3;
    if (attach(paramSurfaceView))
    {
      if (!isOpaque())
      {
        paramSurfaceView.setZOrderOnTop(true);
        paramSurfaceView.getHolder().setFormat(-3);
      }
      this.mRenderSurface = new UiHelper.SurfaceViewHandler(this, paramSurfaceView);
      UiHelper.1 local1 = new UiHelper.1(this);
      paramSurfaceView = paramSurfaceView.getHolder();
      paramSurfaceView.addCallback(local1);
      paramSurfaceView.setFixedSize(this.mDesiredWidth, this.mDesiredHeight);
      Surface localSurface = paramSurfaceView.getSurface();
      if ((localSurface != null) && (localSurface.isValid()))
      {
        local1.surfaceCreated(paramSurfaceView);
        if (isOpaque()) {
          i = -1;
        }
        local1.surfaceChanged(paramSurfaceView, i, paramSurfaceView.getSurfaceFrame().width(), paramSurfaceView.getSurfaceFrame().height());
      }
    }
  }
  
  public void attachTo(@NonNull TextureView paramTextureView)
  {
    if (attach(paramTextureView))
    {
      paramTextureView.setOpaque(isOpaque());
      this.mRenderSurface = new UiHelper.TextureViewHandler(this, paramTextureView);
      UiHelper.2 local2 = new UiHelper.2(this);
      paramTextureView.setSurfaceTextureListener(local2);
      if (paramTextureView.isAvailable()) {
        local2.onSurfaceTextureAvailable(paramTextureView.getSurfaceTexture(), this.mDesiredWidth, this.mDesiredHeight);
      }
    }
  }
  
  public void detach()
  {
    destroySwapChain();
    this.mNativeWindow = null;
    this.mRenderSurface = null;
  }
  
  public int getDesiredHeight()
  {
    return this.mDesiredHeight;
  }
  
  public int getDesiredWidth()
  {
    return this.mDesiredWidth;
  }
  
  @Nullable
  public UiHelper.RendererCallback getRenderCallback()
  {
    return this.mRenderCallback;
  }
  
  public long getSwapChainFlags()
  {
    if (isOpaque()) {
      return 0L;
    }
    return 1L;
  }
  
  public boolean isOpaque()
  {
    return this.mOpaque;
  }
  
  public boolean isReadyToRender()
  {
    return this.mHasSwapChain;
  }
  
  public void setDesiredSize(int paramInt1, int paramInt2)
  {
    this.mDesiredWidth = paramInt1;
    this.mDesiredHeight = paramInt2;
    if (this.mRenderSurface != null) {
      this.mRenderSurface.resize(paramInt1, paramInt2);
    }
  }
  
  public void setOpaque(boolean paramBoolean)
  {
    this.mOpaque = paramBoolean;
  }
  
  public void setRenderCallback(@Nullable UiHelper.RendererCallback paramRendererCallback)
  {
    this.mRenderCallback = paramRendererCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.android.UiHelper
 * JD-Core Version:    0.7.0.1
 */