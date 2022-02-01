package com.tencent.biz.qqcircle.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleBaseInputPopupWindow$2
  implements View.OnClickListener
{
  QCircleBaseInputPopupWindow$2(QCircleBaseInputPopupWindow paramQCircleBaseInputPopupWindow) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */