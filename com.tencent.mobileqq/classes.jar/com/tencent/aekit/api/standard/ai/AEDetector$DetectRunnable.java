package com.tencent.aekit.api.standard.ai;

import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.plugin.core.AIData;
import com.tencent.aekit.plugin.core.AIDataStorage;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;

class AEDetector$DetectRunnable
  implements Runnable
{
  private AIData aiData;
  private AIInput aiInput;
  private AIParam aiParam;
  private IDetect detector;
  private boolean isValid = false;
  
  public AEDetector$DetectRunnable(AEDetector paramAEDetector, IDetect paramIDetect, AIData paramAIData, AIInput paramAIInput, AIParam paramAIParam)
  {
    if ((paramIDetect == null) || (paramAIData == null) || (paramAIInput == null) || (paramAIParam == null))
    {
      this.isValid = false;
      return;
    }
    this.detector = paramIDetect;
    this.aiData = paramAIData;
    this.aiInput = paramAIInput;
    this.aiParam = paramAIParam;
    this.isValid = true;
  }
  
  public void run()
  {
    if (!this.isValid) {}
    Object localObject2;
    do
    {
      return;
      AEProfiler.getInstance().start(this.detector.getModuleType());
      localObject2 = this.detector.detect(this.aiInput, this.aiParam);
      long l = AEProfiler.getInstance().end(this.detector.getModuleType());
      AEProfiler.getInstance().add(1, this.detector.getModuleType(), l);
    } while (this.aiData == null);
    synchronized (this.aiData.getLock())
    {
      this.aiData.setAttr(localObject2);
      this.aiData.getLock().notifyAll();
      AEDetector.access$1000(this.this$0).update(this.detector.getModuleType(), localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AEDetector.DetectRunnable
 * JD-Core Version:    0.7.0.1
 */