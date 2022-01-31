import java.util.ArrayList;

public class anor
{
  public String a;
  public ArrayList<String> a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{friendUin: ").append(this.jdField_a_of_type_JavaLangString).append("}");
    localStringBuilder.append("{age: ").append(this.b).append("}");
    localStringBuilder.append("{constellation: ").append(this.c).append("}");
    localStringBuilder.append("{city: ").append(this.d).append("}");
    localStringBuilder.append("{school: ").append(this.e).append("}");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      localStringBuilder.append("{personalTags: is empty ").append("}");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{personalTags:size  ").append(this.jdField_a_of_type_JavaUtilArrayList.size()).append("}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anor
 * JD-Core Version:    0.7.0.1
 */