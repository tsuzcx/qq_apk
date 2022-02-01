package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

public class b
{
  public static int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt2, paramFloat1 / paramFloat2) + paramInt1;
    if (paramInt1 < 0) {
      return 0;
    }
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private static int a(int paramInt, float paramFloat)
  {
    if (paramInt > 180) {
      if (paramInt <= 600) {
        paramInt = 180;
      } else if (paramInt <= 1800) {
        paramInt = 300;
      } else {
        paramInt = 600;
      }
    }
    return (int)(paramInt * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.b
 * JD-Core Version:    0.7.0.1
 */