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
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeOverdueBannerProcessor;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpic.VideoItemEventManager;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.pushnotice.PushNoticeUtil;
import com.tencent.mobileqq.pushnotice.ThirdPushManager;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qassistant.config.QAssistantConfigItem;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpActionLegacy;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTrackerForAio;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import com.tencent.qqperf.tools.ProcessStats;
import com.tencent.qqperf.tools.SceneTracker;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.vip.ad.TianshuReportUtils;
import cooperation.vip.tianshu.TianShuManager;
import java.lang.ref.WeakReference;
import mqq.app.Constants.LogoutReason;

@RoutePage(desc="手Q主页", path="/base/start/splash")
public class SplashActivity
  extends BaseActivity
{
  private static final long AIO_OPEN_GAP_TIME = 800L;
  public static final int FRAGMENT_CHAT = 2;
  public static final int FRAGMENT_EMPTY = 0;
  public static final String FRAGMENT_ID = "fragment_id";
  public static final int FRAGMENT_MAIN = 1;
  private static long OPEN_AIO_MIN_INTERVAL_TIME = 500L;
  public static final String SWITCH_ANIM = "switch_anim";
  public static final String TAB_INDEX = "tab_index";
  public static final String TAG = "SplashActivity";
  public static volatile int currentFragment = 1;
  public static int sExitAIOCode = 0;
  public static long sExitAIOTime = 0L;
  public static volatile boolean sIsNormalRouteEnter = true;
  public static int sOpenAIOCode;
  public static volatile WeakReference<SplashActivity> sWeakInstance;
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
  
  private boolean checkDuplication()
  {
    SplashActivity localSplashActivity;
    if (sWeakInstance != null) {
      localSplashActivity = (SplashActivity)sWeakInstance.get();
    } else {
      localSplashActivity = null;
    }
    if ((localSplashActivity != null) && (localSplashActivity != this) && (!localSplashActivity.isFinishing()))
    {
      int i = getTaskId();
      int j = localSplashActivity.getTaskId();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDuplication, ");
      localStringBuilder.append(localSplashActivity);
      localStringBuilder.append(", ");
      localStringBuilder.append(j);
      localStringBuilder.append(", ");
      localStringBuilder.append(this);
      localStringBuilder.append(", ");
      localStringBuilder.append(i);
      QLog.d("SplashActivity", 1, localStringBuilder.toString());
      if (i == j) {
        return true;
      }
      localSplashActivity.finish();
    }
    return false;
  }
  
  private void checkGesture()
  {
    if (GesturePWDUtils.getGestureUnlockFailed(this, this.app.getCurrentAccountUin()))
    {
      String str2 = getString(2131890010);
      String str1;
      if (GesturePWDUtils.getGestureUnlockFailedType(this) == 1) {
        str1 = getString(2131890013);
      } else {
        str1 = getString(2131890012);
      }
      DialogUtil.a(this, 230, str2, str1, 2131887648, 2131890011, new SplashActivity.6(this), new SplashActivity.7(this)).show();
    }
  }
  
  private boolean dealFromSplashAD()
  {
    if ((VasSplashUtil.c) && (VasSplashUtil.f != null) && (jumpVasSplashAction(this, this.app, VasSplashUtil.f)))
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
    Intent localIntent;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
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
      else
      {
        paramIntent = paramIntent.getParcelableExtra("AllInOne");
        if ((paramIntent instanceof AllInOne))
        {
          paramIntent = (AllInOne)paramIntent;
          paramIntent.lastActivity = 100;
          paramIntent.profileEntryType = 6;
          ProfileUtils.openProfileCard(this, paramIntent);
        }
      }
    }
    else
    {
      localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtra("uin", paramIntent.getStringExtra("uin"));
      localIntent.putExtra("uintype", paramIntent.getIntExtra("uintype", 0));
      localIntent.putExtra("yuyin", paramIntent.getBooleanExtra("yuyin", false));
      localIntent.putExtra("uinname", paramIntent.getStringExtra("uinname"));
      localIntent.putExtra("enterchatwin", true);
      startActivity(localIntent);
      getIntent().removeExtra("fromMsgBox");
    }
    getIntent().removeExtra("forward");
  }
  
  private boolean handleStoryIntent(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("jump_to_story", false))
    {
      Intent localIntent = new Intent(this, QQStoryMainActivity.class);
      localIntent.replaceExtras(paramIntent.getExtras());
      startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  private boolean highFrequencyOpenSameAio()
  {
    Intent localIntent = getIntent();
    Object localObject = "";
    int i = -1;
    boolean bool2 = false;
    try
    {
      String str = localIntent.getStringExtra("uin");
      localObject = str;
      int j = localIntent.getIntExtra("uintype", -1);
      localObject = str;
      i = j;
    }
    catch (Exception localException)
    {
      QLog.e("SplashActivity", 2, localException, new Object[0]);
    }
    long l = SystemClock.uptimeMillis();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (!((String)localObject).equals(this.mLastOpenAIOUin)) {
        bool1 = bool2;
      } else if (i != this.mLastOpenAIOType) {
        bool1 = bool2;
      } else if (l - this.mLastOpenAIOTime > 800L) {
        bool1 = bool2;
      } else {
        bool1 = true;
      }
    }
    if (!bool1)
    {
      this.mLastOpenAIOTime = l;
      this.mLastOpenAIOUin = ((String)localObject);
      this.mLastOpenAIOType = i;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("highFrequencyOpenSameAio ");
      ((StringBuilder)localObject).append(bool1);
      QLog.i("SplashActivity", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  private void initSplashState()
  {
    if ("Success".equals(BaseApplicationImpl.sInjectResult))
    {
      BaseApplicationImpl.sSplashActivityEscapedMsg = "";
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sInjectResult:");
    ((StringBuilder)localObject).append(BaseApplicationImpl.sInjectResult);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      throw new IllegalAccessError("SplashActivity escapes!");
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("\n");
      localStringBuilder.append(Log.getStackTraceString(localThrowable));
      BaseApplicationImpl.sSplashActivityEscapedMsg = localStringBuilder.toString();
    }
  }
  
  private boolean intercept()
  {
    return PushNoticeUtil.a(this, getIntent());
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
  
  public static boolean jumpVasSplashAction(SplashActivity paramSplashActivity, QQAppInterface paramQQAppInterface, SplashItem paramSplashItem)
  {
    if (paramSplashItem == null) {
      return false;
    }
    try
    {
      int i = paramSplashItem.g;
      VasSplashUtil.c = false;
      if (i != 1)
      {
        if (i != 4) {
          return false;
        }
        if (TextUtils.isEmpty(paramSplashItem.h))
        {
          QLog.i("QSplash@VasSplashUtil", 1, "scheme is null");
          return false;
        }
        JumpParser.a(paramQQAppInterface, paramSplashActivity, paramSplashItem.h).a();
        TianShuManager.setLastClickAdTraceInfo(paramSplashItem.b, paramSplashItem.n);
        if (paramSplashItem.c())
        {
          TianshuReportUtils.b(paramSplashItem.b, 102, paramSplashItem.n);
          return false;
        }
        TianshuReportUtils.c(paramSplashItem.b, 102, paramSplashItem.n);
        return false;
      }
      if (TextUtils.isEmpty(paramSplashItem.h))
      {
        QLog.i("QSplash@VasSplashUtil", 1, "jumpH5Url is null");
        return false;
      }
      paramQQAppInterface = new Intent(paramSplashActivity, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("url", paramSplashItem.h);
      paramQQAppInterface.putExtra("key_from_splash_ad", true);
      paramQQAppInterface.putExtra("big_brother_source_key", "biz_src_jc_vip");
      paramSplashActivity.startActivity(paramQQAppInterface);
      TianShuManager.setLastClickAdTraceInfo(paramSplashItem.b, paramSplashItem.n);
      if (paramSplashItem.c())
      {
        TianshuReportUtils.b(paramSplashItem.b, 102, paramSplashItem.n);
        return true;
      }
      TianshuReportUtils.c(paramSplashItem.b, 102, paramSplashItem.n);
      return true;
    }
    catch (Exception paramSplashActivity) {}
    return false;
  }
  
  public static void onSystemScreenSettingChanged()
  {
    ScreenUtil.updateCache();
    com.tencent.widget.XPanelContainer.d = 0;
  }
  
  private void setSwitch()
  {
    if (AIOUtils.a) {
      return;
    }
    AIOUtils.b = getIntent().getBooleanExtra("traceviewSwitch", false);
    AIOUtils.c = getIntent().getBooleanExtra("forbidChatFont", false);
    AIOUtils.d = getIntent().getBooleanExtra("forbidHeadPendant", false);
    AIOUtils.f = getIntent().getBooleanExtra("forbidChatBubble", false);
    AIOUtils.g = getIntent().getBooleanExtra("logDBOperation", false);
    com.tencent.mobileqq.app.ThreadSetting.logcatBgTaskMonitor = getIntent().getBooleanExtra("logBgTaskMonitor", false);
    AIOUtils.a = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("traceviewSwitch: ");
      localStringBuilder.append(AIOUtils.b);
      localStringBuilder.append(" isForbidChatFontFun: ");
      localStringBuilder.append(AIOUtils.c);
      localStringBuilder.append(" isForbidHeadPendantFun: ");
      localStringBuilder.append(AIOUtils.d);
      localStringBuilder.append(" isForbidChatBubbleFun: ");
      localStringBuilder.append(AIOUtils.f);
      localStringBuilder.append(" logcatDBOperation: ");
      localStringBuilder.append(AIOUtils.g);
      localStringBuilder.append(" isEnableAutoDumpLeak: ");
      localStringBuilder.append(AppSetting.f);
      QLog.d("SplashActivity", 2, localStringBuilder.toString());
    }
  }
  
  private boolean tryOpenAio(Intent paramIntent)
  {
    int i;
    if (paramIntent.getIntExtra("uintype", -1) == 10014) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramIntent.getBooleanExtra("open_chatfragment", false)) && (i == 0))
    {
      BBannerHelper.a(this.app, paramIntent);
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      openAIO(false, 0);
      return true;
    }
    return false;
  }
  
  private boolean tryOpenFlashShowTab(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("open_flash_show_tab_fragment", false))
    {
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        currentFragment = 1;
        localObject = MainFragment.a();
        ((MainFragment)localObject).r = paramIntent;
        localFragmentTransaction.add(16908290, (Fragment)localObject, MainFragment.class.getName());
        localFragmentTransaction.commitAllowingStateLoss();
        return true;
      }
      openMainFragment(paramIntent);
      return true;
    }
    return false;
  }
  
  private boolean tryOpenKandianTab(Intent paramIntent)
  {
    int i = 0;
    if ((paramIntent.getBooleanExtra("open_kandian_tab_fragment", false)) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()))
    {
      setIntent(paramIntent);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        currentFragment = 1;
        localObject = MainFragment.a();
        ((MainFragment)localObject).r = paramIntent;
        localFragmentTransaction.add(16908290, (Fragment)localObject, MainFragment.class.getName());
        localFragmentTransaction.commitAllowingStateLoss();
      }
      else
      {
        openMainFragment(paramIntent);
        i = 1;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("tryOpenKandianTab type : ");
        paramIntent.append(i);
        QLog.d("SplashActivity", 2, paramIntent.toString());
      }
      return true;
    }
    return false;
  }
  
  private boolean tryOpenNowTab(Intent paramIntent)
  {
    if ((paramIntent.getBooleanExtra("open_now_tab_fragment", false)) && (this.app.getNowLiveManager().d))
    {
      setIntent(paramIntent);
      getIntent().putExtra("isBack2Root", true);
      Object localObject = getSupportFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      if (((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName()) == null)
      {
        currentFragment = 1;
        localObject = MainFragment.a();
        ((MainFragment)localObject).r = paramIntent;
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
        ((MainFragment)localObject).r = paramIntent;
        localFragmentTransaction.add(16908290, (Fragment)localObject, MainFragment.class.getName());
        localFragmentTransaction.commitAllowingStateLoss();
      }
      else
      {
        openMainFragment(paramIntent);
        i = 1;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("tryOpenQzoneTab type : ");
        paramIntent.append(i);
        QLog.d("SplashActivity", 2, paramIntent.toString());
      }
      return true;
    }
    return false;
  }
  
  protected void clearAIO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 4, "clearAIO");
    }
    AIOPreLoadEngine.a().c();
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
        if (localFragment1 == null) {
          ((FragmentTransaction)localObject).add(16908290, MainFragment.a(), MainFragment.class.getName());
        } else {
          ((FragmentTransaction)localObject).show(localFragment1);
        }
      }
      ((FragmentTransaction)localObject).remove(localFragment2).commitAllowingStateLoss();
      if (AIOSelectableDelegateImpl.a().l()) {
        AIOSelectableDelegateImpl.a().n();
      }
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if ((localFragment != null) && (localFragment.isVisible()))
    {
      ((ChatFragment)localFragment).onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localObject != null) {
      ((MainFragment)localObject).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  /* Error */
  protected boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 735	com/tencent/mobileqq/activity/SplashActivity:initSplashState	()V
    //   4: getstatic 393	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   7: ifnull +794 -> 801
    //   10: getstatic 393	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   13: invokevirtual 738	java/lang/String:length	()I
    //   16: ifle +785 -> 801
    //   19: iconst_1
    //   20: istore_2
    //   21: goto +3 -> 24
    //   24: iload_2
    //   25: ifeq +44 -> 69
    //   28: new 221	android/content/Intent
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   36: invokespecial 740	android/content/Intent:<init>	(Landroid/content/Intent;)V
    //   39: astore_3
    //   40: aload_3
    //   41: ldc_w 741
    //   44: invokevirtual 446	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   47: pop
    //   48: aload_0
    //   49: invokespecial 742	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   52: aload_0
    //   53: aload_3
    //   54: iconst_m1
    //   55: aconst_null
    //   56: invokespecial 746	com/tencent/mobileqq/app/BaseActivity:superStartActivityForResult	(Landroid/content/Intent;ILandroid/os/Bundle;)V
    //   59: ldc2_w 747
    //   62: invokestatic 754	java/lang/Thread:sleep	(J)V
    //   65: iconst_m1
    //   66: invokestatic 758	java/lang/System:exit	(I)V
    //   69: aconst_null
    //   70: ldc_w 760
    //   73: invokestatic 764	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aconst_null
    //   77: ldc_w 766
    //   80: invokestatic 764	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aconst_null
    //   84: ldc_w 768
    //   87: invokestatic 764	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 771	com/tencent/mobileqq/activity/SplashActivity:mActNeedImmersive	Z
    //   95: aload_0
    //   96: aload_1
    //   97: invokespecial 773	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   100: pop
    //   101: ldc_w 768
    //   104: aconst_null
    //   105: invokestatic 764	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_0
    //   109: invokespecial 775	com/tencent/mobileqq/activity/SplashActivity:intercept	()Z
    //   112: ifne +647 -> 759
    //   115: aload_0
    //   116: invokevirtual 778	com/tencent/mobileqq/activity/SplashActivity:needFinish	()Z
    //   119: ifne +640 -> 759
    //   122: aload_0
    //   123: invokespecial 780	com/tencent/mobileqq/activity/SplashActivity:checkDuplication	()Z
    //   126: ifeq +6 -> 132
    //   129: goto +630 -> 759
    //   132: aload_0
    //   133: invokespecial 782	com/tencent/mobileqq/activity/SplashActivity:dealFromSplashAD	()Z
    //   136: ifne +5 -> 141
    //   139: iconst_0
    //   140: ireturn
    //   141: aload_0
    //   142: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   145: invokevirtual 785	android/content/Intent:getAction	()Ljava/lang/String;
    //   148: astore_3
    //   149: aload_3
    //   150: ifnull +19 -> 169
    //   153: ldc_w 787
    //   156: aload_3
    //   157: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +9 -> 169
    //   163: aload_0
    //   164: invokevirtual 138	com/tencent/mobileqq/activity/SplashActivity:finish	()V
    //   167: iconst_0
    //   168: ireturn
    //   169: new 97	java/lang/ref/WeakReference
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 790	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   177: putstatic 95	com/tencent/mobileqq/activity/SplashActivity:sWeakInstance	Ljava/lang/ref/WeakReference;
    //   180: aload_1
    //   181: ifnull +42 -> 223
    //   184: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +12 -> 199
    //   190: ldc 36
    //   192: iconst_2
    //   193: ldc_w 792
    //   196: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_0
    //   200: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   203: ldc_w 579
    //   206: iconst_0
    //   207: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   210: pop
    //   211: aload_0
    //   212: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   215: ldc_w 642
    //   218: iconst_0
    //   219: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   222: pop
    //   223: aload_0
    //   224: getfield 143	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   227: iconst_0
    //   228: putfield 795	com/tencent/mobileqq/app/QQAppInterface:isClearTaskBySystem	Z
    //   231: aload_0
    //   232: invokespecial 797	com/tencent/mobileqq/activity/SplashActivity:setSwitch	()V
    //   235: aload_0
    //   236: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   239: astore_3
    //   240: aload_3
    //   241: invokevirtual 341	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   244: ifnull +78 -> 322
    //   247: aload_3
    //   248: invokevirtual 341	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   251: ldc 219
    //   253: invokevirtual 803	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   256: ifne +18 -> 274
    //   259: aload_3
    //   260: ldc_w 805
    //   263: iconst_0
    //   264: invokevirtual 314	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   267: ifeq +27 -> 294
    //   270: aload_1
    //   271: ifnonnull +23 -> 294
    //   274: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +12 -> 289
    //   280: ldc 36
    //   282: iconst_2
    //   283: ldc_w 807
    //   286: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_0
    //   290: iconst_0
    //   291: putfield 810	com/tencent/mobileqq/activity/SplashActivity:mCanLock	Z
    //   294: aload_0
    //   295: aload_0
    //   296: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   299: ldc_w 812
    //   302: invokevirtual 251	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   305: putfield 71	com/tencent/mobileqq/activity/SplashActivity:mJumpShecme	Ljava/lang/String;
    //   308: aload_0
    //   309: aload_0
    //   310: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   313: ldc_w 814
    //   316: invokevirtual 251	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   319: putfield 73	com/tencent/mobileqq/activity/SplashActivity:mPkg	Ljava/lang/String;
    //   322: aload_3
    //   323: invokevirtual 341	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   326: ifnull +161 -> 487
    //   329: aload_3
    //   330: invokevirtual 341	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   333: ldc_w 816
    //   336: invokevirtual 803	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   339: ifeq +148 -> 487
    //   342: new 110	java/lang/StringBuilder
    //   345: dup
    //   346: ldc_w 818
    //   349: invokespecial 819	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: astore_1
    //   353: aload_1
    //   354: aload_3
    //   355: invokevirtual 785	android/content/Intent:getAction	()Ljava/lang/String;
    //   358: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_1
    //   363: ldc_w 821
    //   366: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_1
    //   371: aload_3
    //   372: invokevirtual 824	android/content/Intent:getDataString	()Ljava/lang/String;
    //   375: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_1
    //   380: ldc_w 826
    //   383: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_3
    //   388: invokevirtual 341	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   391: invokevirtual 830	android/os/Bundle:keySet	()Ljava/util/Set;
    //   394: invokeinterface 836 1 0
    //   399: astore 4
    //   401: aload 4
    //   403: invokeinterface 841 1 0
    //   408: ifeq +69 -> 477
    //   411: aload 4
    //   413: invokeinterface 844 1 0
    //   418: checkcast 368	java/lang/String
    //   421: astore 5
    //   423: aload 5
    //   425: ldc_w 308
    //   428: invokevirtual 847	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   431: ifeq +6 -> 437
    //   434: goto -33 -> 401
    //   437: aload_1
    //   438: aload 5
    //   440: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_1
    //   445: ldc_w 849
    //   448: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_1
    //   453: aload_3
    //   454: invokevirtual 341	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   457: aload 5
    //   459: invokevirtual 852	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   462: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload_1
    //   467: ldc_w 854
    //   470: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: goto -73 -> 401
    //   477: ldc 36
    //   479: iconst_1
    //   480: aload_1
    //   481: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 380	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: aload_0
    //   488: aload_0
    //   489: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   492: invokespecial 856	com/tencent/mobileqq/activity/SplashActivity:tryOpenAio	(Landroid/content/Intent;)Z
    //   495: ifne +316 -> 811
    //   498: aload_0
    //   499: aload_0
    //   500: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   503: invokespecial 858	com/tencent/mobileqq/activity/SplashActivity:tryOpenNowTab	(Landroid/content/Intent;)Z
    //   506: ifne +305 -> 811
    //   509: aload_0
    //   510: aload_0
    //   511: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   514: invokespecial 860	com/tencent/mobileqq/activity/SplashActivity:tryOpenKandianTab	(Landroid/content/Intent;)Z
    //   517: ifne +294 -> 811
    //   520: aload_0
    //   521: aload_0
    //   522: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   525: invokespecial 862	com/tencent/mobileqq/activity/SplashActivity:tryOpenQzoneTab	(Landroid/content/Intent;)Z
    //   528: ifne +283 -> 811
    //   531: aload_0
    //   532: aload_0
    //   533: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   536: invokespecial 864	com/tencent/mobileqq/activity/SplashActivity:tryOpenFlashShowTab	(Landroid/content/Intent;)Z
    //   539: ifeq +267 -> 806
    //   542: goto +269 -> 811
    //   545: iload_2
    //   546: ifne +35 -> 581
    //   549: aload_0
    //   550: invokevirtual 600	com/tencent/mobileqq/activity/SplashActivity:getSupportFragmentManager	()Landroidx/fragment/app/FragmentManager;
    //   553: astore_1
    //   554: iconst_1
    //   555: putstatic 619	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   558: aload_1
    //   559: invokevirtual 606	androidx/fragment/app/FragmentManager:beginTransaction	()Landroidx/fragment/app/FragmentTransaction;
    //   562: ldc_w 627
    //   565: invokestatic 622	com/tencent/mobileqq/activity/home/MainFragment:a	()Lcom/tencent/mobileqq/activity/home/MainFragment;
    //   568: ldc_w 608
    //   571: invokevirtual 613	java/lang/Class:getName	()Ljava/lang/String;
    //   574: invokevirtual 633	androidx/fragment/app/FragmentTransaction:add	(ILandroidx/fragment/app/Fragment;Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    //   577: invokevirtual 636	androidx/fragment/app/FragmentTransaction:commitAllowingStateLoss	()I
    //   580: pop
    //   581: invokestatic 870	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   584: new 872	com/tencent/mobileqq/activity/SplashActivity$1
    //   587: dup
    //   588: aload_0
    //   589: invokespecial 873	com/tencent/mobileqq/activity/SplashActivity$1:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   592: ldc2_w 874
    //   595: invokevirtual 881	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   598: pop
    //   599: aload_0
    //   600: aload_3
    //   601: invokespecial 883	com/tencent/mobileqq/activity/SplashActivity:handleStoryIntent	(Landroid/content/Intent;)Z
    //   604: pop
    //   605: iconst_1
    //   606: putstatic 886	com/tencent/common/app/BaseApplicationImpl:appMainActivityHasLanuch	Z
    //   609: ldc_w 766
    //   612: aconst_null
    //   613: invokestatic 764	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: getstatic 891	com/tencent/widget/immersive/ImmersiveUtils:statusHeightCorrect	Z
    //   619: ifne +29 -> 648
    //   622: aload_0
    //   623: invokevirtual 894	com/tencent/mobileqq/activity/SplashActivity:isInMultiWindow	()Z
    //   626: ifne +22 -> 648
    //   629: aload_0
    //   630: invokevirtual 898	com/tencent/mobileqq/activity/SplashActivity:getWindow	()Landroid/view/Window;
    //   633: invokevirtual 904	android/view/Window:getDecorView	()Landroid/view/View;
    //   636: new 906	com/tencent/mobileqq/activity/SplashActivity$2
    //   639: dup
    //   640: aload_0
    //   641: invokespecial 907	com/tencent/mobileqq/activity/SplashActivity$2:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   644: invokevirtual 913	android/view/View:post	(Ljava/lang/Runnable;)Z
    //   647: pop
    //   648: invokestatic 917	com/tencent/mobileqq/activity/SplashActivity:getActivityRoutes	()Ljava/util/ArrayList;
    //   651: astore_1
    //   652: getstatic 619	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   655: iconst_1
    //   656: if_icmpne +43 -> 699
    //   659: aload_0
    //   660: invokevirtual 920	com/tencent/mobileqq/activity/SplashActivity:getCurrentTab	()I
    //   663: getstatic 924	com/tencent/mobileqq/activity/home/impl/FrameControllerUtil:a	I
    //   666: if_icmpne +33 -> 699
    //   669: aload_1
    //   670: invokevirtual 929	java/util/ArrayList:size	()I
    //   673: iconst_2
    //   674: if_icmpgt +25 -> 699
    //   677: aload_1
    //   678: invokevirtual 929	java/util/ArrayList:size	()I
    //   681: iconst_2
    //   682: if_icmpne +21 -> 703
    //   685: ldc_w 931
    //   688: aload_1
    //   689: iconst_0
    //   690: invokevirtual 934	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   693: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   696: ifne +7 -> 703
    //   699: iconst_0
    //   700: putstatic 936	com/tencent/mobileqq/activity/SplashActivity:sIsNormalRouteEnter	Z
    //   703: getstatic 619	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   706: iconst_1
    //   707: if_icmpne +36 -> 743
    //   710: ldc_w 938
    //   713: invokestatic 208	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   716: checkcast 938	com/tencent/mobileqq/qassistant/api/IVoiceAssistantMain
    //   719: aload_3
    //   720: invokeinterface 942 2 0
    //   725: astore_1
    //   726: aload_1
    //   727: ifnull +16 -> 743
    //   730: aload_1
    //   731: aload_0
    //   732: getfield 143	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   735: aload_0
    //   736: invokevirtual 946	com/tencent/mobileqq/activity/SplashActivity:getActivity	()Landroid/app/Activity;
    //   739: invokevirtual 951	com/tencent/mobileqq/qassistant/config/QAssistantConfigItem:a	(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)Z
    //   742: pop
    //   743: invokestatic 956	com/tencent/mobileqq/pushnotice/ThirdPushNotifyManager:a	()Lcom/tencent/mobileqq/pushnotice/ThirdPushNotifyManager;
    //   746: aload_0
    //   747: getfield 143	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   750: aload_0
    //   751: invokevirtual 959	com/tencent/mobileqq/pushnotice/ThirdPushNotifyManager:a	(Lmqq/app/AppRuntime;Landroid/content/Context;)V
    //   754: invokestatic 963	com/tencent/mobileqq/alpha/DCLBridge:a	()V
    //   757: iconst_1
    //   758: ireturn
    //   759: aload_0
    //   760: invokevirtual 138	com/tencent/mobileqq/activity/SplashActivity:finish	()V
    //   763: ldc_w 766
    //   766: aconst_null
    //   767: invokestatic 764	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   770: ldc_w 760
    //   773: aconst_null
    //   774: invokestatic 764	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   777: iconst_0
    //   778: ireturn
    //   779: astore_1
    //   780: ldc 36
    //   782: iconst_2
    //   783: aload_1
    //   784: iconst_0
    //   785: anewarray 350	java/lang/Object
    //   788: invokestatic 354	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   791: iconst_1
    //   792: ireturn
    //   793: astore_3
    //   794: goto -729 -> 65
    //   797: astore_1
    //   798: goto -476 -> 322
    //   801: iconst_0
    //   802: istore_2
    //   803: goto -779 -> 24
    //   806: iconst_0
    //   807: istore_2
    //   808: goto -263 -> 545
    //   811: iconst_1
    //   812: istore_2
    //   813: goto -268 -> 545
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	816	0	this	SplashActivity
    //   0	816	1	paramBundle	Bundle
    //   20	793	2	i	int
    //   39	681	3	localObject	Object
    //   793	1	3	localException	Exception
    //   399	13	4	localIterator	java.util.Iterator
    //   421	37	5	str	String
    // Exception table:
    //   from	to	target	type
    //   0	19	779	java/lang/Exception
    //   28	59	779	java/lang/Exception
    //   65	69	779	java/lang/Exception
    //   69	129	779	java/lang/Exception
    //   132	139	779	java/lang/Exception
    //   141	149	779	java/lang/Exception
    //   153	167	779	java/lang/Exception
    //   169	180	779	java/lang/Exception
    //   184	199	779	java/lang/Exception
    //   199	223	779	java/lang/Exception
    //   223	270	779	java/lang/Exception
    //   274	289	779	java/lang/Exception
    //   289	294	779	java/lang/Exception
    //   322	401	779	java/lang/Exception
    //   401	434	779	java/lang/Exception
    //   437	474	779	java/lang/Exception
    //   477	487	779	java/lang/Exception
    //   487	542	779	java/lang/Exception
    //   549	581	779	java/lang/Exception
    //   581	648	779	java/lang/Exception
    //   648	699	779	java/lang/Exception
    //   699	703	779	java/lang/Exception
    //   703	726	779	java/lang/Exception
    //   730	743	779	java/lang/Exception
    //   743	757	779	java/lang/Exception
    //   759	777	779	java/lang/Exception
    //   59	65	793	java/lang/Exception
    //   294	322	797	java/lang/Exception
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnDestroy");
    }
    BroadcastReceiver localBroadcastReceiver = this.br;
    if (localBroadcastReceiver != null)
    {
      try
      {
        unregisterReceiver(localBroadcastReceiver);
      }
      catch (Throwable localThrowable)
      {
        QLog.d("SplashActivity", 1, "", localThrowable);
      }
      this.br = null;
    }
    if (QQPlayerService.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SplashActivity", 2, "QQPlayerService stopPlayMusic");
      }
      QQPlayerService.e(getApplicationContext());
    }
    onSystemScreenSettingChanged();
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
      if ((localFragment != null) && (localFragment.isVisible()))
      {
        ((ChatFragment)localFragment).i();
        return true;
      }
      localObject = (MainFragment)((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      if (localObject != null) {
        return ((MainFragment)localObject).a(paramInt, paramKeyEvent);
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
      Object localObject = paramIntent.getAction();
      if ((localObject != null) && ("QQ_ACTION_MENU_QUIT".equals(localObject)))
      {
        finish();
        return;
      }
      localObject = paramIntent.getExtras();
      if (paramIntent.getIntExtra("fromCmGame", 0) == 1) {
        overridePendingTransition(0, 0);
      }
      int i = getIntent().getIntExtra("uintype", -1);
      if (i == 10005)
      {
        getIntent().removeExtra("uintype");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("wtf 10005 aio");
        localStringBuilder.append(paramIntent);
        QLog.e("SplashActivity", 1, localStringBuilder.toString());
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
          paramIntent = ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).readItemFromIntent(paramIntent);
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
          paramIntent = ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).readItemFromIntent(paramIntent);
          if (paramIntent != null)
          {
            paramIntent.a(this.app, getActivity());
            return;
          }
        }
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e("SplashActivity", 2, paramIntent, new Object[0]);
    }
    return;
  }
  
  protected void doOnPause()
  {
    if (isInMultiWindow())
    {
      Object localObject = getSupportFragmentManager();
      Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment != null) && (localFragment.isVisible()))
      {
        ((ChatFragment)localFragment).p();
        return;
      }
      localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      if (localObject != null)
      {
        ((MainFragment)localObject).n();
        super.doOnPause();
      }
      return;
    }
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  /* Error */
  protected void doOnResume()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1069	com/tencent/mobileqq/app/BaseActivity:doOnResume	()V
    //   4: invokestatic 1072	com/tencent/image/AbstractVideoImage:resumeAll	()V
    //   7: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +12 -> 22
    //   13: ldc 36
    //   15: iconst_2
    //   16: ldc_w 1073
    //   19: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: invokespecial 1075	com/tencent/mobileqq/activity/SplashActivity:checkGesture	()V
    //   26: aload_0
    //   27: invokevirtual 898	com/tencent/mobileqq/activity/SplashActivity:getWindow	()Landroid/view/Window;
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 1079	android/view/Window:getAttributes	()Landroid/view/WindowManager$LayoutParams;
    //   35: getfield 1084	android/view/WindowManager$LayoutParams:flags	I
    //   38: sipush 1024
    //   41: iand
    //   42: ifeq +10 -> 52
    //   45: aload_3
    //   46: sipush 1024
    //   49: invokevirtual 1087	android/view/Window:clearFlags	(I)V
    //   52: aload_0
    //   53: getfield 143	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: invokevirtual 1090	com/tencent/mobileqq/app/QQAppInterface:getKickIntent	()Landroid/content/Intent;
    //   59: astore_3
    //   60: iconst_1
    //   61: istore_1
    //   62: iconst_1
    //   63: istore_2
    //   64: aload_3
    //   65: ifnull +24 -> 89
    //   68: ldc 36
    //   70: iconst_1
    //   71: ldc_w 1092
    //   74: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 143	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   82: invokevirtual 1090	com/tencent/mobileqq/app/QQAppInterface:getKickIntent	()Landroid/content/Intent;
    //   85: invokevirtual 281	com/tencent/mobileqq/activity/SplashActivity:startActivity	(Landroid/content/Intent;)V
    //   88: return
    //   89: aload_0
    //   90: aload_0
    //   91: invokevirtual 325	com/tencent/mobileqq/activity/SplashActivity:getIntent	()Landroid/content/Intent;
    //   94: invokespecial 1094	com/tencent/mobileqq/activity/SplashActivity:handleIntentFromQc	(Landroid/content/Intent;)V
    //   97: aload_0
    //   98: getfield 143	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   101: invokevirtual 1097	com/tencent/mobileqq/app/QQAppInterface:getDevLockIntent	()Landroid/content/Intent;
    //   104: astore 4
    //   106: aload 4
    //   108: ifnull +606 -> 714
    //   111: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +12 -> 126
    //   117: ldc 36
    //   119: iconst_2
    //   120: ldc_w 1099
    //   123: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: new 926	java/util/ArrayList
    //   129: dup
    //   130: invokespecial 1100	java/util/ArrayList:<init>	()V
    //   133: astore 8
    //   135: aload 4
    //   137: ldc_w 1102
    //   140: invokevirtual 251	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore_3
    //   144: iload_1
    //   145: istore_2
    //   146: aload 4
    //   148: ldc_w 1104
    //   151: iconst_1
    //   152: invokevirtual 314	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   155: istore_1
    //   156: iload_1
    //   157: istore_2
    //   158: aload 4
    //   160: ldc_w 1106
    //   163: invokevirtual 251	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   166: astore 6
    //   168: aload 4
    //   170: ldc_w 1108
    //   173: invokevirtual 251	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore 7
    //   178: aload 4
    //   180: ldc_w 1110
    //   183: invokevirtual 251	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 5
    //   188: aload 4
    //   190: ldc_w 1112
    //   193: invokevirtual 1116	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   196: astore 4
    //   198: goto +59 -> 257
    //   201: ldc 81
    //   203: astore 5
    //   205: aload 8
    //   207: astore 4
    //   209: goto +48 -> 257
    //   212: ldc 81
    //   214: astore 5
    //   216: aload_3
    //   217: astore 4
    //   219: aload 5
    //   221: astore_3
    //   222: goto +22 -> 244
    //   225: aload_3
    //   226: astore 4
    //   228: goto +7 -> 235
    //   231: ldc 81
    //   233: astore 4
    //   235: ldc 81
    //   237: astore 6
    //   239: ldc 81
    //   241: astore_3
    //   242: iload_2
    //   243: istore_1
    //   244: aload_3
    //   245: astore 5
    //   247: aload_3
    //   248: astore 7
    //   250: aload 4
    //   252: astore_3
    //   253: aload 8
    //   255: astore 4
    //   257: new 221	android/content/Intent
    //   260: dup
    //   261: aload_0
    //   262: ldc_w 1118
    //   265: invokespecial 256	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   268: astore 8
    //   270: aload 8
    //   272: ldc_w 1104
    //   275: iload_1
    //   276: invokevirtual 317	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   279: pop
    //   280: aload 8
    //   282: ldc_w 1102
    //   285: aload_3
    //   286: invokevirtual 278	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   289: pop
    //   290: aload 8
    //   292: ldc_w 1106
    //   295: aload 6
    //   297: invokevirtual 278	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   300: pop
    //   301: aload 8
    //   303: ldc_w 1108
    //   306: aload 7
    //   308: invokevirtual 278	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   311: pop
    //   312: aload 8
    //   314: ldc_w 1110
    //   317: aload 5
    //   319: invokevirtual 278	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   322: pop
    //   323: aload 8
    //   325: ldc_w 1112
    //   328: aload 4
    //   330: invokevirtual 1122	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   333: pop
    //   334: aload_0
    //   335: aload 8
    //   337: invokevirtual 281	com/tencent/mobileqq/activity/SplashActivity:startActivity	(Landroid/content/Intent;)V
    //   340: goto +3 -> 343
    //   343: aload_0
    //   344: getfield 143	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: invokevirtual 1125	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   350: ifeq +370 -> 720
    //   353: aload_0
    //   354: getfield 143	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   357: invokevirtual 1128	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   360: invokestatic 437	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   363: invokevirtual 1131	com/tencent/common/app/BaseApplicationImpl:getPCActiveUin	()Ljava/lang/String;
    //   366: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   369: ifeq +351 -> 720
    //   372: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: istore_1
    //   376: iload_1
    //   377: ifeq +340 -> 717
    //   380: ldc 36
    //   382: iconst_2
    //   383: ldc_w 1099
    //   386: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: goto +3 -> 392
    //   392: ldc 36
    //   394: astore_3
    //   395: aload_0
    //   396: invokevirtual 1134	com/tencent/mobileqq/activity/SplashActivity:isResume	()Z
    //   399: ifne +4 -> 403
    //   402: return
    //   403: invokestatic 437	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   406: invokevirtual 1137	com/tencent/common/app/BaseApplicationImpl:getPCActiveNoticeIntent	()Landroid/content/Intent;
    //   409: astore 4
    //   411: aload 4
    //   413: ifnonnull +20 -> 433
    //   416: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +58 -> 477
    //   422: aload_3
    //   423: iconst_2
    //   424: ldc_w 1139
    //   427: invokestatic 380	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: goto +47 -> 477
    //   433: getstatic 1144	com/tencent/mobileqq/activity/NotifyPCActiveActivity:a	Lcom/tencent/mobileqq/activity/NotifyPCActiveActivity;
    //   436: ifnonnull +41 -> 477
    //   439: getstatic 1148	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   442: instanceof 2
    //   445: ifeq +32 -> 477
    //   448: aload_0
    //   449: aload 4
    //   451: invokevirtual 281	com/tencent/mobileqq/activity/SplashActivity:startActivity	(Landroid/content/Intent;)V
    //   454: goto +23 -> 477
    //   457: astore 4
    //   459: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +15 -> 477
    //   465: aload_3
    //   466: iconst_2
    //   467: ldc 81
    //   469: aload 4
    //   471: invokestatic 1150	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   474: goto +3 -> 477
    //   477: aconst_null
    //   478: ldc_w 1152
    //   481: invokestatic 764	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: aload_0
    //   485: getfield 143	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   488: invokevirtual 1128	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   491: invokestatic 366	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   494: ifne +37 -> 531
    //   497: ldc_w 1154
    //   500: aload_0
    //   501: getfield 143	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   504: invokevirtual 1128	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   507: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   510: ifne +21 -> 531
    //   513: invokestatic 870	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   516: new 1156	com/tencent/mobileqq/activity/SplashActivity$3
    //   519: dup
    //   520: aload_0
    //   521: invokespecial 1157	com/tencent/mobileqq/activity/SplashActivity$3:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   524: ldc2_w 12
    //   527: invokevirtual 881	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   530: pop
    //   531: invokestatic 870	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   534: new 1159	com/tencent/mobileqq/activity/SplashActivity$4
    //   537: dup
    //   538: aload_0
    //   539: invokespecial 1160	com/tencent/mobileqq/activity/SplashActivity$4:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   542: ldc2_w 12
    //   545: invokevirtual 881	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   548: pop
    //   549: ldc_w 1152
    //   552: aconst_null
    //   553: invokestatic 764	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: invokestatic 870	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   559: new 1162	com/tencent/mobileqq/activity/SplashActivity$5
    //   562: dup
    //   563: aload_0
    //   564: invokespecial 1163	com/tencent/mobileqq/activity/SplashActivity$5:<init>	(Lcom/tencent/mobileqq/activity/SplashActivity;)V
    //   567: ldc2_w 12
    //   570: invokevirtual 881	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   573: pop
    //   574: aload_0
    //   575: invokevirtual 894	com/tencent/mobileqq/activity/SplashActivity:isInMultiWindow	()Z
    //   578: ifeq +71 -> 649
    //   581: aload_0
    //   582: invokevirtual 600	com/tencent/mobileqq/activity/SplashActivity:getSupportFragmentManager	()Landroidx/fragment/app/FragmentManager;
    //   585: astore 4
    //   587: aload 4
    //   589: ldc_w 680
    //   592: invokevirtual 613	java/lang/Class:getName	()Ljava/lang/String;
    //   595: invokevirtual 617	androidx/fragment/app/FragmentManager:findFragmentByTag	(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    //   598: astore_3
    //   599: aload_3
    //   600: ifnull +26 -> 626
    //   603: aload_3
    //   604: invokevirtual 687	androidx/fragment/app/Fragment:isVisible	()Z
    //   607: ifeq +19 -> 626
    //   610: aload_3
    //   611: checkcast 680	com/tencent/mobileqq/activity/ChatFragment
    //   614: astore 4
    //   616: aload_3
    //   617: checkcast 680	com/tencent/mobileqq/activity/ChatFragment
    //   620: invokevirtual 1055	com/tencent/mobileqq/activity/ChatFragment:p	()V
    //   623: goto +26 -> 649
    //   626: aload 4
    //   628: ldc_w 608
    //   631: invokevirtual 613	java/lang/Class:getName	()Ljava/lang/String;
    //   634: invokevirtual 617	androidx/fragment/app/FragmentManager:findFragmentByTag	(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    //   637: astore_3
    //   638: aload_3
    //   639: ifnull +10 -> 649
    //   642: aload_3
    //   643: checkcast 608	com/tencent/mobileqq/activity/home/MainFragment
    //   646: invokevirtual 1056	com/tencent/mobileqq/activity/home/MainFragment:n	()V
    //   649: invokestatic 1167	com/tencent/qqperf/monitor/crash/safemode/SafeModeUtil:d	()V
    //   652: return
    //   653: ldc 36
    //   655: astore 4
    //   657: astore_3
    //   658: goto +16 -> 674
    //   661: astore_3
    //   662: ldc 36
    //   664: astore 4
    //   666: goto +8 -> 674
    //   669: astore_3
    //   670: ldc 36
    //   672: astore 4
    //   674: aload 4
    //   676: iconst_2
    //   677: aload_3
    //   678: iconst_0
    //   679: anewarray 350	java/lang/Object
    //   682: invokestatic 354	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   685: return
    //   686: astore_3
    //   687: goto -456 -> 231
    //   690: astore 4
    //   692: goto -467 -> 225
    //   695: astore 4
    //   697: goto -485 -> 212
    //   700: astore 4
    //   702: goto -501 -> 201
    //   705: astore 4
    //   707: aload 8
    //   709: astore 4
    //   711: goto -454 -> 257
    //   714: goto -371 -> 343
    //   717: goto -325 -> 392
    //   720: goto -243 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	this	SplashActivity
    //   61	316	1	bool1	boolean
    //   63	180	2	bool2	boolean
    //   30	613	3	localObject1	Object
    //   657	1	3	localException1	Exception
    //   661	1	3	localException2	Exception
    //   669	9	3	localException3	Exception
    //   686	1	3	localException4	Exception
    //   104	346	4	localObject2	Object
    //   457	13	4	localThrowable	Throwable
    //   585	90	4	localObject3	Object
    //   690	1	4	localException5	Exception
    //   695	1	4	localException6	Exception
    //   700	1	4	localException7	Exception
    //   705	1	4	localException8	Exception
    //   709	1	4	localObject4	Object
    //   186	132	5	localObject5	Object
    //   166	130	6	str	String
    //   176	131	7	localObject6	Object
    //   133	575	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   433	454	457	java/lang/Throwable
    //   380	389	653	java/lang/Exception
    //   395	402	653	java/lang/Exception
    //   403	411	653	java/lang/Exception
    //   416	430	653	java/lang/Exception
    //   433	454	653	java/lang/Exception
    //   459	474	653	java/lang/Exception
    //   477	531	653	java/lang/Exception
    //   531	599	653	java/lang/Exception
    //   603	623	653	java/lang/Exception
    //   626	638	653	java/lang/Exception
    //   642	649	653	java/lang/Exception
    //   649	652	653	java/lang/Exception
    //   257	340	661	java/lang/Exception
    //   343	376	661	java/lang/Exception
    //   0	22	669	java/lang/Exception
    //   22	52	669	java/lang/Exception
    //   52	60	669	java/lang/Exception
    //   68	88	669	java/lang/Exception
    //   89	106	669	java/lang/Exception
    //   111	126	669	java/lang/Exception
    //   126	135	669	java/lang/Exception
    //   135	144	686	java/lang/Exception
    //   146	156	690	java/lang/Exception
    //   158	168	690	java/lang/Exception
    //   168	178	695	java/lang/Exception
    //   178	188	700	java/lang/Exception
    //   188	198	705	java/lang/Exception
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "doOnStart");
    }
    Object localObject = this.mJumpShecme;
    if ((localObject != null) && (((String)localObject).length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.mPkg)))
    {
      localObject = JumpParser.a(this.app, this, this.mJumpShecme);
      ((JumpAction)localObject).d(this.mPkg);
      ((JumpAction)localObject).a();
      this.mJumpShecme = null;
      this.mPkg = null;
    }
  }
  
  protected void doOnStop()
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SplashActivity");
    String str;
    if (currentFragment == 1) {
      str = "_MainFragment";
    } else {
      str = "_ChatFragment";
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public String getCIOPageName()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (currentFragment == 1) {
      localObject = MainFragment.class.getName();
    } else {
      localObject = ChatFragment.class.getName();
    }
    Object localObject = localFragmentManager.findFragmentByTag((String)localObject);
    if (localObject != null) {
      return ((QBaseFragment)localObject).getCIOPageName();
    }
    return super.getCIOPageName();
  }
  
  public ClassLoader getClassLoader()
  {
    Object localObject = super.getClassLoader();
    ClassLoader localClassLoader2 = this.mClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.mClassLoader = localClassLoader1;
      localObject = localClassLoader1;
    }
    return localObject;
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
      return ((MainFragment)localFragment).w();
    }
    return 0;
  }
  
  public String getPreProcess()
  {
    return "com.tencent.mobileqq:peak";
  }
  
  public void handleNativeIntentByPullActivePush(Intent paramIntent)
  {
    int i = 0;
    int j = paramIntent.getIntExtra("extra_pull_active_push_type", 0);
    if (j == 0) {
      return;
    }
    if (j == 2)
    {
      String str = paramIntent.getStringExtra("extra_pull_active_push_url");
      paramIntent = new Intent(this.app.getApp(), QQBrowserActivity.class);
      paramIntent.putExtra("url", str);
    }
    else
    {
      if (j == 1)
      {
        j = paramIntent.getIntExtra("extra_pull_active_push_subtype", 0);
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j == 5) {
                  HotChatManager.a(this, false);
                }
              }
              else
              {
                paramIntent = new Intent();
                paramIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
                i = 1;
                break label200;
              }
            }
            else
            {
              paramIntent = new Intent(this.app.getApp(), ActivateFriendActivity.class);
              paramIntent.putExtra("af_key_from", 4);
              break label200;
            }
          }
          else {
            new JumpActionLegacy(this.app, this).k();
          }
        }
        else {
          new JumpActionLegacy(this.app, this).bY_();
        }
      }
      paramIntent = null;
    }
    label200:
    if (paramIntent != null) {
      if (i != 0) {
        RouteUtils.a(this, paramIntent, "/nearby/activity");
      } else {
        startActivity(paramIntent);
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
  }
  
  public boolean isNeedInterruptDoMulitWindow()
  {
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needFinish()
  {
    if ((this.app != null) && (this.app.isExitTaskUnfinished))
    {
      QLog.d("SplashActivity", 1, "LastExitTaskUnfinished finish");
      return true;
    }
    if (((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).finishNotifyActivityByKicked(this)) {
      return false;
    }
    if (UserguideActivity.a(this))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SplashActivity", 2, "showUserGuide");
      }
      return true;
    }
    if ((this.app != null) && ((this.app.isLogin()) || (this.app.getKickIntent() != null))) {
      return false;
    }
    Object localObject = getSharedPreferences("UserGuide", 0);
    String str1 = ((SharedPreferences)localObject).getString("qq_version", "");
    String str2 = ((SharedPreferences)localObject).getString("qq_version_full", "");
    String str3 = AppSetting.b();
    localObject = ((SharedPreferences)localObject).edit();
    if (!TextUtils.equals(str1, "5770")) {
      ((SharedPreferences.Editor)localObject).putString("qq_version_pre", str1);
    }
    if (!TextUtils.equals(str2, str3)) {
      ((SharedPreferences.Editor)localObject).putString("qq_version_full_pre", str2);
    }
    ((SharedPreferences.Editor)localObject).putString("qq_version", "5770");
    ((SharedPreferences.Editor)localObject).putString("qq_version_full", str3);
    ((SharedPreferences.Editor)localObject).commit();
    if (QLog.isColorLevel()) {
      QLog.e("SplashActivity", 2, String.format("update version pre[%s, %s], cur[%s, %s]", new Object[] { str1, str2, "5770", str3 }));
    }
    RouteUtils.a(this, new Intent(), "/base/login");
    return true;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).e();
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).h();
    }
    AIOConfigManager.a(this.app);
    ThirdPushManager.a().c();
    SplashADUtil.a(BaseApplicationImpl.getContext(), this.app.getLongAccountUin());
  }
  
  protected void onAccoutChangeFailed()
  {
    super.onAccoutChangeFailed();
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).f();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (FrameHelperActivity.aq != null)
    {
      DrawerFrame localDrawerFrame = (DrawerFrame)FrameHelperActivity.aq.get();
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
      return localChatFragment.b(paramInt);
    }
    return null;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((sWeakInstance != null) && (sWeakInstance.get() == this)) {
      sWeakInstance = null;
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
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
      ((MainFragment)localObject).onMultiWindowModeChanged(paramBoolean);
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).k();
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).n();
    }
    if (!"1000".equals(ThemeUtil.getCurrentThemeId()))
    {
      if (getAppInterface() != null) {
        BannerManager.a().a(ThemeOverdueBannerProcessor.a, 0, null);
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
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle != null) {
      paramBundle.remove("android:support:fragments");
    }
  }
  
  public void openAIO(boolean paramBoolean, int paramInt)
  {
    AIOPreLoadEngine.a().c();
    ThreadRegulator.a().a(1);
    sOpenAIOCode = HardCoderManager.getInstance().start(0, 1, 0, 0, 2000, 301, 4L, Process.myTid(), "openAIO");
    SceneTracker.a().a("ChatFragment", true);
    StartupTrackerForAio.a(null, "AIO_Start_cost");
    if (!AIOUtils.a(this, this.app, paramBoolean, getIntent()))
    {
      if (highFrequencyOpenSameAio()) {
        return;
      }
      long l = SystemClock.uptimeMillis();
      if (l - this.mLastOpenAioTime < OPEN_AIO_MIN_INTERVAL_TIME) {
        return;
      }
      this.mLastOpenAioTime = l;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("|openAIO|");
        ((StringBuilder)localObject1).append(getIntent().getIntExtra("uintype", -1));
        QLog.e("SplashActivity", 2, ((StringBuilder)localObject1).toString());
      }
      paramBoolean = getIntent().getBooleanExtra("open_chatfragment_withanim", false);
      Object localObject3 = getSupportFragmentManager();
      Object localObject1 = ((FragmentManager)localObject3).beginTransaction();
      Object localObject2 = ((FragmentManager)localObject3).findFragmentByTag(ChatFragment.class.getName());
      localObject3 = ((FragmentManager)localObject3).findFragmentByTag(MainFragment.class.getName());
      Object localObject4;
      if (localObject3 != null)
      {
        localObject4 = (MainFragment)localObject3;
        ((MainFragment)localObject4).x();
        if ((getIntent().getIntExtra("uintype", -1) != 10014) && (((MainFragment)localObject4).w() != FrameControllerUtil.a)) {
          ((MainFragment)localObject4).a(FrameControllerUtil.a);
        }
      }
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SplashActivity", 2, "openAIO f != null ");
        }
        localObject4 = (ChatFragment)localObject2;
        ((ChatFragment)localObject4).l();
        currentFragment = 2;
        if (((ChatFragment)localObject4).h == null)
        {
          QLog.w("SplashActivity", 1, "ChatFragment state error, trying to recreate it.");
          localObject4 = ChatFragment.a();
          ((FragmentTransaction)localObject1).remove((Fragment)localObject2);
          ((FragmentTransaction)localObject1).add(16908290, (Fragment)localObject4, ChatFragment.class.getName());
          if (localObject3 != null) {
            ((FragmentTransaction)localObject1).hide((Fragment)localObject3);
          }
          ((FragmentTransaction)localObject1).commitAllowingStateLoss();
        }
        else if (!((Fragment)localObject2).isVisible())
        {
          localObject4 = getIntent().getExtras();
          if (localObject4 != null)
          {
            localObject4 = ((Bundle)localObject4).getBundle("guild_extra");
            if (localObject4 != null)
            {
              paramInt = ((Bundle)localObject4).getInt("open_chat_fragment_anim_type", 0);
              break label423;
            }
          }
          paramInt = 0;
          label423:
          if ((paramBoolean) && (ProcessStats.b() > 1)) {
            if (paramInt == 1) {
              ((FragmentTransaction)localObject1).setCustomAnimations(2130772104, 2130772007);
            } else if (paramInt == 2) {
              ((FragmentTransaction)localObject1).setCustomAnimations(2130772104, 2130772135);
            } else {
              ((FragmentTransaction)localObject1).setCustomAnimations(2130772104, 2130772114);
            }
          }
          ((FragmentTransaction)localObject1).show((Fragment)localObject2);
          if (localObject3 != null) {
            ((FragmentTransaction)localObject1).hide((Fragment)localObject3);
          }
          ((FragmentTransaction)localObject1).commitAllowingStateLoss();
        }
      }
      else
      {
        if (Math.abs(SystemClock.uptimeMillis() - this.firtCreateAIOTime) < 1000L)
        {
          if (QLog.isColorLevel()) {
            QLog.i("SplashActivity", 2, "openAIO hasOpenedAIO true, renturn ");
          }
          return;
        }
        this.firtCreateAIOTime = SystemClock.uptimeMillis();
        if ((paramBoolean) && (ProcessStats.b() > 1)) {
          ((FragmentTransaction)localObject1).setCustomAnimations(2130772104, 2130772114);
        }
        localObject2 = ChatFragment.a();
        currentFragment = 2;
        ((FragmentTransaction)localObject1).add(16908290, (Fragment)localObject2, ChatFragment.class.getName());
        if (localObject3 != null) {
          ((FragmentTransaction)localObject1).hide((Fragment)localObject3);
        }
        ((FragmentTransaction)localObject1).commitAllowingStateLoss();
        AIOPreLoadEngine.a().c();
        if (QLog.isColorLevel()) {
          QLog.i("SplashActivity", 2, "openAIO f == null ");
        }
      }
      if (getIntent().getBooleanExtra("activepull_push_flag", false)) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006593", "0X8006593", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
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
    if (currentFragment != 1)
    {
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      localObject = (ChatFragment)((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      try
      {
        if (paramIntent.getBooleanExtra("switch_anim", false)) {
          localFragmentTransaction.setCustomAnimations(2130772113, 2130772105);
        }
      }
      catch (Exception localException)
      {
        QLog.e("SplashActivity", 2, localException, new Object[0]);
      }
      currentFragment = 1;
      localFragmentTransaction.show(localMainFragment);
      if (localObject != null) {
        localFragmentTransaction.hide((Fragment)localObject);
      }
      localFragmentTransaction.commitAllowingStateLoss();
    }
    localMainFragment.a(paramIntent);
  }
  
  public void preloadUi()
  {
    try
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(this);
      this.mPreloadMainViews = FrameFragment.a(localLayoutInflater);
      this.mPreloadConversationView = localLayoutInflater.inflate(2131624569, null);
      FPSSwipListView localFPSSwipListView = (FPSSwipListView)this.mPreloadConversationView.findViewById(2131444377);
      if (localFPSSwipListView != null)
      {
        this.mPreloadLocalSearchBar = localLayoutInflater.inflate(2131629216, localFPSSwipListView, false);
        return;
      }
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
      return ((MainFragment)localFragment).l();
    }
    return super.setLastActivityName();
  }
  
  public void showGifAnnimate()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).m();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity
 * JD-Core Version:    0.7.0.1
 */