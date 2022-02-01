import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView;
import com.tencent.qphone.base.util.QLog;

public class bbjg
  extends OrientationEventListener
{
  public bbjg(QIdentifierCaptureView paramQIdentifierCaptureView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.k = paramInt;
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIdentifierCaptureView", 2, "OrientationEventListener unknown");
      }
      this.a.l = 90;
    }
    if ((paramInt > 315) || (paramInt < 45)) {
      this.a.l = 90;
    }
    for (;;)
    {
      if (this.a.b) {
        this.a.j = this.a.l;
      }
      bbht.a = this.a.j;
      return;
      if ((paramInt > 45) && (paramInt < 135)) {
        this.a.l = 180;
      } else if ((paramInt > 135) && (paramInt < 225)) {
        this.a.l = 270;
      } else if ((paramInt > 225) && (paramInt < 315)) {
        this.a.l = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjg
 * JD-Core Version:    0.7.0.1
 */