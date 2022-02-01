package com.tencent.avgame.gameroom;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GameRoomFragment$10
  implements DialogInterface.OnClickListener
{
  GameRoomFragment$10(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.getActivity();
    if ((paramDialogInterface == null) || (paramDialogInterface.isFinishing())) {
      return;
    }
    GameRoomFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.10
 * JD-Core Version:    0.7.0.1
 */