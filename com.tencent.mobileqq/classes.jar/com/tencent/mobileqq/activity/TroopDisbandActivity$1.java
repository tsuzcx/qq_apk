package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopDisbandActivity$1
  implements Runnable
{
  TroopDisbandActivity$1(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = (ITroopMemberListHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
      ITroopListHandler localITroopListHandler = (ITroopListHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER);
      if ((localObject != null) && (localITroopListHandler != null))
      {
        long l = Long.parseLong(this.this$0.k);
        ((ITroopMemberListHandler)localObject).a(l, 0L, 5, 6, 1);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(Long.valueOf(l));
        localITroopListHandler.a((ArrayList)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.disband", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.1
 * JD-Core Version:    0.7.0.1
 */