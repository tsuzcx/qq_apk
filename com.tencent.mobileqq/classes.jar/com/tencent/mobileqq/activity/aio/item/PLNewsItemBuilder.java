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
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
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
import vhl;
import vhm;

public class PLNewsItemBuilder
  extends AbstractChatItemBuilder
{
  int jdField_a_of_type_Int = 0;
  RoundedColorDrawable jdField_a_of_type_ComTencentMobileqqStructmsgRoundedColorDrawable;
  int b;
  int c = 0;
  
  public PLNewsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131560655) * 2);
    this.jdField_b_of_type_Int = ((int)paramContext.getResources().getDimension(2131559448));
    this.c = paramContext.getResources().getDimensionPixelSize(2131559449);
  }
  
  private int a(vhm paramvhm)
  {
    int i = paramvhm.c.getBackground().getIntrinsicWidth();
    return paramvhm.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, vhm paramvhm)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968762, null);
      paramvhm.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363062);
      paramvhm.c = ((TextView)paramView.findViewById(2131363651));
      paramvhm.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363397));
      paramvhm.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363553));
      paramvhm.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.jdField_b_of_type_Int);
      paramvhm.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramvhm);
      paramvhm.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramvhm.c.getLayoutParams().height = i;
      localView = paramView;
      if (jdField_b_of_type_Boolean)
      {
        paramvhm.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_b_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramvhm.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramvhm.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  public static String a(String paramString, int paramInt)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      int k;
      if (j < paramString.length())
      {
        k = paramString.codePointAt(j);
        if ((k < 32) || (k > 126)) {
          break label90;
        }
        i += 1;
      }
      for (;;)
      {
        if (i <= paramInt) {
          localStringBuilder.appendCodePoint(k);
        }
        if (i < paramInt) {
          break;
        }
        if (localStringBuilder.length() < paramString.length()) {
          localStringBuilder.append("...");
        }
        return localStringBuilder.toString();
        label90:
        if (k >= 65535)
        {
          i += 1;
          j += 1;
        }
        else
        {
          i += 2;
        }
      }
      j += 1;
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramViewHolder = (vhm)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramViewHolder.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramOnLongClickAndTouchListener = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    String str = String.format(Constants.jdField_a_of_type_JavaLangString, new Object[] { paramOnLongClickAndTouchListener });
    if (!paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramViewHolder.c.getText().equals(paramLinearLayout.text)) {
      paramViewHolder.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131362406);
    Object localObject = (Integer)paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131362407);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!Utils.a(paramLinearLayout.cover, paramMessageRecord))) {
        break label543;
      }
    }
    label538:
    label543:
    for (int i = 0;; i = 1)
    {
      int k = i;
      if (TextUtils.isEmpty(paramLinearLayout.cover))
      {
        k = i;
        if (j == paramLinearLayout.bgColor) {
          k = 0;
        }
      }
      RoundedColorDrawable localRoundedColorDrawable;
      if (k != 0)
      {
        localObject = new RoundedColorDrawable(paramLinearLayout.bgColor, this.jdField_b_of_type_Int * 3, this.jdField_b_of_type_Int * 3, this.jdField_b_of_type_Int);
        localRoundedColorDrawable = new RoundedColorDrawable(0, this.jdField_b_of_type_Int * 3, this.jdField_b_of_type_Int * 3, this.jdField_b_of_type_Int);
        if (TextUtils.isEmpty(paramLinearLayout.cover)) {
          break label538;
        }
      }
      for (;;)
      {
        try
        {
          paramMessageRecord = new URL(paramLinearLayout.cover);
          if (paramMessageRecord != null)
          {
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramViewHolder), a(paramViewHolder), localRoundedColorDrawable, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(URLDrawableDecodeHandler.o);
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131362406, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
              paramViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131362407, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqStructmsgRoundedColorDrawable == null) {
                this.jdField_a_of_type_ComTencentMobileqqStructmsgRoundedColorDrawable = new RoundedColorDrawable(Color.parseColor("#66000000"), this.jdField_b_of_type_Int * 3, this.jdField_b_of_type_Int * 3, this.jdField_b_of_type_Int);
              }
              paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqStructmsgRoundedColorDrawable);
              if (jdField_b_of_type_Boolean)
              {
                paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
              }
              paramViewHolder.jdField_b_of_type_AndroidViewView.setTag(paramViewHolder);
              paramViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(new vhl(this, paramLinearLayout, paramOnLongClickAndTouchListener));
              return paramView;
              j = ((Integer)localObject).intValue();
            }
          }
        }
        catch (MalformedURLException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
          paramMessageRecord = null;
          continue;
          paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new vhm(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PLNewsItemBuilder
 * JD-Core Version:    0.7.0.1
 */