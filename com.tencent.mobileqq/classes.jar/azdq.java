import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class azdq
  extends azdr
{
  azdq()
  {
    super(1);
    this.a = "StepEmptySensor";
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdq
 * JD-Core Version:    0.7.0.1
 */