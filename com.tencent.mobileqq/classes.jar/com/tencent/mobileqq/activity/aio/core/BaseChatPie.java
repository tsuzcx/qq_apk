package com.tencent.mobileqq.activity.aio.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.etrump.mixlayout.VasShieldFont;
import com.immersion.stickersampleapp.HapticManager;
import com.rookery.translate.AITranslator;
import com.tencent.aelight.camera.util.api.IAIOShortVideoUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.BaseQQMessageFacade.MessageNotifyParam;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.OnChatMessageCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.activity.aio.core.input.MessageSignal;
import com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.input.AIOInputState;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.FakeInputUI;
import com.tencent.mobileqq.activity.aio.coreui.input.FunBtnUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainerBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IHeadIconProcessor;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.coreui.tips.MsgBox;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOMultiActionHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.activity.aio.helper.DecodeAIOInputBitmapHeightTask;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper;
import com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.SelectToBottomHelper;
import com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper;
import com.tencent.mobileqq.activity.aio.helper.UnreadBackBottomHelper;
import com.tencent.mobileqq.activity.aio.helper.UnreadCountHelper;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.MixedHolder;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.PanelIconCallback;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.activity.aio.rebuild.panel.PanelRegistry;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.miniaio.IChatWindow;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.activity.selectable.ChatSelCurPageForLSSHelper;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.apollo.aio.item.IApolloItemBuilder.Holder;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.OnBottomOverScrollListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper;
import com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.hiboom.FontBubbleManager.FontBubbleObserver;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.mobileqq.jubao.JubaoHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.ScrollPlayer;
import com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.util.SystemDragUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.webview.UrlSecurityCheckManager;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.CommonImageView;
import com.tencent.mobileqq.widget.CommonTextView;
import com.tencent.mobileqq.widget.MosaicEffect;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QqViewFlipper;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.mqq.shared_file_accessor.LogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import com.tencent.qqperf.tools.SceneTracker;
import com.tencent.theme.SkinEngine;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollButtomListener;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.OnChangeMultiScreenListener;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqindividuality.QQIndividualityUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class BaseChatPie
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, ChatActivityConstants, BaseChatItemLayout.OnChatMessageCheckedChangeListener, PanelIconLinearLayout.PanelIconCallback, IChatWindow, CheckPttListener, ChatXListView.OnBottomOverScrollListener, INetInfoHandler, AbsListView.OnScrollButtomListener, AbsListView.OnScrollListener, AbsListView.RecyclerListener, XPanelContainer.OnChangeMultiScreenListener, XPanelContainer.PanelCallback, Observer
{
  public static int f = 30;
  private static int j;
  protected boolean A = true;
  public boolean B = false;
  public boolean C;
  private boolean D = false;
  private boolean E = true;
  private boolean F = false;
  private boolean G = false;
  protected float a;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  public Dialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new BaseChatPie.15(this);
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getRecentThreadLooper());
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View a;
  protected ViewGroup a;
  protected ViewStub a;
  public FrameLayout a;
  protected ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  public ChatAdapter1 a;
  public InputLinearLayout a;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  public SessionInfo a;
  public AIOAnimationConatiner a;
  public AIOFooterViewDetector a;
  protected final AIOContext a;
  protected final AIOInput a;
  protected final MsgList a;
  protected final TipsController a;
  protected HelperProvider a;
  final StructingMsgItemBuilder.ViewCache jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache = new StructingMsgItemBuilder.ViewCache();
  public PanelIconLinearLayout a;
  protected PanelManager a;
  protected BaseChatpieHelper a;
  protected TipsManager a;
  public ApolloInfo a;
  public BaseActivity a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new BaseChatPie.25(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new BaseChatPie.24(this);
  protected FriendListHandler a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new BaseChatPie.23(this);
  public QQAppInterface a;
  public QQMapActivityProxy a;
  public ChatXListView a;
  private ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  private NoC2CExtensionInfo jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
  FontBubbleManager.FontBubbleObserver jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager$FontBubbleObserver;
  private final ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new BaseChatPie.26(this);
  public TroopAioTips a;
  private RoamSettingObserver jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver = new BaseChatPie.22(this);
  public QQBlurView a;
  public QQProgressDialog a;
  public QqViewFlipper a;
  public NavBarAIO a;
  public PatchedButton a;
  public XEditTextEx a;
  protected XPanelContainer a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  protected CharSequence a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public AtomicBoolean a;
  protected final MqqHandler a;
  int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  protected View b;
  protected ViewGroup b;
  protected ImageView b;
  protected RelativeLayout b;
  protected TextView b;
  public QQProgressDialog b;
  private Boolean jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Runnable jdField_b_of_type_JavaLangRunnable = new BaseChatPie.1(this);
  public String b;
  protected boolean b;
  protected int c;
  protected View c;
  public ViewGroup c;
  protected ImageView c;
  protected TextView c;
  public QQProgressDialog c;
  protected String c;
  protected boolean c;
  protected int d;
  protected View d;
  public ViewGroup d;
  protected ImageView d;
  protected TextView d;
  protected boolean d;
  protected int e;
  protected View e;
  public ImageView e;
  public TextView e;
  protected boolean e;
  protected View f;
  public ImageView f;
  public TextView f;
  public boolean f;
  private int g;
  public ImageView g;
  public TextView g;
  public boolean g;
  private int jdField_h_of_type_Int = 0;
  protected ImageView h;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 1;
  protected ImageView i;
  boolean jdField_i_of_type_Boolean = false;
  protected ImageView j;
  public boolean j;
  private int k;
  public ImageView k;
  protected boolean k;
  private int jdField_l_of_type_Int = 0;
  boolean jdField_l_of_type_Boolean = false;
  private int m;
  public volatile boolean m;
  boolean n = true;
  boolean o = true;
  boolean p = false;
  protected boolean q;
  public boolean r = false;
  protected boolean s = false;
  protected boolean t = false;
  public boolean u = false;
  public boolean v = false;
  public boolean w = false;
  public boolean x;
  public boolean y = false;
  public boolean z;
  
  public BaseChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    this.jdField_b_of_type_JavaLangString = "BaseChatPie";
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = a();
    a(paramQQAppInterface, paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputAIOInput = a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputAIOInput.a().e();
    ao();
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
    case 20001: 
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131693470, 1).a();
      return;
    case 9011: 
      g(paramIntent);
      return;
    case 2000: 
      l(paramIntent);
      return;
    case 102: 
      a(false, null, false);
      return;
    case 85: 
      if (paramIntent != null)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"), false, true, paramIntent.getStringExtra(QQIndividualityUtils.jdField_d_of_type_JavaLangString), null);
        return;
      }
      break;
    case 21: 
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131719442));
      a(paramIntent.getExtras());
      return;
    case 20: 
      a(true, false);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(1024);
      return;
    case 18: 
      m(paramIntent);
      return;
    case 10: 
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt1, paramIntent, 10);
      return;
    case 5: 
      m(paramInt2);
    case 9009: 
      k(paramIntent);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.b(paramIntent);
      return;
    case 1: 
    case 17000: 
      ((IAIOShortVideoUtil)QRoute.api(IAIOShortVideoUtil.class)).handleSysCameraResult(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt3, paramInt1);
      return;
    case 0: 
      a(false, false);
    }
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, int paramInt3)
  {
    if (paramInt1 == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setCanLock(false);
    }
    else if (paramInt1 == 4001)
    {
      EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramIntent);
    }
    else if ((paramInt1 == 103) && (!paramBoolean))
    {
      a(false, true);
    }
    else if ((paramInt1 == 101) && (paramInt2 != -1))
    {
      a(false, false);
    }
    else if (paramInt1 == 13007)
    {
      p(paramIntent);
    }
    else if (paramInt1 == 11000)
    {
      c(paramInt1, paramInt2, paramIntent);
    }
    else if (paramInt1 == 13002)
    {
      o(paramIntent);
    }
    else if (paramInt1 == 13006)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onActivityResult() REQUEST_OPEN_REACTIVE_SETTING");
      }
      af();
    }
    else if (paramInt1 == 14001)
    {
      n(paramIntent);
    }
    else if (paramInt2 == -1)
    {
      a(paramInt1, paramInt2, paramIntent, paramInt3);
    }
    else
    {
      l(paramInt1);
    }
    b(paramInt1, paramInt2, paramIntent);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.a(paramInt1, paramInt2, paramString);
  }
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSession_forwardType intent type");
      localStringBuilder.append(paramIntent.getIntExtra("uintype", -1));
      localStringBuilder.append("needToBottom=");
      localStringBuilder.append(paramBoolean);
      QLog.d("forward", 2, localStringBuilder.toString());
    }
    if ((paramIntent.getExtras() != null) && (paramIntent.getExtras().containsKey("forward_type")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("forward", 2, "updateSession_forwardType from forward");
      }
      if ((paramIntent.getIntExtra("uintype", -1) == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramIntent.getStringExtra("uin"), true).jdField_a_of_type_Boolean))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697407, 0).b(a());
        return;
      }
      int i1 = paramIntent.getIntExtra("forward_type", 2147483647);
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      if (i1 == 0) {
        this.jdField_f_of_type_Boolean = true;
      } else if ((i1 == 1001) || (i1 == -4)) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 1, "updateSession_forwardType, postDelayed!");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseChatPie.5(this, paramBoolean, paramIntent), 500L);
      a(false, null, false);
    }
  }
  
  private void a(Message paramMessage)
  {
    ViewGroup localViewGroup = this.jdField_d_of_type_AndroidViewViewGroup;
    StringBuilder localStringBuilder = null;
    if (localViewGroup == null)
    {
      paramMessage = "1";
    }
    else if (paramMessage.obj == null)
    {
      paramMessage = "2";
    }
    else if (!(paramMessage.obj instanceof Drawable))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("3, msg.obj=");
      localStringBuilder.append(paramMessage.obj);
      paramMessage = localStringBuilder.toString();
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850371));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850371));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1034))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10007)
        {
          if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
          {
            this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850371));
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
          }
        }
        else
        {
          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)paramMessage.obj);
          if (AIOMusicSkin.a().n_()) {
            AIOMusicSkin.a().b(this.jdField_d_of_type_AndroidViewViewGroup.getContext(), this.jdField_d_of_type_AndroidViewViewGroup);
          }
          ((QEffectBgProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(17)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("MSG_SHOW_AIO_BACKGROUND sessionInfo:  isQimUserOnline = ");
            paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean);
            paramMessage.append("  isQimUserTitleForm = ");
            paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean);
            paramMessage.append("  isTimUserOnline = ");
            paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean);
            paramMessage.append(" isTimUserTitleForm = ");
            paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean);
            paramMessage.append("  isNightMode = ");
            paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean);
            paramMessage.append("  curType = ");
            paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            QLog.d("Q.msg.delmsg", 1, paramMessage.toString());
          }
        }
      }
      else
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850371));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      X();
      paramMessage = localStringBuilder;
    }
    d(paramMessage);
  }
  
  private void a(AIOLongShotHelper paramAIOLongShotHelper)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130851066);
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set left text from set checkbox: ");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = "";
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localObject != null) {
      ((NavBarAIO)localObject).e();
    }
    if (this.x)
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    MultiMsgManager.a().a();
    paramAIOLongShotHelper.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    ((AIOMultiActionHelper)a(66)).b();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      j();
      ai();
    }
    if (this.jdField_g_of_type_Boolean)
    {
      W();
      this.jdField_g_of_type_Boolean = false;
    }
    this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369258).setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
    paramAIOLongShotHelper = this.jdField_h_of_type_AndroidWidgetTextView;
    if ((paramAIOLongShotHelper != null) && (!TextUtils.isEmpty(paramAIOLongShotHelper.getText().toString())) && (!"0".equals(this.jdField_h_of_type_AndroidWidgetTextView.getText().toString())))
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      ((UnreadBackBottomHelper)a(53)).a();
    }
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", false);
  }
  
  private void a(FriendsManager paramFriendsManager, int paramInt1, int paramInt2)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    paramFriendsManager = localExtensionInfo;
    if (localExtensionInfo == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "saveC2CChatInputType | mExtensionInfo != null");
        }
        paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      }
      else
      {
        return;
      }
    }
    if (paramFriendsManager.chatInputType != paramInt1)
    {
      paramFriendsManager.chatInputType = paramInt1;
      paramFriendsManager.isDataChanged = true;
    }
    if (paramFriendsManager.showC2CPanel != paramInt2)
    {
      paramFriendsManager.showC2CPanel = paramInt2;
      paramFriendsManager.isDataChanged = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    AIOContext localAIOContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
    localAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = this;
    localAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    localAIOContext.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private void a(Object paramObject)
  {
    paramObject = (BaseQQMessageFacade.MessageNotifyParam)paramObject;
    if ((paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramObject.jdField_a_of_type_Int == 0)) {
      a(false, true);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramString == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onUpdateFriendInfo wrong uinType");
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034) {
        return;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) || (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) {
          paramString = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) {
          paramString = CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        } else {
          paramString = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramString;
        if (QLog.isColorLevel())
        {
          String str = this.jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onUpdateFriendInfo title");
          localStringBuilder.append(MessageRecordUtil.a(paramString));
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          paramString = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramString);
          a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
        }
      }
    }
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    if (!paramHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      paramHashMap = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
      if ((paramHashMap instanceof BaseChatItemLayout))
      {
        Object localObject = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramHashMap);
        paramHashMap = AIOUtils.a(paramHashMap);
        if ((localObject != null) && (paramHashMap != null) && (!paramHashMap.isSendFromLocal()) && (paramHashMap.istroop != 1) && (paramHashMap.istroop != 3000))
        {
          if ((paramHashMap.istroop != 1010) && (paramHashMap.istroop != 1001) && (paramHashMap.istroop != 10002) && (paramHashMap.istroop != 10010))
          {
            paramHashMap = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramHashMap.senderuin);
          }
          else
          {
            int i2;
            if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(paramHashMap.senderuin)) {
              i2 = 202;
            } else {
              i2 = 200;
            }
            paramHashMap = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i2, paramHashMap.senderuin, true);
          }
          localObject = (HeadIconWrapper)((BaseBubbleBuilder.ViewHolder)localObject).a.a(HeadIconWrapper.class);
          if (localObject != null) {
            ((IHeadIconProcessor)((HeadIconWrapper)localObject).a()).a(paramHashMap);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    int i1 = 1;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing()))
    {
      if (MultiMsgManager.a().jdField_a_of_type_Int != 2) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      MultiMsgManager.a().b.clear();
      if ((paramBoolean) && (paramObject != null)) {
        MultiMsgManager.a().b.putAll((Map)paramObject);
      }
      if (MultiMsgManager.a().b.size() == 0) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698526, 0).b(a());
      } else if (paramObject != null) {
        if (MultiMsgManager.a().jdField_a_of_type_Int == 6) {
          ((MultiFavoriteHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(11)).a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
        } else {
          ((MultiForwardHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(1)).a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetFriendNickBatch = ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    localObject = new HashMap();
    if ((!paramBoolean) && ((paramObject instanceof Integer))) {
      i1 = ((Integer)paramObject).intValue();
    } else if (paramBoolean) {
      i1 = 0;
    }
    paramObject = new StringBuilder();
    paramObject.append(i1);
    paramObject.append("");
    ((HashMap)localObject).put("result", paramObject.toString());
    paramObject = new StringBuilder();
    paramObject.append(NetworkUtil.getSystemNetwork(BaseApplication.getContext()));
    paramObject.append("");
    ((HashMap)localObject).put("netType", paramObject.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, (HashMap)localObject, "");
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localSessionInfo != null)
      {
        if (!Utils.a(paramString1, localSessionInfo.jdField_a_of_type_JavaLangString)) {
          return;
        }
        int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if ((i1 != 1001) && (i1 != 1009) && (i1 != 1010)) {
          return;
        }
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        paramString1.jdField_d_of_type_JavaLangString = paramString2;
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString1.jdField_d_of_type_JavaLangString);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          paramString1 = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramString1);
          a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
        }
        if (QLog.isDevelopLevel()) {
          DatingUtil.a(this.jdField_b_of_type_JavaLangString, new Object[] { "onGetFriendDateNick", paramString2 });
        }
      }
    }
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      if (paramInt == 0) {
        paramBoolean = ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).d();
      } else {
        paramBoolean = false;
      }
      if (!paramBoolean) {
        if ((paramInt != 1) && (paramInt != 4) && (paramInt != 5)) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
        } else {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(false);
        }
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private boolean a(Intent paramIntent)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((localSessionInfo != null) && ((localSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)))
    {
      paramIntent = paramIntent.getStringExtra("input_text_redpacket");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chooseChatInputType redPacketExtra");
        }
        h(0);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramIntent);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 267387140: 
      QQProgressDialog localQQProgressDialog = this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (localQQProgressDialog != null)
      {
        localQQProgressDialog.dismiss();
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(false);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694326, 0).b(a());
      if (paramMessage.arg1 == 1) {
        UncommonMessageProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, UncommonMessageProcessor.jdField_b_of_type_Int, UncommonMessageProcessor.jdField_l_of_type_Int);
      }
      return true;
    case 267387139: 
      paramMessage = this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (paramMessage != null)
      {
        paramMessage.dismiss();
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(false);
      return true;
    case 16711689: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a();
      return true;
    case 18: 
      a(false, false);
      return true;
    }
    f(paramMessage.arg1);
    return true;
  }
  
  private boolean a(FriendsManager paramFriendsManager)
  {
    Object localObject2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (!paramFriendsManager.d()) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chooseC2CChatInputType get ExtensionInfo = null");
      }
      localObject1 = new ExtensionInfo();
      ((ExtensionInfo)localObject1).uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      ((ExtensionInfo)localObject1).timestamp = System.currentTimeMillis();
      if (UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        ((ExtensionInfo)localObject1).chatInputType = 0;
      } else {
        ((ExtensionInfo)localObject1).chatInputType = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = ((ExtensionInfo)localObject1);
    }
    if (QLog.isColorLevel())
    {
      paramFriendsManager = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doChooseC2CInputType extInfo.chatInputType = ");
      ((StringBuilder)localObject2).append(((ExtensionInfo)localObject1).chatInputType);
      QLog.d(paramFriendsManager, 2, ((StringBuilder)localObject2).toString());
    }
    if (!AIOInputTypeHelper.jdField_b_of_type_Boolean)
    {
      int i1 = ((ExtensionInfo)localObject1).chatInputType;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2) {
            return false;
          }
          paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          if ((paramFriendsManager != null) && (paramFriendsManager.getIntent().getIntExtra("enter_ext_panel", 0) == 0))
          {
            this.jdField_h_of_type_Int = 2;
            return false;
          }
        }
      }
      else
      {
        ((ExtensionInfo)localObject1).chatInputType = 1;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doChooseC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser");
        }
      }
    }
    return false;
  }
  
  private boolean a(Object paramObject)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject instanceof SplashActivity))
    {
      if (((BaseActivity)localObject).isFinishing())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "preCheckUpdate: finished");
        }
        return true;
      }
      localObject = ((SplashActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if ((localObject != null) && (!((Fragment)localObject).isVisible()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "preCheckUpdate: chat fragment not visible");
        }
        return true;
      }
    }
    if ((paramObject == null) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "preCheckUpdate: data is null: ");
    }
    return paramObject == null;
  }
  
  private void aA()
  {
    NativeVideoImage.resumeAll();
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = PicItemBuilder.jdField_a_of_type_Int;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    AbstractVideoImage.resumeAll();
    NowVideoController.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.d();
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).b();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onShow_updateUI: listView.setVisibility(View.VISIBLE)");
    }
    aD();
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(this);
    if ((this.jdField_h_of_type_Boolean) && (this.n))
    {
      ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider);
      this.n = false;
    }
    if ((this.jdField_i_of_type_Boolean) && (this.o))
    {
      localObject = (ForwardIMByThirdPartyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(37);
      if (localObject != null) {
        ((ForwardIMByThirdPartyHelper)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), true);
      }
      this.o = false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    if (((SharedPreferences)localObject).getBoolean("sdcard_related_download_failed", false))
    {
      if (!Environment.getExternalStorageState().equals("mounted")) {
        QQToast.a(BaseApplication.getContext(), 2131694486, 0).b(a());
      } else if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1) {
        QQToast.a(BaseApplication.getContext(), 2131718576, 0).b(a());
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("sdcard_related_download_failed", false);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(64))
    {
      int i1 = HotReactiveHelper.a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(64, i1 * 1000);
    }
  }
  
  private void aB()
  {
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
    }
  }
  
  private void aC()
  {
    if ((QQLSRecentManager.jdField_e_of_type_Boolean) && (QQUtils.a(BaseApplication.getContext())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setReaded return : QQLSActivity is alive");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onShow_setReaded");
    }
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a(), 8, null, false);
  }
  
  private void aD()
  {
    if (t())
    {
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 4);
      if (((SharedPreferences)localObject1).getBoolean("FORWARD_EMOPGK_ID", false))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().getInt("FORWARD_EMOPGK_ID"));
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        ((SharedPreferences)localObject1).edit().remove("FORWARD_EMOPGK_ID").commit();
        this.jdField_h_of_type_Int = 3;
        localObject1 = (AIOEmoticonPanelHelper)a(104);
        if (localObject1 != null) {
          ((AIOEmoticonPanelHelper)localObject1).showEmoticonPanel((String)localObject2);
        }
      }
    }
  }
  
  private void aE()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.jdField_d_of_type_Boolean))
    {
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      int i1;
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() == 0)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1))
      {
        if (i()) {
          a((FriendsManager)localObject, 0, i1);
        }
      }
      else {
        b((FriendsManager)localObject, 0, i1);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveChatInputType cost :");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      QLog.d("save_inptut", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void aF()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b())
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(16711689);
    }
  }
  
  private void ao()
  {
    if (this.x) {
      b(AIOUtils.b(1.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
    } else {
      ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this), true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a().getVisibility() != 0)
    {
      XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      localXEditTextEx.setPadding(localXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), AIOUtils.b(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
    }
  }
  
  private void ap()
  {
    if (a())
    {
      QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      boolean bool = false;
      localQQBlurView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_c_of_type_AndroidViewViewGroup);
      localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      localQQBlurView.b(localQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
      localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = true;
      }
      localQQBlurView.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130838064);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new BaseChatPie.3(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDirtyListener(new BaseChatPie.4(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
  }
  
  private void aq()
  {
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  private void ar()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputAIOInput.a().f();
  }
  
  private void as()
  {
    BaseChatPie.9 local9 = new BaseChatPie.9(this);
    if (AppSetting.jdField_f_of_type_Boolean)
    {
      ThreadManager.executeOnSubThread(local9, true);
      return;
    }
    local9.run();
  }
  
  private void at()
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if (localChatXListView != null) {
      AIOUtils.a(localChatXListView.getOverscrollHeader());
    }
  }
  
  private void au()
  {
    XPanelContainer localXPanelContainer = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localXPanelContainer != null)
    {
      localXPanelContainer.c();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
    }
  }
  
  private void av()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showInputPanelIfNeeded() called");
    }
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Activity)localObject1).getIntent();
    if (localObject1 == null)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "showInputPanelIfNeeded() intent == null");
      return;
    }
    boolean bool = ((Intent)localObject1).getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false);
    if (QLog.isColorLevel())
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showInputPanelIfNeeded() requestShowInputPanel = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", Intent = ");
      localStringBuilder.append(System.identityHashCode(localObject1));
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    if (!bool) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localObject2 == null) {
      return;
    }
    if (!((XPanelContainer)localObject2).c())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showInputPanelIfNeeded() isReadyToShow false");
      }
      return;
    }
    Y();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = new BaseChatPie.11(this, (Intent)localObject1);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
  }
  
  private void aw()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showPlusPanelIfNeeded() called");
    }
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Activity)localObject1).getIntent();
    if (localObject1 == null) {
      return;
    }
    boolean bool = ((Intent)localObject1).getBooleanExtra("KEY_SHOULD_SHOW_PLUS_PANEL", false);
    if (QLog.isColorLevel())
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showPlusPanelIfNeeded() requestShowPlusPanel = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", Intent = ");
      localStringBuilder.append(System.identityHashCode(localObject1));
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    if (!bool) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localObject2 == null) {
      return;
    }
    if (!((XPanelContainer)localObject2).c())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showPlusPanelIfNeeded() isReadyToShow false");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseChatPie.12(this, (Intent)localObject1), 100L);
  }
  
  private void ax()
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if (localChatXListView != null) {
      localChatXListView.setSelection(localChatXListView.getAdapter().getCount() - 1);
    }
  }
  
  private void ay()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c();
    }
  }
  
  private void az()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow_videoStatus: mEnterExtPanel = ");
      localStringBuilder.append(this.jdField_h_of_type_Int);
      localStringBuilder.append(", mExtPanelOnResumeTimes = ");
      localStringBuilder.append(this.jdField_i_of_type_Int);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int i1 = this.jdField_h_of_type_Int;
    if (i1 != 0)
    {
      int i2 = this.jdField_i_of_type_Int - 1;
      this.jdField_i_of_type_Int = i2;
      if (i2 == 0)
      {
        if (i1 == 1) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new BaseChatPie.16(this));
        } else if (i1 == 2) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new BaseChatPie.17(this));
        }
        this.jdField_h_of_type_Int = 0;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false)) || (paramIntent.getBooleanExtra("destroy_last_activity", false)))) || (paramInt2 == 4))
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Bundle localBundle = paramIntent.getExtras();
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
        AIOUtils.a(localIntent, new int[] { 2 });
        localIntent.putExtras(new Bundle(localBundle));
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(4, paramIntent);
    }
    if ((paramInt1 == 21) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      a(false, null, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramInt1, paramInt2, paramIntent);
  }
  
  private void b(FriendsManager paramFriendsManager, int paramInt1, int paramInt2)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "saveNoC2CChatInputType | mNoC2CExtensionInfo != null");
        }
        localNoC2CExtensionInfo1 = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
      }
      else
      {
        return;
      }
    }
    if (localNoC2CExtensionInfo1.chatInputType != paramInt1)
    {
      localNoC2CExtensionInfo1.chatInputType = paramInt1;
      localNoC2CExtensionInfo1.isDataChanged = true;
    }
    if (localNoC2CExtensionInfo1.showC2CPanel != paramInt2)
    {
      localNoC2CExtensionInfo1.showC2CPanel = paramInt2;
      localNoC2CExtensionInfo1.isDataChanged = true;
    }
    paramFriendsManager.a(localNoC2CExtensionInfo1, false);
    this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo = null;
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
    {
      if (!(paramObject instanceof Set)) {
        return;
      }
      VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      Set localSet = (Set)paramObject;
      int i1 = 0;
      int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
      while (i1 < i3)
      {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
        if ((paramObject instanceof BaseChatItemLayout))
        {
          Object localObject1 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramObject);
          ChatMessage localChatMessage = AIOUtils.a(paramObject);
          if (localChatMessage.isSend()) {
            paramObject = localChatMessage.selfuin;
          }
          for (;;)
          {
            break;
            if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004)) {
              paramObject = localChatMessage.senderuin;
            } else {
              paramObject = localChatMessage.frienduin;
            }
          }
          Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if ((localObject1 != null) && (((BaseBubbleBuilder.ViewHolder)localObject1).a != null) && (paramObject != null) && (localSet.contains(paramObject)))
          {
            localObject2 = ((FriendsManager)localObject2).a(paramObject);
            if (localObject2 != null)
            {
              Object localObject3 = Long.valueOf(((ExtensionInfo)localObject2).pendantId);
              if (((Long)localObject3).longValue() != 0L)
              {
                localObject3 = ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(((Long)localObject3).longValue());
                localObject1 = ((BaseBubbleBuilder.ViewHolder)localObject1).a;
                int i2;
                if (i1 != i3) {
                  i2 = 1;
                } else {
                  i2 = 2;
                }
                ((PendantInfo)localObject3).a((View)localObject1, i2, localChatMessage.uniseq, paramObject, ((ExtensionInfo)localObject2).pendantDiyId);
              }
              else if (((BaseBubbleBuilder.ViewHolder)localObject1).a.jdField_a_of_type_ComTencentImageURLImageView != null)
              {
                ((BaseBubbleBuilder.ViewHolder)localObject1).a.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
                ((BaseBubbleBuilder.ViewHolder)localObject1).a.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
              }
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if ((i1 == 1044) || (i1 == 1045)) {
            break label56;
          }
          if (i1 != 3000) {
            return;
          }
        }
        a(false, false);
        return;
      }
      label56:
      if (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramString2;
        }
        else
        {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          paramString1.jdField_d_of_type_JavaLangString = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.jdField_a_of_type_JavaLangString);
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          if (paramString2.jdField_d_of_type_JavaLangString != null) {
            paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          } else {
            paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          }
          paramString2.jdField_d_of_type_JavaLangString = paramString1;
        }
        if (QLog.isColorLevel())
        {
          paramString1 = this.jdField_b_of_type_JavaLangString;
          paramString2 = new StringBuilder();
          paramString2.append("onSetComment curFriendNick");
          paramString2.append(MessageRecordUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString));
          QLog.d(paramString1, 2, paramString2.toString());
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          paramString1 = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramString1);
          a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
        }
      }
    }
  }
  
  private boolean b(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 26)
    {
      if (i1 != 28)
      {
        if (i1 != 31)
        {
          if (i1 != 58) {
            return false;
          }
          ChatActivityFacade.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
          return true;
        }
        boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_notice_key", false);
        if ((!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", false)) && (bool))
        {
          SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", true);
          paramMessage = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
          paramMessage.addFlags(268435456);
          paramMessage.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          BaseApplicationImpl.getApplication().startActivity(paramMessage);
        }
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      return true;
    }
    ChatActivityFacade.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
    return true;
  }
  
  private boolean b(FriendsManager paramFriendsManager)
  {
    Object localObject2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (!paramFriendsManager.d()) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chooseC2CChatInputType get NoC2CExtensionInfo = null");
      }
      localObject1 = new NoC2CExtensionInfo();
      ((NoC2CExtensionInfo)localObject1).type = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      ((NoC2CExtensionInfo)localObject1).uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      ((NoC2CExtensionInfo)localObject1).chatInputType = 0;
      this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo = ((NoC2CExtensionInfo)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    if (QLog.isColorLevel())
    {
      paramFriendsManager = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doChooseNoC2CInputType noC2CExtInfo.chatInputType = ");
      ((StringBuilder)localObject2).append(((NoC2CExtensionInfo)localObject1).chatInputType);
      ((StringBuilder)localObject2).append(" noC2CType = ");
      ((StringBuilder)localObject2).append(i1);
      QLog.d(paramFriendsManager, 2, ((StringBuilder)localObject2).toString());
    }
    int i1 = ((NoC2CExtensionInfo)localObject1).chatInputType;
    if (i1 != 0)
    {
      if (i1 != 2) {
        return false;
      }
      paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if ((paramFriendsManager != null) && (paramFriendsManager.getIntent().getIntExtra("enter_ext_panel", 0) == 0))
      {
        this.jdField_h_of_type_Int = 2;
        return false;
      }
    }
    else
    {
      ((NoC2CExtensionInfo)localObject1).chatInputType = 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doChooseNoC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser ");
      }
    }
    return false;
  }
  
  private boolean b(boolean paramBoolean)
  {
    if (BaseChatItemLayout.jdField_a_of_type_Boolean)
    {
      if (!this.z)
      {
        a(false, null, false);
        return true;
      }
      MultiMsgManager.a().jdField_a_of_type_Int = 0;
    }
    return paramBoolean;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, "");
  }
  
  private void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResult = =");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("resultCode");
      localStringBuilder.append(paramInt2);
      QLog.d("faceGuide", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(5, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(6, true);
    if (1000 == paramInt2)
    {
      paramInt1 = paramIntent.getIntExtra("click_item", 1);
      if ((paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 14)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onActivityResult = setPanel=");
        paramIntent.append(paramInt1);
        QLog.d("XPanel", 2, paramIntent.toString());
      }
      a(paramInt1);
      return;
    }
    if (1001 == paramInt2) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramObject);
      localStringBuilder.append("");
      if ((((String)localObject).equals(localStringBuilder.toString())) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onUpdateDelFriend exit ChatActivity now uin = ");
          ((StringBuilder)localObject).append(paramObject);
          QLog.d("cardpush", 2, ((StringBuilder)localObject).toString());
        }
        b(1);
      }
    }
  }
  
  private boolean c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(13);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(false);
    boolean bool = b(false);
    String str;
    StringBuilder localStringBuilder;
    if ((bool) && (paramInt == 0))
    {
      if (QLog.isColorLevel())
      {
        str = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("basechatpie_finish 1,type:");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return true;
    }
    n(paramInt);
    if ((a(paramInt, bool)) && (paramInt == 0))
    {
      if (QLog.isColorLevel())
      {
        str = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("basechatpie_finish 3,type:");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  private boolean c(Message paramMessage)
  {
    if (paramMessage.what == 16711697)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.jdField_b_of_type_Long < 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "MSG_BUBBLE_CACHE_UPDATE, frequency limit, abort");
        }
        return false;
      }
      this.jdField_b_of_type_Long = l1;
      if (this.jdField_b_of_type_Int != 0)
      {
        this.p = true;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "MSG_BUBBLE_CACHE_UPDATE, scrolling, abort");
        }
        return false;
      }
      boolean bool = VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      if (QLog.isColorLevel())
      {
        paramMessage = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MSG_BUBBLE_CACHE_UPDATE, needRefresh=");
        localStringBuilder.append(bool);
        QLog.d(paramMessage, 2, localStringBuilder.toString());
      }
      if (bool) {
        e(196608);
      }
    }
    return false;
  }
  
  private void d(String paramString)
  {
    if (paramString != null)
    {
      if (this.jdField_d_of_type_AndroidViewViewGroup != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        if ((localObject != null) && (((SessionInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (ChatBackground.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground))))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
          {
            this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850371));
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
          {
            this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850371));
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1034))
          {
            this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
          else
          {
            this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850371));
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("MSG_SHOW_AIO_BACKGROUND Error. bErrMsg=");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", show Again img=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          QLog.e("Q.msg.delmsg", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MSG_SHOW_AIO_BACKGROUND Error.. bErrMsg=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", afRoot=");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_AndroidViewViewGroup);
      ((StringBuilder)localObject).append(", sessionInfo=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      QLog.e("Q.msg.delmsg", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {
      paramObject = (Card)paramObject;
    } else {
      paramObject = null;
    }
    if ((paramBoolean) && (paramObject != null))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if ((i1 != 1) && (i1 != 1008) && (i1 != 1024))
      {
        if (i1 == 1034) {
          return;
        }
        if (i1 != 3000)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.uin))) {
            return;
          }
          n();
          if (QLog.isColorLevel())
          {
            paramObject = this.jdField_b_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onCardDownload nick = ");
            localStringBuilder.append(MessageRecordUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString));
            QLog.d(paramObject, 2, localStringBuilder.toString());
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
          if (AppSetting.jdField_d_of_type_Boolean)
          {
            paramObject = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
            this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramObject);
            a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
          }
          if ((3000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (!(this instanceof DiscussChatPie))) {
            return;
          }
          ((DiscussChatPie)this).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_AndroidWidgetTextView);
          return;
        }
      }
      a(false, false);
    }
  }
  
  private boolean d(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 100)
    {
      if (i1 != 101) {
        return false;
      }
      i1 = paramMessage.arg1;
      if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i1))
      {
        if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips(i1))
        {
          ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).showGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(a());
      }
      return true;
    }
    if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(0)) {
      ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), a());
    }
    return true;
  }
  
  private void e(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131378040: 
    case 2131378837: 
      if (this.z) {
        return;
      }
      a(paramView);
      return;
    case 2131369216: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
        this.D = true;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
      if (paramView != null) {
        paramView.d();
      }
      k();
      paramView = ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localObject = String.valueOf(NetConnInfoCenter.getServerTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report click setting: curType = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localStringBuilder.append(", mEntryFriendCard = ");
      localStringBuilder.append(this.D);
      localStringBuilder.append(", reportType = ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(", strCurT = ");
      localStringBuilder.append((String)localObject);
      QLog.d("850_reportEvent", 1, localStringBuilder.toString());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, paramView, "", (String)localObject, "");
      AIODtReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject);
      return;
    }
    if ((!this.z) && (BaseChatItemLayout.jdField_a_of_type_Boolean))
    {
      a(false, null, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
      {
        paramView = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F8", "0X80064F8", 0, 0, paramView, "", "", "");
      }
    }
    else
    {
      c(false);
    }
    try
    {
      paramView = this.jdField_a_of_type_AndroidWidgetTextView.getTag();
      localObject = (String[])paramView;
      if ((paramView != null) && ("comic".equals(localObject[0])))
      {
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "2", "40025", localObject[1], new String[] { "1" });
        return;
      }
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private boolean e(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 14)
    {
      if (i1 != 16711681)
      {
        if (i1 != 16711696)
        {
          if (i1 != 23)
          {
            if (i1 != 24) {
              return false;
            }
            Object localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog;
            if (localObject != null)
            {
              ((QQProgressDialog)localObject).dismiss();
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698527, 0).b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299168));
            }
            localObject = new HashMap();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramMessage.arg1);
            localStringBuilder.append("");
            ((HashMap)localObject).put("nickCount", localStringBuilder.toString());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeOut", false, 30000L, 0L, (HashMap)localObject, "");
            return true;
          }
          h(0);
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
          return true;
        }
        b(1);
        return true;
      }
      paramMessage = (String)paramMessage.obj;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessage)) {
        b(1);
      }
      return true;
    }
    b(paramMessage.arg1, paramMessage.arg2);
    return true;
  }
  
  private void h(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    localSessionInfo.jdField_a_of_type_Boolean = false;
    localSessionInfo.jdField_b_of_type_Boolean = false;
    if (localSessionInfo.jdField_a_of_type_Int == 0)
    {
      QIMUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      TIMUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    boolean bool2 = true;
    if (i1 == 1026)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("phonenum");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int = paramIntent.getIntExtra("entrance", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    localSessionInfo.f = null;
    localSessionInfo.jdField_c_of_type_JavaLangString = null;
    localSessionInfo.jdField_d_of_type_Int = paramIntent.getIntExtra("add_friend_source_id", 3999);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int = paramIntent.getIntExtra("key_confess_topicid", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c();
    this.jdField_h_of_type_Int = paramIntent.getIntExtra("enter_ext_panel", 0);
    this.jdField_i_of_type_Int = paramIntent.getIntExtra("ext_panel_onresume", 1);
    this.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("isBack2Root", false);
    if (paramIntent.getLongExtra("res_share_id", -1L) != -1L) {
      this.jdField_h_of_type_Boolean = paramIntent.getExtras().containsKey("res_share_id");
    }
    if (!this.jdField_h_of_type_Boolean) {
      this.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("is_share_flag", false);
    }
    if ("qzoneShareTopic".equals(paramIntent.getStringExtra("share_qq_ext_str"))) {
      this.jdField_h_of_type_Boolean = false;
    }
    this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("thridparty_pull_aio", false);
    this.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("is_from_manage_stranger", false);
    boolean bool3 = paramIntent.getBooleanExtra("need_jump_to_msg", false);
    boolean bool1;
    if (paramIntent.getIntExtra("aio_msg_source", 999) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.s = bool1;
    if ((this.s) || (bool3))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramIntent);
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b() > -1L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramIntent.b(bool1);
      AIOUtils.o = false;
      this.t = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(2);
  }
  
  private void i(Intent paramIntent)
  {
    h(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    String str = paramIntent.getStringExtra("input_text");
    paramIntent.removeExtra("input_text");
    if (str != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(str);
    }
  }
  
  private void j(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("res_share_id", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSession_otherThings appShareId=");
      localStringBuilder.append(l1);
      QLog.d("forward", 2, localStringBuilder.toString());
    }
    if (l1 > 0L) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseChatPie.6(this, paramIntent), 20L);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(4);
    if (paramIntent.getIntExtra("entrance", 0) == 9)
    {
      this.z = true;
      U();
      return;
    }
    this.z = false;
  }
  
  private void k(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nearby_profile_nickname");
      if ((paramIntent != null) && (!paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
        if (QLog.isColorLevel())
        {
          String str = this.jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult new nick is ");
          localStringBuilder.append(paramIntent);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_MqqOsMqqHandler.post(new BaseChatPie.14(this));
      }
    }
  }
  
  private void l(int paramInt)
  {
    if (paramInt == 2000) {
      ((HiddenChatHelper)a(39)).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    }
  }
  
  private void l(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onActivityResult() ENTER_CHATOPTION_REQUEST");
    }
    af();
    boolean bool;
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      bool = paramIntent.getExtras().getBoolean("isNeedFinish");
    } else {
      bool = false;
    }
    if (bool) {
      b(1);
    } else {
      a(false, false);
    }
    ((HiddenChatHelper)a(39)).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
  }
  
  private void m(int paramInt)
  {
    if (paramInt != -1) {
      return;
    }
    ax();
  }
  
  private void m(Intent paramIntent)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy;
    if (localObject1 != null)
    {
      ((QQMapActivityProxy)localObject1).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = null;
    }
    if (paramIntent != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBS", 2, "onActivityResult ChatActivityConstants.LBS_REQUEST");
      }
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        String str1 = localBundle.getString("latitude");
        String str2 = localBundle.getString("longitude");
        String str3 = localBundle.getString("description");
        String str4 = localBundle.getString("title");
        String str5 = localBundle.getString("summary");
        String str6 = localBundle.getString("dianping_id");
        paramIntent = localBundle.getString("poiId");
        localObject1 = localBundle.getString("latSpan");
        Object localObject2 = localBundle.getString("lngSpan");
        Object localObject3;
        if ((paramIntent != null) && (localObject1 != null) && (localObject2 != null))
        {
          localObject3 = localObject1;
        }
        else
        {
          localObject1 = "";
          paramIntent = (Intent)localObject1;
          localObject2 = paramIntent;
          localObject3 = paramIntent;
          paramIntent = (Intent)localObject1;
        }
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str1, str2, str3, str4, str5, str6, paramIntent, (String)localObject3, (String)localObject2, localBundle);
      }
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if ((!paramBoolean) && (l())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2130839573, this.jdField_a_of_type_AndroidContentContext.getString(2131719975), 0).b(a());
    }
  }
  
  private void n(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 4) && (paramInt != 5))
    {
      if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 0)) {
        aE();
      }
    }
    else {
      aE();
    }
  }
  
  private void n(Intent paramIntent)
  {
    int i1 = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int != i1)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      paramIntent.jdField_b_of_type_Int = i1;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, paramIntent.jdField_b_of_type_Int);
    }
  }
  
  private void o(int paramInt) {}
  
  private void o(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onActivityResulte() REQUEST_OPEN_SHORT_VIDEO_PLAYER...");
    }
    a(false, false);
    try
    {
      paramIntent = paramIntent.getStringExtra("babyq_video_type");
      if (!TextUtils.isEmpty(paramIntent))
      {
        int i1 = Integer.parseInt(paramIntent);
        paramIntent = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
        if (paramIntent != null)
        {
          paramIntent.a(i1);
          return;
        }
      }
    }
    catch (Exception paramIntent)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "doOnActivityResult exception!", paramIntent);
    }
  }
  
  private void p(Intent paramIntent)
  {
    try
    {
      int i1 = Integer.parseInt(paramIntent.getStringExtra("babyq_video_type"));
      paramIntent = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (paramIntent != null)
      {
        paramIntent.a(i1);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "doOnActivityResult exception!", paramIntent);
    }
  }
  
  private void q(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (this.jdField_l_of_type_Boolean))
    {
      int i1 = paramIntent.getInt("aio_msg_source", 999);
      paramIntent = ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" AIO_MSG_SOURCE : ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", reportType  = ");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.d("850_reportEvent", 1, ((StringBuilder)localObject).toString());
      localObject = String.valueOf(NetConnInfoCenter.getServerTimeMillis());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "AIO", "AIO_appear", 0, 0, paramIntent, String.valueOf(i1), (String)localObject, "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_appear", 0, 0, paramIntent, String.valueOf(i1), (String)localObject, "");
      return;
    }
    QLog.d("850_reportEvent", 1, "do not need to report");
  }
  
  private void r(Intent paramIntent)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = (IApolloAIOHelper)a(8);
    if ((localObject != null) && (((IApolloAIOHelper)localObject).isApolloForward())) {
      return;
    }
    if (t()) {
      return;
    }
    if (!((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).a()) {
      return;
    }
    if (a(paramIntent)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.jdField_d_of_type_Boolean))
    {
      paramIntent = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      boolean bool2;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1))
      {
        if (i())
        {
          bool2 = a(paramIntent);
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break label317;
          }
          paramIntent = this.jdField_b_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("chooseChatInputType doChooseC2CInputType needGuide = ");
          ((StringBuilder)localObject).append(bool2);
          QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
          bool1 = bool2;
          break label317;
        }
      }
      else
      {
        bool2 = b(paramIntent);
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break label317;
        }
        paramIntent = this.jdField_b_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("chooseChatInputType doChooseNoC2CInputType needGuide = ");
        ((StringBuilder)localObject).append(bool2);
        QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
        bool1 = bool2;
        break label317;
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (QLog.isColorLevel()))
    {
      paramIntent = this.jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("chooseC2CChatInputType isSimpleBar = ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = false;
    label317:
    ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).a(false, bool1);
    if (QLog.isColorLevel())
    {
      paramIntent = this.jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("chooseC2CChatInputType cost :");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean t()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if ((localBaseActivity != null) && (localBaseActivity.getIntent() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID"))) {
        return true;
      }
    }
    return false;
  }
  
  public void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "return MainFragment");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject1 instanceof SplashActivity))
    {
      Object localObject3 = ((BaseActivity)localObject1).getSupportFragmentManager();
      localObject1 = ((FragmentManager)localObject3).beginTransaction();
      Object localObject2 = ((FragmentManager)localObject3).findFragmentByTag(MainFragment.class.getName());
      localObject3 = ((FragmentManager)localObject3).findFragmentByTag(ChatFragment.class.getName());
      ((FragmentTransaction)localObject1).setCustomAnimations(2130772083, 2130772075);
      SplashActivity.currentFragment = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtra("isFromAioFragment", true);
      if (localObject2 != null) {
        ((FragmentTransaction)localObject1).show((Fragment)localObject2);
      } else {
        ((FragmentTransaction)localObject1).add(16908290, MainFragment.a(), MainFragment.class.getName());
      }
      ((FragmentTransaction)localObject1).hide((Fragment)localObject3);
      if (localObject3 != null)
      {
        localObject2 = (ChatFragment)localObject3;
        if (((ChatFragment)localObject2).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) {
            ((ChatFragment)localObject2).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
          } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) {
            ((ChatFragment)localObject2).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
          } else {
            ((ChatFragment)localObject2).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 450);
          }
        }
      }
      ((FragmentTransaction)localObject1).commitAllowingStateLoss();
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 4, "returnMainFragment() mActivity instanceof ChatActivity ");
    }
    SceneTracker.a().b("ChatFragment");
  }
  
  protected void B()
  {
    try
    {
      if (this.jdField_l_of_type_Int == 0)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
        localIntentFilter.addAction("android.intent.action.PHONE_STATE");
        localIntentFilter.addAction("vivo_smart_shot_enter");
        localIntentFilter.addAction("com.huawei.hwmultidisplay.action.WINDOW_CAST_MODE");
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        this.jdField_l_of_type_Int = 1;
      }
      else if (QLog.isColorLevel())
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 2, "registerReceiver but done");
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("registerReceiver ");
        localStringBuilder.append(localException);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this);
    String str = this.jdField_b_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AIOTime doOnRegReceivershashCode = ");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
  }
  
  protected void C()
  {
    try
    {
      if (this.jdField_l_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_l_of_type_Int = 0;
      }
      else if (QLog.isColorLevel())
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 2, "unRegisterReceiver but cannot");
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unregisterReceiver:");
        localStringBuilder.append(localException);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
    }
    boolean bool = AppNetConnInfo.unregisterNetInfoHandler(this);
    String str = this.jdField_b_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AIOTime doOnUnRegReceivers :");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("hashCode = ");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
  }
  
  protected void D()
  {
    ThreadPriorityManager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void E()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(21);
  }
  
  public void F()
  {
    this.x = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isThemeDefault");
      ((StringBuilder)localObject2).append(this.x);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_Boolean = false;
      if (ChatBackground.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
        {
          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850371));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
        {
          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850371));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
        }
        else
        {
          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localObject1 != null) {
      ((NavBarAIO)localObject1).d();
    }
    try
    {
      aj();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130851069, 2130851070);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850473, 2130850474);
      }
    }
    catch (Exception localException)
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPostThemeChanged e:");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append("isThemeDefault");
      localStringBuilder.append(this.x);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(22);
    ((SimpleUIAIOHelper)a(29)).a(a());
    AIOMusicSkin.a().b(a(), this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
  }
  
  public void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMagicFaceItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public void H()
  {
    Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setId(2131371572);
    ((TextView)localObject).setBackgroundResource(2130838330);
    ((TextView)localObject).setGravity(1);
    ((TextView)localObject).setPadding(0, (int)(this.jdField_a_of_type_Float * 2.0F + 0.5F), 0, 0);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(2, 16.0F);
    ((TextView)localObject).setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(2, 2131368875);
    localLayoutParams.addRule(11);
    float f1 = this.jdField_a_of_type_Float;
    localLayoutParams.bottomMargin = ((int)(f1 * 10.0F + 0.5F));
    localLayoutParams.rightMargin = ((int)(f1 * 10.0F + 0.5F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)localObject);
    ((TextView)localObject).setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a() != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a());
    }
    ((AudioPanelAioHelper)a(128)).j(2131371572);
    localObject = (UnreadBackBottomHelper)a(53);
    ((UnreadBackBottomHelper)localObject).a(this.jdField_h_of_type_AndroidWidgetTextView);
    ((UnreadBackBottomHelper)localObject).b(this.jdField_g_of_type_Int);
  }
  
  protected void I()
  {
    ((AppGuideTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).b();
  }
  
  protected void J()
  {
    ai();
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent() == null)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "onShow_otherThings: intent == null");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new BaseChatPie.18(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink().b();
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(31, 800L);
    aB();
    AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    BubbleDiyFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    a(BaseApplication.getContext(), "com.vivo.smartshot");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isvivo has shot");
      ((StringBuilder)localObject).append(jdField_j_of_type_Int);
      QLog.d("vivo", 2, ((StringBuilder)localObject).toString());
    }
    if (!((IDPCApi)QRoute.api(IDPCApi.class)).isInited()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    }
    AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(), null);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    float f1 = this.jdField_a_of_type_Float;
    AIOUtils.a((View)localObject, (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), 0, 0);
    AIOUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(this.jdField_a_of_type_Float * 50.0F + 0.5F));
  }
  
  protected void K()
  {
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_end", null, false, null);
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "onShow start ", hashCode(), this.jdField_c_of_type_Int);
    StartupTracker.a(null, "AIO_onShow");
    StartupTracker.a(null, "AIO_onShow_emotion");
    StartupTracker.a("AIO_onShow_emotion", null);
    I();
    StartupTracker.a(null, "AIO_onShow_updateUI");
    aA();
    StartupTracker.a("AIO_onShow_updateUI", "AIO_onShow_videoStatus");
    az();
    StartupTracker.a("AIO_onShow_videoStatus", "AIO_onShow_report");
    q(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    StartupTracker.a("AIO_onShow_report", "AIO_onShow_otherThings");
    J();
    StartupTracker.a("AIO_onShow_otherThings", "AIO_onShow_setReaded");
    aC();
    StartupTracker.a("AIO_onShow_setReaded", null);
    ThreadPriorityManager.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(10);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1000, new Object[0]);
    StartupTracker.a("AIO_onShow", null);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "AIOTime onShow end");
    }
    if (!(this instanceof TroopChatPie)) {
      AIOAnimationControlManager.a(this, true);
    }
    av();
    aw();
  }
  
  @TargetApi(11)
  protected void L()
  {
    PanelIconLinearLayout localPanelIconLinearLayout;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a() == 2)
    {
      localPanelIconLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
      if (localPanelIconLinearLayout != null)
      {
        localPanelIconLinearLayout.setAllEnable(false);
        if (VersionUtils.e()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
        }
      }
    }
    else
    {
      localPanelIconLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
      if (localPanelIconLinearLayout != null)
      {
        localPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.e()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
        }
      }
    }
  }
  
  protected void M()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    PanelIconLinearLayout localPanelIconLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
    if (localPanelIconLinearLayout != null)
    {
      if (i1 == 1)
      {
        localPanelIconLinearLayout.setAllUnSelected();
        return;
      }
      if (i1 == 23)
      {
        localPanelIconLinearLayout.setSelected(8);
        return;
      }
      if (i1 == 35)
      {
        localPanelIconLinearLayout.setSelected(8);
        return;
      }
      localPanelIconLinearLayout.setSelected(i1);
    }
  }
  
  public void N()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null))
    {
      localObject = (InputMethodManager)((BaseActivity)localObject).getSystemService("input_method");
      if (localObject != null)
      {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "hideSoftInput, ", this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken() });
        }
      }
    }
  }
  
  protected void O()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setCheckPttListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager$FontBubbleObserver = new FontBubbleManager.FontBubbleObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager$FontBubbleObserver);
  }
  
  protected void P()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setCheckPttListener(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager$FontBubbleObserver);
  }
  
  public void Q()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void R()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().b();
  }
  
  public void S()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().c();
  }
  
  public void T()
  {
    ((AIOShakeHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(65)).a();
  }
  
  public void U()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localObject != null) {
      ((NavBarAIO)localObject).setRightToStr(HardCodeUtil.a(2131701205), new BaseChatPie.28(this));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
    if (localObject != null) {
      ((PanelIconLinearLayout)localObject).setVisibility(8);
    }
    JubaoHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().getIntent());
    a(true, null, false, true);
  }
  
  public void V()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    PanelIconLinearLayout localPanelIconLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
    if (localPanelIconLinearLayout != null) {
      localPanelIconLinearLayout.setCustomHeight(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().b();
  }
  
  public void W()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    PanelIconLinearLayout localPanelIconLinearLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
    if ((localPanelIconLinearLayout != null) && (!(this instanceof PublicAccountChatPie))) {
      localPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.jdField_b_of_type_Int);
    }
    ((SimpleUIAIOHelper)a(29)).c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
  }
  
  protected void X()
  {
    Object localObject1;
    Object localObject2;
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null)
      {
        boolean bool;
        if ((!"".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString)) && (!"null".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString))) {
          bool = false;
        } else {
          bool = true;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = this.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("#handleNightMask# : inNightMode, isDefaultBg=");
          ((StringBuilder)localObject2).append(bool);
          ((StringBuilder)localObject2).append(",mMask=");
          ((StringBuilder)localObject2).append(this.jdField_e_of_type_AndroidViewView);
          ((StringBuilder)localObject2).append(", sessionInfo.chatBg.path=");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        if ((this.jdField_e_of_type_AndroidViewView != null) && (QLog.isColorLevel())) {
          if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
          } else if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 4) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
          } else {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#handleNightMask# : mMask getVisibility = GONE");
          }
        }
        if (!bool)
        {
          localObject1 = this.jdField_e_of_type_AndroidViewView;
          if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0)) {
            return;
          }
          localObject1 = this.jdField_e_of_type_AndroidViewView;
          if (localObject1 == null)
          {
            this.jdField_e_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
            this.jdField_e_of_type_AndroidViewView.setBackgroundColor(1996488704);
            localObject1 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131370119);
            ((RelativeLayout.LayoutParams)localObject1).addRule(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getId());
            this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidViewView);
            return;
          }
          ((View)localObject1).setVisibility(0);
          return;
        }
        localObject1 = this.jdField_e_of_type_AndroidViewView;
        if (localObject1 != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject1);
          this.jdField_e_of_type_AndroidViewView = null;
        }
      }
    }
    else
    {
      localObject1 = this.jdField_e_of_type_AndroidViewView;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if (localObject2 != null)
        {
          ((RelativeLayout)localObject2).removeView((View)localObject1);
          this.jdField_e_of_type_AndroidViewView = null;
        }
      }
    }
  }
  
  public void Y()
  {
    XPanelContainer localXPanelContainer = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localXPanelContainer != null) {
      localXPanelContainer.a(1);
    }
  }
  
  public void Z()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(30);
  }
  
  public int a()
  {
    return AIOUtils.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  protected int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt2 = paramInt1 + paramInt2 - paramInt4 - paramInt5;
    paramInt1 = paramInt2;
    if (paramInt2 >= paramInt3 - paramInt5 - paramInt4) {
      paramInt1 = paramInt6 - 1;
    }
    if (paramInt1 >= paramInt8)
    {
      paramInt1 += paramInt4;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt1));
    }
    else
    {
      paramInt1 = paramInt8;
    }
    if (paramInt7 == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt6, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt6));
      paramInt1 = paramInt6;
    }
    long l1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt1);
    paramInt2 = paramInt1;
    if (l1 > 0L)
    {
      paramInt2 = paramInt1;
      if (l1 != l2)
      {
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(l1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt2, l1);
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "doUpdateUnreadBubble. after revise readCnt =", Integer.valueOf(paramInt2) });
      }
    }
    return paramInt6 - paramInt2;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Dialog a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramInt);
  }
  
  public View a(int paramInt)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(paramInt);
    if (localView != null) {
      return localView;
    }
    return null;
  }
  
  public ViewGroup a()
  {
    return this.jdField_c_of_type_AndroidViewViewGroup;
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public TextView a()
  {
    return this.jdField_h_of_type_AndroidWidgetTextView;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public AIOAnimationConatiner a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  }
  
  protected AIOContext a()
  {
    return new AIOContext();
  }
  
  protected AIOInput a()
  {
    return new AIOInputBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new BaseMessageSender(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected TipsController a()
  {
    return new TipsController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
  }
  
  protected InputUIContainer a()
  {
    return new InputUIContainerBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new InputBarUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout)).a(new EditTextUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentWidgetXEditTextEx)).a(new FunBtnUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentWidgetPatchedButton)).a(new InputRightIconUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected HelperProvider a()
  {
    return new HelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public <T extends IHelper> T a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramInt);
  }
  
  public StructingMsgItemBuilder.ViewCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache;
  }
  
  public PanelManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager;
  }
  
  public TipsManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public ExtensionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  }
  
  public NoC2CExtensionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
  }
  
  public EntryModel a()
  {
    return new EntryModel(-1, 0L, "", false);
  }
  
  public RecordParams.RecorderParam a()
  {
    return new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
  }
  
  public XPanelContainer a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
  }
  
  protected Boolean a()
  {
    return null;
  }
  
  protected String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    return ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected final List<ChatMessage> a()
  {
    return a(false);
  }
  
  protected final List<ChatMessage> a(boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramBoolean);
  }
  
  public final MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    if (localObject != null) {
      ((ImageButton)localObject).setActivated(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(paramInt);
    AIOUtils.o = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPanelIconClick panelID=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("currentID=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
      QLog.d("XPanel", 2, ((StringBuilder)localObject).toString());
    }
    ((FastImageHelper)a(83)).b(true);
    o();
    if (paramInt == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(paramInt);
    o(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(paramInt1, paramInt2);
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a(this.jdField_a_of_type_Long);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a();
    if (i1 < paramInt6) {
      i1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, i1);
    } else {
      i1 = 0;
    }
    if (i1 != this.jdField_g_of_type_Int)
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(13)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(13);
      }
      int i2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(), i1);
      localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      Message localMessage = ((MqqHandler)localObject).obtainMessage(13, i2, paramInt7);
      long l1;
      if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        l1 = 1500L;
      } else {
        l1 = 0L;
      }
      ((MqqHandler)localObject).sendMessageDelayed(localMessage, l1);
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      this.jdField_g_of_type_Int = i1;
    }
    Object localObject = (UnreadBackBottomHelper)a(53);
    if (localObject != null)
    {
      ((UnreadBackBottomHelper)localObject).b(this.jdField_g_of_type_Int);
      ((UnreadBackBottomHelper)localObject).a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doOnActivityResult], requestCode:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",resultCode:");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int i1;
    boolean bool;
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      i1 = paramIntent.getIntExtra("camera_type", 1);
      bool = paramIntent.getExtras().getBoolean("progress2View");
      if ((paramInt1 == 11000) && (i1 == 103)) {
        paramInt1 = 1;
      }
    }
    else
    {
      bool = false;
      i1 = 1;
    }
    a(paramInt1, paramInt2, paramIntent, bool, i1);
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramInt, paramDialog);
  }
  
  public final void a(int paramInt, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt, paramMsgSendCostParams, paramLong);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
      if (localObject != null)
      {
        ((SystemBarCompact)localObject).setStatusBarDrawable(null);
        ((SystemBarCompact)localObject).setStatusBarColor(paramInt);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      return;
    }
    if (paramBoolean2) {
      return;
    }
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    paramBoolean2 = false;
    paramBoolean1 = false;
    Object localObject2;
    if ((i1 != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1))
    {
      localObject2 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      }
      if (localObject1 != null)
      {
        if (paramInt == 2)
        {
          ((ExtensionInfo)localObject1).isDataChanged = true;
          return;
        }
        if (!((ExtensionInfo)localObject1).isDataChanged)
        {
          if (((ExtensionInfo)localObject1).audioPanelType != paramInt) {
            paramBoolean1 = true;
          }
          ((ExtensionInfo)localObject1).isDataChanged = paramBoolean1;
        }
        ((ExtensionInfo)localObject1).audioPanelType = paramInt;
      }
    }
    else
    {
      localObject2 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
      }
      if (localObject1 != null)
      {
        if (paramInt == 2)
        {
          ((NoC2CExtensionInfo)localObject1).isDataChanged = true;
          return;
        }
        if (!((NoC2CExtensionInfo)localObject1).isDataChanged)
        {
          paramBoolean1 = paramBoolean2;
          if (((NoC2CExtensionInfo)localObject1).audioPanelType != paramInt) {
            paramBoolean1 = true;
          }
          ((NoC2CExtensionInfo)localObject1).isDataChanged = paramBoolean1;
        }
        ((NoC2CExtensionInfo)localObject1).audioPanelType = paramInt;
      }
    }
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(paramLong);
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isPackageExist isVivoShot=");
      ((StringBuilder)localObject).append(jdField_j_of_type_Int);
      QLog.d("vivo", 2, ((StringBuilder)localObject).toString());
    }
    if (jdField_j_of_type_Int != 0)
    {
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
      return;
    }
    Object localObject = Build.MANUFACTURER.toUpperCase();
    if ((!((String)localObject).endsWith("BBK")) && (!((String)localObject).endsWith("VIVO")))
    {
      jdField_j_of_type_Int = 2;
      return;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getApplicationInfo(paramString, 8192);
      jdField_j_of_type_Int = 1;
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      jdField_j_of_type_Int = 2;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append(" isPackageExist isScrollToButtom=");
      paramContext.append(this.jdField_b_of_type_JavaLangBoolean);
      QLog.d("vivo", 2, paramContext.toString());
    }
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130851069, 2130851070);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    a(true, false);
    b(paramIntent);
    a(false);
    h();
    this.jdField_d_of_type_Boolean = c();
    this.jdField_e_of_type_Boolean = b();
    i(paramIntent);
    e(paramIntent);
    m();
    j();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.a(paramIntent);
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int i1 = paramIntent.getIntExtra(AlbumConstants.h, -1);
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleRequest requestCode ");
      localStringBuilder.append(i1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((i1 == 2) || (i1 == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.b(paramIntent);
    }
    if (paramInt == 1)
    {
      FriendHotTipsBar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    if ((paramInt == 2) && (!this.A)) {
      FriendHotTipsBar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onConfigurationChanged");
    }
    N();
    if (paramConfiguration.orientation == 2) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7B", "0X8005C7B", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(19);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramConfiguration);
  }
  
  public void a(Drawable paramDrawable)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
      if (localObject != null) {
        ((SystemBarCompact)localObject).setStatusBarDrawable(paramDrawable);
      }
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle(paramBundle));
    a(localIntent, false);
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    if (!this.z)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject1 != null)
      {
        Object localObject2 = (ISpriteScriptManager)((QQAppInterface)localObject1).getRuntimeService(ISpriteScriptManager.class, "all");
        localObject1 = ((ISpriteScriptManager)localObject2).getUIHandler();
        localObject2 = ((ISpriteScriptManager)localObject2).getSpriteContext();
        if ((localObject1 != null) && (localObject2 != null))
        {
          if (QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowHeightSwitch", 0) == 0)
          {
            ((ISpriteUIHandler)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            return;
          }
          if (((ISpriteUIHandler)localObject1).a(paramMotionEvent, this.jdField_a_of_type_AndroidWidgetRelativeLayout)) {
            ((ISpriteUIHandler)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public void a(View paramView) {}
  
  protected void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (paramImageView != null)
    {
      if (this.x)
      {
        paramImageView.setImageResource(paramInt2);
        return;
      }
      paramImageView.setImageResource(paramInt1);
    }
  }
  
  public void a(ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(paramSendMsgParams);
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    paramApolloInfo.send(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    AioAnimationDetector.a().a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start del anim,uniseq is:");
      localStringBuilder.append(paramChatMessage.uniseq);
      localStringBuilder.append(",id is:");
      localStringBuilder.append(paramChatMessage.getId());
      localStringBuilder.append(",time is:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Q.msg.delmsg", 2, localStringBuilder.toString());
    }
    long l1 = System.currentTimeMillis();
    ThreadManager.post(new BaseChatPie.27(this, paramChatMessage), 8, null, true);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("removeMsgByMessageRecord cost time is:");
      paramChatMessage.append(l2 - l1);
      QLog.d("Q.msg.delmsg", 2, paramChatMessage.toString());
    }
  }
  
  public final void a(ChatMessage paramChatMessage, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)a(15);
    if (!localAIOLongShotHelper.a())
    {
      int i4 = 1;
      if (AIOUtils.a(1) == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        paramChatMessage = MultiMsgManager.a().jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        int i3 = 0;
        boolean bool1 = false;
        i1 = 1;
        boolean bool2;
        int i2;
        do
        {
          do
          {
            bool2 = bool1;
            i2 = i1;
            if (!paramChatMessage.hasNext()) {
              break;
            }
            paramCompoundButton = (Map.Entry)paramChatMessage.next();
          } while (!((Boolean)paramCompoundButton.getValue()).booleanValue());
          i3 += 1;
          paramCompoundButton = (ChatMessage)paramCompoundButton.getKey();
          bool2 = bool1 | ((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramCompoundButton);
          if (MultiMsgProxy.a(paramCompoundButton))
          {
            i2 = i1;
            if (i3 <= 1) {}
          }
          else
          {
            i2 = 0;
          }
          bool1 = bool2;
          i1 = i2;
        } while (i2 != 0);
        if (!bool2) {
          i1 = i4;
        } else {
          i1 = 0;
        }
        ((AIOMultiActionHelper)a(66)).a(i1 & i2);
      }
      int i1 = MultiMsgManager.a().c();
      ((SelectToBottomHelper)a(40)).a(i1);
    }
    else
    {
      localAIOLongShotHelper.a(paramChatMessage, paramCompoundButton, paramBoolean);
    }
    ((AIOMultiActionHelper)a(66)).c();
  }
  
  protected void a(String paramString)
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new BaseChatPie.7(this, paramString1, paramString3, paramString2));
  }
  
  public void a(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramList, false);
    e(196613);
  }
  
  void a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      String str1 = a(paramList, paramMessageRecord);
      if (QLog.isColorLevel())
      {
        String str2 = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sessionInfo.curType = ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localStringBuilder.append(", mr = null ? ");
        boolean bool;
        if (paramMessageRecord == null) {
          bool = true;
        } else {
          bool = false;
        }
        localStringBuilder.append(bool);
        localStringBuilder.append("，mr.type = ");
        if (paramMessageRecord == null) {
          paramMessageRecord = "null";
        } else {
          paramMessageRecord = Integer.valueOf(paramMessageRecord.istroop);
        }
        localStringBuilder.append(paramMessageRecord);
        localStringBuilder.append(", newList.size() = ");
        localStringBuilder.append(paramList.size());
        QLog.d(str2, 2, localStringBuilder.toString());
      }
      if (str1 != null)
      {
        a(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
        a(str1);
        if (jdField_a_of_type_Boolean) {
          this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(str1);
        }
      }
      else
      {
        a(false);
      }
    }
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    a(paramList, paramCharSequence, 0);
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramList, paramCharSequence, paramInt);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.C = paramBoolean;
    if ((paramBoolean) && (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
      return;
    }
    if ((!paramBoolean) && (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    }
  }
  
  public void a(boolean paramBoolean, Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(paramBoolean, paramContext, paramView);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    a(paramBoolean1, paramChatMessage, paramBoolean2, false);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramBoolean1, paramChatMessage, paramBoolean2, paramBoolean3, false);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((BaseChatItemLayout.jdField_a_of_type_Boolean == paramBoolean1) && (!paramBoolean4))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 4, "setLeftCheckBoxVisible visible is not change so no need change");
      }
      return;
    }
    if (paramBoolean1)
    {
      BaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$OnChatMessageCheckedChangeListener = this;
      this.G = true;
    }
    else
    {
      BaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$OnChatMessageCheckedChangeListener = null;
    }
    BaseChatItemLayout.jdField_a_of_type_Boolean = paramBoolean1;
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)a(15);
    if (!paramBoolean3)
    {
      if (!localAIOLongShotHelper.a()) {
        MultiMsgManager.a().a(paramChatMessage, paramBoolean1);
      }
      a(paramChatMessage, null, paramBoolean1);
    }
    if ((!paramBoolean1) && (!paramBoolean3))
    {
      a(localAIOLongShotHelper);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      Q();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 0)
      {
        V();
        this.jdField_g_of_type_Boolean = true;
      }
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
      {
        paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_Int = paramChatMessage.bottomMargin;
        }
      }
      paramChatMessage = this.jdField_h_of_type_AndroidWidgetTextView;
      if (paramChatMessage != null) {
        paramChatMessage.setVisibility(8);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.F) {
        MultiMsgManager.a().a();
      }
    }
    if (!paramBoolean2) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramBoolean1, paramBoolean2);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(paramInt);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      return true;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramMotionEvent);
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    if (this.jdField_c_of_type_AndroidViewViewGroup == null)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "mAIORootView == null");
      ChatFragment localChatFragment = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getChatFragment();
      if (localChatFragment != null) {
        this.jdField_c_of_type_AndroidViewViewGroup = localChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      }
      if (this.jdField_c_of_type_AndroidViewViewGroup == null)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "root view is still null");
        return false;
      }
    }
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a();
    d();
    this.jdField_c_of_type_Int = 2;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnCreate", hashCode(), this.jdField_c_of_type_Int);
    c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    StartupTracker.a("AIO_updateSession", "AIO_doOnCreate_otherCost");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    BaseActivity.sActivityRoute.add(getClass().getSimpleName());
    O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ChatActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    StartupTracker.a("AIO_doOnCreate_otherCost", "AIO_doOnCreate_handleRequest");
    if (paramBoolean) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), 1);
    } else {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), 2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.a();
    StartupTracker.a("AIO_doOnCreate_handleRequest", null);
    return true;
  }
  
  public void aa()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1))
      {
        if (i())
        {
          localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
          if ((localObject != null) && (((ExtensionInfo)localObject).isDataChanged)) {
            ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          }
        }
      }
      else
      {
        localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
        if ((localObject != null) && (((NoC2CExtensionInfo)localObject).isDataChanged)) {
          ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        }
      }
    }
  }
  
  public void ab()
  {
    if (((ChatPieSelectableHelper)a(4)).b()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if (localObject != null)
      {
        int i1 = ((ChatXListView)localObject).getLastVisiblePosition();
        int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount() + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onOverScrollTargetValue isScrollToButtom=");
          ((StringBuilder)localObject).append(this.w);
          ((StringBuilder)localObject).append("lastPosition=");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append("toLast=");
          ((StringBuilder)localObject).append(i2);
          QLog.d("MyOnGestureListener", 2, ((StringBuilder)localObject).toString());
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout;
        if ((localObject != null) && (((InputLinearLayout)localObject).getVisibility() == 0) && (i1 == i2) && (this.w))
        {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004454", "0X8004454", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void ac()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onEventComplite");
    }
    this.E = true;
  }
  
  public void ad()
  {
    a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  public void ae()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
  }
  
  public void af() {}
  
  public void ag()
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("power")).newWakeLock(536870918, this.jdField_b_of_type_JavaLangString);
    }
    if (!this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "remainScreenOn");
    }
  }
  
  public void ah()
  {
    PowerManager.WakeLock localWakeLock = this.jdField_a_of_type_AndroidOsPowerManager$WakeLock;
    if ((localWakeLock != null) && (localWakeLock.isHeld()))
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "cancelRemainScreenOn");
    }
  }
  
  public void ai()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b();
  }
  
  protected void aj()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((localObject != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      if (localNavBarAIO == null) {
        return;
      }
      localNavBarAIO.a((SessionInfo)localObject);
      if (this.jdField_g_of_type_Boolean)
      {
        localObject = this.jdField_h_of_type_AndroidWidgetTextView;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void ak()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
  }
  
  public void al()
  {
    MediaPlayerManager localMediaPlayerManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
    if (localMediaPlayerManager != null)
    {
      localMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
      ((AudioPanelAioHelper)a(128)).b(false, false);
    }
  }
  
  public void am()
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if (localObject != null)
      {
        ((XEditTextEx)localObject).requestFocus();
        InputMethodUtil.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_e_of_type_AndroidWidgetTextView.getText().toString());
        ((StringBuilder)localObject).append(" ");
        localObject = ((StringBuilder)localObject).toString();
        int i1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
        Editable localEditable = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
        if ((i1 >= 0) && (i1 < localEditable.length()))
        {
          localEditable.insert(i1, (CharSequence)localObject);
          return;
        }
        localEditable.append((CharSequence)localObject);
      }
    }
  }
  
  public void an()
  {
    ChatAdapter1 localChatAdapter1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    if (localChatAdapter1 != null) {
      localChatAdapter1.notifyDataSetChanged();
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
  }
  
  public AIOContext b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  }
  
  public TipsController b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController;
  }
  
  @Deprecated
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper = new BaseChatpieHelper(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager = new PanelManager(this.jdField_a_of_type_AndroidContentContext);
    PanelRegistry.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager);
  }
  
  public void b(int paramInt)
  {
    paramInt = Math.max(paramInt, 0);
    Object localObject1 = (LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367418);
    Object localObject2 = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
    if (paramInt != ((LinearLayout.LayoutParams)localObject2).bottomMargin)
    {
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramInt;
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((SimpleUIAIOHelper)a(29)).d();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    if (localObject1 != null)
    {
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      paramInt += this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom();
      if (paramInt != ((RelativeLayout.LayoutParams)localObject2).bottomMargin)
      {
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramInt;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    L();
    M();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doPanelChanged newPanel=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("inputx", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (IApolloAIOHelper)a(8);
    if (localObject != null) {
      ((IApolloAIOHelper)localObject).doOnPanelChanged(paramInt1, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(paramInt1, paramInt2);
    ((IceBreakHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(10)).a(paramInt1, paramInt2);
    ((SimpleUIAIOHelper)a(29)).a(paramInt1, paramInt2);
  }
  
  public final void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c(paramLong);
  }
  
  protected void b(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_updateSession_updateTitle");
    Object localObject = paramIntent.getStringExtra("uinname");
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_b_of_type_JavaLangString, 2, "updateSession_updateTitle nick == null");
      }
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSession_updateTitle curFriendNick");
      localStringBuilder.append(MessageRecordUtil.a(paramIntent));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    ((SessionInfo)localObject).jdField_d_of_type_JavaLangString = paramIntent;
    if (((SessionInfo)localObject).jdField_d_of_type_JavaLangString != null)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        paramIntent = this.jdField_e_of_type_AndroidWidgetTextView.getText();
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
      }
    }
    else
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "updateSession_updateTitle sessionInfo.curFriendNick == null");
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    StartupTracker.a("AIO_updateSession_updateTitle", null);
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramMotionEvent);
  }
  
  protected void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = AIOUtils.a(paramView);
    if ((paramView instanceof ShortVideoItemBuilder.Holder))
    {
      ((ShortVideoItemBuilder.Holder)paramView).a();
      return;
    }
    if ((paramView instanceof ShortVideoRealItemBuilder.Holder))
    {
      ((ShortVideoRealItemBuilder.Holder)paramView).a();
      return;
    }
    if ((paramView instanceof TextItemBuilder.Holder))
    {
      paramView = (TextItemBuilder.Holder)paramView;
      if (paramView.a != null) {
        paramView.a.d();
      }
    }
    else if ((paramView instanceof MixedMsgItemBuilder.MixedHolder))
    {
      paramView = (MixedMsgItemBuilder.MixedHolder)paramView;
      if (paramView.a != null) {
        paramView.a.d();
      }
    }
    else if ((paramView instanceof LongMsgItemBuilder.Holder))
    {
      paramView = (LongMsgItemBuilder.Holder)paramView;
      if (paramView.a != null) {
        paramView.a.d();
      }
    }
    else if ((paramView instanceof IApolloItemBuilder.Holder))
    {
      ((IApolloItemBuilder.Holder)paramView).a();
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage) + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("pos is:");
      paramChatMessage.append(i1);
      QLog.d("Q.msg.delmsg", 2, paramChatMessage.toString());
    }
    if (i1 < 0) {
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("horMoveView is null,childIndex is:");
      paramChatMessage.append(i1 - i2);
      paramChatMessage.append(",firstPos is:");
      paramChatMessage.append(i2);
      paramChatMessage.append(",pos is:");
      paramChatMessage.append(i1);
      QLog.d("Q.msg.delmsg", 2, paramChatMessage.toString());
    }
    e(196613);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = LBSHandler.a(this.jdField_a_of_type_AndroidContentContext, paramString, new BaseChatPie.29(this), null);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365639)).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131694583));
    }
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (!localDialog.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
    {
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644)).setText(paramString);
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  @TargetApi(13)
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_m_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getRequestedOrientation();
      int i4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation;
      paramBoolean = VersionUtils.b();
      int i1 = 0;
      int i2 = 0;
      int i3 = 1;
      Object localObject;
      if (!paramBoolean)
      {
        if (i4 == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          i1 = i3;
          if (VersionUtils.c()) {
            i1 = 7;
          }
          ((BaseActivity)localObject).setRequestedOrientation(i1);
          return;
        }
        if (i4 == 2)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          i1 = i2;
          if (VersionUtils.c()) {
            i1 = 6;
          }
          ((BaseActivity)localObject).setRequestedOrientation(i1);
        }
      }
      else
      {
        if (VersionUtils.f())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay();
          i2 = ((Display)localObject).getRotation();
          Point localPoint = new Point();
          ((Display)localObject).getSize(localPoint);
          if ((i2 != 0) && (i2 != 2))
          {
            if (localPoint.x > localPoint.y)
            {
              if (i2 == 1) {
                break label230;
              }
            }
            else
            {
              if (i2 != 1) {
                break label228;
              }
              break label222;
            }
          }
          else
          {
            if (localPoint.x <= localPoint.y) {
              break label218;
            }
            if (i2 == 0) {
              break label230;
            }
          }
          i1 = 8;
          break label230;
          label218:
          if (i2 != 0) {
            label222:
            i1 = 9;
          } else {
            label228:
            i1 = 1;
          }
          label230:
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(i1);
          return;
        }
        i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getRotation();
        if ((i1 != 0) && (i1 != 1))
        {
          if ((i1 == 2) || (i1 == 3))
          {
            if (i4 == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(9);
              return;
            }
            if (i4 == 2) {
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(8);
            }
          }
        }
        else
        {
          if (i4 == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(1);
            return;
          }
          if (i4 == 2) {
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(0);
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(this.jdField_m_of_type_Int);
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public boolean b(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 4) || (paramInt == 5))
    {
      SplashActivity.sExitAIOCode = HardCoderManager.a().a(0, 1, 0, 0, 2000, 302, 8L, Process.myTid(), "exitAIO");
      SplashActivity.sExitAIOTime = SystemClock.uptimeMillis();
    }
    this.jdField_c_of_type_Int = 7;
    Object localObject1 = this.jdField_b_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("finish ");
    ((StringBuilder)localObject3).append(paramInt);
    AIOUtils.a((String)localObject1, ((StringBuilder)localObject3).toString(), hashCode(), this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramInt)) {
      return true;
    }
    if (c(paramInt)) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.b(paramInt);
    D();
    ay();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false))) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.moveTaskToBack(true);
    }
    r();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
    if (paramInt == 0)
    {
      A();
      try
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetTextView.getTag();
        localObject3 = (String[])localObject1;
        if ((localObject1 == null) || (!"comic".equals(localObject3[0]))) {
          break label340;
        }
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "2", "40025", localObject3[1], new String[] { "3" });
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    else if ((paramInt == 1) || (paramInt == 4) || (paramInt == 5))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if ((localObject2 instanceof ChatActivity)) {
        ((BaseActivity)localObject2).finish();
      } else {
        A();
      }
      localObject2 = HapticManager.a();
      if (localObject2 != null) {
        ((HapticManager)localObject2).c();
      }
    }
    label340:
    if ((this.s) && (!this.t) && (AIOUtils.o))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      this.t = true;
    }
    DuiButtonImageView.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(14);
    this.jdField_c_of_type_Int = 8;
    if (this.G) {
      a(false, null, false);
    }
    BaseChatItemLayout.jdField_a_of_type_Boolean = this.F;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, String.format("finish preCheckBoxVisible=[%b]", new Object[] { Boolean.valueOf(this.F) }));
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  @Deprecated
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "BaseChatPie";
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected void c(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updateSession");
    }
    StartupTracker.a(null, "AIO_updateSession_initIntentData");
    h(paramIntent);
    StartupTracker.a("AIO_updateSession_initIntentData", "AIO_updateSession_updateUI");
    d(paramIntent);
    a(paramIntent);
    StartupTracker.a("AIO_updateSession_updateUI", "AIO_updateSession_forwardType");
    a(paramIntent, true);
    StartupTracker.a("AIO_updateSession_forwardType", "AIO_updateSession_otherThings");
    j(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this);
    StartupTracker.a("AIO_updateSession_otherThings", null);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "AIOTime updateSession end");
    }
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.onTouchEvent(paramMotionEvent);
  }
  
  public void c(View paramView)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.addView(paramView);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "set left text from cancel");
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690707);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localObject != null) {
      ((NavBarAIO)localObject).e();
    }
    ((AIOMultiActionHelper)a(66)).a(paramChatMessage);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    localObject = (AIOLongShotHelper)a(15);
    if (((AIOLongShotHelper)localObject).a())
    {
      ((AIOLongShotHelper)localObject).d();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
    }
    this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369258).setVisibility(4);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
    if (localObject != null) {
      ((PanelIconLinearLayout)localObject).setCustomHeight(0);
    }
    a(true, paramChatMessage, false);
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramBoolean)) {
      return;
    }
    d(paramBoolean);
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Int = 2;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "preStartBaseAIO", hashCode(), this.jdField_c_of_type_Int);
    this.B = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    this.q = true;
    this.u = false;
    this.w = false;
    this.r = false;
    this.F = BaseChatItemLayout.jdField_a_of_type_Boolean;
    BaseChatItemLayout.jdField_a_of_type_Boolean = false;
    AIOUtils.a(false);
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_begin", null, false, null);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    StartupTracker.a(null, "AIO_doOnCreate_initUI");
    e();
    StartupTracker.a("AIO_doOnCreate_initUI", "AIO_doOnCreate_initData");
    f();
    StartupTracker.a("AIO_doOnCreate_initData", "AIO_updateSession");
  }
  
  protected void d(int paramInt) {}
  
  protected void d(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(3);
  }
  
  public void d(View paramView)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeView(paramView);
  }
  
  void d(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mActivity == null");
      }
      return;
    }
    if ((localBaseActivity instanceof SplashActivity))
    {
      int i1;
      if (paramBoolean) {
        i1 = 4;
      } else {
        i1 = 5;
      }
      b(i1);
      return;
    }
    localBaseActivity.finish();
  }
  
  public boolean d()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a();
    boolean bool = false;
    if (i1 != 0)
    {
      if (i1 == 1) {
        bool = true;
      }
      return bool;
    }
    return b(0);
  }
  
  public int e()
  {
    return this.jdField_c_of_type_AndroidViewViewGroup.getMeasuredHeight();
  }
  
  protected void e()
  {
    this.x = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376809));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnChangeMultiScreenListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShowChangeListener(new BaseChatPie.2(this));
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    ((XPanelContainer)localObject).jdField_c_of_type_Boolean = true;
    ((XPanelContainer)localObject).setReadyToShow(false);
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362288));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364485));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376636));
    this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376637));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378837));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378040));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369240));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369563));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379476));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369258));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369216));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369231));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376320));
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376321));
    this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369211));
    this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695359));
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("afroot: ");
      localStringBuilder.append(this.jdField_d_of_type_AndroidViewViewGroup);
      localStringBuilder.append(", mDefautlBtnLeft: ");
      localStringBuilder.append(this.jdField_c_of_type_AndroidWidgetTextView);
      localStringBuilder.append(", isThemeDefault: ");
      localStringBuilder.append(this.x);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369985).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690817));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378784));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365729));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378828));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378829));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378830));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqViewFlipper = ((QqViewFlipper)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378874));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqViewFlipper.setMeasureAllChildren(false);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378872));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378873));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131373978));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365909));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131370119));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new BaseChatPie.MyOnGestureListener(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362698));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector = new AIOFooterViewDetector(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131380356));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131372306));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setHelperProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368874));
    this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367417));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368875));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputAIOInput.a(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputAIOInput.a().b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputAIOInput.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputAIOInput.a().d();
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreInputAIOInput.a().c();
    this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
    a();
    ap();
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131373031);
      SystemDragUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject, a(), a());
    }
  }
  
  public final void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt);
  }
  
  protected void e(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.jdField_f_of_type_Boolean = true;
      ai();
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription(HardCodeUtil.a(2131701199));
    }
    else if (localObject1 != null)
    {
      this.jdField_f_of_type_Boolean = ((Bundle)localObject1).getBoolean("isBack2Root");
      if (this.jdField_f_of_type_Boolean)
      {
        ai();
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription(HardCodeUtil.a(2131701209));
      }
    }
    boolean bool1 = paramIntent.getBooleanExtra("key_jump_from_qzone_feed", false);
    boolean bool2 = paramIntent.getBooleanExtra("isFromDiscussionFlyTicket", false);
    boolean bool3 = paramIntent.getBooleanExtra("need_to_show_unread_num", false);
    if (bool2)
    {
      this.jdField_c_of_type_Boolean = true;
    }
    else
    {
      if (bool1)
      {
        localObject1 = paramIntent.getStringExtra("key_jump_from_qzone_feed_left_title");
        if (localObject1 == null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131690706);
        } else {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131717280, new Object[] { localObject1 });
        }
        this.jdField_c_of_type_Boolean = false;
        break label284;
      }
      if (!bool3) {
        break label207;
      }
      this.jdField_c_of_type_Boolean = true;
    }
    localObject1 = null;
    break label284;
    label207:
    Object localObject2 = paramIntent.getStringExtra("leftViewText");
    if ((!this.jdField_f_of_type_Boolean) && ((localObject2 == null) || (!((String)localObject2).contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131719442))))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.jdField_c_of_type_Boolean = bool1;
    localObject1 = localObject2;
    if (this.s)
    {
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
    }
    label284:
    if (this.jdField_c_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      ThreadManagerV2.excute(new BaseChatPie.8(this), 32, null, true);
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_b_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("AIOTime doOnCreate_initUI updateUnreadNumOnTitleBar cost: ");
        ((StringBuilder)localObject3).append(System.currentTimeMillis() - l1);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      localObject3 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131690706);
      } else {
        localObject2 = localObject1;
      }
      ((TextView)localObject3).setText((CharSequence)localObject2);
      ai();
    }
    Object localObject3 = paramIntent.getStringExtra("backName");
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      ai();
      localObject2 = paramIntent.getStringExtra("comicId");
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      paramIntent = (Intent)localObject2;
      if (localObject2 == null) {
        paramIntent = "";
      }
      localTextView.setTag(new String[] { "comic", paramIntent });
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回QQ动漫");
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set left text from update left: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", back: ");
      ((StringBuilder)localObject2).append((String)localObject3);
      QLog.i(paramIntent, 2, ((StringBuilder)localObject2).toString());
    }
    if (ChatActivityConstants.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131701176));
      if (!this.jdField_c_of_type_Boolean)
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        paramIntent = (Intent)localObject1;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131690529).equals(localObject1))
        {
          paramIntent = new StringBuilder();
          paramIntent.append(HardCodeUtil.a(2131701212));
          paramIntent.append((String)localObject1);
          paramIntent.append(HardCodeUtil.a(2131701178));
          paramIntent = paramIntent.toString();
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
      }
    }
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (paramIntent != null)
    {
      paramIntent.e();
      bool1 = ((AudioPanelAioHelper)a(128)).jdField_b_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(bool1 ^ true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2, paramBoolean);
  }
  
  public boolean e()
  {
    return ((this instanceof TroopChatPie)) || ((this instanceof DiscussChatPie));
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a(), this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(1);
  }
  
  protected void f(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateListUnRead: ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 0)
    {
      localObject1 = this.jdField_h_of_type_AndroidWidgetTextView;
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(Integer.toString(paramInt));
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
        break label138;
      }
    }
    if (paramInt > 0)
    {
      if (this.jdField_h_of_type_AndroidWidgetTextView == null) {
        H();
      }
      localObject2 = this.jdField_h_of_type_AndroidWidgetTextView;
      if (paramInt > 99) {
        localObject1 = "99";
      } else {
        localObject1 = Integer.toString(paramInt);
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      ((UnreadBackBottomHelper)a(53)).a();
    }
    label138:
    if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (BaseChatItemLayout.jdField_a_of_type_Boolean)) {
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected void f(Intent paramIntent)
  {
    if (ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidContentContext, paramIntent, this.jdField_a_of_type_MqqOsMqqHandler)) {
      this.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("isBack2Root", false);
    }
  }
  
  public void f(boolean paramBoolean) {}
  
  public boolean f()
  {
    return ((AudioPanelAioHelper)a(128)).b();
  }
  
  public void g()
  {
    Object localObject;
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131377646);
      ((View)localObject).setBackgroundResource(2130839086);
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(true, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131377646).setVisibility(8);
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(8);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(true);
    StartupTracker.a("AIO_SysMsgCost", "AIO_onShow_first");
    this.r = true;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    Object localObject = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShowFirst ");
    localStringBuilder.append(paramInt);
    AIOUtils.a((String)localObject, localStringBuilder.toString(), hashCode(), this.jdField_c_of_type_Int);
    AIOUtils.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    e(131072);
    g();
    r(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ThreadManager.executeOnSubThread(new BaseChatPie.19(this), true);
    }
    localObject = new BaseChatPie.20(this);
    if (AppSetting.jdField_f_of_type_Boolean) {
      ThreadManager.executeOnSubThread((Runnable)localObject, true);
    } else {
      ((Runnable)localObject).run();
    }
    K();
    if (this.z) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
    }
    i();
    DuiButtonImageView.a();
    StartupTracker.a("AIO_onShow_first", null);
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, new Object[] { Integer.valueOf(8) });
      }
      catch (Exception localException)
      {
        QLog.w(this.jdField_b_of_type_JavaLangString, 2, "disable auto fill error", localException);
      }
    }
    if (!PEPanelHelper.jdField_a_of_type_Boolean) {
      ThreadManager.executeOnSubThread(new BaseChatPie.21(this));
    }
    if (SplashActivity.sOpenAIOCode != 0)
    {
      HardCoderManager.a().a(SplashActivity.sOpenAIOCode);
      SplashActivity.sOpenAIOCode = 0;
    }
    VasShieldFont.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    UrlSecurityCheckManager localUrlSecurityCheckManager = (UrlSecurityCheckManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
    localUrlSecurityCheckManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localUrlSecurityCheckManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    av();
    aw();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(9);
  }
  
  public void g(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (!paramIntent.getBooleanExtra("click_long_screen_shot", false)) {
      return;
    }
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    if (paramIntent != null) {
      paramIntent.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatSelCurPageForLSSHelper.a();
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0;
  }
  
  protected void h() {}
  
  @TargetApi(11)
  public void h(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a(paramInt);
  }
  
  public void h(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramBoolean)
    {
      if (localObject != null)
      {
        localObject = (ChatFragment)localObject;
        if (((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        }
      }
    }
    else if (localObject != null)
    {
      localObject = (ChatFragment)localObject;
      if (((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    if (localObject != null) {
      ((ChatAdapter1)localObject).jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean h()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramMessage)) {
      return true;
    }
    e(paramMessage);
    a(paramMessage);
    b(paramMessage);
    c(paramMessage);
    d(paramMessage);
    int i1 = paramMessage.what;
    if (i1 != 42)
    {
      if (i1 != 51)
      {
        if (i1 != 54)
        {
          if (i1 != 60)
          {
            if (i1 != 64)
            {
              if (i1 != 87)
              {
                if (i1 != 56)
                {
                  if (i1 != 57) {
                    return true;
                  }
                  a(true, true);
                  return true;
                }
                c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 3);
                return true;
              }
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTypeface(VasShieldFont.a());
              return true;
            }
            af();
            return true;
          }
          a(paramMessage);
          return true;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (paramMessage.arg1 > 50))
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
          if ((localLayoutParams != null) && (localLayoutParams.bottomMargin != paramMessage.arg1))
          {
            localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramMessage.arg1);
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(localLayoutParams);
            return true;
          }
        }
      }
      else
      {
        paramMessage = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
        if (paramMessage != null)
        {
          paramMessage.a();
          return true;
        }
      }
    }
    else
    {
      boolean bool = paramMessage.getData().getBoolean("showRedDot");
      if (bool) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B00", "0X8005B00", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b(bool);
    }
    return true;
  }
  
  protected void i() {}
  
  public void i(int paramInt)
  {
    AIOAnimationConatiner localAIOAnimationConatiner = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
    if (localAIOAnimationConatiner != null) {
      localAIOAnimationConatiner.c(paramInt);
    }
    ((UnreadBackBottomHelper)a(53)).c(paramInt);
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramBoolean);
  }
  
  public boolean i()
  {
    boolean bool = false;
    int i1 = 0;
    while ((i1 < UinTypeUtil.c.length) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != UinTypeUtil.c[i1])) {
      i1 += 1;
    }
    if (i1 < UinTypeUtil.c.length) {
      bool = true;
    }
    return bool;
  }
  
  protected void j()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void j(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(paramInt);
  }
  
  public void j(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localObject != null) {
      ((XPanelContainer)localObject).setIsInMultiScreen(paramBoolean);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    if (localObject != null) {
      ((ChatAdapter1)localObject).jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean j()
  {
    return this.s;
  }
  
  public void k()
  {
    if ((BusinessUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (BusinessUtils.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void k(int paramInt)
  {
    if (jdField_j_of_type_Int == 1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVivoSetting isButtom=");
        localStringBuilder.append(paramInt);
        QLog.d("vivo", 2, localStringBuilder.toString());
      }
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.30(this, paramInt));
    }
  }
  
  public void k(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      ((CommonTextView)this.jdField_e_of_type_AndroidWidgetTextView).setMosaicEffect(new MosaicEffect(10));
      ((OnlineStatusLyricView)this.jdField_f_of_type_AndroidWidgetTextView).setMosaicEffect(new MosaicEffect(10));
      ((CommonTextView)this.jdField_g_of_type_AndroidWidgetTextView).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.jdField_e_of_type_AndroidWidgetImageView).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.jdField_f_of_type_AndroidWidgetImageView).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.jdField_g_of_type_AndroidWidgetImageView).setMosaicEffect(new MosaicEffect(10));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131366019);
      if (localObject != null) {
        ((CommonImageView)localObject).setMosaicEffect(new MosaicEffect(10));
      }
      ((CommonTextView)this.jdField_d_of_type_AndroidWidgetTextView).setMosaicEffect(new MosaicEffect(10));
      if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130850371);
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
    }
    else
    {
      ((CommonTextView)this.jdField_e_of_type_AndroidWidgetTextView).setMosaicEffect(null);
      ((OnlineStatusLyricView)this.jdField_f_of_type_AndroidWidgetTextView).setMosaicEffect(null);
      ((CommonTextView)this.jdField_g_of_type_AndroidWidgetTextView).setMosaicEffect(null);
      ((CommonImageView)this.jdField_e_of_type_AndroidWidgetImageView).setMosaicEffect(null);
      ((CommonImageView)this.jdField_f_of_type_AndroidWidgetImageView).setMosaicEffect(null);
      ((CommonImageView)this.jdField_g_of_type_AndroidWidgetImageView).setMosaicEffect(null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131366019);
      if (localObject != null) {
        ((CommonImageView)localObject).setMosaicEffect(null);
      }
      ((CommonTextView)this.jdField_d_of_type_AndroidWidgetTextView).setMosaicEffect(null);
      x();
    }
  }
  
  public boolean k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "shouldRecordPositionY ");
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (i1 == 1)
    {
      if (!((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))
      {
        this.E = false;
        return true;
      }
    }
    else {
      if ((i1 == 0) || ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() != 0))) {
        break label91;
      }
    }
    return false;
    label91:
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
      this.E = false;
    }
    return true;
  }
  
  protected void l()
  {
    if ((this.jdField_c_of_type_Boolean) && (!BaseChatItemLayout.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.post(((UnreadCountHelper)a(5)).a());
    }
  }
  
  public void l(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  public boolean l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    boolean bool;
    if (((localObject == null) || ((!((BaseActivity)localObject).isResume()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()))) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 6) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 5)) {
      bool = false;
    } else {
      bool = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (QLog.isColorLevel()))
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isActivityResume = ");
      localStringBuilder.append(bool);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850473, 2130850474);
  }
  
  public boolean m()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a();
  }
  
  protected void n()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    localSessionInfo.jdField_d_of_type_JavaLangString = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
  }
  
  protected boolean n()
  {
    return true;
  }
  
  public void o()
  {
    ((AIOEmoticonGuideHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(54)).b();
  }
  
  public boolean o()
  {
    return this.r;
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    e(paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMovedToScrapHeap(View paramView)
  {
    if (paramView == null) {
      return;
    }
    PokeItemAnimationManager.a().a(paramView);
    Object localObject1 = AIOUtils.a(paramView);
    if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
    {
      localObject1 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
      if ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
      {
        localObject1 = (MessageForStructing)((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((((MessageForStructing)localObject1).structingMsg instanceof StructMsgForGeneralShare))
        {
          Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
          if (((localObject2 instanceof ChatActivity)) || ((localObject2 instanceof SplashActivity)))
          {
            if (((StructMsgForGeneralShare)((MessageForStructing)localObject1).structingMsg).mIsPAVideoStructMsg) {
              AIOVideoPlayController.a().a(paramView, (StructMsgForGeneralShare)((MessageForStructing)localObject1).structingMsg);
            }
            localObject2 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();
            localObject1 = ((StructMsgForGeneralShare)((MessageForStructing)localObject1).structingMsg).getLayoutStr();
            if (localObject2 != null) {
              ((StructingMsgItemBuilder.ViewCache)localObject2).a((String)localObject1, (ViewGroup)paramView.findViewById(2131364521));
            }
          }
        }
      }
    }
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onNetMobile2Wifi readconfirm network change");
    }
    aF();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onNetNone2Mobile readconfirm network change");
    }
    aF();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onNetNone2Wifi readconfirm network change");
    }
    aF();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onNetWifi2Mobile readconfirm network change");
    }
    aF();
  }
  
  public void onNetWifi2None() {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(20);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    int i3 = paramInt3 - i2 - i1;
    int i4 = i3 - (paramInt1 - i2) - paramInt2;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("firstVisibleItem = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",visibleItemCount = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",totalItemCount = ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",footerCnt = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(",headerCnt = ");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(",botCnt=");
      ((StringBuilder)localObject).append(i4);
      QLog.i("BaseChatPieOnScroll", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QWalletAIOLifeCycleHelper)a(27);
    if (localObject != null) {
      ((QWalletAIOLifeCycleHelper)localObject).a(paramInt1);
    }
    a(paramInt1, paramInt2, paramInt3, i1, i2, i3, i4);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().f().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsListView.OnScrollListener)((Iterator)localObject).next()).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (this.jdField_d_of_type_Int < paramInt1)
    {
      b(this.jdField_c_of_type_AndroidViewView);
    }
    else
    {
      i1 = paramInt1 + paramInt2 - 1;
      if ((i1 < this.jdField_e_of_type_Int) && (i1 > 0)) {
        b(this.jdField_d_of_type_AndroidViewView);
      }
    }
    this.jdField_d_of_type_Int = paramInt1;
    i1 = paramInt1 + paramInt2;
    i2 = i1 - 1;
    if (i2 >= 0) {
      this.jdField_e_of_type_Int = i2;
    }
    this.jdField_c_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
    this.jdField_d_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
    ((IceBreakHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(10)).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (i1 == paramInt3) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().f();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (AppSetting.jdField_k_of_type_Boolean)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      ThreadPriorityManager.a(bool);
    }
    this.jdField_b_of_type_Int = paramInt;
    NowVideoController.a().a(paramAbsListView, paramInt);
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      ScrollPlayer.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
      URLDrawable.resume();
      if (this.p)
      {
        this.p = false;
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711697);
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711697);
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, BubbleManager.jdField_a_of_type_Long);
      }
      localObject = DropFrameMonitor.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("list_aio_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((DropFrameMonitor)localObject).a(localStringBuilder.toString(), false);
      DuiButtonImageView.d();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b() == 0) {
        AIOSingleReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      }
      ((UrlSecurityCheckManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(18);
    }
    else
    {
      ScrollPlayer.a(true);
      if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
      }
      URLDrawable.pause();
      localObject = DropFrameMonitor.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("list_aio_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((DropFrameMonitor)localObject).a(localStringBuilder.toString());
      DuiButtonImageView.c();
      ((UrlSecurityCheckManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER)).a();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().f().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsListView.OnScrollListener)((Iterator)localObject).next()).onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(16);
    } else if (paramInt == 2) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(17);
    }
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().f();
    }
  }
  
  public void onScrollToButtom(int paramInt)
  {
    if (paramInt < 0)
    {
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(true);
      k(1);
      this.w = true;
      UnreadBackBottomHelper localUnreadBackBottomHelper = (UnreadBackBottomHelper)a(53);
      if (localUnreadBackBottomHelper != null) {
        localUnreadBackBottomHelper.a(paramInt);
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 == 0)
    {
      Object localObject = (StickerRecHelper)a(14);
      if ((localObject != null) && (((StickerRecHelper)localObject).a()))
      {
        ((StickerRecHelper)localObject).b();
        localObject = (IApolloAIOHelper)a(8);
        if (localObject != null) {
          ((IApolloAIOHelper)localObject).showApolloView(true);
        }
        localObject = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(52);
        if (localObject != null) {
          ((AIOShortcutBarHelper)localObject).c(12);
        }
      }
    }
    ((FastImageHelper)a(83)).b(true);
    o();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramView, paramMotionEvent)) {
      return true;
    }
    int i2 = paramView.getId();
    if (i2 != 2131368874)
    {
      if (i2 != 2131370119) {
        return false;
      }
      ((AIOZhituHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(116)).a();
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramMotionEvent);
      }
      if (i1 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(false);
      } else if ((i1 == 1) || (i1 == 3)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(true);
      }
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return false;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.onTouch(paramView, paramMotionEvent);
    return false;
  }
  
  @TargetApi(11)
  public void p()
  {
    if (this.B)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doOnDestroy return");
      }
      return;
    }
    this.B = true;
    URLDrawable.resume();
    this.jdField_c_of_type_Int = 9;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnDestroy", hashCode(), this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(0, 0L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.b();
    ar();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
    if (localObject != null) {
      ((TipsManager)localObject).b();
    }
    P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().e();
    localObject = (IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
    ((IEmoticonManagerService)localObject).saveRecentEmotionToDB();
    ((IEmoticonManagerService)localObject).saveEmotionKeywordToDB();
    au();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ChatActivity.class);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
    if (localObject != null) {
      ((AIOAnimationConatiner)localObject).b();
    }
    ChatActivityUtils.b();
    ChatActivityFacade.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.c();
    at();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    localObject = this.jdField_h_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.b();
    if (AITranslator.a()) {
      AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().b();
    AioAnimationDetector.a().a();
    ThridAppShareHelper.a().a();
    Scroller.b(true);
    ((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class)).clearAIORequests();
    com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.jdField_a_of_type_Long = 0L;
    if (jdField_j_of_type_Int == 1) {
      k(0);
    }
    ChatActivityUtils.a();
    ThreadPriorityManager.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache.a();
    NowVideoController.a().c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().f();
    as();
    BaseActivity.sActivityRoute.remove(getClass().getSimpleName());
    localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if (localObject != null) {
      ((AIOAnimationControlManager)localObject).c();
    }
    AIOSingleReporter.a().a();
    ah();
    HotPicPageView.c();
    PresenceInterfaceImpl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    QIMUserManager.a().a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(15);
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(null);
    }
    UniteGrayTipUtil.b();
    VasUtils.a();
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_d_of_type_AndroidViewView = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    if (a())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      if (localObject != null) {
        ((QQBlurView)localObject).c();
      }
    }
    localObject = this.jdField_f_of_type_AndroidWidgetTextView;
    if ((localObject instanceof OnlineStatusLyricView)) {
      ((OnlineStatusLyricView)localObject).d();
    }
  }
  
  public boolean p()
  {
    return this.jdField_a_of_type_ComTencentWidgetPatchedButton.isEnabled();
  }
  
  @Deprecated
  public void q()
  {
    PokeItemHelper.a();
    PokeItemHelper.b();
    PokeItemAnimationManager.a().a();
    b(1);
  }
  
  public boolean q()
  {
    return OneWayFriendHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void r()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    String str = localIntent.getStringExtra("key_nearby_qzone_to_aio");
    if ((str != null) && (str.equals("nearby_qzone_to_aio")))
    {
      str = localIntent.getStringExtra("uin");
      localIntent.putExtra("key_has_talk", LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, localIntent);
    }
  }
  
  public boolean r()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.s();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
  }
  
  public boolean s()
  {
    return (this.jdField_c_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null);
  }
  
  public void t()
  {
    this.jdField_c_of_type_Int = 3;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnStart", hashCode(), this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(5);
  }
  
  public void u()
  {
    this.jdField_c_of_type_Int = 6;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnStop", hashCode(), this.jdField_c_of_type_Int);
    this.jdField_l_of_type_Boolean = false;
    XPanelContainer localXPanelContainer = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if ((localXPanelContainer != null) && (localXPanelContainer.a() == 1)) {
      N();
    }
    aa();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().setSoftInputMode(32);
      }
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, localException, new Object[0]);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject != null) && (((BaseActivity)localObject).getIntent() != null))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("uintype", -1);
      IReadInJoySPEventReport localIReadInJoySPEventReport = (IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
      if (localObject != null) {
        localObject = ((ChatAdapter1)localObject).a();
      } else {
        localObject = null;
      }
      localIReadInJoySPEventReport.addAioEnterAndOutInfo(0, (List)localObject, str, i1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a());
    }
    ShortVideoItemBuilder.g();
    ShortVideoRealItemBuilder.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(12);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (a(paramObject)) {
      return;
    }
    if ((paramObject instanceof MessageRecord))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramObject);
      return;
    }
    if ((paramObject instanceof RefreshMessageContext))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramObject);
      return;
    }
    if ((paramObject instanceof BaseQQMessageFacade.MessageNotifyParam)) {
      a(paramObject);
    }
  }
  
  public void v()
  {
    this.jdField_c_of_type_Int = 5;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnPause", hashCode(), this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().f();
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    ApngImage.pauseByTag(0);
    ((FastImageHelper)a(83)).b(true);
    ThreadManager.post(new BaseChatPie.10(this), 5, null, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b()) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if (localObject != null) {
      ((ChatXListView)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
    if (localObject != null) {
      ((AIOAnimationConatiner)localObject).b(0);
    }
    this.jdField_l_of_type_Boolean = false;
    if (this.D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.D = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(11);
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
    }
  }
  
  protected void w()
  {
    StartupTracker.a(null, "AIO_doOnResume_updateUI");
    ((SimpleUIAIOHelper)a(29)).a(this.jdField_a_of_type_AndroidWidgetTextView);
    x();
    if ((this.jdField_a_of_type_ComTencentWidgetPatchedButton != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().c();
    }
    StartupTracker.a("AIO_doOnResume_updateUI", null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a(0);
    aj();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(7);
    if (a())
    {
      QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIO.");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localStringBuilder.append(".");
      localStringBuilder.append(MsfSdkUtils.getShortUin(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      localQQBlurView.setDebugTag(localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    }
  }
  
  public void x()
  {
    AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
    if ((localAIOLongShotHelper != null) && (localAIOLongShotHelper.a()) && (localAIOLongShotHelper.b()))
    {
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, "loadBackgroundAsync: skip for mosaic is on");
      return;
    }
    ThreadManager.postImmediately(new BaseChatPie.13(this), null, true);
  }
  
  public void y()
  {
    this.jdField_c_of_type_Int = 4;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnResume", hashCode(), this.jdField_c_of_type_Int);
    w();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.q)
    {
      AIOUtils.a(true);
      this.r = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        PAStartupTracker.a(null, "pubAcc_structMsg_display", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      synchronized (QQMessageFacade.a)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(true);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 800L);
      }
    }
    e(131072);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onShow right now");
    }
    K();
    this.q = false;
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isInited()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    }
    this.D = false;
    ??? = (AudioPanelAioHelper)a(128);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, (MediaPlayerManager.Listener)???);
    NowVideoController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    QQLSRecentManager.jdField_f_of_type_Boolean = true;
    ThreadRegulator.a().a(1, 1500L);
    k(((AIOLongShotHelper)a(15)).c());
    ((SimpleUIAIOHelper)a(29)).a(a());
  }
  
  public void z()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(6);
    AIOUtils.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c(false);
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().d();
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    this.jdField_j_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.n = true;
    this.o = true;
    this.p = false;
    this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.w = false;
    this.A = true;
    this.E = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.r = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
    if (localObject != null) {
      ((TipsManager)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
    if (localObject != null)
    {
      ((XPanelContainer)localObject).c();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie
 * JD-Core Version:    0.7.0.1
 */