import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class bahc
  implements SensorEventListener
{
  bahc(bahb parambahb) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (bahb.a(this.a) == null) {
      return;
    }
    if (aciy.b())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < bahb.a(this.a)) {
      bahb.a(this.a, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!aciy.a()) {
        break;
      }
      if (bahb.a(this.a).hasMessages(1)) {
        bahb.a(this.a).removeMessages(1);
      }
      bahb.a(this.a).sendMessageDelayed(bahb.a(this.a).obtainMessage(1), 150L);
      return;
      bahb.a(this.a, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (bahb.a(this.a).hasMessages(1)) {
        bahb.a(this.a).removeMessages(1);
      }
      bahb.a(this.a).sendMessageDelayed(bahb.a(this.a).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.a)
    {
      if (bahb.a(this.a) != null) {
        bahb.a(this.a).a(bahb.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahc
 * JD-Core Version:    0.7.0.1
 */