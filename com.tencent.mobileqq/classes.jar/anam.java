import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.QzonePreDownloadManager;
import java.util.Vector;

public class anam
  implements Downloader.DownloadListener
{
  public anam(QzonePreDownloadManager paramQzonePreDownloadManager, anan paramanan) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, false);
    if (QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).size() > 0)
    {
      anan localanan = (anan)QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).get(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).remove(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, localanan);
    }
    if (this.jdField_a_of_type_Anan.a != null) {
      this.jdField_a_of_type_Anan.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, false);
    if (QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).size() > 0)
    {
      anan localanan = (anan)QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).get(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).remove(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, localanan);
    }
    if (this.jdField_a_of_type_Anan.a != null) {
      this.jdField_a_of_type_Anan.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Anan.a != null) {
      this.jdField_a_of_type_Anan.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, false);
    if (QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).size() > 0)
    {
      anan localanan = (anan)QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).get(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).remove(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, localanan);
    }
    if (this.jdField_a_of_type_Anan.a != null) {
      this.jdField_a_of_type_Anan.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anam
 * JD-Core Version:    0.7.0.1
 */