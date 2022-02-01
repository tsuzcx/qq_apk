package com.tencent.gamecenter.common.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class TrafficStatistics
{
  private static AppInterface a;
  
  private static void a(String paramString, long paramLong)
  {
    String[] arrayOfString;
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIGameCenterDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    else
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGGameCenterDownloadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
    a(paramString, arrayOfString, paramLong);
  }
  
  public static void a(String paramString, long paramLong, short paramShort)
  {
    if (paramShort == 0)
    {
      a(paramString, paramLong);
      return;
    }
    if (paramShort == 1) {
      b(paramString, paramLong);
    }
  }
  
  private static void a(String paramString, String[] paramArrayOfString, long paramLong) {}
  
  private static void b(String paramString, long paramLong)
  {
    String[] arrayOfString;
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIGameCenterUploadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    else
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGGameCenterUploadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
    a(paramString, arrayOfString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.TrafficStatistics
 * JD-Core Version:    0.7.0.1
 */