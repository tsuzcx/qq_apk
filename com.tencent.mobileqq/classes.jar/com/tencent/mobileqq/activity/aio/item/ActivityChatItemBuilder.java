package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ActivityChatItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener
{
  protected String e;
  
  public ActivityChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = (ActivityChatItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.c).inflate(2131625909, null);
      paramOnLongClickAndTouchListener.d = ((TextView)paramViewHolder.findViewById(2131430576));
      paramOnLongClickAndTouchListener.e = ((TextView)paramViewHolder.findViewById(2131430575));
      paramOnLongClickAndTouchListener.f = ((TextView)paramViewHolder.findViewById(2131430574));
      paramOnLongClickAndTouchListener.g = ((ImageView)paramViewHolder.findViewById(2131430572));
      paramViewHolder.setOnClickListener(this);
      paramOnLongClickAndTouchListener.d.setOnClickListener(this);
      paramOnLongClickAndTouchListener.e.setOnClickListener(this);
      paramOnLongClickAndTouchListener.f.setOnClickListener(this);
      paramOnLongClickAndTouchListener.g.setOnClickListener(this);
    }
    if ((paramMessageRecord instanceof MessageForActivity))
    {
      paramLinearLayout = (MessageForActivity)paramMessageRecord;
      paramOnLongClickAndTouchListener.d.setText(HardCodeUtil.a(2131898056));
      paramOnLongClickAndTouchListener.e.setText(paramLinearLayout.title);
      a(paramLinearLayout.summary, paramOnLongClickAndTouchListener.f);
    }
    try
    {
      paramMessageRecord = URLDrawable.getDrawable(paramLinearLayout.bigPic, paramViewHolder.getResources().getDrawable(2130843540), paramViewHolder.getResources().getDrawable(2130843539));
      paramOnLongClickAndTouchListener.g.setBackgroundDrawable(paramMessageRecord);
    }
    catch (Exception paramMessageRecord)
    {
      label215:
      boolean bool;
      break label215;
    }
    paramOnLongClickAndTouchListener.g.setBackgroundResource(2130843539);
    this.e = paramLinearLayout.url;
    if (v)
    {
      bool = TextUtils.isEmpty(paramLinearLayout.title);
      paramView = "";
      if (bool) {
        paramMessageRecord = "";
      } else {
        paramMessageRecord = paramLinearLayout.title;
      }
      paramOnLongClickAndTouchListener = new StringBuilder();
      paramOnLongClickAndTouchListener.append(paramMessageRecord);
      if (TextUtils.isEmpty(paramLinearLayout.summary)) {
        paramMessageRecord = paramView;
      } else {
        paramMessageRecord = paramLinearLayout.summary;
      }
      paramOnLongClickAndTouchListener.append(paramMessageRecord);
      paramViewHolder.setContentDescription(paramOnLongClickAndTouchListener.toString());
    }
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new ActivityChatItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(String paramString, TextView paramTextView)
  {
    paramTextView.getViewTreeObserver().addOnPreDrawListener(new ActivityChatItemBuilder.1(this, paramTextView, paramString));
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    TroopQQBrowserHelper.a(this.c, this.e, this.a.getCurrentAccountUin());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ActivityChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */