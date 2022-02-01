package com.tencent.avgame.gameroom;

import android.graphics.RectF;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.seat.SeatView;

class GameRoomFragment$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  
  GameRoomFragment$4(GameRoomFragment paramGameRoomFragment) {}
  
  public void onGlobalLayout()
  {
    RectF localRectF1 = this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a();
    if (localRectF1 == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.b)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.getString(2131690349), localRectF1, 146);
      this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.b = true;
    }
    else
    {
      RectF localRectF2 = this.jdField_a_of_type_AndroidGraphicsRectF;
      if ((localRectF2 != null) && ((localRectF2.left != localRectF1.left) || (this.jdField_a_of_type_AndroidGraphicsRectF.top != localRectF1.top))) {
        this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(this.jdField_a_of_type_ComTencentAvgameGameroomGameRoomFragment.getString(2131690349), localRectF1, 146);
      }
    }
    this.jdField_a_of_type_AndroidGraphicsRectF = localRectF1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.4
 * JD-Core Version:    0.7.0.1
 */