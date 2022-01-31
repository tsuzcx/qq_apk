package com.google.android.filament;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

public final class MathUtils
{
  private static native void nPackTangentFrame(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, @NonNull @Size(min=4L) float[] paramArrayOfFloat, @IntRange(from=0L) int paramInt);
  
  public static void packTangentFrame(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, @NonNull @Size(min=4L) float[] paramArrayOfFloat)
  {
    nPackTangentFrame(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramArrayOfFloat, 0);
  }
  
  public static void packTangentFrame(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, @NonNull @Size(min=4L) float[] paramArrayOfFloat, @IntRange(from=0L) int paramInt)
  {
    nPackTangentFrame(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramArrayOfFloat, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.MathUtils
 * JD-Core Version:    0.7.0.1
 */