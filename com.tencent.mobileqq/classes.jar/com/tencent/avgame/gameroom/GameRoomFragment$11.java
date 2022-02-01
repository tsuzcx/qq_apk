package com.tencent.avgame.gameroom;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GameRoomFragment$11
  implements DialogInterface.OnClickListener
{
  GameRoomFragment$11(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.getActivity();
    if (paramDialogInterface != null)
    {
      if (paramDialogInterface.isFinishing()) {
        return;
      }
      GameRoomFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.11
 * JD-Core Version:    0.7.0.1
 */