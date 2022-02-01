package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.hotchat.HotChatNote;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.qphone.base.util.QLog;

class HotChatPie$11
  implements IHotChatSCHelper.OnShowNoteListener
{
  HotChatPie$11(HotChatPie paramHotChatPie) {}
  
  public boolean a(HotChatNote paramHotChatNote)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a(this.a.c, "onShowHotchatNote", new Object[] { paramHotChatNote });
    }
    if (paramHotChatNote == null)
    {
      if ((this.a.bU.getCurShowingNote()) && (HotChatPie.b(this.a) != null)) {
        HotChatPie.c(this.a).a(this.a.d, this.a.e, null, null);
      }
      return false;
    }
    if (HotChatPie.d(this.a) == null)
    {
      HotChatPie localHotChatPie = this.a;
      HotChatPie.a(localHotChatPie, new TroopFeedsCenterLogic(localHotChatPie.d, this.a.f, this.a.ah, HotChatPie.e(this.a), HotChatPie.f(this.a), this.a.bp, HotChatPie.g(this.a), null));
    }
    HotChatPie.h(this.a).a(this.a.d, this.a.e, paramHotChatNote.c, paramHotChatNote.d);
    this.a.bU.setCurShowingNote(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.11
 * JD-Core Version:    0.7.0.1
 */