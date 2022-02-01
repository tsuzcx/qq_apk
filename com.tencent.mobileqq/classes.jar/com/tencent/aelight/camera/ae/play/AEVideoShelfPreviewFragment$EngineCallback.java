package com.tencent.aelight.camera.ae.play;

import com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback;
import java.lang.ref.WeakReference;

class AEVideoShelfPreviewFragment$EngineCallback
  implements VideoShelfEngine.Callback
{
  private WeakReference<AEVideoShelfPreviewFragment> mRef;
  
  public AEVideoShelfPreviewFragment$EngineCallback(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment)
  {
    this.mRef = new WeakReference(paramAEVideoShelfPreviewFragment);
  }
  
  public void onCancelCompleted()
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      AEVideoShelfPreviewFragment.access$1600((AEVideoShelfPreviewFragment)this.mRef.get());
    }
  }
  
  public void onCompleted()
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AEVideoShelfPreviewFragment)this.mRef.get()).onCompletion();
    }
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      AEVideoShelfPreviewFragment.access$1500((AEVideoShelfPreviewFragment)this.mRef.get(), paramInt1, paramInt2, paramString);
    }
  }
  
  public void onProgress(int paramInt)
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      AEVideoShelfPreviewFragment.access$1400((AEVideoShelfPreviewFragment)this.mRef.get(), paramInt);
    }
  }
  
  public void onStartGenerate()
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      AEVideoShelfPreviewFragment.access$1300((AEVideoShelfPreviewFragment)this.mRef.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.EngineCallback
 * JD-Core Version:    0.7.0.1
 */