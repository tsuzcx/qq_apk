package com.tencent.avgame.ui;

import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.qphone.base.util.QLog;

class AVGameActivity$6
  implements Runnable
{
  AVGameActivity$6(AVGameActivity paramAVGameActivity, int paramInt) {}
  
  public void run()
  {
    QLog.i("AVGameActivity", 1, "onEnterRoom run mGameExited:" + AVGameActivity.a(this.this$0) + " retCode:" + this.a + " mRoomId:" + AVGameActivity.a(this.this$0));
    if (AVGameActivity.a(this.this$0)) {}
    do
    {
      do
      {
        return;
        if (this.a != 0) {
          break;
        }
      } while ((TextUtils.isEmpty(AVGameActivity.a(this.this$0))) || (AVGameActivity.a(this.this$0) == null));
      AVGameActivity.a(this.this$0).a().a(1, AVGameActivity.a(this.this$0));
      return;
    } while ((this.a == 5) || (this.a == 6));
    int i;
    if ((GameEngine.a().i()) && (GameEngine.a().g()))
    {
      i = this.a;
      if (GameEngine.a().a().m()) {
        break label200;
      }
    }
    label200:
    for (boolean bool = true;; bool = false)
    {
      CJSurvivalFestivalReporter.a(8, true, String.valueOf(i), null, bool);
      AVGameActivity.a(this.this$0, 2, this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.6
 * JD-Core Version:    0.7.0.1
 */