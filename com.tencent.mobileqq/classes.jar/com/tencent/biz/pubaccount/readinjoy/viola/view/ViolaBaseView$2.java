package com.tencent.biz.pubaccount.readinjoy.viola.view;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import tbz;
import tjg;

public class ViolaBaseView$2
  implements Runnable
{
  ViolaBaseView$2(ViolaBaseView paramViolaBaseView, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e(ViolaBaseView.a(), 2, "ThreadManager 执行");
      }
      long l = System.currentTimeMillis();
      tbz.a(this.a, ViolaBaseView.a(this.this$0), ViolaBaseView.a(this.this$0), new tjg(this, l));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(ViolaBaseView.a(), 2, "SDKInitialize Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.2
 * JD-Core Version:    0.7.0.1
 */