package com.microrapid.opencv;

import java.io.Serializable;

public class ImageMainColorData
  implements Serializable
{
  private static final float COLOR_MAX = 255.0F;
  private static final float COLOR_MIN = 0.0F;
  private static final float HUE_MAX = 360.0F;
  private static final float HUE_MIN = 0.0F;
  private static final float LUM_MAX = 1.0F;
  private static final float LUM_MIN = 0.0F;
  private static final float PERCENT_MAX = 100.0F;
  private static final float PERCENT_MIN = 0.0F;
  public final float area;
  public final float b;
  public final float g;
  public final float h;
  public final float l;
  public final float r;
  
  public ImageMainColorData(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.r = correctValue(paramFloat1, 0.0F, 255.0F);
    this.g = correctValue(paramFloat2, 0.0F, 255.0F);
    this.b = correctValue(paramFloat3, 0.0F, 255.0F);
    this.l = correctValue(paramFloat4, 0.0F, 1.0F);
    this.h = correctValue(paramFloat5, 0.0F, 360.0F);
    this.area = correctValue(paramFloat6, 0.0F, 100.0F);
  }
  
  private static float correctValue(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  public String toString()
  {
    return "ImageMainColorData{r=" + this.r + ", g=" + this.g + ", b=" + this.b + ", l=" + this.l + ", h=" + this.h + ", area=" + this.area + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.microrapid.opencv.ImageMainColorData
 * JD-Core Version:    0.7.0.1
 */