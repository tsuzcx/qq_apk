package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.qphone.base.util.QLog;

class RobotAdapter$4
  extends TroopBusinessObserver
{
  RobotAdapter$4(RobotAdapter paramRobotAdapter) {}
  
  public void onAddRobot(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((str != null) && (str.equals(RobotAdapter.a(this.a))))
    {
      RobotAdapter.a(this.a, String.valueOf(paramLong2), paramBoolean, paramInt);
      QLog.d("RobotAdapter", 2, "onAddRobot  success" + paramBoolean + " resultCode " + paramInt);
      return;
    }
    QLog.i("RobotAdapter", 2, "onAddRobot  troop" + paramLong1 + " cur " + RobotAdapter.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter.4
 * JD-Core Version:    0.7.0.1
 */