import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class bemg
{
  char jdField_a_of_type_Char;
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString = "";
  int b;
  
  void a()
  {
    this.jdField_a_of_type_Char = '\000';
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof bemg)) {
        return false;
      }
      paramObject = (bemg)paramObject;
    } while ((this.jdField_a_of_type_Char == paramObject.jdField_a_of_type_Char) && (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b) && ((this.jdField_a_of_type_JavaLangString == paramObject.jdField_a_of_type_JavaLangString) || ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)))));
    return false;
  }
  
  @NonNull
  public String toString()
  {
    return "[opcode=" + this.jdField_a_of_type_Char + ", chars=" + this.jdField_a_of_type_Int + ",lines=" + this.b + ", attribs=" + this.jdField_a_of_type_JavaLangString + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemg
 * JD-Core Version:    0.7.0.1
 */