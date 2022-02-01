package com.tencent.avgame.gameroom;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class GameRoomPresenterImp$6
  implements DialogInterface.OnClickListener
{
  GameRoomPresenterImp$6(GameRoomPresenterImp paramGameRoomPresenterImp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.a();
    if ((paramDialogInterface == null) || (paramDialogInterface.isFinishing())) {
      return;
    }
    this.a.a(false, 1);
    GameRoomViewLayoutParamsDef.w = 0;
    GameRoomViewLayoutParamsDef.x = 0;
    this.a.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp.6
 * JD-Core Version:    0.7.0.1
 */