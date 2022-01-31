package com.tencent.mobileqq.activity.aio.helper;

import adjp;
import akhp;
import bail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopRobotHelper$5
  implements Runnable
{
  public TroopRobotHelper$5(adjp paramadjp, long paramLong) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!bail.d((QQAppInterface)localObject));
      localObject = (akhp)((QQAppInterface)localObject).a(20);
    } while (localObject == null);
    ((akhp)localObject).f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.5
 * JD-Core Version:    0.7.0.1
 */