package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ark.open.ArkView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.LimitHelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.LimitMessageSender;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.LimitMsgLoader;
import com.tencent.mobileqq.activity.aio.rebuild.tips.LimitTipsController;
import com.tencent.mobileqq.apollo.model.IMessageForApollo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.chat.IAioVoicePlayerManager;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatNetworkHelper;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.manager.IExpandLimitChatManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.DateUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandSPUtils;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendSafeTipArkDialog;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendVoiceAnimView;
import com.tencent.mobileqq.qqexpand.widget.chat.HotProtectDialog;
import com.tencent.mobileqq.qqexpand.widget.chat.MaskDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.XPanelContainer;
import expand.common.AdvertisingVideo.AbleToGreetRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class LimitChatPie
  extends BaseChatPie
  implements Handler.Callback, IAppNotifyCallback
{
  private boolean bA = false;
  private int bB;
  private Observer bC = new LimitChatPie.1(this);
  private final MessageObserver bD = new LimitChatPie.2(this);
  private final AvatarObserver bE = new LimitChatPie.3(this);
  private final FriendListObserver bF = new LimitChatPie.4(this);
  ExpandObserver bi = new LimitChatPie.16(this);
  protected BroadcastReceiver bj = new LimitChatPie.32(this);
  private long bk = -1L;
  private long bl = -1L;
  private int bm;
  private int bn = 0;
  private int bo = 0;
  private int bp;
  private int bq;
  private String br = "0";
  private int bs = 0;
  private boolean bt = false;
  private ExtendFriendSafeTipArkDialog bu;
  private final Map<Integer, Object> bv = new HashMap();
  private int bw = 0;
  private int bx = -1;
  private int by;
  private int bz;
  
  public LimitChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    e(paramViewGroup);
    a();
  }
  
  private void a(int paramInt, String paramString)
  {
    b(paramInt, paramString);
    this.bB = paramInt;
    this.bA = true;
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 2) || (paramInt == 5)) {
      ca();
    }
  }
  
  private void a(ArkView paramArkView)
  {
    if (this.bu == null)
    {
      this.bu = new ExtendFriendSafeTipArkDialog(aX(), 2131952058);
      this.bu.a(paramArkView);
      this.bu.a();
      this.bu.setCanceledOnTouchOutside(false);
      this.bu.setOnDismissListener(new LimitChatPie.13(this));
    }
    paramArkView = this.bu;
    if ((paramArkView != null) && (!paramArkView.isShowing())) {
      try
      {
        this.bu.show();
        ((IExpandManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a("sp_extend_friend_prompt_safe_tip", 1);
        return;
      }
      catch (Throwable paramArkView)
      {
        QLog.w("LimitChatPie", 2, "check855AIOChatManner showDialog failed ", paramArkView);
      }
    }
  }
  
  private void a(IExpandManager paramIExpandManager)
  {
    boolean bool2 = ((IExpandSPUtils)QRoute.api(IExpandSPUtils.class)).canPopDialog("sp_extend_friend_prompt_aio_save_empty_node");
    int i = paramIExpandManager.f("sp_extend_friend_prompt_safe_tip");
    boolean bool1;
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int j = bP();
    QLog.w("LimitChatPie", 1, String.format("openSaveEmptyAIONodeDialog : %b, popupDialogState : %d, notShowSafeTip : %b, matchSrc : %d", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j) }));
    ThreadManager.getUIHandler().post(new LimitChatPie.8(this, bool2, bool1, j));
  }
  
  private void a(@NonNull ExpandResponse paramExpandResponse)
  {
    Object localObject = new AdvertisingVideo.AbleToGreetRsp();
    try
    {
      ((AdvertisingVideo.AbleToGreetRsp)localObject).mergeFrom(paramExpandResponse.a());
      paramExpandResponse = new StringBuilder();
      paramExpandResponse.append(this.c);
      paramExpandResponse.append("expand.chat.");
      paramExpandResponse = paramExpandResponse.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestSendMessage succ. code = ");
      localStringBuilder.append(((AdvertisingVideo.AbleToGreetRsp)localObject).code.get());
      QLog.d(paramExpandResponse, 4, localStringBuilder.toString());
      int i = ((AdvertisingVideo.AbleToGreetRsp)localObject).code.get();
      paramExpandResponse = ((AdvertisingVideo.AbleToGreetRsp)localObject).tips_wording.get();
      b(i, paramExpandResponse);
      this.bB = i;
      this.bA = ((AdvertisingVideo.AbleToGreetRsp)localObject).need_report.get();
      ((IExpandSPUtils)QRoute.api(IExpandSPUtils.class)).setGreetLimit(this.d.getCurrentUin(), i, paramExpandResponse);
      if ((i == 1) || (i == 3) || (i == 2) || (i == 5)) {
        ca();
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramExpandResponse)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("expand.chat.");
      QLog.w(((StringBuilder)localObject).toString(), 1, paramExpandResponse.toString());
    }
  }
  
  private void a(QQCustomDialog paramQQCustomDialog, int paramInt)
  {
    try
    {
      this.bv.put(Integer.valueOf(paramInt), paramQQCustomDialog);
      paramQQCustomDialog.show();
      return;
    }
    catch (Exception paramQQCustomDialog)
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pop ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" Dialog fail");
      localStringBuilder.append(paramQQCustomDialog.toString());
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.equals(paramString1, this.ah.b)) && (paramInt1 == this.ah.a))
    {
      paramSendMessageHandler = this.c;
      paramString2 = new StringBuilder();
      paramString2.append("onUpdateSendMsgError uin ");
      paramString2.append(paramString1);
      paramString2.append(" type ");
      paramString2.append(paramInt1);
      paramString2.append(" uinseq ");
      paramString2.append(paramLong2);
      paramString2.append(" errorCode ");
      paramString2.append(paramInt2);
      QLog.w(paramSendMessageHandler, 1, paramString2.toString());
      j(196608);
      return;
    }
    paramSendMessageHandler = this.c;
    paramString2 = new StringBuilder();
    paramString2.append("onUpdateSendMsgError exception uin ");
    paramString2.append(paramString1);
    paramString2.append(" type ");
    paramString2.append(paramInt1);
    paramString2.append(" uinseq ");
    paramString2.append(paramLong2);
    QLog.w(paramSendMessageHandler, 1, paramString2.toString());
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, MatchInfo paramMatchInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, String.format("onGetUnLimitFriendInfo() success=%s uinType=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
    if ((paramBoolean) && (paramMatchInfo != null)) {
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.18(this, paramInt2, paramMatchInfo));
    }
  }
  
  private void a(boolean paramBoolean, StrangerInfo paramStrangerInfo, int paramInt)
  {
    if ((paramBoolean) && (paramStrangerInfo != null))
    {
      VipUtils.a(this.d, paramStrangerInfo, this.p, this.H, this.aO);
      if ((!TextUtils.isEmpty(paramStrangerInfo.mNickName)) && (this.f.isResume()))
      {
        ThreadManager.getSubThreadHandler().post(new LimitChatPie.17(this, paramStrangerInfo));
        this.C.setText(paramStrangerInfo.mNickName);
        this.ah.e = paramStrangerInfo.mNickName;
        bZ();
      }
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).handlePreLoadDataForArkMiniProfileCard(this.d, this.ah.b, this.ah.a, false, paramObject);
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.19(this));
      return;
    }
    QLog.w(this.c, 1, "onPreLoadDataForArkMiniProfileCard network error, data is null");
  }
  
  private void a(boolean paramBoolean, Object paramObject, int paramInt)
  {
    if ((paramInt != 32) && (paramInt != 33))
    {
      QLog.e("LimitChatPie", 1, "error! type must be either 32 or 33");
      return;
    }
    if ((paramBoolean) && (paramObject != null))
    {
      String str;
      if (paramInt == 32) {
        str = this.d.getCurrentUin();
      } else {
        str = this.ah.b;
      }
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).handlePreLoadDataForAvatarProfileCard(this.d, str, paramObject);
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.20(this));
      return;
    }
    QLog.w(this.c, 1, "onPreLoadDataForArkMiniProfileCard network error, data is null");
  }
  
  private void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.d != null) && (!TextUtils.isEmpty(paramString)) && (TextUtils.equals(paramString, this.d.getCurrentAccountUin())))
    {
      j(65536);
      return;
    }
    QLog.w(this.c, 1, "handleUpdateApolloHead, error: app is null or uin error");
  }
  
  private void a(boolean paramBoolean, List<Long> paramList1, int paramInt, List<Long> paramList2)
  {
    if ((paramBoolean) && (paramList1 != null) && (!paramList1.isEmpty()))
    {
      if (TextUtils.isEmpty(this.ah.b)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramList2 = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleExtendFriendOnlineState onlineUinList =");
        localStringBuilder.append(paramList1);
        QLog.i(paramList2, 2, localStringBuilder.toString());
      }
      if (((Long)paramList1.get(0)).toString().equals(this.ah.b))
      {
        this.bt = true;
        aX().runOnUiThread(new LimitChatPie.22(this));
        return;
      }
      this.bt = false;
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    if (this.f != null)
    {
      if (this.f.isFinishing()) {
        return;
      }
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 5) {
              return;
            }
            k(paramString);
            return;
          }
          i(paramString);
          return;
        }
        j(paramString);
        return;
      }
      h(paramString);
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt > 0) && (t(paramInt)) && (!TextUtils.isEmpty(paramString1)))
    {
      a(paramInt, paramString1, paramString2);
      return;
    }
    QLog.w(this.c, 1, "showMakeFriendGrayTips, error: messageNum is <= 0 or isInsertMakeFriendGrayTips is false or tipsString is null");
  }
  
  private void b(Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      InputStatusHelper localInputStatusHelper = (InputStatusHelper)q(16);
      if (localInputStatusHelper != null) {
        if (paramObject.isSend())
        {
          localInputStatusHelper.d();
          if ((paramObject instanceof IMessageForApollo)) {
            f("7");
          }
        }
        else if (paramObject.time > localInputStatusHelper.b)
        {
          cc();
        }
      }
    }
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).handlePreLoadDataForIcebreakerTopic(this.d, this.ah.b, this.ah.a, paramObject);
      return;
    }
    QLog.w(this.c, 1, "onPreLoadDataForIcebreakerTopic network error, data is null");
  }
  
  private void b(boolean paramBoolean, String paramString)
  {
    j(65536);
  }
  
  private void bJ()
  {
    Intent localIntent = AIOUtils.a(new Intent(aX(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.ah.b);
    localIntent.putExtra("uintype", 0);
    aX().startActivity(localIntent);
  }
  
  private int bK()
  {
    int i = this.bz;
    if (i > 0) {
      return i;
    }
    i = this.bx;
    if (i > 0) {
      return i;
    }
    if (this.ah == null) {
      return 0;
    }
    return ExpandFriendData.getMatchSrc(this.d, this.ah.b);
  }
  
  private void bL()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      aX().registerReceiver(this.bj, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerReceiver exception: ");
      localStringBuilder.append(localException);
      QLog.e("LimitChatPie", 1, localStringBuilder.toString());
    }
  }
  
  private void bM()
  {
    try
    {
      aX().unregisterReceiver(this.bj);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregisterReceiver exception: ");
      localStringBuilder.append(localException);
      QLog.e("LimitChatPie", 1, localStringBuilder.toString());
    }
  }
  
  private void bN()
  {
    if (this.bx >= 0) {
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).requestAddMatchedRelation(this.d, this.d.getCurrentUin(), this.ah.b, this.bx);
    }
  }
  
  private void bO()
  {
    ThreadManager.getSubThreadHandler().post(new LimitChatPie.7(this));
  }
  
  private int bP()
  {
    BaseActivity localBaseActivity = this.f;
    int i = 0;
    if (localBaseActivity != null) {
      i = this.f.getIntent().getIntExtra("key_limitchat_match_purpose", 0);
    }
    return i;
  }
  
  private boolean bQ()
  {
    int i = ((IExpandSPUtils)QRoute.api(IExpandSPUtils.class)).getGreetLimitCode(this.d.getCurrentUin());
    String str = ((IExpandSPUtils)QRoute.api(IExpandSPUtils.class)).getGreetLimitString(this.d.getCurrentUin());
    long l = ((IExpandSPUtils)QRoute.api(IExpandSPUtils.class)).getGreetLimitTime(this.d.getCurrentUin());
    if ((!AppNetConnInfo.isNetSupport()) && (i != 0) && (DateUtils.a.b(l)))
    {
      ThreadManager.getUIHandler().post(new LimitChatPie.10(this, i, str));
      return true;
    }
    return false;
  }
  
  private void bR()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.bk;
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1 - l2);
    localStringBuilder.append("");
    localHashMap.put("duration", localStringBuilder.toString());
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("exit#chat_page#view", true, localHashMap);
  }
  
  private void bS()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(this.bw));
    localHashMap.put("to_uid", this.ah.b);
    String str;
    if (this.bt) {
      str = "1";
    } else {
      str = "2";
    }
    localHashMap.put("ext_int1", str);
    localHashMap.put("source_id", String.valueOf(bK()));
    localHashMap.put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.d.getCurrentAccountUin(), this.ah.b));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#chat_page#view", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void bT()
  {
    if ((this.bn > 0) && (this.bo > 0))
    {
      ReportController.b(this.d, "dc00898", "", "", "0X800A695", "0X800A695", 0, 0, "", "", "", "");
      return;
    }
    if ((this.bn > 0) || (this.bo > 0)) {
      ReportController.b(this.d, "dc00898", "", "", "0X800A694", "0X800A694", 0, 0, "", "", "", "");
    }
  }
  
  private boolean bU()
  {
    int i = this.n.getCurrentPanel();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0)
    {
      bool1 = bool2;
      if (!((AudioPanelProvider)this.ae.f(2)).g())
      {
        this.n.a(true);
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkConsumeBackEvent, comsumed:");
      localStringBuilder.append(bool1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  private void bV()
  {
    IExpandManager localIExpandManager = (IExpandManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    BaseActivity localBaseActivity = aX();
    DialogUtil.a(localBaseActivity, localBaseActivity.getString(2131892009), 2131916601, 0, null, new LimitChatPie.11(this, localIExpandManager)).show();
    localIExpandManager.a("sp_extend_friend_prompt_aio_save_empty_node", 1);
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#chat_page#aio_exit_windows", true, -1L, -1L, null, true, true);
  }
  
  private boolean bW()
  {
    ((IExpandManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a("sp_extend_friend_prompt_safe_tip", 3);
    ExtendFriendSafeTipArkDialog localExtendFriendSafeTipArkDialog = this.bu;
    if (localExtendFriendSafeTipArkDialog != null) {
      localExtendFriendSafeTipArkDialog.dismiss();
    }
    return true;
  }
  
  private boolean bX()
  {
    ThreadManager.getUIHandler().post(new LimitChatPie.14(this));
    return true;
  }
  
  private void bY()
  {
    this.C.setText(ExpandFriendData.getNickName(this.d, this.ah.b));
    if (this.V != null) {
      this.V.g = Boolean.valueOf(false);
    }
    this.P = false;
    b(true);
    if (this.J != null) {
      this.J.setVisibility(8);
    }
  }
  
  private void bZ()
  {
    if (this.bB == 2)
    {
      if (this.bv.get(Integer.valueOf(1)) == null) {
        return;
      }
      HotProtectDialog localHotProtectDialog = (HotProtectDialog)this.bv.get(Integer.valueOf(1));
      if (localHotProtectDialog != null) {
        localHotProtectDialog.b(this.ah.e);
      }
    }
  }
  
  private void ca()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("to_uid", this.ah.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.bB);
    localHashMap.put("window_type", localStringBuilder.toString());
    localHashMap.put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.d.getCurrentAccountUin(), this.ah.b));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#chat_page#ad_video_window", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void cb()
  {
    Object localObject1;
    if (this.ah == null) {
      localObject1 = "";
    } else {
      localObject1 = this.ah.b;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSession_updateSubTitle toUin =");
      localStringBuilder.append((String)localObject1);
      QLog.i((String)localObject2, 2, localStringBuilder.toString());
    }
    Object localObject2 = new ArrayList();
    try
    {
      ((List)localObject2).add(Long.valueOf((String)localObject1));
      label83:
      if (!((List)localObject2).isEmpty())
      {
        localObject1 = (IExpandHandler)this.d.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        if (localObject1 != null) {
          ((IExpandHandler)localObject1).a((List)localObject2);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      break label83;
    }
  }
  
  private void cc()
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)q(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.b();
    }
  }
  
  private void cd()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.d.getCurrentAccountUin(), this.ah.b));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#voice_frequency", true, -1L, -1L, localHashMap, true, true);
  }
  
  private boolean ce()
  {
    if ((this.A != null) && (this.A.getVisibility() == 0) && (this.bw == 7))
    {
      ch();
      cf();
      return true;
    }
    return false;
  }
  
  private void cf()
  {
    if ((this.f != null) && (!this.f.isFinishing()))
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.f, 230).setMessage(this.f.getString(2131896387)).setPositiveButton(this.f.getString(2131892267), new LimitChatPie.25(this)).setNegativeButton(this.f.getString(2131887648), new LimitChatPie.24(this));
      localQQCustomDialog.setCancelable(false);
      a(localQQCustomDialog, 2);
      ReportController.b(this.d, "dc00898", "", "", "0X800ADC8", "0X800ADC8", 0, 0, "", "", "", "");
    }
  }
  
  private void cg()
  {
    boolean bool = ((ConfigHandler)this.d.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).o();
    ((IExpandLimitChatManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a(bool);
  }
  
  private void ch()
  {
    if ((this.A.getParent() instanceof RelativeLayout))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.A.getParent();
      ExtendFriendVoiceAnimView localExtendFriendVoiceAnimView = new ExtendFriendVoiceAnimView(this.e);
      int i = ViewUtils.dip2px(29.0F);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.addRule(13, -1);
      localRelativeLayout.addView(localExtendFriendVoiceAnimView, 0, localLayoutParams);
      localExtendFriendVoiceAnimView.setCircleParams(ci(), 800);
      localExtendFriendVoiceAnimView.a(500L);
    }
  }
  
  private int ci()
  {
    String str3 = ThemeUtil.getCurrentThemeId();
    boolean bool = "1103".equals(str3);
    String str2 = "#FFFFFFFF";
    String str1;
    if (bool)
    {
      str1 = "#FFA1A1A1";
    }
    else if ("2920".equals(str3))
    {
      str1 = "#FF848484";
    }
    else if ("2101".equals(str3))
    {
      str1 = "#FFDBB86B";
    }
    else if ("2105".equals(str3))
    {
      str1 = "#FF12B7F5";
    }
    else
    {
      str1 = str2;
      if (QQTheme.isThemeSimpleDayUI(str3)) {
        if (!"2921".equals(str3))
        {
          str1 = str2;
          if (!"2971".equals(str3)) {}
        }
        else
        {
          str1 = "#FF03081A";
        }
      }
    }
    try
    {
      int i = Color.parseColor(str1);
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  private boolean cj()
  {
    if (this.ah.a == 1044)
    {
      if (this.d != null)
      {
        IExpandLimitChatManager localIExpandLimitChatManager = (IExpandLimitChatManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (localIExpandLimitChatManager != null) {
          return localIExpandLimitChatManager.c(this.d);
        }
      }
    }
    else {
      QLog.d(this.c, 2, "UINTYPE NOT Y");
    }
    return false;
  }
  
  private void ck()
  {
    if (!this.f.isFinishing()) {
      QQToast.makeText(this.e, 1, this.e.getString(2131896890), 0).show();
    }
  }
  
  private void cl()
  {
    ((IExpandChatNetworkHelper)QRoute.api(IExpandChatNetworkHelper.class)).reportGreet(this.d, Long.parseLong(this.ah.b), new LimitChatPie.31(this));
  }
  
  private long cm()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  private void f(List<MessageRecord> paramList)
  {
    if ((!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).hasWatchedAdvertise(this.d, this.ah.b)) && (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).hasValidMessage(paramList)))
    {
      if (bQ()) {
        return;
      }
      ((IExpandChatNetworkHelper)QRoute.api(IExpandChatNetworkHelper.class)).requestAbleToGreet(this.d, Long.parseLong(this.ah.b), new LimitChatPie.9(this));
      return;
    }
    if ((((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).hasWatchedAdvertise(this.d, this.ah.b)) && (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).hasValidMessage(paramList))) {
      this.bA = true;
    }
  }
  
  private void g(String paramString)
  {
    if ((!aY()) || (TextUtils.isEmpty(paramString)) || (!TextUtils.equals(paramString, this.ah.b))) {
      QLog.w(this.c, 1, "handleAddFriend, error: activity is not resume or uin not cur match");
    }
    bJ();
  }
  
  private void h(String paramString)
  {
    MaskDialog localMaskDialog = new MaskDialog(this.f);
    localMaskDialog.setMessage(paramString).setNegativeButton(this.f.getString(2131890029), new LimitChatPie.26(this));
    a(localMaskDialog, 1);
  }
  
  private void i(Intent paramIntent)
  {
    this.bw = paramIntent.getIntExtra("key_limitchat_enter_type", 0);
    if ((this.bw == 0) && (this.bx > 0))
    {
      ExpandFriendData.setMatchSrc(this.d, this.ah.b, this.bx);
      switch (this.bx)
      {
      default: 
        return;
      case 303: 
        this.bw = 12;
        return;
      case 302: 
        this.bw = 10;
        return;
      }
      this.bw = 11;
    }
  }
  
  private void i(String paramString)
  {
    MaskDialog localMaskDialog = new MaskDialog(this.f);
    localMaskDialog.setMessage(paramString).setNegativeButton(this.f.getString(2131890029), new LimitChatPie.27(this));
    a(localMaskDialog, 1);
  }
  
  private void j(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null) {
      return;
    }
    boolean bool = paramIntent.getBoolean("profitable_flag", false);
    if (bool)
    {
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.15(this));
      w(1);
    }
    p(bool);
  }
  
  private void j(String paramString)
  {
    HotProtectDialog localHotProtectDialog = new HotProtectDialog(this.f);
    localHotProtectDialog.a(new LimitChatPie.28(this));
    localHotProtectDialog.a(this.ah.b);
    localHotProtectDialog.b(this.ah.e);
    localHotProtectDialog.c(paramString);
    a(localHotProtectDialog, 1);
  }
  
  private void k(String paramString)
  {
    MaskDialog localMaskDialog = new MaskDialog(this.f);
    localMaskDialog.setMessage(paramString).setNegativeButton(this.f.getString(2131890029), new LimitChatPie.29(this));
    a(localMaskDialog, 1);
  }
  
  private void p(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("to_uid", this.ah.b);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.bB);
    localHashMap.put("window_type", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    localHashMap.put("is_finish", localObject);
    localHashMap.put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.d.getCurrentAccountUin(), this.ah.b));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#ad_video_window_go", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void v(int paramInt)
  {
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.expand.aiosafe", this);
    ExtendFriendSafeTipArkDialog.a((ArkView)((ViewGroup)LayoutInflater.from(aX()).inflate(2131627414, bm())).findViewById(2131428764), new LimitChatPie.12(this), paramInt);
  }
  
  private void w(int paramInt)
  {
    if (this.bv.get(Integer.valueOf(paramInt)) != null)
    {
      QQCustomDialog localQQCustomDialog = (QQCustomDialog)this.bv.get(Integer.valueOf(paramInt));
      if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing()))
      {
        localQQCustomDialog.dismiss();
        this.bv.remove(Integer.valueOf(paramInt));
      }
    }
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
    localIntent.putExtra("ExtendFriendLimitChatFromeType", this.bs);
    localIntent.putExtra("subId", ExpandUserInfo.getReportSubId(bK()));
    this.f.startActivityForResult(localIntent, 2000);
  }
  
  public void C() {}
  
  public void K()
  {
    super.K();
    this.W.setPanelIconClickInterceptListener(null);
    ((INewFriendService)this.d.getRuntimeService(INewFriendService.class)).deleteObserver(this.bC);
    this.bC = null;
    this.d.removeObserver(this.bi);
    if (bG())
    {
      bT();
      long l1 = System.currentTimeMillis();
      long l2 = this.bl;
      ReportController.b(this.d, "dc00898", "", "", "0X800A692", "0X800A692", 0, 0, String.valueOf(l1 - l2), "", this.br, "");
    }
    bM();
    ExtendFriendSafeTipArkDialog localExtendFriendSafeTipArkDialog = this.bu;
    if (localExtendFriendSafeTipArkDialog != null) {
      localExtendFriendSafeTipArkDialog.d();
    }
  }
  
  public void M()
  {
    Intent localIntent = this.f.getIntent();
    this.f.setResult(-1, localIntent);
  }
  
  public void N()
  {
    super.N();
    ((IExpandHandler)this.d.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.ah.b, true);
    if (this.bu != null) {
      ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.expand.aiosafe", this);
    }
  }
  
  public void O()
  {
    super.O();
    if (!TextUtils.isEmpty(this.ah.b)) {
      ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).markEnterAio(this.d, this.ah.b);
    }
    if (this.bu != null) {
      ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.expand.aiosafe", null);
    }
  }
  
  public void P()
  {
    super.P();
    ((IAioVoicePlayerManager)QRoute.api(IAioVoicePlayerManager.class)).stopAll();
    bR();
    ExtendFriendSafeTipArkDialog localExtendFriendSafeTipArkDialog = this.bu;
    if (localExtendFriendSafeTipArkDialog != null) {
      localExtendFriendSafeTipArkDialog.c();
    }
  }
  
  public void S()
  {
    super.S();
    if (((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.ah.b)) {
      bJ();
    }
    cg();
    bS();
    this.bk = SystemClock.elapsedRealtime();
    ExtendFriendSafeTipArkDialog localExtendFriendSafeTipArkDialog = this.bu;
    if (localExtendFriendSafeTipArkDialog != null) {
      localExtendFriendSafeTipArkDialog.b();
    }
  }
  
  public boolean V()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onBackEvent begin");
    }
    if (bU()) {
      return true;
    }
    return super.V();
  }
  
  String a(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    Iterator localIterator = paramList1.iterator();
    paramList1 = "0";
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isSystemMessage(localChatMessage.msgtype))
      {
        paramList2.add(localChatMessage);
        if (!localChatMessage.isSelf()) {
          paramList1 = "1";
        }
      }
    }
    return paramList1;
  }
  
  void a() {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt != 2)
    {
      if (paramInt != 4) {
        return;
      }
      PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.ae.d(4);
      if (localPhotoListPanel != null) {
        localPhotoListPanel.setCustomOnClickListener(new LimitChatPie.SendImageListener(this));
      }
      ReportController.b(this.d, "dc00898", "", "", "0X80096AA", "0X80096AA", this.bs, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.d, "dc00898", "", "", "0X80096A9", "0X80096A9", this.bs, 0, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPanelChanged, old:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" new:");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 101)) {
      j(paramIntent);
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2)
  {
    ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).setLastMatchChatGrayTipsSection(this.d, this.ah.b, s(paramInt));
    this.bm = s(paramInt);
    ThreadManager.getSubThreadHandler().post(new LimitChatPie.5(this, paramString1, paramString2));
  }
  
  void a(Object paramObject)
  {
    if ((paramObject instanceof FriendSystemMessage))
    {
      paramObject = ((FriendSystemMessage)paramObject).a.getSystemMsg();
      if ((paramObject != null) && (paramObject.msg != null) && (paramObject.msg.sub_type != null))
      {
        if (paramObject.req_uin == null) {
          return;
        }
        if (paramObject.msg.sub_type.get() != 9) {
          return;
        }
        paramObject = String.valueOf(paramObject.req_uin.get());
        if ((!TextUtils.isEmpty(paramObject)) && (TextUtils.equals(paramObject, this.ah.b)))
        {
          if (((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).needAddFriendConversationNode(this.d, paramObject)) {
            ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).addFriendConversationNode(this.d, paramObject);
          }
        }
        else {
          QLog.w("LimitChatPie", 1, "addFriendConversationNode error, matchUin is null or not cur match");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.V != null) {
      this.V.g = Boolean.valueOf(false);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSubTitlonShowSubTitleTexteText statusText =");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (AioFriendTitleHelper)q(45);
    if ((localObject != null) && (((AioFriendTitleHelper)localObject).a(paramBoolean, paramString))) {
      return;
    }
    aX().runOnUiThread(new LimitChatPie.21(this, paramString, paramBoolean));
  }
  
  void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (TextUtils.equals(paramString, this.ah.b)))
    {
      this.as = true;
      a(262144, null, paramLong);
      if (!((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.ah.b))
      {
        this.bn += 1;
        this.bp += 1;
        b(bz(), bA(), bB());
      }
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).closeIceBreakingPanel(this.d, this.ah.b);
      if ((this.bA) && (!TextUtils.isEmpty(this.ah.b))) {
        cl();
      }
      return;
    }
    String str = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSendResult, error: isSuccess");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" or not cur match");
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).initGdtContext(this.e, new InitGdtContextParams());
    bY();
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.expandfriend.breakicetopic", this);
    ((INewFriendService)this.d.getRuntimeService(INewFriendService.class)).addObserver(this.bC);
    this.d.addObserver(this.bi);
    this.bl = System.currentTimeMillis();
    this.bx = this.f.getIntent().getIntExtra("key_limitchat_match_relation_source", -1);
    i(this.f.getIntent());
    this.by = this.f.getIntent().getIntExtra("key_limitchat_match_sex_type", 0);
    this.bz = this.f.getIntent().getIntExtra("key_limitchat_match_purpose", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enter limit_chat_pie from_page");
    localStringBuilder.append(this.bw);
    QLog.w("LimitChatPie", 2, localStringBuilder.toString());
    bN();
    bO();
    bF();
    bL();
    return paramBoolean;
  }
  
  public RecordParams.RecorderParam aU()
  {
    boolean bool = ((AudioPanelProvider)this.ae.f(2)).e();
    return RecordParams.b(this.d, bool);
  }
  
  public void ah()
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPreThemeChanged");
      localStringBuilder.append(this.aL);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void ai()
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPostThemeChanged");
      localStringBuilder.append(this.aL);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    bg();
  }
  
  protected void au()
  {
    super.au();
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "addBusinessObservers");
    }
    this.d.addObserver(this.bD);
    this.d.addObserver(this.bF);
    this.d.addObserver(this.bE);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.bF);
    this.d.removeObserver(this.bE);
    this.d.removeObserver(this.bD);
  }
  
  protected HelperProvider b()
  {
    return new LimitHelperProvider(this.f);
  }
  
  protected void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSubTitleText text =");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (InputStatusHelper)q(16);
    if (localObject != null) {
      ((InputStatusHelper)localObject).a(paramString);
    }
  }
  
  void b(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isSystemMessage(paramList.msgtype)) && (!TextUtils.isEmpty(paramList.frienduin)) && (TextUtils.equals(paramList.frienduin, this.ah.b)))
      {
        if (((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.ah.b))
        {
          QLog.w(this.c, 1, "handleMessageRecordAdded, error: cur match already was a friend");
          return;
        }
        this.bo += 1;
        this.bq += 1;
        b(bz(), bA(), bB());
        return;
      }
      QLog.w(this.c, 1, "handleMessageRecordAdded, error: message is system message or messageRecord'frienduin is empty or message not belong cur match");
      return;
    }
    QLog.w(this.c, 1, "handleMessageRecordAdded, error: list is null or list is empty");
  }
  
  String bA()
  {
    return ((IExpandManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).A();
  }
  
  String bB()
  {
    return ((IExpandManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).B();
  }
  
  int bC()
  {
    return this.bp + this.bq;
  }
  
  boolean bD()
  {
    int i = bE();
    return (i <= 0) || ((this.bp >= i) && (this.bq >= i));
  }
  
  int bE()
  {
    ExpandConfig localExpandConfig = ((IExpandManager)aX().app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).t();
    if (localExpandConfig == null)
    {
      QLog.w("LimitChatPie", 1, "canSendMediaMessage return true for null cfg");
      return 2;
    }
    return localExpandConfig.sendPicAndVoiceMessageLimitCount;
  }
  
  void bF()
  {
    ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).preLoadDataForAvatarProfileCard(this.d, Long.valueOf(Long.parseLong(this.ah.b)), this.bi);
    ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).preLoadDataForAvatarProfileCard(this.d, Long.valueOf(Long.parseLong(this.d.getCurrentUin())), this.bi);
  }
  
  boolean bG()
  {
    int i = this.bw;
    return (i == 3) || (i == 7);
  }
  
  public void bH()
  {
    ReportController.b(this.d, "dc00898", "", "", "0X800A693", "0X800A693", 0, 0, "", "", "", "");
    f("4");
  }
  
  public int bI()
  {
    return this.bs;
  }
  
  protected void bg()
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUI_titleBarForTheme");
      localStringBuilder.append(this.aL);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.ah != null)
    {
      if (this.e == null) {
        return;
      }
      super.bg();
      this.W.a(this.d, this.ah, this);
      this.W.a(this);
    }
  }
  
  int bz()
  {
    return ((IExpandManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).z();
  }
  
  protected AIOInput c()
  {
    return new AIOInputBuilder().a(this.i).a(new LimitMessageSender(this.i)).a();
  }
  
  void c(long paramLong)
  {
    Iterator localIterator = aa().iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if ((localChatMessage.msgtype == -4027) && (localChatMessage.shmsgseq == paramLong))
      {
        ChatFragment localChatFragment = this.f.getChatFragment();
        if (localChatFragment != null) {
          localChatFragment.k().a(localChatMessage);
        }
      }
    }
  }
  
  void c(List<MessageRecord> paramList)
  {
    if (!TextUtils.isEmpty(this.ah.b))
    {
      if (paramList == null) {
        return;
      }
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).hasMiniProfileCard(paramList);
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).preLoadDataForArkMiniProfileCard(this.d, Long.valueOf(Long.parseLong(this.ah.b)), this.bi);
    }
  }
  
  protected AIOContext d()
  {
    return new LimitContext();
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    this.bs = paramIntent.getIntExtra("key_limitchat_from_type", 0);
    if (QLog.isColorLevel())
    {
      paramIntent = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSession, mfromType :");
      localStringBuilder.append(this.bs);
      QLog.d(paramIntent, 2, localStringBuilder.toString());
    }
  }
  
  void d(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isSystemMessage(localMessageRecord.msgtype)) {
          if (MessageRecordInfo.b(localMessageRecord.issend)) {
            this.bp += 1;
          } else {
            this.bq += 1;
          }
        }
      }
    }
  }
  
  long e(@NonNull List<ChatMessage> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return -1L;
    }
    int j = i - 1;
    if (!((ChatMessage)paramList.get(j)).isSelf()) {
      return cm() - ((ChatMessage)paramList.get(j)).time;
    }
    i = j - 1;
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
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new Scroller()).a(new ListUI(this.i)).a(new LimitMsgLoader()).a(new UnreadTask(this.i)).a();
  }
  
  void e(View paramView)
  {
    VideoReport.addToDetectionWhitelist(this.f);
    VideoReport.setPageId(paramView, "chat_page");
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "0AND0Y11VZ3PFHQD");
    VideoReport.setPageParams(paramView, new PageParams(localHashMap));
    QLog.i("LimitChatPie", 1, "reportDaTongRegister");
  }
  
  boolean e(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramString.getLong("matchUin"));
      localObject = ((StringBuilder)localObject).toString();
      long l = paramString.getLong("msgSeq");
      if ((!TextUtils.isEmpty(this.ah.b)) && (((String)localObject).equals(this.ah.b)))
      {
        f("6");
        c(l);
        return true;
      }
    }
    catch (Exception paramString)
    {
      Object localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSendIcebreakerTopicMessage");
      localStringBuilder.append(paramString.toString());
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    return false;
  }
  
  protected TipsController f()
  {
    return new LimitTipsController(this.i);
  }
  
  protected void f(Intent paramIntent)
  {
    this.Q = true;
    this.s.setText("");
  }
  
  public void f(String paramString)
  {
    Object localObject2 = aa();
    Object localObject1 = new ArrayList();
    localObject2 = a((List)localObject2, (List)localObject1);
    long l = e((List)localObject1);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("frompage", String.valueOf(this.bw));
    ((HashMap)localObject1).put("message_type", paramString);
    ((HashMap)localObject1).put("to_uid", this.ah.b);
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(bK());
    ((HashMap)localObject1).put("dating_purpose", paramString.toString());
    ((HashMap)localObject1).put("TF", localObject2);
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(l);
    ((HashMap)localObject1).put("duration", paramString.toString());
    if (this.bt) {
      paramString = "1";
    } else {
      paramString = "2";
    }
    ((HashMap)localObject1).put("ext_int1", paramString);
    ((HashMap)localObject1).put("source_id", String.valueOf(bK()));
    ((HashMap)localObject1).put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.d.getCurrentAccountUin(), this.ah.b));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#message_success", true, -1L, -1L, (Map)localObject1, true, true);
  }
  
  protected void h()
  {
    this.c = "LimitChatPie";
  }
  
  protected void k(int paramInt)
  {
    super.k(paramInt);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)q(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.d(9);
    }
  }
  
  public void k(boolean paramBoolean) {}
  
  protected void l()
  {
    super.l();
    this.U.setChoiceMode(0);
    this.W.setPanelIconClickInterceptListener(new LimitChatPie.6(this));
  }
  
  public void l(int paramInt)
  {
    super.l(paramInt);
    cb();
  }
  
  public boolean notify(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notify, appName = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", eventName : ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", params : ");
    localStringBuilder.append(paramString3);
    QLog.i("LimitChatPie", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if ("com.tencent.mobileqq.expand.aiosafe".equals(paramString1))
      {
        if ("closeView".equals(paramString2)) {
          return bW();
        }
        if ("viewDidLoad".equals(paramString2)) {
          return bX();
        }
      }
      else if (("com.tencent.mobileqq.expandfriend.breakicetopic".equals(paramString1)) && ("onSendMessage".equals(paramString2)))
      {
        e(paramString3);
      }
    }
    return false;
  }
  
  protected boolean p()
  {
    return (this.aL) || (super.p());
  }
  
  int s(int paramInt)
  {
    return bC() / paramInt + 1;
  }
  
  boolean t(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      if (bC() <= 0) {
        return false;
      }
      if (bC() % paramInt == 0) {
        return true;
      }
      bool1 = bool2;
      if (s(paramInt) - this.bm > 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  boolean u(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 4) || (paramInt == 5);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    b(paramObject);
  }
  
  protected void z()
  {
    if (Boolean.valueOf(cj()).booleanValue())
    {
      this.A.setVisibility(0);
      this.A.setOnClickListener(new LimitChatPie.23(this));
      return;
    }
    this.A.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie
 * JD-Core Version:    0.7.0.1
 */