package com.tencent.biz.common.util;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommUtils
{
  private static final String a = "com.tencent.biz.common.util.CommUtils";
  
  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      paramString = new BufferedReader(new InputStreamReader(((HttpURLConnection)new URL(paramString).openConnection()).getInputStream()));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuffer.append(str);
      }
    }
    catch (Exception paramString)
    {
      label58:
      break label58;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "http error");
    }
    return localStringBuffer.toString();
  }
  
  public static void a(String paramString, CommUtils.IHttpGetString paramIHttpGetString)
  {
    new CommUtils.1(paramIHttpGetString, paramString).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.CommUtils
 * JD-Core Version:    0.7.0.1
 */