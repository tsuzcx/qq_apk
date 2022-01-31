import android.os.Message;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.qphone.base.util.QLog;

class bjou
  implements Downloader.DownloadListener
{
  bjos jdField_a_of_type_Bjos;
  
  public bjou(bjor parambjor, bjos parambjos)
  {
    this.jdField_a_of_type_Bjos = parambjos;
  }
  
  public void onDownloadCanceled(String paramString)
  {
    paramString = Message.obtain(this.jdField_a_of_type_Bjor.a, 2);
    paramString.obj = this.jdField_a_of_type_Bjos;
    paramString.sendToTarget();
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Message.obtain(this.jdField_a_of_type_Bjor.a, 3);
    paramString.obj = this.jdField_a_of_type_Bjos;
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
          this.jdField_a_of_type_Bjos.jdField_a_of_type_Int = paramDownloadResult.retCode;
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
    if (this.jdField_a_of_type_Bjos != null) {
      this.jdField_a_of_type_Bjos.jdField_a_of_type_Float = i;
    }
    paramString = Message.obtain(this.jdField_a_of_type_Bjor.a, 5);
    paramString.obj = this.jdField_a_of_type_Bjos;
    paramString.sendToTarget();
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveSoDownloader", 2, "onDownloadSucceed path:" + paramDownloadResult.getPath());
    }
    paramString = Message.obtain(this.jdField_a_of_type_Bjor.a, 4);
    paramString.obj = this.jdField_a_of_type_Bjos;
    paramString.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjou
 * JD-Core Version:    0.7.0.1
 */