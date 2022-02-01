package com.tencent.mobileqq.activity;

import Override;
import aezo;
import aezp;
import aezq;
import aezr;
import aezs;
import aezt;
import aezu;
import aezv;
import aezw;
import aezx;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
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
import aoef;
import bdxj;
import bdxs;
import bgyd;
import bkxz;
import bkzi;
import bkzz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  public BroadcastReceiver a;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new aezp(this);
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private AutoCompleteTextView jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public aoef a;
  public bkzi a;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private DropdownView jdField_a_of_type_ComTencentMobileqqWidgetDropdownView;
  private InputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private String jdField_a_of_type_JavaLangString;
  private List<SimpleAccount> jdField_a_of_type_JavaUtilList;
  private SubAccountObserver jdField_a_of_type_MqqObserverSubAccountObserver = new aezx(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aezr(this);
  public boolean a;
  private Button b;
  public boolean b;
  private String jdField_c_of_type_JavaLangString;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public SubLoginActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bkzi = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aezv(this);
    this.jdField_a_of_type_Aoef = new aezw(this);
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
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.app.getUinDisplayNameBeforeLogin(paramSimpleAccount.getUin()));
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
    if (this.jdField_a_of_type_Bkzi == null)
    {
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
      this.jdField_a_of_type_Bkzi.b(2131692399);
      this.jdField_a_of_type_Bkzi.b(2131718921);
      this.jdField_a_of_type_Bkzi.c(2131690697);
      this.jdField_a_of_type_Bkzi.setOnDismissListener(new aezo(this));
      this.jdField_a_of_type_Bkzi.a(new aezq(this));
    }
    if (!this.jdField_a_of_type_Bkzi.isShowing())
    {
      bkxz.b(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Bkzi.show();
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562905);
    this.app.registObserver(this.jdField_a_of_type_MqqObserverSubAccountObserver);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("subuin");
    this.d = getIntent().getBooleanExtra("is_need_bind", true);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = ((DropdownView)findViewById(2131365904)).a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundResource(2130840667);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131372456));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370534));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131370546));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377133);
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null))
    {
      paramBundle = findViewById(2131370111);
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(-15724528);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(new aezs(this));
    if (AppSetting.jdField_c_of_type_Boolean) {
      bgyd.a(this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout, false);
    }
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131366811));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131365904));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilList = getAppRuntime().getApplication().getAllAccounts();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(new aezt(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnFocusChangeListener(new aezu(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLongClickable(true);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
    if (jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131719174));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131719196));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131719062));
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.e = true;
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setEnabled(false);
      if (this.d)
      {
        setTitle(2131719045);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719063);
      }
    }
    for (;;)
    {
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      addObserver(this.jdField_a_of_type_Aoef);
      return true;
      setTitle(2131719065);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131719895);
      continue;
      setTitle(2131719045);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131719063);
    }
  }
  
  public void doOnDestroy()
  {
    e();
    f();
    super.doOnDestroy();
    this.app.removeHandler(getClass());
    removeObserver(this.jdField_a_of_type_Aoef);
    this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverSubAccountObserver);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    try
    {
      dismissDialog(0);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.subaccount.SubLoginActivity", 1, new Object[] { "dismiss progress dialog error : ", localException.getMessage() });
    }
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
      if (this.f)
      {
        QLog.d("Q.subaccount.SubLoginActivity", 1, "mShouldAutoLogin: true, then login");
        this.f = false;
        if (this.jdField_a_of_type_AndroidWidgetButton != null) {
          this.jdField_a_of_type_AndroidWidgetButton.performClick();
        }
      }
      if (this.g) {}
      try
      {
        showDialog(0);
        this.g = false;
        return;
      }
      catch (Exception localException)
      {
        QLog.e("Q.subaccount.SubLoginActivity", 1, new Object[] { "show progress dialog error : ", localException.getMessage() });
      }
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
    }
    String str1;
    String str2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131366811: 
        a();
        break;
      case 2131370534: 
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        str1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        if ((str1 == null) || (str1.length() == 0) || (str1.trim().length() == 0))
        {
          QQToast.a(this, 2131694366, 0).b(getTitleBarHeight());
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
          this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
        }
        else
        {
          str2 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
          if ((str2 == null) || (str2.length() < 1))
          {
            b(getString(2131694506));
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
            this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
          }
          else
          {
            if ((!str1.equals(this.app.getUinDisplayNameBeforeLogin(this.app.getAccount()))) && (!str1.equals(this.app.getAccount()))) {
              break label303;
            }
            b(getString(2131719060));
          }
        }
        break;
      }
    }
    label303:
    Object localObject;
    if (this.d)
    {
      localObject = (bdxs)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      if (localObject == null) {
        break label654;
      }
    }
    label654:
    for (boolean bool = ((bdxs)localObject).a(str1);; bool = false)
    {
      if (bool)
      {
        b(getString(2131719061));
        break;
      }
      if ((localObject != null) && (((bdxs)localObject).a() >= 2))
      {
        bdxj.a(this.app, this);
        break;
      }
      if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (str2.equals("!@#ewaGbhkc$!!=")))
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
      if (!c()) {
        break;
      }
      if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (getString(2131719895).equals(this.jdField_a_of_type_AndroidWidgetButton.getText()))) {
        a(2131719093);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) || (!this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.isLogined())) {
          break label612;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: mCurrentAccount and islogin so get subaccount key start");
        }
        getAppRuntime().getSubAccountKey(this.app.getAccount(), this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), null);
        break;
        a(2131719048);
      }
      label612:
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: no login so go to loginSubAccount");
      }
      AuthDevUgActivity.a(2);
      getAppRuntime().loginSubAccount(this.app.getAccount(), str1, str2, null);
      break;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity
 * JD-Core Version:    0.7.0.1
 */