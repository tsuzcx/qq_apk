package com.tencent.av.utils.machine;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class MachineInfo
{
  public int a;
  public int b;
  public float c;
  public float d;
  
  public static MachineInfo a()
  {
    MachineInfo localMachineInfo = new MachineInfo();
    localMachineInfo.a = Build.VERSION.SDK_INT;
    localMachineInfo.d = ((float)DeviceInfoUtil.a() / 1.073742E+009F);
    localMachineInfo.b = DeviceInfoUtil.h();
    localMachineInfo.c = ((float)VcSystemInfo.getMaxCpuFreq() / 1048576.0F);
    return localMachineInfo;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[apiLevel: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", cpuNum: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", maxFreqGHZ: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ramSizeGB:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.machine.MachineInfo
 * JD-Core Version:    0.7.0.1
 */