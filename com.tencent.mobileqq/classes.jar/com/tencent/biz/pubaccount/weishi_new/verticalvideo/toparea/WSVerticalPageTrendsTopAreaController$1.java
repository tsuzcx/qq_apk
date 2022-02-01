package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSVerticalPageTrendsTopAreaController$1
  implements View.OnClickListener
{
  WSVerticalPageTrendsTopAreaController$1(WSVerticalPageTrendsTopAreaController paramWSVerticalPageTrendsTopAreaController) {}
  
  public void onClick(View paramView)
  {
    if (WSVerticalPageTrendsTopAreaController.a(this.a).getActivity() != null) {
      WSVerticalPageTrendsTopAreaController.a(this.a).getActivity().doOnBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageTrendsTopAreaController.1
 * JD-Core Version:    0.7.0.1
 */