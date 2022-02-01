package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import java.util.List;

class BatchImageAIFilterProxy$1
  implements Runnable
{
  BatchImageAIFilterProxy$1(BatchImageAIFilterProxy paramBatchImageAIFilterProxy, List paramList, Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback) {}
  
  public void run()
  {
    BatchImageAIFilterProxy localBatchImageAIFilterProxy = this.this$0;
    localBatchImageAIFilterProxy.c = AIFilterProxyBase.a(this.a, BatchImageAIFilterProxy.a(localBatchImageAIFilterProxy));
    localBatchImageAIFilterProxy = this.this$0;
    localBatchImageAIFilterProxy.a(this.b, localBatchImageAIFilterProxy.c, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.BatchImageAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */