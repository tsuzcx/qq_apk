package com.tencent.biz.qqcircle.fragments.content;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleContentPart$8
  implements View.OnClickListener
{
  QCircleContentPart$8(QCircleContentPart paramQCircleContentPart) {}
  
  public void onClick(View paramView)
  {
    QCircleContentPart.o(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.8
 * JD-Core Version:    0.7.0.1
 */