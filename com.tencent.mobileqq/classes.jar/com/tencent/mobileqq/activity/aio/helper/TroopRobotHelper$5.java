package com.tencent.mobileqq.activity.aio.helper;

import afgn;
import amdu;
import bclg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopRobotHelper$5
  implements Runnable
{
  public TroopRobotHelper$5(afgn paramafgn, long paramLong) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!bclg.d((QQAppInterface)localObject));
      localObject = (amdu)((QQAppInterface)localObject).a(20);
    } while (localObject == null);
    ((amdu)localObject).f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.5
 * JD-Core Version:    0.7.0.1
 */