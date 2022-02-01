package com.tencent.av.opengl.effects;

import com.tencent.qphone.base.util.QLog;

final class AEFilterSupport$CheckAEFilterTask
  implements Runnable
{
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CheckAEFilterTask before[");
      localStringBuilder.append(AEFilterSupport.b());
      localStringBuilder.append("]");
      QLog.i("AEFilterSupport", 2, localStringBuilder.toString());
    }
    if (AEFilterSupport.b() != 1) {
      AEFilterSupport.a();
    }
    AEFilterSupport.a(null);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CheckAEFilterTask after[");
      localStringBuilder.append(AEFilterSupport.b());
      localStringBuilder.append("]");
      QLog.i("AEFilterSupport", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterSupport.CheckAEFilterTask
 * JD-Core Version:    0.7.0.1
 */