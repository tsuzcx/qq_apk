package com.google.android.filament;

import android.support.annotation.NonNull;
import android.support.annotation.Size;

public class Colors
{
  @NonNull
  @Size(3L)
  public static float[] cct(float paramFloat)
  {
    float[] arrayOfFloat = new float[3];
    nCct(paramFloat, arrayOfFloat);
    return arrayOfFloat;
  }
  
  @NonNull
  @Size(3L)
  public static float[] illuminantD(float paramFloat)
  {
    float[] arrayOfFloat = new float[3];
    nIlluminantD(paramFloat, arrayOfFloat);
    return arrayOfFloat;
  }
  
  private static native void nCct(float paramFloat, @NonNull @Size(3L) float[] paramArrayOfFloat);
  
  private static native void nIlluminantD(float paramFloat, @NonNull @Size(3L) float[] paramArrayOfFloat);
  
  @NonNull
  public static float[] toLinear(@NonNull Colors.Conversion paramConversion, @NonNull @Size(min=3L) float[] paramArrayOfFloat)
  {
    int i = 0;
    switch (Colors.1.$SwitchMap$com$google$android$filament$Colors$Conversion[paramConversion.ordinal()])
    {
    }
    for (;;)
    {
      return paramArrayOfFloat;
      i = 0;
      if (i < 3)
      {
        if (paramArrayOfFloat[i] <= 0.04045F) {}
        for (float f = paramArrayOfFloat[i] / 12.92F;; f = (float)Math.pow((paramArrayOfFloat[i] + 0.055F) / 1.055F, 2.400000095367432D))
        {
          paramArrayOfFloat[i] = f;
          i += 1;
          break;
        }
        while (i < 3)
        {
          paramArrayOfFloat[i] = ((float)Math.sqrt(paramArrayOfFloat[i]));
          i += 1;
        }
      }
    }
  }
  
  @NonNull
  @Size(3L)
  public static float[] toLinear(@NonNull Colors.RgbType paramRgbType, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return toLinear(paramRgbType, new float[] { paramFloat1, paramFloat2, paramFloat3 });
  }
  
  @NonNull
  @Size(min=3L)
  public static float[] toLinear(@NonNull Colors.RgbType paramRgbType, @NonNull @Size(min=3L) float[] paramArrayOfFloat)
  {
    if (paramRgbType == Colors.RgbType.LINEAR) {
      return paramArrayOfFloat;
    }
    return toLinear(Colors.Conversion.ACCURATE, paramArrayOfFloat);
  }
  
  @NonNull
  @Size(4L)
  public static float[] toLinear(@NonNull Colors.RgbaType paramRgbaType, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return toLinear(paramRgbaType, new float[] { paramFloat1, paramFloat2, paramFloat3, paramFloat4 });
  }
  
  @NonNull
  @Size(min=4L)
  public static float[] toLinear(@NonNull Colors.RgbaType paramRgbaType, @NonNull @Size(min=4L) float[] paramArrayOfFloat)
  {
    switch (Colors.1.$SwitchMap$com$google$android$filament$Colors$RgbaType[paramRgbaType.ordinal()])
    {
    case 4: 
    default: 
      return paramArrayOfFloat;
    case 1: 
      toLinear(Colors.Conversion.ACCURATE, paramArrayOfFloat);
    case 2: 
      float f = paramArrayOfFloat[3];
      paramArrayOfFloat[0] *= f;
      paramArrayOfFloat[1] *= f;
      paramArrayOfFloat[2] = (f * paramArrayOfFloat[2]);
      return paramArrayOfFloat;
    }
    return toLinear(Colors.Conversion.ACCURATE, paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.Colors
 * JD-Core Version:    0.7.0.1
 */