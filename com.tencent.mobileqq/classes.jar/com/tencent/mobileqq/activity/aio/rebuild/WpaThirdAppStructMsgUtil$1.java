package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

final class WpaThirdAppStructMsgUtil$1
  implements DialogInterface.OnClickListener
{
  WpaThirdAppStructMsgUtil$1(AbsShareMsg paramAbsShareMsg, BaseActivity paramBaseActivity, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8004B55", "0X8004B55", 0, 0, "", "", "", "");
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if (!(paramDialogInterface instanceof SplashActivity))
      {
        paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
        paramDialogInterface.putExtra("tab_index", FrameControllerUtil.a);
        paramDialogInterface.addFlags(67108864);
        paramDialogInterface.addFlags(268435456);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
        return;
      }
      paramDialogInterface.getChatFragment().a().A();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "qbShowWpaResultDialog back");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("appid");
      if (paramDialogInterface != null)
      {
        BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        ForwardSdkShareOption.a(localBaseActivity, true, localBaseActivity.getIntent().getStringExtra("callback_type"), Long.parseLong(paramDialogInterface));
      }
    }
    Util.a(this.jdField_a_of_type_AndroidContentContext, 0, "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8004B56", "0X8004B56", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.WpaThirdAppStructMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */