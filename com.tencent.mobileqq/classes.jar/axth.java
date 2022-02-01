import org.json.JSONObject;

public class axth
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static axth a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    axth localaxth = new axth();
    localaxth.a = paramJSONObject.optString("name");
    localaxth.b = new String(bhkv.decode(paramJSONObject.optString("iconUrl"), 0));
    localaxth.c = paramJSONObject.optString("accessibilityText");
    localaxth.d = paramJSONObject.optString("ruleWording");
    return localaxth;
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
 * Qualified Name:     axth
 * JD-Core Version:    0.7.0.1
 */