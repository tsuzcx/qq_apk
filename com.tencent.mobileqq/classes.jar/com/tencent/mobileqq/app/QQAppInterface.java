package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.accessibility.AccessibilityManager;
import com.dataline.activities.LiteActivity;
import com.etrump.mixlayout.FontManager;
import com.immersion.stickersampleapp.ImmersionHandler;
import com.tencent.av.AVLog;
import com.tencent.av.app.AvAddFriendService;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gameplay.QavGPDownloader;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.redpacket.config.AVRedPacketConfigManager;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.VideoC2CHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.addContactTroopView.AddContactTroopManage;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.NativeAd.preload.NativeAdPreloadManager;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.VideoPlayCountHandler;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUStatistic;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.readinjoy.logic.SMRM;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyOperationManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinHandler;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUploadManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.biz.pubaccount.subscript.SubscriptHandler;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PAReportManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanHandler;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.notification.StoryMsgNotification;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.biz.qrcode.ipc.QrMainProcManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.gdtad.net.GdtAdHandler;
import com.tencent.hotpatch.PatchDownloadManager;
import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.aio.photo.PhotoListConfigManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.newfriend.CloneFriendPushHelper;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.contacts.utils.CardUtil;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.weather.WeatherManager;
import com.tencent.mobileqq.addon.DiyPendantHandler;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloNativeSSOReqMgr;
import com.tencent.mobileqq.apollo.ApolloPushManager;
import com.tencent.mobileqq.apollo.ApolloResponseManager;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloRecentManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MessageStatisticHelper;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyContainer;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyHandler;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.app.soso.LbsInfoReportManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.app.utils.DingdongPluginBizHandler;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.app.utils.ShortVideoHandler;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.arcard.ARRelationShipHandler;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfoHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.bubble.BubbleDiyHandler;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.campuscircle.CampusCircleHandler;
import com.tencent.mobileqq.campuscircle.CampusCircleManager;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.struct.NearbyBannerManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.extendfriend.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransProxy;
import com.tencent.mobileqq.flashchat.FlashChatHanlder;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.hitrate.PreloadProcHitMgr;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.now.NowDownloadEngineManager;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.mobileqq.leba.LebaConfigManager;
import com.tencent.mobileqq.leba.LebaFeedsHandler;
import com.tencent.mobileqq.leba.LebaFeedsManager;
import com.tencent.mobileqq.leba.LebaGridHandler;
import com.tencent.mobileqq.leba.LebaGridManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeHandler;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.lovelanguage.LoveLanguageHandler;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.PullActiveManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.managers.TimJumpLoginManager;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.CommercialDrainageManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.musicgene.MusicPlayerHandler;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.nearby.NearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager;
import com.tencent.mobileqq.nearby.now.NowSmallVideoHandler;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedtouchHandler;
import com.tencent.mobileqq.now.NowManager;
import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.mobileqq.ocr.OCRHandler;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.olympic.OlympicHandler;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.pic.BaseStrategy;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler.IPluginManagerProvider;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.upload.task.VipImageUploadManager;
import com.tencent.mobileqq.ptt.PttConfigController;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.qcall.LightalkShieldHandler;
import com.tencent.mobileqq.qcall.LightalkShieldManager;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.qcall.PstnHandler;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallCardHandler;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.redtouch.NumRedMsgManager;
import com.tencent.mobileqq.redtouch.NumRedPointManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.scribble.ScribbleDownloader;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.SearchWebHistoryManager;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.DAUStatistic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.statistics.battery.BatteryStats;
import com.tencent.mobileqq.statistics.battery.BatteryStatsImpl;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.TeamWorkHandler;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager;
import com.tencent.mobileqq.troop.utils.TroopAioADManager;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopFileUploadingManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceManager;
import com.tencent.mobileqq.util.IPCFaceHelper;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.IndividuationABTestManager;
import com.tencent.mobileqq.vas.SonicTemplateUpdateManager;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vashealth.SportManager;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.BigDataGetIpHandler;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.QPUpdateManager;
import com.tencent.securemodule.impl.SecureModuleService;
import com.tencent.securemodule.service.CloudScanListener;
import com.tencent.securemodule.service.ISecureModuleService;
import com.tencent.securemodule.service.ProductInfo;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MsgAutoMonitorUtil;
import cooperation.comic.QQComicPreloadManager;
import cooperation.comic.emoticon.VipComicEmoticonUploadManager;
import cooperation.comic.utils.QQComicRedTouchManager;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginManagerV2;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlinkReliableReport;
import cooperation.qlink.QlinkServiceManager;
import cooperation.qqfav.QfavHelper;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import cooperation.qqreader.QRProcessManager;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.plugin.QZonePluginManager;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.troop.TroopPluginManager;
import cooperation.weiyun.WeiyunHelper;
import dov.com.qq.im.capture.QIMManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AccountManagerImpl;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.ProxyIpManagerImpl;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;
import mqq.manager.PushManager;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import zkl;
import zkm;
import zkn;
import zko;
import zkp;
import zkq;
import zkr;
import zks;
import zkt;
import zku;
import zkv;
import zkw;
import zkx;
import zky;
import zkz;
import zla;
import zlb;
import zle;
import zlf;
import zlg;
import zlh;
import zli;
import zlj;
import zlk;

public class QQAppInterface
  extends AppInterface
  implements PluginManageHandler.IPluginManagerProvider
{
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  private static TextToSpeech jdField_a_of_type_AndroidSpeechTtsTextToSpeech;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static final long[] a;
  public static int b;
  public static volatile boolean b;
  private static final long[] jdField_b_of_type_ArrayOfLong;
  private static long jdField_d_of_type_Long;
  public static int e;
  public static int f;
  private static boolean t;
  public int a;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new zlb(this);
  public Intent a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.sImageCache;
  private AvAddFriendService jdField_a_of_type_ComTencentAvAppAvAddFriendService;
  private AVNotifyCenter jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter;
  private QQLruCache jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private CallTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener;
  private CheckPttListener jdField_a_of_type_ComTencentMobileqqAppCheckPttListener;
  private CheckPtvListener jdField_a_of_type_ComTencentMobileqqAppCheckPtvListener;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new zlh(this);
  private HotChatManager jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
  public LebaHelper a;
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  private MsgTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener;
  private QQGAudioMsgHandler jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler;
  private CacheManager jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager;
  public Automator a;
  volatile ConversationFacade jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
  public volatile QQMessageFacade a;
  private FTSDBManager jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  public AboutConfig a;
  private Config jdField_a_of_type_ComTencentMobileqqConfigConfig;
  private QQEntityManagerFactory jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
  private SigInfo jdField_a_of_type_ComTencentMobileqqDataSigInfo;
  private FileManagerEngine jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine;
  private FileTransferHandler jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler;
  private FileManagerDataCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter;
  private FileManagerNotifyCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter;
  private FileManagerRSCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter;
  private OnlineFileSessionCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private PicPreDownloader jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  volatile QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  private ScribbleDownloader jdField_a_of_type_ComTencentMobileqqScribbleScribbleDownloader;
  public MobileQQService a;
  private MessageCache jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
  private ShortVideoPreDownloader jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader;
  private ShortVideoResourceManager jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager;
  private ReportController jdField_a_of_type_ComTencentMobileqqStatisticsReportController;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private CloudScanListener jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener;
  private ISecureModuleService jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService;
  private QQProxyForQlink jdField_a_of_type_CooperationQlinkQQProxyForQlink;
  private QlinkServiceManager jdField_a_of_type_CooperationQlinkQlinkServiceManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  public WeakReference a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  List jdField_a_of_type_JavaUtilList = new Vector();
  public Set a;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  zlj jdField_a_of_type_Zlj = null;
  public boolean a;
  private volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[2];
  private BusinessHandler[] jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler = new BusinessHandler[''];
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[280];
  private Manager[] jdField_a_of_type_ArrayOfMqqManagerManager = new Manager[280];
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new zlg(this);
  private Intent jdField_b_of_type_AndroidContentIntent;
  private Handler jdField_b_of_type_AndroidOsHandler = new zle(this, ThreadManager.getSubThreadLooper());
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ThreadLocal jdField_b_of_type_JavaLangThreadLocal = new ThreadLocal();
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  List jdField_b_of_type_JavaUtilList = new Vector();
  public int c;
  public long c;
  private BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new zkx(this);
  List jdField_c_of_type_JavaUtilList = new Vector();
  public boolean c;
  private volatile long[] jdField_c_of_type_ArrayOfLong = new long[2];
  public int d;
  private List jdField_d_of_type_JavaUtilList = new ArrayList();
  public volatile boolean d;
  private long e;
  public boolean e;
  private long f;
  public boolean f;
  public int g;
  private long g;
  public boolean g;
  private final int h;
  public boolean h;
  private final int i;
  public boolean i;
  boolean j;
  public boolean k = true;
  public volatile boolean l;
  public boolean m;
  public boolean n;
  public boolean o = true;
  public boolean p;
  public boolean q;
  private boolean r;
  private boolean s;
  
  static
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      String str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("QQAppInterface escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.sQQAppInterfaceEscapedMsg = str + "\n" + QLog.getStackTraceString(localThrowable);
        QLog.e("DexLoad", 1, "QQAppInterface escapes!");
      }
    }
    for (;;)
    {
      jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
      jdField_d_of_type_Long = 86400000L;
      jdField_b_of_type_ArrayOfLong = new long[] { 100L, 200L, 200L, 100L };
      jdField_a_of_type_ArrayOfLong = new long[] { 100L, 400L, 100L, 400L, 100L, 400L };
      jdField_b_of_type_Int = 1;
      jdField_a_of_type_ArrayOfInt = new int[] { 17, 18, 19, 28, 27, 25, 26, 41, 47 };
      jdField_e_of_type_Int = 300000;
      jdField_f_of_type_Int = 30000;
      return;
      BaseApplicationImpl.sQQAppInterfaceEscapedMsg = "";
    }
  }
  
  public QQAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_e_of_type_Long = 31L;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_f_of_type_Long = -1L;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_h_of_type_Int = 990;
    this.jdField_i_of_type_Int = 991;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidOsHandler = new zku(this, Looper.getMainLooper());
    this.jdField_g_of_type_Int = -1;
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache == null) {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2001, 4000, 60);
    }
  }
  
  private void J()
  {
    if (BaseApplicationImpl.sImageCache != null)
    {
      int i1 = BaseApplicationImpl.sImageCache.size() * 3 / 4;
      BaseApplicationImpl.sImageCache.trimToSize(i1);
    }
  }
  
  private void K()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
    localIntentFilter.addAction("com.tencent.mobileqq.kickedLogin.otherDevice");
    this.app.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void L()
  {
    if (this.l) {
      return;
    }
    this.l = true;
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.jdField_a_of_type_Boolean = false;
    if (GuardManager.a != null) {
      GuardManager.a.a(false);
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        synchronized (this.jdField_c_of_type_JavaUtilList)
        {
          this.jdField_c_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a();
          HeavyTaskExecutor.a(new zkm(this));
        }
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      BusinessHandler[] arrayOfBusinessHandler = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler;
      int i2 = arrayOfBusinessHandler.length;
      int i1 = 0;
      while (i1 < i2)
      {
        BusinessHandler localBusinessHandler = arrayOfBusinessHandler[i1];
        if (localBusinessHandler != null) {
          localBusinessHandler.a();
        }
        i1 += 1;
        continue;
        localObject2 = finally;
        throw localObject2;
        localObject3 = finally;
        throw localObject3;
        localObject4 = finally;
        throw localObject4;
      }
      if (this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener != null) {
        a().unregisterCloudScanListener(this.app.getBaseContext(), this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener);
      }
      VideoBroadcastReceiver.a();
      if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
        this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
      }
      FaceDecodeTask.b();
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.d();
      }
      WeiyunHelper.b();
      SosoInterface.a();
      EquipLockWebImpl.a();
      PluginManageHandler.getInstance().setPluginManagerProvider(null, false);
      SessionInfo.clearOldSession();
      PublicAccountUtil.b();
      PublicAccountConfigUtil.a();
      PublicAccountSearchRecommendManager.a().a();
      QQIndividualityPluginProxyService.a();
      com.tencent.mobileqq.search.SearchEntryConfigManager.jdField_a_of_type_Boolean = false;
      StoryMsgNotification.a().a(BaseApplication.getContext());
      FaceScanDownloadManager.a();
      CloneFriendPushHelper.a();
      HeavyTaskExecutor.a(new zkn(this));
      QWalletHelper.release();
      return;
    }
  }
  
  private void M()
  {
    Object localObject = (SubAccountManager)getManager(60);
    if (localObject != null) {}
    for (localObject = ((SubAccountManager)localObject).a();; localObject = null)
    {
      if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
        return;
      }
      SubAccountControll.a(this, (byte)0, (ArrayList)localObject);
      return;
    }
  }
  
  private void N()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig = new AboutConfig(this);
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a();
    }
  }
  
  private void O()
  {
    this.q = ((LebaGridManager)getManager(211)).a();
    QLog.d("Q.lebanew", 1, "initLebaTabShowState ");
  }
  
  private void P()
  {
    if (this.jdField_g_of_type_Int != -1) {}
    String str;
    do
    {
      return;
      str = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
      if ((str != null) && (str.length() <= "0111100".length())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQAppInterface", 2, "isCallTabShow fullVal is null");
    return;
    Object localObject = str;
    if (str.length() < "0111100".length()) {
      localObject = str + "0111100".substring(str.length());
    }
    int i1 = localObject.toCharArray()[6];
    localObject = new StringBuilder((String)localObject);
    if (48 != i1) {
      ((StringBuilder)localObject).setCharAt(6, '0');
    }
    for (i1 = 1;; i1 = 0)
    {
      this.jdField_g_of_type_Int = 0;
      this.n = false;
      if (i1 == 0) {
        break;
      }
      ThreadManager.post(new zla(this, (StringBuilder)localObject), 8, null, false);
      return;
    }
  }
  
  @TargetApi(23)
  private void Q()
  {
    QLog.d("QQAppInterface", 1, "checkBackgroundRestricWhilteList ENTER " + System.currentTimeMillis());
    localObject = new int[] { 0, 0 };
    arrayOfInt1 = new int[] { 1, 3 };
    arrayOfInt2 = new int[] { 2, 3 };
    arrayOfInt3 = new int[] { 3, 7 };
    arrayOfInt4 = new int[] { 4, 7 };
    arrayOfInt5 = new int[] { 5, 14 };
    localBaseApplication = BaseApplicationImpl.getContext();
    ConnectivityManager localConnectivityManager = (ConnectivityManager)localBaseApplication.getSystemService("connectivity");
    boolean bool2 = localConnectivityManager.isActiveNetworkMetered();
    int i2;
    if (bool2) {
      i2 = -1;
    }
    try
    {
      Method localMethod = localConnectivityManager.getClass().getMethod("getRestrictBackgroundStatus", new Class[0]);
      localMethod.setAccessible(true);
      i1 = ((Integer)localMethod.invoke(localConnectivityManager, new Object[0])).intValue();
      i2 = i1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        boolean bool1;
        localException.printStackTrace();
        continue;
        SharedPreferences localSharedPreferences = localBaseApplication.getSharedPreferences("qq_background_restric_whitelist_cfg", 0);
        int i3 = localSharedPreferences.getInt("tips_index", 0);
        long l1 = localSharedPreferences.getLong("tips_last_time", 0L);
        if (i3 == 0)
        {
          localObject = localSharedPreferences.edit();
          i1 = i3 + 1;
          ((SharedPreferences.Editor)localObject).putInt("tips_index", i1).putLong("tips_last_time", System.currentTimeMillis()).commit();
          bool1 = true;
        }
        else
        {
          if (i3 >= 0)
          {
            i1 = i3;
            if (i3 <= 5) {}
          }
          else
          {
            i1 = 5;
          }
          if (System.currentTimeMillis() >= new int[][] { localObject, arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5 }[i1][1] * 86400000L + l1)
          {
            localObject = localSharedPreferences.edit();
            i1 += 1;
            ((SharedPreferences.Editor)localObject).putInt("tips_index", i1).putLong("tips_last_time", System.currentTimeMillis()).commit();
            bool1 = true;
            continue;
            localBaseApplication.getSharedPreferences("qq_background_restric_whitelist_cfg", 0).edit().putInt("tips_index", 0).putLong("tips_last_time", 0L).commit();
            i1 = -1;
            bool1 = false;
            l1 = 0L;
          }
          else
          {
            bool1 = false;
          }
        }
      }
    }
    switch (i2)
    {
    default: 
      i1 = -1;
      bool1 = false;
      l1 = 0L;
      localObject = new StringBuilder("checkBackgroundRestricWhilteList");
      ((StringBuilder)localObject).append(" isActiveNetworkMetered=").append(bool2).append(" restrictStatus=").append(i2).append(" tipsIdx=").append(i1).append(" tipsTime=").append(l1).append(" notice=").append(bool1);
      QLog.d("QQAppInterface", 1, ((StringBuilder)localObject).toString());
      if (bool1)
      {
        localObject = new Intent(localBaseApplication, DialogActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).addFlags(131072);
        ((Intent)localObject).putExtra("key_dialog_type", DialogActivity.jdField_b_of_type_Int);
        localBaseApplication.startActivity((Intent)localObject);
      }
      QLog.d("QQAppInterface", 1, "checkBackgroundRestricWhilteList END");
      return;
    }
  }
  
  private static void R()
  {
    int i3 = 0;
    i2 = 0;
    if (t) {}
    do
    {
      return;
      i1 = i3;
      try
      {
        Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.headCfg.name(), "24|3500|1");
        i1 = i3;
        if (QLog.isColorLevel())
        {
          i1 = i3;
          QLog.i("QQAppInterface", 2, "initHeadCfg, " + (String)localObject);
        }
        i1 = i3;
        localObject = ((String)localObject).split("\\|");
        i1 = i3;
        if (localObject.length > 0)
        {
          i1 = i3;
          i3 = Integer.parseInt(localObject[0]);
          i2 = i3;
          if (i3 >= 1)
          {
            i2 = i3;
            if (i3 <= 168)
            {
              i1 = i3;
              jdField_d_of_type_Long = i3 * 60 * 60 * 1000;
              i2 = i3;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          jdField_d_of_type_Long = 86400000L;
          i2 = i1;
          if (QLog.isColorLevel())
          {
            QLog.e("QQAppInterface", 2, "initHeadCfg error", localException);
            i2 = i1;
          }
        }
      }
      t = true;
    } while (!QLog.isColorLevel());
    QLog.i("QQAppInterface", 2, "initHeadCfg," + i2 + "," + jdField_d_of_type_Long);
  }
  
  private Intent a(Context paramContext, QQMessageFacade.Message paramMessage, int paramInt)
  {
    paramMessage = paramMessage.frienduin;
    int i1 = paramInt;
    if (paramInt == 1026) {
      i1 = 1;
    }
    Object localObject1;
    if (String.valueOf(AppConstants.G).equals(paramMessage))
    {
      localObject1 = paramContext.getString(2131437732);
      paramContext = new Intent(paramContext, MsgBoxListActivity.class);
      paramContext.putExtra("uin", paramMessage);
      paramContext.putExtra("uintype", 1001);
      paramMessage = (QQMessageFacade.Message)localObject1;
    }
    for (;;)
    {
      paramContext.putExtra("uinname", paramMessage);
      return paramContext;
      if ((String.valueOf(AppConstants.K).equals(paramMessage)) || (AppConstants.ap.equals(paramMessage)) || (AppConstants.aw.equals(paramMessage)))
      {
        paramMessage = paramContext.getString(2131433315);
        paramContext = new Intent(paramContext, NewFriendActivity.class);
        paramContext.putExtra("EntranceId", 1);
      }
      else if (String.valueOf(AppConstants.L).equals(paramMessage))
      {
        paramMessage = paramContext.getString(2131434943);
        paramContext = new Intent(paramContext, TroopActivity.class);
        paramContext.putExtra("_key_mode", 0);
        paramContext.putExtra("key_tab_mode", 2);
      }
      else if (String.valueOf(AppConstants.H).equals(paramMessage))
      {
        paramMessage = new Intent(paramContext, QQBroadcastActivity.class);
        localObject1 = paramContext.getString(2131434941);
        paramContext = paramMessage;
        paramMessage = (QQMessageFacade.Message)localObject1;
      }
      else if (String.valueOf(AppConstants.D).equals(paramMessage))
      {
        paramMessage = paramContext.getString(2131434943);
        paramContext = new Intent(paramContext, VisitorsActivity.class);
        paramContext.putExtra("votersOnly", true);
        paramContext.putExtra("toUin", Long.valueOf(getCurrentAccountUin()));
      }
      else if (String.valueOf(AppConstants.y).equals(paramMessage))
      {
        paramMessage = new Intent(paramContext, LiteActivity.class);
        paramMessage.putExtra("targetUin", AppConstants.y);
        localObject1 = paramContext.getString(2131427485);
        paramContext = paramMessage;
        paramMessage = (QQMessageFacade.Message)localObject1;
      }
      else if (String.valueOf(AppConstants.z).equals(paramMessage))
      {
        paramMessage = new Intent(paramContext, LiteActivity.class);
        paramMessage.putExtra("targetUin", AppConstants.z);
        localObject1 = paramContext.getString(2131427486);
        paramContext = paramMessage;
        paramMessage = (QQMessageFacade.Message)localObject1;
      }
      else
      {
        if (!String.valueOf(9973L).equals(paramMessage)) {
          break;
        }
        paramMessage = new Intent(paramContext, ActivateFriendActivity.class);
        localObject1 = paramContext.getString(2131437234);
        paramMessage.setFlags(67108864);
        paramMessage.putExtra("af_key_from", 4);
        paramContext = paramMessage;
        paramMessage = (QQMessageFacade.Message)localObject1;
      }
    }
    Object localObject2;
    if (i1 == 7000)
    {
      localObject1 = paramContext.getString(2131436308);
      localObject2 = new Intent(paramContext, AssociatedAccountActivity.class);
      ((Intent)localObject2).putExtra("subAccount", paramMessage);
      paramContext = (SubAccountManager)getManager(60);
      if (paramContext == null) {
        break label1248;
      }
    }
    label826:
    label976:
    label1248:
    for (paramContext = paramContext.b(paramMessage);; paramContext = paramMessage)
    {
      ((Intent)localObject2).putExtra("subAccountLatestNick", paramContext);
      ((Intent)localObject2).putExtra("finishAIO", true);
      ((Intent)localObject2).putExtra("uin", paramMessage);
      ((Intent)localObject2).putExtra("uintype", i1);
      paramContext = (Context)localObject2;
      paramMessage = (QQMessageFacade.Message)localObject1;
      break;
      if ((i1 == 1001) || (i1 == 1010))
      {
        paramMessage = paramContext.getString(2131437732);
        paramContext = new Intent(paramContext, MsgBoxListActivity.class);
        paramContext.putExtra("uin", AppConstants.G);
        paramContext.putExtra("uintype", i1);
        break;
      }
      if (i1 == 1032)
      {
        paramMessage = paramContext.getString(2131439188);
        paramContext = new Intent(paramContext, PublicFragmentActivity.class);
        paramContext.putExtra("uintype", 1032);
        paramContext.putExtra("uin", AppConstants.aE);
        paramContext.putExtra("public_fragment_class", ConfessMsgListFragment.class.getName());
        paramContext.addFlags(335544320);
        break;
      }
      if (i1 == 7220)
      {
        localObject1 = PublicAccountConfigUtil.c(this, paramContext);
        ReadInJoyUtils.b(true);
        if (ReadInJoyHelper.h()) {
          paramContext = ReadInJoyActivityHelper.a(paramContext, 6);
        }
        for (;;)
        {
          paramContext.putExtra("uin", AppConstants.as);
          paramContext.putExtra("uintype", i1);
          paramMessage = (QQMessageFacade.Message)localObject1;
          break;
          paramContext = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
          if (!ReadInJoyHelper.a(this)) {
            break label826;
          }
          paramContext.putExtra("readinjoy_show_tab", 0);
          paramContext.putExtra("tab_tab_index", 0);
          paramContext.putExtra("launch_from", 6);
        }
        localObject2 = new ArrayList();
        paramMessage = ((KandianMergeManager)getManager(161)).b();
        if ((paramMessage != null) && ((paramMessage instanceof MessageForStructing)) && (paramMessage.extInt == 1))
        {
          paramMessage = (MessageForStructing)paramMessage;
          if (paramMessage.structingMsg == null) {
            paramMessage.parse();
          }
          if ((paramMessage.structingMsg != null) && (!TextUtils.isEmpty(paramMessage.structingMsg.mArticleIds)))
          {
            paramMessage = paramMessage.structingMsg.mArticleIds.split("\\|");
            int i2 = paramMessage.length;
            paramInt = 0;
            for (;;)
            {
              if (paramInt < i2)
              {
                String str = paramMessage[paramInt];
                try
                {
                  ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(str)));
                  paramInt += 1;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    localException.printStackTrace();
                  }
                }
              }
            }
          }
        }
        if (((ArrayList)localObject2).isEmpty())
        {
          paramMessage = null;
          paramContext.putExtra("subscription_all_article_id", paramMessage);
          if (!((ArrayList)localObject2).isEmpty()) {
            break label1027;
          }
        }
        for (long l1 = -1L;; l1 = ((Long)((ArrayList)localObject2).get(0)).longValue())
        {
          paramContext.putExtra("subscription_click_article_id", l1);
          paramContext.putExtra("launch_from", 6);
          break;
          paramMessage = (QQMessageFacade.Message)localObject2;
          break label976;
        }
      }
      localObject1 = new Intent(paramContext, SplashActivity.class);
      if (i1 == 1009) {
        paramContext = paramContext.getString(2131434034);
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("uin", paramMessage);
        ((Intent)localObject1).putExtra("uintype", i1);
        localObject1 = AIOUtils.a((Intent)localObject1, new int[] { 2 });
        ((Intent)localObject1).setAction("com.tencent.mobileqq.action.MAINACTIVITY");
        paramMessage = paramContext;
        paramContext = (Context)localObject1;
        break;
        if (String.valueOf(1787740092L).equals(paramMessage))
        {
          paramContext = paramContext.getString(2131436280);
        }
        else if (i1 == 1024)
        {
          ((Intent)localObject1).putExtra("chat_subType", 1);
          paramContext = ContactUtils.b(this, paramMessage, i1);
        }
        else if (i1 == 9501)
        {
          paramContext = ((SmartDeviceProxyMgr)a(51)).a(Long.parseLong(paramMessage));
          if (paramContext != null) {
            paramContext = SmartDeviceUtil.a(paramContext);
          } else {
            paramContext = paramMessage;
          }
        }
        else if (i1 == 1029)
        {
          paramContext = ContactUtils.f(this, paramMessage);
        }
        else
        {
          paramContext = ContactUtils.b(this, paramMessage, i1);
        }
      }
    }
  }
  
  private Intent a(Context paramContext, String paramString, int paramInt)
  {
    if (String.valueOf(AppConstants.G).equals(paramString))
    {
      localObject = paramContext.getString(2131434024);
      paramContext = new Intent(paramContext, MsgBoxListActivity.class);
      paramContext.putExtra("uin", paramString);
      paramContext.putExtra("uintype", 1001);
    }
    for (;;)
    {
      paramContext.putExtra("uinname", (String)localObject);
      return paramContext;
      if (String.valueOf(AppConstants.K).equals(paramString))
      {
        localObject = paramContext.getString(2131434943);
        paramContext = new Intent(paramContext, NewFriendActivity.class);
        paramContext.putExtra("EntranceId", 1);
      }
      else if (String.valueOf(AppConstants.L).equals(paramString))
      {
        localObject = paramContext.getString(2131434943);
        paramContext = new Intent(paramContext, TroopActivity.class);
        paramContext.putExtra("_key_mode", 0);
        paramContext.putExtra("key_tab_mode", 2);
      }
      else if (String.valueOf(AppConstants.H).equals(paramString))
      {
        paramString = new Intent(paramContext, QQBroadcastActivity.class);
        localObject = paramContext.getString(2131434941);
        paramContext = paramString;
      }
      else if (String.valueOf(AppConstants.D).equals(paramString))
      {
        localObject = paramContext.getString(2131434943);
        paramContext = new Intent(paramContext, VisitorsActivity.class);
        paramContext.putExtra("votersOnly", true);
        paramContext.putExtra("toUin", Long.valueOf(getCurrentAccountUin()));
      }
      else if (String.valueOf(AppConstants.y).equals(paramString))
      {
        paramString = new Intent(paramContext, LiteActivity.class);
        paramString.putExtra("targetUin", AppConstants.y);
        localObject = paramContext.getString(2131427485);
        paramContext = paramString;
      }
      else
      {
        if (!String.valueOf(AppConstants.z).equals(paramString)) {
          break;
        }
        paramString = new Intent(paramContext, LiteActivity.class);
        paramString.putExtra("targetUin", AppConstants.z);
        localObject = paramContext.getString(2131427486);
        paramContext = paramString;
      }
    }
    Object localObject = new Intent(getApp(), SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("conversation_index", 1);
    ((Intent)localObject).setFlags(335544320);
    String str;
    if (paramInt == 7000)
    {
      str = paramContext.getString(2131436308);
      ((Intent)localObject).setClass(paramContext, AssociatedAccountActivity.class);
      ((Intent)localObject).putExtra("subAccount", paramString);
      paramContext = (SubAccountManager)getManager(60);
      if (paramContext == null) {
        break label758;
      }
    }
    label758:
    for (paramContext = paramContext.b(paramString);; paramContext = paramString)
    {
      ((Intent)localObject).putExtra("subAccountLatestNick", paramContext);
      ((Intent)localObject).putExtra("finishAIO", true);
      paramContext = (Context)localObject;
      localObject = str;
      for (;;)
      {
        paramContext.putExtra("uin", paramString);
        paramContext.putExtra("uintype", paramInt);
        break;
        if (paramInt == 1009)
        {
          str = paramContext.getString(2131434034);
          paramContext = (Context)localObject;
          localObject = str;
        }
        else if (String.valueOf(1787740092L).equals(paramString))
        {
          str = paramContext.getString(2131436280);
          paramContext = (Context)localObject;
          localObject = str;
        }
        else if (paramInt == 1024)
        {
          ((Intent)localObject).setClass(paramContext, SplashActivity.class);
          paramContext = AIOUtils.a((Intent)localObject, null);
          paramContext.putExtra("chat_subType", 1);
          localObject = ContactUtils.b(this, paramString, paramInt);
        }
        else if ((paramInt == 1001) || (paramInt == 1010) || (paramInt == 10002))
        {
          localObject = paramContext.getString(2131437732);
          paramContext = new Intent(paramContext, MsgBoxListActivity.class);
          paramString = AppConstants.G;
          paramContext.putExtra("uin", paramString);
          paramContext.putExtra("uintype", paramInt);
        }
        else if (paramInt == 1032)
        {
          localObject = paramContext.getString(2131439188);
          paramContext = new Intent(paramContext, MsgBoxListActivity.class);
          paramString = AppConstants.aE;
          paramContext.putExtra("uin", paramString);
          paramContext.putExtra("uintype", paramInt);
        }
        else
        {
          str = ContactUtils.b(this, paramString, paramInt);
          paramContext = (Context)localObject;
          localObject = str;
        }
      }
    }
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApp());
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private Drawable a(String paramString, boolean paramBoolean, byte paramByte)
  {
    Object localObject = a(1, paramString, paramByte, true, 0);
    if ((localObject != null) && (paramBoolean)) {
      localObject = ImageUtil.a((Bitmap)localObject);
    }
    for (;;)
    {
      paramString = null;
      if (localObject != null) {
        paramString = new BitmapDrawable((Bitmap)localObject);
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = ImageUtil.b();
      }
      return localObject;
    }
  }
  
  private SQLiteOpenHelper a()
  {
    if (!getCurrentAccountUin().equals("0")) {
      return getEntityManagerFactory().build(getCurrentAccountUin());
    }
    return null;
  }
  
  private SQLiteOpenHelper a(String paramString)
  {
    return getEntityManagerFactory(paramString).build(paramString);
  }
  
  public static BatteryStats a()
  {
    return BatteryStatsImpl.a();
  }
  
  private String a(QQMessageFacade.Message paramMessage)
  {
    switch (paramMessage.bizType)
    {
    default: 
      return "";
    case 14: 
      if (paramMessage.msgtype == -2025)
      {
        if (MessageForQQWalletMsg.isRedPacketMsg(a().b(paramMessage.frienduin, 1, paramMessage.uniseq))) {
          return getApp().getString(2131437907);
        }
        return getApp().getString(2131433158);
      }
      return getApp().getString(2131433158);
    case 20: 
      return getApp().getString(2131430181);
    case 12: 
      return getApp().getString(2131430182);
    case 5: 
      return getApp().getString(2131430620);
    case 19: 
      return getApp().getString(2131430195);
    case 4: 
      return getApp().getString(2131430196);
    }
    return getApp().getString(2131438977);
  }
  
  private String a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    Object localObject2;
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020))
    {
      localObject1 = ContactUtils.d(this, paramMessage.frienduin, paramMessage.senderuin);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(paramMessage.frienduin)) {}
      }
      else
      {
        localObject2 = ((FriendsManager)getManager(50)).c(paramMessage.frienduin);
        if (localObject2 != null) {
          if (TextUtils.isEmpty(((Friends)localObject2).remark)) {
            break label242;
          }
        }
      }
    }
    label242:
    for (Object localObject1 = ((Friends)localObject2).remark;; localObject1 = ((Friends)localObject2).name)
    {
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
          if (!this.jdField_a_of_type_JavaUtilSet.contains(paramMessage.frienduin))
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramMessage.frienduin);
            localObject2 = (FriendListHandler)a(1);
            addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d("QQAppInterface_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject2).b(paramMessage.frienduin);
            localObject2 = localObject1;
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
      localObject1 = ContactUtils.c(this, paramMessage.senderuin, paramMessage.frienduin);
      break;
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (SystemUtil.a()) {
      localStringBuilder.append(AppConstants.bm);
    }
    for (;;)
    {
      String str = MD5.toMD5(paramString);
      str = MD5.toMD5(str + paramString);
      localStringBuilder.append(MD5.toMD5(str + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
    }
  }
  
  private String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if ((paramInt == 1000) || (paramInt == 1020))
    {
      paramString2 = ContactUtils.d(this, paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = paramString2;
        if (!paramString2.equals(paramString1)) {}
      }
      else
      {
        localObject = ((FriendsManager)getManager(50)).c(paramString1);
        if (localObject != null) {
          if (TextUtils.isEmpty(((Friends)localObject).remark)) {
            break label199;
          }
        }
      }
    }
    label199:
    for (paramString2 = ((Friends)localObject).remark;; paramString2 = ((Friends)localObject).name)
    {
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
          if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString1))
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramString1);
            localObject = (FriendListHandler)a(1);
            addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d("QQAppInterface_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject).b(paramString1);
            localObject = paramString2;
          }
        }
      }
      if ((localObject != null) && (!"".equals(localObject))) {
        break label208;
      }
      return paramString1;
      paramString2 = ContactUtils.c(this, paramString2, paramString1);
      break;
    }
    label208:
    return localObject;
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {}
    long l1;
    long l2;
    do
    {
      return;
      int i1 = paramIntent.getExtras().getInt("faceType", 1);
      paramContext = paramIntent.getExtras().getString("uin");
      l1 = paramIntent.getExtras().getLong("headSystemId", -1L);
      l2 = paramIntent.getExtras().getLong("faceFlag", -1L);
      paramIntent = new StringBuilder("refreshQQHeadBroast ");
      paramIntent.append(" uin=").append(StringUtil.d(paramContext));
      paramIntent.append(" sysId=").append(l1);
      paramIntent.append(" headFlag=").append(l2);
      paramIntent.append(" headType=").append(i1);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, paramIntent.toString());
      }
      paramIntent = (ClassicHeadActivityManager)getManager(198);
    } while ((paramIntent == null) || (!c().equals(paramContext)) || (l2 == -1L) || (l1 == -1L) || (!paramIntent.a()));
    paramIntent.a(l1, l2, 1L);
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showNotification. cmd=" + paramString4 + ", ticker=" + Utils.a(paramString1) + ",msgShow:" + Utils.a(paramString3) + ", bitmap=" + paramBitmap);
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = BitmapManager.a(this.app.getResources(), 2130839193);
    }
    if (localBitmap != null)
    {
      paramBitmap = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), paramString4);
      paramBitmap.extraData.putStringArray("cmds", new String[] { paramString1, paramString2, paramString3 });
      paramBitmap.extraData.putParcelable("intent", paramIntent);
      paramBitmap.extraData.putParcelable("bitmap", localBitmap);
      sendToService(paramBitmap);
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    boolean bool = NoDisturbUtil.a(this.app.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showInComingMsg ,isFinished=" + this.j + ", isCanDisturb=" + bool + ", needTicker=" + paramBoolean + ", message=" + paramMessage);
    }
    if ((this.j) || (!bool)) {}
    Object localObject3;
    Object localObject6;
    MessageRecord localMessageRecord;
    Object localObject4;
    label251:
    Object localObject7;
    label349:
    label622:
    label750:
    label757:
    Object localObject2;
    label516:
    label551:
    label691:
    label960:
    label997:
    label2286:
    label2675:
    do
    {
      Object localObject1;
      do
      {
        do
        {
          return;
          if (!Utils.b(paramMessage.frienduin)) {
            break;
          }
          localObject1 = BaseApplicationImpl.getContext();
          localObject3 = ((ActivityManager)((Context)localObject1).getSystemService("activity")).getRunningTasks(1);
          if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQAppInterface", 2, "BabyQ topActivity packageName: " + ((ActivityManager.RunningTaskInfo)((List)localObject3).get(0)).topActivity.getPackageName());
          }
        } while (((Context)localObject1).getPackageName().equals(((ActivityManager.RunningTaskInfo)((List)localObject3).get(0)).topActivity.getPackageName()));
        localObject3 = "";
        localObject6 = "";
        localMessageRecord = null;
        localObject4 = null;
        if (!ActionMsgUtil.d(paramMessage.msgtype)) {
          break;
        }
        localObject1 = EmosmUtils.a(getApp(), paramMessage);
        if (paramMessage.msgtype == -2051)
        {
          localObject3 = TroopBusinessUtil.a(paramMessage);
          if (localObject3 != null) {
            paramMessage.nickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject3).c;
          }
        }
        localObject7 = a(getApp(), paramMessage, true);
        ((Intent)localObject7).putExtra("entrance", 6);
        ((Intent)localObject7).putExtra("key_notification_click_action", true);
        localObject9 = ((Intent)localObject7).getStringExtra("uinname");
        if ((localObject9 != null) && (!"".equals(localObject9))) {
          break label4438;
        }
        localObject9 = ((Intent)localObject7).getStringExtra("uin");
        switch (paramMessage.istroop)
        {
        default: 
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.b() == 1)
          {
            if ((!AppConstants.K.equals(paramMessage.frienduin)) && (!AppConstants.ap.equals(paramMessage.frienduin)) && (!AppConstants.aw.equals(paramMessage.frienduin))) {
              break label3227;
            }
            localObject4 = a(paramMessage.senderuin, true);
          }
          localObject6 = (String)localObject9 + ": ";
          localObject3 = localObject1;
          localObject8 = localObject9;
          localObject10 = localObject1;
          if (ActionMsgUtil.a(paramMessage.msgtype))
          {
            if ((paramMessage.actMsgContentValue == null) || ("".endsWith(paramMessage.actMsgContentValue))) {
              break label3241;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQAppInterface", 2, "isShareAppActionMsg+ actionDetailMsg=" + paramMessage.actMsgContentValue);
            }
            localObject1 = paramMessage.actMsgContentValue;
            localObject10 = localObject1;
            localObject3 = localObject1;
          }
          if (paramMessage.istroop != 1008) {
            break label3347;
          }
          localObject1 = (String)localObject6 + (String)localObject3;
          if (paramMessage.msgtype != -2016) {
            break label4391;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(getApplication(), paramMessage, true);
          localObject6 = localObject3;
          if (paramMessage.counter <= 1) {
            break label4384;
          }
          if (paramMessage.counter <= 100) {
            break label3403;
          }
          localObject1 = (String)localObject8 + " (" + getApp().getString(2131435830) + ")";
          if (paramBoolean) {
            break label4381;
          }
          localObject3 = null;
          if (paramMessage.istroop != 1008) {
            break label3501;
          }
        }
      } while ((paramMessage.extStr == null) || (((paramMessage.extLong & 0x1) == 0) && (!paramMessage.extStr.contains("lockDisplay"))) || (paramMessage.extStr == null) || (((paramMessage.extLong & 0x1) == 1) && (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true"))));
      ((Intent)localObject7).putExtra("need_report", true);
      ((Intent)localObject7).putExtra("incoming_msguid", paramMessage.msgUid);
      ((Intent)localObject7).putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
      localObject8 = ((Intent)localObject7).getStringExtra("uin");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject8))) {
        break label4374;
      }
      localObject3 = ((String)localObject1).replace((CharSequence)localObject8, "");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        if (!AppConstants.t.equals(localObject8)) {
          break label3486;
        }
        localObject4 = a(paramMessage.frienduin, true);
      }
      for (;;)
      {
        localObject3 = localObject6;
        localObject8 = localObject6;
        localObject9 = localObject7;
        localObject7 = localObject3;
        localObject6 = localObject1;
        localObject3 = localObject8;
        localObject1 = localObject9;
        if ((paramBoolean) && (paramMessage.istroop != 6000) && (paramMessage.istroop != 1009) && (!paramMessage.frienduin.equals(AppConstants.C))) {
          break label4227;
        }
        a((Intent)localObject1, (String)localObject3, (String)localObject6, (String)localObject7, (Bitmap)localObject4, "CMD_SHOW_NOTIFIYCATION");
        return;
        if (paramMessage.msgtype == -2009)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(getApplication(), paramMessage, true);
          break;
        }
        if (paramMessage.msgtype == -2040)
        {
          localObject1 = new MessageForApproval();
          ((MessageForApproval)localObject1).msgData = paramMessage.msgData;
          localObject1 = ((MessageForApproval)localObject1).getFullTitle();
          break;
        }
        if (paramMessage.msgtype == -2041)
        {
          localObject1 = getApp().getString(2131438331);
          localObject3 = getApp().getString(2131438332);
          localObject1 = (String)localObject1 + " " + (String)localObject3;
          break;
        }
        if (paramMessage.msgtype == -2011)
        {
          try
          {
            localObject1 = StructMsgFactory.a(paramMessage.msgData);
            if (localObject1 == null)
            {
              localObject1 = localObject3;
              if (QLog.isColorLevel())
              {
                QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg is null");
                localObject1 = localObject3;
              }
            }
            else if (((AbsStructMsg)localObject1).mMsgServiceID == 61)
            {
              localObject1 = this.app.getResources().getString(2131433677);
            }
            else if (((AbsStructMsg)localObject1).mMsgServiceID == 107)
            {
              localObject1 = this.app.getResources().getString(2131438977);
            }
            else
            {
              localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg error:" + localException.getMessage(), localException);
            }
            localObject2 = "";
          }
          break;
        }
        if (FlashPicHelper.a(paramMessage))
        {
          localObject2 = getApp().getString(2131435568);
          break;
        }
        if (paramMessage.msgtype == -7001)
        {
          localObject2 = getApp().getString(2131439069);
          break;
        }
        if (paramMessage.msgtype == -2052)
        {
          localObject2 = new MessageForQQStoryComment();
          ((MessageForQQStoryComment)localObject2).msgData = paramMessage.msgData;
          ((MessageForQQStoryComment)localObject2).parse();
          localObject2 = ((MessageForQQStoryComment)localObject2).getSummaryMsg();
          break;
        }
        if (paramMessage.msgtype == -2057)
        {
          localObject2 = "[小视频]";
          break;
        }
        if (paramMessage.msgtype == -2059)
        {
          localObject2 = new MessageForTroopPobing();
          ((MessageForTroopPobing)localObject2).msgData = paramMessage.msgData;
          ((MessageForTroopPobing)localObject2).doParse();
          localObject2 = ((MessageForTroopPobing)localObject2).getSummaryMsg();
          break;
        }
        localObject3 = paramMessage.getMessageText();
        if (!TroopRobotManager.b(paramMessage)) {
          break label4441;
        }
        if (!TroopRobotManager.d(paramMessage)) {
          TroopRobotManager.a(paramMessage);
        }
        localObject2 = TroopRobotManager.b(paramMessage);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label4441;
        }
        localObject3 = localObject2;
        localObject2 = localObject3;
        if (LoveLanguageManager.a(paramMessage)) {
          localObject2 = LoveLanguageManager.b(((CharSequence)localObject3).toString());
        }
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = "";
        }
        if ((localObject3 instanceof QQText))
        {
          localObject2 = ((QQText)localObject3).a();
          break;
        }
        localObject2 = new QQText(((CharSequence)localObject3).toString(), 3).a();
        break;
        localObject3 = a(paramMessage);
        if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName))) {
          localObject6 = (String)localObject3 + paramMessage.nickName + "(" + (String)localObject9 + "):";
        }
        for (localObject3 = (String)localObject3 + paramMessage.nickName + ": " + (String)localObject2;; localObject3 = (String)localObject3 + (String)localObject4 + ": " + (String)localObject2)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.b() != 1) {
            break label4423;
          }
          localObject4 = (DiscussionHandler)a(6);
          if (localObject4 == null) {
            break label4417;
          }
          localObject4 = ((DiscussionHandler)localObject4).a(paramMessage.frienduin, true);
          localObject10 = localObject2;
          localObject8 = localObject9;
          break;
          localObject4 = ContactUtils.a(this, paramMessage.senderuin, 0);
          localObject6 = (String)localObject3 + (String)localObject4 + "(" + (String)localObject9 + "):";
        }
        if ((paramMessage.msgtype == -1013) || (paramMessage.msgtype == -2030) || (paramMessage.msgtype == -1047))
        {
          localObject6 = (String)localObject9 + ":";
          localObject3 = localObject2;
          localObject10 = localObject2;
          localObject8 = localObject9;
          localObject4 = localMessageRecord;
          break label551;
        }
        localObject3 = "";
        String str;
        if (AnonymousChatHelper.a(paramMessage))
        {
          localObject4 = AnonymousChatHelper.a(paramMessage).b;
          new StringBuilder().append(getApp().getString(2131430287)).append((String)localObject4).append("(").append((String)localObject9).append("):").toString();
          new StringBuilder().append(getApp().getString(2131430287)).append((String)localObject4).append(": ").append((String)localObject2).toString();
          if (paramMessage.msgtype != -2035)
          {
            localObject4 = localObject2;
            if (paramMessage.msgtype != -2038) {}
          }
          else
          {
            localObject4 = MessageForGrayTips.getOrginMsg((String)localObject2);
          }
          localObject2 = localObject4;
          if (paramMessage.msgtype == -3006)
          {
            localObject2 = MessageForPubAccount.getMsgSummary(this, paramMessage, false);
            localObject3 = PublicAccountConfigUtil.a(this, getApplication().getApplicationContext());
          }
          if (!MsgProxyUtils.j(paramMessage.msgtype)) {
            break label2258;
          }
          localObject3 = a(paramMessage);
          str = (String)localObject3 + "(" + (String)localObject9 + "):";
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label2286;
          }
        }
        for (localObject11 = (String)localObject3 + ": " + (String)localObject2;; localObject11 = localObject2)
        {
          localObject3 = localObject11;
          localObject10 = localObject2;
          localObject8 = localObject9;
          localObject6 = str;
          localObject4 = localMessageRecord;
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.b() != 1) {
            break;
          }
          localObject4 = a(paramMessage.frienduin, (byte)3, false, false);
          localObject3 = localObject11;
          localObject10 = localObject2;
          localObject8 = localObject9;
          localObject6 = str;
          break;
          if (!TextUtils.isEmpty(paramMessage.nickName))
          {
            localObject3 = paramMessage.nickName;
            break label2003;
          }
          localObject3 = ContactUtils.g(this, paramMessage.frienduin, paramMessage.senderuin);
          break label2003;
          localObject3 = a(paramMessage) + (String)localObject3;
          break label2086;
        }
        localObject4 = ((Intent)localObject7).getStringExtra("subAccountLatestNick");
        if (localObject4 != null)
        {
          localObject3 = localObject4;
          if (((String)localObject4).length() != 0) {}
        }
        else
        {
          localObject3 = paramMessage.senderuin;
        }
        localObject6 = (String)localObject9 + "-" + (String)localObject3 + ":" + (String)localObject2;
        localObject3 = (String)localObject3 + ":" + (String)localObject2;
        localObject4 = null;
        localObject10 = localObject2;
        localObject8 = localObject9;
        break label551;
        localObject6 = (String)localObject9 + ": ";
        localObject3 = localObject2;
        localObject10 = localObject2;
        localObject8 = localObject9;
        localObject4 = localMessageRecord;
        break label551;
        if (String.valueOf(AppConstants.G).equals(paramMessage.frienduin))
        {
          localObject4 = ContactUtils.q(this, paramMessage.senderuin);
          localObject3 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject3 = paramMessage.senderuin;
          }
          str = (String)localObject3 + "(" + (String)localObject9 + "):";
          if (paramMessage.msgtype != -2053) {
            break label2675;
          }
          localObject3 = paramMessage.nickName;
        }
        for (localObject11 = getApp().getString(2131437862) + (String)localObject3 + (String)localObject2;; localObject11 = a(paramMessage) + (String)localObject3 + ": " + (String)localObject2)
        {
          localObject3 = localObject11;
          localObject10 = localObject2;
          localObject8 = localObject9;
          localObject6 = str;
          localObject4 = localMessageRecord;
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.b() != 1) {
            break;
          }
          localObject4 = a(paramMessage.frienduin, 200);
          localObject3 = localObject11;
          localObject10 = localObject2;
          localObject8 = localObject9;
          localObject6 = str;
          break;
          localObject4 = ContactUtils.q(this, paramMessage.frienduin);
          localObject3 = localObject4;
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            break label2493;
          }
          localObject3 = paramMessage.frienduin;
          break label2493;
        }
        localObject4 = SkinUtils.a(getApp().getResources().getDrawable(2130842387));
        localObject8 = getApp().getString(2131439188);
        localObject3 = new ConfessInfo();
        ((ConfessInfo)localObject3).parseFromJsonStr(paramMessage.getExtInfoFromExtStr("ext_key_confess_info"));
        localObject3 = ConfessMsgUtil.a(this, (ConfessInfo)localObject3, paramMessage.senderuin);
        localObject6 = (String)localObject3 + "(" + (String)localObject8 + "):" + (String)localObject2;
        localObject3 = (String)localObject3 + ":" + (String)localObject2;
        localObject10 = localObject2;
        break label551;
        localObject4 = SkinUtils.a(getApp().getResources().getDrawable(2130839203));
        localObject8 = XMLMessageUtils.a(paramMessage);
        if ((localObject8 == null) || (((PAMessage)localObject8).items.isEmpty())) {
          break label4402;
        }
        localObject3 = ((PAMessage.Item)((PAMessage)localObject8).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject8).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject8).items.get(0)).digestList != null))
        {
          localObject9 = (String)((PAMessage.Item)((PAMessage)localObject8).items.get(0)).digestList.get(0);
          localObject8 = localObject3;
          localObject3 = localObject9;
          localObject10 = localObject2;
          break label551;
        }
        localObject10 = localObject2;
        localObject8 = localObject9;
        break label551;
        localObject4 = SkinUtils.a(getApp().getResources().getDrawable(2130842153));
        localObject6 = (String)localObject9 + ": ";
        localObject3 = localObject2;
        localObject10 = localObject2;
        localObject8 = localObject9;
        break label551;
        if (("device_groupchat".equals(paramMessage.extStr)) && ((paramMessage.msgtype == -4501) || (paramMessage.msgtype == -4508)))
        {
          localObject4 = ContactUtils.b(this, paramMessage.senderuin, true);
          localObject3 = localObject4;
          if (!TextUtils.isEmpty(paramMessage.senderuin))
          {
            localObject3 = localObject4;
            if (paramMessage.senderuin.equals(paramMessage.frienduin)) {
              localObject3 = SmartDeviceUtil.a(((SmartDeviceProxyMgr)a(51)).a(Long.parseLong(paramMessage.senderuin)));
            }
          }
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = "";
          }
          localObject3 = (String)localObject4 + ": " + (String)localObject2;
          localObject10 = localObject2;
          localObject8 = localObject9;
          localObject4 = localMessageRecord;
          break label551;
        }
        localObject3 = localObject2;
        localObject10 = localObject2;
        localObject8 = localObject9;
        localObject4 = localMessageRecord;
        break label551;
        localObject4 = a(paramMessage.frienduin, true);
        break label516;
        localObject2 = a().a(AppShareIDUtil.a(paramMessage.shareAppID));
        if ((localObject2 == null) || (((AppShareID)localObject2).messagetail == null) || ("".equals(((AppShareID)localObject2).messagetail)))
        {
          localObject2 = getApp().getString(2131435936);
          break label622;
        }
        localObject2 = getApp().getString(2131435934) + ((AppShareID)localObject2).messagetail + this.app.getString(2131435935);
        break label622;
        localObject2 = localObject6;
        if (paramMessage.istroop == 7000) {
          break label662;
        }
        localObject2 = localObject6;
        if (MsgProxyUtils.a(paramMessage.istroop) == 1032) {
          break label662;
        }
        localObject2 = (String)localObject6 + (String)localObject10;
        break label662;
        localObject2 = (String)localObject8 + " (" + paramMessage.counter + getApp().getString(2131434663) + ")";
        break label750;
        localObject6 = (String)localObject3 + " : " + (String)localObject6;
        break label910;
        localObject2 = getApp().getString(2131435508);
      }
      if (paramMessage.istroop != 7220) {
        break;
      }
    } while (!ReadInJoyUtils.b(this, paramMessage));
    label662:
    label1504:
    Object localObject8 = "";
    label902:
    label910:
    label1728:
    label2003:
    Object localObject9 = "0";
    label2086:
    label2258:
    Object localObject11 = "";
    label2493:
    label3403:
    Object localObject10 = null;
    label3227:
    label3241:
    label3501:
    label4402:
    label4417:
    label4423:
    label4438:
    label4441:
    label4447:
    for (;;)
    {
      int i1;
      try
      {
        localMessageRecord = a().b(paramMessage.frienduin, paramMessage.istroop);
        if ((localMessageRecord instanceof MessageForStructing))
        {
          localObject4 = (MessageForStructing)localMessageRecord;
          localObject10 = localObject4;
          if (((MessageForStructing)localObject4).structingMsg == null)
          {
            ((MessageForStructing)localObject4).parse();
            localObject10 = localObject4;
          }
        }
        if ((localObject10 == null) || (((MessageForStructing)localObject10).extInt != 1)) {
          continue;
        }
        if (((MessageForStructing)localObject10).structingMsg == null) {
          break label4342;
        }
        if (!TextUtils.isEmpty(((MessageForStructing)localObject10).structingMsg.mArticleIds)) {
          localObject8 = localObject10.structingMsg.mArticleIds.split("\\|")[0];
        }
        if (((MessageForStructing)localObject10).structingMsg.mStrategyIds != null) {
          localObject9 = localObject10.structingMsg.mStrategyIds.split("\\|")[0];
        }
        if (((MessageForStructing)localObject10).structingMsg.mAlgorithmIds == null) {
          break label4367;
        }
        localObject4 = localObject10.structingMsg.mAlgorithmIds.split("\\|")[0];
        if (TextUtils.isEmpty(((MessageForStructing)localObject10).structingMsg.mInnerUniqIds)) {
          break label4360;
        }
        localObject11 = ((MessageForStructing)localObject10).structingMsg.mInnerUniqIds.split("\\|");
        int i2 = localObject11.length;
        i1 = 0;
        if (i1 >= i2) {
          break label4353;
        }
        localObject10 = localObject11[i1];
        if (TextUtils.isEmpty((CharSequence)localObject10)) {
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      localObject11 = new JSONObject();
      ((JSONObject)localObject11).put("algorithm_id", localObject4);
      ((JSONObject)localObject11).put("rowkey", localObject10);
      PublicAccountReportUtils.a(null, "CliOper", "", paramMessage.senderuin, "0X80081DC", "0X80081DC", 0, 0, "", (String)localObject8, (String)localObject9, ((JSONObject)localObject11).toString(), false);
      localObject8 = ImageUtil.e();
      localObject4 = localObject6;
      localObject6 = localObject2;
      localObject2 = localObject7;
      localObject7 = localObject4;
      localObject4 = localObject8;
      break label960;
      i1 += 1;
      continue;
      if (localMessageRecord.extInt == 5)
      {
        localObject8 = "0";
        localObject4 = "";
        localObject10 = localObject11;
        continue;
        if (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (paramMessage.msgtype == -3001))
        {
          if (OpenAppClient.a(this.app.getApplicationContext(), paramMessage.action, paramMessage.frienduin, paramMessage.istroop) == null) {
            break;
          }
          localObject8 = localObject6;
          localObject6 = localObject2;
          localObject2 = localObject7;
          localObject7 = localObject8;
          break label960;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.b() > 1)
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.a();
          localObject5 = new StringBuffer();
          ((StringBuffer)localObject5).append(String.format(getApp().getString(2131435835), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.b()) }));
          if (i1 == 0) {
            break;
          }
          if (i1 > 1000) {
            ((StringBuffer)localObject5).append(getApp().getString(2131435829));
          }
          for (;;)
          {
            localObject2 = new Intent(getApp(), SplashActivity.class);
            ((Intent)localObject2).addFlags(335544320);
            ((Intent)localObject2).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
            localObject6 = getApp().getString(2131435828);
            localObject7 = ((StringBuffer)localObject5).toString();
            localObject5 = null;
            break;
            ((StringBuffer)localObject5).append(i1).append(getApp().getString(2131434663));
          }
        }
        if (paramMessage.istroop == 0)
        {
          ((Intent)localObject7).putExtra("need_report", true);
          ((Intent)localObject7).putExtra("incoming_msguid", paramMessage.msgUid);
          ((Intent)localObject7).putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
          ((Intent)localObject7).putExtra("KEY_FROM", "notifcation");
        }
        localObject8 = localObject6;
        localObject6 = localObject2;
        localObject2 = localObject7;
        localObject7 = localObject8;
        break label960;
        if (QQUtils.a(getApp()))
        {
          localObject8 = (QQLSRecentManager)getManager(71);
          if (NotifyPushSettingActivity.a()) {}
          for (paramBoolean = false;; paramBoolean = SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131435404), "qqsetting_lock_screen_whenexit_key", true))
          {
            if (!paramBoolean) {
              break label4321;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  showInComingMsg");
            }
            ((QQLSRecentManager)localObject8).a(this, paramMessage.frienduin, paramMessage.istroop, false);
            break;
          }
          label4321:
          break label997;
        }
        if (!QLog.isColorLevel()) {
          break label997;
        }
        QLog.d("QQAppInterface", 2, "screen unlock");
        break label997;
      }
      label4342:
      Object localObject5 = "";
      localObject10 = localObject11;
      continue;
      localObject10 = "";
      break label4447;
      localObject10 = localObject11;
      continue;
      localObject5 = "";
      continue;
      localObject3 = localObject2;
      break label902;
      break label757;
      localObject2 = localObject8;
      break label750;
      localObject6 = localObject3;
      localObject3 = localObject2;
      break label691;
      localObject3 = localObject2;
      localObject10 = localObject2;
      localObject8 = localObject9;
      break label551;
      localObject5 = null;
      break label1728;
      localObject10 = localObject2;
      localObject8 = localObject9;
      localObject5 = localMessageRecord;
      break label551;
      break label349;
      break label1504;
      break label251;
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "showMsgNotification: entryA message.frienduin=" + paramMessage.frienduin + ", message.senderuin=" + paramMessage.senderuin + ", needSoundVibrationsTip " + paramBoolean1 + " , isOnline " + paramBoolean2);
    }
    int i2;
    if (f())
    {
      a(paramMessage, true);
      i2 = 0;
      i1 = i2;
      if (this.jdField_a_of_type_Int == 0)
      {
        i1 = i2;
        if (paramBoolean1) {
          i1 = 1;
        }
      }
      if (paramMessage.istroop != 1001)
      {
        i2 = i1;
        if (paramMessage.istroop != 10002) {}
      }
      else
      {
        i2 = i1;
        if (paramMessage.msgtype == -3001) {
          i2 = 1;
        }
      }
      i1 = i2;
      if (paramMessage.istroop == 1008) {
        if ((paramMessage.extStr == null) || ((paramMessage.extLong & 0x1) != 0) || (!paramMessage.extStr.contains("lockDisplay")))
        {
          i1 = i2;
          if (paramMessage.extStr != null)
          {
            i1 = i2;
            if ((paramMessage.extLong & 0x1) == 1)
            {
              i1 = i2;
              if (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
            }
          }
        }
        else
        {
          i1 = i2;
          if (paramBoolean1) {
            i1 = 1;
          }
        }
      }
      i2 = i1;
      if (paramMessage.istroop == 1008)
      {
        i2 = i1;
        if (AppConstants.t.equals(paramMessage.senderuin)) {
          i2 = 1;
        }
      }
      if (paramMessage.istroop != 9002) {
        break label318;
      }
    }
    label318:
    for (int i1 = i3;; i1 = i2)
    {
      if (i1 != 0) {
        d(paramMessage, paramBoolean2);
      }
      return;
      f(true);
      break;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (f()) {
      b(paramMessageRecord, true);
    }
    for (;;)
    {
      int i2 = 0;
      int i1 = i2;
      if (this.jdField_a_of_type_Int == 0)
      {
        i1 = i2;
        if (paramBoolean1) {
          i1 = 1;
        }
      }
      if (paramMessageRecord.istroop != 1001)
      {
        i2 = i1;
        if (paramMessageRecord.istroop != 10002) {}
      }
      else
      {
        i2 = i1;
        if (paramMessageRecord.msgtype == -3001) {
          i2 = 1;
        }
      }
      i1 = i2;
      if (paramMessageRecord.istroop == 1008) {
        if ((paramMessageRecord.extStr == null) || ((paramMessageRecord.extLong & 0x1) != 0) || (!paramMessageRecord.extStr.contains("lockDisplay")))
        {
          i1 = i2;
          if (paramMessageRecord.extStr != null)
          {
            i1 = i2;
            if ((paramMessageRecord.extLong & 0x1) == 1)
            {
              i1 = i2;
              if (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
            }
          }
        }
        else
        {
          i1 = i2;
          if (paramBoolean1) {
            i1 = 1;
          }
        }
      }
      i2 = i1;
      if (paramMessageRecord.istroop == 1008)
      {
        i2 = i1;
        if (AppConstants.t.equals(paramMessageRecord.senderuin)) {
          i2 = 1;
        }
      }
      if (i2 != 0) {
        d(paramMessageRecord, paramBoolean2);
      }
      return;
      c(paramMessageRecord, true);
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) || (paramInt1 == 103)) {}
    while ((paramInt1 == 32) && (paramInt2 == 200)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (!paramQQAppInterface.jdField_h_of_type_Boolean)
    {
      String str = paramQQAppInterface.getAccount();
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (localSharedPreferences.contains(str + "_" + "long_text_msg_config_version")) {
        paramQQAppInterface.jdField_i_of_type_Boolean = localSharedPreferences.getBoolean(str + "_msfpull_filter_switch", true);
      }
    }
    paramQQAppInterface.jdField_h_of_type_Boolean = true;
    return paramQQAppInterface.jdField_i_of_type_Boolean;
  }
  
  private Object[] a(Setting paramSetting, String paramString, int paramInt)
  {
    String str = paramString;
    int i1 = paramInt;
    if (paramSetting != null)
    {
      str = paramString;
      i1 = paramInt;
      if (paramInt != 101)
      {
        str = paramString;
        i1 = paramInt;
        if (paramInt != 1001)
        {
          str = paramString;
          i1 = paramInt;
          if (paramString != null)
          {
            str = paramString;
            i1 = paramInt;
            if (paramSetting.bHeadType == 0)
            {
              str = String.valueOf(paramSetting.systemHeadID);
              if (paramInt != 4) {
                break label94;
              }
              i1 = -56;
            }
          }
        }
      }
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(i1), str };
      label94:
      if (paramInt == 16) {
        i1 = 16;
      } else {
        i1 = -55;
      }
    }
  }
  
  private Intent b(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("uin", paramMessage.frienduin);
    paramContext.putExtra("troop_uin", paramMessage.senderuin);
    paramContext.putExtra("uintype", paramMessage.istroop);
    paramContext.putExtra("uinname", a(paramMessage, paramBoolean));
    paramContext = AIOUtils.a(paramContext, new int[] { 2 });
    paramContext.setAction("com.tencent.mobileqq.action.CHAT");
    return paramContext;
  }
  
  private BusinessHandler b(int paramInt)
  {
    Object localObject2 = null;
    long l1 = System.currentTimeMillis();
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        QLog.d("Conversation", 2, "createHandler,cost time:" + (l2 - l1));
      }
      return localObject1;
      localObject1 = new MessageHandler(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = ((MessageHandler)localObject1);
      continue;
      localObject1 = new FriendListHandler(this);
      continue;
      localObject1 = new CardHandler(this);
      continue;
      localObject1 = new MusicPlayerHandler(this);
      continue;
      localObject1 = new LBSHandler(this);
      continue;
      localObject1 = new ConfigHandler(this);
      continue;
      localObject1 = new ReportHandler(this);
      continue;
      localObject1 = new DiscussionHandler(this);
      continue;
      localObject1 = new QZoneNotifyHandler(this);
      continue;
      localObject1 = new DataLineHandler_210(this);
      continue;
      localObject1 = new RegisterProxySvcPackHandler(this);
      continue;
      localObject1 = new PublicAccountHandler(this);
      continue;
      localObject1 = new EmoticonHandler(this);
      continue;
      localObject1 = new SVIPHandler(this);
      continue;
      localObject1 = new ThemeHandler(this);
      continue;
      localObject1 = new QvipSpecialCareHandler(this);
      continue;
      localObject1 = new ClubContentUpdateHandler(this);
      continue;
      localObject1 = new SubAccountBindHandler(this);
      continue;
      localObject1 = new ShieldListHandler(this);
      continue;
      localObject1 = new TroopHandler(this);
      continue;
      localObject1 = new EnterpriseQQHandler(this);
      continue;
      localObject1 = new BizTroopHandler(this);
      continue;
      localObject1 = new StartAppCheckHandler(this);
      continue;
      localObject1 = new SafeCenterPushHandler(this);
      continue;
      localObject1 = new QPSafeCheckHandler(this);
      continue;
      localObject1 = new StrangerHandler(this);
      continue;
      localObject1 = new VipInfoHandler(this);
      continue;
      localObject1 = new TroopQZoneUploadAlbumHandler(this);
      continue;
      localObject1 = new CardPayHandler(this);
      continue;
      localObject1 = new RedTouchHandler(this);
      continue;
      localObject1 = new NearFieldDiscussHandler(this);
      continue;
      localObject1 = new SecSvcHandler(this);
      continue;
      localObject1 = new HotChatHandler(this);
      continue;
      localObject1 = new BmqqBusinessHandler(this);
      continue;
      localObject1 = new VideoC2CHandler(this);
      continue;
      localObject1 = new SignatureHandler(this);
      continue;
      localObject1 = new QWalletAuthHandler(this);
      continue;
      localObject1 = new TroopRedTouchHandler(this);
      continue;
      localObject1 = new UniPayHandler(this);
      continue;
      localObject1 = new VipSetFunCallHandler(this);
      continue;
      localObject1 = new QPayHandler(this);
      continue;
      localObject1 = new RouterHandler(this);
      continue;
      localObject1 = new DeviceMsgHandle(this);
      continue;
      localObject1 = new DeviceFileHandler(this);
      continue;
      localObject1 = new SmartDeviceProxyMgr(this);
      continue;
      localObject1 = new LightalkSwitchHanlder(this);
      continue;
      localObject1 = new BabyQHandler(this);
      continue;
      localObject1 = new ChatBackgroundAuthHandler(this);
      continue;
      localObject1 = new RedpointHandler(this);
      continue;
      localObject1 = new NumRedPointHandler(this);
      continue;
      localObject1 = new NumRedMsgHandler(this);
      continue;
      localObject1 = new NearFieldTroopHandler(this);
      continue;
      localObject1 = new PPCLoginAuthHandler(this);
      continue;
      localObject1 = new MessageRoamHandler(this);
      continue;
      localObject1 = new NearbyCardHandler(this);
      continue;
      localObject1 = new ReadInJoyHandler(this);
      continue;
      localObject1 = new MSFNetTransportProvider(this);
      continue;
      localObject1 = new SubscriptHandler(this);
      continue;
      localObject1 = new EcShopHandler(this);
      continue;
      localObject1 = new NearbyRelevantHandler(this);
      continue;
      localObject1 = new BubbleDiyHandler(this);
      continue;
      localObject1 = new DingdongPluginBizHandler(this);
      continue;
      localObject1 = new FavEmoRoamingHandler(this);
      continue;
      localObject1 = new VIPRecommendPayHandler(this);
      continue;
      localObject1 = new PrinterStatusHandler(this);
      continue;
      localObject1 = new QWalletHandler(this);
      continue;
      localObject1 = new VasExtensionHandler(this);
      continue;
      localObject1 = new LightalkShieldHandler(this);
      continue;
      localObject1 = new QCallCardHandler(this);
      continue;
      localObject1 = new VipComicMqqHandler(this);
      continue;
      localObject1 = new GlobalSearchHandler(this);
      continue;
      localObject1 = new PstnHandler(this);
      continue;
      localObject1 = new LoginWelcomeHandler(this);
      continue;
      localObject1 = new QidianHandler(this);
      continue;
      localObject1 = new VIPAioSendHandler(this);
      continue;
      localObject1 = new EcshopReportHandler(this);
      continue;
      localObject1 = new NearbyHandler(this);
      continue;
      localObject1 = new VideoPlayRecommendHandler(this);
      continue;
      localObject1 = new RedtouchHandler(this);
      continue;
      localObject1 = new ArkAppHandler(this);
      continue;
      localObject1 = new PublicAccountArticleHandler(this);
      continue;
      localObject1 = new OlympicHandler(this);
      continue;
      localObject1 = new VoiceChangeHandler(this);
      continue;
      localObject1 = new DynamicAvatarInfoHandler(this);
      continue;
      localObject1 = new VideoPlayCountHandler(this);
      continue;
      localObject1 = new QQStoryHandler(this);
      continue;
      localObject1 = new ArMapHandler(this);
      continue;
      localObject1 = new NowHandler(this);
      continue;
      localObject1 = new VasMonitorHandler(this);
      continue;
      localObject1 = new BigDataGetIpHandler(this);
      continue;
      localObject1 = new QidianPubAccountBigDataHandler(this);
      continue;
      localObject1 = new LebaGridHandler(this);
      continue;
      localObject1 = new WerewolvesHandler(this);
      continue;
      localObject1 = new CampusCircleHandler(this);
      continue;
      localObject1 = new GdtAdHandler(this);
      continue;
      localObject1 = new FlashChatHanlder(this);
      continue;
      localObject1 = new UniteSearchHandler(this);
      continue;
      localObject1 = new PersonalityLabelHandler(this);
      continue;
      localObject1 = new OCRHandler(this);
      continue;
      localObject1 = new DiyPendantHandler(this);
      continue;
      localObject1 = new ApolloContentUpdateHandler(this);
      continue;
      localObject1 = new ImmersionHandler(this);
      continue;
      localObject1 = new PokeBigResHandler(this);
      continue;
      localObject1 = new ShortVideoHandler(this);
      continue;
      localObject1 = new NowSmallVideoHandler(this);
      continue;
      localObject1 = new TeamWorkFileImportHandler(this);
      continue;
      localObject1 = new ReadInJoySkinHandler(this);
      continue;
      localObject1 = new ConfessHandler(this);
      continue;
      localObject1 = new TeamWorkHandler(this);
      continue;
      localObject1 = new ARRelationShipHandler(this);
      continue;
      localObject1 = new LoveLanguageHandler(this);
      continue;
      localObject1 = new LebaFeedsHandler(this);
      continue;
      localObject1 = new VideoPlayDianZanHandler(this);
      continue;
      localObject1 = new ExtendFriendHandler(this);
    }
  }
  
  public static String b(int paramInt1, String paramString, int paramInt2)
  {
    String str;
    if (paramInt1 == 4) {
      str = "troop_" + paramString;
    }
    do
    {
      return str;
      if (paramInt1 == 32) {
        return "stranger_" + String.valueOf(paramInt2) + "_" + paramString;
      }
      str = paramString;
    } while (paramInt1 != 16);
    return "qcall_" + String.valueOf(paramInt2) + "_" + paramString;
  }
  
  private void b(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {}
    label165:
    label203:
    label209:
    do
    {
      return;
      int i3 = paramIntent.getExtras().getInt("faceType", 1);
      Object localObject2 = paramIntent.getExtras().getStringArrayList("uinList");
      paramContext = new ArrayList();
      ??? = new ArrayList();
      paramIntent = new ArrayList();
      if (QLog.isColorLevel()) {
        QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, receive uinList: ", (ArrayList)localObject2);
      }
      int i1;
      String str;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        i1 = 0;
        if (i1 < ((ArrayList)localObject2).size())
        {
          str = (String)((ArrayList)localObject2).get(i1);
          int i2;
          if ((str != null) && (str.length() > 0))
          {
            Object localObject3 = new File(a(i3, str, 0));
            if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
              break label203;
            }
            i2 = 1;
            if (i2 == 0) {
              break label209;
            }
            localObject3 = a(i3, str, 0);
            paramContext.add(str);
            ((ArrayList)???).add(localObject3);
          }
          for (;;)
          {
            i1 += 1;
            break;
            i2 = 0;
            break label165;
            paramIntent.add(str);
          }
        }
      }
      try
      {
        if (paramContext.size() > 0)
        {
          localObject2 = new Intent("com.tencent.qqhead.getheadresp");
          ((Intent)localObject2).putExtra("faceType", i3);
          ((Intent)localObject2).putStringArrayListExtra("uinList", paramContext);
          ((Intent)localObject2).putStringArrayListExtra("headPathList", (ArrayList)???);
          getApp().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp");
        }
        if (paramIntent.size() > 0)
        {
          l1 = System.currentTimeMillis();
          localObject2 = (FriendListHandler)a(1);
          i1 = 0;
          if (i1 < paramIntent.size())
          {
            str = (String)paramIntent.get(i1);
            if (i3 == 1) {
              ((FriendListHandler)localObject2).a(str, (byte)0, (byte)2);
            }
          }
        }
      }
      catch (Exception localException)
      {
        synchronized (this.jdField_a_of_type_JavaUtilHashtable)
        {
          do
          {
            for (;;)
            {
              long l1;
              this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l1));
              i1 += 1;
              continue;
              localException = localException;
              QLog.e("Q.qqhead.broadcast", 2, "headQQHeadBroadcast error", localException);
            }
          } while (i3 != 4);
          ((FriendListHandler)localObject2).d(str);
        }
      }
    } while (!QLog.isColorLevel());
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, response uinList: ", paramContext);
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead uinList: ", paramIntent);
  }
  
  private boolean b(String paramString)
  {
    return (String.valueOf(AppConstants.F).equals(paramString)) || (String.valueOf(AppConstants.H).equals(paramString)) || (String.valueOf(AppConstants.G).equals(paramString));
  }
  
  private void c(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((this.j) || (!NoDisturbUtil.a(this.app.getApplicationContext(), this))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("notification", 4, String.format("showNoMsgContetnNotifcationForQAV fail 1, message:%s", new Object[] { paramMessageRecord }));
      }
    }
    Object localObject;
    int i1;
    Intent localIntent;
    StringBuffer localStringBuffer;
    int i2;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QCallFacade)getManager(37);
          if (localObject != null) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("notification", 4, String.format("showNoMsgContetnNotifcationForQAV fail 2, message:%s", new Object[] { paramMessageRecord }));
        return;
        i1 = ((QCallFacade)localObject).b();
      } while (i1 == 0);
      if (i1 != 1) {
        break label469;
      }
      if (((paramMessageRecord.msgtype != -2016) && (paramMessageRecord.msgtype != -4008)) || (paramMessageRecord.istroop != 3000)) {
        break;
      }
      localIntent = a(getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(getApp().getString(2131435834));
      i2 = ((QCallFacade)localObject).a();
    } while (i2 == 0);
    if (i2 > 1000)
    {
      localStringBuffer.append(getApp().getString(2131435831));
      label227:
      localObject = null;
      if (paramBoolean) {
        localObject = localStringBuffer.toString();
      }
      if (paramMessageRecord.msgtype != -2016) {
        break label543;
      }
      if (QLog.isColorLevel()) {
        QLog.e("notification", 2, "AVNotify:MSG_TYPE_MULTI_VIDEO, count:" + i1);
      }
      if (paramMessageRecord.istroop == 3000)
      {
        if (QLog.isColorLevel()) {
          QLog.e("notification", 2, "AVNotify:UIN_TYPE_DISCUSSION, count:" + i1);
        }
        localIntent.putExtra("qav_notify_flag", true);
      }
    }
    for (;;)
    {
      a(localIntent, (String)localObject, getApp().getResources().getString(2131435828), localStringBuffer.toString(), null, "CMD_SHOW_NOTIFIYCATION");
      return;
      if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004))
      {
        localIntent = new Intent(getApp(), SplashActivity.class);
        localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
        localIntent.putExtra("conversation_index", 1);
        localIntent.setFlags(335544320);
        break;
      }
      localIntent = a(getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
      break;
      label469:
      localIntent = new Intent(getApp(), SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      localIntent.putExtra("conversation_index", 1);
      localIntent.setFlags(335544320);
      break;
      localStringBuffer.append(i2).append(getApp().getString(2131435833));
      break label227;
      label543:
      if (paramMessageRecord.msgtype == -2009)
      {
        if (QLog.isColorLevel()) {
          QLog.e("notification", 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO, count:" + i1);
        }
        localIntent.putExtra("qav_notify_flag", true);
      }
    }
  }
  
  private String d()
  {
    try
    {
      int i1 = Process.myPid();
      Object localObject = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i1)
        {
          localObject = localRunningAppProcessInfo.processName;
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("QQAppInterface", 1, "failed to get current process name");
    }
    return null;
  }
  
  private void d(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    label126:
    boolean bool1;
    boolean bool4;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      localObject1 = null;
      if (paramMessageRecord != null)
      {
        if (paramMessageRecord.msgtype == -2020) {
          localObject1 = paramMessageRecord.getBaseInfoString();
        }
      }
      else {
        QLog.d("notification", 2, "message is:" + (String)localObject1 + ",isOnline is:" + paramBoolean);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "previous vibrate time is:" + this.jdField_f_of_type_Long + ",curr time is:" + System.currentTimeMillis());
      }
      if (this.jdField_f_of_type_Long != -1L) {
        break label388;
      }
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      bool1 = h();
      bool4 = NoDisturbUtil.a(this.app.getApplicationContext(), this);
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool4);
      }
      if ((paramMessageRecord == null) || (paramMessageRecord.istroop != 1008) || (!AppConstants.t.equals(paramMessageRecord.senderuin))) {
        break label592;
      }
      bool2 = false;
      bool3 = false;
      paramMessageRecord = RingtoneManager.getActualDefaultRingtoneUri(getApp(), 2);
      localObject1 = (Vibrator)getApp().getSystemService("vibrator");
      if ((!k()) || (!bool4)) {
        break label516;
      }
      paramBoolean = true;
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "canVibrator: " + paramBoolean + " canPlaySound: " + bool1 + " uri: " + paramMessageRecord);
      }
      if ((paramBoolean) && (localObject1 != null)) {
        ((Vibrator)localObject1).vibrate(jdField_b_of_type_ArrayOfLong, -1);
      }
      if ((bool1) && (paramMessageRecord != null)) {
        AudioUtil.a(paramMessageRecord, false, false);
      }
    }
    label388:
    label592:
    while ((bool1) || (!bool4)) {
      for (;;)
      {
        return;
        localObject1 = "not shake msg,uinSeq is:" + paramMessageRecord.uniseq;
        break;
        if (Math.abs(System.currentTimeMillis() - this.jdField_f_of_type_Long) > 2000L) {
          break label126;
        }
        if (paramMessageRecord == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SpecialCare", 2, "message = null");
          }
        }
        else if (paramMessageRecord.msgtype != -2020)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SpecialCare", 2, "message.msgtype != MessageRecord.MSG_TYPE_SHAKE_WINDOW");
          }
        }
        else
        {
          if ((paramBoolean) && (a() == 11L)) {
            break label126;
          }
          if (QLog.isColorLevel())
          {
            QLog.e("SpecialCare", 2, "isOnline = " + paramBoolean + " getOnlineStatus = " + a());
            return;
            if ((i()) && (j()) && (bool4))
            {
              bool1 = true;
              paramBoolean = true;
            }
            else
            {
              paramBoolean = bool3;
              bool1 = bool2;
              if (i())
              {
                paramBoolean = bool3;
                bool1 = bool2;
                if (!j())
                {
                  paramBoolean = bool3;
                  bool1 = bool2;
                  if (bool4)
                  {
                    bool1 = true;
                    paramBoolean = bool3;
                  }
                }
              }
            }
          }
        }
      }
    }
    label516:
    SharedPreferences localSharedPreferences = getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    Object localObject4 = (Vibrator)getApp().getSystemService("vibrator");
    boolean bool3 = c();
    Object localObject3 = "";
    Object localObject1 = "";
    int i1;
    label735:
    int i2;
    if (paramMessageRecord != null)
    {
      if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1004))
      {
        localObject1 = paramMessageRecord.frienduin;
        localObject3 = "special_sound_type" + getCurrentAccountUin() + (String)localObject1;
      }
    }
    else
    {
      bool1 = z();
      bool2 = y();
      i1 = RoamSettingController.a(this);
      if (i1 != 0) {
        break label1004;
      }
      if (c() != 1) {
        break label999;
      }
      i1 = 1;
      i2 = i1;
      if ((paramMessageRecord == null) || (paramMessageRecord.istroop != 1)) {
        break label1617;
      }
      if ((!bool1) || (!x())) {
        break label1022;
      }
      bool1 = true;
      label765:
      if ((!bool2) || (!w())) {
        break label1028;
      }
      bool2 = true;
    }
    label780:
    label1433:
    label1563:
    label1611:
    label1617:
    for (;;)
    {
      bool4 = m();
      boolean bool5 = v();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool2 + ",isVideoing is:" + bool3 + ",isCallIdle is:" + bool4 + ",notRecordingPtt is:" + bool5);
      }
      if ((bool2) && (bool4) && (!bool3) && (bool5))
      {
        if ((paramMessageRecord != null) && (paramBoolean) && (paramMessageRecord.msgtype == -2020) && (a() == 11L))
        {
          ((Vibrator)localObject4).vibrate(jdField_a_of_type_ArrayOfLong, -1);
          i1 = 2;
        }
        for (;;)
        {
          int i4 = this.jdField_d_of_type_JavaUtilList.size();
          int i3 = 0;
          while (i3 < i4)
          {
            ((VibrateListener)this.jdField_d_of_type_JavaUtilList.get(i3)).m(i1);
            i3 += 1;
          }
          if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1032)
          {
            localObject1 = AppConstants.aE;
            break;
          }
          localObject1 = paramMessageRecord.senderuin;
          break;
          label999:
          i1 = 0;
          break label735;
          label1004:
          if (i1 == 1) {}
          for (i1 = 1;; i1 = 0)
          {
            i2 = i1;
            break;
          }
          label1022:
          bool1 = false;
          break label765;
          bool2 = false;
          break label780;
          if (localSharedPreferences.contains((String)localObject3))
          {
            ((Vibrator)localObject4).vibrate(1000L);
            i1 = 3;
          }
          else
          {
            ((Vibrator)localObject4).vibrate(jdField_b_of_type_ArrayOfLong, -1);
            i1 = 1;
          }
        }
      }
      if ((i2 != 0) && (!bool3) && (!k()) && (!l()) && (bool4) && (bool5))
      {
        i1 = SettingCloneUtil.readValueForInt(this.app, getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.jdField_b_of_type_Int);
        if (localSharedPreferences.contains((String)localObject3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "-->SpecialSound");
          }
          localObject4 = (FriendsManager)getManager(50);
          if ((localObject4 != null) && (((FriendsManager)localObject4).b((String)localObject1)))
          {
            i1 = localSharedPreferences.getInt((String)localObject3, i1);
            if (i1 != 1) {
              break label1433;
            }
            try
            {
              ThreadManager.post(new zkp(this), 8, null, true);
              return;
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("notification", 2, localException.getMessage());
              }
            }
          }
        }
      }
      label1234:
      Object localObject2;
      if ((bool1) && (!bool3) && (!k()) && (!l()) && (bool4) && (bool5))
      {
        i2 = SettingCloneUtil.readValueForInt(this.app, getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.jdField_b_of_type_Int);
        if (QLog.isColorLevel())
        {
          localObject2 = (AudioManager)getApp().getSystemService("audio");
          localObject3 = new StringBuilder().append("StreamVolume=");
          if (localObject2 != null) {
            break label1553;
          }
        }
      }
      for (i1 = 0;; i1 = ((AudioManager)localObject2).getStreamVolume(2))
      {
        QLog.d("notification", 2, i1 + ",SoundRid=" + i2);
        if (i2 != SoundAndVibrateActivity.jdField_b_of_type_Int) {
          break label1611;
        }
        localObject2 = ThemeUtil.getThemeVoiceRootPath();
        if (localObject2 == null) {
          break label1563;
        }
        localObject2 = new File((String)localObject2 + File.separatorChar + "message.mp3");
        if (!((File)localObject2).exists()) {
          break label1563;
        }
        AudioUtil.a(Uri.fromFile((File)localObject2), false, true);
        return;
        localObject2 = localSharedPreferences.getString("special_sound_url" + i1, "");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1234;
        }
        localObject3 = new File(this.app.getFilesDir(), (String)localObject2);
        if (((File)localObject3).exists())
        {
          AudioUtil.a(((File)localObject3).getAbsolutePath(), false);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this.app.getApplicationContext(), this);
        }
        a(new zkq(this, (String)localObject2, (File)localObject3));
        break label1234;
        break;
      }
      for (i1 = 2131230721;; i1 = i2)
      {
        i2 = i1;
        if (paramMessageRecord != null)
        {
          i2 = i1;
          if (b(paramMessageRecord.frienduin)) {
            i2 = 2131230758;
          }
        }
        ThreadManager.post(new zkr(this, i2), 8, null, true);
        return;
      }
    }
  }
  
  /* Error */
  private String e()
  {
    // Byte code:
    //   0: ldc_w 2560
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 387	com/tencent/mobileqq/app/QQAppInterface:app	Lcom/tencent/common/app/BaseApplicationImpl;
    //   9: invokevirtual 2564	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   12: astore_3
    //   13: aload 4
    //   15: astore_2
    //   16: aload_3
    //   17: aload_0
    //   18: getfield 387	com/tencent/mobileqq/app/QQAppInterface:app	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 381	com/tencent/common/app/BaseApplicationImpl:getPackageName	()Ljava/lang/String;
    //   24: iconst_0
    //   25: invokevirtual 2570	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   28: astore 5
    //   30: aload 4
    //   32: astore_3
    //   33: aload 5
    //   35: ifnull +99 -> 134
    //   38: aload 4
    //   40: astore_2
    //   41: aload 4
    //   43: astore_3
    //   44: aload 5
    //   46: getfield 2575	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   49: ifnull +85 -> 134
    //   52: aload 4
    //   54: astore_2
    //   55: aload 5
    //   57: getfield 2575	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: ifnull +67 -> 134
    //   70: aload 4
    //   72: astore_2
    //   73: aload 4
    //   75: ldc_w 2577
    //   78: invokevirtual 797	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: astore 5
    //   83: iconst_3
    //   84: istore_1
    //   85: aload 4
    //   87: astore_2
    //   88: aload 4
    //   90: astore_3
    //   91: iload_1
    //   92: aload 5
    //   94: arraylength
    //   95: if_icmple +39 -> 134
    //   98: aload 4
    //   100: astore_2
    //   101: new 117	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   108: aload 4
    //   110: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 2579
    //   116: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 4
    //   124: iload_1
    //   125: iconst_1
    //   126: isub
    //   127: istore_1
    //   128: goto -43 -> 85
    //   131: astore_3
    //   132: aload_2
    //   133: astore_3
    //   134: aload_3
    //   135: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	QQAppInterface
    //   84	44	1	i1	int
    //   15	118	2	str1	String
    //   12	79	3	localObject1	Object
    //   131	1	3	localException	Exception
    //   133	2	3	localObject2	Object
    //   3	120	4	str2	String
    //   28	65	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	30	131	java/lang/Exception
    //   44	52	131	java/lang/Exception
    //   55	62	131	java/lang/Exception
    //   73	83	131	java/lang/Exception
    //   91	98	131	java/lang/Exception
    //   101	124	131	java/lang/Exception
  }
  
  public static void f(String paramString)
  {
    TextToSpeech localTextToSpeech = jdField_a_of_type_AndroidSpeechTtsTextToSpeech;
    if ((localTextToSpeech != null) && (!TextUtils.isEmpty(paramString))) {
      localTextToSpeech.speak(paramString, 1, null);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if ((this.j) || (!NoDisturbUtil.a(this.app.getApplicationContext(), this))) {}
    Intent localIntent;
    StringBuffer localStringBuffer;
    int i1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.b() != 1) {
        break;
      }
      localIntent = a(getApp(), (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.a().get(0), false);
      localIntent.putExtra("entrance", 6);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(getApp().getString(2131435834));
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.a();
    } while (i1 == 0);
    if (i1 > 1000)
    {
      localStringBuffer.append(getApp().getString(2131435829));
      label147:
      if (!paramBoolean) {
        break label248;
      }
    }
    label248:
    for (String str = localStringBuffer.toString();; str = null)
    {
      a(localIntent, str, getApp().getResources().getString(2131435828), localStringBuffer.toString(), null, "CMD_SHOW_NOTIFIYCATION");
      return;
      localIntent = new Intent(getApp(), SplashActivity.class);
      localIntent.addFlags(335544320);
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      break;
      localStringBuffer.append(i1).append(getApp().getString(2131434663));
      break label147;
    }
  }
  
  private boolean v()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener.g());
  }
  
  private boolean w()
  {
    return b() != 0;
  }
  
  private boolean x()
  {
    return a() != 0;
  }
  
  private boolean y()
  {
    return d() != 0;
  }
  
  private boolean z()
  {
    return c() != 0;
  }
  
  public void A()
  {
    LeakInspector.a(this, String.format("%d", new Object[] { Long.valueOf(getLongAccountUin()) }));
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.b();
    }
    Object localObject = (SubAccountManager)getManager(60);
    if (localObject != null) {
      ((SubAccountManager)localObject).b();
    }
    localObject = (ActivateFriendsManager)getManager(84);
    if (localObject != null) {
      ((ActivateFriendsManager)localObject).d();
    }
  }
  
  public void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "refreshAppBadge");
    }
    if ((this.isBackground_Stop) && (BadgeUtils.a(this.app.getApplicationContext()))) {
      ThreadManager.post(new zky(this), 5, null, false);
    }
  }
  
  @TargetApi(14)
  public void D()
  {
    try
    {
      AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.app.getSystemService("accessibility");
      bool1 = localAccessibilityManager.isEnabled();
      boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label100;
      }
      bool1 = true;
      AppSetting.b = bool1;
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "set talkback enable: " + AppSetting.b);
      }
    }
    catch (Throwable localThrowable)
    {
      boolean bool1;
      label73:
      label100:
      break label73;
    }
    if (AppSetting.b) {
      if (jdField_a_of_type_AndroidSpeechTtsTextToSpeech == null) {
        jdField_a_of_type_AndroidSpeechTtsTextToSpeech = new TextToSpeech(BaseApplicationImpl.sApplication, null);
      }
    }
    while (jdField_a_of_type_AndroidSpeechTtsTextToSpeech == null)
    {
      return;
      bool1 = false;
      break;
    }
    jdField_a_of_type_AndroidSpeechTtsTextToSpeech.stop();
    jdField_a_of_type_AndroidSpeechTtsTextToSpeech = null;
  }
  
  public void E()
  {
    int i1 = 2131436118;
    if ((this.app != null) && (isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Mobile ");
      }
      localObject1 = a();
      bool1 = ((TransFileController)localObject1).c();
      bool2 = ((TransFileController)localObject1).a();
      bool3 = ((TransFileController)localObject1).b();
      localObject2 = BaseActivity.sTopActivity;
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
        if (!bool2) {
          break label307;
        }
        if (!bool3) {
          break label296;
        }
      }
    }
    label296:
    label307:
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      Object localObject2;
      i1 = 2131436117;
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QQAppInterface", 2, "onX2Mobile==============pauseAllRawSendC2C:" + bool1);
          QLog.d("QQAppInterface", 2, "onX2Mobile==============pauseAllShortVideoSend:" + bool2);
          QLog.d("QQAppInterface", 2, "onX2Mobile==============pauseAllShortVideoReceive:" + bool3);
          QLog.d("QQAppInterface", 2, "onX2Mobile==============dialog message:" + ((Context)localObject1).getResources().getString(i1));
        }
        ((Intent)localObject2).putExtra("key_dialog_msg_id", i1);
        ((Context)localObject1).startActivity((Intent)localObject2);
        return;
        if (!bool1)
        {
          i1 = 2131436114;
          continue;
          if (bool3)
          {
            if (!bool1) {
              i1 = 2131436115;
            }
          }
          else {
            i1 = 2131436116;
          }
        }
      }
    }
    QLog.d("QQAppInterface", 2, "onX2Mobile app = null,maybe not QQ process");
  }
  
  public void F()
  {
    if (this.app != null) {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Wifi ");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QQAppInterface", 2, "onX2Wifi app = null,maybe not QQ process");
  }
  
  public void G()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      jdField_b_of_type_Int = localSharedPreferences.getInt("browser_font_size_index", 1);
    }
  }
  
  public int a()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.group.ring", 0);
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    int i2 = -1;
    int i1;
    if ((this.app == null) || (paramInt < 0) || (paramInt >= 7))
    {
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.e("QQAppInterface", 2, "readCallTabStateVal wrong index," + paramInt);
        i1 = i2;
      }
    }
    do
    {
      String str;
      do
      {
        return i1;
        str = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
        if ((str != null) && (str.length() == 7)) {
          break;
        }
        i1 = i2;
      } while (!QLog.isColorLevel());
      QLog.e("QQAppInterface", 2, "readCallTabStateVal val is null");
      return -1;
      i2 = str.charAt(paramInt) - '0';
      i1 = i2;
    } while (!QLog.isColorLevel());
    QLog.i("QQAppInterface", 2, "uin:" + getCurrentAccountUin() + ",readCallTabStateVal index=" + paramInt + ", resut=" + i2);
    return i2;
  }
  
  public int a(String paramString)
  {
    int i3 = 0;
    try
    {
      Class[] arrayOfClass = Class.forName("com.android.internal.R").getDeclaredClasses();
      int i4 = arrayOfClass.length;
      int i1 = 0;
      for (;;)
      {
        int i2 = i3;
        if (i1 < i4)
        {
          Class localClass = arrayOfClass[i1];
          if ("id".equals(localClass.getSimpleName())) {
            i2 = localClass.getDeclaredField(paramString).getInt(null);
          }
        }
        else
        {
          return i2;
        }
        i1 += 1;
      }
      return 0;
    }
    catch (Exception paramString) {}
  }
  
  public long a()
  {
    if ((getAccount() != null) && (isLogin()))
    {
      if (this.jdField_e_of_type_Long == 31L)
      {
        this.jdField_e_of_type_Long = getApp().getSharedPreferences("acc_info" + getAccount(), 0).getLong("getProfileStatusNew", 11L);
        if (this.jdField_e_of_type_Long == 31L)
        {
          this.jdField_e_of_type_Long = 11L;
          a(11L, false);
        }
      }
      return this.jdField_e_of_type_Long;
    }
    return -1L;
  }
  
  public Intent a(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020) || (paramMessage.istroop == 1004))
    {
      if (RecentUtil.a(this, paramMessage.frienduin)) {
        return a(getApp(), paramMessage, 0);
      }
      return b(paramContext, paramMessage, paramBoolean);
    }
    return a(getApp(), paramMessage, paramMessage.istroop);
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte1, int paramInt2, boolean paramBoolean, byte paramByte2, int paramInt3)
  {
    if ((paramInt1 == 1) && (paramString != null) && ((paramString.equals(AppConstants.H)) || (paramString.equals(AppConstants.G)) || (paramString.equals(AppConstants.D)) || (paramString.equals(AppConstants.F)))) {
      return ImageUtil.i();
    }
    if ((paramInt1 == 11) && (!StringUtil.d(paramString))) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((paramInt1 == 101) || (paramInt1 == 1001)) {
      paramByte1 = 1;
    }
    for (;;)
    {
      if ((paramInt1 == 4) && (!TroopUtils.a(paramString))) {}
      for (paramByte2 = 113;; paramByte2 = paramInt1)
      {
        if (paramByte2 == 113) {
          paramByte1 = 1;
        }
        String str1 = a(paramByte2, paramString, paramByte1, paramInt3, paramInt2, false);
        Object localObject1 = a(str1);
        boolean bool;
        String str2;
        BitmapManager.BitmapDecodeResult localBitmapDecodeResult;
        label296:
        Object localObject2;
        if (localObject1 == null) {
          if (paramBoolean)
          {
            localObject1 = a(paramByte2, paramString, paramInt3);
            if (localObject1 != null)
            {
              bool = ((Boolean)((Pair)localObject1).first).booleanValue();
              str2 = a(paramByte2, paramString, paramInt3);
              localBitmapDecodeResult = a(str2);
              if (localBitmapDecodeResult.jdField_a_of_type_Int != 0) {
                QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decodeFile fail, faceType=" + paramByte2 + ", uin=" + paramString + ", result=" + localBitmapDecodeResult.jdField_a_of_type_Int + ", facePath=" + str2);
              }
              if ((!bool) && (localBitmapDecodeResult.jdField_a_of_type_Int == 1)) {
                return null;
              }
              if (localBitmapDecodeResult.jdField_a_of_type_Int != 2)
              {
                paramInt1 = 1;
                localObject1 = localBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap;
                if ((localObject1 == null) && (localBitmapDecodeResult.jdField_a_of_type_Int != 1) && (paramInt1 != 0))
                {
                  if (paramByte2 != 4) {
                    break label960;
                  }
                  localObject2 = "troop_" + paramString;
                }
              }
            }
          }
        }
        for (;;)
        {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            if (this.jdField_a_of_type_JavaUtilHashMap == null) {
              this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
            }
            Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
            if (localInteger == null)
            {
              paramInt2 = 0;
              QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + (String)localObject2 + ", nDecodeFailCount = " + paramInt2);
              if (paramInt2 < 3)
              {
                paramInt2 += 1;
                this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(paramInt2));
                FileUtils.d(str2);
                QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + (String)localObject2 + ", del the damaged file,nDecodeFailCount=" + paramInt2);
              }
              if (localObject1 == null) {
                break label957;
              }
            }
            switch (paramByte1)
            {
            case 2: 
            default: 
              localObject1 = a((Bitmap)localObject1);
              if (localObject1 == null) {
                break label830;
              }
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.", 2, "getFaceBitmap decode success, faceType=" + paramByte2 + ", uin=" + paramString + ", shape=" + paramByte1 + ", path=" + str2 + ", bmp=" + localObject1);
              }
              a(str1, (Bitmap)localObject1, FaceManager.a(paramByte2));
              if (((localObject1 == null) && (paramBoolean) && (paramInt1 == 0)) || (bool))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("Q.qqhead.", 2, "getFaceBitmap needUpdate, faceType=" + paramByte2 + ", uin=" + paramString + ", shape=" + paramByte1);
                }
                if (paramInt1 == 0) {
                  break label895;
                }
                paramByte1 = 1;
                localObject2 = (FriendListHandler)a(1);
              }
              switch (paramByte2)
              {
              default: 
                return localObject1;
                paramInt1 = 0;
                break label296;
                paramInt2 = localInteger.intValue();
              }
              break;
            }
          }
          continue;
          localObject1 = a((Bitmap)localObject1, 50, 50);
          continue;
          label830:
          if ((QLog.isColorLevel()) && (localBitmapDecodeResult.jdField_a_of_type_Int == 0)) {
            QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decode shape fail, faceType=" + paramByte2 + ", uin=" + paramString + ", shape=" + paramByte1);
          }
          continue;
          label895:
          paramByte1 = 2;
          continue;
          ((FriendListHandler)localObject2).b(paramString, paramByte1);
          continue;
          ((FriendListHandler)localObject2).a(paramString, paramByte1);
          continue;
          ((FriendListHandler)localObject2).a(paramString, (byte)0, paramByte1);
          continue;
          ((FriendListHandler)localObject2).a(paramString, paramInt3, (byte)1, paramByte1);
          continue;
          ((FriendListHandler)localObject2).b(paramString, paramInt3, (byte)1, paramByte1);
          continue;
          label957:
          continue;
          label960:
          localObject2 = paramString;
          continue;
          bool = false;
          break;
          bool = false;
          paramInt1 = 0;
        }
      }
    }
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte1, boolean paramBoolean, byte paramByte2, int paramInt2)
  {
    return a(paramInt1, paramString, paramByte1, 100, paramBoolean, paramByte2, paramInt2);
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramString, paramByte, paramBoolean, (byte)1, paramInt2);
  }
  
  public Bitmap a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramString, (byte)3, paramBoolean, paramInt2);
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    return ImageUtil.c(paramBitmap, 50, 50);
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = this.app.getResources().getDisplayMetrics().density;
    int i1 = paramBitmap.getWidth();
    float f1 = f2;
    if (i1 > 0)
    {
      f1 = f2;
      if (i1 < paramInt1 * f2) {
        f1 = i1 / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          localBitmap1 = localBitmap2;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
          {
            long l1 = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
            localBitmap1 = localBitmap2;
            if (System.currentTimeMillis() - l1 > jdField_d_of_type_Long)
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
              this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
              localBitmap1 = null;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.", 2, "getFaceBitmap from cache, key: " + paramString + " value: " + localBitmap1);
      }
      return localBitmap1;
    }
    return null;
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean)
  {
    return a(1, paramString, paramByte, paramBoolean, 0);
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(4, paramString, paramByte, true, 0);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = ImageUtil.f();
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
        paramString = b((Bitmap)localObject);
      }
    }
    return paramString;
  }
  
  public Bitmap a(String paramString, int paramInt)
  {
    return a(32, paramString, true, paramInt);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(1, paramString, (byte)3, paramBoolean, 0);
  }
  
  public Drawable a(String paramString)
  {
    return a(paramString, (byte)3, false, false);
  }
  
  public Drawable a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramString, paramByte, paramBoolean1, paramBoolean2);
    paramString = null;
    if (localObject != null) {
      paramString = new BitmapDrawable((Bitmap)localObject);
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = ImageUtil.c();
    }
    return localObject;
  }
  
  public Pair a(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject2 = null;
    String str = b(paramInt1, paramString, paramInt2);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) {
        localObject1 = (Setting)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(str);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
        {
          I();
          localObject1 = (Setting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, str);
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(str, localObject1);
            localObject2 = localObject1;
          }
        }
      }
    }
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.qaif", 2, "getQQHeadSetting. qqset is null, | uin=" + paramString);
      }
      return new Pair(Boolean.valueOf(true), localObject2);
    }
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (bool)) {
        QLog.i("Q.qqhead.qaif", 2, "getQQHeadSetting. | uin=" + paramString + ", isNeedCheckQQHead=" + bool + ", accountStartTime=" + this.jdField_g_of_type_Long + ", updateTimestamp=" + localObject2.updateTimestamp + ", status=" + localObject2.getStatus() + ", id=" + localObject2.getId() + ", currentTimeMillis=" + System.currentTimeMillis());
      }
      return new Pair(Boolean.valueOf(bool), localObject2);
      if ((localObject2 == null) || (System.currentTimeMillis() - localObject2.updateTimestamp > jdField_d_of_type_Long)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public Pair a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    paramString = a(1, paramString, (byte)3, true, 0);
    if (paramString == null) {
      paramString = ImageUtil.a();
    }
    for (;;)
    {
      return Pair.create(Boolean.valueOf(bool), paramString);
      bool = true;
    }
  }
  
  public AvAddFriendService a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppAvAddFriendService == null) {
      this.jdField_a_of_type_ComTencentAvAppAvAddFriendService = new AvAddFriendService(this);
    }
    return this.jdField_a_of_type_ComTencentAvAppAvAddFriendService;
  }
  
  public AVNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter = new AVNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentAvGaudioAVNotifyCenter;
  }
  
  public NowLiveManager a()
  {
    return (NowLiveManager)getManager(170);
  }
  
  public BusinessHandler a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      BusinessHandler localBusinessHandler = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
      localObject1 = localBusinessHandler;
      if (localBusinessHandler == null)
      {
        localBusinessHandler = b(paramInt);
        localObject1 = localBusinessHandler;
        if (localBusinessHandler != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt] = localBusinessHandler;
          localObject1 = localBusinessHandler;
        }
      }
      return localObject1;
    }
  }
  
  public CheckPttListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener;
  }
  
  public CheckPtvListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppCheckPtvListener;
  }
  
  public HotChatManager a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager == null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = ((HotChatManager)getManager(59));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
  }
  
  public LebaHelper a()
  {
    n();
    return this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper;
  }
  
  public MessageHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = ((MessageHandler)a(0));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  }
  
  public QQGAudioMsgHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler = new QQGAudioMsgHandler(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler;
  }
  
  public SQLiteDatabase a()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.a();
    }
    return null;
  }
  
  public SQLiteDatabase a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.a();
    }
    return null;
  }
  
  public CacheManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager = ((CacheManager)getManager(18));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager;
  }
  
  public ConversationFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = ((ConversationFacade)getManager(28));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
  }
  
  public MsgProxy a(int paramInt)
  {
    if (a() != null) {
      return a().a().a(paramInt);
    }
    return null;
  }
  
  public MultiMsgProxy a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a();
    }
    return null;
  }
  
  public QQMessageFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)getManager(19));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
  }
  
  public DataLineMsgProxy a(int paramInt)
  {
    return a().a(paramInt);
  }
  
  public FTSDBManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager = ((FTSDBManager)getManager(129));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager;
  }
  
  public ProxyManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)getManager(17));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  }
  
  public AboutConfig a()
  {
    N();
    return this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig;
  }
  
  public Config a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqConfigConfig == null) {
        this.jdField_a_of_type_ComTencentMobileqqConfigConfig = new Config(this, paramString);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqConfigConfig;
      return paramString;
    }
    finally {}
  }
  
  public Config a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigConfig == null) && (paramBoolean)) {
      a(paramString);
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfigConfig;
  }
  
  public ExtensionInfo a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt1, paramInt2)) {
      return a(paramString, paramBoolean);
    }
    return null;
  }
  
  public ExtensionInfo a(String paramString, boolean paramBoolean)
  {
    FriendsManager localFriendsManager = (FriendsManager)getManager(50);
    if ((localFriendsManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null))
    {
      ExtensionInfo localExtensionInfo2 = localFriendsManager.a(paramString, false);
      ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
      if (localExtensionInfo2 == null)
      {
        localExtensionInfo1 = localExtensionInfo2;
        if (paramBoolean)
        {
          localExtensionInfo1 = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class, paramString);
          localFriendsManager.a(localExtensionInfo1);
        }
      }
      return localExtensionInfo1;
    }
    return null;
  }
  
  public MsgBoxInterFollowManager a()
  {
    return (MsgBoxInterFollowManager)getManager(201);
  }
  
  public Setting a(String paramString)
  {
    return (Setting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, paramString);
  }
  
  public FileManagerEngine a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine = new FileManagerEngine(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine;
    }
    finally {}
  }
  
  public FileTransferHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler = new FileTransferHandler(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler;
  }
  
  public FileManagerDataCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter = new FileManagerDataCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter;
  }
  
  public FileManagerNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter = new FileManagerNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter;
  }
  
  public FileManagerRSCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter = new FileManagerRSCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter;
  }
  
  public OnlineFileSessionCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter = new OnlineFileSessionCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter;
  }
  
  public FileManagerProxy a()
  {
    ProxyManager localProxyManager = a();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
  }
  
  public UniformDownloadBPTransProxy a()
  {
    ProxyManager localProxyManager = a();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
  }
  
  public NearbyProxy a()
  {
    return (NearbyProxy)getManager(115);
  }
  
  public PicPreDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader = ((PicPreDownloader)getManager(38));
    }
    return this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  }
  
  public QCallFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)getManager(37));
    }
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  }
  
  public QzoneContactsFeedManager a()
  {
    return (QzoneContactsFeedManager)getManager(90);
  }
  
  public ScribbleDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleDownloader = ((ScribbleDownloader)getManager(135));
    }
    return this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleDownloader;
  }
  
  public MessageCache a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache == null) {}
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache == null) {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache = new MessageCache(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
    }
  }
  
  public ShortVideoPreDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader = ((ShortVideoPreDownloader)getManager(94));
    }
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader;
  }
  
  public ShortVideoResourceManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager = ((ShortVideoResourceManager)getManager(228));
    }
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager;
  }
  
  public ReportController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStatisticsReportController == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqStatisticsReportController == null) {
        this.jdField_a_of_type_ComTencentMobileqqStatisticsReportController = ReportControllerImpl.a(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqStatisticsReportController;
    }
    finally {}
  }
  
  public TransFileController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = new TransFileController(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
    }
    finally {}
  }
  
  @NonNull
  public BitmapManager.BitmapDecodeResult a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = jdField_a_of_type_AndroidGraphicsBitmap$Config;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    int i1 = 0;
    do
    {
      BitmapManager.a(paramString, localOptions, localBitmapDecodeResult);
      if (localBitmapDecodeResult.jdField_a_of_type_Int == 1) {
        J();
      }
      i1 += 1;
    } while ((i1 < 2) && (localBitmapDecodeResult.jdField_a_of_type_Int == 1));
    return localBitmapDecodeResult;
  }
  
  public ISecureModuleService a()
  {
    if (this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService == null) {
      this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService = SecureModuleService.getInstance(this.app);
    }
    return this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService;
  }
  
  public QQProxyForQlink a()
  {
    if (this.jdField_a_of_type_CooperationQlinkQQProxyForQlink == null) {
      this.jdField_a_of_type_CooperationQlinkQQProxyForQlink = new QQProxyForQlink(this);
    }
    return this.jdField_a_of_type_CooperationQlinkQQProxyForQlink;
  }
  
  public QlinkServiceManager a()
  {
    if (this.jdField_a_of_type_CooperationQlinkQlinkServiceManager == null) {
      this.jdField_a_of_type_CooperationQlinkQlinkServiceManager = new QlinkServiceManager(this);
    }
    return this.jdField_a_of_type_CooperationQlinkQlinkServiceManager;
  }
  
  @Deprecated
  public String a()
  {
    return null;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    localObject = MD5.toMD5((String)localObject + paramString);
    paramString = MD5.toMD5((String)localObject + paramString);
    localObject = new StringBuilder(256);
    if (paramInt == 4) {
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.bn);
      }
    }
    for (;;)
    {
      if (paramInt == 101) {
        ((StringBuilder)localObject).append("discussion_");
      }
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".png");
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_thd/");
      continue;
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.bm);
      } else {
        ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/head/_hd/");
      }
    }
  }
  
  public String a(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    return a(paramInt1, paramString, paramByte, paramInt2, 100, false);
  }
  
  public String a(int paramInt1, String paramString, byte paramByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject1 = null;
    StringBuilder localStringBuilder = new StringBuilder(16);
    label57:
    Object localObject2;
    if ((paramInt1 != 101) && (paramInt1 != 1001) && (paramString != null)) {
      if (paramBoolean)
      {
        localObject1 = b(b(paramInt1, paramString, paramInt2));
        if (paramBoolean) {
          break label120;
        }
        paramBoolean = true;
        ExtensionInfo localExtensionInfo = a(paramString, paramInt1, paramInt2, paramBoolean);
        localObject2 = localObject1;
        localObject1 = localExtensionInfo;
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((ExtensionInfo)localObject1).faceId > 0))
      {
        return VasFaceManager.a(((ExtensionInfo)localObject1).faceId, paramInt3);
        localObject1 = (Setting)a(paramInt1, paramString, paramInt2).second;
        break;
        label120:
        paramBoolean = false;
        break label57;
      }
      localObject1 = a(localObject2, paramString, paramInt1);
      switch (((Integer)localObject1[0]).intValue())
      {
      }
      for (;;)
      {
        localStringBuilder.append(paramString);
        if (paramByte > 0) {
          localStringBuilder.append("_").append(paramByte);
        }
        return localStringBuilder.toString();
        localStringBuilder.append("troop_sys_b_");
        paramString = (String)localObject1[1];
        continue;
        localStringBuilder.append("sys_");
        paramString = (String)localObject1[1];
        continue;
        localStringBuilder.append("dis_e_");
        continue;
        localStringBuilder.append("dis_pstn_e_");
        continue;
        localStringBuilder.append("troop_");
        continue;
        localStringBuilder.append("sub_");
        continue;
        localStringBuilder.append("stranger_").append(Integer.toString(paramInt2)).append("_");
        continue;
        localStringBuilder.append("qcall_").append(Integer.toString(paramInt2)).append("_");
        continue;
        localStringBuilder.append("new_troop_");
      }
      localObject2 = null;
    }
  }
  
  public String a(int paramInt1, String paramString, int paramInt2)
  {
    return a(null, paramInt1, paramString, paramInt2, false);
  }
  
  public String a(Setting paramSetting, int paramInt)
  {
    if (paramSetting == null) {
      return "";
    }
    int i1 = paramSetting.bUsrType;
    String str = Utils.c(paramSetting.uin);
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return a(paramSetting, i1, str, paramInt, true);
  }
  
  public String a(Setting paramSetting, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    Object localObject = paramSetting;
    if (paramSetting == null)
    {
      localObject = paramSetting;
      if (paramString != null)
      {
        localObject = paramSetting;
        if (paramInt1 != 101)
        {
          localObject = paramSetting;
          if (paramInt1 != 1001) {
            localObject = (Setting)a(paramInt1, paramString, paramInt2).second;
          }
        }
      }
    }
    if (!paramBoolean)
    {
      paramSetting = a(paramString, paramInt1, paramInt2, true);
      if ((paramSetting != null) && (paramSetting.faceId > 0)) {
        return VasFaceManager.a(paramSetting.faceId, 100);
      }
    }
    paramSetting = new StringBuilder(256);
    if (paramInt1 == 32) {
      if (SystemUtil.a())
      {
        paramSetting.append(AppConstants.bo);
        localObject = a((Setting)localObject, paramString, paramInt1);
        switch (((Integer)localObject[0]).intValue())
        {
        }
      }
    }
    for (;;)
    {
      localObject = MD5.toMD5(paramString);
      localObject = MD5.toMD5((String)localObject + paramString);
      paramSetting.append(MD5.toMD5((String)localObject + paramString));
      paramSetting.append(".jpg_");
      return paramSetting.toString();
      paramSetting.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
      break;
      if (SystemUtil.a())
      {
        paramSetting.append(AppConstants.bm);
        break;
      }
      paramSetting.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
      break;
      paramSetting.append("troop_sys_b_");
      paramString = (String)localObject[1];
      continue;
      paramSetting.append("sys_");
      paramString = (String)localObject[1];
      continue;
      paramSetting.append("dis_e_");
      paramString = getCurrentAccountUin() + paramString;
      continue;
      paramSetting.append("dis_pstn_e_");
      paramString = getCurrentAccountUin() + paramString;
      continue;
      paramSetting.append("troop_");
      continue;
      paramSetting.append("new_troop_");
      continue;
      paramSetting.append("stranger_").append(Integer.toString(paramInt2)).append("_");
      continue;
      paramSetting.append("qcall_").append(Integer.toString(paramInt2)).append("_");
    }
  }
  
  public String a(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(32);
      localStringBuilder.append("getServerConfigValue type=").append(paramConfigType).append(", key=").append(paramString).append(", value=");
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      if ((this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramConfigType)) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramConfigType)) && (l1 - ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramConfigType)).longValue() < 7200000L))
      {
        paramConfigType = (HashMap)this.jdField_b_of_type_JavaUtilHashtable.get(paramConfigType);
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
      if (getAccount() == null) {}
      for (Object localObject = "0";; localObject = getAccount())
      {
        localObject = ((ServerConfigManager)getManager(4)).getServerConfig((String)localObject, paramConfigType);
        if ((localObject != null) && (((String)localObject).length() != 0)) {
          break;
        }
        if (localStringBuilder != null)
        {
          localStringBuilder.append("null, configText is null");
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
        }
        return null;
      }
      try
      {
        localObject = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<ServerConfig>" + (String)localObject + "</ServerConfig>";
        XMLReader localXMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        zlk localzlk = new zlk(this);
        localXMLReader.setContentHandler(localzlk);
        localXMLReader.parse(new InputSource(new ByteArrayInputStream(((String)localObject).getBytes("UTF-8"))));
        localObject = localzlk.a();
        this.jdField_b_of_type_JavaUtilHashtable.put(paramConfigType, localObject);
        this.jdField_b_of_type_JavaUtilHashMap.put(paramConfigType, Long.valueOf(l1));
        l1 = System.currentTimeMillis() - l1;
        if (localStringBuilder != null)
        {
          localStringBuilder.append((String)((HashMap)localObject).get(paramString));
          localStringBuilder.append(",cost:").append(l1);
          QLog.d("QQAppInterface", 2, localStringBuilder.toString());
        }
        if (l1 > 2000L) {
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "getConfigLongCost", true, l1, 0L, null, null);
        }
        paramConfigType = (String)((HashMap)localObject).get(paramString);
        return paramConfigType;
      }
      catch (Exception paramConfigType)
      {
        if (localStringBuilder != null) {
          QLog.e("QQAppInterface", 2, localStringBuilder.toString(), paramConfigType);
        }
        return null;
      }
      localStringBuilder = null;
    }
  }
  
  public String a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return a(null, 4, paramString, 0, paramBoolean2);
    }
    return a(null, 1, paramString, 0, paramBoolean2);
  }
  
  /* Error */
  public HashMap a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 328	java/util/HashMap
    //   9: dup
    //   10: invokespecial 329	java/util/HashMap:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: getfield 387	com/tencent/mobileqq/app/QQAppInterface:app	Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: invokevirtual 3342	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   22: new 117	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 3344
    //   32: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 577	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   39: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 3347	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   48: iconst_1
    //   49: anewarray 111	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc_w 3349
    //   57: aastore
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: invokevirtual 3355	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_3
    //   65: aload_3
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +133 -> 203
    //   73: aload 4
    //   75: invokeinterface 3360 1 0
    //   80: ifle +123 -> 203
    //   83: aload 4
    //   85: ldc_w 3349
    //   88: invokeinterface 3363 2 0
    //   93: istore_2
    //   94: new 233	java/util/ArrayList
    //   97: dup
    //   98: invokespecial 234	java/util/ArrayList:<init>	()V
    //   101: astore 5
    //   103: aload 5
    //   105: astore_3
    //   106: aload 4
    //   108: invokeinterface 3366 1 0
    //   113: ifeq +92 -> 205
    //   116: aload 4
    //   118: iload_2
    //   119: invokeinterface 3367 2 0
    //   124: astore_3
    //   125: aload_3
    //   126: ifnull -23 -> 103
    //   129: aload 5
    //   131: aload_3
    //   132: invokevirtual 1009	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -33 -> 103
    //   139: astore_3
    //   140: aload 5
    //   142: astore_3
    //   143: aload_3
    //   144: astore 5
    //   146: aload 4
    //   148: ifnull +460 -> 608
    //   151: aload 4
    //   153: invokeinterface 3370 1 0
    //   158: iload_1
    //   159: bipush 254
    //   161: if_icmpne +77 -> 238
    //   164: aload_3
    //   165: ifnull +35 -> 200
    //   168: aload_3
    //   169: invokevirtual 544	java/util/ArrayList:size	()I
    //   172: ifle +28 -> 200
    //   175: aload 7
    //   177: bipush 254
    //   179: invokestatic 1782	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aload_3
    //   183: aload_3
    //   184: invokevirtual 544	java/util/ArrayList:size	()I
    //   187: anewarray 111	java/lang/String
    //   190: invokevirtual 3374	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   193: checkcast 3376	[Ljava/lang/String;
    //   196: invokevirtual 2817	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: pop
    //   200: aload 7
    //   202: areturn
    //   203: aconst_null
    //   204: astore_3
    //   205: aload_3
    //   206: astore 5
    //   208: aload 4
    //   210: ifnull +398 -> 608
    //   213: aload 4
    //   215: invokeinterface 3370 1 0
    //   220: goto -62 -> 158
    //   223: astore_3
    //   224: aload 4
    //   226: ifnull +10 -> 236
    //   229: aload 4
    //   231: invokeinterface 3370 1 0
    //   236: aload_3
    //   237: athrow
    //   238: aload_3
    //   239: ifnull +357 -> 596
    //   242: aload_0
    //   243: aload_3
    //   244: invokevirtual 3379	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/util/List;)Ljava/util/Map;
    //   247: astore 8
    //   249: aload 8
    //   251: ifnull +316 -> 567
    //   254: new 233	java/util/ArrayList
    //   257: dup
    //   258: invokespecial 234	java/util/ArrayList:<init>	()V
    //   261: astore 6
    //   263: new 233	java/util/ArrayList
    //   266: dup
    //   267: invokespecial 234	java/util/ArrayList:<init>	()V
    //   270: astore 4
    //   272: new 233	java/util/ArrayList
    //   275: dup
    //   276: invokespecial 234	java/util/ArrayList:<init>	()V
    //   279: astore 5
    //   281: iconst_0
    //   282: istore_2
    //   283: iload_2
    //   284: aload_3
    //   285: invokevirtual 544	java/util/ArrayList:size	()I
    //   288: if_icmpge +130 -> 418
    //   291: aload_3
    //   292: iload_2
    //   293: invokevirtual 1022	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   296: checkcast 111	java/lang/String
    //   299: astore 9
    //   301: aload 8
    //   303: aload 9
    //   305: invokeinterface 3382 2 0
    //   310: checkcast 675	java/lang/Integer
    //   313: invokevirtual 678	java/lang/Integer:intValue	()I
    //   316: tableswitch	default:+32 -> 348, 1:+39->355, 2:+60->376, 3:+32->348, 4:+81->397
    //   349: iconst_1
    //   350: iadd
    //   351: istore_2
    //   352: goto -69 -> 283
    //   355: iload_1
    //   356: iconst_m1
    //   357: if_icmpeq +8 -> 365
    //   360: iload_1
    //   361: iconst_1
    //   362: if_icmpne -14 -> 348
    //   365: aload 6
    //   367: aload 9
    //   369: invokevirtual 1009	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   372: pop
    //   373: goto -25 -> 348
    //   376: iload_1
    //   377: iconst_m1
    //   378: if_icmpeq +8 -> 386
    //   381: iload_1
    //   382: iconst_2
    //   383: if_icmpne -35 -> 348
    //   386: aload 4
    //   388: aload 9
    //   390: invokevirtual 1009	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   393: pop
    //   394: goto -46 -> 348
    //   397: iload_1
    //   398: iconst_m1
    //   399: if_icmpeq +8 -> 407
    //   402: iload_1
    //   403: iconst_4
    //   404: if_icmpne -56 -> 348
    //   407: aload 5
    //   409: aload 9
    //   411: invokevirtual 1009	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   414: pop
    //   415: goto -67 -> 348
    //   418: aload 6
    //   420: astore_3
    //   421: aload_3
    //   422: ifnull +44 -> 466
    //   425: aload_3
    //   426: invokevirtual 544	java/util/ArrayList:size	()I
    //   429: ifle +37 -> 466
    //   432: iload_1
    //   433: iconst_m1
    //   434: if_icmpeq +8 -> 442
    //   437: iload_1
    //   438: iconst_1
    //   439: if_icmpne +27 -> 466
    //   442: aload 7
    //   444: iconst_1
    //   445: invokestatic 1782	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: aload_3
    //   449: aload_3
    //   450: invokevirtual 544	java/util/ArrayList:size	()I
    //   453: anewarray 111	java/lang/String
    //   456: invokevirtual 3374	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   459: checkcast 3376	[Ljava/lang/String;
    //   462: invokevirtual 2817	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: pop
    //   466: aload 4
    //   468: ifnull +47 -> 515
    //   471: aload 4
    //   473: invokevirtual 544	java/util/ArrayList:size	()I
    //   476: ifle +39 -> 515
    //   479: iload_1
    //   480: iconst_m1
    //   481: if_icmpeq +8 -> 489
    //   484: iload_1
    //   485: iconst_2
    //   486: if_icmpne +29 -> 515
    //   489: aload 7
    //   491: iconst_2
    //   492: invokestatic 1782	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   495: aload 4
    //   497: aload 4
    //   499: invokevirtual 544	java/util/ArrayList:size	()I
    //   502: anewarray 111	java/lang/String
    //   505: invokevirtual 3374	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   508: checkcast 3376	[Ljava/lang/String;
    //   511: invokevirtual 2817	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   514: pop
    //   515: aload 5
    //   517: ifnull +47 -> 564
    //   520: aload 5
    //   522: invokevirtual 544	java/util/ArrayList:size	()I
    //   525: ifle +39 -> 564
    //   528: iload_1
    //   529: iconst_m1
    //   530: if_icmpeq +8 -> 538
    //   533: iload_1
    //   534: iconst_4
    //   535: if_icmpne +29 -> 564
    //   538: aload 7
    //   540: iconst_4
    //   541: invokestatic 1782	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   544: aload 5
    //   546: aload 5
    //   548: invokevirtual 544	java/util/ArrayList:size	()I
    //   551: anewarray 111	java/lang/String
    //   554: invokevirtual 3374	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   557: checkcast 3376	[Ljava/lang/String;
    //   560: invokevirtual 2817	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   563: pop
    //   564: aload 7
    //   566: areturn
    //   567: aconst_null
    //   568: astore 4
    //   570: aload 6
    //   572: astore 5
    //   574: goto -153 -> 421
    //   577: astore_3
    //   578: goto -354 -> 224
    //   581: astore_3
    //   582: aconst_null
    //   583: astore 4
    //   585: aconst_null
    //   586: astore_3
    //   587: goto -444 -> 143
    //   590: astore_3
    //   591: aconst_null
    //   592: astore_3
    //   593: goto -450 -> 143
    //   596: aconst_null
    //   597: astore 4
    //   599: aconst_null
    //   600: astore_3
    //   601: aload 6
    //   603: astore 5
    //   605: goto -184 -> 421
    //   608: aload 5
    //   610: astore_3
    //   611: goto -453 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	614	0	this	QQAppInterface
    //   0	614	1	paramInt	int
    //   93	259	2	i1	int
    //   64	68	3	localObject1	Object
    //   139	1	3	localException1	Exception
    //   142	64	3	localObject2	Object
    //   223	69	3	localList	List
    //   420	30	3	localArrayList1	ArrayList
    //   577	1	3	localObject3	Object
    //   581	1	3	localException2	Exception
    //   586	1	3	localObject4	Object
    //   590	1	3	localException3	Exception
    //   592	19	3	localObject5	Object
    //   4	594	4	localObject6	Object
    //   101	508	5	localObject7	Object
    //   1	601	6	localArrayList2	ArrayList
    //   13	552	7	localHashMap	HashMap
    //   247	55	8	localMap	Map
    //   299	111	9	str	String
    // Exception table:
    //   from	to	target	type
    //   106	125	139	java/lang/Exception
    //   129	136	139	java/lang/Exception
    //   15	65	223	finally
    //   73	103	577	finally
    //   106	125	577	finally
    //   129	136	577	finally
    //   15	65	581	java/lang/Exception
    //   73	103	590	java/lang/Exception
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a();
    }
    return null;
  }
  
  public Map a(List paramList)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.a(paramList, 1);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_Boolean = true;
    }
    while ((!isLogin()) || (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "Wifi, tryReuploadQfavItems");
    }
    QfavHelper.a(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ((CardHandler)a(2)).b(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    int i1 = 0;
    paramString = a(paramInt1, paramString, (byte)0, paramInt2);
    paramInt1 = i1;
    while (paramInt1 <= 3)
    {
      String str = paramString + "_" + paramInt1;
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(str);
      paramInt1 += 1;
    }
  }
  
  public void a(int paramInt1, String arg2, int paramInt2, String arg4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.broadcast", 2, "sendQQHeadBroadcast.type=" + paramInt1 + ",uin=" + ??? + ",idType=" + paramInt2 + ",path=" + ???);
    }
    if (!this.jdField_a_of_type_JavaUtilHashtable.containsKey(???)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashtable)
    {
      this.jdField_a_of_type_JavaUtilHashtable.remove(???);
      if (paramInt1 != 1) {}
    }
    Object localObject;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(???);
        ??? = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
        ???.what = 990;
        this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
        if (this.jdField_a_of_type_JavaUtilHashtable.size() <= 50) {
          break;
        }
        synchronized (this.jdField_a_of_type_JavaUtilHashtable)
        {
          long l1 = System.currentTimeMillis();
          ??? = new ArrayList();
          localObject = this.jdField_a_of_type_JavaUtilHashtable.keys();
          if (!((Enumeration)localObject).hasMoreElements()) {
            break label334;
          }
          String str = (String)((Enumeration)localObject).nextElement();
          if (Math.abs(l1 - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(str)).longValue()) <= 180000L) {
            continue;
          }
          ???.add(str);
        }
        ??? = finally;
        throw ???;
      }
      if (paramInt1 == 4) {
        synchronized (this.jdField_b_of_type_JavaUtilArrayList)
        {
          this.jdField_b_of_type_JavaUtilArrayList.add(???);
          ??? = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
          ???.what = 991;
          this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
        }
      }
    }
    label334:
    paramInt1 = 0;
    while (paramInt1 < ???.size())
    {
      localObject = (String)???.get(paramInt1);
      this.jdField_a_of_type_JavaUtilHashtable.remove(localObject);
      paramInt1 += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , size is:" + paramInt + ",isOnline is:" + paramBoolean2);
    }
    if (paramInt == 0) {}
    Object localObject;
    QQMessageFacade.Message localMessage;
    label176:
    boolean bool;
    label507:
    ActivateFriendsManager localActivateFriendsManager;
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
                        localObject = a();
                      } while (localObject == null);
                      localMessage = ((QQMessageFacade)localObject).a();
                    } while (localMessage == null);
                    if ((1000 != localMessage.istroop) && (1020 != localMessage.istroop)) {
                      break;
                    }
                    if ((localMessage.frienduin == null) || (!localMessage.frienduin.equalsIgnoreCase(getCurrentAccountUin()))) {
                      break label176;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("notification", 2, "receivedMsgNotification , stranger  self message");
                  return;
                  if ((localMessage.senderuin == null) || (!localMessage.senderuin.equalsIgnoreCase(getCurrentAccountUin()))) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("notification", 2, "receivedMsgNotification ,self message");
                return;
                if ((!a(localMessage)) || (localMessage.needNotification())) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("notification", 2, "receivedMsgNotification , isTroopMark");
              return;
            } while (((1008 == localMessage.istroop) && (localMessage.senderuin != null) && (TroopBarAssistantManager.a().a(this, localMessage.senderuin, localMessage.istroop))) || (MsgProxyUtils.d(localMessage.senderuin)) || (localMessage.msgtype == -2058));
            if (localMessage.istroop == 1008)
            {
              if ((localMessage.extStr == null) || (((localMessage.extLong & 0x1) == 0) && (!localMessage.extStr.contains("lockDisplay"))))
              {
                C();
                return;
              }
              if ((localMessage.extStr == null) || (((localMessage.extLong & 0x1) == 1) && (!localMessage.getExtInfoFromExtStr("lockDisplay").equals("true"))))
              {
                C();
                return;
              }
            }
            if ((!AppConstants.ar.equals(localMessage.frienduin)) || (1008 != localMessage.istroop)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("notification", 2, "receivedMsgNotification, not show newKandian");
          return;
          if ((!AppConstants.as.equals(localMessage.frienduin)) || (7220 != localMessage.istroop) || (ReadInJoyUtils.b(this, localMessage))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("notification", 2, "receivedMsgNotification, not show mergeKandian");
        return;
        if (!UserguideActivity.a(getApp(), getCurrentAccountUin())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("notification", 2, "receivedMsgNotification , showUserGuide");
      return;
      if (QLog.isColorLevel())
      {
        if ((!this.isBackground_Pause) && (!this.isBackground_Stop)) {
          break;
        }
        bool = true;
        QLog.d("notification", 2, new Object[] { "receivedMsgNotification , isRunBackground :", Boolean.valueOf(bool), ",userActiveStatus:", Integer.valueOf(this.jdField_a_of_type_Int), ",needSoundVibrationsTip:", Boolean.valueOf(paramBoolean1), ",baseInfo:", localMessage.getBaseInfoString() });
      }
      if (GuardManager.a != null) {
        GuardManager.a.b(0, null);
      }
      bool = ((KeyguardManager)this.app.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      if (((!this.isBackground_Pause) && (!this.isBackground_Stop) && (!bool)) || ((localMessage.istroop != 6000) && (this.jdField_a_of_type_Int != 0) && (((localMessage.istroop == 1001) || (localMessage.istroop == 10002)) && ((localMessage.msgtype != -3001) && (localMessage.istroop != 1008) && (localMessage.istroop != 9002))))) {
        break label939;
      }
      if (localMessage.istroop != 9002) {
        break label867;
      }
      localActivateFriendsManager = (ActivateFriendsManager)getManager(84);
    } while (!localActivateFriendsManager.a(localMessage.msgData));
    if (localActivateFriendsManager.b(localMessage.msgData)) {
      localMessage.counter += paramInt;
    }
    label765:
    OpenApiManager.getInstance().onReceiveNewMsg(localMessage);
    ((QQMessageFacade)localObject).a.b(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , frienduin " + localMessage.frienduin + ",type " + localMessage.istroop + ",counter:" + localMessage.counter);
    }
    a(localMessage, paramBoolean1, paramBoolean2);
    label1289:
    for (;;)
    {
      C();
      return;
      bool = false;
      break label507;
      label867:
      if (localMessage.istroop == 7220)
      {
        localMessage.counter = 1;
        break label765;
      }
      if ((AppConstants.K.equals(localMessage.frienduin)) || (AppConstants.ap.equals(localMessage.frienduin)))
      {
        localMessage.counter = paramInt;
        break label765;
      }
      localMessage.counter += paramInt;
      break label765;
      label939:
      if ((localMessage.msgtype == -1013) || (localMessage.msgtype == -2030) || (localMessage.msgtype == -1047) || (localMessage.msgtype == -1019) || (localMessage.msgtype == -1018)) {
        break;
      }
      if ((localMessage.istroop == 1008) && (AppConstants.t.equals(localMessage.senderuin)))
      {
        d(localMessage, paramBoolean2);
        return;
      }
      if ((paramBoolean1) && ((localMessage.istroop == 6000) || (this.jdField_a_of_type_Int == 0) || (((localMessage.istroop != 1001) && (localMessage.istroop != 10002)) || ((localMessage.msgtype == -3001) || (localMessage.istroop == 1008) || (localMessage.istroop == 9002)))))
      {
        if (this.jdField_d_of_type_Boolean) {
          break label1224;
        }
        d(localMessage, paramBoolean2);
      }
      for (;;)
      {
        if ((!paramBoolean1) || ((localMessage.istroop != 6000) && (this.jdField_a_of_type_Int != 0) && (((localMessage.istroop != 1001) && (localMessage.istroop != 10002)) || (localMessage.msgtype != -3001))) || ((localMessage.istroop != 1001) && (localMessage.istroop != 10002)) || (localMessage.msgtype != -3001)) {
          break label1289;
        }
        OpenAppClient.a(this.app.getApplicationContext(), localMessage.action);
        break;
        label1224:
        if ((this.jdField_c_of_type_ArrayOfLong[0] == localMessage.uniseq) && (this.jdField_c_of_type_ArrayOfLong[1] == 1L))
        {
          d(localMessage, paramBoolean2);
        }
        else
        {
          this.jdField_a_of_type_ArrayOfByte[0] = 1;
          localObject = this.jdField_a_of_type_ArrayOfByte;
          paramInt = i1;
          if (paramBoolean2) {
            paramInt = 1;
          }
          localObject[1] = ((byte)paramInt);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord)
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , size is:" + paramInt + ",isOnline is:" + paramBoolean2);
    }
    if (paramInt == 0) {}
    label50:
    do
    {
      do
      {
        do
        {
          do
          {
            break label50;
            break label50;
            break label50;
            break label50;
            do
            {
              return;
            } while (paramMessageRecord == null);
            if ((1000 != paramMessageRecord.istroop) && (1020 != paramMessageRecord.istroop)) {
              break;
            }
            if ((paramMessageRecord.frienduin == null) || (!paramMessageRecord.frienduin.equalsIgnoreCase(getCurrentAccountUin()))) {
              break label169;
            }
          } while (!QLog.isColorLevel());
          QLog.d("notification", 2, "receivedMsgNotification , stranger  self message");
          return;
          if ((paramMessageRecord.senderuin == null) || (!paramMessageRecord.senderuin.equalsIgnoreCase(getCurrentAccountUin())) || (paramMessageRecord.msgtype == -4008)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("notification", 2, "receivedMsgNotification ,self message");
        return;
      } while (((paramMessageRecord.senderuin != null) && (1008 == paramMessageRecord.istroop) && (TroopBarAssistantManager.a().a(this, paramMessageRecord.senderuin, paramMessageRecord.istroop))) || ((paramMessageRecord.istroop == 1008) && ((paramMessageRecord.extStr == null) || (((paramMessageRecord.extLong & 0x1) == 0) && (!paramMessageRecord.extStr.contains("lockDisplay"))) || (paramMessageRecord.extStr == null) || (((paramMessageRecord.extLong & 0x1) == 1) && (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true"))))) || ((String.valueOf(AppConstants.ar).equals(paramMessageRecord.frienduin)) && (1008 == paramMessageRecord.istroop)) || ((String.valueOf(AppConstants.as).equals(paramMessageRecord.frienduin)) && (7220 == paramMessageRecord.istroop) && (!ReadInJoyUtils.b(this, paramMessageRecord))));
      if (!UserguideActivity.a(getApp(), getCurrentAccountUin())) {
        break;
      }
    } while (!QLog.isColorLevel());
    label169:
    QLog.d("notification", 2, "receivedMsgNotification , showUserGuide");
    return;
    if (GuardManager.a != null) {
      GuardManager.a.b(0, null);
    }
    boolean bool = ((KeyguardManager)this.app.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    Object localObject = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "locking activity:" + ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName());
      }
      localObject = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName();
      if ((((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) || (((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) || (((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        paramInt = 1;
      }
    }
    for (;;)
    {
      int i1 = i2;
      if (paramMessageRecord.msgtype == -2016)
      {
        i1 = i2;
        if (paramMessageRecord.istroop == 3000) {
          i1 = 1;
        }
      }
      if ((paramInt != 0) && (i1 != 0)) {
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("notification", 2, "isBackground_Pause:" + this.isBackground_Pause);
        QLog.d("notification", 2, "isBackground_Stop:" + this.isBackground_Stop);
        QLog.d("notification", 2, "isScreenLocked:" + bool);
      }
      if (((!this.isBackground_Pause) && (!this.isBackground_Stop) && (!bool)) || ((paramMessageRecord.istroop != 6000) && (this.jdField_a_of_type_Int != 0) && (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && ((paramMessageRecord.msgtype != -3001) && (paramMessageRecord.istroop != 1008))))) {
        break;
      }
      a(paramMessageRecord, paramBoolean1, paramBoolean2);
      return;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong >= 0L) {
      this.jdField_c_of_type_Long = paramLong;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (e())
    {
      getApp().getSharedPreferences("acc_info" + getAccount(), 0).edit().putLong("getProfileStatusNew", paramLong).commit();
      this.jdField_e_of_type_Long = paramLong;
      if (paramBoolean) {
        l();
      }
    }
  }
  
  public void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public void a(Context paramContext, Class paramClass)
  {
    if (!a()) {}
    do
    {
      do
      {
        return;
      } while (paramContext == null);
      if (paramClass != null) {
        break label237;
      }
      if (!(paramContext instanceof Activity)) {
        break;
      }
      paramClass = new Intent(this.app.getApplicationContext(), paramContext.getClass());
      paramContext = ((Activity)paramContext).getIntent().getExtras();
      if (paramContext != null)
      {
        paramContext.remove("single");
        paramContext.remove("selfuin");
        paramClass.putExtras(paramContext);
      }
      paramClass.putExtra("fromNotification", true);
      paramClass.addFlags(536870912).addFlags(67108864);
    } while (!e());
    Object localObject1 = getCurrentAccountUin();
    Object localObject2 = null;
    Friends localFriends = ((FriendsManager)getManager(50)).c((String)localObject1);
    if (localFriends != null)
    {
      localObject2 = a(1, localFriends.uin, (byte)3, true, 0);
      paramContext = (Context)localObject2;
      if (localObject2 == null) {
        paramContext = ImageUtil.a();
      }
      if ((localFriends.name != null) && (localFriends.name.length() > 0))
      {
        localObject2 = localFriends.name;
        localObject1 = paramContext;
        paramContext = (Context)localObject2;
      }
    }
    for (;;)
    {
      a(paramClass, "", paramContext, this.app.getString(2131433006), (Bitmap)localObject1, "CMD_IDLE_NOTIFIYCATION");
      return;
      paramClass = new Intent(this.app.getApplicationContext(), SplashActivity.class);
      break;
      label237:
      paramClass = new Intent(this.app.getApplicationContext(), paramClass);
      break;
      localObject2 = paramContext;
      paramContext = (Context)localObject1;
      localObject1 = localObject2;
      continue;
      paramContext = (Context)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_b_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      if (!this.jdField_c_of_type_JavaUtilList.contains(paramBusinessObserver)) {
        this.jdField_c_of_type_JavaUtilList.add(paramBusinessObserver);
      }
      return;
    }
  }
  
  public void a(CallTabUnreadListener paramCallTabUnreadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener = paramCallTabUnreadListener;
  }
  
  public void a(CheckPttListener paramCheckPttListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener = paramCheckPttListener;
  }
  
  public void a(CheckPtvListener paramCheckPtvListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCheckPtvListener = paramCheckPtvListener;
  }
  
  public void a(MsgTabUnreadListener paramMsgTabUnreadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = paramMsgTabUnreadListener;
    if (QLog.isColorLevel()) {
      QLog.i("QQAppInterface", 2, "setMsgTabUnreadListener lis: " + paramMsgTabUnreadListener);
    }
  }
  
  public void a(VibrateListener paramVibrateListener)
  {
    if (paramVibrateListener == null) {}
    while (this.jdField_d_of_type_JavaUtilList.indexOf(paramVibrateListener) >= 0) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.add(paramVibrateListener);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.a().size();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showReadedMsgNotification, Messages size:" + i1 + ", counter:" + i2);
    }
    if ((paramMessage == null) || (i1 == 0) || (i2 == 0))
    {
      j();
      return;
    }
    if (f())
    {
      a(paramMessage, false);
      return;
    }
    f(false);
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    n();
    this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a(paramResourcePluginListener);
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    String str1;
    String str2;
    Bitmap localBitmap;
    QQMessageFacade.Message localMessage;
    Intent localIntent;
    int i1;
    if ((1010 == paramMessageRecord.istroop) || (1001 == paramMessageRecord.istroop) || (10002 == paramMessageRecord.istroop))
    {
      boolean bool = ((KeyguardManager)this.app.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      localObject = "";
      str1 = "";
      str2 = "";
      localBitmap = null;
      localMessage = new QQMessageFacade.Message();
      MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
      if ((!this.isBackground_Pause) && (!this.isBackground_Stop) && (!bool)) {
        break label628;
      }
      localIntent = new Intent(getApp(), MsgBoxListActivity.class);
      localIntent.addFlags(335544320);
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "OneWayMessageNotifyVibert mr.frienduin" + paramMessageRecord.frienduin + ", mr.istroop" + paramMessageRecord.istroop);
      }
      if (1010 != paramMessageRecord.istroop) {
        break label533;
      }
      localIntent.putExtra("uin", AppConstants.X);
      localIntent.putExtra("uintype", paramMessageRecord.istroop);
      localIntent.setAction("com.tencent.mobileqq.action.CHAT");
      localIntent.putExtra("uinname", "");
      localIntent.putExtra("entrance", 6);
      localIntent.putExtra("key_notification_click_action", true);
      if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002))
      {
        localBitmap = SkinUtils.a(getApp().getResources().getDrawable(2130839201));
        localObject = BaseApplicationImpl.getApplication();
        if (paramMessageRecord.istroop != 1001) {
          break label581;
        }
        i1 = 2131437982;
        label307:
        str1 = ((BaseApplicationImpl)localObject).getString(i1);
        localObject = BaseApplicationImpl.getApplication();
        if (paramMessageRecord.istroop != 1001) {
          break label588;
        }
        i1 = 2131437984;
        label334:
        str2 = ((BaseApplicationImpl)localObject).getString(i1);
        localIntent.putExtra("key_notifycation_oneway_message", true);
        paramMessageRecord = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
        if (paramMessageRecord.length() <= 0) {
          break label647;
        }
        paramMessageRecord = paramMessageRecord.split("\\|");
        if (paramMessageRecord.length < 6) {
          break label647;
        }
        str1 = paramMessageRecord[4];
        str2 = paramMessageRecord[5];
      }
    }
    label647:
    for (Object localObject = str2;; localObject = str2)
    {
      a(localIntent, (String)localObject, str1, str2, localBitmap, "CMD_SHOW_NOTIFIYCATION");
      if (QQUtils.a(getApp()))
      {
        paramMessageRecord = (QQLSRecentManager)getManager(71);
        if (SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131435404), "qqsetting_lock_screen_whenexit_key", true))
        {
          if (1001 != localMessage.istroop) {
            break label595;
          }
          paramMessageRecord.a(this, AppConstants.ac, localMessage.istroop, false);
          ReportController.b(this, "dc00899", "grp_lbs", "", "msg_box", "notice_msg", 0, 0, "", "", "", "");
        }
      }
      label519:
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        d(localMessage, paramBoolean);
        return;
        label533:
        if ((1001 != paramMessageRecord.istroop) && (10002 != paramMessageRecord.istroop)) {
          break;
        }
        localIntent.putExtra("uin", AppConstants.G);
        localIntent.putExtra("uintype", paramMessageRecord.istroop);
        break;
        label581:
        i1 = 2131437983;
        break label307;
        label588:
        i1 = 2131437985;
        break label334;
        label595:
        if (1010 != localMessage.istroop) {
          break label519;
        }
        paramMessageRecord.a(this, AppConstants.ad, localMessage.istroop, false);
        break label519;
      }
      label628:
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        d(localMessage, paramBoolean);
        return;
      }
    }
  }
  
  public void a(Setting paramSetting)
  {
    if (paramSetting != null)
    {
      paramSetting = paramSetting.clone();
      if (paramSetting != null)
      {
        paramSetting.url = null;
        if (!TextUtils.isEmpty(paramSetting.uin))
        {
          I();
          this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramSetting.uin, paramSetting);
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService != null) {
      this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.", 2, "deleteStrangerFace.id=" + paramString + ",idType=" + paramInt);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
      a(32, paramString, paramInt);
      IPCFaceHelper localIPCFaceHelper = a().a(false);
      if (localIPCFaceHelper != null) {
        localIPCFaceHelper.a(32, paramString, paramInt);
      }
      paramString = new File(a(32, paramString, paramInt));
    } while ((paramString == null) || (!paramString.exists()));
    paramString.delete();
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    label13:
    long l1;
    do
    {
      do
      {
        do
        {
          break label13;
          do
          {
            return;
          } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
          localObject = a(32, paramString, paramInt);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l1 = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l1 == paramLong);
      Object localObject = (FriendListHandler)a(1);
      if (localObject != null) {
        ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshStrangerFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l1);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.", 2, "refreshStrangerFace.id=" + paramString + ",idType=" + paramInt + ",delLocalCache=" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
      if (paramBoolean)
      {
        a(32, paramString, paramInt);
        localObject = new File(a(32, paramString, paramInt));
        if ((localObject != null) && (((File)localObject).exists())) {
          ((File)localObject).delete();
        }
      }
      localObject = (FriendListHandler)a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
  }
  
  public void a(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap, paramByte);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
    }
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null)
    {
      String str = RoamSettingController.a(paramString, 1);
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "setTroopMsgFilterToServer, path=" + str + " value=" + paramInteger);
      }
      localRoamSettingController.a(str, paramInteger);
      TroopAssistantManager.a().c(this, paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    boolean bool1 = h();
    boolean bool2 = NoDisturbUtil.a(this.app.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool2);
    }
    if ((!bool1) && (bool2))
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApp());
      Vibrator localVibrator = (Vibrator)getApp().getSystemService("vibrator");
      bool1 = c();
      bool2 = z();
      boolean bool3 = y();
      boolean bool4 = m();
      boolean bool5 = v();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool3 + ",isVideoing is:" + bool1 + ",isCallIdle is:" + bool4 + ",notRecordingPtt is:" + bool5);
      }
      if ((bool3) && (bool4) && (!bool1) && (bool5)) {
        localVibrator.vibrate(jdField_a_of_type_ArrayOfLong, -1);
      }
      if ((paramBoolean) && (bool2) && (!bool1) && (!k()) && (!l()) && (m()) && (v()))
      {
        int i1 = localSharedPreferences.getInt("sound_type" + getCurrentAccountUin(), 2131230721);
        if (b(paramString)) {
          i1 = 2131230758;
        }
        AudioUtil.b(i1, false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 0;
    if (paramBoolean)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      int i3 = arrayOfInt.length;
      i1 = i2;
      while (i1 < i3)
      {
        getManager(arrayOfInt[i1]);
        i1 += 1;
      }
    }
    while (i1 < 280)
    {
      if (i1 != 23) {
        getManager(i1);
      }
      i1 += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener.a(paramBoolean, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("QQAppInterface", 2, String.format(Locale.getDefault(), "refreshMsgTabUnreadNum mMsgTabUnreadListener is null, [%b, %d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((CardHandler)a(2)).a(paramBoolean1);
      return;
    }
    a().edit().putBoolean(getApp().getString(2131433588) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSigInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo = new SigInfo();
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey = new byte[paramArrayOfByte1.length];
      System.arraycopy(paramArrayOfByte1, 0, this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey, 0, paramArrayOfByte1.length);
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature = new byte[paramArrayOfByte2.length];
      System.arraycopy(paramArrayOfByte2, 0, this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature, 0, paramArrayOfByte2.length);
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.wSignatureLen = ((short)this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature.length);
    }
  }
  
  public void a(Integer[] paramArrayOfInteger)
  {
    a(paramArrayOfInteger, true);
  }
  
  public void a(Integer[] paramArrayOfInteger, boolean paramBoolean)
  {
    Object localObject2 = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", "0111100");
    if ((localObject2 == null) || (((String)localObject2).length() > "0111100".length()) || (paramArrayOfInteger == null) || (paramArrayOfInteger.length != 7)) {
      if (QLog.isColorLevel()) {
        QLog.e("QQAppInterface", 2, "writeCallTabStateVal valid val," + (String)localObject2 + "," + paramArrayOfInteger);
      }
    }
    Object localObject1;
    int i1;
    label157:
    do
    {
      return;
      localObject1 = localObject2;
      if (((String)localObject2).length() < "0111100".length()) {
        localObject1 = (String)localObject2 + "0111100".substring(((String)localObject2).length());
      }
      localObject1 = new StringBuilder((String)localObject1);
      i1 = 0;
      if (i1 < paramArrayOfInteger.length)
      {
        localObject2 = paramArrayOfInteger[i1];
        if (localObject2 == null) {}
        for (;;)
        {
          i1 += 1;
          break label157;
          if ((((Integer)localObject2).intValue() < 0) || (((Integer)localObject2).intValue() > 9))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("QQAppInterface", 2, "writeCallTabStateVal wrong index,," + localObject2);
            return;
          }
          ((StringBuilder)localObject1).setCharAt(i1, (char)(((Integer)localObject2).intValue() + 48));
        }
      }
      if (paramArrayOfInteger[0] != null)
      {
        this.jdField_g_of_type_Int = 0;
        this.n = false;
        if ((this.n) && ((a().jdField_a_of_type_Char == '2') || (a().jdField_a_of_type_Char == '3')))
        {
          localObject2 = new Integer[5];
          localObject2[0] = Integer.valueOf(1);
          localObject2[3] = Integer.valueOf(0);
          a().a((Integer[])localObject2, false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQAppInterface", 2, "uin:" + getCurrentAccountUin() + ",writeCallTabStateVal vals=" + paramArrayOfInteger + ",mIsCallTabShow=" + this.jdField_g_of_type_Int + ",isCallTabShow=" + this.n);
      }
      SettingCloneUtil.writeValue(getApplication(), getCurrentAccountUin(), null, "qqsetting_calltab_show_key", ((StringBuilder)localObject1).toString());
      localObject1 = a().a();
      i1 = ((String)localObject1).charAt(2);
    } while ((!paramBoolean) || (((String)localObject1).charAt(0) != '0') || (paramArrayOfInteger[0] == null) || ((i1 != 50) && (i1 != 51)));
    paramArrayOfInteger = new Integer[5];
    paramArrayOfInteger[0] = Integer.valueOf(1);
    a().a(paramArrayOfInteger, false);
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      String str = getApp().getString(2131436020);
      if (str != null) {
        bool = SettingCloneUtil.readValue(getApp(), null, str, "qqsetting_notify_icon_key", false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("MobileQQService", 2, "isOpenNoClearNotification" + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] != null;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    byte b1 = 3;
    if (paramInt1 == 101) {
      b1 = 1;
    }
    String str = a(paramInt1, paramString, b1, paramInt2, 100, false);
    if ((this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) && (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str) != null)) {}
    do
    {
      return true;
      paramString = new File(a(paramInt1, paramString, paramInt2));
    } while ((paramString.exists()) && (paramString.isFile()));
    return false;
  }
  
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    return a(paramMessage.frienduin, paramMessage.istroop);
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = a().m(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = b(paramString);
      if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "getAllGeneralSettings , needTroopSettings=" + paramBoolean);
      }
      localRoamSettingController.a(paramBoolean, null);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "getAllGeneralSettings roamSettingController is null ");
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1)
    {
      i1 = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (i1 + 1);
      if (i1 < 3) {}
    }
    do
    {
      return false;
      i1 = this.jdField_d_of_type_Int;
      this.jdField_d_of_type_Int = (i1 + 1);
    } while (i1 >= 3);
    ((CardHandler)a(2)).a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public byte[] a()
  {
    if ((getAccount() != null) && (isLogin()) && (this.jdField_a_of_type_ComTencentMobileqqDataSigInfo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey;
    }
    return null;
  }
  
  public String[] a(int paramInt)
  {
    return (String[])a(paramInt).get(Integer.valueOf(paramInt));
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] != null) {
      return;
    }
    this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] = paramManager;
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    addObserver(paramBusinessObserver, false);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (!this.jdField_b_of_type_JavaUtilList.contains(paramBusinessObserver)) {
          this.jdField_b_of_type_JavaUtilList.add(paramBusinessObserver);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
      }
      return;
    }
  }
  
  public int b()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.group.vibrate", 0);
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    localObject = a((List)localObject);
    if (localObject != null)
    {
      paramString = (Integer)((Map)localObject).get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return 1;
  }
  
  public Bitmap b(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.app.getResources(), 2130846076);
      if (localBitmap != null) {
        new Canvas(paramBitmap).drawBitmap(localBitmap, paramBitmap.getWidth() - localBitmap.getWidth() - 1, paramBitmap.getHeight() - localBitmap.getHeight() - 1, new Paint());
      }
      return paramBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        Object localObject1 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public Bitmap b(String paramString, int paramInt)
  {
    return a(16, paramString, true, paramInt);
  }
  
  @Deprecated
  public Drawable b(String paramString)
  {
    return a(paramString, false, (byte)3);
  }
  
  public SQLiteDatabase b()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.b();
    }
    return null;
  }
  
  public SQLiteDatabase b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.b();
    }
    return null;
  }
  
  public Setting b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache == null) {
      return null;
    }
    return (Setting)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
  }
  
  public String b()
  {
    String str = a();
    if (str != null) {
      try
      {
        str = HexUtil.a(str.getBytes("utf-8"));
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return null;
  }
  
  public String b(String paramString)
  {
    String str = getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString);
    if ((str == null) || (str.length() == 0)) {
      return paramString;
    }
    return str;
  }
  
  public void b()
  {
    int i3 = 0;
    int i6 = 0;
    I();
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, new Setting().getTableName(), false, null, null, null, null, "updateTimestamp desc", null);
    Object localObject1;
    int i2;
    int i1;
    int i5;
    if (localObject2 != null)
    {
      i3 = ((List)localObject2).size();
      if (i3 > 0)
      {
        localObject1 = new ArrayList();
        int i4 = 0;
        i2 = 0;
        i1 = 0;
        if (i4 < i3)
        {
          Setting localSetting = (Setting)((List)localObject2).get(i4);
          if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.uin)))
          {
            if (i1 >= 4000)
            {
              i5 = i2;
              i2 = i1;
              i1 = i5;
            }
            for (;;)
            {
              i5 = i4 + 1;
              i4 = i2;
              i2 = i1;
              i1 = i4;
              i4 = i5;
              break;
              localSetting.url = null;
              if (((localSetting.bSourceType == 1) || (localSetting.bUsrType == 32)) && (i2 <= 100))
              {
                ((List)localObject1).add(localSetting);
                i5 = i2 + 1;
                i2 = i1;
                i1 = i5;
              }
              else
              {
                this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localSetting.uin, localSetting);
                i5 = i1 + 1;
                i1 = i2;
                i2 = i5;
              }
            }
          }
        }
        else
        {
          i5 = Math.min(100, Math.min(4000 - i1, ((List)localObject1).size()));
          if (i5 > 0)
          {
            i4 = i6;
            if (i4 < i5)
            {
              localObject2 = (Setting)((List)localObject1).get(i4);
              if ((localObject2 == null) || (TextUtils.isEmpty(((Setting)localObject2).uin))) {}
              for (;;)
              {
                i4 += 1;
                break;
                this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(((Setting)localObject2).uin, localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("QQAppInterface", 1, "initFaceSettingCache," + i3 + "," + i1 + "," + i2);
      this.r = true;
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("com.tencent.qqhead.getheadreq");
      ((IntentFilter)localObject1).addAction("com.tencent.qqhead.refreshheadreq");
      getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
      return;
      i5 = i1;
      i1 = i2;
      i2 = i5;
      break;
      i2 = 0;
      i1 = 0;
      continue;
      i2 = 0;
      i1 = 0;
    }
  }
  
  public void b(int paramInt)
  {
    a(new zks(this, paramInt));
  }
  
  public void b(VibrateListener paramVibrateListener)
  {
    if (paramVibrateListener == null) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.remove(paramVibrateListener);
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    N();
    this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a(paramResourcePluginListener);
  }
  
  public void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool = NoDisturbUtil.a(this.app.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showInComingMsg ,isFinished=" + this.j + ", isCanDisturb=" + bool + ", needTicker=" + paramBoolean + ", message=" + paramMessageRecord);
    }
    if ((this.j) || (!bool)) {}
    QCallFacade localQCallFacade;
    do
    {
      return;
      localQCallFacade = (QCallFacade)getManager(37);
    } while (localQCallFacade == null);
    Object localObject4 = paramMessageRecord.senderuin;
    Object localObject1;
    if ((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008))
    {
      localObject1 = localQCallFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (localObject1 != null) {
        localObject4 = ((QCallRecent)localObject1).senderUin;
      }
    }
    label439:
    label590:
    label1492:
    for (;;)
    {
      int i1 = localQCallFacade.b();
      if (i1 == 0) {
        break;
      }
      Intent localIntent;
      if (i1 == 1) {
        if (((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008)) && (paramMessageRecord.istroop == 3000))
        {
          localIntent = a(getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
          localObject1 = (DiscussionHandler)a(6);
          if (localObject1 == null) {
            break label1770;
          }
        }
      }
      label471:
      label1757:
      label1770:
      for (localObject1 = ((DiscussionHandler)localObject1).a(paramMessageRecord.frienduin, true);; localObject1 = null)
      {
        Object localObject3 = ContactUtils.a(this, (String)localObject4, 0);
        bool = true;
        Object localObject5;
        Object localObject2;
        Object localObject6;
        int i2;
        for (;;)
        {
          localIntent.putExtra("key_notification_click_action", true);
          localObject5 = localIntent.getStringExtra("uinname");
          if (localObject5 != null)
          {
            localObject2 = localObject5;
            if (!"".equals(localObject5)) {}
          }
          else
          {
            localObject2 = localIntent.getStringExtra("uin");
          }
          if (localObject3 != null)
          {
            localObject5 = localObject3;
            if (!"".equals(localObject3)) {}
          }
          else
          {
            localObject5 = localObject4;
          }
          localObject5 = localQCallFacade.a((String)localObject5, bool);
          switch (paramMessageRecord.istroop)
          {
          default: 
            localObject6 = (String)localObject2 + ": ";
            localObject3 = localObject5;
            localObject4 = localObject1;
            localObject1 = localObject6;
            if (paramMessageRecord.istroop != 1008) {
              break label1492;
            }
            localObject6 = (String)localObject1 + (String)localObject3;
            if (!paramBoolean) {
              localObject6 = null;
            }
            i2 = localQCallFacade.a();
            localObject1 = localObject2;
            if (i2 > 1)
            {
              localObject1 = localObject2;
              if (i1 == 1)
              {
                if (i2 <= 100) {
                  break label1531;
                }
                localObject1 = (String)localObject2 + " (" + getApp().getString(2131435832) + ")";
              }
            }
            if ((paramBoolean) && (paramMessageRecord.istroop != 6000) && (paramMessageRecord.istroop != 1009) && (!paramMessageRecord.frienduin.equals(AppConstants.C))) {
              break label1581;
            }
            if ((paramMessageRecord.msgtype != -2016) && (paramMessageRecord.msgtype != -4008)) {
              break label1703;
            }
            if (QLog.isColorLevel()) {
              QLog.e("QQAppInterface", 2, "AVNotify:MSG_TYPE_MULTI_VIDEO");
            }
            if (paramMessageRecord.istroop == 3000)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QQAppInterface", 2, "AVNotify:UIN_TYPE_DISCUSSION");
              }
              localIntent.putExtra("qav_notify_flag", true);
            }
            a(localIntent, (String)localObject6, (String)localObject1, (String)localObject3, (Bitmap)localObject4, "CMD_SHOW_NOTIFIYCATION");
            return;
            if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004))
            {
              localIntent = new Intent(getApp(), SplashActivity.class);
              localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
              localIntent.putExtra("conversation_index", 1);
              localIntent.setFlags(335544320);
              localIntent.putExtra("uinname", a(paramMessageRecord.frienduin, (String)localObject4, paramMessageRecord.istroop, true));
            }
            for (;;)
            {
              if (!AppConstants.K.equals(paramMessageRecord.frienduin)) {
                break label834;
              }
              localObject1 = a((String)localObject4, true);
              bool = false;
              localObject3 = "";
              break;
              localIntent = a(getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
            }
            if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002) || (paramMessageRecord.istroop == 1010))
            {
              localObject1 = a(paramMessageRecord.frienduin, 200);
              bool = false;
              localObject3 = "";
            }
            else
            {
              localObject1 = a(paramMessageRecord.frienduin, true);
              bool = false;
              localObject3 = "";
            }
            break;
          }
        }
        if (((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008)) && (paramMessageRecord.istroop == 3000)) {}
        for (bool = true;; bool = false)
        {
          localIntent = new Intent(getApp(), SplashActivity.class);
          localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
          localIntent.putExtra("conversation_index", 1);
          localIntent.setFlags(335544320);
          localIntent.putExtra("uinname", getApp().getString(2131435828));
          localObject1 = null;
          localObject3 = "";
          break;
          localObject3 = ContactUtils.a(this, (String)localObject4, 0);
          localObject6 = (String)localObject3 + "(" + (String)localObject2 + "):";
          localObject3 = localObject5;
          localObject4 = localObject1;
          localObject1 = localObject6;
          break label439;
          localObject3 = localIntent.getStringExtra("subAccountLatestNick");
          localObject1 = localObject4;
          if (localObject3 != null) {
            if (((String)localObject3).length() != 0) {
              break label1757;
            }
          }
          for (localObject1 = localObject4;; localObject1 = localObject3)
          {
            localObject4 = (String)localObject2 + "-" + (String)localObject1 + ":" + (String)localObject5;
            localObject3 = (String)localObject1 + ":" + (String)localObject5;
            localObject1 = localObject4;
            localObject4 = null;
            break;
            localObject6 = (String)localObject2 + ": ";
            localObject3 = localObject5;
            localObject4 = localObject1;
            localObject1 = localObject6;
            break;
            if (i1 > 1)
            {
              localObject6 = (String)localObject2 + ": ";
              localObject3 = localObject5;
              localObject4 = localObject1;
              localObject1 = localObject6;
              break;
            }
            localObject3 = ContactUtils.q(this, paramMessageRecord.frienduin);
            localObject6 = (String)localObject3 + "(" + (String)localObject2 + "):";
            localObject3 = (String)localObject3 + ": " + (String)localObject5;
            localObject4 = localObject1;
            localObject1 = localObject6;
            break;
            localObject3 = SkinUtils.a(getApp().getResources().getDrawable(2130839203));
            localObject4 = XMLMessageUtils.a(paramMessageRecord);
            if ((localObject4 != null) && (!((PAMessage)localObject4).items.isEmpty()))
            {
              localObject1 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
              if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList != null))
              {
                localObject4 = (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
                localObject2 = localObject1;
                localObject1 = localObject4;
              }
              for (;;)
              {
                localObject4 = localObject3;
                localObject3 = localObject1;
                localObject1 = "";
                break;
              }
              localObject6 = localObject1;
              if (paramMessageRecord.istroop == 7000) {
                break label471;
              }
              localObject6 = (String)localObject1 + (String)localObject5;
              break label471;
              label1531:
              localObject1 = (String)localObject2 + " (" + i2 + getApp().getString(2131434664) + ")";
              break label553;
              if (!QQUtils.a(getApp())) {
                break label590;
              }
              localObject2 = (QQLSRecentManager)getManager(71);
              paramBoolean = SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131435404), "qqsetting_lock_screen_whenexit_key", true);
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, String.format("videochatting start lsActivity from appinterface  showInComingMsgForQAV, lockScreenMsgWhenExit[%s]", new Object[] { Boolean.valueOf(paramBoolean) }));
              }
              if (!paramBoolean) {
                break label590;
              }
              if (bool)
              {
                ((QQLSRecentManager)localObject2).a(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, true);
                break label590;
              }
              ((QQLSRecentManager)localObject2).a(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, false);
              break label590;
              if (paramMessageRecord.msgtype != -2009) {
                break label662;
              }
              if (QLog.isColorLevel()) {
                QLog.e("QQAppInterface", 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO");
              }
              localIntent.putExtra("qav_notify_flag", true);
              break label662;
            }
            localObject1 = "";
            localObject4 = localObject3;
            localObject3 = localObject5;
            break;
          }
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onWeakNet message: " + paramString);
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    label13:
    long l1;
    do
    {
      do
      {
        do
        {
          break label13;
          do
          {
            return;
          } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
          localObject = a(16, paramString, paramInt);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l1 = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l1 == paramLong);
      Object localObject = (FriendListHandler)a(1);
      if (localObject != null) {
        ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshQCallFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l1);
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("exit", 2, getCurrentAccountUin() + " qq start to exit ");
    }
    this.jdField_g_of_type_Boolean = true;
    M();
    StatisticHitRateCollector.a().d(getCurrentAccountUin());
    PreloadProcHitMgr.a();
    L();
    MobileQQ localMobileQQ;
    if (isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "kickPC get value in exit........... kickpc = false");
      }
      if (this.jdField_a_of_type_Boolean)
      {
        sendOnlineStatus(AppRuntime.Status.receiveofflinemsg, false, 0L);
        ((PushManager)getManager(5)).unregistProxyMessagePush(getAppid(), this.app.getPackageName() + ":video");
      }
    }
    else
    {
      if (GuardManager.a != null) {
        GuardManager.a.a();
      }
      if (!paramBoolean) {
        break label232;
      }
      localMobileQQ = getApplication();
      if (isLogin()) {
        break label227;
      }
      paramBoolean = true;
      label176:
      localMobileQQ.QQProcessExit(paramBoolean);
    }
    for (;;)
    {
      i();
      SharedPreferencesProxyManager.getInstance().trySave();
      HeavyTaskExecutor.a();
      GuardManager.b(true);
      return;
      if (paramBoolean)
      {
        sendOnlineStatus(AppRuntime.Status.offline, false, 0L);
        break;
      }
      sendOnlineStatus(AppRuntime.Status.offline, true, 0L);
      break;
      label227:
      paramBoolean = false;
      break label176;
      label232:
      localMobileQQ = getApplication();
      paramBoolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        paramBoolean = true;
      }
      localMobileQQ.QQProcessExit(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a().edit().putBoolean(getApp().getString(2131433586) + getCurrentAccountUin(), paramBoolean1).commit();
      return;
    }
    ((LBSHandler)a(3)).a(paramBoolean1);
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "kickPC get value........... kickpc = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public final boolean b(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((CardHandler)a(2)).c();
    }
    return a().getBoolean(getApp().getString(2131433588) + getCurrentAccountUin(), true);
  }
  
  public int c()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.ring.switch", 1);
    }
    return 1;
  }
  
  /* Error */
  public Setting c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1118	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   4: invokevirtual 4047	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_3
    //   11: ldc_w 1873
    //   14: aload_1
    //   15: invokevirtual 2921	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   18: checkcast 1873	com/tencent/mobileqq/data/Setting
    //   21: astore_1
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 4048	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   30: aload_1
    //   31: areturn
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 727	java/lang/Exception:printStackTrace	()V
    //   41: aload_3
    //   42: ifnull +30 -> 72
    //   45: aload_3
    //   46: invokevirtual 4048	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +7 -> 62
    //   58: aload_2
    //   59: invokevirtual 4048	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -11 -> 54
    //   68: astore_1
    //   69: goto -34 -> 35
    //   72: aconst_null
    //   73: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	QQAppInterface
    //   0	74	1	paramString	String
    //   9	50	2	localEntityManager1	EntityManager
    //   7	39	3	localEntityManager2	EntityManager
    // Exception table:
    //   from	to	target	type
    //   0	8	32	java/lang/Exception
    //   0	8	51	finally
    //   10	22	64	finally
    //   37	41	64	finally
    //   10	22	68	java/lang/Exception
  }
  
  public String c()
  {
    String str = "";
    if (!"0".equals(getCurrentAccountUin())) {
      str = getCurrentAccountUin();
    }
    return str;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onMessageConnect...");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator == null) || (!e())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache != null) {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
    }
    d();
    a().a();
    a().a();
    a().b();
    for (;;)
    {
      Object localObject4;
      HashMap localHashMap;
      try
      {
        Object localObject2 = d();
        Object localObject3 = BaseApplication.getContext().getSharedPreferences("pull_msf" + (String)localObject2, 0);
        String str = ((SharedPreferences)localObject3).getString("uin", " ");
        localObject4 = ((SharedPreferences)localObject3).getString("time", "0");
        boolean bool1 = ((SharedPreferences)localObject3).getBoolean("proxy", false);
        boolean bool2 = ((SharedPreferences)localObject3).getBoolean("vivo", false);
        int i1 = ((SharedPreferences)localObject3).getInt("param_FailCode", 0);
        boolean bool3 = ((SharedPreferences)localObject3).getBoolean("mainProcess", false);
        Object localObject1 = ((SharedPreferences)localObject3).getString("sdkver", " ");
        if ((!str.equals(" ")) && (!((String)localObject4).equals("0")))
        {
          if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L)) {
            RegisterProxy.jdField_d_of_type_Int |= 0x4;
          }
          localHashMap = new HashMap();
          localHashMap.put("uin", str);
          localHashMap.put("time", localObject4);
          localHashMap.put("process", ((SharedPreferences)localObject3).getString("process", ""));
          localHashMap.put("availMem", ((SharedPreferences)localObject3).getString("availMem", ""));
          localHashMap.put("lowMem", ((SharedPreferences)localObject3).getString("lowMem", ""));
          localHashMap.put("state", ((SharedPreferences)localObject3).getString("state", ""));
          localHashMap.put("version", "150806");
          localHashMap.put("build", "3560");
          localHashMap.put("proxy", String.valueOf(bool1));
          localHashMap.put("vivo", String.valueOf(bool2));
          localHashMap.put("param_FailCode", String.valueOf(i1));
          localHashMap.put("mainProcess", String.valueOf(bool3));
          localHashMap.put("sdkver", String.valueOf(localObject1));
          if (Build.VERSION.SDK_INT >= 21)
          {
            StatisticCollector.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "pullMsfReport_V3", false, 0L, 0L, localHashMap, "");
            localObject3 = ((SharedPreferences)localObject3).edit();
            ((SharedPreferences.Editor)localObject3).clear();
            ((SharedPreferences.Editor)localObject3).commit();
          }
        }
        else
        {
          localObject2 = BaseApplication.getContext().getSharedPreferences("pull_msf_succ" + (String)localObject2, 0);
          localObject3 = ((SharedPreferences)localObject2).getString("uin", " ");
          str = ((SharedPreferences)localObject2).getString("time", "0");
          if ((((String)localObject3).equals(" ")) || (str.equals("0"))) {
            break;
          }
          if ((a(this)) && (BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L)) {
            RegisterProxy.jdField_d_of_type_Int |= 0x2;
          }
          localObject4 = new HashMap();
          ((HashMap)localObject4).put("uin", localObject3);
          ((HashMap)localObject4).put("time", str);
          ((HashMap)localObject4).put("process", ((SharedPreferences)localObject2).getString("process", ""));
          ((HashMap)localObject4).put("availMem", ((SharedPreferences)localObject2).getString("availMem", ""));
          ((HashMap)localObject4).put("lowMem", ((SharedPreferences)localObject2).getString("lowMem", ""));
          ((HashMap)localObject4).put("state", ((SharedPreferences)localObject2).getString("state", ""));
          ((HashMap)localObject4).put("version", "150806");
          ((HashMap)localObject4).put("build", "3560");
          ((HashMap)localObject4).put("proxy", String.valueOf(bool1));
          ((HashMap)localObject4).put("vivo", String.valueOf(bool2));
          ((HashMap)localObject4).put("param_FailCode", String.valueOf(i1));
          ((HashMap)localObject4).put("mainProcess", String.valueOf(bool3));
          ((HashMap)localObject4).put("sdkver", String.valueOf(localObject1));
          if (Build.VERSION.SDK_INT < 21) {
            break label937;
          }
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "pullMsfReport_succ_V2", false, 0L, 0L, (HashMap)localObject4, "");
          localObject1 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject1).clear();
          ((SharedPreferences.Editor)localObject1).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("QQAppInterface", 1, "Failed to report pull Msf Event");
        return;
      }
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "pullMsfReportOther_V3", false, 0L, 0L, localHashMap, "");
      continue;
      label937:
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "pullMsfReport_succOther_V2", false, 0L, 0L, (HashMap)localObject4, "");
    }
  }
  
  public void c(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.group.ring", Integer.valueOf(paramInt));
    }
  }
  
  public void c(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.b(paramResourcePluginListener);
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "checkIfNeedSignonNet onNetNeedSignon() called url:" + paramString);
    }
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramString;
      localMessage.arg1 = 2;
      localMessage.what = 1134024;
      localMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).c(paramBoolean1);
      return;
    }
    a().edit().putBoolean(getApp().getString(2131437351) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public boolean c()
  {
    if (a().a().jdField_b_of_type_Int != -1)
    {
      AVLog.c("QQAppInterface", "VideoProcessAlive mPstnStatus != PstnUtils.PSTN_C2C_NONE");
      return true;
    }
    if (AVNotifyCenter.c())
    {
      AVLog.c("QQAppInterface", "VideoProcessAlive isBeInvitingOnDoubleVideo");
      return true;
    }
    if ((!a().d()) && (a().b() == 0)) {
      return false;
    }
    if (QQServiceForAV.a())
    {
      AVLog.c("QQAppInterface", "VideoProcessAlive");
      return true;
    }
    Object localObject = ((ActivityManager)getApp().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:video"))
        {
          AVLog.c("QQAppInterface", "VideoProcessAlive VIDEO_PROCESS_NAME");
          return true;
        }
      }
    }
    return false;
  }
  
  public final boolean c(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).f();
    }
    return a().getBoolean(getApp().getString(2131437351) + getCurrentAccountUin(), true);
  }
  
  public int d()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.vibrate.switch", 1);
    }
    return 1;
  }
  
  public void d()
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
  
  public void d(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.group.vibrate", Integer.valueOf(paramInt));
    }
  }
  
  public void d(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig != null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.b(paramResourcePluginListener);
    }
  }
  
  public void d(String paramString)
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.d(paramString);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    String str = String.format(Locale.getDefault(), "may_know_in_contact_tab_%s", new Object[] { getCurrentAccountUin() });
    a().edit().putBoolean(str, paramBoolean).commit();
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_c_of_type_Int = 1;
    }
    for (;;)
    {
      ((CardHandler)a(2)).a(paramBoolean1, paramBoolean2);
      return;
      this.jdField_d_of_type_Int = 1;
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (c()))
    {
      Bundle localBundle = ((QQServiceForAV)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(1, 0, null);
      if (localBundle != null)
      {
        boolean bool = localBundle.getBoolean("AV_isUsingCamera", false);
        AVLog.c("QQAppInterface", "isUsingCameraOnVideo: " + bool);
        return bool;
      }
    }
    return false;
  }
  
  public boolean d(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).a(getCurrentAccountUin(), 1);
    }
    return a().getBoolean(getApp().getString(2131437756) + getCurrentAccountUin(), false);
  }
  
  public int e()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("sync.c2c_message", 1);
    }
    return 1;
  }
  
  public void e() {}
  
  public void e(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.ring.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    FriendListHandler localFriendListHandler;
    do
    {
      return;
      localFriendListHandler = (FriendListHandler)a(1);
    } while (localFriendListHandler == null);
    if (paramString.startsWith("+"))
    {
      localFriendListHandler.e(paramString);
      return;
    }
    localFriendListHandler.c(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putBoolean(BaseApplication.getContext().getString(2131433536) + getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).a(paramBoolean1, getCurrentAccountUin(), 1);
      return;
    }
    a().edit().putBoolean(getApp().getString(2131437756) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public boolean e()
  {
    return (getAccount() != null) && (isLogin());
  }
  
  public boolean e(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).a(getCurrentAccountUin(), 2);
    }
    return a().getBoolean(getApp().getString(2131437757) + getCurrentAccountUin(), false);
  }
  
  public int f()
  {
    int i1 = 0;
    int i2 = 0;
    QQMessageFacade localQQMessageFacade = a();
    if (localQQMessageFacade != null)
    {
      QCallFacade localQCallFacade = a();
      i1 = i2;
      if (localQCallFacade != null)
      {
        i1 = i2;
        if (!a().i())
        {
          i2 = localQCallFacade.a();
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("QQAppInterface", 2, "callUnread: " + i2);
            i1 = i2;
          }
        }
      }
      i2 = localQQMessageFacade.b();
      i1 = ((NewFriendManager)getManager(33)).d() + (i2 + i1) + CardUtil.a(this);
    }
    return i1;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onConnClose");
    }
    this.jdField_e_of_type_Boolean = false;
    LoadingStateManager.a().a(1);
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void f(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.vibrate.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).a(paramBoolean1, getCurrentAccountUin(), 2);
      return;
    }
    a().edit().putBoolean(getApp().getString(2131437757) + getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public boolean f()
  {
    return SettingCloneUtil.readValue(getApp(), getCurrentAccountUin(), getApp().getString(2131434202), "qqsetting_notify_showcontent_key", true);
  }
  
  public boolean f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() isFromPush=" + paramBoolean);
    }
    Object localObject1 = null;
    Object localObject2 = (SubAccountManager)getManager(60);
    if (localObject2 != null) {
      localObject1 = ((SubAccountManager)localObject2).a();
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
          bool1 = true;
          SubAccountControll.a(this, (String)localObject2, paramBoolean);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() continue, subUin=" + (String)localObject2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() listSubUin==null");
    }
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() result=" + bool2 + " forground=" + BaseActivity.mAppForground);
    }
    localObject1 = (SubAccountControll)getManager(61);
    if (localObject1 != null)
    {
      if (!bool2) {
        break label258;
      }
      if (BaseActivity.mAppForground) {
        ((SubAccountControll)localObject1).b(this);
      }
    }
    return bool2;
    label258:
    ((SubAccountControll)localObject1).c(this);
    return bool2;
  }
  
  protected void finalize()
  {
    super.finalize();
    QQEntityManagerFactory localQQEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    if (localQQEntityManagerFactory != null) {
      localQQEntityManagerFactory.close();
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRecvFistResp");
    }
    this.jdField_e_of_type_Boolean = true;
    MqqHandler localMqqHandler = getHandler(Conversation.class);
    if (!LoadingStateManager.a().c())
    {
      LoadingStateManager.a().a(2);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(1134012, null).sendToTarget();
      }
    }
    for (;;)
    {
      if (localMqqHandler != null)
      {
        Message localMessage = Message.obtain();
        localMessage.arg1 = 0;
        localMessage.what = 1134024;
        localMqqHandler.sendMessage(localMessage);
      }
      return;
      if ((LoadingStateManager.a().a()) && (localMqqHandler != null)) {
        localMqqHandler.obtainMessage(1134015, null).sendToTarget();
      }
    }
  }
  
  public void g(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("sync.c2c_message", Integer.valueOf(paramInt));
    }
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean g()
  {
    if (z())
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
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.jdField_a_of_type_Int;
  }
  
  public List getBusinessObserver(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (paramInt == 2) {
      return this.jdField_b_of_type_JavaUtilList;
    }
    if (paramInt == 0) {
      return this.jdField_c_of_type_JavaUtilList;
    }
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getCurrentNickname()
  {
    return ContactUtils.l(this, getCurrentAccountUin());
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    String str = getAccount();
    if (str == null) {
      throw new IllegalStateException("WTF");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory = new QQEntityManagerFactory(str);
        ThreadManager.getSubThreadHandler().postDelayed(new zlf(this), 3000L);
      }
      return this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
    }
    finally {}
  }
  
  @Deprecated
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (!paramString.equals(getAccount())) {
      throw new IllegalStateException(paramString + "!=" + getAccount());
    }
    return getEntityManagerFactory();
  }
  
  public Manager getManager(int paramInt)
  {
    ??? = this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt];
    ??? = ???;
    if (??? == null)
    {
      if (this.jdField_a_of_type_ArrayOfJavaLangObject[(this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)] == null) {}
      synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
      {
        if (this.jdField_a_of_type_ArrayOfJavaLangObject[(this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)] == null)
        {
          int i1 = 0;
          while (i1 < this.jdField_a_of_type_ArrayOfJavaLangObject.length)
          {
            this.jdField_a_of_type_ArrayOfJavaLangObject[i1] = new Object();
            i1 += 1;
          }
        }
        if (!AppSetting.jdField_a_of_type_Boolean) {}
      }
    }
    for (;;)
    {
      Manager localManager;
      Manager[] arrayOfManager;
      synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject[paramInt])
      {
        localManager = this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt];
        if ((localManager != null) || ((getAccount() == null) && (paramInt > 7) && (paramInt != 26)))
        {
          ??? = localManager;
          return ???;
          localObject5 = finally;
          throw localObject5;
          arrayOfManager = this.jdField_a_of_type_ArrayOfMqqManagerManager;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label3252;
        }
        QLog.d("QQAppInterface", 2, "getManager begin" + paramInt);
        break label3252;
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface", 2, "getManager end" + paramInt);
        }
        if (??? != null) {
          addManager(paramInt, (Manager)???);
        }
        return ???;
        ??? = new AccountManagerImpl(this);
      }
      Object localObject3 = new WtloginManagerImpl(this);
      continue;
      localObject3 = new TicketManagerImpl(this);
      continue;
      localObject3 = new ProxyIpManagerImpl(this);
      continue;
      localObject3 = new QZoneManagerImp(this);
      continue;
      localObject3 = new PhoneContactManagerImp(this);
      continue;
      localObject3 = new GameCenterManagerImp(this);
      continue;
      localObject3 = new WebProcessManager(this);
      continue;
      localObject3 = new EmoticonManager(this);
      continue;
      localObject3 = StatusManager.a(this);
      continue;
      localObject3 = new ShieldMsgManger(this);
      continue;
      localObject3 = new SttManager(this);
      continue;
      localObject3 = new ProxyManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)localObject3);
      continue;
      localObject3 = new CacheManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager = ((CacheManager)localObject3);
      continue;
      localObject3 = new QQMessageFacade(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)localObject3);
      continue;
      localObject3 = new NetEngineFactory();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)localObject3);
      continue;
      localObject3 = new RecommendTroopManagerImp(this);
      continue;
      localObject3 = new FileTransferManager(this);
      continue;
      localObject3 = new MediaPlayerManager(this);
      continue;
      localObject3 = IPluginManager.a(this);
      continue;
      localObject3 = new SubAccountProtocManager(this);
      continue;
      localObject3 = new ConversationFacade(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = ((ConversationFacade)localObject3);
      continue;
      localObject3 = new RoamSettingController(this);
      continue;
      localObject3 = new TroopCreateLogic(this);
      continue;
      localObject3 = new RecentManagerFor3rdPart(this);
      continue;
      localObject3 = new NewFriendManager(this);
      continue;
      localObject3 = new RedTouchManager(this);
      continue;
      localObject3 = new TroopInfoManager(this);
      continue;
      localObject3 = new QCallFacade(this);
      continue;
      localObject3 = new PicPreDownloader(this);
      continue;
      localObject3 = new RoamSettingManager(this);
      continue;
      localObject3 = new ContactSyncManager(this);
      continue;
      localObject3 = new FontManager(this);
      continue;
      localObject3 = new EmojiManager(this);
      continue;
      localObject3 = new BubbleManager(this);
      continue;
      localObject3 = new ColorRingManager(this);
      continue;
      localObject3 = new AvatarPendantManager(this);
      continue;
      localObject3 = new DownloaderFactory(this);
      continue;
      localObject3 = new TroopGagMgr(this);
      continue;
      localObject3 = new MyBusinessManager(this);
      continue;
      localObject3 = new FriendsManager(this);
      continue;
      localObject3 = new TroopManager(this);
      continue;
      localObject3 = new DiscussionManager(this);
      continue;
      localObject3 = new ContactFacade(this);
      continue;
      localObject3 = new SearchHistoryManager(this);
      continue;
      localObject3 = new PublicAccountDataManager(this);
      continue;
      localObject3 = new AccountDetailDynamicDataManager(this);
      continue;
      localObject3 = new SignatureManager(this);
      continue;
      localObject3 = new ConditionSearchManager(this);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = new HotChatManager(this);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
      continue;
      localObject3 = new SubAccountManager(this);
      continue;
      localObject3 = new SubAccountControll(this);
      continue;
      localObject3 = new ChatBackgroundManager(this);
      continue;
      localObject3 = new NumRedPointManager(this);
      continue;
      localObject3 = new NumRedMsgManager(this);
      continue;
      localObject3 = new LbsInfoMgr(this);
      continue;
      localObject3 = new ShortVideoTransManager(this);
      continue;
      localObject3 = new DeviceProfileManager.AccountDpcManager(this);
      continue;
      localObject3 = new EqqDetailDataManager(this);
      continue;
      localObject3 = new TroopRedTouchManager(this);
      continue;
      localObject3 = new DatingProxyManager(this);
      continue;
      localObject3 = new QQLSRecentManager(this);
      continue;
      localObject3 = new PicStatisticsManager(this);
      continue;
      localObject3 = new NearbyBannerManager(this);
      continue;
      localObject3 = new VipGiftManager(this);
      continue;
      localObject3 = new EarlyDownloadManager(this);
      continue;
      localObject3 = new QQWiFiMainManager(this);
      continue;
      localObject3 = new PortalManager(this);
      continue;
      localObject3 = new OlympicManager(this);
      continue;
      localObject3 = new ArResourceManager(this);
      continue;
      localObject3 = new AddContactTroopManage(this);
      continue;
      localObject3 = new TroopTipsMsgMgr(this);
      continue;
      localObject3 = new WordMatchManager(this);
      continue;
      localObject3 = new PngFrameManager(this);
      continue;
      localObject3 = new VipFunCallManager(this);
      continue;
      localObject3 = new ActivateFriendsManager(this);
      continue;
      localObject3 = new LightalkSwitchManager(this);
      continue;
      localObject3 = new EcShopAssistantManager(this);
      continue;
      localObject3 = new PttConfigController(this);
      continue;
      localObject3 = new VipImageUploadManager(this);
      continue;
      localObject3 = new QzoneContactsFeedManager(this);
      continue;
      localObject3 = new MessageRoamManager(this);
      continue;
      localObject3 = new NearbyGrayTipsManager(this);
      continue;
      localObject3 = new SecSpyFileManager(this);
      continue;
      localObject3 = new ShortVideoPreDownloaderWithSdkSupport(this);
      continue;
      localObject3 = new ReadInJoyManager(this);
      continue;
      localObject3 = new TroopTopicMgr(this);
      continue;
      localObject3 = new PAReportManager(this);
      continue;
      localObject3 = new PhoneUnityManager(this);
      continue;
      localObject3 = new FavroamingManager(this);
      continue;
      localObject3 = new FullMessageSearchManager(this);
      continue;
      localObject3 = new QzoneAlbumRedTouchManager(this);
      continue;
      localObject3 = new TroopAppMgr(this);
      continue;
      localObject3 = new TroopAioADManager(this);
      continue;
      localObject3 = new CommonUsedSystemEmojiManager(this);
      continue;
      localObject3 = new NearbyCardManager(this);
      continue;
      localObject3 = new ODProxy(this);
      continue;
      localObject3 = new TroopGiftManager(this);
      continue;
      localObject3 = new DingdongPluginManager(this);
      continue;
      localObject3 = new WeatherManager(this);
      continue;
      localObject3 = new NearbyProxy(this);
      continue;
      localObject3 = new PatchDownloadManager(this);
      continue;
      localObject3 = new TroopPluginManager(this);
      continue;
      localObject3 = new PttPreSendManager(this);
      continue;
      localObject3 = new PTTPreDownloader(this);
      continue;
      localObject3 = new ArkAppCenter(this);
      continue;
      localObject3 = new PasswdRedBagManager(this);
      continue;
      localObject3 = new HotchatSCMng(this);
      continue;
      localObject3 = new BusinessCardManager(this);
      continue;
      localObject3 = new FTSDBManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager = ((FTSDBManager)localObject3);
      continue;
      localObject3 = new QRProcessManager(this);
      continue;
      localObject3 = new NearbyFlowerManager(this);
      continue;
      localObject3 = new ScribbleDownloader(this);
      continue;
      localObject3 = new IndividualRedPacketManager(this);
      continue;
      localObject3 = new TroopBindPublicAccountMgr(this);
      continue;
      localObject3 = new BlessManager(this);
      continue;
      localObject3 = new DAUStatistic(this);
      continue;
      localObject3 = new PublicQuickPayManager(this);
      continue;
      localObject3 = new LbsInfoReportManager(this);
      continue;
      localObject3 = new ApolloManager(this);
      continue;
      localObject3 = new ApolloRecentManager(this);
      continue;
      localObject3 = new ApolloDaoManager(this);
      continue;
      localObject3 = new LightalkShieldManager(this);
      continue;
      localObject3 = new QCallCardManager(this);
      continue;
      localObject3 = new VipComicMqqManager(this);
      continue;
      localObject3 = new QQComicPreloadManager(this);
      continue;
      localObject3 = new TroopRewardMgr(this);
      continue;
      localObject3 = new FavroamingDBManager(this);
      continue;
      localObject3 = new EmoticonFromGroupDBManager(this);
      continue;
      localObject3 = new PstnManager(this);
      continue;
      localObject3 = new PullActiveManager(this);
      continue;
      localObject3 = new LoginWelcomeManager(this);
      continue;
      localObject3 = new NearByGeneralManager(this);
      continue;
      localObject3 = new VipComicEmoticonUploadManager(this);
      continue;
      localObject3 = new URLInterceptManager(this);
      continue;
      localObject3 = new VACDReportMgr();
      continue;
      localObject3 = new PreloadManager(this);
      continue;
      localObject3 = new GamePartyManager(this);
      continue;
      localObject3 = new ReadInJoyDAUStatistic(this);
      continue;
      localObject3 = new MayknowRecommendManager(this);
      continue;
      localObject3 = new LocalRedTouchManager(this);
      continue;
      localObject3 = new WeishiManager(this);
      continue;
      localObject3 = new KandianMergeManager(this);
      continue;
      localObject3 = new ReadInJoyLogicManager(this);
      continue;
      localObject3 = new TroopVideoManager(this);
      continue;
      localObject3 = new SchoolTroopKeywordManager(this);
      continue;
      localObject3 = new LongTextMsgManager(this);
      continue;
      localObject3 = new QidianManager(this);
      continue;
      localObject3 = new NowLiveManager(this);
      continue;
      localObject3 = new PhotoPlusManager(this);
      continue;
      localObject3 = new FaceManager(this);
      continue;
      localObject3 = new MixedMsgManager(this);
      continue;
      localObject3 = new QZonePluginManager(this);
      continue;
      localObject3 = new VoiceChangeManager(this);
      continue;
      localObject3 = new IndividuationABTestManager(this);
      continue;
      localObject3 = new DynamicAvatarManager(this);
      continue;
      localObject3 = new QQStoryManager(this);
      continue;
      localObject3 = new NowProxy(this);
      continue;
      localObject3 = new ChangeMachineManager(this);
      continue;
      localObject3 = new FunctionModuleConfigManager(this);
      continue;
      localObject3 = new PrecoverManager(this);
      continue;
      localObject3 = new VasQuickUpdateManager(this);
      continue;
      localObject3 = new ThemeSwitchManager(this);
      continue;
      localObject3 = new LikeRankingListManager(this);
      continue;
      localObject3 = new QPUpdateManager(this);
      continue;
      localObject3 = new ArtFilterManager(this);
      continue;
      localObject3 = new ApolloNativeSSOReqMgr(this);
      continue;
      localObject3 = new ARMapConfigManager(this);
      continue;
      localObject3 = new ResDownloadManager(this);
      continue;
      localObject3 = new SonicTemplateUpdateManager(this);
      continue;
      localObject3 = new PreDownloadController(this);
      continue;
      localObject3 = new MsgBoxInterFollowManager(this);
      continue;
      localObject3 = new ARGlobalConfigManager(this);
      continue;
      localObject3 = new CommercialDrainageManager(this);
      continue;
      localObject3 = new NowManager(this);
      continue;
      localObject3 = new ClassicHeadActivityManager(this);
      continue;
      localObject3 = new QSlowTableManager(this);
      continue;
      localObject3 = new TroopRobotManager(this);
      continue;
      localObject3 = new NearbyFaceScoreManager(this);
      continue;
      localObject3 = new DBFixManager(this);
      continue;
      localObject3 = new HotPicManager(this);
      continue;
      localObject3 = new FlashChatManager(this);
      continue;
      localObject3 = new NearbyLikeLimitManager(this);
      continue;
      localObject3 = new PraiseManager(this);
      continue;
      localObject3 = new TroopStoryManager(this);
      continue;
      localObject3 = new LebaGridManager(this);
      continue;
      localObject3 = new ApolloGameManager(this);
      continue;
      localObject3 = new QQComicRedTouchManager(this);
      continue;
      localObject3 = new DoutuManager(this);
      continue;
      localObject3 = new PhotoListConfigManager();
      continue;
      localObject3 = new NearbyVideoChatManager(this);
      continue;
      localObject3 = new HiBoomManager(this);
      continue;
      localObject3 = new CampusCircleManager(this);
      continue;
      localObject3 = new AppGuideTipsManager(this);
      continue;
      localObject3 = new CUOpenCardGuideMng(this);
      continue;
      localObject3 = new AIOAnimationControlManager(this);
      continue;
      localObject3 = new TroopAioKeywordTipManager(this);
      continue;
      localObject3 = new VideoUploadManager(this);
      continue;
      localObject3 = new ApolloPushManager(this);
      continue;
      localObject3 = new OCRManager(this);
      continue;
      localObject3 = new ShortVideoResourceManager(this);
      continue;
      localObject3 = new PLUploadManager(this);
      continue;
      localObject3 = new TroopEnterEffectManager(this);
      continue;
      localObject3 = new VasExtensionManager(this);
      continue;
      localObject3 = new ApolloResponseManager(this);
      continue;
      localObject3 = new PreDownloadScheduler(this);
      continue;
      localObject3 = new TroopOnlineMemberManager(this);
      continue;
      localObject3 = new GroupVideoManager(this);
      continue;
      localObject3 = new PublicAccountEntityHelper(this);
      continue;
      localObject3 = new AdvertisementVideoPreloadManager(this);
      continue;
      localObject3 = new ImaxAdVideoPreloadManager(this);
      continue;
      localObject3 = new SearchWebHistoryManager(this);
      continue;
      localObject3 = new CampusNoticeManager(this);
      continue;
      localObject3 = new UsingTimeReportManager(this);
      continue;
      localObject3 = new TimJumpLoginManager(this);
      continue;
      localObject3 = new SpriteScriptManager(this);
      continue;
      localObject3 = new QrMainProcManager(this);
      continue;
      localObject3 = new WerewolvesDataManager(this);
      continue;
      localObject3 = new AVRedPacketConfigManager(this);
      continue;
      localObject3 = new WorldCupMgr(this);
      continue;
      localObject3 = new BusinessCommonConfig(this);
      continue;
      localObject3 = new TimUpgradeHongdianManager(this);
      continue;
      localObject3 = new QWalletConfigManager(this);
      continue;
      localObject3 = new NativeAdPreloadManager(this);
      continue;
      localObject3 = new MedalWallMng(this);
      continue;
      localObject3 = new MsgTabStoryManager(this);
      continue;
      localObject3 = new MsgTabStoryNodeConfigManager(this);
      continue;
      localObject3 = new HotChatCenterManager(this);
      continue;
      localObject3 = new QQStoryFeedManager(this);
      continue;
      localObject3 = new StoryHaloManager(this);
      continue;
      localObject3 = new QIMNewFriendManager(this);
      continue;
      localObject3 = new SportManager(this);
      continue;
      localObject3 = new UpgradeTIMManager(this);
      continue;
      localObject3 = new ZhituManager(this);
      continue;
      localObject3 = new ReadInJoySkinManager(this);
      continue;
      localObject3 = new NearbyMomentManager(this);
      continue;
      localObject3 = new NowEnterManager(this);
      continue;
      localObject3 = new NowHongbaoPushManager(this);
      continue;
      localObject3 = new NowDownloadEngineManager(this);
      continue;
      localObject3 = new ConfessManager(this);
      continue;
      localObject3 = new ReadInJoyRefreshManager(this);
      continue;
      localObject3 = new ReadInJoyOperationManager(this);
      continue;
      localObject3 = new AIOMessageSpreadManager(this);
      continue;
      localObject3 = new ExtendFriendManager(this);
      continue;
      localObject3 = new QWalletRedManager(this);
      continue;
      localObject3 = new LoveLanguageManager(this);
      continue;
      localObject3 = new LebaFeedsManager(this);
      continue;
      localObject3 = new LebaConfigManager(this);
      continue;
      label3252:
      localObject3 = localManager;
      switch (paramInt)
      {
      }
      localObject3 = localManager;
    }
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush", "MessageSvc.PushGroupMsg", "MessageSvc.PushForceOffline", "MessageSvc.PushNotify", "MessageSvc.PushForceOffline", "MessageSvc.RequestPushStatus", "RegPrxySvc.PullDisGroupSeq", "MessageSvc.RequestBatchPushFStatus", "MessageSvc.PushFStatus", "AccostSvc.SvrMsg", "ADMsgSvc.PushMsg", "StreamSvr.PushStreamMsg", "friendlist.getOnlineFriend", "MessageSvc.WNSQzone", "RegPrxySvc.PbGetMsg", "RegPrxySvc.getOffMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.NoticeEnd", "RegPrxySvc.PbSyncMsg", "account.ResponseNotifyForRecommendUpdate", "MessageSvc.PushReaded", "RegPrxySvc.infoLogin", "baseSdk.Msf.NotifyResp", "RegPrxySvc.PushParam", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "OnlinePush.PbPushC2CMsg", "cmd_connAllFailed", "cmd_recvFirstResp", "MultiVideo.s2c", "MultiVideo.c2sack", "NearFieldTranFileSvr.NotifyList", "ProfileService.CheckUpdateReq", "NearFieldDiscussSvr.NotifyList", "RegPrxySvc.QueryIpwdStat", "StatSvc.SvcReqMSFLoginNotify", "SharpSvr.s2cpstncallback", "ConfigPushSvc.PushDomain" };
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { TempServlet.class, CliNotifyPush.class, ContactBindServlet.class };
  }
  
  public INetEngine getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)getManager(20));
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  public void h()
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
  
  public void h(boolean paramBoolean1, boolean paramBoolean2)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.b(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean h()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    if (localAudioManager != null) {}
    for (;;)
    {
      try
      {
        i1 = localAudioManager.getRingerMode();
        if (i1 == 0) {
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        i1 = 2;
        continue;
      }
      return false;
      int i1 = 2;
    }
  }
  
  public void i()
  {
    ThreadManager.post(new zli(this), 10, null, true);
    try
    {
      sendToService(new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "CMD_STOP_NOTIFIYCATION"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean i()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 2);
  }
  
  public void j()
  {
    try
    {
      QNotificationManager localQNotificationManager = new QNotificationManager(this.app);
      localQNotificationManager.cancel("QQAppInterface_cancelNotification", 121);
      localQNotificationManager.cancel("QQAppInterface_cancelNotification", 119);
      label30:
      a(getApp());
      return;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
  
  public boolean j()
  {
    String str = Build.MANUFACTURER + Build.MODEL;
    if ((!TextUtils.isEmpty(str)) && (str.toLowerCase().contains("xiaomi"))) {
      if (Settings.System.getInt(getApp().getContentResolver(), "vibrate_in_normal", -1) != 1) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (Build.VERSION.SDK_INT >= 11) {
            break;
          }
        } while (Settings.System.getInt(getApp().getContentResolver(), "vibrate_on", -1) > 4);
        return false;
        if (Build.VERSION.SDK_INT >= 16) {
          break;
        }
      } while (Settings.System.getInt(getApp().getContentResolver(), "vibrate_on", -1) == 5);
      return false;
    } while (Settings.System.getInt(getApp().getContentResolver(), "vibrate_when_ringing", -1) == 1);
    return false;
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentAvAppAvAddFriendService != null)
    {
      this.jdField_a_of_type_ComTencentAvAppAvAddFriendService.a();
      this.jdField_a_of_type_ComTencentAvAppAvAddFriendService = null;
    }
  }
  
  public boolean k()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
      if (localAudioManager != null)
      {
        int i1 = localAudioManager.getRingerMode();
        if (i1 == 1) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("QQAppInterface", 1, "isRingerVibrate error: " + localThrowable.getMessage());
    }
    return false;
  }
  
  public void l()
  {
    AppRuntime.Status localStatus;
    if (isLogin()) {
      switch ((int)a())
      {
      default: 
        localStatus = AppRuntime.Status.offline;
      }
    }
    for (;;)
    {
      ((PushManager)getManager(5)).registProxyMessagePush(getAppid(), this.app.getPackageName() + ":video", "com.tencent.av.ui.VChatActivity", new String[] { "VideoSvc.Send", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c" });
      ((PushManager)getManager(5)).registProxyMessagePush(getAppid(), this.app.getPackageName() + ":nearby_video", "", new String[] { "VideoSvc.Send", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c" });
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "kickPC get value in sendRegisterPush........... kickpc = " + b());
      }
      sendOnlineStatus(localStatus, b(), this.app.getSharedPreferences(getAccount(), 0).getInt("GetFrdListReq_seq", 0));
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      return;
      localStatus = AppRuntime.Status.online;
      continue;
      localStatus = AppRuntime.Status.away;
      continue;
      localStatus = AppRuntime.Status.invisiable;
    }
  }
  
  public boolean l()
  {
    AudioManager localAudioManager = (AudioManager)getApp().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public void logout(boolean paramBoolean)
  {
    if (paramBoolean) {
      M();
    }
    ((PushManager)getManager(5)).unregistProxyMessagePush(getAppid(), this.app.getPackageName() + ":video");
    LoadingStateManager.a().a();
    L();
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "kickPC in app  do logout");
    }
    String str = getCurrentAccountUin();
    if (str != null) {}
    try
    {
      WeiyunHelper.a(getApp(), Long.parseLong(str));
      super.logout(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, VideoConfigServlet.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public boolean m()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)getApp().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper = new LebaHelper(this);
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a();
    }
  }
  
  public boolean n()
  {
    return a().getBoolean(getApp().getString(2131433586) + getCurrentAccountUin(), false);
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.c();
    }
  }
  
  public boolean o()
  {
    String str = String.format(Locale.getDefault(), "may_know_in_contact_tab_%s", new Object[] { getCurrentAccountUin() });
    return a().getBoolean(str, true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    startServlet(new NewIntent(getApplication(), PushServlet.class));
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService = new MobileQQService(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator = new Automator(this);
    if (e())
    {
      QCallFacade.a(this, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = getEntityManagerFactory().createEntityManager();
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      if (StartService.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(StepFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, "{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,44,45,[100,79,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103],57,95,105}"));
      }
      if (StartService.jdField_a_of_type_Boolean) {
        ThemeUtil.initTheme(this);
      }
      O();
      P();
    }
    try
    {
      MagnifierSDK.a(Long.parseLong(getAccount()));
      ThreadManager.getSubThreadHandler().post(new zkl(this));
      if (StartService.jdField_a_of_type_Boolean) {
        ProfileCardUtil.a();
      }
      if (GuardManager.a != null) {
        GuardManager.a.a(this);
      }
      this.jdField_c_of_type_Boolean = true;
      a().a();
      a().d();
      UniformDownloadMgr.a().a(this);
      a().a();
      PluginManageHandler.getInstance().setPluginManagerProvider(this, false);
      StoryApi.a(this);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("QQAppInterface", 4, paramBundle.toString());
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    BaseApplicationImpl.sShowTime = 0L;
    BaseApplicationImpl.sLaunchTime = 0L;
    BaseApplicationImpl.appStartTime = 0L;
    FMTSrvAddrProvider.b();
    L();
    ThemeUiPlugin.destroy(this);
    ChatBackgroundManager.a();
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Zlj);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    }
    ThreadManager.post(new zkv(this), 8, null, false);
    i();
    if (QLog.isColorLevel()) {
      QLog.d("security_scan", 2, "Unregist Cloud Scan Listener");
    }
    try
    {
      ThreadManager.post(new zkw(this), 8, null, false);
      label106:
      UniformDownloadMgr.a().a();
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
        a().c();
      }
      Config.a();
      OpenApiManager.getInstance().onRuntimeDestroy(this);
      AppLaucherHelper.a();
      TroopFileUploadingManager.a(this);
      QWalletHelper.clearInstance(this);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter.e();
      }
      if (this.mHwEngine != null) {
        this.mHwEngine.closeEngine();
      }
      if (!TextUtils.isEmpty(getCurrentAccountUin())) {
        QQOperateManager.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter != null) {
        a().e();
      }
      if (this.jdField_a_of_type_CooperationQlinkQQProxyForQlink != null) {
        a().c();
      }
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
      if (localPresendPicMgr != null) {
        localPresendPicMgr.b();
      }
      if (InnerDns.a != null) {
        InnerDns.a().a();
      }
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      }
      QIMManager.a().a();
      t = false;
      return;
    }
    catch (Exception localException)
    {
      break label106;
    }
  }
  
  public RemotePluginManager.Stub onGetPluginManager()
  {
    return (PluginManagerV2)getManager(26);
  }
  
  public void onProxyIpChanged()
  {
    ThreadManager.post(new zko(this), 8, null, false);
  }
  
  public void onRunningBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningBackground");
    }
    super.onRunningBackground();
    if (ReadInJoyGlobalReporter.a())
    {
      ReadInJoyGlobalReporter.a().a();
      ReadInJoyGlobalReporter.a().b();
      ReadInJoyGlobalReporter.a().a(1);
    }
    C();
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.f();
    }
    ReportController.a(this);
    a().b();
    Object localObject = (QzoneAlbumRedTouchManager)getManager(103);
    if (localObject != null) {
      ((QzoneAlbumRedTouchManager)localObject).c();
    }
    localObject = (MediaPlayerManager)this.jdField_a_of_type_ArrayOfMqqManagerManager[23];
    if ((localObject != null) && (((MediaPlayerManager)localObject).b())) {
      ((MediaPlayerManager)localObject).a(false);
    }
    a(-1L);
    if (Build.VERSION.SDK_INT >= 23) {}
    for (;;)
    {
      try
      {
        localObject = BaseApplicationImpl.getContext();
        List localList = ((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningTasks(1);
        if ((localList != null) && (localList.size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQAppInterface", 2, "checkBackgroundRestricWhilteList onRunningBackground topActivity packageName: " + ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName());
          }
          if (!((Context)localObject).getPackageName().equals(((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName())) {
            continue;
          }
          this.s = false;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQAppInterface", 1, "checkBackgroundRestricWhilteList, ", localException);
        continue;
      }
      DeviceAbilityCollector.a(BaseApplicationImpl.getContext());
      LpReportManager.getInstance().startReportImediately(2);
      AdvertisementRecentUserManager.a().a();
      ImaxAdRecentUserManager.a().b();
      SMRM.a().a(this);
      GestureMgrAppDownload.a(this);
      QavGPDownloader.a(this);
      MessageStatisticHelper.a();
      BaseStrategy.b();
      JobReporter.reportThreadPeakCount(getCurrentAccountUin());
      ReadinjoySPEventReport.i();
      return;
      this.s = true;
    }
  }
  
  public void onRunningForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "onRunningForeground");
    }
    super.onRunningForeground();
    ReportController.b(this, "CliOper", "", "", "0X8004014", "0X8004014", 0, 0, "", "", "", "");
    Object localObject = a();
    if ((localObject != null) && (((QQMessageFacade)localObject).b() > 1)) {
      ReportController.b(this, "CliOper", "", "", "0X8004015", "0X8004015", 0, 0, "", "", "", "");
    }
    if (ReadInJoyGlobalReporter.a())
    {
      ReadInJoyGlobalReporter.a().a(this, NetConnInfoCenter.getServerTimeMillis());
      ReadInJoyGlobalReporter.a().a(2);
    }
    ReportController.a(this, false);
    QlinkReliableReport.a();
    localObject = new Intent("com.tencent.intent.QZONE_PRE_DOWNLOAD_CANCEL");
    BaseApplication.getContext().sendBroadcast((Intent)localObject);
    localObject = (PhoneContactManagerImp)getManager(10);
    if (localObject != null) {
      ((PhoneContactManagerImp)localObject).b(false);
    }
    localObject = (GameCenterManagerImp)getManager(11);
    if (localObject != null)
    {
      ((GameCenterManagerImp)localObject).b();
      ((NumRedPointManager)getManager(63)).a();
      localObject = BaseApplication.getContext().getSharedPreferences(getAccount(), 0);
      int i1 = ((SharedPreferences)localObject).getInt("NumRedTimeInterval", 600);
      int i2 = ((SharedPreferences)localObject).getInt("NumRedLastTime", 0);
      if ((int)(System.currentTimeMillis() / 1000L) - i2 > i1) {
        ((NumRedPointHandler)a(55)).b();
      }
      ((RedpointHandler)a(87)).a(false, true);
    }
    localObject = (ArkAppCenter)getManager(120);
    if (localObject != null) {
      ((ArkAppCenter)localObject).a();
    }
    localObject = (QZoneManager)getManager(9);
    if (localObject != null)
    {
      if (((QZoneManager)localObject).a() > 0) {
        ((QZoneManager)localObject).a(((QZoneManager)localObject).a());
      }
      ((QZoneManager)localObject).a(2);
    }
    f(false);
    localObject = (SubAccountControll)getManager(61);
    if ((localObject != null) && (((SubAccountControll)localObject).jdField_a_of_type_Boolean))
    {
      SubAccountControll.a(this, true);
      ((SubAccountControll)localObject).jdField_a_of_type_Boolean = false;
    }
    QWalletPushManager.a(this, false);
    if (!QQUtils.a(getApp().getBaseContext()))
    {
      localObject = (DingdongPluginManager)getManager(114);
      if (localObject != null) {
        ((DingdongPluginManager)localObject).a(this);
      }
    }
    localObject = (ActivateFriendsManager)getManager(84);
    if (localObject != null) {
      ((ActivateFriendsManager)localObject).a();
    }
    StatisticCollector.a(BaseApplicationImpl.sApplication).a(this);
    z();
    QQToast.a(true);
    QWalletHelper.getPayCode(this);
    localObject = (QWalletConfigManager)getManager(244);
    if (localObject != null) {
      ((QWalletConfigManager)localObject).a(4);
    }
    if ((isLogin()) && (Build.VERSION.SDK_INT >= 23) && (this.s)) {
      Q();
    }
    localObject = a();
    if ((localObject != null) && (((NowLiveManager)localObject).jdField_a_of_type_Boolean) && ((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int == 1)) {
      StoryReportor.a("story_tab", "exp", 0, ((TroopRedTouchManager)getManager(69)).b(), new String[] { "", "", "", "" });
    }
    ReadinjoySPEventReport.f();
    VipGrayConfigHelper.a();
    ((GdtAdHandler)a(110)).b();
    ThreadManager.executeOnFileThread(new zkz(this));
    QLog.d("QQAppInterface", 2, "**davorteng**onRunningForeground...");
    localObject = (SmartDeviceProxyMgr)a(51);
    if (localObject != null) {
      ((SmartDeviceProxyMgr)localObject).d();
    }
  }
  
  public void p()
  {
    try
    {
      ((MessageHandler)a(0)).s();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean p()
  {
    return ((NearByGeneralManager)getManager(160)).b();
  }
  
  public void q()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "trySoundAndVibrate is called,needSoundAndVibrations is:" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    }
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = ((QQMessageFacade)localObject).a();
      } while (localObject == null);
      this.jdField_c_of_type_ArrayOfLong[0] = ((QQMessageFacade.Message)localObject).uniseq;
      this.jdField_c_of_type_ArrayOfLong[1] = 1L;
    } while (this.jdField_a_of_type_ArrayOfByte[0] != 1);
    if (this.jdField_a_of_type_ArrayOfByte[1] == 1) {}
    for (;;)
    {
      d((MessageRecord)localObject, bool);
      this.jdField_a_of_type_ArrayOfByte[0] = 0;
      return;
      bool = false;
    }
  }
  
  public boolean q()
  {
    return a().getBoolean(getApp().getString(2131433587) + getCurrentAccountUin(), false);
  }
  
  public void r()
  {
    d(null, false);
  }
  
  public boolean r()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener != null) && (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener.g());
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        this.jdField_b_of_type_JavaUtilList.remove(paramBusinessObserver);
      }
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramBusinessObserver);
      return;
      paramBusinessObserver = finally;
      throw paramBusinessObserver;
      paramBusinessObserver = finally;
      throw paramBusinessObserver;
    }
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.b(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.a(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void s()
  {
    ((LBSHandler)a(3)).b();
  }
  
  public boolean s()
  {
    boolean bool2 = false;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.app);
    boolean bool3 = SettingCloneUtil.readValue(this.app, null, "security_scan_key", "qqsetting_security_scan_key", false);
    boolean bool4 = ((SharedPreferences)localObject).getBoolean("security_scan_last_result", false);
    long l1 = ((SharedPreferences)localObject).getLong("security_scan_last_time", 0L);
    localObject = new Date(l1);
    Date localDate = new Date();
    ((Date)localObject).setHours(0);
    ((Date)localObject).setMinutes(0);
    ((Date)localObject).setSeconds(0);
    boolean bool1 = bool2;
    if (bool3) {
      if ((l1 != 0L) && (localDate.getTime() - ((Date)localObject).getTime() <= 604800000L))
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
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService != null) {
      this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.a(paramToServiceMsg);
    }
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    String str = "";
    if (!getCurrentAccountUin().equals("0")) {
      str = getCurrentAccountUin();
    }
    SharedPreUtils.a(getApplication().getApplicationContext(), str, paramBoolean);
  }
  
  public void start(boolean paramBoolean)
  {
    if ((paramBoolean) && (BaseApplicationImpl.sDirector != null)) {
      return;
    }
    this.jdField_a_of_type_Zlj = new zlj(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Zlj);
    super.start(paramBoolean);
  }
  
  public void t()
  {
    ((CardHandler)a(2)).b();
  }
  
  public boolean t()
  {
    String str1 = getCurrentAccountUin();
    String str2 = ContactUtils.j(this, str1);
    Object localObject;
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2)))
    {
      localObject = (FriendsManager)getManager(50);
      if (localObject == null)
      {
        localObject = null;
        if ((localObject != null) && (((Friends)localObject).name != null)) {
          break label136;
        }
        localObject = (FriendListHandler)a(1);
        if (localObject == null) {
          break label136;
        }
        ((FriendListHandler)localObject).b(str1);
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QQAppInterface", 4, "checkAndGetSelfNickName, [" + str2 + "," + bool + "]");
      }
      return bool;
      localObject = ((FriendsManager)localObject).c(str1);
      break;
    }
  }
  
  public void u()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.L, 0);
      a().a().d();
      return;
    }
  }
  
  public boolean u()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(BaseApplication.getContext().getString(2131433536) + getCurrentAccountUin(), true);
  }
  
  protected void userLogoutReleaseData()
  {
    M();
    UpgradeController.a().a(true);
    FriendSystemMsgController.a().a();
    GroupSystemMsgController.a().a();
    MsgAutoMonitorUtil.a().a();
    ChatActivityUtils.c();
    BadgeUtils.a(this.app, 0);
    SharedPreferences.Editor localEditor = this.app.getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.b();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a();
    }
    OpenApiManager.getInstance().onUserLogout(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a();
    ((NowProxy)getManager(181)).onDestroy();
    NowVideoController.a().c();
  }
  
  public void v()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      a().a(AppConstants.L, 0);
      return;
    }
  }
  
  public void w()
  {
    ISecureModuleService localISecureModuleService = a();
    if (localISecureModuleService.register(new ProductInfo(6, e(), Integer.parseInt("3560"), 201, null, getAccount())) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("security_scan", 2, "Start Security Scan");
      }
      if (this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener == null) {
        this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener = new zkt(this);
      }
      localISecureModuleService.registerCloudScanListener(getApp(), this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener);
      localISecureModuleService.cloudScan();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("security_scan", 2, "regist security service error");
  }
  
  public void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener.a();
    }
  }
  
  public void y()
  {
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void z()
  {
    long l2 = 0L;
    long l1;
    if ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) && (this.m))
    {
      l1 = l2;
      if (this.jdField_c_of_type_Long != 0L)
      {
        l1 = jdField_e_of_type_Int - (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long);
        if (l1 >= 0L) {
          break label116;
        }
        l1 = l2;
      }
    }
    label116:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "onResume send msg " + l1);
      }
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, new WeakReference(this));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface
 * JD-Core Version:    0.7.0.1
 */