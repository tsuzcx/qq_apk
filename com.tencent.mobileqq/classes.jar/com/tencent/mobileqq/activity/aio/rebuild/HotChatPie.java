package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.adapter.HotChatPostListAdapter;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.view.ApolloGameHotChatController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
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
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.SegmentedControlView;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import java.util.Observable;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;
import vzu;
import vzv;
import vzw;
import vzx;
import vzy;
import vzz;
import waa;
import wab;
import wac;
import wad;
import wag;
import wah;
import wai;
import waj;
import wak;
import wal;
import wam;
import wan;
import wao;
import wap;
import waq;
import war;

public class HotChatPie
  extends BaseTroopChatPie
  implements RadioGroup.OnCheckedChangeListener
{
  protected static final String[] a;
  public static long j;
  ViewPluginManager jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = null;
  private BaseTroopChatPie.BaseTroopMsgObserver jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie$BaseTroopMsgObserver;
  public HotChatPostListAdapter a;
  public HotChatManager a;
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new wab(this);
  public HotChatShare a;
  public HotchatSCHelper a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new vzu(this);
  public HotChatInfo a;
  public NearbyGiftPanelDialog a;
  public TroopGiftPanelForNearby a;
  public RedDotRadioButton a;
  protected TroopUsingTimeReport a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  SegmentedControlView jdField_a_of_type_ComTencentWidgetSegmentedControlView;
  public XListView a;
  public boolean aa;
  public boolean ab;
  boolean ac = false;
  boolean ad;
  boolean ae = false;
  public RedDotRadioButton b;
  Dialog g;
  public Dialog h;
  long i;
  public String i;
  public TextView l;
  public int p;
  public int q;
  View q;
  public int r;
  View r;
  public int s = -1;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "@all", "@全体成员" };
  }
  
  public HotChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_i_of_type_Long = 0L;
    this.jdField_q_of_type_AndroidViewView = null;
    this.jdField_r_of_type_Int = 0;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramInt == 1)
    {
      if (this.jdField_r_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_r_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      this.s = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()))
      {
        b(131072);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (paramBoolean))
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) {
          break label201;
        }
        str = "2";
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, str, "", "", "");
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "hot_room", "exp_visit_post", 0, 0, "", "", "", "");
      return;
      label201:
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
        bc();
        ai();
        if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.clearRedPoint();
        }
        this.s = 2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
          this.jdField_r_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
        }
      }
    }
  }
  
  private void bc()
  {
    if (this.jdField_r_of_type_AndroidViewView == null) {
      this.jdField_r_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969030, null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_r_of_type_AndroidViewView.findViewById(2131364812));
      this.l = ((TextView)this.jdField_r_of_type_AndroidViewView.findViewById(2131363120));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969237, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTextColor(-1, -1, -1, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setArrowColor(-1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(10);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838596));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(30);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new wam(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new wan(this));
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_r_of_type_AndroidViewView) == -1)
    {
      localLayoutParams.addRule(6, 2131363526);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_r_of_type_AndroidViewView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(8);
    }
    int k;
    if (SharedPreUtils.ag(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)
    {
      k = 1;
      if (k == 0) {
        break label395;
      }
      if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager == null)
      {
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = new ViewPluginManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "QQ_Hotchat_post_list.apk", "2586", "/hotchatPostListPlugin/opt");
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a(new wao(this), false);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() == 8) || ((this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.getCount() == 0))) {
        d(0, 10);
      }
      return;
      k = 0;
      break;
      label395:
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter = new HotChatPostListAdapter(this.jdField_a_of_type_AndroidContentContext, null, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter);
      }
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new wak(this, paramInt2, paramInt1), 8, null, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPieQ.hotchat.aio_post_list_req", 2, "getPostListFromServer start: " + paramInt1 + "|num:" + paramInt2);
    }
  }
  
  private void o(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.jdField_q_of_type_AndroidViewView == null) {
        this.jdField_q_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969487, null);
      }
      if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(14);
        localLayoutParams.topMargin = 32;
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_q_of_type_AndroidViewView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a();
        this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = ((SegmentedControlView)this.jdField_q_of_type_AndroidViewView.findViewById(2131366691));
      }
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.jdField_q_of_type_AndroidViewView.findViewById(2131366692));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(true);
        this.s = 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)this.jdField_q_of_type_AndroidViewView.findViewById(2131366693));
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setOnCheckedChangeListener(this);
      return;
    }
    if ((this.jdField_q_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.jdField_q_of_type_AndroidViewView) != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.jdField_q_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  private void r(boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new wal(this, paramBoolean));
  }
  
  private void s(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, new Object[] { "[changeSubTitleJumpAnimation] isNeedJump=", Boolean.valueOf(paramBoolean) });
    }
    Object localObject;
    if ((this.jdField_f_of_type_AndroidWidgetImageView != null) && (this.jdField_f_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      localObject = this.jdField_f_of_type_AndroidWidgetImageView.getDrawable();
      if ((localObject instanceof AnimationDrawable))
      {
        localObject = (AnimationDrawable)localObject;
        if (!paramBoolean) {
          break label83;
        }
        if (!((AnimationDrawable)localObject).isRunning()) {
          ((AnimationDrawable)localObject).start();
        }
      }
    }
    label83:
    while (!((AnimationDrawable)localObject).isRunning()) {
      return;
    }
    ((AnimationDrawable)localObject).stop();
  }
  
  protected void D()
  {
    super.D();
    this.ae = true;
  }
  
  protected void E()
  {
    super.E();
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.a();
    }
    if (((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a().a()) {
      s(false);
    }
  }
  
  protected void G()
  {
    super.G();
    this.ae = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()) && (this.s == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.a();
    if (((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a().a()) {
      s(true);
    }
  }
  
  protected void H()
  {
    super.H();
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {}
    for (;;)
    {
      return;
      String str = localIntent.getStringExtra("uin");
      int k = localIntent.getIntExtra("uintype", -1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != k))) {}
      for (k = 1; (k != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()); k = 0)
      {
        this.jdField_r_of_type_AndroidViewView = null;
        this.jdField_a_of_type_ComTencentWidgetXListView = null;
        return;
      }
    }
  }
  
  public void I()
  {
    super.I();
  }
  
  public void N()
  {
    super.N();
    if (this.s == 2) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    }
  }
  
  protected void X()
  {
    bk();
    aZ();
    super.X();
    this.jdField_i_of_type_Long = SystemClock.elapsedRealtime();
    NearbyTransitActivity.a("AIOShow", 2);
    Object localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    Object localObject1 = ((Intent)localObject2).getStringExtra("uin");
    Object localObject3 = ((Intent)localObject2).getStringExtra("uinname");
    String str = ((Intent)localObject2).getStringExtra("hotnamecode");
    boolean bool = ((Intent)localObject2).getBooleanExtra("param_newly_created_hot_chat", false);
    if ((!this.ad) && (bool) && (((Intent)localObject2).getBooleanExtra("param_newly_created_hot_chat", false)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty(str)))
    {
      localObject2 = ShareHotChatGrayTips.makeShareGrayTip("你的热聊房间会被推荐给附近的人和好友，感兴趣的会加入进来哦。你也可以邀请好友加入。分享热聊房间", "分享热聊房间", (String)localObject1, (String)localObject3, HotChatHelper.a(str, 1), str);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.ad = true;
        localObject3 = MessageRecordFactory.a(-2033);
        long l1 = MessageCache.a();
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ((MessageRecord)localObject3).init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, (String)localObject2, l1, -2033, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l1);
        ((MessageRecord)localObject3).isread = true;
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject3, str);
        }
      }
      this.jdField_g_of_type_AndroidAppDialog = HotChatHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, new war(this, (String)localObject1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a()) {
      ThreadManager.post(new vzv(this), 8, null, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.pkFlag != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper == null)
      {
        ThreadManager.post(new vzw(this), 5, null, true);
        localObject1 = new vzx(this);
        this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper = new HotchatSCHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (HotchatSCHelper.OnShowNoteListener)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.a(10000L);
    }
    int k;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.need2ReqRedPoint()) {
        ThreadManager.post(new vzy(this), 8, null, true);
      }
      k = 1;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (k == 0) {
        break label511;
      }
    }
    label511:
    for (localObject1 = "2";; localObject1 = "1")
    {
      ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject1, "", "", "");
      return;
      b(1, false);
      k = 0;
      break;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  public void a(View paramView)
  {
    ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a().d();
  }
  
  protected void a(SessionInfo paramSessionInfo, DraftTextManager paramDraftTextManager, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    super.a(paramSessionInfo, paramDraftTextManager, paramCharSequence, paramQQAppInterface, paramString, paramSourceMsgInfo);
  }
  
  protected void a(QQMessageFacade.Message paramMessage) {}
  
  public void a(ChatMessage paramChatMessage, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.a(a());
    str3 = "@他";
    str4 = paramChatMessage.getExtInfoFromExtStr("hotchat_gender");
    String str1 = str3;
    try
    {
      if (Integer.parseInt(str4) == 1) {
        str1 = "@她";
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        String str2 = str3;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.aio.BaseTroopChatPie", 2, "showHeadLongClickActionSheet, NumberFormatException, genderStr:" + str4);
          str2 = str3;
        }
      }
    }
    localActionSheet.c(str1);
    localActionSheet.a("删除成员", 3);
    localActionSheet.c(2131433029);
    localActionSheet.a(new wad(this, localActionSheet, paramChatMessage, paramString));
    localActionSheet.show();
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby = new TroopGiftPanelForNearby(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), new waj(this), false, false, false, this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog = new NearbyGiftPanelDialog(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby, this.c, true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftTroopGiftPanelForNearby.setIsPttRoom(false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a(paramBoolean, false, 4);
    ai();
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.ae) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.BaseTroopChatPie" + paramString4, 2, "onKickHotChatMember.isSuccess=" + paramBoolean + ",groupuin=" + paramString1 + ",result=" + paramInt + ",memberuin=" + paramString2 + ",strError=" + paramString3);
    }
    if ((this.jdField_h_of_type_AndroidAppDialog != null) && (this.jdField_h_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_h_of_type_AndroidAppDialog.dismiss();
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      QQToast.a(a(), "删除热聊成员成功", 0).b(a().getTitleBarHeight());
      return;
    }
    QQToast.a(a(), "删除热聊成员失败", 0).b(a().getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    super.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    while (this.ae) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.memoShowed = true;
      ThreadManager.post(new waa(this), 8, null, true);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = new TroopFeedsCenterLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.Q, null);
        }
        paramString1 = paramString3;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1 = paramString3;
          if (!paramString3.startsWith("mqqapi"))
          {
            paramString1 = paramString3;
            if (!paramString3.startsWith("http://")) {
              paramString1 = "http://" + paramString3;
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
  
  protected boolean a(boolean paramBoolean)
  {
    this.C = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie$BaseTroopMsgObserver = new BaseTroopChatPie.BaseTroopMsgObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare = new HotChatShare(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport = new TroopUsingTimeReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    return super.a(paramBoolean);
  }
  
  public void aH()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a();
    }
  }
  
  void aY()
  {
    super.aY();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131437344));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state != 0)) {
      ThreadManager.post(new waq(this), 5, null, false);
    }
  }
  
  public void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie$BaseTroopMsgObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
  }
  
  public void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseTroopChatPie$BaseTroopMsgObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
  }
  
  protected void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      HtmlOffline.a("2586", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new wap(this), true, 0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetSegmentedControlView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.jdField_q_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    super.b(paramIntent);
  }
  
  public void bk()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
    if (localHotChatInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a();
      if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("param_newly_created_hot_chat", false)) {
        ThreadManager.post(new wac(this, localHotChatInfo), 8, null, true);
      }
    }
  }
  
  public void bl()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230);
    localQQCustomDialog.setMessage(String.format("需要等级LV%d才能使用闪照功能哦", new Object[] { Integer.valueOf(HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) }));
    localQQCustomDialog.setNegativeButton("知道了", new wag(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton("去看攻略", new wai(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    this.p = paramInt2;
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
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
          this.jdField_q_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate;
          if ((paramIntent != null) && (paramIntent.getIntExtra("hot_chat_from", 1) == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.c())) {
            HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isRobotHotChat);
        this.jdField_f_of_type_JavaLangString = ("" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.robotUin);
        this.jdField_g_of_type_JavaLangString = ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this, new wah(this));
        paramIntent = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
        paramIntent.a(true);
        paramIntent = paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
      } while (paramIntent == null);
      try
      {
        cmd0x934.RspBody localRspBody = new cmd0x934.RspBody();
        localRspBody.mergeFrom(paramIntent);
        if (localRspBody.lists.size() <= 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(27, 0);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramIntent) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.aio.BaseTroopChatPie", 2, paramIntent.getMessage());
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildVisible(27, 8);
  }
  
  protected void e(Intent paramIntent)
  {
    this.aa = paramIntent.getBooleanExtra("abp_flag", false);
    this.ab = paramIntent.getBooleanExtra("is_from_web", false);
    if ((this.ab) && (!this.aa))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131432425);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回");
      return;
    }
    if (this.aa)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("热聊");
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回热聊");
      return;
    }
    super.e(paramIntent);
  }
  
  protected void e(boolean paramBoolean)
  {
    if (this.aa)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
      }
      HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.aa);
      return;
    }
    super.e(paramBoolean);
  }
  
  protected boolean e()
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
          bool2 = super.e();
          bool1 = bool2;
        } while (this.jdField_i_of_type_Boolean);
        bool1 = bool2;
      } while (!this.aa);
      bool1 = bool2;
    } while (bool2);
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, this.aa);
    return bool2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = super.handleMessage(paramMessage);
    }
    return bool;
  }
  
  public int i()
  {
    return this.s;
  }
  
  protected void j(int paramInt)
  {
    super.j(paramInt);
    ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a().a(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("startApolloGame", false));
  }
  
  public void k(boolean paramBoolean)
  {
    a(paramBoolean, 0);
  }
  
  protected void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum > 0)) {}
    for (int k = 1;; k = 0)
    {
      b(true);
      if (k == 0) {
        break;
      }
      this.e.setVisibility(0);
      this.e.setText(String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131437336), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.mFissionRoomNum) }));
      this.e.setTextSize(1, 12.0F);
      return;
    }
    this.e.setVisibility(8);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int k;
    QQAppInterface localQQAppInterface;
    if (paramInt == 2131366692)
    {
      k = 1;
      b(k, true);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramInt != 2131366692) {
        break label62;
      }
    }
    label62:
    for (paramRadioGroup = "clk_hot_room";; paramRadioGroup = "clk_see_post")
    {
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", paramRadioGroup, 0, 0, "", "", "", "");
      return;
      k = 2;
      break;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == '@') || (paramCharSequence.charAt(paramInt1) == 65312)) && (!this.o))
    {
      paramCharSequence = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if (paramCharSequence != null) {}
      for (paramCharSequence = paramCharSequence.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; paramCharSequence = null)
      {
        if (paramCharSequence != null)
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("http://nearby.qq.com/hot_chat/member_list.html", "_wv", "3"), "_bid", "2581"), "gc", paramCharSequence.troopUin), "rid", paramCharSequence.uuid), "from", String.valueOf(1)));
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
  
  protected void p()
  {
    this.d.setVisibility(4);
  }
  
  public void p(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, new Object[] { "[setSubTitleIconVisible] visible=", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean)
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return;
    }
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  public void q(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, new Object[] { "[changeSubTitleDrawable] isBarShow=", Boolean.valueOf(paramBoolean) });
    }
    Object localObject = (LinearLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetImageView.getLayoutParams();
    this.jdField_f_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    if (paramBoolean)
    {
      localObject = this.jdField_f_of_type_AndroidWidgetImageView.getDrawable();
      if ((localObject instanceof AnimationDrawable)) {
        ((AnimationDrawable)localObject).stop();
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841494);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        ((Drawable)localObject).clearColorFilter();
      }
      for (;;)
      {
        ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
      }
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841501);
      ((Drawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    localObject = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841500);
    ((AnimationDrawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    ((AnimationDrawable)localObject).start();
  }
  
  public void s()
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
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "你已不在该热聊", 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public boolean t()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.d())
    {
      bl();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005DD2", "0X8005DD2", 0, 0, "", "", "", "");
    }
    return bool;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
      l(false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) && (paramObject != null) && ((paramObject instanceof MessageRecord)) && (this.s == 2)) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new vzz(this));
    }
  }
  
  protected void v()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
    }
  }
  
  public boolean y()
  {
    return true;
  }
  
  protected void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b();
      this.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      b(1, false);
      if ((this.jdField_q_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.indexOfChild(this.jdField_q_of_type_AndroidViewView) != -1)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.removeView(this.jdField_q_of_type_AndroidViewView);
      }
      this.jdField_q_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentWidgetSegmentedControlView = null;
      this.jdField_r_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter = null;
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = null;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_i_of_type_Long;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006587", "0X8006587", 0, 0, String.valueOf(l1 - l2), String.valueOf(this.jdField_q_of_type_Int), "", "");
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("open_chatfragment_fromphoto", false))) || (this.jdField_h_of_type_AndroidAppDialog != null))
    {
      this.jdField_h_of_type_AndroidAppDialog.dismiss();
      this.jdField_h_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_g_of_type_AndroidAppDialog != null)
    {
      this.jdField_g_of_type_AndroidAppDialog.dismiss();
      this.jdField_g_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatShare.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter.c();
    }
    ((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.b();
    }
    ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a().a(this);
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie
 * JD-Core Version:    0.7.0.1
 */