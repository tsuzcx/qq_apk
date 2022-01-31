package com.tencent.mobileqq.activity;

import abtt;
import abtu;
import abtv;
import abtw;
import abtx;
import abty;
import abtz;
import abua;
import abub;
import ajss;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import axam;
import axat;
import azve;
import bbmy;
import begr;
import behe;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;
import mqq.os.MqqHandler;

public class SubLoginActivity
  extends SubAccountBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private static final boolean jdField_c_of_type_Boolean = AppSetting.jdField_c_of_type_Boolean;
  public ajss a;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new abub(this);
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private AutoCompleteTextView jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public begr a;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private DropdownView jdField_a_of_type_ComTencentMobileqqWidgetDropdownView;
  private InputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private String jdField_a_of_type_JavaLangString;
  private List<SimpleAccount> jdField_a_of_type_JavaUtilList;
  private SubAccountObserver jdField_a_of_type_MqqObserverSubAccountObserver = new abua(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new abtv(this);
  public boolean a;
  private Button b;
  public boolean b;
  private String jdField_c_of_type_JavaLangString;
  private boolean d;
  private boolean e;
  
  public SubLoginActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Begr = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Ajss = new abtz(this);
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.app.b(paramSimpleAccount.getUin()));
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("!@#ewaGbhkc$!!=");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
        }
      }
      finally {}
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_Begr = ((begr)behe.a(this, null));
      this.jdField_a_of_type_Begr.b(2131626976);
      this.jdField_a_of_type_Begr.b(2131653793);
      this.jdField_a_of_type_Begr.c(2131625035);
      this.jdField_a_of_type_Begr.setOnDismissListener(new abtt(this));
      this.jdField_a_of_type_Begr.a(new abtu(this));
    }
    if (!this.jdField_a_of_type_Begr.isShowing())
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Begr.show();
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131496861);
    this.app.registObserver(this.jdField_a_of_type_MqqObserverSubAccountObserver);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("subuin");
    this.d = getIntent().getBooleanExtra("is_need_bind", true);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = ((DropdownView)findViewById(2131299830)).a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundResource(2130840248);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131305584));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131303887));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131303897));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131309892);
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null))
    {
      paramBundle = findViewById(2131303534);
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(-15724528);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(new abtw(this));
    if (AppSetting.jdField_c_of_type_Boolean) {
      azve.a(this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout, false);
    }
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131300669));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131299830));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilList = getAppRuntime().getApplication().getAllAccounts();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(new abtx(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnFocusChangeListener(new abty(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLongClickable(false);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
    if (jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131654153));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131654172));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131653989));
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.e = true;
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setEnabled(false);
      if (this.d)
      {
        setTitle(2131653961);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131653990);
      }
    }
    for (;;)
    {
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      addObserver(this.jdField_a_of_type_Ajss);
      return true;
      setTitle(2131653992);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131654808);
      continue;
      setTitle(2131653961);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131653990);
    }
  }
  
  public void doOnDestroy()
  {
    c();
    d();
    super.doOnDestroy();
    this.app.removeHandler(getClass());
    removeObserver(this.jdField_a_of_type_Ajss);
    this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverSubAccountObserver);
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onPause:....loginActivity..................");
    }
    super.doOnPause();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  public void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.e)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.performClick();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
    }
  }
  
  public boolean onBackEvent()
  {
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.isShown())) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300669: 
      a();
      return;
    }
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    if ((paramView == null) || (paramView.length() == 0) || (paramView.trim().length() == 0))
    {
      bbmy.a(this, 2131629080, 0).b(getTitleBarHeight());
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((str == null) || (str.length() < 1))
    {
      b(getString(2131629288));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
      return;
    }
    if ((paramView.equals(this.app.b(this.app.getAccount()))) || (paramView.equals(this.app.getAccount())))
    {
      b(getString(2131653987));
      return;
    }
    Object localObject;
    if (this.d)
    {
      localObject = (axat)this.app.getManager(61);
      if (localObject == null) {
        break label615;
      }
    }
    label615:
    for (boolean bool = ((axat)localObject).a(paramView);; bool = false)
    {
      if (bool)
      {
        b(getString(2131653988));
        return;
      }
      if ((localObject != null) && (((axat)localObject).a() >= 2))
      {
        axam.a(this.app, this);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (str.equals("!@#ewaGbhkc$!!=")))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i)).getUin() == null)) {}
          while (!((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i)).getUin().equals(localObject))
          {
            i += 1;
            break;
          }
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i));
        }
      }
      if (!b()) {
        break;
      }
      if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (getString(2131654808).equals(this.jdField_a_of_type_AndroidWidgetButton.getText()))) {
        a(2131654032);
      }
      while ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) && (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.isLogined()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: mCurrentAccount and islogin so get subaccount key start");
        }
        getAppRuntime().getSubAccountKey(this.app.getAccount(), this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), null);
        return;
        a(2131653964);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: no login so go to loginSubAccount");
      }
      getAppRuntime().loginSubAccount(this.app.getAccount(), paramView, str, null);
      return;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      a(null);
      if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() == 0)) {}
      do
      {
        do
        {
          return;
          paramCharSequence = paramCharSequence.toString();
        } while ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != this.jdField_a_of_type_JavaLangString.length() + 1));
        if (!paramCharSequence.substring(0, this.jdField_a_of_type_JavaLangString.length()).equals(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(this.jdField_a_of_type_JavaLangString.length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(paramCharSequence);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(1);
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity
 * JD-Core Version:    0.7.0.1
 */