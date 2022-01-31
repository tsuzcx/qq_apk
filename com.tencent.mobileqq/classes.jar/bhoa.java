import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;

class bhoa
  implements Downloader.DownloadListener
{
  bhoa(bhnz parambhnz, String paramString1, Downloader.DownloadListener paramDownloadListener, String paramString2) {}
  
  public void onDownloadCanceled(String paramString)
  {
    File localFile = new File(bhnz.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadCanceled(paramString);
    }
    if (bhnz.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bhnz.jdField_a_of_type_ArrayOfBoolean[bhnz.a(this.jdField_a_of_type_Bhnz)] = false;
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    File localFile = new File(bhnz.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadFailed(paramString, paramDownloadResult);
    }
    if (bhnz.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bhnz.jdField_a_of_type_ArrayOfBoolean[bhnz.a(this.jdField_a_of_type_Bhnz)] = false;
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    File localFile = new File(bhnz.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(bhnz.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.renameTo(new File(bhnz.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/" + this.jdField_a_of_type_JavaLangString));
    }
    LocalMultiProcConfig.putBool(this.b, true);
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadSucceed(paramString, paramDownloadResult);
    }
    if (bhnz.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bhnz.jdField_a_of_type_ArrayOfBoolean[bhnz.a(this.jdField_a_of_type_Bhnz)] = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhoa
 * JD-Core Version:    0.7.0.1
 */