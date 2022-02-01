import org.json.JSONObject;

class arls
{
  String a = "";
  String b = "";
  String c = "";
  
  static arls a(JSONObject paramJSONObject)
  {
    arls localarls = new arls();
    localarls.a = paramJSONObject.optString("nonVIP", localarls.a);
    localarls.b = paramJSONObject.optString("VIP", localarls.b);
    localarls.c = paramJSONObject.optString("SVIP", localarls.c);
    return localarls;
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
 * Qualified Name:     arls
 * JD-Core Version:    0.7.0.1
 */