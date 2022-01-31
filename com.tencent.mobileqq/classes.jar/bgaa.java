import android.os.Message;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.qphone.base.util.QLog;

class bgaa
  implements Downloader.DownloadListener
{
  bfzy jdField_a_of_type_Bfzy;
  
  public bgaa(bfzx parambfzx, bfzy parambfzy)
  {
    this.jdField_a_of_type_Bfzy = parambfzy;
  }
  
  public void onDownloadCanceled(String paramString)
  {
    paramString = Message.obtain(this.jdField_a_of_type_Bfzx.a, 2);
    paramString.obj = this.jdField_a_of_type_Bfzy;
    paramString.sendToTarget();
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Message.obtain(this.jdField_a_of_type_Bfzx.a, 3);
    paramString.obj = this.jdField_a_of_type_Bfzy;
    paramString.arg1 = -9999;
    if ((paramDownloadResult != null) && (paramDownloadResult.getReport() != null)) {}
    for (;;)
    {
      try
      {
        paramDownloadResult = new ImageDownloadReporter().obtainReportObj(paramDownloadResult, paramDownloadResult.getReport());
        if (paramDownloadResult != null)
        {
          paramString.arg1 = paramDownloadResult.retCode;
          QLog.w("QZoneLiveSoDownloader", 1, "So download failed, code=" + paramDownloadResult.retCode);
          this.jdField_a_of_type_Bfzy.jdField_a_of_type_Int = paramDownloadResult.retCode;
        }
      }
      catch (Exception paramDownloadResult)
      {
        QLog.w("QZoneLiveSoDownloader", 1, "", paramDownloadResult);
        continue;
      }
      paramString.sendToTarget();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "So download failed downloadResult:null");
      }
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    int i = (int)(100.0F * paramFloat);
    if (this.jdField_a_of_type_Bfzy != null) {
      this.jdField_a_of_type_Bfzy.jdField_a_of_type_Float = i;
    }
    paramString = Message.obtain(this.jdField_a_of_type_Bfzx.a, 5);
    paramString.obj = this.jdField_a_of_type_Bfzy;
    paramString.sendToTarget();
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveSoDownloader", 2, "onDownloadSucceed path:" + paramDownloadResult.getPath());
    }
    paramString = Message.obtain(this.jdField_a_of_type_Bfzx.a, 4);
    paramString.obj = this.jdField_a_of_type_Bfzy;
    paramString.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgaa
 * JD-Core Version:    0.7.0.1
 */