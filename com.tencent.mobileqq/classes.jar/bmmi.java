import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.open.base.MD5Utils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.HashMap;

class bmmi
  implements Downloader.DownloadListener
{
  bmmi(bmmh parambmmh, bmlm parambmlm, String paramString1, String paramString2, argx paramargx) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadCanceled = " + paramString);
    if (this.jdField_a_of_type_Bmlm != null) {
      this.jdField_a_of_type_Bmlm.b("download canceld url = " + paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadFailed = " + paramString);
    if (this.jdField_a_of_type_Bmlm != null) {
      this.jdField_a_of_type_Bmlm.b("download fail url = " + paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QZLog.i("VipARQGLoaderManager", 2, "onDownloadSucceed = " + paramString);
    paramString = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(this.jdField_a_of_type_JavaLangString.hashCode()));
    paramDownloadResult = MD5Utils.encodeFileHexStr(this.b);
    if (this.jdField_a_of_type_Argx != null) {
      QZLog.i("VipARQGLoaderManager", 1, "download fileMD5 = " + paramDownloadResult + " config.md5 = " + this.jdField_a_of_type_Argx.c);
    }
    if ((this.jdField_a_of_type_Argx != null) && (!TextUtils.isEmpty(paramDownloadResult)) && (paramDownloadResult.equalsIgnoreCase(this.jdField_a_of_type_Argx.c)))
    {
      paramDownloadResult = new File(this.b);
      QzoneZipCacheHelper.unzipFile(paramDownloadResult.getAbsolutePath(), paramString);
      if (paramDownloadResult.exists()) {
        FileUtil.deleteFile(paramDownloadResult);
      }
      if (new File(paramString).exists())
      {
        QZLog.i("VipARQGLoaderManager", 1, "download success file exist start put to map = " + paramString);
        bmmh.a(this.jdField_a_of_type_Bmmh).put(this.jdField_a_of_type_JavaLangString, paramString);
        if (this.jdField_a_of_type_Bmlm != null) {
          this.jdField_a_of_type_Bmlm.a(paramString);
        }
      }
    }
    while (this.jdField_a_of_type_Bmlm == null)
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Bmlm == null);
      this.jdField_a_of_type_Bmlm.b("download success but the file is not exist");
      return;
    }
    this.jdField_a_of_type_Bmlm.b("download success but the file md5 is not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmi
 * JD-Core Version:    0.7.0.1
 */