package com.tencent.biz.troopgift;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.qphone.base.util.QLog;

class AIOGiftPanelContainer$2
  implements Runnable
{
  AIOGiftPanelContainer$2(AIOGiftPanelContainer paramAIOGiftPanelContainer, long paramLong, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 4;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel.time", 2, "begin run time= " + (l - this.jdField_a_of_type_Long));
    }
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.this$0.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    TroopGiftManager localTroopGiftManager = (TroopGiftManager)this.this$0.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
    int i;
    if (this.jdField_a_of_type_Int == 4)
    {
      i = 6;
      if (!(this.this$0.a instanceof FriendChatPie)) {
        break label160;
      }
      j = 11;
      i = 8;
    }
    for (;;)
    {
      localTroopGiftManager.a("OidbSvc.0x6c3", 1731, 1, this.this$0.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, 2, i, j, new AIOGiftPanelContainer.2.1(this, localTroopGiftManager, l, localAIOAnimationControlManager));
      return;
      i = 1;
      break;
      label160:
      if ((this.this$0.a instanceof DiscussChatPie)) {
        i = 9;
      } else if ((this.this$0.a instanceof StrangerChatPie)) {
        i = 10;
      } else {
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer.2
 * JD-Core Version:    0.7.0.1
 */