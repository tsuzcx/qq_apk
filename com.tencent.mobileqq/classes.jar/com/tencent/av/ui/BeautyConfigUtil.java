package com.tencent.av.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class BeautyConfigUtil
{
  private static String a = "QAVPreSetting";
  private static String b = "BeautyFeature";
  private static String c = "BeautyValue";
  private static String d = "BeautyConfig";
  private static String e = "BeautyResetGuide";
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(a, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localSharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(a, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    localSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public static boolean a(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static String b(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(a, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append(paramString);
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public static int c(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(a, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), -1);
  }
  
  public static int d(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(a, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.BeautyConfigUtil
 * JD-Core Version:    0.7.0.1
 */