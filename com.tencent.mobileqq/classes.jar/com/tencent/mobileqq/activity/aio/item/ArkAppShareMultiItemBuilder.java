package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAdapterItemInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.ark.ArkHorizontalListView.RefreshUiCallback;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.config.business.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
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
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.List;

public class ArkAppShareMultiItemBuilder
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener, ContextMenuBuilder2, ArkHorizontalListView.RefreshUiCallback
{
  private List<MessageForArkApp> a;
  
  public ArkAppShareMultiItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private RelativeLayout.LayoutParams a(BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams1.width = -1;
    localLayoutParams1.height = (ArkAppCenterUtil.jdField_a_of_type_Int + AIOUtils.a(29.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.leftMargin = 0;
    paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.v, 0, BaseChatItemLayout.i + BaseChatItemLayout.l);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
    int i;
    if (paramBoolean)
    {
      localLayoutParams2.rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296406);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLayoutParams(localLayoutParams2);
      if (paramBaseChatItemLayout.b != null)
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams();
        i = MessageForArkApp.dp2px(1.0F);
        if (!paramBoolean) {
          break label327;
        }
        localLayoutParams2.addRule(7, 2131364643);
        localLayoutParams2.rightMargin = (-i);
        label147:
        paramBaseChatItemLayout.b.setLayoutParams(localLayoutParams2);
      }
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
        localLayoutParams2.leftMargin = BaseChatItemLayout.t;
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams(localLayoutParams2);
      }
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8))
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        if (!paramBoolean) {
          break label345;
        }
        localLayoutParams2.rightMargin = BaseChatItemLayout.u;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams2);
      return localLayoutParams1;
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        i = MessageForArkApp.dp2px(30.0F);
        localLayoutParams2.leftMargin = (BaseChatItemLayout.t + i);
        localLayoutParams1.leftMargin = (i - BaseChatItemLayout.t);
        break;
      }
      localLayoutParams2.leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296406);
      break;
      label327:
      localLayoutParams2.addRule(5, 2131364643);
      localLayoutParams2.leftMargin = (-i);
      break label147;
      label345:
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
        localLayoutParams2.leftMargin = (MessageForArkApp.dp2px(25.0F) + BaseChatItemLayout.t);
      } else {
        localLayoutParams2.leftMargin = BaseChatItemLayout.t;
      }
    }
  }
  
  private void a(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    ArkAppCenterUtil.a(paramContext, paramMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
    localLayoutParams.addRule(8, 2131364634);
    localLayoutParams.bottomMargin = paramInt2;
    if (paramBoolean)
    {
      localLayoutParams.addRule(5, 2131364634);
      localLayoutParams.leftMargin = paramInt3;
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(7, 2131364634);
      localLayoutParams.rightMargin = paramInt3;
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramMessageForArkApp))
    {
      paramMessageForArkApp.report(0);
      this.jdField_a_of_type_JavaUtilList.add(paramMessageForArkApp);
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
  
  private void b(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    String str = "not loaded";
    if (paramMessageForArkApp.arkContainer != null) {
      str = paramMessageForArkApp.arkContainer.b();
    }
    QQToast.a(paramContext, str, 2000).a();
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (ArkAppShareMultiItemBuilder.ShareMultiHolder)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramOnLongClickAndTouchListener = paramChatMessage.a(NickNameLayoutProcessor.h);
    if (paramOnLongClickAndTouchListener != null)
    {
      if ((!paramOnLongClickAndTouchListener.checkViewNonNull()) || (paramOnLongClickAndTouchListener.getViewVisibility() != 0)) {
        break label97;
      }
      paramViewGroup.addRule(3, 2131364652);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.h;; paramViewGroup.topMargin = 0)
    {
      paramView.jdField_a_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      label97:
      paramViewGroup.addRule(6, 2131364643);
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    boolean bool = localMessageForArkApp.isSend();
    Object localObject = a(paramBaseChatItemLayout, bool);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = BaseChatItemLayout.o;
    int j = MessageForArkApp.dp2px(40.0F);
    int k = localResources.getDimensionPixelSize(2131296404) + (i * 2 + j);
    int m = localResources.getDimensionPixelSize(2131296396);
    i = ArkAppCenterUtil.d - k - ArkAppCenterUtil.jdField_a_of_type_Int - m;
    label109:
    ArkAppShareMultiItemBuilder.ShareMultiHolder localShareMultiHolder;
    ArkHorizontalListViewAdapter localArkHorizontalListViewAdapter;
    if (bool)
    {
      j = i;
      if (!bool) {
        break label442;
      }
      k -= m;
      QLog.d("ArkAppShareMultiItemBuilder", 1, new Object[] { "ArkFold.appName:", localMessageForArkApp.ark_app_message.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(ArkAppCenterUtil.jdField_a_of_type_Int), ", displaywitdh=", Integer.valueOf(ArkAppCenterUtil.c), ", headerWidth=", Integer.valueOf(j), ",footerWidth=", Integer.valueOf(k) });
      localShareMultiHolder = (ArkAppShareMultiItemBuilder.ShareMultiHolder)paramViewHolder;
      paramView = (ArkHorizontalListView)paramView;
      if (paramView != null) {
        break label449;
      }
      paramView = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setDividerWidth(m);
      localArkHorizontalListViewAdapter = new ArkHorizontalListViewAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramOnLongClickAndTouchListener);
      paramView.setAdapter(localArkHorizontalListViewAdapter);
      paramOnLongClickAndTouchListener = paramView;
      label262:
      paramOnLongClickAndTouchListener.setIsSend(bool);
      paramOnLongClickAndTouchListener.MIN_SPACE = (ArkAppCenterUtil.c / 4);
      localArkHorizontalListViewAdapter.a(j, k);
      paramOnLongClickAndTouchListener.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramOnLongClickAndTouchListener.setRefreshCallback(this);
      paramOnLongClickAndTouchListener.setTag(localShareMultiHolder);
      localShareMultiHolder.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      localShareMultiHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      k = localMessageForArkApp.getMsgArkAppCount();
      localArkHorizontalListViewAdapter.a(localArkHorizontalListViewAdapter.a() - k);
      paramView = null;
      j = 0;
      label352:
      if (j >= k) {
        break label476;
      }
      localObject = localMessageForArkApp.getMsgArkAppByPosition(j);
      if ((MessageForArkApp)localArkHorizontalListViewAdapter.b(j) != null) {
        break label464;
      }
      localArkHorizontalListViewAdapter.a((ArkAdapterItemInterface)localObject);
      label388:
      if ((localObject == null) || (TextUtils.isEmpty(((MessageForArkApp)localObject).ark_app_message.appName)) || (!TextUtils.isEmpty(paramView))) {
        break label881;
      }
      paramView = ((MessageForArkApp)localObject).ark_app_message.appName;
    }
    label442:
    label449:
    label464:
    label476:
    label860:
    label881:
    for (;;)
    {
      j += 1;
      break label352;
      j = k - m;
      break;
      k = i;
      break label109;
      localArkHorizontalListViewAdapter = (ArkHorizontalListViewAdapter)paramView.getAdapter();
      paramOnLongClickAndTouchListener = paramView;
      break label262;
      localArkHorizontalListViewAdapter.b(j, (ArkAdapterItemInterface)localObject);
      break label388;
      a(paramOnLongClickAndTouchListener);
      if (localArkHorizontalListViewAdapter.a() == 1)
      {
        int n;
        if (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar != null)
        {
          j = MessageForArkApp.dp2px(16.0F);
          k = MessageForArkApp.dp2px(47.0F);
          m = localResources.getDimensionPixelSize(2131296404);
          n = BaseChatItemLayout.t;
          a(paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar, j, k, i - j - m - n, bool);
        }
        if (paramBaseChatItemLayout.c != null)
        {
          j = MessageForArkApp.dp2px(24.0F);
          k = MessageForArkApp.dp2px(45.0F);
          m = localResources.getDimensionPixelSize(2131296404);
          n = BaseChatItemLayout.t;
          a(paramBaseChatItemLayout.c, j, k, i - j - m - n, bool);
        }
      }
      if (e)
      {
        paramView = new StringBuilder();
        if ((localShareMultiHolder.jdField_b_of_type_JavaLangStringBuilder != null) && (localShareMultiHolder.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
          paramView.append(localShareMultiHolder.jdField_b_of_type_JavaLangStringBuilder);
        }
        paramView.append(a(localMessageForArkApp));
        paramOnLongClickAndTouchListener.setContentDescription(paramView);
        ArkAppCenter.a("ArkAppShareMultiItemBuilder", "Type is card, and talkbackText is " + paramView);
      }
      ArkAsyncShareMsgManager.b(localMessageForArkApp);
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).playShareMsgAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramViewHolder.b, paramViewHolder.c);
      a(localMessageForArkApp);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (!TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label860;
        }
        localShareMultiHolder.c = super.a(localShareMultiHolder.c, localShareMultiHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(localShareMultiHolder.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
        paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        paramView = localShareMultiHolder.c;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
          break label855;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        TroopEssenceReportUtil.a(paramViewHolder, paramView, paramChatMessage);
      }
      while (localShareMultiHolder.c == null) {
        for (;;)
        {
          return paramOnLongClickAndTouchListener;
          paramChatMessage = null;
        }
      }
      localShareMultiHolder.c.setVisibility(8);
      return paramOnLongClickAndTouchListener;
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppShareMultiItemBuilder.ShareMultiHolder();
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    if ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null) && (paramChatMessage.arkContainer.getErrorInfo() != null) && (MessageForArkApp.isAllowedArkForward(false, paramChatMessage))) {
      paramQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
    }
    return paramQQCustomMenu;
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
    MessageForArkApp localMessageForArkApp;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131367398: 
      do
      {
        return;
        localMessageForArkApp = (MessageForArkApp)paramChatMessage;
      } while ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null));
      paramContext = (MessageForArkApp)ArkAppCenterCheckEvent.a(1, localMessageForArkApp.ark_app_message.appName, localMessageForArkApp, localMessageForArkApp);
      if (paramContext == null) {
        paramContext = localMessageForArkApp;
      }
      break;
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      Intent localIntent = new Intent();
      if (paramContext.getMsgArkAppCount() >= 1)
      {
        paramChatMessage = QQCustomArkDialog.AppInfo.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, ArkAppCenterUtil.a(), null, null);
        localIntent.putExtra("is_ark_display_share", true);
      }
      for (;;)
      {
        MessageForArkApp.ArkReportData localArkReportData = paramContext.buildTypeAndTitle();
        if (localArkReportData.isSdkShare)
        {
          paramChatMessage.putString("forward_ark_app_type", localArkReportData.type);
          paramChatMessage.putString("forward_ark_app_title", localArkReportData.title);
        }
        paramChatMessage.putInt("forward_type", 27);
        paramChatMessage.putString("forward_ark_app_name", paramContext.ark_app_message.appName);
        paramChatMessage.putString("forward_ark_app_view", paramContext.ark_app_message.appView);
        paramChatMessage.putString("forward_ark_app_ver", paramContext.ark_app_message.appMinVersion);
        paramChatMessage.putString("forward_ark_app_prompt", paramContext.ark_app_message.promptText);
        paramChatMessage.putString("forward_ark_app_config", paramContext.ark_app_message.config);
        paramChatMessage.putString("forward_ark_app_desc", paramContext.ark_app_message.appDesc);
        paramChatMessage.putString("forward_ark_app_compat", paramContext.ark_app_message.compatibleText);
        paramChatMessage.putString("forward_ark_app_meta", paramContext.ark_app_message.metaList);
        paramChatMessage.putString("forward_appId_ark_from_sdk", paramContext.ark_app_message.appId);
        paramChatMessage.putString("struct_share_key_source_name", paramContext.ark_app_message.mSourceName);
        paramChatMessage.putString("struct_share_key_source_action_data", paramContext.ark_app_message.mSourceActionData);
        paramChatMessage.putString("struct_share_key_source_a_action_data", paramContext.ark_app_message.mSource_A_ActionData);
        paramChatMessage.putString("struct_share_key_source_url", paramContext.ark_app_message.mSourceUrl);
        paramChatMessage.putInt("selection_mode", this.b);
        paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localIntent.putExtras(paramChatMessage);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
        if (!localMessageForArkApp.isMultiMsg) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 11, 0, "11", "", "", "");
        return;
        paramChatMessage = new Bundle();
      }
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      QfavBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      return;
      a(paramContext, (MessageForArkApp)paramChatMessage);
      return;
      b(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
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
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ArkAppShareMultiItemBuilder.1(this, paramView), new ArkAppShareMultiItemBuilder.2(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public void a(ArkHorizontalListView paramArkHorizontalListView)
  {
    int k = 1;
    BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)paramArkHorizontalListView.getTag();
    if ((localViewHolder == null) || (!(localViewHolder instanceof ArkAppShareMultiItemBuilder.ShareMultiHolder))) {
      return;
    }
    int[] arrayOfInt1 = new int[2];
    localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLocationOnScreen(arrayOfInt1);
    int j = arrayOfInt1[0];
    int m = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getMeasuredWidth();
    int n = arrayOfInt1[1];
    int i1 = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getMeasuredHeight();
    int i2 = paramArkHorizontalListView.getChildCount();
    int[] arrayOfInt2 = new int[2];
    int i = 0;
    if (i < i2)
    {
      View localView = paramArkHorizontalListView.getChildAt(i);
      if (localView != null)
      {
        localView.getLocationOnScreen(arrayOfInt2);
        int i3 = arrayOfInt2[0];
        int i4 = localView.getMeasuredWidth();
        int i5 = arrayOfInt2[1];
        int i6 = localView.getMeasuredHeight();
        if ((!(localView instanceof LinearLayout)) || (i3 + i4 < arrayOfInt1[0]) || (arrayOfInt2[0] > m + j) || (i5 + i6 < arrayOfInt1[1]) || (arrayOfInt2[1] > i1 + n)) {}
      }
    }
    for (i = 1;; i = 0)
    {
      if ((localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
      {
        j = 1;
        label229:
        if ((i == 0) || (j != 0)) {
          break label431;
        }
        i = k;
        label240:
        if (i == 0) {
          break label452;
        }
        i = MessageForArkApp.dp2px(1.0F);
        if (localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null)
        {
          localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setScaleType(ImageView.ScaleType.FIT_XY);
          j = MessageForArkApp.dp2px(42.0F);
          paramArkHorizontalListView = new RelativeLayout.LayoutParams(j, j);
          localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b, paramArkHorizontalListView);
        }
        paramArkHorizontalListView = (RelativeLayout.LayoutParams)localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.getLayoutParams();
        paramArkHorizontalListView.addRule(6, 2131364643);
        paramArkHorizontalListView.topMargin = (-i);
        if (!localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.f()) {
          break label436;
        }
        paramArkHorizontalListView.addRule(7, 2131364643);
        paramArkHorizontalListView.rightMargin = (-i);
      }
      for (;;)
      {
        localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setBackgroundResource(2130845015);
        localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.requestLayout();
        localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(0);
        return;
        i += 1;
        break;
        j = 0;
        break label229;
        label431:
        i = 0;
        break label240;
        label436:
        paramArkHorizontalListView.addRule(5, 2131364643);
        paramArkHorizontalListView.leftMargin = (-i);
      }
      label452:
      if (localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null) {
        break;
      }
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(8);
      return;
    }
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
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if (paramView != null)
    {
      paramView = paramView.a;
      if ((paramView != null) && ((paramView instanceof MessageForArkApp)))
      {
        a(localQQCustomMenu);
        if (!paramView.isMultiMsg) {
          break label66;
        }
        a(localQQCustomMenu, paramView, null);
      }
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      paramView = null;
      break;
      label66:
      b(localQQCustomMenu, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramBaseHolder = (MessageForArkApp)paramChatMessage;
    boolean bool;
    if ((paramBaseHolder != null) && (paramBaseHolder.ark_app_message != null) && (paramBaseHolder.arkContainer != null) && (paramBaseHolder.arkContainer.getErrorInfo() != null))
    {
      if (MessageForArkApp.isAllowedArkForward(false, paramBaseHolder)) {
        paramQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
      }
      if ((paramBaseHolder.extraflag == 32768) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramBaseHolder))) {
        break label397;
      }
      Boolean localBoolean = (Boolean)ArkAppCenterCheckEvent.a(3, paramBaseHolder.ark_app_message.appName, paramBaseHolder, Boolean.valueOf(true));
      if (localBoolean == null) {
        break label391;
      }
      bool = localBoolean.booleanValue();
      if (bool) {
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramBaseHolder, new Bundle());
      }
    }
    for (;;)
    {
      if (bool) {
        a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramBaseHolder, new Bundle());
      }
      try
      {
        for (;;)
        {
          if (ArkMsgReplyConfigMgr.a().a(paramBaseHolder.ark_app_message.appName, paramBaseHolder.ark_app_message.appView))
          {
            a(paramBaseHolder, paramQQCustomMenu);
            a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramBaseHolder, null);
          }
          super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
          if (QfavHelper.a(paramChatMessage)) {
            super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366625, null, null);
          }
          paramChatMessage = new Bundle();
          paramChatMessage.putBoolean("isSearch", false);
          super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380949, paramBaseHolder, paramChatMessage);
          super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
          return paramQQCustomMenu;
          ChatActivityFacade.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("ArkAppShareMultiItemBuilder", 2, "add reply menu error, exception =" + localException.getMessage());
        }
      }
      ChatActivityFacade.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return paramQQCustomMenu;
      label391:
      bool = true;
      break;
      label397:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppShareMultiItemBuilder
 * JD-Core Version:    0.7.0.1
 */