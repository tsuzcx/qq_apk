package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;

class GameRoomChatPie$13
  implements DialogInterface.OnClickListener
{
  GameRoomChatPie$13(GameRoomChatPie paramGameRoomChatPie, boolean paramBoolean, WerewolvesPluginInterface paramWerewolvesPluginInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.c;
    paramDialogInterface.bz = true;
    GameRoomChatPie.d(paramDialogInterface, this.a);
    this.c.by = true;
    if ((this.b.c()) && (!this.b.d())) {
      ReportController.b(this.c.d, "dc00899", "Grp_wolf", "", "ready_time", "ready_kick", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.13
 * JD-Core Version:    0.7.0.1
 */