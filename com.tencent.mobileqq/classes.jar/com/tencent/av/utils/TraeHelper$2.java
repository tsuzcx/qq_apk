package com.tencent.av.utils;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.OnDismissListener;

class TraeHelper$2
  implements ActionSheet.OnDismissListener
{
  TraeHelper$2(TraeHelper paramTraeHelper) {}
  
  public void onDismiss()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Trae_DRP 0X8008D22 at: ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("TraeSessionHelper", 2, localStringBuilder.toString());
    }
    ReportController.b(null, "CliOper", "", "", "0X8008D22", "0X8008D22", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.2
 * JD-Core Version:    0.7.0.1
 */