package com.tencent.hippy.qq.update;

import bdgc;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.soload.LoadExtResult;

class HippyQQLibraryManager$2
  implements bdgc
{
  HippyQQLibraryManager$2(HippyQQLibraryManager paramHippyQQLibraryManager) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    HippyQQEngine.runTaskInUIThread(new HippyQQLibraryManager.2.1(this, paramInt, paramLoadExtResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.2
 * JD-Core Version:    0.7.0.1
 */