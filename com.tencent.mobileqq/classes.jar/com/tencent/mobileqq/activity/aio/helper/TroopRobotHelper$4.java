package com.tencent.mobileqq.activity.aio.helper;

import agwy;
import aoip;
import bgpy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopRobotHelper$4
  implements Runnable
{
  public TroopRobotHelper$4(agwy paramagwy, long paramLong) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!bgpy.d((QQAppInterface)localObject));
      localObject = (aoip)((QQAppInterface)localObject).a(20);
    } while (localObject == null);
    ((aoip)localObject).f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.4
 * JD-Core Version:    0.7.0.1
 */