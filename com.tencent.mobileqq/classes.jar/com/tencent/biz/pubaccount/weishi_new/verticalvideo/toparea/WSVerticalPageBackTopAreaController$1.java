package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.app.BaseActivity;

class WSVerticalPageBackTopAreaController$1
  implements View.OnClickListener
{
  WSVerticalPageBackTopAreaController$1(WSVerticalPageBackTopAreaController paramWSVerticalPageBackTopAreaController) {}
  
  public void onClick(View paramView)
  {
    if (WSVerticalPageBackTopAreaController.a(this.a).getBaseActivity() != null)
    {
      WSVerticalBeaconReport.g(WSVerticalPageBackTopAreaController.a(this.a).k(), WSVerticalPageBackTopAreaController.a(this.a).l(), WSVerticalPageBackTopAreaController.a(this.a).F(), ((WSVerticalPageContract.Presenter)WSVerticalPageBackTopAreaController.a(this.a).aO_()).m());
      WSVerticalPageBackTopAreaController.a(this.a).getBaseActivity().doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageBackTopAreaController.1
 * JD-Core Version:    0.7.0.1
 */