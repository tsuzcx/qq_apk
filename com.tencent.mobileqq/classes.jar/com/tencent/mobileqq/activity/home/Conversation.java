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
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
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
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
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
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch.QZoneRedPointDrawerCallback;
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
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxObserver;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentItemTempMsgBoxData;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
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
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.mobileqq.vas.CrashVersionUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.mobileqq.vassplash.model.SplashItem;
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
import org.json.JSONException;
import org.json.JSONObject;

public class Conversation
  extends Frame
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, OnRecentUserOpsListener, RecentAdapter.ShowUpStateListener, AppConstants, FrameHelperActivity.DrawerListener, UpgradeTipsDialog.OnPreparedListener, AbsListView.OnScrollListener, OverScrollViewListener, SwipListView.RightIconMenuListener, Observer
{
  public static long b = -1L;
  private static long jdField_i_of_type_Long = 0L;
  public static boolean p = true;
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private boolean D;
  private boolean E = false;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  int jdField_a_of_type_Int = 0;
  protected long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new Conversation.53(this);
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(BaseApplicationImpl.getContext(), new Conversation.65(this));
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private final AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver = new Conversation.49(this);
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new Conversation.50(this);
  MsgTabStoryNodeListManager jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
  ConversationHotChatCtrl jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl = null;
  ConversationQbossBannerTitleEntranceCtrl jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl;
  ConversationTitleBtnCtrl jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl = null;
  protected QQSettingMe a;
  QZoneFeedsObserver jdField_a_of_type_ComTencentMobileqqActivityQZoneFeedsObserver = new Conversation.52(this);
  SearchBarAssistant jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant;
  private Conversation.DateFormatChangeRunnable jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DateFormatChangeRunnable = new Conversation.DateFormatChangeRunnable(this, null);
  private Conversation.DragChangedListener jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DragChangedListener;
  Conversation.LoadingStateCallback jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$LoadingStateCallback = new Conversation.LoadingStateCallback(this);
  private Conversation.TPHInCon jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon;
  protected Conversation.UICallBack a;
  private ConversationHelper jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper;
  RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  public RecentOptPopBar a;
  private RecentPubAccHelper jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper;
  RecentTroopMenuOption jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private TempMsgBoxObserver jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver = new Conversation.32(this);
  public CareNotificationBar a;
  public SpringFestivalTaskCallback a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new Conversation.41(this);
  private final ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new Conversation.38(this);
  private final DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new Conversation.47(this);
  public FrameHelperActivity a;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new Conversation.31(this);
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new Conversation.57(this);
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new Conversation.40(this);
  private RegisterProxySvcPackObserver jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver = new Conversation.51(this);
  private final SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new Conversation.48(this);
  TroopQZoneUploadAlbumObserver jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver = new Conversation.39(this);
  private AppletsObserver jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver = new Conversation.AppletsObserverImpl(this);
  private final AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new Conversation.29(this);
  public BannerManager a;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new Conversation.45(this);
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("tool_adMessage", "com.tencent.mobileqq:tool");
  public LoginwelcomeHelper a;
  private MiniAppPullInterface jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
  private OnlineStatusObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver = new Conversation.62(this);
  private OnAutoStatusBannerObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusObserverOnAutoStatusBannerObserver = new Conversation.34(this);
  public ConversationHongBaoV2 a;
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new Conversation.42(this);
  private QCircleObserver jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver = new Conversation.QCircleObserverImpl(this);
  private ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new Conversation.68(this);
  StrangerObserver jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver = new Conversation.43(this);
  private StudyModeChangeListener jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener = new Conversation.69(this);
  private RedpointObserver jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver = new Conversation.RedpointObserverImpl(this);
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  protected TroopCommonlyUsedObserver a;
  private final TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new Conversation.35(this);
  private final TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new Conversation.33(this);
  private final TroopOnlinePushObserver jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver = new Conversation.36(this);
  private final RoamSettingObserver jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver = new Conversation.30(this);
  ConversationContainer jdField_a_of_type_ComTencentMobileqqUiConversationContainer;
  private UpgradeTipsDialog jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog;
  VipGiftManager jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = null;
  public PullRefreshHeader a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private TianshuAdManager jdField_a_of_type_CooperationVipAdTianshuAdManager;
  private TianshuRenewalsBarManager jdField_a_of_type_CooperationVipAdTianshuRenewalsBarManager;
  private TianshuSplashManager jdField_a_of_type_CooperationVipAdTianshuSplashManager;
  Runnable jdField_a_of_type_JavaLangRunnable = new Conversation.28(this);
  protected StringBuilder a;
  protected List<RecentBaseData> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new Conversation.61(this);
  protected MqqHandler a;
  public boolean a;
  int jdField_b_of_type_Int = -1;
  Dialog jdField_b_of_type_AndroidAppDialog;
  private final BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new Conversation.54(this);
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
  private final BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new Conversation.55(this);
  View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private PreloadProcHitSession jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("tool_tencent_docs", "com.tencent.mobileqq:tool");
  private Runnable jdField_c_of_type_JavaLangRunnable;
  MqqHandler jdField_c_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$LoadingStateCallback);
  public boolean c;
  public int d;
  long jdField_d_of_type_Long;
  private final BroadcastReceiver jdField_d_of_type_AndroidContentBroadcastReceiver = new Conversation.56(this);
  private View jdField_d_of_type_AndroidViewView;
  private Runnable jdField_d_of_type_JavaLangRunnable = new Conversation.3(this);
  protected boolean d;
  int jdField_e_of_type_Int = 3;
  long jdField_e_of_type_Long = 0L;
  private View jdField_e_of_type_AndroidViewView;
  private Runnable jdField_e_of_type_JavaLangRunnable = new Conversation.22(this);
  boolean jdField_e_of_type_Boolean = false;
  public volatile int f;
  long f;
  public boolean f;
  public volatile int g;
  private long jdField_g_of_type_Long;
  boolean jdField_g_of_type_Boolean = false;
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
  public volatile boolean q;
  public boolean r = false;
  boolean s = false;
  boolean t = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = true;
  private boolean y;
  private boolean z;
  
  public Conversation()
  {
    this.jdField_a_of_type_Long = 2000L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback = new SpringFestivalTaskCallback(this);
    this.jdField_f_of_type_Int = 17;
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack = new Conversation.UICallBack(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver = new Conversation.37(this);
    this.jdField_b_of_type_JavaLangRunnable = new Conversation.67(this);
  }
  
  private void E()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFirstDrawComplete, ");
      localStringBuilder.append(this.jdField_i_of_type_Boolean);
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
    if (this.jdField_i_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1025);
    this.jdField_i_of_type_Boolean = true;
    if (!this.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
    }
    a(3, 10, Long.valueOf(0L));
    BaseApplicationImpl.sApplication.onActivityFocusChanged(a(), true);
  }
  
  private void F()
  {
    FPSSwipListView localFPSSwipListView = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
    if ((localFPSSwipListView != null) && ((localFPSSwipListView instanceof ARMapHongBaoListView)))
    {
      if (this.jdField_a_of_type_CooperationVipAdTianshuAdManager == null) {
        this.jdField_a_of_type_CooperationVipAdTianshuAdManager = new TianshuAdManager(a(), this, (ARMapHongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      }
      this.jdField_a_of_type_CooperationVipAdTianshuAdManager.a();
    }
  }
  
  private void G()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 50L);
  }
  
  private void H()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTopIfNeccessary: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition());
      QLog.d("Q.recent", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() >= 0)
    {
      this.G = true;
      this.jdField_j_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.smoothScrollToPosition(0);
    }
  }
  
  private void I()
  {
    ThreadManager.excute(new Conversation.4(this), 16, null, true);
  }
  
  private void J()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Msg_tab", "Jump_unread", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
        if (localObject == null) {
          return;
        }
        int i3 = ((RecentAdapter)localObject).getCount();
        int i1 = this.jdField_b_of_type_Int;
        boolean bool2 = true;
        i1 += 1;
        while (i1 < i3)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
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
              if (this.jdField_b_of_type_Int == i1) {
                break label170;
              }
              this.jdField_b_of_type_Int = i1;
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
          if (p)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
            ((FPSSwipListView)localObject).smoothScrollToPosition(this.jdField_b_of_type_Int + ((FPSSwipListView)localObject).getHeaderViewsCount());
          }
          else
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
            ((FPSSwipListView)localObject).setSelectionFromTop(this.jdField_b_of_type_Int + ((FPSSwipListView)localObject).getHeaderViewsCount(), 0);
          }
        }
        else
        {
          bool2 = p;
          if (bool2) {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setIsNeedScrollPositionTop(bool2);
          }
          H();
          this.jdField_b_of_type_Int = -1;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("scrollToNextUnreadItem|findUnreadItem:");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append(",mCurrentUnreadItem");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void K()
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
  
  private void L()
  {
    if (LoadingStateManager.a().b()) {
      LoadingStateManager.a().a(3);
    }
  }
  
  private void M()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Conversation showUpgradeDetailInfoIfNeccessary mInitTimUpgradeInfo : ");
      ((StringBuilder)localObject).append(this.D);
      QLog.d("UpgradeTIMWrapper", 2, ((StringBuilder)localObject).toString());
    }
    if (this.u)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog;
      if ((localObject != null) && (((UpgradeTipsDialog)localObject).a()))
      {
        localObject = this.jdField_c_of_type_AndroidAppDialog;
        if ((localObject != null) && (((Dialog)localObject).isShowing()))
        {
          this.jdField_c_of_type_AndroidAppDialog.dismiss();
          this.jdField_c_of_type_AndroidAppDialog = null;
        }
      }
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
      label165:
      break label165;
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    return;
    if (this.u)
    {
      if ((!ConfigHandler.a(a())) && (!this.D))
      {
        a(1134047, 0L, true);
        this.D = true;
      }
      a(1134057, 0L, true);
    }
  }
  
  private void N()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(this);
  }
  
  private void O()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = ((DragFrameLayout)a().findViewById(2131365172));
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DragChangedListener = new Conversation.DragChangedListener(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DragChangedListener, false);
    this.jdField_d_of_type_Boolean = true;
    a().isInCallList = false;
    this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer = ((ConversationContainer)a(2131376809));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer.findViewById(2131378881));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer.findViewById(2131365226));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer.findViewById(2131377872));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer.findViewById(2131379486));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer.findViewById(2131379492));
    P();
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    i();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer.findViewById(2131370166);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer.findViewById(2131376171));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDescendantInvalidatedFlags(true);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setActTAG("actFPSRecent");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(a().getDrawable(2130839396));
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
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setIsNeedScrollPositionTop(true);
    QBaseActivity localQBaseActivity = a();
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
        localObject2 = localQBaseActivity.getLayoutInflater().inflate(2131562771, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
      }
    }
    if (localObject2 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject2, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant = new SearchBarAssistant((BaseActivity)a(), 1, (View)localObject2);
      this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
    }
    BannerManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager = BannerManager.a();
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(PushBannerProcessor.jdField_a_of_type_Int, 2005);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(a(), a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 0, RecentDataListManager.a().jdField_a_of_type_Boolean ^ true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this);
    this.jdField_c_of_type_AndroidViewView = new View(a());
    Object localObject1 = new AbsListView.LayoutParams(-1, 0);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView, null, false);
    if ((!TextUtils.isEmpty(RecentDataListManager.a().jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(a().getCurrentUin())) && (!a().getCurrentUin().equals(RecentDataListManager.a().jdField_b_of_type_JavaLangString)))
    {
      localObject1 = new ArrayList(16);
      QLog.d("Q.recent", 1, "ignore PreLoadList");
    }
    else
    {
      localObject1 = RecentDataListManager.a().jdField_b_of_type_JavaUtilList;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a((List)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.u();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
    this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 = new ConversationHongBaoV2(this, this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer);
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper = new LoginwelcomeHelper(this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131365235));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    c("initUI");
    localObject1 = VasSplashUtil.a;
    if ((localObject1 != null) && (((SplashItem)localObject1).c()) && (!TextUtils.isEmpty(VasSplashUtil.a(a().getCurrentUin())))) {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(VasADBannerProcessor.jdField_a_of_type_Int, 3000);
    }
  }
  
  private void P()
  {
    int i1 = AIOUtils.b(10.0F, a());
    AIOUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, i1, i1, i1, i1);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new Conversation.15(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(new Conversation.16(this));
  }
  
  private void Q()
  {
    ((FriendListHandler)a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(a().getCurrentUin(), false);
  }
  
  private void R()
  {
    int i1 = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getNumRedNumByPath("104000.104001", 100);
    if (i1 > 0) {
      a(8, AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:");
    localStringBuilder.append(a().getCurrentUin());
    localStringBuilder.append("getSubscribeAccountRedDotNum  redNumByPath:");
    localStringBuilder.append(i1);
    QLog.d("Q.recent", 2, localStringBuilder.toString());
  }
  
  private void S()
  {
    try
    {
      if ((!this.jdField_j_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
      {
        this.jdField_j_of_type_Boolean = true;
        if (!this.k) {
          s();
        }
        x();
        if ((!this.l) && (!a().mAutomator.b())) {
          c(2);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.a();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new Conversation.20(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar = new CareNotificationBar(this, this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer);
        U();
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
        T();
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
        }
        else if (this.r)
        {
          a(1055, 0L, false);
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "initUiLater() mMsgTabStoryNodeListNeedInit fallback logic, send MSG_INIT_MSGTAG_STORY");
          }
          this.r = false;
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("Q.recent", 2, new Object[] { "initUiLater() will not send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(a().mAutomator.b()) });
        }
        M();
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(12);
        au();
        return;
      }
      return;
    }
    finally {}
  }
  
  private void T()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    if ((localObject != null) && (this.jdField_d_of_type_Boolean)) {
      ((BannerManager)localObject).b(MissedCallBannerProcessor.jdField_a_of_type_Int, 2000);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null)
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 2000;
      ((Message)localObject).getData().putBoolean("rightNow", false);
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(ContactBannerProcessor.jdField_a_of_type_Int, (Message)localObject);
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(PushBannerProcessor.jdField_a_of_type_Int, 2000, 5000L);
      a(3002, 5000L, true, "vas_banner_login");
    }
    a(5000, "tianshu_req_splash_type_login", true);
    a(5000, "tianshu_req_renewals_type_login");
    localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    if (localObject != null)
    {
      ((BannerManager)localObject).b(SetPwdBannerProcessor.jdField_a_of_type_Int, 3000);
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(SecurePhoneChangeNotifyBannerProcessor.jdField_a_of_type_Int, 3000, 1000L);
    }
  }
  
  private void U()
  {
    long l1 = System.currentTimeMillis();
    if (MiniAppConfProcessor.a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2131559642, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface == null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface = ((IMiniAppService)QRoute.api(IMiniAppService.class)).createMiniAppEntryManager(MiniAppConfProcessor.c(), a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer);
      }
      long l2 = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init Mini App, cost=");
      ((StringBuilder)localObject).append(l2 - l1);
      QLog.d("AutoMonitor", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
    if (localObject != null) {
      ((MiniAppPullInterface)localObject).initUI(a());
    }
  }
  
  private void V()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "resumeDelayRefresh");
    }
    at();
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(PushBannerProcessor.jdField_a_of_type_Int, 2000);
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(SetPwdBannerProcessor.jdField_a_of_type_Int, 3000);
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(NotificationGuideBannerProcessor.jdField_a_of_type_Int, 3000);
    M();
    if (!this.jdField_d_of_type_Boolean) {
      ((FriendListHandler)a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(a().getCurrentAccountUin(), (byte)2);
    }
    W();
    ((ModeSwitchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).a((BaseActivity)a());
  }
  
  private void W()
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
  
  private void X()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("removeObservers");
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      QLog.d("Q.recent", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      Object localObject2;
      if (this.jdField_a_of_type_MqqAppAppRuntime != null)
      {
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver);
        a().unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver);
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
        this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusObserverOnAutoStatusBannerObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver);
        a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver);
        localObject2 = (QCallFacade)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (localObject2 != null) {
          ((QCallFacade)localObject2).deleteObserver(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper != null) {
          this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.c();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null)
        {
          this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback);
          localObject2 = (SpringFestivalEntryManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          if (localObject2 != null) {
            ((SpringFestivalEntryManager)localObject2).a(null);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.f();
        }
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(17);
      try
      {
        localObject2 = (BaseActivity)a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon != null)
        {
          BaseTransProcessor.removeHandler(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon);
          this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon.a();
          this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon = null;
        }
        ((BaseActivity)localObject2).unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject2).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject2).unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
        ((BaseActivity)localObject2).unregisterReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver);
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
  
  private void Y()
  {
    Dialog localDialog = this.jdField_b_of_type_AndroidAppDialog;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  private void Z()
  {
    LoginwelcomeHelper localLoginwelcomeHelper = this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper;
    if (localLoginwelcomeHelper != null) {
      localLoginwelcomeHelper.a();
    }
  }
  
  private NewerGuideBannerManager a()
  {
    return (NewerGuideBannerManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == -1) {
      QQToast.a(a(), 2, a(2131720049), 0).b(a().getTitleBarHeight());
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
    int i1 = 0;
    paramRecentBaseData = paramRecentUserProxy.a(false).iterator();
    while (paramRecentBaseData.hasNext()) {
      if (((RecentUser)paramRecentBaseData.next()).showUpTime != 0L) {
        i1 += 1;
      }
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80053D0", "0X80053D0", 0, 0, paramString, String.valueOf(i1), String.valueOf(i2), "");
    if (paramInt == 7220)
    {
      if (paramBoolean)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(a(), "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "", false);
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007BFF", "0X8007BFF", 0, 0, "", "", "", "", false);
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
    if ((-1 == this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a()) && ((!this.E) || (!this.F)))
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
        localStringBuilder.append(this.o);
        QLog.i("Q.recent", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        if (paramInt == 0) {
          d(paramList);
        } else {
          c(paramList);
        }
      }
      if (AppSetting.jdField_i_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new Conversation.7(this));
      }
      a().refreshMsgTabUnreadNum(false, this.jdField_d_of_type_Int);
      a(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10001, null), false);
      if (this.w)
      {
        this.w = false;
        am();
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
      al();
      PublicAccountEventReport.a(a(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, 0);
      OfficialAccountReporter.a.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$DragChangedListener.a(paramInt, paramList);
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
    if (AppSetting.jdField_i_of_type_Boolean) {
      ThreadManager.getSubThreadHandler().post(new Conversation.6(this));
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
  
  private void a(Message paramMessage)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("UpgradeTIMWrapper", 2, "Conversation onReceiveShowTIMUpgradeTips");
      }
      if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_c_of_type_AndroidAppDialog == null) && ((paramMessage.obj instanceof UpgradeTIMWrapper)))
      {
        UpgradeTIMWrapper localUpgradeTIMWrapper = (UpgradeTIMWrapper)paramMessage.obj;
        if ((localUpgradeTIMWrapper != null) && (!TextUtils.isEmpty(localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(localUpgradeTIMWrapper.c)))
        {
          Conversation.10 local10 = new Conversation.10(this);
          Conversation.11 local11 = new Conversation.11(this, localUpgradeTIMWrapper);
          if (TextUtils.isEmpty(localUpgradeTIMWrapper.d)) {
            paramMessage = HardCodeUtil.a(2131702765);
          } else {
            paramMessage = localUpgradeTIMWrapper.d;
          }
          String str;
          if (TextUtils.isEmpty(localUpgradeTIMWrapper.e)) {
            str = HardCodeUtil.a(2131702775);
          } else {
            str = localUpgradeTIMWrapper.e;
          }
          this.jdField_c_of_type_AndroidAppDialog = DialogUtils.a(a(), localUpgradeTIMWrapper.jdField_a_of_type_JavaLangString, localUpgradeTIMWrapper.jdField_b_of_type_JavaLangString, paramMessage, str, null, local11, local10);
          this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_c_of_type_AndroidAppDialog.setOnDismissListener(new Conversation.12(this));
          if ((this.u) && (!this.jdField_c_of_type_AndroidAppDialog.isShowing()) && ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.isShowing())) && (!ConfigHandler.a(a())))
          {
            this.jdField_c_of_type_AndroidAppDialog.show();
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8008655", "0X8008655", 0, 0, "", "", "", "");
            ConfigHandler.a(a());
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
  
  private void a(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {
      return;
    }
    paramMessage = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
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
          if ((this.jdField_b_of_type_JavaUtilList.contains(str)) || (this.jdField_b_of_type_JavaUtilList.contains(RecentDataListManager.a(localRecentBaseData.getRecentUserUin(), -2147483648)))) {
            try
            {
              localRecentBaseData.update(a(), a());
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
    QQKRPUtil.a(a(), paramRecentUser, paramRecentBaseData);
    PublicAccountEventReport.a(a(), paramRecentBaseData);
    if ((paramRecentUser != null) && (paramRecentUser.lFlag == 16L) && (paramInt == 0))
    {
      paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
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
      paramRecentBaseData = this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
      if (paramRecentBaseData != null) {
        paramRecentBaseData.b();
      }
    }
    if ((paramRecentUser != null) && (paramRecentUser.getType() == 6004))
    {
      paramRecentBaseData = this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
      if (paramRecentBaseData != null) {
        paramRecentBaseData.b();
      }
    }
    if (paramRecentUser != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER);
      paramRecentBaseData.setFeedInfoRead(paramRecentUser.uin);
      if (FeedsManager.isShowStatus(paramRecentUser.uin))
      {
        BeancurdManager localBeancurdManager = (BeancurdManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.BEANCURD_MANAGER);
        if (localBeancurdManager != null)
        {
          long l1 = localBeancurdManager.a(paramRecentUser.uin);
          FeedsManager.saveToken(paramRecentUser.uin, l1);
          paramRecentBaseData.reportClickExpose();
          localBeancurdManager.a(2, 2);
        }
      }
      else
      {
        paramRecentBaseData = a().getMessageFacade().b(paramRecentUser.uin, paramRecentUser.getType());
        if ((paramRecentBaseData != null) && (paramRecentBaseData.msgtype == -1034))
        {
          paramRecentBaseData = (BeancurdManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.BEANCURD_MANAGER);
          if (paramRecentBaseData != null) {
            paramRecentBaseData.a(2, 1);
          }
        }
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString1, boolean paramBoolean, String paramString2)
  {
    RecentTroopMenuOption localRecentTroopMenuOption = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
    if (localRecentTroopMenuOption != null) {
      localRecentTroopMenuOption.a(paramRecentBaseData, paramBoolean);
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "0", paramString2, paramString1, "");
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if ((paramAbsListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
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
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i2);
        if ((localObject1 != null) && ((localObject1 instanceof RecentItemPublicAccountADFolderData)))
        {
          localObject1 = (RecentItemPublicAccountADFolderData)localObject1;
          if (ImaxAdUtil.a(paramAbsListView.getChildAt(i2 - i1)))
          {
            localObject1 = AdvertisementRecentUserManager.a().a(((RecentItemPublicAccountADFolderData)localObject1).mUser.uin);
            if (localObject1 == null) {
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
    b(new Conversation.18(this, paramString2, paramString1));
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    if ((paramObservable instanceof QCallFacade))
    {
      if ((paramObject instanceof Boolean))
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        if ((!this.jdField_d_of_type_Boolean) && (bool))
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
      if (this.jdField_d_of_type_Boolean)
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
        if (paramObservable != null) {
          paramObservable.b(MissedCallBannerProcessor.jdField_a_of_type_Int, 2000);
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
      long l1 = FriendsStatusUtil.a(paramContext);
      if (l1 > 0L) {
        paramMqqHandler.postDelayed(new Conversation.44(paramMqqHandler), l1 * 1000L);
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
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i1, "0", "0", "", "");
    if (!NetworkUtil.isNetworkAvailable(a().getApp().getApplicationContext()))
    {
      QQToast.a(a(), 1, 2131696114, 0).b(a().getTitleBarHeight());
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
      A();
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
    int i2 = paramRecentBaseData.getRecentUserType();
    int i1 = 1;
    boolean bool = false;
    if ((paramString != null) && (paramString.length() != 0) && (paramRecentUserProxy != null))
    {
      Object localObject2 = paramRecentUserProxy.b(paramString, i2);
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
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      Object localObject3;
      StringBuilder localStringBuilder;
      if ((i2 != 7210) && (i2 != 7120))
      {
        if (i2 == 1008)
        {
          i2 = paramRecentBaseData.mUnreadNum;
          if (paramBoolean) {
            paramRecentBaseData = "0X80064C7";
          } else {
            paramRecentBaseData = "0X80064C8";
          }
          paramRecentUserProxy = paramRecentUserProxy.a(false).iterator();
          i1 = 0;
          while (paramRecentUserProxy.hasNext()) {
            if (((RecentUser)paramRecentUserProxy.next()).showUpTime != 0L) {
              i1 += 1;
            }
          }
          paramRecentUserProxy = this.jdField_a_of_type_MqqAppAppRuntime;
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
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", paramRecentBaseData, paramRecentBaseData, 0, 0, "", "", "", "");
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
        paramRecentUserProxy = this.jdField_a_of_type_MqqAppAppRuntime;
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
        ((IKanDianMergeManager)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getRuntimeService(IKanDianMergeManager.class)).roamStickySettingToServer(paramBoolean);
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
  
  private void aa()
  {
    MiniAppPullInterface localMiniAppPullInterface = this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
    if (localMiniAppPullInterface != null) {
      localMiniAppPullInterface.onResume();
    }
  }
  
  private void ab()
  {
    CareNotificationBar localCareNotificationBar = this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar;
    if (localCareNotificationBar != null) {
      localCareNotificationBar.d();
    }
  }
  
  private void ac()
  {
    MsgTabStoryNodeListManager localMsgTabStoryNodeListManager = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
    if (localMsgTabStoryNodeListManager != null) {
      localMsgTabStoryNodeListManager.k();
    }
  }
  
  private void ad()
  {
    if (a().upgradeData != null)
    {
      a(a().upgradeData);
      a().upgradeData = null;
    }
  }
  
  private void ae()
  {
    if ((jdField_b_of_type_Long == -1L) && (SplashActivity.sIsNormalRouteEnter))
    {
      jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).setResumeFlagFromConversation(jdField_b_of_type_Long);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).saveNormalEnterConversationTime(jdField_b_of_type_Long);
    }
  }
  
  private void af()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new Conversation.23(this), 500L);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1070, 3000L);
    ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).residenceReport(System.currentTimeMillis());
    TianShuManager.setLastClickAdTraceInfo("", "");
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).handConversationToShow();
    ai();
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1053)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1053, 500L);
    }
    RecentPubAccHelper.b(a());
  }
  
  private void ag()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (FrameHelperActivity.b())
      {
        FrameHelperActivity.b(true);
        FrameHelperActivity.w();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void ah()
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
  
  private void ai()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null) {
      this.jdField_c_of_type_JavaLangRunnable = new Conversation.24(this);
    }
    ThreadManagerV2.excute(this.jdField_c_of_type_JavaLangRunnable, 32, null, true);
  }
  
  private void aj()
  {
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      if (FrameHelperActivity.b()) {
        FrameHelperActivity.w();
      }
      this.jdField_b_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      if ((localObject != null) && (((ConversationHongBaoV2)localObject).jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_Int != 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.jdField_a_of_type_ComTencentWidgetHongBaoListView.m = true;
        localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
        ((ConversationHongBaoV2)localObject).jdField_a_of_type_Boolean = true;
        ((ConversationHongBaoV2)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      if (localObject != null) {
        ((ConversationHongBaoV2)localObject).h();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback;
      if (localObject != null) {
        ((SpringFestivalTaskCallback)localObject).d();
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
      if (localObject != null) {
        ((ConversationHongBaoV2)localObject).i();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback;
      if (localObject != null) {
        ((SpringFestivalTaskCallback)localObject).d();
      }
    }
    if (this.s) {
      this.s = false;
    }
  }
  
  private void ak()
  {
    BannerManager localBannerManager = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    if (localBannerManager != null) {
      localBannerManager.b();
    }
    c("onResume");
  }
  
  private void al()
  {
    if ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isSimpleDayTheme(true))) {
      return;
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0);
    if ((localObject instanceof RecentUserBaseData))
    {
      localObject = (RecentUserBaseData)localObject;
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
      boolean bool;
      if ((((RecentUserBaseData)localObject).mUser.getType() == 1) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(a(), ((RecentUserBaseData)localObject).mUser))) {
        bool = localTroopManager.a(((RecentUserBaseData)localObject).getRecentUserUin());
      } else if (((RecentUserBaseData)localObject).mUser.showUpTime > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      if (this.z != bool)
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setLocalSearchBarByShowUpMask:mShowUPMask = ");
          ((StringBuilder)localObject).append(this.z);
          ((StringBuilder)localObject).append(", dstMsg = ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("Q.recent", 4, ((StringBuilder)localObject).toString());
        }
        int i1;
        if (bool) {
          i1 = 2130850683;
        } else {
          i1 = 2130850682;
        }
        int i2;
        if (bool) {
          i2 = 2130850695;
        } else {
          i2 = 2130850694;
        }
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(i1);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131366333).setBackgroundResource(i2);
        this.z = bool;
      }
    }
  }
  
  private void am()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess start");
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      if (!this.jdField_i_of_type_Boolean) {
        return;
      }
      if (((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).isTencentDocsAssistantEnable(a()))
      {
        if (!((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).isPreloadToolProcess(a())) {
          return;
        }
        int i3 = 0;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
        int i2 = i3;
        if (localObject != null)
        {
          i2 = i3;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
          {
            int i1 = ((FPSSwipListView)localObject).getFirstVisiblePosition();
            for (;;)
            {
              i2 = i3;
              if (i1 > this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
                break;
              }
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
              if (((localObject instanceof RecentItemTencentDocsAssistantData)) && (((RecentItemTencentDocsAssistantData)localObject).getUnreadNum() > 0))
              {
                i2 = 1;
                break;
              }
              i1 += 1;
            }
          }
        }
        if ((i2 != 0) && (((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).preloadWebProcess(a())))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "preloadTencentDocsWebProcess call");
          }
          localObject = this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
          if (localObject != null) {
            ((PreloadProcHitSession)localObject).a();
          }
        }
      }
    }
  }
  
  private void an()
  {
    Object localObject = this.jdField_a_of_type_CooperationVipAdTianshuAdManager;
    if (localObject != null)
    {
      ((TianshuAdManager)localObject).b();
      this.jdField_a_of_type_CooperationVipAdTianshuAdManager = null;
    }
    localObject = this.jdField_a_of_type_CooperationVipAdTianshuSplashManager;
    if (localObject != null)
    {
      ((TianshuSplashManager)localObject).a();
      this.jdField_a_of_type_CooperationVipAdTianshuSplashManager = null;
    }
    localObject = this.jdField_a_of_type_CooperationVipAdTianshuRenewalsBarManager;
    if (localObject != null)
    {
      ((TianshuRenewalsBarManager)localObject).a();
      this.jdField_a_of_type_CooperationVipAdTianshuRenewalsBarManager = null;
    }
  }
  
  private void ao()
  {
    CareNotificationBar localCareNotificationBar = this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar;
    if (localCareNotificationBar != null) {
      localCareNotificationBar.b();
    }
  }
  
  private void ap()
  {
    b(new Conversation.27(this));
  }
  
  private void aq()
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
    } else if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "troopTipsMsgMgr == null");
    }
    localObject = (EcShopAssistantManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localObject != null) {
      ((EcShopAssistantManager)localObject).e();
    }
    localObject = (IGroupVideoManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    if (localObject != null) {
      ((IGroupVideoManager)localObject).a(true);
    }
    localObject = (HotChatCenterManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
    if (localObject != null) {
      ((HotChatCenterManager)localObject).a();
    }
    HiddenChatManager.a(a()).b();
    localObject = (IExpandLimitChatManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (localObject != null) {
      ((IExpandLimitChatManager)localObject).d();
    }
    localObject = (StoryHaloManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    ((StoryHaloManager)localObject).a(1, ((StoryHaloManager)localObject).a(this.jdField_a_of_type_JavaUtilList));
  }
  
  private void ar()
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
    this.o = localMayknowRecommendManager.d();
    ArrayList localArrayList = localMayknowRecommendManager.c();
    if ((this.o) && (localArrayList != null) && (localArrayList.size() > 0))
    {
      localMayknowRecommendManager.d();
      return;
    }
    localMayknowRecommendManager.e();
    this.o = false;
  }
  
  private void as()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new Conversation.46(this);
  }
  
  private void at()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = RecentDataListManager.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadNextScreenUserFaceIcon:");
      localStringBuilder.append(this.x);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    boolean bool = this.x;
    int i2 = 1;
    if (bool)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() + 1;
    }
    else
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
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
      if (i3 >= this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount()) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i3);
      if ((localObject != null) && ((localObject instanceof RecentBaseData)))
      {
        localObject = (RecentBaseData)localObject;
        if (!(localObject instanceof RecentItemImaxADData)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a().a(((RecentBaseData)localObject).getRecentUserType(), ((RecentBaseData)localObject).getRecentUserUin(), false);
        }
      }
      else
      {
        i3 += i2;
      }
      i1 += 1;
    }
  }
  
  private void au()
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      FrameHelperActivity localFrameHelperActivity = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
      if (localFrameHelperActivity != null)
      {
        localFrameHelperActivity.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks[0] = new Conversation.58(this);
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks[1] = new LebaTabRedTouch.QZoneRedPointDrawerCallback();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
    }
  }
  
  private void av()
  {
    if ((this.u) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      ThreadManager.post(new Conversation.59(this), 5, null, true);
    }
  }
  
  private void aw()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      RecentOptPopBar localRecentOptPopBar = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar;
      if (localRecentOptPopBar != null)
      {
        localRecentOptPopBar.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
        this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1048, 0, 0).sendToTarget();
      }
    }
  }
  
  private void ax()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), a().getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694655);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new Conversation.66(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ay()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 800L);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  private void b(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceiverShowUpgradeTips");
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog == null))
    {
      if (!(paramMessage.obj instanceof UpgradeDetailWrapper)) {
        return;
      }
      paramMessage = (UpgradeDetailWrapper)paramMessage.obj;
      if (ConfigHandler.a(a()) >= 5)
      {
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(UpgradeBannerProcessor.jdField_a_of_type_Int, 3000);
        return;
      }
      if (ConfigHandler.a(a())) {
        return;
      }
      if (ConfigHandler.a(a(), 0) == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog = new UpgradeTipsDialog(a(), a(), paramMessage, this);
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog.setOnDismissListener(new Conversation.13(this));
    }
  }
  
  private void b(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {
      return;
    }
    if (QvipSpecialCareUtil.a(a())) {
      QvipSpecialCareUtil.a(a());
    }
    K();
    List localList1 = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
    List localList2 = a().getProxyManager().a().a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper.a(localList2);
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
        localRecentBaseData = ConversationDataFactory.a(localRecentUser, a(), a());
        paramMessage = localRecentBaseData;
        if (localRecentBaseData != null)
        {
          RecentDataListManager.a().a(localRecentBaseData, str);
          paramMessage = localRecentBaseData;
        }
      }
      else if (!this.jdField_b_of_type_JavaUtilList.contains(str))
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
      Collections.sort(localList1, this.jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper);
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
    e(localList1);
    a(localList1);
    paramMessage = new ArrayList(localList1);
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10000, 0, 0, paramMessage).sendToTarget();
    b(localList1);
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null)
    {
      paramMessage = Message.obtain();
      paramMessage.what = 2000;
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(TroopAssistBannerProcessor.jdField_a_of_type_Int, paramMessage);
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
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80090CC", "0X80090CC", paramInt, 0, "", "", "", "");
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
        Object localObject1 = a().getMessageFacade().b(paramRecentUser.uin, paramRecentUser.getType());
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
        localObject1 = this.jdField_a_of_type_MqqAppAppRuntime;
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
    Object localObject = (TroopManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.getRecentUserUin());
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    if (!bool2)
    {
      if (!((ITroopCommonlyUsedHandler)a().getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a(str, paramBoolean ^ true)) {
        return true;
      }
      paramRecentUserProxy = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
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
      paramRecentUserProxy = new ReportTask(a()).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
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
      localObject = paramRecentUserProxy.b(paramString, i1);
      paramRecentBaseData = (RecentBaseData)localObject;
      if (localObject == null) {
        paramRecentBaseData = new RecentUser(paramString, i1);
      }
      if (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(a(), paramRecentBaseData))
      {
        if (paramBoolean) {
          paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);
        } else {
          paramRecentBaseData.showUpTime = 0L;
        }
        paramRecentUserProxy.b(paramRecentBaseData);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
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
      QLog.d("Q.recent", 2, new Object[] { "doAfterMsgSync from=", Integer.valueOf(paramInt), " isInRealActionLoginB=", Boolean.valueOf(a().mAutomator.b()), " isLoadUIAfterMsgSync=", Boolean.valueOf(this.l) });
      if (1 == paramInt)
      {
        this.q = true;
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(18);
        a(1072, 500L, true);
        a(500, "tianshu_req_splash_type_after_sync", true);
        a(500, "tianshu_req_renewals_type_after_sync");
        a(1073, 30000L, true);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.f();
        }
        ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).setDataManagerAfterMsgSync();
      }
      a(1077, 1200L, true);
      if ((!this.l) && (!this.jdField_g_of_type_Boolean))
      {
        this.l = true;
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(VasADBannerProcessor.jdField_a_of_type_Int, 2001);
        this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
        Q();
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
  
  private void c(long paramLong)
  {
    if (this.jdField_f_of_type_Boolean) {
      a(1016, paramLong, true);
    }
  }
  
  private void c(Message paramMessage)
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
      ((StringBuilder)localObject).append(this.jdField_i_of_type_Boolean);
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
        if (!this.jdField_b_of_type_JavaUtilList.contains(localObject))
        {
          this.jdField_b_of_type_JavaUtilList.add(localObject);
          l1 = l2;
        }
      }
    }
    if (i2 >= this.jdField_c_of_type_Int)
    {
      while (i1 < i2)
      {
        this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(i1);
        i1 += 1;
      }
      this.jdField_c_of_type_Int = i2;
    }
    if ((this.jdField_i_of_type_Boolean) && (!this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(this.jdField_c_of_type_Int)))
    {
      l2 = Math.abs(System.currentTimeMillis() - this.jdField_d_of_type_Long);
      l1 = Math.max(this.jdField_a_of_type_Long - l2, l1);
      localObject = Message.obtain();
      ((Message)localObject).arg1 = paramMessage.arg1;
      ((Message)localObject).what = this.jdField_c_of_type_Int;
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, l1);
    }
  }
  
  private void c(Message paramMessage, long paramLong)
  {
    if (!a(paramMessage)) {
      return;
    }
    ((HotChatCenterManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).b();
    TroopAssistantManager.a().e(a());
    K();
    paramMessage = a().getProxyManager().a();
    if (QvipSpecialCareUtil.a(a())) {
      QvipSpecialCareUtil.a(a());
    }
    boolean bool;
    if ((a().mAutomator != null) && (a().mAutomator.b())) {
      bool = true;
    } else {
      bool = false;
    }
    List localList = paramMessage.a(bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper.a(localList);
    paramMessage = RecentDataListManager.a().jdField_a_of_type_JavaUtilList;
    QQAppInterface localQQAppInterface = a();
    QBaseActivity localQBaseActivity = a();
    int i1;
    if (localList != null) {
      i1 = localList.size();
    } else {
      i1 = 0;
    }
    ConversationDataFactory.a(localList, localQQAppInterface, localQBaseActivity, paramMessage, i1);
    try
    {
      Collections.sort(paramMessage, this.jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper);
    }
    catch (Exception localException)
    {
      QLog.d("Q.recent", 2, "Comparator Exception: ", localException);
      localException.printStackTrace();
    }
    e(paramMessage);
    a(paramMessage);
    Object localObject = new ArrayList(paramMessage);
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
      if ((this.jdField_e_of_type_Boolean) && (((RecentUser)paramObject).getType() == 6004)) {
        this.w = true;
      }
    }
  }
  
  private void c(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new Conversation.17(this, paramString));
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
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(localRecentBaseData);
      }
      i2 += 1;
    }
  }
  
  private void d(Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramObject;
      a().refreshMultiAIOUnreadNum(localMessageRecord.frienduin, localMessageRecord.istroop);
      if ((localMessageRecord.isSendFromLocal()) && (localMessageRecord.msgtype == -2002)) {
        return;
      }
      if ((localMessageRecord.isSendFromLocal()) && (localMessageRecord.msgtype == -2000) && (!this.jdField_e_of_type_Boolean)) {
        return;
      }
      boolean bool = this.jdField_e_of_type_Boolean;
      int i3 = 0;
      if ((bool) && (PublicAccountAdUtil.a(localMessageRecord)))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
        m(false);
      }
      if ((this.jdField_e_of_type_Boolean) && (ImaxAdUtil.a(localMessageRecord))) {
        ImaxAdRecentUserManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
      }
      if ((this.jdField_e_of_type_Boolean) && (QCircleChatUtil.a(localMessageRecord.istroop))) {
        r();
      }
      int i4 = 10;
      Long localLong = Long.valueOf(0L);
      int i1;
      int i2;
      if ((localMessageRecord.isSendFromLocal()) && ((!this.jdField_e_of_type_Boolean) || (TextUtils.equals(localMessageRecord.frienduin, AppConstants.NEW_KANDIAN_UIN)) || (TextUtils.equals(localMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN))))
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
        if (!this.jdField_e_of_type_Boolean)
        {
          i1 = i4;
          i2 = i3;
          paramObject = localLong;
          if (RecentUtil.jdField_b_of_type_Boolean)
          {
            i1 = i4;
            i2 = i3;
            paramObject = localLong;
            if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1024))
            {
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1024, 100L);
              paramObject = localLong;
              i2 = i3;
              i1 = i4;
            }
          }
        }
      }
      if (localMessageRecord.isSend()) {
        QAVHrMeeting.a(a(), localMessageRecord);
      }
      if (e())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "update message in AIO");
        }
        i2 = 4;
        paramObject = RecentDataListManager.a(localMessageRecord.frienduin, localMessageRecord.istroop);
        i1 = 9;
      }
      a(i2, i1, paramObject);
      this.F = true;
    }
  }
  
  private void d(List<RecentBaseData> paramList)
  {
    if (this.o)
    {
      MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if ((localMayknowRecommendManager.jdField_a_of_type_Boolean) && (localMayknowRecommendManager.a(paramList))) {
        localMayknowRecommendManager.jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramList);
    if (this.B)
    {
      this.B = false;
      if (this.C)
      {
        if (this.jdField_e_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addOnLayoutChangeListener(new Conversation.8(this));
        } else {
          ay();
        }
        this.C = false;
      }
    }
    if (paramList != null) {
      RecentDataListManager.a().a(paramList, a().getCurrentUin());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
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
        Object localObject1 = this.jdField_a_of_type_JavaLangStringBuilder;
        int i1 = 0;
        if (localObject1 == null) {
          this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        } else {
          ((StringBuilder)localObject1).setLength(0);
        }
        paramList = new ArrayList(paramList);
        this.jdField_a_of_type_JavaLangStringBuilder.append("SortedRecentInfo, [");
        localObject1 = (TroopManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
        int i2 = paramList.size();
        while (i1 < i2)
        {
          Object localObject2 = (RecentBaseData)paramList.get(i1);
          if ((localObject2 instanceof RecentUserBaseData))
          {
            localObject2 = (RecentUserBaseData)localObject2;
            if (((((RecentUserBaseData)localObject2).getRecentUserType() == 1) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(a(), ((RecentUserBaseData)localObject2).mUser)) && (((TroopManager)localObject1).a(((RecentUserBaseData)localObject2).getRecentUserUin()))) || (((RecentUserBaseData)localObject2).mUser.showUpTime != 0L)) {
              this.jdField_a_of_type_JavaLangStringBuilder.append("t-");
            }
            StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
            localStringBuilder.append(((RecentUserBaseData)localObject2).getRecentUserType());
            localStringBuilder.append("-");
            localStringBuilder.append(StringUtil.e(((RecentUserBaseData)localObject2).getRecentUserUin()));
            localStringBuilder.append("-");
            localStringBuilder.append(i1);
            localStringBuilder.append(" , ");
          }
          i1 += 1;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append("]");
        paramList.clear();
        QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
    }
  }
  
  private boolean e()
  {
    boolean bool2 = Foreground.isCurrentProcessForeground();
    boolean bool3 = QBaseActivity.sTopActivity instanceof SplashActivity;
    boolean bool1;
    if (bool3)
    {
      Object localObject = ((SplashActivity)QBaseActivity.sTopActivity).getSupportFragmentManager();
      try
      {
        localObject = (QBaseFragment)((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
        if ((localObject instanceof ChatFragment))
        {
          bool1 = ((QBaseFragment)localObject).isVisible();
          if (bool1) {
            bool1 = true;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("Q.recent", 1, "AndroidX findFragmentByTag error,", localException);
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "mIsForeground=", Boolean.valueOf(this.jdField_e_of_type_Boolean), " isProcessForeground=", Boolean.valueOf(bool2), " isSplashActivity=", Boolean.valueOf(bool3), " isChatFragment=", Boolean.valueOf(bool1) });
    }
    return (!this.jdField_e_of_type_Boolean) && (bool2) && (bool3) && (bool1);
  }
  
  private boolean f()
  {
    if (!SharedPreUtils.d(a(), a().getCurrentAccountUin()))
    {
      Object localObject2 = a().getProxyManager().a().a(false);
      if ((localObject2 != null) && (((List)localObject2).size() != 0))
      {
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
        ((ITroopCommonlyUsedHandler)a().getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a(localArrayList, 0);
        return false;
      }
      SharedPreUtils.j(a(), a().getCurrentAccountUin());
      return true;
    }
    return false;
  }
  
  private void i(boolean paramBoolean)
  {
    if (this.m != paramBoolean)
    {
      Object localObject;
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null)
        {
          QLog.e("Q.recent", 1, "Error State that mChatTopReflesh is null! ui Not Init! will updateMsgTabStoryNodeView(true) later.");
          this.r = true;
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager = new MsgTabStoryNodeListManager(a(), this, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame, (BreathEffectView)this.jdField_a_of_type_ComTencentMobileqqUiConversationContainer.findViewById(2131368239));
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
        if ((localObject != null) && (((FrameHelperActivity)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null)) {
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b();
        }
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.jdField_f_of_type_Boolean = this.u;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.b();
        this.r = false;
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
        if (localObject != null) {
          ((MsgTabStoryNodeListManager)localObject).c();
        }
        this.r = false;
      }
      this.m = paramBoolean;
    }
  }
  
  private void j(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addObservers");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
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
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiTroopOnlinePushObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver, true);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppRegisterProxySvcPackObserver);
    a().registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQZoneFeedsObserver);
    a().registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver);
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusObserverOnAutoStatusBannerObserver);
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    StudyModeManager.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      as();
    }
    a().getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon = new Conversation.TPHInCon(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon.addFilter(new Class[] { BuddyTransfileProcessor.class, ((IPicTransFile)a().getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getC2CPttDownloadProcessorClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getC2CPttUpProcessorClass(), ((IPicTransFile)a().getRuntimeService(IPicTransFile.class)).getGroupUploadProClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getGroupPttDownloadProcessorClass(), ForwardImageProcessor.class });
    ((ITransFileController)a().getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$TPHInCon);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.SECURITY_DETECT_PUSH_BANNER");
      a().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      localIntentFilter = new IntentFilter("android.intent.action.TIME_SET");
      localIntentFilter.addAction("android.intent.action.DATE_CHANGED");
      localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      a().registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      localIntentFilter = new IntentFilter("com.tencent.WT.WT_OUT_OF_AIO");
      a().registerReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, localException.toString());
      }
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime.isLogin())
    {
      a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver, true);
      a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver, true);
      Object localObject2 = (SpringFestivalEntryManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
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
      a().addObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
      a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsAppletsObserver);
      a().addObserver(this.jdField_a_of_type_ComTencentMobileqqQcircleApiHelperQCircleObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper.b();
      }
    }
    a().d();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
    if (localObject1 != null) {
      ((FrameHelperActivity)localObject1).a("AfterAddObservers");
    }
  }
  
  private void k(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      PreloadProcHitSession localPreloadProcHitSession = this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
      if (localPreloadProcHitSession != null) {
        localPreloadProcHitSession.d();
      }
    }
    m(true);
    am();
    u();
  }
  
  private void l(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_j_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl;
      if (localObject != null)
      {
        ((ConversationTitleBtnCtrl)localObject).e();
        this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl.a(false);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl;
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
      int i2 = i3;
      if (localObject != null)
      {
        i2 = i3;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
        {
          int i1 = ((FPSSwipListView)localObject).getFirstVisiblePosition();
          for (;;)
          {
            i2 = i3;
            if (i1 > this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
              break;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1) instanceof RecentItemPublicAccountADFolderData))
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
        if ((localObject != null) && (!this.v))
        {
          ((PreloadProcHitSession)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "tool preload statistics begin");
          }
          this.v = true;
        }
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).setHasPreloadWebProcessor(true);
        ThreadManager.getSubThreadHandler().postDelayed(new Conversation.25(this), 1000L);
      }
    }
  }
  
  void A()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(a());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131691258);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new Conversation.64(this));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public int a()
  {
    return this.jdField_h_of_type_Int;
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
      if (!RecentUtil.a(a(), paramString)) {
        return 4;
      }
      i1 = 1;
    }
    return i1;
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
      localObject2 = paramLayoutInflater.inflate(2131558938, null);
    }
    StartupTracker.a("Recent_CreateView", null);
    return localObject2;
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
  
  protected String a()
  {
    String str = HardCodeUtil.a(2131702772);
    int i1 = this.jdField_d_of_type_Int;
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
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    StartupTracker.a(null, "Recent_OnCreate");
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = FrameHelperActivity.a((BaseActivity)a());
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl = new ConversationHotChatCtrl(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack);
    this.jdField_b_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getRecentThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper = new RecentPubAccHelper(this.jdField_a_of_type_MqqOsMqqHandler, a());
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl = new ConversationTitleBtnCtrl(this);
    O();
    N();
    c(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper = new ConversationHelper(a());
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
              if (paramInt1 != 14002) {
                if (paramInt1 != 9001)
                {
                  if (paramInt1 != 9002)
                  {
                    if ((paramInt1 == 14005) || (paramInt1 == 14006)) {}
                  }
                  else {
                    b(paramInt1);
                  }
                }
                else
                {
                  a(paramInt2);
                  return;
                }
              }
              b(paramInt1, paramInt2, paramIntent);
              return;
            }
            I();
            return;
          }
          RecentOptPopBar.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity);
          return;
        }
        a(paramInt2, paramIntent);
        return;
      }
      if (paramInt2 == 0)
      {
        B();
        a().exit(false);
      }
    }
    else if (a() != null)
    {
      a().setCanLock(false);
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
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null)
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
      if (!d())
      {
        this.jdField_h_of_type_Boolean = false;
        localObject = this.jdField_b_of_type_MqqOsMqqHandler.obtainMessage(11);
        ((Message)localObject).arg1 = paramInt1;
        ((Message)localObject).arg2 = paramInt2;
        ((Message)localObject).obj = paramObject;
        this.jdField_b_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        return;
      }
      this.jdField_h_of_type_Boolean = true;
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
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(paramInt);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(paramInt, paramLong);
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
    paramString = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    if (paramString != null) {
      paramString.a(VasADBannerProcessor.jdField_a_of_type_Int, (Message)localObject, paramLong, paramBoolean);
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
    RecentUserProxy localRecentUserProxy = a().getProxyManager().a();
    String str2 = paramRecentBaseData.getRecentUserUin();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (QFileAssistantUtils.a(str2))
    {
      ((FileAssistTopHandler)a().getBusinessHandler(BusinessHandlerFactory.FILE_ASSIST_TOP)).a(paramBoolean);
      return;
    }
    if ((paramInt == 7000) && (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(str2)))
    {
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).setTopInRecentList(a(), str2, paramBoolean);
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004169", "0X8004169", 0, 0, "1", str1, paramString, "");
    }
    else if (paramInt == 5000)
    {
      a(paramRecentBaseData, paramString, paramBoolean, str1);
    }
    else if (paramInt == 5001)
    {
      ((HotChatCenterManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a(paramBoolean);
    }
    else if (paramInt == 1)
    {
      if (!b(paramRecentBaseData, paramBoolean, localRecentUserProxy, str2)) {}
    }
    else if ((paramInt == 0) && (localFriendsManager.b(str2)))
    {
      if (!a(paramInt, paramBoolean, str2)) {}
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
      if (((paramInt & 0x1) != 0) && (this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager != null))
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 2001;
        ((Message)localObject).getData().putString("troopUin", paramRecentUser.uin);
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(TroopAssistBannerProcessor.jdField_a_of_type_Int, (Message)localObject);
      }
      if ((paramInt & 0x2) != 0) {
        a(8, paramRecentUser.uin, paramRecentUser.getType());
      }
      if ((paramInt & 0x4) != 0)
      {
        RecentUtil.a(a(), paramRecentUser, -1);
        QQToast.a(a(), HardCodeUtil.a(2131702771), 0).a();
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
      L();
      c(800L);
    }
    Object localObject = a().getHandler(AVNotifyCenter.class);
    if (localObject != null)
    {
      Message localMessage = ((MqqHandler)localObject).obtainMessage(10010);
      localMessage.obj = Boolean.valueOf(paramBoolean1);
      ((MqqHandler)localObject).sendMessage(localMessage);
    }
    boolean bool1 = a().isMSFConnect;
    int i2 = 0;
    if (bool1) {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(NetNeedSignOnBannerProcessor.jdField_a_of_type_Int, 0, null);
    }
    boolean bool3 = paramBoolean1 ^ true;
    LoadingStateManager.a().a(bool3);
    localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    int i3 = NetStateBannerProcessor.jdField_a_of_type_Int;
    if (bool3) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    ((BannerManager)localObject).a(i3, i1, null);
    boolean bool2 = LoadingStateManager.a().d();
    bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (paramInt == 1134012) {
        bool1 = false;
      }
    }
    LoadingStateManager.a().b(bool1);
    localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    i3 = IllegalNetworkBannerProcessor.jdField_a_of_type_Int;
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
      ((StringBuilder)localObject).append(a().isMSFConnect);
      ((StringBuilder)localObject).append(", isNetSupport = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", loadingState = ");
      ((StringBuilder)localObject).append(LoadingStateManager.a().a());
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
    RecentOptPopBar localRecentOptPopBar = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar;
    if ((localRecentOptPopBar != null) && (localRecentOptPopBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a();
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
      paramMessage.append(a().isMSFConnect);
      paramMessage.append(", initLoadingHandle = ");
      paramMessage.append(paramBoolean);
      paramMessage.append(", loadingState = ");
      paramMessage.append(LoadingStateManager.a().a());
      paramMessage.append(", what = ");
      paramMessage.append(i1);
      QLog.i("Q.recent", 2, paramMessage.toString());
    }
    if (a().isMSFConnect)
    {
      a(i1, true, paramBoolean);
      a(i1, true);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new Conversation.1(this, i1, paramBoolean));
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
    if ((paramString.equals("sp_uin_for_title")) && (i2 == 2131376248))
    {
      A();
      ContactReportUtils.a(a(), "msgtab_list_clk", 2);
      return;
    }
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    Object localObject = new AllInOne(paramString, 102);
    boolean bool = localMayknowRecommendManager.a();
    ArrayList localArrayList = localMayknowRecommendManager.c();
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
    i1 -= b();
    if (paramView == null)
    {
      QLog.d("Q.recent", 1, "onMsgTabRecommendBClick recommend is null ");
      return;
    }
    if (i2 == 2131376477)
    {
      if (!NetworkUtil.isNetworkAvailable(paramContext))
      {
        QQToast.a(paramContext, paramContext.getResources().getString(2131692183), 0).b(a().getTitleBarHeight());
        return;
      }
      paramString = (FriendsManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((!paramString.b(paramView.uin)) && (!paramString.d(paramView.uin)))
      {
        paramString = paramView.getDisplayName(localMayknowRecommendManager.a());
        paramContext = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramContext, 1, paramView.uin, null, 3045, 25, paramString, null, null, paramContext.getString(2131689589), null);
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(25), "", "", "");
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(a(), paramContext);
      }
      else if (paramString.b(paramView.uin))
      {
        paramView.friendStatus = 2;
      }
      else
      {
        paramView.friendStatus = 1;
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
      ContactReportUtils.a(a(), paramView.uin, "frd_list_add", 25, 1, paramView.recommendReason, i1, paramView.algBuffer, 2);
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
    ContactReportUtils.a(a(), paramView.uin, "frd_list_clk", 25, 0, paramView.recommendReason, i1, paramView.algBuffer, 2);
  }
  
  public void a(UpgradeTipsDialog paramUpgradeTipsDialog)
  {
    M();
  }
  
  public void a(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if ((a().mAutomator != null) && (a().mAutomator.c()) && (paramVipGiftDownloadInfo != null) && (paramVipGiftDownloadInfo.jdField_d_of_type_Long == 0L) && (paramVipGiftDownloadInfo.jdField_a_of_type_Long != 0L)) {
      paramVipGiftManager.a(paramVipGiftDownloadInfo.jdField_a_of_type_Long);
    }
  }
  
  public void a(@androidx.annotation.NonNull List<RecentBaseData> paramList)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          return;
        }
        i4 = QCallFacade.a(a());
        if (TripleGraySwitchUtil.a(this.jdField_a_of_type_MqqAppAppRuntime.getApp(), "KEY_USE_NEW_COUNT"))
        {
          paramList = paramList.iterator();
          i1 = 0;
          if (!paramList.hasNext()) {
            break label214;
          }
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
          if ((localRecentBaseData == null) || (!localRecentBaseData.isUnreadMsgNumInTabNum()) || (RecentAdapter.a(a(), localRecentBaseData))) {
            continue;
          }
          i1 += localRecentBaseData.getUnreadNum();
          continue;
        }
        paramList = a().getMessageFacade();
        if (paramList == null) {
          break label225;
        }
        i1 = paramList.b();
      }
      catch (Throwable paramList)
      {
        int i4;
        paramList.printStackTrace();
      }
      this.jdField_d_of_type_Int = (i1 + i4);
      if (QLog.isColorLevel())
      {
        QLog.d("fetchUnReadCount", 2, String.format("Conversation, mUnReadCount[%s], msgUnReadCount[%s], callUnReadCount[%s], isCallTabShow[%s],msgUnReadCountNew[%s]", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(i1), Integer.valueOf(i4), Boolean.valueOf(a().isCallTabShow), Integer.valueOf(i2) }));
        return;
      }
      return;
      label214:
      int i3 = i1;
      int i2 = i1;
      int i1 = i3;
      continue;
      label225:
      i1 = 0;
      i2 = 0;
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
    if ((localObject != null) && (this.jdField_f_of_type_Boolean))
    {
      this.jdField_f_of_type_Boolean = false;
      ((FPSSwipListView)localObject).springBackOverScrollHeaderView();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if (localObject != null) {
      ((RecentAdapter)localObject).b(a());
    }
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(PushBannerProcessor.jdField_a_of_type_Int, 0, null);
    RecentDataListManager.a().a();
    TianShuManager.getInstance().clearNecessaryDataCacheForReport();
    TianShuManager.setLastClickAdTraceInfo("", "");
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl;
    if (localObject != null) {
      ((ConversationHotChatCtrl)localObject).a(paramLogoutReason);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
    if (localObject != null) {
      ((ConversationHongBaoV2)localObject).a(paramLogoutReason);
    }
    paramLogoutReason = this.jdField_a_of_type_AndroidAppDialog;
    if ((paramLogoutReason != null) && (paramLogoutReason.isShowing()) && (!this.jdField_g_of_type_Boolean)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      label143:
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1073);
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
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    this.A = false;
    a().isConversationTabShow = true;
    this.jdField_e_of_type_Boolean = true;
    this.v = paramBoolean;
    MayknowRecommendManager.jdField_e_of_type_Boolean = true;
    ae();
    super.a(paramBoolean);
    if (AppSetting.jdField_d_of_type_Boolean) {
      a().setTitle(a(2131693875));
    }
    Y();
    TimeManager.a().c();
    SearchBarAssistant localSearchBarAssistant = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant;
    if (localSearchBarAssistant != null) {
      localSearchBarAssistant.a();
    }
    if (AppSetting.jdField_i_of_type_Boolean) {
      a().setMainActivityState(true);
    }
    try
    {
      a().getWindow().setSoftInputMode(32);
    }
    catch (Exception localException)
    {
      QLog.e("Q.recent", 1, localException, new Object[0]);
    }
    ArkTipsManager.a().c();
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_i_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Long != 1000L) {
        this.jdField_a_of_type_Long = 1000L;
      }
      if (!this.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1020);
      }
      if (this.jdField_h_of_type_Boolean)
      {
        RecentAdapter localRecentAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
        if (localRecentAdapter != null) {
          localRecentAdapter.notifyDataSetChanged();
        }
      }
      a(0L);
      l();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1030, 1000L);
    }
    else
    {
      if (!this.y)
      {
        this.y = true;
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1067, 1000L);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1025, 3000L);
    }
    ag();
    ah();
    ak();
    av();
    ad();
    aj();
    af();
    f();
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 5000L);
    a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
    ImaxAdRecentUserManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).setHasPreloadWebProcessor(false);
    Z();
    k(paramBoolean);
    ApngImage.playByTag(2);
    ac();
    al();
    ab();
    aa();
    DarkModeManager.a(null);
    l(paramBoolean);
    UpComingMsgUtil.a((BaseActivity)a(), paramBoolean);
  }
  
  public boolean a()
  {
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.w();
      return true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback;
    if ((localObject != null) && (((SpringFestivalTaskCallback)localObject).c())) {
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localObject != null)
    {
      View localView = this.jdField_d_of_type_AndroidViewView;
      if (localView != null)
      {
        ((DragFrameLayout)localObject).removeView(localView);
        this.jdField_d_of_type_AndroidViewView = null;
        localObject = (PortalManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_PORTAL);
        if (localObject != null) {
          ((PortalManager)localObject).a(a(), false);
        }
        return true;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
    if ((localObject != null) && (((MiniAppPullInterface)localObject).isMiniAppLauncherOpened()))
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface.hideMiniAppEntry(0);
      return true;
    }
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    boolean bool = Foreground.isCurrentProcessForeground();
    if ((paramMessage.arg1 == 4) && (e())) {
      return true;
    }
    if (((this.jdField_e_of_type_Boolean) || (paramMessage.arg1 != 0)) && (this.jdField_a_of_type_MqqAppAppRuntime.isLogin()) && (bool)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, new Object[] { "isRefreshRecentDataNecessary[isForeground:", Boolean.valueOf(this.jdField_e_of_type_Boolean), ",msg.arg1:", Integer.valueOf(paramMessage.arg1), " msg.arg2", Integer.valueOf(paramMessage.arg2), ",isLogin:", Boolean.valueOf(this.jdField_a_of_type_MqqAppAppRuntime.isLogin()), " ,isProcessForeground=", Boolean.valueOf(bool) });
    }
    return false;
  }
  
  public boolean a(VipGiftManager paramVipGiftManager, VipGiftDownloadInfo paramVipGiftDownloadInfo)
  {
    if (paramVipGiftDownloadInfo != null)
    {
      if (paramVipGiftManager == null) {
        return false;
      }
      if (paramVipGiftDownloadInfo.jdField_d_of_type_Long == 3L) {
        paramVipGiftManager.a(4L, paramVipGiftDownloadInfo.jdField_a_of_type_Long);
      }
      if ((paramVipGiftDownloadInfo != null) && (paramVipGiftDownloadInfo.jdField_d_of_type_Long == 2L) && (a().mAutomator.c()) && (this.u)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)
    {
      if (this.jdField_f_of_type_Boolean) {
        return true;
      }
      paramListView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (paramListView != null) {
        paramListView.a(0L);
      }
      boolean bool2 = a().getMsgHandler().d() ^ true;
      paramListView = (SpringFestivalEntryManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      boolean bool1 = bool2;
      if (paramListView != null)
      {
        bool1 = bool2;
        if (paramListView.d())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "handlePullRefresh fakeRefresh for 2021HB");
          }
          bool1 = true;
        }
      }
      if (bool1)
      {
        this.jdField_f_of_type_Boolean = true;
        e(true);
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(40001, 500L);
        return true;
      }
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      StartupTracker.a("Conversation_PullToRefresh_start", 0L);
      o();
      ThreadManager.getSubThreadHandler().post(new Conversation.9(this));
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
      paramListView = this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
      if (paramListView != null) {
        paramListView.handlePullRefresh();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1054);
      a(3002, 200L, true, "vas_banner_pull_refresh");
      a(1072, 500L, true);
      a(500, "tianshu_req_splash_type_pull_down", true);
      a(500, "tianshu_req_renewals_type_pull_down");
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "send MSG_CHECK_MEDAL_GUIDE");
      }
    }
    return true;
  }
  
  public void ab_()
  {
    QLog.d("Q.recent", 2, "onPause...");
    ApngImage.pauseByTag(2);
    super.ab_();
    this.jdField_e_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
    if (localObject != null) {
      ((ConversationHongBaoV2)localObject).l();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback;
    if (localObject != null) {
      ((SpringFestivalTaskCallback)localObject).c();
    }
    if (jdField_b_of_type_Long > 0L)
    {
      jdField_b_of_type_Long = 0L;
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).setResumeFlagFromConversation(jdField_b_of_type_Long);
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).saveNormalEnterConversationTime(jdField_b_of_type_Long);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1053);
    this.H = false;
    com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConstants.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    if (AppSetting.jdField_i_of_type_Boolean) {
      a().setMainActivityState(false);
    }
    TimeManager.a().b();
    if ((!this.A) && (!this.B) && (RecentParcelUtil.a(a())))
    {
      if (System.currentTimeMillis() - this.jdField_h_of_type_Long > 5000L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
        QQAppInterface localQQAppInterface = a();
        ThreadManager.getSubThreadHandler().post(new Conversation.2(this, localQQAppInterface, (List)localObject));
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "just switch account, don't save RU");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "enter AIO or switching account, don't save RU");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
    if (localObject != null)
    {
      if (((FPSSwipListView)localObject).getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.hideCurShowingRightView();
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(10000);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1070);
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(10);
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9);
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(8);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar;
    if (localObject != null) {
      ((RecentOptPopBar)localObject).i();
    }
    a().isConversationTabShow = false;
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).handConversationToHide();
    localObject = this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
    if (localObject != null) {
      ((PreloadProcHitSession)localObject).d();
    }
    localObject = this.jdField_c_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
    if (localObject != null) {
      ((PreloadProcHitSession)localObject).d();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    QZoneReport.jdField_a_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
    if (localObject != null) {
      ((MsgTabStoryNodeListManager)localObject).l();
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).leaveMsgTab();
    PublicAccountEventReport.a();
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
  
  protected void b(long paramLong)
  {
    TroopVideoManager localTroopVideoManager = (TroopVideoManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_VIDEO_MANAGER);
    if (localTroopVideoManager != null) {
      localTroopVideoManager.a(paramLong);
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
        Object localObject = this.jdField_a_of_type_JavaLangStringBuilder;
        if (localObject == null) {
          this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        } else {
          ((StringBuilder)localObject).setLength(0);
        }
        localObject = new ArrayList();
        ((List)localObject).addAll(paramList);
        this.jdField_a_of_type_JavaLangStringBuilder.append("unreadinfo, [");
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)paramList.next();
          if ((localRecentBaseData != null) && (localRecentBaseData.mUnreadNum > 0))
          {
            StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
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
        this.jdField_a_of_type_JavaLangStringBuilder.append("]");
        ((List)localObject).clear();
        QLog.i("Q.recent", 2, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    c(true);
    this.B = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      if (this.jdField_e_of_type_Boolean)
      {
        this.C = true;
        ax();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    ConversationTitleBtnCtrl localConversationTitleBtnCtrl = this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl;
    if (localConversationTitleBtnCtrl != null) {
      localConversationTitleBtnCtrl.d();
    }
  }
  
  public View c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_c_of_type_AndroidViewView;
  }
  
  public void c()
  {
    super.c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar;
    if ((localObject != null) && (((RecentOptPopBar)localObject).a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
    if (localObject != null) {
      ((PreloadProcHitSession)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper;
    if (localObject != null) {
      ((LoginwelcomeHelper)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
    if (localObject != null) {
      ((MiniAppPullInterface)localObject).onStop();
    }
  }
  
  /* Error */
  protected void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 618	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +36 -> 39
    //   6: new 527	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 528	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc_w 3798
    //   18: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: iload_1
    //   24: invokevirtual 537	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc_w 539
    //   31: iconst_2
    //   32: aload_2
    //   33: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 546	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload_0
    //   40: getfield 585	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +18 -> 63
    //   48: aload_2
    //   49: invokevirtual 3801	com/tencent/mobileqq/fpsreport/FPSSwipListView:getScrollY	()I
    //   52: ifge +11 -> 63
    //   55: aload_0
    //   56: getfield 585	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   59: iconst_0
    //   60: invokevirtual 3804	com/tencent/mobileqq/fpsreport/FPSSwipListView:setScrollY	(I)V
    //   63: aload_0
    //   64: iconst_0
    //   65: invokespecial 3806	com/tencent/mobileqq/activity/home/Conversation:j	(Z)V
    //   68: iload_1
    //   69: ifeq +491 -> 560
    //   72: invokestatic 740	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   75: invokevirtual 3807	com/tencent/mobileqq/managers/LoadingStateManager:a	()V
    //   78: invokestatic 959	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()Lcom/tencent/mobileqq/activity/recent/RecentDataListManager;
    //   81: invokevirtual 3525	com/tencent/mobileqq/activity/recent/RecentDataListManager:a	()V
    //   84: invokestatic 3528	cooperation/vip/tianshu/TianShuManager:getInstance	()Lcooperation/vip/tianshu/TianShuManager;
    //   87: invokevirtual 3531	cooperation/vip/tianshu/TianShuManager:clearNecessaryDataCacheForReport	()V
    //   90: ldc_w 656
    //   93: ldc_w 656
    //   96: invokestatic 1661	cooperation/vip/tianshu/TianShuManager:setLastClickAdTraceInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 175	com/tencent/mobileqq/activity/home/Conversation:jdField_f_of_type_Boolean	Z
    //   103: ifeq +21 -> 124
    //   106: aload_0
    //   107: getfield 585	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +12 -> 124
    //   115: aload_0
    //   116: iconst_0
    //   117: putfield 175	com/tencent/mobileqq/activity/home/Conversation:jdField_f_of_type_Boolean	Z
    //   120: aload_2
    //   121: invokevirtual 3810	com/tencent/mobileqq/fpsreport/FPSSwipListView:hideOverScrollHeaderView	()V
    //   124: aload_0
    //   125: getfield 758	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   128: astore_2
    //   129: aload_2
    //   130: ifnull +23 -> 153
    //   133: aload_2
    //   134: invokevirtual 3811	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   137: goto +11 -> 148
    //   140: astore_2
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 758	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   146: aload_2
    //   147: athrow
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield 758	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog	Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   153: aload_0
    //   154: getfield 764	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +23 -> 182
    //   162: aload_2
    //   163: invokevirtual 772	android/app/Dialog:dismiss	()V
    //   166: goto +11 -> 177
    //   169: astore_2
    //   170: aload_0
    //   171: aconst_null
    //   172: putfield 764	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   175: aload_2
    //   176: athrow
    //   177: aload_0
    //   178: aconst_null
    //   179: putfield 764	com/tencent/mobileqq/activity/home/Conversation:jdField_c_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   182: aload_0
    //   183: getfield 2543	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentConversationHelper	Lcom/tencent/mobileqq/activity/recent/ConversationHelper;
    //   186: astore_2
    //   187: aload_2
    //   188: ifnull +11 -> 199
    //   191: aload_2
    //   192: aload_0
    //   193: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   196: invokevirtual 3813	com/tencent/mobileqq/activity/recent/ConversationHelper:a	(Lcom/tencent/common/app/business/BaseQQAppInterface;)V
    //   199: aload_0
    //   200: getfield 937	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant	Lcom/tencent/mobileqq/activity/contacts/base/SearchBarAssistant;
    //   203: astore_2
    //   204: aload_2
    //   205: ifnull +11 -> 216
    //   208: aload_2
    //   209: aload_0
    //   210: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   213: invokevirtual 3814	com/tencent/mobileqq/activity/contacts/base/SearchBarAssistant:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   216: aload_0
    //   217: getfield 1904	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption	Lcom/tencent/mobileqq/activity/recent/RecentTroopMenuOption;
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +11 -> 233
    //   225: aload_2
    //   226: aload_0
    //   227: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   230: invokevirtual 3815	com/tencent/mobileqq/activity/recent/RecentTroopMenuOption:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   233: aload_0
    //   234: getfield 548	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   237: astore_2
    //   238: aload_2
    //   239: ifnull +22 -> 261
    //   242: aload_2
    //   243: aload_0
    //   244: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   247: invokevirtual 3816	com/tencent/mobileqq/activity/recent/RecentAdapter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   250: aload_0
    //   251: iconst_1
    //   252: bipush 10
    //   254: lconst_0
    //   255: invokestatic 569	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   258: invokevirtual 572	com/tencent/mobileqq/activity/home/Conversation:a	(IILjava/lang/Object;)V
    //   261: aload_0
    //   262: getfield 585	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   265: astore_2
    //   266: aload_2
    //   267: ifnull +8 -> 275
    //   270: aload_2
    //   271: iconst_0
    //   272: invokevirtual 3819	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   275: aload_0
    //   276: iconst_0
    //   277: invokespecial 1838	com/tencent/mobileqq/activity/home/Conversation:i	(Z)V
    //   280: aload_0
    //   281: getfield 2158	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager	Lcom/tencent/biz/qqstory/msgTabNode/view/MsgTabStoryNodeListManager;
    //   284: astore_2
    //   285: aload_2
    //   286: ifnull +11 -> 297
    //   289: aload_2
    //   290: aload_0
    //   291: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   294: invokevirtual 3820	com/tencent/biz/qqstory/msgTabNode/view/MsgTabStoryNodeListManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   297: aload_0
    //   298: getfield 1300	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface	Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   301: astore_2
    //   302: aload_2
    //   303: ifnull +13 -> 316
    //   306: aload_2
    //   307: aload_0
    //   308: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   311: invokeinterface 3823 2 0
    //   316: aload_0
    //   317: getfield 589	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_CooperationVipAdTianshuAdManager	Lcooperation/vip/ad/TianshuAdManager;
    //   320: astore_2
    //   321: aload_2
    //   322: ifnull +11 -> 333
    //   325: aload_2
    //   326: aload_0
    //   327: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   330: invokevirtual 3824	cooperation/vip/ad/TianshuAdManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   333: aload_0
    //   334: getfield 1995	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_CooperationVipAdTianshuSplashManager	Lcooperation/vip/ad/TianshuSplashManager;
    //   337: astore_2
    //   338: aload_2
    //   339: ifnull +11 -> 350
    //   342: aload_2
    //   343: aload_0
    //   344: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: invokevirtual 3825	cooperation/vip/ad/TianshuSplashManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   350: aload_0
    //   351: getfield 213	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback	Lcom/tencent/mobileqq/activity/springfestival/entry/SpringFestivalTaskCallback;
    //   354: astore_2
    //   355: aload_2
    //   356: ifnull +11 -> 367
    //   359: aload_2
    //   360: aload_0
    //   361: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   364: invokevirtual 3826	com/tencent/mobileqq/activity/springfestival/entry/SpringFestivalTaskCallback:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   367: ldc_w 539
    //   370: ldc_w 3828
    //   373: aload_0
    //   374: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   377: getfield 1156	com/tencent/mobileqq/app/QQAppInterface:mAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   380: invokevirtual 1159	com/tencent/mobileqq/app/automator/Automator:b	()Z
    //   383: invokestatic 1215	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   386: invokestatic 3833	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   389: aload_0
    //   390: sipush 1055
    //   393: lconst_0
    //   394: iconst_0
    //   395: invokevirtual 797	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   398: aload_0
    //   399: getfield 949	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqBannerBannerManager	Lcom/tencent/mobileqq/banner/BannerManager;
    //   402: astore_2
    //   403: aload_2
    //   404: ifnull +7 -> 411
    //   407: aload_2
    //   408: invokevirtual 3834	com/tencent/mobileqq/banner/BannerManager:a	()V
    //   411: aload_0
    //   412: getfield 194	com/tencent/mobileqq/activity/home/Conversation:jdField_i_of_type_Boolean	Z
    //   415: ifeq +13 -> 428
    //   418: aload_0
    //   419: getfield 1228	com/tencent/mobileqq/activity/home/Conversation:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   422: bipush 12
    //   424: invokevirtual 563	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   427: pop
    //   428: aload_0
    //   429: getfield 801	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   432: getfield 1032	com/tencent/mobileqq/app/FrameHelperActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   435: iconst_4
    //   436: invokevirtual 2686	android/os/Handler:sendEmptyMessage	(I)Z
    //   439: pop
    //   440: aload_0
    //   441: sipush 1035
    //   444: ldc2_w 2786
    //   447: iconst_0
    //   448: invokevirtual 797	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   451: aload_0
    //   452: getfield 949	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqBannerBannerManager	Lcom/tencent/mobileqq/banner/BannerManager;
    //   455: astore_2
    //   456: aload_2
    //   457: ifnull +54 -> 511
    //   460: aload_2
    //   461: getstatic 952	com/tencent/mobileqq/activity/recent/bannerprocessor/PushBannerProcessor:jdField_a_of_type_Int	I
    //   464: sipush 2000
    //   467: ldc2_w 2786
    //   470: iconst_1
    //   471: invokevirtual 3837	com/tencent/mobileqq/banner/BannerManager:a	(IIJZ)V
    //   474: aload_0
    //   475: getfield 263	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$UICallBack	Lcom/tencent/mobileqq/activity/home/Conversation$UICallBack;
    //   478: astore_2
    //   479: aload_2
    //   480: ifnull +7 -> 487
    //   483: aload_2
    //   484: invokevirtual 3838	com/tencent/mobileqq/activity/home/Conversation$UICallBack:a	()V
    //   487: aload_0
    //   488: sipush 3001
    //   491: lconst_0
    //   492: iconst_1
    //   493: aconst_null
    //   494: invokevirtual 1270	com/tencent/mobileqq/activity/home/Conversation:a	(IJZLjava/lang/String;)V
    //   497: aload_0
    //   498: sipush 3002
    //   501: ldc2_w 2786
    //   504: iconst_1
    //   505: ldc_w 3840
    //   508: invokevirtual 1270	com/tencent/mobileqq/activity/home/Conversation:a	(IJZLjava/lang/String;)V
    //   511: aload_0
    //   512: sipush 500
    //   515: ldc_w 3842
    //   518: iconst_1
    //   519: invokespecial 1275	com/tencent/mobileqq/activity/home/Conversation:a	(ILjava/lang/String;Z)V
    //   522: aload_0
    //   523: sipush 500
    //   526: ldc_w 3844
    //   529: invokespecial 1280	com/tencent/mobileqq/activity/home/Conversation:a	(ILjava/lang/String;)V
    //   532: aload_0
    //   533: aload_0
    //   534: getfield 652	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   537: getstatic 3847	com/tencent/mobileqq/app/QQManagerFactory:VIP_GIF_MANAGER	I
    //   540: invokevirtual 1188	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   543: checkcast 2219	com/tencent/mobileqq/vipgift/VipGiftManager
    //   546: putfield 206	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager	Lcom/tencent/mobileqq/vipgift/VipGiftManager;
    //   549: aload_0
    //   550: invokespecial 3849	com/tencent/mobileqq/activity/home/Conversation:aw	()V
    //   553: aload_0
    //   554: ldc_w 3851
    //   557: invokespecial 1061	com/tencent/mobileqq/activity/home/Conversation:c	(Ljava/lang/String;)V
    //   560: aload_0
    //   561: sipush 10001
    //   564: ldc2_w 3852
    //   567: iconst_0
    //   568: invokevirtual 797	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   571: aload_0
    //   572: getfield 652	com/tencent/mobileqq/activity/home/Conversation:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   575: invokevirtual 2998	mqq/app/AppRuntime:isLogin	()Z
    //   578: ifne +15 -> 593
    //   581: aload_0
    //   582: getfield 194	com/tencent/mobileqq/activity/home/Conversation:jdField_i_of_type_Boolean	Z
    //   585: ifeq +8 -> 593
    //   588: aload_0
    //   589: lconst_0
    //   590: invokevirtual 1993	com/tencent/mobileqq/activity/home/Conversation:a	(J)V
    //   593: aload_0
    //   594: ldc_w 3854
    //   597: ldc2_w 2191
    //   600: iconst_0
    //   601: invokevirtual 797	com/tencent/mobileqq/activity/home/Conversation:a	(IJZ)V
    //   604: ldc_w 2312
    //   607: invokestatic 1308	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   610: checkcast 2312	com/tencent/biz/pubaccount/api/IPublicAccountManager
    //   613: aload_0
    //   614: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   617: invokevirtual 1340	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   620: invokeinterface 3857 2 0
    //   625: getstatic 3860	com/tencent/mobileqq/msgbackup/controller/MsgBackupManager:jdField_g_of_type_Boolean	Z
    //   628: ifeq +13 -> 641
    //   631: invokestatic 3863	com/tencent/mobileqq/msgbackup/controller/MsgBackupManager:a	()Lcom/tencent/mobileqq/msgbackup/controller/MsgBackupManager;
    //   634: aload_0
    //   635: invokevirtual 594	com/tencent/mobileqq/activity/home/Conversation:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   638: invokevirtual 3864	com/tencent/mobileqq/msgbackup/controller/MsgBackupManager:a	(Lcom/tencent/common/app/business/BaseQQAppInterface;)V
    //   641: iload_1
    //   642: ifeq +7 -> 649
    //   645: aload_0
    //   646: invokespecial 2688	com/tencent/mobileqq/activity/home/Conversation:Q	()V
    //   649: invokestatic 3869	com/tencent/mobileqq/activity/qcircle/utils/QCircleUtils:a	()Lcom/tencent/mobileqq/qcircle/api/IQCircleEeveeManangerService;
    //   652: iconst_4
    //   653: aconst_null
    //   654: aconst_null
    //   655: invokeinterface 3875 4 0
    //   660: return
    //   661: astore_2
    //   662: goto -514 -> 148
    //   665: astore_2
    //   666: goto -489 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	669	0	this	Conversation
    //   0	669	1	paramBoolean	boolean
    //   13	121	2	localObject1	Object
    //   140	7	2	localObject2	Object
    //   157	6	2	localDialog	Dialog
    //   169	7	2	localObject3	Object
    //   186	298	2	localObject4	Object
    //   661	1	2	localException1	Exception
    //   665	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   133	137	140	finally
    //   162	166	169	finally
    //   133	137	661	java/lang/Exception
    //   162	166	665	java/lang/Exception
  }
  
  public boolean c()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onDestroy");
    }
    this.jdField_g_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper;
    if (localObject != null) {
      ((RecentPubAccHelper)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localObject != null)
    {
      ((ActionSheet)localObject).setOnButtonClickListener(null);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTipsDialog;
    if (localObject != null) {
      ((UpgradeTipsDialog)localObject).a(null);
    }
    this.o = false;
    TimeManager.a().a();
    X();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl;
    if (localObject != null) {
      ((ConversationHotChatCtrl)localObject).a();
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseSearchBarAssistant;
    if (localObject != null) {
      ((SearchBarAssistant)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if (localObject != null) {
      ((RecentAdapter)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
    if (localObject != null) {
      ((MsgTabStoryNodeListManager)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    if (localObject != null) {
      ((BannerManager)localObject).b(a());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar;
    if (localObject != null) {
      ((CareNotificationBar)localObject).h();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
    if (localObject != null)
    {
      ((FPSSwipListView)localObject).setAdapter(null);
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
      label244:
      break label244;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    localObject = this.jdField_c_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    TroopAssistantManager.a();
    TroopRemindSettingManager.a();
    TroopBarAssistantManager.b();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe;
    if (localObject != null) {
      ((QQSettingMe)localObject).c();
    }
    localObject = this.jdField_d_of_type_AndroidViewView;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.removeView((View)localObject);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper;
    if (localObject != null)
    {
      ((LoginwelcomeHelper)localObject).f();
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper = null;
    }
    an();
    if (this.jdField_e_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl;
    if (localObject != null) {
      ((ConversationTitleBtnCtrl)localObject).g();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
    if (localObject != null) {
      ((MiniAppPullInterface)localObject).onDestroy();
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
        localObject = a().getResources().getDrawable(2130839404);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(5.0F, a()));
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
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
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("LoadingComplete");
    }
  }
  
  protected boolean d()
  {
    int i1 = this.jdField_a_of_type_Int;
    return (i1 != 0) && (i1 != 1);
  }
  
  public void e()
  {
    super.e();
    k();
  }
  
  public void e(boolean paramBoolean)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(NetStateBannerProcessor.jdField_a_of_type_Int);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(IllegalNetworkBannerProcessor.jdField_a_of_type_Int);
    if (paramBoolean)
    {
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(4);
      this.jdField_c_of_type_MqqOsMqqHandler.removeMessages(3);
    }
    if ((!bool1) && (!bool2))
    {
      int i1 = LoadingStateManager.a().a();
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
            if (this.jdField_c_of_type_MqqOsMqqHandler.hasMessages(3)) {
              break label158;
            }
            this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 180000L);
          }
        }
        else
        {
          d(true);
          if (this.jdField_c_of_type_MqqOsMqqHandler.hasMessages(4)) {
            break label158;
          }
          this.jdField_c_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(4, 180000L);
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
    ConversationTitleBtnCtrl localConversationTitleBtnCtrl = this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl;
    if (localConversationTitleBtnCtrl != null) {
      localConversationTitleBtnCtrl.c(paramBoolean);
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "conversation onPostThemeChanged");
    }
    if ((!ThemeUtil.isDefaultTheme()) && (this.z))
    {
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).setBackgroundResource(2130850682);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131366333).setBackgroundResource(2130850694);
        this.z = false;
      }
    }
    x();
    al();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe;
    if (localObject != null) {
      ((QQSettingMe)localObject).d();
    }
    i();
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a("ThemeChanged");
    localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
    if (localObject != null) {
      ((ConversationHongBaoV2)localObject).p();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar;
    if (localObject != null) {
      ((CareNotificationBar)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
    if (localObject != null) {
      ((MsgTabStoryNodeListManager)localObject).i();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
    if (localObject != null) {
      ((MiniAppPullInterface)localObject).onPostThemeChanged();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    if (localObject != null) {
      ((BannerManager)localObject).a(-1, null);
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
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
      if (localObject != null) {
        ((MsgTabStoryNodeListManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
      if (localObject != null) {
        ((MiniAppPullInterface)localObject).initLater(this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame);
      }
    }
  }
  
  protected void h()
  {
    X();
    v();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    if (localObject != null) {
      ((BannerManager)localObject).a(a());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localObject != null)
    {
      View localView = this.jdField_d_of_type_AndroidViewView;
      if (localView != null)
      {
        ((DragFrameLayout)localObject).removeView(localView);
        this.jdField_d_of_type_AndroidViewView = null;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2;
    if (localObject != null) {
      ((ConversationHongBaoV2)localObject).g();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134065);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134061);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134062);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1134068);
    QZoneReport.a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar;
    if (localObject != null) {
      ((RecentOptPopBar)localObject).jdField_a_of_type_Boolean = true;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper;
    if (localObject != null) {
      ((RecentPubAccHelper)localObject).a(a());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginwelcomeHelper;
    if (localObject != null) {
      ((LoginwelcomeHelper)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl;
    if (localObject != null) {
      ((ConversationTitleBtnCtrl)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl;
    if (localObject != null) {
      ((ConversationQbossBannerTitleEntranceCtrl)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar;
    if (localObject != null) {
      ((CareNotificationBar)localObject).a((BaseActivity)a());
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
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((!this.jdField_g_of_type_Boolean) && (a() != null))
    {
      if (a().isFinishing()) {
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
                aq();
                break;
              case 11: 
                c(paramMessage);
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
                this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1044, 0, 0, null).sendToTarget();
                break;
              }
            } else {
              ap();
            }
          }
          else
          {
            paramMessage = (StoryHaloManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STORY_HALO_MANAGER);
            paramMessage.a(2, paramMessage.a(RecentDataListManager.a().jdField_a_of_type_JavaUtilList));
          }
        }
        else {
          ao();
        }
      }
      else {
        j(true);
      }
      TraceUtils.traceEnd();
    }
    return true;
  }
  
  public void i()
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
    else
    {
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850433);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167053));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getColorStateList(2131167053));
    }
    SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "clearStatusBarBg");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
  }
  
  public void k()
  {
    Object localObject;
    if (SystemClock.uptimeMillis() - MsgTabStoryNodeListManager.jdField_b_of_type_Long > 500L)
    {
      J();
      if (this.u)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
        if (((localObject instanceof HongBaoListView)) && (((HongBaoListView)localObject).mEnableStory) && (((HongBaoListView)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView).mForStory))
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
          if (localObject != null) {
            ((MsgTabStoryNodeListManager)localObject).h();
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqMiniEntryMiniAppPullInterface;
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
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void l()
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
  
  public void m()
  {
    a(1068, 0L, true);
  }
  
  public void n()
  {
    a(1069, 0L, true);
  }
  
  public void o()
  {
    if (a().getCurrentAccountUin() != null)
    {
      MqqHandler localMqqHandler = this.jdField_b_of_type_MqqOsMqqHandler;
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1058);
      }
      this.jdField_f_of_type_Boolean = true;
      L();
      e(true);
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(NetStateBannerProcessor.jdField_a_of_type_Int);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(IllegalNetworkBannerProcessor.jdField_a_of_type_Int);
      if ((!bool1) && (!bool2))
      {
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).canFreeTimeRefreshPush()) {
          ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportManualRefresMsg();
        }
        a().mAutomator.c();
        c(60000L);
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "msg_tab", "refresh_tab", 0, 0, "", "", "", "");
        return;
      }
      c(800L);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar;
      RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      ((RecentOptPopBar)localObject).a(localRelativeLayout, localRelativeLayout.getWidth() - a().getDimensionPixelSize(2131298897) - a().getDimensionPixelSize(2131298898), a().getDimensionPixelSize(2131298899));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
      if ((localObject != null) && ((localObject instanceof MainFragment))) {
        ((MainFragment)localObject).l();
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
      StoryReportor.a("plus_shoot", "exp_entry", 0, 0, new String[] { "", "", "", "" });
      aw();
      SafeModeUtil.e();
      this.A = true;
    }
    else if ((paramView == this.jdField_b_of_type_AndroidWidgetImageView) || (paramView == this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch))
    {
      long l1 = System.currentTimeMillis();
      if (Math.abs(l1 - jdField_i_of_type_Long) < 500L) {
        jdField_i_of_type_Long = l1;
      } else {
        jdField_i_of_type_Long = l1;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    StoryHaloManager localStoryHaloManager = (StoryHaloManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STORY_HALO_MANAGER);
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
    if (paramView.getId() == 2131363840)
    {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Two_call", "Two_call_find", 0, 0, "", "", "", "");
      paramView = new Intent(a(), ForwardRecentActivity.class);
      paramView.putExtra("forward_type", 13);
      a(paramView);
      return;
    }
    if ((paramView.getId() != 2131367227) && (paramView.getId() != 2131367229) && (paramView.getId() != 2131367230) && (paramView.getId() != 2131367231) && (paramView.getId() != 2131367232) && (paramView.getId() != 2131367233) && (paramView.getId() != 2131367234))
    {
      if ((paramView.getId() == 2131369511) && (localStoryHaloManager.b(paramObject))) {
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
      paramObject = ContactUtils.f(a(), paramView);
      ChatActivityUtils.a(a(), a(), 0, paramView, paramObject, null, true, null, true, true, null, null);
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView) {}
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = a();
    int i1 = paramRecentBaseData.getRecentUserType();
    if (((i1 == 1) || (i1 == 5000)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption == null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption = new RecentTroopMenuOption(a(), (BaseActivity)a());
    }
    if (Utils.a(paramString1, localResources.getString(2131691260)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
    }
    else if (Utils.a(paramString1, localResources.getString(2131691263)))
    {
      a(i1, paramRecentBaseData, paramString2, true);
    }
    else if (Utils.a(paramString1, localResources.getString(2131693067)))
    {
      a(i1, paramRecentBaseData, paramString2, false);
      if (i1 == 3000) {
        new ReportTask(a()).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_unstick").a();
      }
    }
    else if (Utils.a(paramString1, localResources.getString(2131693069)))
    {
      a(i1, paramRecentBaseData, paramString2, true);
      if (i1 == 3000) {
        new ReportTask(a()).a("dc00899").b("Grp_Dis_set").c("msgTab").d("Clk_stick").a();
      }
    }
    else if (Utils.a(paramString1, localResources.getString(2131694335)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccHelper.a(a(), paramRecentBaseData, a());
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", paramRecentBaseData.getRecentUserUin(), "0X800991D", "0X800991D", 0, 0, "", "", "", "");
    }
    if (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[4])))
    {
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = (RecentUserBaseData)paramRecentBaseData;
        RecentUtil.a(a(), paramString1.a(), true, true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "1", "", paramString2, "");
      return;
    }
    if (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[5])))
    {
      if ((paramRecentBaseData instanceof RecentItemTempMsgBoxData)) {
        ((ITempMsgBoxManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(false);
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString1 = ((RecentUserBaseData)paramRecentBaseData).a();
        a().getConversationFacade().a(paramString1.uin, paramString1.getType(), 1);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1009);
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X800568B", "0X800568B", 0, 0, "0", "", paramString2, "");
    }
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (paramView != null)
      {
        if (this.jdField_f_of_type_Boolean)
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
    if (this.jdField_d_of_type_Boolean)
    {
      if (a(paramView, paramRecentBaseData)) {
        return;
      }
      this.A = true;
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
      else
      {
        paramView = null;
      }
      int i1 = RecentUtil.a(a(), a(), paramView, paramString, paramBoolean, 0, paramRecentBaseData);
      a(paramRecentBaseData, paramView, i1);
      a(i1, paramView);
      if (paramRecentBaseData != null)
      {
        RecentReportHelper.b(a(), paramRecentBaseData, paramView);
        paramRecentBaseData.clearUnReadNum();
        NotifyIdManager.a(a()).b(paramRecentBaseData.getRecentUserUin());
        this.jdField_h_of_type_Boolean = true;
      }
      StartupTracker.a("AIO_Click_cost", null);
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    Object localObject;
    if (this.jdField_d_of_type_Boolean)
    {
      paramString = null;
      int i1 = -1;
      if ((paramRecentBaseData instanceof RecentItemTempMsgBoxData)) {
        com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConstants.jdField_a_of_type_Boolean = false;
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
    else
    {
      localObject = (QCallFacade)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if ((localObject == null) || (paramRecentBaseData == null)) {}
    }
    try
    {
      ((QCallFacade)localObject).b(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
    }
    catch (Exception localException)
    {
      label120:
      break label120;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.recent", 2, "delRecentCallByUin Error");
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Two_call", "Tc_msg_delete", 0, 0, "", "", "", "");
    if ((paramRecentBaseData != null) && (paramString != null) && (paramString.equalsIgnoreCase("2"))) {
      if (paramRecentBaseData.getRecentUserType() == 3000) {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004F8F", "0X8004F8F", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004F88", "0X8004F88", 0, 0, "", "", "", "");
      }
    }
    a(0L);
  }
  
  public void onRightIconMenuHide(View paramView) {}
  
  public void onRightIconMenuShow(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if (localObject == null) {
      return;
    }
    localObject = ((RecentAdapter)localObject).a(paramView);
    if ((localObject != null) && ("9970".equals(((RecentBaseData)localObject).getRecentUserUin()))) {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Swip_Shopfoldertoleft", 0, 0, "", "", "", "");
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
      ThreadManager.executeOnSubThread(new Conversation.5(this, i1, i2, i3));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_i_of_type_Int != paramInt1)
    {
      long l1 = SystemClock.elapsedRealtime();
      double d1 = l1 - this.jdField_g_of_type_Long;
      Double.isNaN(d1);
      d1 = 1.0D / d1 * 1000.0D;
      boolean bool;
      if (paramInt1 > this.jdField_i_of_type_Int) {
        bool = true;
      } else {
        bool = false;
      }
      this.x = bool;
      this.jdField_i_of_type_Int = paramInt1;
      this.jdField_g_of_type_Long = l1;
      if (QLog.isDebugVersion())
      {
        String str = RecentDataListManager.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onScroll:");
        localStringBuilder.append(d1);
        localStringBuilder.append(" for Direction:");
        localStringBuilder.append(this.x);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (d1 <= 25.0D) {
        at();
      } else {
        DynamicFaceDrawable.a(a());
      }
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
      paramAbsListView = (AbsListView.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      if ((paramAbsListView != null) && (paramAbsListView.height != paramInt2))
      {
        paramAbsListView.height = paramInt2;
        this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramAbsListView);
      }
    }
    if (paramInt1 == 0)
    {
      this.G = false;
      this.jdField_j_of_type_Long = -1L;
    }
    if ((this.G) && (SystemClock.elapsedRealtime() - this.jdField_j_of_type_Long > 800L))
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setSelection(0);
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("onScroll cost time is below 1000 ms, isScroll2TopFlag: ");
        paramAbsListView.append(this.G);
        paramAbsListView.append(", startScrollTime: ");
        paramAbsListView.append(this.jdField_j_of_type_Long);
        QLog.d("Conversation", 2, paramAbsListView.toString());
      }
      this.G = false;
      this.jdField_j_of_type_Long = -1L;
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
    if (AppSetting.k)
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
      this.E = true;
      ApngImage.pauseByTag(2);
    }
    else
    {
      this.E = false;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (paramAbsListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager;
      if (localObject != null) {
        ((MsgTabStoryNodeListManager)localObject).b(paramInt);
      }
      if ((paramInt != 0) && (paramInt != 1))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
        if (localObject != null)
        {
          ((RecentAdapter)localObject).a(true);
          ThreadPriorityManager.a(true);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
      {
        int i1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
        int i2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
        int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount();
        int i4 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount();
        this.jdField_b_of_type_Int = Math.max(i1, -1);
        while ((i1 >= 0) && (i1 < i4) && (i1 <= i2 - i3))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1);
          if ((localObject instanceof RecentBaseData))
          {
            localObject = (RecentBaseData)localObject;
            if ((((RecentBaseData)localObject).isUnreadMsgNumInTabNum()) && (((RecentBaseData)localObject).getUnreadNum() > 0))
            {
              this.jdField_b_of_type_Int = i1;
              break;
            }
          }
          i1 += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
        ThreadPriorityManager.a(false);
      }
      if (paramInt == 0)
      {
        at();
        DropFrameMonitor.a().a("list_conv", false);
        ThreadRegulator.a().b(2);
        a(paramAbsListView);
        ImaxAdRecentUserManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView);
        m(false);
        am();
        y();
        w();
      }
      else
      {
        DropFrameMonitor.a().a("list_conv");
        ThreadRegulator.a().a(2);
      }
    }
    if ((!this.E) && (this.F))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Conversation", 2, "onScrollStateChanged call with msg incoming");
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(10);
      this.F = false;
    }
    if (paramInt == 0)
    {
      if (this.jdField_h_of_type_Boolean) {
        a(100L);
      }
      ApngImage.playByTag(2);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    if (localObject != null) {
      ((BannerManager)localObject).b(this.E);
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).onScrollStateChanged(paramAbsListView, paramInt);
    PublicAccountEventReport.a(a(), paramAbsListView, paramInt);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if ((paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView) && (!this.jdField_f_of_type_Boolean))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (paramView != null) {
        paramView.b(0L);
      }
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format("onViewCompleteVisableAndReleased %s", new Object[] { Boolean.valueOf(this.jdField_f_of_type_Boolean) }));
    }
    return a(paramListView);
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void p()
  {
    if ((!this.jdField_i_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      E();
      StartupTracker.a("Recent_Start", null);
      return;
    }
    if (this.jdField_i_of_type_Boolean) {
      a(1030, 0L, true);
    }
  }
  
  public void q()
  {
    this.jdField_e_of_type_Boolean = true;
    if (SetSplash.c())
    {
      a(new Conversation.14(this));
      return;
    }
    p();
  }
  
  public void r()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversationTitleBtnCtrl;
    if (localObject != null) {
      ((ConversationTitleBtnCtrl)localObject).b(false);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversationQbossBannerTitleEntranceCtrl;
    if (localObject != null) {
      ((ConversationQbossBannerTitleEntranceCtrl)localObject).b(false);
    }
  }
  
  public void s()
  {
    for (;;)
    {
      try
      {
        if ((!this.k) && (!this.jdField_g_of_type_Boolean))
        {
          this.k = true;
          Object localObject1 = (BaseActivity)a();
          LayoutInflater localLayoutInflater = LayoutInflater.from((Context)localObject1);
          Object localObject3;
          try
          {
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559642, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false));
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar = new RecentOptPopBar((BaseActivity)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a("KEY_SHOT_REDTOUCH_TIME", System.currentTimeMillis());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
              continue;
            }
            QQSettingMe.a("d_common", 2131561454);
            QQSettingMe.a("d_lovespace", 2131561456);
            QQSettingMe.a("d_profile_bubble", 2131561457);
            localObject1 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(2131561452, null);
            this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe((BaseActivity)a(), a(), (ViewGroup)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a(new Conversation.19(this));
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
              localObject1 = "not in main thread ";
              this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = null;
              this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = null;
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar = null;
              this.k = false;
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
            ((HashMap)localObject1).put("device_mode", DeviceInfoUtil.d());
            ((HashMap)localObject1).put("manufacturer", Build.MANUFACTURER);
            StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
            localObject3 = a().getCurrentAccountUin();
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
              break label424;
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
          this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
          this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager = ((VipGiftManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.VIP_GIF_MANAGER));
        }
        else
        {
          return;
        }
      }
      finally {}
      label424:
      long l1 = 1L;
    }
  }
  
  public void t()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar;
    int i1;
    if ((localObject != null) && (((RecentOptPopBar)localObject).a("KEY_SHOT_FIRST_GUIDE_TIP"))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if ((localObject != null) && (((TextView)localObject).getVisibility() == 0))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((RelativeLayout)a(2131376809)).removeView(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_AndroidWidgetTextView = null;
      }
    }
  }
  
  void u()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      if (!this.jdField_i_of_type_Boolean) {
        return;
      }
      if (!((EcShopAssistantManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).b()) {
        return;
      }
      int i3 = 0;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
      int i2 = i3;
      if (localObject != null)
      {
        i2 = i3;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
        {
          int i1 = ((FPSSwipListView)localObject).getFirstVisiblePosition();
          for (;;)
          {
            i2 = i3;
            if (i1 > this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition()) {
              break;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i1) instanceof RecentItemEcShopAssitant))
            {
              i2 = 1;
              break;
            }
            i1 += 1;
          }
        }
      }
      if ((i2 != 0) && (((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).preloadWebProcess(a())))
      {
        localObject = this.jdField_b_of_type_ComTencentMobileqqHitratePreloadProcHitSession;
        if (localObject != null) {
          ((PreloadProcHitSession)localObject).a();
        }
      }
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
    View localView = this.jdField_e_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() != 8)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  void w()
  {
    if ((this.o) && (((MayknowRecommendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b("sp_mayknow_ml_s_a_vl")))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
      if ((localObject1 != null) && (((FPSSwipListView)localObject1).isShown()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.isEmpty()))
      {
        int i3 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition();
        int i5 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition();
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
            if (i3 < this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getCount())
            {
              i4 = i1;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i3) != null)
              {
                Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(i3);
                i4 = i1;
                if ((localObject2 instanceof RecentItemMayKnowFriendVerticalListData))
                {
                  int i2 = i1;
                  if (i1 < 0) {
                    i2 = b();
                  }
                  localObject2 = ((RecentItemMayKnowFriendVerticalListData)localObject2).a();
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
          ContactReportUtils.a(a(), 25, (ArrayList)localObject1, localArrayList1, localArrayList2, localArrayList3, 2, null);
        }
      }
    }
  }
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "setThemeDiyBgConversation ");
    }
    ThemeBackground.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidViewView, 1, 2130838740, "-conversation-");
  }
  
  public void y()
  {
    if (!this.u) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.b(PushBannerProcessor.jdField_a_of_type_Int)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
    int i1;
    if ((localObject != null) && (((FPSSwipListView)localObject).getChildCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() > 0) && (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() >= 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0)
    {
      this.H = false;
      return;
    }
    if (this.H) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "checkPushBannerReport");
    }
    this.H = true;
    localObject = this.jdField_a_of_type_ComTencentMobileqqBannerBannerManager.a(PushBannerProcessor.jdField_a_of_type_Int);
    if (localObject != null) {
      localObject = ((Banner)localObject).jdField_a_of_type_AndroidViewView.getTag(2131362283);
    } else {
      localObject = null;
    }
    ThreadManager.post(new Conversation.60(this, localObject), 5, null, false);
  }
  
  public void z()
  {
    Object localObject = a();
    if (this.jdField_d_of_type_Boolean)
    {
      if (localObject == null) {
        return;
      }
      CareNotificationBar localCareNotificationBar = this.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar;
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
        ((StringBuilder)localObject).append(this.jdField_f_of_type_Int);
        ((StringBuilder)localObject).append(" currentUnreadCaredItemIndex: ");
        ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject).toString());
      }
      int i1 = (int)(a().getResources().getDimension(2131298890) + a().getResources().getDimension(2131298907) / 2.0F);
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
        localObject = new Conversation.63(this, i2);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed((Runnable)localObject, 250L);
      }
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A1E3", "0X800A1E3", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation
 * JD-Core Version:    0.7.0.1
 */