package com.tencent.avgame.gameroom;

import android.graphics.RectF;
import android.support.v4.app.FragmentActivity;
import bdll;
import com.tencent.avgame.gameroom.gamelist.GameListView;
import com.tencent.avgame.gameroom.seat.SeatView;
import nbp;
import nci;

class GameRoomFragment$3
  implements Runnable
{
  GameRoomFragment$3(GameRoomFragment paramGameRoomFragment) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()) && (this.this$0.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView != null) && (this.this$0.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView != null)) {
      if ((this.this$0.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a()) || (this.this$0.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a())) {
        break label91;
      }
    }
    RectF localRectF;
    label91:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localRectF = this.this$0.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a();
        if (localRectF != null) {
          break;
        }
      }
      return;
    }
    this.this$0.jdField_a_of_type_Nbp.a().a(this.this$0.getString(2131690282), localRectF, 146);
    bdll.b(null, "dc00898", "", "", "0X800B350", "0X800B350", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.3
 * JD-Core Version:    0.7.0.1
 */