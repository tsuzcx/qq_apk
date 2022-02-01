package com.tencent.biz.subscribe.utils;

import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;

final class FeedbackSheetHelper$3
  implements ActionSheet.OnDismissListener
{
  public void onDismiss()
  {
    FeedbackSheetHelper.ResultListener localResultListener = this.jdField_a_of_type_ComTencentBizSubscribeUtilsFeedbackSheetHelper$ResultListener;
    if (localResultListener != null) {
      localResultListener.a(false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.FeedbackSheetHelper.3
 * JD-Core Version:    0.7.0.1
 */