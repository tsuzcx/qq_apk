package com.tencent.biz.qqcircle.fragments.content;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleContentOperationView$5
  implements View.OnClickListener
{
  QCircleContentOperationView$5(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public void onClick(View paramView)
  {
    QCircleContentOperationView.a(this.a, 4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.5
 * JD-Core Version:    0.7.0.1
 */