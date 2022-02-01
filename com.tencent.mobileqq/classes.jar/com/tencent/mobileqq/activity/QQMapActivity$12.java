package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQMapActivity$12
  implements View.OnClickListener
{
  QQMapActivity$12(QQMapActivity paramQQMapActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.k) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.12
 * JD-Core Version:    0.7.0.1
 */