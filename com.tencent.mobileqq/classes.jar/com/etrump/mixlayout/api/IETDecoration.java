package com.etrump.mixlayout.api;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract interface IETDecoration
{
  public abstract int currentFrameIndex();
  
  public abstract void deleteDescriptor();
  
  public abstract void deleteDescriptor(IETEngine paramIETEngine);
  
  public abstract void drawBackground(Bitmap paramBitmap, IETFont paramIETFont);
  
  public abstract void drawBackgroundSpace(Bitmap paramBitmap, IETFont paramIETFont, int paramInt1, int paramInt2);
  
  public abstract void drawForeground(Bitmap paramBitmap, IETFont paramIETFont);
  
  public abstract void drawFrameText(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4, IETFont paramIETFont);
  
  public abstract void drawSceneSpace(Bitmap paramBitmap, int paramInt1, int paramInt2, IETFont paramIETFont);
  
  public abstract int getFrameDelay();
  
  public abstract int getFrameNum();
  
  public abstract Rect getMargins();
  
  public abstract String getText();
  
  public abstract void gotoFrame(int paramInt);
  
  public abstract void gotoLastFrame();
  
  public abstract boolean isLastFrame();
  
  public abstract boolean nextFrame();
  
  public abstract void setNativeDescriptorHandle(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.api.IETDecoration
 * JD-Core Version:    0.7.0.1
 */