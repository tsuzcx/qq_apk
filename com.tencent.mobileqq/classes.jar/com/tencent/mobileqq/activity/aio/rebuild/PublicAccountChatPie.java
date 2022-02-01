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
  boolean D = false;
  boolean E = false;
  public boolean F = false;
  boolean G = false;
  boolean H = false;
  boolean I = false;
  public boolean J = false;
  public boolean K = false;
  public boolean L = false;
  boolean M = false;
  boolean N = false;
  boolean O = false;
  boolean P = false;
  boolean Q = false;
  boolean R = false;
  public boolean S = false;
  boolean T = false;
  boolean U = false;
  public boolean V;
  public boolean W;
  boolean X = false;
  boolean Y = false;
  boolean Z = false;
  long jdField_a_of_type_Long = -1L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler = new PublicAccountChatPie.1(this);
  protected SpannableString a;
  public View.OnClickListener a;
  protected LinearLayout a;
  private IPublicAccountDetail jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiIPublicAccountDetail;
  public IPublicAccountHandler a;
  IPublicAccountManager jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager;
  public IPublicAccountObserver.OnCallback a;
  public IPublicAccountObserver a;
  public IPublicAccountTipsManager a;
  EcShopObserver jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver = new PublicAccountChatPie.53(this);
  CustomMenuBar jdField_a_of_type_ComTencentBizUiCustomMenuBar;
  private PublicAccountChatPie.HomeBroadcast jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$HomeBroadcast;
  protected MessageObserver a;
  private NewPublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = null;
  MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  PublicAccountInfo jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  private IEcshopChatPieDelegate jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate;
  public PreloadProcHitSession a;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  public TroopEntranceBar a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  PublicMenuBar jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = null;
  QidianManager jdField_a_of_type_ComTencentQidianQidianManager;
  public QidianBusinessObserver a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new PublicAccountChatPie.56(this);
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private NewIntent jdField_a_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new PublicAccountChatPie.3(this);
  public int[] a;
  boolean aa = false;
  boolean ab = false;
  public boolean ac = false;
  private boolean ad = false;
  private boolean ae = false;
  private boolean af = false;
  private boolean ag = false;
  private boolean ah = false;
  private boolean ai = false;
  private boolean aj = false;
  private boolean ak;
  private boolean al = false;
  private boolean am;
  long jdField_b_of_type_Long = -1L;
  Dialog jdField_b_of_type_AndroidAppDialog;
  protected SpannableString b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private NewPublicAccountObserver jdField_b_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver;
  private PublicMenuBar jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar;
  protected PatchedButton b;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_b_of_type_MqqAppNewIntent = null;
  private BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  long jdField_c_of_type_Long = -1L;
  private Dialog jdField_c_of_type_AndroidAppDialog = null;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_c_of_type_MqqAppNewIntent = null;
  long jdField_d_of_type_Long = 0L;
  QQProgressDialog jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String d;
  private long e;
  public String e;
  private long jdField_f_of_type_Long;
  String jdField_f_of_type_JavaLangString;
  public int g;
  private long jdField_g_of_type_Long = 0L;
  View jdField_g_of_type_AndroidViewView = null;
  String jdField_g_of_type_JavaLangString;
  public int h;
  private long jdField_h_of_type_Long;
  public View h;
  String jdField_h_of_type_JavaLangString;
  int jdField_i_of_type_Int = 0;
  View jdField_i_of_type_AndroidViewView;
  String jdField_i_of_type_JavaLangString;
  int jdField_j_of_type_Int = 3;
  View jdField_j_of_type_AndroidViewView;
  String jdField_j_of_type_JavaLangString;
  protected int k;
  View jdField_k_of_type_AndroidViewView;
  String jdField_k_of_type_JavaLangString;
  protected int l;
  private View jdField_l_of_type_AndroidViewView;
  protected ImageView l;
  private String jdField_l_of_type_JavaLangString = "";
  public int m;
  private View m;
  protected ImageView m;
  public int n;
  private View n;
  public ImageView n;
  public int o;
  private ImageView o;
  public int p = 0;
  private int q;
  private int r;
  private int s = 0;
  private int t = 0;
  private int u;
  private int v;
  private int w = -1;
  private int x = 0;
  private int y = 0;
  private int z = 0;
  
  public PublicAccountChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_m_of_type_AndroidViewView = null;
    this.jdField_g_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_Int = -1;
    this.jdField_k_of_type_Int = 2130837920;
    this.jdField_l_of_type_Int = 2130837919;
    this.jdField_h_of_type_AndroidViewView = null;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_m_of_type_Int = 0;
    this.jdField_n_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
    this.jdField_v_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("web_public_account", "com.tencent.mobileqq:tool");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new PublicAccountChatPie.12(this);
    this.jdField_n_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver$OnCallback = new PublicAccountChatPie.52(this);
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new PublicAccountChatPie.58(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new PublicAccountChatPie.61(this);
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.setOnCallback(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver$OnCallback);
  }
  
  private boolean A()
  {
    if ((B()) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()))
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updatePublicAccountMenu new qqgame pubaccount return");
      return true;
    }
    if (C())
    {
      IEcshopChatPieDelegate localIEcshopChatPieDelegate = this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate;
      if ((localIEcshopChatPieDelegate != null) && (!localIEcshopChatPieDelegate.a()))
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updatePublicAccountMenu new qqshop pubaccount return");
        return true;
      }
    }
    if (D())
    {
      V();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updatePublicAccountMenu new qqlive pubaccount return");
      return true;
    }
    return this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null;
  }
  
  private boolean B()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ("2747277822".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private boolean C()
  {
    return EcshopFromUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private boolean D()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ("1816533856".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.jdField_i_of_type_Int;
    if (i1 != 0)
    {
      if (i1 != 1) {
        return;
      }
      b(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    d(paramInt1, paramInt4);
  }
  
  private void a(android.os.Message paramMessage)
  {
    paramMessage = paramMessage.getData();
    if (paramMessage != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilMap.put(paramMessage.getString("troopUin"), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramMessage.getString("troopUin"), 1)));
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.d();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.e();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.c();
    }
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
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getBoolean("firstIntoAIO", true))
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(Color.parseColor("#B3000000"));
      localLinearLayout.setVisibility(0);
      localLinearLayout.setClickable(true);
      localLinearLayout.setOnClickListener(new PublicAccountChatPie.51(this, paramRelativeLayout, localLinearLayout));
      Object localObject = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((ImageView)localObject).setImageResource(2130841707);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      localLayoutParams.width = AIOUtils.b(73.0F, localResources);
      localLayoutParams.height = AIOUtils.b(73.0F, localResources);
      localLayoutParams.topMargin = AIOUtils.b(100.0F, localResources);
      localLayoutParams.gravity = 17;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      localObject = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((TextView)localObject).setText(HardCodeUtil.a(2131708789));
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
              localObject = ((StructMsgItemLayout5)localObject).a;
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
                QLog.e(this.jdField_b_of_type_JavaLangString, 1, localThrowable, new Object[0]);
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
                QLog.e(this.jdField_b_of_type_JavaLangString, 1, paramMessageForStructing, new Object[0]);
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
      ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_6", "msg_push");
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
        long l1 = Long.parseLong((String)localObject);
        if (!paramChatMessage.getExtInfoFromExtStr("pa_should_report").equals("true")) {
          break label477;
        }
        paramList1.add(Long.valueOf(l1));
        if (!QLog.isColorLevel()) {
          break label477;
        }
        paramList1 = this.jdField_b_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Report message at index: ");
        ((StringBuilder)localObject).append(String.valueOf(paramInt));
        ((StringBuilder)localObject).append(". MessageId is ");
        ((StringBuilder)localObject).append(l1);
        QLog.d(paramList1, 2, ((StringBuilder)localObject).toString());
        label206:
        paramChatMessage.saveExtInfoToExtStr("pa_msgHasRead", "true");
        paramList1 = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
        if (paramList1 != null) {
          break label480;
        }
        paramList1 = "";
        label236:
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80057C4", "0X80057C4", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(l1), paramList1, "", false);
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
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, " parse ad_id error");
      break label486;
    }
    for (;;)
    {
      paramList2.add(localObject);
      this.jdField_b_of_type_JavaUtilList.add(paramList1);
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
      ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).handleUrlEvent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("starhomeurl"), paramIntent.getStringExtra("uin"), paramString);
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView)
  {
    paramView = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      String str = (String)EcShopAssistantManager.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      localIntent.putExtra("uin", str);
      localIntent = AIOUtils.a(localIntent, null);
      if (paramView.b(str))
      {
        localIntent.putExtra("uintype", 0);
      }
      else
      {
        localIntent.putExtra("uintype", 1005);
        paramView = new StringBuilder();
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
        paramView.append(HardCodeUtil.a(2131708770));
        localIntent.putExtra("uinname", paramView.toString());
        localIntent.putExtra("key_sub_title_from", "来自\"QQ咨询\"");
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Shop_customservice", "Clk_shopcustomservice", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
  
  private boolean a(List<mobileqq_mp.ButtonInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getPublicAccountMenuType(b()));
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = this.jdField_o_of_type_AndroidWidgetImageView;
      if (paramList != null) {
        paramList.setVisibility(0);
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    paramList = this.jdField_o_of_type_AndroidWidgetImageView;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramInt == 0)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", false);
      Object localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      bool = false;
      if (localObject != null)
      {
        localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler == null) {
            this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler = ((IPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
          }
          this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler.onFollowPublicAccount(localObject);
        }
        else
        {
          t();
          paramBoolean = bool;
        }
      }
      else
      {
        t();
        paramBoolean = bool;
      }
      this.D = true;
      this.I = true;
      ap();
      bool = paramBoolean;
      if (this.X)
      {
        localObject = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
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
        m(2131695212);
      } else if (paramInt == 65) {
        m(2131695185);
      } else {
        m(2131695217);
      }
      bool = paramBoolean;
    }
    return bool;
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
      int i1 = -1;
      if (paramArrayOfByte.uint32_result.has())
      {
        int i2 = paramArrayOfByte.uint32_result.get();
        i1 = i2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handle OidbSvc.0xcf8|OIDBSSOPke.result=");
          ((StringBuilder)localObject1).append(i2);
          QLog.i("QQVipHelper", 2, ((StringBuilder)localObject1).toString());
          i1 = i2;
        }
      }
      if ((i1 == 0) && (paramArrayOfByte.bytes_bodybuffer.has()) && (paramArrayOfByte.bytes_bodybuffer.get() != null))
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
  
  private void aF()
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof SplashActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
  
  private void aG()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      QQProgressDialog localQQProgressDialog = this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131698526, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
    }
  }
  
  private void aH()
  {
    if ((B()) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig())) {
      return;
    }
    if (C()) {
      return;
    }
    ar();
    aq();
    if (QLog.isColorLevel()) {
      QZLog.d(this.jdField_b_of_type_JavaLangString, 2, "setInitHeader in INIT_PUBLICACCOUNT_COVER_MENU");
    }
    if (this.jdField_g_of_type_Int != 1) {
      this.jdField_j_of_type_Int = 5;
    }
  }
  
  private void aI()
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getPublicAccountMenuButtonList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b());
    c(localList);
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (C()) {
        return;
      }
      if ((!B()) || (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig())) {
        m(true);
      }
    }
  }
  
  private void aJ()
  {
    if (this.X)
    {
      if (!this.Y) {
        return;
      }
      if ((PublicAccountInfo)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
        return;
      }
    }
    if (C())
    {
      IEcshopChatPieDelegate localIEcshopChatPieDelegate = this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate;
      if ((localIEcshopChatPieDelegate != null) && (localIEcshopChatPieDelegate.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout))) {
        return;
      }
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
      try
      {
        at();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void aK()
  {
    if (this.N) {
      return;
    }
    this.N = true;
    EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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
        String str2 = this.jdField_b_of_type_JavaLangString;
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
        ((IEcshopAdHandler.ReportInfo)localObject2).jdField_a_of_type_Int = 2;
        localObject2 = ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).rebuildReportParam((IEcshopAdHandler.ReportInfo)localObject2, (MessageRecord)localObject1);
        ((IEcshopAdHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a((IEcshopAdHandler.ReportInfo)localObject2, null);
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
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("jump_from", 4);
      if (i1 == 2) {
        localEcshopReportHandler.a(134243865, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, null, null, i1, false);
      }
    }
  }
  
  private void aL()
  {
    PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localPublicAccountInfo != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(localPublicAccountInfo.accountFlag) == -2))
    {
      this.ah = true;
      ar();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.f();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b <= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
        return;
      }
      int i3 = ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (i3 == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
        return;
      }
      int i2 = 0;
      int i1;
      if ((i3 & 0xF) == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i3 >> 4 == 1) {
        i2 = 1;
      }
      if ((i1 != 0) && (i2 != 0))
      {
        this.ai = true;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.e();
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b();
      }
      aT();
      return;
    }
    aT();
  }
  
  private void aM()
  {
    if ((NetworkUtil.getNetworkType(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext()) == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals("2632129500"))) {
      HtmlOffline.b("108", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new PublicAccountChatPie.6(this));
    }
  }
  
  private void aN()
  {
    if ("3105932915".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ((IQQPluginPreloadService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQPluginPreloadService.class)).preload(5);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "the public account is boodo comic");
      }
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.qqcomic.care");
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.carecomic.normal");
      ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.carecomic.update");
    }
  }
  
  private void aO()
  {
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).shouldPreloadWebProcess(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
      if (localIWebProcessManagerService != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doOnCreate, preload web process");
        }
        localIWebProcessManagerService.startWebProcess(-1, null);
      }
    }
  }
  
  private void aP()
  {
    if (this.J)
    {
      if (this.K) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "new", "", "", false);
      } else {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "old", "", "", false);
      }
    }
    else
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", false);
      if ("2290230341".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E2", "0X80090E2", 0, 0, "", "", "", "");
        QZoneReport.a(2);
      }
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).enterPublicAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).isSupportPay(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.F = true;
    }
  }
  
  private void aQ()
  {
    if (B())
    {
      long l1 = ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getClickAioTime();
      if (Math.abs(System.currentTimeMillis() - l1) > 500L) {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).initClickAioTime();
      }
      ThreadManagerV2.excute(new PublicAccountChatPie.7(this), 16, null, false);
    }
  }
  
  private void aR()
  {
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_page_arrive");
    }
  }
  
  private void aS()
  {
    CustomMenuBar localCustomMenuBar = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
    if (localCustomMenuBar != null) {
      localCustomMenuBar.setVisibility(8);
    }
    V();
    X();
  }
  
  private void aT()
  {
    ThreadManager.postImmediately(new PublicAccountChatPie.10(this), null, true);
  }
  
  private void aU()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().iterator();
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
    localObject1 = this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject1 != null) && (((QQProgressDialog)localObject1).isShowing()))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    localObject1 = this.jdField_c_of_type_AndroidAppDialog;
    if ((localObject1 != null) && (((Dialog)localObject1).isShowing()))
    {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
      this.jdField_c_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject1 != null) && (((QQCustomDialog)localObject1).isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar;
    if (localObject1 != null) {
      ((TroopEntranceBar)localObject1).a();
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler;
    if (localObject1 != null) {
      ((IPublicAccountHandler)localObject1).clearWeatherInfoListener();
    }
  }
  
  private void aV()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras() == null) {
      q();
    }
  }
  
  private void aW()
  {
    this.jdField_g_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext()).inflate(2131558569, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    Object localObject = this.jdField_g_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    ((View)localObject).setClickable(true);
    this.jdField_g_of_type_AndroidViewView.findViewById(2131368343).setOnClickListener(new PublicAccountChatPie.20(this));
    if (this.jdField_g_of_type_Int == 2)
    {
      this.jdField_g_of_type_AndroidViewView.findViewById(2131373214).setVisibility(8);
      this.jdField_g_of_type_AndroidViewView.findViewById(2131373200).setVisibility(8);
    }
    else if (this.X)
    {
      this.jdField_g_of_type_AndroidViewView.findViewById(2131373214).setVisibility(8);
      this.jdField_g_of_type_AndroidViewView.findViewById(2131373200).setVisibility(8);
    }
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_g_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void aX()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = ((PublicMenuBar)this.jdField_g_of_type_AndroidViewView.findViewById(2131373197));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setOnMenuItemClickListener(new PublicAccountChatPie.21(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.b();
    boolean bool = this.X;
    int i1 = 2131691813;
    Object localObject;
    MenuItem localMenuItem1;
    if (!bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if (!this.ai) {
        i1 = 2131691812;
      }
      localObject = new MenuItem("DO_NOT_FOLLOW", ((BaseActivity)localObject).getString(i1), a().getResources().getDrawable(2130841813), 0);
      localMenuItem1 = new MenuItem("DO_FOLLOW", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691811), a().getResources().getDrawable(2130841700), 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((MenuItem)localObject, 2131559983);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem1, 2131559983);
    }
    else
    {
      localObject = new MenuItem("DO_CANCEL", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690731), a().getResources().getDrawable(2130841813), 0);
      localMenuItem1 = new MenuItem("DO_FOLLOW", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691811), a().getResources().getDrawable(2130841700), 1);
      MenuItem localMenuItem2 = new MenuItem("DO_NOT_FOLLOW", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691813), a().getResources().getDrawable(2130841813), 0);
      this.jdField_j_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((MenuItem)localObject, 2131559983);
      this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem2, 2131559983);
      this.jdField_k_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem1, 2131559983);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setSwitchButtonVisibility(false);
    if (this.ak)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(0);
  }
  
  private void aY()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
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
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localBundle.putString("puin", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(str);
    localStringBuilder.append(";skey=");
    localStringBuilder.append((String)localObject);
    localBundle.putString("Cookie", localStringBuilder.toString());
    localBundle.putString("Referer", "https://buluo.qq.com");
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
    new HttpWebCgiAsyncTask2("https://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new PublicAccountChatPie.26(this), 1000, null).a(localHashMap);
    ap();
  }
  
  private void aZ()
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new PublicAccountChatPie.33(this));
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((paramInt4 < -5) && (this.P)) || (((this.H) || ((paramInt1 + paramInt2 == paramInt3) && (paramInt4 < 0) && (this.P))) && (!this.G)))
    {
      this.G = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.r, 0.0F);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setAnimationListener(new PublicAccountChatPie.17(this));
      this.jdField_g_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
  }
  
  private void b(android.os.Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
      return;
    }
    if (paramMessage.arg2 == 1)
    {
      int i1 = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, String.format(HardCodeUtil.a(2131708744), new Object[] { (String)paramMessage.obj }), HardCodeUtil.a(2131708758), HardCodeUtil.a(2131708754), new PublicAccountChatPie.2(this, i1), null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  private void b(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1))
    {
      p(80);
      return;
    }
    if (CustomMenuBar.a()) {
      p(16);
    }
  }
  
  private void b(IPublicAccountDetail paramIPublicAccountDetail)
  {
    if (paramIPublicAccountDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.remove(paramIPublicAccountDetail.getEntity());
    localEntityManager.close();
  }
  
  private void b(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramMessageForStructing.structingMsg;
    this.jdField_l_of_type_JavaLangString = paramMessageForStructing.getExtInfoFromExtStr("msg_template_id");
    this.jdField_g_of_type_Int = paramMessageForStructing.structingMsg.mPromotionType;
    this.jdField_d_of_type_JavaLangString = paramMessageForStructing.structingMsg.mPromotionMsg;
    this.jdField_e_of_type_JavaLangString = paramMessageForStructing.structingMsg.mPromotionMenus;
    this.jdField_h_of_type_Int = paramMessageForStructing.structingMsg.mPromotionMenuDestructiveIndex;
    try
    {
      if (this.jdField_e_of_type_JavaLangString == null) {
        break label148;
      }
      int i1 = 0;
      this.al = false;
      paramMessageForStructing = this.jdField_e_of_type_JavaLangString.split(",");
      if (paramMessageForStructing == null) {
        break label148;
      }
      int i2 = paramMessageForStructing.length;
      this.jdField_a_of_type_ArrayOfInt = new int[i2];
      while (i1 < i2)
      {
        paramMessageForStructing[i1] = paramMessageForStructing[i1].trim();
        this.jdField_a_of_type_ArrayOfInt[i1] = Integer.parseInt(paramMessageForStructing[i1]);
        i1 += 1;
      }
    }
    catch (Exception paramMessageForStructing)
    {
      label143:
      label148:
      break label143;
    }
    this.al = true;
  }
  
  private void b(AbsListView paramAbsListView)
  {
    try
    {
      if (EcshopFromUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        int i2 = paramAbsListView.getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          View localView = paramAbsListView.getChildAt(i1);
          if (localView != null) {
            GdtImpressionPolicy.a().a(localView);
          }
          i1 += 1;
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
  
  private boolean b(View paramView)
  {
    if (((paramView.getTag() instanceof String)) && ("tag_on_nearby_tips_click".equals(paramView.getTag())) && (this.jdField_a_of_type_AndroidContentContext != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (System.currentTimeMillis() - this.jdField_d_of_type_Long < 1000L) {
        return true;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      paramView = new StringBuilder("https://gouwu.qq.com/m/html/shop_map.html?_wv=1027&shop_uin=");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView.toString());
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("webStyle", "noBottomBar");
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconClk", "Clk_shopnearbyicon", 0, 0, "", "", "", "");
    }
    return false;
  }
  
  private void ba()
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new PublicAccountChatPie.34(this));
  }
  
  private void bb()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("public_aio_setting", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("firstOpen_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.getBoolean((String)localObject, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.sendMenuEventequest(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.35(this, localSharedPreferences, (String)localObject));
  }
  
  private void bc()
  {
    if (this.jdField_f_of_type_Long == 0L) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (localObject != null) {
        localHashMap.put("uin", localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {
        localHashMap.put("puin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_m_of_type_Int);
      localHashMap.put("menu_click", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_o_of_type_Int);
      localHashMap.put("menu_to_webview", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_n_of_type_Int);
      localHashMap.put("article_click", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.p);
      localHashMap.put("article_to_webview", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(NetworkCenter.getInstance().getNetType());
      localHashMap.put("net_type", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.u);
      localHashMap.put("unread_count", ((StringBuilder)localObject).toString());
      long l1 = System.currentTimeMillis() - this.jdField_f_of_type_Long;
      boolean bool;
      if ((this.p == 0) && (this.jdField_o_of_type_Int == 0)) {
        bool = false;
      } else {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("public account webview preload data: ");
        ((StringBuilder)localObject).append("duration: ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", entered: ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", exinfo: ");
        ((StringBuilder)localObject).append(localHashMap.toString());
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPublicAccountWebviewPreload", bool, l1, 0L, localHashMap, "");
      this.jdField_f_of_type_Long = 0L;
      this.u = 0;
      this.jdField_o_of_type_Int = 0;
      this.jdField_m_of_type_Int = 0;
      this.jdField_n_of_type_Int = 0;
      this.p = 0;
    }
  }
  
  private void bd()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EFD", "0X8004EFD", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8004F08", "0X8004F08", 0, 0, "", "", "", "");
    PAStartupTracker.a(null, "pubAcc_profile_display", "");
  }
  
  private void be()
  {
    if (this.ak) {
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "clk_return", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, "");
    }
  }
  
  private void bf()
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      localImageView = this.jdField_n_of_type_AndroidWidgetImageView;
      if (localImageView != null)
      {
        localImageView.setImageResource(this.jdField_k_of_type_Int);
        this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131689931));
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
      localImageView = this.jdField_n_of_type_AndroidWidgetImageView;
      if (localImageView != null)
      {
        localImageView.setImageResource(this.jdField_l_of_type_Int);
        this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131689930));
      }
    }
  }
  
  private void bg()
  {
    ShortVideoUtils.loadShortVideoSo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (FastImageHelper)a(83);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8)
    {
      ImageView localImageView = this.jdField_m_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689914));
      }
      ((FastImageHelper)localObject).b(true);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return;
    }
    ((FastImageHelper)localObject).b();
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
    localObject = this.jdField_n_of_type_AndroidWidgetImageView;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
      n(false);
    }
    localObject = this.jdField_m_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689836));
    }
    h(0);
  }
  
  private void bh()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      localImageView = this.jdField_n_of_type_AndroidWidgetImageView;
      if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
        n(false);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
    }
    ImageView localImageView = this.jdField_m_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689914));
    }
  }
  
  private void bi()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    StringBuilder localStringBuilder;
    if ((QLog.isColorLevel()) && (this.jdField_n_of_type_AndroidWidgetImageView != null))
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onClick fun_btn start text.length ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
      localStringBuilder.append("mAudioBtn visibility:");
      localStringBuilder.append(this.jdField_n_of_type_AndroidWidgetImageView.getVisibility());
      localStringBuilder.append(" currentPanel:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
      localStringBuilder.append(" currenttime:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2))
    {
      localObject = this.jdField_n_of_type_AndroidWidgetImageView;
      if ((localObject != null) && (((ImageView)localObject).getVisibility() != 0))
      {
        R();
        if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) && (((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_search_push");
        }
      }
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onClick fun_btn end text.length");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
        localStringBuilder.append("cast time :");
        localStringBuilder.append(l2 - l1);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800584F", "0X800584F", 0, 0, "", "", "", "", false);
    }
    if (this.J) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C9C", "0X8005C9C", 0, 1, 0, "", "", "", "");
    }
  }
  
  private void bj()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
    if (localObject != null)
    {
      a((PublicAccountInfo)localObject);
      return;
    }
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
    ((NewIntent)localObject).putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.7.0,3,5295");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      label185:
      ((NewIntent)localObject).putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new PublicAccountChatPie.38(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label185;
    }
  }
  
  private void bk()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "ChatActivityConstants.MSG_PUBLICACCOUNT_ACCOUNTDETAIL");
    }
    Object localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(((IPublicAccountDetail)localObject).getName());
        if (this.E)
        {
          c((IPublicAccountDetail)localObject);
          this.E = false;
        }
        localObject = this.jdField_b_of_type_AndroidAppDialog;
        au();
      }
    }
    if (this.D)
    {
      this.D = false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler = ((IPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler.onFollowPublicAccount(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiIPublicAccountDetail);
      ao();
    }
  }
  
  private void bl()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver = new NewPublicAccountObserver(new PublicAccountChatPie.44(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    PublicAccountStateReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
  }
  
  private void bm()
  {
    Object localObject = this.jdField_c_of_type_MqqAppNewIntent;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).ext.set("4");
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new PublicAccountChatPie.45(this);
    this.jdField_c_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
  }
  
  private void bn()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
    if ((localObject != null) && (((PublicAccountInfo)localObject).isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      bo();
    }
  }
  
  private void bo()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new PublicAccountChatPie.46(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      bp();
      return;
    }
    bp();
  }
  
  private void bp()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicAccountChatPie.47(this, 1, true, true, 0L, false, false, "PublicAccountChatPie"));
  }
  
  private void bq()
  {
    a((RelativeLayout)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getParent());
  }
  
  private void br()
  {
    Object localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(((PublicAccountInfo)localObject).accountFlag2) == -10L))
      {
        this.ak = true;
        localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 115, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon((Drawable)localObject);
        }
      }
    }
  }
  
  private void bs()
  {
    if (this.jdField_h_of_type_Long == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_h_of_type_Long;
    PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localPublicAccountInfo != null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localPublicAccountInfo.uin);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localPublicAccountInfo.name);
      localStringBuilder.append("");
      RecentPubAccHelper.a(localQQAppInterface, (String)localObject, l1 - l2, localStringBuilder.toString());
    }
    this.jdField_h_of_type_Long = 0L;
  }
  
  private void bt()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new PublicAccountChatPie.64(this);
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void bu()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PublicAccountChatPie", 2, "unregisterNetworkChangedReceiver error", localException);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i1 = this.jdField_j_of_type_Int;
    if (i1 != 3)
    {
      if (i1 != 4) {
        return;
      }
      if ((paramInt2 == paramInt1) && (this.ad))
      {
        paramInt1 = this.r;
        if (paramInt1 != 0) {
          a(this.jdField_m_of_type_AndroidViewView, paramInt1);
        }
        this.ad = false;
        this.H = true;
      }
      this.jdField_j_of_type_Int = 2;
      this.Q = true;
      return;
    }
    if ((paramInt2 > paramInt1) && (!this.ad))
    {
      this.r = this.jdField_m_of_type_AndroidViewView.getLayoutParams().height;
      e(this.jdField_m_of_type_AndroidViewView);
      this.ad = true;
    }
    this.jdField_j_of_type_Int = 2;
    this.Q = true;
  }
  
  private void c(IPublicAccountDetail paramIPublicAccountDetail)
  {
    Object localObject1 = this.jdField_g_of_type_AndroidViewView;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131380149);
    localObject1 = (TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131380148);
    ImageView localImageView = (ImageView)this.jdField_g_of_type_AndroidViewView.findViewById(2131368343);
    if (this.ai)
    {
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar;
      if ((localObject3 != null) && (((TroopEntranceBar)localObject3).b > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject3 = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0);
        ((TextView)localObject2).setText(((TroopInfo)localObject3).troopname);
        ((TextView)localObject1).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131695191), new Object[] { paramIPublicAccountDetail.getName() }));
        localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((TroopInfo)localObject3).troopuin));
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = ((TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
        } else {
          localObject1 = "";
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
          localObject2 = "";
        } else {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append((String)localObject2);
        ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_public", "", "oper", "exp_temp", 0, 0, (String)localObject1, localStringBuilder.toString(), "", "");
      }
    }
    else
    {
      ((TextView)localObject2).setText(paramIPublicAccountDetail.getName());
      localObject2 = this.jdField_d_of_type_JavaLangString;
      if (localObject2 != null) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      localImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().jdField_a_of_type_JavaLangString, (byte)3));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new PublicAccountChatPie.42(this, localImageView);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    }
    localObject1 = (ImageView)this.jdField_g_of_type_AndroidViewView.findViewById(2131364429);
    if (paramIPublicAccountDetail.getCertifiedGrade() == 0L)
    {
      ((ImageView)localObject1).setVisibility(8);
      return;
    }
    ((ImageView)localObject1).setVisibility(0);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (((paramInt2 > 5) && (this.P)) || ((paramInt1 == this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()) && (paramInt2 > 0) && (this.P) && (!this.G)))
    {
      this.G = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.r);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setAnimationListener(new PublicAccountChatPie.18(this));
      this.jdField_g_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
  }
  
  private void d(List<mobileqq_mp.ButtonInfo> paramList)
  {
    this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getMenuSetting(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
    if ((paramList != null) && (!paramList.isEmpty())) {
      m(true);
    }
    this.ae = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountTipsManager == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountTipsManager = ((IPublicAccountTipsManager)QRoute.api(IPublicAccountTipsManager.class));
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountTipsManager.init(this.jdField_a_of_type_AndroidContentContext);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if ((((Intent)localObject).hasExtra("pub_account_type")) && ("type_ecshop_account".equals(((Intent)localObject).getStringExtra("pub_account_type"))))
    {
      localObject = ((Intent)localObject).getStringExtra("ecshop_distance_tip");
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountTipsManager.createEcshopDistanceTipsBar((String)localObject, this);
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountTipsManager.showTipsBar(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (View)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconPv", "Pv_shopnearbyicon", 0, 0, "", "", "", "");
    }
    if ((B()) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()))
    {
      V();
      localObject = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
      if (localObject != null) {
        ((CustomMenuBar)localObject).setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initPublicAccountMenu new qqgame pubaccount return");
      }
    }
    localObject = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
    if ((localObject != null) && (((CustomMenuBar)localObject).getVisibility() == 0) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (mobileqq_mp.ButtonInfo)paramList.next();
        if (localObject != null) {
          OfficialAccountReporter.a.a(b(), ((mobileqq_mp.ButtonInfo)localObject).id.get(), ((mobileqq_mp.ButtonInfo)localObject).name.get());
        }
      }
    }
  }
  
  private void e(String paramString)
  {
    AIOUtils.o = true;
    this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    long l1 = NetConnInfoCenter.getServerTime();
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    QQAppInterface localQQAppInterface;
    Object localObject1;
    Object localObject2;
    if ("DO_FOLLOW".equals(paramString))
    {
      if (this.ai)
      {
        aY();
        paramString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar;
        if ((paramString != null) && (paramString.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0)) {
          paramString = ((TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
        } else {
          paramString = "";
        }
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(str);
        ReportController.b(localQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_close_temp", 0, 0, paramString, ((StringBuilder)localObject1).toString(), "", "");
        this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.init(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new PublicAccountChatPie.22(this));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        paramString = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = Long.toString(l1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
        paramString.publicAccountReportClickEventForMigrate(localQQAppInterface, "CliOper", "", str, "0X8004EF5", "0X8004EF5", 0, 0, (String)localObject1, "", ((StringBuilder)localObject2).toString(), this.jdField_l_of_type_JavaLangString, false);
      }
      l(2131695275);
      av();
      return;
    }
    if ("DO_NOT_FOLLOW".equals(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        paramString = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = Long.toString(l1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.jdField_l_of_type_JavaLangString);
        paramString.publicAccountReportClickEventForMigrate(localQQAppInterface, "CliOper", "", str, "0X8004EF7", "0X8004EF7", 0, 0, (String)localObject1, "", (String)localObject2, localStringBuilder.toString(), false);
      }
      if (this.ai)
      {
        f(str);
        paramString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar;
        if ((paramString != null) && (paramString.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0)) {
          paramString = ((TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
        } else {
          paramString = "";
        }
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(str);
        ReportController.b(localQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_focus_temp", 0, 0, paramString, ((StringBuilder)localObject1).toString(), "", "");
        return;
      }
      as();
      return;
    }
    if ("DO_CANCEL".equals(paramString))
    {
      l(2131695275);
      this.jdField_b_of_type_MqqAppNewIntent = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, false, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new PublicAccountChatPie.23(this));
    }
  }
  
  private void e(List<mobileqq_mp.ButtonInfo> paramList)
  {
    int i3 = paramList.size();
    int i1 = 0;
    while (i1 < i3)
    {
      if (i1 > 2) {
        return;
      }
      Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i1);
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
      int i2;
      if (((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
        i2 = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
      } else {
        i2 = 0;
      }
      MenuItem localMenuItem = new MenuItem((String)localObject1, str, null, i2);
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
            i2 = localButtonInfo.id.get();
          } else {
            i2 = 0;
          }
          localObject1 = new MenuItem((String)localObject1, str, null, i2);
          ((MenuItem)localObject1).a(localButtonInfo);
          localMenuItem.a((MenuItem)localObject1);
        }
      }
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localMenuItem, b());
      i1 += 1;
    }
  }
  
  private void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "unfollow");
    }
    o(2131695272);
    Object localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((IPublicAccountDetail)localObject).getAccountFlag()) != -4))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
        this.jdField_b_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver = new NewPublicAccountObserver(new PublicAccountChatPie.28(this, paramString));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
        PublicAccountStateReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      }
      else
      {
        localObject = new NewIntent(BaseApplicationImpl.getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
        ((NewIntent)localObject).putExtra("cmd", "unfollow");
        mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
        localUnFollowRequest.uin.set((int)Long.parseLong(paramString));
        ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
        this.jdField_b_of_type_MqqObserverBusinessObserver = new PublicAccountChatPie.27(this, paramString);
        ((NewIntent)localObject).setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      }
    }
    this.y += 1;
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).removeLbsUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "unfollow exit");
    }
  }
  
  private void h(Intent paramIntent)
  {
    try
    {
      if (EcshopFromUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.gouwu.video");
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.gwh.video");
        GdtNotify.a();
        if (C())
        {
          if (((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).isArkReportOpen()) {
            ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.qqshop");
          }
          i(paramIntent);
          return;
        }
        paramIntent = (IEcshopAdHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
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
  
  private void i(Intent paramIntent)
  {
    try
    {
      PublicAccountChatPie.8 local8 = new PublicAccountChatPie.8(this);
      this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate = ((IEcshopChatPieApi)QRoute.api(IEcshopChatPieApi.class)).createEcshopChatPie(paramIntent, local8);
      if (this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout))
      {
        aS();
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new PublicAccountChatPie.9(this));
      }
      paramIntent = (IEcshopAdHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
      if (paramIntent != null)
      {
        paramIntent.a(null, null, false, null, 10);
        return;
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, QLog.getStackTraceString(paramIntent));
    }
  }
  
  private void o(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new PublicAccountChatPie.29(this, paramInt), 500L);
  }
  
  private void p(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      return;
    }
    localObject = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    if (((LinearLayout.LayoutParams)localObject).gravity != paramInt)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = paramInt;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (localLayoutParams.gravity != paramInt)
    {
      localLayoutParams.gravity = paramInt;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
    }
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (((LinearLayout.LayoutParams)localObject).gravity != paramInt)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = paramInt;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private boolean x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(null);
    }
    if (this.B)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return true;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).cleanPublicAccountObserver();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$HomeBroadcast != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$HomeBroadcast);
      label73:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$HomeBroadcast = null;
      if (this.jdField_b_of_type_MqqAppNewIntent != null) {
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccountCancelCallback(this.jdField_b_of_type_MqqAppNewIntent);
      }
      NewIntent localNewIntent = this.jdField_c_of_type_MqqAppNewIntent;
      if (localNewIntent != null) {
        localNewIntent.setObserver(null);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
        this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = null;
      }
      return false;
    }
    catch (Exception localException)
    {
      break label73;
    }
  }
  
  private boolean y()
  {
    if (!this.X)
    {
      if (this.ac) {
        return true;
      }
      if ((this.jdField_g_of_type_AndroidViewView != null) && (this.jdField_m_of_type_AndroidViewView != null)) {
        return this.jdField_j_of_type_Int == 5;
      }
    }
    return true;
  }
  
  private boolean z()
  {
    this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366392));
    Object localObject1 = this.jdField_o_of_type_AndroidWidgetImageView;
    if (localObject1 != null) {
      ((ImageView)localObject1).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getText(2131696433));
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar);
    }
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_g_of_type_AndroidViewView);
      this.jdField_g_of_type_AndroidViewView = null;
    }
    if (this.jdField_m_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_m_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366391));
    localObject1 = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
    if (localObject1 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131558570, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366391));
    }
    else
    {
      ((CustomMenuBar)localObject1).setVisibility(8);
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
    if (localObject1 == null) {
      return true;
    }
    ((CustomMenuBar)localObject1).setMenuType(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getPublicAccountMenuType(b()));
    if (CustomMenuBar.a())
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167208));
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(AIOUtils.b(48.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      localObject1 = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getLayoutParams();
      if ((localObject2 != null) && (localObject1 != null) && ((localObject2 instanceof RelativeLayout.LayoutParams)) && ((localObject1 instanceof RelativeLayout.LayoutParams)))
      {
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        int[] arrayOfInt = ((RelativeLayout.LayoutParams)localObject2).getRules();
        if ((arrayOfInt.length > 2) && (arrayOfInt[2] == 2131368875))
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131366391);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = (RelativeLayout.LayoutParams)localObject1;
          ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131368875);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    return false;
  }
  
  protected void K()
  {
    if ((this.ah) && (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) > 0)) {
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.K();
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler = ((IPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      if (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountHandler.getWeatherInfo(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, null);
      }
    }
    else if ((((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isHealthUin(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isSupportStepCounter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplicationContext())) && (Build.VERSION.SDK_INT >= 19))
    {
      ((ISportManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISportManager.class, "multi")).refreshCurrentStep("public account");
    }
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if ((localEcShopAssistantManager != null) && (localEcShopAssistantManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ThreadManager.post(new PublicAccountChatPie.4(this), 5, null, true);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    NowVideoController.a().a(1000L);
    OfficialAccountReporter.a.a(a());
  }
  
  protected void O()
  {
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
  }
  
  protected void X()
  {
    super.X();
    if (this.jdField_e_of_type_AndroidViewView != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
        if (localLayoutParams != null)
        {
          if (!w())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getId());
            return;
          }
          if (!v())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getId());
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
  
  protected AIOContext a()
  {
    return new PAContext();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new PAListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new PAMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected HelperProvider a()
  {
    return new PAHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
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
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, paramAbsStructMsg.getMessage());
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    ChatMessage localChatMessage;
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() >= 1)
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().get(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1);
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
        long l1;
        String str2 = str3;
      }
    }
    str3 = localChatMessage.getExtInfoFromExtStr("pa_msgId");
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localChatMessage.frienduin);
    ReportController.b((AppRuntime)localObject, "P_CliOper", "Pb_account_lifeservice", localStringBuilder.toString(), "0X8005C38", "0X8005C38", 0, 1, 0, str3, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
    if (this.J)
    {
      l1 = NetConnInfoCenter.getServerTime() * 1000L;
      if (this.K)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "new", String.valueOf(l1 - this.jdField_b_of_type_Long), "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "old", String.valueOf(l1 - this.jdField_b_of_type_Long), "", "");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.af = true;
  }
  
  void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3, paramInt, 1, paramBusinessObserver);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.X) {
      aC();
    }
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(Editable paramEditable)
  {
    b(paramEditable);
    boolean bool3 = this.jdField_d_of_type_Boolean;
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3)
    {
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690820);
      localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() > 0) {
        bool1 = true;
      }
      ((PatchedButton)localObject).setEnabled(bool1);
      return;
    }
    Object localObject = this.jdField_n_of_type_AndroidWidgetImageView;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
      return;
    }
    localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
    bool1 = bool2;
    if (paramEditable.length() > 0) {
      bool1 = true;
    }
    ((PatchedButton)localObject).setEnabled(bool1);
    if (paramEditable.length() > 0)
    {
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690820);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (ServiceAccountFolderManager.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ServiceAccountFolderManager.a().a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    super.a(paramChatMessage);
    Object localObject2 = paramChatMessage.frienduin;
    int i1 = paramChatMessage.istroop;
    Object localObject1;
    if (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, i1))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localObject2 = ((RecentUserProxy)localObject1).a((String)localObject2, i1);
      if (localObject2 != null) {
        ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
      }
    }
    if (C())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate;
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
        localObject1 = this.jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=");
        ((StringBuilder)localObject2).append(paramPublicAccountInfo.mIsSyncLbsSelected);
        ((StringBuilder)localObject2).append(", eqqPublicAccountInfo.isSyncLbs=");
        ((StringBuilder)localObject2).append(paramPublicAccountInfo.isSyncLbs);
        ((StringBuilder)localObject2).append(", eqqPublicAccountInfo.mIsAgreeSyncLbs=");
        ((StringBuilder)localObject2).append(paramPublicAccountInfo.mIsAgreeSyncLbs);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): pam is null");
        }
        return;
      }
      if ((paramPublicAccountInfo.isSyncLbs) && (!paramPublicAccountInfo.mIsSyncLbsSelected) && (!paramPublicAccountInfo.mIsAgreeSyncLbs) && (!this.ag))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692063);
        String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692061), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
        this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, (String)localObject2, str, 2131692060, 2131692062, new PublicAccountChatPie.39(this, paramPublicAccountInfo, (IPublicAccountDataManager)localObject1), new PublicAccountChatPie.40(this, paramPublicAccountInfo, (IPublicAccountDataManager)localObject1));
        this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new PublicAccountChatPie.41(this));
        this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          this.jdField_b_of_type_AndroidAppDialog.show();
        }
        this.ag = true;
      }
    }
    else if (QLog.isColorLevel())
    {
      paramPublicAccountInfo = this.jdField_b_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.e(paramPublicAccountInfo, 2, ((StringBuilder)localObject1).toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): END");
    }
  }
  
  void a(AbsListView paramAbsListView)
  {
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    int i1 = paramAbsListView.getFirstVisiblePosition();
    while (i1 <= paramAbsListView.getLastVisiblePosition())
    {
      a(localArrayList4, localArrayList5, localArrayList1, localArrayList2, localArrayList3, (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1), i1);
      i1 += 1;
    }
    b(localArrayList4);
    if (!localArrayList5.isEmpty()) {}
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.sendMsgArriveReceipt(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, 0L, l1, l2, 2, localArrayList5);
      paramAbsListView = localArrayList4.iterator();
      while (paramAbsListView.hasNext()) {
        if ("1".equals(((ChatMessage)paramAbsListView.next()).getExtInfoFromExtStr("is_AdArrive_Msg")))
        {
          if (this.jdField_a_of_type_Long == -1L) {
            this.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
          }
          this.jdField_a_of_type_JavaUtilList = localArrayList1;
          ((IPAReportUtil)QRoute.api(IPAReportUtil.class)).reportAdMsgRead(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList2, localArrayList1, localArrayList3);
        }
      }
      return;
    }
    catch (Exception paramAbsListView) {}
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    this.W = true;
    super.a(paramList, paramCharSequence);
    if (this.jdField_q_of_type_Boolean)
    {
      int i1 = -1;
      long l1 = 0L;
      if (paramList.size() > 0)
      {
        paramList = (ChatMessage)paramList.get(paramList.size() - 1);
        int i2 = paramList.msgtype;
        long l2 = paramList.msgseq;
        i1 = i2;
        l1 = l2;
        if ((paramList instanceof MessageForStructing))
        {
          paramList = (MessageForStructing)paramList;
          i1 = i2;
          l1 = l2;
          if (paramList.structingMsg != null)
          {
            l1 = paramList.structingMsg.msgId;
            i1 = i2;
          }
        }
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("");
      paramCharSequence.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramCharSequence = paramCharSequence.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(i1);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l1);
      ReportController.b(paramList, "dc00899", "Pb_account_lifeservice", paramCharSequence, "0X80064D4", "0X80064D4", 0, 0, "", (String)localObject, localStringBuilder.toString(), "");
    }
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<<<<<<<<<<<<<<list.size<<<<<<<<<");
    localStringBuilder.append(paramList.size());
    QLog.i(str, 2, localStringBuilder.toString());
    try
    {
      if (C())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate != null) {
          this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate.a(paramList, new PublicAccountChatPie.55(this, paramCharSequence, paramInt));
        }
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, QLog.getStackTraceString(localThrowable1));
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
        try
        {
          ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).handlePubRefreshList(paramList);
        }
        catch (Throwable localThrowable2)
        {
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, localThrowable2, new Object[0]);
        }
      }
      if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        ((IQQGameSubscribeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQGameSubscribeService.class)).filterSingleGameMsgList(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramList);
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
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("qidianWpaClick ... mQidianKefu = ");
      ((StringBuilder)localObject2).append(this.Z);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    l(2131695275);
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
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.requestQidiKefu(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMap, (String)localObject1, null, new PublicAccountChatPie.60(this));
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EF8", "0X8004EF8", 0, 0, Integer.toString(paramInt), "", "", "");
    if (this.jdField_b_of_type_MqqAppNewIntent != null)
    {
      ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccountCancelCallback(this.jdField_b_of_type_MqqAppNewIntent);
      this.jdField_b_of_type_MqqAppNewIntent = null;
    }
    this.jdField_b_of_type_MqqAppNewIntent = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt, paramBoolean, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new PublicAccountChatPie.43(this));
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!w()) {
        this.jdField_v_of_type_Int = 2;
      } else if (!v()) {
        this.jdField_v_of_type_Int = 1;
      } else {
        this.jdField_v_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      }
      CustomMenuBar localCustomMenuBar = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
      if (localCustomMenuBar != null) {
        localCustomMenuBar.setVisibility(8);
      }
      super.a(paramBoolean1, paramChatMessage, paramBoolean2);
      return;
    }
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    int i1 = this.jdField_v_of_type_Int;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          }
          paramChatMessage = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
          if (paramChatMessage != null) {
            paramChatMessage.setVisibility(0);
          }
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
        if (paramChatMessage != null) {
          paramChatMessage.setVisibility(8);
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      }
      paramChatMessage = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
      if (paramChatMessage != null) {
        paramChatMessage.setVisibility(8);
      }
    }
    this.jdField_v_of_type_Int = -1;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$HomeBroadcast = new PublicAccountChatPie.HomeBroadcast(this, null);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$HomeBroadcast, (IntentFilter)localObject);
    this.B = false;
    this.jdField_v_of_type_Boolean = false;
    aV();
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class));
    ay();
    super.a(paramBoolean);
    if (this.X) {
      aA();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0) {
      this.S = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar = new TroopEntranceBar();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.addObserver(this);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    this.t = ((Intent)localObject).getIntExtra("red_hot_count", 0);
    String str = ((Intent)localObject).getStringExtra("from");
    this.O = ((Intent)localObject).getBooleanExtra("shouldreport", false);
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    this.jdField_n_of_type_Int = 0;
    this.p = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
    this.u = this.t;
    paramBoolean = ((Intent)localObject).getBooleanExtra("is_come_from_readinjoy", false);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setComeFromReadInJoy(paramBoolean);
    this.w = ((Intent)localObject).getIntExtra("INTENT_KEY_FROM", 1);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      aL();
      ((IPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).setLocalIp(null);
      this.M = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("has_unread_msg", false);
    }
    if (a((Intent)localObject, str)) {
      return true;
    }
    aM();
    aN();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    this.J = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnCreate, isMediaAndOtherSubscript = ");
      localStringBuilder.append(this.J);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    aO();
    if (this.J)
    {
      bq();
      aw();
      ((PAListUI)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a()).a();
    }
    aP();
    aQ();
    h((Intent)localObject);
    aR();
    bt();
    return true;
  }
  
  public void aA()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "checkQDAccountValid ...");
    }
    ThreadManager.post(new PublicAccountChatPie.57(this), 8, null, false);
  }
  
  public void aB()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateHeader ... ");
      Object localObject = this.jdField_g_of_type_AndroidViewView;
      if (localObject != null) {
        localObject = Integer.valueOf(((View)localObject).getVisibility());
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar != null)
    {
      if (!this.Y) {
        return;
      }
      if (this.aa)
      {
        this.jdField_j_of_type_AndroidViewView.setVisibility(0);
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void aC()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateWpaUiForQidian: mQidianAccountValid = ");
      localStringBuilder.append(this.Y);
      localStringBuilder.append(", mQidianKefu = ");
      localStringBuilder.append(this.Z);
      localStringBuilder.append(", mQidianShield: ");
      localStringBuilder.append(this.aa);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.Y)
    {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      int i2 = 0;
      if (localObject != null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        at();
        return;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
      if (this.aa) {}
      while (!this.Z)
      {
        i1 = 8;
        break;
      }
      int i1 = i2;
      ((InputLinearLayout)localObject).setVisibility(i1);
      if (this.jdField_o_of_type_AndroidWidgetImageView == null) {
        this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366392));
      }
      this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
      if (localObject != null) {
        ((CustomMenuBar)localObject).setVisibility(8);
      }
      if (this.jdField_g_of_type_AndroidViewView == null)
      {
        if (QLog.isColorLevel()) {
          QZLog.d(this.jdField_b_of_type_JavaLangString, 2, "setInitHeader in updateWpaUiForQidian");
        }
        aq();
      }
      aB();
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
  }
  
  public void aD()
  {
    if (this.Y)
    {
      if (!this.ab) {
        return;
      }
      int i1;
      if ((PublicAccountInfo)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((this.aa) && (i1 == 0))
      {
        AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131698340), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, true);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
        return;
      }
      boolean bool = this.aa;
    }
  }
  
  public void aE()
  {
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.63(this));
  }
  
  public void ao()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      QQProgressDialog localQQProgressDialog = this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
  }
  
  @TargetApi(11)
  void ap()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new PublicAccountChatPie.14(this));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_m_of_type_AndroidViewView);
      this.ad = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    Object localObject = this.jdField_m_of_type_AndroidViewView;
    a((View)localObject, ((View)localObject).getHeight(), 0, new PublicAccountChatPie.15(this));
    this.jdField_g_of_type_AndroidViewView.setTranslationY(0.0F);
    localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_g_of_type_AndroidViewView.getHeight());
    ((TranslateAnimation)localObject).setDuration(500L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setAnimationListener(new PublicAccountChatPie.16(this));
    this.jdField_g_of_type_AndroidViewView.startAnimation((Animation)localObject);
  }
  
  void aq()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
        return;
      }
      aW();
      this.jdField_m_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext()).inflate(2131558568, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
      Object localObject = this.jdField_m_of_type_AndroidViewView;
      if (localObject == null) {
        return;
      }
      if (this.jdField_g_of_type_Int == 2) {
        ((View)localObject).getLayoutParams().height = ((int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131297635));
      } else if (this.X) {
        ((View)localObject).getLayoutParams().height = ((int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131297635));
      }
      if ((!this.X) && (!this.ac))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter();
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_m_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter((ListAdapter)localObject);
      }
      else
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null)
      {
        localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (this.E))
        {
          c((IPublicAccountDetail)localObject);
          this.E = false;
        }
      }
      aX();
    }
  }
  
  void ar()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().b();
  }
  
  void as()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(HardCodeUtil.a(2131708782));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131708778), 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new PublicAccountChatPie.24(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new PublicAccountChatPie.25(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.R = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  void at()
  {
    if (this.ae) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    if (z()) {
      return;
    }
    if (this.I)
    {
      localObject = new TranslateAnimation(0.0F, 0.0F, AIOUtils.b(34.0F, (Resources)localObject), 0.0F);
      ((TranslateAnimation)localObject).setDuration(250L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new PublicAccountChatPie.31(this));
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.startAnimation((Animation)localObject);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366390);
    ((View)localObject).setOnClickListener(new PublicAccountChatPie.32(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_l_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372244);
    bb();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("menuEventSharePre", 0);
    if (!((SharedPreferences)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      ((SharedPreferences.Editor)localObject).commit();
    }
    this.jdField_o_of_type_AndroidWidgetImageView.setOnClickListener(this);
    aZ();
    ba();
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getPublicAccountMenuButtonList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b());
    c((List)localObject);
    d((List)localObject);
  }
  
  public void au()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
    {
      if ((this.jdField_e_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getText().length() < 6))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  void av()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "follow");
    Object localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((IPublicAccountDetail)localObject).getAccountFlag()) != -4)) {
        bl();
      } else {
        bm();
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4);
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "follow exit");
  }
  
  public void aw()
  {
    ThreadManager.post(new PublicAccountChatPie.50(this), 8, null, true);
  }
  
  @TargetApi(11)
  protected void ax()
  {
    ImageView localImageView = this.jdField_l_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      return;
    }
    localImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850216);
      } else {
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850664);
      }
      this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698518));
    }
    else
    {
      if (CustomMenuBar.a()) {
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850215);
      } else {
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850665);
      }
      this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698517));
    }
    if (VersionUtils.e()) {
      this.jdField_l_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    }
  }
  
  void ay()
  {
    aE();
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("qd_wpa_key");
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("qd_kfuin");
      this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("assign_type");
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("assign_key");
      this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("assign_ext");
      this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("rkey");
      this.X = true;
      this.Y = false;
      this.Z = false;
      this.aa = false;
      this.ab = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(str, this.jdField_g_of_type_JavaLangString);
      return;
    }
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQidianQidianManager.b(str);
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))
    {
      this.X = true;
      this.Y = true;
      this.jdField_h_of_type_JavaLangString = null;
      this.jdField_i_of_type_JavaLangString = null;
      this.jdField_j_of_type_JavaLangString = null;
      this.jdField_k_of_type_JavaLangString = null;
      this.Z = true;
      this.aa = false;
      this.ab = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      return;
    }
    this.X = false;
    this.Y = false;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.Z = false;
    this.aa = false;
    this.ab = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  }
  
  protected void az()
  {
    this.X = false;
    this.Y = false;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.Z = false;
    this.aa = false;
    this.ab = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
    this.ac = false;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    ax();
    if (paramInt2 == 8)
    {
      if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
        if (CustomMenuBar.a()) {
          this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130850265);
        } else {
          this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130850187);
        }
      }
    }
    else if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
      if (CustomMenuBar.a()) {
        this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130850264);
      } else {
        this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130850186);
      }
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      SpannableString localSpannableString;
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838033);
        localSpannableString = new SpannableString(HardCodeUtil.a(2131708788));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      if (this.jdField_b_of_type_AndroidTextSpannableString == null)
      {
        localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838333);
        localSpannableString = new SpannableString(HardCodeUtil.a(2131708784));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
      }
      if ((QLog.isColorLevel()) && (this.jdField_n_of_type_AndroidWidgetImageView != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("oldPanel=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" newPanel=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" text.length ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
        ((StringBuilder)localObject).append("mAudioBtn visibility:");
        ((StringBuilder)localObject).append(this.jdField_n_of_type_AndroidWidgetImageView.getVisibility());
        QLog.d("doPanelChanged", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt2 == 2)
      {
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        return;
      }
      Object localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((PatchedButton)localObject).setSelected(bool);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)
      {
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690820);
        return;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).showPubAccUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    paramView = AIOUtils.a(paramView);
    ((WeiShiSubScribeHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(22)).a(paramView);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage) + 1;
    if ((i1 >= 0) && (i1 <= this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1))
    {
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1);
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
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "saveReadedToDB");
    }
    ThreadManager.postImmediately(new PublicAccountChatPie.19(this, paramList), null, false);
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return (localObject != null) && ((((PublicAccountInfo)localObject).accountFlag & 0x40000000) == 1073741824);
    }
    Object localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        return false;
      }
      if ((((IPublicAccountDetail)localObject).getAccountFlag() & 0x40000000) == 1073741824) {
        return true;
      }
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "PublicAccountChatPie";
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramIntent);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new PublicAccountChatPie.36(this));
    bn();
    aE();
    br();
  }
  
  void c(List<mobileqq_mp.ButtonInfo> paramList)
  {
    if (A()) {
      return;
    }
    if (a(paramList)) {
      return;
    }
    if ((paramList != null) && (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      mobileqq_mp.ButtonInfo localButtonInfo = new mobileqq_mp.ButtonInfo();
      localButtonInfo.id.set(0);
      localButtonInfo.name.set(HardCodeUtil.a(2131713713));
      localButtonInfo.event_id.set(1000002);
      localButtonInfo.type.set(3);
      paramList.add(0, localButtonInfo);
    }
    e(paramList);
  }
  
  public void c(boolean paramBoolean)
  {
    try
    {
      if ((C()) && (this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate.a(a());
      }
      label27:
      super.c(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }
  
  protected boolean c()
  {
    PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return (localPublicAccountInfo == null) || ((localPublicAccountInfo.accountFlag & 0x10000000) == 0);
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos is:");
      localStringBuilder.append(i1);
      QLog.d("Q.msg.delmsg", 2, localStringBuilder.toString());
    }
    if (i1 < 0) {
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    int i3 = i1 - i2;
    this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i3);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("horMoveView is null,childIndex is:");
      localStringBuilder.append(i3);
      localStringBuilder.append(",firstPos is:");
      localStringBuilder.append(i2);
      localStringBuilder.append(",pos is:");
      localStringBuilder.append(i1);
      QLog.d("Q.msg.delmsg", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage);
  }
  
  public void d(String paramString)
  {
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountTipsManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)) {
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
          int i1 = paramString.getInt("bid");
          int i2 = paramString.getInt("cid");
          int i3 = paramString.getInt("web");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new PublicAccountChatPie.62(this, bool, (String)localObject1, (String)localObject2, i1, i2, i3));
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
  
  public boolean d()
  {
    try
    {
      if ((C()) && (this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEcshopAioIEcshopChatPieDelegate.a(a());
      }
      label27:
      return super.d();
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_b_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367417));
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131708794));
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366392));
    Object localObject = this.jdField_o_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131373217));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367418));
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (CustomMenuBar.a()) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-1);
    } else {
      p(80);
    }
    this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363032));
    this.jdField_n_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131372878));
    this.jdField_m_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131366114));
    this.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (!CustomMenuBar.a())
    {
      this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130848134);
      this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130837988);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      int i1 = AIOUtils.b(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      if (CustomMenuBar.a())
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130850319);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167208));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, i1, 0, i1);
    }
    if (D()) {
      V();
    }
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131690529));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  public void e(View paramView)
  {
    paramView.getLayoutParams().height = 0;
    paramView.requestLayout();
  }
  
  public int g()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    int i1 = 0;
    localObject1 = ((ChatXListView)localObject1).getChildAt(0);
    Object localObject2 = this.jdField_n_of_type_AndroidViewView;
    if ((localObject2 != null) && (localObject1 != localObject2))
    {
      this.jdField_q_of_type_Int = 0;
      this.jdField_n_of_type_AndroidViewView = ((View)localObject1);
      return 0;
    }
    if (localObject1 != null) {
      i1 = -((View)localObject1).getTop();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ScrollY: ");
      localStringBuilder.append(String.valueOf(i1));
      localStringBuilder.append("  OldScrollY: ");
      localStringBuilder.append(String.valueOf(this.jdField_q_of_type_Int));
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    this.jdField_n_of_type_AndroidViewView = ((View)localObject1);
    return i1;
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    int i1 = paramMessage.what;
    View localView;
    if (i1 != 19)
    {
      if (i1 != 20)
      {
        if (i1 != 1001) {
          switch (i1)
          {
          default: 
            break;
          case 38: 
            this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1000, new Object[0]);
            break;
          case 37: 
            a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
            break;
          case 36: 
            bk();
            break;
          }
        } else {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.c();
        }
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        localView = this.jdField_l_of_type_AndroidViewView;
        if ((localView != null) && (localView.getVisibility() == 0)) {
          this.jdField_l_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
    else
    {
      localView = this.jdField_l_of_type_AndroidViewView;
      if (localView != null)
      {
        localView.setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20, 10000L);
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  protected void j()
  {
    super.j();
    au();
  }
  
  public void k()
  {
    if (this.ak)
    {
      "https://h5.qzone.qq.com/subscription/homepage/{userId}?_proxy=1&_wv=16777217&_wwv=4".replace("{userId}", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      SubscribeLaucher.a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "clk_head", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, "");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.X) {
      localIntent.putExtra("qidian_chat", true);
    }
    AbsStructMsg localAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
    if (localAbsStructMsg != null) {
      localIntent.putExtra("public_account_msg_id", localAbsStructMsg.msgId);
    }
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    }
    if ((((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (((IQQGameSubscribeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQGameSubscribeService.class)).enterSubscribeManagePage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity(), "qqGamePageRouter", "qqGamePageRouter", "subscription/manage"))) {
      return;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfileForResult(localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 1, ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isComeFromReadInJoy());
  }
  
  void l(int paramInt)
  {
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      QQProgressDialog localQQProgressDialog = this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (localQQProgressDialog != null)
      {
        localQQProgressDialog.c(paramInt);
        if (!this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
          this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
      }
    }
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if ("2277373213".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130847570);
        return;
      }
      if (D()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369216).setVisibility(8);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850473, 2130850474);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850473, 2130850474);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getText(2131696425));
    }
  }
  
  public void m(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  public void m(boolean paramBoolean)
  {
    if (D())
    {
      V();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "setPublicAccountMenuBarVisible new qqlive pubaccount return");
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      CustomMenuBar localCustomMenuBar = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
      if (localCustomMenuBar != null) {
        localCustomMenuBar.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().c();
      X();
    }
  }
  
  public void n(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidAppDialog == null)
    {
      this.jdField_c_of_type_AndroidAppDialog = new ReportDialog(a(), 2131756189);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2131560863);
    }
    TextView localTextView1 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131378784);
    TextView localTextView2 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131361945);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          localTextView1.setText(2131698341);
          localTextView2.setText(2131698339);
        }
      }
      else
      {
        localTextView1.setText(2131698338);
        localTextView2.setText(2131698339);
      }
    }
    else
    {
      localTextView1.setText(2131698337);
      localTextView2.setText(2131698343);
    }
    this.jdField_c_of_type_AndroidAppDialog.setOnCancelListener(new PublicAccountChatPie.59(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  protected void n(boolean paramBoolean)
  {
    Object localObject = this.jdField_n_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).clearAnimation();
    localObject = this.jdField_n_of_type_AndroidWidgetImageView;
    int i2 = 8;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((ImageView)localObject).setVisibility(i1);
    localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    int i1 = i2;
    if (!paramBoolean) {
      i1 = 0;
    }
    ((XEditTextEx)localObject).setVisibility(i1);
    if (this.jdField_e_of_type_Boolean)
    {
      localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramBoolean) {
        i1 = 4;
      } else {
        i1 = 0;
      }
      ((PatchedButton)localObject).setVisibility(i1);
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838033);
        SpannableString localSpannableString = new SpannableString(HardCodeUtil.a(2131708761));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    }
  }
  
  protected boolean n()
  {
    if ((!this.T) && (this.J))
    {
      this.T = true;
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1);
      return true;
    }
    if ((!this.U) && (this.J))
    {
      this.U = true;
      return false;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131372878: 
      bg();
      break;
    case 2131371574: 
      N();
      break;
    case 2131369216: 
      bd();
      break;
    case 2131369211: 
      if (!a(paramView)) {
        break;
      }
      break;
    case 2131369202: 
    case 2131369563: 
    case 2131369985: 
    case 2131379476: 
      be();
      break;
    case 2131367417: 
      bi();
      break;
    case 2131366392: 
      m(true);
      break;
    case 2131366114: 
      bh();
      break;
    case 2131363032: 
      bf();
    }
    if (!b(paramView)) {
      super.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    ((WeiShiSubScribeHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(22)).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    b(paramAbsListView);
    if (y()) {
      return;
    }
    int i1 = this.s;
    if (i1 > paramInt3) {
      this.jdField_j_of_type_Int = 4;
    } else if (i1 < paramInt3) {
      this.jdField_j_of_type_Int = 3;
    }
    this.s = paramInt3;
    c(paramInt2, paramInt3);
    if ((!this.ad) && (!this.H)) {
      return;
    }
    if ((this.Q) && (!this.H))
    {
      this.Q = false;
      return;
    }
    if (this.jdField_g_of_type_AndroidViewView.getHeight() != 0) {
      this.r = this.jdField_g_of_type_AndroidViewView.getHeight();
    }
    i1 = this.jdField_q_of_type_Int - g();
    this.jdField_q_of_type_Int = g();
    if (this.x * i1 < 0)
    {
      this.x = i1;
      return;
    }
    this.x = i1;
    if (QLog.isColorLevel())
    {
      paramAbsListView = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Move = ");
      localStringBuilder.append(String.valueOf(i1));
      QLog.d(paramAbsListView, 2, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2, paramInt3, i1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(37);
      NowVideoController.a().a(500L);
    }
    ((WeiShiSubScribeHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(22)).a(paramAbsListView, paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.P = true;
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void p()
  {
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportInQQNews(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Long, this.M, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a());
    if (x()) {
      return;
    }
    super.p();
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager;
    if (localObject1 != null)
    {
      ((IPublicAccountManager)localObject1).clearOldPublicAccountData(b());
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.clearBroadcastReceiver(this.jdField_a_of_type_AndroidContentContext);
    }
    aU();
    a();
    bc();
    if (this.jdField_e_of_type_Long != 0L)
    {
      this.jdField_e_of_type_Long = (System.currentTimeMillis() - this.jdField_e_of_type_Long);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.jdField_e_of_type_Long);
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.z);
      ReportController.b((AppRuntime)localObject1, "dc00899", "Pb_account_lifeservice", (String)localObject2, "0X80064D5", "0X80064D5", 0, 0, "", (String)localObject3, localStringBuilder.toString(), "");
      this.jdField_e_of_type_Long = 0L;
      this.t = 0;
    }
    if (this.S) {
      ThreadManager.executeOnSubThread(new PublicAccountChatPie.11(this));
    }
    az();
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setComeFromReadInJoy(false);
    try
    {
      if (EcshopFromUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        GdtNotify.b();
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).removeNotify("com.tencent.gouwu.video");
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).removeNotify("com.tencent.gwh.video");
        ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).removeNotify("com.tencent.qqshop");
      }
      label346:
      bu();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label346;
    }
  }
  
  boolean t()
  {
    Object localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null) {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } else {
      localObject = null;
    }
    if ((localObject == null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).queryAccountDetail(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null))
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).cleanPublicAccountObserver();
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getPublicAccountDetailRequest(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return true;
    }
    return false;
  }
  
  public void u()
  {
    super.u();
    bs();
    long l1 = NetConnInfoCenter.getServerTime() * 1000L;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      int i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C35", "0X8005C35", 0, 1, 0, (String)this.jdField_a_of_type_JavaUtilList.get(i1), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(l1), (String)this.jdField_b_of_type_JavaUtilList.get(i1));
    }
    if (this.J)
    {
      if (this.K)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 0, "new", String.valueOf(l1 - this.jdField_c_of_type_Long), "", "", false);
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 0, "old", String.valueOf(l1 - this.jdField_c_of_type_Long), "", "", false);
    }
  }
  
  boolean u()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).getLastMessage(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1008);
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
            this.jdField_g_of_type_Int = 1;
            return true;
          }
        }
      }
    }
    return false;
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
      this.S = true;
    }
    if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) && (bool)) {
      ((IKanDianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).removeSubscribePushFromSP(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.update(paramObservable, paramObject);
    if ((paramObservable instanceof TroopEntranceBar))
    {
      if ((paramObject instanceof Integer))
      {
        int i1 = ((Integer)paramObject).intValue();
        if (i1 == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b();
        }
        else if (i1 == 1)
        {
          this.ai = true;
        }
      }
      aT();
      return;
    }
    if ((paramObservable instanceof QQMessageFacade)) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null)
      {
        paramObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.TROOP_MANAGER);
        paramObservable = ((QQMessageFacade)paramObservable).a();
        if (paramObservable == null) {
          return;
        }
        paramObservable = paramObject.c(paramObservable.frienduin);
        if (paramObservable == null) {}
      }
    }
    try
    {
      if (paramObservable.associatePubAccount != Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue()) {
        break label313;
      }
      paramObject = android.os.Message.obtain();
      paramObject.what = 9;
      localObject = new Bundle();
      ((Bundle)localObject).putString("troopUin", paramObservable.troopuin);
      paramObject.setData((Bundle)localObject);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
      return;
    }
    catch (NumberFormatException paramObservable)
    {
      label302:
      break label302;
    }
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "exception: sessionInfo curFriendUin is not a long type.");
    label313:
    return;
    if (this.J) {
      ThreadManager.post(new PublicAccountChatPie.49(this), 5, null, false);
    }
  }
  
  public void v()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
      ((EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    super.v();
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    Object localObject1 = (PublicAccountInfo)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {
      switch (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((PublicAccountInfo)localObject1).accountFlag))
      {
      default: 
        break;
      case -4: 
      case -3: 
      case -2: 
        PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.w, 3, System.currentTimeMillis() - this.jdField_g_of_type_Long);
        break;
      case -5: 
        PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.w, 4, System.currentTimeMillis() - this.jdField_g_of_type_Long);
        break;
      case -7: 
      case -6: 
      case -1: 
        PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.w, 2, System.currentTimeMillis() - this.jdField_g_of_type_Long);
      }
    }
    if (C())
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
      localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis() - this.jdField_g_of_type_Long);
      localStringBuilder.append("");
      ((IEcshopReportApi)localObject1).reportEcshopTo644("gouwu.aio.stay", "1", (String)localObject2, localStringBuilder.toString());
      localObject1 = (IEcshopReportApi)QRoute.api(IEcshopReportApi.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(NetConnInfoCenter.getServerTimeMillis());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis() - this.jdField_g_of_type_Long);
      localStringBuilder.append("");
      ((IEcshopReportApi)localObject1).reportEcshopToBeacon("gouwu_aio_stay", "1", (String)localObject2, localStringBuilder.toString());
    }
    OfficialAccountReporter.a.a(b());
  }
  
  public boolean v()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 8);
  }
  
  protected void w()
  {
    super.w();
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(37, 500L);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.c();
    }
    if ((((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(HardCodeUtil.a(2131708735));
    }
    if ((!this.ae) && (this.af))
    {
      this.af = false;
      ThreadManager.postImmediately(new PublicAccountChatPie.5(this), null, true);
    }
    this.jdField_c_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    if (ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      else
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else if ((this.jdField_e_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getText().length() < 6)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    } else {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    EcShopHandler localEcShopHandler = (EcShopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ECSHOP_HANDLER);
    if (ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      long l1 = 0L;
      if (EcShopAssistantManager.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {
        l1 = ((Long)EcShopAssistantManager.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).longValue();
      }
      if ((!TextUtils.isEmpty((String)EcShopAssistantManager.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) && (System.currentTimeMillis() - l1 <= EcShopAssistantManager.jdField_a_of_type_Int))
      {
        if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
        {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130847320);
        }
        else
        {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      else
      {
        EcShopAssistantManager.b.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
        localEcShopHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((C()) && (this.jdField_q_of_type_Boolean)) {
      ((IEcshopRainViewApi)QRoute.api(IEcshopRainViewApi.class)).addRainView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public boolean w()
  {
    CustomMenuBar localCustomMenuBar = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
    return (localCustomMenuBar == null) || (localCustomMenuBar.getVisibility() == 8);
  }
  
  public void y()
  {
    if ((this.ai) && (this.aj)) {
      return;
    }
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    try
    {
      ark.arkNotify("com.tencent.weather", "pubaccountPendantRefresh", "", "json");
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "ark.arkNotify exception:", localUnsatisfiedLinkError);
    }
    super.y();
    if (!this.aj) {
      ThreadManager.post(new PublicAccountChatPie.54(this), 5, null, false);
    }
    this.aj = true;
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "exp", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, "");
    OfficialAccountReporter.a.a();
  }
  
  public void z()
  {
    super.z();
    this.ae = false;
    this.af = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie
 * JD-Core Version:    0.7.0.1
 */