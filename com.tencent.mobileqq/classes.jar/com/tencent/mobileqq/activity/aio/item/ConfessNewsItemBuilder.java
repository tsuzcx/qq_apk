package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
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
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.ConfessShareHelper;
import com.tencent.mobileqq.confess.TagUtils;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.util.Locale;

public class ConfessNewsItemBuilder
  extends AbstractChatItemBuilder
{
  public ConfessNewsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)paramMessageRecord;
    ConfessNewsItemBuilder.ConfessNewsViewHolder localConfessNewsViewHolder = (ConfessNewsItemBuilder.ConfessNewsViewHolder)paramViewHolder;
    if (paramView == null)
    {
      paramLinearLayout = LayoutInflater.from(this.c).inflate(2131624421, null);
      localConfessNewsViewHolder.f = ((TextView)paramLinearLayout.findViewById(2131447463));
      localConfessNewsViewHolder.g = ((TextView)paramLinearLayout.findViewById(2131431367));
      localConfessNewsViewHolder.h = ((TextView)paramLinearLayout.findViewById(2131446539));
      localConfessNewsViewHolder.d = paramLinearLayout.findViewById(2131431322);
      localConfessNewsViewHolder.e = ((ConfessNewsBgView)paramLinearLayout.findViewById(2131429397));
      localConfessNewsViewHolder.e.setPressMask(true);
      localConfessNewsViewHolder.e.setOnClickListener(new ConfessNewsItemBuilder.1(this));
    }
    else
    {
      paramLinearLayout = paramView;
    }
    localConfessNewsViewHolder.e.setTag(localMessageForConfessNews);
    localConfessNewsViewHolder.e.setBgType(localMessageForConfessNews.nBGType);
    localConfessNewsViewHolder.i = paramMessageRecord.uniseq;
    localConfessNewsViewHolder.j = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    if (paramMessageRecord.istroop == 1) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = this.a.getCurrentAccountUin().equals(localMessageForConfessNews.strConfessorUin);
    boolean bool2 = this.a.getCurrentAccountUin().equals(localMessageForConfessNews.strRecUin);
    if (bool2)
    {
      paramView = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { HardCodeUtil.a(2131900584) });
    }
    else
    {
      localObject1 = localMessageForConfessNews.strRecNick;
      paramView = (View)localObject1;
      if (i != 0) {
        if (localMessageForConfessNews.nRecNickType != 1)
        {
          paramView = (View)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
        else
        {
          localObject2 = ContactUtils.b(this.a, localMessageForConfessNews.strGroupUin, localMessageForConfessNews.strRecUin);
          paramView = (View)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramView = (View)localObject2;
          }
        }
      }
      localObject1 = paramView;
      if (paramView != null)
      {
        localObject1 = paramView;
        if (paramView.length() > 7) {
          localObject1 = ConfessShareHelper.a(paramView, 7.0F);
        }
      }
      paramView = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { localObject1 });
    }
    localConfessNewsViewHolder.f.setText(paramView);
    String str = localMessageForConfessNews.strConfessorDesc;
    float f = TagUtils.b(str);
    Object localObject1 = localMessageForConfessNews.strConfessorNick;
    if (bool1) {
      localObject1 = HardCodeUtil.a(2131900583);
    }
    long l = localMessageForConfessNews.confessTime;
    Object localObject2 = "";
    if (l > 0L) {
      localObject2 = TimeFormatterUtils.a(localMessageForConfessNews.confessTime * 1000L, true, "");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localMessageForConfessNews.nBizType == 1)
    {
      if (bool2)
      {
        localObject1 = HardCodeUtil.a(2131900588);
      }
      else
      {
        if (localMessageForConfessNews.nGetConfessSex == 1) {
          i = 2131900585;
        } else {
          i = 2131900586;
        }
        localObject1 = HardCodeUtil.a(i);
      }
      localStringBuilder.append(String.format(Locale.getDefault(), HardCodeUtil.a(2131900587), new Object[] { Integer.valueOf(localMessageForConfessNews.nConfessNum), localObject1 }));
    }
    else
    {
      localStringBuilder.append("来自");
      localStringBuilder.append((String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localStringBuilder.append(" | ");
        localStringBuilder.append((String)localObject2);
      }
    }
    localConfessNewsViewHolder.h.setText(localStringBuilder.toString());
    if (f > 8.0F)
    {
      localConfessNewsViewHolder.g.setTextSize(1, 21.0F);
      localConfessNewsViewHolder.g.setLineSpacing(0.0F, 1.2F);
      localObject1 = str;
      if (f <= 12.0F)
      {
        localObject1 = str;
        if (TagUtils.a(str))
        {
          double d = f;
          Double.isNaN(d);
          i = (int)(d * 0.7D);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str.substring(0, i));
          ((StringBuilder)localObject1).append("\n");
          ((StringBuilder)localObject1).append(str.substring(i, str.length()));
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    else
    {
      localConfessNewsViewHolder.g.setTextSize(1, 24.0F);
      localConfessNewsViewHolder.g.setLineSpacing(0.0F, 1.0F);
      localObject1 = str;
    }
    localConfessNewsViewHolder.g.setText((CharSequence)localObject1);
    if (v)
    {
      localObject2 = paramViewHolder.r;
      ((StringBuilder)localObject2).append(paramView);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(localStringBuilder.toString());
      paramLinearLayout.setContentDescription(paramViewHolder.r.toString());
    }
    localConfessNewsViewHolder.e.setTag(paramMessageRecord);
    localConfessNewsViewHolder.e.setOnTouchListener(paramOnLongClickAndTouchListener);
    localConfessNewsViewHolder.e.setOnLongClickListener(paramOnLongClickAndTouchListener);
    return paramLinearLayout;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new ConfessNewsItemBuilder.ConfessNewsViewHolder();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    a(paramView);
    return paramView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ConfessNewsItemBuilder
 * JD-Core Version:    0.7.0.1
 */