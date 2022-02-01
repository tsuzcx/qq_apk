package com.tencent.aelight.camera.aeeditor.module.aifilter;

class SilentVideoAIFilterProxy$1
  implements AEEditorAIFilterManager.AIFilterObserver
{
  SilentVideoAIFilterProxy$1(SilentVideoAIFilterProxy paramSilentVideoAIFilterProxy) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if ((paramAIFilterResult instanceof VideoAIFilterResult))
    {
      SilentVideoAIFilterProxy localSilentVideoAIFilterProxy = this.a;
      localSilentVideoAIFilterProxy.d = ((VideoAIFilterResult)paramAIFilterResult);
      SilentVideoAIFilterProxy.a(localSilentVideoAIFilterProxy).a(this.a.d);
    }
  }
  
  public void ar_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.SilentVideoAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */