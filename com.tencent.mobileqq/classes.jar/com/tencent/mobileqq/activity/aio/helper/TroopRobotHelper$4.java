package com.tencent.mobileqq.activity.aio.helper;

import agld;
import aoep;
import bghs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopRobotHelper$4
  implements Runnable
{
  public TroopRobotHelper$4(agld paramagld, long paramLong) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!bghs.d((QQAppInterface)localObject));
      localObject = (aoep)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (localObject == null);
    ((aoep)localObject).f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.4
 * JD-Core Version:    0.7.0.1
 */