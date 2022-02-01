package com.tencent.mobileqq.activity.aio.rebuild;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.ark.ark;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.api.IPublicAccountTipsManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopObserver;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.comic.api.IQQPluginPreloadService;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.gdtad.statistics.GdtImpressionPolicy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.input.FakeInputUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.helper.AIODraftHelper;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.PAHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.WeiShiSubScribeHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.PAMsgListRefresher;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.ark.api.notify.GdtNotify;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler.ReportInfo;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.ecshop.aio.IEcshopChatPieDelegate;
import com.tencent.mobileqq.ecshop.aio.api.IEcshopChatPieApi;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.temp.api.impl.EcshopMessageApiImpl;
import com.tencent.mobileqq.ecshop.utils.EcshopFromUtils;
import com.tencent.mobileqq.ecshop.view.api.IEcshopRainViewApi;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletGdtAdApi;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.PublicMenuBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.URLUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.XPanelContainer;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigGroupInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.RetInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class PublicAccountChatPie
  extends BaseChatPie
{
  boolean bA = false;
  boolean bB = false;
  long bC = -1L;
  List<String> bD = new ArrayList();
  List<String> bE = new ArrayList();
  public boolean bF = false;
  public boolean bG = false;
  long bH = -1L;
  long bI = -1L;
  protected ImageView bJ;
  protected ImageView bK;
  public ImageView bL;
  protected int bM = 2130837944;
  protected int bN = 2130837943;
  protected PatchedButton bO;
  protected LinearLayout bP;
  protected SpannableString bQ;
  protected SpannableString bR;
  public IPublicAccountTipsManager bS;
  long bT = 0L;
  public TroopEntranceBar bU;
  public boolean bV = false;
  public View bW = null;
  boolean bX = false;
  boolean bY = false;
  public int bZ = 0;
  IPublicAccountManager bi;
  CustomMenuBar bj;
  QQProgressDialog bk;
  View bl = null;
  PublicMenuBar bm = null;
  boolean bn = false;
  public IPublicAccountHandler bo;
  boolean bp = false;
  AbsStructMsg bq;
  public int br = 0;
  public String bs = "";
  public String bt = "";
  public int bu = -1;
  public int[] bv;
  public boolean bw = false;
  int bx = 0;
  int by = 3;
  boolean bz = false;
  String cA;
  boolean cB = false;
  boolean cC = false;
  boolean cD = false;
  boolean cE = false;
  boolean cF = false;
  public boolean cG = false;
  MessageForStructing cH = null;
  View cI;
  View cJ;
  View cK;
  QidianManager cL;
  public QidianBusinessObserver cM = new PublicAccountChatPie.58(this);
  public View.OnClickListener cN = new PublicAccountChatPie.61(this);
  private PublicMenuBar cO;
  private ImageView cP;
  private View cQ;
  private NewIntent cR;
  private NewIntent cS = null;
  private NewIntent cT = null;
  private AvatarObserver cU = null;
  private View cV = null;
  private String cW = "";
  private int cX;
  private int cY;
  private int cZ = 0;
  public int ca = 0;
  public int cb = 0;
  public int cc = 0;
  public PreloadProcHitSession cd = new PreloadProcHitSession("web_public_account", "com.tencent.mobileqq:tool");
  Handler ce = new PublicAccountChatPie.1(this);
  boolean cf = false;
  boolean cg = false;
  protected MessageObserver ch = new PublicAccountChatPie.12(this);
  boolean ci = false;
  boolean cj = false;
  ActionSheet ck;
  PublicAccountInfo cl;
  Dialog cm;
  public boolean cn = false;
  public IPublicAccountObserver co = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
  public IPublicAccountObserver.OnCallback cp = new PublicAccountChatPie.52(this);
  EcShopObserver cq = new PublicAccountChatPie.53(this);
  boolean cr = false;
  boolean cs = false;
  public boolean ct;
  public boolean cu;
  String cv;
  String cw;
  String cx;
  String cy;
  String cz;
  private int dA = 0;
  private BusinessObserver dB;
  private IPublicAccountDetail dC;
  private PublicAccountChatPie.HomeBroadcast dD;
  private int dE = 0;
  private XListView.DrawFinishedListener dF = new PublicAccountChatPie.56(this);
  private Dialog dG = null;
  private long dH;
  private BroadcastReceiver dI;
  private boolean dJ;
  private boolean da = false;
  private boolean db = false;
  private boolean dc = false;
  private AtomicBoolean dd = new AtomicBoolean(false);
  private boolean de = false;
  private AtomicBoolean df = new AtomicBoolean(false);
  private boolean dg = false;
  private QQCustomDialog dh;
  private LinearLayout di;
  private long dj = 0L;
  private int dk = 0;
  private boolean dl = false;
  private boolean dm = false;
  private long dn;
  private int jdField_do;
  private int dp = -1;
  private int dq = -1;
  private long dr = 0L;
  private NewPublicAccountObserver ds;
  private NewPublicAccountObserver dt;
  private boolean du;
  private BusinessObserver dv = new PublicAccountChatPie.3(this);
  private IEcshopChatPieDelegate dw;
  private View dx = null;
  private int dy = 0;
  private boolean dz = false;
  
  public PublicAccountChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.co.setOnCallback(this.cp);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.bx;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      b(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    d(paramInt1, paramInt4);
  }
  
  @TargetApi(11)
  private void a(View paramView, int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.addUpdateListener(new PublicAccountChatPie.13(this, paramView, paramInt1, paramInt2));
    localValueAnimator.addListener(paramAnimatorListener);
    localValueAnimator.setDuration(500L).start();
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    SharedPreferences localSharedPreferences = this.f.getSharedPreferences(this.d.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getBoolean("firstIntoAIO", true))
    {
      LinearLayout localLinearLayout = new LinearLayout(this.f);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(Color.parseColor("#B3000000"));
      localLinearLayout.setVisibility(0);
      localLinearLayout.setClickable(true);
      localLinearLayout.setOnClickListener(new PublicAccountChatPie.51(this, paramRelativeLayout, localLinearLayout));
      Object localObject = new ImageView(this.f);
      ((ImageView)localObject).setImageResource(2130842622);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      Resources localResources = this.f.getResources();
      localLayoutParams.width = AIOUtils.b(73.0F, localResources);
      localLayoutParams.height = AIOUtils.b(73.0F, localResources);
      localLayoutParams.topMargin = AIOUtils.b(100.0F, localResources);
      localLayoutParams.gravity = 17;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      localObject = new TextView(this.f);
      ((TextView)localObject).setText(HardCodeUtil.a(2131906565));
      ((TextView)localObject).setTextSize(2, 18.0F);
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = AIOUtils.b(28.0F, localResources);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      paramRelativeLayout.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
      localSharedPreferences.edit().putBoolean("firstIntoAIO", false).commit();
    }
  }
  
  private void a(IPublicAccountDetail paramIPublicAccountDetail)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountChatPie.30(this, paramIPublicAccountDetail), 10L);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    try
    {
      GdtC2SReporter.a(1, 2, ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getAdInfoByChatMessage(paramMessageForArkApp));
      return;
    }
    catch (Exception paramMessageForArkApp)
    {
      paramMessageForArkApp.printStackTrace();
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = paramMessageForStructing.structingMsg;
    if ((paramMessageForStructing instanceof StructMsgForGeneralShare))
    {
      paramMessageForStructing = ((StructMsgForGeneralShare)paramMessageForStructing).mStructMsgItemLists;
      if ((paramMessageForStructing != null) && (!paramMessageForStructing.isEmpty()))
      {
        paramMessageForStructing = paramMessageForStructing.iterator();
        for (;;)
        {
          if (paramMessageForStructing.hasNext())
          {
            Object localObject = (AbsStructMsgElement)paramMessageForStructing.next();
            if ((localObject instanceof StructMsgItemLayout5))
            {
              localObject = ((StructMsgItemLayout5)localObject).ax;
              if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
                continue;
              }
              localObject = ((ArrayList)localObject).iterator();
              if (!((Iterator)localObject).hasNext()) {
                continue;
              }
              AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
              if (!(localAbsStructMsgElement instanceof StructMsgItemVideo)) {
                break;
              }
              try
              {
                GdtC2SReporter.a(1, 2, EcshopMessageApiImpl.getAdInfo(localAbsStructMsgElement));
              }
              catch (Throwable localThrowable)
              {
                QLog.e(this.c, 1, localThrowable, new Object[0]);
              }
              continue;
            }
            if (((localThrowable instanceof StructMsgItemLayout6)) || ((localThrowable instanceof StructMsgItemLayoutPromotion))) {
              try
              {
                GdtC2SReporter.a(1, 2, EcshopMessageApiImpl.getAdInfo(localThrowable));
                return;
              }
              catch (Throwable paramMessageForStructing)
              {
                QLog.e(this.c, 1, paramMessageForStructing, new Object[0]);
              }
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("need_report", false))
    {
      ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.d, this.ah.b, "Pb_account_lifeservice", "mp_msg_sys_6", "msg_push");
      long l1 = paramIntent.getLongExtra("incoming_msguid", 0L);
      long l2 = paramIntent.getLongExtra("incoming_shmsgseq", 0L);
      if (l1 > 0L) {
        ThreadManager.post(new PublicAccountChatPie.37(this, paramString, paramInt, l1, l2), 5, null, true);
      }
    }
    if (paramIntent.hasExtra("need_report")) {
      paramIntent.removeExtra("need_report");
    }
  }
  
  private void a(List<ChatMessage> paramList, List<Long> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramList != null) && (paramList1 != null) && (paramList2 != null) && (paramList3 != null) && (paramList4 != null))
    {
      if (paramChatMessage == null) {
        return;
      }
      try
      {
        boolean bool = paramChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("");
        if ((bool) || (paramChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("true"))) {
          break label483;
        }
        paramList.add(paramChatMessage);
        localObject = paramChatMessage.getExtInfoFromExtStr("pa_msgId");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label474;
        }
        localObject = "0";
        long l = Long.parseLong((String)localObject);
        if (!paramChatMessage.getExtInfoFromExtStr("pa_should_report").equals("true")) {
          break label477;
        }
        paramList1.add(Long.valueOf(l));
        if (!QLog.isColorLevel()) {
          break label477;
        }
        paramList1 = this.c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Report message at index: ");
        ((StringBuilder)localObject).append(String.valueOf(paramInt));
        ((StringBuilder)localObject).append(". MessageId is ");
        ((StringBuilder)localObject).append(l);
        QLog.d(paramList1, 2, ((StringBuilder)localObject).toString());
        label206:
        paramChatMessage.saveExtInfoToExtStr("pa_msgHasRead", "true");
        paramList1 = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
        if (paramList1 != null) {
          break label480;
        }
        paramList1 = "";
        label236:
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "P_CliOper", "Pb_account_lifeservice", this.ah.b, "0X80057C4", "0X80057C4", 0, 0, this.ah.b, String.valueOf(l), paramList1, "", false);
        label294:
        if (paramChatMessage.getExtInfoFromExtStr("ad_msgHasRead").equals("false"))
        {
          paramChatMessage.saveExtInfoToExtStr("ad_msgHasRead", "true");
          localObject = paramChatMessage.getExtInfoFromExtStr("pa_msgId");
          str1 = paramChatMessage.getExtInfoFromExtStr("gdt_msgClick");
          str2 = paramChatMessage.getExtInfoFromExtStr("gdt_view_id");
        }
      }
      catch (Exception paramList)
      {
        Object localObject;
        String str1;
        String str2;
        label383:
        paramList.printStackTrace();
      }
    }
    else
    {
      try
      {
        paramList1 = new JSONObject(str1);
        if (!paramList1.has("ad_id")) {
          break label486;
        }
        paramList1 = paramList1.getString("ad_id");
      }
      catch (Exception paramList1)
      {
        break label383;
      }
      if (!QLog.isColorLevel()) {
        break label486;
      }
      QLog.d(this.c, 2, " parse ad_id error");
      break label486;
    }
    for (;;)
    {
      paramList2.add(localObject);
      this.bE.add(paramList1);
      paramList3.add(str1);
      paramList4.add(str2);
      if (!paramList.contains(paramChatMessage))
      {
        paramList.add(paramChatMessage);
        return;
      }
      return;
      label474:
      break;
      label477:
      break label206;
      label480:
      break label236;
      label483:
      break label294;
      label486:
      paramList1 = "0";
    }
  }
  
  private boolean a(Intent paramIntent, String paramString)
  {
    if ((paramString != null) && (paramString.equals("starShortcut")))
    {
      ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).handleUrlEvent(this.f, this.d, paramIntent.getStringExtra("starhomeurl"), paramIntent.getStringExtra("uin"), paramString);
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null) {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(paramString);
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      if (paramQQAppInterface != null)
      {
        paramString = paramQQAppInterface.getLastMessage(paramString, 1008);
        if ((paramString != null) && (paramString.msgtype == -2011))
        {
          paramQQAppInterface = new MessageForStructing();
          MessageForStructing.copyMessageRecordBaseField(paramQQAppInterface, paramString);
          paramQQAppInterface.parse();
          if ((paramQQAppInterface.structingMsg != null) && ((paramQQAppInterface.structingMsg.mPromotionType == 1) || (paramQQAppInterface.structingMsg.mPromotionType == 2))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte, oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse1)
  {
    if (paramGetPublicAccountDetailInfoResponse == null) {
      return false;
    }
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(paramArrayOfByte);
      int i = -1;
      if (paramArrayOfByte.uint32_result.has())
      {
        int j = paramArrayOfByte.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handle OidbSvc.0xcf8|OIDBSSOPke.result=");
          ((StringBuilder)localObject1).append(j);
          QLog.i("QQVipHelper", 2, ((StringBuilder)localObject1).toString());
          i = j;
        }
      }
      if ((i == 0) && (paramArrayOfByte.bytes_bodybuffer.has()) && (paramArrayOfByte.bytes_bodybuffer.get() != null))
      {
        paramGetPublicAccountDetailInfoResponse.mergeFrom(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
        if (paramGetPublicAccountDetailInfoResponse.ret_info.has())
        {
          paramArrayOfByte = new mobileqq_mp.RetInfo();
          paramArrayOfByte.ret_code.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get());
          paramArrayOfByte.err_info.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).err_info.get());
          paramGetPublicAccountDetailInfoResponse1.ret_info.set(paramArrayOfByte);
        }
        paramGetPublicAccountDetailInfoResponse1.seqno.set(paramGetPublicAccountDetailInfoResponse.seqno.get());
        paramGetPublicAccountDetailInfoResponse1.uin.set((int)paramGetPublicAccountDetailInfoResponse.luin.get());
        paramGetPublicAccountDetailInfoResponse1.name.set(paramGetPublicAccountDetailInfoResponse.name.get());
        paramGetPublicAccountDetailInfoResponse1.display_number.set(paramGetPublicAccountDetailInfoResponse.display_number.get());
        paramGetPublicAccountDetailInfoResponse1.summary.set(paramGetPublicAccountDetailInfoResponse.summary.get());
        paramGetPublicAccountDetailInfoResponse1.is_recv_msg.set(paramGetPublicAccountDetailInfoResponse.is_recv_msg.get());
        paramGetPublicAccountDetailInfoResponse1.is_recv_push.set(paramGetPublicAccountDetailInfoResponse.is_recv_push.get());
        paramGetPublicAccountDetailInfoResponse1.certified_grade.set(paramGetPublicAccountDetailInfoResponse.certified_grade.get());
        Object localObject2;
        ArrayList localArrayList;
        oidb_cmd0xcf8.ConfigInfo localConfigInfo;
        mobileqq_mp.ConfigInfo localConfigInfo1;
        if (paramGetPublicAccountDetailInfoResponse.config_group_info.has())
        {
          paramArrayOfByte = new ArrayList();
          localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
            localArrayList = new ArrayList();
            localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
              localConfigInfo1 = new mobileqq_mp.ConfigInfo();
              localConfigInfo1.type.set(localConfigInfo.type.get());
              localConfigInfo1.title.set(localConfigInfo.title.get());
              localConfigInfo1.content.set(localConfigInfo.content.get());
              localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
              localConfigInfo1.url.set(localConfigInfo.url.get());
              localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
              localConfigInfo1.state.set(localConfigInfo.state.get());
              localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
              localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
              localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
              localArrayList.add(localConfigInfo1);
            }
            localObject2 = new mobileqq_mp.ConfigGroupInfo();
            ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.set(localArrayList);
            paramArrayOfByte.add(localObject2);
          }
          paramGetPublicAccountDetailInfoResponse1.config_group_info.set(paramArrayOfByte);
        }
        paramGetPublicAccountDetailInfoResponse1.is_show_share_button.set(paramGetPublicAccountDetailInfoResponse.is_show_share_button.get());
        paramGetPublicAccountDetailInfoResponse1.is_show_follow_button.set(paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get());
        paramGetPublicAccountDetailInfoResponse1.follow_type.set(paramGetPublicAccountDetailInfoResponse.follow_type.get());
        paramGetPublicAccountDetailInfoResponse1.is_sync_lbs.set(paramGetPublicAccountDetailInfoResponse.is_sync_lbs.get());
        paramGetPublicAccountDetailInfoResponse1.group_id.set(paramGetPublicAccountDetailInfoResponse.group_id.get());
        paramGetPublicAccountDetailInfoResponse1.show_flag.set(paramGetPublicAccountDetailInfoResponse.show_flag.get());
        paramGetPublicAccountDetailInfoResponse1.account_flag.set(paramGetPublicAccountDetailInfoResponse.account_flag.get());
        paramGetPublicAccountDetailInfoResponse1.luin.set(paramGetPublicAccountDetailInfoResponse.luin.get());
        paramGetPublicAccountDetailInfoResponse1.config_background_color.set(paramGetPublicAccountDetailInfoResponse.config_background_color.get());
        paramGetPublicAccountDetailInfoResponse1.config_background_img.set(paramGetPublicAccountDetailInfoResponse.config_background_img.get());
        if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has())
        {
          paramArrayOfByte = new ArrayList();
          localObject1 = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
            localArrayList = new ArrayList();
            localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
              localConfigInfo1 = new mobileqq_mp.ConfigInfo();
              localConfigInfo1.type.set(localConfigInfo.type.get());
              localConfigInfo1.title.set(localConfigInfo.title.get());
              localConfigInfo1.content.set(localConfigInfo.content.get());
              localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
              localConfigInfo1.url.set(localConfigInfo.url.get());
              localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
              localConfigInfo1.state.set(localConfigInfo.state.get());
              localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
              localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
              localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
              localArrayList.add(localConfigInfo1);
            }
            localObject2 = new mobileqq_mp.ConfigGroupInfo();
            ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.set(localArrayList);
            paramArrayOfByte.add(localObject2);
          }
          paramGetPublicAccountDetailInfoResponse1.config_group_info_new.set(paramArrayOfByte);
        }
        paramGetPublicAccountDetailInfoResponse1.certified_description.set(paramGetPublicAccountDetailInfoResponse.certified_description.get());
        paramGetPublicAccountDetailInfoResponse1.unified_account_descrpition.set(paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.get());
        paramGetPublicAccountDetailInfoResponse1.account_flag2.set(paramGetPublicAccountDetailInfoResponse.account_flag2.get());
        return true;
      }
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.w("QQVipHelper", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
      return false;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.w("QQVipHelper", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
    }
    return false;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((paramInt4 < -5) && (this.cg)) || (((this.bA) || ((paramInt1 + paramInt2 == paramInt3) && (paramInt4 < 0) && (this.cg))) && (!this.bz)))
    {
      this.bz = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.cY, 0.0F);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setAnimationListener(new PublicAccountChatPie.17(this));
      this.bl.startAnimation(localTranslateAnimation);
    }
  }
  
  private void b(android.os.Message paramMessage)
  {
    paramMessage = paramMessage.getData();
    if (paramMessage != null)
    {
      this.bU.s.put(paramMessage.getString("troopUin"), Integer.valueOf(this.d.getConversationFacade().a(paramMessage.getString("troopUin"), 1)));
      this.bU.d();
      this.bU.e();
      this.bU.c();
    }
  }
  
  private void b(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.Y.getLineCount() > 1))
    {
      w(80);
      return;
    }
    if (CustomMenuBar.a()) {
      w(16);
    }
  }
  
  private void b(IPublicAccountDetail paramIPublicAccountDetail)
  {
    if (paramIPublicAccountDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.d.getEntityManagerFactory().createEntityManager();
    localEntityManager.remove(paramIPublicAccountDetail.getEntity());
    localEntityManager.close();
  }
  
  private void b(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg == null) {
      return;
    }
    this.bq = paramMessageForStructing.structingMsg;
    this.cW = paramMessageForStructing.getExtInfoFromExtStr("msg_template_id");
    this.br = paramMessageForStructing.structingMsg.mPromotionType;
    this.bs = paramMessageForStructing.structingMsg.mPromotionMsg;
    this.bt = paramMessageForStructing.structingMsg.mPromotionMenus;
    this.bu = paramMessageForStructing.structingMsg.mPromotionMenuDestructiveIndex;
    try
    {
      if (this.bt == null) {
        break label148;
      }
      int i = 0;
      this.dz = false;
      paramMessageForStructing = this.bt.split(",");
      if (paramMessageForStructing == null) {
        break label148;
      }
      int j = paramMessageForStructing.length;
      this.bv = new int[j];
      while (i < j)
      {
        paramMessageForStructing[i] = paramMessageForStructing[i].trim();
        this.bv[i] = Integer.parseInt(paramMessageForStructing[i]);
        i += 1;
      }
    }
    catch (Exception paramMessageForStructing)
    {
      label143:
      label148:
      break label143;
    }
    this.dz = true;
  }
  
  private void b(AbsListView paramAbsListView)
  {
    try
    {
      if (EcshopFromUtils.b(this.ah))
      {
        int j = paramAbsListView.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = paramAbsListView.getChildAt(i);
          if (localView != null) {
            GdtImpressionPolicy.a().a(localView);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramAbsListView)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountChatPie", 2, paramAbsListView, new Object[0]);
      }
    }
  }
  
  private boolean b(boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramInt == 0)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.ah.b, "", "", "", false);
      Object localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
      bool = false;
      if (localObject != null)
      {
        localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.ah.b);
        if (localObject != null)
        {
          if (this.bo == null) {
            this.bo = ((IPublicAccountHandler)this.d.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
          }
          this.bo.onFollowPublicAccount(localObject);
        }
        else
        {
          bH();
          paramBoolean = bool;
        }
      }
      else
      {
        bH();
        paramBoolean = bool;
      }
      this.bn = true;
      this.bB = true;
      bA();
      bool = paramBoolean;
      if (this.cB)
      {
        localObject = (PlusPanel)this.ae.d(8);
        bool = paramBoolean;
        if (localObject != null)
        {
          ((PlusPanel)localObject).a();
          return paramBoolean;
        }
      }
    }
    else
    {
      if (paramInt == 58) {
        t(2131892946);
      } else if (paramInt == 65) {
        t(2131892918);
      } else {
        t(2131892951);
      }
      bool = paramBoolean;
    }
    return bool;
  }
  
  private void bV()
  {
    if (!(this.f instanceof SplashActivity))
    {
      this.f.finish();
      return;
    }
    Intent localIntent = new Intent(this.f, SplashActivity.class);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(67108864);
    this.f.startActivity(localIntent);
  }
  
  private void bW()
  {
    if (!this.f.isFinishing())
    {
      QQProgressDialog localQQProgressDialog = this.bk;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
      {
        this.bk.dismiss();
        QQToast.makeText(this.f, 2131896472, 0).show(this.f.getTitleBarHeight());
      }
    }
  }
  
  private void bX()
  {
    if ((cM()) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig())) {
      return;
    }
    if (cN()) {
      return;
    }
    bD();
    bC();
    if (QLog.isColorLevel()) {
      QZLog.d(this.c, 2, "setInitHeader in INIT_PUBLICACCOUNT_COVER_MENU");
    }
    if (this.br != 1) {
      this.by = 5;
    }
  }
  
  private void bY()
  {
    List localList = this.bi.getPublicAccountMenuButtonList(this.d, ae());
    c(localList);
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (cN()) {
        return;
      }
      if ((!cM()) || (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig())) {
        p(true);
      }
    }
  }
  
  private void bZ()
  {
    if (this.cB)
    {
      if (!this.cC) {
        return;
      }
      if ((PublicAccountInfo)((IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(this.ah.b) == null) {
        return;
      }
    }
    if (cN())
    {
      IEcshopChatPieDelegate localIEcshopChatPieDelegate = this.dw;
      if ((localIEcshopChatPieDelegate != null) && (localIEcshopChatPieDelegate.a(this.o))) {
        return;
      }
    }
    if (!this.f.isFinishing()) {
      try
      {
        bF();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i = this.by;
    if (i != 3)
    {
      if (i != 4) {
        return;
      }
      if ((paramInt2 == paramInt1) && (this.da))
      {
        paramInt1 = this.cY;
        if (paramInt1 != 0) {
          a(this.cV, paramInt1);
        }
        this.da = false;
        this.bA = true;
      }
      this.by = 2;
      this.ci = true;
      return;
    }
    if ((paramInt2 > paramInt1) && (!this.da))
    {
      this.cY = this.cV.getLayoutParams().height;
      e(this.cV);
      this.da = true;
    }
    this.by = 2;
    this.ci = true;
  }
  
  private void c(android.os.Message paramMessage)
  {
    if (this.f.isFinishing()) {
      return;
    }
    if (paramMessage.arg2 == 1)
    {
      int i = paramMessage.arg1;
      this.dh = DialogUtil.a(this.e, 230, null, String.format(HardCodeUtil.a(2131906524), new Object[] { (String)paramMessage.obj }), HardCodeUtil.a(2131906538), HardCodeUtil.a(2131906534), new PublicAccountChatPie.2(this, i), null);
      this.dh.show();
    }
  }
  
  private void c(IPublicAccountDetail paramIPublicAccountDetail)
  {
    Object localObject1 = this.bl;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131449063);
    localObject1 = (TextView)this.bl.findViewById(2131449062);
    ImageView localImageView = (ImageView)this.bl.findViewById(2131435219);
    if (this.dl)
    {
      Object localObject3 = this.bU;
      if ((localObject3 != null) && (((TroopEntranceBar)localObject3).p > 0) && (this.bU.q.size() > 0))
      {
        localObject3 = (TroopInfo)this.bU.q.get(0);
        ((TextView)localObject2).setText(((TroopInfo)localObject3).troopname);
        ((TextView)localObject1).setText(String.format(this.e.getString(2131892924), new Object[] { paramIPublicAccountDetail.getName() }));
        localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.d, 4, ((TroopInfo)localObject3).troopuin));
        if (this.bU.q.size() > 0) {
          localObject1 = ((TroopInfo)this.bU.q.get(0)).troopuin;
        } else {
          localObject1 = "";
        }
        if (this.ah == null) {
          localObject2 = "";
        } else {
          localObject2 = this.ah.b;
        }
        localObject3 = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append((String)localObject2);
        ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_public", "", "oper", "exp_temp", 0, 0, (String)localObject1, localStringBuilder.toString(), "", "");
      }
    }
    else
    {
      ((TextView)localObject2).setText(paramIPublicAccountDetail.getName());
      localObject2 = this.bs;
      if (localObject2 != null) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      localImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.d, aE().b, (byte)3));
    }
    if (this.cU == null)
    {
      this.cU = new PublicAccountChatPie.42(this, localImageView);
      this.f.addObserver(this.cU);
    }
    localObject1 = (ImageView)this.bl.findViewById(2131430460);
    if (paramIPublicAccountDetail.getCertifiedGrade() == 0L)
    {
      ((ImageView)localObject1).setVisibility(8);
      return;
    }
    ((ImageView)localObject1).setVisibility(0);
  }
  
  private void cA()
  {
    ShortVideoUtils.loadShortVideoSo(this.d);
    Object localObject = (FastImageHelper)q(83);
    if (this.n.getCurrentPanel() == 8)
    {
      ImageView localImageView = this.bK;
      if (localImageView != null) {
        localImageView.setContentDescription(this.d.getApplication().getString(2131886555));
      }
      ((FastImageHelper)localObject).b(true);
      this.n.a(1);
      return;
    }
    ((FastImageHelper)localObject).c();
    this.n.a(8);
    localObject = this.bL;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
      q(false);
    }
    localObject = this.bK;
    if (localObject != null) {
      ((ImageView)localObject).setContentDescription(this.d.getApplication().getString(2131886477));
    }
    m(0);
  }
  
  private void cB()
  {
    if (this.n.getCurrentPanel() == 3)
    {
      this.n.a(1);
      ReportController.b(this.d, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
    }
    else
    {
      this.n.a(3);
      localImageView = this.bL;
      if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
        q(false);
      }
      ReportController.b(this.d, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
    }
    ImageView localImageView = this.bK;
    if (localImageView != null) {
      localImageView.setContentDescription(this.d.getApplication().getString(2131886555));
    }
  }
  
  private void cC()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    StringBuilder localStringBuilder;
    if ((QLog.isColorLevel()) && (this.bL != null))
    {
      localObject = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onClick fun_btn start text.length ");
      localStringBuilder.append(this.Y.getText().length());
      localStringBuilder.append("mAudioBtn visibility:");
      localStringBuilder.append(this.bL.getVisibility());
      localStringBuilder.append(" currentPanel:");
      localStringBuilder.append(this.n.getCurrentPanel());
      localStringBuilder.append(" currenttime:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((this.Y.getText().length() > 0) && (this.n.getCurrentPanel() != 2))
    {
      localObject = this.bL;
      if ((localObject != null) && (((ImageView)localObject).getVisibility() != 0))
      {
        ax();
        if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.ah.b))
        {
          if ((this.n.getCurrentPanel() == 1) && (((InputMethodManager)this.e.getSystemService("input_method")).isActive(this.Y))) {
            this.n.b();
          }
          ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather(this.d, "aio_search_push");
        }
      }
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onClick fun_btn end text.length");
        localStringBuilder.append(this.Y.getText().length());
        localStringBuilder.append("cast time :");
        localStringBuilder.append(l2 - l1);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "P_CliOper", "Pb_account_lifeservice", "", "0X800584F", "0X800584F", 0, 0, "", "", "", "", false);
    }
    if (this.bF) {
      ReportController.b(this.d, "P_CliOper", "Pb_account_lifeservice", this.ah.b, "0X8005C9C", "0X8005C9C", 0, 1, 0, "", "", "", "");
    }
  }
  
  private void cD()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    if (!this.f.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null) {
        this.cl = ((PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(this.ah.b));
      }
    }
    Object localObject = this.cl;
    if (localObject != null)
    {
      a((PublicAccountInfo)localObject);
      return;
    }
    localObject = new NewIntent(this.f.getApplicationContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
    ((NewIntent)localObject).putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.8.17,3,5770");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.ah.b));
      label185:
      ((NewIntent)localObject).putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new PublicAccountChatPie.38(this));
      this.d.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label185;
    }
  }
  
  private void cE()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "ChatActivityConstants.MSG_PUBLICACCOUNT_ACCOUNTDETAIL");
    }
    Object localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.ah.b);
      if (localObject != null)
      {
        this.C.setText(((IPublicAccountDetail)localObject).getName());
        if (this.bp)
        {
          c((IPublicAccountDetail)localObject);
          this.bp = false;
        }
        localObject = this.cm;
        bG();
      }
    }
    if (this.bn)
    {
      this.bn = false;
      if (this.bo == null) {
        this.bo = ((IPublicAccountHandler)this.d.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      this.bo.onFollowPublicAccount(this.dC);
      bz();
    }
  }
  
  private void cF()
  {
    this.d.removeObserver(this.ds);
    this.ds = new NewPublicAccountObserver(new PublicAccountChatPie.44(this));
    this.d.addObserver(this.ds);
    PublicAccountStateReporter.a(this.d, true, this.ah.b, 0);
  }
  
  private void cG()
  {
    Object localObject = this.cT;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    this.cT = new NewIntent(this.f.getApplicationContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
    this.cT.putExtra("cmd", "follow");
    localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).ext.set("4");
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.ah.b));
    this.cT.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new PublicAccountChatPie.45(this);
    this.cT.setObserver((BusinessObserver)localObject);
    this.d.startServlet(this.cT);
  }
  
  private void cH()
  {
    if (this.cl == null)
    {
      localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null) {
        this.cl = ((PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(this.ah.b));
      }
    }
    Object localObject = this.cl;
    if ((localObject != null) && (((PublicAccountInfo)localObject).isSyncLbs) && (this.cl.mIsAgreeSyncLbs)) {
      cI();
    }
  }
  
  private void cI()
  {
    if (this.dd.get()) {
      return;
    }
    this.dd.set(true);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.f.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        this.f.requestPermissions(new PublicAccountChatPie.46(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      cJ();
      return;
    }
    cJ();
  }
  
  private void cJ()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicAccountChatPie.47(this, 1, true, true, 0L, false, false, "PublicAccountChatPie"));
  }
  
  private void cK()
  {
    a((RelativeLayout)this.n.getParent());
  }
  
  private void cL()
  {
    Object localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(this.ah.b);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(((PublicAccountInfo)localObject).accountFlag2) == -10L))
      {
        this.du = true;
        localObject = FaceDrawable.getFaceDrawable(this.d, 115, this.ah.b);
        if (localObject != null)
        {
          if (this.u != null) {
            this.u.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          }
          this.p.setRight1Icon((Drawable)localObject);
        }
      }
    }
  }
  
  private boolean cM()
  {
    return (this.ah != null) && (this.ah.b != null) && ("2747277822".equals(this.ah.b));
  }
  
  private boolean cN()
  {
    return EcshopFromUtils.a(this.ah);
  }
  
  private boolean cO()
  {
    return (this.ah != null) && (this.ah.b != null) && ("1816533856".equals(this.ah.b));
  }
  
  private void cP()
  {
    if (this.dH == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.dH;
    PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.ah.b);
    if (localPublicAccountInfo != null)
    {
      QQAppInterface localQQAppInterface = this.d;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localPublicAccountInfo.uin);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localPublicAccountInfo.name);
      localStringBuilder.append("");
      RecentPubAccHelper.a(localQQAppInterface, (String)localObject, l1 - l2, localStringBuilder.toString());
    }
    this.dH = 0L;
  }
  
  private void cQ()
  {
    if (this.dI != null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.dI = new PublicAccountChatPie.64(this);
    this.e.registerReceiver(this.dI, localIntentFilter);
  }
  
  private void cR()
  {
    if (this.dI == null) {
      return;
    }
    try
    {
      this.e.unregisterReceiver(this.dI);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PublicAccountChatPie", 2, "unregisterNetworkChangedReceiver error", localException);
    }
  }
  
  private void ca()
  {
    if (this.bY) {
      return;
    }
    this.bY = true;
    EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)this.d.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    Object localObject1 = this.d.getMessageFacade().o(this.ah.b, this.ah.a);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (localEcshopReportHandler == null) {
        return;
      }
      localObject1 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
      Object localObject2 = ((ChatMessage)localObject1).getExtInfoFromExtStr("public_account_msg_id");
      String str1 = ((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg");
      if (QLog.isColorLevel())
      {
        String str2 = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enter qqgouwu aio msgId = ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" hasAdver: ");
        localStringBuilder.append(str1);
        QLog.i(str2, 2, localStringBuilder.toString());
      }
      if ("1".equals(str1))
      {
        localObject2 = new IEcshopAdHandler.ReportInfo();
        ((IEcshopAdHandler.ReportInfo)localObject2).a = 2;
        localObject2 = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).rebuildReportParam((IEcshopAdHandler.ReportInfo)localObject2, (MessageRecord)localObject1);
        ((IEcshopAdHandler)this.d.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a((IEcshopAdHandler.ReportInfo)localObject2, null);
        if ((localObject1 instanceof MessageForStructing)) {
          a((MessageForStructing)localObject1);
        } else if ((localObject1 instanceof MessageForArkApp)) {
          a((MessageForArkApp)localObject1);
        }
      }
      else if ((localObject1 instanceof MessageForArkApp))
      {
        localEcshopReportHandler.a(134243863, ((ChatMessage)localObject1).senderuin, (String)localObject2, null, null, 0L, false);
      }
      else
      {
        localEcshopReportHandler.a(134243857, ((ChatMessage)localObject1).senderuin, (String)localObject2, null, null, 0L, false);
      }
      int i = this.f.getIntent().getIntExtra("jump_from", 4);
      if (i == 2) {
        localEcshopReportHandler.a(134243865, this.ah.b, null, null, null, i, false);
      }
    }
  }
  
  private void cb()
  {
    PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.ah.b);
    if ((localPublicAccountInfo != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(localPublicAccountInfo.accountFlag) == -2))
    {
      this.dg = true;
      bD();
      this.bU.f();
      if (this.bU.p <= 0)
      {
        this.bU.a(Long.valueOf(this.ah.b).longValue(), 1);
        return;
      }
      int k = ((TroopBindPublicAccountMgr)this.d.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).b(this.ah.b);
      if (k == -1)
      {
        this.bU.a(Long.valueOf(this.ah.b).longValue(), 2);
        return;
      }
      int j = 0;
      int i;
      if ((k & 0xF) == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (k >> 4 == 1) {
        j = 1;
      }
      if ((i != 0) && (j != 0))
      {
        this.dl = true;
      }
      else
      {
        this.bU.e();
        this.bU.b();
      }
      cj();
      return;
    }
    cj();
  }
  
  private void cc()
  {
    if ((NetworkUtil.getNetworkType(this.f.getApplicationContext()) == 1) && (this.ah.b != null) && (this.ah.b.equals("2632129500"))) {
      HtmlOffline.b("108", this.d, true, new PublicAccountChatPie.6(this));
    }
  }
  
  private void cd()
  {
    if ("3105932915".equals(this.ah.b))
    {
      ((IQQPluginPreloadService)this.d.getRuntimeService(IQQPluginPreloadService.class)).preload(5);
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "the public account is boodo comic");
      }
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.qqcomic.care");
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.carecomic.normal");
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.carecomic.update");
    }
  }
  
  private void ce()
  {
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).shouldPreloadWebProcess(this.ah.b))
    {
      IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)this.d.getRuntimeService(IWebProcessManagerService.class, "");
      if (localIWebProcessManagerService != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "doOnCreate, preload web process");
        }
        localIWebProcessManagerService.startWebProcess(-1, null);
      }
    }
  }
  
  private void cf()
  {
    if (this.bF)
    {
      if (this.bG) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.ah.b, "new", "", "", false);
      } else {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.ah.b, "old", "", "", false);
      }
    }
    else
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.ah.b, "", "", "", false);
      if ("2290230341".equals(this.ah.b))
      {
        ReportController.b(this.d, "CliOper", "", "", "0X80090E2", "0X80090E2", 0, 0, "", "", "", "");
        QZoneReport.a(2);
      }
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).enterPublicAccount(this.ah.b);
    if (((IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all")).isSupportPay(this.ah.b)) {
      this.bw = true;
    }
  }
  
  private void cg()
  {
    if (cM())
    {
      long l = ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getClickAioTime();
      if (Math.abs(System.currentTimeMillis() - l) > 500L) {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).initClickAioTime();
      }
      ThreadManagerV2.excute(new PublicAccountChatPie.7(this), 16, null, false);
    }
  }
  
  private void ch()
  {
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.ah.b)) {
      ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather(this.d, "aio_page_arrive");
    }
  }
  
  private void ci()
  {
    CustomMenuBar localCustomMenuBar = this.bj;
    if (localCustomMenuBar != null) {
      localCustomMenuBar.setVisibility(8);
    }
    aB();
    aD();
  }
  
  private void cj()
  {
    ThreadManager.postImmediately(new PublicAccountChatPie.10(this), null, true);
  }
  
  private void ck()
  {
    Object localObject1 = this.V.a().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ChatMessage)((Iterator)localObject1).next();
      if (MessageForStructing.class.isInstance(localObject2))
      {
        localObject2 = ((MessageForStructing)localObject2).structingMsg;
        if (StructMsgForGeneralShare.class.isInstance(localObject2)) {
          ((StructMsgForGeneralShare)localObject2).unInitPay();
        }
      }
    }
    localObject1 = this.bk;
    if ((localObject1 != null) && (((QQProgressDialog)localObject1).isShowing()))
    {
      this.bk.dismiss();
      this.bk = null;
    }
    localObject1 = this.dG;
    if ((localObject1 != null) && (((Dialog)localObject1).isShowing()))
    {
      this.dG.dismiss();
      this.dG = null;
    }
    if (this.ce.hasMessages(10)) {
      this.ce.removeMessages(10);
    }
    localObject1 = this.dh;
    if ((localObject1 != null) && (((QQCustomDialog)localObject1).isShowing()))
    {
      this.dh.dismiss();
      this.dh = null;
    }
    localObject1 = this.bU;
    if (localObject1 != null) {
      ((TroopEntranceBar)localObject1).a();
    }
    localObject1 = this.bo;
    if (localObject1 != null) {
      ((IPublicAccountHandler)localObject1).clearWeatherInfoListener();
    }
  }
  
  private boolean cl()
  {
    if (this.U != null) {
      this.U.setDrawFinishedListener(null);
    }
    if (this.aY)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "hasDestory = true return");
      }
      return true;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).cleanPublicAccountObserver();
    if (this.dD != null) {}
    try
    {
      this.e.unregisterReceiver(this.dD);
      label73:
      this.dD = null;
      if (this.cS != null) {
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccountCancelCallback(this.cS);
      }
      NewIntent localNewIntent = this.cT;
      if (localNewIntent != null) {
        localNewIntent.setObserver(null);
      }
      if (this.cU != null)
      {
        this.f.removeObserver(this.cU);
        this.cU = null;
      }
      return false;
    }
    catch (Exception localException)
    {
      break label73;
    }
  }
  
  private void cm()
  {
    if (this.f.getIntent().getExtras() == null) {
      L();
    }
  }
  
  private boolean cn()
  {
    if (!this.cB)
    {
      if (this.cG) {
        return true;
      }
      if ((this.bl != null) && (this.cV != null)) {
        return this.by == 5;
      }
    }
    return true;
  }
  
  private void co()
  {
    this.bl = LayoutInflater.from(this.f.getBaseContext()).inflate(2131624126, this.o, false);
    Object localObject = this.bl;
    if (localObject == null) {
      return;
    }
    ((View)localObject).setClickable(true);
    this.bl.findViewById(2131435219).setOnClickListener(new PublicAccountChatPie.20(this));
    if (this.br == 2)
    {
      this.bl.findViewById(2131440823).setVisibility(8);
      this.bl.findViewById(2131440809).setVisibility(8);
    }
    else if (this.cB)
    {
      this.bl.findViewById(2131440823).setVisibility(8);
      this.bl.findViewById(2131440809).setVisibility(8);
    }
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).topMargin = this.e.getResources().getDimensionPixelSize(2131299920);
    this.o.addView(this.bl, (ViewGroup.LayoutParams)localObject);
  }
  
  private void cp()
  {
    this.bm = ((PublicMenuBar)this.bl.findViewById(2131440806));
    this.bm.setOnMenuItemClickListener(new PublicAccountChatPie.21(this));
    this.bm.c();
    boolean bool = this.cB;
    int i = 2131888776;
    Object localObject;
    MenuItem localMenuItem1;
    if (!bool)
    {
      localObject = this.f;
      if (!this.dl) {
        i = 2131888775;
      }
      localObject = new MenuItem("DO_NOT_FOLLOW", ((BaseActivity)localObject).getString(i), aX().getResources().getDrawable(2130842730), 0);
      localMenuItem1 = new MenuItem("DO_FOLLOW", this.f.getString(2131888774), aX().getResources().getDrawable(2130842615), 1);
      this.bm.a((MenuItem)localObject, 2131626026);
      this.bm.a(localMenuItem1, 2131626026);
    }
    else
    {
      localObject = new MenuItem("DO_CANCEL", this.f.getString(2131887651), aX().getResources().getDrawable(2130842730), 0);
      localMenuItem1 = new MenuItem("DO_FOLLOW", this.f.getString(2131888774), aX().getResources().getDrawable(2130842615), 1);
      MenuItem localMenuItem2 = new MenuItem("DO_NOT_FOLLOW", this.f.getString(2131888776), aX().getResources().getDrawable(2130842730), 0);
      this.cJ = this.bm.a((MenuItem)localObject, 2131626026);
      this.cI = this.bm.a(localMenuItem2, 2131626026);
      this.cK = this.bm.a(localMenuItem1, 2131626026);
    }
    this.bm.setSwitchButtonVisibility(false);
    if (this.du)
    {
      this.bm.setVisibility(8);
      return;
    }
    this.bm.setVisibility(0);
  }
  
  private void cq()
  {
    String str = this.d.getCurrentUin();
    Object localObject = (TicketManager)this.d.getManager(2);
    if (localObject != null) {
      localObject = ((TicketManager)localObject).getSkey(str);
    } else {
      localObject = null;
    }
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putString("op", "0");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.ah.b);
    localBundle.putString("puin", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(str);
    localStringBuilder.append(";skey=");
    localStringBuilder.append((String)localObject);
    localBundle.putString("Cookie", localStringBuilder.toString());
    localBundle.putString("Referer", "https://buluo.qq.com");
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", this.d.getApp().getApplicationContext());
    new HttpWebCgiAsyncTask2("https://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new PublicAccountChatPie.26(this), 1000, null).a(localHashMap);
    bA();
  }
  
  private boolean cr()
  {
    this.cP = ((ImageView)this.aZ.findViewById(2131432704));
    Object localObject1 = this.cP;
    if (localObject1 != null) {
      ((ImageView)localObject1).setContentDescription(this.f.getText(2131894205));
    }
    if (this.cO != null) {
      this.o.removeView(this.cO);
    }
    if (this.bl != null)
    {
      this.o.removeView(this.bl);
      this.bl = null;
    }
    if (this.cV != null) {
      this.U.removeHeaderView(this.cV);
    }
    this.bj = ((CustomMenuBar)this.o.findViewById(2131432703));
    localObject1 = this.bj;
    if (localObject1 == null)
    {
      this.f.getLayoutInflater().inflate(2131624127, this.o);
      this.bj = ((CustomMenuBar)this.o.findViewById(2131432703));
    }
    else
    {
      ((CustomMenuBar)localObject1).setVisibility(8);
    }
    localObject1 = this.bj;
    if (localObject1 == null) {
      return true;
    }
    ((CustomMenuBar)localObject1).setMenuType(this.bi.getPublicAccountMenuType(ae()));
    if (CustomMenuBar.a())
    {
      this.bj.setBackgroundColor(this.f.getResources().getColor(2131168198));
      this.bj.setMinimumHeight(AIOUtils.b(48.0F, this.f.getResources()));
    }
    if (this.U != null)
    {
      Object localObject2 = this.U.getLayoutParams();
      localObject1 = this.bj.getLayoutParams();
      if ((localObject2 != null) && (localObject1 != null) && ((localObject2 instanceof RelativeLayout.LayoutParams)) && ((localObject1 instanceof RelativeLayout.LayoutParams)))
      {
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        int[] arrayOfInt = ((RelativeLayout.LayoutParams)localObject2).getRules();
        if ((arrayOfInt.length > 2) && (arrayOfInt[2] == 2131435809))
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131432703);
          this.U.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = (RelativeLayout.LayoutParams)localObject1;
          ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131435809);
          this.bj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    return false;
  }
  
  private void cs()
  {
    this.bj.setOnMenuItemClickListener(new PublicAccountChatPie.33(this));
  }
  
  private void ct()
  {
    this.bj.setOnBackClickListner(new PublicAccountChatPie.34(this));
  }
  
  private boolean cu()
  {
    if ((cM()) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()))
    {
      QLog.d(this.c, 2, "updatePublicAccountMenu new qqgame pubaccount return");
      return true;
    }
    if (cN())
    {
      IEcshopChatPieDelegate localIEcshopChatPieDelegate = this.dw;
      if ((localIEcshopChatPieDelegate != null) && (!localIEcshopChatPieDelegate.a()))
      {
        QLog.d(this.c, 2, "updatePublicAccountMenu new qqshop pubaccount return");
        return true;
      }
    }
    if (cO())
    {
      aB();
      QLog.d(this.c, 2, "updatePublicAccountMenu new qqlive pubaccount return");
      return true;
    }
    return this.bj == null;
  }
  
  private void cv()
  {
    SharedPreferences localSharedPreferences = this.f.getSharedPreferences("public_aio_setting", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("firstOpen_");
    ((StringBuilder)localObject).append(this.ah.b);
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.getBoolean((String)localObject, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.ah.b);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.bi.sendMenuEventequest(this.f, this.d, this.ah.b, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.35(this, localSharedPreferences, (String)localObject));
  }
  
  private void cw()
  {
    if (this.dn == 0L) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (this.d != null)
    {
      Object localObject = this.d.getCurrentAccountUin();
      if (localObject != null) {
        localHashMap.put("uin", localObject);
      }
      if ((this.ah != null) && (this.ah.b != null)) {
        localHashMap.put("puin", this.ah.b);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.bZ);
      localHashMap.put("menu_click", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.cb);
      localHashMap.put("menu_to_webview", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.ca);
      localHashMap.put("article_click", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.cc);
      localHashMap.put("article_to_webview", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(NetworkCenter.getInstance().getNetType());
      localHashMap.put("net_type", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_do);
      localHashMap.put("unread_count", ((StringBuilder)localObject).toString());
      long l = System.currentTimeMillis() - this.dn;
      boolean bool;
      if ((this.cc == 0) && (this.cb == 0)) {
        bool = false;
      } else {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("public account webview preload data: ");
        ((StringBuilder)localObject).append("duration: ");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(", entered: ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", exinfo: ");
        ((StringBuilder)localObject).append(localHashMap.toString());
        QLog.d(this.c, 2, ((StringBuilder)localObject).toString());
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPublicAccountWebviewPreload", bool, l, 0L, localHashMap, "");
      this.dn = 0L;
      this.jdField_do = 0;
      this.cb = 0;
      this.bZ = 0;
      this.ca = 0;
      this.cc = 0;
    }
  }
  
  private void cx()
  {
    ReportController.b(this.d, "CliOper", "", "", "0X8004EFD", "0X8004EFD", 0, 0, "", "", "", "");
    ReportController.b(this.d, "P_CliOper", "Pb_account_lifeservice", "", "0X8004F08", "0X8004F08", 0, 0, "", "", "", "");
    PAStartupTracker.a(null, "pubAcc_profile_display", "");
  }
  
  private void cy()
  {
    if (this.du) {
      ReportController.b(null, "dc00898", "", this.ah.b, "auth_aio", "clk_return", 0, 0, "", "", this.ah.e, "");
    }
  }
  
  private void cz()
  {
    ImageView localImageView;
    if (this.n.getCurrentPanel() == 2)
    {
      this.n.b();
      localImageView = this.bL;
      if (localImageView != null)
      {
        localImageView.setImageResource(this.bM);
        this.bL.setContentDescription(this.d.getApp().getString(2131886572));
      }
    }
    else
    {
      this.n.a(2);
      localImageView = this.bL;
      if (localImageView != null)
      {
        localImageView.setImageResource(this.bN);
        this.bL.setContentDescription(this.d.getApp().getString(2131886571));
      }
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (((paramInt2 > 5) && (this.cg)) || ((paramInt1 == this.U.getHeaderViewsCount()) && (paramInt2 > 0) && (this.cg) && (!this.bz)))
    {
      this.bz = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.cY);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setAnimationListener(new PublicAccountChatPie.18(this));
      this.bl.startAnimation(localTranslateAnimation);
    }
  }
  
  private void d(List<mobileqq_mp.ButtonInfo> paramList)
  {
    this.cR = this.bi.getMenuSetting(this.f, this.d, ae(), this.dv, false);
    if ((paramList != null) && (!paramList.isEmpty())) {
      p(true);
    }
    this.db = true;
    if (this.bS == null)
    {
      this.bS = ((IPublicAccountTipsManager)QRoute.api(IPublicAccountTipsManager.class));
      this.bS.init(this.e);
    }
    Object localObject = this.f.getIntent();
    if ((((Intent)localObject).hasExtra("pub_account_type")) && ("type_ecshop_account".equals(((Intent)localObject).getStringExtra("pub_account_type"))))
    {
      localObject = ((Intent)localObject).getStringExtra("ecshop_distance_tip");
      localObject = this.bS.createEcshopDistanceTipsBar((String)localObject, this);
      this.bS.showTipsBar(this.o, (View)localObject);
      ReportController.b(this.d, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconPv", "Pv_shopnearbyicon", 0, 0, "", "", "", "");
    }
    if ((cM()) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()))
    {
      aB();
      localObject = this.bj;
      if (localObject != null) {
        ((CustomMenuBar)localObject).setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "initPublicAccountMenu new qqgame pubaccount return");
      }
    }
    localObject = this.bj;
    if ((localObject != null) && (((CustomMenuBar)localObject).getVisibility() == 0) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (mobileqq_mp.ButtonInfo)paramList.next();
        if (localObject != null) {
          OfficialAccountReporter.a.a(ae(), ((mobileqq_mp.ButtonInfo)localObject).id.get(), ((mobileqq_mp.ButtonInfo)localObject).name.get());
        }
      }
    }
  }
  
  private void e(List<mobileqq_mp.ButtonInfo> paramList)
  {
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      if (i > 2) {
        return;
      }
      Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i);
      Object localObject1;
      if (((mobileqq_mp.ButtonInfo)localObject2).key.has()) {
        localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).key.get();
      } else {
        localObject1 = "";
      }
      String str;
      if (((mobileqq_mp.ButtonInfo)localObject2).name.has()) {
        str = ((mobileqq_mp.ButtonInfo)localObject2).name.get();
      } else {
        str = "";
      }
      int j;
      if (((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
        j = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
      } else {
        j = 0;
      }
      MenuItem localMenuItem = new MenuItem((String)localObject1, str, null, j);
      localMenuItem.a((mobileqq_mp.ButtonInfo)localObject2);
      if (((mobileqq_mp.ButtonInfo)localObject2).sub_button.has()) {
        localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).sub_button.get();
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          mobileqq_mp.ButtonInfo localButtonInfo = (mobileqq_mp.ButtonInfo)((Iterator)localObject2).next();
          if (localButtonInfo.key.has()) {
            localObject1 = localButtonInfo.key.get();
          } else {
            localObject1 = "";
          }
          if (localButtonInfo.name.has()) {
            str = localButtonInfo.name.get();
          } else {
            str = "";
          }
          if (localButtonInfo.id.has()) {
            j = localButtonInfo.id.get();
          } else {
            j = 0;
          }
          localObject1 = new MenuItem((String)localObject1, str, null, j);
          ((MenuItem)localObject1).a(localButtonInfo);
          localMenuItem.a((MenuItem)localObject1);
        }
      }
      this.bj.a(localMenuItem, ae());
      i += 1;
    }
  }
  
  private void f(String paramString)
  {
    AIOUtils.q = true;
    this.bk = new QQProgressDialog(this.o.getContext(), this.f.getTitleBarHeight());
    long l = NetConnInfoCenter.getServerTime();
    String str = this.ah.b;
    QQAppInterface localQQAppInterface;
    Object localObject1;
    Object localObject2;
    if ("DO_FOLLOW".equals(paramString))
    {
      if (this.dl)
      {
        cq();
        paramString = this.bU;
        if ((paramString != null) && (paramString.q != null) && (this.bU.q.size() > 0)) {
          paramString = ((TroopInfo)this.bU.q.get(0)).troopuin;
        } else {
          paramString = "";
        }
        localQQAppInterface = this.d;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(str);
        ReportController.b(localQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_close_temp", 0, 0, paramString, ((StringBuilder)localObject1).toString(), "", "");
        this.bi.init(this.f, this.d, this.d.getAccount(), this.ah.b, new PublicAccountChatPie.22(this));
        return;
      }
      if (this.bq != null)
      {
        paramString = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localQQAppInterface = this.d;
        localObject1 = Long.toString(l);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.bq.msgId);
        paramString.publicAccountReportClickEventForMigrate(localQQAppInterface, "CliOper", "", str, "0X8004EF5", "0X8004EF5", 0, 0, (String)localObject1, "", ((StringBuilder)localObject2).toString(), this.cW, false);
      }
      s(2131893010);
      bJ();
      return;
    }
    if ("DO_NOT_FOLLOW".equals(paramString))
    {
      if (this.bq != null)
      {
        paramString = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localQQAppInterface = this.d;
        localObject1 = Long.toString(l);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.bq.msgId);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.cW);
        paramString.publicAccountReportClickEventForMigrate(localQQAppInterface, "CliOper", "", str, "0X8004EF7", "0X8004EF7", 0, 0, (String)localObject1, "", (String)localObject2, localStringBuilder.toString(), false);
      }
      if (this.dl)
      {
        g(str);
        paramString = this.bU;
        if ((paramString != null) && (paramString.q != null) && (this.bU.q.size() > 0)) {
          paramString = ((TroopInfo)this.bU.q.get(0)).troopuin;
        } else {
          paramString = "";
        }
        localQQAppInterface = this.d;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(str);
        ReportController.b(localQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_focus_temp", 0, 0, paramString, ((StringBuilder)localObject1).toString(), "", "");
        return;
      }
      bE();
      return;
    }
    if ("DO_CANCEL".equals(paramString))
    {
      s(2131893010);
      this.cS = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccount(this.ah.b, 0, false, BaseApplication.getContext(), this.d, new PublicAccountChatPie.23(this));
    }
  }
  
  private boolean f(View paramView)
  {
    paramView = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (ServiceAccountFolderManager.c(this.d, this.ah.b))
    {
      String str = (String)EcShopAssistantManager.j.get(this.ah.b);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      Intent localIntent = new Intent(this.e, SplashActivity.class);
      localIntent.putExtra("uin", str);
      localIntent = AIOUtils.a(localIntent, null);
      if (paramView.n(str))
      {
        localIntent.putExtra("uintype", 0);
      }
      else
      {
        localIntent.putExtra("uintype", 1005);
        paramView = new StringBuilder();
        paramView.append(this.ah.e);
        paramView.append(HardCodeUtil.a(2131906549));
        localIntent.putExtra("uinname", paramView.toString());
        localIntent.putExtra("key_sub_title_from", "来自\"QQ咨询\"");
      }
      this.e.startActivity(localIntent);
      ReportController.b(this.d, "CliOper", "", "", "Shop_customservice", "Clk_shopcustomservice", 0, 0, "", "", this.ah.b, this.d.getCurrentAccountUin());
    }
    return false;
  }
  
  private boolean f(List<mobileqq_mp.ButtonInfo> paramList)
  {
    this.bj.c();
    if (this.ah != null) {
      this.bj.setMenuType(this.bi.getPublicAccountMenuType(ae()));
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = this.cP;
      if (paramList != null) {
        paramList.setVisibility(0);
      }
      return false;
    }
    if (this.X != null) {
      this.X.setVisibility(0);
    }
    this.i.p().d().b().a();
    paramList = this.cP;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    return true;
  }
  
  private void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "unfollow");
    }
    v(2131893007);
    Object localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.ah.b);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((IPublicAccountDetail)localObject).getAccountFlag()) != -4))
      {
        this.d.removeObserver(this.dt);
        this.dt = new NewPublicAccountObserver(new PublicAccountChatPie.28(this, paramString));
        this.d.addObserver(this.dt);
        PublicAccountStateReporter.a(this.d, false, this.ah.b, 0);
      }
      else
      {
        localObject = new NewIntent(BaseApplicationImpl.getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
        ((NewIntent)localObject).putExtra("cmd", "unfollow");
        mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
        localUnFollowRequest.uin.set((int)Long.parseLong(paramString));
        ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
        this.dB = new PublicAccountChatPie.27(this, paramString);
        ((NewIntent)localObject).setObserver(this.dB);
        this.d.startServlet((NewIntent)localObject);
      }
    }
    this.dA += 1;
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).removeLbsUin(this.d, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "unfollow exit");
    }
  }
  
  private boolean g(View paramView)
  {
    if (((paramView.getTag() instanceof String)) && ("tag_on_nearby_tips_click".equals(paramView.getTag())) && (this.e != null) && (!TextUtils.isEmpty(this.ah.b)))
    {
      if (System.currentTimeMillis() - this.bT < 1000L) {
        return true;
      }
      this.bT = System.currentTimeMillis();
      paramView = new StringBuilder("https://gouwu.qq.com/m/html/shop_map.html?_wv=1027&shop_uin=");
      paramView.append(this.ah.b);
      Intent localIntent = new Intent(this.e, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView.toString());
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("webStyle", "noBottomBar");
      this.e.startActivity(localIntent);
      ReportController.b(this.d, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconClk", "Clk_shopnearbyicon", 0, 0, "", "", "", "");
    }
    return false;
  }
  
  private void i(Intent paramIntent)
  {
    try
    {
      if (EcshopFromUtils.b(this.ah))
      {
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.gouwu.video");
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.gwh.video");
        GdtNotify.b();
        if (cN())
        {
          if (((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).isArkReportOpen()) {
            ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.qqshop");
          }
          j(paramIntent);
          return;
        }
        paramIntent = (IEcshopAdHandler)this.d.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
        if (paramIntent != null)
        {
          paramIntent.a(null, null, false, null, 2);
          return;
        }
      }
    }
    catch (Throwable paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountChatPie", 2, paramIntent, new Object[0]);
      }
    }
  }
  
  private void j(Intent paramIntent)
  {
    try
    {
      PublicAccountChatPie.8 local8 = new PublicAccountChatPie.8(this);
      this.dw = ((IEcshopChatPieApi)QRoute.api(IEcshopChatPieApi.class)).createEcshopChatPie(paramIntent, local8);
      if (this.dw.a(this.e, this.o))
      {
        ci();
        this.U.post(new PublicAccountChatPie.9(this));
      }
      paramIntent = (IEcshopAdHandler)this.d.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
      if (paramIntent != null)
      {
        paramIntent.a(null, null, false, null, 10);
        return;
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e(this.c, 1, QLog.getStackTraceString(paramIntent));
    }
  }
  
  private void v(int paramInt)
  {
    this.m.postDelayed(new PublicAccountChatPie.29(this, paramInt), 500L);
  }
  
  private void w(int paramInt)
  {
    Object localObject = this.di;
    if (localObject == null) {
      return;
    }
    localObject = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Y.getLayoutParams();
    if (((LinearLayout.LayoutParams)localObject).gravity != paramInt)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = paramInt;
      this.di.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (localLayoutParams.gravity != paramInt)
    {
      localLayoutParams.gravity = paramInt;
      this.Y.setLayoutParams(localLayoutParams);
    }
    localObject = (LinearLayout.LayoutParams)this.bP.getLayoutParams();
    if (((LinearLayout.LayoutParams)localObject).gravity != paramInt)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = paramInt;
      this.bP.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void B()
  {
    if (this.du)
    {
      "https://h5.qzone.qq.com/subscription/homepage/{userId}?_proxy=1&_wv=16777217&_wwv=4".replace("{userId}", this.ah.b);
      SubscribeLaucher.a(aX(), this.ah.b);
      ReportController.b(null, "dc00898", "", this.ah.b, "auth_aio", "clk_head", 0, 0, "", "", this.ah.e, "");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    localIntent.putExtra("uin", this.ah.b);
    localIntent.putExtra("uinname", this.ah.e);
    localIntent.putExtra("uintype", this.ah.a);
    if (this.cB) {
      localIntent.putExtra("qidian_chat", true);
    }
    AbsStructMsg localAbsStructMsg = this.bq;
    if (localAbsStructMsg != null) {
      localIntent.putExtra("public_account_msg_id", localAbsStructMsg.msgId);
    }
    if ((1 == this.ah.a) || (1000 == this.ah.a) || (1020 == this.ah.a) || (1004 == this.ah.a)) {
      localIntent.putExtra("troop_uin", this.ah.c);
    }
    if ((((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.ah.b)) && (((IQQGameSubscribeService)this.d.getRuntimeService(IQQGameSubscribeService.class)).enterSubscribeManagePage(this.f.getActivity(), "qqGamePageRouter", "qqGamePageRouter", "subscription/manage"))) {
      return;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfileForResult(localIntent, this.d, this.f.getActivity(), this.ah.b, -1, 2000, 1, ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isComeFromReadInJoy());
  }
  
  protected void D()
  {
    if (this.u != null)
    {
      if ("2277373213".equals(this.ah.b))
      {
        this.p.setRight1Icon(2130849230);
        return;
      }
      if (cO()) {
        this.p.findViewById(2131436194).setVisibility(8);
      } else {
        this.p.setRight1Icon(2130852269, 2130852270);
      }
      this.p.setRight1Icon(2130852269, 2130852270);
      this.u.setContentDescription(this.f.getText(2131894197));
    }
  }
  
  public void K()
  {
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportInQQNews(this.ah.b, this.dj, this.bX, this.V.a());
    if (cl()) {
      return;
    }
    super.K();
    Object localObject1 = this.bi;
    if (localObject1 != null)
    {
      ((IPublicAccountManager)localObject1).clearOldPublicAccountData(ae());
      this.bi.clearBroadcastReceiver(this.e);
    }
    ck();
    a();
    cw();
    if (this.dj != 0L)
    {
      this.dj = (System.currentTimeMillis() - this.dj);
      localObject1 = this.d;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.ah.b);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.dj);
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.dE);
      ReportController.b((AppRuntime)localObject1, "dc00899", "Pb_account_lifeservice", (String)localObject2, "0X80064D5", "0X80064D5", 0, 0, "", (String)localObject3, localStringBuilder.toString(), "");
      this.dj = 0L;
      this.dk = 0;
    }
    if (this.cn) {
      ThreadManager.executeOnSubThread(new PublicAccountChatPie.11(this));
    }
    bP();
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setComeFromReadInJoy(false);
    try
    {
      if (EcshopFromUtils.b(this.ah))
      {
        GdtNotify.c();
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).removeNotify("com.tencent.gouwu.video");
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).removeNotify("com.tencent.gwh.video");
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).removeNotify("com.tencent.qqshop");
      }
      label346:
      cR();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label346;
    }
  }
  
  public void O()
  {
    super.O();
    cP();
    long l = NetConnInfoCenter.getServerTime() * 1000L;
    if (!this.bD.isEmpty())
    {
      int i = this.bD.size() - 1;
      ReportController.b(this.d, "P_CliOper", "Pb_account_lifeservice", this.ah.b, "0X8005C35", "0X8005C35", 0, 1, 0, (String)this.bD.get(i), String.valueOf(this.bC), String.valueOf(l), (String)this.bE.get(i));
    }
    if (this.bF)
    {
      if (this.bG)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "P_CliOper", "Pb_account_lifeservice", this.ah.b, "0X8005D16", "0X8005D16", 0, 0, "new", String.valueOf(l - this.bI), "", "", false);
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.d, "P_CliOper", "Pb_account_lifeservice", this.ah.b, "0X8005D16", "0X8005D16", 0, 0, "old", String.valueOf(l - this.bI), "", "", false);
    }
  }
  
  public void P()
  {
    if ((this.d != null) && (this.ah != null)) {
      ((EcShopAssistantManager)this.d.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).w = this.ah.b;
    }
    super.P();
    this.cd.e();
    Object localObject1 = (PublicAccountInfo)((IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.ah.b);
    if (localObject1 != null) {
      switch (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((PublicAccountInfo)localObject1).accountFlag))
      {
      default: 
        break;
      case -4: 
      case -3: 
      case -2: 
        PublicAccountEventReport.a(this.d, this.ah.b, this.dq, 3, System.currentTimeMillis() - this.dr);
        break;
      case -5: 
        PublicAccountEventReport.a(this.d, this.ah.b, this.dq, 4, System.currentTimeMillis() - this.dr);
        break;
      case -7: 
      case -6: 
      case -1: 
        PublicAccountEventReport.a(this.d, this.ah.b, this.dq, 2, System.currentTimeMillis() - this.dr);
      }
    }
    if (cN())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop", 2, "report stay page time tabid is1");
      }
      localObject1 = (IEcshopReportApi)QRoute.api(IEcshopReportApi.class);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(NetConnInfoCenter.getServerTimeMillis());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis() - this.dr);
      localStringBuilder.append("");
      ((IEcshopReportApi)localObject1).reportEcshopTo644("gouwu.aio.stay", "1", (String)localObject2, localStringBuilder.toString());
      localObject1 = (IEcshopReportApi)QRoute.api(IEcshopReportApi.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(NetConnInfoCenter.getServerTimeMillis());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis() - this.dr);
      localStringBuilder.append("");
      ((IEcshopReportApi)localObject1).reportEcshopToBeacon("gouwu_aio_stay", "1", (String)localObject2, localStringBuilder.toString());
    }
    OfficialAccountReporter.a.a(ae());
  }
  
  protected void Q()
  {
    super.Q();
    this.m.sendEmptyMessageDelayed(37, 500L);
    if (this.bU.u)
    {
      this.bU.a(this.d);
      this.bU.c();
    }
    if ((((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.ah.b)) && (this.Y != null)) {
      this.Y.setHint(HardCodeUtil.a(2131906516));
    }
    if ((!this.db) && (this.dc))
    {
      this.dc = false;
      ThreadManager.postImmediately(new PublicAccountChatPie.5(this), null, true);
    }
    this.bI = (NetConnInfoCenter.getServerTime() * 1000L);
    if (ChatActivityUtils.b(this.d, this.ah))
    {
      if (AIOTopRightButtonConfig.a().b(this.d.getCurrentAccountUin()))
      {
        this.A.setVisibility(0);
        this.A.setOnClickListener(this);
      }
      else
      {
        this.A.setVisibility(8);
      }
    }
    else if ((this.C.getText() != null) && (this.C.getText().length() < 6)) {
      this.A.setVisibility(4);
    } else {
      this.A.setVisibility(8);
    }
    EcShopHandler localEcShopHandler = (EcShopHandler)this.d.getBusinessHandler(BusinessHandlerFactory.ECSHOP_HANDLER);
    if (ServiceAccountFolderManager.c(this.d, this.ah.b))
    {
      long l = 0L;
      if (EcShopAssistantManager.k.get(this.ah.b) != null) {
        l = ((Long)EcShopAssistantManager.k.get(this.ah.b)).longValue();
      }
      if ((!TextUtils.isEmpty((String)EcShopAssistantManager.j.get(this.ah.b))) && (System.currentTimeMillis() - l <= EcShopAssistantManager.l))
      {
        if (AIOTopRightButtonConfig.a().b(this.d.getCurrentAccountUin()))
        {
          this.A.setVisibility(0);
          this.A.setOnClickListener(this);
          this.p.setRight2Icon(2130848971);
        }
        else
        {
          this.A.setVisibility(8);
        }
      }
      else
      {
        EcShopAssistantManager.k.put(this.ah.b, Long.valueOf(System.currentTimeMillis()));
        localEcShopHandler.a(this.ah.b);
      }
    }
    if ((cN()) && (this.aC)) {
      ((IEcshopRainViewApi)QRoute.api(IEcshopRainViewApi.class)).addRainView(this.o, this.e);
    }
  }
  
  public void S()
  {
    if ((this.dl) && (this.dm)) {
      return;
    }
    this.dH = System.currentTimeMillis();
    try
    {
      ark.arkNotify("com.tencent.weather", "pubaccountPendantRefresh", "", "json");
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e(this.c, 1, "ark.arkNotify exception:", localUnsatisfiedLinkError);
    }
    super.S();
    if (!this.dm) {
      ThreadManager.post(new PublicAccountChatPie.54(this), 5, null, false);
    }
    this.dm = true;
    this.dr = System.currentTimeMillis();
    ReportController.b(null, "dc00898", "", this.ah.b, "auth_aio", "exp", 0, 0, "", "", this.ah.e, "");
    OfficialAccountReporter.a.a();
  }
  
  public void U()
  {
    super.U();
    this.db = false;
    this.dc = false;
  }
  
  public boolean V()
  {
    try
    {
      if ((cN()) && (this.dw != null)) {
        this.dw.a(aX());
      }
      label27:
      return super.V();
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }
  
  public Map<String, String> a(AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg != null) {
      try
      {
        if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
        {
          paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).mMsgActionData;
          if ((paramAbsStructMsg != null) && (!TextUtils.isEmpty(paramAbsStructMsg)))
          {
            paramAbsStructMsg = URLUtil.b(paramAbsStructMsg.substring(paramAbsStructMsg.indexOf("?") + 1));
            return paramAbsStructMsg;
          }
        }
      }
      catch (Exception paramAbsStructMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, paramAbsStructMsg.getMessage());
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    ChatMessage localChatMessage;
    String str1;
    if (this.V.getCount() >= 1)
    {
      localChatMessage = (ChatMessage)this.V.a().get(this.V.getCount() - 1);
      str3 = "0";
      if (localChatMessage != null)
      {
        str1 = localChatMessage.getExtInfoFromExtStr("gdt_msgClick");
        if (TextUtils.isEmpty(str1)) {}
      }
    }
    try
    {
      localObject = new JSONObject(str1);
      str1 = str3;
      if (((JSONObject)localObject).has("ad_id")) {
        str1 = ((JSONObject)localObject).getString("ad_id");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        long l;
        String str2 = str3;
      }
    }
    str3 = localChatMessage.getExtInfoFromExtStr("pa_msgId");
    localObject = this.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localChatMessage.frienduin);
    ReportController.b((AppRuntime)localObject, "P_CliOper", "Pb_account_lifeservice", localStringBuilder.toString(), "0X8005C38", "0X8005C38", 0, 1, 0, str3, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
    if (this.bF)
    {
      l = NetConnInfoCenter.getServerTime() * 1000L;
      if (this.bG)
      {
        ReportController.b(this.d, "P_CliOper", "Pb_account_lifeservice", this.ah.b, "0X8005D17", "0X8005D17", 0, 1, 0, "new", String.valueOf(l - this.bH), "", "");
        return;
      }
      ReportController.b(this.d, "P_CliOper", "Pb_account_lifeservice", this.ah.b, "0X8005D17", "0X8005D17", 0, 1, 0, "old", String.valueOf(l - this.bH), "", "");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.dc = true;
  }
  
  void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.d.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(this.ah.b, 3, paramInt, 1, paramBusinessObserver);
    }
  }
  
  public void a(Editable paramEditable)
  {
    b(paramEditable);
    boolean bool3 = this.aa;
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      this.bO.setSelected(true);
      this.bO.setText(2131887750);
      localObject = this.bO;
      if (paramEditable.length() > 0) {
        bool1 = true;
      }
      ((PatchedButton)localObject).setEnabled(bool1);
      return;
    }
    Object localObject = this.bL;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
      return;
    }
    localObject = this.bO;
    bool1 = bool2;
    if (paramEditable.length() > 0) {
      bool1 = true;
    }
    ((PatchedButton)localObject).setEnabled(bool1);
    if (paramEditable.length() > 0)
    {
      this.bO.setText(2131887750);
      this.bO.setSelected(true);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if ((this.ah.a == 1008) && (ServiceAccountFolderManager.b(paramQQAppInterface, this.ah.b)) && (ServiceAccountFolderManager.a().a(this.ah.b))) {
      ServiceAccountFolderManager.a().c(paramQQAppInterface, this.ah.b);
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    super.a(paramChatMessage);
    Object localObject2 = paramChatMessage.frienduin;
    int i = paramChatMessage.istroop;
    Object localObject1;
    if (TroopBarAssistantManager.a().a(this.d, (String)localObject2, i))
    {
      localObject1 = this.d.getProxyManager().g();
      localObject2 = ((RecentUserProxy)localObject1).b((String)localObject2, i);
      if (localObject2 != null) {
        ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
      }
    }
    if (cN())
    {
      localObject1 = this.dw;
      if (localObject1 != null) {
        ((IEcshopChatPieDelegate)localObject1).a(paramChatMessage);
      }
    }
  }
  
  void a(PublicAccountInfo paramPublicAccountInfo)
  {
    Object localObject1;
    if (paramPublicAccountInfo != null)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = this.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=");
        ((StringBuilder)localObject2).append(paramPublicAccountInfo.mIsSyncLbsSelected);
        ((StringBuilder)localObject2).append(", eqqPublicAccountInfo.isSyncLbs=");
        ((StringBuilder)localObject2).append(paramPublicAccountInfo.isSyncLbs);
        ((StringBuilder)localObject2).append(", eqqPublicAccountInfo.mIsAgreeSyncLbs=");
        ((StringBuilder)localObject2).append(paramPublicAccountInfo.mIsAgreeSyncLbs);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "showEqqLbsEnableDialog(): pam is null");
        }
        return;
      }
      if ((paramPublicAccountInfo.isSyncLbs) && (!paramPublicAccountInfo.mIsSyncLbsSelected) && (!paramPublicAccountInfo.mIsAgreeSyncLbs) && (!this.de))
      {
        localObject2 = this.f.getString(2131889030);
        String str = String.format(this.f.getString(2131889028), new Object[] { this.ah.e });
        this.cm = DialogUtil.a(this.f, 230, (String)localObject2, str, 2131889027, 2131889029, new PublicAccountChatPie.39(this, paramPublicAccountInfo, (IPublicAccountDataManager)localObject1), new PublicAccountChatPie.40(this, paramPublicAccountInfo, (IPublicAccountDataManager)localObject1));
        this.cm.setOnDismissListener(new PublicAccountChatPie.41(this));
        this.cm.setCanceledOnTouchOutside(true);
        if (!this.f.isFinishing()) {
          this.cm.show();
        }
        this.de = true;
      }
    }
    else if (QLog.isColorLevel())
    {
      paramPublicAccountInfo = this.c;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=");
      ((StringBuilder)localObject1).append(this.ah.b);
      QLog.e(paramPublicAccountInfo, 2, ((StringBuilder)localObject1).toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "showEqqLbsEnableDialog(): END");
    }
  }
  
  void a(AbsListView paramAbsListView)
  {
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    int i = paramAbsListView.getFirstVisiblePosition();
    while (i <= paramAbsListView.getLastVisiblePosition())
    {
      a(localArrayList4, localArrayList5, localArrayList1, localArrayList2, localArrayList3, (ChatMessage)this.V.getItem(i), i);
      i += 1;
    }
    b(localArrayList4);
    if (!localArrayList5.isEmpty()) {}
    try
    {
      long l1 = Long.parseLong(this.ah.b);
      long l2 = Long.parseLong(this.d.getCurrentAccountUin());
      this.bi.sendMsgArriveReceipt(BaseApplication.getContext(), this.d, 0L, 0L, l1, l2, 2, localArrayList5);
      paramAbsListView = localArrayList4.iterator();
      while (paramAbsListView.hasNext()) {
        if ("1".equals(((ChatMessage)paramAbsListView.next()).getExtInfoFromExtStr("is_AdArrive_Msg")))
        {
          if (this.bC == -1L) {
            this.bC = (NetConnInfoCenter.getServerTime() * 1000L);
          }
          this.bD = localArrayList1;
          ((IPAReportUtil)QRoute.api(IPAReportUtil.class)).reportAdMsgRead(this.d, "", "", this.ah.b, localArrayList2, localArrayList1, localArrayList3);
        }
      }
      return;
    }
    catch (Exception paramAbsListView) {}
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    this.cu = true;
    super.a(paramList, paramCharSequence);
    if (this.aC)
    {
      int i = -1;
      long l1 = 0L;
      if (paramList.size() > 0)
      {
        paramList = (ChatMessage)paramList.get(paramList.size() - 1);
        int j = paramList.msgtype;
        long l2 = paramList.msgseq;
        i = j;
        l1 = l2;
        if ((paramList instanceof MessageForStructing))
        {
          paramList = (MessageForStructing)paramList;
          i = j;
          l1 = l2;
          if (paramList.structingMsg != null)
          {
            l1 = paramList.structingMsg.msgId;
            i = j;
          }
        }
      }
      paramList = this.d;
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("");
      paramCharSequence.append(this.ah.b);
      paramCharSequence = paramCharSequence.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l1);
      ReportController.b(paramList, "dc00899", "Pb_account_lifeservice", paramCharSequence, "0X80064D4", "0X80064D4", 0, 0, "", (String)localObject, localStringBuilder.toString(), "");
    }
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    String str = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<<<<<<<<<<<<<<list.size<<<<<<<<<");
    localStringBuilder.append(paramList.size());
    QLog.i(str, 2, localStringBuilder.toString());
    try
    {
      if (cN())
      {
        if (this.dw != null) {
          this.dw.a(paramList, new PublicAccountChatPie.55(this, paramCharSequence, paramInt));
        }
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e(this.c, 1, QLog.getStackTraceString(localThrowable1));
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(this.ah)) {
        try
        {
          ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).handlePubRefreshList(paramList);
        }
        catch (Throwable localThrowable2)
        {
          QLog.e(this.c, 1, localThrowable2, new Object[0]);
        }
      }
      if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.ah.b)) {
        ((IQQGameSubscribeService)this.d.getRuntimeService(IQQGameSubscribeService.class)).filterSingleGameMsgList(this.f, paramList);
      }
      super.a(paramList, paramCharSequence, paramInt);
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("qidianWpaClick ... mQidianKefu = ");
      ((StringBuilder)localObject2).append(this.cD);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    s(2131893010);
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      localObject2 = (String)paramMap.get("AssignType");
      localObject1 = (String)paramMap.get("AssignID");
      paramMap = (Map<String, String>)localObject2;
    }
    else
    {
      paramMap = null;
      localObject1 = paramMap;
    }
    this.bi.requestQidiKefu(this.f, this.ah.b, paramMap, (String)localObject1, null, new PublicAccountChatPie.60(this));
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    ReportController.b(this.d, "CliOper", "", "", "0X8004EF8", "0X8004EF8", 0, 0, Integer.toString(paramInt), "", "", "");
    if (this.cS != null)
    {
      ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccountCancelCallback(this.cS);
      this.cS = null;
    }
    this.cS = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccount(this.ah.b, paramInt, paramBoolean, BaseApplication.getContext(), this.d, new PublicAccountChatPie.43(this));
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!bN()) {
        this.dp = 2;
      } else if (!bM()) {
        this.dp = 1;
      } else {
        this.dp = 0;
      }
      if (this.X != null) {
        this.X.setVisibility(8);
      }
      CustomMenuBar localCustomMenuBar = this.bj;
      if (localCustomMenuBar != null) {
        localCustomMenuBar.setVisibility(8);
      }
      super.a(paramBoolean1, paramChatMessage, paramBoolean2);
      return;
    }
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    int i = this.dp;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          if (this.X != null) {
            this.X.setVisibility(8);
          }
          paramChatMessage = this.bj;
          if (paramChatMessage != null) {
            paramChatMessage.setVisibility(0);
          }
        }
      }
      else
      {
        if (this.X != null) {
          this.X.setVisibility(0);
        }
        paramChatMessage = this.bj;
        if (paramChatMessage != null) {
          paramChatMessage.setVisibility(8);
        }
      }
    }
    else
    {
      if (this.X != null) {
        this.X.setVisibility(8);
      }
      paramChatMessage = this.bj;
      if (paramChatMessage != null) {
        paramChatMessage.setVisibility(8);
      }
    }
    this.dp = -1;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.d.setHandler(getClass(), this.m);
    this.dD = new PublicAccountChatPie.HomeBroadcast(this, null);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    this.e.registerReceiver(this.dD, (IntentFilter)localObject);
    this.aY = false;
    this.aJ = false;
    cm();
    this.bi = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class));
    bO();
    super.a(paramBoolean);
    if (this.cB) {
      bQ();
    }
    if (this.d.getConversationFacade().a(this.ah.b, this.ah.a) > 0) {
      this.cn = true;
    }
    this.U.setDrawFinishedListener(this.dF);
    this.bU = new TroopEntranceBar();
    this.bU.a(this.d, aX(), this, this.ah, this.o, this.V, this.U);
    this.bU.addObserver(this);
    localObject = this.f.getIntent();
    this.dj = System.currentTimeMillis();
    this.dk = ((Intent)localObject).getIntExtra("red_hot_count", 0);
    String str = ((Intent)localObject).getStringExtra("from");
    this.cf = ((Intent)localObject).getBooleanExtra("shouldreport", false);
    this.dn = System.currentTimeMillis();
    this.ca = 0;
    this.cc = 0;
    this.bZ = 0;
    this.cb = 0;
    this.jdField_do = this.dk;
    paramBoolean = ((Intent)localObject).getBooleanExtra("is_come_from_readinjoy", false);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setComeFromReadInJoy(paramBoolean);
    this.dq = ((Intent)localObject).getIntExtra("INTENT_KEY_FROM", 1);
    if (!this.f.isFinishing())
    {
      cb();
      ((IPublicAccountHandler)this.f.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).setLocalIp(null);
      this.bX = this.f.getIntent().getBooleanExtra("has_unread_msg", false);
    }
    if (a((Intent)localObject, str)) {
      return true;
    }
    cc();
    cd();
    if (this.W != null) {
      this.W.setCustomHeight(0);
    }
    this.bF = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript(this.d, this.ah.b);
    if (QLog.isColorLevel())
    {
      str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnCreate, isMediaAndOtherSubscript = ");
      localStringBuilder.append(this.bF);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.bH = (NetConnInfoCenter.getServerTime() * 1000L);
    ce();
    if (this.bF)
    {
      cK();
      bK();
      ((PAListUI)this.j.b()).a();
    }
    cf();
    cg();
    i((Intent)localObject);
    ch();
    cQ();
    return true;
  }
  
  protected void aD()
  {
    super.aD();
    if (this.aW != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.aW.getLayoutParams();
        if (localLayoutParams != null)
        {
          if ((!bN()) && (this.bj != null))
          {
            localLayoutParams.addRule(2, this.bj.getId());
            return;
          }
          if ((!bM()) && (this.X != null))
          {
            localLayoutParams.addRule(2, this.X.getId());
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void ap()
  {
    if ((this.dg) && (TroopBarAssistantManager.a().b(this.d, this.ah.b) > 0)) {
      TroopBarAssistantManager.a().c(this.d, this.ah.b);
    }
    super.ap();
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.ah.b))
    {
      if (this.bo == null) {
        this.bo = ((IPublicAccountHandler)this.d.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      if (!this.df.get())
      {
        this.df.set(true);
        this.bo.getWeatherInfo(this.f, 2, null);
      }
    }
    else if ((((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isHealthUin(this.ah.b)) && (((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isSupportStepCounter(this.d.getApplicationContext())) && (Build.VERSION.SDK_INT >= 19))
    {
      ((ISportManager)this.d.getRuntimeService(ISportManager.class, "multi")).refreshCurrentStep("public account");
    }
    Object localObject = (EcShopAssistantManager)this.d.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if ((localObject != null) && (((EcShopAssistantManager)localObject).d(this.ah.b))) {
      ThreadManager.post(new PublicAccountChatPie.4(this), 5, null, true);
    }
    b(this.U);
    NowVideoController.a().a(1000L);
    OfficialAccountReporter.a.a(aX());
    if (((AIODraftHelper)q(111)).f)
    {
      localObject = this.bj;
      if (localObject != null)
      {
        ((CustomMenuBar)localObject).setVisibility(8);
        this.X.setVisibility(0);
      }
    }
  }
  
  protected void au()
  {
    super.au();
    this.d.addObserver(this.ch);
    this.d.getMessageFacade().addObserver(this);
    this.d.addObserver(this.co.getBusinessObserver());
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.d.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (ServiceAccountFolderManager.c(this.d, this.ah.b)) {
      this.d.addObserver(this.cq);
    }
    this.d.addObserver(this.cM);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.ch);
    if (this.d.getMessageFacade() != null) {
      this.d.getMessageFacade().deleteObserver(this);
    }
    this.d.removeObserver(this.co.getBusinessObserver());
    this.d.removeObserver(this.cq);
    this.d.removeObserver(this.cM);
    this.d.removeObserver(this.ds);
    this.d.removeObserver(this.dt);
  }
  
  protected HelperProvider b()
  {
    return new PAHelperProvider(this.f);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    bL();
    if (paramInt2 == 8)
    {
      if (this.bK != null) {
        if (CustomMenuBar.a()) {
          this.bK.setImageResource(2130852056);
        } else {
          this.bK.setImageResource(2130851978);
        }
      }
    }
    else if (this.bK != null) {
      if (CustomMenuBar.a()) {
        this.bK.setImageResource(2130852055);
      } else {
        this.bK.setImageResource(2130851977);
      }
    }
    if (!this.aa)
    {
      SpannableString localSpannableString;
      if (this.bQ == null)
      {
        localObject = new ImageSpan(this.e, 2130838075);
        localSpannableString = new SpannableString(HardCodeUtil.a(2131906564));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.bQ = localSpannableString;
      }
      if (this.bR == null)
      {
        localObject = new ImageSpan(this.e, 2130838382);
        localSpannableString = new SpannableString(HardCodeUtil.a(2131906560));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.bR = localSpannableString;
      }
      if ((QLog.isColorLevel()) && (this.bL != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("oldPanel=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" newPanel=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" text.length ");
        ((StringBuilder)localObject).append(this.Y.getText().length());
        ((StringBuilder)localObject).append("mAudioBtn visibility:");
        ((StringBuilder)localObject).append(this.bL.getVisibility());
        QLog.d("doPanelChanged", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt2 == 2)
      {
        this.bO.setSelected(false);
        return;
      }
      Object localObject = this.bO;
      boolean bool;
      if (this.Y.getText().length() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((PatchedButton)localObject).setSelected(bool);
      if (this.Y.getText().length() > 0)
      {
        this.bO.setText(2131887750);
        return;
      }
      this.bO.setSelected(false);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    if (this.cB) {
      bS();
    }
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.ah.b))
    {
      this.bJ.setVisibility(8);
      this.bK.setVisibility(8);
    }
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    paramView = AIOUtils.b(paramView);
    ((WeiShiSubScribeHelper)this.g.a(22)).a(paramView);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    int i = this.V.b(paramChatMessage) + 1;
    if ((i >= 0) && (i <= this.V.getCount() - 1))
    {
      ChatMessage localChatMessage = (ChatMessage)this.V.getItem(i);
      if ((localChatMessage != null) && (localChatMessage.msgtype == -1048))
      {
        super.b(paramChatMessage);
        d(localChatMessage);
        return;
      }
    }
    super.b(paramChatMessage);
  }
  
  void b(List<ChatMessage> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "saveReadedToDB");
    }
    ThreadManager.postImmediately(new PublicAccountChatPie.19(this, paramList), null, false);
  }
  
  @TargetApi(11)
  void bA()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.o.post(new PublicAccountChatPie.14(this));
      this.U.removeHeaderView(this.cV);
      this.da = true;
      this.ce.sendEmptyMessage(1);
      return;
    }
    Object localObject = this.cV;
    a((View)localObject, ((View)localObject).getHeight(), 0, new PublicAccountChatPie.15(this));
    this.bl.setTranslationY(0.0F);
    localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.bl.getHeight());
    ((TranslateAnimation)localObject).setDuration(500L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setAnimationListener(new PublicAccountChatPie.16(this));
    this.bl.startAnimation((Animation)localObject);
  }
  
  public int bB()
  {
    Object localObject1 = this.U;
    int i = 0;
    localObject1 = ((ChatXListView)localObject1).getChildAt(0);
    Object localObject2 = this.dx;
    if ((localObject2 != null) && (localObject1 != localObject2))
    {
      this.cX = 0;
      this.dx = ((View)localObject1);
      return 0;
    }
    if (localObject1 != null) {
      i = -((View)localObject1).getTop();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ScrollY: ");
      localStringBuilder.append(String.valueOf(i));
      localStringBuilder.append("  OldScrollY: ");
      localStringBuilder.append(String.valueOf(this.cX));
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    this.dx = ((View)localObject1);
    return i;
  }
  
  void bC()
  {
    if (this.o != null)
    {
      if (this.U == null) {
        return;
      }
      co();
      this.cV = LayoutInflater.from(this.f.getBaseContext()).inflate(2131624125, this.U, false);
      Object localObject = this.cV;
      if (localObject == null) {
        return;
      }
      if (this.br == 2) {
        ((View)localObject).getLayoutParams().height = ((int)this.f.getResources().getDimension(2131298300));
      } else if (this.cB) {
        ((View)localObject).getLayoutParams().height = ((int)this.f.getResources().getDimension(2131298300));
      }
      if ((!this.cB) && (!this.cG))
      {
        localObject = this.U.getAdapter();
        this.U.setAdapter(null);
        this.U.addHeaderView(this.cV);
        this.U.setAdapter((ListAdapter)localObject);
      }
      else
      {
        localObject = (RelativeLayout.LayoutParams)this.U.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = this.e.getResources().getDimensionPixelSize(2131299920);
        this.U.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null)
      {
        localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.ah.b);
        if ((localObject != null) && (this.bp))
        {
          c((IPublicAccountDetail)localObject);
          this.bp = false;
        }
      }
      cp();
    }
  }
  
  void bD()
  {
    this.U.setOnScrollListener(this);
    this.n.b();
    if (this.X != null) {
      this.X.setVisibility(8);
    }
    this.i.p().d().b().b();
  }
  
  void bE()
  {
    if (this.ck == null)
    {
      this.ck = ((ActionSheet)ActionSheetHelper.b(this.f, null));
      this.ck.setMainTitle(HardCodeUtil.a(2131906558));
      this.ck.addButton(HardCodeUtil.a(2131899883), 3);
      this.ck.addCancelButton(2131887648);
      this.ck.setOnDismissListener(new PublicAccountChatPie.24(this));
      this.ck.setOnButtonClickListener(new PublicAccountChatPie.25(this));
    }
    if (!this.ck.isShowing())
    {
      this.cj = false;
      this.ck.show();
    }
  }
  
  void bF()
  {
    if (this.db) {
      return;
    }
    if (this.o == null) {
      return;
    }
    Object localObject = this.f.getResources();
    if (cr()) {
      return;
    }
    if (this.bB)
    {
      localObject = new TranslateAnimation(0.0F, 0.0F, AIOUtils.b(34.0F, (Resources)localObject), 0.0F);
      ((TranslateAnimation)localObject).setDuration(250L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new PublicAccountChatPie.31(this));
      this.bj.startAnimation((Animation)localObject);
    }
    localObject = this.o.findViewById(2131432702);
    ((View)localObject).setOnClickListener(new PublicAccountChatPie.32(this));
    this.bj.setCoverView((View)localObject);
    this.cQ = this.o.findViewById(2131439749);
    cv();
    localObject = this.f.getSharedPreferences("menuEventSharePre", 0);
    if (!((SharedPreferences)localObject).contains(this.ah.b))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(this.ah.b, 0);
      ((SharedPreferences.Editor)localObject).commit();
    }
    this.cP.setOnClickListener(this);
    cs();
    ct();
    localObject = this.bi.getPublicAccountMenuButtonList(this.d, ae());
    c((List)localObject);
    d((List)localObject);
  }
  
  public void bG()
  {
    if (this.ah.a == 1008)
    {
      if ((this.C.getText() != null) && (this.C.getText().length() < 6))
      {
        this.A.setVisibility(4);
        return;
      }
      this.A.setVisibility(8);
    }
  }
  
  boolean bH()
  {
    Object localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null) {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(this.ah.b);
    } else {
      localObject = null;
    }
    if ((localObject == null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).queryAccountDetail(this.d, this.ah.b) == null))
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).cleanPublicAccountObserver();
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getPublicAccountDetailRequest(this.d, BaseApplication.getContext(), this.m, this.ah.b);
      return true;
    }
    return false;
  }
  
  boolean bI()
  {
    Object localObject = this.d.getMessageFacade();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).getLastMessage(this.ah.b, 1008);
      if (localObject != null) {
        if (((com.tencent.imcore.message.Message)localObject).msgtype == -2011)
        {
          MessageForStructing localMessageForStructing = new MessageForStructing();
          MessageForStructing.copyMessageRecordBaseField(localMessageForStructing, (MessageRecord)localObject);
          localMessageForStructing.parse();
          if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mPromotionType == 1) || (localMessageForStructing.structingMsg.mPromotionType == 2)))
          {
            b(localMessageForStructing);
            return true;
          }
        }
        else
        {
          if ((((com.tencent.imcore.message.Message)localObject).msgtype == -2009) && (((com.tencent.imcore.message.Message)localObject).isSend())) {
            return true;
          }
          if ((((com.tencent.imcore.message.Message)localObject).msgtype == -5008) && (!((com.tencent.imcore.message.Message)localObject).isSend()))
          {
            this.br = 1;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  void bJ()
  {
    QLog.d(this.c, 2, "follow");
    Object localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.ah.b);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((IPublicAccountDetail)localObject).getAccountFlag()) != -4)) {
        cF();
      } else {
        cG();
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(this.d, this.ah.b, 4);
    QLog.d(this.c, 2, "follow exit");
  }
  
  public void bK()
  {
    ThreadManager.post(new PublicAccountChatPie.50(this), 8, null, true);
  }
  
  @TargetApi(11)
  protected void bL()
  {
    ImageView localImageView = this.bJ;
    if (localImageView == null) {
      return;
    }
    localImageView.setEnabled(true);
    if (this.n.getCurrentPanel() == 3)
    {
      if (CustomMenuBar.a()) {
        this.bJ.setImageResource(2130852007);
      } else {
        this.bJ.setImageResource(2130852468);
      }
      this.bJ.setContentDescription(this.e.getString(2131896460));
    }
    else
    {
      if (CustomMenuBar.a()) {
        this.bJ.setImageResource(2130852006);
      } else {
        this.bJ.setImageResource(2130852469);
      }
      this.bJ.setContentDescription(this.e.getString(2131896459));
    }
    if (VersionUtils.e()) {
      this.bJ.setAlpha(1.0F);
    }
  }
  
  public boolean bM()
  {
    return (this.X == null) || (this.X.getVisibility() == 8);
  }
  
  public boolean bN()
  {
    CustomMenuBar localCustomMenuBar = this.bj;
    return (localCustomMenuBar == null) || (localCustomMenuBar.getVisibility() == 8);
  }
  
  void bO()
  {
    bU();
    this.cL = ((QidianManager)this.d.getManager(QQManagerFactory.QIDIAN_MANAGER));
    String str = this.f.getIntent().getStringExtra("uin");
    this.cv = this.f.getIntent().getStringExtra("qd_wpa_key");
    if (!TextUtils.isEmpty(this.cv))
    {
      this.cw = this.f.getIntent().getStringExtra("qd_kfuin");
      this.cx = this.f.getIntent().getStringExtra("assign_type");
      this.cy = this.f.getIntent().getStringExtra("assign_key");
      this.cz = this.f.getIntent().getStringExtra("assign_ext");
      this.cA = this.f.getIntent().getStringExtra("rkey");
      this.cB = true;
      this.cC = false;
      this.cD = false;
      this.cE = false;
      this.cF = false;
      this.cH = null;
      this.cL.a(str, this.cw);
      return;
    }
    this.cw = this.cL.k(str);
    if (!TextUtils.isEmpty(this.cw))
    {
      this.cB = true;
      this.cC = true;
      this.cx = null;
      this.cy = null;
      this.cz = null;
      this.cA = null;
      this.cD = true;
      this.cE = false;
      this.cF = false;
      this.cH = null;
      return;
    }
    this.cB = false;
    this.cC = false;
    this.cx = null;
    this.cy = null;
    this.cz = null;
    this.cA = null;
    this.cD = false;
    this.cE = false;
    this.cF = false;
    this.cH = null;
  }
  
  protected void bP()
  {
    this.cB = false;
    this.cC = false;
    this.cx = null;
    this.cy = null;
    this.cz = null;
    this.cA = null;
    this.cD = false;
    this.cE = false;
    this.cF = false;
    this.cH = null;
    this.cG = false;
  }
  
  public void bQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "checkQDAccountValid ...");
    }
    ThreadManager.post(new PublicAccountChatPie.57(this), 8, null, false);
  }
  
  public void bR()
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateHeader ... ");
      Object localObject = this.bl;
      if (localObject != null) {
        localObject = Integer.valueOf(((View)localObject).getVisibility());
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.bm != null)
    {
      if (!this.cC) {
        return;
      }
      if (this.cE)
      {
        this.cJ.setVisibility(0);
        this.cI.setVisibility(8);
        return;
      }
      this.cJ.setVisibility(8);
      this.cI.setVisibility(0);
    }
  }
  
  public void bS()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateWpaUiForQidian: mQidianAccountValid = ");
      localStringBuilder.append(this.cC);
      localStringBuilder.append(", mQidianKefu = ");
      localStringBuilder.append(this.cD);
      localStringBuilder.append(", mQidianShield: ");
      localStringBuilder.append(this.cE);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.cC)
    {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(this.ah.b);
      int j = 0;
      if (localObject != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.C.setVisibility(0);
        this.u.setVisibility(0);
        this.X.setVisibility(0);
        bF();
        return;
      }
      this.C.setVisibility(0);
      this.u.setVisibility(0);
      localObject = this.X;
      if (this.cE) {}
      while (!this.cD)
      {
        i = 8;
        break;
      }
      int i = j;
      ((InputLinearLayout)localObject).setVisibility(i);
      if (this.cP == null) {
        this.cP = ((ImageView)this.aZ.findViewById(2131432704));
      }
      this.cP.setVisibility(8);
      localObject = this.bj;
      if (localObject != null) {
        ((CustomMenuBar)localObject).setVisibility(8);
      }
      if (this.bl == null)
      {
        if (QLog.isColorLevel()) {
          QZLog.d(this.c, 2, "setInitHeader in updateWpaUiForQidian");
        }
        bC();
      }
      bR();
      return;
    }
    this.C.setVisibility(4);
    this.u.setVisibility(4);
    this.X.setVisibility(8);
  }
  
  public void bT()
  {
    if (this.cC)
    {
      if (!this.cF) {
        return;
      }
      int i;
      if ((PublicAccountInfo)((IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(this.ah.b) != null) {
        i = 1;
      } else {
        i = 0;
      }
      if ((this.cE) && (i == 0))
      {
        AddMessageHelper.a(this.d, this.ah.b, this.d.getApp().getResources().getString(2131896264), this.ah.a, false, true);
        return;
      }
      if (this.cH != null)
      {
        this.d.getMessageFacade().a(this.cH, this.d.getCurrentAccountUin());
        this.cH = null;
        return;
      }
      boolean bool = this.cE;
    }
  }
  
  public void bU()
  {
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.63(this));
  }
  
  protected boolean ba()
  {
    if ((!this.cr) && (this.bF))
    {
      this.cr = true;
      this.U.setSelection(this.V.getCount() - 1);
      return true;
    }
    if ((!this.cs) && (this.bF))
    {
      this.cs = true;
      return false;
    }
    return true;
  }
  
  public void bz()
  {
    if (!this.f.isFinishing())
    {
      QQProgressDialog localQQProgressDialog = this.bk;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
        this.bk.dismiss();
      }
    }
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).showPubAccUin(this.d)) {
      this.C.setText(this.ah.b);
    }
  }
  
  void c(List<mobileqq_mp.ButtonInfo> paramList)
  {
    if (cu()) {
      return;
    }
    if (f(paramList)) {
      return;
    }
    if ((paramList != null) && (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.ah.b)))
    {
      mobileqq_mp.ButtonInfo localButtonInfo = new mobileqq_mp.ButtonInfo();
      localButtonInfo.id.set(0);
      localButtonInfo.name.set(HardCodeUtil.a(2131911256));
      localButtonInfo.event_id.set(1000002);
      localButtonInfo.type.set(3);
      paramList.add(0, localButtonInfo);
    }
    e(paramList);
  }
  
  protected AIOContext d()
  {
    return new PAContext();
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    a(this.ah.b, this.ah.a, paramIntent);
    this.n.post(new PublicAccountChatPie.36(this));
    cH();
    bU();
    cL();
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    int i = this.V.b(paramChatMessage);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos is:");
      localStringBuilder.append(i);
      QLog.d("Q.msg.delmsg", 2, localStringBuilder.toString());
    }
    if (i < 0) {
      return;
    }
    int j = this.U.getFirstVisiblePosition();
    int k = i - j;
    this.bW = this.U.getChildAt(k);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("horMoveView is null,childIndex is:");
      localStringBuilder.append(k);
      localStringBuilder.append(",firstPos is:");
      localStringBuilder.append(j);
      localStringBuilder.append(",pos is:");
      localStringBuilder.append(i);
      QLog.d("Q.msg.delmsg", 2, localStringBuilder.toString());
    }
    this.V.a(paramChatMessage);
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new Scroller()).a(new PAListUI(this.i)).a(new UnreadTask(this.i)).a(new PAMsgListRefresher(this.i)).a();
  }
  
  public void e(View paramView)
  {
    paramView.getLayoutParams().height = 0;
    paramView.requestLayout();
  }
  
  public void e(String paramString)
  {
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (this.bS != null) && (this.f != null)) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("args:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("ArkAppSchemeCenter", 2, ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject2 = paramString.getJSONObject("bidInfo");
        if (((JSONObject)localObject2).optInt("isshow", 0) == 1)
        {
          bool = true;
          localObject1 = ((JSONObject)localObject2).getString("icon");
          localObject2 = ((JSONObject)localObject2).getString("url");
          int i = paramString.getInt("bid");
          int j = paramString.getInt("cid");
          int k = paramString.getInt("web");
          this.f.runOnUiThread(new PublicAccountChatPie.62(this, bool, (String)localObject1, (String)localObject2, i, j, k));
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      boolean bool = false;
    }
  }
  
  protected void f(Intent paramIntent)
  {
    super.f(paramIntent);
    if (this.w != null) {
      this.w.setContentDescription(this.d.getApplication().getString(2131887440));
    }
    if (this.s != null) {
      this.s.setText("");
    }
  }
  
  public void f(boolean paramBoolean)
  {
    try
    {
      if ((cN()) && (this.dw != null)) {
        this.dw.a(aX());
      }
      label27:
      super.f(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }
  
  protected void h()
  {
    this.c = "PublicAccountChatPie";
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    int i = paramMessage.what;
    View localView;
    if (i != 19)
    {
      if (i != 20)
      {
        if (i != 1001) {
          switch (i)
          {
          default: 
            break;
          case 38: 
            this.aX.a(1000, new Object[0]);
            break;
          case 37: 
            a(this.U);
            break;
          case 36: 
            cE();
            break;
          }
        } else {
          this.bj.d();
        }
      }
      else
      {
        this.m.removeMessages(20);
        localView = this.cQ;
        if ((localView != null) && (localView.getVisibility() == 0)) {
          this.cQ.setVisibility(8);
        }
      }
    }
    else
    {
      localView = this.cQ;
      if (localView != null)
      {
        localView.setVisibility(0);
        this.m.removeMessages(20);
        this.m.sendEmptyMessageDelayed(20, 10000L);
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  protected void l()
  {
    super.l();
    this.bO = ((PatchedButton)this.aZ.findViewById(2131433920));
    this.bO.setContentDescription(HardCodeUtil.a(2131906570));
    this.bO.setOnClickListener(this);
    this.cP = ((ImageView)this.aZ.findViewById(2131432704));
    Object localObject = this.cP;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    this.di = ((LinearLayout)this.aZ.findViewById(2131440826));
    this.di.setVisibility(0);
    localObject = (LinearLayout.LayoutParams)this.bO.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.bO.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.bP = ((LinearLayout)this.aZ.findViewById(2131433921));
    localObject = (LinearLayout.LayoutParams)this.bP.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.bP.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.Y.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    this.Y.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (CustomMenuBar.a()) {
      this.di.setBackgroundColor(-1);
    } else {
      w(80);
    }
    this.bL = ((ImageView)this.di.findViewById(2131428843));
    this.bL.setOnClickListener(this);
    this.bK = ((ImageView)this.di.findViewById(2131440441));
    this.bK.setOnClickListener(this);
    this.bJ = ((ImageView)this.di.findViewById(2131432400));
    this.bJ.setOnClickListener(this);
    if (!CustomMenuBar.a())
    {
      this.bJ.setImageResource(2130849798);
      this.bK.setImageResource(2130838012);
    }
    if (this.Y != null)
    {
      int i = AIOUtils.b(3.0F, this.f.getResources());
      if (CustomMenuBar.a())
      {
        this.Y.setBackgroundResource(2130852110);
        this.X.setBackgroundColor(this.f.getResources().getColor(2131168198));
      }
      this.X.setPadding(0, i, 0, i);
    }
    if (cO()) {
      aB();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131440441: 
      cA();
      break;
    case 2131438955: 
      as();
      break;
    case 2131436194: 
      cx();
      break;
    case 2131436189: 
      if (!f(paramView)) {
        break;
      }
      break;
    case 2131436180: 
    case 2131436666: 
    case 2131437136: 
    case 2131448219: 
      cy();
      break;
    case 2131433920: 
      cC();
      break;
    case 2131432704: 
      p(true);
      break;
    case 2131432400: 
      cB();
      break;
    case 2131428843: 
      cz();
    }
    if (!g(paramView)) {
      super.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    ((WeiShiSubScribeHelper)this.g.a(22)).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    b(paramAbsListView);
    if (cn()) {
      return;
    }
    int i = this.cZ;
    if (i > paramInt3) {
      this.by = 4;
    } else if (i < paramInt3) {
      this.by = 3;
    }
    this.cZ = paramInt3;
    c(paramInt2, paramInt3);
    if ((!this.da) && (!this.bA)) {
      return;
    }
    if ((this.ci) && (!this.bA))
    {
      this.ci = false;
      return;
    }
    if (this.bl.getHeight() != 0) {
      this.cY = this.bl.getHeight();
    }
    i = this.cX - bB();
    this.cX = bB();
    if (this.dy * i < 0)
    {
      this.dy = i;
      return;
    }
    this.dy = i;
    if (QLog.isColorLevel())
    {
      paramAbsListView = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Move = ");
      localStringBuilder.append(String.valueOf(i));
      QLog.d(paramAbsListView, 2, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      this.m.sendEmptyMessage(37);
      NowVideoController.a().a(500L);
    }
    ((WeiShiSubScribeHelper)this.g.a(22)).a(paramAbsListView, paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.cg = true;
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void p(boolean paramBoolean)
  {
    if (cO())
    {
      aB();
      QLog.d(this.c, 2, "setPublicAccountMenuBarVisible new qqlive pubaccount return");
      return;
    }
    if (paramBoolean)
    {
      this.n.b();
      CustomMenuBar localCustomMenuBar = this.bj;
      if (localCustomMenuBar != null) {
        localCustomMenuBar.setVisibility(0);
      }
      if (this.X != null) {
        this.X.setVisibility(4);
      }
      this.i.p().d().b().c();
      aD();
    }
  }
  
  protected void q(boolean paramBoolean)
  {
    Object localObject = this.bL;
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).clearAnimation();
    localObject = this.bL;
    int j = 8;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    localObject = this.Y;
    int i = j;
    if (!paramBoolean) {
      i = 0;
    }
    ((XEditTextEx)localObject).setVisibility(i);
    if (this.ab)
    {
      localObject = this.bO;
      if (paramBoolean) {
        i = 4;
      } else {
        i = 0;
      }
      ((PatchedButton)localObject).setVisibility(i);
    }
    if (paramBoolean)
    {
      if (this.bQ == null)
      {
        localObject = new ImageSpan(this.e, 2130838075);
        SpannableString localSpannableString = new SpannableString(HardCodeUtil.a(2131906540));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.bQ = localSpannableString;
      }
      this.bO.setText(this.bQ);
    }
  }
  
  public boolean r(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.ah.b);
      return (localObject != null) && ((((PublicAccountInfo)localObject).accountFlag & 0x40000000) == 1073741824);
    }
    Object localObject = (IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.ah.b);
      if (localObject == null) {
        return false;
      }
      if ((((IPublicAccountDetail)localObject).getAccountFlag() & 0x40000000) == 1073741824) {
        return true;
      }
    }
    return false;
  }
  
  void s(int paramInt)
  {
    if (this.bk == null) {
      this.bk = new QQProgressDialog(this.o.getContext(), this.f.getTitleBarHeight());
    }
    if (!this.f.isFinishing())
    {
      QQProgressDialog localQQProgressDialog = this.bk;
      if (localQQProgressDialog != null)
      {
        localQQProgressDialog.c(paramInt);
        if (!this.bk.isShowing()) {
          this.bk.show();
        }
      }
    }
  }
  
  public void t(int paramInt)
  {
    Toast.makeText(this.f.getApplicationContext(), paramInt, 0).show();
  }
  
  public void u(int paramInt)
  {
    if (this.dG == null)
    {
      this.dG = new ReportDialog(aX(), 2131953338);
      this.dG.setContentView(2131627185);
    }
    TextView localTextView1 = (TextView)this.dG.findViewById(2131447463);
    TextView localTextView2 = (TextView)this.dG.findViewById(2131427499);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          localTextView1.setText(2131896265);
          localTextView2.setText(2131896263);
        }
      }
      else
      {
        localTextView1.setText(2131896262);
        localTextView2.setText(2131896263);
      }
    }
    else
    {
      localTextView1.setText(2131896261);
      localTextView2.setText(2131896267);
    }
    this.dG.setOnCancelListener(new PublicAccountChatPie.59(this));
    this.dG.show();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    boolean bool = paramObject instanceof MessageRecord;
    Object localObject;
    if (bool)
    {
      localObject = ((MessageRecord)paramObject).getExtInfoFromExtStr("welcome_msg");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("true"))) {
        ThreadManager.post(new PublicAccountChatPie.48(this), 8, null, false);
      }
      this.cn = true;
    }
    if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) && (bool)) {
      ((IKanDianMergeManager)this.d.getRuntimeService(IKanDianMergeManager.class)).removeSubscribePushFromSP(this.ah.b);
    }
    super.update(paramObservable, paramObject);
    if ((paramObservable instanceof TroopEntranceBar))
    {
      if ((paramObject instanceof Integer))
      {
        int i = ((Integer)paramObject).intValue();
        if (i == 0)
        {
          this.bU.a(this.d);
          this.bU.b();
        }
        else if (i == 1)
        {
          this.dl = true;
        }
      }
      cj();
      return;
    }
    if ((paramObservable instanceof QQMessageFacade)) {
      if (this.bU != null)
      {
        paramObject = (TroopManager)this.f.app.getManager(QQManagerFactory.TROOP_MANAGER);
        paramObservable = ((QQMessageFacade)paramObservable).B();
        if (paramObservable == null) {
          return;
        }
        paramObservable = paramObject.g(paramObservable.frienduin);
        if (paramObservable == null) {}
      }
    }
    try
    {
      if (paramObservable.associatePubAccount != Long.valueOf(this.ah.b).longValue()) {
        break label313;
      }
      paramObject = android.os.Message.obtain();
      paramObject.what = 9;
      localObject = new Bundle();
      ((Bundle)localObject).putString("troopUin", paramObservable.troopuin);
      paramObject.setData((Bundle)localObject);
      this.ce.sendMessage(paramObject);
      return;
    }
    catch (NumberFormatException paramObservable)
    {
      label302:
      break label302;
    }
    QLog.d(this.c, 2, "exception: sessionInfo curFriendUin is not a long type.");
    label313:
    return;
    if (this.bF) {
      ThreadManager.post(new PublicAccountChatPie.49(this), 5, null, false);
    }
  }
  
  protected boolean x()
  {
    PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)this.d.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.ah.b);
    return (localPublicAccountInfo == null) || ((localPublicAccountInfo.accountFlag & 0x10000000) == 0);
  }
  
  protected void z()
  {
    super.z();
    bG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie
 * JD-Core Version:    0.7.0.1
 */