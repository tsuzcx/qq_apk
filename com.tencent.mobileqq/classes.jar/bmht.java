import dov.com.qq.im.capture.mode.CaptureModeController;

public abstract class bmht
  extends blsz
{
  protected bkoa a;
  protected boolean b;
  public boolean c;
  protected boolean d;
  
  public bmht(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController = paramCaptureModeController;
    this.jdField_a_of_type_Bkms = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bkms;
    if ((this.jdField_a_of_type_Bkms instanceof bkoa)) {
      this.jdField_a_of_type_Bkoa = ((bkoa)this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bkms);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Boolean);
      return;
    }
    b();
  }
  
  public void b()
  {
    this.b = false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = true;
    this.c = false;
    this.d = paramBoolean;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    this.c = true;
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmht
 * JD-Core Version:    0.7.0.1
 */