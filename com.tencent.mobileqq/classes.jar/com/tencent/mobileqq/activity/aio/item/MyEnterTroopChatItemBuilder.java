package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class MyEnterTroopChatItemBuilder
  extends AbstractChatItemBuilder
{
  public MyEnterTroopChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MyEnterTroopChatItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.a).inflate(2131558963, null);
      paramLinearLayout.b = ((TextView)paramViewHolder.findViewById(2131368045));
    }
    paramLinearLayout.b.setMovementMethod(null);
    paramLinearLayout.b.setGravity(17);
    if ((paramMessageRecord instanceof MessageForMyEnterTroop))
    {
      paramMessageRecord = (MessageForMyEnterTroop)paramMessageRecord;
      paramMessageRecord = this.a.getString(2131697201);
      paramLinearLayout.b.setText(paramMessageRecord);
      paramView = this.a.getResources().getColorStateList(2131165442);
      if (paramView != null) {
        paramLinearLayout.b.setTextColor(paramView);
      }
      paramViewHolder.setContentDescription(paramMessageRecord);
    }
    return paramViewHolder;
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new MyEnterTroopChatItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MyEnterTroopChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */