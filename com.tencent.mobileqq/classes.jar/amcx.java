import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.QzonePreDownloadManager;
import java.util.Vector;

public class amcx
  implements Downloader.DownloadListener
{
  public amcx(QzonePreDownloadManager paramQzonePreDownloadManager, amcy paramamcy) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, false);
    if (QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).size() > 0)
    {
      amcy localamcy = (amcy)QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).get(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).remove(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, localamcy);
    }
    if (this.jdField_a_of_type_Amcy.a != null) {
      this.jdField_a_of_type_Amcy.a.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, false);
    if (QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).size() > 0)
    {
      amcy localamcy = (amcy)QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).get(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).remove(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, localamcy);
    }
    if (this.jdField_a_of_type_Amcy.a != null) {
      this.jdField_a_of_type_Amcy.a.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_Amcy.a != null) {
      this.jdField_a_of_type_Amcy.a.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, false);
    if (QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).size() > 0)
    {
      amcy localamcy = (amcy)QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).get(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager).remove(0);
      QzonePreDownloadManager.a(this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager, localamcy);
    }
    if (this.jdField_a_of_type_Amcy.a != null) {
      this.jdField_a_of_type_Amcy.a.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcx
 * JD-Core Version:    0.7.0.1
 */