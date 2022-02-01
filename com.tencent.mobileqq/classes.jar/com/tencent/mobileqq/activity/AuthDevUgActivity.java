package com.tencent.mobileqq.activity;

import Override;
import adkt;
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
import aslh;
import asll;
import bdla;
import bkki;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevUgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 0;
  public static final ArrayList<String> a;
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new adkt(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private TextView d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new String[] { "0X800AA33", "0X800AA34", "0X800AA35", "0X800AA36", "0X800AA37", "0X800B0AA", "0X800B0AC", "0X800B0A3", "0X800B106", "0X800B107", "0X800B108", "0X800B109", "0X800B10A", "0X800B10B", "0X800B10C" }));
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl))) {
      this.d.setVisibility(0);
    }
    String str;
    if (this.jdField_a_of_type_Boolean) {
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          str = getString(2131691976) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
          this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        }
        this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131692006));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))) {
          break label258;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        if (this.d != null) {
          this.d.setVisibility(4);
        }
        label194:
        this.leftView.setVisibility(4);
        setRightButton(2131690697, this);
        if (AppSetting.c)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131692004));
          this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131692006));
        }
      }
    }
    label258:
    label459:
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692005));
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label194;
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType != 2)) {
          break label459;
        }
        str = getString(2131691976) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131691937));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        if (!AppSetting.c) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131692004));
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131691937));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692005));
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131691937));
    } while (!AppSetting.c);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131692004));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131691937));
  }
  
  private void d()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl)))
    {
      QLog.e("Q.devlock.AuthDevUgActivity", 1, "jumpToOtherVerify, mDevlockInfo or OtherDevLockVerifyUrl is null");
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("url", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl);
    localIntent.putExtra("subAccountUin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    if ((this.jdField_c_of_type_JavaLangString != null) && (!this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevUgActivity", 2, "other_verify,  mMainAccount =" + this.jdField_c_of_type_JavaLangString + " mUin =" + this.jdField_a_of_type_JavaLangString + " isSubaccount=" + bool);
      }
      localIntent.putExtra("isSubaccount", bool);
      localIntent.putExtra("avoidLoginWeb", bool);
      a();
      try
      {
        VasWebviewUtil.openQQBrowserActivity(this, "", 16384L, localIntent, false, -1);
        label199:
        b();
        bdla.a(this.app, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
        return;
      }
      catch (SecurityException localSecurityException)
      {
        break label199;
      }
      bool = false;
    }
  }
  
  private void e()
  {
    if ("com.tencent.mobileqq:openSdk".equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getQQProcessName())) {}
    for (Intent localIntent = new Intent(this, AuthDevVerifyCodeActivity2.class);; localIntent = new Intent(this, AuthDevVerifyCodeActivity.class))
    {
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
      {
        localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        localIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        localIntent.putExtra("mobile_type", 0);
      }
      localIntent.putExtra("from_login", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("seq", this.jdField_b_of_type_Int);
      startActivityForResult(localIntent, 1002);
      return;
    }
  }
  
  protected void a()
  {
    finish();
    QLog.d("Q.devlock.AuthDevUgActivity", 1, "beforeOpenBrowser do finish");
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected void b()
  {
    QLog.d("Q.devlock.AuthDevUgActivity", 1, "afterOpenBrowser do nothing");
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
        this.jdField_a_of_type_Boolean = paramBundle.getBoolean("from_login");
        this.jdField_b_of_type_Int = paramBundle.getInt("seq");
        Object localObject = paramBundle.get("DevlockInfo");
        if ((localObject instanceof DevlockInfo)) {
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)localObject);
        }
        this.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
        this.jdField_b_of_type_JavaLangString = paramBundle.getString("from_where");
        this.jdField_c_of_type_JavaLangString = paramBundle.getString("mainaccount");
        if (QLog.isColorLevel())
        {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.jdField_b_of_type_Int + " mUin=" + this.jdField_a_of_type_JavaLangString + " mFromWhere=" + this.jdField_b_of_type_JavaLangString + " mMainAccount=" + this.jdField_c_of_type_JavaLangString);
          if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
          {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate DevlockInfo devSetup:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup + " countryCode:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + " mobile:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AvailableMsgCount + " AllowSet:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.ProtectIntro:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro + "  info.MbGuideType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideMsg:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideInfoType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfoType);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideInfo:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.OtherDevLockVerifyUrl" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl);
          }
        }
        super.getWindow().setFormat(-3);
        if (this.jdField_a_of_type_Boolean) {
          setTheme(2131755578);
        }
        super.setContentView(2131561104);
        if (this.jdField_a_of_type_Boolean)
        {
          super.setTitle(2131691972);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.app;
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
            this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
          }
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
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
      super.setTitle(2131691971);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      bkki.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo))) {
        break label862;
      }
      asll.a().a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370732));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377465));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372627));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364440));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131380402));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.d = ((TextView)super.findViewById(2131372330));
      this.d.setOnClickListener(this);
      c();
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_b_of_type_Int);
      bdla.a(this.app, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA33", "0X800AA33", jdField_a_of_type_Int, 0, "", "", "", "");
      if (jdField_a_of_type_Int != 1) {
        break;
      }
      bdla.a(this.app, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AC0B", "0X800AC0B", jdField_a_of_type_Int, 0, "", "", "", "");
      return true;
      label862:
      finish();
      overridePendingTransition(0, 0);
      QQToast.a(this, 1, getString(2131693720), 0).a();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
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
      Intent localIntent = new Intent(this, LoginInfoActivity.class);
      localIntent.putExtra("from_risk_hint", true);
      startActivity(localIntent);
    }
  }
  
  public boolean isWrapContent()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent(this, AuthDevActivity.class);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramIntent.putExtra("auth_dev_open", true);
        startActivity(paramIntent);
        paramIntent = new Intent();
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent.putExtra("allow_set", true);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        }
        a(-1, paramIntent);
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
            String str;
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
              str = paramIntent.getExtras().getString("resultMobileMask");
              bool = paramIntent.getExtras().getBoolean("resultSetMobile");
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + str + " openSuccess=" + bool);
              }
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
              {
                this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
                {
                  paramIntent = getString(2131691976) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
                  this.jdField_c_of_type_AndroidWidgetTextView.setText(paramIntent);
                  this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131691937));
                  this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                  this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
                }
              }
            } while (!bool);
            asll.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), true);
            paramIntent = new Intent(this, AuthDevActivity.class);
            paramIntent.putExtra("phone_num", str);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            startActivity(paramIntent);
            QQToast.a(getApplicationContext(), 2, getString(2131691933), 0).b(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            }
            a(-1, paramIntent);
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
          asll.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null);
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile));
    paramIntent = getString(2131691976) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramIntent);
    this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131691937));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onBackEvent.cancelVerifyCode mVerifyObserver.seq=");
        if (this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver == null) {
          break label95;
        }
      }
      label95:
      for (int i = this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.getSeq();; i = 0)
      {
        QLog.d("Q.devlock.AuthDevUgActivity", 2, i);
        setResult(0);
        asll.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = null;
        finish();
        overridePendingTransition(0, 2130772001);
        return false;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", false);
    String str = "";
    Object localObject = str;
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
    {
      localObject = str;
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile != null) {
        localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
      }
    }
    localIntent.putExtra("phone_num", (String)localObject);
    a(0, localIntent);
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364440: 
        bdla.a(this.app, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA34", "0X800AA34", jdField_a_of_type_Int, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.sendWirelessMeibaoReq(1);
        if (mAppForground)
        {
          if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals("subaccount")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "subaccount enter webview mUin=" + this.jdField_a_of_type_JavaLangString + " mMainAccount=" + this.jdField_c_of_type_JavaLangString);
            }
            if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
            }
            aslh.a(this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, aslh.jdField_a_of_type_Int);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "mainaccount enter webview mUin=" + this.jdField_a_of_type_JavaLangString);
            }
            if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
              QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
            }
            aslh.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, aslh.jdField_a_of_type_Int);
          }
        }
        else {
          aslh.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, aslh.jdField_a_of_type_Int);
        }
        break;
      case 2131380402: 
        if (this.jdField_a_of_type_Boolean)
        {
          bdla.a(this.app, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA35", "0X800AA35", jdField_a_of_type_Int, 0, "", "", "", "");
          if (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)) {
            d();
          } else {
            e();
          }
        }
        else if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
        {
          bdla.b(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
          localObject = new Intent(this, AuthDevVerifyCodeActivity.class);
          ((Intent)localObject).putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          ((Intent)localObject).putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          startActivityForResult((Intent)localObject, 1001);
        }
        else
        {
          aslh.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, aslh.jdField_a_of_type_Int, 1003, null);
        }
        break;
      case 2131369262: 
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("onClick.cancelVerifyCode mVerifyObserver.seq=");
          if (this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver == null) {
            break label659;
          }
        }
        for (int i = this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.getSeq();; i = 0)
        {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, i);
          bdla.a(this.app, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA37", "0X800AA37", jdField_a_of_type_Int, 0, "", "", "", "");
          asll.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
          this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = null;
          finish();
          overridePendingTransition(0, 2130772001);
          break;
        }
      case 2131372330: 
        label659:
        if ((this.jdField_b_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 3000L))
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          bdla.a(this.app, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA36", "0X800AA36", jdField_a_of_type_Int, 0, "", "", "", "");
          d();
        }
        break;
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