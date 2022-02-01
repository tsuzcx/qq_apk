package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.api.IUpdateListener;

class HippyQQEngine$1
  implements IUpdateListener
{
  HippyQQEngine$1(HippyQQEngine paramHippyQQEngine, long paramLong) {}
  
  public void onUpdateFailed(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    HippyQQEngine.access$000(this.this$0, paramInt2, paramString1, null, this.val$checkStartTime);
  }
  
  public void onUpdateSuccess(int paramInt, String paramString)
  {
    HippyQQEngine.access$000(this.this$0, 0, "", null, this.val$checkStartTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.1
 * JD-Core Version:    0.7.0.1
 */