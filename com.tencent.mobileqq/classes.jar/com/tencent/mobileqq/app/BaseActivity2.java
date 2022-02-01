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
import com.tencent.aelight.camera.util.api.IAIOShortVideoUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.tools.ActivityLifeCycleInfoRecordHelper;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.BaseActivity;

public class BaseActivity2
  extends BaseActivity
  implements SkinnableActivityProcesser.Callback
{
  static BaseActivity2 jdField_a_of_type_ComTencentMobileqqAppBaseActivity2;
  private static ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener;
  private static boolean jdField_a_of_type_Boolean = false;
  static boolean h = true;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  ScreenShot jdField_a_of_type_ComTencentMobileqqAppScreenShot;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  public SystemBarCompact a;
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  protected long b;
  protected String b;
  protected int c = 0;
  boolean f = true;
  protected boolean g = true;
  public boolean i = true;
  public boolean j = true;
  
  public static <T extends View> T a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public static <T extends ViewGroup.LayoutParams> T a(View paramView)
  {
    return paramView.getLayoutParams();
  }
  
  private void a()
  {
    ScreenShot localScreenShot = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot;
    if (localScreenShot != null)
    {
      localScreenShot.a();
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot = null;
      ScreenShot.a("BaseActivity2 cleanScreenShot");
    }
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", hashCode());
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  private boolean a(Intent paramIntent)
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
  
  private void c()
  {
    ThreadManager.excute(new BaseActivity2.2(this), 16, null, true);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b()
  {
    ThemeNavigationBarUtil.a(getWindow());
  }
  
  protected boolean b()
  {
    return false;
  }
  
  @TargetApi(24)
  public boolean c()
  {
    int k = Build.VERSION.SDK_INT;
    bool2 = false;
    bool1 = bool2;
    if (k >= 24) {}
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
      QLog.i("BaseActivity2", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void l()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUnlockActivity...");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("BaseActivity2", 4, localStringBuilder.toString());
    }
    startActivity(new Intent(this, GesturePWDUnlockActivity.class));
  }
  
  protected void m()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=?,stopflag");
      localStringBuilder.append(this.c);
      QLog.d("BaseActivity2", 4, localStringBuilder.toString());
    }
  }
  
  public void onBackPressed()
  {
    if (b()) {
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
    if (a())
    {
      FlingHandler localFlingHandler = this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
      if (localFlingHandler != null) {
        localFlingHandler.onConfigurationChanged(paramConfiguration);
      }
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("[");
      paramBundle.append(hashCode());
      paramBundle.append("]");
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      paramBundle.append(" process id =");
      paramBundle.append(Process.myPid());
      paramBundle.append(" onCreate task : ");
      paramBundle.append(getTaskId());
      QLog.i("BaseActivity2", 2, paramBundle.toString());
    }
    try
    {
      if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
      {
        ((IAIOShortVideoUtil)QRoute.api(IAIOShortVideoUtil.class)).setBaseActivtiyCreateTime(System.currentTimeMillis());
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_CREATE ", Long.valueOf(((IAIOShortVideoUtil)QRoute.api(IAIOShortVideoUtil.class)).getBaseActivtiyCreateTime()) });
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("BaseActivity2", 1, "getLongExtra fail, ", paramBundle);
    }
    try
    {
      this.jdField_b_of_type_JavaLangString = BaseApplicationImpl.sApplication.getSharedPreferences("Last_Login", 4).getString("uin", null);
    }
    catch (IllegalStateException paramBundle)
    {
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.e("BaseActivity2", 2, "Get lastLoginUin error", paramBundle);
      }
    }
    if ((this.jdField_b_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d("BaseActivity2", 1, "last uin is null.. has problem");
    }
    ThreadManagerV2.excute(new BaseActivity2.LogActivityOnCreateRunnalbe(this), 16, null, true);
    if (InitSkin.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
    }
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      int k = paramBundle.getInt("fling_action_key");
      if ((k != 0) && (a())) {
        if (1 == k) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingTrackerHandler(this);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingGestureHandler(this);
        }
      }
      this.g = paramBundle.getBoolean("PhotoConst.ALLOW_LOCK", true);
    }
    if (!jdField_a_of_type_Boolean)
    {
      c();
      jdField_a_of_type_Boolean = true;
    }
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new BaseActivity2.MyScreenReceiver(this, null);
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BaseActivity2", 2, "registerReceiver error", paramBundle);
      }
    }
    if ((this.i) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.j)
      {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(this, true, getResources().getColor(2131167114));
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130846361));
        } else {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(null);
        }
      }
    }
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" process id =");
      ((StringBuilder)localObject).append(Process.myPid());
      ((StringBuilder)localObject).append(" onDestroy task : ");
      ((StringBuilder)localObject).append(getTaskId());
      QLog.i("BaseActivity2", 2, ((StringBuilder)localObject).toString());
    }
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = null;
    ActivityLifeCycleInfoRecordHelper.d(this);
    Object localObject = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localObject != null) {}
    try
    {
      unregisterReceiver((BroadcastReceiver)localObject);
    }
    catch (Exception localException)
    {
      label120:
      break label120;
    }
    localObject = this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
    if (localObject != null) {
      ((SkinnableActivityProcesser)localObject).destory();
    }
  }
  
  @TargetApi(24)
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  protected void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(hashCode());
      localStringBuilder.append("]");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" onPause");
      QLog.d("BaseActivity2", 2, localStringBuilder.toString());
    }
    this.f = true;
    ActivityLifeCycleInfoRecordHelper.c(this);
    a();
  }
  
  public void onPostThemeChanged()
  {
    b();
  }
  
  public void onPreThemeChanged() {}
  
  @TargetApi(9)
  protected void onResume()
  {
    super.onResume();
    if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
    {
      ((IAIOShortVideoUtil)QRoute.api(IAIOShortVideoUtil.class)).setBaseActivtiyResumeTime(System.currentTimeMillis());
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_RESUME ", Long.valueOf(((IAIOShortVideoUtil)QRoute.api(IAIOShortVideoUtil.class)).getBaseActivtiyResumeTime()) });
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" onResume ");
      QLog.d("BaseActivity2", 2, ((StringBuilder)localObject).toString());
    }
    this.f = false;
    ActivityLifeCycleInfoRecordHelper.b(this);
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = this;
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    int k;
    if (Build.VERSION.SDK_INT > 10) {
      k = 4;
    } else {
      k = 0;
    }
    Object localObject = getSharedPreferences("screen_shot", k).edit();
    ((SharedPreferences.Editor)localObject).putString("currentactivity", getClass().getName());
    if (Build.VERSION.SDK_INT > 8) {
      ((SharedPreferences.Editor)localObject).apply();
    } else {
      ((SharedPreferences.Editor)localObject).commit();
    }
    h = GesturePWDUtils.getAppForground(this);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume.mAppForground = ");
      ((StringBuilder)localObject).append(h);
      ((StringBuilder)localObject).append(",mCanLock=");
      ((StringBuilder)localObject).append(this.g);
      QLog.d("BaseActivity2", 4, ((StringBuilder)localObject).toString());
    }
    if ((!h) && (this.g))
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      if ((localObject != null) && (GesturePWDUtils.getJumpLock(this, (String)localObject)))
      {
        l();
        break label348;
      }
    }
    if ((!h) && (this.g)) {
      m();
    }
    label348:
    if (!h)
    {
      h = true;
      GesturePWDUtils.setAppForground(this, h);
    }
    this.c = 0;
    this.g = true;
    localObject = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
    if ((localObject != null) && (this.j)) {
      ((SystemBarCompact)localObject).init();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
    {
      ((IAIOShortVideoUtil)QRoute.api(IAIOShortVideoUtil.class)).setBaseActivtiyStartTime(System.currentTimeMillis());
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_START ", Long.valueOf(((IAIOShortVideoUtil)QRoute.api(IAIOShortVideoUtil.class)).getBaseActivtiyStartTime()) });
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" onStart");
      QLog.d("BaseActivity2", 2, ((StringBuilder)localObject).toString());
    }
    if (a())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
      if (localObject != null) {
        ((FlingHandler)localObject).onStart();
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(hashCode());
      localStringBuilder.append("]");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" onStop");
      QLog.d("BaseActivity2", 2, localStringBuilder.toString());
    }
    this.c = 1;
    h = GesturePWDUtils.isAppOnForegroundByTasks(this);
    boolean bool = h;
    if (!bool) {
      GesturePWDUtils.setAppForground(this, bool);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "zsw subaccount onStop stop get sub msg AbsAppInter.visibleActCnt = ?");
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.c = 2;
    if (a(paramIntent)) {
      this.g = false;
    }
    try
    {
      a(paramIntent, paramInt);
      return;
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseActivity2", 2, "startActivity failed with: ", paramIntent);
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2
 * JD-Core Version:    0.7.0.1
 */