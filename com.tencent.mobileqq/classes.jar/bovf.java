import com.tencent.aekit.openrender.internal.Frame;

public class bovf
{
  private int jdField_a_of_type_Int;
  private bosq jdField_a_of_type_Bosq = new bosq();
  private bovg jdField_a_of_type_Bovg;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2)
  {
    Frame localFrame = paramFrame;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bosq.a(paramFrame, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      localFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    if (this.jdField_a_of_type_Bovg != null) {
      this.jdField_a_of_type_Bovg.a(localFrame);
    }
    return localFrame;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bosq.apply();
    if (this.jdField_a_of_type_Bovg != null) {
      this.jdField_a_of_type_Bovg.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(bovg parambovg)
  {
    this.jdField_a_of_type_Bovg = parambovg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bosq.ClearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    if (this.jdField_a_of_type_Bovg != null) {
      this.jdField_a_of_type_Bovg.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bovf
 * JD-Core Version:    0.7.0.1
 */