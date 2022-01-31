import com.tencent.aekit.openrender.internal.Frame;

public class blae
{
  private int jdField_a_of_type_Int;
  private bkxn jdField_a_of_type_Bkxn = new bkxn();
  private blaf jdField_a_of_type_Blaf;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2)
  {
    Frame localFrame = paramFrame;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bkxn.a(paramFrame, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      localFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    if (this.jdField_a_of_type_Blaf != null) {
      this.jdField_a_of_type_Blaf.a(localFrame);
    }
    return localFrame;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkxn.apply();
    if (this.jdField_a_of_type_Blaf != null) {
      this.jdField_a_of_type_Blaf.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(blaf paramblaf)
  {
    this.jdField_a_of_type_Blaf = paramblaf;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bkxn.ClearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    if (this.jdField_a_of_type_Blaf != null) {
      this.jdField_a_of_type_Blaf.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blae
 * JD-Core Version:    0.7.0.1
 */