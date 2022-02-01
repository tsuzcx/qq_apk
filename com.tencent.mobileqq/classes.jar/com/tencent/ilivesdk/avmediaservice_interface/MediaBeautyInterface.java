package com.tencent.ilivesdk.avmediaservice_interface;

import android.graphics.Rect;

public abstract interface MediaBeautyInterface
{
  public abstract void changeBeautyMode(int paramInt);
  
  public abstract int getCameraId();
  
  public abstract boolean isMirror();
  
  public abstract boolean isSupportBeautyRender();
  
  public abstract boolean isUseBeautyRender();
  
  public abstract void mirrorCamera(boolean paramBoolean);
  
  public abstract void setBeauty(int paramInt);
  
  public abstract boolean setFocus(Rect paramRect);
  
  public abstract void setVideoFilter(String paramString, float paramFloat);
  
  public abstract void setWhiten(int paramInt);
  
  public abstract void setupCosmeticsLevel(int paramInt1, int paramInt2);
  
  public abstract void switchCamera();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avmediaservice_interface.MediaBeautyInterface
 * JD-Core Version:    0.7.0.1
 */