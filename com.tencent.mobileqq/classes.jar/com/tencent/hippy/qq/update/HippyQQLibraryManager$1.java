package com.tencent.hippy.qq.update;

import bdgt;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class HippyQQLibraryManager$1
  implements bdgt
{
  HippyQQLibraryManager$1(HippyQQLibraryManager paramHippyQQLibraryManager) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Hippy", 2, "Hippy: SoLoadManager download resCode=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.1
 * JD-Core Version:    0.7.0.1
 */