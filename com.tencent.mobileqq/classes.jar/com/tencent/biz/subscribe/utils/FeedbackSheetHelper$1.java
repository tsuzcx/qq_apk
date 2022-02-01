package com.tencent.biz.subscribe.utils;

import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;

final class FeedbackSheetHelper$1
  implements ActionSheet.OnDismissListener
{
  FeedbackSheetHelper$1(ActionSheet paramActionSheet, FeedbackSheetHelper.ClickItemListener paramClickItemListener) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (this.jdField_a_of_type_ComTencentBizSubscribeUtilsFeedbackSheetHelper$ClickItemListener != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeUtilsFeedbackSheetHelper$ClickItemListener.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.FeedbackSheetHelper.1
 * JD-Core Version:    0.7.0.1
 */