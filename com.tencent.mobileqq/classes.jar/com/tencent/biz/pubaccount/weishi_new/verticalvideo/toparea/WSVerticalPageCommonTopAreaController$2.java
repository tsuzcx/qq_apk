package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSVerticalPageCommonTopAreaController$2
  implements View.OnClickListener
{
  WSVerticalPageCommonTopAreaController$2(WSVerticalPageCommonTopAreaController paramWSVerticalPageCommonTopAreaController) {}
  
  public void onClick(View paramView)
  {
    WSVerticalPageCommonTopAreaController.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCommonTopAreaController.2
 * JD-Core Version:    0.7.0.1
 */