package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class ShakeItemBuilder
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  private long c = -1L;
  
  public ShakeItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ShakeItemBuilder.1(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    ShakeItemBuilder.Holder localHolder = (ShakeItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new LinearLayout(paramBaseChatItemLayout);
      paramViewHolder.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131167075));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.f);
      ((TextView)localObject).setId(2131364524);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramViewHolder.addView((View)localObject, localLayoutParams);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int i = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    int k = BaseChatItemLayout.o;
    localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844829);
    if (paramChatMessage.isSend())
    {
      i = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
      k = BaseChatItemLayout.p;
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844830);
    }
    localHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131718860));
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (e)
    {
      if ((localHolder.b != null) && (localHolder.b.length() > 0)) {
        localHolder.b.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L)
      {
        paramView.append(TimeFormatterUtils.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L));
        paramView.append(" ");
      }
      if (paramChatMessage.isSend())
      {
        paramView.append("我抖了");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        paramView.append("一下");
      }
      else
      {
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        paramView.append("抖了你一下");
      }
      paramViewHolder.setContentDescription(paramView.toString());
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShakeItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L)
    {
      localStringBuilder.append(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L));
      localStringBuilder.append(" ");
    }
    if (paramChatMessage.isSend())
    {
      localStringBuilder.append("我抖了");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      localStringBuilder.append("一下");
    }
    else
    {
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      localStringBuilder.append("抖了你一下");
    }
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      if (paramInt != 2131371603) {
        return;
      }
      super.a(paramInt, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShakeWindow)AIOUtils.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689933);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689934);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ShakeItemBuilder.2(this, paramView), new ShakeItemBuilder.3(this)).show();
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    ShakeItemBuilder.Holder localHolder = (ShakeItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.a()))
    {
      if (paramBubbleInfo.b == 0) {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      } else {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.b);
      }
      if (paramBubbleInfo.c == 0)
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167077));
        return;
      }
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
      return;
    }
    paramViewHolder = paramView.getResources();
    int i;
    if (paramChatMessage.isSend()) {
      i = 2131167079;
    } else {
      i = 2131167075;
    }
    paramView = paramViewHolder.getColorStateList(i);
    if (paramView != null) {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
    }
    if (paramChatMessage.isSend()) {
      paramViewHolder = paramViewHolder.getColorStateList(2131167078);
    } else {
      paramViewHolder = paramViewHolder.getColorStateList(2131167077);
    }
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder
 * JD-Core Version:    0.7.0.1
 */