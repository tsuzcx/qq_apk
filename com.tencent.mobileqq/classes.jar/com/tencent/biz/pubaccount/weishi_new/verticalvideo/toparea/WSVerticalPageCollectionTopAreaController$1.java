package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSVerticalPageCollectionTopAreaController$1
  implements View.OnClickListener
{
  WSVerticalPageCollectionTopAreaController$1(WSVerticalPageCollectionTopAreaController paramWSVerticalPageCollectionTopAreaController) {}
  
  public void onClick(View paramView)
  {
    if (WSVerticalPageCollectionTopAreaController.a(this.a).getActivity() != null) {
      WSVerticalPageCollectionTopAreaController.a(this.a).getActivity().doOnBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCollectionTopAreaController.1
 * JD-Core Version:    0.7.0.1
 */