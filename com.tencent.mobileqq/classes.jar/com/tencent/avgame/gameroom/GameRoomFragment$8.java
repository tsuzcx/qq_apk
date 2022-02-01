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
    if ((GameEngine.a().e()) || (GameRoomFragment.b(this.this$0)))
    {
      GameRoomFragment.a(this.this$0).setVisibility(8);
      return;
    }
    GameRoomFragment.b(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.8
 * JD-Core Version:    0.7.0.1
 */