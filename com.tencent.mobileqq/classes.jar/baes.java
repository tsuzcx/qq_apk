public class baes
  extends baej
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int c = 0;
  
  public baes(baej parambaej)
  {
    super(parambaej.jdField_a_of_type_JavaLangString, parambaej.jdField_a_of_type_Int, parambaej.jdField_b_of_type_Boolean, parambaej.jdField_a_of_type_Boolean, parambaej.jdField_a_of_type_Long, parambaej.jdField_b_of_type_Long);
  }
  
  public baes(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(baej parambaej)
  {
    boolean bool = super.a(parambaej);
    if ((parambaej instanceof baes))
    {
      parambaej = (baes)parambaej;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != parambaej.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = parambaej.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != parambaej.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = parambaej.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.c != parambaej.c)
      {
        this.c = parambaej.c;
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
 * Qualified Name:     baes
 * JD-Core Version:    0.7.0.1
 */