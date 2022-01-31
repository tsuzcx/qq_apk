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
import vfi;
import vfj;
import vfk;

public class ShakeItemBuilder
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  private long c = -1L;
  
  public ShakeItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vfi(this);
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
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131494227));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.e);
      ((TextView)localObject).setId(2131363575);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramViewHolder.addView((View)localObject, localLayoutParams);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = paramView;
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.n;
    int j = BaseChatItemLayout.o;
    int i = BaseChatItemLayout.n;
    localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842203);
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.o;
      j = BaseChatItemLayout.n;
      i = BaseChatItemLayout.o;
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842204);
    }
    localHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131433338));
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (b)
    {
      if ((localHolder.b != null) && (localHolder.b.length() > 0)) {
        localHolder.b.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L) {
        paramView.append(TimeFormatterUtils.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
      }
      if (!paramChatMessage.isSend()) {
        break label417;
      }
      paramView.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
    }
    for (;;)
    {
      paramViewHolder.setContentDescription(paramView.toString());
      return paramViewHolder;
      label417:
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("抖了你一下");
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShakeItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    if (paramChatMessage.isSend()) {
      localStringBuilder.append("我抖了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("抖了你一下");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131375567: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.c(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForShakeWindow)AIOUtils.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433635);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433636);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new vfj(this, paramView), new vfk(this)).show();
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    ShakeItemBuilder.Holder localHolder = (ShakeItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.a == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131494230);
        if (paramViewHolder != null) {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
        if (!paramChatMessage.isSend()) {
          break label90;
        }
      }
      label90:
      for (paramViewHolder = paramView.getColorStateList(2131494229);; paramViewHolder = paramView.getColorStateList(2131494228))
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131494227);
        break;
      }
    }
    if (paramBubbleInfo.b == 0) {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramBubbleInfo.c == 0)
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131494228));
      return;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.b);
    }
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder
 * JD-Core Version:    0.7.0.1
 */