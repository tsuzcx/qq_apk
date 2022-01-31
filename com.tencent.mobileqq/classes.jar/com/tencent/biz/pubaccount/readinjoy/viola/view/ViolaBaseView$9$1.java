package com.tencent.biz.pubaccount.readinjoy.viola.view;

import azvy;
import com.tencent.qphone.base.util.QLog;
import rnj;
import rnk;

public class ViolaBaseView$9$1
  implements Runnable
{
  public ViolaBaseView$9$1(rnj paramrnj) {}
  
  public void run()
  {
    try
    {
      ViolaBaseView.a(this.a.a, new rnk(this));
      azvy.a().a(ViolaBaseView.a(this.a.a));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(ViolaBaseView.a(), 2, "pageOpenSuccess Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.9.1
 * JD-Core Version:    0.7.0.1
 */