package com.tencent.hippy.qq.update;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class HippyQQLibraryManager$3$1
  implements AsyncBack
{
  HippyQQLibraryManager$3$1(HippyQQLibraryManager.3 param3) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Hippy", 2, "Hippy: checkUpByBusinessIdWithRightUnzip code=" + paramInt + ", param=" + paramString);
    }
    if ((paramInt != 0) || (paramString == null)) {}
    while (!paramString.contains("url")) {
      return;
    }
    UpdateSetting.getInstance().setCDNUpdateFlag(true);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.3.1
 * JD-Core Version:    0.7.0.1
 */