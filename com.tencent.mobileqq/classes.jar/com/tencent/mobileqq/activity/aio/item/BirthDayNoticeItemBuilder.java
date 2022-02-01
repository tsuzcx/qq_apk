package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.vip.manager.MonitorManager;

public class BirthDayNoticeItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener
{
  private static final String e = HardCodeUtil.a(2131899378);
  private ForegroundColorSpan f = new ForegroundColorSpan(Color.parseColor("#883353"));
  private long g = 0L;
  
  public BirthDayNoticeItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, BirthDayNoticeItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624419, null);
      paramHolder.d = paramView;
      paramHolder.e = paramView.findViewById(2131427935);
      paramHolder.f = paramView.findViewById(2131427934);
      paramHolder.g = ((URLImageView)paramView.findViewById(2131427937));
      paramHolder.h = ((TextView)paramView.findViewById(2131427938));
      paramHolder.i = ((TextView)paramView.findViewById(2131427936));
      localView = paramView;
      if (v)
      {
        paramHolder.r = new StringBuilder();
        localView = paramView;
      }
    }
    if (v)
    {
      localView.setContentDescription(null);
      paramHolder.r.replace(0, paramHolder.r.length(), "");
    }
    return localView;
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    long l1;
    if ((paramMessageRecord != null) && (!AIOSingleReporter.a().a(paramMessageRecord, "aio_msg|birthday_notice")))
    {
      AIOSingleReporter.a().b(paramMessageRecord, "aio_msg|birthday_notice");
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramMessageRecord.frienduin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label42:
      Object localObject;
      StringBuilder localStringBuilder;
      break label42;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error parse friend uin ");
    ((StringBuilder)localObject).append(paramMessageRecord);
    QLog.e("BirthDayNoticeItemBuilder", 1, ((StringBuilder)localObject).toString());
    localObject = MonitorManager.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" error parse friend uin ");
    localStringBuilder.append(paramMessageRecord);
    ((MonitorManager)localObject).a(19, 10, localStringBuilder.toString(), false);
    paramMessageRecord = new LpReportInfo_pf00064();
    paramMessageRecord.actionType = 91;
    paramMessageRecord.subactionType = 22;
    paramMessageRecord.reserves = 1;
    paramMessageRecord.toUin = l1;
    LpReportManager.getInstance().reportToPF00064(paramMessageRecord, false, false);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramMessageRecord = (MessageForBirthdayNotice)paramMessageRecord;
    paramViewHolder = (BirthDayNoticeItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    try
    {
      paramViewHolder.g.setBackgroundURL(paramMessageRecord.icon);
      paramViewHolder.f.setBackgroundColor(Color.parseColor(paramMessageRecord.background));
    }
    catch (Exception paramLinearLayout)
    {
      paramOnLongClickAndTouchListener = new StringBuilder();
      paramOnLongClickAndTouchListener.append("set resource error ");
      paramOnLongClickAndTouchListener.append(paramLinearLayout);
      QLog.e("BirthDayNoticeItemBuilder", 1, paramOnLongClickAndTouchListener.toString());
      paramOnLongClickAndTouchListener = MonitorManager.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set data error ");
      localStringBuilder.append(paramLinearLayout);
      paramOnLongClickAndTouchListener.a(19, 2, localStringBuilder.toString(), false);
    }
    paramViewHolder.h.setText(paramMessageRecord.birthday);
    int i = paramMessageRecord.blessing.indexOf(e);
    if (i >= 0)
    {
      paramLinearLayout = new SpannableString(paramMessageRecord.blessing);
      paramLinearLayout.setSpan(this.f, i, e.length() + i, 33);
      paramViewHolder.i.setText(paramLinearLayout);
    }
    else
    {
      paramViewHolder.i.setText(paramMessageRecord.blessing);
    }
    paramViewHolder.e.setTag(paramMessageRecord);
    paramViewHolder.e.setOnClickListener(this);
    a(paramMessageRecord);
    if (v)
    {
      paramViewHolder.r.append("生日");
      paramViewHolder.r.append(paramMessageRecord.birthday);
      paramViewHolder.r.append(paramMessageRecord.blessing);
      paramViewHolder.d.setContentDescription(paramViewHolder.r.toString());
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new BirthDayNoticeItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
  
  public boolean c()
  {
    long l = System.currentTimeMillis();
    boolean bool;
    if (l - this.g > 500L) {
      bool = true;
    } else {
      bool = false;
    }
    this.g = l;
    return bool;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (c())
    {
      localObject1 = paramView.getTag();
      if ((localObject1 instanceof MessageForBirthdayNotice))
      {
        localObject1 = (MessageForBirthdayNotice)localObject1;
        if (TextUtils.isEmpty(((MessageForBirthdayNotice)localObject1).doufu_link))
        {
          if (QLog.isColorLevel()) {
            QLog.e("BirthDayNoticeItemBuilder", 2, "jumpToH5Page with url empty");
          }
          localObject2 = MonitorManager.a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" parse data with empty url ");
          localStringBuilder.append(localObject1);
          ((MonitorManager)localObject2).a(19, 2, localStringBuilder.toString(), false);
        }
        else
        {
          localObject2 = new Intent(this.c, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", ((MessageForBirthdayNotice)localObject1).doufu_link);
          this.c.startActivity((Intent)localObject2);
        }
      }
    }
    try
    {
      long l = Long.parseLong(((MessageForBirthdayNotice)localObject1).frienduin);
      localObject1 = new LpReportInfo_pf00064();
      ((LpReportInfo_pf00064)localObject1).actionType = 91;
      ((LpReportInfo_pf00064)localObject1).subactionType = 22;
      ((LpReportInfo_pf00064)localObject1).reserves = 2;
      ((LpReportInfo_pf00064)localObject1).toUin = l;
      LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject1, false, false);
    }
    catch (Exception localException)
    {
      label198:
      break label198;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("error parse friend uin ");
    ((StringBuilder)localObject2).append(localObject1);
    QLog.e("BirthDayNoticeItemBuilder", 1, ((StringBuilder)localObject2).toString());
    localObject2 = MonitorManager.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" error parse friend uin ");
    localStringBuilder.append(localObject1);
    ((MonitorManager)localObject2).a(19, 10, localStringBuilder.toString(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BirthDayNoticeItemBuilder
 * JD-Core Version:    0.7.0.1
 */