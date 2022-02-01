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
      NearbyUtils.a(this.a.b, "onShowHotchatNote", new Object[] { paramHotChatNote });
    }
    if (paramHotChatNote == null)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper.getCurShowingNote()) && (HotChatPie.a(this.a) != null)) {
        HotChatPie.b(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, null, null);
      }
      return false;
    }
    if (HotChatPie.c(this.a) == null)
    {
      HotChatPie localHotChatPie = this.a;
      HotChatPie.a(localHotChatPie, new TroopFeedsCenterLogic(localHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, HotChatPie.a(this.a), HotChatPie.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, HotChatPie.a(this.a), null));
    }
    HotChatPie.d(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramHotChatNote.a, paramHotChatNote.b);
    this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper.setCurShowingNote(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.11
 * JD-Core Version:    0.7.0.1
 */