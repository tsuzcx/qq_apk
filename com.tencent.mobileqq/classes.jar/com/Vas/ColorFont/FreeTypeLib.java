package com.Vas.ColorFont;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class FreeTypeLib
{
  private int[] a;
  
  private int[] a()
  {
    if (this.a == null)
    {
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      this.a = new int[] { localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels };
    }
    return this.a;
  }
  
  public void a()
  {
    int i = 1;
    int[] arrayOfInt = a();
    if (QLog.isColorLevel()) {
      QLog.d("FreeTypeLib", 2, "initFreeTypeLib screenSize = " + arrayOfInt[0] + ", " + arrayOfInt[1]);
    }
    int j = arrayOfInt[0];
    int k = arrayOfInt[1];
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      initRender(j, k, i);
      return;
      i = 0;
    }
  }
  
  public native int checkColorFontVersion(String paramString);
  
  public native int drawAnimationText(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, int[] paramArrayOfInt6);
  
  public native int drawText(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap, int paramInt2, int paramInt3);
  
  public native int getExtraBitmap(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public native int getFontVersion(String paramString);
  
  public native int getTextWidths(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2);
  
  public native int initColorFont(int paramInt, String paramString, int[] paramArrayOfInt);
  
  public native void initRender(int paramInt1, int paramInt2, int paramInt3);
  
  public native void releaseColorFonts();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.Vas.ColorFont.FreeTypeLib
 * JD-Core Version:    0.7.0.1
 */