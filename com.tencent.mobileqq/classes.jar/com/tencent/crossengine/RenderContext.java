package com.tencent.crossengine;

import android.view.Surface;
import com.tencent.crossengine.util.DisplayInfo;

public class RenderContext
{
  private static final String TAG = "RenderContext";
  private int height;
  private DisplayInfo mDisplayInfo;
  private long mNativeHandle = nCreateNativeRenderContext(paramDisplayInfo.a());
  private int width;
  
  public RenderContext(DisplayInfo paramDisplayInfo)
  {
    this.mDisplayInfo = paramDisplayInfo;
  }
  
  private native long nCreateNativeRenderContext(boolean paramBoolean);
  
  private native void nExit(long paramLong);
  
  private native void nInitRenderContext(long paramLong, Surface paramSurface, int paramInt1, int paramInt2, float paramFloat);
  
  private native void nOnPause(long paramLong);
  
  private native void nOnResume(long paramLong);
  
  private native void nSurfaceChanged(long paramLong, Surface paramSurface, int paramInt1, int paramInt2);
  
  private native void nSurfaceDestroyed(long paramLong);
  
  private native void nUpdateRenderContext(long paramLong);
  
  public void destroy()
  {
    nExit(this.mNativeHandle);
  }
  
  public void destroyRenderContext()
  {
    nSurfaceDestroyed(this.mNativeHandle);
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public long getNativeHandle()
  {
    return this.mNativeHandle;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void initRenderContext(Surface paramSurface, int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    nInitRenderContext(this.mNativeHandle, paramSurface, (int)(paramInt1 / this.mDisplayInfo.a()), (int)(paramInt2 / this.mDisplayInfo.a()), this.mDisplayInfo.a());
  }
  
  public void pause()
  {
    nOnPause(this.mNativeHandle);
  }
  
  public void resume()
  {
    nOnResume(this.mNativeHandle);
  }
  
  public void surfaceChanged(Surface paramSurface, int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    nSurfaceChanged(this.mNativeHandle, paramSurface, (int)(paramInt1 / this.mDisplayInfo.a()), (int)(paramInt2 / this.mDisplayInfo.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.RenderContext
 * JD-Core Version:    0.7.0.1
 */