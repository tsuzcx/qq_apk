package com.tencent.biz.qqcircle.fragments.content;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleContentOperationView$13
  implements View.OnClickListener
{
  QCircleContentOperationView$13(QCircleContentOperationView paramQCircleContentOperationView) {}
  
  public void onClick(View paramView)
  {
    QCircleContentOperationView.f(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.13
 * JD-Core Version:    0.7.0.1
 */