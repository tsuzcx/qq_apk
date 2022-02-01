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
      paramView = LayoutInflater.from(this.c).inflate(2131624484, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131434371);
      paramOnLongClickAndTouchListener = (TextView)paramView.findViewById(2131435014);
      TextView localTextView = (TextView)paramView.findViewById(2131435015);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      paramViewHolder.d = paramLinearLayout;
      paramViewHolder.e = paramOnLongClickAndTouchListener;
      paramViewHolder.f = localTextView;
      paramView.setTag(paramViewHolder);
    }
    else
    {
      paramViewHolder = (TroopLineTipsChatItemBuilder.Holder)paramView.getTag();
    }
    if (ThemeUtil.isInNightMode(this.a))
    {
      paramViewHolder.e.setBackgroundResource(2130843584);
      paramViewHolder.f.setBackgroundResource(2130843584);
    }
    else
    {
      paramViewHolder.e.setBackgroundResource(2130843583);
      paramViewHolder.f.setBackgroundResource(2130843583);
    }
    if ((paramMessageRecord.istroop == 1) && (AnonymousChatHelper.a().a(paramMessageRecord.senderuin))) {
      paramViewHolder.d.setTextColor(AnonymousChatHelper.d);
    } else {
      paramViewHolder.d.setTextColor(paramView.getResources().getColorStateList(2131165854));
    }
    if ((paramMessageRecord instanceof MessageForSplitLineTips))
    {
      paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      if (paramMessageRecord.subType != 1)
      {
        paramViewHolder.d.setText(paramMessageRecord.msgContent);
        return paramView;
      }
      paramViewHolder.d.setText(HardCodeUtil.a(2131912737));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopLineTipsChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */