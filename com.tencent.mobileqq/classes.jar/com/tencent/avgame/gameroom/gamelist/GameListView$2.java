package com.tencent.avgame.gameroom.gamelist;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.avgame.gameroom.video.IAVControlUiPresenter;
import com.tencent.avgame.util.AVGameUtil;

class GameListView$2
  implements View.OnTouchListener
{
  GameListView$2(GameListView paramGameListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        paramView = AVGameUtil.c("avgame_start_game_owner_normal@3x.png");
        if (paramView != null) {
          this.a.d.h().setImageBitmap(paramView);
        }
      }
    }
    else
    {
      paramView = AVGameUtil.c("avgame_start_game_owner_hl@3x.png");
      if (paramView != null) {
        this.a.d.h().setImageBitmap(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.2
 * JD-Core Version:    0.7.0.1
 */