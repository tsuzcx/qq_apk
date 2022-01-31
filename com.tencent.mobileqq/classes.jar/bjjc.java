import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

public class bjjc
  extends bjja
{
  public bjjc(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public int a()
  {
    return 3;
  }
  
  protected void a()
  {
    this.jdField_c_of_type_Float = 90.0F;
  }
  
  public int b()
  {
    return 2;
  }
  
  protected void b()
  {
    Object localObject = bjqf.a().a();
    if ((localObject == null) || (((ArrayList)localObject).size() != 2)) {}
    do
    {
      return;
      float[] arrayOfFloat = (float[])((ArrayList)localObject).get(0);
      if (arrayOfFloat != null)
      {
        this.jdField_a_of_type_Int = (arrayOfFloat.length / 3);
        this.jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.jdField_a_of_type_JavaNioFloatBuffer.put(arrayOfFloat);
        this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
      }
      localObject = (float[])((ArrayList)localObject).get(1);
    } while (localObject == null);
    this.jdField_b_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(localObject.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.jdField_b_of_type_JavaNioFloatBuffer.put((float[])localObject);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Float > 90.0F) {
      this.jdField_b_of_type_Float = 90.0F;
    }
    for (;;)
    {
      if (this.d != 0.0F)
      {
        float f = (float)(Math.toDegrees(Math.atan(this.d)) * 2.0D);
        if (Build.VERSION.SDK_INT >= 14) {
          Matrix.perspectiveM(this.jdField_b_of_type_ArrayOfFloat, 0, f, this.e, 1.0F, 500.0F);
        }
        Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, 0.0F, 0.0F, -2.0F);
      }
      Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, -this.jdField_b_of_type_Float, 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, -this.jdField_c_of_type_Float, 0.0F, 1.0F, 0.0F);
      Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.0F, 0.0F, 0.0F, 1.0F);
      if (this.jdField_a_of_type_Bjjb != null) {
        this.jdField_a_of_type_Bjjb.a((int)this.jdField_f_of_type_Float, -this.jdField_b_of_type_Float, -this.jdField_c_of_type_Float, this.d);
      }
      return;
      if (this.jdField_b_of_type_Float < -90.0F) {
        this.jdField_b_of_type_Float = -90.0F;
      }
    }
  }
  
  public void d()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jdField_f_of_type_Int);
    GLES20.glUniformMatrix4fv(this.jdField_c_of_type_Int, 1, false, a(), 0);
    GLES20.glDrawArrays(4, 0, c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjjc
 * JD-Core Version:    0.7.0.1
 */