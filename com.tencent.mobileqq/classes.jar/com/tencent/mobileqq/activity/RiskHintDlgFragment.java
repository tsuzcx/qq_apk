package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.security.ModifyPwdTopBarHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webprocess.PreloadService;
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
  String jdField_a_of_type_JavaLangString;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new RiskHintDlgFragment.8(this);
  DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private boolean jdField_a_of_type_Boolean = true;
  String b;
  String c;
  private String d;
  private String e;
  
  private void a(int paramInt, TextView... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      TextView localTextView = paramVarArgs[i];
      if (localTextView != null) {
        localTextView.setTextColor(paramInt);
      }
      i += 1;
    }
  }
  
  private void a(QQCustomDialog paramQQCustomDialog)
  {
    if (paramQQCustomDialog == null)
    {
      QLog.e("RiskHintDlgFragment", 1, "setDialogTextColor: dialog == null");
      return;
    }
    TextView localTextView1 = paramQQCustomDialog.getTitleTextView();
    TextView localTextView2 = paramQQCustomDialog.getMessageTextView();
    TextView localTextView3 = paramQQCustomDialog.getBtnLeft();
    TextView localTextView4 = paramQQCustomDialog.getBtnight();
    TextView localTextView5 = (TextView)paramQQCustomDialog.findViewById(2131365786);
    if ("1103".equals(ThemeUtil.getCurrentThemeId())) {}
    for (paramQQCustomDialog = "#FFFFFF";; paramQQCustomDialog = "#000000") {
      try
      {
        int i = Color.parseColor(paramQQCustomDialog);
        a(i, new TextView[] { localTextView1, localTextView2, localTextView3, localTextView4, localTextView5 });
        return;
      }
      catch (Exception paramQQCustomDialog)
      {
        QLog.e("RiskHintDlgFragment", 1, "setDialogTextColor: parseColor error", paramQQCustomDialog);
      }
    }
  }
  
  private void a(QQCustomDialog paramQQCustomDialog, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQCustomDialog == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.d("RiskHintDlgFragment", 1, "setDialogMessageLinkStyle: not need to set");
      return;
    }
    QLog.d("RiskHintDlgFragment", 1, "setDialogMessageLinkStyle: need to set");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(new SpannableString(paramString1));
    paramString1 = new SpannableString(paramString2);
    paramString1.setSpan(new RiskHintDlgFragment.RiskLinkClickableSpan(paramString3, paramQQCustomDialog, new WeakReference(getActivity())), 0, paramString2.length(), 33);
    localSpannableStringBuilder.append(paramString1);
    paramQQCustomDialog.setMessageWithoutAutoLink(localSpannableStringBuilder);
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
    int i = EquipmentLockImpl.a().a(getActivity().app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RiskHintDlgFragment", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
    }
    str = SharedPreUtils.j(getActivity(), getActivity().app.getCurrentAccountUin());
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
  
  void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ModifyPwdTopBarHelper.a().a(getActivity().app.getCurrentAccountUin());
    }
    if ("1".equals(paramString)) {
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        if (NetworkUtil.d(getActivity())) {
          break label162;
        }
        QQToast.a(getActivity(), getString(2131692257), 0).b(getActivity().getTitleBarHeight());
      }
    }
    label162:
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
        ReportController.b(getActivity().app, "dc00898", "", "", "0X800AAA5", "0X800AAA5", 0, 0, "", "", "", "");
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
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString))
      {
        if (paramString.contains("1109907872")) {
          ReportController.b(getActivity().app, "dc00898", "", "", "0X800AAA4", "0X800AAA4", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getActivity(), paramString, 4010, null);
          return;
          if (paramString.contains("1108149324")) {
            ReportController.b(getActivity().app, "dc00898", "", "", "0X800B258", "0X800B258", 0, 0, "", "", "", "");
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
      ReportController.b(getActivity().app, "dc00898", "", "", "0X800AAA6", "0X800AAA6", 0, 0, "", "", "", "");
    } while (getActivity() == null);
    getActivity().finish();
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      paramString1 = DialogUtil.a(getActivity(), 0, paramString1, paramString2, paramString3, paramString4, new RiskHintDlgFragment.1(this), new RiskHintDlgFragment.2(this));
      paramString1.setOnDismissListener(new RiskHintDlgFragment.3(this));
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
      paramString1 = DialogUtil.a(getActivity(), 0, paramString1, paramString2, paramString3, paramString4, paramString5, new RiskHintDlgFragment.4(this), new RiskHintDlgFragment.5(this), new RiskHintDlgFragment.6(this));
      paramString1.setOnDismissListener(new RiskHintDlgFragment.7(this));
      a(paramString1);
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
      PreloadService.b(2);
      ModifyPwdTopBarHelper.a().a(getActivity().app.getCurrentAccountUin(), System.currentTimeMillis());
      ReportController.b(getActivity().app, "dc00898", "", "", "0X800AAA3", "0X800AAA3", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskHintDlgFragment
 * JD-Core Version:    0.7.0.1
 */