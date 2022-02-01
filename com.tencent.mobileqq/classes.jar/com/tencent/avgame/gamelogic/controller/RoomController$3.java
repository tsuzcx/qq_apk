package com.tencent.avgame.gamelogic.controller;

import android.os.Handler;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;
import nfc;
import nmv;

class RoomController$3
  implements Runnable
{
  RoomController$3(RoomController paramRoomController) {}
  
  public void run()
  {
    if (!RoomController.a(this.this$0))
    {
      if (RoomController.a(this.this$0) != null) {
        RoomController.a(this.this$0).removeCallbacks(RoomController.a(this.this$0));
      }
      RoomController.a(this.this$0, new RoomController.PkLeavingRoomRunnable(this.this$0, null));
      RoomController.a(this.this$0).postDelayed(RoomController.a(this.this$0), 2000L);
      RoomController.a(this.this$0, true);
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, "start leaving room ");
      }
      nfc.a().b(false, 12);
      RoomController.a(this.this$0).a().a(3, "");
      RoomController.a(this.this$0, 0);
      RoomController.a(this.this$0, false);
      RoomController.a(this.this$0).removeCallbacks(RoomController.a(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, "finish leaving room " + (System.currentTimeMillis() - l));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.RoomController.3
 * JD-Core Version:    0.7.0.1
 */