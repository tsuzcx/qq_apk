import org.json.JSONObject;

class aqyt
{
  String a = "";
  String b = "";
  String c = "";
  
  static aqyt a(JSONObject paramJSONObject)
  {
    aqyt localaqyt = new aqyt();
    localaqyt.a = paramJSONObject.optString("nonVIP", localaqyt.a);
    localaqyt.b = paramJSONObject.optString("VIP", localaqyt.b);
    localaqyt.c = paramJSONObject.optString("SVIP", localaqyt.c);
    return localaqyt;
  }
  
  String a(String paramString)
  {
    if ("normal".equals(paramString)) {
      return this.a;
    }
    if ("vip".equals(paramString)) {
      return this.b;
    }
    return this.c;
  }
  
  public String toString()
  {
    return "Info{nonVIP='" + this.a + '\'' + ", VIP='" + this.b + '\'' + ", SVIP='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyt
 * JD-Core Version:    0.7.0.1
 */