package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.register.QueryAccount;
import com.tencent.mobileqq.register.RegisterWithNick;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import mqq.app.AppRuntime;

public class RegisterPersonalInfoActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private ClearableEditText a;
  private Button b;
  private boolean c = false;
  private RegisterWithNick d = null;
  private RegisterLHAssistant e = null;
  
  public static void a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, int paramInt)
  {
    paramAppRuntime = new Intent(paramContext, RegisterPersonalInfoActivity.class);
    paramAppRuntime.putExtra("phonenum", paramString1);
    paramAppRuntime.putExtra("invite_code", paramString4);
    paramAppRuntime.putExtra("key", paramString2);
    paramAppRuntime.putExtra("key_register_smscode", paramString3);
    paramAppRuntime.putExtra("key_register_is_phone_num_registered", paramBoolean1);
    paramAppRuntime.putExtra("key_register_from", paramInt);
    if ((paramContext instanceof RegisterSendUpSms)) {
      paramAppRuntime.putExtra("key_register_from_send_sms", true);
    }
    paramContext.startActivity(paramAppRuntime);
  }
  
  private void b()
  {
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.inviteCode = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    this.mIsPhoneNumRegistered = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.c = getIntent().getBooleanExtra("key_register_from_send_sms", false);
    setTitleText(HardCodeUtil.a(2131910833));
    setBackListener();
    setBarProgress(80);
    this.b = ((Button)findViewById(2131429891));
    this.b.setOnClickListener(this);
    this.a = ((ClearableEditText)findViewById(2131439323));
    this.a.addTextChangedListener(new RegisterPersonalInfoActivity.1(this));
    RegisterLHAssistant localRegisterLHAssistant = this.e;
    if (localRegisterLHAssistant != null)
    {
      localRegisterLHAssistant.a();
      return;
    }
    this.e = new RegisterLHAssistant(this, findViewById(2131436855), 2);
  }
  
  public boolean a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = ((ClearableEditText)localObject).getText().toString();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).trim().length() != 0)) {
      return true;
    }
    notifyToast(2131914044, 1);
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      RegisterLHAssistant localRegisterLHAssistant = this.e;
      if ((localRegisterLHAssistant != null) && (localRegisterLHAssistant.e != null)) {
        this.e.e.a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131628273);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    b();
    ReportController.b(this.mRuntime, "CliOper", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    if (!this.mIsPhoneNumRegistered) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007362", "0X8007362", 1, 0, "", "", "", "");
    } else {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007362", "0X8007362", 2, 0, "", "", "", "");
    }
    if (this.c) {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007362", "0X8007362", 3, 0, "", "", "", "");
    }
    if (this.mFrom == 4) {
      ReportController.a(this.mRuntime, "new_reg", "setting_page_no", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    } else if (this.mFrom == 5) {
      ReportController.a(this.mRuntime, "new_reg", "setting_page_no", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    } else if (this.mFrom == 6) {
      ReportController.a(this.mRuntime, "new_reg", "setting_page_no", "page_exp", "", 1, "", "3", "", "", "", "", "", "", "");
    } else {
      ReportController.a(this.mRuntime, "new_reg", "setting_page_no", "page_exp", "", 1, "", "4", "", "", "", "", "", "", "");
    }
    return true;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    super.setIntent(paramIntent);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a("RegisterPersonalInfoActivity -- doOnNewIntent", getIntent());
    }
    b();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131429891)
    {
      Object localObject = this.e;
      if ((localObject != null) && (((RegisterLHAssistant)localObject).c))
      {
        this.e.a(true);
      }
      else if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        notifyToast(2131889169, 0);
      }
      else if (a())
      {
        localObject = this.a.getText().toString();
        if (this.d == null) {
          this.d = new RegisterWithNick(this);
        }
        this.d.a((String)localObject);
        ReportController.a(this.mRuntime, "new_reg", "setting_page_no", "reg_clk", "", 1, "");
      }
    }
    else if (i == 2131436180)
    {
      InputMethodUtil.a(this);
      new Handler().postDelayed(new RegisterPersonalInfoActivity.2(this), 200L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    closeDialog();
    RegisterLHAssistant localRegisterLHAssistant = this.e;
    if (localRegisterLHAssistant != null) {
      localRegisterLHAssistant.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPersonalInfoActivity
 * JD-Core Version:    0.7.0.1
 */