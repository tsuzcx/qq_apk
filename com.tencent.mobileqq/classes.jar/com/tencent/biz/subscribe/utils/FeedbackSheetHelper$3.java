package com.tencent.biz.subscribe.utils;

import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;

final class FeedbackSheetHelper$3
  implements ActionSheet.OnDismissListener
{
  public void onDismiss()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeUtilsFeedbackSheetHelper$ResultListener != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeUtilsFeedbackSheetHelper$ResultListener.a(false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.FeedbackSheetHelper.3
 * JD-Core Version:    0.7.0.1
 */