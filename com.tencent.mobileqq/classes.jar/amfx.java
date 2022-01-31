import org.json.JSONObject;

public class amfx
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c = 1;
  public int d = -1;
  
  public amfx()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static amfx a(JSONObject paramJSONObject)
  {
    amfx localamfx = new amfx();
    localamfx.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("show_c2c_chat_setting", false);
    localamfx.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("show_group_chat_setting", false);
    localamfx.jdField_a_of_type_Int = paramJSONObject.optInt("service_type", -1);
    localamfx.jdField_b_of_type_Int = paramJSONObject.optInt("jumpType", -1);
    localamfx.c = paramJSONObject.optInt("version", -1);
    localamfx.d = paramJSONObject.optInt("appid", -1);
    localamfx.jdField_a_of_type_JavaLangString = paramJSONObject.optString("jumpUrl", "");
    return localamfx;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showC2CChatSetting=").append(this.jdField_a_of_type_Boolean).append(" showGroupChatSetting=").append(this.jdField_b_of_type_Boolean).append(" serviceType=").append(this.jdField_a_of_type_Int).append(" jumpType=").append(this.jdField_b_of_type_Int).append(" version=").append(this.c).append(" appId=").append(this.d).append(" jumpUrl=").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfx
 * JD-Core Version:    0.7.0.1
 */