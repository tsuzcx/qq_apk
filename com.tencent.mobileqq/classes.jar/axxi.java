import android.hardware.Sensor;
import android.hardware.SensorEvent;
import androidx.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;

public class axxi
  extends axxf
{
  private boolean a;
  private long c;
  private int d;
  private int e;
  private int f;
  
  @RequiresApi(api=19)
  axxi()
  {
    super(19);
    this.jdField_a_of_type_JavaLangString = "StepSensorCounter";
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = (int)paramSensorEvent.values[0];
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.d = i;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] initRecord hasStepCount:", Integer.valueOf(this.d) });
      }
      return;
    }
    i -= this.d;
    int j = i - this.e;
    if (this.f == 0) {
      this.c = System.currentTimeMillis();
    }
    for (this.f = 1;; this.f += j)
    {
      a(j);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] thisStepCount:", Integer.valueOf(i), " thisStep:", Integer.valueOf(j), " sampleStepCount:", Integer.valueOf(this.f) });
      }
      this.e = i;
      if (this.f >= axwj.B)
      {
        long l = System.currentTimeMillis() - this.c;
        if ((l > 0L) && (this.f > 0)) {
          a(l / this.f);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] duration:", Long.valueOf(l), " sampleStepStartTime:", Long.valueOf(this.c) });
        }
        this.f = 0;
        this.c = 0L;
      }
      this.jdField_a_of_type_Double = System.currentTimeMillis();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxi
 * JD-Core Version:    0.7.0.1
 */