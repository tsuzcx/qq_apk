package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.accessibility.AccessibilityManager;
import com.dataline.activities.LiteActivity;
import com.tencent.aelight.camera.api.IQIMManager;
import com.tencent.ark.ArkStateCenter;
import com.tencent.av.AVLog;
import com.tencent.av.app.AvAddFriendService;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.api.IVideoProcessMonitor;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.notification.StoryMsgNotification;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxyContainer;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.contact.newfriend.CloneFriendPushHelper;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendPushUtil;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.miniaio.MiniMsgHandler;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetNeedSignOnBannerProcessor;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscUpdateHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.identity.IAccountApi;
import com.tencent.mobileqq.app.memory.QLogReporter;
import com.tencent.mobileqq.app.message.MessageStatisticHelper;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHooker;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastService;
import com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.bridge.ReportControllerServiceHolder;
import com.tencent.mobileqq.bridge.report.service.IReportDataProviderService;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.dt.QQDtReportHelper;
import com.tencent.mobileqq.ecshop.ad.IEcshopAdHandler;
import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgDbTransformer;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.filemanageraux.util.PrivacyInfoUtil;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.hitrate.PreloadProcHitMgr;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;
import com.tencent.mobileqq.inputstatus.InputStatusHandler;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyUtilsConstants;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyJumpUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyLockScreenJumpDelegate;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManagerService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.api.IOfflineUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoExtractFrameManager;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyGlobalReporter;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.MsgPushReportHelper;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgController;
import com.tencent.mobileqq.nearby.INearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.manager.IAutoStatusManager;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler.IPluginManagerProvider;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.pushnotice.PushNoticeUtil;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.MobileQQServiceExtend;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.FDStats;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.statistics.WtloginReporter;
import com.tencent.mobileqq.statistics.natmem.NatMemAPI;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.subaccount.api.IAssociatedAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.ISubAccountServlet;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.utils.TroopFileUploadingManager;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.IPCFaceHelper;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.util.QQTextToSpeechHelper;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QGuardUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.backgroundcpu.BatteryStats;
import com.tencent.qqperf.monitor.backgroundcpu.BatteryStatsImpl;
import com.tencent.qqperf.monitor.base.IAPMModuleLeak;
import com.tencent.qqperf.monitor.sp.DeviceStabilityMonitor;
import com.tencent.qqperf.monitor.sp.SPStatReporter;
import com.tencent.qqperf.tools.DeviceAbilityCollector;
import com.tencent.securemodule.impl.SecureModuleService;
import com.tencent.securemodule.service.CloudScanListener;
import com.tencent.securemodule.service.ISecureModuleService;
import com.tencent.securemodule.service.ProductInfo;
import com.tencent.theme.TextHook;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MsgAutoMonitorUtil;
import com.tencent.util.QQKRPUtil;
import com.tencent.util.notification.NotificationController;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.TraceUtils;
import cooperation.plugin.PluginManagerV2;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlinkReliableReport;
import cooperation.qlink.QlinkServiceManager;
import cooperation.qqfav.QfavHelper;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.vip.tianshu.TianShuManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.PropertiesKey;
import mqq.app.Foreground;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.manager.PushManager;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class QQAppInterface
  extends BaseQQAppInterface
  implements PluginManageHandler.IPluginManagerProvider
{
  public static final String AUTHORIZATION_NAME = "B1_QQ_Neighbor_android";
  public static final String AUTHORIZATION_PASSWORD = "NzVK_qGE";
  public static final int AUTO_CHECK_UPGRADE = 0;
  public static final String BROADCAST_NEW_MESSAGE_NOFITY = "com.tencent.msg.newmessage";
  private static final String BROADCAST_QZONE_CLEAR_COUNT = "com.tencent.qzone.cleanunreadcount";
  private static long CHECK_FACE_UPDATE_PERIOD = 86400000L;
  static final String DATANAME_QZONE_CLEAR_COUNT = "clean_unread_feed_type";
  private static final int FACE_TYPE_OHTER_SYSTEM = -55;
  private static final int FACE_TYPE_TROOP_SYSTEM = -56;
  private static final long FIVE_SECOND = 5000L;
  private static final int[] IMPORTANT_MANAGERS;
  public static final int MANUAL_CHECK_UPGRADE = 1;
  private static final int MAX_CHECKTIME = 168;
  public static final int MAX_RUNNING_TASK = 2;
  public static final int MAX_TRY_TIME = 3;
  private static final int MIN_CHECKTIME = 1;
  private static final int MSG_GET_ONLINE_FRIENDS = 0;
  public static final int MSG_X_2_MOBILE = 1;
  public static final int MSG_X_2_NONE = 3;
  public static final int MSG_X_2_WIFI = 2;
  public static final String QQ_ACTION_LOGOUT = "com.tencent.mobileqq.intent.logout";
  private static final String QQ_HEAD_BROADCAST = "Q.qqhead.broadcast";
  public static final String QQ_HEAD_QAIF = "Q.qqhead.qaif";
  public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
  public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
  public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;
  private static final long SERVER_CONFIG_TIMEOUT = 7200000L;
  static final String TAG = "QQAppInterface";
  private static final String TAG_NOTIFY = "notification";
  static final String TAG_SECURITY_SCAN = "security_scan";
  static final long TIME_SPACE = 2000L;
  public static final int VIBRATE_TYPE_COMMON = 1;
  public static final int VIBRATE_TYPE_SHAKE = 2;
  public static final int VIBRATE_TYPE_SPECIAL_FRIEND = 3;
  public static final long[] VIBRATOR_PATTERN = { 100L, 200L, 200L, 100L };
  public static final long[] VIBRATOR_PATTERN_SHAKE = { 100L, 400L, 100L, 400L, 100L, 400L };
  public static final long[] VIBRATOR_TIME_SELECTOR = { 10L, 50L };
  private static final String VIDEO_PROCESS_NAME = "com.tencent.mobileqq:video";
  public static int curBrowserFontSizeIndex = 1;
  public static int sGetOnlineFriendDelay = 30000;
  public static int sNextGetOnlineFriendDelay;
  public AboutConfig aboutConfig;
  private long accountStartTime = 0L;
  private volatile long[] areMessageRefreshUI = new long[2];
  public boolean bFirstPacket = true;
  public boolean bReceiveMsgOnExit;
  private CacheManager cacheManager;
  private CheckPttListener checkPttListener;
  private CheckPtvListener checkPtvListener;
  private Config config;
  volatile ConversationFacade convsFacade;
  private EntityManager em;
  private QQEntityManagerFactoryProxy emFactory;
  private FileTransferHandler fileTransferHandler;
  Set<String> friendInfoQueue = new HashSet();
  private FriendListObserver friendListObserver = new QQAppInterface.8(this);
  @Deprecated
  public boolean isCallTabShow = false;
  public boolean isConversationTabShow = true;
  public boolean isExitTaskUnfinished = false;
  public boolean isFinished;
  public boolean isInCallList = false;
  public boolean isKandianTabShow = false;
  public boolean isMSFConnect = false;
  public boolean isMsfPullFilterConfigInited = false;
  private boolean isRealSwitchToBackground = false;
  public volatile boolean isReleased = false;
  public boolean isStartSyncOnlineFriend = false;
  private Handler lockDetectHandler = null;
  private HandlerThread lockDetectThread = null;
  private AVNotifyCenter mAVNotifyCenter;
  public Automator mAutomator;
  private AvAddFriendService mAvAddFriendService;
  volatile QCallFacade mCallFacade;
  @Deprecated
  public int mCallTabShowState = -1;
  private final CfgProcess mConfigProcess = new CfgProcess();
  private DatalineMsgDbTransformer mDatalineMsgDBTransformer;
  private FileManagerDataCenter mFileManagerDataCenter;
  private FileManagerEngine mFileManagerEngine;
  private FileManagerNotifyCenter mFileManagerNotifyCenter;
  private FileManagerRSCenter mFileManagerRSCenter;
  public boolean mFirstGetSubAccountName = true;
  private QQGAudioMsgHandler mGAudioHandler;
  private HotChatManager mHCMng = null;
  ConcurrentLinkedQueue<Intent> mHeadGetIntents = new ConcurrentLinkedQueue();
  @Deprecated
  public boolean mIsShowNewLeba = false;
  private CloudScanListener mListener;
  public long mLoginTime;
  private MsgTabUnreadListener mMsgTabUnreadListener = null;
  private MultiAIOUnreadListener mMultiAIOUnreadListener = null;
  private MultiMsgController mMultiMsgController;
  private NetEngineFactory mNetEngineFactory;
  private OnlineFileSessionCenter mOnlineFileSessionCenter;
  private volatile ParcelHooker mParcelHooker;
  private long mPreShowKickedNTs = 0L;
  private PrivacyInfoUtil mPrivacyInfoUtil;
  private QQProxyForQlink mQQProxyForQlink;
  public WeakReference<QQServiceForAV> mQQServiceRef;
  private QlinkServiceManager mQlinkServiceManager;
  private RecentUserProxy mRecentUserProxy;
  public long mRegisterPushTime;
  private ReportController mReportController;
  private Object mReportControllerLock = new Object();
  AtomicInteger mRunningTaskNum = new AtomicInteger(0);
  private ISecureModuleService mSecureService;
  private Intent mSecurityDetectBannerIntent = null;
  private ShortVideoResourceManager mShortVideoResourceMgr;
  private Object mSystemMsgInitLock = new Object();
  public int mTryTimeForNear;
  public int mTryTimeForStatus;
  public volatile boolean mainActivityIsForeground = false;
  private Manager[] managers = new Manager[QQManagerFactory.COUNT_MANAGER];
  MessageNotifiableChecker messageNotifiableChecker;
  MessageNotificationGenerator messageNotificationGenerator;
  private ThreadLocal<Integer> mgrCallingDepthThreadLocal = new ThreadLocal();
  private ThreadLocal<StringBuilder> mgrCallingStackThreadLocal = new ThreadLocal();
  private final Object[] mgrLockArray = new Object[QQManagerFactory.COUNT_MANAGER];
  public MobileQQServiceExtend mqqService;
  public boolean msfPullFilterSwitch = true;
  private MessageCache msgCache;
  volatile QQMessageFacade msgFacade;
  private MessageHandler msgHandler;
  public boolean needReuploadQfav = false;
  private volatile byte[] needSoundAndVibrations = new byte[2];
  QQAppInterface.MyNetInfoHandler netHandler = null;
  private ProxyManager proxyManager;
  private BroadcastReceiver qqAccountReceiver = new QQAppInterface.7(this);
  private BroadcastReceiver qqHeadBroadcastReceiver = new QQAppInterface.5(this);
  private BroadcastReceiver qzoneBrocastReceiver = new QQAppInterface.17(this);
  protected Handler sGetOnlineFriendHandler = new QQAppInterface.14(this, Looper.getMainLooper());
  public long sLastGetOnlineFriendTime = 0L;
  private Hashtable<ServerConfigManager.ConfigType, HashMap<String, String>> serverConfig = new Hashtable();
  private HashMap<ServerConfigManager.ConfigType, Long> serverConfigTimeOut = new HashMap();
  private ShortVideoPreDownloader shortVideoPreDownloader;
  private IQvipSpecialSoundManager soundManager = null;
  SharedPreferences sp = null;
  public int tagMaxNum;
  private long time = -1L;
  public Intent upgradeData = null;
  public int userActiveStatus = 0;
  List<VibrateListener> vibrateListenerList = new ArrayList();
  VibrateSoundHelper vibrateSoundHelper;
  
  static
  {
    IMPORTANT_MANAGERS = new int[] { QQManagerFactory.PROXY_MANAGER, QQManagerFactory.CACHE_MANAGER, QQManagerFactory.MGR_MSG_FACADE, QQManagerFactory.CONVS_FACADE, QQManagerFactory.MGR_SUB_ACNT, QQManagerFactory.MGR_PLUGIN, QQManagerFactory.TROOP_GAG_MANAGER, QQManagerFactory.BEANCURD_MANAGER, QQManagerFactory.EXTEND_FRIEND_MANAGER };
    sNextGetOnlineFriendDelay = 300000;
  }
  
  public QQAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private void addHeadGetTask(Intent paramIntent)
  {
    this.mHeadGetIntents.offer(paramIntent);
    runNext();
  }
  
  private void avGameOnEnterForeground()
  {
    IAvGameManager localIAvGameManager = (IAvGameManager)getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager != null) {
      localIAvGameManager.onEnterForeground();
    }
  }
  
  @TargetApi(23)
  private void checkBackgroundRestricWhilteList()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkBackgroundRestricWhilteList ENTER ");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    QLog.d("QQAppInterface", 1, ((StringBuilder)localObject1).toString());
    boolean bool2 = false;
    Object localObject2 = { 0, 0 };
    localObject1 = BaseApplicationImpl.getContext();
    ConnectivityManager localConnectivityManager = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
    boolean bool1;
    try
    {
      bool1 = localConnectivityManager.isActiveNetworkMetered();
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQAppInterface", 2, "checkBackgroundRestricWhilteList: failed. ", localException2);
      }
      bool1 = false;
    }
    if (bool1)
    {
      int j = -1;
      int k;
      try
      {
        Method localMethod = localConnectivityManager.getClass().getMethod("getRestrictBackgroundStatus", new Class[0]);
        localMethod.setAccessible(true);
        k = ((Integer)localMethod.invoke(localConnectivityManager, new Object[0])).intValue();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        k = -1;
      }
      long l1 = 0L;
      if (k != 2)
      {
        if (k == 3)
        {
          SharedPreferences localSharedPreferences = ((Context)localObject1).getSharedPreferences("qq_background_restric_whitelist_cfg", 0);
          int i = localSharedPreferences.getInt("tips_index", 0);
          long l2 = localSharedPreferences.getLong("tips_last_time", 0L);
          if (i == 0)
          {
            localObject2 = localSharedPreferences.edit();
            j = i + 1;
            ((SharedPreferences.Editor)localObject2).putInt("tips_index", j).putLong("tips_last_time", System.currentTimeMillis()).commit();
          }
          for (;;)
          {
            bool2 = true;
            l1 = l2;
            break;
            if ((i >= 0) && (i <= 5)) {
              break label288;
            }
            i = 5;
            label288:
            j = i;
            l1 = l2;
            if (System.currentTimeMillis() < new int[][] { localObject2, { 1, 3 }, { 2, 3 }, { 3, 7 }, { 4, 7 }, { 5, 14 } }[i][1] * 86400000L + l2) {
              break;
            }
            localObject2 = localSharedPreferences.edit();
            j = i + 1;
            ((SharedPreferences.Editor)localObject2).putInt("tips_index", j).putLong("tips_last_time", System.currentTimeMillis()).commit();
          }
        }
      }
      else {
        ((Context)localObject1).getSharedPreferences("qq_background_restric_whitelist_cfg", 0).edit().putInt("tips_index", 0).putLong("tips_last_time", 0L).commit();
      }
      localObject2 = new StringBuilder("checkBackgroundRestricWhilteList");
      ((StringBuilder)localObject2).append(" isActiveNetworkMetered=");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(" restrictStatus=");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(" tipsIdx=");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(" tipsTime=");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(" notice=");
      ((StringBuilder)localObject2).append(bool2);
      QLog.d("QQAppInterface", 1, ((StringBuilder)localObject2).toString());
      if (bool2)
      {
        localObject2 = new Intent((Context)localObject1, DialogActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).addFlags(131072);
        ((Intent)localObject2).putExtra("key_dialog_type", DialogActivity.b);
        ((Context)localObject1).startActivity((Intent)localObject2);
      }
    }
    QLog.d("QQAppInterface", 1, "checkBackgroundRestricWhilteList END");
  }
  
  private void checkDialogOnBackground()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
        List localList = ((ActivityManager)localBaseApplication.getSystemService("activity")).getRunningTasks(1);
        if ((localList != null) && (localList.size() > 0))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkBackgroundRestricWhilteList onRunningBackground topActivity packageName: ");
            localStringBuilder.append(((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName());
            QLog.d("QQAppInterface", 2, localStringBuilder.toString());
          }
          if (localBaseApplication.getPackageName().equals(((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName()))
          {
            this.isRealSwitchToBackground = false;
            return;
          }
          this.isRealSwitchToBackground = true;
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQAppInterface", 1, "checkBackgroundRestricWhilteList, ", localException);
      }
    }
  }
  
  private void checkGetManagerCallingDepthEnd() {}
  
  private void checkGetManagerCallingDepthForMGRNotNull(int paramInt)
  {
    int i;
    if (this.mgrCallingDepthThreadLocal.get() == null) {
      i = 0;
    } else {
      i = ((Integer)this.mgrCallingDepthThreadLocal.get()).intValue();
    }
    if (i > 0)
    {
      StringBuilder localStringBuilder = (StringBuilder)this.mgrCallingStackThreadLocal.get();
      this.mgrCallingDepthThreadLocal.set(Integer.valueOf(i + 1));
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt);
    }
  }
  
  private void checkGetManagerCallingDepthStart(int paramInt) {}
  
  private void checkRamForAvideo()
  {
    boolean bool = PhoneStatusTools.e(getApp());
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkRamForAvideo isSelfCalling = ");
      localStringBuilder.append(bool);
      QLog.d("QQAppInterface", 2, localStringBuilder.toString());
    }
    if (bool) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkRamForAvideo getAVNotifyCenter().isBeInvitingOnDoubleVideo() = ");
      getAVNotifyCenter();
      localStringBuilder.append(AVNotifyCenter.d());
      QLog.d("QQAppInterface", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkRamForAvideo getAVNotifyCenter().isAvChating() = ");
      localStringBuilder.append(getAVNotifyCenter().b());
      QLog.d("QQAppInterface", 2, localStringBuilder.toString());
    }
    getAVNotifyCenter();
    if ((AVNotifyCenter.d()) && (!getAVNotifyCenter().b())) {
      return;
    }
    long l = DeviceInfoUtil.a() / 1024L / 1024L;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkRamForAvideo memoryTotal = ");
      localStringBuilder.append(l);
      QLog.d("QQAppInterface", 2, localStringBuilder.toString());
    }
    if ((isVideoChatting()) && (l != 0L) && (l <= 2048L)) {
      ThreadManager.getUIHandler().post(new QQAppInterface.21(this));
    }
  }
  
  public static BatteryStats getBatteryStats()
  {
    return BatteryStatsImpl.a();
  }
  
  public static String getBuddyFaceFilePath(String paramString)
  {
    return AvatarUtil.a(paramString);
  }
  
  public static Bitmap getCircleFaceBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return AvatarUtil.a(paramBitmap, paramInt1, paramInt2);
  }
  
  private String getCurrentProcess()
  {
    try
    {
      int i = Process.myPid();
      Object localObject = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      } while (localRunningAppProcessInfo.pid != i);
      localObject = localRunningAppProcessInfo.processName;
      return localObject;
    }
    catch (Exception localException)
    {
      label59:
      break label59;
    }
    QLog.d("QQAppInterface", 1, "failed to get current process name");
    return null;
  }
  
  public static String getCurrentThemeId()
  {
    return ThemeUtil.getCurrentThemeId();
  }
  
  @NotNull
  private Intent getDefaultIntentByUin(Context paramContext, int paramInt, String paramString)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("uin", paramString);
    paramContext.putExtra("uintype", paramInt);
    paramContext = AIOUtils.a(paramContext, new int[] { 2 });
    paramContext.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
    return paramContext;
  }
  
  @NotNull
  public static String getFaceSettingKey(int paramInt1, String paramString, int paramInt2)
  {
    return AvatarUtil.a(paramInt1, paramString, paramInt2);
  }
  
  private Intent getIntentByUin(Context paramContext, com.tencent.imcore.message.Message paramMessage, int paramInt)
  {
    Object localObject2 = paramMessage.frienduin;
    int i = paramInt;
    paramInt = i;
    if (i == 1026) {
      paramInt = 1;
    }
    Object localObject1;
    if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(localObject2))
    {
      localObject1 = paramContext.getString(2131699038);
      localObject2 = new Intent(paramContext, MsgBoxListActivity.class);
      paramContext = AppConstants.LBS_HELLO_UIN;
      if (!MsgBoxUtil.a(paramMessage, this)) {
        paramContext = AppConstants.NEARBY_LBS_HELLO_UIN;
      }
      ((Intent)localObject2).putExtra("uin", paramContext);
      ((Intent)localObject2).putExtra("uintype", 1001);
      paramContext = (Context)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      Object localObject3;
      if ((!String.valueOf(AppConstants.FRIEND_SYSTEM_MSG_UIN).equals(localObject2)) && (!AppConstants.MAYKNOW_RECOMMEND_UIN.equals(localObject2)) && (!AppConstants.FRIEND_ANNIVER_UIN.equals(localObject2)))
      {
        if (String.valueOf(AppConstants.TROOP_SYSTEM_MSG_UIN).equals(localObject2))
        {
          paramMessage = paramContext.getString(2131719404);
          localObject1 = new Intent(paramContext, QPublicFragmentActivity.class);
          ((Intent)localObject1).putExtra("public_fragment_class", ((ILaunchTroopSysMsgUIUtilApi)QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).getFragmentNameForLaunch());
          ((Intent)localObject1).putExtra("_key_mode", 1);
          ((Intent)localObject1).putExtra("key_tab_mode", 2);
          paramContext = paramMessage;
          paramMessage = (com.tencent.imcore.message.Message)localObject1;
        }
        for (;;)
        {
          localObject1 = paramMessage;
          break label2120;
          if (String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(localObject2))
          {
            localObject1 = new Intent(paramContext, QQBroadcastActivity.class);
            paramContext = paramContext.getString(2131719403);
            break label2120;
          }
          if (!String.valueOf(AppConstants.VOTE_MSG_UIN).equals(localObject2)) {
            break;
          }
          localObject1 = paramContext.getString(2131719404);
          paramMessage = new Intent(paramContext, VisitorsActivity.class);
          paramMessage.putExtra("votersOnly", true);
          paramMessage.putExtra("toUin", Long.valueOf(getCurrentAccountUin()));
          paramContext = (Context)localObject1;
        }
        if (String.valueOf(AppConstants.DATALINE_PC_UIN).equals(localObject2))
        {
          localObject1 = new Intent(paramContext, LiteActivity.class);
          ((Intent)localObject1).putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
          paramContext = paramContext.getString(2131693779);
        }
        else if (String.valueOf(AppConstants.DATALINE_IPAD_UIN).equals(localObject2))
        {
          localObject1 = new Intent(paramContext, LiteActivity.class);
          ((Intent)localObject1).putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
          paramContext = paramContext.getString(2131693780);
        }
        else if (String.valueOf(9973L).equals(localObject2))
        {
          localObject1 = new Intent(paramContext, ActivateFriendActivity.class);
          paramContext = paramContext.getString(2131689565);
          ((Intent)localObject1).setFlags(67108864);
          ((Intent)localObject1).putExtra("af_key_from", 4);
          ((Intent)localObject1).putExtra("msg_hash", paramMessage.uniseq);
        }
        else
        {
          boolean bool = AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN.equals(localObject2);
          localObject1 = "";
          if (bool)
          {
            localObject2 = BaseApplicationImpl.getContext().getString(ReadInJoyUtilsConstants.a);
            if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()) {
              paramContext = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent(paramContext, 19);
            } else {
              paramContext = new Intent(paramContext, ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getReadInJoyNewFeedsActivityClazz());
            }
            try
            {
              paramMessage = new JSONObject(paramMessage.extStr).optString("msg_id");
            }
            catch (JSONException paramMessage)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("getIntentByUin, get readinjoy messageId exception, e=");
              ((StringBuilder)localObject3).append(paramMessage.toString());
              QLog.i("QQAppInterface", 1, ((StringBuilder)localObject3).toString());
              paramMessage = (com.tencent.imcore.message.Message)localObject1;
            }
            paramContext.putExtra("notification_message_id", paramMessage);
            paramContext.putExtra("uintype", 7225);
            localObject1 = paramContext;
            paramContext = (Context)localObject2;
          }
          else if (paramInt == 7000)
          {
            paramMessage = paramContext.getString(2131719304);
            localObject1 = new Intent(paramContext, ((IAssociatedAccountApi)QRoute.api(IAssociatedAccountApi.class)).getAssociatedAccountActivity());
            ((Intent)localObject1).putExtra("subAccount", (String)localObject2);
            paramContext = (ISubAccountService)getRuntimeService(ISubAccountService.class, "");
            if (paramContext != null) {
              paramContext = paramContext.getLatestUinNick((String)localObject2);
            } else {
              paramContext = (Context)localObject2;
            }
            ((Intent)localObject1).putExtra("subAccountLatestNick", paramContext);
            ((Intent)localObject1).putExtra("finishAIO", true);
            ((Intent)localObject1).putExtra("uin", (String)localObject2);
            ((Intent)localObject1).putExtra("uintype", paramInt);
            paramContext = paramMessage;
          }
          else if ((paramInt != 1001) && (paramInt != 1010))
          {
            if (paramInt == 1032)
            {
              paramMessage = paramContext.getString(2131698706);
              localObject1 = new Intent(paramContext, PublicFragmentActivity.class);
              ((Intent)localObject1).putExtra("uintype", 1032);
              ((Intent)localObject1).putExtra("uin", AppConstants.CONFESS_UIN);
              ((Intent)localObject1).putExtra("public_fragment_class", ConfessMsgListFragment.class.getName());
              ((Intent)localObject1).addFlags(335544320);
              paramContext = paramMessage;
            }
            else if ((paramInt != 1044) && (paramInt != 1045))
            {
              if (AppConstants.KANDIAN_DAILY_UIN.equals(localObject2))
              {
                localObject1 = BaseApplicationImpl.getContext().getString(ReadInJoyUtilsConstants.a);
                paramMessage = (IKandianDailyManagerService)getRuntimeService(IKandianDailyManagerService.class);
                paramMessage = ((IReadInJoyLockScreenJumpDelegate)QRoute.api(IReadInJoyLockScreenJumpDelegate.class)).getJumpDailyFragmentIntent(paramContext, 6, paramMessage.getRedPntInfoFromMsg());
                paramMessage.putExtra("uin", (String)localObject2);
                paramMessage.putExtra("uintype", paramInt);
                paramContext = (Context)localObject1;
              }
              do
              {
                localObject1 = paramMessage;
                break label2120;
                if (paramInt == 10007)
                {
                  localObject1 = ((ITempApi)QRoute.api(ITempApi.class)).getIntentFromMsg(paramContext, paramMessage, this);
                  paramContext = (Context)localObject2;
                  break label2120;
                }
                localObject3 = null;
                localObject1 = null;
                if (paramInt != 7220) {
                  break;
                }
                paramMessage = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getMergerKandianName(this, paramContext);
                localObject2 = ((IKanDianMergeManager)getRuntimeService(IKanDianMergeManager.class)).getLastMsgForKanDian2();
                if (!((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needForceNotification((MessageRecord)localObject2)) {
                  i = 5;
                } else {
                  i = 6;
                }
                if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab())
                {
                  localObject1 = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent(paramContext, i);
                }
                else
                {
                  localObject2 = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyNewFeedsIntent(paramContext, i);
                  if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle())
                  {
                    ((Intent)localObject2).putExtra("readinjoy_show_tab", 0);
                    ((Intent)localObject2).putExtra("tab_tab_index", 0);
                    ((Intent)localObject2).putExtra("launch_from", i);
                    ((IReadInJoyJumpUtils)QRoute.api(IReadInJoyJumpUtils.class)).configLockScreenJumpInfo((Intent)localObject2);
                  }
                  else
                  {
                    localObject3 = new ArrayList();
                    paramContext = ((IKanDianMergeManager)getRuntimeService(IKanDianMergeManager.class)).getLastMsgForKanDian2();
                    if ((paramContext != null) && ((paramContext instanceof MessageForStructing)) && (paramContext.extInt == 1))
                    {
                      paramContext = (MessageForStructing)paramContext;
                      if (paramContext.structingMsg == null) {
                        paramContext.parse();
                      }
                      if ((paramContext.structingMsg != null) && (!TextUtils.isEmpty(paramContext.structingMsg.mArticleIds)))
                      {
                        paramContext = paramContext.structingMsg.mArticleIds.split("\\|");
                        int k = paramContext.length;
                        int j = 0;
                        while (j < k)
                        {
                          String str = paramContext[j];
                          try
                          {
                            ((ArrayList)localObject3).add(Long.valueOf(Long.parseLong(str)));
                          }
                          catch (Exception localException)
                          {
                            localException.printStackTrace();
                          }
                          j += 1;
                        }
                      }
                    }
                    if (((ArrayList)localObject3).isEmpty()) {
                      paramContext = (Context)localObject1;
                    } else {
                      paramContext = (Context)localObject3;
                    }
                    ((Intent)localObject2).putExtra("subscription_all_article_id", paramContext);
                    long l;
                    if (((ArrayList)localObject3).isEmpty()) {
                      l = -1L;
                    } else {
                      l = ((Long)((ArrayList)localObject3).get(0)).longValue();
                    }
                    ((Intent)localObject2).putExtra("subscription_click_article_id", l);
                    ((Intent)localObject2).putExtra("launch_from", i);
                  }
                  localObject1 = localObject2;
                }
                ((Intent)localObject1).putExtra("uin", AppConstants.KANDIAN_MERGE_UIN);
                ((Intent)localObject1).putExtra("uintype", paramInt);
                paramContext = paramMessage;
                paramMessage = (com.tencent.imcore.message.Message)localObject1;
              } while (i != 6);
              paramContext = BaseApplicationImpl.getContext().getString(ReadInJoyUtilsConstants.a);
              break label2120;
              if (paramInt == 0)
              {
                localObject3 = getDefaultIntentByUin(paramContext, paramInt, (String)localObject2);
                localObject2 = ContactUtils.a(this, (String)localObject2, paramInt);
                paramContext = (Context)localObject2;
                localObject1 = localObject3;
                if (paramMessage.msgtype == -5008)
                {
                  ListenTogetherUtils.a(this, paramMessage, (Intent)localObject3);
                  paramContext = (Context)localObject2;
                  localObject1 = localObject3;
                }
              }
              else if (paramInt == 1)
              {
                localObject3 = getDefaultIntentByUin(paramContext, paramInt, (String)localObject2);
                localObject2 = ContactUtils.a(this, (String)localObject2, paramInt);
                paramContext = (Context)localObject2;
                localObject1 = localObject3;
                if (paramMessage.msgtype == -5008)
                {
                  ListenTogetherUtils.a(this, paramMessage, (Intent)localObject3);
                  paramContext = (Context)localObject2;
                  localObject1 = localObject3;
                }
              }
              else
              {
                localObject1 = localObject3;
                if (paramMessage.msgtype == -5008) {
                  localObject1 = AVGameUtils.a(this, paramMessage);
                }
                if (localObject1 == null)
                {
                  paramMessage = getDefaultIntentByUin(paramContext, paramInt, (String)localObject2);
                  if (paramInt == 1024) {
                    paramMessage.putExtra("chat_subType", 1);
                  }
                }
                else
                {
                  paramMessage = (com.tencent.imcore.message.Message)localObject1;
                }
                if (paramInt == 1009)
                {
                  paramContext = paramContext.getString(2131718365);
                  localObject1 = paramMessage;
                }
                else if (String.valueOf(1787740092L).equals(localObject2))
                {
                  paramContext = paramContext.getString(2131690087);
                  localObject1 = paramMessage;
                }
                else if (paramInt == 1024)
                {
                  paramContext = ContactUtils.a(this, (String)localObject2, paramInt);
                  localObject1 = paramMessage;
                }
                else if (paramInt == 9501)
                {
                  localObject3 = ((SmartDeviceProxyMgr)getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong((String)localObject2));
                  paramContext = (Context)localObject2;
                  localObject1 = paramMessage;
                  if (localObject3 != null)
                  {
                    paramContext = SmartDeviceUtil.a((DeviceInfo)localObject3);
                    localObject1 = paramMessage;
                  }
                }
                else
                {
                  paramContext = ContactUtils.a(this, (String)localObject2, paramInt);
                  localObject1 = paramMessage;
                }
              }
            }
            else
            {
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = ContactUtils.a(this, (String)localObject2, false);
              } else {
                localObject1 = HardCodeUtil.a(2131710079);
              }
              paramContext = MatchChatMsgUtil.a(paramContext);
              paramContext.putExtra("key_matchchat_from_notification", true);
              paramContext.putExtra("key_matchchat_from_notification_uin", paramMessage.frienduin);
              paramContext.putExtra("key_matchchat_from_notification_type", paramInt);
              paramMessage = paramContext;
              paramContext = (Context)localObject1;
              localObject1 = paramMessage;
            }
          }
          else
          {
            localObject1 = paramContext.getString(2131699038);
            localObject2 = new Intent(paramContext, MsgBoxListActivity.class);
            paramContext = AppConstants.LBS_HELLO_UIN;
            if (!MsgBoxUtil.a(paramMessage, this)) {
              paramContext = AppConstants.NEARBY_LBS_HELLO_UIN;
            }
            ((Intent)localObject2).putExtra("uin", paramContext);
            ((Intent)localObject2).putExtra("uintype", paramInt);
            paramContext = (Context)localObject1;
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject3 = paramContext.getString(2131694443);
        localObject1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getNewFriendJumpIntent(paramContext);
        if (AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(localObject2))
        {
          ((Intent)localObject1).putExtra("from", "from_notification");
          paramInt = NewFriendPushUtil.a(paramMessage);
          ((Intent)localObject1).putExtra("fromSubType", paramInt);
          if (paramInt == 6) {
            ((INewFriendApi)QRoute.api(INewFriendApi.class)).report(this, "0X800A181");
          } else if ((paramInt == 9) || (paramInt == 10) || (paramInt == 1)) {
            ((INewFriendApi)QRoute.api(INewFriendApi.class)).report(this, "0X8009CBA");
          }
        }
        ((Intent)localObject1).putExtra("EntranceId", 1);
        paramContext = (Context)localObject3;
      }
    }
    label2120:
    ((Intent)localObject1).putExtra("uinname", paramContext);
    return localObject1;
  }
  
  private Intent getIntentForTroopStranger(Context paramContext, com.tencent.imcore.message.Message paramMessage, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("uin", paramMessage.frienduin);
    paramContext.putExtra("troop_uin", paramMessage.senderuin);
    paramContext.putExtra("uintype", paramMessage.istroop);
    paramContext.putExtra("uinname", getTroopDisscussMemberNick(paramMessage, paramBoolean));
    paramContext = AIOUtils.a(paramContext, new int[] { 2 });
    paramContext.setAction("com.tencent.mobileqq.action.CHAT");
    return paramContext;
  }
  
  private void getManagerCompatibleWithOldLogic(int paramInt, Manager paramManager)
  {
    if (paramInt == QQManagerFactory.PROXY_MANAGER)
    {
      this.proxyManager = ((ProxyManager)paramManager);
      return;
    }
    if (paramInt == QQManagerFactory.CACHE_MANAGER)
    {
      this.cacheManager = ((CacheManager)paramManager);
      return;
    }
    if (paramInt == QQManagerFactory.MGR_MSG_FACADE)
    {
      this.msgFacade = ((QQMessageFacade)paramManager);
      onCreateQQMessageFacade(this.msgFacade);
      return;
    }
    if (paramInt == QQManagerFactory.MGR_NET_ENGINE)
    {
      this.mNetEngineFactory = ((NetEngineFactory)paramManager);
      return;
    }
    if (paramInt == QQManagerFactory.CONVS_FACADE)
    {
      this.convsFacade = ((ConversationFacade)paramManager);
      return;
    }
    if (paramInt == QQManagerFactory.HOT_CHAT_MANAGER) {
      this.mHCMng = ((HotChatManager)paramManager);
    }
  }
  
  public static boolean getMsfPullFilterSwitch(QQAppInterface paramQQAppInterface)
  {
    if (!paramQQAppInterface.isMsfPullFilterConfigInited)
    {
      String str = paramQQAppInterface.getAccount();
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append("long_text_msg_config_version");
      if (localSharedPreferences.contains(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_msfpull_filter_switch");
        paramQQAppInterface.msfPullFilterSwitch = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
      }
    }
    paramQQAppInterface.isMsfPullFilterConfigInited = true;
    return paramQQAppInterface.msfPullFilterSwitch;
  }
  
  private SharedPreferences getPref()
  {
    if (this.sp == null) {
      this.sp = PreferenceManager.getDefaultSharedPreferences(getApp());
    }
    return this.sp;
  }
  
  public static Bitmap getRoundFaceBitmap(Bitmap paramBitmap)
  {
    return AvatarUtil.a(paramBitmap);
  }
  
  public static Bitmap getShapeRoundFaceBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    return AvatarUtil.a(paramBitmap, paramInt1, paramInt2, paramInt3);
  }
  
  private String getTroopDisscussMemberNick(com.tencent.imcore.message.Message paramMessage, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramMessage.istroop != 1000) && (paramMessage.istroop != 1020)) {
      localObject1 = ContactUtils.a(this, paramMessage.senderuin, paramMessage.frienduin);
    } else {
      localObject1 = ((ITroopMemberNameService)getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberNickByTroopCode(paramMessage.frienduin, paramMessage.senderuin);
    }
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).equals(paramMessage.frienduin)) {}
    }
    else
    {
      localObject2 = ((FriendsManager)getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramMessage.frienduin);
      if (localObject2 != null) {
        if (!TextUtils.isEmpty(((Friends)localObject2).remark)) {
          localObject1 = ((Friends)localObject2).remark;
        } else {
          localObject1 = ((Friends)localObject2).name;
        }
      }
      localObject2 = localObject1;
      if (paramBoolean) {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (!((String)localObject1).equals(paramMessage.frienduin)) {}
        }
        else
        {
          localObject2 = localObject1;
          if (!this.friendInfoQueue.contains(paramMessage.frienduin))
          {
            this.friendInfoQueue.add(paramMessage.frienduin);
            localObject2 = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            addObserver(this.friendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d("QQAppInterface_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject2).getFriendInfo(paramMessage.frienduin);
            localObject2 = localObject1;
          }
        }
      }
    }
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!"".equals(localObject2)) {}
    }
    else
    {
      localObject1 = paramMessage.frienduin;
    }
    return localObject1;
  }
  
  private ArrayList<String> getTroopUinList(Cursor paramCursor)
  {
    if ((paramCursor != null) && (paramCursor.getCount() > 0))
    {
      int i = paramCursor.getColumnIndex("troopuin");
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        localObject = localArrayList;
        if (!paramCursor.moveToNext()) {
          break;
        }
        localObject = paramCursor.getString(i);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    Object localObject = null;
    return localObject;
  }
  
  private String getVersionName()
  {
    String str1 = "0.0.0";
    Object localObject1 = this.app.getPackageManager();
    String str2 = str1;
    try
    {
      Object localObject2 = ((PackageManager)localObject1).getPackageInfo(this.app.getPackageName(), 0);
      localObject1 = str1;
      if (localObject2 != null)
      {
        localObject1 = str1;
        str2 = str1;
        if (((PackageInfo)localObject2).versionName != null)
        {
          str2 = str1;
          str1 = ((PackageInfo)localObject2).versionName;
          localObject1 = str1;
          if (str1 != null)
          {
            str2 = str1;
            localObject2 = str1.split("\\.");
            int i = 3;
            for (;;)
            {
              localObject1 = str1;
              str2 = str1;
              if (i <= localObject2.length) {
                break;
              }
              str2 = str1;
              localObject1 = new StringBuilder();
              str2 = str1;
              ((StringBuilder)localObject1).append(str1);
              str2 = str1;
              ((StringBuilder)localObject1).append(".0");
              str2 = str1;
              str1 = ((StringBuilder)localObject1).toString();
              i -= 1;
            }
          }
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return str2;
  }
  
  private void headQQHeadBroadcast(Intent paramIntent)
  {
    ((IQQAvatarBroadcastService)getRuntimeService(IQQAvatarBroadcastService.class, "")).headQQHeadBroadcast(paramIntent);
  }
  
  private void initAbout()
  {
    if (this.aboutConfig == null)
    {
      this.aboutConfig = new AboutConfig(this);
      this.aboutConfig.a();
    }
  }
  
  @Deprecated
  private void initCallTabShowState()
  {
    if (this.mCallTabShowState != -1) {
      return;
    }
    String str = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
    if ((str != null) && (str.length() <= 7))
    {
      Object localObject = str;
      if (str.length() < 7)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("0111100".substring(str.length()));
        localObject = ((StringBuilder)localObject).toString();
      }
      int i = localObject.toCharArray()[6];
      localObject = new StringBuilder((String)localObject);
      if (48 != i)
      {
        ((StringBuilder)localObject).setCharAt(6, '0');
        i = 1;
      }
      else
      {
        i = 0;
      }
      this.mCallTabShowState = 0;
      this.isCallTabShow = false;
      if (i != 0) {
        ThreadManager.post(new QQAppInterface.19(this, (StringBuilder)localObject), 8, null, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQAppInterface", 2, "isCallTabShow fullVal is null");
    }
  }
  
  public static void initHeadCfg()
  {
    int j = 0;
    int k = 0;
    int i = k;
    try
    {
      Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.headCfg.name(), "24|3500|1|0");
      i = k;
      if (QLog.isColorLevel())
      {
        i = k;
        StringBuilder localStringBuilder2 = new StringBuilder();
        i = k;
        localStringBuilder2.append("initHeadCfg, ");
        i = k;
        localStringBuilder2.append((String)localObject);
        i = k;
        QLog.i("QQAppInterface", 2, localStringBuilder2.toString());
      }
      i = k;
      localObject = ((String)localObject).split("\\|");
      i = k;
      if (localObject.length > 0)
      {
        i = k;
        k = Integer.parseInt(localObject[0]);
        j = k;
        if (k >= 1)
        {
          j = k;
          if (k <= 168)
          {
            i = k;
            CHECK_FACE_UPDATE_PERIOD = k * 60 * 60 * 1000;
            j = k;
          }
        }
      }
    }
    catch (Exception localException)
    {
      CHECK_FACE_UPDATE_PERIOD = 86400000L;
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.e("QQAppInterface", 2, "initHeadCfg error", localException);
        j = i;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("initHeadCfg,");
      localStringBuilder1.append(j);
      localStringBuilder1.append(",");
      localStringBuilder1.append(CHECK_FACE_UPDATE_PERIOD);
      QLog.i("QQAppInterface", 2, localStringBuilder1.toString());
    }
  }
  
  @TargetApi(19)
  public static int isNotificationEnabled()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean isTimeIntervalLimited(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    unitTestLog("vibratorAndAudio_check_time_start", new Object[0]);
    if (this.time == -1L)
    {
      unitTestLog("vibratorAndAudio_check_time_not_valid", new Object[0]);
    }
    else if (Math.abs(System.currentTimeMillis() - this.time) <= 2000L)
    {
      unitTestLog("vibratorAndAudio_check_time_in_time_space", new Object[0]);
      if (paramMessageRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SpecialCare", 2, "message = null");
        }
        return true;
      }
      if (paramMessageRecord.msgtype != -2020)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SpecialCare", 2, "message.msgtype != MessageRecord.MSG_TYPE_SHAKE_WINDOW");
        }
        return true;
      }
      if ((!paramBoolean) || (getOnlineStauts() != 11L))
      {
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("isOnline = ");
          paramMessageRecord.append(paramBoolean);
          paramMessageRecord.append(" getOnlineStatus = ");
          paramMessageRecord.append(getOnlineStauts());
          QLog.e("SpecialCare", 2, paramMessageRecord.toString());
        }
        return true;
      }
    }
    this.time = System.currentTimeMillis();
    unitTestLog("vibratorAndAudio_check_time_end", new Object[0]);
    return false;
  }
  
  public static EntityManager ktBridgeForEntityManager(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private void notifyMessageReceived(com.tencent.imcore.message.Message paramMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyMessageReceived: entryA message.frienduin=");
      localStringBuilder.append(paramMessage.frienduin);
      localStringBuilder.append(", message.senderuin=");
      localStringBuilder.append(paramMessage.senderuin);
      localStringBuilder.append(", needSoundVibrationsTip ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" , isOnline ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("QQAppInterface", 2, localStringBuilder.toString());
    }
    if (((NotificationController)getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER)).a(paramMessage.frienduin, paramMessage.istroop))
    {
      if (isShowMsgContent()) {
        showMessageNotificationWithPreview(paramMessage, true);
      } else {
        showMessageNotificationNoPreview(paramMessage, true);
      }
      if (VibrateSoundHelper.a(this.userActiveStatus, paramMessage, paramBoolean1)) {
        vibratorAndAudioForMsg(paramMessage, paramBoolean2);
      }
    }
  }
  
  private void onLineStatusOnAppForeground()
  {
    IAutoStatusManager localIAutoStatusManager = (IAutoStatusManager)((IOnlineStatusManagerService)getRuntimeService(IOnlineStatusManagerService.class)).getManager(IAutoStatusManager.class);
    if (localIAutoStatusManager != null) {
      localIAutoStatusManager.c("QQAppInterface");
    }
  }
  
  private void onRunningBackgroundDoReportForReadInJoy()
  {
    if (((IReadInJoyGlobalReporter)QRoute.api(IReadInJoyGlobalReporter.class)).needReport())
    {
      ((IReadInJoyGlobalReporter)QRoute.api(IReadInJoyGlobalReporter.class)).report();
      ((IReadInJoyGlobalReporter)QRoute.api(IReadInJoyGlobalReporter.class)).stopReport();
      ((IReadInJoyGlobalReporter)QRoute.api(IReadInJoyGlobalReporter.class)).setAPPStatus(1);
    }
  }
  
  private void onRunningBackgroundWithAccount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningBackgroundWithAccount");
    }
    long l = SharedPreUtils.e();
    if (System.currentTimeMillis() - l > 14400000L)
    {
      IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)getRuntimeService(IWebProcessManagerService.class, "all");
      if (localIWebProcessManagerService != null)
      {
        localIWebProcessManagerService.startWebProcess(204, null);
        SharedPreUtils.c(System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface", 2, "check update x5");
        }
      }
    }
    ((IPhoneContactService)getRuntimeService(IPhoneContactService.class, "")).onAppRunBackground();
  }
  
  private void onRunningForegroundWithAccount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningForegroundWithAccount");
    }
    Object localObject = (ActivateFriendsManager)getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
    IQQReminderDataService localIQQReminderDataService = (IQQReminderDataService)getRuntimeService(IQQReminderDataService.class, "");
    if (localObject != null)
    {
      ((ActivateFriendsManager)localObject).a();
      localIQQReminderDataService.checkTodayReminder();
    }
    ((IPhoneContactService)getRuntimeService(IPhoneContactService.class, "")).onAppRunForeground();
    startAllSubMessageAccountMsg(false);
    localObject = (ISubAccountControlService)getRuntimeService(ISubAccountControlService.class, "");
    if ((localObject != null) && (((ISubAccountControlService)localObject).getIsThirdUnreadReqSkip()))
    {
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).startGetThirdQQUnreadNum(this, true);
      ((ISubAccountControlService)localObject).setIsThirdUnreadReqSkip(false);
    }
  }
  
  private void putTroopTable(int paramInt, HashMap<Integer, String[]> paramHashMap, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0) && ((paramInt == -1) || (paramInt == 1))) {
      paramHashMap.put(Integer.valueOf(1), (String[])paramArrayList1.toArray(new String[paramArrayList1.size()]));
    }
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0) && ((paramInt == -1) || (paramInt == 2))) {
      paramHashMap.put(Integer.valueOf(2), (String[])paramArrayList2.toArray(new String[paramArrayList2.size()]));
    }
    if ((paramArrayList3 != null) && (paramArrayList3.size() > 0) && ((paramInt == -1) || (paramInt == 4))) {
      paramHashMap.put(Integer.valueOf(4), (String[])paramArrayList3.toArray(new String[paramArrayList3.size()]));
    }
  }
  
  private void registerAccountReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq.intent.action.EXIT_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getPackageName());
    localIntentFilter.addAction(localStringBuilder.toString());
    localIntentFilter.addAction("com.tencent.mobileqq.kickedLogin.otherDevice");
    this.app.registerReceiver(this.qqAccountReceiver, localIntentFilter);
  }
  
  private void release()
  {
    if (this.isReleased) {
      return;
    }
    QLog.d("QQAppInterface", 1, "release");
    this.isReleased = true;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.jdField_a_of_type_Boolean = false;
    if (GuardManager.a != null) {
      GuardManager.a.a(false, BaseApplicationImpl.processName);
    }
    QQDtReportHelper.b();
    this.mAutomator.onDestroy();
    HeavyTaskExecutor.a(new QQAppInterface.10(this));
    if (this.mListener != null) {
      getSecureModuleService().unregisterCloudScanListener(this.app.getBaseContext(), this.mListener);
    }
    VideoBroadcastReceiver.a();
    RecentParcelUtil.a();
    ((IQQAvatarDecoderApi)QRoute.api(IQQAvatarDecoderApi.class)).closeFaceDecodeThread();
    Object localObject = this.mFileManagerEngine;
    if (localObject != null) {
      ((FileManagerEngine)localObject).b();
    }
    localObject = this.mRecentUserProxy;
    if (localObject != null) {
      ((RecentUserProxy)localObject).b();
    }
    ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).shutdownWySystem();
    TdsReaderGlobal.b();
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).onDestroy();
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).onDestroy();
    EquipLockWebImpl.a();
    PluginManageHandler.getInstance().setPluginManagerProvider(null, false);
    SessionInfo.clearOldSession();
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).resetDeleteOldKandian();
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).resetPublicAccountConfig(getCurrentUin());
    ((IPublicAccountSearchRecommendManager)QRoute.api(IPublicAccountSearchRecommendManager.class)).reset();
    QQIndividualityPluginProxyService.a();
    com.tencent.mobileqq.search.base.api.SearchEntryConfigManager.jdField_a_of_type_Boolean = false;
    StoryMsgNotification.a().a(BaseApplication.getContext());
    FaceScanDownloadManager.a();
    CloneFriendPushHelper.a();
    ((IAccountApi)QRoute.api(IAccountApi.class)).release();
    HeavyTaskExecutor.a(new QQAppInterface.11(this));
    TroopFileDownloadMgr.a().b();
    TroopFileThumbnailMgr.a().b();
    getFileManagerEngine().a().a();
    TroopFileUploadingManager.a(this);
    ((INotifyMsgApi)QRoute.api(INotifyMsgApi.class)).onActiveAccount();
    ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).clearInstance(this);
    WadlProxyServiceUtil.a();
    TogetherWatchFloatingUtil.a();
    onRelease();
  }
  
  private void runNext()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runNext,");
      ((StringBuilder)localObject).append(this.mRunningTaskNum.get());
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.mHeadGetIntents.size());
      QLog.i("Q.qqhead.broadcast", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.mRunningTaskNum.get() < 2) && (!this.mHeadGetIntents.isEmpty()))
    {
      localObject = (Intent)this.mHeadGetIntents.poll();
      if (localObject != null)
      {
        this.mRunningTaskNum.incrementAndGet();
        ThreadManager.excute(new QQAppInterface.20(this, System.currentTimeMillis(), (Intent)localObject), 32, null, true);
      }
    }
  }
  
  private void sendBindUinOffline()
  {
    if (!TextUtils.isEmpty(getAccount()))
    {
      ArrayList localArrayList = ((ISubAccountService)getRuntimeService(ISubAccountService.class, "")).getAllSubUin();
      if (localArrayList != null)
      {
        if (localArrayList.size() == 0) {
          return;
        }
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).setBindUinStatus(this, (byte)0, localArrayList);
      }
    }
  }
  
  private void showKickedNotification(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("title");
    String str2 = paramIntent.getStringExtra("msg");
    if (SystemClock.elapsedRealtime() - this.mPreShowKickedNTs > 5000L)
    {
      paramIntent.putExtra("entrance", 6);
      paramIntent.putExtra("key_notification_click_action", true);
      showNotificationWithoutMessage(new NotificationElement(paramIntent, str2, str1, str2, null), "CMD_SHOW_NOTIFIYCATION");
      this.mPreShowKickedNTs = SystemClock.elapsedRealtime();
    }
  }
  
  private void showMessageNotificationNoPreview(com.tencent.imcore.message.Message paramMessage, boolean paramBoolean)
  {
    if ((!this.isFinished) && (NoDisturbUtil.a(this.app.getApplicationContext(), this)) && (!NoDisturbUtil.b(this.app.getApplicationContext(), this)))
    {
      if (!NewMsgNotificationManager.a(this).a(paramMessage)) {
        return;
      }
      Object localObject;
      if ((this.msgFacade.a.b() != 1) && (paramMessage.istroop != 1044) && (paramMessage.istroop != 1045))
      {
        localObject = new Intent(getApp(), SplashActivity.class);
        ((Intent)localObject).addFlags(335544320);
        ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.a);
      }
      else
      {
        localObject = getIntentByMessage(getApp(), paramMessage, false);
        ((Intent)localObject).putExtra("entrance", 6);
      }
      Intent localIntent = this.messageNotifiableChecker.a(paramMessage, (Intent)localObject);
      localIntent.putExtra("key_notification_click_action", true);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(getApp().getString(2131694529));
      int i;
      if ((paramMessage.istroop != 1044) && (paramMessage.istroop != 1045)) {
        i = this.msgFacade.a.a();
      } else {
        i = this.msgFacade.a.a(1044) + this.msgFacade.a.a(1045);
      }
      if (i == 0) {
        return;
      }
      if (i > 1000)
      {
        localStringBuffer.append(getApp().getString(2131694508));
      }
      else
      {
        localStringBuffer.append(i);
        localStringBuffer.append(getApp().getString(2131694445));
      }
      if (paramBoolean) {
        localObject = localStringBuffer.toString();
      } else {
        localObject = null;
      }
      String str;
      if ((paramMessage.istroop != 1045) && (paramMessage.istroop != 1044)) {
        str = getApp().getResources().getString(2131694524);
      } else {
        str = getApp().getResources().getString(2131698832);
      }
      MessageNotificationGenerator.a(this, paramMessage, new NotificationElement(localIntent, (String)localObject, str, localStringBuffer.toString(), null), "CMD_SHOW_NOTIFIYCATION");
    }
  }
  
  private void showMessageNotificationWithPreview(com.tencent.imcore.message.Message paramMessage, boolean paramBoolean)
  {
    PushNoticeUtil.b(getApplicationContext());
    this.messageNotificationGenerator = new MessageNotificationGenerator(this);
    if (MessageNotifiableChecker.a(this, paramMessage)) {
      this.messageNotificationGenerator.a(this, paramMessage, paramBoolean);
    }
  }
  
  private boolean soundVibrateWhenNoNotification(boolean paramBoolean1, boolean paramBoolean2, com.tencent.imcore.message.Message paramMessage)
  {
    if (this.messageNotifiableChecker.e(paramMessage)) {
      return true;
    }
    int i;
    if ((paramMessage.istroop == 1008) && (AppConstants.REMINDER_UIN.equals(paramMessage.senderuin))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      vibratorAndAudioForMsg(paramMessage, paramBoolean2);
      return true;
    }
    if (paramBoolean1)
    {
      boolean bool = this.messageNotifiableChecker.i(paramMessage);
      if ((this.userActiveStatus == 0) || (bool)) {
        if (!this.mainActivityIsForeground)
        {
          vibratorAndAudioForMsg(paramMessage, paramBoolean2);
        }
        else
        {
          if ((this.areMessageRefreshUI[0] == paramMessage.uniseq) && (this.areMessageRefreshUI[1] == 1L)) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            vibratorAndAudioForMsg(paramMessage, paramBoolean2);
          }
          else
          {
            this.needSoundAndVibrations[0] = 1;
            this.needSoundAndVibrations[1] = ((byte)paramBoolean2);
          }
        }
      }
    }
    if ((paramBoolean1) && (this.messageNotifiableChecker.f(paramMessage))) {
      this.messageNotifiableChecker.a(paramMessage);
    }
    return false;
  }
  
  public static void speak(String paramString)
  {
    QQTextToSpeechHelper.a(paramString);
  }
  
  private void startActivitySafe(Context paramContext, Intent paramIntent, String paramString)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      QQToast.a(paramContext, paramString, 1).a();
      if (QLog.isColorLevel()) {
        QLog.e("QQAppInterface", 1, "startActivitySafe fail", paramIntent);
      }
    }
  }
  
  private boolean systemSound(String paramString)
  {
    return (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(paramString)) || (String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(paramString)) || (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramString));
  }
  
  public void addAboutListener(ResourcePluginListener paramResourcePluginListener)
  {
    initAbout();
    this.aboutConfig.a(paramResourcePluginListener);
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    Manager[] arrayOfManager = this.managers;
    if (arrayOfManager[paramInt] != null) {
      return;
    }
    arrayOfManager[paramInt] = paramManager;
  }
  
  public void addManager(boolean paramBoolean)
  {
    addManager(paramBoolean, 0L);
  }
  
  public void addManager(boolean paramBoolean, long paramLong)
  {
    int i = 0;
    if (paramBoolean)
    {
      int[] arrayOfInt = IMPORTANT_MANAGERS;
      int j = arrayOfInt.length;
      i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        if (k == QQManagerFactory.MGR_PLUGIN)
        {
          QLog.d("QQInitHandler", 2, new Object[] { "pluginManageDelayTime=", Long.valueOf(paramLong) });
          if (paramLong > 0L) {
            ThreadManager.getSubThreadHandler().postDelayed(new QQAppInterface.3(this), paramLong);
          } else if (paramLong == 0L) {
            getManager(QQManagerFactory.MGR_PLUGIN);
          }
        }
        else
        {
          getManager(k);
        }
        i += 1;
      }
    }
    while (i < QQManagerFactory.COUNT_MANAGER)
    {
      if ((i != QQManagerFactory.MGR_MEDIA_PLAYER) && (i != QQManagerFactory.BUSINESS_WORD_MATCH_MANAGER)) {
        getManager(i);
      }
      i += 1;
    }
  }
  
  public void addVibrateListener(VibrateListener paramVibrateListener)
  {
    if (paramVibrateListener == null) {
      return;
    }
    if (this.vibrateListenerList.indexOf(paramVibrateListener) >= 0) {
      return;
    }
    this.vibrateListenerList.add(paramVibrateListener);
  }
  
  boolean canPlaySound()
  {
    return getALLGeneralSettingRing() != 0;
  }
  
  boolean canPlayThemeSound()
  {
    if (canPlaySound())
    {
      Object localObject = ThemeUtil.getUserCurrentThemeId(this);
      if ((localObject != null) && (!((String)localObject).equals("1000")))
      {
        localObject = ThemeUtil.getThemeInfo(getApplication(), (String)localObject);
        if ((localObject != null) && (((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {
          return true;
        }
      }
    }
    return false;
  }
  
  boolean canVibrator()
  {
    return getALLGeneralSettingVibrate() != 0;
  }
  
  public void cancelNotification()
  {
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("QQAppInterface_cancelNotification", 265);
      localQQNotificationManager.cancel("QQAppInterface_cancelNotification", 275);
      localQQNotificationManager.cancel("QQAppInterface_cancelNotification", 527);
      label34:
      showIdleNotification(getApp(), null);
      return;
    }
    catch (Exception localException)
    {
      break label34;
    }
  }
  
  public void cancelSyncOnlineFriend(long paramLong)
  {
    if (paramLong >= 0L) {
      this.sLastGetOnlineFriendTime = paramLong;
    }
    this.sGetOnlineFriendHandler.removeMessages(0);
  }
  
  public boolean checkAndGetSelfNickName()
  {
    String str2 = getCurrentAccountUin();
    String str1 = ContactUtils.e(this, str2);
    Object localObject;
    if ((!TextUtils.isEmpty(str2)) && (str2.equals(str1)))
    {
      localObject = (FriendsManager)getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((FriendsManager)localObject).e(str2);
      }
      if ((localObject == null) || (((Friends)localObject).name == null))
      {
        localObject = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (localObject != null)
        {
          bool = true;
          ((FriendListHandler)localObject).getFriendInfo(str2);
          break label96;
        }
      }
    }
    boolean bool = false;
    label96:
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAndGetSelfNickName, [");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.i("QQAppInterface", 4, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void clearGroupSuspiciousMsg()
  {
    synchronized (this.mSystemMsgInitLock)
    {
      getMessageFacade().a(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
      getMsgHandler().a().d();
      return;
    }
  }
  
  public void clearGroupSystemMsg()
  {
    synchronized (this.mSystemMsgInitLock)
    {
      getMessageFacade().a(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
      getMsgHandler().a().e();
      return;
    }
  }
  
  public void clearGroupSystemMsgHistory()
  {
    synchronized (this.mSystemMsgInitLock)
    {
      getMessageFacade().a(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
      return;
    }
  }
  
  public void clearMsgCounter()
  {
    if (this.msgFacade != null) {
      this.msgFacade.a.b();
    }
    if (!TextUtils.isEmpty(getAccount())) {
      ((ISubAccountService)getRuntimeService(ISubAccountService.class, "")).clearAllUnNotifySenderNum();
    }
    ActivateFriendsManager localActivateFriendsManager = (ActivateFriendsManager)getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
    if (localActivateFriendsManager != null) {
      localActivateFriendsManager.d();
    }
  }
  
  public void deleteStrangerFace(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteStrangerFace.id=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",idType=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("Q.qqhead.", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((paramInt != 200) && (paramInt != 204) && (paramInt != 202)) {
      return;
    }
    removeFaceIconCache(32, paramString, paramInt);
    Object localObject = (IPCFaceHelper)NearbyManagerHelper.a(this).a(false);
    if (localObject != null) {
      ((IPCFaceHelper)localObject).a(32, paramString, paramInt);
    }
    paramString = new File(getCustomFaceFilePath(32, paramString, paramInt));
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void exit(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getCurrentAccountUin());
      ((StringBuilder)localObject).append(" qq start to exit ");
      QLog.d("exit", 2, ((StringBuilder)localObject).toString());
    }
    this.isExitTaskUnfinished = true;
    sendBindUinOffline();
    StatisticHitRateCollector.a().d(getCurrentAccountUin());
    PreloadProcHitMgr.a();
    release();
    if (isLogin())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bReceiveMsgOnExit = ");
        ((StringBuilder)localObject).append(this.bReceiveMsgOnExit);
        ((StringBuilder)localObject).append(", needPCActive = ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("QQAppInterface", 2, ((StringBuilder)localObject).toString());
      }
      localObject = (IOnlineStatusService)getRuntimeService(IOnlineStatusService.class);
      if (this.bReceiveMsgOnExit) {
        ((IOnlineStatusService)localObject).sendOnlineStatus(AppRuntime.Status.receiveofflinemsg, false, 0L, false);
      } else if (paramBoolean) {
        ((IOnlineStatusService)localObject).sendOnlineStatus(AppRuntime.Status.offline, false, 0L, false);
      } else {
        ((IOnlineStatusService)localObject).sendOnlineStatus(AppRuntime.Status.offline, true, 0L, false);
      }
      localObject = (PushManager)getManager(5);
      int i = getAppid();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.app.getPackageName());
      localStringBuilder.append(":video");
      ((PushManager)localObject).unregistProxyMessagePush(i, localStringBuilder.toString());
    }
    if (GuardManager.a != null) {
      GuardManager.a.a();
    }
    if (paramBoolean) {
      getApplication().qqProcessExit(isLogin() ^ true);
    } else {
      getApplication().qqProcessExit(this.bReceiveMsgOnExit ^ true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "QQAppInterface exit removeNotification");
    }
    removeNotification();
    HeavyTaskExecutor.a();
    QGuardUtils.a(true);
  }
  
  protected void finalize()
  {
    super.finalize();
    QQEntityManagerFactoryProxy localQQEntityManagerFactoryProxy = this.emFactory;
    if (localQQEntityManagerFactoryProxy != null) {
      localQQEntityManagerFactoryProxy.close();
    }
  }
  
  public int getALLGeneralSettingRing()
  {
    return ((IRoamSettingService)getRuntimeService(IRoamSettingService.class, "")).getSettingValue("message.ring.switch", 1);
  }
  
  public int getALLGeneralSettingVibrate()
  {
    return ((IRoamSettingService)getRuntimeService(IRoamSettingService.class, "")).getSettingValue("message.vibrate.switch", 1);
  }
  
  public AVNotifyCenter getAVNotifyCenter()
  {
    if (this.mAVNotifyCenter == null) {
      this.mAVNotifyCenter = new AVNotifyCenter(this);
    }
    return this.mAVNotifyCenter;
  }
  
  public AboutConfig getAboutConfig()
  {
    initAbout();
    return this.aboutConfig;
  }
  
  public int getAndroidInternalId(String paramString)
  {
    try
    {
      Class[] arrayOfClass = Class.forName("com.android.internal.R").getDeclaredClasses();
      int j = arrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        Class localClass = arrayOfClass[i];
        if ("id".equals(localClass.getSimpleName()))
        {
          i = localClass.getDeclaredField(paramString).getInt(null);
          return i;
        }
        i += 1;
      }
      return 0;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public AvAddFriendService getAvAddFriendService()
  {
    if (this.mAvAddFriendService == null) {
      this.mAvAddFriendService = new AvAddFriendService(this);
    }
    return this.mAvAddFriendService;
  }
  
  public Bitmap getBitmapFromCache(String paramString)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getBitmapFromCache(paramString);
  }
  
  public void getBrowserFontSetting()
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(getCurrentAccountUin());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (localObject != null) {
      curBrowserFontSizeIndex = ((SharedPreferences)localObject).getInt("browser_font_size_index", 1);
    }
  }
  
  public int getC2CRoamingSetting()
  {
    return ((IRoamSettingService)getRuntimeService(IRoamSettingService.class, "")).getSettingValue("sync.c2c_message", 1);
  }
  
  public CacheManager getCacheManager()
  {
    if (this.cacheManager == null) {
      this.cacheManager = ((CacheManager)getCacheManagerInner());
    }
    return this.cacheManager;
  }
  
  public QCallFacade getCallFacade()
  {
    if (this.mCallFacade == null) {
      this.mCallFacade = ((QCallFacade)getManager(QQManagerFactory.RECENT_CALL_FACADE));
    }
    return this.mCallFacade;
  }
  
  public CheckPttListener getCheckPttListener()
  {
    return this.checkPttListener;
  }
  
  public CheckPtvListener getCheckPtvListener()
  {
    return this.checkPtvListener;
  }
  
  public Config getConfig(String paramString, boolean paramBoolean)
  {
    if ((this.config == null) && (paramBoolean)) {
      initConfig(paramString);
    }
    return this.config;
  }
  
  public CfgProcess getConfigProcess()
  {
    return this.mConfigProcess;
  }
  
  public QzoneContactsFeedManager getContactsFeedManager()
  {
    return (QzoneContactsFeedManager)getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER);
  }
  
  public ConversationFacade getConversationFacade()
  {
    if (this.convsFacade == null) {
      this.convsFacade = ((ConversationFacade)getManager(QQManagerFactory.CONVS_FACADE));
    }
    return this.convsFacade;
  }
  
  public boolean getCurLoginStatus()
  {
    boolean bool = SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true) ^ true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("kickPC get value........... kickpc = ");
      localStringBuilder.append(bool);
      QLog.d("QQAppInterface", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getCurrentNickname()
  {
    return ContactUtils.d(this, getCurrentAccountUin());
  }
  
  public String getCurrentUin()
  {
    if (!"0".equals(getCurrentAccountUin())) {
      return getCurrentAccountUin();
    }
    return "";
  }
  
  public String getCustomFaceFilePath(int paramInt1, String paramString, int paramInt2)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(null, paramInt1, paramString, paramInt2, 0);
  }
  
  public String getCustomFaceFilePath(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(null, paramInt1, paramString, paramInt2, paramInt3);
  }
  
  public String getCustomFaceFilePath(Setting paramSetting, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(paramSetting, paramInt1, paramString, paramInt2, paramInt3);
  }
  
  public String getCustomFaceFilePath(boolean paramBoolean, String paramString)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(paramBoolean, paramString);
  }
  
  public String getCustomFaceFilePathBySetting(Setting paramSetting, int paramInt1, int paramInt2)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePathBySetting(paramSetting, paramInt1, paramInt2);
  }
  
  public DataLineMsgProxy getDataLineMsgProxy(int paramInt)
  {
    return getProxyManager().a(paramInt);
  }
  
  public DatalineMsgDbTransformer getDatalineMsgDBTransformer()
  {
    if (this.mDatalineMsgDBTransformer == null) {
      this.mDatalineMsgDBTransformer = new DatalineMsgDbTransformer(this);
    }
    return this.mDatalineMsgDBTransformer;
  }
  
  public QQEntityManagerFactoryProxy getEntityManagerFactory()
  {
    String str = getAccount();
    if (str != null)
    {
      QQEntityManagerFactoryProxy localQQEntityManagerFactoryProxy = this.emFactory;
      if (localQQEntityManagerFactoryProxy != null) {
        return localQQEntityManagerFactoryProxy;
      }
      try
      {
        if (this.emFactory == null)
        {
          this.emFactory = QQEntityManagerFactoryProxy.a(str, super.getEntityManagerFactory());
          ThreadManager.getSubThreadHandler().postDelayed(new QQAppInterface.6(this), 3000L);
        }
        return this.emFactory;
      }
      finally {}
    }
    throw new IllegalStateException("WTF");
  }
  
  @Deprecated
  public QQEntityManagerFactoryProxy getEntityManagerFactory(String paramString)
  {
    if (paramString.equals(getAccount())) {
      return getEntityManagerFactory();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("!=");
    localStringBuilder.append(getAccount());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public ExtensionInfo getExtensionInfo(String paramString, boolean paramBoolean)
  {
    FriendsManager localFriendsManager = (FriendsManager)getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((localFriendsManager != null) && (this.em != null))
    {
      ExtensionInfo localExtensionInfo2 = localFriendsManager.a(paramString, false);
      ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
      if (localExtensionInfo2 == null)
      {
        localExtensionInfo1 = localExtensionInfo2;
        if (paramBoolean)
        {
          localExtensionInfo1 = (ExtensionInfo)this.em.find(ExtensionInfo.class, paramString);
          localFriendsManager.a(localExtensionInfo1);
        }
      }
      return localExtensionInfo1;
    }
    return null;
  }
  
  public Bitmap getFaceBitmap(int paramInt1, String paramString, byte paramByte1, boolean paramBoolean, byte paramByte2, int paramInt2)
  {
    return ((IQQAvatarCompatibleService)getRuntimeService(IQQAvatarCompatibleService.class, "")).getFaceBitmap(paramInt1, paramString, paramByte1, 100, paramBoolean, paramByte2, paramInt2);
  }
  
  public Bitmap getFaceBitmap(int paramInt1, String paramString, byte paramByte, boolean paramBoolean, int paramInt2)
  {
    return getFaceBitmap(paramInt1, paramString, paramByte, paramBoolean, (byte)1, paramInt2);
  }
  
  public Bitmap getFaceBitmap(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    return getFaceBitmap(paramInt1, paramString, (byte)3, paramBoolean, paramInt2);
  }
  
  public Bitmap getFaceBitmap(String paramString, byte paramByte, boolean paramBoolean)
  {
    return getFaceBitmap(1, paramString, paramByte, paramBoolean, 0);
  }
  
  public Bitmap getFaceBitmap(String paramString, boolean paramBoolean)
  {
    return getFaceBitmap(1, paramString, (byte)3, paramBoolean, 0);
  }
  
  public String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getFaceBitmapCacheKey(paramInt1, paramString, paramByte, paramInt2, 100, false);
  }
  
  public String getFaceBitmapCacheKey(int paramInt1, String paramString, byte paramByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getFaceBitmapCacheKey(paramInt1, paramString, paramByte, paramInt2, paramInt3, paramBoolean);
  }
  
  @Deprecated
  public Drawable getFaceDrawable(String paramString)
  {
    return getFaceDrawable(paramString, false, (byte)3);
  }
  
  public Drawable getFaceDrawable(String paramString, boolean paramBoolean, byte paramByte)
  {
    paramString = getFaceBitmap(1, paramString, paramByte, true, 0);
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramBoolean) {
        localObject = ImageUtil.a(paramString);
      }
    }
    paramString = null;
    if (localObject != null) {
      paramString = new BitmapDrawable((Bitmap)localObject);
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = ImageUtil.e();
    }
    return localObject;
  }
  
  public Setting getFaceSetting(String paramString)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getFaceSetting(paramString);
  }
  
  public FileManagerDataCenter getFileManagerDataCenter()
  {
    if (this.mFileManagerDataCenter == null) {
      this.mFileManagerDataCenter = new FileManagerDataCenter(this);
    }
    return this.mFileManagerDataCenter;
  }
  
  public FileManagerEngine getFileManagerEngine()
  {
    if (this.mFileManagerEngine == null) {
      try
      {
        if (this.mFileManagerEngine == null) {
          this.mFileManagerEngine = new FileManagerEngine(this);
        }
      }
      finally {}
    }
    return this.mFileManagerEngine;
  }
  
  public FileManagerNotifyCenter getFileManagerNotifyCenter()
  {
    if (this.mFileManagerNotifyCenter == null) {
      this.mFileManagerNotifyCenter = new FileManagerNotifyCenter(this);
    }
    return this.mFileManagerNotifyCenter;
  }
  
  public FileManagerProxy getFileManagerProxy()
  {
    ProxyManager localProxyManager = getProxyManager();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
  }
  
  public FileManagerRSCenter getFileManagerRSCenter()
  {
    if (this.mFileManagerRSCenter == null) {
      this.mFileManagerRSCenter = new FileManagerRSCenter(this);
    }
    return this.mFileManagerRSCenter;
  }
  
  public FileTransferHandler getFileTransferHandler()
  {
    if (this.fileTransferHandler == null) {
      this.fileTransferHandler = new FileTransferHandler(this);
    }
    return this.fileTransferHandler;
  }
  
  public QQGAudioMsgHandler getGAudioHandler()
  {
    if (this.mGAudioHandler == null) {
      this.mGAudioHandler = new QQGAudioMsgHandler(this);
    }
    return this.mGAudioHandler;
  }
  
  public HotChatManager getHotChatMng(boolean paramBoolean)
  {
    if ((this.mHCMng == null) && (paramBoolean)) {
      this.mHCMng = ((HotChatManager)getManager(QQManagerFactory.HOT_CHAT_MANAGER));
    }
    return this.mHCMng;
  }
  
  public Intent getIntentByMessage(Context paramContext, com.tencent.imcore.message.Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessage.istroop != 1000) && (paramMessage.istroop != 1020) && (paramMessage.istroop != 1004)) {
      return getIntentByUin(getApp(), paramMessage, paramMessage.istroop);
    }
    if (RecentUtil.a(this, paramMessage.frienduin)) {
      return getIntentByUin(getApp(), paramMessage, 0);
    }
    return getIntentForTroopStranger(paramContext, paramMessage, paramBoolean);
  }
  
  public MsgBoxInterFollowManager getInterFollowMgr()
  {
    return (MsgBoxInterFollowManager)getManager(QQManagerFactory.MSG_BOX_INTERACT_MANAGER);
  }
  
  public boolean getLocVisibilityForStatus()
  {
    SharedPreferences localSharedPreferences = getPref();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131694974));
    localStringBuilder.append(getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public boolean getLocZanAllowedForPeople()
  {
    return ((INearByGeneralManager)getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b();
  }
  
  public boolean getLocZanAllowedForStatus()
  {
    SharedPreferences localSharedPreferences = getPref();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131694973));
    localStringBuilder.append(getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public Manager getManager(int paramInt)
  {
    Manager localManager = this.managers[paramInt];
    ??? = localManager;
    if (localManager == null)
    {
      ??? = this.mgrLockArray;
      if (???[(???.length - 1)] == null) {
        try
        {
          if (this.mgrLockArray[(this.mgrLockArray.length - 1)] == null)
          {
            int i = 0;
            while (i < this.mgrLockArray.length)
            {
              this.mgrLockArray[i] = new Object();
              i += 1;
            }
          }
        }
        finally {}
      }
      if (AppSetting.b) {
        ??? = this.mgrLockArray[paramInt];
      }
      synchronized (this.managers)
      {
        Object localObject3 = this.managers[paramInt];
        if ((localObject3 == null) && ((getAccount() != null) || (paramInt <= 8) || (paramInt == QQManagerFactory.MGR_PLUGIN)))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getManager_");
          ((StringBuilder)localObject3).append(paramInt);
          TraceUtils.traceBegin(((StringBuilder)localObject3).toString());
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getManager begin");
            ((StringBuilder)localObject3).append(paramInt);
            QLog.d("QQAppInterface", 2, ((StringBuilder)localObject3).toString());
          }
          checkGetManagerCallingDepthStart(paramInt);
          localObject3 = QQManagerFactory.createManager(paramInt, this);
          getManagerCompatibleWithOldLogic(paramInt, (Manager)localObject3);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getManager end");
            localStringBuilder.append(paramInt);
            QLog.d("QQAppInterface", 2, localStringBuilder.toString());
          }
          TraceUtils.traceEnd();
          if (localObject3 != null) {
            addManager(paramInt, (Manager)localObject3);
          }
          ??? = localObject3;
        }
        else
        {
          return localObject3;
        }
      }
    }
    checkGetManagerCallingDepthEnd();
    return ???;
  }
  
  public QQMessageFacade getMessageFacade()
  {
    if (this.msgFacade == null) {
      this.msgFacade = ((QQMessageFacade)getManager(QQManagerFactory.MGR_MSG_FACADE));
    }
    return this.msgFacade;
  }
  
  public BaseMsgProxy getMessageProxy(int paramInt)
  {
    ProxyManager localProxyManager = getProxyManager();
    if (localProxyManager != null)
    {
      if (10007 == paramInt) {
        return localProxyManager.a();
      }
      return localProxyManager.a().a(paramInt);
    }
    return null;
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush", "MessageSvc.PushGroupMsg", "MessageSvc.PushForceOffline", "MessageSvc.PushNotify", "MessageSvc.PushForceOffline", "MessageSvc.RequestPushStatus", "RegPrxySvc.PullDisGroupSeq", "MessageSvc.RequestBatchPushFStatus", "MessageSvc.PushFStatus", "AccostSvc.SvrMsg", "ADMsgSvc.PushMsg", "StreamSvr.PushStreamMsg", "friendlist.getOnlineFriend", "MessageSvc.WNSQzone", "RegPrxySvc.PbGetMsg", "RegPrxySvc.getOffMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.NoticeEnd", "RegPrxySvc.PbSyncMsg", "RegPrxySvc.GetBoxFilter", "account.ResponseNotifyForRecommendUpdate", "MessageSvc.PushReaded", "RegPrxySvc.infoLogin", "baseSdk.Msf.NotifyResp", "RegPrxySvc.PushParam", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushBindUinGroupMsg", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "OnlinePush.PbPushC2CMsg", "cmd_connAllFailed", "cmd_recvFirstResp", "MultiVideo.s2c", "MultiVideo.c2sack", "NearFieldTranFileSvr.NotifyList", "ProfileService.CheckUpdateReq", "NearFieldDiscussSvr.NotifyList", "RegPrxySvc.QueryIpwdStat", "StatSvc.SvcReqMSFLoginNotify", "ConfigPushSvc.PushDomain", "ImStatus.ReqPushStatus" };
  }
  
  protected Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { TempServlet.class, CliNotifyPush.class, ContactBindServlet.class };
  }
  
  @Deprecated
  public Drawable getMobileFaceDrawable(String paramString, byte paramByte)
  {
    Bitmap localBitmap = getFaceBitmap(11, paramString, paramByte, true, 0);
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = ImageUtil.f();
    }
    return new BitmapDrawable(paramString);
  }
  
  public MobileQQServiceBase getMobileQQService()
  {
    return this.mqqService;
  }
  
  public MessageCache getMsgCache()
  {
    if (this.msgCache == null) {
      this.msgCache = new MessageCache(this);
    }
    return this.msgCache;
  }
  
  public MessageHandler getMsgHandler()
  {
    if (this.msgHandler == null) {
      this.msgHandler = ((MessageHandler)getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER));
    }
    return this.msgHandler;
  }
  
  public MultiMsgProxy getMultiMessageProxy()
  {
    if (getProxyManager() != null) {
      return getProxyManager().a();
    }
    return null;
  }
  
  public MultiMsgController getMultiMsgController()
  {
    if (this.mMultiMsgController == null) {
      try
      {
        if (this.mMultiMsgController == null) {
          this.mMultiMsgController = new MultiMsgController(this);
        }
      }
      finally {}
    }
    return this.mMultiMsgController;
  }
  
  public String getNamePostfix(com.tencent.imcore.message.Message paramMessage)
  {
    int i = paramMessage.bizType;
    String str2 = "";
    String str1;
    if (i != 4)
    {
      if (i != 5)
      {
        if (i != 10)
        {
          if (i != 17)
          {
            if (i != 22)
            {
              if (i != 24)
              {
                if (i != 12)
                {
                  if (i != 13) {
                    return "";
                  }
                  return getApp().getString(2131697248);
                }
                return getApp().getString(2131698563);
              }
              return getApp().getString(2131697250);
            }
            return getApp().getString(2131697697);
          }
          str1 = str2;
          if (paramMessage.msgtype == -2025)
          {
            str1 = str2;
            if (MessageForQQWalletMsg.isRedPacketMsg(getMessageFacade().b(paramMessage.frienduin, 1, paramMessage.uniseq))) {
              return getApp().getString(2131692916);
            }
          }
        }
        else
        {
          return getApp().getString(2131699476);
        }
      }
      else {
        return getApp().getString(2131697447);
      }
    }
    else {
      str1 = getApp().getString(2131697459);
    }
    return str1;
  }
  
  public String[] getNewAllowedTroopListUin()
  {
    Object localObject = getTroopListUin(-1);
    String[] arrayOfString1 = (String[])((HashMap)localObject).get(Integer.valueOf(1));
    String[] arrayOfString2 = (String[])((HashMap)localObject).get(Integer.valueOf(4));
    localObject = (String[])((HashMap)localObject).get(Integer.valueOf(2));
    if (arrayOfString1 != null) {
      j = arrayOfString1.length + 0;
    } else {
      j = 0;
    }
    int i = j;
    if (arrayOfString2 != null) {
      i = j + arrayOfString2.length;
    }
    int j = i;
    if (localObject != null) {
      j = i + localObject.length;
    }
    if (j > 0)
    {
      String[] arrayOfString3 = new String[j];
      if (arrayOfString1 != null)
      {
        System.arraycopy(arrayOfString1, 0, arrayOfString3, 0, arrayOfString1.length);
        i = arrayOfString1.length;
      }
      else
      {
        i = 0;
      }
      if (arrayOfString2 != null)
      {
        System.arraycopy(arrayOfString2, 0, arrayOfString3, 0, arrayOfString2.length);
        i = arrayOfString2.length;
      }
      if (localObject != null) {
        System.arraycopy(localObject, 0, arrayOfString3, i, localObject.length);
      }
      return arrayOfString3;
    }
    return null;
  }
  
  public String[] getNewTroopListUin(int paramInt)
  {
    return (String[])getTroopListUin(paramInt).get(Integer.valueOf(paramInt));
  }
  
  public boolean getNotAllowedSeeMyDongtai(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getDongtaiPermission(getCurrentAccountUin(), 1);
    }
    SharedPreferences localSharedPreferences = getPref();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131694489));
    localStringBuilder.append(getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public NowLiveManager getNowLiveManager()
  {
    return (NowLiveManager)getManager(QQManagerFactory.NOW_LIVE_MANAGER);
  }
  
  public String getOldCustomFaceFilePath(int paramInt, String paramString)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getOldCustomFaceFilePath(paramInt, paramString);
  }
  
  public OnlineFileSessionCenter getOnlineFileSessionCenter()
  {
    if (this.mOnlineFileSessionCenter == null) {
      this.mOnlineFileSessionCenter = new OnlineFileSessionCenter(this);
    }
    return this.mOnlineFileSessionCenter;
  }
  
  public long getOnlineStauts()
  {
    if (isAccLoginSuccess()) {}
    for (int i = ((IOnlineStatusService)getRuntimeService(IOnlineStatusService.class)).getOnlineStatus().getValue();; i = AppRuntime.Status.offline.getValue()) {
      return i;
    }
  }
  
  public Drawable getOrgFace(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public ParcelHooker getParcelHooker()
  {
    if (this.mParcelHooker == null) {
      try
      {
        if (this.mParcelHooker == null) {
          this.mParcelHooker = new ParcelHooker();
        }
      }
      finally {}
    }
    return this.mParcelHooker;
  }
  
  public void getPreloadSwitch()
  {
    try
    {
      ((ConfigHandler)getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public PrivacyInfoUtil getPrivacyInfoUtil()
  {
    if (this.mPrivacyInfoUtil == null) {
      this.mPrivacyInfoUtil = new PrivacyInfoUtil();
    }
    return this.mPrivacyInfoUtil;
  }
  
  public ProxyManager getProxyManager()
  {
    if (this.proxyManager == null) {
      this.proxyManager = ((ProxyManager)getProxyManagerInner());
    }
    return this.proxyManager;
  }
  
  public Bitmap getQCallFaceBitmap(String paramString, int paramInt)
  {
    return getFaceBitmap(16, paramString, true, paramInt);
  }
  
  public Pair<Boolean, Setting> getQQHeadSetting(int paramInt1, String paramString, int paramInt2)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(paramInt1, paramString, paramInt2);
  }
  
  public Setting getQQHeadSettingFromDB(String paramString)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getSettingFromDb(paramString);
  }
  
  public QQProxyForQlink getQQProxyForQlink()
  {
    if (this.mQQProxyForQlink == null) {
      this.mQQProxyForQlink = new QQProxyForQlink(this);
    }
    return this.mQQProxyForQlink;
  }
  
  public QlinkServiceManager getQlinkServiceMgr()
  {
    if (this.mQlinkServiceManager == null) {
      this.mQlinkServiceManager = new QlinkServiceManager(this);
    }
    return this.mQlinkServiceManager;
  }
  
  public RecentUserProxy getRecentUserProxy()
  {
    if (this.mRecentUserProxy == null) {
      try
      {
        if (this.mRecentUserProxy == null) {
          this.mRecentUserProxy = ((IRecentUserProxyService)getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        }
      }
      finally {}
    }
    return this.mRecentUserProxy;
  }
  
  public Drawable getRectFaceDrawable(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public ReportController getReportController()
  {
    ??? = ReportControllerServiceHolder.a();
    if (??? != null) {
      this.mReportController = ((ReportController)((IReportDataProviderService)???).a(this));
    }
    if (this.mReportController == null) {
      synchronized (this.mReportControllerLock)
      {
        if (this.mReportController == null) {
          this.mReportController = ReportControllerImpl.a(this);
        }
      }
    }
    return this.mReportController;
  }
  
  public Drawable getRoundFaceDrawable(Bitmap paramBitmap)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getRoundFaceDrawable(paramBitmap);
  }
  
  public Pair<Boolean, Bitmap> getScaledFaceBitmap(String paramString, byte paramByte, int paramInt1, int paramInt2)
  {
    paramString = getFaceBitmap(1, paramString, paramByte, true, 0);
    boolean bool;
    if (paramString == null)
    {
      bool = false;
      paramString = ImageUtil.f();
    }
    else
    {
      bool = true;
    }
    return Pair.create(Boolean.valueOf(bool), paramString);
  }
  
  public Intent getSecDetBannerIntent()
  {
    return this.mSecurityDetectBannerIntent;
  }
  
  public ISecureModuleService getSecureModuleService()
  {
    if (this.mSecureService == null) {
      this.mSecureService = SecureModuleService.getInstance(this.app);
    }
    return this.mSecureService;
  }
  
  public String getServerAddress()
  {
    Object localObject1 = this.app.getSharedPreferences("mobileQQ", 0);
    int i = NetworkUtil.getNetworkType(BaseApplication.getContext());
    Object localObject3 = null;
    Object localObject2;
    if (i == 1) {
      localObject2 = ((SharedPreferences)localObject1).getString("serverlist_wifi", null);
    } else {
      localObject2 = ((SharedPreferences)localObject1).getString("serverlist_2g3g", null);
    }
    localObject1 = localObject3;
    if (localObject2 != null)
    {
      localObject2 = ((String)localObject2).split(",");
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        double d1 = Math.random();
        double d2 = localObject2.length;
        Double.isNaN(d2);
        localObject1 = localObject2[((int)(d1 * d2))];
      }
    }
    return localObject1;
  }
  
  public String getServerConfigValue(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(32);
      localStringBuilder.append("getServerConfigValue type=");
      localStringBuilder.append(paramConfigType);
      localStringBuilder.append(", key=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", value=");
    }
    else
    {
      localStringBuilder = null;
    }
    long l = System.currentTimeMillis();
    if ((this.serverConfig.containsKey(paramConfigType)) && (this.serverConfigTimeOut.containsKey(paramConfigType)) && (l - ((Long)this.serverConfigTimeOut.get(paramConfigType)).longValue() < 7200000L))
    {
      paramConfigType = (HashMap)this.serverConfig.get(paramConfigType);
      if (paramConfigType.containsKey(paramString))
      {
        if (localStringBuilder != null)
        {
          localStringBuilder.append((String)paramConfigType.get(paramString));
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
        }
        return (String)paramConfigType.get(paramString);
      }
      if (localStringBuilder != null)
      {
        localStringBuilder.append("null");
        QLog.d("QQAppInterface", 2, localStringBuilder.toString());
      }
      return null;
    }
    if (getAccount() == null) {
      localObject1 = "0";
    } else {
      localObject1 = getAccount();
    }
    Object localObject1 = ((ServerConfigManager)getManager(4)).getServerConfig((String)localObject1, paramConfigType);
    if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
      try
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<ServerConfig>");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("</ServerConfig>");
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        QQAppInterface.ServerConfigXMLHandler localServerConfigXMLHandler = new QQAppInterface.ServerConfigXMLHandler(this);
        ((XMLReader)localObject2).setContentHandler(localServerConfigXMLHandler);
        ((XMLReader)localObject2).parse(new InputSource(new ByteArrayInputStream(((String)localObject1).getBytes("UTF-8"))));
        localObject1 = localServerConfigXMLHandler.getElements();
        this.serverConfig.put(paramConfigType, localObject1);
        this.serverConfigTimeOut.put(paramConfigType, Long.valueOf(l));
        l = System.currentTimeMillis() - l;
        if (localStringBuilder != null)
        {
          localStringBuilder.append((String)((HashMap)localObject1).get(paramString));
          localStringBuilder.append(",cost:");
          localStringBuilder.append(l);
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
        }
        if (l > 2000L) {
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "getConfigLongCost", true, l, 0L, null, null);
        }
        paramConfigType = (String)((HashMap)localObject1).get(paramString);
        return paramConfigType;
      }
      catch (Exception paramConfigType)
      {
        if (localStringBuilder != null) {
          QLog.e("QQAppInterface", 2, localStringBuilder.toString(), paramConfigType);
        }
        return null;
      }
    }
    if (localStringBuilder != null)
    {
      localStringBuilder.append("null, configText is null");
      QLog.d("QQAppInterface", 2, localStringBuilder.toString());
    }
    return null;
  }
  
  public Setting getSettingFromDb(String paramString)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).getSettingFromDb(paramString);
  }
  
  public boolean getShieldHisDongtai(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getDongtaiPermission(getCurrentAccountUin(), 2);
    }
    SharedPreferences localSharedPreferences = getPref();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131719049));
    localStringBuilder.append(getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public ShortVideoPreDownloader getShortVideoPredownloer()
  {
    if (this.shortVideoPreDownloader == null) {
      this.shortVideoPreDownloader = ((ShortVideoPreDownloader)getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER));
    }
    return this.shortVideoPreDownloader;
  }
  
  public ShortVideoResourceManager getShortVideoResourceManager()
  {
    if (this.mShortVideoResourceMgr == null) {
      this.mShortVideoResourceMgr = ((ShortVideoResourceManager)getManager(QQManagerFactory.SHORT_VIDEO_RESOURCE_MANAGER));
    }
    return this.mShortVideoResourceMgr;
  }
  
  public void getSignInInfo(int paramInt)
  {
    try
    {
      ((CardHandler)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).b(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @Deprecated
  public boolean getSingleTroopReceiveStatus(String paramString)
  {
    Object localObject1 = this.app;
    Object localObject2 = getCurrentAccountUin();
    boolean bool = false;
    localObject1 = ((MobileQQ)localObject1).getSharedPreferences((String)localObject2, 0);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(getCurrentAccountUin());
    ((StringBuilder)localObject2).append(paramString);
    if (((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 1L) == 1L) {
      bool = true;
    }
    return bool;
  }
  
  public Bitmap getStrangerFaceBitmap(String paramString, int paramInt)
  {
    return getFaceBitmap(32, paramString, true, paramInt);
  }
  
  public String getTroopDisscussMemberNick(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((paramInt != 1000) && (paramInt != 1020)) {
      paramString2 = ContactUtils.a(this, paramString2, paramString1);
    } else {
      paramString2 = ((ITroopMemberNameService)getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberNickByTroopCode(paramString1, paramString2);
    }
    Object localObject;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = paramString2;
      if (!paramString2.equals(paramString1)) {}
    }
    else
    {
      localObject = ((FriendsManager)getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
      if (localObject != null) {
        if (!TextUtils.isEmpty(((Friends)localObject).remark)) {
          paramString2 = ((Friends)localObject).remark;
        } else {
          paramString2 = ((Friends)localObject).name;
        }
      }
      localObject = paramString2;
      if (paramBoolean) {
        if (!TextUtils.isEmpty(paramString2))
        {
          localObject = paramString2;
          if (!paramString2.equals(paramString1)) {}
        }
        else
        {
          localObject = paramString2;
          if (!this.friendInfoQueue.contains(paramString1))
          {
            this.friendInfoQueue.add(paramString1);
            localObject = (FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            addObserver(this.friendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d("QQAppInterface_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject).getFriendInfo(paramString1);
            localObject = paramString2;
          }
        }
      }
    }
    paramString2 = paramString1;
    if (localObject != null)
    {
      if ("".equals(localObject)) {
        return paramString1;
      }
      paramString2 = (String)localObject;
    }
    return paramString2;
  }
  
  public Bitmap getTroopFaceBitmap(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = getFaceBitmap(4, paramString, paramByte, true, 0);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = ImageUtil.d();
    }
    localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramBoolean1) {
        localObject = ImageUtil.a(paramString);
      }
    }
    paramString = (String)localObject;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (paramBoolean2) {
        paramString = shield((Bitmap)localObject);
      }
    }
    return paramString;
  }
  
  public Drawable getTroopFaceDrawable(String paramString)
  {
    return getTroopFaceDrawable(paramString, (byte)3, false, false);
  }
  
  public Drawable getTroopFaceDrawable(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = getTroopFaceBitmap(paramString, paramByte, paramBoolean1, paramBoolean2);
    if (paramString != null) {
      paramString = new BitmapDrawable(paramString);
    } else {
      paramString = null;
    }
    Object localObject = paramString;
    if (paramString == null) {
      localObject = ImageUtil.c();
    }
    return localObject;
  }
  
  /* Error */
  public HashMap<Integer, String[]> getTroopListUin(int paramInt)
  {
    // Byte code:
    //   0: new 457	java/util/HashMap
    //   3: dup
    //   4: invokespecial 458	java/util/HashMap:<init>	()V
    //   7: astore 8
    //   9: iconst_0
    //   10: istore_2
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_0
    //   15: getfield 507	com/tencent/mobileqq/app/QQAppInterface:app	Lmqq/app/MobileQQ;
    //   18: invokevirtual 3278	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   21: astore 5
    //   23: new 582	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 583	java/lang/StringBuilder:<init>	()V
    //   30: astore 6
    //   32: aload 6
    //   34: ldc_w 3280
    //   37: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 6
    //   43: aload_0
    //   44: invokevirtual 1040	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   47: invokevirtual 589	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 5
    //   53: aload 6
    //   55: invokevirtual 602	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 3285	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   61: iconst_1
    //   62: anewarray 795	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: ldc_w 1500
    //   70: aastore
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: invokevirtual 3291	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   77: astore 5
    //   79: aload_0
    //   80: aload 5
    //   82: invokespecial 3293	com/tencent/mobileqq/app/QQAppInterface:getTroopUinList	(Landroid/database/Cursor;)Ljava/util/ArrayList;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 4
    //   91: aload 5
    //   93: ifnull +68 -> 161
    //   96: aload 5
    //   98: invokeinterface 3294 1 0
    //   103: aload 6
    //   105: astore 4
    //   107: goto +54 -> 161
    //   110: astore 6
    //   112: aload 5
    //   114: astore 4
    //   116: aload 6
    //   118: astore 5
    //   120: goto +8 -> 128
    //   123: goto +23 -> 146
    //   126: astore 5
    //   128: aload 4
    //   130: ifnull +10 -> 140
    //   133: aload 4
    //   135: invokeinterface 3294 1 0
    //   140: aload 5
    //   142: athrow
    //   143: aconst_null
    //   144: astore 5
    //   146: aload 5
    //   148: ifnull +10 -> 158
    //   151: aload 5
    //   153: invokeinterface 3294 1 0
    //   158: aconst_null
    //   159: astore 4
    //   161: iload_1
    //   162: bipush 254
    //   164: if_icmpne +46 -> 210
    //   167: aload 4
    //   169: ifnull +38 -> 207
    //   172: aload 4
    //   174: invokevirtual 1793	java/util/ArrayList:size	()I
    //   177: ifle +30 -> 207
    //   180: aload 8
    //   182: bipush 254
    //   184: invokestatic 809	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aload 4
    //   189: aload 4
    //   191: invokevirtual 1793	java/util/ArrayList:size	()I
    //   194: anewarray 795	java/lang/String
    //   197: invokevirtual 1797	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   200: checkcast 1799	[Ljava/lang/String;
    //   203: invokevirtual 1803	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: aload 8
    //   209: areturn
    //   210: aload 4
    //   212: ifnull +196 -> 408
    //   215: aload_0
    //   216: ldc_w 2454
    //   219: ldc_w 567
    //   222: invokevirtual 571	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   225: checkcast 2454	com/tencent/mobileqq/troop/roamsetting/api/IRoamSettingService
    //   228: aload 4
    //   230: iconst_1
    //   231: invokeinterface 3298 3 0
    //   236: astore 9
    //   238: aload 9
    //   240: ifnull +158 -> 398
    //   243: new 367	java/util/ArrayList
    //   246: dup
    //   247: invokespecial 368	java/util/ArrayList:<init>	()V
    //   250: astore 7
    //   252: new 367	java/util/ArrayList
    //   255: dup
    //   256: invokespecial 368	java/util/ArrayList:<init>	()V
    //   259: astore 5
    //   261: new 367	java/util/ArrayList
    //   264: dup
    //   265: invokespecial 368	java/util/ArrayList:<init>	()V
    //   268: astore 6
    //   270: iload_2
    //   271: aload 4
    //   273: invokevirtual 1793	java/util/ArrayList:size	()I
    //   276: if_icmpge +115 -> 391
    //   279: aload 4
    //   281: iload_2
    //   282: invokevirtual 1256	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   285: checkcast 795	java/lang/String
    //   288: astore 10
    //   290: aload 9
    //   292: aload 10
    //   294: invokeinterface 3301 2 0
    //   299: checkcast 661	java/lang/Integer
    //   302: invokevirtual 665	java/lang/Integer:intValue	()I
    //   305: istore_3
    //   306: iload_3
    //   307: iconst_1
    //   308: if_icmpeq +58 -> 366
    //   311: iload_3
    //   312: iconst_2
    //   313: if_icmpeq +32 -> 345
    //   316: iload_3
    //   317: iconst_4
    //   318: if_icmpeq +6 -> 324
    //   321: goto +63 -> 384
    //   324: iload_1
    //   325: iconst_m1
    //   326: if_icmpeq +8 -> 334
    //   329: iload_1
    //   330: iconst_4
    //   331: if_icmpne +53 -> 384
    //   334: aload 6
    //   336: aload 10
    //   338: invokevirtual 1251	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   341: pop
    //   342: goto +42 -> 384
    //   345: iload_1
    //   346: iconst_m1
    //   347: if_icmpeq +8 -> 355
    //   350: iload_1
    //   351: iconst_2
    //   352: if_icmpne +32 -> 384
    //   355: aload 5
    //   357: aload 10
    //   359: invokevirtual 1251	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   362: pop
    //   363: goto +21 -> 384
    //   366: iload_1
    //   367: iconst_m1
    //   368: if_icmpeq +8 -> 376
    //   371: iload_1
    //   372: iconst_1
    //   373: if_icmpne +11 -> 384
    //   376: aload 7
    //   378: aload 10
    //   380: invokevirtual 1251	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   383: pop
    //   384: iload_2
    //   385: iconst_1
    //   386: iadd
    //   387: istore_2
    //   388: goto -118 -> 270
    //   391: aload 7
    //   393: astore 4
    //   395: goto +24 -> 419
    //   398: aconst_null
    //   399: astore 6
    //   401: aload 6
    //   403: astore 5
    //   405: goto +14 -> 419
    //   408: aconst_null
    //   409: astore 4
    //   411: aload 4
    //   413: astore 5
    //   415: aload 5
    //   417: astore 6
    //   419: aload_0
    //   420: iload_1
    //   421: aload 8
    //   423: aload 4
    //   425: aload 5
    //   427: aload 6
    //   429: invokespecial 3303	com/tencent/mobileqq/app/QQAppInterface:putTroopTable	(ILjava/util/HashMap;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   432: aload 8
    //   434: areturn
    //   435: astore 4
    //   437: goto -294 -> 143
    //   440: astore 4
    //   442: goto -319 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	QQAppInterface
    //   0	445	1	paramInt	int
    //   10	378	2	i	int
    //   305	14	3	j	int
    //   12	412	4	localObject1	Object
    //   435	1	4	localException1	Exception
    //   440	1	4	localException2	Exception
    //   21	98	5	localObject2	Object
    //   126	15	5	localObject3	Object
    //   144	282	5	localObject4	Object
    //   30	74	6	localObject5	Object
    //   110	7	6	localObject6	Object
    //   268	160	6	localObject7	Object
    //   250	142	7	localArrayList	ArrayList
    //   7	426	8	localHashMap	HashMap
    //   236	55	9	localMap	java.util.Map
    //   288	91	10	str	String
    // Exception table:
    //   from	to	target	type
    //   79	87	110	finally
    //   14	79	126	finally
    //   14	79	435	java/lang/Exception
    //   79	87	440	java/lang/Exception
  }
  
  @Deprecated
  public int getTroopMask(String paramString)
  {
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopMask(this, paramString);
  }
  
  public String getUinDisplayNameBeforeLogin(String paramString)
  {
    Object localObject1 = getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Constants.PropertiesKey.uinDisplayName.toString());
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = ((MobileQQ)localObject1).getProperty(((StringBuilder)localObject2).toString());
    localObject1 = paramString;
    if (localObject2 != null)
    {
      if (((String)localObject2).length() == 0) {
        return paramString;
      }
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void getVideoConfigUpdate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, VideoConfigServlet.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public final boolean getVisibilityForInputStatus(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((InputStatusHandler)getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER)).a();
    }
    SharedPreferences localSharedPreferences = getPref();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131719131));
    localStringBuilder.append(getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public final boolean getVisibilityForNetWorkStatus(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getVisibilityForNetWorkStatus();
    }
    SharedPreferences localSharedPreferences = getPref();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131719133));
    localStringBuilder.append(getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  public void getVisibilitySwitches()
  {
    ((LBSHandler)getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a();
  }
  
  public void getZanSwitches()
  {
    ((CardHandler)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a();
  }
  
  public String getvKeyHexStr()
  {
    String str = getvKeyStr();
    if (str != null) {
      try
      {
        str = HexUtil.bytes2HexStr(str.getBytes("utf-8"));
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return null;
  }
  
  @Deprecated
  public String getvKeyStr()
  {
    return null;
  }
  
  public void handleReceivedMessage(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.messageNotifiableChecker = new MessageNotifiableChecker(this, paramInt, paramBoolean1, paramBoolean2);
    QQMessageFacade localQQMessageFacade = this.messageNotifiableChecker.a();
    if (localQQMessageFacade == null) {
      return;
    }
    com.tencent.imcore.message.Message localMessage = localQQMessageFacade.a();
    if (this.messageNotifiableChecker.a(localQQMessageFacade, localMessage)) {
      return;
    }
    this.messageNotifiableChecker.a();
    if (this.messageNotifiableChecker.a(localMessage))
    {
      if (this.messageNotifiableChecker.d(localMessage)) {
        return;
      }
      QQKRPUtil.a(this, localMessage.istroop, localMessage.msgUid);
      unitTestLog("reportEvent", new Object[] { this, Integer.valueOf(localMessage.istroop), Long.valueOf(localMessage.msgUid) });
      OpenApiManager.getInstance().onReceiveNewMsg(localMessage);
      unitTestLog("onReceiveNewMsg", new Object[] { localMessage });
      localQQMessageFacade.a.b(localMessage);
      notifyMessageReceived(localMessage, paramBoolean1, paramBoolean2);
      unitTestLog("notifyMessageReceived", new Object[] { localMessage, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    }
    else if (soundVibrateWhenNoNotification(paramBoolean1, paramBoolean2, localMessage))
    {
      return;
    }
    ((MiniMsgHandler)getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).a(localMessage.frienduin, localMessage.istroop, localMessage.msgtype);
    unitTestLog("notifyUnreadState", new Object[] { localMessage.frienduin, Integer.valueOf(localMessage.istroop), Integer.valueOf(localMessage.msgtype) });
    if (isLogin()) {
      ((IAppBadgeService)getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }
  }
  
  public Config initConfig(String paramString)
  {
    try
    {
      if (this.config == null) {
        this.config = new Config(this, paramString);
      }
      paramString = this.config;
      return paramString;
    }
    finally {}
  }
  
  public void initFaceSettingCache()
  {
    ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).initFaceSettingCache();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadreq");
    localIntentFilter.addAction("com.tencent.qqhead.refreshheadreq");
    getApp().registerReceiver(this.qqHeadBroadcastReceiver, localIntentFilter);
  }
  
  public void initSecureFileFramework()
  {
    getSecurityUINRootFile();
    SharedPreferences localSharedPreferences = this.app.getSharedPreferences("SecurityFileFrameworkManagerImpl", 4);
    Object localObject = localSharedPreferences.getString("SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecurityFileFramework", 2, new Object[] { "report=", localObject });
      }
      localObject = ((String)localObject).split("\\|");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        String[] arrayOfString;
        HashMap localHashMap;
        if (!TextUtils.isEmpty(localCharSequence))
        {
          arrayOfString = localCharSequence.split("#");
          localHashMap = new HashMap();
          int k = arrayOfString.length;
          if (k != 2)
          {
            if (k != 5) {
              break label354;
            }
            localHashMap.put("BusinessName", arrayOfString[0]);
            localHashMap.put("needMigrate", "true");
            localHashMap.put("doMigrate", arrayOfString[4]);
            localHashMap.put("fileSize", arrayOfString[2]);
            localHashMap.put("fileAmount", arrayOfString[3]);
          }
        }
        try
        {
          StatisticCollector.getInstance(getApp()).collectPerformance(getCurrentUin(), "SecureFileStep", true, 0L, 0L, localHashMap, "");
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label232:
          break label232;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface", 2, new Object[] { "SecureFile Report Error, NumberFormatException", localCharSequence });
        }
        break label354;
        localHashMap.put("BusinessName", arrayOfString[0]);
        localHashMap.put("needMigrate", "false");
        localHashMap.put("doMigrate", "null");
        localHashMap.put("fileSize", "-1");
        localHashMap.put("fileAmount", "-1");
        StatisticCollector.getInstance(getApp()).collectPerformance(getCurrentUin(), "SecureFileStep", true, 0L, 0L, localHashMap, "");
        label354:
        i += 1;
      }
      localSharedPreferences.edit().putString("SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", "").apply();
    }
    else
    {
      return;
    }
  }
  
  public boolean isAccLoginSuccess()
  {
    return (getAccount() != null) && (isLogin());
  }
  
  @TargetApi(14)
  public boolean isAccessibilityEnabled()
  {
    try
    {
      boolean bool = ((AccessibilityManager)this.app.getSystemService("accessibility")).isEnabled();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isAccessibilityEnabled()  isAccessibilityEnabled=");
        localStringBuilder.append(bool);
        QLog.i("QQAppInterface", 2, localStringBuilder.toString());
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label57:
      break label57;
    }
    return false;
  }
  
  public boolean isCallIdle()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)getApp().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public boolean isCreateManager(int paramInt)
  {
    return this.managers[paramInt] != null;
  }
  
  public boolean isFaceFileExist(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).isFaceFileExist(paramInt1, paramString, paramInt2, paramInt3);
  }
  
  public boolean isLBSFriendNewClient(String paramString)
  {
    paramString = getMsgCache().m(paramString);
    return (paramString != null) && (paramString.length > 0);
  }
  
  public boolean isNeedSecurityScan()
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(this.app);
    Object localObject2 = this.app;
    boolean bool2 = false;
    boolean bool3 = SettingCloneUtil.readValue((Context)localObject2, null, "security_scan_key", "qqsetting_security_scan_key", false);
    boolean bool4 = ((SharedPreferences)localObject1).getBoolean("security_scan_last_result", false);
    long l = ((SharedPreferences)localObject1).getLong("security_scan_last_time", 0L);
    localObject1 = new Date(l);
    localObject2 = new Date();
    ((Date)localObject1).setHours(0);
    ((Date)localObject1).setMinutes(0);
    ((Date)localObject1).setSeconds(0);
    boolean bool1 = bool2;
    if (bool3) {
      if ((l != 0L) && (((Date)localObject2).getTime() - ((Date)localObject1).getTime() <= 604800000L))
      {
        bool1 = bool2;
        if (!bool4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isOpenNoClearNotification()
  {
    try
    {
      localObject = getApp().getString(2131718840);
    }
    catch (Exception localException)
    {
      Object localObject;
      label14:
      boolean bool;
      break label14;
    }
    localObject = null;
    bool = false;
    if (localObject != null) {
      bool = SettingCloneUtil.readValue(getApp(), null, (String)localObject, "qqsetting_notify_icon_key", false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isOpenNoClearNotification");
      ((StringBuilder)localObject).append(bool);
      QLog.i("MobileQQService", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public final boolean isPhoneNumSearchable(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((CardHandler)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).b();
    }
    SharedPreferences localSharedPreferences = getPref();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131694972));
    localStringBuilder.append(getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  public boolean isPttRecordingOrPlaying()
  {
    CheckPttListener localCheckPttListener = this.checkPttListener;
    return (localCheckPttListener != null) && (localCheckPttListener.f());
  }
  
  public boolean isRingEqualsZero()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public boolean isRingerNormal()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 2);
  }
  
  public boolean isRingerNormalVibrate()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool5 = TextUtils.isEmpty((CharSequence)localObject);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if ((!bool5) && (((String)localObject).toLowerCase().contains("xiaomi")))
    {
      if (Settings.System.getInt(getApp().getContentResolver(), "vibrate_in_normal", -1) == 1) {
        bool1 = true;
      }
      return bool1;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      bool1 = bool2;
      if (Settings.System.getInt(getApp().getContentResolver(), "vibrate_on", -1) > 4) {
        bool1 = true;
      }
      return bool1;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      bool1 = bool3;
      if (Settings.System.getInt(getApp().getContentResolver(), "vibrate_on", -1) == 5) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool4;
    if (Settings.System.getInt(getApp().getContentResolver(), "vibrate_when_ringing", -1) == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean isRingerSilent()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    if (localAudioManager != null) {}
    try
    {
      i = localAudioManager.getRingerMode();
    }
    catch (Throwable localThrowable)
    {
      int i;
      label26:
      break label26;
    }
    i = 2;
    return i == 0;
  }
  
  public boolean isRingerVibrate()
  {
    boolean bool2 = false;
    try
    {
      AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
      boolean bool1 = bool2;
      if (localAudioManager != null)
      {
        int i = localAudioManager.getRingerMode();
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isRingerVibrate error: ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.i("QQAppInterface", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean isSelfNetworkStatusVisible(Friends paramFriends)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getApp().getString(2131719133));
    ((StringBuilder)localObject).append(getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    if (getPref().contains((String)localObject)) {
      return getPref().getBoolean((String)localObject, true);
    }
    return OnlineStatusUtils.a(paramFriends) ^ true;
  }
  
  public boolean isShowMsgContent()
  {
    return SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131718400), "qqsetting_notify_showcontent_key", true);
  }
  
  @Deprecated
  public boolean isTroopMark(com.tencent.imcore.message.Message paramMessage)
  {
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopMark(this, paramMessage.frienduin, paramMessage.istroop);
  }
  
  @Deprecated
  public boolean isTroopMark(String paramString, int paramInt)
  {
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopMark(this, paramString, paramInt);
  }
  
  public boolean isUsingCameraOnVideo()
  {
    Object localObject = this.mQQServiceRef;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((WeakReference)localObject).get() != null)
      {
        bool1 = bool2;
        if (isVideoChatting())
        {
          localObject = ((QQServiceForAV)this.mQQServiceRef.get()).a(1, 0, null);
          bool1 = bool2;
          if (localObject != null)
          {
            localObject = ((Bundle)localObject).getString("camera_used_desc", null);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isUsingCameraOnVideo, result[");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("]");
            QLog.w("QQAppInterface", 1, localStringBuilder.toString());
            bool1 = bool2;
            if (localObject != null) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isVideoChatting()
  {
    if (AVNotifyCenter.d())
    {
      AVLog.printColorLog("QQAppInterface", "VideoProcessAlive isBeInvitingOnDoubleVideo");
      return true;
    }
    if ((!getAVNotifyCenter().b()) && (getAVNotifyCenter().b() == 0)) {
      return false;
    }
    if (((IVideoProcessMonitor)QRoute.api(IVideoProcessMonitor.class)).isVideoProcessAlive()) {
      return true;
    }
    try
    {
      Object localObject = ((ActivityManager)getApp().getSystemService("activity")).getRunningAppProcesses();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:video"))
          {
            AVLog.printColorLog("QQAppInterface", "VideoProcessAlive VIDEO_PROCESS_NAME");
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void logout(boolean paramBoolean)
  {
    if (paramBoolean) {
      sendBindUinOffline();
    }
    Object localObject = (PushManager)getManager(5);
    int i = getAppid();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.app.getPackageName());
    localStringBuilder.append(":video");
    ((PushManager)localObject).unregistProxyMessagePush(i, localStringBuilder.toString());
    LoadingStateManager.a().a();
    release();
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "kickPC in app  do logout");
    }
    localObject = getCurrentAccountUin();
    if (localObject != null) {
      try
      {
        ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).cleanPwdRecord(getApp(), Long.parseLong((String)localObject));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    TextHook.getInstance().switchDefault();
    super.logout(paramBoolean);
  }
  
  public MessageNotifiableChecker messageNotifiableChecker()
  {
    return this.messageNotifiableChecker;
  }
  
  public void notifyFriendListSynced()
  {
    this.sLastGetOnlineFriendTime = SystemClock.uptimeMillis();
  }
  
  public void onConnAllFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onConnAllFailed");
    }
    LoadingStateManager.a().a(4);
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134013, null).sendToTarget();
    }
  }
  
  public void onConnClose()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onConnClose");
    }
    this.isMSFConnect = false;
    LoadingStateManager.a().a(1);
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    startServlet(new NewIntent(getApplication(), PushServlet.class));
    this.mqqService = new MobileQQServiceExtend(this);
    this.mqqService.a();
    this.mAutomator = new Automator(this);
    if (isAccLoginSuccess())
    {
      QCallFacade.a(this, System.currentTimeMillis());
      this.em = getEntityManagerFactory().createEntityManager();
      this.accountStartTime = System.currentTimeMillis();
      if (StartService.jdField_a_of_type_Boolean)
      {
        paramBundle = this.mAutomator;
        paramBundle.a(StepFactory.a(paramBundle, StepFactory.a));
      }
      if (StartService.jdField_a_of_type_Boolean) {
        ThemeUtil.initTheme(this);
      }
      initCallTabShowState();
      try
      {
        MagnifierSDK.a(Long.parseLong(getAccount()));
      }
      catch (Exception paramBundle)
      {
        QLog.e("QQAppInterface", 4, paramBundle.toString());
      }
    }
    ThreadManager.getSubThreadHandler().post(new QQAppInterface.1(this));
    if (StartService.jdField_a_of_type_Boolean) {
      FaceUtil.a();
    }
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
    if (isLogin())
    {
      QQDtReportHelper.a(2);
      QQDtReportHelper.c();
      if (Foreground.isCurrentProcessForeground()) {
        QQDtReportHelper.jdField_a_of_type_Boolean = true;
      }
    }
    this.mFirstGetSubAccountName = true;
    getQlinkServiceMgr().a();
    getFileManagerDataCenter().c();
    getQQProxyForQlink().a();
    PluginManageHandler.getInstance().setPluginManagerProvider(this, false);
    onCreateDebug();
    TroopFileDownloadMgr.a().a();
    TroopFileThumbnailMgr.a().a();
    StoryApi.a(this);
  }
  
  public void onCreateDebug() {}
  
  protected void onCreateQQMessageFacade(QQMessageFacade paramQQMessageFacade)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateQQMessageFacade() called with: msgFacade = [");
      localStringBuilder.append(paramQQMessageFacade);
      localStringBuilder.append("]");
      QLog.d("QQAppInterface", 2, localStringBuilder.toString());
    }
    new QQMessageFacadeConfig(paramQQMessageFacade).start();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mConfigProcess.a();
    BaseApplicationImpl.sShowTime = 0L;
    BaseApplicationImpl.sLaunchTime = 0L;
    BaseApplicationImpl.appStartTime = 0L;
    FMTSrvAddrProvider.destroy();
    release();
    ThemeUiPlugin.destroy(this);
    ChatBackgroundManager.b();
    AppNetConnInfo.unregisterNetInfoHandler(this.netHandler);
    Object localObject = this.sGetOnlineFriendHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    ThreadManager.getSubThreadHandler().post(new QQAppInterface.15(this));
    ThreadManager.excute(new QQAppInterface.16(this), 80, null, false);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "QQAppInterface onDestroy removeNotification");
    }
    removeNotification();
    if (QLog.isColorLevel()) {
      QLog.d("security_scan", 2, "Unregist Cloud Scan Listener");
    }
    localObject = this.mAVNotifyCenter;
    if (localObject != null) {
      ((AVNotifyCenter)localObject).a();
    }
    localObject = this.mMultiMsgController;
    if (localObject != null)
    {
      ((MultiMsgController)localObject).a();
      this.mMultiMsgController = null;
    }
    Config.a();
    OpenApiManager.getInstance().onRuntimeDestroy(this);
    AppLaucherHelper.a();
    ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).clearInstance(this);
    localObject = this.mOnlineFileSessionCenter;
    if (localObject != null) {
      ((OnlineFileSessionCenter)localObject).e();
    }
    if (this.mHwEngine != null) {
      this.mHwEngine.closeEngine();
    }
    if (!TextUtils.isEmpty(getCurrentAccountUin())) {
      QQOperateManager.b();
    }
    if (this.mFileManagerDataCenter != null) {
      getFileManagerDataCenter().d();
    }
    if (this.mQQProxyForQlink != null) {
      getQQProxyForQlink().c();
    }
    localObject = PresendPicMgr.a(null);
    if (localObject != null) {
      ((PresendPicMgr)localObject).b();
    }
    if (InnerDns.mInstance != null) {
      InnerDns.getInstance().onAppDestroy();
    }
    localObject = this.lockDetectHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    ((IQIMManager)QRoute.api(IQIMManager.class)).destory();
    this.mHeadGetIntents.clear();
  }
  
  public RemotePluginManager.Stub onGetPluginManager()
  {
    return (PluginManagerV2)getManager(QQManagerFactory.MGR_PLUGIN);
  }
  
  public void onMessageConnect()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onMessageConnect...");
    }
    Object localObject1;
    if (this.mAutomator != null)
    {
      if (!isAccLoginSuccess()) {
        return;
      }
      if (this.mAutomator != null)
      {
        localObject1 = this.msgCache;
        if (localObject1 != null) {
          ((MessageCache)localObject1).f();
        }
        this.mAutomator.b();
      }
      setLoadingState();
      ((IPicPreDownload)getRuntimeService(IPicPreDownload.class, "")).switchOff();
      getShortVideoPredownloer().a();
      ((IScribbleDownloader)getRuntimeService(IScribbleDownloader.class)).off();
    }
    try
    {
      localObject2 = getCurrentProcess();
      localObject1 = BaseApplication.getContext();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("pull_msf");
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject3 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
      localObject4 = ((SharedPreferences)localObject3).getString("uin", " ");
      localObject5 = ((SharedPreferences)localObject3).getString("time", "0");
      bool1 = ((SharedPreferences)localObject3).getBoolean("proxy", false);
      bool2 = ((SharedPreferences)localObject3).getBoolean("vivo", false);
      i = ((SharedPreferences)localObject3).getInt("param_FailCode", 0);
      bool3 = ((SharedPreferences)localObject3).getBoolean("mainProcess", false);
      localObject1 = ((SharedPreferences)localObject3).getString("sdkver", " ");
      boolean bool4 = ((String)localObject4).equals(" ");
      if ((bool4) || (((String)localObject5).equals("0"))) {
        break label1032;
      }
      if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L)) {
        RegisterProxy.a |= 0x4;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", localObject4);
      localHashMap.put("time", localObject5);
      localHashMap.put("process", ((SharedPreferences)localObject3).getString("process", ""));
      localHashMap.put("availMem", ((SharedPreferences)localObject3).getString("availMem", ""));
      localHashMap.put("lowMem", ((SharedPreferences)localObject3).getString("lowMem", ""));
      localHashMap.put("state", ((SharedPreferences)localObject3).getString("state", ""));
      localHashMap.put("version", "150806");
      localHashMap.put("build", "5295");
      localHashMap.put("proxy", String.valueOf(bool1));
      localHashMap.put("vivo", String.valueOf(bool2));
      localHashMap.put("param_FailCode", String.valueOf(i));
      localHashMap.put("mainProcess", String.valueOf(bool3));
      localHashMap.put("sdkver", String.valueOf(localObject1));
      if (Build.VERSION.SDK_INT >= 21) {
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReport_V3", false, 0L, 0L, localHashMap, "");
      } else {
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReportOther_V3", false, 0L, 0L, localHashMap, "");
      }
      localObject3 = ((SharedPreferences)localObject3).edit();
      ((SharedPreferences.Editor)localObject3).clear();
      ((SharedPreferences.Editor)localObject3).commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        boolean bool1;
        boolean bool2;
        int i;
        boolean bool3;
      }
    }
    localObject3 = BaseApplication.getContext();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("pull_msf_succ");
    ((StringBuilder)localObject4).append((String)localObject2);
    localObject2 = ((BaseApplication)localObject3).getSharedPreferences(((StringBuilder)localObject4).toString(), 0);
    localObject3 = ((SharedPreferences)localObject2).getString("uin", " ");
    localObject4 = ((SharedPreferences)localObject2).getString("time", "0");
    if ((!((String)localObject3).equals(" ")) && (!((String)localObject4).equals("0")))
    {
      if ((getMsfPullFilterSwitch(this)) && (BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L)) {
        RegisterProxy.a |= 0x2;
      }
      localObject5 = new HashMap();
      ((HashMap)localObject5).put("uin", localObject3);
      ((HashMap)localObject5).put("time", localObject4);
      ((HashMap)localObject5).put("process", ((SharedPreferences)localObject2).getString("process", ""));
      ((HashMap)localObject5).put("availMem", ((SharedPreferences)localObject2).getString("availMem", ""));
      ((HashMap)localObject5).put("lowMem", ((SharedPreferences)localObject2).getString("lowMem", ""));
      ((HashMap)localObject5).put("state", ((SharedPreferences)localObject2).getString("state", ""));
      ((HashMap)localObject5).put("version", "150806");
      ((HashMap)localObject5).put("build", "5295");
      ((HashMap)localObject5).put("proxy", String.valueOf(bool1));
      ((HashMap)localObject5).put("vivo", String.valueOf(bool2));
      ((HashMap)localObject5).put("param_FailCode", String.valueOf(i));
      ((HashMap)localObject5).put("mainProcess", String.valueOf(bool3));
      ((HashMap)localObject5).put("sdkver", String.valueOf(localObject1));
      if (Build.VERSION.SDK_INT >= 21) {
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReport_succ_V2", false, 0L, 0L, (HashMap)localObject5, "");
      } else {
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReport_succOther_V2", false, 0L, 0L, (HashMap)localObject5, "");
      }
      localObject1 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject1).clear();
      ((SharedPreferences.Editor)localObject1).commit();
      return;
      QLog.d("QQAppInterface", 1, "Failed to report pull Msf Event");
    }
  }
  
  public void onNetNeedSignon(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkIfNeedSignonNet onNetNeedSignon() called url:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQAppInterface", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = android.os.Message.obtain();
    ((android.os.Message)localObject).arg1 = 2;
    ((android.os.Message)localObject).obj = paramString;
    BannerManager.a().a(NetNeedSignOnBannerProcessor.a, 2, (android.os.Message)localObject);
  }
  
  protected void onProcPause()
  {
    super.onProcPause();
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onProcPause");
    }
    if (isLogin()) {
      ((IAppBadgeService)getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }
  }
  
  protected void onProcResume()
  {
    super.onProcResume();
  }
  
  public void onProxyIpChanged() {}
  
  public boolean onReceiveUnhandledKickedMsg(String paramString, Intent paramIntent)
  {
    if ((GuardManager.a != null) && (!GuardManager.a.a("com.tencent.mobileqq")) && (Build.VERSION.SDK_INT > 28) && ("mqq.intent.action.ACCOUNT_KICKED".equals(paramString)))
    {
      setKickIntent(paramIntent);
      showKickedNotification(paramIntent);
      return true;
    }
    return false;
  }
  
  public void onRecvFistResp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRecvFistResp");
    }
    this.isMSFConnect = true;
    Object localObject = getHandler(Conversation.class);
    if (!LoadingStateManager.a().c())
    {
      LoadingStateManager.a().a(2);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(1134012, null).sendToTarget();
      }
    }
    else if ((LoadingStateManager.a().a()) && (localObject != null))
    {
      ((MqqHandler)localObject).obtainMessage(1134015, null).sendToTarget();
    }
    if (localObject != null)
    {
      localObject = android.os.Message.obtain();
      ((android.os.Message)localObject).arg1 = 0;
      BannerManager.a().a(NetNeedSignOnBannerProcessor.a, 0, (android.os.Message)localObject);
    }
  }
  
  public void onRunningBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningBackground");
    }
    super.onRunningBackground();
    if (!TextUtils.isEmpty(getAccount())) {
      onRunningBackgroundWithAccount();
    }
    onRunningBackgroundCommon();
  }
  
  public void onRunningBackgroundCommon()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningBackgroundGeneral");
    }
    if (((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).allIsInit()) {
      ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).stopRecord("main process onRunningBackground");
    }
    onRunningBackgroundDoReportForReadInJoy();
    if (isLogin()) {
      ((IAppBadgeService)getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }
    Object localObject1 = this.proxyManager;
    if (localObject1 != null) {
      ((ProxyManager)localObject1).saveNotify();
    }
    ReportController.a(this);
    getFileTransferHandler().b();
    localObject1 = (QzoneAlbumRedTouchManager)getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH);
    if (localObject1 != null) {
      ((QzoneAlbumRedTouchManager)localObject1).c();
    }
    localObject1 = (MediaPlayerManager)this.managers[QQManagerFactory.MGR_MEDIA_PLAYER];
    if ((localObject1 != null) && (((MediaPlayerManager)localObject1).a())) {
      ((MediaPlayerManager)localObject1).a(false);
    }
    cancelSyncOnlineFriend(-1L);
    checkDialogOnBackground();
    DeviceStabilityMonitor.a(BaseApplicationImpl.getContext());
    DeviceAbilityCollector.a(BaseApplicationImpl.getContext());
    SPStatReporter.a(BaseApplicationImpl.getContext());
    LpReportManager.getInstance().startReportImediately(2);
    AdvertisementRecentUserManager.a().a();
    ImaxAdRecentUserManager.a().b();
    GestureMgrAppDownload.a(this);
    MessageStatisticHelper.a();
    if (!TextUtils.isEmpty(getAccount())) {
      ((IPicPreDownload)getRuntimeService(IPicPreDownload.class)).commitTrafficPref();
    }
    JobReporter.reportThreadPeakCount(getCurrentAccountUin());
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportLeaveQQ();
    try
    {
      QLogReporter.a().a();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    FDStats.a().b();
    UserguideActivity.a();
    HardCoderManager.a().c();
    ArkStateCenter.getInstance().setForeground(false);
    Object localObject2 = (PushNoticeManager)getManager(QQManagerFactory.PUSH_NOTICE_MANAGER);
    if (localObject2 != null) {
      ((PushNoticeManager)localObject2).a();
    }
    ((IVideoExtractFrameManager)QRoute.api(IVideoExtractFrameManager.class)).onEnterBackground();
    checkRamForAvideo();
    ((IOfflineUtils)QRoute.api(IOfflineUtils.class)).preCache(true);
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).onEnterBackground();
    NatMemAPI.a();
    WtloginReporter.a(this);
    if (isLogin())
    {
      localObject2 = (MayknowRecommendManager)getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (localObject2 != null) {
        ((MayknowRecommendManager)localObject2).j();
      }
    }
    localObject2 = (IAvGameManager)getRuntimeService(IAvGameManager.class, "");
    if (localObject2 != null) {
      ((IAvGameManager)localObject2).onEnterBackground();
    }
    FightMsgReporter.b();
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).onEnterBackground();
  }
  
  public void onRunningForegroudCommon()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningForegroudGeneral");
    }
    if (((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).allIsInit()) {
      ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).startRecord("main process onRunningForeground");
    }
    ReportController.b(this, "CliOper", "", "", "0X8004014", "0X8004014", 0, 0, "", "", "", "");
    Object localObject = getMessageFacade();
    if ((localObject != null) && (((QQMessageFacade)localObject).b() > 1)) {
      ReportController.b(this, "CliOper", "", "", "0X8004015", "0X8004015", 0, 0, "", "", "", "");
    }
    if (((IReadInJoyGlobalReporter)QRoute.api(IReadInJoyGlobalReporter.class)).needReport())
    {
      ((IReadInJoyGlobalReporter)QRoute.api(IReadInJoyGlobalReporter.class)).rsetEnterTime(this, NetConnInfoCenter.getServerTimeMillis());
      ((IReadInJoyGlobalReporter)QRoute.api(IReadInJoyGlobalReporter.class)).setAPPStatus(2);
    }
    ReportController.a(this, false);
    QlinkReliableReport.a();
    localObject = new Intent("com.tencent.intent.QZONE_PRE_DOWNLOAD_CANCEL");
    BaseApplication.getContext().sendBroadcast((Intent)localObject);
    localObject = (GameCenterManagerImp)getManager(QQManagerFactory.GAMECENTER_MANAGER);
    if (localObject != null)
    {
      ((GameCenterManagerImp)localObject).a();
      if (isLogin())
      {
        ((IRedTouchManager)getRuntimeService(IRedTouchManager.class, "")).checkMsgExpire();
        ((IRedTouchServer)getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(false, true, 2);
      }
    }
    localObject = (QZoneManager)getManager(QQManagerFactory.QZONE_MANAGER);
    if (localObject != null)
    {
      if (((QZoneManager)localObject).a() > 0) {
        ((QZoneManager)localObject).a(((QZoneManager)localObject).a());
      }
      ((QZoneManager)localObject).a(2);
    }
    if (MobileQQ.sMobileQQ.waitAppRuntime(null).isLogin())
    {
      localObject = QCircleUtils.a();
      if (localObject != null) {
        ((IQCircleEeveeManangerService)localObject).onSend(2, null, null);
      }
      localObject = QCircleUtils.a();
      if (localObject != null) {
        ((IQCirclePreLoaderService)localObject).requestWhiteList(getCurrentUin());
      }
    }
    ((IQWalletPayApi)QRoute.api(IQWalletPayApi.class)).onQQForeground(this, false);
    QQUtils.a(getApp().getBaseContext());
    StatisticCollector.getInstance(BaseApplicationImpl.sApplication).reportDailyUser(this);
    syncOnlineFriend();
    QQToast.a();
    if (isCreateManager(QQManagerFactory.MGR_PLUGIN)) {
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getPayCode(this);
    }
    localObject = (IQWalletConfigService)getRuntimeService(IQWalletConfigService.class, "");
    if (localObject != null) {
      ((IQWalletConfigService)localObject).tryGetConfig(4);
    }
    if ((isLogin()) && (Build.VERSION.SDK_INT >= 23) && (this.isRealSwitchToBackground)) {
      checkBackgroundRestricWhilteList();
    }
    localObject = getNowLiveManager();
    if ((localObject != null) && (((NowLiveManager)localObject).jdField_a_of_type_Boolean) && ((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.currentFragment == 1)) {
      StoryReportor.a("story_tab", "exp", 0, ((TroopRedTouchManager)getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).b(), new String[] { "", "", "", "" });
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportInForeground();
    VipGrayConfigHelper.a();
    localObject = (IEcshopAdHandler)getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
    if (localObject != null) {
      ((IEcshopAdHandler)localObject).a();
    }
    ThreadManager.executeOnFileThread(new QQAppInterface.18(this));
    QLog.d("QQAppInterface", 2, "**davorteng**onRunningForeground...");
    localObject = (SmartDeviceProxyMgr)getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if (localObject != null) {
      ((SmartDeviceProxyMgr)localObject).c();
    }
    ((ICmShowRscUpdateHandler)QRoute.api(ICmShowRscUpdateHandler.class)).checkUpdateAsync(this);
    ((IVideoExtractFrameManager)QRoute.api(IVideoExtractFrameManager.class)).onEnterForeground();
    ArkStateCenter.getInstance().setForeground(true);
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).onEnterForeground();
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).onEnterForeground();
    TianShuManager.setLastClickAdTraceInfo("", "");
    avGameOnEnterForeground();
    onLineStatusOnAppForeground();
    ((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).preloadWebProcessAsync(2);
    ((IQQGameAdService)QRoute.api(IQQGameAdService.class)).doOnRunningForeground();
  }
  
  public void onRunningForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningForeground");
    }
    super.onRunningForeground();
    if (!TextUtils.isEmpty(getAccount())) {
      onRunningForegroundWithAccount();
    }
    onRunningForegroudCommon();
  }
  
  public void onWeakNet() {}
  
  public void onWeakNet(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWeakNet message: ");
      localStringBuilder.append(paramString);
      QLog.d("QQAppInterface", 2, localStringBuilder.toString());
    }
  }
  
  public void onX2Mobile()
  {
    if ((this.app != null) && (isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Mobile ");
      }
      Object localObject1 = (ITransFileController)getRuntimeService(ITransFileController.class);
      boolean bool1 = ((ITransFileController)localObject1).getBusHelper().pauseAllRawSend();
      boolean bool2 = ((ITransFileController)localObject1).getBusHelper().pauseAllShortVideoSend();
      boolean bool3 = ((ITransFileController)localObject1).getBusHelper().pauseAllShortVideoReceive();
      Object localObject2 = BaseActivity.sTopActivity;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.app;
      }
      if ((bool1) || (bool2) || (bool3))
      {
        localObject2 = new Intent((Context)localObject1, DialogActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).addFlags(131072);
        int i = 2131691254;
        if (bool2)
        {
          if (bool3) {
            i = 2131691255;
          } else if (!bool1) {
            i = 2131691252;
          }
        }
        else if (bool3)
        {
          if (!bool1) {
            i = 2131691250;
          }
        }
        else {
          i = 2131691253;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onX2Mobile==============pauseAllRawSendC2C:");
          localStringBuilder.append(bool1);
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onX2Mobile==============pauseAllShortVideoSend:");
          localStringBuilder.append(bool2);
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onX2Mobile==============pauseAllShortVideoReceive:");
          localStringBuilder.append(bool3);
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onX2Mobile==============dialog message:");
          localStringBuilder.append(((Context)localObject1).getResources().getString(i));
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
        }
        ((Intent)localObject2).putExtra("key_dialog_msg_id", i);
        ((Context)localObject1).startActivity((Intent)localObject2);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("QQAppInterface", 2, "onX2Mobile app = null,maybe not QQ process");
    }
  }
  
  public void onX2Wifi()
  {
    if (this.app != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Wifi ");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onX2Wifi app = null,maybe not QQ process");
    }
  }
  
  public void oneWayMessageNotifyVibert(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((1010 == paramMessageRecord.istroop) || (1001 == paramMessageRecord.istroop) || (10002 == paramMessageRecord.istroop))
    {
      boolean bool = ((KeyguardManager)this.app.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      com.tencent.imcore.message.Message localMessage = new com.tencent.imcore.message.Message();
      MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
      if ((!this.isBackgroundPause) && (!this.isBackgroundStop) && (!bool))
      {
        vibratorAndAudio(localMessage, paramBoolean ^ true, true);
        return;
      }
      Intent localIntent = new Intent(getApp(), MsgBoxListActivity.class);
      localIntent.addFlags(335544320);
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("OneWayMessageNotifyVibert mr.frienduin");
        ((StringBuilder)localObject1).append(paramMessageRecord.frienduin);
        ((StringBuilder)localObject1).append(", mr.istroop");
        ((StringBuilder)localObject1).append(paramMessageRecord.istroop);
        QLog.d("QQAppInterface", 2, ((StringBuilder)localObject1).toString());
      }
      if (1010 == paramMessageRecord.istroop)
      {
        localIntent.putExtra("uin", AppConstants.DATE_UIN);
        localIntent.putExtra("uintype", paramMessageRecord.istroop);
      }
      else if ((1001 == paramMessageRecord.istroop) || (10002 == paramMessageRecord.istroop))
      {
        localObject1 = AppConstants.LBS_HELLO_UIN;
        if (!MsgBoxUtil.b(paramMessageRecord)) {
          localObject1 = AppConstants.NEARBY_LBS_HELLO_UIN;
        }
        localIntent.putExtra("uin", (String)localObject1);
        localIntent.putExtra("uintype", paramMessageRecord.istroop);
      }
      localIntent.setAction("com.tencent.mobileqq.action.CHAT");
      localIntent.putExtra("uinname", "");
      localIntent.putExtra("entrance", 6);
      localIntent.putExtra("key_notification_click_action", true);
      Bitmap localBitmap;
      Object localObject2;
      Object localObject4;
      Object localObject3;
      if ((paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 10002))
      {
        localBitmap = null;
        localObject2 = "";
        localObject1 = localObject2;
        localObject4 = localObject1;
        localObject3 = localObject1;
      }
      else
      {
        localBitmap = SkinUtils.a(getApp().getResources().getDrawable(2130840421));
        localObject1 = BaseApplicationImpl.getApplication();
        int i;
        if (paramMessageRecord.istroop == 1001) {
          i = 2131693574;
        } else {
          i = 2131719757;
        }
        localObject3 = ((BaseApplicationImpl)localObject1).getString(i);
        localObject1 = BaseApplicationImpl.getApplication();
        if (paramMessageRecord.istroop == 1001) {
          i = 2131693573;
        } else {
          i = 2131719756;
        }
        localObject4 = ((BaseApplicationImpl)localObject1).getString(i);
        localIntent.putExtra("key_notifycation_oneway_message", true);
        Object localObject5 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
        localObject2 = localObject3;
        localObject1 = localObject4;
        if (((String)localObject5).length() > 0)
        {
          localObject5 = ((String)localObject5).split("\\|");
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (localObject5.length >= 6)
          {
            localObject2 = localObject5[4];
            localObject1 = localObject5[5];
          }
        }
        localObject4 = localObject1;
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
      MessageNotificationGenerator.a(this, paramMessageRecord, new NotificationElement(localIntent, (String)localObject2, (String)localObject3, (String)localObject4, localBitmap), "CMD_SHOW_NOTIFIYCATION");
      if (QQUtils.a(getApp()))
      {
        paramMessageRecord = (QQLSRecentManager)getManager(QQManagerFactory.QQLS_DATA_MANAGER);
        if (SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131693837), "qqsetting_lock_screen_whenexit_key", true)) {
          if (1001 == localMessage.istroop)
          {
            paramMessageRecord.a(this, AppConstants.LOCK_SCREEN_LBS_HELLO_UIN, localMessage.istroop, false, MsgPushReportHelper.a(localMessage.frienduin, localMessage.istroop, localIntent));
            ReportController.b(this, "dc00899", "grp_lbs", "", "msg_box", "notice_msg", 0, 0, "", "", "", "");
          }
          else if (1010 == localMessage.istroop)
          {
            paramMessageRecord.a(this, AppConstants.LOCK_SCREEN_DATE_UIN, localMessage.istroop, false, MsgPushReportHelper.a(localMessage.frienduin, localMessage.istroop, localIntent));
          }
        }
      }
      vibratorAndAudio(localMessage, paramBoolean ^ true, true);
    }
  }
  
  public void playThemeVoice(int paramInt)
  {
    execute(new QQAppInterface.12(this, paramInt));
  }
  
  public void putBitmapToCache(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).putBitmapToCache(paramString, paramBitmap, paramByte);
  }
  
  public int readCallTabStateVal(int paramInt)
  {
    Object localObject;
    if ((this.app != null) && (paramInt >= 0) && (paramInt < 7))
    {
      localObject = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
      if ((localObject != null) && (((String)localObject).length() == 7))
      {
        int i = ((String)localObject).charAt(paramInt) - '0';
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("uin:");
          ((StringBuilder)localObject).append(getCurrentAccountUin());
          ((StringBuilder)localObject).append(",readCallTabStateVal index=");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(", resut=");
          ((StringBuilder)localObject).append(i);
          QLog.i("QQAppInterface", 2, ((StringBuilder)localObject).toString());
        }
        return i;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQAppInterface", 2, "readCallTabStateVal val is null");
      }
      return -1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readCallTabStateVal wrong index,");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("QQAppInterface", 2, ((StringBuilder)localObject).toString());
    }
    return -1;
  }
  
  public void receiveToService(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    super.receiveToService(paramToServiceMsg, paramFromServiceMsg);
    if (AppSetting.e())
    {
      ParcelHooker localParcelHooker = getParcelHooker();
      try
      {
        localParcelHooker.a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Throwable paramToServiceMsg)
      {
        QLog.e("QQAppInterface", 1, "receiveToService: ", paramToServiceMsg);
      }
    }
  }
  
  boolean recordingPttStopped()
  {
    CheckPttListener localCheckPttListener = this.checkPttListener;
    return (localCheckPttListener == null) || (!localCheckPttListener.f());
  }
  
  public void refreshFace(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    IQQAvatarHandlerService localIQQAvatarHandlerService = (IQQAvatarHandlerService)getRuntimeService(IQQAvatarHandlerService.class, "");
    if (localIQQAvatarHandlerService != null)
    {
      if (paramString.startsWith("+"))
      {
        localIQQAvatarHandlerService.getMobileQQHead(paramString);
        return;
      }
      localIQQAvatarHandlerService.getCustomHead(paramString);
    }
  }
  
  public void refreshMsgTabUnreadNum(boolean paramBoolean, int paramInt)
  {
    MsgTabUnreadListener localMsgTabUnreadListener = this.mMsgTabUnreadListener;
    if (localMsgTabUnreadListener != null)
    {
      localMsgTabUnreadListener.a(paramBoolean, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQAppInterface", 2, String.format(Locale.getDefault(), "refreshMsgTabUnreadNum mMsgTabUnreadListener is null, [%b, %d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
  }
  
  public void refreshMultiAIOUnreadNum(String paramString, int paramInt)
  {
    MultiAIOUnreadListener localMultiAIOUnreadListener = this.mMultiAIOUnreadListener;
    if (localMultiAIOUnreadListener != null) {
      localMultiAIOUnreadListener.a(paramString, paramInt);
    }
  }
  
  public void refreshStrangerFace(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshStrangerFace.id=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",idType=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",delLocalCache=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("Q.qqhead.", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((paramInt != 200) && (paramInt != 204) && (paramInt != 202)) {
      return;
    }
    if (paramBoolean)
    {
      removeFaceIconCache(32, paramString, paramInt);
      localObject = new File(getCustomFaceFilePath(32, paramString, paramInt));
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
    Object localObject = (IQQAvatarHandlerService)getRuntimeService(IQQAvatarHandlerService.class, "");
    if (localObject != null) {
      ((IQQAvatarHandlerService)localObject).getStrangerHead(paramString, paramInt, (byte)1, (byte)0);
    }
  }
  
  public void refreshTroopFace(String paramString)
  {
    IQQAvatarHandlerService localIQQAvatarHandlerService = (IQQAvatarHandlerService)getRuntimeService(IQQAvatarHandlerService.class, "");
    if (localIQQAvatarHandlerService != null) {
      localIQQAvatarHandlerService.getTroopHead(paramString);
    }
  }
  
  public void releaseAvAddFriendService()
  {
    AvAddFriendService localAvAddFriendService = this.mAvAddFriendService;
    if (localAvAddFriendService != null)
    {
      localAvAddFriendService.a();
      this.mAvAddFriendService = null;
    }
  }
  
  public void removeAboutListener(ResourcePluginListener paramResourcePluginListener)
  {
    AboutConfig localAboutConfig = this.aboutConfig;
    if (localAboutConfig != null) {
      localAboutConfig.b(paramResourcePluginListener);
    }
  }
  
  public void removeBitmapFromCache(String paramString)
  {
    ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(paramString);
  }
  
  public void removeFaceIconCache(int paramInt1, String paramString, int paramInt2)
  {
    ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).removeFaceIconCache(paramInt1, paramString, paramInt2);
  }
  
  public void removeFaceIconCacheApollo(int paramInt1, String paramString, int paramInt2)
  {
    ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).removeFaceIconCacheApollo(paramInt1, paramString, paramInt2);
  }
  
  public void removeNotification()
  {
    ThreadManager.post(new QQAppInterface.9(this), 10, null, true);
    try
    {
      sendToService(new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "CMD_STOP_NOTIFIYCATION"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void removeVibrateListener(VibrateListener paramVibrateListener)
  {
    if (paramVibrateListener == null) {
      return;
    }
    this.vibrateListenerList.remove(paramVibrateListener);
  }
  
  public void sendQQHeadBroadcast(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    ((IQQAvatarBroadcastService)getRuntimeService(IQQAvatarBroadcastService.class, "")).sendQQHeadBroadcast(paramInt1, paramString1, paramInt2, paramString2);
  }
  
  public void sendRegisterPush()
  {
    if (isAccLoginSuccess())
    {
      Object localObject1 = (PushManager)getManager(5);
      int i = getAppid();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.app.getPackageName());
      ((StringBuilder)localObject2).append(":video");
      ((PushManager)localObject1).registProxyMessagePush(i, ((StringBuilder)localObject2).toString(), "com.tencent.av.ui.VChatActivity", new String[] { "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c" });
      localObject1 = (PushManager)getManager(5);
      i = getAppid();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.app.getPackageName());
      ((StringBuilder)localObject2).append(":nearby_video");
      ((PushManager)localObject1).registProxyMessagePush(i, ((StringBuilder)localObject2).toString(), "", new String[] { "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c" });
      IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)getRuntimeService(IOnlineStatusService.class);
      localIOnlineStatusService.registerObserver();
      boolean bool = getCurLoginStatus();
      long l2 = this.app.getSharedPreferences(getAccount(), 0).getInt("GetFrdListReq_seq", 0);
      localObject2 = localIOnlineStatusService.getOnlineStatus();
      localObject1 = getApp();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("acc_info");
      ((StringBuilder)localObject3).append(getAccount());
      localObject3 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
      if ((localObject2 != null) && (localObject2 != AppRuntime.Status.offline))
      {
        localObject1 = localObject2;
        if (localObject2 != AppRuntime.Status.receiveofflinemsg) {}
      }
      else
      {
        localObject2 = AppRuntime.Status.build(((SharedPreferences)localObject3).getInt("getProfileStatusNew", AppRuntime.Status.online.getValue()));
        if ((localObject2 != null) && (localObject2 != AppRuntime.Status.offline))
        {
          localObject1 = localObject2;
          if (localObject2 != AppRuntime.Status.receiveofflinemsg) {}
        }
        else
        {
          localObject1 = AppRuntime.Status.online;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sendRegisterPush, change to online, status: ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("QQAppInterface", 1, ((StringBuilder)localObject2).toString());
        }
      }
      long l1;
      if (localObject1 == AppRuntime.Status.online)
      {
        l1 = localIOnlineStatusService.getExtOnlineStatus();
        if (l1 == -1L)
        {
          l1 = ((SharedPreferences)localObject3).getLong("getOnlineStatusExt", -1L);
          if (l1 == -1L)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("sendRegisterPush, change to online, ext_status: ");
            ((StringBuilder)localObject2).append(l1);
            QLog.d("QQAppInterface", 1, ((StringBuilder)localObject2).toString());
          }
        }
      }
      else
      {
        l1 = -1L;
      }
      localIOnlineStatusService.checkBatteryStatus();
      localIOnlineStatusService.sendOnlineStatusWithExt((AppRuntime.Status)localObject1, bool, l2, false, l1);
      this.mRegisterPushTime = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 4, String.format("sendRegisterPush onlineStatus: %s, isKickPC: %s, largeSeq: %s, mRegisterPushTime: %s", new Object[] { localObject1, Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(this.mRegisterPushTime) }));
      }
    }
  }
  
  public void sendSelfQQHeadBroadcast(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    ((IQQAvatarBroadcastService)getRuntimeService(IQQAvatarBroadcastService.class, "")).sendSelfQQHeadBroadcast(paramInt1, paramString1, paramInt2, paramString2);
  }
  
  public void setALLGeneralSettingRing(int paramInt)
  {
    ((IRoamSettingService)getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue("message.ring.switch", Integer.valueOf(paramInt));
  }
  
  public void setALLGeneralSettingVibrate(int paramInt)
  {
    ((IRoamSettingService)getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue("message.vibrate.switch", Integer.valueOf(paramInt));
  }
  
  public void setAllTroopsReceiveStatus(boolean paramBoolean) {}
  
  public void setAutoLogin(boolean paramBoolean)
  {
    String str;
    if (!getCurrentAccountUin().equals("0")) {
      str = getCurrentAccountUin();
    } else {
      str = "";
    }
    SharedPreUtils.a(getApplication().getApplicationContext(), str, paramBoolean);
  }
  
  public void setC2CRoamingSetting(int paramInt)
  {
    ((IRoamSettingService)getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue("sync.c2c_message", Integer.valueOf(paramInt));
  }
  
  public void setCheckPttListener(CheckPttListener paramCheckPttListener)
  {
    this.checkPttListener = paramCheckPttListener;
  }
  
  public void setCheckPtvListener(CheckPtvListener paramCheckPtvListener)
  {
    this.checkPtvListener = paramCheckPtvListener;
  }
  
  public void setLoadingState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onConnOpenAndStartGetMsg");
    }
    LoadingStateManager.a().a(1);
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void setMainActivityState(boolean paramBoolean)
  {
    this.mainActivityIsForeground = paramBoolean;
  }
  
  public void setMsgTabUnreadListener(MsgTabUnreadListener paramMsgTabUnreadListener)
  {
    this.mMsgTabUnreadListener = paramMsgTabUnreadListener;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMsgTabUnreadListener lis: ");
      localStringBuilder.append(paramMsgTabUnreadListener);
      QLog.i("QQAppInterface", 2, localStringBuilder.toString());
    }
  }
  
  public void setMultiAIOUnreadListener(MultiAIOUnreadListener paramMultiAIOUnreadListener)
  {
    this.mMultiAIOUnreadListener = paramMultiAIOUnreadListener;
  }
  
  public void setNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setDongtaiPermission(paramBoolean1, getCurrentAccountUin(), 1);
      return;
    }
    SharedPreferences.Editor localEditor = getPref().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131694489));
    localStringBuilder.append(getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean1).commit();
  }
  
  public void setPhoneNumSearchable(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((CardHandler)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramBoolean1);
      return;
    }
    SharedPreferences.Editor localEditor = getPref().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131694972));
    localStringBuilder.append(getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean1).commit();
  }
  
  public void setSecDetBannerIntent(Intent paramIntent)
  {
    this.mSecurityDetectBannerIntent = paramIntent;
  }
  
  public void setShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setDongtaiPermission(paramBoolean1, getCurrentAccountUin(), 2);
      return;
    }
    SharedPreferences.Editor localEditor = getPref().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131719049));
    localStringBuilder.append(getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean1).commit();
  }
  
  @TargetApi(14)
  public void setTalkbackSwitch()
  {
    try
    {
      localObject = (AccessibilityManager)this.app.getSystemService("accessibility");
      bool1 = ((AccessibilityManager)localObject).isEnabled();
      boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label196;
      }
      bool1 = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        long l;
        continue;
        label196:
        boolean bool1 = false;
      }
    }
    AppSetting.d = bool1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set talkback enable: ");
      ((StringBuilder)localObject).append(AppSetting.d);
      QLog.d("QQAppInterface", 2, ((StringBuilder)localObject).toString());
    }
    if (AppSetting.d)
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("Talkback", 0);
      l = ((SharedPreferences)localObject).getLong("LastTime", 0L);
      if (System.currentTimeMillis() - l > 86400000L)
      {
        StatisticCollector.getInstance(this.app).collectPerformance(null, "enableTalkback", true, 0L, 0L, null, null);
        ((SharedPreferences)localObject).edit().putLong("LastTime", System.currentTimeMillis()).commit();
      }
    }
    if (AppSetting.d)
    {
      QQTextToSpeechHelper.a(getApplication());
      return;
    }
    QQTextToSpeechHelper.a();
  }
  
  public void setTroopMsgFilterToServer(String paramString, Integer paramInteger)
  {
    IRoamSettingService localIRoamSettingService = (IRoamSettingService)getRuntimeService(IRoamSettingService.class, "");
    if (localIRoamSettingService != null)
    {
      String str = localIRoamSettingService.makeGeneralSettingsKey(paramString, 1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTroopMsgFilterToServer, path=");
        localStringBuilder.append(str);
        localStringBuilder.append(" value=");
        localStringBuilder.append(paramInteger);
        QLog.d("QQAppInterface", 2, localStringBuilder.toString());
      }
      localIRoamSettingService.setRoamSettingNewValue(str, paramInteger);
      TroopAssistantManager.a().c(this, paramString);
    }
  }
  
  public void setVisibilityForInputStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((InputStatusHandler)getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER)).a(paramBoolean1);
      return;
    }
    SharedPreferences.Editor localEditor = getPref().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131719131));
    localStringBuilder.append(getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean1).apply();
  }
  
  public void setVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setVisibilityForNetWorkStatus(paramBoolean1);
      return;
    }
    SharedPreferences.Editor localEditor = getPref().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApp().getString(2131719133));
    localStringBuilder.append(getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean1).commit();
  }
  
  public void setVisibilityForStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      SharedPreferences.Editor localEditor = getPref().edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getApp().getString(2131694974));
      localStringBuilder.append(getCurrentAccountUin());
      localEditor.putBoolean(localStringBuilder.toString(), paramBoolean1).commit();
      return;
    }
    ((LBSHandler)getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(paramBoolean1);
  }
  
  public void setZanAllowed(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.mTryTimeForNear = 1;
    } else {
      this.mTryTimeForStatus = 1;
    }
    ((CardHandler)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramBoolean1, paramBoolean2);
  }
  
  public Bitmap shield(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeResource(this.app.getResources(), 2130850813);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    Bitmap localBitmap2 = null;
    if (localBitmap2 != null) {
      new Canvas(paramBitmap).drawBitmap(localBitmap2, paramBitmap.getWidth() - localBitmap2.getWidth() - 1, paramBitmap.getHeight() - localBitmap2.getHeight() - 1, new Paint());
    }
    return paramBitmap;
  }
  
  public void showIdleNotification(Context paramContext, Class<?> paramClass)
  {
    if (!isOpenNoClearNotification()) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    if (paramClass == null)
    {
      if ((paramContext instanceof Activity))
      {
        paramClass = new Intent(this.app.getApplicationContext(), paramContext.getClass());
        localObject = ((Activity)paramContext).getIntent().getExtras();
        paramContext = paramClass;
        if (localObject != null)
        {
          ((Bundle)localObject).remove("single");
          ((Bundle)localObject).remove("selfuin");
          paramClass.putExtras((Bundle)localObject);
          paramContext = paramClass;
        }
      }
      else
      {
        paramContext = new Intent(this.app.getApplicationContext(), SplashActivity.class);
      }
      paramClass = paramContext;
    }
    else
    {
      paramClass = new Intent(this.app.getApplicationContext(), paramClass);
    }
    paramClass.putExtra("fromNotification", true);
    paramClass.addFlags(536870912).addFlags(67108864);
    if (!isAccLoginSuccess()) {
      return;
    }
    String str = getCurrentAccountUin();
    Context localContext = null;
    Friends localFriends = ((FriendsManager)getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str);
    Object localObject = str;
    if (localFriends != null)
    {
      localObject = getFaceBitmap(1, localFriends.uin, (byte)3, true, 0);
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = ImageUtil.f();
      }
      localObject = str;
      localContext = paramContext;
      if (localFriends.name != null)
      {
        localObject = str;
        localContext = paramContext;
        if (localFriends.name.length() > 0)
        {
          localObject = localFriends.name;
          localContext = paramContext;
        }
      }
    }
    showNotificationWithoutMessage(new NotificationElement(paramClass, "", (String)localObject, this.app.getString(2131718362), localContext), "CMD_IDLE_NOTIFIYCATION");
  }
  
  void showNotificationWithoutMessage(NotificationElement paramNotificationElement, String paramString)
  {
    String str1 = paramNotificationElement.b();
    Bitmap localBitmap = paramNotificationElement.a();
    String str2 = paramNotificationElement.c();
    String str3 = paramNotificationElement.d();
    Intent localIntent = paramNotificationElement.a();
    if (QLog.isColorLevel())
    {
      paramNotificationElement = new StringBuilder();
      paramNotificationElement.append("showNotificationWithoutMessage. cmd=");
      paramNotificationElement.append(paramString);
      paramNotificationElement.append(", ticker=");
      paramNotificationElement.append(MessageRecordUtil.a(str1));
      paramNotificationElement.append(",msgShow:");
      paramNotificationElement.append(MessageRecordUtil.a(str3));
      paramNotificationElement.append(", bitmap=");
      paramNotificationElement.append(localBitmap);
      QLog.d("[NotificationRebuild] notification", 2, paramNotificationElement.toString());
    }
    paramNotificationElement = localBitmap;
    if (localBitmap == null) {
      paramNotificationElement = BitmapManager.a(this.app.getResources(), 2130840405);
    }
    if (paramNotificationElement != null)
    {
      paramString = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), paramString);
      paramString.extraData.putStringArray("cmds", new String[] { str1, str2, str3 });
      localIntent.putExtra("param_notifyid", 275);
      paramString.extraData.putParcelable("intent", localIntent);
      paramString.extraData.putParcelable("bitmap", paramNotificationElement);
      sendToService(paramString);
    }
  }
  
  public void showReadedMsgNotification(com.tencent.imcore.message.Message paramMessage1, com.tencent.imcore.message.Message paramMessage2)
  {
    int i = this.msgFacade.a.a().size();
    int j = this.msgFacade.a.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showReadedMsgNotification, Messages size:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", counter:");
      ((StringBuilder)localObject).append(j);
      QLog.d("notification", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = NotifyIdManager.a(this);
    if ((paramMessage1 != null) && (i != 0) && (j != 0))
    {
      if (isShowMsgContent())
      {
        if ((paramMessage2 != null) && (NotifyIdManager.a(paramMessage2)))
        {
          if ((localObject != null) && (((NotifyIdManager)localObject).d(paramMessage2))) {
            showMessageNotificationWithPreview(paramMessage2, false);
          }
        }
        else {
          showMessageNotificationWithPreview(paramMessage1, false);
        }
      }
      else {
        showMessageNotificationNoPreview(paramMessage1, false);
      }
    }
    else {
      cancelNotification();
    }
    if (isShowMsgContent()) {
      ((NotifyIdManager)localObject).b(paramMessage2);
    }
  }
  
  public void start(boolean paramBoolean)
  {
    if ((paramBoolean) && (BaseApplicationImpl.sDirector != null)) {
      return;
    }
    this.netHandler = new QQAppInterface.MyNetInfoHandler(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.netHandler);
    super.start(paramBoolean);
  }
  
  public boolean startAllSubMessageAccountMsg(boolean paramBoolean)
  {
    return startAllSubMessageAccountMsg(paramBoolean, 0);
  }
  
  public boolean startAllSubMessageAccountMsg(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startAllSubMessageAccountMsg() isFromPush=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" fetchMsgType=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2 = (ISubAccountService)getRuntimeService(ISubAccountService.class, "");
    if (localObject2 != null) {
      localObject1 = ((ISubAccountService)localObject2).getAllSubUin();
    }
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((String)localObject2).length() > 4))
        {
          if (paramInt != 2) {
            ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).loadServerMessage(this, (String)localObject2, paramBoolean);
          }
          if ((paramInt != 1) && (!((ISubAccountConfigApi)QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg())) {
            ((ISubAccountServlet)QRoute.api(ISubAccountServlet.class)).fetchOneTroopNewMsg(this, (String)localObject2);
          }
          bool1 = true;
        }
        else if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startAllSubMessageAccountMsg() continue, subUin=");
          localStringBuilder.append((String)localObject2);
          QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() listSubUin==null");
    }
    boolean bool2 = false;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startAllSubMessageAccountMsg() result=");
      ((StringBuilder)localObject1).append(bool2);
      ((StringBuilder)localObject1).append(" forground=");
      ((StringBuilder)localObject1).append(BaseActivity.mAppForground);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = (ISubAccountControlService)getRuntimeService(ISubAccountControlService.class, "");
    if (localObject1 != null) {
      if (bool2)
      {
        if (BaseActivity.mAppForground)
        {
          ((ISubAccountControlService)localObject1).launchTimedMsgTask(this, paramInt);
          return bool2;
        }
      }
      else {
        ((ISubAccountControlService)localObject1).cancelTimedMsgTask(this, 0);
      }
    }
    return bool2;
  }
  
  public void startInspect()
  {
    MagnifierSDK.a().a().a(this, String.format("%d", new Object[] { Long.valueOf(getLongAccountUin()) }));
  }
  
  public void startSecurityScan()
  {
    ISecureModuleService localISecureModuleService = getSecureModuleService();
    if (localISecureModuleService.register(new ProductInfo(6, getVersionName(), Integer.parseInt("5295"), 201, null, getAccount())) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("security_scan", 2, "Start Security Scan");
      }
      if (this.mListener == null) {
        this.mListener = new QQAppInterface.13(this);
      }
      localISecureModuleService.registerCloudScanListener(getApp(), this.mListener);
      localISecureModuleService.cloudScan();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("security_scan", 2, "regist security service error");
    }
  }
  
  public void syncOnlineFriend()
  {
    if ((!this.sGetOnlineFriendHandler.hasMessages(0)) && (this.isStartSyncOnlineFriend))
    {
      long l3 = this.sLastGetOnlineFriendTime;
      long l2 = 0L;
      long l1 = l2;
      if (l3 != 0L)
      {
        l1 = sNextGetOnlineFriendDelay - (SystemClock.uptimeMillis() - this.sLastGetOnlineFriendTime);
        if (l1 < 0L) {
          l1 = l2;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResume send msg ");
        ((StringBuilder)localObject).append(l1);
        QLog.d("QQAppInterface", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.sGetOnlineFriendHandler.obtainMessage(0, new WeakReference(this));
      this.sGetOnlineFriendHandler.sendMessageDelayed((android.os.Message)localObject, l1);
    }
  }
  
  boolean troopCanPlaySound()
  {
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(this) != 0;
  }
  
  boolean troopCanVibrator()
  {
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(this) != 0;
  }
  
  protected void tryReuploadQfavItems()
  {
    if (!this.needReuploadQfav)
    {
      this.needReuploadQfav = true;
      return;
    }
    if ((isLogin()) && (this.needReuploadQfav))
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "Wifi, tryReuploadQfavItems");
      }
      QfavHelper.a(this);
    }
  }
  
  public boolean trySetCardSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      i = this.mTryTimeForNear;
      this.mTryTimeForNear = (i + 1);
      if (i >= 3) {
        return false;
      }
    }
    int i = this.mTryTimeForStatus;
    this.mTryTimeForStatus = (i + 1);
    if (i >= 3) {
      return false;
    }
    ((CardHandler)getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public void trySoundAndVibrate()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("trySoundAndVibrate is called,needSoundAndVibrations is:");
      ((StringBuilder)localObject).append(Arrays.toString(this.needSoundAndVibrations));
      QLog.d("notification", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getMessageFacade();
    if (localObject == null) {
      return;
    }
    localObject = ((QQMessageFacade)localObject).a();
    if (localObject == null) {
      return;
    }
    this.areMessageRefreshUI[0] = ((com.tencent.imcore.message.Message)localObject).uniseq;
    long[] arrayOfLong = this.areMessageRefreshUI;
    boolean bool = true;
    arrayOfLong[1] = 1L;
    if (this.needSoundAndVibrations[0] == 1)
    {
      if (this.needSoundAndVibrations[1] != 1) {
        bool = false;
      }
      vibratorAndAudioForMsg((MessageRecord)localObject, bool);
      this.needSoundAndVibrations[0] = 0;
    }
  }
  
  public Object[] unitTestLog(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, new Object[] { "unitTestLog: invoked. ", " methodName: ", paramString, paramVarArgs });
    }
    return paramVarArgs;
  }
  
  public void updateSettingTableCache(Setting paramSetting)
  {
    ((IQQAvatarDataService)getRuntimeService(IQQAvatarDataService.class, "")).updateSettingTableCache(paramSetting);
  }
  
  protected void userLogoutReleaseData()
  {
    sendBindUinOffline();
    UpgradeController.a().a(true);
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).clearSystemMsgData();
    GroupSystemMsgController.a().a();
    MsgAutoMonitorUtil.getInstance().release();
    ChatActivityUtils.c();
    BadgeUtils.a(this.app, 0);
    SharedPreferences.Editor localEditor = this.app.getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    ((ITransFileController)getRuntimeService(ITransFileController.class)).getBusHelper().pauseAllShortVideoReceive();
    ((ITransFileController)getRuntimeService(ITransFileController.class)).getBusHelper().pauseAllShortVideoSend();
    OpenApiManager.getInstance().onUserLogout(this);
    this.mAutomator.onDestroy();
    NowVideoController.a().c();
    SplashADUtil.a(BaseApplicationImpl.getContext());
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).updateMiniAppList(100);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).hideColorNoteSmallScreen(getApp());
  }
  
  public void vibratorAndAudio()
  {
    vibratorAndAudio(null, false, true);
  }
  
  public void vibratorAndAudio(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.vibrateSoundHelper = new VibrateSoundHelper(this, paramMessageRecord);
    this.vibrateSoundHelper.b(paramMessageRecord, paramBoolean1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("previous vibrate time is:");
    localStringBuilder.append(this.time);
    localStringBuilder.append(",curr time is:");
    localStringBuilder.append(System.currentTimeMillis());
    QLog.d("QQAppInterface", 1, localStringBuilder.toString());
    if (this.vibrateSoundHelper.a(paramMessageRecord)) {
      return;
    }
    if (isTimeIntervalLimited(paramMessageRecord, paramBoolean1)) {
      return;
    }
    if (this.vibrateSoundHelper.c(paramMessageRecord))
    {
      this.vibrateSoundHelper.a(paramBoolean2);
      return;
    }
    unitTestLog("vibratorAndAudio_check_public_account_end", new Object[0]);
    if (this.vibrateSoundHelper.a()) {
      this.vibrateSoundHelper.b(paramMessageRecord, paramBoolean1, paramBoolean2);
    }
  }
  
  void vibratorAndAudioForMsg(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT > 28) {
      bool = false;
    } else {
      bool = true;
    }
    vibratorAndAudio(paramMessageRecord, paramBoolean, bool);
  }
  
  public void vibratorAndAudioForShake(String paramString, boolean paramBoolean)
  {
    this.time = System.currentTimeMillis();
    boolean bool1 = isRingerSilent();
    boolean bool2 = NoDisturbUtil.a(this.app.getApplicationContext(), this);
    boolean bool3 = NoDisturbUtil.b(this.app.getApplicationContext(), this);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isRingerSilent is:");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(",canDisturb is:");
      ((StringBuilder)localObject1).append(bool2);
      QLog.d("notification", 2, new Object[] { ((StringBuilder)localObject1).toString(), " isMute:", Boolean.valueOf(bool3) });
    }
    if ((!bool1) && (bool2) && (!bool3))
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(getApp());
      Object localObject2 = (Vibrator)getApp().getSystemService("vibrator");
      bool1 = isVideoChatting();
      bool2 = canPlaySound();
      bool3 = canVibrator();
      boolean bool4 = isCallIdle();
      boolean bool5 = recordingPttStopped();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("canVibrator is:");
        localStringBuilder.append(bool3);
        localStringBuilder.append(",isVideoing is:");
        localStringBuilder.append(bool1);
        localStringBuilder.append(",isCallIdle is:");
        localStringBuilder.append(bool4);
        localStringBuilder.append(",notRecordingPtt is:");
        localStringBuilder.append(bool5);
        QLog.d("notification", 2, localStringBuilder.toString());
      }
      if ((bool3) && (bool4) && (!bool1) && (bool5)) {
        ((Vibrator)localObject2).vibrate(VIBRATOR_PATTERN_SHAKE, -1);
      }
      if ((paramBoolean) && (bool2) && (!bool1) && (!isRingerVibrate()) && (!isRingEqualsZero()) && (isCallIdle()) && (recordingPttStopped()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sound_type");
        ((StringBuilder)localObject2).append(getCurrentAccountUin());
        int i = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 2131230721);
        if (systemSound(paramString)) {
          i = 2131230769;
        }
        AudioUtil.b(i, false);
      }
    }
  }
  
  public void writeCallTabStateVal(Integer[] paramArrayOfInteger)
  {
    writeCallTabStateVal(paramArrayOfInteger, true);
  }
  
  public void writeCallTabStateVal(Integer[] paramArrayOfInteger, boolean paramBoolean)
  {
    Object localObject2 = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
    Object localObject1;
    if ((localObject2 != null) && (((String)localObject2).length() <= 7) && (paramArrayOfInteger != null) && (paramArrayOfInteger.length == 7))
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() < 7)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("0111100".substring(((String)localObject2).length()));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder((String)localObject1);
      int i = 0;
      while (i < paramArrayOfInteger.length)
      {
        localObject2 = paramArrayOfInteger[i];
        if (localObject2 != null)
        {
          if ((((Integer)localObject2).intValue() >= 0) && (((Integer)localObject2).intValue() <= 9)) {
            ((StringBuilder)localObject1).setCharAt(i, (char)(((Integer)localObject2).intValue() + 48));
          }
        }
        else
        {
          i += 1;
          continue;
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfInteger = new StringBuilder();
          paramArrayOfInteger.append("writeCallTabStateVal wrong index,,");
          paramArrayOfInteger.append(localObject2);
          QLog.e("QQAppInterface", 2, paramArrayOfInteger.toString());
        }
        return;
      }
      if (paramArrayOfInteger[0] != null)
      {
        this.mCallTabShowState = 0;
        this.isCallTabShow = false;
        if ((this.isCallTabShow) && ((getNowLiveManager().jdField_a_of_type_Char == '2') || (getNowLiveManager().jdField_a_of_type_Char == '3')))
        {
          localObject2 = new Integer[5];
          localObject2[0] = Integer.valueOf(1);
          localObject2[3] = Integer.valueOf(0);
          getNowLiveManager().a((Integer[])localObject2, false);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uin:");
        ((StringBuilder)localObject2).append(getCurrentAccountUin());
        ((StringBuilder)localObject2).append(",writeCallTabStateVal vals=");
        ((StringBuilder)localObject2).append(paramArrayOfInteger);
        ((StringBuilder)localObject2).append(",mIsCallTabShow=");
        ((StringBuilder)localObject2).append(this.mCallTabShowState);
        ((StringBuilder)localObject2).append(",isCallTabShow=");
        ((StringBuilder)localObject2).append(this.isCallTabShow);
        QLog.i("QQAppInterface", 2, ((StringBuilder)localObject2).toString());
      }
      SettingCloneUtil.writeValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", ((StringBuilder)localObject1).toString());
      localObject1 = getNowLiveManager().a();
      i = ((String)localObject1).charAt(2);
      if ((paramBoolean) && (((String)localObject1).charAt(0) == '0') && (paramArrayOfInteger[0] != null) && ((i == 50) || (i == 51)))
      {
        paramArrayOfInteger = new Integer[5];
        paramArrayOfInteger[0] = Integer.valueOf(1);
        getNowLiveManager().a(paramArrayOfInteger, false);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeCallTabStateVal valid val,");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(paramArrayOfInteger);
      QLog.e("QQAppInterface", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface
 * JD-Core Version:    0.7.0.1
 */