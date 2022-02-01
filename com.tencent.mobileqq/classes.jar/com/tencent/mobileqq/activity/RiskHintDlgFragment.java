package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONObject;

public class RiskHintDlgFragment
  extends QPublicBaseFragment
{
  String a;
  String b;
  String c;
  DevlockInfo d = null;
  WtloginObserver e = new RiskHintDlgFragment.8(this);
  private boolean f = true;
  private String g;
  private String h;
  
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
    TextView localTextView5 = (TextView)paramQQCustomDialog.findViewById(2131431854);
    if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
      paramQQCustomDialog = "#FFFFFF";
    } else {
      paramQQCustomDialog = "#000000";
    }
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
  
  private void a(QQCustomDialog paramQQCustomDialog, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQCustomDialog != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      QLog.d("RiskHintDlgFragment", 1, "setDialogMessageLinkStyle: need to set");
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(new SpannableString(paramString1));
      paramString1 = new SpannableString(paramString2);
      paramString1.setSpan(new RiskHintDlgFragment.RiskLinkClickableSpan(paramString3, paramQQCustomDialog, new WeakReference(getQBaseActivity())), 0, paramString2.length(), 33);
      localSpannableStringBuilder.append(paramString1);
      paramQQCustomDialog.setMessageWithoutAutoLink(localSpannableStringBuilder);
      return;
    }
    QLog.d("RiskHintDlgFragment", 1, "setDialogMessageLinkStyle: not need to set");
  }
  
  private void b()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("phone_num", this.d.Mobile);
    localIntent.putExtra("country_code", this.d.CountryCode);
    localIntent.putExtra("auth_dev_open", false);
    localIntent.putExtra("from_risk_hint", true);
    localIntent.putExtra("DevlockInfo", this.d);
    localIntent.putExtra("auth_dev_gray_switch", this.f);
    RouteUtils.a(getActivity(), localIntent, "/base/safe/authDevActivity", 0);
  }
  
  void a()
  {
    Object localObject = getQBaseActivity().getAppRuntime().getCurrentAccountUin();
    int i = ((ILoginApi)QRoute.api(ILoginApi.class)).getDevLockStatus(getQBaseActivity().getAppRuntime(), (String)localObject, this.e);
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startGetDevLockStatus CheckDevLockStatus failed. ret=");
        ((StringBuilder)localObject).append(i);
        QLog.d("RiskHintDlgFragment", 2, ((StringBuilder)localObject).toString());
      }
      this.d = null;
    }
    localObject = (String)BaseSharedPreUtil.a(getActivity(), getQBaseActivity().getAppRuntime().getCurrentAccountUin(), "device_manage_switch", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        if (new JSONObject((String)localObject).optInt("securityType", 0) != 0) {
          break label168;
        }
        bool = true;
        this.f = bool;
        return;
      }
      catch (Exception localException)
      {
        QLog.e("RiskHintDlgFragment", 1, new Object[] { "parse dev gray switch error : ", localException.getMessage() });
      }
      return;
      label168:
      boolean bool = false;
    }
  }
  
  void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).cancelVerifyRiskDialog(getQBaseActivity().getAppRuntime().getCurrentAccountUin());
    }
    if ("1".equals(paramString))
    {
      paramString = this.d;
      if (paramString == null)
      {
        if (!NetworkUtil.isNetSupport(getActivity())) {
          QQToast.makeText(getActivity(), getString(2131889169), 0).show(getQBaseActivity().getTitleBarHeight());
        }
      }
      else if (paramString.DevSetup == 1)
      {
        paramString = new Intent();
        paramString.putExtra("phone_num", this.d.Mobile);
        paramString.putExtra("country_code", this.d.CountryCode);
        paramString.putExtra("auth_dev_open", true);
        paramString.putExtra("from_risk_hint", true);
        paramString.putExtra("auth_dev_gray_switch", this.f);
        RouteUtils.a(getActivity(), paramString, "/base/safe/authDevActivity");
      }
      else if (TextUtils.isEmpty(this.d.Mobile))
      {
        if (this.f)
        {
          b();
          return;
        }
        paramString = new Intent();
        paramString.putExtra("DevlockInfo", this.d);
        paramString.putExtra("from_risk_hint", true);
        RouteUtils.a(getActivity(), paramString, "/base/safe/authDevOpenActivity");
      }
      else if (this.d.AllowSet == 0)
      {
        if (this.f)
        {
          b();
          return;
        }
        paramString = new Intent();
        paramString.putExtra("DevlockInfo", this.d);
        paramString.putExtra("from_risk_hint", true);
        RouteUtils.a(getActivity(), paramString, "/base/safe/authDevOpenActivity");
      }
      else if (this.d.AllowSet == 1)
      {
        b();
      }
      ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800AAA5", "0X800AAA5", 0, 0, "", "", "", "");
      a();
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    else
    {
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString))
      {
        if (paramString.contains("1109907872")) {
          ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800AAA4", "0X800AAA4", 0, 0, "", "", "", "");
        } else if (paramString.contains("1108149324")) {
          ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800B258", "0X800B258", 0, 0, "", "", "", "");
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getQBaseActivity(), paramString, 4010, null);
        return;
      }
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http")) || (paramString.startsWith("https"))))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("from_risk_hint", true);
        RouteUtils.a(getActivity(), localIntent, "/base/browser");
        return;
      }
      ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800AAA6", "0X800AAA6", 0, 0, "", "", "", "");
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      paramString1 = DialogUtil.a(getQBaseActivity(), 0, paramString1, paramString2, paramString3, paramString4, new RiskHintDlgFragment.1(this), new RiskHintDlgFragment.2(this));
      paramString1.setOnDismissListener(new RiskHintDlgFragment.3(this));
      paramString1.show();
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("RiskHintDlgFragment", 1, paramString1, new Object[0]);
      getQBaseActivity().finish();
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = DialogUtil.a(getQBaseActivity(), 0, paramString1, paramString2, paramString3, paramString4, paramString5, new RiskHintDlgFragment.4(this), new RiskHintDlgFragment.5(this), new RiskHintDlgFragment.6(this));
      paramString1.setOnDismissListener(new RiskHintDlgFragment.7(this));
      a(paramString1);
      a(paramString1, paramString2, this.g, this.h);
      paramString1.show();
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("RiskHintDlgFragment", 1, paramString1, new Object[0]);
      getQBaseActivity().finish();
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
    this.a = localBundle.getString("btnAction1", "");
    this.b = localBundle.getString("btnAction2", "");
    this.c = localBundle.getString("btnAction3", "");
    this.g = localBundle.getString("contentUrlText", "");
    this.h = localBundle.getString("contentUrlValue", "");
    if (l == 1062L)
    {
      a(str1, str2, str3, str4);
    }
    else if ((l != 1063L) && (l != 1123L) && (l != 1124L))
    {
      QLog.e("RiskHintDlgFragment", 1, new Object[] { "error templateId:", Long.valueOf(l) });
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
    else
    {
      a(str1, str2, str3, str4, str5);
    }
    a();
    ((ILoginApi)QRoute.api(ILoginApi.class)).preloadThirdService();
    ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).doAfterPushRiskDialog(getQBaseActivity().getAppRuntime().getCurrentAccountUin(), System.currentTimeMillis());
    ReportController.b(getQBaseActivity().getAppRuntime(), "dc00898", "", "", "0X800AAA3", "0X800AAA3", 0, 0, "", "", "", "");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskHintDlgFragment
 * JD-Core Version:    0.7.0.1
 */