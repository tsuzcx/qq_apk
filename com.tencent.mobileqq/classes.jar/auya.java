public class auya
  extends auxr
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int c;
  
  public auya(auxr paramauxr)
  {
    super(paramauxr.jdField_a_of_type_JavaLangString, paramauxr.jdField_a_of_type_Int, paramauxr.jdField_b_of_type_Boolean, paramauxr.jdField_a_of_type_Boolean, paramauxr.jdField_a_of_type_Long, paramauxr.jdField_b_of_type_Long);
  }
  
  public auya(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(auxr paramauxr)
  {
    boolean bool = super.a(paramauxr);
    if ((paramauxr instanceof auya))
    {
      paramauxr = (auya)paramauxr;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != paramauxr.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramauxr.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != paramauxr.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = paramauxr.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.c != paramauxr.c)
      {
        this.c = paramauxr.c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auya
 * JD-Core Version:    0.7.0.1
 */