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
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class TroopUnreadTipsChatItemBuilder
  extends AbstractChatItemBuilder
{
  public TroopUnreadTipsChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (TroopUnreadTipsChatItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624484, null);
      paramViewHolder = (TextView)paramView.findViewById(2131434371);
      paramViewHolder.setMovementMethod(null);
      paramViewHolder.setGravity(17);
      paramViewHolder = paramView;
      if (ThemeUtil.isInNightMode(this.a))
      {
        paramViewHolder = (TextView)paramView.findViewById(2131435014);
        paramLinearLayout = (TextView)paramView.findViewById(2131435015);
        paramViewHolder.setBackgroundColor(2130843584);
        paramLinearLayout.setBackgroundColor(2130843584);
        paramViewHolder = paramView;
      }
    }
    paramView = (TextView)paramViewHolder.findViewById(2131434371);
    if ((paramMessageRecord.istroop == 1) && (AnonymousChatHelper.a().a(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(AnonymousChatHelper.d);
      return paramViewHolder;
    }
    paramView.setTextColor(paramViewHolder.getResources().getColorStateList(2131165854));
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new TroopUnreadTipsChatItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopUnreadTipsChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */