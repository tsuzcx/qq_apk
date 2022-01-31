import android.widget.ImageView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class anrw
  implements Runnable
{
  public anrw(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    this.a.e = false;
    this.a.t();
    QIMEffectCameraCaptureUnit.f(this.a, true);
    QIMEffectCameraCaptureUnit.b(this.a).setVisibility(0);
    QIMEffectCameraCaptureUnit.b(this.a).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrw
 * JD-Core Version:    0.7.0.1
 */