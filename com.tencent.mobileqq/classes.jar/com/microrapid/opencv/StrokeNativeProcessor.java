package com.microrapid.opencv;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class StrokeNativeProcessor
{
  public static Bitmap getOutlineImage(Bitmap paramBitmap, Rect paramRect, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[4];
    paramBitmap = nativeOutlineImage(paramBitmap, arrayOfInt, paramDouble1, paramDouble2, paramDouble3, paramInt1, paramInt2, paramInt3, paramBoolean);
    paramRect.left = arrayOfInt[0];
    paramRect.top = arrayOfInt[1];
    paramRect.right = (arrayOfInt[0] + arrayOfInt[2]);
    paramRect.bottom = (arrayOfInt[1] + arrayOfInt[3]);
    return paramBitmap;
  }
  
  public static native Bitmap nativeOutlineImage(Bitmap paramBitmap, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.microrapid.opencv.StrokeNativeProcessor
 * JD-Core Version:    0.7.0.1
 */