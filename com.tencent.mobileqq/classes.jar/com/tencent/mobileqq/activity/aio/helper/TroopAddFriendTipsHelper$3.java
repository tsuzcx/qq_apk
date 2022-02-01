package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;

class TroopAddFriendTipsHelper$3
  implements Runnable
{
  TroopAddFriendTipsHelper$3(TroopAddFriendTipsHelper paramTroopAddFriendTipsHelper, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    TroopHandler localTroopHandler = (TroopHandler)TroopAddFriendTipsHelper.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (this.jdField_a_of_type_Boolean)
    {
      localTroopHandler.a().c(this.jdField_a_of_type_JavaLangString);
      return;
    }
    localTroopHandler.a().d(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.3
 * JD-Core Version:    0.7.0.1
 */