import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite;

public class anvs
  implements Runnable
{
  public anvs(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, String paramString) {}
  
  public void run()
  {
    if (CaptureQmcfSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite))
    {
      CaptureQmcfSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite).setProgress((CaptureQmcfSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite) + CaptureQmcfSoDownloadFragmentAllWaite.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite)) / 2);
      if (QLog.isColorLevel()) {
        QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "" + this.jdField_a_of_type_JavaLangString + " setProgress=" + (CaptureQmcfSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite) + CaptureQmcfSoDownloadFragmentAllWaite.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite)) / 2);
      }
      CaptureQmcfSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite);
    }
    do
    {
      return;
      CaptureQmcfSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite).setProgress(CaptureQmcfSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite));
    } while (!QLog.isColorLevel());
    QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "" + this.jdField_a_of_type_JavaLangString + " setProgress=" + CaptureQmcfSoDownloadFragmentAllWaite.c(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvs
 * JD-Core Version:    0.7.0.1
 */