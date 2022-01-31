import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;

class bjtt
  implements Downloader.DownloadListener
{
  bjtt(bjts parambjts, String paramString1, Downloader.DownloadListener paramDownloadListener, String paramString2) {}
  
  public void onDownloadCanceled(String paramString)
  {
    File localFile = new File(bjts.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadCanceled(paramString);
    }
    if (bjts.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bjts.jdField_a_of_type_ArrayOfBoolean[bjts.a(this.jdField_a_of_type_Bjts)] = false;
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    File localFile = new File(bjts.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadFailed(paramString, paramDownloadResult);
    }
    if (bjts.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bjts.jdField_a_of_type_ArrayOfBoolean[bjts.a(this.jdField_a_of_type_Bjts)] = false;
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    File localFile = new File(bjts.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(bjts.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.renameTo(new File(bjts.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/" + this.jdField_a_of_type_JavaLangString));
    }
    LocalMultiProcConfig.putBool(this.b, true);
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadSucceed(paramString, paramDownloadResult);
    }
    if (bjts.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bjts.jdField_a_of_type_ArrayOfBoolean[bjts.a(this.jdField_a_of_type_Bjts)] = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjtt
 * JD-Core Version:    0.7.0.1
 */