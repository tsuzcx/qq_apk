package com.tencent.avgame.gameroom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GameRoomFragment$15$2
  implements DialogInterface.OnClickListener
{
  GameRoomFragment$15$2(GameRoomFragment.15 param15) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a.e != null) {
      this.a.e.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.15.2
 * JD-Core Version:    0.7.0.1
 */