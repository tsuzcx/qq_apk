package com.tencent.mobileqq.activity;

import Override;
import adrv;
import adrw;
import adrx;
import adry;
import adrz;
import adsa;
import adsd;
import adse;
import adsf;
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
import anzj;
import arsc;
import azoz;
import bdla;
import bdll;
import bdmc;
import bhkd;
import bhnv;
import bhsi;
import biwi;
import bjbs;
import bjji;
import blgx;
import blir;
import blji;
import blrw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.Common;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
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
  implements Handler.Callback, View.OnClickListener, biwi
{
  private long jdField_a_of_type_Long;
  public BroadcastReceiver a;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new adsd(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adsf(this);
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new adrv(this);
  View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  public AutoCompleteTextView a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blir jdField_a_of_type_Blir;
  DropdownView jdField_a_of_type_ComTencentMobileqqWidgetDropdownView;
  public PastablePwdEditText a;
  public SimpleAccount a;
  private String jdField_a_of_type_JavaLangString;
  public List<SimpleAccount> a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new adsa(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
  private boolean jdField_a_of_type_Boolean = true;
  TextWatcher jdField_b_of_type_AndroidTextTextWatcher = new adse(this);
  View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean;
  TextWatcher jdField_c_of_type_AndroidTextTextWatcher = new adrw(this);
  View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  
  public AddAccountActivity()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new adrz(this);
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
      QQToast.a(this, 2131694066, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString();
    if ((str == null) || (str.length() < 1))
    {
      QQToast.a(this, 2131694192, 0).a();
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
      BaseApplicationImpl.isFirstLogin = false;
      showDialog(0);
      this.app.login(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
    }
    for (;;)
    {
      bhkd.b();
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
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).x()))
    {
      paramButton.setText(getString(2131717816));
      return;
    }
    paramButton.setText(getString(2131693443));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.post(new AddAccountActivity.5(paramQQAppInterface), 8, null, false);
    try
    {
      bdmc.a(BaseApplicationImpl.sApplication).a(paramString);
      Common.OnLogin(BaseApplicationImpl.sApplication, paramString);
      bdla.a(BaseApplicationImpl.sApplication).a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "loginSuccess set CURRENT_ACCOUNT: " + paramString);
      }
      bhsi.a(BaseApplicationImpl.sApplication, paramString, true);
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
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.app.b(paramSimpleAccount.getUin()));
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
    bjji.a().a(paramString);
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
    this.jdField_d_of_type_AndroidViewView = findViewById(2131376869);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView = ((DropdownView)findViewById(2131370584));
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(getString(2131718536));
    Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getInputExtras(true);
    if (localObject != null) {
      ((Bundle)localObject).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText = ((PastablePwdEditText)findViewById(2131372298));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setContentDescription(getString(2131718555));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370383));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131718550));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetButton);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131376455));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131718559));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362146));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131377109);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369701);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131366668));
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131692399));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369042));
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
      this.jdField_b_of_type_AndroidViewView = findViewById(2131370385);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setClearButtonVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextClearedListener(this);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_c_of_type_AndroidTextTextWatcher);
      d();
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(3, 2131376869);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      ((LinearLayout)this.jdField_c_of_type_AndroidViewView).setOrientation(1);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        this.mSystemBarComp.setgetStatusBarVisible(true, 0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (TextView)findViewById(2131369073);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(anzj.a(2131698737));
      ((TextView)localObject).setOnClickListener(this);
      findViewById(2131369088).setVisibility(0);
      localObject = (TextView)findViewById(2131369088);
      ((TextView)localObject).setText(2131689552);
      ((TextView)localObject).setContentDescription(getString(2131689552));
      setTitle(getString(2131689552));
      this.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.b().setVisibility(8);
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void d()
  {
    View localView = findViewById(2131376731);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = findViewById(2131376869);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "only kandian tab switch, addAccount login delayTime:" + (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (azoz.a().a()) {
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
      while (!((String)localObject).equals(this.app.b(localSimpleAccount.getUin())))
      {
        i += 1;
        break label65;
        break;
      }
      this.app.updateSubAccountLogin(localSimpleAccount.getUin(), false);
      bjji.a().b((String)localObject);
      BaseApplicationImpl.sApplication.refreAccountList();
      localObject = BaseApplicationImpl.sApplication.getAllAccounts();
    } while ((localObject == null) || (this.jdField_a_of_type_JavaUtilList == null));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Blir == null)
    {
      this.jdField_a_of_type_Blir = ((blir)blji.a(this, null));
      this.jdField_a_of_type_Blir.b(2131692258);
      this.jdField_a_of_type_Blir.b(2131718293);
      this.jdField_a_of_type_Blir.c(2131690580);
      this.jdField_a_of_type_Blir.setOnDismissListener(new adrx(this));
      this.jdField_a_of_type_Blir.a(new adry(this));
    }
    if (!this.jdField_a_of_type_Blir.isShowing())
    {
      blgx.b(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView);
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Blir.show();
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    try
    {
      getWindow().setBackgroundDrawableResource(2130838778);
      setTitle(getString(2131694156));
      super.setContentView(2131559287);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        blrw.a(this);
      }
      if (this.app != null)
      {
        this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
        this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        c();
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
        {
          paramBundle = new IntentFilter();
          paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
          registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
        }
        bdll.b(this.app, "CliOper", "", "", "0X800664D", "0X800664D", 0, 0, "", "", "", "");
        bdll.b(this.app, "dc00898", "", "", "0X800735D", "0X800735D", 0, 0, "", "", "", "");
        bdll.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
        bdll.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 3, 0, "", "", "", "");
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
          this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
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
      this.app.removeHandler(getClass());
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
    azoz.a().a(false);
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
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    Message localMessage = Message.obtain();
    localMessage.what = 20140326;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 800L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (!arsc.a(getAppRuntime(), getClass(), this.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20140326);
      e();
    }
    MiniAppSecurityUtil.doClearAfterLoginSuccess(false);
  }
  
  public void onAccoutChangeFailed()
  {
    QLog.d("AddAccountActivity", 1, "onAccoutChangeFailed");
  }
  
  public boolean onBackEvent()
  {
    MiniAppSecurityUtil.doClearAfterLoginSuccess(false);
    finish();
    overridePendingTransition(2130771990, 2130772001);
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
      AuthDevUgActivity.a(3);
      bdll.a(this.app, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
      continue;
      if (this.jdField_a_of_type_Boolean)
      {
        bdll.a(this.app, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
        bdll.b(this.app, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
        if (!bhnv.d(BaseApplicationImpl.sApplication))
        {
          QQToast.a(this, 2131691989, 0).a();
        }
        else
        {
          try
          {
            ((AccountManager)this.app.getManager(0)).checkQuickRegisterAccount(this.app.getAccount(), this.app.getAppid(), "8.4.5", null);
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
          bdll.a(this.app, "dc00898", "", "", "0X80072EA", "0X80072EA", 0, 0, "", "", "", "");
          bdll.b(this.app, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
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
      localbjbs = new bjbs(this, getTitleBarHeight());
      localbjbs.a(getString(2131693451));
      return localbjbs;
    }
    bjbs localbjbs = new bjbs(this, getTitleBarHeight());
    localbjbs.a(anzj.a(2131698738));
    localbjbs.setCancelable(false);
    return localbjbs;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity
 * JD-Core Version:    0.7.0.1
 */