import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class beug
{
  public long a;
  public String a;
  public long b;
  public String b;
  
  beug()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  String a()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("appId", this.jdField_a_of_type_Long);
        localJSONObject.put("appType", this.jdField_b_of_type_Long);
        if (this.jdField_a_of_type_JavaLangString != null) {
          continue;
        }
        str = "";
        localJSONObject.put("appName", str);
        if (this.jdField_b_of_type_JavaLangString != null) {
          continue;
        }
        str = "";
        localJSONObject.put("appJumpUrl", str);
      }
      catch (Exception localException)
      {
        String str;
        continue;
      }
      return localJSONObject.toString();
      str = this.jdField_a_of_type_JavaLangString;
      continue;
      str = this.jdField_b_of_type_JavaLangString;
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Long = paramString.optLong("appId");
      this.jdField_b_of_type_Long = paramString.optLong("appType");
      this.jdField_a_of_type_JavaLangString = paramString.optString("appName");
      this.jdField_b_of_type_JavaLangString = paramString.optString("appJumpUrl");
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId:").append(this.jdField_a_of_type_Long).append(" ");
    localStringBuilder.append("appType:").append(this.jdField_b_of_type_Long).append(" ");
    localStringBuilder.append("appName:").append(this.jdField_a_of_type_JavaLangString).append(" ");
    localStringBuilder.append("appJumpUrl:").append(this.jdField_b_of_type_JavaLangString).append(" ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beug
 * JD-Core Version:    0.7.0.1
 */