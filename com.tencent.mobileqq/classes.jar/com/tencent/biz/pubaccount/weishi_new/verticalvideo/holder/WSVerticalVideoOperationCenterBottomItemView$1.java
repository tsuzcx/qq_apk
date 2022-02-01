package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSVerticalVideoOperationCenterBottomItemView$1
  implements View.OnClickListener
{
  WSVerticalVideoOperationCenterBottomItemView$1(WSVerticalVideoOperationCenterBottomItemView paramWSVerticalVideoOperationCenterBottomItemView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() instanceof WSVerticalItemVideoAreaController)) {
      ((WSVerticalItemVideoAreaController)this.a.a()).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationCenterBottomItemView.1
 * JD-Core Version:    0.7.0.1
 */