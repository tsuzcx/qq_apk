package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendChatPie$4
  implements View.OnClickListener
{
  FriendChatPie$4(FriendChatPie paramFriendChatPie) {}
  
  public void onClick(View paramView)
  {
    if (this.a.N.getVisibility() == 0) {
      ThreadManager.post(new FriendChatPie.4.1(this), 5, null, false);
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    ReportController.b(this.a.d, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    PlusPanelUtils.a(this.a.d, this.a.f, this.a.ah, true, null, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.4
 * JD-Core Version:    0.7.0.1
 */