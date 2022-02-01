package com.tencent.avgame.gameroom;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.avgame.gamelogic.GameEngine;

class GameRoomFragment$8
  implements Runnable
{
  GameRoomFragment$8(GameRoomFragment paramGameRoomFragment, View paramView) {}
  
  public void run()
  {
    if ((!GameEngine.a().v()) && (!GameRoomFragment.e(this.this$0)))
    {
      GameRoomFragment.b(this.this$0, this.a);
      return;
    }
    GameRoomFragment.d(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.8
 * JD-Core Version:    0.7.0.1
 */