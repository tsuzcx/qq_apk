import java.lang.reflect.Field;

public final class beqo
{
  public final int a;
  public final String a;
  public final Field a;
  
  public beqo(String paramString, int paramInt, Field paramField)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangReflectField = paramField;
    paramField.setAccessible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqo
 * JD-Core Version:    0.7.0.1
 */