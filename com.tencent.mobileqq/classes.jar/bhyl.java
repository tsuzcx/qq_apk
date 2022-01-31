import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.HashMap;

class bhyl
  implements Downloader.DownloadListener
{
  bhyl(bhyk parambhyk, bhxp parambhxp, String paramString1, String paramString2, amwr paramamwr) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadCanceled = " + paramString);
    if (this.jdField_a_of_type_Bhxp != null) {
      this.jdField_a_of_type_Bhxp.b("download canceld url = " + paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadFailed = " + paramString);
    if (this.jdField_a_of_type_Bhxp != null) {
      this.jdField_a_of_type_Bhxp.b("download fail url = " + paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadSucceed = " + paramString);
    paramString = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(this.jdField_a_of_type_JavaLangString.hashCode()));
    paramDownloadResult = bdhv.a(this.b);
    if (this.jdField_a_of_type_Amwr != null) {
      QZLog.i("VipARQGLoaderManager", 1, "download fileMD5 = " + paramDownloadResult + " config.md5 = " + this.jdField_a_of_type_Amwr.c);
    }
    if ((this.jdField_a_of_type_Amwr != null) && (!TextUtils.isEmpty(paramDownloadResult)) && (paramDownloadResult.equalsIgnoreCase(this.jdField_a_of_type_Amwr.c)))
    {
      paramDownloadResult = new File(this.b);
      QzoneZipCacheHelper.unzipFile(paramDownloadResult.getAbsolutePath(), paramString);
      if (paramDownloadResult.exists()) {
        apvb.a(paramDownloadResult);
      }
      if (new File(paramString).exists())
      {
        QZLog.i("VipARQGLoaderManager", 1, "download success file exist start put to map = " + paramString);
        bhyk.a(this.jdField_a_of_type_Bhyk).put(this.jdField_a_of_type_JavaLangString, paramString);
        if (this.jdField_a_of_type_Bhxp != null) {
          this.jdField_a_of_type_Bhxp.a(paramString);
        }
      }
    }
    while (this.jdField_a_of_type_Bhxp == null)
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Bhxp == null);
      this.jdField_a_of_type_Bhxp.b("download success but the file is not exist");
      return;
    }
    this.jdField_a_of_type_Bhxp.b("download success but the file md5 is not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhyl
 * JD-Core Version:    0.7.0.1
 */