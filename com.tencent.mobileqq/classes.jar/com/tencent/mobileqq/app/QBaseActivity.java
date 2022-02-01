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
  private static boolean isThemeSwitchOpen;
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
  
  /* Error */
  static
  {
    // Byte code:
    //   0: new 83	com/tencent/mobileqq/app/GlobalLifecycleCallbacks
    //   3: dup
    //   4: invokespecial 86	com/tencent/mobileqq/app/GlobalLifecycleCallbacks:<init>	()V
    //   7: putstatic 88	com/tencent/mobileqq/app/QBaseActivity:lifecycleCallbacks	Lcom/tencent/mobileqq/app/GlobalLifecycleCallbacks;
    //   10: getstatic 93	com/tencent/mobileqq/app/QBaseActivityInjectUtil:a	Ljava/util/ArrayList;
    //   13: invokevirtual 99	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   16: astore_0
    //   17: aload_0
    //   18: invokeinterface 105 1 0
    //   23: ifeq +70 -> 93
    //   26: aload_0
    //   27: invokeinterface 109 1 0
    //   32: checkcast 111	java/lang/Class
    //   35: astore_1
    //   36: getstatic 88	com/tencent/mobileqq/app/QBaseActivity:lifecycleCallbacks	Lcom/tencent/mobileqq/app/GlobalLifecycleCallbacks;
    //   39: aload_1
    //   40: invokevirtual 114	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   43: checkcast 116	com/tencent/mobileqq/app/lifecycle/BaseActivityLifecycleCallbacks
    //   46: invokevirtual 119	com/tencent/mobileqq/app/GlobalLifecycleCallbacks:a	(Lcom/tencent/mobileqq/app/lifecycle/BaseActivityLifecycleCallbacks;)V
    //   49: goto -32 -> 17
    //   52: astore_0
    //   53: ldc 18
    //   55: iconst_2
    //   56: ldc 121
    //   58: aload_0
    //   59: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   62: iconst_1
    //   63: putstatic 129	com/tencent/mobileqq/app/QBaseActivity:mAppForground	Z
    //   66: iconst_0
    //   67: putstatic 131	com/tencent/mobileqq/app/QBaseActivity:isUnLockSuccess	Z
    //   70: lconst_0
    //   71: putstatic 133	com/tencent/mobileqq/app/QBaseActivity:mAppBackgroundTime	J
    //   74: lconst_0
    //   75: putstatic 135	com/tencent/mobileqq/app/QBaseActivity:mShowGesture	J
    //   78: new 95	java/util/ArrayList
    //   81: dup
    //   82: invokespecial 136	java/util/ArrayList:<init>	()V
    //   85: putstatic 138	com/tencent/mobileqq/app/QBaseActivity:sActivityRoute	Ljava/util/ArrayList;
    //   88: iconst_0
    //   89: putstatic 140	com/tencent/mobileqq/app/QBaseActivity:isThemeSwitchOpen	Z
    //   92: return
    //   93: getstatic 143	com/tencent/mobileqq/app/QBaseActivityInjectUtil:c	Ljava/util/ArrayList;
    //   96: invokevirtual 147	java/util/ArrayList:size	()I
    //   99: ifle -37 -> 62
    //   102: getstatic 143	com/tencent/mobileqq/app/QBaseActivityInjectUtil:c	Ljava/util/ArrayList;
    //   105: iconst_0
    //   106: invokevirtual 151	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   109: checkcast 111	java/lang/Class
    //   112: invokevirtual 114	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   115: checkcast 153	com/tencent/mobileqq/app/IBaseActivityInjectInterface
    //   118: putstatic 155	com/tencent/mobileqq/app/QBaseActivity:injectInterface	Lcom/tencent/mobileqq/app/IBaseActivityInjectInterface;
    //   121: goto -59 -> 62
    //   124: astore_0
    //   125: ldc 18
    //   127: iconst_2
    //   128: ldc 121
    //   130: aload_0
    //   131: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   134: goto -72 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	11	0	localIterator	Iterator
    //   52	7	0	localIllegalAccessException	IllegalAccessException
    //   124	7	0	localInstantiationException	InstantiationException
    //   35	5	1	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   10	17	52	java/lang/IllegalAccessException
    //   17	49	52	java/lang/IllegalAccessException
    //   93	121	52	java/lang/IllegalAccessException
    //   10	17	124	java/lang/InstantiationException
    //   17	49	124	java/lang/InstantiationException
    //   93	121	124	java/lang/InstantiationException
  }
  
  private Object[] collectActivityLifecycleCallbacks()
  {
    Object[] arrayOfObject = null;
    synchronized (this.mActivityLifecycleCallbacks)
    {
      if (this.mActivityLifecycleCallbacks.size() > 0) {
        arrayOfObject = this.mActivityLifecycleCallbacks.toArray();
      }
      return arrayOfObject;
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
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  public static boolean isSensorReady()
  {
    return sSensorReady;
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
  
  private void printDecorView(String paramString) {}
  
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
      bool = QQTheme.a();
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor())) {
        if (!bool)
        {
          bool = true;
          ImmersiveUtils.setStatusTextColor(bool, getWindow());
        }
      }
    }
    while (ImmersiveUtils.isSupporImmersive() == 0)
    {
      boolean bool;
      do
      {
        for (;;)
        {
          return;
          bool = false;
        }
      } while ((ImmersiveUtils.isSupporImmersive() == 0) || (this.mSystemBarComp == null) || (bool));
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    ImmersiveUtils.setStatusTextColor(false, getWindow());
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
    catch (IllegalAccessException paramContext)
    {
      QLog.e("qqBaseActivity", 2, "QBaseActivity attachBaseContext: ", paramContext);
      return;
    }
    catch (InstantiationException paramContext)
    {
      QLog.e("qqBaseActivity", 2, "QBaseActivity attachBaseContext: ", paramContext);
    }
  }
  
  public void checkUnlockForSpecial()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=" + Foreground.getActivityCount() + ",stopflag" + this.mStopFlag);
    }
  }
  
  public void cleanScreenShot()
  {
    if (this.screenShot != null)
    {
      this.screenShot.a();
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
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
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
    Bundle localBundle;
    if (isWrapContent())
    {
      localBundle = getIntent().getExtras();
      if (localBundle == null) {}
    }
    try
    {
      i = localBundle.getInt("fling_action_key");
      if (i != 0)
      {
        if ((1 == i) && (getAppRuntime() != null) && (FlingAllowProvider.contain(getCurrentAccountUinFromRuntime()))) {
          this.mFlingHandler = new FlingTrackerHandler(this);
        }
      }
      else
      {
        printDecorView("do action at before set multiScreen: ");
        setOnMultiScreenChangeListener();
        ((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).adjustSimpleStatusBar(this.mSystemBarComp, getWindow());
        printDecorView("before call post create: ");
        dispatchActivityPostCreated(this, paramBundle);
        printDecorView("doOnCreate Finish: ");
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
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
      dispatchActivityDestroyed(this);
      if (sTopActivity == this) {
        sTopActivity = null;
      }
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
    dispatchNewInstant(this, paramIntent);
  }
  
  public void doOnPause()
  {
    dispatchActivityPrePaused(this);
    super.doOnPause();
    cleanScreenShot();
    dispatchActivityOnPause(this);
    dispatchActivityPostPaused(this);
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    sTopActivity = this;
    dispatchActivityPreResumed(this);
    this.currentActivityStayTime = SystemClock.uptimeMillis();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
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
  
  public void doOnStart()
  {
    super.doOnStart();
    cleanScreenShot();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onStart " + Foreground.getActivityCountFromLifecycle(0));
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onStart();
    }
    dispatchActivityStarted(this);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[" + hashCode() + "]" + this.className + " onStop " + Foreground.getActivityCountFromLifecycle(2));
    }
    cleanScreenShot();
    this.mStopFlag = 1;
    dispatchActivityStopped(this);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
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
    return getResources().getDimensionPixelSize(2131299166);
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
  
  public boolean isNeedMiniMsg()
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
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onAccountChanged ");
      if (getAppRuntime() != null) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("qqBaseActivity", 2, bool);
      dispatchAccountChanged(this);
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
    if ((paramBoolean) && (sTopActivity == this) && (QLog.isDevelopLevel())) {
      QLog.i("qqBaseActivity", 4, "fight..onMultiWindowModeChanged " + getActivityName());
    }
    dispatchOnMultiWindowModeChanged(this, paramBoolean);
  }
  
  public void onPostThemeChanged()
  {
    if (this.mSystemBarComp != null)
    {
      if (!QQTheme.b()) {
        break label57;
      }
      this.mSystemBarComp.setStatusBarDrawable(getResources().getDrawable(2130846481));
    }
    for (;;)
    {
      ((ISimpleUIUtil)QRoute.api(ISimpleUIUtil.class)).adjustSimpleStatusBar(this.mSystemBarComp, getWindow());
      initNavigationBarColor();
      return;
      label57:
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusBarColor(getResources().getColor(2131167091));
    }
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
        int i = getResources().getColor(2131167091);
        if (this.mSystemBarComp == null)
        {
          this.mSystemBarComp = new SystemBarCompact(this, true, i);
          if (!QQTheme.b()) {
            break label98;
          }
          this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130846481));
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      return;
      label98:
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
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
    }
  }
  
  public void setJumpDialog(Dialog paramDialog)
  {
    this.jumpDialog = paramDialog;
  }
  
  protected String setLastActivityName()
  {
    return getString(2131690778);
  }
  
  public void setNFCResumeRunnable(Runnable paramRunnable)
  {
    this.mNFCResumeRunnable = paramRunnable;
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
          QBaseActivity.5 local5 = new QBaseActivity.5(this);
          try
          {
            View localView = getWindow().getDecorView();
            localView.setOnSystemUiVisibilityChangeListener(local5);
            if (localView.getSystemUiVisibility() != 0) {
              local5.onSystemUiVisibilityChange(localView.getSystemUiVisibility());
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
    if ((QQTheme.b()) && (this.mSystemBarComp != null)) {
      this.mSystemBarComp.setStatusBarDrawable(getResources().getDrawable(2130846481));
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
    switch (paramInt2)
    {
    default: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 0: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 1: 
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
    paramInt2 = hashCode();
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", paramInt2);
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  public void startUnlockActivity()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("qqBaseActivity", 4, "startUnlockActivity..." + this.className);
    }
    Intent localIntent = injectInterface.a(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity
 * JD-Core Version:    0.7.0.1
 */