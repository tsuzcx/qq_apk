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
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.assistant.PubAccountTipsManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopObserver;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.ReportInfo;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.ecshopassit.aio.EcshopMinusViewChatPie;
import com.tencent.biz.pubaccount.ecshopassit.aio.EcshopQggChatPie;
import com.tencent.biz.pubaccount.ecshopassit.aio.IEcshopChatPie;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.ReportUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.gdtad.statistics.GdtImpressionPolicy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.WeiShiSubScribeHelper;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.PAMsgListRefresher;
import com.tencent.mobileqq.activity.aio.tips.PubAccountTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager;
import com.tencent.mobileqq.activity.qwallet.utils.ArkPubicEventWrap;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.activity.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
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
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vashealth.SportManager;
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
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.PluginPreloader;
import cooperation.comic.QQComicPreloadManager;
import cooperation.qzone.util.QZLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class PublicAccountChatPie
  extends BaseChatPie
{
  private int A = -1;
  private int B;
  private int C;
  private int D = 0;
  private int E = 0;
  boolean N = false;
  boolean O = false;
  public boolean P = false;
  boolean Q = false;
  boolean R = false;
  boolean S = false;
  public boolean T = false;
  public boolean U = false;
  public boolean V = false;
  boolean W = false;
  boolean X = false;
  boolean Y = false;
  boolean Z = false;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler = new PublicAccountChatPie.1(this);
  protected SpannableString a;
  IPublicAccountManager jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager;
  public PubAccountTipsManager a;
  EcShopObserver jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver = new PublicAccountChatPie.52(this);
  private IEcshopChatPie jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie;
  CustomMenuBar jdField_a_of_type_ComTencentBizUiCustomMenuBar;
  private PublicAccountChatPie.HomeBroadcast jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$HomeBroadcast;
  protected MessageObserver a;
  public PublicAccountHandler a;
  public PublicAccountObserver a;
  private NewPublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = null;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  PublicAccountInfo jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  public PreloadProcHitSession a;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  public TroopEntranceBar a;
  PublicMenuBar jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = null;
  QidianManager jdField_a_of_type_ComTencentQidianQidianManager;
  public QidianBusinessObserver a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new PublicAccountChatPie.56(this);
  private NewIntent jdField_a_of_type_MqqAppNewIntent;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new PublicAccountChatPie.3(this);
  public int[] a;
  boolean aa = false;
  boolean ab = false;
  public boolean ac = false;
  boolean ad = false;
  boolean ae = false;
  public boolean af;
  public boolean ag;
  boolean ah = false;
  boolean ai = false;
  boolean aj = false;
  boolean ak = false;
  boolean al = false;
  public boolean am = false;
  private boolean an = false;
  private boolean ao = false;
  private boolean ap = false;
  private boolean aq = false;
  private boolean ar = false;
  private boolean as = false;
  private boolean at = false;
  private boolean au = false;
  private boolean av = false;
  private boolean aw;
  private boolean ax = false;
  private boolean ay;
  long jdField_b_of_type_Long = -1L;
  protected SpannableString b;
  public View.OnClickListener b;
  protected LinearLayout b;
  private NewPublicAccountObserver jdField_b_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private PublicMenuBar jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar;
  protected PatchedButton b;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_b_of_type_MqqAppNewIntent = null;
  private BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver;
  long jdField_c_of_type_Long = -1L;
  Dialog jdField_c_of_type_AndroidAppDialog;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  List<String> jdField_c_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private NewIntent jdField_c_of_type_MqqAppNewIntent = null;
  long jdField_d_of_type_Long = -1L;
  private Dialog jdField_d_of_type_AndroidAppDialog = null;
  QQProgressDialog jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  long e;
  private long f;
  public String f;
  private long g;
  public String g;
  private long jdField_h_of_type_Long = 0L;
  String jdField_h_of_type_JavaLangString;
  private long jdField_i_of_type_Long;
  String jdField_i_of_type_JavaLangString;
  String j;
  public int k;
  String k;
  public int l;
  protected ImageView l;
  String l;
  int jdField_m_of_type_Int = 0;
  View jdField_m_of_type_AndroidViewView = null;
  protected ImageView m;
  String jdField_m_of_type_JavaLangString;
  int jdField_n_of_type_Int = 3;
  public View n;
  public ImageView n;
  private String jdField_n_of_type_JavaLangString = "bottom";
  protected int o;
  View jdField_o_of_type_AndroidViewView;
  private ImageView jdField_o_of_type_AndroidWidgetImageView;
  private String jdField_o_of_type_JavaLangString = "";
  protected int p;
  View p;
  public int q;
  View q;
  public int r;
  private View r;
  public int s;
  private View s;
  public int t;
  private View t;
  private int u;
  private int v;
  private int w = 0;
  private int x = 0;
  private int y;
  private int z = -1;
  
  public PublicAccountChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_s_of_type_AndroidViewView = null;
    this.jdField_k_of_type_Int = 0;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_l_of_type_Int = -1;
    this.jdField_o_of_type_Int = 2130838073;
    this.jdField_p_of_type_Int = 2130838072;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_n_of_type_AndroidViewView = null;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_q_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_t_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("web_public_account", "com.tencent.mobileqq:tool");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new PublicAccountChatPie.11(this);
    this.jdField_t_of_type_AndroidViewView = null;
    this.jdField_B_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new PublicAccountChatPie.51(this);
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new PublicAccountChatPie.58(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new PublicAccountChatPie.61(this);
  }
  
  private boolean J()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(null);
    }
    if (this.I)
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
      if (this.jdField_c_of_type_MqqAppNewIntent != null) {
        this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver != null)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
        this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = null;
      }
      return false;
    }
    catch (Exception localException)
    {
      break label73;
    }
  }
  
  private boolean K()
  {
    if ((this.ah) || (this.am)) {}
    while ((this.jdField_m_of_type_AndroidViewView == null) || (this.jdField_s_of_type_AndroidViewView == null) || (this.jdField_n_of_type_Int == 5)) {
      return true;
    }
    return false;
  }
  
  private boolean L()
  {
    this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366512));
    if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
      this.jdField_o_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131696414));
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_ComTencentMobileqqWidgetPublicMenuBar);
    }
    if (this.jdField_m_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_m_of_type_AndroidViewView);
      this.jdField_m_of_type_AndroidViewView = null;
    }
    if (this.jdField_s_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_s_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366511));
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131558672, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366511));
    }
    while (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null)
    {
      return true;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getPublicAccountMenuType(b()));
    if (CustomMenuBar.a())
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167183));
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(AIOUtils.a(48.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      Object localObject1 = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getLayoutParams();
      if ((localObject2 != null) && (localObject1 != null) && ((localObject2 instanceof RelativeLayout.LayoutParams)) && ((localObject1 instanceof RelativeLayout.LayoutParams)))
      {
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        int[] arrayOfInt = ((RelativeLayout.LayoutParams)localObject2).getRules();
        if ((arrayOfInt.length > 2) && (arrayOfInt[2] == 2131369142))
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131366511);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = (RelativeLayout.LayoutParams)localObject1;
          ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131369142);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    return false;
  }
  
  private boolean M()
  {
    if ((N()) && (QQGameConfigUtil.b())) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updatePublicAccountMenu new qqgame pubaccount return");
    }
    do
    {
      return true;
      if ((O()) && ((!this.ao) || (this.an)))
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updatePublicAccountMenu new qqshop pubaccount return");
        return true;
      }
      if (P())
      {
        au();
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updatePublicAccountMenu new qqlive pubaccount return");
        return true;
      }
    } while (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null);
    return false;
  }
  
  private boolean N()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ("2747277822".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private boolean O()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private boolean P()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ("1816533856".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (this.jdField_m_of_type_Int)
    {
    default: 
      return;
    case 0: 
      e(paramInt1, paramInt4);
      return;
    }
    b(paramInt1, paramInt2, paramInt3, paramInt4);
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
    localValueAnimator.addUpdateListener(new PublicAccountChatPie.12(this, paramView, paramInt1, paramInt2));
    localValueAnimator.addListener(paramAnimatorListener);
    localValueAnimator.setDuration(500L).start();
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localSharedPreferences.getBoolean("firstIntoAIO", true))
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(Color.parseColor("#B3000000"));
      localLinearLayout.setVisibility(0);
      localLinearLayout.setClickable(true);
      localLinearLayout.setOnClickListener(new PublicAccountChatPie.50(this, paramRelativeLayout, localLinearLayout));
      Object localObject = new ImageView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((ImageView)localObject).setImageResource(2130841821);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      Resources localResources = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
      localLayoutParams.width = AIOUtils.a(73.0F, localResources);
      localLayoutParams.height = AIOUtils.a(73.0F, localResources);
      localLayoutParams.topMargin = AIOUtils.a(100.0F, localResources);
      localLayoutParams.gravity = 17;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((TextView)localObject).setText(HardCodeUtil.a(2131708783));
      ((TextView)localObject).setTextSize(2, 18.0F);
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localLayoutParams.topMargin = AIOUtils.a(28.0F, localResources);
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      localLinearLayout.addView((View)localObject);
      paramRelativeLayout.addView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
      localSharedPreferences.edit().putBoolean("firstIntoAIO", false).commit();
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountChatPie.29(this, paramAccountDetail), 10L);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    try
    {
      GdtC2SReporter.a(1, 2, EcShopAssistantManager.a(paramMessageForArkApp));
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
        label145:
        do
        {
          for (;;)
          {
            if (!paramMessageForStructing.hasNext()) {
              break label168;
            }
            Object localObject = (AbsStructMsgElement)paramMessageForStructing.next();
            if (!(localObject instanceof StructMsgItemLayout5)) {
              break label145;
            }
            localObject = ((StructMsgItemLayout5)localObject).a;
            if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
            {
              localObject = ((ArrayList)localObject).iterator();
              if (((Iterator)localObject).hasNext())
              {
                AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
                if (!(localAbsStructMsgElement instanceof StructMsgItemVideo)) {
                  break;
                }
                try
                {
                  GdtC2SReporter.a(1, 2, EcShopAssistantManager.a(localAbsStructMsgElement));
                }
                catch (Throwable localThrowable)
                {
                  QLog.e(this.jdField_b_of_type_JavaLangString, 1, localThrowable, new Object[0]);
                }
              }
            }
          }
        } while ((!(localThrowable instanceof StructMsgItemLayout6)) && (!(localThrowable instanceof StructMsgItemLayoutPromotion)));
      }
    }
    try
    {
      GdtC2SReporter.a(1, 2, EcShopAssistantManager.a(localThrowable));
      label168:
      return;
    }
    catch (Throwable paramMessageForStructing)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, paramMessageForStructing, new Object[0]);
    }
  }
  
  private void a(String paramString, int paramInt, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("need_report", false))
    {
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_6", "msg_push");
      long l1 = paramIntent.getLongExtra("incoming_msguid", 0L);
      long l2 = paramIntent.getLongExtra("incoming_shmsgseq", 0L);
      if (l1 > 0L) {
        ThreadManager.post(new PublicAccountChatPie.36(this, paramString, paramInt, l1, l2), 5, null, true);
      }
    }
    if (paramIntent.hasExtra("need_report")) {
      paramIntent.removeExtra("need_report");
    }
  }
  
  private void a(List<ChatMessage> paramList, List<Long> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList2 == null) || (paramList3 == null) || (paramList4 == null) || (paramChatMessage == null)) {}
    label366:
    do
    {
      for (;;)
      {
        return;
        try
        {
          if ((!paramChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("")) && (!paramChatMessage.getExtInfoFromExtStr("pa_msgHasRead").equals("true")))
          {
            paramList.add(paramChatMessage);
            str2 = paramChatMessage.getExtInfoFromExtStr("pa_msgId");
            str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = "0";
            }
            long l1 = Long.parseLong(str1);
            if (paramChatMessage.getExtInfoFromExtStr("pa_should_report").equals("true"))
            {
              paramList1.add(Long.valueOf(l1));
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Report message at index: " + String.valueOf(paramInt) + ". MessageId is " + l1);
              }
            }
            paramChatMessage.saveExtInfoToExtStr("pa_msgHasRead", "true");
            str1 = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
            paramList1 = str1;
            if (str1 == null) {
              paramList1 = "";
            }
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80057C4", "0X80057C4", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(l1), paramList1, "", false);
          }
          if (paramChatMessage.getExtInfoFromExtStr("ad_msgHasRead").equals("false"))
          {
            paramChatMessage.saveExtInfoToExtStr("ad_msgHasRead", "true");
            str2 = paramChatMessage.getExtInfoFromExtStr("pa_msgId");
            str3 = paramChatMessage.getExtInfoFromExtStr("gdt_msgClick");
            str1 = "0";
            str4 = paramChatMessage.getExtInfoFromExtStr("gdt_view_id");
          }
        }
        catch (Exception paramList)
        {
          String str2;
          String str3;
          String str4;
          JSONObject localJSONObject;
          paramList.printStackTrace();
          return;
        }
      }
      try
      {
        localJSONObject = new JSONObject(str3);
        paramList1 = str1;
        if (localJSONObject.has("ad_id")) {
          paramList1 = localJSONObject.getString("ad_id");
        }
      }
      catch (Exception paramList1)
      {
        paramList1 = str1;
        if (!QLog.isColorLevel()) {
          break label366;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " parse ad_id error");
        paramList1 = str1;
        break label366;
      }
      paramList2.add(str2);
      this.jdField_c_of_type_JavaUtilList.add(paramList1);
      paramList3.add(str3);
      paramList4.add(str4);
    } while (paramList.contains(paramChatMessage));
    paramList.add(paramChatMessage);
  }
  
  private boolean a(Intent paramIntent, String paramString)
  {
    if ((paramString != null) && (paramString.equals("starShortcut")))
    {
      ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).handleUrlEvent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("starhomeurl"), paramIntent.getStringExtra("uin"), paramString);
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView)
  {
    boolean bool = false;
    paramView = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    String str;
    if (ServiceAccountFolderManager.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      str = (String)EcShopAssistantManager.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(str)) {
        bool = true;
      }
    }
    else
    {
      return bool;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtra("uin", str);
    localIntent = AIOUtils.a(localIntent, null);
    if (paramView.b(str)) {
      localIntent.putExtra("uintype", 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Shop_customservice", "Clk_shopcustomservice", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return false;
      localIntent.putExtra("uintype", 1005);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + HardCodeUtil.a(2131708764));
      localIntent.putExtra("key_sub_title_from", "来自\"QQ咨询\"");
    }
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_JavaLangString != null) && ("3046055438".equals(paramSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null) {}
    for (localObject = ((PublicAccountDataManager)localObject).b(paramString);; localObject = null)
    {
      if (localObject == null)
      {
        paramQQAppInterface = paramQQAppInterface.getMessageFacade();
        if (paramQQAppInterface != null)
        {
          paramString = paramQQAppInterface.a(paramString, 1008);
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
  }
  
  private boolean a(List<mobileqq_mp.ButtonInfo> paramList)
  {
    boolean bool = false;
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMenuType(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getPublicAccountMenuType(b()));
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      }
      if (this.jdField_g_of_type_AndroidViewView != null) {
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_h_of_type_AndroidViewView != null) {
        this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
        this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      bool = true;
    }
    while (this.jdField_o_of_type_AndroidWidgetImageView == null) {
      return bool;
    }
    this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(0);
    return false;
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 0)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", false);
      Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
          }
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(localObject);
        }
      }
      for (;;)
      {
        this.N = true;
        this.S = true;
        bj();
        if (this.ah)
        {
          localObject = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
          if (localObject != null) {
            ((PlusPanel)localObject).a();
          }
        }
        return paramBoolean;
        E();
        paramBoolean = false;
        continue;
        E();
        paramBoolean = false;
      }
    }
    if (paramInt == 58)
    {
      w(2131695218);
      return paramBoolean;
    }
    if (paramInt == 65)
    {
      w(2131695193);
      return paramBoolean;
    }
    w(2131695222);
    return paramBoolean;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((paramInt4 < -5) && (this.Z)) || (((this.R) || ((paramInt1 + paramInt2 == paramInt3) && (paramInt4 < 0) && (this.Z))) && (!this.Q)))
    {
      this.Q = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.jdField_v_of_type_Int, 0.0F);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setAnimationListener(new PublicAccountChatPie.16(this));
      this.jdField_m_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
  }
  
  private void b(android.os.Message paramMessage)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {}
    while (paramMessage.arg2 != 1) {
      return;
    }
    int i1 = paramMessage.arg1;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, String.format(HardCodeUtil.a(2131708738), new Object[] { (String)paramMessage.obj }), HardCodeUtil.a(2131708752), HardCodeUtil.a(2131708748), new PublicAccountChatPie.2(this, i1), null);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void b(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.remove(paramAccountDetail);
    localEntityManager.close();
  }
  
  private void b(MessageForStructing paramMessageForStructing)
  {
    int i1 = 0;
    if (paramMessageForStructing.structingMsg == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramMessageForStructing.structingMsg;
      this.jdField_o_of_type_JavaLangString = paramMessageForStructing.getExtInfoFromExtStr("msg_template_id");
      this.jdField_k_of_type_Int = paramMessageForStructing.structingMsg.mPromotionType;
      this.jdField_f_of_type_JavaLangString = paramMessageForStructing.structingMsg.mPromotionMsg;
      this.jdField_g_of_type_JavaLangString = paramMessageForStructing.structingMsg.mPromotionMenus;
      this.jdField_l_of_type_Int = paramMessageForStructing.structingMsg.mPromotionMenuDestructiveIndex;
      try
      {
        if (this.jdField_g_of_type_JavaLangString == null) {
          continue;
        }
        this.ax = false;
        paramMessageForStructing = this.jdField_g_of_type_JavaLangString.split(",");
        if (paramMessageForStructing == null) {
          continue;
        }
        int i2 = paramMessageForStructing.length;
        this.jdField_a_of_type_ArrayOfInt = new int[i2];
        while (i1 < i2)
        {
          paramMessageForStructing[i1] = paramMessageForStructing[i1].trim();
          this.jdField_a_of_type_ArrayOfInt[i1] = Integer.parseInt(paramMessageForStructing[i1]);
          i1 += 1;
        }
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        this.ax = true;
      }
    }
  }
  
  private void b(AbsListView paramAbsListView)
  {
    try
    {
      if (EcshopAdHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramView.getTag() instanceof String))
    {
      bool1 = bool2;
      if (PubAccountTipsManager.jdField_a_of_type_JavaLangString.equals(paramView.getTag()))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            if (System.currentTimeMillis() - this.jdField_e_of_type_Long >= 1000L) {
              break label72;
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
    label72:
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    paramView = new StringBuilder("https://gouwu.qq.com/m/html/shop_map.html?_wv=1027&shop_uin=");
    paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.toString());
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("webStyle", "noBottomBar");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconClk", "Clk_shopnearbyicon", 0, 0, "", "", "", "");
    return false;
  }
  
  private void bA()
  {
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131698460, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
  }
  
  private void bB()
  {
    if ((N()) && (QQGameConfigUtil.b())) {}
    do
    {
      do
      {
        return;
      } while (O());
      bl();
      bk();
      if (QLog.isColorLevel()) {
        QZLog.d(this.jdField_b_of_type_JavaLangString, 2, "setInitHeader in INIT_PUBLICACCOUNT_COVER_MENU");
      }
    } while (this.jdField_k_of_type_Int == 1);
    this.jdField_n_of_type_Int = 5;
  }
  
  private void bC()
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getPublicAccountMenuButtonList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b());
    c(localList);
    if ((localList != null) && (!localList.isEmpty()))
    {
      if ((!N()) || (!QQGameConfigUtil.b())) {
        t(true);
      }
      if (!O()) {
        t(true);
      }
    }
  }
  
  private void bD()
  {
    if (this.ah) {
      if (this.ai) {}
    }
    while (((O()) && ((!this.ao) || (this.an)) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie != null) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout))) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      do
      {
        return;
      } while (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null);
    }
    try
    {
      bn();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bE()
  {
    if (this.X) {}
    EcshopReportHandler localEcshopReportHandler;
    do
    {
      return;
      this.X = true;
      localEcshopReportHandler = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()) || (localEcshopReportHandler == null));
    Object localObject1 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
    Object localObject2 = ((ChatMessage)localObject1).getExtInfoFromExtStr("public_account_msg_id");
    String str = ((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg");
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "enter qqgouwu aio msgId = " + (String)localObject2 + " hasAdver: " + str);
    }
    if ("1".equals(str))
    {
      localObject2 = new EcshopAdHandler.ReportInfo();
      ((EcshopAdHandler.ReportInfo)localObject2).jdField_a_of_type_Int = 2;
      localObject2 = EcshopAdHandler.a((EcshopAdHandler.ReportInfo)localObject2, (MessageRecord)localObject1);
      ((EcshopAdHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a((EcshopAdHandler.ReportInfo)localObject2, null);
      if ((localObject1 instanceof MessageForStructing)) {
        a((MessageForStructing)localObject1);
      }
    }
    for (;;)
    {
      int i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("jump_from", 4);
      if (i1 != 2) {
        break;
      }
      localEcshopReportHandler.a(134243865, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, null, null, i1, false);
      return;
      if ((localObject1 instanceof MessageForArkApp))
      {
        a((MessageForArkApp)localObject1);
        continue;
        if ((localObject1 instanceof MessageForArkApp)) {
          localEcshopReportHandler.a(134243863, ((ChatMessage)localObject1).senderuin, (String)localObject2, null, null, 0L, false);
        } else {
          localEcshopReportHandler.a(134243857, ((ChatMessage)localObject1).senderuin, (String)localObject2, null, null, 0L, false);
        }
      }
    }
  }
  
  private void bF()
  {
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localPublicAccountInfo != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(localPublicAccountInfo.accountFlag) == -2))
    {
      this.at = true;
      bl();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.f();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b <= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
        return;
      }
      int i2 = ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (i2 == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
        return;
      }
      int i1;
      if ((i2 & 0xF) == 0)
      {
        i1 = 1;
        if (i2 >> 4 != 1) {
          break label191;
        }
        i2 = 1;
        label168:
        if ((i1 == 0) || (i2 == 0)) {
          break label196;
        }
        this.au = true;
      }
      for (;;)
      {
        bN();
        return;
        i1 = 0;
        break;
        label191:
        i2 = 0;
        break label168;
        label196:
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.e();
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b();
      }
    }
    bN();
  }
  
  private void bG()
  {
    if ((NetworkUtil.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()) == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals("2632129500"))) {
      HtmlOffline.b("108", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, new PublicAccountChatPie.6(this));
    }
  }
  
  private void bH()
  {
    if ("3105932915".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      QQComicPreloadManager localQQComicPreloadManager = (QQComicPreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQCOMIC_PRELOAD_MANAGER);
      if (localQQComicPreloadManager != null) {
        PluginPreloader.a(localQQComicPreloadManager.a(5));
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "the public account is boodo comic");
      }
      ArkPubicEventWrap.a().a("com.tencent.qqcomic.care");
      ArkPubicEventWrap.a().a("com.tencent.carecomic.normal");
      ArkPubicEventWrap.a().a("com.tencent.carecomic.update");
    }
  }
  
  private void bI()
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
  
  private void bJ()
  {
    if (this.T) {
      if (this.U) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "new", "", "", false);
      }
    }
    for (;;)
    {
      ReadinjoySPEventReport.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.P = true;
      }
      return;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "old", "", "", false);
      continue;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005A22", "0X8005A22", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", false);
      if ("2290230341".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E2", "0X80090E2", 0, 0, "", "", "", "");
        QZoneReport.a(2);
      }
    }
  }
  
  private void bK()
  {
    if ((N()) && (this.y > 0)) {
      ThreadManagerV2.excute(new PublicAccountChatPie.7(this), 16, null, false);
    }
  }
  
  private void bL()
  {
    if (PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      WeatherDCReportHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_page_arrive");
    }
  }
  
  private void bM()
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    }
    au();
    aw();
  }
  
  private void bN()
  {
    ThreadManager.postImmediately(new PublicAccountChatPie.9(this), null, true);
  }
  
  private void bO()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ChatMessage)localIterator.next();
      if (MessageForStructing.class.isInstance(localObject))
      {
        localObject = ((MessageForStructing)localObject).structingMsg;
        if (StructMsgForGeneralShare.class.isInstance(localObject)) {
          ((StructMsgForGeneralShare)localObject).unInitPay();
        }
      }
    }
    if ((this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if ((this.jdField_d_of_type_AndroidAppDialog != null) && (this.jdField_d_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_d_of_type_AndroidAppDialog.dismiss();
      this.jdField_d_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.d();
    }
  }
  
  private void bP()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null) {
      K();
    }
  }
  
  private void bQ()
  {
    this.jdField_m_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext()).inflate(2131558671, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    if (this.jdField_m_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_m_of_type_AndroidViewView.setClickable(true);
    this.jdField_m_of_type_AndroidViewView.findViewById(2131368603).setOnClickListener(new PublicAccountChatPie.19(this));
    if (this.jdField_k_of_type_Int == 2)
    {
      this.jdField_m_of_type_AndroidViewView.findViewById(2131373641).setVisibility(8);
      this.jdField_m_of_type_AndroidViewView.findViewById(2131373627).setVisibility(8);
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_m_of_type_AndroidViewView, localLayoutParams);
      return;
      if (this.ah)
      {
        this.jdField_m_of_type_AndroidViewView.findViewById(2131373641).setVisibility(8);
        this.jdField_m_of_type_AndroidViewView.findViewById(2131373627).setVisibility(8);
      }
    }
  }
  
  private void bR()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar = ((PublicMenuBar)this.jdField_m_of_type_AndroidViewView.findViewById(2131373624));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setOnMenuItemClickListener(new PublicAccountChatPie.20(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.b();
    Object localObject;
    int i1;
    MenuItem localMenuItem1;
    if (!this.ah)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      if (this.au)
      {
        i1 = 2131691891;
        localObject = new MenuItem("DO_NOT_FOLLOW", ((FragmentActivity)localObject).getString(i1), a().getResources().getDrawable(2130841922), 0);
        localMenuItem1 = new MenuItem("DO_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691889), a().getResources().getDrawable(2130841814), 1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((MenuItem)localObject, 2131560112);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem1, 2131560112);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setSwitchButtonVisibility(false);
      if (!this.aw) {
        break label338;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(8);
      return;
      i1 = 2131691890;
      break;
      localObject = new MenuItem("DO_CANCEL", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690803), a().getResources().getDrawable(2130841922), 0);
      localMenuItem1 = new MenuItem("DO_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691889), a().getResources().getDrawable(2130841814), 1);
      MenuItem localMenuItem2 = new MenuItem("DO_NOT_FOLLOW", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691891), a().getResources().getDrawable(2130841922), 0);
      this.jdField_p_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a((MenuItem)localObject, 2131560112);
      this.jdField_o_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem2, 2131560112);
      this.jdField_q_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.a(localMenuItem1, 2131560112);
    }
    label338:
    this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar.setVisibility(0);
  }
  
  private void bS()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str);; localObject = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("op", "0");
      localBundle.putString("puin", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject);
      localBundle.putString("Referer", "https://buluo.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new HttpWebCgiAsyncTask2("https://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new PublicAccountChatPie.25(this), 1000, null).a(localHashMap);
      bj();
      return;
    }
  }
  
  private void bT()
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new PublicAccountChatPie.32(this));
  }
  
  private void bU()
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new PublicAccountChatPie.33(this));
  }
  
  private void bV()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("public_aio_setting", 0);
    String str = "firstOpen_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (localSharedPreferences.getBoolean(str, false)) {
      return;
    }
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localPublicAccountInfo != null) && ((localPublicAccountInfo.accountFlag & 0x10000) != 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.sendMenuEventequest(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0x9e370001hd", false, 0.0D, 0.0D, null);
    }
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.34(this, localSharedPreferences, str));
  }
  
  private void bW()
  {
    if (this.jdField_g_of_type_Long == 0L) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (localObject != null) {
      localHashMap.put("uin", localObject);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {
      localHashMap.put("puin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    localHashMap.put("menu_click", "" + this.jdField_q_of_type_Int);
    localHashMap.put("menu_to_webview", "" + this.jdField_s_of_type_Int);
    localHashMap.put("article_click", "" + this.jdField_r_of_type_Int);
    localHashMap.put("article_to_webview", "" + this.jdField_t_of_type_Int);
    localHashMap.put("net_type", "" + NetworkCenter.getInstance().getNetType());
    localHashMap.put("unread_count", "" + this.y);
    long l1 = System.currentTimeMillis() - this.jdField_g_of_type_Long;
    if ((this.jdField_t_of_type_Int != 0) || (this.jdField_s_of_type_Int != 0)) {}
    for (boolean bool = true;; bool = false)
    {
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
      this.jdField_g_of_type_Long = 0L;
      this.y = 0;
      this.jdField_s_of_type_Int = 0;
      this.jdField_q_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      this.jdField_t_of_type_Int = 0;
      return;
    }
  }
  
  private void bX()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EFD", "0X8004EFD", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8004F08", "0X8004F08", 0, 0, "", "", "", "");
    PAStartupTracker.a(null, "pubAcc_profile_display", "");
  }
  
  private void bY()
  {
    if (this.aw) {
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "clk_return", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "");
    }
  }
  
  private void bZ()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (this.jdField_n_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(this.jdField_o_of_type_Int);
        this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690016));
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
    } while (this.jdField_n_of_type_AndroidWidgetImageView == null);
    this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(this.jdField_p_of_type_Int);
    this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690015));
  }
  
  private void bz()
  {
    if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
  }
  
  private void c(AccountDetail paramAccountDetail)
  {
    if (this.jdField_m_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject1 = (TextView)this.jdField_m_of_type_AndroidViewView.findViewById(2131380885);
    Object localObject2 = (TextView)this.jdField_m_of_type_AndroidViewView.findViewById(2131380884);
    ImageView localImageView = (ImageView)this.jdField_m_of_type_AndroidViewView.findViewById(2131368603);
    if (this.au) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0);
        ((TextView)localObject1).setText(localTroopInfo.troopname);
        ((TextView)localObject2).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131695199), new Object[] { paramAccountDetail.name }));
        localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localTroopInfo.troopuin));
        localObject1 = "";
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = ((TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          break label318;
        }
        localObject2 = "";
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "exp_temp", 0, 0, (String)localObject1, "" + (String)localObject2, "", "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new PublicAccountChatPie.41(this, localImageView);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      }
      localObject1 = (ImageView)this.jdField_m_of_type_AndroidViewView.findViewById(2131364541);
      if (paramAccountDetail.certifiedGrade != 0) {
        break label375;
      }
      ((ImageView)localObject1).setVisibility(8);
      return;
      label318:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break;
      ((TextView)localObject1).setText(paramAccountDetail.name);
      if (this.jdField_f_of_type_JavaLangString != null) {
        ((TextView)localObject2).setText(this.jdField_f_of_type_JavaLangString);
      }
      localImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().jdField_a_of_type_JavaLangString, (byte)3));
    }
    label375:
    ((ImageView)localObject1).setVisibility(0);
  }
  
  private void ca()
  {
    ShortVideoUtils.loadShortVideoSo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    FastImageHelper localFastImageHelper = (FastImageHelper)a(83);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8)
    {
      if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
        this.jdField_m_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689999));
      }
      localFastImageHelper.b(true);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return;
    }
    localFastImageHelper.b();
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
    if ((this.jdField_n_of_type_AndroidWidgetImageView != null) && (this.jdField_n_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      u(false);
    }
    if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
      this.jdField_m_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689922));
    }
    n(0);
  }
  
  private void cb()
  {
    if (this.jdField_a_of_type_Int != 1)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3) {
        break label85;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
        this.jdField_m_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689999));
      }
      return;
      label85:
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      if ((this.jdField_n_of_type_AndroidWidgetImageView != null) && (this.jdField_n_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        u(false);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
    }
  }
  
  private void cc()
  {
    long l1 = System.currentTimeMillis();
    if ((QLog.isColorLevel()) && (this.jdField_n_of_type_AndroidWidgetImageView != null)) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onClick fun_btn start mInputStat = " + this.jdField_a_of_type_Int + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.jdField_n_of_type_AndroidWidgetImageView.getVisibility() + " currentPanel:" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() + " currenttime:" + System.currentTimeMillis());
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) && (this.jdField_n_of_type_AndroidWidgetImageView != null) && (this.jdField_n_of_type_AndroidWidgetImageView.getVisibility() != 0))
    {
      ao();
      if (PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) && (((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        }
        WeatherDCReportHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_search_push");
      }
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onClick fun_btn end mInputStat = " + this.jdField_a_of_type_Int + "text.length" + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "cast time :" + (l2 - l1));
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800584F", "0X800584F", 0, 0, "", "", "", "", false);
    }
    if (this.T) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C9C", "0X8005C9C", 0, 1, 0, "", "", "", "");
    }
  }
  
  private void cd()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountDataManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      return;
    }
    Object localObject = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
    ((NewIntent)localObject).putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.5.5,3,5105");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      label178:
      ((NewIntent)localObject).putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new PublicAccountChatPie.37(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      break label178;
    }
  }
  
  private void ce()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "ChatActivityConstants.MSG_PUBLICACCOUNT_ACCOUNTDETAIL");
    }
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(((AccountDetail)localObject).name);
        if (this.O)
        {
          c((AccountDetail)localObject);
          this.O = false;
        }
        if (this.jdField_c_of_type_AndroidAppDialog == null) {}
        bo();
      }
    }
    if (this.N)
    {
      this.N = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
      bi();
    }
  }
  
  private void cf()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver = new NewPublicAccountObserver(new PublicAccountChatPie.43(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    PublicAccountStateReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
  }
  
  private void cg()
  {
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).ext.set("4");
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new PublicAccountChatPie.44(this);
    this.jdField_c_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
  }
  
  private void ch()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localPublicAccountDataManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localPublicAccountDataManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      ci();
    }
  }
  
  private void ci()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.requestPermissions(new PublicAccountChatPie.45(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      cj();
      return;
    }
    cj();
  }
  
  private void cj()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicAccountChatPie.46(this, 1, true, true, 0L, false, false, "PublicAccountChatPie"));
  }
  
  private void ck()
  {
    a((RelativeLayout)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getParent());
  }
  
  private void cl()
  {
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(((PublicAccountInfo)localObject).accountFlag2) == -10L))
      {
        this.aw = true;
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
  
  private void cm()
  {
    if (this.jdField_i_of_type_Long == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_i_of_type_Long;
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localPublicAccountInfo != null) {
      RecentPubAccHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPublicAccountInfo.uin + "", l1 - l2, localPublicAccountInfo.name + "");
    }
    this.jdField_i_of_type_Long = 0L;
  }
  
  private void cn()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new PublicAccountChatPie.64(this);
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void co()
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
  
  private void d(int paramInt1, int paramInt2)
  {
    switch (this.jdField_n_of_type_Int)
    {
    default: 
      return;
    case 3: 
      if ((paramInt2 > paramInt1) && (!this.ap))
      {
        this.jdField_v_of_type_Int = this.jdField_s_of_type_AndroidViewView.getLayoutParams().height;
        e(this.jdField_s_of_type_AndroidViewView);
        this.ap = true;
      }
      this.jdField_n_of_type_Int = 2;
      this.aa = true;
      return;
    }
    if ((paramInt2 == paramInt1) && (this.ap))
    {
      if (this.jdField_v_of_type_Int != 0) {
        a(this.jdField_s_of_type_AndroidViewView, this.jdField_v_of_type_Int);
      }
      this.ap = false;
      this.R = true;
    }
    this.jdField_n_of_type_Int = 2;
    this.aa = true;
  }
  
  private void d(List<mobileqq_mp.ButtonInfo> paramList)
  {
    this.jdField_a_of_type_MqqAppNewIntent = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getMenuSetting(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b(), this.jdField_a_of_type_MqqObserverBusinessObserver, false);
    if ((paramList != null) && (!paramList.isEmpty())) {
      t(true);
    }
    this.aq = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager = new PubAccountTipsManager(this.jdField_a_of_type_AndroidContentContext);
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if ((((Intent)localObject).hasExtra("pub_account_type")) && ("type_ecshop_account".equals(((Intent)localObject).getStringExtra("pub_account_type"))))
    {
      localObject = ((Intent)localObject).getStringExtra("ecshop_distance_tip");
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager.a((String)localObject, this);
      this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (View)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_nearbyiconPv", "Pv_shopnearbyicon", 0, 0, "", "", "", "");
    }
    if ((N()) && (QQGameConfigUtil.b()))
    {
      au();
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initPublicAccountMenu new qqgame pubaccount return");
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) && (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getVisibility() == 0) && (paramList != null))
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
  
  private void e(int paramInt1, int paramInt2)
  {
    if (((paramInt2 > 5) && (this.Z)) || ((paramInt1 == this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()) && (paramInt2 > 0) && (this.Z) && (!this.Q)))
    {
      this.Q = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_v_of_type_Int);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setAnimationListener(new PublicAccountChatPie.17(this));
      this.jdField_m_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
  }
  
  private void e(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1)) {
      z(80);
    }
    while (!CustomMenuBar.a()) {
      return;
    }
    z(16);
  }
  
  private void e(List<mobileqq_mp.ButtonInfo> paramList)
  {
    int i3 = paramList.size();
    int i1 = 0;
    for (;;)
    {
      if ((i1 >= i3) || (i1 > 2)) {
        return;
      }
      Object localObject2 = (mobileqq_mp.ButtonInfo)paramList.get(i1);
      Object localObject1;
      String str;
      label76:
      label96:
      MenuItem localMenuItem;
      label139:
      label163:
      mobileqq_mp.ButtonInfo localButtonInfo;
      if (((mobileqq_mp.ButtonInfo)localObject2).key.has())
      {
        localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).key.get();
        if (!((mobileqq_mp.ButtonInfo)localObject2).name.has()) {
          break label286;
        }
        str = ((mobileqq_mp.ButtonInfo)localObject2).name.get();
        if (!((mobileqq_mp.ButtonInfo)localObject2).id.has()) {
          break label293;
        }
        i2 = ((mobileqq_mp.ButtonInfo)localObject2).id.get();
        localMenuItem = new MenuItem((String)localObject1, str, null, i2);
        localMenuItem.a((mobileqq_mp.ButtonInfo)localObject2);
        if (!((mobileqq_mp.ButtonInfo)localObject2).sub_button.has()) {
          break label298;
        }
        localObject1 = ((mobileqq_mp.ButtonInfo)localObject2).sub_button.get();
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label323;
        }
        localObject2 = ((List)localObject1).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label323;
        }
        localButtonInfo = (mobileqq_mp.ButtonInfo)((Iterator)localObject2).next();
        if (!localButtonInfo.key.has()) {
          break label304;
        }
        localObject1 = localButtonInfo.key.get();
        label206:
        if (!localButtonInfo.name.has()) {
          break label311;
        }
        str = localButtonInfo.name.get();
        label227:
        if (!localButtonInfo.id.has()) {
          break label318;
        }
      }
      label286:
      label293:
      label298:
      label304:
      label311:
      label318:
      for (int i2 = localButtonInfo.id.get();; i2 = 0)
      {
        localObject1 = new MenuItem((String)localObject1, str, null, i2);
        ((MenuItem)localObject1).a(localButtonInfo);
        localMenuItem.a((MenuItem)localObject1);
        break label163;
        localObject1 = "";
        break;
        str = "";
        break label76;
        i2 = 0;
        break label96;
        localObject1 = null;
        break label139;
        localObject1 = "";
        break label206;
        str = "";
        break label227;
      }
      label323:
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localMenuItem, b());
      i1 += 1;
    }
  }
  
  private void h(Intent paramIntent)
  {
    try
    {
      if (EcshopAdHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        ArkPubicEventWrap.a().a("com.tencent.gouwu.video");
        ArkPubicEventWrap.a().a("com.tencent.gwh.video");
        ArkAppNotifyCenter.registVolumnReceiver();
        if (O())
        {
          if (EcshopConfUtil.b()) {
            ArkPubicEventWrap.a().a("com.tencent.qqshop");
          }
          i(paramIntent);
          return;
        }
        paramIntent = (EcshopAdHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
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
      this.an = paramIntent.getBooleanExtra("jump_minusonescreen_view", false);
      this.ao = paramIntent.getBooleanExtra("req_qgg_hide_tab", false);
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "---isHideTab---" + this.ao);
      if (this.an)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie = new EcshopMinusViewChatPie();
        if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout)) {
          bM();
        }
      }
      else
      {
        paramIntent = new EcshopQggChatPie();
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie = paramIntent;
        if ((!this.ao) && (paramIntent.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout)))
        {
          this.jdField_n_of_type_JavaLangString = paramIntent.jdField_a_of_type_JavaLangString;
          if ("top".equals(this.jdField_n_of_type_JavaLangString))
          {
            View localView = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131377159);
            if (localView != null) {
              localView.setVisibility(8);
            }
          }
          paramIntent.a(this);
          bM();
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new PublicAccountChatPie.8(this));
        }
        paramIntent = (EcshopAdHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
        if (paramIntent != null)
        {
          paramIntent.a(null, null, false, null, 10);
          return;
        }
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, QLog.getStackTraceString(paramIntent));
    }
  }
  
  private void j(String paramString)
  {
    AIOUtils.o = true;
    this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    long l1 = NetConnInfoCenter.getServerTime();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    String str1;
    if ("DO_FOLLOW".equals(paramString)) {
      if (this.au)
      {
        bS();
        str1 = "";
        paramString = str1;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null)
        {
          paramString = str1;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList != null)
          {
            paramString = str1;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0) {
              paramString = ((TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
            }
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_close_temp", 0, 0, paramString, "" + str2, "", "");
        this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.init(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new PublicAccountChatPie.21(this));
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004EF5", "0X8004EF5", 0, 0, Long.toString(l1), "", "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, this.jdField_o_of_type_JavaLangString, false);
      }
      v(2131695271);
      bp();
      return;
      if ("DO_NOT_FOLLOW".equals(paramString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004EF7", "0X8004EF7", 0, 0, Long.toString(l1), "", "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "" + this.jdField_o_of_type_JavaLangString, false);
        }
        if (this.au)
        {
          k(str2);
          str1 = "";
          paramString = str1;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null)
          {
            paramString = str1;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList != null)
            {
              paramString = str1;
              if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.size() > 0) {
                paramString = ((TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.get(0)).troopuin;
              }
            }
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_focus_temp", 0, 0, paramString, "" + str2, "", "");
          return;
        }
        bm();
        return;
      }
    } while (!"DO_CANCEL".equals(paramString));
    v(2131695271);
    this.jdField_b_of_type_MqqAppNewIntent = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, false, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new PublicAccountChatPie.22(this));
  }
  
  private void k(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "unfollow");
    }
    y(2131695269);
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((AccountDetail)localObject).accountFlag) != -4)) {
        break label228;
      }
      localObject = new NewIntent(BaseApplicationImpl.getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
      ((NewIntent)localObject).putExtra("cmd", "unfollow");
      mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
      localUnFollowRequest.uin.set((int)Long.parseLong(paramString));
      ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
      this.jdField_b_of_type_MqqObserverBusinessObserver = new PublicAccountChatPie.26(this, paramString);
      ((NewIntent)localObject).setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
    }
    for (;;)
    {
      this.D += 1;
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).removeLbsUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "unfollow exit");
      }
      return;
      label228:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
      this.jdField_b_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver = new NewPublicAccountObserver(new PublicAccountChatPie.27(this, paramString));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
      PublicAccountStateReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
  }
  
  private void y(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new PublicAccountChatPie.28(this, paramInt), 500L);
  }
  
  private void z(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (localLayoutParams.gravity != paramInt)
      {
        localLayoutParams.gravity = paramInt;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    } while (localLayoutParams.gravity == paramInt);
    localLayoutParams.gravity = paramInt;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if ("2277373213".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130847702);
      }
    }
    else {
      return;
    }
    if (P()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369501).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850547, 2130850548);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131696406));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850547, 2130850548);
    }
  }
  
  boolean E()
  {
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null) {}
    for (localObject = ((PublicAccountDataManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject == null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).queryAccountDetail(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null))
      {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).cleanPublicAccountObserver();
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getPublicAccountDetailRequest(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return true;
      }
      return false;
    }
  }
  
  boolean F()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1008);
      if (localObject != null) {
        if (((com.tencent.imcore.message.Message)localObject).msgtype == -2011)
        {
          localMessageForStructing = new MessageForStructing();
          MessageForStructing.copyMessageRecordBaseField(localMessageForStructing, (MessageRecord)localObject);
          localMessageForStructing.parse();
          if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mPromotionType == 1) || (localMessageForStructing.structingMsg.mPromotionType == 2))) {
            b(localMessageForStructing);
          }
        }
        else
        {
          while ((((com.tencent.imcore.message.Message)localObject).msgtype == -2009) && (((com.tencent.imcore.message.Message)localObject).isSend()))
          {
            MessageForStructing localMessageForStructing;
            return true;
          }
          if ((((com.tencent.imcore.message.Message)localObject).msgtype == -5008) && (!((com.tencent.imcore.message.Message)localObject).isSend()))
          {
            this.jdField_k_of_type_Int = 1;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean G()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 8);
  }
  
  public boolean H()
  {
    return (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar == null) || (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getVisibility() == 8);
  }
  
  public boolean I()
  {
    return this.an;
  }
  
  public void J()
  {
    ReadinjoySPEventReport.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Long, this.W, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a());
    if (J()) {
      return;
    }
    super.J();
    if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.clearOldPublicAccountData(b());
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.clearBroadcastReceiver(this.jdField_a_of_type_AndroidContentContext);
    }
    bO();
    a();
    bW();
    if (this.jdField_f_of_type_Long != 0L)
    {
      this.jdField_f_of_type_Long = (System.currentTimeMillis() - this.jdField_f_of_type_Long);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064D5", "0X80064D5", 0, 0, "", "" + this.jdField_f_of_type_Long, "" + this.E, "");
      this.jdField_f_of_type_Long = 0L;
      this.x = 0;
    }
    if (this.ac) {
      ThreadManager.executeOnSubThread(new PublicAccountChatPie.10(this));
    }
    bt();
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setComeFromReadInJoy(false);
    try
    {
      if (EcshopAdHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        ArkAppNotifyCenter.unRegistVolumnReceiver();
        ArkPubicEventWrap.a().b("com.tencent.gouwu.video");
        ArkPubicEventWrap.a().b("com.tencent.gwh.video");
        ArkPubicEventWrap.a().b("com.tencent.qqshop");
      }
      label287:
      co();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label287;
    }
  }
  
  public void N()
  {
    super.N();
    cm();
    long l1 = NetConnInfoCenter.getServerTime() * 1000L;
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      int i1 = this.jdField_b_of_type_JavaUtilList.size() - 1;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005C35", "0X8005C35", 0, 1, 0, (String)this.jdField_b_of_type_JavaUtilList.get(i1), String.valueOf(this.jdField_b_of_type_Long), String.valueOf(l1), (String)this.jdField_c_of_type_JavaUtilList.get(i1));
    }
    if (this.T)
    {
      if (this.U) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 0, "new", String.valueOf(l1 - this.jdField_d_of_type_Long), "", "", false);
      }
    }
    else {
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D16", "0X8005D16", 0, 0, "old", String.valueOf(l1 - this.jdField_d_of_type_Long), "", "", false);
  }
  
  public void O()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
      ((EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localPublicAccountInfo != null) {
      switch (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(localPublicAccountInfo.accountFlag))
      {
      }
    }
    for (;;)
    {
      if (O())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop", 2, "report stay page time tabid is1");
        }
        ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "gouwu.aio.stay", "1", NetConnInfoCenter.getServerTimeMillis() + "", NetConnInfoCenter.getServerTimeMillis() - this.jdField_h_of_type_Long + "");
        ReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "gouwu_aio_stay", "1", NetConnInfoCenter.getServerTimeMillis() + "", NetConnInfoCenter.getServerTimeMillis() - this.jdField_h_of_type_Long + "");
      }
      OfficialAccountReporter.a.a(b());
      return;
      PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.A, 2, System.currentTimeMillis() - this.jdField_h_of_type_Long);
      continue;
      PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.A, 3, System.currentTimeMillis() - this.jdField_h_of_type_Long);
      continue;
      PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.A, 4, System.currentTimeMillis() - this.jdField_h_of_type_Long);
    }
  }
  
  public void P()
  {
    super.P();
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(37, 500L);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.c();
    }
    if ((PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(HardCodeUtil.a(2131708729));
    }
    if ((!this.aq) && (this.ar))
    {
      this.ar = false;
      ThreadManager.postImmediately(new PublicAccountChatPie.5(this), null, true);
    }
    this.jdField_d_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    if (ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
        EcShopHandler localEcShopHandler = (EcShopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ECSHOP_HANDLER);
        if (ServiceAccountFolderManager.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          long l1 = 0L;
          if (EcShopAssistantManager.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {
            l1 = ((Long)EcShopAssistantManager.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).longValue();
          }
          if ((!TextUtils.isEmpty((String)EcShopAssistantManager.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) && (System.currentTimeMillis() - l1 <= EcShopAssistantManager.jdField_a_of_type_Int)) {
            break label446;
          }
          EcShopAssistantManager.b.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
          localEcShopHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      if (O())
      {
        if ((!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) && ("top".equals(this.jdField_n_of_type_JavaLangString)) && (ImmersiveUtils.isSupporImmersive() == 1))
        {
          a(-1, false);
          ImmersiveUtils.setStatusTextColor(true, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
        }
        if (this.jdField_v_of_type_Boolean) {
          EcShopAssistantManager.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      return;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      if ((this.jdField_e_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getText().length() < 6))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
        break;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label446:
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130847451);
      }
      else
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void R()
  {
    if ((this.au) && (this.av)) {
      return;
    }
    this.jdField_i_of_type_Long = System.currentTimeMillis();
    try
    {
      ark.arkNotify("com.tencent.weather", "pubaccountPendantRefresh", "", "json");
      super.R();
      if (!this.av) {
        ThreadManager.post(new PublicAccountChatPie.53(this), 5, null, false);
      }
      this.av = true;
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "exp", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "");
      OfficialAccountReporter.a.a();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "ark.arkNotify exception:", localUnsatisfiedLinkError);
      }
    }
  }
  
  public void S()
  {
    super.S();
    this.aq = false;
    this.ar = false;
  }
  
  public AIOContext a()
  {
    return new PAContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  public MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new PAListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new PAMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
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
      str1 = "0";
      if (localChatMessage != null)
      {
        localObject = localChatMessage.getExtInfoFromExtStr("gdt_msgClick");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("ad_id")) {
        str1 = ((JSONObject)localObject).getString("ad_id");
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        String str2 = "0";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "old", String.valueOf(l1 - this.jdField_c_of_type_Long), "", "");
    }
    Object localObject = localChatMessage.getExtInfoFromExtStr("pa_msgId");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "" + localChatMessage.frienduin, "0X8005C38", "0X8005C38", 0, 1, 0, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
    if (this.T)
    {
      l1 = NetConnInfoCenter.getServerTime() * 1000L;
      if (this.U) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8005D17", "0X8005D17", 0, 1, 0, "new", String.valueOf(l1 - this.jdField_c_of_type_Long), "", "");
      }
    }
    else
    {
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.ar = true;
  }
  
  void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3, paramInt, 1, paramBusinessObserver);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.ah) {
      bw();
    }
    if (PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.getLayoutParams().height = paramInt;
    paramView.requestLayout();
  }
  
  public void a(com.tencent.imcore.message.Message paramMessage)
  {
    if (paramMessage == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((TroopInfo)localIterator.next()).troopuin.equals(paramMessage.frienduin));
      }
      for (int i1 = 1; (paramMessage.istroop != 1) || (i1 == 0); i1 = 0)
      {
        super.a(paramMessage);
        return;
      }
    }
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
    Object localObject = paramChatMessage.frienduin;
    int i1 = paramChatMessage.istroop;
    if (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, i1))
    {
      RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localObject = localRecentUserProxy.a((String)localObject, i1);
      if (localObject != null) {
        localRecentUserProxy.a((RecentUser)localObject);
      }
    }
    if ((O()) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie.a(paramChatMessage);
    }
  }
  
  void a(PublicAccountInfo paramPublicAccountInfo)
  {
    PublicAccountDataManager localPublicAccountDataManager;
    if (paramPublicAccountInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + paramPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + paramPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + paramPublicAccountInfo.mIsAgreeSyncLbs);
      }
      localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localPublicAccountDataManager == null) {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): pam is null");
        }
      }
    }
    for (;;)
    {
      return;
      if ((paramPublicAccountInfo.isSyncLbs) && (!paramPublicAccountInfo.mIsSyncLbsSelected) && (!paramPublicAccountInfo.mIsAgreeSyncLbs) && (!this.as))
      {
        String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131692144);
        String str2 = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131692142), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
        this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, str1, str2, 2131692141, 2131692143, new PublicAccountChatPie.38(this, paramPublicAccountInfo, localPublicAccountDataManager), new PublicAccountChatPie.39(this, paramPublicAccountInfo, localPublicAccountDataManager));
        this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new PublicAccountChatPie.40(this));
        this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
          this.jdField_c_of_type_AndroidAppDialog.show();
        }
        this.as = true;
      }
      while (QLog.isColorLevel())
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): END");
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  void a(AbsListView paramAbsListView)
  {
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    int i1 = paramAbsListView.getFirstVisiblePosition();
    while (i1 <= paramAbsListView.getLastVisiblePosition())
    {
      a(localArrayList5, localArrayList4, localArrayList1, localArrayList2, localArrayList3, (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1), i1);
      i1 += 1;
    }
    b(localArrayList5);
    if (!localArrayList4.isEmpty()) {}
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.sendMsgArriveReceipt(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, 0L, l1, l2, 2, localArrayList4);
      paramAbsListView = localArrayList5.iterator();
      while (paramAbsListView.hasNext()) {
        if ("1".equals(((ChatMessage)paramAbsListView.next()).getExtInfoFromExtStr("is_AdArrive_Msg")))
        {
          if (this.jdField_b_of_type_Long == -1L) {
            this.jdField_b_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
          }
          this.jdField_b_of_type_JavaUtilList = localArrayList1;
          ((IPAReportUtil)QRoute.api(IPAReportUtil.class)).reportAdMsgRead(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList2, localArrayList1, localArrayList3);
        }
      }
      return;
    }
    catch (Exception paramAbsListView) {}
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    this.ag = true;
    super.a(paramList, paramCharSequence);
    int i1;
    long l1;
    if (this.jdField_v_of_type_Boolean)
    {
      if (paramList.size() <= 0) {
        break label177;
      }
      paramList = (ChatMessage)paramList.get(paramList.size() - 1);
      i1 = paramList.msgtype;
      l1 = paramList.msgseq;
      if (!(paramList instanceof MessageForStructing)) {
        break label174;
      }
      paramList = (MessageForStructing)paramList;
      if (paramList.structingMsg == null) {
        break label174;
      }
      l1 = paramList.structingMsg.msgId;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064D4", "0X80064D4", 0, 0, "", "" + i1, "" + l1, "");
      return;
      label174:
      continue;
      label177:
      l1 = 0L;
      i1 = -1;
    }
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    QLog.i(this.jdField_b_of_type_JavaLangString, 2, "<<<<<<<<<<<<<<list.size<<<<<<<<<" + paramList.size());
    try
    {
      if (O())
      {
        if (this.an)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
          if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie == null) {
            return;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie.a(paramList, new PublicAccountChatPie.54(this, paramCharSequence, paramInt));
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie.a(paramList, new PublicAccountChatPie.55(this, paramCharSequence, paramInt));
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, QLog.getStackTraceString(localThrowable1));
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
      try
      {
        ((QWalletGdtAdManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_GDT_AD_MANAGER)).a(paramList);
        super.a(paramList, paramCharSequence, paramInt);
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, localThrowable2, new Object[0]);
        }
      }
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "qidianWpaClick ... mQidianKefu = " + this.aj);
    }
    v(2131695271);
    Object localObject;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      localObject = (String)paramMap.get("AssignType");
      String str = (String)paramMap.get("AssignID");
      paramMap = (Map<String, String>)localObject;
      localObject = str;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.requestQidiKefu(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMap, (String)localObject, null, new PublicAccountChatPie.60(this));
      return;
      localObject = null;
      paramMap = null;
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (!H()) {
        this.z = 2;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        super.a(paramBoolean1, paramChatMessage, paramBoolean2);
        return;
        if (!G()) {
          this.z = 1;
        } else {
          this.z = 0;
        }
      }
    }
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    switch (this.z)
    {
    }
    for (;;)
    {
      this.z = -1;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null)
        {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
          }
        }
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$HomeBroadcast = new PublicAccountChatPie.HomeBroadcast(this, null);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$HomeBroadcast, (IntentFilter)localObject);
    this.I = false;
    this.jdField_B_of_type_Boolean = false;
    bP();
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class));
    bs();
    super.a(paramBoolean);
    if (this.ah) {
      bu();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) > 0) {
      this.ac = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar = new TroopEntranceBar();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.addObserver(this);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    this.x = ((Intent)localObject).getIntExtra("red_hot_count", 0);
    String str = ((Intent)localObject).getStringExtra("from");
    this.Y = ((Intent)localObject).getBooleanExtra("shouldreport", false);
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    this.jdField_r_of_type_Int = 0;
    this.jdField_t_of_type_Int = 0;
    this.jdField_q_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.y = this.x;
    paramBoolean = ((Intent)localObject).getBooleanExtra("is_come_from_readinjoy", false);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setComeFromReadInJoy(paramBoolean);
    this.A = ((Intent)localObject).getIntExtra("INTENT_KEY_FROM", 1);
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      bF();
      PublicAccountHandler.jdField_a_of_type_JavaLangString = null;
      this.W = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("has_unread_msg", false);
    }
    if (a((Intent)localObject, str)) {
      return true;
    }
    bG();
    bH();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    this.T = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doOnCreate, isMediaAndOtherSubscript = " + this.T);
    }
    this.jdField_c_of_type_Long = (NetConnInfoCenter.getServerTime() * 1000L);
    bI();
    if (this.T)
    {
      ck();
      bq();
      ((PAListUI)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a()).a();
    }
    bJ();
    bK();
    h((Intent)localObject);
    bL();
    cn();
    return true;
  }
  
  public void ae()
  {
    if ((this.at) && (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) > 0)) {
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.ae();
    if (PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      if (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, null);
      }
    }
    for (;;)
    {
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if ((localEcShopAssistantManager != null) && (localEcShopAssistantManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        ThreadManager.post(new PublicAccountChatPie.4(this), 5, null, true);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      NowVideoController.a().a(1000L);
      OfficialAccountReporter.a.a(a());
      return;
      if (("3026775809".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSystemService("sensor")).getDefaultSensor(19) != null)) {
        ((SportManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPORT_MANAGER)).a("public account");
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    super.afterTextChanged(paramEditable);
    e(paramEditable);
    PatchedButton localPatchedButton;
    if (this.jdField_a_of_type_Int == 0)
    {
      if (!this.jdField_g_of_type_Boolean) {
        break label75;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690891);
      localPatchedButton = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() <= 0) {
        break label70;
      }
      bool1 = bool2;
      localPatchedButton.setEnabled(bool1);
    }
    label70:
    label75:
    do
    {
      do
      {
        return;
        bool1 = false;
        break;
      } while ((this.jdField_n_of_type_AndroidWidgetImageView != null) && (this.jdField_n_of_type_AndroidWidgetImageView.getVisibility() == 0));
      localPatchedButton = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() > 0) {
        bool1 = true;
      }
      localPatchedButton.setEnabled(bool1);
    } while (paramEditable.length() <= 0);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690891);
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(true);
  }
  
  public void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (ServiceAccountFolderManager.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
  }
  
  public void aw()
  {
    super.aw();
    if (this.jdField_k_of_type_AndroidViewView != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_k_of_type_AndroidViewView.getLayoutParams();
        if (localLayoutParams != null)
        {
          if (!H())
          {
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getId());
            return;
          }
          if (!G())
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
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).showPubAccUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(View paramView)
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
        e(localChatMessage);
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
    ThreadManager.postImmediately(new PublicAccountChatPie.18(this, paramList), null, false);
  }
  
  void b(boolean paramBoolean, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EF8", "0X8004EF8", 0, 0, Integer.toString(paramInt), "", "", "");
    if (this.jdField_b_of_type_MqqAppNewIntent != null)
    {
      ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccountCancelCallback(this.jdField_b_of_type_MqqAppNewIntent);
      this.jdField_b_of_type_MqqAppNewIntent = null;
    }
    this.jdField_b_of_type_MqqAppNewIntent = ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).refuseFollowAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt, paramBoolean, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new PublicAccountChatPie.42(this));
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        return (((PublicAccountInfo)localObject).accountFlag & 0x40000000) == 1073741824;
      }
      return false;
    }
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        return false;
      }
      return (((AccountDetail)localObject).accountFlag & 0x40000000) == 1073741824;
    }
    return false;
  }
  
  public void bi()
  {
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  @TargetApi(11)
  void bj()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new PublicAccountChatPie.13(this));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_s_of_type_AndroidViewView);
      this.ap = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    a(this.jdField_s_of_type_AndroidViewView, this.jdField_s_of_type_AndroidViewView.getHeight(), 0, new PublicAccountChatPie.14(this));
    this.jdField_m_of_type_AndroidViewView.setTranslationY(0.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_m_of_type_AndroidViewView.getHeight());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new PublicAccountChatPie.15(this));
    this.jdField_m_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  void bk()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {}
    do
    {
      return;
      bQ();
      this.jdField_s_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext()).inflate(2131558670, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    } while (this.jdField_s_of_type_AndroidViewView == null);
    Object localObject;
    if (this.jdField_k_of_type_Int == 2)
    {
      this.jdField_s_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297644));
      if ((!this.ah) && (!this.am)) {
        break label223;
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject != null)
      {
        localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (this.O))
        {
          c((AccountDetail)localObject);
          this.O = false;
        }
      }
      bR();
      return;
      if (!this.ah) {
        break;
      }
      this.jdField_s_of_type_AndroidViewView.getLayoutParams().height = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297644));
      break;
      label223:
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter();
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_s_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter((ListAdapter)localObject);
    }
  }
  
  void bl()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
    if (this.jdField_g_of_type_AndroidViewView != null) {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_h_of_type_AndroidViewView != null) {
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  void bm()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(HardCodeUtil.a(2131708776));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131708772), 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new PublicAccountChatPie.23(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new PublicAccountChatPie.24(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.ab = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  void bn()
  {
    if (this.aq) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
    } while (L());
    if (this.S)
    {
      localObject = new TranslateAnimation(0.0F, 0.0F, AIOUtils.a(34.0F, (Resources)localObject), 0.0F);
      ((TranslateAnimation)localObject).setDuration(250L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new PublicAccountChatPie.30(this));
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.startAnimation((Animation)localObject);
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366510);
    ((View)localObject).setOnClickListener(new PublicAccountChatPie.31(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_r_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372666);
    bV();
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("menuEventSharePre", 0);
    if (!((SharedPreferences)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      ((SharedPreferences.Editor)localObject).commit();
    }
    this.jdField_o_of_type_AndroidWidgetImageView.setOnClickListener(this);
    bT();
    bU();
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getPublicAccountMenuButtonList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b());
    c((List)localObject);
    d((List)localObject);
  }
  
  public void bo()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
    {
      if ((this.jdField_e_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getText().length() < 6)) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void bp()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "follow");
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((AccountDetail)localObject).accountFlag) != -4)) {
        break label110;
      }
      cg();
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 4);
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "follow exit");
      return;
      label110:
      cf();
    }
  }
  
  public void bq()
  {
    ThreadManager.post(new PublicAccountChatPie.49(this), 8, null, true);
  }
  
  @TargetApi(11)
  protected void br()
  {
    if (this.jdField_l_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130844952);
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_l_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!VersionUtils.e());
    this.jdField_l_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_l_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.e()) {
        this.jdField_l_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850289);
        }
        for (;;)
        {
          this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698452));
          return;
          this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850738);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850288);
      }
      for (;;)
      {
        this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698451));
        return;
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850739);
      }
    }
    this.jdField_l_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850289);
      }
      for (;;)
      {
        this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698452));
        label246:
        if (!VersionUtils.e()) {
          break;
        }
        this.jdField_l_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850738);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850288);
    }
    for (;;)
    {
      this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698451));
      break label246;
      break;
      this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850739);
    }
  }
  
  void bs()
  {
    by();
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("qd_wpa_key");
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("qd_kfuin");
      this.j = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_type");
      this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_key");
      this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("assign_ext");
      this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("rkey");
      this.ah = true;
      this.ai = false;
      this.aj = false;
      this.ak = false;
      this.al = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(str, this.jdField_i_of_type_JavaLangString);
      return;
    }
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQidianQidianManager.b(str);
    if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
    {
      this.ah = true;
      this.ai = true;
      this.j = null;
      this.jdField_k_of_type_JavaLangString = null;
      this.jdField_l_of_type_JavaLangString = null;
      this.jdField_m_of_type_JavaLangString = null;
      this.aj = true;
      this.ak = false;
      this.al = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
      return;
    }
    this.ah = false;
    this.ai = false;
    this.j = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.aj = false;
    this.ak = false;
    this.al = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
  }
  
  protected void bt()
  {
    this.ah = false;
    this.ai = false;
    this.j = null;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_l_of_type_JavaLangString = null;
    this.jdField_m_of_type_JavaLangString = null;
    this.aj = false;
    this.ak = false;
    this.al = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
    this.am = false;
  }
  
  public void bu()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "checkQDAccountValid ...");
    }
    ThreadManager.post(new PublicAccountChatPie.57(this), 8, null, false);
  }
  
  public void bv()
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("updateHeader ... ");
      if (this.jdField_m_of_type_AndroidViewView == null) {
        break label71;
      }
    }
    label71:
    for (Object localObject = Integer.valueOf(this.jdField_m_of_type_AndroidViewView.getVisibility());; localObject = "")
    {
      QLog.d(str, 2, localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar != null) && (this.ai)) {
        break;
      }
      return;
    }
    if (this.ak)
    {
      this.jdField_p_of_type_AndroidViewView.setVisibility(0);
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_p_of_type_AndroidViewView.setVisibility(8);
    this.jdField_o_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void bw()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updateWpaUiForQidian: mQidianAccountValid = " + this.ai + ", mQidianKefu = " + this.aj + ", mQidianShield: " + this.ak);
    }
    if (this.ai) {
      if (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
        break label293;
      }
    }
    label293:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
        bn();
        return;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      InputLinearLayout localInputLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
      if (this.ak) {
        i1 = 8;
      }
      for (;;)
      {
        localInputLinearLayout.setVisibility(i1);
        if (this.jdField_o_of_type_AndroidWidgetImageView == null) {
          this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366512));
        }
        this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
        }
        if (this.jdField_m_of_type_AndroidViewView == null)
        {
          if (QLog.isColorLevel()) {
            QZLog.d(this.jdField_b_of_type_JavaLangString, 2, "setInitHeader in updateWpaUiForQidian");
          }
          bk();
        }
        bv();
        return;
        if (this.aj) {
          i1 = 0;
        } else {
          i1 = 8;
        }
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
      return;
    }
  }
  
  public void bx()
  {
    if ((!this.ai) || (!this.al)) {}
    int i1;
    do
    {
      return;
      if (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null) {}
      for (i1 = 1; (this.ak) && (i1 == 0); i1 = 0)
      {
        AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131698275), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, true);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
        return;
      }
    } while ((this.ak) || (i1 != 0));
  }
  
  public void by()
  {
    ThreadManager.executeOnSubThread(new PublicAccountChatPie.63(this));
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "PublicAccountChatPie";
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    br();
    if (paramInt2 == 8) {
      if (this.jdField_m_of_type_AndroidWidgetImageView != null)
      {
        if (!CustomMenuBar.a()) {
          break label295;
        }
        this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130850338);
      }
    }
    for (;;)
    {
      if (!this.jdField_g_of_type_Boolean)
      {
        SpannableString localSpannableString;
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838192);
          localSpannableString = new SpannableString(HardCodeUtil.a(2131708782));
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838485);
          localSpannableString = new SpannableString(HardCodeUtil.a(2131708778));
          localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if ((QLog.isColorLevel()) && (this.jdField_n_of_type_AndroidWidgetImageView != null)) {
          QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "mAudioBtn visibility:" + this.jdField_n_of_type_AndroidWidgetImageView.getVisibility());
        }
        if (paramInt2 != 2) {
          break;
        }
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (paramInt1 != 2) && (AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(false);
        }
      }
      return;
      label295:
      this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130850260);
      continue;
      if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
        if (CustomMenuBar.a()) {
          this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130850337);
        } else {
          this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130850259);
        }
      }
    }
    Object localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((PatchedButton)localObject).setSelected(bool);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
        break;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690891);
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setSelected(false);
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramIntent);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new PublicAccountChatPie.35(this));
    ch();
    by();
    cl();
  }
  
  void c(List<mobileqq_mp.ButtonInfo> paramList)
  {
    if (M()) {}
    while (a(paramList)) {
      return;
    }
    if ((paramList != null) && (PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      mobileqq_mp.ButtonInfo localButtonInfo = new mobileqq_mp.ButtonInfo();
      localButtonInfo.id.set(0);
      localButtonInfo.name.set(HardCodeUtil.a(2131713785));
      localButtonInfo.event_id.set(1000002);
      localButtonInfo.type.set(3);
      paramList.add(0, localButtonInfo);
    }
    e(paramList);
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131690601));
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
  
  public void e(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i1);
    }
    if (i1 < 0) {
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    int i3 = i1 - i2;
    this.jdField_n_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + i3 + ",firstPos is:" + i2 + ",pos is:" + i1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage);
  }
  
  public void e(boolean paramBoolean)
  {
    try
    {
      if ((O()) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie.a(a());
      }
      label27:
      super.e(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }
  
  public boolean e()
  {
    PublicAccountInfo localPublicAccountInfo = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return (localPublicAccountInfo == null) || ((localPublicAccountInfo.accountFlag & 0x10000000) == 0);
  }
  
  public boolean f()
  {
    return false;
  }
  
  public void g()
  {
    super.g();
    this.jdField_b_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367663));
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131708788));
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
    this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366512));
    if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
      this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131373644));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_b_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367664));
    localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (CustomMenuBar.a()) {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-1);
    }
    for (;;)
    {
      this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131363092));
      this.jdField_n_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373298));
      this.jdField_m_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131366225));
      this.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130848264);
        this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130838139);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        int i1 = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        if (CustomMenuBar.a())
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130850392);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167183));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, i1, 0, i1);
      }
      if (P()) {
        au();
      }
      return;
      z(80);
    }
  }
  
  public boolean g()
  {
    try
    {
      if ((O()) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitAioIEcshopChatPie.a(a());
      }
      label27:
      return super.g();
    }
    catch (Throwable localThrowable)
    {
      break label27;
    }
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1000, new Object[0]);
      continue;
      if (this.jdField_r_of_type_AndroidViewView != null)
      {
        this.jdField_r_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20, 10000L);
        continue;
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
        if ((this.jdField_r_of_type_AndroidViewView != null) && (this.jdField_r_of_type_AndroidViewView.getVisibility() == 0))
        {
          this.jdField_r_of_type_AndroidViewView.setVisibility(8);
          continue;
          a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
          continue;
          ce();
          continue;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.c();
        }
      }
    }
  }
  
  public void i(String paramString)
  {
    boolean bool = true;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountTipsManager != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppSchemeCenter", 2, "args:" + paramString);
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.getJSONObject("bidInfo");
      if (((JSONObject)localObject).optInt("isshow", 0) == 1) {}
      for (;;)
      {
        String str = ((JSONObject)localObject).getString("icon");
        localObject = ((JSONObject)localObject).getString("url");
        int i1 = paramString.getInt("bid");
        int i2 = paramString.getInt("cid");
        int i3 = paramString.getInt("web");
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new PublicAccountChatPie.62(this, bool, str, (String)localObject, i1, i2, i3));
        return;
        bool = false;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public int k()
  {
    int i1 = 0;
    View localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if ((this.jdField_t_of_type_AndroidViewView != null) && (localView != this.jdField_t_of_type_AndroidViewView))
    {
      this.u = 0;
      this.jdField_t_of_type_AndroidViewView = localView;
      return 0;
    }
    if (localView != null) {
      i1 = -localView.getTop();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "ScrollY: " + String.valueOf(i1) + "  OldScrollY: " + String.valueOf(this.u));
    }
    this.jdField_t_of_type_AndroidViewView = localView;
    return i1;
  }
  
  public void k()
  {
    PubAccountTips localPubAccountTips = new PubAccountTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localPubAccountTips);
  }
  
  @TargetApi(11)
  public void n(int paramInt)
  {
    super.n(paramInt);
    ImageSpan localImageSpan;
    SpannableString localSpannableString;
    if (paramInt != this.jdField_a_of_type_Int)
    {
      if (paramInt != 1) {
        break label87;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838192);
        localSpannableString = new SpannableString(HardCodeUtil.a(2131708794));
        localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    }
    label332:
    for (;;)
    {
      br();
      return;
      label87:
      if (paramInt == 2)
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838485);
          localSpannableString = new SpannableString(HardCodeUtil.a(2131708723));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        if (VersionUtils.e())
        {
          if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
            this.jdField_m_of_type_AndroidWidgetImageView.setAlpha(0.6F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(0.6F);
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
        }
      }
      else
      {
        if (this.jdField_b_of_type_AndroidTextSpannableString == null)
        {
          localImageSpan = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838485);
          localSpannableString = new SpannableString(HardCodeUtil.a(2131708769));
          localSpannableString.setSpan(localImageSpan, 0, localSpannableString.length(), 33);
          this.jdField_b_of_type_AndroidTextSpannableString = localSpannableString;
        }
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(2131690891);
        }
        for (;;)
        {
          if (!VersionUtils.e()) {
            break label332;
          }
          if (this.jdField_m_of_type_AndroidWidgetImageView != null) {
            this.jdField_m_of_type_AndroidWidgetImageView.setAlpha(1.0F);
          }
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
          break;
          this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_b_of_type_AndroidTextSpannableString);
        }
      }
    }
  }
  
  public void o()
  {
    if (!this.T) {
      super.o();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (!b(paramView)) {
        break;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      t(true);
      break;
      bX();
      break;
      cc();
      break;
      cb();
      break;
      ca();
      break;
      bZ();
      break;
      ai();
      break;
      bY();
      break;
      if (!a(paramView)) {
        break;
      }
      continue;
      super.onClick(paramView);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    ((WeiShiSubScribeHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(22)).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((O()) && (this.an) && (EcshopConfUtil.b()))
    {
      ReportUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      this.C = (k() - this.u);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onScrollStateChanged<<<<<: " + this.C);
      }
    }
    b(paramAbsListView);
    if (K()) {
      return;
    }
    if (this.w > paramInt3) {
      this.jdField_n_of_type_Int = 4;
    }
    for (;;)
    {
      this.w = paramInt3;
      d(paramInt2, paramInt3);
      if ((!this.ap) && (!this.R)) {
        break;
      }
      if ((!this.aa) || (this.R)) {
        break label204;
      }
      this.aa = false;
      return;
      if (this.w < paramInt3) {
        this.jdField_n_of_type_Int = 3;
      }
    }
    label204:
    if (this.jdField_m_of_type_AndroidViewView.getHeight() != 0) {
      this.jdField_v_of_type_Int = this.jdField_m_of_type_AndroidViewView.getHeight();
    }
    int i1 = this.u - k();
    this.u = k();
    if (this.jdField_B_of_type_Int * i1 < 0)
    {
      this.jdField_B_of_type_Int = i1;
      return;
    }
    this.jdField_B_of_type_Int = i1;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Move = " + String.valueOf(i1));
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
    if ((O()) && (this.an) && (EcshopConfUtil.b()) && (paramInt == 0))
    {
      this.u = k();
      if (this.C > 100)
      {
        ReportUtil.a(null, "qgg.index.up", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
        ReportUtil.b(null, "qgg_index_up", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_b_of_type_JavaLangString, 2, "report qgg_index_up");
        }
      }
    }
    ((WeiShiSubScribeHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(22)).a(paramAbsListView, paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.Z = true;
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void t(boolean paramBoolean)
  {
    if (P())
    {
      au();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "setPublicAccountMenuBarVisible new qqlive pubaccount return");
    }
    while (!paramBoolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(4);
    }
    if (this.jdField_g_of_type_AndroidViewView != null) {
      this.jdField_g_of_type_AndroidViewView.setVisibility(4);
    }
    if (this.jdField_h_of_type_AndroidViewView != null) {
      this.jdField_h_of_type_AndroidViewView.setVisibility(4);
    }
    aw();
  }
  
  protected void u(boolean paramBoolean)
  {
    int i2 = 8;
    if (this.jdField_n_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_n_of_type_AndroidWidgetImageView.clearAnimation();
    Object localObject = this.jdField_n_of_type_AndroidWidgetImageView;
    if (paramBoolean)
    {
      i1 = 0;
      label30:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      i1 = i2;
      if (!paramBoolean) {
        i1 = 0;
      }
      ((XEditTextEx)localObject).setVisibility(i1);
      if (this.jdField_h_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_ComTencentWidgetPatchedButton;
        if (!paramBoolean) {
          break label162;
        }
      }
    }
    label162:
    for (int i1 = 4;; i1 = 0)
    {
      ((PatchedButton)localObject).setVisibility(i1);
      if (!paramBoolean) {
        break;
      }
      if (this.jdField_a_of_type_AndroidTextSpannableString == null)
      {
        localObject = new ImageSpan(this.jdField_a_of_type_AndroidContentContext, 2130838192);
        SpannableString localSpannableString = new SpannableString(HardCodeUtil.a(2131708755));
        localSpannableString.setSpan(localObject, 0, localSpannableString.length(), 33);
        this.jdField_a_of_type_AndroidTextSpannableString = localSpannableString;
      }
      this.jdField_b_of_type_ComTencentWidgetPatchedButton.setText(this.jdField_a_of_type_AndroidTextSpannableString);
      return;
      i1 = 8;
      break label30;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageRecord))
    {
      localObject = ((MessageRecord)paramObject).getExtInfoFromExtStr("welcome_msg");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals("true"))) {
        ThreadManager.post(new PublicAccountChatPie.47(this), 8, null, false);
      }
      this.ac = true;
    }
    if ((ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((paramObject instanceof MessageRecord))) {
      ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    super.update(paramObservable, paramObject);
    int i1;
    if ((paramObservable instanceof TroopEntranceBar)) {
      if ((paramObject instanceof Integer))
      {
        i1 = ((Integer)paramObject).intValue();
        if (i1 != 0) {
          break label153;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar.b();
      }
    }
    label148:
    label152:
    label153:
    do
    {
      break label152;
      break label152;
      break label152;
      break label152;
      bN();
      for (;;)
      {
        return;
        if (i1 != 1) {
          break label148;
        }
        this.au = true;
        break label148;
        if ((paramObservable instanceof QQMessageFacade))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar == null) {
            break;
          }
          paramObject = (TroopManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.TROOP_MANAGER);
          paramObservable = ((QQMessageFacade)paramObservable).a();
          if (paramObservable == null) {
            break;
          }
          paramObservable = paramObject.c(paramObservable.frienduin);
          if (paramObservable == null) {
            break;
          }
          try
          {
            if (paramObservable.associatePubAccount == Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue())
            {
              paramObject = android.os.Message.obtain();
              paramObject.what = 9;
              localObject = new Bundle();
              ((Bundle)localObject).putString("troopUin", paramObservable.troopuin);
              paramObject.setData((Bundle)localObject);
              this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
              return;
            }
          }
          catch (NumberFormatException paramObservable)
          {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "exception: sessionInfo curFriendUin is not a long type.");
            return;
          }
        }
      }
    } while (!this.T);
    ThreadManager.post(new PublicAccountChatPie.48(this), 5, null, false);
  }
  
  public void v()
  {
    super.v();
    bo();
  }
  
  void v(int paramInt)
  {
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
    if ((!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      if (!this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
  
  public void w(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  public boolean w()
  {
    if ((!this.ad) && (this.T))
    {
      this.ad = true;
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1);
    }
    while ((this.ae) || (!this.T)) {
      return true;
    }
    this.ae = true;
    return false;
  }
  
  public void x(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidAppDialog == null)
    {
      this.jdField_d_of_type_AndroidAppDialog = new ReportDialog(a(), 2131755842);
      this.jdField_d_of_type_AndroidAppDialog.setContentView(2131560988);
    }
    TextView localTextView1 = (TextView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131379432);
    TextView localTextView2 = (TextView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131361939);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidAppDialog.setOnCancelListener(new PublicAccountChatPie.59(this));
      this.jdField_d_of_type_AndroidAppDialog.show();
      return;
      localTextView1.setText(2131698272);
      localTextView2.setText(2131698278);
      continue;
      localTextView1.setText(2131698273);
      localTextView2.setText(2131698274);
      continue;
      localTextView1.setText(2131698276);
      localTextView2.setText(2131698274);
    }
  }
  
  public void z()
  {
    if (this.aw)
    {
      "https://h5.qzone.qq.com/subscription/homepage/{userId}?_proxy=1&_wv=16777217&_wwv=4".replace("{userId}", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      SubscribeLaucher.a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "auth_aio", "clk_head", 0, 0, "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, "");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.ah) {
      localIntent.putExtra("qidian_chat", true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      localIntent.putExtra("public_account_msg_id", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
    }
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1020 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfileForResult(localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 1, ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isComeFromReadInJoy());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie
 * JD-Core Version:    0.7.0.1
 */