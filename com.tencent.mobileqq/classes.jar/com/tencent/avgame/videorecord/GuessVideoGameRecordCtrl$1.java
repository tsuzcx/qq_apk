package com.tencent.avgame.videorecord;

import android.os.Handler;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.qav.log.AVLog;

class GuessVideoGameRecordCtrl$1
  extends SimpleGameRoomStatusListener
{
  GuessVideoGameRecordCtrl$1(GuessVideoGameRecordCtrl paramGuessVideoGameRecordCtrl) {}
  
  public boolean a(int paramInt, String paramString, EngineData paramEngineData)
  {
    AVLog.c(this.a.a, "onRoomSelfExit " + paramInt + " " + paramString);
    GuessVideoGameRecordCtrl.a(this.a).removeCallbacksAndMessages(null);
    GuessVideoGameRecordCtrl.a(this.a).sendEmptyMessage(2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessVideoGameRecordCtrl.1
 * JD-Core Version:    0.7.0.1
 */