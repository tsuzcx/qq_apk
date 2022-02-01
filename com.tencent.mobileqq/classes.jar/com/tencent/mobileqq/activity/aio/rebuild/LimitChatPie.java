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
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
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
import com.tencent.mobileqq.profilecard.data.AllInOne;
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
import java.lang.ref.WeakReference;
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
  private boolean D = false;
  private boolean E = false;
  private long jdField_a_of_type_Long = -1L;
  protected BroadcastReceiver a;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new LimitChatPie.4(this);
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new LimitChatPie.2(this);
  private final AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new LimitChatPie.3(this);
  ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new LimitChatPie.16(this);
  private ExtendFriendSafeTipArkDialog jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog;
  private final Map<Integer, Object> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Observer jdField_a_of_type_JavaUtilObserver = new LimitChatPie.1(this);
  private long b;
  private String d;
  private int g;
  private int h = 0;
  private int i = 0;
  private int j;
  private int k;
  private int l = 0;
  private int m;
  private int n;
  private int o;
  private int p;
  
  public LimitChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_b_of_type_Long = -1L;
    this.jdField_d_of_type_JavaLangString = "0";
    this.jdField_m_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new LimitChatPie.33(this);
    e(paramViewGroup);
    a();
  }
  
  private boolean A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1044)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        IExpandLimitChatManager localIExpandLimitChatManager = (IExpandLimitChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        if (localIExpandLimitChatManager != null) {
          return localIExpandLimitChatManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
    else {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "UINTYPE NOT Y");
    }
    return false;
  }
  
  private void a(int paramInt, String paramString)
  {
    b(paramInt, paramString);
    this.p = paramInt;
    this.E = true;
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 2)) {
      aA();
    }
  }
  
  private void a(ArkView paramArkView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog = new ExtendFriendSafeTipArkDialog(a(), 2131755355);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog.a(paramArkView);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog.a();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog.setOnDismissListener(new LimitChatPie.13(this));
    }
    paramArkView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog;
    if ((paramArkView != null) && (!paramArkView.isShowing())) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog.show();
        ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a("sp_extend_friend_prompt_safe_tip", 1);
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
    int i1 = paramIExpandManager.a("sp_extend_friend_prompt_safe_tip");
    boolean bool1;
    if (i1 == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i2 = k();
    QLog.w("LimitChatPie", 1, String.format("openSaveEmptyAIONodeDialog : %b, popupDialogState : %d, notShowSafeTip : %b, matchSrc : %d", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i1), Boolean.valueOf(bool1), Integer.valueOf(i2) }));
    ThreadManager.getUIHandler().post(new LimitChatPie.8(this, bool2, bool1, i2));
  }
  
  private void a(@NonNull ExpandResponse paramExpandResponse)
  {
    Object localObject = new AdvertisingVideo.AbleToGreetRsp();
    try
    {
      ((AdvertisingVideo.AbleToGreetRsp)localObject).mergeFrom(paramExpandResponse.a());
      paramExpandResponse = new StringBuilder();
      paramExpandResponse.append(this.jdField_b_of_type_JavaLangString);
      paramExpandResponse.append("expand.chat.");
      paramExpandResponse = paramExpandResponse.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestSendMessage succ. code = ");
      localStringBuilder.append(((AdvertisingVideo.AbleToGreetRsp)localObject).code.get());
      QLog.d(paramExpandResponse, 4, localStringBuilder.toString());
      int i1 = ((AdvertisingVideo.AbleToGreetRsp)localObject).code.get();
      paramExpandResponse = ((AdvertisingVideo.AbleToGreetRsp)localObject).tips_wording.get();
      b(i1, paramExpandResponse);
      this.p = i1;
      this.E = ((AdvertisingVideo.AbleToGreetRsp)localObject).need_report.get();
      ((IExpandSPUtils)QRoute.api(IExpandSPUtils.class)).setGreetLimit(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), i1, paramExpandResponse);
      if ((i1 == 1) || (i1 == 3) || (i1 == 2)) {
        aA();
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramExpandResponse)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("expand.chat.");
      QLog.w(((StringBuilder)localObject).toString(), 1, paramExpandResponse.toString());
    }
  }
  
  private void a(QQCustomDialog paramQQCustomDialog, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramQQCustomDialog);
      paramQQCustomDialog.show();
      return;
    }
    catch (Exception paramQQCustomDialog)
    {
      String str = this.jdField_b_of_type_JavaLangString;
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
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      paramSendMessageHandler = this.jdField_b_of_type_JavaLangString;
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
      e(196608);
      return;
    }
    paramSendMessageHandler = this.jdField_b_of_type_JavaLangString;
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
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, String.format("onGetUnLimitFriendInfo() success=%s uinType=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
    if ((paramBoolean) && (paramMatchInfo != null)) {
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.18(this, paramInt2, paramMatchInfo));
    }
  }
  
  private void a(boolean paramBoolean, StrangerInfo paramStrangerInfo, int paramInt)
  {
    if ((paramBoolean) && (paramStrangerInfo != null))
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStrangerInfo, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_g_of_type_AndroidWidgetImageView, this.z);
      if ((!TextUtils.isEmpty(paramStrangerInfo.mNickName)) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()))
      {
        ThreadManager.getSubThreadHandler().post(new LimitChatPie.17(this, paramStrangerInfo));
        this.e.setText(paramStrangerInfo.mNickName);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramStrangerInfo.mNickName;
        az();
      }
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).handlePreLoadDataForArkMiniProfileCard(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false, paramObject);
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.19(this));
      return;
    }
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onPreLoadDataForArkMiniProfileCard network error, data is null");
  }
  
  private void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(paramString)) && (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      e(65536);
      return;
    }
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "handleUpdateApolloHead, error: app is null or uin error");
  }
  
  private void a(boolean paramBoolean, List<Long> paramList1, int paramInt, List<Long> paramList2)
  {
    if ((paramBoolean) && (paramList1 != null) && (!paramList1.isEmpty()))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramList2 = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleExtendFriendOnlineState onlineUinList =");
        localStringBuilder.append(paramList1);
        QLog.i(paramList2, 2, localStringBuilder.toString());
      }
      if (((Long)paramList1.get(0)).toString().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.D = true;
        a().runOnUiThread(new LimitChatPie.22(this));
        return;
      }
      this.D = false;
    }
  }
  
  private void aA()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("to_uid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.p);
    localHashMap.put("window_type", localStringBuilder.toString());
    localHashMap.put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#chat_page#ad_video_window", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void aB()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      localObject1 = "";
    } else {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
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
        localObject1 = (IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
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
  
  private void aC()
  {
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.b();
    }
  }
  
  private void aD()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#voice_frequency", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void aE()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698453)).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694583), new LimitChatPie.25(this)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690728), new LimitChatPie.24(this));
      localQQCustomDialog.setCancelable(false);
      a(localQQCustomDialog, 2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ADC8", "0X800ADC8", 0, 0, "", "", "", "");
    }
  }
  
  private void aF()
  {
    aG();
    GdtAdLoader.Session localSession = new GdtAdLoader.Session();
    localSession.a = ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).createRequest(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()), "3091857866779205", 1, 1);
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).loadAd(localSession, new WeakReference(new LimitChatPie.31(this)), new WeakReference(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void aG()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) && (!AppNetConnInfo.isNetSupport())) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131689828), 0).a();
    }
  }
  
  private void aH()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("to_uid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.p);
    localHashMap.put("window_type", localStringBuilder.toString());
    localHashMap.put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#ad_video_window_no", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void aI()
  {
    boolean bool = ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).b();
    ((IExpandLimitChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a(bool);
  }
  
  private void aJ()
  {
    if ((this.jdField_d_of_type_AndroidWidgetImageView.getParent() instanceof RelativeLayout))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_d_of_type_AndroidWidgetImageView.getParent();
      ExtendFriendVoiceAnimView localExtendFriendVoiceAnimView = new ExtendFriendVoiceAnimView(this.jdField_a_of_type_AndroidContentContext);
      int i1 = ViewUtils.a(29.0F);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
      localLayoutParams.addRule(13, -1);
      localRelativeLayout.addView(localExtendFriendVoiceAnimView, 0, localLayoutParams);
      localExtendFriendVoiceAnimView.setCircleParams(l(), 800);
      localExtendFriendVoiceAnimView.a(500L);
    }
  }
  
  private void aK()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131698916), 0).a();
    }
  }
  
  private void aL()
  {
    ((IExpandChatNetworkHelper)QRoute.api(IExpandChatNetworkHelper.class)).reportGreet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), new LimitChatPie.32(this));
  }
  
  private void ap()
  {
    Intent localIntent = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", 0);
    a().startActivity(localIntent);
  }
  
  private void aq()
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerReceiver exception: ");
      localStringBuilder.append(localException);
      QLog.e("LimitChatPie", 1, localStringBuilder.toString());
    }
  }
  
  private void ar()
  {
    try
    {
      a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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
  
  private void as()
  {
    ThreadManager.getSubThreadHandler().post(new LimitChatPie.7(this));
  }
  
  private void at()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_a_of_type_Long;
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1 - l2);
    localStringBuilder.append("");
    localHashMap.put("duration", localStringBuilder.toString());
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("exit#chat_page#view", true, localHashMap);
  }
  
  private void au()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(this.jdField_m_of_type_Int));
    localHashMap.put("to_uid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    String str;
    if (this.D) {
      str = "1";
    } else {
      str = "2";
    }
    localHashMap.put("ext_int1", str);
    localHashMap.put("source_id", String.valueOf(this.o));
    localHashMap.put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#chat_page#view", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void av()
  {
    if ((this.h > 0) && (this.i > 0))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A695", "0X800A695", 0, 0, "", "", "", "");
      return;
    }
    if ((this.h > 0) || (this.i > 0)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A694", "0X800A694", 0, 0, "", "", "", "");
    }
  }
  
  private void aw()
  {
    IExpandManager localIExpandManager = (IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    BaseActivity localBaseActivity = a();
    DialogUtil.a(localBaseActivity, localBaseActivity.getString(2131694336), 2131719065, 0, null, new LimitChatPie.11(this, localIExpandManager)).show();
    localIExpandManager.a("sp_extend_friend_prompt_aio_save_empty_node", 1);
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#chat_page#aio_exit_windows", true, -1L, -1L, null, true, true);
  }
  
  private void ax()
  {
    this.e.setText(ExpandFriendData.getNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
    }
    this.jdField_b_of_type_Boolean = false;
    a(true);
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void ay()
  {
    AllInOne localAllInOne = new AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
    ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, localAllInOne, this.l, 2);
  }
  
  private void az()
  {
    if (this.p == 2)
    {
      if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1)) == null) {
        return;
      }
      HotProtectDialog localHotProtectDialog = (HotProtectDialog)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
      if (localHotProtectDialog != null) {
        localHotProtectDialog.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  private long b()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  private void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
        return;
      }
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          g(paramString);
          return;
        }
        h(paramString);
        return;
      }
      f(paramString);
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt > 0) && (c(paramInt)) && (!TextUtils.isEmpty(paramString1)))
    {
      a(paramInt, paramString1, paramString2);
      return;
    }
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "showMakeFriendGrayTips, error: messageNum is <= 0 or isInsertMakeFriendGrayTips is false or tipsString is null");
  }
  
  private void b(Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      InputStatusHelper localInputStatusHelper = (InputStatusHelper)a(16);
      if (localInputStatusHelper != null) {
        if (paramObject.isSend())
        {
          localInputStatusHelper.d();
          if ((paramObject instanceof IMessageForApollo)) {
            d("7");
          }
        }
        else if (paramObject.time > localInputStatusHelper.jdField_b_of_type_Long)
        {
          aC();
        }
      }
    }
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).handlePreLoadDataForIcebreakerTopic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramObject);
      return;
    }
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onPreLoadDataForIcebreakerTopic network error, data is null");
  }
  
  private void b(boolean paramBoolean, String paramString)
  {
    e(65536);
  }
  
  private void e(String paramString)
  {
    if ((!l()) || (TextUtils.isEmpty(paramString)) || (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "handleAddFriend, error: activity is not resume or uin not cur match");
    }
    ap();
  }
  
  private void e(List<MessageRecord> paramList)
  {
    if ((!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).hasWatchedAdvertise(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).hasValidMessage(paramList)))
    {
      if (v()) {
        return;
      }
      ((IExpandChatNetworkHelper)QRoute.api(IExpandChatNetworkHelper.class)).requestAbleToGreet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), new LimitChatPie.9(this));
      return;
    }
    if ((((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).hasWatchedAdvertise(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).hasValidMessage(paramList))) {
      this.E = true;
    }
  }
  
  private void f(String paramString)
  {
    MaskDialog localMaskDialog = new MaskDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localMaskDialog.setMessage(paramString).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698769), new LimitChatPie.27(this)).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698768), new LimitChatPie.26(this));
    a(localMaskDialog, 1);
  }
  
  private void g(String paramString)
  {
    MaskDialog localMaskDialog = new MaskDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localMaskDialog.setMessage(paramString).setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692918), new LimitChatPie.28(this));
    a(localMaskDialog, 1);
  }
  
  private void h(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null) {
      return;
    }
    boolean bool = paramIntent.getBoolean("profitable_flag", false);
    if (bool)
    {
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.15(this));
      m(1);
    }
    m(bool);
  }
  
  private void h(String paramString)
  {
    HotProtectDialog localHotProtectDialog = new HotProtectDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localHotProtectDialog.a(new LimitChatPie.29(this));
    localHotProtectDialog.b(new LimitChatPie.30(this));
    localHotProtectDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localHotProtectDialog.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localHotProtectDialog.c(paramString);
    a(localHotProtectDialog, 1);
  }
  
  private int k()
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    int i1 = 0;
    if (localBaseActivity != null) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("key_limitchat_match_purpose", 0);
    }
    return i1;
  }
  
  private int l()
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
      if (QQTheme.d(str3)) {
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
      int i1 = Color.parseColor(str1);
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  private void l(int paramInt)
  {
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.expand.aiosafe", this);
    ExtendFriendSafeTipArkDialog.a((ArkView)((ViewGroup)LayoutInflater.from(a()).inflate(2131561071, a())).findViewById(2131362965), new LimitChatPie.12(this), paramInt);
  }
  
  private void m(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null)
    {
      QQCustomDialog localQQCustomDialog = (QQCustomDialog)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing()))
      {
        localQQCustomDialog.dismiss();
        this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  private void m(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("to_uid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.p);
    localHashMap.put("window_type", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    localHashMap.put("is_finish", localObject);
    localHashMap.put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#ad_video_window_go", true, -1L, -1L, localHashMap, true, true);
  }
  
  private boolean v()
  {
    int i1 = ((IExpandSPUtils)QRoute.api(IExpandSPUtils.class)).getGreetLimitCode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    String str = ((IExpandSPUtils)QRoute.api(IExpandSPUtils.class)).getGreetLimitString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    long l1 = ((IExpandSPUtils)QRoute.api(IExpandSPUtils.class)).getGreetLimitTime(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if ((!AppNetConnInfo.isNetSupport()) && (i1 != 0) && (DateUtils.a.a(l1)))
    {
      ThreadManager.getUIHandler().post(new LimitChatPie.10(this, i1, str));
      return true;
    }
    return false;
  }
  
  private boolean w()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    boolean bool2 = true;
    boolean bool1;
    if (i1 != 0)
    {
      bool1 = bool2;
      if (!((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).d())
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkConsumeBackEvent, comsumed:");
      localStringBuilder.append(bool1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  private boolean x()
  {
    ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a("sp_extend_friend_prompt_safe_tip", 3);
    ExtendFriendSafeTipArkDialog localExtendFriendSafeTipArkDialog = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog;
    if (localExtendFriendSafeTipArkDialog != null) {
      localExtendFriendSafeTipArkDialog.dismiss();
    }
    return true;
  }
  
  private boolean y()
  {
    ThreadManager.getUIHandler().post(new LimitChatPie.14(this));
    return true;
  }
  
  private boolean z()
  {
    if ((this.jdField_d_of_type_AndroidWidgetImageView != null) && (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_m_of_type_Int == 7))
    {
      aJ();
      aE();
      return true;
    }
    return false;
  }
  
  public void E()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPreThemeChanged");
      localStringBuilder.append(this.x);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void F()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPostThemeChanged");
      localStringBuilder.append(this.x);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    aj();
  }
  
  protected void O()
  {
    super.O();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "addBusinessObservers");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  int a(int paramInt)
  {
    return h() / paramInt + 1;
  }
  
  long a(@NonNull List<ChatMessage> paramList)
  {
    int i1 = paramList.size();
    if (i1 <= 0) {
      return -1L;
    }
    int i2 = i1 - 1;
    if (!((ChatMessage)paramList.get(i2)).isSelf()) {
      return b() - ((ChatMessage)paramList.get(i2)).time;
    }
    i1 = i2 - 1;
    while (i2 > 0)
    {
      if ((((ChatMessage)paramList.get(i2)).isSelf()) && (!((ChatMessage)paramList.get(i1)).isSelf())) {
        return ((ChatMessage)paramList.get(i2)).time - ((ChatMessage)paramList.get(i1)).time;
      }
      i2 -= 1;
      i1 -= 1;
    }
    return -1L;
  }
  
  protected AIOContext a()
  {
    return new LimitContext();
  }
  
  protected AIOInput a()
  {
    return new AIOInputBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new LimitMessageSender(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new LimitMsgLoader()).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected TipsController a()
  {
    return new LimitTipsController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
  }
  
  protected HelperProvider a()
  {
    return new LimitHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public RecordParams.RecorderParam a()
  {
    boolean bool = ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).b();
    return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
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
      PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(4);
      if (localPhotoListPanel != null) {
        localPhotoListPanel.setCustomOnClickListener(new LimitChatPie.SendImageListener(this));
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AA", "0X80096AA", this.l, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A9", "0X80096A9", this.l, 0, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
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
      h(paramIntent);
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2)
  {
    ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).setLastMatchChatGrayTipsSection(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, a(paramInt));
    this.jdField_g_of_type_Int = a(paramInt);
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
        if ((!TextUtils.isEmpty(paramObject)) && (TextUtils.equals(paramObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          if (((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).needAddFriendConversationNode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject)) {
            ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).addFriendConversationNode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
          }
        }
        else {
          QLog.w("LimitChatPie", 1, "addFriendConversationNode error, matchUin is null or not cur match");
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSubTitleText text =");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (InputStatusHelper)a(16);
    if (localObject != null) {
      ((InputStatusHelper)localObject).a(paramString);
    }
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSubTitlonShowSubTitleTexteText statusText =");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = (AioFriendTitleHelper)a(45);
    if ((localObject != null) && (((AioFriendTitleHelper)localObject).a(paramBoolean, paramString))) {
      return;
    }
    a().runOnUiThread(new LimitChatPie.21(this, paramString, paramBoolean));
  }
  
  void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_m_of_type_Boolean = true;
      a(262144, null, paramLong);
      if (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.h += 1;
        this.j += 1;
        b(g(), e(), f());
      }
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).closeIceBreakingPanel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((this.E) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        aL();
      }
      return;
    }
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSendResult, error: isSuccess");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" or not cur match");
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  protected boolean a()
  {
    boolean bool2 = this.x;
    boolean bool1 = false;
    if ((bool2) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramString.getLong("matchUin"));
      localObject = ((StringBuilder)localObject).toString();
      long l1 = paramString.getLong("msgSeq");
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        d("6");
        c(l1);
        return true;
      }
    }
    catch (Exception paramString)
    {
      Object localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSendIcebreakerTopicMessage");
      localStringBuilder.append(paramString.toString());
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
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
          return x();
        }
        if ("viewDidLoad".equals(paramString2)) {
          return y();
        }
      }
      else if (("com.tencent.mobileqq.expandfriend.breakicetopic".equals(paramString1)) && ("onSendMessage".equals(paramString2)))
      {
        a(paramString3);
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).initGdtContext(this.jdField_a_of_type_AndroidContentContext, new InitGdtContextParams());
    ax();
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.expandfriend.breakicetopic", this);
    ((INewFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class)).addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_m_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("key_limitchat_enter_type", 0);
    this.n = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("key_limitchat_match_sex_type", 0);
    this.o = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("key_limitchat_match_purpose", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enter limit_chat_pie from_page");
    localStringBuilder.append(this.jdField_m_of_type_Int);
    QLog.w("LimitChatPie", 2, localStringBuilder.toString());
    as();
    aq();
    return paramBoolean;
  }
  
  protected void aj()
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUI_titleBarForTheme");
      localStringBuilder.append(this.x);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      super.aj();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this);
    }
  }
  
  public void ao()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A693", "0X800A693", 0, 0, "", "", "", "");
    d("4");
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.e.setOnClickListener(new LimitChatPie.20(this));
  }
  
  void b(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isSystemMessage(paramList.msgtype)) && (!TextUtils.isEmpty(paramList.frienduin)) && (TextUtils.equals(paramList.frienduin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          QLog.w(this.jdField_b_of_type_JavaLangString, 1, "handleMessageRecordAdded, error: cur match already was a friend");
          return;
        }
        this.i += 1;
        this.k += 1;
        b(g(), e(), f());
        return;
      }
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "handleMessageRecordAdded, error: message is system message or messageRecord'frienduin is empty or message not belong cur match");
      return;
    }
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "handleMessageRecordAdded, error: list is null or list is empty");
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "LimitChatPie";
  }
  
  void c(long paramLong)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if ((localChatMessage.msgtype == -4027) && (localChatMessage.shmsgseq == paramLong))
      {
        ChatFragment localChatFragment = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getChatFragment();
        if (localChatFragment != null) {
          localChatFragment.a().a(localChatMessage);
        }
      }
    }
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    this.l = paramIntent.getIntExtra("key_limitchat_from_type", 0);
    if (QLog.isColorLevel())
    {
      paramIntent = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSession, mfromType :");
      localStringBuilder.append(this.l);
      QLog.d(paramIntent, 2, localStringBuilder.toString());
    }
  }
  
  void c(List<MessageRecord> paramList)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (paramList == null) {
        return;
      }
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).hasMiniProfileCard(paramList);
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).preLoadDataForArkMiniProfileCard(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    }
  }
  
  boolean c(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      if (h() <= 0) {
        return false;
      }
      if (h() % paramInt == 0) {
        return true;
      }
      bool1 = bool2;
      if (a(paramInt) - this.jdField_g_of_type_Int > 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d(String paramString)
  {
    Object localObject2 = a();
    Object localObject1 = new ArrayList();
    localObject2 = a((List)localObject2, (List)localObject1);
    long l1 = a((List)localObject1);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("frompage", String.valueOf(this.jdField_m_of_type_Int));
    ((HashMap)localObject1).put("message_type", paramString);
    ((HashMap)localObject1).put("to_uid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(this.o);
    ((HashMap)localObject1).put("dating_purpose", paramString.toString());
    ((HashMap)localObject1).put("TF", localObject2);
    paramString = new StringBuilder();
    paramString.append("");
    paramString.append(l1);
    ((HashMap)localObject1).put("duration", paramString.toString());
    if (this.D) {
      paramString = "1";
    } else {
      paramString = "2";
    }
    ((HashMap)localObject1).put("ext_int1", paramString);
    ((HashMap)localObject1).put("source_id", String.valueOf(this.o));
    ((HashMap)localObject1).put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_page#message_success", true, -1L, -1L, (Map)localObject1, true, true);
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
          if (MessageRecordInfo.a(localMessageRecord.issend)) {
            this.j += 1;
          } else {
            this.k += 1;
          }
        }
      }
    }
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onBackEvent begin");
    }
    if (w()) {
      return true;
    }
    return super.d();
  }
  
  boolean d(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 4) || (paramInt == 5);
  }
  
  String e()
  {
    return ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f();
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChoiceMode(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconClickInterceptListener(new LimitChatPie.6(this));
  }
  
  protected void e(Intent paramIntent)
  {
    this.c = true;
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  void e(View paramView)
  {
    VideoReport.addToDetectionWhitelist(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    VideoReport.setPageId(paramView, "chat_page");
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "0AND0Y11VZ3PFHQD");
    VideoReport.setPageParams(paramView, new PageParams(localHashMap));
    QLog.i("LimitChatPie", 1, "reportDaTongRegister");
  }
  
  String f()
  {
    return ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).g();
  }
  
  protected void f(int paramInt)
  {
    super.f(paramInt);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)a(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.c(9);
    }
  }
  
  int g()
  {
    return ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).d();
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
    aB();
  }
  
  int h()
  {
    return this.j + this.k;
  }
  
  public void h(boolean paramBoolean) {}
  
  int i()
  {
    ExpandConfig localExpandConfig = ((IExpandManager)a().app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    if (localExpandConfig == null)
    {
      QLog.w("LimitChatPie", 1, "canSendMediaMessage return true for null cfg");
      return 2;
    }
    return localExpandConfig.sendPicAndVoiceMessageLimitCount;
  }
  
  public int j()
  {
    return this.l;
  }
  
  protected void j()
  {
    if (Boolean.valueOf(A()).booleanValue())
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new LimitChatPie.23(this));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
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
    localIntent.putExtra("ExtendFriendLimitChatFromeType", this.l);
    localIntent.putExtra("subId", ExpandUserInfo.fromTypeToSubID(3));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void l() {}
  
  public void p()
  {
    super.p();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconClickInterceptListener(null);
    ((INewFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class)).deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_JavaUtilObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    if (u())
    {
      av();
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_b_of_type_Long;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A692", "0X800A692", 0, 0, String.valueOf(l1 - l2), "", this.jdField_d_of_type_JavaLangString, "");
    }
    ar();
    ExtendFriendSafeTipArkDialog localExtendFriendSafeTipArkDialog = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog;
    if (localExtendFriendSafeTipArkDialog != null) {
      localExtendFriendSafeTipArkDialog.d();
    }
  }
  
  public void r()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, localIntent);
  }
  
  public void t()
  {
    super.t();
    ((IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog != null) {
      ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.expand.aiosafe", this);
    }
  }
  
  boolean t()
  {
    int i1 = i();
    return (i1 <= 0) || ((this.j >= i1) && (this.k >= i1));
  }
  
  public void u()
  {
    super.u();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).markEnterAio(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog != null) {
      ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.mobileqq.expand.aiosafe", null);
    }
  }
  
  boolean u()
  {
    int i1 = this.jdField_m_of_type_Int;
    return (i1 == 3) || (i1 == 7);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    b(paramObject);
  }
  
  public void v()
  {
    super.v();
    ((IAioVoicePlayerManager)QRoute.api(IAioVoicePlayerManager.class)).stopAll();
    at();
    ExtendFriendSafeTipArkDialog localExtendFriendSafeTipArkDialog = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog;
    if (localExtendFriendSafeTipArkDialog != null) {
      localExtendFriendSafeTipArkDialog.c();
    }
  }
  
  public void y()
  {
    super.y();
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ap();
    }
    aI();
    au();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    ExtendFriendSafeTipArkDialog localExtendFriendSafeTipArkDialog = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendSafeTipArkDialog;
    if (localExtendFriendSafeTipArkDialog != null) {
      localExtendFriendSafeTipArkDialog.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie
 * JD-Core Version:    0.7.0.1
 */