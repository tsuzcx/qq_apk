import com.tencent.TMG.utils.QLog;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class bnvb
  implements Downloader.DownloadListener
{
  bnvb(bnva parambnva, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LottieLoader", 0, "diy data download fail url = " + paramString);
    }
    bnva.a(this.jdField_a_of_type_Bnva, 2);
    bnva.a(this.jdField_a_of_type_Bnva, false, paramString, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LottieLoader", 0, "diy data download success url = " + paramString);
    }
    bnva.b(this.jdField_a_of_type_Bnva, true, paramString, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvb
 * JD-Core Version:    0.7.0.1
 */