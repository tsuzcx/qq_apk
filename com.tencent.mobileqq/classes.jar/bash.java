import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class bash
  implements SensorEventListener
{
  bash(basg parambasg, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent.values[0] > 1.0E+008F) || (NetConnInfoCenter.getServerTimeMillis() > this.jdField_a_of_type_Long))
    {
      QLog.e("SportManager", 1, "unregister listener:" + paramSensorEvent.values[0]);
      if (basg.a != null) {
        basg.a.unregisterListener(this);
      }
      return;
    }
    if ((basd.jdField_a_of_type_Long == 0L) || (basd.jdField_a_of_type_Int == 0))
    {
      QLog.e("SportManager", 1, "lastReportStepTime:" + basd.jdField_a_of_type_Long + ",cur_total:" + basd.jdField_a_of_type_Int);
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis() - basd.jdField_a_of_type_Long;
    int i = (int)(paramSensorEvent.values[0] - basd.jdField_a_of_type_Int);
    if ((l > this.jdField_a_of_type_Int) && (i > this.b))
    {
      this.jdField_a_of_type_Basg.a("timer1 report");
      return;
    }
    QLog.e("SportManager", 1, "sensor event step:" + paramSensorEvent.values[0] + ",cur_total:" + basd.jdField_a_of_type_Int + ",interval time:" + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bash
 * JD-Core Version:    0.7.0.1
 */