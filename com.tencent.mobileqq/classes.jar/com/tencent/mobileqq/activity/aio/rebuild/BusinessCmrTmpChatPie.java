package com.tencent.mobileqq.activity.aio.rebuild;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.helper.CmrHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class BusinessCmrTmpChatPie
  extends FriendChatPie
{
  long bC = 0L;
  protected NewIntent bD = null;
  protected LinearLayout bE;
  protected CustomMenuBar bF;
  protected ImageView bG;
  protected ImageView bH;
  protected View bI;
  protected TextView bJ;
  protected TextView bK;
  protected LinearLayout bL;
  protected ImageView bM;
  protected ImageView bN;
  public View bO;
  public Handler bP = new BusinessCmrTmpChatPie.1(this);
  List<StructMsg.ButtonInfo> bQ = null;
  QidianManager bR;
  FriendsManager bS;
  protected MessageObserver bT = new BusinessCmrTmpChatPie.8(this);
  public EnterpriseQQObserver bU = new BusinessCmrTmpChatPie.12(this);
  public PublicAccountInfo bV;
  protected MessageObserver bW = new BusinessCmrTmpChatPie.14(this);
  public QidianBusinessObserver bX = new BusinessCmrTmpChatPie.16(this);
  private boolean bY = false;
  private boolean bZ = false;
  private IPublicAccountObserver ca = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
  private ShieldListObserver cb = new BusinessCmrTmpChatPie.6(this);
  private int cc = 0;
  private boolean cd = false;
  private CardObserver ce = new BusinessCmrTmpChatPie.15(this);
  
  public BusinessCmrTmpChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.ca.setOnCallback(new BusinessCmrTmpChatPie.2(this));
  }
  
  private void a(EqqDetail paramEqqDetail)
  {
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1)) {
      bF();
    }
  }
  
  private void bM()
  {
    Object localObject;
    if (this.bR.m(this.ah.b))
    {
      this.bL.setVisibility(8);
      if (this.Y != null)
      {
        AIOUtils.a(this.Y, 2130851969);
        t();
      }
      if (this.W != null)
      {
        this.W.setCustomHeight(PanelIconLinearLayout.b);
        bN();
      }
      if (this.X != null) {
        this.X.setBackgroundColor(Color.parseColor("#00000000"));
      }
      localObject = this.f.getResources();
      if (this.Y != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Y.getLayoutParams();
        localLayoutParams.bottomMargin = 0;
        localLayoutParams.topMargin = 1;
        localLayoutParams.leftMargin = AIOUtils.b(8.0F, (Resources)localObject);
        localLayoutParams.gravity = 80;
        this.Y.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      this.bL.setVisibility(0);
      if (this.Y != null)
      {
        AIOUtils.a(this.Y, 2130852110);
        if (CustomMenuBar.a()) {
          this.X.setBackgroundColor(this.f.getResources().getColor(2131168198));
        }
        bI();
      }
      if (this.W != null)
      {
        this.W.setCustomHeight(0);
        bN();
      }
      if (this.Y != null)
      {
        localObject = (FrameLayout.LayoutParams)this.Y.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
        ((FrameLayout.LayoutParams)localObject).topMargin = 1;
        ((FrameLayout.LayoutParams)localObject).gravity = 16;
        this.Y.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void bN()
  {
    int i;
    if ((this.W != null) && (this.W.getVisibility() == 0) && (this.W.a > 0)) {
      i = 0;
    } else {
      i = AIOUtils.b(8.0F, this.f.getResources());
    }
    if (this.X.getPaddingBottom() != i) {
      this.X.setPadding(this.X.getPaddingLeft(), this.X.getPaddingTop(), this.X.getPaddingRight(), i);
    }
  }
  
  private void bO()
  {
    this.f.getLayoutInflater().inflate(2131624127, this.o);
    this.bO = this.o.findViewById(2131439749);
    this.bF = ((CustomMenuBar)this.o.findViewById(2131432703));
    Object localObject = this.o.findViewById(2131432702);
    ((View)localObject).setOnClickListener(new BusinessCmrTmpChatPie.9(this));
    this.bF.setCoverView((View)localObject);
    this.bF.setOnMenuItemClickListener(new BusinessCmrTmpChatPie.10(this));
    this.bF.setOnBackClickListner(new BusinessCmrTmpChatPie.11(this));
    if (this.f.getIntent().getBooleanExtra("crm_ivr_aio_video_action_sheet", false)) {
      CrmUtils.a(this.d, this.f, this.ah);
    } else if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "We needn't show video action sheet, because isShowVideoActionSheet is false");
    }
    this.bL = ((LinearLayout)this.aZ.findViewById(2131440826));
    localObject = (LinearLayout.LayoutParams)this.bL.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.bL.setVisibility(0);
    this.bL.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.Z.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 1;
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.Z.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.Y.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 1;
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.Y.setLayoutParams((ViewGroup.LayoutParams)localObject);
    View localView = this.i.p().d().c().a();
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = this.X.getHeight();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      ((FrameLayout.LayoutParams)localObject).topMargin = 1;
      ((FrameLayout.LayoutParams)localObject).gravity = 16;
      localView.setLayoutParams(localLayoutParams);
    }
    this.bG = ((ImageView)this.bL.findViewById(2131432704));
    this.bG.setOnClickListener(this);
    if (CustomMenuBar.a())
    {
      this.bF.setBackgroundColor(this.f.getResources().getColor(2131168198));
      this.bF.setMinimumHeight(AIOUtils.b(48.0F, this.f.getResources()));
    }
    this.bN = ((ImageView)this.bL.findViewById(2131440441));
    this.bN.setOnClickListener(this);
    this.bM = ((ImageView)this.bL.findViewById(2131432400));
    this.bM.setOnClickListener(this);
    if (!CustomMenuBar.a())
    {
      this.bM.setImageResource(2130849798);
      this.bN.setImageResource(2130838012);
    }
    if (this.Y != null)
    {
      AIOUtils.a(this.Y, 2130852110);
      if (CustomMenuBar.a()) {
        this.X.setBackgroundColor(this.f.getResources().getColor(2131168198));
      }
    }
  }
  
  private void bP()
  {
    if (ChatActivityUtils.a(this.d, this.ah.a, this.ah.b, this.ah.f))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "checkNavigationMenuUpdate msg shielded");
      }
      return;
    }
    if (!this.bZ)
    {
      this.bZ = true;
      long l1 = Long.parseLong(this.ah.b);
      PubAccountNavigationMenu localPubAccountNavigationMenu = ((QidianPubAccountBigDataHandler)this.d.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER)).a(this.ah.b);
      QidianHandler localQidianHandler = (QidianHandler)this.d.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
      long l2 = this.d.getLongAccountUin();
      int i;
      if (localPubAccountNavigationMenu != null) {
        i = localPubAccountNavigationMenu.version;
      } else {
        i = 0;
      }
      localQidianHandler.a(l1, l2, i, this.cc, false);
    }
  }
  
  private void v(int paramInt)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
    Object localObject2 = BaseApplicationImpl.getApplication().getResources();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 26);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(paramInt);
    ((Bundle)localObject1).putString("key_action_DATA", ((StringBuilder)localObject3).toString());
    localObject3 = ((Resources)localObject2).getString(2131891488);
    localObject2 = ((Resources)localObject2).getString(2131891489);
    localMessageForGrayTips.init(this.d.getCurrentAccountUin(), this.ah.b, this.d.getCurrentAccountUin(), (String)localObject3, NetConnInfoCenter.getServerTime(), -2064, 0, 0L);
    paramInt = ((String)localObject3).indexOf((String)localObject2);
    localMessageForGrayTips.addHightlightItem(paramInt, ((String)localObject2).length() + paramInt, (Bundle)localObject1);
    localObject1 = new ArrayList();
    ((List)localObject1).add(localMessageForGrayTips);
    this.d.getMessageFacade().b((List)localObject1, this.d.getCurrentAccountUin());
  }
  
  public void B()
  {
    if (this.bR.m(this.ah.b))
    {
      Intent localIntent = new Intent(this.e, ChatSettingActivity.class);
      localIntent.putExtra("uin", this.ah.b);
      localIntent.putExtra("uinname", this.ah.e);
      int i;
      if (this.bS.n(this.ah.b)) {
        i = 0;
      } else {
        i = this.ah.a;
      }
      localIntent.putExtra("uintype", i);
      this.f.startActivityForResult(localIntent, 2000);
      return;
    }
    ReportController.b(this.d, "CliOper", "", "", "Biz_card", "Open_biz_card", 0, 0, this.ah.b, "", "", "");
    CrmUtils.a(this.f, null, this.ah.b, true, -1, true, 2000);
  }
  
  protected void D()
  {
    a(this.u, 2130852269, 2130852270);
  }
  
  public void K()
  {
    super.K();
    if ((this.bH != null) && (this.X != null))
    {
      this.X.removeView(this.bH);
      this.bH = null;
    }
    QidianManager localQidianManager = this.bR;
    if ((localQidianManager != null) && (localQidianManager.m(this.ah.b))) {
      ((QidianHandler)this.d.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(this.ah.b, null, true);
    }
    if (this.X != null) {
      this.X.setPadding(this.X.getPaddingLeft(), this.X.getPaddingTop(), this.X.getPaddingRight(), 0);
    }
  }
  
  protected void Q()
  {
    super.Q();
    int j = ImmersiveUtils.getStatusBarHeight(this.e);
    LinearLayout localLinearLayout = this.bE;
    int i = j;
    if (localLinearLayout != null)
    {
      i = j;
      if (localLinearLayout.getVisibility() == 0) {
        i = (int)this.f.getResources().getDimension(2131297461);
      }
    }
    this.k.d().a(i);
  }
  
  public void U()
  {
    super.U();
    if ((this.bH != null) && (this.X != null))
    {
      this.X.removeView(this.bH);
      this.bH = null;
    }
    CustomMenuBar localCustomMenuBar = this.bF;
    if (localCustomMenuBar != null) {
      localCustomMenuBar.c();
    }
  }
  
  public boolean V()
  {
    CustomMenuBar localCustomMenuBar = this.bF;
    if (localCustomMenuBar != null) {
      localCustomMenuBar.d();
    }
    return super.V();
  }
  
  void a(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.Y.getLineCount() > 1))
    {
      t(80);
      return;
    }
    t(16);
  }
  
  public void a(PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if ((paramPubAccountNavigationMenu != null) && (paramPubAccountNavigationMenu.xml != null) && (paramPubAccountNavigationMenu.xml.length() > 0) && (this.ah != null) && (this.ah.b != null) && (this.ah.b.equals(String.valueOf(paramPubAccountNavigationMenu.puin))))
    {
      try
      {
        localObject = this.d.getMessageFacade();
        paramPubAccountNavigationMenu = StructMsgFactory.a(this.d, this.ah.a, Long.parseLong(this.ah.b), paramPubAccountNavigationMenu.xml.getBytes(), 0);
        if (paramPubAccountNavigationMenu == null) {
          return;
        }
        long l = MobileQQService.seq;
        paramPubAccountNavigationMenu = MessageRecordFactory.c(this.d, this.ah.b, this.ah.b, this.ah.b, this.ah.a, l, paramPubAccountNavigationMenu);
        if (paramPubAccountNavigationMenu == null) {
          return;
        }
        paramPubAccountNavigationMenu.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
        ((QQMessageFacade)localObject).a(paramPubAccountNavigationMenu, this.d.getCurrentAccountUin());
        return;
      }
      catch (Exception paramPubAccountNavigationMenu)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Add message error: ");
      ((StringBuilder)localObject).append(paramPubAccountNavigationMenu.getMessage());
      QLog.d("BusinessChatPie", 2, ((StringBuilder)localObject).toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("BusinessChatPie", 2, "showNavigationMenu not current uin or xml is null");
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.aJ = false;
    this.bR = ((QidianManager)this.d.getManager(QQManagerFactory.QIDIAN_MANAGER));
    this.bS = ((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER));
    super.a(paramBoolean);
    if (!this.f.isFinishing())
    {
      bO();
      if (!this.bR.m(ae()))
      {
        bI();
        EnterpriseQQManager.a(this.d).a(this.d, ae(), false);
      }
    }
    this.bY = this.bR.m(this.ah.b);
    bK();
    Object localObject;
    if (!this.bR.m(this.ah.b))
    {
      this.f.sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
      localObject = new BusinessCmrTmpChatPie.3(this);
      CrmUtils.a(this.d, this.f, this.ah.b, this.ah.a, (BusinessObserver)localObject);
      if (this.W != null)
      {
        this.W.setCustomHeight(0);
        bN();
      }
    }
    else
    {
      localObject = new BmqqAccountType(this.ah.b, 6);
      this.bR.a(this.f, (BmqqAccountType)localObject);
    }
    bM();
    bL();
    return true;
  }
  
  protected void au()
  {
    super.au();
    this.d.addObserver(this.bT);
    this.d.addObserver(this.bU);
    this.d.addObserver(this.bW);
    this.d.addObserver(this.ca.getBusinessObserver());
    this.d.addObserver(this.cb);
    this.d.addObserver(this.bX);
    this.d.addObserver(this.ce);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.bT);
    this.d.removeObserver(this.bU);
    this.d.removeObserver(this.bW);
    this.d.removeObserver(this.ca.getBusinessObserver());
    this.d.removeObserver(this.cb);
    this.d.removeObserver(this.bX);
    this.d.removeObserver(this.ce);
  }
  
  protected HelperProvider b()
  {
    return new CmrHelperProvider(this.f);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    bH();
    if (paramInt2 == 8)
    {
      if (this.bN != null)
      {
        if (CustomMenuBar.a())
        {
          this.bN.setImageResource(2130852056);
          return;
        }
        this.bN.setImageResource(2130851978);
      }
    }
    else if (this.bN != null)
    {
      if (CustomMenuBar.a())
      {
        this.bN.setImageResource(2130852055);
        return;
      }
      this.bN.setImageResource(2130851977);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    bC();
  }
  
  public void b(List<StructMsg.ButtonInfo> paramList)
  {
    this.bF.c();
    int i = 0;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.bG.setVisibility(0);
      int j = paramList.size();
      while (i < j)
      {
        if (i > 2) {
          return;
        }
        Object localObject = (StructMsg.ButtonInfo)paramList.get(i);
        MenuItem localMenuItem = new MenuItem(((StructMsg.ButtonInfo)localObject).key.get(), ((StructMsg.ButtonInfo)localObject).name.get(), null, ((StructMsg.ButtonInfo)localObject).id.get());
        if (((StructMsg.ButtonInfo)localObject).sub_button.get().size() > 0)
        {
          localObject = ((StructMsg.ButtonInfo)localObject).sub_button.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)((Iterator)localObject).next();
            localMenuItem.a(new MenuItem(localButtonInfo.key.get(), localButtonInfo.name.get(), null, localButtonInfo.id.get()));
          }
        }
        this.bF.a(localMenuItem, ae());
        i += 1;
      }
      return;
    }
    this.bF.setVisibility(8);
    this.X.setVisibility(0);
    this.bG.setVisibility(8);
  }
  
  protected void bC()
  {
    if (!this.bR.o(this.ah.b))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView don't request qidian master, so wait request show");
      }
      return;
    }
    if (bD())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView true");
      }
      bE();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateFollowAndShieldView false");
    }
    bF();
  }
  
  protected boolean bD()
  {
    Object localObject;
    long l1;
    if ((this.ah.a == 1024) && (!BmqqSegmentUtil.b(this.e, this.ah.b)))
    {
      boolean bool = this.bR.m(this.ah.b);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showOrHideFollow isQidianMasterInCache: ");
        ((StringBuilder)localObject).append(bool);
        QLog.i("ChatActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (bool) {
        return this.bS.n(this.ah.b) ^ true;
      }
      localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.ah.b);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label144:
      break label144;
    }
    if (!((IPublicAccountDataManager)localObject).isFollowedUin(Long.valueOf(l1))) {
      return true;
    }
    return false;
  }
  
  protected void bE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showFollowAndShield() ==== called.");
    }
    String str = this.ah.b;
    if (this.bE == null)
    {
      Object localObject = new BusinessCmrTmpChatPie.4(this);
      this.bE = new LinearLayout(this.e);
      this.bE.setId(2131428151);
      this.bE.setVisibility(8);
      this.bE.setOrientation(0);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams.weight = 1.0F;
      this.bI = this.f.getLayoutInflater().inflate(2131626026, null);
      this.bI.setBackgroundDrawable(this.d.getApplication().getResources().getDrawable(2130838290));
      this.bI.findViewById(2131438136).setVisibility(8);
      this.bJ = ((TextView)this.bI.findViewById(2131438139));
      this.bJ.setTextColor(this.d.getApplication().getResources().getColorStateList(2131168114));
      ((ImageView)this.bI.findViewById(2131438117)).setImageResource(2130842730);
      this.bI.setOnClickListener((View.OnClickListener)localObject);
      this.bE.addView(this.bI, localLayoutParams);
      View localView = this.f.getLayoutInflater().inflate(2131626026, null);
      localView.setBackgroundDrawable(this.d.getApplication().getResources().getDrawable(2130838290));
      this.bK = ((TextView)localView.findViewById(2131438139));
      this.bK.setTextColor(this.d.getApplication().getResources().getColorStateList(2131168114));
      this.bK.setText(this.e.getString(2131888774));
      ((ImageView)localView.findViewById(2131438117)).setImageResource(2130842615);
      localView.setTag(Integer.valueOf(3));
      localView.setOnClickListener((View.OnClickListener)localObject);
      this.bE.addView(localView, localLayoutParams);
      ((RelativeLayout.LayoutParams)this.U.getLayoutParams()).addRule(3, 2131428151);
      localObject = new RelativeLayout.LayoutParams(-1, (int)this.d.getApplication().getResources().getDimension(2131297461));
      ((RelativeLayout.LayoutParams)localObject).topMargin = (this.f.getChatFragment().q().getMeasuredHeight() + this.e.getResources().getDimensionPixelSize(2131299920));
      this.ba.addView(this.bE, (ViewGroup.LayoutParams)localObject);
    }
    if (ChatActivityUtils.a(this.d, this.ah.a, str, this.ah.f))
    {
      this.bJ.setText(this.e.getString(2131886584));
      this.bI.setTag(Integer.valueOf(1));
    }
    else
    {
      this.bJ.setText(this.e.getString(2131888776));
      this.bI.setTag(Integer.valueOf(2));
    }
    if ((this.bK != null) && (this.bR.m(this.ah.b))) {
      this.bK.setText(this.e.getString(2131886467));
    }
    this.bE.setVisibility(0);
    try
    {
      this.U.removeHeaderView(this.bc);
    }
    catch (Exception localException)
    {
      label600:
      break label600;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "removeHeaderView err");
    }
    this.k.d().a((int)this.f.getResources().getDimension(2131297461));
  }
  
  protected void bF()
  {
    LinearLayout localLinearLayout = this.bE;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
    }
    try
    {
      if (this.U.getHeaderViewsCount() != 0) {
        break label55;
      }
      this.U.addHeaderView(this.bc);
    }
    catch (Exception localException)
    {
      label39:
      label55:
      break label39;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "addHeaderView err");
    }
    this.k.d().a(ImmersiveUtils.getStatusBarHeight(this.e));
  }
  
  void bG()
  {
    ChatActivityUtils.b(this.f);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow");
    }
    ((FriendListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.ah.b);
    Object localObject = this.bD;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    this.bD = new NewIntent(this.f.getApplicationContext(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    this.bD.putExtra("cmd", "follow");
    localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).account_type.set(2);
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.ah.b));
    this.bD.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new BusinessCmrTmpChatPie.5(this);
    this.bD.setObserver((BusinessObserver)localObject);
    this.d.startServlet(this.bD);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow exit");
    }
  }
  
  @TargetApi(11)
  protected void bH()
  {
    ImageView localImageView = this.bM;
    if (localImageView == null) {
      return;
    }
    localImageView.setEnabled(true);
    if (this.n.getCurrentPanel() == 3)
    {
      if (CustomMenuBar.a()) {
        this.bM.setImageResource(2130852007);
      } else {
        this.bM.setImageResource(2130852468);
      }
      this.bM.setContentDescription(this.e.getString(2131896460));
    }
    else
    {
      if (CustomMenuBar.a()) {
        this.bM.setImageResource(2130852006);
      } else {
        this.bM.setImageResource(2130852469);
      }
      this.bM.setContentDescription(this.e.getString(2131896459));
    }
    if (VersionUtils.e()) {
      this.bM.setAlpha(1.0F);
    }
  }
  
  public void bI()
  {
    if (this.bQ == null) {
      this.bQ = new ArrayList();
    }
    this.bQ.clear();
    List localList = EnterpriseQQManager.a(this.d).a(this.d, ae());
    if ((localList != null) && (localList.size() > 0)) {
      this.bQ.addAll(localList);
    }
    localList = this.bQ;
    if ((localList != null) && (!localList.isEmpty())) {
      p(true);
    } else {
      p(false);
    }
    b(this.bQ);
  }
  
  public void bJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    Object localObject;
    if (!this.f.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null) {
        this.bV = ((PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(this.ah.b));
      }
    }
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest;
    if (this.bV == null)
    {
      localObject = new NewIntent(this.f.getApplicationContext(), ProtoServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(1);
      localGetEqqDetailInfoRequest.seqno.set(0);
    }
    try
    {
      localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.ah.b));
      label155:
      ((NewIntent)localObject).putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new BusinessCmrTmpChatPie.13(this));
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail");
      }
      this.d.startServlet((NewIntent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): END");
      }
      return;
    }
    catch (Exception localException)
    {
      break label155;
    }
  }
  
  public void bK()
  {
    try
    {
      String str = this.ah.b;
      Object localObject = this.d.getMessageFacade().h(str, 0);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.msgtype == -1013) || (localMessageRecord.msgtype == -1019) || (localMessageRecord.msgtype == -1018) || (localMessageRecord.msgtype == -2019) || (localMessageRecord.msgtype == -7006)) {
            this.d.getMessageFacade().h(str, 0, localMessageRecord.uniseq);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void bL()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessChatPie", 2, "checkNavigationMenuUpdate");
    }
    this.cc = this.j.e().d();
    if (TextUtils.isEmpty(this.ah.b)) {
      return;
    }
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.bC) < 1000L) {
      return;
    }
    this.bC = l;
    this.bZ = false;
    if (this.bR.d(this.ah.b, false)) {
      bP();
    }
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    this.P = true;
    paramIntent = ContactUtils.a(this.d, this.ah.b, this.ah.c, ContactUtils.c(this.ah.a), 3);
    if ((this.ah.a == 1024) && ((paramIntent == null) || (paramIntent.equals(this.ah.b)))) {
      this.al.getFriendInfo(this.ah.b);
    }
  }
  
  protected AIOContext d()
  {
    return new BusinessCmrTmpContext();
  }
  
  protected void d(Intent paramIntent)
  {
    paramIntent.putExtra("uintype", 1024);
    super.d(paramIntent);
    if (!this.bR.m(this.ah.b))
    {
      bJ();
      if (this.W != null)
      {
        this.W.setCustomHeight(0);
        bN();
      }
    }
  }
  
  protected void e(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_updateSession_business");
    paramIntent = paramIntent.getByteArrayExtra("sigt");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("From chatActivity : buinessCrm Sigt--->");
      localStringBuilder.append(HexUtil.bytes2HexStr(paramIntent));
      QLog.d("BusinessChatPie", 2, localStringBuilder.toString());
    }
    if (paramIntent != null)
    {
      this.d.getMsgCache().d(this.ah.b, paramIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("BusinessChatPie", 4, "updateSession()--AIO 已保存 sigt");
      }
    }
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  public void e(String paramString)
  {
    if ((this.d != null) && (this.ah != null))
    {
      PubAccountNavigationMenu localPubAccountNavigationMenu = ((QidianPubAccountBigDataHandler)this.d.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER)).a(this.ah.b);
      if ("1".equals(paramString))
      {
        long l1 = Long.parseLong(this.ah.b);
        paramString = (QidianHandler)this.d.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
        long l2 = this.d.getLongAccountUin();
        int i;
        if (localPubAccountNavigationMenu != null) {
          i = localPubAccountNavigationMenu.version;
        } else {
          i = 0;
        }
        paramString.a(l1, l2, i, 0, true);
        return;
      }
      if (localPubAccountNavigationMenu != null) {
        a(localPubAccountNavigationMenu);
      }
    }
  }
  
  public void l(int paramInt)
  {
    super.l(paramInt);
    ((TempMsgManager)this.d.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(this.ah, this);
    bN();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131432704) {
      p(true);
    }
    if (paramView.getId() == 2131432400) {
      if (this.n.getCurrentPanel() == 3)
      {
        this.n.a(1);
        ReportController.b(this.d, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      }
      else
      {
        this.n.a(3);
        ReportController.b(this.d, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      }
    }
    if (paramView.getId() == 2131440441)
    {
      ShortVideoUtils.loadShortVideoSo(this.d);
      Object localObject = (FastImageHelper)q(83);
      if (this.n.getCurrentPanel() == 8)
      {
        ImageView localImageView = this.bN;
        if (localImageView != null) {
          localImageView.setContentDescription(this.d.getApplication().getString(2131886555));
        }
        ((FastImageHelper)localObject).b(true);
        this.n.a(1);
      }
      else
      {
        ((FastImageHelper)localObject).c();
        this.n.a(8);
        localObject = this.bN;
        if (localObject != null) {
          ((ImageView)localObject).setContentDescription(this.d.getApplication().getString(2131886476));
        }
        m(0);
      }
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p(boolean paramBoolean)
  {
    if (!this.bR.m(this.ah.b))
    {
      if (paramBoolean)
      {
        this.n.b();
        this.bF.setVisibility(0);
        this.X.setVisibility(4);
        return;
      }
      this.bG.setVisibility(0);
    }
  }
  
  public void s(int paramInt)
  {
    Toast.makeText(this.f.getApplicationContext(), paramInt, 0).show();
  }
  
  void t(int paramInt)
  {
    Object localObject = this.bL;
    if (localObject == null) {
      return;
    }
    localObject = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Y.getLayoutParams();
    if (((LinearLayout.LayoutParams)localObject).gravity != paramInt)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = paramInt;
      this.bL.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (localLayoutParams.gravity != paramInt)
    {
      localLayoutParams.gravity = paramInt;
      this.Y.setLayoutParams(localLayoutParams);
    }
    localObject = (LinearLayout.LayoutParams)this.Z.getLayoutParams();
    if (((LinearLayout.LayoutParams)localObject).gravity != paramInt)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = paramInt;
      this.Z.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public StructMsg.ButtonInfo u(int paramInt)
  {
    Object localObject = this.bQ;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return null;
      }
      int i = 0;
      while (i < this.bQ.size())
      {
        localObject = (StructMsg.ButtonInfo)this.bQ.get(i);
        if (((StructMsg.ButtonInfo)localObject).id.get() == paramInt) {
          return localObject;
        }
        localObject = ((StructMsg.ButtonInfo)localObject).sub_button.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int j = 0;
          while (j < ((List)localObject).size())
          {
            if (((StructMsg.ButtonInfo)((List)localObject).get(j)).id.get() == paramInt) {
              return (StructMsg.ButtonInfo)((List)localObject).get(j);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  protected boolean x()
  {
    return true;
  }
  
  protected void z()
  {
    if (this.bR.g(this.ah.b))
    {
      this.A.setOnClickListener(new BusinessCmrTmpChatPie.7(this));
      if (AIOTopRightButtonConfig.a().b(this.d.getCurrentAccountUin()))
      {
        this.A.setVisibility(0);
        this.A.setContentDescription(this.f.getResources().getString(2131896548));
        return;
      }
      this.A.setVisibility(8);
      return;
    }
    this.A.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie
 * JD-Core Version:    0.7.0.1
 */