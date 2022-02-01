import java.util.HashMap;

public class bbkb
  extends bbjz
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public int i;
  public int j = -1;
  public int k = -1;
  public int l = 1001;
  public int m = -1;
  
  public bbkb()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
  }
  
  public HashMap<String, String> a(String paramString)
  {
    if ("ShortVideo.Send".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_DetailUrl", this.jdField_a_of_type_JavaLangString);
      paramString.put("param_uinType", this.jdField_b_of_type_Int + "");
      paramString.put("param_GroupMemberCount", this.c + "");
      paramString.put("param_isForward", this.jdField_a_of_type_Boolean + "");
      paramString.put("param_isExist", this.jdField_b_of_type_Boolean + "");
      paramString.put("param_forwardSourceUinType", this.jdField_a_of_type_Int + "");
      paramString.put("param_forwardSourceGroupMemberCount", this.i + "");
      paramString.put("param_age", this.d + "");
      paramString.put("param_gender", this.e + "");
      paramString.put("param_userType", this.l + "");
      paramString.put("param_shortVideoType", this.f + "");
      paramString.put("param_shortVideoSourceType", this.j + "");
      paramString.put("param_reportHour", this.g + "");
      paramString.put("param_fileInterval", this.k + "");
      paramString.put("param_netType", this.h + "");
      paramString.put("param_md5", this.jdField_b_of_type_JavaLangString);
      paramString.put("param_fileSize", this.jdField_a_of_type_Long + "");
      paramString.put("param_duration", this.jdField_b_of_type_Long + "");
      paramString.put("param_status", this.m + "");
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkb
 * JD-Core Version:    0.7.0.1
 */