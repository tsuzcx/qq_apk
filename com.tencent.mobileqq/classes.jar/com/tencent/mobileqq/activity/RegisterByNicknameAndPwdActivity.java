package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.io.UnsupportedEncodingException;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import tpe;
import tpf;
import tpg;

public class RegisterByNicknameAndPwdActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new tpg(this);
  private boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private ClearableEditText b;
  private String c;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  
  public RegisterByNicknameAndPwdActivity()
  {
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static int a(String paramString)
  {
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[Α-￥]")) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterByNicknameAndPwdActivity", 2, "getMixStringLength, str :" + paramString + ",length :" + i);
    }
    return i;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramQQAppInterface = new Intent(paramContext, RegisterByNicknameAndPwdActivity.class);
    paramQQAppInterface.putExtra("phonenum", paramString1);
    paramQQAppInterface.putExtra("key", paramString2);
    paramQQAppInterface.putExtra("key_register_smscode", paramString3);
    paramQQAppInterface.putExtra("key_register_is_phone_num_registered", paramBoolean1);
    paramQQAppInterface.putExtra("key_register_has_pwd", paramBoolean2);
    if ((paramContext instanceof RegisterSendUpSms)) {
      paramQQAppInterface.putExtra("key_register_from_send_sms", true);
    }
    paramContext.startActivity(paramQQAppInterface);
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (paramString.length() <= 0))
    {
      bool1 = false;
      return bool1;
    }
    int i3 = paramString.length();
    int i = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    label36:
    if (i < i3)
    {
      int n = paramString.charAt(i);
      int i1;
      int i2;
      if ((n >= 48) && (n <= 57))
      {
        n = m;
        i1 = k;
        i2 = j;
        if (j == 0)
        {
          i2 = 1;
          i1 = k;
          n = m;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i2 + i1 + n >= 2) {
          break;
        }
        i += 1;
        m = n;
        k = i1;
        j = i2;
        break label36;
        if (((n >= 97) && (n <= 122)) || ((n >= 65) && (n <= 90)))
        {
          n = m;
          i1 = k;
          i2 = j;
          if (k == 0)
          {
            i1 = 1;
            n = m;
            i2 = j;
          }
        }
        else
        {
          n = m;
          i1 = k;
          i2 = j;
          if (m == 0)
          {
            n = 1;
            i1 = k;
            i2 = j;
          }
        }
      }
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    return paramString.indexOf(" ") != -1;
  }
  
  private void d()
  {
    a("设置昵称与密码");
    b();
    if (getIntent().getBooleanExtra("not_need_verify_sms", false))
    {
      a(50);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131372192));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131372190));
      this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364885));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364930));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!this.jdField_a_of_type_Boolean) {
        break label207;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843868);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("隐藏密码");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnFocusChangeListener(new tpe(this));
      if (AccessibilityUtil.a(this))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(2131434477);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(2131433200);
      }
      return;
      a(80);
      break;
      label207:
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843869);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("显示密码");
    }
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, RegisterQQNumberActivity.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uin", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("key_register_sign", this.jdField_a_of_type_ArrayOfByte);
    localIntent.putExtra("key_register_password", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText()));
    localIntent.putExtra("key_register_unbind", true);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("key_register_has_pwd", this.jdField_c_of_type_Boolean);
    localIntent.putExtra("key_register_from_send_sms", this.jdField_e_of_type_Boolean);
    localIntent.putExtra("key_register_chose_bind_phone", false);
    startActivity(localIntent);
    finish();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {}
    for (;;)
    {
      return;
      Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
      if ((paramEditable == localObject2) || (paramEditable == localObject1))
      {
        String str = localObject2.toString();
        localObject2 = localObject1.toString();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() >= 8)) {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        }
        while (paramEditable == localObject1)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label106;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
        continue;
        label106:
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(true);
        localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 1, ((String)localObject2).length());
        try
        {
          if (((String)localObject1).length() < ((String)localObject1).getBytes("utf-8").length)
          {
            paramEditable.delete(((String)localObject2).length() - 1, ((String)localObject2).length());
            return;
          }
        }
        catch (UnsupportedEncodingException paramEditable)
        {
          paramEditable.printStackTrace();
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364885: 
      ReportController.b(this.app, "CliOper", "", "", "0X8006653", "0X8006653", 0, 0, "", "", "", "");
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        a(2131433009, 0);
        return;
      }
      paramView = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText());
      if (TextUtils.isEmpty(paramView))
      {
        a(2131434298, 1);
        return;
      }
      if (b(paramView))
      {
        a(2131434282, 1);
        return;
      }
      if (!a(paramView))
      {
        a(2131434281, 1);
        return;
      }
      String str = this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if ((TextUtils.isEmpty(str)) || (str.trim().length() == 0))
      {
        a(2131434318, 1);
        return;
      }
      try
      {
        if (a(str) > 24L)
        {
          a(2131434319, 1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
        for (;;)
        {
          try
          {
            if (this.jdField_d_of_type_Boolean)
            {
              localAccountManager.getQuickRegisterAccount(this.app.getCurrentAccountUin(), str, paramView, AppSetting.a, "7.6.3", this.jdField_a_of_type_MqqObserverAccountObserver);
              b(2131434237);
              return;
            }
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          PhoneNumLoginImpl.a().a(this.app, false);
          localAccountManager.sendRegisterBySetPass(paramView, str, this.jdField_c_of_type_JavaLangString, false, this.jdField_a_of_type_MqqObserverAccountObserver);
        }
      }
    case 2131364930: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_d_of_type_Boolean) {
          ReportController.a(this.app, "dc00898", "", "", "0X80072FA", "0X80072FA", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843869);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("显示密码");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramView)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.length());
        }
        if (!this.jdField_a_of_type_Boolean) {
          bool = true;
        }
        this.jdField_a_of_type_Boolean = bool;
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843868);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("隐藏密码");
      }
    }
    InputMethodUtil.a(this);
    new Handler().postDelayed(new tpf(this), 200L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130970917);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("key_register_from_quick_register", false);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("key_register_smscode");
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = "";
    }
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_e_of_type_Boolean = getIntent().getBooleanExtra("key_register_from_send_sms", false);
    d();
    ReportController.b(this.app, "CliOper", "", "", "0X8006652", "0X8006652", 0, 0, "", "", "", "");
    ReportController.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 0, 0, "", "", "", "");
    if (this.jdField_d_of_type_Boolean) {
      ReportController.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 1, 0, "", "", "", "");
    }
    if (!this.jdField_b_of_type_Boolean) {
      ReportController.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 2, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Boolean) {
        ReportController.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 5, 0, "", "", "", "");
      }
      return;
      if (!this.jdField_c_of_type_Boolean) {
        ReportController.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 3, 0, "", "", "", "");
      } else {
        ReportController.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 4, 0, "", "", "", "");
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    c();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity
 * JD-Core Version:    0.7.0.1
 */