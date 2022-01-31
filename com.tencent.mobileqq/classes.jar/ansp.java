import android.os.Handler;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class ansp
  implements Runnable
{
  private ansp(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    QIMEffectCameraCaptureUnit.b(this.a);
    if (QIMEffectCameraCaptureUnit.a(this.a) >= 3) {
      QIMEffectCameraCaptureUnit.a(this.a, 0);
    }
    QIMEffectCameraCaptureUnit.a(this.a, QIMEffectCameraCaptureUnit.a(this.a));
    this.a.a.postDelayed(QIMEffectCameraCaptureUnit.a(this.a), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansp
 * JD-Core Version:    0.7.0.1
 */