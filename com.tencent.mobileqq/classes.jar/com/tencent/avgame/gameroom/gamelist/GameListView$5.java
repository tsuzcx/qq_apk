package com.tencent.avgame.gameroom.gamelist;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.util.AVGameUtil;

class GameListView$5
  implements View.OnTouchListener
{
  GameListView$5(GameListView paramGameListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = IGameEngine.a().e();
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        if (bool) {
          paramView = "avgame_match_stop_normal@2x.png";
        } else {
          paramView = "avgame_match_start_normal@2x.png";
        }
        paramView = AVGameUtil.a(paramView);
        if (paramView != null) {
          GameListView.a(this.a).setImageBitmap(paramView);
        }
      }
    }
    else
    {
      if (bool) {
        paramView = "avgame_match_stop_press@2x.png";
      } else {
        paramView = "avgame_match_start_press@2x.png";
      }
      paramView = AVGameUtil.a(paramView);
      if (paramView != null) {
        GameListView.a(this.a).setImageBitmap(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.5
 * JD-Core Version:    0.7.0.1
 */