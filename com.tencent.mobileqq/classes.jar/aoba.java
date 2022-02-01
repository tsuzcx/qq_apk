import android.app.Activity;
import android.text.TextUtils;
import org.json.JSONObject;

public class aoba
  extends aoay
{
  private String b;
  
  public aoba(Activity paramActivity, String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4)
  {
    super(paramActivity, paramString1, paramString2, paramLong, paramString3, paramInt);
    this.b = paramString4;
  }
  
  private boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (a() == 1);
  }
  
  protected String d()
  {
    String str2 = aobd.a().a(this.b);
    String str1 = str2;
    if (a(str2)) {
      str1 = super.d();
    }
    return str1;
  }
  
  protected String e()
  {
    String str2 = aobd.a().a(this.b);
    String str1 = str2;
    if (a(str2)) {
      str1 = super.e();
    }
    return str1;
  }
  
  protected String f()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", "result");
    localJSONObject2.put("gameType", a());
    JSONObject localJSONObject3 = new JSONObject();
    localJSONObject3.put("jump_url", a());
    String str2 = aobd.a().a(this.b);
    String str1 = str2;
    if (a(str2)) {
      str1 = "https://qqvgame.qq.com/d55d788cc3c423807d830230aad935b2.png";
    }
    localJSONObject3.put("icon_url", str1);
    localJSONObject2.put("extra", localJSONObject3);
    localJSONObject1.put("invite", localJSONObject2);
    return localJSONObject1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoba
 * JD-Core Version:    0.7.0.1
 */