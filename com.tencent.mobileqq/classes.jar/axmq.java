import org.json.JSONObject;

public class axmq
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static axmq a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    axmq localaxmq = new axmq();
    localaxmq.a = paramJSONObject.optString("name");
    localaxmq.b = new String(bhcu.decode(paramJSONObject.optString("iconUrl"), 0));
    localaxmq.c = paramJSONObject.optString("accessibilityText");
    localaxmq.d = paramJSONObject.optString("ruleWording");
    return localaxmq;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=").append(this.a).append("|");
    localStringBuilder.append("iconUrl=").append(this.b).append("|");
    localStringBuilder.append("accessibilityText=").append(this.c).append("|");
    localStringBuilder.append("ruleWording=").append(this.d).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axmq
 * JD-Core Version:    0.7.0.1
 */