import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import java.util.List;

public class apat
  extends apap
{
  private float a;
  private float b = -1.0F;
  private float c = -1.0F;
  float[] d = new float[3];
  private float[] e = new float[16];
  
  public apat(Context paramContext, int paramInt, SensorManager paramSensorManager, apah paramapah)
  {
    super(paramContext, paramInt, paramSensorManager, paramapah);
    this.jdField_a_of_type_Float = -1.0F;
    if (paramSensorManager.getDefaultSensor(3) != null)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramSensorManager.getDefaultSensor(3));
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(3));
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.jdField_a_of_type_Apah == null) {
      return;
    }
    if (Math.abs(paramFloat1 - this.jdField_a_of_type_Float) > 1.0F)
    {
      this.jdField_a_of_type_Float = paramFloat1;
      this.jdField_a_of_type_Apah.updateAzimuth(paramFloat1);
    }
    if (Math.abs(paramFloat2 - this.b) > 1.0F)
    {
      this.b = paramFloat2;
      this.jdField_a_of_type_Apah.updatePitch(paramFloat2);
    }
    if (Math.abs(paramFloat3 - this.c) > 1.0F)
    {
      this.c = paramFloat3;
      this.jdField_a_of_type_Apah.updateRoll(paramFloat3);
    }
    this.jdField_a_of_type_Apah.updateSensor(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 3)
    {
      System.arraycopy(paramSensorEvent.values, 0, this.jdField_a_of_type_ArrayOfFloat, 0, 3);
      if (this.jdField_a_of_type_Int != 1)
      {
        this.d[0] = ((float)Math.toRadians(this.jdField_a_of_type_ArrayOfFloat[0]));
        this.d[1] = ((float)Math.toRadians(this.jdField_a_of_type_ArrayOfFloat[1]));
        this.d[2] = ((float)Math.toRadians(this.jdField_a_of_type_ArrayOfFloat[2]));
        apaj.a(apaj.a(this.d), this.e);
        super.a(this.e);
      }
    }
    else
    {
      return;
    }
    a(this.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_ArrayOfFloat[1], this.jdField_a_of_type_ArrayOfFloat[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apat
 * JD-Core Version:    0.7.0.1
 */