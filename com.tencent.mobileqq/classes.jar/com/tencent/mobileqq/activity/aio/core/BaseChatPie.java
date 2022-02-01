package com.tencent.mobileqq.activity.aio.core;

import aara;
import abem;
import abwp;
import abwx;
import abwz;
import acjp;
import acvu;
import acvv;
import acwc;
import aews;
import aewx;
import aeyb;
import aezf;
import aezl;
import aezn;
import aezp;
import aezq;
import afaz;
import afca;
import afcm;
import afdm;
import afdp;
import afgw;
import afhw;
import afih;
import afim;
import afls;
import afmp;
import afnn;
import afoi;
import afpb;
import afpo;
import afqg;
import afqj;
import afqw;
import afqx;
import afqy;
import afrb;
import afrd;
import afri;
import afrl;
import afrt;
import afrz;
import afsd;
import afsl;
import afsn;
import afss;
import afst;
import afsu;
import aftn;
import afvh;
import afvi;
import afvw;
import aghp;
import agib;
import agjd;
import agjt;
import agkc;
import agkg;
import agkm;
import agmk;
import agmx;
import agmy;
import agnj;
import agnu;
import agnv;
import agok;
import agpx;
import agpy;
import agql;
import agwt;
import agxc;
import agxe;
import ahcd;
import ahda;
import ahgc;
import ahiu;
import ahln;
import ahly;
import ahlz;
import ahmo;
import ahmq;
import ahov;
import ahpb;
import ahpe;
import ahpf;
import ahpk;
import ahpm;
import ahpw;
import ahpx;
import ahqa;
import ahqh;
import ahqj;
import ahqp;
import ahqs;
import ahrd;
import ahtj;
import ajiq;
import ajul;
import akxy;
import akya;
import akyb;
import almr;
import alne;
import alnn;
import alnr;
import alpg;
import alps;
import amal;
import amat;
import amaz;
import ambc;
import amlu;
import amnm;
import amoa;
import ampg;
import amph;
import ampv;
import amrh;
import amrp;
import amsu;
import amsw;
import amtj;
import amuu;
import amwf;
import amzb;
import anaz;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
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
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlo;
import anmr;
import aowj;
import aowk;
import apec;
import apff;
import apse;
import aqhd;
import aquj;
import aqwb;
import aqwf;
import aqwg;
import aqwt;
import arib;
import asbj;
import ashb;
import asln;
import atid;
import atmm;
import atoe;
import aubv;
import aucf;
import aucg;
import audg;
import audx;
import auen;
import aues;
import auet;
import aufo;
import augn;
import auij;
import auww;
import avli;
import avma;
import avmr;
import avnb;
import avnj;
import avsf;
import avsq;
import awcm;
import awgw;
import awgy;
import awhm;
import awhn;
import aydq;
import azbu;
import azca;
import azjc;
import azuu;
import azux;
import azxj;
import azye;
import azyi;
import babd;
import bamu;
import bapt;
import baqh;
import bbko;
import bbpn;
import bbub;
import bbwb;
import bbxj;
import bbyp;
import bcdm;
import bcef;
import bcer;
import bcgn;
import bcgr;
import bcws;
import bdav;
import bdyo;
import bdzi;
import becw;
import becx;
import bevq;
import bevs;
import bevt;
import beyh;
import bfas;
import bfbz;
import bfcf;
import bfcx;
import bfcy;
import bfip;
import bfpm;
import bfsu;
import bfta;
import bftc;
import bftf;
import bfth;
import bftk;
import bftt;
import bfua;
import bfur;
import bfwu;
import bfwz;
import bfxd;
import bfxf;
import bfyc;
import bfyg;
import bfyl;
import bfyz;
import bfzg;
import bgae;
import bgdk;
import bgga;
import bggc;
import bgsw;
import bhfj;
import bhht;
import bhjt;
import bily;
import bjmm;
import bjmp;
import bjnm;
import bjnw;
import bjon;
import bjsd;
import bjvd;
import bjvk;
import bjvm;
import bkfq;
import bkkh;
import bkmt;
import bkrk;
import bleg;
import blfa;
import blig;
import blvr;
import bmau;
import bnbb;
import com.immersion.stickersampleapp.HapticManager;
import com.rookery.translate.AITranslator;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.imcore.message.QQMessageFacade.MessageNotifyParam;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.logcat.LogcatUtil;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.helper.DecodeAIOInputBitmapHeightTask;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.AIOFakePanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob;
import com.tencent.mobileqq.activity.aio.rebuild.SaveTextDraftJob;
import com.tencent.mobileqq.activity.aio.tips.SougouInputGrayTips;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.MX3FlowCameraActivity;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper;
import com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ReportWorker;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.CommonImageView;
import com.tencent.mobileqq.widget.CommonTextView;
import com.tencent.mobileqq.widget.DrawableCenterTextView;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QqViewFlipper;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.mqq.shared_file_accessor.LogUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollButtomListener;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.ListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import gb;
import gm;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import lfg;
import lmt;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import nmy;
import npt;
import nrz;
import org.jetbrains.annotations.NotNull;
import ple;
import ynm;
import znt;
import zsj;
import zsz;

public class BaseChatPie
  implements acvu, aezl, afca, agxc, ajiq, ampg, amph, Handler.Callback, TextWatcher, View.OnClickListener, View.OnTouchListener, apff, bjsd, bjvk, bjvm, EmoticonCallback, INetInfoHandler, AbsListView.OnScrollButtomListener, AbsListView.OnScrollListener, AbsListView.RecyclerListener, Observer
{
  private static final int CALLER_ON_CREATE = 1;
  private static final int CALLER_ON_NEW_INTENT = 2;
  public static final int CAMERA_MODE_CAPTURE = 1;
  public static final int CAMERA_MODE_VIDEO = 2;
  public static final int FINISH_TYPE_BACK = 0;
  public static final int FINISH_TYPE_C = 2;
  public static final int FINISH_TYPE_INTERNAL = 3;
  public static final int FINISH_TYPE_REAL = 1;
  public static final int INVALID = 2;
  public static final long INVALID_SH_MSG_SEQ = -1L;
  public static int MAX_SOURCE_MSG_TEXT_LENGTH = 30;
  public static final int NAVIGATE_MAX_MSG_ITEM = 200;
  protected static final int PRE_PARSE_MSG_NUM = 8;
  public static final int PTT_RECORD_DELAY_TIME = 200;
  public static final int RECODING = 1;
  public static final int REPORT_FROM_REPLY = 1;
  public static final int STANDBY = 0;
  public static final String STATIC_TAG = "Q.aio.BaseChatPie";
  private static int inputMaxLength;
  public static boolean isStraightPtt;
  private static int isVivoShot;
  public static boolean preloaded;
  private static boolean refreshDelayForNextPie;
  public Dialog addFriendDialog;
  protected TextView addFriendTv;
  protected ViewStub addView;
  public ViewGroup afRoot;
  public aewx aioTipsController;
  public boolean apolloIsShowing;
  public QQAppInterface app;
  public QQCustomDialog authDialog;
  public afdm businessFooterDetector;
  private boolean canPullRefresh = true;
  Runnable cancelMessageBox = new BaseChatPie.44(this);
  private CardObserver cardObserver = new BaseChatPie.72(this);
  protected BaseChatpieHelper chatPieHelper;
  bggc cmShowActionObserver = new BaseChatPie.73(this);
  private ampv configObserver = new BaseChatPie.71(this);
  private boolean couldTrigerDismissPanel = true;
  private long createTime;
  private int currentPanelId = 0;
  protected String defaultEpId;
  protected int defaultPanelType = -1;
  protected int dirty = 131075;
  private aqwg doutuManager;
  private avsq emoticonManager;
  private amrh emoticonObserver = new BaseChatPie.74(this);
  private EmotionKeywordAdapter emotionKeywordAdapter;
  private EmotionKeywordHorizonListView emotionKeywordList;
  private EmotionKeywordLayout emotionLayout;
  public View expandStickerView;
  protected int fateOfRecorder = 0;
  private asbj fmob;
  public ImageView freeTalkImg;
  protected FriendListHandler friendListHandler;
  private amsu friendListObserver = new BaseChatPie.67(this);
  public boolean hasAutoInput;
  private boolean hasCheckedBoxVisible;
  public boolean hasDestory;
  private boolean hasDraftText;
  public volatile boolean hasSentRecvMsg;
  private volatile boolean hasSetReaded;
  boolean hasUnread = false;
  int hasUnreadCount = 0;
  protected View headView;
  public afqw helperProvider;
  private afih imeListener;
  public XEditTextEx input;
  public boolean isBack2Root;
  protected boolean isBeingInputDraft;
  public boolean isFromManageStranger;
  public boolean isFromOnCreate;
  protected boolean isFromSeachResult;
  boolean isHaveNewAfterIn = false;
  public boolean isJubaoMode;
  public boolean isMultiSelectHideIPB;
  private Boolean isNeedDelayShowUnreaded = Boolean.valueOf(true);
  boolean isOpenFromShare = false;
  boolean isOpenFromThirdParty = false;
  public boolean isOverScrollTarget;
  private boolean isPauseRefresh;
  protected boolean isPttOnlyBar;
  public boolean isSendToRobotServer;
  protected boolean isSimpleBar;
  public boolean isThemeDefault;
  private Boolean isVivoScrollToButtom = Boolean.valueOf(false);
  private long lastRefreshTime = -1L;
  private int lastVisiblePositionY = -1;
  protected LinearLayout linearLayout;
  public aezn listAdapter;
  public ChatXListView listView;
  protected boolean loadSearchedMessage;
  protected View loadingView;
  public zsj mAIOGiftPanelContainer;
  public ViewGroup mAIORootView;
  public FragmentActivity mActivity;
  public AIOAnimationConatiner mAnimContainer;
  public QQCustomDialog mApolloGameDialog;
  public amlu mApolloInfo;
  public ApolloPanel mApolloPanel;
  private int mApolloPanelStatus = -1;
  public alps mApolloViewController;
  public amnm mApolloViewObserver = new amnm(this);
  public aowj mArkController;
  protected ahpb mArkTipsBar;
  public AudioPanel mAudioPanel;
  public bhht mAuthEmoticonDialog;
  public bhht mAuthcmShowDialog;
  public long mBlockRefreshJumpBottomStartTime = -1L;
  protected List<QQOperationViopTipTask> mBlueTipsTaskList = new ArrayList();
  public QQBlurView mBottomBlurView;
  boolean mBubbleCacheMsgAborted = false;
  protected ahpe mC2BTipsBar;
  protected boolean mCacnelSellPttPanle;
  public afnn mChatDrawer;
  public aqwt mComboUIManager;
  public RelativeLayout mContent;
  public Context mContext;
  protected int mCurrentAIOState = -1;
  public NavBarAIO mCustomTitleView;
  protected ImageView mDefaultLeftBack;
  public TextView mDefautlBtnLeft;
  protected float mDensity;
  protected DoodlePanel mDoodlePanel;
  private avnb mDraftManager;
  public String mDraftText;
  public DrawerFrame mDrawerFrame;
  public int mEffectPullRefreshCount;
  protected EmoticonMainPanel mEmoPanel;
  protected EmotionSearchPanel mEmotionSearchPanel;
  protected boolean mEnableVideoBtn;
  private int mEnterExtPanel = 0;
  private boolean mEntryFriendCard;
  private int mExtPanelOnResumeTimes = 1;
  private ExtensionInfo mExtensionInfo;
  public View mFakeInput;
  RelativeLayout.LayoutParams mFakeInputParam;
  public View mFakeUpInput;
  RelativeLayout.LayoutParams mFakeUpInputParam;
  protected int mFirstVisibleItem;
  protected View mFirstVisibleView;
  protected PhotoListPanel mFlashPicPanel;
  audx mFontBubbleObserver;
  protected ahpk mFraudTipsBar;
  public PatchedButton mFunBtn;
  protected ahrd mFunCallTipBar;
  private lmt mGAudioObserver;
  protected TextView mGagInputBtn;
  private GestureDetector mGestureDetector;
  protected bfip mGiftAnimationController;
  private boolean mHasGuideVoiceChangerDone = true;
  aues mHiBoomAuthObserver;
  auet mHiBoomForwardAuthObserver;
  public HotPicMainPanel mHotPicMainPanel;
  public ImageButton mIconButtonInInputRight;
  public View mIconLayoutInInputRight;
  protected MessageQueue.IdleHandler mIdleHanlder;
  public InputLinearLayout mInputBar;
  private View.OnLayoutChangeListener mInputBarOnLayoutChangeListener;
  public InputGlobalLayoutListener mInputGloblLayoutListener;
  protected int mInputStat = 0;
  protected boolean mIsCurrentSession = true;
  boolean mIsFirstShowOpenIdMsg = true;
  boolean mIsFirtShowShareMsg = true;
  public boolean mIsFromVoiceChangerGuide;
  private boolean mIsMsgSignalOpen = false;
  private boolean mIsMsgSignaling;
  private int mJumpActionId = -1;
  protected int mLastVisibleItem;
  protected View mLastVisibleView;
  int mListViewBottomMargin = 0;
  protected ahqa mLocationShareTipBar;
  private avmr mMagicfaceViewController;
  protected View mMask;
  private int mMsgInputLen;
  private int mMsgSignalCount;
  private int mMsgSignalNetType;
  private int mMsgSignalSum;
  protected TextView mMsgbox;
  private View mMsgboxline;
  private NoC2CExtensionInfo mNoC2CExtensionInfo;
  private MovementMethod mNormalMovementMethod;
  protected ahqh mOperateTips;
  public ajul mPasswdRedBagManager;
  private int mPkgId = -1;
  private long mPreMrShMsgSeqForCurType = -1L;
  public bhht mProgressDialog;
  private TextView mPttBtn;
  private bhjt mPttPlayVolumeDialog;
  public amzb mQQMapActivityProxy;
  private int mReadedCnt;
  private BroadcastReceiver mReceiver = new BaseChatPie.33(this);
  private int mReceiverState;
  public bhjt mRecordToastDialog;
  private Runnable mRetryShowInputPanelTask;
  RichTextPanel mRichTextPanel;
  protected ImageView mRightButtonRedDot;
  private Runnable mRunOnShow = new BaseChatPie.1(this);
  bjvd mSCCallbak = new BaseChatPie.2(this);
  private PowerManager.WakeLock mScreenWakeLoack;
  int mScrollState = 0;
  protected ScrollerRunnable mScrollerRunnable;
  protected MoveToBottomScroller mScrollerdownRunnable;
  private anaz mShortVideoObserver = new BaseChatPie.75(this);
  public boolean mSingleTitle = true;
  public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  private boolean mStickerBubbleQuickButtonHandlingTouchDown;
  private boolean mStickerBubbleQuickButtonReported;
  private ahmo mStickerBubbleSendTouchDelegate;
  final agpy mStructingMsgItemViewCache = new agpy();
  public TextView mSubTilteText;
  public ViewGroup mSubTitleLayout;
  protected ImageView mSubTitleLeftImageView;
  public TextView mSubTitleText2;
  protected ahqp mTimTipsBar;
  protected View mTipRoot;
  protected RelativeLayout mTipsContainer;
  protected RelativeLayout mTipsLayout;
  public ahqs mTipsMgr;
  public ImageView mTitleBtnCall;
  protected TextView mTitleBtnLeft;
  protected ImageView mTitleBtnRight;
  protected RelativeLayout mTitleBtnRightLayout;
  protected ImageView mTitleBtnRightRedTip;
  public FrameLayout mTitleBtnRightSearch;
  public TextView mTitleBubbleLeft;
  protected TextView mTitleCount;
  protected int mTitleHeight;
  public ImageView mTitleIcon;
  public ImageView mTitleIcon2;
  public ImageView mTitleIconRight;
  public ViewGroup mTitleLayout;
  protected String mTitleLeftText = "";
  protected boolean mTitleShowUnread;
  public TextView mTitleText;
  protected View.OnClickListener mTroopReplyMsgSourceClick = new BaseChatPie.87(this);
  public bdzi mTroopTips;
  private TextView mUnReadTxt;
  private int mUnReadedCnt;
  protected becx mUserActionState;
  protected RelativeLayout mVideoBtn;
  protected VideoStatusTipsBar mVideoStatusBar;
  public QqViewFlipper mViewFlipper;
  protected VoiceTextPanel mVoiceTextEditPanel;
  private boolean mZhituButtonExposeReported;
  public boolean mZhituSwitch;
  protected ahpx mlightalkTipsBar;
  private MediaPlayerManager mpm;
  private Runnable msgSignalRunnable;
  public boolean needAutoInput;
  private boolean needInitTips = true;
  private boolean needRecreateAudioPanel;
  private boolean needRecreateEmotionPanel;
  private boolean needShowAudioWhenResume;
  boolean needUpload = false;
  private boolean needjumpToMsg = true;
  protected CharSequence oldSubTitleText;
  public boolean onShowDone;
  protected AIOFakePanel panelCamera;
  public agxe panelManager;
  public PanelIconLinearLayout panelicons;
  protected String pcmForVadPath;
  private ImageView phoneImage;
  public int playMode;
  private boolean preCheckBoxVisible;
  private int preRecordOrientation;
  Dialog pttMaskDialog;
  protected long pullReqTime = -1L;
  protected View qimRealAddView;
  private View receiptCover;
  public boolean receiptMode;
  public int recordCounts = -1;
  protected QQRecorder recorder;
  protected long recordingUniseq;
  private int refreshBottomCount;
  protected QQMessageFacade.RefreshMessageContext refreshMessageContext;
  private long refreshScrollMsg = -1L;
  public XPanelContainer root;
  protected boolean sendCloseSearchBroadCast;
  private int sendMsgSignalMaxCount = 10;
  protected boolean sendOnEnterEnabled;
  public SessionInfo sessionInfo = new SessionInfo();
  public boolean setSubTitleVisiable;
  protected TextView shieldTV;
  protected boolean showOnlineStatus;
  public AtomicBoolean showSendWantGiftMsg = new AtomicBoolean(false);
  protected View speakerPhoneLayout;
  public boolean speakerPhoneOn = true;
  private TextView speakerPhoneTextView;
  public String tag = "BaseChatPie";
  protected View timRealAddView;
  protected long timeOrSeq;
  public ImageView titleBgView;
  private View titleCover;
  private TextView tvReceiptTips;
  public final MqqHandler uiHandler = new bjmp(Looper.getMainLooper(), this, true);
  private long vasLastRefreshReqTime;
  protected final int verAnimDuration = 300;
  
  public BaseChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    setTag();
    this.app = paramQQAppInterface;
    this.mAIORootView = paramViewGroup;
    this.mActivity = paramFragmentActivity;
    this.mContext = paramContext;
    this.mTitleHeight = this.mContext.getResources().getDimensionPixelSize(2131299076);
    if (inputMaxLength == 0) {
      inputMaxLength = paramContext.getResources().getInteger(2131427342);
    }
    this.helperProvider = new afqw();
    this.helperProvider.a(this);
    initHelper();
    this.chatPieHelper = new BaseChatpieHelper(this);
    this.panelManager = new agxe(paramContext, this);
    this.panelManager.a();
  }
  
  private void addFriend()
  {
    boolean bool1 = false;
    boolean bool2 = isOneWayFriend();
    if (bool2) {
      bcef.b(this.app, "CliOper", "", this.sessionInfo.curFriendUin, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
    }
    FragmentActivity localFragmentActivity = this.mActivity;
    SessionInfo localSessionInfo = this.sessionInfo;
    String str = this.app.getApp().getString(2131690599);
    if (this.mActivity.getIntent().getStringExtra("param_return_addr") != null) {
      bool1 = true;
    }
    ChatActivityUtils.a(localFragmentActivity, localSessionInfo, str, bool1, bool2);
  }
  
  private void adjustInputInInputLayout()
  {
    if (this.isThemeDefault) {
      adjustInputLayout(AIOUtils.dp2px(1.0F, this.mActivity.getResources()));
    }
    for (;;)
    {
      if (this.mIconLayoutInInputRight.getVisibility() != 0) {
        this.input.setPadding(this.input.getPaddingLeft(), this.input.getPaddingTop(), AIOUtils.dp2px(11.0F, this.mActivity.getResources()), this.input.getPaddingBottom());
      }
      return;
      ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this), true);
    }
  }
  
  private void aioEventReport(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramIntent = paramIntent.getExtras();
    } while ((paramIntent == null) || (!this.needUpload));
    int i = paramIntent.getInt("aio_msg_source", 999);
    if (QLog.isDevelopLevel()) {
      QLog.d("reportEvent", 4, " AIO_MSG_SOURCE : " + i);
    }
    if (this.sessionInfo.curType == 1)
    {
      bcef.b(this.app, "CliOper", "", this.sessionInfo.curFriendUin, "AIO", "AIO_appear", 0, 0, ChatActivityUtils.b(this.sessionInfo.curType), String.valueOf(i), "", "");
      return;
    }
    bcef.b(this.app, "CliOper", "", "", "AIO", "AIO_appear", 0, 0, ChatActivityUtils.b(this.sessionInfo.curType), String.valueOf(i), "", "");
  }
  
  private void batchUpdateMessageCommon(ChatMessage paramChatMessage, MessageRecord paramMessageRecord)
  {
    aeyb localaeyb;
    if (isActivityResume())
    {
      ((afpo)this.helperProvider.a(65)).a(paramMessageRecord);
      if ((!paramMessageRecord.isread) && ((paramMessageRecord instanceof MessageForPoke)) && (!paramMessageRecord.isSend()))
      {
        this.app.getMsgCache().jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageRecord.uniseq), (MessageForPoke)paramMessageRecord);
        ((MessageForPoke)paramMessageRecord).isPlayed = false;
      }
      if ((!paramMessageRecord.isread) && (!paramMessageRecord.isSend()) && ((paramMessageRecord instanceof MessageForArkFlashChat)) && (!isFullScreenMode())) {
        ((FlashChatManager)this.app.getManager(217)).a((MessageForArkFlashChat)paramMessageRecord);
      }
      setReaded();
      if (this.sessionInfo.curType == 1) {
        awhn.a(this.app, this.sessionInfo.curFriendUin);
      }
      this.isHaveNewAfterIn = true;
      this.hasUnread = true;
      if ((!paramMessageRecord.isSend()) && (paramMessageRecord.msgtype == -2039) && (!alnr.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageRecord.uniseq)))) {
        alnr.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramMessageRecord.uniseq));
      }
      localaeyb = (aeyb)this.app.getManager(218);
      if (paramMessageRecord.isSend()) {
        break label322;
      }
      localaeyb.a(paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForText)) {
        ((bcws)this.app.getManager(272)).a(paramChatMessage);
      }
      if ((!(this instanceof ahiu)) || (!((ahiu)this).j) || (this.listView.getLastVisiblePosition() != this.listAdapter.getCount() - 1)) {
        break label331;
      }
      this.uiHandler.postDelayed(new BaseChatPie.34(this), 800L);
    }
    for (;;)
    {
      this.hasSentRecvMsg = true;
      return;
      label322:
      localaeyb.a(this, paramMessageRecord);
      break;
      label331:
      paramChatMessage.mMsgAnimFlag = true;
      refresh(196608);
    }
  }
  
  private boolean batchUpdateMessageConfess(Object paramObject, MessageRecord paramMessageRecord)
  {
    if (isActivityResume())
    {
      if (((paramMessageRecord instanceof MessageForUniteGrayTip)) && (this.sessionInfo.curFriendUin.equals(paramMessageRecord.senderuin)) && (apse.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.sessionInfo.curType, this.sessionInfo.topicId)))
      {
        MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)paramMessageRecord;
        String str = localMessageForUniteGrayTip.tipParam.c;
        localMessageForUniteGrayTip.hasRead = 1;
        localMessageForUniteGrayTip.updateUniteGrayTipMsgData(this.app);
        if (localMessageForUniteGrayTip.tipParam.b == 2097153) {
          awgy.a(this.app, this.sessionInfo, localMessageForUniteGrayTip, this.uiHandler, this.mAnimContainer, localMessageForUniteGrayTip.subType);
        }
      }
      afdp.a().a(this.app, this.sessionInfo, paramMessageRecord, this.mAnimContainer, this);
      if (beyh.a(this, this.app, paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  private void batchUpdateMessageForApollo(MessageRecord paramMessageRecord)
  {
    if ((32768 != paramMessageRecord.extraflag) && ((paramMessageRecord instanceof MessageForApollo))) {
      ((alnn)this.app.getManager(211)).a((MessageForApollo)paramMessageRecord, "aio");
    }
  }
  
  private void batchUpdateMessageLBS(ChatMessage paramChatMessage, MessageRecord paramMessageRecord)
  {
    if ((String.valueOf(AppConstants.SYSTEM_MSG_UIN).equalsIgnoreCase(paramMessageRecord.frienduin)) && (!paramMessageRecord.isread))
    {
      messageTips(this.app.getMessageFacade().getIncomingMsg());
      return;
    }
    if (isActivityResume())
    {
      this.hasUnread = true;
      setReaded();
      paramChatMessage.mMsgAnimFlag = true;
      refresh(196608);
    }
    this.hasSentRecvMsg = true;
  }
  
  private void batchUpdateMessageLocal(Object paramObject, MessageRecord paramMessageRecord)
  {
    setReaded();
    if (this.sessionInfo.curType == 1) {
      awhn.a(this.app, this.sessionInfo.curFriendUin);
    }
    this.isHaveNewAfterIn = true;
    this.hasSentRecvMsg = true;
    determineBatchUpdateJumpBottom(paramObject, paramMessageRecord);
    if (((paramMessageRecord instanceof MessageForStructing)) && ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 0))) {
      if ("viewMultiMsg".equals(((MessageForStructing)paramMessageRecord).structingMsg.mMsgAction)) {
        awcm.a().a(this.app, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, true);
      }
    }
    do
    {
      return;
      if (((paramMessageRecord instanceof MessageForText)) && (paramMessageRecord.istroop == 3000) && (paramMessageRecord.extraflag == 0))
      {
        batchUpdateMessageLocalDiscuss((MessageForText)paramMessageRecord);
        return;
      }
    } while (!(paramMessageRecord instanceof MessageForArkFlashChat));
    ((FlashChatManager)this.app.getManager(217)).a((MessageForArkFlashChat)paramMessageRecord);
  }
  
  private void batchUpdateMessageLocalDiscuss(MessageForText paramMessageForText)
  {
    if ((paramMessageForText.atInfoList != null) && (paramMessageForText.atInfoList.size() > 0))
    {
      bcef.b(this.app, "CliOper", "", "", "0X8006211", "0X8006211", 0, 0, "", "", "", "");
      if ((paramMessageForText.atInfoList == null) || (paramMessageForText.atInfoList.size() != 1)) {
        break label125;
      }
      if (!((MessageForText.AtTroopMemberInfo)paramMessageForText.atInfoList.get(0)).isIncludingAll()) {
        bcef.b(this.app, "CliOper", "", "", "0X8006212", "0X8006212", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return;
      label125:
      if ((paramMessageForText.atInfoList != null) && (paramMessageForText.atInfoList.size() > 1))
      {
        paramMessageForText = paramMessageForText.atInfoList.iterator();
        do
        {
          if (!paramMessageForText.hasNext()) {
            break;
          }
        } while (!((MessageForText.AtTroopMemberInfo)paramMessageForText.next()).isIncludingAll());
        for (int i = 1; i == 0; i = 0)
        {
          bcef.b(this.app, "CliOper", "", "", "0X8006213", "0X8006213", 0, 0, "", "", "", "");
          return;
        }
      }
    }
  }
  
  private void batchUpdateMessageOther(Object paramObject, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype != -2006) || (!(paramObject instanceof MessageForFoldMsg)))
    {
      paramObject = this.app.getMessageFacade().getIncomingMsg();
      if (MessageForPtt.class.isInstance(paramMessageRecord)) {
        paramObject.msg = ((MessageForPtt)paramMessageRecord).getSummaryMsg();
      }
      messageTips(paramObject);
    }
  }
  
  private boolean batchUpdateMessageRev(Object paramObject, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sendback", 2, "update mr.isBlessMsg" + paramMessageRecord.isBlessMsg);
    }
    if ((paramMessageRecord.msgtype == -1004) && (!this.sessionInfo.curFriendUin.equals(paramMessageRecord.frienduin))) {
      return true;
    }
    if (isNeedUpdate(paramMessageRecord)) {
      batchUpdateMessageCommon((ChatMessage)paramObject, paramMessageRecord);
    }
    for (;;)
    {
      updateUnreadNumOnTitleBar();
      if (((paramObject instanceof MessageForStructing)) || ((paramObject instanceof MessageForText))) {
        AIOUtils.preStartQWebIfNeed(this.app, this, this.listAdapter, (ChatMessage)paramObject);
      }
      return false;
      if (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && (this.sessionInfo.curFriendUin.equals(paramMessageRecord.senderuin)) && (abwz.d(this.sessionInfo.curType))) {
        batchUpdateMessageLBS((ChatMessage)paramObject, paramMessageRecord);
      } else if ((isActivityResume()) && (!paramMessageRecord.isread)) {
        batchUpdateMessageOther(paramObject, paramMessageRecord);
      }
    }
  }
  
  private boolean blockRefreshJumpBottom()
  {
    if (SystemClock.uptimeMillis() - this.mBlockRefreshJumpBottomStartTime <= 1000L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        Object localObject = getActivity();
        bool2 = bool1;
        if (localObject != null)
        {
          localObject = ((BaseActivity)localObject).getIntent();
          bool2 = bool1;
          if (localObject != null)
          {
            bool1 = ((Intent)localObject).getBooleanExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", false);
            bool2 = bool1;
            if (bool1)
            {
              ((Intent)localObject).removeExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM");
              this.mBlockRefreshJumpBottomStartTime = SystemClock.uptimeMillis();
              bool2 = bool1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "blockRefreshJumpBottom() block = " + bool2);
      }
      return bool2;
    }
  }
  
  private void branchUpdateMessage(Object paramObject)
  {
    if ((paramObject instanceof ChatMessage))
    {
      localMessageRecord = (MessageRecord)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "update mr.msgseq" + localMessageRecord.msgseq + ",time is:" + System.currentTimeMillis() + " status:" + localMessageRecord.extraflag);
      }
      batchUpdateMessageForApollo(localMessageRecord);
      if (batchUpdateMessageConfess(paramObject, localMessageRecord)) {}
      do
      {
        return;
        if (localMessageRecord.isSendFromLocal()) {
          break;
        }
      } while (batchUpdateMessageRev(paramObject, localMessageRecord));
      for (;;)
      {
        bcdm.a(0, 0, ((MessageRecord)paramObject).istroop, 1);
        return;
        batchUpdateMessageLocal(paramObject, localMessageRecord);
      }
    }
    MessageRecord localMessageRecord = (MessageRecord)paramObject;
    if (((paramObject instanceof DataLineMsgRecord)) && (!localMessageRecord.isread) && (!localMessageRecord.isSendFromLocal())) {
      messageTips(this.app.getMessageFacade().getIncomingMsg());
    }
    updateUnreadNumOnTitleBar();
  }
  
  private void branchUpdateMessageNotifyParam(Object paramObject)
  {
    paramObject = (QQMessageFacade.MessageNotifyParam)paramObject;
    if ((paramObject.uin.equals(this.sessionInfo.curFriendUin)) && (paramObject.operation == 0)) {
      instantUpdate(false, true);
    }
  }
  
  private void branchUpdateRefreshMessageContext(Object paramObject)
  {
    paramObject = (QQMessageFacade.RefreshMessageContext)paramObject;
    Object localObject = (aezq)paramObject.context;
    if (!android.text.TextUtils.equals(this.sessionInfo.curFriendUin, ((aezq)localObject).a())) {}
    do
    {
      return;
      if ((this.sessionInfo.curType == paramObject.uinType) && (this.pullReqTime != ((aezq)localObject).a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "refreshMessageContext sync other MiniAIO");
        }
        refresh(131073);
        return;
      }
    } while ((this.pullReqTime != ((aezq)localObject).a()) || (!paramObject.needRefreshAIO) || (!apse.a(paramObject.uinType, paramObject.topicId, this.sessionInfo.curType, this.sessionInfo.topicId)));
    localObject = paramObject.resultMsgList;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.mEffectPullRefreshCount += 1;
    }
    boolean bool;
    long l;
    if (!paramObject.isComplete)
    {
      bool = true;
      this.canPullRefresh = bool;
      l = this.pullReqTime + 300L - SystemClock.uptimeMillis();
      if (l <= 0L) {
        break label221;
      }
    }
    for (;;)
    {
      this.uiHandler.postDelayed(new BaseChatPie.35(this, paramObject), l);
      return;
      bool = false;
      break;
      label221:
      l = 0L;
    }
  }
  
  private void cancelSendPttInner(String paramString, long paramLong, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "cancelSendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
    }
    checkOrUpdatePttRecord(2, paramString, paramLong);
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (int i = 1; i == 0; i = 0)
    {
      bcgn.a(paramString, true);
      bcgn.a(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putInt("DiyTextId", paramRecorderParam.e);
      bcgn.a(paramString, this.app, this.sessionInfo.curFriendUin, paramLong, true, 0, paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.d, localBundle);
      return;
    }
    azbu.a(paramString);
  }
  
  private void cancelShieldMsg(String paramString)
  {
    ChatActivityUtils.a(this.app, this.mActivity, this.sessionInfo.curType, paramString, this.sessionInfo.phoneNum, true);
    if (this.sessionInfo.curType == 1010) {
      bcef.b(this.app, "CliOper", "", this.sessionInfo.curFriendUin, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
    }
  }
  
  private void changeCheckBoxHidden(AIOLongShotHelper paramAIOLongShotHelper)
  {
    this.mTitleBtnLeft.setBackgroundResource(2130850593);
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "set left text from set checkbox: " + this.mTitleLeftText);
    }
    if (android.text.TextUtils.isEmpty(this.mTitleLeftText))
    {
      this.mTitleBtnLeft.setText("");
      if (this.mCustomTitleView != null) {
        this.mCustomTitleView.e();
      }
      if (!this.isThemeDefault) {
        break label351;
      }
      if (!android.text.TextUtils.isEmpty(this.mDefautlBtnLeft.getText())) {
        break label340;
      }
      this.mDefautlBtnLeft.setVisibility(8);
    }
    for (;;)
    {
      awcm.a().a();
      paramAIOLongShotHelper.b();
      this.listAdapter.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      ((afpb)getHelper(66)).b();
      this.mTitleBtnRight.setVisibility(0);
      this.mTitleBtnRightSearch.setVisibility(8);
      if (this.app != null)
      {
        updateSession_updateTitleBtnCall();
        adjustTitleDimension();
      }
      if (this.isMultiSelectHideIPB)
      {
        showBottomBar();
        this.isMultiSelectHideIPB = false;
      }
      this.mAIORootView.findViewById(2131369124).setVisibility(0);
      this.mTitleLayout.setVisibility(0);
      this.mSubTitleLayout.setVisibility(0);
      paramAIOLongShotHelper = this.listView.getLayoutParams();
      if ((paramAIOLongShotHelper instanceof ViewGroup.MarginLayoutParams)) {
        paramAIOLongShotHelper = (ViewGroup.MarginLayoutParams)paramAIOLongShotHelper;
      }
      if ((this.mUnReadTxt != null) && (!android.text.TextUtils.isEmpty(this.mUnReadTxt.getText().toString())) && (!"0".equals(this.mUnReadTxt.getText().toString())))
      {
        this.mUnReadTxt.setVisibility(0);
        ((aftn)getHelper(53)).a();
      }
      amat.a(this.app, "select_more_msg", false);
      return;
      this.mTitleBtnLeft.setText(this.mTitleLeftText);
      this.mTitleLeftText = "";
      break;
      label340:
      this.mDefautlBtnLeft.setVisibility(0);
      continue;
      label351:
      this.mDefautlBtnLeft.setVisibility(8);
    }
  }
  
  private void changeCoverVisibility(int paramInt)
  {
    if (this.titleCover == null)
    {
      this.receiptCover = new View(this.mContext);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      int i = Color.parseColor("#7f000000");
      this.receiptCover.setBackgroundColor(i);
      this.receiptCover.setId(2131374020);
      this.receiptCover.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131374052);
      this.mContent.addView(this.receiptCover, (ViewGroup.LayoutParams)localObject);
      this.tvReceiptTips = new TextView(this.mContext);
      localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(40.0F, this.mContent.getResources()));
      this.tvReceiptTips.setGravity(17);
      this.tvReceiptTips.setTextSize(14.0F);
      this.tvReceiptTips.setId(2131374052);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368751);
      this.mContent.addView(this.tvReceiptTips, (ViewGroup.LayoutParams)localObject);
      this.titleCover = new View(this.mContext);
      localObject = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(2131299076));
      this.titleCover.setBackgroundColor(i);
      this.titleCover.setId(2131374050);
      this.titleCover.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131376501);
      this.afRoot.addView(this.titleCover, (ViewGroup.LayoutParams)localObject);
    }
    ((RelativeLayout.LayoutParams)this.listView.getLayoutParams()).addRule(2, 2131374052);
    this.receiptCover.setVisibility(paramInt);
    this.tvReceiptTips.setVisibility(paramInt);
    this.titleCover.setVisibility(paramInt);
    Object localObject = (ChatFragment)this.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if ((localObject == null) || (((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null)) {
      return;
    }
    if (paramInt == 0)
    {
      ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarMask(new PorterDuffColorFilter(2130706432, PorterDuff.Mode.SRC_ATOP));
      return;
    }
    ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarMask(null);
  }
  
  private void checkInitApolloViewController()
  {
    if (this.mApolloViewController == null) {
      this.mApolloViewController = new alps();
    }
  }
  
  private void chooseChatInputType(Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    if (isApolloForward()) {}
    label11:
    do
    {
      do
      {
        break label11;
        do
        {
          return;
        } while ((this.mCacnelSellPttPanle) || (isEmoPgkForward()));
        if (!this.mIsFromVoiceChangerGuide) {
          break;
        }
        initAudioPanelFlag(false, false);
      } while (this.needShowAudioWhenResume);
      this.mAudioPanel.setCurrentPannel(0, true);
      this.mHasGuideVoiceChangerDone = true;
      return;
    } while (chooseChatInputTypeRedPacket(paramIntent));
    boolean bool2;
    boolean bool1;
    if ((this.sessionInfo != null) && (!this.isSimpleBar))
    {
      paramIntent = (amsw)this.app.getManager(51);
      if ((this.sessionInfo.curType == 3000) || (this.sessionInfo.curType == 1))
      {
        bool2 = doChooseNoC2CInputType(paramIntent);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d(this.tag, 2, "chooseChatInputType doChooseNoC2CInputType needGuide = " + bool2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      showAudioPanelIfNeed(false, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.tag, 2, "chooseC2CChatInputType cost :" + (System.currentTimeMillis() - l));
      return;
      if (isC2CSession())
      {
        bool2 = doChooseC2CInputType(paramIntent);
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.tag, 2, "chooseChatInputType doChooseC2CInputType needGuide = " + bool2);
        bool1 = bool2;
        continue;
        if ((this.sessionInfo != null) && (this.isSimpleBar) && (QLog.isColorLevel())) {
          QLog.d(this.tag, 2, "chooseC2CChatInputType isSimpleBar = " + this.isSimpleBar);
        }
      }
      bool1 = false;
    }
  }
  
  private boolean chooseChatInputTypeRedPacket(Intent paramIntent)
  {
    if ((this.sessionInfo != null) && ((this.sessionInfo.curType == 3000) || (this.sessionInfo.curType == 1)))
    {
      paramIntent = paramIntent.getStringExtra("input_text_redpacket");
      if (!android.text.TextUtils.isEmpty(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "chooseChatInputType redPacketExtra");
        }
        setInputStat(0);
        this.input.setText(paramIntent);
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  private String clickSendTextButtonForC2C(afqj paramafqj, int paramInt1, int paramInt2, MixedMsgInfo paramMixedMsgInfo, MessageRecord paramMessageRecord, acwc paramacwc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
    }
    if (paramacwc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
    {
      paramacwc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
      if (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg))) {
        paramacwc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.oriMsgType = 1;
      }
      if (paramMessageRecord != null) {
        paramacwc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.packSourceMsg(this.app, paramMessageRecord);
      }
    }
    ArrayList localArrayList = new ArrayList();
    String str = bevq.a(this.input.getEditableText(), localArrayList);
    boolean bool = isReplyTextMode();
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.panelManager.a(4);
    if ((this.receiptMode) || (bool)) {
      if (bool) {
        azyi.a().a(this.app, this.sessionInfo, str, localArrayList, paramacwc, paramMessageRecord, null, null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
      }
      return str;
      sendMessageInner(str, paramacwc, localArrayList);
      continue;
      if ((!paramafqj.b()) && (paramMixedMsgInfo != null) && (paramMixedMsgInfo.a()))
      {
        ((avsf)this.app.getManager(174)).a(this.app, this, localArrayList, paramMixedMsgInfo);
        paramafqj.c();
      }
      else if ((this.sessionInfo.curType == 0) && (localPhotoListPanel != null) && (localPhotoListPanel.a(str)))
      {
        if (!localPhotoListPanel.a(true, this)) {
          sendMessageInner(str, paramacwc, localArrayList);
        }
        ((afrt)this.helperProvider.a(7)).b(hashCode());
      }
      else
      {
        sendMessageInner(str, paramacwc, null);
        if ((paramInt1 + paramInt2 > 0) && (localPhotoListPanel != null))
        {
          localPhotoListPanel.a(false, null);
          ((afrt)this.helperProvider.a(7)).b(hashCode());
        }
      }
    }
  }
  
  @NotNull
  private String clickSendTextButtonForTroop(afqj paramafqj, int paramInt1, int paramInt2, MixedMsgInfo paramMixedMsgInfo, MessageRecord paramMessageRecord, acwc paramacwc)
  {
    if (paramacwc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
    {
      paramacwc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
      if (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg))) {
        paramacwc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.oriMsgType = 1;
      }
      if (paramMessageRecord != null) {
        paramacwc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.packSourceMsg(this.app, paramMessageRecord);
      }
    }
    Object localObject1 = new ArrayList();
    String str1 = bevq.a(this.input.getEditableText(), (ArrayList)localObject1);
    createAtMsg(true);
    Object localObject2 = new ArrayList();
    String str2 = bevq.a(this.input.getEditableText(), (ArrayList)localObject2);
    boolean bool = isReplyTextMode();
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.panelManager.a(4);
    if ((this.receiptMode) || (bool)) {
      if (bool) {
        azyi.a().a(this.app, this.sessionInfo, str1, (ArrayList)localObject1, paramacwc, paramMessageRecord, str2, (ArrayList)localObject2);
      }
    }
    do
    {
      return str1;
      sendMessageInner(str1, paramacwc, (ArrayList)localObject1);
      return str1;
      if ((!paramafqj.b()) && (paramMixedMsgInfo != null) && (paramMixedMsgInfo.a()))
      {
        ((avsf)this.app.getManager(174)).a(this.app, this, (ArrayList)localObject1, paramMixedMsgInfo);
        paramafqj.c();
        return str1;
      }
      if ((localPhotoListPanel != null) && (localPhotoListPanel.a(str1)))
      {
        if (!localPhotoListPanel.a(true, this)) {
          sendMessageInner(str1, paramacwc, (ArrayList)localObject1);
        }
        ((afrt)this.helperProvider.a(7)).b(hashCode());
        return str1;
      }
      if (this.input.getTag(2131373800) == null) {
        break;
      }
    } while (this.input.getTag(2131373800) == null);
    paramMessageRecord = (MessageForTroopGift)this.input.getTag(2131373800);
    paramacwc.e = paramMessageRecord.senderUin;
    paramafqj = amtj.a(2131700131);
    paramMixedMsgInfo = bfyz.i(this.mContext, "wantWord");
    if (!android.text.TextUtils.isEmpty(paramMixedMsgInfo)) {
      paramafqj = paramMixedMsgInfo;
    }
    for (;;)
    {
      this.input.setText(paramafqj);
      paramafqj = ContactUtils.getMemberDisplaynameByIstroop(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin, paramMessageRecord.senderUin + "");
      paramMixedMsgInfo = this.app;
      localObject1 = this.mContext;
      str1 = this.sessionInfo.curFriendUin;
      paramMessageRecord = paramMessageRecord.senderUin + "";
      localObject2 = this.input;
      if (this.sessionInfo.curType == 1) {}
      for (bool = true;; bool = false)
      {
        paramafqj = bevq.a(paramMixedMsgInfo, (Context)localObject1, str1, paramMessageRecord, paramafqj, false, (EditText)localObject2, bool);
        if ((paramafqj != null) && (paramafqj.length() != 0)) {
          this.input.getEditableText().insert(0, paramafqj);
        }
        paramafqj = new ArrayList();
        paramMixedMsgInfo = bevq.a(this.input.getEditableText(), paramafqj);
        sendMessageInner(paramMixedMsgInfo, paramacwc, paramafqj);
        return paramMixedMsgInfo;
      }
      sendMessageInner(str1, paramacwc, (ArrayList)localObject1);
      if ((paramInt1 + paramInt2 <= 0) || (localPhotoListPanel == null)) {
        break;
      }
      localPhotoListPanel.a(false, null);
      ((afrt)this.helperProvider.a(7)).b(hashCode());
      return str1;
    }
  }
  
  private void destroyApollo()
  {
    if (this.mApolloViewObserver != null)
    {
      if (this.mApolloViewObserver.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
        this.mApolloViewObserver.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      }
      this.mApolloViewObserver.jdField_a_of_type_Boolean = false;
    }
    ((alnr)this.app.getManager(153)).a(null);
    if (this.mApolloViewController != null) {
      this.mApolloViewController.f(this);
    }
    alnr.jdField_a_of_type_JavaUtilHashSet.clear();
    ((alpg)this.app.getManager(232)).a();
  }
  
  private void destroyArk()
  {
    aowk.a().b(this);
    afvh.a(2);
    ArkFlashChatContainerWrapper.a(2);
    if (this.mArkController != null)
    {
      this.mArkController.b();
      this.mArkController = null;
    }
  }
  
  private void destroyDialog()
  {
    if (this.mProgressDialog != null)
    {
      this.mProgressDialog.dismiss();
      this.mProgressDialog = null;
    }
    if ((this.addFriendDialog != null) && (this.addFriendDialog.isShowing()))
    {
      this.addFriendDialog.dismiss();
      this.addFriendDialog = null;
    }
    if ((this.mAuthEmoticonDialog != null) && (this.mAuthEmoticonDialog.isShowing()))
    {
      this.mAuthEmoticonDialog.dismiss();
      this.mAuthEmoticonDialog = null;
    }
    if ((this.authDialog != null) && (this.authDialog.isShowing())) {
      this.authDialog.dismiss();
    }
  }
  
  private void destroyFile()
  {
    if (this.app.getFileManagerProxy() != null) {
      this.app.getFileManagerProxy().e();
    }
    if (!android.text.TextUtils.isEmpty(this.sessionInfo.curFriendUin))
    {
      abwz.b(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType, -3010);
      abwz.b(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType, -4020);
    }
    afaz localafaz = afaz.a(this.app);
    if (localafaz != null) {
      localafaz.b();
    }
  }
  
  private void destroyInput()
  {
    if (this.mInputGloblLayoutListener != null) {
      this.input.removeOnLayoutChangeListener(this.mInputGloblLayoutListener);
    }
    if (this.mActivity != null)
    {
      localObject = this.mActivity.getCurrentFocus();
      if (localObject != null)
      {
        QLog.i(this.tag, 1, localObject.toString());
        ((View)localObject).clearFocus();
      }
    }
    Object localObject = (InputMethodManager)this.mContext.getSystemService("input_method");
    hideFullScreenInput(true);
    if ((this.root != null) && (localObject != null)) {}
    try
    {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.root.getWindowToken(), 0);
      if (this.input != null)
      {
        this.input.removeTextChangedListener(this);
        if (this.input.getInputExtras(false) != null) {
          this.input.getInputExtras(false).clear();
        }
        this.input.setCompoundDrawables(null, null, null, null);
        this.input.setTag(2131373788, null);
      }
    }
    catch (RuntimeException localThrowable)
    {
      try
      {
        this.input.setSelection(0);
        this.input.a = null;
        this.input.setOnPrivateIMECommandListener(null);
        this.input.setOnEditorActionListener(null);
        this.input.setOnKeyListener(null);
        this.input.setOnTouchListener(null);
        this.input.setOnFocusChangeListener(null);
        this.input.setOnClickListener(null);
        if (this.sessionInfo.debugFilterMemberMsgCommand) {
          this.input.setText("");
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          for (;;)
          {
            if (AIOUtils.needForceRelease())
            {
              localObject = this.input.getViewTreeObserver();
              Field localField = ViewTreeObserver.class.getDeclaredField("mOnTouchModeChangeListeners");
              localField.setAccessible(true);
              localField.set(localObject, new CopyOnWriteArrayList());
              QLog.d(this.tag, 1, "force clear mOnTouchModeChangeListeners success.");
            }
            if (this.imeListener != null) {
              this.imeListener.a();
            }
            if (this.mInputBar != null) {
              this.mInputBar.removeOnLayoutChangeListener(this.mInputBarOnLayoutChangeListener);
            }
            return;
            localRuntimeException = localRuntimeException;
            QLog.e(this.tag, 1, localRuntimeException, new Object[0]);
          }
          localThrowable = localThrowable;
          QLog.e(this.tag, 1, "doOnDestroy: ", localThrowable);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d(this.tag, 1, "force clear mOnTouchModeChangeListeners", localException);
          }
        }
      }
    }
  }
  
  private void destroyListView()
  {
    if (this.listView != null)
    {
      this.businessFooterDetector.b();
      this.listView.setRecyclerListener(null);
      this.listView.setChatPie(null);
      this.listView.setOverScrollListener(null);
      this.listView.setShowPanelListener(null);
      this.listView.setAdapter(null);
      this.listView.setOnScrollListener(null);
      this.listView.setOnScrollToButtomListener(null);
      this.listView.setOnMeasureListener(null);
    }
    if (this.listAdapter != null) {
      this.listAdapter.c();
    }
  }
  
  private void destroyPtt()
  {
    if (this.mpm != null)
    {
      this.mpm.a(this.listView);
      this.mpm.a(true);
    }
    if ((this.mRecordToastDialog != null) && (this.mRecordToastDialog.isShowing()) && (this.mRecordToastDialog.getWindow() != null))
    {
      this.mRecordToastDialog.dismiss();
      this.mRecordToastDialog = null;
    }
    if ((this.mPttPlayVolumeDialog != null) && (this.mPttPlayVolumeDialog.isShowing()) && (this.mPttPlayVolumeDialog.getWindow() != null))
    {
      this.mPttPlayVolumeDialog.dismiss();
      this.mPttPlayVolumeDialog = null;
    }
    if (this.speakerPhoneLayout != null)
    {
      this.speakerPhoneLayout.setVisibility(4);
      this.speakerPhoneLayout = null;
    }
    if (this.mpm != null) {
      this.mpm.f();
    }
    if (this.recorder != null) {
      this.recorder.a();
    }
  }
  
  private void destroyReceipt()
  {
    if (this.receiptMode)
    {
      this.receiptMode = false;
      changeCoverVisibility(8);
    }
    azuu.a().a();
    if (this.titleCover != null)
    {
      this.afRoot.removeViewInLayout(this.titleCover);
      this.mContent.removeViewInLayout(this.receiptCover);
      this.mContent.removeViewInLayout(this.tvReceiptTips);
      this.titleCover = null;
      this.receiptCover = null;
      this.tvReceiptTips = null;
      ((RelativeLayout.LayoutParams)this.listView.getLayoutParams()).addRule(2, 2131368751);
    }
  }
  
  private void destroyScrollerRunnable()
  {
    if (this.mScrollerRunnable != null) {
      this.mScrollerRunnable.b();
    }
    if (this.mScrollerdownRunnable != null) {
      this.mScrollerdownRunnable.b();
    }
  }
  
  private void destroyUnRegReceivers()
  {
    BaseChatPie.22 local22 = new BaseChatPie.22(this);
    if (AppSetting.e)
    {
      ThreadManager.executeOnSubThread(local22, true);
      return;
    }
    local22.run();
  }
  
  private void determineBatchUpdateJumpBottom(Object paramObject, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.frienduin.equals(this.sessionInfo.curFriendUin)) && (apse.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.sessionInfo.curType, this.sessionInfo.topicId)))
    {
      if ((!(paramObject instanceof MessageForArkApp)) || (((MessageForArkApp)paramObject).getProcessState() != 1002)) {
        break label172;
      }
      ((ChatMessage)paramObject).mMsgAnimFlag = false;
      if (paramMessageRecord.msgtype == -2058) {
        break label183;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "update need instantUpdate, msg= " + paramMessageRecord.toString());
      }
      instantUpdate(true, true);
    }
    for (;;)
    {
      ((aeyb)this.app.getManager(218)).a(this, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForText)) {
        ((bcws)this.app.getManager(272)).a((ChatMessage)paramObject);
      }
      return;
      label172:
      ((ChatMessage)paramObject).mMsgAnimFlag = true;
      break;
      label183:
      instantUpdate(false, false);
    }
  }
  
  private boolean dispatchFinishToPanel(int paramInt, boolean paramBoolean)
  {
    if (this.root.a() != 0)
    {
      if ((this.root.a() == 2) && (paramInt == 0) && (this.mAudioPanel != null) && (this.mAudioPanel.a())) {}
      for (int i = 1;; i = 0)
      {
        if ((this.root.a() == 36) && (paramInt == 0) && (this.mVoiceTextEditPanel != null)) {
          this.mVoiceTextEditPanel.d();
        }
        if (i == 0)
        {
          if (paramInt == 1) {
            this.root.a(false);
          }
        }
        else {
          return true;
        }
        this.root.a(true);
        return true;
      }
    }
    return paramBoolean;
  }
  
  private boolean doChooseC2CInputType(amsw paramamsw)
  {
    ExtensionInfo localExtensionInfo2 = paramamsw.a(this.sessionInfo.curFriendUin, false);
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null) {
      if (paramamsw.d()) {}
    }
    label26:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "chooseC2CChatInputType get ExtensionInfo = null");
      }
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = this.sessionInfo.curFriendUin;
      localExtensionInfo1.timestamp = System.currentTimeMillis();
      if (abwz.d(this.sessionInfo.curType)) {}
      for (localExtensionInfo1.chatInputType = 0;; localExtensionInfo1.chatInputType = 1)
      {
        this.mExtensionInfo = localExtensionInfo1;
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "doChooseC2CInputType extInfo.chatInputType = " + localExtensionInfo1.chatInputType);
        }
        if (aews.b) {
          break;
        }
        switch (localExtensionInfo1.chatInputType)
        {
        case 1: 
        default: 
          return false;
        case 0: 
          localExtensionInfo1.chatInputType = 1;
          if (!QLog.isColorLevel()) {
            break label26;
          }
          QLog.d(this.tag, 2, "doChooseC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser");
          return false;
        }
      }
    } while ((this.mActivity == null) || (this.mActivity.getIntent().getIntExtra("enter_ext_panel", 0) != 0));
    this.mEnterExtPanel = 2;
    return false;
  }
  
  private boolean doChooseNoC2CInputType(amsw paramamsw)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramamsw.a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null) {
      if (paramamsw.d()) {}
    }
    label36:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "chooseC2CChatInputType get NoC2CExtensionInfo = null");
      }
      localNoC2CExtensionInfo1 = new NoC2CExtensionInfo();
      localNoC2CExtensionInfo1.type = this.sessionInfo.curType;
      localNoC2CExtensionInfo1.uin = this.sessionInfo.curFriendUin;
      localNoC2CExtensionInfo1.chatInputType = 0;
      this.mNoC2CExtensionInfo = localNoC2CExtensionInfo1;
      if (this.sessionInfo.curType == 1) {}
      for (int i = 1;; i = 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "doChooseNoC2CInputType noC2CExtInfo.chatInputType = " + localNoC2CExtensionInfo1.chatInputType + " noC2CType = " + i);
        }
        switch (localNoC2CExtensionInfo1.chatInputType)
        {
        case 1: 
        default: 
          return false;
        case 0: 
          localNoC2CExtensionInfo1.chatInputType = 1;
          if (!QLog.isColorLevel()) {
            break label36;
          }
          QLog.d(this.tag, 2, "doChooseNoC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser ");
          return false;
        }
      }
    } while ((this.mActivity == null) || (this.mActivity.getIntent().getIntExtra("enter_ext_panel", 0) != 0));
    this.mEnterExtPanel = 2;
    return false;
  }
  
  private void doLeftBackEvent(boolean paramBoolean)
  {
    if (this.mActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "mActivity == null");
      }
    }
    while (((afqy)getHelper(39)).a()) {
      return;
    }
    if ((this.mActivity instanceof SplashActivity))
    {
      finish(1);
      return;
    }
    this.mActivity.finish();
  }
  
  private void doOnActivityResultCameraType(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceGuide", 2, "onActivityResult = =" + paramInt1 + "resultCode" + paramInt2);
    }
    this.chatPieHelper.jdField_a_of_type_Boolean = false;
    this.chatPieHelper.b = false;
    this.panelicons.setEnable(5, true);
    this.panelicons.setEnable(6, true);
    if (1000 == paramInt2)
    {
      paramInt1 = paramIntent.getIntExtra("click_item", 1);
      if ((paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 14)) {
        this.root.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("XPanel", 2, "onActivityResult = setPanel=" + paramInt1);
      }
      onPanelIconClick(Integer.valueOf(paramInt1));
    }
    while (1001 != paramInt2) {
      return;
    }
    this.root.a();
  }
  
  private void doOnActivityResultDelegate(int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, int paramInt3)
  {
    if (paramInt1 == 2) {
      this.mActivity.setCanLock(false);
    }
    for (;;)
    {
      doOnActivityResultOther(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt1 == 4001)
      {
        EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.app.getCurrentAccountUin(), paramIntent);
      }
      else if ((paramInt1 == 103) && (!paramBoolean))
      {
        instantUpdate(false, true);
      }
      else if ((paramInt1 == 101) && (paramInt2 != -1))
      {
        instantUpdate(false, false);
      }
      else if ((paramInt1 == 4779) && (paramInt2 == 8213))
      {
        this.mEmoPanel.doAutoDownload(17);
      }
      else if ((paramInt1 == 4813) && (paramInt2 == 8213))
      {
        this.mEmoPanel.doAutoDownload(18);
      }
      else if (paramInt1 == 13007)
      {
        doOnActivityResultVideoType(paramIntent);
      }
      else if (paramInt1 == 11000)
      {
        doOnActivityResultCameraType(paramInt1, paramInt2, paramIntent);
      }
      else if (paramInt1 == 13002)
      {
        doOnActivityResultShortVideoType(paramIntent);
      }
      else if (paramInt1 == 13006)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "onActivityResult() REQUEST_OPEN_REACTIVE_SETTING");
        }
        refreshTitleReativeIcon();
      }
      else if (paramInt1 == 100012)
      {
        if ((paramIntent != null) && (paramIntent.getIntExtra("camera_type", -1) == 103)) {
          doShowPtv();
        }
      }
      else if (paramInt1 == 14001)
      {
        doOnActivityResultTextPreType(paramIntent);
      }
      else if (paramInt1 == 12007)
      {
        doOnActivityResultGiftType();
      }
      else if (paramInt1 == 12008)
      {
        doOnActivityResultMotionType(paramInt2, paramIntent);
      }
      else if (paramInt1 == 18000)
      {
        ((afri)getHelper(11)).a(paramInt2, paramIntent);
      }
      else if (paramInt2 == -1)
      {
        doOnActivityResultOk(paramInt1, paramInt2, paramIntent, paramInt3);
      }
      else
      {
        doOnActivityResultUnknown(paramInt1);
      }
    }
  }
  
  private void doOnActivityResultGiftType()
  {
    if (this.mAIOGiftPanelContainer != null)
    {
      TroopGiftPanel localTroopGiftPanel = this.mAIOGiftPanelContainer.a();
      if (localTroopGiftPanel != null) {
        localTroopGiftPanel.a(null);
      }
    }
  }
  
  private void doOnActivityResultMotionType(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt == -1))
    {
      TroopGiftPanel localTroopGiftPanel = this.mAIOGiftPanelContainer.a();
      if (localTroopGiftPanel != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null) {
          localTroopGiftPanel.a(paramIntent.getLong("duration_time"), paramIntent.getLong("elapsed_time"), paramIntent.getBoolean("profitable_flag", false));
        }
      }
    }
  }
  
  private void doOnActivityResultOk(int paramInt1, int paramInt2, Intent paramIntent, int paramInt3)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    case 4: 
    default: 
    case 18: 
    case 0: 
    case 1: 
    case 17000: 
    case 10: 
    case 3: 
    case 20: 
    case 21: 
    case 2000: 
    case 5: 
    case 100017: 
    case 11: 
    case 9009: 
    case 85: 
      do
      {
        return;
        doOnActivityResultOkLbs(paramIntent);
        return;
        instantUpdate(false, false);
        return;
        bbpn.a(this.app, this.mActivity, paramIntent, this.sessionInfo, paramInt3, paramInt1);
        return;
        ChatActivityUtils.a(this.app, this.mActivity, this.sessionInfo, paramInt1, paramIntent, 10);
        return;
        this.chatPieHelper.b(paramIntent);
        return;
        instantUpdate(true, false);
        this.mActivity.getWindow().clearFlags(1024);
        return;
        paramIntent.putExtra("selfSet_leftViewText", this.app.getApplication().getString(2131718771));
        startChatAndSendMsg(paramIntent.getExtras());
        return;
        doOnActivityResultOkOption(paramIntent);
        return;
        doOnActivityResultOkFile(paramInt2);
        return;
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("input_full_screen_mode_result");
        if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 2) {}
        for (;;)
        {
          ((afqj)this.helperProvider.a(24)).a(localArrayList, bool);
          return;
          bool = false;
        }
        doOnActivityResultOkShortVD(paramIntent);
        return;
        doOnActivityResultOkNearBy(paramIntent);
        return;
      } while (paramIntent == null);
      acvv.a(this.app, this.mContext, this.sessionInfo, paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"), false, true, paramIntent.getStringExtra(bkrk.d), null);
      return;
    case 9010: 
      bbwb.a(paramIntent, getActivity());
      return;
    case 9011: 
      setNeedLongScreenShot(paramIntent);
      return;
    case 102: 
      setLeftCheckBoxVisible(false, null, false);
      return;
    }
    QQToast.a(this.mContext, 2, 2131693185, 1).a();
  }
  
  private void doOnActivityResultOkFile(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    jumpToBottom();
  }
  
  private void doOnActivityResultOkLbs(Intent paramIntent)
  {
    if (this.mQQMapActivityProxy != null)
    {
      this.mQQMapActivityProxy.a();
      this.mQQMapActivityProxy = null;
    }
    if (paramIntent != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBS", 2, "onActivityResult ChatActivityConstants.LBS_REQUEST");
      }
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        String str4 = localBundle.getString("latitude");
        String str5 = localBundle.getString("longitude");
        String str6 = localBundle.getString("description");
        String str7 = localBundle.getString("title");
        String str8 = localBundle.getString("summary");
        String str9 = localBundle.getString("dianping_id");
        String str1 = localBundle.getString("poiId");
        String str2 = localBundle.getString("latSpan");
        String str3 = localBundle.getString("lngSpan");
        if ((str1 != null) && (str2 != null))
        {
          paramIntent = str3;
          if (str3 != null) {}
        }
        else
        {
          str1 = "";
          str2 = "";
          paramIntent = "";
        }
        acvv.a(this.mContext, this.app, this.sessionInfo, str4, str5, str6, str7, str8, str9, str1, str2, paramIntent, localBundle);
      }
    }
  }
  
  private void doOnActivityResultOkNearBy(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nearby_profile_nickname");
      if ((paramIntent != null) && (!paramIntent.equals(this.sessionInfo.curFriendNick)))
      {
        this.sessionInfo.curFriendNick = paramIntent;
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "onActivityResult new nick is " + paramIntent);
        }
        this.uiHandler.post(new BaseChatPie.32(this));
      }
    }
  }
  
  private void doOnActivityResultOkOption(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onActivityResult() ENTER_CHATOPTION_REQUEST");
    }
    refreshTitleReativeIcon();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {}
    for (boolean bool = paramIntent.getExtras().getBoolean("isNeedFinish");; bool = false)
    {
      if (bool) {
        finish(1);
      }
      for (;;)
      {
        ((afqy)getHelper(39)).a(this.mActivity.getIntent());
        return;
        instantUpdate(false, false);
      }
    }
  }
  
  private void doOnActivityResultOkShortVD(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("input_full_screen_mode", false))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramIntent = paramIntent.getStringExtra("input_full_screen_mode_result");
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "onActivityResult fullInputMode " + paramIntent);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramIntent);
        ((afqj)this.helperProvider.a(24)).a(localArrayList, false);
      }
      return;
    }
  }
  
  private void doOnActivityResultOther(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false)) || (paramIntent.getBooleanExtra("destroy_last_activity", false)))) || (paramInt2 == 4))
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Bundle localBundle = paramIntent.getExtras();
        Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.mContext, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(localBundle));
        this.mActivity.startActivity(localIntent);
      }
      this.mActivity.setResult(4, paramIntent);
    }
    if ((paramInt1 == 21) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      setLeftCheckBoxVisible(false, null, false);
    }
    this.helperProvider.a(paramInt1, paramInt2, paramIntent);
    if ((this.mChatDrawer != null) && (this.mChatDrawer.a())) {
      this.mChatDrawer.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  private void doOnActivityResultShortVideoType(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onActivityResulte() REQUEST_OPEN_SHORT_VIDEO_PLAYER...");
    }
    instantUpdate(false, false);
    try
    {
      paramIntent = paramIntent.getStringExtra("babyq_video_type");
      if (!android.text.TextUtils.isEmpty(paramIntent))
      {
        int i = Integer.parseInt(paramIntent);
        paramIntent = (amoa)this.app.getBusinessHandler(53);
        if (paramIntent != null) {
          paramIntent.a(i);
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d(this.tag, 1, "doOnActivityResult exception!", paramIntent);
    }
  }
  
  private void doOnActivityResultTextPreType(Intent paramIntent)
  {
    int i = ChatTextSizeSettingActivity.a(this.mContext);
    if (this.sessionInfo.textSizeForTextItem != i)
    {
      this.sessionInfo.textSizeForTextItem = i;
      this.input.setTextSize(0, this.sessionInfo.textSizeForTextItem);
    }
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("uin_type", 0);
      String str = paramIntent.getStringExtra("peeruin");
      long l = paramIntent.getLongExtra("uniseq", 0L);
      replyMessageAtInput((ChatMessage)this.app.getMessageFacade().getMsgItemByUniseq(str, i, l));
    }
  }
  
  private void doOnActivityResultUnknown(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ((afqy)getHelper(39)).a(this.mActivity.getIntent());
  }
  
  private void doOnActivityResultVideoType(Intent paramIntent)
  {
    try
    {
      int i = Integer.parseInt(paramIntent.getStringExtra("babyq_video_type"));
      paramIntent = (amoa)this.app.getBusinessHandler(53);
      if (paramIntent != null) {
        paramIntent.a(i);
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d(this.tag, 1, "doOnActivityResult exception!", paramIntent);
    }
  }
  
  private void doOnListViewMeasure(afsn paramafsn, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramafsn != null) && (!paramafsn.c()) && (paramafsn.b()) && (paramInt1 == 0)) {
      paramafsn.e();
    }
    this.listView.setOnMeasureListener(null);
    this.listView.setSelectionFromBottom(paramInt2, paramInt3);
  }
  
  private void doOnNewIntent_updateUI(Intent paramIntent)
  {
    this.listView.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "doOnNewIntent_updateUI: listView.setVisibility(View.INVISIBLE)");
    }
    if (BaseChatItemLayout.jdField_a_of_type_Boolean) {
      setLeftCheckBoxVisible(false, null, false);
    }
    Bundle localBundle = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.isBack2Root = true;
      this.mTitleBtnLeft.setText(2131718771);
      adjustTitleDimension();
      this.mTitleBtnLeft.setContentDescription(amtj.a(2131700128));
    }
    for (;;)
    {
      if (this.mCustomTitleView != null) {
        this.mCustomTitleView.e();
      }
      this.mEnterExtPanel = paramIntent.getIntExtra("enter_ext_panel", 0);
      this.mExtPanelOnResumeTimes = paramIntent.getIntExtra("ext_panel_onresume", 1);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "mEnterExtPanel = " + this.mEnterExtPanel + ", mExtPanelOnResumeTimes = " + this.mExtPanelOnResumeTimes);
      }
      if (this.mAnimContainer != null) {
        this.mAnimContainer.a();
      }
      afdp.a().a();
      hideZhituIcon();
      return;
      if (localBundle != null)
      {
        this.isBack2Root = localBundle.getBoolean("isBack2Root");
        if (this.isBack2Root)
        {
          this.mTitleBtnLeft.setText(2131718771);
          adjustTitleDimension();
          this.mTitleBtnLeft.setContentDescription(amtj.a(2131700109));
        }
      }
    }
  }
  
  private int getDisplayUnReadCntBubble(int paramInt)
  {
    int m = this.listAdapter.getCount();
    int i = this.listView.getHeaderViewsCount() + this.mReadedCnt - 1;
    int k;
    for (int j = 0; (i >= 0) && (i < m); j = k)
    {
      Object localObject = this.listAdapter.getItem(i);
      if (!afhw.a(localObject))
      {
        k = j;
        if (!afhw.b(localObject)) {}
      }
      else
      {
        k = j + 1;
      }
      i += 1;
    }
    QLog.i(this.tag, 1, "getDisplayUnReadCntBubble() called with: unReadCnt = [" + paramInt + "], filterCount = [" + j + "]");
    return Math.max(paramInt - j, 0);
  }
  
  private int getIndexOfMsg(List<ChatMessage> paramList, long paramLong)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((this.sessionInfo.curType == 3000) || (this.sessionInfo.curType == 1))
      {
        if (((ChatMessage)paramList.get(i)).shmsgseq != paramLong) {}
      }
      else {
        while (((ChatMessage)paramList.get(i)).time == paramLong) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  private MessageRecord getMessageRecordSource(List<ChatMessage> paramList)
  {
    if ((1000 == this.sessionInfo.curType) || (1004 == this.sessionInfo.curType) || (1022 == this.sessionInfo.curType)) {
      return ChatActivityUtils.b(paramList, this.sessionInfo, this.app);
    }
    return ChatActivityUtils.a(paramList, this.sessionInfo, this.app);
  }
  
  @Nullable
  private CharSequence getMessageSourceSequenceExt(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    Object localObject;
    if ((1000 != this.sessionInfo.curType) && (1004 != this.sessionInfo.curType))
    {
      localObject = paramCharSequence;
      if (this.sessionInfo.curType != 10008) {}
    }
    else
    {
      CharSequence localCharSequence = paramCharSequence;
      if (paramList.size() >= 15)
      {
        localCharSequence = paramCharSequence;
        if (!((ChatMessage)paramList.get(0)).mNeedGrayTips) {
          localCharSequence = null;
        }
      }
      localObject = localCharSequence;
      if (!paramList.isEmpty())
      {
        localObject = localCharSequence;
        if (((ChatMessage)paramList.get(0)).mMessageSource == null)
        {
          localObject = localCharSequence;
          if (((ChatMessage)paramList.get(0)).mNeedGrayTips)
          {
            localObject = localCharSequence;
            if (localCharSequence == null)
            {
              ((ChatMessage)paramList.get(0)).mNeedGrayTips = false;
              localObject = localCharSequence;
            }
          }
        }
      }
    }
    paramList = (List<ChatMessage>)localObject;
    if (1001 == this.sessionInfo.curType) {
      if (!awhm.jdField_a_of_type_JavaUtilHashSet.contains(this.sessionInfo.curFriendUin))
      {
        paramList = (List<ChatMessage>)localObject;
        if (!awhm.a(this.app, this.sessionInfo.curFriendUin)) {}
      }
      else
      {
        paramList = null;
      }
    }
    paramCharSequence = paramList;
    if (10002 == this.sessionInfo.curType)
    {
      paramCharSequence = paramList;
      if (awhm.a(this.app, this.sessionInfo.curFriendUin)) {
        paramCharSequence = null;
      }
    }
    if (abwz.a(this.sessionInfo.curType) == 1032) {
      paramCharSequence = null;
    }
    if (10010 == this.sessionInfo.curType) {
      paramCharSequence = null;
    }
    if (this.sessionInfo.curType == 10008) {
      return null;
    }
    return paramCharSequence;
  }
  
  private void getMsgSignalDpcStat()
  {
    boolean bool = true;
    if (this.app.getMsgCache().c() == 1) {}
    for (;;)
    {
      this.mIsMsgSignalOpen = bool;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "mIsMsgSignalOpen: " + this.mIsMsgSignalOpen);
      }
      return;
      bool = false;
    }
  }
  
  @Nullable
  private MessageRecord getSourceMsgForNonAnonymous(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord;
    int i;
    if (this.mSourceMsgInfo != null)
    {
      localObject = paramMessageRecord;
      if (android.text.TextUtils.isEmpty(this.mSourceMsgInfo.mAnonymousNickName))
      {
        localObject = paramMessageRecord;
        if (paramMessageRecord == null)
        {
          localObject = getAIOList();
          i = ((List)localObject).size() - 1;
          if (i < 0) {
            break label106;
          }
          paramMessageRecord = (ChatMessage)((List)localObject).get(i);
          if (paramMessageRecord.shmsgseq != this.mSourceMsgInfo.mSourceMsgSeq) {
            break label99;
          }
        }
      }
    }
    for (;;)
    {
      MessageForReplyText.reportReplyMsg(this.app, "suc_replyMsg", "reply_suc", this.sessionInfo.curFriendUin, paramMessageRecord);
      localObject = paramMessageRecord;
      return localObject;
      label99:
      i -= 1;
      break;
      label106:
      paramMessageRecord = null;
    }
  }
  
  private ahmo getStickerBubbleTouchDelegate(View paramView)
  {
    if (this.mStickerBubbleSendTouchDelegate == null)
    {
      ahmq localahmq = new ahmq(this.mContext, this);
      this.mStickerBubbleSendTouchDelegate = new ahmo(localahmq, paramView, agkg.b(this.app));
      localahmq.a(this.mStickerBubbleSendTouchDelegate);
    }
    return this.mStickerBubbleSendTouchDelegate;
  }
  
  private boolean handleApolloPanelMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 44: 
    case 76: 
    case 66: 
    case 73: 
    case 75: 
    case 72: 
    case 45: 
      do
      {
        do
        {
          Object localObject;
          do
          {
            int i;
            int j;
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
                      return false;
                    } while (this.mApolloPanel == null);
                    this.mApolloPanel.f();
                    return false;
                  } while (this.mApolloPanel == null);
                  this.mApolloPanel.p();
                  return false;
                } while (this.mApolloPanel == null);
                localObject = (amlu)paramMessage.obj;
                if (paramMessage.arg1 == 1)
                {
                  this.mApolloPanel.g();
                  return false;
                }
                this.mApolloPanel.a((amlu)localObject);
                return false;
              } while (this.mApolloPanel == null);
              this.mApolloPanel.o();
              return false;
              i = paramMessage.arg1;
              j = paramMessage.arg2;
            } while (this.mApolloPanel == null);
            this.mApolloPanel.a(i, j);
            return false;
            if (this.mApolloPanel != null) {
              this.mApolloPanel.o();
            }
          } while ((paramMessage.obj == null) || (android.text.TextUtils.isEmpty(paramMessage.obj.toString())));
          if (this.mApolloGameDialog == null)
          {
            localObject = new BaseChatPie.15(this);
            BaseChatPie.16 local16 = new BaseChatPie.16(this);
            this.mApolloGameDialog = bfur.a(this.mActivity, 0, amtj.a(2131700132), paramMessage.obj.toString(), amtj.a(2131700101), amtj.a(2131700138), (DialogInterface.OnClickListener)localObject, local16);
          }
          this.mApolloGameDialog.show();
          return false;
        } while (this.mApolloPanel == null);
        paramMessage = (HashMap)paramMessage.obj;
      } while (paramMessage == null);
      paramMessage.put("offset", "" + getTitleBarHeight());
      this.mApolloPanel.a(paramMessage);
      return false;
    }
    showAvatarPanel();
    return false;
  }
  
  private boolean handleBaseMsg(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 16711681: 
      paramMessage = (String)paramMessage.obj;
      if (this.sessionInfo.curFriendUin.equals(paramMessage)) {
        finish(1);
      }
      return true;
    case 14: 
      doPanelChanged(paramMessage.arg1, paramMessage.arg2);
      return true;
    case 23: 
      setInputStat(0);
      this.root.a(1);
      return true;
    case 16711696: 
      finish(1);
      return true;
    case 24: 
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        QQToast.a(this.app.getApp(), 2131697902, 0).b(this.mContext.getApplicationContext().getResources().getDimensionPixelSize(2131299076));
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("nickCount", paramMessage.arg1 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "multiMsgNickTimeOut", false, 30000L, 0L, localHashMap, "");
      return true;
    }
    this.root.a(1);
    return true;
  }
  
  private void handleDoutuMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      bcef.b(this.app, "dc00898", "", "", "0X8007FA8", "0X8007FA8", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "[Doutu] handleMessage : MSG_SHOW_DOUTU_EMOTION_LAYOUT");
      }
      if (this.doutuManager == null) {
        this.doutuManager = ((aqwg)this.app.getManager(214));
      }
      this.doutuManager.a(this.mContext, this.mContent, this.mActivity, this.sessionInfo, this.uiHandler, (aqwf)paramMessage.obj);
      if (this.emotionLayout != null)
      {
        this.emotionLayout.hide();
        this.uiHandler.removeMessages(67);
      }
      if (this.mApolloViewController != null) {
        this.mApolloViewController.a(false);
      }
      hideAppShortcutBar();
      return;
      if (this.doutuManager != null) {
        this.doutuManager.b();
      }
      if (this.mApolloViewController != null) {
        this.mApolloViewController.a(true);
      }
      resumeAppShorcutBar();
      return;
    } while ((this.doutuManager == null) || (this.doutuManager.jdField_a_of_type_Aqwb == null));
    this.doutuManager.jdField_a_of_type_Aqwb.notifyDataSetChanged();
  }
  
  private void handleEmoticonMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
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
                showEmoticonPanel((String)paramMessage.obj);
                return;
              } while (this.mEmoPanel == null);
              this.mEmoPanel.updateFavEmoticonPanel();
              return;
            } while (this.mEmoPanel == null);
            this.mEmoPanel.updateLastEmoticonPanel();
            return;
          } while (this.mEmoPanel == null);
          this.mEmoPanel.updateSystemAndEmojiPanel();
          return;
        } while (this.mEmoPanel == null);
        this.mEmoPanel.updateMagicPanel();
        return;
        handleHiddenEmoticonKeyword();
        return;
      } while ((this.emotionLayout == null) || (this.emotionLayout.getVisibility() != 0));
      this.emotionLayout.hide();
      this.uiHandler.removeMessages(67);
      if (this.mApolloViewController != null) {
        this.mApolloViewController.a(true);
      }
      resumeAppShorcutBar();
      return;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof String)) {
          localObject1 = (String)paramMessage.obj;
        }
      }
      if (this.emotionLayout != null) {
        this.emotionLayout.show((String)localObject1);
      }
      if (this.mApolloViewController != null) {
        this.mApolloViewController.a(false);
      }
      if (this.doutuManager != null) {
        this.doutuManager.b();
      }
      hideAppShortcutBar();
      EmojiStickerManager.a().c(this);
      this.uiHandler.removeMessages(67);
      this.uiHandler.sendEmptyMessageDelayed(67, 6000L);
      ((afsu)getHelper(14)).a();
      return;
      disableZhitu();
    } while ((this.input == null) || (paramMessage.arg1 != 1));
    this.input.setText("");
  }
  
  private void handleEmotionKeywords(Editable paramEditable)
  {
    if ((paramEditable != null) && (this.emotionLayout != null) && (this.emotionKeywordList != null) && (this.emoticonManager != null) && (this.sessionInfo.curType != 1008) && (this.sessionInfo.curType != 10007))
    {
      paramEditable = paramEditable.toString();
      String str = paramEditable.toLowerCase();
      if (this.emoticonManager.a(str)) {
        ThreadManager.post(new BaseChatPie.62(this, str, paramEditable), 5, null, true);
      }
      return;
    }
    QLog.e(this.tag, 1, "emotionkeyword error");
  }
  
  private void handleInputAreaClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onClick case R.id.input");
      }
      this.root.e();
      return;
      this.root.a(1);
      return;
    } while (!afqx.a(getApp(), this.mContext, this.input.getText().toString(), getCurType()));
    if (!ahtj.a(this.app).a(this.input.getText()))
    {
      QQToast.a(this.mContext, amtj.a(2131700130), 0).a();
      bcef.b(getApp(), "dc00898", "", "", "0X800932D", "0X800932D", 0, 0, "", "", "", "");
      return;
    }
    if (com.tencent.mobileqq.text.TextUtils.isContainComplexScript(this.input.getText().toString()))
    {
      QQToast.a(this.mContext, amtj.a(2131700102), 0).a();
      return;
    }
    boolean bool;
    if (!this.mZhituSwitch)
    {
      bool = true;
      this.mZhituSwitch = bool;
      this.mIconButtonInInputRight.setImageResource(2130838103);
      this.mIconButtonInInputRight.setActivated(this.mZhituSwitch);
      if (!this.mZhituSwitch) {
        break label346;
      }
      if (this.emotionLayout != null) {
        this.emotionLayout.hide();
      }
      if (this.doutuManager != null) {
        this.doutuManager.b();
      }
      if (amat.a(this.app)) {
        break label341;
      }
    }
    label341:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        amat.a(this.app, "zhitu", true);
      }
      auen.c.set(false);
      this.root.a(28, false);
      return;
      bool = false;
      break;
    }
    label346:
    this.root.a();
  }
  
  private void handleInputRightButtonTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 2: 
    case 0: 
      do
      {
        do
        {
          return;
        } while (!this.mStickerBubbleQuickButtonHandlingTouchDown);
        getStickerBubbleTouchDelegate(paramView).a(paramMotionEvent);
        return;
        QLog.d(this.tag, 1, "hiboom icon touch down");
      } while (!this.input.getText().toString().isEmpty());
      getStickerBubbleTouchDelegate(paramView).a(paramMotionEvent);
      this.mStickerBubbleQuickButtonHandlingTouchDown = true;
      return;
    }
    QLog.d(this.tag, 1, "hiboom icon touch up");
    if ((this.input.getText().toString().isEmpty()) || (this.mStickerBubbleQuickButtonHandlingTouchDown))
    {
      getStickerBubbleTouchDelegate(paramView).a(paramMotionEvent);
      this.mStickerBubbleQuickButtonHandlingTouchDown = false;
      return;
    }
    onClick(this.mIconButtonInInputRight);
  }
  
  private void handleMarketFaceMsgRefresh(List<ChatMessage> paramList)
  {
    if ((this.hasUnread) && (paramList.size() > 0))
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(paramList.size() - 1);
      localChatMessage.mPendantAnimatable = true;
      if (((localChatMessage instanceof MessageForMarketFace)) && (!isFullScreenMode()))
      {
        MarkFaceMessage localMarkFaceMessage = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
        paramList = localMarkFaceMessage;
        if (localMarkFaceMessage == null)
        {
          localChatMessage.parse();
          paramList = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
        }
        if (((paramList.mobileparam != null) && (paramList.mobileparam.length > 0)) || ((paramList.mediaType == 3) && (abwz.d(this.sessionInfo.curType)))) {
          ((MessageForMarketFace)localChatMessage).needToPlay = true;
        }
      }
    }
  }
  
  private boolean handleMsgMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 16711689: 
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "read confirm send readconfirm");
      }
      this.uiHandler.sendEmptyMessageDelayed(16711689, 300000L);
      ThreadManager.post(new BaseChatPie.17(this), 8, null, false);
      return true;
    case 12: 
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "handleMessage MSG_REFRESH_LIST");
      }
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof amwf)))
      {
        paramMessage = (amwf)paramMessage.obj;
        paramMessage.e = (System.currentTimeMillis() - paramMessage.d);
        MessageHandler.a(paramMessage, this.app);
      }
      refreshListAdapter();
      if (this.mScrollState == 0)
      {
        apec.a().a(getApp(), 1500);
        almr.a().a(getApp(), 1500);
      }
      return true;
    case 78: 
      long l = paramMessage.getData().getLong("messageUniseq");
      int i = paramMessage.arg1;
      ChatMessage localChatMessage = (ChatMessage)this.app.getMessageProxy(this.sessionInfo.curType).a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, l);
      if ((localChatMessage != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof amwf)))
      {
        paramMessage = (amwf)paramMessage.obj;
        paramMessage.e = (System.currentTimeMillis() - paramMessage.d);
        MessageHandler.a(paramMessage, this.app);
        localChatMessage.setIsSentByXG(paramMessage.b);
      }
      refreshListItem(localChatMessage, i);
      return true;
    case 13: 
      updateListUnRead(paramMessage.arg1);
      return true;
    case 18: 
      instantUpdate(false, false);
      return true;
    case 267387139: 
      if (this.mProgressDialog != null)
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog.c(false);
      }
      this.app.getMsgCache().b(false);
      return true;
    }
    if (this.mProgressDialog != null)
    {
      this.mProgressDialog.dismiss();
      this.mProgressDialog.c(false);
    }
    this.app.getMsgCache().b(false);
    QQToast.a(this.mContext, 2131693968, 0).b(getTitleBarHeight());
    if (paramMessage.arg1 == 1) {
      anmr.b(this.sessionInfo.curFriendUin, this.sessionInfo.curType, anmr.b, anmr.l);
    }
    return true;
  }
  
  private void handlePttMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 40: 
    case 16711685: 
    case 16711687: 
    case 16711686: 
      do
      {
        return;
        setLastAudioPanelType(paramMessage.arg1);
        return;
        refreshMusicItem();
        return;
        stopAudioRecord(2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
        }
        this.recorder.c();
        cancelRemainScreenOn();
      } while (this.recordingUniseq != 0L);
      playPersonalSound(2131230744);
      return;
    }
    checkOrUpdatePttRecord(0, null, -1L);
  }
  
  private void handleReadConfirmMessage()
  {
    if (this.isHaveNewAfterIn)
    {
      this.uiHandler.removeMessages(16711689);
      this.uiHandler.sendEmptyMessage(16711689);
    }
  }
  
  private void handleRefreshPokeStatus(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = (ChatMessage)paramList.get(paramList.size() - 1);
      if ((!paramList.isSend()) && (this.sessionInfo.curType == 0) && (!isFullScreenMode()))
      {
        if (!(paramList instanceof MessageForPoke)) {
          break label151;
        }
        if (!((MessageForPoke)paramList).isPlayed)
        {
          MessageForPoke localMessageForPoke = (MessageForPoke)paramList;
          agkc.a().a(this.app, this.sessionInfo.curFriendUin, localMessageForPoke.interactType, 0, localMessageForPoke.strength);
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "receive PokeMsg strength:" + localMessageForPoke.strength + "." + paramList);
          }
        }
      }
    }
    label151:
    do
    {
      return;
      agkc.a().a(this.app, this.sessionInfo.curFriendUin, -1, 0, -1);
    } while (!QLog.isColorLevel());
    QLog.d("PokeMsg", 2, "receive unPokeMsg strength:-1." + paramList);
  }
  
  private void handleRefreshSingleTitle(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    Object localObject;
    String str;
    StringBuilder localStringBuilder;
    boolean bool;
    if (this.mSingleTitle)
    {
      if ((1000 != this.sessionInfo.curType) || (paramMessageRecord != null) || (paramList.size() != 0)) {
        break label215;
      }
      localObject = ChatActivityUtils.a(this.mContext, this.app, this.sessionInfo.realTroopUin);
      if (QLog.isColorLevel())
      {
        str = this.tag;
        localStringBuilder = new StringBuilder().append("sessionInfo.curType = ").append(this.sessionInfo.curType).append(", mr = null ? ");
        if (paramMessageRecord != null) {
          break label401;
        }
        bool = true;
        label103:
        localStringBuilder = localStringBuilder.append(bool).append("，mr.type = ");
        if (paramMessageRecord != null) {
          break label407;
        }
      }
    }
    label401:
    label407:
    for (paramMessageRecord = "null";; paramMessageRecord = Integer.valueOf(paramMessageRecord.istroop))
    {
      QLog.d(str, 2, paramMessageRecord + ", newList.size() = " + paramList.size());
      if (localObject == null) {
        break label418;
      }
      setSubTitleVisable(true);
      this.mSubTilteText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.mTitleLayout.setOnClickListener(null);
      this.mSubTitleLayout.setOnClickListener(null);
      setSubTitleText((String)localObject);
      if (jdField_a_of_type_Boolean) {
        this.mSubTilteText.setContentDescription((CharSequence)localObject);
      }
      return;
      label215:
      if ((this.sessionInfo.curType == 0) || (this.sessionInfo.curType == 1025))
      {
        localObject = ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo.curFriendUin);
        break;
      }
      if ((this.sessionInfo.curType == 1001) || (this.sessionInfo.curType == 10002))
      {
        localObject = this.mContext;
        if (this.sessionInfo.curType == 1001) {}
        for (int i = 2131697985;; i = 2131693947)
        {
          localObject = ((Context)localObject).getString(i);
          break;
        }
      }
      if (this.sessionInfo.curType == 10004)
      {
        localObject = this.mContext.getString(2131697986);
        break;
      }
      if (this.sessionInfo.curType == 10010)
      {
        localObject = this.mContext.getString(2131693946);
        break;
      }
      localObject = ChatActivityUtils.a(this.mContext, paramMessageRecord, this.app);
      break;
      bool = false;
      break label103;
    }
    label418:
    setSubTitleVisable(false);
  }
  
  private boolean handleTipsMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 25: 
      if ((this.mPttPlayVolumeDialog != null) && (this.mPttPlayVolumeDialog.isShowing()) && (this.mPttPlayVolumeDialog.getWindow() != null))
      {
        this.mPttPlayVolumeDialog.dismiss();
        this.mPttPlayVolumeDialog = null;
      }
      return true;
    case 38: 
      if (this.mlightalkTipsBar == null) {
        this.mlightalkTipsBar = new ahpx(this.app, this.mTipsMgr, this.sessionInfo, this.mActivity);
      }
      if (this.mTipsMgr.a(this.mlightalkTipsBar, new Object[0]))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "BaseChatPie:handleMessage() : TYPE_ON_SHOW =====>");
        }
        ThreadManager.getSubThreadHandler().post(new BaseChatPie.18(this));
        bcef.b(this.app, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "1", "", "", "");
      }
      return true;
    case 35: 
      if (this.mFunCallTipBar == null) {
        this.mFunCallTipBar = new ahrd(this.app, this.mTipsMgr, this.mContext, this.sessionInfo.curFriendUin, new BaseChatPie.19(this));
      }
      this.mFunCallTipBar.a(this.sessionInfo.curFriendUin);
      this.mTipsMgr.a(this.mFunCallTipBar, new Object[0]);
      return true;
    case 26: 
      acvv.c(this.app, this.sessionInfo, true);
      return true;
    case 58: 
      acvv.a(this, this.app, this.sessionInfo, true);
      return true;
    case 28: 
      this.mTipsMgr.a();
      return true;
    case 31: 
      boolean bool = SettingCloneUtil.readValue(this.app.getApp(), this.app.getAccount(), null, "pcactive_notice_key", false);
      if ((!SettingCloneUtil.readValue(this.app.getApp(), this.app.getAccount(), null, "pcactive_has_notice", false)) && (bool))
      {
        SettingCloneUtil.writeValue(this.app.getApp(), this.app.getAccount(), null, "pcactive_has_notice", true);
        paramMessage = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
        paramMessage.addFlags(268435456);
        paramMessage.putExtra("uin", this.app.getAccount());
        BaseApplicationImpl.getApplication().startActivity(paramMessage);
      }
      return true;
    }
    showManagerFavEmoticonTips();
    return true;
  }
  
  private void handleTitleBarClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369068: 
    case 2131369436: 
    case 2131369874: 
    case 2131379417: 
    case 2131369082: 
    case 2131377934: 
    case 2131378762: 
      do
      {
        return;
        if ((!this.isJubaoMode) && (BaseChatItemLayout.jdField_a_of_type_Boolean))
        {
          setLeftCheckBoxVisible(false, null, false);
          if (this.sessionInfo.curType == 1008)
          {
            paramView = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
            bcef.b(this.app, "dc00899", "Pb_account_lifeservice", this.sessionInfo.curFriendUin, "0X80064F8", "0X80064F8", 0, 0, paramView, "", "", "");
          }
        }
        for (;;)
        {
          try
          {
            paramView = this.mTitleBtnLeft.getTag();
            String[] arrayOfString = (String[])paramView;
            if ((paramView == null) || (!"comic".equals(arrayOfString[0]))) {
              break;
            }
            bkfq.a(this.app, "3006", "2", "40025", arrayOfString[1], new String[] { "1" });
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          leftBackEvent(false);
        }
        if (this.sessionInfo.curType == 0) {
          this.mEntryFriendCard = true;
        }
        if (this.mpm != null) {
          this.mpm.d();
        }
        openOptionActivity();
        if (QLog.isDevelopLevel()) {
          QLog.d("reportEvent", 4, " curType : " + this.sessionInfo.curType + ", mEntryFriendCard: " + this.mEntryFriendCard);
        }
        bcef.b(this.app, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, ChatActivityUtils.b(this.sessionInfo.curType), "", "", "");
        return;
      } while (this.isJubaoMode);
      onClickTitleLayout(paramView);
      return;
    }
    switchReceiptMode();
  }
  
  private boolean handleUpdateBubbleCache(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      long l = System.currentTimeMillis();
      if (l - this.vasLastRefreshReqTime < 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "MSG_BUBBLE_CACHE_UPDATE, frequency limit, abort");
        }
      }
      else
      {
        this.vasLastRefreshReqTime = l;
        if (this.mScrollState != 0)
        {
          this.mBubbleCacheMsgAborted = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "MSG_BUBBLE_CACHE_UPDATE, scrolling, abort");
          }
        }
        else
        {
          boolean bool = bgae.a(this.app, this.listView);
          if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "MSG_BUBBLE_CACHE_UPDATE, needRefresh=" + bool);
          }
          if (bool) {
            refresh(196608);
          }
        }
      }
    }
  }
  
  private boolean handleWeiyunMsg(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 100: 
      if (bleg.a(0)) {
        blfa.a(this.app, getActivity(), getTitleBarHeight());
      }
      return true;
    }
    int i = paramMessage.arg1;
    if (bleg.a(i))
    {
      if (!bleg.d(i)) {
        break label82;
      }
      bleg.a(this.app);
    }
    for (;;)
    {
      return true;
      label82:
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.app.getApp(), paramMessage, 1).b(getTitleBarHeight());
    }
  }
  
  private boolean ifListViewNeedToScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    afsn localafsn = (afsn)getHelper(52);
    return ((this.root.a() == 1) && (paramInt2 - paramInt1 != paramInt4 - paramInt3)) || ((localafsn != null) && (localafsn.a()));
  }
  
  private void initAudioPanelFlag(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if ((paramBoolean2) && (shouldShowAudioPanel()))
      {
        showAudioPanel(false);
        this.needShowAudioWhenResume = false;
      }
      if (DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_input.name())) {
        if (((this.mAudioPanel == null) || (this.needShowAudioWhenResume)) && (shouldShowAudioPanel()))
        {
          showAudioPanel(false);
          this.needShowAudioWhenResume = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "initAudioPanelFlag needShowAudioWhenResume  = " + this.needShowAudioWhenResume);
      }
      return;
      this.needShowAudioWhenResume = true;
      continue;
      if ((this.needShowAudioWhenResume) && (shouldShowAudioPanel()))
      {
        showAudioPanel(true);
        this.needShowAudioWhenResume = false;
      }
    }
  }
  
  private void initBottomBlurView()
  {
    boolean bool = false;
    if (enableBlur())
    {
      this.mBottomBlurView.setVisibility(0);
      this.mBottomBlurView.a(this.mAIORootView);
      this.mBottomBlurView.b(this.mBottomBlurView);
      this.mBottomBlurView.a(8);
      this.mBottomBlurView.c(-1);
      this.mBottomBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
      QQBlurView localQQBlurView = this.mBottomBlurView;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = true;
      }
      localQQBlurView.setEnableBlur(bool);
      this.mBottomBlurView.setDisableBlurDrawableRes(2130838139);
      this.mBottomBlurView.a(new BaseChatPie.7(this));
      this.mBottomBlurView.setDirtyListener(new BaseChatPie.8(this));
      this.mBottomBlurView.d();
      return;
    }
    this.mBottomBlurView.setVisibility(8);
  }
  
  private void initInput()
  {
    this.mInputBarOnLayoutChangeListener = new BaseChatPie.6(this);
    this.mInputBar.addOnLayoutChangeListener(this.mInputBarOnLayoutChangeListener);
    adjustInputInInputLayout();
  }
  
  private void initMsgSignalRunnable()
  {
    this.msgSignalRunnable = new BaseChatPie.63(this);
  }
  
  private boolean isApolloForward()
  {
    return (this.mActivity != null) && (this.mActivity.getIntent() != null) && (this.mActivity.getIntent().getExtras() != null) && (this.mActivity.getIntent().getExtras().containsKey("apollo_forward_key"));
  }
  
  private boolean isC2CSession()
  {
    boolean bool = false;
    int i = 0;
    for (;;)
    {
      if ((i >= abwz.q.length) || (this.sessionInfo.curType == abwz.q[i]))
      {
        if (i < abwz.q.length) {
          bool = true;
        }
        return bool;
      }
      i += 1;
    }
  }
  
  private boolean isEmoPgkForward()
  {
    return (this.mContext != null) && (this.mActivity != null) && (this.mActivity.getIntent() != null) && (this.mActivity.getIntent().getExtras() != null) && (this.mActivity.getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID"));
  }
  
  private boolean isOtherType(int paramInt)
  {
    return (paramInt == 23) || (paramInt == 14) || (paramInt == 6) || (paramInt == 21) || (paramInt == 4) || (paramInt == 3) || (paramInt == 26) || (paramInt == 18) || (paramInt == 19) || (paramInt == 5) || (paramInt == 20) || (paramInt == 13) || (paramInt == 101) || (paramInt == 102);
  }
  
  private int jumpBottom(int paramInt)
  {
    if (this.sessionInfo.curType == 1008)
    {
      this.listView.postDelayed(new BaseChatPie.40(this), 300L);
      return paramInt;
    }
    this.refreshBottomCount += 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "[refreshListAdapter]: refreshBottomCount=" + this.refreshBottomCount + ",refreshDelayForNextPie=" + refreshDelayForNextPie);
    }
    if (refreshDelayForNextPie)
    {
      if (!blockRefreshJumpBottom()) {
        this.listView.post(new BaseChatPie.41(this));
      }
      refreshDelayForNextPie = false;
      return paramInt;
    }
    if (this.refreshBottomCount == 1)
    {
      this.listView.setSelectionFromBottom(this.listView.getCount() - 1, 0);
      return paramInt;
    }
    this.listView.post(new BaseChatPie.42(this));
    return paramInt;
  }
  
  private void jumpToSpecifiedMsg()
  {
    long l;
    Object localObject;
    int i;
    if (this.needjumpToMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "do jumpToSpecifiedMsg");
      }
      l = System.currentTimeMillis();
      localObject = this.listAdapter.a();
      if (((List)localObject).size() > 0)
      {
        if ((this.mActivity.getIntent() == null) || (!this.mActivity.getIntent().getBooleanExtra("jump_from_shmsgseq", false))) {
          break label167;
        }
        int j = ((List)localObject).size();
        i = 0;
        if (i >= j) {
          break label312;
        }
        if (((ChatMessage)((List)localObject).get(i)).shmsgseq != this.timeOrSeq) {
          break label160;
        }
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.listView.post(new BaseChatPie.27(this, i));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l, 0L, null, null);
        this.needjumpToMsg = false;
        return;
        label160:
        i += 1;
        break;
        label167:
        i = getIndexOfMsg((List)localObject, this.timeOrSeq);
        continue;
      }
      List localList = this.app.getMessageFacade().getBaseMessageManager(this.sessionInfo.curType).a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.timeOrSeq);
      if (1000 == this.sessionInfo.curType) {}
      for (localObject = ChatActivityUtils.b(localList, this.sessionInfo, this.app);; localObject = ChatActivityUtils.a(localList, this.sessionInfo, this.app))
      {
        setList(localList, ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo, (MessageRecord)localObject, -1L));
        this.listView.post(new BaseChatPie.28(this));
        break;
      }
      label312:
      i = -1;
    }
  }
  
  private void jumpToSpecifiedMsgSimply()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "jumpToSpecifiedMsgSimply, refreshScrollMsg = " + this.refreshScrollMsg);
    }
    List localList = this.listAdapter.a();
    if ((localList.size() > 0) && (this.refreshScrollMsg >= 0L))
    {
      int i = getIndexOfMsg(localList, this.refreshScrollMsg);
      if (i >= 0)
      {
        this.listView.post(new BaseChatPie.31(this, i));
        this.refreshScrollMsg = -1L;
      }
    }
  }
  
  private int jumpTop(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    int i = paramInt3;
    if (paramInt4 > 0)
    {
      i = paramInt3;
      if (this.listView.getHeaderViewsCount() + paramInt2 >= 0)
      {
        paramInt4 = -1;
        paramInt3 = paramInt4;
        if (paramInt5 <= 0) {
          break label455;
        }
        if (paramInt2 < paramList1.size()) {
          break label469;
        }
        paramInt2 = paramList1.size() - 1;
      }
    }
    label177:
    label455:
    label469:
    for (;;)
    {
      if (paramInt2 < 0) {}
      for (i = paramInt2 + this.listView.getHeaderViewsCount();; i = paramInt2)
      {
        long l = ((ChatMessage)paramList1.get(i)).uniseq;
        paramInt3 = 0;
        paramInt2 = paramInt4;
        if (paramInt3 < paramInt5)
        {
          if (((ChatMessage)paramList2.get(paramInt3)).uniseq == l) {
            paramInt2 = paramInt3;
          }
        }
        else
        {
          paramInt3 = paramInt2;
          if (paramInt2 >= 0) {
            break label455;
          }
          paramInt3 = paramInt2;
          if (paramList1.size() <= i + 1) {
            break label455;
          }
          l = ((ChatMessage)paramList1.get(i + 1)).uniseq;
          paramInt4 = 0;
          paramInt3 = paramInt2;
          if (paramInt4 >= paramInt5) {
            break label455;
          }
          if (((ChatMessage)paramList2.get(paramInt4)).uniseq != l) {
            break label272;
          }
          paramBoolean = true;
        }
        for (;;)
        {
          if (paramInt4 >= 0)
          {
            paramInt3 = this.mReadedCnt + paramInt4;
            paramInt2 = paramInt3;
            if (paramBoolean) {
              paramInt2 = paramInt3 - 1;
            }
            if ((paramInt1 < 0) && (paramInt4 == 0))
            {
              this.listView.springBackOverScrollHeaderView();
              i = paramInt2;
              return i;
              paramInt3 += 1;
              break;
              paramInt4 += 1;
              break label177;
            }
            if (paramInt1 < 0)
            {
              paramInt3 = this.listView.getHeight();
              try
              {
                paramInt5 = this.listView.getChildAt(this.listView.getHeaderViewsCount()).getBottom();
                paramInt3 -= paramInt5;
              }
              catch (NullPointerException paramList1)
              {
                for (;;)
                {
                  paramInt3 = this.listView.getHeight();
                }
              }
              this.listView.hideOverScrollHeaderView();
              this.listView.setSelectionFromBottom(paramInt4 + this.listView.getHeaderViewsCount(), paramInt3 + paramInt1 - this.listView.getPaddingBottom());
              return paramInt2;
            }
            paramInt1 = this.listView.getHeight();
            try
            {
              paramInt3 = this.listView.getChildAt(this.listView.getHeaderViewsCount()).getBottom();
              paramInt1 -= paramInt3;
            }
            catch (NullPointerException paramList1)
            {
              for (;;)
              {
                paramInt1 = this.listView.getHeight();
              }
            }
            this.listView.setSelectionFromBottom(paramInt4 + this.listView.getHeaderViewsCount(), paramInt1 - this.listView.getPaddingBottom());
            return paramInt2;
          }
          this.listView.hideOverScrollHeaderView();
          return paramInt5;
          paramInt4 = paramInt3;
        }
      }
    }
  }
  
  private void msgReport(int paramInt1, int paramInt2)
  {
    msgReport(paramInt1, paramInt2, "");
  }
  
  private void msgReport(int paramInt1, int paramInt2, String paramString)
  {
    this.chatPieHelper.a(paramInt1, paramInt2, paramString);
  }
  
  private void onAddFriendInner(String paramString)
  {
    int k = 0;
    if (!this.sessionInfo.curFriendUin.equals(paramString)) {
      return;
    }
    paramString = abwz.q;
    int m = paramString.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        j = paramString[i];
        if (this.sessionInfo.curType == j) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.mActivity.runOnUiThread(new BaseChatPie.70(this));
        return;
      }
      i += 1;
    }
  }
  
  private void onFinish_setReaded()
  {
    if (this.app != null)
    {
      if (!this.hasSetReaded)
      {
        if (!StringUtil.isEmpty(this.sessionInfo.curFriendUin))
        {
          acvv.a(this.app, this.sessionInfo);
          setReaded();
          if (this.sessionInfo.curType == 1) {
            awhn.a(this.app, this.sessionInfo.curFriendUin);
          }
          QLog.d(this.tag, 1, "setReaded() call");
        }
        this.hasSetReaded = true;
      }
      if (this.listAdapter.getCount() > 0)
      {
        Object localObject = (ChatMessage)this.listAdapter.getItem(this.listAdapter.getCount() - 1);
        if ((localObject != null) && (((ChatMessage)localObject).msgtype == -2039))
        {
          localObject = (MessageForApollo)localObject;
          if ((!((MessageForApollo)localObject).hasPlayed) && (((MessageForApollo)localObject).isSend())) {
            ApolloUtil.a((MessageForApollo)localObject, this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType);
          }
        }
      }
    }
  }
  
  private void onGetFriendDateNickInner(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((!paramBoolean) || (this.sessionInfo == null) || (!bftf.a(paramString1, this.sessionInfo.curFriendUin))) {}
    do
    {
      return;
      switch (this.sessionInfo.curType)
      {
      default: 
        return;
      }
      this.sessionInfo.curFriendNick = paramString2;
      this.mTitleText.setText(this.sessionInfo.curFriendNick);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        paramString1 = this.mTitleText.getText().toString();
        this.mTitleText.setContentDescription(paramString1);
        getActivity().setTitle(this.mTitleText.getText());
      }
    } while (!QLog.isDevelopLevel());
    aquj.a(this.tag, new Object[] { "onGetFriendDateNick", paramString2 });
  }
  
  private void onGetFriendNickBatchInner(boolean paramBoolean, Object paramObject)
  {
    this.uiHandler.removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.mProgressDialog == null) || (!this.mProgressDialog.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", NetworkUtil.getSystemNetwork(BaseApplication.getContext()) + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label353;
        }
        i = 1;
        break;
        if (awcm.a().jdField_a_of_type_Int != 2) {
          this.mProgressDialog.dismiss();
        }
        awcm.a().b.clear();
        if ((paramBoolean) && (paramObject != null)) {
          awcm.a().b.putAll((Map)paramObject);
        }
        if (awcm.a().b.size() == 0) {
          QQToast.a(this.app.getApp(), 2131697901, 0).b(getTitleBarHeight());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
          return;
          if (paramObject != null) {
            if (awcm.a().jdField_a_of_type_Int == 6) {
              ((afri)this.helperProvider.a(11)).a((Map)paramObject, awcm.a().jdField_a_of_type_JavaUtilArrayList, awcm.a().jdField_a_of_type_Int);
            } else {
              ((afrl)this.helperProvider.a(1)).a((Map)paramObject, awcm.a().jdField_a_of_type_JavaUtilArrayList, awcm.a().jdField_a_of_type_Int);
            }
          }
        }
      }
      label353:
      i = 0;
    }
  }
  
  private void onGetSigZanInfoInner(Object paramObject)
  {
    if (this.mScrollState != 0) {}
    while ((agmx.jdField_a_of_type_Long == 0L) || (!(paramObject instanceof bamu))) {
      return;
    }
    ThreadManager.post(new BaseChatPie.68(this, (bamu)paramObject), 5, null, false);
  }
  
  private void onGetStrangerInfoInner(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null) || (this.listView == null) || (!(paramObject instanceof Set))) {
      return;
    }
    bgae.a(this.app);
    Set localSet = (Set)paramObject;
    int k = this.listView.getChildCount();
    int i = 0;
    label47:
    Object localObject1;
    ChatMessage localChatMessage;
    label102:
    int j;
    if (i < k)
    {
      paramObject = this.listView.getChildAt(i);
      if ((paramObject != null) && ((paramObject instanceof BaseChatItemLayout)))
      {
        localObject1 = (aezf)AIOUtils.getHolder(paramObject);
        localChatMessage = AIOUtils.getMessage(paramObject);
        if (!localChatMessage.isSend()) {
          break label247;
        }
        paramObject = localChatMessage.selfuin;
        Object localObject2 = (amsw)this.app.getManager(51);
        if ((localObject1 != null) && (((aezf)localObject1).a != null) && (paramObject != null) && (localSet.contains(paramObject)))
        {
          localObject2 = ((amsw)localObject2).a(paramObject);
          if (localObject2 != null)
          {
            Object localObject3 = Long.valueOf(((ExtensionInfo)localObject2).pendantId);
            if (localObject3 != null)
            {
              if (((Long)localObject3).longValue() == 0L) {
                break label304;
              }
              localObject3 = ((AvatarPendantManager)this.app.getManager(46)).a(((Long)localObject3).longValue());
              localObject1 = ((aezf)localObject1).a;
              if (i == k) {
                break label298;
              }
              j = 1;
              label220:
              ((PendantInfo)localObject3).a((View)localObject1, j, localChatMessage.uniseq, paramObject, ((ExtensionInfo)localObject2).pendantDiyId);
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label247:
      if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004))
      {
        paramObject = localChatMessage.frienduin;
        break label102;
      }
      paramObject = localChatMessage.senderuin;
      break label102;
      label298:
      j = 2;
      break label220;
      label304:
      if (((aezf)localObject1).a.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        ((aezf)localObject1).a.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        ((aezf)localObject1).a.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  private void onHandleCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (this.sessionInfo.curFriendUin != null) && (paramObject != null) && (this.sessionInfo.curFriendUin.equals(paramObject.uin)) && ((this.sessionInfo.curType == 1001) || (this.sessionInfo.curType == 1003) || (this.sessionInfo.curType == 10002)) && (paramObject.strCertificationInfo != null) && (!paramObject.strCertificationInfo.equals(""))) {
        acvv.f(this.app, this.sessionInfo);
      }
      if ((paramBoolean) && (paramObject != null)) {}
      switch (this.sessionInfo.curType)
      {
      default: 
        if ((this.sessionInfo.curFriendUin != null) && (this.sessionInfo.curFriendUin.equals(paramObject.uin)))
        {
          updateFriendNick();
          if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "onCardDownload nick = " + bftf.a(this.sessionInfo.curFriendNick));
          }
          this.mTitleText.setText(this.sessionInfo.curFriendNick);
          if (AppSetting.jdField_c_of_type_Boolean)
          {
            paramObject = this.mTitleText.getText().toString();
            this.mTitleText.setContentDescription(paramObject);
            getActivity().setTitle(this.mTitleText.getText());
          }
          if ((3000 == this.sessionInfo.curType) && ((this instanceof afim))) {
            ((afim)this).a(this.sessionInfo.curFriendNick, this.sessionInfo.curFriendUin, this.mTitleText);
          }
        }
      case 1034: 
        return;
      }
      instantUpdate(false, false);
      return;
    }
  }
  
  private void onMsgBoxClick(View paramView)
  {
    Intent localIntent = (Intent)paramView.getTag();
    localIntent.putExtra("message_box_click", true);
    MediaPlayerManager.a(this.app).a(false);
    paramView.setVisibility(8);
    if (this.mMsgboxline != null) {
      this.mMsgboxline.setVisibility(8);
    }
    int i = AIOUtils.openAioToAIOByMT(this.app, this.mActivity, localIntent);
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "openAIO by start SplashAct");
      }
      this.mActivity.startActivity(localIntent);
    }
    while (i != 2)
    {
      if ((localIntent.getBooleanExtra("finishAIO", false)) && ((this.mActivity instanceof ChatActivity))) {
        this.mActivity.finish();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, " onClick R.id.msgbox ");
      }
      return;
    }
    QLog.e(this.tag, 1, "openAIO rediectToAIOWithMt 2");
  }
  
  private void onPanelDestroy()
  {
    if (this.mEmoPanel != null)
    {
      this.mEmoPanel.onDestory();
      this.mEmoPanel = null;
    }
    if (this.mAudioPanel != null)
    {
      this.mAudioPanel.b();
      this.mAudioPanel.c();
    }
    if (this.mVoiceTextEditPanel != null) {
      this.mVoiceTextEditPanel.e();
    }
    if (this.mEmotionSearchPanel != null) {
      this.mEmotionSearchPanel.onDestory();
    }
    if (this.mApolloPanel != null)
    {
      this.mApolloPanelStatus = -1;
      this.mApolloPanel.h();
      this.mApolloPanel = null;
    }
    if (this.mDoodlePanel != null)
    {
      this.mDoodlePanel.a();
      this.mDoodlePanel = null;
    }
    if (this.mRichTextPanel != null) {
      this.mRichTextPanel.c();
    }
    if (this.root != null)
    {
      this.root.d();
      this.root.setReadyToShow(false);
    }
  }
  
  private void onQueryUinSafetyFlagInner(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean) || (paramInt1 != 146)) {
      return;
    }
    if (paramInt2 == 0)
    {
      alne.a().a(paramLong);
      return;
    }
    alne.a().a(paramLong, paramInt2);
    this.mActivity.runOnUiThread(new BaseChatPie.69(this, paramLong));
  }
  
  private void onSend()
  {
    afss localafss = (afss)getHelper(29);
    if ((this.input.getText().length() <= 0) && (getPhotoListSelectCount() <= 0))
    {
      localafss.b(false);
      return;
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, " onClick fun_btn start mInputStat = " + this.mInputStat + " text.length " + this.input.getText().length() + " currentPanel:" + this.root.a() + " currenttime:" + System.currentTimeMillis());
    }
    send();
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, " onClick fun_btn end mInputStat = " + this.mInputStat + "text.length" + this.input.getText().length() + "cast time :" + (l2 - l1));
      }
    }
    localafss.b(true);
  }
  
  private void onSetCommentInner(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {}
    switch (this.sessionInfo.curType)
    {
    default: 
    case 0: 
    case 1037: 
    case 1044: 
    case 1045: 
      do
      {
        do
        {
          return;
        } while (!paramString1.equals(this.sessionInfo.curFriendUin));
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          break;
        }
        this.sessionInfo.curFriendNick = paramString2;
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "onSetComment curFriendNick" + bftf.a(this.sessionInfo.curFriendNick));
        }
        this.mTitleText.setText(this.sessionInfo.curFriendNick);
      } while (!AppSetting.jdField_c_of_type_Boolean);
      paramString1 = this.mTitleText.getText().toString();
      this.mTitleText.setContentDescription(paramString1);
      getActivity().setTitle(this.mTitleText.getText());
      return;
      this.sessionInfo.curFriendNick = ContactUtils.getFriendShowName(this.app, this.sessionInfo.curFriendUin);
      paramString2 = this.sessionInfo;
      if (this.sessionInfo.curFriendNick != null) {}
      for (paramString1 = this.sessionInfo.curFriendNick;; paramString1 = this.sessionInfo.curFriendUin)
      {
        paramString2.curFriendNick = paramString1;
        break;
      }
    case 1: 
      instantUpdate(false, false);
      return;
    }
    instantUpdate(false, false);
  }
  
  private void onSetGenralSettingsTroopFilterInner(boolean paramBoolean)
  {
    if ((!paramBoolean) && (isActivityResume())) {
      QQToast.a(this.app.getApp(), 2130839615, this.mContext.getString(2131719243), 0).b(getTitleBarHeight());
    }
  }
  
  private void onShow_EmotionLayout()
  {
    if ((!isActivityResume()) || (this.emotionLayout == null)) {}
    for (;;)
    {
      try
      {
        this.emotionLayout = ((EmotionKeywordLayout)View.inflate(this.mContext, 2131558601, null));
        localObject = (afsu)getHelper(14);
        boolean bool = ((afsu)localObject).a();
        if (!bool) {
          continue;
        }
        this.emotionKeywordList = ((afsu)localObject).a(this.input);
        this.emotionKeywordList.setTouchListener(new BaseChatPie.53(this));
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368751);
        if (!bool) {
          continue;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e(this.tag, 2, "EmotionPreviewLayout InflateException = " + localException);
        continue;
        localException.addRule(11);
        continue;
      }
      this.mContent.addView(this.emotionLayout, (ViewGroup.LayoutParams)localObject);
      this.emoticonManager = ((avsq)this.app.getManager(14));
      return;
      this.emotionKeywordList = ((EmotionKeywordHorizonListView)this.emotionLayout.findViewById(2131366017));
      this.emotionKeywordAdapter = new EmotionKeywordAdapter(this.mContext, this.app, this.sessionInfo, this.input, this);
      this.emotionKeywordList.setAdapter(this.emotionKeywordAdapter);
    }
  }
  
  private void onShow_setReaded()
  {
    if ((avnj.e) && (bfyg.a(BaseApplication.getContext())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setReaded return : QQLSActivity is alive");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onShow_setReaded");
    }
    ThreadManager.post(new BaseChatpieHelper.UnreadTask(this.app, this), 8, null, false);
  }
  
  private void onShow_updateUI()
  {
    NativeVideoImage.resumeAll();
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = agjt.jdField_c_of_type_Int;
    AbstractGifImage.resumeAll();
    com.etrump.mixlayout.ETTextView.enableAnimation = true;
    ApngImage.playByTag(0);
    AbstractVideoImage.resumeAll();
    nrz.a().a();
    this.mAnimContainer.d();
    ((AvatarPendantManager)this.app.getManager(46)).b();
    this.listView.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onShow_updateUI: listView.setVisibility(View.VISIBLE)");
    }
    this.mTipsMgr.a(1000, new Object[0]);
    showQuickApolloSendPanel();
    showQuickSendPanel();
    Object localObject;
    if ((this.needShowAudioWhenResume) && (!this.mCacnelSellPttPanle))
    {
      if (!this.mHasGuideVoiceChangerDone)
      {
        initAudioPanelFlag(true, false);
        this.mAudioPanel.setCurrentPannel(0, true);
        this.mHasGuideVoiceChangerDone = true;
        this.needShowAudioWhenResume = false;
      }
    }
    else
    {
      this.input.setOnTouchListener(this);
      if ((this.isOpenFromShare) && (this.mIsFirtShowShareMsg))
      {
        atoe.a(this.mActivity, this.helperProvider);
        this.mIsFirtShowShareMsg = false;
      }
      if ((this.isOpenFromThirdParty) && (this.mIsFirstShowOpenIdMsg))
      {
        localObject = (atmm)this.helperProvider.a(37);
        if (localObject != null) {
          ((atmm)localObject).a(this.mActivity.getIntent(), true);
        }
        this.mIsFirstShowOpenIdMsg = false;
      }
      localObject = this.app.getPreferences();
      if (((SharedPreferences)localObject).getBoolean("sdcard_related_download_failed", false))
      {
        if (Environment.getExternalStorageState().equals("mounted")) {
          break label355;
        }
        QQToast.a(BaseApplication.getContext(), 2131694119, 0).b(getTitleBarHeight());
      }
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("sdcard_related_download_failed", false);
      ((SharedPreferences.Editor)localObject).commit();
      if (!this.uiHandler.hasMessages(64))
      {
        int i = awgw.a();
        this.uiHandler.sendEmptyMessageDelayed(64, i * 1000);
      }
      EmojiStickerManager.a().a(this);
      return;
      showAudioPanelIfNeed(true, false);
      break;
      label355:
      if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1) {
        QQToast.a(BaseApplication.getContext(), 2131717957, 0).b(getTitleBarHeight());
      }
    }
  }
  
  private void onShow_videoStatus()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onShow_videoStatus: mEnterExtPanel = " + this.mEnterExtPanel + ", mExtPanelOnResumeTimes = " + this.mExtPanelOnResumeTimes);
    }
    if (this.mEnterExtPanel != 0)
    {
      int i = this.mExtPanelOnResumeTimes - 1;
      this.mExtPanelOnResumeTimes = i;
      if (i == 0)
      {
        if (this.mEnterExtPanel != 1) {
          break label103;
        }
        this.root.post(new BaseChatPie.54(this));
      }
    }
    for (;;)
    {
      this.mEnterExtPanel = 0;
      return;
      label103:
      if (this.mEnterExtPanel == 2) {
        this.root.post(new BaseChatPie.55(this));
      }
    }
  }
  
  private void onUpdateC2ChatStatusInner(HashMap<String, String> paramHashMap)
  {
    if (!paramHashMap.containsKey(this.sessionInfo.curFriendUin)) {}
    aezf localaezf;
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.listView.getChildCount())
      {
        paramHashMap = this.listView.getChildAt(i);
        if ((paramHashMap != null) && ((paramHashMap instanceof BaseChatItemLayout)))
        {
          localaezf = (aezf)AIOUtils.getHolder(paramHashMap);
          paramHashMap = AIOUtils.getMessage(paramHashMap);
          if ((localaezf != null) && (paramHashMap != null) && (!paramHashMap.isSendFromLocal()) && (paramHashMap.istroop != 1) && (paramHashMap.istroop != 3000))
          {
            if (!arib.a(this.app, this.mContext, this.sessionInfo)) {
              break label136;
            }
            arib.a(this.app, this.mContext, this.sessionInfo, paramHashMap, localaezf);
          }
        }
        i += 1;
      }
    }
    label136:
    if ((paramHashMap.istroop == 1010) || (paramHashMap.istroop == 1001) || (paramHashMap.istroop == 10002) || (paramHashMap.istroop == 10010)) {}
    for (paramHashMap = FaceDrawable.getStrangerFaceDrawable(this.app, 200, paramHashMap.senderuin, true);; paramHashMap = FaceDrawable.getFaceDrawable(this.app, 1, paramHashMap.senderuin))
    {
      localaezf.a.setHeaderIcon(paramHashMap);
      break;
    }
  }
  
  private void onUpdateDelFriendInner(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.sessionInfo.curFriendUin.equals(paramObject + "")) && (!this.mActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "onUpdateDelFriend exit ChatActivity now uin = " + paramObject);
      }
      finish(1);
    }
  }
  
  private void onUpdateFriendInfoInner(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.sessionInfo.curType != 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.tag, 2, "onUpdateFriendInfo wrong uinType");
      return;
    } while ((this.sessionInfo.curType == 1034) || (((this.sessionInfo.curType != 1006) || (!paramString.equals(this.sessionInfo.contactUin))) && (!paramString.equals(this.sessionInfo.curFriendUin))));
    String str = null;
    if ((this.sessionInfo.curType == 1006) && (paramString.equals(this.sessionInfo.contactUin))) {
      str = ContactUtils.getFriendDisplayName(this.app, paramString);
    }
    for (;;)
    {
      this.sessionInfo.curFriendNick = str;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onUpdateFriendInfo title" + bftf.a(str));
      }
      this.mTitleText.setText(this.sessionInfo.curFriendNick);
      if (!AppSetting.jdField_c_of_type_Boolean) {
        break;
      }
      paramString = this.mTitleText.getText().toString();
      this.mTitleText.setContentDescription(paramString);
      getActivity().setTitle(this.mTitleText.getText());
      return;
      if (this.sessionInfo.curType == 1024) {
        str = npt.b(this.app, paramString);
      } else if (paramString.equals(this.sessionInfo.curFriendUin)) {
        str = ContactUtils.getFriendShowName(this.app, paramString);
      }
    }
  }
  
  private void panelAudioAction()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        getActivity().requestPermissions(new BaseChatPie.85(this), 2, new String[] { "android.permission.RECORD_AUDIO" });
        return;
        i = 0;
      }
      else
      {
        afgw.a().a(this.mContext);
        this.root.a(2);
        agwt.a(this.app, "0X8005CAC", this.sessionInfo.curType);
        return;
        i = 1;
      }
    }
  }
  
  private void panelCameraAction()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (getActivity().checkSelfPermission("android.permission.CAMERA") == 0)
      {
        i = 1;
        if ((i == 0) || (getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
          break label129;
        }
        i = 1;
        label42:
        if ((i == 0) || (!PermissionUtils.isStorePermissionEnable(getActivity()))) {
          break label134;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label58:
      if (i == 0) {
        getActivity().requestPermissions(new BaseChatPie.83(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      }
      for (;;)
      {
        agwt.a(this.app, "0X800407A", this.sessionInfo.curType);
        return;
        i = 0;
        break;
        label129:
        i = 0;
        break label42;
        label134:
        i = 0;
        break label58;
        grantForCamera();
      }
      i = 1;
    }
  }
  
  private void panelEmotionAction()
  {
    if (this.mInputStat != 1)
    {
      if (this.mEmoPanel != null) {
        this.needRecreateEmotionPanel = (isFullScreenMode() ^ this.mEmoPanel.onlySysAndEmoji);
      }
      this.root.a(3);
      if (this.mEmoPanel != null) {
        this.mEmoPanel.preloadWebProcess();
      }
      showEmoticonGuideBubble();
      agwt.a(this.app, "0X8005CAD", this.sessionInfo.curType);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "ep_mall", "0X8005795", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  private void panelHotpicAction()
  {
    if (this.mInputStat != 1) {
      this.root.a(24);
    }
  }
  
  private void panelNotificationAction()
  {
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("finish_animation_up_down", true);
    bfcx localbfcx = bfcx.a();
    Object localObject2 = localbfcx.a("troop_homework_create_notice");
    Object localObject1 = localObject2;
    if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://web.qun.qq.com/mannounce/schooledit.html?_bid=148&_wv=1031&from=<$FROM>&content=<$CONTENT>&gc=<$GC>";
    }
    localObject2 = new bfcy();
    ((bfcy)localObject2).jdField_a_of_type_JavaLangString = this.sessionInfo.curFriendUin;
    ((bfcy)localObject2).c = "aio";
    ((bfcy)localObject2).i = "";
    localIntent.putExtra("url", localbfcx.a((String)localObject1, (bfcy)localObject2));
    this.mContext.startActivity(localIntent);
    this.mActivity.overridePendingTransition(2130772300, 2130771990);
    bftc.a(this.app, this.sessionInfo.curFriendUin, "Grp_notice", "CreateNotice_Clk", 0, 0, new String[] { this.sessionInfo.curFriendUin, "", "", "" });
  }
  
  private void panelPokeAction(int paramInt)
  {
    if (paramInt == 26)
    {
      this.panelicons.setShowRed(26, false);
      agkg.a(this.app, true);
      paramInt = agkg.b(this.app);
      acvv.b(this.app, BaseApplicationImpl.getContext(), this.sessionInfo, paramInt, "", "");
      bcef.b(this.app, "CliOper", "", this.sessionInfo.curFriendUin, "0X8007F23", "0X8007F23", paramInt, 0, "", "", "", "");
    }
  }
  
  private void panelPtvAction()
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = PermissionUtils.isStorePermissionEnable(getActivity());; bool = true)
    {
      if (!bool)
      {
        getActivity().requestPermissions(new BaseChatPie.84(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      doShowPtv(true);
      return;
    }
  }
  
  private boolean preCheckUpdate(Object paramObject)
  {
    if ((this.mActivity instanceof SplashActivity))
    {
      if (this.mActivity.isFinishing()) {
        return true;
      }
      Fragment localFragment = ((SplashActivity)this.mActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if ((localFragment != null) && (!localFragment.isVisible())) {
        return true;
      }
    }
    return paramObject == null;
  }
  
  private boolean preFinish(int paramInt)
  {
    afls.a().a();
    if (this.uiHandler.hasMessages(59)) {
      this.uiHandler.removeMessages(59);
    }
    if (this.mApolloViewObserver != null) {
      this.mApolloViewObserver.a(true, paramInt);
    }
    this.helperProvider.a(11);
    this.isHaveNewAfterIn = false;
    boolean bool1 = restoreMultiSelectModeBeforeFinish(false);
    if ((bool1) && (paramInt == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "basechatpie_finish 1,type:" + paramInt);
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (this.receiptMode)
          {
            switchReceiptMode();
            bool1 = true;
          }
          if ((!bool1) || (paramInt != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.tag, 2, "basechatpie_finish 1.1,type:" + paramInt);
        return true;
        bool2 = bool1;
        if (this.mMagicfaceViewController != null)
        {
          bool2 = bool1;
          if (this.mMagicfaceViewController.b()) {
            bool2 = true;
          }
        }
        if ((!bool2) || (paramInt != 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.tag, 2, "basechatpie_finish 2,type:" + paramInt);
      return true;
      saveChatInputTypeBeforeFinish(paramInt);
      boolean bool2 = dispatchFinishToPanel(paramInt, bool2);
      bool1 = bool2;
      if (this.mAIOGiftPanelContainer != null)
      {
        bool1 = bool2;
        if (this.mAIOGiftPanelContainer.a())
        {
          this.mAIOGiftPanelContainer.a();
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramInt == 0)
        {
          bool2 = bool1;
          if (this.mDoodlePanel != null)
          {
            bool2 = bool1;
            if (this.mDoodlePanel.a()) {
              bool2 = true;
            }
          }
        }
      }
      if ((!bool2) || (paramInt != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.tag, 2, "basechatpie_finish 3,type:" + paramInt);
    return true;
    return false;
  }
  
  private void refreshHeadMessage_attention(int paramInt1, long paramLong1, int paramInt2, long paramLong2, Runnable paramRunnable)
  {
    MessageRecord localMessageRecord = this.app.getMessageFacade().queryMsgItemByShmsgseq4Troop(this.sessionInfo.curFriendUin, this.sessionInfo.curType, paramLong1);
    if ((localMessageRecord != null) && (paramInt2 <= 200))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag + ".troop.special_msg", 2, "refreshHeadMessage==>unreadMsgCount:" + paramInt2 + ", fistseq:" + paramLong2 + ", mr.shmsgseq:" + localMessageRecord.shmsgseq);
      }
      if ((int)paramLong2 >= localMessageRecord.shmsgseq + 1L)
      {
        if (this.mTroopTips != null) {
          this.mTroopTips.a(paramLong2, localMessageRecord.shmsgseq, false);
        }
        this.mScrollerRunnable.a(paramInt1, 0, -1, paramRunnable, this.uiHandler, 6);
      }
    }
    do
    {
      do
      {
        return;
        paramInt2 = this.listAdapter.c(paramLong1);
      } while (paramInt2 == -1);
      this.mScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, this.uiHandler, 6);
      return;
      boolean bool = this.app.getMessageFacade().getTroopMessageManager().c(this.sessionInfo.curFriendUin);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag + ".trooptroop_pull_msg", 2, "所要定位的消息还没拉回来本地，并发拉取中...mUserActionState create, natvigateSeq:" + paramLong1 + ",isAioParallelPullMsgDone:" + bool);
      }
      if (!bool) {
        break;
      }
      if ((int)paramLong2 >= 1L + paramLong1)
      {
        if (this.mTroopTips != null) {
          this.mTroopTips.a(paramLong2, paramLong1, false);
        }
        this.mScrollerRunnable.a(paramInt1, 0, -1, paramRunnable, this.uiHandler, 6);
        return;
      }
      paramInt2 = this.listAdapter.c(paramLong1);
    } while (paramInt2 == -1);
    this.mScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, this.uiHandler, 6);
    return;
    this.mUserActionState = new becx();
    this.mUserActionState.d = becx.jdField_c_of_type_Int;
    this.mUserActionState.a = bdyo.a(paramInt1, paramLong1, paramInt2);
    this.app.getMessageFacade().getTroopMessageManager().addObserver(this);
  }
  
  private void refreshHeadMessage_other(int paramInt1, long paramLong1, int paramInt2, long paramLong2, Runnable paramRunnable)
  {
    ThreadManager.post(new BaseChatPie.38(this, paramLong1, paramInt2, paramLong2, paramInt1, paramRunnable), 8, null, true);
  }
  
  private void refreshHeadMessage_replyMsg(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2, Runnable paramRunnable)
  {
    if (paramInt2 <= 200)
    {
      if (paramLong2 - paramLong1 > paramInt2)
      {
        QQToast.a(this.mActivity, 2131697162, 0).b(this.mActivity.getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "refreshHeadMessage: invalidate unread count");
        }
        if (paramInt3 == 1) {
          agmk.a(this.app, null, "0X800A36B");
        }
      }
      do
      {
        return;
        if ((int)paramLong2 < 1L + paramLong1) {
          break label170;
        }
        if (NetworkUtil.isNetworkAvailable(this.mActivity)) {
          break;
        }
        QQToast.a(this.mActivity, 2131696687, 0).b(this.mActivity.getTitleBarHeight());
      } while (paramInt3 != 1);
      agmk.a(this.app, null, "0X800A36B");
      return;
      if (this.mTroopTips != null) {
        this.mTroopTips.a(paramLong2, paramLong1, false);
      }
      this.mScrollerRunnable.a(paramInt1, 0, -1, paramRunnable, 6);
      return;
      label170:
      List localList = this.app.getMessageFacade().queryMsgItemByShmsgseq(this.sessionInfo.curFriendUin, this.sessionInfo.curType, paramLong1, 0L);
      if ((localList == null) || (localList.size() <= 0)) {
        break label450;
      }
      paramInt2 = 0;
      label216:
      if (paramInt2 >= localList.size()) {
        break label450;
      }
      paramRunnable = (MessageRecord)localList.get(paramInt2);
      if ((abwz.a(paramRunnable)) || ((paramRunnable instanceof MessageForSafeGrayTips))) {}
    }
    for (;;)
    {
      if ((paramRunnable != null) && (!aucg.a(paramRunnable)))
      {
        paramInt2 = this.listAdapter.a(paramRunnable.uniseq);
        if (paramInt2 != -1)
        {
          this.mScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, 6);
          return;
          paramInt2 += 1;
          break label216;
        }
        if (paramRunnable.msgtype == -2006) {
          QQToast.a(this.mActivity, amtj.a(2131700122), 0).b(this.mActivity.getTitleBarHeight());
        }
        if (paramInt3 != 1) {
          break;
        }
        agmk.a(this.app, null, "0X800A36B");
        return;
      }
      QQToast.a(this.mActivity, 2131697162, 0).b(this.mActivity.getTitleBarHeight());
      if (paramInt3 != 1) {
        break;
      }
      agmk.a(this.app, null, "0X800A36B");
      return;
      QQToast.a(this.mActivity, 2131697163, 0).b(this.mActivity.getTitleBarHeight());
      if (paramInt3 != 1) {
        break;
      }
      agmk.a(this.app, null, "0X800A36B");
      return;
      label450:
      paramRunnable = null;
    }
  }
  
  private void refreshHeadMessage_troopEssenceMsg(int paramInt, long paramLong1, long paramLong2, Runnable paramRunnable)
  {
    if (paramLong2 - paramLong1 > 200L)
    {
      QQToast.a(this.mActivity, 2131719141, 0).b(this.mActivity.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "refreshHeadMessage: invalidate unread count TYPE_TROOP_ESSENCEMSG");
      }
      return;
    }
    if ((int)paramLong2 >= 1L + paramLong1)
    {
      if (!NetworkUtil.isNetworkAvailable(this.mActivity))
      {
        QQToast.a(this.mActivity, 2131696687, 0).b(this.mActivity.getTitleBarHeight());
        return;
      }
      if (this.mTroopTips != null) {
        this.mTroopTips.a(paramLong2, paramLong1, false);
      }
      this.mScrollerRunnable.a(paramInt, 0, -1, paramRunnable, 6);
      return;
    }
    int i = this.listAdapter.c(paramLong1);
    if (i != -1)
    {
      this.mScrollerRunnable.a(paramInt, i, i, null, 6);
      return;
    }
    QQToast.a(this.mActivity, 2131719141, 0).b(this.mActivity.getTitleBarHeight());
  }
  
  private void refreshHeadMessage_unreadMsg(long paramLong1, long paramLong2, Runnable paramRunnable)
  {
    if ((int)paramLong2 >= 1L + paramLong1)
    {
      if (paramLong2 - paramLong1 <= 200L) {
        break label57;
      }
      paramLong1 = paramLong2 - 200L;
    }
    label57:
    for (;;)
    {
      if (this.mTroopTips != null) {
        this.mTroopTips.a(paramLong2, paramLong1, true);
      }
      this.mScrollerRunnable.a(0, -1, paramRunnable, 6);
      return;
    }
  }
  
  private List<ChatMessage> refreshListAdapterGetNewMsg(List<ChatMessage> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "refreshListAdapter refreshFlag: " + paramInt);
    }
    switch (this.dirty & 0xFFFF0000)
    {
    default: 
      return paramList;
    case 65536: 
      this.listAdapter.notifyDataSetChanged();
      return paramList;
    }
    paramList = getAIOList(this.onShowDone);
    if (this.listView != null)
    {
      bfzg.a(null, "AIO_BaseChatPie_Remove_Sticker_Cost");
      EmojiStickerManager.a().a(this, paramList);
      bfzg.a("AIO_BaseChatPie_Remove_Sticker_Cost", null);
    }
    handleMarketFaceMsgRefresh(paramList);
    Object localObject = getMessageRecordSource(paramList);
    if (localObject != null) {
      this.mPreMrShMsgSeqForCurType = ((MessageRecord)localObject).shmsgseq;
    }
    handleRefreshSingleTitle(paramList, (MessageRecord)localObject);
    localObject = getMessageSourceSequenceExt(paramList, ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo, (MessageRecord)localObject, this.mPreMrShMsgSeqForCurType));
    if (this.sessionInfo.curType == 1)
    {
      bfas localbfas = (bfas)this.app.getManager(132);
      if (localbfas.b(this.sessionInfo.curFriendUin)) {
        localbfas.a(this.sessionInfo.curFriendUin, paramList);
      }
    }
    handleRefreshPokeStatus(paramList);
    if (this.isJubaoMode) {
      paramList = auww.a(paramList);
    }
    for (;;)
    {
      setList(paramList, (CharSequence)localObject, this.dirty);
      needShowTimeForLastMsgItem();
      ChatFragment.a(true);
      this.mAIORootView.invalidate();
      return paramList;
    }
  }
  
  private int refreshListAdapterScroll(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    switch (paramInt6)
    {
    case 5: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      paramInt1 = refreshListAdapterScroll_default(paramList1, paramList2, paramInt3, paramInt4, paramInt5);
    }
    for (;;)
    {
      if (paramInt6 == 6)
      {
        paramInt1 = paramInt5 - (paramInt4 - this.mReadedCnt);
        this.mScrollerRunnable.a(this.listView.getHeaderViewsCount(), -1, null, 7);
        if ((this.mScrollerRunnable.a() == 22) || (this.mScrollerRunnable.a() == 103)) {
          QQToast.a(this.app.getApp(), 1, this.mContext.getString(2131697257), 3000).b(getTitleBarHeight());
        }
      }
      while (paramInt6 != 7)
      {
        return paramInt1;
        paramInt1 = jumpBottom(paramInt5);
        break;
        if (!blockRefreshJumpBottom()) {
          this.mScrollerdownRunnable.a();
        }
        paramInt1 = paramInt5;
        break;
        if (paramInt4 == 0)
        {
          this.listView.setSelectionFromBottom(this.listView.getHeaderViewsCount() + paramInt5 - 1, 0);
          this.listView.hideOverScrollHeaderView();
          paramInt1 = paramInt5;
          break;
        }
        this.listView.hideOverScrollHeaderView();
        paramInt1 = jumpTop(paramList1, paramList2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
        break;
        jumpToSpecifiedMsg();
        paramInt1 = paramInt3;
        break;
        paramList1 = this.listAdapter.a();
        if ((paramList1.size() <= 0) || (this.refreshScrollMsg < 0L)) {
          break label536;
        }
        paramInt1 = getIndexOfMsg(paramList1, this.refreshScrollMsg);
        if (paramInt1 >= 0)
        {
          this.mScrollerRunnable.b(paramInt1, 1);
          this.refreshScrollMsg = -1L;
        }
        paramInt1 = paramInt3;
        break;
        BaseChatpieHelper.a(this.tag, this.listView, 0, paramList1, paramList2);
        paramInt1 = this.mReadedCnt + paramInt5 - paramInt4;
        break;
        jumpToSpecifiedMsgSimply();
        paramInt1 = paramInt3;
        break;
        QQToast.a(this.app.getApp(), 1, this.mContext.getString(2131697258), 3000).b(getTitleBarHeight());
        return paramInt1;
      }
      paramInt3 = this.mReadedCnt;
      paramInt2 = this.listAdapter.getCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        paramList1 = (ChatMessage)this.listAdapter.getItem(paramInt1);
        if ((paramList1 == null) || (paramList1.msgtype != -4009)) {}
      }
      for (;;)
      {
        paramList1 = this.mScrollerRunnable;
        if (paramInt1 == 0) {}
        for (paramInt2 = 0;; paramInt2 = -1)
        {
          paramList1.a(paramInt1, paramInt2, null, 8);
          return paramInt5 - (paramInt4 - paramInt3);
          paramInt1 += 1;
          break;
        }
        paramInt1 = 0;
      }
      label536:
      paramInt1 = paramInt3;
    }
  }
  
  private int refreshListAdapterScroll_default(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    long l;
    if (paramList1 != paramList2)
    {
      if ((paramInt2 <= 0) || (paramInt3 <= 0)) {
        break label169;
      }
      l = ((ChatMessage)paramList1.get(paramInt2 - 1)).uniseq;
      i = paramInt3 - 1;
      if (i < 0) {
        break label169;
      }
      if ((i != paramInt3 - 1) || (!aucg.a((MessageRecord)paramList2.get(i)))) {
        break label104;
      }
      i = -1;
    }
    for (;;)
    {
      label76:
      if (i >= 0) {
        i = paramInt3 - (paramInt2 - this.mReadedCnt + paramInt3 - 1 - i);
      }
      label104:
      do
      {
        do
        {
          return i;
          if (((ChatMessage)paramList2.get(i)).uniseq == l) {
            break label76;
          }
          i -= 1;
          break;
          i = paramInt1;
        } while (paramInt3 <= 0);
        i = paramInt1;
      } while (aucg.a((MessageRecord)paramList2.get(paramInt3 - 1)));
      return paramInt3;
      label169:
      i = -1;
    }
  }
  
  private void refreshMusicItem()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMusicItem");
    }
    this.listAdapter.notifyDataSetChanged();
  }
  
  private void remainScreenOn()
  {
    if (this.mScreenWakeLoack == null) {
      this.mScreenWakeLoack = ((PowerManager)this.mActivity.getSystemService("power")).newWakeLock(536870918, this.tag);
    }
    if (!this.mScreenWakeLoack.isHeld()) {
      this.mScreenWakeLoack.acquire();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "remainScreenOn");
    }
  }
  
  private void reportCancelPttEvent(int paramInt)
  {
    bfxf.a(this.app, paramInt);
  }
  
  private void reportClassicAndSmallEmoticon(String paramString, boolean paramBoolean, EmoticonMainPanel paramEmoticonMainPanel, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new ReportWorker(paramString, paramBoolean, paramEmoticonMainPanel, paramQQAppInterface, getCurType()), 2, null, false);
  }
  
  private void reportNotificationClick()
  {
    Bundle localBundle = this.mActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      bcef.b(this.app, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
    }
  }
  
  private void resetArkMsgInputState()
  {
    if ((this.listView == null) || (this.listView.getAdapter() == null)) {}
    for (;;)
    {
      return;
      int i = this.listView.getFirstVisiblePosition();
      int j = this.listView.getLastVisiblePosition();
      while ((i <= j) && (i < this.listView.getAdapter().getCount()))
      {
        Object localObject = this.listView.getAdapter().getItem(i);
        if ((localObject instanceof MessageForArkApp))
        {
          localObject = (MessageForArkApp)localObject;
          if (((MessageForArkApp)localObject).arkContainer != null) {
            ((MessageForArkApp)localObject).arkContainer.d();
          }
        }
        i += 1;
      }
    }
  }
  
  private boolean restoreMultiSelectModeBeforeFinish(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (BaseChatItemLayout.jdField_a_of_type_Boolean)
    {
      if (!this.isJubaoMode)
      {
        setLeftCheckBoxVisible(false, null, false);
        bool = true;
      }
    }
    else {
      return bool;
    }
    awcm.a().jdField_a_of_type_Int = 0;
    return paramBoolean;
  }
  
  private void saveC2CChatInputType(amsw paramamsw, int paramInt1, int paramInt2)
  {
    ExtensionInfo localExtensionInfo = paramamsw.a(this.sessionInfo.curFriendUin, false);
    paramamsw = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      if (this.mExtensionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "saveC2CChatInputType | mExtensionInfo != null");
        }
        paramamsw = this.mExtensionInfo;
      }
    }
    else
    {
      if (paramamsw.chatInputType != paramInt1)
      {
        paramamsw.chatInputType = paramInt1;
        paramamsw.isDataChanged = true;
      }
      if (paramamsw.showC2CPanel != paramInt2)
      {
        paramamsw.showC2CPanel = paramInt2;
        paramamsw.isDataChanged = true;
      }
      this.mExtensionInfo = null;
    }
  }
  
  private void saveChatInputType()
  {
    long l = System.currentTimeMillis();
    amsw localamsw;
    int i;
    if ((this.sessionInfo != null) && (!this.isSimpleBar))
    {
      localamsw = (amsw)this.app.getManager(51);
      if ((this.root.a() != 2) || (this.root.a() == null) || (this.root.a().getVisibility() != 0)) {
        break label138;
      }
      i = 1;
      if ((this.sessionInfo.curType != 3000) && (this.sessionInfo.curType != 1)) {
        break label143;
      }
      saveNoC2CChatInputType(localamsw, 0, i);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("save_inptut", 2, "saveChatInputType cost :" + (System.currentTimeMillis() - l));
      }
      return;
      label138:
      i = 0;
      break;
      label143:
      if (isC2CSession()) {
        saveC2CChatInputType(localamsw, 0, i);
      }
    }
  }
  
  private void saveChatInputTypeBeforeFinish(int paramInt)
  {
    if (paramInt == 1) {
      saveChatInputType();
    }
    while ((paramInt != 0) || (this.root.a() != 0)) {
      return;
    }
    saveChatInputType();
  }
  
  private void saveNoC2CChatInputType(amsw paramamsw, int paramInt1, int paramInt2)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramamsw.a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null)
    {
      if (this.mNoC2CExtensionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "saveNoC2CChatInputType | mNoC2CExtensionInfo != null");
        }
        localNoC2CExtensionInfo1 = this.mNoC2CExtensionInfo;
      }
    }
    else
    {
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
      paramamsw.a(localNoC2CExtensionInfo1, false);
      this.mNoC2CExtensionInfo = null;
    }
  }
  
  private void sendMessageInner(String paramString, acwc paramacwc, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    if (this.receiptMode)
    {
      azuu.a().a(this.app, this.sessionInfo, paramString, paramArrayList, paramacwc);
      switchReceiptMode();
      return;
    }
    acvv.a(this.app, this.mContext, this.sessionInfo, paramString, paramArrayList, paramacwc);
  }
  
  private void setC2CLastAudioPanelType(amsw paramamsw)
  {
    ExtensionInfo localExtensionInfo = paramamsw.a(this.sessionInfo.curFriendUin, false);
    if ((localExtensionInfo == null) && (!paramamsw.d())) {
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.78(this, paramamsw));
    }
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1)) {
      this.mAudioPanel.setCurrentPannel(localExtensionInfo.audioPanelType, false);
    }
  }
  
  private void setIsPauseRefresh(boolean paramBoolean)
  {
    this.isPauseRefresh = paramBoolean;
  }
  
  private void setListViewPaddingBottom(int paramInt)
  {
    if ((this.mInputBar.getVisibility() == 0) && (this.listView.getPaddingBottom() != paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onLayoutChange() update list.paddingBottom from " + this.listView.getPaddingBottom() + " to " + paramInt);
      }
      this.listView.setPadding(this.listView.getPaddingLeft(), this.listView.getPaddingTop(), this.listView.getPaddingRight(), paramInt);
    }
  }
  
  private void setNoC2CLastAudioPanelType(amsw paramamsw)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = paramamsw.a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, false);
    if ((localNoC2CExtensionInfo == null) && (!paramamsw.d())) {
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.79(this, paramamsw));
    }
    if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.audioPanelType != -1)) {
      this.mAudioPanel.setCurrentPannel(localNoC2CExtensionInfo.audioPanelType, false);
    }
  }
  
  private void shieldMsg(String paramString)
  {
    ChatActivityUtils.a(this.app, this.mActivity, this.sessionInfo.curType, paramString, this.sessionInfo.phoneNum, false);
    if (this.sessionInfo.curType == 1010) {
      bcef.b(this.app, "CliOper", "", this.sessionInfo.curFriendUin, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    }
  }
  
  private boolean shouldShowAudioPanel()
  {
    return (this.sessionInfo.curType != 1008) && (!this.isFromSeachResult);
  }
  
  private void showAudioPanelIfNeedForC2C(amsw paramamsw, boolean paramBoolean1, boolean paramBoolean2)
  {
    ExtensionInfo localExtensionInfo = paramamsw.a(this.sessionInfo.curFriendUin, false);
    paramamsw = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      if (this.mExtensionInfo != null) {
        paramamsw = this.mExtensionInfo;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "showAudioPanelIfNeedForC2C extInfo.chatInputType = " + paramamsw.chatInputType + " extInfo.showC2CPanel = " + paramamsw.showC2CPanel);
      }
      if (paramamsw.chatInputType == 2) {
        break label111;
      }
    }
    label111:
    while (paramamsw.showC2CPanel != 1)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.tag, 2, "showAudioPanelIfNeed | ExtensionInfo = null");
      return;
    }
    initAudioPanelFlag(paramBoolean1, paramBoolean2);
  }
  
  private void showAudioPanelIfNeedForNoC2C(amsw paramamsw, boolean paramBoolean1, boolean paramBoolean2)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = paramamsw.a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, false);
    paramamsw = localNoC2CExtensionInfo;
    if (localNoC2CExtensionInfo == null)
    {
      if (this.mNoC2CExtensionInfo != null) {
        paramamsw = this.mNoC2CExtensionInfo;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "showAudioPanelIfNeedForNoC2C noC2CExtInfo.chatInputType = " + paramamsw.chatInputType + " noC2CExtInfo.showC2CPanel = " + paramamsw.showC2CPanel);
      }
      if (paramamsw.chatInputType == 2) {
        break label118;
      }
    }
    label118:
    while (paramamsw.showC2CPanel != 1)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.tag, 2, "showAudioPanelIfNeed | NoC2CExtensionInfo = null");
      return;
    }
    initAudioPanelFlag(paramBoolean1, paramBoolean2);
  }
  
  private void showEmoticonGuideBubble()
  {
    ((afoi)this.helperProvider.a(54)).a();
  }
  
  private void showInputPanelIfNeeded()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "showInputPanelIfNeeded() called");
    }
    Object localObject = getActivity();
    if (localObject == null) {}
    do
    {
      boolean bool;
      do
      {
        return;
        localObject = ((Activity)localObject).getIntent();
        if (localObject == null)
        {
          QLog.e(this.tag, 1, "showInputPanelIfNeeded() intent == null");
          return;
        }
        bool = ((Intent)localObject).getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false);
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "showInputPanelIfNeeded() requestShowInputPanel = " + bool + ", Intent = " + System.identityHashCode(localObject));
        }
      } while ((!bool) || (this.root == null));
      if (this.root.c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.tag, 2, "showInputPanelIfNeeded() isReadyToShow false");
    return;
    showInputPanel();
    this.uiHandler.removeCallbacks(this.mRetryShowInputPanelTask);
    this.mRetryShowInputPanelTask = new BaseChatPie.24(this, (Intent)localObject);
    this.uiHandler.postDelayed(this.mRetryShowInputPanelTask, 100L);
  }
  
  private void showPanel(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 21: 
      showAvatarPanel();
      return;
    case 24: 
      panelHotpicAction();
      return;
    case 3: 
      panelEmotionAction();
      return;
    case 2: 
      panelAudioAction();
      return;
    case 9: 
      agwt.a(this.app, this.mActivity);
      return;
    case 6: 
      panelPtvAction();
      return;
    case 5: 
      panelCameraAction();
      return;
    case 14: 
      this.root.a(14);
      agwt.a(this.app, "0X8005977", this.sessionInfo.curType);
      return;
    case 26: 
      panelPokeAction(paramInt);
      return;
    case 22: 
      this.root.a(22);
      return;
    case 31: 
      panelNotificationAction();
      return;
    }
    PublishHomeWorkFragment.a(this.app, this.mActivity, this.sessionInfo.curFriendUin);
    bftc.a(this.app, this.sessionInfo.curFriendUin, "homework", "AioAssign_Clk", 0, 0, new String[] { this.sessionInfo.curFriendUin, "", "", bftc.a(this.app, this.sessionInfo.curFriendUin) });
  }
  
  private void showPlusPanelIfNeeded()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "showPlusPanelIfNeeded() called");
    }
    Object localObject = getActivity();
    if (localObject == null) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return;
          localObject = ((Activity)localObject).getIntent();
        } while (localObject == null);
        bool = ((Intent)localObject).getBooleanExtra("KEY_SHOULD_SHOW_PLUS_PANEL", false);
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "showPlusPanelIfNeeded() requestShowPlusPanel = " + bool + ", Intent = " + System.identityHashCode(localObject));
        }
      } while ((!bool) || (this.root == null));
      if (this.root.c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.tag, 2, "showPlusPanelIfNeeded() isReadyToShow false");
    return;
    this.root.a(8);
    this.uiHandler.postDelayed(new BaseChatPie.25(this, (Intent)localObject), 100L);
  }
  
  public static void showPttToast(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = bfxd.b(paramBoolean1, paramBoolean2, paramBoolean3);
    if (i > 0) {
      QQToast.a(paramContext, i, 0).b(paramContext.getResources().getDimensionPixelSize(2131299076));
    }
  }
  
  private void showQuickApolloSendPanel()
  {
    Intent localIntent;
    int i;
    if (isApolloForward())
    {
      this.mEnterExtPanel = 21;
      localIntent = this.mActivity.getIntent();
      if (!localIntent.hasExtra("apollo_actionid_key")) {
        break label170;
      }
      i = localIntent.getExtras().getInt("apollo_actionid_key");
      localIntent.removeExtra("apollo_actionid_key");
    }
    for (;;)
    {
      int j;
      if (localIntent.hasExtra("apollo_pkgid_key"))
      {
        j = localIntent.getExtras().getInt("apollo_pkgid_key");
        localIntent.removeExtra("apollo_pkgid_key");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, new Object[] { "showQuickApolloSendPanel, pkgId=", Integer.valueOf(j), ", actionId=", Integer.valueOf(i) });
        }
        if (this.mApolloPanel != null) {
          this.mApolloPanel.b(j, i);
        }
        for (;;)
        {
          showAvatarPanel();
          this.mJumpActionId = -1;
          this.mPkgId = -1;
          return;
          this.mJumpActionId = i;
          this.mPkgId = j;
        }
        j = -1;
      }
      label170:
      i = -1;
    }
  }
  
  private void showQuickSendPanel()
  {
    if (isEmoPgkForward())
    {
      SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("mobileQQ", 4);
      if (localSharedPreferences.getBoolean("FORWARD_EMOPGK_ID", false))
      {
        String str = this.mActivity.getIntent().getExtras().getInt("FORWARD_EMOPGK_ID") + "";
        localSharedPreferences.edit().remove("FORWARD_EMOPGK_ID").commit();
        this.mEnterExtPanel = 3;
        showEmoticonPanel(str);
      }
    }
  }
  
  private void showUnbindFriendActionSheet()
  {
    bjnw localbjnw = (bjnw)bjon.a(getActivity(), null);
    localbjnw.a(this.app.getApplication().getResources().getString(2131718525));
    localbjnw.a(2131718523, 3);
    localbjnw.b(2131718522);
    localbjnw.c(2131690620);
    localbjnw.a(new BaseChatPie.11(this, localbjnw));
    localbjnw.show();
    bcef.b(null, "dc00898", "", "", "0X800ACA2", "0X800ACA2", 0, 0, "", "0", "0", "");
  }
  
  private void udpateAIOBackgrourd(Message paramMessage)
  {
    if (this.afRoot == null) {
      paramMessage = "1";
    }
    for (;;)
    {
      updateAIOBackgrourdErr(paramMessage);
      return;
      if (paramMessage.obj == null)
      {
        paramMessage = "2";
      }
      else
      {
        if ((paramMessage.obj instanceof Drawable)) {
          break;
        }
        paramMessage = "3, msg.obj=" + paramMessage.obj;
      }
    }
    if ((this.sessionInfo.isQimUserOnline) && (this.sessionInfo.isQimUserTitleForm) && (!this.sessionInfo.isNightMode))
    {
      this.afRoot.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849953));
      this.sessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
    }
    for (;;)
    {
      handleNightMask();
      paramMessage = null;
      break;
      if ((this.sessionInfo.isTimUserOnline) && (this.sessionInfo.isTimUserTitleForm) && (!this.sessionInfo.isNightMode))
      {
        this.afRoot.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849953));
        this.sessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else if ((this.sessionInfo.curType == 1033) || (this.sessionInfo.curType == 1034))
      {
        this.afRoot.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849953));
        this.sessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else if (this.sessionInfo.curType == 10007)
      {
        if (!ThemeUtil.isNowThemeIsNight(this.app, false, null))
        {
          this.afRoot.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849953));
          this.sessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
        }
      }
      else
      {
        this.afRoot.setBackgroundDrawable((Drawable)paramMessage.obj);
        if (bdav.a().c()) {
          bdav.a().b(this.afRoot.getContext(), this.afRoot);
        }
        ((afrz)this.helperProvider.a(17)).a(this.mContext, this.app, this.sessionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND sessionInfo:  isQimUserOnline = " + this.sessionInfo.isQimUserOnline + "  isQimUserTitleForm = " + this.sessionInfo.isQimUserTitleForm + "  isTimUserOnline = " + this.sessionInfo.isTimUserOnline + " isTimUserTitleForm = " + this.sessionInfo.isTimUserTitleForm + "  isNightMode = " + this.sessionInfo.isNightMode + "  curType = " + this.sessionInfo.curType);
        }
      }
    }
  }
  
  private void unbindDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void unbindDrawables()
  {
    if (this.listView != null) {
      unbindDrawable(this.listView.getOverscrollHeader());
    }
    if (this.mMsgbox != null) {
      unbindDrawable(this.mMsgbox.getBackground());
    }
    if (this.shieldTV != null) {
      unbindDrawable(this.shieldTV.getBackground());
    }
    if (this.addFriendTv != null) {
      unbindDrawable(this.addFriendTv.getBackground());
    }
  }
  
  private void updateAIOBackgrourdErr(String paramString)
  {
    if (paramString != null)
    {
      if ((this.afRoot == null) || (this.sessionInfo == null) || (this.sessionInfo.chatBg == null) || ((this.sessionInfo.chatBg.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!aezp.a(this.mContext, this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin, true, 7, this.sessionInfo.chatBg)))) {
        break label330;
      }
      if ((!this.sessionInfo.isQimUserOnline) || (!this.sessionInfo.isQimUserTitleForm) || (this.sessionInfo.isNightMode)) {
        break label184;
      }
      this.afRoot.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849953));
      this.sessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
    }
    for (;;)
    {
      QLog.e("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND Error. bErrMsg=" + paramString + ", show Again img=" + this.sessionInfo.chatBg.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
      label184:
      if ((this.sessionInfo.isTimUserOnline) && (this.sessionInfo.isTimUserTitleForm) && (!this.sessionInfo.isNightMode))
      {
        this.afRoot.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849953));
        this.sessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else if ((this.sessionInfo.curType == 1033) || (this.sessionInfo.curType == 1034))
      {
        this.afRoot.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849953));
        this.sessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else
      {
        this.afRoot.setBackgroundDrawable(this.sessionInfo.chatBg.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    label330:
    QLog.e("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND Error.. bErrMsg=" + paramString + ", afRoot=" + this.afRoot + ", sessionInfo=" + this.sessionInfo);
  }
  
  private void updateApolloPanel(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 21) || (paramInt2 == 21)) && (this.mApolloPanel != null)) {
      this.mApolloPanel.a(paramInt1, paramInt2, this.mApolloPanel);
    }
    amal localamal;
    if ((ambc.b(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin)) && (!ambc.a(this.app)))
    {
      localamal = ambc.a(this.app);
      if (paramInt1 != 21) {
        break label170;
      }
      if (localamal != null) {
        localamal.a(1);
      }
    }
    for (;;)
    {
      if (this.mApolloViewController != null)
      {
        paramInt2 = 0;
        paramInt1 = paramInt2;
        if (this.listView != null)
        {
          paramInt1 = paramInt2;
          if (this.mCustomTitleView != null)
          {
            paramInt1 = paramInt2;
            if (this.input != null) {
              paramInt1 = this.listView.getBottom() - this.listView.getPaddingBottom() - this.mCustomTitleView.getHeight() + this.input.getTop();
            }
          }
        }
        this.mApolloViewController.a(this.app, paramInt1);
      }
      return;
      label170:
      if ((paramInt2 == 21) && (localamal != null)) {
        localamal.a(2);
      }
    }
  }
  
  private void updateFakeInput(int paramInt)
  {
    if (this.mFakeInput != null)
    {
      if (paramInt < 1) {
        break label43;
      }
      this.mFakeInput.setVisibility(8);
    }
    for (;;)
    {
      if (this.mFakeUpInput != null)
      {
        if (paramInt < 1) {
          break;
        }
        this.mFakeUpInput.setVisibility(8);
      }
      return;
      label43:
      this.mFakeInput.setVisibility(0);
    }
    this.mFakeUpInput.setVisibility(0);
  }
  
  private void updateRichTextPanel(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 28)
    {
      this.mZhituSwitch = false;
      this.mIconButtonInInputRight.setActivated(false);
      if (this.mRichTextPanel != null) {
        this.mRichTextPanel.b(false);
      }
    }
    if (paramInt2 == 28)
    {
      this.mZhituSwitch = true;
      this.mIconButtonInInputRight.setActivated(true);
      if (this.mRichTextPanel != null) {
        this.mRichTextPanel.b(true);
      }
    }
  }
  
  private void updateSession_forwardType(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "updateSession_forwardType intent type" + paramIntent.getIntExtra("uintype", -1) + "needToBottom=" + paramBoolean);
    }
    if ((paramIntent.getExtras() != null) && (paramIntent.getExtras().containsKey("forward_type")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("forward", 2, "updateSession_forwardType from forward");
      }
      if ((paramIntent.getIntExtra("uintype", -1) == 1) && (((bfbz)this.app.getManager(48)).a(paramIntent.getStringExtra("uin"), true).jdField_a_of_type_Boolean)) {
        QQToast.a(this.app.getApp(), 2131696866, 0).b(getTitleBarHeight());
      }
    }
    else
    {
      return;
    }
    int i = paramIntent.getIntExtra("forward_type", 2147483647);
    this.isNeedDelayShowUnreaded = Boolean.valueOf(true);
    if (i == 0) {
      this.isBack2Root = true;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(this.tag, 1, "updateSession_forwardType, postDelayed!");
      }
      this.uiHandler.postDelayed(new BaseChatPie.12(this, paramBoolean, paramIntent, paramIntent), 500L);
      setLeftCheckBoxVisible(false, null, false);
      return;
      if ((i == 1001) || (i == -4)) {
        ForwardUtils.handleAppShareAction(this.app, this.mContext, this.sessionInfo, paramIntent);
      }
    }
  }
  
  private void updateSession_initIntentData(Intent paramIntent)
  {
    this.sessionInfo.curFriendUin = paramIntent.getStringExtra("uin");
    this.sessionInfo.curType = paramIntent.getIntExtra("uintype", -1);
    this.sessionInfo.isQimUserOnline = false;
    this.sessionInfo.isTimUserOnline = false;
    if (this.sessionInfo.curType == 0)
    {
      ahcd.a().a(this.app, this.sessionInfo);
      ahov.a().a(this.app, this.sessionInfo);
    }
    if (this.sessionInfo.curType == 1026)
    {
      this.sessionInfo.curType = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
      }
    }
    this.sessionInfo.phoneNum = paramIntent.getStringExtra("phonenum");
    this.sessionInfo.entrance = paramIntent.getIntExtra("entrance", 0);
    this.refreshMessageContext = new QQMessageFacade.RefreshMessageContext();
    this.refreshMessageContext.context = new aezq(this.sessionInfo.curFriendUin);
    this.sessionInfo.troopUin = paramIntent.getStringExtra("troop_uin");
    this.sessionInfo.contactUin = null;
    this.sessionInfo.realTroopUin = null;
    this.sessionInfo.addFriendSourceId = paramIntent.getIntExtra("add_friend_source_id", 3999);
    this.sessionInfo.topicId = paramIntent.getIntExtra("key_confess_topicid", 0);
    this.refreshMessageContext.topicId = this.sessionInfo.topicId;
    this.mEnterExtPanel = paramIntent.getIntExtra("enter_ext_panel", 0);
    this.mExtPanelOnResumeTimes = paramIntent.getIntExtra("ext_panel_onresume", 1);
    this.isBack2Root = paramIntent.getBooleanExtra("isBack2Root", false);
    this.mIsFromVoiceChangerGuide = paramIntent.getBooleanExtra("open_chat_from_voice_changer_guide", false);
    if (!this.mIsFromVoiceChangerGuide)
    {
      bool1 = true;
      this.mHasGuideVoiceChangerDone = bool1;
      if (paramIntent.getLongExtra("res_share_id", -1L) != -1L) {
        this.isOpenFromShare = paramIntent.getExtras().containsKey("res_share_id");
      }
      if (!this.isOpenFromShare) {
        this.isOpenFromShare = paramIntent.getBooleanExtra("is_share_flag", false);
      }
      if ("qzoneShareTopic".equals(paramIntent.getStringExtra("share_qq_ext_str"))) {
        this.isOpenFromShare = false;
      }
      this.isOpenFromThirdParty = paramIntent.getBooleanExtra("thridparty_pull_aio", false);
      this.isFromManageStranger = paramIntent.getBooleanExtra("is_from_manage_stranger", false);
      boolean bool2 = paramIntent.getBooleanExtra("need_jump_to_msg", false);
      if (paramIntent.getIntExtra("aio_msg_source", 999) != 1) {
        break label510;
      }
      bool1 = true;
      label439:
      this.isFromSeachResult = bool1;
      if ((this.isFromSeachResult) || (bool2))
      {
        this.timeOrSeq = paramIntent.getLongExtra("searched_timeorseq", -1L);
        if (this.timeOrSeq <= -1L) {
          break label515;
        }
      }
    }
    label515:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.loadSearchedMessage = bool1;
      AIOUtils.isUserOperatedInAIO = false;
      this.sendCloseSearchBroadCast = false;
      this.helperProvider.a(1);
      return;
      bool1 = false;
      break;
      label510:
      bool1 = false;
      break label439;
    }
  }
  
  private void updateSession_otherThings(Intent paramIntent)
  {
    if (this.recorder != null) {
      this.recorder.a(null);
    }
    long l = paramIntent.getLongExtra("res_share_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "updateSession_otherThings appShareId=" + l);
    }
    if (l > 0L) {
      this.uiHandler.postDelayed(new BaseChatPie.13(this, paramIntent), 20L);
    }
    this.helperProvider.a(3);
    if (paramIntent.getIntExtra("entrance", 0) == 9)
    {
      this.isJubaoMode = true;
      setRightBtnToFinish();
      return;
    }
    this.isJubaoMode = false;
  }
  
  private void updateSession_updateInput(Intent paramIntent)
  {
    setInputStat(0);
    ((afqj)this.helperProvider.a(24)).b();
    this.sessionInfo.textSizeForTextItem = ChatTextSizeSettingActivity.a(this.mContext);
    this.input.setTextSize(0, this.sessionInfo.textSizeForTextItem);
    String str = paramIntent.getStringExtra("input_text");
    paramIntent.removeExtra("input_text");
    if (str != null) {
      this.input.setText(str);
    }
    while (baqh.a(this, this.mActivity.getIntent())) {
      return;
    }
    loadTextDraft();
  }
  
  private void updateShiledStatusAsync(boolean paramBoolean, String paramString)
  {
    ThreadManager.post(new BaseChatPie.10(this, paramString, paramBoolean), 8, null, true);
  }
  
  private void updateTipsBar()
  {
    int i = this.root.a();
    int j = this.mBlueTipsTaskList.size();
    if (i != 0)
    {
      i = this.mTipsMgr.a();
      if ((i == 5) || (i == 6)) {
        this.mTipsMgr.a();
      }
    }
    while ((j == 0) || (this.mOperateTips == null) || (isFullScreenMode())) {
      return;
    }
    QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)this.mBlueTipsTaskList.get(j - 1);
    this.mOperateTips.a(localQQOperationViopTipTask);
  }
  
  private void updateZanInfo(Message paramMessage)
  {
    Object localObject = (Map)paramMessage.obj;
    int i = this.listAdapter.a((ChatMessage)((Map)localObject).get("chatMessage"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "updateZanInfo pos is:" + i);
    }
    if (i < 0) {}
    do
    {
      do
      {
        do
        {
          int j;
          int k;
          int m;
          int n;
          do
          {
            return;
            j = this.listView.getFirstVisiblePosition();
            k = this.listView.getHeaderViewsCount();
            m = this.listView.getLastVisiblePosition();
            n = this.listView.getHeaderViewsCount();
          } while ((i < j - k) || (i > m - n));
          paramMessage = this.listView.getChildAt(i - this.listView.getFirstVisiblePosition());
        } while ((paramMessage == null) || (!(paramMessage instanceof LinearLayout)));
        localObject = (bamu)((Map)localObject).get("sigZanInfo");
      } while (!(AIOUtils.getHolder(paramMessage) instanceof agmy));
      paramMessage = (agmy)AIOUtils.getHolder(paramMessage);
    } while ((((bamu)localObject).jdField_a_of_type_JavaLangString == null) || (!((bamu)localObject).jdField_a_of_type_JavaLangString.equals(paramMessage.a.b)));
    paramMessage.a.d = ((bamu)localObject).b;
    paramMessage.a.f = ((bamu)localObject).jdField_c_of_type_Int;
    paramMessage.a.j();
  }
  
  public void addApolloBackgroundSurfaceView()
  {
    checkInitApolloViewController();
    this.mApolloViewController.c(this);
  }
  
  protected void addBusinessObservers()
  {
    this.app.addObserver(this.cardObserver);
    this.app.addObserver(this.friendListObserver);
    this.app.addObserver(this.configObserver);
    this.app.setCheckPttListener(this);
    this.app.setCheckPtvListener(this);
    this.app.getFileManagerNotifyCenter().addObserver(this.fmob);
    this.app.getMessageFacade().addObserver(this);
    this.app.getAVNotifyCenter().addObserver(this.mGAudioObserver);
    this.app.addObserver(this.emoticonObserver);
    this.app.addObserver(this.cmShowActionObserver);
    this.app.addObserver(this.mApolloViewObserver);
    this.app.addObserver(this.mShortVideoObserver);
    this.mHiBoomAuthObserver = new aues(getActivity());
    this.app.addObserver(this.mHiBoomAuthObserver);
    this.mHiBoomForwardAuthObserver = new auet(getActivity());
    this.app.addObserver(this.mHiBoomForwardAuthObserver);
    this.mFontBubbleObserver = new audx(this);
    this.app.addObserver(this.mFontBubbleObserver);
  }
  
  public void addStickerExpandView()
  {
    int j;
    Object localObject;
    if (this.listView != null) {
      if (this.listView.getChildCount() > 0)
      {
        j = this.listView.getFirstVisiblePosition();
        localObject = this.listView.getChildAt(0);
        if (localObject != null) {
          break label150;
        }
      }
    }
    label150:
    for (int i = 0;; i = ((View)localObject).getTop())
    {
      this.listView.setSelectionFromTop(j, i);
      if (this.expandStickerView == null)
      {
        this.expandStickerView = new View(this.mContext);
        this.expandStickerView.setId(2131374021);
        localObject = new AbsListView.LayoutParams(-1, 80);
        this.expandStickerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.expandStickerView.getParent() == null)
      {
        this.listView.setAdapter(null);
        this.listView.addFooterView(this.expandStickerView, null, false);
        this.listView.setAdapter(this.listAdapter);
        refresh(196608);
      }
      return;
    }
  }
  
  public void adjustInputLayout(int paramInt)
  {
    paramInt = Math.max(paramInt, 0);
    Object localObject = (LinearLayout)this.mAIORootView.findViewById(2131367353);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    if (paramInt != localLayoutParams.bottomMargin)
    {
      localLayoutParams.bottomMargin = paramInt;
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      ((afss)getHelper(29)).d();
    }
    if (this.mIconLayoutInInputRight != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.mIconLayoutInInputRight.getLayoutParams();
      paramInt = this.mInputBar.getPaddingBottom() + paramInt;
      if (paramInt != ((RelativeLayout.LayoutParams)localObject).bottomMargin)
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
        this.mIconLayoutInInputRight.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void adjustTitleDimension()
  {
    this.mCustomTitleView.b();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (((afqj)this.helperProvider.a(24)).a(paramEditable)) {
      return;
    }
    afsd localafsd = (afsd)getHelper(27);
    if (localafsd != null) {
      localafsd.a(paramEditable);
    }
    handleTextChangedReal(paramEditable);
  }
  
  public void backToQzoneUserHomeActivity()
  {
    Intent localIntent = this.mActivity.getIntent();
    String str = localIntent.getStringExtra("key_nearby_qzone_to_aio");
    if ((str != null) && (str.equals("nearby_qzone_to_aio")))
    {
      str = localIntent.getStringExtra("uin");
      localIntent.putExtra("key_has_talk", amuu.a(this.app, str));
      this.mActivity.setResult(-1, localIntent);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      bevq[] arrayOfbevq = (bevq[])this.input.getEditableText().getSpans(paramInt1, paramInt1 + paramInt2, bevq.class);
      if ((arrayOfbevq != null) && (arrayOfbevq.length > 0)) {
        bcef.b(null, "dc00898", "", "", "0X800A9AC", "0X800A9AC", 0, 0, "", "", "", "");
      }
    }
    ((afst)getHelper(41)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ((afqj)this.helperProvider.a(24)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void cacheSendShakeMsg(MessageForShakeWindow paramMessageForShakeWindow)
  {
    ((afpo)this.helperProvider.a(65)).a(paramMessageForShakeWindow);
  }
  
  public void cancelRemainScreenOn()
  {
    if ((this.mScreenWakeLoack != null) && (this.mScreenWakeLoack.isHeld()))
    {
      this.mScreenWakeLoack.release();
      this.mScreenWakeLoack = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "cancelRemainScreenOn");
    }
  }
  
  public void cancelSendPtt(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 2) {
      if (paramInt != 1) {
        break label39;
      }
    }
    label39:
    for (bool1 = bool2;; bool1 = false)
    {
      cancelSendPttInner(paramString, this.recordingUniseq, bool1, paramRecorderParam);
      reportCancelPttEvent(paramInt);
      return;
    }
  }
  
  protected void checkOrUpdatePttRecord(int paramInt, String paramString, long paramLong)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
    case 0: 
      do
      {
        return;
      } while ((paramString == null) || (paramLong == 0L));
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "disPlayAudioRecord updatePttRecordMessage: " + paramString);
      }
      acvv.a(this.app, this.sessionInfo, paramString, -3, paramLong);
      instantUpdate(true, true);
      return;
    }
    if (paramString != null)
    {
      paramString = bcgn.a(paramString);
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
    }
    if (!this.uiHandler.hasMessages(16711688)) {
      this.uiHandler.sendEmptyMessageDelayed(16711688, 1000L);
    }
    if (paramLong != 0L)
    {
      paramInt = this.sessionInfo.curType;
      paramString = this.sessionInfo.curFriendUin;
      this.app.getMessageFacade().removeMsgByUniseq(paramString, paramInt, paramLong);
    }
    instantUpdate(true, false);
  }
  
  public void clearInput()
  {
    this.input.setText("");
    this.input.setCompoundDrawables(null, null, null, null);
    this.input.setTag(2131373788, null);
    this.input.setSelection(0);
    this.mSourceMsgInfo = null;
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.panelManager.a(4);
    if (localPhotoListPanel != null) {
      localPhotoListPanel.a(false);
    }
    if (getCurrentPanel() == 28) {
      hideAllPanels();
    }
    ((afqj)this.helperProvider.a(24)).d();
  }
  
  public void clickSendTextButton()
  {
    acwc localacwc = null;
    if (isFullScreenMode()) {
      hideFullScreenInput(false);
    }
    if (this.sessionInfo.debugFilterMemberMsgCommand)
    {
      BaseChatpieHelper.a(this.sessionInfo, this.input, this.mFunBtn, true);
      this.dirty = 131075;
      refresh(this.dirty);
      return;
    }
    afqj localafqj = (afqj)this.helperProvider.a(24);
    aucg.a();
    Object localObject1 = (PhotoListPanel)this.panelManager.a(4);
    int i;
    label95:
    int j;
    label104:
    MixedMsgInfo localMixedMsgInfo;
    if (localObject1 != null)
    {
      i = ((PhotoListPanel)localObject1).b();
      if (localObject1 == null) {
        break label311;
      }
      j = ((PhotoListPanel)localObject1).c();
      if ((localafqj.b()) && (this.input.getText().length() <= 0) && (i + j <= 0)) {
        break label314;
      }
      localMixedMsgInfo = localafqj.a();
      if (localMixedMsgInfo != null) {
        break label316;
      }
      localObject1 = "";
      label149:
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        break label325;
      }
    }
    label311:
    label314:
    label316:
    label325:
    for (Object localObject3 = this.input.getText().toString();; localObject3 = localObject1)
    {
      LogcatUtil.a((String)localObject3);
      if (this.input.getTag(2131373788) == null) {
        this.mSourceMsgInfo = null;
      }
      localObject2 = localacwc;
      if (this.mSourceMsgInfo != null)
      {
        localObject2 = localacwc;
        if (!android.text.TextUtils.isEmpty(this.mSourceMsgInfo.mSourceMsgTroopName)) {
          localObject2 = ((azye)this.app.getManager(340)).b(this.mSourceMsgInfo.getUniSeq());
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.mSourceMsgInfo != null) {
          localObject1 = ahln.c(this.app, this.sessionInfo, this.mSourceMsgInfo);
        }
      }
      aydq.a((String)localObject3);
      if (((String)localObject3).length() <= inputMaxLength) {
        break label331;
      }
      ChatActivityUtils.a(this.mContext, 2131718135, 1);
      return;
      i = 0;
      break label95;
      j = 0;
      break label104;
      break;
      localObject1 = localMixedMsgInfo.b();
      break label149;
    }
    label331:
    localacwc = new acwc();
    setSendTextMsgParams(localacwc);
    audg.a(this).jdField_a_of_type_Boolean = false;
    localacwc.i = this.isSendToRobotServer;
    this.isSendToRobotServer = false;
    Object localObject2 = (afsd)getHelper(27);
    if (localObject2 != null) {
      ((afsd)localObject2).a((String)localObject3, localacwc, 0);
    }
    if ((this.sessionInfo.curType == 1) || (this.sessionInfo.curType == 3000))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
      }
      localObject2 = getSourceMsgForNonAnonymous((MessageRecord)localObject1);
    }
    for (localObject1 = clickSendTextButtonForTroop(localafqj, i, j, localMixedMsgInfo, (MessageRecord)localObject2, localacwc);; localObject1 = localObject3)
    {
      reportClassicAndSmallEmoticon((String)localObject1, false, this.mEmoPanel, this.app);
      clearInput();
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
      }
      msgReport(this.sessionInfo.entrance, -1);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport end currenttime:" + System.currentTimeMillis());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send end currenttime:" + System.currentTimeMillis());
      }
      this.mTipsMgr.a(1002, new Object[] { localObject1 });
      if (this.app.getApplication().getResources().getConfiguration().orientation == 2) {
        bcef.b(this.app, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
      }
      agmk.a(this.app, (MessageRecord)localObject2, "0X800A369");
      ((afqy)getHelper(39)).a();
      return;
      localObject3 = clickSendTextButtonForC2C(localafqj, i, j, localMixedMsgInfo, (MessageRecord)localObject1, localacwc);
      localObject2 = localObject1;
    }
  }
  
  public void createAtMsg(boolean paramBoolean)
  {
    int i = 0;
    if ((this.sessionInfo.curType != 1) && (this.sessionInfo.curType != 3000)) {
      break label26;
    }
    label26:
    while ((this.mSourceMsgInfo == null) || (!android.text.TextUtils.isEmpty(this.mSourceMsgInfo.mAnonymousNickName))) {
      return;
    }
    boolean bool1;
    label74:
    Object localObject;
    QQAppInterface localQQAppInterface;
    Context localContext;
    String str1;
    String str2;
    XEditTextEx localXEditTextEx;
    if (((HotChatManager)this.app.getManager(60)).a(this.sessionInfo.curFriendUin) != null)
    {
      bool1 = true;
      localObject = ContactUtils.getMemberDisplaynameByIstroop(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin, this.mSourceMsgInfo.mSourceMsgSenderUin + "");
      localQQAppInterface = this.app;
      localContext = this.mContext;
      str1 = this.sessionInfo.curFriendUin;
      str2 = this.mSourceMsgInfo.mSourceMsgSenderUin + "";
      localXEditTextEx = this.input;
      if (this.sessionInfo.curType != 1) {
        break label252;
      }
    }
    label252:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject = bevq.a(localQQAppInterface, localContext, str1, str2, (String)localObject, bool1, localXEditTextEx, bool2, true);
      if ((localObject == null) || (((SpannableString)localObject).length() <= 0)) {
        break;
      }
      if (!paramBoolean) {
        break label258;
      }
      this.input.getEditableText().insert(0, (CharSequence)localObject);
      return;
      bool1 = false;
      break label74;
    }
    label258:
    if (this.input.getSelectionStart() < 0) {}
    for (;;)
    {
      this.input.getEditableText().insert(i, (CharSequence)localObject);
      return;
      i = this.input.getSelectionStart();
    }
  }
  
  public afnn createChatDrawer()
  {
    return null;
  }
  
  public EntryModel createMiniAppEntryModel()
  {
    return new EntryModel(-1, 0L, "", false);
  }
  
  public void createQQMapActivityProxy()
  {
    if (this.mQQMapActivityProxy == null) {
      this.mQQMapActivityProxy = new amzb(this.app.getAccount());
    }
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.input);
  }
  
  public void disableZhitu()
  {
    if ((this.mIconLayoutInInputRight != null) && (this.mZhituSwitch))
    {
      ahtj.a(this.app).c();
      this.mIconButtonInInputRight.setImageResource(2130838103);
      this.mIconButtonInInputRight.setActivated(false);
      this.mZhituSwitch = false;
    }
  }
  
  public void dismissPttMaskDialog()
  {
    if ((this.pttMaskDialog != null) && (this.pttMaskDialog.isShowing()) && (this.pttMaskDialog.getWindow() != null)) {}
    try
    {
      this.pttMaskDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.tag, 1, "dismissPttMaskDialog", localException);
    }
  }
  
  @TargetApi(11)
  protected void doDisableInputStat()
  {
    if (isFullScreenMode()) {
      hideFullScreenInput(false);
    }
    if (this.app.getMessageFacade().getCurrChatUin() == null) {}
    do
    {
      bfcf localbfcf;
      do
      {
        return;
        localbfcf = ((bfbz)this.app.getManager(48)).a(this.sessionInfo.curFriendUin, true);
      } while (this.input == null);
      Object localObject = (afqj)this.helperProvider.a(24);
      ((afqj)localObject).jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      if (this.mGagInputBtn == null)
      {
        TextView localTextView = new TextView(this.mContext);
        localTextView.setId(2131367364);
        localTextView.setBackgroundResource(2130849760);
        localTextView.setTextSize(1, 17.0F);
        localTextView.setTextColor(this.mContext.getResources().getColor(2131166991));
        localTextView.setEnabled(false);
        localTextView.setGravity(17);
        int i = ((ViewGroup)((afqj)localObject).jdField_a_of_type_AndroidViewView.getParent()).indexOfChild(((afqj)localObject).jdField_a_of_type_AndroidViewView);
        localObject = new LinearLayout.LayoutParams(this.input.getWidth(), -2);
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(14.0F, getActivity().getResources());
        ((LinearLayout.LayoutParams)localObject).gravity = 80;
        this.mInputBar.addView(localTextView, i, (ViewGroup.LayoutParams)localObject);
        this.mGagInputBtn = localTextView;
      }
      if (localbfcf != null)
      {
        if (this.mGagInputBtn != null)
        {
          QLog.d(this.tag, 1, "fightgag.doDisableInputStat text" + localbfcf.b);
          this.mGagInputBtn.setText(localbfcf.b);
        }
        if (this.root.a() == 2) {
          this.root.a();
        }
      }
      if (this.mGagInputBtn != null) {
        this.mGagInputBtn.setVisibility(0);
      }
      if (this.mPttBtn != null) {
        this.mPttBtn.setVisibility(8);
      }
      this.input.setVisibility(8);
      this.panelicons.setAllEnable(false);
      this.input.setEnabled(false);
      setFunBtnEnabled(false);
      shouldHideLightVideoBtn(3);
      if (VersionUtils.isHoneycomb())
      {
        if (!ThemeUtil.isInNightMode(this.app)) {
          this.panelicons.setChildAlpha(8, 0.6F);
        }
        this.input.setAlpha(0.6F);
        this.mFunBtn.setAlpha(0.6F);
      }
      this.mInputStat = 2;
      hideZhituIcon();
    } while (this.mApolloViewController == null);
    this.mApolloViewController.a(false);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "[doOnActivityResult], requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
    }
    boolean bool = false;
    updateAddFriendAndShieldView();
    int i;
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      i = paramIntent.getIntExtra("camera_type", 1);
      bool = paramIntent.getExtras().getBoolean("progress2View");
      if ((paramInt1 == 11000) && (i == 103)) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      doOnActivityResultDelegate(paramInt1, paramInt2, paramIntent, bool, i);
      return;
      continue;
      i = 1;
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "onConfigurationChanged");
    }
    hideSoftInput();
    if (paramConfiguration.orientation == 2) {
      bcef.b(this.app, "CliOper", "", "", "0X8005C7B", "0X8005C7B", 0, 0, "", "", "", "");
    }
    this.helperProvider.a(18);
    ArkAppCenterUtil.doOnConfigurationChanged(paramConfiguration);
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    this.createTime = NetConnInfoCenter.getServerTime();
    if (this.mAIORootView == null)
    {
      QLog.e(this.tag, 1, "mAIORootView == null");
      ChatFragment localChatFragment = this.mActivity.getChatFragment();
      if (localChatFragment != null) {
        this.mAIORootView = localChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      }
      if (this.mAIORootView == null)
      {
        QLog.e(this.tag, 1, "root view is still null");
        return false;
      }
    }
    this.mAIORootView.setVisibility(0);
    this.sessionInfo.reset();
    preStartBaseAIO();
    this.mCurrentAIOState = 2;
    AIOUtils.printColorLevelLog(this.tag, "doOnCreate", hashCode(), this.mCurrentAIOState);
    updateSession(this.mActivity.getIntent());
    bfzg.a("AIO_updateSession", "AIO_doOnCreate_otherCost");
    getAndParseAIOList();
    BaseActivity.sActivityRoute.add(getClass().getSimpleName());
    addBusinessObservers();
    this.app.setHandler(ChatActivity.class, this.uiHandler);
    bfzg.a("AIO_doOnCreate_otherCost", "AIO_doOnCreate_handleRequest");
    if (paramBoolean) {
      handleRequest(this.mActivity.getIntent(), 1);
    }
    for (;;)
    {
      this.chatPieHelper.a();
      bfzg.a("AIO_doOnCreate_handleRequest", null);
      return true;
      handleRequest(this.mActivity.getIntent(), 2);
    }
  }
  
  protected void doOnCreate_initData()
  {
    this.friendListHandler = ((FriendListHandler)this.app.getBusinessHandler(1));
    this.aioTipsController = new aewx(this.mTipsLayout);
    this.sessionInfo.chatBg = new aezp();
    if (this.fmob == null) {
      this.fmob = new BaseChatPie.MyFMObserver(this, null);
    }
    if (this.mGAudioObserver == null) {
      this.mGAudioObserver = new BaseChatPie.MyAVObserver(this, null);
    }
    this.speakerPhoneOn = this.app.getLoudSpeakerState();
    this.mpm = MediaPlayerManager.a(this.app);
    this.needUpload = true;
    this.mTipsMgr = new ahqs(this.app, this.sessionInfo, this.aioTipsController, this.root, this.mBlueTipsTaskList);
    this.mPasswdRedBagManager = ((ajul)this.app.getManager(125));
  }
  
  protected void doOnCreate_initUI()
  {
    this.isThemeDefault = ThemeUtil.isDefaultOrDIYTheme(false);
    this.root = ((XPanelContainer)this.mAIORootView.findViewById(2131376679));
    this.mEmotionSearchPanel = ((EmotionSearchPanel)this.mAIORootView.findViewById(2131366037));
    this.panelManager.a(this.root);
    this.root.setOnPanelChangeListener(this);
    this.root.setOnChangeMultiScreenListener(this);
    this.root.setReadyToShowChangeListener(new BaseChatPie.3(this));
    this.root.jdField_c_of_type_Boolean = true;
    this.root.setReadyToShow(false);
    this.afRoot = ((ViewGroup)this.mAIORootView.findViewById(2131362294));
    agkc.a().a((FitSystemWindowsRelativeLayout)this.afRoot);
    this.mContent = ((RelativeLayout)this.mAIORootView.findViewById(2131364407));
    this.mTipRoot = this.mAIORootView.findViewById(2131374032);
    this.mTipsContainer = ((RelativeLayout)this.mAIORootView.findViewById(2131364504));
    this.mTipsLayout = ((RelativeLayout)this.mAIORootView.findViewById(2131374037));
    this.mCustomTitleView = ((NavBarAIO)this.mAIORootView.findViewById(2131376501));
    this.titleBgView = ((ImageView)this.mAIORootView.findViewById(2131376502));
    this.mTitleLayout = ((ViewGroup)this.mAIORootView.findViewById(2131378762));
    this.mSubTitleLayout = ((ViewGroup)this.mAIORootView.findViewById(2131377934));
    this.mTitleBtnLeft = ((TextView)this.mAIORootView.findViewById(2131369068));
    this.mTitleBubbleLeft = ((TextView)this.mAIORootView.findViewById(2131369106));
    this.mDefaultLeftBack = ((ImageView)this.mAIORootView.findViewById(2131369436));
    this.mDefautlBtnLeft = ((TextView)this.mAIORootView.findViewById(2131379417));
    this.mTitleBtnRightLayout = ((RelativeLayout)this.mAIORootView.findViewById(2131369124));
    this.mTitleBtnRight = ((ImageView)this.mAIORootView.findViewById(2131369082));
    this.mTitleBtnRightSearch = ((FrameLayout)this.mAIORootView.findViewById(2131369097));
    this.freeTalkImg = ((ImageView)this.mAIORootView.findViewById(2131376186));
    this.mRightButtonRedDot = ((ImageView)this.mAIORootView.findViewById(2131376187));
    this.mRightButtonRedDot.setVisibility(8);
    this.mTitleBtnCall = ((ImageView)this.mAIORootView.findViewById(2131369077));
    this.mTitleBtnCall.setContentDescription(this.app.getApp().getString(2131694890));
    this.mTitleBtnLeft.setOnClickListener(this);
    this.mTitleBtnRight.setOnClickListener(this);
    this.mDefaultLeftBack.setOnClickListener(this);
    this.mDefautlBtnLeft.setOnClickListener(this);
    this.mAIORootView.findViewById(2131369874).setOnClickListener(this);
    this.mCustomTitleView.setOnClickListener(this);
    this.mTitleBtnRight.setContentDescription(this.app.getApp().getString(2131690706));
    this.mTitleText = ((TextView)this.mAIORootView.findViewById(2131378707));
    this.mTitleCount = ((TextView)this.mAIORootView.findViewById(2131365635));
    this.mTitleIcon = ((ImageView)this.mAIORootView.findViewById(2131378752));
    this.mTitleIcon2 = ((ImageView)this.mAIORootView.findViewById(2131378753));
    this.mTitleIconRight = ((ImageView)this.mAIORootView.findViewById(2131378754));
    this.mViewFlipper = ((QqViewFlipper)this.mAIORootView.findViewById(2131378797));
    this.mViewFlipper.setMeasureAllChildren(false);
    this.mSubTilteText = ((TextView)this.mAIORootView.findViewById(2131378795));
    this.mSubTitleText2 = ((TextView)this.mAIORootView.findViewById(2131378796));
    this.addView = ((ViewStub)this.mAIORootView.findViewById(2131373882));
    this.mSubTitleLeftImageView = ((ImageView)this.mAIORootView.findViewById(2131365805));
    this.listView = ((ChatXListView)this.mAIORootView.findViewById(2131370017));
    this.listView.setChatPie(this);
    this.listView.setActTAG("actFPSAIO");
    this.listView.setStackFromBottom(true);
    this.listView.setOnTouchListener(this);
    this.listView.setOnScrollListener(this);
    this.listView.setOnScrollToButtomListener(this);
    this.listView.setOverScrollListener(this);
    this.listView.setTranscriptMode(0);
    this.listView.setLongClickable(true);
    this.listView.setDelAnimationDuration(300L);
    this.listView.setShowPanelListener(this);
    this.listView.setRecyclerListener(this);
    this.listView.setChoiceMode(2);
    this.listView.a();
    this.mGestureDetector = new GestureDetector(this.mContext, new BaseChatPie.MyOnGestureListener(this));
    this.mAnimContainer = ((AIOAnimationConatiner)this.mAIORootView.findViewById(2131362701));
    this.mAnimContainer.a(this.listView);
    this.mAnimContainer.a = this.mApolloViewObserver;
    this.businessFooterDetector = new afdm(this.mContext, this.listView, this);
    this.listAdapter = new aezn(this.app, this.mActivity, this.sessionInfo, this.mAnimContainer, this);
    ((akya)getHelper(4)).b();
    if (this.headView == null)
    {
      this.headView = new View(this.mContext);
      int i = this.mContext.getResources().getDimensionPixelSize(2131299076);
      this.headView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      this.headView.setId(2131362430);
      this.listView.addHeaderView(this.headView, null, false);
      this.listView.setOverscrollHeaderTop(i);
    }
    this.listView.setAdapter(this.listAdapter);
    this.listAdapter.a(this.listView);
    this.mScrollerRunnable = new ScrollerRunnable(this.listView);
    this.mScrollerdownRunnable = new MoveToBottomScroller(this.listView, this.businessFooterDetector);
    this.mBottomBlurView = ((QQBlurView)this.mAIORootView.findViewById(2131380315));
    this.panelicons = ((PanelIconLinearLayout)this.mAIORootView.findViewById(2131372228));
    this.panelicons.setPanelIconListener(this);
    this.panelicons.setHelperProvider(this.helperProvider);
    this.input = ((XEditTextEx)this.mAIORootView.findViewById(2131368750));
    this.input.a = this.mSCCallbak;
    this.input.removeTextChangedListener(this);
    try
    {
      this.input.setEditableFactory(QQTextBuilder.EMOTION_INPUT_FACTORY);
      this.input.addTextChangedListener(this);
      this.input.setOnClickListener(this);
      this.input.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
      this.imeListener = new afih(this);
      this.input.setOnPrivateIMECommandListener(this.imeListener);
      abem.a(this.app.getApp(), this.input);
      ((afqj)this.helperProvider.a(24)).a(this.mAIORootView);
      this.root.a(this.input);
      this.mVideoBtn = ((RelativeLayout)this.mAIORootView.findViewById(2131380488));
      bnbb.a(this.mAIORootView, true);
      this.helperProvider.a(0);
      this.mFunBtn = ((PatchedButton)this.mAIORootView.findViewById(2131367352));
      this.mFunBtn.setText(amtj.a(2131700117));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.mFunBtn.setContentDescription(amtj.a(2131700108));
      }
      this.mFunBtn.setOnClickListener(this);
      this.mFunBtn.setOnLongClickListener(new BaseChatPie.4(this));
      this.mInputBar = ((InputLinearLayout)this.mAIORootView.findViewById(2131368751));
      this.mIconLayoutInInputRight = this.mAIORootView.findViewById(2131362379);
      this.mIconButtonInInputRight = ((ImageButton)this.mAIORootView.findViewById(2131362378));
      this.mIconButtonInInputRight.setOnTouchListener(this);
      bfpm.a(this.mIconButtonInInputRight, new BaseChatPie.5(this));
      this.mIconButtonInInputRight.setImageResource(2130838103);
      this.mZhituSwitch = false;
      initFakeInputView();
      initUPFakeInputView();
      if (this.mArkController == null) {
        this.mArkController = new aowj(this);
      }
      this.titleBgView.setVisibility(8);
      initInput();
      initBottomBlurView();
      if (Build.VERSION.SDK_INT >= 16)
      {
        ViewGroup localViewGroup = (ViewGroup)this.mAIORootView.findViewById(2131372918);
        bfsu.a(this.app, localViewGroup, getActivity(), getSessionInfo());
      }
      if ((this.mAIORootView.getParent() instanceof DrawerFrame))
      {
        this.mDrawerFrame = ((DrawerFrame)this.mAIORootView.getParent());
        this.mDrawerFrame.a();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.tag, 1, "input set error", localException);
      }
      this.mDrawerFrame = new DrawerFrame(this.mContext, this.mAIORootView);
    }
  }
  
  @TargetApi(11)
  public void doOnDestroy()
  {
    preloaded = false;
    if (this.hasDestory) {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "doOnDestroy return");
      }
    }
    do
    {
      return;
      this.hasDestory = true;
      URLDrawable.resume();
      this.mCurrentAIOState = 9;
      AIOUtils.printColorLevelLog(this.tag, "doOnDestroy", hashCode(), this.mCurrentAIOState);
      this.refreshBottomCount = 0;
      this.mReadedCnt = 0;
      destroyApollo();
      destroyListView();
      destroyInput();
      hideAddFriendAndShield();
      if (this.mTipsMgr != null) {
        this.mTipsMgr.b();
      }
      removeBusinessObservers();
      this.app.removeHandler(getClass());
      this.sessionInfo.mLastReadMsgId = -1L;
      destroyPtt();
      destroyScrollerRunnable();
      destroyArk();
      Object localObject = (avsq)this.app.getManager(14);
      ((avsq)localObject).b();
      ((avsq)localObject).c();
      EmojiStickerManager.a().a(this, this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.onShowDone);
      onPanelDestroy();
      agkg.a();
      agkg.b();
      agkc.a().a(3);
      agkc.a().a(6);
      agkc.a().a(12);
      agkc.a().a(15);
      agkc.a().a(18);
      agkc.a().a(9);
      if (this.mHotPicMainPanel != null)
      {
        localObject = augn.a(this.app);
        if (localObject != null) {
          ((augn)localObject).a(false);
        }
      }
      this.uiHandler.removeCallbacksAndMessages(null);
      this.uiHandler.removeCallbacks(this.mRunOnShow);
      destroyDialog();
      this.app.removeHandler(ChatActivity.class);
      if (this.mAnimContainer != null) {
        this.mAnimContainer.b();
      }
      ChatActivityUtils.b();
      acvv.a();
      unbindDrawables();
      this.isNeedDelayShowUnreaded = Boolean.valueOf(true);
      if (this.mUnReadTxt != null) {
        this.mUnReadTxt.setVisibility(8);
      }
      this.chatPieHelper.b();
      destroyFile();
      if (AITranslator.a()) {
        AITranslator.a().a(this.mContext, true);
      }
      this.mIsMsgSignaling = false;
      this.mMsgSignalSum = 60;
      this.mMsgSignalCount = 0;
      this.mMsgSignalNetType = 0;
      ThreadManager.getSubThreadHandler().removeCallbacks(this.msgSignalRunnable);
      afdp.a().a();
      znt.a().a();
      refreshDelayForNextPie = true;
      if (this.mIdleHanlder != null) {
        Looper.myQueue().removeIdleHandler(this.mIdleHanlder);
      }
      bfwz.a();
      this.app.getPicPreDownloader().c();
      azca.a();
      agmx.jdField_a_of_type_Long = 0L;
      if (isVivoShot == 1) {
        setVivoSetting(0);
      }
      ChatActivityUtils.a();
      bfta.a(false);
      this.mStructingMsgItemViewCache.a();
      nrz.a().c();
      this.app.getMsgCache().jdField_a_of_type_JavaUtilHashMap.clear();
      destroyUnRegReceivers();
      BaseActivity.sActivityRoute.remove(getClass().getSimpleName());
      localObject = (beyh)this.app.getManager(223);
      if (localObject != null) {
        ((beyh)localObject).c();
      }
      bfth.a().a();
      cancelRemainScreenOn();
      aqwg.a(this.mContent, this.app);
      if (this.mComboUIManager != null)
      {
        this.mComboUIManager.a();
        this.mComboUIManager = null;
      }
      HotPicPageView.c();
      auij.a(this.app);
      ahcd.a().a(false);
      destroyReceipt();
      CustomizeStrategyFactory.a().a(false);
      this.helperProvider.a(13);
      ahtj.a(this.app).c();
      hideZhituIcon();
      if (this.mTitleBtnRight != null) {
        this.mTitleBtnRight.setOnClickListener(null);
      }
      aucg.b();
      this.playMode = 0;
      this.mStickerBubbleQuickButtonReported = false;
      this.mZhituButtonExposeReported = false;
      bgae.a();
      this.mFirstVisibleView = null;
      this.mLastVisibleView = null;
      this.mFirstVisibleItem = 0;
      this.mLastVisibleItem = 0;
      if ((enableBlur()) && (this.mBottomBlurView != null)) {
        this.mBottomBlurView.c();
      }
      if (this.mChatDrawer != null)
      {
        this.mChatDrawer.e();
        this.mChatDrawer = null;
      }
    } while (!(this.mSubTilteText instanceof OnlineStatusLyricView));
    ((OnlineStatusLyricView)this.mSubTilteText).d();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "doOnNewIntent");
    }
    if (this.root != null) {
      this.root.a();
    }
    this.mCurrentAIOState = 1;
    this.hasDestory = false;
    doOnNewIntent_updateUI(paramIntent);
    doOnNewIntent_updateData(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "AIOTime doOnNewIntent end");
    }
  }
  
  public void doOnNewIntent_clearBusinessData()
  {
    bfwz.a();
    this.helperProvider.a(20);
    AIOUtils.setIsNotLoadSuit(false);
    this.isPauseRefresh = false;
    this.hasSetReaded = false;
    this.isBack2Root = false;
    this.speakerPhoneOn = true;
    this.canPullRefresh = true;
    this.mEffectPullRefreshCount = 0;
    this.isOpenFromShare = false;
    this.isOpenFromThirdParty = false;
    this.isHaveNewAfterIn = false;
    this.hasUnread = false;
    this.isFromManageStranger = false;
    this.isBeingInputDraft = false;
    this.needUpload = false;
    this.hasSentRecvMsg = false;
    this.mCacnelSellPttPanle = false;
    this.mIsFirtShowShareMsg = true;
    this.mIsFirstShowOpenIdMsg = true;
    this.mBubbleCacheMsgAborted = false;
    this.isVivoScrollToButtom = Boolean.valueOf(false);
    this.isOverScrollTarget = false;
    this.mIsCurrentSession = true;
    this.needShowAudioWhenResume = false;
    this.needInitTips = true;
    this.couldTrigerDismissPanel = true;
    this.mSingleTitle = true;
    this.showOnlineStatus = false;
    this.mTitleShowUnread = false;
    this.isSimpleBar = false;
    this.onShowDone = false;
    if (this.mTipsContainer != null)
    {
      this.mTipsContainer.removeAllViews();
      this.mMsgbox = null;
      this.mMsgboxline = null;
    }
    if (this.mTipsMgr != null) {
      this.mTipsMgr.a();
    }
    if ((this.linearLayout != null) && (this.mContent != null))
    {
      this.linearLayout.removeAllViews();
      this.mContent.removeView(this.linearLayout);
      this.linearLayout = null;
      this.shieldTV = null;
      this.addFriendTv = null;
    }
    if (this.speakerPhoneLayout != null)
    {
      this.speakerPhoneLayout.setVisibility(4);
      this.speakerPhoneLayout = null;
    }
    if ((this.emotionLayout != null) && (this.mContent != null))
    {
      this.mContent.removeView(this.emotionLayout);
      this.emotionLayout = null;
    }
    if (this.mEmoPanel != null)
    {
      this.mEmoPanel.onDestory();
      this.mEmoPanel = null;
    }
    if (this.root != null)
    {
      this.root.d();
      this.root.c();
    }
    this.timeOrSeq = 0L;
    this.loadSearchedMessage = false;
    this.needjumpToMsg = true;
    if ((this.doutuManager != null) && (this.doutuManager.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.mContent != null))
    {
      this.mContent.removeView(this.doutuManager.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.doutuManager.b();
    }
    hideGiftPanel();
  }
  
  protected void doOnNewIntent_updateBusinessData(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    boolean bool = paramIntent.getBooleanExtra("isNeedUpdate", false);
    this.mIsCurrentSession = false;
    if ((!this.mIsCurrentSession) || (localBundle.containsKey("forward_type"))) {
      updateSession(paramIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "updateSession_otherThings appShareId=" + localBundle.getLong("res_share_id", 0L));
      }
      return;
      if ((this.dirty != 0) || (bool)) {
        instantUpdate(true, false);
      } else if (localBundle.getLong("res_share_id", 0L) > 0L) {
        ForwardUtils.handleAppShareAction(this.app, this.mActivity, this.sessionInfo, paramIntent);
      }
    }
  }
  
  protected void doOnNewIntent_updateData(Intent paramIntent)
  {
    this.speakerPhoneOn = this.app.getLoudSpeakerState();
    if ((this.sessionInfo.curFriendUin == null) && (QLog.isColorLevel())) {
      QLog.d(this.tag, 2, "onNewIntent sessionInfo.curFriendUin is null and sessionInfo.curType " + this.sessionInfo.curType + " troopUin " + this.sessionInfo.troopUin + " sessionInfo.entrance " + this.sessionInfo.entrance);
    }
    doOnNewIntent_updateBusinessData(paramIntent);
    this.needUpload = true;
    handleRequest(paramIntent, 2);
  }
  
  public void doOnPause()
  {
    this.mCurrentAIOState = 5;
    AIOUtils.printColorLevelLog(this.tag, "doOnPause", hashCode(), this.mCurrentAIOState);
    this.app.getMessageFacade().pauseChatActivity();
    afvh.a(0);
    ArkFlashChatContainerWrapper.a(0);
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    ApngImage.pauseByTag(0);
    if (!isActivityResume()) {
      AbstractVideoImage.pauseAll();
    }
    agnv.a(this.listView);
    agnj.e();
    ShortVideoRealItemBuilder.e();
    ((afqg)getHelper(83)).b(true);
    ThreadManager.post(new BaseChatPie.23(this), 5, null, false);
    if (this.isHaveNewAfterIn) {
      acvv.a(this.app, this.sessionInfo);
    }
    this.uiHandler.removeMessages(16711689);
    this.uiHandler.removeCallbacks(this.mRetryShowInputPanelTask);
    if (this.mEmoPanel != null) {
      this.mEmoPanel.onPause();
    }
    if (this.listView != null) {
      this.listView.b();
    }
    if ((this.root.a() == 2) && (this.mAudioPanel != null)) {
      this.mAudioPanel.a();
    }
    if ((this.root.d()) && (this.mVoiceTextEditPanel != null)) {
      this.mVoiceTextEditPanel.b();
    }
    if (this.mAnimContainer != null) {
      this.mAnimContainer.b(0);
    }
    if (this.mMagicfaceViewController != null) {
      this.mMagicfaceViewController.h();
    }
    this.needUpload = false;
    if (this.mEntryFriendCard)
    {
      this.mpm.a(this.listView);
      this.mEntryFriendCard = false;
    }
    if (this.recorder != null) {
      this.recorder.a();
    }
    if (this.mGiftAnimationController != null) {
      this.mGiftAnimationController.c();
    }
    if (this.mHotPicMainPanel != null) {
      this.mHotPicMainPanel.e();
    }
    if (this.mApolloViewController != null) {
      this.mApolloViewController.e(this);
    }
    this.helperProvider.a(9);
    if (enableBlur()) {
      this.mBottomBlurView.b();
    }
    if (this.mChatDrawer != null) {
      this.mChatDrawer.d();
    }
  }
  
  protected void doOnRegReceivers()
  {
    try
    {
      if (this.mReceiverState == 0)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
        localIntentFilter.addAction("android.intent.action.PHONE_STATE");
        localIntentFilter.addAction("vivo_smart_shot_enter");
        localIntentFilter.addAction("com.huawei.hwmultidisplay.action.WINDOW_CAST_MODE");
        this.mContext.registerReceiver(this.mReceiver, localIntentFilter);
        this.mReceiverState = 1;
      }
      for (;;)
      {
        AppNetConnInfo.registerConnectionChangeReceiver(this.mContext, this);
        QLog.d(this.tag, 1, "AIOTime doOnRegReceivershashCode = " + Integer.toHexString(hashCode()));
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.tag, 2, "registerReceiver but done");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.tag, 2, "registerReceiver " + localException);
        }
      }
    }
  }
  
  public void doOnResume()
  {
    this.mCurrentAIOState = 4;
    AIOUtils.printColorLevelLog(this.tag, "doOnResume", hashCode(), this.mCurrentAIOState);
    doOnResume_updateUI();
    this.app.getMessageFacade().resumeChatActivity(this.sessionInfo.curFriendUin, this.sessionInfo.curType);
    if (this.isFromOnCreate)
    {
      AIOUtils.setIsNotLoadSuit(true);
      this.onShowDone = false;
      if (this.sessionInfo.curType == 1008) {
        bfwu.a(null, "pubAcc_structMsg_display", this.sessionInfo.curFriendUin);
      }
    }
    for (;;)
    {
      synchronized (QQMessageFacade.AIO_LOCK)
      {
        refreshListAdapter();
        setIsPauseRefresh(true);
        this.uiHandler.postDelayed(this.mRunOnShow, 800L);
        this.isFromOnCreate = false;
        if (DeviceProfileManager.b) {
          getMsgSignalDpcStat();
        }
        this.mEntryFriendCard = false;
        this.speakerPhoneOn = this.app.getLoudSpeakerState();
        this.mpm.a(this.listView, this.listAdapter, this);
        nrz.a().a(this.app, this.listView, this.sessionInfo);
        avnj.f = true;
        ThreadRegulator.a().a(1, 1500L);
        enableMosaicEffect(((AIOLongShotHelper)getHelper(15)).c());
        ((afss)getHelper(29)).a(getStatusTxtDartElseLight());
        return;
      }
      refresh(131072);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onShow right now");
      }
      onShow();
    }
  }
  
  protected void doOnResume_updateUI()
  {
    bfzg.a(null, "AIO_doOnResume_updateUI");
    ((afss)getHelper(29)).a(this.mTitleBtnLeft);
    afvh.a(1);
    ArkFlashChatContainerWrapper.a(1);
    loadBackgroundAsync();
    if (this.mEmoPanel != null) {
      this.mEmoPanel.onResume();
    }
    if ((this.root != null) && (this.root.a() == 2) && (this.mAudioPanel != null) && (this.mAudioPanel.getVisibility() == 0)) {
      this.recordCounts = 0;
    }
    if ((this.mFunBtn != null) && (this.input != null)) {
      if ((this.input.getText().length() <= 0) && (getPhotoListSelectCount() <= 0)) {
        break label312;
      }
    }
    label312:
    for (boolean bool = true;; bool = false)
    {
      setFunBtnEnabled(bool);
      bfzg.a("AIO_doOnResume_updateUI", null);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTipRoot.getLayoutParams();
      int j = (int)this.mActivity.getResources().getDimension(2131299076);
      int i = j;
      if (this.linearLayout != null)
      {
        i = j;
        if (this.linearLayout.getVisibility() == 0) {
          i = j + (int)this.mActivity.getResources().getDimension(2131297076);
        }
      }
      localLayoutParams.topMargin = i;
      this.mTipRoot.setLayoutParams(localLayoutParams);
      updateUI_titleBarForTheme();
      this.helperProvider.a(5);
      if (enableBlur())
      {
        this.mBottomBlurView.setDebugTag("AIO." + this.sessionInfo.curType + "." + MsfSdkUtils.getShortUin(this.sessionInfo.curFriendUin));
        this.mBottomBlurView.a();
      }
      if (this.mChatDrawer != null) {
        this.mChatDrawer.c();
      }
      return;
    }
  }
  
  public void doOnStart()
  {
    this.mCurrentAIOState = 3;
    AIOUtils.printColorLevelLog(this.tag, "doOnStart", hashCode(), this.mCurrentAIOState);
    this.helperProvider.a(4);
  }
  
  public void doOnStop()
  {
    this.mCurrentAIOState = 6;
    AIOUtils.printColorLevelLog(this.tag, "doOnStop", hashCode(), this.mCurrentAIOState);
    this.needUpload = false;
    if ((this.root != null) && (this.root.a() == 1)) {
      hideSoftInput();
    }
    saveChatInputDbIfNeed();
    if (this.input != null) {}
    for (Object localObject = this.input.getText();; localObject = null)
    {
      if ((this.input != null) && (!this.sessionInfo.debugFilterMemberMsgCommand)) {
        saveTextDraft(this.sessionInfo, this.mDraftManager, (Spanned)localObject, this.app, this.mDraftText, this.mSourceMsgInfo, null);
      }
      this.isNeedDelayShowUnreaded = Boolean.valueOf(true);
      if ((this.mActivity != null) && (this.mActivity.getWindow() != null)) {
        this.mActivity.getWindow().setSoftInputMode(32);
      }
      if (this.mRichTextPanel != null) {
        this.mRichTextPanel.a();
      }
      String str;
      int i;
      ple localple;
      if ((this.mActivity != null) && (this.mActivity.getIntent() != null))
      {
        str = this.mActivity.getIntent().getStringExtra("uin");
        i = this.mActivity.getIntent().getIntExtra("uintype", -1);
        localple = ple.a();
        if (this.listAdapter == null) {
          break label259;
        }
      }
      label259:
      for (localObject = this.listAdapter.a();; localObject = null)
      {
        localple.a(0, (List)localObject, str, i, this.hasUnreadCount);
        agnj.g();
        ShortVideoRealItemBuilder.g();
        this.helperProvider.a(10);
        return;
      }
    }
  }
  
  protected void doOnUnRegReceivers()
  {
    try
    {
      if (this.mReceiverState == 1)
      {
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mReceiverState = 0;
      }
      for (;;)
      {
        boolean bool = AppNetConnInfo.unregisterNetInfoHandler(this);
        QLog.d(this.tag, 1, "AIOTime doOnUnRegReceivers :" + bool + "hashCode = " + Integer.toHexString(hashCode()));
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.tag, 2, "unRegisterReceiver but cannot");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.tag, 2, "unregisterReceiver:" + localException);
        }
      }
    }
  }
  
  protected void doPanelChanged(int paramInt1, int paramInt2)
  {
    updatePanelIconBtnImage();
    updatePanelIconStatus();
    if (QLog.isColorLevel()) {
      QLog.d("inputx", 2, "doPanelChanged newPanel=" + paramInt2);
    }
    updateApolloPanel(paramInt1, paramInt2);
    updateFakeInput(paramInt2);
    if (this.mAudioPanel != null) {
      this.mAudioPanel.a(paramInt1, paramInt2);
    }
    if ((paramInt2 == 14) && (paramInt1 != 14) && (this.mFlashPicPanel != null)) {
      this.mFlashPicPanel.a();
    }
    if ((paramInt1 == 2) && (paramInt2 != 2) && (this.mAudioPanel != null)) {
      this.mAudioPanel.b();
    }
    if ((paramInt1 != 2) && (paramInt2 == 2)) {
      this.recordCounts = 0;
    }
    if ((paramInt1 == 36) && (paramInt2 != 36) && (paramInt2 != 1) && (this.mVoiceTextEditPanel != null)) {
      this.mVoiceTextEditPanel.e();
    }
    updateTipsBar();
    updateRichTextPanel(paramInt1, paramInt2);
    ((afrd)this.helperProvider.a(10)).a(paramInt1, paramInt2);
    ((afss)getHelper(29)).a(paramInt1, paramInt2);
  }
  
  public void doShowPtv()
  {
    doShowPtv(false);
  }
  
  public void doShowPtv(boolean paramBoolean)
  {
    int j = 0;
    Object localObject = (afqj)this.helperProvider.a(24);
    if ((this.sessionInfo.curType == 1033) || (this.sessionInfo.curType == 1034)) {}
    for (int i = 1; (((afqj)localObject).a()) && ((i != 0) || (isReplyTextMode())); i = 0)
    {
      ((afqj)localObject).a(true);
      return;
    }
    if (this.recorder != null) {
      this.recorder.a();
    }
    if ((paramBoolean) && (((afqj)localObject).a())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, "doShowPtv clickAioPanel:" + paramBoolean + ", fullMode:" + isFullScreenMode());
      }
      if (!this.app.isUsingCameraOnVideo()) {
        break label226;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 2131695417, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299076));
      agwt.a(this.app, "0X8005E91", this.sessionInfo.curType);
      if (this.root.a() != 1) {
        break;
      }
      hideSoftInput();
      return;
    }
    label226:
    if (babd.a())
    {
      localObject = null;
      if (this.sessionInfo != null) {
        localObject = new SessionWrap(this.sessionInfo.curFriendUin, this.sessionInfo.curFriendNick, this.sessionInfo.curType, this.sessionInfo.troopUin);
      }
      localObject = ynm.a((SessionWrap)localObject, this.mActivity.getClass().getName(), 10000, 100);
      ((Bundle)localObject).putInt("VIDEO_STORY_FROM_TYPE", blvr.e.a());
      if (bool) {}
      for (i = 200;; i = 205)
      {
        ((Bundle)localObject).putInt("AECAMERA_MODE", i);
        ((Bundle)localObject).putInt("qq_sub_business_id", 106);
        ((Bundle)localObject).putBoolean("input_full_screen_mode", bool);
        ynm.a().a(getActivity(), (Bundle)localObject, 11);
        bmau.a().a(false);
        bmau.a().e();
        break;
      }
    }
    if (this.sessionInfo.curType == 9501) {}
    for (;;)
    {
      try
      {
        localObject = aara.a(this.app, Long.parseLong(this.sessionInfo.curFriendUin));
        i = j;
        if (localObject != null) {
          i = ((DeviceInfo)localObject).productId;
        }
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
      }
      afcm.a(this.app, this.mContext, getActivity(), this.sessionInfo, i, 1);
      break;
      i = 0;
    }
  }
  
  protected void doUpdateUnreadBubble(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i;
    Object localObject;
    Message localMessage;
    if (this.mReadedCnt < paramInt6)
    {
      int j = paramInt1 + paramInt2 - paramInt4 - paramInt5;
      i = j;
      if (j >= paramInt3 - paramInt5 - paramInt4) {
        i = paramInt6 - 1;
      }
      if (i >= this.mReadedCnt) {
        this.mReadedCnt = (i + paramInt4);
      }
      if (paramInt7 == 0) {
        this.mReadedCnt = paramInt6;
      }
      i = paramInt6 - this.mReadedCnt;
      if (i != this.mUnReadedCnt)
      {
        if (this.uiHandler.hasMessages(13)) {
          this.uiHandler.removeMessages(13);
        }
        j = getDisplayUnReadCntBubble(i);
        localObject = this.uiHandler;
        localMessage = this.uiHandler.obtainMessage(13, j, paramInt7);
        if (!this.isNeedDelayShowUnreaded.booleanValue()) {
          break label226;
        }
      }
    }
    label226:
    for (long l = 1500L;; l = 0L)
    {
      ((MqqHandler)localObject).sendMessageDelayed(localMessage, l);
      this.isNeedDelayShowUnreaded = Boolean.valueOf(false);
      this.mUnReadedCnt = i;
      localObject = (aftn)getHelper(53);
      if (localObject != null)
      {
        ((aftn)localObject).c(this.mUnReadedCnt);
        ((aftn)localObject).a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void emoticonMall()
  {
    gotoEmoMallPage(6);
  }
  
  protected boolean enableBlur()
  {
    return false;
  }
  
  public boolean enableFullScreenInput()
  {
    return true;
  }
  
  public void enableMosaicEffect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((CommonTextView)this.mTitleText).setMosaicEffect(new bhfj(10));
      ((OnlineStatusLyricView)this.mSubTilteText).setMosaicEffect(new bhfj(10));
      ((CommonTextView)this.mSubTitleText2).setMosaicEffect(new bhfj(10));
      ((CommonImageView)this.mTitleIcon).setMosaicEffect(new bhfj(10));
      ((CommonImageView)this.mTitleIcon2).setMosaicEffect(new bhfj(10));
      ((CommonImageView)this.mTitleIconRight).setMosaicEffect(new bhfj(10));
      localObject = this.mActivity.findViewById(2131365840);
      if (localObject != null) {
        ((CommonImageView)localObject).setMosaicEffect(new bhfj(10));
      }
      ((CommonTextView)this.mTitleCount).setMosaicEffect(new bhfj(10));
      if (!nmy.a().a(this.sessionInfo.curFriendUin))
      {
        localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130849953);
        this.afRoot.setBackgroundDrawable((Drawable)localObject);
        this.sessionInfo.chatBg = new aezp();
        this.sessionInfo.chatBg.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
        this.sessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      return;
    }
    ((CommonTextView)this.mTitleText).setMosaicEffect(null);
    ((OnlineStatusLyricView)this.mSubTilteText).setMosaicEffect(null);
    ((CommonTextView)this.mSubTitleText2).setMosaicEffect(null);
    ((CommonImageView)this.mTitleIcon).setMosaicEffect(null);
    ((CommonImageView)this.mTitleIcon2).setMosaicEffect(null);
    ((CommonImageView)this.mTitleIconRight).setMosaicEffect(null);
    Object localObject = this.mActivity.findViewById(2131365840);
    if (localObject != null) {
      ((CommonImageView)localObject).setMosaicEffect(null);
    }
    ((CommonTextView)this.mTitleCount).setMosaicEffect(null);
    loadBackgroundAsync();
  }
  
  public MessageForArkApp findCurrentArkMsg(afvi paramafvi)
  {
    Object localObject;
    if (paramafvi == null)
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.listAdapter.a().iterator();
    MessageForArkApp localMessageForArkApp;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (ChatMessage)localIterator.next();
          } while (!(localObject instanceof MessageForArkApp));
          localMessageForArkApp = (MessageForArkApp)localObject;
          localObject = localMessageForArkApp;
          if (localMessageForArkApp.arkContainer == paramafvi) {
            break;
          }
        } while (localMessageForArkApp.mExtendMsgArkAppList == null);
        localObject = localMessageForArkApp.mExtendMsgArkAppList.iterator();
      }
    } while (((MessageForArkApp)((Iterator)localObject).next()).arkContainer != paramafvi);
    return localMessageForArkApp;
    return null;
  }
  
  @Deprecated
  public void finish()
  {
    boolean bool = false;
    if (this.mDoodlePanel != null) {
      bool = this.mDoodlePanel.a();
    }
    if (!bool)
    {
      agkg.a();
      agkg.b();
      agkc.a().a();
      finish(1);
    }
  }
  
  public boolean finish(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      SplashActivity.jdField_c_of_type_Int = acjp.a().a(0, 1, 0, 0, 2000, 302, 8L, Process.myTid(), "exitAIO");
      SplashActivity.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    this.mCurrentAIOState = 7;
    AIOUtils.printColorLevelLog(this.tag, "finish " + paramInt, hashCode(), this.mCurrentAIOState);
    if (preFinish(paramInt)) {
      return true;
    }
    afmp.b();
    pauseWhenBack();
    onFinish_setReaded();
    if (this.mActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) {
      this.mActivity.moveTaskToBack(true);
    }
    backToQzoneUserHomeActivity();
    this.uiHandler.removeCallbacks(this.mRunOnShow);
    this.root.c();
    if (paramInt == 0) {
      returnMainFragment();
    }
    while (paramInt != 1)
    {
      try
      {
        Object localObject = this.mTitleBtnLeft.getTag();
        String[] arrayOfString = (String[])localObject;
        if ((localObject != null) && ("comic".equals(arrayOfString[0]))) {
          bkfq.a(this.app, "3006", "2", "40025", arrayOfString[1], new String[] { "3" });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if ((this.isFromSeachResult) && (!this.sendCloseSearchBroadCast) && (AIOUtils.isUserOperatedInAIO))
      {
        this.mActivity.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
        this.sendCloseSearchBroadCast = true;
      }
      if (this.mApolloViewController != null) {
        this.mApolloViewController.a(false);
      }
      hideAppShortcutBar();
      DuiButtonImageView.b();
      this.helperProvider.a(12);
      this.mCurrentAIOState = 8;
      ListenTogetherManager.a(this.app, this.sessionInfo, hashCode());
      if (this.hasCheckedBoxVisible) {
        setLeftCheckBoxVisible(false, null, false);
      }
      BaseChatItemLayout.jdField_a_of_type_Boolean = this.preCheckBoxVisible;
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, String.format("finish preCheckBoxVisible=[%b]", new Object[] { Boolean.valueOf(this.preCheckBoxVisible) }));
      }
      return false;
    }
    if ((this.mActivity instanceof ChatActivity)) {
      this.mActivity.finish();
    }
    for (;;)
    {
      HapticManager localHapticManager = HapticManager.a();
      if (localHapticManager == null) {
        break;
      }
      localHapticManager.c();
      break;
      returnMainFragment();
    }
  }
  
  public void funBtnEnable(boolean paramBoolean)
  {
    this.mFunBtn.setEnabled(paramBoolean);
  }
  
  protected List<ChatMessage> getAIOList()
  {
    return getAIOList(false);
  }
  
  protected List<ChatMessage> getAIOList(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return paramQQAppInterface.getMessageFacade().getAIOList(this.sessionInfo.curFriendUin, this.sessionInfo.curType, -1L, paramBoolean);
  }
  
  protected List<ChatMessage> getAIOList(boolean paramBoolean)
  {
    List localList = getAIOList(this.app, paramBoolean);
    if (((aubv)this.app.getManager(379)).a(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin))
    {
      localList = getAIOList(this.app, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "aioList cache update, re get aioList from cache");
      }
      return localList;
    }
    return localList;
  }
  
  public ViewGroup getAIORootView()
  {
    return this.mAIORootView;
  }
  
  public BaseActivity getActivity()
  {
    return this.mActivity;
  }
  
  protected void getAndParseAIOList()
  {
    ThreadManager.post(new BaseChatPie.39(this), 8, null, true);
  }
  
  public AIOAnimationConatiner getAnimContainer()
  {
    return this.mAnimContainer;
  }
  
  public final QQAppInterface getApp()
  {
    return this.app;
  }
  
  protected int getAudioPanelType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public RelativeLayout getContent()
  {
    return this.mContent;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  @Deprecated
  public String getCurFriendNick()
  {
    return this.sessionInfo.curFriendNick;
  }
  
  @Deprecated
  public String getCurFriendUin()
  {
    return this.sessionInfo.curFriendUin;
  }
  
  public String getCurTroopUin()
  {
    return this.sessionInfo.troopUin;
  }
  
  public int getCurType()
  {
    return this.sessionInfo.curType;
  }
  
  public int getCurrentAIOState()
  {
    return this.mCurrentAIOState;
  }
  
  public int getCurrentPanel()
  {
    return this.root.a();
  }
  
  public EmoticonMainPanel getEmoPanel()
  {
    return this.mEmoPanel;
  }
  
  public EmotionKeywordLayout getEmotionKeyWordLayout()
  {
    return this.emotionLayout;
  }
  
  public int getFateOfRecorder()
  {
    return this.fateOfRecorder;
  }
  
  public boolean getFunBtnEnable()
  {
    return this.mFunBtn.isEnabled();
  }
  
  public zsz getGiftAioPanelData()
  {
    if (this.mAIOGiftPanelContainer != null) {
      return this.mAIOGiftPanelContainer.a();
    }
    return null;
  }
  
  public bfip getGiftAnimationController()
  {
    if (this.mGiftAnimationController == null) {
      this.mGiftAnimationController = new bfip(this, this.mActivity, this.app);
    }
    return this.mGiftAnimationController;
  }
  
  public <T extends afrb> T getHelper(int paramInt)
  {
    return this.helperProvider.a(paramInt);
  }
  
  public boolean getIfOnShowDone()
  {
    return this.onShowDone;
  }
  
  public boolean getInputEnable()
  {
    return this.mInputStat != 2;
  }
  
  public ahqa getLocationShareTipBar()
  {
    return this.mLocationShareTipBar;
  }
  
  public avmr getMagicfaceViewController()
  {
    if (this.mMagicfaceViewController == null) {
      this.mMagicfaceViewController = new avmr(this);
    }
    return this.mMagicfaceViewController;
  }
  
  public agxe getPanelManager()
  {
    return this.panelManager;
  }
  
  protected int getPhotoListSelectCount()
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.panelManager.a(4);
    int i;
    if (localPhotoListPanel != null)
    {
      i = localPhotoListPanel.b();
      if (localPhotoListPanel == null) {
        break label39;
      }
    }
    label39:
    for (int j = localPhotoListPanel.c();; j = 0)
    {
      return j + i;
      i = 0;
      break;
    }
  }
  
  public QQRecorder.RecorderParam getRecorderParam()
  {
    return new QQRecorder.RecorderParam(bfyl.jdField_a_of_type_Int, 0, 0);
  }
  
  public XPanelContainer getRoot()
  {
    return this.root;
  }
  
  protected int getScrollFlag(int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "refreshlistadapter dirtyFlag=" + paramInt);
    }
    int i;
    if ((this.loadSearchedMessage) && (this.needjumpToMsg))
    {
      i = 8;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "refreshlistadapter after set dirtyFlag=" + i);
      }
      return i;
    }
    Object localObject;
    int k;
    if (paramInt == 0)
    {
      if (this.listView.getLastVisiblePosition() < 0) {
        break label339;
      }
      localObject = this.listView.getChildAt(this.listView.getChildCount() - 1);
      i = paramInt;
      if (localObject != null)
      {
        i = paramInt;
        if (this.listView.getFooterViewsCount() > 0)
        {
          i = paramInt;
          if (((View)localObject).getId() == 2131362429)
          {
            i = paramInt;
            if (!((akya)getHelper(4)).b()) {
              i = 2;
            }
          }
        }
        j = ((View)localObject).getBottom();
      }
      int m = this.listView.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "refreshlistadapter=====lastbuttom=" + j + " listHeight=" + m);
      }
      paramInt = i;
      k = j;
      j = m;
    }
    for (;;)
    {
      localObject = (AIOLongShotHelper)getHelper(15);
      i = paramInt;
      if (k > j) {
        break;
      }
      i = paramInt;
      if (((AIOLongShotHelper)localObject).a()) {
        break;
      }
      i = paramInt;
      if (paramInt != 0) {
        break;
      }
      i = paramInt;
      if (((akya)getHelper(4)).b()) {
        break;
      }
      i = 2;
      break;
      if (!needShowTimeForLastMsgItem())
      {
        i = 0;
        break;
      }
      if ((paramInt & 0x11) == 17)
      {
        i = 17;
        break;
      }
      i = paramInt;
      if ((paramInt & 0x10) != 16) {
        break;
      }
      i = 16;
      break;
      label339:
      j = 0;
      k = 0;
    }
  }
  
  public SessionInfo getSessionInfo()
  {
    return this.sessionInfo;
  }
  
  protected Boolean getStatusTxtDartElseLight()
  {
    return null;
  }
  
  public ahqs getTipManager()
  {
    return this.mTipsMgr;
  }
  
  public int getTitleBarHeight()
  {
    return this.mContext.getResources().getDimensionPixelSize(2131299076);
  }
  
  public final MqqHandler getUIHandler()
  {
    return this.uiHandler;
  }
  
  public agpy getViewCache()
  {
    return this.mStructingMsgItemViewCache;
  }
  
  public void gotoEmoMallPage(int paramInt)
  {
    EmojiHomeUiPlugin.openEmojiHomePage(this.mActivity, this.app.getAccount(), paramInt);
    if (6 == paramInt) {
      bcef.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiTianjia", 0, 0, "", "", "", "");
    }
    while (9 != paramInt) {
      return;
    }
    bcef.b(null, "CliOper", "", "", "MbGuanli", "MbGiftClick", 0, 0, "", "", "", "");
  }
  
  public void grantForCamera()
  {
    QLog.d("CheckPermission", 1, "CheckPermission user grant");
    this.root.a();
    if (this.recorder != null) {
      this.recorder.a();
    }
    if (this.sessionInfo.curType == 9501) {}
    for (;;)
    {
      try
      {
        localObject = aara.a(this.app, Long.parseLong(this.sessionInfo.curFriendUin));
        if (localObject == null) {
          continue;
        }
        i = ((DeviceInfo)localObject).productId;
      }
      catch (Exception localException)
      {
        Object localObject;
        i = 0;
        continue;
        i = 0;
        continue;
      }
      afcm.a(this.app, this.mContext, getActivity(), this.sessionInfo, i, 0);
      localObject = (amoa)this.app.getBusinessHandler(53);
      if (((amoa)localObject).a(0)) {
        ((amoa)localObject).a();
      }
      return;
      int i = 0;
    }
  }
  
  public boolean handleApolloMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 77: 
    case 48: 
    case 47: 
    case 61: 
    case 62: 
    case 65: 
    case 82: 
      label216:
      do
      {
        do
        {
          do
          {
            return false;
            paramMessage = (String)paramMessage.obj;
          } while (android.text.TextUtils.isEmpty(paramMessage));
          QQToast.a(this.mContext, paramMessage, 0).a();
          return false;
        } while (this.input == null);
        this.input.setText("");
        return false;
        if (this.businessFooterDetector.a() != null)
        {
          i = Math.max(AIOUtils.dp2px(46.0F, this.mContext.getResources()), paramMessage.arg1);
          this.businessFooterDetector.a(1, i);
          this.businessFooterDetector.a(i, true, "handleMsg_showFooter", 0);
          return false;
        }
        if (1 != ((alnr)this.app.getManager(153)).b(this.app.getCurrentUin()))
        {
          i = 1;
          if ((i == 0) || (ambc.a(this.app))) {
            break label282;
          }
        }
        for (i = 1; i == 0; i = 0)
        {
          this.apolloIsShowing = true;
          i = Math.max(AIOUtils.dp2px(46.0F, this.mContext.getResources()), paramMessage.arg1);
          this.businessFooterDetector.a(i, false, "handleMsg_addFooter", 0);
          return false;
          i = 0;
          break label216;
        }
        this.apolloIsShowing = false;
        this.businessFooterDetector.a(1, 0);
        this.businessFooterDetector.a();
        return false;
        initApolloSurfaceView();
        return false;
      } while (!(paramMessage.obj instanceof ApolloActionData));
      label282:
      int i = paramMessage.arg1;
      String str = paramMessage.getData().getString("senderUin");
      paramMessage = (ApolloActionData)paramMessage.obj;
      ((alpg)this.app.getManager(232)).a(this, paramMessage, i, str);
      return false;
    }
    ((alpg)this.app.getManager(232)).a();
    return false;
  }
  
  protected void handleForwardData(Intent paramIntent)
  {
    if (ForwardUtils.handleForwardData(this.app, this.mActivity, this.mContext, paramIntent, this.uiHandler)) {
      this.isBack2Root = this.mActivity.getIntent().getBooleanExtra("isBack2Root", false);
    }
  }
  
  public void handleHiddenEmoticonKeyword()
  {
    if (this.emotionLayout != null)
    {
      this.emotionLayout.hide();
      this.uiHandler.removeMessages(67);
    }
    if (this.mApolloViewController != null) {
      this.mApolloViewController.a(true);
    }
    if (this.emotionKeywordAdapter != null) {
      this.emotionKeywordAdapter.reportExposeData();
    }
    ((afsu)getHelper(14)).b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    handleBaseMsg(paramMessage);
    handleMsgMessage(paramMessage);
    handleTipsMessage(paramMessage);
    handleEmoticonMessage(paramMessage);
    handleDoutuMessage(paramMessage);
    handleApolloMessage(paramMessage);
    handleApolloPanelMessage(paramMessage);
    handlePttMessage(paramMessage);
    ((afqg)getHelper(83)).a(paramMessage);
    handleUpdateBubbleCache(paramMessage);
    handleWeiyunMsg(paramMessage);
    switch (paramMessage.what)
    {
    default: 
    case 16711683: 
    case 54: 
    case 60: 
    case 51: 
    case 267387138: 
    case 42: 
    case 55: 
    case 56: 
    case 57: 
    case 64: 
    case 68: 
    case 95: 
      do
      {
        do
        {
          do
          {
            RelativeLayout.LayoutParams localLayoutParams;
            do
            {
              do
              {
                return true;
                QQToast.a(this.app.getApp(), 2131718116, 1).b(getTitleBarHeight());
                return true;
              } while ((this.listView == null) || (paramMessage.arg1 <= 50));
              localLayoutParams = (RelativeLayout.LayoutParams)this.listView.getLayoutParams();
            } while ((localLayoutParams == null) || (localLayoutParams.bottomMargin == paramMessage.arg1));
            localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramMessage.arg1);
            this.listView.setLayoutParams(localLayoutParams);
            return true;
            udpateAIOBackgrourd(paramMessage);
            return true;
            paramMessage = (PlusPanel)this.panelManager.a(8);
          } while (paramMessage == null);
          paramMessage.c();
          return true;
          updateZanInfo(paramMessage);
          return true;
          boolean bool = paramMessage.getData().getBoolean("showRedDot");
          if (bool) {
            bcef.b(this.app, "CliOper", "", "", "0X8005B00", "0X8005B00", 0, 0, "", "", "", "");
          }
          this.mCustomTitleView.b(bool);
          return true;
          reportClassicAndSmallEmoticon((String)paramMessage.obj, true, this.mEmoPanel, this.app);
          return true;
          msgReport(this.sessionInfo.entrance, 3);
          return true;
          instantUpdate(true, true);
          return true;
          refreshTitleReativeIcon();
          return true;
        } while (this.mTipsMgr == null);
        this.mTipsMgr.c();
        return true;
      } while ((!(paramMessage.obj instanceof CharSequence)) || (this.mMsgbox == null));
      paramMessage = (CharSequence)paramMessage.obj;
      this.mMsgbox.setText(paramMessage);
      this.mMsgbox.requestLayout();
      return true;
    }
    this.input.setTypeface(gm.a());
    return true;
  }
  
  protected void handleNightMask()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.sessionInfo.chatBg != null) {
        if ((!"".equals(this.sessionInfo.chatBg.jdField_a_of_type_JavaLangString)) && (!"null".equals(this.sessionInfo.chatBg.jdField_a_of_type_JavaLangString))) {
          break label368;
        }
      }
    }
    label221:
    label368:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "#handleNightMask# : inNightMode, isDefaultBg=" + bool + ",mMask=" + this.mMask + ", sessionInfo.chatBg.path=" + this.sessionInfo.chatBg.jdField_a_of_type_JavaLangString);
      }
      if ((this.mMask != null) && (QLog.isColorLevel()))
      {
        if (this.mMask.getVisibility() == 0) {
          QLog.d(this.tag, 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
        }
      }
      else
      {
        if (bool) {
          break label313;
        }
        if ((this.mMask == null) || (this.mMask.getVisibility() != 0)) {
          break label221;
        }
      }
      do
      {
        do
        {
          return;
          if (this.mMask.getVisibility() == 4)
          {
            QLog.d(this.tag, 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
            break;
          }
          QLog.d(this.tag, 2, "#handleNightMask# : mMask getVisibility = GONE");
          break;
          if (this.mMask == null)
          {
            this.mMask = new View(this.mContext);
            this.mMask.setBackgroundColor(1996488704);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
            localLayoutParams.addRule(6, 2131370017);
            localLayoutParams.addRule(2, this.mInputBar.getId());
            this.mMask.setLayoutParams(localLayoutParams);
            this.mContent.addView(this.mMask);
            return;
          }
          this.mMask.setVisibility(0);
          return;
        } while (this.mMask == null);
        this.mContent.removeView(this.mMask);
        this.mMask = null;
        return;
      } while ((this.mMask == null) || (this.mContent == null));
      this.mContent.removeView(this.mMask);
      this.mMask = null;
      return;
    }
  }
  
  public void handlePanelOnExpandFullScreen()
  {
    int i = this.root.a();
    if ((this.panelicons != null) && (i != 1) && (i != 3))
    {
      this.root.a();
      showInputPanel();
    }
  }
  
  public void handleRemoveTips()
  {
    if (this.mTipsContainer != null)
    {
      this.mTipsContainer.removeAllViews();
      this.mMsgbox = null;
      this.mMsgboxline = null;
    }
  }
  
  protected void handleRequest(Intent paramIntent, int paramInt)
  {
    int i = paramIntent.getIntExtra(bftk.h, -1);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "handleRequest requestCode " + i);
    }
    if ((i == 2) || (i == 1)) {
      this.chatPieHelper.b(paramIntent);
    }
    if (paramInt == 1) {
      ahpm.b(this.app, this.sessionInfo.curFriendUin);
    }
    while ((paramInt != 2) || (this.mIsCurrentSession)) {
      return;
    }
    ahpm.b(this.app, this.sessionInfo.curFriendUin);
  }
  
  protected void handleScrollOutScreen(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = AIOUtils.getHolder(paramView);
            if (agnu.class.isInstance(paramView))
            {
              ((agnu)paramView).a();
              return;
            }
            if (agok.class.isInstance(paramView))
            {
              ((agok)paramView).a();
              return;
            }
            if (aghp.class.isInstance(paramView))
            {
              ((aghp)paramView).a();
              return;
            }
            if (!(paramView instanceof agql)) {
              break;
            }
            paramView = (agql)paramView;
          } while (paramView.a == null);
          paramView.a.d();
          return;
          if (!(paramView instanceof agjd)) {
            break;
          }
          paramView = (agjd)paramView;
        } while (paramView.a == null);
        paramView.a.d();
        return;
      } while (!(paramView instanceof agib));
      paramView = (agib)paramView;
    } while (paramView.a == null);
    paramView.a.d();
  }
  
  protected void handleSignalAfterTextChanged(Editable paramEditable)
  {
    if (this.mIsMsgSignalOpen)
    {
      if ((this.mIsMsgSignaling) || (paramEditable.length() <= 0)) {
        break label82;
      }
      this.mMsgSignalNetType = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
      if ((this.mMsgSignalNetType == 2) || (this.mMsgSignalNetType == 3))
      {
        this.mIsMsgSignaling = true;
        this.mMsgSignalSum = 1;
        if (this.msgSignalRunnable == null) {
          initMsgSignalRunnable();
        }
        ThreadManager.getSubThreadHandler().post(this.msgSignalRunnable);
      }
    }
    label82:
    while (paramEditable.length() != 0) {
      return;
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.msgSignalRunnable);
    this.mIsMsgSignaling = false;
    this.mMsgSignalSum = 40;
    this.mMsgSignalCount = 0;
    this.mMsgInputLen = 0;
    this.mMsgSignalNetType = 0;
  }
  
  protected void handleTextChangedReal(Editable paramEditable)
  {
    boolean bool2 = true;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "input stat is " + this.mInputStat);
    }
    boolean bool1;
    int i;
    if (this.mInputStat == 0)
    {
      if (this.isSimpleBar)
      {
        if ((paramEditable.length() <= 0) && (getPhotoListSelectCount() <= 0)) {
          break label425;
        }
        bool1 = true;
        setFunBtnEnabled(bool1);
      }
      afsu localafsu = (afsu)getHelper(14);
      if ((!localafsu.a()) || (this.sessionInfo.curType == 1008)) {
        break label430;
      }
      i = 1;
      label116:
      if ((this.emotionLayout != null) && (this.emotionLayout.getVisibility() == 0) && (i == 0))
      {
        this.emotionLayout.setVisibility(8);
        this.uiHandler.removeMessages(67);
        if ((this.mApolloViewController != null) && (!isFullScreenMode())) {
          this.mApolloViewController.a(true);
        }
        resumeAppShorcutBar();
        if (this.emotionKeywordAdapter != null) {
          this.emotionKeywordAdapter.reportExposeData();
        }
      }
      if ((paramEditable.length() <= 0) && (getPhotoListSelectCount() <= 0)) {
        break label435;
      }
      bool1 = true;
      label213:
      setFunBtnEnabled(bool1);
      afss localafss = (afss)getHelper(29);
      if (paramEditable.length() <= 0) {
        break label440;
      }
      bool1 = true;
      label240:
      localafss.a(bool1);
      if (this.hasDraftText)
      {
        if (paramEditable.length() <= 0) {
          break label445;
        }
        bool1 = bool2;
        label265:
        this.hasDraftText = bool1;
      }
      handleZhituTextChanged(paramEditable);
      showStickerBubbleQuickButtonIfNeeded(paramEditable.toString());
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "check zhitu condition: " + paramEditable.length() + " / " + this.receiptMode + " / " + this.mZhituSwitch);
      }
      if (i != 0) {
        localafsu.b(paramEditable);
      }
      if (isShowStickerLayout(paramEditable))
      {
        if (i == 0) {
          break label450;
        }
        localafsu.a(paramEditable);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("afterTextChanged", 2, " afterTextChanged cost: " + (System.currentTimeMillis() - l));
      }
      handleSignalAfterTextChanged(paramEditable);
      handleTextChangedZhituShow(paramEditable);
      return;
      label425:
      bool1 = false;
      break;
      label430:
      i = 0;
      break label116;
      label435:
      bool1 = false;
      break label213;
      label440:
      bool1 = false;
      break label240;
      label445:
      bool1 = false;
      break label265;
      label450:
      handleEmotionKeywords(paramEditable);
    }
  }
  
  protected void handleTextChangedZhituShow(Editable paramEditable)
  {
    if ((!this.receiptMode) && (paramEditable.length() > 0) && (this.mZhituSwitch))
    {
      this.uiHandler.removeMessages(84);
      ahtj.a(this.app).a(this.app, paramEditable, this.listAdapter.a(), getCurType(), true);
      this.uiHandler.sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  protected void handleZhituTextChanged(Editable paramEditable)
  {
    int i = 1;
    boolean bool;
    if ((paramEditable.toString().trim().length() > 0) && (((afqx)getHelper(18)).a(this.mContext, paramEditable.toString(), this.input)))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "check valid input condition: " + bool + " / " + this.receiptMode + " / " + ahtj.a(this.sessionInfo.curType));
      }
      if ((!bool) || (this.receiptMode) || (!ahtj.a(this.sessionInfo.curType)) || (this.mSourceMsgInfo != null) || ((this instanceof ahgc))) {
        break label306;
      }
      bool = true;
      label150:
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "afterTextChange,isValidInput = " + bool);
      }
      ahtj localahtj = ahtj.a(this.app);
      if ((!bool) || (!localahtj.a(paramEditable))) {
        break label311;
      }
      label205:
      if (i == 0)
      {
        disableZhitu();
        hideZhituIcon();
      }
      if (i != 0)
      {
        if (!atid.a(this.app).b(this.app)) {
          break label369;
        }
        if (this.mIconLayoutInInputRight.getVisibility() != 0) {
          break label321;
        }
        if ((paramEditable.length() <= 20) && (localahtj.a(paramEditable))) {
          break label316;
        }
        this.mIconButtonInInputRight.setSelected(false);
        this.mZhituSwitch = false;
        showZhituIcon();
        localahtj.c();
        this.mIconButtonInInputRight.setImageResource(2130838103);
      }
    }
    label306:
    label311:
    label316:
    label321:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label150;
      i = 0;
      break label205;
      showZhituIcon();
      return;
      showZhituIcon();
    } while (this.hasDraftText);
    bcef.b(this.app, "CliOper", "", "", "0X80094D0", "0X80094D0", 0, 0, "", "", "", "");
    return;
    label369:
    this.mIconLayoutInInputRight.setVisibility(8);
    this.input.setPadding(this.input.getPaddingLeft(), this.input.getPaddingTop(), AIOUtils.dp2px(11.0F, this.mActivity.getResources()), this.input.getPaddingBottom());
  }
  
  public boolean hasXPanelContainer()
  {
    return this.root.a() != 0;
  }
  
  protected void hideAddFriendAndShield()
  {
    if (this.linearLayout != null) {
      this.linearLayout.setVisibility(8);
    }
    if (this.mTipRoot != null)
    {
      int i = (int)this.mActivity.getResources().getDimension(2131299076);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTipRoot.getLayoutParams();
      localLayoutParams.topMargin = i;
      this.mTipRoot.setLayoutParams(localLayoutParams);
    }
  }
  
  public void hideAllPanels()
  {
    hideAllPanels(false);
  }
  
  public void hideAllPanels(boolean paramBoolean)
  {
    Object localObject;
    if (this.root.a() == 1)
    {
      localObject = (InputMethodManager)this.mContext.getSystemService("input_method");
      if (((InputMethodManager)localObject).isActive(this.input))
      {
        if (paramBoolean) {
          this.root.b();
        }
      }
      else
      {
        View localView = this.root.a();
        if ((localView != null) && ((localView instanceof VoiceTextPanel)) && (((InputMethodManager)localObject).isActive()))
        {
          if (!paramBoolean) {
            break label98;
          }
          this.root.b();
        }
      }
    }
    label98:
    do
    {
      return;
      this.root.a();
      break;
      this.root.a();
      return;
      localObject = this.root.a();
    } while ((localObject == null) || (((View)localObject).getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "hideAllPanels  curPanel = " + this.root.a());
    }
    if (paramBoolean)
    {
      this.root.b();
      return;
    }
    this.root.a();
  }
  
  public void hideAppShortcutBar()
  {
    afsn localafsn = (afsn)this.helperProvider.a(52);
    if (localafsn != null) {
      localafsn.h();
    }
  }
  
  public void hideBottomBar()
  {
    this.mInputBar.setVisibility(8);
    this.mBottomBlurView.setVisibility(8);
    if (this.panelicons != null) {
      this.panelicons.setCustomHeight(0);
    }
    if (this.mFakeInput != null) {
      this.mFakeInput.setVisibility(8);
    }
    if (this.mFakeUpInput != null) {
      this.mFakeUpInput.setVisibility(8);
    }
  }
  
  public void hideFullScreenInput(boolean paramBoolean)
  {
    ((afqj)this.helperProvider.a(24)).a(paramBoolean);
  }
  
  public void hideGiftPanel()
  {
    if (this.mAIOGiftPanelContainer != null) {
      this.mAIOGiftPanelContainer.a();
    }
  }
  
  public void hidePanel()
  {
    this.root.a();
  }
  
  public void hideSoftInput()
  {
    if ((this.mActivity != null) && (this.root != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.mActivity.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.hideSoftInputFromWindow(this.root.getWindowToken(), 0);
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, new Object[] { "hideSoftInput, ", this.root.getWindowToken() });
        }
      }
    }
  }
  
  public void hideTroopFCView(boolean paramBoolean) {}
  
  public void hideZhituIcon()
  {
    if ((this.mActivity != null) && (this.mIconLayoutInInputRight != null) && (this.mIconLayoutInInputRight.getVisibility() == 0))
    {
      this.mIconButtonInInputRight.setImageResource(2130838103);
      this.mIconLayoutInInputRight.setVisibility(8);
      this.mZhituSwitch = false;
      this.input.setPadding(this.input.getPaddingLeft(), this.input.getPaddingTop(), AIOUtils.dp2px(11.0F, this.mActivity.getResources()), this.input.getPaddingBottom());
    }
  }
  
  public boolean ifApolloFunAvailThenInit()
  {
    checkInitApolloViewController();
    return this.mApolloViewController.a(this);
  }
  
  public void initApolloSurfaceView()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "[initApolloSurfaceView],mCurrentAIOState:" + this.mCurrentAIOState);
    }
    checkInitApolloViewController();
    this.mApolloViewController.b(this);
  }
  
  protected void initFakeInputView()
  {
    if (this.mFakeInput == null)
    {
      this.mFakeInput = new View(this.mActivity);
      this.mFakeInputParam = new RelativeLayout.LayoutParams(-1, (int)(15.0F * this.mDensity + 0.5F));
      this.mFakeInputParam.addRule(3, 2131368751);
      this.mFakeInput.setId(2131362371);
      if (this.mContent != null) {
        this.mContent.addView(this.mFakeInput, this.mFakeInputParam);
      }
    }
    this.mFakeInput.setVisibility(0);
    this.mFakeInput.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      bfpm.a(this.mFakeInput, false);
    }
  }
  
  protected int initHaveUnRead()
  {
    int i = this.app.getConversationFacade().a(this.sessionInfo.curFriendUin, this.sessionInfo.curType);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "initHaveUnRead count " + i);
    }
    return i;
  }
  
  protected void initHelper() {}
  
  protected void initTipsTaskList()
  {
    this.mOperateTips = new ahqh(this.app, this.mTipsMgr, this.app.getApp(), this.root, this.mBlueTipsTaskList, this.sessionInfo, this.listAdapter);
    ahqj localahqj = new ahqj(this.app, this.mTipsMgr, this.mActivity, this.mActivity.getIntent());
    this.mVideoStatusBar = new VideoStatusTipsBar(this.app, this.sessionInfo, this.mTipsMgr, this.mActivity, this.uiHandler);
    this.mFraudTipsBar = new ahpk(this.app, this.mTipsMgr, this.app.getApp(), this.sessionInfo, this.uiHandler);
    new SougouInputGrayTips(this.app, this.mTipsMgr, this.mContext, this.sessionInfo);
    ahpw localahpw = new ahpw(this.app, this.mTipsMgr, this.mActivity, this.sessionInfo, this.listAdapter);
    VipSpecialCareGrayTips localVipSpecialCareGrayTips = new VipSpecialCareGrayTips(this.app, this.mTipsMgr, this.mActivity, this.sessionInfo);
    ahpf localahpf = new ahpf(this.app, this.mTipsMgr, this.mActivity);
    this.mLocationShareTipBar = new ahqa(this);
    this.mTipsMgr.a(this.mOperateTips);
    this.mTipsMgr.a(localahqj);
    this.mTipsMgr.a(this.mVideoStatusBar);
    this.mTipsMgr.a(this.mFraudTipsBar);
    this.mTipsMgr.a(localahpf);
    this.mTipsMgr.a(localahpw);
    this.mTipsMgr.a(localVipSpecialCareGrayTips);
    this.mTipsMgr.a(this.mLocationShareTipBar);
  }
  
  protected void initUPFakeInputView()
  {
    if (this.mFakeUpInput == null)
    {
      this.mFakeUpInput = new View(this.mActivity);
      this.mFakeUpInputParam = new RelativeLayout.LayoutParams(-1, (int)(12.0F * this.mDensity + 0.5F));
      this.mFakeUpInputParam.addRule(6, 2131368751);
      this.mFakeUpInput.setId(2131362372);
      if (this.mContent != null) {
        this.mContent.addView(this.mFakeUpInput, this.mFakeUpInputParam);
      }
    }
    this.mFakeUpInput.setVisibility(0);
    this.mFakeUpInput.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      bfpm.a(this.mFakeUpInput, false);
    }
  }
  
  public void instantUpdate(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "instantUpdate: " + paramBoolean1 + " / " + paramBoolean2);
    }
    if (blockRefreshJumpBottom())
    {
      QLog.d(this.tag, 1, "instantUpdate: blockRefreshJumpBottom TRUE " + false + " / " + false);
      paramBoolean2 = false;
      paramBoolean1 = false;
    }
    if (paramBoolean1) {
      if (!paramBoolean2) {}
    }
    for (;;)
    {
      refresh(i | 0x20000);
      return;
      i = 3;
      continue;
      i = 0;
    }
  }
  
  public boolean isActivityResume()
  {
    boolean bool = false;
    if (((this.mActivity != null) && ((this.mActivity.isResume()) || (this.mActivity.isInMultiWindow()))) || (this.root.a() == 6) || (this.root.a() == 5)) {
      bool = true;
    }
    if ((this.mActivity != null) && (QLog.isColorLevel())) {
      QLog.d(this.tag, 2, "isActivityResume = " + bool);
    }
    return bool;
  }
  
  public boolean isAllowSendFlash()
  {
    return false;
  }
  
  public boolean isExtensionInfo()
  {
    boolean bool = true;
    if ((this.sessionInfo.curType == 3000) || (this.sessionInfo.curType == 1)) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isFullScreenMode()
  {
    return ((afqj)this.helperProvider.a(24)).a();
  }
  
  public boolean isMsgBoxVisable()
  {
    return (this.mMsgbox != null) && (this.mMsgbox.getVisibility() == 0);
  }
  
  public boolean isNeedRecreatePanel(int paramInt)
  {
    if ((paramInt == 2) && (this.needRecreateAudioPanel))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "recreate audio panel due to receipt message");
      }
      this.needRecreateAudioPanel = false;
      return true;
    }
    if ((paramInt == 3) && (this.needRecreateEmotionPanel))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "recreate emotion panel due to full screen");
      }
      this.needRecreateEmotionPanel = false;
      return true;
    }
    return this.panelManager.isNeedRecreatePanel(paramInt);
  }
  
  protected boolean isNeedUpdate(MessageRecord paramMessageRecord)
  {
    return (this.sessionInfo.curFriendUin.equals(paramMessageRecord.frienduin)) && ((this.sessionInfo.curType == paramMessageRecord.istroop) || ((abwz.d(this.sessionInfo.curType)) && (abwz.d(paramMessageRecord.istroop)))) && (apse.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.sessionInfo.curType, this.sessionInfo.topicId));
  }
  
  public boolean isOneWayFriend()
  {
    return azxj.a(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin);
  }
  
  public boolean isPTVRecording()
  {
    return this.chatPieHelper.b;
  }
  
  public void isPackageExist(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vivo", 2, "isPackageExist isVivoShot=" + isVivoShot);
    }
    if (isVivoShot != 0) {
      this.isVivoScrollToButtom = Boolean.valueOf(false);
    }
    for (;;)
    {
      return;
      String str = Build.MANUFACTURER.toUpperCase();
      if ((!str.endsWith("BBK")) && (!str.endsWith("VIVO")))
      {
        isVivoShot = 2;
        return;
      }
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext.getApplicationInfo(paramString, 8192);
        isVivoShot = 1;
        this.isVivoScrollToButtom = Boolean.valueOf(false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("vivo", 2, " isPackageExist isScrollToButtom=" + this.isVivoScrollToButtom);
        return;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          isVivoShot = 2;
        }
      }
    }
  }
  
  public boolean isPublicChatActivity()
  {
    return getCurType() == 1008;
  }
  
  public boolean isRecorderRecording()
  {
    return (this.recorder != null) && (!this.recorder.b());
  }
  
  public boolean isRecording()
  {
    return (this.recorder != null) && (this.recorder.a());
  }
  
  public boolean isRecordingOrPlaying()
  {
    return isRecording();
  }
  
  public boolean isReplyTextMode()
  {
    return this.mSourceMsgInfo != null;
  }
  
  protected boolean isShowStickerLayout(Editable paramEditable)
  {
    afsu localafsu = (afsu)getHelper(14);
    return (paramEditable.length() > 0) && (!this.receiptMode) && (!this.mZhituSwitch) && (!isReplyTextMode()) && (!isFullScreenMode()) && (localafsu.b()) && (this.sessionInfo.curType != 10007);
  }
  
  public boolean isSimpleBar()
  {
    return this.isSimpleBar;
  }
  
  protected final boolean isVoiceChangerPanel()
  {
    return (this.mAudioPanel != null) && (this.mAudioPanel.a() == 0);
  }
  
  void jumpToBottom()
  {
    if (this.listView != null) {
      this.listView.setSelection(this.listView.getAdapter().getCount() - 1);
    }
  }
  
  public void jumpToSpecifiedMsg(long paramLong)
  {
    long l = System.currentTimeMillis();
    Object localObject = this.listAdapter.a();
    if (((List)localObject).size() > 0)
    {
      int i = getIndexOfMsg((List)localObject, paramLong);
      if (i >= 0) {
        this.listView.post(new BaseChatPie.29(this, i));
      }
    }
    else
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l, 0L, null, null);
      return;
    }
    List localList = this.app.getMessageFacade().getBaseMessageManager(this.sessionInfo.curType).a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, paramLong);
    if (1000 == this.sessionInfo.curType) {}
    for (localObject = ChatActivityUtils.b(localList, this.sessionInfo, this.app);; localObject = ChatActivityUtils.a(localList, this.sessionInfo, this.app))
    {
      setList(localList, ChatActivityUtils.a(this.app, this.mContext, this.sessionInfo, (MessageRecord)localObject, -1L));
      this.listView.post(new BaseChatPie.30(this));
      break;
    }
  }
  
  public void jumpToSpecifiedMsg(ChatMessage paramChatMessage)
  {
    List localList = this.listAdapter.a();
    long l = paramChatMessage.time;
    if ((this.sessionInfo.curType == 3000) || (this.sessionInfo.curType == 1)) {}
    for (l = paramChatMessage.shmsgseq;; l = paramChatMessage.time)
    {
      if (localList.size() > 0)
      {
        int i = getIndexOfMsg(localList, l);
        if (i >= 0) {
          this.listView.setSelection(i);
        }
      }
      return;
    }
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    if (isFullScreenMode()) {}
    do
    {
      return;
      if (!this.chatPieHelper.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.tag, 2, "leftBackEvent() disableBackForPTV true");
    return;
    if ((this.mDoodlePanel != null) && (this.mDoodlePanel.a(true) > 0)) {
      bcef.b(this.app, "dc00898", "", "", "0X80081B8", "0X80081B8", 1, 0, "", "", "", "");
    }
    if ((this.mDoodlePanel != null) && (this.mDoodlePanel.a(true) > 10))
    {
      BaseChatPie.45 local45 = new BaseChatPie.45(this, paramBoolean);
      bfur.a(this.mContext, 230, null, this.mContext.getString(2131689858), this.mContext.getString(2131689856), this.mContext.getString(2131689857), local45, local45).show();
      return;
    }
    doLeftBackEvent(paramBoolean);
  }
  
  public void loadBackgroundAsync()
  {
    AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
    if ((localAIOLongShotHelper != null) && (localAIOLongShotHelper.a()) && (localAIOLongShotHelper.b()))
    {
      QLog.i(this.tag, 1, "loadBackgroundAsync: skip for mosaic is on");
      return;
    }
    ThreadManager.postImmediately(new BaseChatPie.26(this), null, true);
  }
  
  protected void loadTextDraft()
  {
    this.input.setText("");
    this.mSourceMsgInfo = null;
    this.mDraftManager = avnb.a(this.app);
    this.isBeingInputDraft = true;
    ThreadManager.post(new GetTextDraftJob(this.uiHandler, this.sessionInfo, this.mDraftManager, this.app, this), 8, null, true);
  }
  
  public void magicfaceSend(Emoticon paramEmoticon)
  {
    acvv.a(this.app, this.mContext, this.sessionInfo, paramEmoticon);
  }
  
  protected void messageTips(QQMessageFacade.Message paramMessage)
  {
    if (this.isJubaoMode) {}
    while ((!BaseChatpieHelper.a(this.sessionInfo, this.app, paramMessage)) || (isFullScreenMode()) || (bjnm.a(this.app).c(paramMessage)) || (((afqy)getHelper(39)).a(paramMessage)) || (24 == this.mTipsMgr.a())) {
      return;
    }
    Intent localIntent = this.app.getIntentByMessage(this.mContext, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    paramMessage = new BaseChatPie.43(this, paramMessage, localIntent);
    this.mActivity.runOnUiThread(paramMessage);
  }
  
  protected boolean needShowTimeForLastMsgItem()
  {
    return true;
  }
  
  public void onAudioPanelTypeChanged(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!paramBoolean1) {
      break label7;
    }
    label7:
    label217:
    label222:
    label223:
    for (;;)
    {
      return;
      if (!paramBoolean2)
      {
        Object localObject = (amsw)this.app.getManager(51);
        if ((this.sessionInfo.curType == 3000) || (this.sessionInfo.curType == 1))
        {
          localObject = ((amsw)localObject).a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, false);
          if (localObject != null) {
            break label222;
          }
          localObject = this.mNoC2CExtensionInfo;
        }
        for (;;)
        {
          if (localObject == null) {
            break label223;
          }
          if (paramInt == 2)
          {
            ((NoC2CExtensionInfo)localObject).isDataChanged = true;
            return;
          }
          if (!((NoC2CExtensionInfo)localObject).isDataChanged) {
            if (((NoC2CExtensionInfo)localObject).audioPanelType == paramInt) {
              break label132;
            }
          }
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            ((NoC2CExtensionInfo)localObject).isDataChanged = paramBoolean1;
            ((NoC2CExtensionInfo)localObject).audioPanelType = paramInt;
            return;
          }
          ExtensionInfo localExtensionInfo = ((amsw)localObject).a(this.sessionInfo.curFriendUin, false);
          localObject = localExtensionInfo;
          if (localExtensionInfo == null) {
            localObject = this.mExtensionInfo;
          }
          if (localObject == null) {
            break;
          }
          if (paramInt == 2)
          {
            ((ExtensionInfo)localObject).isDataChanged = true;
            return;
          }
          if (!((ExtensionInfo)localObject).isDataChanged) {
            if (((ExtensionInfo)localObject).audioPanelType == paramInt) {
              break label217;
            }
          }
          for (paramBoolean1 = bool;; paramBoolean1 = false)
          {
            ((ExtensionInfo)localObject).isDataChanged = paramBoolean1;
            ((ExtensionInfo)localObject).audioPanelType = paramInt;
            return;
          }
        }
      }
    }
  }
  
  public void onAvatarLongClick()
  {
    String str;
    int i;
    Editable localEditable;
    if ((this.mTitleText != null) && (this.input != null))
    {
      this.input.requestFocus();
      bjmm.a(this.input);
      str = this.mTitleText.getText().toString() + " ";
      i = this.input.getSelectionStart();
      localEditable = this.input.getEditableText();
      if ((i < 0) || (i >= localEditable.length())) {
        localEditable.append(str);
      }
    }
    else
    {
      return;
    }
    localEditable.insert(i, str);
  }
  
  public boolean onBackEvent()
  {
    if ((this.mChatDrawer != null) && (this.mChatDrawer.a()))
    {
      if (!this.mChatDrawer.b()) {
        this.mChatDrawer.a(true);
      }
      return true;
    }
    akya localakya = (akya)getHelper(4);
    if ((localakya != null) && (localakya.a())) {
      return true;
    }
    if (this.doutuManager != null) {
      this.doutuManager.b();
    }
    if (this.mComboUIManager != null) {
      this.mComboUIManager.d();
    }
    if (this.chatPieHelper.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onBackEvent() disableBackForPTV true");
      }
      return false;
    }
    if (((afqy)getHelper(39)).a()) {
      return true;
    }
    ((afst)getHelper(41)).a();
    return finish(0);
  }
  
  public void onChangeMultiScreen(boolean paramBoolean)
  {
    Fragment localFragment = this.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramBoolean) {
      if ((localFragment != null) && (((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
        ((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
      }
    }
    for (;;)
    {
      if (this.listAdapter != null) {
        this.listAdapter.jdField_a_of_type_Boolean = paramBoolean;
      }
      return;
      if ((localFragment != null) && (((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
        ((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
      }
    }
  }
  
  public void onCheckedChanged(ChatMessage paramChatMessage, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)getHelper(15);
    int m;
    int k;
    int j;
    int i;
    int n;
    if (!localAIOLongShotHelper.a()) {
      if (AIOUtils.getAIOMsgMenuDpcConfig(1) == 0)
      {
        m = 1;
        if (m != 0)
        {
          paramChatMessage = awcm.a().jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          k = 0;
          j = 0;
          i = 1;
          if (!paramChatMessage.hasNext()) {
            break label283;
          }
          paramCompoundButton = (Map.Entry)paramChatMessage.next();
          if (!((Boolean)paramCompoundButton.getValue()).booleanValue()) {
            break label264;
          }
          n = k + 1;
          paramCompoundButton = (ChatMessage)paramCompoundButton.getKey();
          k = amrp.a(paramCompoundButton) | j;
          j = i;
          if (m != 0)
          {
            j = i;
            if (i != 0) {
              if (anlo.a(paramCompoundButton))
              {
                j = i;
                if (n <= 1) {}
              }
              else
              {
                j = 0;
              }
            }
          }
          if (j != 0) {
            break label222;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        j = i2;
        label176:
        ((afpb)getHelper(66)).a(i & j);
        i = awcm.a().c();
        ((afsl)getHelper(40)).b(i);
        return;
        m = 0;
        break;
        label222:
        i = n;
      }
      for (;;)
      {
        n = k;
        int i1 = j;
        k = i;
        j = n;
        i = i1;
        break;
        j = 0;
        break label176;
        localAIOLongShotHelper.a(paramChatMessage, paramCompoundButton, paramBoolean);
        return;
        label264:
        n = i;
        i = k;
        k = j;
        j = n;
      }
      label283:
      k = j;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131369068) && (i != 2131369436) && (i != 2131379417) && (i != 2131369874)) {
      AIOUtils.isUserOperatedInAIO = true;
    }
    if ((i != 2131362373) && (i != 2131372779)) {
      ((afqg)getHelper(83)).b(true);
    }
    removeEmoticonGuideBubble();
    handleTitleBarClick(paramView);
    handleInputAreaClick(paramView);
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      alnr.jdField_a_of_type_JavaUtilArrayList.clear();
      this.mReadedCnt = this.listAdapter.getCount();
      if (this.mReadedCnt > 0)
      {
        this.mScrollerRunnable.b();
        this.mScrollerdownRunnable.b();
        this.listView.setSelectionFromBottom(this.listView.getCount() - 1, 0);
      }
      paramView.setVisibility(8);
      ((aftn)getHelper(53)).onClick(paramView);
      continue;
      onSend();
      continue;
      onMsgBoxClick(paramView);
      continue;
      QQAppInterface localQQAppInterface = this.app;
      if (!this.speakerPhoneOn) {}
      for (boolean bool = true;; bool = false)
      {
        localQQAppInterface.setLoudSpeakerState(bool);
        this.mpm.c();
        ((avsq)this.app.getManager(14)).a(this.mpm.a(), this.sessionInfo, this.speakerPhoneOn);
        break;
      }
      ((afqg)getHelper(83)).c();
    }
  }
  
  public void onClickTitleLayout(View paramView) {}
  
  public Dialog onCreateDialog(int paramInt)
  {
    return this.helperProvider.a(paramInt);
  }
  
  public View onCreatePanel(int paramInt)
  {
    Object localObject = this.panelManager.onCreatePanel(paramInt);
    if (localObject != null)
    {
      if ((localObject instanceof PlusPanel)) {
        ((PlusPanel)localObject).setOneWayFriend(isOneWayFriend());
      }
      return localObject;
    }
    long l;
    if (paramInt == 36)
    {
      l = System.currentTimeMillis();
      this.mVoiceTextEditPanel = ((VoiceTextPanel)View.inflate(this.mContext, 2131558665, null));
      this.mVoiceTextEditPanel.a(this.app, this, this.sessionInfo, this.mInputBar, this.panelicons);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "openVoiceTextEditPanel:" + (System.currentTimeMillis() - l));
      }
      return this.mVoiceTextEditPanel;
    }
    if (paramInt == 3)
    {
      l = System.currentTimeMillis();
      this.mEmoPanel = ((EmoticonMainPanel)View.inflate(this.mContext, 2131559130, null));
      this.mEmoPanel.setCallBack(this);
      localObject = this.mEmoPanel;
      if ((isFullScreenMode()) || (this.receiptMode)) {}
      for (boolean bool = true;; bool = false)
      {
        ((EmoticonMainPanel)localObject).onlySysAndEmoji = bool;
        if (isFullScreenMode()) {
          this.mEmoPanel.setHideAllSettingTabs(true);
        }
        this.mEmoPanel.disableMoreEmotionButton = this.receiptMode;
        this.mEmoPanel.disableGuide = this.receiptMode;
        this.mEmoPanel.init(this.app, this.sessionInfo.curType, this.mContext, getTitleBarHeight(), this.defaultEpId, this.defaultPanelType, this);
        if (QLog.isColorLevel()) {
          QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
        }
        return this.mEmoPanel;
      }
    }
    if (paramInt == 2)
    {
      l = System.currentTimeMillis();
      this.mAudioPanel = ((AudioPanel)View.inflate(this.mContext, 2131560910, null));
      this.mAudioPanel.a(this.app, this, this.sessionInfo, this.mInputBar, this.panelicons);
      setLastAudioPanelType(-1);
      if (this.receiptMode) {
        this.mAudioPanel.setReceiptMode(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenAudioPanel:" + (System.currentTimeMillis() - l));
      }
      return this.mAudioPanel;
    }
    if (paramInt == 14)
    {
      if (!isAllowSendFlash()) {
        return null;
      }
      l = System.currentTimeMillis();
      localObject = ((afrt)this.helperProvider.a(7)).a(hashCode());
      this.mFlashPicPanel = agwt.a(this.app, this, this.mInputBar, this.panelicons, true, (Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenFlashPicPanel:" + (System.currentTimeMillis() - l));
      }
      return this.mFlashPicPanel;
    }
    if (paramInt == 5)
    {
      this.panelCamera = new AIOFakePanel(this.mActivity);
      return this.panelCamera;
    }
    if (paramInt == 21)
    {
      this.mApolloPanel = ((ApolloPanel)View.inflate(this.mContext, 2131558588, null));
      this.mApolloPanel.a(this, this.sessionInfo, this.mPkgId, this.mJumpActionId, this.mApolloPanelStatus);
      bfzg.a("apollo_panel_open", null);
      return this.mApolloPanel;
    }
    if (paramInt == 22) {
      return this.mArkController.a();
    }
    if (paramInt == 24)
    {
      this.mHotPicMainPanel = ((HotPicMainPanel)View.inflate(this.mContext, 2131558612, null));
      this.mHotPicMainPanel.a(this.app, this.mContext, this, this.panelicons, this.root);
      return this.mHotPicMainPanel;
    }
    if (paramInt == 18)
    {
      if (this.mDoodlePanel == null)
      {
        this.mDoodlePanel = ((DoodlePanel)View.inflate(this.mContext, 2131558596, null));
        this.mDoodlePanel.a(this.app, this, Long.valueOf(this.sessionInfo.curFriendUin).longValue(), this.sessionInfo.curType, this.root, new BaseChatPie.64(this));
      }
      return this.mDoodlePanel;
    }
    if (paramInt == 28)
    {
      if (this.mRichTextPanel == null)
      {
        this.mRichTextPanel = new RichTextPanel(this.mContext);
        this.mRichTextPanel.a(this);
      }
      return this.mRichTextPanel;
    }
    return null;
  }
  
  public void onDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ((akya)getHelper(4)).a(paramMotionEvent);
  }
  
  protected void onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((!this.isJubaoMode) && (this.app != null))
    {
      paramMotionEvent = ((amaz)this.app.getManager(249)).a();
      if (paramMotionEvent != null) {
        paramMotionEvent.a(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin);
      }
    }
  }
  
  public void onEmotionKeywordDimiss()
  {
    if (this.emotionLayout != null) {
      this.emotionLayout.hide();
    }
    if (this.mApolloViewController != null) {
      this.mApolloViewController.a(true);
    }
    resumeAppShorcutBar();
    if (this.emotionKeywordAdapter != null) {
      this.emotionKeywordAdapter.reportExposeData();
    }
  }
  
  public void onEnterCamera() {}
  
  protected void onEnterReceiptMode() {}
  
  public void onEventComplite()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onEventComplite");
    }
    this.couldTrigerDismissPanel = true;
  }
  
  public void onExpandFullScreen()
  {
    changeCoverVisibility(8);
    afrt localafrt = (afrt)this.helperProvider.a(7);
    if (localafrt != null) {
      localafrt.d();
    }
  }
  
  public void onFullScreenStateChange()
  {
    if (this.root.a() == 3)
    {
      View localView = this.root.a();
      if (((localView instanceof EmoticonMainPanel)) && (localView.getVisibility() == 0)) {
        this.root.a();
      }
    }
  }
  
  public void onHeadsetChanged(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean4)
    {
      if (this.recorder != null) {
        this.recorder.a(paramBoolean1);
      }
      if (!this.mpm.a()) {
        return;
      }
    }
    this.speakerPhoneOn = paramBoolean3;
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioHelper.b(this.app.getApp());
      }
    }
    if (!this.mpm.b()) {
      showPttStatusToast(this.app.getApp(), paramBoolean3, paramBoolean1, paramBoolean4);
    }
    if (this.mpm.a()) {
      if ((paramBoolean1) || (paramBoolean4)) {
        break label130;
      }
    }
    label130:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      updateSpeakerPhoneLayout(paramBoolean2, paramBoolean3);
      if (this.recorder == null) {
        break;
      }
      this.recorder.a(paramBoolean1);
      return;
    }
  }
  
  public void onHideAllPanel()
  {
    this.panelicons.setAllUnSelected();
    this.panelManager.onHideAllPanel();
    if (this.mFakeInput != null) {
      this.mFakeInput.setVisibility(0);
    }
    if (this.mFakeUpInput != null) {
      this.mFakeUpInput.setVisibility(0);
    }
    if ((this.mArkController != null) && (this.root.a() == 22)) {
      this.mArkController.a();
    }
    if (this.mEmoPanel != null) {
      this.mEmoPanel.isHiden = true;
    }
  }
  
  public void onHideFullScreen()
  {
    if (this.receiptMode) {
      changeCoverVisibility(0);
    }
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.listView == null) {
      return true;
    }
    if (((akya)getHelper(4)).b()) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.listView.getChildCount() - 1;
    while (i >= 0)
    {
      paramMotionEvent = this.listView.getChildAt(i);
      if ((paramMotionEvent != null) && ((AIOUtils.getHolder(paramMotionEvent) instanceof afvw)))
      {
        paramMotionEvent = paramMotionEvent.findViewById(2131362940);
        Rect localRect = new Rect();
        paramMotionEvent.getGlobalVisibleRect(localRect);
        if (localRect.contains((int)f1, (int)f2)) {
          return false;
        }
      }
      i -= 1;
    }
    return true;
  }
  
  public void onListScrollChanged(int paramInt)
  {
    if (this.mAnimContainer != null) {
      this.mAnimContainer.c(paramInt);
    }
    ((aftn)getHelper(53)).d(paramInt);
  }
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onMovedToScrapHeap(View paramView)
  {
    if (paramView == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            agkc.a().a(paramView);
            localObject1 = AIOUtils.getHolder(paramView);
          } while (!agpx.class.isInstance(localObject1));
          localObject1 = (agpx)localObject1;
        } while ((((agpx)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(((agpx)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
        localObject2 = (MessageForStructing)((agpx)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForGeneralShare)) || ((!(this.mContext instanceof ChatActivity)) && (!(this.mContext instanceof SplashActivity))));
      if (((StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg).mIsPAVideoStructMsg) {
        bcgr.a().a(paramView, (StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg);
      }
      localObject1 = ((FragmentActivity)this.mContext).getChatFragment().a().getViewCache();
      localObject2 = ((StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg).getLayoutStr();
    } while (localObject1 == null);
    ((agpy)localObject1).a((String)localObject2, (ViewGroup)paramView.findViewById(2131364441));
  }
  
  public void onMsgBoxShow()
  {
    if (this.mComboUIManager != null) {
      this.mComboUIManager.c();
    }
  }
  
  public void onNearToEar(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isActivityResume())
    {
      if (!paramBoolean1) {
        break label41;
      }
      showPttMaskDialog();
    }
    for (;;)
    {
      showPttStatusToast(this.app.getApp(), paramBoolean2, false, false);
      updateSpeakerPhoneLayout(true, paramBoolean2);
      this.speakerPhoneOn = paramBoolean2;
      return;
      label41:
      dismissPttMaskDialog();
    }
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onNetMobile2Wifi readconfirm network change");
    }
    handleReadConfirmMessage();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onNetNone2Mobile readconfirm network change");
    }
    handleReadConfirmMessage();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onNetNone2Wifi readconfirm network change");
    }
    handleReadConfirmMessage();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onNetWifi2Mobile readconfirm network change");
    }
    handleReadConfirmMessage();
  }
  
  public void onNetWifi2None() {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onOverScrollTargetValue()
  {
    if (((akya)getHelper(4)).b()) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while ((this.listAdapter == null) || (this.listView == null));
      i = this.listView.getLastVisiblePosition();
      j = this.listAdapter.getCount() - 1 + this.listView.getFooterViewsCount() + this.listView.getHeaderViewsCount();
      if (QLog.isColorLevel()) {
        QLog.d("MyOnGestureListener", 2, "onOverScrollTargetValue isScrollToButtom=" + this.isOverScrollTarget + "lastPosition=" + i + "toLast=" + j);
      }
    } while ((this.mInputBar == null) || (this.mInputBar.getVisibility() != 0) || (i != j) || (!this.isOverScrollTarget));
    this.root.a(1);
    bcef.b(this.app, "CliOper", "", "", "0X8004454", "0X8004454", 0, 0, "", "", "", "");
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    this.panelManager.onPanelChanged(paramInt1, paramInt2);
    this.uiHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
    if ((paramInt1 == 2) && (paramInt2 != 2)) {
      isStraightPtt = false;
    }
    if (this.mArkController != null) {
      this.mArkController.a(paramInt1, paramInt2);
    }
    boolean bool;
    if (paramInt1 == 24) {
      if (paramInt2 == 1)
      {
        bool = true;
        this.mHotPicMainPanel.a(bool);
        label74:
        if (paramInt2 != 18) {
          break label276;
        }
        if (this.mApolloViewController != null)
        {
          this.mApolloViewController.b();
          this.mApolloViewController.a(false);
        }
        hideAppShortcutBar();
        this.mDoodlePanel.b();
        label113:
        if (paramInt2 != 1) {
          break label337;
        }
        if (this.mChatDrawer != null) {
          this.mChatDrawer.c(false);
        }
      }
    }
    for (;;)
    {
      ((akya)getHelper(4)).a();
      return;
      bool = false;
      break;
      if (paramInt1 == 18)
      {
        if (paramInt2 == 1) {}
        for (bool = true;; bool = false)
        {
          this.mDoodlePanel.a(bool);
          if (this.mApolloViewController != null)
          {
            this.mApolloViewController.a(true);
            this.mApolloViewController.c();
          }
          resumeAppShorcutBar();
          break;
        }
      }
      if (paramInt1 == 3)
      {
        if (this.mEmoPanel == null) {
          break label74;
        }
        if (paramInt2 == 1) {}
        for (bool = true;; bool = false)
        {
          this.mEmoPanel.onHide(bool);
          break;
        }
      }
      if ((paramInt1 != 28) || (this.mRichTextPanel == null)) {
        break label74;
      }
      if (paramInt2 == 1) {}
      for (bool = true;; bool = false)
      {
        this.mRichTextPanel.c(bool);
        break;
      }
      label276:
      if (paramInt2 == 24)
      {
        this.mHotPicMainPanel.f();
        break label113;
      }
      if (paramInt2 == 3)
      {
        if (this.mEmoPanel == null) {
          break label113;
        }
        this.mEmoPanel.onShow();
        break label113;
      }
      if ((paramInt2 != 28) || (this.mRichTextPanel == null)) {
        break label113;
      }
      this.mRichTextPanel.d();
      break label113;
      label337:
      if ((this.mChatDrawer != null) && (!this.root.d())) {
        this.mChatDrawer.c(true);
      }
    }
  }
  
  public void onPanelIconClick(Object paramObject)
  {
    if (this.mIconButtonInInputRight != null)
    {
      this.mZhituSwitch = false;
      this.mIconButtonInInputRight.setActivated(this.mZhituSwitch);
    }
    ahtj.a(this.app).c();
    AIOUtils.isUserOperatedInAIO = true;
    if (!(paramObject instanceof Integer))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, "panel clicked, id: " + paramObject);
      }
      return;
    }
    int i = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("XPanel", 2, "onPanelIconClick panelID=" + i + "currentID=" + this.root.a());
    }
    ((afqg)getHelper(83)).b(true);
    removeEmoticonGuideBubble();
    if ((isFullScreenMode()) && ((i == 2) || (i == 10) || (i == 8))) {
      hideFullScreenInput(false);
    }
    if (i == this.root.a())
    {
      this.root.a();
      return;
    }
    this.panelManager.a(i);
    showPanel(i);
  }
  
  protected void onPhoneStateChange(int paramInt) {}
  
  public void onPlayFailed(int paramInt)
  {
    this.mActivity.setVolumeControlStream(3);
    updateSpeakerPhoneLayout(false, false);
  }
  
  public void onPlayStart()
  {
    updateSpeakerPhoneLayout(true, this.speakerPhoneOn);
    this.mActivity.getWindow().addFlags(128);
  }
  
  public void onPlayStop()
  {
    this.mActivity.setVolumeControlStream(3);
    updateSpeakerPhoneLayout(false, false);
    dismissPttMaskDialog();
    this.mActivity.getWindow().clearFlags(128);
    this.uiHandler.sendEmptyMessageDelayed(25, 1000L);
  }
  
  public void onPlayVolumeChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      bcef.b(this.app, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.uiHandler.removeMessages(25);
      if ((this.mPttPlayVolumeDialog == null) || (!this.mPttPlayVolumeDialog.isShowing()))
      {
        this.mPttPlayVolumeDialog = new bhjt(this.mContext);
        this.mPttPlayVolumeDialog.a(this.mContext.getString(2131697931));
        this.mPttPlayVolumeDialog.show();
      }
    }
    while ((paramInt != 1) || (this.mPttPlayVolumeDialog == null) || (!this.mPttPlayVolumeDialog.isShowing()) || (this.mPttPlayVolumeDialog.getWindow() == null)) {
      return;
    }
    this.mPttPlayVolumeDialog.dismiss();
  }
  
  protected void onPostSetReadConfirm(QQAppInterface paramQQAppInterface)
  {
    this.hasSetReaded = true;
    afdp.a().a(paramQQAppInterface, this.sessionInfo, this.mAnimContainer, this);
  }
  
  public void onPostThemeChanged()
  {
    this.isThemeDefault = ThemeUtil.isDefaultOrDIYTheme(false);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "isThemeDefault" + this.isThemeDefault);
    }
    if ((this.app != null) && (this.mContext != null) && (this.afRoot != null) && (this.sessionInfo.chatBg != null))
    {
      this.sessionInfo.chatBg.jdField_a_of_type_Boolean = false;
      if (aezp.a(this.mContext, this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin, true, 7, this.sessionInfo.chatBg))
      {
        if ((!this.sessionInfo.isQimUserOnline) || (!this.sessionInfo.isQimUserTitleForm) || (this.sessionInfo.isNightMode)) {
          break label279;
        }
        this.afRoot.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849953));
        this.sessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
    }
    for (;;)
    {
      if (this.mCustomTitleView != null) {
        this.mCustomTitleView.d();
      }
      try
      {
        updateUI_titleBarForTheme();
        if (this.mCustomTitleView != null)
        {
          this.mCustomTitleView.a(2130850596, 2130850597);
          this.mCustomTitleView.setRight1Icon(2130850056, 2130850057);
        }
        ((akya)getHelper(4)).b();
        ((afss)getHelper(29)).a(getStatusTxtDartElseLight());
        ArkAppCenterUtil.onThemeChanged();
        bdav.a().b(getActivity(), this.root);
        return;
        label279:
        if ((this.sessionInfo.isTimUserOnline) && (this.sessionInfo.isTimUserTitleForm) && (!this.sessionInfo.isNightMode))
        {
          this.afRoot.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849953));
          this.sessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
          continue;
        }
        this.afRoot.setBackgroundDrawable(this.sessionInfo.chatBg.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d(this.tag, 2, "onPostThemeChanged e:" + localException.getMessage() + "isThemeDefault" + this.isThemeDefault);
        }
      }
    }
  }
  
  public void onPreThemeChanged() {}
  
  public void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    this.helperProvider.a(paramInt, paramDialog);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.helperProvider.a(19);
    int j = this.listView.getFooterViewsCount();
    int k = this.listView.getHeaderViewsCount();
    int i = paramInt3 - k - j;
    int m = i - (paramInt1 - k) - paramInt2;
    if (QLog.isColorLevel()) {
      QLog.i("BaseChatPieOnScroll", 2, "firstVisibleItem = " + paramInt1 + ",visibleItemCount = " + paramInt2 + ",totalItemCount = " + paramInt3 + ",footerCnt = " + j + ",headerCnt = " + k + ",botCnt=" + m);
    }
    Object localObject = (afsd)getHelper(27);
    if (localObject != null) {
      ((afsd)localObject).b(paramInt1);
    }
    doUpdateUnreadBubble(paramInt1, paramInt2, paramInt3, j, k, i, m);
    localObject = afmp.a();
    if (paramAbsListView.getChildAt(0) != null)
    {
      i = paramAbsListView.getChildAt(0).getTop();
      ((afmp)localObject).a(paramInt1, paramInt2, k, j, paramInt3, i, paramAbsListView.getWidth(), paramAbsListView.getHeight());
      if (this.mFirstVisibleItem >= paramInt1) {
        break label326;
      }
      handleScrollOutScreen(this.mFirstVisibleView);
    }
    for (;;)
    {
      this.mFirstVisibleItem = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.mLastVisibleItem = (paramInt1 + paramInt2 - 1);
      }
      this.mFirstVisibleView = paramAbsListView.getChildAt(0);
      this.mLastVisibleView = paramAbsListView.getChildAt(paramInt2 - 1);
      ((afrd)this.helperProvider.a(10)).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      if ((paramInt1 + paramInt2 == paramInt3) && (this.mScrollerRunnable != null)) {
        this.mScrollerRunnable.d();
      }
      return;
      i = 0;
      break;
      label326:
      if ((paramInt1 + paramInt2 - 1 < this.mLastVisibleItem) && (paramInt1 + paramInt2 - 1 > 0)) {
        handleScrollOutScreen(this.mLastVisibleView);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mScrollState = paramInt;
    nrz.a().a(paramAbsListView, paramInt);
    ((bgga)this.app.getManager(235)).a.a(this.listView, this.listAdapter, paramInt);
    if (paramInt == 0)
    {
      ahda.a(false);
      this.listAdapter.b();
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      AbstractVideoImage.resumeAll();
      ApngImage.playByTag(0);
      VasFaceManager.b();
      com.etrump.mixlayout.ETTextView.enableAnimation = true;
      gb.a(this);
      agnj.f();
      ShortVideoRealItemBuilder.f();
      this.mAnimContainer.d();
      bfua.a(this.app);
      ((alnr)this.app.getManager(153)).g();
      ((alnn)this.app.getManager(211)).a(2, this.sessionInfo.curFriendUin, this.sessionInfo.curType);
      ((AvatarPendantManager)this.app.getManager(46)).b();
      if ((this.mBubbleCacheMsgAborted) && (this.uiHandler != null))
      {
        this.mBubbleCacheMsgAborted = false;
        this.uiHandler.removeMessages(16711697);
        paramAbsListView = this.uiHandler.obtainMessage(16711697);
        this.uiHandler.sendMessageDelayed(paramAbsListView, BubbleManager.jdField_a_of_type_Long);
      }
      apec.a().a(this.app, 0);
      almr.a().a(this.app, 0);
      EmojiStickerManager.a().b(this);
      DropFrameMonitor.getInstance().stopMonitorScene("list_aio_" + this.sessionInfo.curType, false);
      DuiButtonImageView.d();
      if (this.dirty == 0) {
        bfth.a().a(this.listView);
      }
      ((bgsw)this.app.getManager(290)).a(this.listView, this.listAdapter);
      this.helperProvider.a(16);
      afmp.a().a(this.mScrollState);
      if (paramInt != 1) {
        break label520;
      }
      resetArkMsgInputState();
      this.helperProvider.a(14);
    }
    for (;;)
    {
      if ((paramInt == 1) && (this.mScrollerRunnable != null)) {
        this.mScrollerRunnable.d();
      }
      return;
      ahda.a(true);
      if (paramInt == 2) {
        this.listAdapter.a();
      }
      for (;;)
      {
        VasFaceManager.a();
        URLDrawable.pause();
        if (!agjt.j)
        {
          AbstractGifImage.pauseAll();
          ApngImage.pauseAll();
          com.etrump.mixlayout.ETTextView.enableAnimation = false;
        }
        AbstractVideoImage.pauseAll();
        agnj.e();
        ShortVideoRealItemBuilder.e();
        this.mAnimContainer.c();
        if (paramInt == 1) {
          hideTroopFCView(false);
        }
        ((AvatarPendantManager)this.app.getManager(46)).a();
        DropFrameMonitor.getInstance().startMonitorScene("list_aio_" + this.sessionInfo.curType);
        DuiButtonImageView.c();
        ((bgsw)this.app.getManager(290)).a();
        break;
        this.listAdapter.b();
      }
      label520:
      if (paramInt == 2) {
        this.helperProvider.a(15);
      }
    }
  }
  
  public void onScrollToButtom(int paramInt)
  {
    if (paramInt < 0)
    {
      this.isVivoScrollToButtom = Boolean.valueOf(true);
      setVivoSetting(1);
      this.isOverScrollTarget = true;
      aftn localaftn = (aftn)getHelper(53);
      if (localaftn != null) {
        localaftn.b(paramInt);
      }
    }
  }
  
  protected void onShow()
  {
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_end", null, false, null);
    AIOUtils.printColorLevelLog(this.tag, "onShow start ", hashCode(), this.mCurrentAIOState);
    bfzg.a(null, "AIO_onShow");
    bfzg.a(null, "AIO_onShow_emotion");
    onShow_EmotionLayout();
    bfzg.a("AIO_onShow_emotion", null);
    onShow_business();
    bfzg.a(null, "AIO_onShow_updateUI");
    onShow_updateUI();
    bfzg.a("AIO_onShow_updateUI", "AIO_onShow_videoStatus");
    onShow_videoStatus();
    bfzg.a("AIO_onShow_videoStatus", "AIO_onShow_report");
    aioEventReport(this.mActivity.getIntent());
    bfzg.a("AIO_onShow_report", "AIO_onShow_otherThings");
    onShow_otherThings();
    bfzg.a("AIO_onShow_otherThings", "AIO_onShow_setReaded");
    onShow_setReaded();
    bfzg.a("AIO_onShow_setReaded", null);
    if ((this.mActivity.getIntent() != null) && (this.mActivity.getIntent().hasExtra("launchApolloGame")) && (this.mActivity.getIntent().getBooleanExtra("launchApolloGame", false))) {
      ((alnn)this.app.getManager(211)).a(this.mActivity.getIntent(), this.sessionInfo.curType);
    }
    if (this.mApolloViewController != null) {
      this.mApolloViewController.d(this);
    }
    bfta.a(false);
    this.helperProvider.a(8);
    bfzg.a("AIO_onShow", null);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "AIOTime onShow end");
    }
    if (this.mRichTextPanel != null) {
      this.mRichTextPanel.b();
    }
    if (this.mComboUIManager == null) {
      this.mComboUIManager = new aqwt(this.app, this.mActivity, this, this.mContent, this.mTroopTips, this.mAnimContainer);
    }
    if (!(this instanceof TroopChatPie)) {
      playGiftAnimationPlayList(true);
    }
    showInputPanelIfNeeded();
    showPlusPanelIfNeeded();
  }
  
  public void onShowFirst(int paramInt)
  {
    this.helperProvider.a(6);
    this.root.setReadyToShow(true);
    bfzg.a("AIO_SysMsgCost", "AIO_onShow_first");
    this.onShowDone = true;
    this.uiHandler.removeCallbacks(this.mRunOnShow);
    AIOUtils.printColorLevelLog(this.tag, "onShowFirst " + paramInt, hashCode(), this.mCurrentAIOState);
    AIOUtils.setIsNotLoadSuit(false);
    setIsPauseRefresh(false);
    refresh(131072);
    updateAddFriendAndShieldView();
    updateInputBarBg();
    chooseChatInputType(this.mActivity.getIntent());
    setOverScrollHandleVisable(true);
    if ((this.sessionInfo.curType == 0) && (bftf.b(this.sessionInfo.curFriendUin))) {
      ThreadManager.executeOnSubThread(new BaseChatPie.58(this), true);
    }
    Object localObject = new BaseChatPie.59(this);
    if (AppSetting.e) {
      ThreadManager.executeOnSubThread((Runnable)localObject, true);
    }
    for (;;)
    {
      if (this.mApolloViewObserver != null) {
        this.mApolloViewObserver.a(false, 0);
      }
      checkInitApolloViewController();
      onShow();
      ambc.a(this.app);
      bfzg.a(null, "AIO_apolloSurface");
      if ((this.isJubaoMode) || (!ifApolloFunAvailThenInit()))
      {
        this.businessFooterDetector.a();
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "remove footerview for initApolloSurfaceView failed");
        }
      }
      updateSession_updatePanel();
      aowk.a().a(this);
      bfzg.a("AIO_apolloSurface", null);
      DuiButtonImageView.a();
      bfzg.a("AIO_onShow_first", null);
      localObject = (VasExtensionHandler)this.app.getBusinessHandler(71);
      ((VasExtensionHandler)localObject).d(this.sessionInfo.curFriendUin);
      ((VasExtensionHandler)localObject).e(this.sessionInfo.curFriendUin);
      if (Build.VERSION.SDK_INT >= 26) {}
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.input, new Object[] { Integer.valueOf(8) });
        CustomizeStrategyFactory.a().a(true);
        PokePanel.a(this.app);
        if (!agkg.b)
        {
          ThreadManager.executeOnSubThread(new BaseChatPie.60(this));
          if (SplashActivity.b != 0)
          {
            acjp.a().a(SplashActivity.b);
            SplashActivity.b = 0;
          }
          gm.a(this.app, getUIHandler(), this.sessionInfo);
          localObject = (bgsw)this.app.getManager(290);
          ((bgsw)localObject).a(this.sessionInfo.curType, this.sessionInfo.curFriendUin);
          ((bgsw)localObject).a(this.listView, this.listAdapter);
          showInputPanelIfNeeded();
          showPlusPanelIfNeeded();
          this.helperProvider.a(7);
          return;
          ((Runnable)localObject).run();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w(this.tag, 2, "disable auto fill error", localException);
          continue;
          if (!ahly.jdField_a_of_type_Boolean) {
            ThreadManager.executeOnSubThread(new BaseChatPie.61(this));
          }
        }
      }
    }
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable)
  {
    if ((paramEmoticonInfo2.type == 6) && ((paramEmoticonInfo2 instanceof PicEmoticonInfo)) && (((PicEmoticonInfo)paramEmoticonInfo2).isSound())) {
      this.mpm.a(true);
    }
  }
  
  public void onShowSubTitleText(boolean paramBoolean, String paramString) {}
  
  protected void onShow_business()
  {
    if (this.needInitTips)
    {
      initTipsTaskList();
      this.needInitTips = false;
    }
    ((aeyb)this.app.getManager(218)).b();
  }
  
  protected void onShow_otherThings()
  {
    adjustTitleDimension();
    blig.a(BaseApplicationImpl.getContext(), new BaseChatPie.56(this), null);
    Intent localIntent = this.mActivity.getIntent();
    if (localIntent == null) {
      QLog.e(this.tag, 1, "onShow_otherThings: intent == null");
    }
    String str;
    do
    {
      return;
      boolean bool = localIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "onShow_otherThings, isPhotoPlusEditSend = " + bool);
      }
      if (bool)
      {
        localIntent.removeExtra("PhotoConst.SEND_FLAG");
        agwt.a(this.mActivity, this.sessionInfo, localIntent);
        if (this.receiptMode) {
          switchReceiptMode();
        }
      }
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.57(this));
      this.app.getQQProxyForQlink().b();
      this.uiHandler.sendEmptyMessageDelayed(31, 800L);
      reportNotificationClick();
      bfua.a(this.app);
      apec.a().a(this.app, 0);
      SignatureManager.a(this.app, this.sessionInfo.curFriendUin, null);
      isPackageExist(BaseApplication.getContext(), "com.vivo.smartshot");
      if (QLog.isColorLevel()) {
        QLog.d("vivo", 2, "isvivo has shot" + isVivoShot);
      }
      if (!DeviceProfileManager.b) {
        getMsgSignalDpcStat();
      }
      AIOUtils.preStartQWebIfNeed(this.app, this, this.listAdapter, null);
      AIOUtils.expandViewTouchDelegate(this.input, (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F), 0, 0);
      AIOUtils.expandViewTouchDelegate(this.mDefaultLeftBack, 0, 0, 0, (int)(50.0F * this.mDensity + 0.5F));
      str = localIntent.getStringExtra("panel");
    } while ((str == null) || (!str.equals("ptv")));
    doShowPtv();
    localIntent.removeExtra("panel");
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      audg.a(this).b(paramInt3);
      return;
    }
    catch (Throwable paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    hideGiftPanel();
    int i = paramMotionEvent.getAction();
    if ((i == 0) && (this.emotionLayout != null) && (this.emotionLayout.getVisibility() == 0))
    {
      this.emotionLayout.hide();
      if (this.mApolloViewController != null) {
        this.mApolloViewController.a(true);
      }
      resumeAppShorcutBar();
    }
    if (this.doutuManager != null) {
      this.doutuManager.b();
    }
    ((afqg)getHelper(83)).b(true);
    removeEmoticonGuideBubble();
    switch (paramView.getId())
    {
    default: 
      return false;
    case 2131370017: 
      if (this.mZhituSwitch)
      {
        ahtj.a(this.app).c();
        this.mIconButtonInInputRight.setImageResource(2130838103);
        this.mIconButtonInInputRight.setSelected(false);
        this.mZhituSwitch = false;
      }
      if ((this.mTroopTips != null) && (this.sessionInfo.curType == 1)) {
        this.mTroopTips.a(paramMotionEvent);
      }
      if (i == 0) {
        this.mpm.b(false);
      }
      for (;;)
      {
        this.mGestureDetector.onTouchEvent(paramMotionEvent);
        return false;
        if ((i == 1) || (i == 3)) {
          this.mpm.b(true);
        }
      }
    case 2131368750: 
      this.input.onTouch(paramView, paramMotionEvent);
      return false;
    }
    handleInputRightButtonTouch(paramView, paramMotionEvent);
    if ((getCurrentPanel() != 28) && (paramMotionEvent.getAction() == 0)) {
      bcef.b(this.app, "CliOper", "", "", "0X80094D1", "0X80094D1", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "listView onViewCompleteVisableAndReleased");
    }
    if (((this.listAdapter != null) && (this.listAdapter.getCount() > 0)) || ((this.sessionInfo.curType == 0) && (!bftf.b(this.sessionInfo.curFriendUin))))
    {
      this.pullReqTime = SystemClock.uptimeMillis();
      ((aezq)this.refreshMessageContext.context).a(this.pullReqTime);
      this.refreshMessageContext.needAutoNavigateTop = false;
      this.refreshMessageContext.needNotifyUI = true;
      if (this.sessionInfo.curType == 1008)
      {
        this.app.getMessageFacade().refreshMessageListHead(this.sessionInfo.curFriendUin, this.sessionInfo.curType, 21, this.refreshMessageContext);
        return true;
      }
      this.app.getMessageFacade().refreshMessageListHead(this.sessionInfo.curFriendUin, this.sessionInfo.curType, 20, this.refreshMessageContext);
      return true;
    }
    setOverScrollHandleVisable(false);
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void onVolumeStreamChanged(int paramInt)
  {
    this.mActivity.setVolumeControlStream(paramInt);
  }
  
  public void openOptionActivity()
  {
    if ((bftf.b(this.sessionInfo.curFriendUin)) && (bftf.a(this.mContext))) {
      return;
    }
    Intent localIntent = new Intent(this.mContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.sessionInfo.curFriendUin);
    localIntent.putExtra("uinname", this.sessionInfo.curFriendNick);
    localIntent.putExtra("uintype", this.sessionInfo.curType);
    this.mActivity.startActivityForResult(localIntent, 2000);
  }
  
  public boolean panelOpened()
  {
    return this.root.a() != 0;
  }
  
  protected void pauseWhenBack()
  {
    afvh.a(2);
    ArkFlashChatContainerWrapper.a(2);
    bfta.a(true);
    this.mAnimContainer.c();
    ((AvatarPendantManager)this.app.getManager(46)).a();
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void playGiftAnimationPlayList(boolean paramBoolean)
  {
    if (((getActivity() instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int != 2)) {
      return;
    }
    beyh localbeyh = (beyh)this.app.getManager(223);
    localbeyh.a(this);
    if (paramBoolean) {
      localbeyh.b();
    }
    localbeyh.a(this.mActivity.getSharedPreferences("AIOAnimationControlManager_limit_key", 4));
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "playTroopGiftAnimationPlayList");
    }
    this.uiHandler.post(new BaseChatPie.88(this, localbeyh, paramBoolean));
  }
  
  public void playMaigcface(Emoticon paramEmoticon, int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.mAudioPanel != null) && (this.mAudioPanel.b() != 1)) {}
    avli localavli;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) && (paramInt == 1) && (this.root != null) && (this.root.a() != 0));
      localavli = avma.a(paramEmoticon, 1);
    } while ((!paramBoolean) && (localavli != null) && (paramInt == 1) && (!localavli.jdField_c_of_type_Boolean));
    getMagicfaceViewController().a(paramEmoticon, paramInt, paramString);
  }
  
  public void playPersonalSound(int paramInt)
  {
    bftt.b(paramInt, false);
  }
  
  public void preStartBaseAIO()
  {
    this.mCurrentAIOState = 2;
    AIOUtils.printColorLevelLog(this.tag, "preStartBaseAIO", hashCode(), this.mCurrentAIOState);
    this.hasDestory = false;
    this.hasSetReaded = false;
    this.isPauseRefresh = false;
    this.isFromOnCreate = true;
    this.hasAutoInput = false;
    this.isOverScrollTarget = false;
    this.onShowDone = false;
    this.chatPieHelper.jdField_a_of_type_Boolean = false;
    this.preCheckBoxVisible = BaseChatItemLayout.jdField_a_of_type_Boolean;
    BaseChatItemLayout.jdField_a_of_type_Boolean = false;
    AIOUtils.setIsNotLoadSuit(false);
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_begin", null, false, null);
    this.mDensity = this.app.getApplication().getResources().getDisplayMetrics().density;
    bfzg.a(null, "AIO_doOnCreate_initUI");
    doOnCreate_initUI();
    bfzg.a("AIO_doOnCreate_initUI", "AIO_doOnCreate_initData");
    doOnCreate_initData();
    bfzg.a("AIO_doOnCreate_initData", "AIO_updateSession");
  }
  
  public void recoderToListen(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    recorderVolumeChange(0);
    if (paramRecorderParam != null) {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label28;
      }
    }
    label28:
    for (int i = 1; i == 0; i = 0)
    {
      bcgn.a(paramString, false);
      return;
    }
    azbu.b(paramString);
  }
  
  public void recorderEnd(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i = 1;
    setRequestedOrientation4Recording(true);
    cancelRemainScreenOn();
    recorderVolumeChange(0);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "recorderEnd() is called");
    }
    this.input.setEnabled(true);
    if (paramRecorderParam != null) {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label66;
      }
    }
    while (i == 0)
    {
      bcgn.a(paramString, false);
      bcgn.a(paramString);
      return;
      label66:
      i = 0;
    }
    azbu.b(paramString);
  }
  
  public void recorderError(String paramString, boolean paramBoolean1, boolean paramBoolean2, QQRecorder.RecorderParam paramRecorderParam)
  {
    cancelSendPttInner(paramString, this.recordingUniseq, paramBoolean2, paramRecorderParam);
    this.mActivity.runOnUiThread(new BaseChatPie.46(this, paramBoolean1));
  }
  
  public void recorderInit(bfyc parambfyc, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (this.uiHandler != null)
    {
      if (this.uiHandler.hasMessages(16711688))
      {
        this.uiHandler.removeMessages(16711688);
        checkOrUpdatePttRecord(0, null, -1L);
      }
      this.uiHandler.removeMessages(16711688);
      this.uiHandler.removeMessages(16711686);
      this.uiHandler.removeMessages(16711687);
    }
    setRequestedOrientation4Recording(false);
    remainScreenOn();
    this.mpm.a(true);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "startRecord() is called");
    }
    this.input.setEnabled(false);
    if (this.recorder == null) {
      this.recorder = new QQRecorder(this.mContext);
    }
    if ((parambfyc != null) && ((parambfyc instanceof PressToSpeakPanel)) && (((PressToSpeakPanel)parambfyc).b()))
    {
      str = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH + "ppt/", true);
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      this.pcmForVadPath = (str + "pcmforvad.pcm");
      this.recorder.a(this.pcmForVadPath);
    }
    this.recorder.a(paramRecorderParam);
    String str = BuddyTransfileProcessor.getTransferFilePath(this.app.getCurrentAccountUin(), null, 2, null, false);
    paramRecorderParam = MessageForPtt.getLocalFilePath(paramRecorderParam.jdField_c_of_type_Int, str);
    if ((str != null) && (!str.equals(paramRecorderParam))) {
      new File(str).deleteOnExit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "path: " + paramRecorderParam);
      }
      this.recorder.a(parambfyc);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
      }
      this.recorder.a(paramRecorderParam, paramBoolean);
      if (this.recordCounts >= 0) {
        this.recordCounts += 1;
      }
      return;
      paramRecorderParam = str;
    }
  }
  
  public void recorderPrepared(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + paramString);
    }
    Object localObject = bfyl.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
    int i;
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
    {
      i = 1;
      if (i != 0) {
        break label127;
      }
      bcgn.a(this.app, paramRecorderParam.jdField_c_of_type_Int, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      bcgn.a(paramString, (byte[])localObject, localObject.length, (short)0);
      label94:
      if (paramString != null)
      {
        if (paramBoolean) {
          break label145;
        }
        this.recordingUniseq = 0L;
        playPersonalSound(2131230745);
        instantUpdate(true, false);
      }
    }
    label145:
    label279:
    for (;;)
    {
      return;
      i = 0;
      break;
      label127:
      azbu.a(paramString);
      azbu.a(paramString, (byte[])localObject, localObject.length);
      break label94;
      if (this.receiptMode)
      {
        localObject = acvv.a(this.app, paramString, this.sessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int);
        paramString = (String)localObject;
        if (localObject != null)
        {
          ((MessageForPtt)localObject).msgVia = this.sessionInfo.entrance;
          azuu.a().a = ((MessageForPtt)localObject);
        }
      }
      for (paramString = (String)localObject;; paramString = acvv.a(this.app, paramString, this.sessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int))
      {
        if (paramString == null) {
          break label279;
        }
        if (i == 0) {
          paramString.setPttStreamFlag(10001);
        }
        this.recordingUniseq = paramString.uniseq;
        paramRecorderParam.d = paramString.vipSubBubbleId;
        paramRecorderParam.e = paramString.vipBubbleDiyTextId;
        playPersonalSound(2131230733);
        break;
      }
    }
  }
  
  public int recorderSetTimeout()
  {
    int i = agkm.a(this.app, "Normal_MaxPtt") * 1000;
    int j = VipUtils.a(this.app, null);
    if ((j & 0x4) != 0) {
      i = agkm.a(this.app, "SVIP_MaxPtt") * 1000;
    }
    for (;;)
    {
      i -= 200;
      this.uiHandler.sendEmptyMessageDelayed(16711687, i);
      return i + 200;
      if ((j & 0x2) != 0) {
        i = agkm.a(this.app, "VIP_MaxPtt") * 1000;
      }
    }
  }
  
  public void recorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (paramInt2 = 1; paramInt2 == 0; paramInt2 = 0)
    {
      bcgn.a(paramString, paramArrayOfByte, paramInt1, (short)0);
      return;
    }
    azbu.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public void recorderTimeTooShort(String paramString)
  {
    checkOrUpdatePttRecord(2, paramString, this.recordingUniseq);
    this.mActivity.runOnUiThread(new BaseChatPie.50(this));
  }
  
  public void recorderVolumeChange(int paramInt)
  {
    this.mActivity.runOnUiThread(new BaseChatPie.49(this, paramInt));
  }
  
  public void refresh(int paramInt)
  {
    refresh(paramInt, null, -1L);
  }
  
  public void refresh(int paramInt, amwf paramamwf, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "refresh with dirty: " + paramInt + " uniseq: " + paramLong + " currentPauseRefreshFlag: " + this.isPauseRefresh);
    }
    if ((this.isPauseRefresh) && (this.dirty == paramInt)) {}
    Message localMessage;
    label297:
    label300:
    label302:
    do
    {
      int i;
      for (;;)
      {
        return;
        i = paramInt & 0xFFFF0000;
        if ((paramInt & 0xFFFF) > (this.dirty & 0xFFFF))
        {
          paramInt &= 0xFFFF;
          this.dirty = (i | paramInt);
          if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "refresh with refreshFlag: " + i + " scrollFlag: " + paramInt);
          }
          if ((!isActivityResume()) && (this.root.a() != 6) && (this.root.a() != 5) && (this.root.a() != 35) && (!blockRefreshJumpBottom())) {
            break label297;
          }
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label300;
          }
          if (i != 262144) {
            break label302;
          }
          localMessage = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", paramLong);
          localMessage.setData(localBundle);
          localMessage.what = 78;
          localMessage.obj = paramamwf;
          localMessage.arg1 = 0;
          this.uiHandler.sendMessageDelayed(localMessage, 400L);
          return;
          paramInt = this.dirty & 0xFFFF;
          break;
        }
      }
      localMessage = new Message();
      localMessage.what = 12;
      if (paramamwf != null) {
        localMessage.obj = paramamwf;
      }
      if (i < 196608) {
        break;
      }
    } while (this.uiHandler.hasMessages(12));
    paramLong = SystemClock.uptimeMillis();
    if (paramLong - this.lastRefreshTime > 1000L)
    {
      this.uiHandler.sendMessage(localMessage);
      return;
    }
    this.uiHandler.sendMessageDelayed(localMessage, 1000L - (paramLong - this.lastRefreshTime));
    return;
    paramamwf = (akya)getHelper(4);
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.mActivity.runOnUiThread(new BaseChatPie.36(this, paramamwf));
    }
    for (;;)
    {
      this.uiHandler.removeMessages(12);
      this.uiHandler.sendMessage(localMessage);
      return;
      if ((!paramamwf.b()) && (this.listAdapter != null)) {
        this.listAdapter.d();
      }
    }
  }
  
  public void refreshHeadMessage(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord)
  {
    refreshHeadMessage(paramInt1, paramLong, paramInt2, paramMessageRecord, 0, 0);
  }
  
  public void refreshHeadMessage(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag + ".troop.special_msg", 2, "refreshHeadMessage==>type = " + paramInt1 + ", value = " + paramLong + ", unreadMsgCount = " + paramInt2 + ", flushType = " + paramInt3);
    }
    long l2 = 0L;
    paramMessageRecord = this.listAdapter.a();
    long l1 = l2;
    if (paramMessageRecord != null)
    {
      paramMessageRecord = paramMessageRecord.iterator();
      ChatMessage localChatMessage;
      do
      {
        l1 = l2;
        if (!paramMessageRecord.hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)paramMessageRecord.next();
      } while (abwz.a(localChatMessage));
      l1 = localChatMessage.shmsgseq;
    }
    paramMessageRecord = new BaseChatPie.37(this);
    this.mScrollerRunnable.b(paramInt3);
    paramInt3 = 0;
    if (this.mTipsMgr.a() == 9) {
      paramInt3 = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag + ".troop.special_msg", 2, "refreshHeadMessage==>fistseq:" + l1 + "|value:" + paramLong + "|type:" + paramInt1);
    }
    if (paramInt3 == 0)
    {
      if (paramInt1 != 1) {
        break label287;
      }
      refreshHeadMessage_unreadMsg(paramLong, l1, paramMessageRecord);
    }
    label287:
    do
    {
      return;
      if (isOtherType(paramInt1))
      {
        refreshHeadMessage_other(paramInt1, paramLong, paramInt2, l1, paramMessageRecord);
        return;
      }
      if (paramInt1 == 22)
      {
        refreshHeadMessage_replyMsg(paramInt1, paramLong, paramInt2, paramInt4, l1, paramMessageRecord);
        return;
      }
      if ((paramInt1 == 17) || (paramInt1 == 10) || (paramInt1 == 100) || (paramInt1 == 11))
      {
        refreshHeadMessage_attention(paramInt1, paramLong, paramInt2, l1, paramMessageRecord);
        return;
      }
    } while (paramInt1 != 103);
    refreshHeadMessage_troopEssenceMsg(paramInt1, paramLong, l1, paramMessageRecord);
  }
  
  public void refreshListAdapter()
  {
    if (this.isPauseRefresh) {}
    do
    {
      do
      {
        return;
      } while ((this.dirty == 0) || (this.listAdapter == null) || (this.listView == null));
      this.hasSetReaded = false;
    } while (android.text.TextUtils.isEmpty(this.sessionInfo.curFriendUin));
    this.listView.setVisibility(0);
    List localList1 = this.listAdapter.a();
    int k = this.listView.getScrollY();
    int m = this.listView.getFirstVisiblePosition();
    int n = this.listView.getHeaderViewsCount();
    int i = this.dirty & 0xFFFF0000;
    List localList2 = refreshListAdapterGetNewMsg(localList1, i);
    int i1 = this.mReadedCnt;
    int i2 = localList1.size();
    int j = localList2.size();
    k = refreshListAdapterScroll(localList1, localList2, k, m - n, i1, i2, j, getScrollFlag(this.dirty & 0xFFFF));
    this.dirty = 0;
    this.lastRefreshTime = SystemClock.uptimeMillis();
    this.mReadedCnt = k;
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "refreshListAdapter, read count: " + this.mReadedCnt + " newsize " + j);
    }
    switch (i)
    {
    }
    for (;;)
    {
      ((afpo)this.helperProvider.a(65)).c();
      if ((k == j) && (!((akya)getHelper(4)).b())) {
        this.listAdapter.d();
      }
      afmp.a().a(localList2);
      return;
      if (this.hasSentRecvMsg)
      {
        this.mTipsMgr.a(1001, new Object[0]);
        this.hasSentRecvMsg = false;
      }
    }
  }
  
  public void refreshListItem(ChatMessage paramChatMessage, int paramInt)
  {
    this.listAdapter.a(paramChatMessage, paramInt);
  }
  
  public void refreshMagicFaceItem()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMagicFaceItem");
    }
    this.listAdapter.notifyDataSetChanged();
  }
  
  public void refreshTitleReativeIcon() {}
  
  protected void removeBusinessObservers()
  {
    if (this.app == null) {
      return;
    }
    this.app.removeObserver(this.cardObserver);
    this.app.removeObserver(this.friendListObserver);
    this.app.removeObserver(this.configObserver);
    this.app.setCheckPttListener(null);
    this.app.setCheckPtvListener(null);
    this.app.getFileManagerNotifyCenter().deleteObserver(this.fmob);
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    this.app.getAVNotifyCenter().deleteObserver(this.mGAudioObserver);
    this.app.removeObserver(this.emoticonObserver);
    this.app.removeObserver(this.cmShowActionObserver);
    this.app.removeObserver(this.mApolloViewObserver);
    this.app.removeObserver(this.mShortVideoObserver);
    if (this.mHiBoomAuthObserver != null) {
      this.app.removeObserver(this.mHiBoomAuthObserver);
    }
    if (this.mHiBoomForwardAuthObserver != null) {
      this.app.removeObserver(this.mHiBoomForwardAuthObserver);
    }
    this.app.removeObserver(this.mFontBubbleObserver);
  }
  
  public void removeEmoticonGuideBubble()
  {
    ((afoi)this.helperProvider.a(54)).b();
  }
  
  public void removeStickerExpandView()
  {
    int i = 0;
    int j;
    View localView;
    if ((this.expandStickerView != null) && (this.listView != null)) {
      if (this.listView.getChildCount() > 0)
      {
        j = this.listView.getFirstVisiblePosition();
        localView = this.listView.getChildAt(0);
        if (localView != null) {
          break label88;
        }
      }
    }
    for (;;)
    {
      this.listView.setSelectionFromTop(j, i);
      if (this.expandStickerView != null) {
        this.listView.removeFooterView(this.expandStickerView);
      }
      this.expandStickerView = null;
      refresh(196608);
      return;
      label88:
      i = localView.getTop();
    }
  }
  
  public void replyMessageAtInput(ChatMessage paramChatMessage)
  {
    replyMessageAtInput(paramChatMessage, 0, 0L, null);
  }
  
  public void replyMessageAtInput(ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null)) {}
    do
    {
      return;
      if (paramLong == 0L) {
        agmk.a(this.app, this.sessionInfo, Long.parseLong(paramChatMessage.senderuin));
      }
      paramString = ahln.a(this.app, paramChatMessage, paramInt, paramLong, paramString);
    } while (paramString == null);
    this.mSourceMsgInfo = paramString;
    if (android.text.TextUtils.isEmpty(this.mSourceMsgInfo.mSourceMsgTroopName))
    {
      paramString = this.mTroopReplyMsgSourceClick;
      paramInt = this.input.getWidth();
      int i = this.input.getPaddingLeft();
      paramString = bevt.a(this.app, this.mActivity, this.mSourceMsgInfo, paramInt - i * 2, this.input.getPaint(), paramString);
      if (paramString == null) {
        break label313;
      }
      this.input.setCompoundDrawables(null, paramString.getDrawable(), null, null);
      this.input.setCompoundDrawablePadding(20);
      this.input.setTag(2131373788, paramString);
      this.mNormalMovementMethod = this.input.getMovementMethod();
      this.input.setMovementMethod(bevs.a());
      disableZhitu();
      hideZhituIcon();
      shouldHideLightVideoBtn(2);
      this.input.setPadding(this.input.getPaddingLeft(), this.input.getPaddingTop(), this.input.getPaddingLeft(), this.input.getPaddingBottom());
      if ((this.mSourceMsgInfo != null) && (!this.app.getCurrentUin().equals(String.valueOf(this.mSourceMsgInfo.mSourceMsgSenderUin)))) {
        createAtMsg(false);
      }
    }
    for (;;)
    {
      this.uiHandler.postDelayed(new BaseChatPie.86(this), 200L);
      MessageForReplyText.reportReplyMsg(this.app, this.sessionInfo, paramChatMessage);
      return;
      paramString = null;
      break;
      label313:
      if (this.mNormalMovementMethod != null) {
        this.input.setMovementMethod(this.mNormalMovementMethod);
      }
    }
  }
  
  public void reportGiftPanelRedDot(int paramInt)
  {
    if (this.mAIOGiftPanelContainer != null) {
      this.mAIOGiftPanelContainer.a(paramInt);
    }
  }
  
  protected void reportSendPttEvent(int paramInt1, int paramInt2)
  {
    bfxf.a(this.app, this.sessionInfo.curType, paramInt1, paramInt2);
  }
  
  public void resetRefreshMessageContext()
  {
    this.refreshMessageContext.isComplete = false;
    this.refreshMessageContext.isLocalOnly = false;
    this.refreshMessageContext.retryIndex = 0;
    this.refreshMessageContext.repullLongMsgIndex = 0;
    this.refreshMessageContext.repullStickerMsgIndex = 0;
    this.canPullRefresh = true;
  }
  
  public void resumeAppShorcutBar()
  {
    afsn localafsn = (afsn)this.helperProvider.a(52);
    if (localafsn != null) {
      localafsn.g();
    }
  }
  
  public void returnMainFragment()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "return MainFragment");
    }
    Object localObject;
    FragmentTransaction localFragmentTransaction;
    if ((this.mActivity instanceof SplashActivity))
    {
      localObject = this.mActivity.getSupportFragmentManager();
      localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      localFragmentTransaction.setCustomAnimations(2130772052, 2130772049);
      SplashActivity.jdField_a_of_type_Int = 1;
      this.mActivity.getIntent().putExtra("isFromAioFragment", true);
      if (localFragment != null)
      {
        localFragmentTransaction.show(localFragment);
        localFragmentTransaction.hide((Fragment)localObject);
        if ((localObject != null) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null))
        {
          if ((!this.sessionInfo.isQimUserOnline) || (!this.sessionInfo.isQimUserTitleForm) || (this.sessionInfo.isNightMode)) {
            break label199;
          }
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        }
        label164:
        localFragmentTransaction.commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      bcer.a().b("ChatFragment");
      return;
      localFragmentTransaction.add(16908290, MainFragment.a(), MainFragment.class.getName());
      break;
      label199:
      if ((this.sessionInfo.isTimUserOnline) && (this.sessionInfo.isTimUserTitleForm) && (!this.sessionInfo.isNightMode))
      {
        ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        break label164;
      }
      ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 450);
      break label164;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 4, "returnMainFragment() mActivity instanceof ChatActivity ");
      }
    }
  }
  
  public void saveChatInputDbIfNeed()
  {
    if ((this.sessionInfo == null) || (this.isSimpleBar)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (amsw)this.app.getManager(51);
          if ((this.sessionInfo.curType != 3000) && (this.sessionInfo.curType != 1)) {
            break;
          }
          localObject = ((amsw)localObject).a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, false);
        } while ((localObject == null) || (!((NoC2CExtensionInfo)localObject).isDataChanged));
        ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.app));
        return;
      } while (!isC2CSession());
      localObject = ((amsw)localObject).a(this.sessionInfo.curFriendUin, false);
    } while ((localObject == null) || (!((ExtensionInfo)localObject).isDataChanged));
    ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.app));
  }
  
  protected void saveTextDraft(SessionInfo paramSessionInfo, avnb paramavnb, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    if (this.input != null)
    {
      Object localObject = (afqj)this.helperProvider.a(24);
      String str = ((afqj)localObject).a(paramSpanned);
      paramSpanned = ((afqj)localObject).a(paramSpanned);
      localObject = this.input.getTag(2131373788);
      ThreadManager.post(new SaveTextDraftJob(this, new SessionInfo(paramSessionInfo), paramavnb, str, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, localObject, paramString2), 8, null, false);
    }
  }
  
  public void scrollToMsgByID(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    this.refreshScrollMsg = paramLong;
    refresh(65552);
  }
  
  public void send()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send start: currenttime:" + System.currentTimeMillis());
    }
    clickSendTextButton();
    if (this.mArkController != null) {
      this.mArkController.c();
    }
  }
  
  public void send(amlu paramamlu)
  {
    paramamlu.a(this.app, this.mActivity, this.input, this.sessionInfo);
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.send(this.app, this.mActivity, this.input, this.sessionInfo);
  }
  
  public void send(String paramString, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (this.receiptMode) {}
    label569:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send start: currenttime:" + System.currentTimeMillis());
      }
      if (android.text.TextUtils.isEmpty(paramString))
      {
        QLog.e("EmojiStickerManager", 1, " send, emojiText is empty");
        return;
      }
      acwc localacwc;
      if ((paramString.length() > 0) && (paramStickerInfo != null))
      {
        this.mSourceMsgInfo = null;
        aydq.a(paramString);
        if (paramString.length() > 3478)
        {
          ChatActivityUtils.a(this.mContext, 2131718135, 1);
          return;
        }
        localacwc = new acwc();
        localacwc.b = this.mMsgSignalCount;
        localacwc.jdField_a_of_type_Int = this.mMsgSignalSum;
        localacwc.jdField_c_of_type_Boolean = this.mIsMsgSignalOpen;
        localacwc.jdField_c_of_type_Int = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        localacwc.jdField_a_of_type_Long = System.currentTimeMillis();
        localacwc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = this.mSourceMsgInfo;
        localacwc.i = this.isSendToRobotServer;
        localacwc.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo = paramStickerInfo;
        this.isSendToRobotServer = false;
        if ((this.sessionInfo.curType == 1) || (this.sessionInfo.curType == 3000))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
          }
          sendMessageInner(paramString, localacwc, new ArrayList());
          reportClassicAndSmallEmoticon(paramString, false, this.mEmoPanel, this.app);
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
          }
          msgReport(this.sessionInfo.entrance, -1);
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " msgReport end currenttime:" + System.currentTimeMillis());
          }
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " send end currenttime:" + System.currentTimeMillis());
          }
          this.mTipsMgr.a(1002, new Object[] { paramString });
          if (this.app.getApplication().getResources().getConfiguration().orientation == 2) {
            bcef.b(this.app, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        if (this.mArkController == null) {
          break label569;
        }
        this.mArkController.c();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
        }
        new ArrayList();
        sendMessageInner(paramString, localacwc, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
        break;
        QLog.e("EmojiStickerManager", 1, " send, sticker info is empty");
      }
    }
  }
  
  public void sendPtt(String paramString, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    ThreadManager.postImmediately(new BaseChatPie.51(this), null, false);
    if (!this.receiptMode)
    {
      sendPttInner(paramString, this.recordingUniseq, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean, paramInt4);
      return;
    }
    azuu.a().a(this.app, this.sessionInfo, paramString, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean);
    getActivity().runOnUiThread(new BaseChatPie.52(this));
  }
  
  protected void sendPttForIME(String paramString1, int paramInt, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    Object localObject = acvv.a(this.app, paramString1, this.sessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int);
    if (localObject != null)
    {
      ((MessageForPtt)localObject).c2cViaOffline = true;
      long l = ((MessageRecord)localObject).uniseq;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      acvv.a(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin, paramString1, l, false, paramInt, paramRecorderParam.jdField_c_of_type_Int, true, 0, 4, false, paramRecorderParam.d, (Bundle)localObject);
      checkOrUpdatePttRecord(0, paramString1, l);
      bcef.b(this.app, "CliOper", "", "", "0X8005B16", "0X8005B16", 0, 0, "", "", paramString2, "8.4.8");
      paramString1 = StatisticCollector.getInstance(BaseApplication.getContext());
      paramRecorderParam = new HashMap();
      paramRecorderParam.put("param_FailCode", String.valueOf(0));
      paramRecorderParam.put("inputname", paramString2);
      paramRecorderParam.put(BaseConstants.RDM_NoChangeFailCode, "");
      paramString1.collectPerformance("", "sendPttEventFromIME", false, 0L, 0L, paramRecorderParam, "");
    }
  }
  
  protected void sendPttInner(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      i = 1;
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label130;
      }
    }
    long l;
    int j;
    String str1;
    Object localObject;
    label130:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l = SystemClock.uptimeMillis();
      j = this.sessionInfo.curType;
      str1 = this.sessionInfo.curFriendUin;
      if (i != 0) {
        break label441;
      }
      localObject = acvv.a(this.app, paramString, this.sessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int);
      if (localObject != null) {
        break label136;
      }
      return;
      i = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool;
    paramLong = ((MessageRecord)localObject).uniseq;
    if ((localObject != null) && (MessageForPtt.class.isInstance(localObject)))
    {
      localObject = (MessageForPtt)localObject;
      ((MessageForPtt)localObject).waveformArray = PttAudioWaveView.a(paramRecorderParam.jdField_a_of_type_ArrayOfInt, paramRecorderParam.f);
      if (!StringUtil.isEmpty(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
        ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
      }
    }
    PttInfoCollector.sPttSendCostRecorder.put(paramString, Long.valueOf(l));
    if (!bool)
    {
      bcgn.a(paramString, false);
      bcgn.a(paramString);
      label241:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + paramLong);
      }
      localObject = this.app;
      if (!isStraightPtt) {
        break label498;
      }
    }
    label441:
    label498:
    for (int i = 1;; i = 2)
    {
      bcef.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", i, 0, "", "", "", "8.4.8");
      isStraightPtt = true;
      i = getAudioPanelType(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      ArrayList localArrayList = new ArrayList();
      String str2 = bevq.a(this.input.getEditableText(), localArrayList);
      acvv.a(this.app, j, str1, paramString, paramLong, false, paramInt2, paramRecorderParam.jdField_c_of_type_Int, bool, paramInt3, i, paramBoolean, paramRecorderParam.d, (Bundle)localObject, localArrayList, str2, false, paramInt4);
      reportSendPttEvent(paramInt1, paramInt2);
      checkOrUpdatePttRecord(0, paramString, paramLong);
      return;
      localObject = this.app.getMessageFacade().getMsgItemByUniseq(str1, 0, paramLong);
      if ((localObject != null) && (MessageForPtt.class.isInstance(localObject))) {
        ((MessageForPtt)localObject).voiceLength = QQRecorder.a(paramInt2);
      }
      break;
      azbu.b(paramString);
      break label241;
    }
  }
  
  public void sendRobotNextMessage(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, int paramInt)
  {
    acwc localacwc = new acwc();
    localacwc.b = this.mMsgSignalCount;
    localacwc.jdField_a_of_type_Int = this.mMsgSignalSum;
    localacwc.jdField_c_of_type_Boolean = this.mIsMsgSignalOpen;
    localacwc.jdField_c_of_type_Int = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    localacwc.jdField_a_of_type_Long = System.currentTimeMillis();
    localacwc.g = paramInt;
    sendMessageInner(paramString, localacwc, paramArrayList);
  }
  
  public void sendSliceDataIfNeeded(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", paramRecorderParam.e);
        bcgn.a(paramString, this.app, this.sessionInfo.curFriendUin, this.recordingUniseq, paramInt, paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.d, localBundle);
      }
      return;
    }
  }
  
  public boolean sessionSupportLightVideo()
  {
    return bnbb.a(this.receiptMode, this.mSourceMsgInfo, this.sessionInfo, this.app);
  }
  
  public BaseActivity setActivity(FragmentActivity paramFragmentActivity)
  {
    this.mActivity = paramFragmentActivity;
    return this.mActivity;
  }
  
  public void setEmotionLayoutInvisible()
  {
    if (this.emotionLayout != null) {
      this.emotionLayout.hide();
    }
  }
  
  public void setEmotionSearchPanelVisible(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, String paramString, int paramInt2)
  {
    if (paramBoolean1)
    {
      if (this.mEmotionSearchPanel == null) {
        this.mEmotionSearchPanel = ((EmotionSearchPanel)View.inflate(this.mContext, 2131558604, null));
      }
      EmoticonPanelHotPicSearchHelper localEmoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper)getEmoPanel().getEmoController().getHelper(7);
      this.mEmotionSearchPanel.showEmotionSearchWindow();
      int i = ScreenUtil.getRealHeight(this.mContext) - paramInt1 - ImmersiveUtils.getStatusBarHeight(this.mContext);
      if (ThemeUtil.isNowThemeIsSimple(this.app, false, null))
      {
        Rect localRect = new Rect();
        this.input.getGlobalVisibleRect(localRect);
        this.mEmotionSearchPanel.init(this.app, this, i, paramBoolean2, paramString, paramInt1 - localRect.bottom, paramInt2, localEmoticonPanelHotPicSearchHelper);
        return;
      }
      paramInt1 = this.panelicons.getHeight();
      int j = this.input.getHeight();
      this.mEmotionSearchPanel.init(this.app, this, i, paramBoolean2, paramString, paramInt1 + j, paramInt2, localEmoticonPanelHotPicSearchHelper);
      return;
    }
    this.mEmotionSearchPanel.onDestory();
  }
  
  public void setFateOfRecorder(int paramInt)
  {
    this.fateOfRecorder = paramInt;
  }
  
  public void setFunBtnEnabled(boolean paramBoolean)
  {
    if (sessionSupportLightVideo()) {}
    for (this.mEnableVideoBtn = LightVideoConfigMgr.a().a();; this.mEnableVideoBtn = false)
    {
      bnbb.a(this.mEnableVideoBtn, paramBoolean, this.mVideoBtn, this.mFunBtn);
      return;
    }
  }
  
  @TargetApi(11)
  public void setInputStat(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, " setInputStat start stat = " + paramInt + " mInputStat= " + this.mInputStat + " currenttime:" + System.currentTimeMillis());
    }
    if (paramInt != this.mInputStat)
    {
      if (paramInt != 1) {
        break label346;
      }
      if (this.mPttBtn == null)
      {
        Button localButton = new Button(this.mContext);
        localButton.setId(2131380935);
        localButton.setBackgroundResource(2130849924);
        localButton.setTextSize(2, 14.0F);
        localButton.setTextColor(this.mContext.getResources().getColorStateList(2131166990));
        localButton.setText(2131689943);
        localButton.setOnTouchListener(this);
        int i = ((ViewGroup)this.input.getParent()).indexOfChild(this.input);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        this.mInputBar.addView(localButton, i, localLayoutParams);
        this.mPttBtn = localButton;
      }
      this.mPttBtn.setVisibility(0);
      if (this.mGagInputBtn != null) {
        this.mGagInputBtn.setVisibility(8);
      }
      this.input.setVisibility(8);
      this.panelicons.setEnable(8, true);
      this.input.setEnabled(true);
      setFunBtnEnabled(true);
      if (VersionUtils.isHoneycomb())
      {
        this.panelicons.setEnable(8, true);
        this.panelicons.setChildAlpha(8, 1.0F);
        this.input.setAlpha(1.0F);
        this.mFunBtn.setAlpha(1.0F);
      }
      this.root.a();
    }
    for (;;)
    {
      this.mInputStat = paramInt;
      updatePanelIconBtnImage();
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, " setInputStat end currenttime:" + System.currentTimeMillis());
      }
      return;
      label346:
      if (paramInt != 2) {
        break;
      }
      doDisableInputStat();
    }
    if (this.mPttBtn != null) {
      this.mPttBtn.setVisibility(8);
    }
    if (this.mGagInputBtn != null) {
      this.mGagInputBtn.setVisibility(8);
    }
    this.input.setVisibility(0);
    if ((this.mExtPanelOnResumeTimes <= 0) || ((this.input.getText().length() > 0) || (getPhotoListSelectCount() > 0))) {
      setFunBtnEnabled(true);
    }
    for (;;)
    {
      this.panelicons.setEnable(8, true);
      this.input.setEnabled(true);
      if (VersionUtils.isHoneycomb())
      {
        this.panelicons.setChildAlpha(8, 1.0F);
        this.input.setAlpha(1.0F);
        this.mFunBtn.setAlpha(1.0F);
      }
      if ((this.input.getText().length() > 0) && (this.mSourceMsgInfo == null) && (!(this instanceof ahgc)) && (atid.a(this.app).b(this.app))) {
        showZhituIcon();
      }
      if (this.mApolloViewController != null) {
        this.mApolloViewController.a(true);
      }
      resumeAppShorcutBar();
      break;
      setFunBtnEnabled(false);
    }
  }
  
  public void setIsFirstShowOpenIdMsg(boolean paramBoolean)
  {
    this.mIsFirstShowOpenIdMsg = paramBoolean;
  }
  
  public void setIsInMultiWindow(boolean paramBoolean)
  {
    if (this.root != null) {
      this.root.setIsInMultiScreen(paramBoolean);
    }
    if (this.listAdapter != null) {
      this.listAdapter.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  protected void setLastAudioPanelType(int paramInt)
  {
    if (this.mAudioPanel == null) {}
    amsw localamsw;
    do
    {
      do
      {
        return;
      } while (this.mIsFromVoiceChangerGuide);
      if (paramInt != -1)
      {
        this.mAudioPanel.setCurrentPannel(paramInt, false);
        return;
      }
      localamsw = (amsw)this.app.getManager(51);
      if ((this.sessionInfo.curType == 3000) || (this.sessionInfo.curType == 1))
      {
        setNoC2CLastAudioPanelType(localamsw);
        return;
      }
    } while (!isC2CSession());
    setC2CLastAudioPanelType(localamsw);
  }
  
  public void setLeftCheckBoxVisible(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    setLeftCheckBoxVisible(paramBoolean1, paramChatMessage, paramBoolean2, false);
  }
  
  public void setLeftCheckBoxVisible(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, boolean paramBoolean3)
  {
    setLeftCheckBoxVisible(paramBoolean1, paramChatMessage, paramBoolean2, paramBoolean3, false);
  }
  
  public void setLeftCheckBoxVisible(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((BaseChatItemLayout.jdField_a_of_type_Boolean == paramBoolean1) && (!paramBoolean4)) {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.tag, 4, "setLeftCheckBoxVisible visible is not change so no need change");
      }
    }
    label228:
    for (;;)
    {
      return;
      if (paramBoolean1)
      {
        BaseChatItemLayout.jdField_a_of_type_Aezl = this;
        this.hasCheckedBoxVisible = true;
        BaseChatItemLayout.jdField_a_of_type_Boolean = paramBoolean1;
        AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)getHelper(15);
        if (!paramBoolean3)
        {
          if (!localAIOLongShotHelper.a()) {
            awcm.a().a(paramChatMessage, paramBoolean1);
          }
          onCheckedChanged(paramChatMessage, null, paramBoolean1);
        }
        if ((paramBoolean1) || (paramBoolean3)) {
          break label120;
        }
        changeCheckBoxHidden(localAIOLongShotHelper);
      }
      for (;;)
      {
        if (paramBoolean2) {
          break label228;
        }
        this.listAdapter.notifyDataSetChanged();
        return;
        BaseChatItemLayout.jdField_a_of_type_Aezl = null;
        break;
        label120:
        this.listAdapter.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        hidePanel();
        if (this.mInputBar.getVisibility() == 0)
        {
          hideBottomBar();
          this.isMultiSelectHideIPB = true;
        }
        paramChatMessage = this.listView.getLayoutParams();
        if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
        {
          paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
          if (this.mListViewBottomMargin == 0) {
            this.mListViewBottomMargin = paramChatMessage.bottomMargin;
          }
        }
        if (this.mUnReadTxt != null) {
          this.mUnReadTxt.setVisibility(8);
        }
        this.mDefautlBtnLeft.setVisibility(8);
        if (this.preCheckBoxVisible) {
          awcm.a().a();
        }
      }
    }
  }
  
  public void setLeftTitleToCancle(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "set left text from cancel");
    }
    this.mTitleLeftText = this.mTitleBtnLeft.getText().toString();
    this.mTitleBtnLeft.setText(2131690600);
    this.mTitleBtnLeft.setBackgroundDrawable(null);
    if (this.mCustomTitleView != null) {
      this.mCustomTitleView.e();
    }
    ((afpb)getHelper(66)).a(paramChatMessage);
    this.mTitleBtnRight.setVisibility(4);
    this.mTitleBtnCall.setVisibility(4);
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)getHelper(15);
    if (localAIOLongShotHelper.a())
    {
      localAIOLongShotHelper.d();
      this.mTitleLayout.setVisibility(4);
      this.mSubTitleLayout.setVisibility(4);
      this.mAIORootView.findViewById(2131369124).setVisibility(4);
    }
    for (;;)
    {
      if (this.panelicons != null) {
        this.panelicons.setCustomHeight(0);
      }
      setLeftCheckBoxVisible(true, paramChatMessage, false);
      return;
      this.mAIORootView.findViewById(2131369124).setVisibility(4);
    }
  }
  
  protected void setList(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    setList(paramList, paramCharSequence, 0);
  }
  
  public void setList(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    this.listAdapter.a(paramList, paramCharSequence, paramInt);
  }
  
  public void setNeedLongScreenShot(Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((!paramIntent.getBooleanExtra("click_long_screen_shot", false)) || (this.listAdapter == null)) {
      return;
    }
    this.listAdapter.jdField_a_of_type_Akyb.a();
  }
  
  protected void setOverScrollHandleVisable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.listView.getOverScrollHeaderView() == null)
      {
        if (this.loadingView == null) {
          this.loadingView = LayoutInflater.from(this.mContext).inflate(2131558939, null);
        }
        this.listView.setOverScrollHeader(this.loadingView);
      }
      return;
    }
    this.listView.setOverscrollHeader((Drawable)null);
    this.listView.setOverScrollHeader((View)null);
  }
  
  protected void setReaded()
  {
    setReaded(this.app);
  }
  
  protected void setReaded(QQAppInterface paramQQAppInterface)
  {
    int i = this.sessionInfo.curType;
    if ((i != 1033) && (i != 1034))
    {
      i = this.app.getConversationFacade().a(this.sessionInfo.curFriendUin, this.sessionInfo.curType);
      bcdm.a(1, 0, this.sessionInfo.curType, i);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "setReaded");
    }
    paramQQAppInterface.getMessageFacade().setReaded(this.sessionInfo.curFriendUin, this.sessionInfo.curType, true, true);
  }
  
  public void setRecyclerListener(AbsListView.RecyclerListener paramRecyclerListener)
  {
    if (this.listView != null) {
      this.listView.setRecyclerListener(paramRecyclerListener);
    }
  }
  
  @TargetApi(13)
  public void setRequestedOrientation4Recording(boolean paramBoolean)
  {
    int i = 0;
    int j = 1;
    if (!paramBoolean)
    {
      this.preRecordOrientation = this.mActivity.getRequestedOrientation();
      int k = this.app.getApplication().getResources().getConfiguration().orientation;
      Object localObject;
      if (!VersionUtils.isrFroyo()) {
        if (k == 1)
        {
          localObject = this.mActivity;
          i = j;
          if (VersionUtils.isGingerBread()) {
            i = 7;
          }
          ((FragmentActivity)localObject).setRequestedOrientation(i);
        }
      }
      label72:
      do
      {
        do
        {
          do
          {
            break label72;
            do
            {
              return;
            } while (k != 2);
            localObject = this.mActivity;
            if (VersionUtils.isGingerBread()) {}
            for (i = 6;; i = 0)
            {
              ((FragmentActivity)localObject).setRequestedOrientation(i);
              return;
            }
            if (VersionUtils.isHoneycombMR2())
            {
              localObject = this.mActivity.getWindowManager().getDefaultDisplay();
              j = ((Display)localObject).getRotation();
              Point localPoint = new Point();
              ((Display)localObject).getSize(localPoint);
              if ((j == 0) || (j == 2)) {
                if (localPoint.x > localPoint.y) {
                  if (j != 0) {}
                }
              }
              for (;;)
              {
                this.mActivity.setRequestedOrientation(i);
                return;
                i = 8;
                continue;
                if (j == 0)
                {
                  i = 1;
                }
                else
                {
                  i = 9;
                  continue;
                  if (localPoint.x > localPoint.y)
                  {
                    if (j != 1) {
                      i = 8;
                    }
                  }
                  else if (j == 1) {
                    i = 9;
                  } else {
                    i = 1;
                  }
                }
              }
            }
            i = this.mActivity.getWindowManager().getDefaultDisplay().getRotation();
            if ((i != 0) && (i != 1)) {
              break;
            }
            if (k == 1)
            {
              this.mActivity.setRequestedOrientation(1);
              return;
            }
          } while (k != 2);
          this.mActivity.setRequestedOrientation(0);
          return;
        } while ((i != 2) && (i != 3));
        if (k == 1)
        {
          this.mActivity.setRequestedOrientation(9);
          return;
        }
      } while (k != 2);
      this.mActivity.setRequestedOrientation(8);
      return;
    }
    this.mActivity.setRequestedOrientation(this.preRecordOrientation);
  }
  
  public void setRightBtnToFinish()
  {
    if (this.mCustomTitleView != null) {
      this.mCustomTitleView.setRightToStr(amtj.a(2131700133), new BaseChatPie.77(this));
    }
    if (this.panelicons != null) {
      this.panelicons.setVisibility(8);
    }
    auww.a(this.app, getActivity().getIntent());
    setLeftCheckBoxVisible(true, null, false, true);
  }
  
  protected void setScrollToMsgseq(long paramLong)
  {
    this.refreshScrollMsg = paramLong;
  }
  
  public void setSendTextMsgParams(acwc paramacwc)
  {
    paramacwc.b = this.mMsgSignalCount;
    paramacwc.jdField_a_of_type_Int = this.mMsgSignalSum;
    paramacwc.jdField_c_of_type_Boolean = this.mIsMsgSignalOpen;
    paramacwc.jdField_c_of_type_Int = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    paramacwc.jdField_a_of_type_Long = System.currentTimeMillis();
    paramacwc.h = audg.a(this).jdField_a_of_type_Boolean;
    if ((this.mSourceMsgInfo != null) && (this.mSourceMsgInfo.mSourceMsgText.length() > MAX_SOURCE_MSG_TEXT_LENGTH))
    {
      this.mSourceMsgInfo.mSourceMsgText = this.mSourceMsgInfo.mSourceMsgText.substring(0, MAX_SOURCE_MSG_TEXT_LENGTH);
      this.mSourceMsgInfo.mSourceSummaryFlag = 0;
      if (this.mSourceMsgInfo.mType == -1036) {
        this.mSourceMsgInfo.oriMsgType = 1;
      }
    }
    paramacwc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = this.mSourceMsgInfo;
  }
  
  protected void setSubTitleText(String paramString)
  {
    this.mSubTilteText.setText(paramString);
  }
  
  public void setSubTitleVisable(boolean paramBoolean)
  {
    this.setSubTitleVisiable = paramBoolean;
    if ((paramBoolean) && (this.mSubTilteText.getVisibility() == 8))
    {
      this.mSubTilteText.setVisibility(0);
      this.mTitleText.setTextSize(1, 17.0F);
    }
    while ((paramBoolean) || (this.mSubTilteText.getVisibility() != 0)) {
      return;
    }
    this.mSubTilteText.setVisibility(8);
    this.mTitleText.setTextSize(1, 17.0F);
  }
  
  public void setSystemBarColor(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
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
  
  public void setSystemBarDrawable(Drawable paramDrawable)
  {
    Object localObject = this.mActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
      if (localObject != null) {
        ((SystemBarCompact)localObject).setStatusBarDrawable(paramDrawable);
      }
    }
  }
  
  protected void setTag()
  {
    this.tag = "BaseChatPie";
  }
  
  public void setTextDraft(DraftTextInfo paramDraftTextInfo)
  {
    if (paramDraftTextInfo != null) {}
    for (Object localObject = paramDraftTextInfo.text;; localObject = "")
    {
      this.mDraftText = ((String)localObject);
      localObject = (afsd)getHelper(27);
      if (((localObject == null) || (!((afsd)localObject).a())) && (this.input != null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, "skip set text draft");
      }
      return;
    }
    if ((paramDraftTextInfo != null) && (paramDraftTextInfo.sourceMsgSeq != 0L))
    {
      this.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo();
      this.mSourceMsgInfo.mSourceMsgTroopName = paramDraftTextInfo.sourceMsgTroopName;
      this.mSourceMsgInfo.mSourceMsgSeq = paramDraftTextInfo.sourceMsgSeq;
      this.mSourceMsgInfo.mSourceMsgText = paramDraftTextInfo.sourceMsgText;
      this.mSourceMsgInfo.mSourceMsgSenderUin = paramDraftTextInfo.sourceSenderUin;
      this.mSourceMsgInfo.mSourceMsgToUin = paramDraftTextInfo.sourceToUin;
      this.mSourceMsgInfo.mSourceMsgTime = paramDraftTextInfo.mSourceMsgTime;
      this.mSourceMsgInfo.mSourceSummaryFlag = paramDraftTextInfo.mSourceSummaryFlag;
      this.mSourceMsgInfo.mType = paramDraftTextInfo.mSourceType;
      this.mSourceMsgInfo.mRichMsg = paramDraftTextInfo.mSourceRichMsg;
      this.mSourceMsgInfo.mAtInfoStr = paramDraftTextInfo.mSourceAtInfoStr;
      this.mSourceMsgInfo.origUid = paramDraftTextInfo.mSourceUid;
      i = this.input.getWidth();
      int j = this.input.getPaddingLeft();
      int k = this.input.getPaddingRight();
      if (android.text.TextUtils.isEmpty(this.mSourceMsgInfo.mSourceMsgTroopName))
      {
        localObject = this.mTroopReplyMsgSourceClick;
        localObject = bevt.a(this.app, this.mActivity, this.mSourceMsgInfo, i - j - k, this.input.getPaint(), (View.OnClickListener)localObject);
        if (localObject != null)
        {
          this.input.setCompoundDrawables(null, ((bevt)localObject).getDrawable(), null, null);
          this.input.setTag(2131373788, localObject);
          this.input.setMovementMethod(bevs.a());
        }
        shouldHideLightVideoBtn(2);
      }
    }
    else
    {
      if (this.mDraftText == null) {
        break label506;
      }
    }
    label506:
    for (boolean bool = true;; bool = false)
    {
      this.hasDraftText = bool;
      if ((paramDraftTextInfo == null) || (paramDraftTextInfo.mixedMsgInfoHtml == null)) {
        break label512;
      }
      ((afqj)this.helperProvider.a(24)).a(paramDraftTextInfo.mixedMsgInfoHtml);
      bgdk.a(paramDraftTextInfo, this.input, this.mDraftText, this.app, getActivity(), this.sessionInfo.curFriendUin);
      if ((!android.text.TextUtils.isEmpty(this.mDraftText)) && (this.mSourceMsgInfo == null) && (!(this instanceof ahgc)) && (atid.a(this.app).b(this.app))) {
        this.uiHandler.postDelayed(new BaseChatPie.14(this), 100L);
      }
      this.input.setSelection(this.input.getText().toString().length());
      this.isBeingInputDraft = false;
      return;
      localObject = null;
      break;
    }
    label512:
    Editable localEditable = this.input.getEditableText();
    int i = this.input.getText().length();
    if (this.mDraftText == null) {}
    for (localObject = "";; localObject = this.mDraftText)
    {
      localEditable.insert(i, (CharSequence)localObject);
      break;
    }
  }
  
  public void setTitleLeftText(String paramString)
  {
    this.mTitleLeftText = paramString;
  }
  
  public void setUnreadTxt()
  {
    Object localObject = new TextView(this.mContext);
    ((TextView)localObject).setId(2131371466);
    ((TextView)localObject).setBackgroundResource(2130838401);
    ((TextView)localObject).setGravity(1);
    ((TextView)localObject).setPadding(0, (int)(2.0F * this.mDensity + 0.5F), 0, 0);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(2, 16.0F);
    ((TextView)localObject).setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(2, 2131368751);
    localLayoutParams.addRule(11);
    localLayoutParams.bottomMargin = ((int)(this.mDensity * 10.0F + 0.5F));
    localLayoutParams.rightMargin = ((int)(this.mDensity * 10.0F + 0.5F));
    this.mContent.addView((View)localObject, localLayoutParams);
    this.mUnReadTxt = ((TextView)localObject);
    ((TextView)localObject).setVisibility(8);
    if (this.mTipRoot != null) {
      this.mContent.bringChildToFront(this.mTipRoot);
    }
    if (this.speakerPhoneLayout != null) {
      ((RelativeLayout.LayoutParams)this.speakerPhoneLayout.getLayoutParams()).addRule(2, 2131371466);
    }
    localObject = (aftn)getHelper(53);
    ((aftn)localObject).a(this.mUnReadTxt);
    ((aftn)localObject).c(this.mUnReadedCnt);
  }
  
  public void setVivoSetting(int paramInt)
  {
    if (isVivoShot == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("vivo", 2, "setVivoSetting isButtom=" + paramInt);
      }
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.82(this, paramInt));
    }
  }
  
  public void setting()
  {
    Intent localIntent = new Intent(this.mContext, EmosmActivity.class);
    localIntent.putExtra("extra_launch_source", 1);
    localIntent.putExtra("extra_launch_mode", 2);
    this.mActivity.startActivity(localIntent);
    bcef.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
  }
  
  public void shouldHideLightVideoBtn(int paramInt)
  {
    if (LightVideoConfigMgr.a().a()) {
      bnbb.a(paramInt, this.mVideoBtn, this.mFunBtn, this.receiptMode, this.mSourceMsgInfo);
    }
  }
  
  public boolean shouldRecordPositionY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "shouldRecordPositionY ");
    }
    this.currentPanelId = this.root.a();
    if (this.currentPanelId == 1)
    {
      if (!((InputMethodManager)this.mContext.getSystemService("input_method")).isActive(this.input))
      {
        this.couldTrigerDismissPanel = false;
        return true;
      }
    }
    else if ((this.currentPanelId == 0) || ((this.root.a() != null) && (this.root.a().getVisibility() != 0)))
    {
      if (this.input.getVisibility() == 0) {
        this.couldTrigerDismissPanel = false;
      }
      return true;
    }
    return false;
  }
  
  public void showAbnormalRecordDlg()
  {
    int j = 0;
    if (((this.mContext instanceof Activity)) && (((Activity)this.mContext).isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "showAbnormalRecordDlg failed, mContext not valid");
      }
      return;
    }
    Object localObject = Build.MANUFACTURER;
    int i;
    if (((String)localObject).equalsIgnoreCase("meizu")) {
      i = 2131697965;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(this.mContext.getString(i));
        if (j == 0) {
          break label247;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.mContext.getResources().getColor(2131165616), this.mContext.getResources().getColor(2131165621)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        bfur.a(this.mContext, amtj.a(2131700129), (CharSequence)localObject, 0, 2131719087, null, null, new BaseChatPie.47(this)).show();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.tag, 2, "show showAbnormalRecordDlg error : " + localException.getMessage());
      return;
      if (localException.equalsIgnoreCase("xiaomi"))
      {
        i = 2131697967;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i = 2131697966;
      }
      else
      {
        i = 2131697964;
        j = 1;
      }
    }
    label247:
    bfur.a(this.mContext, 230, amtj.a(2131700112), localException.toString(), amtj.a(2131700135), "", null, new BaseChatPie.48(this)).show();
  }
  
  protected void showAddFriendAndShield()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "showAddFriendAndShield() ==== called.");
    }
    String str = this.sessionInfo.curFriendUin;
    if (this.sessionInfo.curType == 1006) {
      str = this.sessionInfo.contactUin;
    }
    View localView;
    if (this.linearLayout == null)
    {
      BaseChatPie.9 local9 = new BaseChatPie.9(this);
      this.linearLayout = new LinearLayout(this.mContext);
      this.linearLayout.setId(2131362539);
      this.linearLayout.setVisibility(8);
      this.linearLayout.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.app.getApplication().getResources().getDimension(2131297076));
      localLayoutParams.addRule(3, 2131376501);
      if (!this.isThemeDefault) {
        localLayoutParams.topMargin = 0;
      }
      this.shieldTV = new DrawableCenterTextView(this.mContext);
      if ((this.sessionInfo.curType == 1006) && ((this.sessionInfo.contactUin == null) || (this.sessionInfo.contactUin.equals(""))))
      {
        this.shieldTV.setEnabled(false);
        this.shieldTV.setClickable(false);
        this.shieldTV.setTextSize(0, this.app.getApplication().getResources().getDimension(2131296458));
        this.shieldTV.setCompoundDrawablePadding(AIOUtils.dp2px(8.0F, this.app.getApplication().getResources()));
        this.shieldTV.setOnClickListener(local9);
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
        localLayoutParams1.weight = 1.0F;
        localView = new View(this.mContext);
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(1, -1);
        this.addFriendTv = new DrawableCenterTextView(this.mContext);
        this.addFriendTv.setText(this.mContext.getString(2131689843));
        this.addFriendTv.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131296458));
        if (!this.isThemeDefault) {
          break label817;
        }
        localObject = this.mContext.getResources().getDrawable(2130837980);
        label396:
        this.addFriendTv.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
        this.addFriendTv.setCompoundDrawablePadding(AIOUtils.dp2px(8.0F, this.mContext.getResources()));
        this.addFriendTv.setContentDescription(this.addFriendTv.getText());
        this.addFriendTv.setOnClickListener(local9);
        this.addFriendTv.setTag(Integer.valueOf(3));
        localObject = new LinearLayout.LayoutParams(0, -1);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        if (!this.isThemeDefault) {
          break label834;
        }
        localView.setBackgroundColor(Color.parseColor("#d3d5dc"));
        this.shieldTV.setBackgroundDrawable(this.app.getApplication().getResources().getDrawable(2130838314));
        this.addFriendTv.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838314));
        this.shieldTV.setTextColor(this.app.getApplication().getResources().getColorStateList(2131167089));
        this.addFriendTv.setTextColor(this.mContext.getResources().getColorStateList(2131167089));
        label580:
        this.linearLayout.addView(this.shieldTV, localLayoutParams1);
        this.linearLayout.addView(localView, localLayoutParams2);
        this.linearLayout.addView(this.addFriendTv, (ViewGroup.LayoutParams)localObject);
        this.afRoot.addView(this.linearLayout, localLayoutParams);
      }
    }
    else
    {
      if (!this.isThemeDefault) {
        break label941;
      }
    }
    label941:
    for (Object localObject = this.app.getApplication().getResources().getDrawable(2130838315);; localObject = this.app.getApplication().getResources().getDrawable(2130838318))
    {
      boolean bool = isOneWayFriend();
      if (bool)
      {
        localObject = this.app.getApplication().getResources().getDrawable(2130838004);
        this.shieldTV.setText(this.app.getApplication().getResources().getString(2131718523));
        this.shieldTV.setTag(Integer.valueOf(4));
      }
      this.shieldTV.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      updateShiledStatusAsync(bool, str);
      this.linearLayout.setVisibility(0);
      if (this.mTipRoot != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.mTipRoot.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.mActivity.getResources().getDimension(2131297076) + (int)this.mActivity.getResources().getDimension(2131299076));
        this.mTipRoot.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      this.shieldTV.setEnabled(true);
      this.shieldTV.setClickable(true);
      break;
      label817:
      localObject = this.mContext.getResources().getDrawable(2130837983);
      break label396;
      label834:
      this.shieldTV.setBackgroundDrawable(this.app.getApplication().getResources().getDrawable(2130838313));
      this.addFriendTv.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838313));
      localView.setBackgroundColor(this.mContext.getResources().getColor(2131166448));
      this.shieldTV.setTextColor(this.app.getApplication().getResources().getColorStateList(2131167088));
      this.addFriendTv.setTextColor(this.mContext.getResources().getColorStateList(2131167088));
      break label580;
    }
  }
  
  public void showApolloStatusPanel(int paramInt)
  {
    int i = -1;
    if (paramInt == 0) {
      i = ((alnr)this.app.getManager(153)).b(this.app.getCurrentUin());
    }
    for (;;)
    {
      if (this.mApolloPanel != null) {
        this.mApolloPanel.b(i);
      }
      this.mApolloPanelStatus = i;
      showAvatarPanel();
      return;
      if (paramInt == 1) {
        i = 7;
      }
    }
  }
  
  public void showArkAppManagerPanel()
  {
    this.root.a(30);
  }
  
  public ahpb showArkTips(String paramString, long paramLong)
  {
    if (this.mArkTipsBar == null)
    {
      this.mArkTipsBar = new ahpb(this.mTipsMgr, this.mActivity);
      this.mTipsMgr.a(this.mArkTipsBar);
    }
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = this.tag;
      StringBuilder localStringBuilder = new StringBuilder().append("showArkTips : hide? :");
      if (paramString == null)
      {
        bool = true;
        QLog.d(str, 2, bool + ",mID=" + paramLong);
      }
    }
    else
    {
      if (paramString != null) {
        break label119;
      }
      this.mTipsMgr.a();
    }
    for (;;)
    {
      return this.mArkTipsBar;
      bool = false;
      break;
      label119:
      this.mTipsMgr.a(this.mArkTipsBar, new Object[] { paramString, Long.valueOf(paramLong) });
    }
  }
  
  public void showAudioPanel(boolean paramBoolean)
  {
    this.root.a(2, paramBoolean);
  }
  
  protected void showAudioPanelIfNeed(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (BaseChatItemLayout.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (!this.isSimpleBar)
      {
        amsw localamsw = (amsw)this.app.getManager(51);
        if (!localamsw.d())
        {
          ThreadManager.executeOnSubThread(new BaseChatPie.80(this));
          return;
        }
        long l = System.currentTimeMillis();
        if ((this.sessionInfo.curType == 3000) || (this.sessionInfo.curType == 1)) {
          showAudioPanelIfNeedForNoC2C(localamsw, paramBoolean1, paramBoolean2);
        }
        while (QLog.isColorLevel())
        {
          QLog.d(this.tag, 2, "showAudioPanelIfNeed cost :" + (System.currentTimeMillis() - l) + " isCallFromOnShow = " + paramBoolean1 + " guide = " + paramBoolean2);
          return;
          showAudioPanelIfNeedForC2C(localamsw, paramBoolean1, paramBoolean2);
        }
      }
    }
  }
  
  public void showAvatarPanel()
  {
    if (this.root != null)
    {
      this.root.a(21);
      if ((this.app != null) && (this.sessionInfo != null))
      {
        alnr localalnr = (alnr)this.app.getManager(153);
        if ((localalnr.b(this.app.getCurrentUin()) == 0) || (localalnr.b(this.app.getCurrentUin()) == 2)) {
          VipUtils.a(this.app, "cmshow", "Apollo", "panel_close_show", localalnr.b(this.app.getCurrentUin()), ApolloUtil.h(alnr.a(this.app)), new String[] { "" + ApolloUtil.b(this.sessionInfo.curType) });
        }
        if (this.mApolloPanel != null)
        {
          int i = this.mApolloPanel.b();
          if (i != -1) {
            VipUtils.a(this.app, "cmshow", "Apollo", "game_show", ApolloUtil.b(this.sessionInfo.curType), 0, new String[] { Integer.toString(i) });
          }
        }
      }
    }
  }
  
  public void showBottomBar()
  {
    this.mInputBar.setVisibility(0);
    this.mBottomBlurView.setVisibility(0);
    if ((this.panelicons != null) && (!(this instanceof ahiu))) {
      this.panelicons.setCustomHeight(PanelIconLinearLayout.b);
    }
    ((afss)getHelper(29)).c();
    if (this.mFakeInput != null) {
      this.mFakeInput.setVisibility(0);
    }
    if (this.mFakeUpInput != null) {
      this.mFakeUpInput.setVisibility(0);
    }
  }
  
  public void showC2BTips()
  {
    if (this.mC2BTipsBar == null)
    {
      this.mC2BTipsBar = new ahpe(this.mActivity, this.mTipsMgr);
      this.mTipsMgr.a(this.mC2BTipsBar);
    }
    this.mC2BTipsBar.a(this.sessionInfo.curFriendUin);
  }
  
  public void showCameraPanel(int paramInt)
  {
    Object localObject = FlowCameraActivity2.class;
    if (bbub.d(bbub.c)) {
      localObject = MX3FlowCameraActivity.class;
    }
    localObject = new Intent(this.mContext, (Class)localObject);
    ((Intent)localObject).putExtra("flow_camera_height", XPanelContainer.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("selected_item", 5);
    ((Intent)localObject).putExtra("selected_data", this.panelicons.a());
    ((Intent)localObject).putExtra("PhotoConst.SEND_SESSION_INFO", this.sessionInfo);
    ((Intent)localObject).putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
    ((Intent)localObject).putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
    this.chatPieHelper.c((Intent)localObject);
    if (((this.sessionInfo.curType == 1) && (nmy.a().a(this.sessionInfo.curFriendUin))) || (this.sessionInfo.curType == 1010) || (this.sessionInfo.curType == 1001) || (this.sessionInfo.curType == 10002)) {
      ((Intent)localObject).putExtra("flow_camera_capture_mode", true);
    }
    if (paramInt == 1) {
      ((Intent)localObject).putExtra("flow_camera_capture_mode", true);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("flow_camera_use_filter_function", bbxj.a(this.app, BaseApplicationImpl.getContext()));
      this.mActivity.startActivityForResult((Intent)localObject, 11000);
      agwt.a(this.app, "0X8005E7D", this.sessionInfo.curType);
      if (MediaPlayerManager.a(this.app).a()) {
        MediaPlayerManager.a(this.app).a(false);
      }
      if (bkkh.a != null) {
        bkkh.a.b();
      }
      return;
      if (paramInt == 2) {
        ((Intent)localObject).putExtra("flow_camera_video_mode", true);
      }
    }
  }
  
  public void showEmoticonPanel(int paramInt)
  {
    long l = System.currentTimeMillis();
    if ((this.mEmoPanel != null) && (this.mEmoPanel.getVisibility() == 0))
    {
      this.mEmoPanel.initEmoticonView(paramInt);
      this.root.a(3);
    }
    for (;;)
    {
      this.defaultPanelType = -1;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l));
      }
      return;
      if (this.mEmoPanel == null)
      {
        this.defaultPanelType = paramInt;
        this.root.a(3);
        if (this.mEmoPanel != null) {
          this.mEmoPanel.preloadWebProcess();
        }
      }
      else
      {
        this.mEmoPanel.initEmoticonView(paramInt);
        this.root.a(3);
        this.mEmoPanel.preloadWebProcess();
      }
    }
  }
  
  public void showEmoticonPanel(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((this.mEmoPanel != null) && (this.mEmoPanel.getVisibility() == 0))
    {
      this.mEmoPanel.initEmoticonView(paramString);
      this.root.a(3);
    }
    for (;;)
    {
      this.defaultEpId = null;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l));
      }
      return;
      if (this.mEmoPanel == null)
      {
        this.defaultEpId = paramString;
        this.root.a(3);
        if (this.mEmoPanel != null) {
          this.mEmoPanel.preloadWebProcess();
        }
      }
      else if (paramString != null)
      {
        this.mEmoPanel.initEmoticonView(paramString);
        this.root.a(3);
        this.mEmoPanel.preloadWebProcess();
      }
    }
  }
  
  public void showGiftPanel(boolean paramBoolean)
  {
    showGiftPanel(paramBoolean, TroopGiftPanel.e);
  }
  
  public void showGiftPanel(boolean paramBoolean, int paramInt)
  {
    if (aqhd.a().isEnable())
    {
      GiftJsPlugin.openGiftBrowser(getActivity(), this.sessionInfo.troopUin);
      return;
    }
    if (this.mAIOGiftPanelContainer == null) {
      this.mAIOGiftPanelContainer = new zsj(this);
    }
    this.mAIOGiftPanelContainer.a(paramBoolean, paramInt);
  }
  
  public void showInputPanel()
  {
    if (this.root != null) {
      this.root.a(1);
    }
  }
  
  public void showManagerFavEmoticonTips()
  {
    String str = this.mContext.getString(2131689610);
    bfur.a(this.mContext, 230, null, str, 2131691986, 2131691985, new BaseChatPie.65(this), new BaseChatPie.66(this)).show();
  }
  
  public void showNearPeopleOperDialog(String paramString)
  {
    if (this.addFriendDialog == null)
    {
      this.addFriendDialog = amuu.a(this.mContext, paramString, new BaseChatPie.81(this), null);
      if (this.addFriendDialog != null) {
        ((TextView)this.addFriendDialog.findViewById(2131365547)).setText(this.mContext.getString(2131694201));
      }
    }
    if ((this.addFriendDialog != null) && (!this.addFriendDialog.isShowing()) && (!this.mActivity.isFinishing()))
    {
      ((TextView)this.addFriendDialog.findViewById(2131365552)).setText(paramString);
      this.addFriendDialog.show();
    }
  }
  
  public void showPlusItemPanel(int paramInt)
  {
    this.root.a(paramInt);
  }
  
  public void showPokePanel()
  {
    String str = agkg.a(this.app);
    if ((android.text.TextUtils.isEmpty(str)) || ((agkg.b(this.app, 1) == 0) && (agkg.b(this.app, 0) == 0)) || (bily.c(this.app, this.sessionInfo.curFriendUin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("pokeMsg", 2, "pokePanelInfo " + str + ", " + agkg.b(this.app, 1) + ", " + agkg.b(this.app, 0) + ", " + bily.c(this.app, this.sessionInfo.curFriendUin));
      }
      acvv.b(this.app, BaseApplicationImpl.getContext(), this.sessionInfo);
    }
    do
    {
      return;
      agkg.d(this.app);
      if (!PokePanel.jdField_c_of_type_Boolean) {
        break;
      }
      if (this.root != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("pokeMsg", 2, "show pokePanel");
        }
        this.root.a(23);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("pokeMsg", 2, "XPanel is null");
    return;
    PokePanel.a(this.app);
    acvv.b(this.app, BaseApplicationImpl.getContext(), this.sessionInfo);
  }
  
  public void showProgressDialog(int paramInt)
  {
    if (this.mProgressDialog == null) {
      this.mProgressDialog = new bhht(this.mContext, getTitleBarHeight());
    }
    this.mProgressDialog.c(paramInt);
    this.mProgressDialog.show();
  }
  
  public void showPttMaskDialog()
  {
    if (this.pttMaskDialog == null)
    {
      this.pttMaskDialog = new ReportDialog(this.mContext, 2131755174);
      ImageView localImageView = new ImageView(this.mContext);
      localImageView.setBackgroundResource(2130838100);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localImageView.startAnimation(localAlphaAnimation);
      this.pttMaskDialog.setContentView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    try
    {
      if (!this.mActivity.isFinishing()) {
        this.pttMaskDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.tag, 1, "showPttMaskDialog", localException);
    }
  }
  
  public void showPttStatusToast(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = bfxd.b(paramBoolean1, paramBoolean2, paramBoolean3);
    int j = bfxd.a(paramBoolean1, paramBoolean2, paramBoolean3);
    if ((i > 0) && (this.playMode != j))
    {
      this.playMode = j;
      QQToast.a(paramContext, i, 0).b(paramContext.getResources().getDimensionPixelSize(2131299076));
    }
  }
  
  public void showScribblePanel()
  {
    if (this.root == null) {
      return;
    }
    this.root.a(18);
  }
  
  public void showStickerBubbleQuickButtonIfNeeded(@Nullable String paramString)
  {
    if ((this.sessionInfo.curType != 0) || (!agkg.c(this.app)) || (this.receiptMode)) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        i = agkg.b(this.app, 9);
        j = agkg.b(this.app, 4);
        int k = agkg.b(this.app, 11);
        QLog.d(this.tag, 2, String.format("showStickerBubbleQuickButtonIfNeeded  peInputSwitch :%dentryType:%d,viewType:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      }
      str = paramString;
      if (paramString == null) {
        str = this.input.getText().toString();
      }
    } while ((!str.isEmpty()) || (ahlz.a(this.app.getCurrentUin()) <= 0));
    this.mIconLayoutInInputRight.setVisibility(0);
    this.mIconButtonInInputRight.setImageDrawable(ahlz.a(this.app.getCurrentUin()));
    int j = this.mIconLayoutInInputRight.getWidth();
    if (j == 0) {}
    for (int i = AIOUtils.dp2px(37.0F, this.mActivity.getResources());; i = j)
    {
      if (this.input.getPaddingRight() < i) {
        this.input.setPadding(this.input.getPaddingLeft(), this.input.getPaddingTop(), i, this.input.getPaddingBottom());
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("ZhituManager", 4, "showZhituIcon.rightPadding." + i + " ,pr = " + j + ",input.getPaddingRight() = " + this.input.getPaddingRight());
      }
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.mIconButtonInInputRight.setContentDescription(amtj.a(2131700111) + ahly.a(ahlz.a(this.app.getCurrentUin())));
      }
      if (this.mStickerBubbleQuickButtonReported) {
        break;
      }
      bcef.b(getApp(), "dc00898", "", "", "0X8009272", "0X8009272", ahlz.a(this.app.getCurrentUin()), 0, "", "", "", "");
      this.mStickerBubbleQuickButtonReported = true;
      return;
    }
  }
  
  public boolean showTimTips()
  {
    if (this.mTimTipsBar == null)
    {
      this.mTimTipsBar = new ahqp(this.app, this.mActivity, this.mTipsMgr);
      this.mTipsMgr.a(this.mTimTipsBar);
    }
    return this.mTipsMgr.a(this.mTimTipsBar, new Object[0]);
  }
  
  public void showVoiceEditPanel(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.root.a(36);
    if (this.mVoiceTextEditPanel != null) {
      this.mVoiceTextEditPanel.setParam(paramString, paramRecorderParam, paramInt, this.pcmForVadPath);
    }
  }
  
  protected void showZhituAfterDraft() {}
  
  public void showZhituIcon()
  {
    if (bbyp.b()) {
      break label6;
    }
    label6:
    while ((!((afqx)getHelper(18)).a(this.mContext, this.input.getText().toString(), this.input)) || (this.mIconLayoutInInputRight == null)) {
      return;
    }
    if (this.mIconLayoutInInputRight.getVisibility() != 0)
    {
      this.mIconLayoutInInputRight.setVisibility(0);
      this.mZhituSwitch = false;
    }
    this.mIconButtonInInputRight.setImageResource(2130838103);
    this.mIconButtonInInputRight.setContentDescription(amtj.a(2131700118));
    int j = this.mIconLayoutInInputRight.getWidth();
    if (j == 0) {}
    for (int i = AIOUtils.dp2px(37.0F, this.mActivity.getResources());; i = j)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ZhituManager", 4, "showZhituIcon.rightPadding." + i + " ,pr = " + j + ",input.getPaddingRight() = " + this.input.getPaddingRight());
      }
      if (this.input.getPaddingRight() < i) {
        this.input.setPadding(this.input.getPaddingLeft(), this.input.getPaddingTop(), i, this.input.getPaddingBottom());
      }
      if (this.mZhituButtonExposeReported) {
        break;
      }
      bcef.b(getApp(), "dc00898", "", "", "0X800932B", "0X800932B", 0, 0, "", "", "", "");
      this.mZhituButtonExposeReported = true;
      return;
    }
  }
  
  protected boolean showorhideAddFriend()
  {
    return false;
  }
  
  protected void startChatAndSendMsg(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle(paramBundle));
    updateSession_forwardType(localIntent, false);
  }
  
  public void startDelAnim(ChatMessage paramChatMessage)
  {
    int i = this.listAdapter.a(paramChatMessage) + this.listView.getHeaderViewsCount();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i);
    }
    if (i < 0) {
      return;
    }
    int j = this.listView.getFirstVisiblePosition();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + (i - j) + ",firstPos is:" + j + ",pos is:" + i);
    }
    refresh(196613);
  }
  
  public void startDelAnimAndDelMsg(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "start del anim,uniseq is:" + paramChatMessage.uniseq + ",id is:" + paramChatMessage.getId() + ",time is:" + System.currentTimeMillis());
    }
    long l1 = System.currentTimeMillis();
    ThreadManager.post(new BaseChatPie.76(this, paramChatMessage), 8, null, true);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "removeMsgByMessageRecord cost time is:" + (l2 - l1));
    }
  }
  
  public void startMulDelAnimAndDelMsg(List<ChatMessage> paramList)
  {
    this.app.getMessageFacade().removeMultiMsgByMessageRecord(paramList, false);
    refresh(196613);
  }
  
  public void startShakeAnim()
  {
    ((afpo)this.helperProvider.a(65)).a();
  }
  
  public void stickerEditMode(boolean paramBoolean)
  {
    setIsPauseRefresh(paramBoolean);
  }
  
  public void stopAudioRecord(int paramInt)
  {
    if ((this.recorder != null) && (!this.recorder.b()) && (!this.uiHandler.hasMessages(16711686)))
    {
      this.uiHandler.removeMessages(16711688);
      this.uiHandler.removeMessages(16711686);
      this.uiHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.fateOfRecorder = paramInt;
      Message localMessage = this.uiHandler.obtainMessage(16711686);
      this.uiHandler.sendMessageDelayed(localMessage, 200L);
    }
  }
  
  public void stopPttPlayingAndHideUI()
  {
    if (this.mpm != null)
    {
      this.mpm.a(this.listView);
      this.mpm.a(true);
      updateSpeakerPhoneLayout(false, false);
    }
  }
  
  public boolean supportRefreshHeadMessage()
  {
    return ((this instanceof TroopChatPie)) || ((this instanceof afim));
  }
  
  public void switchPhotoListFilterForReceiptMode(boolean paramBoolean)
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.panelManager.a(4);
    if (localPhotoListPanel == null) {
      return;
    }
    localPhotoListPanel.setReceiptMode(paramBoolean, this.app);
    if (paramBoolean)
    {
      localPhotoListPanel.setSelectLimitListener(new BaseChatPie.90(this));
      return;
    }
    localPhotoListPanel.setSelectLimitListener(null);
  }
  
  public void switchReceiptMode()
  {
    String str1;
    if ((!this.receiptMode) && (azux.b(this.app) <= 0))
    {
      str1 = getActivity().getString(2131697944);
      QQToast.a(getActivity(), str1, 0).b(getActivity().getResources().getDimensionPixelSize(2131299076));
      bcef.b(this.app, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
      return;
    }
    int i;
    if (!this.receiptMode)
    {
      bool = true;
      this.receiptMode = bool;
      ((afqg)getHelper(83)).b(true);
      removeEmoticonGuideBubble();
      if (!this.receiptMode) {
        break label578;
      }
      if ((this.mIconLayoutInInputRight != null) && (this.mIconLayoutInInputRight.getVisibility() == 0)) {
        hideZhituIcon();
      }
      onEnterReceiptMode();
      this.root.a(1);
      this.panelicons.a(true);
      changeCoverVisibility(0);
      i = azux.b(this.app);
      str1 = String.valueOf(i);
      if (i >= 4) {
        break label542;
      }
      String str2 = String.format(getActivity().getString(2131697958), new Object[] { str1 });
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.getContext().getResources().getColor(2131167139)), str2.length() - str1.length() - 2, str2.length() - 2, 18);
      this.tvReceiptTips.setText(localSpannableString);
      label281:
      i = BaseApplicationImpl.getContext().getResources().getColor(2131167140);
      this.tvReceiptTips.setTextColor(i);
      this.input.setCompoundDrawables(null, null, null, null);
      this.input.setTag(2131373788, null);
      amat.a(this.app, "receipt_msg", true);
      hideAppShortcutBar();
      if (this.sessionInfo.curType != 0) {
        break label555;
      }
      i = 1;
      label351:
      bcef.b(this.app, "CliOper", "", "", "0x80083E8", "0x80083E8", i, 0, "", "", "", "");
      label387:
      switchPhotoListFilterForReceiptMode(this.receiptMode);
      if (this.mEmoPanel != null)
      {
        this.mEmoPanel.onlySysAndEmoji = this.receiptMode;
        this.mEmoPanel.disableMoreEmotionButton = this.receiptMode;
        this.mEmoPanel.disableGuide = this.receiptMode;
        if (!this.receiptMode) {
          this.mEmoPanel.disableGuideOneTime = true;
        }
        this.mEmoPanel.init(this.app, this.sessionInfo.curType, this.mContext, getTitleBarHeight(), this.defaultEpId, this.defaultPanelType, this);
      }
      if (this.mAudioPanel != null)
      {
        this.needRecreateAudioPanel = true;
        this.mAudioPanel = null;
      }
      shouldHideLightVideoBtn(1);
      if ((this.input.getText().length() <= 0) && (getPhotoListSelectCount() <= 0)) {
        break label635;
      }
    }
    label542:
    label555:
    label578:
    label635:
    for (boolean bool = true;; bool = false)
    {
      setFunBtnEnabled(bool);
      return;
      bool = false;
      break;
      this.tvReceiptTips.setText(2131697957);
      break label281;
      if (this.sessionInfo.curType == 3000)
      {
        i = 2;
        break label351;
      }
      i = 3;
      break label351;
      hideAllPanels();
      this.panelicons.a(this.app, this.sessionInfo, this);
      changeCoverVisibility(8);
      this.input.getText().clear();
      this.mContent.post(new BaseChatPie.89(this));
      break label387;
    }
  }
  
  public void turnOffShake() {}
  
  public void turnOnShake() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (preCheckUpdate(paramObject)) {}
    do
    {
      return;
      if ((paramObject instanceof MessageRecord))
      {
        branchUpdateMessage(paramObject);
        return;
      }
      if ((paramObject instanceof QQMessageFacade.RefreshMessageContext))
      {
        branchUpdateRefreshMessageContext(paramObject);
        return;
      }
    } while (!(paramObject instanceof QQMessageFacade.MessageNotifyParam));
    branchUpdateMessageNotifyParam(paramObject);
  }
  
  public void updateAddFriendAndShieldView()
  {
    if (showorhideAddFriend())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView true");
      }
      showAddFriendAndShield();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView false");
    }
    hideAddFriendAndShield();
  }
  
  protected void updateFriendNick()
  {
    this.sessionInfo.curFriendNick = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
  }
  
  public void updateInputBarBg()
  {
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.mInputBar.findViewById(2131377546);
      ((View)localObject).setBackgroundResource(2130839144);
      ((View)localObject).setVisibility(0);
      localObject = this.mInputBar.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
      return;
    }
    Object localObject = this.mInputBar.getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setVisible(true, false);
    }
    this.mInputBar.findViewById(2131377546).setVisibility(8);
  }
  
  protected void updateListUnRead(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.tag, 2, "updateListUnRead: " + paramInt);
    }
    if ((paramInt == 0) && (this.mUnReadTxt != null))
    {
      this.mUnReadTxt.setText(Integer.toString(paramInt));
      this.mUnReadTxt.setVisibility(8);
    }
    while (paramInt <= 0)
    {
      if ((this.mUnReadTxt != null) && (BaseChatItemLayout.jdField_a_of_type_Boolean)) {
        this.mUnReadTxt.setVisibility(8);
      }
      return;
    }
    if (this.mUnReadTxt == null) {
      setUnreadTxt();
    }
    TextView localTextView = this.mUnReadTxt;
    if (paramInt > 99) {}
    for (String str = "99";; str = Integer.toString(paramInt))
    {
      localTextView.setText(str);
      this.mUnReadTxt.setVisibility(0);
      ((aftn)getHelper(53)).a();
      break;
    }
  }
  
  protected void updateOnlineStatus() {}
  
  @TargetApi(11)
  protected void updatePanelIconBtnImage()
  {
    if (this.mInputStat == 1) {
      if (this.panelicons != null)
      {
        this.panelicons.setAllEnable(true);
        if (VersionUtils.isHoneycomb()) {
          this.panelicons.setAllAlpha(1.0F);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.mInputStat != 2) {
              break;
            }
          } while (this.panelicons == null);
          this.panelicons.setAllEnable(false);
        } while (!VersionUtils.isHoneycomb());
        this.panelicons.setAllAlpha(0.6F);
        return;
      } while (this.panelicons == null);
      this.panelicons.setAllEnable(true);
    } while (!VersionUtils.isHoneycomb());
    this.panelicons.setAllAlpha(1.0F);
  }
  
  protected void updatePanelIconStatus()
  {
    int i = this.root.a();
    if (this.panelicons != null)
    {
      if (i == 1) {
        this.panelicons.setAllUnSelected();
      }
    }
    else {
      return;
    }
    if (i == 21)
    {
      if (this.sessionInfo.curType != 1) {
        break label195;
      }
      HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(60);
      if ((localHotChatManager != null) && (localHotChatManager.b(this.sessionInfo.curFriendUin))) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.panelicons.setSelected(21);
        return;
        i = 0;
      }
      else
      {
        this.panelicons.setSelected(8);
        return;
        if (i == 23)
        {
          this.panelicons.setSelected(8);
          return;
        }
        if (i == 18)
        {
          this.panelicons.setSelected(8);
          return;
        }
        if (i == 35)
        {
          this.panelicons.setSelected(8);
          return;
        }
        if (i == 24)
        {
          this.panelicons.setSelected(8);
          return;
        }
        if (i == 36)
        {
          this.panelicons.setSelected(2);
          return;
        }
        this.panelicons.setSelected(i);
        return;
        label195:
        i = 0;
      }
    }
  }
  
  public void updateSession(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "updateSession");
    }
    this.needShowAudioWhenResume = true;
    bfzg.a(null, "AIO_updateSession_initIntentData");
    updateSession_initIntentData(paramIntent);
    bfzg.a("AIO_updateSession_initIntentData", "AIO_updateSession_updateUI");
    updateSession_business(paramIntent);
    updateSession_updateUI(paramIntent);
    bfzg.a("AIO_updateSession_updateUI", "AIO_updateSession_forwardType");
    updateSession_forwardType(paramIntent, true);
    bfzg.a("AIO_updateSession_forwardType", "AIO_updateSession_otherThings");
    updateSession_otherThings(paramIntent);
    this.panelicons.a(this.app, this.sessionInfo, this);
    bfzg.a("AIO_updateSession_otherThings", null);
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "AIOTime updateSession end");
    }
  }
  
  protected void updateSession_business(Intent paramIntent)
  {
    this.helperProvider.a(2);
  }
  
  protected void updateSession_checkUpdateFooterView()
  {
    bfzg.a(null, "AIO_apolloFooterview");
    this.sessionInfo.curType = this.mActivity.getIntent().getIntExtra("uintype", -1);
    int j;
    if (((this.sessionInfo.curType == 1) || (this.sessionInfo.curType == 0) || ((this.sessionInfo.curType == 3000) && (1 == alnr.c("discuss")))) && (alnr.b) && (1 == ((alnr)this.app.getManager(153)).b(this.app.getCurrentUin())) && (!((HotChatManager)this.app.getManager(60)).b(this.sessionInfo.curFriendUin)) && (!ambc.a(this.app)) && (ambc.b(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin)))
    {
      j = SpriteUIHandler.a(this.mContext);
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, new Object[] { "add apollo footerview on init UI, footerHeight:", Integer.valueOf(j) });
      }
    }
    for (int i = j;; i = 0)
    {
      if (i > 0) {
        this.businessFooterDetector.a(i, false, "initUI", 0);
      }
      bfzg.a("AIO_apolloFooterview", null);
      return;
    }
  }
  
  protected void updateSession_updateDrawer()
  {
    this.mChatDrawer = createChatDrawer();
  }
  
  protected void updateSession_updatePanel() {}
  
  protected boolean updateSession_updatePttBar()
  {
    return false;
  }
  
  protected boolean updateSession_updateSimpleBar()
  {
    return false;
  }
  
  protected void updateSession_updateSubTitle() {}
  
  protected void updateSession_updateTitle(Intent paramIntent)
  {
    bfzg.a(null, "AIO_updateSession_updateTitle");
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.tag, 2, "updateSession_updateTitle nick == null");
      }
      paramIntent = ContactUtils.getDisplayName(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.troopUin, ContactUtils.getEntry(this.sessionInfo.curType), 3);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "updateSession_updateTitle curFriendNick" + bftf.a(paramIntent));
    }
    this.sessionInfo.curFriendNick = paramIntent;
    if (this.sessionInfo.curFriendNick != null)
    {
      this.mTitleText.setText(this.sessionInfo.curFriendNick);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        paramIntent = this.mTitleText.getText();
        this.mTitleText.setContentDescription(paramIntent);
        getActivity().setTitle(this.mTitleText.getText());
      }
    }
    for (;;)
    {
      this.mTitleIcon.setVisibility(8);
      this.mTitleIcon2.setVisibility(8);
      bfzg.a("AIO_updateSession_updateTitle", null);
      return;
      QLog.e(this.tag, 1, "updateSession_updateTitle sessionInfo.curFriendNick == null");
    }
  }
  
  protected void updateSession_updateTitleBtnCall()
  {
    this.mTitleBtnCall.setVisibility(8);
  }
  
  protected void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    boolean bool2 = true;
    Object localObject1 = paramIntent.getExtras();
    Object localObject3;
    Object localObject2;
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.isBack2Root = true;
      adjustTitleDimension();
      this.mCustomTitleView.setLeftContentDescription(amtj.a(2131700127));
      bool1 = paramIntent.getBooleanExtra("key_jump_from_qzone_feed", false);
      if (!paramIntent.getBooleanExtra("isFromDiscussionFlyTicket", false)) {
        break label458;
      }
      this.mTitleShowUnread = true;
      localObject1 = null;
      if (!this.mTitleShowUnread) {
        break label595;
      }
      long l = System.currentTimeMillis();
      ThreadManagerV2.excute(new BaseChatPie.21(this), 32, null, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "AIOTime doOnCreate_initUI updateUnreadNumOnTitleBar cost: " + (System.currentTimeMillis() - l));
      }
      localObject3 = paramIntent.getStringExtra("backName");
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject3))
      {
        this.mTitleBtnLeft.setText((CharSequence)localObject3);
        adjustTitleDimension();
        localObject2 = paramIntent.getStringExtra("comicId");
        TextView localTextView = this.mTitleBtnLeft;
        paramIntent = (Intent)localObject2;
        if (localObject2 == null) {
          paramIntent = "";
        }
        localTextView.setTag(new String[] { "comic", paramIntent });
        this.mTitleBtnLeft.setContentDescription("返回QQ动漫");
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, "set left text from update left: " + (String)localObject1 + ", back: " + (String)localObject3);
      }
      if (acvu.jdField_a_of_type_Boolean)
      {
        this.mTitleBtnRight.setContentDescription(amtj.a(2131700104));
        if (!this.mTitleShowUnread)
        {
          localObject1 = this.mTitleBtnLeft.getText().toString();
          paramIntent = (Intent)localObject1;
          if (!this.app.getApplication().getString(2131690424).equals(localObject1)) {
            paramIntent = amtj.a(2131700140) + (String)localObject1 + amtj.a(2131700106);
          }
          this.mTitleBtnLeft.setContentDescription(paramIntent);
        }
      }
      if (this.mCustomTitleView != null)
      {
        this.mCustomTitleView.e();
        paramIntent = this.mCustomTitleView;
        if (this.speakerPhoneOn) {
          break label642;
        }
      }
    }
    label642:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramIntent.a(bool1, this.sessionInfo.curType);
      return;
      if (localObject1 == null) {
        break;
      }
      this.isBack2Root = ((Bundle)localObject1).getBoolean("isBack2Root");
      if (!this.isBack2Root) {
        break;
      }
      adjustTitleDimension();
      this.mCustomTitleView.setLeftContentDescription(amtj.a(2131700137));
      break;
      label458:
      if (bool1)
      {
        localObject1 = paramIntent.getStringExtra("key_jump_from_qzone_feed_left_title");
        if (localObject1 == null) {}
        for (localObject1 = this.app.getApplication().getString(2131690599);; localObject1 = this.app.getApplication().getString(2131716763, new Object[] { localObject1 }))
        {
          this.mTitleShowUnread = false;
          break;
        }
      }
      localObject1 = paramIntent.getStringExtra("leftViewText");
      if ((this.isBack2Root) || ((localObject1 != null) && (((String)localObject1).contains(this.app.getApplication().getString(2131718771))))) {}
      for (bool1 = true;; bool1 = false)
      {
        this.mTitleShowUnread = bool1;
        if (this.isFromSeachResult) {
          this.mTitleShowUnread = true;
        }
        break;
      }
      label595:
      localObject3 = this.mTitleBtnLeft;
      if (localObject1 == null) {}
      for (localObject2 = this.app.getApplication().getString(2131690599);; localObject2 = localObject1)
      {
        ((TextView)localObject3).setText((CharSequence)localObject2);
        adjustTitleDimension();
        break;
      }
    }
  }
  
  protected void updateSession_updateTitleRightView()
  {
    this.mCustomTitleView.setRight1Icon(2130850056, 2130850057);
  }
  
  protected void updateSession_updateUI(Intent paramIntent)
  {
    this.mCustomTitleView.setRight2Icon(2130850596, 2130850597);
    this.mTipsMgr.a();
    instantUpdate(true, false);
    updateSession_updateTitle(paramIntent);
    setSubTitleVisable(false);
    updateSession_updateSubTitle();
    this.isSimpleBar = updateSession_updateSimpleBar();
    this.isPttOnlyBar = updateSession_updatePttBar();
    updateSession_updateInput(paramIntent);
    updateSession_updateTitleLeftView(paramIntent);
    updateSession_updateTitleRightView();
    updateSession_updateTitleBtnCall();
    updateSession_checkUpdateFooterView();
    updateSession_updateDrawer();
    this.canPullRefresh = true;
    this.mEffectPullRefreshCount = 0;
    setOverScrollHandleVisable(false);
    this.chatPieHelper.a(paramIntent);
  }
  
  protected void updateSpeakerPhoneLayout(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mpm.b()) {
      paramBoolean1 = false;
    }
    if ((paramBoolean1) && (!AIOUtils.isRubbishSamsun())) {
      if (this.speakerPhoneLayout == null)
      {
        this.mActivity.getLayoutInflater().inflate(2131558645, this.mContent);
        this.speakerPhoneLayout = this.mContent.findViewById(2131362489);
        this.speakerPhoneTextView = ((TextView)this.mContent.findViewById(2131362490));
        this.phoneImage = ((ImageView)this.mContent.findViewById(2131362488));
        this.speakerPhoneLayout.setOnClickListener(this);
        if (this.sessionInfo.curType != 1) {
          break label228;
        }
        if ((this.mTroopTips != null) && (!this.mTroopTips.c())) {
          ((RelativeLayout.LayoutParams)this.speakerPhoneLayout.getLayoutParams()).addRule(2, 2131368751);
        }
      }
    }
    label227:
    label228:
    do
    {
      do
      {
        do
        {
          break label227;
          for (;;)
          {
            this.speakerPhoneLayout.setVisibility(0);
            if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
              this.speakerPhoneTextView.setTextColor(Color.parseColor("#FF737373"));
            }
            if (!paramBoolean2) {
              break;
            }
            this.speakerPhoneTextView.setText(2131689960);
            this.phoneImage.setBackgroundResource(2130849886);
            if (this.mCustomTitleView != null) {
              this.mCustomTitleView.a(false, this.sessionInfo.curType);
            }
            return;
            if (this.mUnReadTxt == null) {
              ((RelativeLayout.LayoutParams)this.speakerPhoneLayout.getLayoutParams()).addRule(2, 2131368751);
            }
          }
          this.speakerPhoneTextView.setText(2131689959);
          this.phoneImage.setBackgroundResource(2130849885);
        } while (this.mCustomTitleView == null);
        this.mCustomTitleView.a(true, this.sessionInfo.curType);
        return;
      } while (this.speakerPhoneLayout == null);
      this.speakerPhoneLayout.setVisibility(8);
      paramBoolean1 = lfg.a(BaseApplicationImpl.getContext());
      paramBoolean2 = AudioHelper.a(BaseApplicationImpl.getContext());
    } while (((!paramBoolean1) && (!paramBoolean2)) || (this.mCustomTitleView == null));
    NavBarAIO localNavBarAIO = this.mCustomTitleView;
    if (!this.speakerPhoneOn) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localNavBarAIO.a(paramBoolean1, this.sessionInfo.curType);
      return;
    }
  }
  
  protected void updateUI_titleBarForTheme()
  {
    if ((this.sessionInfo == null) || (this.mContext == null) || (this.mCustomTitleView == null)) {}
    do
    {
      return;
      this.mCustomTitleView.a(this.sessionInfo);
    } while (!this.isMultiSelectHideIPB);
    if (this.mUnReadTxt != null) {
      this.mUnReadTxt.setVisibility(8);
    }
    this.mDefautlBtnLeft.setVisibility(8);
  }
  
  protected void updateUnreadNumOnTitleBar()
  {
    int i;
    Object localObject;
    String str1;
    if ((this.mTitleShowUnread) && (!BaseChatItemLayout.jdField_a_of_type_Boolean))
    {
      int j = azjc.a(this.app);
      i = 0;
      localObject = this.app.getMessageFacade();
      if (localObject != null) {
        i = ((QQMessageFacade)localObject).getUnreadMsgsNum();
      }
      i += j;
      localObject = "";
      if (i <= 0) {
        break label175;
      }
      localObject = "" + i;
      if (i > 99) {
        localObject = "99+";
      }
      str1 = this.mContext.getString(2131718771) + "(" + (String)localObject + ")";
    }
    for (String str2 = amtj.a(2131700121) + this.mContext.getString(2131718771) + i + "条未读";; str2 = amtj.a(2131700126) + this.mContext.getString(2131718771))
    {
      updateUnreadNumOnTitleBar(str1, str2, (String)localObject);
      return;
      label175:
      str1 = this.mContext.getString(2131718771);
    }
  }
  
  void updateUnreadNumOnTitleBar(String paramString1, String paramString2, String paramString3)
  {
    this.uiHandler.post(new BaseChatPie.20(this, paramString1, paramString3, paramString2));
  }
  
  protected void updateViewForTheme(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (paramImageView != null)
    {
      if (this.isThemeDefault) {
        paramImageView.setImageResource(paramInt2);
      }
    }
    else {
      return;
    }
    paramImageView.setImageResource(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie
 * JD-Core Version:    0.7.0.1
 */