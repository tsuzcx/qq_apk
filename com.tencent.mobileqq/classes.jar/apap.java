import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mobileqq.armap.sensor.rotation.Matrix4;

public abstract class apap
  extends apao
{
  public int a;
  protected Context a;
  protected apay a;
  public Matrix4 a;
  public float[] b = new float[3];
  public float[] c = new float[3];
  
  public apap(Context paramContext, int paramInt, SensorManager paramSensorManager, apah paramapah)
  {
    super(paramSensorManager, paramapah);
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4 = new Matrix4();
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4 = new Matrix4();
    this.jdField_a_of_type_Apay = new apay();
  }
  
  protected void a(float[] paramArrayOfFloat)
  {
    if ((this.jdField_a_of_type_Apah == null) || (paramArrayOfFloat == null)) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4.set(paramArrayOfFloat);
        this.jdField_a_of_type_Apay.a(this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4, 0, this.c);
        if (this.jdField_a_of_type_Int == 1)
        {
          this.jdField_a_of_type_Apah.updateAzimuth(this.c[0]);
          return;
        }
        this.b[0] = this.c[1];
        this.b[1] = (-this.c[0]);
        this.b[2] = (-this.c[2]);
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_Apah.updateRotation(this.b[0], this.b[1], this.b[2]);
          return;
        }
      } while ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3));
      this.jdField_a_of_type_Apah.updateRotation(this.b[0], this.b[1], this.b[2]);
    } while ((this.jdField_a_of_type_Int != 3) || (paramArrayOfFloat.length != 16));
    this.jdField_a_of_type_Apah.onRotationUpdateOriginal(paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apap
 * JD-Core Version:    0.7.0.1
 */