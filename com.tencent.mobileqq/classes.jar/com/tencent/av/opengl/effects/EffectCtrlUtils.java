package com.tencent.av.opengl.effects;

import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class EffectCtrlUtils
{
  public static boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    int i = VcSystemInfo.getNumCores();
    StringBuilder localStringBuilder;
    if (i < paramInt)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice fail, cpuCount[");
      localStringBuilder.append(i);
      localStringBuilder.append(" < ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w("EffectCtrlUtils", 1, localStringBuilder.toString());
      return false;
    }
    long l = VcSystemInfo.getMaxCpuFreq();
    if ((l != 0L) && (l < paramLong1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice fail, cpuFrequency[");
      localStringBuilder.append(l);
      localStringBuilder.append(" < ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w("EffectCtrlUtils", 1, localStringBuilder.toString());
      return false;
    }
    paramLong1 = DeviceInfoUtil.a();
    if (paramLong1 < paramLong2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice fail, mem[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" < ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("]");
      QLog.w("EffectCtrlUtils", 1, localStringBuilder.toString());
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectCtrlUtils
 * JD-Core Version:    0.7.0.1
 */