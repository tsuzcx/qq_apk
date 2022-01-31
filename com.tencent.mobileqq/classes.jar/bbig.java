import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

public class bbig
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  public SensorEventListener a;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new bbii(this, Looper.getMainLooper());
  private bbij jdField_a_of_type_Bbij;
  public boolean a;
  private boolean b;
  
  public bbig(Context paramContext, bbij parambbij)
  {
    this.jdField_a_of_type_AndroidHardwareSensorEventListener = new bbih(this);
    this.jdField_a_of_type_Bbij = parambbij;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSSensor", 2, "LSSensor open=====");
    }
    this.b = false;
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
    if (this.jdField_a_of_type_AndroidHardwareSensor != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidHardwareSensor.getMaximumRange();
      if (this.jdField_a_of_type_Float > 10.0F) {
        this.jdField_a_of_type_Float = 10.0F;
      }
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor, 2);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bbij.a(this.b);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSSensor", 2, "LSSensor shutdown=====");
    }
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
      this.jdField_a_of_type_AndroidHardwareSensorManager = null;
    }
    try
    {
      this.jdField_a_of_type_Bbij = null;
      this.jdField_a_of_type_AndroidHardwareSensor = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbig
 * JD-Core Version:    0.7.0.1
 */