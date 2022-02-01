package com.tencent.avgame.util;

import android.os.Build;
import com.tencent.av.utils.machine.MachineInfo;
import com.tencent.av.utils.machine.MachineLevelLine;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.qphone.base.util.QLog;

public class AvGameMachineLevelUtils
{
  public static final MachineLevelLine a = new MachineLevelLine(27, 8, 2.0F, 5.0F);
  public static final MachineLevelLine b = new MachineLevelLine(23, 6, 1.8F, 3.0F);
  public static final MachineLevelLine c = new MachineLevelLine(21, 4, 1.3F, 2.6F);
  
  public static int a()
  {
    Object localObject1 = b;
    MachineLevelLine localMachineLevelLine1 = c;
    MachineLevelLine localMachineLevelLine2 = a;
    Object localObject2 = AvGameConfigUtil.a();
    if (localObject2 != null)
    {
      localObject1 = ((AvGameConfBean)localObject2).h();
      localMachineLevelLine1 = ((AvGameConfBean)localObject2).i();
      localMachineLevelLine2 = ((AvGameConfBean)localObject2).e();
    }
    else
    {
      QLog.e("AvGameMachineLevelUtils", 2, "getCurMachineLevel no bean");
    }
    localObject2 = MachineInfo.a();
    if (QLog.isColorLevel()) {
      QLog.d("AvGameMachineLevelUtils", 2, ((MachineInfo)localObject2).toString());
    }
    if (localObject2 == null)
    {
      QLog.e("AvGameMachineLevelUtils", 2, "getCurMachineInfo null");
      return 2;
    }
    if (b()) {}
    do
    {
      i = 0;
      break;
      if (localMachineLevelLine2.a((MachineInfo)localObject2))
      {
        i = 3;
        break;
      }
      if (((MachineLevelLine)localObject1).a((MachineInfo)localObject2))
      {
        i = 2;
        break;
      }
    } while (!localMachineLevelLine1.a((MachineInfo)localObject2));
    int i = 1;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getCurMachine level is ");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(" api=");
    ((StringBuilder)localObject1).append(((MachineInfo)localObject2).a);
    ((StringBuilder)localObject1).append(" cpuNum:");
    ((StringBuilder)localObject1).append(((MachineInfo)localObject2).b);
    ((StringBuilder)localObject1).append(" maxFreqGHZ=");
    ((StringBuilder)localObject1).append(((MachineInfo)localObject2).c);
    ((StringBuilder)localObject1).append(" ramSizeGB:");
    ((StringBuilder)localObject1).append(((MachineInfo)localObject2).d);
    QLog.d("AvGameMachineLevelUtils", 2, ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("lowMatchine level is  api=");
    ((StringBuilder)localObject1).append(localMachineLevelLine1.a);
    ((StringBuilder)localObject1).append(" cpuNum:");
    ((StringBuilder)localObject1).append(localMachineLevelLine1.b);
    ((StringBuilder)localObject1).append(" maxFreqGHZ=");
    ((StringBuilder)localObject1).append(localMachineLevelLine1.c);
    ((StringBuilder)localObject1).append(" ramSizeGB:");
    ((StringBuilder)localObject1).append(localMachineLevelLine1.d);
    QLog.d("AvGameMachineLevelUtils", 2, ((StringBuilder)localObject1).toString());
    return i;
  }
  
  public static boolean b()
  {
    return Build.MODEL.equalsIgnoreCase("MI 5C");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.AvGameMachineLevelUtils
 * JD-Core Version:    0.7.0.1
 */