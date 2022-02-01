package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.app.BaseActivity;

class WSVerticalPageChatTopAreaController$1
  implements View.OnClickListener
{
  WSVerticalPageChatTopAreaController$1(WSVerticalPageChatTopAreaController paramWSVerticalPageChatTopAreaController) {}
  
  public void onClick(View paramView)
  {
    if (WSVerticalPageChatTopAreaController.a(this.a).getBaseActivity() != null)
    {
      WSVerticalBeaconReport.d(WSVerticalPageChatTopAreaController.a(this.a).a(), WSVerticalPageChatTopAreaController.a(this.a).b(), WSVerticalPageChatTopAreaController.a(this.a).a());
      WSVerticalPageChatTopAreaController.a(this.a).getBaseActivity().doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageChatTopAreaController.1
 * JD-Core Version:    0.7.0.1
 */