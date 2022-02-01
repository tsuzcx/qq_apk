package com.tencent.mobileqq.activity;

import afkw;
import afkx;
import afky;
import afkz;
import afla;
import aflb;
import aflc;
import afld;
import afle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import asvf;
import bdll;
import bhlq;
import bhnv;
import bhpc;
import bhsi;
import bilz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONObject;

public class RiskHintDlgFragment
  extends PublicBaseFragment
{
  public String a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new afld(this);
  public DevlockInfo a;
  private boolean jdField_a_of_type_Boolean = true;
  public String b;
  public String c;
  private String d;
  private String e;
  
  public RiskHintDlgFragment()
  {
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  }
  
  private void a(bhpc parambhpc, String paramString1, String paramString2, String paramString3)
  {
    if ((parambhpc == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.d("RiskHintDlgFragment", 1, "setDialogMessageLinkStyle: not need to set");
      return;
    }
    QLog.d("RiskHintDlgFragment", 1, "setDialogMessageLinkStyle: need to set");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(new SpannableString(paramString1));
    paramString1 = new SpannableString(paramString2);
    paramString1.setSpan(new afle(paramString3, parambhpc, new WeakReference(getActivity())), 0, paramString2.length(), 33);
    localSpannableStringBuilder.append(paramString1);
    parambhpc.setMessageWithoutAutoLink(localSpannableStringBuilder);
  }
  
  private void b()
  {
    Intent localIntent = new Intent(getActivity(), AuthDevActivity.class);
    localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
    localIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
    localIntent.putExtra("auth_dev_open", false);
    localIntent.putExtra("from_risk_hint", true);
    localIntent.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
    localIntent.putExtra("auth_dev_gray_switch", this.jdField_a_of_type_Boolean);
    startActivityForResult(localIntent, 0);
  }
  
  void a()
  {
    String str = getActivity().app.getCurrentAccountUin();
    int i = asvf.a().a(getActivity().app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RiskHintDlgFragment", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
    }
    str = bhsi.j(getActivity(), getActivity().app.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      if (new JSONObject(str).optInt("securityType", 0) == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RiskHintDlgFragment", 1, new Object[] { "parse dev gray switch error : ", localException.getMessage() });
    }
  }
  
  public void a(String paramString)
  {
    if ("1".equals(paramString)) {
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        if (bhnv.d(getActivity())) {
          break label137;
        }
        QQToast.a(getActivity(), getString(2131691989), 0).b(getActivity().getTitleBarHeight());
      }
    }
    label137:
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
        paramString.putExtra("auth_dev_gray_switch", this.jdField_a_of_type_Boolean);
        startActivity(paramString);
      }
      for (;;)
      {
        bdll.b(getActivity().app, "dc00898", "", "", "0X800AAA5", "0X800AAA5", 0, 0, "", "", "", "");
        a();
        if (getActivity() == null) {
          break;
        }
        getActivity().finish();
        return;
        if (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
        {
          if (this.jdField_a_of_type_Boolean)
          {
            b();
            return;
          }
          paramString = new Intent(getActivity(), AuthDevOpenUgActivity.class);
          paramString.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          paramString.putExtra("from_risk_hint", true);
          startActivity(paramString);
        }
        else if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            b();
            return;
          }
          paramString = new Intent(getActivity(), AuthDevOpenUgActivity.class);
          paramString.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          paramString.putExtra("from_risk_hint", true);
          startActivity(paramString);
        }
        else if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1)
        {
          b();
        }
      }
      if (MiniAppLauncher.isMiniAppUrl(paramString))
      {
        if (paramString.contains("1109907872")) {
          bdll.b(getActivity().app, "dc00898", "", "", "0X800AAA4", "0X800AAA4", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          MiniAppLauncher.startMiniApp(getActivity(), paramString, 4010, null);
          return;
          if (paramString.contains("1108149324")) {
            bdll.b(getActivity().app, "dc00898", "", "", "0X800B258", "0X800B258", 0, 0, "", "", "", "");
          }
        }
      }
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http")) || (paramString.startsWith("https"))))
      {
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("from_risk_hint", true);
        getActivity().startActivity(localIntent);
        return;
      }
      bdll.b(getActivity().app, "dc00898", "", "", "0X800AAA6", "0X800AAA6", 0, 0, "", "", "", "");
    } while (getActivity() == null);
    getActivity().finish();
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      paramString1 = bhlq.a(getActivity(), 0, paramString1, paramString2, paramString3, paramString4, new afkw(this), new afkx(this));
      paramString1.setOnDismissListener(new afky(this));
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
      paramString1 = bhlq.a(getActivity(), 0, paramString1, paramString2, paramString3, paramString4, paramString5, new afkz(this), new afla(this), new aflb(this));
      paramString1.setOnDismissListener(new aflc(this));
      a(paramString1, paramString2, this.d, this.e);
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
    this.d = localBundle.getString("contentUrlText", "");
    this.e = localBundle.getString("contentUrlValue", "");
    if (l == 1062L) {
      a(str1, str2, str3, str4);
    }
    for (;;)
    {
      a();
      bilz.b(2);
      bdll.b(getActivity().app, "dc00898", "", "", "0X800AAA3", "0X800AAA3", 0, 0, "", "", "", "");
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if ((l == 1063L) || (l == 1123L) || (l == 1124L))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskHintDlgFragment
 * JD-Core Version:    0.7.0.1
 */