import java.util.ArrayList;

public class aswb
{
  public int a;
  public long a;
  public String a;
  public ArrayList<asxf> a;
  public int b;
  public String b;
  public ArrayList<asxg> b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j = "";
  public String k = "";
  
  public aswb()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{friendUin: ").append(this.jdField_a_of_type_JavaLangString).append("}");
    localStringBuilder.append("{age: ").append(this.jdField_b_of_type_JavaLangString).append("}");
    localStringBuilder.append("{constellation: ").append(this.jdField_c_of_type_JavaLangString).append("}");
    localStringBuilder.append("{city: ").append(this.jdField_d_of_type_JavaLangString).append("}");
    localStringBuilder.append("{school: ").append(this.e).append("}");
    localStringBuilder.append("{constel:").append(this.jdField_c_of_type_JavaLangString).append("}");
    localStringBuilder.append("{company:").append(this.f).append("}");
    localStringBuilder.append("{mGender: ").append(this.jdField_a_of_type_Int).append("}");
    localStringBuilder.append("{mDeclaration: ").append(this.g).append("}");
    localStringBuilder.append("{mVoiceUrl: ").append(this.h).append("}");
    localStringBuilder.append("{mVoiceDuration: ").append(this.jdField_b_of_type_Int).append("}");
    localStringBuilder.append("{signWords: ").append(this.i).append("}");
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      localStringBuilder.append("{personalTags: is empty ").append("}");
      localStringBuilder.append("{popular: ").append(this.jdField_a_of_type_Long).append("}");
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        break label399;
      }
      localStringBuilder.append("{schoolInfo: is empty ").append("}");
    }
    for (;;)
    {
      localStringBuilder.append("{distance: ").append(this.jdField_c_of_type_Int).append("}");
      localStringBuilder.append("{signalBombMatchPool: ").append(this.jdField_d_of_type_Int).append("}");
      localStringBuilder.append("{strFromCity: ").append(this.j).append("}");
      localStringBuilder.append("{strToCity: ").append(this.k).append("}");
      return localStringBuilder.toString();
      localStringBuilder.append("{personalTags:size  ").append(this.jdField_a_of_type_JavaUtilArrayList.size()).append("}");
      break;
      label399:
      localStringBuilder.append("{schoolInfo:size  ").append(this.jdField_b_of_type_JavaUtilArrayList.size()).append("}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswb
 * JD-Core Version:    0.7.0.1
 */