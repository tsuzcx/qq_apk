import androidx.annotation.NonNull;

public class belk
{
  private StringBuilder a = new StringBuilder();
  
  public void a(belm parambelm)
  {
    this.a.append(parambelm.jdField_a_of_type_JavaLangString);
    if (parambelm.b > 0) {
      this.a.append('|').append(beks.a(parambelm.b));
    }
    this.a.append(parambelm.jdField_a_of_type_Char);
    this.a.append(beks.a(parambelm.jdField_a_of_type_Int));
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
 * Qualified Name:     belk
 * JD-Core Version:    0.7.0.1
 */