import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class bhre
  implements SensorEventListener
{
  bhre(bhrd parambhrd) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (bhrd.a(this.a) == null) {
      return;
    }
    if (agej.b())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < bhrd.a(this.a)) {
      bhrd.a(this.a, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!agej.a()) {
        break;
      }
      if (bhrd.a(this.a).hasMessages(1)) {
        bhrd.a(this.a).removeMessages(1);
      }
      bhrd.a(this.a).sendMessageDelayed(bhrd.a(this.a).obtainMessage(1), 150L);
      return;
      bhrd.a(this.a, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (bhrd.a(this.a).hasMessages(1)) {
        bhrd.a(this.a).removeMessages(1);
      }
      bhrd.a(this.a).sendMessageDelayed(bhrd.a(this.a).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.a)
    {
      if (bhrd.a(this.a) != null) {
        bhrd.a(this.a).a(bhrd.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhre
 * JD-Core Version:    0.7.0.1
 */