public class axud
  extends axtu
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int c;
  
  public axud(axtu paramaxtu)
  {
    super(paramaxtu.jdField_a_of_type_JavaLangString, paramaxtu.jdField_a_of_type_Int, paramaxtu.jdField_b_of_type_Boolean, paramaxtu.jdField_a_of_type_Boolean, paramaxtu.jdField_a_of_type_Long, paramaxtu.jdField_b_of_type_Long);
  }
  
  public axud(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(axtu paramaxtu)
  {
    boolean bool = super.a(paramaxtu);
    if ((paramaxtu instanceof axud))
    {
      paramaxtu = (axud)paramaxtu;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != paramaxtu.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramaxtu.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != paramaxtu.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = paramaxtu.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.c != paramaxtu.c)
      {
        this.c = paramaxtu.c;
        return true;
      }
    }
    else
    {
      throw new IllegalArgumentException("should be FlowDecodeConfig's instance");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axud
 * JD-Core Version:    0.7.0.1
 */