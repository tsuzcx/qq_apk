import org.json.JSONObject;

public class argc
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c = 1;
  public int d = -1;
  
  public argc()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static argc a(JSONObject paramJSONObject)
  {
    argc localargc = new argc();
    localargc.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("show_c2c_chat_setting", false);
    localargc.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("show_group_chat_setting", false);
    localargc.jdField_a_of_type_Int = paramJSONObject.optInt("service_type", -1);
    localargc.jdField_b_of_type_Int = paramJSONObject.optInt("jumpType", -1);
    localargc.c = paramJSONObject.optInt("version", -1);
    localargc.d = paramJSONObject.optInt("appid", -1);
    localargc.jdField_a_of_type_JavaLangString = paramJSONObject.optString("jumpUrl", "");
    return localargc;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showC2CChatSetting=").append(this.jdField_a_of_type_Boolean).append(" showGroupChatSetting=").append(this.jdField_b_of_type_Boolean).append(" serviceType=").append(this.jdField_a_of_type_Int).append(" jumpType=").append(this.jdField_b_of_type_Int).append(" version=").append(this.c).append(" appId=").append(this.d).append(" jumpUrl=").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argc
 * JD-Core Version:    0.7.0.1
 */