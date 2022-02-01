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
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558801, null);
      localConfessNewsViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131378784));
      localConfessNewsViewHolder.c = ((TextView)paramLinearLayout.findViewById(2131365202));
      localConfessNewsViewHolder.d = ((TextView)paramLinearLayout.findViewById(2131378039));
      localConfessNewsViewHolder.jdField_b_of_type_AndroidViewView = paramLinearLayout.findViewById(2131365169);
      localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView = ((ConfessNewsBgView)paramLinearLayout.findViewById(2131363496));
      localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setPressMask(true);
      localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnClickListener(new ConfessNewsItemBuilder.1(this));
    }
    else
    {
      paramLinearLayout = paramView;
    }
    localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(localMessageForConfessNews);
    localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setBgType(localMessageForConfessNews.nBGType);
    localConfessNewsViewHolder.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    localConfessNewsViewHolder.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    if (paramMessageRecord.istroop == 1) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localMessageForConfessNews.strConfessorUin);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localMessageForConfessNews.strRecUin);
    if (bool2)
    {
      paramView = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { HardCodeUtil.a(2131702591) });
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
          localObject2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForConfessNews.strGroupUin, localMessageForConfessNews.strRecUin);
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
    localConfessNewsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
    String str = localMessageForConfessNews.strConfessorDesc;
    float f = TagUtils.a(str);
    Object localObject1 = localMessageForConfessNews.strConfessorNick;
    if (bool1) {
      localObject1 = HardCodeUtil.a(2131702590);
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
        localObject1 = HardCodeUtil.a(2131702595);
      }
      else
      {
        if (localMessageForConfessNews.nGetConfessSex == 1) {
          i = 2131702592;
        } else {
          i = 2131702593;
        }
        localObject1 = HardCodeUtil.a(i);
      }
      localStringBuilder.append(String.format(Locale.getDefault(), HardCodeUtil.a(2131702594), new Object[] { Integer.valueOf(localMessageForConfessNews.nConfessNum), localObject1 }));
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
    localConfessNewsViewHolder.d.setText(localStringBuilder.toString());
    if (f > 8.0F)
    {
      localConfessNewsViewHolder.c.setTextSize(1, 21.0F);
      localConfessNewsViewHolder.c.setLineSpacing(0.0F, 1.2F);
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
      localConfessNewsViewHolder.c.setTextSize(1, 24.0F);
      localConfessNewsViewHolder.c.setLineSpacing(0.0F, 1.0F);
      localObject1 = str;
    }
    localConfessNewsViewHolder.c.setText((CharSequence)localObject1);
    if (e)
    {
      localObject2 = paramViewHolder.b;
      ((StringBuilder)localObject2).append(paramView);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(localStringBuilder.toString());
      paramLinearLayout.setContentDescription(paramViewHolder.b.toString());
    }
    localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(paramMessageRecord);
    localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnTouchListener(paramOnLongClickAndTouchListener);
    localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnLongClickListener(paramOnLongClickAndTouchListener);
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
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ConfessNewsItemBuilder
 * JD-Core Version:    0.7.0.1
 */