package com.tencent.gdtad.jsbridge;

import com.tencent.qphone.base.util.QLog;

public class GdtMvWebJsCallHandler
  implements GdtJsCallHandler
{
  private static GdtMvWebJsCallHandler.Action a;
  
  public static void a(GdtMvWebJsCallHandler.Action paramAction)
  {
    a = paramAction;
  }
  
  public static void c()
  {
    a = null;
  }
  
  protected String a(String paramString)
  {
    if (a == null)
    {
      QLog.i("WebGdtMvWebJsCallHandler", 1, "onGetAdInfo mAction == null");
      return "";
    }
    return a.a(paramString);
  }
  
  protected void a()
  {
    if (a == null)
    {
      QLog.i("WebGdtMvWebJsCallHandler", 1, "onVideoClose mAction == null");
      return;
    }
    a.a();
  }
  
  protected void a(String paramString)
  {
    if (a == null)
    {
      QLog.i("WebGdtMvWebJsCallHandler", 1, "onReportAntiSpam mAction == null");
      return;
    }
    a.a(paramString);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (a == null)
    {
      QLog.i("WebGdtMvWebJsCallHandler", 1, "onHandleRewardVideoClick mAction == null");
      return;
    }
    a.a(paramString, paramBoolean);
  }
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    return true;
  }
  
  protected void b()
  {
    if (a == null)
    {
      QLog.i("WebGdtMvWebJsCallHandler", 1, "onVideoMute mAction == null");
      return;
    }
    a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtMvWebJsCallHandler
 * JD-Core Version:    0.7.0.1
 */