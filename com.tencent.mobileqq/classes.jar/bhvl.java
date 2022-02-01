import android.graphics.Rect;

public class bhvl
{
  private bhvg jdField_a_of_type_Bhvg;
  private bhvi jdField_a_of_type_Bhvi;
  
  public bhvl(bhvg parambhvg, bhvi parambhvi)
  {
    this.jdField_a_of_type_Bhvg = parambhvg;
    this.jdField_a_of_type_Bhvi = parambhvi;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhvg.a(new bhvm(this));
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bhvi.a(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bhvg.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bhvg.b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bhvg.a(null);
    this.jdField_a_of_type_Bhvi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvl
 * JD-Core Version:    0.7.0.1
 */