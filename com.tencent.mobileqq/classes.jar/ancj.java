import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ancj
{
  public String a = ajyc.a(2131714821);
  public String b = ajyc.a(2131714828);
  public String c = ajyc.a(2131714824);
  public String d = ajyc.a(2131714826);
  public String e = ajyc.a(2131714819);
  
  public static ancj a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    ancj localancj = new ancj();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].a).optJSONObject("MyFileNameConfig");
      localancj.a = paramArrayOfampi.optString("tdfileTabName");
      localancj.b = paramArrayOfampi.optString("wyfileTabName");
      localancj.c = paramArrayOfampi.optString("tdlistTabviewName");
      localancj.d = paramArrayOfampi.optString("createTXDocTitle");
      localancj.e = paramArrayOfampi.optString("safeShareToastWording");
      return localancj;
    }
    catch (JSONException paramArrayOfampi)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfampi.getLocalizedMessage(), paramArrayOfampi);
    }
    return localancj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ancj
 * JD-Core Version:    0.7.0.1
 */