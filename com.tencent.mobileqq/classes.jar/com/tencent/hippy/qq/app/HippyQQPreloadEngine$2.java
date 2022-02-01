package com.tencent.hippy.qq.app;

import com.tencent.qphone.base.util.QLog;

class HippyQQPreloadEngine$2
  implements Runnable
{
  HippyQQPreloadEngine$2(HippyQQPreloadEngine paramHippyQQPreloadEngine) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HippyQQPreloadEngine", 2, "onJsBundleUpdateComplte run");
    }
    HippyQQPreloadEngine.access$302(this.this$0, true);
    HippyQQPreloadEngine.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQPreloadEngine.2
 * JD-Core Version:    0.7.0.1
 */