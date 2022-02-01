package com.tencent.biz.pubaccount.readinjoy.viola.view;

import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ViolaBaseView$5
  implements Runnable
{
  ViolaBaseView$5(ViolaBaseView paramViolaBaseView, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e(ViolaBaseView.a(), 2, "ThreadManager 执行");
      }
      long l = System.currentTimeMillis();
      ViolaAccessHelper.a(this.a, ViolaBaseView.a(this.this$0), ViolaBaseView.a(this.this$0), new ViolaBaseView.5.1(this, l));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(ViolaBaseView.a(), 2, "SDKInitialize Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.5
 * JD-Core Version:    0.7.0.1
 */