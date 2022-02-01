import android.hardware.Sensor;
import android.hardware.SensorEvent;
import androidx.annotation.RequiresApi;

public class azkb
  extends azjx
{
  @RequiresApi(api=19)
  azkb()
  {
    super(18);
    this.a = "StepSensorDetector";
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkb
 * JD-Core Version:    0.7.0.1
 */