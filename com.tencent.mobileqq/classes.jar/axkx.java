import android.opengl.EGLContext;

public class axkx
{
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  public axlt a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidOpenglEGLContext = null;
      return;
    }
  }
  
  public void a(EGLContext paramEGLContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidOpenglEGLContext = paramEGLContext;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axkx
 * JD-Core Version:    0.7.0.1
 */