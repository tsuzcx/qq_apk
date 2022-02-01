package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.api.IUpdateListener;

class HippyQQPreloadEngine$3
  implements IUpdateListener
{
  HippyQQPreloadEngine$3(HippyQQPreloadEngine paramHippyQQPreloadEngine) {}
  
  public void onUpdateFailed(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    HippyQQPreloadEngine.access$500(this.this$0, paramInt2, paramString1);
  }
  
  public void onUpdateSuccess(int paramInt, String paramString)
  {
    HippyQQPreloadEngine.access$500(this.this$0, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQPreloadEngine.3
 * JD-Core Version:    0.7.0.1
 */