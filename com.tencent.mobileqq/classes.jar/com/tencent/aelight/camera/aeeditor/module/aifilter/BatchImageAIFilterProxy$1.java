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
    localBatchImageAIFilterProxy.b = AIFilterProxyBase.a(this.jdField_a_of_type_JavaUtilList, BatchImageAIFilterProxy.a(localBatchImageAIFilterProxy));
    localBatchImageAIFilterProxy = this.this$0;
    localBatchImageAIFilterProxy.a(this.jdField_a_of_type_AndroidContentContext, localBatchImageAIFilterProxy.b, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterProxyBase$AIFilterProxyCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.BatchImageAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */