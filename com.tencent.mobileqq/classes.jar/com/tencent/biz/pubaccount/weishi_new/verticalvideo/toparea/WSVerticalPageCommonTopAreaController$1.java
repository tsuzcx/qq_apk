package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.app.BaseActivity;

class WSVerticalPageCommonTopAreaController$1
  implements View.OnClickListener
{
  WSVerticalPageCommonTopAreaController$1(WSVerticalPageCommonTopAreaController paramWSVerticalPageCommonTopAreaController) {}
  
  public void onClick(View paramView)
  {
    if (WSVerticalPageCommonTopAreaController.a(this.a).getBaseActivity() != null)
    {
      WSVerticalBeaconReport.d(WSVerticalPageCommonTopAreaController.a(this.a).a(), WSVerticalPageCommonTopAreaController.a(this.a).b(), WSVerticalPageCommonTopAreaController.a(this.a).a());
      WSVerticalPageCommonTopAreaController.a(this.a).getBaseActivity().doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCommonTopAreaController.1
 * JD-Core Version:    0.7.0.1
 */