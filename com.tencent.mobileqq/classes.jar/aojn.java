import android.app.Activity;
import android.text.TextUtils;
import org.json.JSONObject;

public class aojn
  extends aojk
{
  private String b;
  
  public aojn(Activity paramActivity, String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4)
  {
    super(paramActivity, paramString1, paramString2, paramLong, paramString3, paramInt);
    this.b = paramString4;
  }
  
  private boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (a() == 1);
  }
  
  protected String f()
  {
    String str2 = aojq.a().a(this.b);
    String str1 = str2;
    if (a(str2)) {
      str1 = super.f();
    }
    return str1;
  }
  
  protected String g()
  {
    String str2 = aojq.a().a(this.b);
    String str1 = str2;
    if (a(str2)) {
      str1 = super.g();
    }
    return str1;
  }
  
  protected String h()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", "result");
    localJSONObject2.put("gameType", a());
    JSONObject localJSONObject3 = new JSONObject();
    localJSONObject3.put("jump_url", a());
    String str2 = aojq.a().a(this.b);
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
 * Qualified Name:     aojn
 * JD-Core Version:    0.7.0.1
 */