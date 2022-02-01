package com.tencent.aelight.camera.aeeditor.module.aifilter;

class SilentBatchImageAIFilterProxy$1
  implements AEEditorAIFilterManager.AIFilterObserver
{
  SilentBatchImageAIFilterProxy$1(SilentBatchImageAIFilterProxy paramSilentBatchImageAIFilterProxy) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if ((paramAIFilterResult instanceof BatchImageAIFilterResult))
    {
      SilentBatchImageAIFilterProxy.a(this.a, (BatchImageAIFilterResult)paramAIFilterResult);
      SilentBatchImageAIFilterProxy.b(this.a).a(SilentBatchImageAIFilterProxy.a(this.a));
    }
  }
  
  public void ar_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.SilentBatchImageAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */