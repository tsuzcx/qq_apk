package com.tencent.biz.subscribe.utils;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class FeedbackSheetHelper$4
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.a;
    if (paramView != null) {
      paramView.a(true);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.FeedbackSheetHelper.4
 * JD-Core Version:    0.7.0.1
 */