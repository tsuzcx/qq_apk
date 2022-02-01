package com.tencent.avgame.gameroom;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.avgame.gameroom.seat.SeatView;

class GameRoomFragment$5
  implements View.OnTouchListener
{
  GameRoomFragment$5(GameRoomFragment paramGameRoomFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = paramView.findViewById(2131429044);
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        GameRoomFragment.d(this.a).setVisibility(8);
        this.a.i.a();
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.5
 * JD-Core Version:    0.7.0.1
 */