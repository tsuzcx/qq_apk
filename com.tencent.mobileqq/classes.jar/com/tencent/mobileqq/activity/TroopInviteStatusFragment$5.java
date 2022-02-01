package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopInviteStatusFragment$5
  extends MessageObserver
{
  TroopInviteStatusFragment$5(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void onSendSystemMsgActionError(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopInviteStatusFragment", 2, "onSendSystemMsgActionError logStr:" + paramString);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      paramString = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719697);
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramString, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight()).show();
    }
  }
  
  public void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (!paramBoolean)
    {
      paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719023);
      if (TextUtils.isEmpty(paramString3)) {
        break label175;
      }
    }
    for (;;)
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, paramString3, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
      paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692699);
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, paramString1, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      this.a.c = -1;
      TroopInviteStatusFragment.a(this.a);
      this.a.jdField_b_of_type_Boolean = true;
      this.a.jdField_a_of_type_AndroidOsHandler.post(this.a.jdField_b_of_type_JavaLangRunnable);
      return;
      label175:
      paramString3 = paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.5
 * JD-Core Version:    0.7.0.1
 */