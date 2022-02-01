package com.tencent.ilive.opensdk.params;

public class RenderFrame
{
  public boolean flip = false;
  public byte[] frameBytes;
  public int height = 0;
  public int rotate = 0;
  public int width = 0;
  
  public void reset()
  {
    this.width = 0;
    this.height = 0;
    this.rotate = 0;
    this.flip = false;
    this.frameBytes = null;
  }
  
  public String toString()
  {
    return "RenderFrame{, width=" + this.width + ", height=" + this.height + ", rotate=" + this.rotate + ", flip=" + this.flip + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.RenderFrame
 * JD-Core Version:    0.7.0.1
 */