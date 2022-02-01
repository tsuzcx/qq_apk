import android.graphics.Rect;

public class bieq
{
  private biel jdField_a_of_type_Biel;
  private bien jdField_a_of_type_Bien;
  
  public bieq(biel parambiel, bien parambien)
  {
    this.jdField_a_of_type_Biel = parambiel;
    this.jdField_a_of_type_Bien = parambien;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Biel.a(new bier(this));
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bien.a(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Biel.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Biel.b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Biel.a(null);
    this.jdField_a_of_type_Bien.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bieq
 * JD-Core Version:    0.7.0.1
 */