public class bhjs
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c;
  
  public bhjs(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.c = bhjt.a(paramString);
  }
  
  public bhjs(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = bhjt.a(paramString);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "QQCustomMenuItem{title='" + this.jdField_a_of_type_JavaLangString + '\'' + ", special=" + this.jdField_a_of_type_Boolean + ", priority=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjs
 * JD-Core Version:    0.7.0.1
 */