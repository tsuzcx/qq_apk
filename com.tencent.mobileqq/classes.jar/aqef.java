import android.text.TextUtils;
import org.json.JSONObject;

public class aqef
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static aqef a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    aqef localaqef = new aqef();
    localaqef.a = paramJSONObject.getString("tips");
    localaqef.b = paramJSONObject.getString("buttonText");
    localaqef.c = paramJSONObject.getString("url");
    localaqef.d = paramJSONObject.getString("icon");
    return localaqef;
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
 * Qualified Name:     aqef
 * JD-Core Version:    0.7.0.1
 */