import android.os.Handler;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class anjq
  implements Runnable
{
  public anjq(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    QIMEffectCameraCaptureUnit.d(this.a);
    this.a.a.removeCallbacks(QIMEffectCameraCaptureUnit.a(this.a));
    QIMEffectCameraCaptureUnit.f(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anjq
 * JD-Core Version:    0.7.0.1
 */