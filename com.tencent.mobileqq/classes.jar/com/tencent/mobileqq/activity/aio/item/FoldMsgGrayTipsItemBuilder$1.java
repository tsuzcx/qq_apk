package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FoldMsgGrayTipsItemBuilder$1
  implements View.OnClickListener
{
  FoldMsgGrayTipsItemBuilder$1(FoldMsgGrayTipsItemBuilder paramFoldMsgGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = AIOUtils.a(paramView);
    if ((localObject instanceof MessageForFoldMsgGrayTips))
    {
      ((MessageForFoldMsgGrayTips)localObject).isOpen = true;
      FoldMsgGrayTipsItemBuilder.Holder localHolder = (FoldMsgGrayTipsItemBuilder.Holder)AIOUtils.a(paramView);
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((MessageForFoldMsgGrayTips)localObject).getShowMsgContent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext));
      localObject = localHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        if (((ViewGroup.MarginLayoutParams)localObject).rightMargin != AIOUtils.a(10.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources())) {
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = AIOUtils.a(10.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
        }
      }
      localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localHolder.a.requestLayout();
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BD", "0X80064BD", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FoldMsgGrayTipsItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */