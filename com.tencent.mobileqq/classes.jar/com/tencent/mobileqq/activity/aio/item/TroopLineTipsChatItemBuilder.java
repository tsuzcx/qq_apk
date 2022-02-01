package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class TroopLineTipsChatItemBuilder
  extends AbstractChatItemBuilder
{
  public TroopLineTipsChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramView == null)
    {
      paramViewHolder = (TroopLineTipsChatItemBuilder.Holder)paramViewHolder;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558864, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131367798);
      paramOnLongClickAndTouchListener = (TextView)paramView.findViewById(2131368157);
      TextView localTextView = (TextView)paramView.findViewById(2131368158);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramViewHolder.b = paramLinearLayout;
      paramViewHolder.c = paramOnLongClickAndTouchListener;
      paramViewHolder.d = localTextView;
      paramView.setTag(paramViewHolder);
    }
    else
    {
      paramViewHolder = (TroopLineTipsChatItemBuilder.Holder)paramView.getTag();
    }
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      paramViewHolder.c.setBackgroundResource(2130842631);
      paramViewHolder.d.setBackgroundResource(2130842631);
    }
    else
    {
      paramViewHolder.c.setBackgroundResource(2130842630);
      paramViewHolder.d.setBackgroundResource(2130842630);
    }
    if ((paramMessageRecord.istroop == 1) && (AnonymousChatHelper.a().a(paramMessageRecord.senderuin))) {
      paramViewHolder.b.setTextColor(AnonymousChatHelper.d);
    } else {
      paramViewHolder.b.setTextColor(paramView.getResources().getColorStateList(2131165527));
    }
    if ((paramMessageRecord instanceof MessageForSplitLineTips))
    {
      paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      if (paramMessageRecord.subType != 1)
      {
        paramViewHolder.b.setText(paramMessageRecord.msgContent);
        return paramView;
      }
      paramViewHolder.b.setText(HardCodeUtil.a(2131715255));
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new TroopLineTipsChatItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopLineTipsChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */