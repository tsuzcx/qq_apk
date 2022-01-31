import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.OrientationListener;
import com.tencent.ttpic.baseutils.log.LogUtils;

public abstract class bkve
{
  private int jdField_a_of_type_Int = -1;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorEventListener jdField_a_of_type_AndroidHardwareSensorEventListener;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private OrientationListener jdField_a_of_type_AndroidViewOrientationListener;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public bkve(Context paramContext)
  {
    this(paramContext, 3);
  }
  
  public bkve(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.b = paramInt;
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    if (this.jdField_a_of_type_AndroidHardwareSensor != null) {
      this.jdField_a_of_type_AndroidHardwareSensorEventListener = new bkvf(this);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
      LogUtils.w("MOEL", "Cannot detect sensors. Not enabled");
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor, this.b);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(int paramInt);
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidHardwareSensor != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
      LogUtils.w("MOEL", "Cannot detect sensors. Invalid disable");
    }
    while (this.jdField_a_of_type_Boolean != true) {
      return;
    }
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkve
 * JD-Core Version:    0.7.0.1
 */