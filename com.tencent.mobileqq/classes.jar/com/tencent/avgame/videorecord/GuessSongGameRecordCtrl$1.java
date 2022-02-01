package com.tencent.avgame.videorecord;

import android.os.Handler;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.qav.videorecord.SimpleGameRoomStatusListener;
import com.tencent.qav.log.AVLog;

class GuessSongGameRecordCtrl$1
  extends SimpleGameRoomStatusListener
{
  GuessSongGameRecordCtrl$1(GuessSongGameRecordCtrl paramGuessSongGameRecordCtrl) {}
  
  public boolean a(int paramInt, String paramString, EngineData paramEngineData)
  {
    paramEngineData = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRoomSelfExit ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    AVLog.c(paramEngineData, localStringBuilder.toString());
    GuessSongGameRecordCtrl.a(this.a).removeCallbacksAndMessages(null);
    GuessSongGameRecordCtrl.a(this.a).sendEmptyMessage(2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessSongGameRecordCtrl.1
 * JD-Core Version:    0.7.0.1
 */