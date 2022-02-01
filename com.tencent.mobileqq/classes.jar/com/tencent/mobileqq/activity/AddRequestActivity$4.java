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
    if (paramInt == 0) {
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity;
        NewReportPlugin.a(paramView, paramView.a, null, this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app.getCurrentAccountUin(), 20010, null);
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, 2131694424, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.getTitleBarHeight());
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.4
 * JD-Core Version:    0.7.0.1
 */