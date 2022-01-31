package com.tencent.ark;

import android.graphics.Bitmap;
import android.graphics.Rect;

abstract interface ArkTextureView$ArkTextureViewInterface
{
  public abstract void checkSurfaceAvailable();
  
  public abstract void createContext();
  
  public abstract void destroyBitmapBuffer();
  
  public abstract Bitmap getBitmapBuffer();
  
  public abstract void initArkView(ArkViewModel paramArkViewModel);
  
  public abstract boolean onInvalidate(Rect paramRect);
  
  public abstract Bitmap recreateBitmapBuffer(Rect paramRect);
  
  public abstract void releaseContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkTextureView.ArkTextureViewInterface
 * JD-Core Version:    0.7.0.1
 */