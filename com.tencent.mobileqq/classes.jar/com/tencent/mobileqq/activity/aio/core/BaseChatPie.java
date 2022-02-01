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
import com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI;
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
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.PanelIconCallback;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.GuildOneClickJumpMsgFilter;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.OneClickJumpMsgFilter;
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
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
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
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.util.SystemDragUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.BlurUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SimpleModeHelper;
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
import com.tencent.mobileqq.widget.QQBlur.BackgroundViewDirtyListener;
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
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
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
import org.jetbrains.annotations.NotNull;

public class BaseChatPie
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, ChatActivityConstants, BaseChatItemLayout.OnChatMessageCheckedChangeListener, PanelIconLinearLayout.PanelIconCallback, IChatWindow, CheckPttListener, ChatXListView.OnBottomOverScrollListener, INetInfoHandler, AbsListView.OnScrollButtomListener, AbsListView.OnScrollListener, AbsListView.RecyclerListener, XPanelContainer.OnChangeMultiScreenListener, XPanelContainer.PanelCallback, Observer
{
  public static int bh = 30;
  private static int bn;
  protected ImageView A;
  protected TextView B;
  public TextView C;
  public ImageView D;
  public ImageView E;
  public ImageView F;
  public ImageView G;
  public ImageView H;
  public TextView I;
  public TextView J;
  public QqViewFlipper K;
  protected ImageView L;
  protected CharSequence M = null;
  protected ImageView N;
  protected ImageView O;
  protected boolean P = true;
  protected boolean Q = false;
  protected ViewStub R;
  protected View S;
  protected View T;
  public ChatXListView U;
  public ChatAdapter1 V;
  public PanelIconLinearLayout W;
  public InputLinearLayout X;
  public XEditTextEx Y;
  public PatchedButton Z;
  boolean aA = false;
  protected String aB = "";
  protected boolean aC;
  public boolean aD = false;
  protected int aE = -1;
  protected boolean aF = false;
  protected boolean aG = false;
  public ApolloInfo aH;
  public boolean aI = false;
  public boolean aJ = false;
  public boolean aK = false;
  public boolean aL;
  public ImageView aM;
  public boolean aN = false;
  public boolean aO;
  public View aP;
  public View aQ;
  public int aR;
  public int aS;
  protected boolean aT = true;
  public AIOAnimationConatiner aU;
  public AIOFooterViewDetector aV;
  protected View aW;
  protected TipsManager aX;
  public boolean aY = false;
  public ViewGroup aZ;
  protected boolean aa = false;
  protected boolean ab;
  public AtomicBoolean ac = new AtomicBoolean(false);
  protected TextView ad;
  protected PanelManager ae;
  public QQProgressDialog af;
  public QQProgressDialog ag;
  public SessionInfo ah = new SessionInfo();
  protected float ai;
  public boolean aj = false;
  public boolean ak = false;
  protected FriendListHandler al;
  boolean am = false;
  boolean an = false;
  public QQProgressDialog ao;
  public boolean ap = false;
  protected boolean aq = false;
  boolean ar = false;
  public volatile boolean as = false;
  public QQMapActivityProxy at;
  public AioTips au;
  boolean av = true;
  boolean aw = true;
  int ax = 0;
  final StructingMsgItemBuilder.ViewCache ay = new StructingMsgItemBuilder.ViewCache();
  int az = 0;
  private Handler bA = new Handler(ThreadManager.getRecentThreadLooper());
  private int bB;
  private BroadcastReceiver bC = new BaseChatPie.15(this);
  private RoamSettingObserver bD = new BaseChatPie.22(this);
  private FriendListObserver bE = new BaseChatPie.23(this);
  private ConfigObserver bF = new BaseChatPie.24(this);
  private CardObserver bG = new BaseChatPie.25(this);
  private final ProfileCardObserver bH = new BaseChatPie.26(this);
  private ExtensionInfo bI;
  private NoC2CExtensionInfo bJ;
  private GestureDetector bK;
  public ViewGroup ba;
  public QQBlurView bb;
  protected View bc;
  public QQBlurView bd;
  public Dialog be;
  public boolean bf;
  FontBubbleManager.FontBubbleObserver bg;
  private int bi = 0;
  private Boolean bj = Boolean.valueOf(true);
  private boolean bk = false;
  private int bl = 0;
  private int bm = 1;
  private Boolean bo = Boolean.valueOf(false);
  private int bp = -1;
  private boolean bq = true;
  private int br = 0;
  private PowerManager.WakeLock bs;
  private long bt;
  private boolean bu = false;
  private boolean bv = false;
  private MediaPlayerManager bw;
  private Runnable bx;
  private Runnable by = new BaseChatPie.1(this);
  private long bz;
  public String c = "BaseChatPie";
  public QQAppInterface d;
  public Context e;
  public BaseActivity f;
  protected HelperProvider g;
  protected BaseChatpieHelper h;
  protected final AIOContext i;
  protected final MsgList j;
  protected final TipsController k;
  protected final AIOInput l;
  protected final MqqHandler m = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  protected XPanelContainer n;
  protected RelativeLayout o;
  public NavBarAIO p;
  protected ViewGroup q;
  protected ViewGroup r;
  protected TextView s;
  protected TextView t;
  protected ImageView u;
  public FrameLayout v;
  protected ImageView w;
  protected TextView x;
  protected ImageView y;
  protected RelativeLayout z;
  
  public BaseChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    h();
    this.d = paramQQAppInterface;
    this.aZ = paramViewGroup;
    this.f = paramBaseActivity;
    this.e = paramContext;
    this.g = b();
    this.i = d();
    a(paramQQAppInterface, paramBaseActivity);
    this.j = e();
    this.k = f();
    this.l = c();
  }
  
  private void a()
  {
    this.l.d().k();
    bz();
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
    case 20001: 
      QQToast.makeText(this.e, 2, 2131891019, 1).show();
      return;
    case 9011: 
      h(paramIntent);
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
        ChatActivityFacade.a(this.d, this.e, this.ah, paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"), false, true, paramIntent.getStringExtra(QQIndividualityUtils.d), null);
        return;
      }
      break;
    case 21: 
      paramIntent.putExtra("selfSet_leftViewText", this.d.getApplication().getString(2131917002));
      a(paramIntent.getExtras());
      return;
    case 20: 
      a(true, false);
      this.f.getWindow().clearFlags(1024);
      return;
    case 18: 
      m(paramIntent);
      return;
    case 10: 
      ChatActivityUtils.a(this.d, this.f, this.ah, paramInt1, paramIntent, 10);
      return;
    case 5: 
      t(paramInt2);
    case 9009: 
      k(paramIntent);
      return;
    case 3: 
      this.h.b(paramIntent);
      return;
    case 1: 
    case 17000: 
      ((IAIOShortVideoUtil)QRoute.api(IAIOShortVideoUtil.class)).handleSysCameraResult(this.d, this.f, paramIntent, this.ah, paramInt3, paramInt1);
      return;
    case 0: 
      a(false, false);
    }
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, int paramInt3)
  {
    if (paramInt1 == 2)
    {
      this.f.setCanLock(false);
    }
    else if (paramInt1 == 4001)
    {
      EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.d.getCurrentAccountUin(), paramIntent);
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
        QLog.d(this.c, 2, "onActivityResult() REQUEST_OPEN_REACTIVE_SETTING");
      }
      bc();
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
      s(paramInt1);
    }
    b(paramInt1, paramInt2, paramIntent);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    this.h.a(paramInt1, paramInt2, paramString);
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
      if ((paramIntent.getIntExtra("uintype", -1) == 1) && (((TroopGagMgr)this.d.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramIntent.getStringExtra("uin"), true).b))
      {
        QQToast.makeText(this.d.getApp(), 2131895180, 0).show(A());
        return;
      }
      int i1 = paramIntent.getIntExtra("forward_type", 2147483647);
      this.bj = Boolean.valueOf(true);
      if (i1 == 0) {
        this.aj = true;
      } else if ((i1 == 1001) || (i1 == -4)) {
        ForwardUtils.a(this.d, this.e, this.ah, paramIntent);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i(this.c, 1, "updateSession_forwardType, postDelayed!");
      }
      this.m.postDelayed(new BaseChatPie.5(this, paramBoolean, paramIntent), 500L);
      a(false, null, false);
    }
  }
  
  private void a(FriendsManager paramFriendsManager, int paramInt1, int paramInt2)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.d(this.ah.b, false);
    paramFriendsManager = localExtensionInfo;
    if (localExtensionInfo == null) {
      if (this.bI != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "saveC2CChatInputType | mExtensionInfo != null");
        }
        paramFriendsManager = this.bI;
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
    this.bI = null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    AIOContext localAIOContext = this.i;
    localAIOContext.a = paramQQAppInterface;
    localAIOContext.c = this;
    localAIOContext.d = this.ah;
    localAIOContext.b = paramBaseActivity;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramString == null) {
        return;
      }
      if (this.ah.a == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "onUpdateFriendInfo wrong uinType");
        }
        return;
      }
      if (this.ah.a == 1034) {
        return;
      }
      if (((this.ah.a == 1006) && (paramString.equals(this.ah.g))) || (paramString.equals(this.ah.b)))
      {
        if ((this.ah.a == 1006) && (paramString.equals(this.ah.g))) {
          paramString = ContactUtils.d(this.d, paramString);
        } else if (this.ah.a == 1024) {
          paramString = CrmUtils.e(this.d, paramString);
        } else {
          paramString = ContactUtils.g(this.d, paramString);
        }
        this.ah.e = paramString;
        if (QLog.isColorLevel())
        {
          String str = this.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onUpdateFriendInfo title");
          localStringBuilder.append(MessageRecordUtil.a(paramString));
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.C.setText(this.ah.e);
        if (AppSetting.e)
        {
          paramString = this.C.getText().toString();
          this.C.setContentDescription(paramString);
          aX().setTitle(this.C.getText());
        }
      }
    }
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    if (!paramHashMap.containsKey(this.ah.b)) {
      return;
    }
    int i1 = 0;
    while (i1 < this.U.getChildCount())
    {
      paramHashMap = this.U.getChildAt(i1);
      if ((paramHashMap instanceof BaseChatItemLayout))
      {
        Object localObject = (BaseBubbleBuilder.ViewHolder)AIOUtils.b(paramHashMap);
        paramHashMap = AIOUtils.a(paramHashMap);
        if ((localObject != null) && (paramHashMap != null) && (!paramHashMap.isSendFromLocal()) && (paramHashMap.istroop != 1) && (paramHashMap.istroop != 3000) && (paramHashMap.istroop != 10013))
        {
          if ((paramHashMap.istroop != 1010) && (paramHashMap.istroop != 1001) && (paramHashMap.istroop != 10002) && (paramHashMap.istroop != 10010))
          {
            paramHashMap = FaceDrawable.getFaceDrawable(this.d, 1, paramHashMap.senderuin);
          }
          else
          {
            int i2;
            if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(paramHashMap.senderuin)) {
              i2 = 202;
            } else {
              i2 = 200;
            }
            paramHashMap = FaceDrawable.getStrangerFaceDrawable(this.d, i2, paramHashMap.senderuin, true);
          }
          localObject = (HeadIconWrapper)((BaseBubbleBuilder.ViewHolder)localObject).j.a(HeadIconWrapper.class);
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
    this.m.removeMessages(24);
    Object localObject = this.ao;
    int i1 = 1;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing()))
    {
      if (MultiMsgManager.a().e != 2) {
        this.ao.dismiss();
      }
      MultiMsgManager.a().d.clear();
      if ((paramBoolean) && (paramObject != null)) {
        MultiMsgManager.a().d.putAll((Map)paramObject);
      }
      if (MultiMsgManager.a().d.size() == 0) {
        QQToast.makeText(this.d.getApp(), 2131896472, 0).show(A());
      } else if (paramObject != null) {
        if (MultiMsgManager.a().e == 6) {
          ((MultiFavoriteHelper)this.g.a(11)).a((Map)paramObject, MultiMsgManager.a().c, MultiMsgManager.a().e);
        } else {
          ((MultiForwardHelper)this.g.a(1)).a((Map)paramObject, MultiMsgManager.a().c, MultiMsgManager.a().e);
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
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.d.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, (HashMap)localObject, "");
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      SessionInfo localSessionInfo = this.ah;
      if (localSessionInfo != null)
      {
        if (!Utils.a(paramString1, localSessionInfo.b)) {
          return;
        }
        int i1 = this.ah.a;
        if ((i1 != 1001) && (i1 != 1009) && (i1 != 1010)) {
          return;
        }
        paramString1 = this.ah;
        paramString1.e = paramString2;
        this.C.setText(paramString1.e);
        if (AppSetting.e)
        {
          paramString1 = this.C.getText().toString();
          this.C.setContentDescription(paramString1);
          aX().setTitle(this.C.getText());
        }
        if (QLog.isDevelopLevel()) {
          DatingUtil.a(this.c, new Object[] { "onGetFriendDateNick", paramString2 });
        }
      }
    }
  }
  
  private boolean a(FriendsManager paramFriendsManager)
  {
    Object localObject2 = paramFriendsManager.d(this.ah.b, false);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (!paramFriendsManager.m()) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "chooseC2CChatInputType get ExtensionInfo = null");
      }
      localObject1 = new ExtensionInfo();
      ((ExtensionInfo)localObject1).uin = this.ah.b;
      ((ExtensionInfo)localObject1).timestamp = System.currentTimeMillis();
      if (UinTypeUtil.b(this.ah.a)) {
        ((ExtensionInfo)localObject1).chatInputType = 0;
      } else {
        ((ExtensionInfo)localObject1).chatInputType = 1;
      }
      this.bI = ((ExtensionInfo)localObject1);
    }
    if (QLog.isColorLevel())
    {
      paramFriendsManager = this.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doChooseC2CInputType extInfo.chatInputType = ");
      ((StringBuilder)localObject2).append(((ExtensionInfo)localObject1).chatInputType);
      QLog.d(paramFriendsManager, 2, ((StringBuilder)localObject2).toString());
    }
    if (!AIOInputTypeHelper.b)
    {
      int i1 = ((ExtensionInfo)localObject1).chatInputType;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2) {
            return false;
          }
          paramFriendsManager = this.f;
          if ((paramFriendsManager != null) && (paramFriendsManager.getIntent().getIntExtra("enter_ext_panel", 0) == 0))
          {
            this.bl = 2;
            return false;
          }
        }
      }
      else
      {
        ((ExtensionInfo)localObject1).chatInputType = 1;
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "doChooseC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser");
        }
      }
    }
    return false;
  }
  
  private boolean a(Object paramObject)
  {
    Object localObject = this.f;
    if ((localObject instanceof SplashActivity))
    {
      if (((BaseActivity)localObject).isFinishing())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "preCheckUpdate: finished");
        }
        return true;
      }
      localObject = ((SplashActivity)this.f).getChatFragment();
      if ((localObject != null) && (!((Fragment)localObject).isVisible()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, a((Fragment)localObject));
        }
        return true;
      }
    }
    if ((paramObject == null) && (QLog.isColorLevel())) {
      QLog.d(this.c, 2, "preCheckUpdate: data is null: ");
    }
    return paramObject == null;
  }
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false)) || (paramIntent.getBooleanExtra("destroy_last_activity", false)))) || (paramInt2 == 4))
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Bundle localBundle = paramIntent.getExtras();
        Intent localIntent = new Intent(this.e, SplashActivity.class);
        AIOUtils.a(localIntent, new int[] { 2 });
        localIntent.putExtras(new Bundle(localBundle));
        this.f.startActivity(localIntent);
      }
      this.f.setResult(4, paramIntent);
    }
    if ((paramInt1 == 21) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      a(false, null, false);
    }
    this.g.a(paramInt1, paramInt2, paramIntent);
  }
  
  private void b(FriendsManager paramFriendsManager, int paramInt1, int paramInt2)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramFriendsManager.b(this.ah.b, this.ah.a, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null) {
      if (this.bJ != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "saveNoC2CChatInputType | mNoC2CExtensionInfo != null");
        }
        localNoC2CExtensionInfo1 = this.bJ;
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
    this.bJ = null;
  }
  
  private void b(Object paramObject)
  {
    paramObject = (BaseQQMessageFacade.MessageNotifyParam)paramObject;
    if ((paramObject.a.equals(this.ah.b)) && (paramObject.b == 0)) {
      a(false, true);
    }
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.U != null))
    {
      if (!(paramObject instanceof Set)) {
        return;
      }
      VasUtils.a(this.d);
      Set localSet = (Set)paramObject;
      int i1 = 0;
      int i3 = this.U.getChildCount();
      while (i1 < i3)
      {
        paramObject = this.U.getChildAt(i1);
        if ((paramObject instanceof BaseChatItemLayout))
        {
          Object localObject1 = (BaseBubbleBuilder.ViewHolder)AIOUtils.b(paramObject);
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
          Object localObject2 = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if ((localObject1 != null) && (((BaseBubbleBuilder.ViewHolder)localObject1).j != null) && (paramObject != null) && (localSet.contains(paramObject)))
          {
            localObject2 = ((FriendsManager)localObject2).x(paramObject);
            if (localObject2 != null)
            {
              Object localObject3 = Long.valueOf(((ExtensionInfo)localObject2).pendantId);
              if (((Long)localObject3).longValue() != 0L)
              {
                localObject3 = ((AvatarPendantManager)this.d.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(((Long)localObject3).longValue());
                localObject1 = ((BaseBubbleBuilder.ViewHolder)localObject1).j;
                int i2;
                if (i1 != i3) {
                  i2 = 1;
                } else {
                  i2 = 2;
                }
                ((PendantInfo)localObject3).a((View)localObject1, i2, localChatMessage.uniseq, paramObject, ((ExtensionInfo)localObject2).pendantDiyId);
              }
              else if (((BaseBubbleBuilder.ViewHolder)localObject1).j.ae != null)
              {
                ((BaseBubbleBuilder.ViewHolder)localObject1).j.ae.setImageDrawable(null);
                ((BaseBubbleBuilder.ViewHolder)localObject1).j.ae.setVisibility(8);
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
      int i1 = this.ah.a;
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
      if (paramString1.equals(this.ah.b))
      {
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          this.ah.e = paramString2;
        }
        else
        {
          paramString1 = this.ah;
          paramString1.e = ContactUtils.g(this.d, paramString1.b);
          paramString2 = this.ah;
          if (paramString2.e != null) {
            paramString1 = this.ah.e;
          } else {
            paramString1 = this.ah.b;
          }
          paramString2.e = paramString1;
        }
        if (QLog.isColorLevel())
        {
          paramString1 = this.c;
          paramString2 = new StringBuilder();
          paramString2.append("onSetComment curFriendNick");
          paramString2.append(MessageRecordUtil.a(this.ah.e));
          QLog.d(paramString1, 2, paramString2.toString());
        }
        this.C.setText(this.ah.e);
        if (AppSetting.e)
        {
          paramString1 = this.C.getText().toString();
          this.C.setContentDescription(paramString1);
          aX().setTitle(this.C.getText());
        }
      }
    }
  }
  
  private boolean b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 267387140: 
      QQProgressDialog localQQProgressDialog = this.ao;
      if (localQQProgressDialog != null)
      {
        localQQProgressDialog.dismiss();
        this.ao.c(false);
      }
      this.d.getMsgCache().b(false);
      QQToast.makeText(this.e, 2131891964, 0).show(A());
      if (paramMessage.arg1 == 1) {
        UncommonMessageProcessor.b(this.ah.b, this.ah.a, UncommonMessageProcessor.b, UncommonMessageProcessor.l);
      }
      return true;
    case 267387139: 
      paramMessage = this.ao;
      if (paramMessage != null)
      {
        paramMessage.dismiss();
        this.ao.c(false);
      }
      this.d.getMsgCache().b(false);
      return true;
    case 16711689: 
      this.j.e().a();
      return true;
    case 18: 
      a(false, false);
      return true;
    }
    k(paramMessage.arg1);
    return true;
  }
  
  private boolean b(FriendsManager paramFriendsManager)
  {
    Object localObject2 = paramFriendsManager.b(this.ah.b, this.ah.a, false);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (!paramFriendsManager.m()) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "chooseC2CChatInputType get NoC2CExtensionInfo = null");
      }
      localObject1 = new NoC2CExtensionInfo();
      ((NoC2CExtensionInfo)localObject1).type = this.ah.a;
      ((NoC2CExtensionInfo)localObject1).uin = this.ah.b;
      ((NoC2CExtensionInfo)localObject1).chatInputType = 0;
      this.bJ = ((NoC2CExtensionInfo)localObject1);
    }
    if (this.ah.a == 1) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    if (QLog.isColorLevel())
    {
      paramFriendsManager = this.c;
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
      paramFriendsManager = this.f;
      if ((paramFriendsManager != null) && (paramFriendsManager.getIntent().getIntExtra("enter_ext_panel", 0) == 0))
      {
        this.bl = 2;
        return false;
      }
    }
    else
    {
      ((NoC2CExtensionInfo)localObject1).chatInputType = 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "doChooseNoC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser ");
      }
    }
    return false;
  }
  
  private void bA()
  {
    Object localObject = this.ao;
    if (localObject != null)
    {
      ((QQProgressDialog)localObject).dismiss();
      this.ao = null;
    }
    localObject = this.be;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      this.be.dismiss();
      this.be = null;
    }
    localObject = this.af;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing()))
    {
      this.af.dismiss();
      this.af = null;
    }
  }
  
  private void bB()
  {
    this.l.d().l();
  }
  
  private void bC()
  {
    BaseChatPie.9 local9 = new BaseChatPie.9(this);
    if (AppSetting.g)
    {
      ThreadManager.executeOnSubThread(local9, true);
      return;
    }
    local9.run();
  }
  
  private void bD()
  {
    ChatXListView localChatXListView = this.U;
    if (localChatXListView != null) {
      AIOUtils.a(localChatXListView.getOverscrollHeader());
    }
  }
  
  private void bE()
  {
    XPanelContainer localXPanelContainer = this.n;
    if (localXPanelContainer != null)
    {
      localXPanelContainer.e();
      this.n.setReadyToShow(false);
    }
  }
  
  private void bF()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "showInputPanelIfNeeded() called");
    }
    Object localObject1 = aX();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Activity)localObject1).getIntent();
    if (localObject1 == null)
    {
      QLog.e(this.c, 1, "showInputPanelIfNeeded() intent == null");
      return;
    }
    boolean bool = ((Intent)localObject1).getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false);
    if (QLog.isColorLevel())
    {
      localObject2 = this.c;
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
    Object localObject2 = this.n;
    if (localObject2 == null) {
      return;
    }
    if (!((XPanelContainer)localObject2).g())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "showInputPanelIfNeeded() isReadyToShow false");
      }
      return;
    }
    aF();
    this.m.removeCallbacks(this.bx);
    this.bx = new BaseChatPie.11(this, (Intent)localObject1);
    this.m.postDelayed(this.bx, 100L);
  }
  
  private void bG()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "showPlusPanelIfNeeded() called");
    }
    Object localObject1 = aX();
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
      localObject2 = this.c;
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
    Object localObject2 = this.n;
    if (localObject2 == null) {
      return;
    }
    if (!((XPanelContainer)localObject2).g())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "showPlusPanelIfNeeded() isReadyToShow false");
      }
      return;
    }
    this.n.a(8);
    this.m.postDelayed(new BaseChatPie.12(this, (Intent)localObject1), 100L);
  }
  
  private void bH()
  {
    ChatXListView localChatXListView = this.U;
    if (localChatXListView != null) {
      localChatXListView.setSelection(localChatXListView.getAdapter().getCount() - 1);
    }
  }
  
  private void bI()
  {
    if (this.d != null) {
      this.j.e().h();
    }
  }
  
  private void bJ()
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow_videoStatus: mEnterExtPanel = ");
      localStringBuilder.append(this.bl);
      localStringBuilder.append(", mExtPanelOnResumeTimes = ");
      localStringBuilder.append(this.bm);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int i1 = this.bl;
    if (i1 != 0)
    {
      int i2 = this.bm - 1;
      this.bm = i2;
      if (i2 == 0)
      {
        if (i1 == 1) {
          this.n.post(new BaseChatPie.16(this));
        } else if (i1 == 2) {
          this.n.post(new BaseChatPie.17(this));
        }
        this.bl = 0;
      }
    }
  }
  
  private void bK()
  {
    NativeVideoImage.resumeAll();
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = PicItemBuilder.D;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    AbstractVideoImage.resumeAll();
    NowVideoController.a().b();
    this.aU.e();
    ((AvatarPendantManager)this.d.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).b();
    this.U.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onShow_updateUI: listView.setVisibility(View.VISIBLE)");
    }
    bN();
    this.Y.setOnTouchListener(this);
    if (an())
    {
      ForwardSDKB77AIOHelper.a(this.f, this.g);
      this.av = false;
    }
    if ((this.an) && (this.aw))
    {
      localObject = (ForwardIMByThirdPartyHelper)this.g.a(37);
      if (localObject != null) {
        ((ForwardIMByThirdPartyHelper)localObject).a(this.f.getIntent(), true);
      }
      this.aw = false;
    }
    Object localObject = this.d.getPreferences();
    if (((SharedPreferences)localObject).getBoolean("sdcard_related_download_failed", false))
    {
      if (!Environment.getExternalStorageState().equals("mounted")) {
        QQToast.makeText(BaseApplication.getContext(), 2131892168, 0).show(A());
      } else if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1) {
        QQToast.makeText(BaseApplication.getContext(), 2131916077, 0).show(A());
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("sdcard_related_download_failed", false);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (!this.m.hasMessages(64))
    {
      int i1 = HotReactiveHelper.a();
      this.m.sendEmptyMessageDelayed(64, i1 * 1000);
    }
  }
  
  private void bL()
  {
    Bundle localBundle = this.f.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ReportController.b(this.d, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
    }
  }
  
  private void bM()
  {
    if ((QQLSRecentManager.h) && (QQUtils.a(BaseApplication.getContext())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setReaded return : QQLSActivity is alive");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onShow_setReaded");
    }
    ThreadManager.post(this.j.e(), 8, null, false);
  }
  
  private void bN()
  {
    if (bO())
    {
      Object localObject1 = this.e.getSharedPreferences("mobileQQ", 4);
      if (((SharedPreferences)localObject1).getBoolean("FORWARD_EMOPGK_ID", false))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.f.getIntent().getExtras().getInt("FORWARD_EMOPGK_ID"));
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        ((SharedPreferences)localObject1).edit().remove("FORWARD_EMOPGK_ID").commit();
        this.bl = 3;
        localObject1 = (AIOEmoticonPanelHelper)q(104);
        if (localObject1 != null) {
          ((AIOEmoticonPanelHelper)localObject1).showEmoticonPanel((String)localObject2);
        }
      }
    }
  }
  
  private boolean bO()
  {
    if (this.e != null)
    {
      BaseActivity localBaseActivity = this.f;
      if ((localBaseActivity != null) && (localBaseActivity.getIntent() != null) && (this.f.getIntent().getExtras() != null) && (this.f.getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID"))) {
        return true;
      }
    }
    return false;
  }
  
  private void bP()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if ((this.ah != null) && (!this.aa))
    {
      localObject = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
      int i1;
      if ((this.n.getCurrentPanel() == 2) && (this.n.getCurrentPanelView() != null) && (this.n.getCurrentPanelView().getVisibility() == 0)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((this.ah.a != 3000) && (this.ah.a != 1))
      {
        if (aK()) {
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
  
  private void bQ()
  {
    if (this.j.e().g())
    {
      this.m.removeMessages(16711689);
      this.m.sendEmptyMessage(16711689);
    }
  }
  
  private void bz()
  {
    if (this.aL) {
      d(AIOUtils.b(1.0F, this.f.getResources()));
    } else {
      ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this), true);
    }
    if (this.i.p().d().c().a().getVisibility() != 0)
    {
      XEditTextEx localXEditTextEx = this.Y;
      localXEditTextEx.setPadding(localXEditTextEx.getPaddingLeft(), this.Y.getPaddingTop(), AIOUtils.b(11.0F, this.f.getResources()), this.Y.getPaddingBottom());
    }
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
    this.W.setEnable(5, true);
    this.W.setEnable(6, true);
    if (1000 == paramInt2)
    {
      paramInt1 = paramIntent.getIntExtra("click_item", 1);
      if ((paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 14)) {
        this.n.b();
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
      this.n.b();
    }
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      Object localObject = this.ah.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramObject);
      localStringBuilder.append("");
      if ((((String)localObject).equals(localStringBuilder.toString())) && (!this.f.isFinishing()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onUpdateDelFriend exit ChatActivity now uin = ");
          ((StringBuilder)localObject).append(paramObject);
          QLog.d("cardpush", 2, ((StringBuilder)localObject).toString());
        }
        f(1);
      }
    }
  }
  
  private boolean c(Message paramMessage)
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
          ChatActivityFacade.a(this, this.d, this.ah, true);
          return true;
        }
        boolean bool = SettingCloneUtil.readValue(this.d.getApp(), this.d.getAccount(), null, "pcactive_notice_key", false);
        if ((!SettingCloneUtil.readValue(this.d.getApp(), this.d.getAccount(), null, "pcactive_has_notice", false)) && (bool))
        {
          SettingCloneUtil.writeValue(this.d.getApp(), this.d.getAccount(), null, "pcactive_has_notice", true);
          paramMessage = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
          paramMessage.addFlags(268435456);
          paramMessage.putExtra("uin", this.d.getAccount());
          BaseApplicationImpl.getApplication().startActivity(paramMessage);
        }
        return true;
      }
      this.aX.c();
      return true;
    }
    ChatActivityFacade.c(this.d, this.ah, true);
    return true;
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
      int i1 = this.ah.a;
      if ((i1 != 1) && (i1 != 1008) && (i1 != 1024))
      {
        if (i1 == 1034) {
          return;
        }
        if (i1 != 3000)
        {
          if ((this.ah.b == null) || (!this.ah.b.equals(paramObject.uin))) {
            return;
          }
          E();
          if (QLog.isColorLevel())
          {
            paramObject = this.c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onCardDownload nick = ");
            localStringBuilder.append(MessageRecordUtil.a(this.ah.e));
            QLog.d(paramObject, 2, localStringBuilder.toString());
          }
          this.C.setText(this.ah.e);
          if (AppSetting.e)
          {
            paramObject = this.C.getText().toString();
            this.C.setContentDescription(paramObject);
            aX().setTitle(this.C.getText());
          }
          if ((3000 != this.ah.a) || (!(this instanceof DiscussChatPie))) {
            return;
          }
          ((DiscussChatPie)this).a(this.ah.e, this.ah.b, this.C);
          return;
        }
      }
      a(false, false);
    }
  }
  
  private boolean d(Message paramMessage)
  {
    if (paramMessage.what == 16711697)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.bz < 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "MSG_BUBBLE_CACHE_UPDATE, frequency limit, abort");
        }
        return false;
      }
      this.bz = l1;
      if (this.az != 0)
      {
        this.aA = true;
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "MSG_BUBBLE_CACHE_UPDATE, scrolling, abort");
        }
        return false;
      }
      boolean bool = VasUtils.a(this.d, this.U);
      if (QLog.isColorLevel())
      {
        paramMessage = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MSG_BUBBLE_CACHE_UPDATE, needRefresh=");
        localStringBuilder.append(bool);
        QLog.d(paramMessage, 2, localStringBuilder.toString());
      }
      if (bool) {
        j(196608);
      }
    }
    return false;
  }
  
  private void e(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131446540: 
    case 2131447534: 
      if (this.aO) {
        return;
      }
      a(paramView);
      return;
    case 2131436194: 
      if (this.ah.a == 0) {
        this.bk = true;
      }
      paramView = this.bw;
      if (paramView != null) {
        paramView.d();
      }
      B();
      paramView = ChatActivityUtils.c(this.ah.a);
      localObject = String.valueOf(NetConnInfoCenter.getServerTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report click setting: curType = ");
      localStringBuilder.append(this.ah.a);
      localStringBuilder.append(", mEntryFriendCard = ");
      localStringBuilder.append(this.bk);
      localStringBuilder.append(", reportType = ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(", strCurT = ");
      localStringBuilder.append((String)localObject);
      QLog.d("850_reportEvent", 1, localStringBuilder.toString());
      ReportController.b(this.d, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, paramView, "", (String)localObject, "");
      AIODtReportHelper.a(this.ah, (String)localObject);
      return;
    }
    if ((!this.aO) && (BaseChatItemLayout.ad))
    {
      a(false, null, false);
      if (this.ah.a == 1008)
      {
        paramView = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        ReportController.b(this.d, "dc00899", "Pb_account_lifeservice", this.ah.b, "0X80064F8", "0X80064F8", 0, 0, paramView, "", "", "");
      }
    }
    else
    {
      f(false);
    }
    try
    {
      paramView = this.s.getTag();
      localObject = (String[])paramView;
      if ((paramView != null) && ("comic".equals(localObject[0])))
      {
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.d, "3006", "2", "40025", localObject[1], new String[] { "1" });
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
          ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).showGrayTips(this.d);
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.makeText(this.d.getApp(), paramMessage, 1).show(A());
      }
      return true;
    }
    if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(0)) {
      ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(this.d, aX(), A());
    }
    return true;
  }
  
  private boolean f(Message paramMessage)
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
            Object localObject = this.ao;
            if (localObject != null)
            {
              ((QQProgressDialog)localObject).dismiss();
              QQToast.makeText(this.d.getApp(), 2131896473, 0).show(this.e.getApplicationContext().getResources().getDimensionPixelSize(2131299920));
            }
            localObject = new HashMap();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramMessage.arg1);
            localStringBuilder.append("");
            ((HashMap)localObject).put("nickCount", localStringBuilder.toString());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.d.getCurrentAccountUin(), "multiMsgNickTimeOut", false, 30000L, 0L, (HashMap)localObject, "");
            return true;
          }
          m(0);
          this.n.a(1);
          return true;
        }
        f(1);
        return true;
      }
      paramMessage = (String)paramMessage.obj;
      if (this.ah.b.equals(paramMessage)) {
        f(1);
      }
      return true;
    }
    b(paramMessage.arg1, paramMessage.arg2);
    return true;
  }
  
  private void i(Intent paramIntent)
  {
    m(0);
    this.ah.r = ChatTextSizeSettingActivity.a(this.e);
    this.Y.setTextSize(0, this.ah.r);
    String str = paramIntent.getStringExtra("input_text");
    paramIntent.removeExtra("input_text");
    if (str != null) {
      this.Y.setText(str);
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
      this.m.postDelayed(new BaseChatPie.6(this, paramIntent), 20L);
    }
    this.g.b(4);
    if (paramIntent.getIntExtra("entrance", 0) == 9)
    {
      this.aO = true;
      aA();
      return;
    }
    this.aO = false;
  }
  
  private void k(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nearby_profile_nickname");
      if ((paramIntent != null) && (!paramIntent.equals(this.ah.e)))
      {
        this.ah.e = paramIntent;
        if (QLog.isColorLevel())
        {
          String str = this.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult new nick is ");
          localStringBuilder.append(paramIntent);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        this.m.post(new BaseChatPie.14(this));
      }
    }
  }
  
  private void l(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onActivityResult() ENTER_CHATOPTION_REQUEST");
    }
    bc();
    boolean bool;
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      bool = paramIntent.getExtras().getBoolean("isNeedFinish");
    } else {
      bool = false;
    }
    if (bool) {
      f(1);
    } else {
      a(false, false);
    }
    ((HiddenChatHelper)q(39)).a(this.f.getIntent());
  }
  
  private void m(Intent paramIntent)
  {
    Object localObject1 = this.at;
    if (localObject1 != null)
    {
      ((QQMapActivityProxy)localObject1).a();
      this.at = null;
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
        localObject1 = localBundle.getString("poiId");
        Object localObject2 = localBundle.getString("latSpan");
        Object localObject3 = localBundle.getString("lngSpan");
        if ((localObject1 != null) && (localObject2 != null) && (localObject3 != null)) {
          break label172;
        }
        Object localObject4 = "";
        localObject1 = localObject4;
        localObject3 = localObject1;
        localObject2 = localObject1;
        localObject1 = localObject4;
        label172:
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("ChatActivityFacade.forwardForMap data = ");
        ((StringBuilder)localObject4).append(paramIntent.getExtras());
        QLog.d("LBS", 1, ((StringBuilder)localObject4).toString());
        ChatActivityFacade.a(this.e, this.d, this.ah, str1, str2, str3, str4, str5, str6, (String)localObject1, (String)localObject2, (String)localObject3, localBundle);
      }
    }
  }
  
  private void n(Intent paramIntent)
  {
    int i1 = ChatTextSizeSettingActivity.a(this.e);
    if (this.ah.r != i1)
    {
      paramIntent = this.ah;
      paramIntent.r = i1;
      this.Y.setTextSize(0, paramIntent.r);
    }
  }
  
  private void o(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onActivityResulte() REQUEST_OPEN_SHORT_VIDEO_PLAYER...");
    }
    a(false, false);
    try
    {
      paramIntent = paramIntent.getStringExtra("babyq_video_type");
      if (!TextUtils.isEmpty(paramIntent))
      {
        int i1 = Integer.parseInt(paramIntent);
        paramIntent = (BabyQHandler)this.d.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
        if (paramIntent != null)
        {
          paramIntent.a(i1);
          return;
        }
      }
    }
    catch (Exception paramIntent)
    {
      QLog.d(this.c, 1, "doOnActivityResult exception!", paramIntent);
    }
  }
  
  private void p(Intent paramIntent)
  {
    try
    {
      int i1 = Integer.parseInt(paramIntent.getStringExtra("babyq_video_type"));
      paramIntent = (BabyQHandler)this.d.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (paramIntent != null)
      {
        paramIntent.a(i1);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.d(this.c, 1, "doOnActivityResult exception!", paramIntent);
    }
  }
  
  private void p(boolean paramBoolean)
  {
    if ((!paramBoolean) && (aY())) {
      QQToast.makeText(this.d.getApp(), 2130839791, this.e.getString(2131917580), 0).show(A());
    }
  }
  
  private void q(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (this.ar))
    {
      int i1 = paramIntent.getInt("aio_msg_source", 999);
      paramIntent = ChatActivityUtils.c(this.ah.a);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" AIO_MSG_SOURCE : ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", reportType  = ");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.d("850_reportEvent", 1, ((StringBuilder)localObject).toString());
      localObject = String.valueOf(NetConnInfoCenter.getServerTimeMillis());
      if (this.ah.a == 1)
      {
        ReportController.b(this.d, "CliOper", "", this.ah.b, "AIO", "AIO_appear", 0, 0, paramIntent, String.valueOf(i1), (String)localObject, "");
        return;
      }
      ReportController.b(this.d, "CliOper", "", "", "AIO", "AIO_appear", 0, 0, paramIntent, String.valueOf(i1), (String)localObject, "");
      return;
    }
    QLog.d("850_reportEvent", 1, "do not need to report");
  }
  
  private void r(Intent paramIntent)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = (IApolloAIOHelper)q(8);
    if ((localObject != null) && (((IApolloAIOHelper)localObject).isApolloForward())) {
      return;
    }
    if (bO()) {
      return;
    }
    if (!((AudioPanelProvider)this.ae.f(2)).d()) {
      return;
    }
    if (s(paramIntent)) {
      return;
    }
    if ((this.ah != null) && (!this.aa))
    {
      paramIntent = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
      boolean bool2;
      if ((this.ah.a != 3000) && (this.ah.a != 1))
      {
        if (aK())
        {
          bool2 = a(paramIntent);
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break label317;
          }
          paramIntent = this.c;
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
        paramIntent = this.c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("chooseChatInputType doChooseNoC2CInputType needGuide = ");
        ((StringBuilder)localObject).append(bool2);
        QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
        bool1 = bool2;
        break label317;
      }
    }
    else if ((this.ah != null) && (QLog.isColorLevel()))
    {
      paramIntent = this.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("chooseC2CChatInputType isSimpleBar = ");
      ((StringBuilder)localObject).append(this.aa);
      QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = false;
    label317:
    ((AudioPanelProvider)this.ae.f(2)).a(false, bool1);
    if (QLog.isColorLevel())
    {
      paramIntent = this.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("chooseC2CChatInputType cost :");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void s(int paramInt)
  {
    if (paramInt == 2000) {
      ((HiddenChatHelper)q(39)).a(this.f.getIntent());
    }
  }
  
  private boolean s(Intent paramIntent)
  {
    SessionInfo localSessionInfo = this.ah;
    if ((localSessionInfo != null) && ((localSessionInfo.a == 3000) || (this.ah.a == 1)))
    {
      paramIntent = paramIntent.getStringExtra("input_text_redpacket");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, "chooseChatInputType redPacketExtra");
        }
        m(0);
        this.Y.setText(paramIntent);
        return true;
      }
    }
    return false;
  }
  
  private void t(int paramInt)
  {
    if (paramInt != -1) {
      return;
    }
    bH();
  }
  
  private boolean u(int paramInt)
  {
    this.g.b(13);
    this.j.e().b(false);
    boolean bool = c(false);
    String str;
    StringBuilder localStringBuilder;
    if ((bool) && (paramInt == 0))
    {
      if (QLog.isColorLevel())
      {
        str = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("basechatpie_finish 1,type:");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return true;
    }
    g(paramInt);
    if ((a(paramInt, bool)) && (paramInt == 0))
    {
      if (QLog.isColorLevel())
      {
        str = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("basechatpie_finish 3,type:");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  private void v(int paramInt) {}
  
  public int A()
  {
    return AIOUtils.a(this.e) + ImmersiveUtils.getStatusBarHeight(this.e);
  }
  
  public void B()
  {
    if ((BusinessUtils.c(this.ah.b)) && (BusinessUtils.a(this.e))) {
      return;
    }
    Intent localIntent = new Intent(this.e, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.ah.b);
    localIntent.putExtra("uinname", this.ah.e);
    localIntent.putExtra("uintype", this.ah.a);
    this.f.startActivityForResult(localIntent, 2000);
  }
  
  protected void C()
  {
    if ((this.Q) && (!BaseChatItemLayout.ad)) {
      this.bA.post(((UnreadCountHelper)q(5)).a());
    }
  }
  
  protected void D()
  {
    this.p.setRight1Icon(2130852269, 2130852270);
  }
  
  protected void E()
  {
    SessionInfo localSessionInfo = this.ah;
    localSessionInfo.e = ContactUtils.a(this.d, localSessionInfo.b, this.ah.c, ContactUtils.c(this.ah.a), 3);
  }
  
  public int F()
  {
    return this.ah.a;
  }
  
  protected void G()
  {
    TextView localTextView = this.C;
    float f1;
    if (QQTheme.isNowSimpleUI()) {
      f1 = 16.0F;
    } else {
      f1 = 17.0F;
    }
    localTextView.setTextSize(1, f1);
  }
  
  protected void H()
  {
    TextView localTextView = this.B;
    float f1;
    if (QQTheme.isNowSimpleUI()) {
      f1 = 16.0F;
    } else {
      f1 = 17.0F;
    }
    localTextView.setTextSize(1, f1);
  }
  
  public void I()
  {
    ((AIOEmoticonGuideHelper)this.g.a(54)).b();
  }
  
  public TipsManager J()
  {
    return this.aX;
  }
  
  @TargetApi(11)
  public void K()
  {
    if (this.aY)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "doOnDestroy return");
      }
      return;
    }
    this.aY = true;
    URLDrawable.resume();
    this.aE = 9;
    AIOUtils.a(this.c, "doOnDestroy", hashCode(), this.aE);
    this.j.d().s();
    this.j.f().a(0, 0L);
    this.j.g();
    this.aV.c();
    bB();
    Object localObject = this.aX;
    if (localObject != null) {
      ((TipsManager)localObject).d();
    }
    av();
    this.d.removeHandler(getClass());
    this.ah.h = -1L;
    this.j.d().l();
    localObject = (IEmoticonManagerService)this.d.getRuntimeService(IEmoticonManagerService.class);
    ((IEmoticonManagerService)localObject).saveRecentEmotionToDB();
    ((IEmoticonManagerService)localObject).saveEmotionKeywordToDB();
    bE();
    this.m.removeCallbacksAndMessages(null);
    this.m.removeCallbacks(this.by);
    bA();
    this.d.removeHandler(ChatActivity.class);
    localObject = this.aU;
    if (localObject != null) {
      ((AIOAnimationConatiner)localObject).b();
    }
    ChatActivityUtils.b();
    ChatActivityFacade.a();
    this.k.g();
    bD();
    this.bj = Boolean.valueOf(true);
    localObject = this.ad;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.h.b();
    if (AITranslator.b()) {
      AITranslator.a().a(this.e, true);
    }
    this.i.p().b().g();
    AioAnimationDetector.a().b();
    ThridAppShareHelper.a().b();
    Scroller.b(true);
    ((IPicPreDownload)this.d.getRuntimeService(IPicPreDownload.class)).clearAIORequests();
    com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.e = 0L;
    if (bn == 1) {
      p(0);
    }
    ChatActivityUtils.a();
    ThreadPriorityManager.a(false);
    this.ay.a();
    NowVideoController.a().d();
    this.d.getMessageFacade().j();
    bC();
    BaseActivity.sActivityRoute.remove(getClass().getSimpleName());
    localObject = (AIOAnimationControlManager)this.d.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if (localObject != null) {
      ((AIOAnimationControlManager)localObject).f();
    }
    AIOSingleReporter.a().b();
    be();
    HotPicPageView.c();
    PresenceInterfaceImpl.b(this.d);
    QIMUserManager.b().a(false);
    this.g.b(15);
    localObject = this.u;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(null);
    }
    UniteGrayTipUtil.b();
    VasUtils.a();
    this.aP = null;
    this.aQ = null;
    this.aR = 0;
    this.aS = 0;
    if (p())
    {
      localObject = this.bb;
      if (localObject != null) {
        ((QQBlurView)localObject).c();
      }
      localObject = this.bd;
      if (localObject != null) {
        ((QQBlurView)localObject).c();
      }
    }
    localObject = this.I;
    if ((localObject instanceof OnlineStatusLyricView)) {
      ((OnlineStatusLyricView)localObject).f();
    }
  }
  
  @Deprecated
  public void L()
  {
    PokeItemHelper.b();
    PokeItemHelper.d();
    PokeItemAnimationManager.c().a();
    f(1);
  }
  
  public void M()
  {
    Intent localIntent = this.f.getIntent();
    String str = localIntent.getStringExtra("key_nearby_qzone_to_aio");
    if ((str != null) && (str.equals("nearby_qzone_to_aio")))
    {
      str = localIntent.getStringExtra("uin");
      localIntent.putExtra("key_has_talk", LBSHandler.a(this.d, str));
      this.f.setResult(-1, localIntent);
    }
  }
  
  public void N()
  {
    this.aE = 3;
    AIOUtils.a(this.c, "doOnStart", hashCode(), this.aE);
    this.g.b(5);
  }
  
  public void O()
  {
    this.aE = 6;
    AIOUtils.a(this.c, "doOnStop", hashCode(), this.aE);
    this.ar = false;
    XPanelContainer localXPanelContainer = this.n;
    if ((localXPanelContainer != null) && (localXPanelContainer.getCurrentPanel() == 1)) {
      as();
    }
    aM();
    this.bj = Boolean.valueOf(true);
    try
    {
      if ((this.f != null) && (this.f.getWindow() != null)) {
        this.f.getWindow().setSoftInputMode(32);
      }
    }
    catch (Exception localException)
    {
      QLog.e(this.c, 1, localException, new Object[0]);
    }
    Object localObject = this.f;
    if ((localObject != null) && (((BaseActivity)localObject).getIntent() != null))
    {
      String str = this.f.getIntent().getStringExtra("uin");
      int i1 = this.f.getIntent().getIntExtra("uintype", -1);
      IReadInJoySPEventReport localIReadInJoySPEventReport = (IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class);
      localObject = this.V;
      if (localObject != null) {
        localObject = ((ChatAdapter1)localObject).a();
      } else {
        localObject = null;
      }
      localIReadInJoySPEventReport.addAioEnterAndOutInfo(0, (List)localObject, str, i1, this.j.e().b());
    }
    ShortVideoItemBuilder.j();
    ShortVideoRealItemBuilder.j();
    this.g.b(12);
  }
  
  public void P()
  {
    this.aE = 5;
    AIOUtils.a(this.c, "doOnPause", hashCode(), this.aE);
    this.d.getMessageFacade().j();
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    ApngImage.pauseByTag(0);
    ((FastImageHelper)q(83)).b(true);
    ThreadManager.post(new BaseChatPie.10(this), 5, null, false);
    if (this.j.e().g()) {
      ChatActivityFacade.a(this.d, this.ah);
    }
    this.m.removeMessages(16711689);
    this.m.removeCallbacks(this.bx);
    Object localObject = this.U;
    if (localObject != null) {
      ((ChatXListView)localObject).e();
    }
    localObject = this.aU;
    if (localObject != null) {
      ((AIOAnimationConatiner)localObject).b(0);
    }
    this.ar = false;
    if (this.bk)
    {
      this.bw.a(this.U);
      this.bk = false;
    }
    this.g.b(11);
    if (p())
    {
      this.bb.b();
      this.bd.b();
    }
  }
  
  protected void Q()
  {
    StartupTracker.a(null, "AIO_doOnResume_updateUI");
    Object localObject = (SimpleUIAIOHelper)q(29);
    ((SimpleUIAIOHelper)localObject).a(this.s);
    ((SimpleUIAIOHelper)localObject).b(this.t);
    R();
    if ((this.Z != null) && (this.Y != null)) {
      this.i.p().d().d().c();
    }
    StartupTracker.a("AIO_doOnResume_updateUI", null);
    this.k.d().a(ImmersiveUtils.getStatusBarHeight(this.e));
    bg();
    this.g.b(7);
    if (p())
    {
      localObject = this.bb;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIO.");
      localStringBuilder.append(this.ah.a);
      localStringBuilder.append(".");
      localStringBuilder.append(MsfSdkUtils.getShortUin(this.ah.b));
      ((QQBlurView)localObject).setDebugTag(localStringBuilder.toString());
      this.bb.a();
    }
    this.bd.a();
  }
  
  public void R()
  {
    AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.f();
    if ((localAIOLongShotHelper != null) && (localAIOLongShotHelper.c()) && (localAIOLongShotHelper.d()))
    {
      QLog.i(this.c, 1, "loadBackgroundAsync: skip for mosaic is on");
      return;
    }
    ThreadManager.postImmediately(new BaseChatPie.13(this), null, true);
  }
  
  public void S()
  {
    this.aE = 4;
    AIOUtils.a(this.c, "doOnResume", hashCode(), this.aE);
    Q();
    this.d.getMessageFacade().k(this.ah.b, this.ah.a);
    if (this.aC)
    {
      AIOUtils.a(true);
      this.aD = false;
      if (this.ah.a == 1008) {
        PAStartupTracker.a(null, "pubAcc_structMsg_display", this.ah.b);
      }
      synchronized (QQMessageFacade.l)
      {
        this.j.f().e();
        this.j.f().a(true);
        this.m.postDelayed(this.by, 800L);
      }
    }
    j(131072);
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onShow right now");
    }
    ap();
    this.aC = false;
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isInited()) {
      this.i.p().b().d();
    }
    this.bk = false;
    ??? = (AudioPanelAioHelper)q(128);
    this.bw.a(this.U, this.V, (MediaPlayerManager.Listener)???);
    NowVideoController.a().a(this.d, this.U, this.ah);
    QQLSRecentManager.i = true;
    ThreadRegulator.a().a(1, 1500L);
    n(((AIOLongShotHelper)q(15)).h());
    ((SimpleUIAIOHelper)q(29)).a(T());
  }
  
  protected Boolean T()
  {
    return null;
  }
  
  public void U()
  {
    this.g.b(6);
    AIOUtils.a(false);
    this.j.f().a(false);
    this.j.e().c(false);
    this.aj = false;
    this.j.b().g();
    this.am = false;
    this.an = false;
    this.j.e().b(false);
    this.j.e().a(false);
    this.ap = false;
    this.ar = false;
    this.as = false;
    this.av = true;
    this.aw = true;
    this.aA = false;
    this.bo = Boolean.valueOf(false);
    this.aK = false;
    this.aT = true;
    this.bq = true;
    this.P = true;
    this.Q = false;
    this.aa = false;
    this.aD = false;
    this.k.e();
    Object localObject = this.aX;
    if (localObject != null) {
      ((TipsManager)localObject).c();
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((XPanelContainer)localObject).e();
      this.n.d();
    }
    this.j.d().q();
    this.j.f().b(false);
    this.j.f().c(true);
  }
  
  public boolean V()
  {
    int i1 = this.g.a();
    boolean bool = false;
    if (i1 != 0)
    {
      if (i1 == 1) {
        bool = true;
      }
      return bool;
    }
    return f(0);
  }
  
  protected int[] W()
  {
    return new int[] { 2130772113, 2130772105 };
  }
  
  public void X()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "return MainFragment");
    }
    Object localObject1 = this.f;
    if ((localObject1 instanceof SplashActivity))
    {
      Object localObject2 = ((BaseActivity)localObject1).getSupportFragmentManager();
      localObject1 = ((FragmentManager)localObject2).beginTransaction();
      localObject2 = ((FragmentManager)localObject2).findFragmentByTag(MainFragment.class.getName());
      ChatFragment localChatFragment = this.f.getChatFragment();
      int[] arrayOfInt = W();
      ((FragmentTransaction)localObject1).setCustomAnimations(arrayOfInt[0], arrayOfInt[1]);
      SplashActivity.currentFragment = 1;
      this.f.getIntent().putExtra("isFromAioFragment", true);
      if (localObject2 != null) {
        ((FragmentTransaction)localObject1).show((Fragment)localObject2);
      } else {
        ((FragmentTransaction)localObject1).add(16908290, MainFragment.a(), MainFragment.class.getName());
      }
      ((FragmentTransaction)localObject1).hide(localChatFragment);
      ((FragmentTransaction)localObject1).commitAllowingStateLoss();
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.c, 4, "returnMainFragment() mActivity instanceof ChatActivity ");
    }
    SceneTracker.a().b("ChatFragment");
  }
  
  protected void Y()
  {
    try
    {
      if (this.br == 0)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
        localIntentFilter.addAction("android.intent.action.PHONE_STATE");
        localIntentFilter.addAction("vivo_smart_shot_enter");
        localIntentFilter.addAction("com.huawei.hwmultidisplay.action.WINDOW_CAST_MODE");
        this.e.registerReceiver(this.bC, localIntentFilter);
        this.br = 1;
      }
      else if (QLog.isColorLevel())
      {
        QLog.e(this.c, 2, "registerReceiver but done");
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("registerReceiver ");
        localStringBuilder.append(localException);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.e, this);
    String str = this.c;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AIOTime doOnRegReceivershashCode = ");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
  }
  
  protected void Z()
  {
    try
    {
      if (this.br == 1)
      {
        this.e.unregisterReceiver(this.bC);
        this.br = 0;
      }
      else if (QLog.isColorLevel())
      {
        QLog.e(this.c, 2, "unRegisterReceiver but cannot");
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unregisterReceiver:");
        localStringBuilder.append(localException);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
    }
    boolean bool = AppNetConnInfo.unregisterNetInfoHandler(this);
    String str = this.c;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AIOTime doOnUnRegReceivers :");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("hashCode = ");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
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
      this.j.f().a(paramInt1, this.j.b().c(paramInt1));
    }
    else
    {
      paramInt1 = paramInt8;
    }
    if (paramInt7 == 0)
    {
      this.j.f().a(paramInt6, this.j.b().c(paramInt6));
      paramInt1 = paramInt6;
    }
    long l1 = this.j.f().a();
    long l2 = this.j.b().c(paramInt1);
    paramInt2 = paramInt1;
    if (l1 > 0L)
    {
      paramInt2 = paramInt1;
      if (l1 != l2)
      {
        paramInt2 = this.j.b().b(l1);
        this.j.f().a(paramInt2, l1);
        QLog.d(this.c, 2, new Object[] { "doUpdateUnreadBubble. after revise readCnt =", Integer.valueOf(paramInt2) });
      }
    }
    return paramInt6 - paramInt2;
  }
  
  public String a(Fragment paramFragment)
  {
    StringBuilder localStringBuilder = new StringBuilder("preCheckUpdate: chat fragment not visible ");
    localStringBuilder.append(",f=");
    localStringBuilder.append(paramFragment.getClass().getSimpleName());
    localStringBuilder.append(",isAdded=");
    localStringBuilder.append(paramFragment.isAdded());
    localStringBuilder.append(",isHidden=");
    localStringBuilder.append(paramFragment.isHidden());
    View localView = paramFragment.getView();
    if (localView == null)
    {
      localStringBuilder.append(",view=null");
    }
    else
    {
      localStringBuilder.append(",getWindowToken=");
      localStringBuilder.append(localView.getWindowToken());
      localStringBuilder.append(",getVisibility=");
      localStringBuilder.append(localView.getVisibility());
    }
    localStringBuilder.append(",isVisible=");
    localStringBuilder.append(paramFragment.isVisible());
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.i.p().d().c().b();
    if (localObject != null) {
      ((ImageButton)localObject).setActivated(false);
    }
    this.ae.a(paramInt);
    AIOUtils.q = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPanelIconClick panelID=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("currentID=");
      ((StringBuilder)localObject).append(this.n.getCurrentPanel());
      QLog.d("XPanel", 2, ((StringBuilder)localObject).toString());
    }
    ((FastImageHelper)q(83)).b(true);
    I();
    if (paramInt == this.n.getCurrentPanel())
    {
      this.n.b();
      return;
    }
    this.ae.e(paramInt);
    v(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.ae.a(paramInt1, paramInt2);
    this.m.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
    this.i.p().d().f().a(this.bt);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i3 = this.j.f().b();
    int i2;
    if (i3 < paramInt6) {
      i2 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, i3);
    } else {
      i2 = 0;
    }
    Object localObject1 = this.i.e().b();
    Object localObject2;
    if ((localObject1 instanceof TroopListUI))
    {
      localObject2 = (TroopListUI)localObject1;
      if (((TroopListUI)localObject2).y() != null)
      {
        localObject1 = ((TroopListUI)localObject2).y().a();
        i1 = i2;
        if (localObject1 == JumpState.START) {
          break label312;
        }
        i1 = i2;
        if (localObject1 == JumpState.INACTIVATED) {
          break label312;
        }
        i1 = i2;
        if (localObject1 == JumpState.END) {
          break label312;
        }
        i1 = OneClickJumpMsgFilter.a;
        QLog.d(this.c, 1, new Object[] { "doUpdateUnreadBubble. change cnt because of oneClickJump =", Integer.valueOf(i3) });
        break label312;
      }
    }
    int i1 = i2;
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeListUiIsGuildListUI(localObject1))
    {
      i1 = i2;
      if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeGuildListUIJumpStateMachineControllerIsNotNull(localObject1))
      {
        localObject1 = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getJumpStateFromGuildListUI(localObject1);
        if ((localObject1 == JumpState.START) || (localObject1 == JumpState.INACTIVATED) || (localObject1 == JumpState.END))
        {
          i1 = i2;
          if (!this.i.e().b().e()) {}
        }
        else
        {
          i1 = GuildOneClickJumpMsgFilter.a;
          QLog.d(this.c, 1, new Object[] { "doUpdateUnreadBubble. change guild cnt because of oneClickJump =", Integer.valueOf(i3), ", unReadCnt = ", Integer.valueOf(i1) });
        }
      }
    }
    label312:
    if (i1 != this.bi)
    {
      if (this.m.hasMessages(13)) {
        this.m.removeMessages(13);
      }
      i2 = ChatActivityUtils.a(this.V.a(), i1);
      localObject1 = this.m;
      localObject2 = ((MqqHandler)localObject1).obtainMessage(13, i2, paramInt7);
      long l1;
      if (this.bj.booleanValue()) {
        l1 = 1500L;
      } else {
        l1 = 0L;
      }
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, l1);
      this.bj = Boolean.valueOf(false);
      this.bi = i1;
    }
    localObject1 = (UnreadBackBottomHelper)q(53);
    if (localObject1 != null)
    {
      ((UnreadBackBottomHelper)localObject1).b(this.bi);
      ((UnreadBackBottomHelper)localObject1).a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
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
    this.g.a(paramInt, paramDialog);
  }
  
  public final void a(int paramInt, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams, long paramLong)
  {
    this.j.f().a(paramInt, paramMsgSendCostParams, paramLong);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      return;
    }
    if (paramBoolean2) {
      return;
    }
    Object localObject1 = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i1 = this.ah.a;
    paramBoolean2 = false;
    paramBoolean1 = false;
    Object localObject2;
    if ((i1 != 3000) && (this.ah.a != 1))
    {
      localObject2 = ((FriendsManager)localObject1).d(this.ah.b, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.bI;
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
      localObject2 = ((FriendsManager)localObject1).b(this.ah.b, this.ah.a, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.bJ;
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
    this.j.d().b(paramLong);
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isPackageExist isVivoShot=");
      ((StringBuilder)localObject).append(bn);
      QLog.d("vivo", 2, ((StringBuilder)localObject).toString());
    }
    if (bn != 0)
    {
      this.bo = Boolean.valueOf(false);
      return;
    }
    Object localObject = Build.MANUFACTURER.toUpperCase();
    if ((!((String)localObject).endsWith("BBK")) && (!((String)localObject).endsWith("VIVO")))
    {
      bn = 2;
      return;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getApplicationInfo(paramString, 8192);
      bn = 1;
      this.bo = Boolean.valueOf(false);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      bn = 2;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append(" isPackageExist isScrollToButtom=");
      paramContext.append(this.bo);
      QLog.d("vivo", 2, paramContext.toString());
    }
  }
  
  protected void a(Intent paramIntent)
  {
    this.ah.b = paramIntent.getStringExtra("uin");
    this.ah.a = paramIntent.getIntExtra("uintype", -1);
    SessionInfo localSessionInfo = this.ah;
    localSessionInfo.i = false;
    localSessionInfo.j = false;
    if (localSessionInfo.a == 0)
    {
      QIMUserManager.b().a(this.d, this.ah);
      TIMUserManager.b().a(this.d, this.ah);
    }
    int i1 = this.ah.a;
    boolean bool2 = true;
    if (i1 == 1026)
    {
      this.ah.a = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
      }
    }
    this.ah.f = paramIntent.getStringExtra("phonenum");
    this.ah.s = paramIntent.getIntExtra("entrance", 0);
    this.ah.c = paramIntent.getStringExtra("troop_uin");
    localSessionInfo = this.ah;
    localSessionInfo.g = null;
    localSessionInfo.d = null;
    localSessionInfo.t = paramIntent.getIntExtra("add_friend_source_id", 3999);
    this.ah.v = paramIntent.getIntExtra("key_confess_topicid", 0);
    this.j.b().c();
    this.bl = paramIntent.getIntExtra("enter_ext_panel", 0);
    this.bm = paramIntent.getIntExtra("ext_panel_onresume", 1);
    this.aj = paramIntent.getBooleanExtra("isBack2Root", false);
    if (paramIntent.getLongExtra("res_share_id", -1L) != -1L) {
      this.am = paramIntent.getExtras().containsKey("res_share_id");
    }
    if (!this.am) {
      this.am = paramIntent.getBooleanExtra("is_share_flag", false);
    }
    if ("qzoneShareTopic".equals(paramIntent.getStringExtra("share_qq_ext_str"))) {
      this.am = false;
    }
    this.an = paramIntent.getBooleanExtra("thridparty_pull_aio", false);
    this.ap = paramIntent.getBooleanExtra("is_from_manage_stranger", false);
    boolean bool3 = paramIntent.getBooleanExtra("need_jump_to_msg", false);
    boolean bool1;
    if (paramIntent.getIntExtra("aio_msg_source", 999) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.aF = bool1;
    if ((this.aF) || (bool3))
    {
      this.j.d().a(paramIntent);
      paramIntent = this.j.f();
      if (this.j.d().p() > -1L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramIntent.b(bool1);
      AIOUtils.q = false;
      this.aG = false;
    }
    this.g.b(2);
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int i1 = paramIntent.getIntExtra(AlbumConstants.h, -1);
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleRequest requestCode ");
      localStringBuilder.append(i1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((i1 == 2) || (i1 == 1)) {
      this.h.b(paramIntent);
    }
    if (paramInt == 1)
    {
      FriendHotTipsBar.b(this.d, this.ah.b);
      return;
    }
    if ((paramInt == 2) && (!this.aT)) {
      FriendHotTipsBar.b(this.d, this.ah.b);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.c, 2, "onConfigurationChanged");
    }
    as();
    if (paramConfiguration.orientation == 2) {
      ReportController.b(this.d, "CliOper", "", "", "0X8005C7B", "0X8005C7B", 0, 0, "", "", "", "");
    }
    this.g.b(19);
    this.g.a(paramConfiguration);
  }
  
  public void a(Drawable paramDrawable)
  {
    Object localObject = this.f.getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).q();
      if (localObject != null) {
        ((ImmersiveTitleBar2)localObject).setBackgroundDrawable(paramDrawable);
      }
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle(paramBundle));
    a(localIntent, false);
  }
  
  protected void a(Message paramMessage)
  {
    ViewGroup localViewGroup = this.ba;
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
      if ((this.ah.i) && (this.ah.l) && (!this.ah.k))
      {
        this.ba.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852162));
        this.ah.H.b = ColorStateList.valueOf(1711276032);
        QLog.d(this.c, 1, "udpateAIOBackgrourd, setAIO bg skin_chat_background");
      }
      else if ((this.ah.j) && (this.ah.m) && (!this.ah.k))
      {
        this.ba.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852162));
        this.ah.H.b = ColorStateList.valueOf(1711276032);
        QLog.d(this.c, 1, "udpateAIOBackgrourd, setAIO bg skin_chat_background");
      }
      else if ((this.ah.a != 1033) && (this.ah.a != 1034))
      {
        if (this.ah.a == 10007)
        {
          if (!ThemeUtil.isNowThemeIsNight(this.d, false, null))
          {
            this.ba.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852162));
            this.ah.H.b = ColorStateList.valueOf(1711276032);
            QLog.d(this.c, 1, "udpateAIOBackgrourd, setAIO bgsetAIO bg skin_chat_background");
          }
        }
        else
        {
          this.ba.setBackgroundDrawable((Drawable)paramMessage.obj);
          if (AIOMusicSkin.a().du_()) {
            AIOMusicSkin.a().b(this.ba.getContext(), this.ba);
          }
          ((QEffectBgProvider)this.g.a(17)).a(this.e, this.d, this.ah);
          paramMessage = new StringBuilder();
          paramMessage.append("MSG_SHOW_AIO_BACKGROUND sessionInfo:  isQimUserOnline = ");
          paramMessage.append(this.ah.i);
          paramMessage.append("  isQimUserTitleForm = ");
          paramMessage.append(this.ah.l);
          paramMessage.append("  isTimUserOnline = ");
          paramMessage.append(this.ah.j);
          paramMessage.append(" isTimUserTitleForm = ");
          paramMessage.append(this.ah.m);
          paramMessage.append("  isNightMode = ");
          paramMessage.append(this.ah.k);
          paramMessage.append("  curType = ");
          paramMessage.append(this.ah.a);
          QLog.d("Q.msg.delmsg", 1, paramMessage.toString());
        }
      }
      else
      {
        this.ba.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852162));
        this.ah.H.b = ColorStateList.valueOf(1711276032);
        QLog.d(this.c, 1, "udpateAIOBackgrourd, setAIO bg skin_chat_background");
      }
      aD();
      paramMessage = localStringBuilder;
    }
    a(paramMessage);
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    if (!this.aO)
    {
      Object localObject1 = this.d;
      if (localObject1 != null)
      {
        Object localObject2 = (ISpriteScriptManager)((QQAppInterface)localObject1).getRuntimeService(ISpriteScriptManager.class, "all");
        localObject1 = ((ISpriteScriptManager)localObject2).getUIHandler();
        localObject2 = ((ISpriteScriptManager)localObject2).getSpriteContext();
        if ((localObject1 != null) && (localObject2 != null))
        {
          if (QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowHeightSwitch", 0) == 0)
          {
            ((ISpriteUIHandler)localObject1).a(this.d, this.ah.a, this.ah.b);
            return;
          }
          if (((ISpriteUIHandler)localObject1).a(paramMotionEvent, this.o)) {
            ((ISpriteUIHandler)localObject1).a(this.d, this.ah.a, this.ah.b);
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
      if (this.aL)
      {
        paramImageView.setImageResource(paramInt2);
        return;
      }
      paramImageView.setImageResource(paramInt1);
    }
  }
  
  public void a(ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    this.i.p().b().a(paramSendMsgParams);
  }
  
  protected void a(AIOLongShotHelper paramAIOLongShotHelper)
  {
    this.s.setBackgroundResource(2130853297);
    if (QLog.isColorLevel())
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set left text from set checkbox: ");
      localStringBuilder.append(this.aB);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(this.aB))
    {
      this.s.setText("");
    }
    else
    {
      this.s.setText(this.aB);
      this.aB = "";
    }
    Object localObject = this.p;
    if (localObject != null) {
      ((NavBarAIO)localObject).e();
    }
    if (this.aL)
    {
      if (TextUtils.isEmpty(this.x.getText())) {
        this.x.setVisibility(8);
      } else {
        this.x.setVisibility(0);
      }
    }
    else {
      this.x.setVisibility(8);
    }
    MultiMsgManager.a().g();
    paramAIOLongShotHelper.b();
    this.V.g = Boolean.valueOf(true);
    ((AIOMultiActionHelper)q(66)).b();
    this.u.setVisibility(0);
    this.v.setVisibility(8);
    if (this.d != null)
    {
      z();
      bf();
    }
    if (this.ak)
    {
      aC();
      this.ak = false;
    }
    this.aZ.findViewById(2131436236).setVisibility(0);
    this.q.setVisibility(0);
    this.r.setVisibility(0);
    this.U.getLayoutParams();
    paramAIOLongShotHelper = this.ad;
    if ((paramAIOLongShotHelper != null) && (!TextUtils.isEmpty(paramAIOLongShotHelper.getText().toString())) && (!"0".equals(this.ad.getText().toString())))
    {
      this.ad.setVisibility(0);
      ((UnreadBackBottomHelper)q(53)).b();
    }
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.d, "select_more_msg", false);
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    paramApolloInfo.send(this.d, this.Y, this.ah.a, this.ah.b, this.ah.c);
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    AioAnimationDetector.a().a(paramQQAppInterface, this.ah, this.aU);
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
    this.j.f().a(paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)q(15);
    if (!localAIOLongShotHelper.c())
    {
      int i4 = 1;
      if (AIOUtils.a(1) == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        paramChatMessage = MultiMsgManager.a().b.entrySet().iterator();
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
        ((AIOMultiActionHelper)q(66)).a(i1 & i2);
      }
      int i1 = MultiMsgManager.a().f();
      ((SelectToBottomHelper)q(40)).a(i1);
    }
    else
    {
      localAIOLongShotHelper.a(paramChatMessage, paramCompoundButton, paramBoolean);
    }
    ((AIOMultiActionHelper)q(66)).c();
  }
  
  protected void a(String paramString)
  {
    if (paramString != null)
    {
      if (this.ba != null)
      {
        localObject = this.ah;
        if ((localObject != null) && (((SessionInfo)localObject).H != null) && ((this.ah.H.c != null) || (ChatBackground.a(this.e, this.d.getCurrentAccountUin(), this.ah.b, true, 7, this.ah.H))))
        {
          if ((this.ah.i) && (this.ah.l) && (!this.ah.k))
          {
            this.ba.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852162));
            this.ah.H.b = ColorStateList.valueOf(1711276032);
          }
          else if ((this.ah.j) && (this.ah.m) && (!this.ah.k))
          {
            this.ba.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852162));
            this.ah.H.b = ColorStateList.valueOf(1711276032);
          }
          else if ((this.ah.a != 1033) && (this.ah.a != 1034))
          {
            this.ba.setBackgroundDrawable(this.ah.H.c);
          }
          else
          {
            this.ba.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852162));
            this.ah.H.b = ColorStateList.valueOf(1711276032);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("MSG_SHOW_AIO_BACKGROUND Error. bErrMsg=");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", show Again img=");
          ((StringBuilder)localObject).append(this.ah.H.c);
          QLog.e("Q.msg.delmsg", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MSG_SHOW_AIO_BACKGROUND Error.. bErrMsg=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", afRoot=");
      ((StringBuilder)localObject).append(this.ba);
      ((StringBuilder)localObject).append(", sessionInfo=");
      ((StringBuilder)localObject).append(this.ah);
      QLog.e("Q.msg.delmsg", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, BaseChatPie paramBaseChatPie)
  {
    this.m.post(new BaseChatPie.7(this, paramString1, paramString3, paramString2));
  }
  
  public void a(List<ChatMessage> paramList)
  {
    this.d.getMessageFacade().a(paramList, false);
    j(196614);
  }
  
  void a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    if (this.P)
    {
      String str1 = b(paramList, paramMessageRecord);
      if (QLog.isColorLevel())
      {
        String str2 = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sessionInfo.curType = ");
        localStringBuilder.append(this.ah.a);
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
        b(true);
        this.I.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.q.setOnClickListener(null);
        this.r.setOnClickListener(null);
        b(str1);
        if (b) {
          this.I.setContentDescription(str1);
        }
      }
      else
      {
        b(false);
      }
    }
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    a(paramList, paramCharSequence, 0);
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    this.V.a(paramList, paramCharSequence, paramInt);
  }
  
  public void a(boolean paramBoolean, Context paramContext, View paramView)
  {
    this.ae.a(paramBoolean, paramContext, paramView);
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
    if ((BaseChatItemLayout.ad == paramBoolean1) && (!paramBoolean4))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.c, 4, "setLeftCheckBoxVisible visible is not change so no need change");
      }
      return;
    }
    if (paramBoolean1)
    {
      BaseChatItemLayout.an = this;
      this.bv = true;
    }
    else
    {
      BaseChatItemLayout.an = null;
    }
    BaseChatItemLayout.ad = paramBoolean1;
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)q(15);
    if (!paramBoolean3)
    {
      if (!localAIOLongShotHelper.c()) {
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
      this.V.g = Boolean.valueOf(false);
      aw();
      if (this.X.getVisibility() == 0)
      {
        aB();
        this.ak = true;
      }
      paramChatMessage = this.U.getLayoutParams();
      if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
      {
        paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
        if (this.ax == 0) {
          this.ax = paramChatMessage.bottomMargin;
        }
      }
      paramChatMessage = this.ad;
      if (paramChatMessage != null) {
        paramChatMessage.setVisibility(8);
      }
      this.x.setVisibility(8);
      if (this.bu) {
        MultiMsgManager.a().g();
      }
    }
    if (!paramBoolean2) {
      this.V.notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.j.f().a(paramBoolean1, paramBoolean2);
  }
  
  protected boolean a(int paramInt, boolean paramBoolean)
  {
    if (this.n.getCurrentPanel() != 0)
    {
      if (paramInt == 0) {
        paramBoolean = ((AudioPanelProvider)this.ae.f(2)).g();
      } else {
        paramBoolean = false;
      }
      if (!paramBoolean) {
        if ((paramInt != 1) && (paramInt != 4) && (paramInt != 5)) {
          this.n.a(true);
        } else {
          this.n.a(false);
        }
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.bt = NetConnInfoCenter.getServerTime();
    if (this.aZ == null)
    {
      QLog.e(this.c, 1, "mAIORootView == null");
      ChatFragment localChatFragment = this.f.getChatFragment();
      if (localChatFragment != null) {
        this.aZ = localChatFragment.h;
      }
      if (this.aZ == null)
      {
        QLog.e(this.c, 1, "root view is still null");
        return false;
      }
    }
    this.aZ.setVisibility(0);
    this.ah.a();
    k();
    this.aE = 2;
    AIOUtils.a(this.c, "doOnCreate", hashCode(), this.aE);
    d(this.f.getIntent());
    StartupTracker.a("AIO_updateSession", "AIO_doOnCreate_otherCost");
    this.j.c().b(this.i);
    BaseActivity.sActivityRoute.add(getClass().getSimpleName());
    au();
    this.d.setHandler(ChatActivity.class, this.m);
    StartupTracker.a("AIO_doOnCreate_otherCost", "AIO_doOnCreate_handleRequest");
    if (paramBoolean) {
      a(this.f.getIntent(), 1);
    } else {
      a(this.f.getIntent(), 2);
    }
    this.h.a();
    StartupTracker.a("AIO_doOnCreate_handleRequest", null);
    return true;
  }
  
  public void aA()
  {
    Object localObject = this.p;
    if (localObject != null) {
      ((NavBarAIO)localObject).setRightToStr(HardCodeUtil.a(2131899217), new BaseChatPie.28(this));
    }
    localObject = this.W;
    if (localObject != null) {
      ((PanelIconLinearLayout)localObject).setVisibility(8);
    }
    JubaoHelper.a(this.d, aX().getIntent());
    a(true, null, false, true);
  }
  
  public void aB()
  {
    this.X.setVisibility(8);
    this.bb.setVisibility(8);
    PanelIconLinearLayout localPanelIconLinearLayout = this.W;
    if (localPanelIconLinearLayout != null) {
      localPanelIconLinearLayout.setCustomHeight(0);
    }
    this.i.p().d().b().b();
  }
  
  public void aC()
  {
    this.X.setVisibility(0);
    this.bb.setVisibility(0);
    PanelIconLinearLayout localPanelIconLinearLayout = this.W;
    if ((localPanelIconLinearLayout != null) && (!(this instanceof PublicAccountChatPie))) {
      localPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.b);
    }
    ((SimpleUIAIOHelper)q(29)).d();
    this.i.p().d().b().a();
  }
  
  protected void aD()
  {
    Object localObject1;
    Object localObject2;
    if (ThemeUtil.isInNightMode(this.d))
    {
      if (this.ah.H != null)
      {
        boolean bool;
        if ((!"".equals(this.ah.H.a)) && (!"null".equals(this.ah.H.a))) {
          bool = false;
        } else {
          bool = true;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = this.c;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("#handleNightMask# : inNightMode, isDefaultBg=");
          ((StringBuilder)localObject2).append(bool);
          ((StringBuilder)localObject2).append(",mMask=");
          ((StringBuilder)localObject2).append(this.aW);
          ((StringBuilder)localObject2).append(", sessionInfo.chatBg.path=");
          ((StringBuilder)localObject2).append(this.ah.H.a);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        if ((this.aW != null) && (QLog.isColorLevel())) {
          if (this.aW.getVisibility() == 0) {
            QLog.d(this.c, 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
          } else if (this.aW.getVisibility() == 4) {
            QLog.d(this.c, 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
          } else {
            QLog.d(this.c, 2, "#handleNightMask# : mMask getVisibility = GONE");
          }
        }
        if (!bool)
        {
          localObject1 = this.aW;
          if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0)) {
            return;
          }
          localObject1 = this.aW;
          if (localObject1 == null)
          {
            this.aW = new View(this.e);
            this.aW.setBackgroundColor(1996488704);
            localObject1 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131437281);
            ((RelativeLayout.LayoutParams)localObject1).addRule(2, this.X.getId());
            this.aW.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.o.addView(this.aW);
            return;
          }
          ((View)localObject1).setVisibility(0);
          return;
        }
        localObject1 = this.aW;
        if (localObject1 != null)
        {
          this.o.removeView((View)localObject1);
          this.aW = null;
        }
      }
    }
    else
    {
      localObject1 = this.aW;
      if (localObject1 != null)
      {
        localObject2 = this.o;
        if (localObject2 != null)
        {
          ((RelativeLayout)localObject2).removeView((View)localObject1);
          this.aW = null;
        }
      }
    }
  }
  
  public SessionInfo aE()
  {
    return this.ah;
  }
  
  public void aF()
  {
    XPanelContainer localXPanelContainer = this.n;
    if (localXPanelContainer != null) {
      localXPanelContainer.a(1);
    }
  }
  
  public void aG()
  {
    this.n.a(30);
  }
  
  public ExtensionInfo aH()
  {
    return this.bI;
  }
  
  public NoC2CExtensionInfo aI()
  {
    return this.bJ;
  }
  
  public boolean aJ()
  {
    return (this.ah.a != 3000) && (this.ah.a != 1);
  }
  
  public boolean aK()
  {
    boolean bool = false;
    int i1 = 0;
    while ((i1 < UinTypeUtil.d.length) && (this.ah.a != UinTypeUtil.d[i1])) {
      i1 += 1;
    }
    if (i1 < UinTypeUtil.d.length) {
      bool = true;
    }
    return bool;
  }
  
  public boolean aL()
  {
    return this.aF;
  }
  
  public void aM()
  {
    if (this.ah != null)
    {
      if (this.aa) {
        return;
      }
      Object localObject = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((this.ah.a != 3000) && (this.ah.a != 1))
      {
        if (aK())
        {
          localObject = ((FriendsManager)localObject).d(this.ah.b, false);
          if ((localObject != null) && (((ExtensionInfo)localObject).isDataChanged)) {
            ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.d));
          }
        }
      }
      else
      {
        localObject = ((FriendsManager)localObject).b(this.ah.b, this.ah.a, false);
        if ((localObject != null) && (((NoC2CExtensionInfo)localObject).isDataChanged)) {
          ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.d));
        }
      }
    }
  }
  
  public void aN()
  {
    if (((ChatPieSelectableHelper)q(4)).d()) {
      return;
    }
    if (this.V != null)
    {
      Object localObject = this.U;
      if (localObject != null)
      {
        int i1 = ((ChatXListView)localObject).getLastVisiblePosition();
        int i2 = this.V.getCount() - 1 + this.U.getFooterViewsCount() + this.U.getHeaderViewsCount();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onOverScrollTargetValue isScrollToButtom=");
          ((StringBuilder)localObject).append(this.aK);
          ((StringBuilder)localObject).append("lastPosition=");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append("toLast=");
          ((StringBuilder)localObject).append(i2);
          QLog.d("MyOnGestureListener", 2, ((StringBuilder)localObject).toString());
        }
        localObject = this.X;
        if ((localObject != null) && (((InputLinearLayout)localObject).getVisibility() == 0) && (i1 == i2) && (this.aK) && (!this.j.b().e()))
        {
          this.n.a(1);
          ReportController.b(this.d, "CliOper", "", "", "0X8004454", "0X8004454", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public boolean aO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "shouldRecordPositionY ");
    }
    int i1 = this.n.getCurrentPanel();
    if (i1 == 1)
    {
      if (!((InputMethodManager)this.e.getSystemService("input_method")).isActive(this.Y))
      {
        this.bq = false;
        return true;
      }
    }
    else {
      if ((i1 == 0) || ((this.n.getCurrentPanelView() != null) && (this.n.getCurrentPanelView().getVisibility() != 0))) {
        break label91;
      }
    }
    return false;
    label91:
    if (this.Y.getVisibility() == 0) {
      this.bq = false;
    }
    return true;
  }
  
  public void aP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onEventComplite");
    }
    this.bq = true;
  }
  
  public void aQ()
  {
    a(false, this.e, this.Y);
  }
  
  public int aR()
  {
    return this.n.getCurrentPanel();
  }
  
  public void aS()
  {
    if (this.at == null) {
      this.at = new QQMapActivityProxy(this.d.getAccount());
    }
  }
  
  public StructingMsgItemBuilder.ViewCache aT()
  {
    return this.ay;
  }
  
  public RecordParams.RecorderParam aU()
  {
    return new RecordParams.RecorderParam(RecordParams.a, 0, 0);
  }
  
  public EntryModel aV()
  {
    return new EntryModel(-1, 0L, "", false);
  }
  
  public ViewGroup aW()
  {
    return this.aZ;
  }
  
  public BaseActivity aX()
  {
    return this.f;
  }
  
  public boolean aY()
  {
    Object localObject = this.f;
    boolean bool;
    if (((localObject == null) || ((!((BaseActivity)localObject).isResume()) && (!this.f.isInMultiWindow()))) && (this.n.getCurrentPanel() != 6) && (this.n.getCurrentPanel() != 5)) {
      bool = false;
    } else {
      bool = true;
    }
    if ((this.f != null) && (QLog.isColorLevel()))
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isActivityResume = ");
      localStringBuilder.append(bool);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean aZ()
  {
    return this.k.c().a();
  }
  
  protected final List<ChatMessage> aa()
  {
    return e(false);
  }
  
  public boolean ab()
  {
    return ((this instanceof TroopChatPie)) || ((this instanceof DiscussChatPie));
  }
  
  public boolean ac()
  {
    return ((AudioPanelAioHelper)q(128)).g();
  }
  
  protected void ad()
  {
    ThreadPriorityManager.a(true);
    this.aU.d();
    ((AvatarPendantManager)this.d.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  @Deprecated
  public String ae()
  {
    return this.ah.b;
  }
  
  @Deprecated
  public String af()
  {
    return this.ah.e;
  }
  
  public String ag()
  {
    return this.ah.c;
  }
  
  public void ah()
  {
    this.g.b(21);
  }
  
  public void ai()
  {
    BlurUtil.a(this.bd, this.aZ, 2131168025, r(2131445137));
    this.aL = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject;
    if (QLog.isColorLevel())
    {
      String str = this.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isThemeDefault");
      ((StringBuilder)localObject).append(this.aL);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    if ((this.d != null) && (this.e != null) && (this.ba != null) && (this.ah.H != null))
    {
      this.ah.H.d = false;
      if (ChatBackground.a(this.e, this.d.getCurrentAccountUin(), this.ah.b, true, 7, this.ah.H)) {
        if ((this.ah.i) && (this.ah.l) && (!this.ah.k))
        {
          this.ba.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852162));
          this.ah.H.b = ColorStateList.valueOf(1711276032);
          QLog.d(this.c, 1, "onPostThemeChanged, setAIO bg skin_chat_background");
        }
        else if ((this.ah.j) && (this.ah.m) && (!this.ah.k))
        {
          this.ba.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852162));
          this.ah.H.b = ColorStateList.valueOf(1711276032);
          QLog.d(this.c, 1, "onPostThemeChanged, setAIO bg skin_chat_background");
        }
        else
        {
          this.ba.setBackgroundDrawable(this.ah.H.c);
          QLog.d(this.c, 1, "onPostThemeChanged,set chatBg");
        }
      }
    }
    try
    {
      bg();
      if (this.p != null)
      {
        this.p.a(2130853300, 2130853301);
        this.p.setRight1Icon(2130852269, 2130852270);
      }
    }
    catch (Exception localException)
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPostThemeChanged e:");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append("isThemeDefault");
      localStringBuilder.append(this.aL);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.g.b(22);
    ((SimpleUIAIOHelper)q(29)).a(T());
    AIOMusicSkin.a().b(aX(), this.n);
    o();
  }
  
  public void aj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMagicFaceItem");
    }
    this.V.notifyDataSetChanged();
  }
  
  public TextView ak()
  {
    return this.ad;
  }
  
  public void al()
  {
    Object localObject = new TextView(this.e);
    ((TextView)localObject).setId(2131438953);
    ((TextView)localObject).setBackgroundResource(2130838379);
    ((TextView)localObject).setGravity(1);
    ((TextView)localObject).setPadding(0, (int)(this.ai * 2.0F + 0.5F), 0, 0);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(2, 16.0F);
    ((TextView)localObject).setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(2, 2131435809);
    localLayoutParams.addRule(11);
    float f1 = this.ai;
    localLayoutParams.bottomMargin = ((int)(f1 * 10.0F + 0.5F));
    localLayoutParams.rightMargin = ((int)(f1 * 10.0F + 0.5F));
    this.o.addView((View)localObject, localLayoutParams);
    this.ad = ((TextView)localObject);
    ((TextView)localObject).setVisibility(8);
    if (this.k.d().c() != null) {
      this.o.bringChildToFront(this.k.d().c());
    }
    ((AudioPanelAioHelper)q(128)).k(2131438953);
    localObject = (UnreadBackBottomHelper)q(53);
    ((UnreadBackBottomHelper)localObject).a(this.ad);
    ((UnreadBackBottomHelper)localObject).b(this.bi);
  }
  
  protected void am()
  {
    ((AppGuideTipsManager)this.d.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).b();
  }
  
  protected boolean an()
  {
    Intent localIntent = this.f.getIntent();
    boolean bool2 = false;
    if (localIntent == null) {
      return false;
    }
    if (!this.am) {
      return false;
    }
    int i1;
    if (this.f.getIntent().getIntExtra("sdk_share_type", 0) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      this.av = false;
      return false;
    }
    if (this.f.getIntent().getIntExtra("uintype", 0) == 10014) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool3 = TextUtils.isEmpty(this.f.getIntent().getStringExtra("key_b77_sdk_share"));
    boolean bool1;
    if (!this.av)
    {
      bool1 = bool2;
      if (i1 != 0)
      {
        bool1 = bool2;
        if (!(bool3 ^ true)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  protected void ao()
  {
    bf();
    if (this.f.getIntent() == null)
    {
      QLog.e(this.c, 1, "onShow_otherThings: intent == null");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new BaseChatPie.18(this));
    this.d.getQQProxyForQlink().c();
    this.m.sendEmptyMessageDelayed(31, 800L);
    bL();
    AvatarPendantUtil.a(this.d);
    BubbleDiyFetcher.a().a(this.d, 0);
    a(BaseApplication.getContext(), "com.vivo.smartshot");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isvivo has shot");
      ((StringBuilder)localObject).append(bn);
      QLog.d("vivo", 2, ((StringBuilder)localObject).toString());
    }
    if (!((IDPCApi)QRoute.api(IDPCApi.class)).isInited()) {
      this.i.p().b().d();
    }
    AIOUtils.a(this.d, this.ah.a, this.V.a(), null);
    Object localObject = this.Y;
    float f1 = this.ai;
    AIOUtils.a((View)localObject, (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), 0, 0);
    AIOUtils.a(this.w, 0, 0, 0, (int)(this.ai * 50.0F + 0.5F));
  }
  
  protected void ap()
  {
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_end", null, false, null);
    AIOUtils.a(this.c, "onShow start ", hashCode(), this.aE);
    StartupTracker.a(null, "AIO_onShow");
    StartupTracker.a(null, "AIO_onShow_emotion");
    StartupTracker.a("AIO_onShow_emotion", null);
    am();
    StartupTracker.a(null, "AIO_onShow_updateUI");
    bK();
    StartupTracker.a("AIO_onShow_updateUI", "AIO_onShow_videoStatus");
    bJ();
    StartupTracker.a("AIO_onShow_videoStatus", "AIO_onShow_report");
    q(this.f.getIntent());
    StartupTracker.a("AIO_onShow_report", "AIO_onShow_otherThings");
    ao();
    StartupTracker.a("AIO_onShow_otherThings", "AIO_onShow_setReaded");
    bM();
    StartupTracker.a("AIO_onShow_setReaded", null);
    ThreadPriorityManager.a(false);
    this.g.b(10);
    this.aX.a(1000, new Object[0]);
    StartupTracker.a("AIO_onShow", null);
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "AIOTime onShow end");
    }
    if (!(this instanceof TroopChatPie)) {
      AIOAnimationControlManager.a(this, true);
    }
    bF();
    bG();
  }
  
  @TargetApi(11)
  protected void aq()
  {
    PanelIconLinearLayout localPanelIconLinearLayout;
    if (this.i.p().d().a().a() == 2)
    {
      localPanelIconLinearLayout = this.W;
      if (localPanelIconLinearLayout != null)
      {
        localPanelIconLinearLayout.setAllEnable(false);
        if (VersionUtils.e()) {
          this.W.setAllAlpha(0.6F);
        }
      }
    }
    else
    {
      localPanelIconLinearLayout = this.W;
      if (localPanelIconLinearLayout != null)
      {
        localPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.e()) {
          this.W.setAllAlpha(1.0F);
        }
      }
    }
  }
  
  protected void ar()
  {
    int i1 = this.n.getCurrentPanel();
    PanelIconLinearLayout localPanelIconLinearLayout = this.W;
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
  
  public void as()
  {
    Object localObject = this.f;
    if ((localObject != null) && (this.n != null))
    {
      localObject = (InputMethodManager)((BaseActivity)localObject).getSystemService("input_method");
      if (localObject != null)
      {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.n.getWindowToken(), 0);
        if (QLog.isColorLevel()) {
          QLog.d(this.c, 2, new Object[] { "hideSoftInput, ", this.n.getWindowToken() });
        }
      }
    }
  }
  
  public boolean at()
  {
    return this.n.getCurrentPanel() != 0;
  }
  
  protected void au()
  {
    this.d.addObserver(this.bG);
    this.d.addObserver(this.bH);
    this.d.addObserver(this.bD);
    this.d.addObserver(this.bE);
    this.d.addObserver(this.bF);
    this.d.setCheckPttListener(this);
    this.d.getMessageFacade().addObserver(this);
    this.bg = new FontBubbleManager.FontBubbleObserver(this);
    this.d.addObserver(this.bg);
  }
  
  protected void av()
  {
    QQAppInterface localQQAppInterface = this.d;
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.removeObserver(this.bG);
    this.d.removeObserver(this.bH);
    this.d.removeObserver(this.bD);
    this.d.removeObserver(this.bE);
    this.d.removeObserver(this.bF);
    this.d.setCheckPttListener(null);
    if (this.d.getMessageFacade() != null) {
      this.d.getMessageFacade().deleteObserver(this);
    }
    this.d.removeObserver(this.bg);
  }
  
  public void aw()
  {
    this.n.b();
  }
  
  public void ax()
  {
    this.i.p().a().b();
  }
  
  public void ay()
  {
    this.i.p().a().c();
  }
  
  public void az()
  {
    ((AIOShakeHelper)this.g.a(65)).a();
  }
  
  public View b(int paramInt)
  {
    View localView = this.ae.b(paramInt);
    if (localView != null) {
      return localView;
    }
    return null;
  }
  
  protected HelperProvider b()
  {
    return new HelperProvider(this.f);
  }
  
  protected String b(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    return ChatActivityUtils.a(this.e, paramMessageRecord, this.d);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    aq();
    ar();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doPanelChanged newPanel=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("inputx", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (IApolloAIOHelper)q(8);
    if (localObject != null) {
      ((IApolloAIOHelper)localObject).doOnPanelChanged(paramInt1, paramInt2);
    }
    this.i.p().d().b().a(paramInt2);
    this.ae.b(paramInt1, paramInt2);
    ((IceBreakHelper)this.g.a(10)).a(paramInt1, paramInt2);
    ((SimpleUIAIOHelper)q(29)).a(paramInt1, paramInt2);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.f.getChatFragment();
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).q();
      if (localObject != null) {
        ((ImmersiveTitleBar2)localObject).setBackgroundColor(paramInt);
      }
    }
  }
  
  public final void b(long paramLong)
  {
    this.j.d().c(paramLong);
  }
  
  protected void b(Intent paramIntent)
  {
    this.p.setRight2Icon(2130853300, 2130853301);
    this.aX.c();
    a(true, false);
    c(paramIntent);
    b(false);
    u();
    this.aa = x();
    this.ab = w();
    i(paramIntent);
    f(paramIntent);
    D();
    z();
    this.j.b().g();
    this.j.b().b(false);
    this.h.a(paramIntent);
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.g.a(paramMotionEvent);
  }
  
  protected void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = AIOUtils.b(paramView);
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
      if (paramView.w != null) {
        paramView.w.n();
      }
    }
    else if ((paramView instanceof MixedMsgItemBuilder.MixedHolder))
    {
      paramView = (MixedMsgItemBuilder.MixedHolder)paramView;
      if (paramView.a != null) {
        paramView.a.n();
      }
    }
    else if ((paramView instanceof LongMsgItemBuilder.Holder))
    {
      paramView = (LongMsgItemBuilder.Holder)paramView;
      if (paramView.f != null) {
        paramView.f.n();
      }
    }
    else if ((paramView instanceof IApolloItemBuilder.Holder))
    {
      ((IApolloItemBuilder.Holder)paramView).a();
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    int i1 = this.V.b(paramChatMessage) + this.U.getHeaderViewsCount();
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
    int i2 = this.U.getFirstVisiblePosition();
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
    j(196614);
  }
  
  protected void b(String paramString)
  {
    this.I.setText(paramString);
  }
  
  protected void b(boolean paramBoolean)
  {
    this.bf = paramBoolean;
    if ((paramBoolean) && (this.I.getVisibility() == 8))
    {
      this.I.setVisibility(0);
      G();
      return;
    }
    if ((!paramBoolean) && (this.I.getVisibility() == 0))
    {
      this.I.setVisibility(8);
      G();
    }
  }
  
  protected boolean ba()
  {
    return true;
  }
  
  public int bb()
  {
    return this.aE;
  }
  
  public void bc() {}
  
  public void bd()
  {
    if (this.bs == null) {
      this.bs = ((PowerManager)this.f.getSystemService("power")).newWakeLock(536870918, this.c);
    }
    if (!this.bs.isHeld()) {
      this.bs.acquire();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "remainScreenOn");
    }
  }
  
  public void be()
  {
    PowerManager.WakeLock localWakeLock = this.bs;
    if ((localWakeLock != null) && (localWakeLock.isHeld()))
    {
      this.bs.release();
      this.bs = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "cancelRemainScreenOn");
    }
  }
  
  public void bf()
  {
    this.p.b();
  }
  
  protected void bg()
  {
    if ((this.ah != null) && (this.e != null))
    {
      if (this.p == null) {
        return;
      }
      if (AnonymousChatHelper.a().a(this.ah.b)) {
        this.p.setBackgroundResource(2130844758);
      } else {
        this.p.d();
      }
      this.p.a(this.ah);
      if (this.ak)
      {
        TextView localTextView = this.ad;
        if (localTextView != null) {
          localTextView.setVisibility(8);
        }
        this.x.setVisibility(8);
      }
    }
  }
  
  public void bh()
  {
    this.i.p().a().a(this.i);
  }
  
  public AIOAnimationConatiner bi()
  {
    return this.aU;
  }
  
  public boolean bj()
  {
    return this.aD;
  }
  
  public void bk()
  {
    MediaPlayerManager localMediaPlayerManager = this.bw;
    if (localMediaPlayerManager != null)
    {
      localMediaPlayerManager.a(this.U);
      this.bw.a(true);
      ((AudioPanelAioHelper)q(128)).b(false, false);
    }
  }
  
  public RelativeLayout bl()
  {
    return this.o;
  }
  
  public XPanelContainer bm()
  {
    return this.n;
  }
  
  public boolean bn()
  {
    return this.Z.isEnabled();
  }
  
  public void bo()
  {
    if (this.C != null)
    {
      Object localObject = this.Y;
      if (localObject != null)
      {
        ((XEditTextEx)localObject).requestFocus();
        InputMethodUtil.a(this.Y);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.C.getText().toString());
        ((StringBuilder)localObject).append(" ");
        localObject = ((StringBuilder)localObject).toString();
        int i1 = this.Y.getSelectionStart();
        Editable localEditable = this.Y.getEditableText();
        if ((i1 >= 0) && (i1 < localEditable.length()))
        {
          localEditable.insert(i1, (CharSequence)localObject);
          return;
        }
        localEditable.append((CharSequence)localObject);
      }
    }
  }
  
  public long bp()
  {
    return this.bt;
  }
  
  public PanelManager bq()
  {
    return this.ae;
  }
  
  public boolean br()
  {
    return OneWayFriendHelper.a(this.d, this.ah.a, this.ah.b);
  }
  
  public boolean bs()
  {
    return this.aa;
  }
  
  public void bt()
  {
    ChatAdapter1 localChatAdapter1 = this.V;
    if (localChatAdapter1 != null) {
      localChatAdapter1.notifyDataSetChanged();
    }
  }
  
  public boolean bu()
  {
    return (this.aZ == null) || (this.n == null);
  }
  
  public AIOContext bv()
  {
    return this.i;
  }
  
  public int bw()
  {
    return this.aZ.getMeasuredHeight();
  }
  
  public TipsController bx()
  {
    return this.k;
  }
  
  protected AIOInput c()
  {
    return new AIOInputBuilder().a(this.i).a(new BaseMessageSender(this.i)).a();
  }
  
  protected void c(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_updateSession_updateTitle");
    Object localObject = paramIntent.getStringExtra("uinname");
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.c, 2, "updateSession_updateTitle nick == null");
      }
      paramIntent = ContactUtils.a(this.d, s(), this.ah.c, ContactUtils.c(this.ah.a), 3);
    }
    if (QLog.isColorLevel())
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSession_updateTitle curFriendNick");
      localStringBuilder.append(MessageRecordUtil.a(paramIntent));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    localObject = this.ah;
    ((SessionInfo)localObject).e = paramIntent;
    if (((SessionInfo)localObject).e != null)
    {
      this.C.setText(this.ah.e);
      if (AppSetting.e)
      {
        paramIntent = this.C.getText();
        this.C.setContentDescription(paramIntent);
        aX().setTitle(this.C.getText());
      }
    }
    else
    {
      QLog.e(this.c, 1, "updateSession_updateTitle sessionInfo.curFriendNick == null");
    }
    this.D.setVisibility(8);
    this.E.setVisibility(8);
    this.F.setVisibility(8);
    this.G.setVisibility(8);
    StartupTracker.a("AIO_updateSession_updateTitle", null);
  }
  
  public void c(View paramView)
  {
    this.aZ.addView(paramView);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.c, 2, "set left text from cancel");
    }
    this.aB = this.s.getText().toString();
    this.s.setText(2131887626);
    this.s.setBackgroundDrawable(null);
    if (QQTheme.isNowSimpleUI())
    {
      localObject = this.s;
      ((TextView)localObject).setPadding(0, ((TextView)localObject).getPaddingTop(), this.s.getPaddingRight(), this.s.getPaddingBottom());
    }
    Object localObject = this.p;
    if (localObject != null) {
      ((NavBarAIO)localObject).e();
    }
    ((AIOMultiActionHelper)q(66)).a(paramChatMessage);
    this.u.setVisibility(4);
    this.A.setVisibility(4);
    localObject = (AIOLongShotHelper)q(15);
    if (((AIOLongShotHelper)localObject).c())
    {
      ((AIOLongShotHelper)localObject).g();
      this.q.setVisibility(4);
      this.r.setVisibility(4);
    }
    this.aZ.findViewById(2131436236).setVisibility(4);
    localObject = this.W;
    if (localObject != null) {
      ((PanelIconLinearLayout)localObject).setCustomHeight(0);
    }
    a(true, paramChatMessage, false);
  }
  
  public void c(String paramString)
  {
    if (this.be == null)
    {
      this.be = LBSHandler.a(this.e, paramString, new BaseChatPie.29(this), null);
      ((TextView)this.be.findViewById(2131431870)).setText(this.e.getString(2131892267));
    }
    Dialog localDialog = this.be;
    if ((localDialog != null) && (!localDialog.isShowing()) && (!this.f.isFinishing()))
    {
      ((TextView)this.be.findViewById(2131431876)).setText(paramString);
      this.be.show();
    }
  }
  
  public boolean c(int paramInt)
  {
    return this.ae.c(paramInt);
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    if (this.U == null) {
      return true;
    }
    return this.g.b(paramMotionEvent);
  }
  
  protected boolean c(boolean paramBoolean)
  {
    if (BaseChatItemLayout.ad)
    {
      if (!this.aO)
      {
        a(false, null, false);
        return true;
      }
      MultiMsgManager.a().e = 0;
    }
    return paramBoolean;
  }
  
  protected AIOContext d()
  {
    return new AIOContext();
  }
  
  public void d(int paramInt)
  {
    paramInt = Math.max(paramInt, 0);
    Object localObject2 = (LinearLayout)this.aZ.findViewById(2131433921);
    if (localObject2 != null) {
      localObject1 = (LinearLayout.LayoutParams)((LinearLayout)localObject2).getLayoutParams();
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (paramInt != ((LinearLayout.LayoutParams)localObject1).bottomMargin))
    {
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = paramInt;
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((SimpleUIAIOHelper)q(29)).f();
    }
    Object localObject1 = this.i.p().d().c().a();
    if (localObject1 != null)
    {
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      paramInt += this.X.getPaddingBottom();
      if (paramInt != ((RelativeLayout.LayoutParams)localObject2).bottomMargin)
      {
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramInt;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
  }
  
  protected void d(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "updateSession");
    }
    StartupTracker.a(null, "AIO_updateSession_initIntentData");
    a(paramIntent);
    StartupTracker.a("AIO_updateSession_initIntentData", "AIO_updateSession_updateUI");
    e(paramIntent);
    b(paramIntent);
    StartupTracker.a("AIO_updateSession_updateUI", "AIO_updateSession_forwardType");
    a(paramIntent, true);
    StartupTracker.a("AIO_updateSession_forwardType", "AIO_updateSession_otherThings");
    j(paramIntent);
    this.W.a(this);
    StartupTracker.a("AIO_updateSession_otherThings", null);
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "AIOTime updateSession end");
    }
  }
  
  public void d(MotionEvent paramMotionEvent)
  {
    this.aZ.onTouchEvent(paramMotionEvent);
  }
  
  public void d(View paramView)
  {
    this.aZ.removeView(paramView);
  }
  
  public void d(String paramString)
  {
    this.aB = paramString;
  }
  
  @TargetApi(13)
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.bB = this.f.getRequestedOrientation();
      int i4 = this.d.getApplication().getResources().getConfiguration().orientation;
      paramBoolean = VersionUtils.b();
      int i1 = 0;
      int i2 = 0;
      int i3 = 1;
      Object localObject;
      if (!paramBoolean)
      {
        if (i4 == 1)
        {
          localObject = this.f;
          i1 = i3;
          if (VersionUtils.c()) {
            i1 = 7;
          }
          ((BaseActivity)localObject).setRequestedOrientation(i1);
          return;
        }
        if (i4 == 2)
        {
          localObject = this.f;
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
          localObject = this.f.getWindowManager().getDefaultDisplay();
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
          this.f.setRequestedOrientation(i1);
          return;
        }
        i1 = this.f.getWindowManager().getDefaultDisplay().getRotation();
        if ((i1 != 0) && (i1 != 1))
        {
          if ((i1 == 2) || (i1 == 3))
          {
            if (i4 == 1)
            {
              this.f.setRequestedOrientation(9);
              return;
            }
            if (i4 == 2) {
              this.f.setRequestedOrientation(8);
            }
          }
        }
        else
        {
          if (i4 == 1)
          {
            this.f.setRequestedOrientation(1);
            return;
          }
          if (i4 == 2) {
            this.f.setRequestedOrientation(0);
          }
        }
      }
    }
    else
    {
      this.f.setRequestedOrientation(this.bB);
    }
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new Scroller()).a(new ListUI(this.i)).a(new UnreadTask(this.i)).a();
  }
  
  protected final List<ChatMessage> e(boolean paramBoolean)
  {
    return this.j.c().a(this.i, paramBoolean);
  }
  
  public void e(int paramInt)
  {
    if (this.ao == null) {
      this.ao = new QQProgressDialog(this.e, A());
    }
    this.ao.c(paramInt);
    this.ao.show();
  }
  
  protected void e(Intent paramIntent)
  {
    this.g.b(3);
  }
  
  protected TipsController f()
  {
    return new TipsController(this.i);
  }
  
  protected void f(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.aj = true;
      bf();
      this.p.setLeftContentDescription(HardCodeUtil.a(2131899211));
    }
    else if (localObject1 != null)
    {
      this.aj = ((Bundle)localObject1).getBoolean("isBack2Root");
      if (this.aj)
      {
        bf();
        this.p.setLeftContentDescription(HardCodeUtil.a(2131899221));
      }
    }
    boolean bool1 = paramIntent.getBooleanExtra("key_jump_from_qzone_feed", false);
    boolean bool2 = paramIntent.getBooleanExtra("isFromDiscussionFlyTicket", false);
    boolean bool3 = paramIntent.getBooleanExtra("need_to_show_unread_num", false);
    if (bool2)
    {
      this.Q = true;
    }
    else
    {
      if (bool1)
      {
        localObject1 = paramIntent.getStringExtra("key_jump_from_qzone_feed_left_title");
        if (localObject1 == null) {
          localObject1 = this.d.getApplication().getString(2131887625);
        } else {
          localObject1 = this.d.getApplication().getString(2131914753, new Object[] { localObject1 });
        }
        this.Q = false;
        break label284;
      }
      if (!bool3) {
        break label207;
      }
      this.Q = true;
    }
    localObject1 = null;
    break label284;
    label207:
    Object localObject2 = paramIntent.getStringExtra("leftViewText");
    if ((!this.aj) && ((localObject2 == null) || (!((String)localObject2).contains(this.d.getApplication().getString(2131917002))))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.Q = bool1;
    localObject1 = localObject2;
    if (this.aF)
    {
      this.Q = true;
      localObject1 = localObject2;
    }
    label284:
    if (this.Q)
    {
      long l1 = System.currentTimeMillis();
      ThreadManagerV2.excute(new BaseChatPie.8(this), 32, null, true);
      if (QLog.isColorLevel())
      {
        localObject2 = this.c;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("AIOTime doOnCreate_initUI updateUnreadNumOnTitleBar cost: ");
        ((StringBuilder)localObject3).append(System.currentTimeMillis() - l1);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      localObject3 = this.s;
      if (localObject1 == null) {
        localObject2 = this.d.getApplication().getString(2131887625);
      } else {
        localObject2 = localObject1;
      }
      ((TextView)localObject3).setText((CharSequence)localObject2);
      bf();
    }
    Object localObject3 = paramIntent.getStringExtra("backName");
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      this.s.setText((CharSequence)localObject3);
      bf();
      localObject2 = paramIntent.getStringExtra("comicId");
      TextView localTextView = this.s;
      paramIntent = (Intent)localObject2;
      if (localObject2 == null) {
        paramIntent = "";
      }
      localTextView.setTag(new String[] { "comic", paramIntent });
      this.s.setContentDescription("返回QQ动漫");
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set left text from update left: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", back: ");
      ((StringBuilder)localObject2).append((String)localObject3);
      QLog.i(paramIntent, 2, ((StringBuilder)localObject2).toString());
    }
    if (ChatActivityConstants.b)
    {
      this.u.setContentDescription(HardCodeUtil.a(2131899191));
      if (!this.Q)
      {
        localObject1 = this.s.getText().toString();
        paramIntent = (Intent)localObject1;
        if (!this.d.getApplication().getString(2131887440).equals(localObject1))
        {
          paramIntent = new StringBuilder();
          paramIntent.append(HardCodeUtil.a(2131901576));
          paramIntent.append((String)localObject1);
          paramIntent.append(HardCodeUtil.a(2131899193));
          paramIntent = paramIntent.toString();
        }
        this.s.setContentDescription(paramIntent);
      }
    }
    paramIntent = this.p;
    if (paramIntent != null)
    {
      paramIntent.e();
      bool1 = ((AudioPanelAioHelper)q(128)).i;
      this.p.a(bool1 ^ true, this.ah.a);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.g.a(paramBoolean)) {
      return;
    }
    g(paramBoolean);
  }
  
  public boolean f(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 4) || (paramInt == 5))
    {
      SplashActivity.sExitAIOCode = HardCoderManager.getInstance().start(0, 1, 0, 0, 2000, 302, 8L, Process.myTid(), "exitAIO");
      SplashActivity.sExitAIOTime = SystemClock.uptimeMillis();
    }
    this.aE = 7;
    Object localObject1 = this.c;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("finish ");
    ((StringBuilder)localObject3).append(paramInt);
    AIOUtils.a((String)localObject1, ((StringBuilder)localObject3).toString(), hashCode(), this.aE);
    if (this.g.d(paramInt)) {
      return true;
    }
    if (u(paramInt)) {
      return true;
    }
    this.g.e(paramInt);
    ad();
    bI();
    if ((this.f.getIntent() != null) && (this.f.getIntent().getBooleanExtra("key_req_by_contact_sync", false))) {
      this.f.moveTaskToBack(true);
    }
    M();
    this.m.removeCallbacks(this.by);
    this.n.d();
    if (paramInt == 0)
    {
      X();
      try
      {
        localObject1 = this.s.getTag();
        localObject3 = (String[])localObject1;
        if ((localObject1 == null) || (!"comic".equals(localObject3[0]))) {
          break label340;
        }
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(this.d, "3006", "2", "40025", localObject3[1], new String[] { "3" });
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    else if ((paramInt == 1) || (paramInt == 4) || (paramInt == 5))
    {
      Object localObject2 = this.f;
      if ((localObject2 instanceof ChatActivity)) {
        ((BaseActivity)localObject2).finish();
      } else {
        X();
      }
      localObject2 = HapticManager.b();
      if (localObject2 != null) {
        ((HapticManager)localObject2).e();
      }
    }
    label340:
    if ((this.aF) && (!this.aG) && (AIOUtils.q))
    {
      this.f.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
      this.aG = true;
    }
    DuiButtonImageView.c();
    this.g.b(14);
    this.aE = 8;
    if (this.bv) {
      a(false, null, false);
    }
    BaseChatItemLayout.ad = this.bu;
    if (QLog.isColorLevel()) {
      QLog.i(this.c, 2, String.format("finish preCheckBoxVisible=[%b]", new Object[] { Boolean.valueOf(this.bu) }));
    }
    return false;
  }
  
  public void g()
  {
    this.g.a(this);
    this.h = new BaseChatpieHelper(this);
    this.ae = new PanelManager(this.e);
    PanelRegistry.a(this, this.ae);
  }
  
  protected void g(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 4) && (paramInt != 5))
    {
      if ((paramInt == 0) && (this.n.getCurrentPanel() == 0)) {
        bP();
      }
    }
    else {
      bP();
    }
  }
  
  protected void g(Intent paramIntent)
  {
    if (ForwardUtils.a(this.d, this.f, this.e, paramIntent, this.m)) {
      this.aj = this.f.getIntent().getBooleanExtra("isBack2Root", false);
    }
  }
  
  void g(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = this.f;
    if (localBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "mActivity == null");
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
      f(i1);
      return;
    }
    localBaseActivity.finish();
  }
  
  public Dialog h(int paramInt)
  {
    return this.g.c(paramInt);
  }
  
  protected void h()
  {
    this.c = "BaseChatPie";
  }
  
  public void h(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (!paramIntent.getBooleanExtra("click_long_screen_shot", false)) {
      return;
    }
    paramIntent = this.V;
    if (paramIntent != null) {
      paramIntent.p.a();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    this.n.a(2, paramBoolean);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.g.a(paramMessage)) {
      return true;
    }
    f(paramMessage);
    b(paramMessage);
    c(paramMessage);
    d(paramMessage);
    e(paramMessage);
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
                c(this.ah.s, 3);
                return true;
              }
              this.Y.setTypeface(VasShieldFont.c());
              return true;
            }
            bc();
            return true;
          }
          a(paramMessage);
          return true;
        }
        if ((this.U != null) && (paramMessage.arg1 > 50))
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.U.getLayoutParams();
          if ((localLayoutParams != null) && (localLayoutParams.bottomMargin != paramMessage.arg1))
          {
            localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramMessage.arg1);
            this.U.setLayoutParams(localLayoutParams);
            return true;
          }
        }
      }
      else
      {
        paramMessage = (PlusPanel)this.ae.d(8);
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
        ReportController.b(this.d, "CliOper", "", "", "0X8005B00", "0X8005B00", 0, 0, "", "", "", "");
      }
      this.p.a(bool);
    }
    return true;
  }
  
  public final QQAppInterface i()
  {
    return this.d;
  }
  
  protected void i(int paramInt) {}
  
  public void i(boolean paramBoolean) {}
  
  public final MqqHandler j()
  {
    return this.m;
  }
  
  public final void j(int paramInt)
  {
    this.j.f().a(paramInt);
  }
  
  public void j(boolean paramBoolean)
  {
    this.aw = paramBoolean;
  }
  
  public void k()
  {
    this.aE = 2;
    AIOUtils.a(this.c, "preStartBaseAIO", hashCode(), this.aE);
    this.aY = false;
    this.j.e().c(false);
    this.j.f().a(false);
    this.aC = true;
    this.aI = false;
    this.aK = false;
    this.aD = false;
    this.bu = BaseChatItemLayout.ad;
    BaseChatItemLayout.ad = false;
    AIOUtils.a(false);
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_begin", null, false, null);
    this.ai = this.d.getApplication().getResources().getDisplayMetrics().density;
    StartupTracker.a(null, "AIO_doOnCreate_initUI");
    l();
    StartupTracker.a("AIO_doOnCreate_initUI", "AIO_doOnCreate_initData");
    q();
    StartupTracker.a("AIO_doOnCreate_initData", "AIO_updateSession");
  }
  
  protected void k(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateListUnRead: ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 0)
    {
      localObject1 = this.ad;
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(Integer.toString(paramInt));
        this.ad.setVisibility(8);
        break label138;
      }
    }
    if (paramInt > 0)
    {
      if (this.ad == null) {
        al();
      }
      localObject2 = this.ad;
      if (paramInt > 99) {
        localObject1 = "99";
      } else {
        localObject1 = Integer.toString(paramInt);
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.ad.setVisibility(0);
      ((UnreadBackBottomHelper)q(53)).b();
    }
    label138:
    if ((this.ad != null) && (BaseChatItemLayout.ad)) {
      this.ad.setVisibility(8);
    }
  }
  
  public void k(boolean paramBoolean)
  {
    this.f.getSupportFragmentManager();
    this.f.getChatFragment();
    ChatAdapter1 localChatAdapter1 = this.V;
    if (localChatAdapter1 != null) {
      localChatAdapter1.h = paramBoolean;
    }
  }
  
  protected void l()
  {
    this.aL = ThemeUtil.isDefaultOrDIYTheme(false);
    this.n = ((XPanelContainer)this.aZ.findViewById(2131445137));
    this.ae.a(this.n);
    this.n.setOnPanelChangeListener(this);
    this.n.setOnChangeMultiScreenListener(this);
    this.n.setReadyToShowChangeListener(new BaseChatPie.2(this));
    Object localObject = this.n;
    ((XPanelContainer)localObject).i = true;
    ((XPanelContainer)localObject).setReadyToShow(false);
    this.ba = ((ViewGroup)this.aZ.findViewById(2131427887));
    this.o = ((RelativeLayout)this.aZ.findViewById(2131430542));
    this.k.f();
    this.p = ((NavBarAIO)this.aZ.findViewById(2131444897));
    this.bd = ((QQBlurView)this.aZ.findViewById(2131429596));
    this.aM = ((ImageView)this.aZ.findViewById(2131444898));
    this.q = ((ViewGroup)this.aZ.findViewById(2131447534));
    this.r = ((ViewGroup)this.aZ.findViewById(2131446540));
    this.s = ((TextView)this.aZ.findViewById(2131436180));
    this.t = ((TextView)this.aZ.findViewById(2131436218));
    this.w = ((ImageView)this.aZ.findViewById(2131436666));
    this.x = ((TextView)this.aZ.findViewById(2131448219));
    this.z = ((RelativeLayout)this.aZ.findViewById(2131436236));
    this.u = ((ImageView)this.aZ.findViewById(2131436194));
    this.v = ((FrameLayout)this.aZ.findViewById(2131436209));
    this.N = ((ImageView)this.aZ.findViewById(2131444531));
    this.O = ((ImageView)this.aZ.findViewById(2131444532));
    this.O.setVisibility(8);
    this.A = ((ImageView)this.aZ.findViewById(2131436189));
    this.A.setContentDescription(this.d.getApp().getString(2131893100));
    if (QLog.isColorLevel())
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("afroot: ");
      localStringBuilder.append(this.ba);
      localStringBuilder.append(", mDefautlBtnLeft: ");
      localStringBuilder.append(this.x);
      localStringBuilder.append(", isThemeDefault: ");
      localStringBuilder.append(this.aL);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.s.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.aZ.findViewById(2131437136).setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.u.setContentDescription(this.d.getApp().getString(2131887747));
    this.C = ((TextView)this.aZ.findViewById(2131447463));
    this.B = ((TextView)this.aZ.findViewById(2131431971));
    this.D = ((ImageView)this.aZ.findViewById(2131447511));
    this.E = ((ImageView)this.aZ.findViewById(2131447516));
    this.F = ((ImageView)this.aZ.findViewById(2131447512));
    this.G = ((ImageView)this.aZ.findViewById(2131447513));
    this.H = ((ImageView)this.aZ.findViewById(2131447514));
    this.K = ((QqViewFlipper)this.aZ.findViewById(2131447574));
    this.K.setMeasureAllChildren(false);
    this.I = ((TextView)this.aZ.findViewById(2131447572));
    this.J = ((TextView)this.aZ.findViewById(2131447573));
    this.R = ((ViewStub)this.aZ.findViewById(2131442044));
    this.L = ((ImageView)this.aZ.findViewById(2131432177));
    this.U = ((ChatXListView)this.aZ.findViewById(2131437281));
    this.U.setChatPie(this);
    this.U.setOnTouchListener(this);
    this.U.setOnScrollListener(this);
    this.U.setOnScrollToButtomListener(this);
    this.U.setLongClickable(true);
    this.U.setShowPanelListener(this);
    this.U.setRecyclerListener(this);
    this.bK = new GestureDetector(this.e, new BaseChatPie.MyOnGestureListener(this));
    this.aU = ((AIOAnimationConatiner)this.aZ.findViewById(2131428370));
    this.aU.a(this.U);
    this.aV = new AIOFooterViewDetector(this.e, this.U, this);
    this.V = m();
    this.j.b().a(this.U, this.V);
    this.j.d().a(this.i, this.U, this.V, this.aV);
    this.bb = ((QQBlurView)this.aZ.findViewById(2131449300));
    this.W = ((PanelIconLinearLayout)this.aZ.findViewById(2131439817));
    this.W.a(this.d, this.ah, this);
    this.W.setPanelIconListener(this);
    this.W.setHelperProvider(this.g);
    this.Y = ((XEditTextEx)this.aZ.findViewById(2131435808));
    this.Z = ((PatchedButton)this.aZ.findViewById(2131433920));
    this.X = ((InputLinearLayout)this.aZ.findViewById(2131435809));
    this.l.a(n());
    this.l.d().h();
    this.l.d().g();
    this.l.d().j();
    this.n.a(this.Y);
    this.g.b(0);
    this.l.d().i();
    this.aM.setVisibility(8);
    a();
    o();
    BlurUtil.a(this.bd, this.aZ, 2131168025, r(2131445137));
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject = (ViewGroup)this.aZ.findViewById(2131440610);
      SystemDragUtils.a(this.d, (ViewGroup)localObject, aX(), aE());
    }
  }
  
  public void l(int paramInt)
  {
    this.g.b(8);
    this.n.setReadyToShow(true);
    StartupTracker.a("AIO_SysMsgCost", "AIO_onShow_first");
    this.aD = true;
    this.m.removeCallbacks(this.by);
    Object localObject = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShowFirst ");
    localStringBuilder.append(paramInt);
    AIOUtils.a((String)localObject, localStringBuilder.toString(), hashCode(), this.aE);
    AIOUtils.a(false);
    this.j.f().a(false);
    j(131072);
    t();
    r(this.f.getIntent());
    this.j.b().b(true);
    if ((this.ah.a == 0) && (Utils.c(this.ah.b))) {
      ThreadManager.executeOnSubThread(new BaseChatPie.19(this), true);
    }
    localObject = new BaseChatPie.20(this);
    if (AppSetting.g) {
      ThreadManager.executeOnSubThread((Runnable)localObject, true);
    } else {
      ((Runnable)localObject).run();
    }
    ap();
    if (this.aO) {
      this.aV.b();
    }
    y();
    DuiButtonImageView.b();
    StartupTracker.a("AIO_onShow_first", null);
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.Y, new Object[] { Integer.valueOf(8) });
      }
      catch (Exception localException)
      {
        QLog.w(this.c, 2, "disable auto fill error", localException);
      }
    }
    if (!PEPanelHelper.i) {
      ThreadManager.executeOnSubThread(new BaseChatPie.21(this));
    }
    if (SplashActivity.sOpenAIOCode != 0)
    {
      HardCoderManager.getInstance().stop(SplashActivity.sOpenAIOCode);
      SplashActivity.sOpenAIOCode = 0;
    }
    VasShieldFont.a(this.d, j(), this.ah);
    UrlSecurityCheckManager localUrlSecurityCheckManager = (UrlSecurityCheckManager)this.d.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
    localUrlSecurityCheckManager.a(this.ah.a, this.ah.b);
    localUrlSecurityCheckManager.a(this.U, this.V);
    bF();
    bG();
    this.g.b(9);
  }
  
  public void l(boolean paramBoolean)
  {
    this.j.f().a(paramBoolean);
  }
  
  @NotNull
  protected ChatAdapter1 m()
  {
    return new ChatAdapter1(this.d, this.f, this.ah, this.aU, this);
  }
  
  @TargetApi(11)
  public void m(int paramInt)
  {
    this.i.p().d().a().a(paramInt);
  }
  
  public void m(boolean paramBoolean)
  {
    Object localObject = this.n;
    if (localObject != null) {
      ((XPanelContainer)localObject).setIsInMultiScreen(paramBoolean);
    }
    localObject = this.V;
    if (localObject != null) {
      ((ChatAdapter1)localObject).h = paramBoolean;
    }
  }
  
  protected InputUIContainer n()
  {
    return new InputUIContainerBuilder().a(this.i).a(new InputBarUI(this.i, this.X)).a(new EditTextUI(this.i, this.Y)).a(new FunBtnUI(this.i, this.Z)).a(new InputRightIconUI(this.i)).a();
  }
  
  public void n(int paramInt)
  {
    AIOAnimationConatiner localAIOAnimationConatiner = this.aU;
    if (localAIOAnimationConatiner != null) {
      localAIOAnimationConatiner.c(paramInt);
    }
    ((UnreadBackBottomHelper)q(53)).c(paramInt);
  }
  
  public void n(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      ((CommonTextView)this.C).setMosaicEffect(new MosaicEffect(10));
      localObject = this.I;
      if ((localObject instanceof OnlineStatusLyricView)) {
        ((OnlineStatusLyricView)localObject).setMosaicEffect(new MosaicEffect(10));
      }
      ((CommonTextView)this.J).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.D).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.E).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.F).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.G).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.H).setMosaicEffect(new MosaicEffect(10));
      localObject = this.f.findViewById(2131432290);
      if (localObject != null) {
        ((CommonImageView)localObject).setMosaicEffect(new MosaicEffect(10));
      }
      localObject = this.f.findViewById(2131432291);
      if (localObject != null) {
        ((CommonImageView)localObject).setMosaicEffect(new MosaicEffect(10));
      }
      ((CommonTextView)this.B).setMosaicEffect(new MosaicEffect(10));
      if (!AnonymousChatHelper.a().a(this.ah.b))
      {
        localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130852162);
        this.ba.setBackgroundDrawable((Drawable)localObject);
        QLog.d(this.c, 1, "enableMosaicEffect, setAIO bg skin_chat_background");
        this.ah.H = new ChatBackground();
        this.ah.H.c = ((Drawable)localObject);
        this.ah.H.b = ColorStateList.valueOf(1711276032);
      }
    }
    else
    {
      ((CommonTextView)this.C).setMosaicEffect(null);
      localObject = this.I;
      if ((localObject instanceof OnlineStatusLyricView)) {
        ((OnlineStatusLyricView)localObject).setMosaicEffect(null);
      }
      ((CommonTextView)this.J).setMosaicEffect(null);
      ((CommonImageView)this.D).setMosaicEffect(null);
      ((CommonImageView)this.E).setMosaicEffect(null);
      ((CommonImageView)this.F).setMosaicEffect(null);
      ((CommonImageView)this.G).setMosaicEffect(null);
      ((CommonImageView)this.H).setMosaicEffect(null);
      localObject = this.f.findViewById(2131432290);
      if (localObject != null) {
        ((CommonImageView)localObject).setMosaicEffect(null);
      }
      localObject = this.f.findViewById(2131432291);
      if (localObject != null) {
        ((CommonImageView)localObject).setMosaicEffect(null);
      }
      ((CommonTextView)this.B).setMosaicEffect(null);
      R();
    }
  }
  
  protected void o()
  {
    QQBlurView localQQBlurView = this.bb;
    boolean bool = false;
    if (localQQBlurView == null)
    {
      QLog.d(this.c, 1, new Object[] { "[initBottomBlurView] mBottomBlurView is null! Context: ", this.e });
      return;
    }
    SimpleModeHelper.a(this.X);
    if (p())
    {
      this.bb.setVisibility(0);
      this.bb.a(this.aZ);
      localQQBlurView = this.bb;
      localQQBlurView.b(localQQBlurView);
      this.bb.a(8);
      this.bb.c(-1);
      if ((QQTheme.isNowSimpleUI()) && (BlurUtil.a())) {
        this.bb.a(this.o.getResources().getDrawable(2130851968));
      } else {
        this.bb.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
      }
      localQQBlurView = this.bb;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = true;
      }
      localQQBlurView.setEnableBlur(bool);
      this.bb.setDisableBlurDrawableRes(2130838106);
      this.bb.a(new BaseChatPie.3(this));
      this.bb.setDirtyListener(new BaseChatPie.4(this));
      this.bb.d();
      return;
    }
    this.bb.setVisibility(8);
  }
  
  public void o(int paramInt)
  {
    this.n.a(paramInt);
  }
  
  public void o(boolean paramBoolean)
  {
    this.Z.setEnabled(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    e(paramView);
    this.i.d().a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMovedToScrapHeap(View paramView)
  {
    if (paramView == null) {
      return;
    }
    PokeItemAnimationManager.c().a(paramView);
    Object localObject1 = AIOUtils.b(paramView);
    if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
    {
      localObject1 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
      if ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).a != null) && ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).q instanceof MessageForStructing)))
      {
        localObject1 = (MessageForStructing)((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).q;
        if ((((MessageForStructing)localObject1).structingMsg instanceof StructMsgForGeneralShare))
        {
          Object localObject2 = this.e;
          if (((localObject2 instanceof ChatActivity)) || ((localObject2 instanceof SplashActivity)))
          {
            if (((StructMsgForGeneralShare)((MessageForStructing)localObject1).structingMsg).mIsPAVideoStructMsg) {
              AIOVideoPlayController.a().a(paramView, (StructMsgForGeneralShare)((MessageForStructing)localObject1).structingMsg);
            }
            localObject2 = ((BaseActivity)this.e).getChatFragment().k().aT();
            localObject1 = ((StructMsgForGeneralShare)((MessageForStructing)localObject1).structingMsg).getLayoutStr();
            if (localObject2 != null) {
              ((StructingMsgItemBuilder.ViewCache)localObject2).a((String)localObject1, (ViewGroup)paramView.findViewById(2131430578));
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
      QLog.d(this.c, 2, "onNetMobile2Wifi readconfirm network change");
    }
    bQ();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onNetNone2Mobile readconfirm network change");
    }
    bQ();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onNetNone2Wifi readconfirm network change");
    }
    bQ();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onNetWifi2Mobile readconfirm network change");
    }
    bQ();
  }
  
  public void onNetWifi2None() {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.g.b(20);
    int i1 = this.U.getFooterViewsCount();
    int i2 = this.U.getHeaderViewsCount();
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
    Object localObject = (QWalletAIOLifeCycleHelper)q(27);
    if (localObject != null) {
      ((QWalletAIOLifeCycleHelper)localObject).a(paramInt1);
    }
    a(paramInt1, paramInt2, paramInt3, i1, i2, i3, i4);
    localObject = this.j.a().f().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsListView.OnScrollListener)((Iterator)localObject).next()).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (this.aR < paramInt1)
    {
      b(this.aP);
    }
    else
    {
      i1 = paramInt1 + paramInt2 - 1;
      if ((i1 < this.aS) && (i1 > 0)) {
        b(this.aQ);
      }
    }
    this.aR = paramInt1;
    i1 = paramInt1 + paramInt2;
    i2 = i1 - 1;
    if (i2 >= 0) {
      this.aS = i2;
    }
    this.aP = paramAbsListView.getChildAt(0);
    this.aQ = paramAbsListView.getChildAt(paramInt2 - 1);
    ((IceBreakHelper)this.g.a(10)).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (i1 == paramInt3) {
      this.j.d().m();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
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
    this.az = paramInt;
    NowVideoController.a().a(paramAbsListView, paramInt);
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      ScrollPlayer.a(false);
      this.V.c();
      URLDrawable.resume();
      if (this.aA)
      {
        this.aA = false;
        this.m.removeMessages(16711697);
        localObject = this.m.obtainMessage(16711697);
        this.m.sendMessageDelayed((Message)localObject, BubbleManager.b);
      }
      localObject = DropFrameMonitor.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("list_aio_");
      localStringBuilder.append(this.ah.a);
      ((DropFrameMonitor)localObject).a(localStringBuilder.toString(), false);
      DuiButtonImageView.e();
      if (this.j.f().d() == 0) {
        AIOSingleReporter.a().a(this.U);
      }
      ((UrlSecurityCheckManager)this.d.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER)).a(this.U, this.V);
      this.g.b(18);
    }
    else
    {
      ScrollPlayer.a(true);
      if (paramInt == 2) {
        this.V.b();
      } else {
        this.V.c();
      }
      URLDrawable.pause();
      localObject = DropFrameMonitor.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("list_aio_");
      localStringBuilder.append(this.ah.a);
      ((DropFrameMonitor)localObject).a(localStringBuilder.toString());
      DuiButtonImageView.d();
      ((UrlSecurityCheckManager)this.d.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER)).a();
    }
    Object localObject = this.j.a().f().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsListView.OnScrollListener)((Iterator)localObject).next()).onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (paramInt == 1) {
      this.g.b(16);
    } else if (paramInt == 2) {
      this.g.b(17);
    }
    if (paramInt == 1) {
      this.j.d().m();
    }
  }
  
  public void onScrollToButtom(int paramInt)
  {
    if (paramInt < 0)
    {
      this.bo = Boolean.valueOf(true);
      p(1);
      this.aK = true;
      UnreadBackBottomHelper localUnreadBackBottomHelper = (UnreadBackBottomHelper)q(53);
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
      Object localObject = (StickerRecHelper)q(14);
      if ((localObject != null) && (((StickerRecHelper)localObject).c()))
      {
        ((StickerRecHelper)localObject).b();
        localObject = (IApolloAIOHelper)q(8);
        if (localObject != null) {
          ((IApolloAIOHelper)localObject).showApolloView(true);
        }
        localObject = (AIOShortcutBarHelper)this.g.a(52);
        if (localObject != null) {
          ((AIOShortcutBarHelper)localObject).d(12);
        }
      }
    }
    ((FastImageHelper)q(83)).b(true);
    I();
    if (this.g.a(this.i, paramView, paramMotionEvent)) {
      return true;
    }
    int i2 = paramView.getId();
    if (i2 != 2131435808)
    {
      if (i2 != 2131437281) {
        return false;
      }
      ((AIOZhituHelper)this.i.a(116)).a();
      if ((this.au != null) && (this.ah.a == 1)) {
        this.au.a(paramMotionEvent);
      }
      if (i1 == 0) {
        this.bw.b(false);
      } else if ((i1 == 1) || (i1 == 3)) {
        this.bw.b(true);
      }
      this.bK.onTouchEvent(paramMotionEvent);
      return false;
    }
    this.Y.onTouch(paramView, paramMotionEvent);
    return false;
  }
  
  public void p(int paramInt)
  {
    if (bn == 1)
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
  
  protected boolean p()
  {
    return SimpleModeHelper.a();
  }
  
  public <T extends IHelper> T q(int paramInt)
  {
    return this.g.a(paramInt);
  }
  
  protected void q()
  {
    this.al = ((FriendListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.ah.H = new ChatBackground();
    this.bw = MediaPlayerManager.a(this.d);
    this.ar = true;
    this.aX = r();
    this.g.b(1);
  }
  
  protected TipsManager r()
  {
    return new TipsManager(this.i, this.d, this.ah, this.k.d().d(), this.n);
  }
  
  protected QQBlur.BackgroundViewDirtyListener r(int paramInt)
  {
    return new BaseChatPie.32(this, paramInt);
  }
  
  protected String s()
  {
    return this.ah.b;
  }
  
  public void t()
  {
    Object localObject;
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.X.findViewById(2131446058);
      ((View)localObject).setBackgroundResource(2130839241);
      ((View)localObject).setVisibility(0);
      localObject = this.X.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
    }
    else
    {
      localObject = this.X.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(true, false);
      }
      this.X.findViewById(2131446058).setVisibility(8);
    }
  }
  
  protected void u() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (a(paramObject)) {
      return;
    }
    if ((paramObject instanceof MessageRecord))
    {
      this.j.f().a(paramObject);
      return;
    }
    if ((paramObject instanceof RefreshMessageContext))
    {
      this.j.b().a(paramObject);
      return;
    }
    if ((paramObject instanceof BaseQQMessageFacade.MessageNotifyParam)) {
      b(paramObject);
    }
  }
  
  public void v()
  {
    this.W.setAllUnSelected();
    this.ae.v();
    this.i.p().d().b().a();
  }
  
  protected boolean w()
  {
    return false;
  }
  
  protected boolean x()
  {
    return false;
  }
  
  protected void y() {}
  
  protected void z()
  {
    this.A.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie
 * JD-Core Version:    0.7.0.1
 */