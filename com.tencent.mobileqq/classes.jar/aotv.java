import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aotv
{
  public String a = alpo.a(2131715204);
  public String b = alpo.a(2131715211);
  public String c = alpo.a(2131715207);
  public String d = alpo.a(2131715209);
  public String e = alpo.a(2131715202);
  
  public static aotv a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aotv localaotv = new aotv();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].a).optJSONObject("MyFileNameConfig");
      localaotv.a = paramArrayOfaogf.optString("tdfileTabName");
      localaotv.b = paramArrayOfaogf.optString("wyfileTabName");
      localaotv.c = paramArrayOfaogf.optString("tdlistTabviewName");
      localaotv.d = paramArrayOfaogf.optString("createTXDocTitle");
      localaotv.e = paramArrayOfaogf.optString("safeShareToastWording");
      return localaotv;
    }
    catch (JSONException paramArrayOfaogf)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfaogf.getLocalizedMessage(), paramArrayOfaogf);
    }
    return localaotv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aotv
 * JD-Core Version:    0.7.0.1
 */