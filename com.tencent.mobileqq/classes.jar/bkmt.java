import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import dov.com.qq.im.QIMCameraCaptureUnit.10;
import mqq.app.AppRuntime;

public class bkmt
  implements MediaScanner.OnMediaInfoScannerListener
{
  public bkmt(QIMCameraCaptureUnit.10 param10) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.a.this$0.a(101);
      return;
    }
    bkms.a(this.a.this$0, false);
    if (!BaseApplicationImpl.getApplication().getRuntime().isBackground_Pause)
    {
      this.a.this$0.a(this.a.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
    this.a.this$0.b = this.a.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
    this.a.this$0.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkmt
 * JD-Core Version:    0.7.0.1
 */