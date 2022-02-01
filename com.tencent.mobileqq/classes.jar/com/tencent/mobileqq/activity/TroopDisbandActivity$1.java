package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
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
      Object localObject = (TroopHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      TroopListHandler localTroopListHandler = (TroopListHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER);
      if ((localObject != null) && (localTroopListHandler != null))
      {
        long l = Long.parseLong(this.this$0.a);
        ((TroopHandler)localObject).a(l, 0L, 5, 6, 1);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(Long.valueOf(l));
        localTroopListHandler.b((ArrayList)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.disband", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.1
 * JD-Core Version:    0.7.0.1
 */