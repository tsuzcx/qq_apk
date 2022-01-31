import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class bdma
  implements SensorEventListener
{
  bdma(bdlz parambdlz) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (bdlz.a(this.a) == null) {
      return;
    }
    if (aepi.b())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < bdlz.a(this.a)) {
      bdlz.a(this.a, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!aepi.a()) {
        break;
      }
      if (bdlz.a(this.a).hasMessages(1)) {
        bdlz.a(this.a).removeMessages(1);
      }
      bdlz.a(this.a).sendMessageDelayed(bdlz.a(this.a).obtainMessage(1), 150L);
      return;
      bdlz.a(this.a, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (bdlz.a(this.a).hasMessages(1)) {
        bdlz.a(this.a).removeMessages(1);
      }
      bdlz.a(this.a).sendMessageDelayed(bdlz.a(this.a).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.a)
    {
      if (bdlz.a(this.a) != null) {
        bdlz.a(this.a).a(bdlz.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdma
 * JD-Core Version:    0.7.0.1
 */