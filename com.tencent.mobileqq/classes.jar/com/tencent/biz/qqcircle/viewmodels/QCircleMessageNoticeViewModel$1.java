package com.tencent.biz.qqcircle.viewmodels;

import axlx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import ubo;
import ubp;

public class QCircleMessageNoticeViewModel$1
  implements Runnable
{
  public QCircleMessageNoticeViewModel$1(ubo paramubo) {}
  
  public void run()
  {
    axlx localaxlx = (axlx)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    try
    {
      localaxlx.a(new ubp(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleMessageNoticeViewModel", 1, "updateQQCircleRedFlag  updateRedDot" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1
 * JD-Core Version:    0.7.0.1
 */