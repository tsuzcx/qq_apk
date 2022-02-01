package com.tencent.mobileqq.activity.aio.core;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo_tips;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.DiscussListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.DiscussHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class DiscussChatPie
  extends BaseChatPie
{
  protected MessageObserver a;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new DiscussChatPie.3(this);
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new DiscussChatPie.4(this);
  public ActionSheet a;
  private Dialog b;
  private TextView h;
  
  public DiscussChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new DiscussChatPie.10(this);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    Object localObject;
    if ((paramString1 != null) && (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateSendMsgError uin ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" type ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" uniseq ");
        localStringBuilder.append(paramLong);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      a(paramString1, paramInt1, paramLong);
      if (paramInt1 == 3000) {
        switch (paramInt2)
        {
        default: 
          if (paramInt2 > 100) {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString2, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          }
          break;
        case 104: 
          if (Looper.myLooper() != Looper.getMainLooper()) {
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new DiscussChatPie.8(this, paramString1));
          } else {
            e(paramString1);
          }
          break;
        case 103: 
          DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, HardCodeUtil.a(2131703496), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691794), new DiscussChatPie.7(this, paramString1), null).show();
          break;
        case 102: 
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131718738, 1).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
          break;
        case 101: 
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131718736, 1).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        }
      }
      e(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = this.jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateSendMsgError exception uin ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" type ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" uniseq ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d(paramString2, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(String paramString, int paramInt, long paramLong)
  {
    if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 0))
    {
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong);
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)localMessageRecord).structingMsg.mMsgAction))) {
        MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt, paramLong, false);
      }
    }
  }
  
  private boolean a(boolean paramBoolean, List<MessageRecord> paramList)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMsgRevokeNotice:");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (!paramBoolean) {
      return true;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = (MessageRecord)paramList.get(0);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b();
        if (i != -1)
        {
          paramList = (TroopAioNavigateBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("&");
          localStringBuilder.append(3000);
          long l = paramList.a(localStringBuilder.toString());
          if (((MessageRecord)localObject).uniseq == l)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject).append("&");
            ((StringBuilder)localObject).append(3000);
            paramList.a(((StringBuilder)localObject).toString(), i);
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(i);
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
          }
          if (QLog.isColorLevel())
          {
            paramList = new StringBuilder("onMsgRevokeNotice==>");
            paramList.append("navigateType:");
            paramList.append(i);
            paramList.append("|navigaeSeq:");
            paramList.append(l);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
            ((StringBuilder)localObject).append(".troop.special_msg");
            QLog.d(((StringBuilder)localObject).toString(), 2, paramList.toString());
          }
        }
      }
    }
    return false;
  }
  
  private void ao()
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    DiscussionInfo localDiscussionInfo = localDiscussionManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localDiscussionInfo.discussionName;
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localDiscussionInfo.uin, this.e);
    }
    if (localDiscussionManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      ap();
    }
  }
  
  private void ap()
  {
    Object localObject1 = this.jdField_b_of_type_AndroidAppDialog;
    if ((localObject1 != null) && (((Dialog)localObject1).isShowing())) {
      return;
    }
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    Object localObject2;
    if (!localDiscussionManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DiscussionManager's discToTroopCache doesn't contain discussionUIN :");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    localObject1 = (String[])localDiscussionManager.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject1 != null) && (localObject1.length >= 2))
    {
      String str1 = localObject1[0];
      String str2 = localObject1[1];
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
      {
        localObject1 = null;
        try
        {
          localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130842553);
          localObject1 = localObject2;
          localObject2 = ImageUtil.b((Bitmap)localObject2, 10.0F, 140, 140);
          localObject1 = localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, QLog.getStackTraceString(localOutOfMemoryError));
          }
        }
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2));
        localStringBuilder.append(HardCodeUtil.a(2131703499));
        str2 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131703498));
        localStringBuilder.append(str1);
        this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(localContext, (Bitmap)localObject1, str2, localStringBuilder.toString(), this.jdField_a_of_type_AndroidContentContext.getString(2131719065), null, new DiscussChatPie.2(this, str1), null);
        if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
          this.jdField_b_of_type_AndroidAppDialog.show();
        }
        localDiscussionManager.a.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void aq()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, DiscussionInfoCardActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
  }
  
  private void d(String paramString)
  {
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("input_text", this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString());
    localIntent.putExtra("input_panel_status", this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
  }
  
  private void e(String paramString)
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
      {
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, HardCodeUtil.a(2131703497), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718737), new DiscussChatPie.9(this, paramString), null).show();
        return;
      }
    }
    catch (Throwable paramString)
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ERR!! send_discussion_msg_failed_not_member:");
      localStringBuilder.append(paramString.getMessage());
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
  
  private void h(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("result");
    } else {
      paramIntent = "";
    }
    if ((paramIntent != null) && (!paramIntent.equals("")))
    {
      if (NetworkUtil.isNetSupport(a()))
      {
        ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), paramIntent);
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131694475), 0).b(a());
    }
  }
  
  private void i(Intent paramIntent)
  {
    String str2 = paramIntent.getExtras().getString("member_uin");
    Object localObject = paramIntent.getExtras().getString("member_display_name");
    if ((paramIntent.getExtras().getBoolean("isApollo")) && (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo != null))
    {
      String str1 = "0";
      if ("0".equals(str2)) {
        return;
      }
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2);
      if (android.text.TextUtils.isEmpty(paramIntent)) {
        paramIntent = (Intent)localObject;
      }
      localObject = new StringBuilder("@");
      ((StringBuilder)localObject).append(paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.peerUin = str2;
      this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.atNickName = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      a(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo);
      int i;
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.inputText))
      {
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mTextType == 0)
          {
            i = 6;
            break label298;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mTextType == 1)
          {
            i = 7;
            break label298;
          }
        }
        i = 2;
      }
      else if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText))
      {
        i = 3;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mTextType == 0)
      {
        i = 4;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mTextType == 1)
      {
        i = 5;
      }
      else
      {
        i = 0;
      }
      label298:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramIntent = new StringBuilder();
      paramIntent.append("");
      paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.actionId);
      String str3 = paramIntent.toString();
      paramIntent = new StringBuilder();
      paramIntent.append("655_");
      paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mPackageId);
      String str4 = paramIntent.toString();
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText)) {
        paramIntent = str1;
      } else {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText;
      }
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str2, i, j, new String[] { str3, str4, paramIntent, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
    a(str2, (String)localObject, true);
  }
  
  protected void K()
  {
    a();
    super.K();
  }
  
  protected void O()
  {
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new DiscussListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected HelperProvider a()
  {
    return new DiscussHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public RecordParams.RecorderParam a()
  {
    boolean bool = ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).b();
    return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 6001)
      {
        if (paramInt1 != 6002) {
          return;
        }
        h(paramIntent);
        return;
      }
      i(paramIntent);
      return;
    }
    if (paramInt2 == 0)
    {
      if (paramInt1 != 6001) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l) {
        BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.e);
    }
    super.a(paramConfiguration);
  }
  
  public void a(View paramView)
  {
    aq();
  }
  
  public void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "genDiscussTitle, name == null");
      }
      return;
    }
    int i = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramString1 = new QQText(paramString1, 1);
    if (i <= 0)
    {
      paramTextView.setText(paramString1);
      if (AppSetting.d)
      {
        paramTextView.setContentDescription(paramTextView.getText().toString());
        a().setTitle(paramTextView.getText());
      }
      return;
    }
    if (this.h == null) {
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365729));
    }
    this.h.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    if (this.h.getVisibility() != 0)
    {
      this.h.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        boolean bool = ((AudioPanelAioHelper)a(128)).b;
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(bool ^ true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
    paramTextView.setText(paramString1);
    if (AppSetting.d)
    {
      paramTextView.setContentDescription(paramTextView.getText().toString());
      a().setTitle(paramTextView.getText());
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((!android.text.TextUtils.isEmpty(paramString1)) && (!android.text.TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("memUin:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" displayName:");
        localStringBuilder.append(MessageRecordUtil.a(paramString2));
        localStringBuilder.append(" isRemoveOldAtFlag:");
        localStringBuilder.append(paramBoolean);
        QLog.d("_At_Me_DISC", 2, localStringBuilder.toString());
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l)
      {
        if ("0".equals(paramString1))
        {
          BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.i = paramString1;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(131077);
        e(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(HardCodeUtil.a(2131703495));
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new DiscussChatPie.5(this), 200L);
        return;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new DiscussChatPie.6(this, paramBoolean, paramString1, paramString2), 300L);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l) {
      BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
    }
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
  
  public void ai()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  protected void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.e);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "DiscussChatPie";
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    ai();
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("disscuss Uin : ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
    if (localObject != null)
    {
      if (((AVNotifyCenter.VideoRoomInfo_tips)localObject).a) {
        ReportController.b(null, "CliOper", "", "", "0X80066C0", "0X80066C0", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X80066BD", "0X80066BD", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
    }
    super.g(paramInt);
  }
  
  protected void j()
  {
    this.d.setOnClickListener(new DiscussChatPie.1(this));
    if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.d.setVisibility(0);
      this.d.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698604));
    }
    else
    {
      this.d.setVisibility(8);
    }
    ai();
  }
  
  public void k()
  {
    aq();
  }
  
  protected void m()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850467, 2130850468);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d())) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b(0);
      }
      super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131370119) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().e();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void p()
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
    }
    super.p();
  }
  
  public void u()
  {
    if (!this.B)
    {
      TroopAioNavigateBarManager localTroopAioNavigateBarManager = (TroopAioNavigateBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      if (localTroopAioNavigateBarManager != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("&");
        localStringBuilder.append(3000);
        localTroopAioNavigateBarManager.a(localStringBuilder.toString(), 0);
      }
    }
    super.u();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof TroopAioAgent.Message))
    {
      paramObservable = (TroopAioAgent.Message)paramObject;
      if (paramObservable != null) {
        if (paramObservable.jdField_a_of_type_Int == TroopAioAgent.jdField_a_of_type_Int) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramObservable.c, paramObservable.a(), paramObservable.d);
        } else if (paramObservable.jdField_a_of_type_Int == TroopAioAgent.b) {
          ((AudioPanelAioHelper)a(128)).j(paramObservable.b);
        }
      }
    }
    else
    {
      boolean bool = paramObject instanceof Integer;
    }
    if ((paramObject instanceof MessageForText))
    {
      paramObservable = (MessageForText)paramObject;
      if (paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in DiscussChatPie.update()");
        }
        AioVipKeywordHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
      }
    }
  }
  
  public void y()
  {
    super.y();
    ao();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie
 * JD-Core Version:    0.7.0.1
 */