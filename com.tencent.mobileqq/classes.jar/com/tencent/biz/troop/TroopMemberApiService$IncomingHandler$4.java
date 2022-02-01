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
    MessageRecord localMessageRecord = ((IBizTroopMemberInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IBizTroopMemberInfoService.class, "")).getRobotLastSpeakMessage(this.jdField_a_of_type_JavaLangString, this.b);
    if (localMessageRecord != null)
    {
      this.jdField_a_of_type_AndroidOsBundle.putLong("lastMsgTime", localMessageRecord.time);
      this.jdField_a_of_type_AndroidOsBundle.putString("lastMsgContent", localMessageRecord.msg);
      this.jdField_a_of_type_AndroidOsBundle.putInt("seq", this.jdField_a_of_type_Int);
    }
    else
    {
      this.jdField_a_of_type_AndroidOsBundle.putLong("lastMsgTime", 0L);
      this.jdField_a_of_type_AndroidOsBundle.putString("lastMsgContent", "");
      this.jdField_a_of_type_AndroidOsBundle.putInt("seq", this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a(72, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.4
 * JD-Core Version:    0.7.0.1
 */