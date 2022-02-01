package com.Vas.ColorFont;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;

public class FastColorFontLog
{
  public static final String a = Build.MANUFACTURER;
  public static final String b = Build.MODEL;
  
  public static void a(String paramString1, long paramLong, String paramString2)
  {
    if (!FastColorFontHelper.a) {
      return;
    }
    float f = (float)(System.nanoTime() - paramLong) / 1000000.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("  绘制耗时：");
    localStringBuilder.append(f);
    localStringBuilder.append("ms\n  手机型号：");
    localStringBuilder.append(a);
    localStringBuilder.append("  ");
    localStringBuilder.append(b);
    a(paramString1, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FastColorFontLog
 * JD-Core Version:    0.7.0.1
 */