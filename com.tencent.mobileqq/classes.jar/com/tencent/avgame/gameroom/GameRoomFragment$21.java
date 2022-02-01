package com.tencent.avgame.gameroom;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameRoomFragment$21
  implements View.OnClickListener
{
  GameRoomFragment$21(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B51B", "0X800B51B", 0, 0, "", "", "", "");
    GameActivityCenterCtrl.a().c(this.a.getActivity());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.21
 * JD-Core Version:    0.7.0.1
 */