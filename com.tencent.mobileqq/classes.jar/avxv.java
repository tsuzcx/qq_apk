public class avxv
  extends avxm
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int c;
  
  public avxv(avxm paramavxm)
  {
    super(paramavxm.jdField_a_of_type_JavaLangString, paramavxm.jdField_a_of_type_Int, paramavxm.jdField_b_of_type_Boolean, paramavxm.jdField_a_of_type_Boolean, paramavxm.jdField_a_of_type_Long, paramavxm.jdField_b_of_type_Long);
  }
  
  public avxv(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(avxm paramavxm)
  {
    boolean bool = super.a(paramavxm);
    if ((paramavxm instanceof avxv))
    {
      paramavxm = (avxv)paramavxm;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != paramavxm.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramavxm.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != paramavxm.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = paramavxm.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.c != paramavxm.c)
      {
        this.c = paramavxm.c;
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
 * Qualified Name:     avxv
 * JD-Core Version:    0.7.0.1
 */