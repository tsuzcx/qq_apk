package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

class ConfessChatPie$3
  implements Runnable
{
  ConfessChatPie$3(ConfessChatPie paramConfessChatPie) {}
  
  public void run()
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(this.this$0.a, "qq_confess_holmes_progress_lottie.json", new ConfessChatPie.3.1(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.this$0.b, 1, "loadHolmesProgressAnimation fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3
 * JD-Core Version:    0.7.0.1
 */