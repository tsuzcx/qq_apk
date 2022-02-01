import android.graphics.Rect;

public class bglb
{
  private bgkw jdField_a_of_type_Bgkw;
  private bgky jdField_a_of_type_Bgky;
  
  public bglb(bgkw parambgkw, bgky parambgky)
  {
    this.jdField_a_of_type_Bgkw = parambgkw;
    this.jdField_a_of_type_Bgky = parambgky;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bgkw.a(new bglc(this));
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bgky.a(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bgkw.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bgkw.b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bgkw.a(null);
    this.jdField_a_of_type_Bgky.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglb
 * JD-Core Version:    0.7.0.1
 */