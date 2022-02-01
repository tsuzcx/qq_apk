package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.app.BaseActivity;

class WSVerticalPageCLinkTopAreaController$1
  implements View.OnClickListener
{
  WSVerticalPageCLinkTopAreaController$1(WSVerticalPageCLinkTopAreaController paramWSVerticalPageCLinkTopAreaController) {}
  
  public void onClick(View paramView)
  {
    if (WSVerticalPageCLinkTopAreaController.a(this.a).getBaseActivity() != null)
    {
      WSVerticalBeaconReport.g(WSVerticalPageCLinkTopAreaController.a(this.a).k(), WSVerticalPageCLinkTopAreaController.a(this.a).l(), WSVerticalPageCLinkTopAreaController.a(this.a).F(), ((WSVerticalPageContract.Presenter)WSVerticalPageCLinkTopAreaController.a(this.a).aO_()).m());
      WSVerticalPageCLinkTopAreaController.a(this.a).getBaseActivity().doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCLinkTopAreaController.1
 * JD-Core Version:    0.7.0.1
 */