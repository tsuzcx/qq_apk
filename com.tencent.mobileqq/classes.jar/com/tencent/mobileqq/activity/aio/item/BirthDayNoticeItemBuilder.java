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
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131701368);
  private long jdField_a_of_type_Long = 0L;
  private ForegroundColorSpan jdField_a_of_type_AndroidTextStyleForegroundColorSpan = new ForegroundColorSpan(Color.parseColor("#883353"));
  
  public BirthDayNoticeItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, BirthDayNoticeItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558799, null);
      paramHolder.jdField_b_of_type_AndroidViewView = paramView;
      paramHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362335);
      paramHolder.d = paramView.findViewById(2131362334);
      paramHolder.a = ((URLImageView)paramView.findViewById(2131362337));
      paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362338));
      paramHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362336));
      localView = paramView;
      if (e)
      {
        paramHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramHolder.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramHolder.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    long l1;
    if ((paramMessageRecord != null) && (!AIOSingleReporter.a().a(paramMessageRecord, "aio_msg|birthday_notice")))
    {
      AIOSingleReporter.a().a(paramMessageRecord, "aio_msg|birthday_notice");
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
      paramViewHolder.a.setBackgroundURL(paramMessageRecord.icon);
      paramViewHolder.d.setBackgroundColor(Color.parseColor(paramMessageRecord.background));
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
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.birthday);
    int i = paramMessageRecord.blessing.indexOf(jdField_a_of_type_JavaLangString);
    if (i >= 0)
    {
      paramLinearLayout = new SpannableString(paramMessageRecord.blessing);
      paramLinearLayout.setSpan(this.jdField_a_of_type_AndroidTextStyleForegroundColorSpan, i, jdField_a_of_type_JavaLangString.length() + i, 33);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramLinearLayout);
    }
    else
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord.blessing);
    }
    paramViewHolder.jdField_c_of_type_AndroidViewView.setTag(paramMessageRecord);
    paramViewHolder.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    a(paramMessageRecord);
    if (e)
    {
      paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append("生日");
      paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageRecord.birthday);
      paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageRecord.blessing);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setContentDescription(paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new BirthDayNoticeItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public boolean a()
  {
    long l = System.currentTimeMillis();
    boolean bool;
    if (l - this.jdField_a_of_type_Long > 500L) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Long = l;
    return bool;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (a())
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
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", ((MessageForBirthdayNotice)localObject1).doufu_link);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BirthDayNoticeItemBuilder
 * JD-Core Version:    0.7.0.1
 */