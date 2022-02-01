package com.tencent.hippy.qq.update;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class HippyQQLibraryManager$1
  implements OnLoadListener
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.1
 * JD-Core Version:    0.7.0.1
 */