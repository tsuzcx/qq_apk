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
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("down", true);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a(86, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.5
 * JD-Core Version:    0.7.0.1
 */