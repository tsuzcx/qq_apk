import android.text.TextUtils;
import org.json.JSONObject;

public class amxg
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static amxg a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    amxg localamxg = new amxg();
    localamxg.a = paramJSONObject.getString("tips");
    localamxg.b = paramJSONObject.getString("buttonText");
    localamxg.c = paramJSONObject.getString("url");
    localamxg.d = paramJSONObject.getString("icon");
    return localamxg;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean a()
  {
    return (TextUtils.isEmpty(this.a)) && (TextUtils.isEmpty(this.b)) && (TextUtils.isEmpty(this.c)) && (TextUtils.isEmpty(this.d));
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxg
 * JD-Core Version:    0.7.0.1
 */