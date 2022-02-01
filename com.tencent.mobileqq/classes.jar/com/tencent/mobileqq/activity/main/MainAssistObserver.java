package com.tencent.mobileqq.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.ForwardMiniAppThirdPartyHelper;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.handler.GetOpenID;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.push.api.RIJTabObserverCallBack;
import com.tencent.mobileqq.nearby.api.INearbyNewRedDotManager;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.observer.VipGifObserver;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.api.ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class MainAssistObserver
{
  public final int a;
  protected Bundle a;
  Handler jdField_a_of_type_AndroidOsHandler = new MainAssistObserver.18(this, Looper.getMainLooper());
  protected OpenIdObserver a;
  public SplashActivity a;
  public LebaTabRedTouch a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new MainAssistObserver.20(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new MainAssistObserver.11(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new MainAssistObserver.3(this);
  private MsgTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = new MainAssistObserver.8(this);
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new MainAssistObserver.6(this);
  private final RIJTabObserverCallBack jdField_a_of_type_ComTencentMobileqqKandianRepoPushApiRIJTabObserverCallBack = new MainAssistObserver.5(this);
  private INewFriendListener jdField_a_of_type_ComTencentMobileqqNewfriendInterfacesINewFriendListener = new MainAssistObserver.9(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new MainAssistObserver.7(this);
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new MainAssistObserver.19(this);
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new MainAssistObserver.4(this);
  private VipGifObserver jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver = new MainAssistObserver.1(this);
  private QCircleObserver jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver = new MainAssistObserver.13(this);
  private ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new MainAssistObserver.12(this);
  RedpointObserver jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver = new MainAssistObserver.25(this);
  private ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener jdField_a_of_type_ComTencentMobileqqTroopApiITroopNotificationService$INewTroopNotificationUnreadCountOrConfigChangedListener = new MainAssistObserver.10(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  protected QQProgressDialog a;
  protected String a;
  ConcurrentLinkedQueue<Runnable> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public volatile boolean a;
  public final int b;
  protected Bundle b;
  protected Handler b;
  protected QQCustomDialog b;
  protected String b;
  protected boolean b;
  public final int c;
  protected QQCustomDialog c;
  protected String c;
  protected boolean c;
  public boolean d = false;
  
  public MainAssistObserver(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new MainAssistObserver.23(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch = new LebaTabRedTouch(paramSplashActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private QQCustomDialog a(String paramString)
  {
    return DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131690709), new MainAssistObserver.28(this));
  }
  
  private QQCustomDialog a(String paramString1, String paramString2)
  {
    paramString1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(paramString1).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131718867), new MainAssistObserver.30(this));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131718866));
    localStringBuilder.append(paramString2);
    return paramString1.setNegativeButton(localStringBuilder.toString(), new MainAssistObserver.29(this));
  }
  
  private void a(Bundle paramBundle)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("thridparty_prepare_av_game", false);
      localObject = paramBundle.getString("thridparty_av_game_type_key", "");
      long l1 = paramBundle.getLong("thridparty_av_game_room_id", 0L);
      long l2 = paramBundle.getLong("thridparty_av_game_share_uin", 0L);
      int i = paramBundle.getInt("avgame_create_game_type_key", 0);
      int j = paramBundle.getInt("avgame_from_type_key", 4);
      boolean bool = "thridparty_av_game_type_join_room".equals(localObject);
      if (bool)
      {
        paramBundle = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(IAvGameManager.class, "");
        if (paramBundle == null)
        {
          QLog.e("MainAssistObserver", 1, "AV_GAME_MANAGER NULL");
          return;
        }
        paramBundle.joinAvGameRoom(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 2, String.valueOf(l1), String.valueOf(l2));
        return;
      }
      if ("thridparty_av_game_type_create_room".equals(localObject))
      {
        paramBundle = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(IAvGameManager.class, "");
        if (paramBundle == null)
        {
          QLog.e("MainAssistObserver", 1, "AV_GAME_MANAGER NULL");
          return;
        }
        paramBundle.createAvGameRoom(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, j, null, i);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("realHandleThirdPartyPullUpAVGame error: ");
      ((StringBuilder)localObject).append(paramBundle.getMessage());
      QLog.e("MainAssistObserver", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramRunnable);
    l();
  }
  
  private void a(String paramString)
  {
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230).setTitle(null).setMessage(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131699409), new Object[] { paramString })).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131691084), new MainAssistObserver.27(this, paramString)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131690707), new MainAssistObserver.26(this)).show();
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("thridparty_prepare_mini_app", false);
    boolean bool1 = paramBundle.getBoolean("pull_show_open_id_diff_main", false);
    String str1 = paramBundle.getString("mini_app_id", "");
    String str2 = paramBundle.getString("mini_app_path", "");
    String str3 = paramBundle.getString("mini_app_type", "release");
    boolean bool2 = paramBundle.getBoolean("pull_mini_app_not_privilege", false);
    boolean bool3 = paramBundle.getBoolean("pull_mini_app_not_privilege_not_bind", false);
    String str4 = paramBundle.getString("pull_mini_app_not_privilege_not_bind_app_name", "");
    paramBundle = paramBundle.getString("pull_mini_app_not_privilege_string", "");
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver", 2, "showAccountConfirm: shouldShowOpenIdDifferent is true");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_show_open_id_diff_main");
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("is_change_account", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("if_check_account_same", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("key_action", ForwardMiniAppThirdPartyHelper.class.getSimpleName());
      i();
      return;
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_app_not_privilege");
      if (bool3)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_mini_app_not_privilege_not_bind");
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = a(paramBundle, str4);
      }
      else
      {
        this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = a(paramBundle);
      }
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    ForwardMiniAppThirdPartyHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, str1, str2, str3);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    int i = ((LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a();
    String str;
    if (i != 3) {
      if (i != 4) {
        if (i != 5) {
          str = null;
        }
      }
    }
    for (;;)
    {
      break;
      str = "0X80073B6";
      continue;
      str = "0X80073B2";
      continue;
      str = "0X80073B0";
    }
    if (str != null) {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
  }
  
  private void c(Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("pull_app_not_privilege", false);
    String str1 = paramBundle.getString("pull_app_not_privilege_string", "");
    boolean bool2 = paramBundle.getBoolean("pull_show_open_id_diff_main", false);
    paramBundle.getBoolean("pull_uin_not_exist", false);
    boolean bool3 = paramBundle.getBoolean("pull_add_friend_tip", false);
    String str2 = paramBundle.getString("uin", "");
    paramBundle.getString("openid", "");
    paramBundle.getString("appid", "");
    if (bool1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_app_not_privilege");
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = a(str1);
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("thridparty_pull_main");
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_show_open_id_diff_main");
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("is_change_account", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("if_check_account_same", true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().putExtra("key_action", ForwardIMByThirdPartyHelper.class.getSimpleName());
      i();
      return;
    }
    if (bool3)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getIntent().removeExtra("pull_add_friend_tip");
      a(str2);
    }
  }
  
  private void k()
  {
    SplashActivity localSplashActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localSplashActivity == null) {
      return;
    }
    localSplashActivity.showGifAnnimate();
  }
  
  private void l()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runNext: mRunningTaskNum=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      ((StringBuilder)localObject).append(", queueSize=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
      QLog.d("MainAssistObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 3)
    {
      localObject = (Runnable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ThreadManager.post((Runnable)localObject, 10, null, false);
      }
    }
  }
  
  public UpgradeDetailWrapper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper == null) {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localObject != null)
    {
      if (((SplashActivity)localObject).app == null) {
        return;
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.setMsgTabUnreadListener(this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
        VSNetworkHelper.getInstance();
        ((INewFriendService)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(INewFriendService.class, "")).addListener(this.jdField_a_of_type_ComTencentMobileqqNewfriendInterfacesINewFriendListener);
        ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).a();
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver);
        localObject = (ITroopNotificationService)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(ITroopNotificationService.class, "");
        if (localObject != null) {
          ((ITroopNotificationService)localObject).addUnreadCountOrConfigChangedListener(this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopNotificationService$INewTroopNotificationUnreadCountOrConfigChangedListener);
        }
        ((IKanDianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(IKanDianMergeManager.class)).addIndependentTabObserver(this.jdField_a_of_type_ComTencentMobileqqKandianRepoPushApiRIJTabObserverCallBack);
        QLog.d("Q.readinjoy.4tab", 2, "register main assist call notify to update icon red point!");
        ((IKanDianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(IKanDianMergeManager.class)).notificationTabRedNumsChange();
        localObject = (IKandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(IKandianSubscribeManager.class);
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.addObserver(((IKandianSubscribeManager)localObject).getMessageObserver());
        ((INearbyNewRedDotManager)QRoute.api(INearbyNewRedDotManager.class)).init(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    SplashActivity localSplashActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localSplashActivity == null) {
      return;
    }
    localSplashActivity.updateMain(paramInt1, paramInt2, paramObject);
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    SplashActivity localSplashActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localSplashActivity == null) {
      return;
    }
    localSplashActivity.updateTabRedTouch(paramInt, paramRedTypeInfo);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("if_check_account_same", false);
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("key_action");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    paramIntent = this.jdField_a_of_type_AndroidOsBundle;
    if (paramIntent == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramIntent.getString("appid");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("if Check =");
      paramIntent.append(this.jdField_b_of_type_Boolean);
      paramIntent.append(" appid = ");
      paramIntent.append(this.jdField_a_of_type_JavaLangString);
      paramIntent.append(" openId= ");
      paramIntent.append(this.jdField_b_of_type_JavaLangString);
      QLog.i("MainAssistObserver", 2, paramIntent.toString());
    }
    if (this.jdField_b_of_type_Boolean) {
      j();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "onAccountChanged, ");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    StudyModeManager.a();
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localObject == null) {
      return;
    }
    if (((SplashActivity)localObject).app == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.setMsgTabUnreadListener(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ((INewFriendService)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(INewFriendService.class)).removeListener(this.jdField_a_of_type_ComTencentMobileqqNewfriendInterfacesINewFriendListener);
    localObject = (ITroopNotificationService)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject != null) {
      ((ITroopNotificationService)localObject).removeUnreadCountOrConfigChangedListener(this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopNotificationService$INewTroopNotificationUnreadCountOrConfigChangedListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).b();
    ((IKanDianMergeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(IKanDianMergeManager.class)).removeIndependentTabObserver(this.jdField_a_of_type_ComTencentMobileqqKandianRepoPushApiRIJTabObserverCallBack);
    localObject = (IKandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getRuntimeService(IKandianSubscribeManager.class);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(((IKandianSubscribeManager)localObject).getMessageObserver());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver);
    ((INearbyNewRedDotManager)QRoute.api(INearbyNewRedDotManager.class)).onDestroy(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.jdField_b_of_type_AndroidOsBundle = paramIntent.getExtras();
    paramIntent = this.jdField_b_of_type_AndroidOsBundle;
    if (paramIntent == null) {
      return;
    }
    boolean bool1 = paramIntent.getBoolean("thridparty_pull_main", false);
    boolean bool2 = this.jdField_b_of_type_AndroidOsBundle.getBoolean("thridparty_prepare_mini_app", false);
    boolean bool3 = this.jdField_b_of_type_AndroidOsBundle.getBoolean("thridparty_prepare_av_game", false);
    if (bool1)
    {
      c(this.jdField_b_of_type_AndroidOsBundle);
      return;
    }
    if (bool2)
    {
      b(this.jdField_b_of_type_AndroidOsBundle);
      return;
    }
    if (bool3) {
      a(this.jdField_b_of_type_AndroidOsBundle);
    }
  }
  
  public void c()
  {
    try
    {
      ThreadManager.getSubThreadHandler().postDelayed(new MainAssistObserver.2(this), 500L);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyWindowShowed e=");
      localStringBuilder.append(localException);
      QLog.d("MainAssistObserver", 4, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a();
    SplashActivity localSplashActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localSplashActivity != null)
    {
      if (localSplashActivity.app == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
    }
  }
  
  public void e()
  {
    SplashActivity localSplashActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localSplashActivity != null)
    {
      if (localSplashActivity.app == null) {
        return;
      }
      ThreadManager.post(new MainAssistObserver.14(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
    }
  }
  
  public void f()
  {
    SplashActivity localSplashActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localSplashActivity != null)
    {
      if (localSplashActivity.app == null) {
        return;
      }
      ThreadManager.post(new MainAssistObserver.15(this, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app), 8, null, false);
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if ((localObject != null) && (((SplashActivity)localObject).app != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getCurrentAccountUin();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateTabLebaNotify, curUin=");
        localStringBuilder.append((String)localObject);
        QLog.d("MainAssistObserver", 2, localStringBuilder.toString());
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a(new MainAssistObserver.16(this)));
      return;
    }
    QLog.d("Q.lebanew", 1, "updateTabLebaNotify but it's NewLeba!");
  }
  
  public void h()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localObject1 != null)
    {
      if (((SplashActivity)localObject1).app == null) {
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
      e();
      Object localObject2 = ((QQAppInterface)localObject1).getMessageFacade();
      if (localObject2 != null) {
        ThreadManager.post(new MainAssistObserver.17(this, (QQAppInterface)localObject1, (QQMessageFacade)localObject2), 8, null, false);
      }
      g();
      f();
      a(40, null);
      localObject2 = new Intent("com.tencent.qq.syncQQMessage");
      ((QQAppInterface)localObject1).getApp().sendBroadcast((Intent)localObject2);
    }
  }
  
  protected void i()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131695206);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692113);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, new MainAssistObserver.21(this));
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131695174, new MainAssistObserver.22(this));
    }
    if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject1, ((SplashActivity)localObject1).getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131706474));
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getMsgHandler().a(this.jdField_a_of_type_JavaLangString);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("-->checkAccountDiff, mOpenid: ");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      QLog.i("MainAssistObserver", 2, ((StringBuilder)localObject2).toString());
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((OpenID)localObject1).openID)))
      {
        if (!this.jdField_b_of_type_JavaLangString.equals(((OpenID)localObject1).openID))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("-->checkAccountDiff, !mOpenId.equals(openId.openID) mOpenId =");
            ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
            ((StringBuilder)localObject2).append(" openId.openID = ");
            ((StringBuilder)localObject2).append(((OpenID)localObject1).openID);
            QLog.d("MainAssistObserver", 2, ((StringBuilder)localObject2).toString());
          }
          i();
          return;
        }
        if (this.d) {
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("-->checkAccountDiff, mOpenId.equals(openId.openID)  ");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
          QLog.d("MainAssistObserver", 2, ((StringBuilder)localObject1).toString());
        }
        if (BindGroupActivity.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, BindGroupActivity.class);
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getCurrentAccountUin());
          ((Intent)localObject1).putExtra("skey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getCurrentAccountUin()));
          ((Intent)localObject1).putExtra("key_params", this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject1);
        }
        else if (((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).getSimpleNameForTroopSettingActivity().equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
          localObject2 = this.jdField_a_of_type_AndroidOsBundle;
          TroopUtils.a((Context)localObject1, (Bundle)localObject2, ((Bundle)localObject2).getInt("vistor_type", 1));
        }
        else if ("key_sdk_add_friend".equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, (Intent)localObject1);
        }
        else if (ForwardIMByThirdPartyHelper.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin", "");
          if (((FriendsManager)localObject2).b((String)localObject1))
          {
            if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("thridparty_pull_aio", false))
            {
              localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, SplashActivity.class);
              ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
              ((Intent)localObject2).putExtra("thridparty_pull_aio", true);
              localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, (String)localObject1);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              localObject1 = AIOUtils.a((Intent)localObject2, new int[] { 2 });
              this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject1);
            }
          }
          else {
            a((String)localObject1);
          }
        }
        else if (ForwardMiniAppThirdPartyHelper.class.getSimpleName().equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_id", "");
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_path", "");
          String str = this.jdField_a_of_type_AndroidOsBundle.getString("mini_app_type", "release");
          ForwardMiniAppThirdPartyHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, (String)localObject1, (String)localObject2, str);
        }
        this.d = true;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131692930);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_b_of_type_AndroidOsHandler = new Handler();
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new MainAssistObserver.24(this), 3000L);
      GetOpenID.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getMsgHandler(), this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver
 * JD-Core Version:    0.7.0.1
 */