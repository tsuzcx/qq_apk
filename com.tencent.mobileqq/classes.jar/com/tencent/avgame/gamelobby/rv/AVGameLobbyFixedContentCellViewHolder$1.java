package com.tencent.avgame.gamelobby.rv;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AVGameLobbyFixedContentCellViewHolder$1
  implements View.OnTouchListener
{
  AVGameLobbyFixedContentCellViewHolder$1(AVGameLobbyFixedContentCellViewHolder paramAVGameLobbyFixedContentCellViewHolder) {}
  
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
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyFixedContentCellViewHolder.1
 * JD-Core Version:    0.7.0.1
 */