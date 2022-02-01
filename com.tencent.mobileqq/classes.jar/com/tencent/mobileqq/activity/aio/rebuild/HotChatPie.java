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
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
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
  static long cj;
  protected static final String[] cs = { "@all", HardCodeUtil.a(2131903552) };
  public boolean bO = false;
  public boolean bP = false;
  public HotChatManager bQ;
  public HotChatInfo bR;
  public String bS;
  boolean bT = false;
  public IHotChatSCHelper bU;
  IHotChatShare bV;
  Dialog bW;
  public Dialog bX;
  boolean bY;
  public int bZ;
  private BaseTroopMsgObserver br;
  private PullRefreshHeader bs;
  long ca = 0L;
  public int cb = 0;
  boolean cc = false;
  View cd = null;
  SegmentedControlView ce;
  RedDotRadioButton cf;
  RedDotRadioButton cg;
  int ch = 0;
  View ci;
  XListView ck;
  IHotChatPostListAdapter cl;
  TextView cm;
  protected int cn = -1;
  protected TroopUsingTimeReport co;
  TroopRedDotObserver cp = new HotChatPie.1(this);
  ViewPluginManager cq = null;
  HotChatObserver cr = (HotChatObserver)((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatObserverImpl(this);
  
  public HotChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!this.bY) && (paramBoolean) && (paramIntent.getBooleanExtra("param_newly_created_hot_chat", false)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramIntent = HotChatHelper.a(paramString3, 1);
      paramIntent = ((IHotChatApi)QRoute.api(IHotChatApi.class)).makeShareGrayTip(HardCodeUtil.a(2131911360), HardCodeUtil.a(2131903556), paramString1, paramString2, paramIntent, paramString3);
      if (!TextUtils.isEmpty(paramIntent))
      {
        this.bY = true;
        paramString2 = MessageRecordFactory.a(-2033);
        long l = MessageCache.c();
        paramString3 = this.d.getCurrentAccountUin();
        paramString2.init(paramString3, this.ah.b, paramString3, paramIntent, l, -2033, this.ah.a, l);
        paramString2.isread = true;
        if (!MessageHandlerUtils.a(this.d, paramString2, false)) {
          this.d.getMessageFacade().a(paramString2, paramString3);
        }
      }
      this.bW = HotChatHelper.a(this.f, new HotChatPie.12(this, paramString1));
    }
  }
  
  private void bH()
  {
    if (this.ci == null) {
      this.ci = LayoutInflater.from(this.e).inflate(2131625142, null);
    }
    if (this.ck == null)
    {
      this.ck = ((XListView)this.ci.findViewById(2131447863));
      this.cm = ((TextView)this.ci.findViewById(2131432530));
      this.bs = ((PullRefreshHeader)LayoutInflater.from(this.e).inflate(2131625671, this.ck, false));
      this.bs.setHeaderBgColor(-16777216);
      this.bs.setTextColor(-1, -1, -1, -1, -1);
      this.bs.setArrowColor(-1);
      this.ck.setOverScrollHeader(this.bs);
      this.ck.setOverScrollHeight(10);
      this.ck.setOverscrollHeader(this.e.getResources().getDrawable(2130839580));
      this.ck.setDividerHeight(30);
      this.ck.setOnScrollListener(new HotChatPie.3(this));
      this.ck.setOverScrollListener(new HotChatPie.4(this));
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    if (this.X != null) {
      this.X.setVisibility(8);
    }
    if (this.W != null) {
      this.W.setVisibility(8);
    }
    if (this.o.indexOfChild(this.ci) == -1)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131437281);
      this.o.addView(this.ci, (ViewGroup.LayoutParams)localObject);
      this.U.setVisibility(8);
    }
    int j = SharedPreUtils.ai(this.e, this.d.getCurrentUin());
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0)
    {
      if (this.cq == null)
      {
        this.cq = new ViewPluginManager(this.f, "QQ_Hotchat_post_list.apk", "2586", "/hotchatPostListPlugin/opt");
        this.cq.a(new HotChatPie.5(this), false);
      }
    }
    else if (this.cl == null)
    {
      this.cl = ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatPostListAdapter(this.e, null);
      this.ck.setAdapter((ListAdapter)this.cl);
    }
    if (this.ck.getVisibility() != 8)
    {
      localObject = this.cl;
      if ((localObject == null) || (((IHotChatPostListAdapter)localObject).getCount() != 0)) {}
    }
    else
    {
      c(0, 10);
    }
  }
  
  private void bI()
  {
    Object localObject = this.bR;
    if ((localObject != null) && (((HotChatInfo)localObject).pkFlag != 0))
    {
      if (this.bU == null)
      {
        ThreadManager.post(new HotChatPie.10(this), 5, null, true);
        localObject = new HotChatPie.11(this);
        this.bU = ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatSCHelper(this.d, (IHotChatSCHelper.OnShowNoteListener)localObject, this.bR.uuid);
      }
      this.bU.startCheckDelay(10000L);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new HotChatPie.17(this, paramInt2, paramInt1), 8, null, true);
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c);
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
  
  private void c(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt == 1)
    {
      if (this.ci != null) {
        this.o.removeView(this.ci);
      }
      this.U.setVisibility(0);
      if (this.W != null) {
        this.W.setVisibility(0);
      }
      if (this.X != null) {
        this.X.setVisibility(0);
      }
      this.cn = 1;
      localObject = this.cf;
      if ((localObject != null) && (((RedDotRadioButton)localObject).a()))
      {
        j(131072);
        this.cf.a(false);
      }
      if ((this.bp != null) && (this.bp.m() > 0)) {
        this.bp.d(0);
      }
      if ((this.bR != null) && (paramBoolean))
      {
        QQAppInterface localQQAppInterface = this.d;
        if (this.bR.isBuLuoHotChat()) {
          localObject = "2";
        } else {
          localObject = "1";
        }
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject, "", "", "");
      }
    }
    else if (paramInt == 2)
    {
      localObject = this.cg;
      if ((localObject != null) && (((RedDotRadioButton)localObject).a()))
      {
        this.cg.a(false);
        localObject = this.cl;
        if (localObject != null) {
          c(0, ((IHotChatPostListAdapter)localObject).getCount());
        }
      }
      this.bp.d(4);
      bH();
      aw();
      localObject = this.bR;
      if (localObject != null) {
        ((HotChatInfo)localObject).clearRedPoint();
      }
      this.cn = 2;
      if (this.V != null) {
        this.ch = this.V.getCount();
      }
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "hot_room", "exp_visit_post", 0, 0, "", "", "", "");
  }
  
  private void p(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.q.setVisibility(8);
      this.r.setVisibility(8);
      if (this.cd == null) {
        this.cd = LayoutInflater.from(this.e).inflate(2131625974, null);
      }
      if (this.ce == null)
      {
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).topMargin = 32;
        this.p.addView(this.cd, (ViewGroup.LayoutParams)localObject);
        this.p.b();
        this.ce = ((SegmentedControlView)this.cd.findViewById(2131435173));
      }
      this.ce.setVisibility(0);
      this.cf = ((RedDotRadioButton)this.cd.findViewById(2131435171));
      Object localObject = this.cf;
      if (localObject != null)
      {
        ((RedDotRadioButton)localObject).setChecked(true);
        this.cn = 1;
      }
      this.cg = ((RedDotRadioButton)this.cd.findViewById(2131435172));
      this.ce.setOnCheckedChangeListener(this);
      return;
    }
    if ((this.cd != null) && (this.p.indexOfChild(this.cd) != -1)) {
      this.p.removeView(this.cd);
    }
    this.q.setVisibility(0);
    this.r.setVisibility(0);
  }
  
  private void q(boolean paramBoolean)
  {
    this.m.post(new HotChatPie.2(this, paramBoolean));
  }
  
  public void B()
  {
    Object localObject = this.ah.b;
    if ((this.bQ.a((String)localObject)) && (!TextUtils.isEmpty(this.bR.uuid)))
    {
      localObject = new Intent(this.f, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://nearby.qq.com/hot_chat/room_info.html", "_wv", "3"), "_bid", "2581"), "gc", this.bR.troopUin), "rid", this.bR.uuid), "rname", this.bR.name), "rtype", String.valueOf(this.bR.hotChatType)), "rnum", String.valueOf(this.bR.memberCount)));
      aX().startActivity((Intent)localObject);
      ReportController.b(this.d, "CliOper", "", "", "0X8004414", "0X8004414", 0, 0, "", "", "", "");
      if (this.bR.isGameRoom) {
        ReportController.b(this.d, "dc00899", "Grp_wolf", "", "in_game", "clk_grp_card", 0, 0, "", "", "", "");
      }
    }
    else
    {
      QQToast.makeText(this.d.getApp(), HardCodeUtil.a(2131903560), 0).show(this.f.getTitleBarHeight());
    }
  }
  
  protected void E()
  {
    String str = ContactUtils.a(this.d, this.ah.b, this.ah.c, ContactUtils.c(this.ah.a), 3);
    if (!TextUtils.equals(str, this.ah.b)) {
      this.ah.e = str;
    }
  }
  
  public void K()
  {
    Object localObject = this.bU;
    if (localObject != null)
    {
      ((IHotChatSCHelper)localObject).destroy();
      this.bU = null;
    }
    localObject = this.bR;
    if ((localObject != null) && (((HotChatInfo)localObject).isBuLuoHotChat()))
    {
      this.d.removeObserver(this.cp);
      c(1, false);
      if ((this.cd != null) && (this.p.indexOfChild(this.cd) != -1)) {
        this.p.removeView(this.cd);
      }
      this.cd = null;
      this.ce = null;
      this.ci = null;
      this.ck = null;
      this.cl = null;
      this.cq = null;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.ca;
    ReportController.b(this.d, "CliOper", "", "", "0X8006587", "0X8006587", 0, 0, String.valueOf(l1 - l2), String.valueOf(this.cb), "", "");
    if (this.f.getIntent() != null) {
      this.f.getIntent().getBooleanExtra("open_chatfragment_fromphoto", false);
    }
    localObject = this.bX;
    if (localObject != null)
    {
      ((Dialog)localObject).dismiss();
      this.bX = null;
    }
    localObject = this.bW;
    if (localObject != null)
    {
      ((Dialog)localObject).dismiss();
      this.bW = null;
    }
    localObject = this.bV;
    if (localObject != null) {
      ((IHotChatShare)localObject).onDestroy();
    }
    localObject = this.cl;
    if (localObject != null) {
      ((IHotChatPostListAdapter)localObject).destroy();
    }
    ((ITroopRobotService)this.d.getRuntimeService(ITroopRobotService.class, "all")).closeTalking();
    localObject = this.co;
    if (localObject != null) {
      ((TroopUsingTimeReport)localObject).c();
    }
    super.K();
  }
  
  public void O()
  {
    super.O();
    this.cc = true;
  }
  
  public void P()
  {
    super.P();
    IHotChatSCHelper localIHotChatSCHelper = this.bU;
    if (localIHotChatSCHelper != null) {
      localIHotChatSCHelper.stopCheck();
    }
  }
  
  public void S()
  {
    super.S();
    this.cc = false;
    HotChatInfo localHotChatInfo = this.bR;
    if ((localHotChatInfo != null) && (localHotChatInfo.isBuLuoHotChat()) && (this.cn == 2) && (this.bp != null)) {
      this.bp.d(4);
    }
    this.co.b();
  }
  
  public void U()
  {
    super.U();
    Object localObject = this.f.getIntent();
    if (localObject == null) {
      return;
    }
    String str = ((Intent)localObject).getStringExtra("uin");
    int i = ((Intent)localObject).getIntExtra("uintype", -1);
    if ((this.ah.b != null) && ((!this.ah.b.equals(str)) || (this.ah.a != i))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = this.bR;
      if ((localObject != null) && (((HotChatInfo)localObject).isBuLuoHotChat()))
      {
        this.ci = null;
        this.ck = null;
      }
    }
  }
  
  public boolean V()
  {
    HotGiftPanelHelper localHotGiftPanelHelper = (HotGiftPanelHelper)q(136);
    if ((localHotGiftPanelHelper.g != null) && (localHotGiftPanelHelper.g.b()))
    {
      localHotGiftPanelHelper.g.a();
      return true;
    }
    boolean bool = super.V();
    if ((!this.aj) && (this.bO) && (!bool)) {
      HotChatManager.a(this.e, this.bO);
    }
    return bool;
  }
  
  public void X()
  {
    super.X();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 3)
      {
        Intent localIntent = AIOUtils.a(new Intent(this.f, SplashActivity.class), null);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        this.f.startActivity(localIntent);
      }
    }
    else if ((paramInt2 == 8001) && (this.n != null)) {
      this.n.b();
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(View paramView) {}
  
  public void a(ChatMessage paramChatMessage, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(aX());
    String str2 = HardCodeUtil.a(2131903561);
    String str3 = paramChatMessage.getExtInfoFromExtStr("hotchat_gender");
    String str1 = str2;
    try
    {
      if (Integer.parseInt(str3) != 1) {
        break label101;
      }
      str1 = HardCodeUtil.a(2131903558);
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
      str1 = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showHeadLongClickActionSheet, NumberFormatException, genderStr:");
      localStringBuilder.append(str3);
      QLog.e(str1, 2, localStringBuilder.toString());
      str1 = str2;
    }
    label101:
    localActionSheet.addButton(str1);
    localActionSheet.addButton(HardCodeUtil.a(2131903555), 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new HotChatPie.16(this, localActionSheet, paramChatMessage, paramString));
    localActionSheet.show();
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.cc) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
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
    paramString1 = this.bX;
    if ((paramString1 != null) && (paramString1.isShowing())) {
      this.bX.dismiss();
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      QQToast.makeText(aX(), HardCodeUtil.a(2131903542), 0).show(aX().getTitleBarHeight());
      return;
    }
    QQToast.makeText(aX(), HardCodeUtil.a(2131903544), 0).show(aX().getTitleBarHeight());
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.equals(paramString1, this.ah.b)) {
      return false;
    }
    if (this.cc) {
      return false;
    }
    this.bR = this.bQ.c(paramString1);
    paramString1 = this.bR;
    boolean bool = true;
    if ((paramString1 != null) && (!paramString1.memoShowed))
    {
      this.bR.memoShowed = true;
      ThreadManager.post(new HotChatPie.14(this), 8, null, true);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.bj == null) {
          this.bj = new TroopFeedsCenterLogic(this.d, this.f, this.ah, this.o, this.A, this.bp, this.bm, null);
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
        this.bj.a(this.d, this.e, paramString2, paramString1);
        paramString1 = this.bU;
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
    this.aJ = false;
    ((FastImageHelper)q(83)).a(false);
    this.br = new BaseTroopMsgObserver(this);
    this.bV = ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatShare(this.f, this.d, null);
    this.co = new TroopUsingTimeReport(this.d, this.ah.b, "Grp_time", "Grp_AIO", "visit_time");
    return super.a(paramBoolean);
  }
  
  protected void ap()
  {
    bS();
    bB();
    super.ap();
    this.ca = SystemClock.elapsedRealtime();
    NearbyTransitActivity.a("AIOShow", 2);
    Object localObject1 = this.f.getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("uin");
    String str1 = ((Intent)localObject1).getStringExtra("uinname");
    String str2 = ((Intent)localObject1).getStringExtra("hotnamecode");
    int i = 0;
    a((Intent)localObject1, (String)localObject2, str1, str2, ((Intent)localObject1).getBooleanExtra("param_newly_created_hot_chat", false));
    if (this.bQ.a()) {
      ThreadManager.post(new HotChatPie.8(this), 8, null, true);
    }
    this.bR = this.bQ.c(this.ah.b);
    localObject1 = this.bR;
    if ((localObject1 != null) && (((HotChatInfo)localObject1).isBuLuoHotChat())) {
      this.d.addObserver(this.cp);
    }
    bI();
    localObject1 = this.bR;
    if ((localObject1 != null) && (((HotChatInfo)localObject1).isBuLuoHotChat()))
    {
      if (this.bR.need2ReqRedPoint()) {
        ThreadManager.post(new HotChatPie.9(this), 8, null, true);
      }
      i = 1;
    }
    else
    {
      c(1, false);
    }
    localObject2 = this.d;
    if (i != 0) {
      localObject1 = "2";
    } else {
      localObject1 = "1";
    }
    ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "hot_room", "exp_aio", 0, 0, (String)localObject1, "", "", "");
  }
  
  public void au()
  {
    super.au();
    this.d.addObserver(this.cr);
    this.d.addDefaultObservers(this.br);
    if (this.d.getProxyManager() != null) {
      this.d.getProxyManager().addProxyObserver(this.bq);
    }
  }
  
  public void av()
  {
    super.av();
    this.d.removeObserver(this.br);
    if (this.d.getProxyManager() != null) {
      this.d.getProxyManager().removeProxyObserver(this.bq);
    }
    this.d.removeObserver(this.cr);
  }
  
  protected HelperProvider b()
  {
    return new HotHelperProvider(this.f);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    this.bZ = paramInt2;
  }
  
  public void bA()
  {
    super.bA();
    this.u.setContentDescription(this.f.getString(2131890727));
    HotChatInfo localHotChatInfo = this.bR;
    if ((localHotChatInfo != null) && (localHotChatInfo.state != 0)) {
      ThreadManager.post(new HotChatPie.7(this), 5, null, false);
    }
  }
  
  public boolean bF()
  {
    return true;
  }
  
  public int bR()
  {
    return this.cn;
  }
  
  public void bS()
  {
    this.bR = this.bQ.c(this.ah.b);
    HotChatInfo localHotChatInfo = this.bR;
    if (localHotChatInfo != null)
    {
      this.bQ.i();
      if (!this.f.getIntent().getBooleanExtra("param_newly_created_hot_chat", false)) {
        ThreadManager.post(new HotChatPie.15(this, localHotChatInfo), 8, null, true);
      }
    }
  }
  
  protected void c(Intent paramIntent)
  {
    Object localObject = this.bR;
    if ((localObject != null) && (((HotChatInfo)localObject).isBuLuoHotChat()))
    {
      HtmlOffline.a("2586", this.d, new HotChatPie.6(this), true, 0);
      return;
    }
    localObject = this.ce;
    if (localObject != null)
    {
      ((SegmentedControlView)localObject).setVisibility(8);
      this.p.removeView(this.cd);
      this.ce = null;
    }
    this.q.setVisibility(0);
    this.r.setVisibility(0);
    super.c(paramIntent);
  }
  
  protected AIOContext d()
  {
    return new HotChatContext();
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new Scroller()).a(new ListUI(this.i)).a(new UnreadTask(this.i)).a((MsgListRefresher)((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatMsgListRefresher(this.i)).a();
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    this.bQ = this.d.getHotChatMng(true);
    this.bR = this.bQ.c(this.ah.b);
    Object localObject = this.bR;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("PttShow", new Object[] { "HotChatPie_updateSession_business HotChatInfo is null", this.ah.b });
      }
      f(0);
      return;
    }
    this.cb = ((HotChatInfo)localObject).userCreate;
    if ((paramIntent != null) && (paramIntent.getIntExtra("hot_chat_from", 1) == 2) && (this.bQ.e())) {
      HotChatHelper.a(this.d, this.f);
    }
    paramIntent = (AIOShortcutBarHelper)q(52);
    if ((paramIntent != null) && (this.bR.isRobotHotChat))
    {
      localObject = new AIOShortcutBarHelper.AIOShortcutBarEvent(14);
      ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject).a().putLong("roBotUin", this.bR.robotUin);
      paramIntent.a((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject);
    }
  }
  
  protected void f(Intent paramIntent)
  {
    this.bO = paramIntent.getBooleanExtra("abp_flag", false);
    this.bP = paramIntent.getBooleanExtra("is_from_web", false);
    if ((this.bP) && (!this.bO))
    {
      this.s.setText(2131887440);
      this.s.setContentDescription(HardCodeUtil.a(2131901576));
      return;
    }
    if (this.bO)
    {
      this.s.setText(HardCodeUtil.a(2131903562));
      this.s.setContentDescription(HardCodeUtil.a(2131903549));
      return;
    }
    super.f(paramIntent);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.bO)
    {
      if (this.bp != null) {
        this.bp.v();
      }
      HotChatManager.a(this.e, this.bO);
      return;
    }
    super.f(paramBoolean);
  }
  
  protected void h()
  {
    this.c = "HotChatPie";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 29) {
      return super.handleMessage(paramMessage);
    }
    return true;
  }
  
  public void l(int paramInt)
  {
    super.l(paramInt);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i;
    if (paramInt == 2131435171) {
      i = 1;
    } else {
      i = 2;
    }
    c(i, true);
    QQAppInterface localQQAppInterface = this.d;
    String str;
    if (paramInt == 2131435171) {
      str = "clk_hot_room";
    } else {
      str = "clk_see_post";
    }
    ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "hot_room", str, 0, 0, "", "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
  
  protected void u()
  {
    HotChatInfo localHotChatInfo = this.bR;
    if ((localHotChatInfo != null) && (localHotChatInfo.isBuLuoHotChat())) {
      return;
    }
    localHotChatInfo = this.bR;
    int i;
    if ((localHotChatInfo != null) && (localHotChatInfo.mFissionRoomNum > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    b(true);
    if (i != 0)
    {
      this.I.setVisibility(0);
      this.I.setText(String.format(this.f.getString(2131890739), new Object[] { Integer.valueOf(this.bR.mFissionRoomNum) }));
      this.I.setTextSize(1, 12.0F);
      return;
    }
    this.I.setVisibility(8);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((this.f.isResume()) && ((paramObject instanceof MessageForDeliverGiftTips))) {
      AIOAnimationControlManager.a(this, false);
    }
    paramObservable = this.cf;
    if ((paramObservable != null) && (!paramObservable.a()) && (paramObject != null) && ((paramObject instanceof MessageRecord)) && (this.cn == 2)) {
      this.m.post(new HotChatPie.13(this));
    }
  }
  
  protected void z()
  {
    this.A.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie
 * JD-Core Version:    0.7.0.1
 */