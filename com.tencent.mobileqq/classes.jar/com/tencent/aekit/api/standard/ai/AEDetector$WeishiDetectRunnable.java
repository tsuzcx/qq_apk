package com.tencent.aekit.api.standard.ai;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;

public class AEDetector$WeishiDetectRunnable
  implements Runnable
{
  private AIInput aiInput;
  private AIParam aiParam;
  private IDetect detect;
  private Object detectResult;
  
  public AEDetector$WeishiDetectRunnable(AEDetector paramAEDetector, IDetect paramIDetect, AIInput paramAIInput, AIParam paramAIParam)
  {
    this.detect = paramIDetect;
    this.aiInput = paramAIInput;
    this.aiParam = paramAIParam;
  }
  
  public Object getDetectResult()
  {
    return this.detectResult;
  }
  
  public void run()
  {
    if (this.detect != null) {
      this.detectResult = this.detect.detect(this.aiInput, this.aiParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AEDetector.WeishiDetectRunnable
 * JD-Core Version:    0.7.0.1
 */