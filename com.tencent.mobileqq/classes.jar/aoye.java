import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoye
{
  public String a = alud.a(2131715216);
  public String b = alud.a(2131715223);
  public String c = alud.a(2131715219);
  public String d = alud.a(2131715221);
  public String e = alud.a(2131715214);
  
  public static aoye a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    aoye localaoye = new aoye();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].a).optJSONObject("MyFileNameConfig");
      localaoye.a = paramArrayOfaoko.optString("tdfileTabName");
      localaoye.b = paramArrayOfaoko.optString("wyfileTabName");
      localaoye.c = paramArrayOfaoko.optString("tdlistTabviewName");
      localaoye.d = paramArrayOfaoko.optString("createTXDocTitle");
      localaoye.e = paramArrayOfaoko.optString("safeShareToastWording");
      return localaoye;
    }
    catch (JSONException paramArrayOfaoko)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfaoko.getLocalizedMessage(), paramArrayOfaoko);
    }
    return localaoye;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoye
 * JD-Core Version:    0.7.0.1
 */