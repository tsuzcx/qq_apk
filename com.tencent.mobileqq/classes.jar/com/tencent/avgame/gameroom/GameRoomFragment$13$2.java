package com.tencent.avgame.gameroom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GameRoomFragment$13$2
  implements DialogInterface.OnClickListener
{
  GameRoomFragment$13$2(GameRoomFragment.13 param13) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a.b != null) {
      this.a.b.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.13.2
 * JD-Core Version:    0.7.0.1
 */