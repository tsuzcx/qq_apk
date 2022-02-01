import android.graphics.Rect;

public class bhef
{
  private bhea jdField_a_of_type_Bhea;
  private bhec jdField_a_of_type_Bhec;
  
  public bhef(bhea parambhea, bhec parambhec)
  {
    this.jdField_a_of_type_Bhea = parambhea;
    this.jdField_a_of_type_Bhec = parambhec;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhea.a(new bheg(this));
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bhec.a(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bhea.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bhea.b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bhea.a(null);
    this.jdField_a_of_type_Bhec.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhef
 * JD-Core Version:    0.7.0.1
 */