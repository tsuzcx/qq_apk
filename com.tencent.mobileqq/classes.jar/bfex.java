import android.text.TextUtils;
import org.json.JSONObject;

public class bfex
{
  public String a;
  public String b;
  public String c;
  
  public void a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("left");
    this.b = paramJSONObject.optString("text");
    this.c = paramJSONObject.optString("right");
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfex
 * JD-Core Version:    0.7.0.1
 */