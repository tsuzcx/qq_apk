package com.tencent.avgame.gameroom.gamelist;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class GameListView$3
  implements View.OnTouchListener
{
  GameListView$3(GameListView paramGameListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i == 1) {
        this.a.setPrepareNorImage();
      }
    }
    else {
      this.a.setPreparePressImage();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.3
 * JD-Core Version:    0.7.0.1
 */