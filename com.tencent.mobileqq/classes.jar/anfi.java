import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class anfi
  implements SensorEventListener
{
  anfi(anff paramanff) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1) {
      anff.a(this.a, paramSensorEvent);
    }
    while (paramSensorEvent.sensor.getType() != 3) {
      return;
    }
    anff.b(this.a, paramSensorEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfi
 * JD-Core Version:    0.7.0.1
 */