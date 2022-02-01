package com.tencent.mobileqq.activity.home;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.common.AccountDPCHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.PatternLockUtils;
import mqq.app.AppRuntime;

class MainFragment$9
  implements View.OnClickListener
{
  MainFragment$9(MainFragment paramMainFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.flushLog();
    boolean bool = ((CheckBox)this.a.findViewById(2131430666)).isChecked();
    Object localObject = this.b;
    ((MainFragment)localObject).l = bool;
    SettingCloneUtil.writeValue(((MainFragment)localObject).C(), this.b.A.getCurrentAccountUin(), this.b.getString(2131915612), "qqsetting_receivemsg_whenexit_key", bool);
    AccountDPCHelper.b(this.b.C(), this.b.l);
    int i = this.b.c().getMessageFacade().w();
    int j = this.b.c().getCallFacade().b();
    localObject = this.b.C().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", i + j);
    ((SharedPreferences.Editor)localObject).commit();
    this.b.j();
    this.b.c().bReceiveMsgOnExit = this.b.l;
    MainFragment.b = true;
    if (QQPlayerService.b())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      this.b.C().sendBroadcast((Intent)localObject);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(this.b.C(), this.b.A.getCurrentAccountUin(), true);
    this.b.C().finish();
    ReportController.b(this.b.A, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "0", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.9
 * JD-Core Version:    0.7.0.1
 */