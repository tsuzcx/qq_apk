package com.tencent.mobileqq.activity.specialcare;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

class SpecailCareListActivity$1
  extends Handler
{
  SpecailCareListActivity$1(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 2002: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramMessage, paramMessage.getTitleBarHeight());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131699313);
      if ((!this.a.isFinishing()) && (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
      break;
    case 2001: 
      this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      return;
    case 2000: 
      this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
      QQToast.a(BaseApplication.getContext(), 1, 2131694424, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.1
 * JD-Core Version:    0.7.0.1
 */