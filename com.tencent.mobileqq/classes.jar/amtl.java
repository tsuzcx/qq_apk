import android.os.Handler;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class amtl
  implements Runnable
{
  public amtl(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    QIMEffectCameraCaptureUnit.d(this.a);
    this.a.a.removeCallbacks(QIMEffectCameraCaptureUnit.a(this.a));
    QIMEffectCameraCaptureUnit.f(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amtl
 * JD-Core Version:    0.7.0.1
 */