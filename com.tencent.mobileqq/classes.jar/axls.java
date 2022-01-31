import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class axls
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  
  private axls(axlq paramaxlq) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 5)
    {
      this.jdField_a_of_type_Float = paramSensorEvent.values[0];
      if (axlq.a(this.jdField_a_of_type_Axlq) != null) {
        axlq.a(this.jdField_a_of_type_Axlq).a(this.jdField_a_of_type_Float);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axls
 * JD-Core Version:    0.7.0.1
 */