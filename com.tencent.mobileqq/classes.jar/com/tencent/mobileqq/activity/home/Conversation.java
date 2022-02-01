package com.tencent.mobileqq.activity.home;

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
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.LaunchReportHelper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ConversationHotChatCtrl;
import com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QZoneFeedsObserver;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil;
import com.tencent.mobileqq.activity.contacts.base.SearchBarAssistant;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabUIHelper;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch.QZoneRedPointDrawerCallback;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.ConversationHelper;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.OnlineStatusExposureHelper;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentAdapter.ShowUpStateListener;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.activity.recent.RecentReportHelper;
import com.tencent.mobileqq.activity.recent.RecentTroopMenuOption;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ContactBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.IllegalNetworkBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MissedCallBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetNeedSignOnBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetStateBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NotificationGuideBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecurePhoneChangeNotifyBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.TroopAssistBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VerifyPhoneBannerProcessor;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTencentDocsAssistantData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentItemGameMsgBoxData;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxObserver;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentItemTempMsgBoxData;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.DrawerListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackObserver;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.applets.AppletsObserver;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerListener;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.fileassistant.top.FileAssistTopHandler;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.imaxad.ImaxAdPresenter;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;
import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.observer.OnAutoStatusBannerObserver;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.portal.ConversationHongBaoV2;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qqexpand.manager.IExpandLimitChatManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.studymode.ModeSwitchManager;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopCommonlyUsedHandler;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.onlinepush.api.TroopOnlinePushObserver;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopRemindSettingManager;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.ui.ConversationContainer;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.upgrade.UpgradeTipsDialog;
import com.tencent.mobileqq.upgrade.UpgradeTipsDialog.OnPreparedListener;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.CrashVersionUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.QQKRPUtil;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.TraceUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.vip.ad.TianshuAdManager;
import cooperation.vip.ad.TianshuRenewalsBarManager;
import cooperation.vip.ad.TianshuSplashManager;
import cooperation.vip.tianshu.TianShuManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Conversation
  extends Frame
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, OnRecentUserOpsListener, RecentAdapter.ShowUpStateListener, AppConstants, FrameHelperActivity.DrawerListener, UpgradeTipsDialog.OnPreparedListener, AbsListView.OnScrollListener, OverScrollViewListener, SwipListView.RightIconMenuListener, Observer
{
  public static boolean ak = true;
  public static long b = -1L;
  private static long bf;
  protected MqqHandler A;
  int B = -1;
  boolean C = false;
  public boolean D = false;
  long E = 0L;
  boolean F = false;
  MqqHandler G;
  int H;
  long I;
  protected List<RecentBaseData> J;
  long K = 0L;
  final List<String> L = new ArrayList(40);
  boolean M = false;
  long N = 0L;
  public int O;
  boolean P = false;
  boolean Q = false;
  boolean R = false;
  boolean S = false;
  ConversationHotChatCtrl T = null;
  ConversationTitleBtnCtrl U = null;
  ConversationQbossBannerTitleEntranceCtrl V;
  public TextView W;
  VipGiftManager X = null;
  public FrameHelperActivity Y;
  protected QQSettingMe Z;
  protected long a = 2000L;
  DiscussionObserver aA = new Conversation.46(this);
  QZoneFeedsObserver aB = new Conversation.53(this);
  protected StringBuilder aC;
  GestureDetector aD = new GestureDetector(BaseApplicationImpl.getContext(), new Conversation.66(this));
  protected Runnable aE = new Conversation.68(this);
  private FPSSwipListView aI;
  private MiniAppPullInterface aJ;
  private TextView aK;
  private TianshuAdManager aL;
  private TianshuSplashManager aM;
  private TianshuRenewalsBarManager aN;
  private int aO = -1;
  private PreloadProcHitSession aP = new PreloadProcHitSession("tool_adMessage", "com.tencent.mobileqq:tool");
  private boolean aQ = false;
  private PreloadProcHitSession aR = new PreloadProcHitSession("tool_shop", "com.tencent.mobileqq:tool");
  private PreloadProcHitSession aS = new PreloadProcHitSession("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private boolean aT = false;
  private RecentPubAccHelper aU;
  private boolean aV = true;
  private int aW;
  private long aX;
  private boolean aY;
  private ConversationHelper aZ;
  public ConversationHongBaoV2 aa;
  public SpringFestivalTaskCallback ab = new SpringFestivalTaskCallback(this);
  Dialog ac;
  int ad = 3;
  boolean ae = false;
  View af;
  boolean ag = false;
  boolean ah = false;
  ActionSheet ai;
  public LoginwelcomeHelper aj;
  public CareNotificationBar al;
  public volatile int am = 17;
  public volatile boolean an;
  public volatile int ao;
  protected Conversation.UICallBack ap = new Conversation.UICallBack(this);
  Conversation.LoadingStateCallback aq = new Conversation.LoadingStateCallback(this);
  MqqHandler ar = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.aq);
  public boolean as = false;
  boolean at = false;
  boolean au = false;
  Runnable av = new Conversation.29(this);
  protected TroopCommonlyUsedObserver aw = new Conversation.38(this);
  TroopQZoneUploadAlbumObserver ax = new Conversation.40(this);
  ProfileCardObserver ay = new Conversation.43(this);
  StrangerObserver az = new Conversation.44(this);
  private TempMsgBoxObserver bA = new Conversation.33(this);
  private final TroopObserver bB = new Conversation.34(this);
  private OnAutoStatusBannerObserver bC = new Conversation.35(this);
  private final TroopMngObserver bD = new Conversation.36(this);
  private final TroopOnlinePushObserver bE = new Conversation.37(this);
  private final ConfigObserver bF = new Conversation.39(this);
  private final MessageObserver bG = new Conversation.41(this);
  private CardObserver bH = new Conversation.42(this);
  private FMObserver bI = null;
  private final DataLineObserver bJ = new Conversation.48(this);
  private final SubAccountBindObserver bK = new Conversation.49(this);
  private final AVObserver bL = new Conversation.50(this);
  private final QQStoryObserver bM = new Conversation.51(this);
  private RegisterProxySvcPackObserver bN = new Conversation.52(this);
  private final BroadcastReceiver bO = new Conversation.54(this);
  private final BroadcastReceiver bP = new Conversation.55(this);
  private final BroadcastReceiver bQ = new Conversation.56(this);
  private final BroadcastReceiver bR = new Conversation.57(this);
  private Conversation.DateFormatChangeRunnable bS = new Conversation.DateFormatChangeRunnable(this, null);
  private HotChatObserver bT = new Conversation.58(this);
  private boolean bU = false;
  private boolean bV = false;
  private long bW = -1L;
  private boolean bX = false;
  private boolean bY = false;
  private AccountObserver bZ = new Conversation.62(this);
  private boolean ba;
  private boolean bb = false;
  private boolean bc = false;
  private boolean bd = false;
  private long be = 0L;
  private String bg;
  private final BannerListener bh = new Conversation.1(this);
  private Runnable bi;
  private Runnable bj = new Conversation.4(this);
  private DragFrameLayout bk;
  private Conversation.DragChangedListener bl;
  private Conversation.TPHInCon bm;
  private Dialog bn;
  private boolean bo;
  private UpgradeTipsDialog bp;
  private RedpointObserver bq = new Conversation.RedpointObserverImpl(this);
  private AppletsObserver br = new Conversation.AppletsObserverImpl(this);
  private QCircleObserver bs = new Conversation.QCircleObserverImpl(this);
  private AtomicBoolean bt = new AtomicBoolean(false);
  private Runnable bu = new Conversation.22(this);
  private View bv;
  private View bw;
  private final AvatarObserver bx = new Conversation.30(this);
  private final RoamSettingObserver by = new Conversation.31(this);
  private final FriendListObserver bz = new Conversation.32(this);
  public boolean c = false;
  private OnlineStatusObserver ca = new Conversation.63(this);
  private QQProgressDialog cb;
  private ExpandObserver cc = new Conversation.69(this);
  private StudyModeChangeListener cd = new Conversation.70(this);
  public boolean d = false;
  public boolean e = false;
  ConversationContainer f;
  ImmersiveTitleBar2 g;
  RelativeLayout h;
  protected View i;
  public RelativeLayout j;
  ImageView k;
  RedTouch l;
  public RecentOptPopBar m;
  ImageView n;
  RedTouch o;
  RecentTroopMenuOption p;
  protected boolean q;
  int r = 0;
  View s;
  RecentAdapter t;
  SearchBarAssistant u;
  View v;
  MsgTabStoryNodeListManager w;
  public IPullRefreshHeaderControl x;
  public BannerManager y;
  Dialog z;
  
  private void U()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFirstDrawComplete, ");
      localStringBuilder.append(this.P);
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
    if (this.P) {
      return;
    }
    this.t.i();
    this.A.removeMessages(1025);
    this.P = true;
    if (!this.Q) {
      this.A.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    BaseApplicationImpl.sApplication.onActivityFocusChanged(P(), true);
  }
  
  private void V()
  {
    FPSSwipListView localFPSSwipListView = this.aI;
    if ((localFPSSwipListView != null) && ((localFPSSwipListView instanceof ARMapHongBaoListView)))
    {
      if (this.aL == null) {
        this.aL = new TianshuAdManager(s(), this, (ARMapHongBaoListView)this.aI);
      }
      this.aL.a();
    }
  }
  
  private void W()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.bj);
    ThreadManager.getUIHandler().postDelayed(this.bj, 50L);
  }
  
  private void X()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTopIfNeccessary: ");
      localStringBuilder.append(this.aI.getFirstVisiblePosition());
      QLog.d("Q.recent", 2, localStringBuilder.toString());
    }
    if (this.aI.getFirstVisiblePosition() >= 0)
    {
      this.bX = true;
      this.bW = SystemClock.elapsedRealtime();
      this.aI.smoothScrollToPosition(0);
    }
  }
  
  private void Y()
  {
    ThreadManager.excute(new Conversation.5(this), 16, null, true);
  }
  
  private boolean Z()
  {
    boolean bool2 = Foreground.isCurrentProcessForeground();
    boolean bool3 = QBaseActivity.sTopActivity instanceof SplashActivity;
    boolean bool1;
    if (bool3) {
      try
      {
        bool1 = ((SplashActivity)QBaseActivity.sTopActivity).getChatFragment().isVisible();
      }
      catch (Exception localException)
      {
        QLog.d("Q.recent", 1, "AndroidX findFragmentByTag error,", localException);
      }
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "mIsForeground=", Boolean.valueOf(this.C), " isProcessForeground=", Boolean.valueOf(bool2), " isSplashActivity=", Boolean.valueOf(bool3), " isChatFragment=", Boolean.valueOf(bool1) });
    }
    return (!this.C) && (bool2) && (bool3) && (bool1);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == -1) {
      QQToast.makeText(P(), 2, e(2131917670), 0).show(P().getTitleBarHeight());
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((-1 == paramInt) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        TroopUtils.a(P(), paramIntent, true);
        ReportController.b(this.aF, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean, String paramString, RecentUserProxy paramRecentUserProxy)
  {
    int i2 = a(paramRecentBaseData.getRecentUserUin(), paramInt);
    int i1 = 0;
    paramRecentBaseData = paramRecentUserProxy.a(false).iterator();
    while (paramRecentBaseData.hasNext()) {
      if (((RecentUser)paramRecentBaseData.next()).showUpTime != 0L) {
        i1 += 1;
      }
    }
    ReportController.b(this.aF, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, paramString, String.valueOf(i1), String.valueOf(i2), "");
    if (paramInt == 7220)
    {
      if (paramBoolean)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(s(), "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    this.A.removeMessages(9004);
    Message localMessage = Message.obtain();
    localMessage.what = 9004;
    localMessage.obj = paramString;
    this.A.sendMessageDelayed(localMessage, paramInt);
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.A.removeMessages(9003);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 9003;
    localMessage.obj = paramString;
    this.A.sendMessageDelayed(localMessage, paramInt);
  }
  
  private void a(int paramInt, List<RecentBaseData> paramList)
  {
    ab().a(paramList, this.y);
    if ((-1 == this.bk.getMode()) && ((!this.bU) || (!this.bV)))
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doRefreshUI|[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",");
        int i1;
        if (paramList == null) {
          i1 = 0;
        } else {
          i1 = paramList.size();
        }
        localStringBuilder.append(i1);
        localStringBuilder.append("]，shouldShowConversationMayknow = ");
        localStringBuilder.append(this.ah);
        QLog.i("Q.recent", 2, localStringBuilder.toString());
      }
      if (this.t != null) {
        if (paramInt == 0) {
          d(paramList);
        } else {
          c(paramList);
        }
      }
      if (AppSetting.m) {
        ThreadManager.getSubThreadHandler().post(new Conversation.8(this));
      }
      s().refreshMsgTabUnreadNum(false, this.O);
      a(this.A.obtainMessage(10001, null), false);
      if (this.aT)
      {
        this.aT = false;
        aG();
      }
      this.G.sendEmptyMessage(18);
      aF();
      PublicAccountEventReport.a(s(), this.aI, 0);
      OfficialAccountReporter.a.c();
      return;
    }
    this.bl.a(paramInt, paramList);
    this.G.removeMessages(10);
    this.G.removeMessages(9);
    this.G.removeMessages(8);
    if (AppSetting.m) {
      ThreadManager.getSubThreadHandler().post(new Conversation.7(this));
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetWorkStateChange isNetWorkConnect = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" what = ");
      localStringBuilder.append(paramInt);
      QLog.i("Q.recent", 2, localStringBuilder.toString());
    }
    if (paramInt != 10003) {
      return;
    }
    if (paramBoolean)
    {
      a(3002, 200L, true, "vas_banner_net_change");
      a(1072, 400L, true);
      a(500, "tianshu_req_splash_type_net_change", true);
      a(500, "tianshu_req_renewals_type_net_change");
      TianShuManager.setLastClickAdTraceInfo("", "");
      this.y.b(VerifyPhoneBannerProcessor.a, 3000);
    }
  }
  
  private void a(long paramLong, List<RecentBaseData> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    SparseIntArray localSparseIntArray = new SparseIntArray(10100);
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      i1 = ((RecentBaseData)((Iterator)localObject).next()).getRecentUserType();
      localSparseIntArray.put(i1, localSparseIntArray.get(i1) + 1);
    }
    int i1 = 0;
    while (i1 < localSparseIntArray.size())
    {
      int i2 = localSparseIntArray.keyAt(i1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_");
      ((StringBuilder)localObject).append(i2);
      localHashMap.put(((StringBuilder)localObject).toString(), String.valueOf(localSparseIntArray.get(i2)));
      i1 += 1;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - paramLong, paramList.size(), localHashMap, "");
  }
  
  private void a(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {
      return;
    }
    paramMessage = RecentDataListManager.a().c;
    int i2 = paramMessage.size();
    Object localObject = new ArrayList(i2);
    int i1 = 0;
    while (i1 < i2) {
      try
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramMessage.get(i1);
        if (localRecentBaseData != null)
        {
          String str = RecentDataListManager.a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          if ((this.L.contains(str)) || (this.L.contains(RecentDataListManager.a(localRecentBaseData.getRecentUserUin(), -2147483648)))) {
            try
            {
              localRecentBaseData.update(s(), P());
              ((List)localObject).add(localRecentBaseData);
            }
            catch (Throwable localThrowable)
            {
              if (!SafeModeUtil.a(BaseApplicationImpl.sApplication)) {
                break label164;
              }
            }
          }
        }
        i1 += 1;
      }
      catch (Exception paramMessage)
      {
        label164:
        if (!QLog.isDevelopLevel()) {
          break label192;
        }
        QLog.e("Q.recent", 4, paramMessage.toString());
        return;
      }
    }
    throw new RuntimeException(localThrowable);
    label192:
    a(paramMessage);
    this.A.obtainMessage(1019, 0, 0, localObject).sendToTarget();
    b(paramMessage);
    if (this.H <= 8)
    {
      this.H = 0;
      this.L.clear();
    }
    this.G.removeMessages(8);
    this.I = System.currentTimeMillis();
    localObject = new HashMap();
    ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - paramLong, paramMessage.size(), (HashMap)localObject, "");
    StartupTracker.a("Conversation_Refresh_items", System.currentTimeMillis() - paramLong);
    if (QLog.isDevelopLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("REFRESH_FLAG_ITEMS, [");
      paramMessage.append(paramLong);
      paramMessage.append(",");
      paramMessage.append(System.currentTimeMillis() - paramLong);
      paramMessage.append("]");
      QLog.i("Q.recent", 4, paramMessage.toString());
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, int paramInt)
  {
    QQKRPUtil.a(s(), paramRecentUser, paramRecentBaseData);
    PublicAccountEventReport.a(s(), paramRecentBaseData);
    if ((paramRecentUser != null) && (paramRecentUser.lFlag == 16L) && (paramInt == 0))
    {
      paramRecentBaseData = this.aP;
      if (paramRecentBaseData != null)
      {
        paramRecentBaseData.b();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "ad preload tool process hit");
        }
      }
    }
    if ((paramRecentUser != null) && (String.valueOf(9970L).equals(paramRecentUser.uin)))
    {
      paramRecentBaseData = this.aR;
      if (paramRecentBaseData != null) {
        paramRecentBaseData.b();
      }
    }
    if ((paramRecentUser != null) && (paramRecentUser.getType() == 6004))
    {
      paramRecentBaseData = this.aS;
      if (paramRecentBaseData != null) {
        paramRecentBaseData.b();
      }
    }
    if (paramRecentUser != null)
    {
      paramRecentBaseData = (FeedsManager)this.aF.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER);
      paramRecentBaseData.setFeedInfoRead(paramRecentUser.uin);
      if (FeedsManager.isShowStatus(paramRecentUser.uin))
      {
        BeancurdManager localBeancurdManager = (BeancurdManager)this.aF.getManager(QQManagerFactory.BEANCURD_MANAGER);
        if (localBeancurdManager != null)
        {
          long l1 = localBeancurdManager.b(paramRecentUser.uin);
          FeedsManager.saveToken(paramRecentUser.uin, l1);
          paramRecentBaseData.reportClickExpose();
          localBeancurdManager.a(2, 2);
        }
      }
      else
      {
        paramRecentBaseData = s().getMessageFacade().r(paramRecentUser.uin, paramRecentUser.getType());
        if ((paramRecentBaseData != null) && (paramRecentBaseData.msgtype == -1034))
        {
          paramRecentBaseData = (BeancurdManager)this.aF.getManager(QQManagerFactory.BEANCURD_MANAGER);
          if (paramRecentBaseData != null) {
            paramRecentBaseData.a(2, 1);
          }
        }
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString1, boolean paramBoolean, String paramString2)
  {
    RecentTroopMenuOption localRecentTroopMenuOption = this.p;
    if (localRecentTroopMenuOption != null) {
      localRecentTroopMenuOption.a(paramRecentBaseData, paramBoolean);
    }
    ReportController.b(this.aF, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", paramString2, paramString1, "");
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if ((paramAbsListView != null) && (this.t != null))
    {
      int i2 = paramAbsListView.getFirstVisiblePosition();
      int i1 = i2;
      if (i2 > 0) {
        i1 = i2 - 1;
      }
      int i3 = paramAbsListView.getLastVisiblePosition();
      i2 = i1;
      while (i2 < i3 + 1)
      {
        Object localObject1 = this.t.getItem(i2);
        if ((localObject1 != null) && ((localObject1 instanceof RecentItemPublicAccountADFolderData)))
        {
          localObject1 = (RecentItemPublicAccountADFolderData)localObject1;
          if (ImaxAdUtil.a(paramAbsListView.getChildAt(i2 - i1)))
          {
            localObject1 = AdvertisementRecentUserManager.a().b(((RecentItemPublicAccountADFolderData)localObject1).mUser.uin);
            if (localObject1 == null) {
              return;
            }
            Message localMessage = Message.obtain();
            Object localObject2 = new HashMap();
            ((HashMap)localObject2).put("key_app", new WeakReference(s()));
            ((HashMap)localObject2).put("key_adapter", new WeakReference(this.t));
            ((HashMap)localObject2).put("key_listview", new WeakReference(paramAbsListView));
            localMessage.obj = localObject2;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("key_ad_id", ((AdvertisementItem)localObject1).d);
            localMessage.setData((Bundle)localObject2);
            localMessage.what = 1;
            ImaxAdPresenter.a().a(localMessage);
          }
        }
        i2 += 1;
      }
    }
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof JSONObject))
    {
      JSONObject localJSONObject = (JSONObject)paramObject;
      int i1;
      try
      {
        i1 = localJSONObject.getInt("actionType");
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        i1 = -1;
      }
      if (i1 != 1) {
        return;
      }
      paramObject = null;
      try
      {
        String str = localJSONObject.getString("actionUin");
        paramObject = str;
        i1 = localJSONObject.getInt("actionUinType");
        paramObject = str;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        i1 = -1;
      }
      if ((-1 != i1) && (paramObject != null))
      {
        a(8, paramObject, i1);
        return;
      }
      a(200L);
    }
  }
  
  private void a(String paramString1, @android.support.annotation.NonNull String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    b(new Conversation.19(this, paramString2, paramString1));
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    if ((paramObservable instanceof QCallFacade))
    {
      if ((paramObject instanceof Boolean))
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        if ((!this.q) && (bool))
        {
          paramObservable = null;
          if (this.aF != null) {
            paramObservable = (QCallFacade)this.aF.getManager(QQManagerFactory.RECENT_CALL_FACADE);
          }
          if (paramObservable != null) {
            paramObservable.a(false);
          }
        }
      }
      if (this.q)
      {
        paramObservable = this.y;
        if (paramObservable != null) {
          paramObservable.b(MissedCallBannerProcessor.a, 2000);
        }
      }
    }
  }
  
  public static void a(MqqHandler paramMqqHandler, Context paramContext)
  {
    paramMqqHandler.removeMessages(1134065);
    if (FriendsStatusUtil.a(paramContext))
    {
      ReportController.b(null, "CliOper", "", "", "0X8009EB9", "0X8009EB9", 0, 1, "", "", "", "");
      Message localMessage = paramMqqHandler.obtainMessage(1134065);
      localMessage.arg1 = 2;
      paramMqqHandler.sendMessage(localMessage);
      long l1 = FriendsStatusUtil.b(paramContext);
      if (l1 > 0L) {
        paramMqqHandler.postDelayed(new Conversation.45(paramMqqHandler), l1 * 1000L);
      }
    }
    else
    {
      paramContext = paramMqqHandler.obtainMessage(1134065);
      paramContext.arg1 = 0;
      paramMqqHandler.sendMessage(paramContext);
    }
  }
  
  private boolean a(int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject = this.aF;
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i1, "0", "0", "", "");
    if (!NetworkUtil.isNetworkAvailable(s().getApp().getApplicationContext()))
    {
      QQToast.makeText(P(), 1, 2131893879, 0).show(P().getTitleBarHeight());
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setChatAtTop top: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" uin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" userType: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    FriendsStatusUtil.a(s(), paramString, paramBoolean);
    return false;
  }
  
  private boolean a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData instanceof RecentItemMayKnowFriendData))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, " onRecentBaseDataClick recommend_item_menu");
      }
      O();
      ContactReportUtils.a(s(), "msgtab_list_clk", 1);
      return true;
    }
    if ((paramRecentBaseData instanceof RecentItemMayKnowFriendVerticalListData))
    {
      a(paramView, this.aI.getContext(), paramRecentBaseData.getRecentUserUin());
      return true;
    }
    if ((paramRecentBaseData instanceof RecentItemRecommendTroopData))
    {
      ((MayknowRecommendManager)this.aF.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(paramView, this.aI.getContext(), paramRecentBaseData.getRecentUserUin());
      return true;
    }
    return false;
  }
  
  private boolean a(RecentBaseData paramRecentBaseData, boolean paramBoolean, RecentUserProxy paramRecentUserProxy, String paramString)
  {
    int i2 = paramRecentBaseData.getRecentUserType();
    int i1 = 1;
    boolean bool = false;
    if ((paramString != null) && (paramString.length() != 0) && (paramRecentUserProxy != null))
    {
      Object localObject2 = paramRecentUserProxy.c(paramString, i2);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RecentUser(paramString, i2);
      }
      if (paramBoolean) {
        ((RecentUser)localObject1).showUpTime = (System.currentTimeMillis() / 1000L);
      } else {
        ((RecentUser)localObject1).showUpTime = 0L;
      }
      paramRecentUserProxy.b((RecentUser)localObject1);
      this.A.sendEmptyMessage(1009);
      Object localObject3;
      StringBuilder localStringBuilder;
      if ((i2 != 7210) && (i2 != 7120))
      {
        if (i2 == 1008)
        {
          i2 = paramRecentBaseData.mUnreadNum;
          if (RecentPubAccHelper.a()) {
            paramRecentBaseData = "0X800BDDD";
          } else {
            paramRecentBaseData = "0X80064C8";
          }
          if (paramBoolean) {
            if (RecentPubAccHelper.a()) {
              paramRecentBaseData = "0X800BDD4";
            } else {
              paramRecentBaseData = "0X80064C7";
            }
          }
          paramRecentUserProxy = paramRecentUserProxy.a(false).iterator();
          i1 = 0;
          while (paramRecentUserProxy.hasNext()) {
            if (((RecentUser)paramRecentUserProxy.next()).showUpTime != 0L) {
              i1 += 1;
            }
          }
          paramRecentUserProxy = this.aF;
          localObject2 = ((RecentUser)localObject1).uin;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(i2);
          localObject3 = ((StringBuilder)localObject3).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(i1);
          ReportController.b(paramRecentUserProxy, "dc00899", "Pb_account_lifeservice", (String)localObject2, paramRecentBaseData, paramRecentBaseData, 0, 0, (String)localObject3, localStringBuilder.toString(), "", "");
          if ("2290230341".equals(paramString))
          {
            if (paramBoolean) {
              paramRecentBaseData = "0X80090E6";
            } else {
              paramRecentBaseData = "0X800915B";
            }
            if (paramBoolean) {
              QZoneReport.a(4);
            }
            ReportController.b(this.aF, "CliOper", "", "", paramRecentBaseData, paramRecentBaseData, 0, 0, "", "", "", "");
          }
        }
      }
      else
      {
        int i3 = paramRecentBaseData.mUnreadNum;
        if (paramBoolean) {
          paramRecentBaseData = "0X80064C3";
        } else {
          paramRecentBaseData = "0X80064C4";
        }
        if (i2 != 7120) {
          i1 = 0;
        }
        paramRecentUserProxy = paramRecentUserProxy.a(false).iterator();
        i2 = 0;
        while (paramRecentUserProxy.hasNext()) {
          if (((RecentUser)paramRecentUserProxy.next()).showUpTime != 0L) {
            i2 += 1;
          }
        }
        paramRecentUserProxy = this.aF;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(i1);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(i3);
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i2);
        ReportController.b(paramRecentUserProxy, "dc00899", "Pb_account_lifeservice", (String)localObject2, paramRecentBaseData, paramRecentBaseData, 0, 0, (String)localObject3, localStringBuilder.toString(), "", "");
      }
      if ((7220 == ((RecentUser)localObject1).getType()) && (AppConstants.KANDIAN_MERGE_UIN.equals(paramString))) {
        ((IKanDianMergeManager)((QQAppInterface)this.aF).getRuntimeService(IKanDianMergeManager.class)).roamStickySettingToServer(paramBoolean);
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramRecentBaseData = new StringBuilder();
      paramRecentBaseData.append("onMenuItemClick error, %s ");
      if (paramString == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramRecentBaseData.append(paramBoolean);
      paramRecentBaseData.append(" ");
      paramBoolean = bool;
      if (paramRecentUserProxy == null) {
        paramBoolean = true;
      }
      paramRecentBaseData.append(paramBoolean);
      QLog.d("Q.recent", 2, paramRecentBaseData.toString());
    }
    return true;
  }
  
  private void aA()
  {
    Object localObject = this.X;
    if (localObject != null)
    {
      VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).e();
      if (localVipGiftDownloadInfo != null)
      {
        a((VipGiftManager)localObject, localVipGiftDownloadInfo);
        if (b((VipGiftManager)localObject, localVipGiftDownloadInfo))
        {
          localObject = (BaseActivity)P();
          if ((localObject instanceof SplashActivity)) {
            ((SplashActivity)localObject).showGifAnnimate();
          }
        }
      }
    }
  }
  
  private boolean aB()
  {
    if (!SharedPreUtils.aq(P(), s().getCurrentAccountUin()))
    {
      Object localObject2 = s().getProxyManager().g().a(false);
      if ((localObject2 != null) && (((List)localObject2).size() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = (TroopManager)this.aF.getManager(QQManagerFactory.TROOP_MANAGER);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if ((localRecentUser.getType() == 1) && (localRecentUser.showUpTime > 0L))
          {
            ((TroopManager)localObject1).c(localRecentUser.uin, localRecentUser.showUpTime);
            localArrayList.add(localRecentUser.uin);
            a(9, localRecentUser.uin, 1);
          }
        }
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (SharedPreUtils.as(P(), s().getCurrentAccountUin()).contains(localObject2)) {
            localArrayList.remove(localObject2);
          }
        }
        if (localArrayList.size() == 0)
        {
          SharedPreUtils.ar(P(), s().getCurrentAccountUin());
          return true;
        }
        ((ITroopCommonlyUsedHandler)s().getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a(localArrayList, 0);
        return false;
      }
      SharedPreUtils.ar(P(), s().getCurrentAccountUin());
      return true;
    }
    return false;
  }
  
  private void aC()
  {
    if (this.bi == null) {
      this.bi = new Conversation.25(this);
    }
    ThreadManagerV2.excute(this.bi, 32, null, true);
  }
  
  private void aD()
  {
    Object localObject;
    if (this.d)
    {
      if (FrameHelperActivity.G()) {
        FrameHelperActivity.H();
      }
      this.d = false;
      localObject = this.aa;
      if ((localObject != null) && (((ConversationHongBaoV2)localObject).e != -1) && (this.aa.e != 1))
      {
        this.aa.c.D = true;
        localObject = this.aa;
        ((ConversationHongBaoV2)localObject).h = true;
        ((ConversationHongBaoV2)localObject).h = true;
      }
      localObject = this.aa;
      if (localObject != null) {
        ((ConversationHongBaoV2)localObject).j();
      }
      localObject = this.ab;
      if (localObject != null) {
        ((SpringFestivalTaskCallback)localObject).g();
      }
    }
    else
    {
      localObject = this.aa;
      if (localObject != null) {
        ((ConversationHongBaoV2)localObject).k();
      }
      localObject = this.ab;
      if (localObject != null) {
        ((SpringFestivalTaskCallback)localObject).g();
      }
    }
    if (this.at) {
      this.at = false;
    }
  }
  
  private void aE()
  {
    BannerManager localBannerManager = this.y;
    if (localBannerManager != null) {
      localBannerManager.c();
    }
    d("onResume");
  }
  
  private void aF()
  {
    if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(true))) {
      return;
    }
    if (this.v == null) {
      return;
    }
    Object localObject = this.t.getItem(0);
    if ((localObject instanceof RecentUserBaseData))
    {
      localObject = (RecentUserBaseData)localObject;
      TroopManager localTroopManager = (TroopManager)this.aF.getManager(QQManagerFactory.TROOP_MANAGER);
      boolean bool;
      if ((((RecentUserBaseData)localObject).mUser.getType() == 1) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(s(), ((RecentUserBaseData)localObject).mUser))) {
        bool = localTroopManager.o(((RecentUserBaseData)localObject).getRecentUserUin());
      } else if (((RecentUserBaseData)localObject).mUser.showUpTime > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      if (this.ba != bool)
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setLocalSearchBarByShowUpMask:mShowUPMask = ");
          ((StringBuilder)localObject).append(this.ba);
          ((StringBuilder)localObject).append(", dstMsg = ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("Q.recent", 4, ((StringBuilder)localObject).toString());
        }
        int i2 = SimpleModeHelper.a(bool);
        int i1;
        if (bool) {
          i1 = 2130852499;
        } else {
          i1 = 2130852498;
        }
        this.v.setBackgroundResource(i2);
        this.v.findViewById(2131432634).setBackgroundResource(i1);
        this.ba = bool;
      }
    }
  }
  
  private void aG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess start");
    }
    if (this.aF != null)
    {
      if (!this.P) {
        return;
      }
      if (((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).isTencentDocsAssistantEnable(s()))
      {
        if (!((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).isPreloadToolProcess(s())) {
          return;
        }
        int i3 = 0;
        Object localObject = this.aI;
        int i2 = i3;
        if (localObject != null)
        {
          i2 = i3;
          if (this.t != null)
          {
            int i1 = ((FPSSwipListView)localObject).getFirstVisiblePosition();
            for (;;)
            {
              i2 = i3;
              if (i1 > this.aI.getLastVisiblePosition()) {
                break;
              }
              localObject = this.t.getItem(i1);
              if (((localObject instanceof RecentItemTencentDocsAssistantData)) && (((RecentItemTencentDocsAssistantData)localObject).getUnreadNum() > 0))
              {
                i2 = 1;
                break;
              }
              i1 += 1;
            }
          }
        }
        if ((i2 != 0) && (((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).preloadWebProcess(s())))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess call");
          }
          localObject = this.aS;
          if (localObject != null) {
            ((PreloadProcHitSession)localObject).a();
          }
        }
      }
    }
  }
  
  private void aH()
  {
    Object localObject = this.aL;
    if (localObject != null)
    {
      ((TianshuAdManager)localObject).b();
      this.aL = null;
    }
    localObject = this.aM;
    if (localObject != null)
    {
      ((TianshuSplashManager)localObject).b();
      this.aM = null;
    }
    localObject = this.aN;
    if (localObject != null)
    {
      ((TianshuRenewalsBarManager)localObject).a();
      this.aN = null;
    }
  }
  
  private void aI()
  {
    CareNotificationBar localCareNotificationBar = this.al;
    if (localCareNotificationBar != null) {
      localCareNotificationBar.d();
    }
  }
  
  private void aJ()
  {
    b(new Conversation.28(this));
  }
  
  private void aK()
  {
    TroopAssistantManager.a().s(s());
    Object localObject = ServiceAccountFolderManager.a();
    if (localObject != null) {
      ((ServiceAccountFolderManager)localObject).a(s());
    }
    localObject = TroopBarAssistantManager.a();
    if (localObject != null) {
      ((TroopBarAssistantManager)localObject).q(s());
    }
    TroopNotificationHelper.a(s());
    localObject = (TroopTipsMsgMgr)this.aF.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
    if (localObject != null) {
      ((TroopTipsMsgMgr)localObject).b(s());
    } else if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
    }
    localObject = (EcShopAssistantManager)this.aF.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localObject != null) {
      ((EcShopAssistantManager)localObject).g();
    }
    localObject = (IGroupVideoManager)this.aF.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    if (localObject != null) {
      ((IGroupVideoManager)localObject).a(true);
    }
    localObject = (HotChatCenterManager)this.aF.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
    if (localObject != null) {
      ((HotChatCenterManager)localObject).a();
    }
    HiddenChatManager.a(s()).c();
    localObject = (IExpandLimitChatManager)this.aF.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (localObject != null) {
      ((IExpandLimitChatManager)localObject).g();
    }
    localObject = (StoryHaloManager)this.aF.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    ((StoryHaloManager)localObject).a(1, ((StoryHaloManager)localObject).a(this.J));
  }
  
  private void aL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "updateMayKnowOrTroopRecommend");
    }
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.aF.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if (localMayknowRecommendManager.o())
    {
      localMayknowRecommendManager.g();
      return;
    }
    this.ah = localMayknowRecommendManager.p();
    ArrayList localArrayList = localMayknowRecommendManager.f();
    if ((this.ah) && (localArrayList != null) && (localArrayList.size() > 0))
    {
      localMayknowRecommendManager.h();
      return;
    }
    localMayknowRecommendManager.i();
    this.ah = false;
  }
  
  private void aM()
  {
    this.bI = new Conversation.47(this);
  }
  
  private void aN()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = RecentDataListManager.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadNextScreenUserFaceIcon:");
      localStringBuilder.append(this.aV);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    boolean bool = this.aV;
    int i2 = 1;
    if (bool)
    {
      i1 = this.aI.getLastVisiblePosition() - this.aI.getHeaderViewsCount() + 1;
    }
    else
    {
      i1 = this.aI.getFirstVisiblePosition() - this.aI.getHeaderViewsCount() - 1;
      i2 = 0;
    }
    int i4 = 0;
    int i3 = i1;
    int i1 = i4;
    while ((i2 != 0) && (i1 < 10))
    {
      if (i3 < 0) {
        return;
      }
      if (i3 >= this.t.getCount()) {
        return;
      }
      localObject = this.t.getItem(i3);
      if ((localObject != null) && ((localObject instanceof RecentBaseData)))
      {
        localObject = (RecentBaseData)localObject;
        if (!(localObject instanceof RecentItemImaxADData)) {
          this.t.f().a(((RecentBaseData)localObject).getRecentUserType(), ((RecentBaseData)localObject).getRecentUserUin(), false);
        }
      }
      else
      {
        i3 += i2;
      }
      i1 += 1;
    }
  }
  
  private void aO()
  {
    if (!this.F)
    {
      FrameHelperActivity localFrameHelperActivity = this.Y;
      if (localFrameHelperActivity != null)
      {
        localFrameHelperActivity.ak[0] = new Conversation.59(this);
        this.Y.ak[1] = new LebaTabRedTouch.QZoneRedPointDrawerCallback();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
    }
  }
  
  private void aP()
  {
    if ((this.aG) && (this.Y.ah != null) && (!this.Y.ah.j())) {
      ThreadManager.post(new Conversation.60(this), 5, null, true);
    }
  }
  
  private void aQ()
  {
    try
    {
      if (this.cb == null)
      {
        this.cb = new QQProgressDialog(P(), P().getTitleBarHeight());
        this.cb.c(2131892342);
        this.cb.c(false);
        this.cb.setOnDismissListener(new Conversation.67(this));
      }
      this.cb.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void aR()
  {
    try
    {
      if ((this.cb != null) && (this.cb.isShowing()))
      {
        ThreadManager.getUIHandlerV2().postDelayed(this.aE, 800L);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void aa()
  {
    if (this.q)
    {
      ReportController.b(this.aF, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if (this.aI != null)
      {
        Object localObject = this.t;
        if (localObject == null) {
          return;
        }
        int i3 = ((RecentAdapter)localObject).getCount();
        int i1 = this.B;
        boolean bool2 = true;
        i1 += 1;
        while (i1 < i3)
        {
          localObject = this.t.getItem(i1);
          if ((localObject instanceof RecentBaseData))
          {
            localObject = (RecentBaseData)localObject;
            int i2;
            if (((RecentBaseData)localObject).isUnreadMsgNumInTabNum()) {
              i2 = ((RecentBaseData)localObject).getUnreadNum();
            } else {
              i2 = 0;
            }
            if (i2 > 0)
            {
              bool1 = bool2;
              if (this.B == i1) {
                break label170;
              }
              this.B = i1;
              bool1 = bool2;
              break label170;
            }
          }
          i1 += 1;
        }
        boolean bool1 = false;
        label170:
        if (bool1)
        {
          if (ak)
          {
            localObject = this.aI;
            ((FPSSwipListView)localObject).smoothScrollToPosition(this.B + ((FPSSwipListView)localObject).getHeaderViewsCount());
          }
          else
          {
            localObject = this.aI;
            ((FPSSwipListView)localObject).setSelectionFromTop(this.B + ((FPSSwipListView)localObject).getHeaderViewsCount(), 0);
          }
        }
        else
        {
          bool2 = ak;
          if (bool2) {
            this.aI.setIsNeedScrollPositionTop(bool2);
          }
          X();
          this.B = -1;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("scrollToNextUnreadItem|findUnreadItem:");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append(",mCurrentUnreadItem");
          ((StringBuilder)localObject).append(this.B);
          QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private NewerGuideBannerManager ab()
  {
    return (NewerGuideBannerManager)this.aF.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER);
  }
  
  private void ac()
  {
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - this.N);
    if ((this.t != null) && (l2 > 300000L))
    {
      String str = Settings.System.getString(P().getContentResolver(), "date_format");
      if (TimeManager.a().a(str)) {
        this.N = l1;
      }
    }
  }
  
  private void ad()
  {
    if (LoadingStateManager.b().c()) {
      LoadingStateManager.b().a(3);
    }
  }
  
  private void ae()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Conversation showUpgradeDetailInfoIfNeccessary mInitTimUpgradeInfo : ");
      ((StringBuilder)localObject).append(this.bo);
      QLog.d("UpgradeTIMWrapper", 2, ((StringBuilder)localObject).toString());
    }
    if (this.aG)
    {
      localObject = this.bp;
      if ((localObject != null) && (((UpgradeTipsDialog)localObject).a()))
      {
        localObject = this.bn;
        if ((localObject != null) && (((Dialog)localObject).isShowing()))
        {
          this.bn.dismiss();
          this.bn = null;
        }
      }
    }
    try
    {
      this.bp.show();
      ConfigHandler.a(s());
      int i1 = ConfigHandler.c(s());
      ConfigHandler.d(s(), i1 + 1);
      ReportController.b(this.aF, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      label165:
      break label165;
    }
    ReportController.b(this.aF, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    return;
    if (this.aG)
    {
      if ((!ConfigHandler.b(s())) && (!this.bo))
      {
        a(1134047, 0L, true);
        this.bo = true;
      }
      a(1134057, 0L, true);
    }
  }
  
  private void af()
  {
    this.Y.a(this);
  }
  
  private void ag()
  {
    this.bk = ((DragFrameLayout)P().findViewById(2131431325));
    this.bl = new Conversation.DragChangedListener(this, null);
    this.bk.a(this.bl, false);
    this.q = true;
    s().isInCallList = false;
    this.f = ((ConversationContainer)d(2131445137));
    this.g = ((ImmersiveTitleBar2)this.f.findViewById(2131447582));
    this.j = ((RelativeLayout)this.f.findViewById(2131431392));
    this.aH = ((QQBlurView)this.f.findViewById(2131429596));
    this.h = ((RelativeLayout)this.f.findViewById(2131446351));
    this.i = SimpleModeHelper.d(this.h);
    this.aK = ((TextView)this.f.findViewById(2131448231));
    this.W = ((TextView)this.f.findViewById(2131448239));
    ah();
    IphoneTitleBarActivity.setLayerType(this.j);
    IphoneTitleBarActivity.setLayerType(this.g);
    this.s = this.f.findViewById(2131437332);
    this.aI = ((FPSSwipListView)this.f.findViewById(2131444377));
    m();
    this.aI.setDescendantInvalidatedFlags(true);
    this.aI.setActTAG("actFPSRecent");
    try
    {
      this.aI.setOverscrollHeader(Q().getDrawable(2130839580));
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initUI setOverscrollHeader error");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.d("Q.recent", 2, ((StringBuilder)localObject2).toString());
      }
    }
    this.aI.setNeedCheckSpringback(true);
    this.aI.setIsNeedScrollPositionTop(true);
    QBaseActivity localQBaseActivity = P();
    if ((localQBaseActivity != null) && ((localQBaseActivity instanceof SplashActivity)))
    {
      localObject2 = (SplashActivity)localQBaseActivity;
      localObject1 = ((SplashActivity)localObject2).mPreloadLocalSearchBar;
      ((SplashActivity)localObject2).mPreloadLocalSearchBar = null;
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (localQBaseActivity != null) {
        localObject2 = localQBaseActivity.getLayoutInflater().inflate(2131629216, this.aI, false);
      }
    }
    if (localObject2 != null)
    {
      this.aI.addHeaderView((View)localObject2, 0);
      this.u = new SearchBarAssistant((BaseActivity)P(), 1, (View)localObject2);
      this.v = ((View)localObject2);
    }
    BannerManager.a().a(P(), this.aI);
    this.y = BannerManager.a();
    this.y.b(PushBannerProcessor.a, 2005);
    this.y.a(this.aF, this.bh);
    this.t = new RecentAdapter(P(), s(), this.aI, this, 0, RecentDataListManager.a().b ^ true);
    this.t.b(true);
    this.t.a(this.bk);
    this.aI.setAdapter(this.t);
    this.aI.setOnScrollListener(this);
    this.aI.setRightIconMenuListener(this);
    this.t.a(this);
    this.af = new View(P());
    Object localObject1 = new AbsListView.LayoutParams(-1, 0);
    this.af.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.aI.addFooterView(this.af, null, false);
    if ((!TextUtils.isEmpty(RecentDataListManager.a().e)) && (!TextUtils.isEmpty(s().getCurrentUin())) && (!s().getCurrentUin().equals(RecentDataListManager.a().e)))
    {
      localObject1 = new ArrayList(16);
      QLog.d("Q.recent", 1, "ignore PreLoadList");
    }
    else
    {
      localObject1 = RecentDataListManager.a().d;
    }
    this.t.a((List)localObject1);
    this.t.a(0);
    this.Y.E();
    this.Y.q.sendEmptyMessageDelayed(1, 200L);
    this.aa = new ConversationHongBaoV2(this, this.f);
    this.aj = new LoginwelcomeHelper(this, this.bk);
    this.k = ((ImageView)d(2131431401));
    this.l = new RedTouch(P(), this.k).c(53).a();
    IphoneTitleBarActivity.setLayerType(this.k);
    d("initUI");
    localObject1 = VasSplashUtil.f;
    if ((localObject1 != null) && (((SplashItem)localObject1).c()) && (!TextUtils.isEmpty(VasSplashUtil.a(s().getCurrentUin())))) {
      this.y.b(VasADBannerProcessor.a, 3000);
    }
    a(this.aH, this.aI);
    SimpleModeHelper.a(this.aK);
  }
  
  private void ah()
  {
    int i1 = AIOUtils.b(10.0F, Q());
    AIOUtils.a(this.W, i1, i1, i1, i1);
    this.W.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    this.W.setOnClickListener(new Conversation.16(this));
    this.W.setOnLongClickListener(new Conversation.17(this));
  }
  
  private void ai()
  {
    ((FriendListHandler)s().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(s().getCurrentUin(), false);
  }
  
  private void aj()
  {
    int i1 = ((IRedTouchManager)this.aF.getRuntimeService(IRedTouchManager.class, "")).getNumRedNumByPath("104000.104001", 100);
    if (i1 > 0) {
      a(8, AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:");
    localStringBuilder.append(AuthorityUtil.a(s().getCurrentUin()));
    localStringBuilder.append("getSubscribeAccountRedDotNum  redNumByPath:");
    localStringBuilder.append(i1);
    QLog.d("Q.recent", 2, localStringBuilder.toString());
  }
  
  private void ak()
  {
    try
    {
      if ((!this.Q) && (!this.F))
      {
        this.Q = true;
        if (!this.R) {
          x();
        }
        I();
        if ((!this.S) && (!s().mAutomator.g())) {
          c(2);
        }
        if (this.U != null) {
          this.U.a();
        }
        this.k.setOnClickListener(this);
        this.h.setOnTouchListener(new Conversation.21(this));
        this.al = new CareNotificationBar(this, this.f);
        am();
        if (this.ab != null)
        {
          this.ab.e();
          SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          if (localSpringFestivalEntryManager != null) {
            localSpringFestivalEntryManager.m();
          }
        }
        this.aI.setOverScrollHeader((View)this.x);
        this.aI.setOverScrollListener(this);
        al();
        if (!s().mAutomator.g())
        {
          a(this.A, P());
          a(1055, 0L, false);
          if (QLog.isColorLevel())
          {
            QLog.d("Q.recent", 2, new Object[] { "initUiLater() will send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(s().mAutomator.g()) });
            QLog.d("Q.recent", 2, "isInRealActionLoginB MSG_CHECK_QQSPORT_RED_PACKET");
          }
          a(1061, 0L, false);
          a(1059, 0L, false);
        }
        else if (this.as)
        {
          a(1055, 0L, false);
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "initUiLater() mMsgTabStoryNodeListNeedInit fallback logic, send MSG_INIT_MSGTAG_STORY");
          }
          this.as = false;
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("Q.recent", 2, new Object[] { "initUiLater() will not send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(s().mAutomator.g()) });
        }
        ae();
        this.G.sendEmptyMessage(12);
        aO();
        return;
      }
      return;
    }
    finally {}
  }
  
  private void al()
  {
    Object localObject = this.y;
    if ((localObject != null) && (this.q)) {
      ((BannerManager)localObject).b(MissedCallBannerProcessor.a, 2000);
    }
    if (this.y != null)
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 2000;
      ((Message)localObject).getData().putBoolean("rightNow", false);
      this.y.b(ContactBannerProcessor.a, (Message)localObject);
      this.y.a(PushBannerProcessor.a, 2000, 5000L);
      a(3002, 5000L, true, "vas_banner_login");
    }
    a(5000, "tianshu_req_splash_type_login", true);
    a(5000, "tianshu_req_renewals_type_login");
    localObject = this.y;
    if (localObject != null)
    {
      ((BannerManager)localObject).b(SetPwdBannerProcessor.a, 3000);
      this.y.a(SecurePhoneChangeNotifyBannerProcessor.a, 3000, 1000L);
    }
  }
  
  private void am()
  {
    long l1 = System.currentTimeMillis();
    if (MiniAppConfProcessor.b())
    {
      if (this.x == null) {
        this.x = SimpleModeHelper.a(this.aI);
      }
      if (this.aJ == null) {
        this.aJ = ((IMiniAppService)QRoute.api(IMiniAppService.class)).createMiniAppEntryManager(MiniAppConfProcessor.e(), P(), this, this.aI, this.x, this.Y.ah, this.f);
      }
      long l2 = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init Mini App, cost=");
      ((StringBuilder)localObject).append(l2 - l1);
      QLog.d("AutoMonitor", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.aJ;
    if (localObject != null) {
      ((MiniAppPullInterface)localObject).initUI(P());
    }
  }
  
  private void an()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    aN();
    this.y.b(PushBannerProcessor.a, 2000);
    this.y.b(SetPwdBannerProcessor.a, 3000);
    this.y.b(NotificationGuideBannerProcessor.a, 3000);
    ae();
    if (!this.q) {
      ((FriendListHandler)s().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(s().getCurrentAccountUin(), (byte)2);
    }
    ao();
    ((ModeSwitchManager)this.aF.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).a((BaseActivity)P());
    if (!this.Y.ap) {
      TabUIHelper.c(P(), s().getCurrentUin());
    }
  }
  
  private void ao()
  {
    Object localObject = P();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        ReportController.b(this.aF, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void ap()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("removeObservers");
      ((StringBuilder)???).append(this.bt);
      QLog.d("Q.recent", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.bt)
    {
      this.bt.set(false);
      Object localObject2;
      if (this.aF != null)
      {
        s().removeObserver(this.bz);
        s().removeObserver(this.bx);
        s().removeObserver(this.by);
        s().removeObserver(this.bE);
        s().removeObserver(this.bD);
        s().removeObserver(this.bB);
        s().removeObserver(this.aw);
        s().removeObserver(this.bF);
        s().removeObserver(this.bG);
        s().removeObserver(this.ax);
        s().removeObserver(this.bH);
        s().removeObserver(this.ay);
        s().removeObserver(this.aA);
        s().removeObserver(this.bK);
        s().removeObserver(this.bJ);
        s().removeObserver(this.bT);
        s().removeObserver(this.bM);
        s().removeObserver(this.bN);
        s().unRegistObserver(this.bZ);
        s().removeObserver(this.ca);
        s().removeObserver(this.cc);
        s().removeObserver(this.az);
        StudyModeManager.b(this.cd);
        if (s().getAVNotifyCenter() != null) {
          s().getAVNotifyCenter().deleteObserver(this.bL);
        }
        if (s().getMessageFacade() != null) {
          s().getMessageFacade().deleteObserver(this);
        }
        if (this.bI != null) {
          s().getFileManagerNotifyCenter().deleteObserver(this.bI);
        }
        s().setHandler(getClass(), null);
        s().removeHandler(getClass());
        this.aF.unRegistObserver(this.aB);
        this.aF.unRegistObserver(this.bC);
        s().removeObserver(this.bq);
        s().removeObserver(this.br);
        s().removeObserver(this.bs);
        localObject2 = (QCallFacade)this.aF.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (localObject2 != null) {
          ((QCallFacade)localObject2).deleteObserver(this);
        }
        if (this.aj != null) {
          this.aj.c();
        }
        if (this.ab != null)
        {
          this.aF.unRegistObserver(this.ab);
          localObject2 = (SpringFestivalEntryManager)this.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          if (localObject2 != null) {
            ((SpringFestivalEntryManager)localObject2).a(null);
          }
          this.ab.i();
        }
      }
      this.G.removeMessages(17);
      try
      {
        localObject2 = (BaseActivity)P();
        if (this.bm != null)
        {
          BaseTransProcessor.removeHandler(this.bm);
          this.bm.a();
          this.bm = null;
        }
        ((BaseActivity)localObject2).unregisterReceiver(this.bQ);
        ((BaseActivity)localObject2).unregisterReceiver(this.bO);
        ((BaseActivity)localObject2).unregisterReceiver(this.bP);
        ((BaseActivity)localObject2).unregisterReceiver(this.bR);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, localException.toString());
        }
      }
      return;
    }
  }
  
  private void aq()
  {
    Dialog localDialog = this.ac;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  private void ar()
  {
    LoginwelcomeHelper localLoginwelcomeHelper = this.aj;
    if (localLoginwelcomeHelper != null) {
      localLoginwelcomeHelper.a();
    }
  }
  
  private void as()
  {
    MiniAppPullInterface localMiniAppPullInterface = this.aJ;
    if (localMiniAppPullInterface != null) {
      localMiniAppPullInterface.onResume();
    }
  }
  
  private void at()
  {
    CareNotificationBar localCareNotificationBar = this.al;
    if (localCareNotificationBar != null) {
      localCareNotificationBar.f();
    }
  }
  
  private void au()
  {
    MsgTabStoryNodeListManager localMsgTabStoryNodeListManager = this.w;
    if (localMsgTabStoryNodeListManager != null) {
      localMsgTabStoryNodeListManager.l();
    }
  }
  
  private void av()
  {
    if (s().upgradeData != null)
    {
      a(s().upgradeData);
      s().upgradeData = null;
    }
  }
  
  private void aw()
  {
    if ((b == -1L) && (SplashActivity.sIsNormalRouteEnter))
    {
      b = SystemClock.elapsedRealtime();
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).setResumeFlagFromConversation(b);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).saveNormalEnterConversationTime(b);
    }
  }
  
  private void ax()
  {
    this.A.postDelayed(new Conversation.23(this), 500L);
    this.A.sendEmptyMessageDelayed(1070, 3000L);
    ((IRedTouchManager)this.aF.getRuntimeService(IRedTouchManager.class, "")).residenceReport(System.currentTimeMillis());
    TianShuManager.setLastClickAdTraceInfo("", "");
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).handConversationToShow();
    aC();
    if (!this.A.hasMessages(1053)) {
      this.A.sendEmptyMessageDelayed(1053, 500L);
    }
    RecentPubAccHelper.b(s());
    this.A.postDelayed(new Conversation.24(this), 100L);
  }
  
  private void ay()
  {
    try
    {
      ABTestController.a().a("exp_status_new").h();
      ((IGameMsgBoxABTestApi)QRoute.api(IGameMsgBoxABTestApi.class)).reportGameTabExposure(this.A);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Q.recent", 1, "online status exp: ", localThrowable);
    }
  }
  
  private void az()
  {
    if (this.e)
    {
      if (FrameHelperActivity.G())
      {
        FrameHelperActivity.c(true);
        FrameHelperActivity.H();
      }
      this.e = false;
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("REQ_CODE_BIND_NUMBER resultCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", src: ");
      localStringBuilder.append(-1);
      QLog.i("BindMsgConstant", 2, localStringBuilder.toString());
    }
  }
  
  private void b(Message paramMessage)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("UpgradeTIMWrapper", 2, "Conversation onReceiveShowTIMUpgradeTips");
      }
      if ((this.aF != null) && (this.bn == null) && ((paramMessage.obj instanceof UpgradeTIMWrapper)))
      {
        UpgradeTIMWrapper localUpgradeTIMWrapper = (UpgradeTIMWrapper)paramMessage.obj;
        if ((localUpgradeTIMWrapper != null) && (!TextUtils.isEmpty(localUpgradeTIMWrapper.a)) && (!TextUtils.isEmpty(localUpgradeTIMWrapper.b)) && (!TextUtils.isEmpty(localUpgradeTIMWrapper.c)))
        {
          Conversation.11 local11 = new Conversation.11(this);
          Conversation.12 local12 = new Conversation.12(this, localUpgradeTIMWrapper);
          if (TextUtils.isEmpty(localUpgradeTIMWrapper.d)) {
            paramMessage = HardCodeUtil.a(2131900756);
          } else {
            paramMessage = localUpgradeTIMWrapper.d;
          }
          String str;
          if (TextUtils.isEmpty(localUpgradeTIMWrapper.e)) {
            str = HardCodeUtil.a(2131900766);
          } else {
            str = localUpgradeTIMWrapper.e;
          }
          this.bn = DialogUtils.a(P(), localUpgradeTIMWrapper.a, localUpgradeTIMWrapper.b, paramMessage, str, null, local12, local11);
          this.bn.setCanceledOnTouchOutside(false);
          this.bn.setOnDismissListener(new Conversation.13(this));
          if ((this.aG) && (!this.bn.isShowing()) && ((this.bp == null) || (!this.bp.isShowing())) && (!ConfigHandler.b(s())))
          {
            this.bn.show();
            ReportController.b(this.aF, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
            ConfigHandler.a(s());
            a(1134048, 0L, true);
          }
          return;
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  private void b(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {
      return;
    }
    if (QvipSpecialCareUtil.a(s())) {
      QvipSpecialCareUtil.b(s());
    }
    ac();
    List localList1 = RecentDataListManager.a().c;
    List localList2 = s().getProxyManager().g().a(false);
    this.aZ.a(localList2);
    localList1.clear();
    int i1;
    if (localList2 == null) {
      i1 = 0;
    } else {
      i1 = localList2.size();
    }
    int i2 = 0;
    while (i2 < i1)
    {
      RecentUser localRecentUser = (RecentUser)localList2.get(i2);
      String str = RecentDataListManager.a(localRecentUser.uin, localRecentUser.getType());
      RecentBaseData localRecentBaseData = RecentDataListManager.a().a(str);
      if (localRecentBaseData == null)
      {
        localRecentBaseData = ConversationDataFactory.a(localRecentUser, s(), P());
        paramMessage = localRecentBaseData;
        if (localRecentBaseData != null)
        {
          RecentDataListManager.a().a(localRecentBaseData, str);
          paramMessage = localRecentBaseData;
        }
      }
      else if (!this.L.contains(str))
      {
        paramMessage = localRecentBaseData;
        if (!this.L.contains(RecentDataListManager.a(localRecentUser.uin, -2147483648))) {}
      }
      else
      {
        if ((localRecentBaseData instanceof RecentUserBaseData)) {
          ((RecentUserBaseData)localRecentBaseData).a(localRecentUser);
        }
        try
        {
          localRecentBaseData.update(s(), P());
          paramMessage = localRecentBaseData;
        }
        catch (Throwable paramMessage)
        {
          if (!SafeModeUtil.a(BaseApplicationImpl.sApplication)) {
            break label296;
          }
        }
        paramMessage = null;
      }
      if (paramMessage != null) {
        localList1.add(paramMessage);
      }
      i2 += 1;
      continue;
      label296:
      throw new RuntimeException(paramMessage);
    }
    try
    {
      Collections.sort(localList1, this.aZ);
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
    e(localList1);
    a(localList1);
    paramMessage = new ArrayList(localList1);
    this.A.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
    b(localList1);
    if (this.y != null)
    {
      paramMessage = Message.obtain();
      paramMessage.what = 2000;
      this.y.b(TroopAssistBannerProcessor.a, paramMessage);
    }
    if (this.H <= 9) {
      this.H = 0;
    }
    this.L.clear();
    this.G.removeMessages(9);
    this.G.removeMessages(8);
    this.I = System.currentTimeMillis();
    paramMessage = new HashMap();
    paramMessage.put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - paramLong, localList1.size(), paramMessage, "");
    StartupTracker.a("Conversation_Refresh_part", System.currentTimeMillis() - paramLong);
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("REFRESH_FLAG_PART, [");
      paramMessage.append(paramLong);
      paramMessage.append(",");
      paramMessage.append(System.currentTimeMillis() - paramLong);
      paramMessage.append("]");
      QLog.i("Q.recent", 2, paramMessage.toString());
    }
  }
  
  private void b(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, int paramInt)
  {
    if (paramRecentUser != null)
    {
      int i2 = paramRecentUser.getType();
      int i1 = 1;
      if ((i2 != 7120) && (paramRecentUser.getType() != 7210) && (paramRecentUser.getType() != 1008))
      {
        if (paramRecentUser.getType() == 6004)
        {
          if (paramInt > 0) {
            paramInt = 1;
          } else {
            paramInt = 2;
          }
          ReportController.b(this.aF, "dc00898", "", "", "0X80090CC", "0X80090CC", paramInt, 0, "", "", "", "");
        }
      }
      else
      {
        if (paramInt == 0)
        {
          i1 = 0;
          paramRecentBaseData = "0X80067ED";
        }
        else
        {
          paramRecentBaseData = "0X80067EC";
        }
        Object localObject1 = s().getMessageFacade().r(paramRecentUser.uin, paramRecentUser.getType());
        long l2 = 0L;
        long l1 = l2;
        if (localObject1 != null)
        {
          l1 = l2;
          if ((localObject1 instanceof MessageForStructing))
          {
            localObject1 = ((MessageForStructing)localObject1).structingMsg;
            l1 = l2;
            if (localObject1 != null) {
              l1 = ((AbsStructMsg)localObject1).msgId;
            }
          }
        }
        localObject1 = this.aF;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramRecentUser.uin);
        ((StringBuilder)localObject2).append("");
        paramRecentUser = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(l1);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(i1);
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt);
        ReportController.b((AppRuntime)localObject1, "dc00899", "Pb_account_lifeservice", "", paramRecentBaseData, paramRecentBaseData, 0, 0, paramRecentUser, (String)localObject2, (String)localObject3, localStringBuilder.toString());
      }
    }
  }
  
  private void b(Object paramObject)
  {
    if ((paramObject instanceof String[]))
    {
      paramObject = (String[])paramObject;
      if ((paramObject.length == 2) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramObject[0])) && (paramObject[1] != null))
      {
        Object localObject = paramObject[0];
        a(8, paramObject[1], 7000);
        a(8, AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.aM == null) {
      this.aM = new TianshuSplashManager(s());
    }
    this.aM.a(paramString);
  }
  
  private boolean b(RecentBaseData paramRecentBaseData, boolean paramBoolean, RecentUserProxy paramRecentUserProxy, String paramString)
  {
    Object localObject = (TroopManager)this.aF.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = ((TroopManager)localObject).v(paramRecentBaseData.getRecentUserUin());
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    if (!bool2)
    {
      if (!((ITroopCommonlyUsedHandler)s().getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a(str, paramBoolean ^ true)) {
        return true;
      }
      paramRecentUserProxy = ((TroopManager)localObject).g(paramRecentBaseData.getRecentUserUin());
      if (paramRecentUserProxy != null)
      {
        i1 = paramRecentUserProxy.troopmask;
        if ((i1 != 1) && (i1 == 4))
        {
          i1 = 3;
          break label124;
        }
      }
      i1 = 0;
      label124:
      paramRecentUserProxy = new ReportTask(s()).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
      paramString = paramRecentBaseData.getRecentUserUin();
      if (paramBoolean) {
        paramRecentBaseData = "0";
      } else {
        paramRecentBaseData = "1";
      }
      paramRecentUserProxy.a(new String[] { paramString, String.valueOf(i1), paramRecentBaseData }).a();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.recent", 2, "TroopManage.getTroopCodeByTroopUin return null...");
    }
    int i1 = paramRecentBaseData.getRecentUserType();
    if ((paramString != null) && (paramString.length() != 0) && (paramRecentUserProxy != null))
    {
      localObject = paramRecentUserProxy.c(paramString, i1);
      paramRecentBaseData = (RecentBaseData)localObject;
      if (localObject == null) {
        paramRecentBaseData = new RecentUser(paramString, i1);
      }
      if (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(s(), paramRecentBaseData))
      {
        if (paramBoolean) {
          paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);
        } else {
          paramRecentBaseData.showUpTime = 0L;
        }
        paramRecentUserProxy.b(paramRecentBaseData);
        this.A.sendEmptyMessage(1009);
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramRecentBaseData = new StringBuilder();
      paramRecentBaseData.append("onMenuItemClick error, %s ");
      if (paramString == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramRecentBaseData.append(paramBoolean);
      paramRecentBaseData.append(" ");
      paramBoolean = bool1;
      if (paramRecentUserProxy == null) {
        paramBoolean = true;
      }
      paramRecentBaseData.append(paramBoolean);
      QLog.d("Q.recent", 2, paramRecentBaseData.toString());
    }
    return true;
  }
  
  private void c(int paramInt)
  {
    try
    {
      QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync from=", Integer.valueOf(paramInt), " isInRealActionLoginB=", Boolean.valueOf(s().mAutomator.g()), " isLoadUIAfterMsgSync=", Boolean.valueOf(this.S) });
      if (1 == paramInt)
      {
        this.an = true;
        this.G.sendEmptyMessage(18);
        a(1072, 500L, true);
        a(500, "tianshu_req_splash_type_after_sync", true);
        a(500, "tianshu_req_renewals_type_after_sync");
        a(1073, 30000L, true);
        if (this.U != null) {
          this.U.f();
        }
        ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).setDataManagerAfterMsgSync();
      }
      a(1077, 1200L, true);
      if ((!this.S) && (!this.F))
      {
        this.S = true;
        long l1 = System.currentTimeMillis();
        this.y.b(VasADBannerProcessor.a, 2001);
        this.Y.q.sendEmptyMessage(18);
        ai();
        CrashVersionUtils.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync cost=", Long.valueOf(System.currentTimeMillis() - l1), " all done!" });
        } else {
          QLog.d("Q.recent", 2, "doAfterMsgSync all done!");
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  private void c(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceiverShowUpgradeTips");
    }
    if ((this.aF != null) && (this.bp == null))
    {
      if (!(paramMessage.obj instanceof UpgradeDetailWrapper)) {
        return;
      }
      paramMessage = (UpgradeDetailWrapper)paramMessage.obj;
      if (ConfigHandler.c(s()) >= 5)
      {
        this.y.b(UpgradeBannerProcessor.a, 3000);
        return;
      }
      if (ConfigHandler.b(s())) {
        return;
      }
      if (ConfigHandler.c(s(), 0) == null) {
        return;
      }
      this.bp = new UpgradeTipsDialog(P(), s(), paramMessage, this);
      this.bp.setOnDismissListener(new Conversation.14(this));
    }
  }
  
  private void c(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {
      return;
    }
    ((HotChatCenterManager)this.aF.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).g();
    TroopAssistantManager.a().f(s());
    ac();
    paramMessage = s().getProxyManager().g();
    if (QvipSpecialCareUtil.a(s())) {
      QvipSpecialCareUtil.b(s());
    }
    boolean bool;
    if ((s().mAutomator != null) && (s().mAutomator.g())) {
      bool = true;
    } else {
      bool = false;
    }
    List localList = paramMessage.a(bool);
    this.aZ.a(localList);
    paramMessage = RecentDataListManager.a().c;
    Object localObject = s();
    QBaseActivity localQBaseActivity = P();
    int i1;
    if (localList != null) {
      i1 = localList.size();
    } else {
      i1 = 0;
    }
    ConversationDataFactory.a(localList, (BaseQQAppInterface)localObject, localQBaseActivity, paramMessage, i1);
    try
    {
      Collections.sort(paramMessage, this.aZ);
    }
    catch (Exception localException)
    {
      QLog.d("Q.recent", 2, "Comparator Exception: ", localException);
      localException.printStackTrace();
    }
    e(paramMessage);
    a(paramMessage);
    ArrayList localArrayList = new ArrayList(paramMessage);
    this.A.obtainMessage(10000, 0, 0, localArrayList).sendToTarget();
    QLog.d("Q.recent", 1, new Object[] { "notify MSG_REFRESH_UI,size=", Integer.valueOf(localArrayList.size()) });
    b(paramMessage);
    this.L.clear();
    this.H = 0;
    this.G.removeMessages(10);
    this.G.removeMessages(9);
    this.G.removeMessages(8);
    this.I = System.currentTimeMillis();
    a(paramLong, paramMessage);
    localObject = (StoryHaloManager)this.aF.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    ((StoryHaloManager)localObject).b(3, ((StoryHaloManager)localObject).a(paramMessage));
    StartupTracker.a("Conversation_Refresh_global", System.currentTimeMillis() - paramLong);
    if ((OnlineStatusExposureHelper.a()) && (!SimpleUIUtil.e())) {
      this.Y.a(localArrayList);
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("REFRESH_FLAG_GLOBAL, [");
      paramMessage.append(paramLong);
      paramMessage.append(",");
      paramMessage.append(System.currentTimeMillis() - paramLong);
      paramMessage.append("]");
      QLog.i("Q.recent", 2, paramMessage.toString());
    }
  }
  
  private void c(Object paramObject)
  {
    if ((paramObject instanceof RecentUser))
    {
      a(200L);
      if ((this.C) && (((RecentUser)paramObject).getType() == 6004)) {
        this.aT = true;
      }
    }
  }
  
  private void c(String paramString)
  {
    if (this.aN == null) {
      this.aN = new TianshuRenewalsBarManager(this);
    }
    this.aN.a(paramString);
  }
  
  private void c(List<RecentBaseData> paramList)
  {
    int i2 = 0;
    int i1;
    if (paramList == null) {
      i1 = 0;
    } else {
      i1 = paramList.size();
    }
    while (i2 < i1)
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)paramList.get(i2);
      if (localRecentBaseData != null) {
        this.t.a(localRecentBaseData);
      }
      i2 += 1;
    }
  }
  
  private void d(Message paramMessage)
  {
    boolean bool = a(paramMessage);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("REFRESH_FLAG_RECENT_ITEMS, [");
      ((StringBuilder)localObject).append(paramMessage.arg1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramMessage.arg2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramMessage.obj);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.P);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.i("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool) {
      return;
    }
    int i2 = paramMessage.arg2;
    long l2 = 0L;
    int i1 = 8;
    long l1;
    if ((i2 != 8) && (i2 != 9))
    {
      l1 = l2;
      if ((paramMessage.obj instanceof Long)) {
        l1 = ((Long)paramMessage.obj).longValue();
      }
    }
    else
    {
      localObject = null;
      if ((paramMessage.obj instanceof String)) {
        localObject = (String)paramMessage.obj;
      }
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (!this.L.contains(localObject))
        {
          this.L.add(localObject);
          l1 = l2;
        }
      }
    }
    if (i2 >= this.H)
    {
      while (i1 < i2)
      {
        this.G.removeMessages(i1);
        i1 += 1;
      }
      this.H = i2;
    }
    if ((this.P) && (!this.G.hasMessages(this.H)))
    {
      l2 = Math.abs(System.currentTimeMillis() - this.I);
      l1 = Math.max(this.a - l2, l1);
      localObject = Message.obtain();
      ((Message)localObject).arg1 = paramMessage.arg1;
      ((Message)localObject).what = this.H;
      this.G.sendMessageDelayed((Message)localObject, l1);
    }
  }
  
  private void d(Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramObject;
      s().refreshMultiAIOUnreadNum(localMessageRecord.frienduin, localMessageRecord.istroop);
      if ((localMessageRecord.isSendFromLocal()) && (localMessageRecord.msgtype == -2002)) {
        return;
      }
      if ((localMessageRecord.isSendFromLocal()) && (localMessageRecord.msgtype == -2000) && (!this.C)) {
        return;
      }
      boolean bool = this.C;
      int i3 = 0;
      if ((bool) && (PublicAccountAdUtil.a(localMessageRecord)))
      {
        a(this.aI);
        m(false);
      }
      if ((this.C) && (ImaxAdUtil.a(localMessageRecord))) {
        ImaxAdRecentUserManager.a().a(s(), this.t, this.aI);
      }
      if ((this.C) && (QCircleChatUtil.b(localMessageRecord.istroop))) {
        w();
      }
      int i4 = 10;
      Long localLong = Long.valueOf(0L);
      int i1;
      int i2;
      if ((localMessageRecord.isSendFromLocal()) && ((!this.C) || (TextUtils.equals(localMessageRecord.frienduin, AppConstants.NEW_KANDIAN_UIN)) || (TextUtils.equals(localMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))))
      {
        paramObject = RecentDataListManager.a(localMessageRecord.frienduin, localMessageRecord.istroop);
        i1 = 9;
        i2 = 2;
      }
      else
      {
        i1 = i4;
        i2 = i3;
        paramObject = localLong;
        if (!this.C)
        {
          i1 = i4;
          i2 = i3;
          paramObject = localLong;
          if (RecentUtil.d)
          {
            i1 = i4;
            i2 = i3;
            paramObject = localLong;
            if (!this.A.hasMessages(1024))
            {
              this.A.sendEmptyMessageDelayed(1024, 100L);
              paramObject = localLong;
              i2 = i3;
              i1 = i4;
            }
          }
        }
      }
      if (localMessageRecord.isSend()) {
        QAVHrMeeting.a(s(), localMessageRecord);
      }
      if (Z())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "update message in AIO");
        }
        i2 = 4;
        paramObject = RecentDataListManager.a(localMessageRecord.frienduin, localMessageRecord.istroop);
        i1 = 9;
      }
      a(i2, i1, paramObject);
      this.bV = true;
    }
  }
  
  private void d(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.18(this, paramString));
  }
  
  private void d(List<RecentBaseData> paramList)
  {
    if (this.ah)
    {
      MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.aF.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if ((localMayknowRecommendManager.f) && (localMayknowRecommendManager.a(paramList))) {
        localMayknowRecommendManager.f = false;
      }
    }
    this.t.a(paramList);
    if (this.bc)
    {
      this.bc = false;
      if (this.bd)
      {
        if (this.C) {
          this.aI.addOnLayoutChangeListener(new Conversation.9(this));
        } else {
          aR();
        }
        this.bd = false;
      }
    }
    if (paramList != null) {
      RecentDataListManager.a().a(paramList, s().getCurrentUin());
    }
    this.t.a(0);
  }
  
  private void e(List<RecentBaseData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        Object localObject1 = this.aC;
        int i1 = 0;
        if (localObject1 == null) {
          this.aC = new StringBuilder();
        } else {
          ((StringBuilder)localObject1).setLength(0);
        }
        paramList = new ArrayList(paramList);
        this.aC.append("SortedRecentInfo, [");
        localObject1 = (TroopManager)this.aF.getManager(QQManagerFactory.TROOP_MANAGER);
        int i2 = paramList.size();
        while (i1 < i2)
        {
          Object localObject2 = (RecentBaseData)paramList.get(i1);
          if ((localObject2 instanceof RecentUserBaseData))
          {
            localObject2 = (RecentUserBaseData)localObject2;
            if (((((RecentUserBaseData)localObject2).getRecentUserType() == 1) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(s(), ((RecentUserBaseData)localObject2).mUser)) && (((TroopManager)localObject1).o(((RecentUserBaseData)localObject2).getRecentUserUin()))) || (((RecentUserBaseData)localObject2).mUser.showUpTime != 0L)) {
              this.aC.append("t-");
            }
            StringBuilder localStringBuilder = this.aC;
            localStringBuilder.append(((RecentUserBaseData)localObject2).getRecentUserType());
            localStringBuilder.append("-");
            localStringBuilder.append(StringUtil.getSimpleUinForPrint(((RecentUserBaseData)localObject2).getRecentUserUin()));
            localStringBuilder.append("-");
            localStringBuilder.append(i1);
            localStringBuilder.append(" , ");
          }
          i1 += 1;
        }
        this.aC.append("]");
        paramList.clear();
        QLog.i("Q.recent", 2, this.aC.toString());
      }
    }
  }
  
  private void i(boolean paramBoolean)
  {
    if (this.ae != paramBoolean)
    {
      Object localObject;
      if (paramBoolean)
      {
        if (this.x == null)
        {
          QLog.e("Q.recent", 1, "Error State that mChatTopReflesh is null! ui Not Init! will updateMsgTabStoryNodeView(true) later.");
          this.as = true;
          return;
        }
        if (this.w == null) {
          this.w = new MsgTabStoryNodeListManager(P(), this, this.aI, this.x, this.Y.ah, (BreathEffectView)this.f.findViewById(2131435107));
        }
        localObject = this.Y;
        if ((localObject != null) && (((FrameHelperActivity)localObject).ah != null)) {
          this.w.A = this.Y.ah.j();
        }
        this.w.z = this.aG;
        this.w.b();
        this.as = false;
      }
      else
      {
        localObject = this.w;
        if (localObject != null) {
          ((MsgTabStoryNodeListManager)localObject).c();
        }
        this.as = false;
      }
      this.ae = paramBoolean;
    }
  }
  
  private void j(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addObservers");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(this.bt);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.bt;
    if (!paramBoolean) {}
    try
    {
      this.bt.set(true);
      this.G.sendEmptyMessageDelayed(17, 200L);
      return;
    }
    finally {}
    if (!this.bt.get()) {
      return;
    }
    s().setHandler(getClass(), this.A);
    s().addObserver(this.bE, true);
    s().addObserver(this.bD, true);
    s().addObserver(this.bB, true);
    s().addObserver(this.aw, true);
    s().addObserver(this.bF, true);
    s().addObserver(this.bG, true);
    s().addObserver(this.ax, true);
    s().addObserver(this.bH, true);
    s().addObserver(this.ay, true);
    s().addObserver(this.aA, true);
    s().addObserver(this.bK, true);
    s().addObserver(this.bJ);
    s().addObserver(this.bT);
    s().addObserver(this.bM);
    s().addObserver(this.bN);
    s().registObserver(this.aB);
    s().registObserver(this.bZ);
    s().addObserver(this.ca);
    s().addObserver(this.cc);
    s().addObserver(this.az);
    this.aF.registObserver(this.bC);
    this.aF.registObserver(this.bA);
    StudyModeManager.a(this.cd);
    if (this.bI == null) {
      aM();
    }
    s().getFileManagerNotifyCenter().addObserver(this.bI);
    if (this.bm == null) {
      this.bm = new Conversation.TPHInCon(this);
    }
    this.bm.addFilter(new Class[] { BuddyTransfileProcessor.class, ((IPicTransFile)s().getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getC2CPttDownloadProcessorClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getC2CPttUpProcessorClass(), ((IPicTransFile)s().getRuntimeService(IPicTransFile.class)).getGroupUploadProClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getGroupPttDownloadProcessorClass(), ForwardImageProcessor.class });
    ((ITransFileController)s().getRuntimeService(ITransFileController.class)).addHandle(this.bm);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      P().registerReceiver(this.bO, localIntentFilter);
      localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.SECURITY_DETECT_PUSH_BANNER");
      P().registerReceiver(this.bP, localIntentFilter);
      localIntentFilter = new IntentFilter("android.intent.action.TIME_SET");
      localIntentFilter.addAction("android.intent.action.DATE_CHANGED");
      localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      P().registerReceiver(this.bQ, localIntentFilter);
      localIntentFilter = new IntentFilter("com.tencent.WT.WT_OUT_OF_AIO");
      P().registerReceiver(this.bR, localIntentFilter);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, localException.toString());
      }
    }
    if (this.aF.isLogin())
    {
      s().addObserver(this.bz, true);
      s().addObserver(this.bx, true);
      s().addObserver(this.by, true);
      Object localObject2 = (SpringFestivalEntryManager)this.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if (localObject2 != null) {
        ((SpringFestivalEntryManager)localObject2).a(this.ab);
      }
      this.aF.registObserver(this.ab);
      this.ab.a(this.ap);
      s().getMessageFacade().addObserver(this);
      localObject2 = (QCallFacade)this.aF.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (localObject2 != null) {
        ((QCallFacade)localObject2).addObserver(this);
      }
      s().getGAudioHandler().b();
      s().getAVNotifyCenter().addObserver(this.bL);
      UITools.d(this.aF.getApplication().getApplicationContext());
      s().addObserver(this.bq);
      s().addObserver(this.br);
      s().addObserver(this.bs);
      if (this.aj != null) {
        this.aj.b();
      }
    }
    ab().d();
    localObject1 = this.Y;
    if (localObject1 != null) {
      ((FrameHelperActivity)localObject1).b("AfterAddObservers");
    }
  }
  
  private void k(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      PreloadProcHitSession localPreloadProcHitSession = this.aP;
      if (localPreloadProcHitSession != null) {
        localPreloadProcHitSession.e();
      }
    }
    m(true);
    aG();
    A();
  }
  
  private void l(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.Q))
    {
      Object localObject = this.U;
      if (localObject != null)
      {
        ((ConversationTitleBtnCtrl)localObject).e();
        this.U.a(false);
      }
      localObject = this.V;
      if (localObject != null) {
        ((ConversationQbossBannerTitleEntranceCtrl)localObject).a(false);
      }
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if (((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isPreloadTooProcess())
    {
      if ((!paramBoolean) && (((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).hasPreloadWebProcessor())) {
        return;
      }
      int i3 = 0;
      Object localObject = this.aI;
      int i2 = i3;
      if (localObject != null)
      {
        i2 = i3;
        if (this.t != null)
        {
          int i1 = ((FPSSwipListView)localObject).getFirstVisiblePosition();
          for (;;)
          {
            i2 = i3;
            if (i1 > this.aI.getLastVisiblePosition()) {
              break;
            }
            if ((this.t.getItem(i1) instanceof RecentItemPublicAccountADFolderData))
            {
              i2 = 1;
              break;
            }
            i1 += 1;
          }
        }
      }
      if (i2 != 0)
      {
        localObject = this.aP;
        if ((localObject != null) && (!this.aQ))
        {
          ((PreloadProcHitSession)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.aQ = true;
        }
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).setHasPreloadWebProcessor(true);
        ThreadManager.getSubThreadHandler().postDelayed(new Conversation.26(this), 1000L);
      }
    }
  }
  
  void A()
  {
    if (this.aF != null)
    {
      if (!this.P) {
        return;
      }
      if (!((EcShopAssistantManager)this.aF.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).m()) {
        return;
      }
      int i3 = 0;
      Object localObject = this.aI;
      int i2 = i3;
      if (localObject != null)
      {
        i2 = i3;
        if (this.t != null)
        {
          int i1 = ((FPSSwipListView)localObject).getFirstVisiblePosition();
          for (;;)
          {
            i2 = i3;
            if (i1 > this.aI.getLastVisiblePosition()) {
              break;
            }
            if ((this.t.getItem(i1) instanceof RecentItemEcShopAssitant))
            {
              i2 = 1;
              break;
            }
            i1 += 1;
          }
        }
      }
      if ((i2 != 0) && (((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).preloadWebProcess(s())))
      {
        localObject = this.aR;
        if (localObject != null) {
          ((PreloadProcHitSession)localObject).a();
        }
      }
    }
  }
  
  public View B()
  {
    return this.h;
  }
  
  public View C()
  {
    return this.s;
  }
  
  public View D()
  {
    return this.Y.af;
  }
  
  void E()
  {
    View localView = this.bw;
    if ((localView != null) && (localView.getVisibility() != 8)) {
      this.bw.setVisibility(8);
    }
  }
  
  void F()
  {
    if ((this.ah) && (((MayknowRecommendManager)this.aF.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).d("sp_mayknow_ml_s_a_vl")))
    {
      Object localObject1 = this.aI;
      if ((localObject1 != null) && (((FPSSwipListView)localObject1).isShown()) && (!this.t.isEmpty()))
      {
        int i3 = this.aI.getFirstVisiblePosition();
        int i5 = this.aI.getLastVisiblePosition();
        localObject1 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        int i4;
        for (int i1 = -1; i3 <= i5; i1 = i4)
        {
          i4 = i1;
          if (i3 >= 0)
          {
            i4 = i1;
            if (i3 < this.t.getCount())
            {
              i4 = i1;
              if (this.t.getItem(i3) != null)
              {
                Object localObject2 = this.t.getItem(i3);
                i4 = i1;
                if ((localObject2 instanceof RecentItemMayKnowFriendVerticalListData))
                {
                  int i2 = i1;
                  if (i1 < 0) {
                    i2 = G();
                  }
                  localObject2 = ((RecentItemMayKnowFriendVerticalListData)localObject2).e();
                  i4 = i2;
                  if ((((RecentUser)localObject2).extraInfo instanceof MayKnowRecommend))
                  {
                    localObject2 = (MayKnowRecommend)((RecentUser)localObject2).extraInfo;
                    ((ArrayList)localObject1).add(((MayKnowRecommend)localObject2).uin);
                    localArrayList1.add(((MayKnowRecommend)localObject2).recommendReason);
                    localArrayList2.add(Integer.valueOf(i3 - i2));
                    localArrayList3.add(((MayKnowRecommend)localObject2).algBuffer);
                    i4 = i2;
                  }
                }
              }
            }
          }
          i3 += 1;
        }
        if (!((ArrayList)localObject1).isEmpty()) {
          ContactReportUtils.a(s(), 25, (ArrayList)localObject1, localArrayList1, localArrayList2, localArrayList3, 2, null);
        }
      }
    }
  }
  
  int G()
  {
    int i1 = 0;
    while (i1 < this.t.getCount())
    {
      if ((this.t.getItem(i1) instanceof RecentItemMayKnowFriendVerticalListData)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  protected boolean H()
  {
    int i1 = this.r;
    return (i1 != 0) && (i1 != 1);
  }
  
  public void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "setThemeDiyBgConversation ");
    }
    ThemeBackground.a(this.aF, this.s, 1, 2130838959, "-conversation-");
  }
  
  public void J()
  {
    this.A.obtainMessage(1048).sendToTarget();
  }
  
  public RecentAdapter K()
  {
    return this.t;
  }
  
  public void L()
  {
    if (!this.aG) {
      return;
    }
    if (!this.y.d(PushBannerProcessor.a)) {
      return;
    }
    Object localObject = this.aI;
    int i1;
    if ((localObject != null) && (((FPSSwipListView)localObject).getChildCount() > 0) && (this.aI.getHeaderViewsCount() > 0) && (this.aI.getFirstVisiblePosition() - this.aI.getHeaderViewsCount() >= 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0)
    {
      this.bY = false;
      return;
    }
    if (this.bY) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "checkPushBannerReport");
    }
    this.bY = true;
    localObject = this.y.a(PushBannerProcessor.a);
    if (localObject != null) {
      localObject = ((Banner)localObject).c.getTag(2131427870);
    } else {
      localObject = null;
    }
    ThreadManager.post(new Conversation.61(this, localObject), 5, null, false);
  }
  
  public MsgTabStoryNodeListManager M()
  {
    return this.w;
  }
  
  public void N()
  {
    Object localObject = K();
    if (this.q)
    {
      if (localObject == null) {
        return;
      }
      CareNotificationBar localCareNotificationBar = this.al;
      if (localCareNotificationBar == null) {
        return;
      }
      boolean bool = localCareNotificationBar.a((RecentAdapter)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("moveToCaredItemCyclic: invoked.  canFindUnreadItem: ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" currentCaredType:");
        ((StringBuilder)localObject).append(this.am);
        ((StringBuilder)localObject).append(" currentUnreadCaredItemIndex: ");
        ((StringBuilder)localObject).append(this.ao);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject).toString());
      }
      int i1 = (int)(P().getResources().getDimension(2131299612) + P().getResources().getDimension(2131299629) / 2.0F);
      int i2 = this.ao + this.aI.getHeaderViewsCount();
      if (this.ao == 0) {
        i1 = 0;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "moveToCaredItemCyclic: invoked. selection1 ", " position: ", Integer.valueOf(i2) });
        }
        this.al.e();
        this.aI.setSelectionFromTop(i2, i1);
        localObject = new Conversation.64(this, i2);
        this.A.postDelayed((Runnable)localObject, 250L);
      }
    }
    ReportController.b(this.aF, "dc00898", "", "", "0X800A1E3", "0X800A1E3", 0, 0, "", "", "", "");
  }
  
  void O()
  {
    if (this.ai == null)
    {
      this.ai = ActionSheet.create(P());
      this.ai.addButton(2131888204);
      this.ai.addCancelButton(2131887648);
      this.ai.setOnButtonClickListener(new Conversation.65(this));
    }
    this.ai.show();
  }
  
  protected int a(String paramString, int paramInt)
  {
    int i2 = 4;
    int i1;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        i1 = i2;
        if (paramInt == 1000) {
          return i1;
        }
        if (paramInt != 1001) {
          if ((paramInt != 1008) && (paramInt != 1009) && (paramInt != 1012)) {
            if (paramInt != 3000) {
              if (paramInt != 5000) {
                if (paramInt != 6000) {
                  if (paramInt != 7000) {
                    if ((paramInt != 7120) && (paramInt != 7200))
                    {
                      if ((paramInt == 10002) || (paramInt == 10004)) {
                        break label194;
                      }
                      i1 = i2;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    switch (paramInt)
    {
    default: 
      i1 = i2;
      switch (paramInt)
      {
      default: 
        return 0;
      }
    case 1005: 
      return 6;
      return 9;
      return 11;
      return 10;
      return 8;
      return 2;
      return 7;
    case 1003: 
      label194:
      return 5;
      return 3;
      if (!RecentUtil.a(s(), paramString)) {
        return 4;
      }
      i1 = 1;
    }
    return i1;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    StartupTracker.a(null, "Recent_Start");
    StartupTracker.a(null, "Recent_CreateView");
    Object localObject1 = (BaseActivity)P();
    if ((localObject1 != null) && ((localObject1 instanceof SplashActivity)))
    {
      localObject2 = (SplashActivity)localObject1;
      localObject1 = ((SplashActivity)localObject2).mPreloadConversationView;
      ((SplashActivity)localObject2).mPreloadConversationView = null;
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramLayoutInflater.inflate(2131624569, null);
    }
    StartupTracker.a("Recent_CreateView", null);
    return localObject2;
  }
  
  protected void a()
  {
    StartupTracker.a(null, "Recent_OnCreate");
    super.a();
    this.Y = FrameHelperActivity.a((BaseActivity)P());
    this.T = new ConversationHotChatCtrl(this);
    this.A = new CustomHandler(Looper.getMainLooper(), this.ap);
    this.G = new CustomHandler(ThreadManager.getRecentThreadLooper(), this);
    this.aU = new RecentPubAccHelper(this.A, P());
    this.U = new ConversationTitleBtnCtrl(this);
    ag();
    af();
    c(false);
    a("pa_WhiteList_in_studyMode_860178803");
    this.aZ = new ConversationHelper(s());
    StartupTracker.a("Recent_OnCreate", null);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResult, [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",");
      localStringBuilder.append(paramIntent);
      QLog.i("Q.recent", 2, localStringBuilder.toString());
    }
    if (paramInt1 != 2)
    {
      if (paramInt1 != 1000)
      {
        if (paramInt1 != 1300)
        {
          if (paramInt1 != 9010)
          {
            if (paramInt1 != 9999)
            {
              if (paramInt1 != 9001)
              {
                if (paramInt1 != 9002) {
                  return;
                }
                b(paramInt1);
                return;
              }
              a(paramInt2);
              return;
            }
            Y();
            return;
          }
          RecentOptPopBar.a(paramIntent, this.Y);
          return;
        }
        a(paramInt2, paramIntent);
        return;
      }
      if (paramInt2 == 0)
      {
        R();
        s().exit(false);
      }
    }
    else if (P() != null)
    {
      P().setCanLock(false);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshRecentList invalidate params arg1: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", arg2: ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    if (this.aI == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "refreshRecentList|invalidate to refresh");
      }
      return;
    }
    if ((paramInt2 <= 10) && (paramInt2 >= 8))
    {
      if ((paramInt2 == 10) && (!(paramObject instanceof Long)))
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("refreshRecentList invalidate params arg2: ");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(", obj: ");
          ((StringBuilder)localObject).append(paramObject);
          QLog.i("Q.recent", 4, ((StringBuilder)localObject).toString());
        }
        return;
      }
      if (((paramInt2 == 8) || (paramInt2 == 9)) && (!(paramObject instanceof String)))
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("refreshRecentList invalidate params arg2: ");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(", obj:");
          ((StringBuilder)localObject).append(paramObject);
          QLog.i("Q.recent", 4, ((StringBuilder)localObject).toString());
        }
        return;
      }
      if (!H())
      {
        this.M = false;
        localObject = this.G.obtainMessage(11);
        ((Message)localObject).arg1 = paramInt1;
        ((Message)localObject).arg2 = paramInt2;
        ((Message)localObject).obj = paramObject;
        this.G.sendMessage((Message)localObject);
        return;
      }
      this.M = true;
      return;
    }
    if (QLog.isDevelopLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("refreshRecentList invalidate params arg2: ");
      paramObject.append(paramInt2);
      QLog.i("Q.recent", 4, paramObject.toString());
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.A.removeMessages(paramInt);
    }
    this.A.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendVasBannerMsg[what:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",delay:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",refreshType:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = Message.obtain();
    ((Message)localObject).what = paramInt;
    ((Message)localObject).obj = paramString;
    paramString = this.y;
    if (paramString != null) {
      paramString.a(VasADBannerProcessor.a, (Message)localObject, paramLong, paramBoolean);
    }
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    String str1;
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    RecentUserProxy localRecentUserProxy = s().getProxyManager().g();
    String str2 = paramRecentBaseData.getRecentUserUin();
    FriendsManager localFriendsManager = (FriendsManager)this.aF.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (QFileAssistantUtils.a(str2))
    {
      ((FileAssistTopHandler)s().getBusinessHandler(BusinessHandlerFactory.FILE_ASSIST_TOP)).a(paramBoolean);
      return;
    }
    if ((paramInt == 7000) && (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(str2)))
    {
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).setTopInRecentList(s(), str2, paramBoolean);
      ReportController.b(this.aF, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str1, paramString, "");
    }
    else if (paramInt == 5000)
    {
      a(paramRecentBaseData, paramString, paramBoolean, str1);
    }
    else if (paramInt == 5001)
    {
      ((HotChatCenterManager)this.aF.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a(paramBoolean);
    }
    else if (paramInt == 1)
    {
      if (!b(paramRecentBaseData, paramBoolean, localRecentUserProxy, str2)) {}
    }
    else if ((paramInt == 0) && (localFriendsManager.n(str2)))
    {
      if (!a(paramInt, paramBoolean, str2)) {}
    }
    else if (paramInt == 10015)
    {
      if (a(paramRecentBaseData, paramBoolean, localRecentUserProxy, str2)) {
        ((IGameMsgBoxRuntimeService)this.aF.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).setGameTop(paramBoolean);
      }
    }
    else if (a(paramRecentBaseData, paramBoolean, localRecentUserProxy, str2))
    {
      return;
    }
    a(paramInt, paramRecentBaseData, paramBoolean, str1, localRecentUserProxy);
  }
  
  protected void a(int paramInt, RecentUser paramRecentUser)
  {
    Object localObject;
    if ((paramRecentUser != null) && (paramInt != 0))
    {
      if (((paramInt & 0x1) != 0) && (this.y != null))
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 2001;
        ((Message)localObject).getData().putString("troopUin", paramRecentUser.uin);
        this.y.b(TroopAssistBannerProcessor.a, (Message)localObject);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.getType());
      }
      if ((paramInt & 0x4) != 0)
      {
        RecentUtil.a(s(), paramRecentUser, -1);
        QQToast.makeText(P(), HardCodeUtil.a(2131900762), 0).show();
      }
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshAfterClick|[");
      ((StringBuilder)localObject).append(paramRecentUser);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("Q.recent", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 != 8) && (paramInt1 != 9)) {
      return;
    }
    a(0, paramInt1, RecentDataListManager.a(paramString, paramInt2));
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      ad();
      b(800L);
    }
    Object localObject = s().getHandler(AVNotifyCenter.class);
    if (localObject != null)
    {
      Message localMessage = ((MqqHandler)localObject).obtainMessage(10010);
      localMessage.obj = Boolean.valueOf(paramBoolean1);
      ((MqqHandler)localObject).sendMessage(localMessage);
    }
    boolean bool1 = s().isMSFConnect;
    int i2 = 0;
    if (bool1) {
      this.y.a(NetNeedSignOnBannerProcessor.a, 0, null);
    }
    boolean bool3 = paramBoolean1 ^ true;
    LoadingStateManager.b().a(bool3);
    localObject = this.y;
    int i3 = NetStateBannerProcessor.a;
    if (bool3) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    ((BannerManager)localObject).a(i3, i1, null);
    boolean bool2 = LoadingStateManager.b().e();
    bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (paramInt == 1134012) {
        bool1 = false;
      }
    }
    LoadingStateManager.b().b(bool1);
    localObject = this.y;
    i3 = IllegalNetworkBannerProcessor.a;
    int i1 = i2;
    if (bool1) {
      i1 = 2;
    }
    ((BannerManager)localObject).a(i3, i1, null);
    e(paramBoolean2 | bool3 | bool1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("refreshNetStatus");
      ((StringBuilder)localObject).append(", app.isMSFConnect = ");
      ((StringBuilder)localObject).append(s().isMSFConnect);
      ((StringBuilder)localObject).append(", isNetSupport = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", loadingState = ");
      ((StringBuilder)localObject).append(LoadingStateManager.b().f());
      ((StringBuilder)localObject).append(", msg = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong)
  {
    a(0, 10, Long.valueOf(paramLong));
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.j();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (GlobalImageCache.a != null) {
      GlobalImageCache.a.evictAll();
    }
    int i1 = QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i1 + 1);
    RouteUtils.a(paramActivity, localIntent, "/base/login");
    if (QQPlayerService.b())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    RecentOptPopBar localRecentOptPopBar = this.m;
    if ((localRecentOptPopBar != null) && (localRecentOptPopBar.d())) {
      this.m.e();
    }
    super.a(paramConfiguration);
  }
  
  void a(Message paramMessage, boolean paramBoolean)
  {
    int i1;
    if (paramMessage == null) {
      i1 = 0;
    } else {
      i1 = paramMessage.what;
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder(150);
      paramMessage.append("refreshNetStatus");
      paramMessage.append(", app.isMSFConnect = ");
      paramMessage.append(s().isMSFConnect);
      paramMessage.append(", initLoadingHandle = ");
      paramMessage.append(paramBoolean);
      paramMessage.append(", loadingState = ");
      paramMessage.append(LoadingStateManager.b().f());
      paramMessage.append(", what = ");
      paramMessage.append(i1);
      QLog.i("Q.recent", 2, paramMessage.toString());
    }
    if (s().isMSFConnect)
    {
      a(i1, true, paramBoolean);
      a(i1, true);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new Conversation.2(this, i1, paramBoolean));
  }
  
  protected void a(View paramView, int paramInt)
  {
    View localView = this.i;
    if (localView == null) {
      return;
    }
    if (paramView == null)
    {
      localView.setVisibility(8);
      return;
    }
    if (!QQTheme.isSimpleWhite())
    {
      this.i.setVisibility(8);
      return;
    }
    if ((paramView.getTop() == 0) && (paramInt == 0))
    {
      this.i.setVisibility(8);
      return;
    }
    this.i.setVisibility(0);
  }
  
  public void a(View paramView, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMsgTabRecommendBClick uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    int i2 = paramView.getId();
    if ((paramString.equals("sp_uin_for_title")) && (i2 == 2131444456))
    {
      O();
      ContactReportUtils.a(s(), "msgtab_list_clk", 2);
      return;
    }
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.aF.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    Object localObject = new AllInOne(paramString, 102);
    boolean bool = localMayknowRecommendManager.m();
    ArrayList localArrayList = localMayknowRecommendManager.f();
    int i1 = 0;
    while (i1 < localArrayList.size())
    {
      paramView = (MayKnowRecommend)localArrayList.get(i1);
      if (paramView.uin.equals(paramString)) {
        break label176;
      }
      i1 += 1;
    }
    paramView = null;
    i1 = 0;
    label176:
    i1 -= G();
    if (paramView == null)
    {
      QLog.d("Q.recent", 1, "onMsgTabRecommendBClick recommend is null ");
      return;
    }
    if (i2 == 2131444718)
    {
      if (!NetworkUtil.isNetworkAvailable(paramContext))
      {
        QQToast.makeText(paramContext, paramContext.getResources().getString(2131889169), 0).show(P().getTitleBarHeight());
        return;
      }
      paramString = (FriendsManager)this.aF.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((!paramString.n(paramView.uin)) && (!paramString.v(paramView.uin)))
      {
        paramString = paramView.getDisplayName(localMayknowRecommendManager.m());
        paramContext = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramContext, 1, paramView.uin, null, 3045, 25, paramString, null, null, paramContext.getString(2131886199), null);
        ReportController.b(this.aF, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(25), "", "", "");
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(P(), paramContext);
      }
      else if (paramString.n(paramView.uin))
      {
        paramView.friendStatus = 2;
      }
      else
      {
        paramView.friendStatus = 1;
      }
      ReportController.b(this.aF, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
      ContactReportUtils.a(s(), paramView.uin, "frd_list_add", 25, 1, paramView.recommendReason, i1, paramView.algBuffer, 2);
      return;
    }
    paramString = paramView.getRecommendName(bool);
    if (!TextUtils.isEmpty(paramString)) {
      ((AllInOne)localObject).recommendName = paramString;
    }
    if (!TextUtils.isEmpty(paramView.nick)) {
      ((AllInOne)localObject).nickname = paramView.nick;
    }
    ((AllInOne)localObject).profileEntryType = 88;
    paramString = new Bundle();
    paramString.putString("recommend_reason", paramView.recommendReason);
    paramString.putInt("recommend_pos", i1);
    paramString.putByteArray("recommend_algh_id", paramView.algBuffer);
    paramString.putInt("key_display_type", 2);
    ProfileActivity.a(paramContext, (AllInOne)localObject, paramString);
    ContactReportUtils.a(s(), paramView.uin, "frd_list_clk", 25, 0, paramView.recommendReason, i1, paramView.algBuffer, 2);
  }
  
  protected void a(View paramView1, View paramView2)
  {
    float f1;
    if (QQTheme.isNowSimpleUI()) {
      f1 = 54.0F;
    } else {
      f1 = 60.0F;
    }
    int i1 = ViewUtils.dip2px(f1);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    localLayoutParams.leftMargin = i1;
    paramView1.setLayoutParams(localLayoutParams);
    paramView1 = (RelativeLayout.LayoutParams)paramView2.getLayoutParams();
    paramView1.leftMargin = i1;
    paramView2.setLayoutParams(paramView1);
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    ae();
  }
  
  public void a(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if ((s().mAutomator != null) && (s().mAutomator.h()) && (paramVipGiftDownloadInfo != null) && (paramVipGiftDownloadInfo.f == 0L) && (paramVipGiftDownloadInfo.c != 0L)) {
      paramVipGiftManager.c(paramVipGiftDownloadInfo.c);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = (IFeatureRuntimeService)P().getAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
    boolean bool = ((IFeatureRuntimeService)localObject).isFeatureSwitchEnable(paramString);
    if (bool)
    {
      ServiceAccountFolderManager.a(bool);
      localObject = ((IFeatureRuntimeService)localObject).getJSONObject(paramString, "");
      if (localObject != null)
      {
        paramString = new HashSet();
        try
        {
          localObject = ((JSONObject)localObject).optJSONArray("studymode");
          if (localObject != null)
          {
            int i1 = 0;
            while (i1 < ((JSONArray)localObject).length())
            {
              paramString.add(((JSONArray)localObject).getString(i1));
              i1 += 1;
            }
            ServiceAccountFolderManager.a(paramString);
            return;
          }
        }
        catch (JSONException paramString)
        {
          QLog.e("Q.recent", 1, "Parsing WhitList From DataSet of Toggle is failed , ", paramString);
        }
      }
    }
  }
  
  public void a(@androidx.annotation.NonNull List<RecentBaseData> paramList)
  {
    if (this.aF == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          return;
        }
        i4 = QCallFacade.a(s());
        if (TripleGraySwitchUtil.a(this.aF.getApp(), "KEY_USE_NEW_COUNT"))
        {
          paramList = paramList.iterator();
          i1 = 0;
          if (!paramList.hasNext()) {
            break label221;
          }
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
          if ((localRecentBaseData == null) || (!localRecentBaseData.isUnreadMsgNumInTabNum()) || (RecentAdapter.a(s(), localRecentBaseData))) {
            continue;
          }
          i1 += localRecentBaseData.getUnreadNum();
          continue;
        }
        paramList = s().getMessageFacade();
        if (paramList == null) {
          break label232;
        }
        i1 = paramList.w();
      }
      catch (Throwable paramList)
      {
        int i4;
        paramList.printStackTrace();
        return;
      }
      this.O = (i1 + i4);
      if (QLog.isColorLevel()) {
        QLog.d("fetchUnReadCount", 2, String.format("Conversation, mUnReadCount[%s], msgUnReadCount[%s], callUnReadCount[%s], isCallTabShow[%s],msgUnReadCountNew[%s]", new Object[] { Integer.valueOf(this.O), Integer.valueOf(i1), Integer.valueOf(i4), Boolean.valueOf(s().isCallTabShow), Integer.valueOf(i2) }));
      }
      LaunchReportHelper.a(this.aF);
      return;
      label221:
      int i3 = i1;
      int i2 = i1;
      int i1 = i3;
      continue;
      label232:
      i1 = 0;
      i2 = 0;
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    Object localObject = this.aI;
    if ((localObject != null) && (this.D))
    {
      this.D = false;
      ((FPSSwipListView)localObject).springBackOverScrollHeaderView();
    }
    localObject = this.t;
    if (localObject != null) {
      ((RecentAdapter)localObject).b(s());
    }
    this.y.a(PushBannerProcessor.a, 0, null);
    RecentDataListManager.a().b();
    TianShuManager.getInstance().clearNecessaryDataCacheForReport();
    TianShuManager.setLastClickAdTraceInfo("", "");
    localObject = this.T;
    if (localObject != null) {
      ((ConversationHotChatCtrl)localObject).a(paramLogoutReason);
    }
    localObject = this.aa;
    if (localObject != null) {
      ((ConversationHongBaoV2)localObject).a(paramLogoutReason);
    }
    paramLogoutReason = this.z;
    if ((paramLogoutReason != null) && (paramLogoutReason.isShowing()) && (!this.F)) {}
    try
    {
      this.z.dismiss();
      this.z = null;
      label143:
      this.A.removeMessages(1073);
      return;
    }
    catch (Exception paramLogoutReason)
    {
      break label143;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("Q.recent", 2, "onResume...");
    if (this.aF == null) {
      return;
    }
    this.bb = false;
    s().isConversationTabShow = true;
    this.C = true;
    this.aQ = paramBoolean;
    MayknowRecommendManager.l = true;
    aw();
    super.a(paramBoolean);
    if (AppSetting.e) {
      P().setTitle(e(2131891480));
    }
    aq();
    TimeManager.a().e();
    SearchBarAssistant localSearchBarAssistant = this.u;
    if (localSearchBarAssistant != null) {
      localSearchBarAssistant.b();
    }
    if (AppSetting.m) {
      s().setMainActivityState(true);
    }
    try
    {
      P().getWindow().setSoftInputMode(32);
    }
    catch (Exception localException)
    {
      QLog.e("Q.recent", 1, localException, new Object[0]);
    }
    ArkTipsManager.b().g();
    this.r = 0;
    if (this.P)
    {
      if (this.a != 1000L) {
        this.a = 1000L;
      }
      if (!this.Q) {
        this.A.sendEmptyMessage(1020);
      }
      if (this.M)
      {
        RecentAdapter localRecentAdapter = this.t;
        if (localRecentAdapter != null) {
          localRecentAdapter.notifyDataSetChanged();
        }
      }
      a(0L);
      p();
      this.A.sendEmptyMessageDelayed(1030, 1000L);
    }
    else
    {
      if (!this.aY)
      {
        this.aY = true;
        this.A.sendEmptyMessageDelayed(1067, 1000L);
      }
      this.A.sendEmptyMessageDelayed(1025, 3000L);
    }
    az();
    aA();
    aE();
    aP();
    av();
    aD();
    ax();
    aB();
    ThreadManager.getSubThreadHandler().postDelayed(this.bu, 5000L);
    a(this.aI);
    ImaxAdRecentUserManager.a().a(s(), this.t, this.aI);
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).setHasPreloadWebProcessor(false);
    ar();
    k(paramBoolean);
    ApngImage.playByTag(2);
    au();
    aF();
    at();
    as();
    DarkModeManager.a(null);
    l(paramBoolean);
    UpComingMsgUtil.a((BaseActivity)P(), paramBoolean);
  }
  
  protected boolean a(Message paramMessage)
  {
    boolean bool = Foreground.isCurrentProcessForeground();
    if ((paramMessage.arg1 == 4) && (Z())) {
      return true;
    }
    if (((this.C) || (paramMessage.arg1 != 0)) && (this.aF.isLogin()) && (bool)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "isRefreshRecentDataNecessary[isForeground:", Boolean.valueOf(this.C), ",msg.arg1:", Integer.valueOf(paramMessage.arg1), " msg.arg2", Integer.valueOf(paramMessage.arg2), ",isLogin:", Boolean.valueOf(this.aF.isLogin()), " ,isProcessForeground=", Boolean.valueOf(bool) });
    }
    return false;
  }
  
  public boolean a(ListView paramListView)
  {
    if (paramListView == this.aI)
    {
      if (this.D) {
        return true;
      }
      paramListView = this.x;
      if (paramListView != null) {
        paramListView.a(0L);
      }
      boolean bool2 = s().getMsgHandler().H() ^ true;
      paramListView = (SpringFestivalEntryManager)this.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      boolean bool1 = bool2;
      if (paramListView != null)
      {
        bool1 = bool2;
        if (paramListView.l())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "handlePullRefresh fakeRefresh for 2021HB");
          }
          bool1 = true;
        }
      }
      if (bool1)
      {
        this.D = true;
        e(true);
        this.G.sendEmptyMessageDelayed(40001, 500L);
        return true;
      }
      this.E = SystemClock.uptimeMillis();
      StartupTracker.a("Conversation_PullToRefresh_start", 0L);
      t();
      ThreadManager.getSubThreadHandler().post(new Conversation.10(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      }
      paramListView = (MsgTabStoryNodeConfigManager)s().getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER);
      if ((paramListView != null) && (paramListView.a))
      {
        ((MsgTabStoryManager)this.aF.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a().a(2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "MsgTabNodeListLoader update data");
        }
      }
      paramListView = this.aJ;
      if (paramListView != null) {
        paramListView.handlePullRefresh();
      }
      this.A.sendEmptyMessage(1054);
      a(3002, 200L, true, "vas_banner_pull_refresh");
      a(1072, 500L, true);
      a(500, "tianshu_req_splash_type_pull_down", true);
      a(500, "tianshu_req_renewals_type_pull_down");
      this.y.b(VerifyPhoneBannerProcessor.a, 3000);
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "send MSG_CHECK_MEDAL_GUIDE");
      }
    }
    return true;
  }
  
  public void b(long paramLong)
  {
    if (this.D) {
      a(1016, paramLong, true);
    }
  }
  
  protected void b(List<RecentBaseData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (QLog.isColorLevel())
      {
        Object localObject = this.aC;
        if (localObject == null) {
          this.aC = new StringBuilder();
        } else {
          ((StringBuilder)localObject).setLength(0);
        }
        localObject = new ArrayList();
        ((List)localObject).addAll(paramList);
        this.aC.append("unreadinfo, [");
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
          if ((localRecentBaseData != null) && (localRecentBaseData.mUnreadNum > 0))
          {
            StringBuilder localStringBuilder = this.aC;
            localStringBuilder.append(localRecentBaseData.getRecentUserType());
            localStringBuilder.append("-");
            localStringBuilder.append(localRecentBaseData.getRecentUserUin());
            localStringBuilder.append("-");
            localStringBuilder.append(localRecentBaseData.mUnreadNum);
            localStringBuilder.append("-");
            localStringBuilder.append(localRecentBaseData.mUnreadFlag);
            localStringBuilder.append(" , ");
          }
        }
        this.aC.append("]");
        ((List)localObject).clear();
        QLog.i("Q.recent", 2, this.aC.toString());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    c(true);
    this.bc = paramBoolean;
    if (paramBoolean)
    {
      this.be = System.currentTimeMillis();
      if (this.C)
      {
        this.bd = true;
        aQ();
      }
    }
    this.Y.q.sendEmptyMessage(5);
    ConversationTitleBtnCtrl localConversationTitleBtnCtrl = this.U;
    if (localConversationTitleBtnCtrl != null) {
      localConversationTitleBtnCtrl.d();
    }
  }
  
  public boolean b(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if (paramVipGiftDownloadInfo != null)
    {
      if (paramVipGiftManager == null) {
        return false;
      }
      if (paramVipGiftDownloadInfo.f == 3L) {
        paramVipGiftManager.a(4L, paramVipGiftDownloadInfo.c);
      }
      if ((paramVipGiftDownloadInfo != null) && (paramVipGiftDownloadInfo.f == 2L) && (s().mAutomator.h()) && (this.aG)) {
        return true;
      }
    }
    return false;
  }
  
  public void bQ_()
  {
    QLog.d("Q.recent", 2, "onPause...");
    ApngImage.pauseByTag(2);
    super.bQ_();
    this.C = false;
    Object localObject = this.aa;
    if (localObject != null) {
      ((ConversationHongBaoV2)localObject).n();
    }
    localObject = this.ab;
    if (localObject != null) {
      ((SpringFestivalTaskCallback)localObject).f();
    }
    if (b > 0L)
    {
      b = 0L;
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).setResumeFlagFromConversation(b);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).saveNormalEnterConversationTime(b);
    }
    this.A.removeMessages(1053);
    this.bY = false;
    com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConstants.a = false;
    if (this.aF == null) {
      return;
    }
    if (AppSetting.m) {
      s().setMainActivityState(false);
    }
    TimeManager.a().d();
    if ((!this.bb) && (!this.bc) && (RecentParcelUtil.a(s())))
    {
      if (System.currentTimeMillis() - this.be > 5000L)
      {
        localObject = this.t.j();
        QQAppInterface localQQAppInterface = s();
        ThreadManager.getSubThreadHandler().post(new Conversation.3(this, localQQAppInterface, (List)localObject));
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "just switch account, don't save RU");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "enter AIO or switching account, don't save RU");
    }
    localObject = this.aI;
    if (localObject != null)
    {
      if (((FPSSwipListView)localObject).getVisibility() == 0) {
        this.aI.hideCurShowingRightView();
      }
      this.aI.a();
    }
    this.A.removeMessages(10000);
    this.A.removeMessages(1070);
    this.G.removeMessages(10);
    this.G.removeMessages(9);
    this.G.removeMessages(8);
    localObject = this.bk;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a();
    }
    localObject = this.m;
    if (localObject != null) {
      ((RecentOptPopBar)localObject).n();
    }
    s().isConversationTabShow = false;
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).handConversationToHide();
    localObject = this.aR;
    if (localObject != null) {
      ((PreloadProcHitSession)localObject).e();
    }
    localObject = this.aS;
    if (localObject != null) {
      ((PreloadProcHitSession)localObject).e();
    }
    this.A.removeMessages(1134062);
    QZoneReport.b = false;
    localObject = this.w;
    if (localObject != null) {
      ((MsgTabStoryNodeListManager)localObject).m();
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).leaveMsgTab();
    PublicAccountEventReport.a();
  }
  
  public void c()
  {
    super.c();
    Object localObject = this.m;
    if ((localObject != null) && (((RecentOptPopBar)localObject).d())) {
      this.m.e();
    }
    localObject = this.aP;
    if (localObject != null) {
      ((PreloadProcHitSession)localObject).e();
    }
    localObject = this.aj;
    if (localObject != null) {
      ((LoginwelcomeHelper)localObject).e();
    }
    localObject = this.aJ;
    if (localObject != null) {
      ((MiniAppPullInterface)localObject).onStop();
    }
  }
  
  protected void c(long paramLong)
  {
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.aF.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramLong);
    }
  }
  
  /* Error */
  protected void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 744	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +36 -> 39
    //   6: new 653	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 654	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc_w 4131
    //   18: invokevirtual 660	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: iload_1
    //   24: invokevirtual 663	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc_w 665
    //   31: iconst_2
    //   32: aload_2
    //   33: invokevirtual 669	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 672	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload_0
    //   40: getfield 711	com/tencent/mobileqq/activity/home/Conversation:aI	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +18 -> 63
    //   48: aload_2
    //   49: invokevirtual 4134	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   52: ifge +11 -> 63
    //   55: aload_0
    //   56: getfield 711	com/tencent/mobileqq/activity/home/Conversation:aI	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   59: iconst_0
    //   60: invokevirtual 4137	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   63: aload_0
    //   64: iconst_0
    //   65: invokespecial 4139	com/tencent/mobileqq/activity/home/Conversation:j	(Z)V
    //   68: iload_1
    //   69: ifeq +506 -> 575
    //   72: invokestatic 2025	com/tencent/mobileqq/managers/LoadingStateManager:b	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   75: invokevirtual 4140	com/tencent/mobileqq/managers/LoadingStateManager:g	()V
    //   78: invokestatic 1152	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentDataListManager;
    //   81: invokevirtual 3875	com/tencent/mobileqq/activity/recent/RecentDataListManager:b	()V
    //   84: invokestatic 3878	cooperation/vip/tianshu/TianShuManager:getInstance	()Lcooperation/vip/tianshu/TianShuManager;
    //   87: invokevirtual 3881	cooperation/vip/tianshu/TianShuManager:clearNecessaryDataCacheForReport	()V
    //   90: ldc_w 869
    //   93: ldc_w 869
    //   96: invokestatic 1080	cooperation/vip/tianshu/TianShuManager:setLastClickAdTraceInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 296	com/tencent/mobileqq/activity/home/Conversation:D	Z
    //   103: ifeq +21 -> 124
    //   106: aload_0
    //   107: getfield 711	com/tencent/mobileqq/activity/home/Conversation:aI	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +12 -> 124
    //   115: aload_0
    //   116: iconst_0
    //   117: putfield 296	com/tencent/mobileqq/activity/home/Conversation:D	Z
    //   120: aload_2
    //   121: invokevirtual 4143	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   124: aload_0
    //   125: getfield 827	com/tencent/mobileqq/activity/home/Conversation:bp	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   128: astore_2
    //   129: aload_2
    //   130: ifnull +23 -> 153
    //   133: aload_2
    //   134: invokevirtual 4144	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   137: goto +11 -> 148
    //   140: astore_2
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 827	com/tencent/mobileqq/activity/home/Conversation:bp	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   146: aload_2
    //   147: athrow
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield 827	com/tencent/mobileqq/activity/home/Conversation:bp	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   153: aload_0
    //   154: getfield 824	com/tencent/mobileqq/activity/home/Conversation:bn	Landroid/app/Dialog;
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +23 -> 182
    //   162: aload_2
    //   163: invokevirtual 2043	android/app/Dialog:dismiss	()V
    //   166: goto +11 -> 177
    //   169: astore_2
    //   170: aload_0
    //   171: aconst_null
    //   172: putfield 824	com/tencent/mobileqq/activity/home/Conversation:bn	Landroid/app/Dialog;
    //   175: aload_2
    //   176: athrow
    //   177: aload_0
    //   178: aconst_null
    //   179: putfield 824	com/tencent/mobileqq/activity/home/Conversation:bn	Landroid/app/Dialog;
    //   182: aload_0
    //   183: getfield 2740	com/tencent/mobileqq/activity/home/Conversation:aZ	Lcom/tencent/mobileqq/activity/recent/ConversationHelper;
    //   186: astore_2
    //   187: aload_2
    //   188: ifnull +11 -> 199
    //   191: aload_2
    //   192: aload_0
    //   193: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   196: invokevirtual 4146	com/tencent/mobileqq/activity/recent/ConversationHelper:a	(Lcom/tencent/common/app/business/BaseQQAppInterface;)V
    //   199: aload_0
    //   200: getfield 2185	com/tencent/mobileqq/activity/home/Conversation:u	Lcom/tencent/mobileqq/activity/contacts/base/SearchBarAssistant;
    //   203: astore_2
    //   204: aload_2
    //   205: ifnull +11 -> 216
    //   208: aload_2
    //   209: aload_0
    //   210: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   213: invokevirtual 4147	com/tencent/mobileqq/activity/contacts/base/SearchBarAssistant:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   216: aload_0
    //   217: getfield 1323	com/tencent/mobileqq/activity/home/Conversation:p	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +11 -> 233
    //   225: aload_2
    //   226: aload_0
    //   227: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   230: invokevirtual 4148	com/tencent/mobileqq/activity/recent/RecentTroopMenuOption:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   233: aload_0
    //   234: getfield 674	com/tencent/mobileqq/activity/home/Conversation:t	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   237: astore_2
    //   238: aload_2
    //   239: ifnull +22 -> 261
    //   242: aload_2
    //   243: aload_0
    //   244: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   247: invokevirtual 4149	com/tencent/mobileqq/activity/recent/RecentAdapter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   250: aload_0
    //   251: iconst_1
    //   252: bipush 10
    //   254: lconst_0
    //   255: invokestatic 695	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   258: invokevirtual 698	com/tencent/mobileqq/activity/home/Conversation:a	(IILjava/lang/Object;)V
    //   261: aload_0
    //   262: getfield 711	com/tencent/mobileqq/activity/home/Conversation:aI	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   265: astore_2
    //   266: aload_2
    //   267: ifnull +8 -> 275
    //   270: aload_2
    //   271: iconst_0
    //   272: invokevirtual 4152	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   275: aload_0
    //   276: iconst_0
    //   277: invokespecial 1238	com/tencent/mobileqq/activity/home/Conversation:i	(Z)V
    //   280: aload_0
    //   281: getfield 2604	com/tencent/mobileqq/activity/home/Conversation:w	Lcom/tencent/biz/qqstory/msgTabNode/view/MsgTabStoryNodeListManager;
    //   284: astore_2
    //   285: aload_2
    //   286: ifnull +11 -> 297
    //   289: aload_2
    //   290: aload_0
    //   291: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   294: invokevirtual 4153	com/tencent/biz/qqstory/msgTabNode/view/MsgTabStoryNodeListManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   297: aload_0
    //   298: getfield 2464	com/tencent/mobileqq/activity/home/Conversation:aJ	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   301: astore_2
    //   302: aload_2
    //   303: ifnull +13 -> 316
    //   306: aload_2
    //   307: aload_0
    //   308: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   311: invokeinterface 4156 2 0
    //   316: aload_0
    //   317: getfield 715	com/tencent/mobileqq/activity/home/Conversation:aL	Lcooperation/vip/ad/TianshuAdManager;
    //   320: astore_2
    //   321: aload_2
    //   322: ifnull +11 -> 333
    //   325: aload_2
    //   326: aload_0
    //   327: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   330: invokevirtual 4157	cooperation/vip/ad/TianshuAdManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   333: aload_0
    //   334: getfield 1781	com/tencent/mobileqq/activity/home/Conversation:aM	Lcooperation/vip/ad/TianshuSplashManager;
    //   337: astore_2
    //   338: aload_2
    //   339: ifnull +11 -> 350
    //   342: aload_2
    //   343: aload_0
    //   344: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: invokevirtual 4158	cooperation/vip/ad/TianshuSplashManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   350: aload_0
    //   351: getfield 334	com/tencent/mobileqq/activity/home/Conversation:ab	Lcom/tencent/mobileqq/activity/springfestival/entry/SpringFestivalTaskCallback;
    //   354: astore_2
    //   355: aload_2
    //   356: ifnull +11 -> 367
    //   359: aload_2
    //   360: aload_0
    //   361: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   364: invokevirtual 4159	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalTaskCallback:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   367: ldc_w 665
    //   370: ldc_w 4161
    //   373: aload_0
    //   374: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   377: getfield 2375	com/tencent/mobileqq/app/QQAppInterface:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   380: invokevirtual 2379	com/tencent/mobileqq/app/automator/Automator:g	()Z
    //   383: invokestatic 811	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   386: invokestatic 4166	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   389: aload_0
    //   390: sipush 1055
    //   393: lconst_0
    //   394: iconst_0
    //   395: invokevirtual 1067	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   398: aload_0
    //   399: getfield 963	com/tencent/mobileqq/activity/home/Conversation:y	Lcom/tencent/mobileqq/banner/BannerManager;
    //   402: astore_2
    //   403: aload_2
    //   404: ifnull +22 -> 426
    //   407: aload_2
    //   408: invokevirtual 4167	com/tencent/mobileqq/banner/BannerManager:b	()V
    //   411: aload_0
    //   412: getfield 963	com/tencent/mobileqq/activity/home/Conversation:y	Lcom/tencent/mobileqq/banner/BannerManager;
    //   415: aload_0
    //   416: getfield 865	com/tencent/mobileqq/activity/home/Conversation:aF	Lmqq/app/AppRuntime;
    //   419: aload_0
    //   420: getfield 384	com/tencent/mobileqq/activity/home/Conversation:bh	Lcom/tencent/mobileqq/banner/BannerListener;
    //   423: invokevirtual 2197	com/tencent/mobileqq/banner/BannerManager:a	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/banner/BannerListener;)V
    //   426: aload_0
    //   427: getfield 315	com/tencent/mobileqq/activity/home/Conversation:P	Z
    //   430: ifeq +13 -> 443
    //   433: aload_0
    //   434: getfield 1023	com/tencent/mobileqq/activity/home/Conversation:G	Lmqq/os/MqqHandler;
    //   437: bipush 12
    //   439: invokevirtual 689	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   442: pop
    //   443: aload_0
    //   444: getfield 1911	com/tencent/mobileqq/activity/home/Conversation:Y	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   447: getfield 2255	com/tencent/mobileqq/app/FrameHelperActivity:q	Landroid/os/Handler;
    //   450: iconst_4
    //   451: invokevirtual 2878	android/os/Handler:sendEmptyMessage	(I)Z
    //   454: pop
    //   455: aload_0
    //   456: sipush 1035
    //   459: ldc2_w 2654
    //   462: iconst_0
    //   463: invokevirtual 1067	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   466: aload_0
    //   467: getfield 963	com/tencent/mobileqq/activity/home/Conversation:y	Lcom/tencent/mobileqq/banner/BannerManager;
    //   470: astore_2
    //   471: aload_2
    //   472: ifnull +54 -> 526
    //   475: aload_2
    //   476: getstatic 2194	com/tencent/mobileqq/activity/recent/bannerprocessor/PushBannerProcessor:a	I
    //   479: sipush 2000
    //   482: ldc2_w 2654
    //   485: iconst_1
    //   486: invokevirtual 4170	com/tencent/mobileqq/banner/BannerManager:a	(IIJZ)V
    //   489: aload_0
    //   490: getfield 389	com/tencent/mobileqq/activity/home/Conversation:ap	Lcom/tencent/mobileqq/activity/home/Conversation$UICallBack;
    //   493: astore_2
    //   494: aload_2
    //   495: ifnull +7 -> 502
    //   498: aload_2
    //   499: invokevirtual 4171	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	()V
    //   502: aload_0
    //   503: sipush 3001
    //   506: lconst_0
    //   507: iconst_1
    //   508: aconst_null
    //   509: invokevirtual 1062	com/tencent/mobileqq/activity/home/Conversation:a	(IJZLjava/lang/String;)V
    //   512: aload_0
    //   513: sipush 3002
    //   516: ldc2_w 2654
    //   519: iconst_1
    //   520: ldc_w 4173
    //   523: invokevirtual 1062	com/tencent/mobileqq/activity/home/Conversation:a	(IJZLjava/lang/String;)V
    //   526: aload_0
    //   527: sipush 500
    //   530: ldc_w 4175
    //   533: iconst_1
    //   534: invokespecial 1071	com/tencent/mobileqq/activity/home/Conversation:a	(ILjava/lang/String;Z)V
    //   537: aload_0
    //   538: sipush 500
    //   541: ldc_w 4177
    //   544: invokespecial 1075	com/tencent/mobileqq/activity/home/Conversation:a	(ILjava/lang/String;)V
    //   547: aload_0
    //   548: aload_0
    //   549: getfield 865	com/tencent/mobileqq/activity/home/Conversation:aF	Lmqq/app/AppRuntime;
    //   552: getstatic 4180	com/tencent/mobileqq/app/QQManagerFactory:VIP_GIF_MANAGER	I
    //   555: invokevirtual 1281	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   558: checkcast 1602	com/tencent/mobileqq/vipgift/VipGiftManager
    //   561: putfield 327	com/tencent/mobileqq/activity/home/Conversation:X	Lcom/tencent/mobileqq/vipgift/VipGiftManager;
    //   564: aload_0
    //   565: invokevirtual 4182	com/tencent/mobileqq/activity/home/Conversation:J	()V
    //   568: aload_0
    //   569: ldc_w 4184
    //   572: invokespecial 1707	com/tencent/mobileqq/activity/home/Conversation:d	(Ljava/lang/String;)V
    //   575: aload_0
    //   576: sipush 10001
    //   579: ldc2_w 4185
    //   582: iconst_0
    //   583: invokevirtual 1067	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   586: aload_0
    //   587: getfield 865	com/tencent/mobileqq/activity/home/Conversation:aF	Lmqq/app/AppRuntime;
    //   590: invokevirtual 3155	mqq/app/AppRuntime:isLogin	()Z
    //   593: ifne +15 -> 608
    //   596: aload_0
    //   597: getfield 315	com/tencent/mobileqq/activity/home/Conversation:P	Z
    //   600: ifeq +8 -> 608
    //   603: aload_0
    //   604: lconst_0
    //   605: invokevirtual 1425	com/tencent/mobileqq/activity/home/Conversation:a	(J)V
    //   608: aload_0
    //   609: ldc_w 4187
    //   612: ldc2_w 2634
    //   615: iconst_0
    //   616: invokevirtual 1067	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   619: ldc_w 1771
    //   622: invokestatic 926	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   625: checkcast 1771	com/tencent/biz/pubaccount/api/IPublicAccountManager
    //   628: aload_0
    //   629: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   632: invokevirtual 1619	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   635: invokeinterface 4190 2 0
    //   640: getstatic 4194	com/tencent/mobileqq/msgbackup/controller/MsgBackupManager:w	Z
    //   643: ifeq +13 -> 656
    //   646: invokestatic 4197	com/tencent/mobileqq/msgbackup/controller/MsgBackupManager:a	()Lcom/tencent/mobileqq/msgbackup/controller/MsgBackupManager;
    //   649: aload_0
    //   650: invokevirtual 720	com/tencent/mobileqq/activity/home/Conversation:s	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   653: invokevirtual 4199	com/tencent/mobileqq/msgbackup/controller/MsgBackupManager:b	(Lcom/tencent/common/app/business/BaseQQAppInterface;)V
    //   656: iload_1
    //   657: ifeq +7 -> 664
    //   660: aload_0
    //   661: invokespecial 2880	com/tencent/mobileqq/activity/home/Conversation:ai	()V
    //   664: invokestatic 4204	com/tencent/mobileqq/activity/qcircle/utils/QCircleUtils:d	()Lcom/tencent/mobileqq/qcircle/api/IQCircleEeveeManangerService;
    //   667: iconst_4
    //   668: aconst_null
    //   669: aconst_null
    //   670: invokeinterface 4210 4 0
    //   675: aload_0
    //   676: getfield 963	com/tencent/mobileqq/activity/home/Conversation:y	Lcom/tencent/mobileqq/banner/BannerManager;
    //   679: getstatic 1084	com/tencent/mobileqq/activity/recent/bannerprocessor/VerifyPhoneBannerProcessor:a	I
    //   682: sipush 3000
    //   685: invokevirtual 1089	com/tencent/mobileqq/banner/BannerManager:b	(II)V
    //   688: aload_0
    //   689: getfield 1911	com/tencent/mobileqq/activity/home/Conversation:Y	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   692: invokevirtual 4212	com/tencent/mobileqq/app/FrameHelperActivity:K	()V
    //   695: return
    //   696: astore_2
    //   697: goto -549 -> 148
    //   700: astore_2
    //   701: goto -524 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	Conversation
    //   0	704	1	paramBoolean	boolean
    //   13	121	2	localObject1	Object
    //   140	7	2	localObject2	Object
    //   157	6	2	localDialog	Dialog
    //   169	7	2	localObject3	Object
    //   186	313	2	localObject4	Object
    //   696	1	2	localException1	Exception
    //   700	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   133	137	140	finally
    //   162	166	169	finally
    //   133	137	696	java/lang/Exception
    //   162	166	700	java/lang/Exception
  }
  
  public void cx_()
  {
    super.cx_();
    o();
  }
  
  protected String cy_()
  {
    String str = HardCodeUtil.a(2131900763);
    int i1 = this.O;
    if (i1 <= 0) {
      return str;
    }
    if (i1 > 99)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("(99+)");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("(");
    localStringBuilder.append(this.O);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onDestroy");
    }
    this.F = true;
    Object localObject = this.aU;
    if (localObject != null) {
      ((RecentPubAccHelper)localObject).b();
    }
    localObject = this.ai;
    if (localObject != null)
    {
      ((ActionSheet)localObject).setOnButtonClickListener(null);
      this.ai = null;
    }
    localObject = this.bp;
    if (localObject != null) {
      ((UpgradeTipsDialog)localObject).a(null);
    }
    this.ah = false;
    TimeManager.a().c();
    ap();
    this.Y.a(null);
    localObject = this.T;
    if (localObject != null) {
      ((ConversationHotChatCtrl)localObject).a();
    }
    ThreadManager.getUIHandler().removeCallbacks(this.bj);
    localObject = this.u;
    if (localObject != null) {
      ((SearchBarAssistant)localObject).c();
    }
    localObject = this.t;
    if (localObject != null) {
      ((RecentAdapter)localObject).h();
    }
    localObject = this.w;
    if (localObject != null) {
      ((MsgTabStoryNodeListManager)localObject).c();
    }
    localObject = this.y;
    if (localObject != null)
    {
      ((BannerManager)localObject).b(this.aF, this.bh);
      this.y.b(s());
    }
    localObject = this.al;
    if (localObject != null) {
      ((CareNotificationBar)localObject).j();
    }
    localObject = this.aI;
    if (localObject != null)
    {
      ((FPSSwipListView)localObject).setAdapter(null);
      this.aI.setOverScrollListener(null);
    }
    this.aF.unRegistObserver(this.bA);
    this.G.removeCallbacksAndMessages(null);
    try
    {
      localObject = s().getProxyManager().g();
      if (localObject != null) {
        ((RecentUserProxy)localObject).b();
      }
    }
    catch (Throwable localThrowable)
    {
      label259:
      break label259;
    }
    this.A.removeCallbacksAndMessages(null);
    localObject = this.ar;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    TroopAssistantManager.e();
    TroopRemindSettingManager.b();
    TroopBarAssistantManager.c();
    localObject = this.Z;
    if (localObject != null) {
      ((QQSettingMe)localObject).d();
    }
    localObject = this.bv;
    if (localObject != null)
    {
      this.bk.removeView((View)localObject);
      this.bv = null;
    }
    localObject = this.aj;
    if (localObject != null)
    {
      ((LoginwelcomeHelper)localObject).f();
      this.aj = null;
    }
    aH();
    if (this.bu != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.bu);
    }
    localObject = this.U;
    if (localObject != null) {
      ((ConversationTitleBtnCtrl)localObject).g();
    }
    localObject = this.aJ;
    if (localObject != null) {
      ((MiniAppPullInterface)localObject).onDestroy();
    }
    if (this.aH != null) {
      this.aH.c();
    }
    super.d();
  }
  
  protected void d(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLoadingState, showLoadingCircle = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("Q.recent", 4, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      try
      {
        localObject = P().getResources().getDrawable(2130839588);
        this.aK.setCompoundDrawablePadding(AIOUtils.b(5.0F, Q()));
        this.aK.setCompoundDrawables(null, null, (Drawable)localObject, null);
        if (!(localObject instanceof Animatable)) {
          return;
        }
        ((Animatable)localObject).start();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    else
    {
      this.aK.setCompoundDrawables(null, null, null, null);
      this.Y.b("LoadingComplete");
    }
  }
  
  public void e(boolean paramBoolean)
  {
    boolean bool1 = this.y.c(NetStateBannerProcessor.a);
    boolean bool2 = this.y.c(IllegalNetworkBannerProcessor.a);
    if (paramBoolean)
    {
      this.ar.removeMessages(4);
      this.ar.removeMessages(3);
    }
    if ((!bool1) && (!bool2))
    {
      int i1 = LoadingStateManager.b().f();
      if (i1 != 0) {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 != 4) {
                return;
              }
              d(false);
            }
          }
          else
          {
            d(true);
            if (this.ar.hasMessages(3)) {
              break label158;
            }
            this.ar.sendEmptyMessageDelayed(3, 180000L);
          }
        }
        else
        {
          d(true);
          if (this.ar.hasMessages(4)) {
            break label158;
          }
          this.ar.sendEmptyMessageDelayed(4, 180000L);
          return;
        }
      }
      d(false);
      label158:
      return;
    }
    d(false);
  }
  
  public void f(boolean paramBoolean)
  {
    ConversationTitleBtnCtrl localConversationTitleBtnCtrl = this.U;
    if (localConversationTitleBtnCtrl != null) {
      localConversationTitleBtnCtrl.c(paramBoolean);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = this.w;
      if (localObject != null) {
        ((MsgTabStoryNodeListManager)localObject).a(this.Y.ah);
      }
      localObject = this.aJ;
      if (localObject != null) {
        ((MiniAppPullInterface)localObject).initLater(this.Y.ah);
      }
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyCallTabChanged, changed=");
      localStringBuilder.append(paramBoolean);
      QLog.i("Q.recent", 2, localStringBuilder.toString());
    }
  }
  
  public boolean h()
  {
    if (FrameHelperActivity.G())
    {
      FrameHelperActivity.H();
      return true;
    }
    Object localObject = this.ab;
    if ((localObject != null) && (((SpringFestivalTaskCallback)localObject).j())) {
      return true;
    }
    localObject = this.bk;
    if (localObject != null)
    {
      View localView = this.bv;
      if (localView != null)
      {
        ((DragFrameLayout)localObject).removeView(localView);
        this.bv = null;
        localObject = (PortalManager)this.aF.getManager(QQManagerFactory.MGR_PORTAL);
        if (localObject != null) {
          ((PortalManager)localObject).a(P(), false);
        }
        return true;
      }
    }
    localObject = this.aJ;
    if ((localObject != null) && (((MiniAppPullInterface)localObject).isMiniAppLauncherOpened()))
    {
      this.aJ.hideMiniAppEntry(0);
      return true;
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((!this.F) && (P() != null))
    {
      if (P().isFinishing()) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "handleMessage, msg.what=", Integer.valueOf(paramMessage.what) });
      }
      TraceUtils.traceBegin("conv.handleMessage");
      long l1 = System.currentTimeMillis();
      int i1 = paramMessage.what;
      if (i1 != 17)
      {
        if (i1 != 18)
        {
          if (i1 != 1058)
          {
            if (i1 != 40001) {
              switch (i1)
              {
              default: 
                break;
              case 12: 
                aK();
                break;
              case 11: 
                d(paramMessage);
                break;
              case 10: 
                c(paramMessage, l1);
                break;
              case 9: 
                b(paramMessage, l1);
                break;
              case 8: 
                a(paramMessage, l1);
                break;
              case 7: 
                this.A.obtainMessage(1044, 0, 0, null).sendToTarget();
                break;
              }
            } else {
              aJ();
            }
          }
          else
          {
            paramMessage = (StoryHaloManager)this.aF.getManager(QQManagerFactory.STORY_HALO_MANAGER);
            paramMessage.a(2, paramMessage.a(RecentDataListManager.a().c));
          }
        }
        else {
          aI();
        }
      }
      else {
        j(true);
      }
      TraceUtils.traceEnd();
    }
    return true;
  }
  
  public int i()
  {
    return this.aO;
  }
  
  protected void k()
  {
    ap();
    E();
    Object localObject = this.y;
    if (localObject != null)
    {
      ((BannerManager)localObject).a(s());
      this.y.b(this.aF, this.bh);
    }
    localObject = this.bk;
    if (localObject != null)
    {
      View localView = this.bv;
      if (localView != null)
      {
        ((DragFrameLayout)localObject).removeView(localView);
        this.bv = null;
      }
    }
    localObject = this.aa;
    if (localObject != null) {
      ((ConversationHongBaoV2)localObject).i();
    }
    this.A.removeMessages(1134065);
    this.A.removeMessages(1134061);
    this.A.removeMessages(1134062);
    this.A.removeMessages(1134068);
    QZoneReport.b();
    localObject = this.m;
    if (localObject != null) {
      ((RecentOptPopBar)localObject).c = true;
    }
    localObject = this.aU;
    if (localObject != null) {
      ((RecentPubAccHelper)localObject).a(s());
    }
    localObject = this.aj;
    if (localObject != null) {
      ((LoginwelcomeHelper)localObject).d();
    }
    localObject = this.U;
    if (localObject != null) {
      ((ConversationTitleBtnCtrl)localObject).c();
    }
    localObject = this.V;
    if (localObject != null) {
      ((ConversationQbossBannerTitleEntranceCtrl)localObject).a();
    }
    localObject = this.al;
    if (localObject != null) {
      ((CareNotificationBar)localObject).a((BaseActivity)P());
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "conversation onPostThemeChanged");
    }
    if (!ThemeUtil.isDefaultTheme())
    {
      if (this.ba)
      {
        localObject = this.v;
        if (localObject != null)
        {
          ((View)localObject).setBackgroundResource(2130852486);
          this.v.findViewById(2131432634).setBackgroundResource(2130852498);
          this.ba = false;
        }
      }
    }
    else {
      SimpleModeHelper.a(this.v, this.ba);
    }
    SimpleModeHelper.e(this.i);
    I();
    aF();
    Object localObject = this.Z;
    if (localObject != null) {
      ((QQSettingMe)localObject).e();
    }
    m();
    this.Y.b("ThemeChanged");
    localObject = this.aa;
    if (localObject != null) {
      ((ConversationHongBaoV2)localObject).s();
    }
    localObject = this.al;
    if (localObject != null) {
      ((CareNotificationBar)localObject).g();
    }
    localObject = this.w;
    if (localObject != null) {
      ((MsgTabStoryNodeListManager)localObject).j();
    }
    localObject = this.y;
    if (localObject != null) {
      ((BannerManager)localObject).a(-1, null);
    }
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "conversation onPostThemeChanged refresh because simple theme switch!");
      }
      this.G.sendEmptyMessage(10);
      this.Y.E();
    }
    localObject = this.m;
    if (localObject != null) {
      ((RecentOptPopBar)localObject).c = true;
    }
    this.x = SimpleModeHelper.a(this.aI);
    localObject = this.aJ;
    if (localObject != null)
    {
      ((MiniAppPullInterface)localObject).replaceTopRefresh(this.x);
      this.aJ.onPostThemeChanged();
    }
    this.x.a(24, null);
    if (!QQTheme.isSimpleWhite())
    {
      localObject = this.i;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    localObject = this.u;
    if (localObject != null) {
      ((SearchBarAssistant)localObject).d();
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "refreshStatusBarUIByTheme");
    }
    a(this.aH, this.aI);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.h, true);
      a(this.g, true);
      a(this.j, true);
      this.aK.setTextColor(-1);
      this.W.setTextColor(-1);
    }
    else
    {
      SimpleModeHelper.a(this, this.g, this.j, this.h);
      this.aK.setTextColor(Q().getColorStateList(2131167990));
      this.W.setTextColor(Q().getColorStateList(2131167990));
    }
    a(this.aK, this.W);
    SimpleUIUtil.a(this.g, P().getWindow());
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "clearStatusBarBg");
    }
    this.h.setBackgroundDrawable(null);
    this.g.setBackgroundDrawable(null);
    this.j.setBackgroundDrawable(null);
  }
  
  public void o()
  {
    Object localObject;
    if (SystemClock.uptimeMillis() - MsgTabStoryNodeListManager.C > 500L)
    {
      aa();
      if (this.aG)
      {
        localObject = this.aI;
        if (((localObject instanceof HongBaoListView)) && (((HongBaoListView)localObject).mEnableStory) && (((HongBaoListView)this.aI).mForStory))
        {
          localObject = this.w;
          if (localObject != null) {
            ((MsgTabStoryNodeListManager)localObject).i();
          }
          localObject = this.aJ;
          if (localObject != null) {
            ((MiniAppPullInterface)localObject).hideMiniAppEntry(-1);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFrameTabClick|mIsChatList:");
      ((StringBuilder)localObject).append(this.q);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.k)
    {
      Object localObject = this.m;
      RelativeLayout localRelativeLayout = this.j;
      ((RecentOptPopBar)localObject).a(localRelativeLayout, localRelativeLayout.getWidth() - Q().getDimensionPixelSize(2131299619) - Q().getDimensionPixelSize(2131299620), Q().getDimensionPixelSize(2131299621));
      localObject = this.Y;
      if ((localObject != null) && ((localObject instanceof MainFragment))) {
        ((MainFragment)localObject).p();
      }
      ReportController.b(this.aF, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
      StoryReportor.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
      this.l.g();
      SafeModeUtil.e();
      this.bb = true;
    }
    else if ((paramView == this.n) || (paramView == this.o))
    {
      long l1 = System.currentTimeMillis();
      if (Math.abs(l1 - bf) < 500L) {
        bf = l1;
      } else {
        bf = l1;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    StoryHaloManager localStoryHaloManager = (StoryHaloManager)this.aF.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "RecentAdpater onClick not RecentBaseData");
    }
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v == null");
      }
      return;
    }
    if (paramView.getId() == 2131429786)
    {
      ReportController.b(this.aF, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
      paramView = new Intent(P(), ForwardRecentActivity.class);
      paramView.putExtra("forward_type", 13);
      a(paramView);
      return;
    }
    if ((paramView.getId() != 2131433684) && (paramView.getId() != 2131433686) && (paramView.getId() != 2131433687) && (paramView.getId() != 2131433688) && (paramView.getId() != 2131433689) && (paramView.getId() != 2131433690) && (paramView.getId() != 2131433691))
    {
      if ((paramView.getId() == 2131436598) && (localStoryHaloManager.b(paramObject))) {
        localStoryHaloManager.a(paramView, (RecentItemChatMsgData)paramObject);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onItemClick uin: ");
        paramView.append(paramObject);
        QLog.i("Q.recent", 2, paramView.toString());
      }
      paramView = (String)paramObject;
      paramObject = ContactUtils.g(s(), paramView);
      ChatActivityUtils.a(s(), P(), 0, paramView, paramObject, null, true, null, true, true, null, null);
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView) {}
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = Q();
    int i1 = paramRecentBaseData.getRecentUserType();
    if (((i1 == 1) || (i1 == 5000)) && (this.p == null)) {
      this.p = new RecentTroopMenuOption(s(), (BaseActivity)P());
    }
    if (Utils.a(paramString1, localResources.getString(2131888206)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
    }
    else if (Utils.a(paramString1, localResources.getString(2131888211)))
    {
      a(i1, paramRecentBaseData, paramString2, true);
    }
    else if (Utils.a(paramString1, localResources.getString(2131890181)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
      if (i1 == 3000) {
        new ReportTask(s()).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").a();
      }
    }
    else if (Utils.a(paramString1, localResources.getString(2131890183)))
    {
      a(i1, paramRecentBaseData, paramString2, true);
      if (i1 == 3000) {
        new ReportTask(s()).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").a();
      }
    }
    else if (Utils.a(paramString1, localResources.getString(2131891973)))
    {
      this.aU.a(P(), paramRecentBaseData, s());
      ReportController.b(this.aF, "dc00898", "", paramRecentBaseData.getRecentUserUin(), "0X800991D", "0X800991D", 0, 0, "", "", "", "");
    }
    else if (Utils.a(paramString1, localResources.getString(2131888210)))
    {
      this.aU.a(P(), paramRecentBaseData, s());
      ReportController.b(this.aF, "dc00898", "", paramRecentBaseData.getRecentUserUin(), "0X800BDD6", "0X800BDD6", 0, 0, "", "", "", "");
    }
    if (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[4])))
    {
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        RecentUtil.a(s(), paramString1.e(), true, true);
        this.A.sendEmptyMessage(1009);
      }
      ReportController.b(this.aF, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
      return;
    }
    if (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[5])))
    {
      if ((paramRecentBaseData instanceof RecentItemTempMsgBoxData)) {
        ((ITempMsgBoxManager)this.aF.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(false);
      }
      if ((paramRecentBaseData instanceof RecentItemGameMsgBoxData)) {
        ((IGameMsgBoxRuntimeService)this.aF.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).setBoxRead(true);
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = ((RecentUserBaseData)paramRecentBaseData).e();
        s().getConversationFacade().b(paramString1.uin, paramString1.getType(), 1);
        this.A.sendEmptyMessage(1009);
      }
      ReportController.b(this.aF, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
    }
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.aI)
    {
      paramView = this.x;
      if (paramView != null)
      {
        if (this.D)
        {
          paramView.f();
          return;
        }
        paramView.c(0L);
      }
    }
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (this.q)
    {
      if (a(paramView, paramRecentBaseData)) {
        return;
      }
      this.bb = true;
      StartupTracker.a(null, "AIO_Click_cost");
      PAStartupTracker.a(null, "pubAcc_aio_open", "");
      ThreadPriorityManager.a(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "AIOTime onRecentBaseDataClick start");
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramView = ((RecentUserBaseData)paramRecentBaseData).e();
        b(paramRecentBaseData, paramView, paramRecentBaseData.mUnreadNum);
      }
      else
      {
        paramView = null;
      }
      int i1 = RecentUtil.a(P(), s(), paramView, paramString, paramBoolean, 0, paramRecentBaseData);
      a(paramRecentBaseData, paramView, i1);
      a(i1, paramView);
      if (paramRecentBaseData != null)
      {
        RecentReportHelper.b(s(), paramRecentBaseData, paramView);
        paramRecentBaseData.clearUnReadNum();
        NotifyIdManager.a(s()).c(paramRecentBaseData.getRecentUserUin());
        this.M = true;
      }
      StartupTracker.a("AIO_Click_cost", null);
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    Object localObject;
    if (this.q)
    {
      paramString = null;
      int i1 = -1;
      if ((paramRecentBaseData instanceof RecentItemTempMsgBoxData)) {
        com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConstants.a = false;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        localObject = (RecentUserBaseData)paramRecentBaseData;
        paramString = ((RecentUserBaseData)localObject).e();
        i1 = ((RecentUserBaseData)localObject).mPosition;
      }
      if (paramString != null)
      {
        RecentReportHelper.a(s(), paramRecentBaseData, paramString);
        RecentUtil.a(s(), paramString, i1);
        this.T.a(paramString);
      }
    }
    else
    {
      localObject = (QCallFacade)this.aF.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if ((localObject == null) || (paramRecentBaseData == null)) {}
    }
    try
    {
      ((QCallFacade)localObject).d(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
    }
    catch (Exception localException)
    {
      label120:
      break label120;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.recent", 2, "delRecentCallByUin Error");
    }
    ReportController.b(this.aF, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
    if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
      if (paramRecentBaseData.getRecentUserType() == 3000) {
        ReportController.b(this.aF, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.aF, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
    a(0L);
  }
  
  public void onRightIconMenuHide(View paramView) {}
  
  public void onRightIconMenuShow(View paramView)
  {
    Object localObject = this.t;
    if (localObject == null) {
      return;
    }
    localObject = ((RecentAdapter)localObject).a(paramView);
    if ((localObject != null) && ("9970".equals(((RecentBaseData)localObject).getRecentUserUin()))) {
      ReportController.b(this.aF, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
    }
    if ((localObject != null) && (AppConstants.SERVICE_ACCOUNT_FOLDER_UIN.equals(((RecentBaseData)localObject).getRecentUserUin())))
    {
      int i1 = ((RecentBaseData)localObject).mUnreadFlag;
      int i2 = 0;
      if (i1 == 2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (((RecentBaseData)localObject).mUnreadFlag == 1) {
        i2 = ((RecentBaseData)localObject).mUnreadNum;
      }
      int i3 = -1;
      if ((paramView.getTag(-1) instanceof Integer)) {
        i3 = ((Integer)paramView.getTag(-1)).intValue() + 1;
      }
      ThreadManager.executeOnSubThread(new Conversation.6(this, i1, i2, i3));
    }
    if ((localObject != null) && (1008 == ((RecentBaseData)localObject).getRecentUserType()) && (RecentPubAccHelper.a()))
    {
      if (paramView.findViewById(2131438132) != null) {
        ReportController.b(this.aF, "dc00898", "", ((RecentBaseData)localObject).getRecentUserUin(), "0X800BDD3", "0X800BDD3", 0, 0, "", "", "", "");
      }
      if (paramView.findViewById(2131438107) != null) {
        ReportController.b(this.aF, "dc00898", "", ((RecentBaseData)localObject).getRecentUserUin(), "0X800BDDC", "0X800BDDC", 0, 0, "", "", "", "");
      }
      if (paramView.findViewById(2131438131) != null) {
        ReportController.b(this.aF, "dc00898", "", ((RecentBaseData)localObject).getRecentUserUin(), "0X800BDD5", "0X800BDD5", 0, 0, "", "", "", "");
      }
      if (paramView.findViewById(2131438130) != null) {
        ReportController.b(this.aF, "dc00898", "", ((RecentBaseData)localObject).getRecentUserUin(), "0X800BDD9", "0X800BDD9", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.aW != paramInt1)
    {
      long l1 = SystemClock.elapsedRealtime();
      double d1 = l1 - this.aX;
      Double.isNaN(d1);
      d1 = 1.0D / d1 * 1000.0D;
      boolean bool;
      if (paramInt1 > this.aW) {
        bool = true;
      } else {
        bool = false;
      }
      this.aV = bool;
      this.aW = paramInt1;
      this.aX = l1;
      if (QLog.isDebugVersion())
      {
        String str = RecentDataListManager.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onScroll:");
        localStringBuilder.append(d1);
        localStringBuilder.append(" for Direction:");
        localStringBuilder.append(this.aV);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (d1 <= 25.0D) {
        aN();
      } else {
        DynamicFaceDrawable.a(s());
      }
    }
    if (paramAbsListView != null) {
      a(paramAbsListView.getChildAt(0), paramInt1);
    }
    if (paramInt1 + paramInt2 == paramInt3)
    {
      paramInt3 = ((ListView)paramAbsListView).getHeaderViewsCount();
      if (paramInt1 <= paramInt3)
      {
        paramInt3 = paramAbsListView.getChildAt(paramInt3 - paramInt1).getTop();
        paramInt2 = paramAbsListView.getChildAt(paramInt2 - 2).getBottom();
        paramInt2 = Math.max(0, paramAbsListView.getHeight() - paramInt2 + paramInt3);
      }
      else
      {
        paramInt2 = 0;
      }
      paramAbsListView = (AbsListView.LayoutParams)this.af.getLayoutParams();
      if ((paramAbsListView != null) && (paramAbsListView.height != paramInt2))
      {
        paramAbsListView.height = paramInt2;
        this.af.setLayoutParams(paramAbsListView);
      }
    }
    if (paramInt1 == 0)
    {
      this.bX = false;
      this.bW = -1L;
    }
    if ((this.bX) && (SystemClock.elapsedRealtime() - this.bW > 800L))
    {
      this.aI.setSelection(0);
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("onScroll cost time is below 1000 ms, isScroll2TopFlag: ");
        paramAbsListView.append(this.bX);
        paramAbsListView.append(", startScrollTime: ");
        paramAbsListView.append(this.bW);
        QLog.d("Conversation", 2, paramAbsListView.toString());
      }
      this.bX = false;
      this.bW = -1L;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrollStateChanged:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Conversation", 2, ((StringBuilder)localObject).toString());
    }
    if (AppSetting.p)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      ThreadPriorityManager.a(bool);
    }
    if ((paramAbsListView instanceof ARMapHongBaoListView)) {
      ((ARMapHongBaoListView)paramAbsListView).setScrollState(paramInt);
    }
    if (paramInt != 0)
    {
      this.bU = true;
      ApngImage.pauseByTag(2);
    }
    else
    {
      this.bU = false;
    }
    this.r = paramInt;
    if (paramAbsListView == this.aI)
    {
      localObject = this.w;
      if (localObject != null) {
        ((MsgTabStoryNodeListManager)localObject).b(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1))
      {
        localObject = this.t;
        if (localObject != null)
        {
          ((RecentAdapter)localObject).a(true);
          ThreadPriorityManager.a(true);
        }
      }
      else if (this.t != null)
      {
        int i1 = this.aI.getFirstVisiblePosition() - this.aI.getHeaderViewsCount();
        int i2 = this.aI.getLastVisiblePosition();
        int i3 = this.aI.getHeaderViewsCount();
        int i4 = this.t.getCount();
        this.B = Math.max(i1, -1);
        while ((i1 >= 0) && (i1 < i4) && (i1 <= i2 - i3))
        {
          localObject = this.t.getItem(i1);
          if ((localObject instanceof RecentBaseData))
          {
            localObject = (RecentBaseData)localObject;
            if ((((RecentBaseData)localObject).isUnreadMsgNumInTabNum()) && (((RecentBaseData)localObject).getUnreadNum() > 0))
            {
              this.B = i1;
              break;
            }
          }
          i1 += 1;
        }
        this.t.a(false);
        ThreadPriorityManager.a(false);
      }
      if (paramInt == 0)
      {
        aN();
        DropFrameMonitor.b().a("list_conv", false);
        ThreadRegulator.a().b(2);
        a(paramAbsListView);
        ImaxAdRecentUserManager.a().a(s(), this.t, this.aI);
        m(false);
        aG();
        L();
        F();
      }
      else
      {
        DropFrameMonitor.b().a("list_conv");
        ThreadRegulator.a().a(2);
      }
    }
    if ((!this.bU) && (this.bV))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Conversation", 2, "onScrollStateChanged call with msg incoming");
      }
      this.G.sendEmptyMessage(10);
      this.bV = false;
    }
    if (paramInt == 0)
    {
      if (this.M) {
        a(100L);
      }
      ApngImage.playByTag(2);
    }
    Object localObject = this.y;
    if (localObject != null) {
      ((BannerManager)localObject).b(this.bU);
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).onScrollStateChanged(paramAbsListView, paramInt);
    PublicAccountEventReport.a(s(), paramAbsListView, paramInt);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.aI) && (!this.D))
    {
      paramView = this.x;
      if (paramView != null) {
        paramView.b(0L);
      }
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onViewCompleteVisableAndReleased %s", new Object[] { Boolean.valueOf(this.D) }));
    }
    return a(paramListView);
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  protected void p()
  {
    if (this.t == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "refreshRecentHeadView|mChatAdapter is null.");
      }
      return;
    }
    Message localMessage = this.G.obtainMessage(7);
    this.G.sendMessage(localMessage);
  }
  
  public void q()
  {
    a(1068, 0L, true);
  }
  
  public void r()
  {
    a(1069, 0L, true);
  }
  
  public QQAppInterface s()
  {
    return (QQAppInterface)this.aF;
  }
  
  public void t()
  {
    if (s().getCurrentAccountUin() != null)
    {
      MqqHandler localMqqHandler = this.G;
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1058);
      }
      this.D = true;
      ad();
      e(true);
      boolean bool1 = this.y.c(NetStateBannerProcessor.a);
      boolean bool2 = this.y.c(IllegalNetworkBannerProcessor.a);
      if ((!bool1) && (!bool2))
      {
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).canFreeTimeRefreshPush()) {
          ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportManualRefresMsg();
        }
        s().mAutomator.d();
        b(60000L);
        ReportController.b(this.aF, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
        return;
      }
      b(800L);
    }
  }
  
  public void u()
  {
    if ((!this.P) && (!this.F))
    {
      U();
      StartupTracker.a("Recent_Start", null);
      return;
    }
    if (this.P) {
      a(1030, 0L, true);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    d(paramObject);
    c(paramObject);
    b(paramObject);
    a(paramObject);
    a(paramObservable, paramObject);
  }
  
  public void v()
  {
    this.C = true;
    if (SetSplash.e())
    {
      a(new Conversation.15(this));
      return;
    }
    u();
  }
  
  public void w()
  {
    Object localObject = this.U;
    if (localObject != null) {
      ((ConversationTitleBtnCtrl)localObject).b(false);
    }
    localObject = this.V;
    if (localObject != null) {
      ((ConversationQbossBannerTitleEntranceCtrl)localObject).b(false);
    }
  }
  
  public void x()
  {
    for (;;)
    {
      try
      {
        if ((!this.R) && (!this.F))
        {
          this.R = true;
          Object localObject1 = (BaseActivity)P();
          LayoutInflater.from((Context)localObject1);
          Object localObject3;
          try
          {
            if (this.x == null) {
              this.x = SimpleModeHelper.a(this.aI);
            }
            if (this.m == null) {
              this.m = new RecentOptPopBar((BaseActivity)localObject1);
            }
            if (this.Z != null) {
              continue;
            }
            QQSettingMe.a("d_common", 2131627810);
            QQSettingMe.a("d_lovespace", 2131627812);
            QQSettingMe.a("d_profile_bubble", 2131627813);
            localObject1 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(2131627808, null);
            this.Z = new QQSettingMe((BaseActivity)P(), s(), (ViewGroup)localObject1);
            this.Y.a(new Conversation.20(this));
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            if (Thread.currentThread() == Looper.getMainLooper().getThread())
            {
              localObject1 = "in main thread ";
            }
            else
            {
              this.x = null;
              this.Z = null;
              this.m = null;
              this.R = false;
              localObject1 = "not in main thread ";
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append(localException2.toString());
              QLog.i("Q.recent", 2, ((StringBuilder)localObject3).toString());
            }
          }
          try
          {
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("device_mode", DeviceInfoUtil.f());
            ((HashMap)localObject1).put("manufacturer", Build.MANUFACTURER);
            StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
            localObject3 = s().getCurrentAccountUin();
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
              break label401;
            }
            l1 = 0L;
            localStatisticCollector.collectPerformance((String)localObject3, "actConSubInflate", false, l1, 0L, (HashMap)localObject1, "");
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.recent", 2, localException1.toString());
            }
          }
          this.Y.q.sendEmptyMessage(2);
          this.X = ((VipGiftManager)this.aF.getManager(QQManagerFactory.VIP_GIF_MANAGER));
        }
        else
        {
          return;
        }
      }
      finally {}
      label401:
      long l1 = 1L;
    }
  }
  
  public MiniAppPullInterface y()
  {
    return this.aJ;
  }
  
  public boolean z()
  {
    return this.C;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation
 * JD-Core Version:    0.7.0.1
 */