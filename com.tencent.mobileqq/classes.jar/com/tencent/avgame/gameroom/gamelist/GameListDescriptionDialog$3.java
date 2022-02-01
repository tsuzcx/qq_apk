package com.tencent.avgame.gameroom.gamelist;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class GameListDescriptionDialog$3
  implements View.OnTouchListener
{
  GameListDescriptionDialog$3(GameListDescriptionDialog paramGameListDescriptionDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListDescriptionDialog.3
 * JD-Core Version:    0.7.0.1
 */