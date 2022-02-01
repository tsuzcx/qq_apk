package com.tencent.mobileqq.activity;

import Override;
import afkb;
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
import anzj;
import bbbc;
import bbbh;
import bdll;
import bhnv;
import bijm;
import blgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RegisterPersonalInfoActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private bbbh jdField_a_of_type_Bbbh;
  private bijm jdField_a_of_type_Bijm;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private boolean c;
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("invite_code");
    this.b = getIntent().getStringExtra("key");
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_register_from_send_sms", false);
    b(anzj.a(2131712237));
    b();
    a(80);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363809));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131371831));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(new afkb(this));
    if (this.jdField_a_of_type_Bijm != null)
    {
      this.jdField_a_of_type_Bijm.a();
      return;
    }
    this.jdField_a_of_type_Bijm = new bijm(this, findViewById(2131369630), 2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, int paramInt)
  {
    paramQQAppInterface = new Intent(paramContext, RegisterPersonalInfoActivity.class);
    paramQQAppInterface.putExtra("phonenum", paramString1);
    paramQQAppInterface.putExtra("invite_code", paramString4);
    paramQQAppInterface.putExtra("key", paramString2);
    paramQQAppInterface.putExtra("key_register_smscode", paramString3);
    paramQQAppInterface.putExtra("key_register_is_phone_num_registered", paramBoolean1);
    paramQQAppInterface.putExtra("key_register_from", paramInt);
    if ((paramContext instanceof RegisterSendUpSms)) {
      paramQQAppInterface.putExtra("key_register_from_send_sms", true);
    }
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText == null) {
      return false;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((TextUtils.isEmpty(str)) || (str.trim().length() == 0))
    {
      a(2131715852, 1);
      return false;
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1) && (this.jdField_a_of_type_Bijm != null) && (this.jdField_a_of_type_Bijm.jdField_a_of_type_Bbbc != null)) {
      this.jdField_a_of_type_Bijm.jdField_a_of_type_Bbbc.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561944);
    if (QLog.isDevelopLevel()) {
      bijm.a(getClass().getSimpleName(), getIntent());
    }
    a();
    bdll.b(this.app, "CliOper", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    bdll.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    if (!this.jdField_a_of_type_Boolean)
    {
      bdll.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 1, 0, "", "", "", "");
      if (this.jdField_c_of_type_Boolean) {
        bdll.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 3, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Int != 4) {
        break label232;
      }
      bdll.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      bdll.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 2, 0, "", "", "", "");
      break;
      label232:
      if (this.jdField_a_of_type_Int == 5) {
        bdll.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
      } else if (this.jdField_a_of_type_Int == 6) {
        bdll.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "3", "", "", "", "", "", "", "");
      } else {
        bdll.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "4", "", "", "", "", "", "", "");
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    super.setIntent(paramIntent);
    if (QLog.isDevelopLevel()) {
      bijm.a("RegisterPersonalInfoActivity -- doOnNewIntent", getIntent());
    }
    a();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Bijm != null) && (this.jdField_a_of_type_Bijm.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Bijm.a(true);
      }
      else if (!bhnv.d(BaseApplication.getContext()))
      {
        a(2131691989, 0);
      }
      else if (a())
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
        if (this.jdField_a_of_type_Bbbh == null) {
          this.jdField_a_of_type_Bbbh = new bbbh(this);
        }
        this.jdField_a_of_type_Bbbh.a(str);
        bdll.a(this.app, "new_reg", "setting_page_no", "reg_clk", "", 1, "");
        continue;
        blgx.a(this);
        new Handler().postDelayed(new RegisterPersonalInfoActivity.2(this), 200L);
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
    c();
    if (this.jdField_a_of_type_Bijm != null) {
      this.jdField_a_of_type_Bijm.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPersonalInfoActivity
 * JD-Core Version:    0.7.0.1
 */