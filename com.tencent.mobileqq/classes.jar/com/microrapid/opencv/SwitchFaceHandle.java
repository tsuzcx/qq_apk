package com.microrapid.opencv;

import android.graphics.Bitmap;

public class SwitchFaceHandle
{
  private static native void nativeSwitchFace(Bitmap paramBitmap1, int[][] paramArrayOfInt1, Bitmap paramBitmap2, int[][] paramArrayOfInt2, Bitmap paramBitmap3);
  
  public static void switchFace(Bitmap paramBitmap1, int[][] paramArrayOfInt1, Bitmap paramBitmap2, int[][] paramArrayOfInt2, Bitmap paramBitmap3)
  {
    nativeSwitchFace(paramBitmap1, paramArrayOfInt1, paramBitmap2, paramArrayOfInt2, paramBitmap3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.opencv.SwitchFaceHandle
 * JD-Core Version:    0.7.0.1
 */