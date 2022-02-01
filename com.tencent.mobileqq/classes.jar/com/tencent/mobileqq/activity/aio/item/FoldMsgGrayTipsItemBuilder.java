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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.statistics.ReportController;

public class FoldMsgGrayTipsItemBuilder
  extends GrayTipsItemBuilder
{
  public FoldMsgGrayTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  @TargetApi(16)
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (FoldMsgGrayTipsItemBuilder.Holder)paramViewHolder;
    paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558860, null);
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367798));
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376326));
    paramViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372142));
    paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372224));
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    if ((paramMessageRecord instanceof MessageForFoldMsgGrayTips))
    {
      paramMessageRecord = (MessageForFoldMsgGrayTips)paramMessageRecord;
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.getShowMsgContent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(0.0F, 1.0F);
      paramLinearLayout = paramViewHolder.jdField_b_of_type_AndroidWidgetImageView;
      int i;
      if (paramMessageRecord.isOpen) {
        i = 8;
      } else {
        i = 0;
      }
      paramLinearLayout.setVisibility(i);
      if (paramMessageRecord.isOpen)
      {
        paramMessageRecord = paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if ((paramMessageRecord instanceof ViewGroup.MarginLayoutParams))
        {
          paramMessageRecord = (ViewGroup.MarginLayoutParams)paramMessageRecord;
          if (paramMessageRecord.rightMargin != AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) {
            paramMessageRecord.rightMargin = AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          }
        }
      }
      paramMessageRecord = ((IPasswdRedBagService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPasswdRedBagService.class)).getIconFromCacheByType("StatusIcon_HongBaoIcon", 2130847536);
      if (Build.VERSION.SDK_INT < 16) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageRecord));
      } else {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackground(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageRecord));
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new FoldMsgGrayTipsItemBuilder.1(this));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BE", "0X80064BE", 0, 0, "", "", "", "");
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new FoldMsgGrayTipsItemBuilder.Holder(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FoldMsgGrayTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */