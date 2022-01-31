package com.tencent.mobileqq.activity.main;

import agci;
import aiak;
import alrv;
import android.content.res.Resources;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import aukx;
import azoa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class MainAssistObserver$2
  implements Runnable
{
  public MainAssistObserver$2(aiak paramaiak) {}
  
  public void run()
  {
    Object localObject = this.this$0.a;
    if (localObject != null) {}
    for (QQAppInterface localQQAppInterface = ((SplashActivity)localObject).app; (localObject == null) || (localQQAppInterface == null); localQQAppInterface = null) {
      return;
    }
    try
    {
      agci.a(localQQAppInterface);
      aukx.a().a(localQQAppInterface);
      localObject = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localObject = BaseApplicationImpl.sImageCache;
      float f = alrv.a().a;
      ((MQLruCache)localObject).setLargeSize((int)(j * i * 4 * f));
      localQQAppInterface.E();
      QQToast.a(true);
      QQAppInterface.a().a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MainAssistObserver", 4, "notifyWindowShowed e=" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.2
 * JD-Core Version:    0.7.0.1
 */