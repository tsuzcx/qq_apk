package com.tencent.mobileqq.activity;

import abzm;
import abzn;
import abzo;
import abzp;
import abzq;
import abzr;
import abzs;
import abzt;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import aoes;
import axqy;
import bbdj;
import bbfj;
import bbgu;
import bcas;
import bcql;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class RiskHintDlgFragment
  extends PublicBaseFragment
{
  public String a;
  WtloginObserver a;
  public DevlockInfo a;
  public String b;
  public String c;
  
  public RiskHintDlgFragment()
  {
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
    this.jdField_a_of_type_MqqObserverWtloginObserver = new abzt(this);
  }
  
  void a()
  {
    String str = getActivity().app.getCurrentAccountUin();
    int i = aoes.a().a(getActivity().app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RiskHintDlgFragment", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
    }
  }
  
  public void a(String paramString)
  {
    if ("1".equals(paramString)) {
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        if (bbfj.d(getActivity())) {
          break label126;
        }
        bcql.a(getActivity(), getString(2131692321), 0).b(getActivity().getTitleBarHeight());
      }
    }
    label126:
    do
    {
      return;
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
      {
        paramString = new Intent(getActivity(), AuthDevActivity.class);
        paramString.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramString.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        paramString.putExtra("auth_dev_open", true);
        paramString.putExtra("from_risk_hint", true);
        startActivity(paramString);
      }
      for (;;)
      {
        axqy.b(getActivity().app, "dc00898", "", "", "0X800AAA5", "0X800AAA5", 0, 0, "", "", "", "");
        a();
        if (getActivity() == null) {
          break;
        }
        getActivity().finish();
        return;
        if (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
        {
          paramString = new Intent(getActivity(), AuthDevOpenUgActivity.class);
          paramString.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          paramString.putExtra("from_risk_hint", true);
          startActivity(paramString);
        }
        else if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
        {
          paramString = new Intent(getActivity(), AuthDevOpenUgActivity.class);
          paramString.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          paramString.putExtra("from_risk_hint", true);
          startActivity(paramString);
        }
        else if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1)
        {
          paramString = new Intent(getActivity(), AuthDevActivity.class);
          paramString.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramString.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          paramString.putExtra("auth_dev_open", false);
          paramString.putExtra("from_risk_hint", true);
          startActivity(paramString);
        }
      }
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http")) || (paramString.startsWith("https"))))
      {
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("from_risk_hint", true);
        getActivity().startActivity(localIntent);
        axqy.b(getActivity().app, "dc00898", "", "", "0X800AAA4", "0X800AAA4", 0, 0, "", "", "", "");
        return;
      }
      axqy.b(getActivity().app, "dc00898", "", "", "0X800AAA6", "0X800AAA6", 0, 0, "", "", "", "");
    } while (getActivity() == null);
    getActivity().finish();
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      paramString1 = bbdj.a(getActivity(), 0, paramString1, paramString2, paramString3, paramString4, new abzm(this), new abzn(this));
      paramString1.setOnDismissListener(new abzo(this));
      paramString1.show();
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("RiskHintDlgFragment", 1, paramString1, new Object[0]);
      getActivity().finish();
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = bbdj.a(getActivity(), 0, paramString1, paramString2, paramString3, paramString4, paramString5, new abzp(this), new abzq(this), new abzr(this));
      paramString1.setOnDismissListener(new abzs(this));
      paramString1.show();
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("RiskHintDlgFragment", 1, paramString1, new Object[0]);
      getActivity().finish();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    long l = localBundle.getLong("BusiType", 0L);
    String str1 = localBundle.getString("Title", "风险提示");
    String str2 = localBundle.getString("Message", "该帐号被安全扫描检测到存在密码外泄风险，为保障你的帐号财产与隐私安全，请尽快修改密码，并建议在\"设置\"-\"帐号安全\"-\"登录保护\"开启登录保护。");
    String str3 = localBundle.getString("btnText1", "");
    String str4 = localBundle.getString("btnText2", "");
    String str5 = localBundle.getString("btnText3", "");
    this.jdField_a_of_type_JavaLangString = localBundle.getString("btnAction1", "");
    this.b = localBundle.getString("btnAction2", "");
    this.c = localBundle.getString("btnAction3", "");
    if (l == 1062L) {
      a(str1, str2, str3, str4);
    }
    for (;;)
    {
      a();
      bcas.b(2);
      axqy.b(getActivity().app, "dc00898", "", "", "0X800AAA3", "0X800AAA3", 0, 0, "", "", "", "");
      return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      if (l == 1063L)
      {
        a(str1, str2, str3, str4, str5);
      }
      else
      {
        QLog.e("RiskHintDlgFragment", 1, new Object[] { "error templateId:", Long.valueOf(l) });
        if (getActivity() != null) {
          getActivity().finish();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskHintDlgFragment
 * JD-Core Version:    0.7.0.1
 */