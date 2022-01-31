import dov.com.qq.im.ae.mode.AECaptureMode;

public class blfq
  extends bmes
{
  public final bmen<blfi> a;
  private boolean a;
  public final bmen<AECaptureMode[]> b = new bmen();
  
  public blfq()
  {
    this.jdField_a_of_type_Bmen = new bmen();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bmen.a() != null) && (((blfi)this.jdField_a_of_type_Bmen.a()).a == AECaptureMode.GIF);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Bmen.a() != null) && (((blfi)this.jdField_a_of_type_Bmen.a()).a == AECaptureMode.NORMAL);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Bmen.a() != null) && (((blfi)this.jdField_a_of_type_Bmen.a()).a == AECaptureMode.PLAY);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfq
 * JD-Core Version:    0.7.0.1
 */