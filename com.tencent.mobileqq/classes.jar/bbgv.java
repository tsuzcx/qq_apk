import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class bbgv
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  
  private bbgv(bbgt parambbgt) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 5)
    {
      this.jdField_a_of_type_Float = paramSensorEvent.values[0];
      if (bbgt.a(this.jdField_a_of_type_Bbgt) != null) {
        bbgt.a(this.jdField_a_of_type_Bbgt).a(this.jdField_a_of_type_Float);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgv
 * JD-Core Version:    0.7.0.1
 */