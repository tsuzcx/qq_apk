public class bfoo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  
  public bfoo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while ((!(paramObject instanceof bfoo)) || (((bfoo)paramObject).jdField_b_of_type_Long != this.jdField_b_of_type_Long)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "TroopAppInfo{app_showtype='" + this.jdField_a_of_type_Int + '\'' + ", app_type='" + this.jdField_a_of_type_Long + '\'' + ", app_appid='" + this.jdField_b_of_type_Long + '\'' + ", app_removable='" + this.jdField_b_of_type_Int + '\'' + ", app_source='" + this.jdField_c_of_type_Int + '\'' + ", app_name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", app_icon='" + this.jdField_b_of_type_JavaLangString + '\'' + ", app_url='" + this.jdField_c_of_type_JavaLangString + '\'' + ", app_desc='" + this.jdField_d_of_type_JavaLangString + '\'' + ", app_added='" + this.jdField_a_of_type_Boolean + '\'' + ", appTrace='" + this.jdField_e_of_type_JavaLangString + '\'' + ", appShowFrame='" + this.jdField_d_of_type_Int + '\'' + ", appPlayingNum='" + this.jdField_e_of_type_Int + '\'' + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfoo
 * JD-Core Version:    0.7.0.1
 */