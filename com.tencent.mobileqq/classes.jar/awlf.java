import android.opengl.EGLContext;

public class awlf
{
  int jdField_a_of_type_Int;
  EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  Object jdField_a_of_type_JavaLangObject = new Object();
  int b;
  
  public void a(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidOpenglEGLContext = paramEGLContext;
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awlf
 * JD-Core Version:    0.7.0.1
 */