package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class DevlockPushActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new DevlockPushActivity.1(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new DevlockPushActivity.2(this);
  DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private boolean jdField_a_of_type_Boolean = false;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  
  private void c()
  {
    this.leftView.setVisibility(4);
    if (this.jdField_a_of_type_Boolean)
    {
      setRightButton(2131690728, this);
      if (AppSetting.d) {
        this.rightViewText.setContentDescription(getString(2131690728));
      }
    }
    TextView localTextView = (TextView)findViewById(2131367929);
    if (TextUtils.isEmpty(this.d)) {
      localTextView.setVisibility(8);
    } else {
      localTextView.setText(this.d);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131692015));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131691984));
    EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 1);
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
    Object localObject = this.app.getCurrentAccountUin();
    int k = EquipmentLockImpl.a().a(this.app, (String)localObject, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (k != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startGetDevLockStatus.CheckDevLockStatus fail ret=");
        ((StringBuilder)localObject).append(k);
        QLog.d("Q.devlock.DevlockPushActivity", 2, ((StringBuilder)localObject).toString());
      }
      localObject = getString(2131692013);
      QQToast.a(getApplicationContext(), (CharSequence)localObject, 0).b(getTitleBarHeight());
      return;
    }
    d();
  }
  
  void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      EquipmentLockImpl.a().a(paramDevlockInfo.MbGuideInfo);
    }
    int k;
    if ((paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 1)) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0) {
      EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
    } else {
      EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
    }
    paramDevlockInfo = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
    if (paramDevlockInfo == null) {
      return;
    }
    if (paramDevlockInfo.DevSetup == 1)
    {
      paramDevlockInfo = new Intent();
      paramDevlockInfo.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
      paramDevlockInfo.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      paramDevlockInfo.putExtra("auth_dev_open", true);
      RouteUtils.a(this, paramDevlockInfo, "/base/safe/authDevActivity");
      finish();
      overridePendingTransition(0, 0);
      return;
    }
    Object localObject = DevlockPhoneStatus.a();
    if ((localObject != null) && (((DevlockPhoneStatus)localObject).a() == DevlockPhoneStatus.d))
    {
      paramDevlockInfo = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
      if (paramDevlockInfo != null) {
        paramDevlockInfo = paramDevlockInfo.Mobile;
      } else {
        paramDevlockInfo = "";
      }
      ((DevlockPhoneStatus)localObject).a(this, paramDevlockInfo);
      return;
    }
    paramDevlockInfo = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
    if ((paramDevlockInfo != null) && (paramDevlockInfo.AllowSet == 1))
    {
      paramDevlockInfo = new Intent();
      localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
      if (localObject != null)
      {
        paramDevlockInfo.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
        paramDevlockInfo.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      }
      paramDevlockInfo.putExtra("auth_dev_open", false);
      paramDevlockInfo.putExtra("allow_set", true);
      RouteUtils.a(this, paramDevlockInfo, "/base/safe/authDevActivity");
      finish();
      return;
    }
    paramDevlockInfo = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.Mobile)))
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
      overridePendingTransition(0, 2130772011);
      return;
    }
    EquipLockWebEntrance.a(this, this.app, EquipLockWebEntrance.c, 1003, null);
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new DevlockPushActivity.4(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt1 == 1001)
    {
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.getExtras().getInt("requestCode") == 1002))
        {
          setResult(-1, null);
          finish();
          return;
        }
        DevlockPhoneStatus.a().a(DevlockPhoneStatus.e);
        if (EquipmentLockImpl.a().a())
        {
          paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
          localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
          if (localObject != null)
          {
            paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
            paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          }
          startActivity(paramIntent);
        }
        else
        {
          paramIntent = new Intent();
          localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
          if (localObject != null)
          {
            paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
            paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          }
          paramIntent.putExtra("auth_dev_open", true);
          RouteUtils.a(this, paramIntent, "/base/safe/authDevActivity");
        }
        paramIntent = new Intent();
        paramIntent.putExtra("allow_set", true);
        localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
        if (localObject != null) {
          paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
        }
        setResult(-1, paramIntent);
        finish();
      }
    }
    else if (paramInt1 == 1002)
    {
      if (paramInt2 == -1) {
        finish();
      }
    }
    else if (paramInt1 == 1003) {
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
            QLog.d("Q.devlock.DevlockPushActivity", 2, ((StringBuilder)localObject).toString());
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
              QLog.d("Q.devlock.DevlockPushActivity", 2, paramIntent.toString());
            }
            paramIntent = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
            if (paramIntent != null) {
              paramIntent.Mobile = ((String)localObject);
            }
            if (!bool) {
              return;
            }
            EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
            bool = EquipmentLockImpl.a().a();
            paramIntent = new Intent();
            localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
            if (localObject != null)
            {
              paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            if (bool)
            {
              paramIntent.setClass(this, AuthDevEnableCompleteActivity.class);
              startActivity(paramIntent);
            }
            else
            {
              paramIntent.putExtra("auth_dev_open", true);
              RouteUtils.a(this, paramIntent, "/base/safe/authDevActivity");
            }
            QQToast.a(getApplicationContext(), 2, getString(2131691980), 0).b(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
            if (localObject != null) {
              paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
            }
            setResult(-1, paramIntent);
            finish();
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
          QLog.d("Q.devlock.DevlockPushActivity", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt1 == 2)
        {
          paramIntent = paramIntent.getExtras().getString("resultMobileMask");
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =");
            ((StringBuilder)localObject).append(paramIntent);
            QLog.d("Q.devlock.DevlockPushActivity", 2, ((StringBuilder)localObject).toString());
          }
          if (!TextUtils.isEmpty(paramIntent)) {
            EquipmentLockImpl.a().a(this.app, this.app.getCurrentAccountUin(), null);
          }
          localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
          if (localObject != null) {
            ((DevlockInfo)localObject).Mobile = paramIntent;
          }
        }
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      finish();
      overridePendingTransition(0, 2130772015);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if ((k == 2131369233) || (k == 2131380109)) {}
    try
    {
      EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 3);
      DevlockInfo localDevlockInfo = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
      if (localDevlockInfo == null)
      {
        if (!NetworkUtil.isNetSupport(this)) {
          QQToast.a(this, getString(2131692183), 0).b(getTitleBarHeight());
        } else {
          a();
        }
      }
      else {
        a(localDevlockInfo);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 2);
        label106:
        finish();
        overridePendingTransition(0, 2130772015);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label106;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setTheme(2131755933);
    super.onCreate(paramBundle);
    super.setContentView(2131561051);
    setTitle(2131692018);
    if (this.app == null)
    {
      finish();
      return;
    }
    this.app.setDevLockIntent(null);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131380109));
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
    EquipmentLockImpl.a().a(true);
    EquipmentLockImpl.a().a("Push");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
      DevlockPhoneStatus.a().a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TransferInfo);
    }
    this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("uin");
    this.b = ((Bundle)localObject).getString("from_where");
    this.c = ((Bundle)localObject).getString("mainaccount");
    paramBundle = getIntent().getExtras();
    int k = 0;
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("canCancel", false);
    this.d = getIntent().getExtras().getString("title");
    this.e = getIntent().getExtras().getString("secondTitle");
    this.f = getIntent().getExtras().getString("thirdTitle");
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getExtras().getStringArrayList("wordsList");
    paramBundle = this.jdField_a_of_type_JavaUtilArrayList;
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramBundle = (String)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (k == 0) {
          this.g = paramBundle;
        } else if (k == 1) {
          this.h = paramBundle;
        } else if (k == 2) {
          this.i = paramBundle;
        } else if (k == 3) {
          this.j = paramBundle;
        }
        k += 1;
      }
    }
    if (TextUtils.isEmpty(this.d)) {
      this.d = getString(2131692014);
    }
    if (TextUtils.isEmpty(this.e)) {
      this.e = getString(2131692015);
    }
    if (TextUtils.isEmpty(this.g)) {
      this.g = getString(2131691997);
    }
    if (TextUtils.isEmpty(this.h)) {
      this.h = getString(2131691998);
    }
    if (TextUtils.isEmpty(this.i)) {
      this.i = getString(2131691994);
    }
    if (TextUtils.isEmpty(this.j)) {
      this.j = getString(2131691995);
    }
    if (TextUtils.isEmpty(this.f)) {
      this.f = getString(2131691999);
    }
    c();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity
 * JD-Core Version:    0.7.0.1
 */