package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import nfc;
import nfv;
import ngx;

class RoomController$6
  implements Runnable
{
  RoomController$6(RoomController paramRoomController, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    nfc.a().a().f(6);
    RoomController.b(this.this$0).removeCallbacksAndMessages(null);
    RoomController.a(this.this$0).a(true, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.RoomController.6
 * JD-Core Version:    0.7.0.1
 */