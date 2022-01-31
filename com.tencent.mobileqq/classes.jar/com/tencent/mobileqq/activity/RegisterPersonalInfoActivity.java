package com.tencent.mobileqq.activity;

import abor;
import ajjy;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import auqn;
import auqr;
import awqx;
import badq;
import bavd;
import beex;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RegisterPersonalInfoActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private auqr jdField_a_of_type_Auqr;
  private bavd jdField_a_of_type_Bavd;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.c = getIntent().getStringExtra("invite_code");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_register_from_send_sms", false);
    b(ajjy.a(2131647566));
    b();
    a(80);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297993));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131305163));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(new abor(this));
    if (this.jdField_a_of_type_Bavd != null)
    {
      this.jdField_a_of_type_Bavd.a();
      return;
    }
    this.jdField_a_of_type_Bavd = new bavd(this, findViewById(2131303233), 2);
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
      a(2131651308, 1);
      return false;
    }
    return true;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1) && (this.jdField_a_of_type_Bavd != null) && (this.jdField_a_of_type_Bavd.jdField_a_of_type_Auqn != null)) {
      this.jdField_a_of_type_Bavd.jdField_a_of_type_Auqn.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131495868);
    if (QLog.isDevelopLevel()) {
      bavd.a(getClass().getSimpleName(), getIntent());
    }
    a();
    awqx.b(this.app, "CliOper", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    awqx.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    if (!this.jdField_b_of_type_Boolean)
    {
      awqx.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 1, 0, "", "", "", "");
      if (this.jdField_a_of_type_Boolean) {
        awqx.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 3, 0, "", "", "", "");
      }
      if (this.jdField_b_of_type_Int != 4) {
        break label232;
      }
      awqx.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      awqx.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 2, 0, "", "", "", "");
      break;
      label232:
      if (this.jdField_b_of_type_Int == 5) {
        awqx.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
      } else if (this.jdField_b_of_type_Int == 6) {
        awqx.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "3", "", "", "", "", "", "", "");
      } else {
        awqx.a(this.app, "new_reg", "setting_page_no", "page_exp", "", 1, "", "4", "", "", "", "", "", "", "");
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    super.setIntent(paramIntent);
    if (QLog.isDevelopLevel()) {
      bavd.a("RegisterPersonalInfoActivity -- doOnNewIntent", getIntent());
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
    default: 
    case 2131297993: 
      do
      {
        return;
        if ((this.jdField_a_of_type_Bavd != null) && (this.jdField_a_of_type_Bavd.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Bavd.a(true);
          return;
        }
        if (!badq.d(BaseApplication.getContext()))
        {
          a(2131626719, 0);
          return;
        }
      } while (!a());
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if (this.jdField_a_of_type_Auqr == null) {
        this.jdField_a_of_type_Auqr = new auqr(this);
      }
      this.jdField_a_of_type_Auqr.a(paramView);
      awqx.a(this.app, "new_reg", "setting_page_no", "reg_clk", "", 1, "");
      return;
    }
    beex.a(this);
    new Handler().postDelayed(new RegisterPersonalInfoActivity.2(this), 200L);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
    if (this.jdField_a_of_type_Bavd != null) {
      this.jdField_a_of_type_Bavd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPersonalInfoActivity
 * JD-Core Version:    0.7.0.1
 */