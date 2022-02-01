import android.text.TextUtils;
import org.json.JSONObject;

public class arkm
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static arkm a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    arkm localarkm = new arkm();
    localarkm.a = paramJSONObject.getString("tips");
    localarkm.b = paramJSONObject.getString("buttonText");
    localarkm.c = paramJSONObject.getString("url");
    localarkm.d = paramJSONObject.getString("icon");
    return localarkm;
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
 * Qualified Name:     arkm
 * JD-Core Version:    0.7.0.1
 */