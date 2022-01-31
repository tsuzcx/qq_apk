package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.ProcessStats;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpic.VideoItemEventManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import tyb;
import tyd;
import tye;
import tyf;
import tyg;
import tyh;
import tyi;

public class SplashActivity
  extends FragmentActivity
{
  public static volatile int a;
  public static volatile WeakReference a;
  public static volatile boolean a;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public View a;
  private String jdField_a_of_type_JavaLangString;
  public View[] a;
  private int jdField_b_of_type_Int = -2;
  private long jdField_b_of_type_Long = -1L;
  public View b;
  private String jdField_b_of_type_JavaLangString;
  private String c = "";
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_Boolean = true;
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
    ScreenUtil.a();
    com.tencent.widget.XPanelContainer.d = 0;
  }
  
  private boolean a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("open_chatfragment", false))
    {
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      a(false, 0);
      return true;
    }
    return false;
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
    if ((paramIntent.getBooleanExtra("open_now_tab_fragment", false)) && (this.app.a().jdField_a_of_type_Boolean))
    {
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        jdField_a_of_type_Int = 1;
        localObject = MainFragment.a();
        ((MainFragment)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        localFragmentTransaction.add(16908290, (Fragment)localObject, MainFragment.class.getName());
        localFragmentTransaction.commitAllowingStateLoss();
        return true;
      }
      b(paramIntent);
      return true;
    }
    return false;
  }
  
  private void c(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("forward", -1))
    {
    }
    for (;;)
    {
      getIntent().removeExtra("forward");
      return;
      Object localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      ((Intent)localObject).putExtra("uin", paramIntent.getStringExtra("uin"));
      ((Intent)localObject).putExtra("uintype", paramIntent.getIntExtra("uintype", 0));
      ((Intent)localObject).putExtra("yuyin", paramIntent.getBooleanExtra("yuyin", false));
      ((Intent)localObject).putExtra("uinname", paramIntent.getStringExtra("uinname"));
      ((Intent)localObject).putExtra("enterchatwin", true);
      startActivity((Intent)localObject);
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
        localObject = paramIntent.getStringExtra("url");
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        if (paramIntent.hasExtra("uintype"))
        {
          int i = paramIntent.getIntExtra("uintype", -1);
          localIntent.putExtra("uintype", i);
          if ((i == 1030) && (this.app.a(239)))
          {
            ((CampusNoticeManager)this.app.getManager(239)).a(null);
            if (QLog.isColorLevel()) {
              QLog.d("CampusNoticeManager", 2, "remove campus notice");
            }
          }
        }
        localIntent.putExtra("url", (String)localObject);
        startActivity(localIntent);
      }
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("uin");
    int i = localIntent.getIntExtra("uintype", -1);
    long l = SystemClock.uptimeMillis();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      if (str.equals(this.c)) {
        break label110;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (!bool1)
      {
        this.jdField_b_of_type_Long = l;
        this.c = str;
        this.jdField_b_of_type_Int = i;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "highFrequencyOpenSameAio " + bool1);
      }
      return bool1;
      label110:
      bool1 = bool2;
      if (i == this.jdField_b_of_type_Int)
      {
        bool1 = bool2;
        if (l - this.jdField_b_of_type_Long <= 800L) {
          bool1 = true;
        }
      }
    }
  }
  
  private boolean c(Intent paramIntent)
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
  
  private void d()
  {
    String str2;
    if (GesturePWDUtils.getGestureUnlockFailed(this, this.app.getCurrentAccountUin()))
    {
      str2 = getString(2131436077);
      if (GesturePWDUtils.getGestureUnlockFailedType(this) != 1) {
        break label73;
      }
    }
    label73:
    for (String str1 = getString(2131436078);; str1 = getString(2131436079))
    {
      DialogUtil.b(this, 230, str2, str1, 2131433029, 2131436076, new tyh(this), new tyi(this)).show();
      return;
    }
  }
  
  private void e()
  {
    if (AIOUtils.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      AIOUtils.b = getIntent().getBooleanExtra("traceviewSwitch", false);
      AIOUtils.c = getIntent().getBooleanExtra("forbidChatFont", false);
      AIOUtils.d = getIntent().getBooleanExtra("forbidHeadPendant", false);
      AIOUtils.e = getIntent().getBooleanExtra("forbidChatBubble", false);
      AIOUtils.f = getIntent().getBooleanExtra("logDBOperation", false);
      com.tencent.mobileqq.app.ThreadSetting.logcatBgTaskMonitor = getIntent().getBooleanExtra("logBgTaskMonitor", false);
      AIOUtils.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("SplashActivity", 2, "traceviewSwitch: " + AIOUtils.b + " isForbidChatFontFun: " + AIOUtils.c + " isForbidHeadPendantFun: " + AIOUtils.d + " isForbidChatBubbleFun: " + AIOUtils.e + " logcatDBOperation: " + AIOUtils.f + " isEnableAutoDumpLeak: " + AppSetting.c);
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
      ReportController.b(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      return;
      localObject1 = localObject2;
      if (i == 1) {
        switch (paramIntent.getIntExtra("extra_pull_active_push_subtype", 0))
        {
        default: 
          localObject1 = localObject2;
          break;
        case 1: 
          new JumpAction(this.app, this).h();
          localObject1 = localObject2;
          break;
        case 2: 
          new JumpAction(this.app, this).i();
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
    AIOPreLoadEngine.a().b();
    ThreadRegulator.a().a(1);
    StartupTracker.b(null, "AIO_Start_cost");
    if ((AIOUtils.a(this, this.app, paramBoolean, getIntent())) || (c())) {}
    label428:
    for (;;)
    {
      return;
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
        ((MainFragment)localObject2).j();
        if (((MainFragment)localObject2).a() != MainFragment.jdField_a_of_type_Int) {
          ((MainFragment)localObject2).a(MainFragment.jdField_a_of_type_Int);
        }
      }
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SplashActivity", 2, "openAIO f != null ");
        }
        ((ChatFragment)localObject1).c();
        jdField_a_of_type_Int = 2;
        if (!((Fragment)localObject1).isVisible())
        {
          if ((paramBoolean) && (ProcessStats.a() > 1)) {
            localFragmentTransaction.setCustomAnimations(2131034173, 2131034178);
          }
          localFragmentTransaction.show((Fragment)localObject1);
          localFragmentTransaction.hide((Fragment)localObject2);
          localFragmentTransaction.commitAllowingStateLoss();
        }
      }
      for (;;)
      {
        if (!getIntent().getBooleanExtra("activepull_push_flag", false)) {
          break label428;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
        return;
        if (Math.abs(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) < 1000L)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SplashActivity", 2, "openAIO hasOpenedAIO true, renturn ");
          return;
        }
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        if ((paramBoolean) && (ProcessStats.a() > 1)) {
          localFragmentTransaction.setCustomAnimations(2131034173, 2131034178);
        }
        localObject1 = ChatFragment.a();
        jdField_a_of_type_Int = 2;
        localFragmentTransaction.add(16908290, (Fragment)localObject1, ChatFragment.class.getName());
        localFragmentTransaction.hide((Fragment)localObject2);
        localFragmentTransaction.commitAllowingStateLoss();
        AIOPreLoadEngine.a().b();
        if (QLog.isColorLevel()) {
          QLog.i("SplashActivity", 2, "openAIO f == null ");
        }
      }
    }
  }
  
  public boolean a()
  {
    if ((this.app != null) && (this.app.g)) {
      QLog.d("SplashActivity", 1, "LastExitTaskUnfinished finish");
    }
    Object localObject;
    do
    {
      return true;
      if ((NotificationActivity.a != null) && (!NotificationActivity.a.isFinishing()))
      {
        QLog.d("SplashActivity", 1, "needFinish, notification activity exists");
        localObject = NotificationActivity.a.getIntent();
        NotificationActivity.a.finish();
        startActivity((Intent)localObject);
        return false;
      }
    } while (UserguideActivity.a(this));
    if ((this.app == null) || ((!this.app.isLogin()) && (this.app.getKickIntent() == null)))
    {
      localObject = getSharedPreferences("UserGuide", 0).edit();
      ((SharedPreferences.Editor)localObject).putString("qq_version", "3615");
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, "record build num : 3615");
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
    AIOPreLoadEngine.a().b();
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
        ((FragmentTransaction)localObject).show(localFragment1);
      }
      ((FragmentTransaction)localObject).remove(localFragment2).commitAllowingStateLoss();
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
    if (jdField_a_of_type_Int != 1)
    {
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      localObject = (ChatFragment)((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if (paramIntent.getBooleanExtra("switch_anim", false)) {
        localFragmentTransaction.setCustomAnimations(2131034177, 2131034174);
      }
      jdField_a_of_type_Int = 1;
      localFragmentTransaction.show(localMainFragment);
      localFragmentTransaction.hide((Fragment)localObject);
      localFragmentTransaction.commitAllowingStateLoss();
      if ((localObject != null) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null))
      {
        if ((!((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Boolean) || (!((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.d) || (((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c)) {
          break label199;
        }
        ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
      }
    }
    for (;;)
    {
      localMainFragment.a(paramIntent);
      return;
      label199:
      if ((((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.b) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.e) && (!((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c)) {
        ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
      } else {
        ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 450);
      }
    }
  }
  
  public void c()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).i();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    int i;
    if ((BaseApplicationImpl.sSplashActivityEscapedMsg != null) && (BaseApplicationImpl.sSplashActivityEscapedMsg.length() > 0)) {
      i = 1;
    }
    for (;;)
    {
      Intent localIntent;
      if (i != 0)
      {
        localIntent = new Intent(getIntent());
        localIntent.addFlags(603979776);
        super.finish();
        super.superStartActivityForResult(localIntent, -1, null);
      }
      try
      {
        Thread.sleep(50L);
        System.exit(-1);
        StartupTracker.a(null, "Main_Start");
        StartupTracker.a(null, "Main_OnCreat");
        StartupTracker.a(null, "Main_super_create");
        this.mActNeedImmersive = false;
        super.doOnCreate(paramBundle);
        StartupTracker.a("Main_super_create", null);
        if ((a()) || (b()))
        {
          finish();
          StartupTracker.a("Main_OnCreat", null);
          StartupTracker.a("Main_Start", null);
          bool1 = false;
          return bool1;
          i = 0;
          continue;
        }
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
        if (paramBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SplashActivity", 2, "doOnCreate killedRestore: ");
          }
          getIntent().putExtra("open_chatfragment", false);
        }
        this.app.isClearTaskBySystem = false;
        e();
        localIntent = getIntent();
        if (localIntent.getExtras() != null) {
          if ((localIntent.getExtras().containsKey("forward")) || ((localIntent.getBooleanExtra("k_from_login", false)) && (paramBundle == null)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SplashActivity", 2, "mCanLock set false, intent from forward or login");
            }
            this.mCanLock = false;
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          boolean bool1;
          this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("jump_action_from_h5");
          this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("package_from_h5");
          label292:
          if ((a(getIntent())) || (b(getIntent()))) {}
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              paramBundle = getSupportFragmentManager();
              jdField_a_of_type_Int = 1;
              paramBundle.beginTransaction().add(16908290, MainFragment.a(), MainFragment.class.getName()).commitAllowingStateLoss();
            }
            ThreadManager.getSubThreadHandler().postDelayed(new tyb(this), 1000L);
            c(localIntent);
            BaseApplicationImpl.appMainActivityHasLanuch = true;
            StartupTracker.a("Main_OnCreat", null);
            if ((!ImmersiveUtils.c) && (!isInMultiWindow())) {
              getWindow().getDecorView().post(new tyd(this));
            }
            paramBundle = getActivityRoutes();
            if ((jdField_a_of_type_Int == 1) && (a() == MainFragment.jdField_a_of_type_Int) && (paramBundle.size() <= 2))
            {
              bool1 = bool2;
              if (paramBundle.size() != 2) {
                break;
              }
              bool1 = bool2;
              if ("LoginActivity".equals(paramBundle.get(0))) {
                break;
              }
            }
            jdField_a_of_type_Boolean = false;
            return true;
          }
          localException = localException;
        }
        catch (Exception paramBundle)
        {
          break label292;
        }
      }
    }
  }
  
  protected void doOnDestroy()
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
      if (QQPlayerService.a()) {
        QQPlayerService.c(getApplicationContext());
      }
      ApolloGameWrapper.d(this);
      a();
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
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
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
    if (((paramInt == 24) || (paramInt == 25)) && (VideoItemEventManager.a(this).a()))
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("VolumeBtnDown");
      sendBroadcast((Intent)localObject);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnNewIntent");
    }
    if (a()) {
      finish();
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = paramIntent.getAction();
          if ((localObject != null) && ("QQ_ACTION_MENU_QUIT".equals(localObject)))
          {
            finish();
            return;
          }
          localObject = paramIntent.getExtras();
          if (paramIntent.getIntExtra("fromCmGame", 0) == 1) {
            overridePendingTransition(0, 0);
          }
          if (localObject == null) {
            break;
          }
        } while (a(paramIntent));
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
          return;
        }
      } while (jdField_a_of_type_Int != 1);
      localObject = (MainFragment)getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    } while (localObject == null);
    setIntent(paramIntent);
    ((MainFragment)localObject).a(paramIntent);
  }
  
  protected void doOnPause()
  {
    if (isInMultiWindow())
    {
      Object localObject = getSupportFragmentManager();
      Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment != null) && (localFragment.isVisible()))
      {
        localObject = (ChatFragment)localFragment;
        ((ChatFragment)localFragment).e();
      }
      do
      {
        return;
        localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      } while (localFragment == null);
      ((MainFragment)localFragment).k();
      return;
    }
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    ApngImage.pauseAll();
    ApolloGameWrapper.b(this);
  }
  
  protected void doOnResume()
  {
    boolean bool2 = true;
    super.doOnResume();
    AbstractVideoImage.resumeAll();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnResume");
    }
    d();
    Object localObject1 = getWindow();
    if ((((Window)localObject1).getAttributes().flags & 0x400) != 0) {
      ((Window)localObject1).clearFlags(1024);
    }
    if (this.app.getKickIntent() != null)
    {
      QLog.d("SplashActivity", 1, "doOnResume finish, kickIntent exists");
      startActivity(this.app.getKickIntent());
    }
    label710:
    do
    {
      Object localObject2;
      do
      {
        return;
        c(getIntent());
        Object localObject7 = this.app.getDevLockIntent();
        String str3;
        String str4;
        String str2;
        String str1;
        boolean bool1;
        if (localObject7 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SplashActivity", 2, "onResume start push");
          }
          localObject2 = "";
          localObject5 = "";
          str3 = "";
          str4 = "";
          localObject6 = new ArrayList();
          str2 = str4;
          str1 = str3;
          localObject1 = localObject5;
          bool1 = bool2;
        }
        try
        {
          localObject3 = ((Intent)localObject7).getStringExtra("tipMsg");
          str2 = str4;
          str1 = str3;
          localObject1 = localObject5;
          bool1 = bool2;
          localObject2 = localObject3;
          bool2 = ((Intent)localObject7).getBooleanExtra("canCancel", true);
          str2 = str4;
          str1 = str3;
          localObject1 = localObject5;
          bool1 = bool2;
          localObject2 = localObject3;
          localObject5 = ((Intent)localObject7).getStringExtra("title");
          str2 = str4;
          str1 = str3;
          localObject1 = localObject5;
          bool1 = bool2;
          localObject2 = localObject3;
          str3 = ((Intent)localObject7).getStringExtra("secondTitle");
          str2 = str4;
          str1 = str3;
          localObject1 = localObject5;
          bool1 = bool2;
          localObject2 = localObject3;
          str4 = ((Intent)localObject7).getStringExtra("thirdTitle");
          str2 = str4;
          str1 = str3;
          localObject1 = localObject5;
          bool1 = bool2;
          localObject2 = localObject3;
          localObject7 = ((Intent)localObject7).getStringArrayListExtra("wordsList");
          localObject6 = localObject7;
          localObject2 = localObject3;
          bool1 = bool2;
          localObject1 = localObject5;
          str1 = str3;
          str2 = str4;
          localObject3 = localObject6;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject3;
            Fragment localFragment;
            Object localObject4 = localObject6;
          }
        }
        Object localObject5 = new Intent(this, DevlockPushActivity.class);
        ((Intent)localObject5).putExtra("canCancel", bool1);
        ((Intent)localObject5).putExtra("tipMsg", (String)localObject2);
        ((Intent)localObject5).putExtra("title", (String)localObject1);
        ((Intent)localObject5).putExtra("secondTitle", str1);
        ((Intent)localObject5).putExtra("thirdTitle", str2);
        ((Intent)localObject5).putStringArrayListExtra("wordsList", (ArrayList)localObject3);
        startActivity((Intent)localObject5);
        if ((!this.app.isLogin()) || (!this.app.getAccount().equals(BaseApplicationImpl.getApplication().getPCActiveUin()))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "onResume start push");
        }
      } while (!isResume());
      localObject1 = BaseApplicationImpl.getApplication().getPCActiveNoticeIntent();
      if (localObject1 == null) {
        if (QLog.isColorLevel()) {
          QLog.i("SplashActivity", 2, "Intent is null");
        }
      }
      for (;;)
      {
        StartupTracker.a(null, "Main_Resume_PCActive");
        if ((!TextUtils.isEmpty(this.app.getAccount())) && (!"0".equals(this.app.getAccount()))) {
          ThreadManager.getSubThreadHandler().postDelayed(new tye(this), 800L);
        }
        StartupTracker.a("Main_Resume_PCActive", null);
        ThreadManager.getSubThreadHandler().postDelayed(new tyf(this), 800L);
        ApolloGameWrapper.a(this);
        localObject1 = getIntent();
        if ((((Intent)localObject1).getExtras() != null) && (((Intent)localObject1).getBooleanExtra(MessageConstants.h, false)))
        {
          ((Intent)localObject1).removeExtra(MessageConstants.h);
          ThreadManager.post(new tyg(this), 8, null, false);
        }
        if (!isInMultiWindow()) {
          break;
        }
        localObject2 = getSupportFragmentManager();
        localObject1 = ((FragmentManager)localObject2).findFragmentByTag(ChatFragment.class.getName());
        if ((localObject1 == null) || (!((Fragment)localObject1).isVisible())) {
          break label710;
        }
        localObject2 = (ChatFragment)localObject1;
        ((ChatFragment)localObject1).e();
        return;
        try
        {
          if ((NotifyPCActiveActivity.a != null) || (!(BaseActivity.sTopActivity instanceof SplashActivity))) {
            continue;
          }
          startActivity((Intent)localObject1);
        }
        catch (Throwable localThrowable) {}
        if (QLog.isColorLevel()) {
          QLog.i("SplashActivity", 2, "", localThrowable);
        }
      }
      localFragment = ((FragmentManager)localObject2).findFragmentByTag(MainFragment.class.getName());
    } while (localFragment == null);
    ((MainFragment)localFragment).k();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnStart");
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)))
    {
      JumpAction localJumpAction = JumpParser.a(this.app, this, this.jdField_a_of_type_JavaLangString);
      localJumpAction.b(this.jdField_b_of_type_JavaLangString);
      localJumpAction.b();
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
    }
  }
  
  protected void doOnStop()
  {
    if (isInMultiWindow())
    {
      super.doOnPause();
      AbstractVideoImage.pauseAll();
      ApngImage.pauseAll();
      ApolloGameWrapper.c(this);
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
    ApolloGameWrapper.d(this);
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
  
  protected String getPreProcess()
  {
    return "com.tencent.mobileqq:peak";
  }
  
  public boolean isNeedInterruptDoMulitWindow()
  {
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).b();
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).a();
    }
    AIOConfigManager.a(this.app);
  }
  
  protected void onAccoutChangeFailed()
  {
    super.onAccoutChangeFailed();
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).c();
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
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      return localChatFragment.a(paramInt);
    }
    return null;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() == this)) {
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).a(paramLogoutReason);
    }
    b();
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null) {
      ((ChatFragment)localFragment).b(paramBoolean);
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    Object localObject1 = getSupportFragmentManager();
    Object localObject2 = ((FragmentManager)localObject1).findFragmentByTag(MainFragment.class.getName());
    if (localObject2 != null) {
      ((MainFragment)localObject2).h();
    }
    localObject1 = ((FragmentManager)localObject1).findFragmentByTag(ChatFragment.class.getName());
    if (localObject1 != null) {
      ((ChatFragment)localObject1).d();
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
      this.jdField_a_of_type_AndroidViewView = localLayoutInflater.inflate(2130968831, null);
      FPSSwipListView localFPSSwipListView = (FPSSwipListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363997);
      if (localFPSSwipListView != null) {
        this.jdField_b_of_type_AndroidViewView = localLayoutInflater.inflate(2130971544, localFPSSwipListView, false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SplashActivity", 1, "", localThrowable);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    super.getWindow().setFormat(-3);
  }
  
  protected String setLastActivityName()
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