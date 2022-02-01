package com.tencent.biz.pubaccount.weishi_new.report;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public class WSReportUtils
{
  private static final int[] a = { 1, 2, 9, 12, 10007 };
  private static SparseArray<String> b = new SparseArray();
  private static String c = "";
  private static String d = "";
  
  public static int a(boolean paramBoolean)
  {
    int j = WSReportEventConstants.d;
    int i = 3;
    if ((j != 1) && (WSReportEventConstants.e != 1) && (!paramBoolean) && (!WSReportEventConstants.c))
    {
      if ((WSReportEventConstants.d != 2) && (WSReportEventConstants.e != 2))
      {
        if (WSReportEventConstants.d != 3)
        {
          if (WSReportEventConstants.e == 3) {
            return 3;
          }
          return 0;
        }
      }
      else {
        return 2;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  public static String a()
  {
    return d;
  }
  
  public static String a(int paramInt)
  {
    String str = (String)b.get(paramInt);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "";
  }
  
  public static void a(int paramInt, String paramString)
  {
    b.put(paramInt, paramString);
  }
  
  public static void a(String paramString)
  {
    d = paramString;
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = e();
    }
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = WSExpABTestManager.a().A();
    }
    return paramString;
  }
  
  public static void b()
  {
    b.clear();
  }
  
  public static String c()
  {
    return c;
  }
  
  public static void c(String paramString)
  {
    c = paramString;
  }
  
  public static void d()
  {
    c = "";
  }
  
  public static boolean d(String paramString)
  {
    return (TextUtils.equals(paramString, "fullscreen_videoplay")) || (TextUtils.equals(paramString, "collection_videoplay")) || (TextUtils.equals(paramString, "feeds_fullscreen"));
  }
  
  private static String e()
  {
    int[] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      String str = WeishiUtils.a(arrayOfInt[i]);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      i += 1;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils
 * JD-Core Version:    0.7.0.1
 */