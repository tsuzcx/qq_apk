package com.tencent.avgame.util;

import android.os.Build;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.effects.AEFilterSupport.MachineInfo;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class AvGameMachineLevelUtils
{
  public static final AvGameMachineLevelUtils.MachineLevelLine a = new AvGameMachineLevelUtils.MachineLevelLine(27, 8, 2.0F, 5.0F);
  public static final AvGameMachineLevelUtils.MachineLevelLine b = new AvGameMachineLevelUtils.MachineLevelLine(23, 6, 1.8F, 3.0F);
  public static final AvGameMachineLevelUtils.MachineLevelLine c = new AvGameMachineLevelUtils.MachineLevelLine(21, 4, 1.3F, 2.6F);
  
  public static int a()
  {
    AvGameMachineLevelUtils.MachineLevelLine localMachineLevelLine3 = b;
    AvGameMachineLevelUtils.MachineLevelLine localMachineLevelLine2 = c;
    AvGameMachineLevelUtils.MachineLevelLine localMachineLevelLine1 = a;
    Object localObject = (AvGameConfBean)QConfigManager.a().a(642);
    if (localObject != null)
    {
      localMachineLevelLine3 = ((AvGameConfBean)localObject).b();
      localMachineLevelLine2 = ((AvGameConfBean)localObject).c();
      localMachineLevelLine1 = ((AvGameConfBean)localObject).a();
    }
    for (;;)
    {
      localObject = AEFilterSupport.a();
      if (QLog.isColorLevel()) {
        QLog.d("AvGameMachineLevelUtils", 2, ((AEFilterSupport.MachineInfo)localObject).toString());
      }
      if (localObject != null) {
        break;
      }
      QLog.e("AvGameMachineLevelUtils", 2, "getCurMachineInfo null");
      return 2;
      QLog.e("AvGameMachineLevelUtils", 2, "getCurMachineLevel no bean");
    }
    int i;
    if (a()) {
      i = 0;
    }
    for (;;)
    {
      QLog.d("AvGameMachineLevelUtils", 2, "getCurMachine level is " + i + " api=" + ((AEFilterSupport.MachineInfo)localObject).jdField_a_of_type_Int + " cpuNum:" + ((AEFilterSupport.MachineInfo)localObject).jdField_b_of_type_Int + " maxFreqGHZ=" + ((AEFilterSupport.MachineInfo)localObject).jdField_a_of_type_Float + " ramSizeGB:" + ((AEFilterSupport.MachineInfo)localObject).jdField_b_of_type_Float);
      QLog.d("AvGameMachineLevelUtils", 2, "lowMatchine level is  api=" + localMachineLevelLine2.jdField_a_of_type_Int + " cpuNum:" + localMachineLevelLine2.jdField_b_of_type_Int + " maxFreqGHZ=" + localMachineLevelLine2.jdField_a_of_type_Float + " ramSizeGB:" + localMachineLevelLine2.jdField_b_of_type_Float);
      return i;
      if (localMachineLevelLine1.a((AEFilterSupport.MachineInfo)localObject)) {
        i = 3;
      } else if (localMachineLevelLine3.a((AEFilterSupport.MachineInfo)localObject)) {
        i = 2;
      } else if (localMachineLevelLine2.a((AEFilterSupport.MachineInfo)localObject)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static boolean a()
  {
    return Build.MODEL.equalsIgnoreCase("MI 5C");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.util.AvGameMachineLevelUtils
 * JD-Core Version:    0.7.0.1
 */