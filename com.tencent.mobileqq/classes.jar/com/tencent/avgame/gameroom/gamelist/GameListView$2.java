package com.tencent.avgame.gameroom.gamelist;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.avgame.gameroom.video.IAVControlUiPresenter;
import com.tencent.avgame.util.AVGameUtils;

class GameListView$2
  implements View.OnTouchListener
{
  GameListView$2(GameListView paramGameListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      paramView = AVGameUtils.a("avgame_start_game_owner_hl@3x.png");
      if (paramView != null)
      {
        this.a.a.a().setImageBitmap(paramView);
        continue;
        paramView = AVGameUtils.a("avgame_start_game_owner_normal@3x.png");
        if (paramView != null) {
          this.a.a.a().setImageBitmap(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.2
 * JD-Core Version:    0.7.0.1
 */