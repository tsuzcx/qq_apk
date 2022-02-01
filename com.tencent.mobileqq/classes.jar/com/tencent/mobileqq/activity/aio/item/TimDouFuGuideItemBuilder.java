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
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (TimDouFuGuideItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.c).inflate(2131624483, null);
      paramLinearLayout.d = ((TextView)paramViewHolder.findViewById(2131447463));
      paramLinearLayout.e = ((TextView)paramViewHolder.findViewById(2131431322));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.d.setText(paramMessageRecord.tipsHighLight);
        paramView = new StringBuilder();
        paramView.append(paramMessageRecord.tipsMsg);
        paramView.append(HardCodeUtil.a(2131912244));
        paramView = new SpannableString(paramView.toString());
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(paramViewHolder.getResources().getColor(2131168008)), i - 4, i, 33);
        paramLinearLayout.e.setText(paramView);
        paramViewHolder.setOnClickListener(new TimDouFuGuideItemBuilder.1(this, paramMessageRecord));
      }
    }
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new TimDouFuGuideItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TimDouFuGuideItemBuilder
 * JD-Core Version:    0.7.0.1
 */