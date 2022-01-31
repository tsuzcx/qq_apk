package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.Common;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.MTAReportController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.ConfigClearableEditText.OnTextClearedListener;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SoftInputResizeLayout;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import rem;
import ren;
import reo;
import rep;
import req;
import reu;
import rev;
import rew;
import rex;
import rey;
import rez;

public class AddAccountActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, ConfigClearableEditText.OnTextClearedListener
{
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new rew(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new rey(this);
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new rem(this);
  View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  public AutoCompleteTextView a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public CustomSafeEditText a;
  DropdownView jdField_a_of_type_ComTencentMobileqqWidgetDropdownView;
  public SimpleAccount a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new req(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
  private boolean jdField_a_of_type_Boolean = true;
  TextWatcher jdField_b_of_type_AndroidTextTextWatcher = new rex(this);
  View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean;
  TextWatcher jdField_c_of_type_AndroidTextTextWatcher = new rez(this);
  View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private View d;
  
  private void a(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    if ((paramView == null) || (paramView.length() == 0) || (paramView.trim().length() == 0))
    {
      QQToast.a(this, 2131433203, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().toString();
    if ((str == null) || (str.length() < 1))
    {
      QQToast.a(this, 2131433206, 0).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText, 2);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
    {
      str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i)).getUin() == null)) {}
        while (!((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i)).getUin().equals(str))
        {
          i += 1;
          break;
        }
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "login");
    }
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      BaseApplicationImpl.isFirstLogin = false;
      showDialog(0);
      this.app.login(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
    }
    for (;;)
    {
      AlbumUtil.b();
      return;
      BaseApplicationImpl.isFirstLogin = true;
      try
      {
        showDialog(0);
        getAppRuntime().login(paramView, arrayOfByte, null);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void a(Button paramButton)
  {
    if (paramButton == null) {
      return;
    }
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).s()))
    {
      paramButton.setText(getString(2131435130));
      return;
    }
    paramButton.setText(getString(2131433180));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.post(new reu(paramQQAppInterface), 8, null, false);
    try
    {
      StatisticCollector.a(BaseApplicationImpl.sApplication).a(paramString);
      Common.OnLogin(BaseApplicationImpl.sApplication, paramString);
      MTAReportController.a(BaseApplicationImpl.sApplication).a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "loginSuccess set CURRENT_ACCOUNT: " + paramString);
      }
      SharedPreUtils.a(BaseApplicationImpl.sApplication, paramString, true);
      BaseApplicationImpl.sApplication.refreAccountList();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddAccountActivity", 2, "loginSuccess throwable: " + paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
          return;
        }
        AppRuntime localAppRuntime = getAppRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
          this.app = ((QQAppInterface)localAppRuntime);
        }
        if (this.app != null) {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.app.b(paramSimpleAccount.getUin()));
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("!@#ewaGbhkc$!!=");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
        }
      }
      finally {}
    }
  }
  
  private void a(String paramString)
  {
    OpenProxy.a().a(paramString);
    setResult(-1);
    finish();
  }
  
  private boolean a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        String str = paramIntent.getString("uin");
        if ((str != null) && (str.length() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(str);
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0)) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText(paramIntent);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private void c()
  {
    this.d = findViewById(2131362844);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131364806));
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131427434));
    Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getInputExtras(true);
    if (localObject != null) {
      ((Bundle)localObject).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText = ((CustomSafeEditText)findViewById(2131364807));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setContentDescription(getString(2131427435));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364318));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131427437));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetButton);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364811));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131427439));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364803));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364804);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364809);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131364810));
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131433246));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363227));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.sApplication.getAllAccounts();
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setLongClickable(false);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      if ((this.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        this.mSystemBarComp.init();
      }
      this.jdField_b_of_type_AndroidViewView = findViewById(2131364805);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextClearedListener(this);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_c_of_type_AndroidTextTextWatcher);
      d();
      localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      this.d.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(3, 2131362844);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      ((LinearLayout)this.jdField_c_of_type_AndroidViewView).setOrientation(1);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, ImmersiveUtils.a(this), 0, 0);
        this.mSystemBarComp.setgetStatusBarVisible(true, 0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (TextView)findViewById(2131363410);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("取消");
      ((TextView)localObject).setOnClickListener(this);
      findViewById(2131363363).setVisibility(0);
      localObject = (TextView)findViewById(2131363363);
      ((TextView)localObject).setText(2131433210);
      ((TextView)localObject).setContentDescription(getString(2131433210));
      setTitle(getString(2131433210));
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void d()
  {
    View localView = findViewById(2131363226);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = findViewById(2131362844);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  public void a()
  {
    libsafeedit.clearPassBuffer();
    getAppRuntime().stopPCActivePolling("clearPassInput");
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText() == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() == null)) {}
    label65:
    Object localObject;
    label114:
    do
    {
      return;
      int i = 0;
      SimpleAccount localSimpleAccount;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localSimpleAccount != null) {
          break label114;
        }
      }
      while (!((String)localObject).equals(this.app.b(localSimpleAccount.getUin())))
      {
        i += 1;
        break label65;
        break;
      }
      this.app.updateSubAccountLogin(localSimpleAccount.getUin(), false);
      OpenProxy.a().b((String)localObject);
      BaseApplicationImpl.sApplication.refreAccountList();
      localObject = BaseApplicationImpl.sApplication.getAllAccounts();
    } while ((localObject == null) || (this.jdField_a_of_type_JavaUtilList == null));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131433188);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131433189);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131432998);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ren(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new reo(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected void checkUnlockForSpecial()
  {
    if ((this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.getCurrentAccountUin()) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    try
    {
      getWindow().setBackgroundDrawableResource(2130837505);
      setTitle(getString(2131435574));
      super.setContentView(2130969039);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        SoftInputResizeLayout.a(this);
      }
      if (this.app != null)
      {
        this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
        this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        c();
        ReportController.b(this.app, "CliOper", "", "", "0X800664D", "0X800664D", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X800735D", "0X800735D", 0, 0, "", "", "", "");
        ReportController.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
        ReportController.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 3, 0, "", "", "", "");
        return true;
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        getWindow().setBackgroundDrawableResource(2131493046);
        continue;
        paramBundle = getAppRuntime();
        if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface)))
        {
          this.app = ((QQAppInterface)paramBundle);
          this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
          this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      this.app.removeHandler(getClass());
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "doOnNewIntent");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  protected void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
    if (NotificationActivity.a != null)
    {
      NotificationActivity.a.finish();
      NotificationActivity.a = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "onResume in AddAccountActivity");
    }
    if (this.app != null) {
      this.app.a(-1L);
    }
    PhoneNumLoginImpl.a().a(false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!isFinishing())
      {
        try
        {
          dismissDialog(0);
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AddAccountActivity", 2, "recv message FINISH_ACTIVITY.. finish activity");
        }
        finish();
      }
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("AddAccountActivity", 1, "onAccountChanged");
    this.app.removeHandler(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (PhoneNumLoginImpl.a().a()) {
      return;
    }
    ThreadManager.postImmediately(new rev(this), null, false);
    a(this.app.getAccount());
    if (!isFinishing()) {}
    try
    {
      dismissDialog(0);
      PatternLockUtils.setFirstEnterAfterLoginState(this, this.app.getAccount(), true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onAccoutChangeFailed()
  {
    QLog.d("AddAccountActivity", 1, "onAccoutChangeFailed");
  }
  
  protected boolean onBackEvent()
  {
    finish();
    overridePendingTransition(2131034131, 2131034135);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131364318: 
    case 2131364811: 
      do
      {
        return;
        a(paramView);
        ReportController.a(this.app, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
        return;
      } while (!this.jdField_a_of_type_Boolean);
      ReportController.a(this.app, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
      if (!NetworkUtil.d(BaseApplicationImpl.sApplication))
      {
        QQToast.a(this, 2131432992, 0).a();
        return;
      }
      try
      {
        ((AccountManager)this.app.getManager(0)).checkQuickRegisterAccount(this.app.getAccount(), this.app.getAppid(), "7.6.0", null);
        showDialog(1);
        this.jdField_a_of_type_Boolean = false;
        new Handler().postDelayed(new rep(this), 1000L);
        return;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
        }
      }
    case 2131364810: 
      ReportController.a(this.app, "dc00898", "", "", "0X80072EA", "0X80072EA", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
      b();
      return;
    }
    onBackEvent();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      localQQProgressDialog.a(getString(2131433193));
      return localQQProgressDialog;
    }
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a("请稍候...");
    localQQProgressDialog.setCancelable(false);
    return localQQProgressDialog;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.getCurrentAccountUin()) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity
 * JD-Core Version:    0.7.0.1
 */