package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class AuthDevActivity$2
  implements CompoundButton.OnCheckedChangeListener
{
  AuthDevActivity$2(AuthDevActivity paramAuthDevActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    boolean bool;
    if (paramCompoundButton == AuthDevActivity.access$000(this.a).a())
    {
      AuthDevActivity.access$000(this.a).setOnCheckedChangeListener(null);
      localObject = AuthDevActivity.access$000(this.a);
      if (AuthDevActivity.access$000(this.a).a())
      {
        bool = false;
        ((FormSwitchItem)localObject).setChecked(bool);
        AuthDevActivity.access$000(this.a).setOnCheckedChangeListener(AuthDevActivity.access$100(this.a));
        if (NetworkUtil.d(this.a)) {
          break label127;
        }
        QQToast.a(this.a, this.a.getString(2131692257), 0).b(this.a.getTitleBarHeight());
      }
    }
    label127:
    do
    {
      do
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = true;
        break;
        localObject = (SecSvcHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      } while (localObject == null);
      if (!AuthDevActivity.access$000(this.a).a()) {}
      for (bool = true;; bool = false)
      {
        ((SecSvcHandler)localObject).a(bool);
        break;
      }
      if (paramCompoundButton == AuthDevActivity.access$200(this.a).a())
      {
        if (AuthDevActivity.access$200(this.a).a())
        {
          localObject = "0";
          ReportController.b(null, "dc00898", "", "", "0X800AC54", "0X800AC54", 0, 0, (String)localObject, "", "", "");
          AuthDevActivity.access$200(this.a).setOnCheckedChangeListener(null);
          localObject = AuthDevActivity.access$200(this.a);
          if (!AuthDevActivity.access$200(this.a).a()) {
            break label314;
          }
        }
        for (bool = false;; bool = true)
        {
          ((FormSwitchItem)localObject).setChecked(bool);
          AuthDevActivity.access$200(this.a).setOnCheckedChangeListener(AuthDevActivity.access$100(this.a));
          AuthDevActivity.access$300(this.a);
          break;
          localObject = "1";
          break label213;
        }
      }
    } while (paramCompoundButton != AuthDevActivity.access$400(this.a).a());
    label213:
    label351:
    int i;
    label314:
    if (AuthDevActivity.access$400(this.a).a())
    {
      localObject = "1";
      ReportController.b(null, "dc00898", "", "", "0X800AC53", "0X800AC53", 0, 0, (String)localObject, "", "", "");
      localObject = this.a.app;
      if (!paramBoolean) {
        break label485;
      }
      i = 1;
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "Setting_tab", "Mobile_pc_online", 0, i, "", "", "", "");
      if (!paramBoolean) {
        break label490;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A721", "0X800A721", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      label390:
      SettingCloneUtil.writeValue(this.a, this.a.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", paramBoolean);
      this.a.app.sendRegisterPush();
      break;
      localObject = "0";
      break label351;
      label485:
      i = 0;
      break label390;
      label490:
      ReportController.b(null, "dc00898", "", "", "0X800A722", "0X800A722", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.2
 * JD-Core Version:    0.7.0.1
 */