package com.tencent.avgame.gamelogic.controller;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.listener.GameStatusListener;
import com.tencent.avgame.gamelogic.listener.IDataCtrl;

class GameController$1
  implements Handler.Callback
{
  GameController$1(GameController paramGameController) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    EngineData localEngineData = (EngineData)GameController.a(this.a).a();
    if (localEngineData.a((ITopic)paramMessage.obj)) {
      GameController.a(this.a).a(localEngineData, "");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameController.1
 * JD-Core Version:    0.7.0.1
 */