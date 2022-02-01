package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.api.PackageUpdateListener;

class HippyQQEngine$1
  implements PackageUpdateListener
{
  HippyQQEngine$1(HippyQQEngine paramHippyQQEngine, long paramLong) {}
  
  public void onUpdateComplete(int paramInt, String paramString1, String paramString2)
  {
    HippyQQEngine.access$000(this.this$0, paramInt, paramString1, paramString2, this.val$checkStartTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.1
 * JD-Core Version:    0.7.0.1
 */