package com.tencent.biz.qqcircle.proxy.delegate;

import android.app.Application;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.auto.engine.lib.IToastDelegate;
import com.tencent.qcircle.application.QCircleApplication;

public class QCircleToast
{
  public static int a = -1;
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  private static volatile QCircleToast f;
  private IToastDelegate e;
  
  public static void a(int paramInt1, int paramInt2)
  {
    String str = QCircleApplication.APP.getResources().getString(paramInt1);
    a(b, str, paramInt2);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, QCircleApplication.APP.getResources().getString(paramInt2), paramInt3);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    RFThreadManager.getUIHandler().post(new QCircleToast.1(paramInt1, paramString, paramInt2));
  }
  
  public static void a(IToastDelegate paramIToastDelegate)
  {
    b().b(paramIToastDelegate);
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(b, paramString, paramInt);
  }
  
  private static QCircleToast b()
  {
    try
    {
      if (f == null) {
        try
        {
          if (f == null) {
            f = new QCircleToast();
          }
        }
        finally {}
      }
      QCircleToast localQCircleToast = f;
      return localQCircleToast;
    }
    finally {}
  }
  
  private void b(IToastDelegate paramIToastDelegate)
  {
    if (paramIToastDelegate != null)
    {
      this.e = paramIToastDelegate;
      a = paramIToastDelegate.getIconTypeNone();
      b = paramIToastDelegate.getIconTypeDefault();
      c = paramIToastDelegate.getIconTypeError();
      d = paramIToastDelegate.getIconTypeSuccess();
      return;
    }
    Log.d("QCircleToast", "setDelegate input delegate is null!");
  }
  
  private IToastDelegate c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.proxy.delegate.QCircleToast
 * JD-Core Version:    0.7.0.1
 */