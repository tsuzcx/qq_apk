package com.tencent.aekit.api.standard.ai;

import android.os.Handler;
import android.os.Looper;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

class AEDetector$2$1
  implements Runnable
{
  AEDetector$2$1(AEDetector.2 param2, IDetect paramIDetect) {}
  
  public void run()
  {
    try
    {
      localObject1 = this.val$detect.getModuleType();
      localObject1 = (Handler)AEDetector.access$200(this.this$1.this$0).get(localObject1);
      if (localObject1 == null) {
        break label86;
      }
      localObject1 = ((Handler)localObject1).getLooper();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        label69:
        LogUtils.e("AEDetector", localException);
        continue;
        label86:
        Object localObject2 = null;
      }
    }
    this.val$detect.clear();
    if (localObject1 != null)
    {
      if (!ApiHelper.hasJellyBeanMR2()) {
        break label69;
      }
      ((Looper)localObject1).quitSafely();
    }
    for (;;)
    {
      this.this$1.val$countDownLatch.countDown();
      return;
      ((Looper)localObject1).quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AEDetector.2.1
 * JD-Core Version:    0.7.0.1
 */