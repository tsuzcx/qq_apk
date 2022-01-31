package com.tencent.mobileqq.activity.aio.helper;

import acyp;
import ajtg;
import azgu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopRobotHelper$5
  implements Runnable
{
  public TroopRobotHelper$5(acyp paramacyp, long paramLong) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!azgu.d((QQAppInterface)localObject));
      localObject = (ajtg)((QQAppInterface)localObject).a(20);
    } while (localObject == null);
    ((ajtg)localObject).f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.5
 * JD-Core Version:    0.7.0.1
 */