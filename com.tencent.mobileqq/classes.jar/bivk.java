import com.tencent.aekit.openrender.internal.Frame;

public class bivk
{
  private int jdField_a_of_type_Int;
  private bisu jdField_a_of_type_Bisu = new bisu();
  private bivl jdField_a_of_type_Bivl;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2)
  {
    Frame localFrame = paramFrame;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bisu.a(paramFrame, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      localFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    if (this.jdField_a_of_type_Bivl != null) {
      this.jdField_a_of_type_Bivl.a(localFrame);
    }
    return localFrame;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bisu.apply();
    if (this.jdField_a_of_type_Bivl != null) {
      this.jdField_a_of_type_Bivl.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(bivl parambivl)
  {
    this.jdField_a_of_type_Bivl = parambivl;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bisu.ClearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    if (this.jdField_a_of_type_Bivl != null) {
      this.jdField_a_of_type_Bivl.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivk
 * JD-Core Version:    0.7.0.1
 */