package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.api.IAEEditorUICallbackListener;
import mqq.util.WeakReference;

class AEEditorManagerForQzoneImpl$RealUICallback
  implements IAEEditorUICallbackListener
{
  WeakReference<IAEEditorUICallbackListener> a;
  
  public AEEditorManagerForQzoneImpl$RealUICallback(IAEEditorUICallbackListener paramIAEEditorUICallbackListener)
  {
    this.a = new WeakReference(paramIAEEditorUICallbackListener);
  }
  
  public void deleteMedia(int paramInt)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((IAEEditorUICallbackListener)this.a.get()).deleteMedia(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AEEditorManagerForQzoneImpl.RealUICallback
 * JD-Core Version:    0.7.0.1
 */