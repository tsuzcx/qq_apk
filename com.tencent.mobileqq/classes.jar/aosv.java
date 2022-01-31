import android.text.TextUtils;
import org.json.JSONObject;

public class aosv
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static aosv a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    aosv localaosv = new aosv();
    localaosv.a = paramJSONObject.getString("tips");
    localaosv.b = paramJSONObject.getString("buttonText");
    localaosv.c = paramJSONObject.getString("url");
    localaosv.d = paramJSONObject.getString("icon");
    return localaosv;
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
 * Qualified Name:     aosv
 * JD-Core Version:    0.7.0.1
 */