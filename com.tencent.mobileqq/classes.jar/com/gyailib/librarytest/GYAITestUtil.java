package com.gyailib.librarytest;

import android.graphics.Bitmap;
import com.gyailib.library.GYDetectCommonResultStruct;

public class GYAITestUtil
{
  static
  {
    try
    {
      System.loadLibrary("c++_shared");
      System.loadLibrary("gy_test_all");
      return;
    }
    catch (Error localError)
    {
      localError.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static native double[][] compareDetectCommonResult(GYDetectCommonResultStruct paramGYDetectCommonResultStruct1, GYDetectCommonResultStruct paramGYDetectCommonResultStruct2);
  
  public static native float differChannel(Bitmap paramBitmap1, Bitmap paramBitmap2, float paramFloat);
  
  public static native float[] iou(Bitmap paramBitmap1, Bitmap paramBitmap2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.librarytest.GYAITestUtil
 * JD-Core Version:    0.7.0.1
 */