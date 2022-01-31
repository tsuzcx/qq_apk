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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.confess.ConfessShareHelper;
import com.tencent.mobileqq.confess.TagUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.util.Locale;
import usk;
import usl;

public class ConfessNewsItemBuilder
  extends AbstractChatItemBuilder
{
  public ConfessNewsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = (MessageForConfessNews)paramMessageRecord;
    usl localusl = (usl)paramViewHolder;
    paramLinearLayout = paramView;
    if (paramView == null)
    {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968744, null);
      localusl.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131363360));
      localusl.c = ((TextView)paramLinearLayout.findViewById(2131363519));
      localusl.d = ((TextView)paramLinearLayout.findViewById(2131363520));
      localusl.jdField_b_of_type_AndroidViewView = paramLinearLayout.findViewById(2131363039);
      localusl.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView = ((ConfessNewsBgView)paramLinearLayout.findViewById(2131363516));
      localusl.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setPressMask(true);
      localusl.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnClickListener(new usk(this));
    }
    localusl.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(paramOnLongClickAndTouchListener);
    localusl.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setBgType(paramOnLongClickAndTouchListener.nBGType);
    localusl.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    localusl.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    int i;
    label256:
    String str;
    float f;
    if (paramMessageRecord.istroop == 0)
    {
      i = 1;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramOnLongClickAndTouchListener.strRecUin);
      if ((i == 0) && (bool)) {
        break label527;
      }
      paramView = paramOnLongClickAndTouchListener.strRecNick;
      paramMessageRecord = paramView;
      if (paramView != null)
      {
        paramMessageRecord = paramView;
        if (paramView.length() > 7) {
          paramMessageRecord = ConfessShareHelper.a(paramView, 7.0F);
        }
      }
      paramMessageRecord = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { paramMessageRecord });
      localusl.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      str = paramOnLongClickAndTouchListener.strConfessorDesc;
      f = TagUtils.a(str);
      paramView = paramOnLongClickAndTouchListener.strConfessorNick;
      if ((i != 0) || (bool)) {
        break label595;
      }
      paramView = "我";
    }
    label312:
    label589:
    label595:
    for (;;)
    {
      StringBuilder localStringBuilder;
      if (paramOnLongClickAndTouchListener.confessTime <= 0L)
      {
        paramOnLongClickAndTouchListener = "";
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("来自").append(paramView);
        if (!TextUtils.isEmpty(paramOnLongClickAndTouchListener)) {
          localStringBuilder.append(" | ").append(paramOnLongClickAndTouchListener);
        }
        localusl.d.setText(localStringBuilder.toString());
        if (f <= 8.0F) {
          break label568;
        }
        localusl.c.setTextSize(1, 21.0F);
        localusl.c.setLineSpacing(0.0F, 1.2F);
        if ((f > 12.0F) || (!TagUtils.a(str))) {
          break label589;
        }
        i = (int)(f * 0.7D);
      }
      for (paramView = str.substring(0, i) + "\n" + str.substring(i, str.length());; paramView = str)
      {
        localusl.c.setText(paramView);
        if (b)
        {
          paramViewHolder.b.append(paramMessageRecord).append(paramView).append(",").append(localStringBuilder.toString());
          paramLinearLayout.setContentDescription(paramViewHolder.b.toString());
        }
        return paramLinearLayout;
        i = 0;
        break;
        paramMessageRecord = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { "我" });
        break label256;
        paramOnLongClickAndTouchListener = TimeFormatterUtils.a(paramOnLongClickAndTouchListener.confessTime * 1000L, true, "");
        break label312;
        localusl.c.setTextSize(1, 24.0F);
        localusl.c.setLineSpacing(0.0F, 1.0F);
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new usl();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ConfessNewsItemBuilder
 * JD-Core Version:    0.7.0.1
 */