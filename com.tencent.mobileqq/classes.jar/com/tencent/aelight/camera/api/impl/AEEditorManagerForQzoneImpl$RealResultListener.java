package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.api.IAEEditorGenerateResultListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import mqq.util.WeakReference;

class AEEditorManagerForQzoneImpl$RealResultListener
  implements IAEEditorGenerateResultListener
{
  WeakReference<IAEEditorGenerateResultListener> a;
  
  public AEEditorManagerForQzoneImpl$RealResultListener(IAEEditorGenerateResultListener paramIAEEditorGenerateResultListener)
  {
    this.a = new WeakReference(paramIAEEditorGenerateResultListener);
  }
  
  public void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((IAEEditorGenerateResultListener)this.a.get()).onAETavSessionExportCompleted(paramString, paramLocalMediaInfo);
    }
  }
  
  public void onAETavSessionExportError(String paramString1, int paramInt, String paramString2)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((IAEEditorGenerateResultListener)this.a.get()).onAETavSessionExportError(paramString1, paramInt, paramString2);
    }
  }
  
  public void onAETavSessionExporting(String paramString, float paramFloat)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((IAEEditorGenerateResultListener)this.a.get()).onAETavSessionExporting(paramString, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AEEditorManagerForQzoneImpl.RealResultListener
 * JD-Core Version:    0.7.0.1
 */