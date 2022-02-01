import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class bgrc
  implements SensorEventListener
{
  bgrc(bgrb parambgrb) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (bgrb.a(this.a) == null) {
      return;
    }
    if (afur.b())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < bgrb.a(this.a)) {
      bgrb.a(this.a, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!afur.a()) {
        break;
      }
      if (bgrb.a(this.a).hasMessages(1)) {
        bgrb.a(this.a).removeMessages(1);
      }
      bgrb.a(this.a).sendMessageDelayed(bgrb.a(this.a).obtainMessage(1), 150L);
      return;
      bgrb.a(this.a, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (bgrb.a(this.a).hasMessages(1)) {
        bgrb.a(this.a).removeMessages(1);
      }
      bgrb.a(this.a).sendMessageDelayed(bgrb.a(this.a).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.a)
    {
      if (bgrb.a(this.a) != null) {
        bgrb.a(this.a).a(bgrb.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrc
 * JD-Core Version:    0.7.0.1
 */