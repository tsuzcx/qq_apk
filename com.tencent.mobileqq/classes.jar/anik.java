import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.AlbumLibDownloaderUtil;
import java.io.File;

public class anik
  implements Downloader.DownloadListener
{
  public anik(AlbumLibDownloaderUtil paramAlbumLibDownloaderUtil, String paramString1, Downloader.DownloadListener paramDownloadListener, String paramString2) {}
  
  public void onDownloadCanceled(String paramString)
  {
    File localFile = new File(AlbumLibDownloaderUtil.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadCanceled(paramString);
    }
    if (AlbumLibDownloaderUtil.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_CooperationQzoneUtilAlbumLibDownloaderUtil.jdField_a_of_type_ArrayOfBoolean[AlbumLibDownloaderUtil.a(this.jdField_a_of_type_CooperationQzoneUtilAlbumLibDownloaderUtil)] = false;
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    File localFile = new File(AlbumLibDownloaderUtil.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadFailed(paramString, paramDownloadResult);
    }
    if (AlbumLibDownloaderUtil.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_CooperationQzoneUtilAlbumLibDownloaderUtil.jdField_a_of_type_ArrayOfBoolean[AlbumLibDownloaderUtil.a(this.jdField_a_of_type_CooperationQzoneUtilAlbumLibDownloaderUtil)] = false;
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    File localFile = new File(AlbumLibDownloaderUtil.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(AlbumLibDownloaderUtil.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.renameTo(new File(AlbumLibDownloaderUtil.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/" + this.jdField_a_of_type_JavaLangString));
    }
    LocalMultiProcConfig.putBool(this.b, true);
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadSucceed(paramString, paramDownloadResult);
    }
    if (AlbumLibDownloaderUtil.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_CooperationQzoneUtilAlbumLibDownloaderUtil.jdField_a_of_type_ArrayOfBoolean[AlbumLibDownloaderUtil.a(this.jdField_a_of_type_CooperationQzoneUtilAlbumLibDownloaderUtil)] = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anik
 * JD-Core Version:    0.7.0.1
 */