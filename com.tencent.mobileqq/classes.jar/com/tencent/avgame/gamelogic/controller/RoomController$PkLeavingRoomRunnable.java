package com.tencent.avgame.gamelogic.controller;

import android.content.Intent;
import bdla;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import nfc;
import nfv;

class RoomController$PkLeavingRoomRunnable
  implements Runnable
{
  private RoomController$PkLeavingRoomRunnable(RoomController paramRoomController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "PkLeavingRoomRunnable come " + RoomController.a(this.this$0) + " " + RoomController.a(this.this$0));
    }
    nfv localnfv;
    if (RoomController.a(this.this$0))
    {
      localnfv = nfc.a().a();
      if (RoomController.a(this.this$0) != 2) {
        break label270;
      }
      localnfv.f(7);
    }
    for (;;)
    {
      Intent localIntent = new Intent("tencent.avgame.g2q.pkRestart");
      localIntent.putExtra("key_from_survival", true);
      localIntent.putExtra("key_pk_pool_id", localnfv.j());
      localIntent.putExtra("key_room_id", localnfv.a());
      localIntent.putExtra("key_pk_type", localnfv.k());
      localIntent.putExtra("key_pk_cur_round", localnfv.d);
      localIntent.putExtra("key_pk_game_status", localnfv.n());
      localIntent.putExtra("key_pk_match_status", localnfv.f);
      localIntent.putExtra("key_pk_join_roomid", localnfv.jdField_a_of_type_Long);
      localIntent.putExtra("key_pk_total_num", localnfv.h);
      localIntent.putExtra("key_pk_result_info", localnfv.jdField_a_of_type_ComTencentAvgameGamelogicDataSurvivalPkResultInfo);
      localIntent.putExtra("key_pk_enter_pool", RoomController.b(this.this$0));
      nfc.a().a().getApp().sendBroadcast(localIntent);
      bdla.b(null, "dc00898", "", "", "0X800B042", "0X800B042", 100, 0, "", "", "pk_anr", "");
      QLog.flushLog(true);
      try
      {
        Thread.sleep(100L);
        label265:
        System.exit(0);
        return;
        label270:
        if (RoomController.a(this.this$0) != 3) {
          continue;
        }
        localnfv.f(6);
      }
      catch (Throwable localThrowable)
      {
        break label265;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.RoomController.PkLeavingRoomRunnable
 * JD-Core Version:    0.7.0.1
 */