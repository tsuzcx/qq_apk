package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class AbstractChatItemBuilder
  implements ChatItemBuilder
{
  public Context a;
  public BaseAdapter a;
  public SessionInfo a;
  public QQAppInterface a;
  
  public AbstractChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramView = new LinearLayout((Context)localObject);
      ((LinearLayout)paramView).setOrientation(1);
      paramViewGroup = a();
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_Int = paramInt1;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      if (!paramChatMessage.mNeedTimeStamp) {
        break label445;
      }
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        TextView localTextView = new TextView((Context)localObject);
        paramInt2 = AIOUtils.a(14.0F, ((Context)localObject).getResources());
        localTextView.setTextSize(2, 11.0F);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a != null) {
          localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
        }
        localTextView.setPadding(paramInt2, 0, paramInt2, 0);
        localTextView.setGravity(17);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 1;
        localLayoutParams.topMargin = ((Context)localObject).getResources().getDimensionPixelOffset(2131558610);
        localLayoutParams.bottomMargin = ((Context)localObject).getResources().getDimensionPixelOffset(2131558611);
        ((ViewGroup)paramView).addView(localTextView, 0, localLayoutParams);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = localTextView;
        localTextView.setTag(Long.valueOf(0L));
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (((Long)paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != paramChatMessage.time)
      {
        localObject = TimeFormatterUtils.a((Context)localObject, 3, paramChatMessage.time * 1000L);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      label281:
      paramOnLongClickAndTouchListener = a(paramChatMessage, paramViewGroup, paramViewGroup.jdField_a_of_type_AndroidViewView, (LinearLayout)paramView, paramOnLongClickAndTouchListener);
      if (paramOnLongClickAndTouchListener != null) {
        break label466;
      }
      QQCatchedExceptionReporter.reportQQCatchedException(new IllegalArgumentException("getItemView return null, builder: " + getClass() + ", position: " + paramInt1 + ", msgtype: " + paramChatMessage.msgtype), "ItemBuilderCatchedException", null);
    }
    label445:
    label466:
    while (paramViewGroup.jdField_a_of_type_AndroidViewView == paramOnLongClickAndTouchListener)
    {
      paramChatMessage = paramView;
      do
      {
        for (;;)
        {
          return paramChatMessage;
          try
          {
            paramViewGroup = (AbstractChatItemBuilder.ViewHolder)paramView.getTag();
          }
          catch (ClassCastException paramViewGroup)
          {
            paramChatMessage = paramView;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatItemBuilder", 2, "AbstractChatItemBuilder getview  e" + paramViewGroup + "position=" + paramInt1 + "size=" + this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount());
      return paramView;
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetTextView == null) {
        break label281;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label281;
    }
    if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
      ((ViewGroup)paramView).removeView(paramViewGroup.jdField_a_of_type_AndroidViewView);
    }
    if (paramOnLongClickAndTouchListener.getLayoutParams() == null) {
      ((ViewGroup)paramView).addView(paramOnLongClickAndTouchListener, -1, -2);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramOnLongClickAndTouchListener;
      break;
      ((ViewGroup)paramView).addView(paramOnLongClickAndTouchListener);
    }
  }
  
  public abstract View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  public abstract AbstractChatItemBuilder.ViewHolder a();
  
  public void a() {}
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */