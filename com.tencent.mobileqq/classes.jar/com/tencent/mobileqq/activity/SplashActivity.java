package com.tencent.mobileqq.activity;

import Override;
import aauu;
import aczy;
import aeyy;
import aeyz;
import afoc;
import afof;
import aldh;
import alvr;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import aoaj;
import aqnd;
import avpd;
import awtm;
import bakd;
import bakg;
import baol;
import baom;
import bcrn;
import bdgt;
import bdla;
import bdlm;
import bhdj;
import bheh;
import bhey;
import bhhy;
import bibb;
import bmhv;
import bmll;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter;
import com.tencent.mobileqq.minigame.ui.GameActivity3;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.api.QZoneApiProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import nyv;

public class SplashActivity
  extends FragmentActivity
{
  public static volatile int a;
  public static long a;
  public static volatile WeakReference<SplashActivity> a;
  public static volatile boolean a;
  public static int b;
  public static int c;
  private static long jdField_d_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public View a;
  private String jdField_a_of_type_JavaLangString;
  public View[] a;
  private long jdField_b_of_type_Long;
  public View b;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int = -2;
  private long e = -1L;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_Boolean = true;
    jdField_d_of_type_Long = 500L;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      String str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("SplashActivity escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.sSplashActivityEscapedMsg = str + "\n" + Log.getStackTraceString(localThrowable);
        return;
      }
    }
    BaseApplicationImpl.sSplashActivityEscapedMsg = "";
  }
  
  public static void a()
  {
    ScreenUtil.updateCache();
    com.tencent.widget.XPanelContainer.jdField_d_of_type_Int = 0;
  }
  
  private boolean a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("open_chatfragment", false))
    {
      aldh.a(this.app, paramIntent);
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      a(false, 0);
      return true;
    }
    return false;
  }
  
  public static boolean a(SplashActivity paramSplashActivity, AppInterface paramAppInterface)
  {
    QLog.d("SplashActivity", 2, "jumpMiniGameAction");
    MiniAppReportManager.splashMiniGameClickReport(SplashMiniGameStarter.curData);
    SplashMiniGameStarter.needJump = false;
    SplashMiniGameStarter.setHasJumped();
    paramAppInterface = new Intent(BaseApplicationImpl.getApplication(), GameActivity3.class);
    paramAppInterface.addFlags(805371904);
    paramAppInterface.putExtra("fromSplash", true);
    paramAppInterface.putExtra("processName", "com.tencent.mobileqq:mini3");
    paramAppInterface.putExtra("startDuration", System.currentTimeMillis());
    paramAppInterface.putExtra("splashData", SplashMiniGameStarter.curData);
    paramSplashActivity.startActivity(paramAppInterface);
    paramSplashActivity.overridePendingTransition(17432576, 17432577);
    return true;
  }
  
  public static boolean a(SplashActivity paramSplashActivity, QQAppInterface paramQQAppInterface, baom parambaom)
  {
    if (parambaom == null) {}
    for (;;)
    {
      return false;
      try
      {
        int i = parambaom.jdField_b_of_type_Int;
        baol.jdField_a_of_type_Boolean = false;
        switch (i)
        {
        case 1: 
          if (TextUtils.isEmpty(parambaom.f))
          {
            QLog.i("QSplash@QbossSplashUtil", 1, "jumpH5Url is null");
            return false;
          }
          Intent localIntent = new Intent(paramSplashActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", parambaom.f);
          localIntent.putExtra("key_from_splash_ad", true);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
          paramSplashActivity.startActivity(localIntent);
          if (paramQQAppInterface != null)
          {
            baol.a(parambaom.j, null, 2);
            bmll.a(paramQQAppInterface.getCurrentUin() + "", 102, parambaom.jdField_b_of_type_JavaLangString, parambaom.j);
          }
          break;
        case 4: 
          if (TextUtils.isEmpty(parambaom.f))
          {
            QLog.i("QSplash@QbossSplashUtil", 1, "scheme is null");
            return false;
          }
          bhey.a(paramQQAppInterface, paramSplashActivity, parambaom.f).a();
          if (paramQQAppInterface != null)
          {
            baol.a(parambaom.j, null, 2);
            bmll.a(paramQQAppInterface.getCurrentUin() + "", 102, parambaom.jdField_b_of_type_JavaLangString, parambaom.j);
            return false;
          }
          break;
        case 2: 
        case 3: 
        default: 
          return false;
        }
      }
      catch (Exception paramSplashActivity)
      {
        return false;
      }
    }
    return true;
  }
  
  private boolean b()
  {
    SplashActivity localSplashActivity = null;
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {
      localSplashActivity = (SplashActivity)jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if ((localSplashActivity != null) && (localSplashActivity != this) && (!localSplashActivity.isFinishing()))
    {
      int i = getTaskId();
      int j = localSplashActivity.getTaskId();
      QLog.d("SplashActivity", 1, "checkDuplication, " + localSplashActivity + ", " + j + ", " + this + ", " + i);
      if (i == j) {
        return true;
      }
      localSplashActivity.finish();
    }
    return false;
  }
  
  private boolean b(Intent paramIntent)
  {
    int i = 0;
    if ((paramIntent.getBooleanExtra("open_kandian_tab_fragment", false)) && (bmhv.n()))
    {
      setIntent(paramIntent);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        jdField_a_of_type_Int = 1;
        localObject = MainFragment.a();
        ((MainFragment)localObject).a = paramIntent;
        localFragmentTransaction.add(16908290, (Fragment)localObject, MainFragment.class.getName());
        localFragmentTransaction.commitAllowingStateLoss();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "tryOpenKandianTab type : " + i);
        }
        return true;
        b(paramIntent);
        i = 1;
      }
    }
    return false;
  }
  
  private void c(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("forward", -1);
    int j = paramIntent.getIntExtra("uintype", -1);
    if ((i > 0) && ((j == 1035) || (j == 1041) || (j == 1042)) && (this.app.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER)))
    {
      ((awtm)this.app.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a(this, paramIntent);
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      getIntent().removeExtra("forward");
      return;
      Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
      localIntent.putExtra("uin", paramIntent.getStringExtra("uin"));
      localIntent.putExtra("uintype", paramIntent.getIntExtra("uintype", 0));
      localIntent.putExtra("yuyin", paramIntent.getBooleanExtra("yuyin", false));
      localIntent.putExtra("uinname", paramIntent.getStringExtra("uinname"));
      localIntent.putExtra("enterchatwin", true);
      startActivity(localIntent);
      getIntent().removeExtra("fromMsgBox");
      continue;
      paramIntent = paramIntent.getParcelableExtra("AllInOne");
      if ((paramIntent instanceof ProfileActivity.AllInOne))
      {
        paramIntent = (ProfileActivity.AllInOne)paramIntent;
        paramIntent.g = 100;
        paramIntent.h = 6;
        ProfileActivity.b(this, paramIntent);
        continue;
        paramIntent = paramIntent.getStringExtra("url");
        localIntent = new Intent(this, QQBrowserActivity.class);
        if (j != -1)
        {
          localIntent.putExtra("uintype", j);
          if ((j == 1030) && (this.app.isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)))
          {
            ((aqnd)this.app.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(null);
            if (QLog.isColorLevel()) {
              QLog.d("CampusNoticeManager", 2, "remove campus notice");
            }
          }
        }
        localIntent.putExtra("url", paramIntent);
        startActivity(localIntent);
      }
    }
  }
  
  private boolean c()
  {
    if ((baol.jdField_a_of_type_Boolean) && (baol.jdField_a_of_type_Baom != null) && (a(this, this.app, baol.jdField_a_of_type_Baom)))
    {
      finish();
      return false;
    }
    if ((SplashMiniGameStarter.needJump) && (a(this, this.app)))
    {
      finish();
      return false;
    }
    return true;
  }
  
  private boolean c(Intent paramIntent)
  {
    int i = 0;
    if ((paramIntent.getBooleanExtra("open_qzone_tab_fragment", false)) && (QZoneApiProxy.isInQZoneEnvironment()))
    {
      setIntent(paramIntent);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        jdField_a_of_type_Int = 1;
        localObject = MainFragment.a();
        ((MainFragment)localObject).a = paramIntent;
        localFragmentTransaction.add(16908290, (Fragment)localObject, MainFragment.class.getName());
        localFragmentTransaction.commitAllowingStateLoss();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "tryOpenQzoneTab type : " + i);
        }
        return true;
        b(paramIntent);
        i = 1;
      }
    }
    return false;
  }
  
  private void d()
  {
    String str2;
    if (GesturePWDUtils.getGestureUnlockFailed(this, this.app.getCurrentAccountUin()))
    {
      str2 = getString(2131692795);
      if (GesturePWDUtils.getGestureUnlockFailedType(this) != 1) {
        break label73;
      }
    }
    label73:
    for (String str1 = getString(2131692798);; str1 = getString(2131692797))
    {
      bhdj.a(this, 230, str2, str1, 2131690697, 2131692796, new aeyy(this), new aeyz(this)).show();
      return;
    }
  }
  
  private boolean d()
  {
    i = -1;
    Intent localIntent = getIntent();
    try
    {
      str = localIntent.getStringExtra("uin");
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int j;
        long l;
        label57:
        String str = "";
        QLog.e("SplashActivity", 2, localException1, new Object[0]);
        continue;
        if (i != this.jdField_d_of_type_Int) {
          bool = false;
        } else if (l - this.e > 800L) {
          bool = false;
        } else {
          bool = true;
        }
      }
    }
    try
    {
      j = localIntent.getIntExtra("uintype", -1);
      i = j;
      l = SystemClock.uptimeMillis();
      if (TextUtils.isEmpty(str)) {
        break label179;
      }
      if (str.equals(this.jdField_c_of_type_JavaLangString)) {
        break label135;
      }
      bool = false;
    }
    catch (Exception localException2)
    {
      break label120;
      bool = false;
      break label57;
    }
    if (!bool)
    {
      this.e = l;
      this.jdField_c_of_type_JavaLangString = str;
      this.jdField_d_of_type_Int = i;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SplashActivity", 2, "highFrequencyOpenSameAio " + bool);
    }
    return bool;
  }
  
  private boolean d(Intent paramIntent)
  {
    if ((paramIntent.getBooleanExtra("open_now_tab_fragment", false)) && (this.app.getNowLiveManager().jdField_a_of_type_Boolean))
    {
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        jdField_a_of_type_Int = 1;
        localObject = MainFragment.a();
        ((MainFragment)localObject).a = paramIntent;
        localFragmentTransaction.add(16908290, (Fragment)localObject, MainFragment.class.getName());
        localFragmentTransaction.commitAllowingStateLoss();
        return true;
      }
      b(paramIntent);
      return true;
    }
    return false;
  }
  
  private void e()
  {
    if (AIOUtils.hasSetSwitch) {}
    do
    {
      return;
      AIOUtils.traceviewSwitch = getIntent().getBooleanExtra("traceviewSwitch", false);
      AIOUtils.isForbidChatFontFun = getIntent().getBooleanExtra("forbidChatFont", false);
      AIOUtils.isForbidHeadPendantFun = getIntent().getBooleanExtra("forbidHeadPendant", false);
      AIOUtils.isForbidChatBubbleFun = getIntent().getBooleanExtra("forbidChatBubble", false);
      AIOUtils.logcatDBOperation = getIntent().getBooleanExtra("logDBOperation", false);
      com.tencent.mobileqq.app.ThreadSetting.logcatBgTaskMonitor = getIntent().getBooleanExtra("logBgTaskMonitor", false);
      AIOUtils.hasSetSwitch = true;
    } while (!QLog.isColorLevel());
    QLog.d("SplashActivity", 2, "traceviewSwitch: " + AIOUtils.traceviewSwitch + " isForbidChatFontFun: " + AIOUtils.isForbidChatFontFun + " isForbidHeadPendantFun: " + AIOUtils.isForbidHeadPendantFun + " isForbidChatBubbleFun: " + AIOUtils.isForbidChatBubbleFun + " logcatDBOperation: " + AIOUtils.logcatDBOperation + " isEnableAutoDumpLeak: " + AppSetting.d);
  }
  
  private boolean e(Intent paramIntent)
  {
    boolean bool = false;
    if (paramIntent.getBooleanExtra("jump_to_story", false))
    {
      Intent localIntent = new Intent(this, QQStoryMainActivity.class);
      localIntent.replaceExtras(paramIntent.getExtras());
      startActivity(localIntent);
      bool = true;
    }
    return bool;
  }
  
  public int a()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      return ((MainFragment)localFragment).a();
    }
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).a(paramInt1, paramInt2, paramObject);
    }
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).a(paramInt, paramRedTypeInfo);
    }
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject2 = null;
    int i = paramIntent.getIntExtra("extra_pull_active_push_type", 0);
    if (i == 0) {
      return;
    }
    Object localObject1;
    if (i == 2)
    {
      paramIntent = paramIntent.getStringExtra("extra_pull_active_push_url");
      localObject1 = new Intent(this.app.getApp(), QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramIntent);
    }
    for (;;)
    {
      if (localObject1 != null) {
        startActivity((Intent)localObject1);
      }
      bdla.b(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      return;
      localObject1 = localObject2;
      if (i == 1) {
        switch (paramIntent.getIntExtra("extra_pull_active_push_subtype", 0))
        {
        default: 
          localObject1 = localObject2;
          break;
        case 1: 
          new bheh(this.app, this).h();
          localObject1 = localObject2;
          break;
        case 2: 
          new bheh(this.app, this).o();
          localObject1 = localObject2;
          break;
        case 3: 
          localObject1 = new Intent(this.app.getApp(), ActivateFriendActivity.class);
          ((Intent)localObject1).putExtra("af_key_from", 4);
          break;
        case 4: 
          localObject1 = new Intent(this.app.getApp(), NearbyActivity.class);
          ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
          break;
        case 5: 
          HotChatManager.a(this, false);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    afof.a().b();
    ThreadRegulator.a().a(1);
    jdField_b_of_type_Int = aczy.a().a(0, 1, 0, 0, 2000, 301, 4L, Process.myTid(), "openAIO");
    bdlm.a().a("ChatFragment", true);
    bhhy.b(null, "AIO_Start_cost");
    if ((AIOUtils.beforeEnterAIO(this, this.app, paramBoolean, getIntent())) || (d())) {}
    label568:
    for (;;)
    {
      return;
      long l = SystemClock.uptimeMillis();
      if (l - this.jdField_c_of_type_Long >= jdField_d_of_type_Long)
      {
        this.jdField_c_of_type_Long = l;
        if (QLog.isColorLevel()) {
          QLog.e("SplashActivity", 2, paramInt + "|openAIO|" + getIntent().getIntExtra("uintype", -1));
        }
        paramBoolean = getIntent().getBooleanExtra("open_chatfragment_withanim", false);
        Object localObject2 = getSupportFragmentManager();
        FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject2).beginTransaction();
        Object localObject1 = ((FragmentManager)localObject2).findFragmentByTag(ChatFragment.class.getName());
        localObject2 = ((FragmentManager)localObject2).findFragmentByTag(MainFragment.class.getName());
        if (localObject2 != null)
        {
          ((MainFragment)localObject2).k();
          if (((MainFragment)localObject2).a() != MainFragment.jdField_b_of_type_Int) {
            ((MainFragment)localObject2).a(MainFragment.jdField_b_of_type_Int);
          }
        }
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("SplashActivity", 2, "openAIO f != null ");
          }
          ChatFragment localChatFragment = (ChatFragment)localObject1;
          localChatFragment.d();
          jdField_a_of_type_Int = 2;
          if (localChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
          {
            QLog.w("SplashActivity", 1, "ChatFragment state error, trying to recreate it.");
            localChatFragment = ChatFragment.a();
            localFragmentTransaction.remove((Fragment)localObject1);
            localFragmentTransaction.add(16908290, localChatFragment, ChatFragment.class.getName());
            localFragmentTransaction.hide((Fragment)localObject2);
            localFragmentTransaction.commitAllowingStateLoss();
          }
        }
        for (;;)
        {
          if (!getIntent().getBooleanExtra("activepull_push_flag", false)) {
            break label568;
          }
          bdla.b(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
          return;
          if (!((Fragment)localObject1).isVisible())
          {
            if ((paramBoolean) && (aoaj.a() > 1)) {
              localFragmentTransaction.setCustomAnimations(2130772048, 2130772053);
            }
            localFragmentTransaction.show((Fragment)localObject1);
            localFragmentTransaction.hide((Fragment)localObject2);
            localFragmentTransaction.commitAllowingStateLoss();
            continue;
            if (Math.abs(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) < 1000L)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("SplashActivity", 2, "openAIO hasOpenedAIO true, renturn ");
              return;
            }
            this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
            if ((paramBoolean) && (aoaj.a() > 1)) {
              localFragmentTransaction.setCustomAnimations(2130772048, 2130772053);
            }
            localObject1 = ChatFragment.a();
            jdField_a_of_type_Int = 2;
            localFragmentTransaction.add(16908290, (Fragment)localObject1, ChatFragment.class.getName());
            localFragmentTransaction.hide((Fragment)localObject2);
            localFragmentTransaction.commitAllowingStateLoss();
            afof.a().b();
            if (QLog.isColorLevel()) {
              QLog.i("SplashActivity", 2, "openAIO f == null ");
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    if ((this.app != null) && (this.app.isExitTaskUnfinished)) {
      QLog.d("SplashActivity", 1, "LastExitTaskUnfinished finish");
    }
    Object localObject1;
    do
    {
      return true;
      if ((NotificationActivity.a != null) && (!NotificationActivity.a.isFinishing()))
      {
        QLog.d("SplashActivity", 1, "needFinish, notification activity exists");
        localObject1 = NotificationActivity.a.getIntent();
        NotificationActivity.a.finish();
        startActivity((Intent)localObject1);
        return false;
      }
      if (!UserguideActivity.a(this)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("SplashActivity", 2, "showUserGuide");
    return true;
    if ((this.app == null) || ((!this.app.isLogin()) && (this.app.getKickIntent() == null)))
    {
      Object localObject2 = getSharedPreferences("UserGuide", 0);
      localObject1 = ((SharedPreferences)localObject2).getString("qq_version", "");
      String str1 = ((SharedPreferences)localObject2).getString("qq_version_full", "");
      String str2 = AppSetting.a();
      localObject2 = ((SharedPreferences)localObject2).edit();
      if (!TextUtils.equals((CharSequence)localObject1, "4875")) {
        ((SharedPreferences.Editor)localObject2).putString("qq_version_pre", (String)localObject1);
      }
      if (!TextUtils.equals(str1, str2)) {
        ((SharedPreferences.Editor)localObject2).putString("qq_version_full_pre", str1);
      }
      ((SharedPreferences.Editor)localObject2).putString("qq_version", "4875");
      ((SharedPreferences.Editor)localObject2).putString("qq_version_full", str2);
      ((SharedPreferences.Editor)localObject2).commit();
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, String.format("update version pre[%s, %s], cur[%s, %s]", new Object[] { localObject1, str1, "4875", str2 }));
      }
      startActivity(new Intent(this, LoginActivity.class));
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 4, "clearAIO");
    }
    afof.a().b();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment1 = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    Fragment localFragment2 = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localFragment2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "clearAIO");
      }
      localObject = ((FragmentManager)localObject).beginTransaction();
      if (localFragment2.isVisible())
      {
        jdField_a_of_type_Int = 1;
        ((FragmentTransaction)localObject).hide(localFragment2);
        if (localFragment1 != null) {
          break label136;
        }
        ((FragmentTransaction)localObject).add(16908290, MainFragment.a(), MainFragment.class.getName());
      }
    }
    for (;;)
    {
      ((FragmentTransaction)localObject).remove(localFragment2).commitAllowingStateLoss();
      if (alvr.a().c()) {
        alvr.a().d();
      }
      return;
      label136:
      ((FragmentTransaction)localObject).show(localFragment1);
    }
  }
  
  public void b(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SplashActivity", 2, "openMainFragment");
    }
    Object localObject = getSupportFragmentManager();
    MainFragment localMainFragment = (MainFragment)((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localMainFragment == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "openMainFragment mainfragment is null");
      }
      return;
    }
    FragmentTransaction localFragmentTransaction;
    if (jdField_a_of_type_Int != 1)
    {
      localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      localObject = (ChatFragment)((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    }
    try
    {
      if (paramIntent.getBooleanExtra("switch_anim", false)) {
        localFragmentTransaction.setCustomAnimations(2130772052, 2130772049);
      }
      jdField_a_of_type_Int = 1;
      localFragmentTransaction.show(localMainFragment);
      localFragmentTransaction.hide((Fragment)localObject);
      localFragmentTransaction.commitAllowingStateLoss();
      if ((localObject != null) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null))
      {
        if ((((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isQimUserOnline) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isQimUserTitleForm) && (!((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isNightMode)) {
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        }
      }
      else
      {
        localMainFragment.a(paramIntent);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("SplashActivity", 2, localException, new Object[0]);
        continue;
        if ((((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isTimUserOnline) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isTimUserTitleForm) && (!((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isNightMode)) {
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        } else {
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 450);
        }
      }
    }
  }
  
  public void c()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).j();
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if ((localFragment != null) && (localFragment.isVisible())) {
      ((ChatFragment)localFragment).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      return;
      localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    } while (localObject == null);
    ((MainFragment)localObject).a(paramInt1, paramInt2, paramIntent);
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: getstatic 76	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   3: ifnull +586 -> 589
    //   6: getstatic 76	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   9: invokevirtual 919	java/lang/String:length	()I
    //   12: ifle +577 -> 589
    //   15: iconst_1
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +44 -> 62
    //   21: new 105	android/content/Intent
    //   24: dup
    //   25: aload_0
    //   26: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   29: invokespecial 921	android/content/Intent:<init>	(Landroid/content/Intent;)V
    //   32: astore_3
    //   33: aload_3
    //   34: ldc_w 922
    //   37: invokevirtual 177	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   40: pop
    //   41: aload_0
    //   42: invokespecial 923	android/support/v4/app/FragmentActivity:finish	()V
    //   45: aload_0
    //   46: aload_3
    //   47: iconst_m1
    //   48: aconst_null
    //   49: invokespecial 927	android/support/v4/app/FragmentActivity:superStartActivityForResult	(Landroid/content/Intent;ILandroid/os/Bundle;)V
    //   52: ldc2_w 928
    //   55: invokestatic 935	java/lang/Thread:sleep	(J)V
    //   58: iconst_m1
    //   59: invokestatic 938	java/lang/System:exit	(I)V
    //   62: aconst_null
    //   63: ldc_w 940
    //   66: invokestatic 942	bhhy:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aconst_null
    //   70: ldc_w 944
    //   73: invokestatic 942	bhhy:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aconst_null
    //   77: ldc_w 946
    //   80: invokestatic 942	bhhy:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 949	com/tencent/mobileqq/activity/SplashActivity:mActNeedImmersive	Z
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 951	android/support/v4/app/FragmentActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   93: pop
    //   94: ldc_w 946
    //   97: aconst_null
    //   98: invokestatic 942	bhhy:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 952	com/tencent/mobileqq/activity/SplashActivity:a	()Z
    //   105: ifne +10 -> 115
    //   108: aload_0
    //   109: invokespecial 954	com/tencent/mobileqq/activity/SplashActivity:b	()Z
    //   112: ifeq +23 -> 135
    //   115: aload_0
    //   116: invokevirtual 305	com/tencent/mobileqq/activity/SplashActivity:finish	()V
    //   119: ldc_w 944
    //   122: aconst_null
    //   123: invokestatic 942	bhhy:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: ldc_w 940
    //   129: aconst_null
    //   130: invokestatic 942	bhhy:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload_0
    //   136: invokespecial 955	com/tencent/mobileqq/activity/SplashActivity:c	()Z
    //   139: ifeq +448 -> 587
    //   142: aload_0
    //   143: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   146: invokevirtual 958	android/content/Intent:getAction	()Ljava/lang/String;
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +33 -> 184
    //   154: ldc_w 960
    //   157: aload_3
    //   158: invokevirtual 43	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifeq +23 -> 184
    //   164: aload_0
    //   165: invokevirtual 305	com/tencent/mobileqq/activity/SplashActivity:finish	()V
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_1
    //   171: ldc 138
    //   173: iconst_2
    //   174: aload_1
    //   175: iconst_0
    //   176: anewarray 507	java/lang/Object
    //   179: invokestatic 510	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   182: iconst_1
    //   183: ireturn
    //   184: new 281	java/lang/ref/WeakReference
    //   187: dup
    //   188: aload_0
    //   189: invokespecial 963	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   192: putstatic 279	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   195: aload_1
    //   196: ifnull +41 -> 237
    //   199: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +12 -> 214
    //   205: ldc 138
    //   207: iconst_2
    //   208: ldc_w 965
    //   211: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_0
    //   215: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   218: ldc 103
    //   220: iconst_0
    //   221: invokevirtual 132	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   224: pop
    //   225: aload_0
    //   226: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   229: ldc_w 307
    //   232: iconst_0
    //   233: invokevirtual 132	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   236: pop
    //   237: aload_0
    //   238: getfield 113	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: iconst_0
    //   242: putfield 968	com/tencent/mobileqq/app/QQAppInterface:isClearTaskBySystem	Z
    //   245: aload_0
    //   246: invokespecial 970	com/tencent/mobileqq/activity/SplashActivity:e	()V
    //   249: aload_0
    //   250: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   253: astore_3
    //   254: aload_3
    //   255: invokevirtual 579	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   258: ifnull +79 -> 337
    //   261: aload_3
    //   262: invokevirtual 579	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   265: ldc_w 358
    //   268: invokevirtual 976	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   271: ifne +18 -> 289
    //   274: aload_3
    //   275: ldc_w 978
    //   278: iconst_0
    //   279: invokevirtual 109	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   282: ifeq +27 -> 309
    //   285: aload_1
    //   286: ifnonnull +23 -> 309
    //   289: invokestatic 352	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +12 -> 304
    //   295: ldc 138
    //   297: iconst_2
    //   298: ldc_w 980
    //   301: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload_0
    //   305: iconst_0
    //   306: putfield 983	com/tencent/mobileqq/activity/SplashActivity:mCanLock	Z
    //   309: aload_0
    //   310: aload_0
    //   311: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   314: ldc_w 985
    //   317: invokevirtual 397	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   320: putfield 987	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   323: aload_0
    //   324: aload_0
    //   325: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   328: ldc_w 989
    //   331: invokevirtual 397	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   334: putfield 990	com/tencent/mobileqq/activity/SplashActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   337: aload_0
    //   338: aload_0
    //   339: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   342: invokespecial 992	com/tencent/mobileqq/activity/SplashActivity:a	(Landroid/content/Intent;)Z
    //   345: ifne +249 -> 594
    //   348: aload_0
    //   349: aload_0
    //   350: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   353: invokespecial 994	com/tencent/mobileqq/activity/SplashActivity:d	(Landroid/content/Intent;)Z
    //   356: ifne +238 -> 594
    //   359: aload_0
    //   360: aload_0
    //   361: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   364: invokespecial 996	com/tencent/mobileqq/activity/SplashActivity:b	(Landroid/content/Intent;)Z
    //   367: ifne +227 -> 594
    //   370: aload_0
    //   371: aload_0
    //   372: invokevirtual 126	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   375: invokespecial 998	com/tencent/mobileqq/activity/SplashActivity:c	(Landroid/content/Intent;)Z
    //   378: ifeq +196 -> 574
    //   381: goto +213 -> 594
    //   384: iload_2
    //   385: ifne +35 -> 420
    //   388: aload_0
    //   389: invokevirtual 316	com/tencent/mobileqq/activity/SplashActivity:getSupportFragmentManager	()Landroid/support/v4/app/FragmentManager;
    //   392: astore_1
    //   393: iconst_1
    //   394: putstatic 24	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   397: aload_1
    //   398: invokevirtual 322	android/support/v4/app/FragmentManager:beginTransaction	()Landroid/support/v4/app/FragmentTransaction;
    //   401: ldc_w 340
    //   404: invokestatic 336	com/tencent/mobileqq/activity/home/MainFragment:a	()Lcom/tencent/mobileqq/activity/home/MainFragment;
    //   407: ldc_w 324
    //   410: invokevirtual 329	java/lang/Class:getName	()Ljava/lang/String;
    //   413: invokevirtual 346	android/support/v4/app/FragmentTransaction:add	(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;
    //   416: invokevirtual 349	android/support/v4/app/FragmentTransaction:commitAllowingStateLoss	()I
    //   419: pop
    //   420: invokestatic 1004	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   423: new 1006	com/tencent/mobileqq/activity/SplashActivity$1
    //   426: dup
    //   427: aload_0
    //   428: invokespecial 1007	com/tencent/mobileqq/activity/SplashActivity$1:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   431: ldc2_w 751
    //   434: invokevirtual 1013	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   437: pop
    //   438: aload_0
    //   439: aload_3
    //   440: invokespecial 1015	com/tencent/mobileqq/activity/SplashActivity:e	(Landroid/content/Intent;)Z
    //   443: pop
    //   444: iconst_1
    //   445: putstatic 1018	com/tencent/common/app/BaseApplicationImpl:appMainActivityHasLanuch	Z
    //   448: ldc_w 944
    //   451: aconst_null
    //   452: invokestatic 942	bhhy:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: getstatic 1022	com/tencent/widget/immersive/ImmersiveUtils:c	Z
    //   458: ifne +29 -> 487
    //   461: aload_0
    //   462: invokevirtual 1025	com/tencent/mobileqq/activity/SplashActivity:isInMultiWindow	()Z
    //   465: ifne +22 -> 487
    //   468: aload_0
    //   469: invokevirtual 1029	com/tencent/mobileqq/activity/SplashActivity:getWindow	()Landroid/view/Window;
    //   472: invokevirtual 1035	android/view/Window:getDecorView	()Landroid/view/View;
    //   475: new 1037	com/tencent/mobileqq/activity/SplashActivity$2
    //   478: dup
    //   479: aload_0
    //   480: invokespecial 1038	com/tencent/mobileqq/activity/SplashActivity$2:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   483: invokevirtual 1044	android/view/View:post	(Ljava/lang/Runnable;)Z
    //   486: pop
    //   487: invokestatic 1048	com/tencent/mobileqq/activity/SplashActivity:getActivityRoutes	()Ljava/util/ArrayList;
    //   490: astore_1
    //   491: getstatic 24	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   494: iconst_1
    //   495: if_icmpne +43 -> 538
    //   498: aload_0
    //   499: invokevirtual 1049	com/tencent/mobileqq/activity/SplashActivity:a	()I
    //   502: getstatic 701	com/tencent/mobileqq/activity/home/MainFragment:jdField_b_of_type_Int	I
    //   505: if_icmpne +33 -> 538
    //   508: aload_1
    //   509: invokevirtual 1054	java/util/ArrayList:size	()I
    //   512: iconst_2
    //   513: if_icmpgt +25 -> 538
    //   516: aload_1
    //   517: invokevirtual 1054	java/util/ArrayList:size	()I
    //   520: iconst_2
    //   521: if_icmpne +21 -> 542
    //   524: ldc_w 1056
    //   527: aload_1
    //   528: iconst_0
    //   529: invokevirtual 1059	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   532: invokevirtual 43	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   535: ifne +7 -> 542
    //   538: iconst_0
    //   539: putstatic 26	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Boolean	Z
    //   542: getstatic 24	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   545: iconst_1
    //   546: if_icmpne -364 -> 182
    //   549: aload_3
    //   550: invokestatic 1064	bakg:a	(Landroid/content/Intent;)Lbakd;
    //   553: astore_1
    //   554: aload_1
    //   555: ifnull -373 -> 182
    //   558: aload_1
    //   559: aload_0
    //   560: getfield 113	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   563: aload_0
    //   564: invokevirtual 1068	com/tencent/mobileqq/activity/SplashActivity:getActivity	()Landroid/app/Activity;
    //   567: invokevirtual 1073	bakd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Z
    //   570: pop
    //   571: goto -389 -> 182
    //   574: iconst_0
    //   575: istore_2
    //   576: goto -192 -> 384
    //   579: astore_3
    //   580: goto -522 -> 58
    //   583: astore_1
    //   584: goto -247 -> 337
    //   587: iconst_0
    //   588: ireturn
    //   589: iconst_0
    //   590: istore_2
    //   591: goto -574 -> 17
    //   594: iconst_1
    //   595: istore_2
    //   596: goto -212 -> 384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	599	0	this	SplashActivity
    //   0	599	1	paramBundle	Bundle
    //   16	580	2	i	int
    //   32	518	3	localObject	Object
    //   579	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	170	java/lang/Exception
    //   21	52	170	java/lang/Exception
    //   58	62	170	java/lang/Exception
    //   62	115	170	java/lang/Exception
    //   115	133	170	java/lang/Exception
    //   135	150	170	java/lang/Exception
    //   154	168	170	java/lang/Exception
    //   184	195	170	java/lang/Exception
    //   199	214	170	java/lang/Exception
    //   214	237	170	java/lang/Exception
    //   237	285	170	java/lang/Exception
    //   289	304	170	java/lang/Exception
    //   304	309	170	java/lang/Exception
    //   337	381	170	java/lang/Exception
    //   388	420	170	java/lang/Exception
    //   420	487	170	java/lang/Exception
    //   487	538	170	java/lang/Exception
    //   538	542	170	java/lang/Exception
    //   542	554	170	java/lang/Exception
    //   558	571	170	java/lang/Exception
    //   52	58	579	java/lang/Exception
    //   309	337	583	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (QQPlayerService.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "QQPlayerService stopPlayMusic");
        }
        QQPlayerService.c(getApplicationContext());
      }
      a();
      if ((bibb.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView != null) && (bibb.jdField_a_of_type_JavaLangString == "setting"))
      {
        bibb.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView = null;
        bibb.jdField_a_of_type_JavaLangString = "";
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("SplashActivity", 1, "", localThrowable);
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject;
    Fragment localFragment;
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "doOnKeyDown");
      }
      localObject = getSupportFragmentManager();
      localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment == null) || (!localFragment.isVisible()))
      {
        localObject = (MainFragment)((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
        if (localObject != null) {
          return ((MainFragment)localObject).a(paramInt, paramKeyEvent);
        }
      }
      else
      {
        ((ChatFragment)localFragment).a();
        return true;
      }
    }
    if (paramInt == 82)
    {
      localObject = getSupportFragmentManager();
      localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment == null) || (!localFragment.isVisible()))
      {
        localObject = (MainFragment)((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
        if (localObject != null) {
          return ((MainFragment)localObject).a(paramInt, paramKeyEvent);
        }
      }
    }
    if (((paramInt == 24) || (paramInt == 25)) && (avpd.a(this).a()))
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("VolumeBtnDown");
      sendBroadcast((Intent)localObject);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    try
    {
      super.doOnNewIntent(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "doOnNewIntent");
      }
      if (a())
      {
        finish();
        return;
      }
      localObject = paramIntent.getAction();
      if ((localObject != null) && ("QQ_ACTION_MENU_QUIT".equals(localObject)))
      {
        finish();
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e("SplashActivity", 2, paramIntent, new Object[0]);
      return;
    }
    Object localObject = paramIntent.getExtras();
    if (paramIntent.getIntExtra("fromCmGame", 0) == 1) {
      overridePendingTransition(0, 0);
    }
    int i = getIntent().getIntExtra("uintype", -1);
    if (i == 10005)
    {
      getIntent().removeExtra("uintype");
      QLog.e("SplashActivity", 1, "wtf 10005 aio" + paramIntent);
    }
    if ((i != 10005) && (localObject != null))
    {
      if (a(paramIntent)) {
        return;
      }
      if (Boolean.valueOf(((Bundle)localObject).getBoolean("EXIT", false)).booleanValue()) {
        finish();
      }
      if (((Bundle)localObject).getBoolean("activepull_push_flag"))
      {
        setIntent(paramIntent);
        a(paramIntent);
        return;
      }
      if ((((Bundle)localObject).getInt("fragment_id") == 1) && (jdField_a_of_type_Int != 1))
      {
        setIntent(paramIntent);
        b(paramIntent);
        paramIntent = bakg.a(paramIntent);
        if (paramIntent == null) {
          return;
        }
        paramIntent.a(this.app, getActivity());
        return;
      }
    }
    if (jdField_a_of_type_Int == 1)
    {
      localObject = (MainFragment)getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject != null)
      {
        setIntent(paramIntent);
        ((MainFragment)localObject).a(paramIntent);
        paramIntent = bakg.a(paramIntent);
        if (paramIntent != null) {
          paramIntent.a(this.app, getActivity());
        }
      }
    }
  }
  
  public void doOnPause()
  {
    if (isInMultiWindow())
    {
      Object localObject = getSupportFragmentManager();
      Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment != null) && (localFragment.isVisible()))
      {
        localObject = (ChatFragment)localFragment;
        ((ChatFragment)localFragment).g();
      }
      do
      {
        return;
        localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      } while (localFragment == null);
      ((MainFragment)localFragment).l();
      super.doOnPause();
      return;
    }
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void doOnResume()
  {
    boolean bool2 = true;
    ArrayList localArrayList;
    Object localObject3;
    boolean bool1;
    try
    {
      super.doOnResume();
      AbstractVideoImage.resumeAll();
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "doOnResume");
      }
      d();
      localObject1 = getWindow();
      if ((((Window)localObject1).getAttributes().flags & 0x400) != 0) {
        ((Window)localObject1).clearFlags(1024);
      }
      if (this.app.getKickIntent() != null)
      {
        QLog.d("SplashActivity", 1, "doOnResume finish, kickIntent exists");
        startActivity(this.app.getKickIntent());
        return;
      }
      c(getIntent());
      localObject8 = this.app.getDevLockIntent();
      if (localObject8 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "onResume start push");
        }
        localObject5 = "";
        localObject7 = "";
        str2 = "";
        str3 = "";
        localArrayList = new ArrayList();
        localObject1 = str3;
        localObject3 = str2;
        localObject4 = localObject7;
        bool1 = bool2;
      }
    }
    catch (Exception localException1)
    {
      Object localObject1;
      Object localObject8;
      Object localObject5;
      Object localObject7;
      String str2;
      String str3;
      Object localObject4;
      String str1;
      QLog.e("SplashActivity", 2, localException1, new Object[0]);
      return;
    }
    try
    {
      str1 = ((Intent)localObject8).getStringExtra("tipMsg");
      localObject1 = str3;
      localObject3 = str2;
      localObject4 = localObject7;
      bool1 = bool2;
      localObject5 = str1;
      bool2 = ((Intent)localObject8).getBooleanExtra("canCancel", true);
      localObject1 = str3;
      localObject3 = str2;
      localObject4 = localObject7;
      bool1 = bool2;
      localObject5 = str1;
      localObject7 = ((Intent)localObject8).getStringExtra("title");
      localObject1 = str3;
      localObject3 = str2;
      localObject4 = localObject7;
      bool1 = bool2;
      localObject5 = str1;
      str2 = ((Intent)localObject8).getStringExtra("secondTitle");
      localObject1 = str3;
      localObject3 = str2;
      localObject4 = localObject7;
      bool1 = bool2;
      localObject5 = str1;
      str3 = ((Intent)localObject8).getStringExtra("thirdTitle");
      localObject1 = str3;
      localObject3 = str2;
      localObject4 = localObject7;
      bool1 = bool2;
      localObject5 = str1;
      localObject8 = ((Intent)localObject8).getStringArrayListExtra("wordsList");
      localObject5 = str1;
      localObject4 = localObject7;
      str1 = str2;
      localObject3 = str3;
      localObject1 = localObject8;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject6 = localObject3;
        localObject3 = localException1;
        Object localObject2 = localArrayList;
        bool2 = bool1;
        break;
        try
        {
          if ((NotifyPCActiveActivity.a != null) || (!(BaseActivity.sTopActivity instanceof SplashActivity))) {
            break label484;
          }
          startActivity(localObject2);
        }
        catch (Throwable localThrowable) {}
      }
      if (!QLog.isColorLevel()) {
        break label484;
      }
      QLog.i("SplashActivity", 2, "", localThrowable);
      break label484;
      Fragment localFragment = ((FragmentManager)localObject3).findFragmentByTag(MainFragment.class.getName());
      if (localFragment == null) {
        break label675;
      }
      ((MainFragment)localFragment).l();
      break label675;
    }
    localObject7 = new Intent(this, DevlockPushActivity.class);
    ((Intent)localObject7).putExtra("canCancel", bool2);
    ((Intent)localObject7).putExtra("tipMsg", (String)localObject5);
    ((Intent)localObject7).putExtra("title", localObject4);
    ((Intent)localObject7).putExtra("secondTitle", str1);
    ((Intent)localObject7).putExtra("thirdTitle", (String)localObject3);
    ((Intent)localObject7).putStringArrayListExtra("wordsList", (ArrayList)localObject1);
    startActivity((Intent)localObject7);
    if ((this.app.isLogin()) && (this.app.getAccount().equals(BaseApplicationImpl.getApplication().getPCActiveUin())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "onResume start push");
      }
      if (!isResume()) {
        return;
      }
      localObject1 = BaseApplicationImpl.getApplication().getPCActiveNoticeIntent();
      if (localObject1 != null) {
        break label709;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "Intent is null");
      }
    }
    label484:
    bhhy.a(null, "Main_Resume_PCActive");
    if ((!TextUtils.isEmpty(this.app.getAccount())) && (!"0".equals(this.app.getAccount()))) {
      ThreadManager.getSubThreadHandler().postDelayed(new SplashActivity.3(this), 800L);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new SplashActivity.4(this), 800L);
    bhhy.a("Main_Resume_PCActive", null);
    ThreadManager.getSubThreadHandler().postDelayed(new SplashActivity.5(this), 800L);
    localObject1 = getIntent();
    if ((((Intent)localObject1).getExtras() != null) && (((Intent)localObject1).getBooleanExtra(bcrn.h, false)))
    {
      ((Intent)localObject1).removeExtra(bcrn.h);
      ThreadManager.post(new SplashActivity.6(this), 8, null, false);
    }
    if (isInMultiWindow())
    {
      localObject3 = getSupportFragmentManager();
      localObject1 = ((FragmentManager)localObject3).findFragmentByTag(ChatFragment.class.getName());
      if ((localObject1 != null) && (((Fragment)localObject1).isVisible()))
      {
        localObject3 = (ChatFragment)localObject1;
        ((ChatFragment)localObject1).g();
      }
    }
    else
    {
      label675:
      aauu.d();
      return;
    }
    label709:
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnStart");
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)))
    {
      bheh localbheh = bhey.a(this.app, this, this.jdField_a_of_type_JavaLangString);
      localbheh.c(this.jdField_b_of_type_JavaLangString);
      localbheh.a();
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
    }
  }
  
  public void doOnStop()
  {
    if (isInMultiWindow())
    {
      super.doOnPause();
      AbstractVideoImage.pauseAll();
      ApngImage.pauseAll();
      super.doOnStop();
      return;
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "finish()");
    }
    FragmentManager localFragmentManager = getSupportFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "finish clearAIO");
      }
      localFragmentManager.beginTransaction().remove(localFragment).commitAllowingStateLoss();
    }
    super.finish();
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() == this)) {
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public String getActivityName()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SplashActivity");
    if (jdField_a_of_type_Int == 1) {}
    for (String str = "_MainFragment";; str = "_ChatFragment") {
      return str;
    }
  }
  
  public String getCIOPageName()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (jdField_a_of_type_Int == 1) {}
    for (Object localObject = MainFragment.class.getName();; localObject = ChatFragment.class.getName())
    {
      localObject = localFragmentManager.findFragmentByTag((String)localObject);
      if (localObject == null) {
        break;
      }
      return ((Fragment)localObject).getCIOPageName();
    }
    return super.getCIOPageName();
  }
  
  public ComponentName getComponentName()
  {
    ComponentName localComponentName2 = super.getComponentName();
    ComponentName localComponentName1 = localComponentName2;
    if (localComponentName2 == null) {
      localComponentName1 = new ComponentName(getApplicationContext(), SplashActivity.class);
    }
    return localComponentName1;
  }
  
  public String getPreProcess()
  {
    return "com.tencent.mobileqq:peak";
  }
  
  public boolean isNeedInterruptDoMulitWindow()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).c();
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).b();
    }
    afoc.a(this.app);
    bdgt.a(BaseApplicationImpl.getContext(), this.app.getLongAccountUin());
  }
  
  public void onAccoutChangeFailed()
  {
    super.onAccoutChangeFailed();
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).d();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (FrameHelperActivity.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      DrawerFrame localDrawerFrame = (DrawerFrame)FrameHelperActivity.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localDrawerFrame != null) {
        localDrawerFrame.onConfigurationChanged(paramConfiguration);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      return localChatFragment.a(paramInt);
    }
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() == this)) {
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    b();
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).a(paramLogoutReason);
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null) {
      ((ChatFragment)localFragment).b(paramBoolean);
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localObject != null) {
      ((MainFragment)localObject).a(paramBoolean);
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    Object localObject1 = getSupportFragmentManager();
    Object localObject2 = ((FragmentManager)localObject1).findFragmentByTag(MainFragment.class.getName());
    if (localObject2 != null) {
      ((MainFragment)localObject2).i();
    }
    localObject1 = ((FragmentManager)localObject1).findFragmentByTag(ChatFragment.class.getName());
    if (localObject1 != null) {
      ((ChatFragment)localObject1).e();
    }
    if (!"1000".equals(ThemeUtil.getCurrentThemeId()))
    {
      if (getAppInterface() != null)
      {
        localObject1 = getAppInterface().getHandler(Conversation.class);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 1050;
        ((MqqHandler)localObject1).sendMessage((Message)localObject2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "onPostThemeChanged: hide theme overdue tips");
      }
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.a(paramInt, paramDialog);
    }
  }
  
  public void preloadUi()
  {
    try
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView = MainFragment.a(localLayoutInflater);
      this.jdField_a_of_type_AndroidViewView = localLayoutInflater.inflate(2131559003, null);
      FPSSwipListView localFPSSwipListView = (FPSSwipListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376272);
      if (localFPSSwipListView != null) {
        this.jdField_b_of_type_AndroidViewView = localLayoutInflater.inflate(2131562805, localFPSSwipListView, false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SplashActivity", 1, "", localThrowable);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    super.getWindow().setFormat(-3);
  }
  
  public String setLastActivityName()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      return ((MainFragment)localFragment).a();
    }
    return super.setLastActivityName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity
 * JD-Core Version:    0.7.0.1
 */