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
    StringBuilder localStringBuilder = new StringBuilder("RenderFrame{, width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", rotate=");
    localStringBuilder.append(this.rotate);
    localStringBuilder.append(", flip=");
    localStringBuilder.append(this.flip);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.RenderFrame
 * JD-Core Version:    0.7.0.1
 */