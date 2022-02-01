package com.tencent.mobileqq.activity;

import android.app.Dialog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.LoginAccountFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager.AccountInfo;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager.OnUinClickListener;
import java.util.Map;

class LoginPhoneNumActivity$5
  implements PhoneNumQuickLoginManager.OnUinClickListener
{
  LoginPhoneNumActivity$5(LoginPhoneNumActivity paramLoginPhoneNumActivity) {}
  
  public void a(Dialog paramDialog, Map<String, Object> paramMap, PhoneNumQuickLoginManager.AccountInfo paramAccountInfo)
  {
    paramDialog = (byte[])paramMap.get("login_tvl_value");
    paramMap = LoginAccountFragment.a(2, LoginPhoneNumActivity.access$200(this.a));
    LoginAccountFragment.a(this.a, HardCodeUtil.a(2131897200), HardCodeUtil.a(2131904283), paramAccountInfo, paramMap, paramDialog, 2020);
    ReportController.a(LoginPhoneNumActivity.access$300(this.a), "0X800B939");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity.5
 * JD-Core Version:    0.7.0.1
 */