package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.devicelib.DeviceLib;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxy;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.imcore.message.ext.getaiolist.PretreatmentAIOMsg;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendPushUtil;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush;
import com.tencent.mobileqq.activity.recent.data.RecentItemScheduleData;
import com.tencent.mobileqq.activity.recent.data.RecentItemVoteData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyLockScreenJumpDelegate;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManagerService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.managers.MsgPushReportHelper;
import com.tencent.mobileqq.managers.PullActiveManager;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.mobileqq.ptt.LSRecordPanel.IRecordPanelHandler;
import com.tencent.mobileqq.ptt.LsRecordConfig;
import com.tencent.mobileqq.ptt.TouchProxyRelativeLayout;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.mobileqq.utils.QQLSSensor.ProximitySensorChangeListener;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.tools.ActivityLifeCycleInfoRecordHelper;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.QQKRPUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.MaxHeightRelativelayout;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.Foreground;
import mqq.os.MqqHandler;

public class QQLSActivity
  extends AppActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, Callback, MediaPlayerManager.Callback, MediaPlayerManager.Listener, DragFrameLayout.OnDragModeChangedListener, LSRecordPanel.IRecordPanelHandler, QQLSSensor.ProximitySensorChangeListener, Observer
{
  private static final boolean B = AppSetting.e;
  private static CopyOnWriteArraySet<String> aK = new CopyOnWriteArraySet();
  public static boolean b = false;
  View.OnTouchListener A = new QQLSActivity.12(this);
  private TouchProxyRelativeLayout C;
  private RelativeLayout D;
  private Button E;
  private LSRecordPanel F;
  private View G;
  private TextView H;
  private boolean I;
  private boolean J;
  private TextView K;
  private boolean L;
  private int M;
  private XEditTextEx N;
  private MaxHeightRelativelayout O;
  private XListView P;
  private QQLSActivity.RecentItemAdapter Q;
  private RelativeLayout R;
  private QQLSActivity.SingleItemAdapter S;
  private XListView T;
  private RecentBaseData U;
  private TextView V;
  private TextView W;
  private QQAppInterface X;
  private final int Y = 300;
  private MotionEvent Z;
  IPhoneContactService a;
  private boolean aA = true;
  private boolean aB = false;
  private boolean aC = true;
  private long aD = -1L;
  private boolean aE;
  private ToastStyleDialog aF;
  private MessageObserver aG = new QQLSActivity.8(this);
  private INewFriendListener aH = new QQLSActivity.9(this);
  private Handler aI = new QQLSActivity.13(this, Looper.getMainLooper());
  private int aJ = 0;
  private MotionEvent aa;
  private long ab = -1L;
  private long ac = 0L;
  private long ad = 0L;
  private boolean ae = false;
  private Animation af;
  private final int ag = 1000;
  private final int ah = 1;
  private final int ai = 2;
  private final int aj = 3;
  private final int ak = 4;
  private final int al = 5;
  private final int am = 6;
  private final int an = 7;
  private final int ao = 8;
  private final int ap = 9;
  private final int aq = 10;
  private final int ar = 11;
  private final int as = 12;
  private final int at = 13;
  private final int au = 14;
  private final int av = 15;
  private final int aw = 16;
  private final int ax = 1500;
  private final int ay = 1000;
  private boolean az = false;
  public final int c = 0;
  public final int d = 1;
  public final int e = 2;
  public final int f = 3;
  public final int g = 4;
  public final int h = 5;
  public final int i = 99;
  QQLSSensor j;
  PowerManager.WakeLock k = null;
  INewFriendService l;
  public ISubAccountService m;
  QQLSRecentManager n;
  DragFrameLayout o;
  QCallFacade p;
  ArrayList<MessageRecord> q = new ArrayList();
  float r;
  QQLSActivity.ScreenBroadcastReceiver s;
  KeyguardManager t;
  public boolean u = true;
  protected final MqqHandler v = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  public WeakReferenceHandler w = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public Comparator x = new QQLSActivity.5(this);
  public Comparator y = new QQLSActivity.6(this);
  protected MessageObserver z = new QQLSActivity.10(this);
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "SmoothFinish");
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(450L);
    localAlphaAnimation.setAnimationListener(new QQLSActivity.20(this));
    this.v.sendEmptyMessageDelayed(99, 500L);
    this.C.startAnimation(localAlphaAnimation);
  }
  
  private void B()
  {
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.21(this));
  }
  
  private void C()
  {
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.22(this));
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    Object localObject;
    if (paramMessageRecord.istroop == 7000)
    {
      localObject = this.m;
      if (localObject != null) {
        localObject = ((ISubAccountService)localObject).getLatestUinNick(paramMessageRecord.frienduin);
      } else {
        localObject = null;
      }
      if (localObject == null) {
        paramMessageRecord = paramMessageRecord.frienduin;
      } else {
        paramMessageRecord = (MessageRecord)localObject;
      }
    }
    else if ((paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 1010) && (paramMessageRecord.istroop != 10002))
    {
      if (UinTypeUtil.e(paramMessageRecord.istroop) == 1032)
      {
        localObject = new ConfessInfo();
        ((ConfessInfo)localObject).parseFromJsonStr(paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
        if (paramMessageRecord.istroop == 1032) {
          paramMessageRecord = paramMessageRecord.senderuin;
        } else {
          paramMessageRecord = paramMessageRecord.frienduin;
        }
        paramMessageRecord = ConfessMsgUtil.a(this.X, (ConfessInfo)localObject, paramMessageRecord);
      }
      else if (AnonymousChatHelper.c(paramMessageRecord))
      {
        paramMessageRecord = getResources().getString(2131895011);
      }
      else
      {
        paramMessageRecord = this.X.getMessageFacade().e(this, paramMessageRecord, false);
      }
    }
    else
    {
      localObject = ContactUtils.h(this.X, paramMessageRecord.senderuin);
      paramMessageRecord = (MessageRecord)localObject;
      if (localObject == null) {
        paramMessageRecord = "";
      }
    }
    if (!TextUtils.isEmpty(paramMessageRecord))
    {
      if (paramMessageRecord.equals("")) {
        return "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramMessageRecord);
      ((StringBuilder)localObject).append(":");
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i1 = paramIntent.getIntExtra("uitype", -1);
      int i2 = paramIntent.getIntExtra("notifyId", -1);
      paramIntent = paramIntent.getStringExtra("frienduin");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("lsReportCore uitype: ");
        localStringBuilder.append(i1);
        localStringBuilder.append(", notifyId : ");
        localStringBuilder.append(i2);
        localStringBuilder.append(", frienduin : ");
        localStringBuilder.append(paramIntent);
        QLog.d("QQLSActivity", 2, localStringBuilder.toString());
      }
      MsgPushReportHelper.a(i2, paramIntent, i1);
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    if (Math.abs(this.ad - System.currentTimeMillis()) < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "enter too offen,please try again later");
      }
      return;
    }
    this.ad = System.currentTimeMillis();
    QQLSRecentManager.l = System.currentTimeMillis();
    o();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "enterAIO");
    }
    if (!u())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "=======enterAIO  NOT LOCK!!!!!!!!!");
      }
      finish();
      return;
    }
    if (this.aI.hasMessages(13)) {
      this.aI.removeMessages(13);
    }
    Object localObject1 = null;
    if ((paramRecentBaseData instanceof RecentUserBaseData)) {
      localObject1 = ((RecentUserBaseData)paramRecentBaseData).e();
    }
    if (paramRecentBaseData != null) {
      paramRecentBaseData.clearUnReadNum();
    }
    if (paramRecentBaseData != null)
    {
      localObject2 = this.n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRecentBaseData.getRecentUserUin());
      localStringBuilder.append(paramRecentBaseData.getRecentUserType());
      MsgPushReportHelper.b(((QQLSRecentManager)localObject2).a(localStringBuilder.toString()), paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
    }
    ReportController.b(this.X, "CliOper", "", "", "0X80040DD", "0X80040DD", 0, 0, "", "", "", "");
    Object localObject2 = this.n;
    int i1 = 1;
    QQLSRecentManager.i = true;
    if (v())
    {
      o();
      localObject2 = this.af;
      if (localObject2 != null) {
        this.C.startAnimation((Animation)localObject2);
      }
      if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1012))
      {
        paramRecentBaseData = new AllInOne(this.X.getCurrentAccountUin(), 0);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("param_mode", 2);
        ((Intent)localObject1).putExtra("AllInOne", paramRecentBaseData);
        ((Intent)localObject1).putExtra("abp_flag", true);
        ((Intent)localObject1).putExtra("frome_where", -1);
        ((Intent)localObject1).addFlags(67108864);
        RouteUtils.a(BaseApplicationImpl.getContext(), (Intent)localObject1, "/nearby/people/profile");
      }
      else if ((localObject1 != null) && ((((RecentUser)localObject1).getType() == 1030) || (((RecentUser)localObject1).getType() == 1030) || (((RecentUser)localObject1).getType() == 1041) || (((RecentUser)localObject1).getType() == 1042)))
      {
        if ((paramRecentBaseData instanceof RecentItemNoticeData))
        {
          paramRecentBaseData = ((RecentItemNoticeData)paramRecentBaseData).intent;
          if (paramRecentBaseData != null) {
            startActivity(paramRecentBaseData);
          }
        }
      }
      else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 9653))
      {
        localObject1 = (PullActiveManager)this.X.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
        if ((paramRecentBaseData instanceof RecentItemPullActivePush))
        {
          paramRecentBaseData = ((PullActiveManager)localObject1).d;
          if (paramRecentBaseData != null) {
            startActivity(paramRecentBaseData);
          }
        }
        ((PullActiveManager)localObject1).b();
        QQNotificationManager.getInstance().cancel("QQLSActivity_PullActive", 269);
      }
      else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1001))
      {
        paramRecentBaseData = this.X.getMessageFacade().getLastMessage(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
        startActivity(this.X.getIntentByMessage(this, paramRecentBaseData, false));
      }
      else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(((RecentUser)localObject1).uin)))
      {
        paramRecentBaseData = (IKandianDailyManagerService)this.X.getRuntimeService(IKandianDailyManagerService.class);
        ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportForLockScreenEnter(paramRecentBaseData.getRedPntInfoFromMsg());
        startActivity(((IReadInJoyLockScreenJumpDelegate)QRoute.api(IReadInJoyLockScreenJumpDelegate.class)).getJumpDailyFragmentIntent(this, 9, paramRecentBaseData.getAndRemoveLockScreenRedDodInfo()));
      }
      else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 7220))
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80098D5", "0X80098D5", 0, 0, "0", "", "", "", false);
        paramRecentBaseData = ((IKanDianMergeManager)this.X.getRuntimeService(IKanDianMergeManager.class)).getKandianLockScreenRedPntInfo();
        if ((paramRecentBaseData != null) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).canJumpFeedsForHasKeyguard(paramRecentBaseData.getMessageRecord())))
        {
          ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportForLockScreenEnter();
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(this, 9, 0);
        }
        else
        {
          paramRecentBaseData = new Intent(this, SplashActivity.class);
          paramRecentBaseData.putExtra("tab_index", FrameControllerUtil.a);
          paramRecentBaseData.setFlags(67108864);
          startActivity(paramRecentBaseData);
        }
      }
      else if ((paramRecentBaseData != null) && (UinTypeUtil.e(paramRecentBaseData.getRecentUserType()) == 1044))
      {
        localObject1 = MatchChatMsgUtil.a(this);
        ((Intent)localObject1).putExtra("key_matchchat_from_notification", true);
        ((Intent)localObject1).putExtra("key_matchchat_from_notification_uin", paramRecentBaseData.getRecentUserUin());
        ((Intent)localObject1).putExtra("key_matchchat_from_notification_type", paramRecentBaseData.getRecentUserType());
        startActivity((Intent)localObject1);
      }
      else if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 10007))
      {
        if (((IGameMsgBoxABTestApi)QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab())
        {
          localObject1 = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getLastGameMsg(this.X, paramRecentBaseData.getRecentUserUin());
          if (localObject1 != null) {
            ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(this, paramRecentBaseData.getRecentUserUin(), RoleIdUtil.b((MessageRecord)localObject1), RoleIdUtil.a((MessageRecord)localObject1), 2);
          }
        }
        else
        {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(this.X, this, paramRecentBaseData.getRecentUserUin());
        }
      }
      else
      {
        paramRecentBaseData = new Intent(this, SplashActivity.class);
        paramRecentBaseData.putExtra("tab_index", FrameControllerUtil.a);
        paramRecentBaseData.setFlags(67108864);
        startActivity(paramRecentBaseData);
      }
      paramRecentBaseData = this.aI.obtainMessage(16);
      this.aI.sendMessageDelayed(paramRecentBaseData, 1500L);
      return;
    }
    if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 7432))
    {
      paramRecentBaseData = new Intent(this, SplashActivity.class);
      paramRecentBaseData.setFlags(67108864);
      paramRecentBaseData.putExtra("tab_index", FrameControllerUtil.a);
      paramRecentBaseData.putExtra("fragment_id", 1);
      startActivity(paramRecentBaseData);
    }
    else
    {
      if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 9653))
      {
        localObject2 = (PullActiveManager)this.X.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
        if ((paramRecentBaseData instanceof RecentItemPullActivePush))
        {
          paramRecentBaseData = ((PullActiveManager)localObject2).d;
          if (paramRecentBaseData != null)
          {
            paramRecentBaseData.setFlags(67108864);
            startActivity(paramRecentBaseData);
          }
        }
        ((PullActiveManager)localObject2).b();
        QQNotificationManager.getInstance().cancel("QQLSActivity_PullActive", 269);
        break label1594;
      }
      if ((localObject1 != null) && ((((RecentUser)localObject1).getType() == 1030) || (e(((RecentUser)localObject1).getType()))))
      {
        if ((paramRecentBaseData instanceof RecentItemNoticeData))
        {
          paramRecentBaseData = ((RecentItemNoticeData)paramRecentBaseData).intent;
          if (paramRecentBaseData != null)
          {
            if ((e(((RecentUser)localObject1).getType())) && (!v())) {
              paramRecentBaseData.putExtra("push_notice_unlock", true);
            }
            startActivity(paramRecentBaseData);
          }
        }
      }
      else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1001))
      {
        paramRecentBaseData = this.X.getMessageFacade().getLastMessage(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
        startActivity(this.X.getIntentByMessage(this, paramRecentBaseData, false));
      }
      else if ((paramRecentBaseData != null) && (UinTypeUtil.e(paramRecentBaseData.getRecentUserType()) == 1044))
      {
        localObject2 = MatchChatMsgUtil.a(this);
        ((Intent)localObject2).putExtra("key_matchchat_from_notification", true);
        ((Intent)localObject2).putExtra("key_matchchat_from_notification_uin", paramRecentBaseData.getRecentUserUin());
        ((Intent)localObject2).putExtra("key_matchchat_from_notification_type", paramRecentBaseData.getRecentUserType());
        startActivity((Intent)localObject2);
      }
      else if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 10007))
      {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(this.X, this, paramRecentBaseData.getRecentUserUin());
      }
      else if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 0))
      {
        b(paramRecentBaseData, (RecentUser)localObject1);
      }
      else if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 1))
      {
        a(paramRecentBaseData, (RecentUser)localObject1);
      }
      else if (paramRecentBaseData != null)
      {
        if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 7220)) {
          ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportForLockScreenEnter();
        }
        RecentUtil.a(this, this.X, (RecentUser)localObject1, paramRecentBaseData.mTitleName, true, 1, null);
      }
    }
    i1 = 0;
    label1594:
    QQKRPUtil.a(this.X, (RecentUser)localObject1);
    paramRecentBaseData = this.aI.obtainMessage(9);
    localObject2 = this.aI;
    long l1;
    if ((!GesturePWDUtils.getJumpLock(this, this.X.getCurrentAccountUin())) && (i1 == 0)) {
      l1 = 0L;
    } else {
      l1 = 500L;
    }
    ((Handler)localObject2).sendMessageDelayed(paramRecentBaseData, l1);
    paramRecentBaseData = this.aI.obtainMessage(16);
    this.aI.sendMessageDelayed(paramRecentBaseData, 1500L);
    if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1008)) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ((RecentUser)localObject1).uin, "0X800756F", "0X800756F", 0, 0, "", "", "", "");
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    Bundle localBundle = new Bundle();
    com.tencent.imcore.message.Message localMessage = this.X.getMessageFacade().getLastMessage(paramRecentUser.uin, paramRecentUser.getType());
    if ((localMessage != null) && (localMessage.msgtype == -5008)) {
      localBundle.putBoolean("key_from_listen_together_notify_msg", ListenTogetherUtils.a(this.X, localMessage));
    }
    RecentUtil.a(this, this.X, paramRecentUser, paramRecentBaseData.mTitleName, true, 1, null, localBundle, null);
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.X.getMessageFacade().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private void a(FriendSystemMessage paramFriendSystemMessage)
  {
    if ((paramFriendSystemMessage.a != null) && (AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(paramFriendSystemMessage.a.frienduin)))
    {
      int i1 = NewFriendPushUtil.a(paramFriendSystemMessage.a);
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setFromSysSubMsgType(i1);
      if (i1 == 6)
      {
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).report(this.X, "0X800A181");
        return;
      }
      if ((i1 == 9) || (i1 == 10) || (i1 == 1)) {
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).report(this.X, "0X8009CBA");
      }
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (paramMotionEvent3.getEventTime() - paramMotionEvent1.getEventTime() > 300L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "isConsideredDoubleTap true");
      }
      return false;
    }
    return true;
  }
  
  private boolean a(MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    paramString = this.X.getConversationFacade().p(paramString, paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramMessageRecord == null) {
        return false;
      }
      if (UinTypeUtil.b(paramInt))
      {
        bool1 = bool2;
        if (paramMessageRecord.time <= paramString.lastread) {
          break label75;
        }
      }
      else
      {
        bool1 = bool2;
        if (paramMessageRecord.shmsgseq <= paramString.lastread) {
          break label75;
        }
      }
      bool1 = true;
    }
    label75:
    return bool1;
  }
  
  private SessionInfo b(RecentBaseData paramRecentBaseData)
  {
    int i1 = paramRecentBaseData.getRecentUserType();
    String str = paramRecentBaseData.getRecentUserUin();
    SessionInfo localSessionInfo = new SessionInfo();
    Object localObject;
    StringBuilder localStringBuilder;
    if (i1 == 1)
    {
      localObject = (TroopManager)this.X.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("");
        localObject = ((TroopManager)localObject).f(localStringBuilder.toString());
        if ((localObject != null) && (((TroopInfo)localObject).troopcode != null)) {
          localSessionInfo.c = ((TroopInfo)localObject).troopcode;
        }
      }
    }
    else if (i1 == 1006)
    {
      localObject = ((IPhoneContactService)this.X.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((RespondQueryQQBindingStat)localObject).nationCode);
      localStringBuilder.append(((RespondQueryQQBindingStat)localObject).mobileNo);
      localSessionInfo.f = localStringBuilder.toString();
      localSessionInfo.g = ContactUtils.b(this.X, str);
      if ((localSessionInfo.g == null) && (QLog.isColorLevel())) {
        QLog.d("QQLSActivity", 2, "contactUin == null");
      }
    }
    else if (((i1 == 1004) || (i1 == 1000)) && ((paramRecentBaseData instanceof RecentUserBaseData)))
    {
      localSessionInfo.c = ((RecentUserBaseData)paramRecentBaseData).g();
    }
    localSessionInfo.b = str;
    localSessionInfo.a = i1;
    localSessionInfo.e = paramRecentBaseData.mTitleName;
    return localSessionInfo;
  }
  
  private void b(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    Bundle localBundle = new Bundle();
    com.tencent.imcore.message.Message localMessage = this.X.getMessageFacade().getLastMessage(paramRecentUser.uin, paramRecentUser.getType());
    if ((localMessage != null) && (localMessage.msgtype == -5008)) {
      localBundle.putBoolean("key_from_listen_together_notify_msg", ListenTogetherUtils.a(this.X, localMessage));
    }
    RecentUtil.a(this, this.X, paramRecentUser, paramRecentBaseData.mTitleName, true, 1, null, localBundle, null);
  }
  
  private void b(boolean paramBoolean)
  {
    this.aI.removeMessages(14);
    QQLSActivity.19 local19 = new QQLSActivity.19(this);
    if (paramBoolean)
    {
      this.aI.post(local19);
      return;
    }
    local19.run();
  }
  
  private List<MessageRecord> c(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    if ((!paramString.equals(AppConstants.LOCK_SCREEN_DATE_UIN)) && (!paramString.equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN)))
    {
      Object localObject2 = this.X.getMessageFacade().h(paramString, paramInt);
      Object localObject3 = new ArrayList();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("single item msg list size: ");
        ((StringBuilder)localObject1).append(((List)localObject2).size());
        QLog.d("QQLSActivity", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject4;
      if (UinTypeUtil.b(paramInt))
      {
        localObject1 = this.X.getMsgCache().N(paramString);
        long l1;
        if (localObject1 != null) {
          l1 = ((Long)((Pair)localObject1).first).longValue();
        } else {
          l1 = 0L;
        }
        localObject2 = MsgProxy.a((List)localObject2, l1);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          localObject1 = localObject3;
          if (((List)localObject2).size() > 0)
          {
            ((List)localObject3).addAll((Collection)localObject2);
            localObject1 = localObject3;
          }
        }
      }
      else if ((paramInt != 3000) && (paramInt != 1))
      {
        if (paramInt == 7000)
        {
          localObject2 = new MessageRecord();
          localObject4 = this.m;
          localObject1 = localObject3;
          if (localObject4 != null)
          {
            localObject1 = localObject3;
            if (((ISubAccountService)localObject4).getLatestMsg(paramString) != null)
            {
              ((MessageRecord)localObject2).msg = this.m.getLatestMsg(paramString).toString();
              ((MessageRecord)localObject2).istroop = paramInt;
              ((MessageRecord)localObject2).frienduin = paramString;
              ((List)localObject3).add(localObject2);
              localObject1 = localObject3;
            }
          }
        }
        else if (paramInt == 4000)
        {
          localObject4 = new MessageRecord();
          localObject1 = this.l;
          if (localObject1 != null) {
            localObject2 = ((INewFriendService)localObject1).getLastUnreadNewFriendMessage();
          } else {
            localObject2 = null;
          }
          localObject1 = localObject3;
          if (localObject2 != null)
          {
            ((MessageRecord)localObject4).msg = ((NewFriendMessage)localObject2).b(this.X);
            ((MessageRecord)localObject4).istroop = paramInt;
            ((MessageRecord)localObject4).frienduin = paramString;
            if ((localObject2 instanceof FriendSystemMessage)) {
              a((FriendSystemMessage)localObject2);
            }
            ((List)localObject3).add(localObject4);
            localObject1 = localObject3;
          }
        }
        else if (paramInt == 9002)
        {
          localObject1 = this.X.getMessageFacade().getLastMessage(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
          localObject2 = new MessageRecord();
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, (MessageRecord)localObject1);
          ((List)localObject3).add(localObject2);
          localObject1 = localObject3;
        }
        else if (paramInt == 8)
        {
          localObject1 = MessageRecordFactory.a(-2026);
          ((MessageRecord)localObject1).istroop = paramInt;
          ((MessageRecord)localObject1).frienduin = paramString;
          ((MessageRecord)localObject1).msg = "";
          ((MessageRecord)localObject1).isread = true;
          ((List)localObject3).add(localObject1);
          localObject1 = localObject3;
        }
        else
        {
          localObject1 = localObject3;
          if (paramInt == 9501)
          {
            localObject1 = localObject3;
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              for (;;)
              {
                localObject1 = localObject3;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                ((List)localObject3).add((MessageRecord)((Iterator)localObject2).next());
              }
            }
          }
        }
      }
      else
      {
        localObject1 = MsgProxyUtils.a((List)localObject2, false);
      }
      if ((paramInt != 1001) && (paramInt != 1010) && (paramInt != 10002))
      {
        if (paramInt == 1032) {
          if ((localObject1 != null) && (((List)localObject1).size() != 0))
          {
            localObject2 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
            localObject2 = ConfessMsgUtil.a(this.X, (MessageRecord)localObject2);
            ((List)localObject1).clear();
            if (localObject2 != null) {
              ((List)localObject1).add(localObject2);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "getSingleUnreadMsg UIN_TYPE_LBS_FRIEND is null");
            }
            finish();
            return new ArrayList();
          }
        }
        if (paramString.equals(AppConstants.VOTE_UIN))
        {
          paramString = (DatingProxyManager)this.X.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
          if (paramString != null) {
            ((List)localObject1).add(paramString.a().a(this.U));
          }
          return localObject1;
        }
        if ((paramInt == 1030) && (AppConstants.CAMPUS_NOTICE_UIN.equals(paramString)))
        {
          if (this.X.isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER))
          {
            paramString = ((CampusNoticeManager)this.X.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).b();
            if (paramString != null) {
              ((List)localObject1).add(paramString);
            }
          }
          return localObject1;
        }
        if (e(paramInt))
        {
          if (this.X.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER))
          {
            paramString = ((PushNoticeManager)this.X.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).c();
            if (paramString != null) {
              ((List)localObject1).add(paramString);
            }
          }
          return localObject1;
        }
        if (paramString.equals(AppConstants.PULL_ACTIVE_PUSH_UIN))
        {
          paramString = (PullActiveManager)this.X.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
          if (paramString != null) {
            ((List)localObject1).add(paramString.c());
          }
          return localObject1;
        }
        if (((paramString.equals(AppConstants.KANDIAN_MERGE_UIN)) && (paramInt == 7220)) || ((paramString.equals(AppConstants.NEW_KANDIAN_UIN)) && (paramInt == 1008)))
        {
          paramString = ((IKanDianMergeManager)this.X.getRuntimeService(IKanDianMergeManager.class)).getLastMsgForKandian2();
          ((List)localObject1).clear();
          ((List)localObject1).add(paramString);
          return localObject1;
        }
        if (AppConstants.KANDIAN_DAILY_UIN.equals(paramString))
        {
          paramString = ((IKandianDailyManagerService)this.X.getRuntimeService(IKandianDailyManagerService.class)).getLastLockScreenMsg();
          ((List)localObject1).clear();
          if (paramString != null) {
            ((List)localObject1).add(paramString);
          }
          return localObject1;
        }
        if ((QLog.isColorLevel()) && (localObject1 != null))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("single item continued msg list size: ");
          ((StringBuilder)localObject2).append(((List)localObject1).size());
          QLog.d("QQLSActivity", 2, ((StringBuilder)localObject2).toString());
        }
        PretreatmentAIOMsg.a(paramInt, (List)localObject1, this.X);
        MsgProxyUtils.a(paramString, paramInt, (List)localObject1, this.X.getMsgCache());
        localObject2 = new ArrayList();
        if ((localObject1 != null) && (((List)localObject1).size() != 0))
        {
          localObject3 = ((List)localObject1).iterator();
          int i1 = 0;
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject3).next();
            if ((i1 == 0) || (((MessageRecord)localObject4).isSend()) || (!UniteGrayTipMsgUtil.b((MessageRecord)localObject4))) {
              if ((a((MessageRecord)localObject4, paramString, paramInt)) && (!((MessageRecord)localObject4).isSend())) {
                i1 = 1;
              } else {
                ((List)localObject2).add(localObject4);
              }
            }
          }
          ((List)localObject1).removeAll((Collection)localObject2);
          QLog.d("QQLSActivity", 1, new Object[] { "[getSingleUnreadMsg][LSUnread] remove[", Integer.valueOf(((List)localObject2).size()), "] read msg. retain [", Integer.valueOf(((List)localObject1).size()), "] unreads" });
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("mergeSortList miscalllist size: ");
            ((StringBuilder)localObject2).append(this.q.size());
            ((StringBuilder)localObject2).append(", uinType");
            ((StringBuilder)localObject2).append(paramInt);
            QLog.d("QQLSActivity", 2, ((StringBuilder)localObject2).toString());
          }
          paramString = a(paramString, paramInt);
          if (paramString.size() > 0) {
            a((List)localObject1, paramString, paramInt);
          }
          if (((List)localObject1).size() > 15) {
            return new ArrayList(((List)localObject1).subList(((List)localObject1).size() - 15, ((List)localObject1).size()));
          }
          return localObject1;
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("single item continued msg list size= 0");
          paramString.append(Thread.currentThread().getId());
          QLog.d("QQLSActivity", 2, paramString.toString());
        }
        A();
        return new ArrayList();
      }
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        return new ArrayList(((List)localObject1).subList(((List)localObject1).size() - 1, ((List)localObject1).size()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "getSingleUnreadMsg UIN_TYPE_LBS_FRIEND is null");
      }
      finish();
      return new ArrayList();
    }
    Object localObject1 = new MessageRecord();
    ((MessageRecord)localObject1).frienduin = paramString;
    ((MessageRecord)localObject1).senderuin = paramString;
    ((MessageRecord)localObject1).istroop = paramInt;
    paramString = new ArrayList();
    paramString.add(localObject1);
    return paramString;
  }
  
  private void d(int paramInt)
  {
    this.K.setVisibility(0);
    if (paramInt > 0) {
      this.aI.sendEmptyMessageDelayed(15, paramInt);
    }
  }
  
  private void d(String paramString, int paramInt)
  {
    this.aI.removeMessages(14);
    if (this.H == null)
    {
      this.H = new TextView(this.R.getContext());
      this.H.setBackgroundColor(getResources().getColor(2131168376));
      this.H.setVisibility(0);
      this.H.setGravity(17);
      Object localObject = getResources().getDisplayMetrics();
      int i3 = (int)(((DisplayMetrics)localObject).density * 16.0F);
      int i1 = (int)(((DisplayMetrics)localObject).density * 32.0F);
      int i2 = (int)(((DisplayMetrics)localObject).density * 240.0F);
      this.H.setTextSize(0, i3);
      this.H.setTextColor(-1711276033);
      localObject = new Rect();
      this.C.getGlobalVisibleRect((Rect)localObject);
      Rect localRect = new Rect();
      this.F.getGlobalVisibleRect(localRect);
      i3 = (localRect.top - ((Rect)localObject).top - i1) / 2;
      int i4 = (localRect.right - ((Rect)localObject).left - i2) / 2;
      localObject = new RelativeLayout.LayoutParams(i2, i1);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i4;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i3;
      this.C.addView(this.H, (ViewGroup.LayoutParams)localObject);
    }
    this.H.setText(paramString);
    this.H.setVisibility(0);
    if (paramInt > 0) {
      this.aI.sendEmptyMessageDelayed(14, paramInt);
    }
  }
  
  private static boolean e(int paramInt)
  {
    return (paramInt == 1035) || (paramInt == 1041) || (paramInt == 1042);
  }
  
  private void n()
  {
    QQLSRecentManager localQQLSRecentManager = this.n;
    if (QQLSRecentManager.a == 0L)
    {
      localQQLSRecentManager = this.n;
      QQLSRecentManager.a = System.currentTimeMillis();
      localQQLSRecentManager = this.n;
      QQLSRecentManager.b = QQLSRecentManager.a;
      localQQLSRecentManager = this.n;
      QQLSRecentManager.c = 0;
      return;
    }
    localQQLSRecentManager = this.n;
    long l1 = QQLSRecentManager.b;
    localQQLSRecentManager = this.n;
    if (l1 < QQLSRecentManager.a)
    {
      localQQLSRecentManager = this.n;
      QQLSRecentManager.b = QQLSRecentManager.a;
      localQQLSRecentManager = this.n;
      QQLSRecentManager.c = 0;
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "clearRemindTime");
    }
    QQLSRecentManager localQQLSRecentManager = this.n;
    QQLSRecentManager.a = 0L;
    QQLSRecentManager.b = 0L;
    QQLSRecentManager.c = 0;
  }
  
  @TargetApi(9)
  private void p()
  {
    this.C = ((TouchProxyRelativeLayout)findViewById(2131442597));
    Object localObject = this.C;
    if (localObject == null)
    {
      QLog.e("QQLSActivity", 1, "UI is null finish");
      finish();
      return;
    }
    ((TouchProxyRelativeLayout)localObject).setVisibility(0);
    this.R = ((RelativeLayout)findViewById(2131446042));
    this.O = ((MaxHeightRelativelayout)findViewById(2131444382));
    localObject = this.O;
    double d1 = getResources().getDisplayMetrics().density * 356.0F;
    Double.isNaN(d1);
    ((MaxHeightRelativelayout)localObject).setMaxHeight((int)(d1 + 0.5D));
    this.P = ((XListView)findViewById(2131444379));
    this.P.setDivider(getResources().getDrawable(2130847025));
    this.T = ((XListView)findViewById(2131446043));
    this.T.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.T.setOverScrollMode(2);
    }
    this.T.setTranscriptMode(2);
    this.T.setDivider(null);
    this.N = ((XEditTextEx)findViewById(2131435843));
    this.E = ((Button)findViewById(2131429991));
    this.F = ((LSRecordPanel)findViewById(2131439813));
    this.D = ((RelativeLayout)findViewById(2131429840));
    this.V = ((TextView)findViewById(2131444394));
    this.W = ((TextView)findViewById(2131446046));
    this.N.addTextChangedListener(this);
    this.E.setOnClickListener(this);
    this.F.a(this.X, this.C, this);
    this.D.setContentDescription(getString(2131887812));
    this.K = ((TextView)findViewById(2131434516));
    this.D.setOnClickListener(this);
    this.P.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.P.setOverScrollMode(2);
    }
    this.P.setOnItemClickListener(new QQLSActivity.3(this));
    this.Q = new QQLSActivity.RecentItemAdapter(this);
    this.P.setAdapter(this.Q);
    this.N.setCursorVisible(false);
    this.N.setOnTouchListener(new QQLSActivity.4(this));
    DeviceLib.a(this, this.N);
    this.S = new QQLSActivity.SingleItemAdapter(this);
    this.T.setAdapter(this.S);
    this.T.setOnTouchListener(this.A);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "initUI updateUI");
    }
    c();
  }
  
  private void q()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUI thread");
      localStringBuilder.append(Thread.currentThread().getId());
      QLog.d("QQLSActivity", 2, localStringBuilder.toString());
    }
    if (!this.aC) {
      return;
    }
    Object localObject1 = (InputMethodManager)getSystemService("input_method");
    int i1 = this.R.getVisibility();
    int i2 = 1;
    if (i1 == 8) {
      try
      {
        ((InputMethodManager)localObject1).hideSoftInputFromWindow(this.N.getWindowToken(), 0);
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateUI error: ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.d("QQLSActivity", 1, ((StringBuilder)localObject2).toString());
      }
    }
    ArrayList localArrayList = new ArrayList(this.n.b());
    if (localArrayList.size() == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("recentBaseData size = 0,  finish");
        ((StringBuilder)localObject2).append(Thread.currentThread().getId());
        QLog.d("QQLSActivity", 2, ((StringBuilder)localObject2).toString());
      }
      finish();
      if ((getIntent().getFlags() & 0x100000) != 0)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setClass(this, SplashActivity.class);
        ((Intent)localObject2).setFlags(67108864);
        ((Intent)localObject2).putExtra("tab_index", FrameControllerUtil.a);
        ((Intent)localObject2).putExtra("fragment_id", 1);
        startActivity((Intent)localObject2);
      }
    }
    if (localArrayList.size() == 1)
    {
      this.C.a = this.F;
      this.P.setVisibility(8);
      if (this.R.getVisibility() == 8)
      {
        MediaPlayerManager.a(this.X).a(false);
        MediaPlayerManager.a(this.X).a(this.P);
        MediaPlayerManager.a(this.X).a(this.T, this.S, this, this, true, false);
      }
      this.R.setVisibility(0);
      this.U = ((RecentBaseData)localArrayList.get(0));
      r();
    }
    else
    {
      this.C.a = null;
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(this.N.getWindowToken(), 0);
      if (this.R.getVisibility() == 0)
      {
        MediaPlayerManager.a(this.X).a(false);
        MediaPlayerManager.a(this.X).a(this.T);
        MediaPlayerManager.a(this.X).a(this.P, this.Q, this, this, false, false);
      }
      localObject1 = MediaPlayerManager.a(this.X).f();
      if (localObject1 != null)
      {
        localObject2 = localArrayList.iterator();
        Object localObject3;
        do
        {
          i1 = i2;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (RecentBaseData)((Iterator)localObject2).next();
          localObject3 = this.X.getMessageFacade().getLastMessage(((RecentBaseData)localObject3).getRecentUserUin(), ((RecentBaseData)localObject3).getRecentUserType());
        } while ((((MessageRecord)localObject3).uniseq != ((ChatMessage)localObject1).uniseq) || (((MessageRecord)localObject3).istroop != ((ChatMessage)localObject1).istroop));
        i1 = 0;
        if (i1 != 0) {
          MediaPlayerManager.a(this.X).a(false);
        }
      }
      this.R.setVisibility(8);
      this.P.setVisibility(0);
      this.Q.a(localArrayList);
    }
    this.aD = SystemClock.uptimeMillis();
    localObject1 = this.aI.obtainMessage(12);
    this.aI.sendMessageDelayed((android.os.Message)localObject1, 350L);
    this.ae = false;
    localObject1 = this.X;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(localArrayList.size());
    ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X80040DA", "0X80040DA", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
  }
  
  private void r()
  {
    Object localObject1 = this.R;
    if ((localObject1 != null) && (this.U != null))
    {
      localObject1 = (RelativeLayout)((RelativeLayout)localObject1).findViewById(2131442431);
      Object localObject2 = (TextView)this.R.findViewById(2131442429);
      TextView localTextView = (TextView)this.R.findViewById(2131442434);
      DragTextView localDragTextView = (DragTextView)this.R.findViewById(2131442435);
      localDragTextView.setOnModeChangeListener(this.o);
      localDragTextView.setDragViewType(0);
      localDragTextView.setTag(Integer.valueOf(1000));
      this.R.setFocusable(true);
      ((RelativeLayout)localObject1).setOnTouchListener(this.A);
      ((RelativeLayout)localObject1).requestLayout();
      RecentBaseData localRecentBaseData = this.U;
      String str1 = "QQLSActivity";
      if ((localRecentBaseData != null) && (localRecentBaseData.getRecentUserType() == 8) && (localRecentBaseData.mExtraType == 25))
      {
        localObject1 = (IPhoneContactService)this.X.getRuntimeService(IPhoneContactService.class, "");
        if (localObject1 != null) {
          localObject1 = ((IPhoneContactService)localObject1).queryContactByCodeNumber(localRecentBaseData.mPhoneNumber);
        } else {
          localObject1 = null;
        }
        if (localObject1 != null)
        {
          localRecentBaseData.mTitleName = ((PhoneContact)localObject1).name;
        }
        else
        {
          localObject1 = ((QCallCardManager)this.X.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(localRecentBaseData.getRecentUserUin());
          if (localObject1 != null) {
            localRecentBaseData.mTitleName = ((QCallCardInfo)localObject1).nickname;
          }
        }
        if (localRecentBaseData.mTitleName.equals(localRecentBaseData.getRecentUserUin())) {
          localRecentBaseData.mTitleName = localRecentBaseData.mPhoneNumber;
        }
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateSingleUI mTitleName = ");
          ((StringBuilder)localObject1).append(localRecentBaseData.mTitleName);
          QLog.d("QQLSActivity", 4, ((StringBuilder)localObject1).toString());
        }
      }
      ((TextView)localObject2).setText(localRecentBaseData.mTitleName);
      localTextView.setText(localRecentBaseData.mShowTime);
      int i1;
      if ((localRecentBaseData.getRecentUserType() != 7000) && (localRecentBaseData.getRecentUserType() != 4000) && (localRecentBaseData.getRecentUserType() != 1001) && (localRecentBaseData.getRecentUserType() != 10002) && (localRecentBaseData.getRecentUserType() != 1010) && (localRecentBaseData.getRecentUserType() != 1012) && (localRecentBaseData.getRecentUserType() != 1030) && (localRecentBaseData.getRecentUserType() != 9002) && (localRecentBaseData.getRecentUserType() != 9501) && (localRecentBaseData.getRecentUserType() != 7432) && (localRecentBaseData.getRecentUserType() != 9653) && (localRecentBaseData.getRecentUserType() != 7220) && ((localRecentBaseData.getRecentUserType() != 1008) || (!AppConstants.KANDIAN_DAILY_UIN.equals(localRecentBaseData.getRecentUserUin()))) && ((localRecentBaseData.getRecentUserType() != 1008) || (!AppConstants.NEW_KANDIAN_UIN.equals(localRecentBaseData.getRecentUserUin()))) && (localRecentBaseData.getRecentUserType() != 1032) && (localRecentBaseData.getRecentUserType() != 1035) && (localRecentBaseData.getRecentUserType() != 1041) && (localRecentBaseData.getRecentUserType() != 1042) && (localRecentBaseData.getRecentUserType() != 10007))
      {
        this.R.findViewById(2131435819).setVisibility(0);
        i1 = 1;
      }
      else
      {
        this.R.findViewById(2131435819).setVisibility(8);
        i1 = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateSingleUI type=");
        ((StringBuilder)localObject1).append(localRecentBaseData.getRecentUserType());
        QLog.d("QQLSActivity", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = (RelativeLayout.LayoutParams)localDragTextView.getLayoutParams();
      if ((localRecentBaseData.getRecentUserType() != 1012) && (localRecentBaseData.getRecentUserType() != 1030) && (localRecentBaseData.getRecentUserType() != 7432) && (localRecentBaseData.getRecentUserType() != 9653) && (localRecentBaseData.getRecentUserType() != 1035))
      {
        ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
        this.R.findViewById(2131442431).setVisibility(0);
      }
      else
      {
        this.R.findViewById(2131442431).setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(this.r * 18.0F));
      }
      String str2 = this.U.getRecentUserUin();
      localObject1 = this.U;
      if ((localObject1 instanceof RecentUserBaseData)) {
        localObject1 = ((RecentUserBaseData)localObject1).g();
      } else {
        localObject1 = str2;
      }
      int i3 = this.U.getRecentUserType();
      if ((i3 == 1030) && ((this.U instanceof RecentItemNoticeData)))
      {
        localObject2 = new PushReportController.PushReportItem();
        ((PushReportController.PushReportItem)localObject2).e = "0X800923E";
        ((PushReportController.PushReportItem)localObject2).d = "Android锁屏弹窗";
        PushReportController.a(((RecentItemNoticeData)this.U).url, (PushReportController.PushReportItem)localObject2);
        PushReportController.a(this.X, (PushReportController.PushReportItem)localObject2);
      }
      else if (e(i3))
      {
        localObject2 = this.U;
        if ((localObject2 instanceof RecentItemNoticeData))
        {
          localObject2 = ((RecentItemNoticeData)localObject2).intent;
          PushNoticeManager.a(this.X, ((Intent)localObject2).getStringExtra("push_notice_service_id"), ((Intent)localObject2).getStringExtra("push_notice_content_id"), ((RecentItemNoticeData)this.U).url, "0X800923E", "Android锁屏弹窗");
        }
      }
      List localList = c(str2, i3);
      if ((localList != null) && (localList.size() != 0))
      {
        localObject2 = localRecentBaseData.mShowTime;
        long l1 = localRecentBaseData.mDisplayTime;
        int i2 = 0;
        while (i2 < localList.size())
        {
          long l2;
          if (((MessageRecord)localList.get(i2)).msgtype == -2009)
          {
            l2 = l1;
            if (((MessageRecord)localList.get(i2)).time > l1)
            {
              l2 = ((MessageRecord)localList.get(i2)).time;
              localObject2 = TimeManager.a().a(((MessageRecord)localList.get(i2)).frienduin, ((MessageRecord)localList.get(i2)).time);
            }
          }
          else
          {
            l2 = l1;
          }
          i2 += 1;
          l1 = l2;
        }
        localRecentBaseData.mDisplayTime = l1;
        localTextView.setText((CharSequence)localObject2);
        this.S.a(localList);
        this.F.a(str2, i3, (String)localObject1);
        this.T.setSelection(this.S.getCount() - 1);
        i2 = GesturePWDUtils.getGesturePWDState(this, this.X.getCurrentAccountUin());
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("set mGesturePasswordState=");
          ((StringBuilder)localObject1).append(i2);
          QLog.d(str1, 2, ((StringBuilder)localObject1).toString());
        }
        if (i2 == 2)
        {
          this.R.findViewById(2131435819).setVisibility(8);
          i1 = 0;
        }
        if (i1 != 0)
        {
          this.C.a = this.F;
          if (LsRecordConfig.b(this.X))
          {
            d(-1);
            this.L = true;
            LsRecordConfig.a(this.X);
          }
          else if (this.L)
          {
            z();
          }
        }
        else
        {
          this.C.a = null;
        }
        if (localRecentBaseData.getRecentUserType() == 4000)
        {
          CustomWidgetUtil.a(localDragTextView, 3, localRecentBaseData.mUnreadNum, 0);
          return;
        }
        if ((localRecentBaseData.getRecentUserType() != 1001) && (localRecentBaseData.getRecentUserType() != 1010) && (localRecentBaseData.getRecentUserType() != 10002))
        {
          if (localRecentBaseData.getRecentUserType() == 7000)
          {
            CustomWidgetUtil.a(localDragTextView, 3, this.X.getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType()), 0);
            return;
          }
          if (localRecentBaseData.getRecentUserType() == 1032)
          {
            CustomWidgetUtil.a(localDragTextView, 3, this.X.getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType()), 0);
            return;
          }
          i1 = localList.size();
          localObject1 = localList.iterator();
          while (((Iterator)localObject1).hasNext()) {
            if (UniteGrayTipMsgUtil.b((MessageRecord)((Iterator)localObject1).next())) {
              i1 -= 1;
            }
          }
          CustomWidgetUtil.a(localDragTextView, 3, i1, 0);
          return;
        }
        localObject1 = this.X.getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        CustomWidgetUtil.a(localDragTextView, 3, this.X.getConversationFacade().a(((MessageRecord)localObject1).senderuin, localRecentBaseData.getRecentUserType()), 0);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("LSActivity mSingleAdapter size =0 finish");
        ((StringBuilder)localObject1).append(Thread.currentThread().getId());
        QLog.e("QQLSActivity", 2, ((StringBuilder)localObject1).toString());
      }
      finish();
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "go to wakeUpScreen==========================");
    }
    if (t())
    {
      Object localObject = this.j;
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "wakeUpScreen proximitySensor=null");
        }
        x();
        return;
      }
      if ((localObject != null) && (((QQLSSensor)localObject).a))
      {
        localObject = this.n;
        if (QQLSRecentManager.g)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "some phone need to bright early");
          }
          x();
          return;
        }
        if (this.aA)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose  firstTimeToWakeScreen acquireWakeLock");
          }
          w();
          ReportController.b(this.X, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
          return;
        }
        if (this.az)
        {
          w();
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose acquireWakeLock");
          }
          ReportController.b(this.X, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "wakeUpScreen acquireBrightWakeLock");
        }
        x();
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("wakeUpScreen hasSensor=");
        QQLSSensor localQQLSSensor = this.j;
        boolean bool;
        if (localQQLSSensor != null) {
          bool = localQQLSSensor.a;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject).append(bool);
        QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
      }
      ReportController.b(this.X, "CliOper", "", "", "0X800477A", "0X800477A", 0, 0, "", "", "", "");
      x();
    }
  }
  
  private boolean t()
  {
    long l1 = System.currentTimeMillis();
    QQLSRecentManager localQQLSRecentManager;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("judge need to wake up, now =");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", firstMsgTime =");
      localQQLSRecentManager = this.n;
      ((StringBuilder)localObject).append(QQLSRecentManager.a);
      ((StringBuilder)localObject).append(", lastWakeUpTime = ");
      localQQLSRecentManager = this.n;
      ((StringBuilder)localObject).append(QQLSRecentManager.b);
      ((StringBuilder)localObject).append(", wakeUpTimeAfter30Minute =");
      localQQLSRecentManager = this.n;
      ((StringBuilder)localObject).append(QQLSRecentManager.c);
      QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.n;
    if (QQLSRecentManager.f)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "troop message don't need bright");
      }
      return false;
    }
    localObject = this.n;
    if (QQLSRecentManager.a == 0L)
    {
      localObject = this.n;
      QQLSRecentManager.a = System.currentTimeMillis();
    }
    localObject = this.n;
    if (l1 < QQLSRecentManager.a + 1800000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "less than 30min ,need bright");
      }
      localObject = this.n;
      QQLSRecentManager.b = l1;
      QQLSRecentManager.d = false;
      return true;
    }
    localObject = this.n;
    long l2 = Math.min(6, QQLSRecentManager.c + 1) * 10 * 60 * 1000;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("has wakeup");
      localQQLSRecentManager = this.n;
      ((StringBuilder)localObject).append(QQLSRecentManager.c);
      ((StringBuilder)localObject).append("times");
      QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.n;
    if (l1 > QQLSRecentManager.b + l2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "over wakeuptime ,need bright");
      }
      localObject = this.n;
      QQLSRecentManager.d = true;
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "not bright screen");
    }
    return false;
  }
  
  @TargetApi(16)
  private boolean u()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 16) {
      try
      {
        if (this.t == null) {
          this.t = ((KeyguardManager)getSystemService("keyguard"));
        }
        bool = this.t.isKeyguardLocked();
      }
      catch (SecurityException localSecurityException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("kgm.isKeyguardLocked()=");
          localStringBuilder2.append(localSecurityException);
          QLog.e("QQLSActivity", 2, localStringBuilder2.toString());
        }
        return true;
      }
    } else {
      bool = QQUtils.a(this);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("isKeyguardLock=");
      localStringBuilder1.append(bool);
      QLog.e("QQLSActivity", 2, localStringBuilder1.toString());
    }
    return bool;
  }
  
  @TargetApi(16)
  private boolean v()
  {
    if ((Build.VERSION.SDK_INT == 20) && (Build.VERSION.RELEASE.equals("L")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "isKeyguardLock SDK is androidL !");
      }
      return true;
    }
    boolean bool;
    StringBuilder localStringBuilder1;
    if (Build.VERSION.SDK_INT >= 20)
    {
      bool = "1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.lock_screen_enterAIO.name(), "1"));
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("=======5.0enterAIO=======");
        localStringBuilder1.append(bool);
        QLog.d("QQLSActivity", 2, localStringBuilder1.toString());
      }
      if (!bool) {
        return true;
      }
    }
    if (Build.VERSION.SDK_INT >= 16) {
      try
      {
        if (this.t == null) {
          this.t = ((KeyguardManager)getSystemService("keyguard"));
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("kgm.isKeyguardLocked()=");
          localStringBuilder1.append(this.t.isKeyguardLocked());
          localStringBuilder1.append(". kgm.isKeyguardSecure()=");
          localStringBuilder1.append(this.t.isKeyguardSecure());
          QLog.e("QQLSActivity", 2, localStringBuilder1.toString());
        }
        if ((this.t != null) && (this.t.isKeyguardLocked()))
        {
          bool = this.t.isKeyguardSecure();
          if (bool) {
            return true;
          }
        }
        return false;
      }
      catch (SecurityException localSecurityException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("kgm.isKeyguardLocked()=");
          localStringBuilder2.append(localSecurityException);
          QLog.e("QQLSActivity", 2, localStringBuilder2.toString());
        }
      }
    }
    return true;
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "new wakeLock");
    }
  }
  
  private void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "new brightWakeLock  screen bright!!!");
    }
    QQLSRecentManager localQQLSRecentManager = this.n;
    if (QQLSRecentManager.d)
    {
      long l1 = System.currentTimeMillis();
      localQQLSRecentManager = this.n;
      QQLSRecentManager.b = l1;
      QQLSRecentManager.c += 1;
    }
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.14(this));
  }
  
  private void y()
  {
    Object localObject = this.n;
    if (QQLSRecentManager.g) {
      return;
    }
    if ((DeviceInfoUtil.V()) && (Build.VERSION.SDK_INT == 15))
    {
      localObject = this.n;
      QQLSRecentManager.g = true;
      return;
    }
    localObject = AppSetting.u;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPhoneNeedBright devicesInfo=== ");
      localStringBuilder.append((String)localObject);
      QLog.d("QQLSActivity", 2, localStringBuilder.toString());
    }
    if ((!((String)localObject).equalsIgnoreCase("oppo-x907")) && (!((String)localObject).equalsIgnoreCase("samsung-sch-i779")) && (!((String)localObject).equalsIgnoreCase("xiaomi-hm 1sc")) && (!((String)localObject).endsWith("lenovo-lenovo a390t")) && (!((String)localObject).endsWith("xiaomi-2013022")) && (!((String)localObject).endsWith("bbk-vivo x3t")) && (!((String)localObject).endsWith("bbk-vivo y3t")) && (!((String)localObject).endsWith("oppo-r813t")) && (!((String)localObject).endsWith("huawei-huawei t8833")) && (!((String)localObject).equalsIgnoreCase("unknown-K-Touch W619")) && (!((String)localObject).equalsIgnoreCase("COOLPAD-Coolpad 8079")) && (!((String)localObject).endsWith("K-Touch-K-Touch T780")) && (!((String)localObject).endsWith("HTC-HTC T328w")) && (!((String)localObject).endsWith("HUAWEI-HUAWEI U9508")))
    {
      localObject = this.n;
      if (QQLSRecentManager.a()) {
        return;
      }
      localObject = this.n;
      QQLSRecentManager.g = false;
      return;
    }
    localObject = this.n;
    QQLSRecentManager.g = true;
  }
  
  private void z()
  {
    this.aI.removeMessages(15);
    this.K.setVisibility(4);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.q;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
        return localArrayList;
      }
      localObject = this.q.iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.frienduin.equals(paramString)) && (localMessageRecord.istroop == paramInt)) {
          localArrayList.add(localMessageRecord);
        }
      }
      Collections.sort(localArrayList, this.y);
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    setVolumeControlStream(3);
  }
  
  protected void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    paramView = (QQLSActivity.SinglePttHolder)AIOUtils.b(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.create(this);
      paramView.setMainTitle(2131886575);
      paramView.addButton(2131886574);
      paramView.addCancelButton(2131887648);
      paramView.setOnButtonClickListener(new QQLSActivity.7(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() >= 1))
    {
      a(paramView, localMessageForPtt, true, false);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fileStatus:2001|url ");
        localStringBuilder.append(localMessageForPtt.url);
        localStringBuilder.append("|uniseq ");
        localStringBuilder.append(localMessageForPtt.uniseq);
        QLog.d("PTTItem->onErrorIconClick", 2, localStringBuilder.toString());
      }
      a(paramView, localMessageForPtt, 2001, false);
      return;
    }
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      QQToast.makeText(BaseApplication.getContext(), 2131892168, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 2131916077, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
  }
  
  protected void a(QQLSActivity.SinglePttHolder paramSinglePttHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fileStatus is:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",url is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.url);
      ((StringBuilder)localObject1).append(",uniseq is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.uniseq);
      ((StringBuilder)localObject1).append(",stt is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.sttAbility);
      ((StringBuilder)localObject1).append(",long is:");
      ((StringBuilder)localObject1).append(paramMessageForPtt.longPttVipFlag);
      QLog.d("QQLSActivity", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = "";
    paramSinglePttHolder.j.setTailMessage(false, null, null);
    Object localObject2 = getResources();
    Object localObject3;
    if (paramInt != -1)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          break;
        case 2004: 
        case 2005: 
          paramSinglePttHolder.f.setText("");
          paramSinglePttHolder.f.setPadding(AIOUtils.b(10.0F, (Resources)localObject2), BaseChatItemLayout.n, AIOUtils.b(10.0F, (Resources)localObject2), BaseChatItemLayout.o);
          paramSinglePttHolder.g.setAnimating(false);
          paramSinglePttHolder.e.setImageResource(2130847021);
          paramInt = 1;
        }
        break;
      case 1001: 
      case 1002: 
      case 1003: 
      case 1004: 
      case 1005: 
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("voiceLength showPttItem builder");
          ((StringBuilder)localObject1).append(paramMessageForPtt.voiceLength);
          QLog.d("QQLSActivity", 2, ((StringBuilder)localObject1).toString());
        }
        if (paramMessageForPtt.voiceLength <= 1) {
          paramMessageForPtt.voiceLength = ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(paramMessageForPtt);
        }
        if (paramMessageForPtt.voiceLength <= 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "get a amr file length = 0 return now");
          }
          paramSinglePttHolder.e.setImageDrawable(null);
          paramSinglePttHolder.e.setPadding(0, 0, 0, 0);
          paramSinglePttHolder.f.setText("");
          paramSinglePttHolder.f.setPadding(AIOUtils.b(10.0F, (Resources)localObject2), BaseChatItemLayout.n, AIOUtils.b(10.0F, (Resources)localObject2), BaseChatItemLayout.o);
          return;
        }
        int i1 = paramMessageForPtt.voiceLength;
        PttItemBuilder.a(this.X, "Normal_MaxPtt");
        if (paramMessageForPtt.voiceLength > PttItemBuilder.a(this.X, "ConvertText_MaxPtt")) {
          paramMessageForPtt.sttAbility = 0;
        }
        if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
          paramMessageForPtt.timeStr = PttItemBuilder.a(paramMessageForPtt.voiceLength);
        }
        localObject1 = paramMessageForPtt.timeStr;
        paramSinglePttHolder.f.setText((CharSequence)localObject1);
        paramSinglePttHolder.g.setAnimating(false);
        paramSinglePttHolder.g.setOnClickListener(this);
        if (paramBoolean)
        {
          localObject3 = (AnimationDrawable)((Resources)localObject2).getDrawable(2130772235);
          paramSinglePttHolder.e.setImageDrawable((Drawable)localObject3);
          ((AnimationDrawable)localObject3).start();
          paramSinglePttHolder.g.setBackgroundResource(2130842566);
          paramSinglePttHolder.f.setTextColor(getResources().getColor(2131165564));
        }
        else
        {
          paramSinglePttHolder.f.setTextColor(getResources().getColor(2131168464));
          if (paramMessageForPtt.isReadPtt) {
            paramSinglePttHolder.e.setImageResource(2130842564);
          } else {
            paramSinglePttHolder.e.setImageResource(2130847024);
          }
          paramSinglePttHolder.g.setBackgroundResource(2130842565);
        }
        if ((paramInt != 2003) && (paramInt != 1003))
        {
          if ((paramInt != 1005) && (paramInt != 1004)) {
            paramInt = 4;
          } else {
            paramInt = 1;
          }
        }
        else {
          paramInt = 0;
        }
        int i2 = AIOUtils.b(9.0F, (Resources)localObject2);
        int i3 = paramMessageForPtt.voiceLength;
        i1 = 15;
        if (i3 < 15) {
          i1 = paramMessageForPtt.voiceLength;
        }
        i1 = PttItemBuilder.a(this, i1, null, null, 0);
        paramSinglePttHolder.e.setPadding(i2, 0, 0, 0);
        paramSinglePttHolder.f.setPadding(BaseChatItemLayout.q, 0, i1, 0);
        break;
      }
    }
    else
    {
      paramSinglePttHolder.e.setImageDrawable(null);
      paramSinglePttHolder.e.setPadding(0, 0, 0, 0);
      paramSinglePttHolder.f.setText("");
      paramSinglePttHolder.f.setPadding(AIOUtils.b(40.0F, (Resources)localObject2), BaseChatItemLayout.n, AIOUtils.b(40.0F, (Resources)localObject2), BaseChatItemLayout.o);
      paramSinglePttHolder.g.setAnimating(true);
    }
    paramInt = 0;
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        paramSinglePttHolder.j.setFailedIconVisable(false, null);
        if (paramSinglePttHolder.j.ah != null) {
          paramSinglePttHolder.j.ah.setBackgroundDrawable(null);
        }
      }
      else
      {
        paramSinglePttHolder.j.setFailedIconResource(2130839590, this);
        paramSinglePttHolder.j.ah.setBackgroundDrawable(null);
        ((Animatable)paramSinglePttHolder.j.ah.getDrawable()).start();
      }
    }
    else
    {
      paramSinglePttHolder.j.setFailedIconVisable(true, this);
      paramSinglePttHolder.j.ah.setBackgroundDrawable(null);
      if (B)
      {
        localObject2 = paramSinglePttHolder.j.ah;
        if (paramMessageForPtt.isSendFromLocal()) {
          paramInt = 2131908068;
        } else {
          paramInt = 2131908071;
        }
        ((ImageView)localObject2).setContentDescription(HardCodeUtil.a(paramInt));
      }
    }
    if (B)
    {
      paramMessageForPtt = new StringBuilder();
      paramMessageForPtt.append(this.U.getTitleName());
      paramMessageForPtt.append(HardCodeUtil.a(2131908065));
      paramMessageForPtt = paramMessageForPtt.toString();
      localObject2 = paramSinglePttHolder.g;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramMessageForPtt);
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131908073));
      ((BreathAnimationLayout)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
      if (paramSinglePttHolder.d != null)
      {
        paramSinglePttHolder = paramSinglePttHolder.d;
        paramSinglePttHolder.append("发送了语音.");
        paramSinglePttHolder.append((String)localObject1);
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1) {
      i1 = 2;
    } else {
      i1 = 7;
    }
    ChatActivityFacade.a(this.X, paramMessageForPtt.frienduin, paramMessageForPtt, false, i1, 0, paramBoolean2);
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = AIOUtils.b(paramView);
      if ((paramXListView instanceof QQLSActivity.SinglePttHolder))
      {
        paramXListView = (QQLSActivity.SinglePttHolder)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, PttItemBuilder.a(this.X, paramView), false);
      }
    }
  }
  
  public void a(List<MessageRecord> paramList1, List<MessageRecord> paramList2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mergeSortList miscalllist size: ");
      localStringBuilder.append(paramList2.size());
      QLog.d("QQLSActivity", 2, localStringBuilder.toString());
    }
    paramList1.addAll(paramList2);
    Collections.sort(paramList1, this.y);
  }
  
  public void a(boolean paramBoolean)
  {
    this.az = paramBoolean;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sensor has callback sensorIsClose===");
      localStringBuilder.append(this.az);
      QLog.d("QQLSActivity", 2, localStringBuilder.toString());
    }
    if (this.az)
    {
      this.aA = false;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("callback firstTimeToWakeScreen=");
        localStringBuilder.append(this.aA);
        QLog.d("QQLSActivity", 2, localStringBuilder.toString());
      }
      if (this.aA)
      {
        if (t()) {
          x();
        } else {
          w();
        }
        this.aA = false;
      }
    }
    this.aB = true;
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "exitRecord been called !!!!");
    }
    paramInt = 0;
    int i1 = 0;
    if (paramBoolean1)
    {
      A();
      this.aC = true;
    }
    else
    {
      if (paramBoolean2)
      {
        this.M += 1;
        paramInt = i1;
        if (this.M >= 3)
        {
          paramInt = i1;
          if (LsRecordConfig.d(this.X))
          {
            d(2000);
            LsRecordConfig.c(this.X);
            this.M = 0;
            paramInt = i1;
          }
        }
      }
      else
      {
        paramInt = i1;
        if (paramString != null)
        {
          d(paramString, 2000);
          paramInt = 1;
        }
      }
      this.aC = true;
      if (!this.I) {
        c();
      } else {
        this.J = true;
      }
    }
    if (paramInt == 0) {
      b(paramBoolean3);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isResume()) {
      AudioPanelAioHelper.a(this.X.getApp(), paramBoolean2, false, false);
    }
    this.u = paramBoolean2;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, LSRecordPanel paramLSRecordPanel)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "handleRecording been called !!!!");
    }
    this.aC = false;
    if (this.R.getVisibility() == 0)
    {
      if (paramBoolean1)
      {
        d(HardCodeUtil.a(2131908074), -1);
        return;
      }
      if (paramBoolean2) {
        d(HardCodeUtil.a(2131908075), -1);
      }
    }
    else
    {
      b(false);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (isResume()) {
      AudioPanelAioHelper.a(this.X.getApp(), paramBoolean3, paramBoolean1, paramBoolean2);
    }
    this.u = paramBoolean3;
  }
  
  public boolean a()
  {
    if (this.X == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "app null,  finish");
      }
      finish();
      return true;
    }
    if (this.p == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "rcf null,  finish");
      }
      finish();
      return true;
    }
    if (this.a.shouldBlockMessageTips())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "pcm should block app");
      }
      finish();
      return true;
    }
    return false;
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.X).f();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    return (!paramXListView.isSend()) && (!paramXListView.isReadPtt) && (paramXListView.isReady());
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    ((IPTTPreDownloader)this.X.getRuntimeService(IPTTPreDownloader.class)).onPlayPTT(paramXListView);
    boolean bool2 = paramXListView.isReady();
    paramInt1 = 2;
    boolean bool1 = false;
    if (bool2)
    {
      paramView = AIOUtils.b(paramView);
      if (paramView != null)
      {
        if (!(paramView instanceof QQLSActivity.SinglePttHolder)) {
          return false;
        }
        paramView = (QQLSActivity.SinglePttHolder)paramView;
        paramAudioPlayerBase.a(6);
        if (paramAudioPlayerBase.a(paramXListView.getLocalFilePath()))
        {
          a(paramXListView);
          if (paramView != null) {
            a(paramView, paramXListView, PttItemBuilder.a(this.X, paramXListView), true);
          }
          PttInfoCollector.reportPttPlay(this.X, paramXListView.istroop, paramXListView.issend);
          if (!paramXListView.isSendFromLocal())
          {
            if (paramXListView.istroop == 0) {
              paramInt1 = 1;
            } else if (paramXListView.istroop == 1) {
              paramInt1 = 3;
            } else if (paramXListView.istroop != 3000) {
              paramInt1 = 4;
            }
            paramXListView = (IPttInfoCollector)QRoute.api(IPttInfoCollector.class);
            paramView = this.X;
            if (paramChatMessage.getPttStreamFlag() == 10001) {
              bool1 = true;
            }
            paramXListView.reportPTTPV(paramView, paramInt1, bool1, 1);
          }
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("play failed player return false ");
          paramView.append(paramXListView.getLocalFilePath());
          QLog.d("QQLSActivity", 2, paramView.toString());
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    else if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("play failed not ready ");
      paramView.append(paramXListView.getLocalFilePath());
      QLog.d("QQLSActivity", 2, paramView.toString());
    }
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      this.F.setVisibility(4);
      this.E.setVisibility(0);
      return;
    }
    this.F.setVisibility(0);
    this.E.setVisibility(4);
  }
  
  public int b(String paramString, int paramInt)
  {
    return this.p.f(paramString, paramInt);
  }
  
  public void b()
  {
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.2(this));
  }
  
  public void b(int paramInt)
  {
    setVolumeControlStream(paramInt);
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    if (!this.aI.hasMessages(13))
    {
      long l1 = SystemClock.uptimeMillis();
      android.os.Message localMessage = this.aI.obtainMessage(13);
      long l2 = this.aD;
      if ((l1 - l2 <= 1000L) && (l2 != -1L))
      {
        this.aI.sendMessageDelayed(localMessage, 1000L - (l1 - l2));
        return;
      }
      this.aI.sendMessage(localMessage);
    }
  }
  
  public void c(int paramInt)
  {
    if (isFinishing()) {
      return;
    }
    ToastStyleDialog localToastStyleDialog;
    if (paramInt == 0)
    {
      ReportController.b(this.X, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.v.removeMessages(25);
      localToastStyleDialog = this.aF;
      if ((localToastStyleDialog == null) || (!localToastStyleDialog.isShowing()))
      {
        this.aF = new ToastStyleDialog(this);
        this.aF.a(getString(2131896502));
        this.aF.show();
      }
    }
    else if (paramInt == 1)
    {
      localToastStyleDialog = this.aF;
      if ((localToastStyleDialog != null) && (localToastStyleDialog.isShowing()) && (this.aF.getWindow() != null)) {
        this.aF.dismiss();
      }
    }
  }
  
  public void d()
  {
    new SessionInfo();
    if (this.U == null) {
      return;
    }
    this.X.getMessageFacade().a(this.U.getRecentUserUin(), this.U.getRecentUserType());
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "QQLSActivity send removeNotification");
    }
    this.X.removeNotification();
    Object localObject1 = b(this.U);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" send start currenttime:");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      QLog.d("QQLSActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.N.getText().length() > 0)
    {
      localObject2 = this.N.getText().toString();
      if ((localObject2 != null) && (((String)localObject2).length() > 3478))
      {
        ChatActivityUtils.a(this, 2131916265, 1);
        return;
      }
      if (this.U.getRecentUserType() == 1)
      {
        localObject2 = new ArrayList();
        String str = AtTroopMemberSpan.a(this.N.getEditableText(), (ArrayList)localObject2);
        ChatActivityFacade.a(this.X, this, (SessionInfo)localObject1, str, (ArrayList)localObject2);
      }
      else
      {
        ChatActivityFacade.a(this.X, this, (SessionInfo)localObject1, (String)localObject2, null);
      }
      this.N.getEditableText().clear();
      this.N.setText("");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" msgReport start currenttime:");
        ((StringBuilder)localObject1).append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if ((this.K != null) && (this.L))
    {
      this.L = false;
      z();
    }
    try
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.e("QQLSActivity", 1, localIllegalArgumentException, new Object[0]);
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      QLog.e("QQLSActivity", 1, localIndexOutOfBoundsException, new Object[0]);
    }
    boolean bool = false;
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onBackPressed=== ");
    }
    o();
    A();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = this.n;
    QQLSRecentManager.e = true;
    this.aD = -1L;
    ActivityLifeCycleInfoRecordHelper.a(this);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "qqls dooncreate");
    }
    super.setContentView(2131627515);
    getWindow().addFlags(524288);
    this.r = getResources().getDisplayMetrics().scaledDensity;
    if (!QQLSRecentManager.f) {
      ThreadManager.getSubThreadHandler().post(new QQLSActivity.1(this));
    }
    paramBundle = this.aI.obtainMessage(7);
    this.aI.sendMessageDelayed(paramBundle, 1000L);
    this.X = ((QQAppInterface)getAppRuntime());
    this.p = ((QCallFacade)this.X.getManager(QQManagerFactory.RECENT_CALL_FACADE));
    this.a = ((IPhoneContactService)this.X.getRuntimeService(IPhoneContactService.class));
    this.m = ((ISubAccountService)this.X.getRuntimeService(ISubAccountService.class, ""));
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "doOncreate noNeedStart return");
      }
      return true;
    }
    this.q = this.p.d();
    this.n = ((QQLSRecentManager)this.X.getManager(QQManagerFactory.QQLS_DATA_MANAGER));
    paramBundle = this.n;
    QQLSRecentManager.i = false;
    p();
    this.X.addObserver(this.z);
    this.X.addObserver(this.aG);
    this.l = ((INewFriendService)this.X.getRuntimeService(INewFriendService.class));
    paramBundle = this.l;
    if (paramBundle != null)
    {
      paramBundle.addListener(this.aH);
      this.l.addObserver(this);
    }
    this.o = DragFrameLayout.a(this);
    this.o.a(this, false);
    this.s = new QQLSActivity.ScreenBroadcastReceiver(this, null);
    h();
    this.X.getMessageFacade().addObserver(this);
    n();
    this.aA = true;
    y();
    s();
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setLSAccountDetailRequestHandler(this.aI);
    a(getIntent());
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.X;
    if (localObject != null)
    {
      MediaPlayerManager.a((AppRuntime)localObject).a(this.T);
      MediaPlayerManager.a(this.X).a(this.P);
      aK.clear();
      this.aE = true;
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setLSAccountDetailRequestHandler(null);
      if (this.X.getMessageFacade() != null) {
        this.X.getMessageFacade().deleteObserver(this);
      }
      this.X.removeObserver(this.z);
      this.X.removeObserver(this.aG);
    }
    localObject = this.n;
    QQLSRecentManager.h = false;
    QQLSRecentManager.e = false;
    QQLSRecentManager.i = false;
    QQLSRecentManager.n = false;
    localObject = this.l;
    if (localObject != null)
    {
      ((INewFriendService)localObject).removeListener(this.aH);
      this.l.deleteObserver(this);
    }
    localObject = this.aI;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    b();
    if (this.s != null) {
      i();
    }
    this.P.setOnItemClickListener(null);
    super.doOnDestroy();
    b(false);
    ActivityLifeCycleInfoRecordHelper.d(this);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnNewIntent intent is not null");
    }
    QQLSRecentManager.n = false;
    Object localObject = this.n;
    QQLSRecentManager.e = true;
    this.aD = -1L;
    localObject = this.q;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = this.p;
    if (localObject != null) {
      this.q = ((QCallFacade)localObject).d();
    }
    if (!a())
    {
      n();
      if (this.aI.hasMessages(13)) {
        this.aI.removeMessages(13);
      }
      c();
    }
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ActivityLifeCycleInfoRecordHelper.c(this);
    this.mRuntime.isBackgroundPause = true;
    Object localObject = this.n;
    QQLSRecentManager.h = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onPause,isbackground_pause : true");
    }
    this.F.c();
    this.I = true;
    if (this.aI.hasMessages(8)) {
      this.aI.removeMessages(8);
    }
    localObject = this.aI.obtainMessage(8);
    this.aI.sendMessageDelayed((android.os.Message)localObject, 1500L);
    C();
    MediaPlayerManager.a(this.X).a(true);
    if (this.R.getVisibility() == 0)
    {
      MediaPlayerManager.a(this.X).a(this.T);
      return;
    }
    MediaPlayerManager.a(this.X).a(this.P);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume taskId");
      ((StringBuilder)localObject).append(getTaskId());
      QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
    }
    QQLSRecentManager.n = false;
    ActivityLifeCycleInfoRecordHelper.b(this);
    Object localObject = this.n;
    QQLSRecentManager.h = true;
    this.mRuntime.isBackgroundPause = true;
    if (this.N != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.N.getWindowToken(), 0);
    }
    localObject = this.aI.obtainMessage(11);
    this.aI.sendMessageDelayed((android.os.Message)localObject, 500L);
    this.I = false;
    if (this.J)
    {
      this.J = false;
      c();
    }
    if (this.R.getVisibility() == 0)
    {
      MediaPlayerManager.a(this.X).a(this.T, this.S, this, this, true, false);
      return;
    }
    MediaPlayerManager.a(this.X).a(this.P, this.Q, this, this, false, false);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    QQLSRecentManager localQQLSRecentManager = this.n;
    QQLSRecentManager.e = false;
    QQLSRecentManager.h = false;
    if (this.N != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.N.getWindowToken(), 0);
    }
    if (this.aI.hasMessages(8)) {
      this.aI.removeMessages(8);
    }
    b();
  }
  
  public void e()
  {
    getWindow().addFlags(128);
  }
  
  public void f()
  {
    setVolumeControlStream(3);
    getWindow().clearFlags(128);
    this.v.sendEmptyMessageDelayed(25, 1000L);
  }
  
  public void finish()
  {
    TouchProxyRelativeLayout localTouchProxyRelativeLayout = this.C;
    if (localTouchProxyRelativeLayout != null) {
      try
      {
        localTouchProxyRelativeLayout.setVisibility(4);
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, localException1, new Object[0]);
        }
      }
    }
    QQLSRecentManager localQQLSRecentManager = this.n;
    QQLSRecentManager.h = false;
    if (localQQLSRecentManager != null) {
      localQQLSRecentManager.c();
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQLSActivity", 2, "LSActivity finish");
    }
    try
    {
      super.finish();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("QQLSActivity", 2, localException2, new Object[0]);
    }
  }
  
  public void g()
  {
    Object localObject = this.S;
    if (localObject != null) {
      ((QQLSActivity.SingleItemAdapter)localObject).notifyDataSetChanged();
    }
    localObject = this.Q;
    if (localObject != null) {
      ((QQLSActivity.RecentItemAdapter)localObject).notifyDataSetChanged();
    }
  }
  
  public void h()
  {
    ThreadManager.executeOnSubThread(new QQLSActivity.15(this), true);
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.fileType == 2) && (paramInt1 != 2002) && (paramInt1 != 1002))
    {
      if (paramInt1 == 2001) {
        return;
      }
      paramView = (QQLSActivity.SinglePttHolder)paramView.getTag();
      MessageForPtt localMessageForPtt = (MessageForPtt)paramView.q;
      if (localMessageForPtt != null)
      {
        if (localMessageForPtt.uniseq != paramFileMsg.uniseq) {
          return;
        }
        if ((paramInt1 != 1003) && (paramInt1 != 2003))
        {
          if ((paramFileMsg.status != 1005) && (paramFileMsg.status != 1004))
          {
            if (localMessageForPtt.fileSize == -2L)
            {
              paramInt2 = 999;
            }
            else if (localMessageForPtt.fileSize == -3L)
            {
              paramInt2 = 1001;
            }
            else if (localMessageForPtt.fileSize == -1L)
            {
              paramInt2 = 1005;
            }
            else
            {
              paramInt2 = paramInt1;
              if (paramInt1 == 2005)
              {
                localMessageForPtt.fileSize = -4L;
                paramInt2 = paramInt1;
              }
            }
          }
          else
          {
            g();
            paramInt2 = paramInt1;
          }
        }
        else
        {
          paramInt2 = paramInt1;
          if (!paramFileMsg.isStreamMode)
          {
            paramInt2 = paramInt1;
            if (paramInt1 == 2003)
            {
              g();
              paramInt2 = paramInt1;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramFileMsg = new StringBuilder();
          paramFileMsg.append("fileStatus:");
          paramFileMsg.append(paramInt2);
          paramFileMsg.append("|url ");
          paramFileMsg.append(localMessageForPtt.url);
          paramFileMsg.append("|uniseq ");
          paramFileMsg.append(localMessageForPtt.uniseq);
          QLog.d("PTTItem->handleMessage", 2, paramFileMsg.toString());
        }
        a(paramView, localMessageForPtt, paramInt2, a(localMessageForPtt));
      }
    }
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 17)
    {
      if (i1 != 25)
      {
        if (i1 == 99)
        {
          B();
          finish();
        }
      }
      else
      {
        paramMessage = this.aF;
        if ((paramMessage != null) && (paramMessage.isShowing()) && (this.aF.getWindow() != null) && (!isFinishing()))
        {
          this.aF.dismiss();
          this.aF = null;
        }
      }
    }
    else {
      this.S.notifyDataSetChanged();
    }
    return false;
  }
  
  public void i()
  {
    ThreadManager.executeOnSubThread(new QQLSActivity.16(this), true);
  }
  
  public void j()
  {
    if (this.G != null) {
      return;
    }
    if (MediaPlayerManager.a(this.X).g()) {
      MediaPlayerManager.a(this.X).a(true);
    }
    View localView = new View(this.C.getContext());
    localView.setBackgroundColor(-16777216);
    localView.setVisibility(0);
    Object localObject = new Rect();
    this.C.getGlobalVisibleRect((Rect)localObject);
    Rect localRect = new Rect();
    this.F.getGlobalVisibleRect(localRect);
    localObject = new RelativeLayout.LayoutParams(localRect.right - ((Rect)localObject).left, localRect.top - ((Rect)localObject).top);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    this.C.addView(localView, (ViewGroup.LayoutParams)localObject);
    localObject = new AlphaAnimation(0.0F, 0.6F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(300L);
    localView.startAnimation((Animation)localObject);
    this.G = localView;
  }
  
  public void k()
  {
    if (this.G == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.6F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setAnimationListener(new QQLSActivity.17(this));
    this.G.startAnimation(localAlphaAnimation);
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChange isDone ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChange mDragHost.getMode() ");
      ((StringBuilder)localObject).append(this.o.getMode());
      QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramDragFrameLayout = paramDragFrameLayout.getDragView();
      if ((paramDragFrameLayout != null) && (paramDragFrameLayout.getTag() != null))
      {
        paramInt = ((Integer)paramDragFrameLayout.getTag()).intValue();
        if (QLog.isColorLevel())
        {
          paramDragFrameLayout = new StringBuilder();
          paramDragFrameLayout.append("delete onChange position=");
          paramDragFrameLayout.append(paramInt);
          QLog.d("QQLSActivity", 2, paramDragFrameLayout.toString());
        }
        if (paramInt == 1000)
        {
          paramInt = ((MessageRecord)this.S.a.get(0)).istroop;
          paramDragFrameLayout = ((MessageRecord)this.S.a.get(0)).frienduin;
          if ((paramInt != 1001) && (paramInt != 1010) && (paramInt != 10002))
          {
            if (paramInt == 4000)
            {
              this.l.markAllDataReaded();
            }
            else if (paramInt == 7000)
            {
              ((MessageHandler)this.X.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).C().a(paramDragFrameLayout, null);
              localObject = (ISubAccountService)this.X.getRuntimeService(ISubAccountService.class, "");
              if (localObject != null) {
                ((ISubAccountService)localObject).setAllMessageReaded(paramDragFrameLayout);
              }
            }
            else if (paramInt == 1012)
            {
              localObject = (DatingProxyManager)this.X.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
              if (localObject != null) {
                ((DatingProxyManager)localObject).a().b();
              }
            }
            else if (paramInt == 1030)
            {
              if (this.X.isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER))
              {
                ((CampusNoticeManager)this.X.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(null);
                if (QLog.isColorLevel()) {
                  QLog.d("notification", 2, "remove campus notice from LSA");
                }
              }
            }
            else if (paramInt == 9653)
            {
              ((PullActiveManager)this.X.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER)).b();
            }
            else if (UinTypeUtil.e(paramInt) == 1032)
            {
              this.X.getConversationFacade().e();
              this.X.getMessageFacade().b(AppConstants.CONFESS_UIN, 1032);
            }
            else if ((e(paramInt)) && (this.X.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER)))
            {
              ((PushNoticeManager)this.X.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a(null, paramInt);
              if (QLog.isColorLevel()) {
                QLog.d("notification", 2, "remove push notice from LSA");
              }
            }
          }
          else {
            ((MessageHandler)this.X.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a(paramDragFrameLayout, paramInt, false);
          }
          RecentUtil.b(this.X, paramDragFrameLayout, paramInt);
          this.X.getMessageFacade().a(paramDragFrameLayout, paramInt);
          this.p.a(paramDragFrameLayout, paramInt);
          this.q.clear();
          this.q = this.p.d();
          if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "QQLSActivity onChange removeNotification");
          }
          this.X.removeNotification();
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "single data remove finish");
          }
          A();
          if (paramInt == 3000)
          {
            ReportController.b(this.X, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
            return;
          }
          if (paramInt == 1)
          {
            ReportController.b(this.X, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
            return;
          }
          if (paramInt == 0)
          {
            ReportController.b(this.X, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
            return;
          }
          if ((paramInt == 1001) || (paramInt == 1010) || (paramInt == 10002)) {
            ReportController.b(this.X, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
          }
          return;
        }
        if (QQLSActivity.RecentItemAdapter.a(this.Q).size() <= paramInt) {
          return;
        }
        int i1 = ((RecentBaseData)QQLSActivity.RecentItemAdapter.a(this.Q).get(paramInt)).getRecentUserType();
        paramDragFrameLayout = ((RecentBaseData)QQLSActivity.RecentItemAdapter.a(this.Q).get(paramInt)).getRecentUserUin();
        RecentUtil.b(this.X, paramDragFrameLayout, i1);
        if ((i1 != 1001) && (i1 != 1010) && (i1 != 10002))
        {
          if (i1 == 4000)
          {
            this.l.markAllDataReaded();
            this.X.getMessageFacade().d.a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
            this.X.getMessageFacade().d.a(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
          }
          else if (i1 == 7000)
          {
            ((MessageHandler)this.X.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).C().a(paramDragFrameLayout, null);
            localObject = (ISubAccountService)this.X.getRuntimeService(ISubAccountService.class, "");
            if (localObject != null) {
              ((ISubAccountService)localObject).setAllMessageReaded(paramDragFrameLayout);
            }
          }
          else if (i1 == 1012)
          {
            localObject = (DatingProxyManager)this.X.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
            if (localObject != null) {
              ((DatingProxyManager)localObject).a().b();
            }
          }
          else if (i1 == 1030)
          {
            if (this.X.isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER))
            {
              ((CampusNoticeManager)this.X.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(null);
              if (QLog.isColorLevel()) {
                QLog.d("notification", 2, "remove campus notice from LSA");
              }
            }
          }
          else if (i1 == 9653)
          {
            ((PullActiveManager)this.X.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER)).b();
          }
          else if (UinTypeUtil.e(i1) == 1032)
          {
            this.X.getConversationFacade().e();
            this.X.getMessageFacade().b(AppConstants.CONFESS_UIN, 1032);
          }
          else if (e(i1))
          {
            if (this.X.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER))
            {
              ((PushNoticeManager)this.X.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a(null, i1);
              if (QLog.isColorLevel()) {
                QLog.d("notification", 2, "remove push notice from LSA");
              }
            }
          }
          else
          {
            this.X.getMessageFacade().a(paramDragFrameLayout, i1);
            this.p.a(paramDragFrameLayout, i1);
            this.q.clear();
            this.q = this.p.d();
          }
        }
        else
        {
          ((MessageHandler)this.X.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a(paramDragFrameLayout, i1, false);
          this.X.getMessageFacade().d.b(i1);
        }
        this.X.getMessageFacade().d.a(paramDragFrameLayout, i1);
        QQLSActivity.RecentItemAdapter.a(this.Q).remove(paramInt);
        this.Q.notifyDataSetChanged();
        if (i1 == 3000) {
          ReportController.b(this.X, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
        } else if (i1 == 1) {
          ReportController.b(this.X, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
        } else if (i1 == 0) {
          ReportController.b(this.X, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
        } else if ((i1 == 1001) || (i1 == 1010) || (i1 == 10002)) {
          ReportController.b(this.X, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
        }
        this.n.a(paramDragFrameLayout, i1);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("QQLSActivity", 2, "dragView = null");
        return;
      }
    }
    if (this.o.getMode() == -1)
    {
      if (QLog.isColorLevel())
      {
        paramDragFrameLayout = new StringBuilder();
        paramDragFrameLayout.append("onChange updateUI");
        paramDragFrameLayout.append(Thread.currentThread().getId());
        QLog.d("QQLSActivity", 2, paramDragFrameLayout.toString());
      }
      this.aC = true;
      runOnUiThread(new QQLSActivity.18(this));
      return;
    }
    this.aC = false;
  }
  
  public void onClick(View paramView)
  {
    if ((B) && (paramView.getId() == 2131429332))
    {
      paramView.findViewById(2131442193).performClick();
    }
    else
    {
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131442193: 
        localObject = (QQLSActivity.SinglePttHolder)AIOUtils.b(paramView);
        MessageForPtt localMessageForPtt = (MessageForPtt)((QQLSActivity.SinglePttHolder)localObject).q;
        if (a(localMessageForPtt)) {
          MediaPlayerManager.a(this.X).a(false);
        } else if ((localMessageForPtt != MediaPlayerManager.a(this.X).f()) && (localMessageForPtt.isReady())) {
          if (this.X.isVideoChatting())
          {
            QQToast.makeText(this, 1, 2131892896, 0).show(getResources().getDimensionPixelSize(2131299920));
          }
          else
          {
            boolean bool;
            if ((localObject instanceof QQLSActivity.RecentPttViewHolder)) {
              bool = MediaPlayerManager.a(this.X).a(AIOUtils.a(paramView));
            } else {
              bool = MediaPlayerManager.a(this.X).a(AIOUtils.a(paramView));
            }
            if (!bool) {
              QQToast.makeText(this, 1, 2131892895, 0).show(getResources().getDimensionPixelSize(2131299920));
            }
          }
        }
        if (localMessageForPtt.istroop == 1008) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.X, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", localMessageForPtt.timeStr, "", false);
        }
        break;
      case 2131430585: 
        a(paramView);
        break;
      case 2131429991: 
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "onClick btn_reply");
        }
        o();
        localObject = this.N;
        if ((localObject == null) || (((XEditTextEx)localObject).getText().length() != 0)) {
          if (this.U == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "onClick mSingleRecentBaseData=null return");
            }
          }
          else
          {
            if (this.N != null) {
              ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.N.getWindowToken(), 0);
            }
            Toast.makeText(getApplicationContext(), getString(2131896996), 0).show();
            if (this.U.getRecentUserType() == 3000) {
              ReportController.b(this.X, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "1", "", "", "");
            } else if (this.U.getRecentUserType() == 1) {
              ReportController.b(this.X, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "2", "", "", "");
            } else {
              ReportController.b(this.X, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "0", "", "", "");
            }
            localObject = this.aI.obtainMessage(1);
            this.aI.sendMessageDelayed((android.os.Message)localObject, 100L);
          }
        }
        break;
      case 2131429840: 
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "onClick btn_close");
        }
        QQLSRecentManager.l = System.currentTimeMillis();
        o();
        ReportController.b(this.X, "CliOper", "", "", "0X80040DE", "0X80040DE", 0, 0, "", "", "", "");
        A();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "logout finish");
    }
    A();
    super.onLogout(paramLogoutReason);
  }
  
  @Deprecated
  protected void onStart()
  {
    Foreground.sCountActivity.getAndDecrement();
    super.onStart();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStart taskId");
      ((StringBuilder)localObject).append(getTaskId());
      QLog.d("QQLSActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (getTaskId() == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "getTadk = -1 finish LS ,or onresume will get badToken!");
      }
      finish();
      try
      {
        localObject = Activity.class.getDeclaredField("mFinished");
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).get(this);
        ((Field)localObject).set(this, Boolean.valueOf(true));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Foreground.sCountActivity.incrementAndGet();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onUserLeaveHint()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onUserLeaveHint");
    }
    QQLSRecentManager.n = false;
    o();
    super.onUserLeaveHint();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObservable = new StringBuilder();
      paramObservable.append("update");
      paramObservable.append(Thread.currentThread().getId());
      QLog.d("QQLSActivity", 2, paramObservable.toString());
    }
    boolean bool = u();
    if (QLog.isColorLevel())
    {
      paramObservable = new StringBuilder();
      paramObservable.append("LS update isScreenLocked");
      paramObservable.append(bool);
      QLog.d("QQLSActivity", 2, paramObservable.toString());
    }
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "LS update screen is unLock finish!!!");
      }
      paramObservable = this.aI.obtainMessage(2);
      this.aI.sendMessage(paramObservable);
      return;
    }
    if (isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "LS update screen is finishing not update");
      }
      return;
    }
    paramObservable = this.N;
    if ((paramObservable != null) && (paramObservable.getVisibility() == 0) && (!TextUtils.isEmpty(this.N.getText())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "LS update user is sendMsg not update");
      }
      return;
    }
    bool = false;
    this.aB = false;
    if ((paramObject != null) && ((paramObject instanceof NewFriendMessage)))
    {
      if (QLog.isColorLevel())
      {
        paramObservable = new StringBuilder();
        paramObservable.append("data is NewFriendMessage");
        paramObservable.append(Thread.currentThread().getId());
        QLog.d("QQLSActivity", 2, paramObservable.toString());
      }
      if (this.l.getAllUnreadMessageCount() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "data is NewFriendMessage unread=0 update return");
        }
        return;
      }
      if ((paramObject instanceof FriendSystemMessage)) {
        a((FriendSystemMessage)paramObject);
      }
      this.n.a(this.X, AppConstants.RECOMMEND_CONTACT_UIN, 4000, false, -1, false);
      c();
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof RecentItemVoteData)))
    {
      paramObservable = ((RecentItemVoteData)paramObject).e();
      this.n.a(this.X, paramObservable.uin, paramObservable.msgType, false, -1, false);
      paramObservable = this.n;
      QQLSRecentManager.f = false;
      c();
    }
    else if ((paramObject != null) && ((paramObject instanceof RecentItemScheduleData)))
    {
      paramObservable = ((RecentItemScheduleData)paramObject).e();
      this.n.a(this.X, paramObservable.uin, paramObservable.msgType, false, -1, false);
      paramObservable = this.n;
      QQLSRecentManager.f = false;
      c();
    }
    else if ((paramObject != null) && ((paramObject instanceof RecentItemPullActivePush)))
    {
      paramObservable = ((RecentItemPullActivePush)paramObject).e();
      this.n.a(this.X, paramObservable.uin, paramObservable.getType(), false, -1, false);
      paramObservable = this.n;
      QQLSRecentManager.f = false;
      c();
    }
    if ((paramObject != null) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (ChatMessage)paramObject;
      if (paramObservable.isSend()) {
        return;
      }
      if (paramObservable.istroop != 6000)
      {
        if (paramObservable.istroop == 1009) {
          return;
        }
        if (paramObservable.istroop == 1036) {
          return;
        }
        if (HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.X)) {
          return;
        }
        paramObject = this.n;
        if (paramObservable.istroop == 1) {
          bool = true;
        }
        QQLSRecentManager.f = bool;
        paramObject = this.n;
        if ((!QQLSRecentManager.f) && (this.j == null)) {
          ThreadManager.getSubThreadHandler().post(new QQLSActivity.11(this));
        }
        if ((UinTypeUtil.c(paramObservable)) && (!MsgProxyUtils.a(this.X, paramObservable)))
        {
          if ((1001 != paramObservable.istroop) && (10002 != paramObservable.istroop))
          {
            if (1010 == paramObservable.istroop)
            {
              this.n.a(this.X, AppConstants.LOCK_SCREEN_DATE_UIN, paramObservable.istroop, false, -1, false);
              c();
            }
          }
          else
          {
            this.n.a(this.X, AppConstants.LOCK_SCREEN_LBS_HELLO_UIN, paramObservable.istroop, false, -1, false);
            c();
          }
          return;
        }
        if (paramObservable.istroop == 1)
        {
          if (((HotChatManager)this.X.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramObservable.frienduin)) {
            return;
          }
          if (((IRoamSettingService)this.X.getRuntimeService(IRoamSettingService.class, "")).getTroopMsgFilter(paramObservable.frienduin, 1) != 1) {
            return;
          }
        }
        if (DiscussionManager.a(this.X, paramObservable.frienduin, paramObservable.istroop)) {
          return;
        }
        if (paramObservable.istroop == 1008) {
          if (paramObservable.extStr != null)
          {
            if (((paramObservable.extLong & 0x1) == 0) && (!paramObservable.extStr.contains("lockDisplay"))) {
              return;
            }
            if ((paramObservable.extStr != null) && (((paramObservable.extLong & 0x1) != 1) || (paramObservable.getExtInfoFromExtStr("lockDisplay").equals("true")))) {}
          }
          else
          {
            return;
          }
        }
        if ((paramObservable.istroop == 7220) && ((paramObservable.extInt == 5) || (paramObservable.extInt == 6))) {
          return;
        }
        if ((paramObservable.istroop == 7220) && (paramObservable.extInt == 2) && (TextUtils.equals(paramObservable.senderuin, AppConstants.NEW_KANDIAN_UIN))) {
          return;
        }
        this.n.a(this.X, paramObservable.frienduin, paramObservable.istroop, false, -1, false);
        c();
      }
      return;
    }
    if ((QLog.isColorLevel()) && (paramObject != null))
    {
      paramObservable = new StringBuilder();
      paramObservable.append("update data is not chatMessage return");
      paramObservable.append(paramObject.getClass());
      QLog.d("QQLSActivity", 2, paramObservable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity
 * JD-Core Version:    0.7.0.1
 */