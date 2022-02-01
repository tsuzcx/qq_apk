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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ScrollReport;
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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.SafeModeUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ConversationHotChatCtrl;
import com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QZoneFeedsObserver;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil;
import com.tencent.mobileqq.activity.contacts.base.SearchBarAssistant;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch.QZoneRedPointDrawerCallback;
import com.tencent.mobileqq.activity.qcircle.handler.QCircleObserver;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.ConversationHelper;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
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
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager;
import com.tencent.mobileqq.activity.recent.msgbox.RecentItemTempMsgBoxData;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxObserver;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.DiscussionObserver;
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
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackObserver;
import com.tencent.mobileqq.app.ShortVideoObserver;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopBusinessObserver;
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
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.fileassistant.top.FileAssistTopHandler;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.imaxad.ImaxAdPresenter;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;
import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.portal.ConversationHongBaoV2;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qbosssplash.common.QbossSplashUtil;
import com.tencent.mobileqq.qbosssplash.model.SplashItem;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.studymode.ModeSwitchManager;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
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
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.CrashVersionUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.vip.ad.TianshuAdManager;
import cooperation.vip.ad.TianshuRenewalsBarManager;
import cooperation.vip.ad.TianshuSplashManager;
import cooperation.vip.ad.TianshuSplashUtils;
import cooperation.vip.tianshu.TianShuManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class Conversation
  extends Frame
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, OnRecentUserOpsListener, RecentAdapter.ShowUpStateListener, AppConstants, FrameHelperActivity.DrawerListener, UpgradeTipsDialog.OnPreparedListener, AbsListView.OnScrollListener, OverScrollViewListener, SwipListView.RightIconMenuListener, Observer
{
  public static long b;
  private static long jdField_i_of_type_Long;
  public static boolean q = true;
  private boolean A;
  private boolean B;
  private boolean C = false;
  private boolean D = false;
  private boolean E = false;
  private boolean F;
  private boolean G = false;
  private boolean H = false;
  private boolean I = false;
  private boolean J = false;
  int jdField_a_of_type_Int = 0;
  protected long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new Conversation.51(this);
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(BaseApplicationImpl.getContext(), new Conversation.64(this));
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private final AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver = new Conversation.47(this);
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new Conversation.48(this);
  MsgTabStoryNodeListManager jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
  ConversationHotChatCtrl jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl = null;
  ConversationQbossBannerTitleEntranceCtrl jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl;
  ConversationTitleBtnCtrl jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl = null;
  protected QQSettingMe a;
  QZoneFeedsObserver jdField_a_of_type_ComTencentMobileqqActivityQZoneFeedsObserver = new Conversation.50(this);
  SearchBarAssistant jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant;
  private Conversation.DateFormatChangeRunnable jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DateFormatChangeRunnable = new Conversation.DateFormatChangeRunnable(this, null);
  private Conversation.DragChangedListener jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DragChangedListener;
  Conversation.LoadingStateCallback jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$LoadingStateCallback = new Conversation.LoadingStateCallback(this);
  private Conversation.TPHInCon jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon;
  protected Conversation.UICallBack a;
  private QCircleObserver jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver = new Conversation.QCircleObserverImpl(this);
  private ConversationHelper jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper;
  RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  public RecentOptPopBar a;
  private RecentPubAccHelper jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper;
  RecentTroopMenuOption jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private TempMsgBoxObserver jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver = new Conversation.32(this);
  public CareNotificationBar a;
  public SpringFestivalTaskCallback a;
  protected BizTroopObserver a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new Conversation.39(this);
  private final ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new Conversation.36(this);
  private final DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new Conversation.45(this);
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new Conversation.43(this);
  public FrameHelperActivity a;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new Conversation.31(this);
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new Conversation.55(this);
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new Conversation.38(this);
  private RegisterProxySvcPackObserver jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver = new Conversation.49(this);
  private ShortVideoObserver jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver = new Conversation.56(this);
  StrangerObserver jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new Conversation.41(this);
  private final SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new Conversation.46(this);
  private final TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new Conversation.34(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new Conversation.37(this);
  private AppletsObserver jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver = new Conversation.AppletsObserverImpl(this);
  private final AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new Conversation.30(this);
  public BannerManager a;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new Conversation.67(this);
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("tool_adMessage", "com.tencent.mobileqq:tool");
  public LoginwelcomeHelper a;
  private MiniAppPullInterface jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
  private OnlineStatusObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver = new Conversation.61(this);
  public ConversationHongBaoV2 a;
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new Conversation.40(this);
  private StudyModeChangeListener jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener = new Conversation.68(this);
  private RedpointObserver jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver = new Conversation.RedpointObserverImpl(this);
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private final TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new Conversation.33(this);
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog;
  VipGiftManager jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = null;
  public PullRefreshHeader a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private TianshuAdManager jdField_a_of_type_CooperationVipAdTianshuAdManager;
  private TianshuRenewalsBarManager jdField_a_of_type_CooperationVipAdTianshuRenewalsBarManager;
  private TianshuSplashManager jdField_a_of_type_CooperationVipAdTianshuSplashManager;
  Runnable jdField_a_of_type_JavaLangRunnable = new Conversation.29(this);
  public String a;
  protected StringBuilder a;
  ArrayList<ConversationPullDownActiveBase> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected List<RecentBaseData> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new Conversation.60(this);
  protected MqqHandler a;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  Dialog jdField_b_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new Conversation.52(this);
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  public TextView b;
  private PreloadProcHitSession jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("tool_shop", "com.tencent.mobileqq:tool");
  RedTouch jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch;
  protected Runnable b;
  final List<String> jdField_b_of_type_JavaUtilList = new ArrayList(40);
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  public boolean b;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long = 0L;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new Conversation.53(this);
  View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private PreloadProcHitSession jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private Runnable jdField_c_of_type_JavaLangRunnable;
  MqqHandler jdField_c_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$LoadingStateCallback);
  public boolean c;
  public int d;
  long jdField_d_of_type_Long;
  private final BroadcastReceiver jdField_d_of_type_AndroidContentBroadcastReceiver = new Conversation.54(this);
  private View jdField_d_of_type_AndroidViewView;
  private Runnable jdField_d_of_type_JavaLangRunnable = new Conversation.3(this);
  public boolean d;
  int jdField_e_of_type_Int = 3;
  long jdField_e_of_type_Long = 0L;
  private View jdField_e_of_type_AndroidViewView;
  private Runnable jdField_e_of_type_JavaLangRunnable = new Conversation.23(this);
  protected boolean e;
  public volatile int f;
  long jdField_f_of_type_Long = 0L;
  boolean jdField_f_of_type_Boolean = false;
  public volatile int g;
  private long g;
  public boolean g;
  private int jdField_h_of_type_Int = -1;
  private long jdField_h_of_type_Long = 0L;
  boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int;
  boolean jdField_i_of_type_Boolean = false;
  private long jdField_j_of_type_Long = -1L;
  boolean jdField_j_of_type_Boolean = false;
  boolean k = false;
  boolean l = false;
  boolean m = false;
  boolean n = false;
  boolean o = false;
  boolean p = false;
  public volatile boolean r;
  public boolean s = false;
  boolean t = false;
  boolean u = false;
  public boolean v = false;
  private boolean x = false;
  private boolean y = false;
  private boolean z = true;
  
  static
  {
    jdField_b_of_type_Long = -1L;
  }
  
  public Conversation()
  {
    this.jdField_a_of_type_Long = 2000L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback = new SpringFestivalTaskCallback(this);
    this.jdField_f_of_type_Int = 17;
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack = new Conversation.UICallBack(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new Conversation.35(this);
    this.jdField_b_of_type_JavaLangRunnable = new Conversation.66(this);
  }
  
  private void F()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1025);
    this.jdField_j_of_type_Boolean = true;
    if (!this.k) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    BaseApplicationImpl.sApplication.onActivityFocusChanged(a(), true);
  }
  
  private void G()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof ARMapHongBaoListView)))
    {
      if (this.jdField_a_of_type_CooperationVipAdTianshuAdManager == null) {
        this.jdField_a_of_type_CooperationVipAdTianshuAdManager = new TianshuAdManager(a(), this, (ARMapHongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      }
      this.jdField_a_of_type_CooperationVipAdTianshuAdManager.a();
    }
  }
  
  private void H()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 50L);
  }
  
  private void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "scrollToTopIfNeccessary: " + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() >= 0)
    {
      this.I = true;
      this.jdField_j_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.smoothScrollToPosition(0);
    }
  }
  
  private void J()
  {
    ThreadManager.excute(new Conversation.5(this), 16, null, true);
  }
  
  private void K()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
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
          if (((RecentBaseData)localObject).isUnreadMsgNumInTabNum())
          {
            i2 = ((RecentBaseData)localObject).getUnreadNum();
            label124:
            if (i2 <= 0) {
              break label276;
            }
            if (this.jdField_b_of_type_Int != i1) {
              this.jdField_b_of_type_Int = i1;
            }
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        if (q) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.smoothScrollToPosition(this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount());
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "scrollToNextUnreadItem|findUnreadItem:" + bool + ",mCurrentUnreadItem" + this.jdField_b_of_type_Int);
        return;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount(), 0);
        continue;
        if (q) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setIsNeedScrollPositionTop(q);
        }
        I();
        this.jdField_b_of_type_Int = -1;
      }
      break;
      i2 = 0;
      break label124;
      label276:
      break label96;
    }
  }
  
  private void L()
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
  
  private void M()
  {
    if (LoadingStateManager.a().b()) {
      LoadingStateManager.a().a(3);
    }
  }
  
  private void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMWrapper", 2, "Conversation showUpgradeDetailInfoIfNeccessary mInitTimUpgradeInfo : " + this.F);
    }
    if ((!this.w) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.a()))
    {
      if (this.w)
      {
        if ((!ConfigHandler.a(a())) && (!this.F))
        {
          a(1134047, 0L, true);
          this.F = true;
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
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.show();
      ConfigHandler.a(a());
      int i1 = ConfigHandler.a(a());
      ConfigHandler.b(a(), i1 + 1);
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    }
  }
  
  private void O()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
  }
  
  private void P()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131365297));
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DragChangedListener = new Conversation.DragChangedListener(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DragChangedListener, false);
    this.jdField_e_of_type_Boolean = true;
    a().isInCallList = false;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131377356));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379533));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365362));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378458));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380163));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380170));
    Q();
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    c();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370506);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376667));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDescendantInvalidatedFlags(true);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(a().getDrawable(2130839540));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setIsNeedScrollPositionTop(true);
      Object localObject2 = a();
      if ((localObject2 != null) && ((localObject2 instanceof SplashActivity)))
      {
        Object localObject3 = (SplashActivity)localObject2;
        Object localObject1 = ((SplashActivity)localObject3).mPreloadLocalSearchBar;
        ((SplashActivity)localObject3).mPreloadLocalSearchBar = null;
        if ((localObject1 == null) && (localObject2 != null))
        {
          localObject1 = ((AppActivity)localObject2).getLayoutInflater().inflate(2131562952, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
          if (localObject1 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject1, 0);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant = new SearchBarAssistant((BaseActivity)a(), 1, (View)localObject1);
            this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
          }
          BannerManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
          this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager = BannerManager.a();
          this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(24, 2005);
          localObject1 = a();
          localObject2 = a();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
          if (!RecentDataListManager.a().jdField_a_of_type_Boolean)
          {
            bool = true;
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter((Context)localObject1, (QQAppInterface)localObject2, (XListView)localObject3, this, 0, bool);
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(true);
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this);
            this.jdField_c_of_type_AndroidViewView = new View(a());
            localObject1 = new AbsListView.LayoutParams(-1, 0);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView, null, false);
            if ((TextUtils.isEmpty(RecentDataListManager.a().jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(a().getCurrentUin())) || (a().getCurrentUin().equals(RecentDataListManager.a().jdField_b_of_type_JavaLangString))) {
              break label786;
            }
            localObject1 = new ArrayList(16);
            QLog.d("Q.recent", 1, "ignore PreLoadList");
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a((List)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.u();
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
            this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 = new ConversationHongBaoV2(this, this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper = new LoginwelcomeHelper(this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131365371));
            IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
            c("initUI");
            localObject1 = QbossSplashUtil.a;
            if ((localObject1 != null) && (TianshuSplashUtils.a(((SplashItem)localObject1).l)) && (!TextUtils.isEmpty(TianshuSplashUtils.a(a().getCurrentUin())))) {
              this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(23, 3000);
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.recent", 2, "initUI setOverscrollHeader error" + localThrowable.getMessage());
          continue;
          bool = false;
          continue;
          label786:
          List localList = RecentDataListManager.a().jdField_b_of_type_JavaUtilList;
          continue;
          continue;
          localList = null;
        }
      }
    }
  }
  
  private void Q()
  {
    int i1 = AIOUtils.a(10.0F, a());
    AIOUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, i1, i1, i1, i1);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new Conversation.16(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(new Conversation.17(this));
  }
  
  private void R()
  {
    ((FriendListHandler)a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(a().getCurrentUin(), false);
  }
  
  private void S()
  {
    Manager localManager = this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if ((localManager instanceof RedTouchManager))
    {
      int i1 = ((RedTouchManager)localManager).a("104000.104001", 100);
      if (i1 > 0) {
        a(8, AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230);
      }
      QLog.d("Q.recent", 2, "uin:" + a().getCurrentUin() + "getSubscribeAccountRedDotNum  redNumByPath:" + i1);
    }
  }
  
  private void T()
  {
    for (;;)
    {
      try
      {
        if (!this.k)
        {
          boolean bool = this.jdField_h_of_type_Boolean;
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.k = true;
        if (!this.l) {
          t();
        }
        y();
        if ((!this.m) && (!a().mAutomator.b())) {
          c(2);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.a();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new Conversation.21(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar = new CareNotificationBar(this, this.jdField_a_of_type_AndroidViewViewGroup);
        V();
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.b();
          SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          if (localSpringFestivalEntryManager != null) {
            localSpringFestivalEntryManager.c();
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
        U();
        if (!a().mAutomator.b())
        {
          a(this.jdField_a_of_type_MqqOsMqqHandler, a());
          a(1055, 0L, false);
          if (QLog.isColorLevel())
          {
            QLog.d("Q.recent", 2, new Object[] { "initUiLater() will send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(a().mAutomator.b()) });
            QLog.d("Q.recent", 2, "isInRealActionLoginB MSG_CHECK_QQSPORT_RED_PACKET");
          }
          a(1061, 0L, false);
          a(1059, 0L, false);
          N();
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(12);
          aw();
          continue;
        }
        if (!this.s) {
          break label348;
        }
      }
      finally {}
      a(1055, 0L, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "initUiLater() mMsgTabStoryNodeListNeedInit fallback logic, send MSG_INIT_MSGTAG_STORY");
      }
      this.s = false;
      continue;
      label348:
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "initUiLater() will not send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(a().mAutomator.b()) });
      }
    }
  }
  
  private void U()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null) && (this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(7, 2000);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2000;
      localMessage.getData().putBoolean("rightNow", false);
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(18, localMessage);
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(24, 2000, 5000L);
      a(3002, 5000L, true, "qboss_banner_login");
    }
    a(5000, "tianshu_req_splash_type_login", true);
    a(5000, "tianshu_req_renewals_type_login");
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(20, 3000);
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(5, 3000, 1000L);
    }
  }
  
  private void V()
  {
    long l1 = System.currentTimeMillis();
    if (MiniAppConfProcessor.a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559765, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface == null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface = ((IMiniAppService)QRoute.api(IMiniAppService.class)).createMiniAppEntryManager(MiniAppConfProcessor.c(), a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, this.jdField_a_of_type_AndroidViewViewGroup);
      }
      long l2 = System.currentTimeMillis();
      QLog.d("AutoMonitor", 1, "init Mini App, cost=" + (l2 - l1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initUI(a());
    }
  }
  
  private void W()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    av();
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(24, 2000);
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(20, 3000);
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(21, 3000);
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(35, 3000, 3000L, true);
    N();
    if (!this.jdField_e_of_type_Boolean) {
      ((FriendListHandler)a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(a().getCurrentAccountUin(), (byte)2);
    }
    X();
    ((ModeSwitchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).a((BaseActivity)a());
  }
  
  private void X()
  {
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = ((SplashActivity)localObject).getIntent().getExtras();
      if ((localObject != null) && (((Bundle)localObject).getBoolean("key_notification_click_action", false))) {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "removeObservers" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      Object localObject1;
      if (this.jdField_a_of_type_MqqAppAppRuntime != null)
      {
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver);
        a().unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
        StudyModeManager.b(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
        if (a().getAVNotifyCenter() != null) {
          a().getAVNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
        }
        if (a().getMessageFacade() != null) {
          a().getMessageFacade().deleteObserver(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
          a().getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        }
        a().setHandler(getClass(), null);
        a().removeHandler(getClass());
        this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQZoneFeedsObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver);
        localObject1 = (QCallFacade)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (localObject1 != null) {
          ((QCallFacade)localObject1).deleteObserver(this);
        }
        localObject1 = (RedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH);
        if (localObject1 != null) {
          ((RedTouchManager)localObject1).deleteObserver(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper != null) {
          this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.c();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null)
        {
          this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback);
          localObject1 = (SpringFestivalEntryManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          if (localObject1 != null) {
            ((SpringFestivalEntryManager)localObject1).a(null);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.f();
        }
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(17);
      try
      {
        localObject1 = (BaseActivity)a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon != null)
        {
          BaseTransProcessor.removeHandler(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon);
          this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon.a();
          this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon = null;
        }
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject1).unregisterReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver);
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
  
  private void Z()
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private NewerGuideBannerManager a()
  {
    return (NewerGuideBannerManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == -1) {
      QQToast.a(a(), 2, a(2131720310), 0).b(a().getTitleBarHeight());
    }
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((-1 == paramInt) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        TroopUtils.a(a(), paramIntent, true);
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "discuss", "creat_discuss_msgtab", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean, String paramString, RecentUserProxy paramRecentUserProxy)
  {
    int i2 = a(paramRecentBaseData.getRecentUserUin(), paramInt);
    paramRecentBaseData = paramRecentUserProxy.a(false).iterator();
    int i1 = 0;
    if (paramRecentBaseData.hasNext())
    {
      if (((RecentUser)paramRecentBaseData.next()).showUpTime == 0L) {
        break label202;
      }
      i1 += 1;
    }
    label202:
    for (;;)
    {
      break;
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, paramString, String.valueOf(i1), String.valueOf(i2), "");
      if (paramInt == 7220)
      {
        if (paramBoolean) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(a(), "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
        }
      }
      else {
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
      return;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(9004);
    Message localMessage = Message.obtain();
    localMessage.what = 9004;
    localMessage.obj = paramString;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, paramInt);
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(9003);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 9003;
    localMessage.obj = paramString;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, paramInt);
  }
  
  private void a(int paramInt, List<RecentBaseData> paramList)
  {
    a().a(paramList, this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager);
    if ((-1 != this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a()) || ((this.G) && (this.H)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DragChangedListener.a(paramInt, paramList);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      if (AppSetting.jdField_i_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.7(this));
      }
      return;
    }
    int i1;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doRefreshUI|[").append(paramInt).append(",");
      if (paramList == null)
      {
        i1 = 0;
        QLog.i("Q.recent", 2, i1 + "]，shouldShowConversationMayknow = " + this.p);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
    {
      if (paramInt != 0) {
        break label285;
      }
      d(paramList);
    }
    for (;;)
    {
      if (AppSetting.jdField_i_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.8(this));
      }
      a().refreshMsgTabUnreadNum(false, this.jdField_d_of_type_Int);
      a(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      if (this.y)
      {
        this.y = false;
        ao();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
      an();
      PublicAccountEventReport.a(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, 0);
      OfficialAccountReporter.a.c();
      return;
      i1 = paramList.size();
      break;
      label285:
      c(paramList);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onNetWorkStateChange isNetWorkConnect = " + paramBoolean + " what = " + paramInt);
    }
    if (paramInt != 10003) {}
    while (!paramBoolean) {
      return;
    }
    a(3002, 200L, true, "qboss_banner_net_change");
    a(1072, 400L, true);
    a(500, "tianshu_req_splash_type_net_change", true);
    a(500, "tianshu_req_renewals_type_net_change");
    TianShuManager.setLastClickAdTraceInfo("", "");
  }
  
  private void a(long paramLong, List<RecentBaseData> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    SparseIntArray localSparseIntArray = new SparseIntArray(10100);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      i1 = ((RecentBaseData)localIterator.next()).getRecentUserType();
      localSparseIntArray.put(i1, localSparseIntArray.get(i1) + 1);
    }
    int i1 = 0;
    while (i1 < localSparseIntArray.size())
    {
      int i2 = localSparseIntArray.keyAt(i1);
      localHashMap.put("key_" + i2, String.valueOf(localSparseIntArray.get(i2)));
      i1 += 1;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_global", false, System.currentTimeMillis() - paramLong, paramList.size(), localHashMap, "");
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
        if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_c_of_type_AndroidAppDialog == null))
        {
          boolean bool = paramMessage.obj instanceof UpgradeTIMWrapper;
          if (bool) {}
        }
        else
        {
          return;
        }
        localUpgradeTIMWrapper = (UpgradeTIMWrapper)paramMessage.obj;
        if ((localUpgradeTIMWrapper == null) || (TextUtils.isEmpty(localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(localUpgradeTIMWrapper.c))) {
          continue;
        }
        Conversation.11 local11 = new Conversation.11(this);
        Conversation.12 local12 = new Conversation.12(this, localUpgradeTIMWrapper);
        if (TextUtils.isEmpty(localUpgradeTIMWrapper.d))
        {
          paramMessage = HardCodeUtil.a(2131702632);
          if (!TextUtils.isEmpty(localUpgradeTIMWrapper.e)) {
            break label323;
          }
          str = HardCodeUtil.a(2131702642);
          this.jdField_c_of_type_AndroidAppDialog = DialogUtils.a(a(), localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString, localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString, paramMessage, str, null, local12, local11);
          this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new Conversation.13(this));
          if ((!this.w) || (this.jdField_c_of_type_AndroidAppDialog.isShowing()) || ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.isShowing())) || (ConfigHandler.a(a()))) {
            continue;
          }
          this.jdField_c_of_type_AndroidAppDialog.show();
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
          ConfigHandler.a(a());
          a(1134048, 0L, true);
          continue;
        }
        paramMessage = localUpgradeTIMWrapper.d;
      }
      finally {}
      continue;
      label323:
      String str = localUpgradeTIMWrapper.e;
    }
  }
  
  private void a(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {}
    label91:
    do
    {
      return;
      paramMessage = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
      int i2 = paramMessage.size();
      Object localObject = new ArrayList(i2);
      int i1 = 0;
      if (i1 < i2)
      {
        do
        {
          for (;;)
          {
            RecentBaseData localRecentBaseData;
            try
            {
              localRecentBaseData = (RecentBaseData)paramMessage.get(i1);
              if (localRecentBaseData != null) {
                break label91;
              }
              i1 += 1;
            }
            catch (Exception paramMessage) {}
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.e("Q.recent", 4, paramMessage.toString());
            return;
            String str = RecentDataListManager.a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
            if ((this.jdField_b_of_type_JavaUtilList.contains(str)) || (this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(localRecentBaseData.getRecentUserUin(), -2147483648)))) {
              try
              {
                localRecentBaseData.update(a(), a());
                ((List)localObject).add(localRecentBaseData);
              }
              catch (Throwable localThrowable) {}
            }
          }
        } while (SafeModeUtil.a(BaseApplicationImpl.sApplication));
        throw new RuntimeException(localThrowable);
      }
      a(paramMessage);
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1019, 0, 0, localObject).sendToTarget();
      b(paramMessage);
      if (this.jdField_c_of_type_Int <= 8)
      {
        this.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_JavaUtilList.clear();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_items", false, System.currentTimeMillis() - paramLong, paramMessage.size(), (HashMap)localObject, "");
      StartupTracker.a("Conversation_Refresh_items", System.currentTimeMillis() - paramLong);
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "REFRESH_FLAG_ITEMS, [" + paramLong + "," + (System.currentTimeMillis() - paramLong) + "]");
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, int paramInt)
  {
    QQKRPUtil.a(a(), paramRecentUser, paramRecentBaseData);
    PublicAccountEventReport.a(a(), paramRecentBaseData);
    if ((paramRecentUser != null) && (paramRecentUser.lFlag == 16L) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "ad preload tool process hit");
      }
    }
    if ((paramRecentUser != null) && (String.valueOf(9970L).equals(paramRecentUser.uin)) && (this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null)) {
      this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
    }
    if ((paramRecentUser != null) && (paramRecentUser.getType() == 6004) && (this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null)) {
      this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
    }
    if (paramRecentUser != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER);
      paramRecentBaseData.setFeedInfoRead(paramRecentUser.uin);
      if (!FeedsManager.isShowStatus(paramRecentUser.uin)) {
        break label217;
      }
      BeancurdManager localBeancurdManager = (BeancurdManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.BEANCURD_MANAGER);
      if (localBeancurdManager != null)
      {
        long l1 = localBeancurdManager.a(paramRecentUser.uin);
        FeedsManager.saveToken(paramRecentUser.uin, l1);
        paramRecentBaseData.reportClickExpose();
        localBeancurdManager.a(2, 2);
      }
    }
    label217:
    do
    {
      do
      {
        return;
        paramRecentBaseData = a().getMessageFacade().b(paramRecentUser.uin, paramRecentUser.getType());
      } while ((paramRecentBaseData == null) || (paramRecentBaseData.msgtype != -1034));
      paramRecentBaseData = (BeancurdManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.BEANCURD_MANAGER);
    } while (paramRecentBaseData == null);
    paramRecentBaseData.a(2, 1);
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString1, boolean paramBoolean, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData, paramBoolean);
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", paramString2, paramString1, "");
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
          localObject1 = AdvertisementRecentUserManager.a().a(((RecentItemPublicAccountADFolderData)localObject1).mUser.uin);
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Message localMessage = Message.obtain();
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("key_app", new WeakReference(a()));
        ((HashMap)localObject2).put("key_adapter", new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter));
        ((HashMap)localObject2).put("key_listview", new WeakReference(paramAbsListView));
        localMessage.obj = localObject2;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_ad_id", ((AdvertisementItem)localObject1).c);
        localMessage.setData((Bundle)localObject2);
        localMessage.what = 1;
        ImaxAdPresenter.a().a(localMessage);
        i2 += 1;
      }
    }
  }
  
  private void a(Object paramObject)
  {
    JSONObject localJSONObject;
    if ((paramObject instanceof JSONObject)) {
      localJSONObject = (JSONObject)paramObject;
    }
    int i1;
    try
    {
      i1 = localJSONObject.getInt("actionType");
      switch (i1)
      {
      }
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
        i1 = -1;
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
        for (;;)
        {
          localJSONException.printStackTrace();
          i1 = -1;
        }
        a(8, paramObject, i1);
      }
      if ((-1 == i1) || (paramObject == null))
      {
        a(200L);
        return;
      }
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_CooperationVipAdTianshuSplashManager == null) {
      this.jdField_a_of_type_CooperationVipAdTianshuSplashManager = new TianshuSplashManager(a());
    }
    this.jdField_a_of_type_CooperationVipAdTianshuSplashManager.a(paramString);
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
        if ((!this.jdField_e_of_type_Boolean) && (bool))
        {
          paramObservable = null;
          if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
            paramObservable = (QCallFacade)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE);
          }
          if (paramObservable != null) {
            paramObservable.a(false);
          }
        }
      }
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(7, 2000);
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
      long l1 = FriendsStatusUtil.a(paramContext);
      if (l1 > 0L) {
        paramMqqHandler.postDelayed(new Conversation.42(paramMqqHandler), l1 * 1000L);
      }
      return;
    }
    paramContext = paramMqqHandler.obtainMessage(1134065);
    paramContext.arg1 = 0;
    paramMqqHandler.sendMessage(paramContext);
  }
  
  private boolean a(int paramInt, boolean paramBoolean, String paramString)
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 2)
    {
      ReportController.b(localAppRuntime, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i1, "0", "0", "", "");
      if (NetworkUtil.g(a().getApp().getApplicationContext())) {
        break;
      }
      QQToast.a(a(), 1, 2131696097, 0).b(a().getTitleBarHeight());
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "setChatAtTop top: " + paramBoolean + " uin: " + paramString + " userType: " + paramInt);
    }
    FriendsStatusUtil.a(a(), paramString, paramBoolean);
    return false;
  }
  
  private boolean a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData instanceof RecentItemMayKnowFriendData))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, " onRecentBaseDataClick recommend_item_menu");
      }
      B();
      ContactReportUtils.a(a(), "msgtab_list_clk", 1);
      return true;
    }
    if ((paramRecentBaseData instanceof RecentItemMayKnowFriendVerticalListData))
    {
      a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.getRecentUserUin());
      return true;
    }
    if ((paramRecentBaseData instanceof RecentItemRecommendTroopData))
    {
      ((MayknowRecommendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(paramView, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getContext(), paramRecentBaseData.getRecentUserUin());
      return true;
    }
    return false;
  }
  
  private boolean a(RecentBaseData paramRecentBaseData, boolean paramBoolean, RecentUserProxy paramRecentUserProxy, String paramString)
  {
    int i1 = paramRecentBaseData.getRecentUserType();
    if ((paramString == null) || (paramString.length() == 0) || (paramRecentUserProxy == null))
    {
      if (QLog.isColorLevel())
      {
        paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
        if (paramString != null) {
          break label85;
        }
        paramBoolean = true;
        paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
        if (paramRecentUserProxy != null) {
          break label90;
        }
      }
      label85:
      label90:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("Q.recent", 2, paramBoolean);
        return true;
        paramBoolean = false;
        break;
      }
    }
    RecentUser localRecentUser = paramRecentUserProxy.b(paramString, i1);
    if (localRecentUser == null) {
      localRecentUser = new RecentUser(paramString, i1);
    }
    label392:
    label434:
    for (;;)
    {
      int i3;
      if (paramBoolean)
      {
        localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
        paramRecentUserProxy.b(localRecentUser);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
        if ((i1 != 7210) && (i1 != 7120)) {
          break label392;
        }
        i3 = paramRecentBaseData.mUnreadNum;
        paramRecentBaseData = "0X80064C4";
        if (paramBoolean) {
          paramRecentBaseData = "0X80064C3";
        }
        if (i1 != 7120) {
          break label614;
        }
      }
      label221:
      label608:
      label611:
      label614:
      for (int i2 = 1;; i2 = 0)
      {
        paramRecentUserProxy = paramRecentUserProxy.a(false).iterator();
        i1 = 0;
        if (paramRecentUserProxy.hasNext())
        {
          if (((RecentUser)paramRecentUserProxy.next()).showUpTime == 0L) {
            break label611;
          }
          i1 += 1;
        }
        for (;;)
        {
          break label221;
          localRecentUser.showUpTime = 0L;
          break;
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Pb_account_lifeservice", "" + i2, paramRecentBaseData, paramRecentBaseData, 0, 0, "" + i3, "" + i1, "", "");
          do
          {
            if ((7220 == localRecentUser.getType()) && (AppConstants.KANDIAN_MERGE_UIN.equals(paramString))) {
              ((KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).c(paramBoolean);
            }
            return false;
          } while (i1 != 1008);
          i2 = paramRecentBaseData.mUnreadNum;
          paramRecentBaseData = "0X80064C8";
          if (paramBoolean) {
            paramRecentBaseData = "0X80064C7";
          }
          paramRecentUserProxy = paramRecentUserProxy.a(false).iterator();
          i1 = 0;
          if (paramRecentUserProxy.hasNext())
          {
            if (((RecentUser)paramRecentUserProxy.next()).showUpTime == 0L) {
              break label608;
            }
            i1 += 1;
          }
          for (;;)
          {
            break label434;
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Pb_account_lifeservice", localRecentUser.uin, paramRecentBaseData, paramRecentBaseData, 0, 0, "" + i2, "" + i1, "", "");
            if (!"2290230341".equals(paramString)) {
              break;
            }
            if (paramBoolean) {}
            for (paramRecentBaseData = "0X80090E6";; paramRecentBaseData = "0X800915B")
            {
              if (paramBoolean) {
                QZoneReport.a(4);
              }
              ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", paramRecentBaseData, paramRecentBaseData, 0, 0, "", "", "", "");
              break;
            }
          }
        }
      }
    }
  }
  
  private void aA()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 800L);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void aa()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.a();
    }
  }
  
  private void ab()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onResume();
    }
  }
  
  private void ac()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar.d();
    }
  }
  
  private void ad()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.k();
    }
  }
  
  private void ae()
  {
    if (a().upgradeData != null)
    {
      a(a().upgradeData);
      a().upgradeData = null;
    }
  }
  
  private void af()
  {
    if ((jdField_b_of_type_Long == -1L) && (SplashActivity.sIsNormalRouteEnter))
    {
      jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).setResumeFlagFromConversation(jdField_b_of_type_Long);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).saveNormalEnterConversationTime(jdField_b_of_type_Long);
    }
  }
  
  private void ag()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new Conversation.24(this), 500L);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1070, 3000L);
    ((RedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(System.currentTimeMillis());
    TianShuManager.setLastClickAdTraceInfo("", "");
    ReadInJoyUtils.b(a());
    ak();
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1053)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1053, 500L);
    }
    RecentPubAccHelper.b(a());
  }
  
  private void ah()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (FrameHelperActivity.b())
      {
        FrameHelperActivity.c(true);
        FrameHelperActivity.w();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void ai()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager;
    if (localObject != null)
    {
      VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).a();
      if (localVipGiftDownloadInfo != null)
      {
        a((VipGiftManager)localObject, localVipGiftDownloadInfo);
        if (a((VipGiftManager)localObject, localVipGiftDownloadInfo))
        {
          localObject = (BaseActivity)a();
          if ((localObject instanceof SplashActivity)) {
            ((SplashActivity)localObject).showGifAnnimate();
          }
        }
      }
    }
  }
  
  private void aj()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)localIterator.next();
        if (localConversationPullDownActiveBase != null) {
          if (this.v)
          {
            localConversationPullDownActiveBase.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
            localConversationPullDownActiveBase.jdField_c_of_type_Boolean = true;
            localConversationPullDownActiveBase.c();
          }
          else
          {
            localConversationPullDownActiveBase.d();
          }
        }
      }
      this.v = false;
    }
  }
  
  private void ak()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null) {
      this.jdField_c_of_type_JavaLangRunnable = new Conversation.25(this);
    }
    ThreadManagerV2.excute(this.jdField_c_of_type_JavaLangRunnable, 32, null, true);
  }
  
  private void al()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (FrameHelperActivity.b()) {
        FrameHelperActivity.w();
      }
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int != 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.m = true;
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.h();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.d();
      }
    }
    for (;;)
    {
      if (this.t) {
        this.t = false;
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.i();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.d();
      }
    }
  }
  
  private void am()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b();
    }
    c("onResume");
  }
  
  private void an()
  {
    if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(true))) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidViewView == null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0);
    } while (!(localObject instanceof RecentUserBaseData));
    Object localObject = (RecentUserBaseData)localObject;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
    boolean bool;
    label99:
    int i1;
    if ((((RecentUserBaseData)localObject).mUser.getType() == 1) && (!HotChatUtil.a(a(), ((RecentUserBaseData)localObject).mUser)))
    {
      bool = localTroopManager.b(((RecentUserBaseData)localObject).getRecentUserUin());
      if (this.B == bool) {
        break label218;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent", 4, "setLocalSearchBarByShowUpMask:mShowUPMask = " + this.B + ", dstMsg = " + bool);
      }
      if (!bool) {
        break label220;
      }
      i1 = 2130850757;
      label161:
      if (!bool) {
        break label227;
      }
    }
    label218:
    label220:
    label227:
    for (int i2 = 2130850769;; i2 = 2130850768)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(i1);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366452).setBackgroundResource(i2);
      this.B = bool;
      return;
      if (((RecentUserBaseData)localObject).mUser.showUpTime > 0L)
      {
        bool = true;
        break label99;
      }
      bool = false;
      break label99;
      break;
      i1 = 2130850756;
      break label161;
    }
  }
  
  private void ao()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess start");
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (!this.jdField_j_of_type_Boolean)) {
      break label30;
    }
    label30:
    label178:
    for (;;)
    {
      return;
      if ((TeamWorkUtils.a(a())) && (TeamWorkUtils.b(a())))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
          label73:
          if (i1 <= this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition())
          {
            Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
            if ((!(localObject instanceof RecentItemTencentDocsAssistantData)) || (((RecentItemTencentDocsAssistantData)localObject).getUnreadNum() <= 0)) {}
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 == 0) || (!((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).preloadWebProcess(a()))) {
            break label178;
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
  
  private void ap()
  {
    if (this.jdField_a_of_type_CooperationVipAdTianshuAdManager != null)
    {
      this.jdField_a_of_type_CooperationVipAdTianshuAdManager.b();
      this.jdField_a_of_type_CooperationVipAdTianshuAdManager = null;
    }
    if (this.jdField_a_of_type_CooperationVipAdTianshuSplashManager != null)
    {
      this.jdField_a_of_type_CooperationVipAdTianshuSplashManager.a();
      this.jdField_a_of_type_CooperationVipAdTianshuSplashManager = null;
    }
    if (this.jdField_a_of_type_CooperationVipAdTianshuRenewalsBarManager != null)
    {
      this.jdField_a_of_type_CooperationVipAdTianshuRenewalsBarManager.a();
      this.jdField_a_of_type_CooperationVipAdTianshuRenewalsBarManager = null;
    }
  }
  
  private void aq()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar.b();
    }
  }
  
  private void ar()
  {
    b(new Conversation.28(this));
  }
  
  private void as()
  {
    TroopAssistantManager.a().k(a());
    Object localObject = ServiceAccountFolderManager.a();
    if (localObject != null) {
      ((ServiceAccountFolderManager)localObject).a(a());
    }
    localObject = TroopBarAssistantManager.a();
    if (localObject != null) {
      ((TroopBarAssistantManager)localObject).i(a());
    }
    TroopNotificationHelper.a(a());
    localObject = (TroopTipsMsgMgr)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
    if (localObject != null) {
      ((TroopTipsMsgMgr)localObject).b(a());
    }
    for (;;)
    {
      localObject = (EcShopAssistantManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if (localObject != null) {
        ((EcShopAssistantManager)localObject).e();
      }
      localObject = (GroupVideoManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
      if (localObject != null) {
        ((GroupVideoManager)localObject).a(true);
      }
      localObject = (HotChatCenterManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
      if (localObject != null) {
        ((HotChatCenterManager)localObject).a();
      }
      HiddenChatManager.a(a()).b();
      localObject = (ExtendFriendLimitChatManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
      if (localObject != null) {
        ((ExtendFriendLimitChatManager)localObject).d();
      }
      localObject = (StoryHaloManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STORY_HALO_MANAGER);
      ((StoryHaloManager)localObject).a(1, ((StoryHaloManager)localObject).a(this.jdField_a_of_type_JavaUtilList));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
      }
    }
  }
  
  private void at()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "updateMayKnowOrTroopRecommend");
    }
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if (localMayknowRecommendManager.c())
    {
      localMayknowRecommendManager.c();
      return;
    }
    this.p = localMayknowRecommendManager.d();
    ArrayList localArrayList = localMayknowRecommendManager.c();
    if ((this.p) && (localArrayList != null) && (localArrayList.size() > 0))
    {
      localMayknowRecommendManager.d();
      return;
    }
    localMayknowRecommendManager.e();
    this.p = false;
  }
  
  private void au()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new Conversation.44(this);
  }
  
  private void av()
  {
    if (QLog.isColorLevel()) {
      QLog.d(RecentDataListManager.jdField_a_of_type_JavaLangString, 2, "preloadNextScreenUserFaceIcon:" + this.z);
    }
    int i1;
    int i2;
    int i3;
    if (this.z)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() + 1;
      i2 = 1;
      i3 = 0;
      if ((i2 != 0) && (i3 < 10) && (i1 >= 0)) {
        break label103;
      }
    }
    label103:
    while (i1 >= this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount())
    {
      return;
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
      i2 = 0;
      break;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
    if ((localObject != null) && ((localObject instanceof RecentBaseData)))
    {
      localObject = (RecentBaseData)localObject;
      if (!(localObject instanceof RecentItemImaxADData)) {}
    }
    for (;;)
    {
      i3 += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a().a(((RecentBaseData)localObject).getRecentUserType(), ((RecentBaseData)localObject).getRecentUserUin(), false);
      i1 += i2;
    }
  }
  
  private void aw()
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks[0] = new Conversation.57(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks[1] = new LebaTabRedTouch.QZoneRedPointDrawerCallback();
  }
  
  private void ax()
  {
    if ((this.w) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      ThreadManager.post(new Conversation.58(this), 5, null, true);
    }
  }
  
  private void ay()
  {
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1048, 0, 0).sendToTarget();
    }
  }
  
  private void az()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), a().getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694686);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new Conversation.65(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt + ", src: " + -1);
    }
  }
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ApolloSurfaceView localApolloSurfaceView = CmGameUtil.a();
    if (localApolloSurfaceView != null) {
      localApolloSurfaceView.runRenderTask(new Conversation.4(this, localApolloSurfaceView, paramInt1, paramInt2, paramIntent));
    }
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    AbsStructMsg localAbsStructMsg;
    if ((paramIntent != null) && (paramInt == -1))
    {
      localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg != null) {}
    }
    else
    {
      return;
    }
    String str = paramIntent.getStringExtra("uin");
    paramInt = paramIntent.getIntExtra("uintype", -1);
    int i1 = paramIntent.getIntExtra("cmshow_game_id", -1);
    ShareMsgHelper.a(a(), str, paramInt, localAbsStructMsg, null);
    VipUtils.a((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "cmshow", "Apollo", "share_url_succeed", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramInt), 0, new String[] { Integer.toString(i1) });
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceiverShowUpgradeTips");
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) || (!(paramMessage.obj instanceof UpgradeDetailWrapper))) {}
    do
    {
      return;
      paramMessage = (UpgradeDetailWrapper)paramMessage.obj;
      if (ConfigHandler.a(a()) >= 5)
      {
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(15, 3000);
        return;
      }
    } while ((ConfigHandler.a(a())) || (ConfigHandler.a(a(), 0) == null));
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog = new UpgradeTipsDialog(a(), a(), paramMessage, this);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.setOnDismissListener(new Conversation.14(this));
  }
  
  private void b(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {}
    for (;;)
    {
      return;
      if (QvipSpecialCareManager.a(a())) {
        QvipSpecialCareManager.a(a());
      }
      L();
      List localList1 = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
      List localList2 = a().getProxyManager().a().a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper.a(localList2);
      localList1.clear();
      int i1;
      int i2;
      label83:
      RecentUser localRecentUser;
      String str;
      RecentBaseData localRecentBaseData;
      if (localList2 == null)
      {
        i1 = 0;
        i2 = 0;
        if (i2 >= i1) {
          break label305;
        }
        localRecentUser = (RecentUser)localList2.get(i2);
        str = RecentDataListManager.a(localRecentUser.uin, localRecentUser.getType());
        localRecentBaseData = RecentDataListManager.a().a(str);
        if (localRecentBaseData != null) {
          break label204;
        }
        localRecentBaseData = ConversationDataFactory.a(localRecentUser, a(), a());
        paramMessage = localRecentBaseData;
        if (localRecentBaseData != null)
        {
          RecentDataListManager.a().a(localRecentBaseData, str);
          paramMessage = localRecentBaseData;
        }
      }
      for (;;)
      {
        if (paramMessage != null) {
          localList1.add(paramMessage);
        }
        i2 += 1;
        break label83;
        i1 = localList2.size();
        break;
        label204:
        if (!this.jdField_b_of_type_JavaUtilList.contains(str))
        {
          paramMessage = localRecentBaseData;
          if (!this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(localRecentUser.uin, -2147483648))) {}
        }
        else
        {
          if ((localRecentBaseData instanceof RecentUserBaseData)) {
            ((RecentUserBaseData)localRecentBaseData).a(localRecentUser);
          }
          try
          {
            localRecentBaseData.update(a(), a());
            paramMessage = localRecentBaseData;
          }
          catch (Throwable paramMessage)
          {
            if (!SafeModeUtil.a(BaseApplicationImpl.sApplication)) {
              throw new RuntimeException(paramMessage);
            }
            paramMessage = null;
          }
        }
      }
      try
      {
        label305:
        Collections.sort(localList1, this.jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper);
        e(localList1);
        a(localList1);
        paramMessage = new ArrayList(localList1);
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
        b(localList1);
        if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null)
        {
          paramMessage = Message.obtain();
          paramMessage.what = 2000;
          this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(19, paramMessage);
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
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Conversation_Refresh_part", false, System.currentTimeMillis() - paramLong, localList1.size(), paramMessage, "");
        StartupTracker.a("Conversation_Refresh_part", System.currentTimeMillis() - paramLong);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.recent", 2, "REFRESH_FLAG_PART, [" + paramLong + "," + (System.currentTimeMillis() - paramLong) + "]");
        return;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          paramMessage.printStackTrace();
        }
      }
    }
  }
  
  private void b(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser, int paramInt)
  {
    if (paramRecentUser != null)
    {
      if ((paramRecentUser.getType() != 7120) && (paramRecentUser.getType() != 7210) && (paramRecentUser.getType() != 1008)) {
        break label210;
      }
      paramRecentBaseData = "0X80067EC";
      if (paramInt != 0) {
        break label274;
      }
      paramRecentBaseData = "0X80067ED";
    }
    label274:
    for (int i1 = 0;; i1 = 1)
    {
      Object localObject = a().getMessageFacade().b(paramRecentUser.uin, paramRecentUser.getType());
      if ((localObject != null) && ((localObject instanceof MessageForStructing)))
      {
        localObject = ((MessageForStructing)localObject).structingMsg;
        if (localObject == null) {}
      }
      for (long l1 = ((AbsStructMsg)localObject).msgId;; l1 = 0L)
      {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Pb_account_lifeservice", "", paramRecentBaseData, paramRecentBaseData, 0, 0, paramRecentUser.uin + "", "" + l1, "" + i1, "" + paramInt);
        label210:
        do
        {
          return;
        } while (paramRecentUser.getType() != 6004);
        if (paramInt > 0) {}
        for (paramInt = 1;; paramInt = 2)
        {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80090CC", "0X80090CC", paramInt, 0, "", "", "", "");
          return;
        }
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
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_CooperationVipAdTianshuRenewalsBarManager == null) {
      this.jdField_a_of_type_CooperationVipAdTianshuRenewalsBarManager = new TianshuRenewalsBarManager(this);
    }
    this.jdField_a_of_type_CooperationVipAdTianshuRenewalsBarManager.a(paramString);
  }
  
  private boolean b(RecentBaseData paramRecentBaseData, boolean paramBoolean, RecentUserProxy paramRecentUserProxy, String paramString)
  {
    boolean bool = false;
    Object localObject = (TroopManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.getRecentUserUin());
    int i1;
    if (!TextUtils.isEmpty(str))
    {
      paramRecentUserProxy = (BizTroopHandler)a().getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      if (paramBoolean) {}
      for (i1 = 0; !paramRecentUserProxy.a(str, i1); i1 = 1) {
        return true;
      }
      paramRecentUserProxy = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
      if (paramRecentUserProxy != null) {}
      switch (paramRecentUserProxy.troopmask)
      {
      case 2: 
      case 3: 
      default: 
        i1 = 0;
        label127:
        paramRecentUserProxy = new ReportTask(a()).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
        paramString = paramRecentBaseData.getRecentUserUin();
        if (paramBoolean)
        {
          paramRecentBaseData = "0";
          label177:
          paramRecentUserProxy.a(new String[] { paramString, String.valueOf(i1), paramRecentBaseData }).a();
        }
        break;
      }
    }
    do
    {
      return false;
      i1 = 0;
      break label127;
      i1 = 3;
      break label127;
      paramRecentBaseData = "1";
      break label177;
      if (QLog.isColorLevel()) {
        QLog.e("Q.recent", 2, "TroopManage.getTroopCodeByTroopUin return null...");
      }
      i1 = paramRecentBaseData.getRecentUserType();
      if ((paramString == null) || (paramString.length() == 0) || (paramRecentUserProxy == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
        if (paramString == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
          paramBoolean = bool;
          if (paramRecentUserProxy == null) {
            paramBoolean = true;
          }
          QLog.d("Q.recent", 2, paramBoolean);
          return true;
        }
      }
      localObject = paramRecentUserProxy.b(paramString, i1);
      paramRecentBaseData = (RecentBaseData)localObject;
      if (localObject == null) {
        paramRecentBaseData = new RecentUser(paramString, i1);
      }
    } while (!HotChatUtil.a(a(), paramRecentBaseData));
    if (paramBoolean) {}
    for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
    {
      paramRecentUserProxy.b(paramRecentBaseData);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      break;
    }
  }
  
  private void c(int paramInt)
  {
    for (;;)
    {
      try
      {
        QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync from=", Integer.valueOf(paramInt), " isInRealActionLoginB=", Boolean.valueOf(a().mAutomator.b()), " isLoadUIAfterMsgSync=", Boolean.valueOf(this.m) });
        if (1 == paramInt)
        {
          this.r = true;
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
          a(1072, 500L, true);
          a(500, "tianshu_req_splash_type_after_sync", true);
          a(500, "tianshu_req_renewals_type_after_sync");
          a(1073, 30000L, true);
          a(1077, 1200L, true);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.f();
          }
          PublicAccountDataManager.b();
        }
        if (!this.m)
        {
          boolean bool = this.jdField_h_of_type_Boolean;
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.m = true;
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(23, 2001);
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
        R();
        CrashVersionUtils.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync cost=", Long.valueOf(System.currentTimeMillis() - l1), " all done!" });
        } else {
          QLog.d("Q.recent", 2, "doAfterMsgSync all done!");
        }
      }
      finally {}
    }
  }
  
  private void c(long paramLong)
  {
    if (this.jdField_g_of_type_Boolean) {
      a(1016, paramLong, true);
    }
  }
  
  private void c(Message paramMessage)
  {
    boolean bool = a(paramMessage);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "REFRESH_FLAG_RECENT_ITEMS, [" + paramMessage.arg1 + "," + paramMessage.arg2 + "," + paramMessage.obj + "," + this.jdField_j_of_type_Boolean + "," + bool + "]");
    }
    if (!bool) {
      return;
    }
    int i2 = paramMessage.arg2;
    Object localObject;
    long l1;
    if ((i2 == 8) || (i2 == 9))
    {
      localObject = null;
      if ((paramMessage.obj instanceof String)) {
        localObject = (String)paramMessage.obj;
      }
      if ((localObject != null) && (!this.jdField_b_of_type_JavaUtilList.contains(localObject))) {
        this.jdField_b_of_type_JavaUtilList.add(localObject);
      }
      l1 = 0L;
    }
    for (;;)
    {
      if (i2 >= this.jdField_c_of_type_Int)
      {
        int i1 = 8;
        for (;;)
        {
          if (i1 < i2)
          {
            this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(i1);
            i1 += 1;
            continue;
            if (!(paramMessage.obj instanceof Long)) {
              break label323;
            }
            l1 = ((Long)paramMessage.obj).longValue();
            break;
          }
        }
        this.jdField_c_of_type_Int = i2;
      }
      if ((!this.jdField_j_of_type_Boolean) || (this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(this.jdField_c_of_type_Int))) {
        break;
      }
      long l2 = Math.abs(System.currentTimeMillis() - this.jdField_d_of_type_Long);
      l1 = Math.max(this.jdField_a_of_type_Long - l2, l1);
      localObject = Message.obtain();
      ((Message)localObject).arg1 = paramMessage.arg1;
      ((Message)localObject).what = this.jdField_c_of_type_Int;
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, l1);
      return;
      label323:
      l1 = 0L;
    }
  }
  
  private void c(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {
      return;
    }
    ((HotChatCenterManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).b();
    TroopAssistantManager.a().e(a());
    L();
    paramMessage = a().getProxyManager().a();
    if (QvipSpecialCareManager.a(a())) {
      QvipSpecialCareManager.a(a());
    }
    if ((a().mAutomator != null) && (a().mAutomator.b())) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        Object localObject = paramMessage.a(bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper.a((List)localObject);
        paramMessage = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
        QQAppInterface localQQAppInterface = a();
        QBaseActivity localQBaseActivity = a();
        int i1;
        if (localObject != null)
        {
          i1 = ((List)localObject).size();
          ConversationDataFactory.a((List)localObject, localQQAppInterface, localQBaseActivity, paramMessage, i1);
        }
        try
        {
          Collections.sort(paramMessage, this.jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper);
          e(paramMessage);
          a(paramMessage);
          localObject = new ArrayList(paramMessage);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, localObject).sendToTarget();
          QLog.d("Q.recent", 1, new Object[] { "notify MSG_REFRESH_UI,size=", Integer.valueOf(((List)localObject).size()) });
          b(paramMessage);
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
          this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
          this.jdField_d_of_type_Long = System.currentTimeMillis();
          a(paramLong, paramMessage);
          localObject = (StoryHaloManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STORY_HALO_MANAGER);
          ((StoryHaloManager)localObject).b(3, ((StoryHaloManager)localObject).a(paramMessage));
          StartupTracker.a("Conversation_Refresh_global", System.currentTimeMillis() - paramLong);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "REFRESH_FLAG_GLOBAL, [" + paramLong + "," + (System.currentTimeMillis() - paramLong) + "]");
          return;
          i1 = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("Q.recent", 2, "Comparator Exception: ", localException);
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  private void c(Object paramObject)
  {
    if ((paramObject instanceof RecentUser))
    {
      a(200L);
      if ((this.jdField_f_of_type_Boolean) && (((RecentUser)paramObject).getType() == 6004)) {
        this.y = true;
      }
    }
  }
  
  private void c(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.18(this, paramString));
  }
  
  private void c(List<RecentBaseData> paramList)
  {
    int i1;
    int i2;
    label8:
    RecentBaseData localRecentBaseData;
    if (paramList == null)
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1) {
        return;
      }
      localRecentBaseData = (RecentBaseData)paramList.get(i2);
      if (localRecentBaseData != null) {
        break label47;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label8;
      i1 = paramList.size();
      break;
      label47:
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(localRecentBaseData);
    }
  }
  
  private void d(Object paramObject)
  {
    int i3 = 9;
    int i4 = 0;
    MessageRecord localMessageRecord;
    if ((paramObject instanceof MessageRecord))
    {
      localMessageRecord = (MessageRecord)paramObject;
      a().refreshMultiAIOUnreadNum(localMessageRecord.frienduin, localMessageRecord.istroop);
      if ((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.msgtype != -2002)) {
        break label57;
      }
    }
    label57:
    while ((localMessageRecord.isSendFromLocal()) && (localMessageRecord.msgtype == -2000) && (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    if ((this.jdField_f_of_type_Boolean) && (PublicAccountAdUtil.a(localMessageRecord)))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      m(false);
    }
    if ((this.jdField_f_of_type_Boolean) && (ImaxAdUtil.a(localMessageRecord))) {
      ImaxAdRecentUserManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
    }
    if ((this.jdField_f_of_type_Boolean) && (QCircleChatUtil.a(localMessageRecord.istroop))) {
      s();
    }
    int i5 = 10;
    Long localLong = Long.valueOf(0L);
    int i2;
    int i1;
    if ((localMessageRecord.isSendFromLocal()) && ((!this.jdField_f_of_type_Boolean) || (TextUtils.equals(localMessageRecord.frienduin, AppConstants.NEW_KANDIAN_UIN)) || (TextUtils.equals(localMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))))
    {
      paramObject = RecentDataListManager.a(localMessageRecord.frienduin, localMessageRecord.istroop);
      i2 = 9;
      i1 = 2;
      if (localMessageRecord.isSend()) {
        QAVHrMeeting.a(a(), localMessageRecord);
      }
      if (!e()) {
        break label389;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "update message in AIO");
      }
      i1 = 4;
      paramObject = RecentDataListManager.a(localMessageRecord.frienduin, localMessageRecord.istroop);
      i2 = i3;
    }
    label389:
    for (;;)
    {
      a(i1, i2, paramObject);
      this.H = true;
      return;
      paramObject = localLong;
      i2 = i5;
      i1 = i4;
      if (this.jdField_f_of_type_Boolean) {
        break;
      }
      paramObject = localLong;
      i2 = i5;
      i1 = i4;
      if (!RecentUtil.jdField_b_of_type_Boolean) {
        break;
      }
      paramObject = localLong;
      i2 = i5;
      i1 = i4;
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1024)) {
        break;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1024, 100L);
      paramObject = localLong;
      i2 = i5;
      i1 = i4;
      break;
    }
  }
  
  private void d(List<RecentBaseData> paramList)
  {
    if (this.p)
    {
      MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if ((localMayknowRecommendManager.jdField_a_of_type_Boolean) && (localMayknowRecommendManager.a(paramList))) {
        localMayknowRecommendManager.jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramList);
    if (this.D)
    {
      this.D = false;
      if (this.E)
      {
        if (!this.jdField_f_of_type_Boolean) {
          break label122;
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addOnLayoutChangeListener(new Conversation.9(this));
      }
    }
    for (;;)
    {
      this.E = false;
      if (paramList != null) {
        RecentDataListManager.a().a(paramList, a().getCurrentUin());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
      return;
      label122:
      aA();
    }
  }
  
  private void e(List<RecentBaseData> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      paramList = new ArrayList(paramList);
      this.jdField_a_of_type_JavaLangStringBuilder.append("SortedRecentInfo, [");
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
      int i2 = paramList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = (RecentBaseData)paramList.get(i1);
        if ((localObject instanceof RecentUserBaseData))
        {
          localObject = (RecentUserBaseData)localObject;
          if (((((RecentUserBaseData)localObject).getRecentUserType() == 1) && (!HotChatUtil.a(a(), ((RecentUserBaseData)localObject).mUser)) && (localTroopManager.b(((RecentUserBaseData)localObject).getRecentUserUin()))) || (((RecentUserBaseData)localObject).mUser.showUpTime != 0L)) {
            this.jdField_a_of_type_JavaLangStringBuilder.append("t-");
          }
          this.jdField_a_of_type_JavaLangStringBuilder.append(((RecentUserBaseData)localObject).getRecentUserType()).append("-").append(StringUtil.e(((RecentUserBaseData)localObject).getRecentUserUin())).append("-").append(i1).append(" , ");
        }
        i1 += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("]");
    paramList.clear();
    QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  private boolean e()
  {
    boolean bool2 = Foreground.isCurrentProcessForeground();
    boolean bool3 = QBaseActivity.sTopActivity instanceof SplashActivity;
    boolean bool1;
    if (bool3)
    {
      Fragment localFragment = ((SplashActivity)QBaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (((localFragment instanceof ChatFragment)) && (localFragment.isVisible())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "mIsForeground=", Boolean.valueOf(this.jdField_f_of_type_Boolean), " isProcessForeground=", Boolean.valueOf(bool2), " isSplashActivity=", Boolean.valueOf(bool3), " isChatFragment=", Boolean.valueOf(bool1) });
      }
      if ((!this.jdField_f_of_type_Boolean) && (bool2) && (bool3) && (bool1))
      {
        return true;
        bool1 = false;
      }
      else
      {
        return false;
        bool1 = false;
      }
    }
  }
  
  private boolean f()
  {
    if (!SharedPreUtils.d(a(), a().getCurrentAccountUin()))
    {
      Object localObject2 = a().getProxyManager().a().a(false);
      if ((localObject2 == null) || (((List)localObject2).size() == 0))
      {
        SharedPreUtils.j(a(), a().getCurrentAccountUin());
        return true;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = (TroopManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser.getType() == 1) && (localRecentUser.showUpTime > 0L))
        {
          ((TroopManager)localObject1).a(localRecentUser.uin, localRecentUser.showUpTime);
          localArrayList.add(localRecentUser.uin);
          a(9, localRecentUser.uin, 1);
        }
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (SharedPreUtils.a(a(), a().getCurrentAccountUin()).contains(localObject2)) {
          localArrayList.remove(localObject2);
        }
      }
      if (localArrayList.size() == 0)
      {
        SharedPreUtils.j(a(), a().getCurrentAccountUin());
        return true;
      }
      ((BizTroopHandler)a().getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).a(localArrayList, 0);
    }
    return false;
  }
  
  private void i(boolean paramBoolean)
  {
    if (this.n != paramBoolean)
    {
      if (!paramBoolean) {
        break label149;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null)
      {
        QLog.e("Q.recent", 1, "Error State that mChatTopReflesh is null! ui Not Init! will updateMsgTabStoryNodeView(true) later.");
        this.s = true;
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager = new MsgTabStoryNodeListManager(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, (BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368491));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_f_of_type_Boolean = this.w;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.b();
    for (this.s = false;; this.s = false)
    {
      this.n = paramBoolean;
      return;
      label149:
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.c();
      }
    }
  }
  
  private void j(boolean paramBoolean)
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
    a().setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver);
    a().registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQZoneFeedsObserver);
    a().registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    StudyModeManager.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
    Object localObject2 = (RedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (localObject2 != null) {
      ((RedTouchManager)localObject2).addObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      au();
    }
    a().getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon = new Conversation.TPHInCon(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon.addFilter(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, C2CPttDownloadProcessor.class, C2CPttUploadProcessor.class, GroupPicUploadProcessor.class, GroupPttDownloadProcessor.class, ForwardImageProcessor.class });
    ((ITransFileController)a().getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon);
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
      localObject2 = new IntentFilter("com.tencent.WT.WT_OUT_OF_AIO");
      a().registerReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      if (this.jdField_a_of_type_MqqAppAppRuntime.isLogin())
      {
        a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
        a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver, true);
        localObject2 = (SpringFestivalEntryManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        if (localObject2 != null) {
          ((SpringFestivalEntryManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback);
        }
        this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback);
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack);
        a().getMessageFacade().addObserver(this);
        localObject2 = (QCallFacade)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (localObject2 != null) {
          ((QCallFacade)localObject2).addObserver(this);
        }
        a().getGAudioHandler().a();
        a().getAVNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
        UITools.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext());
        a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver);
        a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
        a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver);
        a().addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleHandlerQCircleObserver);
        if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper != null) {
          this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.b();
        }
      }
      a().d();
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("AfterAddObservers");
        return;
      }
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
  
  private void k(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null)) {
      this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    }
    m(true);
    ao();
    v();
  }
  
  private void l(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.k))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.e();
        this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.a(false);
      }
      ConversationQbossBannerTitleEntranceCtrl localConversationQbossBannerTitleEntranceCtrl = this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl;
      if (localConversationQbossBannerTitleEntranceCtrl != null) {
        localConversationQbossBannerTitleEntranceCtrl.a(false);
      }
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if ((!((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isPreloadTooProcess()) || ((!paramBoolean) && (((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).hasPreloadWebProcessor()))) {}
    label178:
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
          break label178;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null) && (!this.x))
        {
          this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.x = true;
        }
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).setHasPreloadWebProcessor(true);
        ThreadManager.getSubThreadHandler().postDelayed(new Conversation.26(this), 1000L);
        return;
        i1 += 1;
        break;
      }
    }
  }
  
  public void A()
  {
    Object localObject = a();
    if (this.jdField_e_of_type_Boolean)
    {
      if (localObject == null) {}
      while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar == null) {
        return;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar.a((RecentAdapter)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "moveToCaredItemCyclic: invoked.  canFindUnreadItem: " + bool + " currentCaredType:" + this.jdField_f_of_type_Int + " currentUnreadCaredItemIndex: " + this.jdField_g_of_type_Int);
      }
      int i1 = (int)(a().getResources().getDimension(2131298886) + a().getResources().getDimension(2131298903) / 2.0F);
      int i2 = this.jdField_g_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      if (this.jdField_g_of_type_Int == 0) {
        i1 = 0;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, new Object[] { "moveToCaredItemCyclic: invoked. selection1 ", " position: ", Integer.valueOf(i2) });
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar.c();
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelectionFromTop(i2, i1);
        localObject = new Conversation.62(this, i2);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed((Runnable)localObject, 250L);
      }
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A1E3", "0X800A1E3", 0, 0, "", "", "", "");
  }
  
  void B()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(a());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131691337);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new Conversation.63(this));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public int a()
  {
    return this.jdField_h_of_type_Int;
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
      } while (RecentUtil.a(a(), paramString));
      return 4;
    case 3000: 
      return 2;
    case 1: 
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
    }
    return 11;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    StartupTracker.a(null, "Recent_Start");
    StartupTracker.a(null, "Recent_CreateView");
    Object localObject1 = (BaseActivity)a();
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof SplashActivity)))
    {
      localObject2 = (SplashActivity)localObject1;
      localObject1 = ((SplashActivity)localObject2).mPreloadConversationView;
      ((SplashActivity)localObject2).mPreloadConversationView = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramLayoutInflater.inflate(2131559044, null);
      }
      StartupTracker.a("Recent_CreateView", null);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public MsgTabStoryNodeListManager a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
  }
  
  public RecentAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime;
  }
  
  public MiniAppPullInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
  }
  
  public void a()
  {
    super.a();
    i();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onActivityResult, [" + paramInt1 + "," + paramInt2 + "," + paramIntent);
    }
    switch (paramInt1)
    {
    default: 
    case 14002: 
    case 2: 
    case 1000: 
      do
      {
        do
        {
          return;
          b(paramInt2, paramIntent);
          return;
        } while (a() == null);
        a().setCanLock(false);
        return;
      } while (paramInt2 != 0);
      C();
      a().exit(false);
      return;
    case 1300: 
      a(paramInt2, paramIntent);
      return;
    case 9001: 
      a(paramInt2);
      return;
    case 9002: 
      b(paramInt1);
      return;
    case 9010: 
      RecentOptPopBar.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
      return;
    case 14005: 
    case 14006: 
      b(paramInt1, paramInt2, paramIntent);
      return;
    }
    J();
  }
  
  protected void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "refreshRecentList invalidate params arg1: " + paramInt1 + ", arg2: " + paramInt2);
    }
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
      this.jdField_i_of_type_Boolean = false;
      Message localMessage = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(11);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramObject;
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    this.jdField_i_of_type_Boolean = true;
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(paramInt);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "sendQbossRequest[what:" + paramInt + ",delay:" + paramLong + ",refreshType:" + paramString);
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.obj = paramString;
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(23, localMessage, paramLong, paramBoolean);
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    RecentUserProxy localRecentUserProxy;
    String str2;
    FriendsManager localFriendsManager;
    for (String str1 = "1";; str1 = "0")
    {
      localRecentUserProxy = a().getProxyManager().a();
      str2 = paramRecentBaseData.getRecentUserUin();
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (!QFileAssistantUtils.a(str2)) {
        break;
      }
      ((FileAssistTopHandler)a().getBusinessHandler(BusinessHandlerFactory.FILE_ASSIST_TOP)).a(paramBoolean);
      return;
    }
    if ((paramInt == 7000) && (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(str2)))
    {
      SubAccountControll.a(a(), str2, paramBoolean);
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str1, paramString, "");
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            a(paramInt, paramRecentBaseData, paramBoolean, str1, localRecentUserProxy);
            return;
            if (paramInt == 5000)
            {
              a(paramRecentBaseData, paramString, paramBoolean, str1);
            }
            else
            {
              if (paramInt != 5001) {
                break;
              }
              ((HotChatCenterManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a(paramBoolean);
            }
          }
          if (paramInt != 1) {
            break;
          }
        } while (!b(paramRecentBaseData, paramBoolean, localRecentUserProxy, str2));
        return;
        if ((paramInt != 0) || (!localFriendsManager.b(str2))) {
          break;
        }
      } while (!a(paramInt, paramBoolean, str2));
      return;
    } while (!a(paramRecentBaseData, paramBoolean, localRecentUserProxy, str2));
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
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2001;
        localMessage.getData().putString("troopUin", paramRecentUser.uin);
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(19, localMessage);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.getType());
      }
    } while ((paramInt & 0x4) == 0);
    RecentUtil.a(a(), paramRecentUser, -1);
    QQToast.a(a(), HardCodeUtil.a(2131702638), 0).a();
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
    int i2 = 0;
    if (!paramBoolean1)
    {
      M();
      c(800L);
    }
    Object localObject1 = a().getHandler(AVNotifyCenter.class);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((MqqHandler)localObject1).obtainMessage(10010);
      ((Message)localObject2).obj = Boolean.valueOf(paramBoolean1);
      ((MqqHandler)localObject1).sendMessage((Message)localObject2);
    }
    if (a().isMSFConnect) {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(11, 0, null);
    }
    boolean bool1;
    int i1;
    label112:
    boolean bool2;
    if (!paramBoolean1)
    {
      bool1 = true;
      LoadingStateManager.a().a(bool1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
      if (!bool1) {
        break label238;
      }
      i1 = 2;
      ((BannerManager)localObject1).a(1, i1, null);
      bool2 = LoadingStateManager.a().d();
      if ((!bool2) || (paramInt != 1134012)) {
        break label346;
      }
      bool2 = false;
    }
    label346:
    for (;;)
    {
      LoadingStateManager.a().b(bool2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
      i1 = i2;
      if (bool2) {
        i1 = 2;
      }
      ((BannerManager)localObject1).a(12, i1, null);
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
              label238:
              i1 = 0;
              break label112;
            }
          }
        }
      }
      d(bool1 | bool2 | paramBoolean2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder(150);
        ((StringBuilder)localObject1).append("refreshNetStatus").append(", app.isMSFConnect = ").append(a().isMSFConnect).append(", isNetSupport = ").append(paramBoolean1).append(", loadingState = ").append(LoadingStateManager.a().a()).append(", msg = ").append(paramInt);
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
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.b();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.b();
    }
    super.a(paramConfiguration);
  }
  
  void a(Message paramMessage, boolean paramBoolean)
  {
    if (paramMessage == null) {}
    for (int i1 = 0;; i1 = paramMessage.what)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder(150);
        paramMessage.append("refreshNetStatus").append(", app.isMSFConnect = ").append(a().isMSFConnect).append(", initLoadingHandle = ").append(paramBoolean).append(", loadingState = ").append(LoadingStateManager.a().a()).append(", what = ").append(i1);
        QLog.i("Q.recent", 2, paramMessage.toString());
      }
      if (!a().isMSFConnect) {
        break;
      }
      a(i1, true, paramBoolean);
      a(i1, true);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new Conversation.1(this, i1, paramBoolean));
  }
  
  public void a(View paramView, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onMsgTabRecommendBClick uin = " + paramString);
    }
    int i2 = paramView.getId();
    if ((paramString.equals("sp_uin_for_title")) && (i2 == 2131376750))
    {
      B();
      ContactReportUtils.a(a(), "msgtab_list_clk", 2);
      return;
    }
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramString, 102);
    boolean bool = localMayknowRecommendManager.a();
    ArrayList localArrayList = localMayknowRecommendManager.c();
    int i1 = 0;
    if (i1 < localArrayList.size())
    {
      paramView = (MayKnowRecommend)localArrayList.get(i1);
      if (!paramView.uin.equals(paramString)) {}
    }
    for (;;)
    {
      i1 -= b();
      if (paramView == null)
      {
        QLog.d("Q.recent", 1, "onMsgTabRecommendBClick recommend is null ");
        return;
        i1 += 1;
        break;
      }
      if (i2 == 2131376990)
      {
        if (!NetworkUtil.g(paramContext))
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131692257), 0).b(a().getTitleBarHeight());
          return;
        }
        paramString = (FriendsManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((!paramString.b(paramView.uin)) && (!paramString.d(paramView.uin)))
        {
          paramString = paramView.getDisplayName(localMayknowRecommendManager.a());
          paramContext = AddFriendLogicActivity.a(paramContext, 1, paramView.uin, null, 3045, 25, paramString, null, null, paramContext.getString(2131689557), null);
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(25), "", "", "");
          a(paramContext);
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
          ContactReportUtils.a(a(), paramView.uin, "frd_list_add", 25, 1, paramView.recommendReason, i1, paramView.algBuffer, 2);
          return;
          if (paramString.b(paramView.uin)) {
            paramView.friendStatus = 2;
          } else {
            paramView.friendStatus = 1;
          }
        }
      }
      paramString = paramView.getRecommendName(bool);
      if (!TextUtils.isEmpty(paramString)) {
        localAllInOne.l = paramString;
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        localAllInOne.jdField_h_of_type_JavaLangString = paramView.nick;
      }
      localAllInOne.jdField_h_of_type_Int = 88;
      paramString = new Bundle();
      paramString.putString("recommend_reason", paramView.recommendReason);
      paramString.putInt("recommend_pos", i1);
      paramString.putByteArray("recommend_algh_id", paramView.algBuffer);
      paramString.putInt("key_display_type", 2);
      ProfileActivity.a(paramContext, localAllInOne, paramString);
      ContactReportUtils.a(a(), paramView.uin, "frd_list_clk", 25, 0, paramView.recommendReason, i1, paramView.algBuffer, 2);
      return;
      i1 = 0;
      paramView = null;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_Boolean) || (a(paramView, paramRecentBaseData))) {
      return;
    }
    this.C = true;
    StartupTracker.a(null, "AIO_Click_cost");
    PAStartupTracker.a(null, "pubAcc_aio_open", "");
    ThreadPriorityManager.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "AIOTime onRecentBaseDataClick start");
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramView = ((RecentUserBaseData)paramRecentBaseData).a();
      b(paramRecentBaseData, paramView, paramRecentBaseData.mUnreadNum);
    }
    for (;;)
    {
      int i1 = RecentUtil.a(a(), a(), paramView, paramString, paramBoolean, 0, paramRecentBaseData);
      a(paramRecentBaseData, paramView, i1);
      a(i1, paramView);
      if (paramRecentBaseData != null)
      {
        RecentReportHelper.b(a(), paramRecentBaseData, paramView);
        paramRecentBaseData.clearUnReadNum();
        NotifyIdManager.a(a()).b(paramRecentBaseData.getRecentUserUin());
        this.jdField_i_of_type_Boolean = true;
      }
      StartupTracker.a("AIO_Click_cost", null);
      return;
      paramView = null;
    }
  }
  
  public void a(View paramView, Object paramObject)
  {
    StoryHaloManager localStoryHaloManager = (StoryHaloManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STORY_HALO_MANAGER);
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
      if (paramView.getId() == 2131363912)
      {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
        paramView = new Intent(a(), ForwardRecentActivity.class);
        paramView.putExtra("forward_type", 13);
        a(paramView);
        return;
      }
      if ((paramView.getId() == 2131367469) || (paramView.getId() == 2131367471) || (paramView.getId() == 2131367472) || (paramView.getId() == 2131367473) || (paramView.getId() == 2131367474) || (paramView.getId() == 2131367475) || (paramView.getId() == 2131367476))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "onItemClick uin: " + paramObject);
        }
        paramView = (String)paramObject;
        paramObject = ContactUtils.m(a(), paramView);
        ChatActivityUtils.a(a(), a(), 0, paramView, paramObject, null, true, null, true, true, null, null);
        return;
      }
    } while ((paramView.getId() != 2131369827) || (!localStoryHaloManager.b(paramObject)));
    localStoryHaloManager.a(paramView, (RecentItemChatMsgData)paramObject);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    Object localObject;
    if (this.jdField_e_of_type_Boolean)
    {
      paramString = null;
      int i1 = -1;
      if ((paramRecentBaseData instanceof RecentItemTempMsgBoxData)) {
        com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxUtil.jdField_a_of_type_Boolean = false;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        localObject = (RecentUserBaseData)paramRecentBaseData;
        paramString = ((RecentUserBaseData)localObject).a();
        i1 = ((RecentUserBaseData)localObject).mPosition;
      }
      if (paramString != null)
      {
        RecentReportHelper.a(a(), paramRecentBaseData, paramString);
        RecentUtil.a(a(), paramString, i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a(paramString);
      }
    }
    for (;;)
    {
      a(0L);
      return;
      localObject = (QCallFacade)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if ((localObject != null) && (paramRecentBaseData != null)) {}
      try
      {
        ((QCallFacade)localObject).b(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
        if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
          if (paramRecentBaseData.getRecentUserType() == 3000) {
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
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
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    N();
  }
  
  public void a(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if ((a().mAutomator != null) && (a().mAutomator.c()) && (paramVipGiftDownloadInfo != null) && (paramVipGiftDownloadInfo.jdField_d_of_type_Long == 0L) && (paramVipGiftDownloadInfo.jdField_a_of_type_Long != 0L)) {
      paramVipGiftManager.a(paramVipGiftDownloadInfo.jdField_a_of_type_Long);
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = a();
    int i1 = paramRecentBaseData.getRecentUserType();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption == null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption = new RecentTroopMenuOption(a(), (BaseActivity)a());
    }
    if (Utils.a(paramString1, localResources.getString(2131691339)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
      if (!Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[4]))) {
        break label411;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        RecentUtil.a(a(), paramString1.a(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
    }
    label411:
    while (!Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[5])))
    {
      return;
      if (Utils.a(paramString1, localResources.getString(2131691342)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        break;
      }
      if (Utils.a(paramString1, localResources.getString(2131693107)))
      {
        a(i1, paramRecentBaseData, paramString2, false);
        if (i1 != 3000) {
          break;
        }
        new ReportTask(a()).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").a();
        break;
      }
      if (Utils.a(paramString1, localResources.getString(2131693109)))
      {
        a(i1, paramRecentBaseData, paramString2, true);
        if (i1 != 3000) {
          break;
        }
        new ReportTask(a()).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").a();
        break;
      }
      if (!Utils.a(paramString1, localResources.getString(2131694370))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper.a(a(), paramRecentBaseData, a());
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", paramRecentBaseData.getRecentUserUin(), "0X800991D", "0X800991D", 0, 0, "", "", "", "");
      break;
    }
    if ((paramRecentBaseData instanceof RecentItemTempMsgBoxData)) {
      ((TempMsgBoxManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(false);
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
      a().getConversationFacade().a(paramString1.uin, paramString1.getType(), 1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
  }
  
  public void a(@androidx.annotation.NonNull List<RecentBaseData> paramList)
  {
    int i1 = 0;
    int i2 = 0;
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          break;
        }
        i3 = QCallFacade.a(a());
        if (!TripleGraySwitchUtil.a(this.jdField_a_of_type_MqqAppAppRuntime.getApp(), "KEY_USE_NEW_COUNT")) {
          break label197;
        }
        paramList = paramList.iterator();
        i1 = i2;
        if (!paramList.hasNext()) {
          break label225;
        }
        RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
        if ((localRecentBaseData == null) || (!localRecentBaseData.isUnreadMsgNumInTabNum()) || (RecentAdapter.a(a(), localRecentBaseData))) {
          break label222;
        }
        i1 = localRecentBaseData.getUnreadNum() + i1;
      }
      catch (Throwable paramList)
      {
        int i3;
        paramList.printStackTrace();
        return;
      }
      this.jdField_d_of_type_Int = (i2 + i3);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("fetchUnReadCount", 2, String.format("Conversation, mUnReadCount[%s], msgUnReadCount[%s], callUnReadCount[%s], isCallTabShow[%s],msgUnReadCountNew[%s]", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(a().isCallTabShow), Integer.valueOf(i1) }));
      return;
      label197:
      paramList = a().getMessageFacade();
      if (paramList != null)
      {
        i2 = paramList.b();
      }
      else
      {
        i2 = 0;
        continue;
        label222:
        continue;
        label225:
        i2 = i1;
      }
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.springBackOverScrollHeaderView();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(a());
    }
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(24, 0, null);
    RecentDataListManager.a().a();
    TianShuManager.getInstance().clearNecessaryDataCacheForReport();
    TianShuManager.setLastClickAdTraceInfo("", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a(paramLogoutReason);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(paramLogoutReason);
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
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_h_of_type_Boolean)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      label193:
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1073);
      return;
    }
    catch (Exception paramLogoutReason)
    {
      break label193;
    }
  }
  
  /* Error */
  protected void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 617	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 526
    //   9: iconst_2
    //   10: new 528	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 529	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 3698
    //   20: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 538	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 542	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 545	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 584	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   37: ifnull +21 -> 58
    //   40: aload_0
    //   41: getfield 584	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   44: invokevirtual 3701	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   47: ifge +11 -> 58
    //   50: aload_0
    //   51: getfield 584	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   54: iconst_0
    //   55: invokevirtual 3704	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   58: aload_0
    //   59: iconst_0
    //   60: invokespecial 3706	com/tencent/mobileqq/activity/home/Conversation:j	(Z)V
    //   63: iload_1
    //   64: ifeq +470 -> 534
    //   67: invokestatic 738	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   70: invokevirtual 3707	com/tencent/mobileqq/managers/LoadingStateManager:a	()V
    //   73: invokestatic 948	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentDataListManager;
    //   76: invokevirtual 3685	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()V
    //   79: invokestatic 3688	cooperation/vip/tianshu/TianShuManager:getInstance	()Lcooperation/vip/tianshu/TianShuManager;
    //   82: invokevirtual 3691	cooperation/vip/tianshu/TianShuManager:clearNecessaryDataCacheForReport	()V
    //   85: ldc_w 656
    //   88: ldc_w 656
    //   91: invokestatic 1641	cooperation/vip/tianshu/TianShuManager:setLastClickAdTraceInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 179	com/tencent/mobileqq/activity/home/Conversation:jdField_g_of_type_Boolean	Z
    //   98: ifeq +22 -> 120
    //   101: aload_0
    //   102: getfield 584	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   105: ifnull +15 -> 120
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 179	com/tencent/mobileqq/activity/home/Conversation:jdField_g_of_type_Boolean	Z
    //   113: aload_0
    //   114: getfield 584	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   117: invokevirtual 3710	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   120: aload_0
    //   121: getfield 756	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   124: ifnull +15 -> 139
    //   127: aload_0
    //   128: getfield 756	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   131: invokevirtual 3711	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 756	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   139: aload_0
    //   140: getfield 772	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   143: ifnull +15 -> 158
    //   146: aload_0
    //   147: getfield 772	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   150: invokevirtual 780	android/app/Dialog:dismiss	()V
    //   153: aload_0
    //   154: aconst_null
    //   155: putfield 772	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   158: aload_0
    //   159: getfield 2570	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper	Lcom/tencent/mobileqq/activity/recent/ConversationHelper;
    //   162: ifnull +14 -> 176
    //   165: aload_0
    //   166: getfield 2570	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper	Lcom/tencent/mobileqq/activity/recent/ConversationHelper;
    //   169: aload_0
    //   170: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   173: invokevirtual 3714	com/tencent/mobileqq/activity/recent/ConversationHelper:a	(Lcom/tencent/common/app/business/BaseQQAppInterface;)V
    //   176: aload_0
    //   177: getfield 929	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant	Lcom/tencent/mobileqq/activity/contacts/base/SearchBarAssistant;
    //   180: ifnull +14 -> 194
    //   183: aload_0
    //   184: getfield 929	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant	Lcom/tencent/mobileqq/activity/contacts/base/SearchBarAssistant;
    //   187: aload_0
    //   188: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   191: invokevirtual 3715	com/tencent/mobileqq/activity/contacts/base/SearchBarAssistant:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   194: aload_0
    //   195: getfield 1884	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   198: ifnull +14 -> 212
    //   201: aload_0
    //   202: getfield 1884	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   205: aload_0
    //   206: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   209: invokevirtual 3716	com/tencent/mobileqq/activity/recent/RecentTroopMenuOption:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   212: aload_0
    //   213: getfield 547	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   216: ifnull +25 -> 241
    //   219: aload_0
    //   220: getfield 547	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   223: aload_0
    //   224: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   227: invokevirtual 3717	com/tencent/mobileqq/activity/recent/RecentAdapter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   230: aload_0
    //   231: iconst_1
    //   232: bipush 10
    //   234: lconst_0
    //   235: invokestatic 568	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   238: invokevirtual 571	com/tencent/mobileqq/activity/home/Conversation:a	(IILjava/lang/Object;)V
    //   241: aload_0
    //   242: getfield 584	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   245: ifnull +11 -> 256
    //   248: aload_0
    //   249: getfield 584	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   252: iconst_0
    //   253: invokevirtual 3720	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   256: aload_0
    //   257: iconst_0
    //   258: invokespecial 1818	com/tencent/mobileqq/activity/home/Conversation:i	(Z)V
    //   261: aload_0
    //   262: getfield 2150	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager	Lcom/tencent/biz/qqstory/msgTabNode/view/MsgTabStoryNodeListManager;
    //   265: ifnull +14 -> 279
    //   268: aload_0
    //   269: getfield 2150	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager	Lcom/tencent/biz/qqstory/msgTabNode/view/MsgTabStoryNodeListManager;
    //   272: aload_0
    //   273: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   276: invokevirtual 3721	com/tencent/biz/qqstory/msgTabNode/view/MsgTabStoryNodeListManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   279: aload_0
    //   280: getfield 1279	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   283: ifnull +16 -> 299
    //   286: aload_0
    //   287: getfield 1279	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   290: aload_0
    //   291: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   294: invokeinterface 3725 2 0
    //   299: aload_0
    //   300: getfield 588	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_CooperationVipAdTianshuAdManager	Lcooperation/vip/ad/TianshuAdManager;
    //   303: ifnull +14 -> 317
    //   306: aload_0
    //   307: getfield 588	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_CooperationVipAdTianshuAdManager	Lcooperation/vip/ad/TianshuAdManager;
    //   310: aload_0
    //   311: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   314: invokevirtual 3726	cooperation/vip/ad/TianshuAdManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   317: aload_0
    //   318: getfield 1975	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_CooperationVipAdTianshuSplashManager	Lcooperation/vip/ad/TianshuSplashManager;
    //   321: ifnull +14 -> 335
    //   324: aload_0
    //   325: getfield 1975	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_CooperationVipAdTianshuSplashManager	Lcooperation/vip/ad/TianshuSplashManager;
    //   328: aload_0
    //   329: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   332: invokevirtual 3727	cooperation/vip/ad/TianshuSplashManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   335: aload_0
    //   336: getfield 217	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback	Lcom/tencent/mobileqq/activity/springfestival/entry/SpringFestivalTaskCallback;
    //   339: ifnull +14 -> 353
    //   342: aload_0
    //   343: getfield 217	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback	Lcom/tencent/mobileqq/activity/springfestival/entry/SpringFestivalTaskCallback;
    //   346: aload_0
    //   347: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   350: invokevirtual 3728	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalTaskCallback:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   353: ldc_w 526
    //   356: ldc_w 3730
    //   359: aload_0
    //   360: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   363: getfield 1153	com/tencent/mobileqq/app/QQAppInterface:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   366: invokevirtual 1156	com/tencent/mobileqq/app/automator/Automator:b	()Z
    //   369: invokestatic 1206	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   372: invokestatic 3735	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   375: aload_0
    //   376: sipush 1055
    //   379: lconst_0
    //   380: iconst_0
    //   381: invokevirtual 769	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   384: aload_0
    //   385: getfield 941	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqBannerBannerManager	Lcom/tencent/mobileqq/banner/BannerManager;
    //   388: ifnull +10 -> 398
    //   391: aload_0
    //   392: getfield 941	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqBannerBannerManager	Lcom/tencent/mobileqq/banner/BannerManager;
    //   395: invokevirtual 3736	com/tencent/mobileqq/banner/BannerManager:a	()V
    //   398: aload_0
    //   399: getfield 198	com/tencent/mobileqq/activity/home/Conversation:jdField_j_of_type_Boolean	Z
    //   402: ifeq +13 -> 415
    //   405: aload_0
    //   406: getfield 1215	com/tencent/mobileqq/activity/home/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   409: bipush 12
    //   411: invokevirtual 562	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   414: pop
    //   415: aload_0
    //   416: getfield 799	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   419: getfield 1019	com/tencent/mobileqq/app/FrameHelperActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   422: iconst_4
    //   423: invokevirtual 2703	android/os/Handler:sendEmptyMessage	(I)Z
    //   426: pop
    //   427: aload_0
    //   428: sipush 1035
    //   431: ldc2_w 2815
    //   434: iconst_0
    //   435: invokevirtual 769	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   438: aload_0
    //   439: getfield 941	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqBannerBannerManager	Lcom/tencent/mobileqq/banner/BannerManager;
    //   442: ifnull +19 -> 461
    //   445: aload_0
    //   446: getfield 941	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqBannerBannerManager	Lcom/tencent/mobileqq/banner/BannerManager;
    //   449: bipush 24
    //   451: sipush 2000
    //   454: ldc2_w 2815
    //   457: iconst_1
    //   458: invokevirtual 1319	com/tencent/mobileqq/banner/BannerManager:a	(IIJZ)V
    //   461: aload_0
    //   462: sipush 3001
    //   465: lconst_0
    //   466: iconst_1
    //   467: aconst_null
    //   468: invokevirtual 1255	com/tencent/mobileqq/activity/home/Conversation:a	(IJZLjava/lang/String;)V
    //   471: aload_0
    //   472: sipush 3002
    //   475: ldc2_w 2815
    //   478: iconst_1
    //   479: ldc_w 3738
    //   482: invokevirtual 1255	com/tencent/mobileqq/activity/home/Conversation:a	(IJZLjava/lang/String;)V
    //   485: aload_0
    //   486: sipush 500
    //   489: ldc_w 3740
    //   492: iconst_1
    //   493: invokespecial 1260	com/tencent/mobileqq/activity/home/Conversation:a	(ILjava/lang/String;Z)V
    //   496: aload_0
    //   497: sipush 500
    //   500: ldc_w 3742
    //   503: invokespecial 1265	com/tencent/mobileqq/activity/home/Conversation:a	(ILjava/lang/String;)V
    //   506: aload_0
    //   507: aload_0
    //   508: getfield 652	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   511: getstatic 3745	com/tencent/mobileqq/app/QQManagerFactory:VIP_GIF_MANAGER	I
    //   514: invokevirtual 1127	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   517: checkcast 2203	com/tencent/mobileqq/vipgift/VipGiftManager
    //   520: putfield 210	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager	Lcom/tencent/mobileqq/vipgift/VipGiftManager;
    //   523: aload_0
    //   524: invokespecial 3747	com/tencent/mobileqq/activity/home/Conversation:ay	()V
    //   527: aload_0
    //   528: ldc_w 3749
    //   531: invokespecial 1048	com/tencent/mobileqq/activity/home/Conversation:c	(Ljava/lang/String;)V
    //   534: aload_0
    //   535: sipush 10001
    //   538: ldc2_w 3750
    //   541: iconst_0
    //   542: invokevirtual 769	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   545: aload_0
    //   546: getfield 652	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   549: invokevirtual 3007	mqq/app/AppRuntime:isLogin	()Z
    //   552: ifne +15 -> 567
    //   555: aload_0
    //   556: getfield 198	com/tencent/mobileqq/activity/home/Conversation:jdField_j_of_type_Boolean	Z
    //   559: ifeq +8 -> 567
    //   562: aload_0
    //   563: lconst_0
    //   564: invokevirtual 1973	com/tencent/mobileqq/activity/home/Conversation:a	(J)V
    //   567: aload_0
    //   568: ldc_w 3752
    //   571: ldc2_w 1315
    //   574: iconst_0
    //   575: invokevirtual 769	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   578: ldc_w 2302
    //   581: invokestatic 1287	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   584: checkcast 2302	com/tencent/biz/pubaccount/api/IPublicAccountManager
    //   587: aload_0
    //   588: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   591: invokevirtual 1322	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   594: invokeinterface 3755 2 0
    //   599: getstatic 3758	com/tencent/mobileqq/msgbackup/controller/MsgBackupManager:jdField_g_of_type_Boolean	Z
    //   602: ifeq +13 -> 615
    //   605: invokestatic 3761	com/tencent/mobileqq/msgbackup/controller/MsgBackupManager:a	()Lcom/tencent/mobileqq/msgbackup/controller/MsgBackupManager;
    //   608: aload_0
    //   609: invokevirtual 593	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   612: invokevirtual 3762	com/tencent/mobileqq/msgbackup/controller/MsgBackupManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   615: iload_1
    //   616: ifeq +7 -> 623
    //   619: aload_0
    //   620: invokespecial 2705	com/tencent/mobileqq/activity/home/Conversation:R	()V
    //   623: return
    //   624: astore_2
    //   625: aload_0
    //   626: aconst_null
    //   627: putfield 756	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   630: goto -491 -> 139
    //   633: astore_2
    //   634: aload_0
    //   635: aconst_null
    //   636: putfield 756	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   639: aload_2
    //   640: athrow
    //   641: astore_2
    //   642: aload_0
    //   643: aconst_null
    //   644: putfield 772	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   647: goto -489 -> 158
    //   650: astore_2
    //   651: aload_0
    //   652: aconst_null
    //   653: putfield 772	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   656: aload_2
    //   657: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	658	0	this	Conversation
    //   0	658	1	paramBoolean	boolean
    //   624	1	2	localException1	Exception
    //   633	7	2	localObject1	Object
    //   641	1	2	localException2	Exception
    //   650	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   127	134	624	java/lang/Exception
    //   127	134	633	finally
    //   146	153	641	java/lang/Exception
    //   146	153	650	finally
  }
  
  protected boolean a(Message paramMessage)
  {
    boolean bool = Foreground.isCurrentProcessForeground();
    if ((paramMessage.arg1 == 4) && (e())) {}
    while (((this.jdField_f_of_type_Boolean) || (paramMessage.arg1 != 0)) && (this.jdField_a_of_type_MqqAppAppRuntime.isLogin()) && (bool)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "isRefreshRecentDataNecessary[isForeground:", Boolean.valueOf(this.jdField_f_of_type_Boolean), ",msg.arg1:", Integer.valueOf(paramMessage.arg1), " msg.arg2", Integer.valueOf(paramMessage.arg2), ",isLogin:", Boolean.valueOf(this.jdField_a_of_type_MqqAppAppRuntime.isLogin()), " ,isProcessForeground=", Boolean.valueOf(bool) });
    }
    return false;
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
    } while ((paramVipGiftDownloadInfo == null) || (paramVipGiftDownloadInfo.jdField_d_of_type_Long != 2L) || (!a().mAutomator.c()) || (!this.w));
    return true;
  }
  
  public boolean a(ListView paramListView)
  {
    if ((paramListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) || (this.jdField_g_of_type_Boolean)) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    }
    if (!a().getMsgHandler().d()) {}
    for (int i1 = 1;; i1 = 0)
    {
      paramListView = (SpringFestivalEntryManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      int i2 = i1;
      if (paramListView != null)
      {
        i2 = i1;
        if (paramListView.d())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "handlePullRefresh fakeRefresh for 2021HB");
          }
          i2 = 1;
        }
      }
      if (i2 != 0)
      {
        this.jdField_g_of_type_Boolean = true;
        d(true);
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(40001, 500L);
        return true;
      }
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      StartupTracker.a("Conversation_PullToRefresh_start", 0L);
      p();
      ThreadManager.getSubThreadHandler().post(new Conversation.10(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "subaccount onViewCompleteVisableAndReleased ");
      }
      if (((MsgTabStoryNodeConfigManager)a().getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).jdField_a_of_type_Boolean)
      {
        ((MsgTabStoryManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a().a(2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "MsgTabNodeListLoader update data");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.handlePullRefresh();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1054);
      a(3002, 200L, true, "qboss_banner_pull_refresh");
      a(1072, 500L, true);
      a(500, "tianshu_req_splash_type_pull_down", true);
      a(500, "tianshu_req_renewals_type_pull_down");
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("MedalWallMng", 4, "send MSG_CHECK_MEDAL_GUIDE");
      return true;
    }
  }
  
  public String a_()
  {
    String str = HardCodeUtil.a(2131702639);
    if (this.jdField_d_of_type_Int <= 0) {
      return str;
    }
    if (this.jdField_d_of_type_Int > 99) {
      return str + "(99+)";
    }
    return str + "(" + this.jdField_d_of_type_Int + ")";
  }
  
  int b()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1) instanceof RecentItemMayKnowFriendVerticalListData)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "conversation onPostThemeChanged");
    }
    if ((!ThemeUtil.isDefaultTheme()) && (this.B) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850756);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131366452).setBackgroundResource(2130850768);
      this.B = false;
    }
    y();
    an();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.l();
    }
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("ThemeChanged");
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.p();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)localIterator.next();
        if (localConversationPullDownActiveBase != null) {
          localConversationPullDownActiveBase.i();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar.e();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.i();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onPostThemeChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(-1, null);
    }
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "conversation onPostThemeChanged refresh because simple theme switch!");
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(10);
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.u();
    }
  }
  
  protected void b(long paramLong)
  {
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramLong);
    }
  }
  
  protected void b(List<RecentBaseData> paramList)
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
        if ((localRecentBaseData != null) && (localRecentBaseData.mUnreadNum > 0)) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentBaseData.getRecentUserType()).append("-").append(localRecentBaseData.getRecentUserUin()).append("-").append(localRecentBaseData.mUnreadNum).append("-").append(localRecentBaseData.mUnreadFlag).append(" , ");
        }
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append("]");
    localArrayList.clear();
    QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d("Q.recent", 2, "onResume...");
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    this.C = false;
    a().isConversationTabShow = true;
    this.jdField_f_of_type_Boolean = true;
    this.x = paramBoolean;
    MayknowRecommendManager.jdField_e_of_type_Boolean = true;
    af();
    super.b(paramBoolean);
    if (AppSetting.jdField_d_of_type_Boolean) {
      a().setTitle(a(2131693919));
    }
    Z();
    TimeManager.a().c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant.a();
    }
    if (AppSetting.jdField_i_of_type_Boolean) {
      a().setMainActivityState(true);
    }
    try
    {
      a().getWindow().setSoftInputMode(32);
      ArkTipsManager.a().c();
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_j_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Long != 1000L) {
          this.jdField_a_of_type_Long = 1000L;
        }
        if (!this.k) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
        }
        if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
        }
        a(0L);
        j();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
        ah();
        ai();
        am();
        ax();
        ae();
        al();
        aj();
        ag();
        f();
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
        a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
        ImaxAdRecentUserManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).setHasPreloadWebProcessor(false);
        aa();
        k(paramBoolean);
        ApngImage.playByTag(2);
        ad();
        an();
        ac();
        ab();
        DarkModeManager.a(null);
        l(paramBoolean);
        UpComingMsgUtil.a((BaseActivity)a(), paramBoolean);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.recent", 1, localException, new Object[0]);
        continue;
        if (!this.A)
        {
          this.A = true;
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1067, 1000L);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1025, 3000L);
      }
    }
  }
  
  public boolean b()
  {
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.w();
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.c())) {
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_PORTAL);
      if (localPortalManager != null) {
        localPortalManager.a(a(), false);
      }
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.isMiniAppLauncherOpened()))
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.hideMiniAppEntry(0);
      return true;
    }
    return false;
  }
  
  public View c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_c_of_type_AndroidViewView;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "refreshStatusBarUIByTheme");
    }
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, true);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    for (;;)
    {
      SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850507);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167030));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167030));
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "updateLoadingState, showLoadingCircle = " + paramBoolean);
    }
    if (paramBoolean) {
      try
      {
        Drawable localDrawable = a().getResources().getDrawable(2130839547);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(5.0F, a()));
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, localDrawable, null);
        if ((localDrawable instanceof Animatable)) {
          ((Animatable)localDrawable).start();
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("LoadingComplete");
  }
  
  public boolean c()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void d()
  {
    Y();
    w();
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(a());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.g();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)((Iterator)localObject).next();
        if (localConversationPullDownActiveBase != null) {
          localConversationPullDownActiveBase.b();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134065);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134061);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134068);
    QZoneReport.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper.a(a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.c();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl;
    if (localObject != null) {
      ((ConversationQbossBannerTitleEntranceCtrl)localObject).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar.a((BaseActivity)a());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(1);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(12);
    if (paramBoolean)
    {
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(4);
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(3);
    }
    if ((bool1) || (bool2))
    {
      c(false);
      return;
    }
    switch (LoadingStateManager.a().a())
    {
    default: 
      return;
    }
    for (;;)
    {
      c(false);
      return;
      c(true);
      if (this.jdField_c_of_type_MqqOsMqqHandler.hasMessages(4)) {
        break;
      }
      this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(4, 180000L);
      return;
      c(true);
      if (this.jdField_c_of_type_MqqOsMqqHandler.hasMessages(3)) {
        break;
      }
      this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 180000L);
      return;
      c(false);
    }
  }
  
  protected boolean d()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1);
  }
  
  public void e(boolean paramBoolean)
  {
    a(true);
    this.D = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      if (this.jdField_f_of_type_Boolean)
      {
        this.E = true;
        az();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.d();
    }
  }
  
  public void f()
  {
    StartupTracker.a(null, "Recent_OnCreate");
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a((BaseActivity)a());
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl = new ConversationHotChatCtrl(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack);
    this.jdField_b_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getRecentThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper = new RecentPubAccHelper(this.jdField_a_of_type_MqqOsMqqHandler, a());
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl = new ConversationTitleBtnCtrl(this);
    P();
    O();
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper = new ConversationHelper(a());
    StartupTracker.a("Recent_OnCreate", null);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.c(paramBoolean);
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "clearStatusBarBg");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.initLater(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
    }
  }
  
  public void h()
  {
    super.h();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null) {
      this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
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
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onStop();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "notifyCallTabChanged, changed=" + paramBoolean);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((this.jdField_h_of_type_Boolean) || (a() == null) || (a().isFinishing())) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "handleMessage, msg.what=", Integer.valueOf(paramMessage.what) });
    }
    TraceUtils.traceBegin("conv.handleMessage");
    long l1 = System.currentTimeMillis();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      TraceUtils.traceEnd();
      return true;
      c(paramMessage, l1);
      continue;
      b(paramMessage, l1);
      continue;
      a(paramMessage, l1);
      continue;
      c(paramMessage);
      continue;
      as();
      continue;
      j(true);
      continue;
      ar();
      continue;
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1044, 0, 0, null).sendToTarget();
      continue;
      paramMessage = (StoryHaloManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STORY_HALO_MANAGER);
      paramMessage.a(2, paramMessage.a(RecentDataListManager.a().jdField_a_of_type_JavaUtilList));
      continue;
      aq();
    }
  }
  
  public void i()
  {
    if (SystemClock.uptimeMillis() - MsgTabStoryNodeListManager.jdField_b_of_type_Long > 500L)
    {
      K();
      if ((this.w) && ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView instanceof HongBaoListView)) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mEnableStory) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mForStory))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.h();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.hideMiniAppEntry(-1);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onFrameTabClick|mIsChatList:" + this.jdField_e_of_type_Boolean);
    }
  }
  
  protected void j()
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
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onDestroy");
    }
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper.a();
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.a(null);
    }
    this.p = false;
    TimeManager.a().a();
    Y();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a();
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar.h();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(null);
    }
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    try
    {
      localObject = a().getProxyManager().a();
      if (localObject != null) {
        ((RecentUserProxy)localObject).b();
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label254:
      break label254;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_c_of_type_MqqOsMqqHandler != null) {
      this.jdField_c_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    TroopAssistantManager.a();
    TroopRemindSettingManager.a();
    TroopBarAssistantManager.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.d();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)((Iterator)localObject).next();
        if (localConversationPullDownActiveBase != null) {
          localConversationPullDownActiveBase.g();
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.f();
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper = null;
    }
    ap();
    if (this.jdField_e_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.g();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.onDestroy();
    }
    super.k();
  }
  
  public void m()
  {
    a(1068, 0L, true);
  }
  
  public void n()
  {
    QLog.d("Q.recent", 2, "onPause...");
    ApngImage.pauseByTag(2);
    super.n();
    this.jdField_f_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.l();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.c();
    }
    if (jdField_b_of_type_Long > 0L)
    {
      jdField_b_of_type_Long = 0L;
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).setResumeFlagFromConversation(jdField_b_of_type_Long);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).saveNormalEnterConversationTime(jdField_b_of_type_Long);
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConversationPullDownActiveBase)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ConversationPullDownActiveBase)localObject2).e();
        }
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1053);
    this.J = false;
    com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxUtil.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    if (AppSetting.jdField_i_of_type_Boolean) {
      a().setMainActivityState(false);
    }
    TimeManager.a().b();
    if ((!this.C) && (!this.D) && (RecentParcelUtil.a(a()))) {
      if (System.currentTimeMillis() - this.jdField_h_of_type_Long > 5000L)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
        localObject2 = a();
        ThreadManager.getSubThreadHandler().post(new Conversation.2(this, (QQAppInterface)localObject2, (List)localObject1));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.hideCurShowingRightView();
        }
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10000);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1070);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.j();
      }
      a().isConversationTabShow = false;
      ReadInJoyUtils.c(a());
      if (this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null) {
        this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
      }
      if (this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession != null) {
        this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
      QZoneReport.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.l();
      }
      ReadinjoySPEventReport.k();
      PublicAccountEventReport.a();
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "just switch account, don't save RU");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "enter AIO or switching account, don't save RU");
        }
      }
    }
  }
  
  public void o()
  {
    a(1069, 0L, true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getWidth() - a().getDimensionPixelSize(2131298893) - a().getDimensionPixelSize(2131298894), a().getDimensionPixelSize(2131298895));
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity instanceof MainFragment))) {
        ((MainFragment)this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity).l();
      }
      if ((CmGameUtil.c() <= 0) || (CmGameUtil.b() <= 0)) {
        break label333;
      }
    }
    label333:
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = false;
      }
      for (int i2 = 1;; i2 = 0)
      {
        VipUtils.a(CmGameUtil.a(), "cmshow", "Apollo", "plusentrance", 0, 0, new String[] { "" + i1, "" + i2 });
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
        StoryReportor.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
        ay();
        SafeModeUtil.e();
        this.C = true;
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if ((paramView == this.jdField_b_of_type_AndroidWidgetImageView) || (paramView == this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch))
          {
            long l1 = System.currentTimeMillis();
            if (Math.abs(l1 - jdField_i_of_type_Long) < 500L) {
              jdField_i_of_type_Long = l1;
            } else {
              jdField_i_of_type_Long = l1;
            }
          }
        }
      }
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null))
    {
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.ah_();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void onRightIconMenuHide(View paramView) {}
  
  public void onRightIconMenuShow(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramView);
      if ((localRecentBaseData != null) && ("9970".equals(localRecentBaseData.getRecentUserUin()))) {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
      }
    } while ((localRecentBaseData == null) || (!AppConstants.SERVICE_ACCOUNT_FOLDER_UIN.equals(localRecentBaseData.getRecentUserUin())));
    int i1;
    if (localRecentBaseData.mUnreadFlag == 2)
    {
      i1 = 1;
      if (localRecentBaseData.mUnreadFlag != 1) {
        break label168;
      }
    }
    label168:
    for (int i2 = localRecentBaseData.mUnreadNum;; i2 = 0)
    {
      int i3 = -1;
      if ((paramView.getTag(-1) instanceof Integer)) {
        i3 = ((Integer)paramView.getTag(-1)).intValue() + 1;
      }
      ThreadManager.executeOnSubThread(new Conversation.6(this, i1, i2, i3));
      return;
      i1 = 0;
      break;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (this.jdField_i_of_type_Int != paramInt1)
    {
      long l1 = SystemClock.elapsedRealtime();
      double d1 = 1000.0D * (1.0D / (l1 - this.jdField_g_of_type_Long));
      if (paramInt1 > this.jdField_i_of_type_Int)
      {
        bool = true;
        this.z = bool;
        this.jdField_i_of_type_Int = paramInt1;
        this.jdField_g_of_type_Long = l1;
        if (QLog.isDebugVersion()) {
          QLog.d(RecentDataListManager.jdField_a_of_type_JavaLangString, 2, "onScroll:" + d1 + " for Direction:" + this.z);
        }
        if (d1 > 25.0D) {
          break label328;
        }
        av();
      }
    }
    else
    {
      label117:
      if (paramInt1 + paramInt2 == paramInt3)
      {
        paramInt3 = ((ListView)paramAbsListView).getHeaderViewsCount();
        if (paramInt1 > paramInt3) {
          break label338;
        }
        paramInt3 = paramAbsListView.getChildAt(paramInt3 - paramInt1).getTop();
        paramInt2 = paramAbsListView.getChildAt(paramInt2 - 2).getBottom();
      }
    }
    label328:
    label338:
    for (paramInt2 = Math.max(0, paramInt3 + (paramAbsListView.getHeight() - paramInt2));; paramInt2 = 0)
    {
      paramAbsListView = (AbsListView.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      if ((paramAbsListView != null) && (paramAbsListView.height != paramInt2))
      {
        paramAbsListView.height = paramInt2;
        this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramAbsListView);
      }
      if (paramInt1 == 0)
      {
        this.I = false;
        this.jdField_j_of_type_Long = -1L;
      }
      if ((this.I) && (SystemClock.elapsedRealtime() - this.jdField_j_of_type_Long > 800L))
      {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
        if (QLog.isColorLevel()) {
          QLog.d("Conversation", 2, "onScroll cost time is below 1000 ms, isScroll2TopFlag: " + this.I + ", startScrollTime: " + this.jdField_j_of_type_Long);
        }
        this.I = false;
        this.jdField_j_of_type_Long = -1L;
      }
      return;
      bool = false;
      break;
      DynamicFaceDrawable.a(a());
      break label117;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Conversation", 2, "onScrollStateChanged:" + paramInt);
    }
    boolean bool;
    label84:
    int i1;
    label180:
    Object localObject;
    if (AppSetting.k)
    {
      if (paramInt != 0)
      {
        bool = true;
        ThreadPriorityManager.a(bool);
      }
    }
    else
    {
      if ((paramAbsListView instanceof ARMapHongBaoListView)) {
        ((ARMapHongBaoListView)paramAbsListView).setScrollState(paramInt);
      }
      if (paramInt == 0) {
        break label230;
      }
      this.G = true;
      ApngImage.pauseByTag(2);
      this.jdField_a_of_type_Int = paramInt;
      if (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) {
        break label343;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.b(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1)) {
        break label443;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {
        break label278;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
      int i4 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount();
      this.jdField_b_of_type_Int = Math.max(i1, -1);
      if ((i1 < 0) || (i1 >= i4) || (i1 > i2 - i3)) {
        break label266;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
      if ((localObject instanceof RecentBaseData)) {
        break label238;
      }
    }
    label230:
    label238:
    do
    {
      i1 += 1;
      break label180;
      bool = false;
      break;
      this.G = false;
      break label84;
      localObject = (RecentBaseData)localObject;
    } while ((!((RecentBaseData)localObject).isUnreadMsgNumInTabNum()) || (((RecentBaseData)localObject).getUnreadNum() <= 0));
    this.jdField_b_of_type_Int = i1;
    label266:
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
    ThreadPriorityManager.a(false);
    label278:
    if (paramInt == 0)
    {
      av();
      DropFrameMonitor.a().a("list_conv", false);
      ThreadRegulator.a().b(2);
      a(paramAbsListView);
      ImaxAdRecentUserManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      m(false);
      ao();
      z();
      x();
    }
    for (;;)
    {
      label343:
      if ((!this.G) && (this.H))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Conversation", 2, "onScrollStateChanged call with msg incoming");
        }
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(10);
        this.H = false;
      }
      if (paramInt == 0)
      {
        if (this.jdField_i_of_type_Boolean) {
          a(100L);
        }
        ApngImage.playByTag(2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(this.G);
      }
      ReadinjoySPEventReport.ScrollReport.a(paramAbsListView, paramInt);
      PublicAccountEventReport.a(a(), paramAbsListView, paramInt);
      return;
      label443:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
      ThreadPriorityManager.a(true);
      break;
      DropFrameMonitor.a().a("list_conv");
      ThreadRegulator.a().a(2);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onViewCompleteVisableAndReleased %s", new Object[] { Boolean.valueOf(this.jdField_g_of_type_Boolean) }));
    }
    return a(paramListView);
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void p()
  {
    if (a().getCurrentAccountUin() != null)
    {
      if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1058);
      }
      this.jdField_g_of_type_Boolean = true;
      M();
      d(true);
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(1);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(12);
      if ((bool1) || (bool2)) {
        c(800L);
      }
    }
    else
    {
      return;
    }
    if (ReadInJoyHelper.p(this.jdField_a_of_type_MqqAppAppRuntime)) {
      ReadinjoySPEventReport.a().a();
    }
    a().mAutomator.c();
    c(60000L);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
  }
  
  public void q()
  {
    if ((!this.jdField_j_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      F();
      StartupTracker.a("Recent_Start", null);
    }
    while (!this.jdField_j_of_type_Boolean) {
      return;
    }
    a(1030, 0L, true);
  }
  
  public void r()
  {
    this.jdField_f_of_type_Boolean = true;
    if (SetSplash.c())
    {
      a(new Conversation.15(this));
      return;
    }
    q();
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.b(false);
    }
    ConversationQbossBannerTitleEntranceCtrl localConversationQbossBannerTitleEntranceCtrl = this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl;
    if (localConversationQbossBannerTitleEntranceCtrl != null) {
      localConversationQbossBannerTitleEntranceCtrl.b(false);
    }
  }
  
  public void t()
  {
    long l1 = 0L;
    try
    {
      if (!this.l)
      {
        boolean bool = this.jdField_h_of_type_Boolean;
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559765, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar = new RecentOptPopBar(localBaseActivity);
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe((BaseActivity)a(), a(), this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new Conversation.20(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = ((VipGiftManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.VIP_GIF_MANAGER));
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label357;
        }
      }
      localObject1 = finally;
    }
    return;
    this.l = true;
    localBaseActivity = (BaseActivity)a();
    localLayoutInflater = LayoutInflater.from(localBaseActivity);
    Object localObject2 = "in main thread ";
    label215:
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, (String)localObject2 + localException2.toString());
    }
    for (;;)
    {
      try
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("device_mode", DeviceInfoUtil.d());
        ((HashMap)localObject2).put("manufacturer", Build.MANUFACTURER);
        StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
        String str2 = a().getCurrentAccountUin();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label385;
        }
        localStatisticCollector.collectPerformance(str2, "actConSubInflate", false, l1, 0L, (HashMap)localObject2, "");
      }
      catch (Exception localException1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent", 2, localException1.toString());
      break;
      label357:
      String str1 = "not in main thread ";
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar = null;
      this.l = false;
      break label215;
      label385:
      l1 = 1L;
    }
  }
  
  public void u()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_SHOT_FIRST_GUIDE_TIP"))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((i1 == 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((RelativeLayout)a(2131377356)).removeView(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_AndroidWidgetTextView = null;
      }
      return;
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
  
  void v()
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (!this.jdField_j_of_type_Boolean)) {}
    label133:
    for (;;)
    {
      return;
      if (((EcShopAssistantManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).b())
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
          if ((i1 == 0) || (!((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).preloadWebProcess(a())) || (this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession == null)) {
            break label133;
          }
          this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession.a();
          return;
          i1 += 1;
          break;
        }
      }
    }
  }
  
  void w()
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  void x()
  {
    if ((this.p) && (((MayknowRecommendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b("sp_mayknow_ml_s_a_vl")) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.isShown()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.isEmpty()))
    {
      int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
      int i5 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i4;
      for (int i1 = -1; i3 <= i5; i1 = i4)
      {
        i4 = i1;
        if (i3 >= 0)
        {
          i4 = i1;
          if (i3 < this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount())
          {
            i4 = i1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i3) != null)
            {
              Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i3);
              i4 = i1;
              if ((localObject instanceof RecentItemMayKnowFriendVerticalListData))
              {
                int i2 = i1;
                if (i1 < 0) {
                  i2 = b();
                }
                localObject = ((RecentItemMayKnowFriendVerticalListData)localObject).a();
                i4 = i2;
                if ((((RecentUser)localObject).extraInfo instanceof MayKnowRecommend))
                {
                  localObject = (MayKnowRecommend)((RecentUser)localObject).extraInfo;
                  localArrayList1.add(((MayKnowRecommend)localObject).uin);
                  localArrayList2.add(((MayKnowRecommend)localObject).recommendReason);
                  localArrayList3.add(Integer.valueOf(i3 - i2));
                  localArrayList4.add(((MayKnowRecommend)localObject).algBuffer);
                  i4 = i2;
                }
              }
            }
          }
        }
        i3 += 1;
      }
      if (!localArrayList1.isEmpty()) {
        ContactReportUtils.a(a(), 25, localArrayList1, localArrayList2, localArrayList3, localArrayList4, 2, null);
      }
    }
  }
  
  public void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "setThemeDiyBgConversation ");
    }
    ThemeBackground.applyThemeBg(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidViewView, 1, 2130838980, "-conversation-");
  }
  
  public void z()
  {
    if (!this.w) {
      break label7;
    }
    label7:
    while (!this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(24)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getChildCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() >= 0)) {}
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 == 0)
      {
        this.J = false;
        return;
      }
      if (this.J) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "checkPushBannerReport");
      }
      this.J = true;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(24);
      if (localObject != null) {}
      for (localObject = ((Banner)localObject).jdField_a_of_type_AndroidViewView.getTag(2131362258);; localObject = null)
      {
        ThreadManager.post(new Conversation.59(this, localObject), 5, null, false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation
 * JD-Core Version:    0.7.0.1
 */