public class axpu
  extends axpl
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int c;
  
  public axpu(axpl paramaxpl)
  {
    super(paramaxpl.jdField_a_of_type_JavaLangString, paramaxpl.jdField_a_of_type_Int, paramaxpl.jdField_b_of_type_Boolean, paramaxpl.jdField_a_of_type_Boolean, paramaxpl.jdField_a_of_type_Long, paramaxpl.jdField_b_of_type_Long);
  }
  
  public axpu(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(axpl paramaxpl)
  {
    boolean bool = super.a(paramaxpl);
    if ((paramaxpl instanceof axpu))
    {
      paramaxpl = (axpu)paramaxpl;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != paramaxpl.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramaxpl.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != paramaxpl.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = paramaxpl.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.c != paramaxpl.c)
      {
        this.c = paramaxpl.c;
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
 * Qualified Name:     axpu
 * JD-Core Version:    0.7.0.1
 */