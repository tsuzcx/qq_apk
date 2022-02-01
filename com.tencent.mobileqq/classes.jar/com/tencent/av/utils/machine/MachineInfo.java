package com.tencent.av.utils.machine;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class MachineInfo
{
  public float a;
  public int a;
  public float b;
  public int b;
  
  public static MachineInfo a()
  {
    MachineInfo localMachineInfo = new MachineInfo();
    localMachineInfo.jdField_a_of_type_Int = Build.VERSION.SDK_INT;
    localMachineInfo.jdField_b_of_type_Float = ((float)DeviceInfoUtil.a() / 1.073742E+009F);
    localMachineInfo.jdField_b_of_type_Int = DeviceInfoUtil.b();
    localMachineInfo.jdField_a_of_type_Float = ((float)VcSystemInfo.getMaxCpuFreq() / 1048576.0F);
    return localMachineInfo;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[apiLevel: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", cpuNum: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", maxFreqGHZ: ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", ramSizeGB:");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.machine.MachineInfo
 * JD-Core Version:    0.7.0.1
 */