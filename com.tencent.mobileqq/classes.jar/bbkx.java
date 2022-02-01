public class bbkx
  extends bbko
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int c = 0;
  
  public bbkx(bbko parambbko)
  {
    super(parambbko.jdField_a_of_type_JavaLangString, parambbko.jdField_a_of_type_Int, parambbko.jdField_b_of_type_Boolean, parambbko.jdField_a_of_type_Boolean, parambbko.jdField_a_of_type_Long, parambbko.jdField_b_of_type_Long);
  }
  
  public bbkx(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(bbko parambbko)
  {
    boolean bool = super.a(parambbko);
    if ((parambbko instanceof bbkx))
    {
      parambbko = (bbkx)parambbko;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != parambbko.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = parambbko.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != parambbko.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = parambbko.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.c != parambbko.c)
      {
        this.c = parambbko.c;
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
 * Qualified Name:     bbkx
 * JD-Core Version:    0.7.0.1
 */