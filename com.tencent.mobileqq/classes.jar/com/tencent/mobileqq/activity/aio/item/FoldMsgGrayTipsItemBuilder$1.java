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
    Object localObject1 = AIOUtils.a(paramView);
    if ((localObject1 instanceof MessageForFoldMsgGrayTips))
    {
      Object localObject2 = (MessageForFoldMsgGrayTips)localObject1;
      ((MessageForFoldMsgGrayTips)localObject2).isOpen = true;
      localObject1 = (FoldMsgGrayTipsItemBuilder.Holder)AIOUtils.a(paramView);
      ((FoldMsgGrayTipsItemBuilder.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((MessageForFoldMsgGrayTips)localObject2).getShowMsgContent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext));
      localObject2 = ((FoldMsgGrayTipsItemBuilder.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        if (((ViewGroup.MarginLayoutParams)localObject2).rightMargin != AIOUtils.b(10.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources())) {
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = AIOUtils.b(10.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
        }
      }
      ((FoldMsgGrayTipsItemBuilder.Holder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((FoldMsgGrayTipsItemBuilder.Holder)localObject1).a.requestLayout();
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BD", "0X80064BD", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FoldMsgGrayTipsItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */