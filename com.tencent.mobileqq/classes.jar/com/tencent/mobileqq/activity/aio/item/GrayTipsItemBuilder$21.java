package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

class GrayTipsItemBuilder$21
  extends ClickableSpan
{
  GrayTipsItemBuilder$21(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = ActionSheet.create(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.addButton(2131719742);
      paramView.addCancelButton(2131690728);
      paramView.setOnDismissListener(new GrayTipsItemBuilder.21.1(this));
      paramView.setOnButtonClickListener(new GrayTipsItemBuilder.21.2(this, paramView));
      paramView.show();
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.21
 * JD-Core Version:    0.7.0.1
 */