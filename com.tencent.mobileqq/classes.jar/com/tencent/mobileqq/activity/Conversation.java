package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ScrollReport;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.LocalSearchBar;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.activity.recent.RecentReportHelper;
import com.tencent.mobileqq.activity.recent.RecentTroopMenuOption;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTencentDocsAssistantData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.DrawerListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.RegisterProxySvcPackObserver;
import com.tencent.mobileqq.app.ShortVideoObserver;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.armap.ConversationARMap;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.imaxad.ImaxAdNetPresenter;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;
import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.now.enter.ConversationNowController;
import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.mobileqq.now.enter.widget.HongBao2018ListView;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.TraceUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qlink.QQProxyForQlink;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import skk;
import sku;
import skv;
import skw;
import skx;
import slb;
import slc;
import sld;
import sle;
import slf;
import slh;
import sli;
import slj;
import slk;
import sll;
import slq;
import slr;
import sls;
import slv;
import slw;
import smb;
import smc;
import smd;
import smf;
import smg;
import smh;
import smi;
import smp;
import smq;
import smr;
import sms;
import smu;
import smv;
import smw;
import smy;
import smz;
import sna;
import snb;
import sne;
import snf;
import sni;
import snj;
import snk;
import snl;
import snm;
import snn;
import sno;
import snp;
import snq;
import snr;
import sns;
import snt;
import snu;
import snv;

public class Conversation
  extends Frame
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, RadioGroup.OnCheckedChangeListener, UpgradeTipsDialog.OnPreparedListener, OnRecentUserOpsListener, AppConstants, FrameHelperActivity.DrawerListener, AbsListView.OnScrollListener, OverScrollViewListener, SwipListView.RightIconMenuListener, Observer
{
  public static long b;
  private boolean A;
  private boolean B;
  private boolean C;
  int jdField_a_of_type_Int = 0;
  public long a;
  public Dialog a;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new smv(this);
  protected Handler.Callback a;
  public View a;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private final AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver = new smi(this);
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new smq(this);
  public MsgTabStoryNodeListManager a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  ConversationHotChatCtrl jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl = null;
  public QQSettingMe a;
  QZoneFeedsObserver jdField_a_of_type_ComTencentMobileqqActivityQZoneFeedsObserver = new sms(this);
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog;
  public BannerManager a;
  LocalSearchBar jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar;
  public RecentAdapter a;
  public RecentOptPopBar a;
  RecentTroopMenuOption jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  protected BizTroopObserver a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new smc(this);
  private final ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new sls(this);
  private final DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new smg(this);
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new smd(this);
  public FrameHelperActivity a;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new sll(this);
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new smz(this);
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new slw(this);
  private RegisterProxySvcPackObserver jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver = new smr(this);
  private ShortVideoObserver jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver = new snb(this);
  private final SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new smh(this);
  private final TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new slq(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new slv(this);
  public ConversationARMap a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  public FPSSwipListView a;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("tool_adMessage", "com.tencent.mobileqq:tool");
  private ConversationNowController jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController;
  private final GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new smp(this);
  public ConversationHongBao a;
  private PstnObserver jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = new sna(this);
  public RedTouch a;
  VipGiftManager jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = null;
  public PullRefreshHeader a;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public String a;
  protected StringBuilder a;
  public ArrayList a;
  Comparator jdField_a_of_type_JavaUtilComparator = new sni(this);
  public List a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public MqqHandler a;
  private snq jdField_a_of_type_Snq;
  private snr jdField_a_of_type_Snr;
  private sns jdField_a_of_type_Sns;
  snt jdField_a_of_type_Snt = new snt(this);
  private snu jdField_a_of_type_Snu;
  private snv jdField_a_of_type_Snv;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  Dialog jdField_b_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new smw(this);
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  private PreloadProcHitSession jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("tool_shop", "com.tencent.mobileqq:tool");
  public String b;
  final List jdField_b_of_type_JavaUtilList = new ArrayList(40);
  public MqqHandler b;
  public boolean b;
  int jdField_c_of_type_Int;
  public long c;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new smy(this);
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public RelativeLayout c;
  private PreloadProcHitSession jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private String jdField_c_of_type_JavaLangString;
  MqqHandler jdField_c_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_Snt);
  public boolean c;
  int jdField_d_of_type_Int;
  long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  public boolean d;
  int jdField_e_of_type_Int = 3;
  public long e;
  private View jdField_e_of_type_AndroidViewView;
  public boolean e;
  public int f;
  long jdField_f_of_type_Long = 0L;
  private View jdField_f_of_type_AndroidViewView;
  public boolean f;
  private View g;
  public boolean g;
  public boolean h = false;
  public boolean i = false;
  public boolean j;
  public boolean k = false;
  boolean l = false;
  boolean m = false;
  boolean n = false;
  boolean o = false;
  boolean p = false;
  boolean q = false;
  boolean r = false;
  boolean s;
  public boolean t = false;
  boolean u = false;
  public boolean v;
  private boolean x;
  private boolean y;
  private boolean z;
  
  static
  {
    jdField_b_of_type_Long = -1L;
  }
  
  public Conversation()
  {
    this.jdField_a_of_type_Long = 2000L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler$Callback = new skk(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new slr(this);
  }
  
  private void A()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.jdField_f_of_type_Long);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(a().getContentResolver(), "date_format");
      if (TimeManager.a().a(str)) {
        this.jdField_f_of_type_Long = l1;
      }
    }
  }
  
  private void B()
  {
    if (LoadingStateManager.a().b()) {
      LoadingStateManager.a().a(3);
    }
  }
  
  private void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMWrapper", 2, "Conversation showUpgradeDetailInfoIfNeccessary mInitTimUpgradeInfo : " + this.z);
    }
    if ((!this.w) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a()))
    {
      if (this.w)
      {
        if ((!ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.z))
        {
          a(1134047, 0L, true);
          this.z = true;
        }
        a(1134057, 0L, true);
      }
      return;
    }
    if ((this.jdField_c_of_type_AndroidAppDialog != null) && (this.jdField_c_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
      this.jdField_c_of_type_AndroidAppDialog = null;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.show();
      ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i1 = ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ConfigHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1 + 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void D()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131364961));
    this.jdField_a_of_type_Snr = new snr(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_Snr, false);
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.p = false;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131362845));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363398));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363990));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363496));
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363991));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363400));
    c(false);
    Object localObject;
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364001);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364002));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364003));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363996);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363997));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(a().getDrawable(2130838596));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130838220);
      localObject = a();
      if ((localObject == null) || (!(localObject instanceof SplashActivity))) {
        break label740;
      }
      SplashActivity localSplashActivity = (SplashActivity)localObject;
      localObject = localSplashActivity.jdField_b_of_type_AndroidViewView;
      localSplashActivity.jdField_b_of_type_AndroidViewView = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar = new LocalSearchBar(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_b_of_type_AndroidWidgetRelativeLayout, a(), (View)localObject, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager = new BannerManager(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 0, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
      this.jdField_c_of_type_AndroidViewView = new View(a());
      localObject = new AbsListView.LayoutParams(-1, 0);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView, null, false);
      localObject = RecentDataListManager.a().jdField_b_of_type_JavaUtilList;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao = new ConversationHongBao(this, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap = new ConversationARMap(this, this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController = new ConversationNowController(this, this.jdField_a_of_type_AndroidViewViewGroup);
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof HongBao2018ListView)) {
        ((HongBao2018ListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).setNowFloatViewCallBack(new skw(this));
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131363993));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845951);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494218));
      break;
      label740:
      localObject = null;
    }
  }
  
  private void E()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_F2F_REDPACK_IS_SHOWED", false))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = QWalletSetting.a(a().getCurrentAccountUin(), "F2FRedpackEntry", false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "showF2FRedpackRedTouch, isF2FRedpackEntryShowed=" + bool1 + ", isSwitchOpened=" + bool2);
      }
      if ((bool2) && (!bool1))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(a(), this.jdField_a_of_type_AndroidWidgetImageView).a(53).d(5).c(8).a();
        }
        N();
      }
      return;
    }
  }
  
  private void F()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    a(1010, 0L, false);
    a(1023, 0L, false);
    C();
    VipBannerInfo.a(this);
    if (!this.jdField_g_of_type_Boolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2);
    }
    G();
  }
  
  private void G()
  {
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void H()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "removeObservers" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(17);
      Object localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQZoneFeedsObserver);
        localObject1 = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (localObject1 != null) {
          ((QCallFacade)localObject1).deleteObserver(this);
        }
        localObject1 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
        if (localObject1 != null) {
          ((RedTouchManager)localObject1).deleteObserver(this);
        }
        if (this.jdField_a_of_type_Sns != null)
        {
          localObject1 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
          if (localObject1 != null) {
            ((PortalManager)localObject1).a(this.jdField_a_of_type_Sns);
          }
        }
        if (this.jdField_a_of_type_Snq != null)
        {
          localObject1 = (ARMapConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(189);
          if (localObject1 != null) {
            ((ARMapConfigManager)localObject1).b(this.jdField_a_of_type_Snq);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
        localObject1 = (NowHongbaoPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(265);
        if (localObject1 != null) {
          ((NowHongbaoPushManager)localObject1).b(this.jdField_a_of_type_Snu);
        }
      }
      try
      {
        localObject1 = a();
        if (this.jdField_a_of_type_Snv != null)
        {
          ((BaseActivity)localObject1).app.a().b(this.jdField_a_of_type_Snv);
          this.jdField_a_of_type_Snv.a();
          this.jdField_a_of_type_Snv = null;
        }
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, localException.toString());
          }
        }
      }
      return;
    }
  }
  
  private void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess start");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.m)) {
      break label30;
    }
    label30:
    label170:
    for (;;)
    {
      return;
      if ((TeamWorkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (TeamWorkUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          label73:
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition())
          {
            Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
            if ((!(localObject instanceof RecentItemTencentDocsAssistantData)) || (((RecentItemTencentDocsAssistantData)localObject).b() <= 0)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!PublicAccountManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            break label170;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess call");
          }
          if (this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession == null) {
            break;
          }
          this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession.a();
          return;
          i1 += 1;
          break label73;
        }
      }
    }
  }
  
  private void J()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new smf(this);
  }
  
  private void K()
  {
    if ((this.k) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks[0] = new sne(this);
  }
  
  private void L()
  {
    if ((this.w) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      ThreadManager.post(new snf(this), 5, null, true);
    }
  }
  
  private void M()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "checkShowCallTab mCallTabChanged: " + this.p);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.p))
      {
        QCallFacade localQCallFacade = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (localQCallFacade != null) {
          localQCallFacade.b(MessageCache.a());
        }
      }
    } while (!this.p);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n;
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "checkShowCallTab isCallTabShow: " + bool);
    }
    u();
    if (bool)
    {
      ((RadioButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363992)).performClick();
      c(false);
    }
    this.p = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0);
  }
  
  private void N()
  {
    int i2 = 1;
    MqqHandler localMqqHandler;
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_F2F_REDPACK_IS_SHOWED", false);
      if ((!QWalletSetting.a(a().getCurrentAccountUin(), "F2FRedpackEntry", false)) || (bool)) {
        break label90;
      }
      i1 = 1;
      localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
      if (i1 == 0) {
        break label95;
      }
    }
    label90:
    label95:
    for (int i1 = i2;; i1 = 0)
    {
      localMqqHandler.obtainMessage(1048, i1, 0).sendToTarget();
      return;
      i1 = 0;
      break;
    }
  }
  
  private void O()
  {
    if (!this.w) {
      break label7;
    }
    label7:
    while (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.b(17)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getChildCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() >= 0)) {}
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 == 0)
      {
        this.C = false;
        return;
      }
      if (this.C) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "checkPushBannerReport");
      }
      this.C = true;
      ThreadManager.post(new snl(this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(17, 2131365698)), 5, null, false);
      return;
    }
  }
  
  private void a(Message paramMessage)
  {
    for (;;)
    {
      UpgradeTIMWrapper localUpgradeTIMWrapper;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("UpgradeTIMWrapper", 2, "Conversation onReceiveShowTIMUpgradeTips");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_c_of_type_AndroidAppDialog == null))
        {
          boolean bool = paramMessage.obj instanceof UpgradeTIMWrapper;
          if (bool) {}
        }
        else
        {
          return;
        }
        localUpgradeTIMWrapper = (UpgradeTIMWrapper)paramMessage.obj;
        if ((localUpgradeTIMWrapper == null) || (TextUtils.isEmpty(localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(localUpgradeTIMWrapper.jdField_c_of_type_JavaLangString))) {
          continue;
        }
        sno localsno = new sno(this);
        snp localsnp = new snp(this, localUpgradeTIMWrapper);
        if (TextUtils.isEmpty(localUpgradeTIMWrapper.d))
        {
          paramMessage = "知道了";
          if (!TextUtils.isEmpty(localUpgradeTIMWrapper.e)) {
            break label317;
          }
          str = "马上下载";
          this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(a(), localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString, localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString, paramMessage, str, null, localsnp, localsno);
          this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new sku(this));
          if ((!this.w) || (this.jdField_c_of_type_AndroidAppDialog.isShowing()) || ((this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.isShowing())) || (ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            continue;
          }
          this.jdField_c_of_type_AndroidAppDialog.show();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
          ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          a(1134048, 0L, true);
          continue;
        }
        paramMessage = localUpgradeTIMWrapper.d;
      }
      finally {}
      continue;
      label317:
      String str = localUpgradeTIMWrapper.e;
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    int i1;
    if ((paramAbsListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      i1 = paramAbsListView.getFirstVisiblePosition();
      if (i1 <= 0) {
        break label233;
      }
      i1 -= 1;
    }
    label226:
    label233:
    for (;;)
    {
      int i3 = paramAbsListView.getLastVisiblePosition();
      int i2 = i1;
      for (;;)
      {
        Object localObject1;
        if (i2 < i3 + 1)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i2);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemPublicAccountADFolderData))) {
            break label226;
          }
          localObject1 = (RecentItemPublicAccountADFolderData)localObject1;
          if (!ImaxAdUtil.a(paramAbsListView.getChildAt(i2 - i1))) {
            break label226;
          }
          localObject1 = AdvertisementRecentUserManager.a().a(((RecentItemPublicAccountADFolderData)localObject1).a.uin);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Message localMessage = Message.obtain();
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("key_app", new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        ((HashMap)localObject2).put("key_adapter", new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter));
        ((HashMap)localObject2).put("key_listview", new WeakReference(paramAbsListView));
        localMessage.obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_ad_id", ((AdvertisementItem)localObject1).jdField_c_of_type_JavaLangString);
        localMessage.setData((Bundle)localObject2);
        localMessage.what = 1;
        ImaxAdNetPresenter.a().a(localMessage);
        i2 += 1;
      }
    }
  }
  
  private boolean a(String paramString, int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, paramInt) > 0);
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceiverShowUpgradeTips");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) || (!(paramMessage.obj instanceof UpgradeDetailWrapper))) {}
    do
    {
      return;
      paramMessage = (UpgradeDetailWrapper)paramMessage.obj;
      if (ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) >= 5)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340003);
        return;
      }
    } while ((ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog = new UpgradeTipsDialog(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.setOnDismissListener(new skv(this));
  }
  
  private void c(long paramLong)
  {
    if (this.j) {
      a(1016, paramLong, true);
    }
  }
  
  private void d(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(300L);
    paramView.startAnimation(localTranslateAnimation);
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.q != paramBoolean)
    {
      if (!paramBoolean) {
        break label121;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager = new MsgTabStoryNodeListManager(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, (BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364004));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_e_of_type_Boolean = this.w;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.b();
    }
    for (;;)
    {
      this.q = paramBoolean;
      return;
      label121:
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.c();
      }
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "addObservers" + paramBoolean + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    AtomicBoolean localAtomicBoolean = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
    if (!paramBoolean) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(17, 200L);
      return;
    }
    finally {}
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQZoneFeedsObserver);
    Object localObject2 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    if (localObject2 != null) {
      ((RedTouchManager)localObject2).addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      J();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    if (this.jdField_a_of_type_Snv == null) {
      this.jdField_a_of_type_Snv = new snv(this);
    }
    this.jdField_a_of_type_Snv.a(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, C2CPttDownloadProcessor.class, C2CPttUploadProcessor.class, GroupPicUploadProcessor.class, GroupPttDownloadProcessor.class, ForwardImageProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Snv);
    try
    {
      localObject2 = new IntentFilter("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      localObject2 = new IntentFilter("com.tencent.mobileqq.action.SECURITY_DETECT_PUSH_BANNER");
      a().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      localObject2 = new IntentFilter("android.intent.action.TIME_SET");
      ((IntentFilter)localObject2).addAction("android.intent.action.DATE_CHANGED");
      ((IntentFilter)localObject2).addAction("android.intent.action.TIMEZONE_CHANGED");
      a().registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
        localObject2 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
        if (localObject2 != null)
        {
          if (this.jdField_a_of_type_Sns == null) {
            this.jdField_a_of_type_Sns = new sns(this, null);
          }
          ((PortalManager)localObject2).a(this.jdField_a_of_type_Sns, 3);
        }
        localObject2 = (ARMapConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(189);
        if (localObject2 != null)
        {
          if (this.jdField_a_of_type_Snq == null) {
            this.jdField_a_of_type_Snq = new snq(this, null);
          }
          ((ARMapConfigManager)localObject2).a(this.jdField_a_of_type_Snq);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
        localObject2 = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (localObject2 != null) {
          ((QCallFacade)localObject2).addObserver(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
        UITools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver);
        localObject2 = (NowHongbaoPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(265);
        if (localObject2 != null)
        {
          if (this.jdField_a_of_type_Snu == null) {
            this.jdField_a_of_type_Snu = new snu(this, null);
          }
          ((NowHongbaoPushManager)localObject2).a(this.jdField_a_of_type_Snu);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, localException.toString());
        }
      }
    }
  }
  
  private void i(boolean paramBoolean)
  {
    if ((!PublicAccountConfigUtil.k) || ((!paramBoolean) && (PublicAccountManager.a().jdField_a_of_type_Boolean))) {}
    label151:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
        if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
          if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1) instanceof RecentItemPublicAccountADFolderData)) {}
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label151;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null) && (!this.x))
        {
          this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.x = true;
        }
        PublicAccountManager.a().jdField_a_of_type_Boolean = true;
        ThreadManager.getSubThreadHandler().postDelayed(new sld(this), 1000L);
        return;
        i1 += 1;
        break;
      }
    }
  }
  
  private void x()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.m);
    }
    if (this.m) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1025);
    this.m = true;
    if (!this.n) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    BaseApplicationImpl.sApplication.onActivityFocusChanged(a(), true);
  }
  
  private void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "scrollToTopIfNeccessary: " + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
    }
  }
  
  private void z()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {}
    }
    else
    {
      return;
    }
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount();
    int i1 = this.jdField_b_of_type_Int + 1;
    label96:
    int i2;
    for (;;)
    {
      if (i1 < i3)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
        if (!(localObject instanceof RecentBaseData))
        {
          i1 += 1;
        }
        else
        {
          localObject = (RecentBaseData)localObject;
          if (((RecentBaseData)localObject).a())
          {
            i2 = ((RecentBaseData)localObject).b();
            label124:
            if (i2 <= 0) {
              break label224;
            }
            this.jdField_b_of_type_Int = i1;
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount(), 0);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "scrollToNextUnreadItem|findUnreadItem:" + bool + ",mCurrentUnreadItem" + this.jdField_b_of_type_Int);
        return;
        y();
        this.jdField_b_of_type_Int = -1;
      }
      break;
      i2 = 0;
      break label124;
      label224:
      break label96;
    }
  }
  
  protected int a(String paramString, int paramInt)
  {
    int i1 = 4;
    int i2 = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i2;
    case 1000: 
    case 1004: 
    case 1006: 
    case 1021: 
    case 0: 
      do
      {
        i1 = paramInt;
        return i1;
        paramInt = 1;
      } while (RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
      return 4;
    case 3000: 
      return 2;
    case 1: 
      paramString = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      return 3;
    case 1001: 
    case 1003: 
    case 10002: 
    case 10004: 
      return 5;
    case 1005: 
      return 6;
    case 1008: 
    case 1009: 
    case 1012: 
    case 1020: 
    case 1022: 
      return 7;
    case 5000: 
      return 8;
    case 7120: 
    case 7200: 
      return 9;
    case 6000: 
      return 10;
    case 7000: 
      return 11;
    }
    return 12;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    StartupTracker.a(null, "Recent_Start");
    StartupTracker.a(null, "Recent_CreateView");
    Object localObject1 = a();
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof SplashActivity)))
    {
      localObject2 = (SplashActivity)localObject1;
      localObject1 = ((SplashActivity)localObject2).jdField_a_of_type_AndroidViewView;
      ((SplashActivity)localObject2).jdField_a_of_type_AndroidViewView = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramLayoutInflater.inflate(2130968831, null);
      }
      StartupTracker.a("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public RecentAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  }
  
  protected String a()
  {
    if (this.jdField_d_of_type_Int <= 0) {
      return "消息";
    }
    if (this.jdField_d_of_type_Int > 99) {
      return "消息" + "(99+)";
    }
    return "消息" + "(" + this.jdField_d_of_type_Int + ")";
  }
  
  public void a()
  {
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a(paramInt1, paramInt2, paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onActivityResult, [" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    }
    switch (paramInt1)
    {
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return;
                              } while ((paramIntent == null) || (paramInt2 != -1));
                              localObject1 = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
                            } while (localObject1 == null);
                            localObject2 = paramIntent.getStringExtra("uin");
                            paramInt1 = paramIntent.getIntExtra("uintype", -1);
                            paramInt2 = paramIntent.getIntExtra("cmshow_game_id", -1);
                            ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, paramInt1, (AbsStructMsg)localObject1, null);
                            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(paramInt1), 0, new String[] { Integer.toString(paramInt2) });
                            return;
                          } while (a() == null);
                          a().setCanLock(false);
                          return;
                        } while (paramInt2 != 0);
                        w();
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
                        return;
                      } while ((-1 != paramInt2) || (paramIntent == null));
                      paramIntent = paramIntent.getStringExtra("roomId");
                    } while (paramIntent == null);
                    TroopUtils.a(a(), paramIntent);
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
                    return;
                  } while ((-1 != paramInt2) || (paramIntent == null));
                  localObject1 = paramIntent.getStringExtra("roomId");
                  paramIntent = paramIntent.getStringArrayListExtra("qqPhoneUserList");
                } while (localObject1 == null);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_shortcut_launch", 0, 0, "", "", "", "");
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().put(Long.valueOf((String)localObject1), "CREATE_FROM_CALL");
                ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 3000, (String)localObject1, true, true, true, null, paramIntent, 4, 6);
                if (this.jdField_c_of_type_Boolean)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 10, 0, "", "", "", "");
                  this.jdField_c_of_type_Boolean = false;
                  return;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 7, 0, "", "", "", "");
                return;
              } while ((-1 != paramInt2) || (paramIntent == null));
              paramInt1 = paramIntent.getIntExtra("audioType", -1);
              if (paramInt1 == 1)
              {
                paramInt1 = paramIntent.getIntExtra("uinType", 0);
                localObject1 = paramIntent.getStringExtra("peerUin");
                localObject2 = paramIntent.getStringExtra("name");
                str1 = paramIntent.getStringExtra("phoneNum");
                paramIntent = paramIntent.getStringExtra("from");
                ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramInt1, (String)localObject1, (String)localObject2, str1, true, null, true, true, null, paramIntent);
                return;
              }
              if (paramInt1 != 2) {
                break;
              }
              paramInt1 = paramIntent.getIntExtra("uinType", 3000);
              localObject1 = paramIntent.getStringExtra("roomId");
              localObject2 = paramIntent.getStringArrayListExtra("qqPhoneUserList");
              paramInt2 = paramIntent.getIntExtra("callType", 2);
              int i1 = paramIntent.getIntExtra("from", 3);
              ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramInt1, (String)localObject1, true, true, true, null, (ArrayList)localObject2, paramInt2, i1);
              paramInt1 = paramIntent.getIntExtra("reportType", 0);
              if (paramInt1 == 1)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 5, 0, "", "", "", "");
                return;
              }
            } while (paramInt1 != 2);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 6, 0, "", "", "", "");
            return;
            if (paramInt1 == 3)
            {
              paramInt1 = paramIntent.getIntExtra("uinType", 0);
              localObject1 = paramIntent.getStringExtra("peerUin");
              localObject2 = paramIntent.getStringExtra("name");
              str1 = paramIntent.getStringExtra("phoneNum");
              paramInt2 = paramIntent.getIntExtra("from", 3);
              ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramInt1, (String)localObject1, (String)localObject2, str1, true, null, true, true, null, null, paramInt2, true);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006406", "0X8006406", 2, 0, "", "", "", "");
              return;
            }
          } while (paramInt1 != 4);
          paramInt1 = paramIntent.getIntExtra("uinType", 0);
          localObject1 = paramIntent.getStringExtra("peerUin");
          Object localObject2 = paramIntent.getStringExtra("name");
          String str1 = paramIntent.getStringExtra("phoneNum");
          String str2 = paramIntent.getStringExtra("selfPhoneNum");
          paramInt2 = paramIntent.getIntExtra("from", 3);
          paramIntent = new PstnSessionInfo();
          paramIntent.jdField_a_of_type_Int = paramInt1;
          paramIntent.jdField_a_of_type_JavaLangString = ((String)localObject1);
          paramIntent.d = ((String)localObject2);
          paramIntent.jdField_b_of_type_JavaLangString = str1;
          paramIntent.jdField_c_of_type_JavaLangString = str2;
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), paramIntent, paramInt2);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006406", "0X8006406", 2, 0, "", "", "", "");
          return;
        } while (paramInt2 != -1);
        QQToast.a(a(), 2, a(2131436513), 0).b(a().getTitleBarHeight());
        return;
      } while (paramInt2 != -1);
      ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 222);
      return;
      RecentOptPopBar.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
      return;
      localObject1 = CmGameUtil.a();
    } while (localObject1 == null);
    ((ApolloSurfaceView)localObject1).queueEvent(new smb(this, (ApolloSurfaceView)localObject1, paramInt1, paramInt2, paramIntent));
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshRecentList|invalidate to refresh");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt2 <= 10) && (paramInt2 >= 8)) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2);
        return;
        if ((paramInt2 != 10) || ((paramObject instanceof Long))) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2 + ", obj: " + paramObject);
      return;
      if (((paramInt2 != 8) && (paramInt2 != 9)) || ((paramObject instanceof String))) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "refreshRecentList invalidate params arg2: " + paramInt2 + ", obj:" + paramObject);
    return;
    if (!d())
    {
      this.l = false;
      Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(11);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramObject;
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    this.l = true;
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(paramInt);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null))
    {
      if (this.j) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.aa_();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    String str;
    RecentUserProxy localRecentUserProxy;
    Object localObject2;
    if (paramBoolean)
    {
      str = "1";
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject2 = paramRecentBaseData.a();
      if ((paramInt != 7000) || (AppConstants.w.equals(localObject2))) {
        break label159;
      }
      SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, paramBoolean);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str, paramString, "");
    }
    int i2;
    int i1;
    for (;;)
    {
      i2 = a(paramRecentBaseData.a(), paramInt);
      paramRecentBaseData = localRecentUserProxy.a(false).iterator();
      i1 = 0;
      label148:
      while (paramRecentBaseData.hasNext())
      {
        if (((RecentUser)paramRecentBaseData.next()).showUpTime == 0L) {
          break label1444;
        }
        i1 += 1;
      }
      str = "0";
      break;
      label159:
      if (paramInt == 5000)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData, paramBoolean);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", str, paramString, "");
      }
      else
      {
        if (paramInt != 5001) {
          break label248;
        }
        ((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254)).a(paramBoolean);
      }
    }
    label248:
    Object localObject1;
    if (paramInt == 1)
    {
      paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject1 = paramString.d(paramRecentBaseData.a());
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
        if (paramBoolean)
        {
          i1 = 0;
          label306:
          if (((BizTroopHandler)localObject2).a((String)localObject1, i1)) {
            break label325;
          }
        }
      }
    }
    label318:
    label325:
    label375:
    do
    {
      do
      {
        return;
        i1 = 1;
        break label306;
        paramString = paramString.b(paramRecentBaseData.a());
        if (paramString != null) {}
        switch (paramString.troopmask)
        {
        case 2: 
        case 3: 
        default: 
          i1 = 0;
          localObject1 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
          localObject2 = paramRecentBaseData.a();
          if (!paramBoolean) {
            break;
          }
        }
        for (paramString = "0";; paramString = "1")
        {
          ((ReportTask)localObject1).a(new String[] { localObject2, String.valueOf(i1), paramString }).a();
          break;
          i1 = 0;
          break label375;
          i1 = 3;
          break label375;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.recent", 2, "TroopManage.getTroopCodeByTroopUin return null...");
        }
        i1 = paramRecentBaseData.a();
        if ((localObject2 != null) && (((String)localObject2).length() != 0) && (localRecentUserProxy != null)) {
          break label596;
        }
      } while (!QLog.isColorLevel());
      paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
      if (localObject2 == null)
      {
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (localRecentUserProxy != null) {
          break label590;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("Q.recent", 2, paramBoolean);
        return;
        paramBoolean = false;
        break;
      }
      localObject1 = localRecentUserProxy.b((String)localObject2, i1);
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        paramString = new RecentUser();
        paramString.uin = ((String)localObject2);
        paramString.type = i1;
      }
      if (!HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) {
        break;
      }
      if (paramBoolean) {}
      for (paramString.showUpTime = (System.currentTimeMillis() / 1000L);; paramString.showUpTime = 0L)
      {
        localRecentUserProxy.a(paramString);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        break;
      }
      i1 = paramRecentBaseData.a();
      if ((localObject2 != null) && (((String)localObject2).length() != 0) && (localRecentUserProxy != null)) {
        break label792;
      }
    } while (!QLog.isColorLevel());
    label590:
    label596:
    paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
    if (localObject2 == null)
    {
      paramBoolean = true;
      paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
      if (localRecentUserProxy != null) {
        break label786;
      }
    }
    label786:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("Q.recent", 2, paramBoolean);
      return;
      paramBoolean = false;
      break;
    }
    label792:
    paramString = localRecentUserProxy.b((String)localObject2, i1);
    if (paramString == null)
    {
      paramString = new RecentUser();
      paramString.uin = ((String)localObject2);
      paramString.type = i1;
    }
    for (;;)
    {
      label842:
      int i3;
      if (paramBoolean)
      {
        paramString.showUpTime = (System.currentTimeMillis() / 1000L);
        localRecentUserProxy.a(paramString);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        if ((i1 != 7210) && (i1 != 7120)) {
          break label1098;
        }
        i3 = paramRecentBaseData.jdField_c_of_type_Int;
        localObject1 = "0X80064C4";
        if (paramBoolean) {
          localObject1 = "0X80064C3";
        }
        if (i1 != 7120) {
          break label1453;
        }
      }
      label923:
      label1056:
      label1444:
      label1447:
      label1450:
      label1453:
      for (i2 = 1;; i2 = 0)
      {
        Iterator localIterator = localRecentUserProxy.a(false).iterator();
        i1 = 0;
        if (localIterator.hasNext())
        {
          if (((RecentUser)localIterator.next()).showUpTime == 0L) {
            break label1450;
          }
          i1 += 1;
        }
        for (;;)
        {
          break label923;
          paramString.showUpTime = 0L;
          break label842;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + i2, (String)localObject1, (String)localObject1, 0, 0, "" + i3, "" + i1, "", "");
          for (;;)
          {
            if ((7220 == paramString.type) && (AppConstants.at.equals(localObject2)))
            {
              ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).c(paramBoolean);
              break;
              label1098:
              if (i1 == 1008)
              {
                i2 = paramRecentBaseData.jdField_c_of_type_Int;
                localObject1 = "0X80064C8";
                if (paramBoolean) {
                  localObject1 = "0X80064C7";
                }
                localIterator = localRecentUserProxy.a(false).iterator();
                i1 = 0;
                label1143:
                if (localIterator.hasNext())
                {
                  if (((RecentUser)localIterator.next()).showUpTime == 0L) {
                    break label1447;
                  }
                  i1 += 1;
                }
              }
            }
          }
          for (;;)
          {
            break label1143;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", paramString.uin, (String)localObject1, (String)localObject1, 0, 0, "" + i2, "" + i1, "", "");
            if (!"2290230341".equals(localObject2)) {
              break label1056;
            }
            if (paramBoolean) {}
            for (localObject1 = "0X80090E6";; localObject1 = "0X800915B")
            {
              if (paramBoolean) {
                QZoneReport.a(4);
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
              break label1056;
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, str, String.valueOf(i1), String.valueOf(i2), "");
            if (paramInt != 7220) {
              break label318;
            }
            if (paramBoolean)
            {
              PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
              return;
            }
            PublicAccountReportUtils.a(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
            return;
            break label148;
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, RecentUser paramRecentUser)
  {
    if ((paramRecentUser == null) || (paramInt == 0)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshAfterClick|[" + paramRecentUser + "," + paramInt + "]");
      }
    }
    do
    {
      return;
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(paramRecentUser.uin);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.type);
      }
    } while ((paramInt & 0x4) == 0);
    RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, -1);
    QQToast.a(a(), "你已经不在该热聊了", 0).a();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 8) && (paramInt1 != 9)) {
      return;
    }
    a(0, paramInt1, RecentDataListManager.a(paramString, paramInt2));
  }
  
  public void a(int paramInt, List paramList)
  {
    if (-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a())
    {
      this.jdField_a_of_type_Snr.a(paramInt, paramList);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      if (AppSetting.jdField_g_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new snk(this));
      }
      return;
    }
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder().append("doRefreshUI|[").append(paramInt).append(",");
      if (paramList != null) {
        break label266;
      }
    }
    label266:
    for (int i1 = 0;; i1 = paramList.size())
    {
      QLog.i("Q.recent", 4, i1 + "]");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        if (paramInt != 0) {
          break label276;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramList);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
      }
      if (AppSetting.jdField_g_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new snm(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_d_of_type_Int);
      a(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      if (this.r)
      {
        this.r = false;
        if ((((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null)) {
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.e();
        }
      }
      if (!this.y) {
        break;
      }
      this.y = false;
      I();
      return;
    }
    label276:
    if (paramList == null)
    {
      paramInt = 0;
      label282:
      i1 = 0;
      label284:
      if (i1 < paramInt)
      {
        localObject = (RecentBaseData)paramList.get(i1);
        if (localObject != null) {
          break label323;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label284;
      break;
      paramInt = paramList.size();
      break label282;
      label323:
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a((RecentBaseData)localObject);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    if (!paramBoolean1)
    {
      B();
      c(800L);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(AVNotifyCenter.class);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((MqqHandler)localObject1).obtainMessage(10010);
      ((Message)localObject2).obj = Boolean.valueOf(paramBoolean1);
      ((MqqHandler)localObject1).sendMessage((Message)localObject2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(7, 0);
    }
    boolean bool1;
    int i1;
    label111:
    boolean bool2;
    if (!paramBoolean1)
    {
      bool1 = true;
      LoadingStateManager.a().a(bool1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      if (!bool1) {
        break label244;
      }
      i1 = 2;
      ((BannerManager)localObject1).a(1, i1);
      bool2 = LoadingStateManager.a().d();
      if ((!bool2) || (paramInt != 1134012)) {
        break label352;
      }
      bool2 = false;
    }
    label352:
    for (;;)
    {
      LoadingStateManager.a().b(bool2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      i1 = i2;
      if (bool2) {
        i1 = 2;
      }
      ((BannerManager)localObject1).a(8, i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(-1, null);
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ConversationPullDownActiveBase)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              ((ConversationPullDownActiveBase)localObject2).a(paramBoolean1);
              continue;
              bool1 = false;
              break;
              label244:
              i1 = 0;
              break label111;
            }
          }
        }
      }
      d(bool1 | bool2 | paramBoolean2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(150);
        ((StringBuilder)localObject1).append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", isNetSupport = ").append(paramBoolean1).append(", loadingState = ").append(LoadingStateManager.a().a()).append(", msg = ").append(paramInt);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
  }
  
  public void a(long paramLong)
  {
    a(0, 10, Long.valueOf(paramLong));
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.a();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int i1 = QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i1 + 1);
    a(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.f();
    }
    super.a(paramConfiguration);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "showHongbaoLayer | bitmap is " + paramBitmap);
    }
    if (paramBitmap == null)
    {
      if (this.jdField_d_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
        this.jdField_d_of_type_AndroidViewView = null;
      }
      return;
    }
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      this.jdField_d_of_type_AndroidViewView = a().getLayoutInflater().inflate(2130969028, null);
      this.jdField_f_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131364807);
      this.jdField_e_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131364806);
      this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new sle(this));
    }
    Object localObject1 = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131364810);
    ((ImageView)localObject1).setContentDescription("关闭活动提醒");
    ((ImageView)localObject1).setOnClickListener(new slh(this));
    localObject1 = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131364808);
    Object localObject2 = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics();
    int i1 = ((DisplayMetrics)localObject2).widthPixels;
    int i2 = ((DisplayMetrics)localObject2).heightPixels;
    int i3 = paramBitmap.getWidth();
    int i4 = paramBitmap.getHeight();
    float f1 = i1 / i3;
    float f2 = i2 / i4;
    if (f1 - f2 > 0.0F)
    {
      f1 = f2;
      localObject2 = ((ImageView)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = ((int)(i3 * f1));
      ((ViewGroup.LayoutParams)localObject2).height = ((int)(f1 * i4));
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((ImageView)localObject1).setImageBitmap(paramBitmap);
      paramBitmap = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
      ((ImageView)localObject1).setOnClickListener(new sli(this, paramBitmap));
      ((Button)this.jdField_d_of_type_AndroidViewView.findViewById(2131364809)).setOnClickListener(new slj(this, paramBitmap));
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.addView(this.jdField_d_of_type_AndroidViewView);
      d(this.jdField_f_of_type_AndroidViewView);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = new StringBuilder().append("");
      if (paramBitmap == null) {
        break label444;
      }
    }
    label444:
    for (i1 = paramBitmap.b();; i1 = -1)
    {
      ReportController.b((QQAppInterface)localObject1, "dc01440", "", "", "0X80077E5", "0X80077E5", 0, 0, i1, "", "", "");
      return;
      break;
    }
  }
  
  public void a(Message paramMessage, boolean paramBoolean)
  {
    if (paramMessage == null) {}
    for (int i1 = 0;; i1 = paramMessage.what)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder(150);
        paramMessage.append("refreshNetStatus").append(", app.isMSFConnect = ").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean).append(", initLoadingHandle = ").append(paramBoolean).append(", loadingState = ").append(LoadingStateManager.a().a()).append(", what = ").append(i1);
        QLog.i("Q.recent", 2, paramMessage.toString());
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_e_of_type_Boolean) {
        break;
      }
      a(i1, true, paramBoolean);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new slf(this, i1, paramBoolean));
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramView);
      if ((localRecentBaseData != null) && ("9970".equals(localRecentBaseData.a()))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
      }
    } while ((localRecentBaseData == null) || (!AppConstants.au.equals(localRecentBaseData.a())));
    int i1;
    if (localRecentBaseData.jdField_b_of_type_Int == 2)
    {
      i1 = 1;
      if (localRecentBaseData.jdField_b_of_type_Int != 1) {
        break label168;
      }
    }
    label168:
    for (int i2 = localRecentBaseData.jdField_c_of_type_Int;; i2 = 0)
    {
      int i3 = -1;
      if ((paramView.getTag(-1) instanceof Integer)) {
        i3 = ((Integer)paramView.getTag(-1)).intValue() + 1;
      }
      ThreadManager.executeOnSubThread(new smu(this, i1, i2, i3));
      return;
      i1 = 0;
      break;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    RecentUserBaseData localRecentUserBaseData;
    String str;
    if (this.jdField_g_of_type_Boolean)
    {
      StartupTracker.a(null, "AIO_Click_cost");
      PAStartupTracker.a(null, "pubAcc_aio_open", "");
      ThreadPriorityManager.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "AIOTime onRecentBaseDataClick start");
      }
      paramView = null;
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
        paramView = localRecentUserBaseData.a();
        if (paramView == null) {
          break label552;
        }
        if ((paramView.type != 7120) && (paramView.type != 7210) && (paramView.type != 1008)) {
          break label495;
        }
        str = "0X80067EC";
        if (localRecentUserBaseData.jdField_c_of_type_Int != 0) {
          break label567;
        }
        str = "0X80067ED";
      }
    }
    label552:
    label555:
    label567:
    for (int i1 = 0;; i1 = 1)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.uin, paramView.type);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)))
      {
        localObject = ((MessageForStructing)localObject).structingMsg;
        if (localObject == null) {}
      }
      for (long l1 = ((AbsStructMsg)localObject).msgId;; l1 = 0L)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", str, str, 0, 0, paramView.uin + "", "" + l1, "" + i1, "" + localRecentUserBaseData.jdField_c_of_type_Int);
        i1 = RecentUtil.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData);
        if ((paramView != null) && (paramView.lFlag == 16L) && (i1 == 0) && (this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "ad preload tool process hit");
          }
        }
        if ((paramView != null) && (String.valueOf(9970L).equals(paramView.uin)) && (this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null)) {
          this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
        }
        if ((paramView != null) && (paramView.type == 6004) && (this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null)) {
          this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
        }
        a(i1, paramView);
        if (paramRecentBaseData != null)
        {
          RecentReportHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramView);
          paramRecentBaseData.b();
          this.l = true;
        }
        if (paramView != null)
        {
          paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
          paramRecentBaseData.setFeedInfoRead(paramView.uin);
          if (FeedsManager.isShowStatus(paramView.uin)) {
            paramRecentBaseData.reportClickExpose();
          }
        }
        StartupTracker.a("AIO_Click_cost", null);
        return;
        label495:
        if (paramView.type == 6004) {
          if (paramRecentBaseData.b() <= 0) {
            break label555;
          }
        }
        for (i1 = 1;; i1 = 2)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090CC", "0X80090CC", i1, 0, "", "", "", "");
          break;
        }
      }
    }
  }
  
  public void a(View paramView, Object paramObject)
  {
    StoryHaloManager localStoryHaloManager = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(196);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick not RecentBaseData");
    }
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v == null");
      }
    }
    do
    {
      return;
      if (paramView.getId() == 2131364006)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
        paramView = new Intent(a(), ForwardRecentActivity.class);
        paramView.putExtra("forward_type", 13);
        a(paramView);
        return;
      }
      if ((paramView.getId() == 2131363896) || (paramView.getId() == 2131363897) || (paramView.getId() == 2131363898) || (paramView.getId() == 2131363899) || (paramView.getId() == 2131363900) || (paramView.getId() == 2131363901) || (paramView.getId() == 2131363902))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = ContactUtils.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 0, paramView, paramObject, null, true, null, true, true, null, null);
        return;
      }
    } while ((paramView.getId() != 2131374958) || (!localStoryHaloManager.b(paramObject)));
    localStoryHaloManager.a(paramView, (RecentItemChatMsgData)paramObject);
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    C();
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    Object localObject;
    if (this.jdField_g_of_type_Boolean)
    {
      paramString = null;
      int i1 = -1;
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        localObject = (RecentUserBaseData)paramRecentBaseData;
        paramString = ((RecentUserBaseData)localObject).a();
        i1 = ((RecentUserBaseData)localObject).i;
      }
      if (paramString != null)
      {
        RecentReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a(paramString);
      }
    }
    for (;;)
    {
      return;
      localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if ((localObject != null) && (paramRecentBaseData != null)) {}
      try
      {
        ((QCallFacade)localObject).b(paramRecentBaseData.a(), paramRecentBaseData.a());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
        if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
          if (paramRecentBaseData.a() == 3000)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.recent", 2, "delRecentCallByUin Error");
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) && (paramVipGiftDownloadInfo != null) && (paramVipGiftDownloadInfo.jdField_d_of_type_Long == 0L) && (paramVipGiftDownloadInfo.jdField_a_of_type_Long != 0L)) {
      paramVipGiftManager.a(paramVipGiftDownloadInfo.jdField_a_of_type_Long);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Conversation", 2, "onScrollStateChanged:" + paramInt);
    }
    if ((paramAbsListView instanceof ARMapHongBaoListView)) {
      ((ARMapHongBaoListView)paramAbsListView).setScrollState(paramInt);
    }
    if (paramInt != 0) {
      ApngImage.pauseByTag(2);
    }
    this.jdField_a_of_type_Int = paramInt;
    if (paramAbsListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.b(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1)) {
        break label333;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        int i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
        int i2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
        int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
        int i4 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount();
        this.jdField_b_of_type_Int = Math.max(i1, -1);
        if ((i1 >= 0) && (i1 < i4) && (i1 <= i2 - i3))
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
          if (!(localObject instanceof RecentBaseData)) {}
          do
          {
            i1 += 1;
            break;
            localObject = (RecentBaseData)localObject;
          } while ((!((RecentBaseData)localObject).a()) || (((RecentBaseData)localObject).b() <= 0));
          this.jdField_b_of_type_Int = i1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
        ThreadPriorityManager.a(false);
      }
      if (paramInt != 0) {
        break label355;
      }
      DynamicFaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      DropFrameMonitor.a().a("list_conv", false);
      ThreadRegulator.a().b(2);
      a(paramAbsListView);
      ImaxAdRecentUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      i(false);
      I();
      O();
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        if (this.l) {
          a(100L);
        }
        ApngImage.playByTag(2);
      }
      ReadinjoySPEventReport.ScrollReport.a(paramAbsListView, paramInt);
      return;
      label333:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
      ThreadPriorityManager.a(true);
      break;
      label355:
      DynamicFaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      DropFrameMonitor.a().a("list_conv");
      ThreadRegulator.a().a(2);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 0;
    if (paramInt1 + paramInt2 == paramInt3)
    {
      int i2 = ((ListView)paramAbsListView).getHeaderViewsCount();
      paramInt3 = i1;
      if (paramInt1 <= i2)
      {
        paramInt1 = paramAbsListView.getChildAt(i2 - paramInt1).getTop();
        paramInt2 = paramAbsListView.getChildAt(paramInt2 - 2).getBottom();
        paramInt3 = Math.max(0, paramInt1 + (paramAbsListView.getHeight() - paramInt2));
      }
      paramAbsListView = (AbsListView.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      if ((paramAbsListView != null) && (paramAbsListView.height != paramInt3))
      {
        paramAbsListView.height = paramInt3;
        this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramAbsListView);
      }
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = a();
    int i1 = paramRecentBaseData.a();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption == null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption = new RecentTroopMenuOption(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    }
    if (Utils.a(paramString1, localResources.getString(2131437170)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
      if (!Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[4]))) {
        break label337;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.a(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
    }
    label337:
    while (!Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[5])))
    {
      return;
      if (Utils.a(paramString1, localResources.getString(2131437169)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        break;
      }
      if (Utils.a(paramString1, localResources.getString(2131435405)))
      {
        a(i1, paramRecentBaseData, paramString2, false);
        if (i1 != 3000) {
          break;
        }
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").a();
        break;
      }
      if (!Utils.a(paramString1, localResources.getString(2131435404))) {
        break;
      }
      a(i1, paramRecentBaseData, paramString2, true);
      if (i1 != 3000) {
        break;
      }
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").a();
      break;
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1.uin, paramString1.type, 1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
  }
  
  protected void a(List paramList)
  {
    RecentUser localRecentUser;
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, src[");
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localRecentUser = (RecentUser)((Iterator)localObject).next();
          this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentUser.uin + "|" + localRecentUser.type + ",");
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("], [");
    }
    Object localObject = null;
    int i1;
    if (paramList == null)
    {
      i1 = 0;
      i1 -= 1;
      label145:
      if (i1 < 0) {
        break label572;
      }
      localRecentUser = (RecentUser)paramList.get(i1);
      if (localRecentUser != null) {
        break label191;
      }
      paramList.remove(i1);
    }
    label191:
    label611:
    label614:
    for (;;)
    {
      i1 -= 1;
      break label145;
      i1 = paramList.size();
      break;
      if ((TextUtils.isEmpty(localRecentUser.uin)) || (TextUtils.isEmpty(localRecentUser.uin.trim())))
      {
        paramList.remove(i1);
        if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel())) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(i1).append(",").append(localRecentUser.type).append(";");
        }
      }
      else if ((localRecentUser.type == 1) && ((localRecentUser.lFlag & 1L) != 0L))
      {
        if ((localObject != null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label611;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
      }
      for (;;)
      {
        if ((localObject == null) || (((HotChatManager)localObject).b(localRecentUser.uin))) {
          break label614;
        }
        paramList.remove(i1);
        if ((this.jdField_a_of_type_JavaLangStringBuilder == null) || (!QLog.isDevelopLevel())) {
          break label614;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append("invalide hotchat ").append(i1).append(",").append(localRecentUser.uin).append(";");
        break;
        if (localRecentUser.type == 3000)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label569;
          }
          DiscussionInfo localDiscussionInfo = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(localRecentUser.uin);
          if ((localDiscussionInfo == null) || (localDiscussionInfo.isUIControlFlag_Hidden_RecentUser()) || (localDiscussionInfo.isHidden()))
          {
            paramList.remove(i1);
            if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel())) {
              this.jdField_a_of_type_JavaLangStringBuilder.append("hidden_RecentUser ").append(i1).append(",").append(localRecentUser.uin).append(";");
            }
          }
          break;
        }
        if (localRecentUser.lFlag == 16L)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label569;
          }
          AdvertisementRecentUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
          break;
        }
        if ((localRecentUser.type == 10005) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          ImaxAdRecentUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
        }
        break;
        if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel()))
        {
          this.jdField_a_of_type_JavaLangStringBuilder.append("]");
          QLog.i("Q.recent", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        }
        return;
      }
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.j))
    {
      this.j = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.springBackOverScrollHeaderView();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(17, 0);
    RecentDataListManager.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)localIterator.next();
        if (localConversationPullDownActiveBase != null) {
          localConversationPullDownActiveBase.a(paramLogoutReason);
        }
      }
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.k)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception paramLogoutReason) {}
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = true;
    if ((jdField_b_of_type_Long == -1L) && (SplashActivity.jdField_a_of_type_Boolean))
    {
      jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      SosoInterface.a(jdField_b_of_type_Long);
    }
    E();
    super.a(paramBoolean);
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
    Object localObject1 = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    if (localObject1 != null) {
      this.jdField_f_of_type_Int = ((PstnManager)localObject1).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onResume, tabChange=" + paramBoolean + ", mLastPstnGaryFlag=" + this.jdField_f_of_type_Int);
    }
    if (this.jdField_e_of_type_Boolean)
    {
      if (FrameHelperActivity.a())
      {
        FrameHelperActivity.b(true);
        FrameHelperActivity.o();
      }
      this.jdField_e_of_type_Boolean = false;
    }
    TimeManager.a().c();
    M();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.c();
    }
    if (AppSetting.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(true);
    }
    this.i = true;
    a().getWindow().setSoftInputMode(32);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((VipGiftManager)localObject1).a();
      if (localObject2 != null)
      {
        a((VipGiftManager)localObject1, (VipGiftDownloadInfo)localObject2);
        if (a((VipGiftManager)localObject1, (VipGiftDownloadInfo)localObject2) == true)
        {
          localObject1 = a();
          if ((localObject1 != null) && ((localObject1 instanceof SplashActivity))) {
            ((SplashActivity)localObject1).c();
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null)
    {
      boolean bool = LoadingStateManager.a().d();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
      if (bool)
      {
        i1 = 2;
        ((BannerManager)localObject1).a(8, i1);
        LoadingStateManager.a().b(bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == 0) {
          break label684;
        }
        i1 = 1;
        label355:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
        if (i1 == 0) {
          break label689;
        }
        i1 = 2;
        label367:
        ((BannerManager)localObject1).a(33, i1);
        if (!FileViewMusicService.a().a()) {
          break label694;
        }
        i1 = 1;
        label386:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager;
        if (i1 == 0) {
          break label699;
        }
        i1 = 2;
        label398:
        ((BannerManager)localObject1).a(34, i1);
      }
    }
    else
    {
      ArkTipsManager.a().c();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_AndroidContentIntent = null;
      }
      this.jdField_a_of_type_Int = 0;
      if (!this.m) {
        break label704;
      }
      if (this.jdField_a_of_type_Long != 1000L) {
        this.jdField_a_of_type_Long = 1000L;
      }
      if (!this.n) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
      }
      if ((this.l) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      }
      a(0L);
      d();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
      label533:
      L();
      if (!this.jdField_d_of_type_Boolean) {
        break label721;
      }
      if (FrameHelperActivity.a()) {
        FrameHelperActivity.o();
      }
      this.jdField_d_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_d_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_d_of_type_Int != 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_ComTencentWidgetHongBaoListView.l = true;
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.g();
      label606:
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label744;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label739;
      }
      localObject2 = (ConversationPullDownActiveBase)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        if (this.v)
        {
          ((ConversationPullDownActiveBase)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          ((ConversationPullDownActiveBase)localObject2).h = true;
          ((ConversationPullDownActiveBase)localObject2).k();
          continue;
          i1 = 0;
          break;
          label684:
          i1 = 0;
          break label355;
          label689:
          i1 = 0;
          break label367;
          label694:
          i1 = 0;
          break label386;
          label699:
          i1 = 0;
          break label398;
          label704:
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1025, 3000L);
          break label533;
          label721:
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.h();
          break label606;
        }
        ((ConversationPullDownActiveBase)localObject2).e();
      }
    }
    label739:
    this.v = false;
    label744:
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController != null) {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController.h();
    }
    if (this.t) {
      this.t = false;
    }
    if (AppSetting.jdField_b_of_type_Boolean) {
      a().setTitle(a(2131433284));
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new slb(this), 500L);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      PhoneContactSelectActivity.a(a(), this.jdField_c_of_type_Boolean, 1400);
    }
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(System.currentTimeMillis());
    ReadInJoyUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i1 = QZoneReport.a();
    if (i1 >= 0)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134061);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134061, i1 * 1000L);
    }
    if (!SharedPreUtils.j(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
      if ((localObject3 == null) || (((List)localObject3).size() == 0))
      {
        SharedPreUtils.l(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        return;
      }
      localObject1 = new ArrayList();
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
        if ((localRecentUser.type == 1) && (localRecentUser.showUpTime > 0L))
        {
          ((TroopManager)localObject2).a(localRecentUser.uin, localRecentUser.showUpTime);
          ((ArrayList)localObject1).add(localRecentUser.uin);
          a(9, localRecentUser.uin, 1);
        }
      }
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (SharedPreUtils.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).contains(localObject3)) {
          ((ArrayList)localObject1).remove(localObject3);
        }
      }
      if (((ArrayList)localObject1).size() == 0)
      {
        SharedPreUtils.l(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        return;
      }
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a((List)localObject1, 0);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new slc(this), 5000L);
    a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
    ImaxAdRecentUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
    PublicAccountManager.a().jdField_a_of_type_Boolean = false;
    if (paramBoolean) {
      this.x = true;
    }
    for (;;)
    {
      i(true);
      I();
      p();
      ApngImage.playByTag(2);
      if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1053)) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1053, 500L);
      }
      localObject1 = (NowHongbaoPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(265);
      if (localObject1 != null) {
        ((NowHongbaoPushManager)localObject1).c();
      }
      this.h = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.m();
      return;
      this.x = false;
      if (this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null) {
        this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "updateLoadingState, showLoadingCircle = " + paramBoolean1);
    }
    if (paramBoolean1) {
      if (this.jdField_c_of_type_AndroidWidgetImageView == null)
      {
        if (this.jdField_a_of_type_AndroidWidgetRadioGroup.getVisibility() != 0) {
          break label201;
        }
        i1 = this.jdField_a_of_type_AndroidWidgetRadioGroup.getId();
        this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(a());
        this.jdField_c_of_type_AndroidWidgetImageView.setId(2131365713);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, i1);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(7.0F * DeviceInfoUtil.a()));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      }
    }
    label201:
    while ((this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
      try
      {
        Object localObject = a().getResources().getDrawable(2130838604);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        if ((localObject instanceof Animatable)) {
          ((Animatable)localObject).start();
        }
        if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        return;
        int i1 = this.jdField_a_of_type_AndroidWidgetTextView.getId();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean a()
  {
    if (FrameHelperActivity.a())
    {
      FrameHelperActivity.o();
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
      if (localPortalManager != null) {
        localPortalManager.a(a(), false);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onViewCompleteVisableAndReleased %s", new Object[] { Boolean.valueOf(this.j) }));
    }
    return a(paramListView);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (((!this.i) && (paramMessage.arg1 == 0)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "isRefreshRecentDataNecessary[isForeground:" + this.i + ",msg.arg1:" + paramMessage.arg1 + ",isLogin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin());
      }
      return false;
    }
    return true;
  }
  
  public boolean a(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if ((paramVipGiftDownloadInfo == null) || (paramVipGiftManager == null)) {}
    do
    {
      return false;
      if (paramVipGiftDownloadInfo.jdField_d_of_type_Long == 3L) {
        paramVipGiftManager.a(4L, paramVipGiftDownloadInfo.jdField_a_of_type_Long);
      }
    } while ((paramVipGiftDownloadInfo == null) || (paramVipGiftDownloadInfo.jdField_d_of_type_Long != 2L) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c()) || (!this.w));
    return true;
  }
  
  public boolean a(ListView paramListView)
  {
    if ((paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) || (this.j)) {}
    do
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
      }
      if (!((PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78)).c())
      {
        this.j = true;
        d(true);
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(40001, 500L);
        return true;
      }
      if (!((NowEnterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).e())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "[handlePullRefresh] abort real refresh");
        }
        this.j = true;
        d(true);
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(40001, 500L);
        return true;
      }
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      StartupTracker.a("Conversation_PullToRefresh_start", 0L);
      l();
      ThreadManager.getSubThreadHandler().post(new snn(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      }
      if (((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).jdField_a_of_type_Boolean)
      {
        ((MsgTabStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250)).a().a(2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "MsgTabNodeListLoader update data");
        }
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1054);
    } while (!QLog.isDevelopLevel());
    QLog.i("MedalWallMng", 4, "send MSG_CHECK_MEDAL_GUIDE");
    return true;
  }
  
  public boolean a(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = paramString2;
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "showNowEntrance : isShow=" + paramBoolean + ",logoUrl=" + paramString1 + ",jumpUrl=" + paramString2 + ",nowFloatEnterHide:" + this.h);
    }
    if (this.h)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return false;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString1)))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramString2 = a().getDrawable(2130839557);
    }
    for (;;)
    {
      try
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramString2;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramString2;
        paramString1 = URLDrawable.getDrawable(paramString1, (URLDrawable.URLDrawableOptions)localObject);
        if (paramString1.getStatus() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 1, "URLDrawable's status is SUCCESSED.");
          }
          localObject = (NowHongbaoPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(265);
          if (localObject != null)
          {
            long l1 = ((NowHongbaoPushManager)localObject).a(2);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "year_icon", "bottomicon_view", 0, 0, "" + l1, "", "", "");
          }
          paramBoolean = true;
        }
      }
      catch (Exception paramString1)
      {
        bool = false;
      }
      try
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString1);
        return paramBoolean;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          bool = paramBoolean;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 1, "start load URLDrawable.");
      }
      if (paramString1.getStatus() == 2)
      {
        paramString1.restartDownload();
        paramBoolean = false;
      }
      else
      {
        paramString1.startDownload(true);
        paramBoolean = false;
        continue;
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString2);
        paramBoolean = bool;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.recent", 1, "URLDrawable download excpetion:" + paramString1.toString());
          paramBoolean = bool;
          continue;
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          paramBoolean = false;
        }
      }
    }
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b()
  {
    t();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.q();
    }
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.n();
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)localIterator.next();
        if (localConversationPullDownActiveBase != null) {
          localConversationPullDownActiveBase.g();
        }
      }
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845951);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131494218));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.k();
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (!this.j) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public void b(long paramLong)
  {
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramLong);
    }
  }
  
  public void b(View paramView) {}
  
  protected void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    ArrayList localArrayList;
    for (;;)
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(paramList);
      this.jdField_a_of_type_JavaLangStringBuilder.append("unreadinfo, [");
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
        if ((localRecentBaseData != null) && (localRecentBaseData.jdField_c_of_type_Int > 0)) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentBaseData.a()).append("-").append(localRecentBaseData.a()).append("-").append(localRecentBaseData.jdField_c_of_type_Int).append("-").append(localRecentBaseData.jdField_b_of_type_Int).append(" , ");
        }
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("]");
    localArrayList.clear();
    QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  /* Error */
  protected void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 405	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 763
    //   9: iconst_2
    //   10: new 409	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 410	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 2980
    //   20: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 421	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 425	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 795	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   37: invokevirtual 2983	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   40: ifge +11 -> 51
    //   43: aload_0
    //   44: getfield 587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   47: iconst_0
    //   48: invokevirtual 2986	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 2988	com/tencent/mobileqq/activity/Conversation:h	(Z)V
    //   56: iload_1
    //   57: ifeq +355 -> 412
    //   60: invokestatic 393	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   63: invokevirtual 2989	com/tencent/mobileqq/managers/LoadingStateManager:a	()V
    //   66: invokestatic 676	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentDataListManager;
    //   69: invokevirtual 2611	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()V
    //   72: aload_0
    //   73: getfield 1269	com/tencent/mobileqq/activity/Conversation:j	Z
    //   76: ifeq +22 -> 98
    //   79: aload_0
    //   80: getfield 587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   83: ifnull +15 -> 98
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 1269	com/tencent/mobileqq/activity/Conversation:j	Z
    //   91: aload_0
    //   92: getfield 587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   95: invokevirtual 2992	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   98: aload_0
    //   99: getfield 433	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   102: ifnull +15 -> 117
    //   105: aload_0
    //   106: getfield 433	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   109: invokevirtual 2993	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 433	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   117: aload_0
    //   118: getfield 452	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   121: ifnull +15 -> 136
    //   124: aload_0
    //   125: getfield 452	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   128: invokevirtual 460	android/app/Dialog:dismiss	()V
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 452	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   136: aload_0
    //   137: getfield 624	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar	Lcom/tencent/mobileqq/activity/recent/LocalSearchBar;
    //   140: ifnull +14 -> 154
    //   143: aload_0
    //   144: getfield 624	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar	Lcom/tencent/mobileqq/activity/recent/LocalSearchBar;
    //   147: aload_0
    //   148: getfield 440	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   151: invokevirtual 2994	com/tencent/mobileqq/activity/recent/LocalSearchBar:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   154: aload_0
    //   155: getfield 1794	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   158: ifnull +14 -> 172
    //   161: aload_0
    //   162: getfield 1794	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   165: aload_0
    //   166: getfield 440	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: invokevirtual 2995	com/tencent/mobileqq/activity/recent/RecentTroopMenuOption:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   172: aload_0
    //   173: getfield 361	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   176: ifnull +25 -> 201
    //   179: aload_0
    //   180: getfield 361	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   183: aload_0
    //   184: getfield 440	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   187: invokevirtual 2996	com/tencent/mobileqq/activity/recent/RecentAdapter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   190: aload_0
    //   191: iconst_1
    //   192: bipush 10
    //   194: lconst_0
    //   195: invokestatic 1453	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: invokevirtual 1456	com/tencent/mobileqq/activity/Conversation:a	(IILjava/lang/Object;)V
    //   201: aload_0
    //   202: getfield 587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   205: ifnull +11 -> 216
    //   208: aload_0
    //   209: getfield 587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   212: iconst_0
    //   213: invokevirtual 1474	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   216: aload_0
    //   217: iconst_0
    //   218: invokespecial 1152	com/tencent/mobileqq/activity/Conversation:g	(Z)V
    //   221: aload_0
    //   222: getfield 1299	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager	Lcom/tencent/biz/qqstory/msgTabNode/view/MsgTabStoryNodeListManager;
    //   225: ifnull +14 -> 239
    //   228: aload_0
    //   229: getfield 1299	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager	Lcom/tencent/biz/qqstory/msgTabNode/view/MsgTabStoryNodeListManager;
    //   232: aload_0
    //   233: getfield 440	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   236: invokevirtual 2997	com/tencent/biz/qqstory/msgTabNode/view/MsgTabStoryNodeListManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   239: ldc_w 763
    //   242: ldc_w 2999
    //   245: invokestatic 3003	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_0
    //   249: sipush 1055
    //   252: lconst_0
    //   253: iconst_0
    //   254: invokevirtual 449	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   257: aload_0
    //   258: getfield 631	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   261: ifnull +10 -> 271
    //   264: aload_0
    //   265: getfield 631	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   268: invokevirtual 3004	com/tencent/mobileqq/activity/recent/BannerManager:d	()V
    //   271: aload_0
    //   272: getfield 163	com/tencent/mobileqq/activity/Conversation:m	Z
    //   275: ifeq +13 -> 288
    //   278: aload_0
    //   279: getfield 843	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   282: bipush 12
    //   284: invokevirtual 1254	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   287: pop
    //   288: aload_0
    //   289: getfield 683	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   292: getfield 688	com/tencent/mobileqq/app/FrameHelperActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   295: iconst_4
    //   296: invokevirtual 1533	android/os/Handler:sendEmptyMessage	(I)Z
    //   299: pop
    //   300: aload_0
    //   301: sipush 1035
    //   304: ldc2_w 2493
    //   307: iconst_0
    //   308: invokevirtual 449	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   311: aload_0
    //   312: sipush 1010
    //   315: ldc2_w 2493
    //   318: iconst_1
    //   319: invokevirtual 449	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   322: aload_0
    //   323: aload_0
    //   324: getfield 440	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   327: bipush 75
    //   329: invokevirtual 897	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   332: checkcast 2435	com/tencent/mobileqq/vipgift/VipGiftManager
    //   335: putfield 173	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager	Lcom/tencent/mobileqq/vipgift/VipGiftManager;
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 440	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   343: sipush 142
    //   346: invokevirtual 897	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   349: checkcast 2632	com/tencent/mobileqq/qcall/PstnManager
    //   352: invokevirtual 2633	com/tencent/mobileqq/qcall/PstnManager:a	()I
    //   355: putfield 2635	com/tencent/mobileqq/activity/Conversation:jdField_f_of_type_Int	I
    //   358: invokestatic 405	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +33 -> 394
    //   364: ldc_w 763
    //   367: iconst_2
    //   368: new 409	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 410	java/lang/StringBuilder:<init>	()V
    //   375: ldc_w 3006
    //   378: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_0
    //   382: getfield 2635	com/tencent/mobileqq/activity/Conversation:jdField_f_of_type_Int	I
    //   385: invokevirtual 1471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 425	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 428	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: aload_0
    //   395: invokespecial 787	com/tencent/mobileqq/activity/Conversation:N	()V
    //   398: aload_0
    //   399: getfield 717	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController	Lcom/tencent/mobileqq/now/enter/ConversationNowController;
    //   402: ifnull +10 -> 412
    //   405: aload_0
    //   406: getfield 717	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController	Lcom/tencent/mobileqq/now/enter/ConversationNowController;
    //   409: invokevirtual 3008	com/tencent/mobileqq/now/enter/ConversationNowController:j	()V
    //   412: aload_0
    //   413: sipush 10001
    //   416: ldc2_w 1287
    //   419: iconst_0
    //   420: invokevirtual 449	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   423: aload_0
    //   424: getfield 440	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   427: invokevirtual 1383	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   430: ifne +15 -> 445
    //   433: aload_0
    //   434: getfield 163	com/tencent/mobileqq/activity/Conversation:m	Z
    //   437: ifeq +8 -> 445
    //   440: aload_0
    //   441: lconst_0
    //   442: invokevirtual 2495	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   445: aload_0
    //   446: ldc_w 3009
    //   449: ldc2_w 3010
    //   452: iconst_0
    //   453: invokevirtual 449	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   456: invokestatic 976	com/tencent/biz/pubaccount/PublicAccountManager:a	()Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   459: aload_0
    //   460: getfield 440	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   463: invokevirtual 807	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   466: invokevirtual 3012	com/tencent/biz/pubaccount/PublicAccountManager:a	(Ljava/lang/String;)V
    //   469: return
    //   470: astore_2
    //   471: aload_0
    //   472: aconst_null
    //   473: putfield 433	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   476: goto -359 -> 117
    //   479: astore_2
    //   480: aload_0
    //   481: aconst_null
    //   482: putfield 433	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog	Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   485: aload_2
    //   486: athrow
    //   487: astore_2
    //   488: aload_0
    //   489: aconst_null
    //   490: putfield 452	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   493: goto -357 -> 136
    //   496: astore_2
    //   497: aload_0
    //   498: aconst_null
    //   499: putfield 452	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   502: aload_2
    //   503: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	Conversation
    //   0	504	1	paramBoolean	boolean
    //   470	1	2	localException1	Exception
    //   479	7	2	localObject1	Object
    //   487	1	2	localException2	Exception
    //   496	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   105	112	470	java/lang/Exception
    //   105	112	479	finally
    //   124	131	487	java/lang/Exception
    //   124	131	496	finally
  }
  
  public View c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_c_of_type_AndroidViewView;
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (int i1 = this.jdField_a_of_type_AndroidWidgetRadioGroup.getId();; i1 = this.jdField_a_of_type_AndroidWidgetTextView.getId())
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.addRule(0, i1);
        this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public boolean c()
  {
    return this.i;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "refreshRecentHeadView|mChatAdapter is null.");
      }
      return;
    }
    Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(7);
    this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void d(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(8);
    if (paramBoolean)
    {
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(4);
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(3);
    }
    if ((bool1) || (bool2)) {
      a(false, true);
    }
    do
    {
      do
      {
        return;
        switch (LoadingStateManager.a().a())
        {
        default: 
          return;
        case 0: 
        case 3: 
          a(false, false);
          return;
        case 1: 
          a(true, false);
        }
      } while (this.jdField_c_of_type_MqqOsMqqHandler.hasMessages(4));
      this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(4, 180000L);
      return;
      a(true, false);
    } while (this.jdField_c_of_type_MqqOsMqqHandler.hasMessages(3));
    this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 180000L);
    return;
    a(false, true);
  }
  
  protected boolean d()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1);
  }
  
  protected void e()
  {
    super.e();
    if (SystemClock.uptimeMillis() - MsgTabStoryNodeListManager.jdField_b_of_type_Long > 500L)
    {
      z();
      if ((this.w) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof HongBaoListView)) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mEnableStory) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mForStory)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.j();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onFrameTabClick|mIsChatList:" + this.jdField_g_of_type_Boolean);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
    }
  }
  
  protected void f()
  {
    H();
    r();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.f();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)localIterator.next();
        if (localConversationPullDownActiveBase != null) {
          localConversationPullDownActiveBase.j();
        }
      }
    }
    this.A = false;
    this.B = false;
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController != null) {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController.k();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134061);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    QZoneReport.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "notifyCallTabChanged, changed=" + paramBoolean);
    }
    this.p = paramBoolean;
  }
  
  protected void g()
  {
    StartupTracker.a(null, "Recent_OnCreate");
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl = new ConversationHotChatCtrl(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getRecentThreadLooper(), this);
    D();
    b(false);
    StartupTracker.a("Recent_OnCreate", null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.k) || (a() == null) || (a().isFinishing())) {
      return true;
    }
    TraceUtils.a("conv.handleMessage");
    long l1 = System.currentTimeMillis();
    boolean bool1;
    int i1;
    int i2;
    label632:
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
    case 10: 
    case 9: 
    case 8: 
      for (;;)
      {
        TraceUtils.a();
        return true;
        if (!a(paramMessage)) {
          return true;
        }
        ((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254)).b();
        TroopAssistantManager.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        A();
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        boolean bool2 = false;
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b()) {
            bool1 = true;
          }
        }
        Object localObject1 = paramMessage.a(bool1);
        a((List)localObject1);
        paramMessage = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject4 = a();
        if (localObject1 != null)
        {
          i1 = ((List)localObject1).size();
          ConversationDataFactory.a((List)localObject1, (QQAppInterface)localObject3, (Context)localObject4, paramMessage, i1);
        }
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_JavaUtilComparator);
          s();
          localObject1 = new ArrayList(paramMessage);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, localObject1).sendToTarget();
          b(paramMessage);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {}
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          localObject1 = new HashMap();
          ((HashMap)localObject1).put(BaseConstants.RDM_NoChangeFailCode, "");
          StatisticCollector.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject1, "");
          localObject1 = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(196);
          ((StoryHaloManager)localObject1).b(3, ((StoryHaloManager)localObject1).a(paramMessage));
          StartupTracker.a("Conversation_Refresh_global", System.currentTimeMillis() - l1);
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("Q.recent", 4, "REFRESH_FLAG_GLOBAL, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
          continue;
          i1 = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (!a(paramMessage)) {
          return true;
        }
        if (QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        A();
        localObject3 = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
        a((List)localObject4);
        ((List)localObject3).clear();
        RecentUser localRecentUser;
        String str;
        if (localObject4 == null)
        {
          i1 = 0;
          i2 = 0;
          if (i2 >= i1) {
            break label824;
          }
          localRecentUser = (RecentUser)((List)localObject4).get(i2);
          str = RecentDataListManager.a(localRecentUser.uin, localRecentUser.type);
          localObject2 = RecentDataListManager.a().a(str);
          if (localObject2 != null) {
            break label747;
          }
          localObject2 = ConversationDataFactory.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          paramMessage = (Message)localObject2;
          if (localObject2 != null)
          {
            RecentDataListManager.a().a((RecentBaseData)localObject2, str);
            paramMessage = (Message)localObject2;
          }
        }
        for (;;)
        {
          if (paramMessage != null) {
            ((List)localObject3).add(paramMessage);
          }
          i2 += 1;
          break label632;
          i1 = ((List)localObject4).size();
          break;
          if (!this.jdField_b_of_type_JavaUtilList.contains(str))
          {
            paramMessage = (Message)localObject2;
            if (!this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(localRecentUser.uin, -2147483648))) {}
          }
          else
          {
            if ((localObject2 instanceof RecentUserBaseData)) {
              ((RecentUserBaseData)localObject2).a(localRecentUser);
            }
            ((RecentBaseData)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
            paramMessage = (Message)localObject2;
          }
        }
        try
        {
          Collections.sort((List)localObject3, this.jdField_a_of_type_JavaUtilComparator);
          s();
          paramMessage = new ArrayList((Collection)localObject3);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
          b((List)localObject3);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.e();
          }
          if (this.jdField_c_of_type_Int <= 9) {
            this.jdField_c_of_type_Int = 0;
          }
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          paramMessage = new HashMap();
          paramMessage.put(BaseConstants.RDM_NoChangeFailCode, "");
          StatisticCollector.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - l1, ((List)localObject3).size(), paramMessage, "");
          StartupTracker.a("Conversation_Refresh_part", System.currentTimeMillis() - l1);
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("Q.recent", 4, "REFRESH_FLAG_PART, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            paramMessage.printStackTrace();
          }
        }
        if (!a(paramMessage)) {
          return true;
        }
        paramMessage = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
        i2 = paramMessage.size();
        localObject2 = new ArrayList(i2);
        i1 = 0;
        if (i1 < i2) {
          for (;;)
          {
            try
            {
              localObject3 = (RecentBaseData)paramMessage.get(i1);
              if (localObject3 == null) {
                i1 += 1;
              }
            }
            catch (Exception paramMessage)
            {
              if (QLog.isDevelopLevel()) {
                QLog.e("Q.recent", 4, paramMessage.toString());
              }
              return true;
            }
            localObject4 = RecentDataListManager.a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
            if ((this.jdField_b_of_type_JavaUtilList.contains(localObject4)) || (this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(((RecentBaseData)localObject3).a(), -2147483648))))
            {
              ((RecentBaseData)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
              ((List)localObject2).add(localObject3);
            }
          }
        }
        s();
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1019, 0, 0, localObject2).sendToTarget();
        b(paramMessage);
        if (this.jdField_c_of_type_Int <= 8)
        {
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_JavaUtilList.clear();
        }
        this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
        this.jdField_d_of_type_Long = System.currentTimeMillis();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
        StatisticCollector.a(BaseApplication.getContext()).a(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - l1, paramMessage.size(), (HashMap)localObject2, "");
        StartupTracker.a("Conversation_Refresh_items", System.currentTimeMillis() - l1);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + l1 + "," + (System.currentTimeMillis() - l1) + "]");
        }
      }
    case 11: 
      label747:
      bool1 = a(paramMessage);
      label824:
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "REFRESH_FLAG_RECENT_ITEMS, [" + paramMessage.arg1 + "," + paramMessage.arg2 + "," + paramMessage.obj + "," + this.m + "," + bool1 + "]");
      }
      if (!bool1) {
        return true;
      }
      i2 = paramMessage.arg2;
      if ((i2 == 8) || (i2 == 9))
      {
        localObject2 = null;
        if ((paramMessage.obj instanceof String)) {
          localObject2 = (String)paramMessage.obj;
        }
        if ((localObject2 != null) && (!this.jdField_b_of_type_JavaUtilList.contains(localObject2))) {
          this.jdField_b_of_type_JavaUtilList.add(localObject2);
        }
        l1 = 0L;
      }
      break;
    }
    for (;;)
    {
      if (i2 >= this.jdField_c_of_type_Int)
      {
        i1 = 8;
        for (;;)
        {
          if (i1 < i2)
          {
            this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(i1);
            i1 += 1;
            continue;
            if (!(paramMessage.obj instanceof Long)) {
              break label2000;
            }
            l1 = ((Long)paramMessage.obj).longValue();
            break;
          }
        }
        this.jdField_c_of_type_Int = i2;
      }
      if ((!this.m) || (this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(this.jdField_c_of_type_Int))) {
        break;
      }
      long l2 = Math.abs(System.currentTimeMillis() - this.jdField_d_of_type_Long);
      l1 = Math.max(this.jdField_a_of_type_Long - l2, l1);
      localObject2 = Message.obtain();
      ((Message)localObject2).arg1 = paramMessage.arg1;
      ((Message)localObject2).what = this.jdField_c_of_type_Int;
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject2, l1);
      break;
      TroopAssistantManager.a().i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = ServiceAccountFolderManager.a();
      if (paramMessage != null) {
        paramMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramMessage = TroopBarAssistantManager.a();
      if (paramMessage != null) {
        paramMessage.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessage = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80);
      if (paramMessage != null) {
        paramMessage.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      for (;;)
      {
        paramMessage = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
        if (paramMessage != null) {
          paramMessage.e();
        }
        paramMessage = (GroupVideoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235);
        if (paramMessage != null) {
          paramMessage.a(true);
        }
        paramMessage = (HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254);
        if (paramMessage != null) {
          paramMessage.a();
        }
        paramMessage = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(196);
        paramMessage.a(1, paramMessage.a(this.jdField_a_of_type_JavaUtilList));
        break;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
        }
      }
      h(true);
      break;
      a(new slk(this));
      break;
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1044, 0, 0, null).sendToTarget();
      break;
      paramMessage = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(196);
      paramMessage.a(2, paramMessage.a(RecentDataListManager.a().jdField_a_of_type_JavaUtilList));
      break;
      label2000:
      l1 = 0L;
    }
  }
  
  public void i()
  {
    ApngImage.pauseByTag(2);
    super.i();
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.j();
    if (jdField_b_of_type_Long > 0L)
    {
      jdField_b_of_type_Long = 0L;
      SosoInterface.a(jdField_b_of_type_Long);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)localIterator.next();
        if (localConversationPullDownActiveBase != null) {
          localConversationPullDownActiveBase.f();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController != null) {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController.i();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1053);
    this.C = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    M();
    if (AppSetting.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
    }
    TimeManager.a().b();
    this.i = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.u();
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.b();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10000);
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.u();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o = false;
    ReadInJoyUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null) {
      this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null) {
      this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    QZoneReport.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.n();
    }
    ReadinjoySPEventReport.k();
  }
  
  public void j()
  {
    super.j();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.f();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null) {
      this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    }
    NowHongbaoPushManager localNowHongbaoPushManager = (NowHongbaoPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(265);
    if (localNowHongbaoPushManager != null) {
      localNowHongbaoPushManager.d();
    }
  }
  
  protected void k()
  {
    this.k = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeTipsDialog.a(null);
    }
    TimeManager.a().a();
    H();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_c_of_type_MqqOsMqqHandler != null) {
      this.jdField_c_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    TroopAssistantManager.a();
    TroopRemindSettingManager.a();
    TroopBarAssistantManager.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.g();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)localIterator.next();
        if (localConversationPullDownActiveBase != null) {
          localConversationPullDownActiveBase.l();
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController != null) {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController.l();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    this.jdField_b_of_type_Boolean = false;
    super.k();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1058);
      }
      this.j = true;
      B();
      d(true);
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(1);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(8);
      if ((bool1) || (bool2)) {
        c(800L);
      }
    }
    else
    {
      return;
    }
    if (ReadInJoyHelper.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      ReadinjoySPEventReport.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d();
    c(60000L);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void m()
  {
    this.i = true;
    if ((!this.m) && (!this.k))
    {
      x();
      StartupTracker.a("Recent_Start", null);
    }
    while (!this.m) {
      return;
    }
    a(1030, 0L, true);
  }
  
  public void n()
  {
    long l1 = 0L;
    try
    {
      if (!this.o)
      {
        boolean bool = this.k;
        if (!bool) {
          break label23;
        }
      }
    }
    finally
    {
      try
      {
        label23:
        BaseActivity localBaseActivity;
        LayoutInflater localLayoutInflater;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130969237, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar = new RecentOptPopBar(localBaseActivity);
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new skx(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = ((VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75));
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label350;
        }
      }
      localObject1 = finally;
    }
    return;
    this.o = true;
    localBaseActivity = a();
    localLayoutInflater = LayoutInflater.from(localBaseActivity);
    Object localObject2 = "in main thread ";
    label208:
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, (String)localObject2 + localException2.toString());
    }
    for (;;)
    {
      try
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("device_mode", DeviceInfoUtil.e());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
        String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label378;
        }
        localStatisticCollector.a(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
      }
      catch (Exception localException1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent", 2, localException1.toString());
      break;
      label350:
      String str1 = "not in main thread ";
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar = null;
      this.o = false;
      break label208;
      label378:
      l1 = 1L;
    }
  }
  
  /* Error */
  public void o()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 165	com/tencent/mobileqq/activity/Conversation:n	Z
    //   6: ifne +12 -> 18
    //   9: aload_0
    //   10: getfield 148	com/tencent/mobileqq/activity/Conversation:k	Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 165	com/tencent/mobileqq/activity/Conversation:n	Z
    //   26: aload_0
    //   27: getfield 167	com/tencent/mobileqq/activity/Conversation:o	Z
    //   30: ifne +7 -> 37
    //   33: aload_0
    //   34: invokevirtual 3330	com/tencent/mobileqq/activity/Conversation:n	()V
    //   37: aload_0
    //   38: invokevirtual 2951	com/tencent/mobileqq/activity/Conversation:t	()V
    //   41: aload_0
    //   42: getfield 729	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   45: aload_0
    //   46: invokevirtual 579	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   49: aload_0
    //   50: invokespecial 2627	com/tencent/mobileqq/activity/Conversation:E	()V
    //   53: aload_0
    //   54: getfield 587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   57: aload_0
    //   58: getfield 1303	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader	Lcom/tencent/mobileqq/widget/PullRefreshHeader;
    //   61: invokevirtual 3333	com/tencent/mobileqq/fpsreport/FPSSwipListView:setOverScrollHeader	(Landroid/view/View;)V
    //   64: aload_0
    //   65: getfield 587	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   68: aload_0
    //   69: invokevirtual 3254	com/tencent/mobileqq/fpsreport/FPSSwipListView:setOverScrollListener	(Lcom/tencent/widget/OverScrollViewListener;)V
    //   72: aload_0
    //   73: getfield 631	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   76: ifnull +17 -> 93
    //   79: aload_0
    //   80: getfield 507	com/tencent/mobileqq/activity/Conversation:jdField_g_of_type_Boolean	Z
    //   83: ifeq +10 -> 93
    //   86: aload_0
    //   87: getfield 631	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   90: invokevirtual 3334	com/tencent/mobileqq/activity/recent/BannerManager:f	()V
    //   93: aload_0
    //   94: getfield 631	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   97: ifnull +11 -> 108
    //   100: aload_0
    //   101: getfield 631	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   104: iconst_0
    //   105: invokevirtual 3335	com/tencent/mobileqq/activity/recent/BannerManager:a	(Z)V
    //   108: aload_0
    //   109: sipush 1010
    //   112: lconst_0
    //   113: iconst_0
    //   114: invokevirtual 449	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   117: aload_0
    //   118: sipush 1023
    //   121: lconst_0
    //   122: iconst_0
    //   123: invokevirtual 449	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   126: ldc_w 763
    //   129: ldc_w 3337
    //   132: invokestatic 3003	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: sipush 1055
    //   139: lconst_0
    //   140: iconst_0
    //   141: invokevirtual 449	com/tencent/mobileqq/activity/Conversation:a	(IJZ)V
    //   144: aload_0
    //   145: invokespecial 797	com/tencent/mobileqq/activity/Conversation:C	()V
    //   148: aload_0
    //   149: getfield 843	com/tencent/mobileqq/activity/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   152: bipush 12
    //   154: invokevirtual 1254	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   157: pop
    //   158: aload_0
    //   159: invokespecial 3339	com/tencent/mobileqq/activity/Conversation:K	()V
    //   162: aload_0
    //   163: getfield 3340	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   166: ifnonnull +69 -> 235
    //   169: aload_0
    //   170: invokestatic 3345	com/tencent/mobileqq/ar/ARDeviceController:a	()Lcom/tencent/mobileqq/ar/ARDeviceController;
    //   173: invokevirtual 3346	com/tencent/mobileqq/ar/ARDeviceController:a	()Ljava/lang/String;
    //   176: putfield 3340	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   179: aload_0
    //   180: getfield 3340	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   183: ifnonnull +52 -> 235
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 517	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   191: ldc_w 3347
    //   194: invokevirtual 519	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   197: checkcast 526	android/widget/RelativeLayout
    //   200: putfield 3349	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   203: new 3351	android/opengl/GLSurfaceView
    //   206: dup
    //   207: aload_0
    //   208: invokevirtual 366	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   211: invokespecial 3352	android/opengl/GLSurfaceView:<init>	(Landroid/content/Context;)V
    //   214: astore_2
    //   215: aload_2
    //   216: new 3354	sky
    //   219: dup
    //   220: aload_0
    //   221: invokespecial 3355	sky:<init>	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   224: invokevirtual 3359	android/opengl/GLSurfaceView:setRenderer	(Landroid/opengl/GLSurfaceView$Renderer;)V
    //   227: aload_0
    //   228: getfield 3349	com/tencent/mobileqq/activity/Conversation:jdField_c_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   231: aload_2
    //   232: invokevirtual 3360	android/widget/RelativeLayout:addView	(Landroid/view/View;)V
    //   235: invokestatic 405	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq -220 -> 18
    //   241: ldc_w 3362
    //   244: iconst_2
    //   245: new 409	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 410	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 3364
    //   255: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: getfield 3340	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   262: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 425	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 428	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: goto -253 -> 18
    //   274: astore_2
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_2
    //   278: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	Conversation
    //   13	2	1	bool	boolean
    //   214	18	2	localGLSurfaceView	android.opengl.GLSurfaceView
    //   274	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	274	finally
    //   21	37	274	finally
    //   37	93	274	finally
    //   93	108	274	finally
    //   108	235	274	finally
    //   235	271	274	finally
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (paramInt == 2131363992)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
        paramRadioGroup = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
        if (paramRadioGroup != null) {
          paramRadioGroup.g();
        }
      }
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.p = false;
      paramRadioGroup = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      if (paramRadioGroup != null) {
        paramRadioGroup.b(MessageCache.a());
      }
      paramRadioGroup = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78);
      if (this.t)
      {
        if (paramRadioGroup != null) {
          paramRadioGroup.a(null, 3, false, 0L);
        }
        this.t = false;
      }
      for (;;)
      {
        a(100L);
        if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao != null) {
          this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.e();
        }
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          break;
        }
        paramRadioGroup = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramRadioGroup.hasNext())
        {
          localObject = (ConversationPullDownActiveBase)paramRadioGroup.next();
          if (localObject != null) {
            ((ConversationPullDownActiveBase)localObject).h();
          }
        }
        if (this.u)
        {
          q();
          this.u = false;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.g();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_g_of_type_Boolean) {}
    for (paramRadioGroup = "0";; paramRadioGroup = "1")
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Msg_tab", "Call_history_tab", 0, 0, paramRadioGroup, "", "", "");
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getWidth() - a().getDimensionPixelSize(2131558949) - a().getDimensionPixelSize(2131558953), a().getDimensionPixelSize(2131558954));
      if ((CmGameUtil.c() <= 0) || (CmGameUtil.b() <= 0)) {
        break label640;
      }
    }
    label640:
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_f_of_type_Boolean = false;
      }
      for (int i2 = 1;; i2 = 0)
      {
        VipUtils.a(CmGameUtil.a(), "cmshow", "Apollo", "plusentrance", 0, 0, new String[] { "" + i1, "" + i2 });
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
        StoryReportor.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
        boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_F2F_REDPACK_IS_SHOWED", false);
        boolean bool2 = QWalletSetting.a(a().getCurrentAccountUin(), "F2FRedpackEntry", false);
        if ((!bool1) && (bool2)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_F2F_REDPACK_IS_SHOWED", true);
        }
        if (!this.s) {
          RedBagVideoManager.a(RedBagVideoManager.f);
        }
        N();
        do
        {
          do
          {
            do
            {
              return;
              if (paramView != this.jdField_a_of_type_ComTencentImageURLImageView) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.e("Q.recent", 2, "click mNowFloatPendantLogo btn, url=" + this.jdField_c_of_type_JavaLangString);
              }
            } while (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString));
            if ((this.jdField_c_of_type_JavaLangString.startsWith("http://")) || (this.jdField_c_of_type_JavaLangString.startsWith("https://")))
            {
              paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
              paramView.putExtra("url", this.jdField_c_of_type_JavaLangString);
              a(paramView);
            }
            for (;;)
            {
              paramView = (NowHongbaoPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(265);
              if (paramView == null) {
                break;
              }
              l1 = paramView.a(2);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "year_icon", "bottomicon_click", 0, 0, "" + l1, "", "", "");
              return;
              paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), this.jdField_c_of_type_JavaLangString);
              if (paramView != null) {
                paramView.b();
              }
            }
          } while (paramView != this.jdField_b_of_type_AndroidWidgetImageView);
          if (QLog.isColorLevel()) {
            QLog.e("Q.recent", 2, "click mNowFloatPendantClose btn");
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          paramView = (NowHongbaoPushManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(265);
        } while (paramView == null);
        paramView.a(2, false);
        long l1 = paramView.a(2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "year_icon", "bottomicon_close", 0, 0, "" + l1, "", "", "");
        return;
      }
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView) {}
  
  void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.m)) {}
    label124:
    for (;;)
    {
      return;
      if (((EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87)).b())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
            if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1) instanceof RecentItemEcShopAssitant)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!PublicAccountManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession == null)) {
            break label124;
          }
          this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.a();
          return;
          i1 += 1;
          break;
        }
      }
    }
  }
  
  void q()
  {
    if (this.jdField_g_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131363999));
      this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_g_of_type_AndroidViewView = a(2131363423);
    }
    if (this.jdField_g_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  void r()
  {
    if ((this.jdField_g_of_type_AndroidViewView != null) && (this.jdField_g_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void s()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
          int i2 = QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localQQMessageFacade != null) {
            i1 = localQQMessageFacade.b();
          }
          this.jdField_d_of_type_Int = (i1 + i2);
          if (QLog.isColorLevel())
          {
            QLog.d("fetchUnReadCount", 2, String.format("Conversation, mUnReadCount[%s], msgUnReadCount[%s], callUnReadCount[%s], isCallTabShow[%s]", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(i1), Integer.valueOf(i2), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n) }));
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if ((!ThemeUtil.isNowThemeIsDIY()) && (!ThemeUtil.isNowThemeIsAnimate()))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setContentBackground(2130838220);
      return;
    }
    ThreadManager.post(new snj(this), 8, null, true);
  }
  
  void u()
  {
    s();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int i2 = 2;
    Object localObject2;
    if ((paramObject instanceof MessageRecord))
    {
      localObject2 = (MessageRecord)paramObject;
      if ((!((MessageRecord)localObject2).isSendFromLocal()) || (((MessageRecord)localObject2).msgtype != -2002)) {}
    }
    label35:
    label193:
    label589:
    do
    {
      do
      {
        do
        {
          break label35;
          break label35;
          do
          {
            return;
          } while ((((MessageRecord)localObject2).isSendFromLocal()) && (((MessageRecord)localObject2).msgtype == -2000) && (!this.i));
          if ((this.i) && (PublicAccountAdUtil.a((MessageRecord)localObject2)))
          {
            a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
            i(false);
          }
          if ((this.i) && (ImaxAdUtil.a((MessageRecord)localObject2))) {
            ImaxAdRecentUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          }
          int i1 = 10;
          Object localObject1 = Long.valueOf(0L);
          if ((((MessageRecord)localObject2).isSendFromLocal()) && ((!this.i) || (TextUtils.equals(((MessageRecord)localObject2).frienduin, AppConstants.as)) || (TextUtils.equals(((MessageRecord)localObject2).frienduin, AppConstants.at))))
          {
            i1 = 9;
            localObject1 = RecentDataListManager.a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
            if (((MessageRecord)localObject2).isSend()) {
              QAVHrMeeting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
            }
            a(i2, i1, localObject1);
          }
          for (;;)
          {
            if (!(paramObservable instanceof QCallFacade)) {
              break label589;
            }
            if ((paramObject instanceof Boolean))
            {
              boolean bool = ((Boolean)paramObject).booleanValue();
              if ((!this.jdField_g_of_type_Boolean) && (bool))
              {
                paramObservable = null;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                  paramObservable = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
                }
                if (paramObservable != null) {
                  paramObservable.a(false);
                }
              }
            }
            if ((!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager == null)) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.f();
            return;
            if ((!this.i) && (RecentUtil.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1024))) {
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1024, 100L);
            }
            i2 = 0;
            break label193;
            if ((paramObject instanceof RecentUser))
            {
              a(200L);
              if ((this.i) && (((RecentUser)paramObject).type == 6004)) {
                this.y = true;
              }
            }
            else if ((paramObject instanceof String[]))
            {
              localObject1 = (String[])paramObject;
              if ((localObject1.length == 2) && (AppConstants.w.equals(localObject1[0])) && (localObject1[1] != null))
              {
                localObject2 = localObject1[0];
                a(8, localObject1[1], 7000);
              }
            }
            else if ((paramObject instanceof JSONObject))
            {
              JSONObject localJSONObject = (JSONObject)paramObject;
              try
              {
                i1 = localJSONObject.getInt("actionType");
                switch (i1)
                {
                default: 
                  break;
                case 1: 
                  localObject1 = null;
                }
                try
                {
                  localObject2 = localJSONObject.getString("actionUin");
                  localObject1 = localObject2;
                  i1 = localJSONObject.getInt("actionUinType");
                  localObject1 = localObject2;
                }
                catch (JSONException localJSONException2)
                {
                  for (;;)
                  {
                    localJSONException2.printStackTrace();
                    i1 = -1;
                  }
                  a(8, localJSONException1, i1);
                }
                if ((-1 == i1) || (localObject1 == null)) {
                  a(200L);
                }
              }
              catch (JSONException localJSONException1)
              {
                for (;;)
                {
                  localJSONException1.printStackTrace();
                  i1 = -1;
                }
              }
            }
          }
        } while ((!(paramObservable instanceof RedTouchManager)) || (!(paramObject instanceof BusinessInfoCheckUpdate.AppInfo)));
        paramObject = (BusinessInfoCheckUpdate.AppInfo)paramObject;
        paramObservable = ((RedTouchManager)paramObservable).a(paramObject);
      } while ((paramObservable == null) || (paramObservable.size() <= 0));
      paramObservable = (VipBannerInfo)paramObservable.get(0);
    } while ((paramObservable.jdField_a_of_type_Int < 1) || (paramObservable.jdField_a_of_type_Int > 4));
    VipBannerInfo.b(this);
  }
  
  public void v()
  {
    super.v();
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation
 * JD-Core Version:    0.7.0.1
 */