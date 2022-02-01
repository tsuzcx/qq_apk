package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSVerticalItemVideoAreaController$1
  implements View.OnClickListener
{
  WSVerticalItemVideoAreaController$1(WSVerticalItemVideoAreaController paramWSVerticalItemVideoAreaController) {}
  
  public void onClick(View paramView)
  {
    this.a.g();
    this.a.i();
    WSVerticalItemVideoAreaController.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoAreaController.1
 * JD-Core Version:    0.7.0.1
 */