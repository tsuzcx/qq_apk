package com.tencent.component.media.animwebp;

public class AnimWebPInfo
{
  private static final String TAG = "AnimWebPInfo";
  private int backgroundColor;
  private int canvasHeight;
  private int canvasWidth;
  private int durationMillis;
  private int frameCount;
  private int frameNumber;
  private int height;
  private int loopCount;
  private int width;
  private int xOffset;
  private int yOffset;
  
  public AnimWebPInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.xOffset = paramInt3;
    this.yOffset = paramInt4;
    this.backgroundColor = paramInt5;
    this.canvasWidth = paramInt6;
    this.canvasHeight = paramInt7;
    this.frameCount = paramInt8;
    this.loopCount = paramInt9;
    this.durationMillis = paramInt10;
    this.frameNumber = paramInt11;
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public int getCanvasHeight()
  {
    return this.canvasHeight;
  }
  
  public int getCanvasWidth()
  {
    return this.canvasWidth;
  }
  
  public int getDurationMillis()
  {
    return this.durationMillis;
  }
  
  public int getFrameCount()
  {
    return this.frameCount;
  }
  
  public int getFrameNumber()
  {
    return this.frameNumber;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getLoopCount()
  {
    return this.loopCount;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int getxOffset()
  {
    return this.xOffset;
  }
  
  public int getyOffset()
  {
    return this.yOffset;
  }
  
  public String toString()
  {
    return "AnimWebPInfo{width=" + this.width + ", height=" + this.height + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", backgroundColor=" + this.backgroundColor + ", canvasWidth=" + this.canvasWidth + ", canvasHeight=" + this.canvasHeight + ", frameCount=" + this.frameCount + ", loopCount=" + this.loopCount + ", durationMillis=" + this.durationMillis + ", frameNumber=" + this.frameNumber + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.animwebp.AnimWebPInfo
 * JD-Core Version:    0.7.0.1
 */