package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.Constants;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.net.MalformedURLException;
import java.net.URL;

public class PLNewsItemBuilder
  extends AbstractChatItemBuilder
{
  int jdField_a_of_type_Int = 0;
  RoundedColorDrawable jdField_a_of_type_ComTencentMobileqqStructmsgRoundedColorDrawable;
  int b = 0;
  int d = 0;
  
  public PLNewsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296400) * 2);
    this.b = ((int)paramContext.getResources().getDimension(2131298193));
    this.d = paramContext.getResources().getDimensionPixelSize(2131298192);
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 3);
    }
  }
  
  private int a(PLNewsItemBuilder.Holder paramHolder)
  {
    int i = paramHolder.c.getBackground().getIntrinsicWidth();
    return paramHolder.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, PLNewsItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558816, null);
      paramHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365169);
      paramHolder.c = ((TextView)paramView.findViewById(2131378460));
      paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378784));
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363496));
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.b);
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramHolder);
      paramHolder.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramHolder.c.getLayoutParams().height = i;
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
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    int i = 0;
    while (j < paramString.length())
    {
      int k = paramString.codePointAt(j);
      if ((k >= 32) && (k <= 126))
      {
        i += 1;
      }
      else if (k >= 65535)
      {
        i += 1;
        j += 1;
      }
      else
      {
        i += 2;
      }
      if (i <= paramInt) {
        localStringBuilder.appendCodePoint(k);
      }
      if (i >= paramInt) {
        break;
      }
      j += 1;
    }
    if (localStringBuilder.length() < paramString.length()) {
      localStringBuilder.append("...");
    }
    return localStringBuilder.toString();
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramViewHolder = (PLNewsItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramViewHolder.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramOnLongClickAndTouchListener = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    paramMessageRecord = Constants.jdField_a_of_type_JavaLangString;
    int k = 1;
    String str = String.format(paramMessageRecord, new Object[] { paramOnLongClickAndTouchListener });
    if (!paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramViewHolder.c.getText().equals(paramLinearLayout.text)) {
      paramViewHolder.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131373114);
    Object localObject = (Integer)paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131373113);
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((Integer)localObject).intValue();
    }
    int i = k;
    if (!TextUtils.isEmpty(paramLinearLayout.cover))
    {
      i = k;
      if (Utils.a(paramLinearLayout.cover, paramMessageRecord)) {
        i = 0;
      }
    }
    k = i;
    if (TextUtils.isEmpty(paramLinearLayout.cover))
    {
      k = i;
      if (j == paramLinearLayout.bgColor) {
        k = 0;
      }
    }
    if (k != 0)
    {
      i = paramLinearLayout.bgColor;
      j = this.b;
      localObject = new RoundedColorDrawable(i, j * 3, j * 3, j);
      i = this.b;
      RoundedColorDrawable localRoundedColorDrawable = new RoundedColorDrawable(0, i * 3, i * 3, i);
      if (!TextUtils.isEmpty(paramLinearLayout.cover))
      {
        try
        {
          paramMessageRecord = new URL(paramLinearLayout.cover);
        }
        catch (MalformedURLException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
          paramMessageRecord = null;
        }
        if (paramMessageRecord != null)
        {
          paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramViewHolder), a(paramViewHolder), localRoundedColorDrawable, (Drawable)localObject);
          paramMessageRecord.setDecodeHandler(URLDrawableDecodeHandler.r);
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131373114, paramLinearLayout.cover);
          break label393;
        }
      }
      paramMessageRecord = null;
      label393:
      if (paramMessageRecord == null)
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131373113, Integer.valueOf(paramLinearLayout.bgColor));
      }
    }
    if (!TextUtils.isEmpty(paramLinearLayout.cover))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgRoundedColorDrawable == null)
      {
        i = Color.parseColor("#66000000");
        j = this.b;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgRoundedColorDrawable = new RoundedColorDrawable(i, j * 3, j * 3, j);
      }
      paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqStructmsgRoundedColorDrawable);
    }
    else
    {
      paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
    }
    if (e)
    {
      paramMessageRecord = paramViewHolder.jdField_b_of_type_JavaLangStringBuilder;
      paramMessageRecord.append(str);
      paramMessageRecord.append(paramLinearLayout.text);
      paramView.setContentDescription(paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
    }
    paramViewHolder.jdField_b_of_type_AndroidViewView.setTag(paramViewHolder);
    paramViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(new PLNewsItemBuilder.1(this, paramLinearLayout, paramOnLongClickAndTouchListener));
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new PLNewsItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PLNewsItemBuilder
 * JD-Core Version:    0.7.0.1
 */