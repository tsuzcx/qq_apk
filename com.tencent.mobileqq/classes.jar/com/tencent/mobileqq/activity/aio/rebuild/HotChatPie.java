package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.troopgift.TroopGiftPanel;
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
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.HotChatMsgListRefresher;
import com.tencent.mobileqq.adapter.HotChatPostListAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.HotChatObserverImpl;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class HotChatPie
  extends BaseTroopChatPie
  implements RadioGroup.OnCheckedChangeListener
{
  protected static final String[] a;
  static long d;
  public boolean Z = false;
  ViewPluginManager jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = null;
  private BaseTroopMsgObserver jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseTroopMsgObserver;
  HotChatPostListAdapter jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter;
  public HotChatManager a;
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new HotChatObserverImpl(this);
  HotChatShare jdField_a_of_type_ComTencentMobileqqAppHotChatShare;
  public HotchatSCHelper a;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new HotChatPie.1(this);
  public HotChatInfo a;
  protected NearbyGiftPanelDialog a;
  protected TroopGiftPanelForNearby a;
  RedDotRadioButton jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton;
  protected TroopUsingTimeReport a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  SegmentedControlView jdField_a_of_type_ComTencentWidgetSegmentedControlView;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public boolean aa = false;
  boolean ab = false;
  boolean ac;
  boolean ad = false;
  RedDotRadioButton b;
  long jdField_c_of_type_Long = 0L;
  Dialog jdField_c_of_type_AndroidAppDialog;
  public Dialog d;
  public String i;
  public int n;
  TextView n;
  public int o;
  View o;
  int jdField_p_of_type_Int = 0;
  View jdField_p_of_type_AndroidViewView;
  protected int q = -1;
  
  static
  {
    jdField_d_of_type_Long = 0L;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "@all", HardCodeUtil.a(2131705601) };
  }
  
  public HotChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_o_of_type_Int = 0;
    this.jdField_o_of_type_AndroidViewView = null;
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!this.ac) && (paramBoolean) && (paramIntent.getBooleanExtra("param_newly_created_hot_chat", false)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramIntent = HotChatHelper.a(paramString3, 1);
      paramIntent = ShareHotChatGrayTips.makeShareGrayTip(ShareHotChatGrayTips.SHARE_GRAY_TIP_CONTENT, HardCodeUtil.a(2131705605), paramString1, paramString2, paramIntent, paramString3);
      if (!TextUtils.isEmpty(paramIntent))
      {
        this.ac = true;
        paramString2 = MessageRecordFactory.a(-2033);
        long l = MessageCache.a();
        paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        paramString2.init(paramString3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString3, paramIntent, l, -2033, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
        paramString2.isread = true;
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString2, paramString3);
        }
      }
      this.jdField_c_of_type_AndroidAppDialog = HotChatHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new HotChatPie.13(this, paramString1));
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramInt == 1)
    {
      if (this.jdField_p_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_p_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      }
      this.q = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()))
      {
        g(131072);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (paramBoolean))
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) {
          break label220;
        }
        str = "2";
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, str, "", "", "");
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "hot_room", "exp_visit_post", 0, 0, "", "", "", "");
      return;
      label220:
      str = "1";
      break;
      if (paramInt == 2)
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()))
        {
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
          if (this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter != null) {
            d(0, this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.getCount());
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(4);
        bn();
        an();
        if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.clearRedPoint();
        }
        this.q = 2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
          this.jdField_p_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
        }
      }
    }
  }
  
  private void bn()
  {
    if (this.jdField_p_of_type_AndroidViewView == null) {
      this.jdField_p_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559347, null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_p_of_type_AndroidViewView.findViewById(2131379798));
      this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)this.jdField_p_of_type_AndroidViewView.findViewById(2131366350));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559765, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTextColor(-1, -1, -1, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(-1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(10);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839540));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(30);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new HotChatPie.4(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new HotChatPie.5(this));
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_p_of_type_AndroidViewView) == -1)
    {
      localLayoutParams.addRule(6, 2131370460);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_p_of_type_AndroidViewView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(8);
    }
    int j;
    if (SharedPreUtils.U(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 1)
    {
      j = 1;
      if (j == 0) {
        break label400;
      }
      if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager == null)
      {
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = new ViewPluginManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "QQ_Hotchat_post_list.apk", "2586", "/hotchatPostListPlugin/opt");
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(new HotChatPie.6(this), false);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() == 8) || ((this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.getCount() == 0))) {
        d(0, 10);
      }
      return;
      j = 0;
      break;
      label400:
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter = new HotChatPostListAdapter(this.jdField_a_of_type_AndroidContentContext, null, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter);
      }
    }
  }
  
  private void bo()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.pkFlag != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper == null)
      {
        ThreadManager.post(new HotChatPie.11(this), 5, null, true);
        HotChatPie.12 local12 = new HotChatPie.12(this);
        this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper = new HotchatSCHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, local12, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.a(10000L);
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new HotChatPie.21(this, paramInt2, paramInt1), 8, null, true);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString + "Q.hotchat.aio_post_list_req", 2, "getPostListFromServer start: " + paramInt1 + "|num:" + paramInt2);
    }
  }
  
  private void t(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.jdField_o_of_type_AndroidViewView == null) {
        this.jdField_o_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560061, null);
      }
      if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(14);
        localLayoutParams.topMargin = 32;
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_o_of_type_AndroidViewView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b();
        this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = ((SegmentedControlView)this.jdField_o_of_type_AndroidViewView.findViewById(2131368557));
      }
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.jdField_o_of_type_AndroidViewView.findViewById(2131368555));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(true);
        this.q = 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.jdField_o_of_type_AndroidViewView.findViewById(2131368556));
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setOnCheckedChangeListener(this);
      return;
    }
    if ((this.jdField_o_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.jdField_o_of_type_AndroidViewView) != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.jdField_o_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  private void u(boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new HotChatPie.3(this, paramBoolean));
  }
  
  public void C()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
    }
  }
  
  public boolean F()
  {
    return true;
  }
  
  public void J()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b();
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      b(1, false);
      if ((this.jdField_o_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.jdField_o_of_type_AndroidViewView) != -1)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.jdField_o_of_type_AndroidViewView);
      }
      this.jdField_o_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
      this.jdField_p_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter = null;
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = null;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_c_of_type_Long;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006587", "0X8006587", 0, 0, String.valueOf(l1 - l2), String.valueOf(this.jdField_o_of_type_Int), "", "");
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("open_chatfragment_fromphoto", false))) || (this.jdField_d_of_type_AndroidAppDialog != null))
    {
      this.jdField_d_of_type_AndroidAppDialog.dismiss();
      this.jdField_d_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_c_of_type_AndroidAppDialog != null)
    {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
      this.jdField_c_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.c();
    }
    ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.b();
    }
    super.J();
  }
  
  public void N()
  {
    super.N();
    this.ad = true;
  }
  
  public void O()
  {
    super.O();
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.a();
    }
  }
  
  public void R()
  {
    super.R();
    this.ad = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) && (this.q == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.a();
  }
  
  public void S()
  {
    super.S();
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {}
    for (;;)
    {
      return;
      String str = localIntent.getStringExtra("uin");
      int j = localIntent.getIntExtra("uintype", -1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != j))) {}
      for (j = 1; (j != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()); j = 0)
      {
        this.jdField_p_of_type_AndroidViewView = null;
        this.jdField_a_of_type_ComTencentWidgetXListView = null;
        return;
      }
    }
  }
  
  public void T()
  {
    super.T();
  }
  
  public AIOContext a()
  {
    return new HotChatContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  public MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new HotChatMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public TroopGiftPanelForNearby a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
      continue;
      if ((paramInt2 == 8001) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
  }
  
  public void a(View paramView) {}
  
  public void a(com.tencent.imcore.message.Message paramMessage) {}
  
  public void a(SessionInfo paramSessionInfo, DraftTextManager paramDraftTextManager, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    super.a(paramSessionInfo, paramDraftTextManager, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, null);
  }
  
  public void a(ChatMessage paramChatMessage, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(a());
    String str3 = HardCodeUtil.a(2131705610);
    String str4 = paramChatMessage.getExtInfoFromExtStr("hotchat_gender");
    String str1 = str3;
    try
    {
      if (Integer.parseInt(str4) == 1) {
        str1 = HardCodeUtil.a(2131705607);
      }
      localActionSheet.addButton(str1);
      localActionSheet.addButton(HardCodeUtil.a(2131705604), 3);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new HotChatPie.17(this, localActionSheet, paramChatMessage, paramString));
      localActionSheet.show();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        String str2 = str3;
        if (QLog.isColorLevel())
        {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "showHeadLongClickActionSheet, NumberFormatException, genderStr:" + str4);
          str2 = str3;
        }
      }
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    }
    m(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {}
    for (paramObject = "507";; paramObject = "503")
    {
      NearbyFlowerManager.a("gift_aio", "clk_icon", d(), paramObject, "", "");
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)a().getSystemService("input_method");
    View localView = a().getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), new HotChatPie.20(this), false, false, false, this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog = new NearbyGiftPanelDialog(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.jdField_c_of_type_AndroidViewViewGroup, true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.setIsPttRoom(false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a(paramBoolean, false, 4);
    an();
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.ad) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString + paramString4, 2, "onKickHotChatMember.isSuccess=" + paramBoolean + ",groupuin=" + paramString1 + ",result=" + paramInt + ",memberuin=" + paramString2 + ",strError=" + paramString3);
    }
    if ((this.jdField_d_of_type_AndroidAppDialog != null) && (this.jdField_d_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_d_of_type_AndroidAppDialog.dismiss();
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      QQToast.a(a(), HardCodeUtil.a(2131705590), 0).b(a().getTitleBarHeight());
      return;
    }
    QQToast.a(a(), HardCodeUtil.a(2131705592), 0).b(a().getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    super.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    while (this.ad) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed = true;
      ThreadManager.post(new HotChatPie.15(this), 8, null, true);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.P, null);
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
              if (!paramString3.startsWith("https://")) {
                paramString1 = "https://" + paramString3;
              }
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString2, paramString1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b = false;
        }
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.B = false;
    ((FastImageHelper)a(83)).a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseTroopMsgObserver = new BaseTroopMsgObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare = new HotChatShare(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport = new TroopUsingTimeReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    return super.a(paramBoolean);
  }
  
  public void aM()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a();
    }
  }
  
  public void ae()
  {
    int k = 1;
    bv();
    bk();
    super.ae();
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    NearbyTransitActivity.a("AIOShow", 2);
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    a((Intent)localObject, ((Intent)localObject).getStringExtra("uin"), ((Intent)localObject).getStringExtra("uinname"), ((Intent)localObject).getStringExtra("hotnamecode"), ((Intent)localObject).getBooleanExtra("param_newly_created_hot_chat", false));
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a()) {
      ThreadManager.post(new HotChatPie.9(this), 8, null, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
    bo();
    int j;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      j = k;
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.need2ReqRedPoint())
      {
        ThreadManager.post(new HotChatPie.10(this), 8, null, true);
        j = k;
      }
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (j == 0) {
        break label248;
      }
    }
    label248:
    for (localObject = "2";; localObject = "1")
    {
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject, "", "", "");
      return;
      b(1, false);
      j = 0;
      break;
    }
  }
  
  public void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseTroopMsgObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseTroopMsgObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
  }
  
  public void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      HtmlOffline.a("2586", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new HotChatPie.7(this), true, 0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.jdField_o_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    super.b(paramIntent);
  }
  
  public void bj()
  {
    super.bj();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131693233));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state != 0)) {
      ThreadManager.post(new HotChatPie.8(this), 5, null, false);
    }
  }
  
  public void bv()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if (localHotChatInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a();
      if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("param_newly_created_hot_chat", false)) {
        ThreadManager.post(new HotChatPie.16(this, localHotChatInfo), 8, null, true);
      }
    }
  }
  
  public void bw()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230);
    localQQCustomDialog.setMessage(String.format("需要等级LV%d才能使用闪照功能哦", new Object[] { Integer.valueOf(HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) }));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131705600), new HotChatPie.18(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131705593), new HotChatPie.19(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "HotChatPie";
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    this.jdField_n_of_type_Int = paramInt2;
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true);
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("PttShow", new Object[] { "HotChatPie_updateSession_business HotChatInfo is null", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
      }
      b(0);
    }
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_o_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate;
          if ((paramIntent != null) && (paramIntent.getIntExtra("hot_chat_from", 1) == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.c())) {
            HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isRobotHotChat);
        this.jdField_f_of_type_JavaLangString = ("" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.robotUin);
        this.g = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.g, this, new HotChatPie.2(this));
        paramIntent = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
        paramIntent.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.g);
        paramIntent = paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
      } while (paramIntent == null);
      try
      {
        new cmd0x934.RspBody().mergeFrom(paramIntent);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramIntent) {}
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, paramIntent.getMessage());
  }
  
  public void e(Intent paramIntent)
  {
    this.Z = paramIntent.getBooleanExtra("abp_flag", false);
    this.aa = paramIntent.getBooleanExtra("is_from_web", false);
    if ((this.aa) && (!this.Z))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690601);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131705599));
      return;
    }
    if (this.Z)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705611));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131705597));
      return;
    }
    super.e(paramIntent);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.Z)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
      }
      HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.Z);
      return;
    }
    super.e(paramBoolean);
  }
  
  public boolean g()
  {
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a();
      bool1 = true;
    }
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return bool1;
          bool2 = super.g();
          bool1 = bool2;
        } while (this.i);
        bool1 = bool2;
      } while (!this.Z);
      bool1 = bool2;
    } while (bool2);
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.Z);
    return bool2;
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = super.handleMessage(paramMessage);
    }
    return bool;
  }
  
  public int k()
  {
    return this.q;
  }
  
  public void m(int paramInt)
  {
    super.m(paramInt);
  }
  
  public void m(boolean paramBoolean)
  {
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int j;
    QQAppInterface localQQAppInterface;
    if (paramInt == 2131368555)
    {
      j = 1;
      b(j, true);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramInt != 2131368555) {
        break label80;
      }
    }
    label80:
    for (String str = "clk_hot_room";; str = "clk_see_post")
    {
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", str, 0, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      j = 2;
      break;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == '@') || (paramCharSequence.charAt(paramInt1) == 65312)) && (!this.jdField_o_of_type_Boolean))
    {
      paramCharSequence = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if (paramCharSequence != null) {}
      for (paramCharSequence = paramCharSequence.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; paramCharSequence = null)
      {
        if (paramCharSequence != null)
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://nearby.qq.com/hot_chat/member_list.html", "_wv", "3"), "_bid", "2581"), "gc", paramCharSequence.troopUin), "rid", paramCharSequence.uuid), "from", String.valueOf(1)));
          paramCharSequence = new Bundle();
          paramCharSequence.putBoolean("hide_left_button", true);
          localIntent.putExtras(paramCharSequence);
          a().startActivity(localIntent);
        }
        return;
      }
    }
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum > 0)) {}
    for (int j = 1;; j = 0)
    {
      b(true);
      if (j == 0) {
        break;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131693245), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum) }));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
      n(false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) && (paramObject != null) && ((paramObject instanceof MessageRecord)) && (this.q == 2)) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new HotChatPie.14(this));
    }
  }
  
  public void v()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public boolean v()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d())
    {
      bw();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005DD2", "0X8005DD2", 0, 0, "", "", "", "");
    }
    return bool;
  }
  
  public void z()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a((String)localObject)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid)))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://nearby.qq.com/hot_chat/room_info.html", "_wv", "3"), "_bid", "2581"), "gc", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin), "rid", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid), "rname", this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name), "rtype", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.hotChatType)), "rnum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memberCount)));
      a().startActivity((Intent)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004414", "0X8004414", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isGameRoom) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "clk_grp_card", 0, 0, "", "", "", "");
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), HardCodeUtil.a(2131705609), 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie
 * JD-Core Version:    0.7.0.1
 */