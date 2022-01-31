package com.tencent.mobileqq.activity;

import acou;
import acov;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import apwo;
import apwq;
import apwu;
import bdee;
import bepp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class DevlockPushActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new acou(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  public bepp a;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new acov(this);
  public DevlockInfo a;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  
  public DevlockPushActivity()
  {
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  }
  
  private void c()
  {
    this.leftView.setVisibility(4);
    if (this.jdField_a_of_type_Boolean)
    {
      setRightButton(2131690648, this);
      if (AppSetting.c) {
        this.rightViewText.setContentDescription(getString(2131690648));
      }
    }
    TextView localTextView = (TextView)findViewById(2131367412);
    if (TextUtils.isEmpty(this.d)) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131692208));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131692166));
      apwu.a().a(null, this.app.getCurrentAccountUin(), 1);
      return;
      localTextView.setText(this.d);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new DevlockPushActivity.3(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    String str = this.app.getCurrentAccountUin();
    int k = apwu.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (k != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus.CheckDevLockStatus fail ret=" + k);
      }
      str = getString(2131692203);
      QQToast.a(getApplicationContext(), str, 0).b(getTitleBarHeight());
      return;
    }
    d();
  }
  
  public void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      apwu.a().a(paramDevlockInfo.MbGuideInfo);
    }
    int k;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        k = 1;
      }
    }
    for (;;)
    {
      if (k != 0) {
        apwu.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          break label99;
        }
        return;
        k = 0;
        break;
        apwu.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
      }
      label99:
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
      {
        paramDevlockInfo = new Intent(this, AuthDevActivity.class);
        paramDevlockInfo.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramDevlockInfo.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        paramDevlockInfo.putExtra("auth_dev_open", true);
        startActivity(paramDevlockInfo);
        finish();
        overridePendingTransition(0, 0);
        return;
      }
      apwo localapwo = apwo.a();
      if ((localapwo != null) && (localapwo.a() == apwo.c))
      {
        paramDevlockInfo = "";
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          paramDevlockInfo = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
        }
        localapwo.a(this, paramDevlockInfo);
        return;
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1))
      {
        paramDevlockInfo = new Intent(this, AuthDevActivity.class);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramDevlockInfo.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramDevlockInfo.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramDevlockInfo.putExtra("auth_dev_open", false);
        paramDevlockInfo.putExtra("allow_set", true);
        startActivity(paramDevlockInfo);
        finish();
        return;
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
      {
        paramDevlockInfo = new Intent(this, AuthDevConfirmPhoneNoActivity.class);
        paramDevlockInfo.putExtra("ParaTextUp", this.i);
        paramDevlockInfo.putExtra("ParaTextDown", this.j);
        paramDevlockInfo.putExtra("PhoneNO", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramDevlockInfo.putExtra("mainaccount", this.c);
        paramDevlockInfo.putExtra("uin", this.jdField_a_of_type_JavaLangString);
        paramDevlockInfo.putExtra("from_where", this.b);
        paramDevlockInfo.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult(paramDevlockInfo, 1001);
        overridePendingTransition(0, 2130771997);
        return;
      }
      apwq.a(this, this.app, apwq.c, 1003, null);
      return;
      k = 0;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new DevlockPushActivity.4(this));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        if ((paramIntent == null) || (paramIntent.getExtras().getInt("requestCode") != 1002)) {
          break label50;
        }
        setResult(-1, null);
        finish();
      }
    }
    label50:
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
              do
              {
                do
                {
                  do
                  {
                    return;
                    apwo.a().a(apwo.d);
                    if (apwu.a().a())
                    {
                      paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
                      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                      {
                        paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                        paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                      }
                      startActivity(paramIntent);
                    }
                    for (;;)
                    {
                      paramIntent = new Intent();
                      paramIntent.putExtra("allow_set", true);
                      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                        paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                      }
                      setResult(-1, paramIntent);
                      finish();
                      return;
                      paramIntent = new Intent(this, AuthDevActivity.class);
                      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                      {
                        paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                        paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                      }
                      paramIntent.putExtra("auth_dev_open", true);
                      startActivity(paramIntent);
                    }
                    if (paramInt1 != 1002) {
                      break;
                    }
                  } while (paramInt2 != -1);
                  finish();
                  return;
                } while (paramInt1 != 1003);
                if (paramInt2 != -1) {
                  break;
                }
              } while ((paramIntent == null) || (paramIntent.getExtras() == null));
              paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
              }
            } while (paramInt1 != 2);
            String str = paramIntent.getExtras().getString("resultMobileMask");
            bool = paramIntent.getExtras().getBoolean("resultSetMobile");
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + str + " openSuccess=" + bool);
            }
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
            }
          } while (!bool);
          apwu.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
          boolean bool = apwu.a().a();
          paramIntent = new Intent();
          if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
          {
            paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          }
          if (bool) {
            paramIntent.setClass(this, AuthDevEnableCompleteActivity.class);
          }
          for (;;)
          {
            startActivity(paramIntent);
            QQToast.a(getApplicationContext(), 2, getString(2131692160), 0).b(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            }
            setResult(-1, paramIntent);
            finish();
            return;
            paramIntent.setClass(this, AuthDevActivity.class);
            paramIntent.putExtra("auth_dev_open", true);
          }
        } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
        paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
        }
      } while (paramInt1 != 2);
      paramIntent = paramIntent.getExtras().getString("resultMobileMask");
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
      }
      if (!TextUtils.isEmpty(paramIntent)) {
        apwu.a().a(this.app, this.app.getCurrentAccountUin(), null);
      }
    } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      finish();
      overridePendingTransition(0, 2130772001);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    try
    {
      apwu.a().a(null, this.app.getCurrentAccountUin(), 3);
      label48:
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        if (!bdee.d(this))
        {
          QQToast.a(this, getString(2131692397), 0).b(getTitleBarHeight());
          return;
        }
        a();
        return;
      }
      a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      return;
      try
      {
        apwu.a().a(null, this.app.getCurrentAccountUin(), 2);
        label112:
        finish();
        overridePendingTransition(0, 2130772001);
        return;
      }
      catch (Exception paramView)
      {
        break label112;
      }
    }
    catch (Exception paramView)
    {
      break label48;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int k = 0;
    setTheme(2131755553);
    super.onCreate(paramBundle);
    super.setContentView(2131560907);
    setTitle(2131692212);
    if (this.app == null)
    {
      finish();
      return;
    }
    this.app.setDevLockIntent(null);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131379173));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    Object localObject = getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    apwu.a().a(true);
    apwu.a().a("Push");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
      apwo.a().a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TransferInfo);
    }
    this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("uin");
    this.b = ((Bundle)localObject).getString("from_where");
    this.c = ((Bundle)localObject).getString("mainaccount");
    this.jdField_a_of_type_Boolean = getIntent().getExtras().getBoolean("canCancel", false);
    this.d = getIntent().getExtras().getString("title");
    this.e = getIntent().getExtras().getString("secondTitle");
    this.f = getIntent().getExtras().getString("thirdTitle");
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getExtras().getStringArrayList("wordsList");
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      if (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramBundle = (String)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (k == 0) {
          this.g = paramBundle;
        }
        for (;;)
        {
          k += 1;
          break;
          if (k == 1) {
            this.h = paramBundle;
          } else if (k == 2) {
            this.i = paramBundle;
          } else if (k == 3) {
            this.j = paramBundle;
          }
        }
      }
    }
    if (TextUtils.isEmpty(this.d)) {
      this.d = getString(2131692207);
    }
    if (TextUtils.isEmpty(this.e)) {
      this.e = getString(2131692208);
    }
    if (TextUtils.isEmpty(this.g)) {
      this.g = getString(2131692184);
    }
    if (TextUtils.isEmpty(this.h)) {
      this.h = getString(2131692185);
    }
    if (TextUtils.isEmpty(this.i)) {
      this.i = getString(2131692181);
    }
    if (TextUtils.isEmpty(this.j)) {
      this.j = getString(2131692182);
    }
    if (TextUtils.isEmpty(this.f)) {
      this.f = getString(2131692187);
    }
    c();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity
 * JD-Core Version:    0.7.0.1
 */