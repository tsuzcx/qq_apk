package com.tencent.mm.opensdk.openapi;

import com.tencent.mm.opensdk.utils.Log;
import java.util.concurrent.CountDownLatch;

class BaseWXApiImplV10$1
  implements Runnable
{
  BaseWXApiImplV10$1(BaseWXApiImplV10 paramBaseWXApiImplV10, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      MMSharedPreferences localMMSharedPreferences = new MMSharedPreferences(this.this$0.context);
      BaseWXApiImplV10.access$002(this.this$0, localMMSharedPreferences.getInt("_build_info_sdk_int_", 0));
      this.val$countDownWait.countDown();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.SDK.WXApiImplV10", localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.1
 * JD-Core Version:    0.7.0.1
 */