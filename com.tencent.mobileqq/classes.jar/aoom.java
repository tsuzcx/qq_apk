import android.text.TextUtils;
import org.json.JSONObject;

public class aoom
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static aoom a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    aoom localaoom = new aoom();
    localaoom.a = paramJSONObject.getString("tips");
    localaoom.b = paramJSONObject.getString("buttonText");
    localaoom.c = paramJSONObject.getString("url");
    localaoom.d = paramJSONObject.getString("icon");
    return localaoom;
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
 * Qualified Name:     aoom
 * JD-Core Version:    0.7.0.1
 */