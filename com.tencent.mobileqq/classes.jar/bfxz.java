import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

class bfxz
  implements SensorEventListener
{
  bfxz(bfxy parambfxy) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent arg1)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSSensor", 4, "QQLSSensor onSensorChanged" + ???.values[0]);
    }
    if (bfxy.a(this.a) == null) {
      return;
    }
    if (AIOUtils.isRubbishSamsun())
    {
      this.a.a = false;
      return;
    }
    if (???.values[0] < bfxy.a(this.a)) {
      bfxy.a(this.a, true);
    }
    for (;;)
    {
      ??? = Build.MODEL;
      if (!AIOUtils.isSamsungPhone()) {
        break;
      }
      if (bfxy.a(this.a).hasMessages(1)) {
        bfxy.a(this.a).removeMessages(1);
      }
      bfxy.a(this.a).sendMessageDelayed(bfxy.a(this.a).obtainMessage(1), 150L);
      return;
      bfxy.a(this.a, false);
    }
    if ((???.equalsIgnoreCase("mi 3c")) || (???.equalsIgnoreCase("K-Touch W619")) || (???.equalsIgnoreCase("mi 3w")))
    {
      if (bfxy.a(this.a).hasMessages(1)) {
        bfxy.a(this.a).removeMessages(1);
      }
      bfxy.a(this.a).sendMessageDelayed(bfxy.a(this.a).obtainMessage(1), 250L);
      return;
    }
    synchronized (this.a)
    {
      if (bfxy.a(this.a) != null) {
        bfxy.a(this.a).a(bfxy.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxz
 * JD-Core Version:    0.7.0.1
 */