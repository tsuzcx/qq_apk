package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

class TroopMemberApiService$IncomingHandler$5
  extends DownloadListener
{
  TroopMemberApiService$IncomingHandler$5(TroopMemberApiService.IncomingHandler paramIncomingHandler, Bundle paramBundle) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    this.a.putBoolean("down", true);
    this.b.a.a(86, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.5
 * JD-Core Version:    0.7.0.1
 */