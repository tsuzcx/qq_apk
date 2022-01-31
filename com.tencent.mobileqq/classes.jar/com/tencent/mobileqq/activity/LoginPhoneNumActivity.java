package com.tencent.mobileqq.activity;

import adhv;
import adhw;
import adhx;
import adhy;
import adhz;
import adic;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import awia;
import bdin;
import bdjb;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class LoginPhoneNumActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private adic jdField_a_of_type_Adic;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ConfigClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new adhz(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new adhv(this);
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private String d;
  
  private String a(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.jdField_b_of_type_JavaLangString)) {
          break label170;
        }
        if ("853".equals(this.jdField_b_of_type_JavaLangString))
        {
          break label170;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        i = j;
        if (!paramString.startsWith("1"))
        {
          i = j;
          if ("86".equals(this.jdField_b_of_type_JavaLangString)) {
            i = 0;
          }
        }
        if (!"86".equals(this.jdField_b_of_type_JavaLangString)) {
          break label162;
        }
        j = paramString.length();
        if (j == 11) {
          break label162;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label145;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.jdField_b_of_type_JavaLangString);
      if (bool)
      {
        i = 9;
        continue;
        label145:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label162:
        continue;
        label170:
        i = 6;
      }
    }
  }
  
  private boolean a()
  {
    boolean bool = true;
    this.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString());
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      a(2131717510, 1);
      bool = false;
    }
    return bool;
  }
  
  private void d()
  {
    c(2131721272);
    b();
    a(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379132));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362828));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379131));
    this.jdField_b_of_type_JavaLangString = bdjb.b(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("+" + this.jdField_b_of_type_JavaLangString);
    if ("86".equals(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131717456));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText = ((ConfigClearableEditText)findViewById(2131371324));
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.addTextChangedListener(this);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setCustomSelectionActionModeCallback(new adhx(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363638));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setOnCreateContextMenuListener(new adhy(this));
    }
  }
  
  private void e()
  {
    if (!a()) {}
    do
    {
      return;
      if (!bdin.d(BaseApplication.getContext()))
      {
        a(2131692398, 0);
        return;
      }
      b(2131717556);
    } while (awia.a().a(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver) == 0);
    c();
    a(getString(2131717527), 1);
  }
  
  public void a()
  {
    boolean bool = getIntent().getBooleanExtra("login_from_account_change", false);
    Intent localIntent = new Intent(this, LoginVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("isSubaccount", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("fromWhere", this.d);
    localIntent.putExtra("login_from_account_change", bool);
    if (bool)
    {
      startActivityForResult(localIntent, 20140319);
      return;
    }
    startActivity(localIntent);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (a(paramEditable.toString()) != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561026);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isSubaccount", false);
    }
    if (this.app != null) {
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    }
    d();
    this.jdField_a_of_type_Adic = new adic();
    paramBundle = new adhw(this);
    this.jdField_a_of_type_Adic.a(paramBundle);
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      this.jdField_b_of_type_AndroidWidgetTextView.setText("+" + this.jdField_b_of_type_JavaLangString);
      try
      {
        if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString()) != null)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if ((paramInt1 == 20140319) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362828: 
    case 2131379132: 
      startActivityForResult(new Intent(this, NewStyleCountryActivity.class), 1);
      return;
    }
    if (!this.jdField_a_of_type_Adic.a(this))
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      return;
    }
    e();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */