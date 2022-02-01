package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;

class TroopRobotHelper$1$1
  implements Runnable
{
  TroopRobotHelper$1$1(TroopRobotHelper.1 param1) {}
  
  public void run()
  {
    if ((TroopRobotHelper.a(this.a.a) instanceof BaseTroopChatPie))
    {
      ((BaseTroopChatPie)TroopRobotHelper.a(this.a.a)).R = false;
      this.a.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.1.1
 * JD-Core Version:    0.7.0.1
 */