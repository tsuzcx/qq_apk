package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
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
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongCalendarSyncUtil;
import cooperation.dingdong.DingdongMsgItemTitleImageView;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import cooperation.dingdong.DingdongPluginHelper;
import mqq.app.MobileQQ;
import ute;

public class DingdongScheduleItemBuilder
  extends BaseBubbleBuilder
{
  public DingdongScheduleItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void d(View paramView)
  {
    DingdongPluginHelper.a("0X800652B", 1);
    MessageForDingdongSchedule localMessageForDingdongSchedule = (MessageForDingdongSchedule)AIOUtils.a(paramView);
    if (localMessageForDingdongSchedule != null)
    {
      DingdongCalendarSyncUtil.a();
      Intent localIntent = new Intent();
      localIntent.putExtra("schedule_feed_id", localMessageForDingdongSchedule.getSummaryData().id);
      DingdongPluginHelper.a((Activity)paramView.getContext(), "com.dingdong.business.Schedule.Activity.ScheduleDetailActivity", localIntent, -1);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (ute)paramChatMessage.getTag();
    paramView.jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.d;
    if (b) {}
    try
    {
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.jdField_c_of_type_AndroidWidgetTextView.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.jdField_d_of_type_AndroidWidgetTextView.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131438293));
      paramChatMessage.setContentDescription(paramView.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramChatMessage;
    }
    catch (Exception paramView)
    {
      QLog.e("DingdongScheduleItemBuilder", 1, "getView. error:" + paramView.toString() + ".");
    }
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForDingdongSchedule localMessageForDingdongSchedule = (MessageForDingdongSchedule)paramChatMessage;
    ute localute = (ute)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968746, null);
      localute.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131361926));
      localute.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131363534));
      localute.e = ((TextView)paramViewHolder.findViewById(2131363537));
      localute.f = ((TextView)paramViewHolder.findViewById(2131363538));
      localute.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView = ((DingdongMsgItemTitleImageView)paramViewHolder.findViewById(2131363503));
      localute.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewHolder.findViewById(2131363533));
      localute.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131363531));
      localute.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131363532));
      localute.jdField_b_of_type_AndroidViewView = paramViewHolder.findViewById(2131363535);
      localute.jdField_c_of_type_AndroidViewView = paramViewHolder.findViewById(2131363539);
      localute.jdField_d_of_type_AndroidViewView = paramViewHolder.findViewById(2131363536);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnClickListener(this);
    }
    paramView = (LinearLayout.LayoutParams)localute.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramOnLongClickAndTouchListener = (RelativeLayout.LayoutParams)localute.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    label260:
    label372:
    int j;
    if (paramChatMessage.isSend())
    {
      i = 2130838170;
      paramView.leftMargin = 0;
      paramView.rightMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
      paramOnLongClickAndTouchListener.leftMargin = ((int)(16.0F * this.jdField_a_of_type_Float));
      paramChatMessage = paramBaseChatItemLayout.getContext();
      localute.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.destroyDrawingCache();
      localute.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.setBackgroundDrawable(paramChatMessage.getResources().getDrawable(i));
      localute.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.invalidate();
      localute.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramView);
      localute.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramOnLongClickAndTouchListener);
      localute.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
      localute.jdField_a_of_type_AndroidWidgetTextView.invalidate();
      if ((localMessageForDingdongSchedule.notificationType != 4) && (localMessageForDingdongSchedule.notificationType != 3)) {
        break label613;
      }
      localute.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.setReplaceColor(Color.rgb(128, 128, 128));
      localute.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.invalidate();
      localute.jdField_c_of_type_AndroidWidgetTextView.setText(localMessageForDingdongSchedule.getSummaryData().title);
      localute.jdField_d_of_type_AndroidWidgetTextView.setText(DingdongPluginHelper.a(localMessageForDingdongSchedule.getSummaryData().beginTime, localMessageForDingdongSchedule.getSummaryData().endTime, false));
      if (!TextUtils.isEmpty(localMessageForDingdongSchedule.getSummaryData().location)) {
        break label635;
      }
      localute.e.setVisibility(8);
      i = 0;
      label451:
      if (!TextUtils.isEmpty(localMessageForDingdongSchedule.getSummaryData().mark)) {
        break label689;
      }
      localute.f.setVisibility(8);
      label475:
      paramChatMessage = localute.jdField_b_of_type_AndroidViewView;
      if (i == 0) {
        break label720;
      }
      j = 0;
      label489:
      paramChatMessage.setVisibility(j);
      paramChatMessage = localute.jdField_c_of_type_AndroidViewView;
      if (i == 0) {
        break label726;
      }
      j = 0;
      label509:
      paramChatMessage.setVisibility(j);
      paramChatMessage = localute.jdField_d_of_type_AndroidViewView;
      if (i == 0) {
        break label733;
      }
    }
    label689:
    label720:
    label726:
    label733:
    for (int i = 0;; i = 8)
    {
      paramChatMessage.setVisibility(i);
      switch (localMessageForDingdongSchedule.notificationType)
      {
      default: 
        return paramViewHolder;
        i = 2130838169;
        paramView.leftMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
        paramView.rightMargin = 0;
        paramOnLongClickAndTouchListener.leftMargin = ((int)(24.0F * this.jdField_a_of_type_Float));
        break label260;
        label613:
        localute.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.setReplaceColor(Color.rgb(250, 165, 92));
        break label372;
        label635:
        localute.e.setVisibility(0);
        localute.e.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131438299), new Object[] { localMessageForDingdongSchedule.getSummaryData().location }));
        i = 1;
        break label451;
        localute.f.setVisibility(0);
        localute.f.setText(localMessageForDingdongSchedule.getSummaryData().mark);
        i = 1;
        break label475;
        j = 4;
        break label489;
        j = 8;
        break label509;
      }
    }
    localute.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    return paramViewHolder;
    localute.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localute.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131438296));
    return paramViewHolder;
    localute.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localute.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131438297));
    return paramViewHolder;
    localute.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localute.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131438297));
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ute(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131438301);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131438302);
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
  
  protected void a(View paramView) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.m = true;
    if (super.a()) {
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131361862: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DingdongScheduleItemBuilder
 * JD-Core Version:    0.7.0.1
 */