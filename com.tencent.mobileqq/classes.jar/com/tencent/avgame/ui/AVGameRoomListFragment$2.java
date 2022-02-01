package com.tencent.avgame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.util.AvGameEntranceUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class AVGameRoomListFragment$2
  implements View.OnClickListener
{
  AVGameRoomListFragment$2(AVGameRoomListFragment paramAVGameRoomListFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.a.a != null) {
      localObject = this.a.a;
    } else {
      localObject = "";
    }
    ReportController.b(null, "dc00898", "", "", "0X800B01D", "0X800B01D", 0, 0, "", "", (String)localObject, "");
    if (!AvGameEntranceUtils.a(this.a.getQBaseActivity(), this.a.a))
    {
      localObject = (IAvGameManager)this.a.getQBaseActivity().getAppRuntime().getRuntimeService(IAvGameManager.class, "");
      if (localObject != null) {
        ((IAvGameManager)localObject).createAvGameRoom(this.a.getQBaseActivity(), 6, this.a.a, 0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.2
 * JD-Core Version:    0.7.0.1
 */