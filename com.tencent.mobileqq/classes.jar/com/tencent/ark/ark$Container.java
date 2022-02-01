package com.tencent.ark;

import android.graphics.Bitmap;

public class ark$Container
  extends ark.NativeObject
{
  public ark$Container()
  {
    this.mNative = newNativeObject(this);
  }
  
  private static final native void deleteNativeObject(long paramLong);
  
  private static final native long newNativeObject(Container paramContainer);
  
  public native boolean ActivateRootView();
  
  public native boolean AttachBitmap(Bitmap paramBitmap);
  
  public native boolean CheckShare();
  
  public native boolean CreateHardwareBitmap(int paramInt1, int paramInt2);
  
  public native boolean CreateRootView(ark.Application paramApplication, String paramString);
  
  public native boolean DeactivateRootView();
  
  public void DeletePtr()
  {
    deleteNativeObject(this.mNative);
    this.mNative = 0L;
  }
  
  public native void DestroyHardwareBitmap();
  
  public native void DetachBitmap(Bitmap paramBitmap);
  
  public native long GetViewHandle();
  
  public native boolean GetViewOpaque();
  
  public native String GetViewShare();
  
  public native boolean InputCanRedo();
  
  public native boolean InputCanUndo();
  
  public native boolean InputDeleteBackward();
  
  public native String InputGetSelectText();
  
  public native boolean InputInsertText(String paramString);
  
  public native boolean InputIsFocused();
  
  public native boolean InputRedo();
  
  public native boolean InputSelect();
  
  public native boolean InputSelectAll();
  
  public native boolean InputSetCaretHolderSize(int paramInt1, int paramInt2);
  
  public native boolean InputSetSelectHolderSize(int paramInt1, int paramInt2);
  
  public native boolean InputUndo();
  
  public native boolean InvalidSurface();
  
  public native boolean Paint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native void SetBorderHornLeft(boolean paramBoolean);
  
  public native void SetBorderRadius(float paramFloat);
  
  public native void SetBorderRadiusTop(float paramFloat);
  
  public native void SetBorderType(int paramInt);
  
  public native void SetContainerCallback(ark.ContainerCallback paramContainerCallback);
  
  public native void SetContextHolder(EGLContextHolder paramEGLContextHolder);
  
  public native void SetDisableGPURasterization(boolean paramBoolean);
  
  public native void SetDisableGPURendering(boolean paramBoolean);
  
  public native void SetID(String paramString);
  
  public native void SetMetadata(String paramString1, String paramString2);
  
  public native void SetShowFps(boolean paramBoolean);
  
  public native void SetSize(int paramInt1, int paramInt2);
  
  public native void TouchCancel(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt, int paramInt);
  
  public native void TouchEnd(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt, int paramInt);
  
  public native void TouchMove(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt, int paramInt);
  
  public native void TouchStart(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt, int paramInt);
  
  public native void ViewEvent(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ark.Container
 * JD-Core Version:    0.7.0.1
 */