package com.tencent.gdtad.util;

import android.graphics.Bitmap;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.qphone.base.util.QLog;

public class GdtSmartBlur
{
  public boolean a = false;
  
  private GdtSmartBlur()
  {
    a();
  }
  
  public static GdtSmartBlur a()
  {
    return GdtSmartBlur.GdtSmartBlurHolder.a;
  }
  
  private void a()
  {
    try
    {
      System.loadLibrary("smart-blur");
      this.a = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GdtSmartBlur", 1, "load library error", localThrowable);
      this.a = false;
    }
  }
  
  private native void blurBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    int j = VcSystemInfo.getNumCores();
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    blurBitmap(paramBitmap, paramInt, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtSmartBlur
 * JD-Core Version:    0.7.0.1
 */