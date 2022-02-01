package com.tencent.avgame.gameroom.gamelist;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class GameListView$6
  extends RecyclerView.OnScrollListener
{
  GameListView$6(GameListView paramGameListView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 1) && (!this.a.c)) {
      this.a.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.6
 * JD-Core Version:    0.7.0.1
 */