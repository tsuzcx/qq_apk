package com.tencent.ad.tangram.canvas.views;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  implements Serializable
{
  public int currentLength;
  public AtomicInteger hasLoadedFirstImages;
  public volatile boolean hasLoadedImage;
  
  public a(int paramInt, boolean paramBoolean, AtomicInteger paramAtomicInteger)
  {
    this.currentLength = paramInt;
    this.hasLoadedImage = paramBoolean;
    this.hasLoadedFirstImages = paramAtomicInteger;
  }
  
  public int getCurrentLength()
  {
    return this.currentLength;
  }
  
  public AtomicInteger getHasLoadedFirstImages()
  {
    return this.hasLoadedFirstImages;
  }
  
  public boolean isHasLoadedImage()
  {
    return this.hasLoadedImage;
  }
  
  public void setCurrentLength(int paramInt)
  {
    this.currentLength = paramInt;
  }
  
  public void setHasLoadedFirstImages(AtomicInteger paramAtomicInteger)
  {
    this.hasLoadedFirstImages = paramAtomicInteger;
  }
  
  public void setHasLoadedImage(boolean paramBoolean)
  {
    this.hasLoadedImage = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.a
 * JD-Core Version:    0.7.0.1
 */