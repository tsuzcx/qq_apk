package com.tencent.mobileqq.activity.aio.helper;

import aoep;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;

class TroopAddFriendTipsHelper$3
  implements Runnable
{
  TroopAddFriendTipsHelper$3(TroopAddFriendTipsHelper paramTroopAddFriendTipsHelper, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    aoep localaoep = (aoep)TroopAddFriendTipsHelper.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (this.jdField_a_of_type_Boolean)
    {
      localaoep.a().c(this.jdField_a_of_type_JavaLangString);
      return;
    }
    localaoep.a().d(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.3
 * JD-Core Version:    0.7.0.1
 */