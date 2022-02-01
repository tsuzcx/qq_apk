package com.tencent.av.utils.machine;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class MachineLevelHelper
{
  private static final MachineLevelLine a = new MachineLevelLine(21, 4, 1.1F, 2.7F);
  private static final MachineLevelLine b = new MachineLevelLine(27, 8, 1.8F, 5.0F);
  private MachineInfo c = null;
  private int d = 0;
  
  public MachineLevelHelper(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      a.a(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      b.a(paramString2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MachineLevelHelper", 2, String.format("init, middle[%s], high[%s], config[%s, %s]", new Object[] { a, b, paramString1, paramString2 }));
    }
  }
  
  public int a()
  {
    int i = this.d;
    if (i != 0) {
      return i;
    }
    if (this.c == null) {
      this.c = MachineInfo.a();
    }
    if (b.a(this.c)) {
      this.d = 7;
    } else if (a.a(this.c)) {
      this.d = 4;
    } else {
      this.d = 3;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MachineLevelHelper", 2, String.format("getCurMachineLevel, level: %s, middle[%s], high[%s], cur[%s]", new Object[] { Integer.valueOf(this.d), a, b, this.c }));
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.machine.MachineLevelHelper
 * JD-Core Version:    0.7.0.1
 */