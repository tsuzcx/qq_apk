package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSVerticalPageChatTopAreaController$2
  implements View.OnClickListener
{
  WSVerticalPageChatTopAreaController$2(WSVerticalPageChatTopAreaController paramWSVerticalPageChatTopAreaController) {}
  
  public void onClick(View paramView)
  {
    if (FastClickUtils.a("vertical_video_top_homepage_click")) {
      WSLog.a("AbsWsUIGroup", "fast click, ignored: vertical video top homepage");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      WSVerticalBeaconReport.d(WSVerticalPageChatTopAreaController.a(this.a).a(), WSVerticalPageChatTopAreaController.a(this.a).b(), WSVerticalPageChatTopAreaController.a(this.a));
      WeishiActivityHelper.a(WSVerticalPageChatTopAreaController.a(this.a).getActivity(), "from_qq_chat", 0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageChatTopAreaController.2
 * JD-Core Version:    0.7.0.1
 */