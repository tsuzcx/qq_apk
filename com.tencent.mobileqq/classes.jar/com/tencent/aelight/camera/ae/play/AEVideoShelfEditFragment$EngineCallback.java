package com.tencent.aelight.camera.ae.play;

import com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback;
import java.lang.ref.WeakReference;

class AEVideoShelfEditFragment$EngineCallback
  implements VideoShelfEngine.Callback
{
  private WeakReference<AEVideoShelfEditFragment> mRef;
  
  public AEVideoShelfEditFragment$EngineCallback(AEVideoShelfEditFragment paramAEVideoShelfEditFragment)
  {
    this.mRef = new WeakReference(paramAEVideoShelfEditFragment);
  }
  
  public void onCancelCompleted()
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AEVideoShelfEditFragment)this.mRef.get()).onCancelCompleted();
    }
  }
  
  public void onCompleted()
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AEVideoShelfEditFragment)this.mRef.get()).onCompleted();
    }
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AEVideoShelfEditFragment)this.mRef.get()).onError(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onProgress(int paramInt)
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AEVideoShelfEditFragment)this.mRef.get()).onProgress(paramInt);
    }
  }
  
  public void onStartGenerate()
  {
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((AEVideoShelfEditFragment)this.mRef.get()).onStartGenerate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.EngineCallback
 * JD-Core Version:    0.7.0.1
 */