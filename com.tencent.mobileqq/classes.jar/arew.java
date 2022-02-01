public class arew
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public arew(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString1.substring(paramString1.lastIndexOf("/") + 1);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arew
 * JD-Core Version:    0.7.0.1
 */