package com.tencent.biz.pubaccount.readinjoy.viola.view;

import bcwk;
import com.tencent.qphone.base.util.QLog;
import sqv;
import sqw;

public class ViolaBaseView$10$1
  implements Runnable
{
  public ViolaBaseView$10$1(sqv paramsqv) {}
  
  public void run()
  {
    try
    {
      ViolaBaseView.a(this.a.a, new sqw(this));
      bcwk.a().a(ViolaBaseView.a(this.a.a));
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10.1
 * JD-Core Version:    0.7.0.1
 */