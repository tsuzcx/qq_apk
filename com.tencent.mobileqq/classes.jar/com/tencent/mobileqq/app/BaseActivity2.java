package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.shortvideo.AIOShortVideoUtil;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.BaseActivity;

public class BaseActivity2
  extends BaseActivity
  implements SkinnableActivityProcesser.Callback
{
  private static final int DEFAULT_FLING_ACTION = 2;
  protected static final String TAG = "BaseActivity2";
  static boolean mAppForground = true;
  private static ShakeListener shakeListener;
  private static boolean snapChecked;
  static BaseActivity2 topActivity;
  private String className = getClass().getSimpleName();
  protected long currentActivityStayTime;
  boolean isPause = true;
  public String lastLoginUin;
  public boolean mActNeedImmersive = true;
  protected boolean mCanLock = true;
  private FlingHandler mFlingHandler;
  public boolean mNeedStatusTrans = true;
  private BroadcastReceiver mScreenReceiver;
  protected int mStopFlag = 0;
  public SystemBarCompact mSystemBarComp;
  public int[] mWindowLocation;
  SkinnableActivityProcesser processer;
  ScreenShot screenShot;
  
  private void cleanScreenShot()
  {
    if (this.screenShot != null)
    {
      this.screenShot.a();
      this.screenShot = null;
      ScreenShot.a("BaseActivity2 cleanScreenShot");
    }
  }
  
  public static <T extends View> T findViewById(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public static <T extends ViewGroup.LayoutParams> T getLayoutParams(View paramView)
  {
    return paramView.getLayoutParams();
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
  
  private void setShakeEnabled()
  {
    ThreadManager.excute(new BaseActivity2.2(this), 16, null, true);
  }
  
  private void startActivityInner(Intent paramIntent, int paramInt)
  {
    switch (2)
    {
    default: 
      super.startActivityForResult(paramIntent, paramInt);
      return;
    case 0: 
      super.startActivityForResult(paramIntent, paramInt);
      return;
    }
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", hashCode());
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  protected void checkUnlockForSpecial()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BaseActivity2", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=?,stopflag" + this.mStopFlag);
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
  
  public void doInMultiWindowModeStatusBarVisibilityChange(int paramInt) {}
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299166);
  }
  
  public void initNavigationBarColor()
  {
    ThemeNavigationBarUtil.a(getWindow());
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
        QLog.i("BaseActivity2", 2, " fight...isInMultiWindowMode = " + bool1);
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
  
  public boolean isNeedStatusBarGone()
  {
    boolean bool = true;
    if (this.mWindowLocation == null) {
      this.mWindowLocation = new int[2];
    }
    getWindow().getDecorView().getLayoutParams();
    getWindow().getDecorView().getLocationOnScreen(this.mWindowLocation);
    if (this.mWindowLocation[1] > 10) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("BaseActivity2", 4, "fight..isNeedStatusBarGone " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  protected boolean isWrapContent()
  {
    return true;
  }
  
  protected boolean onBackEvent()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    if (onBackEvent()) {
      return;
    }
    try
    {
      super.onBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseActivity2", 2, "", localThrowable);
      }
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onConfigurationChanged(paramConfiguration);
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    try
    {
      if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
      {
        AIOShortVideoUtil.e = System.currentTimeMillis();
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_CREATE ", Long.valueOf(AIOShortVideoUtil.e) });
      }
    }
    catch (Exception paramBundle)
    {
      try
      {
        this.lastLoginUin = BaseApplicationImpl.sApplication.getSharedPreferences("Last_Login", 4).getString("uin", null);
        if ((this.lastLoginUin == null) && (QLog.isColorLevel())) {
          QLog.d("BaseActivity2", 1, "last uin is null.. has problem");
        }
        ThreadManagerV2.excute(new BaseActivity2.LogActivityOnCreateRunnalbe(this), 16, null, true);
        if (InitSkin.a) {
          this.processer = new SkinnableActivityProcesser(this, this);
        }
        paramBundle = getIntent().getExtras();
        if (paramBundle != null)
        {
          int i = paramBundle.getInt("fling_action_key");
          if ((i != 0) && (isWrapContent()))
          {
            if (1 == i) {
              this.mFlingHandler = new FlingTrackerHandler(this);
            }
          }
          else {
            this.mCanLock = paramBundle.getBoolean("PhotoConst.ALLOW_LOCK", true);
          }
        }
        else if (!snapChecked)
        {
          setShakeEnabled();
          snapChecked = true;
        }
      }
      catch (IllegalStateException paramBundle)
      {
        try
        {
          for (;;)
          {
            paramBundle = new IntentFilter();
            paramBundle.addAction("android.intent.action.SCREEN_OFF");
            this.mScreenReceiver = new BaseActivity2.MyScreenReceiver(this, null);
            registerReceiver(this.mScreenReceiver, paramBundle);
            if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
            {
              getWindow().addFlags(67108864);
              if (this.mActNeedImmersive)
              {
                this.mSystemBarComp = new SystemBarCompact(this, true, getResources().getColor(2131167091));
                if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
                  break;
                }
                this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130846481));
              }
            }
            initNavigationBarColor();
            return;
            paramBundle = paramBundle;
            QLog.e("BaseActivity2", 1, "getLongExtra fail, ", paramBundle);
            continue;
            paramBundle = paramBundle;
            this.lastLoginUin = null;
            if (QLog.isColorLevel()) {
              QLog.e("BaseActivity2", 2, "Get lastLoginUin error", paramBundle);
            }
          }
          this.mFlingHandler = new FlingGestureHandler(this);
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e("BaseActivity2", 2, "registerReceiver error", paramBundle);
              continue;
              this.mSystemBarComp.setStatusDrawable(null);
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
    }
    topActivity = null;
    StatisticCollector.getInstance(this).logOnDestroy(this);
    if (this.mScreenReceiver != null) {}
    try
    {
      unregisterReceiver(this.mScreenReceiver);
      label104:
      if (this.processer != null) {
        this.processer.destory();
      }
      return;
    }
    catch (Exception localException)
    {
      break label104;
    }
  }
  
  @TargetApi(24)
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " onPause");
    }
    this.isPause = true;
    StatisticCollector.getInstance(this).logOnPause(this);
    cleanScreenShot();
  }
  
  public void onPostThemeChanged()
  {
    initNavigationBarColor();
  }
  
  public void onPreThemeChanged() {}
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
    if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
    {
      AIOShortVideoUtil.i = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_RESUME ", Long.valueOf(AIOShortVideoUtil.i) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " onResume ");
    }
    this.isPause = false;
    StatisticCollector.getInstance(this).logOnResume(this);
    topActivity = this;
    this.currentActivityStayTime = SystemClock.uptimeMillis();
    int i;
    SharedPreferences.Editor localEditor;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localEditor = getSharedPreferences("screen_shot", i).edit();
      localEditor.putString("currentactivity", getClass().getName());
      if (Build.VERSION.SDK_INT <= 8) {
        break label328;
      }
      localEditor.apply();
      label185:
      mAppForground = GesturePWDUtils.getAppForground(this);
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseActivity2", 4, "onResume.mAppForground = " + mAppForground + ",mCanLock=" + this.mCanLock);
      }
      if ((mAppForground) || (!this.mCanLock) || (this.lastLoginUin == null) || (!GesturePWDUtils.getJumpLock(this, this.lastLoginUin))) {
        break label338;
      }
      startUnlockActivity();
    }
    for (;;)
    {
      if (!mAppForground)
      {
        mAppForground = true;
        GesturePWDUtils.setAppForground(this, mAppForground);
      }
      this.mStopFlag = 0;
      this.mCanLock = true;
      if ((this.mSystemBarComp != null) && (this.mActNeedImmersive)) {
        this.mSystemBarComp.init();
      }
      return;
      i = 0;
      break;
      label328:
      localEditor.commit();
      break label185;
      label338:
      if ((!mAppForground) && (this.mCanLock)) {
        checkUnlockForSpecial();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
    {
      AIOShortVideoUtil.g = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_START ", Long.valueOf(AIOShortVideoUtil.g) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " onStart");
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.className + " onStop");
    }
    this.mStopFlag = 1;
    mAppForground = GesturePWDUtils.isAppOnForegroundByTasks(this);
    if (!mAppForground) {
      GesturePWDUtils.setAppForground(this, mAppForground);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "zsw subaccount onStop stop get sub msg AbsAppInter.visibleActCnt = ?");
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.mStopFlag = 2;
    if (isStartQQ3rdApp(paramIntent)) {
      this.mCanLock = false;
    }
    try
    {
      startActivityInner(paramIntent, paramInt);
      return;
    }
    catch (Exception paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BaseActivity2", 2, "startActivity failed with: ", paramIntent);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    try
    {
      JefsClass.getInstance().b(this, paramIntent, new BaseActivity2.1(this, paramIntent, paramInt, paramBundle));
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("BaseActivity2", 1, paramIntent, new Object[0]);
    }
  }
  
  protected void startUnlockActivity()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BaseActivity2", 4, "startUnlockActivity..." + this.className);
    }
    startActivity(new Intent(this, GesturePWDUnlockActivity.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2
 * JD-Core Version:    0.7.0.1
 */