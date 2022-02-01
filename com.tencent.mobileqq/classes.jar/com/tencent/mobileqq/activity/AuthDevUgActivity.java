package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.loginregister.EquipLockProxy;
import com.tencent.mobileqq.loginregister.IEquipLockApi;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

@RoutePage(desc="设备锁验证页面", path="/base/safe/authDevUgActivity")
public class AuthDevUgActivity
  extends QIphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final long MAX_TIME_SPACE = 3000L;
  private static final long MIN_TIME_SPACE = 500L;
  private static final String TAG = "Q.devlock.AuthDevUgActivity";
  private AppRuntime mApp = null;
  private Button mBottomBtn;
  private Button mChangePhoneBtn;
  private DevlockInfo mDevlockInfo = null;
  private IEquipLockApi mEquipLockApi;
  private String mFromWhere;
  private boolean mIsFromLogin = false;
  private long mLastClickTimeMillis = 0L;
  private long mLastClickTimeMillisForJumpOther = 0L;
  private String mMainAccount;
  private TextView mMainTv;
  private TextView mOtherVerifyTv;
  private TextView mSecretPhoneTv;
  private TextView mSetPhoneTv;
  private String mUin;
  VerifyDevLockManager.VerifyDevLockObserver mVerifyObserver = new AuthDevUgActivity.1(this);
  private int mVerifySeq;
  
  private void initUI()
  {
    Object localObject = this.mDevlockInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((DevlockInfo)localObject).OtherDevLockVerifyUrl))) {
      this.mOtherVerifyTv.setVisibility(0);
    }
    if (this.mIsFromLogin)
    {
      localObject = this.mDevlockInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((DevlockInfo)localObject).VerifyReason))) {
        this.mMainTv.setText(this.mDevlockInfo.VerifyReason);
      } else {
        this.mMainTv.setText(getString(2131692052));
      }
      if (this.mDevlockInfo != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getString(2131692023));
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(this.mDevlockInfo.Mobile);
        localObject = ((StringBuilder)localObject).toString();
        this.mSecretPhoneTv.setText((CharSequence)localObject);
      }
      this.mBottomBtn.setText(getString(2131692053));
      this.mSetPhoneTv.setVisibility(8);
      localObject = this.mDevlockInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((DevlockInfo)localObject).Mobile)))
      {
        this.mSecretPhoneTv.setVisibility(0);
        this.mChangePhoneBtn.setVisibility(0);
      }
      else
      {
        this.mSecretPhoneTv.setVisibility(8);
        this.mChangePhoneBtn.setVisibility(8);
        localObject = this.mOtherVerifyTv;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(4);
        }
      }
      this.leftView.setVisibility(4);
      setRightButton(2131690728, this);
      if (AppSetting.d)
      {
        this.mChangePhoneBtn.setContentDescription(getString(2131692051));
        this.mBottomBtn.setContentDescription(getString(2131692053));
      }
    }
    else
    {
      localObject = this.mDevlockInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((DevlockInfo)localObject).ProtectIntro))) {
        this.mMainTv.setText(this.mDevlockInfo.ProtectIntro);
      } else {
        this.mMainTv.setText(getString(2131692052));
      }
      localObject = this.mDevlockInfo;
      if ((localObject != null) && (((DevlockInfo)localObject).MbGuideType == 2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getString(2131692023));
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(this.mDevlockInfo.Mobile);
        localObject = ((StringBuilder)localObject).toString();
        this.mSecretPhoneTv.setText((CharSequence)localObject);
        this.mBottomBtn.setText(getString(2131691984));
        this.mSetPhoneTv.setVisibility(8);
        this.mSecretPhoneTv.setVisibility(0);
        this.mChangePhoneBtn.setVisibility(0);
        if (AppSetting.d)
        {
          this.mChangePhoneBtn.setContentDescription(getString(2131692051));
          this.mBottomBtn.setContentDescription(getString(2131691984));
        }
      }
      else
      {
        localObject = this.mDevlockInfo;
        if ((localObject != null) && (!TextUtils.isEmpty(((DevlockInfo)localObject).MbGuideMsg))) {
          this.mSetPhoneTv.setText(this.mDevlockInfo.MbGuideMsg);
        }
        this.mBottomBtn.setText(getString(2131691984));
        if (AppSetting.d)
        {
          this.mChangePhoneBtn.setContentDescription(getString(2131692051));
          this.mBottomBtn.setContentDescription(getString(2131691984));
        }
      }
    }
  }
  
  private void jumpToOtherVerify()
  {
    Object localObject1 = this.mDevlockInfo;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((DevlockInfo)localObject1).OtherDevLockVerifyUrl)))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("portraitOnly", true);
      ((Intent)localObject1).putExtra("url", this.mDevlockInfo.OtherDevLockVerifyUrl);
      ((Intent)localObject1).putExtra("subAccountUin", this.mUin);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).putExtra("hide_more_button", true);
      boolean bool2 = false;
      Object localObject2 = this.mMainAccount;
      boolean bool1 = bool2;
      if (localObject2 != null)
      {
        bool1 = bool2;
        if (!((String)localObject2).equals(this.mUin)) {
          bool1 = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("other_verify,  mMainAccount =");
        ((StringBuilder)localObject2).append(this.mMainAccount);
        ((StringBuilder)localObject2).append(" mUin =");
        ((StringBuilder)localObject2).append(this.mUin);
        ((StringBuilder)localObject2).append(" isSubaccount=");
        ((StringBuilder)localObject2).append(bool1);
        QLog.d("Q.devlock.AuthDevUgActivity", 2, ((StringBuilder)localObject2).toString());
      }
      ((Intent)localObject1).putExtra("isSubaccount", bool1);
      ((Intent)localObject1).putExtra("avoidLoginWeb", bool1);
      beforeOpenBrowser();
    }
    try
    {
      this.mEquipLockApi.a(this, "", 16384L, (Intent)localObject1, false, -1);
      label225:
      afterOpenBrowser();
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
      return;
      QLog.e("Q.devlock.AuthDevUgActivity", 1, "jumpToOtherVerify, mDevlockInfo or OtherDevLockVerifyUrl is null");
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label225;
    }
  }
  
  private void jumpToSMSVerify()
  {
    if ("com.tencent.mobileqq:openSdk".equals(this.mApp.getApplication().getQQProcessName())) {
      localObject = "/base/login/authDevVerifyCodeOpenSdk";
    } else {
      localObject = "/base/login/authDevVerifyCode";
    }
    Object localObject = new ActivityURIRequest(this, (String)localObject);
    if (this.mDevlockInfo != null)
    {
      ((ActivityURIRequest)localObject).extra().putString("phone_num", this.mDevlockInfo.Mobile);
      ((ActivityURIRequest)localObject).extra().putString("country_code", this.mDevlockInfo.CountryCode);
      ((ActivityURIRequest)localObject).extra().putInt("mobile_type", 0);
    }
    ((ActivityURIRequest)localObject).extra().putBoolean("from_login", this.mIsFromLogin);
    ((ActivityURIRequest)localObject).extra().putString("uin", this.mUin);
    ((ActivityURIRequest)localObject).extra().putInt("seq", this.mVerifySeq);
    ((ActivityURIRequest)localObject).setRequestCode(1002);
    QRoute.startUri((URIRequest)localObject, null);
  }
  
  protected void afterOpenBrowser()
  {
    QLog.d("Q.devlock.AuthDevUgActivity", 1, "afterOpenBrowser do nothing");
  }
  
  protected void beforeOpenBrowser()
  {
    finish();
    QLog.d("Q.devlock.AuthDevUgActivity", 1, "beforeOpenBrowser do finish");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return true;
    }
    paramBundle = paramBundle.getExtras();
    if (paramBundle == null)
    {
      finish();
      return true;
    }
    try
    {
      this.mIsFromLogin = paramBundle.getBoolean("from_login");
      this.mVerifySeq = paramBundle.getInt("seq");
      Object localObject = paramBundle.get("DevlockInfo");
      if ((localObject instanceof DevlockInfo)) {
        this.mDevlockInfo = ((DevlockInfo)localObject);
      }
      this.mUin = paramBundle.getString("uin");
      this.mFromWhere = paramBundle.getString("from_where");
      this.mMainAccount = paramBundle.getString("mainaccount");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate mIsFromLogin = ");
        paramBundle.append(this.mIsFromLogin);
        paramBundle.append(" mVerifySeq=");
        paramBundle.append(this.mVerifySeq);
        paramBundle.append(" mUin=");
        paramBundle.append(this.mUin);
        paramBundle.append(" mFromWhere=");
        paramBundle.append(this.mFromWhere);
        paramBundle.append(" mMainAccount=");
        paramBundle.append(this.mMainAccount);
        QLog.d("Q.devlock.AuthDevUgActivity", 2, paramBundle.toString());
        if (this.mDevlockInfo != null)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("onCreate DevlockInfo devSetup:");
          paramBundle.append(this.mDevlockInfo.DevSetup);
          paramBundle.append(" countryCode:");
          paramBundle.append(this.mDevlockInfo.CountryCode);
          paramBundle.append(" mobile:");
          paramBundle.append(this.mDevlockInfo.Mobile);
          paramBundle.append(" MbItemSmsCodeStatus:");
          paramBundle.append(this.mDevlockInfo.MbItemSmsCodeStatus);
          paramBundle.append(" TimeLimit:");
          paramBundle.append(this.mDevlockInfo.TimeLimit);
          paramBundle.append(" AvailableMsgCount:");
          paramBundle.append(this.mDevlockInfo.AvailableMsgCount);
          paramBundle.append(" AllowSet:");
          paramBundle.append(this.mDevlockInfo.AllowSet);
          QLog.d("Q.devlock.AuthDevUgActivity", 2, paramBundle.toString());
          paramBundle = new StringBuilder();
          paramBundle.append("DevlockInfo.ProtectIntro:");
          paramBundle.append(this.mDevlockInfo.ProtectIntro);
          paramBundle.append("  info.MbGuideType:");
          paramBundle.append(this.mDevlockInfo.MbGuideType);
          QLog.d("Q.devlock.AuthDevUgActivity", 2, paramBundle.toString());
          paramBundle = new StringBuilder();
          paramBundle.append("DevlockInfo.MbGuideMsg:");
          paramBundle.append(this.mDevlockInfo.MbGuideMsg);
          QLog.d("Q.devlock.AuthDevUgActivity", 2, paramBundle.toString());
          paramBundle = new StringBuilder();
          paramBundle.append("DevlockInfo.MbGuideInfoType:");
          paramBundle.append(this.mDevlockInfo.MbGuideInfoType);
          QLog.d("Q.devlock.AuthDevUgActivity", 2, paramBundle.toString());
          paramBundle = new StringBuilder();
          paramBundle.append("DevlockInfo.MbGuideInfo:");
          paramBundle.append(this.mDevlockInfo.MbGuideInfo);
          QLog.d("Q.devlock.AuthDevUgActivity", 2, paramBundle.toString());
          paramBundle = new StringBuilder();
          paramBundle.append("DevlockInfo.OtherDevLockVerifyUrl");
          paramBundle.append(this.mDevlockInfo.OtherDevLockVerifyUrl);
          QLog.d("Q.devlock.AuthDevUgActivity", 2, paramBundle.toString());
        }
      }
      super.getWindow().setFormat(-3);
      if (this.mIsFromLogin) {
        setTheme(2131755933);
      }
      super.setContentView(2131561055);
      if (this.mIsFromLogin) {
        super.setTitle(2131692019);
      } else {
        super.setTitle(2131692018);
      }
      this.mApp = this.mRuntime;
      if (this.mApp == null) {
        this.mApp = getAppRuntime();
      }
      if (this.mApp == null)
      {
        finish();
        return true;
      }
      this.mEquipLockApi = new EquipLockProxy();
      if (this.mIsFromLogin)
      {
        LoginUtils.b(this.mApp);
        paramBundle = this.mDevlockInfo;
        if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.MbGuideInfo)))
        {
          this.mEquipLockApi.a(this.mDevlockInfo.MbGuideInfo);
        }
        else
        {
          finish();
          overridePendingTransition(0, 0);
          QQToast.a(this, 1, getString(2131693843), 0).a();
        }
      }
      this.mMainTv = ((TextView)super.findViewById(2131370647));
      this.mSetPhoneTv = ((TextView)super.findViewById(2131377309));
      this.mSecretPhoneTv = ((TextView)super.findViewById(2131372534));
      this.mChangePhoneBtn = ((Button)super.findViewById(2131364435));
      this.mBottomBtn = ((Button)super.findViewById(2131380109));
      this.mChangePhoneBtn.setOnClickListener(this);
      this.mBottomBtn.setOnClickListener(this);
      this.mOtherVerifyTv = ((TextView)super.findViewById(2131372221));
      this.mOtherVerifyTv.setOnClickListener(this);
      initUI();
      this.mVerifyObserver.setSeq(this.mVerifySeq);
      ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AA33", "0X800AA33", LoginStaticField.a, 0, "", "", "", "");
      if (LoginStaticField.a == 1) {
        ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AC0B", "0X800AC0B", LoginStaticField.a, 0, "", "", "", "");
      }
      return true;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.mApp = null;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      Intent localIntent = new Intent();
      localIntent.putExtra("from_risk_hint", true);
      LoginUtils.a(this, localIntent, "/base/safe/loginInfo");
    }
  }
  
  public void finishSelf(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected boolean isWrapContent()
  {
    return !this.mIsFromLogin;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt1 == 1001)
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        localObject = this.mDevlockInfo;
        if (localObject != null)
        {
          paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
          paramIntent.putExtra("country_code", this.mDevlockInfo.CountryCode);
        }
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent = paramIntent.getExtras();
        localObject = new ActivityURIRequest(this, "/base/safe/authDevActivity");
        ((ActivityURIRequest)localObject).extra().putAll(paramIntent);
        QRoute.startUri((URIRequest)localObject, null);
        paramIntent = new Intent();
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent.putExtra("allow_set", true);
        localObject = this.mDevlockInfo;
        if (localObject != null) {
          paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
        }
        finishSelf(-1, paramIntent);
      }
    }
    else if (paramInt1 == 1002)
    {
      if (paramInt2 == -1)
      {
        setResult(paramInt2, paramIntent);
        finish();
      }
    }
    else if (paramInt1 == 1003)
    {
      AppRuntime localAppRuntime;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.getExtras() != null))
        {
          paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onActivityResult.resultCode= RESULT_OK  resultState =");
            ((StringBuilder)localObject).append(paramInt1);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, ((StringBuilder)localObject).toString());
          }
          if (paramInt1 == 2)
          {
            localObject = paramIntent.getExtras().getString("resultMobileMask");
            boolean bool = paramIntent.getExtras().getBoolean("resultSetMobile");
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("onActivityResult.resultCode= RESULT_OK  resultMobileMask =");
              paramIntent.append((String)localObject);
              paramIntent.append(" openSuccess=");
              paramIntent.append(bool);
              QLog.d("Q.devlock.AuthDevUgActivity", 2, paramIntent.toString());
            }
            paramIntent = this.mDevlockInfo;
            if (paramIntent != null)
            {
              paramIntent.Mobile = ((String)localObject);
              if (!TextUtils.isEmpty(paramIntent.Mobile))
              {
                paramIntent = new StringBuilder();
                paramIntent.append(getString(2131692023));
                paramIntent.append(":");
                paramIntent.append(this.mDevlockInfo.Mobile);
                paramIntent = paramIntent.toString();
                this.mSecretPhoneTv.setText(paramIntent);
                this.mBottomBtn.setText(getString(2131691984));
                this.mSetPhoneTv.setVisibility(8);
                this.mSecretPhoneTv.setVisibility(0);
                this.mChangePhoneBtn.setVisibility(0);
              }
            }
            if (!bool) {
              return;
            }
            paramIntent = this.mEquipLockApi;
            localAppRuntime = this.mApp;
            paramIntent.a(localAppRuntime, this, localAppRuntime.getCurrentAccountUin(), true);
            paramIntent = new Intent();
            paramIntent.putExtra("phone_num", (String)localObject);
            localObject = this.mDevlockInfo;
            if (localObject != null) {
              paramIntent.putExtra("country_code", ((DevlockInfo)localObject).CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            LoginUtils.a(this, paramIntent, "/base/safe/authDevActivity");
            QQToast.a(getApplicationContext(), 2, getString(2131691980), 0).b(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            localObject = this.mDevlockInfo;
            if (localObject != null) {
              paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
            }
            finishSelf(-1, paramIntent);
          }
        }
      }
      else if ((paramInt2 == 0) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onActivityResult.resultCode= RESULT_CANCELED resultState =");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.d("Q.devlock.AuthDevUgActivity", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt1 == 2)
        {
          paramIntent = paramIntent.getExtras().getString("resultMobileMask");
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =");
            ((StringBuilder)localObject).append(paramIntent);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, ((StringBuilder)localObject).toString());
          }
          if (!TextUtils.isEmpty(paramIntent))
          {
            localObject = this.mEquipLockApi;
            localAppRuntime = this.mApp;
            ((IEquipLockApi)localObject).a(localAppRuntime, localAppRuntime.getCurrentAccountUin(), null);
          }
          localObject = this.mDevlockInfo;
          if (localObject != null)
          {
            ((DevlockInfo)localObject).Mobile = paramIntent;
            if (!TextUtils.isEmpty(((DevlockInfo)localObject).Mobile))
            {
              paramIntent = new StringBuilder();
              paramIntent.append(getString(2131692023));
              paramIntent.append(":");
              paramIntent.append(this.mDevlockInfo.Mobile);
              paramIntent = paramIntent.toString();
              this.mSecretPhoneTv.setText(paramIntent);
              this.mBottomBtn.setText(getString(2131691984));
              this.mSetPhoneTv.setVisibility(8);
              this.mSecretPhoneTv.setVisibility(0);
              this.mChangePhoneBtn.setVisibility(0);
            }
          }
        }
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.mIsFromLogin)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onBackEvent.cancelVerifyCode mVerifyObserver.seq=");
        localObject2 = this.mVerifyObserver;
        int i;
        if (localObject2 != null) {
          i = ((VerifyDevLockManager.VerifyDevLockObserver)localObject2).getSeq();
        } else {
          i = 0;
        }
        ((StringBuilder)localObject1).append(i);
        QLog.d("Q.devlock.AuthDevUgActivity", 2, ((StringBuilder)localObject1).toString());
      }
      setResult(0);
      this.mEquipLockApi.a(this.mApp, this.mVerifyObserver);
      this.mVerifyObserver = null;
      finish();
      overridePendingTransition(0, 2130772015);
      return false;
    }
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("auth_dev_open", false);
    Object localObject1 = this.mDevlockInfo;
    if ((localObject1 != null) && (((DevlockInfo)localObject1).Mobile != null)) {
      localObject1 = this.mDevlockInfo.Mobile;
    } else {
      localObject1 = "";
    }
    ((Intent)localObject2).putExtra("phone_num", (String)localObject1);
    finishSelf(0, (Intent)localObject2);
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((this.mLastClickTimeMillis <= 0L) || (System.currentTimeMillis() - this.mLastClickTimeMillis <= 0L) || (System.currentTimeMillis() - this.mLastClickTimeMillis >= 500L))
    {
      this.mLastClickTimeMillis = System.currentTimeMillis();
      int i = paramView.getId();
      Object localObject;
      if (i == 2131364435)
      {
        ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AA34", "0X800AA34", LoginStaticField.a, 0, "", "", "", "");
        this.mApp.sendWirelessMeibaoReq(1);
        if (mAppForground)
        {
          if ((!TextUtils.isEmpty(this.mFromWhere)) && (this.mFromWhere.equals("subaccount")))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("subaccount enter webview mUin=");
              ((StringBuilder)localObject).append(this.mUin);
              ((StringBuilder)localObject).append(" mMainAccount=");
              ((StringBuilder)localObject).append(this.mMainAccount);
              QLog.d("Q.devlock.AuthDevUgActivity", 2, ((StringBuilder)localObject).toString());
            }
            if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
            }
            this.mEquipLockApi.a(this, this.mMainAccount, this.mUin, 1);
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("mainaccount enter webview mUin=");
              ((StringBuilder)localObject).append(this.mUin);
              QLog.d("Q.devlock.AuthDevUgActivity", 2, ((StringBuilder)localObject).toString());
            }
            if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
            }
            this.mEquipLockApi.a(this, this.mApp.getCurrentAccountUin(), this.mUin, 1);
          }
        }
        else {
          this.mEquipLockApi.a(this, this.mApp, 1);
        }
      }
      else if (i == 2131380109)
      {
        if (this.mIsFromLogin)
        {
          ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AA35", "0X800AA35", LoginStaticField.a, 0, "", "", "", "");
          if (TextUtils.isEmpty(this.mDevlockInfo.Mobile)) {
            jumpToOtherVerify();
          } else {
            jumpToSMSVerify();
          }
        }
        else
        {
          localObject = this.mDevlockInfo;
          if ((localObject != null) && (!TextUtils.isEmpty(((DevlockInfo)localObject).Mobile)))
          {
            ReportController.b(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
            localObject = new Intent(this, AuthDevVerifyCodeActivity.class);
            ((Intent)localObject).putExtra("phone_num", this.mDevlockInfo.Mobile);
            ((Intent)localObject).putExtra("country_code", this.mDevlockInfo.CountryCode);
            startActivityForResult((Intent)localObject, 1001);
          }
          else
          {
            this.mEquipLockApi.a(this, this.mApp, 1, 1003, null);
          }
        }
      }
      else if (i == 2131369233)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onClick.cancelVerifyCode mVerifyObserver.seq=");
          VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = this.mVerifyObserver;
          if (localVerifyDevLockObserver != null) {
            i = localVerifyDevLockObserver.getSeq();
          } else {
            i = 0;
          }
          ((StringBuilder)localObject).append(i);
          QLog.d("Q.devlock.AuthDevUgActivity", 2, ((StringBuilder)localObject).toString());
        }
        ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AA37", "0X800AA37", LoginStaticField.a, 0, "", "", "", "");
        this.mEquipLockApi.a(this.mApp, this.mVerifyObserver);
        this.mVerifyObserver = null;
        finish();
        overridePendingTransition(0, 2130772015);
      }
      else if ((i == 2131372221) && ((this.mLastClickTimeMillisForJumpOther <= 0L) || (System.currentTimeMillis() - this.mLastClickTimeMillisForJumpOther <= 0L) || (System.currentTimeMillis() - this.mLastClickTimeMillisForJumpOther >= 3000L)))
      {
        this.mLastClickTimeMillisForJumpOther = System.currentTimeMillis();
        ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AA36", "0X800AA36", LoginStaticField.a, 0, "", "", "", "");
        jumpToOtherVerify();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevUgActivity
 * JD-Core Version:    0.7.0.1
 */