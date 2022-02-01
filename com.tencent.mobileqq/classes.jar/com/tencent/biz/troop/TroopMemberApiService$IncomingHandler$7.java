package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.hotchat.HotChatNote;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.hotchat.api.IHotChatSCMng;
import com.tencent.mobileqq.hotchat.helper.HotChatHelper;

class TroopMemberApiService$IncomingHandler$7
  implements IHotChatSCHelper.OnShowNoteListener
{
  TroopMemberApiService$IncomingHandler$7(TroopMemberApiService.IncomingHandler paramIncomingHandler, Bundle paramBundle) {}
  
  public boolean a(HotChatNote paramHotChatNote)
  {
    Bundle localBundle = new Bundle();
    HotChatNote localHotChatNote = paramHotChatNote;
    if (paramHotChatNote == null) {
      localHotChatNote = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a.getHotChatSCMng().getHotChatNote(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a.getActID(), 1, HotChatHelper.a());
    }
    if (localHotChatNote != null)
    {
      localBundle.putString("url", localHotChatNote.b);
      localBundle.putString("content", localHotChatNote.a);
    }
    else
    {
      localBundle.putString("url", "");
      localBundle.putString("content", "");
    }
    localBundle.putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq", -1));
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler.a.a(101, localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.7
 * JD-Core Version:    0.7.0.1
 */