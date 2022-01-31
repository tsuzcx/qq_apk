package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
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
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.QLog;

public class GoldMsgPttItemBuilder
  extends PttItemBuilder
{
  public GoldMsgPttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    GoldMsgPttItemBuilder.GoldMsgPttHolder localGoldMsgPttHolder = (GoldMsgPttItemBuilder.GoldMsgPttHolder)paramViewHolder;
    if (QLog.isDevelopLevel()) {
      QLog.d("GoldMsgPttItemBuilder", 4, "getBubbleView mContent = " + paramView);
    }
    int j;
    int i;
    if (paramView == null)
    {
      paramViewHolder = super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      paramView = new LinearLayout((Context)localObject);
      paramView.setId(2131362399);
      paramView.setOrientation(1);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      paramBaseChatItemLayout = new LinearLayout((Context)localObject);
      paramBaseChatItemLayout.setOrientation(0);
      paramBaseChatItemLayout.setGravity(16);
      paramBaseChatItemLayout.setId(2131362398);
      paramBaseChatItemLayout.setOnClickListener(this);
      TextView localTextView = new TextView((Context)localObject);
      localTextView.setId(2131362397);
      localTextView.setSingleLine();
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextSize(2, 14.0F);
      localTextView.setMinHeight(GoldMsgChatHelper.g);
      localTextView.setGravity(16);
      localTextView.setTextColor(GoldMsgChatHelper.i);
      localTextView.setCompoundDrawablePadding(GoldMsgChatHelper.b);
      GoldMsgQueueView localGoldMsgQueueView = new GoldMsgQueueView((Context)localObject);
      localGoldMsgQueueView.setId(2131362401);
      localObject = new TextView((Context)localObject);
      ((TextView)localObject).setId(2131362402);
      ((TextView)localObject).setSingleLine();
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setTextSize(2, 14.0F);
      ((TextView)localObject).setTextColor(GoldMsgChatHelper.j);
      ((TextView)localObject).setText("暂无人领取");
      localGoldMsgQueueView.setLayoutParams(new LinearLayout.LayoutParams(GoldMsgChatHelper.f, GoldMsgChatHelper.g));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, 0, GoldMsgChatHelper.c, 0);
      localTextView.setLayoutParams(localLayoutParams);
      ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      paramBaseChatItemLayout.addView(localTextView);
      paramBaseChatItemLayout.addView(localGoldMsgQueueView);
      paramBaseChatItemLayout.addView((View)localObject);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 3;
      paramBaseChatItemLayout.setLayoutParams(localLayoutParams);
      paramView.addView(paramViewHolder);
      paramView.addView(paramBaseChatItemLayout);
      localGoldMsgPttHolder.jdField_b_of_type_AndroidViewView = paramViewHolder;
      localGoldMsgPttHolder.jdField_a_of_type_AndroidWidgetLinearLayout = paramView;
      localGoldMsgPttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView = localGoldMsgQueueView;
      localGoldMsgPttHolder.jdField_b_of_type_AndroidWidgetLinearLayout = paramBaseChatItemLayout;
      localGoldMsgPttHolder.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      localGoldMsgPttHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject);
      GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localGoldMsgPttHolder.jdField_a_of_type_AndroidWidgetTextView, localGoldMsgPttHolder.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView, localGoldMsgPttHolder.jdField_b_of_type_AndroidWidgetTextView, paramChatMessage);
      localGoldMsgPttHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
      localGoldMsgPttHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder = new LinearLayout.LayoutParams(-2, -2);
      if (!paramChatMessage.isSend()) {
        break label591;
      }
      j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.n + GoldMsgChatHelper.h;
    }
    for (paramViewHolder.gravity = 5;; paramViewHolder.gravity = 3)
    {
      localGoldMsgPttHolder.jdField_b_of_type_AndroidViewView.setLayoutParams(paramViewHolder);
      localGoldMsgPttHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(j, GoldMsgChatHelper.e, i, GoldMsgChatHelper.e);
      localGoldMsgPttHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setTag(paramChatMessage);
      GoldMsgChatHelper.a().a(paramChatMessage);
      return localGoldMsgPttHolder.jdField_a_of_type_AndroidWidgetLinearLayout;
      localGoldMsgPttHolder.jdField_b_of_type_AndroidViewView = super.a(paramChatMessage, paramViewHolder, localGoldMsgPttHolder.jdField_b_of_type_AndroidViewView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      break;
      label591:
      i = BaseChatItemLayout.n;
      j = GoldMsgChatHelper.h + i;
      i = BaseChatItemLayout.o;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new GoldMsgPttItemBuilder.GoldMsgPttHolder();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramInt == 890)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof GoldMsgPttItemBuilder.GoldMsgPttHolder))
      {
        paramView = (GoldMsgPttItemBuilder.GoldMsgPttHolder)paramView;
        GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.jdField_a_of_type_AndroidWidgetTextView, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView, paramView.jdField_b_of_type_AndroidWidgetTextView, paramChatMessage);
      }
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo, int paramInt) {}
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo) {}
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    super.a(paramHolder, paramMessageForPtt, paramInt, paramBoolean);
    paramHolder.c.setTextColor(-1);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout) {}
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramContext = (GoldMsgPttItemBuilder.GoldMsgPttHolder)paramViewHolder;
    if (paramChatMessage.isSend())
    {
      paramContext.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130843988);
      return;
    }
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130843987);
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean, PttItemBuilder.Holder paramHolder)
  {
    if (paramMessageForPtt.isSend())
    {
      paramMessageForPtt = paramHolder.a;
      if (paramBoolean) {}
      for (i = 2130845643;; i = 2130843783)
      {
        paramMessageForPtt.setImageResource(i);
        return;
      }
    }
    paramMessageForPtt = paramHolder.a;
    if (paramBoolean) {}
    for (int i = 2130843780;; i = 2130843779)
    {
      paramMessageForPtt.setImageResource(i);
      return;
    }
  }
  
  protected void a(MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PttItemBuilder.Holder paramHolder)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if ((paramBoolean1) && (!paramBoolean2))
    {
      int i;
      if (paramMessageForPtt.isSend()) {
        if (paramBoolean3) {
          i = 2131034207;
        }
      }
      for (;;)
      {
        paramMessageForPtt = (AnimationDrawable)localResources.getDrawable(i);
        paramHolder.a.setImageDrawable(paramMessageForPtt);
        paramMessageForPtt.start();
        return;
        i = 2131034362;
        continue;
        if (paramBoolean3) {
          i = 2131034361;
        } else {
          i = 2131034360;
        }
      }
    }
    a(paramMessageForPtt, paramBoolean3, paramHolder);
  }
  
  protected boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, BaseBubbleBuilder.ViewHolder paramViewHolder, MessageForPtt paramMessageForPtt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GoldMsgPttItemBuilder
 * JD-Core Version:    0.7.0.1
 */