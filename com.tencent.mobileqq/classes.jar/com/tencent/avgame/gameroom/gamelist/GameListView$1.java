package com.tencent.avgame.gameroom.gamelist;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.util.AVGameUtil;
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
    if (((this.this$0.getContext() instanceof Activity)) && (((Activity)this.this$0.getContext()).isFinishing())) {
      return;
    }
    if (AVGameUtil.b() == 2) {
      return;
    }
    if (IGameEngine.J()) {
      return;
    }
    if ((IGameEngine.I().s().j() == 0) && (IGameEngine.I().v()))
    {
      int i = IGameEngine.I().e();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("match delay check.  currentPlayNum:");
        localStringBuilder.append(i);
        localStringBuilder.append(" preNum:");
        localStringBuilder.append(GameListView.a(this.this$0));
        QLog.i("GameListView", 2, localStringBuilder.toString());
      }
      if (i == 1)
      {
        this.this$0.b.g();
        DialogUtil.a(this.this$0.getContext(), 230, null, this.this$0.getResources().getString(2131887308), this.this$0.getResources().getString(2131887312), this.this$0.getResources().getString(2131887307), new GameListView.1.1(this), new GameListView.1.2(this)).show();
        ReportController.b(null, "dc00898", "", "", "0X800B499", "0X800B499", 0, 0, "", "", "", "");
        return;
      }
      if (i <= GameListView.a(this.this$0))
      {
        this.this$0.b.g();
        DialogUtil.a(this.this$0.getContext(), 230, null, this.this$0.getResources().getString(2131887309), this.this$0.getResources().getString(2131887410), null, null, new GameListView.1.3(this)).show();
        ReportController.b(null, "dc00898", "", "", "0X800B49C", "0X800B49C", IGameEngine.I().s().e().players.size(), 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.1
 * JD-Core Version:    0.7.0.1
 */