package com.tencent.component.media.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public abstract interface NewGifDecoder
{
  public abstract void changeFile(String paramString);
  
  public abstract NewGifDecoder.GifFrame doRender(Bitmap paramBitmap);
  
  public abstract Bitmap.Config getAcceptableConfig();
  
  public abstract long getAllocationByteCount();
  
  public abstract String getComment();
  
  public abstract int getCurrentFrameIndex();
  
  public abstract int getCurrentLoop();
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract int getError();
  
  public abstract int getFrameCount();
  
  public abstract int getFrameDuration(int paramInt);
  
  public abstract int getHeight();
  
  public abstract int getImageCount();
  
  public abstract int getLoopCount();
  
  public abstract long getSourceLength();
  
  public abstract int getWidth();
  
  public abstract boolean isAnimationCompleted();
  
  public abstract boolean isRecycled();
  
  public abstract NewGifDecoder.GifFrame next(Bitmap paramBitmap);
  
  public abstract NewGifDecoder.GifFrame nextForGifPlay(Bitmap paramBitmap, boolean paramBoolean);
  
  public abstract void prepareData();
  
  public abstract void recycle();
  
  public abstract boolean reset();
  
  public abstract Bitmap seekToFrame(int paramInt, Bitmap paramBitmap);
  
  public abstract NewGifDecoder.GifFrame seekToFrameGetTime(int paramInt, Bitmap paramBitmap);
  
  public abstract Bitmap seekToTime(int paramInt, Bitmap paramBitmap);
  
  public abstract void setGifInfoHandler(GifInfoHandle paramGifInfoHandle);
  
  public abstract void setLoopCount(int paramInt);
  
  public abstract void setSpeed(float paramFloat);
  
  public abstract long start();
  
  public abstract void stop();
  
  public abstract void updateFile(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDecoder
 * JD-Core Version:    0.7.0.1
 */