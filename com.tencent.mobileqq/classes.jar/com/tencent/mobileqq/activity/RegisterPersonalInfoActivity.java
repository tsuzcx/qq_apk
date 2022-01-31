package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.InputMethodUtil;
import mqq.observer.WtloginObserver;
import tpr;
import tps;
import tpt;

public class RegisterPersonalInfoActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new tpt(this);
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String c = "";
  private String d;
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramQQAppInterface = new Intent(paramContext, RegisterPersonalInfoActivity.class);
    paramQQAppInterface.putExtra("phonenum", paramString1);
    paramQQAppInterface.putExtra("key", paramString2);
    paramQQAppInterface.putExtra("key_register_smscode", paramString3);
    paramQQAppInterface.putExtra("key_register_is_phone_num_registered", paramBoolean1);
    if ((paramContext instanceof RegisterSendUpSms)) {
      paramQQAppInterface.putExtra("key_register_from_send_sms", true);
    }
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970918);
    a("设置昵称");
    b();
    a(80);
    this.c = getIntent().getStringExtra("key_register_smscode");
    if (this.c == null) {
      this.c = "";
    }
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_register_from_send_sms", false);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370512));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131372190));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(new tpr(this));
    ReportController.b(this.app, "CliOper", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    ReportController.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 0, 0, "", "", "", "");
    if (!this.jdField_b_of_type_Boolean) {
      ReportController.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        ReportController.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 3, 0, "", "", "", "");
      }
      return true;
      ReportController.a(this.app, "dc00898", "", "", "0X8007362", "0X8007362", 2, 0, "", "", "", "");
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131370512: 
      for (;;)
      {
        return;
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          a(2131433009, 0);
          return;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
        if ((TextUtils.isEmpty(paramView)) || (paramView.trim().length() == 0))
        {
          a(2131434318, 1);
          return;
        }
        try
        {
          b(2131434237);
          if (PhoneNumLoginImpl.a().a(this.app, this.c.getBytes(), paramView.getBytes(), this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
          {
            c();
            a(2131434215, 1);
            return;
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
      }
    }
    InputMethodUtil.a(this);
    new Handler().postDelayed(new tps(this), 200L);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPersonalInfoActivity
 * JD-Core Version:    0.7.0.1
 */