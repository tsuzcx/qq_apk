package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevConfirmPhoneNoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private String a = null;
  private String b = null;
  private String c = null;
  private TextView d = null;
  private TextView e = null;
  private TextView f = null;
  private Button g = null;
  private Button h = null;
  private String i;
  private String j;
  private String k;
  private DevlockInfo l = null;
  
  private void a()
  {
    super.setContentView(2131627392);
    setTitle(2131888985);
    this.d = ((TextView)findViewById(2131447148));
    this.e = ((TextView)findViewById(2131447147));
    this.f = ((TextView)findViewById(2131447195));
    this.g = ((Button)findViewById(2131429847));
    this.h = ((Button)findViewById(2131429930));
    if ((QLog.isColorLevel()) && ((this.d == null) || (this.e == null) || (this.f == null) || (this.g == null) || (this.h == null)))
    {
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "one or more controls is null! ");
      return;
    }
    onCreateRightView();
    setRightButton(2131888963, this);
    Object localObject = (TextView)findViewById(2131436180);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.a;
    if (localObject != null) {
      this.d.setText((CharSequence)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      this.e.setText((CharSequence)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      this.f.setText((CharSequence)localObject);
    }
    localObject = getString(2131888960);
    String str = getString(2131888987);
    this.g.setText((CharSequence)localObject);
    this.g.setClickable(true);
    this.g.setOnClickListener(this);
    this.h.setText(str);
    this.h.setClickable(true);
    this.h.setOnClickListener(this);
    try
    {
      EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 6);
      return;
    }
    catch (Exception localException) {}
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt1 != 1001)
    {
      if (paramInt1 != 1002) {
        return;
      }
      if (paramIntent != null)
      {
        localObject = paramIntent.getExtras();
        if (localObject == null) {
          return;
        }
        paramInt2 = ((Bundle)localObject).getInt("resultState", 1);
        localObject = ((Bundle)localObject).getString("resultMobileMask");
        if (paramInt2 != 1)
        {
          if (paramInt2 == 2)
          {
            DevlockPhoneStatus.a().a(DevlockPhoneStatus.e);
          }
          else if (paramInt2 == 3)
          {
            DevlockPhoneStatus.a().a(DevlockPhoneStatus.d);
            DevlockPhoneStatus.a().a(0L);
          }
          paramIntent = new Intent(paramIntent);
          paramIntent.putExtra("requestCode", paramInt1);
          paramIntent.putExtra("phone_num", (String)localObject);
          setResult(-1, paramIntent);
          finish();
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("verify page call back resultCode = ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          paramIntent = new Intent(paramIntent);
        } else {
          paramIntent = new Intent();
        }
        paramIntent.putExtra("requestCode", paramInt1);
        setResult(-1, paramIntent);
        finish();
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130772018);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m != 2131429847)
    {
      if (m != 2131429930)
      {
        if (m != 2131436211) {
          break label401;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "onClick right cancel button! ");
        }
        finish();
        overridePendingTransition(0, 2130772018);
        break label401;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click modify mobile phone button! ");
      }
    }
    try
    {
      EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 8);
      if (this.app != null) {
        this.app.sendWirelessMeibaoReq(1);
      }
      if ((!TextUtils.isEmpty(this.j)) && (this.j.equals("subaccount")))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("subaccount enter webview mUin=");
          ((StringBuilder)localObject).append(this.i);
          ((StringBuilder)localObject).append(" mMainAccount=");
          ((StringBuilder)localObject).append(this.k);
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, ((StringBuilder)localObject).toString());
        }
        if ((TextUtils.isEmpty(this.i)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
        }
        EquipLockWebEntrance.a(this, this.k, this.i, EquipLockWebEntrance.c, 1002, null);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mainaccount enter webview mUin=");
          ((StringBuilder)localObject).append(this.i);
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, ((StringBuilder)localObject).toString());
        }
        if ((TextUtils.isEmpty(this.i)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
        }
        localObject = this.i;
        EquipLockWebEntrance.a(this, (String)localObject, (String)localObject, EquipLockWebEntrance.c, 1002, null);
        break label401;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click confirm mobile phone button! ");
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 7);
        label344:
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("phone_num", this.l.Mobile);
        ((Intent)localObject).putExtra("country_code", this.l.CountryCode);
        ((Intent)localObject).putExtra("mobile_type", 0);
        RouteUtils.a(this, (Intent)localObject, "/base/login/authDevVerifyCode", 1001);
        label401:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label344;
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
    this.a = ((Bundle)localObject).getString("ParaTextUp");
    this.b = ((Bundle)localObject).getString("ParaTextDown");
    this.c = ((Bundle)localObject).getString("PhoneNO");
    this.i = ((Bundle)localObject).getString("uin");
    this.j = ((Bundle)localObject).getString("from_where");
    this.k = ((Bundle)localObject).getString("mainaccount");
    this.l = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("on Create strParaGraphUp : ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("on Create strParaGraphDown : ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, ((StringBuilder)localObject).toString());
    }
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevConfirmPhoneNoActivity
 * JD-Core Version:    0.7.0.1
 */