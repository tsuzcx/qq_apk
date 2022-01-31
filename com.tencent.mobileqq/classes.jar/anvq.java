import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment;

public class anvq
  implements Runnable
{
  public anvq(CaptureQmcfSoDownloadFragment paramCaptureQmcfSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    CaptureQmcfSoDownloadFragment.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureFragmentCaptureQmcfSoDownloadFragment).setText(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 2, "setTipsTextData: textData=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvq
 * JD-Core Version:    0.7.0.1
 */