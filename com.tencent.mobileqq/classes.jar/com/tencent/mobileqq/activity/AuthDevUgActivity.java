package com.tencent.mobileqq.activity;

import aabr;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import annw;
import anny;
import anoc;
import awqx;
import bbmy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevUgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new aabr(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private TextView d;
  
  private void a()
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
          str = getString(2131626561) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
          this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        }
        this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131626588));
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.BakMobileState == 2))
        {
          this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
          if (AppSetting.c) {
            this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131626540));
          }
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))) {
          break label303;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        if (this.d != null) {
          this.d.setVisibility(4);
        }
        label239:
        this.leftView.setVisibility(4);
        setRightButton(2131625035, this);
        if (AppSetting.c)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131626586));
          this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131626588));
        }
      }
    }
    label303:
    label504:
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131626587));
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label239;
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType != 2)) {
          break label504;
        }
        str = getString(2131626561) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131626512));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        if (!AppSetting.c) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131626586));
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131626512));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131626587));
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131626512));
    } while (!AppSetting.c);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131626586));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131626512));
  }
  
  private void b()
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
      finish();
      try
      {
        VasWebviewUtil.openQQBrowserActivity(this, "", 16384L, localIntent, false, -1);
        label199:
        awqx.a(this.app, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
        return;
      }
      catch (SecurityException localSecurityException)
      {
        break label199;
      }
      bool = false;
    }
  }
  
  private void c()
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
      localIntent.putExtra("seq", this.jdField_a_of_type_Int);
      startActivityForResult(localIntent, 1002);
      return;
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
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
        this.jdField_a_of_type_Int = paramBundle.getInt("seq");
        Object localObject = paramBundle.get("DevlockInfo");
        if ((localObject instanceof DevlockInfo)) {
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)localObject);
        }
        this.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
        this.jdField_b_of_type_JavaLangString = paramBundle.getString("from_where");
        this.jdField_c_of_type_JavaLangString = paramBundle.getString("mainaccount");
        if (QLog.isColorLevel())
        {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.jdField_a_of_type_Int + " mUin=" + this.jdField_a_of_type_JavaLangString + " mFromWhere=" + this.jdField_b_of_type_JavaLangString + " mMainAccount=" + this.jdField_c_of_type_JavaLangString);
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
          setTheme(2131690007);
        }
        super.setContentView(2131495159);
        if (this.jdField_a_of_type_Boolean)
        {
          super.setTitle(2131626556);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.app;
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
            this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
          }
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
            break;
          }
          super.finish();
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        finish();
        return true;
      }
      super.setTitle(2131626555);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(LoginActivity.class);
      if (paramBundle != null) {
        paramBundle.sendEmptyMessage(20140107);
      }
      paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(SubLoginActivity.class);
      if (paramBundle != null) {
        paramBundle.sendEmptyMessage(20140107);
      }
      paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(AddAccountActivity.class);
      if (paramBundle != null) {
        paramBundle.sendEmptyMessage(20140107);
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo))) {
        break label871;
      }
      anoc.a().a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131304082));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131310180));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131305747));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298471));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131312732));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299980));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.d = ((TextView)super.findViewById(2131305463));
      this.d.setOnClickListener(this);
      a();
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_a_of_type_Int);
      return true;
      label871:
      finish();
      overridePendingTransition(0, 0);
      bbmy.a(this, 1, getString(2131628385), 0).a();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
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
    label673:
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
                  localObject = getString(2131626561) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
                  this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                  this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131626512));
                  this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                  this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
                }
              }
            } while (!bool);
            anoc.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), true);
            Object localObject = new Intent(this, AuthDevActivity.class);
            ((Intent)localObject).putExtra("phone_num", str);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              ((Intent)localObject).putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            String str = paramIntent.getExtras().getString("emergency_phone_mask");
            if (!TextUtils.isEmpty(str))
            {
              paramInt1 = paramIntent.getExtras().getInt("emergency_phone_state");
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.AuthDevUgActivity", 2, "emergency phone:" + str + " state=" + paramInt1);
              }
              annw.a().a(str);
              paramIntent = annw.a();
              if (paramInt1 != 1) {
                break label673;
              }
            }
            for (paramInt1 = annw.e;; paramInt1 = annw.h)
            {
              paramIntent.b(paramInt1);
              ((Intent)localObject).putExtra("auth_dev_open", true);
              startActivity((Intent)localObject);
              bbmy.a(getApplicationContext(), 2, getString(2131626508), 0).b(getTitleBarHeight());
              paramIntent = new Intent();
              paramIntent.putExtra("auth_dev_open", true);
              paramIntent.putExtra("allow_set", true);
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              }
              a(-1, paramIntent);
              return;
            }
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
          anoc.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null);
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile));
    paramIntent = getString(2131626561) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramIntent);
    this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131626512));
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
        anoc.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
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
    label543:
    do
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131298471: 
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
            anny.a(this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, anny.jdField_a_of_type_Int);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "mainaccount enter webview mUin=" + this.jdField_a_of_type_JavaLangString);
          }
          if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
          }
          anny.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, anny.jdField_a_of_type_Int);
          return;
        }
        anny.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, anny.jdField_a_of_type_Int);
        return;
      case 2131312732: 
        if (this.jdField_a_of_type_Boolean)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
          {
            b();
            return;
          }
          c();
          return;
        }
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
        {
          awqx.b(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
          paramView = new Intent(this, AuthDevVerifyCodeActivity.class);
          paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          startActivityForResult(paramView, 1001);
          return;
        }
        anny.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, anny.jdField_a_of_type_Int, 1003, null);
        return;
      case 2131302832: 
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder().append("onClick.cancelVerifyCode mVerifyObserver.seq=");
          if (this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver == null) {
            break label543;
          }
        }
        for (int i = this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.getSeq();; i = 0)
        {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, i);
          anoc.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
          this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = null;
          finish();
          overridePendingTransition(0, 2130772001);
          return;
        }
      }
    } while (!this.jdField_a_of_type_Boolean);
    if ("com.tencent.mobileqq:openSdk".equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getQQProcessName())) {}
    for (paramView = new Intent(this, AuthDevVerifyCodeActivity2.class);; paramView = new Intent(this, AuthDevVerifyCodeActivity.class))
    {
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.BakMobileState == 2))
      {
        paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.BakMobile);
        paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.BakCountryCode);
        paramView.putExtra("mobile_type", 1);
      }
      paramView.putExtra("from_login", this.jdField_a_of_type_Boolean);
      paramView.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      paramView.putExtra("seq", this.jdField_a_of_type_Int);
      startActivityForResult(paramView, 1002);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevUgActivity
 * JD-Core Version:    0.7.0.1
 */