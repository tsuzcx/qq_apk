import org.json.JSONObject;

public class aonf
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c = 1;
  public int d = -1;
  
  public aonf()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aonf a(JSONObject paramJSONObject)
  {
    aonf localaonf = new aonf();
    localaonf.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("show_c2c_chat_setting", false);
    localaonf.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("show_group_chat_setting", false);
    localaonf.jdField_a_of_type_Int = paramJSONObject.optInt("service_type", -1);
    localaonf.jdField_b_of_type_Int = paramJSONObject.optInt("jumpType", -1);
    localaonf.c = paramJSONObject.optInt("version", -1);
    localaonf.d = paramJSONObject.optInt("appid", -1);
    localaonf.jdField_a_of_type_JavaLangString = paramJSONObject.optString("jumpUrl", "");
    return localaonf;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showC2CChatSetting=").append(this.jdField_a_of_type_Boolean).append(" showGroupChatSetting=").append(this.jdField_b_of_type_Boolean).append(" serviceType=").append(this.jdField_a_of_type_Int).append(" jumpType=").append(this.jdField_b_of_type_Int).append(" version=").append(this.c).append(" appId=").append(this.d).append(" jumpUrl=").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aonf
 * JD-Core Version:    0.7.0.1
 */