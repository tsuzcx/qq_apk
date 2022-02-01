package com.tencent.avgame.gamelogic.controller;

import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.ui.AVGameActivity;

class SurvivalRoomController$3
  implements Runnable
{
  SurvivalRoomController$3(SurvivalRoomController paramSurvivalRoomController, AVGameActivity paramAVGameActivity, long paramLong, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (GameEngine.a().g())
    {
      SurvivalRoomController.a(this.this$0, this.jdField_a_of_type_ComTencentAvgameUiAVGameActivity, String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ArrayOfByte);
      return;
    }
    SurvivalRoomController.b(this.this$0, this.jdField_a_of_type_ComTencentAvgameUiAVGameActivity, String.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController.3
 * JD-Core Version:    0.7.0.1
 */