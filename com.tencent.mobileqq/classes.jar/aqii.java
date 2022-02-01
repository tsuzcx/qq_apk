import org.json.JSONObject;

class aqii
{
  String a = "";
  String b = "";
  String c = "";
  
  static aqii a(JSONObject paramJSONObject)
  {
    aqii localaqii = new aqii();
    localaqii.a = paramJSONObject.optString("nonVIP", localaqii.a);
    localaqii.b = paramJSONObject.optString("VIP", localaqii.b);
    localaqii.c = paramJSONObject.optString("SVIP", localaqii.c);
    return localaqii;
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
 * Qualified Name:     aqii
 * JD-Core Version:    0.7.0.1
 */