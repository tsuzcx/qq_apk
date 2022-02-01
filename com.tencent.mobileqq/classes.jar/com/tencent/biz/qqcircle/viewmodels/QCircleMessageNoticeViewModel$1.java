package com.tencent.biz.qqcircle.viewmodels;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import vtf;
import vxc;
import vxd;

public class QCircleMessageNoticeViewModel$1
  implements Runnable
{
  public QCircleMessageNoticeViewModel$1(vxc paramvxc, Context paramContext) {}
  
  public void run()
  {
    vtf localvtf = (vtf)BaseApplicationImpl.getApplication().getRuntime().getManager(376);
    try
    {
      localvtf.a("circle_entrance", new vxd(this), false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleMessageNoticeViewModel", 1, "updateQQCircleRedFlag  updateRedDot" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1
 * JD-Core Version:    0.7.0.1
 */