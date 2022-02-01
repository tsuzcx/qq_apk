import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import org.json.JSONObject;

public class apxi
  implements apxf
{
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {}
    do
    {
      return false;
      paramJSONObject = BaseActivity.sTopActivity;
    } while (paramJSONObject == null);
    paramString3 = new Intent(paramJSONObject, TranslucentActivity.class);
    paramString3.addFlags(268435456);
    QzonePluginProxyActivity.a(paramString3, "com.qzone.misc.web.QZoneTranslucentActivity");
    paramString3.setAction("action_js2qzone");
    paramString3.putExtra("cmd", "Schema");
    paramString2 = paramString1;
    if (paramString1.startsWith("arouse/detailbyurl?base64url"))
    {
      paramString2 = paramString1;
      if (!paramString1.contains("from")) {
        paramString2 = paramString1 + "&from=aio";
      }
    }
    paramString3.putExtra("schema", "mqzone://" + paramString2);
    paramString3.putExtra("from", 2);
    paramJSONObject.startActivity(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxi
 * JD-Core Version:    0.7.0.1
 */