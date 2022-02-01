package com.ae.light.camera.api.impl;

import com.ae.light.camera.api.IAEEditorUICallbackListener;
import dov.com.qq.im.ae.camera.core.AEEditorManagerForQzone.AEEditorUICallbackListener;
import mqq.util.WeakReference;

class AEEditorManagerForQzoneImpl$RealUICallback
  implements AEEditorManagerForQzone.AEEditorUICallbackListener
{
  WeakReference<IAEEditorUICallbackListener> a;
  
  public AEEditorManagerForQzoneImpl$RealUICallback(IAEEditorUICallbackListener paramIAEEditorUICallbackListener)
  {
    this.a = new WeakReference(paramIAEEditorUICallbackListener);
  }
  
  public void deleteMedia(int paramInt)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((IAEEditorUICallbackListener)this.a.get()).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.ae.light.camera.api.impl.AEEditorManagerForQzoneImpl.RealUICallback
 * JD-Core Version:    0.7.0.1
 */