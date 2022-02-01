package com.tencent.avgame.gameroom;

import android.graphics.RectF;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.seat.SeatView;

class GameRoomFragment$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private RectF b;
  
  GameRoomFragment$4(GameRoomFragment paramGameRoomFragment) {}
  
  public void onGlobalLayout()
  {
    RectF localRectF1 = this.a.i.getAddMemberViewRectInRootView();
    if (localRectF1 == null) {
      return;
    }
    if (!this.a.w)
    {
      this.a.a.e().a(this.a.getString(2131887260), localRectF1, 146);
      this.a.w = true;
    }
    else
    {
      RectF localRectF2 = this.b;
      if ((localRectF2 != null) && ((localRectF2.left != localRectF1.left) || (this.b.top != localRectF1.top))) {
        this.a.a.e().b(this.a.getString(2131887260), localRectF1, 146);
      }
    }
    this.b = localRectF1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.4
 * JD-Core Version:    0.7.0.1
 */