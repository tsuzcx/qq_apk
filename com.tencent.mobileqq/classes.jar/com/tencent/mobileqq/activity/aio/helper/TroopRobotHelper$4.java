package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troop.utils.RobotUtils;

class TroopRobotHelper$4
  implements Runnable
{
  TroopRobotHelper$4(TroopRobotHelper paramTroopRobotHelper, long paramLong) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!RobotUtils.d((QQAppInterface)localObject));
      localObject = (TroopHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (localObject == null);
    ((TroopHandler)localObject).f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.4
 * JD-Core Version:    0.7.0.1
 */