package com.tencent.biz.qqcircle.viewmodels;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import vqu;
import vud;
import vue;

public class QCircleMessageNoticeViewModel$1
  implements Runnable
{
  public QCircleMessageNoticeViewModel$1(vud paramvud, Context paramContext) {}
  
  public void run()
  {
    vqu localvqu = (vqu)BaseApplicationImpl.getApplication().getRuntime().getManager(376);
    try
    {
      localvqu.a("circle_entrance", new vue(this), false);
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