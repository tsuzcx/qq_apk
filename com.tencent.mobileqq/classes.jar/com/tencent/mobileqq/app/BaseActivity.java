package com.tencent.mobileqq.app;

import Override;
import abiz;
import adla;
import alni;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import ants;
import antt;
import anui;
import anxh;
import aobf;
import aohg;
import aori;
import asvf;
import awzy;
import bdgb;
import bdkh;
import bdll;
import bdmc;
import bdmv;
import bhzh;
import blhf;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.fling.FlingAllowProvider;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qlink.QlinkBridgeActivity;
import cooperation.qlink.QlinkShareJumpActivity;
import cooperation.qqfav.widget.QfavJumpActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import eipc.EIPCClient;
import eipc.EIPCResultCallback;
import java.lang.reflect.Field;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.os.MqqHandler;
import mqq.os.MqqInterceptHandler;

public class BaseActivity
  extends AppActivity
  implements SkinnableActivityProcesser.Callback
{
  public static final int MSG_SHAKE = 1001;
  public static final int REQUEST_CODE_UNLOCK = 12289;
  public static final String TAG = "qqBaseActivity";
  private static boolean isThemeSwitchOpen;
  public static boolean isUnLockSuccess;
  public static long mAppBackgroundTime;
  public static boolean mAppForground = true;
  public static boolean mIsInMultiScreen;
  private static BroadcastReceiver mScreenReceiver;
  protected static long mShowGesture;
  public static ArrayList<String> sActivityRoute = new ArrayList();
  private static boolean sSensorReady;
  public static BaseActivity sTopActivity;
  private static aohg shakeListener;
  public QQAppInterface app;
  private String className = getClass().getSimpleName();
  protected long currentActivityStayTime;
  public boolean isClearCoverLayer = true;
  private Dialog jumpDialog;
  public boolean mActNeedImmersive = true;
  public boolean mCanLock = true;
  private ClassLoader mClassLoader;
  public boolean mCurrentActivityShakeFlag = true;
  private BroadcastReceiver mDebugUiHierarchyBroadcastReceiver;
  private EIPCResultCallback mEIPCResultCallback = new ants(this);
  protected FlingHandler mFlingHandler;
  protected boolean mIsAttachedToWindow;
  protected boolean mIsStatusBarVisibilityNeedGone;
  private MiniMsgUser mMiniMsgUser;
  private Runnable mNFCPauseRunnable;
  private Runnable mNFCResumeRunnable;
  public boolean mNeedStatusTrans = true;
  private boolean mShowOnFirst;
  private BaseActivity.StatusBarCorrectTask mStatusBarCorrectTask;
  protected int mStatusBarVisibility = 0;
  public int mStopFlag;
  public SystemBarCompact mSystemBarComp;
  public int[] mWindowLocation;
  SkinnableActivityProcesser processer;
  Runnable runnableRemoveNotification = null;
  public ScreenShot screenShot;
  
  private void attachDebugUiHierarchyTools() {}
  
  private void cleanScreenShot()
  {
    if (this.screenShot != null)
    {
      this.screenShot.a();
      this.screenShot = null;
      ScreenShot.a("BaseActivity cleanScreenShot");
    }
  }
  
  private void dettachDebugUiHierarchyTools() {}
  
  public static ArrayList<String> getActivityRoutes()
  {
    return (ArrayList)sActivityRoute.clone();
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  private boolean isStartQQ3rdApp(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while (((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT"))) || ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.PICK"))));
        paramIntent = paramIntent.getComponent();
        if (paramIntent == null) {
          break;
        }
        str = paramIntent.getPackageName();
      } while ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone")));
      paramIntent = paramIntent.getClassName();
    } while ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")));
    return false;
  }
  
  private void replaceActivityHandler()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mHandler");
      localField.setAccessible(true);
      Handler localHandler = MqqInterceptHandler.createMqqHandler((Handler)localField.get(this));
      if (localHandler != null) {
        localField.set(this, localHandler);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("qqBaseActivity", 1, "", localException);
    }
  }
  
  private void resumeNFC()
  {
    String str = BridgeHelper.a(getActivity(), getCurrentAccountUin()).a("buscard_registerNFC");
    if ((TextUtils.isEmpty(str)) || ("true".equals(str))) {}
    try
    {
      if (this.mNFCResumeRunnable != null) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mNFCResumeRunnable);
      }
      this.mNFCResumeRunnable = new BaseActivity.4(this);
      ThreadManager.getSubThreadHandler().post(this.mNFCResumeRunnable);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.i("qqBaseActivity", 4, "registerNFCEvent failed");
    }
  }
  
  private void resumeStartUnlockIfNeeded()
  {
    String str = getCurrentAccountUin();
    if (((!mAppForground) || (("com.tencent.mobileqq".equals(BaseApplicationImpl.processName)) && (!isUnLockSuccess))) && (this.mCanLock) && (str != null) && (GesturePWDUtils.getJumpLock(getActivity(), str)) && (!(getActivity() instanceof GesturePWDUnlockActivity)) && (!(getActivity() instanceof InstallActivity)) && (!(getActivity() instanceof UserguideActivity)) && (!(getActivity() instanceof JumpActivity)) && (!(getActivity() instanceof qfileJumpActivity)) && (!(getActivity() instanceof QfavJumpActivity)) && (!(getActivity() instanceof LoginActivity)) && (!(getActivity() instanceof QlinkBridgeActivity)) && (!(getActivity() instanceof QlinkShareJumpActivity))) {
      startUnlockActivity();
    }
    for (;;)
    {
      if ((!mAppForground) && (str != null)) {
        aori.a().a(this.app);
      }
      if ((!mAppForground) && (!(this instanceof JumpActivity)))
      {
        mAppForground = true;
        GesturePWDUtils.setAppForground(getActivity(), mAppForground);
      }
      this.mStopFlag = 0;
      this.mCanLock = true;
      return;
      if ((!mAppForground) && (this.mCanLock)) {
        checkUnlockForSpecial();
      } else if ((!mAppForground) && (!this.mCanLock)) {
        isUnLockSuccess = true;
      }
    }
  }
  
  private void resumeStatusBar()
  {
    this.mIsStatusBarVisibilityNeedGone = false;
    if ((!isNeedInterruptDoMulitWindow()) && (this.mIsAttachedToWindow) && (isInMultiWindow()))
    {
      boolean bool = isNeedStatusBarGone();
      if ((this.mSystemBarComp != null) && (this.mSystemBarComp.isStatusBarVisible == bool)) {
        if (!bool) {
          break label75;
        }
      }
    }
    label75:
    for (int i = 2;; i = 0)
    {
      this.mSystemBarComp.setStatusBarVisible(i, 0);
      this.mStatusBarVisibility = i;
      doInMultiWindowModeStatusBarVisibilityChange(i);
      return;
    }
  }
  
  private void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    boolean bool = paramIntent.getBooleanExtra("key_gesture_showgesture_valid", true);
    if ((bool) && (Math.abs(mShowGesture - SystemClock.uptimeMillis()) < 1000L))
    {
      QLog.d("qqBaseActivity", 1, "startActivityForResult" + mShowGesture + "," + bool);
      return;
    }
    this.mStopFlag = 2;
    if (isStartQQ3rdApp(paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "mCanLock set false, isStartQQ3rdApp");
      }
      this.mCanLock = false;
    }
    if (!isMoveTaskToBack(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    String str = paramIntent.getStringExtra("selfSet_leftViewText");
    if (TextUtils.isEmpty(str)) {
      paramIntent.putExtra("leftViewText", setLastActivityName());
    }
    for (;;)
    {
      try
      {
        startActivityInner(paramIntent, paramInt1, paramInt2);
        return;
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("qqBaseActivity", 2, "startActivity failed with: ", paramIntent);
      return;
      paramIntent.putExtra("leftViewText", str);
      paramIntent.removeExtra("selfSet_leftViewText");
    }
  }
  
  private void startActivityInner(Intent paramIntent, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 0: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 1: 
      if ((this.app != null) && (FlingAllowProvider.contain(getCurrentAccountUin())))
      {
        paramInt2 = hashCode();
        String str = ScreenCapture.getSnapPath(this, paramInt2);
        if (str != null)
        {
          ScreenCapture.captureViewToFile(str, getWindow().getDecorView());
          paramIntent.putExtra("fling_action_key", 1);
          paramIntent.putExtra("fling_code_key", paramInt2);
        }
      }
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    }
    paramInt2 = hashCode();
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", paramInt2);
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  private boolean tryLoadDataIfInSafeMode(QQAppInterface paramQQAppInterface)
  {
    if (!abiz.a(BaseApplicationImpl.sApplication)) {
      return false;
    }
    try
    {
      QLog.e("qqBaseActivity", 2, "prepare try preload Database");
      paramQQAppInterface.a();
      QLog.e("qqBaseActivity", 2, "try preload getRecentUserProxy finish");
      return true;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        try
        {
          QLog.e("qqBaseActivity", 2, "try preload fail", paramQQAppInterface);
          bdkh.a(paramQQAppInterface, "");
        }
        catch (Throwable paramQQAppInterface) {}
      }
    }
  }
  
  public void addObserver(anui paramanui)
  {
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.addObserver(paramanui);
    }
  }
  
  public void addObserver(anui paramanui, boolean paramBoolean)
  {
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.addObserver(paramanui, paramBoolean);
    }
  }
  
  public void adjustSimpleStatusBar()
  {
    boolean bool1 = false;
    if (bdgb.b())
    {
      bool2 = ThemeUtil.isNowThemeIsNight(this.app, false, null);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c())) {
        if (!bool2) {
          bool1 = true;
        }
      }
    }
    while (ImmersiveUtils.isSupporImmersive() == 0)
    {
      boolean bool2;
      ImmersiveUtils.a(bool1, getWindow());
      do
      {
        return;
      } while ((ImmersiveUtils.isSupporImmersive() == 0) || (this.mSystemBarComp == null) || (bool2));
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    ImmersiveUtils.a(false, getWindow());
  }
  
  protected void checkUnlockForSpecial()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=" + Foreground.sCountActivity + ",stopflag" + this.mStopFlag);
    }
  }
  
  protected void correctStatusBarHeight()
  {
    if ((!ImmersiveUtils.c) && (!isInMultiWindow()))
    {
      if (this.mStatusBarCorrectTask == null) {
        this.mStatusBarCorrectTask = new BaseActivity.StatusBarCorrectTask(this);
      }
      ThreadManager.getUIHandler().post(this.mStatusBarCorrectTask);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    bdll.a(paramMotionEvent);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @SuppressLint({"SdCardPath"})
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (isThemeSwitchOpen) {}
    return super.doDispatchKeyEvent(paramKeyEvent);
  }
  
  public void doInMultiWindowModeStatusBarVisibilityChange(int paramInt) {}
  
  public void doOnBackPressed()
  {
    if (!onBackEvent()) {}
    try
    {
      super.doOnBackPressed();
      if (((this instanceof FragmentActivity)) && (!((FragmentActivity)this).getThisFragmentManager().popBackStackImmediate())) {
        finish();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "", localThrowable);
      }
      finish();
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = Build.VERSION.SDK_INT;
    bdmc.a(this).a(this);
    setImmersiveStatus();
    replaceActivityHandler();
    if (themeChangeRightNow()) {
      this.processer = new SkinnableActivityProcesser(this, this);
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    sActivityRoute.add(getActivityName());
    updateAppRuntime();
    if (getAppRuntime() != null) {
      setVolumeControlStream(3);
    }
    if (!sSensorReady)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new BaseActivity.1(this), 300L);
      sSensorReady = true;
    }
    if (isWrapContent())
    {
      paramBundle = getIntent().getExtras();
      if (paramBundle == null) {}
    }
    try
    {
      i = paramBundle.getInt("fling_action_key");
      if (i != 0)
      {
        if ((1 == i) && (getAppRuntime() != null) && (FlingAllowProvider.contain(getCurrentAccountUin()))) {
          this.mFlingHandler = new FlingTrackerHandler(this);
        }
      }
      else
      {
        setOnMultiScreenChangeListener();
        blhf.a(this.app, this);
        if (isNeedMiniMsg()) {
          this.mMiniMsgUser = new MiniMsgUser(this, getMiniMsgUserParam());
        }
        bdgb.a(this.mSystemBarComp, getWindow());
        attachDebugUiHierarchyTools();
        return false;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        i = 0;
        continue;
        this.mFlingHandler = new FlingGestureHandler(this);
      }
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      if ((this.jumpDialog != null) && (this.jumpDialog.isShowing())) {
        this.jumpDialog.dismiss();
      }
      super.doOnDestroy();
      sActivityRoute.remove(getActivityName());
      bdmc.a(this).d(this);
      aori.a(this);
      if (this.processer != null) {
        this.processer.destory();
      }
      if (this.mNFCPauseRunnable != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mNFCPauseRunnable);
        this.mNFCPauseRunnable = null;
      }
      if (this.mNFCResumeRunnable != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mNFCResumeRunnable);
        this.mNFCResumeRunnable = null;
      }
      if (QLog.isColorLevel()) {
        QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
      }
      AppInterface localAppInterface = getAppInterface();
      if (localAppInterface != null) {
        localAppInterface.removeHandler(getClass());
      }
      if ((MagnifierSDK.a().a().a > 0.0F) && (BaseApplicationImpl.sImageCache != null)) {
        BaseApplicationImpl.sImageCache.releaseLargeCache();
      }
      if (sTopActivity == this) {
        sTopActivity = null;
      }
      if ((isNeedMiniMsg()) && (this.mMiniMsgUser != null)) {
        this.mMiniMsgUser.destroy();
      }
      dettachDebugUiHierarchyTools();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("qqBaseActivity", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    aobf.b(this);
    if (26 <= Build.VERSION.SDK_INT) {
      anxh.a(this, true, false);
    }
    if (paramIntent != null) {
      ActivityLifecycle.onNewIntent(getActivity(), paramIntent);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    bdmc.a(this).c(this);
    Object localObject = sTopActivity;
    if ((this.currentActivityStayTime != 0L) && (localObject != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, localObject.getClass().getName(), (int)(SystemClock.uptimeMillis() - this.currentActivityStayTime), 0, null);
    }
    cleanScreenShot();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(256);
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(this.className);
      ((StringBuilder)localObject).append(" onPause HeapAlloc=");
      ((StringBuilder)localObject).append(Runtime.getRuntime().totalMemory() / 1024L);
      ((StringBuilder)localObject).append(" KB HeapFree=");
      ((StringBuilder)localObject).append(Runtime.getRuntime().freeMemory() / 1024L);
      ((StringBuilder)localObject).append(" KB");
      QLog.d("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
    }
    localObject = BridgeHelper.a(getActivity(), getCurrentAccountUin()).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {}
    try
    {
      if (this.mNFCPauseRunnable != null) {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mNFCPauseRunnable);
      }
      this.mNFCPauseRunnable = new BaseActivity.5(this);
      ThreadManager.getSubThreadHandler().post(this.mNFCPauseRunnable);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("qqBaseActivity", 4, "disableNFCEvent failed");
        }
      }
    }
    if ((isNeedMiniMsg()) && (this.mMiniMsgUser != null)) {
      this.mMiniMsgUser.onBackground();
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    sTopActivity = this;
    bdmc.a(this).b(this);
    this.currentActivityStayTime = SystemClock.uptimeMillis();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      setOnMultiScreenChangeListener();
    }
    if ((this instanceof NotificationActivity)) {}
    for (;;)
    {
      if (asvf.a == true) {
        asvf.a().b();
      }
      ThreadManager.excute(new BaseActivity.3(this), 64, null, true);
      mAppForground = GesturePWDUtils.getAppForground(getActivity());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("[");
        localStringBuilder.append(hashCode());
        localStringBuilder.append("]");
        localStringBuilder.append(this.className);
        localStringBuilder.append(" onResume .mAppForground = ");
        localStringBuilder.append(mAppForground);
        localStringBuilder.append(",mCanLock=");
        localStringBuilder.append(this.mCanLock);
        localStringBuilder.append(" HeapAlloc=");
        localStringBuilder.append(Runtime.getRuntime().totalMemory() / 1024L);
        localStringBuilder.append(" KB HeapFree=");
        localStringBuilder.append(Runtime.getRuntime().freeMemory() / 1024L);
        localStringBuilder.append(" KB HeapMax=");
        localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L);
        localStringBuilder.append(" KB");
        QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
      }
      if (mAppBackgroundTime > 0L) {
        bdmv.a(SystemClock.elapsedRealtime() - mAppBackgroundTime);
      }
      mAppBackgroundTime = 0L;
      resumeStartUnlockIfNeeded();
      if (GuardManager.a != null) {
        GuardManager.a.b(1, getPreProcess());
      }
      resumeNFC();
      resumeStatusBar();
      if ((isNeedMiniMsg()) && (this.mMiniMsgUser != null)) {
        this.mMiniMsgUser.onForeground();
      }
      if (Build.VERSION.SDK_INT < 23) {
        bdgb.a(this.mSystemBarComp, getWindow());
      }
      return;
      asvf.a().a();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    cleanScreenShot();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onStart " + Foreground.sCountActivity);
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onStart();
    }
    awzy.a(getIntent());
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onStop " + Foreground.sCountActivity);
    }
    cleanScreenShot();
    this.mStopFlag = 1;
    mAppForground = GesturePWDUtils.isAppOnForegroundByTasks(this);
    if (!mAppForground)
    {
      GesturePWDUtils.setAppForground(this, mAppForground);
      isUnLockSuccess = false;
      mAppBackgroundTime = SystemClock.elapsedRealtime();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    int i = 0;
    super.doOnWindowFocusChanged(paramBoolean);
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = getClass().getName();
      if (this.app == null)
      {
        bool = true;
        QLog.d("qqBaseActivity", 2, String.format("doOnWindowFocusChanged, isFocused[%s], appIsNull[%s], curName[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), localObject }));
      }
    }
    else
    {
      if ((this.app != null) && (!paramBoolean)) {
        break label315;
      }
    }
    for (;;)
    {
      try
      {
        if (!AppSetting.c.equalsIgnoreCase("Xiaomi-MI 5")) {
          continue;
        }
        if (this.runnableRemoveNotification == null) {
          this.runnableRemoveNotification = new BaseActivity.2(this);
        }
        ThreadManager.getUIHandler().postDelayed(this.runnableRemoveNotification, 3000L);
        if ((!isNeedInterruptDoMulitWindow()) && (!this.mIsAttachedToWindow) && (isInMultiWindow()))
        {
          bool = isNeedStatusBarGone();
          if ((this.mSystemBarComp != null) && (this.mSystemBarComp.isStatusBarVisible == bool))
          {
            if (bool) {
              i = 2;
            }
            this.mSystemBarComp.setStatusBarVisible(i, 0);
            this.mStatusBarVisibility = i;
            doInMultiWindowModeStatusBarVisibilityChange(i);
          }
        }
        this.mIsAttachedToWindow = true;
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("qqBaseActivity", 4, "doOnWindowFocusChanged failed");
        continue;
      }
      localObject = (KandianMergeManager)this.app.getManager(162);
      if (localObject != null) {
        ((KandianMergeManager)localObject).a(paramBoolean, getClass());
      }
      if ((paramBoolean) && (!this.mShowOnFirst))
      {
        if ((isNeedMiniMsg()) && (this.mMiniMsgUser != null)) {
          this.mMiniMsgUser.showOnFirst();
        }
        this.mShowOnFirst = true;
      }
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "BaseActivity doOnWindowFocusChanged removeNotification");
      }
      this.app.j();
      continue;
      label315:
      if (this.runnableRemoveNotification != null)
      {
        ThreadManager.getUIHandler().removeCallbacks(this.runnableRemoveNotification);
        this.runnableRemoveNotification = null;
      }
    }
  }
  
  public void doRefreshMiniBadge(Bundle paramBundle) {}
  
  public void finish()
  {
    try
    {
      super.finish();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("qqBaseActivity", 1, "finish error");
    }
  }
  
  @Deprecated
  public Activity getActivity()
  {
    return this;
  }
  
  public String getActivityName()
  {
    return this.className;
  }
  
  public AppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  public String getCIOPageName()
  {
    return getClass().getName();
  }
  
  public boolean getCanLock()
  {
    return this.mCanLock;
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader3 = super.getClassLoader();
    ClassLoader localClassLoader2 = this.mClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.a();
    }
    if (localClassLoader1 != null)
    {
      this.mClassLoader = localClassLoader1;
      return localClassLoader1;
    }
    return localClassLoader3;
  }
  
  public String getCurrentAccountUin()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if (localAppRuntime == null) {
      return "";
    }
    if ((localAppRuntime instanceof AppInterface)) {
      return ((AppInterface)localAppRuntime).getCurrentAccountUin();
    }
    return localAppRuntime.getAccount();
  }
  
  protected MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 0;
    localMiniMsgUserParam.accessType = 0;
    localMiniMsgUserParam.entryType = 0;
    localMiniMsgUserParam.positionX = -1;
    localMiniMsgUserParam.positionY = -1;
    localMiniMsgUserParam.colorType = 0;
    localMiniMsgUserParam.filterMsgType = 0;
    return localMiniMsgUserParam;
  }
  
  protected String getPreProcess()
  {
    return null;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299011);
  }
  
  @TargetApi(24)
  public boolean isInMultiWindow()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 24) {}
    try
    {
      bool1 = isInMultiWindowMode();
      if (QLog.isDebugVersion()) {
        QLog.i("qqBaseActivity", 2, " fight...isInMultiWindowMode = " + bool1);
      }
      return bool1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
  }
  
  public boolean isNeedInterruptDoMulitWindow()
  {
    return false;
  }
  
  protected boolean isNeedMiniMsg()
  {
    return false;
  }
  
  public boolean isNeedStatusBarGone()
  {
    boolean bool = false;
    if (this.mWindowLocation == null) {
      this.mWindowLocation = new int[2];
    }
    getWindow().getDecorView().getLayoutParams();
    getWindow().getDecorView().getLocationOnScreen(this.mWindowLocation);
    if (getWindow().getDecorView().getSystemUiVisibility() == 0) {}
    for (int i = 1;; i = 0)
    {
      if ((this.mWindowLocation[1] > 10) || (i == 0)) {
        bool = true;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("qqBaseActivity", 4, "fight..isNeedStatusBarGone " + bool);
      }
      return bool;
    }
  }
  
  public boolean isSupportScreenShot()
  {
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return true;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onAccountChanged ");
      if (getAppRuntime() != null) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("qqBaseActivity", 2, bool);
      if (this.app != null) {
        this.app.a(0L);
      }
      updateAppRuntime();
      return;
    }
  }
  
  protected boolean onBackEvent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @TargetApi(24)
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (sTopActivity == this))
    {
      if ((paramBoolean) && (Build.VERSION.SDK_INT >= 24))
      {
        bdll.a(this.app, "dc00898", "", "", "0X800859D", "0X800859D", 0, 0, "", "", "", "");
        bdmc.a(this).a(null, "MulitScreenMode", paramBoolean, 0L, 0L, null, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("qqBaseActivity", 4, "fight..onMultiWindowModeChanged " + getActivityName());
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    if (this.mSystemBarComp != null)
    {
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break label43;
      }
      this.mSystemBarComp.setStatusBarDrawable(getResources().getDrawable(2130846177));
    }
    for (;;)
    {
      bdgb.a(this.mSystemBarComp, getWindow());
      return;
      label43:
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusBarColor(getResources().getColor(2131167048));
    }
  }
  
  public void onPreThemeChanged() {}
  
  public void onProcessBackground(Bundle paramBundle)
  {
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_proc_backgound", paramBundle, this.mEIPCResultCallback);
  }
  
  protected void onProcessForeGround(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MiniMsgIPCServer", 4, "onProcessForeGround" + paramBundle.toString());
    }
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_proc_foregound", paramBundle, this.mEIPCResultCallback);
  }
  
  protected void onRefreshMiniBadge(Bundle paramBundle)
  {
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_refresh_mini_badge", paramBundle, this.mEIPCResultCallback);
  }
  
  public boolean preloadData(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadData", 2, "LoadDataactivity = " + paramAppRuntime + paramAppRuntime.isLogin());
    }
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)) && (!TextUtils.isEmpty(paramAppRuntime.getAccount())))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
      if (paramAppRuntime.isLogin())
      {
        if (tryLoadDataIfInSafeMode(localQQAppInterface)) {
          return false;
        }
        return alni.a().a(localQQAppInterface, BaseApplicationImpl.sApplication, paramBoolean, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoadData", 2, new Object[] { "Preload not login account: ", paramAppRuntime.getAccount() });
      }
      try
      {
        if (tryLoadDataIfInSafeMode(localQQAppInterface)) {
          return false;
        }
        paramBoolean = alni.a().a(localQQAppInterface, BaseApplicationImpl.sApplication, paramBoolean, false);
        return paramBoolean;
      }
      catch (Throwable paramAppRuntime)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoadData", 2, "has account and not login, preload fail.");
        }
        return false;
      }
    }
    return false;
  }
  
  public void receiveScreenOff() {}
  
  public void removeObserver(anui paramanui)
  {
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.removeObserver(paramanui);
    }
  }
  
  public void setCanLock(boolean paramBoolean)
  {
    if ((!paramBoolean) && (QLog.isColorLevel())) {
      QLog.e("qqBaseActivity", 2, "mCanLock set false", new Throwable());
    }
    this.mCanLock = paramBoolean;
  }
  
  protected void setContentBackgroundResource(int paramInt)
  {
    findViewById(16908290).setBackgroundResource(paramInt);
  }
  
  public void setImmersiveStatus()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.mActNeedImmersive)
      {
        int i = getResources().getColor(2131167048);
        if (this.mSystemBarComp == null)
        {
          this.mSystemBarComp = new SystemBarCompact(this, true, i);
          if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
            break label99;
          }
          this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130846177));
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(getWindow(), this.isClearCoverLayer);
      return;
      label99:
      this.mSystemBarComp.setStatusDrawable(null);
    }
  }
  
  public void setImmersiveStatus(int paramInt)
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, paramInt);
      }
      ImmersiveUtils.a(getWindow(), this.isClearCoverLayer);
    }
  }
  
  public void setJumpDialog(Dialog paramDialog)
  {
    this.jumpDialog = paramDialog;
  }
  
  protected String setLastActivityName()
  {
    return getString(2131690559);
  }
  
  @TargetApi(11)
  public void setOnMultiScreenChangeListener()
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    do
    {
      for (;;)
      {
        return;
        if (Build.VERSION.SDK_INT >= 21)
        {
          antt localantt = new antt(this);
          try
          {
            View localView = getWindow().getDecorView();
            localView.setOnSystemUiVisibilityChangeListener(localantt);
            if (localView.getSystemUiVisibility() != 0) {
              localantt.onSystemUiVisibilityChange(localView.getSystemUiVisibility());
            }
            if (QLog.isDevelopLevel())
            {
              QLog.d("qqBaseActivity", 4, "setOnMultiScreenChangeListener:" + localView.getSystemUiVisibility() + ",Activity name:" + getClass().getName());
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("qqBaseActivity", 4, "setOnMultiScreenChangeListener happen exception:" + localException.getMessage() + ",Activity name:" + getClass().getName());
  }
  
  public void setStatusBarBlue()
  {
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) && (this.mSystemBarComp != null)) {
      this.mSystemBarComp.setStatusBarDrawable(getResources().getDrawable(2130846177));
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    JumpActivity.g(paramIntent);
    JumpActivity.a(this, paramIntent);
    access$501(this, paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    JumpActivity.g(paramIntent);
    JumpActivity.a(this, paramIntent);
    access$601(this, paramIntent, paramBundle);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    JumpActivity.g(paramIntent);
    JumpActivity.a(this, paramIntent);
    startActivityForResult(paramIntent, paramInt, 2);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    JumpActivity.g(paramIntent);
    JumpActivity.a(this, paramIntent);
    Object localObject;
    if (this.app != null)
    {
      localObject = (bhzh)this.app.getManager(150);
      if ((localObject == null) || (!((bhzh)localObject).a(paramIntent, this.app, this))) {}
    }
    else
    {
      do
      {
        return;
        if (!(this instanceof QQBrowserActivity)) {
          break;
        }
        localObject = ((QQBrowserActivity)this).a();
      } while ((localObject != null) && (((WebViewFragment)localObject).browserApp != null) && (((WebViewFragment)localObject).browserApp.a != null) && (((WebViewFragment)localObject).browserApp.a.a(paramIntent, this)));
    }
    try
    {
      JefsClass.getInstance().b(this, paramIntent, new BaseActivity.8(this, paramIntent, paramInt, paramBundle));
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("qqBaseActivity", 1, paramIntent, new Object[0]);
    }
  }
  
  public void startUnlockActivity()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "startUnlockActivity..." + this.className);
    }
    GesturePWDUnlockActivity.c = true;
    Intent localIntent = new Intent(this, GesturePWDUnlockActivity.class);
    localIntent.putExtra("key_gesture_showgesture_valid", false);
    startActivityForResult(localIntent, 12289);
    mShowGesture = SystemClock.uptimeMillis();
  }
  
  protected boolean themeChangeRightNow()
  {
    return true;
  }
  
  public void turnOffShake()
  {
    BaseActivity.7 local7 = new BaseActivity.7(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.getSubThreadHandler().post(local7);
      return;
    }
    local7.run();
  }
  
  public void turnOnShake()
  {
    BaseActivity.6 local6 = new BaseActivity.6(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.getSubThreadHandler().post(local6);
      return;
    }
    local6.run();
  }
  
  public void updateAppRuntime()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 4, "updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity
 * JD-Core Version:    0.7.0.1
 */