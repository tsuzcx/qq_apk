package com.tencent.biz.qcircleshadow.listenerproxy;

import com.ae.light.camera.api.IAEEditorUICallbackListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListener;
import java.lang.ref.WeakReference;

public class QCircleAEEditorUICallbackListenerProxy
  implements IAEEditorUICallbackListener
{
  private WeakReference<QCircleAEEditorUICallbackListener> a;
  
  public QCircleAEEditorUICallbackListenerProxy(QCircleAEEditorUICallbackListener paramQCircleAEEditorUICallbackListener)
  {
    this.a = new WeakReference(paramQCircleAEEditorUICallbackListener);
  }
  
  public void a(int paramInt)
  {
    QCircleAEEditorUICallbackListener localQCircleAEEditorUICallbackListener = (QCircleAEEditorUICallbackListener)this.a.get();
    if (localQCircleAEEditorUICallbackListener != null) {
      localQCircleAEEditorUICallbackListener.deleteMedia(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.listenerproxy.QCircleAEEditorUICallbackListenerProxy
 * JD-Core Version:    0.7.0.1
 */