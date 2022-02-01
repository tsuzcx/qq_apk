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
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)paramMessageRecord;
    ConfessNewsItemBuilder.ConfessNewsViewHolder localConfessNewsViewHolder = (ConfessNewsItemBuilder.ConfessNewsViewHolder)paramViewHolder;
    paramLinearLayout = paramView;
    if (paramView == null)
    {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558903, null);
      localConfessNewsViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131379432));
      localConfessNewsViewHolder.c = ((TextView)paramLinearLayout.findViewById(2131365328));
      localConfessNewsViewHolder.d = ((TextView)paramLinearLayout.findViewById(2131378646));
      localConfessNewsViewHolder.jdField_b_of_type_AndroidViewView = paramLinearLayout.findViewById(2131365294);
      localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView = ((ConfessNewsBgView)paramLinearLayout.findViewById(2131363573));
      localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setPressMask(true);
      localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnClickListener(new ConfessNewsItemBuilder.1(this));
    }
    localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(localMessageForConfessNews);
    localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setBgType(localMessageForConfessNews.nBGType);
    localConfessNewsViewHolder.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    localConfessNewsViewHolder.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    int i;
    boolean bool1;
    Object localObject;
    label251:
    String str2;
    String str1;
    label306:
    StringBuilder localStringBuilder;
    if ((paramMessageRecord.istroop != 0) || (paramMessageRecord.istroop == 1))
    {
      i = 1;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localMessageForConfessNews.strConfessorUin);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localMessageForConfessNews.strRecUin);
      if (!bool2) {
        break label574;
      }
      localObject = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { HardCodeUtil.a(2131702459) });
      localConfessNewsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      str2 = localMessageForConfessNews.strConfessorDesc;
      float f = TagUtils.a(str2);
      paramView = localMessageForConfessNews.strConfessorNick;
      if (bool1) {
        paramView = HardCodeUtil.a(2131702458);
      }
      if (localMessageForConfessNews.confessTime > 0L) {
        break label692;
      }
      str1 = "";
      localStringBuilder = new StringBuilder();
      if (localMessageForConfessNews.nBizType != 1) {
        break label741;
      }
      if (!bool2) {
        break label712;
      }
      paramView = HardCodeUtil.a(2131702463);
      label335:
      localStringBuilder.append(String.format(Locale.getDefault(), HardCodeUtil.a(2131702462), new Object[] { Integer.valueOf(localMessageForConfessNews.nConfessNum), paramView }));
      label371:
      localConfessNewsViewHolder.d.setText(localStringBuilder.toString());
      if (f <= 8.0F) {
        break label792;
      }
      localConfessNewsViewHolder.c.setTextSize(1, 21.0F);
      localConfessNewsViewHolder.c.setLineSpacing(0.0F, 1.2F);
      if ((f > 12.0F) || (!TagUtils.a(str2))) {
        break label814;
      }
      i = (int)(f * 0.7D);
    }
    label792:
    label814:
    for (paramView = str2.substring(0, i) + "\n" + str2.substring(i, str2.length());; paramView = str2)
    {
      localConfessNewsViewHolder.c.setText(paramView);
      if (e)
      {
        paramViewHolder.b.append((String)localObject).append(paramView).append(",").append(localStringBuilder.toString());
        paramLinearLayout.setContentDescription(paramViewHolder.b.toString());
      }
      localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(paramMessageRecord);
      localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnTouchListener(paramOnLongClickAndTouchListener);
      localConfessNewsViewHolder.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      return paramLinearLayout;
      i = 0;
      break;
      label574:
      localObject = localMessageForConfessNews.strRecNick;
      paramView = (View)localObject;
      if (i != 0) {
        if (localMessageForConfessNews.nRecNickType != 1)
        {
          paramView = (View)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        }
        else
        {
          str1 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForConfessNews.strGroupUin, localMessageForConfessNews.strRecUin);
          paramView = (View)localObject;
          if (!TextUtils.isEmpty(str1)) {
            paramView = str1;
          }
        }
      }
      localObject = paramView;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.length() > 7) {
          localObject = ConfessShareHelper.a(paramView, 7.0F);
        }
      }
      localObject = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { localObject });
      break label251;
      label692:
      str1 = TimeFormatterUtils.a(localMessageForConfessNews.confessTime * 1000L, true, "");
      break label306;
      label712:
      if (localMessageForConfessNews.nGetConfessSex == 1)
      {
        paramView = HardCodeUtil.a(2131702460);
        break label335;
      }
      paramView = HardCodeUtil.a(2131702461);
      break label335;
      label741:
      localStringBuilder.append("来自");
      if ((i != 0) && (!bool1)) {}
      localStringBuilder.append(paramView);
      if (TextUtils.isEmpty(str1)) {
        break label371;
      }
      localStringBuilder.append(" | ").append(str1);
      break label371;
      localConfessNewsViewHolder.c.setTextSize(1, 24.0F);
      localConfessNewsViewHolder.c.setLineSpacing(0.0F, 1.0F);
    }
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ConfessNewsItemBuilder
 * JD-Core Version:    0.7.0.1
 */