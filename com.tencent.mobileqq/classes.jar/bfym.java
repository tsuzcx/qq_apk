import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class bfym
  extends bfyn
{
  public static float a;
  private float g;
  
  public bfym(boolean paramBoolean)
  {
    super(paramBoolean);
    this.jdField_g_of_type_Float = 55.207924F;
    if (paramBoolean) {
      this.jdField_g_of_type_Int = 36;
    }
    this.jdField_c_of_type_Float = jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return 3;
  }
  
  protected void a()
  {
    if ((this.h != 0) && (this.i != 0)) {}
    for (this.jdField_f_of_type_Float = (360 - (6 - (int)(this.h / this.i + 0.1F)) * 40);; this.jdField_f_of_type_Float = 360.0F)
    {
      if (this.jdField_f_of_type_Float > 360.0F) {
        this.jdField_f_of_type_Float = 360.0F;
      }
      jdField_a_of_type_Float = this.jdField_f_of_type_Float / 2.0F;
      this.jdField_c_of_type_Float = jdField_a_of_type_Float;
      return;
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  protected void b()
  {
    this.d = 0.5228754F;
    ArrayList localArrayList = bgfl.a().a(this.jdField_f_of_type_Float, false);
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = bgfl.a().a(this.jdField_f_of_type_Float, true);; localObject = null)
    {
      if ((localArrayList == null) || (localArrayList.size() != 2)) {}
      float[] arrayOfFloat1;
      do
      {
        return;
        float[] arrayOfFloat2 = (float[])localArrayList.get(0);
        int i = arrayOfFloat2.length;
        arrayOfFloat1 = arrayOfFloat2;
        if (localObject != null)
        {
          float[] arrayOfFloat3 = (float[])((ArrayList)localObject).get(0);
          arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, arrayOfFloat3.length + i);
          System.arraycopy(arrayOfFloat3, 0, arrayOfFloat1, i, arrayOfFloat3.length);
        }
        if (arrayOfFloat1 != null)
        {
          this.jdField_a_of_type_Int = (i / 3);
          this.jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
          this.jdField_a_of_type_JavaNioFloatBuffer.put(arrayOfFloat1);
          this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
        }
        arrayOfFloat2 = (float[])localArrayList.get(1);
        i = arrayOfFloat2.length;
        arrayOfFloat1 = arrayOfFloat2;
        if (localObject != null)
        {
          localObject = (float[])((ArrayList)localObject).get(1);
          arrayOfFloat1 = Arrays.copyOf(arrayOfFloat2, localObject.length + i);
          System.arraycopy(localObject, 0, arrayOfFloat1, i, localObject.length);
        }
      } while (arrayOfFloat1 == null);
      this.jdField_b_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.jdField_b_of_type_JavaNioFloatBuffer.put(arrayOfFloat1);
      this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
      return;
    }
  }
  
  public void c()
  {
    if (this.d != 0.0F)
    {
      if (this.d > 0.5228754F) {
        this.d = 0.5228754F;
      }
      float f = (float)(Math.toDegrees(Math.atan(this.d)) * 2.0D);
      this.jdField_g_of_type_Float = ((int)((55.207924F - f) * 0.5D));
      if (Build.VERSION.SDK_INT >= 14) {
        Matrix.perspectiveM(this.jdField_b_of_type_ArrayOfFloat, 0, f, this.jdField_e_of_type_Float, 1.0F, 500.0F);
      }
      Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, 0.0F, 0.0F, -2.0F);
    }
    int i;
    if (this.jdField_b_of_type_Float > this.jdField_g_of_type_Float)
    {
      this.jdField_b_of_type_Float = this.jdField_g_of_type_Float;
      if (jdField_a_of_type_Float == 180.0F) {
        break label337;
      }
      if (this.jdField_e_of_type_Int != 1) {
        break label312;
      }
      i = 44;
      label133:
      if (this.jdField_c_of_type_Float <= this.jdField_f_of_type_Float - i) {
        break label318;
      }
      this.jdField_c_of_type_Float = (this.jdField_f_of_type_Float - i);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bfyg != null)
      {
        this.jdField_a_of_type_Bfyg.a(this.d);
        this.jdField_a_of_type_Bfyg.a(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
      }
      Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, -this.jdField_b_of_type_Float, 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, -this.jdField_c_of_type_Float, 0.0F, 1.0F, 0.0F);
      Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.0F, 0.0F, 0.0F, 1.0F);
      if ((this.jdField_a_of_type_Bfyo != null) && (this.d != 1.0F)) {
        this.jdField_a_of_type_Bfyo.a((int)this.jdField_f_of_type_Float - i, -this.jdField_b_of_type_Float, -this.jdField_c_of_type_Float, this.d);
      }
      return;
      if (this.jdField_b_of_type_Float >= -this.jdField_g_of_type_Float) {
        break;
      }
      this.jdField_b_of_type_Float = (-this.jdField_g_of_type_Float);
      break;
      label312:
      i = 17;
      break label133;
      label318:
      if (this.jdField_c_of_type_Float < i) {
        this.jdField_c_of_type_Float = i;
      }
      continue;
      label337:
      i = 0;
    }
  }
  
  public void d()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jdField_f_of_type_Int);
    GLES20.glUniformMatrix4fv(this.jdField_c_of_type_Int, 1, false, a(), 0);
    GLES20.glDrawArrays(4, 0, c());
    if (this.jdField_a_of_type_Bfyr != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_Bfyr.size())
      {
        bfys localbfys = (bfys)this.jdField_a_of_type_Bfyr.valueAt(i);
        int j = localbfys.a();
        if (j > 0)
        {
          GLES20.glBindTexture(3553, j);
          j = c();
          GLES20.glDrawArrays(4, ((int)(this.jdField_f_of_type_Float / 10.0F) - 1 - localbfys.b()) * 6 + j, 6);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfym
 * JD-Core Version:    0.7.0.1
 */