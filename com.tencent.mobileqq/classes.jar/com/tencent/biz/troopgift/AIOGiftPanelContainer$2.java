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
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("begin run time= ");
      ((StringBuilder)localObject).append(l - this.jdField_a_of_type_Long);
      QLog.d("TroopGiftPanel.time", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AIOAnimationControlManager)this.this$0.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    TroopGiftManager localTroopGiftManager = (TroopGiftManager)this.this$0.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
    int i;
    if (this.jdField_a_of_type_Int == 4) {
      i = 6;
    } else {
      i = 1;
    }
    int j;
    if ((this.this$0.a instanceof FriendChatPie))
    {
      i = 8;
      j = 11;
    }
    else
    {
      if ((this.this$0.a instanceof DiscussChatPie)) {}
      for (i = 9;; i = 10)
      {
        j = 4;
        break label172;
        if (!(this.this$0.a instanceof StrangerChatPie)) {
          break;
        }
      }
      j = 0;
    }
    label172:
    localTroopGiftManager.a("OidbSvc.0x6c3", 1731, 1, this.this$0.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, 2, i, j, new AIOGiftPanelContainer.2.1(this, localTroopGiftManager, l, (AIOAnimationControlManager)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer.2
 * JD-Core Version:    0.7.0.1
 */