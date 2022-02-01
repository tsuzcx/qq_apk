import org.json.JSONObject;

class arok
{
  String a = "";
  String b = "";
  String c = "";
  
  static arok a(JSONObject paramJSONObject)
  {
    arok localarok = new arok();
    localarok.a = paramJSONObject.optString("nonVIP", localarok.a);
    localarok.b = paramJSONObject.optString("VIP", localarok.b);
    localarok.c = paramJSONObject.optString("SVIP", localarok.c);
    return localarok;
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
 * Qualified Name:     arok
 * JD-Core Version:    0.7.0.1
 */