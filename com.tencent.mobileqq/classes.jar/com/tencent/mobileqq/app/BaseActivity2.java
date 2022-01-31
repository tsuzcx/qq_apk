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
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.BaseActivity;
import zan;
import zao;

public class BaseActivity2
  extends BaseActivity
  implements SkinnableActivityProcesser.Callback
{
  public static boolean T = true;
  public static BaseActivity2 a;
  private static ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener;
  private static boolean jdField_a_of_type_Boolean;
  public boolean R = true;
  protected boolean S = true;
  public boolean U = true;
  public boolean V = true;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  public ScreenShot a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  public SystemBarCompact a;
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  public String q;
  protected int v;
  
  public static View a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public static ViewGroup.LayoutParams a(View paramView)
  {
    return paramView.getLayoutParams();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.a();
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot = null;
      ScreenShot.a("BaseActivity2 cleanScreenShot");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (jdField_a_of_type_ComTencentMobileqqAppShakeListener == null) {
        ThreadManager.post(new zan(this), 5, null, true);
      }
    }
    while (jdField_a_of_type_ComTencentMobileqqAppShakeListener == null) {
      return;
    }
    ((SensorManager)getSystemService("sensor")).unregisterListener(jdField_a_of_type_ComTencentMobileqqAppShakeListener);
    jdField_a_of_type_ComTencentMobileqqAppShakeListener = null;
  }
  
  private boolean a(Intent paramIntent)
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
  
  protected void S()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BaseActivity2", 4, "startUnlockActivity..." + this.jdField_a_of_type_JavaLangString);
    }
    startActivity(new Intent(this, GesturePWDUnlockActivity.class));
  }
  
  protected void T()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BaseActivity2", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=?,stopflag" + this.v);
    }
  }
  
  public View a(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int e()
  {
    return getResources().getDimensionPixelSize(2131558448);
  }
  
  protected boolean f()
  {
    return false;
  }
  
  @TargetApi(24)
  public boolean g()
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
  
  public void onBackPressed()
  {
    if (f()) {
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
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("BaseActivity2", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    try
    {
      paramBundle = BaseApplicationImpl.sApplication;
      if (Build.VERSION.SDK_INT <= 10) {
        break label373;
      }
      i = 4;
    }
    catch (IllegalStateException paramBundle)
    {
      try
      {
        for (;;)
        {
          registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
          if ((this.U) && (ImmersiveUtils.isSupporImmersive() == 1))
          {
            getWindow().addFlags(67108864);
            if (this.V)
            {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(this, true, getResources().getColor(2131494254));
              if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
                break;
              }
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130843344));
            }
          }
          return;
          int i = 0;
          continue;
          paramBundle = paramBundle;
          this.q = null;
          if (QLog.isColorLevel()) {
            QLog.e("BaseActivity2", 2, "Get lastLoginUin error", paramBundle);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingGestureHandler(this);
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("BaseActivity2", 2, "registerReceiver error", paramBundle);
          }
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(null);
      }
    }
    this.q = paramBundle.getSharedPreferences("Last_Login", i).getString("uin", null);
    if ((this.q == null) && (QLog.isColorLevel())) {
      QLog.d("BaseActivity2", 1, "last uin is null.. has porblem?");
    }
    StatisticCollector.a(this).a(this);
    if (InitSkin.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
    }
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      i = paramBundle.getInt("fling_action_key");
      if ((i != 0) && (a()))
      {
        if (1 == i) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingTrackerHandler(this);
        }
      }
      else {
        this.S = paramBundle.getBoolean("PhotoConst.ALLOW_LOCK", true);
      }
    }
    else
    {
      if (!jdField_a_of_type_Boolean)
      {
        if (SettingCloneUtil.readValue(this, null, getString(2131433581), "qqsetting_screenshot_key", false)) {
          a(true);
        }
        jdField_a_of_type_Boolean = true;
      }
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new zao(this, null);
    }
    label373:
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("BaseActivity2", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
    }
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = null;
    StatisticCollector.a(this).d(this);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label104:
      if (this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser != null) {
        this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser.destory();
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
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onPause");
    }
    this.R = true;
    StatisticCollector.a(this).c(this);
    a();
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onResume ");
    }
    this.R = false;
    StatisticCollector.a(this).b(this);
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = this;
    int i;
    SharedPreferences.Editor localEditor;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localEditor = getSharedPreferences("screen_shot", i).edit();
      localEditor.putString("currentactivity", getClass().getName());
      if (Build.VERSION.SDK_INT <= 8) {
        break label273;
      }
      localEditor.apply();
      label130:
      T = GesturePWDUtils.getAppForground(this);
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseActivity2", 4, "onResume.mAppForground = " + T + ",mCanLock=" + this.S);
      }
      if ((T) || (!this.S) || (this.q == null) || (!GesturePWDUtils.getJumpLock(this, this.q))) {
        break label283;
      }
      S();
    }
    for (;;)
    {
      if (!T)
      {
        T = true;
        GesturePWDUtils.setAppForground(this, T);
      }
      this.v = 0;
      this.S = true;
      if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) && (this.V)) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
      }
      return;
      i = 0;
      break;
      label273:
      localEditor.commit();
      break label130;
      label283:
      if ((!T) && (this.S)) {
        T();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStart");
    }
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStop");
    }
    this.v = 1;
    T = GesturePWDUtils.isAppOnForegroundByTasks(this);
    if (!T) {
      GesturePWDUtils.setAppForground(this, T);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "zsw subaccount onStop stop get sub msg AbsAppInter.visibleActCnt = ?");
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.v = 2;
    if (a(paramIntent)) {
      this.S = false;
    }
    switch (2)
    {
    }
    try
    {
      super.startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (Exception paramIntent)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("BaseActivity2", 2, "startActivity failed with: ", paramIntent);
      return;
      paramIntent.putExtra("fling_action_key", 2);
      paramIntent.putExtra("fling_code_key", hashCode());
      super.startActivityForResult(paramIntent, paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2
 * JD-Core Version:    0.7.0.1
 */