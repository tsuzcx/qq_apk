import androidx.annotation.NonNull;

public class beme
{
  private StringBuilder a = new StringBuilder();
  
  public void a(bemg parambemg)
  {
    this.a.append(parambemg.jdField_a_of_type_JavaLangString);
    if (parambemg.b > 0) {
      this.a.append('|').append(belm.a(parambemg.b));
    }
    this.a.append(parambemg.jdField_a_of_type_Char);
    this.a.append(belm.a(parambemg.jdField_a_of_type_Int));
  }
  
  public void c()
  {
    this.a.delete(0, this.a.length());
  }
  
  @NonNull
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beme
 * JD-Core Version:    0.7.0.1
 */