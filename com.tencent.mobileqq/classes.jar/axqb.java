import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class axqb
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  
  private axqb(axpz paramaxpz) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 5)
    {
      this.jdField_a_of_type_Float = paramSensorEvent.values[0];
      if (axpz.a(this.jdField_a_of_type_Axpz) != null) {
        axpz.a(this.jdField_a_of_type_Axpz).a(this.jdField_a_of_type_Float);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axqb
 * JD-Core Version:    0.7.0.1
 */