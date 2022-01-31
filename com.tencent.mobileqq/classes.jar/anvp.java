import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment;

public class anvp
  implements Runnable
{
  public anvp(CaptureQmcfSoDownloadFragment paramCaptureQmcfSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    CaptureQmcfSoDownloadFragment.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragment).setProgress(CaptureQmcfSoDownloadFragment.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragment));
    if (QLog.isColorLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 2, "" + this.jdField_a_of_type_JavaLangString + " setProgress=" + CaptureQmcfSoDownloadFragment.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragment));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvp
 * JD-Core Version:    0.7.0.1
 */