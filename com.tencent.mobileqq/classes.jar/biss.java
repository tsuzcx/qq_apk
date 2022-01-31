import com.tencent.aekit.openrender.internal.Frame;

public class biss
{
  public static final Integer a;
  private bisz jdField_a_of_type_Bisz = new bisz();
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
      this.jdField_a_of_type_Bisz.a(paramFrame, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      localFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    return localFrame;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bisz.apply();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bisz.ClearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biss
 * JD-Core Version:    0.7.0.1
 */