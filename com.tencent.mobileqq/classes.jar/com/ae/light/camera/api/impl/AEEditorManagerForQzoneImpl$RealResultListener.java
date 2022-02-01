package com.ae.light.camera.api.impl;

import com.ae.light.camera.api.IAEEditorGenerateResultListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.qq.im.ae.camera.core.AEEditorManagerForQzone.AEEditorGenerateResultListener;
import mqq.util.WeakReference;

class AEEditorManagerForQzoneImpl$RealResultListener
  implements AEEditorManagerForQzone.AEEditorGenerateResultListener
{
  WeakReference<IAEEditorGenerateResultListener> a;
  
  public AEEditorManagerForQzoneImpl$RealResultListener(IAEEditorGenerateResultListener paramIAEEditorGenerateResultListener)
  {
    this.a = new WeakReference(paramIAEEditorGenerateResultListener);
  }
  
  public void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((IAEEditorGenerateResultListener)this.a.get()).a(paramString, paramLocalMediaInfo);
    }
  }
  
  public void onAETavSessionExportError(String paramString, int paramInt)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((IAEEditorGenerateResultListener)this.a.get()).a(paramString, paramInt);
    }
  }
  
  public void onAETavSessionExporting(String paramString, float paramFloat)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((IAEEditorGenerateResultListener)this.a.get()).a(paramString, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.ae.light.camera.api.impl.AEEditorManagerForQzoneImpl.RealResultListener
 * JD-Core Version:    0.7.0.1
 */