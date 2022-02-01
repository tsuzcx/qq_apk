package com.tencent.mobileqq.Doraemon.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SdkAuthDialog$2
  implements View.OnClickListener
{
  SdkAuthDialog$2(SdkAuthDialog paramSdkAuthDialog, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener == null)
    {
      QLog.e("SdkAuthDialog", 1, "negativeListener is null");
    }
    else
    {
      localOnClickListener.onClick(paramView);
      ReportController.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "2", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog.2
 * JD-Core Version:    0.7.0.1
 */