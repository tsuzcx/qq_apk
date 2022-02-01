package com.tencent.biz.qqcircle.flutter.animation.download;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class QCircleFlutterFileDownloadFactory
{
  private static volatile QCircleFlutterFileDownloadFactory a;
  private Map<String, String> b = null;
  private Map<String, QCircleFlutterFileDownloadFactory.OnDownloadFileListener> c = null;
  
  public static QCircleFlutterFileDownloadFactory a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleFlutterFileDownloadFactory();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(@NonNull QCircleFlutterFileDownloadOption paramQCircleFlutterFileDownloadOption, QCircleFlutterFileDownloadFactory.OnDownloadFileListener paramOnDownloadFileListener)
  {
    if (paramOnDownloadFileListener == null)
    {
      QLog.w("QCircleFlutterFileDownloadFactory", 2, "[downloadFile] download file listener not is null.");
      return;
    }
    String str = paramQCircleFlutterFileDownloadOption.b();
    if (TextUtils.isEmpty(str))
    {
      QLog.w("QCircleFlutterFileDownloadFactory", 2, "[downloadFile] download url not is empty.");
      return;
    }
    this.c.put(str, paramOnDownloadFileListener);
    if ((paramQCircleFlutterFileDownloadOption.a()) && (this.b.containsKey(str)))
    {
      a(paramQCircleFlutterFileDownloadOption, (String)this.b.get(str));
      return;
    }
    paramOnDownloadFileListener = new QCircleFlutterFileDownloadFactory.DownloadCallbackTask(this, paramQCircleFlutterFileDownloadOption);
    RFWDownloaderFactory.getDownloader(paramQCircleFlutterFileDownloadOption.d()).downloadOrUpdateFile(str, paramOnDownloadFileListener);
  }
  
  public void a(QCircleFlutterFileDownloadOption paramQCircleFlutterFileDownloadOption, String paramString)
  {
    if (paramQCircleFlutterFileDownloadOption == null)
    {
      QLog.d("QCircleFlutterFileDownloadFactory", 2, "[notifyDownloadFileFinish] option not is null.");
      return;
    }
    String str = paramQCircleFlutterFileDownloadOption.b();
    if (TextUtils.isEmpty(str))
    {
      QLog.d("QCircleFlutterFileDownloadFactory", 2, "[notifyDownloadFileFinish] current url is empty.");
      return;
    }
    QCircleFlutterFileDownloadFactory.OnDownloadFileListener localOnDownloadFileListener = (QCircleFlutterFileDownloadFactory.OnDownloadFileListener)this.c.get(str);
    if (localOnDownloadFileListener != null) {
      localOnDownloadFileListener.a(paramQCircleFlutterFileDownloadOption, paramString);
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString))) {
      this.b.put(str, paramString);
    }
  }
  
  public void b(QCircleFlutterFileDownloadOption paramQCircleFlutterFileDownloadOption, String paramString)
  {
    if (paramQCircleFlutterFileDownloadOption == null)
    {
      QLog.d("QCircleFlutterFileDownloadFactory", 2, "[notifyDownloadFileFail] option not is null.");
      return;
    }
    Object localObject = paramQCircleFlutterFileDownloadOption.b();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.d("QCircleFlutterFileDownloadFactory", 2, "[notifyDownloadFileFail] current url is empty.");
      return;
    }
    localObject = (QCircleFlutterFileDownloadFactory.OnDownloadFileListener)this.c.get(localObject);
    if (localObject != null) {
      ((QCircleFlutterFileDownloadFactory.OnDownloadFileListener)localObject).b(paramQCircleFlutterFileDownloadOption, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.download.QCircleFlutterFileDownloadFactory
 * JD-Core Version:    0.7.0.1
 */