package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.qphone.base.util.QLog;

public class ReadInJoyAdLog
{
  public static void a(String paramString1, String paramString2)
  {
    if (a()) {
      QLog.d(paramString1, b(), paramString2);
    }
  }
  
  private static boolean a()
  {
    return QLog.isColorLevel();
  }
  
  private static int b()
  {
    return 2;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a()) {
      QLog.e(paramString1, b(), paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog
 * JD-Core Version:    0.7.0.1
 */