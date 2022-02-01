package com.tencent.biz.qqcircle.share.operation;

import android.view.View;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionMenuItem;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheetHelper;
import com.tencent.biz.qqcircle.widgets.QCircleActionSheet;

class QCircleDisLikeOperation$4
  implements ActionSheet.OnButtonClickListener
{
  QCircleDisLikeOperation$4(QCircleDisLikeOperation paramQCircleDisLikeOperation) {}
  
  public void a(View paramView, int paramInt)
  {
    if (QCircleDisLikeOperation.b(this.a) == null) {
      return;
    }
    ActionSheetHelper.a(this.a.i(), QCircleDisLikeOperation.b(this.a));
    paramView = QCircleDisLikeOperation.b(this.a).c(paramInt);
    if (paramView == null) {
      return;
    }
    QCircleDisLikeOperation.a(this.a, paramView.d, true);
    QCircleDisLikeOperation.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleDisLikeOperation.4
 * JD-Core Version:    0.7.0.1
 */