package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import uri;
import urj;
import urk;

public class ArkAppItemBubbleBuilder
  extends BaseBubbleBuilder
{
  private static final int b;
  private static final int c = BaseChatItemLayout.h;
  private static final int d = BaseChatItemLayout.j;
  
  static
  {
    jdField_b_of_type_Int = BaseChatItemLayout.g;
  }
  
  public ArkAppItemBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForArkApp)paramChatMessage;
    Object localObject1 = new ArkAppMessage.Config();
    ((ArkAppMessage.Config)localObject1).fromString(paramBaseChatItemLayout.ark_app_message.config);
    if ((((ArkAppMessage.Config)localObject1).autoSize != null) && (((ArkAppMessage.Config)localObject1).autoSize.intValue() == 1)) {}
    for (int i = 1;; i = 0)
    {
      localObject1 = (ArkAppItemBubbleBuilder.Holder)paramViewHolder;
      paramViewHolder = paramView;
      if (paramView == null)
      {
        paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968741, null);
        ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramViewHolder.findViewById(2131363294));
        ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewHolder.findViewById(2131363299));
        ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131363300));
        ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131363301));
        ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localObject1);
        paramViewHolder.findViewById(2131363293).setPadding(0, 0, 0, 0);
        paramView = (ArkAppLoadLayout)paramViewHolder.findViewById(2131363295);
        localObject2 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).setMargins(5, 5, 5, 5);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = paramView;
        ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        paramView = new uri(this, (ArkAppItemBubbleBuilder.Holder)localObject1, paramBaseChatItemLayout);
        ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(paramView);
      }
      if (ArkTipsManager.a().a(paramChatMessage.uniseq)) {
        paramBaseChatItemLayout.arkContainer = ArkTipsManager.a().a();
      }
      if (paramBaseChatItemLayout.arkContainer == null) {
        paramBaseChatItemLayout.arkContainer = new ArkAioContainerWrapper();
      }
      paramView = ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      paramBaseChatItemLayout.arkContainer.a(paramBaseChatItemLayout.ark_app_message.appName, paramBaseChatItemLayout.ark_app_message.appView, paramBaseChatItemLayout.ark_app_message.appMinVersion, paramBaseChatItemLayout.ark_app_message.metaList, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      int j = BaseChatItemLayout.e;
      Object localObject2 = paramBaseChatItemLayout.arkContainer;
      ArkAppView localArkAppView;
      if (i != 0)
      {
        i = j;
        ((ArkAioContainerWrapper)localObject2).setFixSize(i, -1);
        paramBaseChatItemLayout.arkContainer.setHintSize(-1, j);
        paramBaseChatItemLayout.arkContainer.a(-1, j);
        paramBaseChatItemLayout.arkContainer.setMaxSize(BaseChatItemLayout.d, -1);
        ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_JavaLangString = paramBaseChatItemLayout.msg;
        localObject2 = ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
        localArkAppView = ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
        ((ArkViewImplement.ArkViewInterface)localObject2).setClipRadius(14.0F);
        ((ArkViewImplement.ArkViewInterface)localObject2).setBorderType(1);
        if (paramChatMessage.isSend()) {
          break label571;
        }
      }
      label571:
      for (boolean bool = true;; bool = false)
      {
        ((ArkViewImplement.ArkViewInterface)localObject2).setAlignLeft(bool);
        localArkAppView.a(paramBaseChatItemLayout.arkContainer, paramView);
        ((ArkViewImplement.ArkViewInterface)localObject2).setOnTouchListener(paramOnLongClickAndTouchListener);
        ((ArkViewImplement.ArkViewInterface)localObject2).setOnLongClickListener(paramOnLongClickAndTouchListener);
        if (paramView != null)
        {
          paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
        }
        if (jdField_b_of_type_Boolean)
        {
          if ((((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_JavaLangStringBuilder != null) && (((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
            ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_JavaLangStringBuilder.setLength(0);
          }
          paramChatMessage = a(paramBaseChatItemLayout);
          paramViewHolder.setContentDescription(paramChatMessage);
          ((ArkViewImplement.ArkViewInterface)localObject2).setContentDescription(paramChatMessage);
        }
        return paramViewHolder;
        i = -1;
        break;
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppItemBubbleBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return "";
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    if ((localMessageForArkApp.ark_app_message == null) || (localMessageForArkApp.ark_app_message.promptText == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    localStringBuilder.append(localMessageForArkApp.ark_app_message.promptText);
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
    case 2131363499: 
      do
      {
        return;
        paramChatMessage = (MessageForArkApp)paramChatMessage;
      } while ((paramChatMessage == null) || (paramChatMessage.ark_app_message == null));
      localObject = (MessageForArkApp)ArkAppCenterCheckEvent.a(1, paramChatMessage.ark_app_message.appName, paramChatMessage, paramChatMessage);
      if (localObject != null) {
        break;
      }
    }
    while ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null))
    {
      paramInt = paramChatMessage.getMsgArkAppCount();
      localObject = new Intent();
      if (paramInt == 1)
      {
        paramContext = QQCustomArkDialog.AppInfo.a(paramChatMessage.ark_app_message.appName, paramChatMessage.ark_app_message.appView, paramChatMessage.ark_app_message.appMinVersion, paramChatMessage.ark_app_message.metaList, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null);
        ((Intent)localObject).putExtra("is_ark_display_share", true);
      }
      for (;;)
      {
        paramContext.putInt("forward_type", 27);
        paramContext.putString("forward_ark_app_name", paramChatMessage.ark_app_message.appName);
        paramContext.putString("forward_ark_app_view", paramChatMessage.ark_app_message.appView);
        paramContext.putString("forward_ark_app_ver", paramChatMessage.ark_app_message.appMinVersion);
        paramContext.putString("forward_ark_app_prompt", paramChatMessage.ark_app_message.promptText);
        paramContext.putString("forward_ark_app_config", paramChatMessage.ark_app_message.config);
        paramContext.putString("forward_ark_app_desc", paramChatMessage.ark_app_message.appDesc);
        paramContext.putString("forward_ark_app_compat", paramChatMessage.ark_app_message.compatibleText);
        paramContext.putString("forward_ark_app_meta", paramChatMessage.ark_app_message.metaList);
        ((Intent)localObject).putExtras(paramContext);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
        return;
        paramContext = new Bundle();
      }
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      super.a(paramChatMessage);
      return;
      super.c(paramChatMessage);
      return;
      paramChatMessage = (ChatMessage)localObject;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForArkApp)AIOUtils.a(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433618);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433619);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new urj(this, paramView), new urk(this)).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558621);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(d, jdField_b_of_type_Int, i, c);
      return;
    }
    paramView.setPadding(i, jdField_b_of_type_Int, d, c);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    Object localObject;
    int i;
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        localObject = new ArkAppMessage.Config();
        ((ArkAppMessage.Config)localObject).fromString(paramView.ark_app_message.config);
        if ((((ArkAppMessage.Config)localObject).forward == null) || (((ArkAppMessage.Config)localObject).forward.intValue() <= 0)) {
          break label290;
        }
        localObject = (Boolean)ArkAppCenterCheckEvent.a(0, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
        if ((localObject == null) || (((Boolean)localObject).booleanValue())) {
          break label285;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localQQCustomMenu.a(2131363499, this.jdField_a_of_type_AndroidContentContext.getString(2131435066), 2130838309);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView)))
      {
        localObject = (Boolean)ArkAppCenterCheckEvent.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
        if (localObject == null) {
          break label280;
        }
      }
      label280:
      for (boolean bool = ((Boolean)localObject).booleanValue();; bool = true)
      {
        if (bool) {
          a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
        }
        super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
        return localQQCustomMenu.a();
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
        return localQQCustomMenu.a();
      }
      label285:
      i = 1;
      continue;
      label290:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */