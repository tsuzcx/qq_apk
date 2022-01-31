package com.tencent.mobileqq.activity;

import adug;
import alud;
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
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import axmf;
import axml;
import azqs;
import bczz;
import bdin;
import bebv;
import bhsj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class RegisterByNicknameAndPwdActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private axml jdField_a_of_type_Axml;
  private bebv jdField_a_of_type_Bebv;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ClearableEditText jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean d;
  private boolean e;
  
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString4, int paramInt, String paramString5, String paramString6, boolean paramBoolean4)
  {
    paramQQAppInterface = new Intent(paramContext, RegisterByNicknameAndPwdActivity.class);
    paramQQAppInterface.putExtra("phonenum", paramString1);
    paramQQAppInterface.putExtra("invite_code", paramString4);
    paramQQAppInterface.putExtra("key", paramString2);
    paramQQAppInterface.putExtra("key_register_smscode", paramString3);
    paramQQAppInterface.putExtra("key_register_is_phone_num_registered", paramBoolean1);
    paramQQAppInterface.putExtra("key_register_has_pwd", paramBoolean2);
    paramQQAppInterface.putExtra("key_register_from", paramInt);
    paramQQAppInterface.putExtra("key_register_nick", paramString5);
    paramQQAppInterface.putExtra("key_register_password", paramString6);
    paramQQAppInterface.putExtra("key_register_phonenum_bindnewqq", paramBoolean4);
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
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("invite_code");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.d = getIntent().getBooleanExtra("key_register_from_quick_register", false);
    this.e = getIntent().getBooleanExtra("key_register_phonenum_bindnewqq", true);
    String str1 = getIntent().getStringExtra("key_register_nick");
    String str2 = getIntent().getStringExtra("key_register_password");
    b(alud.a(2131713730));
    b();
    a(100);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372518);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131372521);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372517));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372520));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131371614));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131371165));
    this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363684));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131369842));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131380037);
    if (!TextUtils.isEmpty(str1)) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.setText(str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(str2);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371615));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846524);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131713750));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnFocusChangeListener(new adug(this));
      if (bczz.a(this))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(2131694805);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(2131695122);
      }
      if (this.jdField_a_of_type_Bebv == null) {
        break;
      }
      this.jdField_a_of_type_Bebv.a();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846525);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131713733));
    }
    this.jdField_a_of_type_Bebv = new bebv(this, findViewById(2131369148), 1);
  }
  
  private void e()
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText != null) && (!this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.isEnabled()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.isEnabled())) {
      getWindow().setSoftInputMode(localLayoutParams.softInputMode & 0xFFFFFFFB | 0x2);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterByNicknameAndPwdActivity", 2, "setSoftInputMode, isHideInput=" + bool + ",mode=" + localLayoutParams.softInputMode);
      }
      return;
      getWindow().setSoftInputMode(localLayoutParams.softInputMode & 0xFFFFFFFD | 0x4);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  public boolean a()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText == null)) {
      return false;
    }
    String str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText());
    String str2 = this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if (TextUtils.isEmpty(str1))
    {
      a(2131695202, 1);
      return false;
    }
    if (b(str1))
    {
      a(2131717547, 1);
      return false;
    }
    if (!a(str1))
    {
      a(2131717546, 1);
      return false;
    }
    if ((TextUtils.isEmpty(str2)) || (str2.trim().length() == 0))
    {
      a(2131717495, 1);
      return false;
    }
    try
    {
      if (a(str2) > 24L)
      {
        a(2131717496, 1);
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {}
    Object localObject1;
    do
    {
      return;
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
    } while ((paramEditable != localObject2) && (paramEditable != localObject1));
    String str = localObject2.toString();
    Object localObject2 = localObject1.toString();
    int i;
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() >= 8))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840306);
        i = 1;
      }
    }
    for (;;)
    {
      label86:
      int j;
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (a((String)localObject2)))
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130840306);
          j = 1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          label122:
          if ((!TextUtils.isEmpty(str)) && (i != 0) && (j != 0)) {
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Bebv != null) {
              this.jdField_a_of_type_Bebv.b(this.jdField_a_of_type_AndroidWidgetButton.isEnabled());
            }
            if (paramEditable != localObject1) {
              break;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label231;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
            return;
            this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840303);
            i = 0;
            break label86;
            this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130840303);
            j = 0;
            break label122;
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          }
          label231:
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(true);
          localObject1 = ((String)localObject2).substring(((String)localObject2).length() - 1, ((String)localObject2).length());
          try
          {
            if (((String)localObject1).length() >= ((String)localObject1).getBytes("utf-8").length) {
              break;
            }
            paramEditable.delete(((String)localObject2).length() - 1, ((String)localObject2).length());
            return;
          }
          catch (UnsupportedEncodingException paramEditable)
          {
            paramEditable.printStackTrace();
            return;
          }
        }
        j = 0;
      }
      i = 0;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1) && (this.jdField_a_of_type_Bebv != null) && (this.jdField_a_of_type_Bebv.jdField_a_of_type_Axmf != null)) {
      this.jdField_a_of_type_Bebv.jdField_a_of_type_Axmf.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    if (QLog.isDevelopLevel()) {
      bebv.a("RegisterByNicknameAndPwdActivity -- doOnNewIntent", getIntent());
    }
    d();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Axml != null) {
      this.jdField_a_of_type_Axml.c();
    }
    e();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Axml != null) {
      this.jdField_a_of_type_Axml.b();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_Axml != null) {
      this.jdField_a_of_type_Axml.d();
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Bebv != null) && (this.jdField_a_of_type_Bebv.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Bebv.a(this.e);
          return;
        }
        azqs.b(this.app, "CliOper", "", "", "0X8006653", "0X8006653", 0, 0, "", "", "", "");
        if (!bdin.d(BaseApplication.getContext()))
        {
          a(2131692398, 0);
          return;
        }
      } while (!a());
      paramView = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText());
      String str = this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if (this.jdField_a_of_type_Axml == null) {
        this.jdField_a_of_type_Axml = new axml(this);
      }
      this.jdField_a_of_type_Axml.a(str, paramView, true, this.e);
      azqs.a(this.app, "new_reg_805", "setting_page", "reg_clk", "", 1, "");
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.d) {
          azqs.a(this.app, "dc00898", "", "", "0X80072FA", "0X80072FA", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846525);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131713740));
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846524);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131713747));
      }
      bhsj.a(this);
      new Handler().postDelayed(new RegisterByNicknameAndPwdActivity.2(this), 200L);
      return;
    } while (this.jdField_a_of_type_Axml == null);
    this.jdField_a_of_type_Axml.f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561665);
    if (QLog.isDevelopLevel()) {
      bebv.a(getClass().getSimpleName(), getIntent());
    }
    d();
    azqs.b(this.app, "CliOper", "", "", "0X8006652", "0X8006652", 0, 0, "", "", "", "");
    azqs.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 0, 0, "", "", "", "");
    if (this.d) {
      azqs.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 1, 0, "", "", "", "");
    }
    if (!this.jdField_b_of_type_Boolean) {
      azqs.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 2, 0, "", "", "", "");
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("key_register_from_send_sms", false)) {
        azqs.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 5, 0, "", "", "", "");
      }
      if (this.jdField_b_of_type_Int != 4) {
        break;
      }
      azqs.a(this.app, "new_reg_805", "setting_page", "page_exp", "3", 1, "", "1", "", "", "", "", "", "", "");
      return;
      if (!this.jdField_c_of_type_Boolean) {
        azqs.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 3, 0, "", "", "", "");
      } else {
        azqs.a(this.app, "dc00898", "", "", "0X800735E", "0X800735E", 4, 0, "", "", "", "");
      }
    }
    if (this.jdField_b_of_type_Int == 5)
    {
      azqs.a(this.app, "new_reg_805", "setting_page", "page_exp", "1", 1, "", "2", "", "", "", "", "", "", "");
      return;
    }
    if (this.jdField_b_of_type_Int == 6)
    {
      azqs.a(this.app, "new_reg_805", "setting_page", "page_exp", "2", 1, "", "3", "", "", "", "", "", "", "");
      return;
    }
    if (this.d)
    {
      azqs.a(this.app, "new_reg_805", "setting_page", "page_exp", "4", 1, "", "3", "", "", "", "", "", "", "");
      return;
    }
    azqs.a(this.app, "new_reg_805", "setting_page", "page_exp", "5", 1, "", "4", "", "", "", "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
    if (this.jdField_a_of_type_Bebv != null) {
      this.jdField_a_of_type_Bebv.b();
    }
    if (this.jdField_a_of_type_Axml != null) {
      this.jdField_a_of_type_Axml.a();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity
 * JD-Core Version:    0.7.0.1
 */