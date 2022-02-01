package com.tencent.mobileqq.activity.aio.helper;

import aftj;
import anca;
import bezm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopRobotHelper$4
  implements Runnable
{
  public TroopRobotHelper$4(aftj paramaftj, long paramLong) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!bezm.d((QQAppInterface)localObject));
      localObject = (anca)((QQAppInterface)localObject).getBusinessHandler(20);
    } while (localObject == null);
    ((anca)localObject).f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.4
 * JD-Core Version:    0.7.0.1
 */