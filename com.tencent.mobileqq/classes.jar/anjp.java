import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class anjp
  implements Runnable
{
  public anjp(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    QIMEffectCameraCaptureUnit.b(this.a).setVisibility(8);
    QIMEffectCameraCaptureUnit.b(this.a).setEnabled(false);
    QIMEffectCameraCaptureUnit.a(this.a, 0);
    QIMEffectCameraCaptureUnit.a(this.a, QIMEffectCameraCaptureUnit.a(this.a));
    QIMEffectCameraCaptureUnit.f(this.a).setVisibility(0);
    this.a.a.postDelayed(QIMEffectCameraCaptureUnit.a(this.a), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anjp
 * JD-Core Version:    0.7.0.1
 */