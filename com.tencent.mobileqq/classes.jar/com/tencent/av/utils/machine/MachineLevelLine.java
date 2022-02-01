package com.tencent.av.utils.machine;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class MachineLevelLine
  extends MachineInfo
{
  public MachineLevelLine(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public MachineLevelLine(MachineLevelLine paramMachineLevelLine)
  {
    if (paramMachineLevelLine != null)
    {
      this.jdField_a_of_type_Int = paramMachineLevelLine.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramMachineLevelLine.jdField_b_of_type_Int;
      this.jdField_a_of_type_Float = paramMachineLevelLine.jdField_a_of_type_Float;
      this.jdField_b_of_type_Float = paramMachineLevelLine.jdField_b_of_type_Float;
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("MachineLevelLine", 2, paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        StringBuilder localStringBuilder = paramString[i];
        if (localStringBuilder != null)
        {
          int k = localStringBuilder.indexOf('=');
          if ((k > 0) && (k < localStringBuilder.length())) {
            try
            {
              String str = localStringBuilder.substring(0, k);
              float f = Float.parseFloat(localStringBuilder.substring(k + 1));
              if ("MemoryLimit".equalsIgnoreCase(str))
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("MemoryLimit:  ");
                localStringBuilder.append(f);
                QLog.i("MachineLevelLine", 2, localStringBuilder.toString());
                this.jdField_b_of_type_Float = f;
              }
              else if ("CpuNumLimit".equalsIgnoreCase(str))
              {
                this.jdField_b_of_type_Int = ((int)f);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("CpuNumLimit:  ");
                localStringBuilder.append(f);
                QLog.i("MachineLevelLine", 2, localStringBuilder.toString());
              }
              else if ("CpuFreqLimit".equalsIgnoreCase(str))
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("CpuFreqLimit:  ");
                localStringBuilder.append(f);
                QLog.i("MachineLevelLine", 2, localStringBuilder.toString());
                this.jdField_a_of_type_Float = f;
              }
              else if ("APILevelLimit".equalsIgnoreCase(str))
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("APILevelLimit:  ");
                localStringBuilder.append(f);
                QLog.i("MachineLevelLine", 2, localStringBuilder.toString());
                this.jdField_a_of_type_Int = ((int)f);
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean a(@NonNull MachineInfo paramMachineInfo)
  {
    return (this.jdField_a_of_type_Int <= paramMachineInfo.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int <= paramMachineInfo.jdField_b_of_type_Int) && (this.jdField_a_of_type_Float <= paramMachineInfo.jdField_a_of_type_Float) && (this.jdField_b_of_type_Float <= paramMachineInfo.jdField_b_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.machine.MachineLevelLine
 * JD-Core Version:    0.7.0.1
 */