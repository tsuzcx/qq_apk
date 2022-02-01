package com.tencent.avgame.gameroom;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameRoomFragment$7
  implements View.OnClickListener
{
  GameRoomFragment$7(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(View paramView)
  {
    View localView1 = GameRoomFragment.d(this.a).findViewById(2131429064);
    View localView2 = GameRoomFragment.d(this.a).findViewById(2131429065);
    localView1.setVisibility(8);
    localView2.setVisibility(8);
    GameRoomFragment.d(this.a).setBackgroundColor(-1308622848);
    GameRoomFragment.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.7
 * JD-Core Version:    0.7.0.1
 */