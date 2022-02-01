package com.tencent.biz.troop;

import aaor;
import android.os.Bundle;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopMemberApiService$IncomingHandler$4
  implements Runnable
{
  public TroopMemberApiService$IncomingHandler$4(aaor paramaaor, TroopManager paramTroopManager, String paramString1, String paramString2, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_JavaLangString, this.b);
    if (localMessageRecord != null)
    {
      this.jdField_a_of_type_AndroidOsBundle.putLong("lastMsgTime", localMessageRecord.time);
      this.jdField_a_of_type_AndroidOsBundle.putString("lastMsgContent", localMessageRecord.msg);
      this.jdField_a_of_type_AndroidOsBundle.putInt("seq", this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aaor.a.a(72, this.jdField_a_of_type_AndroidOsBundle);
      return;
      this.jdField_a_of_type_AndroidOsBundle.putLong("lastMsgTime", 0L);
      this.jdField_a_of_type_AndroidOsBundle.putString("lastMsgContent", "");
      this.jdField_a_of_type_AndroidOsBundle.putInt("seq", this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.4
 * JD-Core Version:    0.7.0.1
 */