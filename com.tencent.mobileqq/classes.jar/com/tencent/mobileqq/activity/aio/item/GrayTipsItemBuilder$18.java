package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

class GrayTipsItemBuilder$18
  extends ClickableSpan
{
  GrayTipsItemBuilder$18(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.c instanceof Activity))
    {
      paramView = ActionSheet.create(this.a.c);
      paramView.addButton(2131917335);
      paramView.addCancelButton(2131887648);
      paramView.setOnDismissListener(new GrayTipsItemBuilder.18.1(this));
      paramView.setOnButtonClickListener(new GrayTipsItemBuilder.18.2(this, paramView));
      paramView.show();
      ReportController.b(this.a.a, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.18
 * JD-Core Version:    0.7.0.1
 */