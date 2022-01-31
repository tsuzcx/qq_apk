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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import vkl;

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
      paramViewHolder = (vkl)paramViewHolder;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968788, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131363789);
      paramOnLongClickAndTouchListener = (TextView)paramView.findViewById(2131363801);
      TextView localTextView = (TextView)paramView.findViewById(2131363802);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramViewHolder.b = paramLinearLayout;
      paramViewHolder.c = paramOnLongClickAndTouchListener;
      paramViewHolder.d = localTextView;
      paramView.setTag(paramViewHolder);
      label92:
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label208;
      }
      paramViewHolder.c.setBackgroundResource(2130840579);
      paramViewHolder.d.setBackgroundResource(2130840579);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!AnonymousChatHelper.a().a(paramMessageRecord.senderuin))) {
        break label229;
      }
      paramViewHolder.b.setTextColor(AnonymousChatHelper.d);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        paramViewHolder.b.setText(paramMessageRecord.msgContent);
        return paramView;
        paramViewHolder = (vkl)paramView.getTag();
        break label92;
        label208:
        paramViewHolder.c.setBackgroundResource(2130840578);
        paramViewHolder.d.setBackgroundResource(2130840578);
        break label120;
        label229:
        paramViewHolder.b.setTextColor(paramView.getResources().getColorStateList(2131492892));
      }
    }
    paramViewHolder.b.setText("以上是历史消息");
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new vkl(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopLineTipsChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */