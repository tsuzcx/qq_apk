import android.text.TextUtils;
import org.json.JSONObject;

public class aqva
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static aqva a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    aqva localaqva = new aqva();
    localaqva.a = paramJSONObject.getString("tips");
    localaqva.b = paramJSONObject.getString("buttonText");
    localaqva.c = paramJSONObject.getString("url");
    localaqva.d = paramJSONObject.getString("icon");
    return localaqva;
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
 * Qualified Name:     aqva
 * JD-Core Version:    0.7.0.1
 */