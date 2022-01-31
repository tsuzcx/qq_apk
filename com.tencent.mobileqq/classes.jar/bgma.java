import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelperCallBack;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

public class bgma
{
  public static void a(String paramString, QzoneOfflineCacheHelperCallBack paramQzoneOfflineCacheHelperCallBack)
  {
    QzoneOfflineCacheHelper.downLoadFileIfNeeded(null, paramString, paramQzoneOfflineCacheHelperCallBack, false, null);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QzoneOfflineCacheHelper.updateLruFileInNewThread(paramString2);
  }
  
  public static void a(String paramString1, String paramString2, QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack)
  {
    if (paramString1 != null) {
      try
      {
        if (paramString1.length() == 0) {
          return;
        }
        if (paramQzoneZipCacheHelperCallBack != null)
        {
          QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, paramString1, "QZonePet", paramString2, -1, paramQzoneZipCacheHelperCallBack);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("WidgetAIOfflineUtil", 1, QZLog.getStackTraceString(paramString1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgma
 * JD-Core Version:    0.7.0.1
 */