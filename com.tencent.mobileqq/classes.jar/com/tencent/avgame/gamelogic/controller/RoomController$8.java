package com.tencent.avgame.gamelogic.controller;

import nfc;
import nfv;
import ngx;

class RoomController$8
  implements Runnable
{
  RoomController$8(RoomController paramRoomController, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.a) && (RoomController.a(this.this$0))) {
      RoomController.b(this.this$0, true);
    }
    for (;;)
    {
      nfc.a().a().f(1);
      RoomController.a(this.this$0).a(true, 0, this.a, null);
      return;
      RoomController.b(this.this$0, false);
      nfc.a().k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.RoomController.8
 * JD-Core Version:    0.7.0.1
 */