package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ReadOnlyBufferException;

public class Renderer
{
  public static final int MIRROR_FRAME_FLAG_CLEAR = 4;
  public static final int MIRROR_FRAME_FLAG_COMMIT = 1;
  public static final int MIRROR_FRAME_FLAG_SET_PRESENTATION_TIME = 2;
  private final Engine mEngine;
  private long mNativeObject;
  
  Renderer(@NonNull Engine paramEngine, long paramLong)
  {
    this.mEngine = paramEngine;
    this.mNativeObject = paramLong;
  }
  
  private static native boolean nBeginFrame(long paramLong1, long paramLong2);
  
  private static native void nCopyFrame(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  private static native void nEndFrame(long paramLong);
  
  private static native double nGetUserTime(long paramLong);
  
  private static native int nReadPixels(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Buffer paramBuffer, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, Object paramObject, Runnable paramRunnable);
  
  private static native int nReadPixelsEx(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Buffer paramBuffer, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, Object paramObject, Runnable paramRunnable);
  
  private static native void nRender(long paramLong1, long paramLong2);
  
  private static native void nResetUserTime(long paramLong);
  
  public boolean beginFrame(@NonNull SwapChain paramSwapChain)
  {
    return nBeginFrame(getNativeObject(), paramSwapChain.getNativeObject());
  }
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public void copyFrame(@NonNull SwapChain paramSwapChain, @NonNull Viewport paramViewport1, @NonNull Viewport paramViewport2, int paramInt)
  {
    nCopyFrame(getNativeObject(), paramSwapChain.getNativeObject(), paramViewport1.left, paramViewport1.bottom, paramViewport1.width, paramViewport1.height, paramViewport2.left, paramViewport2.bottom, paramViewport2.width, paramViewport2.height, paramInt);
  }
  
  public void endFrame()
  {
    nEndFrame(getNativeObject());
  }
  
  @NonNull
  public Engine getEngine()
  {
    return this.mEngine;
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed Renderer");
    }
    return this.mNativeObject;
  }
  
  public double getUserTime()
  {
    return nGetUserTime(getNativeObject());
  }
  
  @Deprecated
  public void mirrorFrame(@NonNull SwapChain paramSwapChain, @NonNull Viewport paramViewport1, @NonNull Viewport paramViewport2, int paramInt)
  {
    copyFrame(paramSwapChain, paramViewport1, paramViewport2, paramInt);
  }
  
  public void readPixels(@IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4, @NonNull Texture.PixelBufferDescriptor paramPixelBufferDescriptor)
  {
    if (paramPixelBufferDescriptor.storage.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (nReadPixels(getNativeObject(), this.mEngine.getNativeObject(), paramInt1, paramInt2, paramInt3, paramInt4, paramPixelBufferDescriptor.storage, paramPixelBufferDescriptor.storage.remaining(), paramPixelBufferDescriptor.left, paramPixelBufferDescriptor.top, paramPixelBufferDescriptor.type.ordinal(), paramPixelBufferDescriptor.alignment, paramPixelBufferDescriptor.stride, paramPixelBufferDescriptor.format.ordinal(), paramPixelBufferDescriptor.handler, paramPixelBufferDescriptor.callback) < 0) {
      throw new BufferOverflowException();
    }
  }
  
  public void readPixels(@NonNull RenderTarget paramRenderTarget, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4, @NonNull Texture.PixelBufferDescriptor paramPixelBufferDescriptor)
  {
    if (paramPixelBufferDescriptor.storage.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (nReadPixelsEx(getNativeObject(), this.mEngine.getNativeObject(), paramRenderTarget.getNativeObject(), paramInt1, paramInt2, paramInt3, paramInt4, paramPixelBufferDescriptor.storage, paramPixelBufferDescriptor.storage.remaining(), paramPixelBufferDescriptor.left, paramPixelBufferDescriptor.top, paramPixelBufferDescriptor.type.ordinal(), paramPixelBufferDescriptor.alignment, paramPixelBufferDescriptor.stride, paramPixelBufferDescriptor.format.ordinal(), paramPixelBufferDescriptor.handler, paramPixelBufferDescriptor.callback) < 0) {
      throw new BufferOverflowException();
    }
  }
  
  public void render(@NonNull View paramView)
  {
    nRender(getNativeObject(), paramView.getNativeObject());
  }
  
  public void resetUserTime()
  {
    nResetUserTime(getNativeObject());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.Renderer
 * JD-Core Version:    0.7.0.1
 */