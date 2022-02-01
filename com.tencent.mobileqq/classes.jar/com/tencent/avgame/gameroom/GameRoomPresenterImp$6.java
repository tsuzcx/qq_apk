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
    if (paramDialogInterface != null)
    {
      if (paramDialogInterface.isFinishing()) {
        return;
      }
      this.a.a(false, 1);
      GameRoomViewLayoutParamsDef.H = 0;
      GameRoomViewLayoutParamsDef.I = 0;
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp.6
 * JD-Core Version:    0.7.0.1
 */