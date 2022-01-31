package com.tencent.av.opengl.effects;

import com.tencent.qphone.base.util.QLog;

final class AEFilterSupport$CheckAEFilterTask
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterSupport", 2, "CheckAEFilterTask before[" + AEFilterSupport.a() + "]");
    }
    if (AEFilterSupport.a() != 1) {
      AEFilterSupport.a();
    }
    AEFilterSupport.a(null);
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterSupport", 2, "CheckAEFilterTask after[" + AEFilterSupport.a() + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterSupport.CheckAEFilterTask
 * JD-Core Version:    0.7.0.1
 */