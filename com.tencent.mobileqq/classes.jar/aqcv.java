import org.json.JSONObject;

public class aqcv
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c = 1;
  public int d = -1;
  
  public aqcv()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aqcv a(JSONObject paramJSONObject)
  {
    aqcv localaqcv = new aqcv();
    localaqcv.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("show_c2c_chat_setting", false);
    localaqcv.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("show_group_chat_setting", false);
    localaqcv.jdField_a_of_type_Int = paramJSONObject.optInt("service_type", -1);
    localaqcv.jdField_b_of_type_Int = paramJSONObject.optInt("jumpType", -1);
    localaqcv.c = paramJSONObject.optInt("version", -1);
    localaqcv.d = paramJSONObject.optInt("appid", -1);
    localaqcv.jdField_a_of_type_JavaLangString = paramJSONObject.optString("jumpUrl", "");
    return localaqcv;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showC2CChatSetting=").append(this.jdField_a_of_type_Boolean).append(" showGroupChatSetting=").append(this.jdField_b_of_type_Boolean).append(" serviceType=").append(this.jdField_a_of_type_Int).append(" jumpType=").append(this.jdField_b_of_type_Int).append(" version=").append(this.c).append(" appId=").append(this.d).append(" jumpUrl=").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqcv
 * JD-Core Version:    0.7.0.1
 */