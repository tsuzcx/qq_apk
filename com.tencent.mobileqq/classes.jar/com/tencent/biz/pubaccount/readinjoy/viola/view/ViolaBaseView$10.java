package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bfqd;
import com.tencent.qphone.base.util.QLog;
import tol;

public class ViolaBaseView$10
  implements Runnable
{
  ViolaBaseView$10(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    try
    {
      ViolaBaseView.a(this.this$0, new tol(this));
      bfqd.a().a(ViolaBaseView.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(ViolaBaseView.a(), 2, "pageOpenSuccess Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10
 * JD-Core Version:    0.7.0.1
 */