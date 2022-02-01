package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;

class QCircleAddBlackListView$1
  implements ActionSheet.OnButtonClickListener
{
  QCircleAddBlackListView$1(QCircleAddBlackListView paramQCircleAddBlackListView, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    if (!FastClickUtils.a("showUnblackUserActionSheetClick"))
    {
      if (paramInt == 0) {
        QCircleAddBlackListView.a(this.b, true);
      }
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAddBlackListView.1
 * JD-Core Version:    0.7.0.1
 */