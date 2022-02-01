package com.tencent.mobileqq.activity.aio.rebuild;

import ahey;
import ahfb;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;

public class ConfessChatPie$3
  implements Runnable
{
  public ConfessChatPie$3(ahey paramahey) {}
  
  public void run()
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(this.this$0.mContext, "qq_confess_holmes_progress_lottie.json", new ahfb(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.this$0.tag, 1, "loadHolmesProgressAnimation fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3
 * JD-Core Version:    0.7.0.1
 */