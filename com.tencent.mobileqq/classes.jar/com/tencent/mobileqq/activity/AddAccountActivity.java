package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.KandianConfigServlet;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.ConfigClearableEditText.OnTextClearedListener;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
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

public class AddAccountActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, ConfigClearableEditText.OnTextClearedListener
{
  private long jdField_a_of_type_Long = 0L;
  public BroadcastReceiver a;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new AddAccountActivity.7(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AddAccountActivity.9(this);
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new AddAccountActivity.1(this);
  View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  AutoCompleteTextView jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LoginFailedHelper jdField_a_of_type_ComTencentMobileqqAppLoginFailedHelper = new LoginFailedHelper();
  DropdownView jdField_a_of_type_ComTencentMobileqqWidgetDropdownView;
  PastablePwdEditText jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText;
  SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private String jdField_a_of_type_JavaLangString = null;
  List<SimpleAccount> jdField_a_of_type_JavaUtilList;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new AddAccountActivity.4(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
  private boolean jdField_a_of_type_Boolean = true;
  TextWatcher jdField_b_of_type_AndroidTextTextWatcher = new AddAccountActivity.8(this);
  View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean = false;
  TextWatcher jdField_c_of_type_AndroidTextTextWatcher = new AddAccountActivity.10(this);
  View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView = null;
  private boolean jdField_d_of_type_Boolean = false;
  
  public AddAccountActivity()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new AddAccountActivity.2(this);
  }
  
  private void a(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    if ((paramView == null) || (paramView.length() == 0) || (paramView.trim().length() == 0))
    {
      QQToast.a(this, 2131694582, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString();
    if ((str == null) || (str.length() < 1))
    {
      QQToast.a(this, 2131694725, 0).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText, 2);
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
      com.tencent.mobileqq.util.LoginSetting.jdField_a_of_type_Boolean = false;
      showDialog(0);
      this.app.login(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
    }
    for (;;)
    {
      AlbumUtil.b();
      return;
      com.tencent.mobileqq.util.LoginSetting.jdField_a_of_type_Boolean = true;
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
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).isNeedSecurityScan()))
    {
      paramButton.setText(getString(2131718962));
      return;
    }
    paramButton.setText(getString(2131693888));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.post(new AddAccountActivity.5(paramQQAppInterface), 8, null, false);
    try
    {
      StatisticCollector.getInstance(BaseApplicationImpl.sApplication).setContact(paramString);
      Common.OnLogin(BaseApplicationImpl.sApplication, paramString);
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("");
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
          return;
        }
        AppRuntime localAppRuntime = getAppRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
          this.app = ((QQAppInterface)localAppRuntime);
        }
        if (this.app != null) {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.app.getUinDisplayNameBeforeLogin(paramSimpleAccount.getUin()));
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("!@#ewaGbhkc$!!=");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("");
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
            this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText(paramIntent);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_d_of_type_AndroidViewView = findViewById(2131377297);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131371016));
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131699698));
    Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getInputExtras(true);
    if (localObject != null) {
      ((Bundle)localObject).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText = ((PastablePwdEditText)findViewById(2131372766));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setContentDescription(getString(2131699700));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370817));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131699699));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetButton);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131376864));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131719755));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362170));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131377553);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370130);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131366994));
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131692686));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369487));
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setLongClickable(true);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      if ((this.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        this.mSystemBarComp.init();
      }
      this.jdField_b_of_type_AndroidViewView = findViewById(2131370819);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setClearButtonVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextClearedListener(this);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_c_of_type_AndroidTextTextWatcher);
      d();
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(3, 2131377297);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      ((LinearLayout)this.jdField_c_of_type_AndroidViewView).setOrientation(1);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        this.mSystemBarComp.setgetStatusBarVisible(true, 0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (TextView)findViewById(2131369518);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(HardCodeUtil.a(2131699901));
      ((TextView)localObject).setOnClickListener(this);
      findViewById(2131369534).setVisibility(0);
      localObject = (TextView)findViewById(2131369534);
      ((TextView)localObject).setText(2131689558);
      ((TextView)localObject).setContentDescription(getString(2131689558));
      setTitle(getString(2131689558));
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void d()
  {
    View localView = findViewById(2131377159);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = findViewById(2131377297);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "only kandian tab switch, addAccount login delayTime:" + (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (PhoneNumLoginImpl.a().a()) {
      return;
    }
    ThreadManager.postImmediately(new AddAccountActivity.6(this), null, false);
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
      while (!((String)localObject).equals(this.app.getUinDisplayNameBeforeLogin(localSimpleAccount.getUin())))
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
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131692531);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131719448);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new AddAccountActivity.11(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new AddAccountActivity.12(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView);
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void checkUnlockForSpecial()
  {
    if ((this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.getCurrentAccountUin()) == 21)) {
      startUnlockActivity();
    }
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
    try
    {
      getWindow().setBackgroundDrawableResource(2130838979);
      setTitle(getString(2131694674));
      super.setContentView(2131559408);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        SoftInputResizeLayout.assistActivity(this);
      }
      if (this.app != null)
      {
        this.app.setHandler(LoginProgressClazz.class, this.jdField_a_of_type_MqqOsMqqHandler);
        this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        c();
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
        {
          paramBundle = new IntentFilter();
          paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
          registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
        }
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
        getWindow().setBackgroundDrawableResource(2131165210);
        continue;
        paramBundle = getAppRuntime();
        if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface)))
        {
          this.app = ((QQAppInterface)paramBundle);
          this.app.setHandler(LoginProgressClazz.class, this.jdField_a_of_type_MqqOsMqqHandler);
          this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      this.app.removeHandler(LoginProgressClazz.class);
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20140326);
    }
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
      QLog.e("AddAccountActivity", 1, new Object[] { "dismiss progress dialog error : ", localException.getMessage() });
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "doOnNewIntent");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  public void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setClearButtonVisible(false);
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "onResume in AddAccountActivity");
    }
    if (this.app != null) {
      this.app.cancelSyncOnlineFriend(-1L);
    }
    PhoneNumLoginImpl.a().a(false);
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.d("AddAccountActivity", 1, "mShouldAutoLogin: true, then login");
      this.jdField_b_of_type_Boolean = false;
      a(this.jdField_a_of_type_AndroidWidgetButton);
    }
    if (this.jdField_c_of_type_Boolean) {}
    try
    {
      showDialog(0);
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AddAccountActivity", 1, new Object[] { "show progress dialog error : ", localException.getMessage() });
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
      } while (isFinishing());
      try
      {
        dismissDialog(0);
        return true;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "recv message FINISH_ACTIVITY.. finish activity");
      }
      finish();
      return true;
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20140326);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "handleMessage  LOGIN_DO_NEXT");
      }
      e();
      return true;
    } while (isFinishing());
    this.jdField_c_of_type_Boolean = true;
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("AddAccountActivity", 1, "onAccountChanged");
    this.app.removeHandler(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.setHandler(LoginProgressClazz.class, this.jdField_a_of_type_MqqOsMqqHandler);
    Message localMessage = Message.obtain();
    localMessage.what = 20140326;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 800L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (!KandianConfigServlet.a(getAppRuntime(), getClass(), this.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20140326);
      e();
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).doClearAfterLoginSuccess(false);
  }
  
  public void onAccoutChangeFailed()
  {
    QLog.d("AddAccountActivity", 1, "onAccoutChangeFailed");
  }
  
  public boolean onBackEvent()
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).doClearAfterLoginSuccess(false);
    finish();
    overridePendingTransition(2130771979, 2130772003);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      LoginStaticField.a(3);
      ReportController.a(this.app, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
      continue;
      if (this.jdField_a_of_type_Boolean)
      {
        ReportController.a(this.app, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
        if (!NetworkUtil.d(BaseApplicationImpl.sApplication))
        {
          QQToast.a(this, 2131692257, 0).a();
        }
        else
        {
          try
          {
            ((AccountManager)this.app.getManager(0)).checkQuickRegisterAccount(this.app.getAccount(), this.app.getAppid(), "8.5.5", null);
            showDialog(1);
            this.jdField_a_of_type_Boolean = false;
            new Handler().postDelayed(new AddAccountActivity.3(this), 1000L);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          ReportController.a(this.app, "dc00898", "", "", "0X80072EA", "0X80072EA", 0, 0, "", "", "", "");
          ReportController.b(this.app, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
          b();
          continue;
          onBackEvent();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      localQQProgressDialog.a(getString(2131699693));
      return localQQProgressDialog;
    }
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(HardCodeUtil.a(2131699902));
    localQQProgressDialog.setCancelable(false);
    return localQQProgressDialog;
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.getCurrentAccountUin()) == 21)) {
      startUnlockActivity();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity
 * JD-Core Version:    0.7.0.1
 */