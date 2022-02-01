import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class bhxa
  implements SensorEventListener
{
  bhxa(bhwz parambhwz, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent.values[0] > 1.0E+008F) || (NetConnInfoCenter.getServerTimeMillis() > this.jdField_a_of_type_Long))
    {
      QLog.e("SportManager", 1, "unregister listener:" + paramSensorEvent.values[0]);
      if (bhwz.a != null) {
        bhwz.a.unregisterListener(this);
      }
      return;
    }
    if ((bhww.jdField_a_of_type_Long == 0L) || (bhww.jdField_a_of_type_Int == 0))
    {
      QLog.e("SportManager", 1, "lastReportStepTime:" + bhww.jdField_a_of_type_Long + ",cur_total:" + bhww.jdField_a_of_type_Int);
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis() - bhww.jdField_a_of_type_Long;
    int i = (int)(paramSensorEvent.values[0] - bhww.jdField_a_of_type_Int);
    if ((l > this.jdField_a_of_type_Int) && (i > this.b))
    {
      this.jdField_a_of_type_Bhwz.a("timer1 report");
      return;
    }
    QLog.e("SportManager", 1, "sensor event step:" + paramSensorEvent.values[0] + ",cur_total:" + bhww.jdField_a_of_type_Int + ",interval time:" + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxa
 * JD-Core Version:    0.7.0.1
 */