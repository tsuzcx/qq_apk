package com.tencent.biz.pubaccount.readinjoy;

import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KandianUGStatisticUtils
{
  private static ExecutorService a;
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramString1.contains("?")) {
      return paramString1 + "&acttype=" + paramString3 + "&itemid=" + paramString2;
    }
    return paramString1 + "?acttype=" + paramString3 + "&itemid=" + paramString2;
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (a == null) {
      a = Executors.newFixedThreadPool(1);
    }
    a.execute(new KandianUGStatisticUtils.1(paramString));
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramString1.contains("?")) {
      return paramString1 + "&acttype=" + paramString2 + "&subpos=" + paramString3;
    }
    return paramString1 + "?acttype=" + paramString2 + "&subpos=" + paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KandianUGStatisticUtils
 * JD-Core Version:    0.7.0.1
 */