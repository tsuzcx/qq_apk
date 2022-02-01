package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.PatternLockUtils;

class AccountManageActivity$36
  implements View.OnClickListener
{
  AccountManageActivity$36(AccountManageActivity paramAccountManageActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.flushLog();
    boolean bool = ((CheckBox)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131364710)).isChecked();
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c = bool;
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getString(2131718470), "qqsetting_receivemsg_whenexit_key", bool);
    SyncService.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.getMessageFacade().b();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.getCallFacade().a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", i + j);
    ((SharedPreferences.Editor)localObject).commit();
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.i();
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.bReceiveMsgOnExit = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.c;
    com.tencent.mobileqq.activity.home.MainFragment.b = true;
    if (QQPlayerService.a())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity().sendBroadcast((Intent)localObject);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.getCurrentAccountUin(), true);
    localObject = new Intent("QQ_ACTION_MENU_QUIT");
    ((Intent)localObject).setClass(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.getActivity(), SplashActivity.class);
    ((Intent)localObject).addFlags(67108864);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.startActivity((Intent)localObject);
      label275:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app, "CliOper", "", "", "0X800932A", "0X800932A", 0, 0, "0", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label275;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.36
 * JD-Core Version:    0.7.0.1
 */