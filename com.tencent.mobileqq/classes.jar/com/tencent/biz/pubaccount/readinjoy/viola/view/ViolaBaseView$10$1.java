package com.tencent.biz.pubaccount.readinjoy.viola.view;

import baxc;
import com.tencent.qphone.base.util.QLog;
import rzr;
import rzs;

public class ViolaBaseView$10$1
  implements Runnable
{
  public ViolaBaseView$10$1(rzr paramrzr) {}
  
  public void run()
  {
    try
    {
      ViolaBaseView.a(this.a.a, new rzs(this));
      baxc.a().a(ViolaBaseView.a(this.a.a));
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10.1
 * JD-Core Version:    0.7.0.1
 */