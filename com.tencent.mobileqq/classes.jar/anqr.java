import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import dov.com.qq.im.QIMCameraCaptureUnit;
import mqq.app.AppRuntime;

class anqr
  implements MediaScanner.OnMediaInfoScannerListener
{
  anqr(anqq paramanqq) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.a.a.a(101);
      return;
    }
    QIMCameraCaptureUnit.b(this.a.a, false);
    if (!BaseApplicationImpl.getApplication().getRuntime().isBackground_Pause)
    {
      this.a.a.a(this.a.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
    this.a.a.b = this.a.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
    this.a.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqr
 * JD-Core Version:    0.7.0.1
 */