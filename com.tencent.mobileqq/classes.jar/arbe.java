import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arbe
{
  public String a = anni.a(2131713516);
  public String b = anni.a(2131713523);
  public String c = anni.a(2131713519);
  public String d = anni.a(2131713521);
  public String e = anni.a(2131713514);
  
  public static arbe a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    arbe localarbe = new arbe();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].a).optJSONObject("MyFileNameConfig");
      localarbe.a = paramArrayOfaqlg.optString("tdfileTabName");
      localarbe.b = paramArrayOfaqlg.optString("wyfileTabName");
      localarbe.c = paramArrayOfaqlg.optString("tdlistTabviewName");
      localarbe.d = paramArrayOfaqlg.optString("createTXDocTitle");
      localarbe.e = paramArrayOfaqlg.optString("safeShareToastWording");
      return localarbe;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfaqlg.getLocalizedMessage(), paramArrayOfaqlg);
    }
    return localarbe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbe
 * JD-Core Version:    0.7.0.1
 */