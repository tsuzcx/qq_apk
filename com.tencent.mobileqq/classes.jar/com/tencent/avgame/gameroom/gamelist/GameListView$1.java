package com.tencent.avgame.gameroom.gamelist;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GameListView$1
  implements Runnable
{
  GameListView$1(GameListView paramGameListView) {}
  
  public void run()
  {
    if (((this.this$0.getContext() instanceof Activity)) && (((Activity)this.this$0.getContext()).isFinishing())) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((AVGameUtils.b() == 2) || (GameEngine.a().a().a() != 0) || (!GameEngine.a().e()));
      i = GameEngine.a().a();
      if (QLog.isColorLevel()) {
        QLog.i("GameListView", 2, "match delay check.  currentPlayNum:" + i + " preNum:" + GameListView.a(this.this$0));
      }
      if (i == 1)
      {
        this.this$0.a.d();
        DialogUtil.a(this.this$0.getContext(), 230, null, this.this$0.getResources().getString(2131690473), this.this$0.getResources().getString(2131690477), this.this$0.getResources().getString(2131690472), new GameListView.1.1(this), new GameListView.1.2(this)).show();
        ReportController.b(null, "dc00898", "", "", "0X800B499", "0X800B499", 0, 0, "", "", "", "");
        return;
      }
    } while (i > GameListView.a(this.this$0));
    this.this$0.a.d();
    DialogUtil.a(this.this$0.getContext(), 230, null, this.this$0.getResources().getString(2131690474), this.this$0.getResources().getString(2131690571), null, null, new GameListView.1.3(this)).show();
    ReportController.b(null, "dc00898", "", "", "0X800B49C", "0X800B49C", GameEngine.a().a().a().players.size(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.1
 * JD-Core Version:    0.7.0.1
 */