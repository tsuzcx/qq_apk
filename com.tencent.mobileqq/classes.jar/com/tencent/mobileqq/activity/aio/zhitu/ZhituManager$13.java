package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Looper;

class ZhituManager$13
  implements Runnable
{
  ZhituManager$13(ZhituManager paramZhituManager) {}
  
  public void run()
  {
    ZhituManager localZhituManager = this.this$0;
    ZhituManager.a(localZhituManager, ZhituManager.a(localZhituManager));
    ZhituManager.a(this.this$0, false);
    Looper.myLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.13
 * JD-Core Version:    0.7.0.1
 */