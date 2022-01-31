import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import java.util.List;

public class anox
  extends anpa
{
  private float jdField_a_of_type_Float = -1.0F;
  boolean jdField_a_of_type_Boolean = false;
  private float b = -1.0F;
  private float c = -1.0F;
  private float[] d = new float[3];
  private float[] e = new float[3];
  private float[] f = new float[3];
  private float[] g = new float[3];
  private float[] h = new float[16];
  private float[] i = new float[3];
  
  public anox(Context paramContext, int paramInt, SensorManager paramSensorManager, anos paramanos)
  {
    super(paramContext, paramInt, paramSensorManager, paramanos);
    paramContext = paramSensorManager.getDefaultSensor(1);
    paramSensorManager = paramSensorManager.getDefaultSensor(2);
    if ((paramContext != null) && (paramSensorManager != null))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramContext);
      this.jdField_a_of_type_JavaUtilList.add(paramSensorManager);
      return;
    }
    throw new OrientationProviderNotFound("1,2");
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.jdField_a_of_type_Anos == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.jdField_a_of_type_Float) > 2.0F)
    {
      this.jdField_a_of_type_Float = paramFloat1;
      this.jdField_a_of_type_Anos.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.b) > 2.0F)
    {
      this.b = paramFloat2;
      this.jdField_a_of_type_Anos.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.c) > 2.0F)
    {
      this.c = paramFloat3;
      this.jdField_a_of_type_Anos.updateRoll(paramFloat3);
    }
    this.jdField_a_of_type_Anos.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 2)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.d, 0, 3);
      anot.a(this.d, this.g);
      System.arraycopy(this.d, 0, this.g, 0, 3);
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Boolean) && (SensorManager.getRotationMatrix(this.h, null, this.e, this.d)))
      {
        SensorManager.getOrientation(this.h, this.i);
        if (this.jdField_a_of_type_Int == 1) {
          break;
        }
        super.a(this.h);
      }
      return;
      if (paramSensorEvent.sensor.getType() == 1)
      {
        System.arraycopy(paramSensorEvent.values, 0, this.e, 0, 3);
        anot.a(this.e, this.f);
        System.arraycopy(this.e, 0, this.f, 0, 3);
      }
    }
    a((float)(Math.toDegrees(this.i[0] + a()) + 360.0D) % 360.0F, (float)(this.i[1] * 180.0F / 3.141592653589793D), (float)(this.i[2] * 180.0F / 3.141592653589793D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anox
 * JD-Core Version:    0.7.0.1
 */