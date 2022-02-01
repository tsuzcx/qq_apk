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
    localSingleImageAIFilterProxy.b = AIFilterProxyBase.a(this.a, SingleImageAIFilterProxy.a(localSingleImageAIFilterProxy));
    localSingleImageAIFilterProxy = this.this$0;
    localSingleImageAIFilterProxy.a(this.b, localSingleImageAIFilterProxy.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.SingleImageAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */