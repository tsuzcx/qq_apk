package com.tencent.avgame.gameroom.seat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.gamelogic.data.Player;

class SeatView$1
  implements DialogInterface.OnClickListener
{
  SeatView$1(SeatView paramSeatView, Player paramPlayer) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a.a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatView.1
 * JD-Core Version:    0.7.0.1
 */