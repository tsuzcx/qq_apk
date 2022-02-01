package com.tencent.biz.qqcircle.proxy.delegate;

import com.tencent.mobileqq.auto.engine.lib.IToastDelegate;
import com.tencent.qphone.base.util.QLog;

final class QCircleToast$1
  implements Runnable
{
  QCircleToast$1(int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    IToastDelegate localIToastDelegate = QCircleToast.a(QCircleToast.a());
    if (localIToastDelegate != null)
    {
      localIToastDelegate.makeTextAndShow(this.a, this.b, this.c);
      return;
    }
    QLog.e("QCircleToast", 1, "makeTextAndShow() get delegate is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.proxy.delegate.QCircleToast.1
 * JD-Core Version:    0.7.0.1
 */