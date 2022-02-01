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
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.handler.GetOpenID;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.flashshow.api.helper.FSObserver;
import com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.NotifyObj;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
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
import com.tencent.mobileqq.pb.PBUInt32Field;
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
import java.util.Observer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class MainAssistObserver
{
  private MessageObserver A = new MainAssistObserver.4(this);
  private QZoneObserver B = new MainAssistObserver.5(this);
  private final RIJTabObserverCallBack C = new MainAssistObserver.6(this);
  private ReadInJoyObserver D = new MainAssistObserver.7(this);
  private GameCenterObserver E = new MainAssistObserver.8(this);
  private MsgTabUnreadListener F = new MainAssistObserver.9(this);
  private final Observer G = new MainAssistObserver.10(this);
  private INewFriendListener H = new MainAssistObserver.12(this);
  private ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener I = new MainAssistObserver.13(this);
  private ConfigObserver J = new MainAssistObserver.14(this);
  private ExpandObserver K = new MainAssistObserver.15(this);
  private QCircleObserver L = new MainAssistObserver.16(this);
  private FSObserver M = new MainAssistObserver.17(this);
  private UpgradeDetailWrapper N;
  private GetRedPointExObserver O = new MainAssistObserver.23(this);
  public SplashActivity a;
  public final int b = 0;
  public final int c = 1;
  public final int d = 3;
  public volatile boolean e = false;
  public LebaTabRedTouch f;
  ConcurrentLinkedQueue<Runnable> g = new ConcurrentLinkedQueue();
  AtomicInteger h = new AtomicInteger(0);
  QQCustomDialog i = null;
  Handler j = new MainAssistObserver.22(this, Looper.getMainLooper());
  CardObserver k = new MainAssistObserver.24(this);
  protected String l;
  protected String m;
  protected boolean n;
  protected Bundle o;
  protected String p;
  protected QQProgressDialog q;
  protected Handler r;
  protected boolean s;
  protected QQCustomDialog t;
  public boolean u = false;
  protected OpenIdObserver v = new MainAssistObserver.27(this);
  RedpointObserver w = new MainAssistObserver.29(this);
  protected QQCustomDialog x;
  protected Bundle y;
  private VipGifObserver z = new MainAssistObserver.2(this);
  
  public MainAssistObserver(SplashActivity paramSplashActivity)
  {
    this.f = new LebaTabRedTouch(paramSplashActivity);
    this.a = paramSplashActivity;
  }
  
  private QQCustomDialog a(String paramString1, String paramString2)
  {
    paramString1 = DialogUtil.a(this.a, 230).setTitle(null).setMessage(paramString1).setPositiveButton(this.a.getString(2131916400), new MainAssistObserver.34(this));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getString(2131916399));
    localStringBuilder.append(paramString2);
    return paramString1.setNegativeButton(localStringBuilder.toString(), new MainAssistObserver.33(this));
  }
  
  private void a(Bundle paramBundle)
  {
    try
    {
      this.a.getIntent().putExtra("thridparty_prepare_av_game", false);
      localObject = paramBundle.getString("thridparty_av_game_type_key", "");
      long l1 = paramBundle.getLong("thridparty_av_game_room_id", 0L);
      long l2 = paramBundle.getLong("thridparty_av_game_share_uin", 0L);
      int i1 = paramBundle.getInt("avgame_create_game_type_key", 0);
      int i2 = paramBundle.getInt("avgame_from_type_key", 4);
      boolean bool = "thridparty_av_game_type_join_room".equals(localObject);
      if (bool)
      {
        paramBundle = (IAvGameManager)this.a.app.getRuntimeService(IAvGameManager.class, "");
        if (paramBundle == null)
        {
          QLog.e("MainAssistObserver", 1, "AV_GAME_MANAGER NULL");
          return;
        }
        paramBundle.joinAvGameRoom(this.a, 2, String.valueOf(l1), String.valueOf(l2));
        return;
      }
      if ("thridparty_av_game_type_create_room".equals(localObject))
      {
        paramBundle = (IAvGameManager)this.a.app.getRuntimeService(IAvGameManager.class, "");
        if (paramBundle == null)
        {
          QLog.e("MainAssistObserver", 1, "AV_GAME_MANAGER NULL");
          return;
        }
        paramBundle.createAvGameRoom(this.a, i2, null, i1);
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
    this.g.offer(paramRunnable);
    n();
  }
  
  private void a(String paramString)
  {
    DialogUtil.a(this.a, 230).setTitle(null).setMessage(String.format(this.a.getString(2131897440), new Object[] { paramString })).setPositiveButton(this.a.getString(2131888030), new MainAssistObserver.31(this, paramString)).setNegativeButton(this.a.getString(2131887626), new MainAssistObserver.30(this)).show();
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    boolean bool = false;
    if (paramBoolean)
    {
      localRedTypeInfo.red_type.set(5);
      a(48, 18, Boolean.valueOf(false));
      a(48, 16, Integer.valueOf(paramInt));
    }
    else
    {
      localRedTypeInfo.red_type.set(0);
      a(48, 16, Integer.valueOf(0));
      paramBoolean = bool;
      if (paramInt > 0) {
        paramBoolean = true;
      }
      a(48, 18, Boolean.valueOf(paramBoolean));
    }
    a(48, localRedTypeInfo);
  }
  
  private boolean a(IGuildUnreadCntService.NotifyObj paramNotifyObj)
  {
    if (paramNotifyObj != null)
    {
      if (paramNotifyObj.a != 3) {
        return false;
      }
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((SplashActivity)localObject).app == null) {
          return false;
        }
        localObject = ((IGuildUnreadCntService)this.a.app.getRuntimeService(IGuildUnreadCntService.class, "")).getAllGuildAtUnreadCntInfo();
        int i1 = ((IGuildUnreadCntService.UnreadCntInfo)localObject).b;
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (i1 == 2)
        {
          bool1 = bool2;
          if (paramNotifyObj.c != null)
          {
            bool1 = bool2;
            if (paramNotifyObj.c.b == ((IGuildUnreadCntService.UnreadCntInfo)localObject).b)
            {
              if (paramNotifyObj.c.a < ((IGuildUnreadCntService.UnreadCntInfo)localObject).a) {
                return true;
              }
              bool1 = false;
            }
          }
        }
        return bool1;
      }
    }
    return false;
  }
  
  private QQCustomDialog b(String paramString)
  {
    return DialogUtil.a(this.a, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.a.getString(2131887629), new MainAssistObserver.32(this));
  }
  
  private void b(Bundle paramBundle)
  {
    this.a.getIntent().putExtra("thridparty_prepare_mini_app", false);
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
      this.a.getIntent().removeExtra("pull_show_open_id_diff_main");
      this.a.getIntent().putExtra("is_change_account", true);
      this.a.getIntent().putExtra("if_check_account_same", true);
      this.a.getIntent().putExtra("key_action", ForwardMiniAppThirdPartyHelper.class.getSimpleName());
      k();
      return;
    }
    if (bool2)
    {
      this.a.getIntent().removeExtra("pull_app_not_privilege");
      if (bool3)
      {
        this.a.getIntent().removeExtra("pull_mini_app_not_privilege_not_bind");
        this.x = a(paramBundle, str4);
      }
      else
      {
        this.x = b(paramBundle);
      }
      this.x.show();
      return;
    }
    ForwardMiniAppThirdPartyHelper.a(this.a, str1, str2, str3);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    int i1 = ((LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).d();
    String str;
    if (i1 != 3) {
      if (i1 != 4) {
        if (i1 != 5) {
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
      this.a.getIntent().removeExtra("pull_app_not_privilege");
      this.x = b(str1);
      this.x.show();
      return;
    }
    if (bool2)
    {
      this.a.getIntent().removeExtra("thridparty_pull_main");
      this.a.getIntent().removeExtra("pull_show_open_id_diff_main");
      this.a.getIntent().putExtra("is_change_account", true);
      this.a.getIntent().putExtra("if_check_account_same", true);
      this.a.getIntent().putExtra("key_action", ForwardIMByThirdPartyHelper.class.getSimpleName());
      k();
      return;
    }
    if (bool3)
    {
      this.a.getIntent().removeExtra("pull_add_friend_tip");
      a(str2);
    }
  }
  
  private void m()
  {
    SplashActivity localSplashActivity = this.a;
    if (localSplashActivity == null) {
      return;
    }
    localSplashActivity.showGifAnnimate();
  }
  
  private void n()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runNext: mRunningTaskNum=");
      ((StringBuilder)localObject).append(this.h.get());
      ((StringBuilder)localObject).append(", queueSize=");
      ((StringBuilder)localObject).append(this.g.size());
      QLog.d("MainAssistObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (this.h.get() <= 3)
    {
      localObject = (Runnable)this.g.poll();
      if (localObject != null)
      {
        this.h.incrementAndGet();
        ThreadManager.post((Runnable)localObject, 10, null, false);
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((SplashActivity)localObject).app == null) {
        return;
      }
      if (this.e) {
        return;
      }
      try
      {
        this.a.app.registObserver(this.z);
        this.a.app.registObserver(this.B);
        this.a.app.registObserver(this.E);
        this.a.app.addObserver(this.J);
        this.a.app.addObserver(this.A);
        this.a.app.addObserver(this.O);
        this.a.app.setMsgTabUnreadListener(this.F);
        this.a.app.addObserver(this.D);
        VSNetworkHelper.getInstance();
        ((INewFriendService)this.a.app.getRuntimeService(INewFriendService.class, "")).addListener(this.H);
        ((TroopRedTouchHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).b();
        this.a.app.addObserver(this.k);
        this.a.app.addObserver(this.v);
        this.a.app.addObserver(this.w);
        this.a.app.addObserver(this.K);
        this.a.app.addObserver(this.L);
        this.a.app.addObserver(this.M);
        localObject = (ITroopNotificationService)this.a.app.getRuntimeService(ITroopNotificationService.class, "");
        if (localObject != null) {
          ((ITroopNotificationService)localObject).addUnreadCountOrConfigChangedListener(this.I);
        }
        ((IKanDianMergeManager)this.a.app.getRuntimeService(IKanDianMergeManager.class)).addIndependentTabObserver(this.C);
        QLog.d("Q.readinjoy.4tab", 2, "register main assist call notify to update icon red point!");
        ((IKanDianMergeManager)this.a.app.getRuntimeService(IKanDianMergeManager.class)).notificationTabRedNumsChange();
        localObject = (IKandianSubscribeManager)this.a.app.getRuntimeService(IKandianSubscribeManager.class);
        this.a.app.addObserver(((IKandianSubscribeManager)localObject).getMessageObserver());
        ThreadManagerV2.excute(new MainAssistObserver.1(this), 32, null, false);
        ((INearbyNewRedDotManager)QRoute.api(INearbyNewRedDotManager.class)).init(this.a.app);
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
      }
      this.e = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    SplashActivity localSplashActivity = this.a;
    if (localSplashActivity == null) {
      return;
    }
    localSplashActivity.updateMain(paramInt1, paramInt2, paramObject);
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    SplashActivity localSplashActivity = this.a;
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
    this.n = paramIntent.getBooleanExtra("if_check_account_same", false);
    this.p = paramIntent.getStringExtra("key_action");
    if (TextUtils.isEmpty(this.p)) {
      return;
    }
    this.o = paramIntent.getExtras();
    paramIntent = this.o;
    if (paramIntent == null) {
      return;
    }
    this.l = paramIntent.getString("appid");
    this.m = this.o.getString("openid");
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("if Check =");
      paramIntent.append(this.n);
      paramIntent.append(" appid = ");
      paramIntent.append(this.l);
      paramIntent.append(" openId= ");
      paramIntent.append(this.m);
      QLog.i("MainAssistObserver", 2, paramIntent.toString());
    }
    if (this.n) {
      l();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "onAccountChanged, ");
    }
    this.h.set(0);
    this.g.clear();
    StudyModeManager.a();
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (((SplashActivity)localObject).app == null) {
      return;
    }
    if (!this.e) {
      return;
    }
    this.a.app.unRegistObserver(this.B);
    this.a.app.removeObserver(this.A);
    this.a.app.removeObserver(this.O);
    this.a.app.unRegistObserver(this.E);
    this.a.app.setMsgTabUnreadListener(null);
    this.a.app.removeObserver(this.J);
    this.a.app.removeObserver(this.D);
    ((INewFriendService)this.a.app.getRuntimeService(INewFriendService.class)).removeListener(this.H);
    localObject = (ITroopNotificationService)this.a.app.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject != null) {
      ((ITroopNotificationService)localObject).removeUnreadCountOrConfigChangedListener(this.I);
    }
    this.a.app.removeObserver(this.w);
    this.a.app.unRegistObserver(this.z);
    ((TroopRedTouchHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).c();
    ((IKanDianMergeManager)this.a.app.getRuntimeService(IKanDianMergeManager.class)).removeIndependentTabObserver(this.C);
    localObject = (IKandianSubscribeManager)this.a.app.getRuntimeService(IKandianSubscribeManager.class);
    this.a.app.removeObserver(((IKandianSubscribeManager)localObject).getMessageObserver());
    ((IGuildUnreadCntService)this.a.app.getRuntimeService(IGuildUnreadCntService.class, "")).deleteObserver(this.G);
    this.e = false;
    this.a.app.removeObserver(this.k);
    this.a.app.removeObserver(this.v);
    this.a.app.removeObserver(this.K);
    this.a.app.removeObserver(this.L);
    this.a.app.removeObserver(this.M);
    ((INearbyNewRedDotManager)QRoute.api(INearbyNewRedDotManager.class)).onDestroy(this.a.app);
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.y = paramIntent.getExtras();
    paramIntent = this.y;
    if (paramIntent == null) {
      return;
    }
    boolean bool1 = paramIntent.getBoolean("thridparty_pull_main", false);
    boolean bool2 = this.y.getBoolean("thridparty_prepare_mini_app", false);
    boolean bool3 = this.y.getBoolean("thridparty_prepare_av_game", false);
    if (bool1)
    {
      c(this.y);
      return;
    }
    if (bool2)
    {
      b(this.y);
      return;
    }
    if (bool3) {
      a(this.y);
    }
  }
  
  public void c()
  {
    try
    {
      ThreadManager.getSubThreadHandler().postDelayed(new MainAssistObserver.3(this), 500L);
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
    this.h.set(0);
    this.g.clear();
    this.f.e();
    SplashActivity localSplashActivity = this.a;
    if (localSplashActivity != null)
    {
      if (localSplashActivity.app == null) {
        return;
      }
      this.a = null;
    }
  }
  
  public void e()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (((SplashActivity)localObject1).app == null) {
        return;
      }
      localObject1 = this.a.app;
      Object localObject2 = ((IGuildUnreadCntService)((QQAppInterface)localObject1).getRuntimeService(IGuildUnreadCntService.class, "")).getAllGuildAtUnreadCntInfo();
      boolean bool;
      if (((IGuildUnreadCntService.UnreadCntInfo)localObject2).b == 1) {
        bool = true;
      } else {
        bool = false;
      }
      long l2 = ((IGuildUnreadCntService.UnreadCntInfo)localObject2).a;
      long l1 = 0L;
      if (l2 >= 0L) {
        l1 = ((IGuildUnreadCntService.UnreadCntInfo)localObject2).a;
      }
      int i1 = (int)l1;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        a(bool, i1);
      } else {
        ThreadManager.getUIHandler().post(new MainAssistObserver.11(this, bool, i1));
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateGuildTabUI showType = ");
        localStringBuilder.append(((IGuildUnreadCntService.UnreadCntInfo)localObject2).b);
        localStringBuilder.append(" unreadCount = ");
        localStringBuilder.append(i1);
        QLog.d("MainAssistObserver", 2, localStringBuilder.toString());
      }
      localObject2 = new Intent("com.tencent.qq.syncQQMessage");
      ((QQAppInterface)localObject1).getApp().sendBroadcast((Intent)localObject2);
      if (QLog.isDevelopLevel()) {
        QLog.d("fetchUnReadCount", 4, String.format("MainAssistObserver小站tab, nUnreadCount[%s]", new Object[] { Integer.valueOf(i1) }));
      }
    }
  }
  
  public void f()
  {
    SplashActivity localSplashActivity = this.a;
    if (localSplashActivity != null)
    {
      if (localSplashActivity.app == null) {
        return;
      }
      ThreadManager.post(new MainAssistObserver.18(this, this.a.app), 8, null, false);
    }
  }
  
  public void g()
  {
    SplashActivity localSplashActivity = this.a;
    if (localSplashActivity != null)
    {
      if (localSplashActivity.app == null) {
        return;
      }
      ThreadManager.post(new MainAssistObserver.19(this, this.a.app), 8, null, false);
    }
  }
  
  public void h()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((SplashActivity)localObject).app != null))
    {
      localObject = this.a.app.getCurrentAccountUin();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateTabLebaNotify, curUin=");
        localStringBuilder.append((String)localObject);
        QLog.d("MainAssistObserver", 2, localStringBuilder.toString());
      }
      a(this.f.a(new MainAssistObserver.20(this)));
      return;
    }
    QLog.d("Q.lebanew", 1, "updateTabLebaNotify but it's NewLeba!");
  }
  
  public void i()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (((SplashActivity)localObject1).app == null) {
        return;
      }
      localObject1 = this.a.app;
      f();
      Object localObject2 = ((QQAppInterface)localObject1).getMessageFacade();
      if (localObject2 != null) {
        ThreadManager.post(new MainAssistObserver.21(this, (QQAppInterface)localObject1, (QQMessageFacade)localObject2), 8, null, false);
      }
      h();
      g();
      a(40, null);
      localObject2 = new Intent("com.tencent.qq.syncQQMessage");
      ((QQAppInterface)localObject1).getApp().sendBroadcast((Intent)localObject2);
    }
  }
  
  public UpgradeDetailWrapper j()
  {
    if (this.N == null) {
      this.N = UpgradeController.a().d();
    }
    return this.N;
  }
  
  protected void k()
  {
    if (this.t == null)
    {
      this.t = DialogUtil.a(this.a, 230);
      this.t.setMessage(2131892939);
      this.t.setTitle(2131889094);
      this.t.setNegativeButton(2131887648, new MainAssistObserver.25(this));
      this.t.setPositiveButton(2131892907, new MainAssistObserver.26(this));
    }
    if (!this.t.isShowing()) {
      this.t.show();
    }
  }
  
  protected void l()
  {
    if (this.q == null)
    {
      localObject1 = this.a;
      this.q = new QQProgressDialog((Context)localObject1, ((SplashActivity)localObject1).getTitleBarHeight());
      this.q.a(HardCodeUtil.a(2131904333));
    }
    Object localObject1 = this.a.app.getMsgHandler().e(this.l);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("-->checkAccountDiff, mOpenid: ");
      ((StringBuilder)localObject2).append(this.m);
      QLog.i("MainAssistObserver", 2, ((StringBuilder)localObject2).toString());
    }
    if (!TextUtils.isEmpty(this.m))
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((OpenID)localObject1).openID)))
      {
        if (!this.m.equals(((OpenID)localObject1).openID))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("-->checkAccountDiff, !mOpenId.equals(openId.openID) mOpenId =");
            ((StringBuilder)localObject2).append(this.m);
            ((StringBuilder)localObject2).append(" openId.openID = ");
            ((StringBuilder)localObject2).append(((OpenID)localObject1).openID);
            QLog.d("MainAssistObserver", 2, ((StringBuilder)localObject2).toString());
          }
          k();
          return;
        }
        if (this.u) {
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("-->checkAccountDiff, mOpenId.equals(openId.openID)  ");
          ((StringBuilder)localObject1).append(this.m);
          QLog.d("MainAssistObserver", 2, ((StringBuilder)localObject1).toString());
        }
        if (BindGroupActivity.class.getSimpleName().equals(this.p))
        {
          localObject1 = new Intent(this.a, BindGroupActivity.class);
          ((Intent)localObject1).putExtra("uin", this.a.getCurrentAccountUin());
          ((Intent)localObject1).putExtra("skey", ((TicketManager)this.a.app.getManager(2)).getSkey(this.a.app.getCurrentAccountUin()));
          ((Intent)localObject1).putExtra("key_params", this.o);
          this.a.startActivity((Intent)localObject1);
        }
        else if (((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).getSimpleNameForTroopSettingActivity().equals(this.p))
        {
          localObject1 = this.a;
          localObject2 = this.o;
          TroopUtils.a((Context)localObject1, (Bundle)localObject2, ((Bundle)localObject2).getInt("vistor_type", 1));
        }
        else if ("key_sdk_add_friend".equals(this.p))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras(this.o);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.a, (Intent)localObject1);
        }
        else if (ForwardIMByThirdPartyHelper.class.getSimpleName().equals(this.p))
        {
          localObject2 = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          localObject1 = this.o.getString("uin", "");
          if (((FriendsManager)localObject2).n((String)localObject1))
          {
            if (this.o.getBoolean("thridparty_pull_aio", false))
            {
              localObject2 = new Intent(this.a, SplashActivity.class);
              ((Intent)localObject2).putExtras(this.o);
              ((Intent)localObject2).putExtra("thridparty_pull_aio", true);
              localObject1 = ContactUtils.a(this.a.app, (String)localObject1);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              localObject1 = AIOUtils.a((Intent)localObject2, new int[] { 2 });
              this.a.startActivity((Intent)localObject1);
            }
          }
          else {
            a((String)localObject1);
          }
        }
        else if (ForwardMiniAppThirdPartyHelper.class.getSimpleName().equals(this.p))
        {
          localObject1 = this.o.getString("mini_app_id", "");
          localObject2 = this.o.getString("mini_app_path", "");
          String str = this.o.getString("mini_app_type", "release");
          ForwardMiniAppThirdPartyHelper.a(this.a, (String)localObject1, (String)localObject2, str);
        }
        this.u = true;
        return;
      }
      this.q.c(2131890041);
      this.q.show();
      this.r = new Handler();
      this.r.postDelayed(new MainAssistObserver.28(this), 3000L);
      GetOpenID.a(this.a.app.getMsgHandler(), this.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver
 * JD-Core Version:    0.7.0.1
 */