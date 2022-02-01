package com.tencent.avgame.gamelogic.controller;

import com.tencent.avgame.business.observer.UserInfoObserver;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.IDataCtrl;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class RoomController$1
  extends UserInfoObserver
{
  RoomController$1(RoomController paramRoomController) {}
  
  public void a(boolean paramBoolean, int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      EngineData localEngineData = (EngineData)RoomController.a(this.a).a();
      localEngineData.a(paramHashMap);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("updateNicks when onUserNickUpdated %s", new Object[] { Arrays.toString(localEngineData.a().players.toArray()) }));
      }
      RoomController.a(this.a).a(paramHashMap);
      RoomController.a(this.a, paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.RoomController.1
 * JD-Core Version:    0.7.0.1
 */