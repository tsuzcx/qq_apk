import android.graphics.Rect;

public class bdta
{
  private bdsv jdField_a_of_type_Bdsv;
  private bdsx jdField_a_of_type_Bdsx;
  
  public bdta(bdsv parambdsv, bdsx parambdsx)
  {
    this.jdField_a_of_type_Bdsv = parambdsv;
    this.jdField_a_of_type_Bdsx = parambdsx;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdsv.a(new bdtb(this));
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bdsx.a(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bdsv.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bdsv.b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bdsv.a(null);
    this.jdField_a_of_type_Bdsx.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdta
 * JD-Core Version:    0.7.0.1
 */