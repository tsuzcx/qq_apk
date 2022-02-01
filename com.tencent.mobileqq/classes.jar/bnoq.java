import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.OrientationListener;

class bnoq
  implements SensorEventListener
{
  bnoq(bnop parambnop) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float[] arrayOfFloat = paramSensorEvent.values;
    int j = -1;
    float f1 = -arrayOfFloat[0];
    float f2 = -arrayOfFloat[1];
    float f3 = -arrayOfFloat[2];
    if ((f1 * f1 + f2 * f2) * 35.0F >= f3 * f3)
    {
      j = 90 - Math.round(57.29578F * (float)Math.atan2(-f2, f1));
      int i;
      for (;;)
      {
        i = j;
        if (j < 360) {
          break;
        }
        j -= 360;
      }
      for (;;)
      {
        j = i;
        if (i >= 0) {
          break;
        }
        i += 360;
      }
    }
    if (bnop.a(this.a) != null) {
      bnop.a(this.a).onSensorChanged(1, paramSensorEvent.values);
    }
    if (j != bnop.a(this.a))
    {
      bnop.a(this.a, j);
      this.a.a(j);
    }
    this.a.a((f1 + 9.8F) * 180.0F / 19.6F, (f2 + 9.8F) * 180.0F / 19.6F, (f3 + 9.8F) * 180.0F / 19.6F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoq
 * JD-Core Version:    0.7.0.1
 */