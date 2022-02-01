import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

public class apdq
{
  private int jdField_a_of_type_Int;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private int[] jdField_b_of_type_ArrayOfInt;
  
  private void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException("width & height should > 0!");
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      GLES20.glDeleteFramebuffers(1, this.jdField_a_of_type_ArrayOfInt, 0);
      this.jdField_a_of_type_ArrayOfInt = null;
    }
    if (this.jdField_b_of_type_ArrayOfInt != null)
    {
      GLES20.glDeleteTextures(1, this.jdField_b_of_type_ArrayOfInt, 0);
      this.jdField_b_of_type_ArrayOfInt = null;
    }
    this.jdField_a_of_type_ArrayOfInt = new int[1];
    this.jdField_b_of_type_ArrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, this.jdField_a_of_type_ArrayOfInt, 0);
    GLES20.glGenTextures(1, this.jdField_b_of_type_ArrayOfInt, 0);
    GLES20.glBindTexture(3553, this.jdField_b_of_type_ArrayOfInt[0]);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jdField_b_of_type_ArrayOfInt[0], 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_b_of_type_ArrayOfInt != null) {
      i = this.jdField_b_of_type_ArrayOfInt[0];
    }
    return i;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_ArrayOfInt != null)
    {
      GLES20.glDeleteTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
      this.jdField_b_of_type_ArrayOfInt = null;
    }
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      GLES20.glDeleteFramebuffers(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      this.jdField_a_of_type_ArrayOfInt = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_ArrayOfInt == null) || (paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int))
    {
      long l = System.currentTimeMillis();
      b(paramInt1, paramInt2);
      QLog.i("Keying_FrameBuffer", 2, " init need " + (System.currentTimeMillis() - l));
    }
    GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ArrayOfInt[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdq
 * JD-Core Version:    0.7.0.1
 */