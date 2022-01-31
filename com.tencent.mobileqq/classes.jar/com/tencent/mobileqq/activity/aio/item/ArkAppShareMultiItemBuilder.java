package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAdapterItemInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.ark.ArkHorizontalListView.RefreshUiCallback;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
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
import uru;
import urv;

public class ArkAppShareMultiItemBuilder
  extends BaseBubbleBuilder
  implements ArkHorizontalListView.RefreshUiCallback
{
  public ArkAppShareMultiItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
    localLayoutParams.addRule(8, 2131361877);
    localLayoutParams.bottomMargin = paramInt2;
    if (paramBoolean)
    {
      localLayoutParams.addRule(5, 2131361877);
      localLayoutParams.leftMargin = paramInt3;
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(7, 2131361877);
      localLayoutParams.rightMargin = paramInt3;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (ArkAppShareMultiItemBuilder.ShareMultiHolder)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.a.getLayoutParams();
    paramOnLongClickAndTouchListener = paramChatMessage.b();
    if ((paramOnLongClickAndTouchListener != null) && (paramOnLongClickAndTouchListener.getVisibility() == 0)) {
      paramViewGroup.addRule(3, 2131361870);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.g;; paramViewGroup.topMargin = 0)
    {
      paramView.a.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      paramViewGroup.addRule(6, 2131361863);
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    boolean bool = localMessageForArkApp.isSend();
    ArkAppShareMultiItemBuilder.ShareMultiHolder localShareMultiHolder = (ArkAppShareMultiItemBuilder.ShareMultiHolder)paramViewHolder;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramViewHolder = new RelativeLayout.LayoutParams(-1, -2);
    paramViewHolder.width = -1;
    paramViewHolder.height = (BaseChatItemLayout.d + AIOUtils.a(29.0F, localResources));
    paramViewHolder.leftMargin = 0;
    paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.u, 0, BaseChatItemLayout.h + BaseChatItemLayout.k);
    Object localObject = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
    int i;
    label168:
    int j;
    label277:
    int k;
    int m;
    if (bool)
    {
      ((RelativeLayout.LayoutParams)localObject).rightMargin = BaseChatItemLayout.n;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramBaseChatItemLayout.b != null)
      {
        localObject = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams();
        i = AIOUtils.a(1.0F, localResources);
        if (!bool) {
          break label636;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131361863);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = (-i);
        paramBaseChatItemLayout.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        localObject = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.s;
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8))
      {
        localObject = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        if (!bool) {
          break label655;
        }
        ((RelativeLayout.LayoutParams)localObject).rightMargin = BaseChatItemLayout.t;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      i = BaseChatItemLayout.n;
      j = AIOUtils.a(40.0F, localResources);
      k = localResources.getDimensionPixelSize(2131558619) + (i * 2 + j);
      m = localResources.getDimensionPixelSize(2131558622);
      i = BaseChatItemLayout.jdField_c_of_type_Int - k - BaseChatItemLayout.d - m;
      if (!bool) {
        break label706;
      }
      j = i;
      label351:
      if (!bool) {
        break label716;
      }
      k -= m;
      label363:
      paramView = (ArkHorizontalListView)paramView;
      if (paramView != null) {
        break label723;
      }
      paramView = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      paramView.d = (BaseChatItemLayout.jdField_c_of_type_Int / 4);
      paramView.setDividerWidth(m);
      paramOnLongClickAndTouchListener = new ArkHorizontalListViewAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramOnLongClickAndTouchListener);
      paramView.setAdapter(paramOnLongClickAndTouchListener);
      label425:
      paramView.setIsSend(bool);
      paramOnLongClickAndTouchListener.a(j, k);
      paramView.setLayoutParams(paramViewHolder);
      paramView.setRefreshCallback(this);
      paramView.setTag(localShareMultiHolder);
      localShareMultiHolder.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      k = localMessageForArkApp.getMsgArkAppCount();
      paramOnLongClickAndTouchListener.a(paramOnLongClickAndTouchListener.a() - k);
      paramViewHolder = null;
      j = 0;
      label491:
      if (j >= k) {
        break label747;
      }
      localObject = localMessageForArkApp.getMsgArkAppByPosition(j);
      if ((MessageForArkApp)paramOnLongClickAndTouchListener.b(j) != null) {
        break label735;
      }
      paramOnLongClickAndTouchListener.a((ArkAdapterItemInterface)localObject);
      label527:
      if ((localObject == null) || (TextUtils.isEmpty(((MessageForArkApp)localObject).ark_app_message.appName)) || (!TextUtils.isEmpty(paramViewHolder))) {
        break label1009;
      }
      paramViewHolder = ((MessageForArkApp)localObject).ark_app_message.appName;
    }
    label655:
    label706:
    label716:
    label723:
    label735:
    label747:
    label1009:
    for (;;)
    {
      j += 1;
      break label491;
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        i = AIOUtils.a(30.0F, localResources);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = (BaseChatItemLayout.s + i);
        paramViewHolder.leftMargin = (i - BaseChatItemLayout.s);
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.n;
      break;
      label636:
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131361863);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = (-i);
      break label168;
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = (AIOUtils.a(25.0F, localResources) + BaseChatItemLayout.s);
        break label277;
      }
      ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.s;
      break label277;
      j = k - m;
      break label351;
      k = i;
      break label363;
      paramOnLongClickAndTouchListener = (ArkHorizontalListViewAdapter)paramView.a();
      break label425;
      paramOnLongClickAndTouchListener.b(j, (ArkAdapterItemInterface)localObject);
      break label527;
      a(paramView);
      if (paramOnLongClickAndTouchListener.a() == 1)
      {
        int n;
        if (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar != null)
        {
          j = AIOUtils.a(16.0F, localResources);
          k = AIOUtils.a(47.0F, localResources);
          m = localResources.getDimensionPixelSize(2131558619);
          n = BaseChatItemLayout.s;
          a(paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar, j, k, i - j - m - n, bool);
        }
        if (paramBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          j = AIOUtils.a(24.0F, localResources);
          k = AIOUtils.a(45.0F, localResources);
          m = localResources.getDimensionPixelSize(2131558619);
          n = BaseChatItemLayout.s;
          a(paramBaseChatItemLayout.jdField_c_of_type_AndroidWidgetImageView, j, k, i - j - m - n, bool);
        }
      }
      if (((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) && (localShareMultiHolder.jdField_b_of_type_Int == localShareMultiHolder.jdField_c_of_type_Int - 1))
      {
        paramBaseChatItemLayout = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (paramBaseChatItemLayout != null)
        {
          paramBaseChatItemLayout = paramBaseChatItemLayout.a().a;
          if (paramBaseChatItemLayout != null) {
            paramBaseChatItemLayout.a(2, paramViewHolder, paramChatMessage, null);
          }
        }
      }
      if (b)
      {
        if ((localShareMultiHolder.jdField_b_of_type_JavaLangStringBuilder != null) && (localShareMultiHolder.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
          localShareMultiHolder.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
        }
        paramView.setContentDescription(a(localMessageForArkApp));
      }
      return paramView;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppShareMultiItemBuilder.ShareMultiHolder();
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
      localObject = new Intent();
      if (paramChatMessage.getMsgArkAppCount() == 1)
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
      super.b(paramChatMessage);
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
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new uru(this, paramView), new urv(this)).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
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
    localViewHolder.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLocationOnScreen(arrayOfInt1);
    int j = arrayOfInt1[0];
    int m = localViewHolder.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getMeasuredWidth();
    int n = arrayOfInt1[1];
    int i1 = localViewHolder.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getMeasuredHeight();
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
      if ((localViewHolder.a.jdField_a_of_type_ComTencentImageURLImageView != null) && (localViewHolder.a.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
      {
        j = 1;
        label229:
        if ((i == 0) || (j != 0)) {
          break label441;
        }
        i = k;
        label240:
        if (i == 0) {
          break label462;
        }
        paramArkHorizontalListView = this.jdField_a_of_type_AndroidContentContext.getResources();
        i = AIOUtils.a(1.0F, paramArkHorizontalListView);
        if (localViewHolder.a.b == null)
        {
          localViewHolder.a.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localViewHolder.a.b.setScaleType(ImageView.ScaleType.FIT_XY);
          j = AIOUtils.a(42.0F, paramArkHorizontalListView);
          paramArkHorizontalListView = new RelativeLayout.LayoutParams(j, j);
          localViewHolder.a.addView(localViewHolder.a.b, paramArkHorizontalListView);
        }
        paramArkHorizontalListView = (RelativeLayout.LayoutParams)localViewHolder.a.b.getLayoutParams();
        paramArkHorizontalListView.addRule(6, 2131361863);
        paramArkHorizontalListView.topMargin = (-i);
        if (!localViewHolder.a.a()) {
          break label446;
        }
        paramArkHorizontalListView.addRule(7, 2131361863);
        paramArkHorizontalListView.rightMargin = (-i);
      }
      for (;;)
      {
        localViewHolder.a.b.setBackgroundResource(2130842198);
        localViewHolder.a.b.requestLayout();
        localViewHolder.a.b.setVisibility(0);
        return;
        i += 1;
        break;
        j = 0;
        break label229;
        label441:
        i = 0;
        break label240;
        label446:
        paramArkHorizontalListView.addRule(5, 2131361863);
        paramArkHorizontalListView.leftMargin = (-i);
      }
      label462:
      if (localViewHolder.a.b == null) {
        break;
      }
      localViewHolder.a.b.setVisibility(8);
      return;
    }
  }
  
  protected void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    if (paramChatMessage == null) {}
    while (((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000)) || (paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || (!paramChatMessage.isSupportReply()) || (!(paramChatMessage instanceof MessageForArkApp)) || (((MessageForArkApp)paramChatMessage).msg == null)) {
      return;
    }
    paramQQCustomMenu.a(2131375353, this.jdField_a_of_type_AndroidContentContext.getString(2131430723), 2130838312);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    int k = 0;
    boolean bool = true;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    int i;
    Object localObject;
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null) && (paramView.arkContainer.getErrorInfo() != null)) {
        if (paramView.arkContainer.getErrorInfo().retCode == -5)
        {
          i = 1;
          ArkAppCenter.b("ChatItemBuilder", String.format("getMenuItem, onLineState appName=%s,retCode=%d", new Object[] { paramView.ark_app_message.appName, Integer.valueOf(paramView.arkContainer.getErrorInfo().retCode) }));
          localObject = new ArkAppMessage.Config();
          ((ArkAppMessage.Config)localObject).fromString(paramView.ark_app_message.config);
          j = k;
          if (((ArkAppMessage.Config)localObject).forward != null)
          {
            j = k;
            if (((ArkAppMessage.Config)localObject).forward.intValue() > 0)
            {
              localObject = (Boolean)ArkAppCenterCheckEvent.a(0, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
              if ((localObject == null) || (((Boolean)localObject).booleanValue())) {
                break label380;
              }
            }
          }
        }
      }
    }
    label380:
    for (int j = k;; j = 1)
    {
      if ((j != 0) && (i == 0)) {
        localQQCustomMenu.a(2131363499, this.jdField_a_of_type_AndroidContentContext.getString(2131435066), 2130838309);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView)))
      {
        localObject = (Boolean)ArkAppCenterCheckEvent.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
        if (localObject != null) {
          bool = ((Boolean)localObject).booleanValue();
        }
        if (bool) {
          a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
        }
      }
      a(paramView, localQQCustomMenu);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
      i = 0;
      break;
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppShareMultiItemBuilder
 * JD-Core Version:    0.7.0.1
 */