package com.Vas.ColorFont;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class FastColorFontHelper
{
  private static FastColorFontHelper jdField_a_of_type_ComVasColorFontFastColorFontHelper;
  static boolean jdField_a_of_type_Boolean = false;
  private FreeTypeLib jdField_a_of_type_ComVasColorFontFreeTypeLib = new FreeTypeLib();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public AtomicBoolean a;
  public AtomicBoolean b = new AtomicBoolean(false);
  public AtomicBoolean c = new AtomicBoolean(false);
  
  private FastColorFontHelper()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static FastColorFontHelper a()
  {
    if (jdField_a_of_type_ComVasColorFontFastColorFontHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComVasColorFontFastColorFontHelper == null) {
        jdField_a_of_type_ComVasColorFontFastColorFontHelper = new FastColorFontHelper();
      }
      return jdField_a_of_type_ComVasColorFontFastColorFontHelper;
    }
    finally {}
  }
  
  int a(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.getExtraBitmap(paramInt, paramBitmap1, paramBitmap2);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt)))
    {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      int[] arrayOfInt = new int[3];
      int i = this.jdField_a_of_type_ComVasColorFontFreeTypeLib.initColorFont(paramInt, paramString, arrayOfInt);
      FastColorFontLog.a("FastColorFontHelper", "initColorFont  fontId=" + paramInt + "  fontWidth:" + arrayOfInt[1] + "  fontHeight:" + arrayOfInt[2] + "  lineSpace:" + arrayOfInt[0] + "  path=" + paramString);
      if (i >= 2)
      {
        FastColorFontCache.b(paramInt, i);
        FastColorFontCache.a(paramInt, arrayOfInt[0]);
        FastColorFontCache.d(paramInt, arrayOfInt[1]);
        FastColorFontCache.c(paramInt, arrayOfInt[2]);
      }
      if ((paramInt >= 8388608) || (paramInt <= -8388608)) {
        FastColorFontLog.b("FastColorFontHelper", "为了缓存不出现问题，字体id最好限制在3个字节以内！");
      }
      return i;
    }
    FastColorFontLog.a("FastColorFontHelper", "该字体已经初始化  fontId=" + paramInt + "  path=" + paramString);
    return 0;
  }
  
  int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap, int paramInt2, int paramInt3)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.drawText(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramBitmap, paramInt2, paramInt3);
  }
  
  int a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, int[] paramArrayOfInt6)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.drawAnimationText(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5, paramBitmap1, paramBitmap2, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramArrayOfInt6);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib.getFontVersion(paramString);
  }
  
  public FreeTypeLib a()
  {
    return this.jdField_a_of_type_ComVasColorFontFreeTypeLib;
  }
  
  void a(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2)
  {
    this.jdField_a_of_type_ComVasColorFontFreeTypeLib.getTextWidths(paramInt1, paramArrayOfInt1, paramInt2, paramArrayOfInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.Vas.ColorFont.FastColorFontHelper
 * JD-Core Version:    0.7.0.1
 */