package com.tencent.biz.qcircleshadow.listenerproxy;

import com.tencent.aelight.camera.api.IAEEditorGenerateResultListener;
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
  
  public void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    QCircleAEEditorGenerateResultListener localQCircleAEEditorGenerateResultListener = (QCircleAEEditorGenerateResultListener)this.a.get();
    if (localQCircleAEEditorGenerateResultListener != null) {
      localQCircleAEEditorGenerateResultListener.onAETavSessionExportCompleted(paramString, paramLocalMediaInfo);
    }
  }
  
  public void onAETavSessionExportError(String paramString1, int paramInt, String paramString2)
  {
    QCircleAEEditorGenerateResultListener localQCircleAEEditorGenerateResultListener = (QCircleAEEditorGenerateResultListener)this.a.get();
    if (localQCircleAEEditorGenerateResultListener != null) {
      localQCircleAEEditorGenerateResultListener.onAETavSessionExportError(paramString1, paramInt, paramString2);
    }
  }
  
  public void onAETavSessionExporting(String paramString, float paramFloat)
  {
    QCircleAEEditorGenerateResultListener localQCircleAEEditorGenerateResultListener = (QCircleAEEditorGenerateResultListener)this.a.get();
    if (localQCircleAEEditorGenerateResultListener != null) {
      localQCircleAEEditorGenerateResultListener.onAETavSessionExporting(paramString, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.listenerproxy.QCircleAEEditorGenerateResultListenerProxy
 * JD-Core Version:    0.7.0.1
 */