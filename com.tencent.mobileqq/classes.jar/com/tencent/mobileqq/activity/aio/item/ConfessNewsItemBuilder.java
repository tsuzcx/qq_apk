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
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.util.Locale;
import vam;
import van;

public class ConfessNewsItemBuilder
  extends AbstractChatItemBuilder
{
  public ConfessNewsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = (MessageForConfessNews)paramMessageRecord;
    van localvan = (van)paramViewHolder;
    paramLinearLayout = paramView;
    if (paramView == null)
    {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968747, null);
      localvan.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131363397));
      localvan.c = ((TextView)paramLinearLayout.findViewById(2131363556));
      localvan.d = ((TextView)paramLinearLayout.findViewById(2131363557));
      localvan.jdField_b_of_type_AndroidViewView = paramLinearLayout.findViewById(2131363062);
      localvan.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView = ((ConfessNewsBgView)paramLinearLayout.findViewById(2131363553));
      localvan.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setPressMask(true);
      localvan.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnClickListener(new vam(this));
    }
    localvan.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(localObject);
    localvan.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setBgType(((MessageForConfessNews)localObject).nBGType);
    localvan.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    localvan.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    int i;
    label243:
    String str;
    if ((paramMessageRecord.istroop != 0) || (paramMessageRecord.istroop == 1))
    {
      i = 1;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((MessageForConfessNews)localObject).strConfessorUin);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((MessageForConfessNews)localObject).strRecUin)) {
        break label530;
      }
      paramMessageRecord = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { "我" });
      localvan.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      str = ((MessageForConfessNews)localObject).strConfessorDesc;
      float f = TagUtils.a(str);
      paramView = ((MessageForConfessNews)localObject).strConfessorNick;
      if (bool) {
        paramView = "我";
      }
      if (((MessageForConfessNews)localObject).confessTime > 0L) {
        break label637;
      }
      paramOnLongClickAndTouchListener = "";
      label294:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("来自");
      if ((i != 0) && (!bool)) {
        ((StringBuilder)localObject).append("本群");
      }
      ((StringBuilder)localObject).append(paramView);
      if (!TextUtils.isEmpty(paramOnLongClickAndTouchListener)) {
        ((StringBuilder)localObject).append(" | ").append(paramOnLongClickAndTouchListener);
      }
      localvan.d.setText(((StringBuilder)localObject).toString());
      if (f <= 8.0F) {
        break label657;
      }
      localvan.c.setTextSize(1, 21.0F);
      localvan.c.setLineSpacing(0.0F, 1.2F);
      if ((f > 12.0F) || (!TagUtils.a(str))) {
        break label678;
      }
      i = (int)(f * 0.7D);
    }
    label530:
    label678:
    for (paramView = str.substring(0, i) + "\n" + str.substring(i, str.length());; paramView = str)
    {
      localvan.c.setText(paramView);
      if (b)
      {
        paramViewHolder.b.append(paramMessageRecord).append(paramView).append(",").append(((StringBuilder)localObject).toString());
        paramLinearLayout.setContentDescription(paramViewHolder.b.toString());
      }
      return paramLinearLayout;
      i = 0;
      break;
      paramView = ((MessageForConfessNews)localObject).strRecNick;
      paramMessageRecord = paramView;
      if (i != 0) {
        if (((MessageForConfessNews)localObject).nRecNickType != 1)
        {
          paramMessageRecord = paramView;
          if (!TextUtils.isEmpty(paramView)) {}
        }
        else
        {
          paramOnLongClickAndTouchListener = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForConfessNews)localObject).strGroupUin, ((MessageForConfessNews)localObject).strRecUin);
          paramMessageRecord = paramView;
          if (!TextUtils.isEmpty(paramOnLongClickAndTouchListener)) {
            paramMessageRecord = paramOnLongClickAndTouchListener;
          }
        }
      }
      paramView = paramMessageRecord;
      if (paramMessageRecord != null)
      {
        paramView = paramMessageRecord;
        if (paramMessageRecord.length() > 7) {
          paramView = ConfessShareHelper.a(paramMessageRecord, 7.0F);
        }
      }
      paramMessageRecord = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { paramView });
      break label243;
      label637:
      paramOnLongClickAndTouchListener = TimeFormatterUtils.a(((MessageForConfessNews)localObject).confessTime * 1000L, true, "");
      break label294;
      localvan.c.setTextSize(1, 24.0F);
      localvan.c.setLineSpacing(0.0F, 1.0F);
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new van();
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