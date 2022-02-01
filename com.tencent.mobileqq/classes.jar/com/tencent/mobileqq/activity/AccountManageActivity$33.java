package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.common.AccountDPCHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.PatternLockUtils;

class AccountManageActivity$33
  implements View.OnClickListener
{
  AccountManageActivity$33(AccountManageActivity paramAccountManageActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.flushLog();
    boolean bool = ((CheckBox)this.a.findViewById(2131430666)).isChecked();
    Object localObject = this.b;
    ((AccountManageActivity)localObject).u = bool;
    SettingCloneUtil.writeValue(((AccountManageActivity)localObject).getActivity(), this.b.app.getCurrentAccountUin(), this.b.getString(2131915612), "qqsetting_receivemsg_whenexit_key", bool);
    AccountDPCHelper.b(this.b.getActivity(), this.b.u);
    int i = this.b.app.getMessageFacade().w();
    int j = this.b.app.getCallFacade().b();
    localObject = this.b.getActivity().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", i + j);
    ((SharedPreferences.Editor)localObject).commit();
    this.b.i();
    this.b.app.bReceiveMsgOnExit = this.b.u;
    com.tencent.mobileqq.activity.home.MainFragment.b = true;
    if (QQPlayerService.b())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      this.b.getActivity().sendBroadcast((Intent)localObject);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(this.b.getActivity(), this.b.app.getCurrentAccountUin(), true);
    localObject = new Intent("QQ_ACTION_MENU_QUIT");
    ((Intent)localObject).setClass(this.b.getActivity(), SplashActivity.class);
    ((Intent)localObject).addFlags(67108864);
    try
    {
      this.b.startActivity((Intent)localObject);
      label277:
      ReportController.b(this.b.app, "CliOper", "", "", "0X800932A", "0X800932A", 0, 0, "0", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label277;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.33
 * JD-Core Version:    0.7.0.1
 */