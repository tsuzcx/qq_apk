package com.tencent.avgame.ui;

import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.qphone.base.util.QLog;

class AVGameActivity$1
  implements FPSCalculator.GetFPSListener
{
  AVGameActivity$1(AVGameActivity paramAVGameActivity) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameActivity", 2, String.format("fps=%.1f", new Object[] { Double.valueOf(paramDouble) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.1
 * JD-Core Version:    0.7.0.1
 */