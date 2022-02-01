package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleCommentListView$1
  implements View.OnClickListener
{
  QCircleCommentListView$1(QCircleCommentListView paramQCircleCommentListView) {}
  
  public void onClick(View paramView)
  {
    if (QCircleCommentListView.a(this.a) != null) {
      QCircleCommentListView.a(this.a).setClickable(false);
    }
    QCircleCommentListView.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCommentListView.1
 * JD-Core Version:    0.7.0.1
 */