package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;
import com.tencent.mobileqq.statistics.ReportController;

class CaiShenActivity$6
  extends SimpleSensorChangeListener
{
  CaiShenActivity$6(CaiShenActivity paramCaiShenActivity) {}
  
  public void onSensorSupport(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 4) {
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (String str = "1";; str = "0")
    {
      ReportController.b(null, "dc01440", "", "", "0X8007A39", "0X8007A39", 0, 0, str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.6
 * JD-Core Version:    0.7.0.1
 */