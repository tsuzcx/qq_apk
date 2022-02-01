import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class aprp
{
  public static final float[] a;
  public static final short[] a;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private ShortBuffer jdField_a_of_type_JavaNioShortBuffer;
  public float[] b;
  public short[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    jdField_a_of_type_ArrayOfShort = new short[] { 0, 1, 2, 2, 3, 0 };
  }
  
  public aprp()
  {
    this.jdField_b_of_type_ArrayOfFloat = jdField_a_of_type_ArrayOfFloat;
    this.jdField_b_of_type_ArrayOfShort = jdField_a_of_type_ArrayOfShort;
    b();
  }
  
  public aprp(float[] paramArrayOfFloat, short[] paramArrayOfShort)
  {
    this.jdField_b_of_type_ArrayOfFloat = paramArrayOfFloat;
    this.jdField_b_of_type_ArrayOfShort = paramArrayOfShort;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_b_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_b_of_type_ArrayOfFloat).position(0);
    this.jdField_a_of_type_JavaNioShortBuffer = ByteBuffer.allocateDirect(this.jdField_b_of_type_ArrayOfShort.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
    this.jdField_a_of_type_JavaNioShortBuffer.put(this.jdField_b_of_type_ArrayOfShort).position(0);
  }
  
  public void a()
  {
    GLES20.glDrawElements(4, 6, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    GLES20.glEnableVertexAttribArray(paramInt1);
    aprn.a("glEnableVertexAttribArray aPositionHandle");
    GLES20.glEnableVertexAttribArray(paramInt2);
    aprn.a("glEnableVertexAttribArray aTextureCoordHandle");
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(paramInt1, 3, 5126, false, 20, this.jdField_a_of_type_JavaNioFloatBuffer);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(3);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 20, this.jdField_a_of_type_JavaNioFloatBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprp
 * JD-Core Version:    0.7.0.1
 */