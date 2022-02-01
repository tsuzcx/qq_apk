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
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie;
    paramDialogInterface.I = true;
    GameRoomChatPie.d(paramDialogInterface, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.H = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a()) && (!this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.b())) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a, "dc00899", "Grp_wolf", "", "ready_time", "ready_kick", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.13
 * JD-Core Version:    0.7.0.1
 */