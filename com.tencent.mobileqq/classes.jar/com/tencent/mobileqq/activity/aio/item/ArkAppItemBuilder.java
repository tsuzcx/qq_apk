package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class ArkAppItemBuilder
  extends AbstractChatItemBuilder
{
  public ArkAppItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if ((BaseChatItemLayout.a > BaseChatItemLayout.b) && (QLog.isColorLevel())) {
      QLog.e("ark.ArkAppItemBuilder", 2, String.format(Locale.CHINA, "widthPixels > heightPixels: (%d, %d)", new Object[] { Integer.valueOf(BaseChatItemLayout.a), Integer.valueOf(BaseChatItemLayout.b) }));
    }
    int i = BaseChatItemLayout.c - BaseChatItemLayout.s - BaseChatItemLayout.t - paramLinearLayout.getResources().getDimensionPixelSize(2131558652) * 2;
    if (BaseChatItemLayout.x != i) {
      QLog.e("ark.ArkAppItemBuilder", 2, String.format(Locale.CHINA, "structMsgWidth != arkAppWidth, structMsgWidth: %d, arkAppWidth: %d, (w, h): (%d, %d)", new Object[] { Integer.valueOf(BaseChatItemLayout.x), Integer.valueOf(i), Integer.valueOf(BaseChatItemLayout.a), Integer.valueOf(BaseChatItemLayout.b) }));
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramMessageRecord;
    ArkAppItemBuilder.Holder localHolder = (ArkAppItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968741, null);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramViewHolder.findViewById(2131363294));
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localHolder);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramViewHolder.findViewById(2131363295));
    }
    if (ArkTipsManager.a().a(paramMessageRecord.uniseq)) {
      localMessageForArkApp.arkContainer = ArkTipsManager.a().a();
    }
    if (localMessageForArkApp.arkContainer == null) {
      localMessageForArkApp.arkContainer = new ArkAioContainerWrapper();
    }
    localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity, localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    int j = AIOUtils.a(352.0F, paramLinearLayout.getResources());
    localMessageForArkApp.arkContainer.setFixSize(i, -1);
    localMessageForArkApp.arkContainer.setMaxSize(i, -1);
    localMessageForArkApp.arkContainer.setHintSize(-1, j);
    localMessageForArkApp.arkContainer.a(-1, j);
    localHolder.jdField_a_of_type_JavaLangString = localMessageForArkApp.msg;
    paramMessageRecord = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    paramView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    paramLinearLayout = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    paramView.setClipRadius(5.0F);
    paramLinearLayout.a(localMessageForArkApp.arkContainer, paramMessageRecord);
    paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    if (paramMessageRecord != null)
    {
      paramMessageRecord.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramMessageRecord.setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new ArkAppItemBuilder.Holder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
    case 2131363499: 
      do
      {
        return;
        paramContext = (MessageForArkApp)paramChatMessage;
      } while ((paramContext == null) || (paramContext.ark_app_message == null));
      paramChatMessage = (MessageForArkApp)ArkAppCenterCheckEvent.a(1, paramContext.ark_app_message.appName, paramContext, paramContext);
      if (paramChatMessage != null) {
        break;
      }
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      paramChatMessage = new Bundle();
      paramChatMessage.putInt("forward_type", 27);
      paramChatMessage.putString("forward_ark_app_name", paramContext.ark_app_message.appName);
      paramChatMessage.putString("forward_ark_app_view", paramContext.ark_app_message.appView);
      paramChatMessage.putString("forward_ark_app_ver", paramContext.ark_app_message.appMinVersion);
      paramChatMessage.putString("forward_ark_app_prompt", paramContext.ark_app_message.promptText);
      paramChatMessage.putString("forward_ark_app_config", paramContext.ark_app_message.config);
      paramChatMessage.putString("forward_ark_app_desc", paramContext.ark_app_message.appDesc);
      paramChatMessage.putString("forward_ark_app_compat", paramContext.ark_app_message.compatibleText);
      paramChatMessage.putString("forward_ark_app_meta", paramContext.ark_app_message.metaList);
      paramContext = new Intent();
      paramContext.putExtras(paramChatMessage);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
      return;
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    int i;
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
        localConfig.fromString(paramView.ark_app_message.config);
        if ((localConfig.forward != null) && (localConfig.forward.intValue() > 0))
        {
          paramView = (Boolean)ArkAppCenterCheckEvent.a(0, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
          if ((paramView != null) && (!paramView.booleanValue())) {
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        localQQCustomMenu.a(2131363499, this.jdField_a_of_type_AndroidContentContext.getString(2131435066), 2130838309);
      }
      localQQCustomMenu.a(2131375336, this.jdField_a_of_type_AndroidContentContext.getString(2131433621), 2130838305);
      return localQQCustomMenu.a();
      i = 1;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBuilder
 * JD-Core Version:    0.7.0.1
 */