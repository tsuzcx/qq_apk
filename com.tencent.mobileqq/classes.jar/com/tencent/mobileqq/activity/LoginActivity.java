package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment.GuideCallBack;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideHandler;
import com.tencent.mobileqq.app.GatewayLoginNewDevHelper;
import com.tencent.mobileqq.app.LoginForbiddenDialogReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.loginregister.LoginProxy;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SoftInputResizeLayout;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;

@RoutePage(desc="主登录页面", path="/base/login")
public class LoginActivity
  extends QBaseActivity
  implements Handler.Callback, GuideBaseFragment.GuideCallBack
{
  public static final String FAKE_PASSWORD = "!@#ewaGbhkc$!!=";
  private static final String TAG = "LoginActivity";
  private static LoginActivity sCurrent;
  private AppRuntime app;
  private boolean isAddAccount;
  private boolean isChange;
  private boolean isFromAccountManager;
  private boolean isFromRegisterChoose;
  private GuideBaseFragment mCurrentView;
  private Bitmap mFirstBitmap;
  private MqqHandler mHandler = new MqqHandler(this);
  private LoginProxy mLoginProxy;
  private boolean mNeedFinishLoginActivity = true;
  private boolean mNeedShowProgress;
  private long startDelayTime = 0L;
  
  private void dismissDialogById(int paramInt)
  {
    try
    {
      dismissDialog(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("LoginActivity", 1, "dismissDialogById error : ", localException);
    }
  }
  
  @TargetApi(11)
  public void changeGuideBaseView(GuideBaseFragment paramGuideBaseFragment)
  {
    Object localObject = getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
    localObject = ((FragmentManager)localObject).findFragmentById(2131434494);
    if ((this.mCurrentView == null) && (localObject == null))
    {
      localFragmentTransaction.add(2131434494, paramGuideBaseFragment);
      if (VersionUtils.e()) {
        localFragmentTransaction.commitAllowingStateLoss();
      } else {
        localFragmentTransaction.commit();
      }
    }
    else
    {
      if ((this.mCurrentView == null) && (localObject != null) && ((localObject instanceof GuideBaseFragment))) {
        this.mCurrentView = ((GuideBaseFragment)localObject);
      }
      localObject = this.mCurrentView;
      if (localObject != null) {
        ((GuideBaseFragment)localObject).a(null);
      }
      localFragmentTransaction.replace(2131434494, paramGuideBaseFragment);
      if (VersionUtils.e()) {
        localFragmentTransaction.commitAllowingStateLoss();
      } else {
        localFragmentTransaction.commit();
      }
    }
    this.mCurrentView = paramGuideBaseFragment;
    this.mCurrentView.a(this);
  }
  
  public void checkUnlockForSpecial()
  {
    if (this.isAddAccount)
    {
      AppRuntime localAppRuntime = this.app;
      if ((localAppRuntime != null) && (LoginUtils.a(this, localAppRuntime))) {
        startUnlockActivity();
      }
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
  
  protected void doAfterLoginSuccess()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("only kandian tab switch, login delayTime:");
      ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis() - this.startDelayTime);
      QLog.e("LoginActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (PhoneNumLoginImpl.a().b()) {
      return;
    }
    Object localObject = this.mLoginProxy;
    AppRuntime localAppRuntime = this.app;
    if (((LoginProxy)localObject).a(localAppRuntime, this, localAppRuntime.getAccount())) {
      finish();
    }
    if (!isFinishing()) {
      dismissDialogById(0);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    Object localObject1 = getWindow();
    ((Window)localObject1).addFlags(1024);
    this.app = getAppRuntime();
    Object localObject2 = this.app;
    if (localObject2 == null)
    {
      finish();
      QLog.e("LoginActivity", 1, "app is null, finish");
      return true;
    }
    ((IFeatureRuntimeService)((AppRuntime)localObject2).getRuntimeService(IFeatureRuntimeService.class, "all")).initSdk(this);
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject2 = ((Window)localObject1).getDecorView();
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject1).getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      ((Window)localObject1).setAttributes(localLayoutParams);
      int i = ((View)localObject2).getSystemUiVisibility();
      ((Window)localObject1).getDecorView().setSystemUiVisibility(0x400 | i);
    }
    this.isChange = getIntent().getBooleanExtra("is_change_account", false);
    this.isAddAccount = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    this.isFromRegisterChoose = getIntent().getBooleanExtra("from_register_choose", false);
    this.isFromAccountManager = getIntent().getBooleanExtra("login_from_account_change", false);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      SoftInputResizeLayout.assistActivity(this);
    }
    localObject1 = sCurrent;
    if (localObject1 != null) {
      ((Activity)localObject1).finish();
    }
    sCurrent = this;
    LoginUtils.a(this.app, LoginProgressClazz.class, this.mHandler);
    this.mLoginProxy = new LoginProxy();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("LoginActivity app is ");
      ((StringBuilder)localObject1).append(this.app);
      QLog.d("LoginActivity", 2, ((StringBuilder)localObject1).toString());
    }
    this.mNeedFinishLoginActivity = true;
    super.setContentView(2131629188);
    if (paramBundle != null)
    {
      this.mCurrentView = ((GuideBaseFragment)getSupportFragmentManager().findFragmentById(2131434494));
      paramBundle = this.mCurrentView;
      if (paramBundle != null) {
        paramBundle.a(this);
      }
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate savedInstanceState != null, mCurrentView isExist:");
      paramBundle.append(this.mCurrentView);
      boolean bool;
      if (paramBundle.toString() != null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("LoginActivity", 1, new Object[] { Boolean.valueOf(bool) });
    }
    if (this.mCurrentView == null) {
      changeGuideBaseView(GuideHandler.a(this, this.app));
    }
    this.mLoginProxy.a(this, getIntent().getExtras());
    if ((this.isAddAccount) && (this.isFromAccountManager))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800664D", "0X800664D", 0, 0, "", "", "", "");
      ReportController.b(this.app, "dc00898", "", "", "0X800735D", "0X800735D", 0, 0, "", "", "", "");
      ReportController.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
      ReportController.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 3, 0, "", "", "", "");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.app;
    if (localObject == null) {
      return;
    }
    sCurrent = null;
    LoginUtils.b((AppRuntime)localObject, LoginProgressClazz.class);
    if (this.mFirstBitmap != null) {
      this.mFirstBitmap = null;
    }
    localObject = this.mHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeMessages(2005);
    }
    dismissDialogById(0);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.mNeedFinishLoginActivity = true;
    GuideBaseFragment localGuideBaseFragment = this.mCurrentView;
    if (localGuideBaseFragment != null) {
      localGuideBaseFragment.a(paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "doOnNewIntent in LoginActivity");
    }
  }
  
  protected void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    GatewayLoginNewDevHelper.a(1);
    QLog.d("LoginActivity", 1, new Object[] { "onResume mNeedShowProgress=", Boolean.valueOf(this.mNeedShowProgress) });
    if (this.mNeedShowProgress) {
      try
      {
        showDialog(0);
        this.mNeedShowProgress = false;
        return;
      }
      catch (Exception localException)
      {
        QLog.e("LoginActivity", 1, new Object[] { "show progress dialog error : ", localException.getMessage() });
      }
    }
  }
  
  public GuideBaseFragment getCurrentView()
  {
    return this.mCurrentView;
  }
  
  public void handleBackEvent()
  {
    onBackEvent();
  }
  
  @TargetApi(16)
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
        QLog.d("LoginActivity", 2, "handleMessage  LOGIN_DO_NEXT");
      }
      doAfterLoginSuccess();
      return true;
    case 2004: 
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "recv message FINISH_ACTIVITY.. finish activity");
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
        dismissDialogById(0);
      }
      break;
    }
    return true;
  }
  
  protected boolean isSupportMultiWindow()
  {
    if (("Meizu".equalsIgnoreCase(DeviceInfoUtil.t())) && (Build.VERSION.SDK_INT < 24))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onMultiWindowModeChanged meizu < 7.0 not support!");
      }
      return false;
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
    QLog.d("login", 1, "LoginActivity onAccountChanged");
    LoginUtils.b(this.app, LoginProgressClazz.class);
    this.app = getAppRuntime();
    LoginUtils.a(this.app, LoginProgressClazz.class, this.mHandler);
    Object localObject = this.mCurrentView;
    if (localObject != null) {
      localObject = ((GuideBaseFragment)localObject).a();
    } else {
      localObject = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.mLoginProxy.a(this, this.app, (String)localObject);
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 2005;
    this.mHandler.sendMessageDelayed((Message)localObject, 800L);
    this.startDelayTime = System.currentTimeMillis();
    if (!this.mLoginProxy.a(this.app, getClass(), this.startDelayTime))
    {
      this.mHandler.removeMessages(2005);
      doAfterLoginSuccess();
    }
    else
    {
      showDialog(0);
    }
    ReportController.a(this.app, "dc00898", "", "", "0X800AC0B", "0X800AC0B", 0, 0, "", "", "", "");
    LoginForbiddenDialogReporter.a(getAppRuntime(), this.app.getAccount(), 1);
  }
  
  protected void onAccoutChangeFailed()
  {
    QLog.d("login", 1, "LoginActivity onAccoutChangeFailed");
  }
  
  protected boolean onBackEvent()
  {
    boolean bool1 = getIntent().getBooleanExtra("is_change_account", false);
    boolean bool2 = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    boolean bool3 = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    boolean bool4 = getIntent().getBooleanExtra("login_from_account_change", false);
    boolean bool5 = getIntent().getBooleanExtra("from_register_choose", false);
    boolean bool6 = getIntent().getBooleanExtra("fromsubaccount", false);
    boolean bool7 = getIntent().getBooleanExtra("is_need_login_with_mask", false);
    StringBuilder localStringBuilder;
    if (bool3)
    {
      if (bool2) {
        moveTaskToBack(true);
      } else {
        try
        {
          this.app.exit(false);
        }
        catch (Exception localException1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onBackEvent app exit exception: ");
          localStringBuilder.append(localException1.getMessage());
          QLog.e("LoginActivity", 1, localStringBuilder.toString());
          localException1.printStackTrace();
        }
      }
      finish();
      return true;
    }
    if ((!bool1) && (!bool2) && (!bool5) && (!bool7))
    {
      try
      {
        this.app.exit(false);
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBackEvent app exit exception: ");
        localStringBuilder.append(localException2.getMessage());
        QLog.e("LoginActivity", 1, localStringBuilder.toString());
        localException2.printStackTrace();
      }
      finish();
      return true;
    }
    if ((bool1) && (!bool6)) {
      setResult(-1);
    }
    finish();
    if ((bool2) && (bool4)) {
      overridePendingTransition(2130772007, 2130772018);
    }
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
    GuideBaseFragment localGuideBaseFragment = this.mCurrentView;
    if (localGuideBaseFragment != null) {
      return localGuideBaseFragment.a(paramInt);
    }
    return null;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if (!isSupportMultiWindow()) {
      return;
    }
    GuideBaseFragment localGuideBaseFragment = this.mCurrentView;
    if (localGuideBaseFragment != null) {
      localGuideBaseFragment.onMultiWindowModeChanged(paramBoolean);
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    GuideBaseFragment localGuideBaseFragment = this.mCurrentView;
    if (localGuideBaseFragment != null) {
      localGuideBaseFragment.a(paramInt, paramDialog);
    }
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  public void receiveScreenOff()
  {
    super.receiveScreenOff();
    if (this.isAddAccount)
    {
      AppRuntime localAppRuntime = this.app;
      if ((localAppRuntime != null) && (LoginUtils.a(this, localAppRuntime))) {
        startUnlockActivity();
      }
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity
 * JD-Core Version:    0.7.0.1
 */