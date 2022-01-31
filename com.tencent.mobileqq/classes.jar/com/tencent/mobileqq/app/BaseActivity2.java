package com.tencent.mobileqq.app;

import ajsu;
import akgf;
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
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import axcz;
import axrn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.app.BaseActivity;

public class BaseActivity2
  extends BaseActivity
  implements SkinnableActivityProcesser.Callback
{
  private static akgf jdField_a_of_type_Akgf;
  public static BaseActivity2 a;
  private static boolean jdField_a_of_type_Boolean;
  public static boolean ab = true;
  public boolean Z = true;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  public ScreenShot a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  public SystemBarCompact a;
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  protected boolean aa = true;
  public boolean ac = true;
  public boolean ad = true;
  protected long h;
  public String q;
  protected int w;
  
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.a();
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot = null;
      ScreenShot.a("BaseActivity2 cleanScreenShot");
    }
  }
  
  private void a(Intent paramIntent, int paramInt)
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
  
  private void b()
  {
    ThreadManager.excute(new BaseActivity2.2(this), 16, null, true);
  }
  
  protected void V()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BaseActivity2", 4, "startUnlockActivity..." + this.jdField_a_of_type_JavaLangString);
    }
    startActivity(new Intent(this, GesturePWDUnlockActivity.class));
  }
  
  protected void W()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BaseActivity2", 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=?,stopflag" + this.w);
    }
  }
  
  public <T extends View> T a(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public int e()
  {
    return getResources().getDimensionPixelSize(2131298865);
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
      if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
      {
        axcz.e = System.currentTimeMillis();
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_CREATE ", Long.valueOf(axcz.e) });
      }
    }
    catch (Exception paramBundle)
    {
      try
      {
        this.q = BaseApplicationImpl.sApplication.getSharedPreferences("Last_Login", 4).getString("uin", null);
        if ((this.q == null) && (QLog.isColorLevel())) {
          QLog.d("BaseActivity2", 1, "last uin is null.. has problem");
        }
        ThreadManagerV2.excute(new BaseActivity2.LogActivityOnCreateRunnalbe(this), 16, null, true);
        if (InitSkin.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
        }
        paramBundle = getIntent().getExtras();
        if (paramBundle != null)
        {
          int i = paramBundle.getInt("fling_action_key");
          if ((i != 0) && (a()))
          {
            if (1 == i) {
              this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingTrackerHandler(this);
            }
          }
          else {
            this.aa = paramBundle.getBoolean("PhotoConst.ALLOW_LOCK", true);
          }
        }
        else if (!jdField_a_of_type_Boolean)
        {
          b();
          jdField_a_of_type_Boolean = true;
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
            this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ajsu(this, null);
            registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
            if ((this.ac) && (ImmersiveUtils.isSupporImmersive() == 1))
            {
              getWindow().addFlags(67108864);
              if (this.ad)
              {
                this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(this, true, getResources().getColor(2131166910));
                if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
                  break;
                }
                this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130845305));
              }
            }
            return;
            paramBundle = paramBundle;
            QLog.e("BaseActivity2", 1, "getLongExtra fail, ", paramBundle);
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
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("BaseActivity2", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
    }
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = null;
    axrn.a(this).d(this);
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
    this.Z = true;
    axrn.a(this).c(this);
    a();
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
    if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
    {
      axcz.i = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_RESUME ", Long.valueOf(axcz.i) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onResume ");
    }
    this.Z = false;
    axrn.a(this).b(this);
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = this;
    this.h = SystemClock.uptimeMillis();
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
      ab = GesturePWDUtils.getAppForground(this);
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseActivity2", 4, "onResume.mAppForground = " + ab + ",mCanLock=" + this.aa);
      }
      if ((ab) || (!this.aa) || (this.q == null) || (!GesturePWDUtils.getJumpLock(this, this.q))) {
        break label338;
      }
      V();
    }
    for (;;)
    {
      if (!ab)
      {
        ab = true;
        GesturePWDUtils.setAppForground(this, ab);
      }
      this.w = 0;
      this.aa = true;
      if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) && (this.ad)) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
      }
      return;
      i = 0;
      break;
      label328:
      localEditor.commit();
      break label185;
      label338:
      if ((!ab) && (this.aa)) {
        W();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L) != 0L)
    {
      axcz.g = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_BASE_ACTIVITY_START ", Long.valueOf(axcz.g) });
    }
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
    this.w = 1;
    ab = GesturePWDUtils.isAppOnForegroundByTasks(this);
    if (!ab) {
      GesturePWDUtils.setAppForground(this, ab);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity2", 2, "zsw subaccount onStop stop get sub msg AbsAppInter.visibleActCnt = ?");
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.w = 2;
    if (a(paramIntent)) {
      this.aa = false;
    }
    try
    {
      a(paramIntent, paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2
 * JD-Core Version:    0.7.0.1
 */