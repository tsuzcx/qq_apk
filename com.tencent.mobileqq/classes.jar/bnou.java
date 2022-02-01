import com.tencent.aekit.openrender.internal.Frame;

public class bnou
{
  private int jdField_a_of_type_Int;
  private bnmf jdField_a_of_type_Bnmf = new bnmf();
  private bnov jdField_a_of_type_Bnov;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2)
  {
    Frame localFrame = paramFrame;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bnmf.a(paramFrame, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      localFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    if (this.jdField_a_of_type_Bnov != null) {
      this.jdField_a_of_type_Bnov.a(localFrame);
    }
    return localFrame;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bnmf.apply();
    if (this.jdField_a_of_type_Bnov != null) {
      this.jdField_a_of_type_Bnov.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(bnov parambnov)
  {
    this.jdField_a_of_type_Bnov = parambnov;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bnmf.clearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    if (this.jdField_a_of_type_Bnov != null) {
      this.jdField_a_of_type_Bnov.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnou
 * JD-Core Version:    0.7.0.1
 */