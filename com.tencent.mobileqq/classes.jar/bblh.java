public class bblh
  extends bbky
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int c = 0;
  
  public bblh(bbky parambbky)
  {
    super(parambbky.jdField_a_of_type_JavaLangString, parambbky.jdField_a_of_type_Int, parambbky.jdField_b_of_type_Boolean, parambbky.jdField_a_of_type_Boolean, parambbky.jdField_a_of_type_Long, parambbky.jdField_b_of_type_Long);
  }
  
  public bblh(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(bbky parambbky)
  {
    boolean bool = super.a(parambbky);
    if ((parambbky instanceof bblh))
    {
      parambbky = (bblh)parambbky;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != parambbky.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = parambbky.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != parambbky.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = parambbky.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.c != parambbky.c)
      {
        this.c = parambbky.c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblh
 * JD-Core Version:    0.7.0.1
 */