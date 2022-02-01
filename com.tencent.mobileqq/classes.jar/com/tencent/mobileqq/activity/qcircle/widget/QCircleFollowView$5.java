package com.tencent.mobileqq.activity.qcircle.widget;

import android.view.View;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QCircleFollowView$5
  implements ActionSheet.OnButtonClickListener
{
  QCircleFollowView$5(QCircleFollowView paramQCircleFollowView, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!FastClickUtils.a("showUnFollowUserActionSheetClick")) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (QCircleFollowView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView) != null) {
        QCircleFollowView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView).a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView.5
 * JD-Core Version:    0.7.0.1
 */