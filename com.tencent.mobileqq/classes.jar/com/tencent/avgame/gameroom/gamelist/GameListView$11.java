package com.tencent.avgame.gameroom.gamelist;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.mobileqq.statistics.ReportController;

class GameListView$11
  implements DialogInterface.OnClickListener
{
  GameListView$11(GameListView paramGameListView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    GameListView.a(this.a);
    ReportController.b(null, "dc00898", "", "", "0X800B760", "0X800B760", 0, 0, "", "" + GameEngine.a().a().a(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.11
 * JD-Core Version:    0.7.0.1
 */