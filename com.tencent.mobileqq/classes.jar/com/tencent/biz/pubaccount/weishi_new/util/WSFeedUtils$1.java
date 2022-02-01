package com.tencent.biz.pubaccount.weishi_new.util;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class WSFeedUtils$1
  implements ActionSheet.OnButtonClickListener
{
  WSFeedUtils$1(ActionSheet.OnButtonClickListener paramOnButtonClickListener, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    WSLog.b("WSFeedUtils", "clickedView :" + paramView + ", which: " + paramInt);
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener.OnClick(paramView, paramInt);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils.1
 * JD-Core Version:    0.7.0.1
 */