import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aroc
{
  public String a = anvx.a(2131714204);
  public String b = anvx.a(2131714211);
  public String c = anvx.a(2131714207);
  public String d = anvx.a(2131714209);
  public String e = anvx.a(2131714202);
  
  public static aroc a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    aroc localaroc = new aroc();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].a).optJSONObject("MyFileNameConfig");
      localaroc.a = paramArrayOfaqxa.optString("tdfileTabName");
      localaroc.b = paramArrayOfaqxa.optString("wyfileTabName");
      localaroc.c = paramArrayOfaqxa.optString("tdlistTabviewName");
      localaroc.d = paramArrayOfaqxa.optString("createTXDocTitle");
      localaroc.e = paramArrayOfaqxa.optString("safeShareToastWording");
      return localaroc;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfaqxa.getLocalizedMessage(), paramArrayOfaqxa);
    }
    return localaroc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aroc
 * JD-Core Version:    0.7.0.1
 */