package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
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
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
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
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;
import mqq.os.MqqHandler;

public class SubLoginActivity
  extends SubAccountBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private static final boolean c = AppSetting.d;
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
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
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
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.removeTextChangedListener(this);
      this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
      if (paramSimpleAccount == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(a(paramSimpleAccount.getUin()));
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
      return;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    Object localObject1 = MobileQQ.sMobileQQ;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Constants.PropertiesKey.uinDisplayName.toString());
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = ((MobileQQ)localObject1).getProperty(((StringBuilder)localObject2).toString());
    localObject1 = paramString;
    if (localObject2 != null)
    {
      if (((String)localObject2).length() == 0) {
        return paramString;
      }
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131692483);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131719166);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
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
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i = 2;
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CNR setAutoLoginSharePre auto =");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("SharedPreUtils", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("_preferences");
      localObject = paramContext.getSharedPreferences(((StringBuilder)localObject).toString(), 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("login_auto");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
      paramContext = paramContext.getSharedPreferences("sp_login_auto", 4).edit();
      if (!paramBoolean) {
        i = 1;
      }
      paramContext.putInt(paramString, i).commit();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre uin is null");
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562877);
    this.app.registObserver(this.jdField_a_of_type_MqqObserverSubAccountObserver);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("subuin");
    this.d = getIntent().getBooleanExtra("is_need_bind", true);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = ((DropdownView)findViewById(2131365985)).a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundResource(2130840672);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131372343));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370448));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131370462));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376995);
    if (QQTheme.a())
    {
      paramBundle = findViewById(2131370044);
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(-15724528);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(new SubLoginActivity.4(this));
    if (AppSetting.d) {
      AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout, false);
    }
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131366847));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131365985));
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
    if (c)
    {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131699831));
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(getString(2131699833));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131719321));
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.e = true;
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setEnabled(false);
      if (this.d)
      {
        setTitle(2131719304);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719322);
      }
      else
      {
        setTitle(2131719324);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131720183);
      }
    }
    else
    {
      setTitle(2131719304);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131719322);
    }
    this.app.setHandler(LoginProgressClazz.class, this.jdField_a_of_type_MqqOsMqqHandler);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    hideJuhua();
    dimissDialog();
    super.doOnDestroy();
    this.app.removeHandler(LoginProgressClazz.class);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverSubAccountObserver);
    BroadcastReceiver localBroadcastReceiver = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localBroadcastReceiver != null) {
      unregisterReceiver(localBroadcastReceiver);
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
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onPause:....loginActivity..................");
    }
    super.doOnPause();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  protected void doOnResume()
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
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.clearFocus();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
    if (this.g)
    {
      QLog.d("Q.subaccount.SubLoginActivity", 1, "mShouldAutoLogin: true, then login");
      this.g = false;
      Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (localButton != null) {
        localButton.performClick();
      }
    }
    if (this.h) {
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
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramView == localObject1)
    {
      if ((localObject1 != null) && (((ImageView)localObject1).isShown())) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
    }
    else
    {
      int i = paramView.getId();
      if (i == 2131370448)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
        Object localObject2 = paramView.getWindowToken();
        i = 0;
        ((InputMethodManager)localObject1).hideSoftInputFromWindow((IBinder)localObject2, 0);
        localObject1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).trim().length() != 0))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
          if ((localObject2 != null) && (((String)localObject2).length() >= 1))
          {
            if ((!((String)localObject1).equals(a(this.app.getAccount()))) && (!((String)localObject1).equals(this.app.getAccount())))
            {
              Object localObject3;
              if (this.d)
              {
                localObject3 = (ISubAccountService)this.app.getRuntimeService(ISubAccountService.class, null);
                boolean bool;
                if (localObject3 != null) {
                  bool = ((ISubAccountService)localObject3).isSubAccountUin((String)localObject1);
                } else {
                  bool = false;
                }
                if (bool)
                {
                  showQQToast(getString(2131719320));
                  break label667;
                }
                if ((localObject3 != null) && (((ISubAccountService)localObject3).getBindedNumber() >= 2))
                {
                  SubAccountControllUtil.a(this.app, this);
                  break label667;
                }
              }
              if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (((String)localObject2).equals("!@#ewaGbhkc$!!=")))
              {
                localObject3 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
                while (i < this.jdField_a_of_type_JavaUtilList.size())
                {
                  if ((this.jdField_a_of_type_JavaUtilList.get(i) != null) && (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i)).getUin() != null) && (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i)).getUin().equals(localObject3)))
                  {
                    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i));
                    break;
                  }
                  i += 1;
                }
              }
              if (isNetConnToast())
              {
                if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (getString(2131720183).equals(this.jdField_a_of_type_AndroidWidgetButton.getText()))) {
                  showJuhua(2131719352);
                } else {
                  showJuhua(2131719307);
                }
                localObject3 = this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
                if ((localObject3 != null) && (((SimpleAccount)localObject3).isLogined()))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: mCurrentAccount and islogin so get subaccount key start");
                  }
                  getAppRuntime().getSubAccountKey(this.app.getAccount(), this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), null);
                }
                else
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.subaccount.SubLoginActivity", 2, "onClick: no login so go to loginSubAccount");
                  }
                  LoginStaticField.a(2);
                  getAppRuntime().loginSubAccount(this.app.getAccount(), (String)localObject1, (String)localObject2, null);
                }
              }
            }
            else
            {
              showQQToast(getString(2131719319));
            }
          }
          else
          {
            showQQToast(getString(2131694702));
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
            this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
          }
        }
        else
        {
          QQToast.a(this, 2131694550, 0).b(getTitleBarHeight());
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
          this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
        }
      }
      else if (i == 2131366847)
      {
        a();
      }
    }
    label667:
    EventCollector.getInstance().onViewClicked(paramView);
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
      String str = this.jdField_a_of_type_JavaLangString;
      if (str != null)
      {
        if (str.length() == 0) {
          return;
        }
        paramCharSequence = paramCharSequence.toString();
        if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
        {
          if (paramCharSequence.length() != this.jdField_a_of_type_JavaLangString.length() + 1) {
            return;
          }
          if (!paramCharSequence.substring(0, this.jdField_a_of_type_JavaLangString.length()).equals(this.jdField_a_of_type_JavaLangString)) {
            break label134;
          }
          paramCharSequence = paramCharSequence.substring(this.jdField_a_of_type_JavaLangString.length());
          if (paramCharSequence != null)
          {
            if (paramCharSequence.length() != 1) {
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(paramCharSequence);
            this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(1);
            break label134;
          }
        }
      }
      return;
    }
    label134:
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      InputMethodManager localInputMethodManager = this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity
 * JD-Core Version:    0.7.0.1
 */