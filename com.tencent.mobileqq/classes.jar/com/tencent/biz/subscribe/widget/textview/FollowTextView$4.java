package com.tencent.biz.subscribe.widget.textview;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FollowTextView$4
  implements ActionSheet.OnButtonClickListener
{
  FollowTextView$4(FollowTextView paramFollowTextView, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!FollowTextView.b(this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView)) {
      return;
    }
    FollowTextView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView, false);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.FollowTextView.4
 * JD-Core Version:    0.7.0.1
 */