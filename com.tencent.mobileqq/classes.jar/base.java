public class base
  extends barv
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int c = 0;
  
  public base(barv parambarv)
  {
    super(parambarv.jdField_a_of_type_JavaLangString, parambarv.jdField_a_of_type_Int, parambarv.jdField_b_of_type_Boolean, parambarv.jdField_a_of_type_Boolean, parambarv.jdField_a_of_type_Long, parambarv.jdField_b_of_type_Long);
  }
  
  public base(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(barv parambarv)
  {
    boolean bool = super.a(parambarv);
    if ((parambarv instanceof base))
    {
      parambarv = (base)parambarv;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != parambarv.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = parambarv.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != parambarv.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = parambarv.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.c != parambarv.c)
      {
        this.c = parambarv.c;
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
 * Qualified Name:     base
 * JD-Core Version:    0.7.0.1
 */