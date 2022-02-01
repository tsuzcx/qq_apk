import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class baoc
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  
  private baoc(baoa parambaoa) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 5)
    {
      this.jdField_a_of_type_Float = paramSensorEvent.values[0];
      if (baoa.a(this.jdField_a_of_type_Baoa) != null) {
        baoa.a(this.jdField_a_of_type_Baoa).a(this.jdField_a_of_type_Float);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baoc
 * JD-Core Version:    0.7.0.1
 */