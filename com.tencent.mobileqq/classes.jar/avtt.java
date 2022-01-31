import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class avtt
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  
  private avtt(avtr paramavtr) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 5)
    {
      this.jdField_a_of_type_Float = paramSensorEvent.values[0];
      if (avtr.a(this.jdField_a_of_type_Avtr) != null) {
        avtr.a(this.jdField_a_of_type_Avtr).a(this.jdField_a_of_type_Float);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avtt
 * JD-Core Version:    0.7.0.1
 */