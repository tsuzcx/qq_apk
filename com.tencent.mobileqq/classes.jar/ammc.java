import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ammc
{
  public String a = ajjy.a(2131649032);
  public String b = ajjy.a(2131649039);
  public String c = ajjy.a(2131649035);
  public String d = ajjy.a(2131649037);
  public String e = ajjy.a(2131649030);
  
  public static ammc a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    ammc localammc = new ammc();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].a).optJSONObject("MyFileNameConfig");
      localammc.a = paramArrayOfalzs.optString("tdfileTabName");
      localammc.b = paramArrayOfalzs.optString("wyfileTabName");
      localammc.c = paramArrayOfalzs.optString("tdlistTabviewName");
      localammc.d = paramArrayOfalzs.optString("createTXDocTitle");
      localammc.e = paramArrayOfalzs.optString("safeShareToastWording");
      return localammc;
    }
    catch (JSONException paramArrayOfalzs)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfalzs.getLocalizedMessage(), paramArrayOfalzs);
    }
    return localammc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ammc
 * JD-Core Version:    0.7.0.1
 */