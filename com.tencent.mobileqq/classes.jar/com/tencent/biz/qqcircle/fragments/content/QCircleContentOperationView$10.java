package com.tencent.biz.qqcircle.fragments.content;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleContentOperationView$10
  implements View.OnClickListener
{
  QCircleContentOperationView$10(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public void onClick(View paramView)
  {
    if ((QCircleContentOperationView.c(this.a) instanceof QCircleContentHorizontalAdapter.QCircleVideoVH))
    {
      if (((QCircleContentHorizontalAdapter.QCircleVideoVH)QCircleContentOperationView.c(this.a)).a != null) {
        QCircleContentOperationView.d(this.a);
      }
      if (((QCircleContentHorizontalAdapter.QCircleVideoVH)QCircleContentOperationView.c(this.a)).c != null) {
        ((QCircleContentHorizontalAdapter.QCircleVideoVH)QCircleContentOperationView.c(this.a)).c.a(this.a.y);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.10
 * JD-Core Version:    0.7.0.1
 */