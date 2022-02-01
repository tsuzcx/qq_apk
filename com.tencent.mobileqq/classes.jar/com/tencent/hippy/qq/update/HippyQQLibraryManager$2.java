package com.tencent.hippy.qq.update;

import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;

class HippyQQLibraryManager$2
  implements OnLoadListener
{
  HippyQQLibraryManager$2(HippyQQLibraryManager paramHippyQQLibraryManager) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    HippyQQEngine.runTaskInUIThread(new HippyQQLibraryManager.2.1(this, paramInt, paramLoadExtResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.2
 * JD-Core Version:    0.7.0.1
 */