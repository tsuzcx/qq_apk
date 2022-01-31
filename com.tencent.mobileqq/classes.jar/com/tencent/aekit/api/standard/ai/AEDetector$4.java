package com.tencent.aekit.api.standard.ai;

import android.opengl.GLES20;
import android.os.Handler;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIDataSet;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIInput.DataSize;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.openapi.plugin.AICtrl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class AEDetector$4
  implements Runnable
{
  AEDetector$4(AEDetector paramAEDetector, AICtrl paramAICtrl, AIInput paramAIInput, AIParam paramAIParam, AIDataSet paramAIDataSet) {}
  
  public void run()
  {
    GLES20.glFinish();
    Iterator localIterator = AEDetector.access$100(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      IDetect localIDetect = (IDetect)localIterator.next();
      String str = localIDetect.getModuleType();
      if (!str.equals(AEDetectorType.FACE.value)) {
        if (!this.val$aiCtrl.isModuleOn(str))
        {
          AEDetector.access$1500(this.this$0, str);
        }
        else
        {
          localIDetect.reloadModel();
          Frame localFrame = (Frame)this.val$aiInput.getInput("frame");
          Object localObject1 = this.val$aiParam.getScale(localIDetect.getModuleType());
          Object localObject2;
          long l;
          if (localObject1 != null)
          {
            localObject2 = localIDetect.getModuleType() + "-setBytes-" + (int)(localFrame.width * ((Float)localObject1).floatValue()) + "x" + (int)(localFrame.height * ((Float)localObject1).floatValue());
            AEProfiler.getInstance().start((String)localObject2);
            this.val$aiInput.setBytes(((Float)localObject1).floatValue(), AEDetector.access$1600(this.this$0, localFrame, (Float)localObject1));
            l = AEProfiler.getInstance().end((String)localObject2);
            AEProfiler.getInstance().add(1, (String)localObject2, l);
          }
          if ((this.val$aiParam.getBytesDataSizeWidth(localIDetect.getModuleType()) != null) && (this.val$aiParam.getBytesDataSizeHeight(localIDetect.getModuleType()) != null))
          {
            int i = this.val$aiParam.getBytesDataSizeWidth(localIDetect.getModuleType()).intValue();
            int j = this.val$aiParam.getBytesDataSizeHeight(localIDetect.getModuleType()).intValue();
            if ((i > 0) && (j > 0))
            {
              localObject1 = localIDetect.getModuleType() + "-setSizeBytes-" + i + "x" + j;
              AEProfiler.getInstance().start((String)localObject1);
              localObject2 = new AIInput.DataSize(i, j);
              this.val$aiInput.setSizedBytes((AIInput.DataSize)localObject2, AEDetector.access$1700(this.this$0, localFrame, (AIInput.DataSize)localObject2));
              l = AEProfiler.getInstance().end((String)localObject1);
              AEProfiler.getInstance().add(1, (String)localObject1, l);
            }
          }
          AEDetector.access$1300(this.this$0, str);
          if (!AEDetector.access$1400(this.this$0, str, Integer.valueOf(this.val$aiCtrl.getModuleFreq(str)))) {
            ((Handler)AEDetector.access$200(this.this$0).get(localIDetect.getModuleType())).post(new AEDetector.DetectRunnable(this.this$0, localIDetect, this.val$aiDataSet.getAIData(str), this.val$aiInput, this.val$aiParam));
          }
        }
      }
    }
    AEDetector.access$700(this.this$0).clear();
    AEDetector.access$800(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AEDetector.4
 * JD-Core Version:    0.7.0.1
 */