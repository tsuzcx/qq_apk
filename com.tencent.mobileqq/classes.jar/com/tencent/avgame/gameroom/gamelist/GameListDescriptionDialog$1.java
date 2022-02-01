package com.tencent.avgame.gameroom.gamelist;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameListDescriptionDialog$1
  implements View.OnClickListener
{
  GameListDescriptionDialog$1(GameListDescriptionDialog paramGameListDescriptionDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListDescriptionDialog.1
 * JD-Core Version:    0.7.0.1
 */