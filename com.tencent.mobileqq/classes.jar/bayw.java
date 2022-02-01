import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.io.File;

public class bayw
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return QzoneZipCacheHelper.getBasePath("qzone_aio_gift", String.valueOf(paramString.hashCode()));
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    return BaseApplicationImpl.getApplication().getCacheDir() + File.separator + paramString2 + File.separator + Utils.Crc64String(paramString1) + paramString1.substring(paramString1.lastIndexOf("."));
  }
  
  public static void a(bayz parambayz, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.e("QzoneGiftUtil", 1, "downloadGiftZip fail with url = null  boxZipUrl = " + paramString1 + " giftZipUrl = " + paramString2 + " giftUrl = " + paramString3);
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {}
    for (int i = 2;; i = 3)
    {
      ThreadManagerV2.executeOnFileThread(new QzoneGiftUtil.1(parambayz, i, paramString1, paramString2, paramString3));
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack)
  {
    QLog.i("QzoneGiftUtil", 1, "downloadGiftPhoto");
    Downloader localDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
    if (localDownloader != null) {
      localDownloader.download(paramString1, a(paramString1, paramString2), false, new bayy(paramQzoneZipCacheHelperCallBack));
    }
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    return auog.a(a(paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayw
 * JD-Core Version:    0.7.0.1
 */