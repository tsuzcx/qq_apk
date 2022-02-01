package com.huawei.hms.opendevice;

import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.support.log.HMSLog;

public class o
{
  public static boolean a()
  {
    int i = HwBuildEx.VERSION.EMUI_SDK_INT;
    HMSLog.d("CommFun", "Emui Api Level:" + i);
    return i > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.o
 * JD-Core Version:    0.7.0.1
 */