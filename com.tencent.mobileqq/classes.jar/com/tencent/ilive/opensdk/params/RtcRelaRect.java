package com.tencent.ilive.opensdk.params;

public class RtcRelaRect
{
  public float h = 1.0F;
  public float w = 1.0F;
  public float x = 0.0F;
  public float y = 0.0F;
  
  public RtcRelaRect() {}
  
  public RtcRelaRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.w = paramFloat3;
    this.h = paramFloat4;
  }
  
  public String toString()
  {
    return " " + this.x + "," + this.y + "," + this.w + "," + this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.RtcRelaRect
 * JD-Core Version:    0.7.0.1
 */