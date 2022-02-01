import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.qphone.base.util.QLog;

public class bbgt
{
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private bbgv jdField_a_of_type_Bbgv;
  private bbgw jdField_a_of_type_Bbgw;
  private boolean jdField_a_of_type_Boolean;
  
  public static bbgt a()
  {
    return bbgx.a();
  }
  
  public int a(Context paramContext, bbgw parambbgw)
  {
    QLog.d("MicroMsg.LightSensor", 1, "SensorShower start");
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("MicroMsg.LightSensor", 1, "[SensorShower.start] light sensor has started");
      return 2;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getApplicationContext().getSystemService("sensor"));
    paramContext = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(5);
    if (paramContext != null)
    {
      this.jdField_a_of_type_Bbgv = new bbgv(this, null);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Bbgv, paramContext, 3);
      this.jdField_a_of_type_Bbgw = parambbgw;
      return 0;
    }
    QLog.e("MicroMsg.LightSensor", 1, "[SensorShower.start] System do not have lightSensor");
    return 1;
  }
  
  public void a()
  {
    QLog.d("MicroMsg.LightSensor", 1, "sensorshower stop");
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidHardwareSensorManager == null))
    {
      QLog.d("MicroMsg.LightSensor", 1, "sensorshower stop mHasStarted is false or mSensorShower is null");
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Bbgv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgt
 * JD-Core Version:    0.7.0.1
 */