import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite;

public class aomb
  implements Runnable
{
  public aomb(CaptureQmcfSoDownloadFragmentAllWaite paramCaptureQmcfSoDownloadFragmentAllWaite, int paramInt) {}
  
  public void run()
  {
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "onDownloadProgress mGestureState=" + CaptureQmcfSoDownloadFragmentAllWaite.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite) + " mVideoState=" + CaptureQmcfSoDownloadFragmentAllWaite.c(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite) + ",mFilterSoState=" + CaptureQmcfSoDownloadFragmentAllWaite.d(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite));
    }
    CaptureQmcfSoDownloadFragmentAllWaite.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragmentAllWaite, "GestureDownloadProgress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aomb
 * JD-Core Version:    0.7.0.1
 */