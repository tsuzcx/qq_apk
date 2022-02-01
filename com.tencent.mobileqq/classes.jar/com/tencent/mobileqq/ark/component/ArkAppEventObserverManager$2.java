package com.tencent.mobileqq.ark.component;

import android.hardware.SensorEvent;
import com.tencent.qphone.base.util.QLog;

class ArkAppEventObserverManager$2
  implements Runnable
{
  ArkAppEventObserverManager$2(ArkAppEventObserverManager paramArkAppEventObserverManager, SensorEvent paramSensorEvent, long paramLong) {}
  
  public void run()
  {
    int i = 0;
    Object localObject;
    while (i < 3)
    {
      localObject = ArkAppEventObserverManager.i(this.this$0);
      double d1 = this.a.values[i];
      Double.isNaN(d1);
      double d2 = ArkAppEventObserverManager.i(this.this$0)[i];
      Double.isNaN(d2);
      localObject[i] = ((float)(d1 * 0.1D + d2 * 0.9D));
      ArkAppEventObserverManager.j(this.this$0)[i] = (this.a.values[i] - ArkAppEventObserverManager.i(this.this$0)[i]);
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("onMotionSensorChange curTime=");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", mMotionX=");
      ((StringBuilder)localObject).append(ArkAppEventObserverManager.j(this.this$0)[0]);
      ((StringBuilder)localObject).append(", mMotionY=");
      ((StringBuilder)localObject).append(ArkAppEventObserverManager.j(this.this$0)[1]);
      ((StringBuilder)localObject).append(", mMotionZ=");
      ((StringBuilder)localObject).append(ArkAppEventObserverManager.j(this.this$0)[2]);
      QLog.d("ArkAppEventObserverManager", 2, ((StringBuilder)localObject).toString());
    }
    if (ArkAppEventObserverManager.k(this.this$0) != null) {
      ArkAppEventObserverManager.k(this.this$0).a(true, ArkAppEventObserverManager.j(this.this$0)[0], ArkAppEventObserverManager.j(this.this$0)[1], ArkAppEventObserverManager.j(this.this$0)[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.2
 * JD-Core Version:    0.7.0.1
 */