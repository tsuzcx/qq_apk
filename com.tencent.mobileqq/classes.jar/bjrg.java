import dov.com.qq.im.capture.mode.CaptureModeController;

public abstract class bjrg
  extends bjcl
{
  protected bihg a;
  protected boolean b;
  public boolean c;
  protected boolean d;
  
  public bjrg(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController = paramCaptureModeController;
    this.jdField_a_of_type_Bify = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bify;
    if ((this.jdField_a_of_type_Bify instanceof bihg)) {
      this.jdField_a_of_type_Bihg = ((bihg)this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bify);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjrg
 * JD-Core Version:    0.7.0.1
 */