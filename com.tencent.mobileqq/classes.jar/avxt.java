public class avxt
  extends avxk
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int c;
  
  public avxt(avxk paramavxk)
  {
    super(paramavxk.jdField_a_of_type_JavaLangString, paramavxk.jdField_a_of_type_Int, paramavxk.jdField_b_of_type_Boolean, paramavxk.jdField_a_of_type_Boolean, paramavxk.jdField_a_of_type_Long, paramavxk.jdField_b_of_type_Long);
  }
  
  public avxt(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(avxk paramavxk)
  {
    boolean bool = super.a(paramavxk);
    if ((paramavxk instanceof avxt))
    {
      paramavxk = (avxt)paramavxk;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != paramavxk.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramavxk.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != paramavxk.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = paramavxk.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.c != paramavxk.c)
      {
        this.c = paramavxk.c;
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
 * Qualified Name:     avxt
 * JD-Core Version:    0.7.0.1
 */