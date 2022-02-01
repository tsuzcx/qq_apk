package com.tencent.biz.qcircleshadow.listenerproxy;

import com.ae.light.camera.api.IAEEditorGenerateResultListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.lang.ref.WeakReference;

public class QCircleAEEditorGenerateResultListenerProxy
  implements IAEEditorGenerateResultListener
{
  private WeakReference<QCircleAEEditorGenerateResultListener> a;
  
  public QCircleAEEditorGenerateResultListenerProxy(QCircleAEEditorGenerateResultListener paramQCircleAEEditorGenerateResultListener)
  {
    this.a = new WeakReference(paramQCircleAEEditorGenerateResultListener);
  }
  
  public void a(String paramString, float paramFloat)
  {
    QCircleAEEditorGenerateResultListener localQCircleAEEditorGenerateResultListener = (QCircleAEEditorGenerateResultListener)this.a.get();
    if (localQCircleAEEditorGenerateResultListener != null) {
      localQCircleAEEditorGenerateResultListener.onAETavSessionExporting(paramString, paramFloat);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QCircleAEEditorGenerateResultListener localQCircleAEEditorGenerateResultListener = (QCircleAEEditorGenerateResultListener)this.a.get();
    if (localQCircleAEEditorGenerateResultListener != null) {
      localQCircleAEEditorGenerateResultListener.onAETavSessionExportError(paramString, paramInt);
    }
  }
  
  public void a(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    QCircleAEEditorGenerateResultListener localQCircleAEEditorGenerateResultListener = (QCircleAEEditorGenerateResultListener)this.a.get();
    if (localQCircleAEEditorGenerateResultListener != null) {
      localQCircleAEEditorGenerateResultListener.onAETavSessionExportCompleted(paramString, paramLocalMediaInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.listenerproxy.QCircleAEEditorGenerateResultListenerProxy
 * JD-Core Version:    0.7.0.1
 */