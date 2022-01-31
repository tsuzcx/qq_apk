package com.tencent.biz.qqcircle.viewmodels;

import axho;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tzd;
import tze;

public class QCircleMessageNoticeViewModel$1
  implements Runnable
{
  public QCircleMessageNoticeViewModel$1(tzd paramtzd) {}
  
  public void run()
  {
    axho localaxho = (axho)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    try
    {
      localaxho.a(new tze(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(tzd.a(), 1, "updateQQCircleRedFlag  updateRedDot" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1
 * JD-Core Version:    0.7.0.1
 */