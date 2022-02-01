package com.tencent.avgame.videorecord;

import android.os.Handler;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.qav.log.AVLog;

class GuessSongGameRecordCtrl$1
  extends SimpleGameRoomStatusListener
{
  GuessSongGameRecordCtrl$1(GuessSongGameRecordCtrl paramGuessSongGameRecordCtrl) {}
  
  public boolean a(int paramInt, String paramString, EngineData paramEngineData)
  {
    AVLog.c(this.a.a, "onRoomSelfExit " + paramInt + " " + paramString);
    GuessSongGameRecordCtrl.a(this.a).removeCallbacksAndMessages(null);
    GuessSongGameRecordCtrl.a(this.a).sendEmptyMessage(2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.1
 * JD-Core Version:    0.7.0.1
 */