import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class bbih
  implements SensorEventListener
{
  bbih(bbig parambbig) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (bbig.a(this.a) == null) {
      return;
    }
    if (actn.b())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < bbig.a(this.a)) {
      bbig.a(this.a, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!actn.a()) {
        break;
      }
      if (bbig.a(this.a).hasMessages(1)) {
        bbig.a(this.a).removeMessages(1);
      }
      bbig.a(this.a).sendMessageDelayed(bbig.a(this.a).obtainMessage(1), 150L);
      return;
      bbig.a(this.a, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (bbig.a(this.a).hasMessages(1)) {
        bbig.a(this.a).removeMessages(1);
      }
      bbig.a(this.a).sendMessageDelayed(bbig.a(this.a).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.a)
    {
      if (bbig.a(this.a) != null) {
        bbig.a(this.a).a(bbig.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbih
 * JD-Core Version:    0.7.0.1
 */