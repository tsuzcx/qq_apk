package com.tencent.mobileqq.activity;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;
import mqq.os.MqqHandler;

public class SubLoginActivity
  extends SubAccountBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private static final boolean jdField_c_of_type_Boolean = AppSetting.d;
  public BroadcastReceiver a;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new SubLoginActivity.10(this);
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private AutoCompleteTextView jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LoginFailedHelper jdField_a_of_type_ComTencentMobileqqAppLoginFailedHelper = new LoginFailedHelper();
  public SubAccountBindObserver a;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private DropdownView jdField_a_of_type_ComTencentMobileqqWidgetDropdownView;
  private InputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private String jdField_a_of_type_JavaLangString = null;
  private List<SimpleAccount> jdField_a_of_type_JavaUtilList;
  private SubAccountObserver jdField_a_of_type_MqqObserverSubAccountObserver = new SubLoginActivity.9(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new SubLoginActivity.3(this);
  boolean jdField_a_of_type_Boolean = false;
  private Button jdField_b_of_type_AndroidWidgetButton;
  boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean d;
  private boolean e;
  private boolean f = false;
  private boolean g = false;
  private boolean h;
  
  public SubLoginActivity()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new SubLoginActivity.7(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new SubLoginActivity.8(this);
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
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131692531);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131719448);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new SubLoginActivity.1(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new SubLoginActivity.2(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
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
    super.setContentView(2131563053);
    this.app.registObserver(this.jdField_a_of_type_MqqObserverSubAccountObserver);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("subuin");
    this.d = getIntent().getBooleanExtra("is_need_bind", true);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = ((DropdownView)findViewById(2131366068)).a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundResource(2130840797);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131372766));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370817));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131370831));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377553);
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null))
    {
      paramBundle = findViewById(2131370383);
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(-15724528);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(new SubLoginActivity.4(this));
    if (AppSetting.d) {
      AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout, false);
    }
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131366994));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131366068));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilList = getAppRuntime().getApplication().getAllAccounts();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(new SubLoginActivity.5(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnFocusChangeListener(new SubLoginActivity.6(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLongClickable(true);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
    if (jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131699698));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131699700));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131719602));
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.e = true;
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setEnabled(false);
      if (this.d)
      {
        setTitle(2131719585);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719603);
      }
    }
    for (;;)
    {
      this.app.setHandler(LoginProgressClazz.class, this.jdField_a_of_type_MqqOsMqqHandler);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      return true;
      setTitle(2131719605);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131720468);
      continue;
      setTitle(2131719585);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131719603);
    }
  }
  
  public void doOnDestroy()
  {
    e();
    f();
    super.doOnDestroy();
    this.app.removeHandler(LoginProgressClazz.class);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
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
      if (this.g)
      {
        QLog.d("Q.subaccount.SubLoginActivity", 1, "mShouldAutoLogin: true, then login");
        this.g = false;
        if (this.jdField_a_of_type_AndroidWidgetButton != null) {
          this.jdField_a_of_type_AndroidWidgetButton.performClick();
        }
      }
      if (this.h) {}
      try
      {
        showDialog(0);
        this.h = false;
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
      case 2131366994: 
        a();
        break;
      case 2131370817: 
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        str1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        if ((str1 == null) || (str1.length() == 0) || (str1.trim().length() == 0))
        {
          QQToast.a(this, 2131694582, 0).b(getTitleBarHeight());
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
          this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
        }
        else
        {
          str2 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
          if ((str2 == null) || (str2.length() < 1))
          {
            b(getString(2131694724));
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
            this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
          }
          else
          {
            if ((!str1.equals(this.app.getUinDisplayNameBeforeLogin(this.app.getAccount()))) && (!str1.equals(this.app.getAccount()))) {
              break label303;
            }
            b(getString(2131719600));
          }
        }
        break;
      }
    }
    label303:
    Object localObject;
    if (this.d)
    {
      localObject = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      if (localObject == null) {
        break label654;
      }
    }
    label654:
    for (boolean bool = ((SubAccountManager)localObject).a(str1);; bool = false)
    {
      if (bool)
      {
        b(getString(2131719601));
        break;
      }
      if ((localObject != null) && (((SubAccountManager)localObject).a() >= 2))
      {
        SubAccountControll.a(this.app, this);
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
      if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (getString(2131720468).equals(this.jdField_a_of_type_AndroidWidgetButton.getText()))) {
        a(2131719633);
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
        a(2131719588);
      }
      label612:
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: no login so go to loginSubAccount");
      }
      LoginStaticField.a(2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity
 * JD-Core Version:    0.7.0.1
 */