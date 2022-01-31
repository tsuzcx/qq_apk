package com.tencent.aekit.api.standard.ai;

import android.os.Handler;
import android.os.Looper;
import com.tencent.aekit.plugin.core.AIDataStorage;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import java.util.Map;

class AEDetector$5
  implements Runnable
{
  AEDetector$5(AEDetector paramAEDetector, IDetect paramIDetect, String paramString) {}
  
  public void run()
  {
    this.val$initedDetector.clear();
    if (ApiHelper.hasJellyBeanMR2()) {
      ((Handler)AEDetector.access$200(this.this$0).get(this.val$key)).getLooper().quitSafely();
    }
    for (;;)
    {
      AEDetector.access$200(this.this$0).remove(this.val$key);
      AEDetector.access$300(this.this$0).remove(this.val$key);
      AEDetector.access$400(this.this$0).remove(this.val$key);
      AEDetector.access$500(this.this$0).remove(this.val$key);
      AEDetector.access$600(this.this$0).remove(this.val$key);
      AEDetector.access$1800(this.this$0).remove(this.val$key);
      AEDetector.access$1000(this.this$0).remove(this.val$key);
      return;
      ((Handler)AEDetector.access$200(this.this$0).get(this.val$key)).getLooper().quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AEDetector.5
 * JD-Core Version:    0.7.0.1
 */