package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
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
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.SafeModeUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpic.VideoItemEventManager;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qassistant.command.jump.QAssistantConfigItem;
import com.tencent.mobileqq.qassistant.command.jump.QAssistantConfigUtils;
import com.tencent.mobileqq.qbosssplash.common.QbossSplashUtil;
import com.tencent.mobileqq.qbosssplash.model.SplashItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StartupTrackerForAio;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import com.tencent.qqperf.tools.ProcessStats;
import com.tencent.qqperf.tools.SceneTracker;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.vip.ad.TianshuSplashUtils;
import cooperation.vip.tianshu.TianShuManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;

@RoutePage(desc="手Q主页", path="/base/start/splash")
public class SplashActivity
  extends FragmentActivity
{
  private static final long AIO_OPEN_GAP_TIME = 800L;
  public static final int FRAGMENT_CHAT = 2;
  public static final int FRAGMENT_EMPTY = 0;
  public static final String FRAGMENT_ID = "fragment_id";
  public static final int FRAGMENT_MAIN = 1;
  private static long OPEN_AIO_MIN_INTERVAL_TIME = 0L;
  public static final String SWITCH_ANIM = "switch_anim";
  public static final String TAB_INDEX = "tab_index";
  public static final String TAG = "SplashActivity";
  public static volatile int currentFragment;
  public static int sExitAIOCode = 0;
  public static long sExitAIOTime = 0L;
  public static volatile boolean sIsNormalRouteEnter;
  public static int sOpenAIOCode;
  public static volatile WeakReference<SplashActivity> sWeakInstance = null;
  private BroadcastReceiver br = null;
  private long firtCreateAIOTime;
  private ClassLoader mClassLoader = null;
  private String mJumpShecme = null;
  private long mLastOpenAIOTime = -1L;
  private int mLastOpenAIOType = -2;
  private String mLastOpenAIOUin = "";
  private long mLastOpenAioTime;
  private String mPkg = null;
  public View mPreloadConversationView;
  public View mPreloadLocalSearchBar;
  public View[] mPreloadMainViews;
  
  static
  {
    currentFragment = 1;
    sIsNormalRouteEnter = true;
    OPEN_AIO_MIN_INTERVAL_TIME = 500L;
    sOpenAIOCode = 0;
  }
  
  private boolean checkDuplication()
  {
    SplashActivity localSplashActivity = null;
    if (sWeakInstance != null) {
      localSplashActivity = (SplashActivity)sWeakInstance.get();
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
  
  private void checkGesture()
  {
    String str2;
    if (GesturePWDUtils.getGestureUnlockFailed(this, this.app.getCurrentAccountUin()))
    {
      str2 = getString(2131692939);
      if (GesturePWDUtils.getGestureUnlockFailedType(this) != 1) {
        break label69;
      }
    }
    label69:
    for (String str1 = getString(2131692942);; str1 = getString(2131692941))
    {
      DialogUtil.a(this, 230, str2, str1, 2131690800, 2131692940, new SplashActivity.7(this), new SplashActivity.8(this)).show();
      return;
    }
  }
  
  private boolean dealFromSplashAD()
  {
    if ((QbossSplashUtil.jdField_a_of_type_Boolean) && (QbossSplashUtil.jdField_a_of_type_ComTencentMobileqqQbosssplashModelSplashItem != null) && (jumpQbossSplashAction(this, this.app, QbossSplashUtil.jdField_a_of_type_ComTencentMobileqqQbosssplashModelSplashItem)))
    {
      finish();
      return false;
    }
    if ((((ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class)).needJump()) && (jumpMiniGameAction(this, this.app)))
    {
      finish();
      return false;
    }
    return true;
  }
  
  private void handleIntentFromQc(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("forward", -1);
    int j = paramIntent.getIntExtra("uintype", -1);
    if ((i > 0) && ((j == 1035) || (j == 1041) || (j == 1042)) && (this.app.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER)))
    {
      ((PushNoticeManager)this.app.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a(this, paramIntent);
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      getIntent().removeExtra("forward");
      return;
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
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
            ((CampusNoticeManager)this.app.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(null);
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
  
  private boolean handleStoryIntent(Intent paramIntent)
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
  
  private boolean highFrequencyOpenSameAio()
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
        label56:
        String str = "";
        QLog.e("SplashActivity", 2, localException1, new Object[0]);
        continue;
        if (i != this.mLastOpenAIOType) {
          bool = false;
        } else if (l - this.mLastOpenAIOTime > 800L) {
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
        break label178;
      }
      if (str.equals(this.mLastOpenAIOUin)) {
        break label134;
      }
      bool = false;
    }
    catch (Exception localException2)
    {
      break label119;
      bool = false;
      break label56;
    }
    if (!bool)
    {
      this.mLastOpenAIOTime = l;
      this.mLastOpenAIOUin = str;
      this.mLastOpenAIOType = i;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SplashActivity", 2, "highFrequencyOpenSameAio " + bool);
    }
    return bool;
  }
  
  private void initSplashState()
  {
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
  
  public static boolean jumpMiniGameAction(SplashActivity paramSplashActivity, AppInterface paramAppInterface)
  {
    QLog.d("SplashActivity", 2, "jumpMiniGameAction");
    paramAppInterface = (IMiniAppService)QRoute.api(IMiniAppService.class);
    ISplashMiniGameStarterService localISplashMiniGameStarterService = (ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class);
    paramAppInterface.splashMiniGameClickReport(localISplashMiniGameStarterService.getCurrData());
    localISplashMiniGameStarterService.setNeedJump(false);
    localISplashMiniGameStarterService.setHasJumped();
    paramAppInterface = new Intent(BaseApplicationImpl.getApplication(), localISplashMiniGameStarterService.getGameActivityClass());
    paramAppInterface.addFlags(805371904);
    paramAppInterface.putExtra("fromSplash", true);
    paramAppInterface.putExtra("processName", "com.tencent.mobileqq:mini3");
    paramAppInterface.putExtra("startDuration", System.currentTimeMillis());
    paramAppInterface.putExtra("splashData", ((ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class)).getCurrData());
    paramSplashActivity.startActivity(paramAppInterface);
    paramSplashActivity.overridePendingTransition(17432576, 17432577);
    return true;
  }
  
  public static boolean jumpQbossSplashAction(SplashActivity paramSplashActivity, QQAppInterface paramQQAppInterface, SplashItem paramSplashItem)
  {
    if (paramSplashItem == null) {}
    for (;;)
    {
      return false;
      try
      {
        int i = paramSplashItem.jdField_b_of_type_Int;
        QbossSplashUtil.jdField_a_of_type_Boolean = false;
        switch (i)
        {
        case 1: 
          if (TextUtils.isEmpty(paramSplashItem.f))
          {
            QLog.i("QSplash@QbossSplashUtil", 1, "jumpH5Url is null");
            return false;
          }
          Intent localIntent = new Intent(paramSplashActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", paramSplashItem.f);
          localIntent.putExtra("key_from_splash_ad", true);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
          paramSplashActivity.startActivity(localIntent);
          if (paramQQAppInterface != null) {
            if (TianshuSplashUtils.a(paramSplashItem.l))
            {
              TianshuSplashUtils.a(paramQQAppInterface.getCurrentUin() + "", 102, paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.j);
            }
            else
            {
              TianShuManager.setLastClickAdTraceInfo(paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.j);
              QbossSplashUtil.a(paramSplashItem.j, null, 2);
            }
          }
          break;
        case 4: 
          if (TextUtils.isEmpty(paramSplashItem.f))
          {
            QLog.i("QSplash@QbossSplashUtil", 1, "scheme is null");
            return false;
          }
          JumpParser.a(paramQQAppInterface, paramSplashActivity, paramSplashItem.f).a();
          if (paramQQAppInterface != null)
          {
            if (TianshuSplashUtils.a(paramSplashItem.l))
            {
              TianshuSplashUtils.a(paramQQAppInterface.getCurrentUin() + "", 102, paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.j);
              return false;
            }
            TianShuManager.setLastClickAdTraceInfo(paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.j);
            QbossSplashUtil.a(paramSplashItem.j, null, 2);
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
  
  public static void onSystemScreenSettingChanged()
  {
    ScreenUtil.updateCache();
    com.tencent.widget.XPanelContainer.d = 0;
  }
  
  private void setSwitch()
  {
    if (AIOUtils.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      AIOUtils.b = getIntent().getBooleanExtra("traceviewSwitch", false);
      AIOUtils.c = getIntent().getBooleanExtra("forbidChatFont", false);
      AIOUtils.d = getIntent().getBooleanExtra("forbidHeadPendant", false);
      AIOUtils.f = getIntent().getBooleanExtra("forbidChatBubble", false);
      AIOUtils.g = getIntent().getBooleanExtra("logDBOperation", false);
      com.tencent.mobileqq.app.ThreadSetting.logcatBgTaskMonitor = getIntent().getBooleanExtra("logBgTaskMonitor", false);
      AIOUtils.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("SplashActivity", 2, "traceviewSwitch: " + AIOUtils.b + " isForbidChatFontFun: " + AIOUtils.c + " isForbidHeadPendantFun: " + AIOUtils.d + " isForbidChatBubbleFun: " + AIOUtils.f + " logcatDBOperation: " + AIOUtils.g + " isEnableAutoDumpLeak: " + AppSetting.e);
  }
  
  private boolean tryOpenAio(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("open_chatfragment", false))
    {
      BBannerHelper.a(this.app, paramIntent);
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      openAIO(false, 0);
      return true;
    }
    return false;
  }
  
  private boolean tryOpenKandianTab(Intent paramIntent)
  {
    int i = 0;
    if ((paramIntent.getBooleanExtra("open_kandian_tab_fragment", false)) && (ReadInJoyHelper.o()))
    {
      setIntent(paramIntent);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        currentFragment = 1;
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
        openMainFragment(paramIntent);
        i = 1;
      }
    }
    return false;
  }
  
  private boolean tryOpenNowTab(Intent paramIntent)
  {
    if ((paramIntent.getBooleanExtra("open_now_tab_fragment", false)) && (this.app.getNowLiveManager().jdField_a_of_type_Boolean))
    {
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        currentFragment = 1;
        localObject = MainFragment.a();
        ((MainFragment)localObject).a = paramIntent;
        localFragmentTransaction.add(16908290, (Fragment)localObject, MainFragment.class.getName());
        localFragmentTransaction.commitAllowingStateLoss();
        return true;
      }
      openMainFragment(paramIntent);
      return true;
    }
    return false;
  }
  
  private boolean tryOpenQzoneTab(Intent paramIntent)
  {
    int i = 0;
    if ((paramIntent.getBooleanExtra("open_qzone_tab_fragment", false)) && (QZoneApiProxy.isInQZoneEnvironment()))
    {
      setIntent(paramIntent);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        currentFragment = 1;
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
        openMainFragment(paramIntent);
        i = 1;
      }
    }
    return false;
  }
  
  protected void clearAIO()
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
        currentFragment = 1;
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
      if (AIOSelectableDelegateImpl.a().c()) {
        AIOSelectableDelegateImpl.a().d();
      }
      return;
      label136:
      ((FragmentTransaction)localObject).show(localFragment1);
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
    //   0: aload_0
    //   1: invokespecial 741	com/tencent/mobileqq/activity/SplashActivity:initSplashState	()V
    //   4: getstatic 419	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   7: ifnull +586 -> 593
    //   10: getstatic 419	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   13: invokevirtual 744	java/lang/String:length	()I
    //   16: ifle +577 -> 593
    //   19: iconst_1
    //   20: istore_2
    //   21: iload_2
    //   22: ifeq +44 -> 66
    //   25: new 231	android/content/Intent
    //   28: dup
    //   29: aload_0
    //   30: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   33: invokespecial 746	android/content/Intent:<init>	(Landroid/content/Intent;)V
    //   36: astore_3
    //   37: aload_3
    //   38: ldc_w 747
    //   41: invokevirtual 450	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   44: pop
    //   45: aload_0
    //   46: invokespecial 748	android/support/v4/app/FragmentActivity:finish	()V
    //   49: aload_0
    //   50: aload_3
    //   51: iconst_m1
    //   52: aconst_null
    //   53: invokespecial 752	android/support/v4/app/FragmentActivity:superStartActivityForResult	(Landroid/content/Intent;ILandroid/os/Bundle;)V
    //   56: ldc2_w 753
    //   59: invokestatic 760	java/lang/Thread:sleep	(J)V
    //   62: iconst_m1
    //   63: invokestatic 764	java/lang/System:exit	(I)V
    //   66: aconst_null
    //   67: ldc_w 766
    //   70: invokestatic 770	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aconst_null
    //   74: ldc_w 772
    //   77: invokestatic 770	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aconst_null
    //   81: ldc_w 774
    //   84: invokestatic 770	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: iconst_0
    //   89: putfield 777	com/tencent/mobileqq/activity/SplashActivity:mActNeedImmersive	Z
    //   92: aload_0
    //   93: aload_1
    //   94: invokespecial 779	android/support/v4/app/FragmentActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   97: pop
    //   98: ldc_w 774
    //   101: aconst_null
    //   102: invokestatic 770	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: invokevirtual 782	com/tencent/mobileqq/activity/SplashActivity:needFinish	()Z
    //   109: ifne +10 -> 119
    //   112: aload_0
    //   113: invokespecial 784	com/tencent/mobileqq/activity/SplashActivity:checkDuplication	()Z
    //   116: ifeq +23 -> 139
    //   119: aload_0
    //   120: invokevirtual 150	com/tencent/mobileqq/activity/SplashActivity:finish	()V
    //   123: ldc_w 772
    //   126: aconst_null
    //   127: invokestatic 770	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: ldc_w 766
    //   133: aconst_null
    //   134: invokestatic 770	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: iconst_0
    //   138: ireturn
    //   139: aload_0
    //   140: invokespecial 786	com/tencent/mobileqq/activity/SplashActivity:dealFromSplashAD	()Z
    //   143: ifeq +448 -> 591
    //   146: aload_0
    //   147: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   150: invokevirtual 789	android/content/Intent:getAction	()Ljava/lang/String;
    //   153: astore_3
    //   154: aload_3
    //   155: ifnull +33 -> 188
    //   158: ldc_w 791
    //   161: aload_3
    //   162: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +23 -> 188
    //   168: aload_0
    //   169: invokevirtual 150	com/tencent/mobileqq/activity/SplashActivity:finish	()V
    //   172: iconst_0
    //   173: ireturn
    //   174: astore_1
    //   175: ldc 36
    //   177: iconst_2
    //   178: aload_1
    //   179: iconst_0
    //   180: anewarray 386	java/lang/Object
    //   183: invokestatic 390	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   186: iconst_1
    //   187: ireturn
    //   188: new 109	java/lang/ref/WeakReference
    //   191: dup
    //   192: aload_0
    //   193: invokespecial 794	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   196: putstatic 65	com/tencent/mobileqq/activity/SplashActivity:sWeakInstance	Ljava/lang/ref/WeakReference;
    //   199: aload_1
    //   200: ifnull +42 -> 242
    //   203: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +12 -> 218
    //   209: ldc 36
    //   211: iconst_2
    //   212: ldc_w 796
    //   215: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_0
    //   219: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   222: ldc_w 592
    //   225: iconst_0
    //   226: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   229: pop
    //   230: aload_0
    //   231: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   234: ldc_w 609
    //   237: iconst_0
    //   238: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   241: pop
    //   242: aload_0
    //   243: getfield 155	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   246: iconst_0
    //   247: putfield 799	com/tencent/mobileqq/app/QQAppInterface:isClearTaskBySystem	Z
    //   250: aload_0
    //   251: invokespecial 801	com/tencent/mobileqq/activity/SplashActivity:setSwitch	()V
    //   254: aload_0
    //   255: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   258: astore_3
    //   259: aload_3
    //   260: invokevirtual 351	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   263: ifnull +78 -> 341
    //   266: aload_3
    //   267: invokevirtual 351	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   270: ldc 229
    //   272: invokevirtual 806	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   275: ifne +18 -> 293
    //   278: aload_3
    //   279: ldc_w 808
    //   282: iconst_0
    //   283: invokevirtual 290	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   286: ifeq +27 -> 313
    //   289: aload_1
    //   290: ifnonnull +23 -> 313
    //   293: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +12 -> 308
    //   299: ldc 36
    //   301: iconst_2
    //   302: ldc_w 810
    //   305: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload_0
    //   309: iconst_0
    //   310: putfield 813	com/tencent/mobileqq/activity/SplashActivity:mCanLock	Z
    //   313: aload_0
    //   314: aload_0
    //   315: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   318: ldc_w 815
    //   321: invokevirtual 277	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 85	com/tencent/mobileqq/activity/SplashActivity:mJumpShecme	Ljava/lang/String;
    //   327: aload_0
    //   328: aload_0
    //   329: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   332: ldc_w 817
    //   335: invokevirtual 277	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   338: putfield 87	com/tencent/mobileqq/activity/SplashActivity:mPkg	Ljava/lang/String;
    //   341: aload_0
    //   342: aload_0
    //   343: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   346: invokespecial 819	com/tencent/mobileqq/activity/SplashActivity:tryOpenAio	(Landroid/content/Intent;)Z
    //   349: ifne +249 -> 598
    //   352: aload_0
    //   353: aload_0
    //   354: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   357: invokespecial 821	com/tencent/mobileqq/activity/SplashActivity:tryOpenNowTab	(Landroid/content/Intent;)Z
    //   360: ifne +238 -> 598
    //   363: aload_0
    //   364: aload_0
    //   365: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   368: invokespecial 823	com/tencent/mobileqq/activity/SplashActivity:tryOpenKandianTab	(Landroid/content/Intent;)Z
    //   371: ifne +227 -> 598
    //   374: aload_0
    //   375: aload_0
    //   376: invokevirtual 259	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   379: invokespecial 825	com/tencent/mobileqq/activity/SplashActivity:tryOpenQzoneTab	(Landroid/content/Intent;)Z
    //   382: ifeq +196 -> 578
    //   385: goto +213 -> 598
    //   388: iload_2
    //   389: ifne +35 -> 424
    //   392: aload_0
    //   393: invokevirtual 618	com/tencent/mobileqq/activity/SplashActivity:getSupportFragmentManager	()Landroid/support/v4/app/FragmentManager;
    //   396: astore_1
    //   397: iconst_1
    //   398: putstatic 67	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   401: aload_1
    //   402: invokevirtual 624	android/support/v4/app/FragmentManager:beginTransaction	()Landroid/support/v4/app/FragmentTransaction;
    //   405: ldc_w 642
    //   408: invokestatic 638	com/tencent/mobileqq/activity/home/MainFragment:a	()Lcom/tencent/mobileqq/activity/home/MainFragment;
    //   411: ldc_w 626
    //   414: invokevirtual 631	java/lang/Class:getName	()Ljava/lang/String;
    //   417: invokevirtual 648	android/support/v4/app/FragmentTransaction:add	(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;
    //   420: invokevirtual 651	android/support/v4/app/FragmentTransaction:commitAllowingStateLoss	()I
    //   423: pop
    //   424: invokestatic 831	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   427: new 833	com/tencent/mobileqq/activity/SplashActivity$1
    //   430: dup
    //   431: aload_0
    //   432: invokespecial 834	com/tencent/mobileqq/activity/SplashActivity$1:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   435: ldc2_w 835
    //   438: invokevirtual 842	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   441: pop
    //   442: aload_0
    //   443: aload_3
    //   444: invokespecial 844	com/tencent/mobileqq/activity/SplashActivity:handleStoryIntent	(Landroid/content/Intent;)Z
    //   447: pop
    //   448: iconst_1
    //   449: putstatic 847	com/tencent/common/app/BaseApplicationImpl:appMainActivityHasLanuch	Z
    //   452: ldc_w 772
    //   455: aconst_null
    //   456: invokestatic 770	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: getstatic 852	com/tencent/widget/immersive/ImmersiveUtils:statusHeightCorrect	Z
    //   462: ifne +29 -> 491
    //   465: aload_0
    //   466: invokevirtual 855	com/tencent/mobileqq/activity/SplashActivity:isInMultiWindow	()Z
    //   469: ifne +22 -> 491
    //   472: aload_0
    //   473: invokevirtual 859	com/tencent/mobileqq/activity/SplashActivity:getWindow	()Landroid/view/Window;
    //   476: invokevirtual 865	android/view/Window:getDecorView	()Landroid/view/View;
    //   479: new 867	com/tencent/mobileqq/activity/SplashActivity$2
    //   482: dup
    //   483: aload_0
    //   484: invokespecial 868	com/tencent/mobileqq/activity/SplashActivity$2:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   487: invokevirtual 874	android/view/View:post	(Ljava/lang/Runnable;)Z
    //   490: pop
    //   491: invokestatic 878	com/tencent/mobileqq/activity/SplashActivity:getActivityRoutes	()Ljava/util/ArrayList;
    //   494: astore_1
    //   495: getstatic 67	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   498: iconst_1
    //   499: if_icmpne +43 -> 542
    //   502: aload_0
    //   503: invokevirtual 881	com/tencent/mobileqq/activity/SplashActivity:getCurrentTab	()I
    //   506: getstatic 885	com/tencent/mobileqq/activity/home/impl/FrameControllerUtil:a	I
    //   509: if_icmpne +33 -> 542
    //   512: aload_1
    //   513: invokevirtual 890	java/util/ArrayList:size	()I
    //   516: iconst_2
    //   517: if_icmpgt +25 -> 542
    //   520: aload_1
    //   521: invokevirtual 890	java/util/ArrayList:size	()I
    //   524: iconst_2
    //   525: if_icmpne +21 -> 546
    //   528: ldc_w 892
    //   531: aload_1
    //   532: iconst_0
    //   533: invokevirtual 895	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   536: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   539: ifne +7 -> 546
    //   542: iconst_0
    //   543: putstatic 69	com/tencent/mobileqq/activity/SplashActivity:sIsNormalRouteEnter	Z
    //   546: getstatic 67	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   549: iconst_1
    //   550: if_icmpne -364 -> 186
    //   553: aload_3
    //   554: invokestatic 900	com/tencent/mobileqq/qassistant/command/jump/QAssistantConfigUtils:a	(Landroid/content/Intent;)Lcom/tencent/mobileqq/qassistant/command/jump/QAssistantConfigItem;
    //   557: astore_1
    //   558: aload_1
    //   559: ifnull -373 -> 186
    //   562: aload_1
    //   563: aload_0
    //   564: getfield 155	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   567: aload_0
    //   568: invokevirtual 904	com/tencent/mobileqq/activity/SplashActivity:getActivity	()Landroid/app/Activity;
    //   571: invokevirtual 909	com/tencent/mobileqq/qassistant/command/jump/QAssistantConfigItem:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Z
    //   574: pop
    //   575: goto -389 -> 186
    //   578: iconst_0
    //   579: istore_2
    //   580: goto -192 -> 388
    //   583: astore_3
    //   584: goto -522 -> 62
    //   587: astore_1
    //   588: goto -247 -> 341
    //   591: iconst_0
    //   592: ireturn
    //   593: iconst_0
    //   594: istore_2
    //   595: goto -574 -> 21
    //   598: iconst_1
    //   599: istore_2
    //   600: goto -212 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	SplashActivity
    //   0	603	1	paramBundle	Bundle
    //   20	580	2	i	int
    //   36	518	3	localObject	Object
    //   583	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	19	174	java/lang/Exception
    //   25	56	174	java/lang/Exception
    //   62	66	174	java/lang/Exception
    //   66	119	174	java/lang/Exception
    //   119	137	174	java/lang/Exception
    //   139	154	174	java/lang/Exception
    //   158	172	174	java/lang/Exception
    //   188	199	174	java/lang/Exception
    //   203	218	174	java/lang/Exception
    //   218	242	174	java/lang/Exception
    //   242	289	174	java/lang/Exception
    //   293	308	174	java/lang/Exception
    //   308	313	174	java/lang/Exception
    //   341	385	174	java/lang/Exception
    //   392	424	174	java/lang/Exception
    //   424	491	174	java/lang/Exception
    //   491	542	174	java/lang/Exception
    //   542	546	174	java/lang/Exception
    //   546	558	174	java/lang/Exception
    //   562	575	174	java/lang/Exception
    //   56	62	583	java/lang/Exception
    //   313	341	587	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnDestroy");
    }
    if (this.br != null) {}
    try
    {
      unregisterReceiver(this.br);
      this.br = null;
      if (QQPlayerService.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "QQPlayerService stopPlayMusic");
        }
        QQPlayerService.c(getApplicationContext());
      }
      onSystemScreenSettingChanged();
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
    if (((paramInt == 24) || (paramInt == 25)) && (VideoItemEventManager.a(this).a()))
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
      if (needFinish())
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
      if (tryOpenAio(paramIntent)) {
        return;
      }
      if (Boolean.valueOf(((Bundle)localObject).getBoolean("EXIT", false)).booleanValue()) {
        finish();
      }
      if (((Bundle)localObject).getBoolean("activepull_push_flag"))
      {
        setIntent(paramIntent);
        handleNativeIntentByPullActivePush(paramIntent);
        return;
      }
      if ((((Bundle)localObject).getInt("fragment_id") == 1) && (currentFragment != 1))
      {
        setIntent(paramIntent);
        openMainFragment(paramIntent);
        paramIntent = QAssistantConfigUtils.a(paramIntent);
        if (paramIntent == null) {
          return;
        }
        paramIntent.a(this.app, getActivity());
        return;
      }
    }
    if (currentFragment == 1)
    {
      localObject = (MainFragment)getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject != null)
      {
        setIntent(paramIntent);
        ((MainFragment)localObject).a(paramIntent);
        paramIntent = QAssistantConfigUtils.a(paramIntent);
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
      ((MainFragment)localFragment).j();
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
      checkGesture();
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
      handleIntentFromQc(getIntent());
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
      ((MainFragment)localFragment).j();
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
    StartupTracker.a(null, "Main_Resume_PCActive");
    if ((!TextUtils.isEmpty(this.app.getAccount())) && (!"0".equals(this.app.getAccount()))) {
      ThreadManager.getSubThreadHandler().postDelayed(new SplashActivity.3(this), 800L);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new SplashActivity.4(this), 800L);
    StartupTracker.a("Main_Resume_PCActive", null);
    ThreadManager.getSubThreadHandler().postDelayed(new SplashActivity.5(this), 800L);
    localObject1 = getIntent();
    if ((((Intent)localObject1).getExtras() != null) && (((Intent)localObject1).getBooleanExtra(MessageConstants.h, false)))
    {
      ((Intent)localObject1).removeExtra(MessageConstants.h);
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
      SafeModeUtil.d();
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
    if ((this.mJumpShecme != null) && (this.mJumpShecme.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.mPkg)))
    {
      JumpAction localJumpAction = JumpParser.a(this.app, this, this.mJumpShecme);
      localJumpAction.c(this.mPkg);
      localJumpAction.a();
      this.mJumpShecme = null;
      this.mPkg = null;
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
    if ((sWeakInstance != null) && (sWeakInstance.get() == this)) {
      sWeakInstance = null;
    }
  }
  
  public String getActivityName()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SplashActivity");
    if (currentFragment == 1) {}
    for (String str = "_MainFragment";; str = "_ChatFragment") {
      return str;
    }
  }
  
  public String getCIOPageName()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (currentFragment == 1) {}
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
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader3 = super.getClassLoader();
    ClassLoader localClassLoader2 = this.mClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.mClassLoader = localClassLoader1;
      return localClassLoader1;
    }
    return localClassLoader3;
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
  
  public int getCurrentTab()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      return ((MainFragment)localFragment).a();
    }
    return 0;
  }
  
  public String getPreProcess()
  {
    return "com.tencent.mobileqq:peak";
  }
  
  public void handleNativeIntentByPullActivePush(Intent paramIntent)
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
          new JumpAction(this.app, this).o();
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
  
  public boolean isNeedInterruptDoMulitWindow()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needFinish()
  {
    if ((this.app != null) && (this.app.isExitTaskUnfinished)) {
      QLog.d("SplashActivity", 1, "LastExitTaskUnfinished finish");
    }
    Object localObject1;
    do
    {
      return true;
      if ((NotificationActivity.instance != null) && (!NotificationActivity.instance.isFinishing()))
      {
        QLog.d("SplashActivity", 1, "needFinish, notification activity exists");
        localObject1 = NotificationActivity.instance.getIntent();
        NotificationActivity.instance.finish();
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
      if (!TextUtils.equals((CharSequence)localObject1, "5105")) {
        ((SharedPreferences.Editor)localObject2).putString("qq_version_pre", (String)localObject1);
      }
      if (!TextUtils.equals(str1, str2)) {
        ((SharedPreferences.Editor)localObject2).putString("qq_version_full_pre", str1);
      }
      ((SharedPreferences.Editor)localObject2).putString("qq_version", "5105");
      ((SharedPreferences.Editor)localObject2).putString("qq_version_full", str2);
      ((SharedPreferences.Editor)localObject2).commit();
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, String.format("update version pre[%s, %s], cur[%s, %s]", new Object[] { localObject1, str1, "5105", str2 }));
      }
      RouteUtils.a(this, new Intent(), "/base/login");
      return true;
    }
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
    AIOConfigManager.a(this.app);
    SplashADUtil.a(BaseApplicationImpl.getContext(), this.app.getLongAccountUin());
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
    if (FrameHelperActivity.a != null)
    {
      DrawerFrame localDrawerFrame = (DrawerFrame)FrameHelperActivity.a.get();
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
    if ((sWeakInstance != null) && (sWeakInstance.get() == this)) {
      sWeakInstance = null;
    }
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    clearAIO();
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
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).h();
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).e();
    }
    if (!"1000".equals(ThemeUtil.getCurrentThemeId()))
    {
      if (getAppInterface() != null) {
        BannerManager.a().a(28, 0, null);
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
  
  public void openAIO(boolean paramBoolean, int paramInt)
  {
    AIOPreLoadEngine.a().b();
    ThreadRegulator.a().a(1);
    sOpenAIOCode = HardCoderManager.a().a(0, 1, 0, 0, 2000, 301, 4L, Process.myTid(), "openAIO");
    SceneTracker.a().a("ChatFragment", true);
    StartupTrackerForAio.a(null, "AIO_Start_cost");
    if ((AIOUtils.a(this, this.app, paramBoolean, getIntent())) || (highFrequencyOpenSameAio())) {}
    label567:
    for (;;)
    {
      return;
      long l = SystemClock.uptimeMillis();
      if (l - this.mLastOpenAioTime >= OPEN_AIO_MIN_INTERVAL_TIME)
      {
        this.mLastOpenAioTime = l;
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
          ((MainFragment)localObject2).q();
          if (((MainFragment)localObject2).a() != FrameControllerUtil.a) {
            ((MainFragment)localObject2).a(FrameControllerUtil.a);
          }
        }
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("SplashActivity", 2, "openAIO f != null ");
          }
          ChatFragment localChatFragment = (ChatFragment)localObject1;
          localChatFragment.d();
          currentFragment = 2;
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
            break label567;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
          return;
          if (!((Fragment)localObject1).isVisible())
          {
            if ((paramBoolean) && (ProcessStats.a() > 1)) {
              localFragmentTransaction.setCustomAnimations(2130772052, 2130772062);
            }
            localFragmentTransaction.show((Fragment)localObject1);
            localFragmentTransaction.hide((Fragment)localObject2);
            localFragmentTransaction.commitAllowingStateLoss();
            continue;
            if (Math.abs(SystemClock.uptimeMillis() - this.firtCreateAIOTime) < 1000L)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("SplashActivity", 2, "openAIO hasOpenedAIO true, renturn ");
              return;
            }
            this.firtCreateAIOTime = SystemClock.uptimeMillis();
            if ((paramBoolean) && (ProcessStats.a() > 1)) {
              localFragmentTransaction.setCustomAnimations(2130772052, 2130772062);
            }
            localObject1 = ChatFragment.a();
            currentFragment = 2;
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
    }
  }
  
  public void openMainFragment(Intent paramIntent)
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
    if (currentFragment != 1)
    {
      localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      localObject = (ChatFragment)((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    }
    try
    {
      if (paramIntent.getBooleanExtra("switch_anim", false)) {
        localFragmentTransaction.setCustomAnimations(2130772061, 2130772053);
      }
      currentFragment = 1;
      localFragmentTransaction.show(localMainFragment);
      localFragmentTransaction.hide((Fragment)localObject);
      localFragmentTransaction.commitAllowingStateLoss();
      if ((localObject != null) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null))
      {
        if ((((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Boolean) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.d) && (!((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c)) {
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
        if ((((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.b) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.e) && (!((ChatFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c)) {
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        } else {
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 450);
        }
      }
    }
  }
  
  public void preloadUi()
  {
    try
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(this);
      this.mPreloadMainViews = FrameFragment.a(localLayoutInflater);
      this.mPreloadConversationView = localLayoutInflater.inflate(2131559044, null);
      FPSSwipListView localFPSSwipListView = (FPSSwipListView)this.mPreloadConversationView.findViewById(2131376667);
      if (localFPSSwipListView != null) {
        this.mPreloadLocalSearchBar = localLayoutInflater.inflate(2131562952, localFPSSwipListView, false);
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
      return ((MainFragment)localFragment).b();
    }
    return super.setLastActivityName();
  }
  
  public void showGifAnnimate()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).i();
    }
  }
  
  public void updateMain(int paramInt1, int paramInt2, Object paramObject)
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).a(paramInt1, paramInt2, paramObject);
    }
  }
  
  public void updateTabRedTouch(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    Object localObject = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localObject != null)
    {
      localObject = (MainFragment)localObject;
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabRedTouch((FrameFragment)localObject, paramInt, paramRedTypeInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity
 * JD-Core Version:    0.7.0.1
 */