package com.tencent.avgame.gameroom;

import android.graphics.RectF;
import com.tencent.avgame.gameroom.gamelist.GameListView;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.seat.SeatView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

class GameRoomFragment$3
  implements Runnable
{
  GameRoomFragment$3(GameRoomFragment paramGameRoomFragment) {}
  
  public void run()
  {
    if ((this.this$0.getQBaseActivity() != null) && (!this.this$0.getQBaseActivity().isFinishing()) && (this.this$0.i != null) && (this.this$0.c != null))
    {
      int i;
      if ((!this.this$0.i.b()) && (!this.this$0.c.e())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        RectF localRectF = this.this$0.i.getAddMemberViewRectInRootView();
        if (localRectF == null) {
          return;
        }
        this.this$0.a.e().a(this.this$0.getString(2131887260), localRectF, 146);
        ReportController.b(null, "dc00898", "", "", "0X800B350", "0X800B350", 1, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.3
 * JD-Core Version:    0.7.0.1
 */