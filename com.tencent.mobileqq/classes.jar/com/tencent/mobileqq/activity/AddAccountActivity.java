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
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.LoginForbiddenDialogReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.splashlogo.KandianConfigServlet;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI.OnInteractionListener;
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
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
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
  extends QBaseActivity
  implements Handler.Callback, AddAccountBaseUI.OnInteractionListener
{
  public static final int CLEAR_PROGRESS_DIALOG = 2001;
  private static final int DIALOG_LOADING = 1;
  private static final int DIALOG_PROGRESS = 0;
  protected static final String FAKE_PASSWORD = "!@#ewaGbhkc$!!=";
  public static final int FINISH_ACTIVITY = 2004;
  public static final int SHOW_PROGRESS_DIALOG = 2002;
  private static final String TAG = "AddAccountActivity";
  private AccountObserver accountObserver = new AddAccountActivity.4(this);
  protected QQAppInterface app;
  TextWatcher autoTextViewWatch = new AddAccountActivity.8(this);
  public BroadcastReceiver mAutoLoginReceiver = new AddAccountActivity.2(this);
  protected AddAccountBaseUI mBaseUI = new AddAccountBaseUI(this, this);
  private boolean mCanRegister = true;
  SimpleAccount mCurrentAccount;
  MqqHandler mHandler = new MqqHandler(this);
  private boolean mIsGotoLoginView = false;
  private LoginFailedHelper mLoginFailedHelper = new LoginFailedHelper();
  private boolean mNeedShowProgress;
  private boolean mShouldAutoLogin = false;
  List<SimpleAccount> mSimpleAccoutList;
  private String mTmpEditStr = null;
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
    if (PhoneNumLoginImpl.a().b()) {
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
          this.mBaseUI.a(str);
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0)) {
            this.mBaseUI.b(paramIntent);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private void initData()
  {
    List localList = this.mSimpleAccoutList;
    if (localList == null) {
      this.mSimpleAccoutList = new ArrayList();
    } else {
      localList.clear();
    }
    localList = BaseApplicationImpl.sApplication.getAllAccounts();
    if (localList != null) {
      this.mSimpleAccoutList.addAll(localList);
    }
  }
  
  private void isNeedSecurityScan(Button paramButton)
  {
    if (paramButton == null) {
      return;
    }
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).isNeedSecurityScan()))
    {
      paramButton.setText(getString(2131916179));
      return;
    }
    paramButton.setText(getString(2131891418));
  }
  
  private void login()
  {
    this.mBaseUI.t();
    String str1 = this.mBaseUI.m();
    byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    if ((str1 != null) && (str1.length() != 0) && (str1.trim().length() != 0))
    {
      String str2 = this.mBaseUI.n();
      if ((str2 != null) && (str2.length() >= 1))
      {
        if ((this.mCurrentAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
        {
          str2 = this.mBaseUI.m();
          int i = 0;
          while (i < this.mSimpleAccoutList.size())
          {
            if ((this.mSimpleAccoutList.get(i) != null) && (((SimpleAccount)this.mSimpleAccoutList.get(i)).getUin() != null) && (((SimpleAccount)this.mSimpleAccoutList.get(i)).getUin().equals(str2)))
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
          getAppRuntime().login(str1, arrayOfByte, null);
        }
        AlbumUtil.b();
        return;
      }
      QQToast.makeText(this, 2131892395, 0).show();
      this.mBaseUI.s();
      return;
    }
    QQToast.makeText(this, 2131892234, 0).show();
    this.mBaseUI.r();
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
  
  private void onBeforeBackHandle()
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).doClearAfterLoginSuccess(false);
  }
  
  private void onRegisterClick()
  {
    if (this.mCanRegister)
    {
      ReportController.a(this.app, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
      if (!NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication))
      {
        QQToast.makeText(this, 2131889169, 0).show();
        return;
      }
      try
      {
        ((AccountManager)this.app.getManager(0)).checkQuickRegisterAccount(this.app.getAccount(), this.app.getAppid(), "8.8.17", null);
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
  
  private void setupLoginedAccount()
  {
    try
    {
      EditText localEditText = this.mBaseUI.l();
      localEditText.removeTextChangedListener(this.onTextChangeForPwd);
      this.mCurrentAccount = null;
      localEditText.setText("");
      localEditText.addTextChangedListener(this.onTextChangeForPwd);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
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
  
  public void doLogin()
  {
    login();
    LoginStaticField.a(3);
    ReportController.a(this.app, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    try
    {
      getWindow().setBackgroundDrawableResource(2130838958);
    }
    catch (Throwable paramBundle)
    {
      label19:
      int i;
      break label19;
    }
    getWindow().setBackgroundDrawableResource(2131165426);
    i = getIntent().getIntExtra("fromWhereExactly", 1);
    paramBundle = new StringBuilder();
    paramBundle.append("doOnCreate AddAccountActivity-login-succeed, from : ");
    paramBundle.append(i);
    QLog.d("AddAccountActivity", 2, paramBundle.toString());
    ReportController.b(this.app, "dc00898", "", "", "0X800BDEB", "0X800BDEB", i, 0, "", "", "", "");
    initViews();
    initData();
    paramBundle = this.app;
    if (paramBundle != null)
    {
      paramBundle.setHandler(LoginProgressClazz.class, this.mHandler);
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
    Object localObject = this.app;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).unRegistObserver(this.accountObserver);
      this.app.removeHandler(LoginProgressClazz.class);
    }
    localObject = this.mHandler;
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
    this.mBaseUI.t();
  }
  
  protected void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    this.mBaseUI.k().clearFocus();
    this.mBaseUI.l().clearFocus();
    if (this.mIsGotoLoginView) {
      this.app.registObserver(this.accountObserver);
    }
    this.mIsGotoLoginView = false;
    if (QLog.isColorLevel()) {
      QLog.d("AddAccountActivity", 2, "onResume in AddAccountActivity");
    }
    QQAppInterface localQQAppInterface = this.app;
    if (localQQAppInterface != null) {
      localQQAppInterface.cancelSyncOnlineFriend(-1L);
    }
    PhoneNumLoginImpl.a().a(false);
    if (this.mShouldAutoLogin)
    {
      QLog.d("AddAccountActivity", 1, "mShouldAutoLogin: true, then login");
      this.mShouldAutoLogin = false;
      login();
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
  
  public void doPhoneLogin()
  {
    ReportController.a(this.app, "dc00898", "", "", "0X800AFD8", "0X800AFD8", 0, 0, "", "", "", "");
    ReportController.b(this.app, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
    boolean bool = getIntent().getBooleanExtra("login_from_account_change", false);
    Intent localIntent = new Intent();
    localIntent.putExtra("login_from_account_change", bool);
    localIntent.putExtra("entrance", "fromAddAccount");
    RouteUtils.a(this, localIntent, "/base/safe/loginPhoneNumActivity");
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
  
  protected void initViews()
  {
    this.mBaseUI.a(2131896982);
    this.mBaseUI.a(getString(2131896989), new AddAccountActivity.1(this)).setContentDescription(getString(2131917042));
    this.mBaseUI.k().addTextChangedListener(this.autoTextViewWatch);
    this.mBaseUI.l().addTextChangedListener(this.onTextChangeForPwd);
    this.mBaseUI.q();
    isNeedSecurityScan(this.mBaseUI.p());
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
    LoginForbiddenDialogReporter.a(getAppRuntime(), this.mBaseUI.m(), 3);
  }
  
  protected void onAccoutChangeFailed()
  {
    QLog.d("AddAccountActivity", 1, "onAccoutChangeFailed");
  }
  
  public void onBackClick()
  {
    onBeforeBackHandle();
  }
  
  protected boolean onBackEvent()
  {
    onBeforeBackHandle();
    finish();
    return true;
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
      localQQProgressDialog.a(HardCodeUtil.a(2131898089));
      localQQProgressDialog.setCancelable(false);
      return localQQProgressDialog;
    }
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(getString(2131897871));
    return localQQProgressDialog;
  }
  
  public void onFindPwdClick()
  {
    ReportController.a(this.app, "dc00898", "", "", "0X8007353", "0X8007353", 0, 0, "", "", "", "");
    ReportController.a(this.app, "dc00898", "", "", "0X800B28F", "0X800B28F", 0, 0, "", "", "", "");
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void onPwdClear()
  {
    libsafeedit.clearPassBuffer();
    getAppRuntime().stopPCActivePolling("clearPassInput");
    Object localObject1 = this.mSimpleAccoutList;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = this.mBaseUI.m();
      int i = 0;
      while (i < this.mSimpleAccoutList.size())
      {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity
 * JD-Core Version:    0.7.0.1
 */