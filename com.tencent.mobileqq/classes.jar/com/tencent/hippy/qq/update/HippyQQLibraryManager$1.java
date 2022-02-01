package com.tencent.hippy.qq.update;

import bbzh;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class HippyQQLibraryManager$1
  implements bbzh
{
  HippyQQLibraryManager$1(HippyQQLibraryManager paramHippyQQLibraryManager) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if ((QLog.isColorLevel()) || (paramInt != 0)) {
      QLog.d("Hippy", 1, "Hippy: SoLoadManager download resCode=" + paramInt);
    }
    if (paramInt == 0) {
      this.this$0.updateSoVersions(paramLoadExtResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.1
 * JD-Core Version:    0.7.0.1
 */