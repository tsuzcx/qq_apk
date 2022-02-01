package com.tencent.biz.game;

import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class SensorAPIJavaScript$1
{
  SensorAPIJavaScript$1(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b.mTAG, 1, "CheckPermission user denied = ");
    }
    this.b.callJs(this.a, new String[] { "false", "{result: -10, msg: 'no permission to record'}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b.mTAG, 1, "CheckPermission user grant = ");
    }
    SensorAPIJavaScript.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.1
 * JD-Core Version:    0.7.0.1
 */