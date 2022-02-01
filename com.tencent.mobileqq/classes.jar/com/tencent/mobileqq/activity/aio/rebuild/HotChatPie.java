package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopMsgObserver;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.HotGiftPanelHelper;
import com.tencent.mobileqq.activity.aio.helper.HotHelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatPostListAdapter;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.hotchat.api.IHotChatShare;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.SegmentedControlView;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import java.util.Observable;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class HotChatPie
  extends BaseTroopChatPie
  implements RadioGroup.OnCheckedChangeListener
{
  protected static final String[] a;
  static long c;
  public boolean M = false;
  public boolean N = false;
  boolean O = false;
  boolean P;
  boolean Q = false;
  ViewPluginManager jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = null;
  private BaseTroopMsgObserver jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseTroopMsgObserver;
  public HotChatManager a;
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = (HotChatObserver)((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatObserverImpl(this);
  public HotChatInfo a;
  IHotChatPostListAdapter jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter;
  public IHotChatSCHelper a;
  IHotChatShare jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatShare;
  TroopRedDotObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver = new HotChatPie.1(this);
  RedDotRadioButton jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
  protected TroopUsingTimeReport a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  SegmentedControlView jdField_a_of_type_ComTencentWidgetSegmentedControlView;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  long jdField_b_of_type_Long = 0L;
  Dialog jdField_b_of_type_AndroidAppDialog;
  RedDotRadioButton jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
  public Dialog c;
  public String e;
  View i = null;
  public int j;
  View jdField_j_of_type_AndroidViewView;
  TextView jdField_j_of_type_AndroidWidgetTextView;
  public int k = 0;
  int l = 0;
  protected int m = -1;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "@all", HardCodeUtil.a(2131705667) };
  }
  
  public HotChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!this.P) && (paramBoolean) && (paramIntent.getBooleanExtra("param_newly_created_hot_chat", false)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramIntent = HotChatHelper.a(paramString3, 1);
      paramIntent = ((IHotChatApi)QRoute.api(IHotChatApi.class)).makeShareGrayTip(HardCodeUtil.a(2131713820), HardCodeUtil.a(2131705671), paramString1, paramString2, paramIntent, paramString3);
      if (!TextUtils.isEmpty(paramIntent))
      {
        this.P = true;
        paramString2 = MessageRecordFactory.a(-2033);
        long l1 = MessageCache.a();
        paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        paramString2.init(paramString3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString3, paramIntent, l1, -2033, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l1);
        paramString2.isread = true;
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString2, paramString3);
        }
      }
      this.jdField_b_of_type_AndroidAppDialog = HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new HotChatPie.12(this, paramString1));
    }
  }
  
  private void at()
  {
    if (this.jdField_j_of_type_AndroidViewView == null) {
      this.jdField_j_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559222, null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379127));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131366238));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559642, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTextColor(-1, -1, -1, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(-1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(10);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839396));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(30);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new HotChatPie.3(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new HotChatPie.4(this));
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_j_of_type_AndroidViewView) == -1)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131370119);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_j_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(8);
    }
    int i1 = SharedPreUtils.R(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    int n = 1;
    if (i1 != 1) {
      n = 0;
    }
    if (n != 0)
    {
      if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager == null)
      {
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = new ViewPluginManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "QQ_Hotchat_post_list.apk", "2586", "/hotchatPostListPlugin/opt");
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(new HotChatPie.5(this), false);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter = ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatPostListAdapter(this.jdField_a_of_type_AndroidContentContext, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() != 8)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter;
      if ((localObject == null) || (((IHotChatPostListAdapter)localObject).getCount() != 0)) {}
    }
    else
    {
      c(0, 10);
    }
  }
  
  private void au()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if ((localObject != null) && (((HotChatInfo)localObject).pkFlag != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper == null)
      {
        ThreadManager.post(new HotChatPie.10(this), 5, null, true);
        localObject = new HotChatPie.11(this);
        this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper = ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatSCHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (IHotChatSCHelper.OnShowNoteListener)localObject, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
      }
      this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper.startCheckDelay(10000L);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1)
    {
      if (this.jdField_j_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_j_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      }
      this.m = 1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
      if ((localObject != null) && (((RedDotRadioButton)localObject).a()))
      {
        e(131072);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (paramBoolean))
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) {
          localObject = "2";
        } else {
          localObject = "1";
        }
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject, "", "", "");
      }
    }
    else if (paramInt == 2)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
      if ((localObject != null) && (((RedDotRadioButton)localObject).a()))
      {
        this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
        localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter;
        if (localObject != null) {
          c(0, ((IHotChatPostListAdapter)localObject).getCount());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(4);
      at();
      Q();
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
      if (localObject != null) {
        ((HotChatInfo)localObject).clearRedPoint();
      }
      this.m = 2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
        this.l = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
      }
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "hot_room", "exp_visit_post", 0, 0, "", "", "", "");
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new HotChatPie.17(this, paramInt2, paramInt1), 8, null, true);
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("Q.hotchat.aio_post_list_req");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPostListFromServer start: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("|num:");
      localStringBuilder.append(paramInt2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.i == null) {
        this.i = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559931, null);
      }
      if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView == null)
      {
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).topMargin = 32;
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.i, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b();
        this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = ((SegmentedControlView)this.i.findViewById(2131368300));
      }
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.i.findViewById(2131368298));
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
      if (localObject != null)
      {
        ((RedDotRadioButton)localObject).setChecked(true);
        this.m = 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.i.findViewById(2131368299));
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setOnCheckedChangeListener(this);
      return;
    }
    if ((this.i != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.i) != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.i);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  private void n(boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new HotChatPie.2(this, paramBoolean));
  }
  
  public void A()
  {
    super.A();
  }
  
  protected void K()
  {
    aB();
    aq();
    super.K();
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    NearbyTransitActivity.a("AIOShow", 2);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("uin");
    String str1 = ((Intent)localObject1).getStringExtra("uinname");
    String str2 = ((Intent)localObject1).getStringExtra("hotnamecode");
    int n = 0;
    a((Intent)localObject1, (String)localObject2, str1, str2, ((Intent)localObject1).getBooleanExtra("param_newly_created_hot_chat", false));
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a()) {
      ThreadManager.post(new HotChatPie.8(this), 8, null, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if ((localObject1 != null) && (((HotChatInfo)localObject1).isBuLuoHotChat())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver);
    }
    au();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if ((localObject1 != null) && (((HotChatInfo)localObject1).isBuLuoHotChat()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.need2ReqRedPoint()) {
        ThreadManager.post(new HotChatPie.9(this), 8, null, true);
      }
      n = 1;
    }
    else
    {
      b(1, false);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (n != 0) {
      localObject1 = "2";
    } else {
      localObject1 = "1";
    }
    ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject1, "", "", "");
  }
  
  public void O()
  {
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseTroopMsgObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseTroopMsgObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
  }
  
  protected AIOContext a()
  {
    return new HotChatContext();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a((MsgListRefresher)((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected HelperProvider a()
  {
    return new HotHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 3)
      {
        Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), null);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      }
    }
    else if ((paramInt2 == 8001) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(View paramView) {}
  
  public void a(ChatMessage paramChatMessage, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(a());
    String str2 = HardCodeUtil.a(2131705676);
    String str3 = paramChatMessage.getExtInfoFromExtStr("hotchat_gender");
    String str1 = str2;
    try
    {
      if (Integer.parseInt(str3) != 1) {
        break label101;
      }
      str1 = HardCodeUtil.a(2131705673);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label48:
      StringBuilder localStringBuilder;
      break label48;
    }
    str1 = str2;
    if (QLog.isColorLevel())
    {
      str1 = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showHeadLongClickActionSheet, NumberFormatException, genderStr:");
      localStringBuilder.append(str3);
      QLog.e(str1, 2, localStringBuilder.toString());
      str1 = str2;
    }
    label101:
    localActionSheet.addButton(str1);
    localActionSheet.addButton(HardCodeUtil.a(2131705670), 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new HotChatPie.16(this, localActionSheet, paramChatMessage, paramString));
    localActionSheet.show();
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.Q) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(paramString4);
      paramString4 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onKickHotChatMember.isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",groupuin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",result=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",memberuin=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",strError=");
      localStringBuilder.append(paramString3);
      QLog.i(paramString4, 2, localStringBuilder.toString());
    }
    paramString1 = this.c;
    if ((paramString1 != null) && (paramString1.isShowing())) {
      this.c.dismiss();
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      QQToast.a(a(), HardCodeUtil.a(2131705656), 0).b(a().getTitleBarHeight());
      return;
    }
    QQToast.a(a(), HardCodeUtil.a(2131705658), 0).b(a().getTitleBarHeight());
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (this.Q) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    boolean bool = true;
    if ((paramString1 != null) && (!paramString1.memoShowed))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed = true;
      ThreadManager.post(new HotChatPie.14(this), 8, null, true);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.F, null);
        }
        paramString1 = paramString3;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1 = paramString3;
          if (!paramString3.startsWith("mqqapi"))
          {
            paramString1 = paramString3;
            if (!paramString3.startsWith("http://"))
            {
              paramString1 = paramString3;
              if (!paramString3.startsWith("https://"))
              {
                paramString1 = new StringBuilder();
                paramString1.append("https://");
                paramString1.append(paramString3);
                paramString1 = paramString1.toString();
              }
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString2, paramString1);
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper;
        if (paramString1 == null) {
          break label243;
        }
        paramString1.setCurShowingNote(false);
        return true;
      }
    }
    bool = false;
    label243:
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.v = false;
    ((FastImageHelper)a(83)).a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseTroopMsgObserver = new BaseTroopMsgObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatShare = ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatShare(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport = new TroopUsingTimeReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    return super.a(paramBoolean);
  }
  
  public void aB()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if (localHotChatInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("param_newly_created_hot_chat", false)) {
        ThreadManager.post(new HotChatPie.15(this, localHotChatInfo), 8, null, true);
      }
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693187));
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if ((localHotChatInfo != null) && (localHotChatInfo.state != 0)) {
      ThreadManager.post(new HotChatPie.7(this), 5, null, false);
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    this.jdField_j_of_type_Int = paramInt2;
  }
  
  protected void b(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if ((localObject != null) && (((HotChatInfo)localObject).isBuLuoHotChat()))
    {
      HtmlOffline.a("2586", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new HotChatPie.6(this), true, 0);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetSegmentedControlView;
    if (localObject != null)
    {
      ((SegmentedControlView)localObject).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.i);
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    super.b(paramIntent);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "HotChatPie";
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.M)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
      }
      HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.M);
      return;
    }
    super.c(paramBoolean);
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true);
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("PttShow", new Object[] { "HotChatPie_updateSession_business HotChatInfo is null", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
      }
      b(0);
      return;
    }
    this.k = ((HotChatInfo)localObject).userCreate;
    if ((paramIntent != null) && (paramIntent.getIntExtra("hot_chat_from", 1) == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.c())) {
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    paramIntent = (AIOShortcutBarHelper)a(52);
    if ((paramIntent != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isRobotHotChat))
    {
      localObject = new AIOShortcutBarHelper.AIOShortcutBarEvent(14);
      ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject).a().putLong("roBotUin", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.robotUin);
      paramIntent.a((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject);
    }
  }
  
  public boolean d()
  {
    HotGiftPanelHelper localHotGiftPanelHelper = (HotGiftPanelHelper)a(136);
    if ((localHotGiftPanelHelper.a != null) && (localHotGiftPanelHelper.a.a()))
    {
      localHotGiftPanelHelper.a.a();
      return true;
    }
    boolean bool = super.d();
    if ((!this.jdField_f_of_type_Boolean) && (this.M) && (!bool)) {
      HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.M);
    }
    return bool;
  }
  
  protected void e(Intent paramIntent)
  {
    this.M = paramIntent.getBooleanExtra("abp_flag", false);
    this.N = paramIntent.getBooleanExtra("is_from_web", false);
    if ((this.N) && (!this.M))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690529);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131705665));
      return;
    }
    if (this.M)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705677));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131705663));
      return;
    }
    super.e(paramIntent);
  }
  
  public int g()
  {
    return this.m;
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
  }
  
  protected void h()
  {
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if ((localHotChatInfo != null) && (localHotChatInfo.isBuLuoHotChat())) {
      return;
    }
    localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    int n;
    if ((localHotChatInfo != null) && (localHotChatInfo.mFissionRoomNum > 0)) {
      n = 1;
    } else {
      n = 0;
    }
    a(true);
    if (n != 0)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693199), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum) }));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 29) {
      return super.handleMessage(paramMessage);
    }
    return true;
  }
  
  protected void j()
  {
    this.d.setVisibility(4);
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a((String)localObject)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid)))
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://nearby.qq.com/hot_chat/room_info.html", "_wv", "3"), "_bid", "2581"), "gc", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin), "rid", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid), "rname", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name), "rtype", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.hotChatType)), "rnum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memberCount)));
      a().startActivity((Intent)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004414", "0X8004414", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isGameRoom) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "clk_grp_card", 0, 0, "", "", "", "");
      }
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), HardCodeUtil.a(2131705675), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
  }
  
  protected void n()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
    }
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int n;
    if (paramInt == 2131368298) {
      n = 1;
    } else {
      n = 2;
    }
    b(n, true);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str;
    if (paramInt == 2131368298) {
      str = "clk_hot_room";
    } else {
      str = "clk_see_post";
    }
    ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", str, 0, 0, "", "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
  
  public void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper;
    if (localObject != null)
    {
      ((IHotChatSCHelper)localObject).destroy();
      this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if ((localObject != null) && (((HotChatInfo)localObject).isBuLuoHotChat()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver);
      b(1, false);
      if ((this.i != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.i) != -1)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.i);
      }
      this.i = null;
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
      this.jdField_j_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter = null;
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = null;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_b_of_type_Long;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006587", "0X8006587", 0, 0, String.valueOf(l1 - l2), String.valueOf(this.k), "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("open_chatfragment_fromphoto", false);
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((Dialog)localObject).dismiss();
      this.c = null;
    }
    localObject = this.jdField_b_of_type_AndroidAppDialog;
    if (localObject != null)
    {
      ((Dialog)localObject).dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatShare;
    if (localObject != null) {
      ((IHotChatShare)localObject).onDestroy();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatPostListAdapter;
    if (localObject != null) {
      ((IHotChatPostListAdapter)localObject).destroy();
    }
    ((ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).closeTalking();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport;
    if (localObject != null) {
      ((TroopUsingTimeReport)localObject).b();
    }
    super.p();
  }
  
  public void u()
  {
    super.u();
    this.Q = true;
  }
  
  public boolean u()
  {
    return true;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
      AIOAnimationControlManager.a(this, false);
    }
    paramObservable = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
    if ((paramObservable != null) && (!paramObservable.a()) && (paramObject != null) && ((paramObject instanceof MessageRecord)) && (this.m == 2)) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new HotChatPie.13(this));
    }
  }
  
  public void v()
  {
    super.v();
    IHotChatSCHelper localIHotChatSCHelper = this.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper;
    if (localIHotChatSCHelper != null) {
      localIHotChatSCHelper.stopCheck();
    }
  }
  
  public void y()
  {
    super.y();
    this.Q = false;
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if ((localHotChatInfo != null) && (localHotChatInfo.isBuLuoHotChat()) && (this.m == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.a();
  }
  
  public void z()
  {
    super.z();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (localObject == null) {
      return;
    }
    String str = ((Intent)localObject).getStringExtra("uin");
    int n = ((Intent)localObject).getIntExtra("uintype", -1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != n))) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
      if ((localObject != null) && (((HotChatInfo)localObject).isBuLuoHotChat()))
      {
        this.jdField_j_of_type_AndroidViewView = null;
        this.jdField_a_of_type_ComTencentWidgetXListView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie
 * JD-Core Version:    0.7.0.1
 */