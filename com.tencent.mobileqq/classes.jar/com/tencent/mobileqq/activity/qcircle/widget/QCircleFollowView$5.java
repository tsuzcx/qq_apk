package com.tencent.mobileqq.activity.qcircle.widget;

import android.view.View;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QCircleFollowView$5
  implements ActionSheet.OnButtonClickListener
{
  QCircleFollowView$5(QCircleFollowView paramQCircleFollowView, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (!FastClickUtils.a("showUnFollowUserActionSheetClick"))
    {
      if (paramInt == 0)
      {
        if (QCircleFollowView.a(this.b) != null) {
          QCircleFollowView.a(this.b).a();
        }
        this.b.b(false);
      }
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView.5
 * JD-Core Version:    0.7.0.1
 */