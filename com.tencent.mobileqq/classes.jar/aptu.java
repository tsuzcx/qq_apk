import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

public class aptu
  implements aptt
{
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {
      return false;
    }
    paramString2 = BaseActivity.sTopActivity;
    if (paramString2 == null) {
      return false;
    }
    if (paramString1.startsWith("open/")) {
      try
      {
        int j = Integer.parseInt(paramString1.substring("open/".length(), paramString1.indexOf("?")));
        paramJSONObject = (String)bkyp.a(paramString1).get("url");
        int i = j;
        if (!MiniAppLauncher.verifyArkScene(j)) {
          i = 2059;
        }
        MiniAppLauncher.startMiniApp(paramString2, paramJSONObject, i, aptq.a(), null);
        return true;
      }
      catch (Exception paramString2)
      {
        QLog.e("ArkApp", 1, "parse miniapp scheme failed:" + paramString1, paramString2);
        return false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptu
 * JD-Core Version:    0.7.0.1
 */