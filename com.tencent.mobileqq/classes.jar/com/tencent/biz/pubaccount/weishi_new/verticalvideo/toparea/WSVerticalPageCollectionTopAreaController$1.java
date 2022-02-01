package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.app.BaseActivity;

class WSVerticalPageCollectionTopAreaController$1
  implements View.OnClickListener
{
  WSVerticalPageCollectionTopAreaController$1(WSVerticalPageCollectionTopAreaController paramWSVerticalPageCollectionTopAreaController) {}
  
  public void onClick(View paramView)
  {
    if (WSVerticalPageCollectionTopAreaController.a(this.a).getBaseActivity() != null)
    {
      WSVerticalBeaconReport.d(WSVerticalPageCollectionTopAreaController.a(this.a).k(), WSVerticalPageCollectionTopAreaController.a(this.a).l(), WSVerticalPageCollectionTopAreaController.a(this.a).F());
      WSVerticalPageCollectionTopAreaController.a(this.a).getBaseActivity().doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCollectionTopAreaController.1
 * JD-Core Version:    0.7.0.1
 */