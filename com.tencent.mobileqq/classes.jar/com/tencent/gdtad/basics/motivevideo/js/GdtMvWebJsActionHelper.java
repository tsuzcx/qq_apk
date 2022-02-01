package com.tencent.gdtad.basics.motivevideo.js;

import com.tencent.qphone.base.util.QLog;

public class GdtMvWebJsActionHelper
{
  public static GdtMvWebJsAction a;
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(GdtMvWebJsAction paramGdtMvWebJsAction)
  {
    a = paramGdtMvWebJsAction;
  }
  
  public String a(String paramString)
  {
    GdtMvWebJsAction localGdtMvWebJsAction = a;
    if (localGdtMvWebJsAction == null)
    {
      QLog.i("GdtMvWebJsActionHelper", 1, "onGetAdInfo mAction == null");
      return "";
    }
    return localGdtMvWebJsAction.a(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    GdtMvWebJsAction localGdtMvWebJsAction = a;
    if (localGdtMvWebJsAction == null)
    {
      QLog.i("GdtMvWebJsActionHelper", 1, "onHandleRewardVideoClick mAction == null");
      return;
    }
    localGdtMvWebJsAction.a(paramString, paramBoolean);
  }
  
  public void b()
  {
    GdtMvWebJsAction localGdtMvWebJsAction = a;
    if (localGdtMvWebJsAction == null)
    {
      QLog.i("GdtMvWebJsActionHelper", 1, "onVideoClose mAction == null");
      return;
    }
    localGdtMvWebJsAction.a();
  }
  
  public void b(String paramString)
  {
    GdtMvWebJsAction localGdtMvWebJsAction = a;
    if (localGdtMvWebJsAction == null)
    {
      QLog.i("GdtMvWebJsActionHelper", 1, "onReportAntiSpam mAction == null");
      return;
    }
    localGdtMvWebJsAction.b(paramString);
  }
  
  public void c()
  {
    GdtMvWebJsAction localGdtMvWebJsAction = a;
    if (localGdtMvWebJsAction == null)
    {
      QLog.i("GdtMvWebJsActionHelper", 1, "onVideoMute mAction == null");
      return;
    }
    localGdtMvWebJsAction.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.js.GdtMvWebJsActionHelper
 * JD-Core Version:    0.7.0.1
 */