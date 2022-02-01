package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Handler.Callback;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.IconClickInterceptListener;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.LimitMsgLoader;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.INotifyReg;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.ExpandDTParamBuilder;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendConfig;
import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.extendfriend.utils.MatchChatAioVoicePlayerManager;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSafeTipArkDialog;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceAnimView;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class LimitChatPie
  extends BaseChatPie
  implements Handler.Callback, ArkAppNotifyCenter.INotifyReg
{
  private boolean N = false;
  private boolean O = false;
  private boolean P = false;
  private boolean Q = true;
  private boolean R = false;
  private boolean S = false;
  protected BroadcastReceiver a;
  private PanelIconLinearLayout.IconClickInterceptListener jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$IconClickInterceptListener = new LimitChatPie.1(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new LimitChatPie.5(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new LimitChatPie.3(this);
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new LimitChatPie.4(this);
  private volatile ExtendFriendUserInfo jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo;
  ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new LimitChatPie.12(this);
  private ExtendFriendSafeTipArkDialog jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog;
  private Observer jdField_a_of_type_JavaUtilObserver = new LimitChatPie.2(this);
  private long jdField_b_of_type_Long = -1L;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private long c;
  private String f = "";
  private String g;
  private String h = "";
  private int k = 0;
  private volatile int l;
  private int m;
  private int n = 0;
  private int o = 0;
  private int p;
  private int q;
  private int r = 0;
  private int s = 0;
  private int t;
  private int u;
  
  static
  {
    ExpandReportUtils.a();
    QLog.i("LimitChatPie", 1, "init expand tunnel");
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
  }
  
  public LimitChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_g_of_type_JavaLangString = "0";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new LimitChatPie.20(this);
    e(paramViewGroup);
  }
  
  private boolean E()
  {
    ExtendFriendConfig localExtendFriendConfig = ((ExtendFriendManager)a().app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    if (localExtendFriendConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatPie", 2, "hasSendMsgToEachOther return true for null cfg");
      }
      return true;
    }
    int i = localExtendFriendConfig.x;
    if ((i > 0) && ((this.p < i) || (this.q < i))) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatPie", 2, "isSendReceiveMsgCountOverThreshHold result = " + bool + ",msgThreshHold = " + i + ",historySendMsgCount = " + this.p + ",historyReceivedMsgCount = " + this.q);
      }
      return bool;
    }
  }
  
  private boolean F()
  {
    boolean bool1 = false;
    int j = 0;
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      int i = j;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a()) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
      }
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a())
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private boolean G()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_d_of_type_AndroidWidgetImageView != null)
    {
      bool1 = bool2;
      if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null)
        {
          bool1 = bool2;
          if (this.s == 7)
          {
            bw();
            bu();
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean H()
  {
    boolean bool = false;
    ExtendFriendLimitChatManager localExtendFriendLimitChatManager;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1044) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localExtendFriendLimitChatManager = (ExtendFriendLimitChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (localExtendFriendLimitChatManager == null) {
          break label67;
        }
      }
    }
    label67:
    for (bool = localExtendFriendLimitChatManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();; bool = false)
    {
      return bool;
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "UINTYPE NOT Y");
      return false;
    }
  }
  
  private long a(List<ChatMessage> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return -1L;
    }
    int j = i - 1;
    if (!((ChatMessage)paramList.get(j)).isSelf()) {
      return b() - ((ChatMessage)paramList.get(j)).time;
    }
    i = j;
    int i1 = j - 1;
    j = i;
    i = i1;
    while (j > 0)
    {
      if ((((ChatMessage)paramList.get(j)).isSelf()) && (!((ChatMessage)paramList.get(i)).isSelf())) {
        return ((ChatMessage)paramList.get(j)).time - ((ChatMessage)paramList.get(i)).time;
      }
      j -= 1;
      i -= 1;
    }
    return -1L;
  }
  
  private String a(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    Object localObject = "0";
    Iterator localIterator = paramList1.iterator();
    paramList1 = (List<ChatMessage>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (ChatMessage)localIterator.next();
      if (ExpandFriendChatUtil.a((MessageRecord)localObject)) {
        break label65;
      }
      paramList2.add(localObject);
      if (((ChatMessage)localObject).isSelf()) {
        break label65;
      }
      paramList1 = "1";
    }
    label65:
    for (;;)
    {
      break;
      return paramList1;
    }
  }
  
  private void a(ArkView paramArkView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog = new ExtendFriendSafeTipArkDialog(a(), 2131755191);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog.a(paramArkView);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog.setContentView(2131561205);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog.setOnDismissListener(new LimitChatPie.10(this));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog.show();
      ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a("sp_extend_friend_prompt_safe_tip", 1);
      return;
    }
    catch (Throwable paramArkView)
    {
      QLog.w("LimitChatPie", 2, "check855AIOChatManner showDialog failed ", paramArkView);
    }
  }
  
  private void a(String paramString, ExtendFriendManager paramExtendFriendManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo = paramExtendFriendManager.a(paramString, true);
    if (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1045) {
        break label97;
      }
      LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1, "", false, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo = paramExtendFriendManager.a(paramString, true);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.isSignalBomb()) && (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.showDistanceHLight))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.showDistanceHLight = false;
        paramExtendFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo);
      }
      return;
      label97:
      LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1, "", false, 3);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    String str = "1";
    if (this.s == 3) {
      str = "3";
    }
    localHashMap.put("match_type", str);
    localHashMap.put("to_uid", paramString1);
    localHashMap.put("session_id", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "_" + paramString1);
    localHashMap.put("dating_purpose", String.valueOf(this.u));
    localHashMap.put("choose_condition", String.valueOf(this.t + 1));
    localHashMap.put("TF", paramString2);
    ExpandReportUtils.a("click#match_page#send_message", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void a(String paramString, List<MessageRecord> paramList)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((paramList == null) || (paramList.size() == 0))
    {
      j(paramString);
      this.l = 0;
      return;
    }
    this.l = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i >= this.l) {
        break label75;
      }
      if (ExpandFriendChatUtil.b((MessageRecord)paramList.get(i))) {
        break;
      }
      i += 1;
    }
    label75:
    j(paramString);
  }
  
  private void a(ArrayList<Long> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "handleExtendFriendOnlineState onlineUinList =" + paramArrayList);
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    String str = ((Long)paramArrayList.get(0)).toString();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {}
    for (paramArrayList = ""; str.equals(paramArrayList); paramArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      this.S = true;
      a().runOnUiThread(new LimitChatPie.15(this));
      return;
    }
    this.S = false;
  }
  
  private long b()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  private void b(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (!ExpandFriendChatUtil.a(localMessageRecord)) {
          if (MessageRecordInfo.a(localMessageRecord.issend)) {
            this.p += 1;
          } else {
            this.q += 1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatPie", 2, "calcHistorySendReceiveMsgCount historySendMsgCount = " + this.p + ",historyReceivedMsgCount = " + this.q);
  }
  
  private void bj()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "gotoFriendAio : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Intent localIntent = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", 0);
    a().startActivity(localIntent);
  }
  
  private void bk()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LimitChatPie", 2, "registerReceiver exception: " + localException);
    }
  }
  
  private void bl()
  {
    try
    {
      a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LimitChatPie", 2, "unregisterReceiver exception: " + localException);
    }
  }
  
  private void bm()
  {
    this.jdField_g_of_type_JavaLangString = ExpandFriendChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ArkAppNotifyCenter.setNotify("com.tencent.mobileqq.expandfriend.breakicetopic", new WeakReference(this));
    ThreadManager.getSubThreadHandler().post(new LimitChatPie.7(this));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {
      this.m = ExpandFriendChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.c = System.currentTimeMillis();
  }
  
  private void bn()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_b_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", l1 - l2 + "");
    ExpandReportUtils.a("exit#chat_page#view", true, localHashMap);
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void bo()
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    BaseActivity localBaseActivity = a();
    DialogUtil.a(localBaseActivity, localBaseActivity.getString(2131694371), 2131719347, 0, null, new LimitChatPie.8(this, localExtendFriendManager)).show();
    localExtendFriendManager.a("sp_extend_friend_prompt_aio_save_empty_node", 1);
    ExpandReportUtils.a("expose#chat_page#aio_exit_windows", true, -1L, -1L, null, true, true);
  }
  
  private void bp()
  {
    ArkAppNotifyCenter.setNotify("com.tencent.mobileqq.expand.aiosafe", new WeakReference(this));
    ExtendFriendSafeTipArkDialog.a((ArkView)((ViewGroup)LayoutInflater.from(a()).inflate(2131561204, a())).findViewById(2131363017), new LimitChatPie.9(this));
  }
  
  private void bq()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
    }
    this.jdField_b_of_type_Boolean = false;
    b(true);
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void br()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
    ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, localAllInOne, this.r, 2);
  }
  
  private void bs()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      localObject = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "updateSession_updateSubTitle toUin =" + (String)localObject);
      }
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.add(Long.valueOf((String)localObject));
        label63:
        if (!localArrayList.isEmpty())
        {
          localObject = (ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
          if (localObject != null) {
            ((ExtendFriendHandler)localObject).a(localArrayList);
          }
        }
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      catch (Exception localException)
      {
        break label63;
      }
    }
  }
  
  private void bt()
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.b();
    }
  }
  
  private void bu()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698388)).setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131694615), new LimitChatPie.18(this)).setNegativeButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131690800), new LimitChatPie.17(this));
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    }
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ADC8", "0X800ADC8", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "ShowVoiceDialog fail" + localException.toString());
      }
    }
  }
  
  private void bv()
  {
    this.Q = ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).b();
    ((ExtendFriendLimitChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a(this.Q);
  }
  
  private void bw()
  {
    if ((this.jdField_d_of_type_AndroidWidgetImageView.getParent() instanceof RelativeLayout))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_d_of_type_AndroidWidgetImageView.getParent();
      ExtendFriendVoiceAnimView localExtendFriendVoiceAnimView = new ExtendFriendVoiceAnimView(this.jdField_a_of_type_AndroidContentContext);
      int i = ViewUtils.a(29.0F);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.addRule(13, -1);
      localRelativeLayout.addView(localExtendFriendVoiceAnimView, 0, localLayoutParams);
      localExtendFriendVoiceAnimView.setCircleParams(k(), 800);
      localExtendFriendVoiceAnimView.a(500L);
    }
  }
  
  private void bx()
  {
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131698840), 0).a();
    }
  }
  
  private void by()
  {
    ThreadManager.getSubThreadHandler().post(new LimitChatPie.19(this));
  }
  
  private void c(long paramLong)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if ((localChatMessage.msgtype == -4027) && (localChatMessage.shmsgseq == paramLong))
      {
        ChatFragment localChatFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment();
        if (localChatFragment != null) {
          localChatFragment.a().a(localChatMessage);
        }
      }
    }
  }
  
  private void e(View paramView)
  {
    VideoReport.addToDetectionWhitelist(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    VideoReport.setPageId(paramView, "chat_page");
    VideoReport.setPageParams(paramView, new ExpandDTParamBuilder().a());
    QLog.i("LimitChatPie", 1, "reportDaTongRegister");
  }
  
  private void j(String paramString)
  {
    if (!((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f()) {
      ExtendFriendSendMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(Long.parseLong(paramString)), this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
  }
  
  private int k()
  {
    String str1 = "#FFFFFFFF";
    String str2 = ThemeUtil.getCurrentThemeId();
    if ("1103".equals(str2)) {
      str1 = "#FFA1A1A1";
    }
    for (;;)
    {
      try
      {
        int i = Color.parseColor(str1);
        return i;
      }
      catch (Exception localException) {}
      if ("2920".equals(str2)) {
        str1 = "#FF848484";
      } else if ("2101".equals(str2)) {
        str1 = "#FFDBB86B";
      } else if ("2105".equals(str2)) {
        str1 = "#FF12B7F5";
      } else if (QQTheme.c(str2)) {
        if (("2921".equals(str2)) || ("2971".equals(str2))) {
          str1 = "#FF03081A";
        } else {
          str1 = "#FFFFFFFF";
        }
      }
    }
    return 0;
  }
  
  public void A() {}
  
  public void J()
  {
    super.J();
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatPie", 2, "doOnDestroy, userfinish:" + this.O);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconClickInterceptListener(null);
    ((NewFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_JavaUtilObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    String str;
    long l1;
    long l2;
    HashMap localHashMap;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)
    {
      str = "";
      if (this.P)
      {
        l1 = System.currentTimeMillis();
        l2 = this.c;
        localHashMap = new HashMap();
        localHashMap.put("chat_id", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + str);
        localHashMap.put("to_uid", str);
        if ((this.n <= 0) || (this.o <= 0)) {
          break label295;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A695", "0X800A695", 0, 0, "", "", "", "");
        ExpandReportUtils.a("click#chat_page#double_match", true, -1L, -1L, localHashMap, true, true);
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A692", "0X800A692", 0, 0, String.valueOf(l1 - l2), "", this.jdField_g_of_type_JavaLangString, "");
      bl();
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog.c();
      }
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break;
      label295:
      if ((this.n > 0) || (this.o > 0))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A694", "0X800A694", 0, 0, "", "", "", "");
        ExpandReportUtils.a("click#chat_page#single_match", true, -1L, -1L, localHashMap, true, true);
      }
    }
  }
  
  public void L()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    localIntent.putExtra("key_limit_chat_result_action", this.k);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, localIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chat pie finish, finishaction:" + this.k);
    }
    this.O = true;
  }
  
  public void M()
  {
    super.M();
    ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog != null) {
      ArkAppNotifyCenter.setNotify("com.tencent.mobileqq.expand.aiosafe", new WeakReference(this));
    }
  }
  
  public void N()
  {
    super.N();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ExpandFriendChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog != null) {
      ArkAppNotifyCenter.setNotify("com.tencent.mobileqq.expand.aiosafe", null);
    }
  }
  
  public void O()
  {
    super.O();
    MatchChatAioVoicePlayerManager.b();
    bn();
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog.b();
    }
  }
  
  public void R()
  {
    super.R();
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bj();
    }
    bv();
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(this.s));
    localHashMap.put("chat_id", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localHashMap.put("to_uid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (this.S) {}
    for (String str = "1";; str = "2")
    {
      localHashMap.put("ext_int1", str);
      ExpandReportUtils.a("expose#chat_page#view", true, -1L, -1L, localHashMap, true, true);
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog.a();
      }
      return;
    }
  }
  
  public void X()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onPreThemeChanged" + this.D);
    }
  }
  
  public void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onPostThemeChanged" + this.D);
    }
    aP();
  }
  
  public MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new LimitMsgLoader()).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public RecordParams.RecorderParam a()
  {
    boolean bool = super.s();
    return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  public void a()
  {
    int i = 1;
    Object localObject = (ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    int i1 = ((ExtendFriendManager)localObject).d();
    int j;
    if (i1 > 0)
    {
      j = this.l / i1 + 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "checkShowGrayTips " + this.l + " " + j + " " + this.m);
      }
      if (this.l % i1 != 0) {
        break label171;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        String str = ((ExtendFriendManager)localObject).e();
        localObject = ((ExtendFriendManager)localObject).f();
        if (!TextUtils.isEmpty(str))
        {
          ExpandFriendChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, j);
          this.m = j;
          ThreadManager.getSubThreadHandler().post(new LimitChatPie.6(this, str, (String)localObject));
        }
      }
      return;
      label171:
      if (j - this.m <= 1) {
        i = 0;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onPanelChanged, old:" + paramInt1 + " new:" + paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(com.tencent.imcore.message.Message paramMessage)
  {
    super.a(paramMessage);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 4: 
      paramObject = (PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(4);
      if (paramObject != null) {
        paramObject.setCustomOnClickListener(new LimitChatPie.SendImageListener(this));
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AA", "0X80096AA", this.r, 0, "", "", "", "");
      return;
    case 2: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A9", "0X80096A9", this.r, 0, "", "", "", "");
      return;
    case 5: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AB", "0X80096AB", this.r, 0, "", "", "", "");
      return;
    case 24: 
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.setOnHotPicItemClickListener(new LimitChatPie.SendGifListener(this));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AC", "0X80096AC", this.r, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AD", "0X80096AD", this.r, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((this.D) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    bq();
    ((NewFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    bm();
    this.s = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("key_limitchat_enter_type", 0);
    QLog.w("LimitChatPie", 2, "enter limit_chat_pie from_page" + this.s);
    this.t = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("key_limitchat_match_sex_type", 0);
    this.u = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("key_limitchat_match_purpose", 0);
    bk();
    return paramBoolean;
  }
  
  public void aP()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updateUI_titleBarForTheme" + this.D);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    super.aP();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this);
  }
  
  public void ad()
  {
    super.ad();
  }
  
  public void al()
  {
    super.al();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "addBusinessObservers");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void ap()
  {
    i("1");
    super.ap();
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.e.setOnClickListener(new LimitChatPie.13(this));
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "setSubTitlonShowSubTitleTexteText statusText =" + paramString);
    }
    AioFriendTitleHelper localAioFriendTitleHelper = (AioFriendTitleHelper)a(45);
    if ((localAioFriendTitleHelper != null) && (localAioFriendTitleHelper.a(paramBoolean, paramString))) {
      return;
    }
    a().runOnUiThread(new LimitChatPie.14(this, paramString, paramBoolean));
  }
  
  public void bf()
  {
    super.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
  }
  
  public void bi()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A693", "0X800A693", 0, 0, "", "", "", "");
    i("4");
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "LimitChatPie";
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    this.r = paramIntent.getIntExtra("key_limitchat_from_type", 0);
    this.P = paramIntent.getBooleanExtra("key_limitchat_auto_open", false);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updateSession, mfromType :" + this.r);
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "setSubTitleText text =" + paramString);
    }
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.a(paramString);
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    MatchChatAioVoicePlayerManager.b();
    super.d();
  }
  
  public void e(Intent paramIntent)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChoiceMode(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconClickInterceptListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$IconClickInterceptListener);
  }
  
  public boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onBackEvent begin");
    }
    if (F()) {
      return true;
    }
    return super.g();
  }
  
  public void h(int paramInt)
  {
    super.h(paramInt);
    ShortcutBarAIOHelper localShortcutBarAIOHelper = (ShortcutBarAIOHelper)a(52);
    if (localShortcutBarAIOHelper != null) {
      localShortcutBarAIOHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  public void i(String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(this.s));
    localHashMap.put("message_type", paramString);
    localHashMap.put("chat_id", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + str);
    localHashMap.put("to_uid", str);
    localHashMap.put("dating_purpose", "" + this.u);
    Object localObject = a();
    paramString = new ArrayList();
    localObject = a((List)localObject, paramString);
    long l1 = a(paramString);
    localHashMap.put("TF", localObject);
    localHashMap.put("duration", "" + l1);
    if (this.S) {}
    for (paramString = "1";; paramString = "2")
    {
      localHashMap.put("ext_int1", paramString);
      ExpandReportUtils.a("click#chat_page#message_success", true, -1L, -1L, localHashMap, true, true);
      if ((this.s == 3) || (this.s == 7)) {
        a(str, (String)localObject);
      }
      return;
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
  }
  
  public void k(boolean paramBoolean) {}
  
  public void m(int paramInt)
  {
    super.m(paramInt);
    bs();
  }
  
  public boolean notify(String paramString1, String paramString2, String paramString3)
  {
    QLog.i("LimitChatPie", 1, "notify, appName = " + paramString1 + ", eventName : " + paramString2 + ", params : " + paramString3);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    if ("com.tencent.mobileqq.expand.aiosafe".equals(paramString1)) {
      if ("closeView".equals(paramString2))
      {
        ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a("sp_extend_friend_prompt_safe_tip", 3);
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSafeTipArkDialog.dismiss();
          return true;
        }
      }
      else if ("viewDidLoad".equals(paramString2))
      {
        ThreadManager.getUIHandler().post(new LimitChatPie.11(this));
      }
    }
    for (;;)
    {
      return false;
      if ("com.tencent.mobileqq.expandfriend.breakicetopic".equals(paramString1)) {
        if ("onSendMessage".equals(paramString2)) {
          try
          {
            paramString1 = new JSONObject(paramString3);
            paramString2 = "" + paramString1.getLong("matchUin");
            long l1 = paramString1.getLong("msgSeq");
            if (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              continue;
            }
            i("6");
            c(l1);
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
          }
        } else if ("onResizeView".equals(paramString2)) {
          g(196613);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void q()
  {
    super.q();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = (InputStatusHelper)a(16);
      if (paramObject != null)
      {
        if (!paramObservable.isSend()) {
          break label58;
        }
        paramObject.d();
        if ((paramObservable instanceof MessageForApollo)) {
          i("7");
        }
      }
    }
    label58:
    do
    {
      do
      {
        return;
        if (paramObservable.time > paramObject.jdField_b_of_type_Long) {
          bt();
        }
        if (paramObservable.senderuin == null)
        {
          QLog.w(this.jdField_b_of_type_JavaLangString, 1, "LimitChatPie update error, MessageRecord.senderuin is null");
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.enableQQCall)) {
          break;
        }
      } while ((!paramObservable.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.uin)) || (this.l <= 4));
      this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.enableQQCall = true;
      by();
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramObservable.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    this.R = true;
  }
  
  public void v()
  {
    if (Boolean.valueOf(H()).booleanValue())
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new LimitChatPie.16(this));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void z()
  {
    if ((BusinessUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (BusinessUtils.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    String str2 = this.f;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("ExtendFriendLimitChatFromeType", this.r);
    if (this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) {
      localIntent.putExtra("subId", ExtendFriendUserInfo.fromTypeToSubID(this.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.fromType));
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie
 * JD-Core Version:    0.7.0.1
 */