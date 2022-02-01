package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AddRequestActivity$4
  implements ActionSheet.OnButtonClickListener
{
  AddRequestActivity$4(AddRequestActivity paramAddRequestActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (NetworkUtil.d(BaseApplication.getContext())) {
        NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a, null, this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app.getCurrentAccountUin(), 20010, null);
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, 2131694459, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.4
 * JD-Core Version:    0.7.0.1
 */