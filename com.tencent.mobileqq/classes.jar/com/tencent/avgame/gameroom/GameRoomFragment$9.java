package com.tencent.avgame.gameroom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.avgame.gamelogic.GameEngine;

class GameRoomFragment$9
  implements DialogInterface.OnClickListener
{
  GameRoomFragment$9(GameRoomFragment paramGameRoomFragment, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (GameEngine.a().d())
    {
      if ((!GameEngine.a().v()) && (!GameRoomFragment.e(this.b)))
      {
        GameRoomFragment.b(this.b, this.a);
        return;
      }
      GameRoomFragment.d(this.b).setVisibility(8);
      return;
    }
    GameRoomFragment.d(this.b).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.9
 * JD-Core Version:    0.7.0.1
 */