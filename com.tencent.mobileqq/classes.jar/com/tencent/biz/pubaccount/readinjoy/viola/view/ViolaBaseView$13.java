package com.tencent.biz.pubaccount.readinjoy.viola.view;

import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.qphone.base.util.QLog;

class ViolaBaseView$13
  implements Runnable
{
  ViolaBaseView$13(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    try
    {
      ViolaBaseView.a(this.this$0, new ViolaBaseView.13.1(this));
      FPSCalculator.a().a(ViolaBaseView.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(ViolaBaseView.a(), 2, "pageOpenSuccess Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.13
 * JD-Core Version:    0.7.0.1
 */