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
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
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
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendPushUtil;
import com.tencent.mobileqq.activity.contact.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
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
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
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
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.managers.MsgPushReportHelper;
import com.tencent.mobileqq.managers.PullActiveManager;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.mobileqq.ptt.LSRecordPanel.IRecordPanelHandler;
import com.tencent.mobileqq.ptt.LsRecordConfig;
import com.tencent.mobileqq.ptt.TouchProxyRelativeLayout;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
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
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.mobileqq.utils.QQLSSensor.ProximitySensorChangeListener;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import mqq.app.Constants.LogoutReason;
import mqq.app.Foreground;
import mqq.os.MqqHandler;

public class QQLSActivity
  extends AppActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, FileTransferManager.Callback, MediaPlayerManager.Callback, MediaPlayerManager.Listener, DragFrameLayout.OnDragModeChangedListener, LSRecordPanel.IRecordPanelHandler, QQLSSensor.ProximitySensorChangeListener, Observer
{
  private static CopyOnWriteArraySet<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static boolean a;
  private static final boolean jdField_c_of_type_Boolean = AppSetting.jdField_d_of_type_Boolean;
  private final int A = 1500;
  private final int B = 1000;
  private int C = 0;
  float jdField_a_of_type_Float;
  public final int a;
  private long jdField_a_of_type_Long = -1L;
  KeyguardManager jdField_a_of_type_AndroidAppKeyguardManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new QQLSActivity.13(this, Looper.getMainLooper());
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new QQLSActivity.12(this);
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQLSActivity.RecentItemAdapter jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter;
  QQLSActivity.ScreenBroadcastReceiver jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$ScreenBroadcastReceiver;
  private QQLSActivity.SingleItemAdapter jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter;
  private NewFriendManager.INewFriendListener jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager$INewFriendListener = new QQLSActivity.9(this);
  NewFriendManager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager;
  PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private RecentBaseData jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  protected MessageObserver a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQLSRecentManager jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
  private LSRecordPanel jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel;
  private TouchProxyRelativeLayout jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout;
  QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  public SubAccountManager a;
  QQLSSensor jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor;
  private ToastStyleDialog jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog;
  public WeakReferenceHandler a;
  private MaxHeightRelativelayout jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Comparator a;
  protected final MqqHandler a;
  public final int b;
  private long jdField_b_of_type_Long = 0L;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private MessageObserver jdField_b_of_type_ComTencentMobileqqAppMessageObserver = new QQLSActivity.8(this);
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  public Comparator b;
  public boolean b;
  public final int c;
  private long jdField_c_of_type_Long = 0L;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public final int d;
  private long jdField_d_of_type_Long = -1L;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  public final int e;
  private boolean e;
  public final int f;
  private boolean f;
  public final int g;
  private boolean g;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = false;
  private final int jdField_i_of_type_Int = 300;
  private boolean jdField_i_of_type_Boolean = true;
  private final int jdField_j_of_type_Int = 1000;
  private boolean jdField_j_of_type_Boolean = false;
  private final int jdField_k_of_type_Int = 1;
  private boolean jdField_k_of_type_Boolean = true;
  private final int jdField_l_of_type_Int = 2;
  private boolean jdField_l_of_type_Boolean;
  private final int m = 3;
  private final int n = 4;
  private final int o = 5;
  private final int p = 6;
  private final int q = 7;
  private final int r = 8;
  private final int s = 9;
  private final int t = 10;
  private final int u = 11;
  private final int v = 12;
  private final int w = 13;
  private final int x = 14;
  private final int y = 15;
  private final int z = 16;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public QQLSActivity()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    this.jdField_d_of_type_Int = 3;
    this.jdField_e_of_type_Int = 4;
    this.jdField_f_of_type_Int = 5;
    this.jdField_g_of_type_Int = 99;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilComparator = new QQLSActivity.5(this);
    this.jdField_b_of_type_JavaUtilComparator = new QQLSActivity.6(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new QQLSActivity.10(this);
  }
  
  private SessionInfo a(RecentBaseData paramRecentBaseData)
  {
    int i1 = paramRecentBaseData.getRecentUserType();
    String str = paramRecentBaseData.getRecentUserUin();
    SessionInfo localSessionInfo = new SessionInfo();
    Object localObject;
    if (i1 == 1)
    {
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null)
      {
        localObject = ((TroopManager)localObject).b(str + "");
        if ((localObject != null) && (((TroopInfo)localObject).troopcode != null)) {
          localSessionInfo.b = ((TroopInfo)localObject).troopcode;
        }
      }
    }
    for (;;)
    {
      localSessionInfo.jdField_a_of_type_JavaLangString = str;
      localSessionInfo.jdField_a_of_type_Int = i1;
      localSessionInfo.d = paramRecentBaseData.mTitleName;
      return localSessionInfo;
      if (i1 == 1006)
      {
        localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a();
        localSessionInfo.e = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
        localSessionInfo.f = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        if ((localSessionInfo.f == null) && (QLog.isColorLevel())) {
          QLog.d("QQLSActivity", 2, "contactUin == null");
        }
      }
      else if (((i1 == 1004) || (i1 == 1000)) && ((paramRecentBaseData instanceof RecentUserBaseData)))
      {
        localSessionInfo.b = ((RecentUserBaseData)paramRecentBaseData).a();
      }
    }
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    String str = null;
    Object localObject;
    if (paramMessageRecord.istroop == 7000)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.b(paramMessageRecord.frienduin);
      }
      localObject = str;
      if (str == null) {
        localObject = paramMessageRecord.frienduin;
      }
    }
    while ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("")))
    {
      return "";
      if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 10002))
      {
        paramMessageRecord = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin);
        localObject = paramMessageRecord;
        if (paramMessageRecord == null) {
          localObject = "";
        }
      }
      else
      {
        if (UinTypeUtil.a(paramMessageRecord.istroop) == 1032)
        {
          localObject = new ConfessInfo();
          ((ConfessInfo)localObject).parseFromJsonStr(paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
          if (paramMessageRecord.istroop == 1032) {}
          for (paramMessageRecord = paramMessageRecord.senderuin;; paramMessageRecord = paramMessageRecord.frienduin)
          {
            localObject = ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ConfessInfo)localObject, paramMessageRecord);
            break;
          }
        }
        if (AnonymousChatHelper.a(paramMessageRecord)) {
          localObject = getResources().getString(2131697219);
        } else {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this, paramMessageRecord, false);
        }
      }
    }
    return (String)localObject + ":";
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i1 = paramIntent.getIntExtra("uitype", -1);
      int i2 = paramIntent.getIntExtra("notifyId", -1);
      paramIntent = paramIntent.getStringExtra("frienduin");
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "lsReportCore uitype: " + i1 + ", notifyId : " + i2 + ", frienduin : " + paramIntent);
      }
      MsgPushReportHelper.a(i2, paramIntent, i1);
    }
  }
  
  private void a(FriendSystemMessage paramFriendSystemMessage)
  {
    int i1;
    if ((paramFriendSystemMessage.a != null) && (AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(paramFriendSystemMessage.a.frienduin)))
    {
      i1 = NewFriendPushUtil.a(paramFriendSystemMessage.a);
      NewFriendActivity.jdField_a_of_type_Int = i1;
      if (i1 != 6) {
        break label52;
      }
      NewFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800A181");
    }
    label52:
    while ((i1 != 9) && (i1 != 10) && (i1 != 1)) {
      return;
    }
    NewFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009CBA");
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    if (Math.abs(this.jdField_c_of_type_Long - System.currentTimeMillis()) < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "enter too offen,please try again later");
      }
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    QQLSRecentManager.jdField_c_of_type_Long = System.currentTimeMillis();
    l();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "enterAIO");
    }
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "=======enterAIO  NOT LOCK!!!!!!!!!");
      }
      finish();
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(13)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData)) {}
    for (Object localObject1 = ((RecentUserBaseData)paramRecentBaseData).a();; localObject1 = null)
    {
      if (paramRecentBaseData != null) {
        paramRecentBaseData.clearUnReadNum();
      }
      if (paramRecentBaseData != null) {
        MsgPushReportHelper.b(this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(paramRecentBaseData.getRecentUserUin() + paramRecentBaseData.getRecentUserType()), paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DD", "0X80040DD", 0, 0, "", "", "", "");
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_f_of_type_Boolean = true;
      if (e())
      {
        l();
        if (this.jdField_a_of_type_AndroidViewAnimationAnimation != null) {
          this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        }
        if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1012))
        {
          paramRecentBaseData = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
          localObject1 = new Intent(this, NearbyPeopleProfileActivity.class);
          ((Intent)localObject1).putExtra("param_mode", 2);
          ((Intent)localObject1).putExtra("AllInOne", paramRecentBaseData);
          ((Intent)localObject1).putExtra("abp_flag", true);
          ((Intent)localObject1).putExtra("frome_where", -1);
          ((Intent)localObject1).addFlags(67108864);
          startActivity((Intent)localObject1);
        }
        for (;;)
        {
          paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramRecentBaseData, 1500L);
          return;
          if ((localObject1 != null) && ((((RecentUser)localObject1).getType() == 1030) || (((RecentUser)localObject1).getType() == 1030) || (((RecentUser)localObject1).getType() == 1041) || (((RecentUser)localObject1).getType() == 1042)))
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
            localObject1 = (PullActiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
            if ((paramRecentBaseData instanceof RecentItemPullActivePush))
            {
              paramRecentBaseData = ((PullActiveManager)localObject1).a;
              if (paramRecentBaseData != null) {
                startActivity(paramRecentBaseData);
              }
            }
            ((PullActiveManager)localObject1).a();
            QQNotificationManager.getInstance().cancel("QQLSActivity_PullActive", 269);
          }
          else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1001))
          {
            paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
            startActivity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getIntentByMessage(this, paramRecentBaseData, false));
          }
          else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(((RecentUser)localObject1).uin)))
          {
            paramRecentBaseData = (KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER);
            ReadInJoyUtils.a(paramRecentBaseData.a());
            startActivity(ReadInJoyLockScreenJumpDelegate.a(this, 9, paramRecentBaseData.b()));
          }
          else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 7220))
          {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80098D5", "0X80098D5", 0, 0, "0", "", "", "", false);
            paramRecentBaseData = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
            if ((paramRecentBaseData != null) && (ReadInJoyUtils.c(paramRecentBaseData.getMessageRecord())))
            {
              ReadInJoyUtils.d();
              ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 9, 0);
            }
            else
            {
              paramRecentBaseData = new Intent(this, SplashActivity.class);
              paramRecentBaseData.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
              paramRecentBaseData.setFlags(67108864);
              startActivity(paramRecentBaseData);
            }
          }
          else if ((paramRecentBaseData != null) && (UinTypeUtil.a(paramRecentBaseData.getRecentUserType()) == 1044))
          {
            localObject1 = MatchChatMsgUtil.a(this);
            ((Intent)localObject1).putExtra("key_matchchat_from_notification", true);
            ((Intent)localObject1).putExtra("key_matchchat_from_notification_uin", paramRecentBaseData.getRecentUserUin());
            ((Intent)localObject1).putExtra("key_matchchat_from_notification_type", paramRecentBaseData.getRecentUserType());
            startActivity((Intent)localObject1);
          }
          else if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 10007))
          {
            GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramRecentBaseData.getRecentUserUin());
          }
          else
          {
            paramRecentBaseData = new Intent(this, SplashActivity.class);
            paramRecentBaseData.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
            paramRecentBaseData.setFlags(67108864);
            startActivity(paramRecentBaseData);
          }
        }
      }
      int i1;
      if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 7432))
      {
        paramRecentBaseData = new Intent(this, SplashActivity.class);
        paramRecentBaseData.setFlags(67108864);
        paramRecentBaseData.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
        paramRecentBaseData.putExtra("fragment_id", 1);
        startActivity(paramRecentBaseData);
        i1 = 0;
        label1003:
        QQKRPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject1);
        paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
        localObject2 = this.jdField_a_of_type_AndroidOsHandler;
        if ((!GesturePWDUtils.getJumpLock(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (i1 == 0)) {
          break label1553;
        }
      }
      label1548:
      label1553:
      for (long l1 = 500L;; l1 = 0L)
      {
        ((Handler)localObject2).sendMessageDelayed(paramRecentBaseData, l1);
        paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramRecentBaseData, 1500L);
        if ((localObject1 == null) || (((RecentUser)localObject1).getType() != 1008)) {
          break;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ((RecentUser)localObject1).uin, "0X800756F", "0X800756F", 0, 0, "", "", "", "");
        return;
        if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 9653))
        {
          localObject2 = (PullActiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
          if ((paramRecentBaseData instanceof RecentItemPullActivePush))
          {
            paramRecentBaseData = ((PullActiveManager)localObject2).a;
            if (paramRecentBaseData != null)
            {
              paramRecentBaseData.setFlags(67108864);
              startActivity(paramRecentBaseData);
            }
          }
          ((PullActiveManager)localObject2).a();
          QQNotificationManager.getInstance().cancel("QQLSActivity_PullActive", 269);
          i1 = 1;
          break label1003;
        }
        if ((localObject1 != null) && ((((RecentUser)localObject1).getType() == 1030) || (a(((RecentUser)localObject1).getType()))))
        {
          if (!(paramRecentBaseData instanceof RecentItemNoticeData)) {
            break label1548;
          }
          paramRecentBaseData = ((RecentItemNoticeData)paramRecentBaseData).intent;
          if (paramRecentBaseData != null)
          {
            if ((a(((RecentUser)localObject1).getType())) && (!e())) {
              paramRecentBaseData.putExtra("push_notice_unlock", true);
            }
            startActivity(paramRecentBaseData);
          }
          i1 = 0;
          break label1003;
        }
        if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1001))
        {
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
          startActivity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getIntentByMessage(this, paramRecentBaseData, false));
          i1 = 0;
          break label1003;
        }
        if ((paramRecentBaseData != null) && (UinTypeUtil.a(paramRecentBaseData.getRecentUserType()) == 1044))
        {
          localObject2 = MatchChatMsgUtil.a(this);
          ((Intent)localObject2).putExtra("key_matchchat_from_notification", true);
          ((Intent)localObject2).putExtra("key_matchchat_from_notification_uin", paramRecentBaseData.getRecentUserUin());
          ((Intent)localObject2).putExtra("key_matchchat_from_notification_type", paramRecentBaseData.getRecentUserType());
          startActivity((Intent)localObject2);
          i1 = 0;
          break label1003;
        }
        if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 10007))
        {
          GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramRecentBaseData.getRecentUserUin());
          i1 = 0;
          break label1003;
        }
        if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 0))
        {
          b(paramRecentBaseData, (RecentUser)localObject1);
          i1 = 0;
          break label1003;
        }
        if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 1))
        {
          a(paramRecentBaseData, (RecentUser)localObject1);
          i1 = 0;
          break label1003;
        }
        if (paramRecentBaseData != null)
        {
          if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 7220)) {
            ReadInJoyUtils.d();
          }
          RecentUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject1, paramRecentBaseData.mTitleName, true, 1, null);
        }
        i1 = 0;
        break label1003;
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    Bundle localBundle = new Bundle();
    com.tencent.imcore.message.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramRecentUser.uin, paramRecentUser.getType());
    if ((localMessage != null) && (localMessage.msgtype == -5008)) {
      localBundle.putBoolean("key_from_listen_together_notify_msg", ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage));
    }
    RecentUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, paramRecentBaseData.mTitleName, true, 1, null, localBundle, null);
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131167305));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      Object localObject = getResources().getDisplayMetrics();
      int i3 = (int)(16.0F * ((DisplayMetrics)localObject).density);
      int i1 = (int)(32.0F * ((DisplayMetrics)localObject).density);
      int i2 = (int)(((DisplayMetrics)localObject).density * 240.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, i3);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1711276033);
      localObject = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.getGlobalVisibleRect((Rect)localObject);
      Rect localRect = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.getGlobalVisibleRect(localRect);
      i3 = (localRect.top - ((Rect)localObject).top - i1) / 2;
      int i4 = (localRect.right - ((Rect)localObject).left - i2) / 2;
      localObject = new RelativeLayout.LayoutParams(i2, i1);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i4;
      ((RelativeLayout.LayoutParams)localObject).topMargin = i3;
      this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramInt > 0) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(14, paramInt);
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 1035) || (paramInt == 1041) || (paramInt == 1042);
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
    boolean bool = true;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt);
    if ((paramString == null) || (paramMessageRecord == null)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (!UinTypeUtil.b(paramInt)) {
          break;
        }
      } while (paramMessageRecord.time > paramString.lastread);
      return false;
    } while (paramMessageRecord.shmsgseq > paramString.lastread);
    return false;
  }
  
  private List<MessageRecord> b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    Object localObject1;
    if ((paramString.equals(AppConstants.LOCK_SCREEN_DATE_UIN)) || (paramString.equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN)))
    {
      localObject1 = new MessageRecord();
      ((MessageRecord)localObject1).frienduin = paramString;
      ((MessageRecord)localObject1).senderuin = paramString;
      ((MessageRecord)localObject1).istroop = paramInt;
      paramString = new ArrayList();
      paramString.add(localObject1);
      return paramString;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString, paramInt);
    Object localObject3 = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "single item msg list size: " + ((List)localObject2).size());
    }
    long l1;
    if (UinTypeUtil.b(paramInt))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramString);
      if (localObject1 != null)
      {
        l1 = ((Long)((Pair)localObject1).first).longValue();
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
    }
    MessageRecord localMessageRecord;
    for (;;)
    {
      if ((paramInt == 1001) || (paramInt == 1010) || (paramInt == 10002))
      {
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "getSingleUnreadMsg UIN_TYPE_LBS_FRIEND is null");
          }
          finish();
          return new ArrayList();
          l1 = 0L;
          break;
          if ((paramInt == 3000) || (paramInt == 1))
          {
            localObject1 = MsgProxyUtils.a((List)localObject2, false);
            continue;
          }
          if (paramInt == 7000)
          {
            localObject2 = new MessageRecord();
            localObject1 = localObject3;
            if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager == null) {
              continue;
            }
            localObject1 = localObject3;
            if (this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.a(paramString) == null) {
              continue;
            }
            ((MessageRecord)localObject2).msg = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.a(paramString).toString();
            ((MessageRecord)localObject2).istroop = paramInt;
            ((MessageRecord)localObject2).frienduin = paramString;
            ((List)localObject3).add(localObject2);
            localObject1 = localObject3;
            continue;
          }
          if (paramInt == 4000)
          {
            localMessageRecord = new MessageRecord();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager != null) {}
            for (localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.a();; localObject2 = null)
            {
              localObject1 = localObject3;
              if (localObject2 == null) {
                break;
              }
              localMessageRecord.msg = ((NewFriendMessage)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              localMessageRecord.istroop = paramInt;
              localMessageRecord.frienduin = paramString;
              if ((localObject2 instanceof FriendSystemMessage)) {
                a((FriendSystemMessage)localObject2);
              }
              ((List)localObject3).add(localMessageRecord);
              localObject1 = localObject3;
              break;
            }
          }
          if (paramInt == 9002)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
            localObject2 = new MessageRecord();
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, (MessageRecord)localObject1);
            ((List)localObject3).add(localObject2);
            localObject1 = localObject3;
            continue;
          }
          if (paramInt == 8)
          {
            localObject1 = MessageRecordFactory.a(-2026);
            ((MessageRecord)localObject1).istroop = paramInt;
            ((MessageRecord)localObject1).frienduin = paramString;
            ((MessageRecord)localObject1).msg = "";
            ((MessageRecord)localObject1).isread = true;
            ((List)localObject3).add(localObject1);
            localObject1 = localObject3;
            continue;
          }
          localObject1 = localObject3;
          if (paramInt != 9501) {
            continue;
          }
          localObject1 = localObject3;
          if (localObject2 == null) {
            continue;
          }
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
        return new ArrayList(((List)localObject1).subList(((List)localObject1).size() - 1, ((List)localObject1).size()));
      }
    }
    if (paramInt == 1032)
    {
      if ((localObject1 == null) || (((List)localObject1).size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "getSingleUnreadMsg UIN_TYPE_LBS_FRIEND is null");
        }
        finish();
        return new ArrayList();
      }
      localObject2 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
      localObject2 = ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
      ((List)localObject1).clear();
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
    }
    if (paramString.equals(AppConstants.VOTE_UIN))
    {
      paramString = (DatingProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
      if (paramString != null) {
        ((List)localObject1).add(paramString.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData));
      }
      return localObject1;
    }
    if ((paramInt == 1030) && (AppConstants.CAMPUS_NOTICE_UIN.equals(paramString)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER))
      {
        paramString = ((CampusNoticeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a();
        if (paramString != null) {
          ((List)localObject1).add(paramString);
        }
      }
      return localObject1;
    }
    if (a(paramInt))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER))
      {
        paramString = ((PushNoticeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a();
        if (paramString != null) {
          ((List)localObject1).add(paramString);
        }
      }
      return localObject1;
    }
    if (paramString.equals(AppConstants.PULL_ACTIVE_PUSH_UIN))
    {
      paramString = (PullActiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
      if (paramString != null) {
        ((List)localObject1).add(paramString.a());
      }
      return localObject1;
    }
    if (((paramString.equals(AppConstants.KANDIAN_MERGE_UIN)) && (paramInt == 7220)) || ((paramString.equals(AppConstants.NEW_KANDIAN_UIN)) && (paramInt == 1008)))
    {
      paramString = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).c();
      ((List)localObject1).clear();
      ((List)localObject1).add(paramString);
      return localObject1;
    }
    if (AppConstants.KANDIAN_DAILY_UIN.equals(paramString))
    {
      paramString = ((KandianDailyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a();
      ((List)localObject1).clear();
      if (paramString != null) {
        ((List)localObject1).add(paramString);
      }
      return localObject1;
    }
    if ((QLog.isColorLevel()) && (localObject1 != null)) {
      QLog.d("QQLSActivity", 2, "single item continued msg list size: " + ((List)localObject1).size());
    }
    PretreatmentAIOMsg.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    MsgProxyUtils.a(paramString, paramInt, (List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache());
    localObject2 = new ArrayList();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "single item continued msg list size= 0" + Thread.currentThread().getId());
      }
      u();
      return new ArrayList();
    }
    localObject3 = ((List)localObject1).iterator();
    int i1 = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
      if ((i1 == 0) || (localMessageRecord.isSend()) || (!UniteGrayTipUtil.a(localMessageRecord))) {
        if ((!a(localMessageRecord, paramString, paramInt)) || (localMessageRecord.isSend())) {
          ((List)localObject2).add(localMessageRecord);
        } else {
          i1 = 1;
        }
      }
    }
    ((List)localObject1).removeAll((Collection)localObject2);
    QLog.d("QQLSActivity", 1, new Object[] { "[getSingleUnreadMsg][LSUnread] remove[", Integer.valueOf(((List)localObject2).size()), "] read msg. retain [", Integer.valueOf(((List)localObject1).size()), "] unreads" });
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mergeSortList miscalllist size: " + this.jdField_a_of_type_JavaUtilArrayList.size() + ", uinType" + paramInt);
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
  
  private void b(RecentBaseData paramRecentBaseData, RecentUser paramRecentUser)
  {
    Bundle localBundle = new Bundle();
    com.tencent.imcore.message.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramRecentUser.uin, paramRecentUser.getType());
    if ((localMessage != null) && (localMessage.msgtype == -5008)) {
      localBundle.putBoolean("key_from_listen_together_notify_msg", ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessage));
    }
    RecentUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, paramRecentBaseData.mTitleName, true, 1, null, localBundle, null);
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(14);
    QQLSActivity.19 local19 = new QQLSActivity.19(this);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(local19);
      return;
    }
    local19.run();
  }
  
  private boolean c()
  {
    long l1 = System.currentTimeMillis();
    QQLSRecentManager localQQLSRecentManager;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("judge need to wake up, now =").append(l1).append(", firstMsgTime =");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localObject = ((StringBuilder)localObject).append(QQLSRecentManager.jdField_a_of_type_Long).append(", lastWakeUpTime = ");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localObject = ((StringBuilder)localObject).append(QQLSRecentManager.jdField_b_of_type_Long).append(", wakeUpTimeAfter30Minute =");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QLog.d("QQLSActivity", 2, QQLSRecentManager.jdField_a_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_c_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "troop message don't need bright");
      }
    }
    do
    {
      return false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      if (QQLSRecentManager.jdField_a_of_type_Long == 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      if (l1 < QQLSRecentManager.jdField_a_of_type_Long + 1800000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "less than 30min ,need bright");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_b_of_type_Long = l1;
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_a_of_type_Boolean = false;
        return true;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      long l2 = Math.min(6, QQLSRecentManager.jdField_a_of_type_Int + 1) * 10 * 60 * 1000;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("has wakeup");
        localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QLog.d("QQLSActivity", 2, QQLSRecentManager.jdField_a_of_type_Int + "times");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      if (l1 > l2 + QQLSRecentManager.jdField_b_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "over wakeuptime ,need bright");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_a_of_type_Boolean = true;
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQLSActivity", 2, "not bright screen");
    return false;
  }
  
  private void d(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramInt > 0) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(15, paramInt);
    }
  }
  
  @TargetApi(16)
  private boolean d()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppKeyguardManager == null) {
          this.jdField_a_of_type_AndroidAppKeyguardManager = ((KeyguardManager)getSystemService("keyguard"));
        }
        bool = this.jdField_a_of_type_AndroidAppKeyguardManager.isKeyguardLocked();
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, "isKeyguardLock=" + bool);
        }
        return bool;
      }
      catch (SecurityException localSecurityException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + localSecurityException);
        }
        return true;
      }
      boolean bool = QQUtils.a(this);
    }
  }
  
  @TargetApi(16)
  private boolean e()
  {
    if ((Build.VERSION.SDK_INT == 20) && (Build.VERSION.RELEASE.equals("L"))) {
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "isKeyguardLock SDK is androidL !");
      }
    }
    for (;;)
    {
      return true;
      boolean bool;
      if (Build.VERSION.SDK_INT >= 20)
      {
        bool = "1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.lock_screen_enterAIO.name(), "1"));
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "=======5.0enterAIO=======" + bool);
        }
        if (!bool) {}
      }
      else if (Build.VERSION.SDK_INT >= 16)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidAppKeyguardManager == null) {
            this.jdField_a_of_type_AndroidAppKeyguardManager = ((KeyguardManager)getSystemService("keyguard"));
          }
          if (QLog.isColorLevel()) {
            QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + this.jdField_a_of_type_AndroidAppKeyguardManager.isKeyguardLocked() + ". kgm.isKeyguardSecure()=" + this.jdField_a_of_type_AndroidAppKeyguardManager.isKeyguardSecure());
          }
          if ((this.jdField_a_of_type_AndroidAppKeyguardManager != null) && (this.jdField_a_of_type_AndroidAppKeyguardManager.isKeyguardLocked()))
          {
            bool = this.jdField_a_of_type_AndroidAppKeyguardManager.isKeyguardSecure();
            if (!bool) {}
          }
          for (bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (SecurityException localSecurityException) {}
      }
    }
    QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + localSecurityException);
    return true;
  }
  
  private void k()
  {
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_a_of_type_Long == 0L)
    {
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_a_of_type_Long = System.currentTimeMillis();
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_b_of_type_Long = QQLSRecentManager.jdField_a_of_type_Long;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_a_of_type_Int = 0;
    }
    long l1;
    do
    {
      return;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      l1 = QQLSRecentManager.jdField_b_of_type_Long;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    } while (l1 >= QQLSRecentManager.jdField_a_of_type_Long);
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Long = QQLSRecentManager.jdField_a_of_type_Long;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Int = 0;
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "clearRemindTime");
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Long = 0L;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Long = 0L;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Int = 0;
  }
  
  @TargetApi(9)
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout = ((TouchProxyRelativeLayout)findViewById(2131374891));
    if (this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout == null)
    {
      QLog.e("QQLSActivity", 1, "UI is null finish");
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378218));
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)findViewById(2131376672));
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight((int)(getResources().getDisplayMetrics().density * 356.0F + 0.5D));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131376669));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(getResources().getDrawable(2130845688));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131378219));
    this.jdField_b_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_b_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    this.jdField_b_of_type_ComTencentWidgetXListView.setTranscriptMode(2);
    this.jdField_b_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)findViewById(2131369172));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364113));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel = ((LSRecordPanel)findViewById(2131372725));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363963));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376684));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378222));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131690946));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368175));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new QQLSActivity.3(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter = new QQLSActivity.RecentItemAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new QQLSActivity.4(this));
    DeviceLib.a(this, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter = new QQLSActivity.SingleItemAdapter(this);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "initUI updateUI");
    }
    b();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "updateUI thread" + Thread.currentThread().getId());
    }
    if (!this.jdField_k_of_type_Boolean) {
      return;
    }
    Object localObject1 = (InputMethodManager)getSystemService("input_method");
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {}
    try
    {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a());
      if (localArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "recentBaseData size = 0,  finish" + Thread.currentThread().getId());
        }
        finish();
        if ((getIntent().getFlags() & 0x100000) != 0)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(this, SplashActivity.class);
          ((Intent)localObject2).setFlags(67108864);
          ((Intent)localObject2).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
          ((Intent)localObject2).putExtra("fragment_id", 1);
          startActivity((Intent)localObject2);
        }
      }
      if (localArrayList.size() == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.a = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel;
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8)
        {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentWidgetXListView);
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_b_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter, this, this, true, false);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData = ((RecentBaseData)localArrayList.get(0));
        o();
        this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((android.os.Message)localObject1, 350L);
        this.jdField_g_of_type_Boolean = false;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DA", "0X80040DA", 0, 0, "" + localArrayList.size(), "", "", "");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("QQLSActivity", 1, "updateUI error: " + localThrowable.getMessage());
      }
      this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.a = null;
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
      {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_b_of_type_ComTencentWidgetXListView);
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter, this, this, false, false);
      }
      localObject1 = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      if (localObject1 == null) {
        break label637;
      }
    }
    Object localObject2 = localThrowable.iterator();
    Object localObject3;
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject3 = (RecentBaseData)((Iterator)localObject2).next();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((RecentBaseData)localObject3).getRecentUserUin(), ((RecentBaseData)localObject3).getRecentUserType());
    } while ((((MessageRecord)localObject3).uniseq != ((ChatMessage)localObject1).uniseq) || (((MessageRecord)localObject3).istroop != ((ChatMessage)localObject1).istroop));
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 != 0) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
      label637:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter.a(localThrowable);
      break;
    }
  }
  
  private void o()
  {
    Object localObject2;
    TextView localTextView;
    DragTextView localDragTextView;
    RecentBaseData localRecentBaseData;
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null))
    {
      localObject1 = (RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374732);
      localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374730);
      localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374735);
      localDragTextView = (DragTextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374736);
      localDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      localDragTextView.setDragViewType(0);
      localDragTextView.setTag(Integer.valueOf(1000));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
      ((RelativeLayout)localObject1).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      ((RelativeLayout)localObject1).requestLayout();
      localRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
      if ((localRecentBaseData != null) && (localRecentBaseData.getRecentUserType() == 8) && (localRecentBaseData.mExtraType == 25))
      {
        localObject1 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
        if (localObject1 == null) {
          break label1585;
        }
      }
    }
    label539:
    label670:
    label1575:
    label1578:
    label1585:
    for (Object localObject1 = ((PhoneContactManager)localObject1).c(localRecentBaseData.mPhoneNumber);; localObject1 = null)
    {
      int i1;
      String str;
      if (localObject1 != null)
      {
        localRecentBaseData.mTitleName = ((PhoneContact)localObject1).name;
        if (localRecentBaseData.mTitleName.equals(localRecentBaseData.getRecentUserUin())) {
          localRecentBaseData.mTitleName = localRecentBaseData.mPhoneNumber;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, "updateSingleUI mTitleName = " + localRecentBaseData.mTitleName);
        }
        ((TextView)localObject2).setText(localRecentBaseData.mTitleName);
        localTextView.setText(localRecentBaseData.mShowTime);
        if ((localRecentBaseData.getRecentUserType() != 7000) && (localRecentBaseData.getRecentUserType() != 4000) && (localRecentBaseData.getRecentUserType() != 1001) && (localRecentBaseData.getRecentUserType() != 10002) && (localRecentBaseData.getRecentUserType() != 1010) && (localRecentBaseData.getRecentUserType() != 1012) && (localRecentBaseData.getRecentUserType() != 1030) && (localRecentBaseData.getRecentUserType() != 9002) && (localRecentBaseData.getRecentUserType() != 9501) && (localRecentBaseData.getRecentUserType() != 7432) && (localRecentBaseData.getRecentUserType() != 9653) && (localRecentBaseData.getRecentUserType() != 7220) && ((localRecentBaseData.getRecentUserType() != 1008) || (!AppConstants.KANDIAN_DAILY_UIN.equals(localRecentBaseData.getRecentUserUin()))) && ((localRecentBaseData.getRecentUserType() != 1008) || (!AppConstants.NEW_KANDIAN_UIN.equals(localRecentBaseData.getRecentUserUin()))) && (localRecentBaseData.getRecentUserType() != 1032) && (localRecentBaseData.getRecentUserType() != 1035) && (localRecentBaseData.getRecentUserType() != 1041) && (localRecentBaseData.getRecentUserType() != 1042) && (localRecentBaseData.getRecentUserType() != 10007)) {
          break label883;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369148).setVisibility(8);
        i1 = 0;
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "updateSingleUI type=" + localRecentBaseData.getRecentUserType());
        }
        localObject1 = (RelativeLayout.LayoutParams)localDragTextView.getLayoutParams();
        if ((localRecentBaseData.getRecentUserType() != 1012) && (localRecentBaseData.getRecentUserType() != 1030) && (localRecentBaseData.getRecentUserType() != 7432) && (localRecentBaseData.getRecentUserType() != 9653) && (localRecentBaseData.getRecentUserType() != 1035)) {
          break label902;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374732).setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(18.0F * this.jdField_a_of_type_Float));
        str = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin();
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData instanceof RecentUserBaseData)) {
          break label1578;
        }
      }
      for (localObject1 = ((RecentUserBaseData)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData).a();; localObject1 = str)
      {
        int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserType();
        if ((i3 == 1030) && ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData instanceof RecentItemNoticeData)))
        {
          localObject2 = new PushReportController.PushReportItem();
          ((PushReportController.PushReportItem)localObject2).e = "0X800923E";
          ((PushReportController.PushReportItem)localObject2).d = "Android锁屏弹窗";
          PushReportController.a(((RecentItemNoticeData)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData).url, (PushReportController.PushReportItem)localObject2);
          PushReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PushReportController.PushReportItem)localObject2);
        }
        List localList;
        for (;;)
        {
          localList = b(str, i3);
          if ((localList != null) && (localList.size() != 0)) {
            break label996;
          }
          if (QLog.isColorLevel()) {
            QLog.e("QQLSActivity", 2, "LSActivity mSingleAdapter size =0 finish" + Thread.currentThread().getId());
          }
          finish();
          return;
          localObject1 = ((QCallCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(localRecentBaseData.getRecentUserUin());
          if (localObject1 == null) {
            break;
          }
          localRecentBaseData.mTitleName = ((QCallCardInfo)localObject1).nickname;
          break;
          label883:
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369148).setVisibility(0);
          i1 = 1;
          break label539;
          ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374732).setVisibility(0);
          break label670;
          if ((a(i3)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData instanceof RecentItemNoticeData)))
          {
            localObject2 = ((RecentItemNoticeData)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData).intent;
            PushNoticeManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Intent)localObject2).getStringExtra("push_notice_service_id"), ((Intent)localObject2).getStringExtra("push_notice_content_id"), ((RecentItemNoticeData)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData).url, "0X800923E", "Android锁屏弹窗");
          }
        }
        label996:
        localObject2 = localRecentBaseData.mShowTime;
        long l1 = localRecentBaseData.mDisplayTime;
        int i2 = 0;
        while (i2 < localList.size())
        {
          long l2 = l1;
          Object localObject3 = localObject2;
          if (((MessageRecord)localList.get(i2)).msgtype == -2009)
          {
            l2 = l1;
            localObject3 = localObject2;
            if (((MessageRecord)localList.get(i2)).time > l1)
            {
              l2 = ((MessageRecord)localList.get(i2)).time;
              localObject3 = TimeManager.a().a(((MessageRecord)localList.get(i2)).frienduin, ((MessageRecord)localList.get(i2)).time);
            }
          }
          i2 += 1;
          l1 = l2;
          localObject2 = localObject3;
        }
        localRecentBaseData.mDisplayTime = l1;
        localTextView.setText((CharSequence)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter.a(localList);
        this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.a(str, i3, (String)localObject1);
        this.jdField_b_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter.getCount() - 1);
        i2 = GesturePWDUtils.getGesturePWDState(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "set mGesturePasswordState=" + i2);
        }
        if (i2 == 2)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369148).setVisibility(8);
          i1 = 0;
        }
        if (i1 != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.a = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel;
          if (LsRecordConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            d(-1);
            this.jdField_f_of_type_Boolean = true;
            LsRecordConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
        while (localRecentBaseData.getRecentUserType() == 4000)
        {
          CustomWidgetUtil.a(localDragTextView, 3, localRecentBaseData.mUnreadNum, 0);
          return;
          if (this.jdField_f_of_type_Boolean)
          {
            t();
            continue;
            this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.a = null;
          }
        }
        if ((localRecentBaseData.getRecentUserType() == 1001) || (localRecentBaseData.getRecentUserType() == 1010) || (localRecentBaseData.getRecentUserType() == 10002))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          CustomWidgetUtil.a(localDragTextView, 3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(((MessageRecord)localObject1).senderuin, localRecentBaseData.getRecentUserType()), 0);
          return;
        }
        if (localRecentBaseData.getRecentUserType() == 7000)
        {
          CustomWidgetUtil.a(localDragTextView, 3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType()), 0);
          return;
        }
        if (localRecentBaseData.getRecentUserType() == 1032)
        {
          CustomWidgetUtil.a(localDragTextView, 3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType()), 0);
          return;
        }
        i1 = localList.size();
        localObject1 = localList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          if (!UniteGrayTipUtil.a((MessageRecord)((Iterator)localObject1).next())) {
            break label1575;
          }
          i1 -= 1;
        }
        for (;;)
        {
          break;
          CustomWidgetUtil.a(localDragTextView, 3, i1, 0);
          return;
        }
      }
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "go to wakeUpScreen==========================");
    }
    if (c())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "wakeUpScreen proximitySensor=null");
        }
        r();
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor == null) || (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("wakeUpScreen hasSensor=");
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor == null) {
          break label159;
        }
      }
      label159:
      for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.jdField_a_of_type_Boolean;; bool = false)
      {
        QLog.d("QQLSActivity", 2, bool);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800477A", "0X800477A", 0, 0, "", "", "", "");
        r();
        return;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "some phone need to bright early");
      }
      r();
      return;
    }
    if (this.jdField_i_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose  firstTimeToWakeScreen acquireWakeLock");
      }
      q();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      q();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose acquireWakeLock");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "wakeUpScreen acquireBrightWakeLock");
    }
    r();
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "new wakeLock");
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "new brightWakeLock  screen bright!!!");
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_a_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_b_of_type_Long = l1;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_a_of_type_Int += 1;
    }
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.14(this));
  }
  
  private void s()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_d_of_type_Boolean) {}
    do
    {
      return;
      if ((DeviceInfoUtil.g()) && (Build.VERSION.SDK_INT == 15))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_d_of_type_Boolean = true;
        return;
      }
      localObject = AppSetting.c;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setPhoneNeedBright devicesInfo=== " + (String)localObject);
      }
      if ((((String)localObject).equalsIgnoreCase("oppo-x907")) || (((String)localObject).equalsIgnoreCase("samsung-sch-i779")) || (((String)localObject).equalsIgnoreCase("xiaomi-hm 1sc")) || (((String)localObject).endsWith("lenovo-lenovo a390t")) || (((String)localObject).endsWith("xiaomi-2013022")) || (((String)localObject).endsWith("bbk-vivo x3t")) || (((String)localObject).endsWith("bbk-vivo y3t")) || (((String)localObject).endsWith("oppo-r813t")) || (((String)localObject).endsWith("huawei-huawei t8833")) || (((String)localObject).equalsIgnoreCase("unknown-K-Touch W619")) || (((String)localObject).equalsIgnoreCase("COOLPAD-Coolpad 8079")) || (((String)localObject).endsWith("K-Touch-K-Touch T780")) || (((String)localObject).endsWith("HTC-HTC T328w")) || (((String)localObject).endsWith("HUAWEI-HUAWEI U9508")))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_d_of_type_Boolean = true;
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    } while (QQLSRecentManager.a());
    localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_d_of_type_Boolean = false;
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(15);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "SmoothFinish");
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(450L);
    localAlphaAnimation.setAnimationListener(new QQLSActivity.20(this));
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(99, 500L);
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.startAnimation(localAlphaAnimation);
  }
  
  private void v()
  {
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.21(this));
  }
  
  private void w()
  {
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.22(this));
  }
  
  public int a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.c(paramString, paramInt);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return localArrayList;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.frienduin.equals(paramString)) && (localMessageRecord.istroop == paramInt)) {
        localArrayList.add(localMessageRecord);
      }
    }
    Collections.sort(localArrayList, this.jdField_b_of_type_JavaUtilComparator);
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.2(this));
  }
  
  public void a(int paramInt)
  {
    setVolumeControlStream(3);
  }
  
  protected void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    paramView = (QQLSActivity.SinglePttHolder)AIOUtils.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.create(this);
      paramView.setMainTitle(2131690019);
      paramView.addButton(2131690018);
      paramView.addCancelButton(2131690800);
      paramView.setOnButtonClickListener(new QQLSActivity.7(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131694521, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131718861, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
      return;
    }
    a(paramView, localMessageForPtt, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("PTTItem->onErrorIconClick", 2, "fileStatus:2001|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
    }
    a(paramView, localMessageForPtt, 2001, false);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.fileType != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      paramView = (QQLSActivity.SinglePttHolder)paramView.getTag();
      localMessageForPtt = (MessageForPtt)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramFileMsg.uniseq));
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramFileMsg.isStreamMode)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2003)
        {
          f();
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + paramInt2 + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, paramInt2, a(localMessageForPtt));
      return;
      if ((paramFileMsg.status == 1005) || (paramFileMsg.status == 1004))
      {
        f();
        paramInt2 = paramInt1;
      }
      else if (localMessageForPtt.fileSize == -2L)
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
  }
  
  protected void a(QQLSActivity.SinglePttHolder paramSinglePttHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag);
    }
    paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    Object localObject = getResources();
    switch (paramInt)
    {
    default: 
      str = "";
      paramInt = 0;
    case 2004: 
    case 2005: 
    case -1: 
    case 999: 
    case 1000: 
    case 2000: 
    case 2001: 
    case 2002: 
      for (;;)
      {
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
            paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          }
          label294:
          if (jdField_c_of_type_Boolean)
          {
            paramMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getTitleName() + HardCodeUtil.a(2131710395);
            paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setContentDescription(paramMessageForPtt + str + HardCodeUtil.a(2131710403));
            if (paramSinglePttHolder.jdField_a_of_type_JavaLangStringBuilder != null)
            {
              paramSinglePttHolder.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append(str);
              if (0 != 0) {
                paramSinglePttHolder.jdField_a_of_type_JavaLangStringBuilder.append(" ").append(null);
              }
            }
          }
          return;
          paramSinglePttHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
          paramSinglePttHolder.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject), BaseChatItemLayout.m, AIOUtils.a(10.0F, (Resources)localObject), BaseChatItemLayout.n);
          paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
          paramSinglePttHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845684);
          str = "";
          paramInt = 1;
          continue;
          paramSinglePttHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramSinglePttHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
          paramSinglePttHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
          paramSinglePttHolder.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(40.0F, (Resources)localObject), BaseChatItemLayout.m, AIOUtils.a(40.0F, (Resources)localObject), BaseChatItemLayout.n);
          paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
          str = "";
          paramInt = 0;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
    }
    if (paramMessageForPtt.voiceLength <= 1) {
      paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
    }
    if (paramMessageForPtt.voiceLength <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "get a amr file length = 0 return now");
      }
      paramSinglePttHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramSinglePttHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramSinglePttHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
      paramSinglePttHolder.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, (Resources)localObject), BaseChatItemLayout.m, AIOUtils.a(10.0F, (Resources)localObject), BaseChatItemLayout.n);
      return;
    }
    if ((paramMessageForPtt.voiceLength <= PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) || (paramMessageForPtt.voiceLength > PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt"))) {
      paramMessageForPtt.sttAbility = 0;
    }
    if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
      paramMessageForPtt.timeStr = PttItemBuilder.a(paramMessageForPtt.voiceLength);
    }
    String str = paramMessageForPtt.timeStr;
    paramSinglePttHolder.jdField_c_of_type_AndroidWidgetTextView.setText(str);
    paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setOnClickListener(this);
    if (paramBoolean)
    {
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)((Resources)localObject).getDrawable(2130772141);
      paramSinglePttHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
      paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setBackgroundResource(2130841765);
      paramSinglePttHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165357));
      if (paramInt == 2003) {
        break label1131;
      }
      if (paramInt != 1003) {
        break label989;
      }
      paramInt = 0;
    }
    for (;;)
    {
      label864:
      int i2 = AIOUtils.a(9.0F, (Resources)localObject);
      if (paramMessageForPtt.voiceLength < 15) {}
      for (int i1 = paramMessageForPtt.voiceLength;; i1 = 15)
      {
        i1 = PttItemBuilder.a(this, i1, null, null, 0);
        paramSinglePttHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i2, 0, 0, 0);
        paramSinglePttHolder.jdField_c_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.r, 0, i1, 0);
        break;
        paramSinglePttHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167374));
        if (paramMessageForPtt.isReadPtt) {
          paramSinglePttHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841763);
        }
        for (;;)
        {
          paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setBackgroundResource(2130841764);
          break;
          paramSinglePttHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845687);
        }
        label989:
        if ((paramInt == 1005) || (paramInt == 1004))
        {
          paramInt = 1;
          break label864;
        }
        paramInt = 4;
        break label864;
      }
      paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      if (!jdField_c_of_type_Boolean) {
        break label294;
      }
      localObject = paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramMessageForPtt = HardCodeUtil.a(2131710398);; paramMessageForPtt = HardCodeUtil.a(2131710401))
      {
        ((ImageView)localObject).setContentDescription(paramMessageForPtt);
        break;
      }
      paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839549, this);
      paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
      ((Animatable)paramSinglePttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
      break label294;
      label1131:
      paramInt = 0;
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (int i1 = 2;; i1 = 7)
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt.frienduin, paramMessageForPtt, false, i1, 0, paramBoolean2);
      return;
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = AIOUtils.a(paramView);
      if ((paramXListView instanceof QQLSActivity.SinglePttHolder))
      {
        paramXListView = (QQLSActivity.SinglePttHolder)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView), false);
      }
    }
  }
  
  public void a(List<MessageRecord> paramList1, List<MessageRecord> paramList2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mergeSortList miscalllist size: " + paramList2.size());
    }
    paramList1.addAll(paramList2);
    Collections.sort(paramList1, this.jdField_b_of_type_JavaUtilComparator);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "sensor has callback sensorIsClose===" + this.jdField_h_of_type_Boolean);
    }
    if (this.jdField_h_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = false;
    }
    do
    {
      this.jdField_j_of_type_Boolean = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "callback firstTimeToWakeScreen=" + this.jdField_i_of_type_Boolean);
      }
    } while (!this.jdField_i_of_type_Boolean);
    if (c()) {
      r();
    }
    for (;;)
    {
      this.jdField_i_of_type_Boolean = false;
      break;
      q();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("QQLSActivity", 2, "onChange isDone " + paramBoolean);
      QLog.d("QQLSActivity", 2, "onChange mDragHost.getMode() " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a());
    }
    Object localObject;
    label642:
    int i1;
    if (paramBoolean)
    {
      paramDragFrameLayout = paramDragFrameLayout.a();
      if ((paramDragFrameLayout == null) || (paramDragFrameLayout.getTag() == null)) {
        break label1589;
      }
      paramInt = ((Integer)paramDragFrameLayout.getTag()).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "delete onChange position=" + paramInt);
      }
      if (paramInt == 1000)
      {
        paramInt = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter.a.get(0)).istroop;
        paramDragFrameLayout = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter.a.get(0)).frienduin;
        if ((paramInt == 1001) || (paramInt == 1010) || (paramInt == 10002))
        {
          ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a(paramDragFrameLayout, paramInt, false);
          RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout, paramInt);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(paramDragFrameLayout, paramInt);
          this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a(paramDragFrameLayout, paramInt);
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a();
          if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "QQLSActivity onChange removeNotification");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeNotification();
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "single data remove finish");
          }
          u();
          if (paramInt != 3000) {
            break label642;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
        }
      }
      while (QQLSActivity.RecentItemAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter).size() <= paramInt)
      {
        do
        {
          for (;;)
          {
            return;
            if (paramInt == 4000)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.f();
            }
            else if (paramInt == 7000)
            {
              ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a().a(paramDragFrameLayout, null);
              localObject = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
              if (localObject != null) {
                ((SubAccountManager)localObject).b(paramDragFrameLayout);
              }
            }
            else if (paramInt == 1012)
            {
              localObject = (DatingProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
              if (localObject != null) {
                ((DatingProxyManager)localObject).a().a();
              }
            }
            else if (paramInt == 1030)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER))
              {
                ((CampusNoticeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(null);
                if (QLog.isColorLevel()) {
                  QLog.d("notification", 2, "remove campus notice from LSA");
                }
              }
            }
            else if (paramInt == 9653)
            {
              ((PullActiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER)).a();
            }
            else if (UinTypeUtil.a(paramInt) == 1032)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().b();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(AppConstants.CONFESS_UIN, 1032);
            }
            else if ((a(paramInt)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER)))
            {
              ((PushNoticeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a(null, paramInt);
              if (QLog.isColorLevel()) {
                QLog.d("notification", 2, "remove push notice from LSA");
              }
            }
          }
          if (paramInt == 1)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
            return;
          }
          if (paramInt == 0)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
            return;
          }
        } while ((paramInt != 1001) && (paramInt != 1010) && (paramInt != 10002));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
        return;
      }
      i1 = ((RecentBaseData)QQLSActivity.RecentItemAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter).get(paramInt)).getRecentUserType();
      paramDragFrameLayout = ((RecentBaseData)QQLSActivity.RecentItemAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter).get(paramInt)).getRecentUserUin();
      RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout, i1);
      if ((i1 != 1001) && (i1 != 1010) && (i1 != 10002)) {
        break label1059;
      }
      ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a(paramDragFrameLayout, i1, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.a(i1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.a(paramDragFrameLayout, i1);
      QQLSActivity.RecentItemAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter).remove(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter.notifyDataSetChanged();
      if (i1 != 3000) {
        break label1437;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
      label982:
      this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(paramDragFrameLayout, i1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "onChange updateUI" + Thread.currentThread().getId());
        }
        this.jdField_k_of_type_Boolean = true;
        runOnUiThread(new QQLSActivity.18(this));
        return;
        label1059:
        if (i1 == 4000)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.f();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.a(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
          break;
        }
        if (i1 == 7000)
        {
          ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a().a(paramDragFrameLayout, null);
          localObject = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
          if (localObject == null) {
            break;
          }
          ((SubAccountManager)localObject).b(paramDragFrameLayout);
          break;
        }
        if (i1 == 1012)
        {
          localObject = (DatingProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
          if (localObject == null) {
            break;
          }
          ((DatingProxyManager)localObject).a().a();
          break;
        }
        if (i1 == 1030)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)) {
            break;
          }
          ((CampusNoticeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(null);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("notification", 2, "remove campus notice from LSA");
          break;
        }
        if (i1 == 9653)
        {
          ((PullActiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER)).a();
          break;
        }
        if (UinTypeUtil.a(i1) == 1032)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().b();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(AppConstants.CONFESS_UIN, 1032);
          break;
        }
        if (a(i1))
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.PUSH_NOTICE_MANAGER)) {
            break;
          }
          ((PushNoticeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).a(null, i1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("notification", 2, "remove push notice from LSA");
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(paramDragFrameLayout, i1);
        this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a(paramDragFrameLayout, i1);
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a();
        break;
        label1437:
        if (i1 == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
          break label982;
        }
        if (i1 == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
          break label982;
        }
        if ((i1 != 1001) && (i1 != 1010) && (i1 != 10002)) {
          break label982;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
        break label982;
        label1589:
        if (QLog.isColorLevel())
        {
          QLog.d("QQLSActivity", 2, "dragView = null");
          return;
        }
      }
    }
    this.jdField_k_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = 0;
    paramInt = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "exitRecord been called !!!!");
    }
    if (paramBoolean1)
    {
      u();
      this.jdField_k_of_type_Boolean = true;
    }
    for (;;)
    {
      if (paramInt == 0) {
        b(paramBoolean3);
      }
      return;
      if (paramBoolean2)
      {
        this.jdField_h_of_type_Int += 1;
        paramInt = i1;
        if (this.jdField_h_of_type_Int >= 3)
        {
          paramInt = i1;
          if (LsRecordConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            d(2000);
            LsRecordConfig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            this.jdField_h_of_type_Int = 0;
            paramInt = i1;
          }
        }
      }
      for (;;)
      {
        this.jdField_k_of_type_Boolean = true;
        if (this.jdField_d_of_type_Boolean) {
          break label145;
        }
        b();
        break;
        paramInt = i1;
        if (paramString != null)
        {
          a(paramString, 2000);
          paramInt = 1;
        }
      }
      label145:
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isResume()) {
      BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean2, false, false);
    }
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, LSRecordPanel paramLSRecordPanel)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "handleRecording been called !!!!");
    }
    this.jdField_k_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      if (paramBoolean1) {
        a(HardCodeUtil.a(2131710404), -1);
      }
      while (!paramBoolean2) {
        return;
      }
      a(HardCodeUtil.a(2131710405), -1);
      return;
    }
    b(false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (isResume()) {
      BaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean3, paramBoolean1, paramBoolean2);
    }
    this.jdField_b_of_type_Boolean = paramBoolean3;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "app null,  finish");
      }
      finish();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "rcf null,  finish");
      }
      finish();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a())
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
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
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
    PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView == null) || (!(paramView instanceof QQLSActivity.SinglePttHolder))) {
        return false;
      }
      paramView = (QQLSActivity.SinglePttHolder)paramView;
      paramAudioPlayerBase.b(6);
      if (paramAudioPlayerBase.a(paramXListView.getLocalFilePath()))
      {
        a(paramXListView);
        if (paramView != null) {
          a(paramView, paramXListView, PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
        }
        PttInfoCollector.reportPttPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView.istroop, paramXListView.issend);
        if (!paramXListView.isSendFromLocal())
        {
          if (paramXListView.istroop != 0) {
            break label151;
          }
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      paramXListView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramChatMessage.getPttStreamFlag() == 10001) {}
      for (boolean bool = true;; bool = false)
      {
        PttInfoCollector.reportPTTPV(paramXListView, paramInt1, bool, 1);
        return true;
        label151:
        if (paramXListView.istroop == 1)
        {
          paramInt1 = 3;
          break;
        }
        if (paramXListView.istroop != 3000) {
          break label261;
        }
        paramInt1 = 2;
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQLSActivity", 2, "play failed player return false " + paramXListView.getLocalFilePath());
      return false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQLSActivity", 2, "play failed not ready " + paramXListView.getLocalFilePath());
      return false;
      label261:
      paramInt1 = 4;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
  
  public void b()
  {
    long l1;
    android.os.Message localMessage;
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(13))
    {
      l1 = SystemClock.uptimeMillis();
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13);
      if ((l1 - this.jdField_d_of_type_Long > 1000L) || (this.jdField_d_of_type_Long == -1L)) {
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L - (l1 - this.jdField_d_of_type_Long));
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
    new SessionInfo();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null) {}
    SessionInfo localSessionInfo;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserType());
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "QQLSActivity send removeNotification");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeNotification();
      localSessionInfo = a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, " send start currenttime:" + System.currentTimeMillis());
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((localObject != null) && (((String)localObject).length() > 3478))
    {
      ChatActivityUtils.a(this, 2131719043, 1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserType() == 1)
    {
      localObject = new ArrayList();
      String str = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localSessionInfo, str, (ArrayList)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().clear();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
      return;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localSessionInfo, (String)localObject, null);
    }
  }
  
  public void c(int paramInt)
  {
    if (isFinishing()) {}
    do
    {
      do
      {
        return;
        if (paramInt != 0) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(25);
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(getString(2131698490));
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      return;
    } while ((paramInt != 1) || (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null));
    this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
  }
  
  public void d()
  {
    getWindow().addFlags(128);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Boolean))
    {
      this.jdField_f_of_type_Boolean = false;
      t();
    }
    try
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        QLog.e("QQLSActivity", 1, localIndexOutOfBoundsException, new Object[0]);
        bool = false;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        QLog.e("QQLSActivity", 1, localIllegalArgumentException, new Object[0]);
        boolean bool = false;
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onBackPressed=== ");
    }
    l();
    u();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Long = -1L;
    StatisticCollector.getInstance(this).logOnCreate(this);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "qqls dooncreate");
    }
    super.setContentView(2131561324);
    getWindow().addFlags(524288);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().scaledDensity;
    if (!QQLSRecentManager.jdField_c_of_type_Boolean) {
      ThreadManager.getSubThreadHandler().post(new QQLSActivity.1(this));
    }
    paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramBundle, 1000L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager = ((SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER));
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "doOncreate noNeedStart return");
      }
      return true;
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a();
    this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager = ((QQLSRecentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQLS_DATA_MANAGER));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_f_of_type_Boolean = false;
    m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager$INewFriendListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$ScreenBroadcastReceiver = new QQLSActivity.ScreenBroadcastReceiver(this, null);
    g();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    k();
    this.jdField_i_of_type_Boolean = true;
    s();
    p();
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setLSAccountDetailRequestHandler(this.jdField_a_of_type_AndroidOsHandler);
    a(getIntent());
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_b_of_type_ComTencentWidgetXListView);
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentWidgetXListView);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
      this.jdField_l_of_type_Boolean = true;
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setLSAccountDetailRequestHandler(null);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = false;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Boolean = false;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_f_of_type_Boolean = false;
    QQLSRecentManager.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager$INewFriendListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.deleteObserver(this);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$ScreenBroadcastReceiver != null) {
      h();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(null);
    super.doOnDestroy();
    b(false);
    StatisticCollector.getInstance(this).logOnDestroy(this);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnNewIntent intent is not null");
    }
    QQLSRecentManager.jdField_g_of_type_Boolean = false;
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Long = -1L;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade != null) {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a();
    }
    if (!a())
    {
      k();
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(13)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
      }
      b();
    }
    a(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    StatisticCollector.getInstance(this).logOnPause(this);
    this.mRuntime.isBackgroundPause = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onPause,isbackground_pause : true");
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.b();
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(8)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((android.os.Message)localObject, 1500L);
    w();
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_b_of_type_ComTencentWidgetXListView);
      return;
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentWidgetXListView);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnResume taskId" + getTaskId());
    }
    QQLSRecentManager.jdField_g_of_type_Boolean = false;
    StatisticCollector.getInstance(this).logOnResume(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = true;
    this.mRuntime.isBackgroundPause = true;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((android.os.Message)localObject, 500L);
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      b();
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_b_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter, this, this, true, false);
      return;
    }
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter, this, this, false, false);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Boolean = false;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(8)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    }
    a();
  }
  
  public void e()
  {
    setVolumeControlStream(3);
    getWindow().clearFlags(128);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(25, 1000L);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$RecentItemAdapter.notifyDataSetChanged();
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.setVisibility(4);
      QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a();
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "LSActivity finish");
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          super.finish();
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("QQLSActivity", 2, localException2, new Object[0]);
        }
        localException1 = localException1;
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, localException1, new Object[0]);
        }
      }
    }
  }
  
  public void g()
  {
    ThreadManager.executeOnSubThread(new QQLSActivity.15(this), true);
  }
  
  public void h()
  {
    ThreadManager.executeOnSubThread(new QQLSActivity.16(this), true);
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null) && (!isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
        continue;
        v();
        finish();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$SingleItemAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return;
    }
    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
    }
    View localView = new View(this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.getContext());
    localView.setBackgroundColor(-16777216);
    localView.setVisibility(0);
    Object localObject = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.getGlobalVisibleRect((Rect)localObject);
    Rect localRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.getGlobalVisibleRect(localRect);
    localObject = new RelativeLayout.LayoutParams(localRect.right - ((Rect)localObject).left, localRect.top - ((Rect)localObject).top);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.addView(localView, (ViewGroup.LayoutParams)localObject);
    localObject = new AlphaAnimation(0.0F, 0.6F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(300L);
    localView.startAnimation((Animation)localObject);
    this.jdField_a_of_type_AndroidViewView = localView;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.6F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setAnimationListener(new QQLSActivity.17(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void onClick(View paramView)
  {
    if ((jdField_c_of_type_Boolean) && (paramView.getId() == 2131363508)) {
      paramView.findViewById(2131374560).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363963: 
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "onClick btn_close");
        }
        QQLSRecentManager.jdField_c_of_type_Long = System.currentTimeMillis();
        l();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DE", "0X80040DE", 0, 0, "", "", "", "");
        u();
        break;
      case 2131364113: 
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "onClick btn_reply");
        }
        l();
        if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() != 0)) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "onClick mSingleRecentBaseData=null return");
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
              ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
            }
            Toast.makeText(getApplicationContext(), getString(2131698913), 0).show();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserType() == 3000) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "1", "", "", "");
            }
            for (;;)
            {
              localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
              this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((android.os.Message)localObject, 100L);
              break;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserType() == 1) {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "2", "", "", "");
              } else {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "0", "", "", "");
              }
            }
          }
        }
        break;
      case 2131374560: 
        localObject = (QQLSActivity.SinglePttHolder)AIOUtils.a(paramView);
        MessageForPtt localMessageForPtt = (MessageForPtt)((QQLSActivity.SinglePttHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (a(localMessageForPtt)) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
        while (localMessageForPtt.istroop == 1008)
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", localMessageForPtt.timeStr, "", false);
          break;
          if ((localMessageForPtt != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (localMessageForPtt.isReady()))
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
              break label589;
            }
            QQToast.a(this, 1, 2131695173, 0).b(getResources().getDimensionPixelSize(2131299166));
          }
        }
        if ((localObject instanceof QQLSActivity.RecentPttViewHolder)) {}
        for (boolean bool = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView)); !bool; bool = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView)))
        {
          QQToast.a(this, 1, 2131695172, 0).b(getResources().getDimensionPixelSize(2131299166));
          break;
        }
      case 2131364641: 
        label589:
        a(paramView);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "logout finish");
    }
    u();
    super.onLogout(paramLogoutReason);
  }
  
  @Deprecated
  public void onStart()
  {
    Foreground.sCountActivity.getAndDecrement();
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onStart taskId" + getTaskId());
    }
    if (getTaskId() == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "getTadk = -1 finish LS ,or onresume will get badToken!");
      }
      finish();
    }
    try
    {
      Field localField = Activity.class.getDeclaredField("mFinished");
      localField.setAccessible(true);
      localField.get(this);
      localField.set(this, Boolean.valueOf(true));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Foreground.sCountActivity.incrementAndGet();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onUserLeaveHint()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onUserLeaveHint");
    }
    QQLSRecentManager.jdField_g_of_type_Boolean = false;
    l();
    super.onUserLeaveHint();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "update" + Thread.currentThread().getId());
    }
    boolean bool = d();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "LS update isScreenLocked" + bool);
    }
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "LS update screen is unLock finish!!!");
      }
      paramObservable = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObservable);
    }
    label308:
    label750:
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
                    if (!isFinishing()) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("QQLSActivity", 2, "LS update screen is finishing not update");
                  return;
                  if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("QQLSActivity", 2, "LS update user is sendMsg not update");
                return;
                this.jdField_j_of_type_Boolean = false;
                if ((paramObject == null) || (!(paramObject instanceof NewFriendMessage))) {
                  break label308;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QQLSActivity", 2, "data is NewFriendMessage" + Thread.currentThread().getId());
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.d() != 0) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("QQLSActivity", 2, "data is NewFriendMessage unread=0 update return");
              return;
              if ((paramObject instanceof FriendSystemMessage)) {
                a((FriendSystemMessage)paramObject);
              }
              this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.RECOMMEND_CONTACT_UIN, 4000, false, -1, false);
              b();
              return;
              if ((paramObject != null) && ((paramObject instanceof RecentItemVoteData)))
              {
                paramObservable = ((RecentItemVoteData)paramObject).a();
                this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.uin, paramObservable.msgType, false, -1, false);
                paramObservable = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
                QQLSRecentManager.jdField_c_of_type_Boolean = false;
                b();
              }
              for (;;)
              {
                if ((paramObject != null) && ((paramObject instanceof ChatMessage))) {
                  break label531;
                }
                if ((!QLog.isColorLevel()) || (paramObject == null)) {
                  break;
                }
                QLog.d("QQLSActivity", 2, "update data is not chatMessage return" + paramObject.getClass());
                return;
                if ((paramObject != null) && ((paramObject instanceof RecentItemScheduleData)))
                {
                  paramObservable = ((RecentItemScheduleData)paramObject).a();
                  this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.uin, paramObservable.msgType, false, -1, false);
                  paramObservable = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
                  QQLSRecentManager.jdField_c_of_type_Boolean = false;
                  b();
                }
                else if ((paramObject != null) && ((paramObject instanceof RecentItemPullActivePush)))
                {
                  paramObservable = ((RecentItemPullActivePush)paramObject).a();
                  this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.uin, paramObservable.getType(), false, -1, false);
                  paramObservable = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
                  QQLSRecentManager.jdField_c_of_type_Boolean = false;
                  b();
                }
              }
              paramObservable = (ChatMessage)paramObject;
            } while ((paramObservable.isSend()) || (paramObservable.istroop == 6000) || (paramObservable.istroop == 1009) || (paramObservable.istroop == 1036) || (HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
            paramObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
            if (paramObservable.istroop == 1) {}
            for (bool = true;; bool = false)
            {
              QQLSRecentManager.jdField_c_of_type_Boolean = bool;
              paramObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
              if ((!QQLSRecentManager.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor == null)) {
                ThreadManager.getSubThreadHandler().post(new QQLSActivity.11(this));
              }
              if ((!UinTypeUtil.a(paramObservable)) || (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable))) {
                break label750;
              }
              if ((1001 != paramObservable.istroop) && (10002 != paramObservable.istroop)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.LOCK_SCREEN_LBS_HELLO_UIN, paramObservable.istroop, false, -1, false);
              b();
              return;
            }
          } while (1010 != paramObservable.istroop);
          this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.LOCK_SCREEN_DATE_UIN, paramObservable.istroop, false, -1, false);
          b();
          return;
          if (paramObservable.istroop != 1) {
            break;
          }
        } while (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramObservable.frienduin));
        paramObject = (RoamSettingController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_TROOP_FILTER);
      } while ((paramObject != null) && (paramObject.a(paramObservable.frienduin, 1) != 1));
    } while ((DiscussionManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.frienduin, paramObservable.istroop)) || ((paramObservable.istroop == 1008) && ((paramObservable.extStr == null) || (((paramObservable.extLong & 0x1) == 0) && (!paramObservable.extStr.contains("lockDisplay"))) || (paramObservable.extStr == null) || (((paramObservable.extLong & 0x1) == 1) && (!paramObservable.getExtInfoFromExtStr("lockDisplay").equals("true"))))) || ((paramObservable.istroop == 7220) && ((paramObservable.extInt == 5) || (paramObservable.extInt == 6))) || ((paramObservable.istroop == 7220) && (paramObservable.extInt == 2) && (TextUtils.equals(paramObservable.senderuin, AppConstants.NEW_KANDIAN_UIN))));
    label531:
    this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.frienduin, paramObservable.istroop, false, -1, false);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity
 * JD-Core Version:    0.7.0.1
 */