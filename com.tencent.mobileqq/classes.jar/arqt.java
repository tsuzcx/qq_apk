import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arqt
{
  public String a = anzj.a(2131713625);
  public String b = anzj.a(2131713632);
  public String c = anzj.a(2131713628);
  public String d = anzj.a(2131713630);
  public String e = anzj.a(2131713623);
  
  public static arqt a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    arqt localarqt = new arqt();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].a).optJSONObject("MyFileNameConfig");
      localarqt.a = paramArrayOfaraj.optString("tdfileTabName");
      localarqt.b = paramArrayOfaraj.optString("wyfileTabName");
      localarqt.c = paramArrayOfaraj.optString("tdlistTabviewName");
      localarqt.d = paramArrayOfaraj.optString("createTXDocTitle");
      localarqt.e = paramArrayOfaraj.optString("safeShareToastWording");
      return localarqt;
    }
    catch (JSONException paramArrayOfaraj)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfaraj.getLocalizedMessage(), paramArrayOfaraj);
    }
    return localarqt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arqt
 * JD-Core Version:    0.7.0.1
 */