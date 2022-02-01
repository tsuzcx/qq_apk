package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import com.tencent.qphone.base.util.QLog;

class RobotAdapter$4
  extends TroopRobotObserver
{
  RobotAdapter$4(RobotAdapter paramRobotAdapter) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = String.valueOf(paramLong1);
    if ((localObject != null) && (((String)localObject).equals(RobotAdapter.b(this.a))))
    {
      RobotAdapter.a(this.a, String.valueOf(paramLong2), paramBoolean, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAddRobot  success");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" resultCode ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("RobotAdapter", 2, ((StringBuilder)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAddRobot  troop");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" cur ");
    ((StringBuilder)localObject).append(RobotAdapter.b(this.a));
    QLog.i("RobotAdapter", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter.4
 * JD-Core Version:    0.7.0.1
 */