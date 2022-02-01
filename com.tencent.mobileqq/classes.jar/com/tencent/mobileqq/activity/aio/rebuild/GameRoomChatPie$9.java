package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;

class GameRoomChatPie$9
  implements DialogInterface.OnClickListener
{
  GameRoomChatPie$9(GameRoomChatPie paramGameRoomChatPie, WerewolvesPluginInterface paramWerewolvesPluginInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.b;
    paramDialogInterface.bz = true;
    paramDialogInterface.by = true;
    GameRoomChatPie.b(paramDialogInterface, false);
    if ((this.a.c()) && (!this.a.d())) {
      ReportController.b(this.b.d, "dc00899", "Grp_wolf", "", "ready_time", "ready_kick", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.9
 * JD-Core Version:    0.7.0.1
 */