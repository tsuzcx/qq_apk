package com.tencent.avgame.gameroom;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.app.IAVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;

class GameRoomPresenterImp$8
  implements DialogInterface.OnClickListener
{
  GameRoomPresenterImp$8(GameRoomPresenterImp paramGameRoomPresenterImp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((IAVGameAppInterface)GameEngine.a().f()).a().b(0, null);
    GameEngine.a().s().a();
    ((IAVGameAppInterface)GameEngine.a().f()).b(1006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomPresenterImp.8
 * JD-Core Version:    0.7.0.1
 */