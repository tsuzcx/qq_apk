package com.tencent.biz.qcircleshadow.lib.listener;

import dov.com.qq.im.ae.camera.core.AEEditorManagerForQzone.AEEditorUICallbackListener;
import java.lang.ref.WeakReference;

public class QCircleAEEditorUICallbackListenerProxy
  implements AEEditorManagerForQzone.AEEditorUICallbackListener
{
  private WeakReference<QCircleAEEditorUICallbackListener> mWRFListener;
  
  public QCircleAEEditorUICallbackListenerProxy(QCircleAEEditorUICallbackListener paramQCircleAEEditorUICallbackListener)
  {
    this.mWRFListener = new WeakReference(paramQCircleAEEditorUICallbackListener);
  }
  
  public void deleteMedia(int paramInt)
  {
    QCircleAEEditorUICallbackListener localQCircleAEEditorUICallbackListener = (QCircleAEEditorUICallbackListener)this.mWRFListener.get();
    if (localQCircleAEEditorUICallbackListener != null) {
      localQCircleAEEditorUICallbackListener.deleteMedia(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListenerProxy
 * JD-Core Version:    0.7.0.1
 */