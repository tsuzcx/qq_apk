public class bchd
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  private String c;
  public int d;
  
  public String a()
  {
    if ((this.jdField_a_of_type_Int & 0x4) == 4) {
      return "classteacher";
    }
    if ((this.jdField_a_of_type_Int & 0x8) == 8) {
      return "teacher";
    }
    if ((this.jdField_a_of_type_Int & 0x1) == 1) {
      return "owner";
    }
    if ((this.jdField_a_of_type_Int & 0x2) == 2) {
      return "admin";
    }
    return "other";
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = bchc.a(paramString, "").trim().replaceAll("\\s+", " ");
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String toString()
  {
    return "KeywordResult{msgId=" + this.jdField_a_of_type_Long + ", troopUin='" + this.jdField_a_of_type_JavaLangString + '\'' + ", userRole=" + this.jdField_a_of_type_Int + ", action=" + this.jdField_b_of_type_Int + ", keyword='" + this.jdField_b_of_type_JavaLangString + '\'' + ", startPos=" + this.jdField_c_of_type_Int + ", endPos=" + this.d + ", content=" + this.jdField_c_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchd
 * JD-Core Version:    0.7.0.1
 */