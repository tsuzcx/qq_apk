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
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RegisterWithNick jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick = null;
  private RegisterLHAssistant jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant = null;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void a()
  {
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.inviteCode = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    this.mIsPhoneNumRegistered = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_register_from_send_sms", false);
    setTitleText(HardCodeUtil.a(2131713312));
    setBackListener();
    setBarProgress(80);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364008));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131372292));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(new RegisterPersonalInfoActivity.1(this));
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant = new RegisterLHAssistant(this, findViewById(2131370058), 2);
  }
  
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
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText == null) {
      return false;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((TextUtils.isEmpty(str)) || (str.trim().length() == 0))
    {
      notifyToast(2131716928, 1);
      return false;
    }
    return true;
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
    if ((paramInt1 == 2) && (paramInt2 == -1) && (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant != null) && (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount != null)) {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562022);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    a();
    ReportController.b(this.mRuntime, "CliOper", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    if (!this.mIsPhoneNumRegistered)
    {
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007362", "0X8007362", 1, 0, "", "", "", "");
      if (this.jdField_a_of_type_Boolean) {
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007362", "0X8007362", 3, 0, "", "", "", "");
      }
      if (this.mFrom != 4) {
        break label233;
      }
      ReportController.a(this.mRuntime, "new_reg", "setting_page_no", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007362", "0X8007362", 2, 0, "", "", "", "");
      break;
      label233:
      if (this.mFrom == 5) {
        ReportController.a(this.mRuntime, "new_reg", "setting_page_no", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
      } else if (this.mFrom == 6) {
        ReportController.a(this.mRuntime, "new_reg", "setting_page_no", "page_exp", "", 1, "", "3", "", "", "", "", "", "", "");
      } else {
        ReportController.a(this.mRuntime, "new_reg", "setting_page_no", "page_exp", "", 1, "", "4", "", "", "", "", "", "", "");
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    super.setIntent(paramIntent);
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a("RegisterPersonalInfoActivity -- doOnNewIntent", getIntent());
    }
    a();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131364008) {
      if ((this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant != null) && (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant.a(true);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        notifyToast(2131692257, 0);
      }
      else if (a())
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
        if (this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick == null) {
          this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick = new RegisterWithNick(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqRegisterRegisterWithNick.a(str);
        ReportController.a(this.mRuntime, "new_reg", "setting_page_no", "reg_clk", "", 1, "");
        continue;
        if (i == 2131369487)
        {
          InputMethodUtil.a(this);
          new Handler().postDelayed(new RegisterPersonalInfoActivity.2(this), 200L);
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
  
  public void onDestroy()
  {
    super.onDestroy();
    closeDialog();
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPersonalInfoActivity
 * JD-Core Version:    0.7.0.1
 */