package com.tencent.aekit.api.standard.ai;

import android.os.Handler;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIDataStorage;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

class AEDetector$2
  implements Runnable
{
  AEDetector$2(AEDetector paramAEDetector, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    Iterator localIterator = AEDetector.access$100(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      IDetect localIDetect = (IDetect)localIterator.next();
      if (!localIDetect.getModuleType().equals(AEDetectorType.FACE.value))
      {
        Handler localHandler = (Handler)AEDetector.access$200(this.this$0).get(localIDetect.getModuleType());
        if (localHandler != null)
        {
          localHandler.removeCallbacksAndMessages(null);
          localHandler.post(new AEDetector.2.1(this, localIDetect));
        }
      }
    }
    if (AEDetector.access$100(this.this$0) != null) {
      AEDetector.access$100(this.this$0).clear();
    }
    if (AEDetector.access$300(this.this$0) != null) {
      AEDetector.access$300(this.this$0).clear();
    }
    if (AEDetector.access$400(this.this$0) != null) {
      AEDetector.access$400(this.this$0).clear();
    }
    if (AEDetector.access$500(this.this$0) != null) {
      AEDetector.access$500(this.this$0).clear();
    }
    if (AEDetector.access$600(this.this$0) != null) {
      AEDetector.access$600(this.this$0).clear();
    }
    if (AEDetector.access$700(this.this$0) != null) {
      AEDetector.access$700(this.this$0).clear();
    }
    if (AEDetector.access$800(this.this$0) != null) {
      AEDetector.access$800(this.this$0).clear();
    }
    if (AEDetector.access$900(this.this$0) != null) {
      AEDetector.access$900(this.this$0).clear();
    }
    if (AEDetector.access$1000(this.this$0) != null) {
      AEDetector.access$1000(this.this$0).clear();
    }
    AEDetector.access$1102(this.this$0, null);
    AEDetector.access$1202(this.this$0, null);
    RetrieveDataManager.getInstance().clear();
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AEDetector.2
 * JD-Core Version:    0.7.0.1
 */