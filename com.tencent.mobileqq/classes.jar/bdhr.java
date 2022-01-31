import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class bdhr
  implements SensorEventListener
{
  bdhr(bdhq parambdhq) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (bdhq.a(this.a) == null) {
      return;
    }
    if (aekt.b())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < bdhq.a(this.a)) {
      bdhq.a(this.a, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!aekt.a()) {
        break;
      }
      if (bdhq.a(this.a).hasMessages(1)) {
        bdhq.a(this.a).removeMessages(1);
      }
      bdhq.a(this.a).sendMessageDelayed(bdhq.a(this.a).obtainMessage(1), 150L);
      return;
      bdhq.a(this.a, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (bdhq.a(this.a).hasMessages(1)) {
        bdhq.a(this.a).removeMessages(1);
      }
      bdhq.a(this.a).sendMessageDelayed(bdhq.a(this.a).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.a)
    {
      if (bdhq.a(this.a) != null) {
        bdhq.a(this.a).a(bdhq.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhr
 * JD-Core Version:    0.7.0.1
 */