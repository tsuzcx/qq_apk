package com.tencent.avgame.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.qphone.base.util.QLog;

class AVGameActivity$8
  extends BroadcastReceiver
{
  AVGameActivity$8(AVGameActivity paramAVGameActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      QLog.d("AVGameActivity", 1, "mShareResultReceiver onReceive");
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        if (paramContext == null) {
          return;
        }
        if ("com.tencent.mobileqq.app.avgameshare.avgameshareutil".equals(paramContext)) {
          if (paramIntent.getBooleanExtra("avgame_share_result_success", false))
          {
            QLog.i("AVGameActivity", 1, "mShareResultReceiver onReceive success");
            if (paramIntent.getIntExtra("avgame_share_result_type", 0) == 0) {
              this.a.showTransientTip();
            }
            if (AVGameActivity.access$600(this.a) == null) {
              return;
            }
            paramContext = GameEngine.a().a();
            if (paramContext != null) {
              GameActivityCenterCtrl.a().a(this.a, paramContext.b());
            }
          }
          else
          {
            QLog.i("AVGameActivity", 1, "mShareResultReceiver onReceive fail");
          }
        }
      }
      else {}
    }
    catch (Exception paramContext)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive error: ");
      paramIntent.append(paramContext.getMessage());
      QLog.e("AVGameActivity", 1, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.8
 * JD-Core Version:    0.7.0.1
 */