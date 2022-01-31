import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class bbiv
  implements SensorEventListener
{
  bbiv(bbiu parambbiu) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (bbiu.a(this.a) == null) {
      return;
    }
    if (actj.b())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < bbiu.a(this.a)) {
      bbiu.a(this.a, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!actj.a()) {
        break;
      }
      if (bbiu.a(this.a).hasMessages(1)) {
        bbiu.a(this.a).removeMessages(1);
      }
      bbiu.a(this.a).sendMessageDelayed(bbiu.a(this.a).obtainMessage(1), 150L);
      return;
      bbiu.a(this.a, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (bbiu.a(this.a).hasMessages(1)) {
        bbiu.a(this.a).removeMessages(1);
      }
      bbiu.a(this.a).sendMessageDelayed(bbiu.a(this.a).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.a)
    {
      if (bbiu.a(this.a) != null) {
        bbiu.a(this.a).a(bbiu.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbiv
 * JD-Core Version:    0.7.0.1
 */