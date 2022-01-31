import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class bjiu
  implements SensorEventListener
{
  private long jdField_a_of_type_Long;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private bjiv jdField_a_of_type_Bjiv;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  private float[] b = new float[3];
  
  public bjiu(Context paramContext, bjiv parambjiv)
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(4);
    this.jdField_a_of_type_Bjiv = parambjiv;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this, this.jdField_a_of_type_AndroidHardwareSensor);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 4)
    {
      if (this.jdField_a_of_type_Long != 0L)
      {
        float f1 = (float)(paramSensorEvent.timestamp - this.jdField_a_of_type_Long) * 1.0E-009F;
        float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
        arrayOfFloat[0] += paramSensorEvent.values[0] * f1;
        arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
        arrayOfFloat[1] += paramSensorEvent.values[1] * f1;
        arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
        float f2 = arrayOfFloat[2];
        arrayOfFloat[2] = (f1 * paramSensorEvent.values[2] + f2);
        f1 = (float)Math.toDegrees(this.jdField_a_of_type_ArrayOfFloat[0] - this.b[0]);
        f2 = (float)Math.toDegrees(this.jdField_a_of_type_ArrayOfFloat[1] - this.b[1]);
        float f3 = (float)Math.toDegrees(this.jdField_a_of_type_ArrayOfFloat[2] - this.b[2]);
        if (this.jdField_a_of_type_Bjiv != null) {
          this.jdField_a_of_type_Bjiv.a(f1 * 1.0F, f2 * 1.0F, f3 * 1.0F);
        }
        this.b[0] = this.jdField_a_of_type_ArrayOfFloat[0];
        this.b[1] = this.jdField_a_of_type_ArrayOfFloat[1];
        this.b[2] = this.jdField_a_of_type_ArrayOfFloat[2];
      }
      this.jdField_a_of_type_Long = paramSensorEvent.timestamp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjiu
 * JD-Core Version:    0.7.0.1
 */