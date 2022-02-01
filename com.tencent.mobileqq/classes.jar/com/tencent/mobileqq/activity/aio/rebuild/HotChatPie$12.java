package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.app.HotchatSCMng.HotchatNote;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.qphone.base.util.QLog;

class HotChatPie$12
  implements HotchatSCHelper.OnShowNoteListener
{
  HotChatPie$12(HotChatPie paramHotChatPie) {}
  
  public boolean a(HotchatSCMng.HotchatNote paramHotchatNote)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a(this.a.b, "onShowHotchatNote", new Object[] { paramHotchatNote });
    }
    if (paramHotchatNote == null)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b) && (HotChatPie.a(this.a) != null)) {
        HotChatPie.b(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, null, null);
      }
      return false;
    }
    if (HotChatPie.c(this.a) == null) {
      HotChatPie.a(this.a, new TroopFeedsCenterLogic(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, HotChatPie.a(this.a), HotChatPie.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, HotChatPie.a(this.a), null));
    }
    HotChatPie.d(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramHotchatNote.a, paramHotchatNote.b);
    this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.12
 * JD-Core Version:    0.7.0.1
 */