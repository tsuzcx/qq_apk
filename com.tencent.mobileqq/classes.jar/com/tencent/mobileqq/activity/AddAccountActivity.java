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
import com.tencent.mobileqq.app.LoginForbiddenDialogReporter;
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
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
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
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
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

@RoutePage(desc="添加帐户页面", path="/base/addAccount")
public class AddAccountActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, ConfigClearableEditText.OnTextClearedListener
{
  public static final int CLEAR_PROGRESS_DIALOG = 2001;
  private static final int DIALOG_LOADING = 1;
  private static final int DIALOG_PROGRESS = 0;
  static final String FAKE_PASSWORD = "!@#ewaGbhkc$!!=";
  public static final int FINISH_ACTIVITY = 2004;
  private static final int INPUT_FLAG_NUMBER_SOGOU = 1;
  private static final String INPUT_TYPE_ON_START_SOGOU = "INPUT_TYPE_ON_START";
  public static final int SHOW_PROGRESS_DIALOG = 2002;
  private static final String TAG = "AddAccountActivity";
  private AccountObserver accountObserver = new AddAccountActivity.4(this);
  private boolean actionSheetHasClick = false;
  TextWatcher autoTextViewWatch = new AddAccountActivity.10(this);
  private View.OnClickListener delListener = new AddAccountActivity.9(this);
  DropdownView mAccountDropdownView;
  private ActionSheet mActionSheet = null;
  public BroadcastReceiver mAutoLoginReceiver = new AddAccountActivity.2(this);
  AutoCompleteTextView mAutoTextAccount;
  private boolean mCanRegister = true;
  SimpleAccount mCurrentAccount;
  ImageView mDelIcon;
  private Button mFindPassBtn;
  private View.OnFocusChangeListener mFocusChangeListener = new AddAccountActivity.1(this);
  MqqHandler mHandler = new MqqHandler(this);
  private InputMethodManager mInputManager;
  private boolean mIsGotoLoginView = false;
  Button mLoginBtn;
  private LoginFailedHelper mLoginFailedHelper = new LoginFailedHelper();
  View mLoginHelpLayout;
  View mLoginInputAreaView;
  private boolean mNeedShowProgress;
  PastablePwdEditText mPwdEdit;
  private Button mRegBtn;
  RelativeLayout mRootLayout;
  View mScrollAreaLayout;
  private boolean mShouldAutoLogin = false;
  List<SimpleAccount> mSimpleAccoutList;
  private TextView mTitleTextViewLeft;
  private View mTitleView = null;
  private String mTmpEditStr = null;
  TextWatcher onTextChangeForAccount = new AddAccountActivity.8(this);
  TextWatcher onTextChangeForPwd = new AddAccountActivity.7(this);
  private long startDelayTime = 0L;
  
  private void doAfterLoginSuccess()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("only kandian tab switch, addAccount login delayTime:");
      localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis() - this.startDelayTime);
      QLog.d("AddAccountActivity", 2, localStringBuilder.toString());
    }
    if (PhoneNumLoginImpl.a().a()) {
      return;
    }
    ThreadManager.postImmediately(new AddAccountActivity.6(this), null, false);
    loginSuccess(this.app.getAccount());
    if (!isFinishing()) {
      try
      {
        dismissDialog(0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    PatternLockUtils.setFirstEnterAfterLoginState(this, this.app.getAccount(), true);
  }
  
  private boolean getNewUin(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        String str = paramIntent.getString("uin");
        if ((str != null) && (str.length() > 0))
        {
          this.mAutoTextAccount.setText(str);
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0)) {
            this.mPwdEdit.setText(paramIntent);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private void initViews()
  {
    this.mTitleView = findViewById(2131376752);
    this.mAccountDropdownView = ((DropdownView)findViewById(2131370650));
    this.mAutoTextAccount = this.mAccountDropdownView.a();
    this.mAutoTextAccount.setDropDownBackgroundDrawable(null);
    this.mAutoTextAccount.setContentDescription(getString(2131699831));
    Object localObject = this.mAutoTextAccount.getInputExtras(true);
    if (localObject != null) {
      ((Bundle)localObject).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.mPwdEdit = ((PastablePwdEditText)findViewById(2131372343));
    this.mPwdEdit.setContentDescription(getString(2131699833));
    this.mLoginBtn = ((Button)findViewById(2131370448));
    this.mLoginBtn.setContentDescription(getString(2131699832));
    this.mLoginBtn.setOnClickListener(this);
    isNeedSecurityScan(this.mLoginBtn);
    this.mRegBtn = ((Button)findViewById(2131376354));
    this.mRegBtn.setContentDescription(getString(2131719479));
    this.mRegBtn.setOnClickListener(this);
    this.mRootLayout = ((RelativeLayout)findViewById(2131362196));
    this.mScrollAreaLayout = findViewById(2131376995);
    this.mLoginHelpLayout = findViewById(2131369801);
    this.mFindPassBtn = ((Button)findViewById(2131366847));
    this.mFindPassBtn.setContentDescription(getString(2131692643));
    this.mTitleTextViewLeft = ((TextView)findViewById(2131369202));
    this.mInputManager = ((InputMethodManager)getSystemService("input_method"));
    this.mDelIcon = this.mAccountDropdownView.a();
    this.mDelIcon.setOnClickListener(this.delListener);
    localObject = this.mSimpleAccoutList;
    if (localObject == null) {
      this.mSimpleAccoutList = new ArrayList();
    } else {
      ((List)localObject).clear();
    }
    localObject = BaseApplicationImpl.sApplication.getAllAccounts();
    if (localObject != null) {
      this.mSimpleAccoutList.addAll((Collection)localObject);
    }
    this.mAutoTextAccount.addTextChangedListener(this.onTextChangeForAccount);
    this.mPwdEdit.addTextChangedListener(this.onTextChangeForPwd);
    this.mAutoTextAccount.setOnFocusChangeListener(this.mFocusChangeListener);
    this.mPwdEdit.setOnFocusChangeListener(this.mFocusChangeListener);
    this.mPwdEdit.setLongClickable(true);
    this.mFindPassBtn.setOnClickListener(this);
    if ((this.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.mSystemBarComp.init();
    }
    this.mLoginInputAreaView = findViewById(2131370450);
    this.mAutoTextAccount.clearFocus();
    this.mPwdEdit.clearFocus();
    this.mPwdEdit.setClearButtonVisible(false);
    this.mPwdEdit.setTextClearedListener(this);
    this.mAutoTextAccount.addTextChangedListener(this.autoTextViewWatch);
    setAccSoft();
    localObject = (RelativeLayout.LayoutParams)this.mTitleView.getLayoutParams();
    this.mTitleView.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, 2131376752);
    this.mScrollAreaLayout.setLayoutParams(localLayoutParams);
    ((LinearLayout)this.mScrollAreaLayout).setOrientation(1);
    this.mLoginInputAreaView.setVisibility(0);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      this.mSystemBarComp.setgetStatusBarVisible(true, 0);
    }
    this.mTitleTextViewLeft.setVisibility(8);
    localObject = (TextView)findViewById(2131369233);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(HardCodeUtil.a(2131700042));
    ((TextView)localObject).setOnClickListener(this);
    findViewById(2131369249).setVisibility(0);
    localObject = (TextView)findViewById(2131369249);
    ((TextView)localObject).setText(2131689590);
    ((TextView)localObject).setContentDescription(getString(2131689590));
    setTitle(getString(2131689590));
    this.mAccountDropdownView.b().setVisibility(8);
  }
  
  private void isNeedSecurityScan(Button paramButton)
  {
    if (paramButton == null) {
      return;
    }
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).isNeedSecurityScan()))
    {
      paramButton.setText(getString(2131718678));
      return;
    }
    paramButton.setText(getString(2131693842));
  }
  
  private void login(View paramView)
  {
    if (paramView != null) {
      this.mInputManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    paramView = this.mAutoTextAccount.getText().toString();
    byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    if ((paramView != null) && (paramView.length() != 0) && (paramView.trim().length() != 0))
    {
      String str = this.mPwdEdit.getText().toString();
      if ((str != null) && (str.length() >= 1))
      {
        if ((this.mCurrentAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
        {
          str = this.mAutoTextAccount.getText().toString();
          int i = 0;
          while (i < this.mSimpleAccoutList.size())
          {
            if ((this.mSimpleAccoutList.get(i) != null) && (((SimpleAccount)this.mSimpleAccoutList.get(i)).getUin() != null) && (((SimpleAccount)this.mSimpleAccoutList.get(i)).getUin().equals(str)))
            {
              this.mCurrentAccount = ((SimpleAccount)this.mSimpleAccoutList.get(i));
              break;
            }
            i += 1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("AddAccountActivity", 2, "login");
        }
        if (this.mCurrentAccount != null)
        {
          com.tencent.mobileqq.util.LoginSetting.a = false;
          showDialog(0);
          this.app.login(this.mCurrentAccount);
        }
        else
        {
          com.tencent.mobileqq.util.LoginSetting.a = true;
          try
          {
            showDialog(0);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          getAppRuntime().login(paramView, arrayOfByte, null);
        }
        AlbumUtil.b();
        return;
      }
      QQToast.a(this, 2131694703, 0).a();
      this.mPwdEdit.requestFocus();
      this.mInputManager.showSoftInput(this.mPwdEdit, 2);
      return;
    }
    QQToast.a(this, 2131694550, 0).a();
    this.mAutoTextAccount.requestFocus();
    this.mInputManager.showSoftInput(this.mAutoTextAccount, 2);
  }
  
  private void loginSuccess(String paramString)
  {
    OpenProxy.a().a(paramString);
    setResult(-1);
    finish();
  }
  
  public static void loginSuccessInit(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.post(new AddAccountActivity.5(paramQQAppInterface), 8, null, false);
    try
    {
      StatisticCollector.getInstance(BaseApplicationImpl.sApplication).setContact(paramString);
      QQCrashReportManager.a(paramString);
      Common.OnLogin(BaseApplicationImpl.sApplication, paramString);
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loginSuccess throwable: ");
        localStringBuilder.append(paramQQAppInterface);
        QLog.d("AddAccountActivity", 2, localStringBuilder.toString());
      }
      paramQQAppInterface.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("loginSuccess set CURRENT_ACCOUNT: ");
      paramQQAppInterface.append(paramString);
      QLog.d("AddAccountActivity", 2, paramQQAppInterface.toString());
    }
    SharedPreUtils.a(BaseApplicationImpl.sApplication, paramString, true);
    BaseApplicationImpl.sApplication.refreAccountList();
  }
  
  private void setAccSoft()
  {
    View localView = findViewById(2131376636);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = findViewById(2131376752);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private void setupLoginedAccount(SimpleAccount paramSimpleAccount)
  {
    try
    {
      this.mPwdEdit.removeTextChangedListener(this.onTextChangeForPwd);
      this.mCurrentAccount = null;
      if (paramSimpleAccount == null)
      {
        this.mPwdEdit.setText("");
      }
      else
      {
        AppRuntime localAppRuntime = getAppRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
          this.app = ((QQAppInterface)localAppRuntime);
        }
        if (this.app != null) {
          this.mAutoTextAccount.setText(this.app.getUinDisplayNameBeforeLogin(paramSimpleAccount.getUin()));
        }
        this.mAutoTextAccount.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.mCurrentAccount = paramSimpleAccount;
          this.mPwdEdit.setText("!@#ewaGbhkc$!!=");
        }
        else
        {
          this.mPwdEdit.setText("");
        }
      }
      this.mPwdEdit.addTextChangedListener(this.onTextChangeForPwd);
      return;
    }
    finally {}
  }
  
  public void afterTextCleared()
  {
    libsafeedit.clearPassBuffer();
    getAppRuntime().stopPCActivePolling("clearPassInput");
    Object localObject1 = this.mSimpleAccoutList;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = this.mAutoTextAccount;
      if ((localObject1 != null) && (((AutoCompleteTextView)localObject1).getText() != null))
      {
        if (this.mAutoTextAccount.getText().toString() == null) {
          return;
        }
        int i = 0;
        while (i < this.mSimpleAccoutList.size())
        {
          localObject1 = this.mAutoTextAccount.getText().toString();
          Object localObject2 = (SimpleAccount)this.mSimpleAccoutList.get(i);
          if ((localObject2 != null) && (((String)localObject1).equals(this.app.getUinDisplayNameBeforeLogin(((SimpleAccount)localObject2).getUin()))))
          {
            this.app.updateSubAccountLogin(((SimpleAccount)localObject2).getUin(), false);
            OpenProxy.a().b((String)localObject1);
            BaseApplicationImpl.sApplication.refreAccountList();
            localObject1 = BaseApplicationImpl.sApplication.getAllAccounts();
            if (localObject1 == null) {
              break;
            }
            localObject2 = this.mSimpleAccoutList;
            if (localObject2 == null) {
              break;
            }
            ((List)localObject2).clear();
            this.mSimpleAccoutList.addAll((Collection)localObject1);
            return;
          }
          i += 1;
        }
      }
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    try
    {
      getWindow().setBackgroundDrawableResource(2130838739);
    }
    catch (Throwable paramBundle)
    {
      label19:
      break label19;
    }
    getWindow().setBackgroundDrawableResource(2131165236);
    setTitle(getString(2131694643));
    super.setContentView(2131559283);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      SoftInputResizeLayout.assistActivity(this);
    }
    if (this.app != null)
    {
      this.app.setHandler(LoginProgressClazz.class, this.mHandler);
      this.app.registObserver(this.accountObserver);
    }
    else
    {
      paramBundle = getAppRuntime();
      if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface)))
      {
        this.app = ((QQAppInterface)paramBundle);
        this.app.setHandler(LoginProgressClazz.class, this.mHandler);
        this.app.registObserver(this.accountObserver);
      }
    }
    initViews();
    if (this.mAutoLoginReceiver != null)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
      registerReceiver(this.mAutoLoginReceiver, paramBundle);
    }
    ReportController.b(this.app, "CliOper", "", "", "0X800664D", "0X800664D", 0, 0, "", "", "", "");
    ReportController.b(this.app, "dc00898", "", "", "0X800735D", "0X800735D", 0, 0, "", "", "", "");
    ReportController.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
    ReportController.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 3, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.unRegistObserver(this.accountObserver);
      this.app.removeHandler(LoginProgressClazz.class);
    }
    Object localObject = this.mHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeMessages(2005);
    }
    localObject = this.mAutoLoginReceiver;
    if (localObject != null) {
      unregisterReceiver((BroadcastReceiver)localObject);
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
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    getNewUin(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "doOnNewIntent");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.mInputManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  protected void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    if (this.mIsGotoLoginView) {
      this.app.registObserver(this.accountObserver);
    }
    this.mIsGotoLoginView = false;
    this.mAutoTextAccount.clearFocus();
    this.mDelIcon.setVisibility(8);
    this.mPwdEdit.clearFocus();
    this.mPwdEdit.setClearButtonVisible(false);
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "onResume in AddAccountActivity");
    }
    if (this.app != null) {
      this.app.cancelSyncOnlineFriend(-1L);
    }
    PhoneNumLoginImpl.a().a(false);
    if (this.mShouldAutoLogin)
    {
      QLog.d("AddAccountActivity", 1, "mShouldAutoLogin: true, then login");
      this.mShouldAutoLogin = false;
      login(this.mLoginBtn);
    }
    if (this.mNeedShowProgress) {
      try
      {
        showDialog(0);
        this.mNeedShowProgress = false;
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AddAccountActivity", 1, new Object[] { "show progress dialog error : ", localException.getMessage() });
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2003: 
    default: 
      return true;
    case 2005: 
      paramMessage = this.mHandler;
      if (paramMessage != null) {
        paramMessage.removeMessages(2005);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "handleMessage  LOGIN_DO_NEXT");
      }
      doAfterLoginSuccess();
      return true;
    case 2004: 
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "recv message FINISH_ACTIVITY.. finish activity");
      }
      finish();
      return true;
    case 2002: 
      if (!isFinishing())
      {
        this.mNeedShowProgress = true;
        return true;
      }
      break;
    case 2001: 
      if (!isFinishing()) {
        try
        {
          dismissDialog(0);
          return true;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
      }
      break;
    }
    return true;
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
    this.app.setHandler(LoginProgressClazz.class, this.mHandler);
    Message localMessage = Message.obtain();
    localMessage.what = 2005;
    this.mHandler.sendMessageDelayed(localMessage, 800L);
    this.startDelayTime = System.currentTimeMillis();
    if (!KandianConfigServlet.a(getAppRuntime(), getClass(), this.startDelayTime))
    {
      this.mHandler.removeMessages(2005);
      doAfterLoginSuccess();
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).doClearAfterLoginSuccess(false);
    LoginForbiddenDialogReporter.a(getAppRuntime(), this.mAutoTextAccount.getText().toString(), 3);
  }
  
  protected void onAccoutChangeFailed()
  {
    QLog.d("AddAccountActivity", 1, "onAccoutChangeFailed");
  }
  
  protected boolean onBackEvent()
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).doClearAfterLoginSuccess(false);
    finish();
    overridePendingTransition(2130771991, 2130772015);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131376354: 
      if (this.mCanRegister)
      {
        ReportController.a(this.app, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
        if (!NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication))
        {
          QQToast.a(this, 2131692183, 0).a();
        }
        else
        {
          try
          {
            ((AccountManager)this.app.getManager(0)).checkQuickRegisterAccount(this.app.getAccount(), this.app.getAppid(), "8.7.0", null);
            showDialog(1);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          this.mCanRegister = false;
          new Handler().postDelayed(new AddAccountActivity.3(this), 1000L);
        }
      }
      break;
    case 2131370448: 
      login(paramView);
      LoginStaticField.a(3);
      ReportController.a(this.app, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
      break;
    case 2131369233: 
      onBackEvent();
      break;
    case 2131366847: 
      ReportController.a(this.app, "dc00898", "", "", "0X80072EA", "0X80072EA", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
      showActionSheet();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      localQQProgressDialog.a(HardCodeUtil.a(2131700043));
      localQQProgressDialog.setCancelable(false);
      return localQQProgressDialog;
    }
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(getString(2131699826));
    return localQQProgressDialog;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      InputMethodManager localInputMethodManager = this.mInputManager;
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
      }
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected void showActionSheet()
  {
    if (this.mActionSheet == null)
    {
      this.mActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.mActionSheet.addButton(2131692483);
      this.mActionSheet.addButton(2131719166);
      this.mActionSheet.addCancelButton(2131690728);
      this.mActionSheet.setOnDismissListener(new AddAccountActivity.11(this));
      this.mActionSheet.setOnButtonClickListener(new AddAccountActivity.12(this));
    }
    if (!this.mActionSheet.isShowing())
    {
      InputMethodUtil.b(this.mAutoTextAccount);
      this.actionSheetHasClick = false;
      this.mActionSheet.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity
 * JD-Core Version:    0.7.0.1
 */