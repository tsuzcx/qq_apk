import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.report.lp.MachineLearingSmartReport;

public class bhku
  implements ModuleDownloadListener
{
  public bhku(MachineLearingSmartReport paramMachineLearingSmartReport, String paramString1, String paramString2, String paramString3) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MachineLearingSmartReport", 2, "Module onDownloadCanceled " + paramString);
    }
  }
  
  public void onDownloadFailed(String paramString)
  {
    MachineLearingSmartReport.access$100(this.jdField_a_of_type_CooperationQzoneReportLpMachineLearingSmartReport, 10, "Module onDownloadFailed " + paramString);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MachineLearingSmartReport", 2, "Module onDownloadProgress " + paramString + ",progress=" + Float.toString(paramFloat));
    }
  }
  
  public void onDownloadSucceed(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MachineLearingSmartReport", 2, "Module onDownloadSucceed " + paramString);
    }
    MachineLearingSmartReport.access$000(this.jdField_a_of_type_CooperationQzoneReportLpMachineLearingSmartReport, this.jdField_a_of_type_JavaLangString, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhku
 * JD-Core Version:    0.7.0.1
 */