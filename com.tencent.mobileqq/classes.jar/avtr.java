import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class avtr
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  
  private avtr(avtp paramavtp) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 5)
    {
      this.jdField_a_of_type_Float = paramSensorEvent.values[0];
      if (avtp.a(this.jdField_a_of_type_Avtp) != null) {
        avtp.a(this.jdField_a_of_type_Avtp).a(this.jdField_a_of_type_Float);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avtr
 * JD-Core Version:    0.7.0.1
 */