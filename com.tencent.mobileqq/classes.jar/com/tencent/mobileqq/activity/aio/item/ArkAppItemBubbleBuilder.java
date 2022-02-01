package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.config.business.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.List;

public class ArkAppItemBubbleBuilder
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener
{
  private List<MessageForArkApp> a;
  private SessionInfo b;
  private int c;
  private int d;
  
  public ArkAppItemBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private void a(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    ArkAppCenterUtil.a(paramContext, paramMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  private void a(View paramView, MessageForArkApp paramMessageForArkApp, ArkAppItemBubbleBuilder.Holder paramHolder, ArkViewImplement.ArkViewInterface paramArkViewInterface)
  {
    if (e)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if ((paramHolder.jdField_b_of_type_JavaLangStringBuilder != null) && (paramHolder.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
        localStringBuilder.append(paramHolder.jdField_b_of_type_JavaLangStringBuilder);
      }
      localStringBuilder.append(a(paramMessageForArkApp));
      paramView.setContentDescription(localStringBuilder);
      paramArkViewInterface.setContentDescription(localStringBuilder);
      ArkAppCenter.a("ArkAppItemBubbleBuilder", "Type is normal, and talkbackText is " + localStringBuilder);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.bottomMargin = MessageForArkApp.dp2px(55.0F);
      if (paramBoolean)
      {
        paramView.addRule(0, 2131364634);
        paramView.addRule(1, 0);
      }
    }
    else
    {
      return;
    }
    paramView.addRule(1, 2131364634);
    paramView.addRule(0, 0);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ArkAppItemBubbleBuilder.Holder paramHolder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label101;
      }
      paramHolder.c = super.a(paramHolder.c, paramHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      super.a(paramHolder.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramHolder = paramHolder.c;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        break label96;
      }
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      TroopEssenceReportUtil.a(paramBaseChatItemLayout, paramHolder, paramChatMessage);
    }
    label96:
    label101:
    while (paramHolder.c == null) {
      for (;;)
      {
        return;
        paramChatMessage = null;
      }
    }
    paramHolder.c.setVisibility(8);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramMessageForArkApp))
    {
      paramMessageForArkApp.report(0);
      this.jdField_a_of_type_JavaUtilList.add(paramMessageForArkApp);
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp, ArkAppMessage.Config paramConfig)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramConfig.autoSize != null)
    {
      bool1 = bool2;
      if (paramConfig.autoSize.intValue() == 1) {
        bool1 = true;
      }
    }
    int i = ArkAppCenterUtil.jdField_a_of_type_Int;
    int k = MessageForArkApp.dp2px(390.0F);
    bool2 = MessageForArkApp.isSetSizeByConfig(paramConfig);
    StringBuilder localStringBuilder = new StringBuilder("isSetSize=");
    localStringBuilder.append(bool2).append(",param=[");
    Object localObject;
    if (bool2)
    {
      localObject = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.a(), paramConfig.width.intValue(), paramConfig.height.intValue());
      if (localObject != null) {
        if (!bool1) {
          break label312;
        }
      }
      label312:
      for (j = i;; j = ((MessageForArkApp.Size)localObject).width)
      {
        this.c = j;
        this.d = ((MessageForArkApp.Size)localObject).height;
        paramMessageForArkApp.arkContainer.setFixSize(this.c, this.d);
        localStringBuilder.append("arkConfig.width=").append(paramConfig.width).append(",arkConfig.height=").append(paramConfig.height).append("][autoSize=").append(bool1).append(",maxSize=").append(i).append("][size=").append(((MessageForArkApp.Size)localObject).width).append(",").append(((MessageForArkApp.Size)localObject).height).append("]").append("],app=").append(paramMessageForArkApp.ark_app_message.appName);
        QLog.i("ArkAppItemBubbleBuilder", 1, localStringBuilder.toString());
        ArkAppCenterUtil.a("ArkAppItemBubbleBuilder.attachArkView", this.jdField_a_of_type_AndroidContentContext);
        j = MessageForArkApp.dp2px(30.0F);
        int m = MessageForArkApp.dp2px(30.0F);
        paramMessageForArkApp.arkContainer.setMinSize(j, m);
        paramMessageForArkApp.arkContainer.setHintSize(-1, i);
        paramMessageForArkApp.arkContainer.a(i, i);
        paramMessageForArkApp.arkContainer.setMaxSize(i, k);
        return;
      }
    }
    if (bool1)
    {
      j = i;
      label330:
      this.c = j;
      this.d = -1;
      localObject = paramMessageForArkApp.arkContainer;
      if (!bool1) {
        break label439;
      }
    }
    label439:
    for (int j = i;; j = -1)
    {
      ((ArkAioContainerWrapper)localObject).setFixSize(j, -1);
      localStringBuilder.append("arkConfig.width=").append(paramConfig.width).append(",arkConfig.height=").append(paramConfig.height).append("][autoSize=").append(bool1).append(",maxSize=").append(i).append("]").append(",app=").append(paramMessageForArkApp.ark_app_message.appName);
      break;
      j = -1;
      break label330;
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu)
  {
    if (!ArkAppCenter.e()) {
      return;
    }
    paramQQCustomMenu.a(2131363000, this.jdField_a_of_type_AndroidContentContext.getString(2131690249), 2130839069);
    paramQQCustomMenu.a(2131363002, this.jdField_a_of_type_AndroidContentContext.getString(2131690248), 2130839069);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 2) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366428, paramChatMessage, null);
    }
    while (i != 1) {
      return;
    }
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366427, paramChatMessage, null);
  }
  
  private boolean a(MessageForArkApp paramMessageForArkApp)
  {
    if (!ForwardSDKB77AIOHelper.a(paramMessageForArkApp))
    {
      QLog.d("ArkAppItemBubbleBuilder", 1, "showForbidShareDialog false");
      return false;
    }
    paramMessageForArkApp = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.x);
    QLog.d("ArkAppItemBubbleBuilder", 1, new Object[] { "resend forbid msg wording=", paramMessageForArkApp });
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230);
    localQQCustomDialog.setMessage(paramMessageForArkApp);
    localQQCustomDialog.setPositiveButton(2131694615, new ArkAppItemBubbleBuilder.4(this));
    try
    {
      localQQCustomDialog.show();
      return true;
    }
    catch (Exception paramMessageForArkApp)
    {
      for (;;)
      {
        QLog.e("ArkAppItemBubbleBuilder", 1, "Exception", paramMessageForArkApp);
      }
    }
  }
  
  private void b(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    String str = "not loaded";
    if (paramMessageForArkApp.arkContainer != null) {
      str = paramMessageForArkApp.arkContainer.b();
    }
    QQToast.a(paramContext, str, 2000).a();
  }
  
  private void b(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null) || (TextUtils.isEmpty(paramMessageForArkApp.ark_app_message.metaList))) {
      return;
    }
    ArkAppMessage localArkAppMessage = paramMessageForArkApp.ark_app_message;
    String str;
    if ("com.tencent.giftmall.giftark".equals(localArkAppMessage.appName))
    {
      str = localArkAppMessage.metaList;
      if (!paramMessageForArkApp.isSend()) {
        break label143;
      }
    }
    label143:
    for (int i = 1;; i = 0)
    {
      localArkAppMessage.metaList = str.replace("#sender#", String.valueOf(i)).replace("#msgId#", String.valueOf(paramMessageForArkApp.uniseq));
      QLog.i("ArkAppItemBubbleBuilder", 1, "debugArkMeta = " + localArkAppMessage.metaList + " id = " + paramMessageForArkApp.msgtype + " _ " + paramMessageForArkApp.msgseq);
      return;
    }
  }
  
  private boolean b(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp == null) {}
    while ((!"com.tencent.test.troopapp".equals(paramMessageForArkApp.ark_app_message.appName)) && (!"com.tencent.troopapp".equals(paramMessageForArkApp.ark_app_message.appName))) {
      return false;
    }
    return true;
  }
  
  private void c(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null)) {}
    for (;;)
    {
      return;
      Object localObject = (MessageForArkApp)ArkAppCenterCheckEvent.a(1, paramMessageForArkApp.ark_app_message.appName, paramMessageForArkApp, paramMessageForArkApp);
      if (localObject == null) {}
      while ((paramMessageForArkApp != null) && (paramMessageForArkApp.ark_app_message != null))
      {
        int i = paramMessageForArkApp.getMsgArkAppCount();
        Intent localIntent = new Intent();
        if (i == 1)
        {
          localObject = QQCustomArkDialog.AppInfo.a(paramMessageForArkApp.ark_app_message.appName, paramMessageForArkApp.ark_app_message.appView, paramMessageForArkApp.ark_app_message.appMinVersion, paramMessageForArkApp.ark_app_message.metaList, ArkAppCenterUtil.a(), null, null);
          localIntent.putExtra("is_ark_display_share", true);
        }
        for (;;)
        {
          MessageForArkApp.ArkReportData localArkReportData = paramMessageForArkApp.buildTypeAndTitle();
          if (localArkReportData.isSdkShare)
          {
            ((Bundle)localObject).putString("forward_ark_app_type", localArkReportData.type);
            ((Bundle)localObject).putString("forward_ark_app_title", localArkReportData.title);
          }
          ((Bundle)localObject).putInt("forward_type", 27);
          ((Bundle)localObject).putString("forward_ark_app_name", paramMessageForArkApp.ark_app_message.appName);
          ((Bundle)localObject).putString("forward_ark_app_view", paramMessageForArkApp.ark_app_message.appView);
          ((Bundle)localObject).putString("forward_ark_app_ver", paramMessageForArkApp.ark_app_message.appMinVersion);
          ((Bundle)localObject).putString("forward_ark_app_prompt", paramMessageForArkApp.ark_app_message.promptText);
          ((Bundle)localObject).putString("forward_ark_app_config", paramMessageForArkApp.ark_app_message.config);
          ((Bundle)localObject).putString("forward_ark_app_desc", paramMessageForArkApp.ark_app_message.appDesc);
          ((Bundle)localObject).putString("forward_ark_app_compat", paramMessageForArkApp.ark_app_message.compatibleText);
          ((Bundle)localObject).putString("forward_ark_app_meta", paramMessageForArkApp.ark_app_message.metaList);
          ((Bundle)localObject).putString("forward_appId_ark_from_sdk", paramMessageForArkApp.ark_app_message.appId);
          ((Bundle)localObject).putString("struct_share_key_source_name", paramMessageForArkApp.ark_app_message.mSourceName);
          ((Bundle)localObject).putString("struct_share_key_source_action_data", paramMessageForArkApp.ark_app_message.mSourceActionData);
          ((Bundle)localObject).putString("struct_share_key_source_a_action_data", paramMessageForArkApp.ark_app_message.mSource_A_ActionData);
          ((Bundle)localObject).putString("struct_share_key_source_url", paramMessageForArkApp.ark_app_message.mSourceUrl);
          ((Bundle)localObject).putInt("selection_mode", this.jdField_b_of_type_Int);
          ((Bundle)localObject).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          localIntent.putExtras((Bundle)localObject);
          ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
          return;
          localObject = new Bundle();
        }
        paramMessageForArkApp = (MessageForArkApp)localObject;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout.setHeadIconVisible(true);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
    localConfig.fromString(localMessageForArkApp.ark_app_message.config);
    ArkAppItemBubbleBuilder.Holder localHolder = (ArkAppItemBubbleBuilder.Holder)paramViewHolder;
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558899, null);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)localView.findViewById(2131362998));
      localHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363007));
      localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363006));
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363008));
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localHolder);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131370713));
    }
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    if (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
    {
      paramView = (RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      paramView.width = ArkAppCenterUtil.jdField_a_of_type_Int;
      paramView.height = ArkAppCenterUtil.jdField_a_of_type_Int;
      paramView.setMargins(0, 0, 0, 0);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams(paramView);
    }
    localView.findViewById(2131363025).setPadding(0, 0, 0, 0);
    b(localMessageForArkApp);
    if (localHolder.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      localHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (ArkTipsManager.a().a(paramChatMessage.uniseq)) {
      localMessageForArkApp.arkContainer = ArkTipsManager.a().a();
    }
    if (localMessageForArkApp.arkContainer == null) {
      localMessageForArkApp.arkContainer = new ArkAioContainerWrapper();
    }
    localMessageForArkApp.arkContainer.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppItemBubbleBuilder", 2, "multiAio.ArkAppItemBubbleBuilder set session info =" + ArkAppModuleBase.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo));
    }
    paramView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, ArkAppCenterUtil.a(), localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject = new ArkAppItemBubbleBuilder.1(this, localMessageForArkApp, localHolder);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback((ArkViewImplement.LoadCallback)localObject);
    a(localMessageForArkApp, localConfig);
    localHolder.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
    localObject = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ArkAppView localArkAppView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ((ArkViewImplement.ArkViewInterface)localObject).setClipRadius(16.0F);
    if (MessageForArkApp.isRectangleBorder(localConfig))
    {
      ((ArkViewImplement.ArkViewInterface)localObject).setBorderType(0);
      if (paramChatMessage.isSend()) {
        break label672;
      }
    }
    label672:
    for (boolean bool = true;; bool = false)
    {
      ((ArkViewImplement.ArkViewInterface)localObject).setAlignLeft(bool);
      localArkAppView.a(localMessageForArkApp.arkContainer, paramView);
      ((ArkViewImplement.ArkViewInterface)localObject).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((ArkViewImplement.ArkViewInterface)localObject).setOnLongClickListener(paramOnLongClickAndTouchListener);
      if (paramView != null)
      {
        paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      }
      a(localView, localMessageForArkApp, localHolder, (ArkViewImplement.ArkViewInterface)localObject);
      ArkAsyncShareMsgManager.b(localMessageForArkApp);
      if (paramBaseChatItemLayout.c != null) {
        a(paramBaseChatItemLayout.c, localMessageForArkApp.isSend());
      }
      if (paramBaseChatItemLayout.a != null) {
        a(paramBaseChatItemLayout.a, localMessageForArkApp.isSend());
      }
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).playShareMsgAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramViewHolder.jdField_b_of_type_Int, paramViewHolder.c);
      a(localMessageForArkApp);
      a(paramChatMessage, paramBaseChatItemLayout, localHolder);
      return localView;
      ((ArkViewImplement.ArkViewInterface)localObject).setBorderType(1);
      break;
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppItemBubbleBuilder.Holder();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return "";
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    if ((localMessageForArkApp.ark_app_message == null) || (localMessageForArkApp.ark_app_message.promptText == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    for (;;)
    {
      localStringBuilder.append(localMessageForArkApp.ark_app_message.promptText);
      if (localMessageForArkApp.arkContainer != null)
      {
        paramChatMessage = localMessageForArkApp.arkContainer.jdField_b_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramChatMessage)) {
          localStringBuilder.append(paramChatMessage);
        }
      }
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131367398: 
      c((MessageForArkApp)paramChatMessage);
      return;
    case 2131365636: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131366625: 
      QfavBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      return;
    case 2131363000: 
      a(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
    b(paramContext, (MessageForArkApp)paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForArkApp)AIOUtils.a(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690018);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690019);
    } while ((!paramView.isSendFromLocal()) || (a(paramView)));
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ArkAppItemBubbleBuilder.2(this, paramView), new ArkAppItemBubbleBuilder.3(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296405);
    int j = BaseChatItemLayout.h;
    int k = BaseChatItemLayout.i;
    int m = BaseChatItemLayout.k;
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(m, j, i, k);
      return;
    }
    paramView.setPadding(i, j, m, k);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppItemBubbleBuilder", 2, "updateView type=" + paramInt + ",message=" + paramChatMessage);
    }
    super.a(paramView, paramChatMessage, paramInt);
    b(paramChatMessage, (BaseChatItemLayout)paramView);
  }
  
  protected void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000) && (paramChatMessage.istroop != 0));
        if ((paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) || (!paramChatMessage.isSupportReply())) {
          break;
        }
      } while ((!(paramChatMessage instanceof MessageForArkApp)) || (((MessageForArkApp)paramChatMessage).msg == null));
      paramQQCustomMenu.a(2131376927, this.jdField_a_of_type_AndroidContentContext.getString(2131697689), 2130839065);
      return;
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (!(paramChatMessage instanceof MessageForArkApp)) || (paramChatMessage.istroop == 3000) || (((MessageForArkApp)paramChatMessage).msg == null));
    paramQQCustomMenu.a(2131376927, this.jdField_a_of_type_AndroidContentContext.getString(2131697689), 2130839065);
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof ArkAppItemBubbleBuilder.Holder;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    boolean bool2 = true;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return localQQCustomMenu.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10007) {
      return localQQCustomMenu.a();
    }
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        a(localQQCustomMenu);
        if ((MessageForArkApp.isAllowedArkForward(false, paramView)) && (!b(paramView))) {
          localQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
        }
        if (paramView.isMultiMsg) {
          return localQQCustomMenu.a();
        }
        if ((TextUtils.isEmpty(paramView.ark_app_message.appName)) || (!b(paramView))) {
          break label535;
        }
      }
    }
    label530:
    label535:
    for (int i = 1;; i = 0)
    {
      boolean bool1 = bool2;
      Object localObject;
      if (paramView.extraflag != 32768)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))
        {
          bool1 = bool2;
          if (i == 0)
          {
            localObject = (Boolean)ArkAppCenterCheckEvent.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
            if (localObject == null) {
              break label530;
            }
          }
        }
      }
      for (bool1 = ((Boolean)localObject).booleanValue();; bool1 = true)
      {
        if (bool1) {
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramView, new Bundle());
        }
        if (bool1) {
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramView, new Bundle());
        }
        for (;;)
        {
          super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
          if (TroopEssenceUtil.b(paramView)) {
            a(localQQCustomMenu, paramView);
          }
          try
          {
            if (ArkMsgReplyConfigMgr.a().a(paramView.ark_app_message.appName, paramView.ark_app_message.appView))
            {
              a(paramView, localQQCustomMenu);
              a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramView, null);
            }
            if (QfavHelper.a(paramView)) {
              super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366625, null, null);
            }
            localObject = new Bundle();
            ((Bundle)localObject).putBoolean("isSearch", false);
            super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380949, paramView, (Bundle)localObject);
            super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
            return localQQCustomMenu.a();
            ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("ArkAppItemBubbleBuilder", 2, "add reply menu error, exception =" + localException.getMessage());
            }
          }
        }
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
        return localQQCustomMenu.a();
      }
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */