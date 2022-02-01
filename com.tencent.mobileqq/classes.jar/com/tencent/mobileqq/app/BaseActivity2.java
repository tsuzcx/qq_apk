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
  private static ShakeListener c;
  private static boolean d = false;
  static BaseActivity2 q;
  static boolean v = true;
  public SystemBarCompact A;
  private String a = getClass().getSimpleName();
  private FlingHandler b;
  private BroadcastReceiver e;
  SkinnableActivityProcesser p;
  ScreenShot r;
  boolean s = true;
  protected int t = 0;
  protected boolean u = true;
  protected long w;
  protected String x;
  public boolean y = true;
  public boolean z = true;
  
  public static <T extends View> T a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public static <T extends ViewGroup.LayoutParams> T a(View paramView)
  {
    return paramView.getLayoutParams();
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
  
  private void b()
  {
    ScreenShot localScreenShot = this.r;
    if (localScreenShot != null)
    {
      localScreenShot.d();
      this.r = null;
      ScreenShot.a("BaseActivity2 cleanScreenShot");
    }
  }
  
  private void d()
  {
    ThreadManager.excute(new BaseActivity2.2(this), 16, null, true);
  }
  
  public void c()
  {
    ThemeNavigationBarUtil.a(getWindow());
  }
  
  protected boolean cd_()
  {
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void m()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUnlockActivity...");
      localStringBuilder.append(this.a);
      QLog.d("BaseActivity2", 4, localStringBuilder.toString());
    }
    startActivity(new Intent(this, GesturePWDUnlockActivity.class));
  }
  
  protected void n()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=?,stopflag");
      localStringBuilder.append(this.t);
      QLog.d("BaseActivity2", 4, localStringBuilder.toString());
    }
  }
  
  protected boolean o()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    if (o()) {
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
    if (cd_())
    {
      FlingHandler localFlingHandler = this.b;
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
      paramBundle.append(this.a);
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
      this.x = BaseApplicationImpl.sApplication.getSharedPreferences("Last_Login", 4).getString("uin", null);
    }
    catch (IllegalStateException paramBundle)
    {
      this.x = null;
      if (QLog.isColorLevel()) {
        QLog.e("BaseActivity2", 2, "Get lastLoginUin error", paramBundle);
      }
    }
    if ((this.x == null) && (QLog.isColorLevel())) {
      QLog.d("BaseActivity2", 1, "last uin is null.. has problem");
    }
    ThreadManagerV2.excute(new BaseActivity2.LogActivityOnCreateRunnalbe(this), 16, null, true);
    if (InitSkin.sInited) {
      this.p = new SkinnableActivityProcesser(this, this);
    }
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("fling_action_key");
      if ((i != 0) && (cd_())) {
        if (1 == i) {
          this.b = new FlingTrackerHandler(this);
        } else {
          this.b = new FlingGestureHandler(this);
        }
      }
      this.u = paramBundle.getBoolean("PhotoConst.ALLOW_LOCK", true);
    }
    if (!d)
    {
      d();
      d = true;
    }
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      this.e = new BaseActivity2.MyScreenReceiver(this, null);
      registerReceiver(this.e, paramBundle);
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BaseActivity2", 2, "registerReceiver error", paramBundle);
      }
    }
    if ((this.y) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.z)
      {
        this.A = new SystemBarCompact(this, true, getResources().getColor(2131168092));
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
          this.A.setStatusDrawable(getResources().getDrawable(2130847834));
        } else {
          this.A.setStatusDrawable(null);
        }
      }
    }
    c();
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
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" process id =");
      ((StringBuilder)localObject).append(Process.myPid());
      ((StringBuilder)localObject).append(" onDestroy task : ");
      ((StringBuilder)localObject).append(getTaskId());
      QLog.i("BaseActivity2", 2, ((StringBuilder)localObject).toString());
    }
    q = null;
    ActivityLifeCycleInfoRecordHelper.d(this);
    Object localObject = this.e;
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
    localObject = this.p;
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
      localStringBuilder.append(this.a);
      localStringBuilder.append(" onPause");
      QLog.d("BaseActivity2", 2, localStringBuilder.toString());
    }
    this.s = true;
    ActivityLifeCycleInfoRecordHelper.c(this);
    b();
  }
  
  public void onPostThemeChanged()
  {
    c();
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
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" onResume ");
      QLog.d("BaseActivity2", 2, ((StringBuilder)localObject).toString());
    }
    this.s = false;
    ActivityLifeCycleInfoRecordHelper.b(this);
    q = this;
    this.w = SystemClock.uptimeMillis();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    Object localObject = getSharedPreferences("screen_shot", i).edit();
    ((SharedPreferences.Editor)localObject).putString("currentactivity", getClass().getName());
    if (Build.VERSION.SDK_INT > 8) {
      ((SharedPreferences.Editor)localObject).apply();
    } else {
      ((SharedPreferences.Editor)localObject).commit();
    }
    v = GesturePWDUtils.getAppForground(this);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume.mAppForground = ");
      ((StringBuilder)localObject).append(v);
      ((StringBuilder)localObject).append(",mCanLock=");
      ((StringBuilder)localObject).append(this.u);
      QLog.d("BaseActivity2", 4, ((StringBuilder)localObject).toString());
    }
    if ((!v) && (this.u))
    {
      localObject = this.x;
      if ((localObject != null) && (GesturePWDUtils.getJumpLock(this, (String)localObject)))
      {
        m();
        break label348;
      }
    }
    if ((!v) && (this.u)) {
      n();
    }
    label348:
    if (!v)
    {
      v = true;
      GesturePWDUtils.setAppForground(this, v);
    }
    this.t = 0;
    this.u = true;
    localObject = this.A;
    if ((localObject != null) && (this.z)) {
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
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" onStart");
      QLog.d("BaseActivity2", 2, ((StringBuilder)localObject).toString());
    }
    if (cd_())
    {
      localObject = this.b;
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
      localStringBuilder.append(this.a);
      localStringBuilder.append(" onStop");
      QLog.d("BaseActivity2", 2, localStringBuilder.toString());
    }
    this.t = 1;
    v = GesturePWDUtils.isAppOnForegroundByTasks(this);
    boolean bool = v;
    if (!bool) {
      GesturePWDUtils.setAppForground(this, bool);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "zsw subaccount onStop stop get sub msg AbsAppInter.visibleActCnt = ?");
    }
  }
  
  @TargetApi(24)
  public boolean p()
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
      QLog.i("BaseActivity2", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.t = 2;
    if (a(paramIntent)) {
      this.u = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2
 * JD-Core Version:    0.7.0.1
 */