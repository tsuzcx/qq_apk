package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;

public class FoldMsgGrayTipsItemBuilder
  extends GrayTipsItemBuilder
{
  public FoldMsgGrayTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  @TargetApi(16)
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (FoldMsgGrayTipsItemBuilder.Holder)paramViewHolder;
    paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558962, null);
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368045));
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376834));
    paramViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372558));
    paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372645));
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    int i;
    if ((paramMessageRecord instanceof MessageForFoldMsgGrayTips))
    {
      paramMessageRecord = (MessageForFoldMsgGrayTips)paramMessageRecord;
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.getShowMsgContent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(0.0F, 1.0F);
      paramLinearLayout = paramViewHolder.jdField_b_of_type_AndroidWidgetImageView;
      if (!paramMessageRecord.isOpen) {
        break label302;
      }
      i = 8;
      paramLinearLayout.setVisibility(i);
      if (paramMessageRecord.isOpen)
      {
        paramMessageRecord = paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if ((paramMessageRecord instanceof ViewGroup.MarginLayoutParams))
        {
          paramMessageRecord = (ViewGroup.MarginLayoutParams)paramMessageRecord;
          if (paramMessageRecord.rightMargin != AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) {
            paramMessageRecord.rightMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          }
        }
      }
      paramMessageRecord = ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER)).a("StatusIcon_HongBaoIcon", 2130847668);
      if (Build.VERSION.SDK_INT >= 16) {
        break label308;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageRecord));
    }
    for (;;)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new FoldMsgGrayTipsItemBuilder.1(this));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BE", "0X80064BE", 0, 0, "", "", "", "");
      return paramView;
      label302:
      i = 0;
      break;
      label308:
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackground(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageRecord));
    }
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new FoldMsgGrayTipsItemBuilder.Holder(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FoldMsgGrayTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */