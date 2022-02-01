package com.tencent.avgame.gameroom;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.avgame.gameroom.seat.SeatView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameRoomFragment$6
  implements View.OnClickListener
{
  GameRoomFragment$6(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(View paramView)
  {
    GameRoomFragment.a(this.a).setVisibility(8);
    this.a.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.6
 * JD-Core Version:    0.7.0.1
 */