package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotHandler;
import mqq.app.AppRuntime;

class TroopRobotShortcutBarService$8
  implements Runnable
{
  TroopRobotShortcutBarService$8(TroopRobotShortcutBarService paramTroopRobotShortcutBarService, long paramLong) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return;
    }
    if (((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getIfRobotRedInfoNeedUpdate((AppRuntime)localObject))
    {
      localObject = (ITroopRobotHandler)TroopRobotShortcutBarService.a(this.this$0).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopRobotHandlerName());
      if (localObject != null) {
        ((ITroopRobotHandler)localObject).c(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotShortcutBarService.8
 * JD-Core Version:    0.7.0.1
 */