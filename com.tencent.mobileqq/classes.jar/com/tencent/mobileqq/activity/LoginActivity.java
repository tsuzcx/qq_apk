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
import android.support.v4.app.QFragmentActivity;
import android.support.v4.app.QFragmentManager;
import android.support.v4.app.QFragmentTransaction;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment.GuideCallBack;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideHandler;
import com.tencent.mobileqq.app.GatewayLoginNewDevHelper;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.loginregister.LoginProxy;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
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
  extends QFragmentActivity
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
  
  private void doAfterLoginSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.e("LoginActivity", 2, "only kandian tab switch, login delayTime:" + (NetConnInfoCenter.getServerTimeMillis() - this.startDelayTime));
    }
    if (PhoneNumLoginImpl.a().a()) {}
    do
    {
      return;
      if (this.mLoginProxy.a(this.app, this, this.app.getAccount())) {
        finish();
      }
    } while (isFinishing());
    dismissDialogById(0);
  }
  
  private boolean isSupportMultiWindow()
  {
    if (("Meizu".equalsIgnoreCase(DeviceInfoUtil.h())) && (Build.VERSION.SDK_INT < 24))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onMultiWindowModeChanged meizu < 7.0 not support!");
      }
      return false;
    }
    return true;
  }
  
  @TargetApi(11)
  public void changeGuideBaseView(GuideBaseFragment paramGuideBaseFragment)
  {
    Object localObject = getSupportFragmentManager();
    QFragmentTransaction localQFragmentTransaction = ((QFragmentManager)localObject).beginTransaction();
    localObject = ((QFragmentManager)localObject).findFragmentById(2131368153);
    if ((this.mCurrentView != null) || (localObject != null))
    {
      if ((this.mCurrentView == null) && (localObject != null) && ((localObject instanceof GuideBaseFragment))) {
        this.mCurrentView = ((GuideBaseFragment)localObject);
      }
      if (this.mCurrentView != null) {
        this.mCurrentView.a(null);
      }
      localQFragmentTransaction.replace(2131368153, paramGuideBaseFragment);
      if (VersionUtils.e()) {
        localQFragmentTransaction.commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      this.mCurrentView = paramGuideBaseFragment;
      this.mCurrentView.a(this);
      return;
      localQFragmentTransaction.commit();
      continue;
      localQFragmentTransaction.add(2131368153, paramGuideBaseFragment);
      if (VersionUtils.e()) {
        localQFragmentTransaction.commitAllowingStateLoss();
      } else {
        localQFragmentTransaction.commit();
      }
    }
  }
  
  public void checkUnlockForSpecial()
  {
    if ((this.isAddAccount) && (this.app != null) && (LoginUtils.a(this, this.app))) {
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
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    Window localWindow = getWindow();
    localWindow.addFlags(1024);
    if (Build.VERSION.SDK_INT >= 28)
    {
      View localView = localWindow.getDecorView();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      localWindow.setAttributes(localLayoutParams);
      int i = localView.getSystemUiVisibility();
      localWindow.getDecorView().setSystemUiVisibility(i | 0x400);
    }
    this.isChange = getIntent().getBooleanExtra("is_change_account", false);
    this.isAddAccount = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    this.isFromRegisterChoose = getIntent().getBooleanExtra("from_register_choose", false);
    this.isFromAccountManager = getIntent().getBooleanExtra("login_from_account_change", false);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      SoftInputResizeLayout.assistActivity(this);
    }
    if (sCurrent != null) {
      sCurrent.finish();
    }
    sCurrent = this;
    this.app = getAppRuntime();
    LoginUtils.a(this.app, LoginProgressClazz.class, this.mHandler);
    this.mLoginProxy = new LoginProxy();
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "LoginActivity app is " + this.app);
    }
    this.mNeedFinishLoginActivity = true;
    super.setContentView(2131562936);
    if (paramBundle != null)
    {
      this.mCurrentView = ((GuideBaseFragment)getSupportFragmentManager().findFragmentById(2131368153));
      if (this.mCurrentView != null) {
        this.mCurrentView.a(this);
      }
      if ("doOnCreate savedInstanceState != null, mCurrentView isExist:" + this.mCurrentView == null) {
        break label532;
      }
    }
    label532:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("LoginActivity", 1, new Object[] { Boolean.valueOf(bool) });
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
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    sCurrent = null;
    LoginUtils.a(this.app, LoginProgressClazz.class);
    if (this.mFirstBitmap != null) {
      this.mFirstBitmap = null;
    }
    if (this.mHandler != null) {
      this.mHandler.removeMessages(20140326);
    }
    dismissDialogById(0);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.mNeedFinishLoginActivity = true;
    if (this.mCurrentView != null) {
      this.mCurrentView.a(paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "doOnNewIntent in LoginActivity");
    }
  }
  
  public void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    GatewayLoginNewDevHelper.a(1);
    QLog.d("LoginActivity", 1, new Object[] { "onResume mNeedShowProgress=", Boolean.valueOf(this.mNeedShowProgress) });
    if (this.mNeedShowProgress) {}
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
    }
    do
    {
      do
      {
        return true;
      } while (isFinishing());
      dismissDialogById(0);
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "recv message FINISH_ACTIVITY.. finish activity");
      }
      finish();
      return true;
      if (this.mHandler != null) {
        this.mHandler.removeMessages(20140326);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "handleMessage  LOGIN_DO_NEXT");
      }
      doAfterLoginSuccess();
      return true;
    } while (isFinishing());
    this.mNeedShowProgress = true;
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("login", 1, "LoginActivity onAccountChanged");
    LoginUtils.a(this.app, LoginProgressClazz.class);
    this.app = getAppRuntime();
    LoginUtils.a(this.app, LoginProgressClazz.class, this.mHandler);
    Object localObject = null;
    if (this.mCurrentView != null) {
      localObject = this.mCurrentView.a();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.mLoginProxy.a(this, this.app, (String)localObject);
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 20140326;
    this.mHandler.sendMessageDelayed((Message)localObject, 800L);
    this.startDelayTime = System.currentTimeMillis();
    if (!this.mLoginProxy.a(this.app, getClass(), this.startDelayTime))
    {
      this.mHandler.removeMessages(20140326);
      doAfterLoginSuccess();
    }
    ReportController.a(this.app, "dc00898", "", "", "0X800AC0B", "0X800AC0B", 0, 0, "", "", "", "");
  }
  
  public void onAccoutChangeFailed()
  {
    QLog.d("login", 1, "LoginActivity onAccoutChangeFailed");
  }
  
  public boolean onBackEvent()
  {
    boolean bool1 = getIntent().getBooleanExtra("is_change_account", false);
    boolean bool2 = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    boolean bool3 = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    boolean bool4 = getIntent().getBooleanExtra("login_from_account_change", false);
    boolean bool5 = getIntent().getBooleanExtra("from_register_choose", false);
    boolean bool6 = getIntent().getBooleanExtra("fromsubaccount", false);
    boolean bool7 = getIntent().getBooleanExtra("is_need_login_with_mask", false);
    if (bool3) {
      if (bool2)
      {
        moveTaskToBack(true);
        finish();
      }
    }
    do
    {
      for (;;)
      {
        return true;
        try
        {
          this.app.exit(false);
        }
        catch (Exception localException1)
        {
          QLog.e("LoginActivity", 1, "onBackEvent app exit exception: " + localException1.getMessage());
          localException1.printStackTrace();
        }
      }
      break;
      if ((!bool1) && (!bool2) && (!bool5) && (!bool7)) {
        break label216;
      }
      if ((bool1) && (!bool6)) {
        setResult(-1);
      }
      finish();
    } while ((!bool2) || (!bool4));
    overridePendingTransition(2130771992, 2130772003);
    return true;
    try
    {
      label216:
      this.app.exit(false);
      finish();
      return true;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("LoginActivity", 1, "onBackEvent app exit exception: " + localException2.getMessage());
        localException2.printStackTrace();
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
    Dialog localDialog = null;
    if (this.mCurrentView != null) {
      localDialog = this.mCurrentView.a(paramInt);
    }
    return localDialog;
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if (!isSupportMultiWindow()) {}
    while (this.mCurrentView == null) {
      return;
    }
    this.mCurrentView.a(paramBoolean);
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (this.mCurrentView != null) {
      this.mCurrentView.a(paramInt, paramDialog);
    }
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  public void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.isAddAccount) && (this.app != null) && (LoginUtils.a(this, this.app))) {
      startUnlockActivity();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity
 * JD-Core Version:    0.7.0.1
 */