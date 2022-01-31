import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.HashMap;

class bkay
  implements Downloader.DownloadListener
{
  bkay(bkax parambkax, bkac parambkac, String paramString1, String paramString2, aonx paramaonx) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadCanceled = " + paramString);
    if (this.jdField_a_of_type_Bkac != null) {
      this.jdField_a_of_type_Bkac.b("download canceld url = " + paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadFailed = " + paramString);
    if (this.jdField_a_of_type_Bkac != null) {
      this.jdField_a_of_type_Bkac.b("download fail url = " + paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadSucceed = " + paramString);
    paramString = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(this.jdField_a_of_type_JavaLangString.hashCode()));
    paramDownloadResult = bfhi.a(this.b);
    if (this.jdField_a_of_type_Aonx != null) {
      QZLog.i("VipARQGLoaderManager", 1, "download fileMD5 = " + paramDownloadResult + " config.md5 = " + this.jdField_a_of_type_Aonx.c);
    }
    if ((this.jdField_a_of_type_Aonx != null) && (!TextUtils.isEmpty(paramDownloadResult)) && (paramDownloadResult.equalsIgnoreCase(this.jdField_a_of_type_Aonx.c)))
    {
      paramDownloadResult = new File(this.b);
      QzoneZipCacheHelper.unzipFile(paramDownloadResult.getAbsolutePath(), paramString);
      if (paramDownloadResult.exists()) {
        arof.a(paramDownloadResult);
      }
      if (new File(paramString).exists())
      {
        QZLog.i("VipARQGLoaderManager", 1, "download success file exist start put to map = " + paramString);
        bkax.a(this.jdField_a_of_type_Bkax).put(this.jdField_a_of_type_JavaLangString, paramString);
        if (this.jdField_a_of_type_Bkac != null) {
          this.jdField_a_of_type_Bkac.a(paramString);
        }
      }
    }
    while (this.jdField_a_of_type_Bkac == null)
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Bkac == null);
      this.jdField_a_of_type_Bkac.b("download success but the file is not exist");
      return;
    }
    this.jdField_a_of_type_Bkac.b("download success but the file md5 is not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkay
 * JD-Core Version:    0.7.0.1
 */