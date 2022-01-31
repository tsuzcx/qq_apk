package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForEnterTroop.User;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import utf;

public class EnterTroopChatItemBuilder
  extends AbstractChatItemBuilder
{
  public EnterTroopChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int j = 0;
    paramOnLongClickAndTouchListener = (utf)paramViewHolder;
    paramViewHolder = paramView;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramViewHolder = new LinearLayout(paramLinearLayout.getContext());
      paramViewHolder.setOrientation(1);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = AIOUtils.a(9.0F, paramLinearLayout.getContext().getResources());
      paramViewHolder.setLayoutParams(paramView);
      localObject1 = new LinearLayout(paramViewHolder.getContext());
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setGravity(1);
      paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject1);
      paramView = new LinearLayout(paramViewHolder.getContext());
      paramView.setOrientation(0);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(4.0F, paramLinearLayout.getContext().getResources());
      paramViewHolder.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      paramOnLongClickAndTouchListener.b = new TextView(paramView.getContext());
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      paramView.addView(paramOnLongClickAndTouchListener.b, (ViewGroup.LayoutParams)localObject1);
      paramOnLongClickAndTouchListener.b.setTextColor(-8355712);
      paramOnLongClickAndTouchListener.b.setGravity(1);
      paramOnLongClickAndTouchListener.b.setSingleLine();
      paramOnLongClickAndTouchListener.b.setEllipsize(TextUtils.TruncateAt.END);
      paramOnLongClickAndTouchListener.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    int i;
    if ((paramMessageRecord instanceof MessageForEnterTroop))
    {
      localObject1 = (MessageForEnterTroop)paramMessageRecord;
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131429681);
      localObject2 = ((MessageForEnterTroop)localObject1).mList.iterator();
      for (i = 1; ((Iterator)localObject2).hasNext(); i = 0)
      {
        MessageForEnterTroop.User localUser = (MessageForEnterTroop.User)((Iterator)localObject2).next();
        paramView = paramMessageRecord;
        if (i == 0) {
          paramView = paramMessageRecord + ",";
        }
        paramMessageRecord = paramView + localUser.b;
      }
      paramOnLongClickAndTouchListener.b.setText(paramMessageRecord);
      i = ((MessageForEnterTroop)localObject1).mList.size();
      if (i <= 5) {
        break label727;
      }
      i = 5;
    }
    label727:
    for (;;)
    {
      int k = paramOnLongClickAndTouchListener.jdField_a_of_type_JavaUtilList.size();
      if (k < i) {
        while (j < i - k)
        {
          paramMessageRecord = new ImageView(paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.getContext());
          paramMessageRecord.setScaleType(ImageView.ScaleType.FIT_XY);
          int m = AIOUtils.a(26.0F, paramLinearLayout.getContext().getResources());
          paramView = new LinearLayout.LayoutParams(m, m);
          paramView.leftMargin = AIOUtils.a(4.0F, paramLinearLayout.getContext().getResources());
          paramView.rightMargin = AIOUtils.a(4.0F, paramLinearLayout.getContext().getResources());
          paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramMessageRecord, paramView);
          paramOnLongClickAndTouchListener.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
          j += 1;
        }
      }
      if (k > i)
      {
        j = k;
        while (j > i)
        {
          paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)paramOnLongClickAndTouchListener.jdField_a_of_type_JavaUtilList.get(j - 1));
          paramOnLongClickAndTouchListener.jdField_a_of_type_JavaUtilList.remove(j - 1);
          j -= 1;
        }
      }
      paramMessageRecord = paramOnLongClickAndTouchListener.jdField_a_of_type_JavaUtilList.iterator();
      paramView = ((MessageForEnterTroop)localObject1).mList.iterator();
      while ((paramMessageRecord.hasNext()) && (paramView.hasNext()))
      {
        paramLinearLayout = (ImageView)paramMessageRecord.next();
        paramOnLongClickAndTouchListener = (MessageForEnterTroop.User)paramView.next();
        paramLinearLayout.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramOnLongClickAndTouchListener.a));
      }
      return paramViewHolder;
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new utf(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.EnterTroopChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */