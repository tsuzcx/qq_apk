package com.tencent.mobileqq.Doraemon.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SdkAuthDialog$1
  implements View.OnClickListener
{
  SdkAuthDialog$1(SdkAuthDialog paramSdkAuthDialog, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(SdkAuthDialog.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog)))
    {
      QQToast.a(SdkAuthDialog.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog), SdkAuthDialog.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonUiSdkAuthDialog).getString(2131694422), 0).a();
    }
    else
    {
      View.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      if (localOnClickListener == null)
      {
        QLog.e("SdkAuthDialog", 1, "positiveListener is null");
      }
      else
      {
        localOnClickListener.onClick(paramView);
        ReportController.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "0", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog.1
 * JD-Core Version:    0.7.0.1
 */