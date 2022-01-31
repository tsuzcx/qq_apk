import android.text.TextUtils;
import org.json.JSONObject;

public class amhc
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static amhc a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    amhc localamhc = new amhc();
    localamhc.a = paramJSONObject.getString("tips");
    localamhc.b = paramJSONObject.getString("buttonText");
    localamhc.c = paramJSONObject.getString("url");
    localamhc.d = paramJSONObject.getString("icon");
    return localamhc;
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
 * Qualified Name:     amhc
 * JD-Core Version:    0.7.0.1
 */