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
  DevlockInfo a = null;
  QQProgressDialog b;
  Handler c = new DevlockPushActivity.1(this);
  private Button d;
  private String e;
  private String f;
  private String g;
  private boolean h = false;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private ArrayList<String> p = new ArrayList();
  private WtloginObserver q = new DevlockPushActivity.2(this);
  
  private void c()
  {
    this.leftView.setVisibility(4);
    if (this.h)
    {
      setRightButton(2131887648, this);
      if (AppSetting.e) {
        this.rightViewText.setContentDescription(getString(2131887648));
      }
    }
    TextView localTextView = (TextView)findViewById(2131434517);
    if (TextUtils.isEmpty(this.i)) {
      localTextView.setVisibility(8);
    } else {
      localTextView.setText(this.i);
    }
    this.d.setText(getString(2131888982));
    this.d.setContentDescription(getString(2131888951));
    EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 1);
  }
  
  private void d()
  {
    this.c.post(new DevlockPushActivity.3(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    Object localObject = this.app.getCurrentAccountUin();
    int i1 = EquipmentLockImpl.a().a(this.app, (String)localObject, this.q);
    if (i1 != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startGetDevLockStatus.CheckDevLockStatus fail ret=");
        ((StringBuilder)localObject).append(i1);
        QLog.d("Q.devlock.DevlockPushActivity", 2, ((StringBuilder)localObject).toString());
      }
      localObject = getString(2131888980);
      QQToast.makeText(getApplicationContext(), (CharSequence)localObject, 0).show(getTitleBarHeight());
      return;
    }
    d();
  }
  
  void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      EquipmentLockImpl.a().a(paramDevlockInfo.MbGuideInfo);
    }
    int i1;
    if ((paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
    } else {
      EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
    }
    paramDevlockInfo = this.a;
    if (paramDevlockInfo == null) {
      return;
    }
    if (paramDevlockInfo.DevSetup == 1)
    {
      paramDevlockInfo = new Intent();
      paramDevlockInfo.putExtra("phone_num", this.a.Mobile);
      paramDevlockInfo.putExtra("country_code", this.a.CountryCode);
      paramDevlockInfo.putExtra("auth_dev_open", true);
      RouteUtils.a(this, paramDevlockInfo, "/base/safe/authDevActivity");
      finish();
      overridePendingTransition(0, 0);
      return;
    }
    Object localObject = DevlockPhoneStatus.a();
    if ((localObject != null) && (((DevlockPhoneStatus)localObject).b() == DevlockPhoneStatus.d))
    {
      paramDevlockInfo = this.a;
      if (paramDevlockInfo != null) {
        paramDevlockInfo = paramDevlockInfo.Mobile;
      } else {
        paramDevlockInfo = "";
      }
      ((DevlockPhoneStatus)localObject).a(this, paramDevlockInfo);
      return;
    }
    paramDevlockInfo = this.a;
    if ((paramDevlockInfo != null) && (paramDevlockInfo.AllowSet == 1))
    {
      paramDevlockInfo = new Intent();
      localObject = this.a;
      if (localObject != null)
      {
        paramDevlockInfo.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
        paramDevlockInfo.putExtra("country_code", this.a.CountryCode);
      }
      paramDevlockInfo.putExtra("auth_dev_open", false);
      paramDevlockInfo.putExtra("allow_set", true);
      RouteUtils.a(this, paramDevlockInfo, "/base/safe/authDevActivity");
      finish();
      return;
    }
    paramDevlockInfo = this.a;
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.Mobile)))
    {
      paramDevlockInfo = new Intent(this, AuthDevConfirmPhoneNoActivity.class);
      paramDevlockInfo.putExtra("ParaTextUp", this.n);
      paramDevlockInfo.putExtra("ParaTextDown", this.o);
      paramDevlockInfo.putExtra("PhoneNO", this.a.Mobile);
      paramDevlockInfo.putExtra("mainaccount", this.g);
      paramDevlockInfo.putExtra("uin", this.e);
      paramDevlockInfo.putExtra("from_where", this.f);
      paramDevlockInfo.putExtra("DevlockInfo", this.a);
      startActivityForResult(paramDevlockInfo, 1001);
      overridePendingTransition(0, 2130772014);
      return;
    }
    EquipLockWebEntrance.a(this, this.app, EquipLockWebEntrance.c, 1003, null);
  }
  
  void b()
  {
    this.c.post(new DevlockPushActivity.4(this));
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
        if (EquipmentLockImpl.a().f())
        {
          paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
          localObject = this.a;
          if (localObject != null)
          {
            paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
            paramIntent.putExtra("country_code", this.a.CountryCode);
          }
          startActivity(paramIntent);
        }
        else
        {
          paramIntent = new Intent();
          localObject = this.a;
          if (localObject != null)
          {
            paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
            paramIntent.putExtra("country_code", this.a.CountryCode);
          }
          paramIntent.putExtra("auth_dev_open", true);
          RouteUtils.a(this, paramIntent, "/base/safe/authDevActivity");
        }
        paramIntent = new Intent();
        paramIntent.putExtra("allow_set", true);
        localObject = this.a;
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
            paramIntent = this.a;
            if (paramIntent != null) {
              paramIntent.Mobile = ((String)localObject);
            }
            if (!bool) {
              return;
            }
            EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
            bool = EquipmentLockImpl.a().f();
            paramIntent = new Intent();
            localObject = this.a;
            if (localObject != null)
            {
              paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
              paramIntent.putExtra("country_code", this.a.CountryCode);
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
            QQToast.makeText(getApplicationContext(), 2, getString(2131888947), 0).show(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            localObject = this.a;
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
          localObject = this.a;
          if (localObject != null) {
            ((DevlockInfo)localObject).Mobile = paramIntent;
          }
        }
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.h)
    {
      finish();
      overridePendingTransition(0, 2130772018);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 == 2131436211) || (i1 == 2131449023)) {}
    try
    {
      EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 3);
      DevlockInfo localDevlockInfo = this.a;
      if (localDevlockInfo == null)
      {
        if (!NetworkUtil.isNetSupport(this)) {
          QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
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
        overridePendingTransition(0, 2130772018);
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
    setTheme(2131953054);
    super.onCreate(paramBundle);
    super.setContentView(2131627393);
    setTitle(2131888985);
    if (this.app == null)
    {
      finish();
      return;
    }
    this.app.setDevLockIntent(null);
    this.d = ((Button)findViewById(2131449023));
    this.d.setOnClickListener(this);
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
    EquipmentLockImpl.a().b("Push");
    this.a = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    if (this.a != null) {
      DevlockPhoneStatus.a().a(this.a.TransferInfo);
    }
    this.e = ((Bundle)localObject).getString("uin");
    this.f = ((Bundle)localObject).getString("from_where");
    this.g = ((Bundle)localObject).getString("mainaccount");
    paramBundle = getIntent().getExtras();
    int i1 = 0;
    this.h = paramBundle.getBoolean("canCancel", false);
    this.i = getIntent().getExtras().getString("title");
    this.j = getIntent().getExtras().getString("secondTitle");
    this.k = getIntent().getExtras().getString("thirdTitle");
    this.p = getIntent().getExtras().getStringArrayList("wordsList");
    paramBundle = this.p;
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      while (i1 < this.p.size())
      {
        paramBundle = (String)this.p.get(i1);
        if (i1 == 0) {
          this.l = paramBundle;
        } else if (i1 == 1) {
          this.m = paramBundle;
        } else if (i1 == 2) {
          this.n = paramBundle;
        } else if (i1 == 3) {
          this.o = paramBundle;
        }
        i1 += 1;
      }
    }
    if (TextUtils.isEmpty(this.i)) {
      this.i = getString(2131888981);
    }
    if (TextUtils.isEmpty(this.j)) {
      this.j = getString(2131888982);
    }
    if (TextUtils.isEmpty(this.l)) {
      this.l = getString(2131888964);
    }
    if (TextUtils.isEmpty(this.m)) {
      this.m = getString(2131888965);
    }
    if (TextUtils.isEmpty(this.n)) {
      this.n = getString(2131888961);
    }
    if (TextUtils.isEmpty(this.o)) {
      this.o = getString(2131888962);
    }
    if (TextUtils.isEmpty(this.k)) {
      this.k = getString(2131888966);
    }
    c();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity
 * JD-Core Version:    0.7.0.1
 */