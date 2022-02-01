package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.LoginForbiddenDialogReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;

class SubLoginActivity$9
  extends SubAccountObserver
{
  SubLoginActivity$9(SubLoginActivity paramSubLoginActivity) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SubLoginActivity.onGetKeyBack() start. subUin=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" key=");
      if (paramString3 == null) {
        paramString1 = null;
      } else {
        paramString1 = "no null.";
      }
      localStringBuilder.append(paramString1);
      QLog.d("Q.subaccount.SubLoginActivity", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString3))
    {
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBGeykey", false, 0L, 0L, paramString1, "");
      this.a.hideJuhua();
      paramString1 = this.a;
      paramString1.showQQToast(paramString1.getString(2131719345));
      this.a.runOnUiThread(new SubLoginActivity.9.4(this));
      return;
    }
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12006");
    paramString1.put("fail_step", "getKeyNotEmpty");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBGeykey", true, 0L, 0L, paramString1, "");
    if (!SubLoginActivity.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount onGetKeyBack not need bind");
      }
      this.a.hideJuhua();
      paramString1 = (ISubAccountService)this.a.app.getRuntimeService(ISubAccountService.class, "");
      if (paramString1 != null) {
        paramString1.updateA2(paramString2, paramString3, true);
      }
      SubAccountControllUtil.a(this.a.app, (byte)1, paramString2);
      SubAccountControllUtil.a(this.a.app, paramString2, 7);
      SubAccountAssistantForward.b(this.a.app);
      SubAccountAssistantForward.a(this.a.app);
      this.a.setTitle("");
      SubAccountAssistantForward.a(this.a.app, this.a, paramString2);
      this.a.finish();
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccount", 2, "subaccount onGetKeyBack goto bind");
      }
      paramString1 = (ISubAccountProtocService)this.a.app.getRuntimeService(ISubAccountProtocService.class, "");
      if (paramString1 != null) {
        paramString1.bindAccount(paramString2, paramString3, this.a.fromWhere);
      }
      this.a.a = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onGetKeyBack: sucess .........");
    }
  }
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("Q.subaccount.SubLoginActivity", 2, "onLoginFailed: error, data == null");
      return;
    }
    int i = paramBundle.getInt("ret");
    String str = paramBundle.getString("error");
    LoginForbiddenDialogReporter.a(this.a.getAppRuntime(), SubLoginActivity.a(this.a).getText().toString(), 2, String.valueOf(i), i, str);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onLoginFailed: subLogin ...onLoginTimeout  subuin =  uin .. .errorMsg = ");
      paramString1.append(str);
      QLog.d("Q.subaccount.SubLoginActivity", 2, paramString1.toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", "12002");
    ((HashMap)localObject).put("fail_step", "loginFail");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subLogin:");
    if (str == null) {
      paramString1 = "";
    } else {
      paramString1 = str;
    }
    localStringBuilder.append(paramString1);
    ((HashMap)localObject).put("fail_location", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, (HashMap)localObject, "");
    if (!this.a.getActivity().isFinishing()) {
      try
      {
        this.a.hideJuhua();
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    this.a.runOnUiThread(new SubLoginActivity.9.2(this));
    if (TextUtils.isEmpty(str))
    {
      paramString1 = this.a;
      paramString1.showQQToast(paramString1.getString(2131694422));
      return;
    }
    if (i == 40)
    {
      localObject = paramBundle.getByteArray("tlverror");
      paramString2 = paramBundle.getString("title");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.getResources().getString(2131719311);
      }
      paramString2 = this.a;
      if (LoginFailedHelper.a(paramString2, SubLoginActivity.a(paramString2).getText().toString(), this.a.app, (byte[])localObject, null)) {
        return;
      }
      paramString2 = new Intent();
      paramString2.putExtra("type", 8);
      paramString2.putExtra("msg", str);
      paramString2.putExtra("loginalias", paramString3);
      paramString2.putExtra("loginret", i);
      paramString2.putExtra("errorUrl", paramBundle.getString("errorUrl"));
      paramString2.putExtra("expiredSig", paramBundle.getByteArray("lhsig"));
      paramString2.putExtra("keyFromBindAccount", true);
      paramString2.putExtra("tlverror", (byte[])localObject);
      paramString2.putExtra("title", paramString1);
      paramString2.putExtra("errortitle", paramString1);
      if (LoginFailedHelper.a((byte[])localObject) == 1)
      {
        paramString2.putExtra("uin", SubLoginActivity.a(this.a).getText().toString());
        paramString2.putExtra("passwd", SubLoginActivity.a(this.a).getText().toString());
        paramString2.putExtra("is_from_login", false);
        paramString2.putExtra("keyTipsScenesId", 1);
      }
      RouteUtils.a(this.a, paramString2, "/base/notification");
      return;
    }
    if (i == 1)
    {
      SubLoginActivity.a(this.a).a(this.a.app, this.a, paramString2, 3, str, new SubLoginActivity.9.3(this));
      return;
    }
    paramString1 = this.a;
    paramString1.showQQCustomDialogOneBtn(paramString1.getResources().getString(2131718407), str, null);
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginSuccess: start");
    }
    LoginForbiddenDialogReporter.a(this.a.getAppRuntime(), SubLoginActivity.a(this.a).getText().toString(), 2);
    if (this.a.app == null) {
      return;
    }
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12001");
    paramString1.put("fail_step", "loginsucc");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", true, 0L, 0L, paramString1, "");
    paramString1 = this.a;
    paramString1.a(paramString1.app.getApplication().getApplicationContext(), paramString2, true);
    this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), paramString2, null);
    ThreadManager.post(new SubLoginActivity.9.1(this, paramString2), 8, null, true);
  }
  
  protected void onLoginTimeout(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginTimeout:  subuin =  uin");
    }
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12004");
    paramString1.put("fail_step", "loginTimeout");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (!this.a.getActivity().isFinishing()) {
      try
      {
        this.a.hideJuhua();
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    paramString1 = this.a;
    paramString1.showQQToast(paramString1.getString(2131694422));
  }
  
  protected void onUserCancel(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12003");
    paramString1.put("fail_step", "onUserCancel");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onUserCancel: start");
    }
    if (!this.a.getActivity().isFinishing()) {
      try
      {
        this.a.hideJuhua();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.9
 * JD-Core Version:    0.7.0.1
 */