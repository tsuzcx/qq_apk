import com.tencent.TMG.utils.QLog;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class bgps
  implements Downloader.DownloadListener
{
  bgps(bgpr parambgpr, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LottieLoader", 0, "diy data download fail url = " + paramString);
    }
    bgpr.a(this.jdField_a_of_type_Bgpr, 2);
    bgpr.a(this.jdField_a_of_type_Bgpr, false, paramString, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LottieLoader", 0, "diy data download success url = " + paramString);
    }
    bgpr.b(this.jdField_a_of_type_Bgpr, true, paramString, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgps
 * JD-Core Version:    0.7.0.1
 */