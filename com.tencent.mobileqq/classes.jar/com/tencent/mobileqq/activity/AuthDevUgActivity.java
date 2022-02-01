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
    if ((this.mDevlockInfo != null) && (!TextUtils.isEmpty(this.mDevlockInfo.OtherDevLockVerifyUrl))) {
      this.mOtherVerifyTv.setVisibility(0);
    }
    String str;
    if (this.mIsFromLogin) {
      if ((this.mDevlockInfo != null) && (!TextUtils.isEmpty(this.mDevlockInfo.VerifyReason)))
      {
        this.mMainTv.setText(this.mDevlockInfo.VerifyReason);
        if (this.mDevlockInfo != null)
        {
          str = getString(2131692104) + ":" + this.mDevlockInfo.Mobile;
          this.mSecretPhoneTv.setText(str);
        }
        this.mBottomBtn.setText(getString(2131692134));
        this.mSetPhoneTv.setVisibility(8);
        if ((this.mDevlockInfo != null) && (!TextUtils.isEmpty(this.mDevlockInfo.Mobile))) {
          break label258;
        }
        this.mSecretPhoneTv.setVisibility(8);
        this.mChangePhoneBtn.setVisibility(8);
        if (this.mOtherVerifyTv != null) {
          this.mOtherVerifyTv.setVisibility(4);
        }
        label194:
        this.leftView.setVisibility(4);
        setRightButton(2131690800, this);
        if (AppSetting.d)
        {
          this.mChangePhoneBtn.setContentDescription(getString(2131692132));
          this.mBottomBtn.setContentDescription(getString(2131692134));
        }
      }
    }
    label258:
    label459:
    do
    {
      return;
      this.mMainTv.setText(getString(2131692133));
      break;
      this.mSecretPhoneTv.setVisibility(0);
      this.mChangePhoneBtn.setVisibility(0);
      break label194;
      if ((this.mDevlockInfo != null) && (!TextUtils.isEmpty(this.mDevlockInfo.ProtectIntro))) {
        this.mMainTv.setText(this.mDevlockInfo.ProtectIntro);
      }
      for (;;)
      {
        if ((this.mDevlockInfo == null) || (this.mDevlockInfo.MbGuideType != 2)) {
          break label459;
        }
        str = getString(2131692104) + ":" + this.mDevlockInfo.Mobile;
        this.mSecretPhoneTv.setText(str);
        this.mBottomBtn.setText(getString(2131692065));
        this.mSetPhoneTv.setVisibility(8);
        this.mSecretPhoneTv.setVisibility(0);
        this.mChangePhoneBtn.setVisibility(0);
        if (!AppSetting.d) {
          break;
        }
        this.mChangePhoneBtn.setContentDescription(getString(2131692132));
        this.mBottomBtn.setContentDescription(getString(2131692065));
        return;
        this.mMainTv.setText(getString(2131692133));
      }
      if ((this.mDevlockInfo != null) && (!TextUtils.isEmpty(this.mDevlockInfo.MbGuideMsg))) {
        this.mSetPhoneTv.setText(this.mDevlockInfo.MbGuideMsg);
      }
      this.mBottomBtn.setText(getString(2131692065));
    } while (!AppSetting.d);
    this.mChangePhoneBtn.setContentDescription(getString(2131692132));
    this.mBottomBtn.setContentDescription(getString(2131692065));
  }
  
  private void jumpToOtherVerify()
  {
    boolean bool = true;
    if ((this.mDevlockInfo == null) || (TextUtils.isEmpty(this.mDevlockInfo.OtherDevLockVerifyUrl)))
    {
      QLog.e("Q.devlock.AuthDevUgActivity", 1, "jumpToOtherVerify, mDevlockInfo or OtherDevLockVerifyUrl is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("url", this.mDevlockInfo.OtherDevLockVerifyUrl);
    localIntent.putExtra("subAccountUin", this.mUin);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    if ((this.mMainAccount != null) && (!this.mMainAccount.equals(this.mUin))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevUgActivity", 2, "other_verify,  mMainAccount =" + this.mMainAccount + " mUin =" + this.mUin + " isSubaccount=" + bool);
      }
      localIntent.putExtra("isSubaccount", bool);
      localIntent.putExtra("avoidLoginWeb", bool);
      beforeOpenBrowser();
      try
      {
        this.mEquipLockApi.a(this, "", 16384L, localIntent, false, -1);
        label202:
        afterOpenBrowser();
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
        return;
      }
      catch (SecurityException localSecurityException)
      {
        break label202;
      }
      bool = false;
    }
  }
  
  private void jumpToSMSVerify()
  {
    if ("com.tencent.mobileqq:openSdk".equals(this.mApp.getApplication().getQQProcessName())) {}
    for (Object localObject = "/base/login/authDevVerifyCodeOpenSdk";; localObject = "/base/login/authDevVerifyCode")
    {
      localObject = new ActivityURIRequest(this, (String)localObject);
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
      return;
    }
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
  
  public boolean doOnCreate(Bundle paramBundle)
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
    for (;;)
    {
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
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate mIsFromLogin = " + this.mIsFromLogin + " mVerifySeq=" + this.mVerifySeq + " mUin=" + this.mUin + " mFromWhere=" + this.mFromWhere + " mMainAccount=" + this.mMainAccount);
          if (this.mDevlockInfo != null)
          {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate DevlockInfo devSetup:" + this.mDevlockInfo.DevSetup + " countryCode:" + this.mDevlockInfo.CountryCode + " mobile:" + this.mDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.mDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.mDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.mDevlockInfo.AvailableMsgCount + " AllowSet:" + this.mDevlockInfo.AllowSet);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.ProtectIntro:" + this.mDevlockInfo.ProtectIntro + "  info.MbGuideType:" + this.mDevlockInfo.MbGuideType);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideMsg:" + this.mDevlockInfo.MbGuideMsg);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideInfoType:" + this.mDevlockInfo.MbGuideInfoType);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideInfo:" + this.mDevlockInfo.MbGuideInfo);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.OtherDevLockVerifyUrl" + this.mDevlockInfo.OtherDevLockVerifyUrl);
          }
        }
        super.getWindow().setFormat(-3);
        if (this.mIsFromLogin) {
          setTheme(2131755586);
        }
        super.setContentView(2131561192);
        if (this.mIsFromLogin)
        {
          super.setTitle(2131692100);
          this.mApp = this.mRuntime;
          if (this.mApp == null) {
            this.mApp = getAppRuntime();
          }
          if (this.mApp != null) {
            break;
          }
          finish();
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        finish();
        return true;
      }
      super.setTitle(2131692099);
    }
    this.mEquipLockApi = new EquipLockProxy();
    if (this.mIsFromLogin)
    {
      LoginUtils.b(this.mApp);
      if ((this.mDevlockInfo == null) || (TextUtils.isEmpty(this.mDevlockInfo.MbGuideInfo))) {
        break label873;
      }
      this.mEquipLockApi.a(this.mDevlockInfo.MbGuideInfo);
    }
    for (;;)
    {
      this.mMainTv = ((TextView)super.findViewById(2131371013));
      this.mSetPhoneTv = ((TextView)super.findViewById(2131377883));
      this.mSecretPhoneTv = ((TextView)super.findViewById(2131372947));
      this.mChangePhoneBtn = ((Button)super.findViewById(2131364548));
      this.mBottomBtn = ((Button)super.findViewById(2131380845));
      this.mChangePhoneBtn.setOnClickListener(this);
      this.mBottomBtn.setOnClickListener(this);
      this.mOtherVerifyTv = ((TextView)super.findViewById(2131372640));
      this.mOtherVerifyTv.setOnClickListener(this);
      initUI();
      this.mVerifyObserver.setSeq(this.mVerifySeq);
      ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AA33", "0X800AA33", LoginStaticField.a, 0, "", "", "", "");
      if (LoginStaticField.a != 1) {
        break;
      }
      ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AC0B", "0X800AC0B", LoginStaticField.a, 0, "", "", "", "");
      return true;
      label873:
      finish();
      overridePendingTransition(0, 0);
      QQToast.a(this, 1, getString(2131693889), 0).a();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mApp = null;
  }
  
  public void doOnResume()
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
  
  public boolean isWrapContent()
  {
    return !this.mIsFromLogin;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        if (this.mDevlockInfo != null)
        {
          paramIntent.putExtra("phone_num", this.mDevlockInfo.Mobile);
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
        if (this.mDevlockInfo != null) {
          paramIntent.putExtra("phone_num", this.mDevlockInfo.Mobile);
        }
        finishSelf(-1, paramIntent);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if (paramInt1 != 1002) {
                        break;
                      }
                    } while (paramInt2 != -1);
                    setResult(paramInt2, paramIntent);
                    finish();
                    return;
                  } while (paramInt1 != 1003);
                  if (paramInt2 != -1) {
                    break;
                  }
                } while ((paramIntent == null) || (paramIntent.getExtras() == null));
                paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
                }
              } while (paramInt1 != 2);
              localObject = paramIntent.getExtras().getString("resultMobileMask");
              bool = paramIntent.getExtras().getBoolean("resultSetMobile");
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + (String)localObject + " openSuccess=" + bool);
              }
              if (this.mDevlockInfo != null)
              {
                this.mDevlockInfo.Mobile = ((String)localObject);
                if (!TextUtils.isEmpty(this.mDevlockInfo.Mobile))
                {
                  paramIntent = getString(2131692104) + ":" + this.mDevlockInfo.Mobile;
                  this.mSecretPhoneTv.setText(paramIntent);
                  this.mBottomBtn.setText(getString(2131692065));
                  this.mSetPhoneTv.setVisibility(8);
                  this.mSecretPhoneTv.setVisibility(0);
                  this.mChangePhoneBtn.setVisibility(0);
                }
              }
            } while (!bool);
            this.mEquipLockApi.a(this.mApp, this, this.mApp.getCurrentAccountUin(), true);
            paramIntent = new Intent();
            paramIntent.putExtra("phone_num", (String)localObject);
            if (this.mDevlockInfo != null) {
              paramIntent.putExtra("country_code", this.mDevlockInfo.CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            LoginUtils.a(this, paramIntent, "/base/safe/authDevActivity");
            QQToast.a(getApplicationContext(), 2, getString(2131692061), 0).b(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            if (this.mDevlockInfo != null) {
              paramIntent.putExtra("phone_num", this.mDevlockInfo.Mobile);
            }
            finishSelf(-1, paramIntent);
            return;
          } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
          paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
          }
        } while (paramInt1 != 2);
        paramIntent = paramIntent.getExtras().getString("resultMobileMask");
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
        }
        if (!TextUtils.isEmpty(paramIntent)) {
          this.mEquipLockApi.a(this.mApp, this.mApp.getCurrentAccountUin(), null);
        }
      } while (this.mDevlockInfo == null);
      this.mDevlockInfo.Mobile = paramIntent;
    } while (TextUtils.isEmpty(this.mDevlockInfo.Mobile));
    paramIntent = getString(2131692104) + ":" + this.mDevlockInfo.Mobile;
    this.mSecretPhoneTv.setText(paramIntent);
    this.mBottomBtn.setText(getString(2131692065));
    this.mSetPhoneTv.setVisibility(8);
    this.mSecretPhoneTv.setVisibility(0);
    this.mChangePhoneBtn.setVisibility(0);
  }
  
  public boolean onBackEvent()
  {
    if (this.mIsFromLogin)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onBackEvent.cancelVerifyCode mVerifyObserver.seq=");
        if (this.mVerifyObserver == null) {
          break label98;
        }
      }
      label98:
      for (int i = this.mVerifyObserver.getSeq();; i = 0)
      {
        QLog.d("Q.devlock.AuthDevUgActivity", 2, i);
        setResult(0);
        this.mEquipLockApi.a(this.mApp, this.mVerifyObserver);
        this.mVerifyObserver = null;
        finish();
        overridePendingTransition(0, 2130772003);
        return false;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", false);
    String str = "";
    Object localObject = str;
    if (this.mDevlockInfo != null)
    {
      localObject = str;
      if (this.mDevlockInfo.Mobile != null) {
        localObject = this.mDevlockInfo.Mobile;
      }
    }
    localIntent.putExtra("phone_num", (String)localObject);
    finishSelf(0, localIntent);
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((this.mLastClickTimeMillis > 0L) && (System.currentTimeMillis() - this.mLastClickTimeMillis > 0L) && (System.currentTimeMillis() - this.mLastClickTimeMillis < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.mLastClickTimeMillis = System.currentTimeMillis();
      int i = paramView.getId();
      if (i == 2131364548)
      {
        ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AA34", "0X800AA34", LoginStaticField.a, 0, "", "", "", "");
        this.mApp.sendWirelessMeibaoReq(1);
        if (mAppForground)
        {
          if ((!TextUtils.isEmpty(this.mFromWhere)) && (this.mFromWhere.equals("subaccount")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "subaccount enter webview mUin=" + this.mUin + " mMainAccount=" + this.mMainAccount);
            }
            if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
            }
            this.mEquipLockApi.a(this, this.mMainAccount, this.mUin, 1);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "mainaccount enter webview mUin=" + this.mUin);
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
      else
      {
        Object localObject;
        if (i == 2131380845)
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
          else if ((this.mDevlockInfo != null) && (!TextUtils.isEmpty(this.mDevlockInfo.Mobile)))
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
        else
        {
          if (i == 2131369518)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("onClick.cancelVerifyCode mVerifyObserver.seq=");
              if (this.mVerifyObserver == null) {
                break label656;
              }
            }
            label656:
            for (i = this.mVerifyObserver.getSeq();; i = 0)
            {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, i);
              ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AA37", "0X800AA37", LoginStaticField.a, 0, "", "", "", "");
              this.mEquipLockApi.a(this.mApp, this.mVerifyObserver);
              this.mVerifyObserver = null;
              finish();
              overridePendingTransition(0, 2130772003);
              break;
            }
          }
          if ((i == 2131372640) && ((this.mLastClickTimeMillisForJumpOther <= 0L) || (System.currentTimeMillis() - this.mLastClickTimeMillisForJumpOther <= 0L) || (System.currentTimeMillis() - this.mLastClickTimeMillisForJumpOther >= 3000L)))
          {
            this.mLastClickTimeMillisForJumpOther = System.currentTimeMillis();
            ReportController.a(this.mRuntime, "dc00898", "", this.mUin, "0X800AA36", "0X800AA36", LoginStaticField.a, 0, "", "", "", "");
            jumpToOtherVerify();
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevUgActivity
 * JD-Core Version:    0.7.0.1
 */