package com.tencent.aekit.api.standard.ai;

import android.os.Handler;
import android.os.Looper;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

class AEDetector$2$1
  implements Runnable
{
  AEDetector$2$1(AEDetector.2 param2, IDetect paramIDetect) {}
  
  public void run()
  {
    String str = this.val$detect.getModuleType();
    Handler localHandler = (Handler)AEDetector.access$200(this.this$1.this$0).get(str);
    this.val$detect.clear();
    if ((localHandler != null) && (localHandler.getLooper() != null))
    {
      if (!ApiHelper.hasJellyBeanMR2()) {
        break label88;
      }
      ((Handler)AEDetector.access$200(this.this$1.this$0).get(str)).getLooper().quitSafely();
    }
    for (;;)
    {
      this.this$1.val$countDownLatch.countDown();
      return;
      label88:
      ((Handler)AEDetector.access$200(this.this$1.this$0).get(str)).getLooper().quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AEDetector.2.1
 * JD-Core Version:    0.7.0.1
 */