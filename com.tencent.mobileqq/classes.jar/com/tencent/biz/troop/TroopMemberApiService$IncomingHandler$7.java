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
      localHotChatNote = this.b.a.w.getHotChatSCMng().getHotChatNote(this.b.a.w.getActID(), 1, HotChatHelper.a());
    }
    if (localHotChatNote != null)
    {
      localBundle.putString("url", localHotChatNote.d);
      localBundle.putString("content", localHotChatNote.c);
    }
    else
    {
      localBundle.putString("url", "");
      localBundle.putString("content", "");
    }
    localBundle.putInt("seq", this.a.getInt("seq", -1));
    this.b.a.a(101, localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.7
 * JD-Core Version:    0.7.0.1
 */