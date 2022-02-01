package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyFeedbackPopupWindow$4
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyFeedbackPopupWindow$4(ReadInJoyFeedbackPopupWindow paramReadInJoyFeedbackPopupWindow, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((!ReadInJoyFeedbackPopupWindow.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow)) || (!ReadInJoyFeedbackPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow, "deleteFeeds")));
    FastWebRequestUtil.a(ReadInJoyFeedbackPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow), ReadInJoyFeedbackPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow.4
 * JD-Core Version:    0.7.0.1
 */