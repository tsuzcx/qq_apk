import org.json.JSONObject;

public class awgo
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static awgo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    awgo localawgo = new awgo();
    localawgo.a = paramJSONObject.optString("name");
    localawgo.b = new String(bfuc.decode(paramJSONObject.optString("iconUrl"), 0));
    localawgo.c = paramJSONObject.optString("accessibilityText");
    localawgo.d = paramJSONObject.optString("ruleWording");
    return localawgo;
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
 * Qualified Name:     awgo
 * JD-Core Version:    0.7.0.1
 */