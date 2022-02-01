package com.tencent.avgame.gamelogic.controller;

import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.listener.GameActivityLifeCycleListener;
import com.tencent.avgame.qav.videorecord.SimpleGameRoomStatusListener;

class SurvivalRoomController$1
  extends SimpleGameRoomStatusListener
{
  SurvivalRoomController$1(SurvivalRoomController paramSurvivalRoomController) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if ((IGameEngine.a().f()) && (!SurvivalRoomController.a(this.a).a())) {
      this.a.a(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    }
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if ((IGameEngine.a().f()) && (!SurvivalRoomController.a(this.a).a())) {
      this.a.b(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController.1
 * JD-Core Version:    0.7.0.1
 */