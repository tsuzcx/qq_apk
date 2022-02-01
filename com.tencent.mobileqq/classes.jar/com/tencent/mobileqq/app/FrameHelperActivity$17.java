package com.tencent.mobileqq.app;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FrameHelperActivity$17
  implements View.OnClickListener
{
  FrameHelperActivity$17(FrameHelperActivity paramFrameHelperActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if ((FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity) != null) && (FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).isShowing())) {
      FrameHelperActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).dismiss();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800433B", "0X800433B", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.17
 * JD-Core Version:    0.7.0.1
 */