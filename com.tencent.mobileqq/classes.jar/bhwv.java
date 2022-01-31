import com.tencent.aekit.openrender.internal.Frame;

public class bhwv
{
  private int jdField_a_of_type_Int;
  private bhrv jdField_a_of_type_Bhrv = new bhrv();
  private bhww jdField_a_of_type_Bhww;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2)
  {
    Frame localFrame = paramFrame;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bhrv.a(paramFrame, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      localFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    if (this.jdField_a_of_type_Bhww != null) {
      this.jdField_a_of_type_Bhww.a(localFrame);
    }
    return localFrame;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhrv.apply();
    if (this.jdField_a_of_type_Bhww != null) {
      this.jdField_a_of_type_Bhww.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(bhww parambhww)
  {
    this.jdField_a_of_type_Bhww = parambhww;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bhrv.ClearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    if (this.jdField_a_of_type_Bhww != null) {
      this.jdField_a_of_type_Bhww.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhwv
 * JD-Core Version:    0.7.0.1
 */