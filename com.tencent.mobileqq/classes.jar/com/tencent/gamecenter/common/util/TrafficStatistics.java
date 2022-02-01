package com.tencent.gamecenter.common.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class TrafficStatistics
{
  private static AppInterface a = null;
  
  private static void a(String paramString, long paramLong)
  {
    String[] arrayOfString;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIGameCenterDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      a(paramString, arrayOfString, paramLong);
      return;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGGameCenterDownloadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
  
  public static void a(String paramString, long paramLong, short paramShort)
  {
    if (paramShort == 0) {
      a(paramString, paramLong);
    }
    while (paramShort != 1) {
      return;
    }
    b(paramString, paramLong);
  }
  
  private static void a(String paramString, String[] paramArrayOfString, long paramLong) {}
  
  private static void b(String paramString, long paramLong)
  {
    String[] arrayOfString;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIGameCenterUploadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      a(paramString, arrayOfString, paramLong);
      return;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGGameCenterUploadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.TrafficStatistics
 * JD-Core Version:    0.7.0.1
 */