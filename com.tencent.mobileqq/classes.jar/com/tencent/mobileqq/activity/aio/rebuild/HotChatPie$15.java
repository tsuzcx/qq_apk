package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;

class HotChatPie$15
  implements Runnable
{
  HotChatPie$15(HotChatPie paramHotChatPie, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (HotChatPie.e(this.this$0) == null)
    {
      localObject = this.this$0;
      HotChatPie.b((HotChatPie)localObject, new TroopFeedsCenterLogic(((HotChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, HotChatPie.b(this.this$0), HotChatPie.b(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, HotChatPie.b(this.this$0), null));
    }
    Object localObject = (IHotChatHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
    if (this.a.userCreate == 1)
    {
      ((IHotChatHandler)localObject).getUserCreateHotChatAnnounce(this.a.troopUin);
      return;
    }
    if (this.a.uuid != null) {
      ((IHotChatHandler)localObject).getHotChatAnnounce(this.a.uuid.getBytes(), this.a.troopUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.15
 * JD-Core Version:    0.7.0.1
 */