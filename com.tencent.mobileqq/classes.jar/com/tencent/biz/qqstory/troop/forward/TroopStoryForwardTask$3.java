package com.tencent.biz.qqstory.troop.forward;

import android.os.Handler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

class TroopStoryForwardTask$3
  extends MessageObserver
{
  TroopStoryForwardTask$3(TroopStoryForwardTask paramTroopStoryForwardTask) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    paramStatictisInfo = this.a.a;
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 5;
    }
    paramStatictisInfo.sendEmptyMessage(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask.3
 * JD-Core Version:    0.7.0.1
 */