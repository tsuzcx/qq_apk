package com.tencent.biz.qqcircle.flutter.animation.download;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import java.lang.ref.WeakReference;

public class QCircleFlutterFileDownloadFactory$DownloadCallbackTask
  implements RFWDownloader.RFWDownloadListener
{
  private WeakReference<QCircleFlutterFileDownloadFactory> a = null;
  private QCircleFlutterFileDownloadOption b = null;
  
  public QCircleFlutterFileDownloadFactory$DownloadCallbackTask(QCircleFlutterFileDownloadFactory paramQCircleFlutterFileDownloadFactory, QCircleFlutterFileDownloadOption paramQCircleFlutterFileDownloadOption)
  {
    this.a = new WeakReference(paramQCircleFlutterFileDownloadFactory);
    this.b = paramQCircleFlutterFileDownloadOption;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QCircleFlutterFileDownloadFactory)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      ((QCircleFlutterFileDownloadFactory)localObject).a(this.b, paramString);
      return;
    }
    ((QCircleFlutterFileDownloadFactory)localObject).b(this.b, "download file fail.");
  }
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    RFThreadManager.getUIHandler().post(new QCircleFlutterFileDownloadFactory.DownloadCallbackTask.1(this, paramBoolean, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.download.QCircleFlutterFileDownloadFactory.DownloadCallbackTask
 * JD-Core Version:    0.7.0.1
 */