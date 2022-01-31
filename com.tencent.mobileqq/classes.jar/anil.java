import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import dov.com.qq.im.QIMCameraCaptureUnit;

public class anil
  implements MediaScanner.OnMediaInfoScannerListener
{
  public anil(QIMCameraCaptureUnit paramQIMCameraCaptureUnit) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.a.a(101);
      return;
    }
    this.a.a(this.a.a, paramLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anil
 * JD-Core Version:    0.7.0.1
 */