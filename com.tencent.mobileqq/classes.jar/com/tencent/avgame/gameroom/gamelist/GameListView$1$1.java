package com.tencent.avgame.gameroom.gamelist;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.mobileqq.statistics.ReportController;

class GameListView$1$1
  implements DialogInterface.OnClickListener
{
  GameListView$1$1(GameListView.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B49B", "0X800B49B", 0, 0, "", "", "", "");
    this.a.this$0.c.a(false, 1);
    ((Activity)this.a.this$0.getContext()).finish();
    if (IGameEngine.I().L() != null) {
      IGameEngine.I().L().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.1.1
 * JD-Core Version:    0.7.0.1
 */