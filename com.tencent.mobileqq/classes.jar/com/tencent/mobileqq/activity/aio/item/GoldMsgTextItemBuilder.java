package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgQueueView;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class GoldMsgTextItemBuilder
  extends TextItemBuilder
{
  public GoldMsgTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = paramBaseChatItemLayout.getContext();
    GoldMsgTextItemBuilder.GoldMsgTextHolder localGoldMsgTextHolder = (GoldMsgTextItemBuilder.GoldMsgTextHolder)paramViewHolder;
    if (QLog.isDevelopLevel()) {
      QLog.d("GoldMsgTextItemBuilder", 4, "getBubbleView mContent = " + paramView);
    }
    int j;
    if (paramView == null)
    {
      paramViewHolder = super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      paramView = new RelativeLayout((Context)localObject1);
      paramView.setId(2131362402);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      paramBaseChatItemLayout = new LinearLayout((Context)localObject1);
      paramBaseChatItemLayout.setOrientation(0);
      paramBaseChatItemLayout.setGravity(16);
      paramBaseChatItemLayout.setId(2131362401);
      paramBaseChatItemLayout.setOnClickListener(this);
      TextView localTextView = new TextView((Context)localObject1);
      localTextView.setId(2131362400);
      localTextView.setSingleLine();
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextSize(2, 14.0F);
      localTextView.setMinHeight(GoldMsgChatHelper.g);
      localTextView.setGravity(16);
      localTextView.setTextColor(GoldMsgChatHelper.i);
      localTextView.setCompoundDrawablePadding(GoldMsgChatHelper.b);
      GoldMsgQueueView localGoldMsgQueueView = new GoldMsgQueueView((Context)localObject1);
      localGoldMsgQueueView.setId(2131362404);
      localObject1 = new TextView((Context)localObject1);
      ((TextView)localObject1).setId(2131362405);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextSize(2, 14.0F);
      ((TextView)localObject1).setTextColor(GoldMsgChatHelper.j);
      ((TextView)localObject1).setText("暂无人领取");
      localGoldMsgQueueView.setLayoutParams(new LinearLayout.LayoutParams(GoldMsgChatHelper.f, GoldMsgChatHelper.g));
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, GoldMsgChatHelper.c, 0);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((TextView)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      paramBaseChatItemLayout.addView(localTextView);
      paramBaseChatItemLayout.addView(localGoldMsgQueueView);
      paramBaseChatItemLayout.addView((View)localObject1);
      paramViewHolder.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      paramView.addView(paramViewHolder);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, paramViewHolder.getId());
      paramBaseChatItemLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramView.addView(paramBaseChatItemLayout);
      localGoldMsgTextHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = paramView;
      localGoldMsgTextHolder.jdField_a_of_type_AndroidWidgetLinearLayout = paramBaseChatItemLayout;
      localGoldMsgTextHolder.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      localGoldMsgTextHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView = localGoldMsgQueueView;
      localGoldMsgTextHolder.jdField_b_of_type_AndroidViewView = paramViewHolder;
      localGoldMsgTextHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      localGoldMsgTextHolder.e.setTextColor(-1);
      GoldMsgChatHelper.a(this.a, localGoldMsgTextHolder.jdField_a_of_type_AndroidWidgetTextView, localGoldMsgTextHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView, localGoldMsgTextHolder.jdField_b_of_type_AndroidWidgetTextView, paramChatMessage);
      localGoldMsgTextHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
      localGoldMsgTextHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if (!paramChatMessage.isSend()) {
        break label606;
      }
      j = BaseChatItemLayout.o;
    }
    for (int i = BaseChatItemLayout.n + GoldMsgChatHelper.h;; i = BaseChatItemLayout.o)
    {
      localGoldMsgTextHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(j, GoldMsgChatHelper.e, i, GoldMsgChatHelper.e);
      localGoldMsgTextHolder.e.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
      localGoldMsgTextHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramChatMessage);
      GoldMsgChatHelper.a().a(paramChatMessage);
      return localGoldMsgTextHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
      localGoldMsgTextHolder.jdField_b_of_type_AndroidViewView = super.a(paramChatMessage, paramViewHolder, localGoldMsgTextHolder.jdField_b_of_type_AndroidViewView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      break;
      label606:
      i = BaseChatItemLayout.n;
      j = GoldMsgChatHelper.h + i;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new GoldMsgTextItemBuilder.GoldMsgTextHolder();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramInt == 890)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof GoldMsgTextItemBuilder.GoldMsgTextHolder))
      {
        paramView = (GoldMsgTextItemBuilder.GoldMsgTextHolder)paramView;
        GoldMsgChatHelper.a(this.a, paramView.jdField_a_of_type_AndroidWidgetTextView, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView, paramView.jdField_b_of_type_AndroidWidgetTextView, paramChatMessage);
      }
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo) {}
  
  protected void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout) {}
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramContext = (GoldMsgTextItemBuilder.GoldMsgTextHolder)paramViewHolder;
    if (paramChatMessage.isSend())
    {
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844178);
      return;
    }
    paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GoldMsgTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */