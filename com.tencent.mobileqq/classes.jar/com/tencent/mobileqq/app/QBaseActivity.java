package com.tencent.mobileqq.app;

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
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.fling.FlingAllowProvider;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.app.api.IScreenShot;
import com.tencent.mobileqq.app.api.IScreenShotService;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.api.ISimpleUIUtil;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.os.MqqHandler;
import mqq.os.MqqInterceptHandler;

public class QBaseActivity
  extends AppActivity
  implements SkinnableActivityProcesser.Callback
{
  public static final String KEY_GESTURE_SHOWGESTURE_VALID = "key_gesture_showgesture_valid";
  public static final int MSG_SHAKE = 1001;
  public static final int REQUEST_CODE_UNLOCK = 12289;
  public static final String TAG = "qqBaseActivity";
  private static IBaseActivityInjectInterface injectInterface;
  private static boolean isThemeSwitchOpen = false;
  public static boolean isUnLockSuccess;
  private static final GlobalLifecycleCallbacks lifecycleCallbacks = new GlobalLifecycleCallbacks();
  public static long mAppBackgroundTime;
  public static boolean mAppForground;
  public static boolean mIsInMultiScreen;
  private static BroadcastReceiver mScreenReceiver;
  protected static long mShowGesture;
  public static ArrayList<String> sActivityRoute;
  private static boolean sSensorReady;
  public static QBaseActivity sTopActivity;
  private static ShakeListener shakeListener;
  private String className = getClass().getSimpleName();
  public int clickX;
  public int clickY;
  protected long currentActivityStayTime;
  public boolean isClearCoverLayer = true;
  private Dialog jumpDialog;
  public boolean mActNeedImmersive = true;
  private final ArrayList<BaseActivityLifecycleCallbacks> mActivityLifecycleCallbacks = new ArrayList();
  protected boolean mCanLock = true;
  public boolean mCurrentActivityShakeFlag = true;
  private BroadcastReceiver mDebugUiHierarchyBroadcastReceiver;
  protected FlingHandler mFlingHandler;
  protected boolean mIsAttachedToWindow;
  protected boolean mIsStatusBarVisibilityNeedGone;
  private Runnable mNFCPauseRunnable;
  private Runnable mNFCResumeRunnable;
  public boolean mNeedStatusTrans = true;
  protected boolean mShowOnFirst;
  private QBaseActivity.StatusBarCorrectTask mStatusBarCorrectTask;
  protected int mStatusBarVisibility = 0;
  protected int mStopFlag = 0;
  public SystemBarCompact mSystemBarComp;
  public int[] mWindowLocation;
  SkinnableActivityProcesser processer;
  Runnable runnableRemoveNotification = null;
  public IScreenShot screenShot;
  
  static
  {
    try
    {
      Iterator localIterator = QBaseActivityInjectUtil.a.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        lifecycleCallbacks.a((BaseActivityLifecycleCallbacks)localClass.newInstance());
      }
      if (QBaseActivityInjectUtil.c.size() > 0) {
        injectInterface = (IBaseActivityInjectInterface)((Class)QBaseActivityInjectUtil.c.get(0)).newInstance();
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      QLog.e("qqBaseActivity", 2, "QBaseActivity static statement: ", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.e("qqBaseActivity", 2, "QBaseActivity static statement: ", localIllegalAccessException);
    }
    mAppForground = true;
    isUnLockSuccess = false;
    mAppBackgroundTime = 0L;
    mShowGesture = 0L;
    sActivityRoute = new ArrayList();
  }
  
  private Object[] collectActivityLifecycleCallbacks()
  {
    for (;;)
    {
      synchronized (this.mActivityLifecycleCallbacks)
      {
        if (this.mActivityLifecycleCallbacks.size() > 0)
        {
          Object[] arrayOfObject = this.mActivityLifecycleCallbacks.toArray();
          return arrayOfObject;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public static ArrayList<String> getActivityRoutes()
  {
    return (ArrayList)sActivityRoute.clone();
  }
  
  public static ShakeListener getShakeListener()
  {
    return shakeListener;
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {
      return true;
    }
    return !paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName());
  }
  
  public static boolean isSensorReady()
  {
    return sSensorReady;
  }
  
  private boolean isStartQQ3rdApp(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {
      return true;
    }
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT"))) {
      return true;
    }
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.PICK"))) {
      return true;
    }
    paramIntent = paramIntent.getComponent();
    if (paramIntent != null)
    {
      str = paramIntent.getPackageName();
      if ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone"))) {
        return true;
      }
      paramIntent = paramIntent.getClassName();
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity"))) {
        return true;
      }
    }
    return false;
  }
  
  private void printDecorView(String paramString) {}
  
  private void replaceActivityHandler()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mHandler");
      localField.setAccessible(true);
      Handler localHandler = MqqInterceptHandler.createMqqHandler((Handler)localField.get(this));
      if (localHandler != null)
      {
        localField.set(this, localHandler);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("qqBaseActivity", 1, "", localException);
    }
  }
  
  private void resumeStatusBar()
  {
    this.mIsStatusBarVisibilityNeedGone = false;
    if ((!isNeedInterruptDoMulitWindow()) && (this.mIsAttachedToWindow) && (isInMultiWindow()))
    {
      boolean bool = isNeedStatusBarGone();
      SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
      if ((localSystemBarCompact != null) && (localSystemBarCompact.isStatusBarVisible == bool))
      {
        int i;
        if (bool) {
          i = 2;
        } else {
          i = 0;
        }
        this.mSystemBarComp.setStatusBarVisible(i, 0);
        this.mStatusBarVisibility = i;
        doInMultiWindowModeStatusBarVisibilityChange(i);
      }
    }
  }
  
  public static void setIsUnLockSuccess(boolean paramBoolean)
  {
    isUnLockSuccess = paramBoolean;
  }
  
  public static void setSensorReady(boolean paramBoolean)
  {
    sSensorReady = paramBoolean;
  }
  
  public static void setShakeListener(ShakeListener paramShakeListener)
  {
    shakeListener = paramShakeListener;
  }
  
  private void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    boolean bool = paramIntent.getBooleanExtra("key_gesture_showgesture_valid", true);
    if ((bool) && (Math.abs(mShowGesture - SystemClock.uptimeMillis()) < 1000L))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("startActivityForResult");
      paramIntent.append(mShowGesture);
      paramIntent.append(",");
      paramIntent.append(bool);
      QLog.d("qqBaseActivity", 1, paramIntent.toString());
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
    if (TextUtils.isEmpty(str))
    {
      paramIntent.putExtra("leftViewText", setLastActivityName());
    }
    else
    {
      paramIntent.putExtra("leftViewText", str);
      paramIntent.removeExtra("selfSet_leftViewText");
    }
    try
    {
      startActivityInner(paramIntent, paramInt1, paramInt2);
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.w("qqBaseActivity", 1, "startActivity failed with: ", paramIntent);
    }
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      ((AppInterface)localAppRuntime).addObserver(paramBusinessObserver);
    }
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      ((AppInterface)localAppRuntime).addObserver(paramBusinessObserver, paramBoolean);
    }
  }
  
  public void adjustSimpleStatusBar()
  {
    if (((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).getSimpleUISwitch())
    {
      boolean bool = QQTheme.a();
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()))
      {
        ImmersiveUtils.setStatusTextColor(bool ^ true, getWindow());
        return;
      }
      if (ImmersiveUtils.isSupporImmersive() != 0)
      {
        SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
        if ((localSystemBarCompact != null) && (!bool)) {
          localSystemBarCompact.setStatusBarColor(-2368549);
        }
      }
    }
    else if (ImmersiveUtils.isSupporImmersive() != 0)
    {
      ImmersiveUtils.setStatusTextColor(false, getWindow());
    }
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    try
    {
      paramContext = QBaseActivityInjectUtil.b.iterator();
      while (paramContext.hasNext()) {
        registerActivityLifecycleCallbacks((BaseActivityLifecycleCallbacks)((Class)paramContext.next()).newInstance());
      }
      return;
    }
    catch (InstantiationException paramContext)
    {
      QLog.e("qqBaseActivity", 2, "QBaseActivity attachBaseContext: ", paramContext);
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      QLog.e("qqBaseActivity", 2, "QBaseActivity attachBaseContext: ", paramContext);
    }
  }
  
  public void checkUnlockForSpecial()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=");
      localStringBuilder.append(Foreground.getActivityCount());
      localStringBuilder.append(",stopflag");
      localStringBuilder.append(this.mStopFlag);
      QLog.d("qqBaseActivity", 4, localStringBuilder.toString());
    }
  }
  
  public void cleanScreenShot()
  {
    IScreenShot localIScreenShot = this.screenShot;
    if (localIScreenShot != null)
    {
      localIScreenShot.a();
      this.screenShot = null;
      ((IScreenShotService)QRoute.api(IScreenShotService.class)).logForDev("BaseActivity cleanScreenShot");
    }
  }
  
  protected void correctStatusBarHeight()
  {
    if ((!ImmersiveUtils.statusHeightCorrect) && (!isInMultiWindow()))
    {
      if (this.mStatusBarCorrectTask == null) {
        this.mStatusBarCorrectTask = new QBaseActivity.StatusBarCorrectTask(this);
      }
      ThreadManager.getUIHandler().post(this.mStatusBarCorrectTask);
    }
  }
  
  void dispatchAccountChanged(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).onAccountChanged(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.k(paramActivity);
  }
  
  void dispatchActivityDestroyed(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityDestroyed(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.i(paramActivity);
  }
  
  void dispatchActivityOnCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityCreate(paramQBaseActivity, paramBundle);
        i += 1;
      }
    }
    lifecycleCallbacks.b(paramQBaseActivity, paramBundle);
  }
  
  void dispatchActivityOnPause(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPause(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.f(paramActivity);
  }
  
  void dispatchActivityPostCreated(Activity paramActivity, Bundle paramBundle)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPostCreated(paramActivity, paramBundle);
        i += 1;
      }
    }
    lifecycleCallbacks.a(paramActivity, paramBundle);
  }
  
  void dispatchActivityPostPaused(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPostPaused(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.g(paramActivity);
  }
  
  void dispatchActivityPostResumed(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPostResumed(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.d(paramActivity);
  }
  
  void dispatchActivityPreCreated(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPreCreated(paramQBaseActivity, paramBundle);
        i += 1;
      }
    }
    lifecycleCallbacks.a(paramQBaseActivity, paramBundle);
  }
  
  void dispatchActivityPrePaused(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPrePaused(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.e(paramActivity);
  }
  
  void dispatchActivityPreResumed(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityPreResumed(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.b(paramActivity);
  }
  
  void dispatchActivityResumed(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityResume(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.c(paramActivity);
  }
  
  void dispatchActivityStarted(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityOnStart(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.a(paramActivity);
  }
  
  void dispatchActivityStopped(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnActivityStopped(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.h(paramActivity);
  }
  
  void dispatchActivityWindowFocusChanged(Activity paramActivity, boolean paramBoolean)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnWindowFocusChanged(paramActivity, paramBoolean);
        i += 1;
      }
    }
    lifecycleCallbacks.a(paramActivity, paramBoolean);
  }
  
  void dispatchNewInstant(Activity paramActivity, Intent paramIntent)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).doOnNewIntent(paramActivity, paramIntent);
        i += 1;
      }
    }
    lifecycleCallbacks.a(paramActivity, paramIntent);
  }
  
  public void dispatchOnBackPressed() {}
  
  void dispatchOnMultiWindowModeChanged(Activity paramActivity, boolean paramBoolean)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).onMultiWindowModeChanged(paramActivity, paramBoolean);
        i += 1;
      }
    }
    lifecycleCallbacks.b(paramActivity, paramBoolean);
  }
  
  void dispatchThemeChanged(Activity paramActivity)
  {
    Object[] arrayOfObject = collectActivityLifecycleCallbacks();
    if (arrayOfObject != null)
    {
      int j = arrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        ((BaseActivityLifecycleCallbacks)arrayOfObject[i]).onPostThemeChanged(paramActivity);
        i += 1;
      }
    }
    lifecycleCallbacks.j(paramActivity);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    injectInterface.a(this, paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
    {
      this.clickX = ((int)paramMotionEvent.getRawX());
      this.clickY = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @SuppressLint({"SdCardPath"})
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = isThemeSwitchOpen;
    return super.doDispatchKeyEvent(paramKeyEvent);
  }
  
  public void doInMultiWindowModeStatusBarVisibilityChange(int paramInt) {}
  
  public void doOnBackPressed()
  {
    if (!onBackEvent()) {
      try
      {
        super.doOnBackPressed();
        dispatchOnBackPressed();
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
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (isWrapContent())
    {
      FlingHandler localFlingHandler = this.mFlingHandler;
      if (localFlingHandler != null) {
        localFlingHandler.onConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    printDecorView("before pre create: ");
    dispatchActivityPreCreated(this, paramBundle);
    printDecorView("before super doOnCreate: ");
    super.doOnCreate(paramBundle);
    dispatchActivityOnCreate(this, paramBundle);
    printDecorView("do action at doOnCreate: ");
    setImmersiveStatus();
    initNavigationBarColor();
    replaceActivityHandler();
    if (themeChangeRightNow()) {
      this.processer = new SkinnableActivityProcesser(this, this);
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(this.className);
      ((StringBuilder)localObject).append(" process id =");
      ((StringBuilder)localObject).append(Process.myPid());
      ((StringBuilder)localObject).append(" onCreate task : ");
      ((StringBuilder)localObject).append(getTaskId());
      QLog.i("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
    }
    sActivityRoute.add(getActivityName());
    if (getAppRuntime() != null) {
      setVolumeControlStream(3);
    }
    if (!sSensorReady)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new QBaseActivity.1(this), 300L);
      sSensorReady = true;
    }
    printDecorView("do action at before add Fling: ");
    if (isWrapContent())
    {
      localObject = getIntent().getExtras();
      if (localObject == null) {}
    }
    try
    {
      i = ((Bundle)localObject).getInt("fling_action_key");
    }
    catch (Exception localException)
    {
      int i;
      label250:
      break label250;
    }
    i = 0;
    if (i != 0) {
      if ((1 == i) && (getAppRuntime() != null) && (FlingAllowProvider.contain(getCurrentAccountUinFromRuntime()))) {
        this.mFlingHandler = new FlingTrackerHandler(this);
      } else {
        this.mFlingHandler = new FlingGestureHandler(this);
      }
    }
    printDecorView("do action at before set multiScreen: ");
    setOnMultiScreenChangeListener();
    ((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).adjustSimpleStatusBar(this.mSystemBarComp, getWindow());
    printDecorView("before call post create: ");
    dispatchActivityPostCreated(this, paramBundle);
    printDecorView("doOnCreate Finish: ");
    return false;
  }
  
  protected void doOnDestroy()
  {
    try
    {
      if ((this.jumpDialog != null) && (this.jumpDialog.isShowing())) {
        this.jumpDialog.dismiss();
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("qqBaseActivity", 1, localThrowable, new Object[0]);
    }
    super.doOnDestroy();
    sActivityRoute.remove(getActivityName());
    Object localObject = this.processer;
    if (localObject != null) {
      ((SkinnableActivityProcesser)localObject).destory();
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(this.className);
      ((StringBuilder)localObject).append(" process id =");
      ((StringBuilder)localObject).append(Process.myPid());
      ((StringBuilder)localObject).append(" onDestroy task : ");
      ((StringBuilder)localObject).append(getTaskId());
      QLog.i("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
    }
    dispatchActivityDestroyed(this);
    if (sTopActivity == this) {
      sTopActivity = null;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    dispatchNewInstant(this, paramIntent);
  }
  
  protected void doOnPause()
  {
    dispatchActivityPrePaused(this);
    super.doOnPause();
    cleanScreenShot();
    dispatchActivityOnPause(this);
    dispatchActivityPostPaused(this);
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    sTopActivity = this;
    dispatchActivityPreResumed(this);
    this.currentActivityStayTime = SystemClock.uptimeMillis();
    SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
    if (localSystemBarCompact != null)
    {
      localSystemBarCompact.init();
      setOnMultiScreenChangeListener();
    }
    dispatchActivityResumed(this);
    ThreadManager.excute(new QBaseActivity.2(this), 64, null, true);
    resumeStatusBar();
    if (Build.VERSION.SDK_INT < 23) {
      ((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).adjustSimpleStatusBar(this.mSystemBarComp, getWindow());
    }
    dispatchActivityPostResumed(this);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    cleanScreenShot();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(this.className);
      ((StringBuilder)localObject).append(" onStart ");
      ((StringBuilder)localObject).append(Foreground.getActivityCountFromLifecycle(0));
      QLog.d("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (isWrapContent())
    {
      localObject = this.mFlingHandler;
      if (localObject != null) {
        ((FlingHandler)localObject).onStart();
      }
    }
    dispatchActivityStarted(this);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(hashCode());
      localStringBuilder.append("]");
      localStringBuilder.append(this.className);
      localStringBuilder.append(" onStop ");
      localStringBuilder.append(Foreground.getActivityCountFromLifecycle(2));
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
    cleanScreenShot();
    this.mStopFlag = 1;
    dispatchActivityStopped(this);
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    dispatchActivityWindowFocusChanged(this, paramBoolean);
  }
  
  public void finish()
  {
    try
    {
      super.finish();
      return;
    }
    catch (Exception localException)
    {
      label5:
      break label5;
    }
    QLog.e("qqBaseActivity", 1, "finish error");
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
  
  public String getCIOPageName()
  {
    return getClass().getName();
  }
  
  public boolean getCanLock()
  {
    return this.mCanLock;
  }
  
  public String getCurrentAccountUinFromRuntime()
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
  
  public BroadcastReceiver getDebugUiHierarchyBroadcastReceiver()
  {
    return this.mDebugUiHierarchyBroadcastReceiver;
  }
  
  public Runnable getNFCResumeRunnable()
  {
    return this.mNFCResumeRunnable;
  }
  
  public String getPreProcess()
  {
    return null;
  }
  
  public Runnable getRunnableRemoveNotification()
  {
    return this.runnableRemoveNotification;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public int getStatusBarVisibility()
  {
    return this.mStatusBarVisibility;
  }
  
  public int getStopFlag()
  {
    return this.mStopFlag;
  }
  
  public SystemBarCompact getSystemBarComp()
  {
    return this.mSystemBarComp;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  public void initNavigationBarColor()
  {
    ThemeNavigationBarUtil.a(getWindow());
  }
  
  public boolean isAttachedToWindow()
  {
    return this.mIsAttachedToWindow;
  }
  
  public boolean isCanLock()
  {
    return this.mCanLock;
  }
  
  @TargetApi(24)
  public boolean isInMultiWindow()
  {
    int i = Build.VERSION.SDK_INT;
    bool2 = false;
    bool1 = bool2;
    if (i >= 24) {}
    try
    {
      bool1 = isInMultiWindowMode();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        bool1 = bool2;
      }
    }
    if (QLog.isDebugVersion())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" fight...isInMultiWindowMode = ");
      localStringBuilder.append(bool1);
      QLog.i("qqBaseActivity", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public boolean isNeedInterruptDoMulitWindow()
  {
    return false;
  }
  
  public boolean isNeedMiniMsg()
  {
    return false;
  }
  
  public boolean isNeedStatusBarGone()
  {
    if (this.mWindowLocation == null) {
      this.mWindowLocation = new int[2];
    }
    getWindow().getDecorView().getLayoutParams();
    getWindow().getDecorView().getLocationOnScreen(this.mWindowLocation);
    int i = getWindow().getDecorView().getSystemUiVisibility();
    boolean bool = false;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((this.mWindowLocation[1] > 10) || (i == 0)) {
      bool = true;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fight..isNeedStatusBarGone ");
      localStringBuilder.append(bool);
      QLog.i("qqBaseActivity", 4, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean isShowOnFirst()
  {
    return this.mShowOnFirst;
  }
  
  public boolean isSupportScreenShot()
  {
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return true;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAccountChanged ");
      boolean bool;
      if (getAppRuntime() == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
    }
    dispatchAccountChanged(this);
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
    if ((paramBoolean) && (sTopActivity == this) && (QLog.isDevelopLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fight..onMultiWindowModeChanged ");
      localStringBuilder.append(getActivityName());
      QLog.i("qqBaseActivity", 4, localStringBuilder.toString());
    }
    dispatchOnMultiWindowModeChanged(this, paramBoolean);
  }
  
  public void onPostThemeChanged()
  {
    if (this.mSystemBarComp != null) {
      if (QQTheme.b())
      {
        this.mSystemBarComp.setStatusBarDrawable(getResources().getDrawable(2130846361));
      }
      else
      {
        this.mSystemBarComp.setStatusBarDrawable(null);
        this.mSystemBarComp.setStatusBarColor(getResources().getColor(2131167114));
      }
    }
    ((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).adjustSimpleStatusBar(this.mSystemBarComp, getWindow());
    initNavigationBarColor();
  }
  
  public void onPreThemeChanged() {}
  
  public void receiveScreenOff() {}
  
  public void registerActivityLifecycleCallbacks(BaseActivityLifecycleCallbacks paramBaseActivityLifecycleCallbacks)
  {
    synchronized (this.mActivityLifecycleCallbacks)
    {
      this.mActivityLifecycleCallbacks.add(paramBaseActivityLifecycleCallbacks);
      return;
    }
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      ((AppInterface)localAppRuntime).removeObserver(paramBusinessObserver);
    }
  }
  
  public void setAttachedToWindow(boolean paramBoolean)
  {
    this.mIsAttachedToWindow = paramBoolean;
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
  
  public void setDebugUiHierarchyBroadcastReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    this.mDebugUiHierarchyBroadcastReceiver = paramBroadcastReceiver;
  }
  
  public void setImmersiveStatus()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.mActNeedImmersive)
      {
        int i = getResources().getColor(2131167114);
        if (this.mSystemBarComp == null)
        {
          this.mSystemBarComp = new SystemBarCompact(this, true, i);
          if (QQTheme.b()) {
            this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130846361));
          } else {
            this.mSystemBarComp.setStatusDrawable(null);
          }
        }
      }
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
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
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
    }
  }
  
  public void setJumpDialog(Dialog paramDialog)
  {
    this.jumpDialog = paramDialog;
  }
  
  protected String setLastActivityName()
  {
    return getString(2131690706);
  }
  
  public void setNFCResumeRunnable(Runnable paramRunnable)
  {
    this.mNFCResumeRunnable = paramRunnable;
  }
  
  @TargetApi(11)
  public void setOnMultiScreenChangeListener()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = new QBaseActivity.5(this);
      try
      {
        View localView = getWindow().getDecorView();
        localView.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)localObject);
        if (localView.getSystemUiVisibility() != 0) {
          ((View.OnSystemUiVisibilityChangeListener)localObject).onSystemUiVisibilityChange(localView.getSystemUiVisibility());
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setOnMultiScreenChangeListener:");
          ((StringBuilder)localObject).append(localView.getSystemUiVisibility());
          ((StringBuilder)localObject).append(",Activity name:");
          ((StringBuilder)localObject).append(getClass().getName());
          QLog.d("qqBaseActivity", 4, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setOnMultiScreenChangeListener happen exception:");
          ((StringBuilder)localObject).append(localException.getMessage());
          ((StringBuilder)localObject).append(",Activity name:");
          ((StringBuilder)localObject).append(getClass().getName());
          QLog.d("qqBaseActivity", 4, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void setRunnableRemoveNotification(Runnable paramRunnable)
  {
    this.runnableRemoveNotification = paramRunnable;
  }
  
  public void setShowOnFirst(boolean paramBoolean)
  {
    this.mShowOnFirst = paramBoolean;
  }
  
  public void setStatusBarBlue()
  {
    if (QQTheme.b())
    {
      SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
      if (localSystemBarCompact != null) {
        localSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130846361));
      }
    }
  }
  
  public void setStatusBarVisibility(int paramInt)
  {
    this.mStatusBarVisibility = paramInt;
  }
  
  public void setStopFlag(int paramInt)
  {
    this.mStopFlag = paramInt;
  }
  
  public void setSystemBarComp(SystemBarCompact paramSystemBarCompact)
  {
    this.mSystemBarComp = paramSystemBarCompact;
  }
  
  public void startActivity(Intent paramIntent)
  {
    injectInterface.a(this, paramIntent);
    access$301(this, paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    injectInterface.a(this, paramIntent, paramBundle);
    access$401(this, paramIntent, paramBundle);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    injectInterface.a(this, paramIntent, paramInt);
    startActivityForResult(paramIntent, paramInt, 2);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (injectInterface.a(this, paramIntent, paramInt, paramBundle)) {}
  }
  
  public void startActivityForResultOriginal(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResultOriginal(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    access$501(this, paramIntent, paramInt, paramBundle);
  }
  
  protected void startActivityInner(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          super.startActivityForResult(paramIntent, paramInt1);
          return;
        }
        paramInt2 = hashCode();
        paramIntent.putExtra("fling_action_key", 2);
        paramIntent.putExtra("fling_code_key", paramInt2);
        super.startActivityForResult(paramIntent, paramInt1);
        return;
      }
      if ((getAppRuntime() != null) && (FlingAllowProvider.contain(getCurrentAccountUinFromRuntime())))
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
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  public void startUnlockActivity()
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startUnlockActivity...");
      ((StringBuilder)localObject).append(this.className);
      QLog.d("qqBaseActivity", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = injectInterface.a(this);
    ((Intent)localObject).putExtra("key_gesture_showgesture_valid", false);
    startActivityForResult((Intent)localObject, 12289);
    mShowGesture = SystemClock.uptimeMillis();
  }
  
  protected boolean themeChangeRightNow()
  {
    return true;
  }
  
  public void turnOffShake()
  {
    QBaseActivity.4 local4 = new QBaseActivity.4(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.getSubThreadHandler().post(local4);
      return;
    }
    local4.run();
  }
  
  public void turnOnShake()
  {
    QBaseActivity.3 local3 = new QBaseActivity.3(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.getSubThreadHandler().post(local3);
      return;
    }
    local3.run();
  }
  
  public void unregisterActivityLifecycleCallbacks(BaseActivityLifecycleCallbacks paramBaseActivityLifecycleCallbacks)
  {
    synchronized (this.mActivityLifecycleCallbacks)
    {
      this.mActivityLifecycleCallbacks.remove(paramBaseActivityLifecycleCallbacks);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity
 * JD-Core Version:    0.7.0.1
 */