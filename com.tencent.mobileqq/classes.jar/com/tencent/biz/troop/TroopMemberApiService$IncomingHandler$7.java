package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.app.HotchatSCMng;
import com.tencent.mobileqq.app.HotchatSCMng.HotchatNote;

class TroopMemberApiService$IncomingHandler$7
  implements HotchatSCHelper.OnShowNoteListener
{
  TroopMemberApiService$IncomingHandler$7(TroopMemberApiService.IncomingHandler paramIncomingHandler, Bundle paramBundle) {}
  
  public boolean a(HotchatSCMng.HotchatNote paramHotchatNote)
  {
    Bundle localBundle = new Bundle();
    HotchatSCMng.HotchatNote localHotchatNote = paramHotchatNote;
    if (paramHotchatNote == null) {
      localHotchatNote = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCMng.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a.jdField_a_of_type_JavaLangString, 1, HotchatSCHelper.a());
    }
    if (localHotchatNote != null)
    {
      localBundle.putString("url", localHotchatNote.b);
      localBundle.putString("content", localHotchatNote.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      localBundle.putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq", -1));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a(101, localBundle);
      return false;
      localBundle.putString("url", "");
      localBundle.putString("content", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.7
 * JD-Core Version:    0.7.0.1
 */