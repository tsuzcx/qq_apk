import java.util.Arrays;

public class bbvs
{
  public int a;
  public long a;
  public bbvx a;
  public String a;
  public boolean a;
  public String[] a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public boolean c;
  public long d;
  
  public boolean a(Object paramObject)
  {
    if (!(paramObject instanceof bbvs)) {}
    do
    {
      do
      {
        return false;
        paramObject = (bbvs)paramObject;
      } while ((paramObject.b != this.b) || (paramObject.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean) || (paramObject.c != this.c));
      if ((paramObject.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    } while ((paramObject.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_a_of_type_ArrayOfJavaLangString == null) || (!Arrays.equals(paramObject.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbvs
 * JD-Core Version:    0.7.0.1
 */