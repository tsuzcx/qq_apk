package com.tencent.av.utils.machine;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class MachineLevelHelper
{
  private static final MachineLevelLine jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelLine = new MachineLevelLine(21, 4, 1.1F, 2.7F);
  private static final MachineLevelLine b = new MachineLevelLine(27, 8, 1.8F, 5.0F);
  private int jdField_a_of_type_Int = 0;
  private MachineInfo jdField_a_of_type_ComTencentAvUtilsMachineMachineInfo = null;
  
  public MachineLevelHelper(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelLine.a(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      b.a(paramString2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MachineLevelHelper", 2, String.format("init, middle[%s], high[%s], config[%s, %s]", new Object[] { jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelLine, b, paramString1, paramString2 }));
    }
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      return i;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsMachineMachineInfo == null) {
      this.jdField_a_of_type_ComTencentAvUtilsMachineMachineInfo = MachineInfo.a();
    }
    if (b.a(this.jdField_a_of_type_ComTencentAvUtilsMachineMachineInfo)) {
      this.jdField_a_of_type_Int = 7;
    } else if (jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelLine.a(this.jdField_a_of_type_ComTencentAvUtilsMachineMachineInfo)) {
      this.jdField_a_of_type_Int = 4;
    } else {
      this.jdField_a_of_type_Int = 3;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MachineLevelHelper", 2, String.format("getCurMachineLevel, level: %s, middle[%s], high[%s], cur[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelLine, b, this.jdField_a_of_type_ComTencentAvUtilsMachineMachineInfo }));
    }
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.machine.MachineLevelHelper
 * JD-Core Version:    0.7.0.1
 */