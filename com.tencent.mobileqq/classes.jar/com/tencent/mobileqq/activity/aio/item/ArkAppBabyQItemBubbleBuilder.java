package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAdapterItemInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ArkBabyqCardInfo.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import uua;
import uub;
import uuc;

public class ArkAppBabyQItemBubbleBuilder
  extends TextItemBuilder
{
  public ArkAppBabyQItemBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForArkBabyqReply localMessageForArkBabyqReply = (MessageForArkBabyqReply)paramChatMessage;
    if (localMessageForArkBabyqReply.showAsBabyq) {
      paramChatMessage.issend = 0;
    }
    boolean bool = paramChatMessage.isSend();
    BaseChatItemLayout localBaseChatItemLayout = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    if (localMessageForArkBabyqReply.showAsBabyq)
    {
      localBaseChatItemLayout.setHeaderIcon(a(localBaseChatItemLayout, 1, AppConstants.au));
      paramView = localBaseChatItemLayout.b();
      if ((paramView != null) && (paramView.getVisibility() == 0)) {
        paramView.setText("babyQ");
      }
    }
    ArkAppBabyQItemBubbleBuilder.ArkBabyQHolder localArkBabyQHolder = (ArkAppBabyQItemBubbleBuilder.ArkBabyQHolder)localBaseChatItemLayout.getTag();
    localArkBabyQHolder.e.setText(localMessageForArkBabyqReply.babyqReplyText);
    paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramView = new RelativeLayout.LayoutParams(-1, -2);
    paramView.addRule(3, 2131361877);
    paramView.width = -1;
    paramView.height = (BaseChatItemLayout.d + AIOUtils.a(29.0F, paramViewGroup));
    paramView.leftMargin = 0;
    localBaseChatItemLayout.setPadding(0, BaseChatItemLayout.u, 0, BaseChatItemLayout.h + BaseChatItemLayout.k);
    Object localObject = (RelativeLayout.LayoutParams)localBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
    label356:
    int j;
    int i;
    if (bool)
    {
      ((RelativeLayout.LayoutParams)localObject).rightMargin = BaseChatItemLayout.n;
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, localBaseChatItemLayout.a());
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramViewGroup.getDimensionPixelSize(2131558624);
      localBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((localBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        localObject = (RelativeLayout.LayoutParams)localBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.s;
        localBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((localBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (localBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8))
      {
        localObject = (RelativeLayout.LayoutParams)localBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        if (!bool) {
          break label800;
        }
        ((RelativeLayout.LayoutParams)localObject).rightMargin = BaseChatItemLayout.t;
        localBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      j = BaseChatItemLayout.n * 2 + AIOUtils.a(40.0F, paramViewGroup) + paramViewGroup.getDimensionPixelSize(2131558619);
      i = paramViewGroup.getDimensionPixelSize(2131558622);
      paramInt2 = BaseChatItemLayout.c - j - BaseChatItemLayout.d - i;
      if (!bool) {
        break label855;
      }
      paramInt1 = paramInt2;
      label419:
      if (!bool) {
        break label864;
      }
      paramInt2 = j - i;
      label430:
      if (localArkBabyQHolder.a != null) {
        break label867;
      }
      localObject = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      ((ArkHorizontalListView)localObject).d = (BaseChatItemLayout.c / 4);
      ((ArkHorizontalListView)localObject).setDividerWidth(i);
      paramViewGroup = new ArkHorizontalListViewAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkHorizontalListView)localObject, paramOnLongClickAndTouchListener);
      ((ArkHorizontalListView)localObject).setAdapter(paramViewGroup);
      localArkBabyQHolder.a = ((ArkHorizontalListView)localObject);
      localBaseChatItemLayout.addView(localArkBabyQHolder.a, paramView);
      label515:
      localArkBabyQHolder.a.setIsSend(bool);
      paramViewGroup.a(paramInt1, paramInt2);
      localArkBabyQHolder.jdField_b_of_type_JavaLangString = localMessageForArkBabyqReply.msg;
      j = localMessageForArkBabyqReply.getArkBabyqCardCount();
      paramInt1 = 0;
      label551:
      if (paramInt1 < j - 1)
      {
        paramView = localMessageForArkBabyqReply.getArkCardByPosition(paramInt1);
        paramOnLongClickAndTouchListener = localMessageForArkBabyqReply.getArkCardByPosition(paramInt1 + 1);
        if ((paramView == null) || (paramView.appName == null) || (paramOnLongClickAndTouchListener == null) || (paramOnLongClickAndTouchListener.appName == null) || (paramView.appName.equals(paramOnLongClickAndTouchListener.appName))) {
          break label893;
        }
        localMessageForArkBabyqReply.isSingleApp = false;
      }
      paramView = null;
      if (!localMessageForArkBabyqReply.isSingleApp) {
        break label911;
      }
      paramInt2 = Math.min(j, ArkRecommendController.f);
      paramViewGroup.a(paramViewGroup.a() - paramInt2);
      paramInt1 = 0;
      paramView = null;
      label662:
      paramOnLongClickAndTouchListener = paramView;
      if (paramInt1 >= paramInt2) {
        break label1081;
      }
      paramOnLongClickAndTouchListener = localMessageForArkBabyqReply.getArkCardByPosition(paramInt1);
      if ((ArkBabyqCardInfo)paramViewGroup.b(paramInt1) != null) {
        break label900;
      }
      paramViewGroup.a(paramOnLongClickAndTouchListener);
      label698:
      if ((paramOnLongClickAndTouchListener == null) || (TextUtils.isEmpty(paramOnLongClickAndTouchListener.appName)) || (!TextUtils.isEmpty(paramView))) {
        break label1308;
      }
      paramView = paramOnLongClickAndTouchListener.appName;
    }
    label900:
    label911:
    label1305:
    label1308:
    for (;;)
    {
      paramInt1 += 1;
      break label662;
      if ((localBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        paramInt1 = AIOUtils.a(30.0F, paramViewGroup);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = (BaseChatItemLayout.s + paramInt1);
        paramView.leftMargin = (paramInt1 - BaseChatItemLayout.s);
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.n;
      break;
      label800:
      if ((localBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = (AIOUtils.a(25.0F, localBaseChatItemLayout.getResources()) + BaseChatItemLayout.s);
        break label356;
      }
      ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.s;
      break label356;
      label855:
      paramInt1 = j - i;
      break label419;
      label864:
      break label430;
      label867:
      localArkBabyQHolder.a.setLayoutParams(paramView);
      paramViewGroup = (ArkHorizontalListViewAdapter)localArkBabyQHolder.a.a();
      break label515;
      label893:
      paramInt1 += 1;
      break label551;
      paramViewGroup.b(paramInt1, paramOnLongClickAndTouchListener);
      break label698;
      paramOnLongClickAndTouchListener = new HashMap();
      paramInt1 = 0;
      i = 0;
      if (i < j)
      {
        localObject = localMessageForArkBabyqReply.getArkCardByPosition(i);
        if (localObject != null) {
          if (paramOnLongClickAndTouchListener.containsKey(((ArkBabyqCardInfo)localObject).appName))
          {
            int k = ((Integer)paramOnLongClickAndTouchListener.get(((ArkBabyqCardInfo)localObject).appName)).intValue();
            if (k >= ArkRecommendController.g) {
              break label1292;
            }
            paramInt2 = 1;
            paramOnLongClickAndTouchListener.put(((ArkBabyqCardInfo)localObject).appName, Integer.valueOf(k + 1));
            label1005:
            if ((TextUtils.isEmpty(((ArkBabyqCardInfo)localObject).appName)) || (!TextUtils.isEmpty(paramView))) {
              break label1289;
            }
            paramView = ((ArkBabyqCardInfo)localObject).appName;
            if (paramInt2 == 0) {
              break label1305;
            }
            if ((ArkBabyqCardInfo)paramViewGroup.b(paramInt1) != null) {
              break label1269;
            }
            paramViewGroup.a((ArkAdapterItemInterface)localObject);
            label1054:
            paramInt1 += 1;
          }
        }
      }
      for (;;)
      {
        if (paramInt1 >= ArkRecommendController.f) {}
        for (;;)
        {
          paramViewGroup.a(paramViewGroup.a() - paramInt1);
          paramOnLongClickAndTouchListener = paramView;
          label1081:
          if ((!paramChatMessage.senderuin.equals(paramChatMessage.selfuin)) && (localArkBabyQHolder.jdField_b_of_type_Int == localArkBabyQHolder.c - 1) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
          {
            paramView = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
            if (paramView != null)
            {
              paramView = paramView.a().a;
              if (paramView != null) {
                paramView.a(1, paramOnLongClickAndTouchListener, paramChatMessage, null);
              }
            }
          }
          if (!localMessageForArkBabyqReply.mHasReportRecv)
          {
            ArkAppDataReport.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramOnLongClickAndTouchListener);
            localMessageForArkBabyqReply.mHasReportRecv = true;
            localMessageForArkBabyqReply.saveExtInfoToExtStr(MessageConstants.g, "1");
          }
          if (jdField_b_of_type_Boolean)
          {
            if ((localArkBabyQHolder.jdField_b_of_type_JavaLangStringBuilder != null) && (localArkBabyQHolder.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
              localArkBabyQHolder.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
            }
            paramChatMessage = a(localMessageForArkBabyqReply);
            localArkBabyQHolder.e.setContentDescription(paramChatMessage);
          }
          return localBaseChatItemLayout;
          paramInt2 = 1;
          paramOnLongClickAndTouchListener.put(((ArkBabyqCardInfo)localObject).appName, Integer.valueOf(1));
          break label1005;
          label1269:
          paramViewGroup.b(paramInt1, (ArkAdapterItemInterface)localObject);
          break label1054;
          i += 1;
          break;
          break label1031;
          paramInt2 = 0;
          break label1005;
          paramInt2 = 0;
          break label1031;
        }
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppBabyQItemBubbleBuilder.ArkBabyQHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return "";
    }
    MessageForArkBabyqReply localMessageForArkBabyqReply = (MessageForArkBabyqReply)paramChatMessage;
    if (TextUtils.isEmpty(localMessageForArkBabyqReply.babyqReplyText)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    localStringBuilder.append(localMessageForArkBabyqReply.babyqReplyText);
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
    case 2131363517: 
      do
      {
        return;
        paramChatMessage = (MessageForArkBabyqReply)paramChatMessage;
      } while (paramChatMessage == null);
      paramContext = new Bundle();
      paramContext.putInt("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramContext.putString("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramContext.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      paramContext.putInt("forward_type", 35);
      paramContext.putString("forward_text", paramChatMessage.getSummery());
      paramContext.putString("forward_ark_babyq_reply_rawcontent", paramChatMessage.toAppXml());
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
    case 2131375567: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.c(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    paramView = (MessageForArkBabyqReply)AIOUtils.a(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433635);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433636);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new uub(this, paramView), new uuc(this)).show();
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    Resources localResources = paramView.getResources();
    paramView = (TextItemBuilder.Holder)paramViewHolder;
    boolean bool = paramChatMessage.isSend();
    if ((paramBubbleInfo == null) || (paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramChatMessage = paramView.e;
      if (bool)
      {
        paramViewHolder = localResources.getColorStateList(2131494230);
        paramChatMessage.setTextColor(paramViewHolder);
        paramView = paramView.e;
        if (!bool) {
          break label99;
        }
        paramViewHolder = localResources.getColorStateList(2131494229);
        label81:
        paramView.setLinkTextColor(paramViewHolder);
      }
    }
    label99:
    do
    {
      return;
      paramViewHolder = localResources.getColorStateList(2131494227);
      break;
      paramViewHolder = localResources.getColorStateList(2131494228);
      break label81;
      if (paramBubbleInfo.jdField_b_of_type_Int == 0)
      {
        paramView.e.setTextColor(-16777216);
        if (paramBubbleInfo.c != 0) {
          break label261;
        }
      }
      for (paramViewHolder = localResources.getColorStateList(2131494228);; paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.c))
      {
        paramView.e.setLinkTextColor(paramViewHolder);
        if (!(paramView.e instanceof ETTextView)) {
          break;
        }
        if (!paramBubbleInfo.jdField_a_of_type_Boolean) {
          break label273;
        }
        ((ETTextView)paramView.e).setShadowLayer(3.0F, 0.0F, 0.0F, paramBubbleInfo.d);
        ((ETTextView)paramView.e).setStrokeColor(true, paramBubbleInfo.d);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramBubbleInfo.d);
        return;
        paramView.e.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        break label129;
      }
    } while ((!paramBubbleInfo.jdField_b_of_type_Boolean) || (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView.e.getCurrentTextColor(), 10000.0D * paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) != 1));
    label129:
    label261:
    label273:
    paramViewHolder = (ETTextView)paramView.e;
    float f2 = paramViewHolder.getTextSize() * 3.0F / 16.0F;
    float f1 = f2;
    if (f2 > 25.0F) {
      f1 = 25.0F;
    }
    paramViewHolder.setTextColor(-1);
    paramViewHolder.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.d);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    if (!((MessageForArkBabyqReply)paramChatMessage).showAsBabyq) {
      super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    }
    do
    {
      return;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, true);
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
      }
      if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
      {
        paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumWidth(AIOUtils.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false, false, paramViewHolder.jdField_a_of_type_AndroidViewView, AppConstants.au, 0);
      }
      if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
      {
        paramContext = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
        if (paramContext != null) {
          paramContext.setAlpha(jdField_a_of_type_Int);
        }
      }
      a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      a(paramViewHolder, paramChatMessage);
      if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag)) {
        jdField_a_of_type_AndroidOsHandler.post(new uua(this, paramViewHolder, paramChatMessage));
      }
      paramChatMessage.mAnimFlag = false;
    } while (paramViewHolder.jdField_a_of_type_AndroidViewView == null);
    paramBaseChatItemLayout.setBubbleView(paramViewHolder.jdField_a_of_type_AndroidViewView);
    a(paramViewHolder.jdField_a_of_type_AndroidViewView, paramChatMessage);
    paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131362293, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
    paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131362294, paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    if (((MessageForArkBabyqReply)paramChatMessage).showAsBabyq)
    {
      paramBaseChatItemLayout.setPendantImageVisible(false);
      return;
    }
    super.a(paramChatMessage, paramBaseChatItemLayout, paramInt1, paramInt2);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    int i;
    if (paramView != null)
    {
      paramView = (MessageForArkBabyqReply)paramView.a;
      if (paramView != null)
      {
        if (paramView.mArkBabyqReplyCardList == null) {
          break label266;
        }
        Iterator localIterator = paramView.mArkBabyqReplyCardList.iterator();
        i = 0;
        j = i;
        if (localIterator.hasNext())
        {
          Object localObject = (ArkBabyqCardInfo)localIterator.next();
          j = i;
          if (localObject == null) {
            break label224;
          }
          ArkBabyqCardInfo.Config localConfig = new ArkBabyqCardInfo.Config();
          localConfig.fromString(((ArkBabyqCardInfo)localObject).config);
          j = i;
          if (localConfig.forward == null) {
            break label224;
          }
          j = i;
          if (localConfig.forward.intValue() <= 0) {
            break label224;
          }
          localObject = (Boolean)ArkAppCenterCheckEvent.a(0, ((ArkBabyqCardInfo)localObject).appName, paramView, Boolean.valueOf(true));
          if ((localObject == null) || (((Boolean)localObject).booleanValue())) {
            break label261;
          }
          i = 0;
          label159:
          j = i;
          if (i == 0) {
            break label224;
          }
        }
      }
    }
    label261:
    label266:
    for (int j = i;; j = 0)
    {
      if (j != 0) {
        localQQCustomMenu.a(2131363517, this.jdField_a_of_type_AndroidContentContext.getString(2131435083), 2130838313);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
      label224:
      i = j;
      break;
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
      i = 1;
      break label159;
    }
  }
  
  protected void b(View paramView)
  {
    if (((MessageForArkBabyqReply)AIOUtils.a(paramView)).showAsBabyq)
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(AppConstants.au, 1);
      localAllInOne.h = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.au);
      localAllInOne.g = AppConstants.au;
      ProfileActivity.b(paramView.getContext(), localAllInOne);
      return;
    }
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppBabyQItemBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */