import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

class bhgr
  implements SensorEventListener
{
  bhgr(bhgq parambhgq) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (bhgq.a(this.a) == null) {
      return;
    }
    if (AIOUtils.isRubbishSamsun())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < bhgq.a(this.a)) {
      bhgq.a(this.a, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!AIOUtils.isSamsungPhone()) {
        break;
      }
      if (bhgq.a(this.a).hasMessages(1)) {
        bhgq.a(this.a).removeMessages(1);
      }
      bhgq.a(this.a).sendMessageDelayed(bhgq.a(this.a).obtainMessage(1), 150L);
      return;
      bhgq.a(this.a, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (bhgq.a(this.a).hasMessages(1)) {
        bhgq.a(this.a).removeMessages(1);
      }
      bhgq.a(this.a).sendMessageDelayed(bhgq.a(this.a).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.a)
    {
      if (bhgq.a(this.a) != null) {
        bhgq.a(this.a).a(bhgq.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgr
 * JD-Core Version:    0.7.0.1
 */