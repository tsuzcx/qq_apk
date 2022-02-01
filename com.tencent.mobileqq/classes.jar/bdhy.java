import androidx.annotation.NonNull;

public class bdhy
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c = -1;
  public boolean c;
  public int d;
  
  public bdhy() {}
  
  public bdhy(bdhy parambdhy)
  {
    this.jdField_a_of_type_JavaLangString = parambdhy.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = parambdhy.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Int = parambdhy.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = parambdhy.jdField_b_of_type_Int;
    this.jdField_a_of_type_Boolean = parambdhy.jdField_a_of_type_Boolean;
    this.c = parambdhy.c;
    this.d = parambdhy.d;
    this.jdField_b_of_type_Boolean = parambdhy.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Float = parambdhy.jdField_a_of_type_Float;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_a_of_type_Int).append(",").append(this.jdField_a_of_type_Boolean).append(",").append(this.c).append(",").append(this.jdField_b_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhy
 * JD-Core Version:    0.7.0.1
 */