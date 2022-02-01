package com.tencent.avgame.gameroom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GameRoomFragment$14$1
  implements DialogInterface.OnClickListener
{
  GameRoomFragment$14$1(GameRoomFragment.14 param14) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a.a != null) {
      this.a.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.14.1
 * JD-Core Version:    0.7.0.1
 */