package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTimDouFuGuide;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class TimDouFuGuideItemBuilder
  extends AbstractChatItemBuilder
{
  public TimDouFuGuideItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (TimDouFuGuideItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.a).inflate(2131558965, null);
      paramLinearLayout.b = ((TextView)paramViewHolder.findViewById(2131379432));
      paramLinearLayout.c = ((TextView)paramViewHolder.findViewById(2131365294));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.b.setText(paramMessageRecord.tipsHighLight);
        paramView = new SpannableString(paramMessageRecord.tipsMsg + HardCodeUtil.a(2131714810));
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(paramViewHolder.getResources().getColor(2131167045)), i - 4, i, 33);
        paramLinearLayout.c.setText(paramView);
        paramViewHolder.setOnClickListener(new TimDouFuGuideItemBuilder.1(this, paramMessageRecord));
      }
    }
    return paramViewHolder;
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new TimDouFuGuideItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TimDouFuGuideItemBuilder
 * JD-Core Version:    0.7.0.1
 */