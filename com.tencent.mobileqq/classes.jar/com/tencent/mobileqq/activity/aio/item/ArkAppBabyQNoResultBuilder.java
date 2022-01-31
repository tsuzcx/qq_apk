package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.util.ArrayList;
import urb;
import urc;
import urd;
import ure;

public class ArkAppBabyQNoResultBuilder
  extends BaseBubbleBuilder
{
  public ArkAppBabyQNoResultBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(LinearLayout paramLinearLayout, String paramString, boolean paramBoolean)
  {
    int i = 0;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setText(paramString);
    ((TextView)localObject1).setTextColor(localResources.getColor(2131492879));
    ((TextView)localObject1).setTextSize(2, 18.0F);
    ((TextView)localObject1).setGravity(51);
    int j = AIOUtils.a(14.0F, localResources);
    ((TextView)localObject1).setPadding(j, j, 0, j);
    paramLinearLayout.addView((View)localObject1, new LinearLayout.LayoutParams(-1, -2));
    if (!paramBoolean)
    {
      if ((ArkRecommendController.a == null) || (ArkRecommendController.a.size() <= 0)) {
        paramString = localResources.getStringArray(2131296324);
      }
      while (i < paramString.length)
      {
        localObject1 = paramString[i];
        Object localObject2 = new View(this.jdField_a_of_type_AndroidContentContext);
        ((View)localObject2).setBackgroundResource(2131493225);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.height = 1;
        paramLinearLayout.addView((View)localObject2, localLayoutParams);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setTextColor(localResources.getColor(2131494017));
        ((TextView)localObject2).setTextSize(2, 16.0F);
        ((TextView)localObject2).setGravity(17);
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject1).height = AIOUtils.a(40.0F, localResources);
        paramLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C)) {
          ((TextView)localObject2).setOnClickListener(new urb(this, i));
        }
        i += 1;
        continue;
        paramString = (String[])ArkRecommendController.a.toArray(new String[ArkRecommendController.a.size()]);
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage.issend = 0;
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (BaseChatItemLayout)paramView;
    paramOnLongClickAndTouchListener = (ArkAppBabyQNoResultBuilder.ArkBabyQNoResultHolder)paramViewGroup.getTag();
    paramChatMessage = (MessageForArkBabyqReply)paramChatMessage;
    if (!paramChatMessage.mHasReportRecv)
    {
      ArkAppDataReport.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "");
      ArkAppDataReport.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramChatMessage.mHasReportRecv = true;
      paramChatMessage.saveExtInfoToExtStr(MessageConstants.g, "1");
    }
    if (b)
    {
      if ((paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder != null) && (paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
        paramOnLongClickAndTouchListener.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
      }
      paramView.setContentDescription(a(paramChatMessage));
    }
    return paramViewGroup;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForArkBabyqReply localMessageForArkBabyqReply = (MessageForArkBabyqReply)paramChatMessage;
    paramViewHolder = (ArkAppBabyQNoResultBuilder.ArkBabyQNoResultHolder)paramViewHolder;
    paramBaseChatItemLayout.setHeaderIcon(a(paramBaseChatItemLayout, 1, AppConstants.au));
    paramChatMessage = (LinearLayout)paramView;
    if (paramChatMessage == null)
    {
      paramChatMessage = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setOrientation(1);
    }
    for (;;)
    {
      a(paramChatMessage, localMessageForArkBabyqReply.babyqReplyText, localMessageForArkBabyqReply.isFailed);
      paramViewHolder.jdField_b_of_type_JavaLangString = localMessageForArkBabyqReply.msg;
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.a = paramOnLongClickAndTouchListener;
      return paramChatMessage;
      paramChatMessage.removeAllViews();
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppBabyQNoResultBuilder.ArkBabyQNoResultHolder();
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
      return;
    case 2131375336: 
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
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433618);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433619);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new urd(this, paramView), new ure(this)).show();
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getResources();
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, true);
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
    }
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumWidth(AIOUtils.a(65.0F, paramContext));
      paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(AIOUtils.a(57.0F, paramContext));
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, false, false, paramViewHolder.jdField_a_of_type_AndroidViewView, AppConstants.au, 0);
    }
    Object localObject;
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setAlpha(jdField_a_of_type_Int);
      }
    }
    a(paramViewHolder, paramChatMessage);
    if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag)) {
      jdField_a_of_type_AndroidOsHandler.post(new urc(this, paramViewHolder, paramChatMessage));
    }
    paramChatMessage.mAnimFlag = false;
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = paramBaseChatItemLayout.a();
      if (localObject != paramViewHolder.jdField_a_of_type_AndroidViewView)
      {
        paramBaseChatItemLayout.removeView((View)localObject);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131361863);
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131361863);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
        paramInt1 = paramContext.getDimensionPixelSize(2131558619);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt1;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
        ((RelativeLayout.LayoutParams)localObject).width = BaseChatItemLayout.d;
        paramBaseChatItemLayout.addView(paramViewHolder.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        paramBaseChatItemLayout.a(paramViewHolder.jdField_a_of_type_AndroidViewView);
      }
      a(paramViewHolder.jdField_a_of_type_AndroidViewView, paramChatMessage);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131362293, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131362294, paramChatMessage);
    }
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    paramBaseChatItemLayout.setPendantImageVisible(false);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if ((paramView != null) && ((MessageForArkBabyqReply)paramView.a != null))
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
  
  protected void b(View paramView)
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(AppConstants.au, 1);
    localAllInOne.h = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.au);
    localAllInOne.g = AppConstants.au;
    ProfileActivity.b(paramView.getContext(), localAllInOne);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppBabyQNoResultBuilder
 * JD-Core Version:    0.7.0.1
 */