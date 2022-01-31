import android.graphics.Rect;

public class bdxj
{
  private bdxe jdField_a_of_type_Bdxe;
  private bdxg jdField_a_of_type_Bdxg;
  
  public bdxj(bdxe parambdxe, bdxg parambdxg)
  {
    this.jdField_a_of_type_Bdxe = parambdxe;
    this.jdField_a_of_type_Bdxg = parambdxg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdxe.a(new bdxk(this));
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bdxg.a(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bdxe.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bdxe.b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bdxe.a(null);
    this.jdField_a_of_type_Bdxg.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxj
 * JD-Core Version:    0.7.0.1
 */