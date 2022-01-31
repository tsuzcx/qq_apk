import android.widget.ImageView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class amti
  implements Runnable
{
  public amti(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    this.a.d = false;
    this.a.s();
    QIMEffectCameraCaptureUnit.f(this.a, true);
    QIMEffectCameraCaptureUnit.b(this.a).setVisibility(0);
    QIMEffectCameraCaptureUnit.b(this.a).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amti
 * JD-Core Version:    0.7.0.1
 */