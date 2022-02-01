package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import java.util.List;

class SingleImageAIFilterProxy$1
  implements Runnable
{
  SingleImageAIFilterProxy$1(SingleImageAIFilterProxy paramSingleImageAIFilterProxy, List paramList, Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback) {}
  
  public void run()
  {
    SingleImageAIFilterProxy localSingleImageAIFilterProxy = this.this$0;
    localSingleImageAIFilterProxy.jdField_a_of_type_JavaUtilList = AIFilterProxyBase.a(this.jdField_a_of_type_JavaUtilList, SingleImageAIFilterProxy.a(localSingleImageAIFilterProxy));
    localSingleImageAIFilterProxy = this.this$0;
    localSingleImageAIFilterProxy.a(this.jdField_a_of_type_AndroidContentContext, localSingleImageAIFilterProxy.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterProxyBase$AIFilterProxyCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.SingleImageAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */