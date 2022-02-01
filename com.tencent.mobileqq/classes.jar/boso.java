import com.tencent.aekit.openrender.internal.Frame;

public class boso
{
  public static final Integer a;
  private bosv jdField_a_of_type_Bosv = new bosv();
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(480);
  }
  
  public Frame a(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bosv.a(paramFrame, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      localFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    return localFrame;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bosv.apply();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bosv.ClearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boso
 * JD-Core Version:    0.7.0.1
 */