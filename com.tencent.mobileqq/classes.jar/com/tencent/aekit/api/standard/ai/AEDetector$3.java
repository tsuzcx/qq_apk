package com.tencent.aekit.api.standard.ai;

import com.tencent.aekit.plugin.core.AIData;
import com.tencent.aekit.plugin.core.AIDataSet;
import com.tencent.aekit.plugin.core.AIDataStorage;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.plugin.AICtrl;

class AEDetector$3
  implements Runnable
{
  AEDetector$3(AEDetector paramAEDetector, AICtrl paramAICtrl, AIInput paramAIInput, AIParam paramAIParam, AIDataSet paramAIDataSet) {}
  
  public void run()
  {
    Object localObject1;
    AIData localAIData;
    if (AEDetector.access$000(this.this$0) != null)
    {
      ??? = AEDetector.access$000(this.this$0).getModuleType();
      AEDetector.access$1300(this.this$0, (String)???);
      if (!AEDetector.access$1400(this.this$0, (String)???, Integer.valueOf(this.val$aiCtrl.getModuleFreq((String)???))))
      {
        localObject1 = AEDetector.access$000(this.this$0).detect(this.val$aiInput, this.val$aiParam);
        localAIData = this.val$aiDataSet.getAIData((String)???);
        if (localAIData == null) {}
      }
    }
    synchronized (localAIData.getLock())
    {
      localAIData.setAttr(localObject1);
      localAIData.getLock().notifyAll();
      AEDetector.access$1000(this.this$0).update(AEDetector.access$000(this.this$0).getModuleType(), localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AEDetector.3
 * JD-Core Version:    0.7.0.1
 */