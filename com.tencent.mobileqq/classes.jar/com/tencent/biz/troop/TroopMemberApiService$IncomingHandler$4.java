package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import mqq.app.AppRuntime;

class TroopMemberApiService$IncomingHandler$4
  implements Runnable
{
  TroopMemberApiService$IncomingHandler$4(TroopMemberApiService.IncomingHandler paramIncomingHandler, AppRuntime paramAppRuntime, String paramString1, String paramString2, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = ((IBizTroopMemberInfoService)this.a.getRuntimeService(IBizTroopMemberInfoService.class, "")).getRobotLastSpeakMessage(this.b, this.c);
    if (localMessageRecord != null)
    {
      this.d.putLong("lastMsgTime", localMessageRecord.time);
      this.d.putString("lastMsgContent", localMessageRecord.msg);
      this.d.putInt("seq", this.e);
    }
    else
    {
      this.d.putLong("lastMsgTime", 0L);
      this.d.putString("lastMsgContent", "");
      this.d.putInt("seq", this.e);
    }
    this.f.a.a(72, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.4
 * JD-Core Version:    0.7.0.1
 */