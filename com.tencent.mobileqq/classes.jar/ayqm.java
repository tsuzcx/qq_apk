import android.hardware.Sensor;
import android.hardware.SensorEvent;

public class ayqm
  extends ayre
{
  private float jdField_a_of_type_Float;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[4];
  private float jdField_c_of_type_Float;
  private long jdField_c_of_type_Long;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int = 4;
  private long jdField_d_of_type_Long;
  private final float jdField_e_of_type_Float = 1.3F;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private float jdField_f_of_type_Float = 2.0F;
  private int jdField_f_of_type_Int;
  private int g;
  private int h = 250;
  
  ayqm()
  {
    super(1);
    this.jdField_a_of_type_JavaLangString = "AccelerometerDetector";
  }
  
  private float a(float paramFloat)
  {
    float f1 = this.jdField_f_of_type_Float;
    if (this.jdField_e_of_type_Int < 4)
    {
      this.jdField_b_of_type_ArrayOfFloat[this.jdField_e_of_type_Int] = paramFloat;
      this.jdField_e_of_type_Int += 1;
      return f1;
    }
    f1 = a(this.jdField_b_of_type_ArrayOfFloat, 4);
    System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 1, this.jdField_b_of_type_ArrayOfFloat, 0, 3);
    this.jdField_b_of_type_ArrayOfFloat[3] = paramFloat;
    return f1;
  }
  
  private float a(float[] paramArrayOfFloat, int paramInt)
  {
    float f1 = 0.0F;
    int i = 0;
    while (i < paramInt)
    {
      f1 += paramArrayOfFloat[i];
      i += 1;
    }
    f1 /= 4.0F;
    if (f1 >= 8.0F) {
      return 4.3F;
    }
    if ((f1 >= 7.0F) && (f1 < 8.0F)) {
      return 3.3F;
    }
    if ((f1 >= 4.0F) && (f1 < 7.0F)) {
      return 2.3F;
    }
    if ((f1 >= 3.0F) && (f1 < 4.0F)) {
      return 2.0F;
    }
    return 1.3F;
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_d_of_type_Float == 0.0F) {
      this.jdField_d_of_type_Float = paramFloat;
    }
    for (;;)
    {
      this.jdField_d_of_type_Float = paramFloat;
      return;
      if (a(paramFloat, this.jdField_d_of_type_Float))
      {
        this.jdField_d_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_e_of_type_Long = System.currentTimeMillis();
        if ((this.jdField_e_of_type_Long - this.jdField_d_of_type_Long >= this.h) && (this.jdField_a_of_type_Float - this.jdField_b_of_type_Float >= this.jdField_f_of_type_Float))
        {
          this.jdField_c_of_type_Long = this.jdField_e_of_type_Long;
          a();
        }
        if ((this.jdField_e_of_type_Long - this.jdField_d_of_type_Long >= this.h) && (this.jdField_a_of_type_Float - this.jdField_b_of_type_Float >= 1.3F))
        {
          this.jdField_c_of_type_Long = this.jdField_e_of_type_Long;
          this.jdField_f_of_type_Float = a(this.jdField_a_of_type_Float - this.jdField_b_of_type_Float);
        }
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if (paramFloat1 >= paramFloat2)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_f_of_type_Int += 1;
    }
    while ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && ((this.g >= 2) || (paramFloat2 >= 20.0F)))
    {
      this.jdField_a_of_type_Float = paramFloat2;
      return true;
      this.g = this.jdField_f_of_type_Int;
      this.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_Float = paramFloat2;
      return false;
    }
    return false;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    System.arraycopy(paramSensorEvent.values, 0, this.jdField_a_of_type_ArrayOfFloat, 0, 3);
    this.jdField_c_of_type_Float = ((float)Math.sqrt(this.jdField_a_of_type_ArrayOfFloat[0] * this.jdField_a_of_type_ArrayOfFloat[0] + this.jdField_a_of_type_ArrayOfFloat[1] * this.jdField_a_of_type_ArrayOfFloat[1] + this.jdField_a_of_type_ArrayOfFloat[2] * this.jdField_a_of_type_ArrayOfFloat[2]));
    a(this.jdField_c_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqm
 * JD-Core Version:    0.7.0.1
 */