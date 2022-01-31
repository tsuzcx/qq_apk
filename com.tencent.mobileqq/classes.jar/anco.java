import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anco
{
  public String a = ajya.a(2131714832);
  public String b = ajya.a(2131714839);
  public String c = ajya.a(2131714835);
  public String d = ajya.a(2131714837);
  public String e = ajya.a(2131714830);
  
  public static anco a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    anco localanco = new anco();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].a).optJSONObject("MyFileNameConfig");
      localanco.a = paramArrayOfamph.optString("tdfileTabName");
      localanco.b = paramArrayOfamph.optString("wyfileTabName");
      localanco.c = paramArrayOfamph.optString("tdlistTabviewName");
      localanco.d = paramArrayOfamph.optString("createTXDocTitle");
      localanco.e = paramArrayOfamph.optString("safeShareToastWording");
      return localanco;
    }
    catch (JSONException paramArrayOfamph)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfamph.getLocalizedMessage(), paramArrayOfamph);
    }
    return localanco;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anco
 * JD-Core Version:    0.7.0.1
 */