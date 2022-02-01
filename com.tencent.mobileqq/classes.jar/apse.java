import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class apse
  implements SensorEventListener
{
  apse(apsb paramapsb) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1) {
      apsb.a(this.a, paramSensorEvent);
    }
    while (paramSensorEvent.sensor.getType() != 3) {
      return;
    }
    apsb.b(this.a, paramSensorEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apse
 * JD-Core Version:    0.7.0.1
 */