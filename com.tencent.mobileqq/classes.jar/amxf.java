import android.text.TextUtils;
import org.json.JSONObject;

public class amxf
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static amxf a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    amxf localamxf = new amxf();
    localamxf.a = paramJSONObject.getString("tips");
    localamxf.b = paramJSONObject.getString("buttonText");
    localamxf.c = paramJSONObject.getString("url");
    localamxf.d = paramJSONObject.getString("icon");
    return localamxf;
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
 * Qualified Name:     amxf
 * JD-Core Version:    0.7.0.1
 */