package com.tencent.biz.qqcircle.viewmodels;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.qphone.base.util.QLog;

class QCircleMessageNoticeViewModel$1
  implements Runnable
{
  QCircleMessageNoticeViewModel$1(QCircleMessageNoticeViewModel paramQCircleMessageNoticeViewModel, Context paramContext) {}
  
  public void run()
  {
    try
    {
      QCircleHostRedPointHelper.asyncGetNumRedPointInfoByAppid("circle_entrance", new QCircleMessageNoticeViewModel.1.1(this), false);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateQQCircleRedFlag  updateRedDot");
      localStringBuilder.append(localException.toString());
      QLog.e("QCircleMessageNoticeViewModel", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1
 * JD-Core Version:    0.7.0.1
 */