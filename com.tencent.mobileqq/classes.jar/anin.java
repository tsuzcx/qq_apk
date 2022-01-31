import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import dov.com.qq.im.QIMCameraCaptureUnit;

class anin
  implements MediaScanner.OnMediaInfoScannerListener
{
  anin(anim paramanim) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.a.a.a(101);
      return;
    }
    QIMCameraCaptureUnit.b(this.a.a, false);
    this.a.a.a(this.a.a.a, paramLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anin
 * JD-Core Version:    0.7.0.1
 */