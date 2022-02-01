package com.tencent.biz.qcircleshadow.lib.listener;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.qq.im.ae.camera.core.AEEditorManagerForQzone.AEEditorGenerateResultListener;
import java.lang.ref.WeakReference;

public class QCircleAEEditorGenerateResultListenerProxy
  implements AEEditorManagerForQzone.AEEditorGenerateResultListener
{
  private WeakReference<QCircleAEEditorGenerateResultListener> mWRFListener;
  
  public QCircleAEEditorGenerateResultListenerProxy(QCircleAEEditorGenerateResultListener paramQCircleAEEditorGenerateResultListener)
  {
    this.mWRFListener = new WeakReference(paramQCircleAEEditorGenerateResultListener);
  }
  
  public void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    QCircleAEEditorGenerateResultListener localQCircleAEEditorGenerateResultListener = (QCircleAEEditorGenerateResultListener)this.mWRFListener.get();
    if (localQCircleAEEditorGenerateResultListener != null) {
      localQCircleAEEditorGenerateResultListener.onAETavSessionExportCompleted(paramString, paramLocalMediaInfo);
    }
  }
  
  public void onAETavSessionExportError(String paramString, int paramInt)
  {
    QCircleAEEditorGenerateResultListener localQCircleAEEditorGenerateResultListener = (QCircleAEEditorGenerateResultListener)this.mWRFListener.get();
    if (localQCircleAEEditorGenerateResultListener != null) {
      localQCircleAEEditorGenerateResultListener.onAETavSessionExportError(paramString, paramInt);
    }
  }
  
  public void onAETavSessionExporting(String paramString, float paramFloat)
  {
    QCircleAEEditorGenerateResultListener localQCircleAEEditorGenerateResultListener = (QCircleAEEditorGenerateResultListener)this.mWRFListener.get();
    if (localQCircleAEEditorGenerateResultListener != null) {
      localQCircleAEEditorGenerateResultListener.onAETavSessionExporting(paramString, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListenerProxy
 * JD-Core Version:    0.7.0.1
 */