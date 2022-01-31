import com.tencent.TMG.utils.QLog;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class bkbc
  implements Downloader.DownloadListener
{
  bkbc(bkbb parambkbb, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LottieLoader", 0, "diy data download fail url = " + paramString);
    }
    bkbb.a(this.jdField_a_of_type_Bkbb, 2);
    bkbb.a(this.jdField_a_of_type_Bkbb, false, paramString, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LottieLoader", 0, "diy data download success url = " + paramString);
    }
    bkbb.b(this.jdField_a_of_type_Bkbb, true, paramString, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkbc
 * JD-Core Version:    0.7.0.1
 */